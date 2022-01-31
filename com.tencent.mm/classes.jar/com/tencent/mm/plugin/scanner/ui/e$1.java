package com.tencent.mm.plugin.scanner.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;

final class e$1
  implements View.OnTouchListener
{
  e$1(e parame) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(81018);
    if (paramMotionEvent.getAction() == 0)
    {
      ab.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
      e.a(this.qxd).setVisibility(4);
      e.b(this.qxd).setMaxLines(2000);
      this.qxd.qwY = true;
      if (e.c(this.qxd) != null)
      {
        e.c(this.qxd).a(this.qxd.mKey, Boolean.TRUE);
        e.c(this.qxd).ciJ();
      }
    }
    AppMethodBeat.o(81018);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.e.1
 * JD-Core Version:    0.7.0.1
 */