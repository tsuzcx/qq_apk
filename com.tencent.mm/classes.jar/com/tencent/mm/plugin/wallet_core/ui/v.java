package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.plugin.wallet_core.model.ap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class v
  implements i
{
  public b Pdi;
  private a Pdj;
  public boolean fxt = false;
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(71305);
    this.Pdj = parama;
    h.aHH();
    boolean bool = ((Boolean)h.aHG().aHp().get(ar.a.VuA, Boolean.FALSE)).booleanValue();
    Log.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (bool)
    {
      parama.eQU();
      AppMethodBeat.o(71305);
      return;
    }
    if (this.fxt)
    {
      Log.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", new Object[] { Boolean.valueOf(this.fxt) });
      parama.eQU();
      AppMethodBeat.o(71305);
      return;
    }
    if (paramBoolean)
    {
      this.fxt = true;
      parama = new k();
      h.aHH();
      h.aHF().kcd.a(parama, 0);
      AppMethodBeat.o(71305);
      return;
    }
    parama.eQU();
    AppMethodBeat.o(71305);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(71304);
    if (this.Pdj != null) {
      this.Pdj.cancel();
    }
    AppMethodBeat.o(71304);
  }
  
  public final void eQT()
  {
    AppMethodBeat.i(71303);
    u localu = new u();
    h.aHH();
    h.aHF().kcd.a(localu, 0);
    if (this.Pdj != null) {
      this.Pdj.eQT();
    }
    AppMethodBeat.o(71303);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(71302);
    h.aHH();
    h.aHF().kcd.b(2541, this);
    h.aHH();
    h.aHF().kcd.b(2791, this);
    AppMethodBeat.o(71302);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(71301);
    h.aHH();
    h.aHF().kcd.a(2541, this);
    h.aHH();
    h.aHF().kcd.a(2791, this);
    AppMethodBeat.o(71301);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71306);
    if ((paramq instanceof k))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(71306);
        return;
      }
      paramString = (k)paramq;
      Log.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(ap.bVd()), paramString.OHQ, Boolean.valueOf(paramString.OHR) });
      if ((ap.bVd()) && (paramString.OHR))
      {
        paramq = new Intent();
        paramq.putExtra("agreement_content", paramString.OHQ);
        com.tencent.mm.by.c.b(this.Pdi.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", paramq, this.Pdi.eQV());
        AppMethodBeat.o(71306);
        return;
      }
      if (this.Pdj != null) {
        this.Pdj.eQU();
      }
      AppMethodBeat.o(71306);
      return;
    }
    if ((paramq instanceof u))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(71306);
        return;
      }
      h.aHH();
      h.aHG().aHp().set(ar.a.VuA, Boolean.TRUE);
      Log.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
    }
    AppMethodBeat.o(71306);
  }
  
  public static abstract interface a
  {
    public abstract void cancel();
    
    public abstract void eQT();
    
    public abstract void eQU();
  }
  
  public static abstract interface b
  {
    public abstract int eQV();
    
    public abstract Context getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.v
 * JD-Core Version:    0.7.0.1
 */