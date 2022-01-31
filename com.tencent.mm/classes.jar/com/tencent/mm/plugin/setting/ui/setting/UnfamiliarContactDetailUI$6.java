package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

final class UnfamiliarContactDetailUI$6
  implements UnfamiliarContactDetailUI.g
{
  UnfamiliarContactDetailUI$6(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void ckL()
  {
    AppMethodBeat.i(127639);
    UnfamiliarContactDetailUI.c(this.qLi, true);
    AppMethodBeat.o(127639);
  }
  
  public final void fs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127638);
    UnfamiliarContactDetailUI.f.qLF += paramInt1;
    UnfamiliarContactDetailUI.c(this.qLi, false);
    UnfamiliarContactDetailUI.g(this.qLi).setText(this.qLi.getString(2131304413) + "(" + UnfamiliarContactDetailUI.f(this.qLi).size() + ")");
    if (UnfamiliarContactDetailUI.e(this.qLi) != null) {
      UnfamiliarContactDetailUI.e(this.qLi).ajb.notifyChanged();
    }
    if (paramInt2 < paramInt1)
    {
      ab.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      h.b(this.qLi.getContext(), this.qLi.getString(2131304410, new Object[] { Integer.valueOf(paramInt1 - paramInt2) }), "", true);
    }
    AppMethodBeat.o(127638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.6
 * JD-Core Version:    0.7.0.1
 */