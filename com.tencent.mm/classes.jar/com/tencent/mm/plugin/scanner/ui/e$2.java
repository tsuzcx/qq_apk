package com.tencent.mm.plugin.scanner.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;

final class e$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  e$2(e parame) {}
  
  public final void onGlobalLayout()
  {
    y.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + e.b(this.nJB).getHeight() + ", summaryTv.getLineHeight() = " + e.b(this.nJB).getLineHeight());
    if ((e.b(this.nJB).getText() != null) && (e.b(this.nJB).getHeight() > 0) && (e.b(this.nJB).getLineHeight() > 0) && (e.d(this.nJB) == null))
    {
      if ((e.b(this.nJB).getHeight() / e.b(this.nJB).getLineHeight() > 5) && (!this.nJB.nJx) && (!this.nJB.nJw))
      {
        e.a(this.nJB).setVisibility(0);
        e.b(this.nJB).setMaxLines(5);
        this.nJB.nJx = true;
        if ((e.c(this.nJB) != null) && (e.c(this.nJB).LY(this.nJB.mKey) == null))
        {
          e.c(this.nJB).a(this.nJB.mKey, Boolean.valueOf(false));
          e.c(this.nJB).bxI();
        }
      }
      y.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + e.b(this.nJB).getHeight() / e.b(this.nJB).getLineHeight());
    }
    e.b(this.nJB).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.e.2
 * JD-Core Version:    0.7.0.1
 */