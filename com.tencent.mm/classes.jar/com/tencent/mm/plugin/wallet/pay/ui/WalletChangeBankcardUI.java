package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.adc;
import com.tencent.mm.autogen.a.adl;
import com.tencent.mm.autogen.a.adl.a;
import com.tencent.mm.autogen.a.adm;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.model.ag;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletChangeBankcardUI
  extends WalletBaseUI
  implements a.a
{
  public static int Vnd = 1;
  private IListener CUH;
  protected Button OrJ;
  protected Orders OsJ;
  protected ArrayList<Bankcard> Vbt;
  protected Bankcard Vbu;
  protected Authen VkW;
  protected ListView Vne;
  protected u Vnf;
  protected int Vng;
  protected m Vnh;
  protected String Vni;
  protected FavorPayInfo Vnj;
  private a Vnk;
  com.tencent.mm.plugin.wallet_core.ui.h Vnl;
  private boolean Vnm;
  protected int hUR;
  protected PayInfo mPayInfo;
  protected String qgt;
  protected TextView wCr;
  
  public WalletChangeBankcardUI()
  {
    AppMethodBeat.i(69313);
    this.hUR = 0;
    this.Vbu = null;
    this.Vnh = null;
    this.VkW = null;
    this.OsJ = null;
    this.mPayInfo = null;
    this.Vni = null;
    this.Vnl = null;
    this.CUH = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Vnm = false;
    AppMethodBeat.o(69313);
  }
  
  private void ifX()
  {
    AppMethodBeat.i(69314);
    Object localObject = com.tencent.mm.wallet_core.a.cm(this);
    if (localObject != null) {
      ((e)localObject).i(this, 1);
    }
    for (;;)
    {
      localObject = new adm();
      ((adm)localObject).ihG.result = -1;
      ((adm)localObject).publish();
      AppMethodBeat.o(69314);
      return;
      finish();
    }
  }
  
  private ArrayList<Bankcard> ifY()
  {
    AppMethodBeat.i(69317);
    if (this.hUR == 8)
    {
      localArrayList = (ArrayList)ae.HH(true);
      AppMethodBeat.o(69317);
      return localArrayList;
    }
    ArrayList localArrayList = (ArrayList)ae.HH(false);
    AppMethodBeat.o(69317);
    return localArrayList;
  }
  
  private boolean ifZ()
  {
    return (this.mPayInfo != null) && (this.mPayInfo.hUR != 11);
  }
  
  protected final void Ht(boolean paramBoolean)
  {
    AppMethodBeat.i(69331);
    ifZ();
    this.Vbt = ifY();
    if (this.Vnj != null) {
      if (this.Vnj.VFD == 0) {
        break label51;
      }
    }
    label51:
    for (int i = 1; (i == 0) || (!paramBoolean); i = 0)
    {
      AppMethodBeat.o(69331);
      return;
    }
    String str = this.Vnj.VFE;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    if (i < this.Vbt.size())
    {
      Bankcard localBankcard = (Bankcard)this.Vbt.get(i);
      if (Util.isNullOrNil(str)) {
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
    this.Vbt = localArrayList;
    AppMethodBeat.o(69331);
  }
  
  protected void arU(int paramInt)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(69322);
    int i;
    Bankcard localBankcard;
    if (this.Vbt != null)
    {
      i = this.Vbt.size();
      Log.i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.Vbt == null) || (paramInt >= i)) {
        break label181;
      }
      localBankcard = (Bankcard)this.Vbt.get(paramInt);
      this.Vbu = localBankcard;
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
    for (Object localObject = "";; localObject = this.mPayInfo.hAT)
    {
      ag.g(paramInt, (String)localObject, 13, this.Vbu.field_bindSerial);
      this.Vnh.VOz = localBankcard.field_bindSerial;
      this.OrJ.setEnabled(true);
      this.Vnh.notifyDataSetChanged();
      igc();
      AppMethodBeat.o(69322);
      return;
      i = 0;
      break;
      paramInt = this.mPayInfo.hUR;
      break label90;
    }
    label181:
    if (i == paramInt)
    {
      localObject = g.iif();
      if (((g)localObject).cvt())
      {
        com.tencent.mm.ui.base.k.c(this, ((g)localObject).MDu, getString(a.i.app_tip), true);
        AppMethodBeat.o(69322);
        return;
      }
      if (this.mPayInfo != null) {
        break label292;
      }
      paramInt = k;
      if (this.mPayInfo != null) {
        break label303;
      }
    }
    label292:
    label303:
    for (localObject = "";; localObject = this.mPayInfo.hAT)
    {
      ag.g(paramInt, (String)localObject, 14, "");
      getInput().putInt("key_err_code", -1003);
      getInput().putBoolean("key_has_click_bind_new_card", true);
      com.tencent.mm.wallet_core.a.k(this, getInput());
      AppMethodBeat.o(69322);
      return;
      paramInt = this.mPayInfo.hUR;
      break;
    }
  }
  
  protected final void bgl(String paramString)
  {
    AppMethodBeat.i(69328);
    this.VkW.VCA = paramString;
    boolean bool = getInput().getBoolean("key_has_click_bind_new_card", false);
    int i = getInput().getInt("key_pay_flag");
    if ((bool) && (i == 3))
    {
      Log.i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
      this.VkW.eQp = 3;
    }
    if (this.Vbu != null)
    {
      getInput().putString("key_mobile", this.Vbu.field_mobile);
      getInput().putParcelable("key_bankcard", this.Vbu);
      this.VkW.MDt = this.Vbu.field_bindSerial;
      this.VkW.hAk = this.Vbu.field_bankcardType;
      if (this.Vnj == null) {
        break label338;
      }
      this.VkW.VCK = this.Vnj.VFC;
      if (this.OsJ.VGY != null) {
        this.VkW.VCJ = this.OsJ.VGY.Vlx;
      }
      if ((this.OsJ != null) && (this.OsJ.Vyb == 3))
      {
        if (!this.Vbu.ihY()) {
          break label349;
        }
        this.VkW.eQp = 3;
        label212:
        Bundle localBundle = getInput();
        if (this.Vbu.ihY()) {
          break label361;
        }
        bool = true;
        label230:
        localBundle.putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putString("key_pwd1", paramString);
    getInput().putParcelable("key_authen", this.VkW);
    paramString = com.tencent.mm.plugin.wallet.pay.a.a.a(this.VkW, this.OsJ, false);
    if (paramString != null)
    {
      paramString.setProcessName("PayProcess");
      paramString.setProcessBundle(getInput());
      if ((this.mPayInfo.hUR != 6) || (this.mPayInfo.YvD != 100)) {
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
      this.VkW.VCK = null;
      break;
      label349:
      this.VkW.eQp = 6;
      break label212;
      label361:
      bool = false;
      break label230;
      label366:
      paramString.setScene(this.mPayInfo.hUR);
    }
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(69329);
    if (paramInt == 0)
    {
      ftj();
      AppMethodBeat.o(69329);
      return;
    }
    if (paramInt == 1)
    {
      getInput().putString("key_pwd1", "");
      igc();
      AppMethodBeat.o(69329);
      return;
    }
    Log.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
    AppMethodBeat.o(69329);
  }
  
  protected final void ftj()
  {
    AppMethodBeat.i(69330);
    cancelQRPay();
    e locale = com.tencent.mm.wallet_core.a.cm(this);
    if (locale != null)
    {
      locale.b(this, getInput());
      AppMethodBeat.o(69330);
      return;
    }
    finish();
    AppMethodBeat.o(69330);
  }
  
  public final void g(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69332);
    Log.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
    if (paramBoolean)
    {
      Log.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.hMz = paramString1;
      this.mPayInfo.hMA = paramString2;
      bgl(this.qgt);
      AppMethodBeat.o(69332);
      return;
    }
    Log.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
    bgl(this.qgt);
    AppMethodBeat.o(69332);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_change_bankcard;
  }
  
  protected final void iga()
  {
    AppMethodBeat.i(315516);
    if (this.Vbt != null) {
      Collections.sort(this.Vbt, new Comparator() {});
    }
    AppMethodBeat.o(315516);
  }
  
  protected m igb()
  {
    AppMethodBeat.i(69320);
    m localm = new m(this, this.Vbt, this.Vng, this.OsJ);
    AppMethodBeat.o(69320);
    return localm;
  }
  
  protected final void igc()
  {
    AppMethodBeat.i(69327);
    Log.i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
    getInput().getString("key_pwd1");
    this.Vnm = false;
    setContentViewVisibility(4);
    this.Vnf = u.a(this, this.OsJ, this.Vnj, this.Vbu, this.mPayInfo, new u.c()new com.tencent.mm.wallet_core.ui.k
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(315507);
        if (WalletChangeBankcardUI.b(WalletChangeBankcardUI.this))
        {
          Log.w("MicroMsg.WalletChangeBankcardUI", "has receive cancel");
          com.tencent.mm.plugin.report.service.h.OAn.p(965L, 3L, 1L);
          AppMethodBeat.o(315507);
          return;
        }
        WalletChangeBankcardUI.this.Vnj = paramAnonymousFavorPayInfo;
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.Vnj);
        if ((WalletChangeBankcardUI.this.Vnj != null) && (paramAnonymousBoolean))
        {
          if (WalletChangeBankcardUI.this.Vnj != null)
          {
            WalletChangeBankcardUI.this.Ht(true);
            WalletChangeBankcardUI.this.Vnh.m(WalletChangeBankcardUI.this.Vbt, false);
          }
          if (WalletChangeBankcardUI.this.Vnf != null) {
            WalletChangeBankcardUI.this.Vnf.dismiss();
          }
          WalletChangeBankcardUI.this.updateView();
          WalletChangeBankcardUI.this.setContentViewVisibility(0);
          AppMethodBeat.o(315507);
          return;
        }
        WalletChangeBankcardUI.this.qgt = paramAnonymousString;
        WalletChangeBankcardUI.this.hideVKB();
        WalletChangeBankcardUI.this.bgl(paramAnonymousString);
        WalletChangeBankcardUI.this.Vnl = null;
        AppMethodBeat.o(315507);
      }
    }, new com.tencent.mm.wallet_core.ui.k()new DialogInterface.OnCancelListener
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(315510);
        if (WalletChangeBankcardUI.this.Vnf != null) {
          WalletChangeBankcardUI.this.Vnf.dismiss();
        }
        WalletChangeBankcardUI.this.Ht(false);
        WalletChangeBankcardUI.this.Vnh.m(WalletChangeBankcardUI.this.Vbt, true);
        WalletChangeBankcardUI.this.Vnj = ((FavorPayInfo)paramAnonymousView.getTag());
        if (WalletChangeBankcardUI.this.Vnj != null) {
          WalletChangeBankcardUI.this.Vnj.VFG = "";
        }
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.Vnj);
        WalletChangeBankcardUI.this.updateView();
        WalletChangeBankcardUI.this.setContentViewVisibility(0);
        WalletChangeBankcardUI.this.Vnl = null;
        AppMethodBeat.o(315510);
      }
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(315508);
        Log.i("MicroMsg.WalletChangeBankcardUI", "WalletPwdDialog event2 %s", new Object[] { Util.getStack().toString() });
        WalletChangeBankcardUI.c(WalletChangeBankcardUI.this);
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        WalletChangeBankcardUI.this.qgt = null;
        if (WalletChangeBankcardUI.d(WalletChangeBankcardUI.this).getVisibility() != 0) {
          WalletChangeBankcardUI.this.ftj();
        }
        WalletChangeBankcardUI.this.Vnl = null;
        AppMethodBeat.o(315508);
      }
    });
    this.Vnl = this.Vnf;
    AppMethodBeat.o(69327);
  }
  
  public void initView()
  {
    AppMethodBeat.i(69319);
    this.OrJ = ((Button)findViewById(a.f.pay_btn));
    this.OrJ.setEnabled(false);
    this.OrJ.setOnClickListener(new WalletChangeBankcardUI.3(this));
    if (Util.isNullOrNil(getInput().getString("key_pwd1"))) {
      this.OrJ.setText(a.i.app_ok);
    }
    for (;;)
    {
      this.Vne = ((ListView)findViewById(a.f.settings_lv_address));
      this.Vnh = igb();
      this.Vne.setAdapter(this.Vnh);
      this.Vne.setOnItemClickListener(new WalletChangeBankcardUI.4(this));
      ImageView localImageView = (ImageView)findViewById(a.f.wallet_back_iv);
      localImageView.setClickable(true);
      localImageView.setOnClickListener(new WalletChangeBankcardUI.5(this));
      aw.a(((TextView)findViewById(a.f.wallet_select_title)).getPaint(), 0.8F);
      updateView();
      AppMethodBeat.o(69319);
      return;
      this.OrJ.setText(a.i.wallet_pwd_dialog_pay_again);
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
    if ((this.mPayInfo == null) || (!this.mPayInfo.egT))
    {
      AppMethodBeat.o(69324);
      return false;
    }
    if (this.mPayInfo.egT)
    {
      AppMethodBeat.o(69324);
      return true;
    }
    com.tencent.mm.plugin.wallet.model.p.ifO();
    if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijf())
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
    Log.i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == Vnd) {
      ifX();
    }
    AppMethodBeat.o(69315);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69316);
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_select_use_bankcard_title);
    paramBundle = getInput();
    paramBundle.putInt("key_err_code", 0);
    this.Vng = paramBundle.getInt("key_support_bankcard", 1);
    this.VkW = ((Authen)paramBundle.getParcelable("key_authen"));
    this.OsJ = ((Orders)paramBundle.getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)paramBundle.getParcelable("key_pay_info"));
    this.Vnj = ((FavorPayInfo)paramBundle.getParcelable("key_favor_pay_info"));
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      this.hUR = i;
      Log.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", new Object[] { Integer.valueOf(this.hUR) });
      if (!getInput().getBoolean("key_is_filter_bank_type")) {
        break label305;
      }
      Ht(true);
    }
    for (;;)
    {
      if ((this.OsJ != null) && (this.OsJ.VGX != null) && (this.OsJ.VGX.size() > 0)) {
        this.Vni = getString(a.i.wallet_change_bankcard_tips, new Object[] { i.e(this.OsJ.hAW, this.OsJ.MEq), ((Orders.Commodity)this.OsJ.VGX.get(0)).desc });
      }
      initView();
      ac.pu(7, 0);
      this.CUH.alive();
      if ((getInput().getBoolean("key_is_filter_bank_type")) && (this.Vnh != null)) {
        this.Vnh.VOA = false;
      }
      AppMethodBeat.o(69316);
      return;
      i = this.mPayInfo.hUR;
      break;
      label305:
      ifZ();
      this.Vbt = ifY();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69318);
    if (this.Vnk != null)
    {
      this.Vnk.closeTipDialog();
      this.Vnk.release();
    }
    this.CUH.dead();
    this.Vnl = null;
    super.onDestroy();
    AppMethodBeat.o(69318);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69325);
    if ((paramInt == 4) && (this.Vnj != null) && (this.Vbt.size() == 0))
    {
      Object localObject = this.Vnj;
      int i;
      if ((localObject != null) && (((FavorPayInfo)localObject).VFD != 0)) {
        i = 1;
      }
      while (i != 0)
      {
        Log.i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
        localObject = getInput().getString("key_is_cur_bankcard_bind_serial");
        if (Util.isNullOrNil((String)localObject))
        {
          Log.e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
          bool = super.onKeyUp(paramInt, paramKeyEvent);
          AppMethodBeat.o(69325);
          return bool;
          i = 0;
        }
        else
        {
          ArrayList localArrayList = ifY();
          if ((localArrayList != null) && (this.Vbu == null))
          {
            i = 0;
            for (;;)
            {
              if (i < localArrayList.size())
              {
                if (((String)localObject).equals(((Bankcard)localArrayList.get(i)).field_bindSerial))
                {
                  Log.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:".concat(String.valueOf(localObject)));
                  this.Vbu = ((Bankcard)localArrayList.get(i));
                }
              }
              else
              {
                if (this.Vbu != null) {
                  break;
                }
                Log.e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                bool = super.onKeyUp(paramInt, paramKeyEvent);
                AppMethodBeat.o(69325);
                return bool;
              }
              i += 1;
            }
          }
          igc();
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
    if (this.Vnl != null) {
      this.Vnl.onActivityPause();
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
    if (this.Vnl != null) {
      this.Vnl.onActivityResume();
    }
    AppMethodBeat.o(69323);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    boolean bool2 = false;
    int i = 0;
    AppMethodBeat.i(69326);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof com.tencent.mm.plugin.wallet.pay.a.c.f))
      {
        AppMethodBeat.o(69326);
        return true;
      }
      if ((paramp instanceof b))
      {
        paramString = getInput();
        paramp = (b)paramp;
        if (!Util.isNullOrNil(this.qgt)) {
          paramString.putString("key_pwd1", this.qgt);
        }
        paramString.putString("kreq_token", paramp.getToken());
        paramString.putParcelable("key_authen", paramp.VmM);
        Object localObject1;
        Object localObject2;
        if (!paramp.VmK)
        {
          bool1 = true;
          paramString.putBoolean("key_need_verify_sms", bool1);
          paramString.putParcelable("key_pay_info", this.mPayInfo);
          paramString.putInt("key_pay_flag", 3);
          paramString.putInt("key_can_verify_tail", paramp.VmQ);
          paramString.putString("key_verify_tail_wording", paramp.VmR);
          localObject1 = paramp.MyJ;
          localObject2 = getInput();
          if (paramp.VmS != 1) {
            break label407;
          }
          bool1 = true;
          label189:
          ((Bundle)localObject2).putBoolean("key_block_bind_new_card", bool1);
          if (!Util.isNullOrNil(paramp.VmN)) {
            break label413;
          }
          paramString.putString("key_mobile", this.Vbu.field_mobile);
          label224:
          paramString.putString("key_QADNA_URL", paramp.VmO);
          if (localObject1 != null) {
            paramString.putParcelable("key_realname_guide_helper", (Parcelable)localObject1);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("pwd", this.qgt);
          localObject2 = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
          if (!((com.tencent.mm.plugin.fingerprint.c.a)localObject2).ftq()) {
            break label428;
          }
          paramInt1 = 1;
        }
        for (;;)
        {
          ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
          ((com.tencent.mm.plugin.fingerprint.c.a)localObject2).a(paramp.ifU(), true, (Bundle)localObject1);
          if (paramp.isPaySuccess)
          {
            paramString.putParcelable("key_orders", paramp.VmL);
            if ((this.mPayInfo != null) && (this.mPayInfo.hUR == 8))
            {
              paramp = new adc();
              paramp.ihe.ihf = this.VkW.MDt;
              paramp.publish();
            }
          }
          com.tencent.mm.wallet_core.a.k(this, paramString);
          AppMethodBeat.o(69326);
          return true;
          bool1 = false;
          break;
          label407:
          bool1 = false;
          break label189;
          label413:
          paramString.putString("key_mobile", paramp.VmN);
          break label224;
          label428:
          paramInt1 = i;
          if (((com.tencent.mm.plugin.fingerprint.c.a)localObject2).ftt()) {
            paramInt1 = 2;
          }
        }
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString("pwd", this.qgt);
      getInput().putBoolean("key_need_verify_sms", false);
      paramp = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
      if (this.VkW.Nxi.VSv != 1) {
        break label576;
      }
    }
    label576:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramp.a(bool1, true, paramString);
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(69326);
        return false;
      }
    }
    this.mPayInfo.YvG = paramInt2;
    igc();
    AppMethodBeat.o(69326);
    return true;
    this.mPayInfo.YvG = paramInt2;
    bool1 = bool2;
    if (paramInt2 == 100100) {
      bool1 = true;
    }
    if (this.Vnk == null) {
      this.Vnk = new a(this, this);
    }
    this.Vnk.d(bool1, this.mPayInfo.hMx, this.mPayInfo.hAT);
    Log.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(69326);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void updateView()
  {
    AppMethodBeat.i(69321);
    this.wCr = ((TextView)findViewById(a.f.input_tip));
    if ((this.Vnj != null) && (!Util.isNullOrNil(this.Vnj.VFG)))
    {
      this.wCr.setVisibility(0);
      this.wCr.setText(this.Vnj.VFG);
      AppMethodBeat.o(69321);
      return;
    }
    if (getInput().getInt("key_main_bankcard_state", 0) != 0)
    {
      this.wCr.setVisibility(0);
      this.wCr.setText(this.Vni);
      AppMethodBeat.o(69321);
      return;
    }
    this.wCr.setVisibility(8);
    AppMethodBeat.o(69321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */