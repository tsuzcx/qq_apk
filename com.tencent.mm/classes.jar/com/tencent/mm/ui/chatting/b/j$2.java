package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class j$2
  implements View.OnClickListener
{
  j$2(j paramj) {}
  
  public final void onClick(View paramView)
  {
    paramView = (g)this.vpr.byx.ac(g.class);
    if (paramView.bug() == 0)
    {
      y.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
      return;
    }
    Activity localActivity = this.vpr.byx.vtz.getContext();
    h.a(localActivity, localActivity.getString(R.l.confirm_delete), "", localActivity.getString(R.l.delete_message), localActivity.getString(R.l.app_cancel), new j.2.1(this, localActivity, paramView), null, R.e.alert_btn_color_warn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.2
 * JD-Core Version:    0.7.0.1
 */