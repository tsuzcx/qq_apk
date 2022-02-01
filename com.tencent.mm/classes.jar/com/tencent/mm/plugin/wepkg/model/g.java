package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.WebResourceResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class g
  extends b
{
  public WepkgVersion EET;
  public f EFd;
  private Map<String, WepkgPreloadFile> EFe;
  private String charset;
  
  public g(int paramInt, boolean paramBoolean, String paramString)
  {
    super(paramInt, paramBoolean, paramString);
    this.charset = "UTF-8";
  }
  
  public g(WepkgVersion paramWepkgVersion, f paramf, Map<String, WepkgPreloadFile> paramMap)
  {
    super(0, true, paramWepkgVersion.version);
    AppMethodBeat.i(110705);
    this.charset = "UTF-8";
    this.EET = paramWepkgVersion;
    this.EFd = paramf;
    this.EFe = paramMap;
    if ((paramWepkgVersion != null) && (!bt.isNullOrNil(paramWepkgVersion.charset))) {
      this.charset = paramWepkgVersion.charset;
    }
    AppMethodBeat.o(110705);
  }
  
  public final WebResourceResponse aKM(String paramString)
  {
    AppMethodBeat.i(110707);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110707);
      return null;
    }
    if ((this.EFe != null) && (this.EFe.get(paramString) != null))
    {
      Object localObject1 = (WepkgPreloadFile)this.EFe.get(paramString);
      if (!bt.isNullOrNil(((WepkgPreloadFile)localObject1).filePath))
      {
        Object localObject2 = new e(((WepkgPreloadFile)localObject1).filePath);
        if ((((e)localObject2).exists()) && (((e)localObject2).isFile()) && (((e)localObject2).length() == ((WepkgPreloadFile)localObject1).size)) {
          try
          {
            ad.i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s, localPath:%s", new Object[] { paramString, ((WepkgPreloadFile)localObject1).filePath });
            localObject2 = i.ai((e)localObject2);
            localObject1 = new WebResourceResponse(((WepkgPreloadFile)localObject1).mimeType, this.charset, (InputStream)localObject2);
            AppMethodBeat.o(110707);
            return localObject1;
          }
          catch (FileNotFoundException localFileNotFoundException) {}
        }
      }
    }
    if (this.EFd != null)
    {
      paramString = this.EFd.ln(paramString, this.charset);
      AppMethodBeat.o(110707);
      return paramString;
    }
    AppMethodBeat.o(110707);
    return null;
  }
  
  public final boolean aKO(String paramString)
  {
    AppMethodBeat.i(110706);
    paramString = aKM(d.aLa(paramString));
    if (paramString != null)
    {
      paramString = paramString.mInputStream;
      if (paramString == null) {}
    }
    try
    {
      paramString.close();
      label31:
      AppMethodBeat.o(110706);
      return true;
      AppMethodBeat.o(110706);
      return false;
    }
    catch (IOException paramString)
    {
      break label31;
    }
  }
  
  public final String acz(String paramString)
  {
    AppMethodBeat.i(110708);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110708);
      return null;
    }
    if ((this.EFe != null) && (this.EFe.get(paramString) != null))
    {
      paramString = (WepkgPreloadFile)this.EFe.get(paramString);
      if (!bt.isNullOrNil(paramString.filePath))
      {
        e locale = new e(paramString.filePath);
        if ((locale.exists()) && (locale.isFile()) && (locale.length() == paramString.size))
        {
          paramString = paramString.filePath;
          AppMethodBeat.o(110708);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(110708);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.g
 * JD-Core Version:    0.7.0.1
 */