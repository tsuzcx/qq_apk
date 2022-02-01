package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class u
  implements com.tencent.mm.al.g
{
  public b Aro;
  private a Arp;
  public boolean ddw = false;
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(71305);
    this.Arp = parama;
    com.tencent.mm.kernel.g.afC();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FsX, Boolean.FALSE)).booleanValue();
    ad.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (bool)
    {
      parama.cNB();
      AppMethodBeat.o(71305);
      return;
    }
    if (this.ddw)
    {
      ad.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", new Object[] { Boolean.valueOf(this.ddw) });
      parama.cNB();
      AppMethodBeat.o(71305);
      return;
    }
    if (paramBoolean)
    {
      this.ddw = true;
      parama = new j();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(parama, 0);
      AppMethodBeat.o(71305);
      return;
    }
    parama.cNB();
    AppMethodBeat.o(71305);
  }
  
  public final void cNA()
  {
    AppMethodBeat.i(71303);
    t localt = new t();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(localt, 0);
    if (this.Arp != null) {
      this.Arp.cNA();
    }
    AppMethodBeat.o(71303);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(71304);
    if (this.Arp != null) {
      this.Arp.cancel();
    }
    AppMethodBeat.o(71304);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(71302);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(2541, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(2791, this);
    AppMethodBeat.o(71302);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(71301);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(2541, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(2791, this);
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
      ad.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(an.bcB()), paramString.zWa, Boolean.valueOf(paramString.zWb) });
      if ((an.bcB()) && (paramString.zWb))
      {
        paramn = new Intent();
        paramn.putExtra("agreement_content", paramString.zWa);
        d.b(this.Aro.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", paramn, this.Aro.cNC());
        AppMethodBeat.o(71306);
        return;
      }
      if (this.Arp != null) {
        this.Arp.cNB();
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
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsX, Boolean.TRUE);
      ad.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
    }
    AppMethodBeat.o(71306);
  }
  
  public static abstract interface a
  {
    public abstract void cNA();
    
    public abstract void cNB();
    
    public abstract void cancel();
  }
  
  public static abstract interface b
  {
    public abstract int cNC();
    
    public abstract Context getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.u
 * JD-Core Version:    0.7.0.1
 */