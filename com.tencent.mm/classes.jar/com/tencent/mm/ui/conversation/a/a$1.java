package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34628);
    if ((this.Amg.Amd != null) && (this.Amg.Amf != null))
    {
      paramView = this.Amg.Amd.QF(this.Amg.aug);
      this.Amg.Amf.ahA(paramView.Ami.id);
    }
    AppMethodBeat.o(34628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.a.1
 * JD-Core Version:    0.7.0.1
 */