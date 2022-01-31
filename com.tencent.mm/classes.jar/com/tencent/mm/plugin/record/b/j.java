package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.R.g;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.File;

final class j
  implements v
{
  private int height;
  private String kbQ;
  private String url;
  private int width;
  
  public j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.kbQ = paramString1;
    this.url = paramString2;
    this.width = paramInt1;
    this.height = paramInt2;
    paramString1 = new StringBuilder();
    au.Hx();
    paramString1 = new File(c.FQ() + "web/");
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
  }
  
  public final void S(String paramString, boolean paramBoolean) {}
  
  public final v.b UN()
  {
    return null;
  }
  
  public final String UO()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    return c.FQ() + "web/" + g.o(this.url.getBytes());
  }
  
  public final String UP()
  {
    return this.url;
  }
  
  public final String UQ()
  {
    return this.kbQ;
  }
  
  public final boolean UR()
  {
    return true;
  }
  
  public final boolean US()
  {
    return false;
  }
  
  public final Bitmap UT()
  {
    return BitmapFactory.decodeResource(ae.getContext().getResources(), R.g.nosdcard_headimg);
  }
  
  public final void UU() {}
  
  /* Error */
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_3
    //   2: getstatic 121	com/tencent/mm/platformtools/v$a:eRD	Lcom/tencent/mm/platformtools/v$a;
    //   5: aload_2
    //   6: if_acmpne +118 -> 124
    //   9: aload_1
    //   10: astore_3
    //   11: ldc 123
    //   13: ldc 125
    //   15: iconst_1
    //   16: anewarray 4	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_0
    //   22: getfield 21	com/tencent/mm/plugin/record/b/j:url	Ljava/lang/String;
    //   25: aastore
    //   26: invokestatic 131	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_1
    //   30: astore_2
    //   31: aload_1
    //   32: astore_3
    //   33: aload_0
    //   34: getfield 23	com/tencent/mm/plugin/record/b/j:width	I
    //   37: ifle +30 -> 67
    //   40: aload_1
    //   41: astore_2
    //   42: aload_1
    //   43: astore_3
    //   44: aload_0
    //   45: getfield 25	com/tencent/mm/plugin/record/b/j:height	I
    //   48: ifle +19 -> 67
    //   51: aload_1
    //   52: astore_3
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 23	com/tencent/mm/plugin/record/b/j:width	I
    //   58: aload_0
    //   59: getfield 25	com/tencent/mm/plugin/record/b/j:height	I
    //   62: iconst_1
    //   63: invokestatic 136	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   66: astore_2
    //   67: aload_2
    //   68: astore_3
    //   69: new 36	java/io/File
    //   72: dup
    //   73: aload_0
    //   74: invokevirtual 138	com/tencent/mm/plugin/record/b/j:UO	()Ljava/lang/String;
    //   77: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: astore_1
    //   81: aload_2
    //   82: astore_3
    //   83: aload_1
    //   84: invokevirtual 141	java/io/File:createNewFile	()Z
    //   87: pop
    //   88: new 143	java/io/FileOutputStream
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   96: astore_1
    //   97: aload_1
    //   98: astore_3
    //   99: aload_2
    //   100: getstatic 152	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   103: bipush 100
    //   105: aload_1
    //   106: invokevirtual 158	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   109: pop
    //   110: aload_1
    //   111: astore_3
    //   112: aload_1
    //   113: invokevirtual 161	java/io/FileOutputStream:flush	()V
    //   116: aload_2
    //   117: astore_3
    //   118: aload_1
    //   119: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   122: aload_2
    //   123: astore_3
    //   124: aload_3
    //   125: areturn
    //   126: astore 4
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: astore_3
    //   132: ldc 123
    //   134: aload 4
    //   136: ldc 166
    //   138: iconst_0
    //   139: anewarray 4	java/lang/Object
    //   142: invokestatic 170	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_2
    //   146: astore_3
    //   147: aload_1
    //   148: ifnull -24 -> 124
    //   151: aload_2
    //   152: astore_3
    //   153: aload_1
    //   154: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   157: aload_2
    //   158: areturn
    //   159: astore_1
    //   160: ldc 123
    //   162: aload_1
    //   163: ldc 166
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 170	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_3
    //   173: areturn
    //   174: astore_1
    //   175: aconst_null
    //   176: astore 4
    //   178: aload 4
    //   180: ifnull +10 -> 190
    //   183: aload_2
    //   184: astore_3
    //   185: aload 4
    //   187: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   190: aload_2
    //   191: astore_3
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload_3
    //   196: astore 4
    //   198: goto -20 -> 178
    //   201: astore 4
    //   203: goto -73 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	j
    //   0	206	1	paramBitmap	Bitmap
    //   0	206	2	parama	v.a
    //   0	206	3	paramString	String
    //   126	9	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   176	21	4	str	String
    //   201	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   88	97	126	java/io/FileNotFoundException
    //   11	29	159	java/io/IOException
    //   33	40	159	java/io/IOException
    //   44	51	159	java/io/IOException
    //   53	67	159	java/io/IOException
    //   69	81	159	java/io/IOException
    //   83	88	159	java/io/IOException
    //   118	122	159	java/io/IOException
    //   153	157	159	java/io/IOException
    //   185	190	159	java/io/IOException
    //   192	194	159	java/io/IOException
    //   88	97	174	finally
    //   99	110	194	finally
    //   112	116	194	finally
    //   132	145	194	finally
    //   99	110	201	java/io/FileNotFoundException
    //   112	116	201	java/io/FileNotFoundException
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final String getCacheKey()
  {
    return this.kbQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.j
 * JD-Core Version:    0.7.0.1
 */