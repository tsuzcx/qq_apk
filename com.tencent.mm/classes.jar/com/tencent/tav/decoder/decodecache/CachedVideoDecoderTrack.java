package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.ITexturePool;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CachedVideoDecoderTrack
  implements IDecoderTrack
{
  private static final String TAG = "CachedVideoTrack";
  private CacheSegment currentFrameSegment;
  private CMTime lastSampleTime;
  final Object nextFrameDecoderLock;
  private CacheSegment nextFrameSegment;
  RenderContext renderContext;
  boolean revert;
  private SegmentDecoderThread segmentDecoder;
  private int segmentSize;
  CMTimeRange validTimeRange;
  
  public CachedVideoDecoderTrack(IDecoderTrack paramIDecoderTrack, boolean paramBoolean)
  {
    AppMethodBeat.i(201952);
    this.segmentSize = 60;
    this.nextFrameDecoderLock = new Object();
    this.lastSampleTime = CMTime.CMTimeInvalid;
    this.revert = paramBoolean;
    this.segmentDecoder = new SegmentDecoderThread(this, paramIDecoderTrack);
    AppMethodBeat.o(201952);
  }
  
  private void clearCurrentFrameSegment()
  {
    AppMethodBeat.i(201969);
    if (this.currentFrameSegment != null)
    {
      this.currentFrameSegment.clear();
      this.currentFrameSegment = null;
    }
    AppMethodBeat.o(201969);
  }
  
  private CMSampleBuffer decoderFrame(CMTime paramCMTime)
  {
    AppMethodBeat.i(201967);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.segmentDecoder.decoderSegment(paramCMTime, localCountDownLatch);
    try
    {
      localCountDownLatch.await(5L, TimeUnit.SECONDS);
      label34:
      paramCMTime = this.segmentDecoder.seekSampleBuffer;
      AppMethodBeat.o(201967);
      return paramCMTime;
    }
    catch (InterruptedException paramCMTime)
    {
      break label34;
    }
  }
  
  /* Error */
  private CMSampleBuffer decoderSegment(CMTime arg1)
  {
    // Byte code:
    //   0: ldc 102
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 104	com/tencent/tav/decoder/decodecache/RequestStatus
    //   8: dup
    //   9: invokespecial 105	com/tencent/tav/decoder/decodecache/RequestStatus:<init>	()V
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   18: ifnull +477 -> 495
    //   21: aload_0
    //   22: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   25: getfield 110	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   28: ifnull +467 -> 495
    //   31: aload_0
    //   32: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   35: getfield 110	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   38: aload_1
    //   39: invokevirtual 116	com/tencent/tav/coremedia/CMTimeRange:containsTime	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   42: ifeq +453 -> 495
    //   45: aload_0
    //   46: getfield 43	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameDecoderLock	Ljava/lang/Object;
    //   49: astore_3
    //   50: aload_3
    //   51: monitorenter
    //   52: aload_0
    //   53: invokespecial 118	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:clearCurrentFrameSegment	()V
    //   56: aload_0
    //   57: new 69	com/tencent/tav/decoder/decodecache/CacheSegment
    //   60: dup
    //   61: aload_0
    //   62: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   65: getfield 110	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   68: invokespecial 121	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   71: putfield 67	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   74: aload_0
    //   75: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   78: getfield 125	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   81: invokeinterface 131 1 0
    //   86: astore 5
    //   88: aload 5
    //   90: invokeinterface 137 1 0
    //   95: ifeq +37 -> 132
    //   98: aload 5
    //   100: invokeinterface 141 1 0
    //   105: checkcast 143	com/tencent/tav/decoder/decodecache/CacheFrame
    //   108: astore 6
    //   110: aload_0
    //   111: getfield 67	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   114: aload 6
    //   116: invokevirtual 147	com/tencent/tav/decoder/decodecache/CacheSegment:pushFrame	(Lcom/tencent/tav/decoder/decodecache/CacheFrame;)V
    //   119: goto -31 -> 88
    //   122: astore_1
    //   123: aload_3
    //   124: monitorexit
    //   125: ldc 102
    //   127: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_1
    //   131: athrow
    //   132: aload_0
    //   133: getfield 67	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   136: aload_1
    //   137: invokevirtual 151	com/tencent/tav/decoder/decodecache/CacheSegment:popFrame	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/decoder/decodecache/CacheFrame;
    //   140: astore 5
    //   142: aload 5
    //   144: ifnull +167 -> 311
    //   147: new 153	java/lang/StringBuilder
    //   150: dup
    //   151: ldc 155
    //   153: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: astore_1
    //   157: aload 5
    //   159: getfield 161	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   162: ifnull +144 -> 306
    //   165: aload 5
    //   167: getfield 161	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   170: invokevirtual 167	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   173: ifnull +133 -> 306
    //   176: iconst_1
    //   177: istore_2
    //   178: ldc 10
    //   180: aload_1
    //   181: iload_2
    //   182: invokevirtual 171	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   185: ldc 173
    //   187: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 5
    //   192: getfield 161	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   195: invokevirtual 179	com/tencent/tav/coremedia/CMSampleBuffer:isNewFrame	()Z
    //   198: invokevirtual 171	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   201: ldc 181
    //   203: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 5
    //   208: getfield 184	com/tencent/tav/decoder/decodecache/CacheFrame:realFrameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   211: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: ldc 173
    //   216: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 5
    //   221: getfield 190	com/tencent/tav/decoder/decodecache/CacheFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   224: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 200	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_0
    //   234: new 69	com/tencent/tav/decoder/decodecache/CacheSegment
    //   237: dup
    //   238: new 112	com/tencent/tav/coremedia/CMTimeRange
    //   241: dup
    //   242: aload_0
    //   243: getfield 67	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   246: invokevirtual 204	com/tencent/tav/decoder/decodecache/CacheSegment:getLastFrameTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   249: aload_0
    //   250: invokevirtual 207	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:getFrameDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   253: aload_0
    //   254: getfield 41	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentSize	I
    //   257: i2f
    //   258: invokevirtual 211	com/tencent/tav/coremedia/CMTime:multi	(F)Lcom/tencent/tav/coremedia/CMTime;
    //   261: invokespecial 214	com/tencent/tav/coremedia/CMTimeRange:<init>	(Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V
    //   264: invokespecial 121	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   267: putfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   270: aload_0
    //   271: getfield 59	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   274: aload_0
    //   275: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   278: aconst_null
    //   279: invokevirtual 217	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:decoderSegment	(Lcom/tencent/tav/decoder/decodecache/CacheSegment;Lcom/tencent/tav/decoder/decodecache/RequestStatus;)V
    //   282: aload_0
    //   283: aload 5
    //   285: getfield 190	com/tencent/tav/decoder/decodecache/CacheFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   288: putfield 50	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:lastSampleTime	Lcom/tencent/tav/coremedia/CMTime;
    //   291: aload 5
    //   293: getfield 161	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   296: astore_1
    //   297: aload_3
    //   298: monitorexit
    //   299: ldc 102
    //   301: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: aload_1
    //   305: areturn
    //   306: iconst_0
    //   307: istore_2
    //   308: goto -130 -> 178
    //   311: ldc 10
    //   313: new 153	java/lang/StringBuilder
    //   316: dup
    //   317: ldc 219
    //   319: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   322: aload_0
    //   323: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   326: getfield 125	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   329: invokeinterface 223 1 0
    //   334: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: ldc 173
    //   339: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_0
    //   343: getfield 67	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   346: getfield 125	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   349: invokeinterface 223 1 0
    //   354: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 200	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload_3
    //   364: monitorexit
    //   365: aload_0
    //   366: getfield 59	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   369: iconst_1
    //   370: putfield 229	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:cancel	Z
    //   373: aload_0
    //   374: getfield 43	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameDecoderLock	Ljava/lang/Object;
    //   377: astore_3
    //   378: aload_3
    //   379: monitorenter
    //   380: aload_0
    //   381: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   384: ifnull +10 -> 394
    //   387: aload_0
    //   388: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   391: invokevirtual 72	com/tencent/tav/decoder/decodecache/CacheSegment:clear	()V
    //   394: aload_0
    //   395: new 69	com/tencent/tav/decoder/decodecache/CacheSegment
    //   398: dup
    //   399: new 112	com/tencent/tav/coremedia/CMTimeRange
    //   402: dup
    //   403: aload_1
    //   404: aload_0
    //   405: invokevirtual 207	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:getFrameDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   408: aload_0
    //   409: getfield 41	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentSize	I
    //   412: i2f
    //   413: invokevirtual 211	com/tencent/tav/coremedia/CMTime:multi	(F)Lcom/tencent/tav/coremedia/CMTime;
    //   416: invokespecial 214	com/tencent/tav/coremedia/CMTimeRange:<init>	(Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V
    //   419: invokespecial 121	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   422: putfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   425: aload_0
    //   426: getfield 59	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   429: aload_0
    //   430: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   433: aload 4
    //   435: invokevirtual 217	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:decoderSegment	(Lcom/tencent/tav/decoder/decodecache/CacheSegment;Lcom/tencent/tav/decoder/decodecache/RequestStatus;)V
    //   438: aload_3
    //   439: monitorexit
    //   440: aload 4
    //   442: monitorenter
    //   443: aload 4
    //   445: invokevirtual 232	com/tencent/tav/decoder/decodecache/RequestStatus:getFinish	()Z
    //   448: ifne +11 -> 459
    //   451: aload 4
    //   453: ldc2_w 233
    //   456: invokevirtual 238	java/lang/Object:wait	(J)V
    //   459: aload 4
    //   461: monitorexit
    //   462: aload_0
    //   463: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   466: getfield 125	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   469: invokeinterface 223 1 0
    //   474: ifne +100 -> 574
    //   477: new 163	com/tencent/tav/coremedia/CMSampleBuffer
    //   480: dup
    //   481: getstatic 243	com/tencent/tav/decoder/IDecoder:SAMPLE_TIME_FINISH	Lcom/tencent/tav/coremedia/CMTime;
    //   484: invokespecial 246	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   487: astore_1
    //   488: ldc 102
    //   490: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   493: aload_1
    //   494: areturn
    //   495: new 153	java/lang/StringBuilder
    //   498: dup
    //   499: ldc 248
    //   501: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   504: astore 5
    //   506: aload_0
    //   507: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   510: ifnonnull +32 -> 542
    //   513: ldc 250
    //   515: astore_3
    //   516: ldc 10
    //   518: aload 5
    //   520: aload_3
    //   521: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   524: ldc 173
    //   526: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_1
    //   530: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 200	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: goto -166 -> 373
    //   542: aload_0
    //   543: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   546: getfield 110	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   549: astore_3
    //   550: goto -34 -> 516
    //   553: astore_1
    //   554: aload_3
    //   555: monitorexit
    //   556: ldc 102
    //   558: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   561: aload_1
    //   562: athrow
    //   563: astore_1
    //   564: aload 4
    //   566: monitorexit
    //   567: ldc 102
    //   569: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   572: aload_1
    //   573: athrow
    //   574: aload_0
    //   575: invokespecial 118	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:clearCurrentFrameSegment	()V
    //   578: aload_0
    //   579: new 69	com/tencent/tav/decoder/decodecache/CacheSegment
    //   582: dup
    //   583: aload_0
    //   584: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   587: getfield 110	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   590: invokespecial 121	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   593: putfield 67	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   596: aload_0
    //   597: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   600: getfield 125	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   603: invokeinterface 131 1 0
    //   608: astore_1
    //   609: aload_1
    //   610: invokeinterface 137 1 0
    //   615: ifeq +24 -> 639
    //   618: aload_1
    //   619: invokeinterface 141 1 0
    //   624: checkcast 143	com/tencent/tav/decoder/decodecache/CacheFrame
    //   627: astore_3
    //   628: aload_0
    //   629: getfield 67	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   632: aload_3
    //   633: invokevirtual 147	com/tencent/tav/decoder/decodecache/CacheSegment:pushFrame	(Lcom/tencent/tav/decoder/decodecache/CacheFrame;)V
    //   636: goto -27 -> 609
    //   639: aload_0
    //   640: getfield 43	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameDecoderLock	Ljava/lang/Object;
    //   643: astore_1
    //   644: aload_1
    //   645: monitorenter
    //   646: aload_0
    //   647: new 69	com/tencent/tav/decoder/decodecache/CacheSegment
    //   650: dup
    //   651: new 112	com/tencent/tav/coremedia/CMTimeRange
    //   654: dup
    //   655: aload_0
    //   656: getfield 67	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   659: invokevirtual 204	com/tencent/tav/decoder/decodecache/CacheSegment:getLastFrameTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   662: aload_0
    //   663: invokevirtual 207	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:getFrameDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   666: aload_0
    //   667: getfield 41	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentSize	I
    //   670: i2f
    //   671: invokevirtual 211	com/tencent/tav/coremedia/CMTime:multi	(F)Lcom/tencent/tav/coremedia/CMTime;
    //   674: invokespecial 214	com/tencent/tav/coremedia/CMTimeRange:<init>	(Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V
    //   677: invokespecial 121	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   680: putfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   683: aload_0
    //   684: getfield 59	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   687: aload_0
    //   688: getfield 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   691: aconst_null
    //   692: invokevirtual 217	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:decoderSegment	(Lcom/tencent/tav/decoder/decodecache/CacheSegment;Lcom/tencent/tav/decoder/decodecache/RequestStatus;)V
    //   695: aload_1
    //   696: monitorexit
    //   697: aload_0
    //   698: getfield 67	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   701: ifnull +65 -> 766
    //   704: aload_0
    //   705: getfield 67	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   708: getfield 125	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   711: invokeinterface 223 1 0
    //   716: ifle +50 -> 766
    //   719: aload_0
    //   720: getfield 67	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   723: getfield 125	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   726: iconst_0
    //   727: invokeinterface 254 2 0
    //   732: checkcast 143	com/tencent/tav/decoder/decodecache/CacheFrame
    //   735: astore_1
    //   736: aload_0
    //   737: aload_1
    //   738: getfield 190	com/tencent/tav/decoder/decodecache/CacheFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   741: putfield 50	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:lastSampleTime	Lcom/tencent/tav/coremedia/CMTime;
    //   744: aload_1
    //   745: getfield 161	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   748: astore_1
    //   749: ldc 102
    //   751: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   754: aload_1
    //   755: areturn
    //   756: astore_3
    //   757: aload_1
    //   758: monitorexit
    //   759: ldc 102
    //   761: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   764: aload_3
    //   765: athrow
    //   766: ldc 102
    //   768: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   771: aconst_null
    //   772: areturn
    //   773: astore_1
    //   774: goto -315 -> 459
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	777	0	this	CachedVideoDecoderTrack
    //   177	131	2	bool	boolean
    //   49	584	3	localObject1	Object
    //   756	9	3	localObject2	Object
    //   12	553	4	localRequestStatus	RequestStatus
    //   86	433	5	localObject3	Object
    //   108	7	6	localCacheFrame	CacheFrame
    // Exception table:
    //   from	to	target	type
    //   52	88	122	finally
    //   88	119	122	finally
    //   123	125	122	finally
    //   132	142	122	finally
    //   147	176	122	finally
    //   178	299	122	finally
    //   311	365	122	finally
    //   380	394	553	finally
    //   394	440	553	finally
    //   554	556	553	finally
    //   443	459	563	finally
    //   459	462	563	finally
    //   564	567	563	finally
    //   646	697	756	finally
    //   757	759	756	finally
    //   443	459	773	java/lang/InterruptedException
  }
  
  public void asyncReadNextSample(CMTime paramCMTime) {}
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(201963);
    this.segmentDecoder.decoderTrack.clipRangeAndClearRange(paramCMTimeRange);
    AppMethodBeat.o(201963);
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.lastSampleTime;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(201970);
    CMTime localCMTime = this.segmentDecoder.decoderTrack.getDuration();
    AppMethodBeat.o(201970);
    return localCMTime;
  }
  
  public CMTime getFrameDuration()
  {
    AppMethodBeat.i(201958);
    CMTime localCMTime = this.segmentDecoder.decoderTrack.getFrameDuration();
    AppMethodBeat.o(201958);
    return localCMTime;
  }
  
  public int getFrameRate()
  {
    AppMethodBeat.i(201957);
    int i = this.segmentDecoder.decoderTrack.getFrameRate();
    AppMethodBeat.o(201957);
    return i;
  }
  
  public CGSize getMaxRenderSize()
  {
    AppMethodBeat.i(201972);
    CGSize localCGSize = this.segmentDecoder.decoderTrack.getMaxRenderSize();
    AppMethodBeat.o(201972);
    return localCGSize;
  }
  
  public int getTrackId()
  {
    AppMethodBeat.i(201960);
    int i = this.segmentDecoder.decoderTrack.getTrackId();
    AppMethodBeat.o(201960);
    return i;
  }
  
  public boolean hasNewSample(CMTime paramCMTime)
  {
    return true;
  }
  
  public CMSampleBuffer readSample()
  {
    AppMethodBeat.i(201965);
    if (this.lastSampleTime == CMTime.CMTimeInvalid)
    {
      localCMSampleBuffer = readSample(CMTime.CMTimeZero);
      AppMethodBeat.o(201965);
      return localCMSampleBuffer;
    }
    if (this.lastSampleTime.smallThan(CMTime.CMTimeZero))
    {
      localCMSampleBuffer = new CMSampleBuffer(this.lastSampleTime);
      AppMethodBeat.o(201965);
      return localCMSampleBuffer;
    }
    CMSampleBuffer localCMSampleBuffer = readSample(this.lastSampleTime.add(getFrameDuration()));
    AppMethodBeat.o(201965);
    return localCMSampleBuffer;
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(201966);
    if (paramCMTime.smallThan(CMTime.CMTimeZero))
    {
      paramCMTime = readSample();
      AppMethodBeat.o(201966);
      return paramCMTime;
    }
    Logger.e("CachedVideoTrack", "readSample: targetTime = ".concat(String.valueOf(paramCMTime)));
    if (this.currentFrameSegment != null)
    {
      localObject = this.currentFrameSegment.popFrame(paramCMTime);
      if (localObject != null)
      {
        this.lastSampleTime = ((CacheFrame)localObject).frameTime;
        paramCMTime = new StringBuilder("readSample: hint currentSegment ");
        if ((((CacheFrame)localObject).sampleBuffer != null) && (((CacheFrame)localObject).sampleBuffer.getTextureInfo() != null)) {}
        for (boolean bool = true;; bool = false)
        {
          Logger.e("CachedVideoTrack", bool + "  " + ((CacheFrame)localObject).sampleBuffer.isNewFrame() + " time = " + ((CacheFrame)localObject).realFrameTime + "  " + ((CacheFrame)localObject).frameTime);
          paramCMTime = ((CacheFrame)localObject).sampleBuffer;
          AppMethodBeat.o(201966);
          return paramCMTime;
        }
      }
    }
    if (!paramCMTime.smallThan(getDuration()))
    {
      this.lastSampleTime = IDecoder.SAMPLE_TIME_FINISH;
      paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
      AppMethodBeat.o(201966);
      return paramCMTime;
    }
    Object localObject = decoderSegment(paramCMTime);
    if (localObject != null)
    {
      Logger.e("CachedVideoTrack", "readSample: hint currentSegment - " + ((CMSampleBuffer)localObject).getTime());
      AppMethodBeat.o(201966);
      return localObject;
    }
    if (paramCMTime.bigThan(getDuration()))
    {
      this.lastSampleTime = IDecoder.SAMPLE_TIME_FINISH;
      paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
      AppMethodBeat.o(201966);
      return paramCMTime;
    }
    this.lastSampleTime = IDecoder.SAMPLE_TIME_ERROR;
    paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_ERROR);
    AppMethodBeat.o(201966);
    return paramCMTime;
  }
  
  public void release()
  {
    AppMethodBeat.i(201971);
    if (this.currentFrameSegment != null) {
      this.currentFrameSegment.clear();
    }
    if (this.nextFrameSegment != null) {
      this.nextFrameSegment.clear();
    }
    synchronized (this.nextFrameDecoderLock)
    {
      if (this.segmentDecoder != null)
      {
        this.segmentDecoder.release();
        this.segmentDecoder = null;
      }
      AppMethodBeat.o(201971);
      return;
    }
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201964);
    Logger.e("CachedVideoTrack", "seekTo: PlayerThreadMain ".concat(String.valueOf(paramCMTime)));
    int i;
    label120:
    CMSampleBuffer localCMSampleBuffer;
    if (paramCMTime.bigThan(getFrameDuration()))
    {
      this.lastSampleTime = paramCMTime.sub(getFrameDuration());
      if (this.currentFrameSegment != null)
      {
        this.currentFrameSegment.clear();
        this.currentFrameSegment = null;
      }
      if (this.nextFrameSegment != null)
      {
        this.nextFrameSegment.clear();
        this.nextFrameSegment = null;
      }
      if (!paramBoolean1) {
        break label198;
      }
      long l = paramCMTime.getTimeUs() / getFrameDuration().getTimeUs();
      if (paramCMTime.getTimeUs() % getFrameDuration().getTimeUs() <= 0L) {
        break label183;
      }
      i = 1;
      localCMSampleBuffer = decoderFrame(new CMTime((float)((l + i) * getFrameDuration().getTimeUs()) / 1000000.0F));
      if (localCMSampleBuffer != null) {
        break label189;
      }
    }
    label183:
    label189:
    for (paramCMTime = IDecoder.SAMPLE_TIME_FINISH;; paramCMTime = localCMSampleBuffer.getTime())
    {
      this.lastSampleTime = paramCMTime;
      AppMethodBeat.o(201964);
      return localCMSampleBuffer;
      this.lastSampleTime = paramCMTime;
      break;
      i = 0;
      break label120;
    }
    label198:
    AppMethodBeat.o(201964);
    return null;
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    AppMethodBeat.i(201961);
    this.segmentDecoder.decoderTrack.setDecodeType(paramDecodeType);
    AppMethodBeat.o(201961);
  }
  
  public void setFrameRate(int paramInt)
  {
    AppMethodBeat.i(201956);
    this.segmentDecoder.decoderTrack.setFrameRate(paramInt);
    AppMethodBeat.o(201956);
  }
  
  public void setMaxFrameCacheSize(int paramInt)
  {
    AppMethodBeat.i(201973);
    if (paramInt > 0)
    {
      this.segmentSize = paramInt;
      if (this.segmentDecoder != null) {
        this.segmentDecoder.texturePool.setMaxCacheLength(paramInt);
      }
    }
    AppMethodBeat.o(201973);
  }
  
  public void setRevert(boolean paramBoolean)
  {
    this.revert = paramBoolean;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    AppMethodBeat.i(201962);
    this.segmentDecoder.decoderTrack.setTrackSegments(paramList);
    AppMethodBeat.o(201962);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(201959);
    this.segmentDecoder.decoderTrack.setVolume(paramFloat);
    AppMethodBeat.o(201959);
  }
  
  public void start()
  {
    AppMethodBeat.i(201953);
    start(null);
    AppMethodBeat.o(201953);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    AppMethodBeat.i(201954);
    start(paramSurfaceCreator, null);
    AppMethodBeat.o(201954);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(201955);
    this.validTimeRange = paramCMTimeRange;
    this.renderContext = ((RenderContext)paramSurfaceCreator);
    this.segmentDecoder.startForReady();
    AppMethodBeat.o(201955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack
 * JD-Core Version:    0.7.0.1
 */