package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class u
  implements f
{
  public b Dka;
  private a Dkb;
  public boolean dmo = false;
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(71305);
    this.Dkb = parama;
    g.ajD();
    boolean bool = ((Boolean)g.ajC().ajl().get(al.a.IDn, Boolean.FALSE)).booleanValue();
    ad.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (bool)
    {
      parama.dkB();
      AppMethodBeat.o(71305);
      return;
    }
    if (this.dmo)
    {
      ad.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", new Object[] { Boolean.valueOf(this.dmo) });
      parama.dkB();
      AppMethodBeat.o(71305);
      return;
    }
    if (paramBoolean)
    {
      this.dmo = true;
      parama = new j();
      g.ajD();
      g.ajB().gAO.a(parama, 0);
      AppMethodBeat.o(71305);
      return;
    }
    parama.dkB();
    AppMethodBeat.o(71305);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(71304);
    if (this.Dkb != null) {
      this.Dkb.cancel();
    }
    AppMethodBeat.o(71304);
  }
  
  public final void dkA()
  {
    AppMethodBeat.i(71303);
    t localt = new t();
    g.ajD();
    g.ajB().gAO.a(localt, 0);
    if (this.Dkb != null) {
      this.Dkb.dkA();
    }
    AppMethodBeat.o(71303);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(71302);
    g.ajD();
    g.ajB().gAO.b(2541, this);
    g.ajD();
    g.ajB().gAO.b(2791, this);
    AppMethodBeat.o(71302);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(71301);
    g.ajD();
    g.ajB().gAO.a(2541, this);
    g.ajD();
    g.ajB().gAO.a(2791, this);
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
      ad.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(ao.bni()), paramString.COJ, Boolean.valueOf(paramString.COK) });
      if ((ao.bni()) && (paramString.COK))
      {
        paramn = new Intent();
        paramn.putExtra("agreement_content", paramString.COJ);
        d.b(this.Dka.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", paramn, this.Dka.dkC());
        AppMethodBeat.o(71306);
        return;
      }
      if (this.Dkb != null) {
        this.Dkb.dkB();
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
      g.ajD();
      g.ajC().ajl().set(al.a.IDn, Boolean.TRUE);
      ad.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
    }
    AppMethodBeat.o(71306);
  }
  
  public static abstract interface a
  {
    public abstract void cancel();
    
    public abstract void dkA();
    
    public abstract void dkB();
  }
  
  public static abstract interface b
  {
    public abstract int dkC();
    
    public abstract Context getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.u
 * JD-Core Version:    0.7.0.1
 */