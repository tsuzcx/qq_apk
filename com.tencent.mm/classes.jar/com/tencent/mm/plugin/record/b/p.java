package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;

final class p
  implements v
{
  private int height;
  private String mwm;
  private String url;
  private int width;
  
  public p(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24175);
    this.mwm = paramString1;
    this.url = paramString2;
    this.width = paramInt1;
    this.height = paramInt2;
    paramString1 = new StringBuilder();
    aw.aaz();
    paramString1 = new File(c.YU() + "web/");
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    AppMethodBeat.o(24175);
  }
  
  public final void W(String paramString, boolean paramBoolean) {}
  
  /* Error */
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    // Byte code:
    //   0: sipush 24178
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: astore_3
    //   8: getstatic 85	com/tencent/mm/platformtools/v$a:gjx	Lcom/tencent/mm/platformtools/v$a;
    //   11: aload_2
    //   12: if_acmpne +118 -> 130
    //   15: aload_1
    //   16: astore_3
    //   17: ldc 87
    //   19: ldc 89
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_0
    //   28: getfield 27	com/tencent/mm/plugin/record/b/p:url	Ljava/lang/String;
    //   31: aastore
    //   32: invokestatic 95	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_1
    //   36: astore_2
    //   37: aload_1
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 29	com/tencent/mm/plugin/record/b/p:width	I
    //   43: ifle +30 -> 73
    //   46: aload_1
    //   47: astore_2
    //   48: aload_1
    //   49: astore_3
    //   50: aload_0
    //   51: getfield 31	com/tencent/mm/plugin/record/b/p:height	I
    //   54: ifle +19 -> 73
    //   57: aload_1
    //   58: astore_3
    //   59: aload_1
    //   60: aload_0
    //   61: getfield 29	com/tencent/mm/plugin/record/b/p:width	I
    //   64: aload_0
    //   65: getfield 31	com/tencent/mm/plugin/record/b/p:height	I
    //   68: iconst_1
    //   69: invokestatic 101	com/tencent/mm/sdk/platformtools/d:b	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_3
    //   75: new 42	java/io/File
    //   78: dup
    //   79: aload_0
    //   80: invokevirtual 104	com/tencent/mm/plugin/record/b/p:aon	()Ljava/lang/String;
    //   83: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: astore_1
    //   87: aload_2
    //   88: astore_3
    //   89: aload_1
    //   90: invokevirtual 107	java/io/File:createNewFile	()Z
    //   93: pop
    //   94: new 109	java/io/FileOutputStream
    //   97: dup
    //   98: aload_1
    //   99: invokespecial 112	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   102: astore_1
    //   103: aload_1
    //   104: astore_3
    //   105: aload_2
    //   106: getstatic 118	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   109: bipush 100
    //   111: aload_1
    //   112: invokevirtual 124	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   115: pop
    //   116: aload_1
    //   117: astore_3
    //   118: aload_1
    //   119: invokevirtual 127	java/io/FileOutputStream:flush	()V
    //   122: aload_2
    //   123: astore_3
    //   124: aload_1
    //   125: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   128: aload_2
    //   129: astore_3
    //   130: sipush 24178
    //   133: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_3
    //   137: areturn
    //   138: astore 4
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_1
    //   143: astore_3
    //   144: ldc 87
    //   146: aload 4
    //   148: ldc 132
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokestatic 136	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_2
    //   158: astore_3
    //   159: aload_1
    //   160: ifnull -30 -> 130
    //   163: aload_2
    //   164: astore_3
    //   165: aload_1
    //   166: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   169: aload_2
    //   170: astore_3
    //   171: goto -41 -> 130
    //   174: astore_1
    //   175: ldc 87
    //   177: aload_1
    //   178: ldc 132
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 136	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: goto -57 -> 130
    //   190: astore_1
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 4
    //   196: ifnull +10 -> 206
    //   199: aload_2
    //   200: astore_3
    //   201: aload 4
    //   203: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   206: aload_2
    //   207: astore_3
    //   208: sipush 24178
    //   211: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_2
    //   215: astore_3
    //   216: aload_1
    //   217: athrow
    //   218: astore_1
    //   219: aload_3
    //   220: astore 4
    //   222: goto -28 -> 194
    //   225: astore 4
    //   227: goto -85 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	p
    //   0	230	1	paramBitmap	Bitmap
    //   0	230	2	parama	v.a
    //   0	230	3	paramString	String
    //   138	9	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   192	29	4	str	String
    //   225	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   94	103	138	java/io/FileNotFoundException
    //   17	35	174	java/io/IOException
    //   39	46	174	java/io/IOException
    //   50	57	174	java/io/IOException
    //   59	73	174	java/io/IOException
    //   75	87	174	java/io/IOException
    //   89	94	174	java/io/IOException
    //   124	128	174	java/io/IOException
    //   165	169	174	java/io/IOException
    //   201	206	174	java/io/IOException
    //   208	214	174	java/io/IOException
    //   216	218	174	java/io/IOException
    //   94	103	190	finally
    //   105	116	218	finally
    //   118	122	218	finally
    //   144	157	218	finally
    //   105	116	225	java/io/FileNotFoundException
    //   118	122	225	java/io/FileNotFoundException
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final v.b aom()
  {
    return null;
  }
  
  public final String aon()
  {
    AppMethodBeat.i(24176);
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = c.YU() + "web/" + g.w(this.url.getBytes());
    AppMethodBeat.o(24176);
    return localObject;
  }
  
  public final String aoo()
  {
    return this.url;
  }
  
  public final String aop()
  {
    return this.mwm;
  }
  
  public final boolean aoq()
  {
    return true;
  }
  
  public final boolean aor()
  {
    return false;
  }
  
  public final Bitmap aos()
  {
    AppMethodBeat.i(24177);
    Bitmap localBitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839823);
    AppMethodBeat.o(24177);
    return localBitmap;
  }
  
  public final void aot() {}
  
  public final String getCacheKey()
  {
    return this.mwm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.p
 * JD-Core Version:    0.7.0.1
 */