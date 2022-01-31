package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.widget.a.d;
import java.util.Map;

final class u$18
  implements View.OnClickListener
{
  u$18(u paramu, Map paramMap, boolean paramBoolean, bb parambb, bi parambi) {}
  
  public final void onClick(View paramView)
  {
    paramView = bk.pm((String)this.mcl.get(".msg.fromusername"));
    d locald = new d(u.b(this.vDZ).vtz.getContext(), 1, true);
    if (this.vEp) {
      locald.h(u.b(this.vDZ).vtz.getMMResources().getString(R.l.notify_message_settings_receive_app_brand_msg_title), 3);
    }
    for (;;)
    {
      locald.phH = new u.18.1(this);
      locald.phI = new u.18.2(this, paramView);
      locald.cfU();
      return;
      locald.h(u.b(this.vDZ).vtz.getMMResources().getString(R.l.notify_message_settings_ban_receive_app_brand_msg_title), 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.18
 * JD-Core Version:    0.7.0.1
 */