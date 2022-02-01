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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.abf;
import com.tencent.mm.f.a.abo;
import com.tencent.mm.f.a.abo.a;
import com.tencent.mm.f.a.abp;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.a.c.f;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.t;
import com.tencent.mm.plugin.wallet_core.ui.t.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletChangeBankcardUI
  extends WalletBaseUI
  implements a.a
{
  public static int OxS = 1;
  private IListener IrT;
  protected Button Iub;
  protected Orders Ivh;
  public ArrayList<Bankcard> OmN;
  protected Bankcard OmO;
  protected Authen OvK;
  protected ListView OxT;
  public t OxU;
  protected int OxV;
  public l OxW;
  protected String OxX;
  public FavorPayInfo OxY;
  private a OxZ;
  com.tencent.mm.plugin.wallet_core.ui.g Oya;
  private boolean Oyb;
  protected int fOY;
  protected PayInfo mPayInfo;
  public String njf;
  protected TextView txU;
  
  public WalletChangeBankcardUI()
  {
    AppMethodBeat.i(69313);
    this.fOY = 0;
    this.OmO = null;
    this.OxW = null;
    this.OvK = null;
    this.Ivh = null;
    this.mPayInfo = null;
    this.OxX = null;
    this.Oya = null;
    this.IrT = new IListener() {};
    this.Oyb = false;
    AppMethodBeat.o(69313);
  }
  
  private void gGU()
  {
    AppMethodBeat.i(69314);
    Object localObject = com.tencent.mm.wallet_core.a.bF(this);
    if (localObject != null) {
      ((d)localObject).h(this, 1);
    }
    for (;;)
    {
      localObject = new abp();
      ((abp)localObject).gbw.result = -1;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(69314);
      return;
      finish();
    }
  }
  
  private ArrayList<Bankcard> gGV()
  {
    AppMethodBeat.i(69317);
    if (this.fOY == 8)
    {
      localArrayList = (ArrayList)ag.Cc(true);
      AppMethodBeat.o(69317);
      return localArrayList;
    }
    ArrayList localArrayList = (ArrayList)ag.Cc(false);
    AppMethodBeat.o(69317);
    return localArrayList;
  }
  
  private boolean gGW()
  {
    return (this.mPayInfo != null) && (this.mPayInfo.fOY != 11);
  }
  
  protected final void BO(boolean paramBoolean)
  {
    AppMethodBeat.i(69331);
    gGW();
    this.OmN = gGV();
    if (this.OxY != null) {
      if (this.OxY.OPJ == 0) {
        break label51;
      }
    }
    label51:
    for (int i = 1; (i == 0) || (!paramBoolean); i = 0)
    {
      AppMethodBeat.o(69331);
      return;
    }
    String str = this.OxY.OPK;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    if (i < this.OmN.size())
    {
      Bankcard localBankcard = (Bankcard)this.OmN.get(i);
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
    this.OmN = localArrayList;
    AppMethodBeat.o(69331);
  }
  
  protected void amk(int paramInt)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(69322);
    int i;
    Bankcard localBankcard;
    if (this.OmN != null)
    {
      i = this.OmN.size();
      Log.i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.OmN == null) || (paramInt >= i)) {
        break label181;
      }
      localBankcard = (Bankcard)this.OmN.get(paramInt);
      this.OmO = localBankcard;
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
    for (Object localObject = "";; localObject = this.mPayInfo.fwv)
    {
      af.f(paramInt, (String)localObject, 13, this.OmO.field_bindSerial);
      this.OxW.OYl = localBankcard.field_bindSerial;
      this.Iub.setEnabled(true);
      this.OxW.notifyDataSetChanged();
      gGY();
      AppMethodBeat.o(69322);
      return;
      i = 0;
      break;
      paramInt = this.mPayInfo.fOY;
      break label90;
    }
    label181:
    if (i == paramInt)
    {
      localObject = com.tencent.mm.plugin.wallet_core.model.g.gIR();
      if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bVd())
      {
        com.tencent.mm.ui.base.h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).GGD, getString(a.i.app_tip), true);
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
    for (localObject = "";; localObject = this.mPayInfo.fwv)
    {
      af.f(paramInt, (String)localObject, 14, "");
      getInput().putInt("key_err_code", -1003);
      getInput().putBoolean("key_has_click_bind_new_card", true);
      com.tencent.mm.wallet_core.a.l(this, getInput());
      AppMethodBeat.o(69322);
      return;
      paramInt = this.mPayInfo.fOY;
      break;
    }
  }
  
  protected void bgF(String paramString)
  {
    AppMethodBeat.i(69328);
    this.OvK.OMP = paramString;
    boolean bool = getInput().getBoolean("key_has_click_bind_new_card", false);
    int i = getInput().getInt("key_pay_flag");
    if ((bool) && (i == 3))
    {
      Log.i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
      this.OvK.cUP = 3;
    }
    if (this.OmO != null)
    {
      getInput().putString("key_mobile", this.OmO.field_mobile);
      getInput().putParcelable("key_bankcard", this.OmO);
      this.OvK.GGC = this.OmO.field_bindSerial;
      this.OvK.fvP = this.OmO.field_bankcardType;
      if (this.OxY == null) {
        break label338;
      }
      this.OvK.OMZ = this.OxY.OPI;
      if (this.Ivh.ORe != null) {
        this.OvK.OMY = this.Ivh.ORe.Owm;
      }
      if ((this.Ivh != null) && (this.Ivh.OIp == 3))
      {
        if (!this.OmO.gIK()) {
          break label349;
        }
        this.OvK.cUP = 3;
        label212:
        Bundle localBundle = getInput();
        if (this.OmO.gIK()) {
          break label361;
        }
        bool = true;
        label230:
        localBundle.putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putString("key_pwd1", paramString);
    getInput().putParcelable("key_authen", this.OvK);
    paramString = com.tencent.mm.plugin.wallet.pay.a.a.a(this.OvK, this.Ivh, false);
    if (paramString != null)
    {
      paramString.setProcessName("PayProcess");
      paramString.setProcessBundle(getInput());
      if ((this.mPayInfo.fOY != 6) || (this.mPayInfo.Rzf != 100)) {
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
      this.OvK.OMZ = null;
      break;
      label349:
      this.OvK.cUP = 6;
      break label212;
      label361:
      bool = false;
      break label230;
      label366:
      paramString.setScene(this.mPayInfo.fOY);
    }
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(69329);
    if (paramInt == 0)
    {
      eog();
      AppMethodBeat.o(69329);
      return;
    }
    if (paramInt == 1)
    {
      getInput().putString("key_pwd1", "");
      gGY();
      AppMethodBeat.o(69329);
      return;
    }
    Log.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
    AppMethodBeat.o(69329);
  }
  
  public final void eog()
  {
    AppMethodBeat.i(69330);
    cancelQRPay();
    d locald = com.tencent.mm.wallet_core.a.bF(this);
    if (locald != null)
    {
      locald.b(this, getInput());
      AppMethodBeat.o(69330);
      return;
    }
    finish();
    AppMethodBeat.o(69330);
  }
  
  protected l gGX()
  {
    AppMethodBeat.i(69320);
    l locall = new l(this, this.OmN, this.OxV, this.Ivh);
    AppMethodBeat.o(69320);
    return locall;
  }
  
  protected void gGY()
  {
    AppMethodBeat.i(69327);
    Log.i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
    getInput().getString("key_pwd1");
    this.Oyb = false;
    setContentViewVisibility(4);
    this.OxU = t.a(this, this.Ivh, this.OxY, this.OmO, this.mPayInfo, new t.c()new View.OnClickListener
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(265804);
        if (WalletChangeBankcardUI.b(WalletChangeBankcardUI.this))
        {
          Log.w("MicroMsg.WalletChangeBankcardUI", "has receive cancel");
          com.tencent.mm.plugin.report.service.h.IzE.p(965L, 3L, 1L);
          AppMethodBeat.o(265804);
          return;
        }
        WalletChangeBankcardUI.this.OxY = paramAnonymousFavorPayInfo;
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.OxY);
        if ((WalletChangeBankcardUI.this.OxY != null) && (paramAnonymousBoolean))
        {
          if (WalletChangeBankcardUI.this.OxY != null)
          {
            WalletChangeBankcardUI.this.BO(true);
            WalletChangeBankcardUI.this.OxW.i(WalletChangeBankcardUI.this.OmN, false);
          }
          if (WalletChangeBankcardUI.this.OxU != null) {
            WalletChangeBankcardUI.this.OxU.dismiss();
          }
          WalletChangeBankcardUI.this.updateView();
          WalletChangeBankcardUI.this.setContentViewVisibility(0);
          AppMethodBeat.o(265804);
          return;
        }
        WalletChangeBankcardUI.this.njf = paramAnonymousString;
        WalletChangeBankcardUI.this.hideVKB();
        WalletChangeBankcardUI.this.bgF(paramAnonymousString);
        WalletChangeBankcardUI.this.Oya = null;
        AppMethodBeat.o(265804);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(277875);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (WalletChangeBankcardUI.this.OxU != null) {
          WalletChangeBankcardUI.this.OxU.dismiss();
        }
        WalletChangeBankcardUI.this.BO(false);
        WalletChangeBankcardUI.this.OxW.i(WalletChangeBankcardUI.this.OmN, true);
        WalletChangeBankcardUI.this.OxY = ((FavorPayInfo)paramAnonymousView.getTag());
        if (WalletChangeBankcardUI.this.OxY != null) {
          WalletChangeBankcardUI.this.OxY.OPM = "";
        }
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.OxY);
        WalletChangeBankcardUI.this.updateView();
        WalletChangeBankcardUI.this.setContentViewVisibility(0);
        WalletChangeBankcardUI.this.Oya = null;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(277875);
      }
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(186272);
        Log.i("MicroMsg.WalletChangeBankcardUI", "WalletPwdDialog event2 %s", new Object[] { Util.getStack().toString() });
        WalletChangeBankcardUI.c(WalletChangeBankcardUI.this);
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        WalletChangeBankcardUI.this.njf = null;
        if (WalletChangeBankcardUI.d(WalletChangeBankcardUI.this).getVisibility() != 0) {
          WalletChangeBankcardUI.this.eog();
        }
        WalletChangeBankcardUI.this.Oya = null;
        AppMethodBeat.o(186272);
      }
    });
    this.Oya = this.OxU;
    AppMethodBeat.o(69327);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_change_bankcard;
  }
  
  public final void h(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69332);
    Log.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
    if (paramBoolean)
    {
      Log.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.fHc = paramString1;
      this.mPayInfo.fHd = paramString2;
      bgF(this.njf);
      AppMethodBeat.o(69332);
      return;
    }
    Log.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
    bgF(this.njf);
    AppMethodBeat.o(69332);
  }
  
  public void initView()
  {
    AppMethodBeat.i(69319);
    this.Iub = ((Button)findViewById(a.f.pay_btn));
    this.Iub.setEnabled(false);
    this.Iub.setOnClickListener(new WalletChangeBankcardUI.3(this));
    if (Util.isNullOrNil(getInput().getString("key_pwd1"))) {
      this.Iub.setText(a.i.app_ok);
    }
    for (;;)
    {
      this.OxT = ((ListView)findViewById(a.f.settings_lv_address));
      this.OxW = gGX();
      this.OxT.setAdapter(this.OxW);
      this.OxT.setOnItemClickListener(new WalletChangeBankcardUI.4(this));
      ImageView localImageView = (ImageView)findViewById(a.f.wallet_back_iv);
      localImageView.setClickable(true);
      localImageView.setOnClickListener(new WalletChangeBankcardUI.5(this));
      ar.a(((TextView)findViewById(a.f.wallet_select_title)).getPaint(), 0.8F);
      updateView();
      AppMethodBeat.o(69319);
      return;
      this.Iub.setText(a.i.wallet_pwd_dialog_pay_again);
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
    if ((this.mPayInfo == null) || (!this.mPayInfo.cpf))
    {
      AppMethodBeat.o(69324);
      return false;
    }
    if (this.mPayInfo.cpf)
    {
      AppMethodBeat.o(69324);
      return true;
    }
    s.gGL();
    if (!s.gGM().gJQ())
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
    if (paramInt1 == OxS) {
      gGU();
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
    this.OxV = paramBundle.getInt("key_support_bankcard", 1);
    this.OvK = ((Authen)paramBundle.getParcelable("key_authen"));
    this.Ivh = ((Orders)paramBundle.getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)paramBundle.getParcelable("key_pay_info"));
    this.OxY = ((FavorPayInfo)paramBundle.getParcelable("key_favor_pay_info"));
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      this.fOY = i;
      Log.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", new Object[] { Integer.valueOf(this.fOY) });
      if (!getInput().getBoolean("key_is_filter_bank_type")) {
        break label309;
      }
      BO(true);
    }
    for (;;)
    {
      if ((this.Ivh != null) && (this.Ivh.ORd != null) && (this.Ivh.ORd.size() > 0)) {
        this.OxX = getString(a.i.wallet_change_bankcard_tips, new Object[] { com.tencent.mm.wallet_core.ui.g.d(this.Ivh.fwy, this.Ivh.GHz), ((Orders.Commodity)this.Ivh.ORd.get(0)).desc });
      }
      initView();
      ab.ny(7, 0);
      EventCenter.instance.addListener(this.IrT);
      if ((getInput().getBoolean("key_is_filter_bank_type")) && (this.OxW != null)) {
        this.OxW.OYm = false;
      }
      AppMethodBeat.o(69316);
      return;
      i = this.mPayInfo.fOY;
      break;
      label309:
      gGW();
      this.OmN = gGV();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69318);
    if (this.OxZ != null)
    {
      this.OxZ.closeTipDialog();
      this.OxZ.release();
    }
    EventCenter.instance.removeListener(this.IrT);
    this.Oya = null;
    super.onDestroy();
    AppMethodBeat.o(69318);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69325);
    if ((paramInt == 4) && (this.OxY != null) && (this.OmN.size() == 0))
    {
      Object localObject = this.OxY;
      int i;
      if ((localObject != null) && (((FavorPayInfo)localObject).OPJ != 0)) {
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
          ArrayList localArrayList = gGV();
          if ((localArrayList != null) && (this.OmO == null))
          {
            i = 0;
            for (;;)
            {
              if (i < localArrayList.size())
              {
                if (((String)localObject).equals(((Bankcard)localArrayList.get(i)).field_bindSerial))
                {
                  Log.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:".concat(String.valueOf(localObject)));
                  this.OmO = ((Bankcard)localArrayList.get(i));
                }
              }
              else
              {
                if (this.OmO != null) {
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
          gGY();
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
    if (this.Oya != null) {
      this.Oya.onActivityPause();
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
    if (this.Oya != null) {
      this.Oya.onActivityResume();
    }
    AppMethodBeat.o(69323);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = false;
    int i = 0;
    AppMethodBeat.i(69326);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof f))
      {
        AppMethodBeat.o(69326);
        return true;
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        paramString = getInput();
        paramq = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramq;
        if (!Util.isNullOrNil(this.njf)) {
          paramString.putString("key_pwd1", this.njf);
        }
        paramString.putString("kreq_token", paramq.getToken());
        paramString.putParcelable("key_authen", paramq.OxB);
        Object localObject1;
        Object localObject2;
        if (!paramq.Oxz)
        {
          bool1 = true;
          paramString.putBoolean("key_need_verify_sms", bool1);
          paramString.putParcelable("key_pay_info", this.mPayInfo);
          paramString.putInt("key_pay_flag", 3);
          paramString.putInt("key_can_verify_tail", paramq.OxF);
          paramString.putString("key_verify_tail_wording", paramq.OxG);
          localObject1 = paramq.GCy;
          localObject2 = getInput();
          if (paramq.OxH != 1) {
            break label410;
          }
          bool1 = true;
          label189:
          ((Bundle)localObject2).putBoolean("key_block_bind_new_card", bool1);
          if (!Util.isNullOrNil(paramq.OxC)) {
            break label416;
          }
          paramString.putString("key_mobile", this.OmO.field_mobile);
          label224:
          paramString.putString("key_QADNA_URL", paramq.OxD);
          if (localObject1 != null) {
            paramString.putParcelable("key_realname_guide_helper", (Parcelable)localObject1);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("pwd", this.njf);
          localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
          if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject2).eon()) {
            break label431;
          }
          paramInt1 = 1;
        }
        for (;;)
        {
          ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
          ((com.tencent.mm.plugin.fingerprint.d.a)localObject2).a(paramq.gGR(), true, (Bundle)localObject1);
          if (paramq.isPaySuccess)
          {
            paramString.putParcelable("key_orders", paramq.OxA);
            if ((this.mPayInfo != null) && (this.mPayInfo.fOY == 8))
            {
              paramq = new abf();
              paramq.gaU.gaV = this.OvK.GGC;
              EventCenter.instance.publish(paramq);
            }
          }
          com.tencent.mm.wallet_core.a.l(this, paramString);
          AppMethodBeat.o(69326);
          return true;
          bool1 = false;
          break;
          label410:
          bool1 = false;
          break label189;
          label416:
          paramString.putString("key_mobile", paramq.OxC);
          break label224;
          label431:
          paramInt1 = i;
          if (((com.tencent.mm.plugin.fingerprint.d.a)localObject2).eoq()) {
            paramInt1 = 2;
          }
        }
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString("pwd", this.njf);
      getInput().putBoolean("key_need_verify_sms", false);
      paramq = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.OvK.HzF.PbP != 1) {
        break label580;
      }
    }
    label580:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramq.a(bool1, true, paramString);
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(69326);
        return false;
      }
    }
    this.mPayInfo.Rzi = paramInt2;
    gGY();
    AppMethodBeat.o(69326);
    return true;
    this.mPayInfo.Rzi = paramInt2;
    bool1 = bool2;
    if (paramInt2 == 100100) {
      bool1 = true;
    }
    if (this.OxZ == null) {
      this.OxZ = new a(this, this);
    }
    this.OxZ.c(bool1, this.mPayInfo.fHa, this.mPayInfo.fwv);
    Log.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(69326);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(69321);
    this.txU = ((TextView)findViewById(a.f.input_tip));
    if ((this.OxY != null) && (!Util.isNullOrNil(this.OxY.OPM)))
    {
      this.txU.setVisibility(0);
      this.txU.setText(this.OxY.OPM);
      AppMethodBeat.o(69321);
      return;
    }
    if (getInput().getInt("key_main_bankcard_state", 0) != 0)
    {
      this.txU.setVisibility(0);
      this.txU.setText(this.OxX);
      AppMethodBeat.o(69321);
      return;
    }
    this.txU.setVisibility(8);
    AppMethodBeat.o(69321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */