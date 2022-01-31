package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class x$8
  implements View.OnClickListener
{
  x$8(x paramx, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33135);
    paramView = (az)paramView.getTag();
    ab.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { this.zVs });
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.cmF = (paramView.cEE.field_msgSvrId + ":" + paramView.userName + ":" + x.b(this.zVk).getTalkerUserName() + ":" + this.hZl);
    if (((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).na(paramView.userName))
    {
      localAppBrandStatObject.scene = x.aup(this.hZl);
      ((j)g.E(j.class)).a(x.b(this.zVk).zJz.getContext(), this.zVs, null, this.zVt, this.zVu, this.zVv, localAppBrandStatObject);
      x.K(9, x.c(this.zVk), x.d(this.zVk));
      h.qsU.e(11608, new Object[] { x.d(this.zVk), this.vqy, Integer.valueOf(this.val$index) });
      AppMethodBeat.o(33135);
      return;
    }
    localAppBrandStatObject.scene = 1043;
    paramView = f.rS(paramView.userName);
    j localj = (j)g.E(j.class);
    Activity localActivity = x.b(this.zVk).zJz.getContext();
    String str1 = this.zVs;
    int i = this.zVt;
    int j = this.zVu;
    String str2 = this.zVv;
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.field_appId)
    {
      localj.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramView);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.8
 * JD-Core Version:    0.7.0.1
 */