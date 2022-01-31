package com.tencent.mm.plugin.recharge.ui.form;

import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.b;

final class c$1
  extends c.a
{
  c$1()
  {
    super((byte)0);
  }
  
  public final String XQ(String paramString)
  {
    AppMethodBeat.i(44367);
    if (paramString == null)
    {
      AppMethodBeat.o(44367);
      return "";
    }
    paramString = paramString.replaceAll(" ", "");
    AppMethodBeat.o(44367);
    return paramString;
  }
  
  public final boolean a(MallFormView paramMallFormView)
  {
    AppMethodBeat.i(44366);
    boolean bool = PhoneNumberUtils.isGlobalPhoneNumber(b.xw(paramMallFormView.getText().toString()));
    AppMethodBeat.o(44366);
    return bool;
  }
  
  public final boolean cfH()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.c.1
 * JD-Core Version:    0.7.0.1
 */