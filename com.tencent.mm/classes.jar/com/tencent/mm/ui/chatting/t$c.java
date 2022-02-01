package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.by;

public final class t$c
  implements c.a
{
  private a WBq;
  
  public t$c(a parama)
  {
    this.WBq = parama;
  }
  
  public final boolean fH(View paramView)
  {
    AppMethodBeat.i(34591);
    paramView = (by)paramView.getTag();
    if (paramView == null)
    {
      Log.w("MicroMsg.AvatarDoubleClickListener", "onDoubleClick tag null");
      AppMethodBeat.o(34591);
      return true;
    }
    paramView = paramView.userName;
    Log.i("MicroMsg.AvatarDoubleClickListener", "onDoubleClick: %s", new Object[] { paramView });
    if ((((PluginPatMsg)h.ag(PluginPatMsg.class)).isPatEnable()) && (((b)h.ae(b.class)).M(1, this.WBq.getTalkerUserName(), paramView)))
    {
      AppMethodBeat.o(34591);
      return false;
    }
    AppMethodBeat.o(34591);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.c
 * JD-Core Version:    0.7.0.1
 */