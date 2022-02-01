package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.zm;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(19)
public class RemittanceOSUI
  extends RemittanceBaseUI
  implements e.a
{
  private com.tencent.mm.sdk.b.c vRI;
  private int yvK;
  private String yvL;
  private String yvM;
  private String yvN;
  private String yvO;
  private boolean yvP;
  
  public RemittanceOSUI()
  {
    AppMethodBeat.i(68262);
    this.yvP = false;
    this.vRI = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68262);
  }
  
  public final void DG(String paramString) {}
  
  protected final void axA(String paramString)
  {
    AppMethodBeat.i(68267);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    f.b(getContext(), localIntent, 3);
    this.yvP = true;
    AppMethodBeat.o(68267);
  }
  
  public final void axJ(String paramString)
  {
    AppMethodBeat.i(68266);
    String str2 = v.aAE();
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = v.aAC();
    }
    com.tencent.mm.kernel.g.ajS();
    an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.fIQ);
    str2 = this.fIQ;
    if ((int)localan.ght != 0) {
      str2 = localan.adG();
    }
    paramString = new ab(this.ymU, str1, this.fIQ, str2, paramString, this.yvK);
    paramString.setProcessName("RemittanceProcess");
    doSceneProgress(paramString);
    com.tencent.mm.plugin.report.service.g.yxI.f(13337, new Object[] { Integer.valueOf(1), Double.valueOf(this.ymU) });
    AppMethodBeat.o(68266);
  }
  
  protected final void axM(String paramString)
  {
    AppMethodBeat.i(68268);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    f.b(getContext(), localIntent, 3);
    this.yvP = true;
    AppMethodBeat.o(68268);
  }
  
  public final void dMJ()
  {
    AppMethodBeat.i(68263);
    com.tencent.mm.plugin.report.service.g.yxI.f(13337, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(68263);
  }
  
  public final void dMK()
  {
    AppMethodBeat.i(68264);
    t.makeText(getContext(), getString(2131762506, new Object[] { this.yvL }), 0).show();
    AppMethodBeat.o(68264);
  }
  
  public final void dMN()
  {
    AppMethodBeat.i(68269);
    if (!bu.isNullOrNil(this.yvN))
    {
      f.a((TextView)findViewById(2131297186), "", this.yvN, this.yvO);
      AppMethodBeat.o(68269);
      return;
    }
    ae.i("MicroMsg.RemittanceOSUI", "no bulletin data");
    AppMethodBeat.o(68269);
  }
  
  public int getLayoutId()
  {
    return 2131495258;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68273);
    ae.d("MicroMsg.RemittanceOSUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.fIQ);
    this.yvP = false;
    if ((paramInt1 == 3) && (paramInt2 == -1)) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(68273);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68265);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.IvT.b(this.vRI);
    this.mNetSceneMgr.addSceneEndListener(1622);
    this.mNetSceneMgr.addSceneEndListener(1574);
    initView();
    this.pkW.setTitleText("");
    p.aEA().a(this);
    this.yvK = getIntent().getIntExtra("os_currency", 0);
    this.yvL = getIntent().getStringExtra("os_currencyuint");
    this.yvM = getIntent().getStringExtra("os_currencywording");
    this.yvN = getIntent().getStringExtra("os_notice");
    this.yvO = getIntent().getStringExtra("os_notice_url");
    this.pkW.setTitleText(this.yvL);
    dMN();
    AppMethodBeat.o(68265);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68272);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IvT.d(this.vRI);
    p.aEA().b(this);
    this.mNetSceneMgr.removeSceneEndListener(1622);
    this.mNetSceneMgr.removeSceneEndListener(1574);
    AppMethodBeat.o(68272);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68271);
    super.onPause();
    AppMethodBeat.o(68271);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68270);
    super.onResume();
    AppMethodBeat.o(68270);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(68274);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn, paramBoolean);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof ab)))
    {
      paramString = (ab)paramn;
      if (paramString.yof <= 0) {
        break label260;
      }
      if (paramString.ypx != 0) {
        break label177;
      }
      h.e(this, getString(2131762518, new Object[] { Integer.valueOf(paramString.yof) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68258);
          RemittanceOSUI.this.axA(paramString.ynY);
          AppMethodBeat.o(68258);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68259);
          RemittanceOSUI.this.axM(paramString.ypw);
          AppMethodBeat.o(68259);
        }
      });
      paramInt1 = 1;
    }
    label260:
    for (;;)
    {
      if (paramInt1 == 0)
      {
        paramString = ((ab)paramn).ynY;
        paramn = new Intent();
        paramn.putExtra("rawUrl", paramString);
        paramn.putExtra("showShare", false);
        f.b(getContext(), paramn, 3);
      }
      AppMethodBeat.o(68274);
      return;
      label177:
      if (paramString.ypx == 1)
      {
        h.e(this, getString(2131762518, new Object[] { Integer.valueOf(paramString.yof) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68260);
            RemittanceOSUI.this.axA(paramString.ynY);
            AppMethodBeat.o(68260);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68261);
            RemittanceOSUI.this.axM(paramString.ypw);
            AppMethodBeat.o(68261);
          }
        });
        paramInt1 = 1;
      }
      else
      {
        paramInt1 = 0;
        continue;
        paramInt1 = 0;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSUI
 * JD-Core Version:    0.7.0.1
 */