package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class c$a
{
  public static String a(int paramInt, TenpaySecureEditText paramTenpaySecureEditText)
  {
    AppMethodBeat.i(73139);
    if (u.aqV())
    {
      ad.v("MicroMsg.IEncryptDelegate", "hy: is payu. encrypt with payu");
      new c.b();
      paramTenpaySecureEditText = c.b.b(paramInt, paramTenpaySecureEditText);
      AppMethodBeat.o(73139);
      return paramTenpaySecureEditText;
    }
    ad.v("MicroMsg.IEncryptDelegate", "hy: is tenpay. encrypt with tenpay");
    new c.c();
    paramTenpaySecureEditText = c.c.b(paramInt, paramTenpaySecureEditText);
    AppMethodBeat.o(73139);
    return paramTenpaySecureEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.c.a
 * JD-Core Version:    0.7.0.1
 */