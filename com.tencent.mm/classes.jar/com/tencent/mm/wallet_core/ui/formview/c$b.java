package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a.a;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class c$b
{
  public static String a(int paramInt, TenpaySecureEditText paramTenpaySecureEditText)
  {
    AppMethodBeat.i(242216);
    paramTenpaySecureEditText.setSecureEncrypt(new a(paramInt));
    paramTenpaySecureEditText = paramTenpaySecureEditText.get3DesEncrptData();
    AppMethodBeat.o(242216);
    return paramTenpaySecureEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.c.b
 * JD-Core Version:    0.7.0.1
 */