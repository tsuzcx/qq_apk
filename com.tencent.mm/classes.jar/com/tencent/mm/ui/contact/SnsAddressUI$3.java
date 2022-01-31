package com.tencent.mm.ui.contact;

import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import java.util.HashSet;

final class SnsAddressUI$3
  implements MultiSelectContactView.a
{
  SnsAddressUI$3(SnsAddressUI paramSnsAddressUI) {}
  
  public final void pw(String paramString)
  {
    if (paramString != null)
    {
      SnsAddressUI.a(this.vNN).remove(paramString);
      SnsAddressUI.b(this.vNN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI.3
 * JD-Core Version:    0.7.0.1
 */