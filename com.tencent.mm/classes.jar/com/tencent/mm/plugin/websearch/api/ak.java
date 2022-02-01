package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONObject;

public final class ak
{
  private int BZG = 1;
  private long BZH;
  private String BZI;
  String BZJ;
  private String BZK;
  
  public ak(String paramString1, String paramString2, String paramString3)
  {
    this.BZI = paramString1;
    this.BZJ = paramString2;
    this.BZK = paramString3;
  }
  
  public static int aAB(String paramString)
  {
    AppMethodBeat.i(117802);
    localObject1 = new e(ai.getContext().getCacheDir(), "websearch/temp");
    if (((e)localObject1).exists()) {
      i.cU(q.B(((e)localObject1).fxV()), true);
    }
    ((e)localObject1).mkdirs();
    int i = i.fp(paramString, q.B(((e)localObject1).fxV()));
    if (i < 0)
    {
      ac.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + q.B(((e)localObject1).fxV()));
      AppMethodBeat.o(117802);
      return 1;
    }
    Object localObject3 = new e((e)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = i.ag((e)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      localProperties.load((InputStream)localObject3);
      q.closeQuietly((Closeable)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getZipFileVersion %s", new Object[] { paramString });
        q.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      q.closeQuietly(localObject2);
      AppMethodBeat.o(117802);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    AppMethodBeat.o(117802);
    return i;
  }
  
  private e exE()
  {
    AppMethodBeat.i(117793);
    e locale = new e(exF(), "config.conf");
    AppMethodBeat.o(117793);
    return locale;
  }
  
  private String exH()
  {
    AppMethodBeat.i(117796);
    if (TextUtils.isEmpty(this.BZK))
    {
      AppMethodBeat.o(117796);
      return "config.conf";
    }
    String str = this.BZK + "/" + this.BZJ;
    AppMethodBeat.o(117796);
    return str;
  }
  
  public final void aAA(String paramString)
  {
    AppMethodBeat.i(117801);
    if (i.eA(exF())) {
      i.cU(exF(), true);
    }
    i.aSh(exF());
    e locale = new e(exF(), ".nomedia");
    if (!locale.exists()) {}
    try
    {
      locale.createNewFile();
      int i = i.fp(paramString, exF());
      if (i < 0)
      {
        ac.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + exF());
        AppMethodBeat.o(117801);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "create nomedia file error", new Object[0]);
      }
      exD();
      ac.i("MicroMsg.WebSearch.WebSearchTemplate", "Unzip Path=%s version=%d", new Object[] { exF(), Integer.valueOf(aEh()) });
      AppMethodBeat.o(117801);
    }
  }
  
  public final int aEh()
  {
    AppMethodBeat.i(117791);
    if ((this.BZG <= 1) || (exE().lastModified() > this.BZH)) {
      exD();
    }
    int i = this.BZG;
    AppMethodBeat.o(117791);
    return i;
  }
  
  public final int aEi()
  {
    AppMethodBeat.i(117799);
    Object localObject4 = "assets:///" + exG();
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = i.openRead((String)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      q.closeQuietly((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getAssetH5Version", new Object[0]);
        q.closeQuietly(localObject1);
      }
    }
    finally
    {
      q.closeQuietly(localObject3);
      AppMethodBeat.o(117799);
    }
    i = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    AppMethodBeat.o(117799);
    return i;
  }
  
  public final void exD()
  {
    AppMethodBeat.i(117792);
    this.BZG = Integer.valueOf(z.R(exE()).getProperty("version", "1")).intValue();
    this.BZH = System.currentTimeMillis();
    AppMethodBeat.o(117792);
  }
  
  public final String exF()
  {
    AppMethodBeat.i(117794);
    Object localObject = new e(b.apa(), this.BZI);
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    localObject = q.B(((e)localObject).fxV());
    AppMethodBeat.o(117794);
    return localObject;
  }
  
  public final String exG()
  {
    AppMethodBeat.i(117795);
    if (TextUtils.isEmpty(this.BZK))
    {
      AppMethodBeat.o(117795);
      return "config.conf";
    }
    String str = this.BZK + "/config.conf";
    AppMethodBeat.o(117795);
    return str;
  }
  
  public final String exI()
  {
    AppMethodBeat.i(117797);
    String str = exF() + "/app.html";
    AppMethodBeat.o(117797);
    return str;
  }
  
  public final boolean exJ()
  {
    AppMethodBeat.i(117798);
    Object localObject1 = z.R(exE()).getProperty("md5map");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(117798);
      return false;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      Iterator localIterator = ((JSONObject)localObject1).keys();
      while ((localIterator != null) && (localIterator.hasNext()))
      {
        String str1 = (String)localIterator.next();
        Object localObject2 = new e(exF(), str1);
        if (!((e)localObject2).exists())
        {
          ac.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, file not exist %s", new Object[] { q.B(((e)localObject2).fxV()) });
          AppMethodBeat.o(117798);
          return false;
        }
        localObject2 = i.aKe(q.B(((e)localObject2).fxV()));
        String str2 = ((JSONObject)localObject1).getString(str1);
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(str2)))
        {
          ac.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, fileName %s, fileMd5 %s, expect md5 %s", new Object[] { str1, localObject2, str2 });
          AppMethodBeat.o(117798);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "", new Object[0]);
      AppMethodBeat.o(117798);
      return false;
    }
    AppMethodBeat.o(117798);
    return true;
  }
  
  public final void exK()
  {
    AppMethodBeat.i(117800);
    try
    {
      byte[] arrayOfByte = i.aU("assets:///" + exH(), 0, -1);
      e locale = new e(ai.getContext().getCacheDir(), "websearch/temp.zip");
      if (locale.exists()) {
        locale.delete();
      }
      locale.fxU().mkdirs();
      i.f(q.B(locale.fxV()), arrayOfByte, arrayOfByte.length);
      aAA(q.B(locale.fxV()));
      AppMethodBeat.o(117800);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "initAssetTemplateToPath", new Object[0]);
      AppMethodBeat.o(117800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak
 * JD-Core Version:    0.7.0.1
 */