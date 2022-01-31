package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class x$15
  implements View.OnClickListener
{
  x$15(x paramx) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33144);
    az localaz = (az)paramView.getTag();
    ab.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { localaz.userName });
    so localso = new so();
    localso.cIQ.userName = localaz.userName;
    localso.cIQ.cIS = localaz.hAg;
    Map localMap = br.F(localaz.cEE.field_content, "msg");
    String str = "";
    paramView = str;
    if (localMap != null)
    {
      paramView = str;
      if (localMap.size() > 0)
      {
        localso.cIQ.cIT = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
        paramView = bo.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
      }
    }
    localso.cIQ.cIW = true;
    localso.cIQ.scene = x.aup(paramView);
    localso.cIQ.cmF = (localaz.cEE.field_msgSvrId + ":" + localaz.userName + ":" + x.b(this.zVk).getTalkerUserName() + ":" + paramView);
    com.tencent.mm.sdk.b.a.ymk.l(localso);
    x.K(9, x.c(this.zVk), x.d(this.zVk));
    h.qsU.e(11608, new Object[] { x.d(this.zVk), localaz.userName, Integer.valueOf(0) });
    AppMethodBeat.o(33144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.15
 * JD-Core Version:    0.7.0.1
 */