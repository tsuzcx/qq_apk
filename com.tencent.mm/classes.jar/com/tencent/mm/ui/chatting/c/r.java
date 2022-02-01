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

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.o.class)
public class r
  extends a
  implements com.tencent.mm.ui.chatting.c.b.o
{
  private long[] Gne = null;
  private boolean Gus = false;
  private com.tencent.mm.ui.chatting.o Gut = null;
  
  public final void eQA()
  {
    AppMethodBeat.i(35297);
    this.Gus = this.cOd.GzJ.getBooleanExtra("expose_edit_mode", false).booleanValue();
    this.Gne = this.cOd.GzJ.getArguments().getLongArray("expose_selected_ids");
    AppMethodBeat.o(35297);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35298);
    if ((this.Gus) && (this.Gut == null)) {
      this.Gut = new com.tencent.mm.ui.chatting.o(this.cOd, this.Gne);
    }
    AppMethodBeat.o(35298);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35299);
    super.eQC();
    if (this.Gut != null)
    {
      com.tencent.mm.ui.chatting.o localo = this.Gut;
      Object localObject = (i)localo.cOd.be(i.class);
      ((ae)localo.cOd.be(ae.class)).eYt();
      ((i)localObject).eWm();
      ((i)localObject).eWh();
      if (localo.Gne != null)
      {
        long[] arrayOfLong = localo.Gne;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          ((i)localObject).wA(arrayOfLong[i]);
          i += 1;
        }
      }
      localObject = ((q)localo.cOd.be(q.class)).eXs();
      if (localObject != null) {
        ((ChatFooter)localObject).setVisibility(8);
      }
      localObject = ((q)localo.cOd.be(q.class)).eXt();
      if (localObject != null) {
        ((ChatFooterCustom)localObject).setVisibility(8);
      }
      ((m)localo.cOd.be(m.class)).eXq();
      localo.cOd.hideVKB();
      ((ao)localo.cOd.be(ao.class)).eYR();
      localo.cOd.wk(true);
    }
    AppMethodBeat.o(35299);
  }
  
  public final boolean eXr()
  {
    return this.Gus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.r
 * JD-Core Version:    0.7.0.1
 */