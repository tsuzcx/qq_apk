package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.q;
import com.tencent.mm.ui.chatting.d.b.s;

@com.tencent.mm.ui.chatting.d.a.a(fFo=q.class)
public class t
  extends a
  implements q
{
  private long[] JAK = null;
  private boolean JIJ = false;
  private com.tencent.mm.ui.chatting.o JIK = null;
  
  public final boolean fDB()
  {
    return this.JIJ;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35297);
    this.JIJ = this.cWM.JOR.getBooleanExtra("expose_edit_mode", false).booleanValue();
    this.JAK = this.cWM.JOR.getArguments().getLongArray("expose_selected_ids");
    AppMethodBeat.o(35297);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35298);
    if ((this.JIJ) && (this.JIK == null)) {
      this.JIK = new com.tencent.mm.ui.chatting.o(this.cWM, this.JAK);
    }
    AppMethodBeat.o(35298);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35299);
    super.fwu();
    if (this.JIK != null)
    {
      com.tencent.mm.ui.chatting.o localo = this.JIK;
      Object localObject = (k)localo.cWM.bh(k.class);
      ((ai)localo.cWM.bh(ai.class)).fEJ();
      ((k)localObject).fCr();
      ((k)localObject).fCl();
      if (localo.JAK != null)
      {
        long[] arrayOfLong = localo.JAK;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          ((k)localObject).DR(arrayOfLong[i]);
          i += 1;
        }
      }
      localObject = ((s)localo.cWM.bh(s.class)).fDC();
      if (localObject != null) {
        ((ChatFooter)localObject).setVisibility(8);
      }
      localObject = ((s)localo.cWM.bh(s.class)).fDD();
      if (localObject != null) {
        ((ChatFooterCustom)localObject).setVisibility(8);
      }
      ((com.tencent.mm.ui.chatting.d.b.o)localo.cWM.bh(com.tencent.mm.ui.chatting.d.b.o.class)).fDA();
      localo.cWM.hideVKB();
      ((as)localo.cWM.bh(as.class)).fFl();
      localo.cWM.ya(true);
    }
    AppMethodBeat.o(35299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.t
 * JD-Core Version:    0.7.0.1
 */