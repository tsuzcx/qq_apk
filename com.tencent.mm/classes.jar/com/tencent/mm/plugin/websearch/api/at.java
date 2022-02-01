package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Properties;

public final class at
{
  private int IFu = 1;
  private long IFv;
  private String IFw;
  String IFx;
  private String IFy;
  private String IFz;
  
  public at(String paramString1, String paramString2, String paramString3)
  {
    this.IFw = paramString1;
    this.IFx = paramString2;
    this.IFy = paramString3;
  }
  
  public static int aXk(String paramString)
  {
    AppMethodBeat.i(117802);
    localObject1 = new o(MMApplicationContext.getContext().getCacheDir(), "websearch/temp");
    if (((o)localObject1).exists()) {
      s.dy(aa.z(((o)localObject1).her()), true);
    }
    ((o)localObject1).mkdirs();
    int i = s.fW(paramString, aa.z(((o)localObject1).her()));
    if (i < 0)
    {
      Log.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + aa.z(((o)localObject1).her()));
      AppMethodBeat.o(117802);
      return 1;
    }
    Object localObject3 = new o((o)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = s.ao((o)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      localProperties.load((InputStream)localObject3);
      aa.closeQuietly((Closeable)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getZipFileVersion %s", new Object[] { paramString });
        aa.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      aa.closeQuietly(localObject2);
      AppMethodBeat.o(117802);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    AppMethodBeat.o(117802);
    return i;
  }
  
  private o fYr()
  {
    AppMethodBeat.i(117793);
    o localo = new o(fYs(), "config.conf");
    AppMethodBeat.o(117793);
    return localo;
  }
  
  private String fYu()
  {
    AppMethodBeat.i(117796);
    if (TextUtils.isEmpty(this.IFy))
    {
      AppMethodBeat.o(117796);
      return "config.conf";
    }
    String str = this.IFy + "/" + this.IFx;
    AppMethodBeat.o(117796);
    return str;
  }
  
  public static String fYy()
  {
    return "app.html";
  }
  
  public final void aXj(String paramString)
  {
    AppMethodBeat.i(117801);
    if (s.YS(fYs())) {
      s.dy(fYs(), true);
    }
    s.boN(fYs());
    o localo = new o(fYs(), ".nomedia");
    if (!localo.exists()) {}
    try
    {
      localo.createNewFile();
      int i = s.fW(paramString, fYs());
      if (i < 0)
      {
        Log.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + fYs());
        AppMethodBeat.o(117801);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "create nomedia file error", new Object[0]);
      }
      fYq();
      Log.i("MicroMsg.WebSearch.WebSearchTemplate", "Unzip Path=%s version=%d", new Object[] { fYs(), Integer.valueOf(bbw()) });
      AppMethodBeat.o(117801);
    }
  }
  
  public final int bbw()
  {
    AppMethodBeat.i(117791);
    if ((this.IFu <= 1) || (fYr().lastModified() > this.IFv)) {
      fYq();
    }
    int i = this.IFu;
    AppMethodBeat.o(117791);
    return i;
  }
  
