package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.g.a.yo.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.f;

public class RemittanceUI
  extends RemittanceNewBaseUI
{
  protected String ywk;
  private String ywl;
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, gi paramgi)
  {
    AppMethodBeat.i(68324);
    if (this.ypV != null) {
      this.ypV.j(3, new Object[] { Integer.valueOf(this.mPayScene), Double.valueOf(this.ymU) });
    }
    int k = getIntent().getIntExtra("pay_channel", -1);
    String str = "";
    Object localObject = str;
    if (!bu.V(new String[0]))
    {
      com.tencent.mm.kernel.g.ajS();
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUK(this.fIQ);
      if (localObject != null) {
        localObject = ((an)localObject).adG();
      }
    }
    else
    {
      if (!bu.isNullOrNil(paramString6)) {
        break label400;
      }
      this.yqG = true;
      label127:
      ae.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[] { Integer.valueOf(k) });
      int j = 0;
      int i = 0;
      if (bu.jB(this.dGt, 4))
      {
        boolean bool1 = bu.K(Double.valueOf(this.yqR), Double.valueOf(this.ymU));
        boolean bool2 = bu.lX(this.yqS, paramString1);
        boolean bool3 = bu.lX(this.yqT, paramString4);
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
      paramString1 = new w(this.ymU, "1", this.fIQ, this.yqw, this.mPayScene, this.mScene, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, this.yqb, k, this.yqB, paramString6, this.ypW, (String)localObject, this.yqw, paramgi, this.yqD, this.yqC, this.ywk, this.ywl, this.dGt, this.yqU, j);
      paramString1.setProcessName("RemittanceProcess");
      if (!this.mKindaEnable) {
        break label408;
      }
      showLoading();
      doSceneProgress(paramString1, false);
    }
    for (;;)
    {
      this.yqD = "";
      AppMethodBeat.o(68324);
      return;
      ae.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.fIQ);
      localObject = str;
      break;
      label400:
      this.yqG = false;
      break label127;
      label408:
      doSceneProgress(paramString1);
    }
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final void dMK()
  {
    AppMethodBeat.i(68326);
    t.makeText(getContext(), 2131762419, 0).show();
    AppMethodBeat.o(68326);
  }
  
  public final void dMN()
  {
    AppMethodBeat.i(68328);
    final yo localyo = new yo();
    localyo.dNR.scene = "7";
    localyo.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68321);
        if (!bu.isNullOrNil(localyo.dNS.dNT))
        {
          f.a((TextView)RemittanceUI.this.findViewById(2131297186), localyo.dNS.dNT, localyo.dNS.content, localyo.dNS.url);
          AppMethodBeat.o(68321);
          return;
        }
        ae.i("MicroMsg.RemittanceUI", "no bulletin data");
        AppMethodBeat.o(68321);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.l(localyo);
    AppMethodBeat.o(68328);
  }
  
  public final void dNj()
  {
    AppMethodBeat.i(68322);
    if (dMQ())
    {
      com.tencent.mm.kernel.g.ajS();
      this.yqx = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IRK, ""));
      com.tencent.mm.kernel.g.ajS();
      this.yqy = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IRO, ""));
      com.tencent.mm.kernel.g.ajS();
      this.yqz = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IRP, Integer.valueOf(0))).intValue();
      if ((!bu.isNullOrNil(this.yqx)) && (!bu.isNullOrNil(this.yqy))) {
        break label150;
      }
      com.tencent.mm.plugin.wallet_core.c.aj.a(true, null);
    }
    for (;;)
    {
      ae.d("MicroMsg.RemittanceUI", "do before transfer");
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.e(this.fIQ), false);
      AppMethodBeat.o(68322);
      return;
      label150:
      com.tencent.mm.plugin.wallet_core.c.aj.a(false, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68323);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.g.yxI.f(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI
 * JD-Core Version:    0.7.0.1
 */