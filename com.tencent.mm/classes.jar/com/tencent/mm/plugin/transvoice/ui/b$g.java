package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-transvoice_release"})
public final class b$g
  implements TextWatcher
{
  b$g(b paramb) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = true;
    AppMethodBeat.i(156320);
    if ((!b.x(this.tqJ)) && (b.q(this.tqJ)))
    {
      b.y(this.tqJ);
      b.p(this.tqJ).tpA = 1;
    }
    Button localButton = b.z(this.tqJ);
    if (localButton != null)
    {
      if (!bo.aa((CharSequence)paramEditable)) {}
      for (;;)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(156320);
        return;
        bool = false;
      }
    }
    AppMethodBeat.o(156320);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.g
 * JD-Core Version:    0.7.0.1
 */