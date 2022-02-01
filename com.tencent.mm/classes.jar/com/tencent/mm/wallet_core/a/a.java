package com.tencent.mm.wallet_core.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tenpay.android.wechat.PayuSecureEncrypt;

public final class a
  extends PayuSecureEncrypt
{
  public a(int paramInt)
  {
    this.mEncrptType = paramInt;
  }
  
  private String m(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(72651);
    int i = this.mEncrptType;
    Object localObject = "10";
    StringBuilder localStringBuilder;
    if (-20 == this.mEncrptType)
    {
      i = 40;
      if ((this.mEncrptType == -10) || (this.mEncrptType == -20) || (this.mEncrptType == 60)) {
        localObject = "30";
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("|");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("|");
      if (!paramBoolean) {
        break label233;
      }
      localStringBuilder.append(MD5Util.getMD5String(paramString1));
    }
    for (;;)
    {
      paramString1 = null;
      try
      {
        paramString2 = localStringBuilder.toString().getBytes();
        localObject = new PByteArray();
        if (!MMProtocalJni.rsaPublicEncrypt(paramString2, (PByteArray)localObject, getRsaEKey().getBytes("UTF-8"), getRsaNKey().getBytes("UTF-8"))) {
          Log.e("MicroMsg.WxPayuSecureEncrypt", "MMProtocalJni encrypt failed!");
        }
        paramString2 = "01" + Base64.encodeToString(((PByteArray)localObject).value, 2);
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WxPayuSecureEncrypt", paramString2, "", new Object[0]);
        }
      }
      AppMethodBeat.o(72651);
      return paramString1;
      if (-10 != this.mEncrptType) {
        break;
      }
      i = 20;
      break;
      label233:
      localStringBuilder.append(paramString1);
    }
  }
  
  private String ow(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72650);
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
      AppMethodBeat.o(72650);
      return str;
    case -20: 
    case -10: 
    case 60: 
      paramString1 = m(true, str, paramString2);
      AppMethodBeat.o(72650);
      return paramString1;
    }
    paramString1 = m(false, str, paramString2);
    AppMethodBeat.o(72650);
    return paramString1;
  }
  
  public final String desedeEncode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72647);
    paramString1 = ow(paramString1, paramString2);
    AppMethodBeat.o(72647);
    return paramString1;
  }
  
  public final String desedeVerifyCode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72648);
    paramString1 = ow(paramString1, paramString2);
    AppMethodBeat.o(72648);
    return paramString1;
  }
  
  public final String encryptPasswd(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(72649);
    paramString1 = ow(paramString1, paramString2);
    AppMethodBeat.o(72649);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.a.a
 * JD-Core Version:    0.7.0.1
 */