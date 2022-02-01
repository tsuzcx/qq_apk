package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONObject;

public final class am
{
  private int AHp = 1;
  private long AHq;
  private String AHr;
  String AHs;
  private String AHt;
  
  public am(String paramString1, String paramString2, String paramString3)
  {
    this.AHr = paramString1;
    this.AHs = paramString2;
    this.AHt = paramString3;
  }
  
  public static int avj(String paramString)
  {
    AppMethodBeat.i(117802);
    localObject1 = new e(aj.getContext().getCacheDir(), "websearch/temp");
    if (((e)localObject1).exists()) {
      i.cO(q.B(((e)localObject1).fhU()), true);
    }
    ((e)localObject1).mkdirs();
    int i = i.fc(paramString, q.B(((e)localObject1).fhU()));
    if (i < 0)
    {
      ad.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + q.B(((e)localObject1).fhU()));
      AppMethodBeat.o(117802);
      return 1;
    }
    Object localObject3 = new e((e)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = i.ah((e)localObject3);
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
        ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getZipFileVersion %s", new Object[] { paramString });
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
  
  private e eik()
  {
    AppMethodBeat.i(117793);
    e locale = new e(eil(), "config.conf");
    AppMethodBeat.o(117793);
    return locale;
  }
  
  private String ein()
  {
    AppMethodBeat.i(117796);
    if (TextUtils.isEmpty(this.AHt))
    {
      AppMethodBeat.o(117796);
      return "config.conf";
    }
    String str = this.AHt + "/" + this.AHs;
    AppMethodBeat.o(117796);
    return str;
  }
  
  public final void avi(String paramString)
  {
    AppMethodBeat.i(117801);
    if (i.eK(eil())) {
      i.cO(eil(), true);
    }
    i.aMF(eil());
    e locale = new e(eil(), ".nomedia");
    if (!locale.exists()) {}
    try
    {
      locale.createNewFile();
      int i = i.fc(paramString, eil());
      if (i < 0)
      {
        ad.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + eil());
        AppMethodBeat.o(117801);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "create nomedia file error", new Object[0]);
      }
      eij();
      ad.i("MicroMsg.WebSearch.WebSearchTemplate", "Unzip Path=%s version=%d", new Object[] { eil(), Integer.valueOf(axp()) });
      AppMethodBeat.o(117801);
    }
  }
  
  public final int axp()
  {
    AppMethodBeat.i(117791);
    if ((this.AHp <= 1) || (eik().lastModified() > this.AHq)) {
      eij();
    }
    int i = this.AHp;
    AppMethodBeat.o(117791);
    return i;
  }
  
  public final int axq()
  {
    AppMethodBeat.i(117799);
    Object localObject4 = "assets:///" + eim();
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
        ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "getAssetH5Version", new Object[0]);
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
  
  public final void eij()
  {
    AppMethodBeat.i(117792);
    this.AHp = Integer.valueOf(aa.S(eik()).getProperty("version", "1")).intValue();
    this.AHq = System.currentTimeMillis();
    AppMethodBeat.o(117792);
  }
  
  public final String eil()
  {
    AppMethodBeat.i(117794);
    Object localObject = new e(b.aia(), this.AHr);
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    localObject = q.B(((e)localObject).fhU());
    AppMethodBeat.o(117794);
    return localObject;
  }
  
  public final String eim()
  {
    AppMethodBeat.i(117795);
    if (TextUtils.isEmpty(this.AHt))
    {
      AppMethodBeat.o(117795);
      return "config.conf";
    }
    String str = this.AHt + "/config.conf";
    AppMethodBeat.o(117795);
    return str;
  }
  
  public final String eio()
  {
    AppMethodBeat.i(117797);
    String str = eil() + "/app.html";
    AppMethodBeat.o(117797);
    return str;
  }
  
  public final boolean eip()
  {
    AppMethodBeat.i(117798);
    Object localObject1 = aa.S(eik()).getProperty("md5map");
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
        Object localObject2 = new e(eil(), str1);
        if (!((e)localObject2).exists())
        {
          ad.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, file not exist %s", new Object[] { q.B(((e)localObject2).fhU()) });
          AppMethodBeat.o(117798);
          return false;
        }
        localObject2 = i.aEN(q.B(((e)localObject2).fhU()));
        String str2 = ((JSONObject)localObject1).getString(str1);
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(str2)))
        {
          ad.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, fileName %s, fileMd5 %s, expect md5 %s", new Object[] { str1, localObject2, str2 });
          AppMethodBeat.o(117798);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "", new Object[0]);
      AppMethodBeat.o(117798);
      return false;
    }
    AppMethodBeat.o(117798);
    return true;
  }
  
  public final void eiq()
  {
    AppMethodBeat.i(117800);
    try
    {
      byte[] arrayOfByte = i.aR("assets:///" + ein(), 0, -1);
      e locale = new e(aj.getContext().getCacheDir(), "websearch/temp.zip");
      if (locale.exists()) {
        locale.delete();
      }
      locale.fhT().mkdirs();
      i.f(q.B(locale.fhU()), arrayOfByte, arrayOfByte.length);
      avi(q.B(locale.fhU()));
      AppMethodBeat.o(117800);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localException, "initAssetTemplateToPath", new Object[0]);
      AppMethodBeat.o(117800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.am
 * JD-Core Version:    0.7.0.1
 */