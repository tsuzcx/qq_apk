package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(19)
public class RemittanceOSUI
  extends RemittanceBaseUI
  implements d.a
{
  private c ozT;
  private int qqX;
  private String qqY;
  private String qqZ;
  private String qra;
  private String qrb;
  private boolean qrc;
  
  public RemittanceOSUI()
  {
    AppMethodBeat.i(45097);
    this.qrc = false;
    this.ozT = new RemittanceOSUI.1(this);
    AppMethodBeat.o(45097);
  }
  
  public final void Yl(String paramString)
  {
    AppMethodBeat.i(142266);
    String str2 = r.Zp();
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = r.Zn();
    }
    g.RM();
    ad localad = ((j)g.E(j.class)).YA().arw(this.eaX);
    str2 = this.eaX;
    if ((int)localad.euF != 0) {
      str2 = localad.Of();
    }
    paramString = new aa(this.qlk, str1, this.eaX, str2, paramString, this.qqX);
    paramString.setProcessName("RemittanceProcess");
    doSceneProgress(paramString);
    com.tencent.mm.plugin.report.service.h.qsU.e(13337, new Object[] { Integer.valueOf(1), Double.valueOf(this.qlk) });
    AppMethodBeat.o(142266);
  }
  
  protected final void Yn(String paramString)
  {
    AppMethodBeat.i(45102);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent, 3);
    this.qrc = true;
    AppMethodBeat.o(45102);
  }
  
  protected final void Yo(String paramString)
  {
    AppMethodBeat.i(45103);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent, 3);
    this.qrc = true;
    AppMethodBeat.o(45103);
  }
  
  public final void chg()
  {
    AppMethodBeat.i(45098);
    com.tencent.mm.plugin.report.service.h.qsU.e(13337, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(45098);
  }
  
  public final void chh()
  {
    AppMethodBeat.i(45099);
    t.makeText(getContext(), getString(2131302600, new Object[] { this.qqY }), 0).show();
    AppMethodBeat.o(45099);
  }
  
  public final void chk()
  {
    AppMethodBeat.i(45104);
    if (!bo.isNullOrNil(this.qra))
    {
      e.a((TextView)findViewById(2131821672), "", this.qra, this.qrb);
      AppMethodBeat.o(45104);
      return;
    }
    ab.i("MicroMsg.RemittanceOSUI", "no bulletin data");
    AppMethodBeat.o(45104);
  }
  
  public int getLayoutId()
  {
    return 2130970574;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45108);
    ab.d("MicroMsg.RemittanceOSUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.eaX);
    this.qrc = false;
    if ((paramInt1 == 3) && (paramInt2 == -1)) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(45108);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45100);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.ymk.b(this.ozT);
    this.mNetSceneMgr.addSceneEndListener(1622);
    this.mNetSceneMgr.addSceneEndListener(1574);
    initView();
    this.kRl.setTitleText("");
    o.acQ().a(this);
    this.qqX = getIntent().getIntExtra("os_currency", 0);
    this.qqY = getIntent().getStringExtra("os_currencyuint");
    this.qqZ = getIntent().getStringExtra("os_currencywording");
    this.qra = getIntent().getStringExtra("os_notice");
    this.qrb = getIntent().getStringExtra("os_notice_url");
    this.kRl.setTitleText(this.qqY);
    chk();
    AppMethodBeat.o(45100);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45107);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ymk.d(this.ozT);
    o.acQ().b(this);
    this.mNetSceneMgr.removeSceneEndListener(1622);
    this.mNetSceneMgr.removeSceneEndListener(1574);
    AppMethodBeat.o(45107);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(45106);
    super.onPause();
    AppMethodBeat.o(45106);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45105);
    super.onResume();
    AppMethodBeat.o(45105);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(45109);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm, paramBoolean);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof aa)))
    {
      paramString = (aa)paramm;
      if (paramString.qjz <= 0) {
        break label261;
      }
      if (paramString.qkP != 0) {
        break label178;
      }
      com.tencent.mm.ui.base.h.d(this, getString(2131302612, new Object[] { Integer.valueOf(paramString.qjz) }), getString(2131297056), getString(2131302540), getString(2131302599), new DialogInterface.OnClickListener()new RemittanceOSUI.3
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45093);
          RemittanceOSUI.this.Yn(paramString.qjt);
          AppMethodBeat.o(45093);
        }
      }, new RemittanceOSUI.3(this, paramString));
      paramInt1 = 1;
    }
    label261:
    for (;;)
    {
      if (paramInt1 == 0)
      {
        paramString = ((aa)paramm).qjt;
        paramm = new Intent();
        paramm.putExtra("rawUrl", paramString);
        paramm.putExtra("showShare", false);
        com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramm, 3);
      }
      AppMethodBeat.o(45109);
      return;
      label178:
      if (paramString.qkP == 1)
      {
        com.tencent.mm.ui.base.h.d(this, getString(2131302612, new Object[] { Integer.valueOf(paramString.qjz) }), getString(2131297056), getString(2131302540), getString(2131302599), new RemittanceOSUI.4(this, paramString), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(45096);
            RemittanceOSUI.this.Yo(paramString.qkO);
            AppMethodBeat.o(45096);
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
  
  public final void re(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSUI
 * JD-Core Version:    0.7.0.1
 */