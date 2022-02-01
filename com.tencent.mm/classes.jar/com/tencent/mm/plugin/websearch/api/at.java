package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ad;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Properties;

public final class at
{
  private int PzM = 1;
  private long PzN;
  private String PzO;
  String PzP;
  private String PzQ;
  private String PzR;
  
  public at(String paramString1, String paramString2, String paramString3)
  {
    this.PzO = paramString1;
    this.PzP = paramString2;
    this.PzQ = paramString3;
  }
  
  public static int biV(String paramString)
  {
    AppMethodBeat.i(117802);
    localObject1 = new q(MMApplicationContext.getContext().getCacheDir(), "websearch/temp");
    if (((q)localObject1).ifE()) {
      u.deleteDir(((q)localObject1).bOF());
    }
    ((q)localObject1).ifL();
    int i = u.gj(paramString, ((q)localObject1).bOF());
    if (i < 0)
    {
      Log.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + ((q)localObject1).bOF());
      AppMethodBeat.o(117802);
      return 1;
    }
    Object localObject3 = new q((q)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = u.al((q)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      localProperties.load((InputStream)localObject3);
      ad.closeQuietly((Closeable)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getZipFileVersion %s", new Object[] { paramString });
        ad.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      ad.closeQuietly(localObject2);
      AppMethodBeat.o(117802);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    AppMethodBeat.o(117802);
    return i;
  }
  
  private q gRc()
  {
    AppMethodBeat.i(117793);
    q localq = new q(gRd(), "config.conf");
    AppMethodBeat.o(117793);
    return localq;
  }
  
  private String gRf()
  {
    AppMethodBeat.i(117796);
    if (TextUtils.isEmpty(this.PzQ))
    {
      AppMethodBeat.o(117796);
      return "config.conf";
    }
    String str = this.PzQ + "/" + this.PzP;
    AppMethodBeat.o(117796);
    return str;
  }
  
  public static String gRj()
  {
    return "app.html";
  }
  
  public final void biU(String paramString)
  {
    AppMethodBeat.i(117801);
    if (u.agG(gRd())) {
      u.deleteDir(gRd());
    }
    u.bBD(gRd());
    q localq = new q(gRd(), ".nomedia");
    if (!localq.ifE()) {}
    try
    {
      localq.ifM();
      int i = u.gj(paramString, gRd());
      if (i < 0)
      {
        Log.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + gRd());
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
      gRb();
      Log.i("MicroMsg.WebSearch.WebSearchTemplate", "Unzip Path=%s version=%d", new Object[] { gRd(), Integer.valueOf(bkM()) });
      AppMethodBeat.o(117801);
    }
  }
  
  public final int bkM()
  {
    AppMethodBeat.i(117791);
    if ((this.PzM <= 1) || (gRc().lastModified() > this.PzN)) {
      gRb();
    }
    int i = this.PzM;
    AppMethodBeat.o(117791);
    return i;
  }
  
  public final int bkN()
  {
    AppMethodBeat.i(117799);
    Object localObject4 = "assets:///" + gRe();
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = u.Tf((String)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      ad.closeQuietly((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getAssetH5Version", new Object[0]);
        ad.closeQuietly(localObject1);
      }
    }
    finally
    {
      ad.closeQuietly(localObject3);
      AppMethodBeat.o(117799);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    AppMethodBeat.o(117799);
    return i;
  }
  
  public final void gRb()
  {
    AppMethodBeat.i(117792);
    this.PzM = Integer.valueOf(ai.X(gRc()).getProperty("version", "1")).intValue();
    this.PzN = System.currentTimeMillis();
    AppMethodBeat.o(117792);
  }
  
  public final String gRd()
  {
    AppMethodBeat.i(117794);
    Object localObject = new q(b.aSE(), this.PzO);
    if (!((q)localObject).ifE()) {
      ((q)localObject).ifL();
    }
    localObject = ((q)localObject).bOF();
    AppMethodBeat.o(117794);
    return localObject;
  }
  
  public final String gRe()
  {
    AppMethodBeat.i(117795);
    if (TextUtils.isEmpty(this.PzQ))
    {
      AppMethodBeat.o(117795);
      return "config.conf";
    }
    String str = this.PzQ + "/config.conf";
    AppMethodBeat.o(117795);
    return str;
  }
  
  public final String gRg()
  {
    AppMethodBeat.i(117797);
    String str = gRd() + "/app.html";
    AppMethodBeat.o(117797);
    return str;
  }
  
  public final String gRh()
  {
    AppMethodBeat.i(211711);
    String str = gRd() + "/dist/build.js";
    AppMethodBeat.o(211711);
    return str;
  }
  
  public final String gRi()
  {
    AppMethodBeat.i(211713);
    if (Util.isNullOrNil(this.PzR)) {
      this.PzR = u.buc(new q(gRh()).bOF());
    }
    String str = this.PzR;
    AppMethodBeat.o(211713);
    return str;
  }
  
  /* Error */
  public final boolean gRk()
  {
    // Byte code:
    //   0: ldc_w 276
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 210	com/tencent/mm/plugin/websearch/api/at:gRc	()Lcom/tencent/mm/vfs/q;
    //   10: invokestatic 236	com/tencent/mm/plugin/websearch/api/ai:X	(Lcom/tencent/mm/vfs/q;)Ljava/util/Properties;
    //   13: ldc_w 278
    //   16: invokevirtual 280	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_1
    //   20: aload_1
    //   21: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +11 -> 35
    //   27: ldc_w 276
    //   30: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: iconst_0
    //   34: ireturn
    //   35: new 282	org/json/JSONObject
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 283	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 287	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +182 -> 232
    //   53: aload_2
    //   54: invokeinterface 292 1 0
    //   59: ifeq +173 -> 232
    //   62: aload_2
    //   63: invokeinterface 296 1 0
    //   68: checkcast 298	java/lang/String
    //   71: astore_3
    //   72: new 40	com/tencent/mm/vfs/q
    //   75: dup
    //   76: aload_0
    //   77: invokevirtual 162	com/tencent/mm/plugin/websearch/api/at:gRd	()Ljava/lang/String;
    //   80: aload_3
    //   81: invokespecial 164	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: astore 4
    //   86: aload 4
    //   88: invokevirtual 61	com/tencent/mm/vfs/q:ifE	()Z
    //   91: ifne +31 -> 122
    //   94: ldc 80
    //   96: ldc_w 300
    //   99: iconst_1
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload 4
    //   107: invokevirtual 65	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   110: aastore
    //   111: invokestatic 303	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: ldc_w 276
    //   117: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iconst_0
    //   121: ireturn
    //   122: aload 4
    //   124: invokevirtual 65	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   127: invokestatic 274	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 4
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 306	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   137: astore 5
    //   139: aload 4
    //   141: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +54 -> 198
    //   147: aload 4
    //   149: aload 5
    //   151: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifeq +44 -> 198
    //   157: aload_3
    //   158: ldc_w 312
    //   161: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq -115 -> 49
    //   167: aload_0
    //   168: aload 4
    //   170: putfield 262	com/tencent/mm/plugin/websearch/api/at:PzR	Ljava/lang/String;
    //   173: goto -124 -> 49
    //   176: astore_1
    //   177: ldc 80
    //   179: aload_1
    //   180: ldc_w 314
    //   183: iconst_0
    //   184: anewarray 4	java/lang/Object
    //   187: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: ldc_w 276
    //   193: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: iconst_0
    //   197: ireturn
    //   198: ldc 80
    //   200: ldc_w 316
    //   203: iconst_3
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload_3
    //   210: aastore
    //   211: dup
    //   212: iconst_1
    //   213: aload 4
    //   215: aastore
    //   216: dup
    //   217: iconst_2
    //   218: aload 5
    //   220: aastore
    //   221: invokestatic 303	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: ldc_w 276
    //   227: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: iconst_0
    //   231: ireturn
    //   232: ldc_w 276
    //   235: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: iconst_1
    //   239: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	at
    //   19	114	1	localObject1	Object
    //   176	4	1	localException	Exception
    //   48	15	2	localIterator	java.util.Iterator
    //   71	139	3	str1	String
    //   84	130	4	localObject2	Object
    //   137	82	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   35	49	176	java/lang/Exception
    //   53	114	176	java/lang/Exception
    //   122	173	176	java/lang/Exception
    //   198	224	176	java/lang/Exception
  }
  
  public final void gRl()
  {
    AppMethodBeat.i(117800);
    try
    {
      byte[] arrayOfByte = u.aY("assets:///" + gRf(), 0, -1);
      q localq = new q(MMApplicationContext.getContext().getCacheDir(), "websearch/temp.zip");
      if (localq.ifE()) {
        localq.cFq();
      }
      localq.ifB().ifL();
      u.H(localq.bOF(), arrayOfByte);
      biU(localq.bOF());
      AppMethodBeat.o(117800);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "initAssetTemplateToPath", new Object[0]);
      AppMethodBeat.o(117800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.at
 * JD-Core Version:    0.7.0.1
 */