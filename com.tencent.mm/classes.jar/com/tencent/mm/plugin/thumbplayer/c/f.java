package com.tencent.mm.plugin.thumbplayer.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageLoadData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "_resource", "plugin-thumbplayer_release"})
public final class f
  extends com.tencent.mm.loader.b.a.a<g>
{
  public final boolean a(com.tencent.mm.loader.h.a.a<g> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(189691);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    AppMethodBeat.o(189691);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<g> parama, com.tencent.mm.loader.h.f<?> paramf, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(189690);
    p.k(parama, "url");
    p.k(paramf, "httpResponse");
    p.k(parame, "opts");
    p.k(paramf1, "reaper");
    AppMethodBeat.o(189690);
    return true;
  }
  
  /* Error */
  public final boolean a(com.tencent.mm.loader.h.a.a<g> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<Bitmap> parame1, com.tencent.mm.loader.h.e<Bitmap> parame2, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 74
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 53
    //   11: invokestatic 59	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_2
    //   15: ldc 69
    //   17: invokestatic 59	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_3
    //   21: ldc 75
    //   23: invokestatic 59	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   26: aload 5
    //   28: ldc 60
    //   30: invokestatic 59	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   33: aload 6
    //   35: ldc 61
    //   37: invokestatic 59	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   40: aload_0
    //   41: aload_1
    //   42: aload 5
    //   44: aload 6
    //   46: invokevirtual 79	com/tencent/mm/plugin/thumbplayer/c/f:c	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Ljava/lang/String;
    //   49: astore 8
    //   51: invokestatic 85	com/tencent/mm/plugin/thumbplayer/c/c:aBy	()Ljava/lang/String;
    //   54: new 87	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 89
    //   60: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: ldc 98
    //   69: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 8
    //   74: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: bipush 32
    //   79: invokevirtual 104	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   82: aload_3
    //   83: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: ldc 106
    //   88: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_3
    //   92: invokevirtual 112	com/tencent/mm/loader/h/e:getValue	()Ljava/lang/Object;
    //   95: checkcast 114	android/graphics/Bitmap
    //   98: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: iconst_0
    //   105: anewarray 119	java/lang/Object
    //   108: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: getstatic 131	com/tencent/mm/loader/b/a/c:kNn	Lcom/tencent/mm/loader/b/a/c;
    //   114: astore 9
    //   116: aload 8
    //   118: invokestatic 135	com/tencent/mm/loader/b/a/c:Or	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   121: astore 9
    //   123: aload 9
    //   125: ifnull +115 -> 240
    //   128: aload 9
    //   130: checkcast 137	java/io/Closeable
    //   133: astore 8
    //   135: invokestatic 85	com/tencent/mm/plugin/thumbplayer/c/c:aBy	()Ljava/lang/String;
    //   138: ldc 139
    //   140: aload_1
    //   141: invokestatic 145	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 149	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_3
    //   151: invokevirtual 112	com/tencent/mm/loader/h/e:getValue	()Ljava/lang/Object;
    //   154: astore_3
    //   155: aload_3
    //   156: ifnull +120 -> 276
    //   159: aload_3
    //   160: checkcast 114	android/graphics/Bitmap
    //   163: astore_3
    //   164: getstatic 131	com/tencent/mm/loader/b/a/c:kNn	Lcom/tencent/mm/loader/b/a/c;
    //   167: astore 10
    //   169: aload_3
    //   170: aload 9
    //   172: invokestatic 155	com/tencent/mm/loader/b/a/c:a	(Landroid/graphics/Bitmap;Ljava/io/OutputStream;)Z
    //   175: pop
    //   176: invokestatic 85	com/tencent/mm/plugin/thumbplayer/c/c:aBy	()Ljava/lang/String;
    //   179: ldc 157
    //   181: aload_1
    //   182: invokestatic 145	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   185: invokevirtual 149	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   188: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: iconst_1
    //   192: istore 7
    //   194: iload 7
    //   196: ifne +9 -> 205
    //   199: aload_2
    //   200: aload 9
    //   202: invokevirtual 163	com/tencent/mm/loader/h/f:b	(Ljava/io/OutputStream;)V
    //   205: aload_0
    //   206: aload_1
    //   207: aload 5
    //   209: aload 6
    //   211: invokevirtual 165	com/tencent/mm/plugin/thumbplayer/c/f:a	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Z
    //   214: pop
    //   215: invokestatic 85	com/tencent/mm/plugin/thumbplayer/c/c:aBy	()Ljava/lang/String;
    //   218: ldc 167
    //   220: aload_1
    //   221: invokestatic 145	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   224: invokevirtual 149	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   227: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: getstatic 173	kotlin/x:aazN	Lkotlin/x;
    //   233: astore_1
    //   234: aload 8
    //   236: aconst_null
    //   237: invokestatic 178	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   240: ldc 74
    //   242: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: iconst_1
    //   246: ireturn
    //   247: astore_2
    //   248: ldc 74
    //   250: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aload_2
    //   254: athrow
    //   255: astore_1
    //   256: aload 8
    //   258: aload_2
    //   259: invokestatic 178	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   262: ldc 74
    //   264: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload_1
    //   268: athrow
    //   269: astore_1
    //   270: aload 4
    //   272: astore_2
    //   273: goto -17 -> 256
    //   276: iconst_0
    //   277: istore 7
    //   279: goto -85 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	f
    //   0	282	1	parama	com.tencent.mm.loader.h.a.a<g>
    //   0	282	2	paramf	com.tencent.mm.loader.h.f<?>
    //   0	282	3	parame1	com.tencent.mm.loader.h.e<Bitmap>
    //   0	282	4	parame2	com.tencent.mm.loader.h.e<Bitmap>
    //   0	282	5	parame	e
    //   0	282	6	paramf1	com.tencent.mm.loader.f<?, Bitmap>
    //   192	86	7	i	int
    //   49	208	8	localObject1	java.lang.Object
    //   114	87	9	localObject2	java.lang.Object
    //   167	1	10	localc	com.tencent.mm.loader.b.a.c
    // Exception table:
    //   from	to	target	type
    //   135	155	247	java/lang/Throwable
    //   159	191	247	java/lang/Throwable
    //   199	205	247	java/lang/Throwable
    //   205	234	247	java/lang/Throwable
    //   248	255	255	finally
    //   135	155	269	finally
    //   159	191	269	finally
    //   199	205	269	finally
    //   205	234	269	finally
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<g> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(189703);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    parame = c(parama, parame, paramf);
    Log.v(c.aBy(), "url " + parama + " and path " + parame + " fileret " + u.agG(parame));
    if (u.agG(parame))
    {
      parama = com.tencent.mm.loader.h.b.a.Ov(parame);
      AppMethodBeat.o(189703);
      return parama;
    }
    AppMethodBeat.o(189703);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.h.a.a<g> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(189692);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    parama = ((g)parama.aSr()).filePath;
    AppMethodBeat.o(189692);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.f
 * JD-Core Version:    0.7.0.1
 */