package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class v$a$1
  implements View.OnClickListener
{
  v$a$1(v.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38274);
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(38274);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    this.rHx.ED(i);
    AppMethodBeat.o(38274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.v.a.1
 * JD-Core Version:    0.7.0.1
 */