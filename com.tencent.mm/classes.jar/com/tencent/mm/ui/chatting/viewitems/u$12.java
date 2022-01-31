package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class u$12
  implements View.OnClickListener
{
  u$12(u paramu) {}
  
  public final void onClick(View paramView)
  {
    aw localaw = (aw)paramView.getTag();
    y.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", new Object[] { localaw.userName });
    Object localObject = bn.s(localaw.bWO.field_content, "msg");
    if ((localObject != null) && (((Map)localObject).size() != 0)) {
      bk.getInt((String)((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
    }
    localObject = this.vDZ;
    paramView.getContext();
    u.a((u)localObject, localaw.userName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.12
 * JD-Core Version:    0.7.0.1
 */