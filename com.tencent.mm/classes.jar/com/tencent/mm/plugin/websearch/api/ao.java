package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Properties;

public final class ao
{
  private long DUA;
  private String DUB;
  String DUC;
  private String DUD;
  private String DUE;
  private int DUz = 1;
  
  public ao(String paramString1, String paramString2, String paramString3)
  {
    this.DUB = paramString1;
    this.DUC = paramString2;
    this.DUD = paramString3;
  }
  
  public static int aHp(String paramString)
  {
    AppMethodBeat.i(117802);
    localObject1 = new k(ak.getContext().getCacheDir(), "websearch/temp");
    if (((k)localObject1).exists()) {
      o.dd(w.B(((k)localObject1).fTh()), true);
    }
    ((k)localObject1).mkdirs();
    int i = o.fD(paramString, w.B(((k)localObject1).fTh()));
    if (i < 0)
    {
      ae.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + w.B(((k)localObject1).fTh()));
      AppMethodBeat.o(117802);
      return 1;
    }
    Object localObject3 = new k((k)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = o.ai((k)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      localProperties.load((InputStream)localObject3);
      w.closeQuietly((Closeable)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getZipFileVersion %s", new Object[] { paramString });
        w.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      w.closeQuietly(localObject2);
      AppMethodBeat.o(117802);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    AppMethodBeat.o(117802);
    return i;
  }
  
  private k eQe()
  {
    AppMethodBeat.i(117793);
    k localk = new k(eQf(), "config.conf");
    AppMethodBeat.o(117793);
    return localk;
  }
  
  private String eQh()
  {
    AppMethodBeat.i(117796);
    if (TextUtils.isEmpty(this.DUD))
    {
      AppMethodBeat.o(117796);
      return "config.conf";
    }
    String str = this.DUD + "/" + this.DUC;
    AppMethodBeat.o(117796);
    return str;
  }
  
  public final int aHD()
  {
    AppMethodBeat.i(117791);
    if ((this.DUz <= 1) || (eQe().lastModified() > this.DUA)) {
      eQd();
    }
    int i = this.DUz;
    AppMethodBeat.o(117791);
    return i;
  }
  
  public final int aHE()
  {
    AppMethodBeat.i(117799);
    Object localObject4 = "assets:///" + eQg();
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = o.openRead((String)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      w.closeQuietly((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getAssetH5Version", new Object[0]);
        w.closeQuietly(localObject1);
      }
    }
    finally
    {
      w.closeQuietly(localObject3);
      AppMethodBeat.o(117799);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    AppMethodBeat.o(117799);
    return i;
  }
  
  public final void aHo(String paramString)
  {
    AppMethodBeat.i(117801);
    if (o.fB(eQf())) {
      o.dd(eQf(), true);
    }
    o.aZI(eQf());
    k localk = new k(eQf(), ".nomedia");
    if (!localk.exists()) {}
    try
    {
      localk.createNewFile();
      int i = o.fD(paramString, eQf());
      if (i < 0)
      {
        ae.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + eQf());
        AppMethodBeat.o(117801);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "create nomedia file error", new Object[0]);
      }
      eQd();
      ae.i("MicroMsg.WebSearch.WebSearchTemplate", "Unzip Path=%s version=%d", new Object[] { eQf(), Integer.valueOf(aHD()) });
      AppMethodBeat.o(117801);
    }
  }
  
  public final void eQd()
  {
    AppMethodBeat.i(117792);
    this.DUz = Integer.valueOf(ad.T(eQe()).getProperty("version", "1")).intValue();
    this.DUA = System.currentTimeMillis();
    AppMethodBeat.o(117792);
  }
  
  public final String eQf()
  {
    AppMethodBeat.i(117794);
    Object localObject = new k(b.asc(), this.DUB);
    if (!((k)localObject).exists()) {
      ((k)localObject).mkdirs();
    }
    localObject = w.B(((k)localObject).fTh());
    AppMethodBeat.o(117794);
    return localObject;
  }
  
  public final String eQg()
  {
    AppMethodBeat.i(117795);
    if (TextUtils.isEmpty(this.DUD))
    {
      AppMethodBeat.o(117795);
      return "config.conf";
    }
    String str = this.DUD + "/config.conf";
    AppMethodBeat.o(117795);
    return str;
  }
  
  public final String eQi()
  {
    AppMethodBeat.i(117797);
    String str = eQf() + "/app.html";
    AppMethodBeat.o(117797);
    return str;
  }
  
  public final String eQj()
  {
    AppMethodBeat.i(188482);
    String str = eQf() + "/dist/build.js";
    AppMethodBeat.o(188482);
    return str;
  }
  
  public final String eQk()
  {
    AppMethodBeat.i(188483);
    if (bu.isNullOrNil(this.DUE)) {
      this.DUE = o.aRh(w.B(new k(eQj()).fTh()));
    }
    String str = this.DUE;
    AppMethodBeat.o(188483);
    return str;
  }
  
  /* Error */
  public final boolean eQl()
  {
    // Byte code:
    //   0: ldc_w 279
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 184	com/tencent/mm/plugin/websearch/api/ao:eQe	()Lcom/tencent/mm/vfs/k;
    //   10: invokestatic 239	com/tencent/mm/plugin/websearch/api/ad:T	(Lcom/tencent/mm/vfs/k;)Ljava/util/Properties;
    //   13: ldc_w 281
    //   16: invokevirtual 283	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_1
    //   20: aload_1
    //   21: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +11 -> 35
    //   27: ldc_w 279
    //   30: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: iconst_0
    //   34: ireturn
    //   35: new 285	org/json/JSONObject
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 286	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 290	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +188 -> 238
    //   53: aload_2
    //   54: invokeinterface 295 1 0
    //   59: ifeq +179 -> 238
    //   62: aload_2
    //   63: invokeinterface 299 1 0
    //   68: checkcast 301	java/lang/String
    //   71: astore_3
    //   72: new 40	com/tencent/mm/vfs/k
    //   75: dup
    //   76: aload_0
    //   77: invokevirtual 167	com/tencent/mm/plugin/websearch/api/ao:eQf	()Ljava/lang/String;
    //   80: aload_3
    //   81: invokespecial 169	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: astore 4
    //   86: aload 4
    //   88: invokevirtual 61	com/tencent/mm/vfs/k:exists	()Z
    //   91: ifne +34 -> 125
    //   94: ldc 86
    //   96: ldc_w 303
    //   99: iconst_1
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload 4
    //   107: invokevirtual 65	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   110: invokestatic 71	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   113: aastore
    //   114: invokestatic 306	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: ldc_w 279
    //   120: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: iconst_0
    //   124: ireturn
    //   125: aload 4
    //   127: invokevirtual 65	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   130: invokestatic 71	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   133: invokestatic 277	com/tencent/mm/vfs/o:aRh	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 4
    //   138: aload_1
    //   139: aload_3
    //   140: invokevirtual 309	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 5
    //   145: aload 4
    //   147: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +54 -> 204
    //   153: aload 4
    //   155: aload 5
    //   157: invokevirtual 313	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +44 -> 204
    //   163: aload_3
    //   164: ldc_w 315
    //   167: invokevirtual 313	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifeq -121 -> 49
    //   173: aload_0
    //   174: aload 4
    //   176: putfield 265	com/tencent/mm/plugin/websearch/api/ao:DUE	Ljava/lang/String;
    //   179: goto -130 -> 49
    //   182: astore_1
    //   183: ldc 86
    //   185: aload_1
    //   186: ldc_w 317
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 161	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: ldc_w 279
    //   199: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: iconst_0
    //   203: ireturn
    //   204: ldc 86
    //   206: ldc_w 319
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
    //   227: invokestatic 306	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: ldc_w 279
    //   233: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: iconst_0
    //   237: ireturn
    //   238: ldc_w 279
    //   241: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: iconst_1
    //   245: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	ao
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
  
  public final void eQm()
  {
    AppMethodBeat.i(117800);
    try
    {
      byte[] arrayOfByte = o.bb("assets:///" + eQh(), 0, -1);
      k localk = new k(ak.getContext().getCacheDir(), "websearch/temp.zip");
      if (localk.exists()) {
        localk.delete();
      }
      localk.fTg().mkdirs();
      o.f(w.B(localk.fTh()), arrayOfByte, arrayOfByte.length);
      aHo(w.B(localk.fTh()));
      AppMethodBeat.o(117800);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "initAssetTemplateToPath", new Object[0]);
      AppMethodBeat.o(117800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ao
 * JD-Core Version:    0.7.0.1
 */