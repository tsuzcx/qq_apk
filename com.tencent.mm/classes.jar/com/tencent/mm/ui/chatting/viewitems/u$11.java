package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import java.util.Map;

final class u$11
  implements View.OnClickListener
{
  u$11(u paramu) {}
  
  public final void onClick(View paramView)
  {
    paramView = (aw)paramView.getTag();
    y.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", new Object[] { paramView.userName });
    Object localObject2 = bn.s(paramView.bWO.field_content, "msg");
    Object localObject1 = bk.pm((String)((Map)localObject2).get(".msg.fromusername"));
    h.nFQ.f(11608, new Object[] { u.d(this.vDZ), localObject1, Integer.valueOf(66666) });
    localObject1 = bk.pm((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_username"));
    if (bk.bl((String)localObject1))
    {
      paramView = bk.pm((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.header_jump_url"));
      if (!bk.bl(paramView))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        com.tencent.mm.br.d.b(u.b(this.vDZ).vtz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      return;
    }
    String str = bk.pm((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_path"));
    int i = bk.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
    int j = bk.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
    localObject2 = bk.pm((String)((Map)localObject2).get(".msg.appmsg.template_id"));
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.bFv = (paramView.bWO.field_msgSvrId + ":" + paramView.userName + ":" + u.b(this.vDZ).getTalkerUserName() + ":" + (String)localObject2);
    localAppBrandStatObject.scene = 1014;
    ((com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(u.b(this.vDZ).vtz.getContext(), (String)localObject1, null, i, j, str, localAppBrandStatObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.11
 * JD-Core Version:    0.7.0.1
 */