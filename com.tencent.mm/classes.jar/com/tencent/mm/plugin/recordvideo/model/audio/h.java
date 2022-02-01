package com.tencent.mm.plugin.recordvideo.model.audio;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.plugin.mmsight.segment.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.b;
import java.util.concurrent.Callable;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/GetVideoRecommendAudioTask;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "videoPath", "", "startTime", "", "endTime", "scene", "", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;JJI)V", "getEndTime", "()J", "fetcher", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher;", "frameInterval", "getStartTime", "thumbFetcherPool", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher$FetcherPool;", "getVideoPath", "()Ljava/lang/String;", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "", "onPrepareImageData", "plugin-recordvideo_release"})
public final class h
  extends a
{
  int BPE;
  private d.a BPF;
  private d BPG;
  private final long endTime;
  private final long startTime;
  final String videoPath;
  
  public h(b<com.tencent.mm.vending.e.a> paramb, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    super(paramb);
    AppMethodBeat.i(75431);
    this.videoPath = paramString;
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.BPE = 1000;
    this.scene = paramInt;
    AppMethodBeat.o(75431);
  }
  
  public final Bitmap VB(int paramInt)
  {
    AppMethodBeat.i(75428);
    Log.i(this.TAG, "nextBitmap:" + this.BOS[paramInt]);
    Object localObject = this.BPG;
    if (localObject != null) {}
    for (localObject = ((d)localObject).getFrameAtTime(this.BOS[paramInt]); localObject == null; localObject = null)
    {
      localObject = Bitmap.createBitmap(this.thumbWidth, this.thumbHeight, Bitmap.Config.ARGB_8888);
      p.g(localObject, "Bitmap.createBitmap(thum… Bitmap.Config.ARGB_8888)");
      AppMethodBeat.o(75428);
      return localObject;
    }
    AppMethodBeat.o(75428);
    return localObject;
  }
  
  /* Error */
  public final void eJR()
  {
    // Byte code:
    //   0: ldc 149
    //   2: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 70	com/tencent/mm/plugin/recordvideo/model/audio/h:videoPath	Ljava/lang/String;
    //   9: invokestatic 155	com/tencent/mm/plugin/sight/base/e:aNx	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   12: astore 7
    //   14: aload 7
    //   16: ifnull +304 -> 320
    //   19: aload 7
    //   21: getfield 160	com/tencent/mm/plugin/sight/base/a:videoDuration	I
    //   24: istore_1
    //   25: iload_1
    //   26: ifgt +301 -> 327
    //   29: new 162	com/tencent/mm/compatible/i/d
    //   32: dup
    //   33: invokespecial 164	com/tencent/mm/compatible/i/d:<init>	()V
    //   36: astore 7
    //   38: aload 7
    //   40: aload_0
    //   41: getfield 70	com/tencent/mm/plugin/recordvideo/model/audio/h:videoPath	Ljava/lang/String;
    //   44: invokevirtual 167	com/tencent/mm/compatible/i/d:setDataSource	(Ljava/lang/String;)V
    //   47: aload 7
    //   49: bipush 9
    //   51: invokevirtual 171	com/tencent/mm/compatible/i/d:extractMetadata	(I)Ljava/lang/String;
    //   54: iconst_0
    //   55: invokestatic 177	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   58: istore_2
    //   59: iload_2
    //   60: istore_1
    //   61: iload_1
    //   62: ifgt +32 -> 94
    //   65: aload_0
    //   66: getfield 90	com/tencent/mm/plugin/recordvideo/model/audio/a:TAG	Ljava/lang/String;
    //   69: new 92	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 179
    //   75: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_0
    //   79: getfield 70	com/tencent/mm/plugin/recordvideo/model/audio/h:videoPath	Ljava/lang/String;
    //   82: invokestatic 185	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   85: invokevirtual 188	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: new 193	com/tencent/mm/plugin/mmsight/segment/d$a
    //   98: dup
    //   99: iconst_3
    //   100: new 6	com/tencent/mm/plugin/recordvideo/model/audio/h$a
    //   103: dup
    //   104: aload_0
    //   105: invokespecial 196	com/tencent/mm/plugin/recordvideo/model/audio/h$a:<init>	(Lcom/tencent/mm/plugin/recordvideo/model/audio/h;)V
    //   108: checkcast 198	java/util/concurrent/Callable
    //   111: invokespecial 201	com/tencent/mm/plugin/mmsight/segment/d$a:<init>	(ILjava/util/concurrent/Callable;)V
    //   114: putfield 203	com/tencent/mm/plugin/recordvideo/model/audio/h:BPF	Lcom/tencent/mm/plugin/mmsight/segment/d$a;
    //   117: aload_0
    //   118: getfield 72	com/tencent/mm/plugin/recordvideo/model/audio/h:startTime	J
    //   121: lconst_0
    //   122: lcmp
    //   123: iflt +207 -> 330
    //   126: aload_0
    //   127: getfield 72	com/tencent/mm/plugin/recordvideo/model/audio/h:startTime	J
    //   130: lstore_3
    //   131: aload_0
    //   132: getfield 74	com/tencent/mm/plugin/recordvideo/model/audio/h:endTime	J
    //   135: lconst_0
    //   136: lcmp
    //   137: iflt +198 -> 335
    //   140: aload_0
    //   141: getfield 74	com/tencent/mm/plugin/recordvideo/model/audio/h:endTime	J
    //   144: lstore 5
    //   146: lload 5
    //   148: lload_3
    //   149: lsub
    //   150: lconst_0
    //   151: lcmp
    //   152: ifle +190 -> 342
    //   155: aload_0
    //   156: iconst_3
    //   157: newarray int
    //   159: dup
    //   160: iconst_0
    //   161: ldc2_w 204
    //   164: lload_3
    //   165: ladd
    //   166: l2i
    //   167: iastore
    //   168: dup
    //   169: iconst_1
    //   170: lload 5
    //   172: lload_3
    //   173: lsub
    //   174: ldc2_w 206
    //   177: ldiv
    //   178: l2i
    //   179: iastore
    //   180: dup
    //   181: iconst_2
    //   182: lload 5
    //   184: ldc2_w 204
    //   187: lsub
    //   188: l2i
    //   189: iastore
    //   190: invokevirtual 210	com/tencent/mm/plugin/recordvideo/model/audio/h:I	([I)V
    //   193: aload_0
    //   194: getfield 78	com/tencent/mm/plugin/recordvideo/model/audio/a:scene	I
    //   197: getstatic 216	com/tencent/mm/plugin/recordvideo/b/i:BNI	Lcom/tencent/mm/plugin/recordvideo/b/i;
    //   200: invokevirtual 220	com/tencent/mm/plugin/recordvideo/b/i:ordinal	()I
    //   203: if_icmpne +174 -> 377
    //   206: aload_0
    //   207: lload 5
    //   209: putfield 223	com/tencent/mm/plugin/recordvideo/model/audio/a:pLQ	J
    //   212: aload_0
    //   213: getfield 90	com/tencent/mm/plugin/recordvideo/model/audio/a:TAG	Ljava/lang/String;
    //   216: new 92	java/lang/StringBuilder
    //   219: dup
    //   220: ldc 225
    //   222: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: iload_1
    //   226: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: ldc 227
    //   231: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: lload_3
    //   235: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   238: ldc 235
    //   240: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: lload 5
    //   245: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   248: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload_0
    //   255: getfield 124	com/tencent/mm/plugin/recordvideo/model/audio/a:thumbWidth	I
    //   258: aload_0
    //   259: getfield 127	com/tencent/mm/plugin/recordvideo/model/audio/a:thumbHeight	I
    //   262: getstatic 133	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   265: invokestatic 139	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   268: astore 8
    //   270: aload_0
    //   271: getfield 203	com/tencent/mm/plugin/recordvideo/model/audio/h:BPF	Lcom/tencent/mm/plugin/mmsight/segment/d$a;
    //   274: astore 7
    //   276: aload 7
    //   278: ifnull +108 -> 386
    //   281: aload 7
    //   283: invokevirtual 239	com/tencent/mm/plugin/mmsight/segment/d$a:ekq	()Lcom/tencent/mm/plugin/mmsight/segment/d;
    //   286: astore 7
    //   288: aload_0
    //   289: aload 7
    //   291: putfield 115	com/tencent/mm/plugin/recordvideo/model/audio/h:BPG	Lcom/tencent/mm/plugin/mmsight/segment/d;
    //   294: aload_0
    //   295: getfield 115	com/tencent/mm/plugin/recordvideo/model/audio/h:BPG	Lcom/tencent/mm/plugin/mmsight/segment/d;
    //   298: astore 7
    //   300: aload 7
    //   302: ifnull +90 -> 392
    //   305: aload 7
    //   307: aload 8
    //   309: invokeinterface 243 2 0
    //   314: ldc 149
    //   316: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: return
    //   320: iconst_0
    //   321: istore_1
    //   322: goto -297 -> 25
    //   325: astore 7
    //   327: goto -266 -> 61
    //   330: lconst_0
    //   331: lstore_3
    //   332: goto -201 -> 131
    //   335: iload_1
    //   336: i2l
    //   337: lstore 5
    //   339: goto -193 -> 146
    //   342: iload_1
    //   343: sipush 300
    //   346: if_icmple -153 -> 193
    //   349: aload_0
    //   350: iconst_3
    //   351: newarray int
    //   353: dup
    //   354: iconst_0
    //   355: bipush 100
    //   357: iastore
    //   358: dup
    //   359: iconst_1
    //   360: iload_1
    //   361: iconst_2
    //   362: idiv
    //   363: iastore
    //   364: dup
    //   365: iconst_2
    //   366: iload_1
    //   367: bipush 100
    //   369: isub
    //   370: iastore
    //   371: invokevirtual 210	com/tencent/mm/plugin/recordvideo/model/audio/h:I	([I)V
    //   374: goto -181 -> 193
    //   377: aload_0
    //   378: iload_1
    //   379: i2l
    //   380: putfield 223	com/tencent/mm/plugin/recordvideo/model/audio/a:pLQ	J
    //   383: goto -171 -> 212
    //   386: aconst_null
    //   387: astore 7
    //   389: goto -101 -> 288
    //   392: ldc 149
    //   394: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   397: return
    //   398: astore 7
    //   400: aload_0
    //   401: getfield 90	com/tencent/mm/plugin/recordvideo/model/audio/a:TAG	Ljava/lang/String;
    //   404: aload 7
    //   406: checkcast 245	java/lang/Throwable
    //   409: ldc 247
    //   411: iconst_0
    //   412: anewarray 249	java/lang/Object
    //   415: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   418: ldc 149
    //   420: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	h
    //   24	355	1	i	int
    //   58	2	2	j	int
    //   130	202	3	l1	long
    //   144	194	5	l2	long
    //   12	294	7	localObject1	Object
    //   325	1	7	localException1	java.lang.Exception
    //   387	1	7	localObject2	Object
    //   398	7	7	localException2	java.lang.Exception
    //   268	40	8	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   29	59	325	java/lang/Exception
    //   254	276	398	java/lang/Exception
    //   281	288	398	java/lang/Exception
    //   288	300	398	java/lang/Exception
    //   305	319	398	java/lang/Exception
  }
  
  public final void eJS()
  {
    AppMethodBeat.i(75430);
    d.a locala = this.BPF;
    if (locala != null) {
      locala.a(this.BPG);
    }
    locala = this.BPF;
    if (locala != null)
    {
      locala.destroy();
      AppMethodBeat.o(75430);
      return;
    }
    AppMethodBeat.o(75430);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher;", "kotlin.jvm.PlatformType", "call"})
  static final class a<V>
    implements Callable<d>
  {
    a(h paramh) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.h
 * JD-Core Version:    0.7.0.1
 */