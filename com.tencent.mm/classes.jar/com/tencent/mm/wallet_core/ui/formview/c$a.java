package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class c$a
{
  public static String a(int paramInt, TenpaySecureEditText paramTenpaySecureEditText, long paramLong, String paramString)
  {
    AppMethodBeat.i(242215);
    if (z.bBi())
    {
      Log.v("MicroMsg.IEncryptDelegate", "hy: is payu. encrypt with payu");
      new c.b();
      paramTenpaySecureEditText = c.b.a(paramInt, paramTenpaySecureEditText);
      AppMethodBeat.o(242215);
      return paramTenpaySecureEditText;
    }
    Log.v("MicroMsg.IEncryptDelegate", "hy: is tenpay. encrypt with tenpay");
    new c.c();
    paramTenpaySecureEditText = c.c.b(paramInt, paramTenpaySecureEditText, paramLong, paramString);
    AppMethodBeat.o(242215);
    return paramTenpaySecureEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.c.a
 * JD-Core Version:    0.7.0.1
 */