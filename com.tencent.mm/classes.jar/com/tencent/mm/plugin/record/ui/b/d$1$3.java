package com.tencent.mm.plugin.record.ui.b;

import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.xv;

final class d$1$3
  implements PopupWindow.OnDismissListener
{
  d$1$3(d.1 param1, TextView paramTextView) {}
  
  public final void onDismiss()
  {
    this.dpT.setText(this.nuG.nuw.bNt.desc);
    j.h(this.dpT, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d.1.3
 * JD-Core Version:    0.7.0.1
 */