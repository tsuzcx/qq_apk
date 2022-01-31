package com.tencent.mm.ui.chatting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class AppBrandServiceChattingUI$a$1
  implements ChatFooter.e
{
  AppBrandServiceChattingUI$a$1(AppBrandServiceChattingUI.a parama) {}
  
  public final boolean me(boolean paramBoolean)
  {
    if (AppBrandServiceChattingUI.a.a(this.vhk) != null)
    {
      WxaAttributes.b.a locala = (WxaAttributes.b.a)AppBrandServiceChattingUI.a.a(this.vhk).fRi.get(0);
      if ((AppBrandServiceChattingUI.a.b(this.vhk) == 2) && (AppBrandServiceChattingUI.a.c(this.vhk).username.equals(locala.userName)))
      {
        y.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[] { locala.userName, locala.bFw });
        AppBrandServiceChattingUI.a.a(this.vhk, locala.bFw);
        return true;
      }
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1080;
      ((d)g.r(d.class)).a(this.vhk.getContext(), locala.userName, "", 0, locala.version, locala.bFw, localAppBrandStatObject, AppBrandServiceChattingUI.a.d(this.vhk));
      return true;
    }
    y.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.1
 * JD-Core Version:    0.7.0.1
 */