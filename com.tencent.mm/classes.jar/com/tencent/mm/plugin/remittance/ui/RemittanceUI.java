package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.acx;
import com.tencent.mm.autogen.a.acx.b;
import com.tencent.mm.autogen.a.hd;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.model.af;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.geo;
import com.tencent.mm.protocal.protobuf.gep;
import com.tencent.mm.protocal.protobuf.yt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.i;

public class RemittanceUI
  extends RemittanceNewBaseUI
{
  protected String Otb;
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, hd paramhd)
  {
    AppMethodBeat.i(289054);
    if (this.OlE != null) {
      this.OlE.k(3, new Object[] { Integer.valueOf(this.mPayScene), Double.valueOf(this.pJk) });
    }
    int k = getIntent().getIntExtra("pay_channel", -1);
    String str = "";
    Object localObject = str;
    if (!Util.isNullOrNil(new String[0]))
    {
      com.tencent.mm.kernel.h.baF();
      localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxu(this.luk);
      if (localObject != null) {
        localObject = ((au)localObject).aSV();
      }
    }
    else
    {
      if (!Util.isNullOrNil(paramString4)) {
        break label397;
      }
      this.Omo = true;
      label127:
      Log.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[] { Integer.valueOf(k) });
      int j = 0;
      int i = 0;
      if (Util.isEqual(this.hXQ, 4))
      {
        boolean bool1 = Util.isEqual(Double.valueOf(this.Omz), Double.valueOf(this.pJk));
        boolean bool2 = Util.isEqual(this.OmA, paramString1);
        boolean bool3 = Util.isEqual(this.OmB, paramString2);
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
      paramString1 = new af(this.pJk, "1", this.luk, this.Ome, this.mPayScene, this.mScene, paramString1, paramString2, paramString3, this.OlK, k, this.Omj, paramString4, this.OlF, (String)localObject, this.Ome, paramhd, this.Oml, this.Omk, this.Otb, this.Osd, this.hXQ, this.OmC, j, this.ciX);
      paramString1.setProcessName("RemittanceProcess");
      if (!this.mKindaEnable) {
        break label405;
      }
      showLoading();
      doSceneProgress(paramString1, false);
    }
    for (;;)
    {
      this.Oml = "";
      AppMethodBeat.o(289054);
      return;
      Log.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.luk);
      localObject = str;
      break;
      label397:
      this.Omo = false;
      break label127;
      label405:
      doSceneProgress(paramString1);
    }
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final void eIA()
  {
    AppMethodBeat.i(68322);
    if (gMz())
    {
      com.tencent.mm.kernel.h.baF();
      this.Omf = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPh, ""));
      com.tencent.mm.kernel.h.baF();
      this.Omg = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPm, ""));
      com.tencent.mm.kernel.h.baF();
      this.Omh = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPn, Integer.valueOf(0))).intValue();
      if ((!Util.isNullOrNil(this.Omf)) && (!Util.isNullOrNil(this.Omg))) {
        break label152;
      }
      ak.a(true, null);
    }
    for (;;)
    {
      Log.d("MicroMsg.RemittanceUI", "do before transfer");
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.h(this.luk, this.ciX), false);
      AppMethodBeat.o(68322);
      return;
      label152:
      ak.a(false, null);
    }
  }
  
  public final void gMu()
  {
    AppMethodBeat.i(68326);
    aa.makeText(getContext(), a.i.remittance_amount_lowest_limit, 0).show();
    AppMethodBeat.o(68326);
  }
  
  public final void gMx()
  {
    AppMethodBeat.i(68328);
    final acx localacx = new acx();
    localacx.igk.scene = "7";
    localacx.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68321);
        if (!Util.isNullOrNil(localacx.igl.igm))
        {
          i.a(null, (TextView)RemittanceUI.this.findViewById(a.f.banner_tips), localacx.igl.igm, localacx.igl.content, localacx.igl.url);
          AppMethodBeat.o(68321);
          return;
        }
        Log.i("MicroMsg.RemittanceUI", "no bulletin data");
        AppMethodBeat.o(68321);
      }
    };
    localacx.publish();
    AppMethodBeat.o(68328);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68323);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.OAn.b(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(68325);
    if ((paramp instanceof com.tencent.mm.plugin.remittance.model.h))
    {
      paramString = (com.tencent.mm.plugin.remittance.model.h)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(68320);
          Log.d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", new Object[] { paramString.Oil.Zhp, paramString.Oil.Otb });
          RemittanceUI.this.Ome = paramString.Oil.Zhp;
          RemittanceUI.this.Otb = paramString.Oil.Otb;
          RemittanceUI.this.Osd = paramString.Oil.Osd;
          RemittanceUI.this.Ohb = paramString.Oil.Okq;
          paramAnonymousString = RemittanceUI.this;
          paramAnonymousp = paramString;
          int i;
          if ((paramAnonymousp.Oil.OhU != null) && (paramAnonymousp.Oil.OhU.abaE == 1) && (paramAnonymousp.Oil.OhU.acca != null) && (!Util.isNullOrNil(paramAnonymousp.Oil.OhU.acca.wording)))
          {
            paramAnonymousp = paramAnonymousp.Oil.OhU;
            gep localgep = paramAnonymousp.acca;
            paramAnonymousString.Osf.setVisibility(0);
            Log.i("MicroMsg.RemittanceNewBaseUI", "warning textInfo.wording:%s", new Object[] { localgep.wording });
            paramAnonymousString.Oew.setText(localgep.wording);
            if ((aw.isDarkMode()) && (!Util.isNullOrNil(paramAnonymousp.accb)))
            {
              paramAnonymousString.Oew.setTextColor(i.aHm(paramAnonymousp.accb));
              paramAnonymousInt1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramAnonymousString, 20.0F);
              paramAnonymousInt2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramAnonymousString, 8.0F);
              i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramAnonymousString, 16.0F);
              if ((!aw.isDarkMode()) || (Util.isNullOrNil(paramAnonymousp.accd))) {
                break label431;
              }
              paramAnonymousString.Oex.w(paramAnonymousp.accd, paramAnonymousInt1, paramAnonymousInt1, -1);
              label323:
              if ((!aw.isDarkMode()) || (Util.isNullOrNil(paramAnonymousp.accf))) {
                break label449;
              }
              paramAnonymousString.Oey.w(paramAnonymousp.accf, paramAnonymousInt2, i, -1);
              label356:
              paramAnonymousString.Osf.postDelayed(new RemittanceNewBaseUI.34(paramAnonymousString), 10L);
              paramAnonymousString.Osg.setClickable(true);
              paramAnonymousString.Osg.setOnClickListener(new RemittanceNewBaseUI.36(paramAnonymousString, localgep));
            }
          }
          for (;;)
          {
            RemittanceUI.this.gMy();
            AppMethodBeat.o(68320);
            return;
            paramAnonymousString.Oew.setTextColor(i.aHm(paramAnonymousp.absh));
            break;
            label431:
            paramAnonymousString.Oex.w(paramAnonymousp.accc, paramAnonymousInt1, paramAnonymousInt1, -1);
            break label323;
            label449:
            paramAnonymousString.Oey.w(paramAnonymousp.acce, paramAnonymousInt2, i, -1);
            break label356;
            Log.i("MicroMsg.RemittanceNewBaseUI", "  do not show WarningView");
            paramAnonymousString.Osf.setVisibility(8);
            paramAnonymousp = (LinearLayout.LayoutParams)paramAnonymousString.OlZ.getLayoutParams();
            paramAnonymousp.topMargin = com.tencent.mm.cd.a.fromDPToPix(paramAnonymousString.getContext(), 0);
            paramAnonymousString.OlZ.setLayoutParams(paramAnonymousp);
            paramAnonymousp = (LinearLayout.LayoutParams)paramAnonymousString.Osh.getLayoutParams();
            paramAnonymousp.topMargin = com.tencent.mm.cd.a.fromDPToPix(paramAnonymousString.getContext(), 32);
            paramAnonymousString.Osh.setLayoutParams(paramAnonymousp);
          }
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(68319);
          Log.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          AppMethodBeat.o(68319);
        }
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(68318);
          Log.e("MicroMsg.RemittanceUI", "net error: %s", new Object[] { paramString });
          AppMethodBeat.o(68318);
        }
      });
      AppMethodBeat.o(68325);
      return true;
    }
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI
 * JD-Core Version:    0.7.0.1
 */