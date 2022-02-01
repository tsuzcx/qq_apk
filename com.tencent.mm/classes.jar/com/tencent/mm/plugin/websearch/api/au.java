package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONObject;

public final class au
{
  private int Wqa;
  private long Wqb;
  private String Wqc;
  String Wqd;
  private String Wqe;
  public long Wqf;
  private HashMap<Integer, HashMap<String, String>> Wqg;
  
  public au(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(315338);
    this.Wqa = 1;
    this.Wqf = -1L;
    this.Wqg = new HashMap();
    this.Wqc = paramString1;
    this.Wqd = paramString2;
    this.Wqe = paramString3;
    this.Wqf = paramLong;
    AppMethodBeat.o(315338);
  }
  
  public static int biD(String paramString)
  {
    AppMethodBeat.i(117802);
    Object localObject1 = new u(MMApplicationContext.getContext().getCacheDir(), "websearch/temp");
    if (((u)localObject1).jKS()) {
      y.ew(ah.v(((u)localObject1).jKT()), true);
    }
    ((u)localObject1).jKY();
    int i = y.aA(paramString, ah.v(((u)localObject1).jKT()));
    if (i < 0)
    {
      Log.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + ah.v(((u)localObject1).jKT()));
      AppMethodBeat.o(117802);
      return 1;
    }
    Object localObject3 = new u((u)localObject1, "config.conf");
    Properties localProperties = new Properties();
    Object localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = y.ao((u)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      localProperties.load((InputStream)localObject3);
      ah.closeQuietly((Closeable)localObject3);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException = localException;
        localObject2 = localObject1;
        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getZipFileVersion %s", new Object[] { paramString });
        ah.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      ah.closeQuietly(localObject2);
      AppMethodBeat.o(117802);
    }
  }
  
  private String iqr()
  {
    AppMethodBeat.i(117796);
    if (TextUtils.isEmpty(this.Wqe))
    {
      AppMethodBeat.o(117796);
      return "config.conf";
    }
    String str = this.Wqe + "/" + this.Wqd;
    AppMethodBeat.o(117796);
    return str;
  }
  
  public final int bIG()
  {
    AppMethodBeat.i(117791);
    if ((this.Wqa <= 1) || (iqo().lastModified() > this.Wqb)) {
      iqn();
    }
    int i = this.Wqa;
    AppMethodBeat.o(117791);
    return i;
  }
  
  /* Error */
  public final int bIH()
  {
    // Byte code:
    //   0: ldc 198
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 104	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 200
    //   11: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 203	com/tencent/mm/plugin/websearch/api/au:iqq	()Ljava/lang/String;
    //   18: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore 4
    //   26: new 137	java/util/Properties
    //   29: dup
    //   30: invokespecial 138	java/util/Properties:<init>	()V
    //   33: astore 5
    //   35: aconst_null
    //   36: astore_3
    //   37: aconst_null
    //   38: astore_2
    //   39: aload 4
    //   41: invokestatic 207	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   44: astore 4
    //   46: aload 4
    //   48: astore_2
    //   49: aload 4
    //   51: astore_3
    //   52: aload 5
    //   54: aload 4
    //   56: invokevirtual 146	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   59: aload 4
    //   61: invokestatic 150	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   64: aload 5
    //   66: ldc 152
    //   68: ldc 154
    //   70: invokevirtual 158	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: invokestatic 163	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   76: istore_1
    //   77: ldc 198
    //   79: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: iload_1
    //   83: ireturn
    //   84: astore 4
    //   86: aload_2
    //   87: astore_3
    //   88: ldc 102
    //   90: aload 4
    //   92: ldc 209
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_2
    //   102: invokestatic 150	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   105: goto -41 -> 64
    //   108: astore_2
    //   109: aload_3
    //   110: invokestatic 150	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   113: ldc 198
    //   115: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_2
    //   119: athrow
    //   120: astore_2
    //   121: ldc 198
    //   123: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iconst_1
    //   127: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	au
    //   76	7	1	i	int
    //   38	64	2	localObject1	Object
    //   108	11	2	localObject2	Object
    //   120	1	2	localException1	Exception
    //   36	74	3	localObject3	Object
    //   24	36	4	localObject4	Object
    //   84	7	4	localException2	Exception
    //   33	32	5	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   39	46	84	java/lang/Exception
    //   52	59	84	java/lang/Exception
    //   39	46	108	finally
    //   52	59	108	finally
    //   88	101	108	finally
    //   64	77	120	java/lang/Exception
  }
  
  public final void biC(String paramString)
  {
    AppMethodBeat.i(117801);
    if (y.ZC(iqp())) {
      y.ew(iqp(), true);
    }
    y.bDX(iqp());
    u localu = new u(iqp(), ".nomedia");
    if (!localu.jKS()) {}
    try
    {
      localu.jKZ();
      int i = y.aA(paramString, iqp());
      if (i < 0)
      {
        Log.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + iqp());
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
      iqn();
      Log.i("MicroMsg.WebSearch.WebSearchTemplate", "Unzip Path=%s version=%d", new Object[] { iqp(), Integer.valueOf(bIG()) });
      AppMethodBeat.o(117801);
    }
  }
  
  public final void iqn()
  {
    AppMethodBeat.i(117792);
    Properties localProperties = aj.Z(iqo());
    try
    {
      this.Wqa = Integer.parseInt(localProperties.getProperty("version", "1"));
      this.Wqb = System.currentTimeMillis();
      AppMethodBeat.o(117792);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.Wqa = 1;
      }
    }
  }
  
  final u iqo()
  {
    AppMethodBeat.i(117793);
    u localu = new u(iqp(), "config.conf");
    AppMethodBeat.o(117793);
    return localu;
  }
  
  public final String iqp()
  {
    AppMethodBeat.i(117794);
    Object localObject = new u(b.bms(), this.Wqc);
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    localObject = ah.v(((u)localObject).jKT());
    AppMethodBeat.o(117794);
    return localObject;
  }
  
  public final String iqq()
  {
    AppMethodBeat.i(117795);
    if (TextUtils.isEmpty(this.Wqe))
    {
      AppMethodBeat.o(117795);
      return "config.conf";
    }
    String str = this.Wqe + "/config.conf";
    AppMethodBeat.o(117795);
    return str;
  }
  
  public final String iqs()
  {
    AppMethodBeat.i(117797);
    String str = iqp() + "/app.html";
    AppMethodBeat.o(117797);
    return str;
  }
  
  public final HashMap<String, String> iqt()
  {
    AppMethodBeat.i(315383);
    int i = bIG();
    if (!this.Wqg.containsKey(Integer.valueOf(i))) {
      this.Wqg.put(Integer.valueOf(i), new HashMap());
    }
    HashMap localHashMap = (HashMap)this.Wqg.get(Integer.valueOf(i));
    if (localHashMap.isEmpty()) {
      try
      {
        JSONObject localJSONObject = new JSONObject(aj.Z(iqo()).getProperty("md5map"));
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          if (str2.endsWith(".js"))
          {
            String str1 = iqp() + "/" + str2;
            if (y.ZC(str1))
            {
              str2 = localJSONObject.optString(str2, "");
              localHashMap.put(str1, str2);
              Log.i("MicroMsg.WebSearch.WebSearchTemplate", "getJsFileMap %s %s %s", new Object[] { Integer.valueOf(i), str1, str2 });
              continue;
              AppMethodBeat.o(315383);
            }
          }
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "", new Object[0]);
      }
    }
    for (;;)
    {
      return localHashMap;
      this.Wqg.put(Integer.valueOf(i), localHashMap);
    }
  }
  
  public final boolean iqu()
  {
    AppMethodBeat.i(117798);
    Object localObject1 = aj.Z(iqo()).getProperty("md5map");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(117798);
      return false;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      Iterator localIterator = ((JSONObject)localObject1).keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        Object localObject2 = new u(iqp(), str1);
        if (!((u)localObject2).jKS())
        {
          Log.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, file not exist %s", new Object[] { ah.v(((u)localObject2).jKT()) });
          AppMethodBeat.o(117798);
          return false;
        }
        localObject2 = y.bub(ah.v(((u)localObject2).jKT()));
        String str2 = ((JSONObject)localObject1).getString(str1);
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(str2)))
        {
          Log.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, fileName %s, fileMd5 %s, expect md5 %s", new Object[] { str1, localObject2, str2 });
          AppMethodBeat.o(117798);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "", new Object[0]);
      AppMethodBeat.o(117798);
      return false;
    }
    AppMethodBeat.o(117798);
    return true;
  }
  
  public final void iqv()
  {
    AppMethodBeat.i(117800);
    try
    {
      byte[] arrayOfByte = y.bi("assets:///" + iqr(), 0, -1);
      u localu = new u(MMApplicationContext.getContext().getCacheDir(), "websearch/temp.zip");
      if (localu.jKS()) {
        localu.diJ();
      }
      localu.jKP().jKY();
      y.f(ah.v(localu.jKT()), arrayOfByte, arrayOfByte.length);
      biC(ah.v(localu.jKT()));
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
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.au
 * JD-Core Version:    0.7.0.1
 */