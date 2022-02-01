package com.tencent.tav.decoder;

import android.util.Log;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
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
  private CMSampleState lastSampleState;
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
    AppMethodBeat.i(218089);
    this.preRead = false;
    this.frameDuration = new CMTime(92880L, 1000000);
    this.frameRate = 11;
    this.volume = 1.0F;
    this.trackID = -1;
    this.segments = new ArrayList();
    this.decodeType = IDecoder.DecodeType.Audio;
    this.segmentIndex = -1;
    this.currentSegmentStartTime = CMTime.CMTimeZero;
    this.lastSampleState = new CMSampleState();
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
    AppMethodBeat.o(218089);
  }
  
  /* Error */
  private IDecoder createDecoder(DecoderTrackSegment paramDecoderTrackSegment, CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 203
    //   4: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: invokevirtual 209	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   11: astore 8
    //   13: getstatic 71	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   16: new 211	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 213
    //   22: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload 8
    //   27: getfield 221	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   30: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 227
    //   35: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 236	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iconst_5
    //   45: istore_3
    //   46: aconst_null
    //   47: astore 5
    //   49: aload 5
    //   51: ifnonnull +591 -> 642
    //   54: iload_3
    //   55: ifle +587 -> 642
    //   58: iload_3
    //   59: iconst_1
    //   60: isub
    //   61: istore_3
    //   62: aload_0
    //   63: getfield 126	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   66: ifnull +211 -> 277
    //   69: aload_0
    //   70: getfield 126	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   73: invokestatic 240	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:access$000	(Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;)I
    //   76: istore 4
    //   78: iload 4
    //   80: aload_0
    //   81: getfield 105	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   84: invokevirtual 244	java/util/ArrayList:size	()I
    //   87: if_icmpge +157 -> 244
    //   90: aload_0
    //   91: getfield 105	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   94: iload 4
    //   96: invokevirtual 248	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   99: checkcast 205	com/tencent/tav/decoder/DecoderTrackSegment
    //   102: invokevirtual 209	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   105: aload 8
    //   107: invokestatic 172	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   110: ifeq +134 -> 244
    //   113: aload_0
    //   114: getfield 128	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   117: astore 6
    //   119: aload 6
    //   121: monitorenter
    //   122: aload_0
    //   123: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   126: ifnull +115 -> 241
    //   129: aload_0
    //   130: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   133: getfield 252	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   136: aload 8
    //   138: invokestatic 172	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   141: ifeq +100 -> 241
    //   144: aload_0
    //   145: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   148: getfield 256	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   151: ifnull +90 -> 241
    //   154: aload_0
    //   155: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   158: getfield 256	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   161: astore_2
    //   162: aload_0
    //   163: getfield 105	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   166: aload_0
    //   167: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   170: getfield 257	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   173: invokevirtual 248	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   176: aload_1
    //   177: if_acmpeq +17 -> 194
    //   180: aload_2
    //   181: aload_1
    //   182: invokevirtual 261	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   185: aload_1
    //   186: invokevirtual 265	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   189: invokeinterface 271 3 0
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   199: getstatic 71	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   202: new 211	java/lang/StringBuilder
    //   205: dup
    //   206: ldc_w 273
    //   209: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: aload_2
    //   213: invokeinterface 276 1 0
    //   218: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 236	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload 6
    //   229: monitorexit
    //   230: ldc 203
    //   232: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_2
    //   236: astore_1
    //   237: aload_0
    //   238: monitorexit
    //   239: aload_1
    //   240: areturn
    //   241: aload 6
    //   243: monitorexit
    //   244: aload_1
    //   245: invokevirtual 261	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   248: ifnonnull +258 -> 506
    //   251: ldc 203
    //   253: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aconst_null
    //   257: astore_1
    //   258: goto -21 -> 237
    //   261: astore_1
    //   262: aload 6
    //   264: monitorexit
    //   265: ldc 203
    //   267: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload_1
    //   271: athrow
    //   272: astore_1
    //   273: aload_0
    //   274: monitorexit
    //   275: aload_1
    //   276: athrow
    //   277: getstatic 71	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   280: new 211	java/lang/StringBuilder
    //   283: dup
    //   284: ldc_w 278
    //   287: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload 8
    //   292: getfield 221	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   295: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 236	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   308: ifnull -64 -> 244
    //   311: aload_0
    //   312: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   315: getfield 252	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   318: aload 8
    //   320: invokestatic 172	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   323: ifeq -79 -> 244
    //   326: aload_0
    //   327: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   330: getfield 256	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   333: ifnull -89 -> 244
    //   336: aload_0
    //   337: getfield 128	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   340: astore 6
    //   342: aload 6
    //   344: monitorenter
    //   345: aload_0
    //   346: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   349: ifnull +140 -> 489
    //   352: aload_0
    //   353: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   356: getfield 252	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   359: aload 8
    //   361: if_acmpne +128 -> 489
    //   364: aload_0
    //   365: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   368: getfield 256	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   371: ifnull +118 -> 489
    //   374: aload_0
    //   375: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   378: getfield 256	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   381: astore_2
    //   382: aload_0
    //   383: getfield 105	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   386: aload_0
    //   387: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   390: getfield 257	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   393: invokevirtual 248	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   396: aload_1
    //   397: if_acmpeq +17 -> 414
    //   400: aload_2
    //   401: aload_1
    //   402: invokevirtual 261	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   405: aload_1
    //   406: invokevirtual 265	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   409: invokeinterface 271 3 0
    //   414: getstatic 71	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   417: new 211	java/lang/StringBuilder
    //   420: dup
    //   421: ldc_w 273
    //   424: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   427: aload_2
    //   428: invokeinterface 276 1 0
    //   433: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: ldc_w 280
    //   439: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_0
    //   443: getfield 114	com/tencent/tav/decoder/AudioDecoderTrack:segmentIndex	I
    //   446: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: ldc_w 285
    //   452: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload_0
    //   456: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   459: getfield 257	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   462: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   465: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 236	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: aload_0
    //   472: aconst_null
    //   473: putfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   476: aload 6
    //   478: monitorexit
    //   479: ldc 203
    //   481: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   484: aload_2
    //   485: astore_1
    //   486: goto -249 -> 237
    //   489: aload 6
    //   491: monitorexit
    //   492: goto -248 -> 244
    //   495: astore_1
    //   496: aload 6
    //   498: monitorexit
    //   499: ldc 203
    //   501: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   504: aload_1
    //   505: athrow
    //   506: new 287	com/tencent/tav/decoder/AudioDecoder
    //   509: dup
    //   510: aload 8
    //   512: getfield 221	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   515: invokespecial 288	com/tencent/tav/decoder/AudioDecoder:<init>	(Ljava/lang/String;)V
    //   518: astore 6
    //   520: aload 6
    //   522: aload_1
    //   523: invokevirtual 261	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   526: aload_2
    //   527: invokeinterface 271 3 0
    //   532: getstatic 71	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   535: new 211	java/lang/StringBuilder
    //   538: dup
    //   539: ldc_w 290
    //   542: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   545: aload 8
    //   547: getfield 221	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   550: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 236	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload 6
    //   561: astore 5
    //   563: goto -514 -> 49
    //   566: astore 7
    //   568: aload 6
    //   570: astore 5
    //   572: aload 7
    //   574: astore 6
    //   576: getstatic 71	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   579: new 211	java/lang/StringBuilder
    //   582: dup
    //   583: ldc_w 292
    //   586: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   589: aload 6
    //   591: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   594: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 6
    //   599: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 301	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: aload 5
    //   610: ifnull +10 -> 620
    //   613: aload 5
    //   615: invokeinterface 304 1 0
    //   620: aconst_null
    //   621: astore 5
    //   623: goto -574 -> 49
    //   626: astore 5
    //   628: aconst_null
    //   629: astore 5
    //   631: goto -582 -> 49
    //   634: astore_1
    //   635: ldc 203
    //   637: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   640: aload_1
    //   641: athrow
    //   642: ldc 203
    //   644: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   647: aload 5
    //   649: astore_1
    //   650: goto -413 -> 237
    //   653: astore 6
    //   655: goto -79 -> 576
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	658	0	this	AudioDecoderTrack
    //   0	658	1	paramDecoderTrackSegment	DecoderTrackSegment
    //   0	658	2	paramCMTime	CMTime
    //   45	17	3	i	int
    //   76	19	4	j	int
    //   47	575	5	localObject1	Object
    //   626	1	5	localException1	Exception
    //   629	19	5	localObject2	Object
    //   117	481	6	localObject3	Object
    //   653	1	6	localException2	Exception
    //   566	7	7	localException3	Exception
    //   11	535	8	localDecoderAssetTrack	DecoderAssetTrack
    // Exception table:
    //   from	to	target	type
    //   122	194	261	finally
    //   194	230	261	finally
    //   241	244	261	finally
    //   262	265	261	finally
    //   2	44	272	finally
    //   62	122	272	finally
    //   230	235	272	finally
    //   244	256	272	finally
    //   265	272	272	finally
    //   277	345	272	finally
    //   479	484	272	finally
    //   499	506	272	finally
    //   506	520	272	finally
    //   520	559	272	finally
    //   576	608	272	finally
    //   635	642	272	finally
    //   642	647	272	finally
    //   345	414	495	finally
    //   414	479	495	finally
    //   489	492	495	finally
    //   496	499	495	finally
    //   520	559	566	java/lang/Exception
    //   613	620	626	java/lang/Exception
    //   613	620	634	finally
    //   506	520	653	java/lang/Exception
  }
  
  private void createNextDecoder(int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(218113);
        if ((this.segments == null) || (!this.preRead))
        {
          AppMethodBeat.o(218113);
          return;
        }
        i = paramInt + 1;
        if (i >= this.segments.size())
        {
          AppMethodBeat.o(218113);
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
            AppMethodBeat.o(218113);
          }
          catch (Exception localException)
          {
            Logger.e(TAG, "createNextDecoder", localException);
            AppMethodBeat.o(218113);
          }
        }
      }
      else if ((this.nextDecoder != null) && (paramInt >= 0) && (paramInt < this.segments.size()) && (this.nextDecoder.segmentIndex != paramInt))
      {
        this.nextDecoder.decoder.start(((DecoderTrackSegment)this.segments.get(paramInt)).getTimeRange());
        this.nextDecoder.segmentIndex = paramInt;
      }
      label236:
      AppMethodBeat.o(218113);
    }
  }
  
  private CMSampleBuffer doReadSample(CMTime paramCMTime)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(218109);
    try
    {
      if (this.isReleased)
      {
        Logger.e(TAG, "doReadSample: has released");
        paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
        return paramCMTime;
      }
      paramCMTime = CMSampleState.fromError(-1L);
      this.isEmptyFrame = false;
      if (this.segmentIndex == -1)
      {
        Logger.i(TAG, "doReadSample: segmentIndex == -1");
        if (this.lastSampleState.getStateCode() < -1L) {}
        for (paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-100L));; paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L))) {
          return paramCMTime;
        }
      }
      localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    }
    finally
    {
      AppMethodBeat.o(218109);
    }
    Object localObject1;
    CMTime localCMTime;
    if (this.currentDecoder == null)
    {
      localCMTime = this.lastSampleState.getTime().add(this.frameDuration);
      if (!this.lastSampleState.isInvalid()) {
        break label692;
      }
      localCMTime = CMTime.CMTimeZero;
    }
    label412:
    label423:
    label692:
    for (;;)
    {
      if (localCMTime.smallThan(this.currentSegmentStartTime.add(((DecoderTrackSegment)localObject1).getScaledDuration())))
      {
        this.isEmptyFrame = true;
        Logger.v(TAG, "doReadSample: return emptyBuffer currentDecoder == null");
        paramCMTime = new CMSampleBuffer(localCMTime, outputBuffer());
        AppMethodBeat.o(218109);
        return paramCMTime;
        if (this.lastSampleState.getTime().sub(this.currentSegmentStartTime).multi(this._speed).bigThan(((DecoderTrackSegment)localObject1).getScaledDuration().multi(this._speed))) {
          paramCMTime = CMSampleState.fromError(-1L);
        }
      }
      else
      {
        if (paramCMTime.getStateCode() != -1L) {
          break label506;
        }
        localObject1 = ((DecoderTrackSegment)localObject1).getScaledDuration().add(this.currentSegmentStartTime);
        localCMTime = this.lastSampleState.getTime().add(this.frameDuration);
        if (!((CMTime)localObject1).bigThan(localCMTime)) {
          break label423;
        }
        if (this.currentDecoder != null) {
          break label412;
        }
      }
      for (paramCMTime = getEmptyAudioBuffer();; paramCMTime = this.currentDecoder.outputBuffer())
      {
        Logger.v(TAG, "doReadSample: finish && !end");
        localObject1 = paramCMTime;
        if (paramCMTime == null) {
          localObject1 = getEmptyAudioBuffer();
        }
        paramCMTime = new CMSampleBuffer(localCMTime, (ByteBuffer)localObject1);
        AppMethodBeat.o(218109);
        return paramCMTime;
        paramCMTime = this.currentDecoder.readSample(CMTime.CMTimeInvalid);
        break;
      }
      if (!nextSegment(true))
      {
        Logger.v(TAG, "doReadSample: finish && end && next failed");
        localObject1 = CMSampleState.fromError(-1L);
        if (this.currentDecoder == null) {}
        for (paramCMTime = localObject3;; paramCMTime = this.currentDecoder.outputBuffer())
        {
          paramCMTime = new CMSampleBuffer((CMSampleState)localObject1, paramCMTime);
          AppMethodBeat.o(218109);
          return paramCMTime;
        }
      }
      localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
      break;
      label506:
      if (paramCMTime.getStateCode() < 0L)
      {
        if ((paramCMTime.getStateCode() != -3L) && (paramCMTime.getStateCode() != -100L))
        {
          paramCMTime = new CMSampleBuffer(this.lastSampleState);
          AppMethodBeat.o(218109);
          return paramCMTime;
        }
        paramCMTime = new CMSampleBuffer(paramCMTime);
        AppMethodBeat.o(218109);
        return paramCMTime;
      }
      localCMTime = paramCMTime.getTime().sub(((DecoderTrackSegment)localObject1).getDecoderStartTime()).divide(this._speed);
      paramCMTime = localCMTime;
      if (localCMTime.getTimeUs() > ((DecoderTrackSegment)localObject1).getScaledDuration().getTimeUs()) {
        paramCMTime = ((DecoderTrackSegment)localObject1).getScaledDuration();
      }
      localObject1 = new CMSampleState(paramCMTime.add(this.currentSegmentStartTime));
      Logger.v(TAG, "doReadSample: [success] ".concat(String.valueOf(localObject1)));
      if (this.currentDecoder == null) {}
      for (paramCMTime = localObject2;; paramCMTime = this.currentDecoder.outputBuffer())
      {
        paramCMTime = new CMSampleBuffer((CMSampleState)localObject1, paramCMTime);
        AppMethodBeat.o(218109);
        return paramCMTime;
      }
    }
  }
  
  private int findSegmentIndexAt(CMTime paramCMTime, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(218091);
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
        AppMethodBeat.o(218091);
        return i;
        localCMTime1 = localCMTime1.add(localCMTime2);
        i += 1;
        break;
      }
      AppMethodBeat.o(218091);
      return -1;
    }
  }
  
  private CMTime getSegmentStartTime(int paramInt)
  {
    AppMethodBeat.i(218092);
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while (i < paramInt)
    {
      localCMTime = CMTime.add(localCMTime, ((DecoderTrackSegment)this.segments.get(i)).getScaledDuration());
      i += 1;
    }
    AppMethodBeat.o(218092);
    return localCMTime;
  }
  
  private static boolean isSameExtractor(DecoderAssetTrack paramDecoderAssetTrack1, DecoderAssetTrack paramDecoderAssetTrack2)
  {
    AppMethodBeat.i(218115);
    if ((paramDecoderAssetTrack1 != null) && (paramDecoderAssetTrack2 != null) && (paramDecoderAssetTrack1.assetPath != null) && (paramDecoderAssetTrack1.assetPath.equals(paramDecoderAssetTrack2.assetPath)))
    {
      AppMethodBeat.o(218115);
      return true;
    }
    AppMethodBeat.o(218115);
    return false;
  }
  
  private boolean nextSegment(boolean paramBoolean)
  {
    AppMethodBeat.i(218104);
    Logger.d(TAG, "nextSegment:".concat(String.valueOf(paramBoolean)));
    this.segmentIndex += 1;
    if (this.segmentIndex >= this.segments.size())
    {
      this.segmentIndex = -1;
      AppMethodBeat.o(218104);
      return false;
    }
    this.currentSegmentStartTime = getSegmentStartTime(this.segmentIndex);
    this.lastSampleState = new CMSampleState(this.currentSegmentStartTime);
    if (this.lastSampleState.getTime().equalsTo(CMTime.CMTimeZero)) {
      this.lastSampleState = new CMSampleState();
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
          break label464;
        }
        paramBoolean = true;
        Logger.d((String)???, paramBoolean + " " + this._speed);
        AppMethodBeat.o(218104);
        return true;
        localObject3 = finally;
        AppMethodBeat.o(218104);
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
      label464:
      paramBoolean = false;
    }
  }
  
  public void asyncReadNextSample(CMTime arg1)
  {
    AppMethodBeat.i(218110);
    if (this.decoderThread.pcmFrame == null) {
      synchronized (this.decoderThread)
      {
        if (this.decoderThread.pcmFrame == null) {
          this.decoderThread.action();
        }
        AppMethodBeat.o(218110);
        return;
      }
    }
    AppMethodBeat.o(218110);
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(218100);
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(218100);
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
    AppMethodBeat.o(218100);
  }
  
  public void clipRangeAndRemoveRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(218101);
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(218101);
      return;
    }
    Object localObject = paramCMTimeRange.getStart();
    CMTime localCMTime1 = paramCMTimeRange.getEnd();
    int k = findSegmentIndexAt((CMTime)localObject, false);
    if (k == -1)
    {
      AppMethodBeat.o(218101);
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
      AppMethodBeat.o(218101);
      return;
    }
  }
  
  public CMTime duration()
  {
    AppMethodBeat.i(218093);
    CMTime localCMTime = getSegmentStartTime(this.segments.size());
    AppMethodBeat.o(218093);
    return localCMTime;
  }
  
  public AudioInfo getAudioInfo()
  {
    AppMethodBeat.i(218098);
    if (this.currentDecoder != null)
    {
      localAudioInfo = this.currentDecoder.getAudioInfo();
      AppMethodBeat.o(218098);
      return localAudioInfo;
    }
    AudioInfo localAudioInfo = this.audioInfo;
    AppMethodBeat.o(218098);
    return localAudioInfo;
  }
  
  public CMTime getCurrentSampleTime()
  {
    AppMethodBeat.i(218112);
    CMTime localCMTime = this.lastSampleState.getTime();
    AppMethodBeat.o(218112);
    return localCMTime;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(218111);
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
    AppMethodBeat.o(218111);
    return localCMTime;
  }
  
  public ByteBuffer getEmptyAudioBuffer()
  {
    AppMethodBeat.i(218106);
    if (this.emptyAudioBuffer == null)
    {
      long l = this.audioInfo.channelCount * this.audioInfo.sampleRate * this.frameDuration.getTimeUs() / 1000000L;
      this.emptyAudioBuffer = ByteBuffer.allocate((int)l * 2);
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
    AppMethodBeat.o(218106);
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
  
  public long getLaggingTime()
  {
    return 0L;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
  
  public int getTrackId()
  {
    return this.trackID;
  }
  
  public ByteBuffer outputBuffer()
  {
    AppMethodBeat.i(218090);
    if (this.isEmptyFrame)
    {
      localByteBuffer = getEmptyAudioBuffer();
      AppMethodBeat.o(218090);
      return localByteBuffer;
    }
    if (this.currentDecoder == null)
    {
      AppMethodBeat.o(218090);
      return null;
    }
    ByteBuffer localByteBuffer = this.currentDecoder.outputBuffer();
    AppMethodBeat.o(218090);
    return localByteBuffer;
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    try
    {
      AppMethodBeat.i(218116);
      if (this.audioMixer.getDestAudioChannelCount() != paramAudioInfo.channelCount)
      {
        this.audioMixer.release();
        this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
      }
      paramByteBuffer = this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
      AppMethodBeat.o(218116);
      return paramByteBuffer;
    }
    finally {}
  }
  
  public CMSampleBuffer readSample()
  {
    AppMethodBeat.i(218107);
    CMSampleBuffer localCMSampleBuffer = readSample(CMTime.CMTimeInvalid);
    AppMethodBeat.o(218107);
    return localCMSampleBuffer;
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(218108);
    Logger.v(TAG, "readSample: [start]".concat(String.valueOf(paramCMTime)));
    if (this.isReleased)
    {
      Logger.e(TAG, "readSample: [error] has released");
      paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
      AppMethodBeat.o(218108);
      return paramCMTime;
    }
    synchronized (this.decoderThread.nextFrameDecoderLock)
    {
      if ((this.decoderThread.pcmFrame != null) && (DecoderThread.access$200(this.decoderThread).frameTime == this.lastSampleState.getTime()))
      {
        paramCMTime = DecoderThread.access$200(this.decoderThread).sampleBuffer;
        this.lastSampleState = new CMSampleState(DecoderThread.access$200(this.decoderThread).frameTime);
        createNextDecoder(this.segmentIndex);
        Logger.v(TAG, "readSample: [success] hit asyncRead - " + this.lastSampleState);
        AppMethodBeat.o(218108);
        return paramCMTime;
      }
      paramCMTime = doReadSample(paramCMTime);
      if ((paramCMTime.getSampleByteBuffer() != null) && (this._speed > 0.1F) && (this._speed < 16.0F))
      {
        Logger.v(TAG, "readSample: processFrame [volume " + this.volume + "] [_speed " + this._speed + "]");
        paramCMTime.setSampleByteBuffer(processFrame(paramCMTime.getSampleByteBuffer(), this.volume, this._speed, getAudioInfo()));
        Logger.v(TAG, "readSample: processFrame finish [volume " + this.volume + "] [_speed " + this._speed + "]");
      }
      this.lastSampleState = paramCMTime.getState();
      createNextDecoder(this.segmentIndex);
      Logger.v(TAG, "readSample: [success]  - " + this.lastSampleState);
      AppMethodBeat.o(218108);
      return paramCMTime;
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 677
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 71	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   11: ldc_w 679
    //   14: invokestatic 236	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 137	com/tencent/tav/decoder/AudioDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderThread;
    //   21: invokevirtual 680	com/tencent/tav/decoder/AudioDecoderTrack$DecoderThread:release	()V
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 132	com/tencent/tav/decoder/AudioDecoderTrack:isReleased	Z
    //   29: aload_0
    //   30: getfield 176	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   33: ifnull +15 -> 48
    //   36: aload_0
    //   37: getfield 176	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   40: invokevirtual 681	com/tencent/tav/decoder/AudioDecoder:release	()V
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 176	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   48: aload_0
    //   49: getfield 128	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   52: astore_1
    //   53: aload_1
    //   54: monitorenter
    //   55: aload_0
    //   56: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   59: ifnull +15 -> 74
    //   62: aload_0
    //   63: getfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   66: invokestatic 685	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 164	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   74: aload_1
    //   75: monitorexit
    //   76: getstatic 71	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   79: ldc_w 687
    //   82: invokestatic 236	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: ldc_w 677
    //   88: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: astore_2
    //   95: aload_1
    //   96: monitorexit
    //   97: ldc_w 677
    //   100: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(218105);
    Logger.v(TAG, "seekTo:[time " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    if (this.isReleased)
    {
      Logger.e(TAG, "seekTo: [failed] has released");
      paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
      AppMethodBeat.o(218105);
      return paramCMTime;
    }
    synchronized (this.decoderThread.nextFrameDecoderLock)
    {
      DecoderThread.access$202(this.decoderThread, null);
      if (!this.started)
      {
        Logger.w(TAG, "seekTo: [failed] un started, stack = " + Log.getStackTraceString(new RuntimeException()));
        AppMethodBeat.o(218105);
        return null;
      }
    }
    int i = findSegmentIndexAt(paramCMTime, true);
    if (i == -1)
    {
      this.segmentIndex = -1;
      Logger.e(TAG, "seekTo: [failed] segmentIndex = -1");
      AppMethodBeat.o(218105);
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
      this.lastSampleState = new CMSampleState(paramCMTime);
      Logger.d(TAG, "seekTo: [failed] currentDecoder == null ");
      AppMethodBeat.o(218105);
      return null;
    }
    this.currentDecoder.seekTo(localDecoderTrackSegment.getDecoderStartTime().add((CMTime)???));
    if (paramCMTime.bigThan(this.frameDuration)) {}
    for (this.lastSampleState = new CMSampleState(paramCMTime.sub(this.frameDuration));; this.lastSampleState = new CMSampleState(paramCMTime))
    {
      Logger.v(TAG, "seekTo: [success] [lastSampleState " + this.lastSampleState + "]");
      AppMethodBeat.o(218105);
      return null;
    }
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(218099);
    this.audioInfo = paramAudioInfo.clone();
    if (this.emptyAudioBuffer != null) {
      this.emptyAudioBuffer = null;
    }
    AppMethodBeat.o(218099);
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.decodeType = paramDecodeType;
  }
  
  public void setFrameRate(int paramInt)
  {
    AppMethodBeat.i(218097);
    this.frameDuration = this.frameDuration.divide(paramInt / this.frameRate);
    this.frameRate = paramInt;
    AppMethodBeat.o(218097);
  }
  
  public void setTrackID(int paramInt)
  {
    this.trackID = paramInt;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    AppMethodBeat.i(218102);
    if (this.segments == null) {
      this.segments = new ArrayList();
    }
    this.segments.clear();
    this.segments.addAll(paramList);
    AppMethodBeat.o(218102);
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
    AppMethodBeat.i(218094);
    start(null);
    AppMethodBeat.o(218094);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    AppMethodBeat.i(218095);
    start(paramSurfaceCreator, null);
    AppMethodBeat.o(218095);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(218096);
    if (this.segments.size() == 0)
    {
      release();
      AppMethodBeat.o(218096);
      return;
    }
    this.isReleased = false;
    this.decoderThread.start();
    this.started = true;
    this.segmentIndex = -1;
    clipRangeAndRemoveRange(paramCMTimeRange);
    nextSegment(true);
    AppMethodBeat.o(218096);
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
      AppMethodBeat.i(218081);
      this.segmentIndex = 0;
      this.extractor = paramDecoderAssetTrack;
      this.outputSurface = paramSurface;
      this.segmentIndex = paramInt;
      AppMethodBeat.o(218081);
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
      //   162: aconst_null
      //   163: invokespecial 127	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:<init>	(Lcom/tencent/tav/decoder/AudioDecoderTrack$1;)V
      //   166: invokestatic 131	com/tencent/tav/decoder/AudioDecoderTrack:access$1102	(Lcom/tencent/tav/decoder/AudioDecoderTrack;Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   169: pop
      //   170: aload_2
      //   171: astore_1
      //   172: aload_0
      //   173: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   176: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   179: aload_2
      //   180: putfield 139	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
      //   183: aload_2
      //   184: astore_1
      //   185: aload_0
      //   186: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   189: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   192: aload_0
      //   193: getfield 52	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   196: putfield 140	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   199: aload_2
      //   200: astore_1
      //   201: aload_0
      //   202: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   205: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   208: aload_0
      //   209: getfield 50	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   212: putfield 141	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
      //   215: aload_2
      //   216: astore_1
      //   217: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   220: new 21	java/lang/StringBuilder
      //   223: dup
      //   224: ldc 143
      //   226: invokespecial 26	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   229: aload_0
      //   230: getfield 52	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   233: getfield 32	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
      //   236: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   239: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   242: invokestatic 146	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   245: aload_0
      //   246: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   249: invokestatic 82	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   252: ifeq +195 -> 447
      //   255: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   258: ldc 148
      //   260: invokestatic 146	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   263: aload_2
      //   264: invokeinterface 151 1 0
      //   269: aload_0
      //   270: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   273: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   276: ifnull +13 -> 289
      //   279: aload_0
      //   280: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   283: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   286: invokestatic 155	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   289: ldc 68
      //   291: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   294: return
      //   295: astore_1
      //   296: ldc 68
      //   298: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   301: return
      //   302: astore_3
      //   303: aconst_null
      //   304: astore_2
      //   305: aload_2
      //   306: astore_1
      //   307: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   310: ldc 156
      //   312: aload_3
      //   313: invokestatic 159	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   316: aload_2
      //   317: ifnull +11 -> 328
      //   320: aload_2
      //   321: astore_1
      //   322: aload_2
      //   323: invokeinterface 151 1 0
      //   328: aload_0
      //   329: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   332: invokestatic 82	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   335: ifeq +112 -> 447
      //   338: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   341: ldc 148
      //   343: invokestatic 146	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   346: aload_2
      //   347: ifnull +9 -> 356
      //   350: aload_2
      //   351: invokeinterface 151 1 0
      //   356: aload_0
      //   357: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   360: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   363: ifnull +13 -> 376
      //   366: aload_0
      //   367: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   370: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   373: invokestatic 155	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   376: ldc 68
      //   378: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   381: return
      //   382: astore_1
      //   383: ldc 68
      //   385: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   388: return
      //   389: astore_2
      //   390: aconst_null
      //   391: astore_1
      //   392: aload_0
      //   393: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   396: invokestatic 82	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   399: ifeq +41 -> 440
      //   402: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   405: ldc 148
      //   407: invokestatic 146	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   410: aload_1
      //   411: ifnull +9 -> 420
      //   414: aload_1
      //   415: invokeinterface 151 1 0
      //   420: aload_0
      //   421: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   424: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   427: ifnull +13 -> 440
      //   430: aload_0
      //   431: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   434: invokestatic 135	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   437: invokestatic 155	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   440: ldc 68
      //   442: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   445: aload_2
      //   446: athrow
      //   447: ldc 68
      //   449: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   452: return
      //   453: astore_1
      //   454: goto -185 -> 269
      //   457: astore_1
      //   458: goto -130 -> 328
      //   461: astore_1
      //   462: goto -106 -> 356
      //   465: astore_1
      //   466: goto -46 -> 420
      //   469: astore_1
      //   470: goto -30 -> 440
      //   473: astore_2
      //   474: goto -82 -> 392
      //   477: astore_3
      //   478: goto -173 -> 305
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	481	0	this	AudioDecoderCreateThread
      //   105	112	1	localAudioDecoder1	AudioDecoder
      //   295	1	1	localException1	Exception
      //   306	16	1	localAudioDecoder2	AudioDecoder
      //   382	1	1	localException2	Exception
      //   391	24	1	localObject1	Object
      //   453	1	1	localException3	Exception
      //   457	1	1	localException4	Exception
      //   461	1	1	localException5	Exception
      //   465	1	1	localException6	Exception
      //   469	1	1	localException7	Exception
      //   103	248	2	localAudioDecoder3	AudioDecoder
      //   389	57	2	localObject2	Object
      //   473	1	2	localObject3	Object
      //   302	11	3	localException8	Exception
      //   477	1	3	localException9	Exception
      // Exception table:
      //   from	to	target	type
      //   269	289	295	java/lang/Exception
      //   89	104	302	java/lang/Exception
      //   356	376	382	java/lang/Exception
      //   89	104	389	finally
      //   263	269	453	java/lang/Exception
      //   322	328	457	java/lang/Exception
      //   350	356	461	java/lang/Exception
      //   414	420	465	java/lang/Exception
      //   420	440	469	java/lang/Exception
      //   106	152	473	finally
      //   154	170	473	finally
      //   172	183	473	finally
      //   185	199	473	finally
      //   201	215	473	finally
      //   217	245	473	finally
      //   307	316	473	finally
      //   322	328	473	finally
      //   106	152	477	java/lang/Exception
      //   154	170	477	java/lang/Exception
      //   172	183	477	java/lang/Exception
      //   185	199	477	java/lang/Exception
      //   201	215	477	java/lang/Exception
      //   217	245	477	java/lang/Exception
    }
    
    public void run()
    {
      AppMethodBeat.i(218082);
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
        AppMethodBeat.o(218082);
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
          AppMethodBeat.o(218082);
          return;
          createDecoder();
          continue;
          localObject2 = finally;
          AppMethodBeat.o(218082);
          throw localObject2;
        }
      }
    }
  }
  
  static class CacheBuffer
  {
    private CMTime frameTime;
    private CMTime preFrameTime;
    private CMSampleBuffer sampleBuffer;
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
      AppMethodBeat.i(218084);
      this.nextFrameDecoderLock = new Object();
      AppMethodBeat.o(218084);
    }
    
    protected void doAction()
    {
      CMSampleBuffer localCMSampleBuffer = null;
      AppMethodBeat.i(218085);
      synchronized (this.nextFrameDecoderLock)
      {
        if (this.pcmFrame != null)
        {
          if (AudioDecoderTrack.this.lastSampleState.getTime() != CMTime.CMTimeInvalid) {
            break label243;
          }
          Logger.v(AudioDecoderTrack.TAG, "doAction: CMTime.CMTimeZero");
          localCMSampleBuffer = AudioDecoderTrack.access$1700(AudioDecoderTrack.this, CMTime.CMTimeZero);
        }
        label243:
        while (AudioDecoderTrack.this.lastSampleState.getTime().smallThan(CMTime.CMTimeZero))
        {
          if (localCMSampleBuffer != null)
          {
            if (localCMSampleBuffer.getSampleByteBuffer() != null)
            {
              Logger.v(AudioDecoderTrack.TAG, "doAction: processFrame [volume " + AudioDecoderTrack.this.volume + "] [_speed " + AudioDecoderTrack.this._speed + "]");
              localCMSampleBuffer.setSampleByteBuffer(AudioDecoderTrack.this.processFrame(localCMSampleBuffer.getSampleByteBuffer(), 1.0F, AudioDecoderTrack.this._speed, AudioDecoderTrack.this.getAudioInfo()));
              Logger.v(AudioDecoderTrack.TAG, "doAction: processFrame finish [volume " + AudioDecoderTrack.this.volume + "] [_speed " + AudioDecoderTrack.this._speed + "]");
            }
            this.pcmFrame = new AudioDecoderTrack.CacheBuffer(null);
            AudioDecoderTrack.CacheBuffer.access$2202(this.pcmFrame, AudioDecoderTrack.this.lastSampleState.getTime());
            AudioDecoderTrack.CacheBuffer.access$302(this.pcmFrame, localCMSampleBuffer.getTime());
          }
          AppMethodBeat.o(218085);
          return;
        }
        Logger.v(AudioDecoderTrack.TAG, "doAction: lastSampleTime.add(frameDuration)");
        localCMSampleBuffer = AudioDecoderTrack.access$1700(AudioDecoderTrack.this, AudioDecoderTrack.this.lastSampleState.getTime().add(AudioDecoderTrack.this.frameDuration));
      }
    }
  }
  
  static class DecoderWrapper
  {
    IDecoder decoder;
    DecoderAssetTrack extractor;
    int segmentIndex = -1;
    
    private void release()
    {
      AppMethodBeat.i(218086);
      Logger.d(AudioDecoderTrack.TAG, "Audio DecoderWrapper release: ");
      try
      {
        if (this.decoder != null) {
          this.decoder.release();
        }
        AppMethodBeat.o(218086);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(218086);
        return;
      }
      catch (Error localError)
      {
        label36:
        break label36;
      }
    }
  }
  
  static class ReleaseDecoderThread
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
      AppMethodBeat.i(218088);
      if (this.decoder != null) {
        this.decoder.release();
      }
      AppMethodBeat.o(218088);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack
 * JD-Core Version:    0.7.0.1
 */