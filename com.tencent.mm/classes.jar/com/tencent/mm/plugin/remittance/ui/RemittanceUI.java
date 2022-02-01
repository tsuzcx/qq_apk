package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.protocal.protobuf.wx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.f;

public class RemittanceUI
  extends RemittanceNewBaseUI
{
  protected String Cxg;
  private String Cxh;
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, gl paramgl)
  {
    AppMethodBeat.i(68324);
    if (this.CqM != null) {
      this.CqM.k(3, new Object[] { Integer.valueOf(this.mPayScene), Double.valueOf(this.jVp) });
    }
    int k = getIntent().getIntExtra("pay_channel", -1);
    String str = "";
    Object localObject = str;
    if (!Util.isNullOrNil(new String[0]))
    {
      g.aAi();
      localObject = ((l)g.af(l.class)).aSN().bjJ(this.goe);
      if (localObject != null) {
        localObject = ((as)localObject).arJ();
      }
    }
    else
    {
      if (!Util.isNullOrNil(paramString6)) {
        break label400;
      }
      this.Crx = true;
      label127:
      Log.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[] { Integer.valueOf(k) });
      int j = 0;
      int i = 0;
      if (Util.isEqual(this.dYe, 4))
      {
        boolean bool1 = Util.isEqual(Double.valueOf(this.CrI), Double.valueOf(this.jVp));
        boolean bool2 = Util.isEqual(this.CrJ, paramString1);
        boolean bool3 = Util.isEqual(this.CrK, paramString4);
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
      paramString1 = new w(this.jVp, "1", this.goe, this.Crn, this.mPayScene, this.mScene, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, this.CqS, k, this.Crs, paramString6, this.CqN, (String)localObject, this.Crn, paramgl, this.Cru, this.Crt, this.Cxg, this.Cxh, this.dYe, this.CrL, j);
      paramString1.setProcessName("RemittanceProcess");
      if (!this.mKindaEnable) {
        break label408;
      }
      showLoading();
      doSceneProgress(paramString1, false);
    }
    for (;;)
    {
      this.Cru = "";
      AppMethodBeat.o(68324);
      return;
      Log.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.goe);
      localObject = str;
      break;
      label400:
      this.Crx = false;
      break label127;
      label408:
      doSceneProgress(paramString1);
    }
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final void eNK()
  {
    AppMethodBeat.i(68326);
    u.makeText(getContext(), 2131764485, 0).show();
    AppMethodBeat.o(68326);
  }
  
  public final void eNN()
  {
    AppMethodBeat.i(68328);
    final zt localzt = new zt();
    localzt.efM.scene = "7";
    localzt.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68321);
        if (!Util.isNullOrNil(localzt.efN.efO))
        {
          f.a((TextView)RemittanceUI.this.findViewById(2131297330), localzt.efN.efO, localzt.efN.content, localzt.efN.url);
          AppMethodBeat.o(68321);
          return;
        }
        Log.i("MicroMsg.RemittanceUI", "no bulletin data");
        AppMethodBeat.o(68321);
      }
    };
    EventCenter.instance.publish(localzt);
    AppMethodBeat.o(68328);
  }
  
  public final void eOj()
  {
    AppMethodBeat.i(68322);
    if (eNQ())
    {
      g.aAi();
      this.Cro = ((String)g.aAh().azQ().get(ar.a.NZM, ""));
      g.aAi();
      this.Crp = ((String)g.aAh().azQ().get(ar.a.NZQ, ""));
      g.aAi();
      this.Crq = ((Integer)g.aAh().azQ().get(ar.a.NZR, Integer.valueOf(0))).intValue();
      if ((!Util.isNullOrNil(this.Cro)) && (!Util.isNullOrNil(this.Crp))) {
        break label150;
      }
      aj.a(true, null);
    }
    for (;;)
    {
      Log.d("MicroMsg.RemittanceUI", "do before transfer");
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.e(this.goe), false);
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
    h.CyF.a(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(68325);
    if ((paramq instanceof com.tencent.mm.plugin.remittance.model.e))
    {
      paramString = (com.tencent.mm.plugin.remittance.model.e)paramq;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(68320);
          Log.d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", new Object[] { paramString.Cos.LhU, paramString.Cos.Cxg });
          RemittanceUI.this.Crn = paramString.Cos.LhU;
          RemittanceUI.this.Cxg = paramString.Cos.Cxg;
          RemittanceUI.this.CqR = paramString.Cos.LhV;
          RemittanceUI.a(RemittanceUI.this, paramString.Cos.Cxh);
          RemittanceUI.this.Cnv = paramString.Cos.CpN;
          RemittanceUI.this.eNO();
          AppMethodBeat.o(68320);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(68319);
          Log.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          AppMethodBeat.o(68319);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(68318);
          Log.e("MicroMsg.RemittanceUI", "net error: %s", new Object[] { paramString });
          AppMethodBeat.o(68318);
        }
      });
      AppMethodBeat.o(68325);
      return true;
    }
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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