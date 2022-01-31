package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.sdk.platformtools.ab;

final class k$2
  implements Runnable
{
  k$2(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(81168);
    if (System.currentTimeMillis() - k.a(this.qzH) > 30000L)
    {
      ab.d("MicroMsg.scanner.ScanModeImage", "show scan img nothing recognize");
      this.qzH.qzg.kA(true);
      this.qzH.ivt.setVisibility(8);
      k.b(this.qzH).setText(2131302903);
      k.b(this.qzH).setVisibility(0);
      if (k.c(this.qzH) == null) {
        k.a(this.qzH, new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(81167);
            k.2.this.qzH.qzg.kA(false);
            k.2.this.qzH.ivt.setVisibility(0);
            k.2.this.qzH.ivt.setText(t.ge(t.qDQ, k.2.this.qzH.qzg.getContext().getString(2131302905)));
            k.b(k.2.this.qzH).setVisibility(8);
            k.a(k.2.this.qzH, System.currentTimeMillis());
            AppMethodBeat.o(81167);
            return false;
          }
        });
      }
      k.d(this.qzH).setOnTouchListener(k.c(this.qzH));
    }
    AppMethodBeat.o(81168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.k.2
 * JD-Core Version:    0.7.0.1
 */