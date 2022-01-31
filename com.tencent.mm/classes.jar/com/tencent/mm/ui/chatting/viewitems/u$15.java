package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class u$15
  implements View.OnClickListener
{
  u$15(u paramu) {}
  
  public final void onClick(View paramView)
  {
    aw localaw = (aw)paramView.getTag();
    y.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { localaw.userName });
    rc localrc = new rc();
    localrc.caq.userName = localaw.userName;
    localrc.caq.cas = localaw.vHp;
    Map localMap = bn.s(localaw.bWO.field_content, "msg");
    String str = "";
    paramView = str;
    if (localMap != null)
    {
      paramView = str;
      if (localMap.size() > 0)
      {
        localrc.caq.cat = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
        paramView = bk.pm((String)localMap.get(".msg.appmsg.template_id"));
      }
    }
    localrc.caq.cax = true;
    localrc.caq.scene = 1014;
    localrc.caq.bFv = (localaw.bWO.field_msgSvrId + ":" + localaw.userName + ":" + u.b(this.vDZ).getTalkerUserName() + ":" + paramView);
    com.tencent.mm.sdk.b.a.udP.m(localrc);
    u.C(9, u.c(this.vDZ), u.d(this.vDZ));
    h.nFQ.f(11608, new Object[] { u.d(this.vDZ), localaw.userName, Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.15
 * JD-Core Version:    0.7.0.1
 */