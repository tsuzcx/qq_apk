package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;

public class RemittanceUI
  extends RemittanceNewBaseUI
{
  protected String qrx;
  private String qry;
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, fx paramfx)
  {
    AppMethodBeat.i(45166);
    if (this.qlj != null) {
      this.qlj.j(3, new Object[] { Integer.valueOf(this.mPayScene), Double.valueOf(this.qlk) });
    }
    int k = getIntent().getIntExtra("pay_channel", -1);
    String str = "";
    Object localObject = str;
    if (!bo.Q(new String[0]))
    {
      g.RM();
      localObject = ((j)g.E(j.class)).YA().aru(this.eaX);
      if (localObject != null) {
        localObject = ((ad)localObject).Of();
      }
    }
    else
    {
      if (!bo.isNullOrNil(paramString6)) {
        break label400;
      }
      this.qlU = true;
      label127:
      ab.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[] { Integer.valueOf(k) });
      int j = 0;
      int i = 0;
      if (bo.hl(this.cEU, 4))
      {
        boolean bool1 = bo.z(Double.valueOf(this.qmf), Double.valueOf(this.qlk));
        boolean bool2 = bo.isEqual(this.qmg, paramString1);
        boolean bool3 = bo.isEqual(this.qmh, paramString4);
        j = i;
        if (!bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          i = j | 0x2;
        }
        j = i;
        if (!bool3) {
          j = i | 0x4;
        }
      }
      paramString1 = new v(this.qlk, "1", this.eaX, this.qlK, this.mPayScene, this.mScene, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, this.qlp, k, this.qlP, paramString6, this.qll, (String)localObject, this.qlK, paramfx, this.qlR, this.qlQ, this.qrx, this.qry, this.cEU, this.qmi, j);
      paramString1.setProcessName("RemittanceProcess");
      if (!this.mKindaEnable) {
        break label408;
      }
      showLoading();
      doSceneProgress(paramString1, false);
    }
    for (;;)
    {
      this.qlR = "";
      AppMethodBeat.o(45166);
      return;
      ab.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.eaX);
      localObject = str;
      break;
      label400:
      this.qlU = false;
      break label127;
      label408:
      doSceneProgress(paramString1);
    }
  }
  
  public final void chA()
  {
    AppMethodBeat.i(45164);
    if (chn())
    {
      g.RM();
      this.qlL = ((String)g.RL().Ru().get(ac.a.yEz, ""));
      g.RM();
      this.qlM = ((String)g.RL().Ru().get(ac.a.yED, ""));
      g.RM();
      this.qlN = ((Integer)g.RL().Ru().get(ac.a.yEE, Integer.valueOf(0))).intValue();
      if ((!bo.isNullOrNil(this.qlL)) && (!bo.isNullOrNil(this.qlM))) {
        break label148;
      }
      ah.a(true, null);
    }
    for (;;)
    {
      ab.d("MicroMsg.RemittanceUI", "do before transfer");
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.e(this.eaX), false);
      AppMethodBeat.o(45164);
      return;
      label148:
      ah.a(false, null);
    }
  }
  
  public final void chh()
  {
    AppMethodBeat.i(45168);
    t.makeText(getContext(), 2131302516, 0).show();
    AppMethodBeat.o(45168);
  }
  
  public final void chk()
  {
    AppMethodBeat.i(45170);
    vd localvd = new vd();
    localvd.cLE.bSd = "7";
    localvd.callback = new RemittanceUI.4(this, localvd);
    com.tencent.mm.sdk.b.a.ymk.l(localvd);
    AppMethodBeat.o(45170);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45165);
    super.onCreate(paramBundle);
    h.qsU.e(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    addSceneEndListener(2783);
    AppMethodBeat.o(45165);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45169);
    super.onDestroy();
    removeSceneEndListener(2783);
    AppMethodBeat.o(45169);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45167);
    if ((paramm instanceof com.tencent.mm.plugin.remittance.model.e))
    {
      paramString = (com.tencent.mm.plugin.remittance.model.e)paramm;
      paramString.a(new RemittanceUI.3(this, paramString)).b(new p.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(45161);
          ab.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          AppMethodBeat.o(45161);
        }
      }).c(new RemittanceUI.1(this, paramString));
      AppMethodBeat.o(45167);
      return true;
    }
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    AppMethodBeat.o(45167);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI
 * JD-Core Version:    0.7.0.1
 */