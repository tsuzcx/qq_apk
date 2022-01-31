package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class u$18$1
  implements n.c
{
  u$18$1(u.18 param18) {}
  
  public final void a(l paraml)
  {
    if (this.vEr.vEp)
    {
      paraml.a(1, u.b(this.vEr.vDZ).vtz.getMMResources().getColor(R.e.green_text_color), u.b(this.vEr.vDZ).vtz.getMMResources().getString(R.l.notify_message_settings_receive_app_brand_msg));
      return;
    }
    paraml.a(0, u.b(this.vEr.vDZ).vtz.getMMResources().getColor(R.e.red_text_color), u.b(this.vEr.vDZ).vtz.getMMResources().getString(R.l.notify_message_settings_ban_receive_app_brand_msg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.18.1
 * JD-Core Version:    0.7.0.1
 */