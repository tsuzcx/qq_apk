package com.tencent.mm.plugin.transvoice.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$12", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
public final class b$k
  implements a.b
{
  public final void GW(int paramInt)
  {
    AppMethodBeat.i(156322);
    Object localObject1 = b.A(this.tqJ);
    if (localObject1 != null) {
      ((a)localObject1).dismiss();
    }
    b.d(this.tqJ, paramInt);
    if (paramInt == b.B(this.tqJ))
    {
      AppMethodBeat.o(156322);
      return;
    }
    if (at.isConnected(this.tqJ.getContext()))
    {
      localObject1 = this.tqJ;
      ((b)localObject1).tpU = false;
      ((b)localObject1).mxI = false;
      ((b)localObject1).tpS.tpr = ((b)localObject1).tpT;
      ((b)localObject1).tpS.tpu = 0;
      ((b)localObject1).tpS.tpv = 0L;
      ((b)localObject1).tpS.tpw = 0;
      ((b)localObject1).tpS.tpz = 0;
      ((b)localObject1).tpS.tpA = 0;
      ((b)localObject1).tpS.tpB = 0;
      ((b)localObject1).cLb();
      localObject2 = ((b)localObject1).tqo;
      if (localObject2 != null) {
        ((ak)localObject2).sendEmptyMessageDelayed(5000, 5000L);
      }
      localObject2 = ((b)localObject1).tql;
      if (localObject2 != null) {
        ((ap)localObject2).nP(500L);
      }
      ((b)localObject1).gbb = paramInt;
      long l2 = System.nanoTime() & 0xFFFFFFFF;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = Math.abs(l2);
      }
      localObject2 = new h(String.valueOf(l1));
      h localh = ((b)localObject1).gaW;
      if (localh != null) {
        localh.a((h)localObject2);
      }
      ((b)localObject1).tqe = new com.tencent.mm.plugin.transvoice.a.b((h)localObject2, paramInt, (g.b)new b.y((b)localObject1));
      localObject1 = ((b)localObject1).tqe;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.transvoice.a.b)localObject1).start();
        AppMethodBeat.o(156322);
        return;
      }
      AppMethodBeat.o(156322);
      return;
    }
    localObject1 = new c.a(this.tqJ.getContext());
    Object localObject2 = this.tqJ.getContext();
    j.p(localObject2, "context");
    ((c.a)localObject1).avn(((Context)localObject2).getResources().getString(2131297011));
    localObject2 = this.tqJ.getContext();
    j.p(localObject2, "context");
    ((c.a)localObject1).avs(((Context)localObject2).getResources().getString(2131306198));
    localObject2 = this.tqJ.getContext();
    j.p(localObject2, "context");
    ((c.a)localObject1).Rk(((Context)localObject2).getResources().getColor(2131689571));
    ((c.a)localObject1).aLZ().show();
    AppMethodBeat.o(156322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.k
 * JD-Core Version:    0.7.0.1
 */