package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;

public final class u
  implements i
{
  public b IkQ;
  private a IkR;
  public boolean dEF = false;
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(71305);
    this.IkR = parama;
    g.aAi();
    boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.Ogk, Boolean.FALSE)).booleanValue();
    Log.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (bool)
    {
      parama.ehn();
      AppMethodBeat.o(71305);
      return;
    }
    if (this.dEF)
    {
      Log.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", new Object[] { Boolean.valueOf(this.dEF) });
      parama.ehn();
      AppMethodBeat.o(71305);
      return;
    }
    if (paramBoolean)
    {
      this.dEF = true;
      parama = new j();
      g.aAi();
      g.aAg().hqi.a(parama, 0);
      AppMethodBeat.o(71305);
      return;
    }
    parama.ehn();
    AppMethodBeat.o(71305);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(71304);
    if (this.IkR != null) {
      this.IkR.cancel();
    }
    AppMethodBeat.o(71304);
  }
  
  public final void ehm()
  {
    AppMethodBeat.i(71303);
    com.tencent.mm.plugin.wallet_core.c.t localt = new com.tencent.mm.plugin.wallet_core.c.t();
    g.aAi();
    g.aAg().hqi.a(localt, 0);
    if (this.IkR != null) {
      this.IkR.ehm();
    }
    AppMethodBeat.o(71303);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(71302);
    g.aAi();
    g.aAg().hqi.b(2541, this);
    g.aAi();
    g.aAg().hqi.b(2791, this);
    AppMethodBeat.o(71302);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(71301);
    g.aAi();
    g.aAg().hqi.a(2541, this);
    g.aAi();
    g.aAg().hqi.a(2791, this);
    AppMethodBeat.o(71301);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71306);
    if ((paramq instanceof j))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(71306);
        return;
      }
      paramString = (j)paramq;
      Log.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(com.tencent.mm.plugin.wallet_core.model.ao.bJw()), paramString.HPH, Boolean.valueOf(paramString.HPI) });
      if ((com.tencent.mm.plugin.wallet_core.model.ao.bJw()) && (paramString.HPI))
      {
        paramq = new Intent();
        paramq.putExtra("agreement_content", paramString.HPH);
        c.b(this.IkQ.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", paramq, this.IkQ.eho());
        AppMethodBeat.o(71306);
        return;
      }
      if (this.IkR != null) {
        this.IkR.ehn();
      }
      AppMethodBeat.o(71306);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.t))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(71306);
        return;
      }
      g.aAi();
      g.aAh().azQ().set(ar.a.Ogk, Boolean.TRUE);
      Log.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
    }
    AppMethodBeat.o(71306);
  }
  
  public static abstract interface a
  {
    public abstract void cancel();
    
    public abstract void ehm();
    
    public abstract void ehn();
  }
  
  public static abstract interface b
  {
    public abstract int eho();
    
    public abstract Context getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.u
 * JD-Core Version:    0.7.0.1
 */