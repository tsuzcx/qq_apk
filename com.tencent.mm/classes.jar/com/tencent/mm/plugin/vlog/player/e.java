package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.plugin.vlog.model.g;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/VLogImagePlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/ImageMaterial;", "(IIILcom/tencent/mm/plugin/vlog/model/ImageMaterial;)V", "cacheBitmap", "Landroid/graphics/Bitmap;", "enableMute", "", "mute", "", "isMirror", "isOES", "pause", "playing", "pts", "", "updateTex", "prepare", "readyAt", "seekTime", "release", "resizeBitmap", "bitmap", "resume", "stop", "Companion", "plugin-vlog_release"})
public final class e
  extends b
{
  public static final e.a ApW;
  private Bitmap ApV;
  
  static
  {
    AppMethodBeat.i(110972);
    ApW = new e.a((byte)0);
    AppMethodBeat.o(110972);
  }
  
  public e(int paramInt1, int paramInt2, int paramInt3, g paramg)
  {
    super(paramInt1, paramInt2, paramInt3, (i)paramg);
    AppMethodBeat.i(110971);
    AppMethodBeat.o(110971);
  }
  
  public final void H(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110968);
    if (paramBoolean)
    {
      Bitmap localBitmap = this.ApV;
      if (localBitmap != null)
      {
        ac.i("MicroMsg.VLogImagePlayer", "VLogImagePlayer playing, uploadBitmapTexture, bitmap:" + localBitmap + ", width:" + localBitmap.getWidth() + ", height:" + localBitmap.getHeight());
        c.a locala = c.gWJ;
        c.a.b(localBitmap, this.Aps);
        localBitmap.recycle();
        this.ApV = null;
        AppMethodBeat.o(110968);
        return;
      }
    }
    AppMethodBeat.o(110968);
  }
  
  public final boolean isOES()
  {
    return false;
  }
  
  public final void pause() {}
  
  public final void prepare()
  {
    this.aSG = true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(110970);
    this.Apr = false;
    Bitmap localBitmap = this.ApV;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    this.ApV = null;
    this.aSG = false;
    AppMethodBeat.o(110970);
  }
  
  public final void resume() {}
  
  public final void sk(boolean paramBoolean) {}
  
  public final void stop()
  {
    this.Apr = false;
  }
  
  /* Error */
  public final void yJ(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc 159
    //   8: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: getfield 152	com/tencent/mm/plugin/vlog/player/b:Apr	Z
    //   15: ifeq +9 -> 24
    //   18: ldc 159
    //   20: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 152	com/tencent/mm/plugin/vlog/player/b:Apr	Z
    //   29: getstatic 165	com/tencent/mm/plugin/vlog/player/f:ApY	Lcom/tencent/mm/plugin/vlog/player/f;
    //   32: astore 5
    //   34: aload_0
    //   35: getfield 169	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   38: getfield 173	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   41: invokestatic 177	com/tencent/mm/plugin/vlog/player/f:aym	(Ljava/lang/String;)Lcom/tencent/mm/plugin/vlog/player/a;
    //   44: astore 5
    //   46: aload 5
    //   48: ifnull +123 -> 171
    //   51: ldc 85
    //   53: ldc 179
    //   55: invokestatic 124	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: aload 5
    //   61: getfield 184	com/tencent/mm/plugin/vlog/player/a:width	I
    //   64: putfield 185	com/tencent/mm/plugin/vlog/player/b:width	I
    //   67: aload_0
    //   68: aload 5
    //   70: getfield 188	com/tencent/mm/plugin/vlog/player/a:height	I
    //   73: putfield 189	com/tencent/mm/plugin/vlog/player/b:height	I
    //   76: aload_0
    //   77: aload 5
    //   79: getfield 192	com/tencent/mm/plugin/vlog/player/a:duc	I
    //   82: putfield 193	com/tencent/mm/plugin/vlog/player/b:duc	I
    //   85: iconst_1
    //   86: istore_3
    //   87: iload_3
    //   88: ifeq +88 -> 176
    //   91: aload_0
    //   92: getfield 83	com/tencent/mm/plugin/vlog/player/e:ApV	Landroid/graphics/Bitmap;
    //   95: ifnull +81 -> 176
    //   98: ldc 85
    //   100: ldc 195
    //   102: invokestatic 124	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: ldc 85
    //   107: new 87	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 197
    //   113: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield 200	com/tencent/mm/plugin/vlog/player/b:grV	I
    //   120: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: ldc 202
    //   125: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_0
    //   129: getfield 205	com/tencent/mm/plugin/vlog/player/b:grW	I
    //   132: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: ldc 98
    //   137: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 185	com/tencent/mm/plugin/vlog/player/b:width	I
    //   144: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: ldc 112
    //   149: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 189	com/tencent/mm/plugin/vlog/player/b:height	I
    //   156: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 124	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: ldc 159
    //   167: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: iconst_0
    //   172: istore_3
    //   173: goto -86 -> 87
    //   176: invokestatic 211	java/lang/System:currentTimeMillis	()J
    //   179: lstore_1
    //   180: new 213	android/graphics/BitmapFactory$Options
    //   183: dup
    //   184: invokespecial 215	android/graphics/BitmapFactory$Options:<init>	()V
    //   187: astore 5
    //   189: aload 5
    //   191: iconst_1
    //   192: putfield 218	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   195: aload_0
    //   196: getfield 169	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   199: getfield 173	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   202: aload 5
    //   204: invokestatic 224	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   207: pop
    //   208: aload 5
    //   210: getfield 227	android/graphics/BitmapFactory$Options:outWidth	I
    //   213: istore_3
    //   214: aload 5
    //   216: getfield 230	android/graphics/BitmapFactory$Options:outHeight	I
    //   219: istore 4
    //   221: aload 5
    //   223: iload_3
    //   224: iload 4
    //   226: aload_0
    //   227: getfield 200	com/tencent/mm/plugin/vlog/player/b:grV	I
    //   230: aload_0
    //   231: getfield 205	com/tencent/mm/plugin/vlog/player/b:grW	I
    //   234: invokestatic 236	com/tencent/mm/sdk/platformtools/f:O	(IIII)I
    //   237: putfield 239	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   240: aload 5
    //   242: iconst_0
    //   243: putfield 218	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   246: aload_0
    //   247: getfield 169	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   250: getfield 173	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   253: aload 5
    //   255: invokestatic 242	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   258: astore 5
    //   260: aload 5
    //   262: ifnull +339 -> 601
    //   265: aload 5
    //   267: invokevirtual 245	android/graphics/Bitmap:isRecycled	()Z
    //   270: ifne +331 -> 601
    //   273: aload 5
    //   275: invokevirtual 107	android/graphics/Bitmap:getWidth	()I
    //   278: iconst_2
    //   279: irem
    //   280: iconst_1
    //   281: if_icmpne +317 -> 598
    //   284: aload 5
    //   286: invokevirtual 107	android/graphics/Bitmap:getWidth	()I
    //   289: iconst_1
    //   290: iadd
    //   291: aload 5
    //   293: invokevirtual 115	android/graphics/Bitmap:getHeight	()I
    //   296: getstatic 251	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   299: invokestatic 255	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   302: astore 8
    //   304: aload 8
    //   306: ifnonnull +6 -> 312
    //   309: invokestatic 258	d/g/b/k:fOy	()V
    //   312: new 260	android/graphics/Canvas
    //   315: dup
    //   316: aload 8
    //   318: invokespecial 263	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   321: astore 9
    //   323: aload 9
    //   325: iconst_0
    //   326: iconst_0
    //   327: iconst_0
    //   328: iconst_0
    //   329: invokevirtual 267	android/graphics/Canvas:drawARGB	(IIII)V
    //   332: aload 9
    //   334: aload 5
    //   336: fconst_0
    //   337: fconst_0
    //   338: aconst_null
    //   339: invokevirtual 271	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   342: aload 8
    //   344: astore 5
    //   346: aload 5
    //   348: ifnonnull +6 -> 354
    //   351: invokestatic 258	d/g/b/k:fOy	()V
    //   354: aload_0
    //   355: aload 5
    //   357: invokevirtual 107	android/graphics/Bitmap:getWidth	()I
    //   360: putfield 185	com/tencent/mm/plugin/vlog/player/b:width	I
    //   363: aload_0
    //   364: aload 5
    //   366: invokevirtual 115	android/graphics/Bitmap:getHeight	()I
    //   369: putfield 189	com/tencent/mm/plugin/vlog/player/b:height	I
    //   372: ldc 85
    //   374: new 87	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 273
    //   381: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: iload_3
    //   385: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: ldc_w 275
    //   391: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: iload 4
    //   396: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   399: ldc_w 277
    //   402: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_0
    //   406: getfield 200	com/tencent/mm/plugin/vlog/player/b:grV	I
    //   409: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: ldc 202
    //   414: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_0
    //   418: getfield 205	com/tencent/mm/plugin/vlog/player/b:grW	I
    //   421: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   424: ldc 98
    //   426: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_0
    //   430: getfield 185	com/tencent/mm/plugin/vlog/player/b:width	I
    //   433: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   436: ldc 112
    //   438: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_0
    //   442: getfield 189	com/tencent/mm/plugin/vlog/player/b:height	I
    //   445: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 124	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_0
    //   455: getfield 169	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   458: getfield 173	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   461: invokestatic 283	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   464: astore 8
    //   466: aload 8
    //   468: ifnull +166 -> 634
    //   471: aload 8
    //   473: checkcast 285	java/io/Closeable
    //   476: astore 9
    //   478: new 287	android/support/e/a
    //   481: dup
    //   482: aload 9
    //   484: checkcast 289	java/io/InputStream
    //   487: invokespecial 292	android/support/e/a:<init>	(Ljava/io/InputStream;)V
    //   490: astore 8
    //   492: getstatic 298	d/y:KTp	Ld/y;
    //   495: astore 10
    //   497: aload 9
    //   499: aconst_null
    //   500: invokestatic 304	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   503: aload 8
    //   505: astore 6
    //   507: aload 6
    //   509: ifnull +16 -> 525
    //   512: aload 6
    //   514: ldc_w 306
    //   517: invokevirtual 310	android/support/e/a:m	(Ljava/lang/String;)I
    //   520: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   523: astore 7
    //   525: aload 7
    //   527: ifnonnull +113 -> 640
    //   530: aload 7
    //   532: ifnonnull +134 -> 666
    //   535: aload 7
    //   537: ifnonnull +154 -> 691
    //   540: aload_0
    //   541: aload 5
    //   543: putfield 83	com/tencent/mm/plugin/vlog/player/e:ApV	Landroid/graphics/Bitmap;
    //   546: getstatic 165	com/tencent/mm/plugin/vlog/player/f:ApY	Lcom/tencent/mm/plugin/vlog/player/f;
    //   549: astore 5
    //   551: aload_0
    //   552: getfield 169	com/tencent/mm/plugin/vlog/player/b:Apt	Lcom/tencent/mm/plugin/vlog/model/i;
    //   555: getfield 173	com/tencent/mm/plugin/vlog/model/i:path	Ljava/lang/String;
    //   558: aload_0
    //   559: getfield 185	com/tencent/mm/plugin/vlog/player/b:width	I
    //   562: aload_0
    //   563: getfield 189	com/tencent/mm/plugin/vlog/player/b:height	I
    //   566: aload_0
    //   567: getfield 193	com/tencent/mm/plugin/vlog/player/b:duc	I
    //   570: invokestatic 319	com/tencent/mm/plugin/vlog/player/f:o	(Ljava/lang/String;III)V
    //   573: ldc 85
    //   575: ldc_w 321
    //   578: invokestatic 211	java/lang/System:currentTimeMillis	()J
    //   581: lload_1
    //   582: lsub
    //   583: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   586: invokevirtual 330	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   589: invokestatic 124	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   592: ldc 159
    //   594: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   597: return
    //   598: goto -252 -> 346
    //   601: aconst_null
    //   602: astore 5
    //   604: goto -258 -> 346
    //   607: astore 6
    //   609: ldc 159
    //   611: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   614: aload 6
    //   616: athrow
    //   617: astore 5
    //   619: aload 9
    //   621: aload 6
    //   623: invokestatic 304	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   626: ldc 159
    //   628: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   631: aload 5
    //   633: athrow
    //   634: aconst_null
    //   635: astore 6
    //   637: goto -130 -> 507
    //   640: aload 7
    //   642: invokevirtual 333	java/lang/Integer:intValue	()I
    //   645: bipush 6
    //   647: if_icmpne -117 -> 530
    //   650: aload_0
    //   651: iconst_3
    //   652: putfield 193	com/tencent/mm/plugin/vlog/player/b:duc	I
    //   655: ldc 85
    //   657: ldc_w 335
    //   660: invokestatic 124	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   663: goto -123 -> 540
    //   666: aload 7
    //   668: invokevirtual 333	java/lang/Integer:intValue	()I
    //   671: iconst_3
    //   672: if_icmpne -137 -> 535
    //   675: aload_0
    //   676: iconst_2
    //   677: putfield 193	com/tencent/mm/plugin/vlog/player/b:duc	I
    //   680: ldc 85
    //   682: ldc_w 337
    //   685: invokestatic 124	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   688: goto -148 -> 540
    //   691: aload 7
    //   693: invokevirtual 333	java/lang/Integer:intValue	()I
    //   696: bipush 8
    //   698: if_icmpne -158 -> 540
    //   701: aload_0
    //   702: iconst_1
    //   703: putfield 193	com/tencent/mm/plugin/vlog/player/b:duc	I
    //   706: ldc 85
    //   708: ldc_w 339
    //   711: invokestatic 124	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: goto -174 -> 540
    //   717: astore 5
    //   719: goto -100 -> 619
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	722	0	this	e
    //   0	722	1	paramLong	long
    //   86	299	3	i	int
    //   219	176	4	j	int
    //   32	571	5	localObject1	java.lang.Object
    //   617	15	5	localObject2	java.lang.Object
    //   717	1	5	localObject3	java.lang.Object
    //   1	512	6	localObject4	java.lang.Object
    //   607	15	6	localThrowable	java.lang.Throwable
    //   635	1	6	localObject5	java.lang.Object
    //   4	688	7	localInteger	java.lang.Integer
    //   302	202	8	localObject6	java.lang.Object
    //   321	299	9	localObject7	java.lang.Object
    //   495	1	10	localy	d.y
    // Exception table:
    //   from	to	target	type
    //   478	497	607	java/lang/Throwable
    //   609	617	617	finally
    //   478	497	717	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.e
 * JD-Core Version:    0.7.0.1
 */