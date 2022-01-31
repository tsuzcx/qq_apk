package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class k$6
  implements View.OnClickListener
{
  k$6(k paramk, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    bc.HI().bi(this.bns, this.uJr);
    d.x((Context)this.vUP.sdy.get(), "game", ".ui.GameCenterUI");
    h.nFQ.f(11002, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k.6
 * JD-Core Version:    0.7.0.1
 */