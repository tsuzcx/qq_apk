package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.d.a;

final class am$1
  implements View.OnClickListener
{
  am$1(am paramam, Boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31739);
    if (this.zIB.booleanValue())
    {
      paramView = this.zIC;
      Boolean localBoolean = Boolean.TRUE;
      am.a(paramView, localBoolean, localBoolean);
      ((o)this.zIC.caz.ay(o.class)).dIg().dof();
      AppMethodBeat.o(31739);
      return;
    }
    am.a(this.zIC, Boolean.TRUE, Boolean.FALSE);
    ((o)this.zIC.caz.ay(o.class)).dIg().setMode(2);
    AppMethodBeat.o(31739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.am.1
 * JD-Core Version:    0.7.0.1
 */