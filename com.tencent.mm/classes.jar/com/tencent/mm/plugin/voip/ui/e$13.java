package com.tencent.mm.plugin.voip.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.TimerTask;

final class e$13
  extends TimerTask
{
  e$13(e parame) {}
  
  public final void run()
  {
    this.pYP.hcZ.post(new Runnable()
    {
      public final void run()
      {
        String str = e.ce(bk.cn(e.13.this.pYP.pWA));
        e.x(e.13.this.pYP).setText(str);
        e.y(e.13.this.pYP);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.13
 * JD-Core Version:    0.7.0.1
 */