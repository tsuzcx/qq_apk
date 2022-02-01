package com.tencent.smtt.sdk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil;

public class f
  implements IX5CoreUrlUtil
{
  private DexLoader a;
  
  f(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public String composeSearchUrl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(197035);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(197035);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(197035);
    return paramString1;
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197039);
    paramArrayOfByte = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[] { String.class }, new Object[] { paramArrayOfByte });
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(197039);
      return null;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte;
    AppMethodBeat.o(197039);
    return paramArrayOfByte;
  }
  
  public String guessFileName(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(197072);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(197072);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(197072);
    return paramString1;
  }
  
  public String guessUrl(String paramString)
  {
    AppMethodBeat.i(197032);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197032);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(197032);
    return paramString;
  }
  
  public boolean isAboutUrl(String paramString)
  {
    AppMethodBeat.i(197048);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197048);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197048);
    return bool;
  }
  
  public boolean isAssetUrl(String paramString)
  {
    AppMethodBeat.i(197043);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197043);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197043);
    return bool;
  }
  
  public boolean isContentUrl(String paramString)
  {
    AppMethodBeat.i(197062);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197062);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197062);
    return bool;
  }
  
  public boolean isCookielessProxyUrl(String paramString)
  {
    AppMethodBeat.i(197045);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197045);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197045);
    return bool;
  }
  
  public boolean isDataUrl(String paramString)
  {
    AppMethodBeat.i(197050);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197050);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197050);
    return bool;
  }
  
  public boolean isFileUrl(String paramString)
  {
    AppMethodBeat.i(197046);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197046);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197046);
    return bool;
  }
  
  public boolean isHttpUrl(String paramString)
  {
    AppMethodBeat.i(197055);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197055);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197055);
    return bool;
  }
  
  public boolean isHttpsUrl(String paramString)
  {
    AppMethodBeat.i(197058);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197058);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197058);
    return bool;
  }
  
  public boolean isJavaScriptUrl(String paramString)
  {
    AppMethodBeat.i(197053);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197053);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197053);
    return bool;
  }
  
  public boolean isNetworkUrl(String paramString)
  {
    AppMethodBeat.i(197061);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197061);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197061);
    return bool;
  }
  
  public boolean isValidUrl(String paramString)
  {
    AppMethodBeat.i(197065);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197065);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197065);
    return bool;
  }
  
  public String stripAnchor(String paramString)
  {
    AppMethodBeat.i(197068);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197068);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(197068);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.f
 * JD-Core Version:    0.7.0.1
 */