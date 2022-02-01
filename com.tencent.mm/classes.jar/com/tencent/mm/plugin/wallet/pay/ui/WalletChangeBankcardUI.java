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
import com.tencent.mm.g.a.xt;
import com.tencent.mm.g.a.yc;
import com.tencent.mm.g.a.yc.a;
import com.tencent.mm.g.a.yd;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
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
  public static int Bir = 1;
  public ArrayList<Bankcard> AYt;
  protected Bankcard AYu;
  protected Authen Bgj;
  private boolean BiA;
  protected ListView Bis;
  public com.tencent.mm.plugin.wallet_core.ui.s Bit;
  protected int Biu;
  public k Biv;
  protected String Biw;
  public FavorPayInfo Bix;
  private a Biy;
  com.tencent.mm.plugin.wallet_core.ui.f Biz;
  protected int dqL;
  public String iXf;
  protected PayInfo mPayInfo;
  protected TextView oem;
  private c wPR;
  protected Button wRL;
  protected Orders wSu;
  
  public WalletChangeBankcardUI()
  {
    AppMethodBeat.i(69313);
    this.dqL = 0;
    this.AYu = null;
    this.Biv = null;
    this.Bgj = null;
    this.wSu = null;
    this.mPayInfo = null;
    this.Biw = null;
    this.Biz = null;
    this.wPR = new c() {};
    this.BiA = false;
    AppMethodBeat.o(69313);
  }
  
  private void epy()
  {
    AppMethodBeat.i(69314);
    Object localObject = com.tencent.mm.wallet_core.a.br(this);
    if (localObject != null) {
      ((d)localObject).g(this, 1);
    }
    for (;;)
    {
      localObject = new yd();
      ((yd)localObject).dBG.result = -1;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(69314);
      return;
      finish();
    }
  }
  
  private ArrayList<Bankcard> epz()
  {
    AppMethodBeat.i(69317);
    if (this.dqL == 8)
    {
      localArrayList = (ArrayList)ae.tC(true);
      AppMethodBeat.o(69317);
      return localArrayList;
    }
    ArrayList localArrayList = (ArrayList)ae.tC(false);
    AppMethodBeat.o(69317);
    return localArrayList;
  }
  
  protected void Tw(int paramInt)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(69322);
    int i;
    Bankcard localBankcard;
    if (this.AYt != null)
    {
      i = this.AYt.size();
      ac.i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.AYt == null) || (paramInt >= i)) {
        break label181;
      }
      localBankcard = (Bankcard)this.AYt.get(paramInt);
      this.AYu = localBankcard;
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
    for (Object localObject = "";; localObject = this.mPayInfo.dac)
    {
      af.f(paramInt, (String)localObject, 13, this.AYu.field_bindSerial);
      this.Biv.BEP = localBankcard.field_bindSerial;
      this.wRL.setEnabled(true);
      this.Biv.notifyDataSetChanged();
      epB();
      AppMethodBeat.o(69322);
      return;
      i = 0;
      break;
      paramInt = this.mPayInfo.dqL;
      break label90;
    }
    label181:
    if (i == paramInt)
    {
      localObject = com.tencent.mm.plugin.wallet_core.model.g.erb();
      if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bjw())
      {
        com.tencent.mm.ui.base.h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).vwp, getString(2131755906), true);
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
    for (localObject = "";; localObject = this.mPayInfo.dac)
    {
      af.f(paramInt, (String)localObject, 14, "");
      getInput().putInt("key_err_code", -1003);
      getInput().putBoolean("key_has_click_bind_new_card", true);
      com.tencent.mm.wallet_core.a.k(this, getInput());
      AppMethodBeat.o(69322);
      return;
      paramInt = this.mPayInfo.dqL;
      break;
    }
  }
  
  protected void ayX(String paramString)
  {
    AppMethodBeat.i(69328);
    this.Bgj.BtA = paramString;
    boolean bool = getInput().getBoolean("key_has_click_bind_new_card", false);
    int i = getInput().getInt("key_pay_flag");
    if ((bool) && (i == 3))
    {
      ac.i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
      this.Bgj.drx = 3;
    }
    if (this.AYu != null)
    {
      getInput().putString("key_mobile", this.AYu.field_mobile);
      getInput().putParcelable("key_bankcard", this.AYu);
      this.Bgj.vwo = this.AYu.field_bindSerial;
      this.Bgj.cZz = this.AYu.field_bankcardType;
      if (this.Bix == null) {
        break label338;
      }
      this.Bgj.BtK = this.Bix.Bwv;
      if (this.wSu.BxS != null) {
        this.Bgj.BtJ = this.wSu.BxS.BgL;
      }
      if ((this.wSu != null) && (this.wSu.BoU == 3))
      {
        if (!this.AYu.eqU()) {
          break label349;
        }
        this.Bgj.drx = 3;
        label212:
        Bundle localBundle = getInput();
        if (this.AYu.eqU()) {
          break label361;
        }
        bool = true;
        label230:
        localBundle.putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putString("key_pwd1", paramString);
    getInput().putParcelable("key_authen", this.Bgj);
    paramString = com.tencent.mm.plugin.wallet.pay.a.a.a(this.Bgj, this.wSu, false);
    if (paramString != null)
    {
      paramString.setProcessName("PayProcess");
      paramString.setProcessBundle(getInput());
      if ((this.mPayInfo.dqL != 6) || (this.mPayInfo.DGI != 100)) {
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
      this.Bgj.BtK = null;
      break;
      label349:
      this.Bgj.drx = 6;
      break label212;
      label361:
      bool = false;
      break label230;
      label366:
      paramString.setScene(this.mPayInfo.dqL);
    }
  }
  
  public final void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69332);
    ac.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
    if (paramBoolean)
    {
      ac.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.djs = paramString1;
      this.mPayInfo.djt = paramString2;
      ayX(this.iXf);
      AppMethodBeat.o(69332);
      return;
    }
    ac.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
    ayX(this.iXf);
    AppMethodBeat.o(69332);
  }
  
  public final void cGR()
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
  
  public final void cL()
  {
    AppMethodBeat.i(69321);
    this.oem = ((TextView)findViewById(2131301034));
    if ((this.Bix != null) && (!bs.isNullOrNil(this.Bix.Bwz)))
    {
      this.oem.setVisibility(0);
      this.oem.setText(this.Bix.Bwz);
      AppMethodBeat.o(69321);
      return;
    }
    if (getInput().getInt("key_main_bankcard_state", 0) != 0)
    {
      this.oem.setVisibility(0);
      this.oem.setText(this.Biw);
      AppMethodBeat.o(69321);
      return;
    }
    this.oem.setVisibility(8);
    AppMethodBeat.o(69321);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(69329);
    if (paramInt == 0)
    {
      cGR();
      AppMethodBeat.o(69329);
      return;
    }
    if (paramInt == 1)
    {
      getInput().putString("key_pwd1", "");
      epB();
      AppMethodBeat.o(69329);
      return;
    }
    ac.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
    AppMethodBeat.o(69329);
  }
  
  protected k epA()
  {
    AppMethodBeat.i(69320);
    k localk = new k(this, this.AYt, this.Biu, this.wSu);
    AppMethodBeat.o(69320);
    return localk;
  }
  
  protected void epB()
  {
    AppMethodBeat.i(69327);
    ac.i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
    getInput().getString("key_pwd1");
    this.BiA = false;
    setContentViewVisibility(4);
    this.Bit = com.tencent.mm.plugin.wallet_core.ui.s.a(this, this.wSu, this.Bix, this.AYu, this.mPayInfo, new s.c()new View.OnClickListener
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69310);
        if (WalletChangeBankcardUI.b(WalletChangeBankcardUI.this))
        {
          ac.w("MicroMsg.WalletChangeBankcardUI", "has receive cancel");
          com.tencent.mm.plugin.report.service.h.wUl.n(965L, 3L, 1L);
          AppMethodBeat.o(69310);
          return;
        }
        WalletChangeBankcardUI.this.Bix = paramAnonymousFavorPayInfo;
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.Bix);
        if ((WalletChangeBankcardUI.this.Bix != null) && (paramAnonymousBoolean))
        {
          if (WalletChangeBankcardUI.this.Bix != null)
          {
            WalletChangeBankcardUI.this.ts(true);
            WalletChangeBankcardUI.this.Biv.f(WalletChangeBankcardUI.this.AYt, false);
          }
          if (WalletChangeBankcardUI.this.Bit != null) {
            WalletChangeBankcardUI.this.Bit.dismiss();
          }
          WalletChangeBankcardUI.this.cL();
          WalletChangeBankcardUI.this.setContentViewVisibility(0);
          AppMethodBeat.o(69310);
          return;
        }
        WalletChangeBankcardUI.this.iXf = paramAnonymousString;
        WalletChangeBankcardUI.this.hideVKB();
        WalletChangeBankcardUI.this.ayX(paramAnonymousString);
        WalletChangeBankcardUI.this.Biz = null;
        AppMethodBeat.o(69310);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69311);
        if (WalletChangeBankcardUI.this.Bit != null) {
          WalletChangeBankcardUI.this.Bit.dismiss();
        }
        WalletChangeBankcardUI.this.ts(false);
        WalletChangeBankcardUI.this.Biv.f(WalletChangeBankcardUI.this.AYt, true);
        WalletChangeBankcardUI.this.Bix = ((FavorPayInfo)paramAnonymousView.getTag());
        if (WalletChangeBankcardUI.this.Bix != null) {
          WalletChangeBankcardUI.this.Bix.Bwz = "";
        }
        WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.Bix);
        WalletChangeBankcardUI.this.cL();
        WalletChangeBankcardUI.this.setContentViewVisibility(0);
        WalletChangeBankcardUI.this.Biz = null;
        AppMethodBeat.o(69311);
      }
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(69312);
        ac.i("MicroMsg.WalletChangeBankcardUI", "WalletPwdDialog event2 %s", new Object[] { bs.eWi().toString() });
        WalletChangeBankcardUI.c(WalletChangeBankcardUI.this);
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        WalletChangeBankcardUI.this.iXf = null;
        if (WalletChangeBankcardUI.d(WalletChangeBankcardUI.this).getVisibility() != 0) {
          WalletChangeBankcardUI.this.cGR();
        }
        WalletChangeBankcardUI.this.Biz = null;
        AppMethodBeat.o(69312);
      }
    });
    this.Biz = this.Bit;
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
    this.wRL = ((Button)findViewById(2131303149));
    this.wRL.setEnabled(false);
    this.wRL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69308);
        WalletChangeBankcardUI.this.epB();
        AppMethodBeat.o(69308);
      }
    });
    if (bs.isNullOrNil(getInput().getString("key_pwd1"))) {
      this.wRL.setText(2131755835);
    }
    for (;;)
    {
      this.Bis = ((ListView)findViewById(2131304652));
      this.Biv = epA();
      this.Bis.setAdapter(this.Biv);
      this.Bis.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(69309);
          WalletChangeBankcardUI.this.Tw(paramAnonymousInt);
          AppMethodBeat.o(69309);
        }
      });
      cL();
      AppMethodBeat.o(69319);
      return;
      this.wRL.setText(2131765745);
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
    if ((this.mPayInfo == null) || (!this.mPayInfo.teP))
    {
      AppMethodBeat.o(69324);
      return false;
    }
    if (this.mPayInfo.teP)
    {
      AppMethodBeat.o(69324);
      return true;
    }
    com.tencent.mm.plugin.wallet.a.s.epp();
    if (!com.tencent.mm.plugin.wallet.a.s.epq().esa())
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
    ac.i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == Bir) {
      epy();
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
    this.Biu = paramBundle.getInt("key_support_bankcard", 1);
    this.Bgj = ((Authen)paramBundle.getParcelable("key_authen"));
    this.wSu = ((Orders)paramBundle.getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)paramBundle.getParcelable("key_pay_info"));
    this.Bix = ((FavorPayInfo)paramBundle.getParcelable("key_favor_pay_info"));
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      this.dqL = i;
      ac.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", new Object[] { Integer.valueOf(this.dqL) });
      if (!getInput().getBoolean("key_is_filter_bank_type")) {
        break label309;
      }
      ts(true);
    }
    for (;;)
    {
      if ((this.wSu != null) && (this.wSu.BxR != null) && (this.wSu.BxR.size() > 0)) {
        this.Biw = getString(2131765187, new Object[] { e.d(this.wSu.daf, this.wSu.vxl), ((Orders.Commodity)this.wSu.BxR.get(0)).desc });
      }
      initView();
      ab.km(7, 0);
      com.tencent.mm.sdk.b.a.GpY.c(this.wPR);
      if ((getInput().getBoolean("key_is_filter_bank_type")) && (this.Biv != null)) {
        this.Biv.BEQ = false;
      }
      AppMethodBeat.o(69316);
      return;
      i = this.mPayInfo.dqL;
      break;
      label309:
      this.AYt = epz();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69318);
    if (this.Biy != null)
    {
      this.Biy.closeTipDialog();
      this.Biy.release();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.wPR);
    this.Biz = null;
    super.onDestroy();
    AppMethodBeat.o(69318);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69325);
    if ((paramInt == 4) && (this.Bix != null) && (this.AYt.size() == 0))
    {
      Object localObject = this.Bix;
      int i;
      if ((localObject != null) && (((FavorPayInfo)localObject).Bww != 0)) {
        i = 1;
      }
      while (i != 0)
      {
        ac.i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
        localObject = getInput().getString("key_is_cur_bankcard_bind_serial");
        if (bs.isNullOrNil((String)localObject))
        {
          ac.e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
          bool = super.onKeyUp(paramInt, paramKeyEvent);
          AppMethodBeat.o(69325);
          return bool;
          i = 0;
        }
        else
        {
          ArrayList localArrayList = epz();
          if ((localArrayList != null) && (this.AYu == null))
          {
            i = 0;
            for (;;)
            {
              if (i < localArrayList.size())
              {
                if (((String)localObject).equals(((Bankcard)localArrayList.get(i)).field_bindSerial))
                {
                  ac.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:".concat(String.valueOf(localObject)));
                  this.AYu = ((Bankcard)localArrayList.get(i));
                }
              }
              else
              {
                if (this.AYu != null) {
                  break;
                }
                ac.e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                bool = super.onKeyUp(paramInt, paramKeyEvent);
                AppMethodBeat.o(69325);
                return bool;
              }
              i += 1;
            }
          }
          epB();
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
    if (this.Biz != null) {
      this.Biz.onActivityPause();
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
    if (this.Biz != null) {
      this.Biz.eth();
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
        if (!bs.isNullOrNil(this.iXf)) {
          paramString.putString("key_pwd1", this.iXf);
        }
        paramString.putString("kreq_token", paramn.getToken());
        paramString.putParcelable("key_authen", paramn.Bia);
        Object localObject1;
        Object localObject2;
        if (!paramn.BhY)
        {
          bool1 = true;
          paramString.putBoolean("key_need_verify_sms", bool1);
          paramString.putParcelable("key_pay_info", this.mPayInfo);
          paramString.putInt("key_pay_flag", 3);
          paramString.putInt("key_can_verify_tail", paramn.Bie);
          paramString.putString("key_verify_tail_wording", paramn.Bif);
          localObject1 = paramn.vsI;
          localObject2 = getInput();
          if (paramn.Big != 1) {
            break label410;
          }
          bool1 = true;
          label189:
          ((Bundle)localObject2).putBoolean("key_block_bind_new_card", bool1);
          if (!bs.isNullOrNil(paramn.Bib)) {
            break label416;
          }
          paramString.putString("key_mobile", this.AYu.field_mobile);
          label224:
          paramString.putString("key_QADNA_URL", paramn.Bic);
          if (localObject1 != null) {
            paramString.putParcelable("key_realname_guide_helper", (Parcelable)localObject1);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("pwd", this.iXf);
          localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
          if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject2).cGZ()) {
            break label431;
          }
          paramInt1 = 1;
        }
        for (;;)
        {
          ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
          ((com.tencent.mm.plugin.fingerprint.d.a)localObject2).a(paramn.epv(), true, (Bundle)localObject1);
          if (paramn.isPaySuccess)
          {
            paramString.putParcelable("key_orders", paramn.BhZ);
            if ((this.mPayInfo != null) && (this.mPayInfo.dqL == 8))
            {
              paramn = new xt();
              paramn.dBf.dBg = this.Bgj.vwo;
              com.tencent.mm.sdk.b.a.GpY.l(paramn);
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
          paramString.putString("key_mobile", paramn.Bib);
          break label224;
          label431:
          paramInt1 = i;
          if (((com.tencent.mm.plugin.fingerprint.d.a)localObject2).cHc()) {
            paramInt1 = 2;
          }
        }
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString("pwd", this.iXf);
      getInput().putBoolean("key_need_verify_sms", false);
      paramn = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.Bgj.wfX.BIq != 1) {
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
    this.mPayInfo.DGL = paramInt2;
    epB();
    AppMethodBeat.o(69326);
    return true;
    this.mPayInfo.DGL = paramInt2;
    bool1 = bool2;
    if (paramInt2 == 100100) {
      bool1 = true;
    }
    if (this.Biy == null) {
      this.Biy = new a(this, this);
    }
    this.Biy.b(bool1, this.mPayInfo.djq, this.mPayInfo.dac);
    ac.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(69326);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void ts(boolean paramBoolean)
  {
    AppMethodBeat.i(69331);
    this.AYt = epz();
    if (this.Bix != null) {
      if (this.Bix.Bww == 0) {
        break label48;
      }
    }
    label48:
    for (int i = 1; (i == 0) || (!paramBoolean); i = 0)
    {
      AppMethodBeat.o(69331);
      return;
    }
    String str = this.Bix.Bwx;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    if (i < this.AYt.size())
    {
      Bankcard localBankcard = (Bankcard)this.AYt.get(i);
      if (bs.isNullOrNil(str)) {
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
    this.AYt = localArrayList;
    AppMethodBeat.o(69331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */