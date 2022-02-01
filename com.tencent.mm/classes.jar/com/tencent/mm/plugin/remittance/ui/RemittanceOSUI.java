package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(19)
public class RemittanceOSUI
  extends RemittanceBaseUI
  implements e.a
{
  private c uCM;
  private int wSm;
  private String wSn;
  private String wSo;
  private String wSp;
  private String wSq;
  private boolean wSr;
  
  public RemittanceOSUI()
  {
    AppMethodBeat.i(68262);
    this.wSr = false;
    this.uCM = new c() {};
    AppMethodBeat.o(68262);
  }
  
  public final void Af(String paramString) {}
  
  protected final void arl(String paramString)
  {
    AppMethodBeat.i(68267);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.wallet_core.ui.e.b(getContext(), localIntent, 3);
    this.wSr = true;
    AppMethodBeat.o(68267);
  }
  
  public final void aru(String paramString)
  {
    AppMethodBeat.i(68266);
    String str2 = u.axy();
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = u.axw();
    }
    g.agS();
    ai localai = ((k)g.ab(k.class)).awB().aNt(this.foE);
    str2 = this.foE;
    if ((int)localai.fLJ != 0) {
      str2 = localai.aaS();
    }
    paramString = new ab(this.wJu, str1, this.foE, str2, paramString, this.wSm);
    paramString.setProcessName("RemittanceProcess");
    doSceneProgress(paramString);
    com.tencent.mm.plugin.report.service.h.wUl.f(13337, new Object[] { Integer.valueOf(1), Double.valueOf(this.wJu) });
    AppMethodBeat.o(68266);
  }
  
  protected final void arx(String paramString)
  {
    AppMethodBeat.i(68268);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.wallet_core.ui.e.b(getContext(), localIntent, 3);
    this.wSr = true;
    AppMethodBeat.o(68268);
  }
  
  public final void dxZ()
  {
    AppMethodBeat.i(68263);
    com.tencent.mm.plugin.report.service.h.wUl.f(13337, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(68263);
  }
  
  public final void dya()
  {
    AppMethodBeat.i(68264);
    t.makeText(getContext(), getString(2131762506, new Object[] { this.wSn }), 0).show();
    AppMethodBeat.o(68264);
  }
  
  public final void dyd()
  {
    AppMethodBeat.i(68269);
    if (!bs.isNullOrNil(this.wSp))
    {
      com.tencent.mm.wallet_core.ui.e.a((TextView)findViewById(2131297186), "", this.wSp, this.wSq);
      AppMethodBeat.o(68269);
      return;
    }
    ac.i("MicroMsg.RemittanceOSUI", "no bulletin data");
    AppMethodBeat.o(68269);
  }
  
  public int getLayoutId()
  {
    return 2131495258;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68273);
    ac.d("MicroMsg.RemittanceOSUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.foE);
    this.wSr = false;
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
    com.tencent.mm.sdk.b.a.GpY.b(this.uCM);
    this.mNetSceneMgr.addSceneEndListener(1622);
    this.mNetSceneMgr.addSceneEndListener(1574);
    initView();
    this.oAV.setTitleText("");
    p.aBh().a(this);
    this.wSm = getIntent().getIntExtra("os_currency", 0);
    this.wSn = getIntent().getStringExtra("os_currencyuint");
    this.wSo = getIntent().getStringExtra("os_currencywording");
    this.wSp = getIntent().getStringExtra("os_notice");
    this.wSq = getIntent().getStringExtra("os_notice_url");
    this.oAV.setTitleText(this.wSn);
    dyd();
    AppMethodBeat.o(68265);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68272);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.GpY.d(this.uCM);
    p.aBh().b(this);
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
      if (paramString.wKG <= 0) {
        break label260;
      }
      if (paramString.wLY != 0) {
        break label177;
      }
      com.tencent.mm.ui.base.h.d(this, getString(2131762518, new Object[] { Integer.valueOf(paramString.wKG) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68258);
          RemittanceOSUI.this.arl(paramString.wKz);
          AppMethodBeat.o(68258);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68259);
          RemittanceOSUI.this.arx(paramString.wLX);
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
        paramString = ((ab)paramn).wKz;
        paramn = new Intent();
        paramn.putExtra("rawUrl", paramString);
        paramn.putExtra("showShare", false);
        com.tencent.mm.wallet_core.ui.e.b(getContext(), paramn, 3);
      }
      AppMethodBeat.o(68274);
      return;
      label177:
      if (paramString.wLY == 1)
      {
        com.tencent.mm.ui.base.h.d(this, getString(2131762518, new Object[] { Integer.valueOf(paramString.wKG) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68260);
            RemittanceOSUI.this.arl(paramString.wKz);
            AppMethodBeat.o(68260);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68261);
            RemittanceOSUI.this.arx(paramString.wLX);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSUI
 * JD-Core Version:    0.7.0.1
 */