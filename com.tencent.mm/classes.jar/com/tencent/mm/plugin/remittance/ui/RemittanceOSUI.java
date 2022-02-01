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
import com.tencent.mm.ak.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.a.aat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(19)
public class RemittanceOSUI
  extends RemittanceBaseUI
  implements e.a
{
  private int CwF;
  private String CwG;
  private String CwH;
  private String CwI;
  private String CwJ;
  private boolean CwK;
  private IListener zlO;
  
  public RemittanceOSUI()
  {
    AppMethodBeat.i(68262);
    this.CwK = false;
    this.zlO = new IListener() {};
    AppMethodBeat.o(68262);
  }
  
  public final void Mr(String paramString) {}
  
  protected final void aMa(String paramString)
  {
    AppMethodBeat.i(68267);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    f.b(getContext(), localIntent, 3);
    this.CwK = true;
    AppMethodBeat.o(68267);
  }
  
  public final void aMj(String paramString)
  {
    AppMethodBeat.i(68266);
    String str2 = z.aUa();
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = z.aTY();
    }
    g.aAi();
    as localas = ((l)g.af(l.class)).aSN().Kn(this.goe);
    str2 = this.goe;
    if ((int)localas.gMZ != 0) {
      str2 = localas.arJ();
    }
    paramString = new ab(this.jVp, str1, this.goe, str2, paramString, this.CwF);
    paramString.setProcessName("RemittanceProcess");
    doSceneProgress(paramString);
    com.tencent.mm.plugin.report.service.h.CyF.a(13337, new Object[] { Integer.valueOf(1), Double.valueOf(this.jVp) });
    AppMethodBeat.o(68266);
  }
  
  protected final void aMo(String paramString)
  {
    AppMethodBeat.i(68268);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    f.b(getContext(), localIntent, 3);
    this.CwK = true;
    AppMethodBeat.o(68268);
  }
  
  public final void eNJ()
  {
    AppMethodBeat.i(68263);
    com.tencent.mm.plugin.report.service.h.CyF.a(13337, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(68263);
  }
  
  public final void eNK()
  {
    AppMethodBeat.i(68264);
    u.makeText(getContext(), getString(2131764573, new Object[] { this.CwG }), 0).show();
    AppMethodBeat.o(68264);
  }
  
  public final void eNN()
  {
    AppMethodBeat.i(68269);
    if (!Util.isNullOrNil(this.CwI))
    {
      f.a((TextView)findViewById(2131297330), "", this.CwI, this.CwJ);
      AppMethodBeat.o(68269);
      return;
    }
    Log.i("MicroMsg.RemittanceOSUI", "no bulletin data");
    AppMethodBeat.o(68269);
  }
  
  public int getLayoutId()
  {
    return 2131496105;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68273);
    Log.d("MicroMsg.RemittanceOSUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.goe);
    this.CwK = false;
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
    EventCenter.instance.add(this.zlO);
    this.mNetSceneMgr.addSceneEndListener(1622);
    this.mNetSceneMgr.addSceneEndListener(1574);
    initView();
    this.qAh.setTitleText("");
    p.aYn().a(this);
    this.CwF = getIntent().getIntExtra("os_currency", 0);
    this.CwG = getIntent().getStringExtra("os_currencyuint");
    this.CwH = getIntent().getStringExtra("os_currencywording");
    this.CwI = getIntent().getStringExtra("os_notice");
    this.CwJ = getIntent().getStringExtra("os_notice_url");
    this.qAh.setTitleText(this.CwG);
    eNN();
    AppMethodBeat.o(68265);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68272);
    super.onDestroy();
    EventCenter.instance.removeListener(this.zlO);
    p.aYn().b(this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(68274);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq, paramBoolean);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof ab)))
    {
      paramString = (ab)paramq;
      if (paramString.CoV <= 0) {
        break label260;
      }
      if (paramString.Cqo != 0) {
        break label177;
      }
      com.tencent.mm.ui.base.h.c(this, getString(2131764585, new Object[] { Integer.valueOf(paramString.CoV) }), getString(2131755962), getString(2131764510), getString(2131764572), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68258);
          RemittanceOSUI.this.aMa(paramString.CoO);
          AppMethodBeat.o(68258);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68259);
          RemittanceOSUI.this.aMo(paramString.Cqn);
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
        paramString = ((ab)paramq).CoO;
        paramq = new Intent();
        paramq.putExtra("rawUrl", paramString);
        paramq.putExtra("showShare", false);
        f.b(getContext(), paramq, 3);
      }
      AppMethodBeat.o(68274);
      return;
      label177:
      if (paramString.Cqo == 1)
      {
        com.tencent.mm.ui.base.h.c(this, getString(2131764585, new Object[] { Integer.valueOf(paramString.CoV) }), getString(2131755962), getString(2131764510), getString(2131764572), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68260);
            RemittanceOSUI.this.aMa(paramString.CoO);
            AppMethodBeat.o(68260);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68261);
            RemittanceOSUI.this.aMo(paramString.Cqn);
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