package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.i;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class s
  implements f
{
  public boolean coy = false;
  public s.b uuu;
  private s.a uuv;
  
  public final void a(s.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(47734);
    this.uuv = parama;
    g.RM();
    boolean bool = ((Boolean)g.RL().Ru().get(ac.a.yJM, Boolean.FALSE)).booleanValue();
    ab.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (bool)
    {
      parama.bON();
      AppMethodBeat.o(47734);
      return;
    }
    if (this.coy)
    {
      ab.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", new Object[] { Boolean.valueOf(this.coy) });
      parama.bON();
      AppMethodBeat.o(47734);
      return;
    }
    if (paramBoolean)
    {
      this.coy = true;
      parama = new i();
      g.RM();
      g.RK().eHt.a(parama, 0);
      AppMethodBeat.o(47734);
      return;
    }
    parama.bON();
    AppMethodBeat.o(47734);
  }
  
  public final void bOM()
  {
    AppMethodBeat.i(47732);
    r localr = new r();
    g.RM();
    g.RK().eHt.a(localr, 0);
    if (this.uuv != null) {
      this.uuv.bOM();
    }
    AppMethodBeat.o(47732);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(47733);
    if (this.uuv != null) {
      this.uuv.cancel();
    }
    AppMethodBeat.o(47733);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(47731);
    g.RM();
    g.RK().eHt.b(2541, this);
    g.RM();
    g.RK().eHt.b(2791, this);
    AppMethodBeat.o(47731);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47730);
    g.RM();
    g.RK().eHt.a(2541, this);
    g.RM();
    g.RK().eHt.a(2791, this);
    AppMethodBeat.o(47730);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47735);
    if ((paramm instanceof i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(47735);
        return;
      }
      paramString = (i)paramm;
      ab.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(an.Pk()), paramString.ubv, Boolean.valueOf(paramString.ubw) });
      if ((an.Pk()) && (paramString.ubw))
      {
        paramm = new Intent();
        paramm.putExtra("agreement_content", paramString.ubv);
        d.b(this.uuu.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", paramm, this.uuu.bOO());
        AppMethodBeat.o(47735);
        return;
      }
      this.uuv.bON();
      AppMethodBeat.o(47735);
      return;
    }
    if ((paramm instanceof r))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(47735);
        return;
      }
      g.RM();
      g.RL().Ru().set(ac.a.yJM, Boolean.TRUE);
      ab.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
    }
    AppMethodBeat.o(47735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.s
 * JD-Core Version:    0.7.0.1
 */