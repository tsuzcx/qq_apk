package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.g.a.vs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.a.c.f;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.d;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletChangeBankcardUI
  extends WalletBaseUI
  implements a.a
{
  public static int tVK = 1;
  protected int cCD;
  public String gJv;
  protected TextView kvT;
  protected PayInfo mPayInfo;
  private com.tencent.mm.sdk.b.c qoE;
  protected Button qqy;
  protected Orders qrf;
  public ArrayList<Bankcard> tNG;
  protected Bankcard tNH;
  protected Authen tTD;
  protected ListView tVL;
  public q tVM;
  protected int tVN;
  public com.tencent.mm.plugin.wallet_core.ui.i tVO;
  protected String tVP;
  public FavorPayInfo tVQ;
  private a tVR;
  d tVS;
  private boolean tVT;
  
  public WalletChangeBankcardUI()
  {
    AppMethodBeat.i(45965);
    this.cCD = 0;
    this.tNH = null;
    this.tVO = null;
    this.tTD = null;
    this.qrf = null;
    this.mPayInfo = null;
    this.tVP = null;
    this.tVS = null;
    this.qoE = new WalletChangeBankcardUI.1(this);
    this.tVT = false;
    AppMethodBeat.o(45965);
  }
  
  private void cRQ()
  {
    AppMethodBeat.i(45966);
    Object localObject = com.tencent.mm.wallet_core.a.aM(this);
    if (localObject != null) {
      ((com.tencent.mm.wallet_core.c)localObject).e(this, 1);
    }
    for (;;)
    {
      localObject = new vs();
      ((vs)localObject).cMW.result = -1;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(45966);
      return;
      finish();
    }
  }
  
  private ArrayList<Bankcard> cRR()
  {
    AppMethodBeat.i(45969);
    if (this.cCD == 8)
    {
      localArrayList = (ArrayList)ae.nG(true);
      AppMethodBeat.o(45969);
      return localArrayList;
    }
    ArrayList localArrayList = (ArrayList)ae.nG(false);
    AppMethodBeat.o(45969);
    return localArrayList;
  }
  
  protected void In(int paramInt)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(45974);
    int i;
    Bankcard localBankcard;
    if (this.tNG != null)
    {
      i = this.tNG.size();
      ab.i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.tNG == null) || (paramInt >= i)) {
        break label181;
      }
      localBankcard = (Bankcard)this.tNG.get(paramInt);
      this.tNH = localBankcard;
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
    for (Object localObject = "";; localObject = this.mPayInfo.cnI)
    {
      ad.e(paramInt, (String)localObject, 13, this.tNH.field_bindSerial);
      this.tVO.upz = localBankcard.field_bindSerial;
      this.qqy.setEnabled(true);
      this.tVO.notifyDataSetChanged();
      cRT();
      AppMethodBeat.o(45974);
      return;
      i = 0;
      break;
      paramInt = this.mPayInfo.cCD;
      break label90;
    }
    label181:
    if (i == paramInt)
    {
      localObject = com.tencent.mm.plugin.wallet_core.model.i.cTp();
      if (((com.tencent.mm.plugin.wallet_core.model.i)localObject).Pk())
      {
        com.tencent.mm.ui.base.h.b(this, ((com.tencent.mm.plugin.wallet_core.model.i)localObject).pot, getString(2131297087), true);
        AppMethodBeat.o(45974);
        return;
      }
      if (this.mPayInfo != null) {
        break label290;
      }
      paramInt = k;
      if (this.mPayInfo != null) {
        break label301;
      }
    }
    label290:
    label301:
    for (localObject = "";; localObject = this.mPayInfo.cnI)
    {
      ad.e(paramInt, (String)localObject, 14, "");
      getInput().putInt("key_err_code", -1003);
      getInput().putBoolean("key_has_click_bind_new_card", true);
      com.tencent.mm.wallet_core.a.j(this, getInput());
      AppMethodBeat.o(45974);
      return;
      paramInt = this.mPayInfo.cCD;
      break;
    }
  }
  
  protected void afb(String paramString)
  {
    AppMethodBeat.i(45980);
    this.tTD.ueW = paramString;
    boolean bool = getInput().getBoolean("key_has_click_bind_new_card", false);
    int i = getInput().getInt("key_pay_flag");
    if ((bool) && (i == 3))
    {
      ab.i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
      this.tTD.bsY = 3;
    }
    if (this.tNH != null)
    {
      getInput().putString("key_mobile", this.tNH.field_mobile);
      getInput().putParcelable("key_bankcard", this.tNH);
      this.tTD.por = this.tNH.field_bindSerial;
      this.tTD.poq = this.tNH.field_bankcardType;
      if (this.tVQ == null) {
        break label338;
      }
      this.tTD.ufh = this.tVQ.uhU;
      if (this.qrf.ujm != null) {
        this.tTD.ufg = this.qrf.ujm.tUf;
      }
      if ((this.qrf != null) && (this.qrf.ubU == 3))
      {
        if (!this.tNH.cTi()) {
          break label349;
        }
        this.tTD.bsY = 3;
        label212:
        Bundle localBundle = getInput();
        if (this.tNH.cTi()) {
          break label361;
        }
        bool = true;
        label230:
        localBundle.putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putString("key_pwd1", paramString);
    getInput().putParcelable("key_authen", this.tTD);
    paramString = com.tencent.mm.plugin.wallet.pay.a.a.a(this.tTD, this.qrf, false);
    if (paramString != null)
    {
      paramString.setProcessName("PayProcess");
      paramString.setProcessBundle(getInput());
      if ((this.mPayInfo.cCD != 6) || (this.mPayInfo.wgs != 100)) {
        break label366;
      }
      paramString.setScene(100);
    }
    for (;;)
    {
      doSceneProgress(paramString);
      AppMethodBeat.o(45980);
      return;
      label338:
      this.tTD.ufh = null;
      break;
      label349:
      this.tTD.bsY = 6;
      break label212;
      label361:
      bool = false;
      break label230;
      label366:
      paramString.setScene(this.mPayInfo.cCD);
    }
  }
  
  public final void bJ()
  {
    AppMethodBeat.i(45973);
    this.kvT = ((TextView)findViewById(2131828908));
    if ((this.tVQ != null) && (!bo.isNullOrNil(this.tVQ.uhY)))
    {
      this.kvT.setVisibility(0);
      this.kvT.setText(this.tVQ.uhY);
      AppMethodBeat.o(45973);
      return;
    }
    if (getInput().getInt("key_main_bankcard_state", 0) != 0)
    {
      this.kvT.setVisibility(0);
      this.kvT.setText(this.tVP);
      AppMethodBeat.o(45973);
      return;
    }
    this.kvT.setVisibility(8);
    AppMethodBeat.o(45973);
  }
  
  public final void byK()
  {
    AppMethodBeat.i(45982);
    cancelQRPay();
    com.tencent.mm.wallet_core.c localc = com.tencent.mm.wallet_core.a.aM(this);
    if (localc != null)
    {
      localc.b(this, getInput());
      AppMethodBeat.o(45982);
      return;
    }
    finish();
    AppMethodBeat.o(45982);
  }
  
  public final void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(45984);
    ab.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
    if (paramBoolean)
    {
      ab.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.cwl = paramString1;
      this.mPayInfo.cwm = paramString2;
      afb(this.gJv);
      AppMethodBeat.o(45984);
      return;
    }
    ab.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
    afb(this.gJv);
    AppMethodBeat.o(45984);
  }
  
  protected com.tencent.mm.plugin.wallet_core.ui.i cRS()
  {
    AppMethodBeat.i(45972);
    com.tencent.mm.plugin.wallet_core.ui.i locali = new com.tencent.mm.plugin.wallet_core.ui.i(this, this.tNG, this.tVN, this.qrf);
    AppMethodBeat.o(45972);
    return locali;
  }
  
  protected void cRT()
  {
    AppMethodBeat.i(45979);
    ab.i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
    getInput().getString("key_pwd1");
    this.tVT = false;
    setContentViewVisibility(4);
    this.tVM = q.a(this, this.qrf, this.tVQ, this.tNH, this.mPayInfo, new WalletChangeBankcardUI.5(this), new WalletChangeBankcardUI.6(this), new WalletChangeBankcardUI.7(this));
    this.tVS = this.tVM;
    AppMethodBeat.o(45979);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(45981);
    if (paramInt == 0)
    {
      byK();
      AppMethodBeat.o(45981);
      return;
    }
    if (paramInt == 1)
    {
      getInput().putString("key_pwd1", "");
      cRT();
      AppMethodBeat.o(45981);
      return;
    }
    ab.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
    AppMethodBeat.o(45981);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971159;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45971);
    this.qqy = ((Button)findViewById(2131829079));
    this.qqy.setEnabled(false);
    this.qqy.setOnClickListener(new WalletChangeBankcardUI.3(this));
    if (bo.isNullOrNil(getInput().getString("key_pwd1"))) {
      this.qqy.setText(2131297018);
    }
    for (;;)
    {
      this.tVL = ((ListView)findViewById(2131828919));
      this.tVO = cRS();
      this.tVL.setAdapter(this.tVO);
      this.tVL.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(45961);
          WalletChangeBankcardUI.this.In(paramAnonymousInt);
          AppMethodBeat.o(45961);
        }
      });
      bJ();
      AppMethodBeat.o(45971);
      return;
      this.qqy.setText(2131305530);
    }
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(45976);
    if (super.isTransparent())
    {
      AppMethodBeat.o(45976);
      return true;
    }
    if ((this.mPayInfo == null) || (!this.mPayInfo.nnQ))
    {
      AppMethodBeat.o(45976);
      return false;
    }
    if (this.mPayInfo.nnQ)
    {
      AppMethodBeat.o(45976);
      return true;
    }
    s.cRG();
    if (!s.cRH().cUl())
    {
      AppMethodBeat.o(45976);
      return false;
    }
    AppMethodBeat.o(45976);
    return false;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  protected final void nx(boolean paramBoolean)
  {
    AppMethodBeat.i(45983);
    this.tNG = cRR();
    if (this.tVQ != null) {
      if (this.tVQ.uhV == 0) {
        break label48;
      }
    }
    label48:
    for (int i = 1; (i == 0) || (!paramBoolean); i = 0)
    {
      AppMethodBeat.o(45983);
      return;
    }
    String str = this.tVQ.uhW;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    if (i < this.tNG.size())
    {
      Bankcard localBankcard = (Bankcard)this.tNG.get(i);
      if (bo.isNullOrNil(str)) {
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
    this.tNG = localArrayList;
    AppMethodBeat.o(45983);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45967);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == tVK) {
      cRQ();
    }
    AppMethodBeat.o(45967);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45968);
    super.onCreate(paramBundle);
    setMMTitle(2131305646);
    paramBundle = getInput();
    paramBundle.putInt("key_err_code", 0);
    this.tVN = paramBundle.getInt("key_support_bankcard", 1);
    this.tTD = ((Authen)paramBundle.getParcelable("key_authen"));
    this.qrf = ((Orders)paramBundle.getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)paramBundle.getParcelable("key_pay_info"));
    this.tVQ = ((FavorPayInfo)paramBundle.getParcelable("key_favor_pay_info"));
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      this.cCD = i;
      ab.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", new Object[] { Integer.valueOf(this.cCD) });
      if (!getInput().getBoolean("key_is_filter_bank_type")) {
        break label308;
      }
      nx(true);
    }
    for (;;)
    {
      if ((this.qrf != null) && (this.qrf.ujl != null) && (this.qrf.ujl.size() > 0)) {
        this.tVP = getString(2131304995, new Object[] { e.e(this.qrf.cnL, this.qrf.ppp), ((Orders.Commodity)this.qrf.ujl.get(0)).desc });
      }
      initView();
      z.id(7, 0);
      com.tencent.mm.sdk.b.a.ymk.c(this.qoE);
      if ((getInput().getBoolean("key_is_filter_bank_type")) && (this.tVO != null)) {
        this.tVO.upA = false;
      }
      AppMethodBeat.o(45968);
      return;
      i = this.mPayInfo.cCD;
      break;
      label308:
      this.tNG = cRR();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45970);
    if (this.tVR != null)
    {
      this.tVR.cRP();
      this.tVR.release();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.qoE);
    this.tVS = null;
    super.onDestroy();
    AppMethodBeat.o(45970);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(45977);
    if ((paramInt == 4) && (this.tVQ != null) && (this.tNG.size() == 0))
    {
      Object localObject = this.tVQ;
      int i;
      if ((localObject != null) && (((FavorPayInfo)localObject).uhV != 0)) {
        i = 1;
      }
      while (i != 0)
      {
        ab.i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
        localObject = getInput().getString("key_is_cur_bankcard_bind_serial");
        if (bo.isNullOrNil((String)localObject))
        {
          ab.e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
          bool = super.onKeyUp(paramInt, paramKeyEvent);
          AppMethodBeat.o(45977);
          return bool;
          i = 0;
        }
        else
        {
          ArrayList localArrayList = cRR();
          if ((localArrayList != null) && (this.tNH == null))
          {
            i = 0;
            for (;;)
            {
              if (i < localArrayList.size())
              {
                if (((String)localObject).equals(((Bankcard)localArrayList.get(i)).field_bindSerial))
                {
                  ab.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:".concat(String.valueOf(localObject)));
                  this.tNH = ((Bankcard)localArrayList.get(i));
                }
              }
              else
              {
                if (this.tNH != null) {
                  break;
                }
                ab.e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                bool = super.onKeyUp(paramInt, paramKeyEvent);
                AppMethodBeat.o(45977);
                return bool;
              }
              i += 1;
            }
          }
          cRT();
          AppMethodBeat.o(45977);
          return true;
        }
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(45977);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(45985);
    super.onPause();
    if (this.tVS != null) {
      this.tVS.onActivityPause();
    }
    AppMethodBeat.o(45985);
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45975);
    getInput().putInt("key_err_code", 0);
    super.onResume();
    if (this.tVS != null) {
      this.tVS.cVq();
    }
    AppMethodBeat.o(45975);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    int i = 0;
    AppMethodBeat.i(45978);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof f))
      {
        AppMethodBeat.o(45978);
        return true;
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        paramString = getInput();
        paramm = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
        if (!bo.isNullOrNil(this.gJv)) {
          paramString.putString("key_pwd1", this.gJv);
        }
        paramString.putString("kreq_token", paramm.getToken());
        paramString.putParcelable("key_authen", paramm.tVs);
        Object localObject1;
        Object localObject2;
        if (!paramm.tVq)
        {
          bool1 = true;
          paramString.putBoolean("key_need_verify_sms", bool1);
          paramString.putParcelable("key_pay_info", this.mPayInfo);
          paramString.putInt("key_pay_flag", 3);
          paramString.putInt("key_can_verify_tail", paramm.tVw);
          paramString.putString("key_verify_tail_wording", paramm.tVx);
          localObject1 = paramm.plg;
          localObject2 = getInput();
          if (paramm.tVy != 1) {
            break label410;
          }
          bool1 = true;
          label189:
          ((Bundle)localObject2).putBoolean("key_block_bind_new_card", bool1);
          if (!bo.isNullOrNil(paramm.tVt)) {
            break label416;
          }
          paramString.putString("key_mobile", this.tNH.field_mobile);
          label224:
          paramString.putString("key_QADNA_URL", paramm.tVu);
          if (localObject1 != null) {
            paramString.putParcelable("key_realname_guide_helper", (Parcelable)localObject1);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("pwd", this.gJv);
          localObject2 = (l)g.E(l.class);
          if (!((l)localObject2).byS()) {
            break label431;
          }
          paramInt1 = 1;
        }
        for (;;)
        {
          ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
          ((l)localObject2).a(paramm.cRM(), true, (Bundle)localObject1);
          if (paramm.isPaySuccess)
          {
            paramString.putParcelable("key_orders", paramm.tVr);
            if ((this.mPayInfo != null) && (this.mPayInfo.cCD == 8))
            {
              paramm = new vi();
              paramm.cMv.cMw = this.tTD.por;
              com.tencent.mm.sdk.b.a.ymk.l(paramm);
            }
          }
          com.tencent.mm.wallet_core.a.j(this, paramString);
          AppMethodBeat.o(45978);
          return true;
          bool1 = false;
          break;
          label410:
          bool1 = false;
          break label189;
          label416:
          paramString.putString("key_mobile", paramm.tVt);
          break label224;
          label431:
          paramInt1 = i;
          if (((l)localObject2).byV()) {
            paramInt1 = 2;
          }
        }
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString("pwd", this.gJv);
      getInput().putBoolean("key_need_verify_sms", false);
      paramm = (l)g.E(l.class);
      if (this.tTD.pVo.utc != 1) {
        break label580;
      }
    }
    label580:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramm.a(bool1, true, paramString);
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(45978);
        return false;
      }
    }
    this.mPayInfo.wgw = paramInt2;
    cRT();
    AppMethodBeat.o(45978);
    return true;
    this.mPayInfo.wgw = paramInt2;
    bool1 = bool2;
    if (paramInt2 == 100100) {
      bool1 = true;
    }
    if (this.tVR == null) {
      this.tVR = new a(this, this);
    }
    this.tVR.a(bool1, this.mPayInfo.cwj, this.mPayInfo.cnI);
    ab.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(45978);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */