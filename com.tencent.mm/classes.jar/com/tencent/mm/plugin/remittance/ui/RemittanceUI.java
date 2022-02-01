package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.g.a.xo.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.r;

public class RemittanceUI
  extends RemittanceNewBaseUI
{
  protected String wSM;
  private String wSN;
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ge paramge)
  {
    AppMethodBeat.i(68324);
    if (this.wMw != null) {
      this.wMw.j(3, new Object[] { Integer.valueOf(this.mPayScene), Double.valueOf(this.wJu) });
    }
    int k = getIntent().getIntExtra("pay_channel", -1);
    String str = "";
    Object localObject = str;
    if (!bs.T(new String[0]))
    {
      g.agS();
      localObject = ((k)g.ab(k.class)).awB().aNr(this.foE);
      if (localObject != null) {
        localObject = ((ai)localObject).aaS();
      }
    }
    else
    {
      if (!bs.isNullOrNil(paramString6)) {
        break label400;
      }
      this.wNh = true;
      label127:
      ac.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[] { Integer.valueOf(k) });
      int j = 0;
      int i = 0;
      if (bs.jl(this.dtm, 4))
      {
        boolean bool1 = bs.I(Double.valueOf(this.wNs), Double.valueOf(this.wJu));
        boolean bool2 = bs.lr(this.wNt, paramString1);
        boolean bool3 = bs.lr(this.wNu, paramString4);
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
      paramString1 = new w(this.wJu, "1", this.foE, this.wMX, this.mPayScene, this.mScene, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, this.wMC, k, this.wNc, paramString6, this.wMx, (String)localObject, this.wMX, paramge, this.wNe, this.wNd, this.wSM, this.wSN, this.dtm, this.wNv, j);
      paramString1.setProcessName("RemittanceProcess");
      if (!this.mKindaEnable) {
        break label408;
      }
      showLoading();
      doSceneProgress(paramString1, false);
    }
    for (;;)
    {
      this.wNe = "";
      AppMethodBeat.o(68324);
      return;
      ac.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.foE);
      localObject = str;
      break;
      label400:
      this.wNh = false;
      break label127;
      label408:
      doSceneProgress(paramString1);
    }
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final void dya()
  {
    AppMethodBeat.i(68326);
    t.makeText(getContext(), 2131762419, 0).show();
    AppMethodBeat.o(68326);
  }
  
  public final void dyd()
  {
    AppMethodBeat.i(68328);
    final xo localxo = new xo();
    localxo.dAo.scene = "7";
    localxo.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68321);
        if (!bs.isNullOrNil(localxo.dAp.dAq))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)RemittanceUI.this.findViewById(2131297186), localxo.dAp.dAq, localxo.dAp.content, localxo.dAp.url);
          AppMethodBeat.o(68321);
          return;
        }
        ac.i("MicroMsg.RemittanceUI", "no bulletin data");
        AppMethodBeat.o(68321);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.l(localxo);
    AppMethodBeat.o(68328);
  }
  
  public final void dyz()
  {
    AppMethodBeat.i(68322);
    if (dyg())
    {
      g.agS();
      this.wMY = ((String)g.agR().agA().get(ah.a.GKU, ""));
      g.agS();
      this.wMZ = ((String)g.agR().agA().get(ah.a.GKY, ""));
      g.agS();
      this.wNa = ((Integer)g.agR().agA().get(ah.a.GKZ, Integer.valueOf(0))).intValue();
      if ((!bs.isNullOrNil(this.wMY)) && (!bs.isNullOrNil(this.wMZ))) {
        break label150;
      }
      aj.a(true, null);
    }
    for (;;)
    {
      ac.d("MicroMsg.RemittanceUI", "do before transfer");
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.e(this.foE), false);
      AppMethodBeat.o(68322);
      return;
      label150:
      aj.a(false, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68323);
    super.onCreate(paramBundle);
    h.wUl.f(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    addSceneEndListener(2783);
    AppMethodBeat.o(68323);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68327);
    super.onDestroy();
    removeSceneEndListener(2783);
    hideLoading();
    AppMethodBeat.o(68327);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68325);
    if ((paramn instanceof com.tencent.mm.plugin.remittance.model.e))
    {
      paramString = (com.tencent.mm.plugin.remittance.model.e)paramn;
      paramString.a(new RemittanceUI.3(this, paramString)).b(new RemittanceUI.2(this)).c(new RemittanceUI.1(this, paramString));
      AppMethodBeat.o(68325);
      return true;
    }
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    AppMethodBeat.o(68325);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean shouldEnsureSoterConnection()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI
 * JD-Core Version:    0.7.0.1
 */