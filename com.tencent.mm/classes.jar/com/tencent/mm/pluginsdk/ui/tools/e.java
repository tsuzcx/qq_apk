package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.aj;

public final class e
  implements s
{
  private int height;
  private String qdZ;
  private String url;
  private int width;
  
  public e(String paramString1, String paramString2)
  {
    this.qdZ = paramString1;
    this.url = paramString2;
    this.width = 0;
    this.height = 0;
  }
  
  public final void Z(String paramString, boolean paramBoolean) {}
  
  /* Error */
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    // Byte code:
    //   0: ldc 35
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: astore_3
    //   7: getstatic 47	com/tencent/mm/platformtools/s$a:hUk	Lcom/tencent/mm/platformtools/s$a;
    //   10: aload_2
    //   11: if_acmpne +143 -> 154
    //   14: aload_1
    //   15: astore_3
    //   16: ldc 49
    //   18: ldc 51
    //   20: iconst_1
    //   21: anewarray 4	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: getfield 21	com/tencent/mm/pluginsdk/ui/tools/e:url	Ljava/lang/String;
    //   30: aastore
    //   31: invokestatic 57	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 23	com/tencent/mm/pluginsdk/ui/tools/e:width	I
    //   42: ifle +30 -> 72
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: astore_3
    //   49: aload_0
    //   50: getfield 25	com/tencent/mm/pluginsdk/ui/tools/e:height	I
    //   53: ifle +19 -> 72
    //   56: aload_1
    //   57: astore_3
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 23	com/tencent/mm/pluginsdk/ui/tools/e:width	I
    //   63: aload_0
    //   64: getfield 25	com/tencent/mm/pluginsdk/ui/tools/e:height	I
    //   67: iconst_1
    //   68: invokestatic 63	com/tencent/mm/sdk/platformtools/f:b	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   71: astore_2
    //   72: aload_2
    //   73: astore_3
    //   74: new 65	com/tencent/mm/vfs/e
    //   77: dup
    //   78: aload_0
    //   79: invokevirtual 69	com/tencent/mm/pluginsdk/ui/tools/e:aGy	()Ljava/lang/String;
    //   82: invokespecial 72	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   85: astore 5
    //   87: aload_2
    //   88: astore_3
    //   89: aload 5
    //   91: invokevirtual 76	com/tencent/mm/vfs/e:createNewFile	()Z
    //   94: pop
    //   95: aconst_null
    //   96: astore 4
    //   98: aconst_null
    //   99: astore_1
    //   100: aload 5
    //   102: invokestatic 82	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   105: astore 5
    //   107: aload 5
    //   109: astore_1
    //   110: aload 5
    //   112: astore 4
    //   114: aload_2
    //   115: getstatic 88	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   118: bipush 100
    //   120: aload 5
    //   122: invokevirtual 94	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   125: pop
    //   126: aload 5
    //   128: astore_1
    //   129: aload 5
    //   131: astore 4
    //   133: aload 5
    //   135: invokevirtual 99	java/io/OutputStream:flush	()V
    //   138: aload_2
    //   139: astore_3
    //   140: aload 5
    //   142: ifnull +12 -> 154
    //   145: aload_2
    //   146: astore_3
    //   147: aload 5
    //   149: invokevirtual 102	java/io/OutputStream:close	()V
    //   152: aload_2
    //   153: astore_3
    //   154: ldc 35
    //   156: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_3
    //   160: areturn
    //   161: astore_3
    //   162: aload_1
    //   163: astore 4
    //   165: ldc 49
    //   167: aload_3
    //   168: ldc 107
    //   170: iconst_0
    //   171: anewarray 4	java/lang/Object
    //   174: invokestatic 111	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_2
    //   178: astore_3
    //   179: aload_1
    //   180: ifnull -26 -> 154
    //   183: aload_2
    //   184: astore_3
    //   185: aload_1
    //   186: invokevirtual 102	java/io/OutputStream:close	()V
    //   189: aload_2
    //   190: astore_3
    //   191: goto -37 -> 154
    //   194: astore_1
    //   195: ldc 49
    //   197: aload_1
    //   198: ldc 107
    //   200: iconst_0
    //   201: anewarray 4	java/lang/Object
    //   204: invokestatic 111	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: goto -53 -> 154
    //   210: astore_1
    //   211: aload 4
    //   213: ifnull +10 -> 223
    //   216: aload_2
    //   217: astore_3
    //   218: aload 4
    //   220: invokevirtual 102	java/io/OutputStream:close	()V
    //   223: aload_2
    //   224: astore_3
    //   225: ldc 35
    //   227: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload_2
    //   231: astore_3
    //   232: aload_1
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	e
    //   0	234	1	paramBitmap	Bitmap
    //   0	234	2	parama	s.a
    //   0	234	3	paramString	String
    //   96	123	4	localObject1	Object
    //   85	63	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   100	107	161	java/io/FileNotFoundException
    //   114	126	161	java/io/FileNotFoundException
    //   133	138	161	java/io/FileNotFoundException
    //   16	34	194	java/io/IOException
    //   38	45	194	java/io/IOException
    //   49	56	194	java/io/IOException
    //   58	72	194	java/io/IOException
    //   74	87	194	java/io/IOException
    //   89	95	194	java/io/IOException
    //   147	152	194	java/io/IOException
    //   185	189	194	java/io/IOException
    //   218	223	194	java/io/IOException
    //   225	230	194	java/io/IOException
    //   232	234	194	java/io/IOException
    //   100	107	210	finally
    //   114	126	210	finally
    //   133	138	210	finally
    //   165	177	210	finally
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final String aGA()
  {
    return this.qdZ;
  }
  
  public final boolean aGB()
  {
    return true;
  }
  
  public final boolean aGC()
  {
    return false;
  }
  
  public final Bitmap aGD()
  {
    AppMethodBeat.i(152383);
    Bitmap localBitmap = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233478);
    AppMethodBeat.o(152383);
    return localBitmap;
  }
  
  public final void aGE() {}
  
  public final s.b aGx()
  {
    return null;
  }
  
  public final String aGy()
  {
    AppMethodBeat.i(152382);
    String str = d.apW() + "/" + g.getMessageDigest(this.url.getBytes());
    AppMethodBeat.o(152382);
    return str;
  }
  
  public final String aGz()
  {
    return this.url;
  }
  
  public final String getCacheKey()
  {
    return this.qdZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */