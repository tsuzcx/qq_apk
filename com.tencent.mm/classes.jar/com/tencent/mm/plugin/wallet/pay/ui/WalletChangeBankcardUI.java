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
import com.tencent.mm.g.a.yn;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.g.a.yw.a;
import com.tencent.mm.g.a.yx;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.ab;
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
  public static int CIF = 1;
  protected Authen CGx;
  protected ListView CIG;
  public com.tencent.mm.plugin.wallet_core.ui.s CIH;
  protected int CII;
  public k CIJ;
  protected String CIK;
  public FavorPayInfo CIL;
  private a CIM;
  com.tencent.mm.plugin.wallet_core.ui.f CIN;
  private boolean CIO;
  public ArrayList<Bankcard> CyC;
  protected Bankcard CyD;
  protected int dCC;
  public String jqo;
  protected PayInfo mPayInfo;
  protected TextView oHG;
  private c ydz;
  protected Button yft;
  protected Orders ygb;
  
  public WalletChangeBankcardUI()
  {
    AppMethodBeat.i(69313);
    this.dCC = 0;
    this.CyD = null;
    this.CIJ = null;
    this.CGx = null;
    this.ygb = null;
    this.mPayInfo = null;
    this.CIK = null;
    this.CIN = null;
    this.ydz = new c() {};
    this.CIO = false;
    AppMethodBeat.o(69313);
  }
  
  private void eDy()
  {
    AppMethodBeat.i(69314);
    Object localObject = com.tencent.mm.wallet_core.a.br(this);
    if (localObject != null) {
      ((d)localObject).g(this, 1);
    }
    for (;;)
    {
      localObject = new yx();
      ((yx)localObject).dNT.result = -1;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(69314);
      return;
      finish();
    }
  }
  
  private ArrayList<Bankcard> eDz()
  {
    AppMethodBeat.i(69317);
    if (this.dCC == 8)
    {
      localArrayList = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.um(true);
      AppMethodBeat.o(69317);
      return localArrayList;
    }
    ArrayList localArrayList = (ArrayList)com.tencent.mm.plugin.wallet_core.model.af.um(false);
    AppMethodBeat.o(69317);
    return localArrayList;
  }
  
  protected void Vo(int paramInt)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(69322);
    int i;
    Bankcard localBankcard;
    if (this.CyC != null)
    {
      i = this.CyC.size();
      ad.i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.CyC == null) || (paramInt >= i)) {
        break label181;
      }
      localBankcard = (Bankcard)this.CyC.get(paramInt);
      this.CyD = localBankcard;
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
    for (Object localObject = "";; localObject = this.mPayInfo.dlu)
    {
      com.tencent.mm.wallet_core.c.af.f(paramInt, (String)localObject, 13, this.CyD.field_bindSerial);
      this.CIJ.Dfh = localBankcard.field_bindSerial;
      this.yft.setEnabled(true);
      this.CIJ.notifyDataSetChanged();
      eDB();
      AppMethodBeat.o(69322);
      return;
      i = 0;
      break;
      paramInt = this.mPayInfo.dCC;
      break label90;
    }
    label181:
    if (i == paramInt)
    {
      localObject = com.tencent.mm.plugin.wallet_core.model.g.eFb();
      if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bni())
      {
        com.tencent.mm.ui.base.h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).wBJ, getString(2131755906), true);
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
    for (localObject = "";; localObject = this.mPayInfo.dlu)
    {
      com.tencent.mm.wallet_core.c.af.f(paramInt, (String)localObject, 14, "");
      getInput().putInt("key_err_code", -1003);
      getInput().putBoolean("key_has_click_bind_new_card", true);
      com.tencent.mm.wallet_core.a.k(this, getInput());
      AppMethodBeat.o(69322);
      return;
      paramInt = this.mPayInfo.dCC;
      break;
    }
  }
  
  protected void aEf(String paramString)
  {
    AppMethodBeat.i(69328);
    this.CGx.CTP = paramString;
    boolean bool = getInput().getBoolean("key_has_click_bind_new_card", false);
    int i = getInput().getInt("key_pay_flag");
    if ((bool) && (i == 3))
    {
      ad.i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
      this.CGx.dDp = 3;
    }
    if (this.CyD != null)
    {
      getInput().putString("key_mobile", this.CyD.field_mobile);
      getInput().putParcelable("key_bankcard", this.CyD);
      this.CGx.wBI = this.CyD.field_bindSerial;
      this.CGx.dkR = this.CyD.field_bankcardType;
      if (this.CIL == null) {
        break label338;
      }
      this.CGx.CTZ = this.CIL.CWL;
      if (this.ygb.CYl != null) {
        this.CGx.CTY = this.ygb.CYl.CGZ;
      }
      if ((this.ygb != null) && (this.ygb.CPj == 3))
      {
        if (!this.CyD.eEU()) {
          break label349;
        }
        this.CGx.dDp = 3;
        label212:
        Bundle localBundle = getInput();
        if (this.CyD.eEU()) {
          break label361;
        }
        bool = true;
        label230:
        localBundle.putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putString("key_pwd1", paramString);
    getInput().putParcelable("key_authen", this.CGx);
    paramString = com.tencent.mm.plugin.wallet.pay.a.a.a(this.CGx, this.ygb, false);
    if (paramString != null)
    {
      paramString.setProcessName("PayProcess");
      paramString.setProcessBundle(getInput());
      if ((this.mPayInfo.dCC != 6) || (this.mPayInfo.FlP != 100)) {
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
      this.CGx.CTZ = null;
      break;
      label349:
      this.CGx.dDp = 6;
      break label212;
      label361:
      bool = false;
      break label230;
      label366:
      paramString.setScene(this.mPayInfo.dCC);
    }
  }
  
  public final void cPg()
  {
    AppMethodBeat.i(69330);
    cancelQRPay();
    d locald = com.tencent.mm.wallet_core.a.br(this);
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
      cPg();
      AppMethodBeat.o(69329);
      return;
    }
    if (paramInt == 1)
    {
      getInput().putString("key_pwd1", "");
      eDB();
      AppMethodBeat.o(69329);
      return;
    }
    ad.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
    AppMethodBeat.o(69329);
  }
  
  public final void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69332);
    ad.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
    if (paramBoolean)
    {
      ad.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.dvf = paramString1;
      this.mPayInfo.dvg = paramString2;
      aEf(this.jqo);
      AppMethodBeat.o(69332);
      return;
    }
    ad.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
    aEf(this.jqo);
    AppMethodBeat.o(69332);
  }
  
  protected k eDA()
  {
    AppMethodBeat.i(69320);
    k localk = new k(this, this.CyC, this.CII, this.ygb);
    AppMethodBeat.o(69320);
    return localk;
  }
  
  protected void eDB()
  {
    AppMethodBeat.i(69327);
    ad.i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
    getInput().getString("key_pwd1");
    this.CIO = false;
    setContentViewVisibility(4);
    this.CIH = com.tencent.mm.plugin.wallet_core.ui.s.a(this, this.ygb, this.CIL, this.CyD, this.mPayInfo, new s.c()new View.OnClickListener
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69310);
        if (WalletChangeBankcardUI.b(WalletChangeBankcardUI.this))
        {
          ad.w("MicroMsg.WalletChangeBankcardUI", "has receive cancel");
          com.tencent.mm.plugin.report.service.g.yhR.n(965L, 3L, 1L);
          AppMethodBeat.o(69310);
          return;
        }
        WalletChangeBankcardUI.this.CIL = paramAnonymousFavorPayInfo;
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.CIL);
        if ((WalletChangeBankcardUI.this.CIL != null) && (paramAnonymousBoolean))
        {
          if (WalletChangeBankcardUI.this.CIL != null)
          {
            WalletChangeBankcardUI.this.uc(true);
            WalletChangeBankcardUI.this.CIJ.f(WalletChangeBankcardUI.this.CyC, false);
          }
          if (WalletChangeBankcardUI.this.CIH != null) {
            WalletChangeBankcardUI.this.CIH.dismiss();
          }
          WalletChangeBankcardUI.this.updateView();
          WalletChangeBankcardUI.this.setContentViewVisibility(0);
          AppMethodBeat.o(69310);
          return;
        }
        WalletChangeBankcardUI.this.jqo = paramAnonymousString;
        WalletChangeBankcardUI.this.hideVKB();
        WalletChangeBankcardUI.this.aEf(paramAnonymousString);
        WalletChangeBankcardUI.this.CIN = null;
        AppMethodBeat.o(69310);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69311);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (WalletChangeBankcardUI.this.CIH != null) {
          WalletChangeBankcardUI.this.CIH.dismiss();
        }
        WalletChangeBankcardUI.this.uc(false);
        WalletChangeBankcardUI.this.CIJ.f(WalletChangeBankcardUI.this.CyC, true);
        WalletChangeBankcardUI.this.CIL = ((FavorPayInfo)paramAnonymousView.getTag());
        if (WalletChangeBankcardUI.this.CIL != null) {
          WalletChangeBankcardUI.this.CIL.CWP = "";
        }
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.CIL);
        WalletChangeBankcardUI.this.updateView();
        WalletChangeBankcardUI.this.setContentViewVisibility(0);
        WalletChangeBankcardUI.this.CIN = null;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69311);
      }
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(69312);
        ad.i("MicroMsg.WalletChangeBankcardUI", "WalletPwdDialog event2 %s", new Object[] { bt.flS().toString() });
        WalletChangeBankcardUI.c(WalletChangeBankcardUI.this);
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        WalletChangeBankcardUI.this.jqo = null;
        if (WalletChangeBankcardUI.d(WalletChangeBankcardUI.this).getVisibility() != 0) {
          WalletChangeBankcardUI.this.cPg();
        }
        WalletChangeBankcardUI.this.CIN = null;
        AppMethodBeat.o(69312);
      }
    });
    this.CIN = this.CIH;
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
    this.yft = ((Button)findViewById(2131303149));
    this.yft.setEnabled(false);
    this.yft.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletChangeBankcardUI.this.eDB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69308);
      }
    });
    if (bt.isNullOrNil(getInput().getString("key_pwd1"))) {
      this.yft.setText(2131755835);
    }
    for (;;)
    {
      this.CIG = ((ListView)findViewById(2131304652));
      this.CIJ = eDA();
      this.CIG.setAdapter(this.CIJ);
      this.CIG.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(69309);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          WalletChangeBankcardUI.this.Vo(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(69309);
        }
      });
      updateView();
      AppMethodBeat.o(69319);
      return;
      this.yft.setText(2131765745);
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
    if ((this.mPayInfo == null) || (!this.mPayInfo.ucG))
    {
      AppMethodBeat.o(69324);
      return false;
    }
    if (this.mPayInfo.ucG)
    {
      AppMethodBeat.o(69324);
      return true;
    }
    com.tencent.mm.plugin.wallet.a.s.eDp();
    if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGa())
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
    if (paramInt1 == CIF) {
      eDy();
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
    this.CII = paramBundle.getInt("key_support_bankcard", 1);
    this.CGx = ((Authen)paramBundle.getParcelable("key_authen"));
    this.ygb = ((Orders)paramBundle.getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)paramBundle.getParcelable("key_pay_info"));
    this.CIL = ((FavorPayInfo)paramBundle.getParcelable("key_favor_pay_info"));
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      this.dCC = i;
      ad.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", new Object[] { Integer.valueOf(this.dCC) });
      if (!getInput().getBoolean("key_is_filter_bank_type")) {
        break label309;
      }
      uc(true);
    }
    for (;;)
    {
      if ((this.ygb != null) && (this.ygb.CYk != null) && (this.ygb.CYk.size() > 0)) {
        this.CIK = getString(2131765187, new Object[] { e.d(this.ygb.dlx, this.ygb.wCF), ((Orders.Commodity)this.ygb.CYk.get(0)).desc });
      }
      initView();
      ab.kB(7, 0);
      com.tencent.mm.sdk.b.a.IbL.c(this.ydz);
      if ((getInput().getBoolean("key_is_filter_bank_type")) && (this.CIJ != null)) {
        this.CIJ.Dfi = false;
      }
      AppMethodBeat.o(69316);
      return;
      i = this.mPayInfo.dCC;
      break;
      label309:
      this.CyC = eDz();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69318);
    if (this.CIM != null)
    {
      this.CIM.closeTipDialog();
      this.CIM.release();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.ydz);
    this.CIN = null;
    super.onDestroy();
    AppMethodBeat.o(69318);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69325);
    if ((paramInt == 4) && (this.CIL != null) && (this.CyC.size() == 0))
    {
      Object localObject = this.CIL;
      int i;
      if ((localObject != null) && (((FavorPayInfo)localObject).CWM != 0)) {
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
          ArrayList localArrayList = eDz();
          if ((localArrayList != null) && (this.CyD == null))
          {
            i = 0;
            for (;;)
            {
              if (i < localArrayList.size())
              {
                if (((String)localObject).equals(((Bankcard)localArrayList.get(i)).field_bindSerial))
                {
                  ad.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:".concat(String.valueOf(localObject)));
                  this.CyD = ((Bankcard)localArrayList.get(i));
                }
              }
              else
              {
                if (this.CyD != null) {
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
          eDB();
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
    if (this.CIN != null) {
      this.CIN.onActivityPause();
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
    if (this.CIN != null) {
      this.CIN.eHn();
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
        if (!bt.isNullOrNil(this.jqo)) {
          paramString.putString("key_pwd1", this.jqo);
        }
        paramString.putString("kreq_token", paramn.getToken());
        paramString.putParcelable("key_authen", paramn.CIo);
        Object localObject1;
        Object localObject2;
        if (!paramn.CIm)
        {
          bool1 = true;
          paramString.putBoolean("key_need_verify_sms", bool1);
          paramString.putParcelable("key_pay_info", this.mPayInfo);
          paramString.putInt("key_pay_flag", 3);
          paramString.putInt("key_can_verify_tail", paramn.CIs);
          paramString.putString("key_verify_tail_wording", paramn.CIt);
          localObject1 = paramn.wya;
          localObject2 = getInput();
          if (paramn.CIu != 1) {
            break label410;
          }
          bool1 = true;
          label189:
          ((Bundle)localObject2).putBoolean("key_block_bind_new_card", bool1);
          if (!bt.isNullOrNil(paramn.CIp)) {
            break label416;
          }
          paramString.putString("key_mobile", this.CyD.field_mobile);
          label224:
          paramString.putString("key_QADNA_URL", paramn.CIq);
          if (localObject1 != null) {
            paramString.putParcelable("key_realname_guide_helper", (Parcelable)localObject1);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("pwd", this.jqo);
          localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
          if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject2).cPo()) {
            break label431;
          }
          paramInt1 = 1;
        }
        for (;;)
        {
          ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
          ((com.tencent.mm.plugin.fingerprint.d.a)localObject2).a(paramn.eDv(), true, (Bundle)localObject1);
          if (paramn.isPaySuccess)
          {
            paramString.putParcelable("key_orders", paramn.CIn);
            if ((this.mPayInfo != null) && (this.mPayInfo.dCC == 8))
            {
              paramn = new yn();
              paramn.dNs.dNt = this.CGx.wBI;
              com.tencent.mm.sdk.b.a.IbL.l(paramn);
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
          paramString.putString("key_mobile", paramn.CIp);
          break label224;
          label431:
          paramInt1 = i;
          if (((com.tencent.mm.plugin.fingerprint.d.a)localObject2).cPr()) {
            paramInt1 = 2;
          }
        }
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString("pwd", this.jqo);
      getInput().putBoolean("key_need_verify_sms", false);
      paramn = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.CGx.xnF.DiI != 1) {
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
    this.mPayInfo.FlS = paramInt2;
    eDB();
    AppMethodBeat.o(69326);
    return true;
    this.mPayInfo.FlS = paramInt2;
    bool1 = bool2;
    if (paramInt2 == 100100) {
      bool1 = true;
    }
    if (this.CIM == null) {
      this.CIM = new a(this, this);
    }
    this.CIM.b(bool1, this.mPayInfo.dvd, this.mPayInfo.dlu);
    ad.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(69326);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void uc(boolean paramBoolean)
  {
    AppMethodBeat.i(69331);
    this.CyC = eDz();
    if (this.CIL != null) {
      if (this.CIL.CWM == 0) {
        break label48;
      }
    }
    label48:
    for (int i = 1; (i == 0) || (!paramBoolean); i = 0)
    {
      AppMethodBeat.o(69331);
      return;
    }
    String str = this.CIL.CWN;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    if (i < this.CyC.size())
    {
      Bankcard localBankcard = (Bankcard)this.CyC.get(i);
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
    this.CyC = localArrayList;
    AppMethodBeat.o(69331);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(69321);
    this.oHG = ((TextView)findViewById(2131301034));
    if ((this.CIL != null) && (!bt.isNullOrNil(this.CIL.CWP)))
    {
      this.oHG.setVisibility(0);
      this.oHG.setText(this.CIL.CWP);
      AppMethodBeat.o(69321);
      return;
    }
    if (getInput().getInt("key_main_bankcard_state", 0) != 0)
    {
      this.oHG.setVisibility(0);
      this.oHG.setText(this.CIK);
      AppMethodBeat.o(69321);
      return;
    }
    this.oHG.setVisibility(8);
    AppMethodBeat.o(69321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */