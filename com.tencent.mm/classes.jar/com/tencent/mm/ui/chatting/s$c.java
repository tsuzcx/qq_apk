package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.c.x;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.az;

public final class s$c
  implements i.a
{
  private a zzP;
  
  public s$c(a parama)
  {
    this.zzP = parama;
  }
  
  public final boolean eg(View paramView)
  {
    AppMethodBeat.i(30719);
    paramView = ((az)paramView.getTag()).userName;
    ab.i("MicroMsg.AvatarDoubleClickListener", "onDoubleClick: %s", new Object[] { paramView });
    if (!bo.isNullOrNil(paramView))
    {
      boolean bool = ((x)this.zzP.ay(x.class)).atV(paramView);
      AppMethodBeat.o(30719);
      return bool;
    }
    AppMethodBeat.o(30719);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.c
 * JD-Core Version:    0.7.0.1
 */