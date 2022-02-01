package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.vlog.model.j;
import com.tencent.mm.sdk.platformtools.ad;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogImagePlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/ImageMaterial;", "(IIILcom/tencent/mm/plugin/vlog/model/ImageMaterial;)V", "cacheBitmap", "Landroid/graphics/Bitmap;", "enableMute", "", "mute", "", "isMirror", "isOES", "pause", "playing", "pts", "", "updateTex", "prepare", "readyAt", "seekTime", "release", "resizeBitmap", "bitmap", "resume", "stop", "Companion", "plugin-vlog_release"})
public final class d
  extends b
{
  public static final a BIu;
  private Bitmap BIt;
  
  static
  {
    AppMethodBeat.i(110972);
    BIu = new a((byte)0);
    AppMethodBeat.o(110972);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, j paramj)
  {
    super(paramInt1, paramInt2, paramInt3, (com.tencent.mm.plugin.vlog.model.l)paramj);
    AppMethodBeat.i(110971);
    AppMethodBeat.o(110971);
  }
  
  /* Error */
  public final void Bm(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc 84
    //   8: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: getfield 88	com/tencent/mm/plugin/vlog/player/b:BHY	Z
    //   15: ifeq +9 -> 24
    //   18: ldc 84
    //   20: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 88	com/tencent/mm/plugin/vlog/player/b:BHY	Z
    //   29: getstatic 94	com/tencent/mm/plugin/vlog/player/e:BIv	Lcom/tencent/mm/plugin/vlog/player/e;
    //   32: astore 5
    //   34: aload_0
    //   35: getfield 98	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   38: getfield 102	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   41: invokestatic 106	com/tencent/mm/plugin/vlog/player/e:aDs	(Ljava/lang/String;)Lcom/tencent/mm/plugin/vlog/player/a;
    //   44: astore 5
    //   46: aload 5
    //   48: ifnull +123 -> 171
    //   51: ldc 108
    //   53: ldc 110
    //   55: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: aload 5
    //   61: getfield 121	com/tencent/mm/plugin/vlog/player/a:width	I
    //   64: putfield 122	com/tencent/mm/plugin/vlog/player/b:width	I
    //   67: aload_0
    //   68: aload 5
    //   70: getfield 125	com/tencent/mm/plugin/vlog/player/a:height	I
    //   73: putfield 126	com/tencent/mm/plugin/vlog/player/b:height	I
    //   76: aload_0
    //   77: aload 5
    //   79: getfield 129	com/tencent/mm/plugin/vlog/player/a:dGc	I
    //   82: putfield 130	com/tencent/mm/plugin/vlog/player/b:dGc	I
    //   85: iconst_1
    //   86: istore_3
    //   87: iload_3
    //   88: ifeq +88 -> 176
    //   91: aload_0
    //   92: getfield 132	com/tencent/mm/plugin/vlog/player/d:BIt	Landroid/graphics/Bitmap;
    //   95: ifnull +81 -> 176
    //   98: ldc 108
    //   100: ldc 134
    //   102: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: ldc 108
    //   107: new 136	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 138
    //   113: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield 144	com/tencent/mm/plugin/vlog/player/b:gLD	I
    //   120: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: ldc 150
    //   125: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_0
    //   129: getfield 156	com/tencent/mm/plugin/vlog/player/b:gLE	I
    //   132: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: ldc 158
    //   137: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 122	com/tencent/mm/plugin/vlog/player/b:width	I
    //   144: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: ldc 160
    //   149: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 126	com/tencent/mm/plugin/vlog/player/b:height	I
    //   156: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: ldc 84
    //   167: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: iconst_0
    //   172: istore_3
    //   173: goto -86 -> 87
    //   176: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   179: lstore_1
    //   180: new 172	android/graphics/BitmapFactory$Options
    //   183: dup
    //   184: invokespecial 174	android/graphics/BitmapFactory$Options:<init>	()V
    //   187: astore 5
    //   189: aload 5
    //   191: iconst_1
    //   192: putfield 177	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   195: aload_0
    //   196: getfield 98	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   199: getfield 102	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   202: aload 5
    //   204: invokestatic 183	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   207: pop
    //   208: aload 5
    //   210: getfield 186	android/graphics/BitmapFactory$Options:outWidth	I
    //   213: istore_3
    //   214: aload 5
    //   216: getfield 189	android/graphics/BitmapFactory$Options:outHeight	I
    //   219: istore 4
    //   221: aload 5
    //   223: iload_3
    //   224: iload 4
    //   226: aload_0
    //   227: getfield 144	com/tencent/mm/plugin/vlog/player/b:gLD	I
    //   230: aload_0
    //   231: getfield 156	com/tencent/mm/plugin/vlog/player/b:gLE	I
    //   234: invokestatic 195	com/tencent/mm/sdk/platformtools/g:O	(IIII)I
    //   237: putfield 198	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   240: aload 5
    //   242: iconst_0
    //   243: putfield 177	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   246: aload_0
    //   247: getfield 98	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   250: getfield 102	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   253: aload 5
    //   255: invokestatic 201	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   258: astore 5
    //   260: aload 5
    //   262: ifnull +336 -> 598
    //   265: aload 5
    //   267: invokevirtual 207	android/graphics/Bitmap:isRecycled	()Z
    //   270: ifne +328 -> 598
    //   273: aload 5
    //   275: invokevirtual 211	android/graphics/Bitmap:getWidth	()I
    //   278: iconst_2
    //   279: irem
    //   280: iconst_1
    //   281: if_icmpne +314 -> 595
    //   284: aload 5
    //   286: invokevirtual 211	android/graphics/Bitmap:getWidth	()I
    //   289: iconst_1
    //   290: iadd
    //   291: aload 5
    //   293: invokevirtual 214	android/graphics/Bitmap:getHeight	()I
    //   296: getstatic 220	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   299: invokestatic 224	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   302: astore 8
    //   304: aload 8
    //   306: ifnonnull +6 -> 312
    //   309: invokestatic 227	d/g/b/p:gfZ	()V
    //   312: new 229	android/graphics/Canvas
    //   315: dup
    //   316: aload 8
    //   318: invokespecial 232	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   321: astore 9
    //   323: aload 9
    //   325: iconst_0
    //   326: iconst_0
    //   327: iconst_0
    //   328: iconst_0
    //   329: invokevirtual 236	android/graphics/Canvas:drawARGB	(IIII)V
    //   332: aload 9
    //   334: aload 5
    //   336: fconst_0
    //   337: fconst_0
    //   338: aconst_null
    //   339: invokevirtual 240	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   342: aload 8
    //   344: astore 5
    //   346: aload 5
    //   348: ifnonnull +6 -> 354
    //   351: invokestatic 227	d/g/b/p:gfZ	()V
    //   354: aload_0
    //   355: aload 5
    //   357: invokevirtual 211	android/graphics/Bitmap:getWidth	()I
    //   360: putfield 122	com/tencent/mm/plugin/vlog/player/b:width	I
    //   363: aload_0
    //   364: aload 5
    //   366: invokevirtual 214	android/graphics/Bitmap:getHeight	()I
    //   369: putfield 126	com/tencent/mm/plugin/vlog/player/b:height	I
    //   372: ldc 108
    //   374: new 136	java/lang/StringBuilder
    //   377: dup
    //   378: ldc 242
    //   380: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   383: iload_3
    //   384: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: ldc 244
    //   389: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: iload 4
    //   394: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: ldc 246
    //   399: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_0
    //   403: getfield 144	com/tencent/mm/plugin/vlog/player/b:gLD	I
    //   406: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   409: ldc 150
    //   411: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_0
    //   415: getfield 156	com/tencent/mm/plugin/vlog/player/b:gLE	I
    //   418: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: ldc 158
    //   423: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_0
    //   427: getfield 122	com/tencent/mm/plugin/vlog/player/b:width	I
    //   430: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: ldc 160
    //   435: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_0
    //   439: getfield 126	com/tencent/mm/plugin/vlog/player/b:height	I
    //   442: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: aload_0
    //   452: getfield 98	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   455: getfield 102	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   458: invokestatic 252	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   461: astore 8
    //   463: aload 8
    //   465: ifnull +166 -> 631
    //   468: aload 8
    //   470: checkcast 254	java/io/Closeable
    //   473: astore 9
    //   475: new 256	android/support/e/a
    //   478: dup
    //   479: aload 9
    //   481: checkcast 258	java/io/InputStream
    //   484: invokespecial 261	android/support/e/a:<init>	(Ljava/io/InputStream;)V
    //   487: astore 8
    //   489: getstatic 267	d/z:MKo	Ld/z;
    //   492: astore 10
    //   494: aload 9
    //   496: aconst_null
    //   497: invokestatic 272	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   500: aload 8
    //   502: astore 6
    //   504: aload 6
    //   506: ifnull +16 -> 522
    //   509: aload 6
    //   511: ldc_w 274
    //   514: invokevirtual 278	android/support/e/a:l	(Ljava/lang/String;)I
    //   517: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   520: astore 7
    //   522: aload 7
    //   524: ifnonnull +113 -> 637
    //   527: aload 7
    //   529: ifnonnull +134 -> 663
    //   532: aload 7
    //   534: ifnonnull +154 -> 688
    //   537: aload_0
    //   538: aload 5
    //   540: putfield 132	com/tencent/mm/plugin/vlog/player/d:BIt	Landroid/graphics/Bitmap;
    //   543: getstatic 94	com/tencent/mm/plugin/vlog/player/e:BIv	Lcom/tencent/mm/plugin/vlog/player/e;
    //   546: astore 5
    //   548: aload_0
    //   549: getfield 98	com/tencent/mm/plugin/vlog/player/b:BIa	Lcom/tencent/mm/plugin/vlog/model/l;
    //   552: getfield 102	com/tencent/mm/plugin/vlog/model/l:path	Ljava/lang/String;
    //   555: aload_0
    //   556: getfield 122	com/tencent/mm/plugin/vlog/player/b:width	I
    //   559: aload_0
    //   560: getfield 126	com/tencent/mm/plugin/vlog/player/b:height	I
    //   563: aload_0
    //   564: getfield 130	com/tencent/mm/plugin/vlog/player/b:dGc	I
    //   567: invokestatic 287	com/tencent/mm/plugin/vlog/player/e:o	(Ljava/lang/String;III)V
    //   570: ldc 108
    //   572: ldc_w 289
    //   575: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   578: lload_1
    //   579: lsub
    //   580: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   583: invokevirtual 298	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   586: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   589: ldc 84
    //   591: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   594: return
    //   595: goto -249 -> 346
    //   598: aconst_null
    //   599: astore 5
    //   601: goto -255 -> 346
    //   604: astore 6
    //   606: ldc 84
    //   608: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   611: aload 6
    //   613: athrow
    //   614: astore 5
    //   616: aload 9
    //   618: aload 6
    //   620: invokestatic 272	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   623: ldc 84
    //   625: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   628: aload 5
    //   630: athrow
    //   631: aconst_null
    //   632: astore 6
    //   634: goto -130 -> 504
    //   637: aload 7
    //   639: invokevirtual 301	java/lang/Integer:intValue	()I
    //   642: bipush 6
    //   644: if_icmpne -117 -> 527
    //   647: aload_0
    //   648: iconst_3
    //   649: putfield 130	com/tencent/mm/plugin/vlog/player/b:dGc	I
    //   652: ldc 108
    //   654: ldc_w 303
    //   657: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   660: goto -123 -> 537
    //   663: aload 7
    //   665: invokevirtual 301	java/lang/Integer:intValue	()I
    //   668: iconst_3
    //   669: if_icmpne -137 -> 532
    //   672: aload_0
    //   673: iconst_2
    //   674: putfield 130	com/tencent/mm/plugin/vlog/player/b:dGc	I
    //   677: ldc 108
    //   679: ldc_w 305
    //   682: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   685: goto -148 -> 537
    //   688: aload 7
    //   690: invokevirtual 301	java/lang/Integer:intValue	()I
    //   693: bipush 8
    //   695: if_icmpne -158 -> 537
    //   698: aload_0
    //   699: iconst_1
    //   700: putfield 130	com/tencent/mm/plugin/vlog/player/b:dGc	I
    //   703: ldc 108
    //   705: ldc_w 307
    //   708: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: goto -174 -> 537
    //   714: astore 5
    //   716: goto -100 -> 616
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	this	d
    //   0	719	1	paramLong	long
    //   86	298	3	i	int
    //   219	174	4	j	int
    //   32	568	5	localObject1	Object
    //   614	15	5	localObject2	Object
    //   714	1	5	localObject3	Object
    //   1	509	6	localObject4	Object
    //   604	15	6	localThrowable	java.lang.Throwable
    //   632	1	6	localObject5	Object
    //   4	685	7	localInteger	java.lang.Integer
    //   302	199	8	localObject6	Object
    //   321	296	9	localObject7	Object
    //   492	1	10	localz	d.z
    // Exception table:
    //   from	to	target	type
    //   475	494	604	java/lang/Throwable
    //   606	614	614	finally
    //   475	494	714	finally
  }
  
  public final void H(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110968);
    if (paramBoolean)
    {
      Bitmap localBitmap = this.BIt;
      if (localBitmap != null)
      {
        ad.i("MicroMsg.VLogImagePlayer", "VLogImagePlayer playing, uploadBitmapTexture, bitmap:" + localBitmap + ", width:" + localBitmap.getWidth() + ", height:" + localBitmap.getHeight());
        c.a locala = c.hoP;
        c.a.b(localBitmap, this.BHZ);
        localBitmap.recycle();
        this.BIt = null;
        AppMethodBeat.o(110968);
        return;
      }
    }
    AppMethodBeat.o(110968);
  }
  
  public final void pause() {}
  
  public final void prepare()
  {
    this.bdb = true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(110970);
    this.BHY = false;
    Bitmap localBitmap = this.BIt;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    this.BIt = null;
    this.bdb = false;
    AppMethodBeat.o(110970);
  }
  
  public final void resume() {}
  
  public final void sR(boolean paramBoolean) {}
  
  public final void stop()
  {
    this.BHY = false;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogImagePlayer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.d
 * JD-Core Version:    0.7.0.1
 */