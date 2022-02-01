package com.tencent.mm.ui.chatting.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.ao;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.m;
import com.tencent.mm.ui.chatting.c.b.q;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.o.class)
public class r
  extends a
  implements com.tencent.mm.ui.chatting.c.b.o
{
  private long[] HMU = null;
  private boolean HUl = false;
  private com.tencent.mm.ui.chatting.o HUm = null;
  
  public final void fgg()
  {
    AppMethodBeat.i(35297);
    this.HUl = this.cLy.HZF.getBooleanExtra("expose_edit_mode", false).booleanValue();
    this.HMU = this.cLy.HZF.getArguments().getLongArray("expose_selected_ids");
    AppMethodBeat.o(35297);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35298);
    if ((this.HUl) && (this.HUm == null)) {
      this.HUm = new com.tencent.mm.ui.chatting.o(this.cLy, this.HMU);
    }
    AppMethodBeat.o(35298);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35299);
    super.fgi();
    if (this.HUm != null)
    {
      com.tencent.mm.ui.chatting.o localo = this.HUm;
      Object localObject = (i)localo.cLy.bf(i.class);
      ((ae)localo.cLy.bf(ae.class)).fof();
      ((i)localObject).flY();
      ((i)localObject).flT();
      if (localo.HMU != null)
      {
        long[] arrayOfLong = localo.HMU;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          ((i)localObject).Bd(arrayOfLong[i]);
          i += 1;
        }
      }
      localObject = ((q)localo.cLy.bf(q.class)).fne();
      if (localObject != null) {
        ((ChatFooter)localObject).setVisibility(8);
      }
      localObject = ((q)localo.cLy.bf(q.class)).fnf();
      if (localObject != null) {
        ((ChatFooterCustom)localObject).setVisibility(8);
      }
      ((m)localo.cLy.bf(m.class)).fnc();
      localo.cLy.hideVKB();
      ((ao)localo.cLy.bf(ao.class)).foH();
      localo.cLy.xo(true);
    }
    AppMethodBeat.o(35299);
  }
  
  public final boolean fnd()
  {
    return this.HUl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.r
 * JD-Core Version:    0.7.0.1
 */