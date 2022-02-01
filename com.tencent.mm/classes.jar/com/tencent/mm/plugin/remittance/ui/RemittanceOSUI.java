package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(19)
public class RemittanceOSUI
  extends RemittanceBaseUI
  implements e.a
{
  private c tut;
  private int vIi;
  private String vIj;
  private String vIk;
  private String vIl;
  private String vIm;
  private boolean vIn;
  
  public RemittanceOSUI()
  {
    AppMethodBeat.i(68262);
    this.vIn = false;
    this.tut = new c() {};
    AppMethodBeat.o(68262);
  }
  
  protected final void ame(String paramString)
  {
    AppMethodBeat.i(68267);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.wallet_core.ui.e.b(getContext(), localIntent, 3);
    this.vIn = true;
    AppMethodBeat.o(68267);
  }
  
  public final void amn(String paramString)
  {
    AppMethodBeat.i(68266);
    String str2 = u.aqI();
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = u.aqG();
    }
    g.afC();
    af localaf = ((k)g.ab(k.class)).apM().aHY(this.flk);
    str2 = this.flk;
    if ((int)localaf.fId != 0) {
      str2 = localaf.ZX();
    }
    paramString = new ab(this.vzp, str1, this.flk, str2, paramString, this.vIi);
    paramString.setProcessName("RemittanceProcess");
    doSceneProgress(paramString);
    com.tencent.mm.plugin.report.service.h.vKh.f(13337, new Object[] { Integer.valueOf(1), Double.valueOf(this.vzp) });
    AppMethodBeat.o(68266);
  }
  
  protected final void amq(String paramString)
  {
    AppMethodBeat.i(68268);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.wallet_core.ui.e.b(getContext(), localIntent, 3);
    this.vIn = true;
    AppMethodBeat.o(68268);
  }
  
  public final void djX()
  {
    AppMethodBeat.i(68263);
    com.tencent.mm.plugin.report.service.h.vKh.f(13337, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(68263);
  }
  
  public final void djY()
  {
    AppMethodBeat.i(68264);
    t.makeText(getContext(), getString(2131762506, new Object[] { this.vIj }), 0).show();
    AppMethodBeat.o(68264);
  }
  
  public final void dkb()
  {
    AppMethodBeat.i(68269);
    if (!bt.isNullOrNil(this.vIl))
    {
      com.tencent.mm.wallet_core.ui.e.a((TextView)findViewById(2131297186), "", this.vIl, this.vIm);
      AppMethodBeat.o(68269);
      return;
    }
    ad.i("MicroMsg.RemittanceOSUI", "no bulletin data");
    AppMethodBeat.o(68269);
  }
  
  public int getLayoutId()
  {
    return 2131495258;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68273);
    ad.d("MicroMsg.RemittanceOSUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.flk);
    this.vIn = false;
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
    com.tencent.mm.sdk.b.a.ESL.b(this.tut);
    this.mNetSceneMgr.addSceneEndListener(1622);
    this.mNetSceneMgr.addSceneEndListener(1574);
    initView();
    this.nXA.setTitleText("");
    p.auq().a(this);
    this.vIi = getIntent().getIntExtra("os_currency", 0);
    this.vIj = getIntent().getStringExtra("os_currencyuint");
    this.vIk = getIntent().getStringExtra("os_currencywording");
    this.vIl = getIntent().getStringExtra("os_notice");
    this.vIm = getIntent().getStringExtra("os_notice_url");
    this.nXA.setTitleText(this.vIj);
    dkb();
    AppMethodBeat.o(68265);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68272);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ESL.d(this.tut);
    p.auq().b(this);
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
      if (paramString.vAB <= 0) {
        break label260;
      }
      if (paramString.vBT != 0) {
        break label177;
      }
      com.tencent.mm.ui.base.h.d(this, getString(2131762518, new Object[] { Integer.valueOf(paramString.vAB) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68258);
          RemittanceOSUI.this.ame(paramString.vAu);
          AppMethodBeat.o(68258);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68259);
          RemittanceOSUI.this.amq(paramString.vBS);
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
        paramString = ((ab)paramn).vAu;
        paramn = new Intent();
        paramn.putExtra("rawUrl", paramString);
        paramn.putExtra("showShare", false);
        com.tencent.mm.wallet_core.ui.e.b(getContext(), paramn, 3);
      }
      AppMethodBeat.o(68274);
      return;
      label177:
      if (paramString.vBT == 1)
      {
        com.tencent.mm.ui.base.h.d(this, getString(2131762518, new Object[] { Integer.valueOf(paramString.vAB) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68260);
            RemittanceOSUI.this.ame(paramString.vAu);
            AppMethodBeat.o(68260);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68261);
            RemittanceOSUI.this.amq(paramString.vBS);
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
  
  public final void vZ(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSUI
 * JD-Core Version:    0.7.0.1
 */