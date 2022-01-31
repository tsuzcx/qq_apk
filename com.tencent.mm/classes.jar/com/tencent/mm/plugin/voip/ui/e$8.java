package com.tencent.mm.plugin.voip.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;

final class e$8
  implements Runnable
{
  e$8(e parame) {}
  
  public final void run()
  {
    y.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
    e.u(this.pYP);
    if ((this.pYP.getActivity() == null) || (this.pYP.getActivity().isFinishing())) {}
    while (e.v(this.pYP) > 0) {
      return;
    }
    e.s(this.pYP).setVisibility(8);
    e.w(this.pYP).setVisibility(8);
    e.x(this.pYP).setVisibility(8);
    e.a(this.pYP).setVisibility(8);
    e.b(this.pYP).setVisibility(8);
    e.e(this.pYP, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.8
 * JD-Core Version:    0.7.0.1
 */