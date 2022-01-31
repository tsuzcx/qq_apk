package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.o;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class q
  implements com.tencent.mm.ah.f
{
  public boolean bHj = false;
  public q.b qHp;
  private q.a qHq;
  
  public final void a(q.a parama, boolean paramBoolean)
  {
    this.qHq = parama;
    g.DQ();
    boolean bool = ((Boolean)g.DP().Dz().get(ac.a.uyY, Boolean.valueOf(false))).booleanValue();
    y.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if (bool)
    {
      parama.bgS();
      return;
    }
    if (this.bHj)
    {
      y.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", new Object[] { Boolean.valueOf(this.bHj) });
      parama.bgS();
      return;
    }
    if (paramBoolean)
    {
      this.bHj = true;
      parama = new com.tencent.mm.plugin.wallet_core.c.f();
      g.DQ();
      g.DO().dJT.a(parama, 0);
      return;
    }
    parama.bgS();
  }
  
  public final void bgR()
  {
    o localo = new o();
    g.DQ();
    g.DO().dJT.a(localo, 0);
    if (this.qHq != null) {
      this.qHq.bgR();
    }
  }
  
  public final void cancel()
  {
    if (this.qHq != null) {
      this.qHq.cancel();
    }
  }
  
  public final void onPause()
  {
    g.DQ();
    g.DO().dJT.b(2541, this);
    g.DQ();
    g.DO().dJT.b(2791, this);
  }
  
  public final void onResume()
  {
    g.DQ();
    g.DO().dJT.a(2541, this);
    g.DQ();
    g.DO().dJT.a(2791, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.f)) {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    }
    while ((!(paramm instanceof o)) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      do
      {
        return;
        paramString = (com.tencent.mm.plugin.wallet_core.c.f)paramm;
        y.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(ah.akH()), paramString.qqz, Boolean.valueOf(paramString.qqA) });
      } while ((!ah.akH()) || (!paramString.qqA));
      paramm = new Intent();
      paramm.putExtra("agreement_content", paramString.qqz);
      d.b(this.qHp.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", paramm, this.qHp.bgT());
      return;
    }
    g.DQ();
    g.DP().Dz().c(ac.a.uyY, Boolean.valueOf(true));
    y.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q
 * JD-Core Version:    0.7.0.1
 */