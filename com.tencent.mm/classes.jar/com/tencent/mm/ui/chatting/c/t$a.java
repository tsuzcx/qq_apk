package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.u;

final class t$a
  extends u
{
  t$a(t paramt) {}
  
  public final void Ki()
  {
    AppMethodBeat.i(31492);
    if (com.tencent.mm.model.t.nK(this.zGC.caz.getTalkerUserName()))
    {
      localObject = new v();
      ((v)localObject).fq(this.zGC.caz.getTalkerUserName());
      ((v)localObject).cTE = 4L;
      ((v)localObject).ake();
    }
    this.zGC.caz.hideVKB();
    if (com.tencent.mm.model.t.oy(this.zGC.caz.getTalkerUserName()))
    {
      this.zGC.caz.zJz.getContext().startActivity(new Intent(this.zGC.caz.zJz.getContext(), ServiceNotifySettingsUI.class));
      AppMethodBeat.o(31492);
      return;
    }
    if (com.tencent.mm.model.t.nQ(this.zGC.caz.getTalkerUserName()))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", this.zGC.caz.getTalkerUserName());
      com.tencent.mm.bq.d.b(this.zGC.caz.zJz.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
      AppMethodBeat.o(31492);
      return;
    }
    if (((com.tencent.mm.ui.chatting.c.b.t)this.zGC.caz.ay(com.tencent.mm.ui.chatting.c.b.t.class)).dIO())
    {
      t.a(this.zGC);
      AppMethodBeat.o(31492);
      return;
    }
    if (((com.tencent.mm.ui.chatting.c.b.d)this.zGC.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHG())
    {
      AppMethodBeat.o(31492);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.zGC.caz.zJz.getContext(), SingleChatInfoUI.class);
    ((Intent)localObject).putExtra("Single_Chat_Talker", this.zGC.caz.getTalkerUserName());
    ((Intent)localObject).putExtra("fromChatting", true);
    this.zGC.caz.zJz.startActivity((Intent)localObject);
    AppMethodBeat.o(31492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t.a
 * JD-Core Version:    0.7.0.1
 */