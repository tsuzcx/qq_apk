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
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.Map;

final class x$16
  implements View.OnClickListener
{
  x$16(x paramx) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33145);
    Object localObject1 = (az)paramView.getTag();
    Object localObject2 = br.F(((c)localObject1).cEE.field_content, "msg");
    if (localObject2 == null)
    {
      ab.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
      AppMethodBeat.o(33145);
      return;
    }
    int i = bo.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
    if (i == 1)
    {
      String str1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_username");
      String str2 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_path");
      i = bo.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
      int j = bo.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
      paramView = bo.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
      ab.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { str1 });
      localObject2 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject2).cmF = (((az)localObject1).cEE.field_msgSvrId + ":" + ((az)localObject1).userName + ":" + x.b(this.zVk).getTalkerUserName() + ":" + paramView);
      if (((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).na(((az)localObject1).userName))
      {
        ((AppBrandStatObject)localObject2).scene = x.aup(paramView);
        ((j)g.E(j.class)).a(x.b(this.zVk).zJz.getContext(), str1, null, j, i, str2, (AppBrandStatObject)localObject2);
        x.K(9, x.c(this.zVk), x.d(this.zVk));
        h.qsU.e(11608, new Object[] { x.d(this.zVk), ((az)localObject1).userName, Integer.valueOf(0) });
        AppMethodBeat.o(33145);
        return;
      }
      ((AppBrandStatObject)localObject2).scene = 1043;
      paramView = f.rS(((az)localObject1).userName);
      j localj = (j)g.E(j.class);
      Activity localActivity = x.b(this.zVk).zJz.getContext();
      if (paramView == null) {}
      for (paramView = null;; paramView = paramView.field_appId)
      {
        localj.a(localActivity, str1, null, j, i, str2, (AppBrandStatObject)localObject2, paramView);
        break;
      }
    }
    if (i == 2)
    {
      localObject1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_username");
      long l = bo.getLong((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1L);
      x.b(paramView.getContext(), (String)localObject1, l);
      ab.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[] { localObject1, Long.valueOf(l) });
    }
    AppMethodBeat.o(33145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.16
 * JD-Core Version:    0.7.0.1
 */