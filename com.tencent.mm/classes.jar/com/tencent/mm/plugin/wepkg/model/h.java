package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebResourceResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class h
  extends b
{
  public WepkgVersion JNh;
  public g JNr;
  private Map<String, WepkgPreloadFile> JNs;
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
    this.JNh = paramWepkgVersion;
    this.JNr = paramg;
    this.JNs = paramMap;
    if ((paramWepkgVersion != null) && (!Util.isNullOrNil(paramWepkgVersion.charset))) {
      this.charset = paramWepkgVersion.charset;
    }
    AppMethodBeat.o(110705);
  }
  
  public final String anz(String paramString)
  {
    AppMethodBeat.i(110708);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110708);
      return null;
    }
    if ((this.JNs != null) && (this.JNs.get(paramString) != null))
    {
      paramString = (WepkgPreloadFile)this.JNs.get(paramString);
      if (!Util.isNullOrNil(paramString.filePath))
      {
        o localo = new o(paramString.filePath);
        if ((localo.exists()) && (localo.isFile()) && (localo.length() == paramString.size))
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
  
  public final WebResourceResponse bcB(String paramString)
  {
    AppMethodBeat.i(110707);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110707);
      return null;
    }
    if ((this.JNs != null) && (this.JNs.get(paramString) != null))
    {
      Object localObject1 = (WepkgPreloadFile)this.JNs.get(paramString);
      if (!Util.isNullOrNil(((WepkgPreloadFile)localObject1).filePath))
      {
        Object localObject2 = new o(((WepkgPreloadFile)localObject1).filePath);
        if ((((o)localObject2).exists()) && (((o)localObject2).isFile()) && (((o)localObject2).length() == ((WepkgPreloadFile)localObject1).size)) {
          try
          {
            Log.i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s, localPath:%s", new Object[] { paramString, ((WepkgPreloadFile)localObject1).filePath });
            localObject2 = s.ao((o)localObject2);
            localObject1 = new WebResourceResponse(((WepkgPreloadFile)localObject1).mimeType, this.charset, (InputStream)localObject2);
            AppMethodBeat.o(110707);
            return localObject1;
          }
          catch (FileNotFoundException localFileNotFoundException) {}
        }
      }
    }
    if (this.JNr != null)
    {
      paramString = this.JNr.mt(paramString, this.charset);
      AppMethodBeat.o(110707);
      return paramString;
    }
    AppMethodBeat.o(110707);
    return null;
  }
  
  public final boolean bcE(String paramString)
  {
    AppMethodBeat.i(110706);
    paramString = bcB(d.bcQ(paramString));
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