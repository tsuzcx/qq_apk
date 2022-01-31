package com.tencent.mm.plugin.record.ui.b;

import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.aca;

final class d$2$3
  implements PopupWindow.OnDismissListener
{
  d$2$3(d.2 param2, TextView paramTextView) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(153641);
    TextView localTextView = this.ehq;
    if (this.qay.qaw) {}
    for (String str = this.qay.qak.cuL.desc;; str = this.qay.qax.pYY)
    {
      localTextView.setText(str);
      j.k(this.ehq, 1);
      AppMethodBeat.o(153641);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d.2.3
 * JD-Core Version:    0.7.0.1
 */