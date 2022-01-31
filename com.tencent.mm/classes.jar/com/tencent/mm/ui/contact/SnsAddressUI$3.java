package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import java.util.HashSet;

final class SnsAddressUI$3
  implements MultiSelectContactView.c
{
  SnsAddressUI$3(SnsAddressUI paramSnsAddressUI) {}
  
  public final void wK(String paramString)
  {
    AppMethodBeat.i(33925);
    if (paramString != null)
    {
      SnsAddressUI.a(this.Afv).remove(paramString);
      SnsAddressUI.b(this.Afv);
    }
    AppMethodBeat.o(33925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI.3
 * JD-Core Version:    0.7.0.1
 */