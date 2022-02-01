package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.o;
import com.tencent.mm.ui.chatting.d.b.q;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.p;

@com.tencent.mm.ui.chatting.d.a.a(fJv=q.class)
public class t
  extends a
  implements q
{
  private long[] JVB = null;
  private boolean KdF = false;
  private p KdG = null;
  
  public final void fAs()
  {
    AppMethodBeat.i(35297);
    this.KdF = this.cXJ.Kkd.getBooleanExtra("expose_edit_mode", false).booleanValue();
    this.JVB = this.cXJ.Kkd.getArguments().getLongArray("expose_selected_ids");
    AppMethodBeat.o(35297);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35298);
    if ((this.KdF) && (this.KdG == null)) {
      this.KdG = new p(this.cXJ, this.JVB);
    }
    AppMethodBeat.o(35298);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35299);
    super.fAu();
    if (this.KdG != null)
    {
      p localp = this.KdG;
      Object localObject = (k)localp.cXJ.bh(k.class);
      ((aj)localp.cXJ.bh(aj.class)).fIM();
      ((k)localObject).fGt();
      ((k)localObject).fGn();
      if (localp.JVB != null)
      {
        long[] arrayOfLong = localp.JVB;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          ((k)localObject).Eq(arrayOfLong[i]);
          i += 1;
        }
      }
      localObject = ((s)localp.cXJ.bh(s.class)).fHF();
      if (localObject != null) {
        ((ChatFooter)localObject).setVisibility(8);
      }
      localObject = ((s)localp.cXJ.bh(s.class)).fHG();
      if (localObject != null) {
        ((ChatFooterCustom)localObject).setVisibility(8);
      }
      ((o)localp.cXJ.bh(o.class)).fHD();
      localp.cXJ.hideVKB();
      ((at)localp.cXJ.bh(at.class)).fJo();
      localp.cXJ.yh(true);
    }
    AppMethodBeat.o(35299);
  }
  
  public final boolean fHE()
  {
    return this.KdF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.t
 * JD-Core Version:    0.7.0.1
 */