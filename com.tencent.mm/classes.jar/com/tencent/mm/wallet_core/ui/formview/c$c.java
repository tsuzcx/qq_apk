package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class c$c
{
  public static String b(int paramInt, TenpaySecureEditText paramTenpaySecureEditText)
  {
    AppMethodBeat.i(49409);
    switch (paramInt)
    {
    default: 
      if (paramTenpaySecureEditText.getText().toString() == null)
      {
        AppMethodBeat.o(49409);
        return "";
      }
      break;
    case 2: 
      paramTenpaySecureEditText = paramTenpaySecureEditText.get3DesEncrptData();
      AppMethodBeat.o(49409);
      return paramTenpaySecureEditText;
    case 1: 
      b.dRI();
      paramTenpaySecureEditText = paramTenpaySecureEditText.getEncryptDataWithHash(true, b.dRJ());
      AppMethodBeat.o(49409);
      return paramTenpaySecureEditText;
    case 0: 
      b.dRI();
      paramTenpaySecureEditText = paramTenpaySecureEditText.getEncryptDataWithHash(false, b.dRJ());
      AppMethodBeat.o(49409);
      return paramTenpaySecureEditText;
    case 3: 
      paramTenpaySecureEditText = paramTenpaySecureEditText.get3DesVerifyCode();
      AppMethodBeat.o(49409);
      return paramTenpaySecureEditText;
    }
    paramTenpaySecureEditText = paramTenpaySecureEditText.getText().toString();
    AppMethodBeat.o(49409);
    return paramTenpaySecureEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.c.c
 * JD-Core Version:    0.7.0.1
 */