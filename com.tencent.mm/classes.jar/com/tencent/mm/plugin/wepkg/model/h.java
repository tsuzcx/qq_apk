package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebResourceResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class h
  extends b
{
  public WepkgVersion XFY;
  public g XGi;
  private Map<String, WepkgPreloadFile> XGj;
  private String charset;
  
  public h(int paramInt, boolean paramBoolean, String paramString)
  {
    super(paramInt, paramBoolean, paramString);
    this.charset = "UTF-8";
  }
  
  public h(WepkgVersion paramWepkgVersion, g paramg, Map<String, WepkgPreloadFile> paramMap)
  {
    super(0, true, paramWepkgVersion.version);
    AppMethodBeat.i(110705);
    this.charset = "UTF-8";
    this.XFY = paramWepkgVersion;
    this.XGi = paramg;
    this.XGj = paramMap;
    if ((paramWepkgVersion != null) && (!Util.isNullOrNil(paramWepkgVersion.charset))) {
      this.charset = paramWepkgVersion.charset;
    }
    AppMethodBeat.o(110705);
  }
  
  public final String apy(String paramString)
  {
    AppMethodBeat.i(110708);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110708);
      return null;
    }
    if ((this.XGj != null) && (this.XGj.get(paramString) != null))
    {
      paramString = (WepkgPreloadFile)this.XGj.get(paramString);
      if (!Util.isNullOrNil(paramString.filePath))
      {
        u localu = new u(paramString.filePath);
        if ((localu.jKS()) && (localu.jKV()) && (localu.length() == paramString.size))
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
  
  public final WebResourceResponse bop(String paramString)
  {
    AppMethodBeat.i(110707);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110707);
      return null;
    }
    if ((this.XGj != null) && (this.XGj.get(paramString) != null))
    {
      Object localObject1 = (WepkgPreloadFile)this.XGj.get(paramString);
      if (!Util.isNullOrNil(((WepkgPreloadFile)localObject1).filePath))
      {
        Object localObject2 = new u(((WepkgPreloadFile)localObject1).filePath);
        if ((((u)localObject2).jKS()) && (((u)localObject2).jKV()) && (((u)localObject2).length() == ((WepkgPreloadFile)localObject1).size)) {
          try
          {
            Log.i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s, localPath:%s", new Object[] { paramString, ((WepkgPreloadFile)localObject1).filePath });
            localObject2 = y.ao((u)localObject2);
            localObject1 = new WebResourceResponse(((WepkgPreloadFile)localObject1).mimeType, this.charset, (InputStream)localObject2);
            AppMethodBeat.o(110707);
            return localObject1;
          }
          catch (FileNotFoundException localFileNotFoundException) {}
        }
      }
    }
    if (this.XGi != null)
    {
      paramString = this.XGi.oL(paramString, this.charset);
      AppMethodBeat.o(110707);
      return paramString;
    }
    AppMethodBeat.o(110707);
    return null;
  }
  
  public final boolean bor(String paramString)
  {
    AppMethodBeat.i(110706);
    paramString = bop(d.boD(paramString));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h
 * JD-Core Version:    0.7.0.1
 */