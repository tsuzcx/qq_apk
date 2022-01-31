package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.ui.widget.c.a;

final class BaseTimeLineItem$6
  implements View.OnLongClickListener
{
  BaseTimeLineItem$6(BaseTimeLineItem paramBaseTimeLineItem, View paramView) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(40120);
    int[] arrayOfInt = new int[2];
    if ((paramView.getTag(2131820681) instanceof int[])) {}
    for (paramView = (int[])paramView.getTag(2131820681);; paramView = arrayOfInt)
    {
      this.sgI.rkX.jVd.a(this.scO, this.sgI.rkX.rks.sjE, this.sgI.rkX.rks.sjr, paramView[0], paramView[1]);
      AppMethodBeat.o(40120);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.6
 * JD-Core Version:    0.7.0.1
 */