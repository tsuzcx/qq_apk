package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
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
  private CMTime lastSampleTime;
  private DecoderWrapper nextDecoder;
  private final Object nextDecoderLock;
  private CMSampleBuffer nextFrame;
  private final Object nextFrameDecoderLock;
  private int segmentIndex;
  private ArrayList<DecoderTrackSegment> segments;
  private boolean started;
  private IDecoderTrack.SurfaceCreator surfaceCreator;
  private int trackId;
  
  public VideoDecoderTrack(int paramInt)
  {
    AppMethodBeat.i(201894);
    this.frameDuration = new CMTime(1L, 44);
    this.frameRate = 44;
    this.segments = new ArrayList();
    this.decodeType = IDecoder.DecodeType.Video;
    this.segmentIndex = -1;
    this.currentSegmentStartTime = CMTime.CMTimeZero;
    this.lastSampleTime = CMTime.CMTimeInvalid;
    this.decoderCreateThread = null;
    this.nextDecoderLock = new Object();
    this.currentDecoderLock = new Object();
    this.nextFrameDecoderLock = new Object();
    this.isReleased = false;
    this.nextFrame = null;
    this.currentFrame = null;
    this.duration = CMTime.CMTimeZero;
    this.decoderThread = new DecoderThread(null);
    this._speed = 1.0F;
    this.started = false;
    this.surfaceCreator = null;
    this.trackId = paramInt;
    AppMethodBeat.o(201894);
  }
  
  private void clipRangeAndRemoveRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(201903);
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(201903);
      return;
    }
    CMTime localCMTime2 = paramCMTimeRange.getStart();
    CMTime localCMTime1 = paramCMTimeRange.getEnd();
    int k = findSegmentIndexAt(localCMTime2, false);
    if (k == -1)
    {
      AppMethodBeat.o(201903);
      return;
    }
    int i = findSegmentIndexAt(localCMTime1, false);
    if (i == -1) {
      i = this.segments.size() - 1;
    }
    label466:
    for (;;)
    {
      CMTime localCMTime3 = getSegmentStartTime(k);
      localCMTime2 = getSegmentStartTime(i);
      DecoderTrackSegment localDecoderTrackSegment1 = (DecoderTrackSegment)this.segments.get(k);
      DecoderTrackSegment localDecoderTrackSegment2 = (DecoderTrackSegment)this.segments.get(i);
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
      int j = this.segments.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if ((j > i) || (j < k)) {
            this.segments.remove(j);
          }
          j -= 1;
          continue;
          if (getSegmentStartTime(i) != localCMTime1) {
            break label466;
          }
          i -= 1;
          break;
        }
      }
      if (getSegmentStartTime(i + 1).smallThan(paramCMTimeRange.getEnd()))
      {
        paramCMTimeRange = new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, localCMTime1.sub(localDecoderTrackSegment2.getScaledDuration().add(localCMTime2))), null);
        this.segments.add(paramCMTimeRange);
      }
      AppMethodBeat.o(201903);
      return;
    }
  }
  
  /* Error */
  private IVideoDecoder createDecoder(DecoderTrackSegment paramDecoderTrackSegment, CMTime paramCMTime)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc_w 275
    //   8: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_1
    //   12: invokevirtual 279	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   15: astore 11
    //   17: aload 11
    //   19: ifnonnull +15 -> 34
    //   22: ldc_w 275
    //   25: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: getstatic 72	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   37: astore 7
    //   39: new 281	java/lang/StringBuilder
    //   42: dup
    //   43: ldc_w 283
    //   46: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload 11
    //   51: getfield 291	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   54: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 297
    //   60: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: astore 8
    //   65: aload_0
    //   66: getfield 143	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   69: ifnull +290 -> 359
    //   72: iconst_1
    //   73: istore 5
    //   75: aload 7
    //   77: aload 8
    //   79: iload 5
    //   81: invokevirtual 300	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   84: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: iconst_0
    //   88: anewarray 4	java/lang/Object
    //   91: invokestatic 308	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: iconst_5
    //   95: istore_3
    //   96: aconst_null
    //   97: astore 7
    //   99: aload 7
    //   101: ifnonnull +785 -> 886
    //   104: iload_3
    //   105: ifle +781 -> 886
    //   108: iload_3
    //   109: iconst_1
    //   110: isub
    //   111: istore_3
    //   112: aload_0
    //   113: getfield 118	com/tencent/tav/decoder/VideoDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;
    //   116: ifnull +417 -> 533
    //   119: aload_0
    //   120: getfield 118	com/tencent/tav/decoder/VideoDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;
    //   123: invokestatic 312	com/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread:access$100	(Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;)I
    //   126: istore 4
    //   128: iload 4
    //   130: aload_0
    //   131: getfield 97	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   134: invokevirtual 202	java/util/ArrayList:size	()I
    //   137: if_icmpge +237 -> 374
    //   140: aload_0
    //   141: getfield 97	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   144: iload 4
    //   146: invokevirtual 221	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   149: checkcast 223	com/tencent/tav/decoder/DecoderTrackSegment
    //   152: invokevirtual 279	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   155: aload 11
    //   157: invokestatic 318	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   160: ifeq +214 -> 374
    //   163: getstatic 72	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   166: new 281	java/lang/StringBuilder
    //   169: dup
    //   170: ldc_w 320
    //   173: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: aload 11
    //   178: getfield 291	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   181: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: iconst_0
    //   188: anewarray 4	java/lang/Object
    //   191: invokestatic 308	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: aload_0
    //   195: getfield 120	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   198: astore 8
    //   200: aload 8
    //   202: monitorenter
    //   203: aload_0
    //   204: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   207: ifnull +164 -> 371
    //   210: aload_0
    //   211: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   214: getfield 324	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   217: aload 11
    //   219: invokestatic 318	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   222: ifeq +149 -> 371
    //   225: aload_0
    //   226: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   229: getfield 327	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   232: ifnull +139 -> 371
    //   235: aload_0
    //   236: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   239: getfield 327	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   242: astore_2
    //   243: aload_0
    //   244: getfield 97	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   247: aload_0
    //   248: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   251: getfield 328	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:segmentIndex	I
    //   254: invokevirtual 221	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   257: aload_1
    //   258: if_acmpeq +17 -> 275
    //   261: aload_2
    //   262: aload_1
    //   263: invokevirtual 227	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   266: aload_1
    //   267: invokevirtual 331	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   270: invokeinterface 337 3 0
    //   275: aload_0
    //   276: aconst_null
    //   277: putfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   280: getstatic 72	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   283: astore_1
    //   284: new 281	java/lang/StringBuilder
    //   287: dup
    //   288: ldc_w 339
    //   291: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   294: astore 7
    //   296: aload_0
    //   297: getfield 143	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   300: ifnonnull +65 -> 365
    //   303: iload 6
    //   305: istore 5
    //   307: aload_1
    //   308: aload 7
    //   310: iload 5
    //   312: invokevirtual 300	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   315: ldc_w 341
    //   318: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_2
    //   322: invokeinterface 344 1 0
    //   327: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 308	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: aload 8
    //   342: monitorexit
    //   343: ldc_w 275
    //   346: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: aload_2
    //   350: astore_1
    //   351: goto -321 -> 30
    //   354: astore_1
    //   355: aload_0
    //   356: monitorexit
    //   357: aload_1
    //   358: athrow
    //   359: iconst_0
    //   360: istore 5
    //   362: goto -287 -> 75
    //   365: iconst_0
    //   366: istore 5
    //   368: goto -61 -> 307
    //   371: aload 8
    //   373: monitorexit
    //   374: aload_0
    //   375: getfield 143	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   378: ifnull +537 -> 915
    //   381: aload 11
    //   383: getfield 347	com/tencent/tav/decoder/DecoderAssetTrack:size	Lcom/tencent/tav/coremedia/CGSize;
    //   386: astore 8
    //   388: aload 11
    //   390: getfield 350	com/tencent/tav/decoder/DecoderAssetTrack:preferRotation	I
    //   393: istore 4
    //   395: aload 8
    //   397: ifnull +518 -> 915
    //   400: aload_0
    //   401: getfield 143	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   404: aload 8
    //   406: getfield 355	com/tencent/tav/coremedia/CGSize:width	F
    //   409: f2i
    //   410: aload 8
    //   412: getfield 358	com/tencent/tav/coremedia/CGSize:height	F
    //   415: f2i
    //   416: iload 4
    //   418: invokeinterface 364 4 0
    //   423: astore 8
    //   425: aload 7
    //   427: astore 9
    //   429: aload 11
    //   431: getfield 367	com/tencent/tav/decoder/DecoderAssetTrack:sourceType	I
    //   434: iconst_3
    //   435: if_icmpne +341 -> 776
    //   438: aload 7
    //   440: astore 9
    //   442: new 369	com/tencent/tav/decoder/ImageDecoder
    //   445: dup
    //   446: invokespecial 370	com/tencent/tav/decoder/ImageDecoder:<init>	()V
    //   449: astore 7
    //   451: aload 7
    //   453: aload 11
    //   455: getfield 291	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   458: getstatic 373	com/tencent/tav/decoder/ImageDecoder:IMAGE_DECODE_SIZE	Lcom/tencent/tav/coremedia/CGSize;
    //   461: aconst_null
    //   462: invokeinterface 377 4 0
    //   467: aload 7
    //   469: astore 9
    //   471: aload 7
    //   473: aload_1
    //   474: invokevirtual 227	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   477: aload_2
    //   478: invokeinterface 337 3 0
    //   483: aload 7
    //   485: astore 9
    //   487: getstatic 72	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   490: new 281	java/lang/StringBuilder
    //   493: dup
    //   494: ldc_w 379
    //   497: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   500: aload 11
    //   502: getfield 291	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   505: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: iconst_0
    //   512: anewarray 4	java/lang/Object
    //   515: invokestatic 308	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   518: goto -419 -> 99
    //   521: astore_1
    //   522: aload 8
    //   524: monitorexit
    //   525: ldc_w 275
    //   528: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   531: aload_1
    //   532: athrow
    //   533: getstatic 72	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   536: new 281	java/lang/StringBuilder
    //   539: dup
    //   540: ldc_w 381
    //   543: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   546: aload 11
    //   548: getfield 291	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   551: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: iconst_0
    //   558: anewarray 4	java/lang/Object
    //   561: invokestatic 308	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   564: aload_0
    //   565: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   568: ifnull -194 -> 374
    //   571: aload_0
    //   572: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   575: getfield 324	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   578: aload 11
    //   580: invokestatic 318	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   583: ifeq -209 -> 374
    //   586: aload_0
    //   587: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   590: getfield 327	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   593: ifnull -219 -> 374
    //   596: aload_0
    //   597: getfield 120	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   600: astore 8
    //   602: aload 8
    //   604: monitorenter
    //   605: aload_0
    //   606: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   609: ifnull +149 -> 758
    //   612: aload_0
    //   613: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   616: getfield 324	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   619: aload 11
    //   621: if_acmpne +137 -> 758
    //   624: aload_0
    //   625: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   628: getfield 327	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   631: ifnull +127 -> 758
    //   634: aload_0
    //   635: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   638: getfield 327	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   641: astore_2
    //   642: aload_0
    //   643: getfield 97	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   646: aload_0
    //   647: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   650: getfield 328	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:segmentIndex	I
    //   653: invokevirtual 221	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   656: aload_1
    //   657: if_acmpeq +17 -> 674
    //   660: aload_2
    //   661: aload_1
    //   662: invokevirtual 227	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   665: aload_1
    //   666: invokevirtual 331	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   669: invokeinterface 337 3 0
    //   674: aload_0
    //   675: aconst_null
    //   676: putfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   679: getstatic 72	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   682: astore_1
    //   683: new 281	java/lang/StringBuilder
    //   686: dup
    //   687: ldc_w 339
    //   690: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   693: astore 7
    //   695: aload_0
    //   696: getfield 143	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   699: ifnonnull +53 -> 752
    //   702: iconst_1
    //   703: istore 5
    //   705: aload_1
    //   706: aload 7
    //   708: iload 5
    //   710: invokevirtual 300	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   713: ldc_w 341
    //   716: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload_2
    //   720: invokeinterface 344 1 0
    //   725: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: iconst_0
    //   732: anewarray 4	java/lang/Object
    //   735: invokestatic 308	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   738: aload 8
    //   740: monitorexit
    //   741: ldc_w 275
    //   744: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   747: aload_2
    //   748: astore_1
    //   749: goto -719 -> 30
    //   752: iconst_0
    //   753: istore 5
    //   755: goto -50 -> 705
    //   758: aload 8
    //   760: monitorexit
    //   761: goto -387 -> 374
    //   764: astore_1
    //   765: aload 8
    //   767: monitorexit
    //   768: ldc_w 275
    //   771: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   774: aload_1
    //   775: athrow
    //   776: aload 7
    //   778: astore 9
    //   780: new 383	com/tencent/tav/decoder/VideoDecoder
    //   783: dup
    //   784: aload 11
    //   786: getfield 291	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   789: aload 8
    //   791: invokespecial 386	com/tencent/tav/decoder/VideoDecoder:<init>	(Ljava/lang/String;Landroid/view/Surface;)V
    //   794: astore 7
    //   796: goto -329 -> 467
    //   799: astore 10
    //   801: getstatic 72	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   804: new 281	java/lang/StringBuilder
    //   807: dup
    //   808: ldc_w 388
    //   811: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   814: aload 10
    //   816: invokevirtual 391	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   819: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload 10
    //   824: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: invokestatic 398	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   833: aload_0
    //   834: aload 8
    //   836: invokespecial 178	com/tencent/tav/decoder/VideoDecoderTrack:free	(Landroid/view/Surface;)V
    //   839: aload 7
    //   841: ifnull +22 -> 863
    //   844: aload 7
    //   846: iconst_1
    //   847: invokeinterface 402 2 0
    //   852: aload_0
    //   853: aload 7
    //   855: invokeinterface 406 1 0
    //   860: invokespecial 178	com/tencent/tav/decoder/VideoDecoderTrack:free	(Landroid/view/Surface;)V
    //   863: aconst_null
    //   864: astore 7
    //   866: goto -767 -> 99
    //   869: astore 7
    //   871: aconst_null
    //   872: astore 7
    //   874: goto -775 -> 99
    //   877: astore_1
    //   878: ldc_w 275
    //   881: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   884: aload_1
    //   885: athrow
    //   886: ldc_w 275
    //   889: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   892: aload 7
    //   894: astore_1
    //   895: goto -865 -> 30
    //   898: astore 10
    //   900: aload 9
    //   902: astore 7
    //   904: goto -103 -> 801
    //   907: astore 10
    //   909: aconst_null
    //   910: astore 8
    //   912: goto -111 -> 801
    //   915: aconst_null
    //   916: astore 8
    //   918: goto -493 -> 425
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	921	0	this	VideoDecoderTrack
    //   0	921	1	paramDecoderTrackSegment	DecoderTrackSegment
    //   0	921	2	paramCMTime	CMTime
    //   95	17	3	i	int
    //   126	291	4	j	int
    //   73	681	5	bool1	boolean
    //   1	303	6	bool2	boolean
    //   37	828	7	localObject1	Object
    //   869	1	7	localException1	Exception
    //   872	31	7	localObject2	Object
    //   63	854	8	localObject3	Object
    //   427	474	9	localObject4	Object
    //   799	24	10	localException2	Exception
    //   898	1	10	localException3	Exception
    //   907	1	10	localException4	Exception
    //   15	770	11	localDecoderAssetTrack	DecoderAssetTrack
    // Exception table:
    //   from	to	target	type
    //   5	17	354	finally
    //   22	28	354	finally
    //   34	72	354	finally
    //   75	94	354	finally
    //   112	203	354	finally
    //   343	349	354	finally
    //   374	395	354	finally
    //   400	425	354	finally
    //   429	438	354	finally
    //   442	451	354	finally
    //   451	467	354	finally
    //   471	483	354	finally
    //   487	518	354	finally
    //   525	533	354	finally
    //   533	605	354	finally
    //   741	747	354	finally
    //   768	776	354	finally
    //   780	796	354	finally
    //   801	839	354	finally
    //   878	886	354	finally
    //   886	892	354	finally
    //   203	275	521	finally
    //   275	303	521	finally
    //   307	343	521	finally
    //   371	374	521	finally
    //   522	525	521	finally
    //   605	674	764	finally
    //   674	702	764	finally
    //   705	741	764	finally
    //   758	761	764	finally
    //   765	768	764	finally
    //   451	467	799	java/lang/Exception
    //   844	863	869	java/lang/Exception
    //   844	863	877	finally
    //   429	438	898	java/lang/Exception
    //   442	451	898	java/lang/Exception
    //   471	483	898	java/lang/Exception
    //   487	518	898	java/lang/Exception
    //   780	796	898	java/lang/Exception
    //   374	395	907	java/lang/Exception
    //   400	425	907	java/lang/Exception
  }
  
  private void createDecoder(DecoderAssetTrack paramDecoderAssetTrack, int paramInt)
  {
    AppMethodBeat.i(201925);
    try
    {
      if ((this.surfaceCreator != null) && (paramDecoderAssetTrack.size != null))
      {
        CGSize localCGSize = paramDecoderAssetTrack.size;
        int i = paramDecoderAssetTrack.preferRotation;
        this.decoderCreateThread = new DecoderCreateThread(paramDecoderAssetTrack, this.surfaceCreator.createOutputSurface((int)localCGSize.width, (int)localCGSize.height, i), paramInt, null);
        this.decoderCreateThread.start();
      }
      AppMethodBeat.o(201925);
      return;
    }
    catch (Exception paramDecoderAssetTrack)
    {
      Logger.e(TAG, "createNextDecoder: try start DecoderCreateThread", paramDecoderAssetTrack);
      AppMethodBeat.o(201925);
    }
  }
  
  private void createNextDecoder(int paramInt)
  {
    AppMethodBeat.i(201924);
    if ((this.segments == null) || (!PRE_READ))
    {
      AppMethodBeat.o(201924);
      return;
    }
    int i = paramInt + 1;
    if (i >= this.segments.size())
    {
      AppMethodBeat.o(201924);
      return;
    }
    if (this.decoderCreateThread == null)
    {
      DecoderAssetTrack localDecoderAssetTrack = ((DecoderTrackSegment)this.segments.get(i)).getVideoAsset();
      if (localDecoderAssetTrack != null)
      {
        if ((this.nextDecoder == null) || (!ExtractorUtils.isSameExtractor(this.nextDecoder.extractor, localDecoderAssetTrack)))
        {
          createDecoder(localDecoderAssetTrack, i);
          AppMethodBeat.o(201924);
        }
      }
      else if ((this.nextDecoder != null) && (this.nextDecoder.segmentIndex != paramInt))
      {
        this.nextDecoder.decoder.start(((DecoderTrackSegment)this.segments.get(paramInt)).getTimeRange());
        this.nextDecoder.segmentIndex = paramInt;
      }
    }
    AppMethodBeat.o(201924);
  }
  
  private CMSampleBuffer createSampleBuffer(CMTime paramCMTime)
  {
    AppMethodBeat.i(201917);
    paramCMTime = new CMSampleBuffer(paramCMTime);
    AppMethodBeat.o(201917);
    return paramCMTime;
  }
  
  private CMSampleBuffer createSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(201919);
    paramCMTime = new CMSampleBuffer(paramCMTime, paramTextureInfo, paramBoolean);
    AppMethodBeat.o(201919);
    return paramCMTime;
  }
  
  private CMSampleBuffer createSampleBuffer(CMTime paramCMTime, VideoTexture paramVideoTexture, boolean paramBoolean)
  {
    AppMethodBeat.i(201918);
    if (paramVideoTexture == null) {}
    for (TextureInfo localTextureInfo = null;; localTextureInfo = paramVideoTexture.getTextureInfo())
    {
      paramCMTime = new CacheSampleBuffer(paramCMTime, localTextureInfo, paramBoolean);
      paramCMTime.setTexture(paramVideoTexture);
      AppMethodBeat.o(201918);
      return paramCMTime;
    }
  }
  
  private CMSampleBuffer doReadSample(CMTime paramCMTime)
  {
    try
    {
      AppMethodBeat.i(201915);
      paramCMTime = doReadSample(paramCMTime, false);
      AppMethodBeat.o(201915);
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
    CMTime localCMTime1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    boolean bool = true;
    DecoderTrackSegment localDecoderTrackSegment;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(201916);
        if (LOG_VERBOSE) {
          Logger.d(TAG, "doReadSample: step 1 ");
        }
        if (this.isReleased)
        {
          paramCMTime = createSampleBuffer(IDecoder.SAMPLE_TIME_UNSTART);
          AppMethodBeat.o(201916);
          return paramCMTime;
        }
        if (paramCMTime == null)
        {
          paramCMTime = createSampleBuffer(IDecoder.SAMPLE_TIME_ERROR);
          AppMethodBeat.o(201916);
          continue;
        }
        localObject1 = VideoDecoder.SAMPLE_TIME_FINISH;
      }
      finally {}
      if (this.segmentIndex == -1)
      {
        if (!this.lastSampleTime.smallThan(IDecoder.SAMPLE_TIME_FINISH))
        {
          paramCMTime = createSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
          AppMethodBeat.o(201916);
        }
        else
        {
          paramCMTime = createSampleBuffer(VideoDecoder.SAMPLE_TIME_UNSTART);
          AppMethodBeat.o(201916);
        }
      }
      else
      {
        localDecoderTrackSegment = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
        i = 0;
        label164:
        if (LOG_VERBOSE) {
          Logger.d(TAG, "doReadSample: step 2 ");
        }
        CMTime localCMTime2;
        if (this.currentDecoder == null)
        {
          this.lastSampleTime = this.lastSampleTime.add(this.frameDuration);
          localCMTime2 = this.currentSegmentStartTime.add(localDecoderTrackSegment.getScaledDuration());
          if (this.lastSampleTime.smallThan(localCMTime2))
          {
            if (this.surfaceCreator == null)
            {
              paramCMTime = createSampleBuffer(this.lastSampleTime);
              AppMethodBeat.o(201916);
              continue;
            }
            paramCMTime = createSampleBuffer(this.lastSampleTime, this.surfaceCreator.videoTextureForSurface(this._outputSurface), false);
            AppMethodBeat.o(201916);
          }
        }
        else
        {
          localCMTime2 = paramCMTime.sub(this.currentSegmentStartTime).multi(this._speed);
          localObject1 = localCMTime2;
          if (localCMTime2.value < 0L) {
            localObject1 = CMTime.CMTimeZero;
          }
          if ((float)((CMTime)localObject1).getTimeUs() <= (float)localDecoderTrackSegment.getScaledDuration().getTimeUs() * this._speed) {
            break;
          }
          localObject1 = VideoDecoder.SAMPLE_TIME_FINISH;
        }
        label349:
        if ((!((CMTime)localObject1).equalsTo(VideoDecoder.SAMPLE_TIME_FINISH)) && (!((CMTime)localObject1).bigThan(localDecoderTrackSegment.getTimeRange().getDuration()))) {
          break label720;
        }
        if (!localDecoderTrackSegment.getScaledDuration().add(this.currentSegmentStartTime).sub(this.frameDuration).bigThan(paramCMTime)) {
          break label582;
        }
        if (!(this.currentDecoder instanceof VideoDecoder)) {
          break label514;
        }
        localObject1 = this.surfaceCreator.videoTextureForSurface(this._outputSurface);
        if ((i == 0) || (this.currentDecoder == null) || (!this.currentDecoder.isLastFrameValid())) {
          break label976;
        }
        paramBoolean = bool;
        label453:
        paramCMTime = createSampleBuffer(paramCMTime, (VideoTexture)localObject1, paramBoolean);
        AppMethodBeat.o(201916);
      }
    }
    Object localObject1 = ((CMTime)localObject1).add(localDecoderTrackSegment.getDecoderStartTime());
    if (this.currentDecoder == null)
    {
      localObject1 = IDecoder.SAMPLE_TIME_UNSTART;
    }
    else
    {
      localObject1 = this.currentDecoder.readSample((CMTime)localObject1);
      break label971;
      label514:
      if (this.currentDecoder == null)
      {
        localObject1 = localObject3;
        label525:
        if ((i == 0) || (this.currentDecoder == null) || (!this.currentDecoder.isLastFrameValid())) {
          break label981;
        }
      }
    }
    label582:
    label720:
    label981:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramCMTime = createSampleBuffer(paramCMTime, (TextureInfo)localObject1, paramBoolean);
      AppMethodBeat.o(201916);
      break;
      localObject1 = this.currentDecoder.getTextureInfo();
      break label525;
      if (paramBoolean)
      {
        Logger.e(TAG, "async read finish , skip it!");
        AppMethodBeat.o(201916);
        paramCMTime = null;
        break;
      }
      if (!nextSegment(true))
      {
        if ((this.currentDecoder instanceof VideoDecoder))
        {
          paramCMTime = createSampleBuffer(VideoDecoder.SAMPLE_TIME_FINISH, this.surfaceCreator.videoTextureForSurface(this._outputSurface), false);
          AppMethodBeat.o(201916);
          break;
        }
        localObject1 = VideoDecoder.SAMPLE_TIME_FINISH;
        if (this.currentDecoder == null) {}
        for (paramCMTime = localCMTime1;; paramCMTime = this.currentDecoder.getTextureInfo())
        {
          paramCMTime = createSampleBuffer((CMTime)localObject1, paramCMTime, false);
          AppMethodBeat.o(201916);
          break;
        }
      }
      localDecoderTrackSegment = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
      break label164;
      if (((CMTime)localObject1).getTimeUs() < 0L)
      {
        if (!((CMTime)localObject1).equalsTo(VideoDecoder.SAMPLE_TIME_ERROR))
        {
          paramCMTime = createSampleBuffer(this.lastSampleTime);
          AppMethodBeat.o(201916);
          break;
        }
        paramCMTime = createSampleBuffer((CMTime)localObject1);
        AppMethodBeat.o(201916);
        break;
      }
      if (LOG_VERBOSE) {
        Logger.d(TAG, "doReadSample: step 3 ");
      }
      localCMTime1 = ((CMTime)localObject1).sub(localDecoderTrackSegment.getDecoderStartTime());
      localObject1 = localCMTime1;
      if (localCMTime1.bigThan(localDecoderTrackSegment.getTimeRange().getDuration())) {
        localObject1 = localDecoderTrackSegment.getTimeRange().getDuration();
      }
      localObject1 = this.currentSegmentStartTime.add(((CMTime)localObject1).divide(this._speed));
      if (LOG_VERBOSE) {
        Logger.d(TAG, "readSample: currentTime = " + paramCMTime + "  sampleTime = " + localObject1);
      }
      if ((this.currentDecoder instanceof VideoDecoder))
      {
        paramCMTime = createSampleBuffer((CMTime)localObject1, this.surfaceCreator.videoTextureForSurface(this._outputSurface), true);
        AppMethodBeat.o(201916);
        break;
      }
      if (this.currentDecoder == null) {}
      for (paramCMTime = localObject2;; paramCMTime = this.currentDecoder.getTextureInfo())
      {
        paramCMTime = createSampleBuffer((CMTime)localObject1, paramCMTime, true);
        AppMethodBeat.o(201916);
        break;
      }
      i = 1;
      break label349;
      paramBoolean = false;
      break label453;
    }
  }
  
  private int findSegmentIndexAt(CMTime paramCMTime, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(201895);
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
        AppMethodBeat.o(201895);
        return i;
        localCMTime1 = localCMTime1.add(localCMTime2);
        i += 1;
        break;
      }
      AppMethodBeat.o(201895);
      return -1;
    }
  }
  
  private void free(Surface paramSurface)
  {
    AppMethodBeat.i(201907);
    if (paramSurface != null) {}
    try
    {
      this.surfaceCreator.free(paramSurface);
      AppMethodBeat.o(201907);
      return;
    }
    catch (Exception paramSurface)
    {
      Logger.e(TAG, "free", paramSurface);
      AppMethodBeat.o(201907);
    }
  }
  
  private CMTime getSegmentStartTime(int paramInt)
  {
    AppMethodBeat.i(201896);
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while ((i < paramInt) && (i < this.segments.size()))
    {
      localCMTime = CMTime.add(localCMTime, ((DecoderTrackSegment)this.segments.get(i)).getScaledDuration());
      i += 1;
    }
    AppMethodBeat.o(201896);
    return localCMTime;
  }
  
  private boolean needSwitchNextFrame(CMSampleBuffer paramCMSampleBuffer1, CMSampleBuffer paramCMSampleBuffer2, CMTime paramCMTime)
  {
    AppMethodBeat.i(201920);
    if ((paramCMSampleBuffer1 == null) || (paramCMSampleBuffer2.getTime().smallThan(CMTime.CMTimeZero)))
    {
      AppMethodBeat.o(201920);
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
        AppMethodBeat.o(201920);
        return true;
      }
    }
    if (Math.abs(l2) >= Math.abs(l1))
    {
      AppMethodBeat.o(201920);
      return true;
    }
    AppMethodBeat.o(201920);
    return false;
  }
  
  private boolean nextSegment(boolean paramBoolean)
  {
    AppMethodBeat.i(201908);
    Logger.d(TAG, "nextSegment:".concat(String.valueOf(paramBoolean)));
    this.segmentIndex += 1;
    this._outputSurface = null;
    if (this.segmentIndex >= this.segments.size())
    {
      this.segmentIndex = -1;
      AppMethodBeat.o(201908);
      return false;
    }
    this.currentSegmentStartTime = getSegmentStartTime(this.segmentIndex);
    this.lastSampleTime = this.currentSegmentStartTime;
    Object localObject2 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
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
          ??? = ((DecoderTrackSegment)this.segments.get(this.segmentIndex)).getDecoderStartTime();
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
          break label428;
        }
        paramBoolean = true;
        Logger.d((String)???, paramBoolean + " " + this._speed);
        AppMethodBeat.o(201908);
        return true;
        localObject3 = finally;
        AppMethodBeat.o(201908);
        throw localObject3;
        ??? = CMTime.CMTimeInvalid;
      }
      Logger.e(TAG, "nextSegment: videoAsset is null");
      synchronized (this.currentDecoderLock)
      {
        if (this.currentDecoder != null)
        {
          new ReleaseDecoderThread(this.currentDecoder).start();
          this.currentDecoder = null;
        }
      }
      label428:
      paramBoolean = false;
    }
  }
  
  private void release(Surface paramSurface)
  {
    AppMethodBeat.i(201906);
    if (paramSurface != null) {}
    try
    {
      paramSurface.release();
      AppMethodBeat.o(201906);
      return;
    }
    catch (Exception paramSurface)
    {
      Logger.e(TAG, "release", paramSurface);
      AppMethodBeat.o(201906);
    }
  }
  
  private void releaseDecoder()
  {
    AppMethodBeat.i(201914);
    if (this.currentDecoder != null) {
      synchronized (this.currentDecoderLock)
      {
        if ((this.currentDecoder != null) && (this.currentDecoder.getSourcePath() != null))
        {
          new ReleaseDecoderThread(this.currentDecoder).start();
          this.currentDecoder = null;
        }
        AppMethodBeat.o(201914);
        return;
      }
    }
    AppMethodBeat.o(201914);
  }
  
  private CMSampleBuffer switchToNextFrame()
  {
    AppMethodBeat.i(201913);
    this.currentFrame = createSampleBuffer(this.nextFrame.getTime(), this.nextFrame.getTextureInfo(), this.nextFrame.isNewFrame());
    Object localObject;
    if ((this.nextFrame.isNewFrame()) && ((this.nextFrame instanceof CacheSampleBuffer)))
    {
      localObject = ((CacheSampleBuffer)this.nextFrame).getTexture();
      if ((localObject != null) && (!Thread.currentThread().getName().equals("VideoDecoder"))) {
        if (LOG_VERBOSE) {
          Logger.d(TAG, "readSample: awaitNewImage: " + this.nextFrame.getTime());
        }
      }
    }
    try
    {
      ((VideoTexture)localObject).awaitNewImage();
      this.nextFrame = createSampleBuffer(CMTime.CMTimeInvalid);
      if (this.currentFrame.getTime().smallThan(CMTime.CMTimeZero))
      {
        this.lastSampleTime = this.currentFrame.getTime();
        localObject = createSampleBuffer(this.currentFrame.getTime());
        AppMethodBeat.o(201913);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e(TAG, "readSample: videoTexture.awaitNewImage() error", localThrowable);
      CMSampleBuffer localCMSampleBuffer = createSampleBuffer(IDecoder.SAMPLE_TIME_ERROR);
      AppMethodBeat.o(201913);
      return localCMSampleBuffer;
    }
    AppMethodBeat.o(201913);
    return null;
  }
  
  private boolean unNeedReDecoderNextFrame(CMTime paramCMTime)
  {
    AppMethodBeat.i(201922);
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
      AppMethodBeat.o(201922);
      return true;
      i = 0;
      break;
    }
    label91:
    AppMethodBeat.o(201922);
    return false;
  }
  
  public void asyncReadNextSample(CMTime arg1)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(201921);
        if (unNeedReDecoderNextFrame(???))
        {
          AppMethodBeat.o(201921);
          return;
        }
        if (this.isReleased)
        {
          AppMethodBeat.o(201921);
          continue;
        }
        this.nextFrame = new CMSampleBuffer(???);
      }
      finally {}
      synchronized (this.decoderThread)
      {
        this.decoderThread.action();
        AppMethodBeat.o(201921);
      }
    }
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(201902);
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(201902);
      return;
    }
    CMTime localCMTime1 = paramCMTimeRange.getStart();
    CMTime localCMTime2 = paramCMTimeRange.getEnd();
    CMTime localCMTime3 = duration();
    clipRangeAndRemoveRange(paramCMTimeRange);
    if (localCMTime1.getValue() != 0L) {
      this.segments.add(0, new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, localCMTime1), null));
    }
    if (localCMTime2.getTimeUs() < localCMTime3.getTimeUs()) {
      this.segments.add(new DecoderTrackSegment(new CMTimeRange(localCMTime2, new CMTime(localCMTime3.getTimeSeconds() - localCMTime2.getTimeSeconds())), null));
    }
    AppMethodBeat.o(201902);
  }
  
  public CMTime duration()
  {
    AppMethodBeat.i(201897);
    CMTime localCMTime = getSegmentStartTime(this.segments.size());
    AppMethodBeat.o(201897);
    return localCMTime;
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.lastSampleTime;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(201923);
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
    AppMethodBeat.o(201923);
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
  
  public CGSize getMaxRenderSize()
  {
    AppMethodBeat.i(201927);
    Object localObject1 = new CGSize(1.0F, 1.0F);
    Iterator localIterator = this.segments.iterator();
    Object localObject2;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject2 = (DecoderTrackSegment)localIterator.next();
      if ((localObject2 == null) || (((DecoderTrackSegment)localObject2).getVideoAsset() == null)) {
        break label104;
      }
      localObject2 = ((DecoderTrackSegment)localObject2).getVideoAsset().size;
      if (localObject2 == null) {
        break label104;
      }
    } while (((CGSize)localObject1).width * ((CGSize)localObject1).height > ((CGSize)localObject2).width * ((CGSize)localObject2).height);
    label104:
    for (;;)
    {
      localObject1 = localObject2;
      continue;
      AppMethodBeat.o(201927);
      return localObject1;
    }
  }
  
  public int getTrackId()
  {
    return this.trackId;
  }
  
  public boolean hasNewSample(CMTime paramCMTime)
  {
    boolean bool2 = false;
    AppMethodBeat.i(201911);
    if ((this.nextFrame != null) && (!this.nextFrame.getTime().bigThan(paramCMTime)))
    {
      Object localObject = this.nextFrameDecoderLock;
      boolean bool1 = bool2;
      try
      {
        if (this.nextFrame != null)
        {
          bool1 = bool2;
          if (!this.nextFrame.getTime().bigThan(paramCMTime)) {
            bool1 = true;
          }
        }
        return bool1;
      }
      finally
      {
        AppMethodBeat.o(201911);
      }
    }
    AppMethodBeat.o(201911);
    return false;
  }
  
  public CMSampleBuffer readSample()
  {
    AppMethodBeat.i(201910);
    if (this.lastSampleTime == CMTime.CMTimeInvalid)
    {
      localCMSampleBuffer = readSample(CMTime.CMTimeZero);
      AppMethodBeat.o(201910);
      return localCMSampleBuffer;
    }
    CMSampleBuffer localCMSampleBuffer = readSample(this.lastSampleTime.add(this.frameDuration));
    AppMethodBeat.o(201910);
    return localCMSampleBuffer;
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(201912);
    if (LOG_VERBOSE) {
      Logger.d(TAG, "readSample: start expectFrameTime = ".concat(String.valueOf(paramCMTime)));
    }
    if (this.isReleased)
    {
      releaseDecoder();
      paramCMTime = createSampleBuffer(IDecoder.SAMPLE_TIME_UNSTART);
      AppMethodBeat.o(201912);
      return paramCMTime;
    }
    if (paramCMTime.bigThan(getDuration()))
    {
      releaseDecoder();
      paramCMTime = createSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
      AppMethodBeat.o(201912);
      return paramCMTime;
    }
    if ((this.currentFrame != null) && (this.currentFrame.getTime().getTimeUs() >= 0L) && (this.currentFrame.getTextureInfo() != null) && (!this.currentFrame.getTime().smallThan(paramCMTime)))
    {
      this.lastSampleTime = paramCMTime;
      paramCMTime = createSampleBuffer(this.lastSampleTime, this.currentFrame.getTextureInfo(), false);
      AppMethodBeat.o(201912);
      return paramCMTime;
    }
    if (LOG_VERBOSE) {
      Logger.d(TAG, "readSample: step 1 ");
    }
    Object localObject2 = paramCMTime.sub(this.frameDuration).add(new CMTime(1L, paramCMTime.timeScale));
    if ((findSegmentIndexAt(paramCMTime, false) == this.segmentIndex) && (this.nextFrame != null) && (this.nextFrame.getTime().getTimeUs() >= 0L) && (this.decodeType == IDecoder.DecodeType.Video)) {}
    boolean bool;
    for (;;)
    {
      synchronized (this.nextFrameDecoderLock)
      {
        if ((this.nextFrame == null) || (this.nextFrame.getTime().getTimeUs() < IDecoder.SAMPLE_TIME_FINISH.getTimeUs()) || ((this.nextFrame.getTextureInfo() == null) && (this.nextFrame.getSampleByteBuffer() == null)))
        {
          if (LOG_VERBOSE) {
            Logger.d(TAG, "readSample:" + localObject2 + " nextFrame not hit time");
          }
          this.nextFrame = doReadSample((CMTime)localObject2);
        }
        if (LOG_VERBOSE) {
          Logger.d(TAG, "readSample: step 2 ");
        }
        bool = needSwitchNextFrame(this.currentFrame, this.nextFrame, paramCMTime);
        if (LOG_VERBOSE)
        {
          localObject2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder("readSample: needSwitch: ").append(bool).append(" expectFrameTime = ").append(paramCMTime).append(" currentFrame = ");
          if (this.currentFrame != null) {
            break label565;
          }
          ??? = CMTime.CMTimeZero;
          Logger.d((String)localObject2, ??? + "  nextFrame = " + this.nextFrame);
        }
        if (!bool) {
          break;
        }
        ??? = switchToNextFrame();
        if (??? == null) {
          break;
        }
        AppMethodBeat.o(201912);
        return ???;
      }
      if (LOG_VERBOSE) {
        Logger.d(TAG, "readSample:" + localObject2 + " nextFrame not hit");
      }
      if (findSegmentIndexAt(paramCMTime, false) != this.segmentIndex)
      {
        this.nextFrame = doReadSample(paramCMTime);
      }
      else
      {
        this.nextFrame = doReadSample((CMTime)localObject2);
        continue;
        label565:
        ??? = this.currentFrame.getTime();
      }
    }
    if (LOG_VERBOSE) {
      Logger.d(TAG, "readSample: step 3 ");
    }
    createNextDecoder(this.segmentIndex);
    this.lastSampleTime = paramCMTime;
    if (LOG_VERBOSE) {
      Logger.d(TAG, "readSample: step 4 ");
    }
    if (this.currentFrame != null)
    {
      paramCMTime = createSampleBuffer(this.lastSampleTime, this.currentFrame.getTextureInfo(), bool);
      AppMethodBeat.o(201912);
      return paramCMTime;
    }
    ??? = this.lastSampleTime;
    if (this.currentDecoder == null) {}
    for (paramCMTime = null;; paramCMTime = this.currentDecoder.getTextureInfo())
    {
      paramCMTime = createSampleBuffer((CMTime)???, paramCMTime, bool);
      AppMethodBeat.o(201912);
      return paramCMTime;
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 722
    //   5: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 137	com/tencent/tav/decoder/VideoDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderThread;
    //   12: invokevirtual 723	com/tencent/tav/decoder/VideoDecoderTrack$DecoderThread:release	()V
    //   15: getstatic 72	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   18: ldc_w 725
    //   21: aload_0
    //   22: invokestatic 681	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   25: invokevirtual 572	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   28: invokestatic 458	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 126	com/tencent/tav/decoder/VideoDecoderTrack:isReleased	Z
    //   36: aload_0
    //   37: getfield 97	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   40: invokevirtual 728	java/util/ArrayList:clear	()V
    //   43: aload_0
    //   44: getfield 152	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   47: ifnull +31 -> 78
    //   50: aload_0
    //   51: getfield 152	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   54: iconst_1
    //   55: invokeinterface 402 2 0
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 152	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   65: invokeinterface 406 1 0
    //   70: invokespecial 730	com/tencent/tav/decoder/VideoDecoderTrack:release	(Landroid/view/Surface;)V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 152	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   78: aload_0
    //   79: getfield 120	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   82: astore_1
    //   83: aload_1
    //   84: monitorenter
    //   85: aload_0
    //   86: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   89: ifnull +15 -> 104
    //   92: aload_0
    //   93: getfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   96: invokestatic 734	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:access$300	(Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;)V
    //   99: aload_0
    //   100: aconst_null
    //   101: putfield 187	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   104: aload_1
    //   105: monitorexit
    //   106: aload_0
    //   107: getfield 130	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   110: ifnull +23 -> 133
    //   113: aload_0
    //   114: getfield 130	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   117: invokevirtual 605	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   120: ifnull +13 -> 133
    //   123: aload_0
    //   124: getfield 130	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   127: invokevirtual 605	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   130: invokevirtual 737	com/tencent/tav/coremedia/TextureInfo:release	()V
    //   133: aload_0
    //   134: getfield 128	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   137: ifnull +39 -> 176
    //   140: aload_0
    //   141: getfield 128	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   144: instanceof 440
    //   147: ifeq +29 -> 176
    //   150: aload_0
    //   151: getfield 128	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   154: checkcast 440	com/tencent/tav/decoder/CacheSampleBuffer
    //   157: invokevirtual 609	com/tencent/tav/decoder/CacheSampleBuffer:getTexture	()Lcom/tencent/tav/decoder/VideoTexture;
    //   160: ifnull +16 -> 176
    //   163: aload_0
    //   164: getfield 128	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   167: checkcast 440	com/tencent/tav/decoder/CacheSampleBuffer
    //   170: invokevirtual 609	com/tencent/tav/decoder/CacheSampleBuffer:getTexture	()Lcom/tencent/tav/decoder/VideoTexture;
    //   173: invokevirtual 738	com/tencent/tav/decoder/VideoTexture:release	()V
    //   176: getstatic 72	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   179: ldc_w 740
    //   182: invokestatic 458	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: ldc_w 722
    //   188: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_0
    //   192: monitorexit
    //   193: return
    //   194: astore_2
    //   195: aload_1
    //   196: monitorexit
    //   197: ldc_w 722
    //   200: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201909);
    if (LOG_VERBOSE) {
      Logger.d(TAG, "seekTo:[timeUs " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    }
    synchronized (this.nextFrameDecoderLock)
    {
      this.currentFrame = null;
      this.nextFrame = null;
    }
    for (;;)
    {
      try
      {
        if ((!this.started) || (this.isReleased))
        {
          Logger.e(TAG, "seekTo: [failed] [started " + this.started + "] [isReleased " + this.isReleased + "]");
          return null;
          paramCMTime = finally;
          throw paramCMTime;
        }
        int i = findSegmentIndexAt(paramCMTime, true);
        if (i == -1)
        {
          this.segmentIndex = -1;
          Logger.e(TAG, "seekTo: [failed] [index " + i + "]");
          return null;
        }
        ??? = getSegmentStartTime(i);
        if ((this.segmentIndex != i) || (this.currentDecoder == null))
        {
          this.segmentIndex = (i - 1);
          nextSegment(false);
        }
        ??? = paramCMTime.sub((CMTime)???).multi(this._speed);
        DecoderTrackSegment localDecoderTrackSegment = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
        if (this.currentDecoder == null)
        {
          this.lastSampleTime = paramCMTime;
          Logger.e(TAG, "seekTo: [failed] [currentDecoder == null]");
          return null;
        }
        this.currentDecoder.seekTo(localDecoderTrackSegment.getDecoderStartTime().add((CMTime)???), paramBoolean2);
        if (paramCMTime.bigThan(this.frameDuration))
        {
          this.lastSampleTime = paramCMTime.sub(this.frameDuration);
          if (paramBoolean1)
          {
            paramCMTime = readSample();
            this.currentFrame = null;
            this.nextFrame = null;
            if (LOG_VERBOSE) {
              Logger.d(TAG, "seekTo: [success] [lastSampleTime " + this.lastSampleTime + "] [sampleBuffer " + paramCMTime + "]");
            }
            return paramCMTime;
          }
        }
        else
        {
          this.lastSampleTime = paramCMTime;
          continue;
        }
        paramCMTime = null;
      }
      finally
      {
        AppMethodBeat.o(201909);
      }
    }
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.decodeType = paramDecodeType;
  }
  
  public void setFrameRate(int paramInt)
  {
    AppMethodBeat.i(201901);
    this.frameRate = paramInt;
    this.frameDuration = new CMTime(600 / paramInt, 600);
    AppMethodBeat.o(201901);
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    AppMethodBeat.i(201904);
    if (this.segments == null) {
      this.segments = new ArrayList();
    }
    this.segments.clear();
    this.segments.addAll(paramList);
    AppMethodBeat.o(201904);
  }
  
  public void setVolume(float paramFloat) {}
  
  public float speed()
  {
    return this._speed;
  }
  
  public void start()
  {
    AppMethodBeat.i(201898);
    start(null);
    AppMethodBeat.o(201898);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    AppMethodBeat.i(201899);
    start(paramSurfaceCreator, null);
    AppMethodBeat.o(201899);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(201900);
    Logger.d(TAG, "VideoDecoderTrack start:".concat(String.valueOf(paramCMTimeRange)));
    if (this.segments.size() == 0)
    {
      release();
      AppMethodBeat.o(201900);
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
    AppMethodBeat.o(201900);
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
      AppMethodBeat.i(201885);
      this.videoAsset = paramDecoderAssetTrack;
      this.outputSurface = paramSurface;
      this.segmentIndex = paramInt;
      AppMethodBeat.o(201885);
    }
    
    private void createDecoder()
    {
      AppMethodBeat.i(201887);
      if ((VideoDecoderTrack.this.segments == null) || (this.segmentIndex >= VideoDecoderTrack.this.segments.size()))
      {
        AppMethodBeat.o(201887);
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
        catch (Exception localException2)
        {
          Surface localSurface;
          Object localObject2;
          localObject1 = null;
        }
        try
        {
          VideoDecoderTrack.access$500(VideoDecoderTrack.this, localSurface);
          localObject1 = localObject2;
          ((IVideoDecoder)localObject2).init(this.videoAsset.assetPath, ImageDecoder.IMAGE_DECODE_SIZE, null);
          localObject1 = localObject2;
          ((IVideoDecoder)localObject2).start(((DecoderTrackSegment)VideoDecoderTrack.this.segments.get(this.segmentIndex)).getTimeRange(), ((DecoderTrackSegment)VideoDecoderTrack.this.segments.get(this.segmentIndex)).getDecoderStartTime());
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
          AppMethodBeat.o(201887);
          return;
        }
        catch (Exception localException3)
        {
          break;
        }
        localObject2 = new VideoDecoder(this.videoAsset.assetPath, localSurface);
      }
      Logger.e(VideoDecoderTrack.TAG, "createDecoder", localException2);
      if (localObject1 != null) {}
      try
      {
        localObject1.release(true);
        VideoDecoderTrack.access$500(VideoDecoderTrack.this, localObject1.outputSurface());
        AppMethodBeat.o(201887);
        return;
      }
      catch (Exception localException1)
      {
        AppMethodBeat.o(201887);
        return;
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(201886);
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
        AppMethodBeat.o(201886);
        return;
      }
      for (;;)
      {
        synchronized (VideoDecoderTrack.this.nextDecoderLock)
        {
          if ((VideoDecoderTrack.this.nextDecoder == null) || (!ExtractorUtils.isSameExtractor(VideoDecoderTrack.this.nextDecoder.extractor, this.videoAsset)))
          {
            if (VideoDecoderTrack.this.nextDecoder != null)
            {
              Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread create - " + this.videoAsset.assetPath);
              if ((VideoDecoderTrack.this.nextDecoder.decoder != null) && (VideoDecoderTrack.this.nextDecoder.decoder != VideoDecoderTrack.this.currentDecoder))
              {
                VideoDecoderTrack.DecoderWrapper.access$300(VideoDecoderTrack.this.nextDecoder);
                VideoDecoderTrack.access$902(VideoDecoderTrack.this, null);
              }
              createDecoder();
            }
          }
          else
          {
            VideoDecoderTrack.access$702(VideoDecoderTrack.this, null);
            if (!VideoDecoderTrack.this.isReleased) {}
          }
        }
        synchronized (VideoDecoderTrack.this.nextDecoderLock)
        {
          if (VideoDecoderTrack.this.nextDecoder != null)
          {
            VideoDecoderTrack.DecoderWrapper.access$300(VideoDecoderTrack.this.nextDecoder);
            VideoDecoderTrack.access$902(VideoDecoderTrack.this, null);
          }
          Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread finish - " + this.videoAsset.assetPath);
          AppMethodBeat.o(201886);
          return;
          createDecoder();
          continue;
          localObject2 = finally;
          AppMethodBeat.o(201886);
          throw localObject2;
        }
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
    
    protected void doAction()
    {
      AppMethodBeat.i(201888);
      synchronized (VideoDecoderTrack.this.nextFrameDecoderLock)
      {
        if (VideoDecoderTrack.this.nextFrame != null)
        {
          if (VideoDecoderTrack.this.lastSampleTime != CMTime.CMTimeInvalid) {
            break label79;
          }
          if (LOG_VERBOSE) {
            Logger.d(VideoDecoderTrack.TAG, "DecoderThread doAction: CMTime.CMTimeZero");
          }
          VideoDecoderTrack.access$1402(VideoDecoderTrack.this, VideoDecoderTrack.access$1600(VideoDecoderTrack.this, CMTime.CMTimeZero, true));
        }
        label79:
        while (VideoDecoderTrack.this.lastSampleTime.smallThan(CMTime.CMTimeZero))
        {
          AppMethodBeat.o(201888);
          return;
        }
        if (LOG_VERBOSE) {
          Logger.d(VideoDecoderTrack.TAG, "DecoderThread doAction: lastSampleTime.add(frameDuration) ");
        }
        VideoDecoderTrack.access$1402(VideoDecoderTrack.this, VideoDecoderTrack.access$1600(VideoDecoderTrack.this, VideoDecoderTrack.this.nextFrame.getTime(), true));
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
      AppMethodBeat.i(201889);
      Logger.d(VideoDecoderTrack.TAG, "Video DecoderWrapper release: ");
      try
      {
        if (this.decoder != null)
        {
          this.decoder.release(true);
          VideoDecoderTrack.access$500(VideoDecoderTrack.this, this.decoder.outputSurface());
        }
        AppMethodBeat.o(201889);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(201889);
        return;
      }
      catch (Error localError)
      {
        label53:
        break label53;
      }
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
      AppMethodBeat.i(201892);
      if (this.decoder != null)
      {
        Logger.d(VideoDecoderTrack.TAG, "ReleaseDecoderThread start");
        this.decoder.release(true);
        VideoDecoderTrack.access$500(VideoDecoderTrack.this, this.decoder.outputSurface());
        this.decoder = null;
        Logger.d(VideoDecoderTrack.TAG, "ReleaseDecoderThread end");
      }
      AppMethodBeat.o(201892);
    }
    
    public void run()
    {
      AppMethodBeat.i(201891);
      doRelease();
      AppMethodBeat.o(201891);
    }
    
    public void start()
    {
      AppMethodBeat.i(201893);
      if (!(this.decoder instanceof VideoDecoder)) {
        doRelease();
      }
      super.start();
      AppMethodBeat.o(201893);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack
 * JD-Core Version:    0.7.0.1
 */