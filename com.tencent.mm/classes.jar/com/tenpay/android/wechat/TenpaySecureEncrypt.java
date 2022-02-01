package com.tenpay.android.wechat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;

public final class TenpaySecureEncrypt
  implements ISecureEncrypt
{
  public final String desedeEncode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73253);
    paramString1 = new Encrypt().desedeEncode(paramString1);
    AppMethodBeat.o(73253);
    return paramString1;
  }
  
  public final String desedeVerifyCode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73254);
    paramString1 = new Encrypt().desedeVerifyCode(paramString1);
    AppMethodBeat.o(73254);
    return paramString1;
  }
  
  public final String encryptPasswd(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(73252);
    String str = paramString1;
    if (paramBoolean) {
      str = TenpayUtil.md5HexDigest(paramString1);
    }
    paramString1 = new Encrypt();
    if (paramString2 != null) {
      paramString1.setTimeStamp(paramString2);
    }
    paramString1 = paramString1.encryptPasswd(str);
    AppMethodBeat.o(73252);
    return paramString1;
  }
  
  public final String encryptPasswdWithRSA2048(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(73251);
    String str = paramString1;
    if (paramBoolean) {
      str = TenpayUtil.md5HexDigest(paramString1);
    }
    paramString1 = new Encrypt();
    if (paramString2 != null) {
      paramString1.setTimeStamp(paramString2);
    }
    paramString1 = paramString1.encryptPasswdWithRSA2048(str);
    AppMethodBeat.o(73251);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpaySecureEncrypt
 * JD-Core Version:    0.7.0.1
 */