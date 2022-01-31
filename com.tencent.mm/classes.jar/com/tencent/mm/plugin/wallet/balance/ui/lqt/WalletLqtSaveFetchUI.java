package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet.balance.a.a.i;
import com.tencent.mm.plugin.wallet.balance.a.a.l;
import com.tencent.mm.plugin.wallet.balance.a.a.n;
import com.tencent.mm.plugin.wallet.balance.a.a.o;
import com.tencent.mm.plugin.wallet.balance.a.a.o.6;
import com.tencent.mm.plugin.wallet.balance.a.a.o.7;
import com.tencent.mm.plugin.wallet.balance.a.a.o.8;
import com.tencent.mm.plugin.wallet.balance.a.a.o.9;
import com.tencent.mm.plugin.wallet.balance.a.a.p.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aup;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletLqtSaveFetchUI
  extends WalletLqtBasePresenterUI
{
  private int accountType;
  private Dialog eXA;
  private HashMap<String, Integer> mNg = new HashMap();
  private int mode;
  private com.tencent.mm.plugin.wallet.balance.a.a.m qfV = (com.tencent.mm.plugin.wallet.balance.a.a.m)C(com.tencent.mm.plugin.wallet.balance.a.a.m.class);
  private n qfW = (n)z(n.class);
  private Bankcard qgs;
  private WalletFormView qiA;
  private TextView qiB;
  private TextView qiC;
  private Button qiD;
  private ImageView qiE;
  private TextView qiF;
  private TextView qiG;
  private ViewGroup qiH;
  private TextView qiI;
  private CheckBox qiJ;
  private TextView qiK;
  private TextView qiL;
  private TextView qiM;
  private TextView qiN;
  private WalletLqtArriveTimeLayout qiO;
  private ScrollView qiP;
  private CharSequence qiQ;
  private Bankcard qiR;
  private int qiS;
  private String qiT;
  private String qiU;
  private long qiV = -1L;
  private String qiW;
  private boolean qiX = false;
  private List<Bankcard> qiY;
  private o qix = new o(this.qfV, this.qfW, this);
  private com.tencent.mm.plugin.wallet.balance.a.a.p qiy = new com.tencent.mm.plugin.wallet.balance.a.a.p(this.qix);
  private ViewGroup qiz;
  
  private void bTw()
  {
    Object localObject1 = i.qfx;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((i)localObject1).kl(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.p.bTK();
        localObject1 = com.tencent.mm.plugin.wallet.a.p.bTL().bWc();
      }
      localObject2 = new LinkedList();
      if (localObject1 != null) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label195;
        }
        Bankcard localBankcard = (Bankcard)((Iterator)localObject1).next();
        if (localBankcard.bUQ())
        {
          com.tencent.mm.plugin.wallet.a.p.bTK();
          if (!com.tencent.mm.plugin.wallet.a.p.bTL().bVK())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && (localBankcard.field_support_lqt_turn_in == 1)) {
          ((List)localObject2).add(localBankcard);
        }
        if ((this.mode == 2) && (localBankcard.field_support_lqt_turn_out == 1)) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label195:
    localObject1 = i.qfx;
    if (this.mode == 1)
    {
      bool = true;
      this.qgs = ((i)localObject1).kk(bool);
      if (this.qgs == null)
      {
        com.tencent.mm.plugin.wallet.a.p.bTK();
        this.qgs = com.tencent.mm.plugin.wallet.a.p.bTL().qhj;
      }
      if (this.qgs == null) {
        break label362;
      }
    }
    int i;
    label362:
    for (localObject1 = this.qgs.field_bindSerial;; localObject1 = "")
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletLqtSaveFetchUI", "defaultBankcard: %s, save mCurrentSerial: %s", new Object[] { localObject1, this.qiW });
      if (bk.bl(this.qiW)) {
        break label369;
      }
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = (Bankcard)((List)localObject2).get(i);
        if ((!bk.bl(((Bankcard)localObject1).field_bindSerial)) && (this.qiW.equals(((Bankcard)localObject1).field_bindSerial))) {
          this.qgs = ((Bankcard)localObject1);
        }
        i += 1;
      }
      bool = false;
      break;
    }
    label369:
    if (this.qgs.bUQ())
    {
      this.qiC.setText(this.qgs.field_desc);
      this.qiC.setText(this.qgs.field_desc);
      this.qiC.setVisibility(0);
      this.qiE.setTag(this.qgs.field_bindSerial);
      if (this.qiE != null)
      {
        localObject1 = "";
        localObject2 = com.tencent.mm.plugin.wallet_core.d.b.h(this, this.qgs.field_bankcardType, this.qgs.bUP());
        if (localObject2 != null) {
          localObject1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject2).mEi;
        }
        this.qiE.setImageBitmap(null);
        if (!this.qgs.bUQ()) {
          break label897;
        }
        this.qiE.setImageResource(a.e.wallet_balance_manager_logo_small);
      }
      label500:
      this.qiK.setVisibility(8);
      this.qiL.setVisibility(8);
      if ((this.mode != 2) && (this.mode == 1) && (!this.qgs.bUQ()) && (!bk.bl(this.qgs.field_avail_save_wording)))
      {
        this.qiK.setText(this.qgs.field_avail_save_wording);
        this.qiK.setVisibility(0);
      }
      if (this.mode != 1) {
        break label981;
      }
      setMMTitle(getString(a.i.wallet_lqt_save_wording));
      localObject1 = getIntent().getStringArrayListExtra("lqt_protocol_list");
      bool = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0) || (!bool)) {
        break label969;
      }
      this.qiH.setVisibility(0);
      this.qiJ.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
      this.qiH.setOnClickListener(new WalletLqtSaveFetchUI.3(this));
      this.qiJ.setOnCheckedChangeListener(new WalletLqtSaveFetchUI.4(this));
      localObject2 = getString(a.i.wallet_lqt_protocol_agree_prefix);
      i = ((String)localObject2).length();
      localObject2 = new SpannableString((String)localObject2 + getString(a.i.wallet_lqt_protocol_agree_suffix));
      ((SpannableString)localObject2).setSpan(new a(new WalletLqtSaveFetchUI.5(this, (ArrayList)localObject1)), i, ((SpannableString)localObject2).length(), 17);
      this.qiI.setText((CharSequence)localObject2);
      this.qiI.setClickable(true);
      this.qiI.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
      if (this.mode == 1)
      {
        if ((this.qgs == null) || (!this.qgs.bUQ())) {
          break label1385;
        }
        this.qiF.setText(this.qiQ);
      }
    }
    for (;;)
    {
      label805:
      this.qiA.setText(this.qiA.getText());
      return;
      this.qiC.setText(getString(a.i.wallet_balance_save_bankcard_tips, new Object[] { this.qgs.field_bankName, this.qgs.field_bankcardTail }));
      break;
      label897:
      localObject1 = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject1));
      x.a(new WalletLqtSaveFetchUI.15(this));
      if (localObject1 == null) {
        break label500;
      }
      localObject1 = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject1, getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);
      this.qiE.setImageBitmap((Bitmap)localObject1);
      break label500;
      label969:
      this.qiH.setVisibility(8);
      break label805;
      label981:
      if (this.mode != 2) {
        break label805;
      }
      findViewById(a.f.wallet_info_tip).setVisibility(8);
      this.qiH.setVisibility(8);
      setMMTitle(getString(a.i.wallet_lqt_fetch_wording_title));
      this.qiG.setVisibility(8);
      localObject1 = l.bTj();
      if ((this.qgs != null) && (this.qgs.bUQ()))
      {
        i = getIntent().getIntExtra("lqt_balance", 0);
        if (ae.eTL) {
          i = 50000000;
        }
        if (i <= 0) {
          break label805;
        }
        localObject1 = getString(a.i.wallet_lqt_fetch_remain_wording_1, new Object[] { Double.valueOf(fe(String.valueOf(i), "100")) });
        j = ((String)localObject1).length();
        localObject1 = new SpannableString((String)localObject1 + getString(a.i.wallet_lqt_fetch_remain_wording_2));
        ((SpannableString)localObject1).setSpan(new a(new WalletLqtSaveFetchUI.12(this, i)), j, ((SpannableString)localObject1).length(), 18);
        this.qiQ = ((CharSequence)localObject1);
        this.qiF.setText((CharSequence)localObject1);
        break label805;
      }
      if (((l)localObject1).qfL == null)
      {
        i = 0;
        label1204:
        if (((l)localObject1).qfL != null) {
          break label1373;
        }
      }
      label1373:
      for (int j = 0;; j = ((l)localObject1).qfL.twa)
      {
        if (ae.eTL)
        {
          i = 100000000;
          j = 50000000;
        }
        localObject2 = getString(a.i.wallet_lqt_fetch_remain_wording_1_2, new Object[] { Double.valueOf(fe(String.valueOf(i), "100")), Double.valueOf(fe(String.valueOf(j), "100")) });
        i = ((String)localObject2).length();
        localObject2 = new SpannableString((String)localObject2 + getString(a.i.wallet_lqt_fetch_remain_wording_1_2_tail));
        ((SpannableString)localObject2).setSpan(new a(new WalletLqtSaveFetchUI.13(this, (l)localObject1)), i, ((SpannableString)localObject2).length(), 18);
        this.qiQ = ((CharSequence)localObject2);
        this.qiF.setText((CharSequence)localObject2);
        break;
        i = ((l)localObject1).qfL.balance;
        break label1204;
      }
      label1385:
      this.qiF.setText("");
    }
  }
  
  private List<Bankcard> bTx()
  {
    Object localObject1 = i.qfx;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((i)localObject1).kl(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.p.bTK();
        localObject1 = com.tencent.mm.plugin.wallet.a.p.bTL().bWc();
      }
      localObject2 = new LinkedList();
      if (localObject1 != null) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          return localObject2;
        }
        Bankcard localBankcard = (Bankcard)((Iterator)localObject1).next();
        if (localBankcard.bUQ())
        {
          com.tencent.mm.plugin.wallet.a.p.bTK();
          if (!com.tencent.mm.plugin.wallet.a.p.bTL().bVK())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.bUQ()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((this.mode == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.bUQ()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    return localObject2;
  }
  
  private static double fe(String paramString1, String paramString2)
  {
    try
    {
      if (bk.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim()) {
        return new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), 5, 2).doubleValue();
      }
      return 0.0D;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
    }
  }
  
  private static int ff(String paramString1, String paramString2)
  {
    try
    {
      double d1 = bk.getDouble(paramString1, 0.0D);
      double d2 = bk.getDouble(paramString2, 0.0D);
      if (d1 == 0.0D) {
        paramString1 = "0";
      }
      paramString1 = new BigDecimal(paramString1);
      if (d2 == 0.0D) {
        paramString2 = "0";
      }
      int i = paramString1.multiply(new BigDecimal(paramString2)).intValue();
      return i;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
    }
    return 0;
  }
  
  private void ko(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mode == 1)
      {
        if (this.qiH.getVisibility() == 0)
        {
          if ((this.qiJ.isChecked()) && (this.qiX)) {
            this.qiD.setEnabled(true);
          }
        }
        else {
          return;
        }
        this.qiD.setEnabled(false);
        return;
      }
      if ((this.qiX) && (this.qiO.getVisibility() == 0) && ((this.qiO.getSelectRedeemType() != null) || (this.qiO.getRedeemTypeList() == null) || (this.qiO.getRedeemTypeList().isEmpty())))
      {
        if (this.qiO.getSelectRedeemType() == null) {}
        for (Integer localInteger = null;; localInteger = Integer.valueOf(this.qiO.getSelectRedeemType().tAb))
        {
          com.tencent.mm.sdk.platformtools.y.v("MicroMsg.WalletLqtSaveFetchUI", "redeem type: %s", new Object[] { localInteger });
          this.qiD.setEnabled(true);
          return;
        }
      }
    }
    this.qiD.setEnabled(false);
  }
  
  public final void Lz(String paramString)
  {
    Toast.makeText(this, paramString, 1).show();
  }
  
  public final void bTy()
  {
    if (this.eXA != null) {
      this.eXA.dismiss();
    }
  }
  
  public final void bTz()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyN, this.qiW);
      localObject = i.qfx;
      if (this.mode != 1) {
        break label148;
      }
      bool1 = true;
      label44:
      ((i)localObject).kn(bool1);
      if (!bool1) {
        break label153;
      }
    }
    label148:
    label153:
    for (Object localObject = ((i)localObject).qfr;; localObject = ((i)localObject).qfs)
    {
      bool1 = bool2;
      if (localObject != null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", new Object[] { Boolean.valueOf(((aup)localObject).tqf) });
        bool1 = ((aup)localObject).tqf;
      }
      if (bool1)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletLqtSaveFetchUI", "saveOrfetchDone, req again after deal");
        this.qiy.qgj.et(this.mode, this.accountType);
      }
      return;
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyO, this.qiW);
      break;
      bool1 = false;
      break label44;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    o localo = this.qix;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))
    {
      com.tencent.mm.plugin.wallet.a.p.bTK();
      localo.qgc = com.tencent.mm.plugin.wallet.a.p.bTL().qhj;
      if (localo.eVG != null)
      {
        localo.eVG.x(new Object[] { paramm });
        localo.eVG.resume();
      }
    }
    return super.c(paramInt1, paramInt2, paramString, paramm);
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_lqt_save_ui;
  }
  
  public final void kp(boolean paramBoolean)
  {
    if ((this.eXA == null) || (!this.eXA.isShowing()))
    {
      if (paramBoolean) {
        this.eXA = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
      }
    }
    else {
      return;
    }
    this.eXA = com.tencent.mm.wallet_core.ui.g.b(this, false, null);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    o localo = this.qix;
    if ((paramInt1 == o.qfT) && (paramInt2 == -1))
    {
      paramIntent = (Orders)paramIntent.getParcelableExtra("key_orders");
      if ((paramIntent != null) && (paramIntent.qwN != null) && (paramIntent.qwN.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s", new Object[] { Integer.valueOf(localo.hashCode()), Integer.valueOf(localo.accountType) });
        localo.bMY = ((Orders.Commodity)paramIntent.qwN.get(0)).bMY;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
        localo.qfX.kp(false);
        paramIntent = localo.qfW.qfP;
        f.a(localo.qfY, localo.bMY, Integer.valueOf(localo.qfZ), Integer.valueOf(localo.accountType)).c(paramIntent).f(new o.7(localo)).a(new o.6(localo));
      }
    }
    while ((paramInt1 != o.qfU) || (paramInt2 != -1)) {
      return;
    }
    String str = paramIntent.getStringExtra("lqt_fetch_enc_pwd");
    paramIntent = paramIntent.getStringExtra("lqt_redeem_listid");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", new Object[] { Integer.valueOf(localo.hashCode()), Integer.valueOf(localo.accountType), paramIntent });
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", new Object[] { Integer.valueOf(localo.hashCode()), paramIntent });
    if (bk.bl(localo.qgb))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", new Object[] { Integer.valueOf(localo.hashCode()), paramIntent });
      localo.qgb = paramIntent;
    }
    localo.qfX.kp(true);
    paramIntent = localo.qfW.qfQ;
    f.a(Integer.valueOf(localo.qga), str, localo.qgb, Integer.valueOf(localo.accountType)).c(paramIntent).f(new o.9(localo)).a(new o.8(localo));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    ta(getResources().getColor(a.c.white));
    czo();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
    this.qiA = ((WalletFormView)findViewById(a.f.lqt_save_form));
    this.qiD = ((Button)findViewById(a.f.next_btn));
    this.qiE = ((ImageView)findViewById(a.f.bankcard_logo_iv));
    this.qiF = ((TextView)findViewById(a.f.lqt_save_balance_hint));
    this.qiG = ((TextView)findViewById(a.f.lqt_save_balance_hint2));
    this.qiB = ((TextView)findViewById(a.f.lqt_save_hint));
    this.qiC = ((TextView)findViewById(a.f.lqt_balance_bankcard));
    this.qiM = ((TextView)findViewById(a.f.wallet_title));
    this.qiH = ((ViewGroup)findViewById(a.f.lqt_save_protocal_layout));
    this.qiI = ((TextView)findViewById(a.f.lqt_save_protocol_link_tv));
    this.qiJ = ((CheckBox)findViewById(a.f.lqt_save_protocol_agree_checkbox));
    this.qiz = ((ViewGroup)findViewById(a.f.main_content));
    this.qiK = ((TextView)findViewById(a.f.hint_1));
    this.qiL = ((TextView)findViewById(a.f.hint_2));
    this.qiN = ((TextView)findViewById(a.f.lqt_save_arrive_time_title));
    this.qiO = ((WalletLqtArriveTimeLayout)findViewById(a.f.lqt_save_arrive_time_layout));
    this.qiP = ((ScrollView)findViewById(a.f.lqt_root_view));
    this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
    this.qiS = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
    this.qiT = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
    this.qiU = getIntent().getStringExtra("lqt_profile_wording");
    this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.DQ();
      this.qiW = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyN, ""));
      if (bk.bl(this.qiW))
      {
        com.tencent.mm.kernel.g.DQ();
        this.qiW = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyM, ""));
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", new Object[] { Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.qiW });
      this.qiA.getTitleTv().setText(com.tencent.mm.wallet_core.c.ab.cML());
      if (this.mode != 1) {
        break label962;
      }
      a(this.qiA, 2, false, true, false);
      label489:
      if (this.mode != 1) {
        break label982;
      }
      this.qiB.setText(getString(a.i.wallet_lqt_save_amount_hint));
      this.qiD.setText(a.i.wallet_lqt_save_wording);
      this.qiM.setText(getString(a.i.wallet_lqt_save_hint_bank_card_wording));
      label535:
      this.qiA.a(new WalletLqtSaveFetchUI.6(this));
      this.lTH = new WalletLqtSaveFetchUI.7(this);
      this.qiD.setOnClickListener(new WalletLqtSaveFetchUI.8(this));
      if (!bk.bl(this.qiU))
      {
        paramBundle = (TextView)findViewById(a.f.lqt_profile_wording);
        paramBundle.setText(this.qiU);
        paramBundle.setVisibility(0);
      }
      if (this.mode == 2) {
        this.qiO.setCallback(new WalletLqtSaveFetchUI.9(this));
      }
      this.qiF.setText("");
      this.qiF.setClickable(true);
      this.qiF.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
      ko(false);
      if (this.mode == 1) {
        this.qiz.setVisibility(4);
      }
      if (this.qiC.findViewById(a.f.wallet_tips_msg) != null) {
        this.qiC.findViewById(a.f.wallet_tips_msg).setVisibility(8);
      }
      paramBundle = new WalletLqtSaveFetchUI.1(this);
      this.qiC.setOnClickListener(paramBundle);
      if (findViewById(a.f.change_bankcard_layout) != null) {
        findViewById(a.f.change_bankcard_layout).setOnClickListener(paramBundle);
      }
      if (this.mode == 1)
      {
        paramBundle = i.qfx;
        paramBundle.kn(true);
        paramBundle = paramBundle.qfr;
        if (paramBundle == null) {
          break label1031;
        }
      }
    }
    label1031:
    for (paramBundle = com.tencent.mm.plugin.wallet_core.model.ab.a(paramBundle.tqd);; paramBundle = null)
    {
      this.qiR = paramBundle;
      if (this.qiR == null)
      {
        com.tencent.mm.plugin.wallet.a.p.bTK();
        this.qiR = com.tencent.mm.plugin.wallet.a.p.bTL().qhj;
      }
      if (this.qiR != null)
      {
        paramBundle = getString(a.i.wallet_lqt_balance_remain_wording_1, new Object[] { Double.valueOf(this.qiR.qty) });
        int i = paramBundle.length();
        paramBundle = new SpannableString(paramBundle + getString(a.i.wallet_lqt_balance_remain_wording_2));
        paramBundle.setSpan(new a(new WalletLqtSaveFetchUI.11(this)), i, paramBundle.length(), 18);
        this.qiQ = paramBundle;
        this.qiF.setText(paramBundle);
      }
      this.qiz.setVisibility(0);
      bTw();
      return;
      com.tencent.mm.kernel.g.DQ();
      this.qiW = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyO, ""));
      break;
      label962:
      this.wCm = false;
      a(this.qiA, 2, false, false, false);
      break label489;
      label982:
      if (this.mode != 2) {
        break label535;
      }
      this.qiB.setText(getString(a.i.wallet_lqt_fetch_amount_hint));
      this.qiD.setText(a.i.wallet_lqt_fetch_wording);
      this.qiM.setText(getString(a.i.wallet_lqt_fetch_hint_bank_card_wording));
      break label535;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.qix = null;
    this.qiy = null;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletLqtSaveFetchUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    paramIntent = bTx();
    if (this.mode == 1) {
      this.qiy.qgj.et(this.mode, this.accountType).f(new WalletLqtSaveFetchUI.18(this, paramIntent));
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI
 * JD-Core Version:    0.7.0.1
 */