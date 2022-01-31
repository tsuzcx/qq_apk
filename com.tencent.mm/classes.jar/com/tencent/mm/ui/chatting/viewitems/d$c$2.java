package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.bi;

final class d$c$2
  implements View.OnClickListener
{
  d$c$2(Boolean paramBoolean, long paramLong, String paramString, bi parambi) {}
  
  public final void onClick(View paramView)
  {
    if (!this.vCb.booleanValue())
    {
      l.z(this.byn, this.vCc);
      this.dUy.setStatus(1);
      au.Hx();
      c.Fy().fd(this.byn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.c.2
 * JD-Core Version:    0.7.0.1
 */