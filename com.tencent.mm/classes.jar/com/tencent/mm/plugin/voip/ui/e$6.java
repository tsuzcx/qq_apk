package com.tencent.mm.plugin.voip.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.voip.a.e;

final class e$6
  implements Runnable
{
  e$6(e parame) {}
  
  public final void run()
  {
    e.q(this.pYP).setText(a.e.voip_invite_waiting_tip);
    this.pYP.pWW.a(e.r(this.pYP), d.pWP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.6
 * JD-Core Version:    0.7.0.1
 */