package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.c.a;

final class ak$1
  implements View.OnClickListener
{
  ak$1(ak paramak, Boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    if (this.vsN.booleanValue())
    {
      ak.a(this.vsO, Boolean.valueOf(true), Boolean.valueOf(true));
      ((n)this.vsO.byx.ac(n.class)).cEq().cnd();
      return;
    }
    ak.a(this.vsO, Boolean.valueOf(true), Boolean.valueOf(false));
    ((n)this.vsO.byx.ac(n.class)).cEq().setMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ak.1
 * JD-Core Version:    0.7.0.1
 */