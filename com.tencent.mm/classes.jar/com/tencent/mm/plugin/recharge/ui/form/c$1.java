package com.tencent.mm.plugin.recharge.ui.form;

import android.telephony.PhoneNumberUtils;
import com.tencent.mm.plugin.recharge.model.b;

final class c$1
  extends c.a
{
  c$1()
  {
    super((byte)0);
  }
  
  public final String LF(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replaceAll(" ", "");
  }
  
  public final boolean a(MallFormView paramMallFormView)
  {
    return PhoneNumberUtils.isGlobalPhoneNumber(b.qa(paramMallFormView.getText().toString()));
  }
  
  public final boolean bvo()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.c.1
 * JD-Core Version:    0.7.0.1
 */