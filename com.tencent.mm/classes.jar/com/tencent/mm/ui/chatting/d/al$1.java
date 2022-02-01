package com.tencent.mm.ui.chatting.d;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

final class al$1
  implements q.f
{
  al$1(al paramal, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(35463);
    if (this.WME)
    {
      paramo.d(1, this.WMG.fgR.WQv.getMMResources().getString(R.l.location_send_poi));
      paramo.d(2, this.WMG.fgR.WQv.getMMResources().getString(R.l.location_send_share));
      AppMethodBeat.o(35463);
      return;
    }
    if ((!al.a(this.WMG)) || (this.WMF))
    {
      paramo.d(1, this.WMG.fgR.WQv.getMMResources().getString(R.l.location_send_poi));
      AppMethodBeat.o(35463);
      return;
    }
    paramo.d(1, this.WMG.fgR.WQv.getMMResources().getString(R.l.location_send_poi));
    paramo.d(2, this.WMG.fgR.WQv.getMMResources().getString(R.l.location_send_share));
    AppMethodBeat.o(35463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.al.1
 * JD-Core Version:    0.7.0.1
 */