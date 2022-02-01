package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bz;

public final class v$c
  implements c.a
{
  private a aeiK;
  
  public v$c(a parama)
  {
    this.aeiK = parama;
  }
  
  public final boolean iA(View paramView)
  {
    AppMethodBeat.i(34591);
    paramView = (bz)paramView.getTag();
    if (paramView == null)
    {
      Log.w("MicroMsg.AvatarDoubleClickListener", "onDoubleClick tag null");
      AppMethodBeat.o(34591);
      return true;
    }
    paramView = paramView.userName;
    Log.i("MicroMsg.AvatarDoubleClickListener", "onDoubleClick: %s", new Object[] { paramView });
    if ((((PluginPatMsg)h.az(PluginPatMsg.class)).isPatEnable()) && (((b)h.ax(b.class)).kM(this.aeiK.getTalkerUserName(), paramView)))
    {
      AppMethodBeat.o(34591);
      return false;
    }
    AppMethodBeat.o(34591);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v.c
 * JD-Core Version:    0.7.0.1
 */