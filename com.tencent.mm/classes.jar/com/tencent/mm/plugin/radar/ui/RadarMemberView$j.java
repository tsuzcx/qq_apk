package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/ui/RadarMemberView$showModifyDialog$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-radar_release"})
public final class RadarMemberView$j
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = false;
    AppMethodBeat.i(102960);
    j.q(paramEditable, "s");
    int j = 50 - paramEditable.length();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Object localObject = RadarMemberView.f(this.pRw);
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)String.valueOf(i));
    }
    localObject = RadarMemberView.g(this.pRw);
    if (localObject != null)
    {
      localObject = ((c)localObject).getButton(-1);
      if (localObject != null)
      {
        if (paramEditable.length() > 0) {
          bool = true;
        }
        ((Button)localObject).setEnabled(bool);
        AppMethodBeat.o(102960);
        return;
      }
    }
    AppMethodBeat.o(102960);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(102959);
    j.q(paramCharSequence, "s");
    AppMethodBeat.o(102959);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(102958);
    j.q(paramCharSequence, "s");
    AppMethodBeat.o(102958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.j
 * JD-Core Version:    0.7.0.1
 */