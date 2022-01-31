package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Locale;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    c localc = this.woz;
    if (c.a(this.woz) == null) {}
    for (paramView = null;; paramView = String.format(Locale.US, "%02d:%02d", new Object[] { paramView.getCurrentHour(), paramView.getCurrentMinute() }))
    {
      c.a(localc, true, paramView);
      return;
      paramView = c.a(this.woz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.c.1
 * JD-Core Version:    0.7.0.1
 */