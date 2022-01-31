package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public final class f
{
  private String charset;
  public WepkgVersion vGb;
  private e vGl;
  private Map<String, WepkgPreloadFile> vGm;
  
  public f(WepkgVersion paramWepkgVersion, e parame, Map<String, WepkgPreloadFile> paramMap)
  {
    AppMethodBeat.i(63547);
    this.charset = "UTF-8";
    this.vGb = paramWepkgVersion;
    this.vGl = parame;
    this.vGm = paramMap;
    if ((paramWepkgVersion != null) && (!bo.isNullOrNil(paramWepkgVersion.charset))) {
      this.charset = paramWepkgVersion.charset;
    }
    AppMethodBeat.o(63547);
  }
  
  public final String Ly(String paramString)
  {
    AppMethodBeat.i(63550);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63550);
      return null;
    }
    if ((this.vGm != null) && (this.vGm.get(paramString) != null))
    {
      paramString = (WepkgPreloadFile)this.vGm.get(paramString);
      if (!bo.isNullOrNil(paramString.filePath))
      {
        File localFile = new File(paramString.filePath);
        if ((localFile.exists()) && (localFile.isFile()) && (localFile.length() == paramString.size))
        {
          paramString = paramString.filePath;
          AppMethodBeat.o(63550);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(63550);
    return null;
  }
  
  public final s akB(String paramString)
  {
    AppMethodBeat.i(63549);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63549);
      return null;
    }
    if ((this.vGm != null) && (this.vGm.get(paramString) != null))
    {
      Object localObject1 = (WepkgPreloadFile)this.vGm.get(paramString);
      if (!bo.isNullOrNil(((WepkgPreloadFile)localObject1).filePath))
      {
        Object localObject2 = new File(((WepkgPreloadFile)localObject1).filePath);
        if ((((File)localObject2).exists()) && (((File)localObject2).isFile()) && (((File)localObject2).length() == ((WepkgPreloadFile)localObject1).size)) {
          try
          {
            ab.i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s, localPath:%s", new Object[] { paramString, ((WepkgPreloadFile)localObject1).filePath });
            localObject2 = new FileInputStream((File)localObject2);
            localObject1 = new s(((WepkgPreloadFile)localObject1).mimeType, this.charset, (InputStream)localObject2);
            AppMethodBeat.o(63549);
            return localObject1;
          }
          catch (FileNotFoundException localFileNotFoundException) {}
        }
      }
    }
    if (this.vGl != null)
    {
      paramString = this.vGl.hO(paramString, this.charset);
      AppMethodBeat.o(63549);
      return paramString;
    }
    AppMethodBeat.o(63549);
    return null;
  }
  
  public final boolean akC(String paramString)
  {
    AppMethodBeat.i(63548);
    if (akB(d.akO(paramString)) != null)
    {
      AppMethodBeat.o(63548);
      return true;
    }
    AppMethodBeat.o(63548);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.f
 * JD-Core Version:    0.7.0.1
 */