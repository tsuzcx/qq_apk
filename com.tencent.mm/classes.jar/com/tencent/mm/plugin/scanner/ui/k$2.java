package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.y;

final class k$2
  implements Runnable
{
  k$2(k paramk) {}
  
  public final void run()
  {
    if (System.currentTimeMillis() - k.a(this.nMa) > 30000L)
    {
      y.d("MicroMsg.scanner.ScanModeImage", "show scan img nothing recognize");
      this.nMa.nLB.ix(true);
      this.nMa.gSy.setVisibility(8);
      k.b(this.nMa).setText(R.l.scan_img_nothing_recognize);
      k.b(this.nMa).setVisibility(0);
      if (k.c(this.nMa) == null) {
        k.a(this.nMa, new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            k.2.this.nMa.nLB.ix(false);
            k.2.this.nMa.gSy.setVisibility(0);
            k.2.this.nMa.gSy.setText(r.eD(r.nPX, k.2.this.nMa.nLB.getContext().getString(R.l.scan_img_tips_focus)));
            k.b(k.2.this.nMa).setVisibility(8);
            k.a(k.2.this.nMa, System.currentTimeMillis());
            return false;
          }
        });
      }
      k.d(this.nMa).setOnTouchListener(k.c(this.nMa));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.k.2
 * JD-Core Version:    0.7.0.1
 */