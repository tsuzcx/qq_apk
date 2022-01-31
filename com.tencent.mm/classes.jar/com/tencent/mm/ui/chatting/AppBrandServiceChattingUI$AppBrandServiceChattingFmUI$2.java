package com.tencent.mm.ui.chatting;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.d.a;

final class AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$2
  implements com.tencent.mm.pluginsdk.ui.d.g
{
  AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$2(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI paramAppBrandServiceChattingFmUI) {}
  
  public final Object a(m paramm)
  {
    AppMethodBeat.i(30349);
    switch (paramm.type)
    {
    default: 
      AppMethodBeat.o(30349);
      return null;
    }
    paramm = this.zwg.caz.getTalkerUserName();
    AppMethodBeat.o(30349);
    return paramm;
  }
  
  public final Object b(m paramm)
  {
    AppMethodBeat.i(30350);
    if (paramm.type == 45)
    {
      String str = new String(Base64.decode(paramm.url, 0));
      paramm = new String(Base64.decode(bo.bf((String)paramm.ap(String.class), ""), 0));
      ab.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[] { str, paramm });
      if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(this.zwg) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).appId.equals(str)))
      {
        ab.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[] { str, paramm });
        AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(this.zwg, paramm);
        paramm = Boolean.TRUE;
        AppMethodBeat.o(30350);
        return paramm;
      }
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1081;
      ((j)com.tencent.mm.kernel.g.E(j.class)).a(this.zwg.getContext(), null, str, 0, 0, paramm, localAppBrandStatObject);
    }
    AppMethodBeat.o(30350);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.2
 * JD-Core Version:    0.7.0.1
 */