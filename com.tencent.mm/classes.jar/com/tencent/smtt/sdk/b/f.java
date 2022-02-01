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
    AppMethodBeat.i(192822);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(192822);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(192822);
    return paramString1;
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(192823);
    paramArrayOfByte = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[] { String.class }, new Object[] { paramArrayOfByte });
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(192823);
      return null;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte;
    AppMethodBeat.o(192823);
    return paramArrayOfByte;
  }
  
  public String guessFileName(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(192836);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(192836);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(192836);
    return paramString1;
  }
  
  public String guessUrl(String paramString)
  {
    AppMethodBeat.i(192821);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192821);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(192821);
    return paramString;
  }
  
  public boolean isAboutUrl(String paramString)
  {
    AppMethodBeat.i(192827);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192827);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(192827);
    return bool;
  }
  
  public boolean isAssetUrl(String paramString)
  {
    AppMethodBeat.i(192824);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192824);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(192824);
    return bool;
  }
  
  public boolean isContentUrl(String paramString)
  {
    AppMethodBeat.i(192833);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192833);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(192833);
    return bool;
  }
  
  public boolean isCookielessProxyUrl(String paramString)
  {
    AppMethodBeat.i(192825);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192825);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(192825);
    return bool;
  }
  
  public boolean isDataUrl(String paramString)
  {
    AppMethodBeat.i(192828);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192828);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(192828);
    return bool;
  }
  
  public boolean isFileUrl(String paramString)
  {
    AppMethodBeat.i(192826);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192826);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(192826);
    return bool;
  }
  
  public boolean isHttpUrl(String paramString)
  {
    AppMethodBeat.i(192830);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192830);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(192830);
    return bool;
  }
  
  public boolean isHttpsUrl(String paramString)
  {
    AppMethodBeat.i(192831);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192831);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(192831);
    return bool;
  }
  
  public boolean isJavaScriptUrl(String paramString)
  {
    AppMethodBeat.i(192829);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192829);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(192829);
    return bool;
  }
  
  public boolean isNetworkUrl(String paramString)
  {
    AppMethodBeat.i(192832);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192832);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(192832);
    return bool;
  }
  
  public boolean isValidUrl(String paramString)
  {
    AppMethodBeat.i(192834);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192834);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(192834);
    return bool;
  }
  
  public String stripAnchor(String paramString)
  {
    AppMethodBeat.i(192835);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192835);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(192835);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.f
 * JD-Core Version:    0.7.0.1
 */