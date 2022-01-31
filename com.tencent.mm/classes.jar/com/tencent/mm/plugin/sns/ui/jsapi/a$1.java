package com.tencent.mm.plugin.sns.ui.jsapi;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40217);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a.c))) {}
    for (paramView = null; paramView == null; paramView = (a.c)paramView.getTag())
    {
      ab.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
      AppMethodBeat.o(40217);
      return;
    }
    if (a.a(this.sji) != null) {
      a.a(this.sji).a(paramView);
    }
    AppMethodBeat.o(40217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.a.1
 * JD-Core Version:    0.7.0.1
 */