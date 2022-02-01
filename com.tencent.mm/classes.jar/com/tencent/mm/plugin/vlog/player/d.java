package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.plugin.vlog.model.q;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogImagePlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/ImageMaterial;", "(IIILcom/tencent/mm/plugin/vlog/model/ImageMaterial;)V", "cacheBitmap", "Landroid/graphics/Bitmap;", "enableMute", "", "mute", "", "isMirror", "isOES", "pause", "playing", "pts", "", "updateTex", "prepare", "readyAt", "seekTime", "release", "resizeBitmap", "bitmap", "resume", "stop", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b
{
  public static final a Udj;
  private Bitmap Udk;
  
  static
  {
    AppMethodBeat.i(110972);
    Udj = new a((byte)0);
    AppMethodBeat.o(110972);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, q paramq)
  {
    super(paramInt1, paramInt2, paramInt3, (s)paramq);
    AppMethodBeat.i(110971);
    AppMethodBeat.o(110971);
  }
  
  public final void FP(boolean paramBoolean) {}
  
  public final void Z(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110968);
    if (paramBoolean)
    {
      Bitmap localBitmap = this.Udk;
      if (localBitmap != null)
      {
        Log.i("MicroMsg.VLogImagePlayer", "VLogImagePlayer playing, uploadBitmapTexture, bitmap:" + localBitmap + ", width:" + localBitmap.getWidth() + ", height:" + localBitmap.getHeight());
        c.a locala = c.nFs;
        c.a.c(localBitmap, this.TXY);
        localBitmap.recycle();
        this.Udk = null;
      }
    }
    AppMethodBeat.o(110968);
  }
  
  public final void pause() {}
  
  public final void prepare()
  {
    this.cGv = true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(110970);
    this.UcS = false;
    Bitmap localBitmap = this.Udk;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    this.Udk = null;
    this.cGv = false;
    AppMethodBeat.o(110970);
  }
  
  public final void resume() {}
  
  public final void stop()
  {
    this.UcS = false;
  }
  
  /* Error */
  public final void wG(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc 159
    //   5: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 156	com/tencent/mm/plugin/vlog/player/b:UcS	Z
    //   12: ifeq +9 -> 21
    //   15: ldc 159
    //   17: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: return
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 156	com/tencent/mm/plugin/vlog/player/b:UcS	Z
    //   26: getstatic 165	com/tencent/mm/plugin/vlog/player/e:Udl	Lcom/tencent/mm/plugin/vlog/player/e;
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 169	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   35: getfield 173	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   38: invokestatic 177	com/tencent/mm/plugin/vlog/player/e:bfl	(Ljava/lang/String;)Lcom/tencent/mm/plugin/vlog/player/a;
    //   41: astore 5
    //   43: aload 5
    //   45: ifnull +662 -> 707
    //   48: ldc 91
    //   50: ldc 179
    //   52: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: aload 5
    //   58: getfield 184	com/tencent/mm/plugin/vlog/player/a:width	I
    //   61: putfield 185	com/tencent/mm/plugin/vlog/player/b:width	I
    //   64: aload_0
    //   65: aload 5
    //   67: getfield 188	com/tencent/mm/plugin/vlog/player/a:height	I
    //   70: putfield 189	com/tencent/mm/plugin/vlog/player/b:height	I
    //   73: aload_0
    //   74: aload 5
    //   76: getfield 192	com/tencent/mm/plugin/vlog/player/a:hYK	I
    //   79: invokevirtual 195	com/tencent/mm/plugin/vlog/player/d:th	(I)V
    //   82: iconst_1
    //   83: istore_3
    //   84: iload_3
    //   85: ifeq +83 -> 168
    //   88: aload_0
    //   89: getfield 89	com/tencent/mm/plugin/vlog/player/d:Udk	Landroid/graphics/Bitmap;
    //   92: ifnull +76 -> 168
    //   95: ldc 91
    //   97: ldc 197
    //   99: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: ldc 91
    //   104: new 93	java/lang/StringBuilder
    //   107: dup
    //   108: ldc 199
    //   110: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload_0
    //   114: invokevirtual 202	com/tencent/mm/plugin/vlog/player/d:getDrawWidth	()I
    //   117: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: ldc 204
    //   122: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: invokevirtual 207	com/tencent/mm/plugin/vlog/player/d:getDrawHeight	()I
    //   129: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: ldc 104
    //   134: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: getfield 185	com/tencent/mm/plugin/vlog/player/b:width	I
    //   141: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc 118
    //   146: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: getfield 189	com/tencent/mm/plugin/vlog/player/b:height	I
    //   153: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: ldc 159
    //   164: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: return
    //   168: invokestatic 213	java/lang/System:currentTimeMillis	()J
    //   171: lstore_1
    //   172: new 215	android/graphics/BitmapFactory$Options
    //   175: dup
    //   176: invokespecial 217	android/graphics/BitmapFactory$Options:<init>	()V
    //   179: astore 5
    //   181: aload 5
    //   183: iconst_1
    //   184: putfield 220	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   187: aload_0
    //   188: getfield 169	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   191: getfield 173	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   194: aload 5
    //   196: invokestatic 226	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   199: pop
    //   200: aload 5
    //   202: getfield 229	android/graphics/BitmapFactory$Options:outWidth	I
    //   205: istore_3
    //   206: aload 5
    //   208: getfield 232	android/graphics/BitmapFactory$Options:outHeight	I
    //   211: istore 4
    //   213: aload 5
    //   215: iload_3
    //   216: iload 4
    //   218: aload_0
    //   219: invokevirtual 202	com/tencent/mm/plugin/vlog/player/d:getDrawWidth	()I
    //   222: aload_0
    //   223: invokevirtual 207	com/tencent/mm/plugin/vlog/player/d:getDrawHeight	()I
    //   226: invokestatic 238	com/tencent/mm/sdk/platformtools/BitmapUtil:calculateInSampleSize	(IIII)I
    //   229: putfield 241	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   232: aload 5
    //   234: iconst_0
    //   235: putfield 220	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   238: aload_0
    //   239: getfield 169	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   242: getfield 173	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   245: aload 5
    //   247: invokestatic 244	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   250: astore 5
    //   252: aload 5
    //   254: ifnull +320 -> 574
    //   257: aload 5
    //   259: invokevirtual 248	android/graphics/Bitmap:isRecycled	()Z
    //   262: ifne +312 -> 574
    //   265: aload 5
    //   267: invokevirtual 113	android/graphics/Bitmap:getWidth	()I
    //   270: iconst_2
    //   271: irem
    //   272: iconst_1
    //   273: if_icmpne +298 -> 571
    //   276: aload 5
    //   278: invokevirtual 113	android/graphics/Bitmap:getWidth	()I
    //   281: iconst_1
    //   282: iadd
    //   283: aload 5
    //   285: invokevirtual 121	android/graphics/Bitmap:getHeight	()I
    //   288: getstatic 254	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   291: invokestatic 258	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   294: astore 6
    //   296: aload 6
    //   298: invokestatic 262	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   301: new 264	android/graphics/Canvas
    //   304: dup
    //   305: aload 6
    //   307: invokespecial 267	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   310: astore 8
    //   312: aload 8
    //   314: iconst_0
    //   315: iconst_0
    //   316: iconst_0
    //   317: iconst_0
    //   318: invokevirtual 271	android/graphics/Canvas:drawARGB	(IIII)V
    //   321: aload 8
    //   323: aload 5
    //   325: fconst_0
    //   326: fconst_0
    //   327: aconst_null
    //   328: invokevirtual 275	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   331: aload 6
    //   333: astore 5
    //   335: aload 5
    //   337: invokestatic 262	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   340: aload_0
    //   341: aload 5
    //   343: invokevirtual 113	android/graphics/Bitmap:getWidth	()I
    //   346: putfield 185	com/tencent/mm/plugin/vlog/player/b:width	I
    //   349: aload_0
    //   350: aload 5
    //   352: invokevirtual 121	android/graphics/Bitmap:getHeight	()I
    //   355: putfield 189	com/tencent/mm/plugin/vlog/player/b:height	I
    //   358: ldc 91
    //   360: new 93	java/lang/StringBuilder
    //   363: dup
    //   364: ldc_w 277
    //   367: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   370: iload_3
    //   371: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: ldc_w 279
    //   377: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: iload 4
    //   382: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: ldc_w 281
    //   388: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_0
    //   392: invokevirtual 202	com/tencent/mm/plugin/vlog/player/d:getDrawWidth	()I
    //   395: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   398: ldc 204
    //   400: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: invokevirtual 207	com/tencent/mm/plugin/vlog/player/d:getDrawHeight	()I
    //   407: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: ldc 104
    //   412: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_0
    //   416: getfield 185	com/tencent/mm/plugin/vlog/player/b:width	I
    //   419: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: ldc 118
    //   424: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_0
    //   428: getfield 189	com/tencent/mm/plugin/vlog/player/b:height	I
    //   431: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   434: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: aload_0
    //   441: getfield 169	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   444: getfield 173	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   447: invokestatic 287	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   450: astore 6
    //   452: aload 6
    //   454: ifnull +247 -> 701
    //   457: aload 6
    //   459: checkcast 289	java/io/Closeable
    //   462: astore 8
    //   464: new 291	androidx/f/a/a
    //   467: dup
    //   468: aload 8
    //   470: checkcast 293	java/io/InputStream
    //   473: invokespecial 296	androidx/f/a/a:<init>	(Ljava/io/InputStream;)V
    //   476: astore 6
    //   478: getstatic 302	kotlin/ah:aiuX	Lkotlin/ah;
    //   481: astore 9
    //   483: aload 8
    //   485: aconst_null
    //   486: invokestatic 307	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   489: aload 6
    //   491: ifnonnull +116 -> 607
    //   494: aload 7
    //   496: astore 6
    //   498: aload 6
    //   500: ifnonnull +124 -> 624
    //   503: aload 6
    //   505: ifnonnull +145 -> 650
    //   508: aload 6
    //   510: ifnonnull +165 -> 675
    //   513: aload_0
    //   514: aload 5
    //   516: putfield 89	com/tencent/mm/plugin/vlog/player/d:Udk	Landroid/graphics/Bitmap;
    //   519: getstatic 165	com/tencent/mm/plugin/vlog/player/e:Udl	Lcom/tencent/mm/plugin/vlog/player/e;
    //   522: astore 5
    //   524: aload_0
    //   525: getfield 169	com/tencent/mm/plugin/vlog/player/b:UcR	Lcom/tencent/mm/plugin/vlog/model/s;
    //   528: getfield 173	com/tencent/mm/plugin/vlog/model/s:path	Ljava/lang/String;
    //   531: aload_0
    //   532: getfield 185	com/tencent/mm/plugin/vlog/player/b:width	I
    //   535: aload_0
    //   536: getfield 189	com/tencent/mm/plugin/vlog/player/b:height	I
    //   539: aload_0
    //   540: invokevirtual 310	com/tencent/mm/plugin/vlog/player/d:hRY	()I
    //   543: invokestatic 314	com/tencent/mm/plugin/vlog/player/e:s	(Ljava/lang/String;III)V
    //   546: ldc 91
    //   548: ldc_w 316
    //   551: invokestatic 213	java/lang/System:currentTimeMillis	()J
    //   554: lload_1
    //   555: lsub
    //   556: invokestatic 322	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   559: invokestatic 326	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   562: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: ldc 159
    //   567: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   570: return
    //   571: goto -236 -> 335
    //   574: aconst_null
    //   575: astore 5
    //   577: goto -242 -> 335
    //   580: astore 5
    //   582: ldc 159
    //   584: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   587: aload 5
    //   589: athrow
    //   590: astore 6
    //   592: aload 8
    //   594: aload 5
    //   596: invokestatic 307	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   599: ldc 159
    //   601: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   604: aload 6
    //   606: athrow
    //   607: aload 6
    //   609: ldc_w 328
    //   612: iconst_1
    //   613: invokevirtual 331	androidx/f/a/a:k	(Ljava/lang/String;I)I
    //   616: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   619: astore 6
    //   621: goto -123 -> 498
    //   624: aload 6
    //   626: invokevirtual 339	java/lang/Integer:intValue	()I
    //   629: bipush 6
    //   631: if_icmpne -128 -> 503
    //   634: aload_0
    //   635: iconst_3
    //   636: invokevirtual 195	com/tencent/mm/plugin/vlog/player/d:th	(I)V
    //   639: ldc 91
    //   641: ldc_w 341
    //   644: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: goto -134 -> 513
    //   650: aload 6
    //   652: invokevirtual 339	java/lang/Integer:intValue	()I
    //   655: iconst_3
    //   656: if_icmpne -148 -> 508
    //   659: aload_0
    //   660: iconst_2
    //   661: invokevirtual 195	com/tencent/mm/plugin/vlog/player/d:th	(I)V
    //   664: ldc 91
    //   666: ldc_w 343
    //   669: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   672: goto -159 -> 513
    //   675: aload 6
    //   677: invokevirtual 339	java/lang/Integer:intValue	()I
    //   680: bipush 8
    //   682: if_icmpne -169 -> 513
    //   685: aload_0
    //   686: iconst_1
    //   687: invokevirtual 195	com/tencent/mm/plugin/vlog/player/d:th	(I)V
    //   690: ldc 91
    //   692: ldc_w 345
    //   695: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   698: goto -185 -> 513
    //   701: aconst_null
    //   702: astore 6
    //   704: goto -215 -> 489
    //   707: iconst_0
    //   708: istore_3
    //   709: goto -625 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	712	0	this	d
    //   0	712	1	paramLong	long
    //   83	626	3	i	int
    //   211	170	4	j	int
    //   29	547	5	localObject1	Object
    //   580	15	5	localThrowable	java.lang.Throwable
    //   294	215	6	localObject2	Object
    //   590	18	6	localObject3	Object
    //   619	84	6	localInteger	java.lang.Integer
    //   1	494	7	localObject4	Object
    //   310	283	8	localObject5	Object
    //   481	1	9	localah	kotlin.ah
    // Exception table:
    //   from	to	target	type
    //   464	483	580	finally
    //   582	590	590	finally
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogImagePlayer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.d
 * JD-Core Version:    0.7.0.1
 */