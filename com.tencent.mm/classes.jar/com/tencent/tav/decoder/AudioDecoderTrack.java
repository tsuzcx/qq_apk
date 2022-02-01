package com.tencent.tav.decoder;

import android.util.Log;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.codec.IDecoderFactory;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.thread.ReActionHandlerThread;
import com.tencent.tav.report.AverageTimeReporter;
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
  private boolean decodeError;
  private Exception decodeException;
  private IDecoder.DecodeType decodeType;
  private AudioDecoderCreateThread decoderCreateThread;
  private IDecoderFactory decoderFactory;
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
    this(null);
  }
  
  public AudioDecoderTrack(IDecoderFactory paramIDecoderFactory)
  {
    AppMethodBeat.i(216346);
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
    this.decodeError = false;
    this.decodeException = null;
    this._speed = 1.0F;
    this.started = false;
    this.duration = CMTime.CMTimeZero;
    this.decoderFactory = paramIDecoderFactory;
    AppMethodBeat.o(216346);
  }
  
  /* Error */
  private IDecoder createDecoder(DecoderTrackSegment paramDecoderTrackSegment, CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 219
    //   4: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: invokevirtual 225	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   11: astore 8
    //   13: getstatic 76	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   16: new 227	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 229
    //   22: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload 8
    //   27: getfield 237	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   30: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 243
    //   35: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 252	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iconst_5
    //   45: istore_3
    //   46: aconst_null
    //   47: astore 5
    //   49: aload 5
    //   51: ifnonnull +621 -> 672
    //   54: iload_3
    //   55: ifle +617 -> 672
    //   58: iload_3
    //   59: iconst_1
    //   60: isub
    //   61: istore_3
    //   62: aload_0
    //   63: getfield 134	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   66: ifnull +211 -> 277
    //   69: aload_0
    //   70: getfield 134	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   73: invokestatic 256	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:access$000	(Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;)I
    //   76: istore 4
    //   78: iload 4
    //   80: aload_0
    //   81: getfield 113	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   84: invokevirtual 260	java/util/ArrayList:size	()I
    //   87: if_icmpge +157 -> 244
    //   90: aload_0
    //   91: getfield 113	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   94: iload 4
    //   96: invokevirtual 264	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   99: checkcast 221	com/tencent/tav/decoder/DecoderTrackSegment
    //   102: invokevirtual 225	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   105: aload 8
    //   107: invokestatic 186	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   110: ifeq +134 -> 244
    //   113: aload_0
    //   114: getfield 136	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   117: astore 6
    //   119: aload 6
    //   121: monitorenter
    //   122: aload_0
    //   123: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   126: ifnull +115 -> 241
    //   129: aload_0
    //   130: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   133: getfield 268	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   136: aload 8
    //   138: invokestatic 186	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   141: ifeq +100 -> 241
    //   144: aload_0
    //   145: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   148: getfield 272	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   151: ifnull +90 -> 241
    //   154: aload_0
    //   155: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   158: getfield 272	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   161: astore_2
    //   162: aload_0
    //   163: getfield 113	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   166: aload_0
    //   167: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   170: getfield 273	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   173: invokevirtual 264	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   176: aload_1
    //   177: if_acmpeq +17 -> 194
    //   180: aload_2
    //   181: aload_1
    //   182: invokevirtual 277	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   185: aload_1
    //   186: invokevirtual 281	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   189: invokeinterface 287 3 0
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   199: getstatic 76	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   202: new 227	java/lang/StringBuilder
    //   205: dup
    //   206: ldc_w 289
    //   209: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: aload_2
    //   213: invokeinterface 292 1 0
    //   218: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 252	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload 6
    //   229: monitorexit
    //   230: ldc 219
    //   232: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_2
    //   236: astore_1
    //   237: aload_0
    //   238: monitorexit
    //   239: aload_1
    //   240: areturn
    //   241: aload 6
    //   243: monitorexit
    //   244: aload_1
    //   245: invokevirtual 277	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   248: ifnonnull +258 -> 506
    //   251: ldc 219
    //   253: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aconst_null
    //   257: astore_1
    //   258: goto -21 -> 237
    //   261: astore_1
    //   262: aload 6
    //   264: monitorexit
    //   265: ldc 219
    //   267: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload_1
    //   271: athrow
    //   272: astore_1
    //   273: aload_0
    //   274: monitorexit
    //   275: aload_1
    //   276: athrow
    //   277: getstatic 76	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   280: new 227	java/lang/StringBuilder
    //   283: dup
    //   284: ldc_w 294
    //   287: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload 8
    //   292: getfield 237	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   295: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 252	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   308: ifnull -64 -> 244
    //   311: aload_0
    //   312: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   315: getfield 268	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   318: aload 8
    //   320: invokestatic 186	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   323: ifeq -79 -> 244
    //   326: aload_0
    //   327: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   330: getfield 272	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   333: ifnull -89 -> 244
    //   336: aload_0
    //   337: getfield 136	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   340: astore 6
    //   342: aload 6
    //   344: monitorenter
    //   345: aload_0
    //   346: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   349: ifnull +140 -> 489
    //   352: aload_0
    //   353: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   356: getfield 268	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   359: aload 8
    //   361: if_acmpne +128 -> 489
    //   364: aload_0
    //   365: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   368: getfield 272	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   371: ifnull +118 -> 489
    //   374: aload_0
    //   375: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   378: getfield 272	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   381: astore_2
    //   382: aload_0
    //   383: getfield 113	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   386: aload_0
    //   387: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   390: getfield 273	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   393: invokevirtual 264	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   396: aload_1
    //   397: if_acmpeq +17 -> 414
    //   400: aload_2
    //   401: aload_1
    //   402: invokevirtual 277	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   405: aload_1
    //   406: invokevirtual 281	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   409: invokeinterface 287 3 0
    //   414: getstatic 76	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   417: new 227	java/lang/StringBuilder
    //   420: dup
    //   421: ldc_w 289
    //   424: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   427: aload_2
    //   428: invokeinterface 292 1 0
    //   433: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: ldc_w 296
    //   439: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_0
    //   443: getfield 122	com/tencent/tav/decoder/AudioDecoderTrack:segmentIndex	I
    //   446: invokevirtual 299	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: ldc_w 301
    //   452: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload_0
    //   456: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   459: getfield 273	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   462: invokevirtual 299	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   465: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 252	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: aload_0
    //   472: aconst_null
    //   473: putfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   476: aload 6
    //   478: monitorexit
    //   479: ldc 219
    //   481: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   484: aload_2
    //   485: astore_1
    //   486: goto -249 -> 237
    //   489: aload 6
    //   491: monitorexit
    //   492: goto -248 -> 244
    //   495: astore_1
    //   496: aload 6
    //   498: monitorexit
    //   499: ldc 219
    //   501: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   504: aload_1
    //   505: athrow
    //   506: new 303	com/tencent/tav/decoder/AudioDecoder
    //   509: dup
    //   510: aload 8
    //   512: getfield 237	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   515: aload_0
    //   516: getfield 169	com/tencent/tav/decoder/AudioDecoderTrack:decoderFactory	Lcom/tencent/tav/codec/IDecoderFactory;
    //   519: invokespecial 306	com/tencent/tav/decoder/AudioDecoder:<init>	(Ljava/lang/String;Lcom/tencent/tav/codec/IDecoderFactory;)V
    //   522: astore 6
    //   524: aload 6
    //   526: aload_1
    //   527: invokevirtual 277	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   530: aload_2
    //   531: invokeinterface 287 3 0
    //   536: getstatic 76	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   539: new 227	java/lang/StringBuilder
    //   542: dup
    //   543: ldc_w 308
    //   546: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   549: aload 8
    //   551: getfield 237	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   554: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 252	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: aload 6
    //   565: astore 5
    //   567: goto -518 -> 49
    //   570: astore 7
    //   572: aload 6
    //   574: astore 5
    //   576: aload 7
    //   578: astore 6
    //   580: getstatic 76	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   583: new 227	java/lang/StringBuilder
    //   586: dup
    //   587: ldc_w 310
    //   590: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   593: aload 6
    //   595: invokevirtual 313	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   598: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: aload 6
    //   603: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   606: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 319	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: aload 5
    //   614: ifnull +10 -> 624
    //   617: aload 5
    //   619: invokeinterface 322 1 0
    //   624: iload_3
    //   625: ifne +68 -> 693
    //   628: aload 8
    //   630: getfield 237	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   633: ifnull +60 -> 693
    //   636: aload 8
    //   638: getfield 237	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   641: ldc_w 324
    //   644: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   647: ifne +46 -> 693
    //   650: aload_0
    //   651: iconst_1
    //   652: putfield 159	com/tencent/tav/decoder/AudioDecoderTrack:decodeError	Z
    //   655: aload_0
    //   656: aload 6
    //   658: putfield 161	com/tencent/tav/decoder/AudioDecoderTrack:decodeException	Ljava/lang/Exception;
    //   661: goto +32 -> 693
    //   664: astore_1
    //   665: ldc 219
    //   667: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   670: aload_1
    //   671: athrow
    //   672: ldc 219
    //   674: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   677: aload 5
    //   679: astore_1
    //   680: goto -443 -> 237
    //   683: astore 5
    //   685: goto -61 -> 624
    //   688: astore 6
    //   690: goto -110 -> 580
    //   693: aconst_null
    //   694: astore 5
    //   696: goto -647 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	699	0	this	AudioDecoderTrack
    //   0	699	1	paramDecoderTrackSegment	DecoderTrackSegment
    //   0	699	2	paramCMTime	CMTime
    //   45	580	3	i	int
    //   76	19	4	j	int
    //   47	631	5	localObject1	Object
    //   683	1	5	localException1	Exception
    //   694	1	5	localObject2	Object
    //   117	540	6	localObject3	Object
    //   688	1	6	localException2	Exception
    //   570	7	7	localException3	Exception
    //   11	626	8	localDecoderAssetTrack	DecoderAssetTrack
    // Exception table:
    //   from	to	target	type
    //   122	194	261	finally
    //   194	230	261	finally
    //   2	44	272	finally
    //   62	122	272	finally
    //   230	235	272	finally
    //   241	244	272	finally
    //   244	256	272	finally
    //   262	272	272	finally
    //   277	345	272	finally
    //   479	484	272	finally
    //   489	492	272	finally
    //   496	506	272	finally
    //   506	524	272	finally
    //   524	563	272	finally
    //   580	612	272	finally
    //   628	661	272	finally
    //   665	672	272	finally
    //   672	677	272	finally
    //   345	414	495	finally
    //   414	479	495	finally
    //   524	563	570	java/lang/Exception
    //   617	624	664	finally
    //   617	624	683	java/lang/Exception
    //   506	524	688	java/lang/Exception
  }
  
  private void createNextDecoder(int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(216398);
        if ((this.segments == null) || (!this.preRead))
        {
          AppMethodBeat.o(216398);
          return;
        }
        i = paramInt + 1;
        if (i >= this.segments.size())
        {
          AppMethodBeat.o(216398);
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
            AppMethodBeat.o(216398);
          }
          catch (Exception localException)
          {
            Logger.e(TAG, "createNextDecoder", localException);
            AppMethodBeat.o(216398);
          }
        }
      }
      else if ((this.nextDecoder != null) && (paramInt >= 0) && (paramInt < this.segments.size()) && (this.nextDecoder.segmentIndex != paramInt))
      {
        this.nextDecoder.decoder.start(((DecoderTrackSegment)this.segments.get(paramInt)).getTimeRange());
        this.nextDecoder.segmentIndex = paramInt;
      }
      label236:
      AppMethodBeat.o(216398);
    }
  }
  
  private CMSampleBuffer doReadSample(CMTime paramCMTime)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(216393);
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
      AppMethodBeat.o(216393);
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
        AppMethodBeat.o(216393);
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
        AppMethodBeat.o(216393);
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
          AppMethodBeat.o(216393);
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
          AppMethodBeat.o(216393);
          return paramCMTime;
        }
        paramCMTime = new CMSampleBuffer(paramCMTime);
        AppMethodBeat.o(216393);
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
        AppMethodBeat.o(216393);
        return paramCMTime;
      }
    }
  }
  
  private int findSegmentIndexAt(CMTime paramCMTime, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(216354);
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
        AppMethodBeat.o(216354);
        return i;
        localCMTime1 = localCMTime1.add(localCMTime2);
        i += 1;
        break;
      }
      AppMethodBeat.o(216354);
      return -1;
    }
  }
  
  private CMTime getSegmentStartTime(int paramInt)
  {
    AppMethodBeat.i(216359);
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while (i < paramInt)
    {
      localCMTime = CMTime.add(localCMTime, ((DecoderTrackSegment)this.segments.get(i)).getScaledDuration());
      i += 1;
    }
    AppMethodBeat.o(216359);
    return localCMTime;
  }
  
  private static boolean isSameExtractor(DecoderAssetTrack paramDecoderAssetTrack1, DecoderAssetTrack paramDecoderAssetTrack2)
  {
    AppMethodBeat.i(216405);
    if ((paramDecoderAssetTrack1 != null) && (paramDecoderAssetTrack2 != null) && (paramDecoderAssetTrack1.assetPath != null) && (paramDecoderAssetTrack1.assetPath.equals(paramDecoderAssetTrack2.assetPath)))
    {
      AppMethodBeat.o(216405);
      return true;
    }
    AppMethodBeat.o(216405);
    return false;
  }
  
  private boolean nextSegment(boolean paramBoolean)
  {
    AppMethodBeat.i(216382);
    Logger.d(TAG, "nextSegment:".concat(String.valueOf(paramBoolean)));
    this.segmentIndex += 1;
    if (this.segmentIndex >= this.segments.size())
    {
      this.segmentIndex = -1;
      AppMethodBeat.o(216382);
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
        AppMethodBeat.o(216382);
        return true;
        localObject3 = finally;
        AppMethodBeat.o(216382);
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
    AppMethodBeat.i(216632);
    if (this.decoderThread.pcmFrame == null) {
      synchronized (this.decoderThread)
      {
        if (this.decoderThread.pcmFrame == null) {
          this.decoderThread.action();
        }
        AppMethodBeat.o(216632);
        return;
      }
    }
    AppMethodBeat.o(216632);
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(216584);
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(216584);
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
    AppMethodBeat.o(216584);
  }
  
  public void clipRangeAndRemoveRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(216592);
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(216592);
      return;
    }
    Object localObject = paramCMTimeRange.getStart();
    CMTime localCMTime1 = paramCMTimeRange.getEnd();
    int k = findSegmentIndexAt((CMTime)localObject, false);
    if (k == -1)
    {
      AppMethodBeat.o(216592);
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
      AppMethodBeat.o(216592);
      return;
    }
  }
  
  public CMTime duration()
  {
    AppMethodBeat.i(216541);
    CMTime localCMTime = getSegmentStartTime(this.segments.size());
    AppMethodBeat.o(216541);
    return localCMTime;
  }
  
  public AudioInfo getAudioInfo()
  {
    AppMethodBeat.i(216577);
    if (this.currentDecoder != null)
    {
      localAudioInfo = this.currentDecoder.getAudioInfo();
      AppMethodBeat.o(216577);
      return localAudioInfo;
    }
    AudioInfo localAudioInfo = this.audioInfo;
    AppMethodBeat.o(216577);
    return localAudioInfo;
  }
  
  public CMTime getCurrentSampleTime()
  {
    AppMethodBeat.i(216645);
    CMTime localCMTime = this.lastSampleState.getTime();
    AppMethodBeat.o(216645);
    return localCMTime;
  }
  
  public AverageTimeReporter getDecodePerformance()
  {
    return null;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(216641);
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
    AppMethodBeat.o(216641);
    return localCMTime;
  }
  
  public ByteBuffer getEmptyAudioBuffer()
  {
    AppMethodBeat.i(216611);
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
    AppMethodBeat.o(216611);
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
    AppMethodBeat.i(216514);
    if (this.isEmptyFrame)
    {
      localByteBuffer = getEmptyAudioBuffer();
      AppMethodBeat.o(216514);
      return localByteBuffer;
    }
    if (this.currentDecoder == null)
    {
      AppMethodBeat.o(216514);
      return null;
    }
    ByteBuffer localByteBuffer = this.currentDecoder.outputBuffer();
    AppMethodBeat.o(216514);
    return localByteBuffer;
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    try
    {
      AppMethodBeat.i(216674);
      if (this.audioMixer.getDestAudioChannelCount() != paramAudioInfo.channelCount)
      {
        this.audioMixer.release();
        this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
      }
      paramByteBuffer = this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
      AppMethodBeat.o(216674);
      return paramByteBuffer;
    }
    finally {}
  }
  
  public CMSampleBuffer readSample()
  {
    AppMethodBeat.i(216616);
    CMSampleBuffer localCMSampleBuffer = readSample(CMTime.CMTimeInvalid);
    AppMethodBeat.o(216616);
    return localCMSampleBuffer;
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(216621);
    if (this.isReleased)
    {
      Logger.e(TAG, "readSample: [error] has released");
      paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
      AppMethodBeat.o(216621);
      return paramCMTime;
    }
    if (this.decodeError)
    {
      paramCMTime = new CMSampleBuffer(CMSampleState.fromExportError(-3L, -202, "", this.decodeException));
      AppMethodBeat.o(216621);
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
        AppMethodBeat.o(216621);
        return paramCMTime;
      }
      paramCMTime = doReadSample(paramCMTime);
      if ((paramCMTime.getSampleByteBuffer() != null) && (this._speed > 0.1F) && (this._speed < 16.0F)) {
        paramCMTime.setSampleByteBuffer(processFrame(paramCMTime.getSampleByteBuffer(), this.volume, this._speed, getAudioInfo()));
      }
      this.lastSampleState = paramCMTime.getState();
      createNextDecoder(this.segmentIndex);
      AppMethodBeat.o(216621);
      return paramCMTime;
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 691
    //   5: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 76	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   11: ldc_w 693
    //   14: invokestatic 252	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 145	com/tencent/tav/decoder/AudioDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderThread;
    //   21: invokevirtual 694	com/tencent/tav/decoder/AudioDecoderTrack$DecoderThread:release	()V
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 140	com/tencent/tav/decoder/AudioDecoderTrack:isReleased	Z
    //   29: aload_0
    //   30: getfield 190	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   33: ifnull +15 -> 48
    //   36: aload_0
    //   37: getfield 190	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   40: invokevirtual 695	com/tencent/tav/decoder/AudioDecoder:release	()V
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 190	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   48: aload_0
    //   49: getfield 136	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   52: astore_1
    //   53: aload_1
    //   54: monitorenter
    //   55: aload_0
    //   56: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   59: ifnull +15 -> 74
    //   62: aload_0
    //   63: getfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   66: invokestatic 699	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 178	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   74: aload_1
    //   75: monitorexit
    //   76: getstatic 76	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   79: ldc_w 701
    //   82: invokestatic 252	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: ldc_w 691
    //   88: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: astore_2
    //   95: aload_1
    //   96: monitorexit
    //   97: ldc_w 691
    //   100: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2	48	105	finally
    //   48	55	105	finally
    //   76	91	105	finally
    //   95	105	105	finally
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216603);
    Logger.v(TAG, "seekTo:[time " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    if (this.isReleased)
    {
      Logger.e(TAG, "seekTo: [failed] has released");
      paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
      AppMethodBeat.o(216603);
      return paramCMTime;
    }
    synchronized (this.decoderThread.nextFrameDecoderLock)
    {
      DecoderThread.access$202(this.decoderThread, null);
      if (!this.started)
      {
        Logger.w(TAG, "seekTo: [failed] un started, stack = " + Log.getStackTraceString(new RuntimeException()));
        AppMethodBeat.o(216603);
        return null;
      }
    }
    int i = findSegmentIndexAt(paramCMTime, true);
    if (i == -1)
    {
      this.segmentIndex = -1;
      Logger.e(TAG, "seekTo: [failed] segmentIndex = -1");
      AppMethodBeat.o(216603);
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
      AppMethodBeat.o(216603);
      return null;
    }
    this.currentDecoder.seekTo(localDecoderTrackSegment.getDecoderStartTime().add((CMTime)???));
    if (paramCMTime.bigThan(this.frameDuration)) {}
    for (this.lastSampleState = new CMSampleState(paramCMTime.sub(this.frameDuration));; this.lastSampleState = new CMSampleState(paramCMTime))
    {
      Logger.v(TAG, "seekTo: [success] [lastSampleState " + this.lastSampleState + "]");
      AppMethodBeat.o(216603);
      return null;
    }
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(216580);
    this.audioInfo = paramAudioInfo.clone();
    if (this.emptyAudioBuffer != null) {
      this.emptyAudioBuffer = null;
    }
    AppMethodBeat.o(216580);
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.decodeType = paramDecodeType;
  }
  
  public void setFrameRate(int paramInt)
  {
    AppMethodBeat.i(216560);
    this.frameDuration = this.frameDuration.divide(paramInt / this.frameRate);
    this.frameRate = paramInt;
    AppMethodBeat.o(216560);
  }
  
  public void setTrackID(int paramInt)
  {
    this.trackID = paramInt;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    AppMethodBeat.i(216598);
    if (this.segments == null) {
      this.segments = new ArrayList();
    }
    this.segments.clear();
    this.segments.addAll(paramList);
    AppMethodBeat.o(216598);
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
    AppMethodBeat.i(216547);
    start(null);
    AppMethodBeat.o(216547);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    AppMethodBeat.i(216551);
    start(paramSurfaceCreator, null);
    AppMethodBeat.o(216551);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(216555);
    if (this.segments.size() == 0)
    {
      release();
      AppMethodBeat.o(216555);
      return;
    }
    this.isReleased = false;
    this.decoderThread.start();
    this.started = true;
    this.segmentIndex = -1;
    clipRangeAndRemoveRange(paramCMTimeRange);
    nextSegment(true);
    AppMethodBeat.o(216555);
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
      AppMethodBeat.i(216340);
      this.segmentIndex = 0;
      this.extractor = paramDecoderAssetTrack;
      this.outputSurface = paramSurface;
      this.segmentIndex = paramInt;
      AppMethodBeat.o(216340);
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
      //   100: aload_0
      //   101: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   104: invokestatic 105	com/tencent/tav/decoder/AudioDecoderTrack:access$1500	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/codec/IDecoderFactory;
      //   107: invokespecial 108	com/tencent/tav/decoder/AudioDecoder:<init>	(Ljava/lang/String;Lcom/tencent/tav/codec/IDecoderFactory;)V
      //   110: astore_2
      //   111: aload_2
      //   112: astore_1
      //   113: aload_2
      //   114: aload_0
      //   115: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   118: invokestatic 72	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
      //   121: aload_0
      //   122: getfield 50	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   125: invokevirtual 112	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   128: checkcast 114	com/tencent/tav/decoder/DecoderTrackSegment
      //   131: invokevirtual 118	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
      //   134: aload_0
      //   135: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   138: invokestatic 72	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
      //   141: aload_0
      //   142: getfield 50	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   145: invokevirtual 112	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   148: checkcast 114	com/tencent/tav/decoder/DecoderTrackSegment
      //   151: invokevirtual 122	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
      //   154: invokeinterface 128 3 0
      //   159: aload_2
      //   160: astore_1
      //   161: aload_0
      //   162: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   165: new 130	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper
      //   168: dup
      //   169: aconst_null
      //   170: invokespecial 133	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:<init>	(Lcom/tencent/tav/decoder/AudioDecoderTrack$1;)V
      //   173: invokestatic 137	com/tencent/tav/decoder/AudioDecoderTrack:access$1102	(Lcom/tencent/tav/decoder/AudioDecoderTrack;Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   176: pop
      //   177: aload_2
      //   178: astore_1
      //   179: aload_0
      //   180: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   183: invokestatic 141	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   186: aload_2
      //   187: putfield 145	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
      //   190: aload_2
      //   191: astore_1
      //   192: aload_0
      //   193: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   196: invokestatic 141	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   199: aload_0
      //   200: getfield 52	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   203: putfield 146	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   206: aload_2
      //   207: astore_1
      //   208: aload_0
      //   209: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   212: invokestatic 141	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   215: aload_0
      //   216: getfield 50	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
      //   219: putfield 147	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
      //   222: aload_2
      //   223: astore_1
      //   224: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   227: new 21	java/lang/StringBuilder
      //   230: dup
      //   231: ldc 149
      //   233: invokespecial 26	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   236: aload_0
      //   237: getfield 52	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
      //   240: getfield 32	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
      //   243: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   246: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   249: invokestatic 152	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   252: aload_0
      //   253: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   256: invokestatic 82	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   259: ifeq +195 -> 454
      //   262: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   265: ldc 154
      //   267: invokestatic 152	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   270: aload_2
      //   271: invokeinterface 157 1 0
      //   276: aload_0
      //   277: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   280: invokestatic 141	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   283: ifnull +13 -> 296
      //   286: aload_0
      //   287: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   290: invokestatic 141	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   293: invokestatic 161	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   296: ldc 68
      //   298: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   301: return
      //   302: astore_1
      //   303: ldc 68
      //   305: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   308: return
      //   309: astore_3
      //   310: aconst_null
      //   311: astore_2
      //   312: aload_2
      //   313: astore_1
      //   314: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   317: ldc 162
      //   319: aload_3
      //   320: invokestatic 165	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   323: aload_2
      //   324: ifnull +11 -> 335
      //   327: aload_2
      //   328: astore_1
      //   329: aload_2
      //   330: invokeinterface 157 1 0
      //   335: aload_0
      //   336: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   339: invokestatic 82	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   342: ifeq +112 -> 454
      //   345: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   348: ldc 154
      //   350: invokestatic 152	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   353: aload_2
      //   354: ifnull +9 -> 363
      //   357: aload_2
      //   358: invokeinterface 157 1 0
      //   363: aload_0
      //   364: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   367: invokestatic 141	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   370: ifnull +13 -> 383
      //   373: aload_0
      //   374: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   377: invokestatic 141	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   380: invokestatic 161	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   383: ldc 68
      //   385: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   388: return
      //   389: astore_1
      //   390: ldc 68
      //   392: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   395: return
      //   396: astore_2
      //   397: aconst_null
      //   398: astore_1
      //   399: aload_0
      //   400: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   403: invokestatic 82	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
      //   406: ifeq +41 -> 447
      //   409: invokestatic 91	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
      //   412: ldc 154
      //   414: invokestatic 152	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   417: aload_1
      //   418: ifnull +9 -> 427
      //   421: aload_1
      //   422: invokeinterface 157 1 0
      //   427: aload_0
      //   428: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   431: invokestatic 141	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   434: ifnull +13 -> 447
      //   437: aload_0
      //   438: getfield 19	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
      //   441: invokestatic 141	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
      //   444: invokestatic 161	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
      //   447: ldc 68
      //   449: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   452: aload_2
      //   453: athrow
      //   454: ldc 68
      //   456: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   459: return
      //   460: astore_1
      //   461: goto -185 -> 276
      //   464: astore_1
      //   465: goto -130 -> 335
      //   468: astore_1
      //   469: goto -106 -> 363
      //   472: astore_1
      //   473: goto -46 -> 427
      //   476: astore_1
      //   477: goto -30 -> 447
      //   480: astore_2
      //   481: goto -82 -> 399
      //   484: astore_3
      //   485: goto -173 -> 312
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	488	0	this	AudioDecoderCreateThread
      //   112	112	1	localAudioDecoder1	AudioDecoder
      //   302	1	1	localException1	Exception
      //   313	16	1	localAudioDecoder2	AudioDecoder
      //   389	1	1	localException2	Exception
      //   398	24	1	localObject1	Object
      //   460	1	1	localException3	Exception
      //   464	1	1	localException4	Exception
      //   468	1	1	localException5	Exception
      //   472	1	1	localException6	Exception
      //   476	1	1	localException7	Exception
      //   110	248	2	localAudioDecoder3	AudioDecoder
      //   396	57	2	localObject2	Object
      //   480	1	2	localObject3	Object
      //   309	11	3	localException8	Exception
      //   484	1	3	localException9	Exception
      // Exception table:
      //   from	to	target	type
      //   276	296	302	java/lang/Exception
      //   89	111	309	java/lang/Exception
      //   363	383	389	java/lang/Exception
      //   89	111	396	finally
      //   270	276	460	java/lang/Exception
      //   329	335	464	java/lang/Exception
      //   357	363	468	java/lang/Exception
      //   421	427	472	java/lang/Exception
      //   427	447	476	java/lang/Exception
      //   113	159	480	finally
      //   161	177	480	finally
      //   179	190	480	finally
      //   192	206	480	finally
      //   208	222	480	finally
      //   224	252	480	finally
      //   314	323	480	finally
      //   329	335	480	finally
      //   113	159	484	java/lang/Exception
      //   161	177	484	java/lang/Exception
      //   179	190	484	java/lang/Exception
      //   192	206	484	java/lang/Exception
      //   208	222	484	java/lang/Exception
      //   224	252	484	java/lang/Exception
    }
    
    public void run()
    {
      AppMethodBeat.i(216373);
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
        AppMethodBeat.o(216373);
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
          AppMethodBeat.o(216373);
          return;
          createDecoder();
          continue;
          localObject2 = finally;
          AppMethodBeat.o(216373);
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
    extends ReActionHandlerThread
  {
    private static final String NAME = "AudioDecoderThread";
    private final Object nextFrameDecoderLock;
    private AudioDecoderTrack.CacheBuffer pcmFrame;
    
    public DecoderThread()
    {
      super();
      AppMethodBeat.i(215996);
      this.nextFrameDecoderLock = new Object();
      AppMethodBeat.o(215996);
    }
    
    public void doAction()
    {
      CMSampleBuffer localCMSampleBuffer = null;
      AppMethodBeat.i(216029);
      synchronized (this.nextFrameDecoderLock)
      {
        if (this.pcmFrame != null)
        {
          if (AudioDecoderTrack.this.lastSampleState.getTime() != CMTime.CMTimeInvalid) {
            break label243;
          }
          Logger.v(AudioDecoderTrack.TAG, "doAction: CMTime.CMTimeZero");
          localCMSampleBuffer = AudioDecoderTrack.access$1800(AudioDecoderTrack.this, CMTime.CMTimeZero);
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
            AudioDecoderTrack.CacheBuffer.access$2302(this.pcmFrame, AudioDecoderTrack.this.lastSampleState.getTime());
            AudioDecoderTrack.CacheBuffer.access$302(this.pcmFrame, localCMSampleBuffer.getTime());
          }
          AppMethodBeat.o(216029);
          return;
        }
        Logger.v(AudioDecoderTrack.TAG, "doAction: lastSampleTime.add(frameDuration)");
        localCMSampleBuffer = AudioDecoderTrack.access$1800(AudioDecoderTrack.this, AudioDecoderTrack.this.lastSampleState.getTime().add(AudioDecoderTrack.this.frameDuration));
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
      AppMethodBeat.i(215975);
      Logger.d(AudioDecoderTrack.TAG, "Audio DecoderWrapper release: ");
      try
      {
        if (this.decoder != null) {
          this.decoder.release();
        }
        AppMethodBeat.o(215975);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(215975);
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
      AppMethodBeat.i(216108);
      if (this.decoder != null) {
        this.decoder.release();
      }
      AppMethodBeat.o(216108);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack
 * JD-Core Version:    0.7.0.1
 */