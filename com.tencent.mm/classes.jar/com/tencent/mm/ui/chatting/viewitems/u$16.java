package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.e;
import java.util.Map;

final class u$16
  implements View.OnClickListener
{
  u$16(u paramu) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = (aw)paramView.getTag();
    Object localObject2 = bn.s(((c)localObject1).bWO.field_content, "msg");
    if (localObject2 == null) {
      y.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
    }
    int i;
    do
    {
      return;
      i = bk.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
      if (i == 1)
      {
        String str1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_username");
        String str2 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_path");
        i = bk.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
        int j = bk.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
        paramView = bk.pm((String)((Map)localObject2).get(".msg.appmsg.template_id"));
        y.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { str1 });
        localObject2 = new AppBrandStatObject();
        ((AppBrandStatObject)localObject2).bFv = (((aw)localObject1).bWO.field_msgSvrId + ":" + ((aw)localObject1).userName + ":" + u.b(this.vDZ).getTalkerUserName() + ":" + paramView);
        if (((com.tencent.mm.plugin.biz.a.a)g.r(com.tencent.mm.plugin.biz.a.a.class)).gr(((aw)localObject1).userName))
        {
          ((AppBrandStatObject)localObject2).scene = 1014;
          ((com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(u.b(this.vDZ).vtz.getContext(), str1, null, j, i, str2, (AppBrandStatObject)localObject2);
          u.C(9, u.c(this.vDZ), u.d(this.vDZ));
          h.nFQ.f(11608, new Object[] { u.d(this.vDZ), ((aw)localObject1).userName, Integer.valueOf(0) });
          return;
        }
        ((AppBrandStatObject)localObject2).scene = 1043;
        paramView = f.kX(((aw)localObject1).userName);
        com.tencent.mm.plugin.appbrand.r.d locald = (com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class);
        Activity localActivity = u.b(this.vDZ).vtz.getContext();
        if (paramView == null) {}
        for (paramView = null;; paramView = paramView.field_appId)
        {
          locald.a(localActivity, str1, null, j, i, str2, (AppBrandStatObject)localObject2, paramView);
          break;
        }
      }
    } while (i != 2);
    localObject1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_username");
    long l = bk.getLong((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
    u.b(paramView.getContext(), (String)localObject1, l);
    y.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { localObject1, Long.valueOf(l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.16
 * JD-Core Version:    0.7.0.1
 */