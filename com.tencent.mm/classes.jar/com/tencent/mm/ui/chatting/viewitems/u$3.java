package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.e;

final class u$3
  implements View.OnClickListener
{
  u$3(u paramu, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4) {}
  
  public final void onClick(View paramView)
  {
    paramView = (aw)paramView.getTag();
    y.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { this.vEh });
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.bFv = (paramView.bWO.field_msgSvrId + ":" + paramView.userName + ":" + u.b(this.vDZ).getTalkerUserName() + ":" + this.gBq);
    if (((com.tencent.mm.plugin.biz.a.a)g.r(com.tencent.mm.plugin.biz.a.a.class)).gr(paramView.userName))
    {
      localAppBrandStatObject.scene = 1014;
      ((com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(u.b(this.vDZ).vtz.getContext(), this.vEh, null, this.vEi, this.vEj, this.vEk, localAppBrandStatObject);
      u.C(9, u.c(this.vDZ), u.d(this.vDZ));
      h.nFQ.f(11608, new Object[] { u.d(this.vDZ), this.rzx, Integer.valueOf(1) });
      return;
    }
    localAppBrandStatObject.scene = 1043;
    paramView = f.kX(paramView.userName);
    com.tencent.mm.plugin.appbrand.r.d locald = (com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class);
    Activity localActivity = u.b(this.vDZ).vtz.getContext();
    String str1 = this.vEh;
    int i = this.vEi;
    int j = this.vEj;
    String str2 = this.vEk;
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.field_appId)
    {
      locald.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramView);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.3
 * JD-Core Version:    0.7.0.1
 */