package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class e$7
  implements View.OnClickListener
{
  e$7(e parame) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
    e.s(this.pYP).setEnabled(false);
    e.t(this.pYP);
    e.s(this.pYP).setEnabled(true);
    if ((this.pYP.pWz != null) && (this.pYP.pWz.get() != null)) {
      ((c)this.pYP.pWz.get()).bQC();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.7
 * JD-Core Version:    0.7.0.1
 */