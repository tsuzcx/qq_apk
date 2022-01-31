package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsMsgUI$1
  implements View.OnClickListener
{
  SnsMsgUI$1(SnsMsgUI paramSnsMsgUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39065);
    if ((paramView.getTag() instanceof ao))
    {
      SnsMsgUI.a(this.rSU).u(paramView, -1, 1);
      AppMethodBeat.o(39065);
      return;
    }
    if ((paramView.getTag() instanceof j))
    {
      SnsMsgUI.a(this.rSU, (j)paramView.getTag());
      AppMethodBeat.o(39065);
      return;
    }
    ab.w("MicroMsg.SnsMsgUI", "v.getTag():" + paramView.getTag());
    AppMethodBeat.o(39065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.1
 * JD-Core Version:    0.7.0.1
 */