package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogImagePlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/ImageMaterial;", "(IIILcom/tencent/mm/plugin/vlog/model/ImageMaterial;)V", "cacheBitmap", "Landroid/graphics/Bitmap;", "enableMute", "", "mute", "", "isMirror", "isOES", "pause", "playing", "pts", "", "updateTex", "prepare", "readyAt", "seekTime", "release", "resizeBitmap", "bitmap", "resume", "stop", "Companion", "plugin-vlog_release"})
public final class c
  extends b
{
  public static final a yZV;
  private Bitmap yZU;
  
  static
  {
    AppMethodBeat.i(110972);
    yZV = new a((byte)0);
    AppMethodBeat.o(110972);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, com.tencent.mm.plugin.vlog.model.c paramc)
  {
    super(paramInt1, paramInt2, paramInt3, (d)paramc);
    AppMethodBeat.i(110971);
    AppMethodBeat.o(110971);
  }
  
  public final void H(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110968);
    if (paramBoolean)
    {
      Bitmap localBitmap = this.yZU;
      if (localBitmap != null)
      {
        ad.i("MicroMsg.VLogImagePlayer", "VLogImagePlayer playing, uploadBitmapTexture, bitmap:" + localBitmap + ", width:" + localBitmap.getWidth() + ", height:" + localBitmap.getHeight());
        com.tencent.mm.media.j.c.a locala = com.tencent.mm.media.j.c.gwl;
        com.tencent.mm.media.j.c.a.b(localBitmap, this.yZS);
        localBitmap.recycle();
        this.yZU = null;
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
    this.aRL = true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(110970);
    this.yZR = false;
    Bitmap localBitmap = this.yZU;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    this.yZU = null;
    this.aRL = false;
    AppMethodBeat.o(110970);
  }
  
  public final void resume() {}
  
  public final void rl(boolean paramBoolean) {}
  
  public final void stop()
  {
    this.yZR = false;
  }
  
  /* Error */
  public final void ug(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc 160
    //   8: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: getfield 153	com/tencent/mm/plugin/vlog/player/b:yZR	Z
    //   15: ifeq +9 -> 24
    //   18: ldc 160
    //   20: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 153	com/tencent/mm/plugin/vlog/player/b:yZR	Z
    //   29: getstatic 166	com/tencent/mm/plugin/vlog/player/d:yZX	Lcom/tencent/mm/plugin/vlog/player/d;
    //   32: astore 5
    //   34: aload_0
    //   35: getfield 170	com/tencent/mm/plugin/vlog/player/b:yZT	Lcom/tencent/mm/plugin/vlog/model/d;
    //   38: getfield 174	com/tencent/mm/plugin/vlog/model/d:path	Ljava/lang/String;
    //   41: invokestatic 178	com/tencent/mm/plugin/vlog/player/d:asW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/vlog/player/a;
    //   44: astore 5
    //   46: aload 5
    //   48: ifnull +123 -> 171
    //   51: ldc 86
    //   53: ldc 180
    //   55: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: aload 5
    //   61: getfield 185	com/tencent/mm/plugin/vlog/player/a:width	I
    //   64: putfield 186	com/tencent/mm/plugin/vlog/player/b:width	I
    //   67: aload_0
    //   68: aload 5
    //   70: getfield 189	com/tencent/mm/plugin/vlog/player/a:height	I
    //   73: putfield 190	com/tencent/mm/plugin/vlog/player/b:height	I
    //   76: aload_0
    //   77: aload 5
    //   79: getfield 193	com/tencent/mm/plugin/vlog/player/a:dwp	I
    //   82: putfield 194	com/tencent/mm/plugin/vlog/player/b:dwp	I
    //   85: iconst_1
    //   86: istore_3
    //   87: iload_3
    //   88: ifeq +88 -> 176
    //   91: aload_0
    //   92: getfield 84	com/tencent/mm/plugin/vlog/player/c:yZU	Landroid/graphics/Bitmap;
    //   95: ifnull +81 -> 176
    //   98: ldc 86
    //   100: ldc 196
    //   102: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: ldc 86
    //   107: new 88	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 198
    //   113: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield 201	com/tencent/mm/plugin/vlog/player/b:guK	I
    //   120: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: ldc 203
    //   125: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_0
    //   129: getfield 206	com/tencent/mm/plugin/vlog/player/b:guL	I
    //   132: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: ldc 99
    //   137: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 186	com/tencent/mm/plugin/vlog/player/b:width	I
    //   144: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: ldc 113
    //   149: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 190	com/tencent/mm/plugin/vlog/player/b:height	I
    //   156: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: ldc 160
    //   167: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: iconst_0
    //   172: istore_3
    //   173: goto -86 -> 87
    //   176: invokestatic 212	java/lang/System:currentTimeMillis	()J
    //   179: lstore_1
    //   180: new 214	android/graphics/BitmapFactory$Options
    //   183: dup
    //   184: invokespecial 216	android/graphics/BitmapFactory$Options:<init>	()V
    //   187: astore 5
    //   189: aload 5
    //   191: iconst_1
    //   192: putfield 219	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   195: aload_0
    //   196: getfield 170	com/tencent/mm/plugin/vlog/player/b:yZT	Lcom/tencent/mm/plugin/vlog/model/d;
    //   199: getfield 174	com/tencent/mm/plugin/vlog/model/d:path	Ljava/lang/String;
    //   202: aload 5
    //   204: invokestatic 225	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   207: pop
    //   208: aload 5
    //   210: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   213: istore_3
    //   214: aload 5
    //   216: getfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   219: istore 4
    //   221: aload 5
    //   223: iload_3
    //   224: iload 4
    //   226: aload_0
    //   227: getfield 201	com/tencent/mm/plugin/vlog/player/b:guK	I
    //   230: aload_0
    //   231: getfield 206	com/tencent/mm/plugin/vlog/player/b:guL	I
    //   234: invokestatic 237	com/tencent/mm/sdk/platformtools/f:M	(IIII)I
    //   237: putfield 240	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   240: aload 5
    //   242: iconst_0
    //   243: putfield 219	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   246: aload_0
    //   247: getfield 170	com/tencent/mm/plugin/vlog/player/b:yZT	Lcom/tencent/mm/plugin/vlog/model/d;
    //   250: getfield 174	com/tencent/mm/plugin/vlog/model/d:path	Ljava/lang/String;
    //   253: aload 5
    //   255: invokestatic 243	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   258: astore 5
    //   260: aload 5
    //   262: ifnull +339 -> 601
    //   265: aload 5
    //   267: invokevirtual 246	android/graphics/Bitmap:isRecycled	()Z
    //   270: ifne +331 -> 601
    //   273: aload 5
    //   275: invokevirtual 108	android/graphics/Bitmap:getWidth	()I
    //   278: iconst_2
    //   279: irem
    //   280: iconst_1
    //   281: if_icmpne +317 -> 598
    //   284: aload 5
    //   286: invokevirtual 108	android/graphics/Bitmap:getWidth	()I
    //   289: iconst_1
    //   290: iadd
    //   291: aload 5
    //   293: invokevirtual 116	android/graphics/Bitmap:getHeight	()I
    //   296: getstatic 252	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   299: invokestatic 256	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   302: astore 8
    //   304: aload 8
    //   306: ifnonnull +6 -> 312
    //   309: invokestatic 259	d/g/b/k:fvU	()V
    //   312: new 261	android/graphics/Canvas
    //   315: dup
    //   316: aload 8
    //   318: invokespecial 264	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   321: astore 9
    //   323: aload 9
    //   325: iconst_0
    //   326: iconst_0
    //   327: iconst_0
    //   328: iconst_0
    //   329: invokevirtual 268	android/graphics/Canvas:drawARGB	(IIII)V
    //   332: aload 9
    //   334: aload 5
    //   336: fconst_0
    //   337: fconst_0
    //   338: aconst_null
    //   339: invokevirtual 272	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   342: aload 8
    //   344: astore 5
    //   346: aload 5
    //   348: ifnonnull +6 -> 354
    //   351: invokestatic 259	d/g/b/k:fvU	()V
    //   354: aload_0
    //   355: aload 5
    //   357: invokevirtual 108	android/graphics/Bitmap:getWidth	()I
    //   360: putfield 186	com/tencent/mm/plugin/vlog/player/b:width	I
    //   363: aload_0
    //   364: aload 5
    //   366: invokevirtual 116	android/graphics/Bitmap:getHeight	()I
    //   369: putfield 190	com/tencent/mm/plugin/vlog/player/b:height	I
    //   372: ldc 86
    //   374: new 88	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 274
    //   381: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: iload_3
    //   385: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: ldc_w 276
    //   391: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: iload 4
    //   396: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   399: ldc_w 278
    //   402: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_0
    //   406: getfield 201	com/tencent/mm/plugin/vlog/player/b:guK	I
    //   409: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: ldc 203
    //   414: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_0
    //   418: getfield 206	com/tencent/mm/plugin/vlog/player/b:guL	I
    //   421: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   424: ldc 99
    //   426: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_0
    //   430: getfield 186	com/tencent/mm/plugin/vlog/player/b:width	I
    //   433: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   436: ldc 113
    //   438: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_0
    //   442: getfield 190	com/tencent/mm/plugin/vlog/player/b:height	I
    //   445: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_0
    //   455: getfield 170	com/tencent/mm/plugin/vlog/player/b:yZT	Lcom/tencent/mm/plugin/vlog/model/d;
    //   458: getfield 174	com/tencent/mm/plugin/vlog/model/d:path	Ljava/lang/String;
    //   461: invokestatic 284	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   464: astore 8
    //   466: aload 8
    //   468: ifnull +166 -> 634
    //   471: aload 8
    //   473: checkcast 286	java/io/Closeable
    //   476: astore 9
    //   478: new 288	android/support/d/a
    //   481: dup
    //   482: aload 9
    //   484: checkcast 290	java/io/InputStream
    //   487: invokespecial 293	android/support/d/a:<init>	(Ljava/io/InputStream;)V
    //   490: astore 8
    //   492: getstatic 299	d/y:JfV	Ld/y;
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
    //   517: invokevirtual 310	android/support/d/a:l	(Ljava/lang/String;)I
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
    //   543: putfield 84	com/tencent/mm/plugin/vlog/player/c:yZU	Landroid/graphics/Bitmap;
    //   546: getstatic 166	com/tencent/mm/plugin/vlog/player/d:yZX	Lcom/tencent/mm/plugin/vlog/player/d;
    //   549: astore 5
    //   551: aload_0
    //   552: getfield 170	com/tencent/mm/plugin/vlog/player/b:yZT	Lcom/tencent/mm/plugin/vlog/model/d;
    //   555: getfield 174	com/tencent/mm/plugin/vlog/model/d:path	Ljava/lang/String;
    //   558: aload_0
    //   559: getfield 186	com/tencent/mm/plugin/vlog/player/b:width	I
    //   562: aload_0
    //   563: getfield 190	com/tencent/mm/plugin/vlog/player/b:height	I
    //   566: aload_0
    //   567: getfield 194	com/tencent/mm/plugin/vlog/player/b:dwp	I
    //   570: invokestatic 319	com/tencent/mm/plugin/vlog/player/d:o	(Ljava/lang/String;III)V
    //   573: ldc 86
    //   575: ldc_w 321
    //   578: invokestatic 212	java/lang/System:currentTimeMillis	()J
    //   581: lload_1
    //   582: lsub
    //   583: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   586: invokevirtual 330	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   589: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   592: ldc 160
    //   594: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   597: return
    //   598: goto -252 -> 346
    //   601: aconst_null
    //   602: astore 5
    //   604: goto -258 -> 346
    //   607: astore 6
    //   609: ldc 160
    //   611: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   614: aload 6
    //   616: athrow
    //   617: astore 5
    //   619: aload 9
    //   621: aload 6
    //   623: invokestatic 304	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   626: ldc 160
    //   628: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   652: putfield 194	com/tencent/mm/plugin/vlog/player/b:dwp	I
    //   655: ldc 86
    //   657: ldc_w 335
    //   660: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   663: goto -123 -> 540
    //   666: aload 7
    //   668: invokevirtual 333	java/lang/Integer:intValue	()I
    //   671: iconst_3
    //   672: if_icmpne -137 -> 535
    //   675: aload_0
    //   676: iconst_2
    //   677: putfield 194	com/tencent/mm/plugin/vlog/player/b:dwp	I
    //   680: ldc 86
    //   682: ldc_w 337
    //   685: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   688: goto -148 -> 540
    //   691: aload 7
    //   693: invokevirtual 333	java/lang/Integer:intValue	()I
    //   696: bipush 8
    //   698: if_icmpne -158 -> 540
    //   701: aload_0
    //   702: iconst_1
    //   703: putfield 194	com/tencent/mm/plugin/vlog/player/b:dwp	I
    //   706: ldc 86
    //   708: ldc_w 339
    //   711: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: goto -174 -> 540
    //   717: astore 5
    //   719: goto -100 -> 619
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	722	0	this	c
    //   0	722	1	paramLong	long
    //   86	299	3	i	int
    //   219	176	4	j	int
    //   32	571	5	localObject1	Object
    //   617	15	5	localObject2	Object
    //   717	1	5	localObject3	Object
    //   1	512	6	localObject4	Object
    //   607	15	6	localThrowable	java.lang.Throwable
    //   635	1	6	localObject5	Object
    //   4	688	7	localInteger	java.lang.Integer
    //   302	202	8	localObject6	Object
    //   321	299	9	localObject7	Object
    //   495	1	10	localy	d.y
    // Exception table:
    //   from	to	target	type
    //   478	497	607	java/lang/Throwable
    //   609	617	617	finally
    //   478	497	717	finally
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogImagePlayer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.c
 * JD-Core Version:    0.7.0.1
 */