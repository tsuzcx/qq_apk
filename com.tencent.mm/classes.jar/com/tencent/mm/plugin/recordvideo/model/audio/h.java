package com.tencent.mm.plugin.recordvideo.model.audio;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.plugin.mmsight.segment.d.a;
import com.tencent.mm.plugin.mmsight.segment.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/GetVideoRecommendAudioTask;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "videoPath", "", "startTime", "", "endTime", "scene", "", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;JJI)V", "getEndTime", "()J", "fetcher", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher;", "frameInterval", "getStartTime", "thumbFetcherPool", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher$FetcherPool;", "getVideoPath", "()Ljava/lang/String;", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "", "onPrepareImageData", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a
{
  private int NJn;
  private d.a NJo;
  private d NJp;
  private final long endTime;
  private final long startTime;
  private final String videoPath;
  
  public h(b<com.tencent.mm.vending.e.a> paramb, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    super(paramb);
    AppMethodBeat.i(75431);
    this.videoPath = paramString;
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.NJn = 1000;
    setScene(paramInt);
    AppMethodBeat.o(75431);
  }
  
  private static final d a(h paramh)
  {
    AppMethodBeat.i(279636);
    s.u(paramh, "this$0");
    paramh = o.q(paramh.videoPath, paramh.NJn, paramh.thumbWidth, paramh.thumbHeight);
    AppMethodBeat.o(279636);
    return paramh;
  }
  
  public final Bitmap agx(int paramInt)
  {
    AppMethodBeat.i(75428);
    Log.i(this.TAG, s.X("nextBitmap:", Integer.valueOf(this.NIx[paramInt])));
    Object localObject = this.NJp;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((d)localObject).getFrameAtTime(this.NIx[paramInt]))
    {
      localObject = Bitmap.createBitmap(this.thumbWidth, this.thumbHeight, Bitmap.Config.ARGB_8888);
      s.s(localObject, "{\n\n            // TODO c…nfig.ARGB_8888)\n        }");
      AppMethodBeat.o(75428);
      return localObject;
    }
    AppMethodBeat.o(75428);
    return localObject;
  }
  
  /* Error */
  public final void gHK()
  {
    // Byte code:
    //   0: ldc 164
    //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 81	com/tencent/mm/plugin/recordvideo/model/audio/h:videoPath	Ljava/lang/String;
    //   9: invokestatic 170	com/tencent/mm/plugin/sight/base/f:aVX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/b;
    //   12: astore 7
    //   14: aload 7
    //   16: ifnonnull +287 -> 303
    //   19: iconst_0
    //   20: istore_1
    //   21: iload_1
    //   22: ifgt +292 -> 314
    //   25: new 172	com/tencent/mm/compatible/i/d
    //   28: dup
    //   29: invokespecial 174	com/tencent/mm/compatible/i/d:<init>	()V
    //   32: astore 7
    //   34: aload 7
    //   36: aload_0
    //   37: getfield 81	com/tencent/mm/plugin/recordvideo/model/audio/h:videoPath	Ljava/lang/String;
    //   40: invokevirtual 178	com/tencent/mm/compatible/i/d:setDataSource	(Ljava/lang/String;)V
    //   43: aload 7
    //   45: bipush 9
    //   47: invokevirtual 182	com/tencent/mm/compatible/i/d:extractMetadata	(I)Ljava/lang/String;
    //   50: iconst_0
    //   51: invokestatic 188	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   54: istore_2
    //   55: iload_2
    //   56: istore_1
    //   57: iload_1
    //   58: ifgt +25 -> 83
    //   61: aload_0
    //   62: getfield 113	com/tencent/mm/plugin/recordvideo/model/audio/a:TAG	Ljava/lang/String;
    //   65: ldc 190
    //   67: aload_0
    //   68: getfield 81	com/tencent/mm/plugin/recordvideo/model/audio/h:videoPath	Ljava/lang/String;
    //   71: invokestatic 196	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   74: invokestatic 201	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   77: invokestatic 129	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   80: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: new 206	com/tencent/mm/plugin/mmsight/segment/d$a
    //   87: dup
    //   88: iconst_3
    //   89: new 208	com/tencent/mm/plugin/recordvideo/model/audio/h$$ExternalSyntheticLambda0
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 211	com/tencent/mm/plugin/recordvideo/model/audio/h$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/recordvideo/model/audio/h;)V
    //   97: invokespecial 214	com/tencent/mm/plugin/mmsight/segment/d$a:<init>	(ILjava/util/concurrent/Callable;)V
    //   100: putfield 216	com/tencent/mm/plugin/recordvideo/model/audio/h:NJo	Lcom/tencent/mm/plugin/mmsight/segment/d$a;
    //   103: aload_0
    //   104: getfield 83	com/tencent/mm/plugin/recordvideo/model/audio/h:startTime	J
    //   107: lconst_0
    //   108: lcmp
    //   109: iflt +208 -> 317
    //   112: aload_0
    //   113: getfield 83	com/tencent/mm/plugin/recordvideo/model/audio/h:startTime	J
    //   116: lstore_3
    //   117: aload_0
    //   118: getfield 85	com/tencent/mm/plugin/recordvideo/model/audio/h:endTime	J
    //   121: lconst_0
    //   122: lcmp
    //   123: iflt +199 -> 322
    //   126: aload_0
    //   127: getfield 85	com/tencent/mm/plugin/recordvideo/model/audio/h:endTime	J
    //   130: lstore 5
    //   132: lload 5
    //   134: lload_3
    //   135: lsub
    //   136: lconst_0
    //   137: lcmp
    //   138: ifle +191 -> 329
    //   141: aload_0
    //   142: iconst_3
    //   143: newarray int
    //   145: dup
    //   146: iconst_0
    //   147: ldc2_w 217
    //   150: lload_3
    //   151: ladd
    //   152: l2i
    //   153: iastore
    //   154: dup
    //   155: iconst_1
    //   156: lload 5
    //   158: lload_3
    //   159: lsub
    //   160: ldc2_w 219
    //   163: ldiv
    //   164: l2i
    //   165: iastore
    //   166: dup
    //   167: iconst_2
    //   168: lload 5
    //   170: ldc2_w 217
    //   173: lsub
    //   174: l2i
    //   175: iastore
    //   176: invokevirtual 224	com/tencent/mm/plugin/recordvideo/model/audio/h:L	([I)V
    //   179: aload_0
    //   180: invokevirtual 228	com/tencent/mm/plugin/recordvideo/model/audio/h:getScene	()I
    //   183: getstatic 234	com/tencent/mm/plugin/recordvideo/c/k:NHp	Lcom/tencent/mm/plugin/recordvideo/c/k;
    //   186: invokevirtual 237	com/tencent/mm/plugin/recordvideo/c/k:ordinal	()I
    //   189: if_icmpne +175 -> 364
    //   192: aload_0
    //   193: lload 5
    //   195: invokevirtual 241	com/tencent/mm/plugin/recordvideo/model/audio/h:kq	(J)V
    //   198: aload_0
    //   199: getfield 113	com/tencent/mm/plugin/recordvideo/model/audio/a:TAG	Ljava/lang/String;
    //   202: new 243	java/lang/StringBuilder
    //   205: dup
    //   206: ldc 245
    //   208: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   211: iload_1
    //   212: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: ldc 253
    //   217: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: lload_3
    //   221: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: ldc_w 261
    //   227: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: lload 5
    //   232: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: getfield 98	com/tencent/mm/plugin/recordvideo/model/audio/a:thumbWidth	I
    //   245: aload_0
    //   246: getfield 101	com/tencent/mm/plugin/recordvideo/model/audio/a:thumbHeight	I
    //   249: getstatic 142	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   252: invokestatic 148	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   255: astore 8
    //   257: aload_0
    //   258: getfield 216	com/tencent/mm/plugin/recordvideo/model/audio/h:NJo	Lcom/tencent/mm/plugin/mmsight/segment/d$a;
    //   261: astore 7
    //   263: aload 7
    //   265: ifnonnull +108 -> 373
    //   268: aconst_null
    //   269: astore 7
    //   271: aload_0
    //   272: aload 7
    //   274: putfield 136	com/tencent/mm/plugin/recordvideo/model/audio/h:NJp	Lcom/tencent/mm/plugin/mmsight/segment/d;
    //   277: aload_0
    //   278: getfield 136	com/tencent/mm/plugin/recordvideo/model/audio/h:NJp	Lcom/tencent/mm/plugin/mmsight/segment/d;
    //   281: astore 7
    //   283: aload 7
    //   285: ifnull +119 -> 404
    //   288: aload 7
    //   290: aload 8
    //   292: invokeinterface 268 2 0
    //   297: ldc 164
    //   299: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: return
    //   303: aload 7
    //   305: getfield 273	com/tencent/mm/plugin/sight/base/b:videoDuration	I
    //   308: istore_1
    //   309: goto -288 -> 21
    //   312: astore 7
    //   314: goto -257 -> 57
    //   317: lconst_0
    //   318: lstore_3
    //   319: goto -202 -> 117
    //   322: iload_1
    //   323: i2l
    //   324: lstore 5
    //   326: goto -194 -> 132
    //   329: iload_1
    //   330: sipush 300
    //   333: if_icmple -154 -> 179
    //   336: aload_0
    //   337: iconst_3
    //   338: newarray int
    //   340: dup
    //   341: iconst_0
    //   342: bipush 100
    //   344: iastore
    //   345: dup
    //   346: iconst_1
    //   347: iload_1
    //   348: iconst_2
    //   349: idiv
    //   350: iastore
    //   351: dup
    //   352: iconst_2
    //   353: iload_1
    //   354: bipush 100
    //   356: isub
    //   357: iastore
    //   358: invokevirtual 224	com/tencent/mm/plugin/recordvideo/model/audio/h:L	([I)V
    //   361: goto -182 -> 179
    //   364: aload_0
    //   365: iload_1
    //   366: i2l
    //   367: invokevirtual 241	com/tencent/mm/plugin/recordvideo/model/audio/h:kq	(J)V
    //   370: goto -172 -> 198
    //   373: aload 7
    //   375: invokevirtual 277	com/tencent/mm/plugin/mmsight/segment/d$a:gcQ	()Lcom/tencent/mm/plugin/mmsight/segment/d;
    //   378: astore 7
    //   380: goto -109 -> 271
    //   383: astore 7
    //   385: aload_0
    //   386: getfield 113	com/tencent/mm/plugin/recordvideo/model/audio/a:TAG	Ljava/lang/String;
    //   389: aload 7
    //   391: checkcast 279	java/lang/Throwable
    //   394: ldc_w 281
    //   397: iconst_0
    //   398: anewarray 283	java/lang/Object
    //   401: invokestatic 287	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: ldc 164
    //   406: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   409: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	h
    //   20	346	1	i	int
    //   54	2	2	j	int
    //   116	203	3	l1	long
    //   130	195	5	l2	long
    //   12	292	7	localObject	Object
    //   312	62	7	localException1	java.lang.Exception
    //   378	1	7	locald	d
    //   383	7	7	localException2	java.lang.Exception
    //   255	36	8	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   25	55	312	java/lang/Exception
    //   241	263	383	java/lang/Exception
    //   271	283	383	java/lang/Exception
    //   288	297	383	java/lang/Exception
    //   373	380	383	java/lang/Exception
  }
  
  public final void gHL()
  {
    AppMethodBeat.i(75430);
    d.a locala = this.NJo;
    if (locala != null) {
      locala.a(this.NJp);
    }
    locala = this.NJo;
    if (locala != null) {
      locala.destroy();
    }
    AppMethodBeat.o(75430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.h
 * JD-Core Version:    0.7.0.1
 */