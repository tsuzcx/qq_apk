package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bo;

final class c$2
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35681);
    if ((paramView.getTag() instanceof n))
    {
      n localn = (n)paramView.getTag();
      if ((localn != null) && (!bo.isNullOrNil(localn.getSnsId()))) {
        c.S(paramView.getContext(), localn.getSnsId());
      }
    }
    AppMethodBeat.o(35681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.c.2
 * JD-Core Version:    0.7.0.1
 */