package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public final class d
{
  private String charset = "UTF-8";
  public WepkgVersion rPj;
  private c rPt;
  public Map<String, WepkgPreloadFile> rPu;
  
  public d(WepkgVersion paramWepkgVersion, c paramc, Map<String, WepkgPreloadFile> paramMap)
  {
    this.rPj = paramWepkgVersion;
    this.rPt = paramc;
    this.rPu = paramMap;
    if ((paramWepkgVersion != null) && (!bk.bl(paramWepkgVersion.charset))) {
      this.charset = paramWepkgVersion.charset;
    }
  }
  
  public final m Vd(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    if ((this.rPu != null) && (this.rPu.get(paramString) != null))
    {
      Object localObject1 = (WepkgPreloadFile)this.rPu.get(paramString);
      if (!bk.bl(((WepkgPreloadFile)localObject1).filePath))
      {
        Object localObject2 = new File(((WepkgPreloadFile)localObject1).filePath);
        if ((((File)localObject2).exists()) && (((File)localObject2).isFile()) && (((File)localObject2).length() == ((WepkgPreloadFile)localObject1).size)) {
          try
          {
            y.i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s", new Object[] { paramString });
            localObject2 = new FileInputStream((File)localObject2);
            localObject1 = new m(((WepkgPreloadFile)localObject1).mimeType, this.charset, (InputStream)localObject2);
            return localObject1;
          }
          catch (FileNotFoundException localFileNotFoundException) {}
        }
      }
    }
    if (this.rPt != null)
    {
      y.i("MicroMsg.Wepkg.WepkgInterceptor", "hit big package, rid: " + paramString);
      return this.rPt.fL(paramString, this.charset);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.d
 * JD-Core Version:    0.7.0.1
 */