package com.tencent.mm.plugin.transvoice.ui;

import a.f.b.j;
import a.l;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$1"})
final class b$e
  implements TextView.OnEditorActionListener
{
  b$e(b paramb) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(156318);
    if (4 != paramInt)
    {
      j.p(paramKeyEvent, "event");
      if (paramKeyEvent.getAction() != 66) {}
    }
    else
    {
      b.o(this.tqJ);
      AppMethodBeat.o(156318);
      return true;
    }
    AppMethodBeat.o(156318);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.e
 * JD-Core Version:    0.7.0.1
 */