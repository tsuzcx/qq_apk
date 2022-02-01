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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aah;
import com.tencent.mm.g.a.aah.a;
import com.tencent.mm.g.a.aai;
import com.tencent.mm.g.a.zy;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.plugin.wallet_core.ui.s.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ab;
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
  public static int HFZ = 1;
  private IListener Cuh;
  protected Orders CwO;
  protected Button Cwg;
  protected Authen HDR;
  protected ListView HGa;
  public com.tencent.mm.plugin.wallet_core.ui.s HGb;
  protected int HGc;
  public k HGd;
  protected String HGe;
  public FavorPayInfo HGf;
  private a HGg;
  com.tencent.mm.plugin.wallet_core.ui.f HGh;
  private boolean HGi;
  public ArrayList<Bankcard> Hva;
  protected Bankcard Hvb;
  protected int dVv;
  public String krw;
  protected PayInfo mPayInfo;
  protected TextView qbW;
  
  public WalletChangeBankcardUI()
  {
    AppMethodBeat.i(69313);
    this.dVv = 0;
    this.Hvb = null;
    this.HGd = null;
    this.HDR = null;
    this.CwO = null;
    this.mPayInfo = null;
    this.HGe = null;
    this.HGh = null;
    this.Cuh = new IListener() {};
    this.HGi = false;
    AppMethodBeat.o(69313);
  }
  
  private void fOp()
  {
    AppMethodBeat.i(69314);
    Object localObject = com.tencent.mm.wallet_core.a.by(this);
    if (localObject != null) {
      ((d)localObject).g(this, 1);
    }
    for (;;)
    {
      localObject = new aai();
      ((aai)localObject).ehf.result = -1;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(69314);
      return;
      finish();
    }
  }
  
  private ArrayList<Bankcard> fOq()
  {
    AppMethodBeat.i(69317);
    if (this.dVv == 8)
    {
      localArrayList = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.yh(true);
      AppMethodBeat.o(69317);
      return localArrayList;
    }
    ArrayList localArrayList = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.yh(false);
    AppMethodBeat.o(69317);
    return localArrayList;
  }
  
  protected void aUW(String paramString)
  {
    AppMethodBeat.i(69328);
    this.HDR.HUO = paramString;
    boolean bool = getInput().getBoolean("key_has_click_bind_new_card", false);
    int i = getInput().getInt("key_pay_flag");
    if ((bool) && (i == 3))
    {
      Log.i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
      this.HDR.cSx = 3;
    }
    if (this.Hvb != null)
    {
      getInput().putString("key_mobile", this.Hvb.field_mobile);
      getInput().putParcelable("key_bankcard", this.Hvb);
      this.HDR.ANo = this.Hvb.field_bindSerial;
      this.HDR.dDj = this.Hvb.field_bankcardType;
      if (this.HGf == null) {
        break label331;
      }
      this.HDR.HUY = this.HGf.HXI;
      if (this.CwO.HZe != null) {
        this.HDR.HUX = this.CwO.HZe.HEt;
      }
      if ((this.CwO != null) && (this.CwO.HQg == 3))
      {
        if (!this.Hvb.fQe()) {
          break label342;
        }
        this.HDR.cSx = 3;
        label206:
        Bundle localBundle = getInput();
        if (this.Hvb.fQe()) {
          break label354;
        }
        bool = true;
        label224:
        localBundle.putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putString("key_pwd1", paramString);
    getInput().putParcelable("key_authen", this.HDR);
    paramString = com.tencent.mm.plugin.wallet.pay.a.a.a(this.HDR, this.CwO, false);
    if (paramString != null)
    {
      paramString.setProcessName("PayProcess");
      paramString.setProcessBundle(getInput());
      if ((this.mPayInfo.dVv != 6) || (this.mPayInfo.Kxr != 100)) {
        break label359;
      }
      paramString.setScene(100);
    }
    for (;;)
    {
      doSceneProgress(paramString);
      AppMethodBeat.o(69328);
      return;
      label331:
      this.HDR.HUY = null;
      break;
      label342:
      this.HDR.cSx = 6;
      break label206;
      label354:
      bool = false;
      break label224;
      label359:
      paramString.setScene(this.mPayInfo.dVv);
    }
  }
  
  protected void aex(int paramInt)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(69322);
    int i;
    Bankcard localBankcard;
    if (this.Hva != null)
    {
      i = this.Hva.size();
      Log.i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.Hva == null) || (paramInt >= i)) {
        break label185;
      }
      localBankcard = (Bankcard)this.Hva.get(paramInt);
      this.Hvb = localBankcard;
      if (this.mPayInfo != null) {
        break label162;
      }
      paramInt = j;
      label92:
      if (this.mPayInfo != null) {
        break label173;
      }
    }
    label162:
    label173:
    for (Object localObject = "";; localObject = this.mPayInfo.dDL)
    {
      com.tencent.mm.wallet_core.c.af.f(paramInt, (String)localObject, 13, this.Hvb.field_bindSerial);
      this.HGd.IfW = localBankcard.field_bindSerial;
      this.Cwg.setEnabled(true);
      this.HGd.notifyDataSetChanged();
      fOs();
      AppMethodBeat.o(69322);
      return;
      i = 0;
      break;
      paramInt = this.mPayInfo.dVv;
      break label92;
    }
    label185:
    if (i == paramInt)
    {
      localObject = com.tencent.mm.plugin.wallet_core.model.g.fQl();
      if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bJw())
      {
        com.tencent.mm.ui.base.h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).ANp, getString(2131755998), true);
        AppMethodBeat.o(69322);
        return;
      }
      if (this.mPayInfo != null) {
        break label299;
      }
      paramInt = k;
      if (this.mPayInfo != null) {
        break label310;
      }
    }
    label299:
    label310:
    for (localObject = "";; localObject = this.mPayInfo.dDL)
    {
      com.tencent.mm.wallet_core.c.af.f(paramInt, (String)localObject, 14, "");
      getInput().putInt("key_err_code", -1003);
      getInput().putBoolean("key_has_click_bind_new_card", true);
      com.tencent.mm.wallet_core.a.l(this, getInput());
      AppMethodBeat.o(69322);
      return;
      paramInt = this.mPayInfo.dVv;
      break;
    }
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(69329);
    if (paramInt == 0)
    {
      dJG();
      AppMethodBeat.o(69329);
      return;
    }
    if (paramInt == 1)
    {
      getInput().putString("key_pwd1", "");
      fOs();
      AppMethodBeat.o(69329);
      return;
    }
    Log.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
    AppMethodBeat.o(69329);
  }
  
  public final void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69332);
    Log.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
    if (paramBoolean)
    {
      Log.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.dNR = paramString1;
      this.mPayInfo.dNS = paramString2;
      aUW(this.krw);
      AppMethodBeat.o(69332);
      return;
    }
    Log.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
    aUW(this.krw);
    AppMethodBeat.o(69332);
  }
  
  public final void dJG()
  {
    AppMethodBeat.i(69330);
    cancelQRPay();
    d locald = com.tencent.mm.wallet_core.a.by(this);
    if (locald != null)
    {
      locald.b(this, getInput());
      AppMethodBeat.o(69330);
      return;
    }
    finish();
    AppMethodBeat.o(69330);
  }
  
  protected k fOr()
  {
    AppMethodBeat.i(69320);
    k localk = new k(this, this.Hva, this.HGc, this.CwO);
    AppMethodBeat.o(69320);
    return localk;
  }
  
  protected void fOs()
  {
    AppMethodBeat.i(69327);
    Log.i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
    getInput().getString("key_pwd1");
    this.HGi = false;
    setContentViewVisibility(4);
    this.HGb = com.tencent.mm.plugin.wallet_core.ui.s.a(this, this.CwO, this.HGf, this.Hvb, this.mPayInfo, new s.c()new View.OnClickListener
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69310);
        if (WalletChangeBankcardUI.b(WalletChangeBankcardUI.this))
        {
          Log.w("MicroMsg.WalletChangeBankcardUI", "has receive cancel");
          com.tencent.mm.plugin.report.service.h.CyF.n(965L, 3L, 1L);
          AppMethodBeat.o(69310);
          return;
        }
        WalletChangeBankcardUI.this.HGf = paramAnonymousFavorPayInfo;
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.HGf);
        if ((WalletChangeBankcardUI.this.HGf != null) && (paramAnonymousBoolean))
        {
          if (WalletChangeBankcardUI.this.HGf != null)
          {
            WalletChangeBankcardUI.this.xU(true);
            WalletChangeBankcardUI.this.HGd.h(WalletChangeBankcardUI.this.Hva, false);
          }
          if (WalletChangeBankcardUI.this.HGb != null) {
            WalletChangeBankcardUI.this.HGb.dismiss();
          }
          WalletChangeBankcardUI.this.updateView();
          WalletChangeBankcardUI.this.setContentViewVisibility(0);
          AppMethodBeat.o(69310);
          return;
        }
        WalletChangeBankcardUI.this.krw = paramAnonymousString;
        WalletChangeBankcardUI.this.hideVKB();
        WalletChangeBankcardUI.this.aUW(paramAnonymousString);
        WalletChangeBankcardUI.this.HGh = null;
        AppMethodBeat.o(69310);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69311);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (WalletChangeBankcardUI.this.HGb != null) {
          WalletChangeBankcardUI.this.HGb.dismiss();
        }
        WalletChangeBankcardUI.this.xU(false);
        WalletChangeBankcardUI.this.HGd.h(WalletChangeBankcardUI.this.Hva, true);
        WalletChangeBankcardUI.this.HGf = ((FavorPayInfo)paramAnonymousView.getTag());
        if (WalletChangeBankcardUI.this.HGf != null) {
          WalletChangeBankcardUI.this.HGf.HXM = "";
        }
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.HGf);
        WalletChangeBankcardUI.this.updateView();
        WalletChangeBankcardUI.this.setContentViewVisibility(0);
        WalletChangeBankcardUI.this.HGh = null;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69311);
      }
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(69312);
        Log.i("MicroMsg.WalletChangeBankcardUI", "WalletPwdDialog event2 %s", new Object[] { Util.getStack().toString() });
        WalletChangeBankcardUI.c(WalletChangeBankcardUI.this);
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        WalletChangeBankcardUI.this.krw = null;
        if (WalletChangeBankcardUI.d(WalletChangeBankcardUI.this).getVisibility() != 0) {
          WalletChangeBankcardUI.this.dJG();
        }
        WalletChangeBankcardUI.this.HGh = null;
        AppMethodBeat.o(69312);
      }
    });
    this.HGh = this.HGb;
    AppMethodBeat.o(69327);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496913;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69319);
    this.Cwg = ((Button)findViewById(2131305806));
    this.Cwg.setEnabled(false);
    this.Cwg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletChangeBankcardUI.this.fOs();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69308);
      }
    });
    if (Util.isNullOrNil(getInput().getString("key_pwd1"))) {
      this.Cwg.setText(2131755921);
    }
    for (;;)
    {
      this.HGa = ((ListView)findViewById(2131307705));
      this.HGd = fOr();
      this.HGa.setAdapter(this.HGd);
      this.HGa.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(69309);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          WalletChangeBankcardUI.this.aex(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(69309);
        }
      });
      updateView();
      AppMethodBeat.o(69319);
      return;
      this.Cwg.setText(2131768198);
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
    if ((this.mPayInfo == null) || (!this.mPayInfo.crp))
    {
      AppMethodBeat.o(69324);
      return false;
    }
    if (this.mPayInfo.crp)
    {
      AppMethodBeat.o(69324);
      return true;
    }
    com.tencent.mm.plugin.wallet.a.s.fOg();
    if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRk())
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
    if (paramInt1 == HFZ) {
      fOp();
    }
    AppMethodBeat.o(69315);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69316);
    super.onCreate(paramBundle);
    setMMTitle(2131768318);
    paramBundle = getInput();
    paramBundle.putInt("key_err_code", 0);
    this.HGc = paramBundle.getInt("key_support_bankcard", 1);
    this.HDR = ((Authen)paramBundle.getParcelable("key_authen"));
    this.CwO = ((Orders)paramBundle.getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)paramBundle.getParcelable("key_pay_info"));
    this.HGf = ((FavorPayInfo)paramBundle.getParcelable("key_favor_pay_info"));
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      this.dVv = i;
      Log.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", new Object[] { Integer.valueOf(this.dVv) });
      if (!getInput().getBoolean("key_is_filter_bank_type")) {
        break label309;
      }
      xU(true);
    }
    for (;;)
    {
      if ((this.CwO != null) && (this.CwO.HZd != null) && (this.CwO.HZd.size() > 0)) {
        this.HGe = getString(2131767630, new Object[] { com.tencent.mm.wallet_core.ui.f.d(this.CwO.dDO, this.CwO.AOl), ((Orders.Commodity)this.CwO.HZd.get(0)).desc });
      }
      initView();
      ab.mg(7, 0);
      EventCenter.instance.addListener(this.Cuh);
      if ((getInput().getBoolean("key_is_filter_bank_type")) && (this.HGd != null)) {
        this.HGd.IfX = false;
      }
      AppMethodBeat.o(69316);
      return;
      i = this.mPayInfo.dVv;
      break;
      label309:
      this.Hva = fOq();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69318);
    if (this.HGg != null)
    {
      this.HGg.closeTipDialog();
      this.HGg.release();
    }
    EventCenter.instance.removeListener(this.Cuh);
    this.HGh = null;
    super.onDestroy();
    AppMethodBeat.o(69318);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69325);
    if ((paramInt == 4) && (this.HGf != null) && (this.Hva.size() == 0))
    {
      Object localObject = this.HGf;
      int i;
      if ((localObject != null) && (((FavorPayInfo)localObject).HXJ != 0)) {
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
          ArrayList localArrayList = fOq();
          if ((localArrayList != null) && (this.Hvb == null))
          {
            i = 0;
            for (;;)
            {
              if (i < localArrayList.size())
              {
                if (((String)localObject).equals(((Bankcard)localArrayList.get(i)).field_bindSerial))
                {
                  Log.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:".concat(String.valueOf(localObject)));
                  this.Hvb = ((Bankcard)localArrayList.get(i));
                }
              }
              else
              {
                if (this.Hvb != null) {
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
          fOs();
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
    if (this.HGh != null) {
      this.HGh.onActivityPause();
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
    if (this.HGh != null) {
      this.HGh.fSA();
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
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pay.a.c.f))
      {
        AppMethodBeat.o(69326);
        return true;
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        paramString = getInput();
        paramq = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramq;
        if (!Util.isNullOrNil(this.krw)) {
          paramString.putString("key_pwd1", this.krw);
        }
        paramString.putString("kreq_token", paramq.getToken());
        paramString.putParcelable("key_authen", paramq.HFI);
        Object localObject1;
        Object localObject2;
        if (!paramq.HFG)
        {
          bool1 = true;
          paramString.putBoolean("key_need_verify_sms", bool1);
          paramString.putParcelable("key_pay_info", this.mPayInfo);
          paramString.putInt("key_pay_flag", 3);
          paramString.putInt("key_can_verify_tail", paramq.HFM);
          paramString.putString("key_verify_tail_wording", paramq.HFN);
          localObject1 = paramq.AJr;
          localObject2 = getInput();
          if (paramq.HFO != 1) {
            break label408;
          }
          bool1 = true;
          label188:
          ((Bundle)localObject2).putBoolean("key_block_bind_new_card", bool1);
          if (!Util.isNullOrNil(paramq.HFJ)) {
            break label414;
          }
          paramString.putString("key_mobile", this.Hvb.field_mobile);
          label222:
          paramString.putString("key_QADNA_URL", paramq.HFK);
          if (localObject1 != null) {
            paramString.putParcelable("key_realname_guide_helper", (Parcelable)localObject1);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("pwd", this.krw);
          localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
          if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject2).dJO()) {
            break label428;
          }
          paramInt1 = 1;
        }
        for (;;)
        {
          ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
          ((com.tencent.mm.plugin.fingerprint.d.a)localObject2).a(paramq.fOm(), true, (Bundle)localObject1);
          if (paramq.isPaySuccess)
          {
            paramString.putParcelable("key_orders", paramq.HFH);
            if ((this.mPayInfo != null) && (this.mPayInfo.dVv == 8))
            {
              paramq = new zy();
              paramq.egE.egF = this.HDR.ANo;
              EventCenter.instance.publish(paramq);
            }
          }
          com.tencent.mm.wallet_core.a.l(this, paramString);
          AppMethodBeat.o(69326);
          return true;
          bool1 = false;
          break;
          label408:
          bool1 = false;
          break label188;
          label414:
          paramString.putString("key_mobile", paramq.HFJ);
          break label222;
          label428:
          paramInt1 = i;
          if (((com.tencent.mm.plugin.fingerprint.d.a)localObject2).dJR()) {
            paramInt1 = 2;
          }
        }
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString("pwd", this.krw);
      getInput().putBoolean("key_need_verify_sms", false);
      paramq = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.HDR.BDB.Ijy != 1) {
        break label576;
      }
    }
    label576:
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
    this.mPayInfo.Kxu = paramInt2;
    fOs();
    AppMethodBeat.o(69326);
    return true;
    this.mPayInfo.Kxu = paramInt2;
    bool1 = bool2;
    if (paramInt2 == 100100) {
      bool1 = true;
    }
    if (this.HGg == null) {
      this.HGg = new a(this, this);
    }
    this.HGg.b(bool1, this.mPayInfo.dNP, this.mPayInfo.dDL);
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
    this.qbW = ((TextView)findViewById(2131302684));
    if ((this.HGf != null) && (!Util.isNullOrNil(this.HGf.HXM)))
    {
      this.qbW.setVisibility(0);
      this.qbW.setText(this.HGf.HXM);
      AppMethodBeat.o(69321);
      return;
    }
    if (getInput().getInt("key_main_bankcard_state", 0) != 0)
    {
      this.qbW.setVisibility(0);
      this.qbW.setText(this.HGe);
      AppMethodBeat.o(69321);
      return;
    }
    this.qbW.setVisibility(8);
    AppMethodBeat.o(69321);
  }
  
  protected final void xU(boolean paramBoolean)
  {
    AppMethodBeat.i(69331);
    this.Hva = fOq();
    if (this.HGf != null) {
      if (this.HGf.HXJ == 0) {
        break label48;
      }
    }
    label48:
    for (int i = 1; (i == 0) || (!paramBoolean); i = 0)
    {
      AppMethodBeat.o(69331);
      return;
    }
    String str = this.HGf.HXK;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    if (i < this.Hva.size())
    {
      Bankcard localBankcard = (Bankcard)this.Hva.get(i);
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
    this.Hva = localArrayList;
    AppMethodBeat.o(69331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */