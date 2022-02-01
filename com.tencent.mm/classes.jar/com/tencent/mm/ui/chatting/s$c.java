package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.bk;

public final class s$c
  implements c.a
{
  private a JBI;
  
  public s$c(a parama)
  {
    this.JBI = parama;
  }
  
  public final boolean ex(View paramView)
  {
    AppMethodBeat.i(34591);
    paramView = (bk)paramView.getTag();
    if (paramView == null)
    {
      ad.w("MicroMsg.AvatarDoubleClickListener", "onDoubleClick tag null");
      AppMethodBeat.o(34591);
      return true;
    }
    paramView = paramView.userName;
    ad.i("MicroMsg.AvatarDoubleClickListener", "onDoubleClick: %s", new Object[] { paramView });
    if ((((PluginPatMsg)g.ad(PluginPatMsg.class)).isPatEnable()) && (((b)g.ab(b.class)).G(1, this.JBI.getTalkerUserName(), paramView)))
    {
      AppMethodBeat.o(34591);
      return false;
    }
    AppMethodBeat.o(34591);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.c
 * JD-Core Version:    0.7.0.1
 */