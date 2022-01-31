package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ap$1
  implements View.OnClickListener
{
  ap$1(ap paramap) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39049);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof ap.c))) {}
    for (paramView = null; paramView == null; paramView = (ap.c)paramView.getTag())
    {
      ab.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
      AppMethodBeat.o(39049);
      return;
    }
    if (ap.a(this.rSz) != null) {
      ap.a(this.rSz).a(paramView);
    }
    AppMethodBeat.o(39049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap.1
 * JD-Core Version:    0.7.0.1
 */