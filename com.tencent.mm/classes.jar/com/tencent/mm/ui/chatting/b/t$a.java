package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.b.a.m;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.x;

final class t$a
  extends v
{
  t$a(t paramt) {}
  
  public final void xQ()
  {
    if (com.tencent.mm.model.s.hb(this.vqY.byx.getTalkerUserName()))
    {
      localObject = new m();
      ((m)localObject).ciU = this.vqY.byx.getTalkerUserName();
      ((m)localObject).ciV = 4L;
      ((m)localObject).QX();
    }
    this.vqY.byx.XM();
    if (com.tencent.mm.model.s.hP(this.vqY.byx.getTalkerUserName())) {
      this.vqY.byx.vtz.getContext().startActivity(new Intent(this.vqY.byx.vtz.getContext(), ServiceNotifySettingsUI.class));
    }
    do
    {
      return;
      if (com.tencent.mm.model.s.hh(this.vqY.byx.getTalkerUserName()))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", this.vqY.byx.getTalkerUserName());
        d.b(this.vqY.byx.vtz.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
        return;
      }
      if (((com.tencent.mm.ui.chatting.b.b.s)this.vqY.byx.ac(com.tencent.mm.ui.chatting.b.b.s.class)).cEW())
      {
        t.a(this.vqY);
        return;
      }
    } while (((c)this.vqY.byx.ac(c.class)).cDQ());
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.vqY.byx.vtz.getContext(), SingleChatInfoUI.class);
    ((Intent)localObject).putExtra("Single_Chat_Talker", this.vqY.byx.getTalkerUserName());
    ((Intent)localObject).putExtra("fromChatting", true);
    this.vqY.byx.vtz.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.t.a
 * JD-Core Version:    0.7.0.1
 */