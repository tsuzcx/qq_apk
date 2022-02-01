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
    AppMethodBeat.i(219812);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(219812);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(219812);
    return paramString1;
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(219822);
    paramArrayOfByte = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[] { String.class }, new Object[] { paramArrayOfByte });
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(219822);
      return null;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte;
    AppMethodBeat.o(219822);
    return paramArrayOfByte;
  }
  
  public String guessFileName(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(219891);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(219891);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(219891);
    return paramString1;
  }
  
  public String guessUrl(String paramString)
  {
    AppMethodBeat.i(219804);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219804);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(219804);
    return paramString;
  }
  
  public boolean isAboutUrl(String paramString)
  {
    AppMethodBeat.i(219850);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219850);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(219850);
    return bool;
  }
  
  public boolean isAssetUrl(String paramString)
  {
    AppMethodBeat.i(219830);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219830);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(219830);
    return bool;
  }
  
  public boolean isContentUrl(String paramString)
  {
    AppMethodBeat.i(219880);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219880);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(219880);
    return bool;
  }
  
  public boolean isCookielessProxyUrl(String paramString)
  {
    AppMethodBeat.i(219837);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219837);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(219837);
    return bool;
  }
  
  public boolean isDataUrl(String paramString)
  {
    AppMethodBeat.i(219855);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219855);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(219855);
    return bool;
  }
  
  public boolean isFileUrl(String paramString)
  {
    AppMethodBeat.i(219844);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219844);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(219844);
    return bool;
  }
  
  public boolean isHttpUrl(String paramString)
  {
    AppMethodBeat.i(219865);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219865);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(219865);
    return bool;
  }
  
  public boolean isHttpsUrl(String paramString)
  {
    AppMethodBeat.i(219870);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219870);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(219870);
    return bool;
  }
  
  public boolean isJavaScriptUrl(String paramString)
  {
    AppMethodBeat.i(219860);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219860);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(219860);
    return bool;
  }
  
  public boolean isNetworkUrl(String paramString)
  {
    AppMethodBeat.i(219876);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219876);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(219876);
    return bool;
  }
  
  public boolean isValidUrl(String paramString)
  {
    AppMethodBeat.i(219884);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219884);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(219884);
    return bool;
  }
  
  public String stripAnchor(String paramString)
  {
    AppMethodBeat.i(219888);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219888);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(219888);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.f
 * JD-Core Version:    0.7.0.1
 */