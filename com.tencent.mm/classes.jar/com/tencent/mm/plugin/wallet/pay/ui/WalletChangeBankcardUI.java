package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yt;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.g.a.zc.a;
import com.tencent.mm.g.a.zd;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.plugin.wallet_core.ui.s.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletChangeBankcardUI
  extends WalletBaseUI
  implements a.a
{
  public static int Dal = 1;
  public ArrayList<Bankcard> CQh;
  protected Bankcard CQi;
  protected Authen CYd;
  protected ListView Dam;
  public com.tencent.mm.plugin.wallet_core.ui.s Dan;
  protected int Dao;
  public k Dap;
  protected String Daq;
  public FavorPayInfo Dar;
  private a Das;
  com.tencent.mm.plugin.wallet_core.ui.f Dat;
  private boolean Dau;
  protected int dDH;
  public String jth;
  protected PayInfo mPayInfo;
  protected TextView oOi;
  private c ytq;
  protected Orders yvS;
  protected Button yvk;
  
  public WalletChangeBankcardUI()
  {
    AppMethodBeat.i(69313);
    this.dDH = 0;
    this.CQi = null;
    this.Dap = null;
    this.CYd = null;
    this.yvS = null;
    this.mPayInfo = null;
    this.Daq = null;
    this.Dat = null;
    this.ytq = new c() {};
    this.Dau = false;
    AppMethodBeat.o(69313);
  }
  
  private void eHf()
  {
    AppMethodBeat.i(69314);
    Object localObject = com.tencent.mm.wallet_core.a.bs(this);
    if (localObject != null) {
      ((d)localObject).g(this, 1);
    }
    for (;;)
    {
      localObject = new zd();
      ((zd)localObject).dPj.result = -1;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(69314);
      return;
      finish();
    }
  }
  
  private ArrayList<Bankcard> eHg()
  {
    AppMethodBeat.i(69317);
    if (this.dDH == 8)
    {
      localArrayList = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.uu(true);
      AppMethodBeat.o(69317);
      return localArrayList;
    }
    ArrayList localArrayList = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.uu(false);
    AppMethodBeat.o(69317);
    return localArrayList;
  }
  
  protected void VV(int paramInt)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(69322);
    int i;
    Bankcard localBankcard;
    if (this.CQh != null)
    {
      i = this.CQh.size();
      ae.i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.CQh == null) || (paramInt >= i)) {
        break label181;
      }
      localBankcard = (Bankcard)this.CQh.get(paramInt);
      this.CQi = localBankcard;
      if (this.mPayInfo != null) {
        break label158;
      }
      paramInt = j;
      label90:
      if (this.mPayInfo != null) {
        break label169;
      }
    }
    label158:
    label169:
    for (Object localObject = "";; localObject = this.mPayInfo.dmw)
    {
      com.tencent.mm.wallet_core.c.af.f(paramInt, (String)localObject, 13, this.CQi.field_bindSerial);
      this.Dap.DwL = localBankcard.field_bindSerial;
      this.yvk.setEnabled(true);
      this.Dap.notifyDataSetChanged();
      eHi();
      AppMethodBeat.o(69322);
      return;
      i = 0;
      break;
      paramInt = this.mPayInfo.dDH;
      break label90;
    }
    label181:
    if (i == paramInt)
    {
      localObject = com.tencent.mm.plugin.wallet_core.model.g.eII();
      if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bnS())
      {
        com.tencent.mm.ui.base.h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).wRu, getString(2131755906), true);
        AppMethodBeat.o(69322);
        return;
      }
      if (this.mPayInfo != null) {
        break label291;
      }
      paramInt = k;
      if (this.mPayInfo != null) {
        break label302;
      }
    }
    label291:
    label302:
    for (localObject = "";; localObject = this.mPayInfo.dmw)
    {
      com.tencent.mm.wallet_core.c.af.f(paramInt, (String)localObject, 14, "");
      getInput().putInt("key_err_code", -1003);
      getInput().putBoolean("key_has_click_bind_new_card", true);
      com.tencent.mm.wallet_core.a.k(this, getInput());
      AppMethodBeat.o(69322);
      return;
      paramInt = this.mPayInfo.dDH;
      break;
    }
  }
  
  protected void aFy(String paramString)
  {
    AppMethodBeat.i(69328);
    this.CYd.Dlv = paramString;
    boolean bool = getInput().getBoolean("key_has_click_bind_new_card", false);
    int i = getInput().getInt("key_pay_flag");
    if ((bool) && (i == 3))
    {
      ae.i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
      this.CYd.dEu = 3;
    }
    if (this.CQi != null)
    {
      getInput().putString("key_mobile", this.CQi.field_mobile);
      getInput().putParcelable("key_bankcard", this.CQi);
      this.CYd.wRt = this.CQi.field_bindSerial;
      this.CYd.dlT = this.CQi.field_bankcardType;
      if (this.Dar == null) {
        break label338;
      }
      this.CYd.DlF = this.Dar.Doq;
      if (this.yvS.DpQ != null) {
        this.CYd.DlE = this.yvS.DpQ.CYF;
      }
      if ((this.yvS != null) && (this.yvS.DgN == 3))
      {
        if (!this.CQi.eIB()) {
          break label349;
        }
        this.CYd.dEu = 3;
        label212:
        Bundle localBundle = getInput();
        if (this.CQi.eIB()) {
          break label361;
        }
        bool = true;
        label230:
        localBundle.putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putString("key_pwd1", paramString);
    getInput().putParcelable("key_authen", this.CYd);
    paramString = com.tencent.mm.plugin.wallet.pay.a.a.a(this.CYd, this.yvS, false);
    if (paramString != null)
    {
      paramString.setProcessName("PayProcess");
      paramString.setProcessBundle(getInput());
      if ((this.mPayInfo.dDH != 6) || (this.mPayInfo.FEn != 100)) {
        break label366;
      }
      paramString.setScene(100);
    }
    for (;;)
    {
      doSceneProgress(paramString);
      AppMethodBeat.o(69328);
      return;
      label338:
      this.CYd.DlF = null;
      break;
      label349:
      this.CYd.dEu = 6;
      break label212;
      label361:
      bool = false;
      break label230;
      label366:
      paramString.setScene(this.mPayInfo.dDH);
    }
  }
  
  public final void cRL()
  {
    AppMethodBeat.i(69330);
    cancelQRPay();
    d locald = com.tencent.mm.wallet_core.a.bs(this);
    if (locald != null)
    {
      locald.b(this, getInput());
      AppMethodBeat.o(69330);
      return;
    }
    finish();
    AppMethodBeat.o(69330);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(69329);
    if (paramInt == 0)
    {
      cRL();
      AppMethodBeat.o(69329);
      return;
    }
    if (paramInt == 1)
    {
      getInput().putString("key_pwd1", "");
      eHi();
      AppMethodBeat.o(69329);
      return;
    }
    ae.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
    AppMethodBeat.o(69329);
  }
  
  public final void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69332);
    ae.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
    if (paramBoolean)
    {
      ae.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.dwk = paramString1;
      this.mPayInfo.dwl = paramString2;
      aFy(this.jth);
      AppMethodBeat.o(69332);
      return;
    }
    ae.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
    aFy(this.jth);
    AppMethodBeat.o(69332);
  }
  
  protected k eHh()
  {
    AppMethodBeat.i(69320);
    k localk = new k(this, this.CQh, this.Dao, this.yvS);
    AppMethodBeat.o(69320);
    return localk;
  }
  
  protected void eHi()
  {
    AppMethodBeat.i(69327);
    ae.i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
    getInput().getString("key_pwd1");
    this.Dau = false;
    setContentViewVisibility(4);
    this.Dan = com.tencent.mm.plugin.wallet_core.ui.s.a(this, this.yvS, this.Dar, this.CQi, this.mPayInfo, new s.c()new View.OnClickListener
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69310);
        if (WalletChangeBankcardUI.b(WalletChangeBankcardUI.this))
        {
          ae.w("MicroMsg.WalletChangeBankcardUI", "has receive cancel");
          com.tencent.mm.plugin.report.service.g.yxI.n(965L, 3L, 1L);
          AppMethodBeat.o(69310);
          return;
        }
        WalletChangeBankcardUI.this.Dar = paramAnonymousFavorPayInfo;
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.Dar);
        if ((WalletChangeBankcardUI.this.Dar != null) && (paramAnonymousBoolean))
        {
          if (WalletChangeBankcardUI.this.Dar != null)
          {
            WalletChangeBankcardUI.this.uj(true);
            WalletChangeBankcardUI.this.Dap.f(WalletChangeBankcardUI.this.CQh, false);
          }
          if (WalletChangeBankcardUI.this.Dan != null) {
            WalletChangeBankcardUI.this.Dan.dismiss();
          }
          WalletChangeBankcardUI.this.updateView();
          WalletChangeBankcardUI.this.setContentViewVisibility(0);
          AppMethodBeat.o(69310);
          return;
        }
        WalletChangeBankcardUI.this.jth = paramAnonymousString;
        WalletChangeBankcardUI.this.hideVKB();
        WalletChangeBankcardUI.this.aFy(paramAnonymousString);
        WalletChangeBankcardUI.this.Dat = null;
        AppMethodBeat.o(69310);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69311);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WalletChangeBankcardUI.this.Dan != null) {
          WalletChangeBankcardUI.this.Dan.dismiss();
        }
        WalletChangeBankcardUI.this.uj(false);
        WalletChangeBankcardUI.this.Dap.f(WalletChangeBankcardUI.this.CQh, true);
        WalletChangeBankcardUI.this.Dar = ((FavorPayInfo)paramAnonymousView.getTag());
        if (WalletChangeBankcardUI.this.Dar != null) {
          WalletChangeBankcardUI.this.Dar.Dou = "";
        }
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.Dar);
        WalletChangeBankcardUI.this.updateView();
        WalletChangeBankcardUI.this.setContentViewVisibility(0);
        WalletChangeBankcardUI.this.Dat = null;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69311);
      }
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(69312);
        ae.i("MicroMsg.WalletChangeBankcardUI", "WalletPwdDialog event2 %s", new Object[] { bu.fpN().toString() });
        WalletChangeBankcardUI.c(WalletChangeBankcardUI.this);
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        WalletChangeBankcardUI.this.jth = null;
        if (WalletChangeBankcardUI.d(WalletChangeBankcardUI.this).getVisibility() != 0) {
          WalletChangeBankcardUI.this.cRL();
        }
        WalletChangeBankcardUI.this.Dat = null;
        AppMethodBeat.o(69312);
      }
    });
    this.Dat = this.Dan;
    AppMethodBeat.o(69327);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495933;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69319);
    this.yvk = ((Button)findViewById(2131303149));
    this.yvk.setEnabled(false);
    this.yvk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletChangeBankcardUI.this.eHi();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69308);
      }
    });
    if (bu.isNullOrNil(getInput().getString("key_pwd1"))) {
      this.yvk.setText(2131755835);
    }
    for (;;)
    {
      this.Dam = ((ListView)findViewById(2131304652));
      this.Dap = eHh();
      this.Dam.setAdapter(this.Dap);
      this.Dam.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(69309);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          WalletChangeBankcardUI.this.VV(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(69309);
        }
      });
      updateView();
      AppMethodBeat.o(69319);
      return;
      this.yvk.setText(2131765745);
    }
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69324);
    if (super.isTransparent())
    {
      AppMethodBeat.o(69324);
      return true;
    }
    if ((this.mPayInfo == null) || (!this.mPayInfo.unK))
    {
      AppMethodBeat.o(69324);
      return false;
    }
    if (this.mPayInfo.unK)
    {
      AppMethodBeat.o(69324);
      return true;
    }
    com.tencent.mm.plugin.wallet.a.s.eGW();
    if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJH())
    {
      AppMethodBeat.o(69324);
      return false;
    }
    AppMethodBeat.o(69324);
    return false;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69315);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == Dal) {
      eHf();
    }
    AppMethodBeat.o(69315);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69316);
    super.onCreate(paramBundle);
    setMMTitle(2131765865);
    paramBundle = getInput();
    paramBundle.putInt("key_err_code", 0);
    this.Dao = paramBundle.getInt("key_support_bankcard", 1);
    this.CYd = ((Authen)paramBundle.getParcelable("key_authen"));
    this.yvS = ((Orders)paramBundle.getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)paramBundle.getParcelable("key_pay_info"));
    this.Dar = ((FavorPayInfo)paramBundle.getParcelable("key_favor_pay_info"));
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      this.dDH = i;
      ae.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", new Object[] { Integer.valueOf(this.dDH) });
      if (!getInput().getBoolean("key_is_filter_bank_type")) {
        break label309;
      }
      uj(true);
    }
    for (;;)
    {
      if ((this.yvS != null) && (this.yvS.DpP != null) && (this.yvS.DpP.size() > 0)) {
        this.Daq = getString(2131765187, new Object[] { com.tencent.mm.wallet_core.ui.f.d(this.yvS.dmz, this.yvS.wSq), ((Orders.Commodity)this.yvS.DpP.get(0)).desc });
      }
      initView();
      ab.kI(7, 0);
      com.tencent.mm.sdk.b.a.IvT.c(this.ytq);
      if ((getInput().getBoolean("key_is_filter_bank_type")) && (this.Dap != null)) {
        this.Dap.DwM = false;
      }
      AppMethodBeat.o(69316);
      return;
      i = this.mPayInfo.dDH;
      break;
      label309:
      this.CQh = eHg();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69318);
    if (this.Das != null)
    {
      this.Das.closeTipDialog();
      this.Das.release();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.ytq);
    this.Dat = null;
    super.onDestroy();
    AppMethodBeat.o(69318);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69325);
    if ((paramInt == 4) && (this.Dar != null) && (this.CQh.size() == 0))
    {
      Object localObject = this.Dar;
      int i;
      if ((localObject != null) && (((FavorPayInfo)localObject).Dor != 0)) {
        i = 1;
      }
      while (i != 0)
      {
        ae.i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
        localObject = getInput().getString("key_is_cur_bankcard_bind_serial");
        if (bu.isNullOrNil((String)localObject))
        {
          ae.e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
          bool = super.onKeyUp(paramInt, paramKeyEvent);
          AppMethodBeat.o(69325);
          return bool;
          i = 0;
        }
        else
        {
          ArrayList localArrayList = eHg();
          if ((localArrayList != null) && (this.CQi == null))
          {
            i = 0;
            for (;;)
            {
              if (i < localArrayList.size())
              {
                if (((String)localObject).equals(((Bankcard)localArrayList.get(i)).field_bindSerial))
                {
                  ae.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:".concat(String.valueOf(localObject)));
                  this.CQi = ((Bankcard)localArrayList.get(i));
                }
              }
              else
              {
                if (this.CQi != null) {
                  break;
                }
                ae.e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                bool = super.onKeyUp(paramInt, paramKeyEvent);
                AppMethodBeat.o(69325);
                return bool;
              }
              i += 1;
            }
          }
          eHi();
          AppMethodBeat.o(69325);
          return true;
        }
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(69325);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69333);
    super.onPause();
    if (this.Dat != null) {
      this.Dat.onActivityPause();
    }
    AppMethodBeat.o(69333);
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69323);
    getInput().putInt("key_err_code", 0);
    super.onResume();
    if (this.Dat != null) {
      this.Dat.eKV();
    }
    AppMethodBeat.o(69323);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    boolean bool2 = false;
    int i = 0;
    AppMethodBeat.i(69326);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.c.f))
      {
        AppMethodBeat.o(69326);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        paramString = getInput();
        paramn = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramn;
        if (!bu.isNullOrNil(this.jth)) {
          paramString.putString("key_pwd1", this.jth);
        }
        paramString.putString("kreq_token", paramn.getToken());
        paramString.putParcelable("key_authen", paramn.CZU);
        Object localObject1;
        Object localObject2;
        if (!paramn.CZS)
        {
          bool1 = true;
          paramString.putBoolean("key_need_verify_sms", bool1);
          paramString.putParcelable("key_pay_info", this.mPayInfo);
          paramString.putInt("key_pay_flag", 3);
          paramString.putInt("key_can_verify_tail", paramn.CZY);
          paramString.putString("key_verify_tail_wording", paramn.CZZ);
          localObject1 = paramn.wNL;
          localObject2 = getInput();
          if (paramn.Daa != 1) {
            break label410;
          }
          bool1 = true;
          label189:
          ((Bundle)localObject2).putBoolean("key_block_bind_new_card", bool1);
          if (!bu.isNullOrNil(paramn.CZV)) {
            break label416;
          }
          paramString.putString("key_mobile", this.CQi.field_mobile);
          label224:
          paramString.putString("key_QADNA_URL", paramn.CZW);
          if (localObject1 != null) {
            paramString.putParcelable("key_realname_guide_helper", (Parcelable)localObject1);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("pwd", this.jth);
          localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
          if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject2).cRT()) {
            break label431;
          }
          paramInt1 = 1;
        }
        for (;;)
        {
          ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
          ((com.tencent.mm.plugin.fingerprint.d.a)localObject2).a(paramn.eHc(), true, (Bundle)localObject1);
          if (paramn.isPaySuccess)
          {
            paramString.putParcelable("key_orders", paramn.CZT);
            if ((this.mPayInfo != null) && (this.mPayInfo.dDH == 8))
            {
              paramn = new yt();
              paramn.dOI.dOJ = this.CYd.wRt;
              com.tencent.mm.sdk.b.a.IvT.l(paramn);
            }
          }
          com.tencent.mm.wallet_core.a.k(this, paramString);
          AppMethodBeat.o(69326);
          return true;
          bool1 = false;
          break;
          label410:
          bool1 = false;
          break label189;
          label416:
          paramString.putString("key_mobile", paramn.CZV);
          break label224;
          label431:
          paramInt1 = i;
          if (((com.tencent.mm.plugin.fingerprint.d.a)localObject2).cRW()) {
            paramInt1 = 2;
          }
        }
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString("pwd", this.jth);
      getInput().putBoolean("key_need_verify_sms", false);
      paramn = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.CYd.xDC.DAm != 1) {
        break label580;
      }
    }
    label580:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramn.a(bool1, true, paramString);
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(69326);
        return false;
      }
    }
    this.mPayInfo.FEq = paramInt2;
    eHi();
    AppMethodBeat.o(69326);
    return true;
    this.mPayInfo.FEq = paramInt2;
    bool1 = bool2;
    if (paramInt2 == 100100) {
      bool1 = true;
    }
    if (this.Das == null) {
      this.Das = new a(this, this);
    }
    this.Das.b(bool1, this.mPayInfo.dwi, this.mPayInfo.dmw);
    ae.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(69326);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void uj(boolean paramBoolean)
  {
    AppMethodBeat.i(69331);
    this.CQh = eHg();
    if (this.Dar != null) {
      if (this.Dar.Dor == 0) {
        break label48;
      }
    }
    label48:
    for (int i = 1; (i == 0) || (!paramBoolean); i = 0)
    {
      AppMethodBeat.o(69331);
      return;
    }
    String str = this.Dar.Dos;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    if (i < this.CQh.size())
    {
      Bankcard localBankcard = (Bankcard)this.CQh.get(i);
      if (bu.isNullOrNil(str)) {
        if (!localBankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
          localArrayList.add(localBankcard);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localBankcard.field_bankcardType.equals(str)) {
          localArrayList.add(localBankcard);
        }
      }
    }
    this.CQh = localArrayList;
    AppMethodBeat.o(69331);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(69321);
    this.oOi = ((TextView)findViewById(2131301034));
    if ((this.Dar != null) && (!bu.isNullOrNil(this.Dar.Dou)))
    {
      this.oOi.setVisibility(0);
      this.oOi.setText(this.Dar.Dou);
      AppMethodBeat.o(69321);
      return;
    }
    if (getInput().getInt("key_main_bankcard_state", 0) != 0)
    {
      this.oOi.setVisibility(0);
      this.oOi.setText(this.Daq);
      AppMethodBeat.o(69321);
      return;
    }
    this.oOi.setVisibility(8);
    AppMethodBeat.o(69321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */