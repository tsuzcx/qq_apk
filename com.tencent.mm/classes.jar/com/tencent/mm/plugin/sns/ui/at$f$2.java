package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class at$f$2
  implements View.OnClickListener
{
  at$f$2(at.f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39212);
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(39212);
      return;
    }
    this.rVo.rVn = ((at.f.a)paramView.getTag());
    int i = this.rVo.rVn.cIp;
    int j = this.rVo.rVn.position;
    this.rVo.fJ(i, j + 1);
    AppMethodBeat.o(39212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at.f.2
 * JD-Core Version:    0.7.0.1
 */