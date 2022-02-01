package com.tencent.smtt.sdk.a;

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
    AppMethodBeat.i(54741);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(54741);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(54741);
    return paramString1;
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(54742);
    paramArrayOfByte = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[] { String.class }, new Object[] { paramArrayOfByte });
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(54742);
      return null;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte;
    AppMethodBeat.o(54742);
    return paramArrayOfByte;
  }
  
  public String guessFileName(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(54755);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(54755);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(54755);
    return paramString1;
  }
  
  public String guessUrl(String paramString)
  {
    AppMethodBeat.i(54740);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54740);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(54740);
    return paramString;
  }
  
  public boolean isAboutUrl(String paramString)
  {
    AppMethodBeat.i(54746);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54746);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(54746);
    return bool;
  }
  
  public boolean isAssetUrl(String paramString)
  {
    AppMethodBeat.i(54743);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54743);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(54743);
    return bool;
  }
  
  public boolean isContentUrl(String paramString)
  {
    AppMethodBeat.i(54752);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54752);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(54752);
    return bool;
  }
  
  public boolean isCookielessProxyUrl(String paramString)
  {
    AppMethodBeat.i(54744);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54744);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(54744);
    return bool;
  }
  
  public boolean isDataUrl(String paramString)
  {
    AppMethodBeat.i(54747);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54747);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(54747);
    return bool;
  }
  
  public boolean isFileUrl(String paramString)
  {
    AppMethodBeat.i(54745);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54745);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(54745);
    return bool;
  }
  
  public boolean isHttpUrl(String paramString)
  {
    AppMethodBeat.i(54749);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54749);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(54749);
    return bool;
  }
  
  public boolean isHttpsUrl(String paramString)
  {
    AppMethodBeat.i(54750);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54750);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(54750);
    return bool;
  }
  
  public boolean isJavaScriptUrl(String paramString)
  {
    AppMethodBeat.i(54748);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54748);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(54748);
    return bool;
  }
  
  public boolean isNetworkUrl(String paramString)
  {
    AppMethodBeat.i(54751);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54751);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(54751);
    return bool;
  }
  
  public boolean isValidUrl(String paramString)
  {
    AppMethodBeat.i(54753);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54753);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(54753);
    return bool;
  }
  
  public String stripAnchor(String paramString)
  {
    AppMethodBeat.i(54754);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54754);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(54754);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.f
 * JD-Core Version:    0.7.0.1
 */