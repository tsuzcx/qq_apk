package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a.a;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class c$b
{
  public static String b(int paramInt, TenpaySecureEditText paramTenpaySecureEditText)
  {
    AppMethodBeat.i(73140);
    paramTenpaySecureEditText.setSecureEncrypt(new a(paramInt));
    paramTenpaySecureEditText = paramTenpaySecureEditText.get3DesEncrptData();
    AppMethodBeat.o(73140);
    return paramTenpaySecureEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.c.b
 * JD-Core Version:    0.7.0.1
 */