package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class e$20
  implements View.OnClickListener
{
  e$20(e parame) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
    if ((this.pYP.pWz != null) && (this.pYP.pWz.get() != null) && (((c)this.pYP.pWz.get()).bQz()))
    {
      e.a(this.pYP).setEnabled(false);
      e.f(this.pYP).setEnabled(false);
      e.g(this.pYP).setVisibility(0);
      e.g(this.pYP).setText(a.e.voip_cancel_call);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.20
 * JD-Core Version:    0.7.0.1
 */