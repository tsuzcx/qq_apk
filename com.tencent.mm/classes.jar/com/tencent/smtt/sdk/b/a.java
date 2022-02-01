package com.tencent.smtt.sdk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager;
import java.io.File;
import java.io.InputStream;

public class a
  implements IX5CoreCacheManager
{
  private DexLoader a;
  
  a(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public boolean cacheDisabled()
  {
    AppMethodBeat.i(197111);
    boolean bool = ((Boolean)this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0])).booleanValue();
    AppMethodBeat.o(197111);
    return bool;
  }
  
  public void clearLocalStorage()
  {
    AppMethodBeat.i(197114);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearLocalStorage", null, new Object[0]);
    AppMethodBeat.o(197114);
  }
  
  public void clearNetworkCache() {}
  
  public InputStream getCacheFile(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197119);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[] { String.class, Boolean.TYPE }, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramString == null)
    {
      AppMethodBeat.o(197119);
      return null;
    }
    paramString = (InputStream)paramString;
    AppMethodBeat.o(197119);
    return paramString;
  }
  
  public File getCacheFileBaseDir()
  {
    AppMethodBeat.i(197112);
    File localFile = (File)this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
    AppMethodBeat.o(197112);
    return localFile;
  }
  
  public String getLocalPath(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */