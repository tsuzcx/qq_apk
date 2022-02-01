package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class u
  implements f
{
  public b DBE;
  private a DBF;
  public boolean dnq = false;
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(71305);
    this.DBF = parama;
    g.ajS();
    boolean bool = ((Boolean)g.ajR().ajA().get(am.a.IXN, Boolean.FALSE)).booleanValue();
    ae.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (bool)
    {
      parama.dnB();
      AppMethodBeat.o(71305);
      return;
    }
    if (this.dnq)
    {
      ae.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", new Object[] { Boolean.valueOf(this.dnq) });
      parama.dnB();
      AppMethodBeat.o(71305);
      return;
    }
    if (paramBoolean)
    {
      this.dnq = true;
      parama = new j();
      g.ajS();
      g.ajQ().gDv.a(parama, 0);
      AppMethodBeat.o(71305);
      return;
    }
    parama.dnB();
    AppMethodBeat.o(71305);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(71304);
    if (this.DBF != null) {
      this.DBF.cancel();
    }
    AppMethodBeat.o(71304);
  }
  
  public final void dnA()
  {
    AppMethodBeat.i(71303);
    t localt = new t();
    g.ajS();
    g.ajQ().gDv.a(localt, 0);
    if (this.DBF != null) {
      this.DBF.dnA();
    }
    AppMethodBeat.o(71303);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(71302);
    g.ajS();
    g.ajQ().gDv.b(2541, this);
    g.ajS();
    g.ajQ().gDv.b(2791, this);
    AppMethodBeat.o(71302);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(71301);
    g.ajS();
    g.ajQ().gDv.a(2541, this);
    g.ajS();
    g.ajQ().gDv.a(2791, this);
    AppMethodBeat.o(71301);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71306);
    if ((paramn instanceof j))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(71306);
        return;
      }
      paramString = (j)paramn;
      ae.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(ao.bnS()), paramString.Dgo, Boolean.valueOf(paramString.Dgp) });
      if ((ao.bnS()) && (paramString.Dgp))
      {
        paramn = new Intent();
        paramn.putExtra("agreement_content", paramString.Dgo);
        d.b(this.DBE.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", paramn, this.DBE.dnC());
        AppMethodBeat.o(71306);
        return;
      }
      if (this.DBF != null) {
        this.DBF.dnB();
      }
      AppMethodBeat.o(71306);
      return;
    }
    if ((paramn instanceof t))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(71306);
        return;
      }
      g.ajS();
      g.ajR().ajA().set(am.a.IXN, Boolean.TRUE);
      ae.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
    }
    AppMethodBeat.o(71306);
  }
  
  public static abstract interface a
  {
    public abstract void cancel();
    
    public abstract void dnA();
    
    public abstract void dnB();
  }
  
  public static abstract interface b
  {
    public abstract int dnC();
    
    public abstract Context getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.u
 * JD-Core Version:    0.7.0.1
 */