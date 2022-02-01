package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.aca;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.model.aj;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.g;

@a(19)
public class RemittanceOSUI
  extends RemittanceBaseUI
  implements f.a
{
  private IListener ERe;
  private int IuH;
  private String IuI;
  private String IuJ;
  private String IuK;
  private String IuL;
  private boolean IuM;
  
  public RemittanceOSUI()
  {
    AppMethodBeat.i(68262);
    this.IuM = false;
    this.ERe = new IListener() {};
    AppMethodBeat.o(68262);
  }
  
  public final void TM(String paramString) {}
  
  protected final void aWE(String paramString)
  {
    AppMethodBeat.i(68267);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    g.c(getContext(), localIntent, 3);
    this.IuM = true;
    AppMethodBeat.o(68267);
  }
  
  public final void aWN(String paramString)
  {
    AppMethodBeat.i(68266);
    String str2 = z.bdb();
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = z.bcZ();
    }
    com.tencent.mm.kernel.h.aHH();
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.iSn);
    str2 = this.iSn;
    if ((int)localas.jxt != 0) {
      str2 = localas.ays();
    }
    paramString = new aj(this.mMC, str1, this.iSn, str2, paramString, this.IuH);
    paramString.setProcessName("RemittanceProcess");
    doSceneProgress(paramString);
    com.tencent.mm.plugin.report.service.h.IzE.a(13337, new Object[] { Integer.valueOf(1), Double.valueOf(this.mMC) });
    AppMethodBeat.o(68266);
  }
  
  protected final void aWS(String paramString)
  {
    AppMethodBeat.i(68268);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    g.c(getContext(), localIntent, 3);
    this.IuM = true;
    AppMethodBeat.o(68268);
  }
  
  public final void fAA()
  {
    AppMethodBeat.i(68264);
    w.makeText(getContext(), getString(a.i.remittance_os_amount_lowest_limit, new Object[] { this.IuI }), 0).show();
    AppMethodBeat.o(68264);
  }
  
  public final void fAD()
  {
    AppMethodBeat.i(68269);
    if (!Util.isNullOrNil(this.IuK))
    {
      g.a((TextView)findViewById(a.f.banner_tips), "", this.IuK, this.IuL);
      AppMethodBeat.o(68269);
      return;
    }
    Log.i("MicroMsg.RemittanceOSUI", "no bulletin data");
    AppMethodBeat.o(68269);
  }
  
  public final void fAz()
  {
    AppMethodBeat.i(68263);
    com.tencent.mm.plugin.report.service.h.IzE.a(13337, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(68263);
  }
  
  public int getLayoutId()
  {
    return a.g.remittance_new_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68273);
    Log.d("MicroMsg.RemittanceOSUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.iSn);
    this.IuM = false;
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
    EventCenter.instance.add(this.ERe);
    this.mNetSceneMgr.addSceneEndListener(1622);
    this.mNetSceneMgr.addSceneEndListener(1574);
    initView();
    this.tZh.setTitleText("");
    com.tencent.mm.am.q.bhz().a(this);
    this.IuH = getIntent().getIntExtra("os_currency", 0);
    this.IuI = getIntent().getStringExtra("os_currencyuint");
    this.IuJ = getIntent().getStringExtra("os_currencywording");
    this.IuK = getIntent().getStringExtra("os_notice");
    this.IuL = getIntent().getStringExtra("os_notice_url");
    this.tZh.setTitleText(this.IuI);
    fAD();
    AppMethodBeat.o(68265);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68272);
    super.onDestroy();
    EventCenter.instance.removeListener(this.ERe);
    com.tencent.mm.am.q.bhz().b(this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(68274);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq, paramBoolean);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof aj)))
    {
      paramString = (aj)paramq;
      if (paramString.Imk <= 0) {
        break label260;
      }
      if (paramString.InF != 0) {
        break label177;
      }
      com.tencent.mm.ui.base.h.c(this, getString(a.i.remittance_remind_desc_os, new Object[] { Integer.valueOf(paramString.Imk) }), getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.remittance_open_order_history_action), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68258);
          RemittanceOSUI.this.aWE(paramString.IlQ);
          AppMethodBeat.o(68258);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68259);
          RemittanceOSUI.this.aWS(paramString.InE);
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
        paramString = ((aj)paramq).IlQ;
        paramq = new Intent();
        paramq.putExtra("rawUrl", paramString);
        paramq.putExtra("showShare", false);
        g.c(getContext(), paramq, 3);
      }
      AppMethodBeat.o(68274);
      return;
      label177:
      if (paramString.InF == 1)
      {
        com.tencent.mm.ui.base.h.c(this, getString(a.i.remittance_remind_desc_os, new Object[] { Integer.valueOf(paramString.Imk) }), getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.remittance_open_order_history_action), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68260);
            RemittanceOSUI.this.aWE(paramString.IlQ);
            AppMethodBeat.o(68260);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68261);
            RemittanceOSUI.this.aWS(paramString.InE);
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