package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.b.a.dd;
import com.tencent.mm.g.b.a.dd.a;
import com.tencent.mm.g.b.a.dd.b;
import com.tencent.mm.g.b.a.dd.c;
import com.tencent.mm.g.b.a.dd.d;
import com.tencent.mm.g.b.a.dd.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.k;

final class t$1
  extends com.tencent.mm.plugin.messenger.a.a
{
  t$1(j.b paramb, t.d paramd, String paramString, com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.af.a parama1) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(33043);
    ((k)g.E(k.class)).T(this.iaj.fjd, 2);
    this.zUB.zUH.setText(this.zUC);
    dd localdd = new dd().iu(this.iaj.fiY).iv(this.iaj.fiW).iw(this.iaj.fjd).ix(this.zRK.getTalkerUserName());
    if (this.zRK.dJG()) {}
    for (paramView = dd.c.deK;; paramView = dd.c.deL)
    {
      localdd.deq = paramView;
      localdd.der = dd.b.deG;
      localdd.cRG = 0L;
      paramView = localdd.iy("").Hl();
      paramView.det = dd.d.deN;
      paramView.dev = dd.a.hn(this.zUD.ffe + 1000);
      paramView.deu = dd.e.deR;
      paramView.ake();
      AppMethodBeat.o(33043);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.1
 * JD-Core Version:    0.7.0.1
 */