package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.tn;
import com.tencent.mm.h.a.tw;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletChangeBankcardUI
  extends WalletBaseUI
  implements a.a
{
  public static int qmv = 1;
  protected int bUV = 0;
  public String frT;
  protected TextView iuP;
  protected Button nBL;
  private com.tencent.mm.sdk.b.c nCz = new WalletChangeBankcardUI.1(this);
  public PayInfo nDu = null;
  public Orders nEh = null;
  public o qgo;
  public ArrayList<Bankcard> qgr;
  public Bankcard qgs = null;
  public Authen qkD = null;
  public FavorPayInfo qmA;
  private a qmB;
  com.tencent.mm.plugin.wallet_core.ui.c qmC = null;
  protected ListView qmw;
  public int qmx;
  public com.tencent.mm.plugin.wallet_core.ui.g qmy = null;
  protected String qmz = null;
  
  private void bTU()
  {
    Object localObject = com.tencent.mm.wallet_core.a.aj(this);
    if (localObject != null) {
      ((com.tencent.mm.wallet_core.c)localObject).b(this, 1);
    }
    for (;;)
    {
      localObject = new tw();
      ((tw)localObject).cei.result = -1;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      return;
      finish();
    }
  }
  
  private boolean bTV()
  {
    return (this.nDu != null) && (this.nDu.bUV != 11);
  }
  
  private ArrayList<Bankcard> kt(boolean paramBoolean)
  {
    if (this.bUV == 8)
    {
      p.bTK();
      return p.bTL().kB(paramBoolean);
    }
    p.bTK();
    return p.bTL().kt(paramBoolean);
  }
  
  protected void AJ(int paramInt)
  {
    int k = 0;
    int j = 0;
    int i;
    if (this.qgr != null)
    {
      i = this.qgr.size();
      y.i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.qgr == null) || (paramInt >= i)) {
        break label171;
      }
      localBankcard = (Bankcard)this.qgr.get(paramInt);
      this.qgs = localBankcard;
      if (this.nDu != null) {
        break label148;
      }
      paramInt = j;
      if (this.nDu != null) {
        break label159;
      }
      localObject = "";
      aa.d(paramInt, (String)localObject, 13, this.qgs.field_bindSerial);
      this.qmy.qCP = localBankcard.field_bindSerial;
      this.nBL.setEnabled(true);
      this.qmy.notifyDataSetChanged();
      bTY();
    }
    label148:
    label159:
    label171:
    while (i != paramInt) {
      for (;;)
      {
        Bankcard localBankcard;
        return;
        i = 0;
        break;
        paramInt = this.nDu.bUV;
        continue;
        localObject = this.nDu.bMX;
      }
    }
    Object localObject = com.tencent.mm.plugin.wallet_core.model.g.bUY();
    if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).akH())
    {
      h.b(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).mOd, getString(a.i.app_tip), true);
      return;
    }
    if (this.nDu == null)
    {
      paramInt = k;
      if (this.nDu != null) {
        break label282;
      }
    }
    label282:
    for (localObject = "";; localObject = this.nDu.bMX)
    {
      aa.d(paramInt, (String)localObject, 14, "");
      this.BX.putInt("key_err_code", -1003);
      this.BX.putBoolean("key_has_click_bind_new_card", true);
      com.tencent.mm.wallet_core.a.j(this, this.BX);
      return;
      paramInt = this.nDu.bUV;
      break;
    }
  }
  
  public void Qj(String paramString)
  {
    this.qkD.qsI = paramString;
    boolean bool = this.BX.getBoolean("key_has_click_bind_new_card", false);
    int i = this.BX.getInt("key_pay_flag");
    if ((bool) && (i == 3))
    {
      y.i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
      this.qkD.bcw = 3;
    }
    if (this.qgs != null)
    {
      this.BX.putString("key_mobile", this.qgs.field_mobile);
      this.BX.putParcelable("key_bankcard", this.qgs);
      this.qkD.mOc = this.qgs.field_bindSerial;
      this.qkD.mOb = this.qgs.field_bankcardType;
      if (this.qmA == null) {
        break label328;
      }
      this.qkD.qsU = this.qmA.qvC;
      if (this.nEh.qwO != null) {
        this.qkD.qsT = this.nEh.qwO.qkW;
      }
      if ((this.nEh != null) && (this.nEh.qqY == 3))
      {
        if (!this.qgs.bUT()) {
          break label339;
        }
        this.qkD.bcw = 3;
        label206:
        Bundle localBundle = this.BX;
        if (this.qgs.bUT()) {
          break label351;
        }
        bool = true;
        label224:
        localBundle.putBoolean("key_is_oversea", bool);
      }
    }
    this.BX.putString("key_pwd1", paramString);
    this.BX.putParcelable("key_authen", this.qkD);
    paramString = com.tencent.mm.plugin.wallet.pay.a.a.a(this.qkD, this.nEh, false);
    if (paramString != null)
    {
      paramString.dIA = "PayProcess";
      paramString.BX = this.BX;
      if ((this.nDu.bUV != 6) || (this.nDu.snU != 100)) {
        break label356;
      }
    }
    label328:
    label339:
    label351:
    label356:
    for (paramString.fzn = 100;; paramString.fzn = this.nDu.bUV)
    {
      a(paramString, true, true);
      return;
      this.qkD.qsU = null;
      break;
      this.qkD.bcw = 6;
      break label206;
      bool = false;
      break label224;
    }
  }
  
  public final boolean aSk()
  {
    if (super.aSk()) {}
    do
    {
      return true;
      if ((this.nDu == null) || (!this.nDu.kPR)) {
        return false;
      }
    } while (this.nDu.kPR);
    p.bTK();
    return p.bTL().bVN();
  }
  
  protected final boolean aSl()
  {
    return true;
  }
  
  public final void aSr()
  {
    cNg();
    com.tencent.mm.wallet_core.c localc = com.tencent.mm.wallet_core.a.aj(this);
    if (localc != null)
    {
      localc.b(this, this.BX);
      return;
    }
    finish();
  }
  
  public final void aZ()
  {
    this.iuP = ((TextView)findViewById(a.f.input_tip));
    if ((this.qmA != null) && (!bk.bl(this.qmA.qvG)))
    {
      this.iuP.setVisibility(0);
      this.iuP.setText(this.qmA.qvG);
      return;
    }
    if (this.BX.getInt("key_main_bankcard_state", 0) != 0)
    {
      this.iuP.setVisibility(0);
      this.iuP.setText(this.qmz);
      return;
    }
    this.iuP.setVisibility(8);
  }
  
  public final void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    y.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
    if (paramBoolean)
    {
      y.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
      this.nDu.bOU = paramString1;
      this.nDu.bOV = paramString2;
      Qj(this.frT);
      return;
    }
    y.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
    Qj(this.frT);
  }
  
  protected final void bTW()
  {
    if (this.qgr != null) {
      Collections.sort(this.qgr, new WalletChangeBankcardUI.2(this));
    }
  }
  
  public com.tencent.mm.plugin.wallet_core.ui.g bTX()
  {
    bTW();
    return new com.tencent.mm.plugin.wallet_core.ui.g(this, this.qgr, this.qmx, this.nEh);
  }
  
  public void bTY()
  {
    y.i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
    String str = this.BX.getString("key_pwd1");
    if (bk.bl(str))
    {
      vN(4);
      this.qgo = o.a(this, this.nEh, this.qmA, this.qgs, this.nDu, new WalletChangeBankcardUI.5(this), new WalletChangeBankcardUI.6(this), new WalletChangeBankcardUI.7(this));
      this.qmC = this.qgo;
      return;
    }
    Qj(str);
  }
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.c.e)) {
        return true;
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        paramString = this.BX;
        paramm = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
        if (!bk.bl(this.frT)) {
          paramString.putString("key_pwd1", this.frT);
        }
        paramString.putString("kreq_token", paramm.token);
        paramString.putParcelable("key_authen", paramm.qmd);
        Object localObject;
        if (!paramm.qmb)
        {
          bool1 = true;
          paramString.putBoolean("key_need_verify_sms", bool1);
          paramString.putParcelable("key_pay_info", this.nDu);
          paramString.putInt("key_pay_flag", 3);
          paramString.putInt("key_can_verify_tail", paramm.qmh);
          paramString.putString("key_verify_tail_wording", paramm.qmi);
          localObject = paramm.mKP;
          Bundle localBundle = this.BX;
          bool1 = bool2;
          if (paramm.qmj == 1) {
            bool1 = true;
          }
          localBundle.putBoolean("key_block_bind_new_card", bool1);
          if (!bk.bl(paramm.qme)) {
            break label371;
          }
          paramString.putString("key_mobile", this.qgs.field_mobile);
        }
        for (;;)
        {
          paramString.putString("key_QADNA_URL", paramm.qmf);
          if (localObject != null) {
            paramString.putParcelable("key_realname_guide_helper", (Parcelable)localObject);
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("pwd", this.frT);
          ((com.tencent.mm.pluginsdk.k)com.tencent.mm.kernel.g.r(com.tencent.mm.pluginsdk.k.class)).a(paramm.bTQ(), true, (Bundle)localObject);
          if (paramm.qno)
          {
            paramString.putParcelable("key_orders", paramm.qmc);
            if ((this.nDu != null) && (this.nDu.bUV == 8))
            {
              paramm = new tn();
              paramm.cdL.cdM = this.qkD.mOc;
              com.tencent.mm.sdk.b.a.udP.m(paramm);
            }
          }
          com.tencent.mm.wallet_core.a.j(this, paramString);
          return true;
          bool1 = false;
          break;
          label371:
          paramString.putString("key_mobile", paramm.qme);
        }
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString("pwd", this.frT);
      this.BX.putBoolean("key_need_verify_sms", false);
      paramm = (com.tencent.mm.pluginsdk.k)com.tencent.mm.kernel.g.r(com.tencent.mm.pluginsdk.k.class);
      if (this.qkD.nqa.qFX != 1) {
        break label510;
      }
    }
    label510:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramm.a(bool1, true, paramString);
      switch (paramInt2)
      {
      default: 
        return false;
      }
    }
    this.nDu.snY = paramInt2;
    bTY();
    return true;
    this.nDu.snY = paramInt2;
    bool1 = bool3;
    if (paramInt2 == 100100) {
      bool1 = true;
    }
    if (this.qmB == null) {
      this.qmB = new a(this, this);
    }
    this.qmB.a(bool1, this.nDu.bOS, this.nDu.bMX);
    y.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + bool1);
    return true;
  }
  
  protected int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_change_bankcard;
  }
  
  public final void initView()
  {
    this.nBL = ((Button)findViewById(a.f.pay_btn));
    this.nBL.setEnabled(false);
    this.nBL.setOnClickListener(new WalletChangeBankcardUI.3(this));
    if (bk.bl(this.BX.getString("key_pwd1"))) {
      this.nBL.setText(a.i.app_ok);
    }
    for (;;)
    {
      this.qmw = ((ListView)findViewById(a.f.settings_lv_address));
      this.qmy = bTX();
      this.qmw.setAdapter(this.qmy);
      this.qmw.setOnItemClickListener(new WalletChangeBankcardUI.4(this));
      aZ();
      return;
      this.nBL.setText(a.i.wallet_pwd_dialog_pay_again);
    }
  }
  
  protected final void ku(boolean paramBoolean)
  {
    this.qgr = kt(bTV());
    if (this.qmA != null) {
      if (this.qmA.qvD == 0) {
        break label40;
      }
    }
    label40:
    for (int i = 1; (i == 0) || (!paramBoolean); i = 0) {
      return;
    }
    String str = this.qmA.qvE;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    if (i < this.qgr.size())
    {
      Bankcard localBankcard = (Bankcard)this.qgr.get(i);
      if (bk.bl(str)) {
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
    this.qgr = localArrayList;
    bTW();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == qmv) {
      bTU();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_select_use_bankcard_title);
    paramBundle = this.BX;
    paramBundle.putInt("key_err_code", 0);
    this.qmx = paramBundle.getInt("key_support_bankcard", 1);
    this.qkD = ((Authen)paramBundle.getParcelable("key_authen"));
    this.nEh = ((Orders)paramBundle.getParcelable("key_orders"));
    this.nDu = ((PayInfo)paramBundle.getParcelable("key_pay_info"));
    this.qmA = ((FavorPayInfo)paramBundle.getParcelable("key_favor_pay_info"));
    int i;
    if (this.nDu == null)
    {
      i = 0;
      this.bUV = i;
      y.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", new Object[] { Integer.valueOf(this.bUV) });
      if (!this.BX.getBoolean("key_is_filter_bank_type")) {
        break label300;
      }
      ku(true);
    }
    for (;;)
    {
      if ((this.nEh != null) && (this.nEh.qwN != null) && (this.nEh.qwN.size() > 0)) {
        this.qmz = getString(a.i.wallet_change_bankcard_tips, new Object[] { com.tencent.mm.wallet_core.ui.e.d(this.nEh.nCq, this.nEh.mOZ), ((Orders.Commodity)this.nEh.qwN.get(0)).desc });
      }
      bTW();
      initView();
      w.fT(7, 0);
      com.tencent.mm.sdk.b.a.udP.c(this.nCz);
      if ((this.BX.getBoolean("key_is_filter_bank_type")) && (this.qmy != null)) {
        this.qmy.qCQ = false;
      }
      return;
      i = this.nDu.bUV;
      break;
      label300:
      this.qgr = kt(bTV());
    }
  }
  
  public void onDestroy()
  {
    if (this.qmB != null)
    {
      this.qmB.bTT();
      this.qmB.release();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.nCz);
    this.qmC = null;
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.qmA != null) && (this.qgr.size() == 0))
    {
      Object localObject = this.qmA;
      int i;
      if ((localObject != null) && (((FavorPayInfo)localObject).qvD != 0)) {
        i = 1;
      }
      while (i != 0)
      {
        y.i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
        localObject = this.BX.getString("key_is_cur_bankcard_bind_serial");
        if (bk.bl((String)localObject))
        {
          y.e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
          return super.onKeyUp(paramInt, paramKeyEvent);
          i = 0;
        }
        else
        {
          ArrayList localArrayList = kt(true);
          if ((localArrayList != null) && (this.qgs == null))
          {
            i = 0;
            for (;;)
            {
              if (i < localArrayList.size())
              {
                if (((String)localObject).equals(((Bankcard)localArrayList.get(i)).field_bindSerial))
                {
                  y.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:" + (String)localObject);
                  this.qgs = ((Bankcard)localArrayList.get(i));
                }
              }
              else
              {
                if (this.qgs != null) {
                  break;
                }
                y.e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                return super.onKeyUp(paramInt, paramKeyEvent);
              }
              i += 1;
            }
          }
          bTY();
          return true;
        }
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.qmC != null) {
      this.qmC.bWt();
    }
  }
  
  public void onResume()
  {
    this.BX.putInt("key_err_code", 0);
    super.onResume();
    if (this.qmC != null) {
      this.qmC.bWs();
    }
  }
  
  public final void st(int paramInt)
  {
    if (paramInt == 0)
    {
      aSr();
      return;
    }
    if (paramInt == 1)
    {
      this.BX.putString("key_pwd1", "");
      bTY();
      return;
    }
    y.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */