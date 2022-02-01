package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.u;

@com.tencent.mm.ui.chatting.d.a.a(gRF=s.class)
public class v
  extends a
  implements s
{
  private long[] PgO = null;
  private boolean Ppw = false;
  private com.tencent.mm.ui.chatting.p Ppx = null;
  
  public final void gIk()
  {
    AppMethodBeat.i(35297);
    this.Ppw = this.dom.Pwc.getBooleanExtra("expose_edit_mode", false).booleanValue();
    this.PgO = this.dom.Pwc.getArguments().getLongArray("expose_selected_ids");
    AppMethodBeat.o(35297);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35298);
    if ((this.Ppw) && (this.Ppx == null)) {
      this.Ppx = new com.tencent.mm.ui.chatting.p(this.dom, this.PgO);
    }
    AppMethodBeat.o(35298);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35299);
    super.gIm();
    if (this.Ppx != null)
    {
      com.tencent.mm.ui.chatting.p localp = this.Ppx;
      Object localObject = (k)localp.dom.bh(k.class);
      ((am)localp.dom.bh(am.class)).gQW();
      ((k)localObject).gOz();
      ((k)localObject).gOt();
      if (localp.PgO != null)
      {
        long[] arrayOfLong = localp.PgO;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          ((k)localObject).Nu(arrayOfLong[i]);
          i += 1;
        }
      }
      localObject = ((u)localp.dom.bh(u.class)).gPO();
      if (localObject != null) {
        ((ChatFooter)localObject).setVisibility(8);
      }
      localObject = ((u)localp.dom.bh(u.class)).gPP();
      if (localObject != null) {
        ((ChatFooterCustom)localObject).setVisibility(8);
      }
      ((com.tencent.mm.ui.chatting.d.b.p)localp.dom.bh(com.tencent.mm.ui.chatting.d.b.p.class)).gPM();
      localp.dom.hideVKB();
      ((aw)localp.dom.bh(aw.class)).gRy();
      localp.dom.BW(true);
    }
    AppMethodBeat.o(35299);
  }
  
  public final boolean gPN()
  {
    return this.Ppw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.v
 * JD-Core Version:    0.7.0.1
 */