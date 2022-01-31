package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class f$6
  implements View.OnClickListener
{
  f$6(f paramf) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
    h.nFQ.a(11526, true, true, new Object[] { Integer.valueOf(b.bPx().bRd()), Long.valueOf(b.bPx().bRe()), Long.valueOf(b.bPx().bRf()), Integer.valueOf(2) });
    if ((this.pZw.pWz != null) && (this.pZw.pWz.get() != null) && (((c)this.pZw.pWz.get()).bQy()))
    {
      f.c(this.pZw).setEnabled(false);
      f.d(this.pZw).setText(a.e.voip_waitting);
      this.pZw.pWW.a(f.e(this.pZw), d.pWP);
      f.f(this.pZw).setVisibility(0);
      f.g(this.pZw).setVisibility(8);
      f.c(this.pZw).setVisibility(8);
      f.h(this.pZw).setVisibility(8);
      f.i(this.pZw).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.f.6
 * JD-Core Version:    0.7.0.1
 */