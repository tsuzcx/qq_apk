package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AudioDecoderTrack
  implements IDecoderTrack
{
  private static String TAG = "AudioDecoderTrack";
  private float _speed;
  private AudioInfo audioInfo;
  private AudioMixer audioMixer;
  private AudioDecoder currentDecoder;
  private final Object currentDecoderLock;
  private CMTime currentSegmentStartTime;
  private IDecoder.DecodeType decodeType;
  private AudioDecoderCreateThread decoderCreateThread;
  private final DecoderThread decoderThread;
  private CMTime duration;
  private ByteBuffer emptyAudioBuffer;
  private CMTime frameDuration;
  private int frameRate;
  private boolean isEmptyFrame;
  private boolean isReleased;
  private CMTime lastSampleTime;
  private DecoderWrapper nextDecoder;
  private final Object nextDecoderLock;
  private boolean preRead;
  private int segmentIndex;
  private ArrayList<DecoderTrackSegment> segments;
  private boolean started;
  private int trackID;
  private float volume;
  
  public AudioDecoderTrack()
  {
    AppMethodBeat.i(197747);
    this.preRead = false;
    this.frameDuration = new CMTime(92880L, 1000000);
    this.frameRate = 11;
    this.volume = 1.0F;
    this.trackID = -1;
    this.segments = new ArrayList();
    this.decodeType = IDecoder.DecodeType.Audio;
    this.segmentIndex = -1;
    this.currentSegmentStartTime = CMTime.CMTimeZero;
    this.lastSampleTime = CMTime.CMTimeInvalid;
    this.decoderCreateThread = null;
    this.nextDecoderLock = new Object();
    this.currentDecoderLock = new Object();
    this.isReleased = false;
    this.decoderThread = new DecoderThread();
    this.audioMixer = new AudioMixer();
    this.audioInfo = new AudioInfo();
    this.isEmptyFrame = false;
    this._speed = 1.0F;
    this.started = false;
    this.duration = CMTime.CMTimeZero;
    AppMethodBeat.o(197747);
  }
  
  /* Error */
  private IDecoder createDecoder(DecoderTrackSegment paramDecoderTrackSegment, CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 201
    //   4: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: invokevirtual 207	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   11: astore 8
    //   13: getstatic 70	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   16: new 209	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 211
    //   22: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload 8
    //   27: getfield 219	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   30: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 225
    //   35: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: iconst_0
    //   42: anewarray 4	java/lang/Object
    //   45: invokestatic 233	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: iconst_5
    //   49: istore_3
    //   50: aconst_null
    //   51: astore 5
    //   53: aload 5
    //   55: ifnonnull +607 -> 662
    //   58: iload_3
    //   59: ifle +603 -> 662
    //   62: iload_3
    //   63: iconst_1
    //   64: isub
    //   65: istore_3
    //   66: aload_0
    //   67: getfield 125	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   70: ifnull +215 -> 285
    //   73: aload_0
    //   74: getfield 125	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   77: invokestatic 237	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:access$000	(Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;)I
    //   80: istore 4
    //   82: iload 4
    //   84: aload_0
    //   85: getfield 104	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   88: invokevirtual 241	java/util/ArrayList:size	()I
    //   91: if_icmpge +161 -> 252
    //   94: aload_0
    //   95: getfield 104	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   98: iload 4
    //   100: invokevirtual 245	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   103: checkcast 203	com/tencent/tav/decoder/DecoderTrackSegment
    //   106: invokevirtual 207	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   109: aload 8
    //   111: invokestatic 171	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   114: ifeq +138 -> 252
    //   117: aload_0
    //   118: getfield 127	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   121: astore 6
    //   123: aload 6
    //   125: monitorenter
    //   126: aload_0
    //   127: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   130: ifnull +119 -> 249
    //   133: aload_0
    //   134: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   137: getfield 249	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   140: aload 8
    //   142: invokestatic 171	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   145: ifeq +104 -> 249
    //   148: aload_0
    //   149: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   152: getfield 253	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   155: ifnull +94 -> 249
    //   158: aload_0
    //   159: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   162: getfield 253	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   165: astore_2
    //   166: aload_0
    //   167: getfield 104	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   170: aload_0
    //   171: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   174: getfield 254	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   177: invokevirtual 245	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   180: aload_1
    //   181: if_acmpeq +17 -> 198
    //   184: aload_2
    //   185: aload_1
    //   186: invokevirtual 258	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   189: aload_1
    //   190: invokevirtual 262	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   193: invokeinterface 268 3 0
    //   198: aload_0
    //   199: aconst_null
    //   200: putfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   203: getstatic 70	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   206: new 209	java/lang/StringBuilder
    //   209: dup
    //   210: ldc_w 270
    //   213: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload_2
    //   217: invokeinterface 273 1 0
    //   222: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 233	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload 6
    //   237: monitorexit
    //   238: ldc 201
    //   240: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aload_2
    //   244: astore_1
    //   245: aload_0
    //   246: monitorexit
    //   247: aload_1
    //   248: areturn
    //   249: aload 6
    //   251: monitorexit
    //   252: aload_1
    //   253: invokevirtual 258	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   256: ifnonnull +266 -> 522
    //   259: ldc 201
    //   261: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aconst_null
    //   265: astore_1
    //   266: goto -21 -> 245
    //   269: astore_1
    //   270: aload 6
    //   272: monitorexit
    //   273: ldc 201
    //   275: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_1
    //   279: athrow
    //   280: astore_1
    //   281: aload_0
    //   282: monitorexit
    //   283: aload_1
    //   284: athrow
    //   285: getstatic 70	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   288: new 209	java/lang/StringBuilder
    //   291: dup
    //   292: ldc_w 275
    //   295: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   298: aload 8
    //   300: getfield 219	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   303: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: iconst_0
    //   310: anewarray 4	java/lang/Object
    //   313: invokestatic 233	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: aload_0
    //   317: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   320: ifnull -68 -> 252
    //   323: aload_0
    //   324: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   327: getfield 249	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   330: aload 8
    //   332: invokestatic 171	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   335: ifeq -83 -> 252
    //   338: aload_0
    //   339: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   342: getfield 253	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   345: ifnull -93 -> 252
    //   348: aload_0
    //   349: getfield 127	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   352: astore 6
    //   354: aload 6
    //   356: monitorenter
    //   357: aload_0
    //   358: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   361: ifnull +144 -> 505
    //   364: aload_0
    //   365: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   368: getfield 249	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   371: aload 8
    //   373: if_acmpne +132 -> 505
    //   376: aload_0
    //   377: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   380: getfield 253	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   383: ifnull +122 -> 505
    //   386: aload_0
    //   387: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   390: getfield 253	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   393: astore_2
    //   394: aload_0
    //   395: getfield 104	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   398: aload_0
    //   399: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   402: getfield 254	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   405: invokevirtual 245	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   408: aload_1
    //   409: if_acmpeq +17 -> 426
    //   412: aload_2
    //   413: aload_1
    //   414: invokevirtual 258	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   417: aload_1
    //   418: invokevirtual 262	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   421: invokeinterface 268 3 0
    //   426: getstatic 70	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   429: new 209	java/lang/StringBuilder
    //   432: dup
    //   433: ldc_w 270
    //   436: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   439: aload_2
    //   440: invokeinterface 273 1 0
    //   445: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: ldc_w 277
    //   451: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_0
    //   455: getfield 113	com/tencent/tav/decoder/AudioDecoderTrack:segmentIndex	I
    //   458: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   461: ldc_w 282
    //   464: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_0
    //   468: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   471: getfield 254	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   474: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   477: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: iconst_0
    //   481: anewarray 4	java/lang/Object
    //   484: invokestatic 233	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   487: aload_0
    //   488: aconst_null
    //   489: putfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   492: aload 6
    //   494: monitorexit
    //   495: ldc 201
    //   497: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   500: aload_2
    //   501: astore_1
    //   502: goto -257 -> 245
    //   505: aload 6
    //   507: monitorexit
    //   508: goto -256 -> 252
    //   511: astore_1
    //   512: aload 6
    //   514: monitorexit
    //   515: ldc 201
    //   517: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   520: aload_1
    //   521: athrow
    //   522: new 284	com/tencent/tav/decoder/AudioDecoder
    //   525: dup
    //   526: aload 8
    //   528: getfield 219	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   531: invokespecial 285	com/tencent/tav/decoder/AudioDecoder:<init>	(Ljava/lang/String;)V
    //   534: astore 6
    //   536: aload 6
    //   538: aload_1
    //   539: invokevirtual 258	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   542: aload_2
    //   543: invokeinterface 268 3 0
    //   548: getstatic 70	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   551: new 209	java/lang/StringBuilder
    //   554: dup
    //   555: ldc_w 287
    //   558: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   561: aload 8
    //   563: getfield 219	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   566: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: iconst_0
    //   573: anewarray 4	java/lang/Object
    //   576: invokestatic 233	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   579: aload 6
    //   581: astore 5
    //   583: goto -530 -> 53
    //   586: astore 7
    //   588: aload 6
    //   590: astore 5
    //   592: aload 7
    //   594: astore 6
    //   596: getstatic 70	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   599: new 209	java/lang/StringBuilder
    //   602: dup
    //   603: ldc_w 289
    //   606: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   609: aload 6
    //   611: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   614: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload 6
    //   619: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 299	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 5
    //   630: ifnull +10 -> 640
    //   633: aload 5
    //   635: invokeinterface 302 1 0
    //   640: aconst_null
    //   641: astore 5
    //   643: goto -590 -> 53
    //   646: astore 5
    //   648: aconst_null
    //   649: astore 5
    //   651: goto -598 -> 53
    //   654: astore_1
    //   655: ldc 201
    //   657: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   660: aload_1
    //   661: athrow
    //   662: ldc 201
    //   664: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   667: aload 5
    //   669: astore_1
    //   670: goto -425 -> 245
    //   673: astore 6
    //   675: goto -79 -> 596
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	678	0	this	AudioDecoderTrack
    //   0	678	1	paramDecoderTrackSegment	DecoderTrackSegment
    //   0	678	2	paramCMTime	CMTime
    //   49	17	3	i	int
    //   80	19	4	j	int
    //   51	591	5	localObject1	Object
    //   646	1	5	localException1	Exception
    //   649	19	5	localObject2	Object
    //   121	497	6	localObject3	Object
    //   673	1	6	localException2	Exception
    //   586	7	7	localException3	Exception
    //   11	551	8	localDecoderAssetTrack	DecoderAssetTrack
    // Exception table:
    //   from	to	target	type
    //   126	198	269	finally
    //   198	238	269	finally
    //   249	252	269	finally
    //   270	273	269	finally
    //   2	48	280	finally
    //   66	126	280	finally
    //   238	243	280	finally
    //   252	264	280	finally
    //   273	280	280	finally
    //   285	357	280	finally
    //   495	500	280	finally
    //   515	522	280	finally
    //   522	536	280	finally
    //   536	579	280	finally
    //   596	628	280	finally
    //   655	662	280	finally
    //   662	667	280	finally
    //   357	426	511	finally
    //   426	495	511	finally
    //   505	508	511	finally
    //   512	515	511	finally
    //   536	579	586	java/lang/Exception
    //   633	640	646	java/lang/Exception
    //   633	640	654	finally
    //   522	536	673	java/lang/Exception
  }
  
  private void createNextDecoder(int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(197771);
        if ((this.segments == null) || (!this.preRead))
        {
          AppMethodBeat.o(197771);
          return;
        }
        i = paramInt + 1;
        if (i >= this.segments.size())
        {
          AppMethodBeat.o(197771);
          continue;
        }
        if (this.decoderCreateThread != null) {
          break label236;
        }
      }
      finally {}
      DecoderAssetTrack localDecoderAssetTrack = ((DecoderTrackSegment)this.segments.get(i)).getVideoAsset();
      if (localDecoderAssetTrack != null)
      {
        if (this.nextDecoder != null)
        {
          boolean bool = isSameExtractor(this.nextDecoder.extractor, localDecoderAssetTrack);
          if (bool) {}
        }
        else
        {
          try
          {
            this.decoderCreateThread = new AudioDecoderCreateThread(localDecoderAssetTrack, null, i, null);
            this.decoderCreateThread.start();
            AppMethodBeat.o(197771);
          }
          catch (Exception localException)
          {
            Logger.e(TAG, "createNextDecoder", localException);
            AppMethodBeat.o(197771);
          }
        }
      }
      else if ((this.nextDecoder != null) && (paramInt >= 0) && (paramInt < this.segments.size()) && (this.nextDecoder.segmentIndex != paramInt))
      {
        this.nextDecoder.decoder.start(((DecoderTrackSegment)this.segments.get(paramInt)).getTimeRange());
        this.nextDecoder.segmentIndex = paramInt;
      }
      label236:
      AppMethodBeat.o(197771);
    }
  }
  
  private CMSampleBuffer doReadSample(CMTime paramCMTime)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(197768);
    this.frameDuration.divide(this._speed);
    try
    {
      if (this.isReleased)
      {
        Logger.e(TAG, "doReadSample: has released");
        paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
        return paramCMTime;
      }
      paramCMTime = IDecoder.SAMPLE_TIME_FINISH;
      this.isEmptyFrame = false;
      if (this.segmentIndex == -1)
      {
        Logger.e(TAG, "doReadSample: segmentIndex == -1");
        if (this.lastSampleTime.smallThan(IDecoder.SAMPLE_TIME_FINISH)) {}
        for (paramCMTime = new CMSampleBuffer(AudioDecoder.SAMPLE_TIME_UNSTART);; paramCMTime = new CMSampleBuffer(VideoDecoder.SAMPLE_TIME_FINISH)) {
          return paramCMTime;
        }
      }
      localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    }
    finally
    {
      AppMethodBeat.o(197768);
    }
    Object localObject1;
    CMTime localCMTime2 = this.lastSampleTime.clone();
    CMTime localCMTime1;
    if (this.currentDecoder == null)
    {
      localCMTime1 = localCMTime2.add(this.frameDuration);
      if (!localCMTime2.equalsTo(CMTime.CMTimeInvalid)) {
        break label685;
      }
      localCMTime1 = CMTime.CMTimeZero;
    }
    label406:
    label417:
    label685:
    for (;;)
    {
      if (localCMTime1.smallThan(this.currentSegmentStartTime.add(((DecoderTrackSegment)localObject1).getScaledDuration())))
      {
        this.isEmptyFrame = true;
        Logger.d(TAG, "doReadSample: return emptyBuffer currentDecoder == null");
        paramCMTime = new CMSampleBuffer(localCMTime1, outputBuffer());
        AppMethodBeat.o(197768);
        return paramCMTime;
        if (localCMTime2.sub(this.currentSegmentStartTime).multi(this._speed).bigThan(((DecoderTrackSegment)localObject1).getScaledDuration().multi(this._speed))) {
          paramCMTime = IDecoder.SAMPLE_TIME_FINISH;
        }
      }
      else
      {
        if (!paramCMTime.equalsTo(IDecoder.SAMPLE_TIME_FINISH)) {
          break label501;
        }
        localObject1 = ((DecoderTrackSegment)localObject1).getScaledDuration().add(this.currentSegmentStartTime);
        localCMTime1 = localCMTime2.add(this.frameDuration);
        if (!((CMTime)localObject1).bigThan(localCMTime1)) {
          break label417;
        }
        if (this.currentDecoder != null) {
          break label406;
        }
      }
      for (paramCMTime = getEmptyAudioBuffer();; paramCMTime = this.currentDecoder.outputBuffer())
      {
        Logger.i(TAG, "doReadSample: finish && !end", new Object[0]);
        localObject1 = paramCMTime;
        if (paramCMTime == null) {
          localObject1 = getEmptyAudioBuffer();
        }
        paramCMTime = new CMSampleBuffer(localCMTime1, (ByteBuffer)localObject1);
        AppMethodBeat.o(197768);
        return paramCMTime;
        paramCMTime = this.currentDecoder.readSample(CMTime.CMTimeInvalid);
        break;
      }
      if (!nextSegment(true))
      {
        Logger.i(TAG, "doReadSample: finish && end && next failed", new Object[0]);
        localObject1 = AudioDecoder.SAMPLE_TIME_FINISH;
        if (this.currentDecoder == null) {}
        for (paramCMTime = localObject3;; paramCMTime = this.currentDecoder.outputBuffer())
        {
          paramCMTime = new CMSampleBuffer((CMTime)localObject1, paramCMTime);
          AppMethodBeat.o(197768);
          return paramCMTime;
        }
      }
      localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
      break;
      label501:
      if (paramCMTime.getTimeUs() < 0L)
      {
        if ((paramCMTime.getValue() != AudioDecoder.SAMPLE_TIME_ERROR.getValue()) && (paramCMTime.getValue() != AudioDecoder.SAMPLE_TIME_UNSTART.getValue()))
        {
          paramCMTime = new CMSampleBuffer(localCMTime2);
          AppMethodBeat.o(197768);
          return paramCMTime;
        }
        paramCMTime = new CMSampleBuffer(paramCMTime);
        AppMethodBeat.o(197768);
        return paramCMTime;
      }
      localCMTime1 = paramCMTime.sub(((DecoderTrackSegment)localObject1).getDecoderStartTime()).divide(this._speed);
      paramCMTime = localCMTime1;
      if (localCMTime1.getTimeUs() > ((DecoderTrackSegment)localObject1).getScaledDuration().getTimeUs()) {
        paramCMTime = ((DecoderTrackSegment)localObject1).getScaledDuration();
      }
      localObject1 = paramCMTime.add(this.currentSegmentStartTime);
      Logger.i(TAG, "doReadSample: [success] ".concat(String.valueOf(localObject1)), new Object[0]);
      if (this.currentDecoder == null) {}
      for (paramCMTime = localObject2;; paramCMTime = this.currentDecoder.outputBuffer())
      {
        paramCMTime = new CMSampleBuffer((CMTime)localObject1, paramCMTime);
        AppMethodBeat.o(197768);
        return paramCMTime;
      }
    }
  }
  
  private int findSegmentIndexAt(CMTime paramCMTime, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(197749);
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
        AppMethodBeat.o(197749);
        return i;
        localCMTime1 = localCMTime1.add(localCMTime2);
        i += 1;
        break;
      }
      AppMethodBeat.o(197749);
      return -1;
    }
  }
  
  private CMTime getSegmentStartTime(int paramInt)
  {
    AppMethodBeat.i(197750);
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while (i < paramInt)
    {
      localCMTime = CMTime.add(localCMTime, ((DecoderTrackSegment)this.segments.get(i)).getScaledDuration());
      i += 1;
    }
    AppMethodBeat.o(197750);
    return localCMTime;
  }
  
  private static boolean isSameExtractor(DecoderAssetTrack paramDecoderAssetTrack1, DecoderAssetTrack paramDecoderAssetTrack2)
  {
    AppMethodBeat.i(197773);
    if ((paramDecoderAssetTrack1 != null) && (paramDecoderAssetTrack2 != null) && (paramDecoderAssetTrack1.assetPath != null) && (paramDecoderAssetTrack1.assetPath.equals(paramDecoderAssetTrack2.assetPath)))
    {
      AppMethodBeat.o(197773);
      return true;
    }
    AppMethodBeat.o(197773);
    return false;
  }
  
  private boolean nextSegment(boolean paramBoolean)
  {
    AppMethodBeat.i(197763);
    Logger.d(TAG, "nextSegment:".concat(String.valueOf(paramBoolean)));
    this.segmentIndex += 1;
    if (this.segmentIndex >= this.segments.size())
    {
      this.segmentIndex = -1;
      AppMethodBeat.o(197763);
      return false;
    }
    this.currentSegmentStartTime = getSegmentStartTime(this.segmentIndex);
    this.lastSampleTime = this.currentSegmentStartTime;
    if (this.lastSampleTime.equalsTo(CMTime.CMTimeZero)) {
      this.lastSampleTime = CMTime.CMTimeInvalid;
    }
    Object localObject2 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    IDecoder localIDecoder;
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
          localIDecoder = createDecoder((DecoderTrackSegment)localObject2, (CMTime)???);
        }
      }
    }
    for (;;)
    {
      synchronized (this.currentDecoderLock)
      {
        this.currentDecoder = ((AudioDecoder)localIDecoder);
        if (this.audioMixer != null) {
          this.audioMixer.release();
        }
        this.audioMixer = new AudioMixer();
        if ((this.currentDecoder != null) && (this.currentDecoder.hasTrack()) && (paramBoolean)) {
          this.currentDecoder.seekTo(((DecoderTrackSegment)localObject2).getDecoderStartTime());
        }
        if (((DecoderTrackSegment)localObject2).getScaledDuration().getTimeUs() > 0L) {
          this._speed = ((float)((DecoderTrackSegment)localObject2).getTimeRange().getDurationUs() * 1.0F / (float)((DecoderTrackSegment)localObject2).getScaledDuration().getTimeUs());
        }
        ??? = TAG;
        localObject2 = new StringBuilder("nextSegment:");
        if (this.currentDecoder != null) {
          break label452;
        }
        paramBoolean = true;
        Logger.d((String)???, paramBoolean + " " + this._speed);
        AppMethodBeat.o(197763);
        return true;
        localObject3 = finally;
        AppMethodBeat.o(197763);
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
      label452:
      paramBoolean = false;
    }
  }
  
  public void asyncReadNextSample(CMTime arg1)
  {
    AppMethodBeat.i(197769);
    if (this.decoderThread.pcmFrame == null) {
      synchronized (this.decoderThread)
      {
        if (this.decoderThread.pcmFrame == null) {
          this.decoderThread.action();
        }
        AppMethodBeat.o(197769);
        return;
      }
    }
    AppMethodBeat.o(197769);
  }
  
  public void clearTimeRanges()
  {
    AppMethodBeat.i(197752);
    release();
    AppMethodBeat.o(197752);
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(197759);
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(197759);
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
    AppMethodBeat.o(197759);
  }
  
  public void clipRangeAndRemoveRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(197760);
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(197760);
      return;
    }
    Object localObject = paramCMTimeRange.getStart();
    CMTime localCMTime1 = paramCMTimeRange.getEnd();
    int k = findSegmentIndexAt((CMTime)localObject, false);
    if (k == -1)
    {
      AppMethodBeat.o(197760);
      return;
    }
    int i = findSegmentIndexAt(localCMTime1, false);
    if (i == -1) {
      i = this.segments.size() - 1;
    }
    label364:
    for (;;)
    {
      localCMTime1 = getSegmentStartTime(k);
      CMTime localCMTime2 = getSegmentStartTime(i);
      localObject = (DecoderTrackSegment)this.segments.get(k);
      DecoderTrackSegment localDecoderTrackSegment = (DecoderTrackSegment)this.segments.get(i);
      localCMTime2 = paramCMTimeRange.getEnd().sub(localCMTime2);
      float f = (float)localDecoderTrackSegment.getScaledDuration().getTimeUs() * 1.0F / (float)localDecoderTrackSegment.getTimeRange().getDurationUs();
      localDecoderTrackSegment.setTimeRange(new CMTimeRange(localDecoderTrackSegment.getTimeRange().getStart(), localCMTime2.divide(f)));
      localDecoderTrackSegment.setScaledDuration(localCMTime2);
      f = (float)((DecoderTrackSegment)localObject).getScaledDuration().getTimeUs() * 1.0F / (float)((DecoderTrackSegment)localObject).getTimeRange().getDurationUs();
      paramCMTimeRange = paramCMTimeRange.getStart().sub(localCMTime1);
      localCMTime1 = paramCMTimeRange.divide(f);
      ((DecoderTrackSegment)localObject).setTimeRange(new CMTimeRange(((DecoderTrackSegment)localObject).getTimeRange().getStart().add(localCMTime1), ((DecoderTrackSegment)localObject).getTimeRange().getDuration().sub(localCMTime1)));
      ((DecoderTrackSegment)localObject).setScaledDuration(((DecoderTrackSegment)localObject).getScaledDuration().sub(paramCMTimeRange));
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
            break label364;
          }
          i -= 1;
          break;
        }
      }
      AppMethodBeat.o(197760);
      return;
    }
  }
  
  public CMTime duration()
  {
    AppMethodBeat.i(197751);
    CMTime localCMTime = getSegmentStartTime(this.segments.size());
    AppMethodBeat.o(197751);
    return localCMTime;
  }
  
  public AudioInfo getAudioInfo()
  {
    AppMethodBeat.i(197757);
    if (this.currentDecoder != null)
    {
      localAudioInfo = this.currentDecoder.getAudioInfo();
      AppMethodBeat.o(197757);
      return localAudioInfo;
    }
    AudioInfo localAudioInfo = this.audioInfo;
    AppMethodBeat.o(197757);
    return localAudioInfo;
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.lastSampleTime;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(197770);
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
    AppMethodBeat.o(197770);
    return localCMTime;
  }
  
  public ByteBuffer getEmptyAudioBuffer()
  {
    AppMethodBeat.i(197765);
    if (this.emptyAudioBuffer == null)
    {
      long l = this.audioInfo.channelCount * this.audioInfo.sampleRate * this.frameDuration.getTimeUs() / 1000000L;
      this.emptyAudioBuffer = ByteBuffer.allocateDirect((int)l * 2);
      this.emptyAudioBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localObject = new short[(int)l];
      int i = 0;
      while (i < l)
      {
        localObject[i] = 0;
        i += 1;
      }
      this.emptyAudioBuffer.asShortBuffer().put((short[])localObject, 0, (int)l);
    }
    this.emptyAudioBuffer.position(0);
    Object localObject = this.emptyAudioBuffer;
    AppMethodBeat.o(197765);
    return localObject;
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
    return null;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
  
  public int getTrackId()
  {
    return this.trackID;
  }
  
  public boolean hasNewSample(CMTime paramCMTime)
  {
    return true;
  }
  
  public ByteBuffer outputBuffer()
  {
    AppMethodBeat.i(197748);
    if (this.isEmptyFrame)
    {
      localByteBuffer = getEmptyAudioBuffer();
      AppMethodBeat.o(197748);
      return localByteBuffer;
    }
    if (this.currentDecoder == null)
    {
      AppMethodBeat.o(197748);
      return null;
    }
    ByteBuffer localByteBuffer = this.currentDecoder.outputBuffer();
    AppMethodBeat.o(197748);
    return localByteBuffer;
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    try
    {
      AppMethodBeat.i(197774);
      if (this.audioMixer.getDestAudioChannelCount() != paramAudioInfo.channelCount)
      {
        this.audioMixer.release();
        this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
      }
      paramByteBuffer = this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
      AppMethodBeat.o(197774);
      return paramByteBuffer;
    }
    finally {}
  }
  
  public CMSampleBuffer readSample()
  {
    AppMethodBeat.i(197766);
    CMSampleBuffer localCMSampleBuffer = readSample(CMTime.CMTimeInvalid);
    AppMethodBeat.o(197766);
    return localCMSampleBuffer;
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(197767);
    Logger.d(TAG, "readSample: [start]".concat(String.valueOf(paramCMTime)));
    if (this.isReleased)
    {
      Logger.e(TAG, "readSample: [error] has released");
      paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
      AppMethodBeat.o(197767);
      return paramCMTime;
    }
    synchronized (this.decoderThread.nextFrameDecoderLock)
    {
      if ((this.decoderThread.pcmFrame != null) && (DecoderThread.access$200(this.decoderThread).frameTime == this.lastSampleTime))
      {
        paramCMTime = DecoderThread.access$200(this.decoderThread).sampleBuffer;
        this.lastSampleTime = DecoderThread.access$200(this.decoderThread).frameTime;
        createNextDecoder(this.segmentIndex);
        Logger.d(TAG, "readSample: [success] hit asyncRead - " + this.lastSampleTime);
        AppMethodBeat.o(197767);
        return paramCMTime;
      }
      paramCMTime = doReadSample(paramCMTime);
      if ((paramCMTime.getSampleByteBuffer() != null) && (this._speed > 0.1F) && (this._speed < 16.0F))
      {
        Logger.i(TAG, "readSample: processFrame [volume " + this.volume + "] [_speed " + this._speed + "]", new Object[0]);
        paramCMTime.setSampleByteBuffer(processFrame(paramCMTime.getSampleByteBuffer(), this.volume, this._speed, getAudioInfo()));
        Logger.i(TAG, "readSample: processFrame finish [volume " + this.volume + "] [_speed " + this._speed + "]", new Object[0]);
      }
      this.lastSampleTime = paramCMTime.getTime();
      createNextDecoder(this.segmentIndex);
      Logger.d(TAG, "readSample: [success]  - " + this.lastSampleTime);
      AppMethodBeat.o(197767);
      return paramCMTime;
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 663
    //   5: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 70	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   11: ldc_w 665
    //   14: invokestatic 361	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 136	com/tencent/tav/decoder/AudioDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderThread;
    //   21: invokevirtual 666	com/tencent/tav/decoder/AudioDecoderTrack$DecoderThread:release	()V
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 131	com/tencent/tav/decoder/AudioDecoderTrack:isReleased	Z
    //   29: aload_0
    //   30: getfield 175	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   33: ifnull +15 -> 48
    //   36: aload_0
    //   37: getfield 175	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   40: invokevirtual 667	com/tencent/tav/decoder/AudioDecoder:release	()V
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 175	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   48: aload_0
    //   49: getfield 127	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   52: astore_1
    //   53: aload_1
    //   54: monitorenter
    //   55: aload_0
    //   56: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   59: ifnull +15 -> 74
    //   62: aload_0
    //   63: getfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   66: invokestatic 671	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 163	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   74: aload_1
    //   75: monitorexit
    //   76: getstatic 70	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   79: ldc_w 673
    //   82: invokestatic 361	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: ldc_w 663
    //   88: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: astore_2
    //   95: aload_1
    //   96: monitorexit
    //   97: ldc_w 663
    //   100: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_2
    //   104: athrow
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	AudioDecoderTrack
    //   105	4	1	localObject2	Object
    //   94	10	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   55	74	94	finally
    //   74	76	94	finally
    //   95	97	94	finally
    //   2	48	105	finally
    //   48	55	105	finally
    //   76	91	105	finally
    //   97	105	105	finally
  }
  
  public CMTime sampleTime()
  {
    return this.lastSampleTime;
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(197764);
    Logger.d(TAG, "seekTo:[timeUs " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    if (this.isReleased)
    {
      Logger.e(TAG, "seekTo: [failed] has released");
      paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
      AppMethodBeat.o(197764);
      return paramCMTime;
    }
    synchronized (this.decoderThread.nextFrameDecoderLock)
    {
      DecoderThread.access$202(this.decoderThread, null);
      if (!this.started)
      {
        Logger.e(TAG, "seekTo: [failed] un started");
        AppMethodBeat.o(197764);
        return null;
      }
    }
    int i = findSegmentIndexAt(paramCMTime, true);
    if (i == -1)
    {
      this.segmentIndex = -1;
      Logger.e(TAG, "seekTo: [failed] segmentIndex = -1");
      AppMethodBeat.o(197764);
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
      Logger.e(TAG, "seekTo: [failed] currentDecoder == null ");
      AppMethodBeat.o(197764);
      return null;
    }
    this.currentDecoder.seekTo(localDecoderTrackSegment.getDecoderStartTime().add((CMTime)???));
    if (paramCMTime.bigThan(this.frameDuration)) {}
    for (this.lastSampleTime = paramCMTime.sub(this.frameDuration);; this.lastSampleTime = paramCMTime)
    {
      Logger.d(TAG, "seekTo: [success] [lastSampleTime " + this.lastSampleTime + "]");
      AppMethodBeat.o(197764);
      return null;
    }
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(197758);
    this.audioInfo = paramAudioInfo.clone();
    if (this.emptyAudioBuffer != null) {
      this.emptyAudioBuffer = null;
    }
    AppMethodBeat.o(197758);
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.decodeType = paramDecodeType;
  }
  
  public void setFrameRate(int paramInt)
  {
    AppMethodBeat.i(197756);
    this.frameDuration = this.frameDuration.divide(paramInt / this.frameRate);
    this.frameRate = paramInt;
    AppMethodBeat.o(197756);
  }
  
  public void setTrackID(int paramInt)
  {
    this.trackID = paramInt;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    AppMethodBeat.i(197761);
    if (this.segments == null) {
      this.segments = new ArrayList();
    }
    this.segments.clear();
    this.segments.addAll(paramList);
    AppMethodBeat.o(197761);
  }
  
  public void setVolume(float paramFloat)
  {
    this.volume = paramFloat;
  }
  
  public float speed()
  {
    return this._speed;
  }
  
  public void start()
  {
    AppMethodBeat.i(197753);
    start(null);
    AppMethodBeat.o(197753);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    AppMethodBeat.i(197754);
    start(paramSurfaceCreator, null);
    AppMethodBeat.o(197754);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(197755);
    if (this.segments.size() == 0)
    {
      release();
      AppMethodBeat.o(197755);
      return;
    }
    this.isReleased = false;
    this.decoderThread.start();
    this.started = true;
    this.segmentIndex = -1;
    clipRangeAndRemoveRange(paramCMTimeRange);
    nextSegment(true);
    AppMethodBeat.o(197755);
  }
  
  class AudioDecoderCreateThread
    extends Thread
  {
    DecoderAssetTrack extractor;
    private Surface outputSurface;
    private int segmentIndex;
    
    private AudioDecoderCreateThread(DecoderAssetTrack paramDecoderAssetTrack, Surface paramSurface, int paramInt)
    {
      super();
      AppMethodBeat.i(197739);
      this.segmentIndex = 0;
      this.extractor = paramDecoderAssetTrack;
      this.outputSurface = paramSurface;
      this.segmentIndex = paramInt;
      AppMethodBeat.o(197739);
    }
    
    /* Error */
    private void createDecoder()
    {
      // Byte code:
      //   0: ldc 68
      //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   9: invokestatic 72	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
      //   12: ifnull +43 -> 55
      //   15: aload_0
      //   16: getfield 50	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   19: aload_0
      //   20: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   23: invokestatic 72	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
      //   26: invokevirtual 78	java/util/ArrayList:size	()I
      //   29: if_icmpge +26 -> 55
      //   32: aload_0
      //   33: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   36: invokestatic 82	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   39: ifne +16 -> 55
      //   42: aload_0
      //   43: getfield 52	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   46: getfield 32	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
      //   49: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   52: ifeq +37 -> 89
      //   55: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   58: new 21	java/lang/StringBuilder
      //   61: dup
      //   62: ldc 93
      //   64: invokespecial 26	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   67: aload_0
      //   68: getfield 52	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   71: getfield 32	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
      //   74: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   80: invokestatic 99	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   83: ldc 68
      //   85: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   88: return
      //   89: new 101	com/tencent/tav/decoder/AudioDecoder
      //   92: dup
      //   93: aload_0
      //   94: getfield 52	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   97: getfield 32	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
      //   100: invokespecial 102	com/tencent/tav/decoder/AudioDecoder:<init>	(Ljava/lang/String;)V
      //   103: astore_2
      //   104: aload_2
      //   105: astore_1
      //   106: aload_2
      //   107: aload_0
      //   108: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   111: invokestatic 72	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
      //   114: aload_0
      //   115: getfield 50	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   118: invokevirtual 106	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   121: checkcast 108	com/tencent/tav/decoder/DecoderTrackSegment
      //   124: invokevirtual 112	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
      //   127: aload_0
      //   128: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   131: invokestatic 72	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
      //   134: aload_0
      //   135: getfield 50	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   138: invokevirtual 106	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   141: checkcast 108	com/tencent/tav/decoder/DecoderTrackSegment
      //   144: invokevirtual 116	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
      //   147: invokeinterface 122 3 0
      //   152: aload_2
      //   153: astore_1
      //   154: aload_0
      //   155: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   158: new 124	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper
      //   161: dup
      //   162: aload_0
      //   163: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   166: aconst_null
      //   167: invokespecial 127	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:<init>	(Lcom/tencent/tav/decoder/AudioDecoderTrack;Lcom/tencent/tav/decoder/AudioDecoderTrack$1;)V
      //   170: invokestatic 131	com/tencent/tav/decoder/AudioDecoderTrack:access$1102	(Lcom/tencent/tav/decoder/AudioDecoderTrack;Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   173: pop
      //   174: aload_2
      //   175: astore_1
      //   176: aload_0
      //   177: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   180: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   183: aload_2
      //   184: putfield 139	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
      //   187: aload_2
      //   188: astore_1
      //   189: aload_0
      //   190: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   193: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   196: aload_0
      //   197: getfield 52	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   200: putfield 140	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   203: aload_2
      //   204: astore_1
      //   205: aload_0
      //   206: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   209: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   212: aload_0
      //   213: getfield 50	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   216: putfield 141	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
      //   219: aload_2
      //   220: astore_1
      //   221: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   224: new 21	java/lang/StringBuilder
      //   227: dup
      //   228: ldc 143
      //   230: invokespecial 26	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   233: aload_0
      //   234: getfield 52	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   237: getfield 32	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
      //   240: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   243: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   246: invokestatic 146	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   249: aload_0
      //   250: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   253: invokestatic 82	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   256: ifeq +195 -> 451
      //   259: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   262: ldc 148
      //   264: invokestatic 99	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   267: aload_2
      //   268: invokeinterface 151 1 0
      //   273: aload_0
      //   274: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   277: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   280: ifnull +13 -> 293
      //   283: aload_0
      //   284: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   287: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   290: invokestatic 155	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   293: ldc 68
      //   295: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   298: return
      //   299: astore_1
      //   300: ldc 68
      //   302: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   305: return
      //   306: astore_3
      //   307: aconst_null
      //   308: astore_2
      //   309: aload_2
      //   310: astore_1
      //   311: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   314: ldc 156
      //   316: aload_3
      //   317: invokestatic 159	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   320: aload_2
      //   321: ifnull +11 -> 332
      //   324: aload_2
      //   325: astore_1
      //   326: aload_2
      //   327: invokeinterface 151 1 0
      //   332: aload_0
      //   333: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   336: invokestatic 82	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   339: ifeq +112 -> 451
      //   342: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   345: ldc 148
      //   347: invokestatic 99	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   350: aload_2
      //   351: ifnull +9 -> 360
      //   354: aload_2
      //   355: invokeinterface 151 1 0
      //   360: aload_0
      //   361: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   364: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   367: ifnull +13 -> 380
      //   370: aload_0
      //   371: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   374: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   377: invokestatic 155	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   380: ldc 68
      //   382: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   385: return
      //   386: astore_1
      //   387: ldc 68
      //   389: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   392: return
      //   393: astore_2
      //   394: aconst_null
      //   395: astore_1
      //   396: aload_0
      //   397: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   400: invokestatic 82	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   403: ifeq +41 -> 444
      //   406: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   409: ldc 148
      //   411: invokestatic 99	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   414: aload_1
      //   415: ifnull +9 -> 424
      //   418: aload_1
      //   419: invokeinterface 151 1 0
      //   424: aload_0
      //   425: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   428: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   431: ifnull +13 -> 444
      //   434: aload_0
      //   435: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   438: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   441: invokestatic 155	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   444: ldc 68
      //   446: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   449: aload_2
      //   450: athrow
      //   451: ldc 68
      //   453: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   456: return
      //   457: astore_1
      //   458: goto -185 -> 273
      //   461: astore_1
      //   462: goto -130 -> 332
      //   465: astore_1
      //   466: goto -106 -> 360
      //   469: astore_1
      //   470: goto -46 -> 424
      //   473: astore_1
      //   474: goto -30 -> 444
      //   477: astore_2
      //   478: goto -82 -> 396
      //   481: astore_3
      //   482: goto -173 -> 309
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	485	0	this	AudioDecoderCreateThread
      //   105	116	1	localAudioDecoder1	AudioDecoder
      //   299	1	1	localException1	Exception
      //   310	16	1	localAudioDecoder2	AudioDecoder
      //   386	1	1	localException2	Exception
      //   395	24	1	localObject1	Object
      //   457	1	1	localException3	Exception
      //   461	1	1	localException4	Exception
      //   465	1	1	localException5	Exception
      //   469	1	1	localException6	Exception
      //   473	1	1	localException7	Exception
      //   103	252	2	localAudioDecoder3	AudioDecoder
      //   393	57	2	localObject2	Object
      //   477	1	2	localObject3	Object
      //   306	11	3	localException8	Exception
      //   481	1	3	localException9	Exception
      // Exception table:
      //   from	to	target	type
      //   273	293	299	java/lang/Exception
      //   89	104	306	java/lang/Exception
      //   360	380	386	java/lang/Exception
      //   89	104	393	finally
      //   267	273	457	java/lang/Exception
      //   326	332	461	java/lang/Exception
      //   354	360	465	java/lang/Exception
      //   418	424	469	java/lang/Exception
      //   424	444	473	java/lang/Exception
      //   106	152	477	finally
      //   154	174	477	finally
      //   176	187	477	finally
      //   189	203	477	finally
      //   205	219	477	finally
      //   221	249	477	finally
      //   311	320	477	finally
      //   326	332	477	finally
      //   106	152	481	java/lang/Exception
      //   154	174	481	java/lang/Exception
      //   176	187	481	java/lang/Exception
      //   189	203	481	java/lang/Exception
      //   205	219	481	java/lang/Exception
      //   221	249	481	java/lang/Exception
    }
    
    public void run()
    {
      AppMethodBeat.i(197740);
      ??? = AudioDecoderTrack.TAG;
      StringBuilder localStringBuilder = new StringBuilder("AudioDecoderCreateThread start - ").append(this.extractor.assetPath).append(" - ");
      if (this.outputSurface != null) {}
      for (boolean bool = true;; bool = false)
      {
        Logger.d((String)???, bool);
        if (!AudioDecoderTrack.this.isReleased) {
          break;
        }
        AudioDecoderTrack.access$902(AudioDecoderTrack.this, null);
        AppMethodBeat.o(197740);
        return;
      }
      for (;;)
      {
        synchronized (AudioDecoderTrack.this.nextDecoderLock)
        {
          if ((AudioDecoderTrack.this.nextDecoder == null) || (!AudioDecoderTrack.access$1200(AudioDecoderTrack.this.nextDecoder.extractor, this.extractor)))
          {
            if (AudioDecoderTrack.this.nextDecoder != null)
            {
              Logger.d(AudioDecoderTrack.TAG, "AudioDecoderCreateThread create - " + this.extractor.assetPath);
              if ((AudioDecoderTrack.this.nextDecoder.decoder != null) && (AudioDecoderTrack.this.nextDecoder.decoder != AudioDecoderTrack.this.currentDecoder))
              {
                AudioDecoderTrack.DecoderWrapper.access$600(AudioDecoderTrack.this.nextDecoder);
                AudioDecoderTrack.access$1102(AudioDecoderTrack.this, null);
              }
              createDecoder();
            }
          }
          else
          {
            AudioDecoderTrack.access$902(AudioDecoderTrack.this, null);
            if (!AudioDecoderTrack.this.isReleased) {}
          }
        }
        synchronized (AudioDecoderTrack.this.nextDecoderLock)
        {
          if (AudioDecoderTrack.this.nextDecoder != null)
          {
            AudioDecoderTrack.DecoderWrapper.access$600(AudioDecoderTrack.this.nextDecoder);
            AudioDecoderTrack.access$1102(AudioDecoderTrack.this, null);
          }
          Logger.d(AudioDecoderTrack.TAG, "AudioDecoderCreateThread finish - " + this.extractor.assetPath);
          AppMethodBeat.o(197740);
          return;
          createDecoder();
          continue;
          localObject2 = finally;
          AppMethodBeat.o(197740);
          throw localObject2;
        }
      }
    }
  }
  
  class CacheBuffer
  {
    private CMTime frameTime;
    private CMTime preFrameTime;
    private CMSampleBuffer sampleBuffer;
    
    private CacheBuffer() {}
  }
  
  class DecoderThread
    extends ReActionThread
  {
    private static final String NAME = "AudioDecoderThread";
    private final Object nextFrameDecoderLock;
    private AudioDecoderTrack.CacheBuffer pcmFrame;
    
    public DecoderThread()
    {
      super();
      AppMethodBeat.i(197742);
      this.nextFrameDecoderLock = new Object();
      AppMethodBeat.o(197742);
    }
    
    protected void doAction()
    {
      CMSampleBuffer localCMSampleBuffer = null;
      AppMethodBeat.i(197743);
      synchronized (this.nextFrameDecoderLock)
      {
        if (this.pcmFrame != null)
        {
          if (AudioDecoderTrack.this.lastSampleTime != CMTime.CMTimeInvalid) {
            break label249;
          }
          Logger.d(AudioDecoderTrack.TAG, "doAction: CMTime.CMTimeZero");
          localCMSampleBuffer = AudioDecoderTrack.access$1700(AudioDecoderTrack.this, CMTime.CMTimeZero);
        }
        label249:
        while (AudioDecoderTrack.this.lastSampleTime.smallThan(CMTime.CMTimeZero))
        {
          if (localCMSampleBuffer != null)
          {
            if (localCMSampleBuffer.getSampleByteBuffer() != null)
            {
              Logger.i(AudioDecoderTrack.TAG, "doAction: processFrame [volume " + AudioDecoderTrack.this.volume + "] [_speed " + AudioDecoderTrack.this._speed + "]", new Object[0]);
              localCMSampleBuffer.setSampleByteBuffer(AudioDecoderTrack.this.processFrame(localCMSampleBuffer.getSampleByteBuffer(), 1.0F, AudioDecoderTrack.this._speed, AudioDecoderTrack.this.getAudioInfo()));
              Logger.i(AudioDecoderTrack.TAG, "doAction: processFrame finish [volume " + AudioDecoderTrack.this.volume + "] [_speed " + AudioDecoderTrack.this._speed + "]", new Object[0]);
            }
            this.pcmFrame = new AudioDecoderTrack.CacheBuffer(AudioDecoderTrack.this, null);
            AudioDecoderTrack.CacheBuffer.access$2202(this.pcmFrame, AudioDecoderTrack.this.lastSampleTime);
            AudioDecoderTrack.CacheBuffer.access$302(this.pcmFrame, localCMSampleBuffer.getTime());
          }
          AppMethodBeat.o(197743);
          return;
        }
        Logger.d(AudioDecoderTrack.TAG, "doAction: lastSampleTime.add(frameDuration)");
        localCMSampleBuffer = AudioDecoderTrack.access$1700(AudioDecoderTrack.this, AudioDecoderTrack.this.lastSampleTime.add(AudioDecoderTrack.this.frameDuration));
      }
    }
  }
  
  class DecoderWrapper
  {
    IDecoder decoder;
    DecoderAssetTrack extractor;
    int segmentIndex = -1;
    
    private DecoderWrapper() {}
    
    private void release()
    {
      AppMethodBeat.i(197744);
      Logger.d(AudioDecoderTrack.TAG, "Audio DecoderWrapper release: ");
      try
      {
        if (this.decoder != null) {
          this.decoder.release();
        }
        AppMethodBeat.o(197744);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(197744);
        return;
      }
      catch (Error localError)
      {
        label36:
        break label36;
      }
    }
  }
  
  class ReleaseDecoderThread
    extends Thread
  {
    private IDecoder decoder;
    
    ReleaseDecoderThread(IDecoder paramIDecoder)
    {
      super();
      this.decoder = paramIDecoder;
    }
    
    public void run()
    {
      AppMethodBeat.i(197746);
      if (this.decoder != null) {
        this.decoder.release();
      }
      AppMethodBeat.o(197746);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack
 * JD-Core Version:    0.7.0.1
 */