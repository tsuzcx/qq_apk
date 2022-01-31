package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.fu;
import com.tencent.mm.h.a.fu.a;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.bsb;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.protocal.c.jy;
import com.tencent.mm.protocal.c.ka;
import com.tencent.mm.protocal.c.ke;
import com.tencent.mm.protocal.c.kk;
import com.tencent.mm.protocal.c.yz;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.picker.d.2;
import com.tencent.mm.ui.widget.picker.d.3;
import com.tencent.mm.ui.widget.picker.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RemittanceBusiUI
  extends WalletBaseUI
{
  private int lTG;
  private ScrollView lls;
  private String mKL;
  private boolean nAA;
  private boolean nAD;
  private com.tencent.mm.sdk.b.c nAF = new RemittanceBusiUI.18(this);
  private LinearLayout nAk;
  private String nAt;
  private boolean nAy = false;
  private TextView nBB;
  private TextView nBC;
  private TextView nBD;
  private TextView nBE;
  private TextView nBF;
  private TextView nBG;
  private TextView nBH;
  private View nBI;
  private CdnImageView nBJ;
  private WalletFormView nBK;
  private Button nBL;
  private LinearLayout nBM;
  private LinearLayout nBN;
  private TextView nBO;
  private View nBP;
  private TextView nBQ;
  private String nBR;
  private double nBS;
  private String nBT;
  private String nBU;
  private String nBV;
  private String nBW;
  private String nBX;
  private int nBY;
  private String nBZ;
  private String nBd;
  private String nBe;
  private String nBi;
  private BusiRemittanceResp nBm;
  private boolean nCa;
  private String nCb;
  private int nCc;
  private int nCd;
  private String nCe;
  private bya nCf;
  private String nCg;
  private int nCh = 0;
  private int nCi = 0;
  private int nCj = 0;
  private int nCk = 0;
  private String nCl;
  private a nCm = new a();
  private String nCn = "";
  private String nCo = "";
  boolean nCp = false;
  private double nCq = -1.0D;
  private boolean nCr = false;
  com.tencent.mm.plugin.remittance.model.g nCs = null;
  private RemittanceBusiUI.a nCt;
  private RemittanceBusiUI.a nCu;
  private Runnable nCv = new RemittanceBusiUI.9(this);
  private com.tencent.mm.wallet_core.d.c<com.tencent.mm.plugin.remittance.model.l> nCw = new RemittanceBusiUI.13(this);
  private b nCx = new b();
  private com.tencent.mm.sdk.b.c nCy = new RemittanceBusiUI.19(this);
  private com.tencent.mm.sdk.b.c nCz = new RemittanceBusiUI.20(this);
  private String nzV;
  private int nzY;
  
  private void a(com.tencent.mm.plugin.remittance.model.c paramc, com.tencent.mm.plugin.remittance.model.d paramd, int paramInt)
  {
    long l;
    if (this.nCp)
    {
      this.nBQ.setText(e.A(bwB()));
      ai.S(this.nCv);
      this.nBS = bwB();
      l = Math.round(this.nBS * 100.0D);
      if (l > 0L) {
        break label102;
      }
      this.nCm.bwj();
      this.nBH.setTextColor(-7829368);
      this.nBH.setText(this.nBm.nxN);
      if (this.nCs != null) {
        this.nCs.nye = true;
      }
    }
    return;
    label102:
    int j = (int)l;
    int k = this.lTG;
    int m = this.nBm.nxO;
    String str1 = this.nBW;
    String str2 = this.nzV;
    String str3 = this.nBm.nxP;
    String str4 = this.nAt;
    String str5 = this.nBT;
    String str6 = this.nBm.nxQ;
    if (paramc == null) {}
    for (int i = 0;; i = 1)
    {
      this.nCs = new com.tencent.mm.plugin.remittance.model.g(j, k, m, str1, str2, str3, str4, str5, str6, i, paramc, paramd);
      ai.l(this.nCv, paramInt);
      return;
    }
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean)
    {
      String str = paramIntent.getStringExtra("key_trans_id");
      double d = paramIntent.getDoubleExtra("key_total_fee", -1.0D);
      y.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", new Object[] { str, Double.valueOf(d) });
      if (bk.bl(this.mKL)) {
        this.mKL = str;
      }
      if (d >= 0.0D) {
        this.nCq = d;
      }
      if (this.nAy) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(2) });
      }
      bwE();
      y.i("MicroMsg.RemittanceBusiUI", "do pay check");
      int i = (int)Math.round(this.nBS * 100.0D);
      paramIntent = new co();
      paramIntent.bUR = this.lTG;
      paramIntent.swc = this.nBd;
      paramIntent.swd = this.mKL;
      paramIntent.nxO = this.nBm.nxO;
      paramIntent.scene = this.nzY;
      paramIntent.swe = this.nBi;
      paramIntent.swf = this.nCm.nzH;
      paramIntent.swg = this.nBT;
      paramIntent.nzl = this.nAt;
      paramIntent.swh = i;
      a(new com.tencent.mm.plugin.remittance.model.h(paramIntent, this.nCn), false, false);
      return;
    }
    y.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
    bwD();
  }
  
  private boolean a(com.tencent.mm.plugin.remittance.model.i parami)
  {
    boolean bool;
    if (!this.nAA) {
      if (!bk.bl(parami.nyh.sFa))
      {
        this.nAA = true;
        com.tencent.mm.ui.base.h.a(this, parami.nyh.sFa, getString(a.i.app_remind), getString(a.i.remittance_busi_continue_text), getString(a.i.app_cancel), new RemittanceBusiUI.14(this, parami), new RemittanceBusiUI.15(this));
        bool = true;
      }
    }
    for (;;)
    {
      if (!bool)
      {
        if (parami.nyh.sFb != null)
        {
          this.nAD = true;
          com.tencent.mm.ui.base.h.a(this, parami.nyh.inp, "", parami.nyh.sFb.lRF, parami.nyh.sFb.lRE, new RemittanceBusiUI.16(this, parami), new RemittanceBusiUI.17(this));
          return true;
          bool = false;
        }
        else
        {
          return false;
        }
      }
      else
      {
        return bool;
        bool = false;
      }
    }
  }
  
  private void b(com.tencent.mm.plugin.remittance.model.i parami)
  {
    y.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", new Object[] { Integer.valueOf(parami.nyh.sFf) });
    if (parami.nyh.sFf == 1)
    {
      localObject2 = parami.nyh;
      y.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", new Object[] { Integer.valueOf(((ke)localObject2).sFg) });
      if (((ke)localObject2).sFg == 1)
      {
        parami = new Bundle();
        com.tencent.mm.sdk.b.a.udP.c(this.nCz);
        parami.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
        parami.putString("realname_verify_process_jump_plugin", "remittance");
        parami.putInt("real_name_verify_mode", 0);
        parami.putInt("entry_scene", this.nzY);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, parami);
        return;
      }
      localObject1 = new Intent();
      if (!bk.bl(this.nCl)) {
        parami = this.nCl;
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("INTENT_TITLE", parami);
        ((Intent)localObject1).putExtra("INTENT_CAN_TOUCH", this.nCh);
        ((Intent)localObject1).putExtra("INTENT_PAYFEE", e.A(0.0D));
        parami = ((ke)localObject2).sFh;
        try
        {
          ((Intent)localObject1).putExtra("INTENT_TOKENMESS", parami.toByteArray());
          com.tencent.mm.br.d.b(this.mController.uMN, "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", (Intent)localObject1, 2);
          return;
        }
        catch (Exception parami)
        {
          y.printErrStackTrace("MicroMsg.RemittanceBusiUI", parami, "", new Object[0]);
          return;
        }
        localObject3 = getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
        if (!bk.bl(this.nBT))
        {
          com.tencent.mm.kernel.g.DQ();
          parami = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abj(this.nBT);
          if (parami != null)
          {
            parami = parami.Bq();
            StringBuilder localStringBuilder = new StringBuilder().append(e.afq(parami));
            if (bk.bl(this.nBU)) {}
            for (parami = "";; parami = "(" + this.nBU + ")")
            {
              parami = bk.q((String)localObject3, new Object[] { parami });
              break;
            }
          }
          y.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.nBT);
          parami = "";
        }
        else
        {
          y.e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
          parami = "";
        }
      }
    }
    Object localObject1 = new PayInfo();
    ((PayInfo)localObject1).bMX = parami.nyh.bOT;
    ((PayInfo)localObject1).bUV = this.nzY;
    if (this.lTG > 0) {
      ((PayInfo)localObject1).bUR = this.lTG;
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("extinfo_key_1", this.nBT);
    ((Bundle)localObject2).putString("extinfo_key_2", this.nBU);
    ((Bundle)localObject2).putString("extinfo_key_3", this.nBW);
    ((Bundle)localObject2).putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
    ((Bundle)localObject2).putString("extinfo_key_7", this.nBe);
    ((Bundle)localObject2).putString("extinfo_key_19", parami.nyh.nyX);
    ((PayInfo)localObject1).snX = ((Bundle)localObject2);
    ((PayInfo)localObject1).nzh = 1;
    Object localObject3 = new Intent();
    if (parami.nyh.nyU == 1)
    {
      ((Bundle)localObject2).putInt("extinfo_key_15", parami.nyh.sFo);
      ((Bundle)localObject2).putString("extinfo_key_17", parami.nyh.nyV);
      ((Bundle)localObject2).putString("extinfo_key_18", parami.nyh.nyW);
      ((Intent)localObject3).putExtra("key_pay_info", (Parcelable)localObject1);
      ((Intent)localObject3).putExtra("from_patch_ui", true);
      ((Intent)localObject3).putExtra("key_rcvr_open_id", this.nAt);
      ((Intent)localObject3).putExtra("key_mch_info", this.nBZ);
      ((Intent)localObject3).putExtra("key_mch_photo", this.nBm.nxM);
      ((Intent)localObject3).putExtra("key_transfer_qrcode_id", this.nBR);
      ((Intent)localObject3).putExtra("get_dynamic_code_sign", parami.nyh.nyV);
      ((Intent)localObject3).putExtra("get_dynamic_code_extend", parami.nyh.nyW);
      ((Intent)localObject3).putExtra("dynamic_code_spam_wording", parami.nyh.nyY);
      ((Intent)localObject3).putExtra("dynamic_code_amount", parami.nyh.sFo);
      ((Intent)localObject3).putExtra("show_paying_wording", parami.nyh.nyX);
      if (this.nBm.nxU == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((Intent)localObject3).putExtra("show_avatar_type", bool);
        com.tencent.mm.plugin.report.service.h.nFQ.f(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
        com.tencent.mm.sdk.b.a.udP.b(this.nAF);
        this.nCy.cqo();
        com.tencent.mm.br.d.b(this, "wallet_payu", ".create.ui.WalletPayUVerifyCodeUI", (Intent)localObject3, 3);
        return;
      }
    }
    if (!bk.bl(parami.nyi)) {}
    for (this.nAy = true; (parami.nyj != null) && (parami.nyj.bMR.bMV != null); this.nAy = false)
    {
      com.tencent.mm.pluginsdk.wallet.h.a(parami.nyj.bMR.bMV, false, "", (PayInfo)localObject1, this.nBU, (Intent)localObject3, parami.nyj.bMR.bMT);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", (PayInfo)localObject1, this.nBU, (Intent)localObject3, 1);
  }
  
  private double bwB()
  {
    if ((this.nCa) || (this.nzY == 33)) {
      return this.nBS;
    }
    this.nBS = bk.getDouble(this.nBK.getText(), 0.0D);
    return this.nBS;
  }
  
  private boolean bwC()
  {
    if (this.nBI == null) {}
    while (this.nBm == null) {
      return false;
    }
    y.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
    if ((this.nBm.nxS != null) && (this.nBm.nxS.sEK.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if (this.nBm.nxR.size() > 0) {
        i = 1;
      }
      if (this.nCm.bwk().size() > 0) {
        i = 1;
      }
      if (i == 0)
      {
        this.nBI.setVisibility(8);
        this.nCu.update();
        this.nBP.setVisibility(8);
        return false;
      }
      this.nBP.setVisibility(0);
      this.nCt.update();
      this.nBI.setVisibility(0);
      this.nBH.setText(this.nBm.nxN);
      this.nBH.setTextColor(-7829368);
      this.nBQ.setText(e.A(bwB()));
      Object localObject = this.nCm.nzH;
      if (localObject != null)
      {
        this.nBH.setTextColor(-30434);
        this.nBH.setText(((yz)localObject).nxN);
        this.nBQ.setText(e.A(((yz)localObject).sXN / 100.0D));
      }
      label300:
      for (;;)
      {
        findViewById(a.f.favor_layout_ll).setOnClickListener(new RemittanceBusiUI.2(this));
        return true;
        localObject = this.nCm;
        if (((a)localObject).nzI == null) {}
        for (localObject = "";; localObject = ((a)localObject).nzI.sEN)
        {
          if (bk.bl((String)localObject)) {
            break label300;
          }
          this.nBH.setTextColor(-7829368);
          this.nBH.setText((CharSequence)localObject);
          break;
        }
      }
    }
  }
  
  private void bwD()
  {
    y.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
    yz localyz = this.nCm.nzH;
    if (localyz == null)
    {
      y.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
      return;
    }
    int i = (int)Math.round(this.nBS * 100.0D);
    co localco = new co();
    localco.bUR = this.lTG;
    localco.swc = this.nBd;
    localco.swd = this.mKL;
    localco.nxO = this.nBm.nxO;
    localco.scene = this.nzY;
    localco.swe = this.nBi;
    localco.swf = localyz;
    localco.swg = this.nBT;
    localco.nzl = this.nAt;
    localco.swh = i;
    a(new k(localco, this.nCn), false, false);
  }
  
  private void bwE()
  {
    y.i("MicroMsg.RemittanceBusiUI", "goto busi result");
    Intent localIntent = new Intent(this, RemittanceBusiResultUI.class);
    localIntent.putExtra("key_pay_desc", this.nBe);
    localIntent.putExtra("key_rcv_desc", this.nBW);
    if (this.nBm != null) {
      localIntent.putExtra("BusiRemittanceResp", this.nBm);
    }
    localIntent.putExtra("key_mch_name", this.nzV);
    localIntent.putExtra("key_rcver_name", this.nBT);
    localIntent.putExtra("key_rcver_true_name", this.nBU);
    if (this.nCq >= 0.0D) {
      localIntent.putExtra("key_money", this.nCq);
    }
    for (;;)
    {
      localIntent.putExtra("key_f2f_id", this.nBd);
      localIntent.putExtra("key_trans_id", this.mKL);
      localIntent.putExtra("key_check_sign", this.nBi);
      localIntent.putExtra("key_rcvr_open_id", this.nAt);
      localIntent.putExtra("key_channel", this.lTG);
      if (this.nBm != null)
      {
        localIntent.putExtra("key_succ_show_avatar_type", this.nBm.nxU);
        localIntent.putExtra("key_succ_show_avatar_show", this.nBm.nxL);
        localIntent.putExtra("key_succ_show_avatar_url", this.nBm.nxM);
      }
      if (this.nBm != null) {
        localIntent.putExtra("key_scan_sceen", this.nBm.nxO);
      }
      localIntent.putExtra("key_succ_page_extend", this.nCo);
      yz localyz = this.nCm.nzH;
      int i = (int)Math.round(this.nBS * 100.0D);
      co localco = new co();
      localco.bUR = this.lTG;
      localco.swc = this.nBd;
      localco.swd = this.mKL;
      localco.nxO = this.nBm.nxO;
      localco.scene = this.nzY;
      localco.swe = this.nBi;
      localco.swf = localyz;
      localco.swg = this.nBT;
      localco.nzl = this.nAt;
      localco.swh = i;
      try
      {
        localIntent.putExtra("AfterPlaceOrderCommReq", localco.toByteArray());
        startActivity(localIntent);
        finish();
        return;
        localIntent.putExtra("key_money", this.nBS);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.RemittanceBusiUI", localException, "", new Object[0]);
        }
      }
    }
  }
  
  private void bwF()
  {
    this.nBS = bwB();
    if (this.nBS <= 0.0D)
    {
      findViewById(a.f.favor_layout_ll).setClickable(false);
      findViewById(a.f.favor_layout_ll).setEnabled(false);
      findViewById(a.f.favor_layout_ll).setOnClickListener(null);
      this.nBL.setClickable(false);
      this.nBL.setEnabled(false);
      this.nBH.setTextColor(getResources().getColor(a.c.normal_color));
      return;
    }
    this.nBH.setTextColor(-7829368);
    findViewById(a.f.favor_layout_ll).setEnabled(true);
    findViewById(a.f.favor_layout_ll).setClickable(true);
    this.nBL.setClickable(true);
    this.nBL.setEnabled(true);
    findViewById(a.f.favor_layout_ll).setOnClickListener(new RemittanceBusiUI.21(this));
  }
  
  private void bww()
  {
    ai.d(new RemittanceBusiUI.28(this));
  }
  
  private void cm(final List<za> paramList)
  {
    final com.tencent.mm.ui.widget.picker.d locald = new com.tencent.mm.ui.widget.picker.d(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.nCm.nzH;
    Object localObject1 = new HashSet();
    final HashSet localHashSet = new HashSet();
    if ((this.nCm.bwm()) && (localObject2 != null))
    {
      localObject2 = ((yz)localObject2).sEJ.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(Long.valueOf(((za)((Iterator)localObject2).next()).sXU));
      }
    }
    localObject2 = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      if (((HashSet)localObject1).contains(Long.valueOf(((za)((Iterator)localObject2).next()).sXU))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = getString(a.i.remittance_f2f_favor_select);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      locald.woB.setVisibility(0);
      locald.woC.setText((CharSequence)localObject1);
    }
    locald.woD = localArrayList;
    locald.phH = new RemittanceBusiUI.6(this, paramList, localHashSet);
    locald.phI = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        if (localHashSet.contains(Integer.valueOf(paramAnonymousInt))) {}
        Object localObject1;
        label201:
        do
        {
          do
          {
            return;
          } while (paramAnonymousInt >= paramList.size());
          com.tencent.mm.plugin.report.service.h.nFQ.f(15235, new Object[] { Integer.valueOf(4) });
          localObject1 = (za)paramList.get(paramAnonymousInt);
          paramAnonymousMenuItem = locald;
          boolean bool;
          if (paramAnonymousMenuItem.woE != null)
          {
            paramAnonymousMenuItem = paramAnonymousMenuItem.woE.cKm();
            bool = paramAnonymousMenuItem.contains(Integer.valueOf(paramAnonymousInt));
            if (bool) {
              break label201;
            }
          }
          for (int i = 1;; i = 0)
          {
            localObject2 = new LinkedList();
            paramAnonymousMenuItem = paramAnonymousMenuItem.iterator();
            while (paramAnonymousMenuItem.hasNext())
            {
              int j = ((Integer)paramAnonymousMenuItem.next()).intValue();
              if ((j < paramList.size()) && ((i != 0) || (paramAnonymousInt != j))) {
                ((List)localObject2).add((za)paramList.get(j));
              }
            }
            paramAnonymousMenuItem = new ArrayList();
            break;
          }
          if (i != 0) {
            ((List)localObject2).add(localObject1);
          }
          a locala = RemittanceBusiUI.A(RemittanceBusiUI.this);
          if (i != 0) {}
          for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
          {
            locala.a((List)localObject2, paramAnonymousMenuItem);
            localObject1 = RemittanceBusiUI.A(RemittanceBusiUI.this).nzH;
            paramAnonymousMenuItem = new HashSet();
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((yz)localObject1).sEJ.iterator();
            while (((Iterator)localObject1).hasNext()) {
              paramAnonymousMenuItem.add(Long.valueOf(((za)((Iterator)localObject1).next()).sXU));
            }
          }
          localObject1 = new HashMap();
          Object localObject2 = paramList.iterator();
          i = 0;
          if (((Iterator)localObject2).hasNext())
          {
            if (paramAnonymousMenuItem.contains(Long.valueOf(((za)((Iterator)localObject2).next()).sXU))) {
              ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.valueOf(true));
            }
            for (;;)
            {
              if (i == paramAnonymousInt) {
                ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.valueOf(bool));
              }
              i += 1;
              break;
              ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.valueOf(false));
            }
          }
          paramAnonymousMenuItem = locald;
        } while (paramAnonymousMenuItem.woE == null);
        paramAnonymousMenuItem.woE.woH = ((HashMap)localObject1);
        paramAnonymousMenuItem.woE.notifyDataSetChanged();
      }
    };
    locald.woF = new RemittanceBusiUI.8(this);
    if (locald.phH != null) {
      locald.phH.a(locald.phJ);
    }
    locald.woE = new d.a(locald, locald.mContext);
    locald.woE.cKl();
    locald.woA.setAdapter(locald.woE);
    locald.fbO.setOnClickListener(new d.2(locald));
    locald.hPe.setOnClickListener(new d.3(locald));
    if (locald.vAB != null)
    {
      if ((locald.phJ != null) && (locald.phJ.size() > 3))
      {
        paramList = (FrameLayout.LayoutParams)locald.jdj.getLayoutParams();
        paramList.height = locald.vAC;
        locald.jdj.setLayoutParams(paramList);
      }
      locald.vAB.show();
    }
  }
  
  private void is(boolean paramBoolean)
  {
    y.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject2 = this.nCm.nzH;
    int i = (int)Math.round(this.nBS * 100.0D);
    Object localObject1 = new co();
    ((co)localObject1).bUR = this.lTG;
    ((co)localObject1).swc = this.nBd;
    ((co)localObject1).swd = this.mKL;
    ((co)localObject1).nxO = this.nBm.nxO;
    ((co)localObject1).scene = this.nzY;
    ((co)localObject1).swe = this.nBi;
    ((co)localObject1).swf = ((yz)localObject2);
    ((co)localObject1).swg = this.nBT;
    ((co)localObject1).nzl = this.nAt;
    ((co)localObject1).swh = i;
    localObject2 = this.nCf;
    String str = this.nCe;
    if (paramBoolean) {}
    for (i = 1;; i = 0)
    {
      localObject1 = new com.tencent.mm.plugin.remittance.model.l((bya)localObject2, (co)localObject1, str, i, this.nCg);
      if (!paramBoolean) {
        break;
      }
      ((com.tencent.mm.plugin.remittance.model.l)localObject1).nyn = true;
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a((m)localObject1, 0);
      return;
    }
    this.nCk = 0;
    a((m)localObject1, true, false);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = true;
    if ((paramm instanceof com.tencent.mm.plugin.remittance.model.i))
    {
      paramString = (com.tencent.mm.plugin.remittance.model.i)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramString.nyh.ino == 0)
        {
          this.nBd = paramString.nyh.swc;
          this.mKL = paramString.nyh.swd;
          this.nBi = paramString.nyh.swe;
          this.nCn = paramString.nyh.sFd;
          this.nCo = paramString.nyh.sFc;
          this.nCe = paramString.nyh.sFi;
          this.nCf = paramString.nyh.sFh;
          this.nCh = paramString.nyh.sFl;
          this.nCi = paramString.nyh.sFj;
          this.nCj = paramString.nyh.sFk;
          y.i("MicroMsg.RemittanceBusiUI", "touch_challenge %s need_change_auth_key %s", new Object[] { paramString.nyh.sFm, Integer.valueOf(paramString.nyh.sFn) });
          if (paramString.nyh.sFm != null) {
            com.tencent.mm.plugin.wallet_core.model.s.qyz.klM = paramString.nyh.sFm.coM();
          }
          paramm = com.tencent.mm.plugin.wallet_core.model.s.qyz;
          if (paramString.nyh.sFn == 1)
          {
            paramm.klN = bool;
            if (!a(paramString)) {
              b(paramString);
            }
          }
        }
      }
    }
    for (;;)
    {
      return false;
      bool = false;
      break;
      y.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", new Object[] { Integer.valueOf(paramString.nyh.ino), paramString.nyh.inp });
      if ((paramString.nyh.sFb != null) && (!bk.bl(paramString.nyh.sFb.lRE))) {
        a(paramString);
      }
      for (;;)
      {
        if (paramString.nyh.sFe != 1) {
          break label354;
        }
        a(null, null, 0);
        break;
        Toast.makeText(this, paramString.nyh.inp, 1).show();
      }
      label354:
      continue;
      y.e("MicroMsg.RemittanceBusiUI", "net error: %s", new Object[] { paramm });
      continue;
      if ((paramm instanceof com.tencent.mm.plugin.remittance.model.h))
      {
        y.i("MicroMsg.RemittanceBusiUI", "pay check callback");
        return true;
      }
      if ((paramm instanceof com.tencent.mm.plugin.remittance.model.g))
      {
        y.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", new Object[] { paramm, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (com.tencent.mm.plugin.remittance.model.g)paramm;
        if ((!paramString.nyd.equals(this.nCs.nyd)) || (paramString.nye))
        {
          paramString.nyc = true;
          y.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", new Object[] { Boolean.valueOf(paramString.nye) });
          return true;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramString.nxZ.ino == 0)
          {
            this.nCm.nzI = paramString.nxZ.nxS;
            this.nCm.LP(paramString.nxZ.nxS.sEL);
            bwC();
            paramm = paramString.nya;
            y.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", new Object[] { paramm });
            if (paramm != null) {
              paramm.cl(this.nCm.bwk());
            }
          }
        }
        for (;;)
        {
          paramString.nyc = true;
          return true;
          this.nCm.bwj();
          this.nBH.setTextColor(-7829368);
          this.nBH.setText(paramString.nxZ.inp);
          paramm = paramString.nyb;
          if (paramm != null)
          {
            paramm.a(paramInt1, paramInt2, paramString);
            continue;
            this.nCm.bwj();
            if ((this.nBm != null) && (!bk.bl(this.nBm.nxN))) {
              this.nBH.setText(this.nBm.nxN);
            }
            this.nBH.setTextColor(-7829368);
            this.nBH.setText(getString(a.i.remittance_busi_favor_get_error_default));
            paramm = paramString.nyb;
            if (paramm != null) {
              paramm.a(paramInt1, paramInt2, paramString);
            }
          }
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.remittance.model.l))
      {
        paramString = (com.tencent.mm.plugin.remittance.model.l)paramm;
        y.i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", new Object[] { Boolean.valueOf(paramString.nyn) });
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramString.nym.ino == 0)
          {
            bwE();
          }
          else
          {
            bwD();
            com.tencent.mm.ui.base.h.a(this, paramString.nym.inp, null, false, new RemittanceBusiUI.10(this));
          }
        }
        else {
          com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_unknown_err), null, false, new RemittanceBusiUI.11(this));
        }
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.remittance_busi_ui;
  }
  
  protected final void initView()
  {
    this.lls = ((ScrollView)findViewById(a.f.root_view));
    this.nBB = ((TextView)findViewById(a.f.remittance_busi_name));
    this.nBC = ((TextView)findViewById(a.f.remittance_busi_nick_name));
    this.nBD = ((TextView)findViewById(a.f.remittance_busi_fixed_title));
    this.nBE = ((TextView)findViewById(a.f.remittance_busi_fixed_money));
    this.nBF = ((TextView)findViewById(a.f.remittance_busi_desc));
    this.nBG = ((TextView)findViewById(a.f.remittance_busi_add_desc));
    this.nBJ = ((CdnImageView)findViewById(a.f.remittance_busi_logo));
    this.nBK = ((WalletFormView)findViewById(a.f.remittance_busi_money_et));
    this.nBL = ((Button)findViewById(a.f.remittance_busi_pay_btn));
    this.nBM = ((LinearLayout)findViewById(a.f.remittance_busi_fixed_money_layout));
    this.nAk = ((LinearLayout)findViewById(a.f.remittance_busi_edit_money_layout));
    this.nBN = ((LinearLayout)findViewById(a.f.remittance_busi_desc_container));
    this.nBH = ((TextView)findViewById(a.f.favor_title_desc));
    this.nBI = findViewById(a.f.remittance_busi_favor_layout);
    this.nBO = ((TextView)findViewById(a.f.remittance_busi_fixed_currency));
    this.nBP = findViewById(a.f.final_remittance_layout);
    this.nBQ = ((TextView)findViewById(a.f.final_remittance_busi_fixed_money));
    if (this.nCa)
    {
      if (!bk.bl(this.nBW)) {
        this.nBD.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this, this.nBW, this.nBD.getTextSize()));
      }
      this.nBE.setText(e.A(this.nBS));
      this.nBM.setVisibility(0);
      this.nAk.setVisibility(8);
      if (com.tencent.mm.kernel.g.DK())
      {
        com.tencent.mm.kernel.g.DQ();
        ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.nBT);
        if ((localad == null) || ((int)localad.dBe == 0)) {
          am.a.dVy.a(this.nBT, "", new RemittanceBusiUI.23(this));
        }
      }
      bww();
      this.nBN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (!RemittanceBusiUI.k(RemittanceBusiUI.this)) {
            RemittanceBusiUI.this.VH();
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(15235, new Object[] { Integer.valueOf(6) });
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBusiUI.this, RemittanceBusiUI.this.getString(a.i.remittance_busi_add_desc), RemittanceBusiUI.l(RemittanceBusiUI.this), RemittanceBusiUI.this.getString(a.i.remittance_busi_desc_max_words_count_tip), 20, new RemittanceBusiUI.24.1(this), new RemittanceBusiUI.24.2(this));
        }
      });
      this.nBL.setOnClickListener(new RemittanceBusiUI.25(this));
      this.lls.setOnTouchListener(new RemittanceBusiUI.26(this));
      this.lTH = new RemittanceBusiUI.27(this);
      if ((this.nBm != null) && (this.nBm.nxS != null))
      {
        this.nCm.nzI = this.nBm.nxS;
        this.nCm.LP(this.nBm.nxS.sEL);
      }
      if (bwC()) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(15235, new Object[] { Integer.valueOf(2) });
      }
      return;
    }
    boolean bool;
    if (this.nBm != null) {
      if (this.nBm.nxR.size() > 0)
      {
        bool = false;
        label545:
        if ((this.nBm.nxS != null) && (this.nBm.nxS.sEJ.size() > 0)) {
          bool = false;
        }
      }
    }
    for (;;)
    {
      a(this.nBK, 2, false, bool, true);
      this.nBK.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          if (paramAnonymousEditable.toString().startsWith(".")) {
            paramAnonymousEditable.insert(0, "0");
          }
          String str = paramAnonymousEditable.toString();
          int i = str.indexOf(".");
          int j = str.length();
          if ((i >= 0) && (j - i > 2)) {
            paramAnonymousEditable.delete(i + 3, j);
          }
          RemittanceBusiUI.g(RemittanceBusiUI.this);
          if (RemittanceBusiUI.h(RemittanceBusiUI.this) == 32)
          {
            paramAnonymousEditable = RemittanceBusiUI.this;
            if (RemittanceBusiUI.i(RemittanceBusiUI.this) != null) {
              break label109;
            }
          }
          label109:
          for (i = 400;; i = RemittanceBusiUI.i(RemittanceBusiUI.this).nxV)
          {
            RemittanceBusiUI.a(paramAnonymousEditable, null, i);
            return;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.nBM.setVisibility(8);
      this.nAk.setVisibility(0);
      break;
      continue;
      bool = true;
      break label545;
      bool = true;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    y.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    if (paramInt1 == 3) {
      if (paramInt2 == -1) {
        a(bool1, paramIntent);
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      bool1 = false;
      break;
      if (paramInt1 == 1)
      {
        if (paramInt2 == -1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(bool1, paramIntent);
          break;
        }
      }
      if (paramInt1 == 2) {
        if (paramInt2 == -1)
        {
          String str = paramIntent.getStringExtra("INTENT_RESULT_TOKEN");
          this.nCg = str;
          this.nCq = 0.0D;
          y.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", new Object[] { str });
          is(false);
        }
        else
        {
          bwD();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.nFQ.f(15235, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.remittance_busi_common_bg)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.findViewById(16908308);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(a.c.black));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(a.c.remittance_busi_common_bg));
    }
    boolean bool;
    if (com.tencent.mm.compatible.util.d.gF(21))
    {
      if (com.tencent.mm.compatible.util.d.gF(23)) {
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      setBackBtn(new RemittanceBusiUI.12(this), a.h.actionbar_icon_dark_back);
      kh(1633);
      kh(1241);
      kh(2677);
      kh(2504);
      kh(2702);
      kh(2682);
      paramBundle = this.nCw;
      com.tencent.mm.wallet_core.d.i locali = this.wCh;
      paramBundle.rtType = 2682;
      paramBundle.wBb = locali;
      locali.wBh.put(Integer.valueOf(2682), paramBundle);
      setMMTitle(a.i.remittance_busi_pay);
      setBackBtn(new RemittanceBusiUI.1(this));
      this.nzY = getIntent().getIntExtra("pay_scene", 31);
      this.nBR = getIntent().getStringExtra("scan_remittance_id");
      this.nBS = getIntent().getDoubleExtra("fee", 0.0D);
      this.nBT = getIntent().getStringExtra("receiver_name");
      this.nBU = getIntent().getStringExtra("receiver_true_name");
      this.nBV = getIntent().getStringExtra("receiver_true_name_busi");
      this.lTG = getIntent().getIntExtra("pay_channel", 0);
      this.nBW = getIntent().getStringExtra("desc");
      this.nBY = getIntent().getIntExtra("busi_type", 0);
      this.nzV = getIntent().getStringExtra("mch_name");
      this.nCb = getIntent().getStringExtra("mch_type");
      this.nCd = getIntent().getIntExtra("mch_time", 0);
      this.nBZ = getIntent().getStringExtra("mch_info");
      this.nCc = getIntent().getIntExtra("get_pay_wifi", 0);
      this.nAt = getIntent().getStringExtra("rcvr_open_id");
      this.nBX = getIntent().getStringExtra("rcvr_ticket");
      this.nCl = getIntent().getStringExtra("receiver_tips");
      this.nBm = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
      if (this.nBm != null)
      {
        if ((this.nzY != 32) || ((this.nBm.nxT != 1) && ((this.nBm == null) || (this.nBm.nxR.size() <= 0)))) {
          break label712;
        }
        bool = true;
        label586:
        this.nCp = bool;
      }
      if (this.nBS <= 0.0D) {
        break label717;
      }
    }
    label712:
    label717:
    for (this.nCa = true;; this.nCa = false)
    {
      if (this.nBY == 0)
      {
        y.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
        finish();
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      this.nCt = new RemittanceBusiUI.a(this, 28, 28, 2.0F);
      this.nCu = new RemittanceBusiUI.a(this, 50, 50, 8.0F);
      initView();
      bwF();
      return;
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
      break;
      bool = false;
      break label586;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.udP.d(this.nAF);
    com.tencent.mm.sdk.b.a.udP.d(this.nCz);
    this.nCy.dead();
    ki(1633);
    ki(1241);
    ki(2677);
    ki(2504);
    ki(2702);
    ki(2682);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.v("MicroMsg.RemittanceBusiUI", "onNewIntent");
  }
  
  final class b
    implements Runnable
  {
    public com.tencent.mm.wallet_core.d.d nCO;
    
    b() {}
    
    public final void run()
    {
      com.tencent.mm.wallet_core.d.c localc = RemittanceBusiUI.E(RemittanceBusiUI.this);
      com.tencent.mm.wallet_core.d.d locald = this.nCO;
      y.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", new Object[] { Integer.valueOf(localc.rtType) });
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(localc.rtType, localc);
      localc.a(locald);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI
 * JD-Core Version:    0.7.0.1
 */