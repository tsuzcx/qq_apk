package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.ITexturePool;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.AverageTimeReporter;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CachedVideoDecoderTrack
  implements IDecoderTrack
{
  private static final String TAG = "CachedVideoTrack";
  private CacheSegment currentFrameSegment;
  private CMSampleState lastSampleState;
  final Object nextFrameDecoderLock;
  private CacheSegment nextFrameSegment;
  RenderContext renderContext;
  boolean revert;
  private SegmentDecoderThread segmentDecoder;
  private int segmentSize;
  CMTimeRange validTimeRange;
  
  public CachedVideoDecoderTrack(IDecoderTrack paramIDecoderTrack, boolean paramBoolean)
  {
    AppMethodBeat.i(191840);
    this.segmentSize = 60;
    this.nextFrameDecoderLock = new Object();
    this.lastSampleState = new CMSampleState();
    this.revert = paramBoolean;
    this.segmentDecoder = new SegmentDecoderThread(this, paramIDecoderTrack);
    AppMethodBeat.o(191840);
  }
  
  private void clearCurrentFrameSegment()
  {
    AppMethodBeat.i(191902);
    if (this.currentFrameSegment != null)
    {
      this.currentFrameSegment.clear();
      this.currentFrameSegment = null;
    }
    AppMethodBeat.o(191902);
  }
  
  private CMSampleBuffer decoderFrame(CMTime paramCMTime)
  {
    AppMethodBeat.i(191891);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.segmentDecoder.decoderSegment(paramCMTime, localCountDownLatch);
    try
    {
      localCountDownLatch.await(5L, TimeUnit.SECONDS);
      label34:
      paramCMTime = this.segmentDecoder.seekSampleBuffer;
      AppMethodBeat.o(191891);
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
    //   0: ldc 100
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 102	com/tencent/tav/decoder/decodecache/RequestStatus
    //   8: dup
    //   9: invokespecial 103	com/tencent/tav/decoder/decodecache/RequestStatus:<init>	()V
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   18: ifnull +510 -> 528
    //   21: aload_0
    //   22: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   25: getfield 108	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   28: ifnull +500 -> 528
    //   31: aload_0
    //   32: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   35: getfield 108	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   38: aload_1
    //   39: invokevirtual 114	com/tencent/tav/coremedia/CMTimeRange:containsTime	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   42: ifeq +486 -> 528
    //   45: aload_0
    //   46: getfield 43	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameDecoderLock	Ljava/lang/Object;
    //   49: astore_3
    //   50: aload_3
    //   51: monitorenter
    //   52: aload_0
    //   53: invokespecial 116	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:clearCurrentFrameSegment	()V
    //   56: aload_0
    //   57: new 67	com/tencent/tav/decoder/decodecache/CacheSegment
    //   60: dup
    //   61: aload_0
    //   62: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   65: getfield 108	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   68: invokespecial 119	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   71: putfield 65	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   74: aload_0
    //   75: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   78: getfield 123	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   81: invokeinterface 129 1 0
    //   86: astore 5
    //   88: aload 5
    //   90: invokeinterface 135 1 0
    //   95: ifeq +37 -> 132
    //   98: aload 5
    //   100: invokeinterface 139 1 0
    //   105: checkcast 141	com/tencent/tav/decoder/decodecache/CacheFrame
    //   108: astore 6
    //   110: aload_0
    //   111: getfield 65	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   114: aload 6
    //   116: invokevirtual 145	com/tencent/tav/decoder/decodecache/CacheSegment:pushFrame	(Lcom/tencent/tav/decoder/decodecache/CacheFrame;)V
    //   119: goto -31 -> 88
    //   122: astore_1
    //   123: aload_3
    //   124: monitorexit
    //   125: ldc 100
    //   127: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_1
    //   131: athrow
    //   132: aload_0
    //   133: getfield 65	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   136: aload_1
    //   137: invokevirtual 149	com/tencent/tav/decoder/decodecache/CacheSegment:popFrame	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/decoder/decodecache/CacheFrame;
    //   140: astore 5
    //   142: aload 5
    //   144: ifnull +197 -> 341
    //   147: new 151	java/lang/StringBuilder
    //   150: dup
    //   151: ldc 153
    //   153: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: astore_1
    //   157: aload 5
    //   159: getfield 159	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   162: ifnull +168 -> 330
    //   165: aload 5
    //   167: getfield 159	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   170: invokevirtual 165	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   173: ifnull +157 -> 330
    //   176: iconst_1
    //   177: istore_2
    //   178: aload_1
    //   179: iload_2
    //   180: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: ldc 171
    //   185: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: astore 4
    //   190: aload 5
    //   192: getfield 159	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   195: ifnull +140 -> 335
    //   198: aload 5
    //   200: getfield 159	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   203: invokevirtual 177	com/tencent/tav/coremedia/CMSampleBuffer:isNewFrame	()Z
    //   206: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   209: astore_1
    //   210: ldc 10
    //   212: aload 4
    //   214: aload_1
    //   215: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: ldc 188
    //   220: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 5
    //   225: getfield 192	com/tencent/tav/decoder/decodecache/CacheFrame:realFrameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   228: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: ldc 171
    //   233: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 5
    //   238: getfield 195	com/tencent/tav/decoder/decodecache/CacheFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   241: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 205	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload_0
    //   251: new 67	com/tencent/tav/decoder/decodecache/CacheSegment
    //   254: dup
    //   255: new 110	com/tencent/tav/coremedia/CMTimeRange
    //   258: dup
    //   259: aload_0
    //   260: getfield 65	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   263: invokevirtual 209	com/tencent/tav/decoder/decodecache/CacheSegment:getLastFrameTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   266: aload_0
    //   267: invokevirtual 212	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:getFrameDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   270: aload_0
    //   271: getfield 41	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentSize	I
    //   274: i2f
    //   275: invokevirtual 218	com/tencent/tav/coremedia/CMTime:multi	(F)Lcom/tencent/tav/coremedia/CMTime;
    //   278: invokespecial 221	com/tencent/tav/coremedia/CMTimeRange:<init>	(Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V
    //   281: invokespecial 119	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   284: putfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   287: aload_0
    //   288: getfield 57	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   291: aload_0
    //   292: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   295: aconst_null
    //   296: invokevirtual 224	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:decoderSegment	(Lcom/tencent/tav/decoder/decodecache/CacheSegment;Lcom/tencent/tav/decoder/decodecache/RequestStatus;)V
    //   299: aload_0
    //   300: new 45	com/tencent/tav/coremedia/CMSampleState
    //   303: dup
    //   304: aload 5
    //   306: getfield 195	com/tencent/tav/decoder/decodecache/CacheFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   309: invokespecial 227	com/tencent/tav/coremedia/CMSampleState:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   312: putfield 48	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:lastSampleState	Lcom/tencent/tav/coremedia/CMSampleState;
    //   315: aload 5
    //   317: getfield 159	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   320: astore_1
    //   321: aload_3
    //   322: monitorexit
    //   323: ldc 100
    //   325: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: aload_1
    //   329: areturn
    //   330: iconst_0
    //   331: istore_2
    //   332: goto -154 -> 178
    //   335: ldc 229
    //   337: astore_1
    //   338: goto -128 -> 210
    //   341: ldc 10
    //   343: new 151	java/lang/StringBuilder
    //   346: dup
    //   347: ldc 231
    //   349: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   352: aload_0
    //   353: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   356: getfield 123	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   359: invokeinterface 235 1 0
    //   364: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: ldc 171
    //   369: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: getfield 65	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   376: getfield 123	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   379: invokeinterface 235 1 0
    //   384: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 241	com/tencent/tav/decoder/logger/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload_3
    //   394: monitorexit
    //   395: aload_0
    //   396: getfield 57	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   399: iconst_1
    //   400: putfield 244	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:cancel	Z
    //   403: aload_0
    //   404: getfield 43	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameDecoderLock	Ljava/lang/Object;
    //   407: astore_3
    //   408: aload_3
    //   409: monitorenter
    //   410: aload_0
    //   411: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   414: ifnull +10 -> 424
    //   417: aload_0
    //   418: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   421: invokevirtual 70	com/tencent/tav/decoder/decodecache/CacheSegment:clear	()V
    //   424: aload_0
    //   425: new 67	com/tencent/tav/decoder/decodecache/CacheSegment
    //   428: dup
    //   429: new 110	com/tencent/tav/coremedia/CMTimeRange
    //   432: dup
    //   433: aload_1
    //   434: aload_0
    //   435: invokevirtual 212	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:getFrameDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   438: aload_0
    //   439: getfield 41	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentSize	I
    //   442: i2f
    //   443: invokevirtual 218	com/tencent/tav/coremedia/CMTime:multi	(F)Lcom/tencent/tav/coremedia/CMTime;
    //   446: invokespecial 221	com/tencent/tav/coremedia/CMTimeRange:<init>	(Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V
    //   449: invokespecial 119	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   452: putfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   455: aload_0
    //   456: getfield 57	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   459: aload_0
    //   460: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   463: aload 4
    //   465: invokevirtual 224	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:decoderSegment	(Lcom/tencent/tav/decoder/decodecache/CacheSegment;Lcom/tencent/tav/decoder/decodecache/RequestStatus;)V
    //   468: aload_3
    //   469: monitorexit
    //   470: aload 4
    //   472: monitorenter
    //   473: aload 4
    //   475: invokevirtual 247	com/tencent/tav/decoder/decodecache/RequestStatus:getFinish	()Z
    //   478: ifne +11 -> 489
    //   481: aload 4
    //   483: ldc2_w 248
    //   486: invokevirtual 253	java/lang/Object:wait	(J)V
    //   489: aload 4
    //   491: monitorexit
    //   492: aload_0
    //   493: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   496: getfield 123	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   499: invokeinterface 235 1 0
    //   504: ifne +105 -> 609
    //   507: new 161	com/tencent/tav/coremedia/CMSampleBuffer
    //   510: dup
    //   511: ldc2_w 254
    //   514: invokestatic 259	com/tencent/tav/coremedia/CMSampleState:fromError	(J)Lcom/tencent/tav/coremedia/CMSampleState;
    //   517: invokespecial 262	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMSampleState;)V
    //   520: astore_1
    //   521: ldc 100
    //   523: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   526: aload_1
    //   527: areturn
    //   528: new 151	java/lang/StringBuilder
    //   531: dup
    //   532: ldc_w 264
    //   535: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   538: astore 5
    //   540: aload_0
    //   541: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   544: ifnonnull +33 -> 577
    //   547: ldc_w 266
    //   550: astore_3
    //   551: ldc 10
    //   553: aload 5
    //   555: aload_3
    //   556: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   559: ldc 171
    //   561: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_1
    //   565: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 241	com/tencent/tav/decoder/logger/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   574: goto -171 -> 403
    //   577: aload_0
    //   578: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   581: getfield 108	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   584: astore_3
    //   585: goto -34 -> 551
    //   588: astore_1
    //   589: aload_3
    //   590: monitorexit
    //   591: ldc 100
    //   593: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   596: aload_1
    //   597: athrow
    //   598: astore_1
    //   599: aload 4
    //   601: monitorexit
    //   602: ldc 100
    //   604: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   607: aload_1
    //   608: athrow
    //   609: aload_0
    //   610: invokespecial 116	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:clearCurrentFrameSegment	()V
    //   613: aload_0
    //   614: new 67	com/tencent/tav/decoder/decodecache/CacheSegment
    //   617: dup
    //   618: aload_0
    //   619: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   622: getfield 108	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   625: invokespecial 119	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   628: putfield 65	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   631: aload_0
    //   632: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   635: getfield 123	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   638: invokeinterface 129 1 0
    //   643: astore_1
    //   644: aload_1
    //   645: invokeinterface 135 1 0
    //   650: ifeq +24 -> 674
    //   653: aload_1
    //   654: invokeinterface 139 1 0
    //   659: checkcast 141	com/tencent/tav/decoder/decodecache/CacheFrame
    //   662: astore_3
    //   663: aload_0
    //   664: getfield 65	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   667: aload_3
    //   668: invokevirtual 145	com/tencent/tav/decoder/decodecache/CacheSegment:pushFrame	(Lcom/tencent/tav/decoder/decodecache/CacheFrame;)V
    //   671: goto -27 -> 644
    //   674: aload_0
    //   675: getfield 43	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameDecoderLock	Ljava/lang/Object;
    //   678: astore_1
    //   679: aload_1
    //   680: monitorenter
    //   681: aload_0
    //   682: new 67	com/tencent/tav/decoder/decodecache/CacheSegment
    //   685: dup
    //   686: new 110	com/tencent/tav/coremedia/CMTimeRange
    //   689: dup
    //   690: aload_0
    //   691: getfield 65	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   694: invokevirtual 209	com/tencent/tav/decoder/decodecache/CacheSegment:getLastFrameTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   697: aload_0
    //   698: invokevirtual 212	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:getFrameDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   701: aload_0
    //   702: getfield 41	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentSize	I
    //   705: i2f
    //   706: invokevirtual 218	com/tencent/tav/coremedia/CMTime:multi	(F)Lcom/tencent/tav/coremedia/CMTime;
    //   709: invokespecial 221	com/tencent/tav/coremedia/CMTimeRange:<init>	(Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V
    //   712: invokespecial 119	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   715: putfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   718: aload_0
    //   719: getfield 57	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   722: aload_0
    //   723: getfield 105	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   726: aconst_null
    //   727: invokevirtual 224	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:decoderSegment	(Lcom/tencent/tav/decoder/decodecache/CacheSegment;Lcom/tencent/tav/decoder/decodecache/RequestStatus;)V
    //   730: aload_1
    //   731: monitorexit
    //   732: aload_0
    //   733: getfield 65	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   736: ifnull +72 -> 808
    //   739: aload_0
    //   740: getfield 65	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   743: getfield 123	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   746: invokeinterface 235 1 0
    //   751: ifle +57 -> 808
    //   754: aload_0
    //   755: getfield 65	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   758: getfield 123	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   761: iconst_0
    //   762: invokeinterface 270 2 0
    //   767: checkcast 141	com/tencent/tav/decoder/decodecache/CacheFrame
    //   770: astore_1
    //   771: aload_0
    //   772: new 45	com/tencent/tav/coremedia/CMSampleState
    //   775: dup
    //   776: aload_1
    //   777: getfield 195	com/tencent/tav/decoder/decodecache/CacheFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   780: invokespecial 227	com/tencent/tav/coremedia/CMSampleState:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   783: putfield 48	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:lastSampleState	Lcom/tencent/tav/coremedia/CMSampleState;
    //   786: aload_1
    //   787: getfield 159	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   790: astore_1
    //   791: ldc 100
    //   793: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   796: aload_1
    //   797: areturn
    //   798: astore_3
    //   799: aload_1
    //   800: monitorexit
    //   801: ldc 100
    //   803: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   806: aload_3
    //   807: athrow
    //   808: ldc 100
    //   810: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   813: aconst_null
    //   814: areturn
    //   815: astore_1
    //   816: goto -327 -> 489
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	819	0	this	CachedVideoDecoderTrack
    //   177	155	2	bool	boolean
    //   49	619	3	localObject1	Object
    //   798	9	3	localObject2	Object
    //   12	588	4	localObject3	Object
    //   86	468	5	localObject4	Object
    //   108	7	6	localCacheFrame	CacheFrame
    // Exception table:
    //   from	to	target	type
    //   52	88	122	finally
    //   88	119	122	finally
    //   132	142	122	finally
    //   147	176	122	finally
    //   178	210	122	finally
    //   210	323	122	finally
    //   341	395	122	finally
    //   410	424	588	finally
    //   424	470	588	finally
    //   473	489	598	finally
    //   489	492	598	finally
    //   681	732	798	finally
    //   473	489	815	java/lang/InterruptedException
  }
  
  public void asyncReadNextSample(CMTime paramCMTime) {}
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(191862);
    this.segmentDecoder.decoderTrack.clipRangeAndClearRange(paramCMTimeRange);
    AppMethodBeat.o(191862);
  }
  
  public CMTime getCurrentSampleTime()
  {
    AppMethodBeat.i(191910);
    CMTime localCMTime = this.lastSampleState.getTime();
    AppMethodBeat.o(191910);
    return localCMTime;
  }
  
  public AverageTimeReporter getDecodePerformance()
  {
    return null;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(191907);
    CMTime localCMTime = this.segmentDecoder.decoderTrack.getDuration();
    AppMethodBeat.o(191907);
    return localCMTime;
  }
  
  public CMTime getFrameDuration()
  {
    AppMethodBeat.i(191853);
    CMTime localCMTime = this.segmentDecoder.decoderTrack.getFrameDuration();
    AppMethodBeat.o(191853);
    return localCMTime;
  }
  
  public int getFrameRate()
  {
    AppMethodBeat.i(191852);
    int i = this.segmentDecoder.decoderTrack.getFrameRate();
    AppMethodBeat.o(191852);
    return i;
  }
  
  public long getLaggingTime()
  {
    return 0L;
  }
  
  public int getTrackId()
  {
    AppMethodBeat.i(191855);
    int i = this.segmentDecoder.decoderTrack.getTrackId();
    AppMethodBeat.o(191855);
    return i;
  }
  
  public CMSampleBuffer readSample()
  {
    AppMethodBeat.i(191877);
    if (this.lastSampleState.isInvalid())
    {
      localCMSampleBuffer = readSample(CMTime.CMTimeZero);
      AppMethodBeat.o(191877);
      return localCMSampleBuffer;
    }
    if (this.lastSampleState.getTime().smallThan(CMTime.CMTimeZero))
    {
      localCMSampleBuffer = new CMSampleBuffer(this.lastSampleState);
      AppMethodBeat.o(191877);
      return localCMSampleBuffer;
    }
    CMSampleBuffer localCMSampleBuffer = readSample(this.lastSampleState.getTime().add(getFrameDuration()));
    AppMethodBeat.o(191877);
    return localCMSampleBuffer;
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(191886);
    if (paramCMTime.smallThan(CMTime.CMTimeZero))
    {
      paramCMTime = readSample();
      AppMethodBeat.o(191886);
      return paramCMTime;
    }
    Logger.v("CachedVideoTrack", "readSample: targetTime = ".concat(String.valueOf(paramCMTime)));
    if (this.currentFrameSegment != null)
    {
      localObject = this.currentFrameSegment.popFrame(paramCMTime);
      if (localObject != null)
      {
        this.lastSampleState = new CMSampleState(((CacheFrame)localObject).frameTime);
        paramCMTime = new StringBuilder("readSample: hint currentSegment ");
        boolean bool;
        StringBuilder localStringBuilder;
        if ((((CacheFrame)localObject).sampleBuffer != null) && (((CacheFrame)localObject).sampleBuffer.getTextureInfo() != null))
        {
          bool = true;
          localStringBuilder = paramCMTime.append(bool).append("  ");
          if (((CacheFrame)localObject).sampleBuffer == null) {
            break label195;
          }
        }
        label195:
        for (paramCMTime = Boolean.valueOf(((CacheFrame)localObject).sampleBuffer.isNewFrame());; paramCMTime = "null")
        {
          Logger.v("CachedVideoTrack", paramCMTime + " time = " + ((CacheFrame)localObject).realFrameTime + "  " + ((CacheFrame)localObject).frameTime);
          paramCMTime = ((CacheFrame)localObject).sampleBuffer;
          AppMethodBeat.o(191886);
          return paramCMTime;
          bool = false;
          break;
        }
      }
    }
    if (!paramCMTime.smallThan(getDuration()))
    {
      this.lastSampleState = CMSampleState.fromError(-1L);
      paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
      AppMethodBeat.o(191886);
      return paramCMTime;
    }
    Object localObject = decoderSegment(paramCMTime);
    if (localObject != null)
    {
      Logger.v("CachedVideoTrack", "readSample: hint currentSegment - " + ((CMSampleBuffer)localObject).getTime());
      AppMethodBeat.o(191886);
      return localObject;
    }
    if (paramCMTime.bigThan(getDuration()))
    {
      this.lastSampleState = CMSampleState.fromError(-1L);
      paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
      AppMethodBeat.o(191886);
      return paramCMTime;
    }
    this.lastSampleState = CMSampleState.fromError(-3L);
    paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-3L));
    AppMethodBeat.o(191886);
    return paramCMTime;
  }
  
  public void release()
  {
    AppMethodBeat.i(191915);
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
      AppMethodBeat.o(191915);
      return;
    }
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(191874);
    Logger.v("CachedVideoTrack", "seekTo: PlayerThreadMain ".concat(String.valueOf(paramCMTime)));
    int i;
    label127:
    CMSampleBuffer localCMSampleBuffer;
    if (paramCMTime.bigThan(getFrameDuration()))
    {
      this.lastSampleState = new CMSampleState(paramCMTime.sub(getFrameDuration()));
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
        break label215;
      }
      long l = paramCMTime.getTimeUs() / getFrameDuration().getTimeUs();
      if (paramCMTime.getTimeUs() % getFrameDuration().getTimeUs() <= 0L) {
        break label200;
      }
      i = 1;
      localCMSampleBuffer = decoderFrame(new CMTime((float)((l + i) * getFrameDuration().getTimeUs()) / 1000000.0F));
      if (localCMSampleBuffer != null) {
        break label206;
      }
    }
    label200:
    label206:
    for (paramCMTime = CMSampleState.fromError(-1L);; paramCMTime = localCMSampleBuffer.getState())
    {
      this.lastSampleState = paramCMTime;
      AppMethodBeat.o(191874);
      return localCMSampleBuffer;
      this.lastSampleState = new CMSampleState(paramCMTime);
      break;
      i = 0;
      break label127;
    }
    label215:
    AppMethodBeat.o(191874);
    return null;
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    AppMethodBeat.i(191857);
    this.segmentDecoder.decoderTrack.setDecodeType(paramDecodeType);
    AppMethodBeat.o(191857);
  }
  
  public void setFrameRate(int paramInt)
  {
    AppMethodBeat.i(191851);
    this.segmentDecoder.decoderTrack.setFrameRate(paramInt);
    AppMethodBeat.o(191851);
  }
  
  public void setMaxFrameCacheSize(int paramInt)
  {
    AppMethodBeat.i(191920);
    if (paramInt > 0)
    {
      this.segmentSize = paramInt;
      if (this.segmentDecoder != null) {
        this.segmentDecoder.texturePool.setMaxCacheLength(paramInt);
      }
    }
    AppMethodBeat.o(191920);
  }
  
  public void setRevert(boolean paramBoolean)
  {
    this.revert = paramBoolean;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    AppMethodBeat.i(191859);
    this.segmentDecoder.decoderTrack.setTrackSegments(paramList);
    AppMethodBeat.o(191859);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(191854);
    this.segmentDecoder.decoderTrack.setVolume(paramFloat);
    AppMethodBeat.o(191854);
  }
  
  public void start()
  {
    AppMethodBeat.i(191841);
    start(null);
    AppMethodBeat.o(191841);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    AppMethodBeat.i(191844);
    start(paramSurfaceCreator, null);
    AppMethodBeat.o(191844);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(191847);
    this.validTimeRange = paramCMTimeRange;
    this.renderContext = ((RenderContext)paramSurfaceCreator);
    this.segmentDecoder.startForReady();
    AppMethodBeat.o(191847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack
 * JD-Core Version:    0.7.0.1
 */