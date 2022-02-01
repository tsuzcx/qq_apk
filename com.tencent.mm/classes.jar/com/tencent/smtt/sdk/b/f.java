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
    AppMethodBeat.i(188440);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(188440);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(188440);
    return paramString1;
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(188441);
    paramArrayOfByte = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[] { String.class }, new Object[] { paramArrayOfByte });
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(188441);
      return null;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte;
    AppMethodBeat.o(188441);
    return paramArrayOfByte;
  }
  
  public String guessFileName(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188454);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(188454);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(188454);
    return paramString1;
  }
  
  public String guessUrl(String paramString)
  {
    AppMethodBeat.i(188439);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188439);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(188439);
    return paramString;
  }
  
  public boolean isAboutUrl(String paramString)
  {
    AppMethodBeat.i(188445);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188445);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188445);
    return bool;
  }
  
  public boolean isAssetUrl(String paramString)
  {
    AppMethodBeat.i(188442);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188442);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188442);
    return bool;
  }
  
  public boolean isContentUrl(String paramString)
  {
    AppMethodBeat.i(188451);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188451);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188451);
    return bool;
  }
  
  public boolean isCookielessProxyUrl(String paramString)
  {
    AppMethodBeat.i(188443);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188443);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188443);
    return bool;
  }
  
  public boolean isDataUrl(String paramString)
  {
    AppMethodBeat.i(188446);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188446);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188446);
    return bool;
  }
  
  public boolean isFileUrl(String paramString)
  {
    AppMethodBeat.i(188444);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188444);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188444);
    return bool;
  }
  
  public boolean isHttpUrl(String paramString)
  {
    AppMethodBeat.i(188448);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188448);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188448);
    return bool;
  }
  
  public boolean isHttpsUrl(String paramString)
  {
    AppMethodBeat.i(188449);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188449);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188449);
    return bool;
  }
  
  public boolean isJavaScriptUrl(String paramString)
  {
    AppMethodBeat.i(188447);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188447);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188447);
    return bool;
  }
  
  public boolean isNetworkUrl(String paramString)
  {
    AppMethodBeat.i(188450);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188450);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188450);
    return bool;
  }
  
  public boolean isValidUrl(String paramString)
  {
    AppMethodBeat.i(188452);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188452);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188452);
    return bool;
  }
  
  public String stripAnchor(String paramString)
  {
    AppMethodBeat.i(188453);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188453);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(188453);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.f
 * JD-Core Version:    0.7.0.1
 */