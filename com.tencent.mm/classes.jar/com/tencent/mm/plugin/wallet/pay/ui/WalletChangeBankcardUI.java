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
import com.tencent.mm.g.a.xi;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.g.a.xr.a;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.plugin.wallet_core.ui.s.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletChangeBankcardUI
  extends WalletBaseUI
  implements a.a
{
  public static int zPX = 1;
  protected int dtb;
  public String ixc;
  protected PayInfo mPayInfo;
  protected TextView nBm;
  private c vFM;
  protected Button vHH;
  protected Orders vIq;
  public ArrayList<Bankcard> zGg;
  protected Bankcard zGh;
  protected Authen zNP;
  protected ListView zPY;
  public com.tencent.mm.plugin.wallet_core.ui.s zPZ;
  protected int zQa;
  public k zQb;
  protected String zQc;
  public FavorPayInfo zQd;
  private a zQe;
  com.tencent.mm.plugin.wallet_core.ui.f zQf;
  private boolean zQg;
  
  public WalletChangeBankcardUI()
  {
    AppMethodBeat.i(69313);
    this.dtb = 0;
    this.zGh = null;
    this.zQb = null;
    this.zNP = null;
    this.vIq = null;
    this.mPayInfo = null;
    this.zQc = null;
    this.zQf = null;
    this.vFM = new c() {};
    this.zQg = false;
    AppMethodBeat.o(69313);
  }
  
  private void eac()
  {
    AppMethodBeat.i(69314);
    Object localObject = com.tencent.mm.wallet_core.a.bo(this);
    if (localObject != null) {
      ((d)localObject).g(this, 1);
    }
    for (;;)
    {
      localObject = new xs();
      ((xs)localObject).dDU.result = -1;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(69314);
      return;
      finish();
    }
  }
  
  private ArrayList<Bankcard> ead()
  {
    AppMethodBeat.i(69317);
    if (this.dtb == 8)
    {
      localArrayList = (ArrayList)ae.sB(true);
      AppMethodBeat.o(69317);
      return localArrayList;
    }
    ArrayList localArrayList = (ArrayList)ae.sB(false);
    AppMethodBeat.o(69317);
    return localArrayList;
  }
  
  protected void Rn(int paramInt)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(69322);
    int i;
    Bankcard localBankcard;
    if (this.zGg != null)
    {
      i = this.zGg.size();
      ad.i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.zGg == null) || (paramInt >= i)) {
        break label181;
      }
      localBankcard = (Bankcard)this.zGg.get(paramInt);
      this.zGh = localBankcard;
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
    for (Object localObject = "";; localObject = this.mPayInfo.dcE)
    {
      af.f(paramInt, (String)localObject, 13, this.zGh.field_bindSerial);
      this.zQb.Amu = localBankcard.field_bindSerial;
      this.vHH.setEnabled(true);
      this.zQb.notifyDataSetChanged();
      eaf();
      AppMethodBeat.o(69322);
      return;
      i = 0;
      break;
      paramInt = this.mPayInfo.dtb;
      break label90;
    }
    label181:
    if (i == paramInt)
    {
      localObject = com.tencent.mm.plugin.wallet_core.model.g.ebF();
      if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bcB())
      {
        com.tencent.mm.ui.base.h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).unt, getString(2131755906), true);
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
    for (localObject = "";; localObject = this.mPayInfo.dcE)
    {
      af.f(paramInt, (String)localObject, 14, "");
      getInput().putInt("key_err_code", -1003);
      getInput().putBoolean("key_has_click_bind_new_card", true);
      com.tencent.mm.wallet_core.a.k(this, getInput());
      AppMethodBeat.o(69322);
      return;
      paramInt = this.mPayInfo.dtb;
      break;
    }
  }
  
  protected void atF(String paramString)
  {
    AppMethodBeat.i(69328);
    this.zNP.Abg = paramString;
    boolean bool = getInput().getBoolean("key_has_click_bind_new_card", false);
    int i = getInput().getInt("key_pay_flag");
    if ((bool) && (i == 3))
    {
      ad.i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
      this.zNP.dtM = 3;
    }
    if (this.zGh != null)
    {
      getInput().putString("key_mobile", this.zGh.field_mobile);
      getInput().putParcelable("key_bankcard", this.zGh);
      this.zNP.uns = this.zGh.field_bindSerial;
      this.zNP.dca = this.zGh.field_bankcardType;
      if (this.zQd == null) {
        break label338;
      }
      this.zNP.Abq = this.zQd.Aeb;
      if (this.vIq.Afy != null) {
        this.zNP.Abp = this.vIq.Afy.zOr;
      }
      if ((this.vIq != null) && (this.vIq.zWA == 3))
      {
        if (!this.zGh.eby()) {
          break label349;
        }
        this.zNP.dtM = 3;
        label212:
        Bundle localBundle = getInput();
        if (this.zGh.eby()) {
          break label361;
        }
        bool = true;
        label230:
        localBundle.putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putString("key_pwd1", paramString);
    getInput().putParcelable("key_authen", this.zNP);
    paramString = com.tencent.mm.plugin.wallet.pay.a.a.a(this.zNP, this.vIq, false);
    if (paramString != null)
    {
      paramString.setProcessName("PayProcess");
      paramString.setProcessBundle(getInput());
      if ((this.mPayInfo.dtb != 6) || (this.mPayInfo.Cop != 100)) {
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
      this.zNP.Abq = null;
      break;
      label349:
      this.zNP.dtM = 6;
      break label212;
      label361:
      bool = false;
      break label230;
      label366:
      paramString.setScene(this.mPayInfo.dtb);
    }
  }
  
  public final void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69332);
    ad.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
    if (paramBoolean)
    {
      ad.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.dlK = paramString1;
      this.mPayInfo.dlL = paramString2;
      atF(this.ixc);
      AppMethodBeat.o(69332);
      return;
    }
    ad.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
    atF(this.ixc);
    AppMethodBeat.o(69332);
  }
  
  public final void cE()
  {
    AppMethodBeat.i(69321);
    this.nBm = ((TextView)findViewById(2131301034));
    if ((this.zQd != null) && (!bt.isNullOrNil(this.zQd.Aef)))
    {
      this.nBm.setVisibility(0);
      this.nBm.setText(this.zQd.Aef);
      AppMethodBeat.o(69321);
      return;
    }
    if (getInput().getInt("key_main_bankcard_state", 0) != 0)
    {
      this.nBm.setVisibility(0);
      this.nBm.setText(this.zQc);
      AppMethodBeat.o(69321);
      return;
    }
    this.nBm.setVisibility(8);
    AppMethodBeat.o(69321);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(69329);
    if (paramInt == 0)
    {
      ctF();
      AppMethodBeat.o(69329);
      return;
    }
    if (paramInt == 1)
    {
      getInput().putString("key_pwd1", "");
      eaf();
      AppMethodBeat.o(69329);
      return;
    }
    ad.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
    AppMethodBeat.o(69329);
  }
  
  public final void ctF()
  {
    AppMethodBeat.i(69330);
    cancelQRPay();
    d locald = com.tencent.mm.wallet_core.a.bo(this);
    if (locald != null)
    {
      locald.b(this, getInput());
      AppMethodBeat.o(69330);
      return;
    }
    finish();
    AppMethodBeat.o(69330);
  }
  
  protected k eae()
  {
    AppMethodBeat.i(69320);
    k localk = new k(this, this.zGg, this.zQa, this.vIq);
    AppMethodBeat.o(69320);
    return localk;
  }
  
  protected void eaf()
  {
    AppMethodBeat.i(69327);
    ad.i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
    getInput().getString("key_pwd1");
    this.zQg = false;
    setContentViewVisibility(4);
    this.zPZ = com.tencent.mm.plugin.wallet_core.ui.s.a(this, this.vIq, this.zQd, this.zGh, this.mPayInfo, new s.c()new View.OnClickListener
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69310);
        if (WalletChangeBankcardUI.b(WalletChangeBankcardUI.this))
        {
          ad.w("MicroMsg.WalletChangeBankcardUI", "has receive cancel");
          com.tencent.mm.plugin.report.service.h.vKh.m(965L, 3L, 1L);
          AppMethodBeat.o(69310);
          return;
        }
        WalletChangeBankcardUI.this.zQd = paramAnonymousFavorPayInfo;
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.zQd);
        if ((WalletChangeBankcardUI.this.zQd != null) && (paramAnonymousBoolean))
        {
          if (WalletChangeBankcardUI.this.zQd != null)
          {
            WalletChangeBankcardUI.this.sr(true);
            WalletChangeBankcardUI.this.zQb.f(WalletChangeBankcardUI.this.zGg, false);
          }
          if (WalletChangeBankcardUI.this.zPZ != null) {
            WalletChangeBankcardUI.this.zPZ.dismiss();
          }
          WalletChangeBankcardUI.this.cE();
          WalletChangeBankcardUI.this.setContentViewVisibility(0);
          AppMethodBeat.o(69310);
          return;
        }
        WalletChangeBankcardUI.this.ixc = paramAnonymousString;
        WalletChangeBankcardUI.this.hideVKB();
        WalletChangeBankcardUI.this.atF(paramAnonymousString);
        WalletChangeBankcardUI.this.zQf = null;
        AppMethodBeat.o(69310);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69311);
        if (WalletChangeBankcardUI.this.zPZ != null) {
          WalletChangeBankcardUI.this.zPZ.dismiss();
        }
        WalletChangeBankcardUI.this.sr(false);
        WalletChangeBankcardUI.this.zQb.f(WalletChangeBankcardUI.this.zGg, true);
        WalletChangeBankcardUI.this.zQd = ((FavorPayInfo)paramAnonymousView.getTag());
        if (WalletChangeBankcardUI.this.zQd != null) {
          WalletChangeBankcardUI.this.zQd.Aef = "";
        }
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.zQd);
        WalletChangeBankcardUI.this.cE();
        WalletChangeBankcardUI.this.setContentViewVisibility(0);
        WalletChangeBankcardUI.this.zQf = null;
        AppMethodBeat.o(69311);
      }
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(69312);
        ad.i("MicroMsg.WalletChangeBankcardUI", "WalletPwdDialog event2 %s", new Object[] { bt.eGN().toString() });
        WalletChangeBankcardUI.c(WalletChangeBankcardUI.this);
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        WalletChangeBankcardUI.this.ixc = null;
        if (WalletChangeBankcardUI.d(WalletChangeBankcardUI.this).getVisibility() != 0) {
          WalletChangeBankcardUI.this.ctF();
        }
        WalletChangeBankcardUI.this.zQf = null;
        AppMethodBeat.o(69312);
      }
    });
    this.zQf = this.zPZ;
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
    this.vHH = ((Button)findViewById(2131303149));
    this.vHH.setEnabled(false);
    this.vHH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69308);
        WalletChangeBankcardUI.this.eaf();
        AppMethodBeat.o(69308);
      }
    });
    if (bt.isNullOrNil(getInput().getString("key_pwd1"))) {
      this.vHH.setText(2131755835);
    }
    for (;;)
    {
      this.zPY = ((ListView)findViewById(2131304652));
      this.zQb = eae();
      this.zPY.setAdapter(this.zQb);
      this.zPY.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(69309);
          WalletChangeBankcardUI.this.Rn(paramAnonymousInt);
          AppMethodBeat.o(69309);
        }
      });
      cE();
      AppMethodBeat.o(69319);
      return;
      this.vHH.setText(2131765745);
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
    if ((this.mPayInfo == null) || (!this.mPayInfo.rWX))
    {
      AppMethodBeat.o(69324);
      return false;
    }
    if (this.mPayInfo.rWX)
    {
      AppMethodBeat.o(69324);
      return true;
    }
    com.tencent.mm.plugin.wallet.a.s.dZT();
    if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecF())
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
    ad.i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == zPX) {
      eac();
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
    this.zQa = paramBundle.getInt("key_support_bankcard", 1);
    this.zNP = ((Authen)paramBundle.getParcelable("key_authen"));
    this.vIq = ((Orders)paramBundle.getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)paramBundle.getParcelable("key_pay_info"));
    this.zQd = ((FavorPayInfo)paramBundle.getParcelable("key_favor_pay_info"));
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      this.dtb = i;
      ad.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", new Object[] { Integer.valueOf(this.dtb) });
      if (!getInput().getBoolean("key_is_filter_bank_type")) {
        break label309;
      }
      sr(true);
    }
    for (;;)
    {
      if ((this.vIq != null) && (this.vIq.Afx != null) && (this.vIq.Afx.size() > 0)) {
        this.zQc = getString(2131765187, new Object[] { e.d(this.vIq.dcH, this.vIq.uop), ((Orders.Commodity)this.vIq.Afx.get(0)).desc });
      }
      initView();
      ab.jZ(7, 0);
      com.tencent.mm.sdk.b.a.ESL.c(this.vFM);
      if ((getInput().getBoolean("key_is_filter_bank_type")) && (this.zQb != null)) {
        this.zQb.Amv = false;
      }
      AppMethodBeat.o(69316);
      return;
      i = this.mPayInfo.dtb;
      break;
      label309:
      this.zGg = ead();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69318);
    if (this.zQe != null)
    {
      this.zQe.closeTipDialog();
      this.zQe.release();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.vFM);
    this.zQf = null;
    super.onDestroy();
    AppMethodBeat.o(69318);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69325);
    if ((paramInt == 4) && (this.zQd != null) && (this.zGg.size() == 0))
    {
      Object localObject = this.zQd;
      int i;
      if ((localObject != null) && (((FavorPayInfo)localObject).Aec != 0)) {
        i = 1;
      }
      while (i != 0)
      {
        ad.i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
        localObject = getInput().getString("key_is_cur_bankcard_bind_serial");
        if (bt.isNullOrNil((String)localObject))
        {
          ad.e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
          bool = super.onKeyUp(paramInt, paramKeyEvent);
          AppMethodBeat.o(69325);
          return bool;
          i = 0;
        }
        else
        {
          ArrayList localArrayList = ead();
          if ((localArrayList != null) && (this.zGh == null))
          {
            i = 0;
            for (;;)
            {
              if (i < localArrayList.size())
              {
                if (((String)localObject).equals(((Bankcard)localArrayList.get(i)).field_bindSerial))
                {
                  ad.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:".concat(String.valueOf(localObject)));
                  this.zGh = ((Bankcard)localArrayList.get(i));
                }
              }
              else
              {
                if (this.zGh != null) {
                  break;
                }
                ad.e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                bool = super.onKeyUp(paramInt, paramKeyEvent);
                AppMethodBeat.o(69325);
                return bool;
              }
              i += 1;
            }
          }
          eaf();
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
    if (this.zQf != null) {
      this.zQf.onActivityPause();
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
    if (this.zQf != null) {
      this.zQf.edM();
    }
    AppMethodBeat.o(69323);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
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
        if (!bt.isNullOrNil(this.ixc)) {
          paramString.putString("key_pwd1", this.ixc);
        }
        paramString.putString("kreq_token", paramn.getToken());
        paramString.putParcelable("key_authen", paramn.zPG);
        Object localObject1;
        Object localObject2;
        if (!paramn.zPE)
        {
          bool1 = true;
          paramString.putBoolean("key_need_verify_sms", bool1);
          paramString.putParcelable("key_pay_info", this.mPayInfo);
          paramString.putInt("key_pay_flag", 3);
          paramString.putInt("key_can_verify_tail", paramn.zPK);
          paramString.putString("key_verify_tail_wording", paramn.zPL);
          localObject1 = paramn.ujM;
          localObject2 = getInput();
          if (paramn.zPM != 1) {
            break label410;
          }
          bool1 = true;
          label189:
          ((Bundle)localObject2).putBoolean("key_block_bind_new_card", bool1);
          if (!bt.isNullOrNil(paramn.zPH)) {
            break label416;
          }
          paramString.putString("key_mobile", this.zGh.field_mobile);
          label224:
          paramString.putString("key_QADNA_URL", paramn.zPI);
          if (localObject1 != null) {
            paramString.putParcelable("key_realname_guide_helper", (Parcelable)localObject1);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("pwd", this.ixc);
          localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
          if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject2).ctN()) {
            break label431;
          }
          paramInt1 = 1;
        }
        for (;;)
        {
          ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
          ((com.tencent.mm.plugin.fingerprint.d.a)localObject2).a(paramn.dZZ(), true, (Bundle)localObject1);
          if (paramn.isPaySuccess)
          {
            paramString.putParcelable("key_orders", paramn.zPF);
            if ((this.mPayInfo != null) && (this.mPayInfo.dtb == 8))
            {
              paramn = new xi();
              paramn.dDt.dDu = this.zNP.uns;
              com.tencent.mm.sdk.b.a.ESL.l(paramn);
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
          paramString.putString("key_mobile", paramn.zPH);
          break label224;
          label431:
          paramInt1 = i;
          if (((com.tencent.mm.plugin.fingerprint.d.a)localObject2).ctQ()) {
            paramInt1 = 2;
          }
        }
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString("pwd", this.ixc);
      getInput().putBoolean("key_need_verify_sms", false);
      paramn = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.zNP.uXi.ApW != 1) {
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
    this.mPayInfo.Cot = paramInt2;
    eaf();
    AppMethodBeat.o(69326);
    return true;
    this.mPayInfo.Cot = paramInt2;
    bool1 = bool2;
    if (paramInt2 == 100100) {
      bool1 = true;
    }
    if (this.zQe == null) {
      this.zQe = new a(this, this);
    }
    this.zQe.a(bool1, this.mPayInfo.dlI, this.mPayInfo.dcE);
    ad.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(69326);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void sr(boolean paramBoolean)
  {
    AppMethodBeat.i(69331);
    this.zGg = ead();
    if (this.zQd != null) {
      if (this.zQd.Aec == 0) {
        break label48;
      }
    }
    label48:
    for (int i = 1; (i == 0) || (!paramBoolean); i = 0)
    {
      AppMethodBeat.o(69331);
      return;
    }
    String str = this.zQd.Aed;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    if (i < this.zGg.size())
    {
      Bankcard localBankcard = (Bankcard)this.zGg.get(i);
      if (bt.isNullOrNil(str)) {
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
    this.zGg = localArrayList;
    AppMethodBeat.o(69331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */