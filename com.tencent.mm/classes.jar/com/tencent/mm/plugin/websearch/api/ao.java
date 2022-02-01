package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONObject;

public final class ao
{
  private int DCC = 1;
  private long DCD;
  private String DCE;
  String DCF;
  private String DCG;
  
  public ao(String paramString1, String paramString2, String paramString3)
  {
    this.DCE = paramString1;
    this.DCF = paramString2;
    this.DCG = paramString3;
  }
  
  public static int aFV(String paramString)
  {
    AppMethodBeat.i(117802);
    localObject1 = new e(aj.getContext().getCacheDir(), "websearch/temp");
    if (((e)localObject1).exists()) {
      i.cZ(q.B(((e)localObject1).fOK()), true);
    }
    ((e)localObject1).mkdirs();
    int i = i.fz(paramString, q.B(((e)localObject1).fOK()));
    if (i < 0)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + q.B(((e)localObject1).fOK()));
      AppMethodBeat.o(117802);
      return 1;
    }
    Object localObject3 = new e((e)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = i.ai((e)localObject3);
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
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getZipFileVersion %s", new Object[] { paramString });
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
  
  private e eMv()
  {
    AppMethodBeat.i(117793);
    e locale = new e(eMw(), "config.conf");
    AppMethodBeat.o(117793);
    return locale;
  }
  
  private String eMy()
  {
    AppMethodBeat.i(117796);
    if (TextUtils.isEmpty(this.DCG))
    {
      AppMethodBeat.o(117796);
      return "config.conf";
    }
    String str = this.DCG + "/" + this.DCF;
    AppMethodBeat.o(117796);
    return str;
  }
  
  public final void aFU(String paramString)
  {
    AppMethodBeat.i(117801);
    if (i.fv(eMw())) {
      i.cZ(eMw(), true);
    }
    i.aYg(eMw());
    e locale = new e(eMw(), ".nomedia");
    if (!locale.exists()) {}
    try
    {
      locale.createNewFile();
      int i = i.fz(paramString, eMw());
      if (i < 0)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + eMw());
        AppMethodBeat.o(117801);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "create nomedia file error", new Object[0]);
      }
      eMu();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchTemplate", "Unzip Path=%s version=%d", new Object[] { eMw(), Integer.valueOf(aHm()) });
      AppMethodBeat.o(117801);
    }
  }
  
  public final int aHm()
  {
    AppMethodBeat.i(117791);
    if ((this.DCC <= 1) || (eMv().lastModified() > this.DCD)) {
      eMu();
    }
    int i = this.DCC;
    AppMethodBeat.o(117791);
    return i;
  }
  
  public final int aHn()
  {
    AppMethodBeat.i(117799);
    Object localObject4 = "assets:///" + eMx();
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
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getAssetH5Version", new Object[0]);
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
  
  public final boolean eMA()
  {
    AppMethodBeat.i(117798);
    Object localObject1 = ad.T(eMv()).getProperty("md5map");
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
        Object localObject2 = new e(eMw(), str1);
        if (!((e)localObject2).exists())
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, file not exist %s", new Object[] { q.B(((e)localObject2).fOK()) });
          AppMethodBeat.o(117798);
          return false;
        }
        localObject2 = i.aPK(q.B(((e)localObject2).fOK()));
        String str2 = ((JSONObject)localObject1).getString(str1);
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(str2)))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, fileName %s, fileMd5 %s, expect md5 %s", new Object[] { str1, localObject2, str2 });
          AppMethodBeat.o(117798);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "", new Object[0]);
      AppMethodBeat.o(117798);
      return false;
    }
    AppMethodBeat.o(117798);
    return true;
  }
  
  public final void eMB()
  {
    AppMethodBeat.i(117800);
    try
    {
      byte[] arrayOfByte = i.aY("assets:///" + eMy(), 0, -1);
      e locale = new e(aj.getContext().getCacheDir(), "websearch/temp.zip");
      if (locale.exists()) {
        locale.delete();
      }
      locale.fOJ().mkdirs();
      i.f(q.B(locale.fOK()), arrayOfByte, arrayOfByte.length);
      aFU(q.B(locale.fOK()));
      AppMethodBeat.o(117800);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "initAssetTemplateToPath", new Object[0]);
      AppMethodBeat.o(117800);
    }
  }
  
  public final void eMu()
  {
    AppMethodBeat.i(117792);
    this.DCC = Integer.valueOf(ad.T(eMv()).getProperty("version", "1")).intValue();
    this.DCD = System.currentTimeMillis();
    AppMethodBeat.o(117792);
  }
  
  public final String eMw()
  {
    AppMethodBeat.i(117794);
    Object localObject = new e(b.arN(), this.DCE);
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    localObject = q.B(((e)localObject).fOK());
    AppMethodBeat.o(117794);
    return localObject;
  }
  
  public final String eMx()
  {
    AppMethodBeat.i(117795);
    if (TextUtils.isEmpty(this.DCG))
    {
      AppMethodBeat.o(117795);
      return "config.conf";
    }
    String str = this.DCG + "/config.conf";
    AppMethodBeat.o(117795);
    return str;
  }
  
  public final String eMz()
  {
    AppMethodBeat.i(117797);
    String str = eMw() + "/app.html";
    AppMethodBeat.o(117797);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ao
 * JD-Core Version:    0.7.0.1
 */