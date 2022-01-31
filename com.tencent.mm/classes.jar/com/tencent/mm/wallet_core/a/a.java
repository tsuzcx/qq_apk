package com.tencent.mm.wallet_core.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tenpay.android.wechat.PayuSecureEncrypt;

public final class a
  extends PayuSecureEncrypt
{
  public a(int paramInt)
  {
    this.mEncrptType = paramInt;
  }
  
  private String g(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(49013);
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
      localStringBuilder.append(ag.cE(paramString1));
    }
    for (;;)
    {
      paramString1 = null;
      try
      {
        paramString2 = localStringBuilder.toString().getBytes();
        localObject = new PByteArray();
        if (!MMProtocalJni.rsaPublicEncrypt(paramString2, (PByteArray)localObject, getRsaEKey().getBytes("UTF-8"), getRsaNKey().getBytes("UTF-8"))) {
          ab.e("MicroMsg.WxPayuSecureEncrypt", "MMProtocalJni encrypt failed!");
        }
        paramString2 = "01" + Base64.encodeToString(((PByteArray)localObject).value, 2);
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WxPayuSecureEncrypt", paramString2, "", new Object[0]);
        }
      }
      AppMethodBeat.o(49013);
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
  
  private String iI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49012);
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
      AppMethodBeat.o(49012);
      return str;
    case -20: 
    case -10: 
    case 60: 
      paramString1 = g(true, str, paramString2);
      AppMethodBeat.o(49012);
      return paramString1;
    }
    paramString1 = g(false, str, paramString2);
    AppMethodBeat.o(49012);
    return paramString1;
  }
  
  public final String desedeEncode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49009);
    paramString1 = iI(paramString1, paramString2);
    AppMethodBeat.o(49009);
    return paramString1;
  }
  
  public final String desedeVerifyCode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49010);
    paramString1 = iI(paramString1, paramString2);
    AppMethodBeat.o(49010);
    return paramString1;
  }
  
  public final String encryptPasswd(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(49011);
    paramString1 = iI(paramString1, paramString2);
    AppMethodBeat.o(49011);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.a.a
 * JD-Core Version:    0.7.0.1
 */