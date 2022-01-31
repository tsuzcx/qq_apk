package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$1
  implements ChatFooter.e
{
  AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$1(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI paramAppBrandServiceChattingFmUI) {}
  
  public final boolean pu(boolean paramBoolean)
  {
    AppMethodBeat.i(30348);
    if (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(this.zwg) != null)
    {
      WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(this.zwg).hjU.get(0);
      if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(this.zwg) == 2) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).username.equals(locala.userName)))
      {
        ab.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.cmG });
        AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(this.zwg, locala.cmG);
        AppMethodBeat.o(30348);
        return true;
      }
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1080;
      ((j)g.E(j.class)).a(this.zwg.getContext(), locala.userName, "", 0, locala.version, locala.cmG, localAppBrandStatObject, AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.d(this.zwg));
    }
    for (;;)
    {
      AppMethodBeat.o(30348);
      return true;
      ab.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.1
 * JD-Core Version:    0.7.0.1
 */