package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ap;

final class o$4
  implements View.OnClickListener
{
  o$4(o paramo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34713);
    o.a(this.Anv, this.Anv.tng);
    this.Anv.tng = 1;
    if (this.Anv.Ant == null)
    {
      paramView = this.Anv;
      paramView.Ant = new o.1(paramView);
      a.ymk.b(paramView.Ant);
    }
    if (this.Anv.Ans == null)
    {
      paramView = this.Anv;
      paramView.Ans = new ap(new o.2(paramView), true);
      paramView.Ans.ag(1000L, 1000L);
    }
    AppMethodBeat.o(34713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o.4
 * JD-Core Version:    0.7.0.1
 */