package com.tencent.mm.plugin.scanner.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;

final class e$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  e$2(e parame) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(81019);
    ab.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + e.b(this.qxd).getHeight() + ", summaryTv.getLineHeight() = " + e.b(this.qxd).getLineHeight());
    if ((e.b(this.qxd).getText() != null) && (e.b(this.qxd).getHeight() > 0) && (e.b(this.qxd).getLineHeight() > 0) && (e.d(this.qxd) == null))
    {
      if ((e.b(this.qxd).getHeight() / e.b(this.qxd).getLineHeight() > 5) && (!this.qxd.qwZ) && (!this.qxd.qwY))
      {
        e.a(this.qxd).setVisibility(0);
        e.b(this.qxd).setMaxLines(5);
        this.qxd.qwZ = true;
        if ((e.c(this.qxd) != null) && (e.c(this.qxd).YA(this.qxd.mKey) == null))
        {
          e.c(this.qxd).a(this.qxd.mKey, Boolean.FALSE);
          e.c(this.qxd).ciJ();
        }
      }
      ab.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + e.b(this.qxd).getHeight() / e.b(this.qxd).getLineHeight());
    }
    e.b(this.qxd).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    AppMethodBeat.o(81019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.e.2
 * JD-Core Version:    0.7.0.1
 */