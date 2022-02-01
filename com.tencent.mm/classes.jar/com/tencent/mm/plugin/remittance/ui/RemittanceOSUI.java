package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.adx;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.model.ak;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(19)
public class RemittanceOSUI
  extends RemittanceBaseUI
  implements AvatarStorage.a
{
  private IListener KLC;
  private int Osl;
  private String Osm;
  private String Osn;
  private String Oso;
  private String Osp;
  private boolean Osq;
  
  public RemittanceOSUI()
  {
    AppMethodBeat.i(68262);
    this.Osq = false;
    this.KLC = new IListener(f.hfK) {};
    AppMethodBeat.o(68262);
  }
  
  public final void LM(String paramString) {}
  
  protected final void aTS(String paramString)
  {
    AppMethodBeat.i(68267);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.wallet_core.ui.i.d(getContext(), localIntent, 3);
    this.Osq = true;
    AppMethodBeat.o(68267);
  }
  
  public final void aUb(String paramString)
  {
    AppMethodBeat.i(68266);
    String str2 = z.bAO();
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = z.bAM();
    }
    com.tencent.mm.kernel.h.baF();
    au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.luk);
    str2 = this.luk;
    if ((int)localau.maN != 0) {
      str2 = localau.aSV();
    }
    paramString = new ak(this.pJk, str1, this.luk, str2, paramString, this.Osl);
    paramString.setProcessName("RemittanceProcess");
    doSceneProgress(paramString);
    com.tencent.mm.plugin.report.service.h.OAn.b(13337, new Object[] { Integer.valueOf(1), Double.valueOf(this.pJk) });
    AppMethodBeat.o(68266);
  }
  
  protected final void aUi(String paramString)
  {
    AppMethodBeat.i(68268);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.wallet_core.ui.i.d(getContext(), localIntent, 3);
    this.Osq = true;
    AppMethodBeat.o(68268);
  }
  
  public final void gMt()
  {
    AppMethodBeat.i(68263);
    com.tencent.mm.plugin.report.service.h.OAn.b(13337, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(68263);
  }
  
  public final void gMu()
  {
    AppMethodBeat.i(68264);
    aa.makeText(getContext(), getString(a.i.remittance_os_amount_lowest_limit, new Object[] { this.Osm }), 0).show();
    AppMethodBeat.o(68264);
  }
  
  public final void gMx()
  {
    AppMethodBeat.i(68269);
    if (!Util.isNullOrNil(this.Oso))
    {
      com.tencent.mm.wallet_core.ui.i.a(null, (TextView)findViewById(a.f.banner_tips), "", this.Oso, this.Osp);
      AppMethodBeat.o(68269);
      return;
    }
    Log.i("MicroMsg.RemittanceOSUI", "no bulletin data");
    AppMethodBeat.o(68269);
  }
  
  public int getLayoutId()
  {
    return a.g.remittance_new_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68273);
    Log.d("MicroMsg.RemittanceOSUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.luk);
    this.Osq = false;
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
    this.KLC.alive();
    this.mNetSceneMgr.addSceneEndListener(1622);
    this.mNetSceneMgr.addSceneEndListener(1574);
    initView();
    this.xcz.setTitleText("");
    com.tencent.mm.modelavatar.q.bFp().a(this);
    this.Osl = getIntent().getIntExtra("os_currency", 0);
    this.Osm = getIntent().getStringExtra("os_currencyuint");
    this.Osn = getIntent().getStringExtra("os_currencywording");
    this.Oso = getIntent().getStringExtra("os_notice");
    this.Osp = getIntent().getStringExtra("os_notice_url");
    this.xcz.setTitleText(this.Osm);
    gMx();
    AppMethodBeat.o(68265);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68272);
    super.onDestroy();
    this.KLC.dead();
    com.tencent.mm.modelavatar.q.bFp().b(this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(68274);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp, paramBoolean);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof ak)))
    {
      paramString = (ak)paramp;
      if (paramString.OjB <= 0) {
        break label260;
      }
      if (paramString.OkT != 0) {
        break label177;
      }
      k.b(this, getString(a.i.remittance_remind_desc_os, new Object[] { Integer.valueOf(paramString.OjB) }), getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.remittance_open_order_history_action), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68258);
          RemittanceOSUI.this.aTS(paramString.Ojh);
          AppMethodBeat.o(68258);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68259);
          RemittanceOSUI.this.aUi(paramString.OkS);
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
        paramString = ((ak)paramp).Ojh;
        paramp = new Intent();
        paramp.putExtra("rawUrl", paramString);
        paramp.putExtra("showShare", false);
        com.tencent.mm.wallet_core.ui.i.d(getContext(), paramp, 3);
      }
      AppMethodBeat.o(68274);
      return;
      label177:
      if (paramString.OkT == 1)
      {
        k.b(this, getString(a.i.remittance_remind_desc_os, new Object[] { Integer.valueOf(paramString.OjB) }), getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.remittance_open_order_history_action), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68260);
            RemittanceOSUI.this.aTS(paramString.Ojh);
            AppMethodBeat.o(68260);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68261);
            RemittanceOSUI.this.aUi(paramString.OkS);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSUI
 * JD-Core Version:    0.7.0.1
 */