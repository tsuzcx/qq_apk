package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.a.a;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class c$a
{
  public static String a(int paramInt, TenpaySecureEditText paramTenpaySecureEditText)
  {
    if (q.Gw())
    {
      y.v("MicroMsg.IEncryptDelegate", "hy: is payu. encrypt with payu");
      new c.b();
      paramTenpaySecureEditText.setSecureEncrypt(new a(paramInt));
      return paramTenpaySecureEditText.get3DesEncrptData();
    }
    y.v("MicroMsg.IEncryptDelegate", "hy: is tenpay. encrypt with tenpay");
    new c.c();
    switch (paramInt)
    {
    default: 
      if (paramTenpaySecureEditText.getText().toString() == null) {
        return "";
      }
      break;
    case 2: 
      return paramTenpaySecureEditText.get3DesEncrptData();
    case 1: 
      b.cMj();
      return paramTenpaySecureEditText.getEncryptDataWithHash(true, b.cMk());
    case 0: 
      b.cMj();
      return paramTenpaySecureEditText.getEncryptDataWithHash(false, b.cMk());
    case 3: 
      return paramTenpaySecureEditText.get3DesVerifyCode();
    }
    return paramTenpaySecureEditText.getText().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.c.a
 * JD-Core Version:    0.7.0.1
 */