package com.tencent.mm.plugin.record.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.b.g;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;

final class s
  implements p
{
  private String Ahe;
  private int height;
  private String url;
  private int width;
  
  public s(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27813);
    this.Ahe = paramString1;
    this.url = paramString2;
    this.width = paramInt1;
    this.height = paramInt2;
    paramString1 = new StringBuilder();
    bh.bCz();
    paramString1 = new u(c.bzV() + "web/");
    if (!paramString1.jKS()) {
      paramString1.jKY();
    }
    AppMethodBeat.o(27813);
  }
  
  /* Error */
  public final Bitmap a(Bitmap paramBitmap, p.a parama, String paramString)
  {
    // Byte code:
    //   0: sipush 27816
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: astore_3
    //   8: getstatic 83	com/tencent/mm/platformtools/p$a:pAS	Lcom/tencent/mm/platformtools/p$a;
    //   11: aload_2
    //   12: if_acmpne +143 -> 155
    //   15: aload_1
    //   16: astore_3
    //   17: ldc 85
    //   19: ldc 87
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_0
    //   28: getfield 27	com/tencent/mm/plugin/record/model/s:url	Ljava/lang/String;
    //   31: aastore
    //   32: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_1
    //   36: astore_2
    //   37: aload_1
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 29	com/tencent/mm/plugin/record/model/s:width	I
    //   43: ifle +30 -> 73
    //   46: aload_1
    //   47: astore_2
    //   48: aload_1
    //   49: astore_3
    //   50: aload_0
    //   51: getfield 31	com/tencent/mm/plugin/record/model/s:height	I
    //   54: ifle +19 -> 73
    //   57: aload_1
    //   58: astore_3
    //   59: aload_1
    //   60: aload_0
    //   61: getfield 29	com/tencent/mm/plugin/record/model/s:width	I
    //   64: aload_0
    //   65: getfield 31	com/tencent/mm/plugin/record/model/s:height	I
    //   68: iconst_1
    //   69: invokestatic 99	com/tencent/mm/sdk/platformtools/BitmapUtil:getCenterCropBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_3
    //   75: new 42	com/tencent/mm/vfs/u
    //   78: dup
    //   79: aload_0
    //   80: invokevirtual 102	com/tencent/mm/plugin/record/model/s:bTC	()Ljava/lang/String;
    //   83: invokespecial 60	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   86: astore 5
    //   88: aload_2
    //   89: astore_3
    //   90: aload 5
    //   92: invokevirtual 105	com/tencent/mm/vfs/u:jKZ	()Z
    //   95: pop
    //   96: aconst_null
    //   97: astore 4
    //   99: aconst_null
    //   100: astore_1
    //   101: aload 5
    //   103: invokestatic 111	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   106: astore 5
    //   108: aload 5
    //   110: astore_1
    //   111: aload 5
    //   113: astore 4
    //   115: aload_2
    //   116: getstatic 117	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   119: bipush 100
    //   121: aload 5
    //   123: invokevirtual 123	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   126: pop
    //   127: aload 5
    //   129: astore_1
    //   130: aload 5
    //   132: astore 4
    //   134: aload 5
    //   136: invokevirtual 128	java/io/OutputStream:flush	()V
    //   139: aload_2
    //   140: astore_3
    //   141: aload 5
    //   143: ifnull +12 -> 155
    //   146: aload_2
    //   147: astore_3
    //   148: aload 5
    //   150: invokevirtual 131	java/io/OutputStream:close	()V
    //   153: aload_2
    //   154: astore_3
    //   155: sipush 27816
    //   158: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_3
    //   162: areturn
    //   163: astore_3
    //   164: aload_1
    //   165: astore 4
    //   167: ldc 85
    //   169: aload_3
    //   170: ldc 133
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload_2
    //   180: astore_3
    //   181: aload_1
    //   182: ifnull -27 -> 155
    //   185: aload_2
    //   186: astore_3
    //   187: aload_1
    //   188: invokevirtual 131	java/io/OutputStream:close	()V
    //   191: aload_2
    //   192: astore_3
    //   193: goto -38 -> 155
    //   196: astore_1
    //   197: ldc 85
    //   199: aload_1
    //   200: ldc 133
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: goto -54 -> 155
    //   212: astore_1
    //   213: aload 4
    //   215: ifnull +10 -> 225
    //   218: aload_2
    //   219: astore_3
    //   220: aload 4
    //   222: invokevirtual 131	java/io/OutputStream:close	()V
    //   225: aload_2
    //   226: astore_3
    //   227: sipush 27816
    //   230: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aload_2
    //   234: astore_3
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	s
    //   0	237	1	paramBitmap	Bitmap
    //   0	237	2	parama	p.a
    //   0	237	3	paramString	String
    //   97	124	4	localObject1	Object
    //   86	63	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   101	108	163	java/io/FileNotFoundException
    //   115	127	163	java/io/FileNotFoundException
    //   134	139	163	java/io/FileNotFoundException
    //   17	35	196	java/io/IOException
    //   39	46	196	java/io/IOException
    //   50	57	196	java/io/IOException
    //   59	73	196	java/io/IOException
    //   75	88	196	java/io/IOException
    //   90	96	196	java/io/IOException
    //   148	153	196	java/io/IOException
    //   187	191	196	java/io/IOException
    //   220	225	196	java/io/IOException
    //   227	233	196	java/io/IOException
    //   235	237	196	java/io/IOException
    //   101	108	212	finally
    //   115	127	212	finally
    //   134	139	212	finally
    //   167	179	212	finally
  }
  
  public final void a(p.a parama) {}
  
  public final p.b bTB()
  {
    return null;
  }
  
  public final String bTC()
  {
    AppMethodBeat.i(27814);
    Object localObject = new StringBuilder();
    bh.bCz();
    localObject = c.bzV() + "web/" + g.getMessageDigest(this.url.getBytes());
    AppMethodBeat.o(27814);
    return localObject;
  }
  
  public final String bTD()
  {
    return this.url;
  }
  
  public final String bTE()
  {
    return this.Ahe;
  }
  
  public final boolean bTF()
  {
    return true;
  }
  
  public final boolean bTG()
  {
    return false;
  }
  
  public final Bitmap bTH()
  {
    AppMethodBeat.i(27815);
    Bitmap localBitmap = MMBitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.g.nosdcard_headimg);
    AppMethodBeat.o(27815);
    return localBitmap;
  }
  
  public final void bTI() {}
  
  public final void bTJ() {}
  
  public final String getCacheKey()
  {
    return this.Ahe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.s
 * JD-Core Version:    0.7.0.1
 */