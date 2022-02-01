package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.p;

final class a$3
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(94920);
    if ((paramView.getTag() instanceof p))
    {
      p localp = (p)paramView.getTag();
      a.a(paramView, paramView.getContext(), localp);
    }
    AppMethodBeat.o(94920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a.3
 * JD-Core Version:    0.7.0.1
 */