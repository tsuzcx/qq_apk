package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.a.xd.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

public class RemittanceUI
  extends RemittanceNewBaseUI
{
  protected String vII;
  private String vIJ;
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, gd paramgd)
  {
    AppMethodBeat.i(68324);
    if (this.vCr != null) {
      this.vCr.j(3, new Object[] { Integer.valueOf(this.mPayScene), Double.valueOf(this.vzp) });
    }
    int k = getIntent().getIntExtra("pay_channel", -1);
    String str = "";
    Object localObject = str;
    if (!bt.T(new String[0]))
    {
      g.afC();
      localObject = ((k)g.ab(k.class)).apM().aHW(this.flk);
      if (localObject != null) {
        localObject = ((af)localObject).ZX();
      }
    }
    else
    {
      if (!bt.isNullOrNil(paramString6)) {
        break label400;
      }
      this.vDc = true;
      label127:
      ad.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[] { Integer.valueOf(k) });
      int j = 0;
      int i = 0;
      if (bt.iY(this.dvA, 4))
      {
        boolean bool1 = bt.I(Double.valueOf(this.vDn), Double.valueOf(this.vzp));
        boolean bool2 = bt.kU(this.vDo, paramString1);
        boolean bool3 = bt.kU(this.vDp, paramString4);
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
      paramString1 = new w(this.vzp, "1", this.flk, this.vCS, this.mPayScene, this.mScene, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, this.vCx, k, this.vCX, paramString6, this.vCs, (String)localObject, this.vCS, paramgd, this.vCZ, this.vCY, this.vII, this.vIJ, this.dvA, this.vDq, j);
      paramString1.setProcessName("RemittanceProcess");
      if (!this.mKindaEnable) {
        break label408;
      }
      showLoading();
      doSceneProgress(paramString1, false);
    }
    for (;;)
    {
      this.vCZ = "";
      AppMethodBeat.o(68324);
      return;
      ad.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.flk);
      localObject = str;
      break;
      label400:
      this.vDc = false;
      break label127;
      label408:
      doSceneProgress(paramString1);
    }
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final void djY()
  {
    AppMethodBeat.i(68326);
    t.makeText(getContext(), 2131762419, 0).show();
    AppMethodBeat.o(68326);
  }
  
  public final void dkb()
  {
    AppMethodBeat.i(68328);
    final xd localxd = new xd();
    localxd.dCC.scene = "7";
    localxd.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68321);
        if (!bt.isNullOrNil(localxd.dCD.dCE))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)RemittanceUI.this.findViewById(2131297186), localxd.dCD.dCE, localxd.dCD.content, localxd.dCD.url);
          AppMethodBeat.o(68321);
          return;
        }
        ad.i("MicroMsg.RemittanceUI", "no bulletin data");
        AppMethodBeat.o(68321);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.l(localxd);
    AppMethodBeat.o(68328);
  }
  
  public final void dkx()
  {
    AppMethodBeat.i(68322);
    if (dke())
    {
      g.afC();
      this.vCT = ((String)g.afB().afk().get(ae.a.Fnf, ""));
      g.afC();
      this.vCU = ((String)g.afB().afk().get(ae.a.Fnj, ""));
      g.afC();
      this.vCV = ((Integer)g.afB().afk().get(ae.a.Fnk, Integer.valueOf(0))).intValue();
      if ((!bt.isNullOrNil(this.vCT)) && (!bt.isNullOrNil(this.vCU))) {
        break label150;
      }
      aj.a(true, null);
    }
    for (;;)
    {
      ad.d("MicroMsg.RemittanceUI", "do before transfer");
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.e(this.flk), false);
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
    h.vKh.f(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(68325);
    if ((paramn instanceof com.tencent.mm.plugin.remittance.model.e))
    {
      paramString = (com.tencent.mm.plugin.remittance.model.e)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(68320);
          ad.d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", new Object[] { paramString.vzY.CUY, paramString.vzY.vII });
          RemittanceUI.this.vCS = paramString.vzY.CUY;
          RemittanceUI.this.vII = paramString.vzY.vII;
          RemittanceUI.this.vCw = paramString.vzY.CUZ;
          RemittanceUI.a(RemittanceUI.this, paramString.vzY.vIJ);
          RemittanceUI.this.vyQ = paramString.vzY.vBt;
          RemittanceUI.this.dkc();
          AppMethodBeat.o(68320);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(68319);
          ad.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          AppMethodBeat.o(68319);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(68318);
          ad.e("MicroMsg.RemittanceUI", "net error: %s", new Object[] { paramString });
          AppMethodBeat.o(68318);
        }
      });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI
 * JD-Core Version:    0.7.0.1
 */