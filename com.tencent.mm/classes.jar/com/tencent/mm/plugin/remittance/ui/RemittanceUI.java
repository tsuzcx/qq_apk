package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.aba;
import com.tencent.mm.f.a.aba.b;
import com.tencent.mm.f.a.gs;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.model.ae;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.fic;
import com.tencent.mm.protocal.protobuf.fid;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

public class RemittanceUI
  extends RemittanceNewBaseUI
{
  protected String Ivz;
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, gs paramgs)
  {
    AppMethodBeat.i(267404);
    if (this.Iol != null) {
      this.Iol.j(3, new Object[] { Integer.valueOf(this.mPayScene), Double.valueOf(this.mMC) });
    }
    int k = getIntent().getIntExtra("pay_channel", -1);
    String str = "";
    Object localObject = str;
    if (!Util.isNullOrNil(new String[0]))
    {
      com.tencent.mm.kernel.h.aHH();
      localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwg(this.iSn);
      if (localObject != null) {
        localObject = ((as)localObject).ays();
      }
    }
    else
    {
      if (!Util.isNullOrNil(paramString4)) {
        break label397;
      }
      this.IoV = true;
      label127:
      Log.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[] { Integer.valueOf(k) });
      int j = 0;
      int i = 0;
      if (Util.isEqual(this.fRV, 4))
      {
        boolean bool1 = Util.isEqual(Double.valueOf(this.Ipg), Double.valueOf(this.mMC));
        boolean bool2 = Util.isEqual(this.Iph, paramString1);
        boolean bool3 = Util.isEqual(this.Ipi, paramString2);
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
      paramString1 = new ae(this.mMC, "1", this.iSn, this.IoL, this.mPayScene, this.mScene, paramString1, paramString2, paramString3, this.Ior, k, this.IoQ, paramString4, this.Iom, (String)localObject, this.IoL, paramgs, this.IoS, this.IoR, this.Ivz, this.Iuv, this.fRV, this.Ipj, j, this.auA);
      paramString1.setProcessName("RemittanceProcess");
      if (!this.mKindaEnable) {
        break label405;
      }
      showLoading();
      doSceneProgress(paramString1, false);
    }
    for (;;)
    {
      this.IoS = "";
      AppMethodBeat.o(267404);
      return;
      Log.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.iSn);
      localObject = str;
      break;
      label397:
      this.IoV = false;
      break label127;
      label405:
      doSceneProgress(paramString1);
    }
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final void fAA()
  {
    AppMethodBeat.i(68326);
    w.makeText(getContext(), a.i.remittance_amount_lowest_limit, 0).show();
    AppMethodBeat.o(68326);
  }
  
  public final void fAD()
  {
    AppMethodBeat.i(68328);
    final aba localaba = new aba();
    localaba.gac.scene = "7";
    localaba.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68321);
        if (!Util.isNullOrNil(localaba.gad.gae))
        {
          com.tencent.mm.wallet_core.ui.g.a((TextView)RemittanceUI.this.findViewById(a.f.banner_tips), localaba.gad.gae, localaba.gad.content, localaba.gad.url);
          AppMethodBeat.o(68321);
          return;
        }
        Log.i("MicroMsg.RemittanceUI", "no bulletin data");
        AppMethodBeat.o(68321);
      }
    };
    EventCenter.instance.publish(localaba);
    AppMethodBeat.o(68328);
  }
  
  public final void fAY()
  {
    AppMethodBeat.i(68322);
    if (fAF())
    {
      com.tencent.mm.kernel.h.aHH();
      this.IoM = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnM, ""));
      com.tencent.mm.kernel.h.aHH();
      this.IoN = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnR, ""));
      com.tencent.mm.kernel.h.aHH();
      this.IoO = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnS, Integer.valueOf(0))).intValue();
      if ((!Util.isNullOrNil(this.IoM)) && (!Util.isNullOrNil(this.IoN))) {
        break label154;
      }
      ak.a(true, null);
    }
    for (;;)
    {
      Log.d("MicroMsg.RemittanceUI", "do before transfer");
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.g(this.iSn, this.auA), false);
      AppMethodBeat.o(68322);
      return;
      label154:
      ak.a(false, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68323);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.IzE.a(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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
    if ((paramq instanceof com.tencent.mm.plugin.remittance.model.g))
    {
      paramString = (com.tencent.mm.plugin.remittance.model.g)paramq;
      paramString.a(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(68320);
          Log.d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", new Object[] { paramString.Ilu.Sjj, paramString.Ilu.Ivz });
          RemittanceUI.this.IoL = paramString.Ilu.Sjj;
          RemittanceUI.this.Ivz = paramString.Ilu.Ivz;
          RemittanceUI.this.Iuv = paramString.Ilu.Iuv;
          RemittanceUI.this.Iko = paramString.Ilu.Inc;
          paramAnonymousString = RemittanceUI.this;
          paramAnonymousq = paramString;
          int i;
          if ((paramAnonymousq.Ilu.Ilg != null) && (paramAnonymousq.Ilu.Ilg.UHR == 1) && (paramAnonymousq.Ilu.Ilg.UHS != null) && (!Util.isNullOrNil(paramAnonymousq.Ilu.Ilg.UHS.wording)))
          {
            paramAnonymousq = paramAnonymousq.Ilu.Ilg;
            fid localfid = paramAnonymousq.UHS;
            paramAnonymousString.Iuy.setVisibility(0);
            Log.i("MicroMsg.RemittanceNewBaseUI", "warning textInfo.wording:%s", new Object[] { localfid.wording });
            paramAnonymousString.IuA.setText(localfid.wording);
            if ((ar.isDarkMode()) && (!Util.isNullOrNil(paramAnonymousq.UHT)))
            {
              paramAnonymousString.IuA.setTextColor(com.tencent.mm.wallet_core.ui.g.aIQ(paramAnonymousq.UHT));
              paramAnonymousInt1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramAnonymousString, 20.0F);
              paramAnonymousInt2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramAnonymousString, 8.0F);
              i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramAnonymousString, 16.0F);
              if ((!ar.isDarkMode()) || (Util.isNullOrNil(paramAnonymousq.UHV))) {
                break label431;
              }
              paramAnonymousString.IuB.w(paramAnonymousq.UHV, paramAnonymousInt1, paramAnonymousInt1, -1);
              label323:
              if ((!ar.isDarkMode()) || (Util.isNullOrNil(paramAnonymousq.UHX))) {
                break label449;
              }
              paramAnonymousString.IuC.w(paramAnonymousq.UHX, paramAnonymousInt2, i, -1);
              label356:
              paramAnonymousString.Iuy.postDelayed(new RemittanceNewBaseUI.35(paramAnonymousString), 10L);
              paramAnonymousString.Iuz.setClickable(true);
              paramAnonymousString.Iuz.setOnClickListener(new RemittanceNewBaseUI.36(paramAnonymousString, localfid));
            }
          }
          for (;;)
          {
            RemittanceUI.this.fAE();
            AppMethodBeat.o(68320);
            return;
            paramAnonymousString.IuA.setTextColor(com.tencent.mm.wallet_core.ui.g.aIQ(paramAnonymousq.Uba));
            break;
            label431:
            paramAnonymousString.IuB.w(paramAnonymousq.UHU, paramAnonymousInt1, paramAnonymousInt1, -1);
            break label323;
            label449:
            paramAnonymousString.IuC.w(paramAnonymousq.UHW, paramAnonymousInt2, i, -1);
            break label356;
            Log.i("MicroMsg.RemittanceNewBaseUI", "  do not show WarningView");
            paramAnonymousString.Iuy.setVisibility(8);
            paramAnonymousq = (LinearLayout.LayoutParams)paramAnonymousString.IoG.getLayoutParams();
            paramAnonymousq.topMargin = com.tencent.mm.ci.a.fromDPToPix(paramAnonymousString.getContext(), 0);
            paramAnonymousString.IoG.setLayoutParams(paramAnonymousq);
            paramAnonymousq = (LinearLayout.LayoutParams)paramAnonymousString.IuD.getLayoutParams();
            paramAnonymousq.topMargin = com.tencent.mm.ci.a.fromDPToPix(paramAnonymousString.getContext(), 32);
            paramAnonymousString.IuD.setLayoutParams(paramAnonymousq);
          }
        }
      }).b(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(68319);
          Log.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          AppMethodBeat.o(68319);
        }
      }).c(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI
 * JD-Core Version:    0.7.0.1
 */