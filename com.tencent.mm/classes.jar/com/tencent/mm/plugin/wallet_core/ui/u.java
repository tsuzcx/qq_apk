package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class u
  implements com.tencent.mm.ak.g
{
  public b BJI;
  private a BJJ;
  public boolean daU = false;
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(71305);
    this.BJJ = parama;
    com.tencent.mm.kernel.g.agS();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQQ, Boolean.FALSE)).booleanValue();
    ac.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (bool)
    {
      parama.dbi();
      AppMethodBeat.o(71305);
      return;
    }
    if (this.daU)
    {
      ac.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", new Object[] { Boolean.valueOf(this.daU) });
      parama.dbi();
      AppMethodBeat.o(71305);
      return;
    }
    if (paramBoolean)
    {
      this.daU = true;
      parama = new j();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(parama, 0);
      AppMethodBeat.o(71305);
      return;
    }
    parama.dbi();
    AppMethodBeat.o(71305);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(71304);
    if (this.BJJ != null) {
      this.BJJ.cancel();
    }
    AppMethodBeat.o(71304);
  }
  
  public final void dbh()
  {
    AppMethodBeat.i(71303);
    t localt = new t();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(localt, 0);
    if (this.BJJ != null) {
      this.BJJ.dbh();
    }
    AppMethodBeat.o(71303);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(71302);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(2541, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(2791, this);
    AppMethodBeat.o(71302);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(71301);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(2541, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(2791, this);
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
      ac.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(an.bjw()), paramString.Bou, Boolean.valueOf(paramString.Bov) });
      if ((an.bjw()) && (paramString.Bov))
      {
        paramn = new Intent();
        paramn.putExtra("agreement_content", paramString.Bou);
        d.b(this.BJI.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", paramn, this.BJI.dbj());
        AppMethodBeat.o(71306);
        return;
      }
      if (this.BJJ != null) {
        this.BJJ.dbi();
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
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQQ, Boolean.TRUE);
      ac.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
    }
    AppMethodBeat.o(71306);
  }
  
  public static abstract interface a
  {
    public abstract void cancel();
    
    public abstract void dbh();
    
    public abstract void dbi();
  }
  
  public static abstract interface b
  {
    public abstract int dbj();
    
    public abstract Context getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.u
 * JD-Core Version:    0.7.0.1
 */