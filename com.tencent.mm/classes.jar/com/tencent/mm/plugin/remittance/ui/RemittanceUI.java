package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

public class RemittanceUI
  extends RemittanceNewBaseUI
{
  protected String ygt;
  private String ygu;
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, gh paramgh)
  {
    AppMethodBeat.i(68324);
    if (this.yad != null) {
      this.yad.j(3, new Object[] { Integer.valueOf(this.mPayScene), Double.valueOf(this.xXb) });
    }
    int k = getIntent().getIntExtra("pay_channel", -1);
    String str = "";
    Object localObject = str;
    if (!bt.V(new String[0]))
    {
      com.tencent.mm.kernel.g.ajD();
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTj(this.fGM);
      if (localObject != null) {
        localObject = ((am)localObject).adv();
      }
    }
    else
    {
      if (!bt.isNullOrNil(paramString6)) {
        break label400;
      }
      this.yaP = true;
      label127:
      ad.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[] { Integer.valueOf(k) });
      int j = 0;
      int i = 0;
      if (bt.jx(this.dFo, 4))
      {
        boolean bool1 = bt.K(Double.valueOf(this.yba), Double.valueOf(this.xXb));
        boolean bool2 = bt.lQ(this.ybb, paramString1);
        boolean bool3 = bt.lQ(this.ybc, paramString4);
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
      paramString1 = new w(this.xXb, "1", this.fGM, this.yaF, this.mPayScene, this.mScene, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, this.yaj, k, this.yaK, paramString6, this.yae, (String)localObject, this.yaF, paramgh, this.yaM, this.yaL, this.ygt, this.ygu, this.dFo, this.ybd, j);
      paramString1.setProcessName("RemittanceProcess");
      if (!this.mKindaEnable) {
        break label408;
      }
      showLoading();
      doSceneProgress(paramString1, false);
    }
    for (;;)
    {
      this.yaM = "";
      AppMethodBeat.o(68324);
      return;
      ad.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.fGM);
      localObject = str;
      break;
      label400:
      this.yaP = false;
      break label127;
      label408:
      doSceneProgress(paramString1);
    }
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final void dJR()
  {
    AppMethodBeat.i(68322);
    if (dJy())
    {
      com.tencent.mm.kernel.g.ajD();
      this.yaG = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ixm, ""));
      com.tencent.mm.kernel.g.ajD();
      this.yaH = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ixq, ""));
      com.tencent.mm.kernel.g.ajD();
      this.yaI = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ixr, Integer.valueOf(0))).intValue();
      if ((!bt.isNullOrNil(this.yaG)) && (!bt.isNullOrNil(this.yaH))) {
        break label148;
      }
      aj.a(true, null);
    }
    for (;;)
    {
      ad.d("MicroMsg.RemittanceUI", "do before transfer");
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.e(this.fGM), false);
      AppMethodBeat.o(68322);
      return;
      label148:
      aj.a(false, null);
    }
  }
  
  public final void dJs()
  {
    AppMethodBeat.i(68326);
    t.makeText(getContext(), 2131762419, 0).show();
    AppMethodBeat.o(68326);
  }
  
  public final void dJv()
  {
    AppMethodBeat.i(68328);
    final yi localyi = new yi();
    localyi.dMB.scene = "7";
    localyi.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68321);
        if (!bt.isNullOrNil(localyi.dMC.dMD))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)RemittanceUI.this.findViewById(2131297186), localyi.dMC.dMD, localyi.dMC.content, localyi.dMC.url);
          AppMethodBeat.o(68321);
          return;
        }
        ad.i("MicroMsg.RemittanceUI", "no bulletin data");
        AppMethodBeat.o(68321);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.l(localyi);
    AppMethodBeat.o(68328);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68323);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.g.yhR.f(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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
          ad.d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", new Object[] { paramString.xXK.FUR, paramString.xXK.ygt });
          RemittanceUI.this.yaF = paramString.xXK.FUR;
          RemittanceUI.this.ygt = paramString.xXK.ygt;
          RemittanceUI.this.yai = paramString.xXK.FUS;
          RemittanceUI.a(RemittanceUI.this, paramString.xXK.ygu);
          RemittanceUI.this.xWC = paramString.xXK.xZf;
          RemittanceUI.this.dJw();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI
 * JD-Core Version:    0.7.0.1
 */