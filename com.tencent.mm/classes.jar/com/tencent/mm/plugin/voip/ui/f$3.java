package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class f$3
  implements View.OnClickListener
{
  f$3(f paramf) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11619, new Object[] { Integer.valueOf(3) });
    if ((this.pZw.pWz != null) && (this.pZw.pWz.get() != null)) {
      ((c)this.pZw.pWz.get()).bQR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.f.3
 * JD-Core Version:    0.7.0.1
 */