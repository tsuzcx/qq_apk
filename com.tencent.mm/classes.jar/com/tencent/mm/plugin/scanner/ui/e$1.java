package com.tencent.mm.plugin.scanner.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;

final class e$1
  implements View.OnTouchListener
{
  e$1(e parame) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      y.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
      e.a(this.nJB).setVisibility(4);
      e.b(this.nJB).setMaxLines(2000);
      this.nJB.nJw = true;
      if (e.c(this.nJB) != null)
      {
        e.c(this.nJB).a(this.nJB.mKey, Boolean.valueOf(true));
        e.c(this.nJB).bxI();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.e.1
 * JD-Core Version:    0.7.0.1
 */