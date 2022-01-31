package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class at$f$1
  implements View.OnClickListener
{
  at$f$1(at.f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39211);
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(39211);
      return;
    }
    this.rVo.rVn = ((at.f.a)paramView.getTag());
    int i = this.rVo.rVn.cIp;
    int j = this.rVo.rVn.position;
    this.rVo.fJ(i, j);
    AppMethodBeat.o(39211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at.f.1
 * JD-Core Version:    0.7.0.1
 */