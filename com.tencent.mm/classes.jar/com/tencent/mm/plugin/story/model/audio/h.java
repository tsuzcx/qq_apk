package com.tencent.mm.plugin.story.model.audio;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.plugin.mmsight.segment.d.a;
import com.tencent.mm.plugin.story.g.f;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/audio/GetVideoRecommendAudioTask;", "Lcom/tencent/mm/plugin/story/model/audio/AbsGetRecommendAudioTask;", "videoPath", "", "startTime", "", "endTime", "scene", "", "(Ljava/lang/String;JJI)V", "getEndTime", "()J", "fetcher", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher;", "frameInterval", "getStartTime", "thumbFetcherPool", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentThumbFetcher$FetcherPool;", "getVideoPath", "()Ljava/lang/String;", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "", "onPrepareImageData", "plugin-story_release"})
public final class h
  extends a
{
  private final long endTime;
  int frameInterval;
  private final long startTime;
  private d.a swR;
  private d swS;
  final String videoPath;
  
  public h(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(151068);
    this.videoPath = paramString;
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.frameInterval = 1000;
    this.scene = paramInt;
    AppMethodBeat.o(151068);
  }
  
  public final Bitmap FI(int paramInt)
  {
    AppMethodBeat.i(155298);
    ab.i(this.TAG, "nextBitmap:" + this.swm[paramInt]);
    Object localObject = this.swS;
    if (localObject != null) {}
    for (localObject = ((d)localObject).getFrameAtTime(this.swm[paramInt]); localObject == null; localObject = null)
    {
      localObject = f.sEx;
      f.cDc();
      localObject = Bitmap.createBitmap(this.fgR, this.fgQ, Bitmap.Config.ARGB_8888);
      j.p(localObject, "Bitmap.createBitmap(thum… Bitmap.Config.ARGB_8888)");
      AppMethodBeat.o(155298);
      return localObject;
    }
    AppMethodBeat.o(155298);
    return localObject;
  }
  
  /* Error */
  public final void cBr()
  {
    // Byte code:
    //   0: ldc 147
    //   2: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 62	com/tencent/mm/plugin/story/model/audio/h:videoPath	Ljava/lang/String;
    //   9: invokestatic 153	com/tencent/mm/plugin/sight/base/d:Zo	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   12: astore 7
    //   14: aload 7
    //   16: ifnull +291 -> 307
    //   19: aload 7
    //   21: getfield 158	com/tencent/mm/plugin/sight/base/a:eVA	I
    //   24: istore_1
    //   25: iload_1
    //   26: ifgt +288 -> 314
    //   29: new 160	android/media/MediaMetadataRetriever
    //   32: dup
    //   33: invokespecial 161	android/media/MediaMetadataRetriever:<init>	()V
    //   36: astore 7
    //   38: aload 7
    //   40: aload_0
    //   41: getfield 62	com/tencent/mm/plugin/story/model/audio/h:videoPath	Ljava/lang/String;
    //   44: invokevirtual 164	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   47: aload 7
    //   49: bipush 9
    //   51: invokevirtual 168	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   54: iconst_0
    //   55: invokestatic 174	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   58: istore_2
    //   59: iload_2
    //   60: istore_1
    //   61: iload_1
    //   62: ifgt +32 -> 94
    //   65: aload_0
    //   66: getfield 80	com/tencent/mm/plugin/story/model/audio/a:TAG	Ljava/lang/String;
    //   69: new 82	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 176
    //   75: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_0
    //   79: getfield 62	com/tencent/mm/plugin/story/model/audio/h:videoPath	Ljava/lang/String;
    //   82: invokestatic 182	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   85: invokevirtual 185	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 188	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: new 190	com/tencent/mm/plugin/mmsight/segment/d$a
    //   98: dup
    //   99: iconst_3
    //   100: new 192	com/tencent/mm/plugin/story/model/audio/h$a
    //   103: dup
    //   104: aload_0
    //   105: invokespecial 195	com/tencent/mm/plugin/story/model/audio/h$a:<init>	(Lcom/tencent/mm/plugin/story/model/audio/h;)V
    //   108: checkcast 197	java/util/concurrent/Callable
    //   111: invokespecial 200	com/tencent/mm/plugin/mmsight/segment/d$a:<init>	(ILjava/util/concurrent/Callable;)V
    //   114: putfield 202	com/tencent/mm/plugin/story/model/audio/h:swR	Lcom/tencent/mm/plugin/mmsight/segment/d$a;
    //   117: aload_0
    //   118: getfield 64	com/tencent/mm/plugin/story/model/audio/h:startTime	J
    //   121: lconst_0
    //   122: lcmp
    //   123: iflt +194 -> 317
    //   126: aload_0
    //   127: getfield 64	com/tencent/mm/plugin/story/model/audio/h:startTime	J
    //   130: lstore_3
    //   131: aload_0
    //   132: getfield 66	com/tencent/mm/plugin/story/model/audio/h:endTime	J
    //   135: lconst_0
    //   136: lcmp
    //   137: iflt +185 -> 322
    //   140: aload_0
    //   141: getfield 66	com/tencent/mm/plugin/story/model/audio/h:endTime	J
    //   144: lstore 5
    //   146: lload 5
    //   148: lload_3
    //   149: lsub
    //   150: lconst_0
    //   151: lcmp
    //   152: ifle +177 -> 329
    //   155: aload_0
    //   156: iconst_3
    //   157: newarray int
    //   159: dup
    //   160: iconst_0
    //   161: ldc2_w 203
    //   164: lload_3
    //   165: ladd
    //   166: l2i
    //   167: iastore
    //   168: dup
    //   169: iconst_1
    //   170: lload 5
    //   172: lload_3
    //   173: lsub
    //   174: ldc2_w 205
    //   177: ldiv
    //   178: l2i
    //   179: iastore
    //   180: dup
    //   181: iconst_2
    //   182: lload 5
    //   184: ldc2_w 203
    //   187: lsub
    //   188: l2i
    //   189: iastore
    //   190: invokevirtual 210	com/tencent/mm/plugin/story/model/audio/h:A	([I)V
    //   193: aload_0
    //   194: iload_1
    //   195: i2l
    //   196: putfield 213	com/tencent/mm/plugin/story/model/audio/a:qZL	J
    //   199: aload_0
    //   200: getfield 80	com/tencent/mm/plugin/story/model/audio/a:TAG	Ljava/lang/String;
    //   203: new 82	java/lang/StringBuilder
    //   206: dup
    //   207: ldc 215
    //   209: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: iload_1
    //   213: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: ldc 217
    //   218: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: lload_3
    //   222: invokevirtual 223	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: ldc 225
    //   227: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: lload 5
    //   232: invokevirtual 223	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: getfield 123	com/tencent/mm/plugin/story/model/audio/a:fgR	I
    //   245: aload_0
    //   246: getfield 126	com/tencent/mm/plugin/story/model/audio/a:fgQ	I
    //   249: getstatic 132	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   252: invokestatic 138	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   255: astore 8
    //   257: aload_0
    //   258: getfield 202	com/tencent/mm/plugin/story/model/audio/h:swR	Lcom/tencent/mm/plugin/mmsight/segment/d$a;
    //   261: astore 7
    //   263: aload 7
    //   265: ifnull +99 -> 364
    //   268: aload 7
    //   270: invokevirtual 229	com/tencent/mm/plugin/mmsight/segment/d$a:bRA	()Lcom/tencent/mm/plugin/mmsight/segment/d;
    //   273: astore 7
    //   275: aload_0
    //   276: aload 7
    //   278: putfield 105	com/tencent/mm/plugin/story/model/audio/h:swS	Lcom/tencent/mm/plugin/mmsight/segment/d;
    //   281: aload_0
    //   282: getfield 105	com/tencent/mm/plugin/story/model/audio/h:swS	Lcom/tencent/mm/plugin/mmsight/segment/d;
    //   285: astore 7
    //   287: aload 7
    //   289: ifnull +81 -> 370
    //   292: aload 7
    //   294: aload 8
    //   296: invokeinterface 233 2 0
    //   301: ldc 147
    //   303: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: return
    //   307: iconst_0
    //   308: istore_1
    //   309: goto -284 -> 25
    //   312: astore 7
    //   314: goto -253 -> 61
    //   317: lconst_0
    //   318: lstore_3
    //   319: goto -188 -> 131
    //   322: iload_1
    //   323: i2l
    //   324: lstore 5
    //   326: goto -180 -> 146
    //   329: iload_1
    //   330: sipush 300
    //   333: if_icmple -140 -> 193
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
    //   358: invokevirtual 210	com/tencent/mm/plugin/story/model/audio/h:A	([I)V
    //   361: goto -168 -> 193
    //   364: aconst_null
    //   365: astore 7
    //   367: goto -92 -> 275
    //   370: ldc 147
    //   372: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: return
    //   376: astore 7
    //   378: aload_0
    //   379: getfield 80	com/tencent/mm/plugin/story/model/audio/a:TAG	Ljava/lang/String;
    //   382: aload 7
    //   384: checkcast 235	java/lang/Throwable
    //   387: ldc 237
    //   389: iconst_0
    //   390: anewarray 239	java/lang/Object
    //   393: invokestatic 243	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: ldc 147
    //   398: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	h
    //   24	333	1	i	int
    //   58	2	2	j	int
    //   130	189	3	l1	long
    //   144	181	5	l2	long
    //   12	281	7	localObject1	Object
    //   312	1	7	localException1	java.lang.Exception
    //   365	1	7	localObject2	Object
    //   376	7	7	localException2	java.lang.Exception
    //   255	40	8	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   29	59	312	java/lang/Exception
    //   241	263	376	java/lang/Exception
    //   268	275	376	java/lang/Exception
    //   275	287	376	java/lang/Exception
    //   292	306	376	java/lang/Exception
  }
  
  public final void cBs()
  {
    AppMethodBeat.i(155300);
    d.a locala = this.swR;
    if (locala != null) {
      locala.a(this.swS);
    }
    locala = this.swR;
    if (locala != null)
    {
      locala.destroy();
      AppMethodBeat.o(155300);
      return;
    }
    AppMethodBeat.o(155300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.h
 * JD-Core Version:    0.7.0.1
 */