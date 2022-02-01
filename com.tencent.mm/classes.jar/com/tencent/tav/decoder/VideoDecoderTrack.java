package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.ExtractorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoDecoderTrack
  implements IDecoderTrack
{
  public static boolean LOG_VERBOSE = false;
  public static boolean PRE_READ = true;
  private static String TAG = "VDecoderTrack";
  private Surface _outputSurface;
  private float _speed;
  private IVideoDecoder currentDecoder;
  private final Object currentDecoderLock;
  private CMSampleBuffer currentFrame;
  private CMTime currentSegmentStartTime;
  private IDecoder.DecodeType decodeType;
  private DecoderCreateThread decoderCreateThread;
  private final DecoderThread decoderThread;
  private CMTime duration;
  private CMTime frameDuration;
  private int frameRate;
  private boolean isReleased;
  private CMSampleState lastSampleState;
  private DecoderWrapper nextDecoder;
  private final Object nextDecoderLock;
  private CMSampleBuffer nextFrame;
  private final Object nextFrameDecoderLock;
  private int segmentIndex;
  private ArrayList<DecoderTrackSegment> segments;
  private boolean started;
  private IDecoderTrack.SurfaceCreator surfaceCreator;
  private int trackId;
  
  public VideoDecoderTrack(AssetTrack paramAssetTrack)
  {
    AppMethodBeat.i(214982);
    this.frameDuration = new CMTime(1L, 44);
    this.frameRate = 44;
    this.segments = new ArrayList();
    this.decodeType = IDecoder.DecodeType.Video;
    this.segmentIndex = -1;
    this.currentSegmentStartTime = CMTime.CMTimeZero;
    this.lastSampleState = new CMSampleState();
    this.decoderCreateThread = null;
    this.nextDecoderLock = new Object();
    this.currentDecoderLock = new Object();
    this.nextFrameDecoderLock = new Object();
    this.isReleased = false;
    this.nextFrame = null;
    this.currentFrame = null;
    this.duration = CMTime.CMTimeZero;
    this.decoderThread = new DecoderThread(null);
    this.surfaceCreator = null;
    this._speed = 1.0F;
    this.started = false;
    this.trackId = paramAssetTrack.getTrackID();
    Object localObject = paramAssetTrack.getSegments();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new DecoderTrackSegment(paramAssetTrack, (AssetTrackSegment)((Iterator)localObject).next()));
    }
    setTrackSegments(localArrayList);
    if (getFrameRate() > 0) {}
    for (int i = getFrameRate();; i = (int)paramAssetTrack.getNominalFrameRate())
    {
      setFrameRate(i);
      setVolume(paramAssetTrack.getPreferredVolume());
      setDecodeType(IDecoder.DecodeType.Video);
      if (paramAssetTrack.getTimeRange() != null) {
        clipRangeAndClearRange(paramAssetTrack.getTimeRange().clone());
      }
      AppMethodBeat.o(214982);
      return;
    }
  }
  
  private void clipRangeAndRemoveRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(214988);
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(214988);
      return;
    }
    CMTime localCMTime2 = paramCMTimeRange.getStart();
    CMTime localCMTime1 = paramCMTimeRange.getEnd();
    int k = findSegmentIndexAt(localCMTime2, false);
    if (k == -1)
    {
      AppMethodBeat.o(214988);
      return;
    }
    int j = findSegmentIndexAt(localCMTime1, false);
    int i;
    if (j == -1) {
      i = this.segments.size() - 1;
    }
    DecoderTrackSegment localDecoderTrackSegment2;
    for (;;)
    {
      CMTime localCMTime3 = getSegmentStartTime(k);
      localCMTime2 = getSegmentStartTime(i);
      DecoderTrackSegment localDecoderTrackSegment1 = getSegment(k);
      localDecoderTrackSegment2 = getSegment(i);
      CMTime localCMTime4;
      float f;
      if ((localDecoderTrackSegment2.getTimeRange().getDurationUs() > 0L) && (!getSegmentStartTime(i + 1).smallThan(paramCMTimeRange.getEnd())))
      {
        localCMTime4 = paramCMTimeRange.getEnd().sub(localCMTime2);
        f = (float)localDecoderTrackSegment2.getScaledDuration().getTimeUs() * 1.0F / (float)localDecoderTrackSegment2.getTimeRange().getDurationUs();
        localDecoderTrackSegment2.setTimeRange(new CMTimeRange(localDecoderTrackSegment2.getTimeRange().getStart(), localCMTime4.divide(f)));
        localDecoderTrackSegment2.setScaledDuration(localCMTime4);
      }
      if (localDecoderTrackSegment1.getTimeRange().getDurationUs() > 0L)
      {
        f = (float)localDecoderTrackSegment1.getScaledDuration().getTimeUs() * 1.0F / (float)localDecoderTrackSegment1.getTimeRange().getDurationUs();
        localCMTime3 = paramCMTimeRange.getStart().sub(localCMTime3);
        localCMTime4 = localCMTime3.divide(f);
        localDecoderTrackSegment1.setTimeRange(new CMTimeRange(localDecoderTrackSegment1.getTimeRange().getStart().add(localCMTime4), localDecoderTrackSegment1.getTimeRange().getDuration().sub(localCMTime4)));
        localDecoderTrackSegment1.setScaledDuration(localDecoderTrackSegment1.getScaledDuration().sub(localCMTime3));
      }
      j = this.segments.size() - 1;
      while (j >= 0)
      {
        if ((j > i) || (j < k)) {
          this.segments.remove(j);
        }
        j -= 1;
      }
      i = j;
      if (getSegmentStartTime(j) == localCMTime1) {
        i = j - 1;
      }
    }
    if (getSegmentStartTime(i + 1).smallThan(paramCMTimeRange.getEnd()))
    {
      paramCMTimeRange = new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, localCMTime1.sub(localDecoderTrackSegment2.getScaledDuration().add(localCMTime2))), null);
      this.segments.add(paramCMTimeRange);
    }
    AppMethodBeat.o(214988);
  }
  
  /* Error */
  private IVideoDecoder createDecoder(DecoderTrackSegment paramDecoderTrackSegment, CMTime paramCMTime)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: ldc_w 358
    //   11: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_1
    //   15: invokevirtual 362	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   18: astore 11
    //   20: aload 11
    //   22: ifnonnull +16 -> 38
    //   25: ldc_w 358
    //   28: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload 7
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: areturn
    //   38: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   41: astore 7
    //   43: new 364	java/lang/StringBuilder
    //   46: dup
    //   47: ldc_w 366
    //   50: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: aload 11
    //   55: getfield 373	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   58: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 379
    //   64: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: astore 8
    //   69: aload_0
    //   70: getfield 141	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   73: ifnull +269 -> 342
    //   76: iconst_1
    //   77: istore 5
    //   79: aload 7
    //   81: aload 8
    //   83: iload 5
    //   85: invokevirtual 382	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 390	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: iconst_5
    //   95: istore_3
    //   96: aconst_null
    //   97: astore 7
    //   99: aload 7
    //   101: ifnonnull +761 -> 862
    //   104: iload_3
    //   105: ifle +757 -> 862
    //   108: iload_3
    //   109: iconst_1
    //   110: isub
    //   111: istore_3
    //   112: aload_0
    //   113: getfield 120	com/tencent/tav/decoder/VideoDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;
    //   116: ifnull +396 -> 512
    //   119: aload_0
    //   120: getfield 120	com/tencent/tav/decoder/VideoDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;
    //   123: invokestatic 394	com/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread:access$100	(Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;)I
    //   126: istore 4
    //   128: iload 4
    //   130: aload_0
    //   131: getfield 99	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   134: invokevirtual 296	java/util/ArrayList:size	()I
    //   137: if_icmpge +220 -> 357
    //   140: aload_0
    //   141: iload 4
    //   143: invokespecial 245	com/tencent/tav/decoder/VideoDecoderTrack:getSegment	(I)Lcom/tencent/tav/decoder/DecoderTrackSegment;
    //   146: invokevirtual 362	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   149: aload 11
    //   151: invokestatic 400	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   154: ifeq +203 -> 357
    //   157: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   160: new 364	java/lang/StringBuilder
    //   163: dup
    //   164: ldc_w 402
    //   167: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload 11
    //   172: getfield 373	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   175: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 390	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_0
    //   185: getfield 122	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   188: astore 8
    //   190: aload 8
    //   192: monitorenter
    //   193: aload_0
    //   194: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   197: ifnull +157 -> 354
    //   200: aload_0
    //   201: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   204: getfield 406	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   207: aload 11
    //   209: invokestatic 400	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   212: ifeq +142 -> 354
    //   215: aload_0
    //   216: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   219: getfield 409	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   222: ifnull +132 -> 354
    //   225: aload_0
    //   226: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   229: getfield 409	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   232: astore_2
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   238: getfield 410	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:segmentIndex	I
    //   241: invokespecial 245	com/tencent/tav/decoder/VideoDecoderTrack:getSegment	(I)Lcom/tencent/tav/decoder/DecoderTrackSegment;
    //   244: aload_1
    //   245: if_acmpeq +17 -> 262
    //   248: aload_2
    //   249: aload_1
    //   250: invokevirtual 312	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   253: aload_1
    //   254: invokevirtual 413	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   257: invokeinterface 419 3 0
    //   262: aload_0
    //   263: aconst_null
    //   264: putfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   267: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   270: astore_1
    //   271: new 364	java/lang/StringBuilder
    //   274: dup
    //   275: ldc_w 421
    //   278: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: astore 7
    //   283: aload_0
    //   284: getfield 141	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   287: ifnonnull +61 -> 348
    //   290: iload 6
    //   292: istore 5
    //   294: aload_1
    //   295: aload 7
    //   297: iload 5
    //   299: invokevirtual 382	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   302: ldc_w 423
    //   305: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_2
    //   309: invokeinterface 426 1 0
    //   314: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 390	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: aload 8
    //   325: monitorexit
    //   326: ldc_w 358
    //   329: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   332: aload_2
    //   333: astore_1
    //   334: goto -300 -> 34
    //   337: astore_1
    //   338: aload_0
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    //   342: iconst_0
    //   343: istore 5
    //   345: goto -266 -> 79
    //   348: iconst_0
    //   349: istore 5
    //   351: goto -57 -> 294
    //   354: aload 8
    //   356: monitorexit
    //   357: aload_0
    //   358: getfield 141	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   361: ifnull +534 -> 895
    //   364: aload 11
    //   366: getfield 429	com/tencent/tav/decoder/DecoderAssetTrack:size	Lcom/tencent/tav/coremedia/CGSize;
    //   369: astore 8
    //   371: aload 11
    //   373: getfield 432	com/tencent/tav/decoder/DecoderAssetTrack:preferRotation	I
    //   376: istore 4
    //   378: aload 8
    //   380: ifnull +515 -> 895
    //   383: aload_0
    //   384: getfield 141	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   387: aload 8
    //   389: getfield 437	com/tencent/tav/coremedia/CGSize:width	F
    //   392: f2i
    //   393: aload 8
    //   395: getfield 440	com/tencent/tav/coremedia/CGSize:height	F
    //   398: f2i
    //   399: iload 4
    //   401: invokeinterface 446 4 0
    //   406: astore 8
    //   408: aload 11
    //   410: getfield 449	com/tencent/tav/decoder/DecoderAssetTrack:sourceType	I
    //   413: iconst_3
    //   414: if_icmpne +330 -> 744
    //   417: new 451	com/tencent/tav/decoder/ImageDecoder
    //   420: dup
    //   421: invokespecial 452	com/tencent/tav/decoder/ImageDecoder:<init>	()V
    //   424: astore 10
    //   426: aload 10
    //   428: astore 9
    //   430: aload 10
    //   432: aload 11
    //   434: getfield 373	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   437: getstatic 455	com/tencent/tav/decoder/ImageDecoder:IMAGE_DECODE_SIZE	Lcom/tencent/tav/coremedia/CGSize;
    //   440: aconst_null
    //   441: invokeinterface 459 4 0
    //   446: aload 10
    //   448: astore 7
    //   450: aload 7
    //   452: astore 9
    //   454: aload 7
    //   456: aload_1
    //   457: invokevirtual 312	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   460: aload_2
    //   461: invokeinterface 419 3 0
    //   466: aload 7
    //   468: astore 9
    //   470: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   473: new 364	java/lang/StringBuilder
    //   476: dup
    //   477: ldc_w 461
    //   480: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   483: aload 11
    //   485: getfield 373	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   488: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 390	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto -398 -> 99
    //   500: astore_1
    //   501: aload 8
    //   503: monitorexit
    //   504: ldc_w 358
    //   507: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   510: aload_1
    //   511: athrow
    //   512: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   515: new 364	java/lang/StringBuilder
    //   518: dup
    //   519: ldc_w 463
    //   522: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   525: aload 11
    //   527: getfield 373	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   530: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 390	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: aload_0
    //   540: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   543: ifnull -186 -> 357
    //   546: aload_0
    //   547: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   550: getfield 406	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   553: aload 11
    //   555: invokestatic 400	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   558: ifeq -201 -> 357
    //   561: aload_0
    //   562: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   565: getfield 409	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   568: ifnull -211 -> 357
    //   571: aload_0
    //   572: getfield 122	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   575: astore 8
    //   577: aload 8
    //   579: monitorenter
    //   580: aload_0
    //   581: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   584: ifnull +142 -> 726
    //   587: aload_0
    //   588: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   591: getfield 406	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   594: aload 11
    //   596: if_acmpne +130 -> 726
    //   599: aload_0
    //   600: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   603: getfield 409	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   606: ifnull +120 -> 726
    //   609: aload_0
    //   610: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   613: getfield 409	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   616: astore_2
    //   617: aload_0
    //   618: aload_0
    //   619: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   622: getfield 410	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:segmentIndex	I
    //   625: invokespecial 245	com/tencent/tav/decoder/VideoDecoderTrack:getSegment	(I)Lcom/tencent/tav/decoder/DecoderTrackSegment;
    //   628: aload_1
    //   629: if_acmpeq +17 -> 646
    //   632: aload_2
    //   633: aload_1
    //   634: invokevirtual 312	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   637: aload_1
    //   638: invokevirtual 413	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   641: invokeinterface 419 3 0
    //   646: aload_0
    //   647: aconst_null
    //   648: putfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   651: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   654: astore_1
    //   655: new 364	java/lang/StringBuilder
    //   658: dup
    //   659: ldc_w 421
    //   662: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   665: astore 7
    //   667: aload_0
    //   668: getfield 141	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   671: ifnonnull +49 -> 720
    //   674: iconst_1
    //   675: istore 5
    //   677: aload_1
    //   678: aload 7
    //   680: iload 5
    //   682: invokevirtual 382	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   685: ldc_w 423
    //   688: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload_2
    //   692: invokeinterface 426 1 0
    //   697: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 390	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: aload 8
    //   708: monitorexit
    //   709: ldc_w 358
    //   712: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   715: aload_2
    //   716: astore_1
    //   717: goto -683 -> 34
    //   720: iconst_0
    //   721: istore 5
    //   723: goto -46 -> 677
    //   726: aload 8
    //   728: monitorexit
    //   729: goto -372 -> 357
    //   732: astore_1
    //   733: aload 8
    //   735: monitorexit
    //   736: ldc_w 358
    //   739: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   742: aload_1
    //   743: athrow
    //   744: new 465	com/tencent/tav/decoder/VideoDecoder
    //   747: dup
    //   748: aload 11
    //   750: getfield 373	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   753: aload 8
    //   755: invokespecial 468	com/tencent/tav/decoder/VideoDecoder:<init>	(Ljava/lang/String;Landroid/view/Surface;)V
    //   758: astore 9
    //   760: aload 9
    //   762: astore 7
    //   764: goto -314 -> 450
    //   767: astore 10
    //   769: aload 7
    //   771: astore 9
    //   773: aload 10
    //   775: astore 7
    //   777: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   780: new 364	java/lang/StringBuilder
    //   783: dup
    //   784: ldc_w 470
    //   787: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   790: aload 7
    //   792: invokevirtual 473	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   795: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload 7
    //   800: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   803: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: invokestatic 479	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   809: aload_0
    //   810: aload 8
    //   812: invokespecial 238	com/tencent/tav/decoder/VideoDecoderTrack:free	(Landroid/view/Surface;)V
    //   815: aload 9
    //   817: ifnull +22 -> 839
    //   820: aload 9
    //   822: iconst_1
    //   823: invokeinterface 483 2 0
    //   828: aload_0
    //   829: aload 9
    //   831: invokeinterface 487 1 0
    //   836: invokespecial 238	com/tencent/tav/decoder/VideoDecoderTrack:free	(Landroid/view/Surface;)V
    //   839: aconst_null
    //   840: astore 7
    //   842: goto -743 -> 99
    //   845: astore 7
    //   847: aconst_null
    //   848: astore 7
    //   850: goto -751 -> 99
    //   853: astore_1
    //   854: ldc_w 358
    //   857: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   860: aload_1
    //   861: athrow
    //   862: ldc_w 358
    //   865: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   868: aload 7
    //   870: astore_1
    //   871: goto -837 -> 34
    //   874: astore 7
    //   876: goto -99 -> 777
    //   879: astore 10
    //   881: aconst_null
    //   882: astore 8
    //   884: aload 7
    //   886: astore 9
    //   888: aload 10
    //   890: astore 7
    //   892: goto -115 -> 777
    //   895: aconst_null
    //   896: astore 8
    //   898: goto -490 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	901	0	this	VideoDecoderTrack
    //   0	901	1	paramDecoderTrackSegment	DecoderTrackSegment
    //   0	901	2	paramCMTime	CMTime
    //   95	17	3	i	int
    //   126	274	4	j	int
    //   77	645	5	bool1	boolean
    //   1	290	6	bool2	boolean
    //   4	837	7	localObject1	Object
    //   845	1	7	localException1	Exception
    //   848	21	7	localObject2	Object
    //   874	11	7	localException2	Exception
    //   890	1	7	localObject3	Object
    //   67	830	8	localObject4	Object
    //   428	459	9	localObject5	Object
    //   424	23	10	localImageDecoder	ImageDecoder
    //   767	7	10	localException3	Exception
    //   879	10	10	localException4	Exception
    //   18	731	11	localDecoderAssetTrack	DecoderAssetTrack
    // Exception table:
    //   from	to	target	type
    //   8	20	337	finally
    //   25	31	337	finally
    //   38	76	337	finally
    //   79	94	337	finally
    //   112	193	337	finally
    //   326	332	337	finally
    //   357	378	337	finally
    //   383	408	337	finally
    //   408	426	337	finally
    //   430	446	337	finally
    //   454	466	337	finally
    //   470	497	337	finally
    //   504	512	337	finally
    //   512	580	337	finally
    //   709	715	337	finally
    //   736	744	337	finally
    //   744	760	337	finally
    //   777	815	337	finally
    //   854	862	337	finally
    //   862	868	337	finally
    //   193	262	500	finally
    //   262	290	500	finally
    //   294	326	500	finally
    //   354	357	500	finally
    //   501	504	500	finally
    //   580	646	732	finally
    //   646	674	732	finally
    //   677	709	732	finally
    //   726	729	732	finally
    //   733	736	732	finally
    //   408	426	767	java/lang/Exception
    //   744	760	767	java/lang/Exception
    //   820	839	845	java/lang/Exception
    //   820	839	853	finally
    //   430	446	874	java/lang/Exception
    //   454	466	874	java/lang/Exception
    //   470	497	874	java/lang/Exception
    //   357	378	879	java/lang/Exception
    //   383	408	879	java/lang/Exception
  }
  
  private void createDecoder(DecoderAssetTrack paramDecoderAssetTrack, int paramInt)
  {
    AppMethodBeat.i(215000);
    try
    {
      if ((this.surfaceCreator != null) && (paramDecoderAssetTrack.size != null))
      {
        CGSize localCGSize = paramDecoderAssetTrack.size;
        int i = paramDecoderAssetTrack.preferRotation;
        this.decoderCreateThread = new DecoderCreateThread(paramDecoderAssetTrack, this.surfaceCreator.createOutputSurface((int)localCGSize.width, (int)localCGSize.height, i), paramInt, null);
        this.decoderCreateThread.start();
      }
      AppMethodBeat.o(215000);
      return;
    }
    catch (Exception paramDecoderAssetTrack)
    {
      Logger.e(TAG, "createNextDecoder: try start DecoderCreateThread", paramDecoderAssetTrack);
      AppMethodBeat.o(215000);
    }
  }
  
  private void createNextDecoder(int paramInt)
  {
    AppMethodBeat.i(214999);
    if ((this.segments == null) || (!PRE_READ))
    {
      AppMethodBeat.o(214999);
      return;
    }
    int i = paramInt + 1;
    if (i >= this.segments.size())
    {
      AppMethodBeat.o(214999);
      return;
    }
    if (this.decoderCreateThread == null)
    {
      DecoderAssetTrack localDecoderAssetTrack = getSegment(i).getVideoAsset();
      if (localDecoderAssetTrack != null)
      {
        if ((this.nextDecoder == null) || (!ExtractorUtils.isSameExtractor(this.nextDecoder.extractor, localDecoderAssetTrack)))
        {
          createDecoder(localDecoderAssetTrack, i);
          AppMethodBeat.o(214999);
        }
      }
      else if ((this.nextDecoder != null) && (this.nextDecoder.segmentIndex != paramInt))
      {
        this.nextDecoder.decoder.start(getSegment(paramInt).getTimeRange());
        this.nextDecoder.segmentIndex = paramInt;
      }
    }
    AppMethodBeat.o(214999);
  }
  
  private CMSampleBuffer createSampleBuffer(long paramLong)
  {
    AppMethodBeat.i(215009);
    CMSampleBuffer localCMSampleBuffer = createSampleBuffer(CMSampleState.fromError(paramLong));
    AppMethodBeat.o(215009);
    return localCMSampleBuffer;
  }
  
  private CMSampleBuffer createSampleBuffer(CMSampleState paramCMSampleState)
  {
    AppMethodBeat.i(215010);
    paramCMSampleState = new CMSampleBuffer(paramCMSampleState);
    AppMethodBeat.o(215010);
    return paramCMSampleState;
  }
  
  private CMSampleBuffer createSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(215012);
    paramCMSampleState = new CMSampleBuffer(paramCMSampleState, paramTextureInfo, paramBoolean);
    AppMethodBeat.o(215012);
    return paramCMSampleState;
  }
  
  private CMSampleBuffer createSampleBuffer(CMSampleState paramCMSampleState, VideoTexture paramVideoTexture, boolean paramBoolean)
  {
    AppMethodBeat.i(215011);
    if (paramVideoTexture == null) {}
    for (TextureInfo localTextureInfo = null;; localTextureInfo = paramVideoTexture.getTextureInfo())
    {
      paramCMSampleState = new CacheSampleBuffer(paramCMSampleState, localTextureInfo, paramBoolean);
      paramCMSampleState.setTexture(paramVideoTexture);
      AppMethodBeat.o(215011);
      return paramCMSampleState;
    }
  }
  
  private CMSampleBuffer createSampleBuffer(CMSampleState paramCMSampleState, boolean paramBoolean)
  {
    AppMethodBeat.i(215008);
    if ((this.currentDecoder instanceof VideoDecoder))
    {
      paramCMSampleState = createSampleBuffer(paramCMSampleState, this.surfaceCreator.videoTextureForSurface(this._outputSurface), paramBoolean);
      AppMethodBeat.o(215008);
      return paramCMSampleState;
    }
    if (this.currentDecoder == null) {}
    for (TextureInfo localTextureInfo = null;; localTextureInfo = this.currentDecoder.getTextureInfo())
    {
      paramCMSampleState = createSampleBuffer(paramCMSampleState, localTextureInfo, paramBoolean);
      AppMethodBeat.o(215008);
      return paramCMSampleState;
    }
  }
  
  private CMSampleBuffer createSampleBuffer(boolean paramBoolean)
  {
    AppMethodBeat.i(215007);
    if (this.currentFrame != null)
    {
      localObject = createSampleBuffer(this.lastSampleState, this.currentFrame.getTextureInfo(), paramBoolean);
      AppMethodBeat.o(215007);
      return localObject;
    }
    CMSampleState localCMSampleState = this.lastSampleState;
    if (this.currentDecoder == null) {}
    for (Object localObject = null;; localObject = this.currentDecoder.getTextureInfo())
    {
      localObject = createSampleBuffer(localCMSampleState, (TextureInfo)localObject, paramBoolean);
      AppMethodBeat.o(215007);
      return localObject;
    }
  }
  
  private CMSampleBuffer doReadSample(CMTime paramCMTime)
  {
    try
    {
      AppMethodBeat.i(215005);
      paramCMTime = doReadSample(paramCMTime, false);
      AppMethodBeat.o(215005);
      return paramCMTime;
    }
    finally
    {
      paramCMTime = finally;
      throw paramCMTime;
    }
  }
  
  private CMSampleBuffer doReadSample(CMTime paramCMTime, boolean paramBoolean)
  {
    label122:
    DecoderTrackSegment localDecoderTrackSegment;
    Object localObject;
    int i;
    label138:
    CMTime localCMTime;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(215006);
        logVerbose("doReadSample: step 1 ");
        if (this.isReleased)
        {
          paramCMTime = createSampleBuffer(-100L);
          AppMethodBeat.o(215006);
          return paramCMTime;
        }
        if (paramCMTime == null)
        {
          paramCMTime = createSampleBuffer(-3L);
          AppMethodBeat.o(215006);
          continue;
        }
        if (this.segmentIndex != -1) {
          break label122;
        }
      }
      finally {}
      if (this.lastSampleState.getStateCode() >= -1L)
      {
        paramCMTime = createSampleBuffer(-1L);
        AppMethodBeat.o(215006);
      }
      else
      {
        paramCMTime = createSampleBuffer(-100L);
        AppMethodBeat.o(215006);
        continue;
        localDecoderTrackSegment = getCurrentSegment();
        localObject = CMSampleState.fromError(-1L);
        i = 0;
        logVerbose("doReadSample: step 2 ");
        if (this.currentDecoder != null) {
          break;
        }
        this.lastSampleState = new CMSampleState(this.lastSampleState.getTime().add(this.frameDuration));
        localCMTime = this.currentSegmentStartTime.add(localDecoderTrackSegment.getScaledDuration());
        if (!this.lastSampleState.getTime().smallThan(localCMTime)) {
          break label726;
        }
        if (this.surfaceCreator == null)
        {
          paramCMTime = createSampleBuffer(this.lastSampleState);
          AppMethodBeat.o(215006);
        }
        else
        {
          paramCMTime = createSampleBuffer(this.lastSampleState, this.surfaceCreator.videoTextureForSurface(this._outputSurface), false);
          AppMethodBeat.o(215006);
        }
      }
    }
    label263:
    if ((((CMSampleState)localObject).stateMatchingTo(new long[] { -1L })) || (((CMSampleState)localObject).getTime().bigThan(localDecoderTrackSegment.getTimeRange().getDuration()))) {
      if (localDecoderTrackSegment.getScaledDuration().add(this.currentSegmentStartTime).sub(this.frameDuration).bigThan(paramCMTime)) {
        if ((i == 0) || (this.currentDecoder == null) || (!this.currentDecoder.isLastFrameValid())) {
          break label734;
        }
      }
    }
    label726:
    label729:
    label734:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramCMTime = createSampleBuffer(new CMSampleState(paramCMTime), paramBoolean);
      AppMethodBeat.o(215006);
      break;
      localObject = paramCMTime.sub(this.currentSegmentStartTime).multi(this._speed).limitMin(CMTime.CMTimeZero);
      if ((float)((CMTime)localObject).getTimeUs() > (float)localDecoderTrackSegment.getScaledDuration().getTimeUs() * this._speed)
      {
        localObject = CMSampleState.fromError(-1L);
        break label263;
      }
      localObject = ((CMTime)localObject).add(localDecoderTrackSegment.getDecoderStartTime());
      if (this.currentDecoder == null)
      {
        localObject = CMSampleState.fromError(-100L);
      }
      else
      {
        localObject = this.currentDecoder.readSample((CMTime)localObject);
        break label729;
        if (paramBoolean)
        {
          Logger.d(TAG, "async read finish , skip it!");
          paramCMTime = null;
          AppMethodBeat.o(215006);
          break;
        }
        if (!nextSegment(true))
        {
          paramCMTime = createSampleBuffer(CMSampleState.fromError(-1L), false);
          AppMethodBeat.o(215006);
          break;
        }
        localDecoderTrackSegment = getCurrentSegment();
        break label138;
        if (((CMSampleState)localObject).getStateCode() < 0L)
        {
          if (!((CMSampleState)localObject).stateMatchingTo(new long[] { -3L }))
          {
            paramCMTime = createSampleBuffer(this.lastSampleState);
            AppMethodBeat.o(215006);
            break;
          }
          paramCMTime = createSampleBuffer((CMSampleState)localObject);
          AppMethodBeat.o(215006);
          break;
        }
        logVerbose("doReadSample: step 3 ");
        localCMTime = ((CMSampleState)localObject).getTime().sub(localDecoderTrackSegment.getDecoderStartTime());
        localObject = localCMTime;
        if (localCMTime.bigThan(localDecoderTrackSegment.getTimeRange().getDuration())) {
          localObject = localDecoderTrackSegment.getTimeRange().getDuration();
        }
        localObject = new CMSampleState(this.currentSegmentStartTime.add(((CMTime)localObject).divide(this._speed)));
        logVerbose("readSample: currentTime = " + paramCMTime + "  sampleState = " + localObject);
        paramCMTime = createSampleBuffer((CMSampleState)localObject, true);
        AppMethodBeat.o(215006);
        break;
        break label263;
      }
      i = 1;
      break label263;
    }
  }
  
  private int findSegmentIndexAt(CMTime paramCMTime, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(214989);
    CMTime localCMTime1 = CMTime.CMTimeZero;
    Iterator localIterator = this.segments.iterator();
    int i = 0;
    int j = k;
    CMTime localCMTime2;
    if (localIterator.hasNext())
    {
      localCMTime2 = ((DecoderTrackSegment)localIterator.next()).getScaledDuration();
      if ((paramCMTime.compare(localCMTime1) >= 0) && (paramCMTime.smallThan(localCMTime1.add(localCMTime2)))) {
        j = 1;
      }
    }
    else
    {
      if ((j != 0) || (paramCMTime != localCMTime1) || (i <= 0) || (!paramBoolean)) {
        break label143;
      }
      j = 1;
      i -= 1;
    }
    label143:
    for (;;)
    {
      if (j != 0)
      {
        AppMethodBeat.o(214989);
        return i;
        localCMTime1 = localCMTime1.add(localCMTime2);
        i += 1;
        break;
      }
      AppMethodBeat.o(214989);
      return -1;
    }
  }
  
  private void free(Surface paramSurface)
  {
    AppMethodBeat.i(215017);
    if (paramSurface != null) {}
    try
    {
      this.surfaceCreator.free(paramSurface);
      AppMethodBeat.o(215017);
      return;
    }
    catch (Exception paramSurface)
    {
      AppMethodBeat.o(215017);
    }
  }
  
  private DecoderTrackSegment getCurrentSegment()
  {
    AppMethodBeat.i(214993);
    DecoderTrackSegment localDecoderTrackSegment = getSegment(this.segmentIndex);
    AppMethodBeat.o(214993);
    return localDecoderTrackSegment;
  }
  
  private DecoderTrackSegment getSegment(int paramInt)
  {
    AppMethodBeat.i(214994);
    DecoderTrackSegment localDecoderTrackSegment = (DecoderTrackSegment)this.segments.get(paramInt);
    AppMethodBeat.o(214994);
    return localDecoderTrackSegment;
  }
  
  private CMTime getSegmentStartTime(int paramInt)
  {
    AppMethodBeat.i(214990);
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while ((i < paramInt) && (i < this.segments.size()))
    {
      localCMTime = CMTime.add(localCMTime, getSegment(i).getScaledDuration());
      i += 1;
    }
    AppMethodBeat.o(214990);
    return localCMTime;
  }
  
  private void logVerbose(String paramString)
  {
    AppMethodBeat.i(215021);
    Logger.v(TAG, paramString);
    AppMethodBeat.o(215021);
  }
  
  private boolean needSwitchNextFrame(CMSampleBuffer paramCMSampleBuffer1, CMSampleBuffer paramCMSampleBuffer2, CMTime paramCMTime)
  {
    AppMethodBeat.i(215013);
    if ((paramCMSampleBuffer1 == null) || (paramCMSampleBuffer2.getTime().smallThan(CMTime.CMTimeZero)))
    {
      AppMethodBeat.o(215013);
      return true;
    }
    long l1 = paramCMSampleBuffer2.getTime().getTimeUs();
    long l2 = paramCMTime.getTimeUs();
    if (paramCMSampleBuffer2.isNewFrame())
    {
      paramCMSampleBuffer2 = CMTime.CMTimeZero;
      int i = 0;
      while ((i < this.segmentIndex) && (i < this.segments.size()))
      {
        paramCMSampleBuffer2.add(((DecoderTrackSegment)this.segments.get(i)).getScaledDuration());
        i += 1;
      }
      if ((paramCMTime.bigThan(paramCMSampleBuffer1.getTime())) && (!paramCMTime.smallThan(paramCMSampleBuffer2)))
      {
        AppMethodBeat.o(215013);
        return true;
      }
    }
    if (Math.abs(l2) >= Math.abs(l1))
    {
      AppMethodBeat.o(215013);
      return true;
    }
    AppMethodBeat.o(215013);
    return false;
  }
  
  private boolean nextSegment(boolean paramBoolean)
  {
    AppMethodBeat.i(214992);
    Logger.d(TAG, "nextSegment:".concat(String.valueOf(paramBoolean)));
    this.segmentIndex += 1;
    this._outputSurface = null;
    if (this.segmentIndex >= this.segments.size())
    {
      this.segmentIndex = -1;
      AppMethodBeat.o(214992);
      return false;
    }
    this.currentSegmentStartTime = getSegmentStartTime(this.segmentIndex);
    this.lastSampleState = new CMSampleState(this.currentSegmentStartTime);
    Object localObject2 = getCurrentSegment();
    IVideoDecoder localIVideoDecoder;
    if (((DecoderTrackSegment)localObject2).getVideoAsset() != null) {
      synchronized (this.currentDecoderLock)
      {
        if ((this.currentDecoder != null) && (this.currentDecoder.getSourcePath() != null))
        {
          new ReleaseDecoderThread(this.currentDecoder).start();
          this.currentDecoder = null;
        }
        if (paramBoolean)
        {
          ??? = getCurrentSegment().getDecoderStartTime();
          localIVideoDecoder = createDecoder((DecoderTrackSegment)localObject2, (CMTime)???);
        }
      }
    }
    for (;;)
    {
      synchronized (this.currentDecoderLock)
      {
        this.currentDecoder = localIVideoDecoder;
        if ((this.currentDecoder != null) && (this.currentDecoder.hasTrack()))
        {
          if (paramBoolean) {
            this.currentDecoder.seekTo(((DecoderTrackSegment)localObject2).getDecoderStartTime());
          }
          this._outputSurface = this.currentDecoder.outputSurface();
        }
        if (((DecoderTrackSegment)localObject2).getScaledDuration().getTimeUs() > 0L) {
          this._speed = ((float)((DecoderTrackSegment)localObject2).getTimeRange().getDurationUs() * 1.0F / (float)((DecoderTrackSegment)localObject2).getScaledDuration().getTimeUs());
        }
        ??? = TAG;
        localObject2 = new StringBuilder("nextSegment:");
        if (this.currentDecoder != null) {
          break label415;
        }
        paramBoolean = true;
        Logger.d((String)???, paramBoolean + " " + this._speed);
        AppMethodBeat.o(214992);
        return true;
        localObject3 = finally;
        AppMethodBeat.o(214992);
        throw localObject3;
        ??? = CMTime.CMTimeInvalid;
      }
      Logger.d(TAG, "nextSegment: videoAsset is null");
      synchronized (this.currentDecoderLock)
      {
        if (this.currentDecoder != null)
        {
          new ReleaseDecoderThread(this.currentDecoder).start();
          this.currentDecoder = null;
        }
      }
      label415:
      paramBoolean = false;
    }
  }
  
  private void release(Surface paramSurface)
  {
    AppMethodBeat.i(215016);
    if (paramSurface != null) {}
    try
    {
      paramSurface.release();
      AppMethodBeat.o(215016);
      return;
    }
    catch (Exception paramSurface)
    {
      AppMethodBeat.o(215016);
    }
  }
  
  private void releaseDecoder()
  {
    AppMethodBeat.i(215018);
    if (this.currentDecoder == null)
    {
      AppMethodBeat.o(215018);
      return;
    }
    synchronized (this.currentDecoderLock)
    {
      if ((this.currentDecoder != null) && (this.currentDecoder.getSourcePath() != null))
      {
        new ReleaseDecoderThread(this.currentDecoder).start();
        this.currentDecoder = null;
      }
      AppMethodBeat.o(215018);
      return;
    }
  }
  
  private CMTime segmentsDuration()
  {
    AppMethodBeat.i(214991);
    CMTime localCMTime = getSegmentStartTime(this.segments.size());
    AppMethodBeat.o(214991);
    return localCMTime;
  }
  
  private CMSampleBuffer switchToNextFrame()
  {
    AppMethodBeat.i(215004);
    this.currentFrame = createSampleBuffer(this.nextFrame.getState(), this.nextFrame.getTextureInfo(), this.nextFrame.isNewFrame());
    Object localObject;
    if ((this.nextFrame.isNewFrame()) && ((this.nextFrame instanceof CacheSampleBuffer)))
    {
      localObject = ((CacheSampleBuffer)this.nextFrame).getTexture();
      if ((localObject != null) && (!Thread.currentThread().getName().equals("VideoDecoder"))) {
        logVerbose("readSample: awaitNewImage: " + this.nextFrame.getTime());
      }
    }
    try
    {
      ((VideoTexture)localObject).awaitNewImage();
      this.nextFrame = createSampleBuffer(new CMSampleState());
      if (this.currentFrame.getTime().smallThan(CMTime.CMTimeZero))
      {
        this.lastSampleState = this.currentFrame.getState();
        localObject = createSampleBuffer(this.currentFrame.getState());
        AppMethodBeat.o(215004);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e(TAG, "readSample: videoTexture.awaitNewImage() error", localThrowable);
      CMSampleBuffer localCMSampleBuffer = createSampleBuffer(CMSampleState.fromError(-3L));
      AppMethodBeat.o(215004);
      return localCMSampleBuffer;
    }
    AppMethodBeat.o(215004);
    return null;
  }
  
  private void tryReleaseDecoder(IVideoDecoder paramIVideoDecoder)
  {
    AppMethodBeat.i(215019);
    if (paramIVideoDecoder != null) {}
    try
    {
      paramIVideoDecoder.release(true);
      free(paramIVideoDecoder.outputSurface());
      AppMethodBeat.o(215019);
      return;
    }
    catch (Exception paramIVideoDecoder)
    {
      AppMethodBeat.o(215019);
    }
  }
  
  private boolean unNeedReDecoderNextFrame(CMTime paramCMTime)
  {
    AppMethodBeat.i(215014);
    int i;
    if ((this.nextFrame != null) && (this.nextFrame.getTime().bigThan(paramCMTime)))
    {
      i = 1;
      if ((this.nextFrame == null) || (this.currentFrame == null) || (!this.nextFrame.getTime().bigThan(this.currentFrame.getTime()))) {
        break label86;
      }
    }
    label86:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) && (j == 0)) {
        break label91;
      }
      AppMethodBeat.o(215014);
      return true;
      i = 0;
      break;
    }
    label91:
    AppMethodBeat.o(215014);
    return false;
  }
  
  public void asyncReadNextSample(CMTime arg1)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(215015);
        if (unNeedReDecoderNextFrame(???))
        {
          AppMethodBeat.o(215015);
          return;
        }
        if (this.isReleased)
        {
          AppMethodBeat.o(215015);
          continue;
        }
        this.nextFrame = new CMSampleBuffer(???);
      }
      finally {}
      synchronized (this.decoderThread)
      {
        this.decoderThread.action();
        AppMethodBeat.o(215015);
      }
    }
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(214987);
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(214987);
      return;
    }
    CMTime localCMTime1 = paramCMTimeRange.getStart();
    CMTime localCMTime2 = paramCMTimeRange.getEnd();
    CMTime localCMTime3 = segmentsDuration();
    clipRangeAndRemoveRange(paramCMTimeRange);
    if (localCMTime1.getValue() != 0L) {
      this.segments.add(0, new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, localCMTime1), null));
    }
    if (localCMTime2.getTimeUs() < localCMTime3.getTimeUs()) {
      this.segments.add(new DecoderTrackSegment(new CMTimeRange(localCMTime2, new CMTime(localCMTime3.getTimeSeconds() - localCMTime2.getTimeSeconds())), null));
    }
    AppMethodBeat.o(214987);
  }
  
  public CMTime getCurrentSampleTime()
  {
    AppMethodBeat.i(214986);
    CMTime localCMTime = this.lastSampleState.getTime();
    AppMethodBeat.o(214986);
    return localCMTime;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(214985);
    if (this.duration == CMTime.CMTimeZero)
    {
      localCMTime = CMTime.CMTimeZero;
      Iterator localIterator = this.segments.iterator();
      while (localIterator.hasNext()) {
        localCMTime = localCMTime.add(((DecoderTrackSegment)localIterator.next()).getScaledDuration());
      }
      this.duration = localCMTime;
    }
    CMTime localCMTime = this.duration;
    AppMethodBeat.o(214985);
    return localCMTime;
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public int getFrameRate()
  {
    return this.frameRate;
  }
  
  public int getTrackId()
  {
    return this.trackId;
  }
  
  public CMSampleBuffer readSample()
  {
    AppMethodBeat.i(215002);
    if (this.lastSampleState.isInvalid())
    {
      localCMSampleBuffer = readSample(CMTime.CMTimeZero);
      AppMethodBeat.o(215002);
      return localCMSampleBuffer;
    }
    CMSampleBuffer localCMSampleBuffer = readSample(this.lastSampleState.getTime().add(this.frameDuration));
    AppMethodBeat.o(215002);
    return localCMSampleBuffer;
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(215003);
    logVerbose("readSample: start expectFrameTime = ".concat(String.valueOf(paramCMTime)));
    if (this.isReleased)
    {
      releaseDecoder();
      paramCMTime = createSampleBuffer(CMSampleState.fromError(-100L));
      AppMethodBeat.o(215003);
      return paramCMTime;
    }
    if (paramCMTime.bigThan(getDuration()))
    {
      releaseDecoder();
      paramCMTime = createSampleBuffer(CMSampleState.fromError(-1L));
      AppMethodBeat.o(215003);
      return paramCMTime;
    }
    if ((this.currentFrame != null) && (this.currentFrame.getTime().getTimeUs() >= 0L) && (this.currentFrame.getTextureInfo() != null) && (!this.currentFrame.getTime().smallThan(paramCMTime)))
    {
      this.lastSampleState = new CMSampleState(paramCMTime);
      paramCMTime = createSampleBuffer(this.lastSampleState, this.currentFrame.getTextureInfo(), false);
      AppMethodBeat.o(215003);
      return paramCMTime;
    }
    logVerbose("readSample: step 1 ");
    Object localObject2 = paramCMTime.sub(this.frameDuration).add(new CMTime(1L, paramCMTime.timeScale));
    if ((findSegmentIndexAt(paramCMTime, false) == this.segmentIndex) && (this.nextFrame != null) && (this.nextFrame.getState().getStateCode() >= 0L) && (this.decodeType == IDecoder.DecodeType.Video)) {}
    boolean bool;
    for (;;)
    {
      synchronized (this.nextFrameDecoderLock)
      {
        if ((this.nextFrame == null) || (this.nextFrame.getState().getStateCode() < -1L) || ((this.nextFrame.getTextureInfo() == null) && (this.nextFrame.getSampleByteBuffer() == null)))
        {
          logVerbose("readSample:" + localObject2 + " nextFrame not hit time");
          this.nextFrame = doReadSample((CMTime)localObject2);
        }
        logVerbose("readSample: step 2 ");
        bool = needSwitchNextFrame(this.currentFrame, this.nextFrame, paramCMTime);
        localObject2 = new StringBuilder("readSample: needSwitch: ").append(bool).append(" expectFrameTime = ").append(paramCMTime).append(" currentFrame = ");
        if (this.currentFrame != null) {
          break label523;
        }
        ??? = CMTime.CMTimeZero;
        logVerbose(??? + "  nextFrame = " + this.nextFrame);
        if (!bool) {
          break;
        }
        ??? = switchToNextFrame();
        if (??? == null) {
          break;
        }
        AppMethodBeat.o(215003);
        return ???;
      }
      logVerbose("readSample:" + localObject2 + " nextFrame not hit");
      if (findSegmentIndexAt(paramCMTime, false) != this.segmentIndex)
      {
        this.nextFrame = doReadSample(paramCMTime);
      }
      else
      {
        this.nextFrame = doReadSample((CMTime)localObject2);
        continue;
        label523:
        ??? = this.currentFrame.getTime();
      }
    }
    logVerbose("readSample: step 3 ");
    createNextDecoder(this.segmentIndex);
    this.lastSampleState = new CMSampleState(paramCMTime);
    logVerbose("readSample: step 4 ");
    paramCMTime = createSampleBuffer(bool);
    AppMethodBeat.o(215003);
    return paramCMTime;
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 819
    //   5: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 139	com/tencent/tav/decoder/VideoDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderThread;
    //   12: invokevirtual 820	com/tencent/tav/decoder/VideoDecoderTrack$DecoderThread:release	()V
    //   15: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   18: ldc_w 822
    //   21: aload_0
    //   22: invokestatic 776	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   25: invokevirtual 668	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   28: invokestatic 611	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 128	com/tencent/tav/decoder/VideoDecoderTrack:isReleased	Z
    //   36: aload_0
    //   37: getfield 99	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   40: invokevirtual 825	java/util/ArrayList:clear	()V
    //   43: aload_0
    //   44: getfield 229	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   47: ifnull +31 -> 78
    //   50: aload_0
    //   51: getfield 229	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   54: iconst_1
    //   55: invokeinterface 483 2 0
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 229	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   65: invokeinterface 487 1 0
    //   70: invokespecial 827	com/tencent/tav/decoder/VideoDecoderTrack:release	(Landroid/view/Surface;)V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 229	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   78: aload_0
    //   79: getfield 122	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   82: astore_1
    //   83: aload_1
    //   84: monitorenter
    //   85: aload_0
    //   86: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   89: ifnull +15 -> 104
    //   92: aload_0
    //   93: getfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   96: invokestatic 831	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:access$300	(Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;)V
    //   99: aload_0
    //   100: aconst_null
    //   101: putfield 285	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   104: aload_1
    //   105: monitorexit
    //   106: aload_0
    //   107: getfield 132	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   110: ifnull +23 -> 133
    //   113: aload_0
    //   114: getfield 132	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   117: invokevirtual 557	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   120: ifnull +13 -> 133
    //   123: aload_0
    //   124: getfield 132	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   127: invokevirtual 557	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   130: invokevirtual 834	com/tencent/tav/coremedia/TextureInfo:release	()V
    //   133: aload_0
    //   134: getfield 130	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   137: ifnull +39 -> 176
    //   140: aload_0
    //   141: getfield 130	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   144: instanceof 530
    //   147: ifeq +29 -> 176
    //   150: aload_0
    //   151: getfield 130	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   154: checkcast 530	com/tencent/tav/decoder/CacheSampleBuffer
    //   157: invokevirtual 711	com/tencent/tav/decoder/CacheSampleBuffer:getTexture	()Lcom/tencent/tav/decoder/VideoTexture;
    //   160: ifnull +16 -> 176
    //   163: aload_0
    //   164: getfield 130	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   167: checkcast 530	com/tencent/tav/decoder/CacheSampleBuffer
    //   170: invokevirtual 711	com/tencent/tav/decoder/CacheSampleBuffer:getTexture	()Lcom/tencent/tav/decoder/VideoTexture;
    //   173: invokevirtual 835	com/tencent/tav/decoder/VideoTexture:release	()V
    //   176: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   179: ldc_w 837
    //   182: invokestatic 611	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: ldc_w 819
    //   188: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_0
    //   192: monitorexit
    //   193: return
    //   194: astore_2
    //   195: aload_1
    //   196: monitorexit
    //   197: ldc_w 819
    //   200: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_2
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	VideoDecoderTrack
    //   205	4	1	localObject2	Object
    //   194	10	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   85	104	194	finally
    //   104	106	194	finally
    //   195	197	194	finally
    //   2	78	205	finally
    //   78	85	205	finally
    //   106	133	205	finally
    //   133	176	205	finally
    //   176	191	205	finally
    //   197	205	205	finally
  }
  
  /* Error */
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 839
    //   6: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: new 364	java/lang/StringBuilder
    //   13: dup
    //   14: ldc_w 841
    //   17: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: ldc_w 843
    //   27: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_2
    //   31: invokevirtual 382	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: ldc_w 845
    //   37: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_3
    //   41: invokevirtual 382	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: ldc_w 847
    //   47: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 260	com/tencent/tav/decoder/VideoDecoderTrack:logVerbose	(Ljava/lang/String;)V
    //   56: aload_0
    //   57: getfield 126	com/tencent/tav/decoder/VideoDecoderTrack:nextFrameDecoderLock	Ljava/lang/Object;
    //   60: astore 6
    //   62: aload 6
    //   64: monitorenter
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 132	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   70: aload_0
    //   71: aconst_null
    //   72: putfield 130	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   75: aload 6
    //   77: monitorexit
    //   78: aload_0
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield 145	com/tencent/tav/decoder/VideoDecoderTrack:started	Z
    //   84: ifeq +10 -> 94
    //   87: aload_0
    //   88: getfield 128	com/tencent/tav/decoder/VideoDecoderTrack:isReleased	Z
    //   91: ifeq +70 -> 161
    //   94: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   97: new 364	java/lang/StringBuilder
    //   100: dup
    //   101: ldc_w 849
    //   104: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: getfield 145	com/tencent/tav/decoder/VideoDecoderTrack:started	Z
    //   111: invokevirtual 382	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   114: ldc_w 851
    //   117: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: getfield 128	com/tencent/tav/decoder/VideoDecoderTrack:isReleased	Z
    //   124: invokevirtual 382	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   127: ldc_w 847
    //   130: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 479	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: monitorexit
    //   141: ldc_w 839
    //   144: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_1
    //   150: aload 6
    //   152: monitorexit
    //   153: ldc_w 839
    //   156: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_1
    //   160: athrow
    //   161: aload_0
    //   162: aload_1
    //   163: iconst_1
    //   164: invokespecial 307	com/tencent/tav/decoder/VideoDecoderTrack:findSegmentIndexAt	(Lcom/tencent/tav/coremedia/CMTime;Z)I
    //   167: istore 4
    //   169: iload 4
    //   171: iconst_m1
    //   172: if_icmpne +48 -> 220
    //   175: aload_0
    //   176: iconst_m1
    //   177: putfield 108	com/tencent/tav/decoder/VideoDecoderTrack:segmentIndex	I
    //   180: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   183: new 364	java/lang/StringBuilder
    //   186: dup
    //   187: ldc_w 853
    //   190: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: iload 4
    //   195: invokevirtual 856	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: ldc_w 847
    //   201: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 479	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_0
    //   211: monitorexit
    //   212: ldc_w 839
    //   215: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aconst_null
    //   219: areturn
    //   220: aload_0
    //   221: iload 4
    //   223: invokespecial 311	com/tencent/tav/decoder/VideoDecoderTrack:getSegmentStartTime	(I)Lcom/tencent/tav/coremedia/CMTime;
    //   226: astore 6
    //   228: aload_0
    //   229: getfield 108	com/tencent/tav/decoder/VideoDecoderTrack:segmentIndex	I
    //   232: iload 4
    //   234: if_icmpne +10 -> 244
    //   237: aload_0
    //   238: getfield 229	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   241: ifnonnull +17 -> 258
    //   244: aload_0
    //   245: iload 4
    //   247: iconst_1
    //   248: isub
    //   249: putfield 108	com/tencent/tav/decoder/VideoDecoderTrack:segmentIndex	I
    //   252: aload_0
    //   253: iconst_0
    //   254: invokespecial 615	com/tencent/tav/decoder/VideoDecoderTrack:nextSegment	(Z)Z
    //   257: pop
    //   258: aload_1
    //   259: aload 6
    //   261: invokevirtual 320	com/tencent/tav/coremedia/CMTime:sub	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   264: aload_0
    //   265: getfield 143	com/tencent/tav/decoder/VideoDecoderTrack:_speed	F
    //   268: invokevirtual 599	com/tencent/tav/coremedia/CMTime:multi	(F)Lcom/tencent/tav/coremedia/CMTime;
    //   271: astore 6
    //   273: aload_0
    //   274: invokespecial 577	com/tencent/tav/decoder/VideoDecoderTrack:getCurrentSegment	()Lcom/tencent/tav/decoder/DecoderTrackSegment;
    //   277: astore 7
    //   279: aload_0
    //   280: getfield 229	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   283: ifnonnull +34 -> 317
    //   286: aload_0
    //   287: new 115	com/tencent/tav/coremedia/CMSampleState
    //   290: dup
    //   291: aload_1
    //   292: invokespecial 584	com/tencent/tav/coremedia/CMSampleState:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   295: putfield 118	com/tencent/tav/decoder/VideoDecoderTrack:lastSampleState	Lcom/tencent/tav/coremedia/CMSampleState;
    //   298: getstatic 69	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   301: ldc_w 858
    //   304: invokestatic 479	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload_0
    //   308: monitorexit
    //   309: ldc_w 839
    //   312: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aconst_null
    //   316: areturn
    //   317: aload_0
    //   318: getfield 229	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   321: aload 7
    //   323: invokevirtual 413	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   326: aload 6
    //   328: invokevirtual 342	com/tencent/tav/coremedia/CMTime:add	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   331: iload_3
    //   332: invokeinterface 861 3 0
    //   337: aload_1
    //   338: aload_0
    //   339: getfield 92	com/tencent/tav/decoder/VideoDecoderTrack:frameDuration	Lcom/tencent/tav/coremedia/CMTime;
    //   342: invokevirtual 591	com/tencent/tav/coremedia/CMTime:bigThan	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   345: ifeq +94 -> 439
    //   348: aload_0
    //   349: new 115	com/tencent/tav/coremedia/CMSampleState
    //   352: dup
    //   353: aload_1
    //   354: aload_0
    //   355: getfield 92	com/tencent/tav/decoder/VideoDecoderTrack:frameDuration	Lcom/tencent/tav/coremedia/CMTime;
    //   358: invokevirtual 320	com/tencent/tav/coremedia/CMTime:sub	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   361: invokespecial 584	com/tencent/tav/coremedia/CMSampleState:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   364: putfield 118	com/tencent/tav/decoder/VideoDecoderTrack:lastSampleState	Lcom/tencent/tav/coremedia/CMSampleState;
    //   367: aload 5
    //   369: astore_1
    //   370: iload_2
    //   371: ifeq +8 -> 379
    //   374: aload_0
    //   375: invokevirtual 863	com/tencent/tav/decoder/VideoDecoderTrack:readSample	()Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   378: astore_1
    //   379: aload_0
    //   380: aconst_null
    //   381: putfield 132	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   384: aload_0
    //   385: aconst_null
    //   386: putfield 130	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   389: aload_0
    //   390: new 364	java/lang/StringBuilder
    //   393: dup
    //   394: ldc_w 865
    //   397: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   400: aload_0
    //   401: getfield 118	com/tencent/tav/decoder/VideoDecoderTrack:lastSampleState	Lcom/tencent/tav/coremedia/CMSampleState;
    //   404: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   407: ldc_w 867
    //   410: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload_1
    //   414: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: ldc_w 847
    //   420: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokespecial 260	com/tencent/tav/decoder/VideoDecoderTrack:logVerbose	(Ljava/lang/String;)V
    //   429: aload_0
    //   430: monitorexit
    //   431: ldc_w 839
    //   434: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: aload_1
    //   438: areturn
    //   439: aload_0
    //   440: new 115	com/tencent/tav/coremedia/CMSampleState
    //   443: dup
    //   444: aload_1
    //   445: invokespecial 584	com/tencent/tav/coremedia/CMSampleState:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   448: putfield 118	com/tencent/tav/decoder/VideoDecoderTrack:lastSampleState	Lcom/tencent/tav/coremedia/CMSampleState;
    //   451: goto -84 -> 367
    //   454: astore_1
    //   455: aload_0
    //   456: monitorexit
    //   457: ldc_w 839
    //   460: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   463: aload_1
    //   464: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	VideoDecoderTrack
    //   0	465	1	paramCMTime	CMTime
    //   0	465	2	paramBoolean1	boolean
    //   0	465	3	paramBoolean2	boolean
    //   167	82	4	i	int
    //   1	367	5	localObject1	Object
    //   60	267	6	localObject2	Object
    //   277	45	7	localDecoderTrackSegment	DecoderTrackSegment
    // Exception table:
    //   from	to	target	type
    //   65	78	149	finally
    //   150	153	149	finally
    //   80	94	454	finally
    //   94	141	454	finally
    //   161	169	454	finally
    //   175	212	454	finally
    //   220	244	454	finally
    //   244	258	454	finally
    //   258	309	454	finally
    //   317	367	454	finally
    //   374	379	454	finally
    //   379	431	454	finally
    //   439	451	454	finally
    //   455	457	454	finally
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.decodeType = paramDecodeType;
  }
  
  public void setFrameRate(int paramInt)
  {
    AppMethodBeat.i(214983);
    this.frameRate = paramInt;
    this.frameDuration = new CMTime(600 / paramInt, 600);
    AppMethodBeat.o(214983);
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    AppMethodBeat.i(214984);
    if (this.segments == null) {
      this.segments = new ArrayList();
    }
    this.segments.clear();
    this.segments.addAll(paramList);
    AppMethodBeat.o(214984);
  }
  
  public void setVolume(float paramFloat) {}
  
  public void start()
  {
    AppMethodBeat.i(214995);
    start(null);
    AppMethodBeat.o(214995);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    AppMethodBeat.i(214996);
    start(paramSurfaceCreator, null);
    AppMethodBeat.o(214996);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(214997);
    Logger.d(TAG, "VideoDecoderTrack start:".concat(String.valueOf(paramCMTimeRange)));
    if (this.segments.size() == 0)
    {
      release();
      AppMethodBeat.o(214997);
      return;
    }
    this.isReleased = false;
    this.started = true;
    this.surfaceCreator = paramSurfaceCreator;
    this.segmentIndex = -1;
    this.decoderThread.start();
    clipRangeAndRemoveRange(paramCMTimeRange);
    nextSegment(true);
    Logger.d(TAG, "VideoDecoderTrack start finish:");
    AppMethodBeat.o(214997);
  }
  
  class DecoderCreateThread
    extends Thread
  {
    private Surface outputSurface;
    private int segmentIndex;
    DecoderAssetTrack videoAsset;
    
    private DecoderCreateThread(DecoderAssetTrack paramDecoderAssetTrack, Surface paramSurface, int paramInt)
    {
      super();
      AppMethodBeat.i(214970);
      this.videoAsset = paramDecoderAssetTrack;
      this.outputSurface = paramSurface;
      this.segmentIndex = paramInt;
      AppMethodBeat.o(214970);
    }
    
    private void checkCreateDecoder()
    {
      AppMethodBeat.i(214972);
      if ((VideoDecoderTrack.this.nextDecoder != null) && (ExtractorUtils.isSameExtractor(VideoDecoderTrack.this.nextDecoder.extractor, this.videoAsset)))
      {
        AppMethodBeat.o(214972);
        return;
      }
      if (VideoDecoderTrack.this.nextDecoder == null)
      {
        createDecoder();
        AppMethodBeat.o(214972);
        return;
      }
      Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread create - " + this.videoAsset.assetPath);
      if ((VideoDecoderTrack.this.nextDecoder.decoder != null) && (VideoDecoderTrack.this.nextDecoder.decoder != VideoDecoderTrack.this.currentDecoder)) {
        releaseNextDecoder();
      }
      createDecoder();
      AppMethodBeat.o(214972);
    }
    
    private void createDecoder()
    {
      AppMethodBeat.i(214973);
      if ((VideoDecoderTrack.this.segments == null) || (this.segmentIndex >= VideoDecoderTrack.this.segments.size()))
      {
        AppMethodBeat.o(214973);
        return;
      }
      Object localObject1;
      for (;;)
      {
        try
        {
          localSurface = this.outputSurface;
          if (this.videoAsset.sourceType == 3)
          {
            localObject2 = new ImageDecoder();
            localObject1 = localObject2;
          }
        }
        catch (Exception localException1)
        {
          Surface localSurface;
          Object localObject2;
          localObject1 = null;
        }
        try
        {
          VideoDecoderTrack.access$1200(VideoDecoderTrack.this, localSurface);
          localObject1 = localObject2;
          ((IVideoDecoder)localObject2).init(this.videoAsset.assetPath, ImageDecoder.IMAGE_DECODE_SIZE, null);
          localObject1 = localObject2;
          ((IVideoDecoder)localObject2).start(VideoDecoderTrack.access$1300(VideoDecoderTrack.this, this.segmentIndex).getTimeRange(), VideoDecoderTrack.access$1300(VideoDecoderTrack.this, this.segmentIndex).getDecoderStartTime());
          localObject1 = localObject2;
          VideoDecoderTrack.access$902(VideoDecoderTrack.this, new VideoDecoderTrack.DecoderWrapper(VideoDecoderTrack.this, null));
          localObject1 = localObject2;
          VideoDecoderTrack.this.nextDecoder.outputSurface = localSurface;
          localObject1 = localObject2;
          VideoDecoderTrack.this.nextDecoder.decoder = ((IVideoDecoder)localObject2);
          localObject1 = localObject2;
          VideoDecoderTrack.this.nextDecoder.extractor = this.videoAsset;
          localObject1 = localObject2;
          VideoDecoderTrack.this.nextDecoder.segmentIndex = this.segmentIndex;
          localObject1 = localObject2;
          Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread success - " + this.videoAsset.assetPath);
          AppMethodBeat.o(214973);
          return;
        }
        catch (Exception localException2)
        {
          break;
        }
        localObject2 = new VideoDecoder(this.videoAsset.assetPath, localSurface);
      }
      Logger.e(VideoDecoderTrack.TAG, "createDecoder: ", localException1);
      VideoDecoderTrack.access$500(VideoDecoderTrack.this, localObject1);
      AppMethodBeat.o(214973);
    }
    
    private void releaseNextDecoder()
    {
      AppMethodBeat.i(214974);
      synchronized (VideoDecoderTrack.this.nextDecoderLock)
      {
        if (VideoDecoderTrack.this.nextDecoder != null)
        {
          VideoDecoderTrack.DecoderWrapper.access$300(VideoDecoderTrack.this.nextDecoder);
          VideoDecoderTrack.access$902(VideoDecoderTrack.this, null);
        }
        AppMethodBeat.o(214974);
        return;
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(214971);
      ??? = VideoDecoderTrack.TAG;
      StringBuilder localStringBuilder = new StringBuilder("DecoderCreateThread start - ").append(this.videoAsset.assetPath).append(" - ");
      if (this.outputSurface != null) {}
      for (boolean bool = true;; bool = false)
      {
        Logger.d((String)???, bool);
        if (!VideoDecoderTrack.this.isReleased) {
          break;
        }
        VideoDecoderTrack.access$702(VideoDecoderTrack.this, null);
        AppMethodBeat.o(214971);
        return;
      }
      synchronized (VideoDecoderTrack.this.nextDecoderLock)
      {
        checkCreateDecoder();
        VideoDecoderTrack.access$702(VideoDecoderTrack.this, null);
        if (VideoDecoderTrack.this.isReleased) {
          releaseNextDecoder();
        }
        Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread finish - " + this.videoAsset.assetPath);
        AppMethodBeat.o(214971);
        return;
      }
    }
  }
  
  class DecoderThread
    extends ReActionThread
  {
    private static final String NAME = "VideoDecoder";
    
    private DecoderThread()
    {
      super();
    }
    
    private void doActionInDecoderLock()
    {
      AppMethodBeat.i(214976);
      if (VideoDecoderTrack.this.nextFrame == null)
      {
        AppMethodBeat.o(214976);
        return;
      }
      if (VideoDecoderTrack.this.lastSampleState.isInvalid())
      {
        VideoDecoderTrack.access$1800(VideoDecoderTrack.this, "DecoderThread doAction: CMTime.CMTimeZero");
        VideoDecoderTrack.access$1602(VideoDecoderTrack.this, VideoDecoderTrack.access$1900(VideoDecoderTrack.this, CMTime.CMTimeZero, true));
        AppMethodBeat.o(214976);
        return;
      }
      if (VideoDecoderTrack.this.lastSampleState.getStateCode() >= 0L)
      {
        VideoDecoderTrack.access$1800(VideoDecoderTrack.this, "DecoderThread doAction: lastSampleTime.add(frameDuration) ");
        VideoDecoderTrack.access$1602(VideoDecoderTrack.this, VideoDecoderTrack.access$1900(VideoDecoderTrack.this, VideoDecoderTrack.this.nextFrame.getTime(), true));
      }
      AppMethodBeat.o(214976);
    }
    
    protected void doAction()
    {
      AppMethodBeat.i(214975);
      synchronized (VideoDecoderTrack.this.nextFrameDecoderLock)
      {
        doActionInDecoderLock();
        AppMethodBeat.o(214975);
        return;
      }
    }
  }
  
  class DecoderWrapper
  {
    IVideoDecoder decoder;
    DecoderAssetTrack extractor;
    Surface outputSurface;
    int segmentIndex = -1;
    
    private DecoderWrapper() {}
    
    private void release()
    {
      AppMethodBeat.i(214977);
      Logger.d(VideoDecoderTrack.TAG, "Video DecoderWrapper release: ");
      VideoDecoderTrack.access$500(VideoDecoderTrack.this, this.decoder);
      AppMethodBeat.o(214977);
    }
  }
  
  class ReleaseDecoderThread
    extends Thread
  {
    private IVideoDecoder decoder;
    
    ReleaseDecoderThread(IVideoDecoder paramIVideoDecoder)
    {
      super();
      this.decoder = paramIVideoDecoder;
    }
    
    private void doRelease()
    {
      AppMethodBeat.i(214980);
      if (this.decoder != null)
      {
        Logger.d(VideoDecoderTrack.TAG, "ReleaseDecoderThread start");
        this.decoder.release(true);
        VideoDecoderTrack.access$1200(VideoDecoderTrack.this, this.decoder.outputSurface());
        this.decoder = null;
        Logger.d(VideoDecoderTrack.TAG, "ReleaseDecoderThread end");
      }
      AppMethodBeat.o(214980);
    }
    
    public void run()
    {
      AppMethodBeat.i(214979);
      doRelease();
      AppMethodBeat.o(214979);
    }
    
    public void start()
    {
      AppMethodBeat.i(214981);
      if (!(this.decoder instanceof VideoDecoder)) {
        doRelease();
      }
      super.start();
      AppMethodBeat.o(214981);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack
 * JD-Core Version:    0.7.0.1
 */