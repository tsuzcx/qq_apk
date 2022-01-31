package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.ah;

public final class c
  implements v
{
  private int height;
  private String mwm;
  private String url;
  private int width;
  
  public c(String paramString1, String paramString2)
  {
    this.mwm = paramString1;
    this.url = paramString2;
    this.width = 0;
    this.height = 0;
  }
  
  public final void W(String paramString, boolean paramBoolean) {}
  
  /* Error */
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    // Byte code:
    //   0: ldc 35
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: astore_3
    //   7: getstatic 47	com/tencent/mm/platformtools/v$a:gjx	Lcom/tencent/mm/platformtools/v$a;
    //   10: aload_2
    //   11: if_acmpne +118 -> 129
    //   14: aload_1
    //   15: astore_3
    //   16: ldc 49
    //   18: ldc 51
    //   20: iconst_1
    //   21: anewarray 4	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: getfield 21	com/tencent/mm/pluginsdk/ui/tools/c:url	Ljava/lang/String;
    //   30: aastore
    //   31: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 23	com/tencent/mm/pluginsdk/ui/tools/c:width	I
    //   42: ifle +30 -> 72
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: astore_3
    //   49: aload_0
    //   50: getfield 25	com/tencent/mm/pluginsdk/ui/tools/c:height	I
    //   53: ifle +19 -> 72
    //   56: aload_1
    //   57: astore_3
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 23	com/tencent/mm/pluginsdk/ui/tools/c:width	I
    //   63: aload_0
    //   64: getfield 25	com/tencent/mm/pluginsdk/ui/tools/c:height	I
    //   67: iconst_1
    //   68: invokestatic 63	com/tencent/mm/sdk/platformtools/d:b	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   71: astore_2
    //   72: aload_2
    //   73: astore_3
    //   74: new 65	java/io/File
    //   77: dup
    //   78: aload_0
    //   79: invokevirtual 69	com/tencent/mm/pluginsdk/ui/tools/c:aon	()Ljava/lang/String;
    //   82: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_2
    //   87: astore_3
    //   88: aload_1
    //   89: invokevirtual 76	java/io/File:createNewFile	()Z
    //   92: pop
    //   93: new 78	java/io/FileOutputStream
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: astore_1
    //   102: aload_1
    //   103: astore_3
    //   104: aload_2
    //   105: getstatic 87	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   108: bipush 100
    //   110: aload_1
    //   111: invokevirtual 93	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   114: pop
    //   115: aload_1
    //   116: astore_3
    //   117: aload_1
    //   118: invokevirtual 96	java/io/FileOutputStream:flush	()V
    //   121: aload_2
    //   122: astore_3
    //   123: aload_1
    //   124: invokevirtual 99	java/io/FileOutputStream:close	()V
    //   127: aload_2
    //   128: astore_3
    //   129: ldc 35
    //   131: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_3
    //   135: areturn
    //   136: astore 4
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_1
    //   141: astore_3
    //   142: ldc 49
    //   144: aload 4
    //   146: ldc 104
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_2
    //   156: astore_3
    //   157: aload_1
    //   158: ifnull -29 -> 129
    //   161: aload_2
    //   162: astore_3
    //   163: aload_1
    //   164: invokevirtual 99	java/io/FileOutputStream:close	()V
    //   167: aload_2
    //   168: astore_3
    //   169: goto -40 -> 129
    //   172: astore_1
    //   173: ldc 49
    //   175: aload_1
    //   176: ldc 104
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 108	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: goto -56 -> 129
    //   188: astore_1
    //   189: aconst_null
    //   190: astore 4
    //   192: aload 4
    //   194: ifnull +10 -> 204
    //   197: aload_2
    //   198: astore_3
    //   199: aload 4
    //   201: invokevirtual 99	java/io/FileOutputStream:close	()V
    //   204: aload_2
    //   205: astore_3
    //   206: ldc 35
    //   208: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_2
    //   212: astore_3
    //   213: aload_1
    //   214: athrow
    //   215: astore_1
    //   216: aload_3
    //   217: astore 4
    //   219: goto -27 -> 192
    //   222: astore 4
    //   224: goto -84 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	c
    //   0	227	1	paramBitmap	Bitmap
    //   0	227	2	parama	v.a
    //   0	227	3	paramString	String
    //   136	9	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   190	28	4	str	String
    //   222	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   93	102	136	java/io/FileNotFoundException
    //   16	34	172	java/io/IOException
    //   38	45	172	java/io/IOException
    //   49	56	172	java/io/IOException
    //   58	72	172	java/io/IOException
    //   74	86	172	java/io/IOException
    //   88	93	172	java/io/IOException
    //   123	127	172	java/io/IOException
    //   163	167	172	java/io/IOException
    //   199	204	172	java/io/IOException
    //   206	211	172	java/io/IOException
    //   213	215	172	java/io/IOException
    //   93	102	188	finally
    //   104	115	215	finally
    //   117	121	215	finally
    //   142	155	215	finally
    //   104	115	222	java/io/FileNotFoundException
    //   117	121	222	java/io/FileNotFoundException
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final v.b aom()
  {
    return null;
  }
  
  public final String aon()
  {
    AppMethodBeat.i(79913);
    String str = com.tencent.mm.plugin.i.c.YK() + "/" + g.w(this.url.getBytes());
    AppMethodBeat.o(79913);
    return str;
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
    AppMethodBeat.i(79914);
    Bitmap localBitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839823);
    AppMethodBeat.o(79914);
    return localBitmap;
  }
  
  public final void aot() {}
  
  public final String getCacheKey()
  {
    return this.mwm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */