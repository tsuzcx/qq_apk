package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class c$c
{
  public static String b(int paramInt, TenpaySecureEditText paramTenpaySecureEditText)
  {
    AppMethodBeat.i(73141);
    switch (paramInt)
    {
    default: 
      if (paramTenpaySecureEditText.getText().toString() == null)
      {
        AppMethodBeat.o(73141);
        return "";
      }
      break;
    case 2: 
      paramTenpaySecureEditText = paramTenpaySecureEditText.get3DesEncrptData();
      AppMethodBeat.o(73141);
      return paramTenpaySecureEditText;
    case 1: 
      b.hgC();
      paramTenpaySecureEditText = paramTenpaySecureEditText.getEncryptDataWithHash(true, b.hgD());
      AppMethodBeat.o(73141);
      return paramTenpaySecureEditText;
    case 0: 
      b.hgC();
      paramTenpaySecureEditText = paramTenpaySecureEditText.getEncryptDataWithHash(false, b.hgD());
      AppMethodBeat.o(73141);
      return paramTenpaySecureEditText;
    case 3: 
      paramTenpaySecureEditText = paramTenpaySecureEditText.get3DesVerifyCode();
      AppMethodBeat.o(73141);
      return paramTenpaySecureEditText;
    }
    paramTenpaySecureEditText = paramTenpaySecureEditText.getText().toString();
    AppMethodBeat.o(73141);
    return paramTenpaySecureEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.c.c
 * JD-Core Version:    0.7.0.1
 */