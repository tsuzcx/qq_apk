package com.tencent.mm.wallet_core.a;

import android.util.Base64;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import com.tenpay.android.wechat.PayuSecureEncrypt;

public final class a
  extends PayuSecureEncrypt
{
  public a(int paramInt)
  {
    this.mEncrptType = paramInt;
  }
  
  private String f(boolean paramBoolean, String paramString1, String paramString2)
  {
    int i = this.mEncrptType;
    String str = "10";
    StringBuilder localStringBuilder;
    if (-20 == this.mEncrptType)
    {
      i = 40;
      if ((this.mEncrptType == -10) || (this.mEncrptType == -20) || (this.mEncrptType == 60)) {
        str = "30";
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("|");
      localStringBuilder.append(str);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("|");
      if (!paramBoolean) {
        break label216;
      }
      localStringBuilder.append(ad.bB(paramString1));
    }
    for (;;)
    {
      try
      {
        paramString1 = localStringBuilder.toString().getBytes();
        paramString2 = new PByteArray();
        if (!MMProtocalJni.rsaPublicEncrypt(paramString1, paramString2, getRsaEKey().getBytes("UTF-8"), getRsaNKey().getBytes("UTF-8"))) {
          y.e("MicroMsg.WxPayuSecureEncrypt", "MMProtocalJni encrypt failed!");
        }
        paramString1 = "01" + Base64.encodeToString(paramString2.value, 2);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        label216:
        y.printErrStackTrace("MicroMsg.WxPayuSecureEncrypt", paramString1, "", new Object[0]);
      }
      if (-10 != this.mEncrptType) {
        break;
      }
      i = 20;
      break;
      localStringBuilder.append(paramString1);
    }
    return null;
  }
  
  private String gF(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (this.mEncrptType != 40)
    {
      str = paramString1;
      if (this.mEncrptType != -20) {
        str = paramString1.replaceAll(" ", "");
      }
    }
    switch (this.mEncrptType)
    {
    default: 
      return str;
    case -20: 
    case -10: 
    case 60: 
      return f(true, str, paramString2);
    }
    return f(false, str, paramString2);
  }
  
  public final String desedeEncode(String paramString1, String paramString2)
  {
    return gF(paramString1, paramString2);
  }
  
  public final String desedeVerifyCode(String paramString1, String paramString2)
  {
    return gF(paramString1, paramString2);
  }
  
  public final String encryptPasswd(boolean paramBoolean, String paramString1, String paramString2)
  {
    return gF(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.a.a
 * JD-Core Version:    0.7.0.1
 */