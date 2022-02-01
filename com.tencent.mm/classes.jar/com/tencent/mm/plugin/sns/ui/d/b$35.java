package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.j.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.p;

final class b$35
  implements View.OnClickListener
{
  b$35(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(100256);
    this.zhf.dNq();
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof e)))
    {
      paramView = af.dHR().auT(((e)paramView.getTag()).ddB);
      if (paramView != null)
      {
        f localf = f.ydE;
        f.auz(paramView.field_userName);
        paramView = new com.tencent.mm.plugin.sns.model.q(paramView.field_snsId, 9);
        g.agS();
        g.agQ().ghe.a(paramView, 0);
      }
    }
    AppMethodBeat.o(100256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.35
 * JD-Core Version:    0.7.0.1
 */