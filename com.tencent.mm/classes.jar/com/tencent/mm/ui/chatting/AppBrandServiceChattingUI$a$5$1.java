package com.tencent.mm.ui.chatting;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.ui.appbrand.b;

final class AppBrandServiceChattingUI$a$5$1
  implements Runnable
{
  AppBrandServiceChattingUI$a$5$1(AppBrandServiceChattingUI.a.5 param5) {}
  
  public final void run()
  {
    String str1 = b.acZ(this.vhm.vhk.byx.getTalkerUserName());
    if (TextUtils.isEmpty(str1)) {
      str1 = this.vhm.vhk.byx.getTalkerUserName();
    }
    for (String str2 = this.vhm.vhk.byx.cDP();; str2 = b.ada(str1))
    {
      AppBrandServiceChattingUI.a.f(this.vhm.vhk).username = this.vhm.vhk.byx.getTalkerUserName();
      AppBrandServiceChattingUI.a.f(this.vhm.vhk).hCQ = false;
      AppBrandServiceChattingUI.a.f(this.vhm.vhk).scene = AppBrandServiceChattingUI.a.b(this.vhm.vhk);
      AppBrandServiceChattingUI.a.f(this.vhm.vhk).uRI = AppBrandServiceChattingUI.a.g(this.vhm.vhk);
      if (AppBrandServiceChattingUI.a.b(this.vhm.vhk) != 2) {
        break label226;
      }
      AppBrandServiceChattingUI.a.f(this.vhm.vhk).hdB = AppBrandServiceChattingUI.a.c(this.vhm.vhk);
      if (!AppBrandServiceChattingUI.a.e(this.vhm.vhk)) {
        break;
      }
      AppBrandServiceChattingUI.a.f(this.vhm.vhk).show(1);
      return;
    }
    AppBrandServiceChattingUI.a.f(this.vhm.vhk).show(2);
    return;
    label226:
    WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = b.sv(str1);
    locala.from = 4;
    locala.username = str1;
    locala.nickname = str2;
    AppBrandServiceChattingUI.a.f(this.vhm.vhk).hdB = locala.aes();
    AppBrandServiceChattingUI.a.f(this.vhm.vhk).appId = AppBrandServiceChattingUI.a.d(this.vhm.vhk);
    if (AppBrandServiceChattingUI.a.e(this.vhm.vhk))
    {
      AppBrandServiceChattingUI.a.f(this.vhm.vhk).show(5);
      return;
    }
    AppBrandServiceChattingUI.a.f(this.vhm.vhk).show(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.5.1
 * JD-Core Version:    0.7.0.1
 */