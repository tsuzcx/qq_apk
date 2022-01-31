package com.tencent.mm.plugin.sns.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class SnsStoryHeaderView$1
  implements View.OnClickListener
{
  SnsStoryHeaderView$1(SnsStoryHeaderView paramSnsStoryHeaderView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40420);
    if (SnsStoryHeaderView.a(this.smy) != null) {
      SnsStoryHeaderView.a(this.smy).cwm();
    }
    h.qsU.j(1015L, 5L, 1L);
    SnsStoryHeaderView.b(this.smy);
    AppMethodBeat.o(40420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.1
 * JD-Core Version:    0.7.0.1
 */