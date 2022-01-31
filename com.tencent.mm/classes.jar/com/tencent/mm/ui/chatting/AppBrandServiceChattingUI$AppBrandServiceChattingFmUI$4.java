package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.appbrand.c.a;
import com.tencent.mm.ui.chatting.d.a;

final class AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$4
  implements c.a
{
  AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$4(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI paramAppBrandServiceChattingFmUI) {}
  
  public final void dDw()
  {
    AppMethodBeat.i(30353);
    this.zwg.hideVKB();
    j.b localb = new j.b();
    localb.title = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(this.zwg);
    localb.type = 33;
    localb.fiX = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).username;
    if (bo.isNullOrNil(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(this.zwg))) {}
    for (Object localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).pageId;; localObject = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.f(this.zwg))
    {
      localb.fiW = ((String)localObject);
      localb.fiY = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).appId;
      localb.fjh = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).gXe;
      localb.fji = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).gXf;
      localb.fja = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).hko;
      localb.fiZ = 2;
      localb.url = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).hkp;
      localb.fjj = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).iconUrl;
      localb.cGT = ("wxapp_" + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).appId + AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).pageId);
      localb.cGN = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).username;
      localb.cGO = AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).nickname;
      localObject = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a((byte)0);
      AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(this.zwg));
      AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, localb);
      AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.b((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.g(this.zwg));
      AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.c((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.h(this.zwg));
      AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.d((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, this.zwg.caz.getTalkerUserName());
      AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.e((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.e(this.zwg));
      AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a.a((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a)localObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.i(this.zwg));
      aw.RO().ac((Runnable)localObject);
      AppMethodBeat.o(30353);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.4
 * JD-Core Version:    0.7.0.1
 */