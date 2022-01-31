package com.tencent.mm.ui.chatting.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.l;
import com.tencent.mm.ui.chatting.c.b.n;
import com.tencent.mm.ui.chatting.c.b.z;

@com.tencent.mm.ui.chatting.c.a.a(dJy=n.class)
public class p
  extends a
  implements n
{
  private boolean zFI = false;
  private com.tencent.mm.ui.chatting.o zFJ = null;
  private long[] zyE = null;
  
  public final void dBY()
  {
    AppMethodBeat.i(31404);
    this.zFI = this.caz.zJz.getBooleanExtra("expose_edit_mode", false).booleanValue();
    this.zyE = this.caz.zJz.getArguments().getLongArray("expose_selected_ids");
    AppMethodBeat.o(31404);
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31405);
    if ((this.zFI) && (this.zFJ == null)) {
      this.zFJ = new com.tencent.mm.ui.chatting.o(this.caz, this.zyE);
    }
    AppMethodBeat.o(31405);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31406);
    super.dCa();
    if (this.zFJ != null)
    {
      com.tencent.mm.ui.chatting.o localo = this.zFJ;
      Object localObject = (h)localo.caz.ay(h.class);
      ((z)localo.caz.ay(z.class)).dIY();
      ((h)localObject).dHf();
      ((h)localObject).dHa();
      if (localo.zyE != null)
      {
        long[] arrayOfLong = localo.zyE;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          ((h)localObject).oC(arrayOfLong[i]);
          i += 1;
        }
      }
      localObject = ((com.tencent.mm.ui.chatting.c.b.o)localo.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class)).dIg();
      if (localObject != null) {
        ((ChatFooter)localObject).setVisibility(8);
      }
      localObject = ((com.tencent.mm.ui.chatting.c.b.o)localo.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class)).dIh();
      if (localObject != null) {
        ((ChatFooterCustom)localObject).setVisibility(8);
      }
      ((l)localo.caz.ay(l.class)).dIe();
      localo.caz.hideVKB();
      ((aj)localo.caz.ay(aj.class)).dJw();
      localo.caz.qZ(true);
    }
    AppMethodBeat.o(31406);
  }
  
  public final boolean dIf()
  {
    return this.zFI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.p
 * JD-Core Version:    0.7.0.1
 */