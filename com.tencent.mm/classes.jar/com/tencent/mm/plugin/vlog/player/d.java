package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.vlog.model.q;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogImagePlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/ImageMaterial;", "(IIILcom/tencent/mm/plugin/vlog/model/ImageMaterial;)V", "cacheBitmap", "Landroid/graphics/Bitmap;", "enableMute", "", "mute", "", "isMirror", "isOES", "pause", "playing", "pts", "", "updateTex", "prepare", "readyAt", "seekTime", "release", "resizeBitmap", "bitmap", "resume", "stop", "Companion", "plugin-vlog_release"})
public final class d
  extends b
{
  public static final a Npr;
  private Bitmap Npq;
  
  static
  {
    AppMethodBeat.i(110972);
    Npr = new a((byte)0);
    AppMethodBeat.o(110972);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, q paramq)
  {
    super(paramInt1, paramInt2, paramInt3, (s)paramq);
    AppMethodBeat.i(110971);
    AppMethodBeat.o(110971);
  }
  
  public final void Aq(boolean paramBoolean) {}
  
  public final void O(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110968);
    if (paramBoolean)
    {
      Bitmap localBitmap = this.Npq;
      if (localBitmap != null)
      {
        Log.i("MicroMsg.VLogImagePlayer", "VLogImagePlayer playing, uploadBitmapTexture, bitmap:" + localBitmap + ", width:" + localBitmap.getWidth() + ", height:" + localBitmap.getHeight());
        c.a locala = c.lar;
        c.a.d(localBitmap, this.NkK);
        localBitmap.recycle();
        this.Npq = null;
        AppMethodBeat.o(110968);
        return;
      }
    }
    AppMethodBeat.o(110968);
  }
  
  /* Error */
  public final void Ss(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc 151
    //   8: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: getfield 155	com/tencent/mm/plugin/vlog/player/b:NoX	Z
    //   15: ifeq +9 -> 24
    //   18: ldc 151
    //   20: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 155	com/tencent/mm/plugin/vlog/player/b:NoX	Z
    //   29: getstatic 161	com/tencent/mm/plugin/vlog/player/e:Nps	Lcom/tencent/mm/plugin/vlog/player/e;
    //   32: astore 5
    //   34: aload_0
    //   35: getfield 165	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   38: getfield 169	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   41: invokestatic 173	com/tencent/mm/plugin/vlog/player/e:bfE	(Ljava/lang/String;)Lcom/tencent/mm/plugin/vlog/player/a;
    //   44: astore 5
    //   46: aload 5
    //   48: ifnull +123 -> 171
    //   51: ldc 88
    //   53: ldc 175
    //   55: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: aload 5
    //   61: getfield 180	com/tencent/mm/plugin/vlog/player/a:width	I
    //   64: putfield 181	com/tencent/mm/plugin/vlog/player/b:width	I
    //   67: aload_0
    //   68: aload 5
    //   70: getfield 184	com/tencent/mm/plugin/vlog/player/a:height	I
    //   73: putfield 185	com/tencent/mm/plugin/vlog/player/b:height	I
    //   76: aload_0
    //   77: aload 5
    //   79: getfield 188	com/tencent/mm/plugin/vlog/player/a:fSM	I
    //   82: invokevirtual 191	com/tencent/mm/plugin/vlog/player/d:tm	(I)V
    //   85: iconst_1
    //   86: istore_3
    //   87: iload_3
    //   88: ifeq +88 -> 176
    //   91: aload_0
    //   92: getfield 86	com/tencent/mm/plugin/vlog/player/d:Npq	Landroid/graphics/Bitmap;
    //   95: ifnull +81 -> 176
    //   98: ldc 88
    //   100: ldc 193
    //   102: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: ldc 88
    //   107: new 90	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 195
    //   113: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: invokevirtual 198	com/tencent/mm/plugin/vlog/player/d:getDrawWidth	()I
    //   120: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: ldc 200
    //   125: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_0
    //   129: invokevirtual 203	com/tencent/mm/plugin/vlog/player/d:getDrawHeight	()I
    //   132: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: ldc 101
    //   137: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 181	com/tencent/mm/plugin/vlog/player/b:width	I
    //   144: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: ldc 115
    //   149: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 185	com/tencent/mm/plugin/vlog/player/b:height	I
    //   156: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: ldc 151
    //   167: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: iconst_0
    //   172: istore_3
    //   173: goto -86 -> 87
    //   176: invokestatic 209	java/lang/System:currentTimeMillis	()J
    //   179: lstore_1
    //   180: new 211	android/graphics/BitmapFactory$Options
    //   183: dup
    //   184: invokespecial 213	android/graphics/BitmapFactory$Options:<init>	()V
    //   187: astore 5
    //   189: aload 5
    //   191: iconst_1
    //   192: putfield 216	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   195: aload_0
    //   196: getfield 165	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   199: getfield 169	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   202: aload 5
    //   204: invokestatic 222	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   207: pop
    //   208: aload 5
    //   210: getfield 225	android/graphics/BitmapFactory$Options:outWidth	I
    //   213: istore_3
    //   214: aload 5
    //   216: getfield 228	android/graphics/BitmapFactory$Options:outHeight	I
    //   219: istore 4
    //   221: aload 5
    //   223: iload_3
    //   224: iload 4
    //   226: aload_0
    //   227: invokevirtual 198	com/tencent/mm/plugin/vlog/player/d:getDrawWidth	()I
    //   230: aload_0
    //   231: invokevirtual 203	com/tencent/mm/plugin/vlog/player/d:getDrawHeight	()I
    //   234: invokestatic 234	com/tencent/mm/sdk/platformtools/BitmapUtil:calculateInSampleSize	(IIII)I
    //   237: putfield 237	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   240: aload 5
    //   242: iconst_0
    //   243: putfield 216	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   246: aload_0
    //   247: getfield 165	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   250: getfield 169	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   253: aload 5
    //   255: invokestatic 240	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   258: astore 5
    //   260: aload 5
    //   262: ifnull +340 -> 602
    //   265: aload 5
    //   267: invokevirtual 244	android/graphics/Bitmap:isRecycled	()Z
    //   270: ifne +332 -> 602
    //   273: aload 5
    //   275: invokevirtual 110	android/graphics/Bitmap:getWidth	()I
    //   278: iconst_2
    //   279: irem
    //   280: iconst_1
    //   281: if_icmpne +318 -> 599
    //   284: aload 5
    //   286: invokevirtual 110	android/graphics/Bitmap:getWidth	()I
    //   289: iconst_1
    //   290: iadd
    //   291: aload 5
    //   293: invokevirtual 118	android/graphics/Bitmap:getHeight	()I
    //   296: getstatic 250	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   299: invokestatic 254	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   302: astore 8
    //   304: aload 8
    //   306: ifnonnull +6 -> 312
    //   309: invokestatic 257	kotlin/g/b/p:iCn	()V
    //   312: new 259	android/graphics/Canvas
    //   315: dup
    //   316: aload 8
    //   318: invokespecial 262	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   321: astore 9
    //   323: aload 9
    //   325: iconst_0
    //   326: iconst_0
    //   327: iconst_0
    //   328: iconst_0
    //   329: invokevirtual 266	android/graphics/Canvas:drawARGB	(IIII)V
    //   332: aload 9
    //   334: aload 5
    //   336: fconst_0
    //   337: fconst_0
    //   338: aconst_null
    //   339: invokevirtual 270	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   342: aload 8
    //   344: astore 5
    //   346: aload 5
    //   348: ifnonnull +6 -> 354
    //   351: invokestatic 257	kotlin/g/b/p:iCn	()V
    //   354: aload_0
    //   355: aload 5
    //   357: invokevirtual 110	android/graphics/Bitmap:getWidth	()I
    //   360: putfield 181	com/tencent/mm/plugin/vlog/player/b:width	I
    //   363: aload_0
    //   364: aload 5
    //   366: invokevirtual 118	android/graphics/Bitmap:getHeight	()I
    //   369: putfield 185	com/tencent/mm/plugin/vlog/player/b:height	I
    //   372: ldc 88
    //   374: new 90	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 272
    //   381: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: iload_3
    //   385: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: ldc_w 274
    //   391: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: iload 4
    //   396: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   399: ldc_w 276
    //   402: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_0
    //   406: invokevirtual 198	com/tencent/mm/plugin/vlog/player/d:getDrawWidth	()I
    //   409: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: ldc 200
    //   414: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_0
    //   418: invokevirtual 203	com/tencent/mm/plugin/vlog/player/d:getDrawHeight	()I
    //   421: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   424: ldc 101
    //   426: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_0
    //   430: getfield 181	com/tencent/mm/plugin/vlog/player/b:width	I
    //   433: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   436: ldc 115
    //   438: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_0
    //   442: getfield 185	com/tencent/mm/plugin/vlog/player/b:height	I
    //   445: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_0
    //   455: getfield 165	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   458: getfield 169	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   461: invokestatic 282	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   464: astore 8
    //   466: aload 8
    //   468: ifnull +167 -> 635
    //   471: aload 8
    //   473: checkcast 284	java/io/Closeable
    //   476: astore 9
    //   478: new 286	androidx/e/a/a
    //   481: dup
    //   482: aload 9
    //   484: checkcast 288	java/io/InputStream
    //   487: invokespecial 291	androidx/e/a/a:<init>	(Ljava/io/InputStream;)V
    //   490: astore 8
    //   492: getstatic 297	kotlin/x:aazN	Lkotlin/x;
    //   495: astore 10
    //   497: aload 9
    //   499: aconst_null
    //   500: invokestatic 302	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   503: aload 8
    //   505: astore 6
    //   507: aload 6
    //   509: ifnull +17 -> 526
    //   512: aload 6
    //   514: ldc_w 304
    //   517: iconst_1
    //   518: invokevirtual 307	androidx/e/a/a:i	(Ljava/lang/String;I)I
    //   521: invokestatic 313	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: astore 7
    //   526: aload 7
    //   528: ifnonnull +113 -> 641
    //   531: aload 7
    //   533: ifnonnull +134 -> 667
    //   536: aload 7
    //   538: ifnonnull +154 -> 692
    //   541: aload_0
    //   542: aload 5
    //   544: putfield 86	com/tencent/mm/plugin/vlog/player/d:Npq	Landroid/graphics/Bitmap;
    //   547: getstatic 161	com/tencent/mm/plugin/vlog/player/e:Nps	Lcom/tencent/mm/plugin/vlog/player/e;
    //   550: astore 5
    //   552: aload_0
    //   553: getfield 165	com/tencent/mm/plugin/vlog/player/b:NoY	Lcom/tencent/mm/plugin/vlog/model/s;
    //   556: getfield 169	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   559: aload_0
    //   560: getfield 181	com/tencent/mm/plugin/vlog/player/b:width	I
    //   563: aload_0
    //   564: getfield 185	com/tencent/mm/plugin/vlog/player/b:height	I
    //   567: aload_0
    //   568: invokevirtual 316	com/tencent/mm/plugin/vlog/player/d:aVr	()I
    //   571: invokestatic 320	com/tencent/mm/plugin/vlog/player/e:s	(Ljava/lang/String;III)V
    //   574: ldc 88
    //   576: ldc_w 322
    //   579: invokestatic 209	java/lang/System:currentTimeMillis	()J
    //   582: lload_1
    //   583: lsub
    //   584: invokestatic 327	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   587: invokevirtual 331	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   590: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: ldc 151
    //   595: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   598: return
    //   599: goto -253 -> 346
    //   602: aconst_null
    //   603: astore 5
    //   605: goto -259 -> 346
    //   608: astore 6
    //   610: ldc 151
    //   612: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   615: aload 6
    //   617: athrow
    //   618: astore 5
    //   620: aload 9
    //   622: aload 6
    //   624: invokestatic 302	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   627: ldc 151
    //   629: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   632: aload 5
    //   634: athrow
    //   635: aconst_null
    //   636: astore 6
    //   638: goto -131 -> 507
    //   641: aload 7
    //   643: invokevirtual 334	java/lang/Integer:intValue	()I
    //   646: bipush 6
    //   648: if_icmpne -117 -> 531
    //   651: aload_0
    //   652: iconst_3
    //   653: invokevirtual 191	com/tencent/mm/plugin/vlog/player/d:tm	(I)V
    //   656: ldc 88
    //   658: ldc_w 336
    //   661: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   664: goto -123 -> 541
    //   667: aload 7
    //   669: invokevirtual 334	java/lang/Integer:intValue	()I
    //   672: iconst_3
    //   673: if_icmpne -137 -> 536
    //   676: aload_0
    //   677: iconst_2
    //   678: invokevirtual 191	com/tencent/mm/plugin/vlog/player/d:tm	(I)V
    //   681: ldc 88
    //   683: ldc_w 338
    //   686: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   689: goto -148 -> 541
    //   692: aload 7
    //   694: invokevirtual 334	java/lang/Integer:intValue	()I
    //   697: bipush 8
    //   699: if_icmpne -158 -> 541
    //   702: aload_0
    //   703: iconst_1
    //   704: invokevirtual 191	com/tencent/mm/plugin/vlog/player/d:tm	(I)V
    //   707: ldc 88
    //   709: ldc_w 340
    //   712: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   715: goto -174 -> 541
    //   718: astore 5
    //   720: goto -100 -> 620
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	723	0	this	d
    //   0	723	1	paramLong	long
    //   86	299	3	i	int
    //   219	176	4	j	int
    //   32	572	5	localObject1	Object
    //   618	15	5	localObject2	Object
    //   718	1	5	localObject3	Object
    //   1	512	6	localObject4	Object
    //   608	15	6	localThrowable	java.lang.Throwable
    //   636	1	6	localObject5	Object
    //   4	689	7	localInteger	java.lang.Integer
    //   302	202	8	localObject6	Object
    //   321	300	9	localObject7	Object
    //   495	1	10	localx	kotlin.x
    // Exception table:
    //   from	to	target	type
    //   478	497	608	java/lang/Throwable
    //   610	618	618	finally
    //   478	497	718	finally
  }
  
  public final void pause() {}
  
  public final void prepare()
  {
    this.aMy = true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(110970);
    this.NoX = false;
    Bitmap localBitmap = this.Npq;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    this.Npq = null;
    this.aMy = false;
    AppMethodBeat.o(110970);
  }
  
  public final void resume() {}
  
  public final void stop()
  {
    this.NoX = false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogImagePlayer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.d
 * JD-Core Version:    0.7.0.1
 */