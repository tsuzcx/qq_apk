package com.tencent.mm.plugin.radar.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarMemberView$showModifyDialog$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-radar_release"})
public final class RadarMemberView$j
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = false;
    AppMethodBeat.i(138605);
    p.h(paramEditable, "s");
    int j = 50 - paramEditable.length();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Object localObject = RadarMemberView.f(this.xzN);
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)String.valueOf(i));
    }
    localObject = RadarMemberView.g(this.xzN);
    if (localObject != null)
    {
      localObject = ((d)localObject).getButton(-1);
      if (localObject != null)
      {
        if (paramEditable.length() > 0) {
          bool = true;
        }
        ((Button)localObject).setEnabled(bool);
        AppMethodBeat.o(138605);
        return;
      }
    }
    AppMethodBeat.o(138605);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(138604);
    p.h(paramCharSequence, "s");
    AppMethodBeat.o(138604);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(138603);
    p.h(paramCharSequence, "s");
    AppMethodBeat.o(138603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.j
 * JD-Core Version:    0.7.0.1
 */