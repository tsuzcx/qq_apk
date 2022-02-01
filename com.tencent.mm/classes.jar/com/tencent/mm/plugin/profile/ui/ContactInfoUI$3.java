package com.tencent.mm.plugin.profile.ui;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class ContactInfoUI$3
  implements h
{
  ContactInfoUI$3(ContactInfoUI paramContactInfoUI) {}
  
  public final Object a(u paramu)
  {
    AppMethodBeat.i(26969);
    switch (paramu.type)
    {
    default: 
      AppMethodBeat.o(26969);
      return null;
    }
    if (ContactInfoUI.e(this.uAr) != null)
    {
      paramu = ContactInfoUI.e(this.uAr).field_username;
      AppMethodBeat.o(26969);
      return paramu;
    }
    AppMethodBeat.o(26969);
    return null;
  }
  
  public final Object b(u paramu)
  {
    AppMethodBeat.i(26970);
    if (paramu.type == 45)
    {
      String str = new String(Base64.decode(paramu.url, 0));
      paramu = new String(Base64.decode(bt.by((String)paramu.aV(String.class), ""), 0));
      ad.d("MicroMsg.ContactInfoUI", "appId:%s,path:%s", new Object[] { str, paramu });
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1082;
      if (ContactInfoUI.e(this.uAr) != null) {
        localAppBrandStatObject.dbt = (ContactInfoUI.e(this.uAr).field_username + "|2");
      }
      ((n)g.ab(n.class)).a(this.uAr.getContext(), null, str, 0, 0, paramu, localAppBrandStatObject);
    }
    AppMethodBeat.o(26970);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.3
 * JD-Core Version:    0.7.0.1
 */