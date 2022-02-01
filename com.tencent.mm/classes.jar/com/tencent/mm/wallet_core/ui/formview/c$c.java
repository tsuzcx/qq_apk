package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEditText.EncryptMode;

public final class c$c
{
  public static String b(int paramInt, TenpaySecureEditText paramTenpaySecureEditText, long paramLong, String paramString)
  {
    AppMethodBeat.i(242217);
    long l = paramLong;
    if (paramLong == 0L) {
      l = cn.bDu() / 1000L;
    }
    Log.v("MicroMsg.IEncryptDelegate", "encryptType:%d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      if (paramTenpaySecureEditText.getText().toString() == null)
      {
        AppMethodBeat.o(242217);
        return "";
      }
      break;
    case 2: 
      paramTenpaySecureEditText = paramTenpaySecureEditText.get3DesEncrptData();
      AppMethodBeat.o(242217);
      return paramTenpaySecureEditText;
    case 1: 
      b.jNX();
      paramTenpaySecureEditText = paramTenpaySecureEditText.getEncryptDataWithHash(true, b.jNY());
      AppMethodBeat.o(242217);
      return paramTenpaySecureEditText;
    case 0: 
      b.jNX();
      paramTenpaySecureEditText = paramTenpaySecureEditText.getEncryptDataWithHash(false, b.jNY());
      AppMethodBeat.o(242217);
      return paramTenpaySecureEditText;
    case 3: 
      paramTenpaySecureEditText = paramTenpaySecureEditText.get3DesVerifyCode();
      AppMethodBeat.o(242217);
      return paramTenpaySecureEditText;
    case 4: 
      paramTenpaySecureEditText = paramTenpaySecureEditText.getEncryptPassword(TenpaySecureEditText.EncryptMode.SM2_WITH_MD5, l, paramString);
      AppMethodBeat.o(242217);
      return paramTenpaySecureEditText;
    case 5: 
      paramTenpaySecureEditText = paramTenpaySecureEditText.getEncryptPassword(TenpaySecureEditText.EncryptMode.SM2_WITH_PBKDF2, l, paramString);
      AppMethodBeat.o(242217);
      return paramTenpaySecureEditText;
    }
    paramTenpaySecureEditText = paramTenpaySecureEditText.getText().toString();
    AppMethodBeat.o(242217);
    return paramTenpaySecureEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.c.c
 * JD-Core Version:    0.7.0.1
 */