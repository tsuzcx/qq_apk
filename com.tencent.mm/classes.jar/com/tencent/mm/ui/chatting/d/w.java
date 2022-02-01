package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.ax;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.u;

@com.tencent.mm.ui.chatting.d.a.a(hRc=s.class)
public class w
  extends a
  implements s
{
  private long[] WAh = null;
  private boolean WJR = false;
  private com.tencent.mm.ui.chatting.p WJS = null;
  
  public final void hGU()
  {
    AppMethodBeat.i(35297);
    this.WJR = this.fgR.WQv.getBooleanExtra("expose_edit_mode", false).booleanValue();
    this.WAh = this.fgR.WQv.getArguments().getLongArray("expose_selected_ids");
    AppMethodBeat.o(35297);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35298);
    if ((this.WJR) && (this.WJS == null)) {
      this.WJS = new com.tencent.mm.ui.chatting.p(this.fgR, this.WAh);
    }
    AppMethodBeat.o(35298);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35299);
    super.hGW();
    if (this.WJS != null)
    {
      com.tencent.mm.ui.chatting.p localp = this.WJS;
      Object localObject = (k)localp.fgR.bC(k.class);
      ((an)localp.fgR.bC(an.class)).hQt();
      ((k)localObject).hNL();
      ((k)localObject).hNE();
      if (localp.WAh != null)
      {
        long[] arrayOfLong = localp.WAh;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          ((k)localObject).VC(arrayOfLong[i]);
          i += 1;
        }
      }
      localObject = ((u)localp.fgR.bC(u.class)).hPj();
      if (localObject != null) {
        ((ChatFooter)localObject).setVisibility(8);
      }
      localObject = ((u)localp.fgR.bC(u.class)).hPk();
      if (localObject != null) {
        ((ChatFooterCustom)localObject).setVisibility(8);
      }
      ((com.tencent.mm.ui.chatting.d.b.p)localp.fgR.bC(com.tencent.mm.ui.chatting.d.b.p.class)).hPg();
      localp.fgR.hideVKB();
      ((ax)localp.fgR.bC(ax.class)).hQV();
      localp.fgR.Gr(true);
    }
    AppMethodBeat.o(35299);
  }
  
  public final boolean hPi()
  {
    return this.WJR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.w
 * JD-Core Version:    0.7.0.1
 */