  public final int bbx()
  {
    AppMethodBeat.i(117799);
    Object localObject4 = "assets:///" + fYt();
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = s.openRead((String)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      aa.closeQuietly((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getAssetH5Version", new Object[0]);
        aa.closeQuietly(localObject1);
      }
    }
    finally
    {
      aa.closeQuietly(localObject3);
      AppMethodBeat.o(117799);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    AppMethodBeat.o(117799);
    return i;
  }
  
  public final void fYA()
  {
    AppMethodBeat.i(117800);
    try
    {
      byte[] arrayOfByte = s.aW("assets:///" + fYu(), 0, -1);
      o localo = new o(MMApplicationContext.getContext().getCacheDir(), "websearch/temp.zip");
      if (localo.exists()) {
        localo.delete();
      }
      localo.heq().mkdirs();
      s.f(aa.z(localo.her()), arrayOfByte, arrayOfByte.length);
      aXj(aa.z(localo.her()));
      AppMethodBeat.o(117800);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "initAssetTemplateToPath", new Object[0]);
      AppMethodBeat.o(117800);
    }
  }
  
  public final void fYq()
  {
    AppMethodBeat.i(117792);
    this.IFu = Integer.valueOf(ai.X(fYr()).getProperty("version", "1")).intValue();
    this.IFv = System.currentTimeMillis();
    AppMethodBeat.o(117792);
  }
  
  public final String fYs()
  {
    AppMethodBeat.i(117794);
    Object localObject = new o(b.aKC(), this.IFw);
    if (!((o)localObject).exists()) {
      ((o)localObject).mkdirs();
    }
    localObject = aa.z(((o)localObject).her());
    AppMethodBeat.o(117794);
    return localObject;
  }
  
  public final String fYt()
  {
    AppMethodBeat.i(117795);
    if (TextUtils.isEmpty(this.IFy))
    {
      AppMethodBeat.o(117795);
      return "config.conf";
    }
    String str = this.IFy + "/config.conf";
    AppMethodBeat.o(117795);
    return str;
  }
  
  public final String fYv()
  {
    AppMethodBeat.i(117797);
    String str = fYs() + "/app.html";
    AppMethodBeat.o(117797);
    return str;
  }
  
  public final String fYw()
  {
    AppMethodBeat.i(187868);
    String str = fYs() + "/dist/build.js";
    AppMethodBeat.o(187868);
    return str;
  }
  
  public final String fYx()
  {
    AppMethodBeat.i(187869);
    if (Util.isNullOrNil(this.IFz)) {
      this.IFz = s.bhK(aa.z(new o(fYw()).her()));
    }
    String str = this.IFz;
    AppMethodBeat.o(187869);
    return str;
  }
  
  /* Error */
  public final boolean fYz()
  {
    // Byte code:
    //   0: ldc_w 306
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 216	com/tencent/mm/plugin/websearch/api/at:fYr	()Lcom/tencent/mm/vfs/o;
    //   10: invokestatic 266	com/tencent/mm/plugin/websearch/api/ai:X	(Lcom/tencent/mm/vfs/o;)Ljava/util/Properties;
    //   13: ldc_w 308
    //   16: invokevirtual 310	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_1
    //   20: aload_1
    //   21: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +11 -> 35
    //   27: ldc_w 306
    //   30: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: iconst_0
    //   34: ireturn
    //   35: new 312	org/json/JSONObject
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 313	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 317	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +188 -> 238
    //   53: aload_2
    //   54: invokeinterface 322 1 0
    //   59: ifeq +179 -> 238
    //   62: aload_2
    //   63: invokeinterface 326 1 0
    //   68: checkcast 328	java/lang/String
    //   71: astore_3
    //   72: new 40	com/tencent/mm/vfs/o
    //   75: dup
    //   76: aload_0
    //   77: invokevirtual 167	com/tencent/mm/plugin/websearch/api/at:fYs	()Ljava/lang/String;
    //   80: aload_3
    //   81: invokespecial 169	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: astore 4
    //   86: aload 4
    //   88: invokevirtual 61	com/tencent/mm/vfs/o:exists	()Z
    //   91: ifne +34 -> 125
    //   94: ldc 86
    //   96: ldc_w 330
    //   99: iconst_1
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload 4
    //   107: invokevirtual 65	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   110: invokestatic 71	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   113: aastore
    //   114: invokestatic 333	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: ldc_w 306
    //   120: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: iconst_0
    //   124: ireturn
    //   125: aload 4
    //   127: invokevirtual 65	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   130: invokestatic 71	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   133: invokestatic 304	com/tencent/mm/vfs/s:bhK	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 4
    //   138: aload_1
    //   139: aload_3
    //   140: invokevirtual 336	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 5
    //   145: aload 4
    //   147: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +54 -> 204
    //   153: aload 4
    //   155: aload 5
    //   157: invokevirtual 340	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +44 -> 204
    //   163: aload_3
    //   164: ldc_w 342
    //   167: invokevirtual 340	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifeq -121 -> 49
    //   173: aload_0
    //   174: aload 4
    //   176: putfield 292	com/tencent/mm/plugin/websearch/api/at:IFz	Ljava/lang/String;
    //   179: goto -130 -> 49
    //   182: astore_1
    //   183: ldc 86
    //   185: aload_1
    //   186: ldc_w 344
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: ldc_w 306
    //   199: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: iconst_0
    //   203: ireturn
    //   204: ldc 86
    //   206: ldc_w 346
    //   209: iconst_3
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_3
    //   216: aastore
    //   217: dup
    //   218: iconst_1
    //   219: aload 4
    //   221: aastore
    //   222: dup
    //   223: iconst_2
    //   224: aload 5
    //   226: aastore
    //   227: invokestatic 333	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: ldc_w 306
    //   233: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: iconst_0
    //   237: ireturn
    //   238: ldc_w 306
    //   241: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: iconst_1
    //   245: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	at
    //   19	120	1	localObject1	Object
    //   182	4	1	localException	Exception
    //   48	15	2	localIterator	java.util.Iterator
    //   71	145	3	str1	String
    //   84	136	4	localObject2	Object
    //   143	82	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   35	49	182	java/lang/Exception
    //   53	117	182	java/lang/Exception
    //   125	179	182	java/lang/Exception
    //   204	230	182	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.at
 * JD-Core Version:    0.7.0.1
 */