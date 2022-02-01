package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebResourceResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class g
  extends b
{
  private Map<String, WepkgPreloadFile> EXA;
  public WepkgVersion EXp;
  public f EXz;
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
    this.EXp = paramWepkgVersion;
    this.EXz = paramf;
    this.EXA = paramMap;
    if ((paramWepkgVersion != null) && (!bu.isNullOrNil(paramWepkgVersion.charset))) {
      this.charset = paramWepkgVersion.charset;
    }
    AppMethodBeat.o(110705);
  }
  
  public final WebResourceResponse aMi(String paramString)
  {
    AppMethodBeat.i(110707);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110707);
      return null;
    }
    if ((this.EXA != null) && (this.EXA.get(paramString) != null))
    {
      Object localObject1 = (WepkgPreloadFile)this.EXA.get(paramString);
      if (!bu.isNullOrNil(((WepkgPreloadFile)localObject1).filePath))
      {
        Object localObject2 = new k(((WepkgPreloadFile)localObject1).filePath);
        if ((((k)localObject2).exists()) && (((k)localObject2).isFile()) && (((k)localObject2).length() == ((WepkgPreloadFile)localObject1).size)) {
          try
          {
            ae.i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s, localPath:%s", new Object[] { paramString, ((WepkgPreloadFile)localObject1).filePath });
            localObject2 = o.ai((k)localObject2);
            localObject1 = new WebResourceResponse(((WepkgPreloadFile)localObject1).mimeType, this.charset, (InputStream)localObject2);
            AppMethodBeat.o(110707);
            return localObject1;
          }
          catch (FileNotFoundException localFileNotFoundException) {}
        }
      }
    }
    if (this.EXz != null)
    {
      paramString = this.EXz.lu(paramString, this.charset);
      AppMethodBeat.o(110707);
      return paramString;
    }
    AppMethodBeat.o(110707);
    return null;
  }
  
  public final boolean aMk(String paramString)
  {
    AppMethodBeat.i(110706);
    paramString = aMi(d.aMw(paramString));
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
  
  public final String adq(String paramString)
  {
    AppMethodBeat.i(110708);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110708);
      return null;
    }
    if ((this.EXA != null) && (this.EXA.get(paramString) != null))
    {
      paramString = (WepkgPreloadFile)this.EXA.get(paramString);
      if (!bu.isNullOrNil(paramString.filePath))
      {
        k localk = new k(paramString.filePath);
        if ((localk.exists()) && (localk.isFile()) && (localk.length() == paramString.size))
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