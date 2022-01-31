package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.d.b;

final class e$4
  implements View.OnClickListener
{
  e$4(e parame, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40106);
    if ((this.sgA.rOU != null) && (this.qZq)) {
      this.sgA.rOU.ll(this.sgA.rMD.field_snsId);
    }
    this.sgA.rOV.sjX.onClick(paramView);
    AppMethodBeat.o(40106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.e.4
 * JD-Core Version:    0.7.0.1
 */