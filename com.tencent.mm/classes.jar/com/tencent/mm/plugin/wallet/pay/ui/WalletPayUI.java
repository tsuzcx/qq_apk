package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.g.a.yu;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.a.yv.a;
import com.tencent.mm.g.a.zd;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.plugin.wallet_core.ui.n.b;
import com.tencent.mm.plugin.wallet_core.ui.s.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletPayUI
  extends WalletBaseUI
  implements a.a
{
  private static boolean Dbb;
  private static List<b> Dbc;
  protected ArrayList<Bankcard> CQh;
  protected Bankcard CQi;
  private com.tencent.mm.plugin.wallet.pay.a.d Daf;
  public FavorPayInfo Dar;
  private a Das;
  com.tencent.mm.plugin.wallet_core.ui.f Dat;
  private boolean Dau;
  private TextView DbA;
  private LinearLayout DbB;
  private boolean DbC;
  private boolean DbD;
  private boolean DbE;
  private boolean DbF;
  private boolean DbG;
  private int DbH;
  private boolean DbI;
  private boolean DbJ;
  private com.tencent.mm.plugin.wallet.pay.a.c.f DbK;
  private boolean DbL;
  private boolean DbM;
  private int DbN;
  private Runnable DbO;
  private b DbP;
  private long DbQ;
  private com.tencent.mm.plugin.wallet.pay.a.c.f Dbd;
  protected com.tencent.mm.plugin.wallet_core.ui.d Dbe;
  private boolean Dbf;
  protected boolean Dbg;
  private d.a Dbh;
  protected boolean Dbi;
  protected String Dbj;
  protected boolean Dbk;
  public Bundle Dbl;
  protected boolean Dbm;
  protected TextView Dbn;
  protected TextView Dbo;
  private TextView Dbp;
  protected TextView Dbq;
  protected TextView Dbr;
  protected TextView Dbs;
  protected ImageView Dbt;
  private TextView Dbu;
  private TextView Dbv;
  protected LinearLayout Dbw;
  protected a Dbx;
  public Dialog Dby;
  private long Dbz;
  public String TAG;
  private boolean isPaySuccess;
  public String jth;
  protected int mCount;
  protected PayInfo mPayInfo;
  protected com.tencent.mm.plugin.wallet.a ypV;
  private String yqw;
  private com.tencent.mm.sdk.b.c ytq;
  protected Orders yvS;
  protected Button yvk;
  
  static
  {
    AppMethodBeat.i(69482);
    Dbb = false;
    Dbc = new ArrayList();
    AppMethodBeat.o(69482);
  }
  
  public WalletPayUI()
  {
    AppMethodBeat.i(69427);
    this.TAG = "MicroMsg.WalletPayUI";
    this.yvS = null;
    this.Dbd = null;
    this.mCount = 0;
    this.jth = null;
    this.CQh = null;
    this.CQi = null;
    this.Dar = null;
    this.Dbe = null;
    this.Dbf = false;
    this.isPaySuccess = false;
    this.Dbg = false;
    this.Dbi = false;
    this.Dbj = "";
    this.mPayInfo = null;
    this.Dbk = false;
    this.Dbl = null;
    this.Dbm = false;
    this.Dbz = 0L;
    this.DbC = true;
    this.DbD = false;
    this.DbE = false;
    this.DbF = false;
    this.DbG = false;
    this.DbH = -1;
    this.DbI = false;
    this.DbJ = false;
    this.ypV = null;
    this.DbL = false;
    this.DbM = false;
    this.Daf = null;
    this.DbN = 0;
    this.DbO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69386);
        ae.i(WalletPayUI.this.TAG, "auto reset create flag");
        WalletPayUI.JG();
        AppMethodBeat.o(69386);
      }
    };
    this.DbQ = 0L;
    this.ytq = new com.tencent.mm.sdk.b.c() {};
    this.Dau = false;
    AppMethodBeat.o(69427);
  }
  
  private void VW(int paramInt)
  {
    AppMethodBeat.i(69428);
    this.DbN = paramInt;
    ae.i(this.TAG, "markForceFinish errorType %s %s", new Object[] { Integer.valueOf(paramInt), bu.fpN().toString() });
    AppMethodBeat.o(69428);
  }
  
  private void a(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    AppMethodBeat.i(69456);
    ae.i(this.TAG, "stopRealname realnameGuideFlag %s guide_type %s", new Object[] { paramf.dOi, Integer.valueOf(paramf.Dae) });
    label109:
    Object localObject;
    label150:
    int j;
    if (("1".equals(paramf.dOi)) || ("2".equals(paramf.dOi)))
    {
      this.DbK = paramf;
      this.Daf = paramf.Daf;
      this.DbI = true;
      this.yvS = paramf.yvS;
      if (this.yvS == null) {
        break label523;
      }
      i = this.yvS.DpP.size();
      this.mCount = i;
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("get mOrders! bankcardTag : ");
      if (this.yvS == null) {
        break label528;
      }
      paramf = Integer.valueOf(this.yvS.DgN);
      ae.d((String)localObject, paramf);
      aVv();
      if ((this.yvS != null) && (this.yvS.DpQ != null))
      {
        this.Dbe = com.tencent.mm.plugin.wallet_core.ui.e.DtH.a(this.yvS);
        if (this.Dbe != null)
        {
          if (this.Dbe.eKU().size() > 0) {
            this.Dbf = true;
          }
          this.Dar = this.Dbe.aGl(this.yvS.DpQ.CYF);
          this.Dar.Doq = this.Dbe.aGm(this.Dar.Doq);
          ae.i(this.TAG, "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", new Object[] { this.yvS.DpQ.CYF, this.Dar.Doq, this.Dar.Doq, this.Dar.toString() });
        }
      }
      if ((this.yvS != null) && (this.CQh != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.yvS);
        paramf = com.tencent.mm.plugin.report.service.g.yxI;
        j = this.mPayInfo.dDH;
        com.tencent.mm.plugin.wallet.a.s.eGW();
        if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJH()) {
          break label534;
        }
      }
    }
    label523:
    label528:
    label534:
    for (int i = 2;; i = 1)
    {
      paramf.f(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.yvS.dmz * 100.0D)), this.yvS.wSq });
      if ((this.yvS == null) || (this.yvS.DpP == null)) {
        break label598;
      }
      paramf = new LinkedList();
      localObject = this.yvS.DpP.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramf.add(((Orders.Commodity)((Iterator)localObject).next()).dmx);
      }
      this.DbK = null;
      break;
      i = 0;
      break label109;
      paramf = "";
      break label150;
    }
    if (paramf.size() > 0)
    {
      localObject = new yu();
      ((yu)localObject).dOK.dOM = paramf;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.ypV != null) {
        this.ypV.cp(10001, (String)paramf.get(0));
      }
    }
    label598:
    if ((this.yvS != null) && (this.yvS.Dqn != null) && (this.yvS.Dqn.Drk == 1) && (!bu.isNullOrNil(this.yvS.Dqn.wRt)))
    {
      this.Dbi = true;
      this.Dbj = this.yvS.Dqn.wRt;
    }
    com.tencent.mm.plugin.wallet.a.s.eGW();
    this.CQh = com.tencent.mm.plugin.wallet.a.s.eGX().uw(eHB());
    if (!bu.isNullOrNil(this.Dbj))
    {
      this.CQi = eHy();
      paramf = bu.bI(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!bu.isNullOrNil(paramf)) {
        this.CQi = aFA(paramf);
      }
      this.yvk.setClickable(true);
      if (bu.isNullOrNil(t.eJf().DsM)) {
        break label1031;
      }
      this.Dbu.setVisibility(0);
      this.Dbu.setText(t.eJf().DsM);
      label773:
      if ((this.yvS != null) && (this.CQh != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.yvS);
        paramf = com.tencent.mm.plugin.report.service.g.yxI;
        j = this.mPayInfo.dDH;
        com.tencent.mm.plugin.wallet.a.s.eGW();
        if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJH()) {
          break label1052;
        }
        i = 2;
        label832:
        paramf.f(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.yvS.dmz * 100.0D)), this.yvS.wSq });
      }
      if (this.DbD) {
        aW(0, false);
      }
      if (getPayInfo().hwN != null) {
        break label1057;
      }
    }
    label1031:
    label1052:
    label1057:
    for (long l = 0L;; l = getPayInfo().hwN.getLong("wallet_pay_key_check_time"))
    {
      if (l > 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(641L, 4L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(641L, 5L, bu.DD(l), true);
      }
      if (this.DbQ > 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(641L, 7L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(641L, 8L, bu.DD(this.DbQ), true);
      }
      AppMethodBeat.o(69456);
      return;
      com.tencent.mm.plugin.wallet.a.s.eGW();
      this.CQi = com.tencent.mm.plugin.wallet.a.s.eGX().a(null, null, eHB(), false);
      break;
      this.Dbu.setVisibility(8);
      this.Dbu.setText("");
      break label773;
      i = 1;
      break label832;
    }
  }
  
  private Bankcard aFA(String paramString)
  {
    AppMethodBeat.i(69461);
    com.tencent.mm.plugin.wallet.a.s.eGW();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.eGX().uv(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (bu.nullAsNil(paramString).equals(localBankcard.field_bindSerial))
        {
          ae.i(this.TAG, "hy: get given bankcard");
          AppMethodBeat.o(69461);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(69461);
    return null;
  }
  
  private boolean b(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    int i = 0;
    AppMethodBeat.i(69474);
    boolean bool;
    if ("1".equals(paramf.dOi))
    {
      ae.i(this.TAG, "need realname verify");
      this.DbF = true;
      paramf = new Bundle();
      paramf.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
      paramf.putString("realname_verify_process_jump_plugin", "wallet");
      isTransparent();
      if (this.mPayInfo != null) {
        i = this.mPayInfo.dDH;
      }
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf, null, i);
      AppMethodBeat.o(69474);
      return bool;
    }
    if ("2".equals(paramf.dOi))
    {
      ae.i(this.TAG, "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf.dOj, paramf.dOm, paramf.dOk, paramf.dOl, isTransparent(), null);
      AppMethodBeat.o(69474);
      return bool;
    }
    ae.i(this.TAG, "realnameGuideFlag =  " + paramf.dOi);
    AppMethodBeat.o(69474);
    return false;
  }
  
  private boolean eHA()
  {
    AppMethodBeat.i(69468);
    if ((this.yvS != null) && (this.yvS.DpG))
    {
      com.tencent.mm.kernel.g.ajS();
      if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(196614, Boolean.TRUE)).booleanValue())
      {
        Object localObject = getLayoutInflater().inflate(2131496007, null);
        CheckBox localCheckBox = (CheckBox)((View)localObject).findViewById(2131305890);
        fI((View)localObject);
        ((TextView)((View)localObject).findViewById(2131305896)).setOnClickListener(new WalletPayUI.21(this, localCheckBox));
        localObject = com.tencent.mm.ui.base.h.a(this, getString(2131765703), (View)localObject, getString(2131765184), getString(2131765799), new WalletPayUI.22(this, localCheckBox), new WalletPayUI.24(this));
        ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
        localCheckBox.setOnCheckedChangeListener(new WalletPayUI.25(this, (com.tencent.mm.ui.widget.a.d)localObject));
        AppMethodBeat.o(69468);
        return false;
      }
    }
    AppMethodBeat.o(69468);
    return true;
  }
  
  private boolean eHa()
  {
    AppMethodBeat.i(69449);
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXa, Integer.valueOf(0))).intValue();
    if ((com.tencent.mm.sdk.a.b.fnF()) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE)) {
      i = 1;
    }
    if ((i == 1) || ((this.yvS != null) && (this.yvS.Dqm == 1)))
    {
      AppMethodBeat.o(69449);
      return true;
    }
    AppMethodBeat.o(69449);
    return false;
  }
  
  private boolean eHn()
  {
    AppMethodBeat.i(69430);
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("intent_pay_end")))
    {
      ae.i(this.TAG, "hy: pay end. finish the activity");
      if (localBundle.getBoolean("intent_pay_end", false))
      {
        ae.d(this.TAG, "pay done... errCode:" + localBundle.getInt("intent_pay_end_errcode"));
        ae.d(this.TAG, "pay done INTENT_PAY_APP_URL:" + localBundle.getString("intent_pay_app_url"));
        ae.d(this.TAG, "pay done INTENT_PAY_END:" + localBundle.getBoolean("intent_pay_end", false));
        m(-1, getIntent());
      }
      for (this.isPaySuccess = true;; this.isPaySuccess = false)
      {
        AppMethodBeat.o(69430);
        return true;
        ae.d(this.TAG, "pay cancel");
        m(0, getIntent());
      }
    }
    if ((localBundle != null) && (localBundle.getBoolean("key_is_realname_verify_process")))
    {
      switch (localBundle.getInt("realname_verify_process_ret", 0))
      {
      default: 
        AppMethodBeat.o(69430);
        return false;
      }
      AppMethodBeat.o(69430);
      return true;
    }
    ae.i(this.TAG, "hy: pay not end");
    AppMethodBeat.o(69430);
    return false;
  }
  
  private void eHp()
  {
    AppMethodBeat.i(69440);
    if (this.yvS == null)
    {
      ae.e(this.TAG, "updatePaymentMethodForFavor mOrders is null");
      AppMethodBeat.o(69440);
      return;
    }
    this.Dbs.setVisibility(8);
    this.Dbr.setVisibility(8);
    this.yvk.setText(2131765657);
    this.DbA.setVisibility(0);
    this.DbB.setVisibility(0);
    View localView = this.DbB.findViewById(2131297100);
    Object localObject = this.DbB.findViewById(2131296454);
    final CheckedTextView localCheckedTextView1;
    final CheckedTextView localCheckedTextView2;
    int i;
    if ("CFT".equals(this.yvS.DpK))
    {
      ((View)localObject).setVisibility(8);
      localCheckedTextView1 = (CheckedTextView)this.DbB.findViewById(2131297092);
      localCheckedTextView2 = (CheckedTextView)this.DbB.findViewById(2131296453);
      localView.setEnabled(true);
      if ((this.yvS == null) || (this.yvS.DpP == null) || (this.yvS.DpP.size() <= 0)) {
        break label772;
      }
      if (this.yvS.Dpz != 1) {
        break label574;
      }
      i = 1;
    }
    label772:
    for (;;)
    {
      label200:
      if (this.CQi == null)
      {
        localView.setVisibility(8);
        label213:
        ((View)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69425);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            localCheckedTextView1.setChecked(false);
            localCheckedTextView2.setChecked(true);
            WalletPayUI.a(WalletPayUI.this, true);
            WalletPayUI.e(WalletPayUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69425);
          }
        });
        this.DbA.setVisibility(0);
        this.DbB.setVisibility(0);
        if (this.Dar == null) {
          break label767;
        }
        this.Dbe = com.tencent.mm.plugin.wallet_core.ui.e.DtH.a(this.yvS);
        localObject = this.Dbe.aGi(this.Dar.Doq);
        if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).CYE != 0.0D)) {
          break label767;
        }
        this.DbB.setVisibility(8);
        this.DbA.setVisibility(8);
      }
      label486:
      label767:
      for (int j = 1;; j = 0)
      {
        this.DbC = true;
        if (j != 0) {
          this.DbC = false;
        }
        localCheckedTextView1.setChecked(false);
        localCheckedTextView2.setChecked(true);
        ae.i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.yvS.DpR);
        if (this.yvS.DpR == 1)
        {
          this.DbB.findViewById(2131299147).setVisibility(0);
          ((TextView)this.DbB.findViewById(2131299146)).setText(this.yvS.DpS);
          if (!TextUtils.isEmpty(this.yvS.DpT))
          {
            ((TextView)this.DbB.findViewById(2131299862)).setText(" (" + this.yvS.DpT + ")");
            if ((this.CQi != null) && (this.CQi.eIy()) && (!TextUtils.isEmpty(this.CQi.field_forbidWord)))
            {
              localView.setEnabled(false);
              localCheckedTextView1.setVisibility(8);
              ((TextView)this.DbB.findViewById(2131297107)).setText(this.CQi.field_forbidWord);
            }
          }
        }
        for (;;)
        {
          eHq();
          AppMethodBeat.o(69440);
          return;
          ((View)localObject).setVisibility(0);
          break;
          i = 0;
          break label200;
          localView.setVisibility(0);
          localView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(69424);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              localCheckedTextView1.setChecked(true);
              localCheckedTextView2.setChecked(false);
              WalletPayUI.a(WalletPayUI.this, false);
              WalletPayUI.e(WalletPayUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69424);
            }
          });
          break label213;
          ((TextView)this.DbB.findViewById(2131299862)).setText("");
          break label486;
          this.DbB.findViewById(2131299147).setVisibility(8);
          if ((this.CQi != null) && (this.CQi.eIy()) && (!TextUtils.isEmpty(this.CQi.field_forbidWord)))
          {
            localView.setEnabled(false);
            localCheckedTextView1.setVisibility(8);
            ((TextView)this.DbB.findViewById(2131297107)).setText(this.CQi.field_forbidWord);
          }
          else if ((this.CQi != null) && (this.CQi.eIy()) && (TextUtils.isEmpty(this.CQi.field_forbidWord)) && (i == 0))
          {
            localCheckedTextView1.setChecked(true);
            localCheckedTextView2.setChecked(false);
            this.DbC = false;
          }
        }
      }
      label574:
      i = 0;
    }
  }
  
  private void eHq()
  {
    AppMethodBeat.i(69441);
    if (this.DbC)
    {
      this.yvk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int j = 0;
          AppMethodBeat.i(69387);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.plugin.wallet.a.s.eGW();
          int i;
          if (com.tencent.mm.plugin.wallet.a.s.eGX().eJI())
          {
            if (WalletPayUI.this.mPayInfo == null)
            {
              i = 0;
              if (WalletPayUI.this.mPayInfo != null) {
                break label185;
              }
              paramAnonymousView = "";
              label77:
              af.f(i, paramAnonymousView, 6, "");
            }
          }
          else
          {
            if (WalletPayUI.this.yvS.DpR != 1) {
              break label227;
            }
            com.tencent.mm.plugin.wallet.a.s.eGW();
            if (com.tencent.mm.plugin.wallet.a.s.eGX().eJI())
            {
              if (WalletPayUI.this.mPayInfo != null) {
                break label199;
              }
              i = j;
              label125:
              if (WalletPayUI.this.mPayInfo != null) {
                break label213;
              }
            }
          }
          label185:
          label199:
          label213:
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dmw)
          {
            af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.f(WalletPayUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69387);
            return;
            i = WalletPayUI.this.mPayInfo.dDH;
            break;
            paramAnonymousView = WalletPayUI.this.mPayInfo.dmw;
            break label77;
            i = WalletPayUI.this.mPayInfo.dDH;
            break label125;
          }
          label227:
          ae.i(WalletPayUI.this.TAG, "SimpleReg , assigned userinfo pay! payWithNewBankcard");
          com.tencent.mm.plugin.wallet.a.s.eGW();
          if (com.tencent.mm.plugin.wallet.a.s.eGX().eJI())
          {
            if (WalletPayUI.this.mPayInfo != null) {
              break label299;
            }
            i = 0;
            label264:
            if (WalletPayUI.this.mPayInfo != null) {
              break label313;
            }
          }
          label299:
          label313:
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dmw)
          {
            af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.this.c(false, 0, "");
            break;
            i = WalletPayUI.this.mPayInfo.dDH;
            break label264;
          }
        }
      });
      AppMethodBeat.o(69441);
      return;
    }
    this.yvk.setOnClickListener(new WalletPayUI.3(this));
    AppMethodBeat.o(69441);
  }
  
  private void eHv()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(69447);
    com.tencent.mm.plugin.report.service.g.yxI.f(13958, new Object[] { Integer.valueOf(1) });
    if ((this.mPayInfo != null) && (8 == this.mPayInfo.dDH))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(13955, new Object[] { Integer.valueOf(2) });
      if (this.mPayInfo.hwN != null)
      {
        long l = this.mPayInfo.hwN.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.g.yxI.f(13956, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    Object localObject;
    if (this.Dar != null)
    {
      this.Dbe = com.tencent.mm.plugin.wallet_core.ui.e.DtH.a(this.yvS);
      localObject = this.Dbe.aGi(this.Dar.Doq);
      if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).CYE != 0.0D)) {}
    }
    for (;;)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.wallet.a.s.eGW();
        if (com.tencent.mm.plugin.wallet.a.s.eGX().eJI())
        {
          ae.i(this.TAG, "payWithoutPassword zeroPay");
          if (this.mPayInfo == null)
          {
            i = k;
            if (this.mPayInfo != null) {
              break label258;
            }
          }
          label258:
          for (localObject = "";; localObject = this.mPayInfo.dmw)
          {
            af.f(i, (String)localObject, 3, "");
            eHw();
            AppMethodBeat.o(69447);
            return;
            i = this.mPayInfo.dDH;
            break;
          }
        }
        ae.i(this.TAG, "has useful bankcard ! payWithOldBankcard zeroPay");
        eHi();
        AppMethodBeat.o(69447);
        return;
      }
      if (this.Dbi)
      {
        ae.i(this.TAG, "hy: start do pay with force use given bankcard");
        if (!bu.isNullOrNil(this.Dbj))
        {
          this.CQi = eHy();
          eHi();
          AppMethodBeat.o(69447);
          return;
        }
        com.tencent.mm.plugin.wallet.a.s.eGW();
        if (com.tencent.mm.plugin.wallet.a.s.eGX().eJJ()) {
          if (this.mPayInfo == null)
          {
            i = 0;
            if (this.mPayInfo != null) {
              break label406;
            }
            localObject = "";
            label370:
            af.f(i, (String)localObject, 17, "");
          }
        }
        label406:
        do
        {
          c(false, 0, "");
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.dDH;
          break;
          localObject = this.mPayInfo.dmw;
          break label370;
          com.tencent.mm.plugin.wallet.a.s.eGW();
        } while (!com.tencent.mm.plugin.wallet.a.s.eGX().eJI());
        if (this.mPayInfo == null)
        {
          i = 0;
          label440:
          if (this.mPayInfo != null) {
            break label474;
          }
        }
        label474:
        for (localObject = "";; localObject = this.mPayInfo.dmw)
        {
          af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.dDH;
          break label440;
        }
      }
      localObject = bu.bI(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!bu.isNullOrNil((String)localObject)) {
        this.CQi = aFA((String)localObject);
      }
      if (this.CQi == null)
      {
        if ((this.CQh != null) && (this.CQh.size() > 0))
        {
          ae.i(this.TAG, " no last pay bankcard ! jump to select bankcard!");
          d(false, 8, "");
          AppMethodBeat.o(69447);
          return;
        }
        ae.i(this.TAG, "default bankcard not found! payWithNewBankcard");
        com.tencent.mm.plugin.wallet.a.s.eGW();
        if (com.tencent.mm.plugin.wallet.a.s.eGX().eJJ()) {
          if (this.mPayInfo == null)
          {
            i = 0;
            if (this.mPayInfo != null) {
              break label650;
            }
            localObject = "";
            label614:
            af.f(i, (String)localObject, 17, "");
          }
        }
        label650:
        do
        {
          c(false, 0, "");
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.dDH;
          break;
          localObject = this.mPayInfo.dmw;
          break label614;
          com.tencent.mm.plugin.wallet.a.s.eGW();
        } while (!com.tencent.mm.plugin.wallet.a.s.eGX().eJI());
        if (this.mPayInfo == null)
        {
          i = 0;
          label684:
          if (this.mPayInfo != null) {
            break label718;
          }
        }
        label718:
        for (localObject = "";; localObject = this.mPayInfo.dmw)
        {
          af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.dDH;
          break label684;
        }
      }
      i = this.CQi.a(this.yvS.DgN, this.yvS);
      if (this.ypV != null) {
        this.ypV.cp(10002, "");
      }
      if (i != 0)
      {
        ae.i(this.TAG, "main bankcard(" + i + ") is useless! jump to select bankcard!");
        d(false, i, "");
        AppMethodBeat.o(69447);
        return;
      }
      com.tencent.mm.plugin.wallet.a.s.eGW();
      if (com.tencent.mm.plugin.wallet.a.s.eGX().eJI())
      {
        ae.i(this.TAG, "payWithoutPassword");
        if (this.mPayInfo == null)
        {
          i = j;
          if (this.mPayInfo != null) {
            break label891;
          }
        }
        label891:
        for (localObject = "";; localObject = this.mPayInfo.dmw)
        {
          af.f(i, (String)localObject, 3, "");
          eHw();
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.dDH;
          break;
        }
      }
      ae.i(this.TAG, "has useful bankcard ! payWithOldBankcard");
      eHi();
      AppMethodBeat.o(69447);
      return;
      i = 0;
    }
  }
  
  private void eHw()
  {
    AppMethodBeat.i(69448);
    un(true);
    com.tencent.mm.plugin.wallet_core.utils.f.eMB();
    AppMethodBeat.o(69448);
  }
  
  private Bankcard eHy()
  {
    AppMethodBeat.i(69460);
    com.tencent.mm.plugin.wallet.a.s.eGW();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.eGX().uv(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (bu.nullAsNil(this.Dbj).equals(localBankcard.field_bindSerial))
        {
          ae.i(this.TAG, "hy: get given bankcard");
          AppMethodBeat.o(69460);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(69460);
    return null;
  }
  
  private boolean eHz()
  {
    AppMethodBeat.i(69465);
    if (isTransparent())
    {
      setContentViewVisibility(4);
      al.r(this, 0);
      AppMethodBeat.o(69465);
      return false;
    }
    setContentViewVisibility(0);
    al.r(this, getActionbarColor());
    AppMethodBeat.o(69465);
    return true;
  }
  
  private void fI(View paramView)
  {
    AppMethodBeat.i(69469);
    paramView = (TextView)paramView.findViewById(2131302708);
    paramView.setText(Html.fromHtml(String.format(getResources().getString(2131765701), new Object[] { getResources().getString(2131764964) })));
    paramView.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69469);
  }
  
  private void m(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(69437);
    if ((this.mPayInfo != null) && (this.mPayInfo.dDH == 46) && (this.yvS != null))
    {
      paramIntent.putExtra("key_total_fee", this.yvS.dmz);
      ae.i(this.TAG, "sentCancelEvent set fee:%s", new Object[] { Double.valueOf(this.yvS.dmz) });
    }
    yv localyv = new yv();
    localyv.dON.intent = paramIntent;
    yv.a locala;
    if (this.DbN == 1)
    {
      localyv.dON.dOO = 1000;
      localyv.dON.result = paramInt;
      locala = localyv.dON;
      if (this.mPayInfo != null) {
        break label217;
      }
    }
    label217:
    for (paramIntent = "";; paramIntent = this.mPayInfo.dmw)
    {
      locala.dmw = paramIntent;
      localyv.dON.dOQ = 1;
      if ((this.mPayInfo != null) && (paramInt == 0)) {
        com.tencent.mm.plugin.wallet.pay.a.b.b.aB(this.mPayInfo.dmw, this.mPayInfo.dDH, this.mPayInfo.channel);
      }
      com.tencent.mm.sdk.b.a.IvT.l(localyv);
      AppMethodBeat.o(69437);
      return;
      if (this.DbN != 2) {
        break;
      }
      localyv.dON.dOO = 1001;
      break;
    }
  }
  
  protected final boolean aVv()
  {
    AppMethodBeat.i(69459);
    String str2;
    String str1;
    if ((this.yvS == null) || (this.yvS.DpP == null) || (this.yvS.DpP.size() <= 0))
    {
      ae.w(this.TAG, "mOrders info is Illegal!");
      if ((this.Dbd != null) && (this.Dbd.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      str2 = getString(2131765550);
      str1 = str2;
      if (this.Dbd != null)
      {
        str1 = str2;
        if (!bu.isNullOrNil(this.Dbd.errMsg)) {
          str1 = this.Dbd.errMsg;
        }
      }
      ae.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.d(getContext(), str1, "", new WalletPayUI.19(this));
      AppMethodBeat.o(69459);
      return false;
    }
    if ((this.Dbi) && (!bu.isNullOrNil(this.Dbj)) && (eHy() == null))
    {
      if ((this.Dbd != null) && (this.Dbd.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      ae.w(this.TAG, "hy: should use given bankcard, but resolved as null. show error msg and quit");
      str2 = getString(2131765550);
      str1 = str2;
      if (this.Dbd != null)
      {
        str1 = str2;
        if (!bu.isNullOrNil(this.Dbd.errMsg)) {
          str1 = this.Dbd.errMsg;
        }
      }
      ae.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.d(getContext(), str1, "", new WalletPayUI.20(this));
      AppMethodBeat.o(69459);
      return false;
    }
    AppMethodBeat.o(69459);
    return true;
  }
  
  protected final void aW(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(69455);
    com.tencent.mm.plugin.report.service.g.yxI.f(13958, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.g.yxI.f(13955, new Object[] { Integer.valueOf(4) });
    if (this.mPayInfo == null) {
      if (this.mPayInfo != null) {
        break label226;
      }
    }
    label226:
    for (Object localObject = "";; localObject = this.mPayInfo.dmw)
    {
      af.f(i, (String)localObject, 11, "");
      localObject = getInput();
      ((Bundle)localObject).putInt("key_main_bankcard_state", paramInt);
      ((Bundle)localObject).putParcelable("key_orders", this.yvS);
      ((Bundle)localObject).putParcelable("key_pay_info", this.mPayInfo);
      ((Bundle)localObject).putParcelable("key_authen", eHs());
      ((Bundle)localObject).putString("key_pwd1", this.jth);
      ((Bundle)localObject).putInt("key_pay_flag", 3);
      ((Bundle)localObject).putInt("key_err_code", -1004);
      ((Bundle)localObject).putParcelable("key_favor_pay_info", this.Dar);
      ((Bundle)localObject).putBoolean("key_is_filter_bank_type", paramBoolean);
      if (this.CQi != null) {
        ((Bundle)localObject).putString("key_is_cur_bankcard_bind_serial", this.CQi.field_bindSerial);
      }
      aw((Bundle)localObject);
      AppMethodBeat.o(69455);
      return;
      i = this.mPayInfo.dDH;
      break;
    }
  }
  
  protected void aw(Bundle paramBundle)
  {
    AppMethodBeat.i(69471);
    this.Dbg = true;
    if (this.yvS != null)
    {
      paramBundle.putInt("key_support_bankcard", this.yvS.DgN);
      paramBundle.putString("key_reqKey", this.yvS.dmw);
      if ((this.yvS.DpP != null) && (this.yvS.DpP.size() > 0)) {
        paramBundle.putString("key_TransId", ((Orders.Commodity)this.yvS.DpP.get(0)).dmx);
      }
      paramBundle.putLong("key_SessionId", this.Dbz);
    }
    if (this.mPayInfo != null) {
      paramBundle.putInt("key_scene", this.mPayInfo.dDH);
    }
    if (!eHt()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      paramBundle.putInt("is_deduct_open", this.DbH);
      this.Dbh = new d.a()
      {
        public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(69415);
          ae.i(WalletPayUI.this.TAG, "pay process end");
          WalletPayUI.this.Dbg = false;
          paramAnonymousBundle = new Intent();
          AppMethodBeat.o(69415);
          return paramAnonymousBundle;
        }
      };
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, paramBundle, this.Dbh);
      AppMethodBeat.o(69471);
      return;
    }
  }
  
  protected final void c(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69452);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
    com.tencent.mm.plugin.wallet.a.s.eGW();
    ae.d(str, com.tencent.mm.plugin.wallet.a.s.eGX().eJH() + ", need confirm ? " + paramBoolean);
    if (paramBoolean)
    {
      if (!bu.isNullOrNil(paramString)) {
        break label130;
      }
      paramString = Bankcard.al(this, paramInt);
    }
    label130:
    for (;;)
    {
      com.tencent.mm.ui.base.h.e(this, paramString, "", getString(2131765660), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69398);
          WalletPayUI.this.eHx();
          AppMethodBeat.o(69398);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69400);
          if (WalletPayUI.this.isTransparent()) {
            WalletPayUI.this.finish();
          }
          AppMethodBeat.o(69400);
        }
      });
      AppMethodBeat.o(69452);
      return;
      eHx();
      AppMethodBeat.o(69452);
      return;
    }
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(69466);
    if (paramInt == 0)
    {
      if (isTransparent())
      {
        finish();
        AppMethodBeat.o(69466);
      }
    }
    else if (paramInt == 1) {
      eHi();
    }
    AppMethodBeat.o(69466);
  }
  
  public final void d(boolean paramBoolean, final int paramInt, String paramString)
  {
    AppMethodBeat.i(69453);
    ae.d(this.TAG, "pay with select bankcard! need confirm ? ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (!bu.isNullOrNil(paramString)) {
        break label118;
      }
      paramString = Bankcard.al(this, paramInt);
    }
    label118:
    for (;;)
    {
      com.tencent.mm.ui.base.h.e(this, paramString, "", getString(2131765679), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69401);
          if (WalletPayUI.m(WalletPayUI.this))
          {
            WalletPayUI.this.um(true);
            AppMethodBeat.o(69401);
            return;
          }
          WalletPayUI.this.aW(paramInt, false);
          AppMethodBeat.o(69401);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69402);
          if (WalletPayUI.this.isTransparent()) {
            WalletPayUI.this.finish();
          }
          AppMethodBeat.o(69402);
        }
      });
      AppMethodBeat.o(69453);
      return;
      if (eHa())
      {
        um(true);
        AppMethodBeat.o(69453);
        return;
      }
      aW(paramInt, false);
      AppMethodBeat.o(69453);
      return;
    }
  }
  
  public final void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69472);
    ae.i(this.TAG, "onGenFinish callback");
    if (paramBoolean)
    {
      ae.i(this.TAG, "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.dwk = paramString1;
      this.mPayInfo.dwl = paramString2;
      un(false);
      com.tencent.mm.plugin.wallet_core.utils.f.eMB();
      AppMethodBeat.o(69472);
      return;
    }
    ae.e(this.TAG, "onGenFinish callback, result.isSuccess is false");
    un(false);
    com.tencent.mm.plugin.wallet_core.utils.f.eMB();
    AppMethodBeat.o(69472);
  }
  
  protected final boolean eHB()
  {
    return (this.mPayInfo != null) && (this.mPayInfo.dDH != 11);
  }
  
  protected void eHi()
  {
    AppMethodBeat.i(69450);
    um(false);
    AppMethodBeat.o(69450);
  }
  
  protected void eHo()
  {
    int i = 2;
    AppMethodBeat.i(69432);
    com.tencent.mm.plugin.report.service.g.yxI.f(11850, new Object[] { Integer.valueOf(2), Integer.valueOf(this.mPayInfo.dDH) });
    if (this.mPayInfo.dDH == 11) {
      i = 3;
    }
    Object localObject = this.mPayInfo;
    if ((localObject == null) || (bu.isNullOrNil(((PayInfo)localObject).dmw)))
    {
      ae.i("MicroMsg.CgiManager", "no payInfo or reqKey");
      localObject = null;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessName("PayProcess");
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessSessionId(this.Dbz);
        if ((this.mPayInfo.dDH != 6) || (this.mPayInfo.FEn != 100)) {
          break label446;
        }
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(100);
        label134:
        if (!this.mPayInfo.FEo) {
          break label460;
        }
      }
    }
    label446:
    label460:
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress((com.tencent.mm.ak.n)localObject, true, bool);
      AppMethodBeat.o(69432);
      return;
      String str = ((PayInfo)localObject).dmw;
      ae.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", new Object[] { str });
      ae.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
      if (str.startsWith("sns_aa_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.a((PayInfo)localObject, i);
        break;
      }
      if (str.startsWith("sns_tf_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.j((PayInfo)localObject, i);
        break;
      }
      if (str.startsWith("sns_ff_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.c((PayInfo)localObject, i);
        break;
      }
      if (str.startsWith("ts_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.d((PayInfo)localObject, i);
        break;
      }
      if (str.startsWith("sns_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.h((PayInfo)localObject, i);
        break;
      }
      if (str.startsWith("offline_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.e((PayInfo)localObject, i);
        break;
      }
      if (str.startsWith("up_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.k((PayInfo)localObject, i);
        break;
      }
      if (str.startsWith("seb_ff_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.g((PayInfo)localObject, i);
        break;
      }
      if (str.startsWith("tax_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.i((PayInfo)localObject, i);
        break;
      }
      if (str.startsWith("dc_"))
      {
        localObject = new com.tencent.mm.plugin.wallet.pay.a.c.b((PayInfo)localObject, i);
        break;
      }
      localObject = new com.tencent.mm.plugin.wallet.pay.a.c.f((PayInfo)localObject, i);
      break;
      ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(this.mPayInfo.dDH);
      break label134;
    }
  }
  
  public final void eHr()
  {
    AppMethodBeat.i(69442);
    com.tencent.mm.plugin.wallet.a.j localj = this.Dbe.aGi(this.Dar.Doq);
    List localList = this.Dbe.eKU();
    com.tencent.mm.plugin.wallet.a.h localh = this.Dbe.DtC;
    Object localObject1 = "";
    double d2;
    Object localObject2;
    int i;
    double d1;
    if (localj != null)
    {
      d2 = localj.CYM;
      if (d2 > 0.0D)
      {
        localObject2 = localj.CYO;
        int j = 1;
        localObject1 = localObject2;
        i = j;
        d1 = d2;
        if (!bu.isNullOrNil(localj.CYP))
        {
          localObject1 = (String)localObject2 + "," + localj.CYP;
          d1 = d2;
          i = j;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (i == 0)
      {
        localObject2 = localObject1;
        if (localList.size() > 0) {
          localObject2 = (String)localObject1 + getContext().getString(2131765742);
        }
      }
      if ((d1 > 0.0D) && (localh != null) && (localh.CYI == 0))
      {
        if (localj != null) {
          this.Dbn.setText(com.tencent.mm.wallet_core.ui.f.C(localj.CYL));
        }
        this.Dbq.setText(com.tencent.mm.wallet_core.ui.f.bai(this.yvS.wSq));
        this.Dbp.setText(com.tencent.mm.wallet_core.ui.f.d(this.yvS.dmz, this.yvS.wSq));
        this.Dbp.setVisibility(0);
      }
      for (;;)
      {
        if (!bu.isNullOrNil((String)localObject2)) {
          this.Dbv.setText((CharSequence)localObject2);
        }
        AppMethodBeat.o(69442);
        return;
        this.Dbn.setText(com.tencent.mm.wallet_core.ui.f.C(this.yvS.dmz));
        this.Dbq.setText(com.tencent.mm.wallet_core.ui.f.bai(this.yvS.wSq));
        this.Dbp.setVisibility(8);
      }
      i = 0;
      d1 = d2;
      continue;
      i = 0;
      d1 = 0.0D;
    }
  }
  
  protected final Authen eHs()
  {
    AppMethodBeat.i(69443);
    Authen localAuthen = new Authen();
    if (eHt()) {}
    for (localAuthen.dEu = 3;; localAuthen.dEu = 6)
    {
      if (!bu.isNullOrNil(this.jth)) {
        localAuthen.Dlv = this.jth;
      }
      if (this.CQi != null)
      {
        localAuthen.wRt = this.CQi.field_bindSerial;
        localAuthen.dlT = this.CQi.field_bankcardType;
      }
      if ((this.Dar != null) && (this.Dbe != null) && (this.Dbe.eKR()))
      {
        localAuthen.DlF = this.Dar.Doq;
        localAuthen.DlE = this.Dar.Dot;
      }
      localAuthen.xDC = this.mPayInfo;
      AppMethodBeat.o(69443);
      return localAuthen;
    }
  }
  
  protected final boolean eHt()
  {
    AppMethodBeat.i(69444);
    if ((this.CQi != null) && (this.yvS != null) && (this.yvS.DgN == 3))
    {
      if (this.CQi.eIB())
      {
        AppMethodBeat.o(69444);
        return true;
      }
      AppMethodBeat.o(69444);
      return false;
    }
    if ((this.yvS != null) && (!Bankcard.We(this.yvS.DgN)))
    {
      AppMethodBeat.o(69444);
      return true;
    }
    AppMethodBeat.o(69444);
    return false;
  }
  
  protected final void eHu()
  {
    AppMethodBeat.i(69445);
    ul(true);
    AppMethodBeat.o(69445);
  }
  
  protected final void eHx()
  {
    AppMethodBeat.i(69454);
    Bundle localBundle = getIntent().getExtras();
    com.tencent.mm.plugin.wallet.a.s.eGW();
    if (com.tencent.mm.plugin.wallet.a.s.eGX().eJH()) {}
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("key_pay_flag", i);
      localBundle.putParcelable("key_orders", this.yvS);
      localBundle.putParcelable("key_pay_info", this.mPayInfo);
      localBundle.putParcelable("key_favor_pay_info", this.Dar);
      aw(localBundle);
      AppMethodBeat.o(69454);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(69434);
    ae.i(this.TAG, "finish %s %s mPayResultType:%s", new Object[] { Integer.valueOf(hashCode()), bu.fpN().toString(), Integer.valueOf(this.mPayResultType) });
    cancelQRPay();
    if ((this.yvS != null) && (!this.yvS.DpP.isEmpty())) {
      getIntent().putExtra("key_trans_id", ((Orders.Commodity)this.yvS.DpP.get(0)).dmx);
    }
    if (this.mPayInfo != null) {
      getIntent().putExtra("key_reqKey", this.mPayInfo.dmw);
    }
    com.tencent.mm.wallet_core.d locald;
    if (this.isPaySuccess)
    {
      if (this.yvS != null) {
        getIntent().putExtra("key_total_fee", this.yvS.dmz);
      }
      getIntent().putExtra("key_pay_reslut_type", 1);
      m(-1, getIntent());
      setResult(-1, getIntent());
      locald = getProcess();
      if (locald != null) {
        if (locald.LTg == null) {
          break label717;
        }
      }
    }
    label408:
    label439:
    label570:
    label581:
    label717:
    for (Object localObject = (Context)locald.LTg.get();; localObject = null)
    {
      if (this == localObject)
      {
        ae.i(this.TAG, "remove process end callback to prevent ui leak");
        locald.fVk();
      }
      super.finish();
      AppMethodBeat.o(69434);
      return;
      if ((this.mPayInfo != null) && (this.mPayInfo.dDH == 8) && (this.yvS != null))
      {
        this.mPayInfo.FEv = 0;
        doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.a(eHs(), this.yvS, true), false);
        if (this.mPayInfo.hwN != null)
        {
          long l = this.mPayInfo.hwN.getLong("extinfo_key_9");
          com.tencent.mm.plugin.report.service.g.yxI.f(13956, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      m(0, getIntent());
      getIntent().putExtra("key_pay_reslut_type", this.mPayResultType);
      int i;
      if (this.DbN == 1)
      {
        getIntent().putExtra("key_pay_reslut_type", 1000);
        setResult(0, getIntent());
        com.tencent.mm.plugin.wallet.a.s.eGW();
        if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJJ()) {
          break label593;
        }
        if (this.mPayInfo != null) {
          break label570;
        }
        i = 0;
        if (this.mPayInfo != null) {
          break label581;
        }
      }
      for (localObject = "";; localObject = this.mPayInfo.dmw)
      {
        af.f(i, (String)localObject, 18, "");
        localObject = com.tencent.mm.wallet_core.a.bac("PayProcess").iterator();
        while (((Iterator)localObject).hasNext())
        {
          locald = (com.tencent.mm.wallet_core.d)((Iterator)localObject).next();
          locald.J(new Object[] { "specEndProcessWithoutFinish" });
          if (locald.dyY != null) {
            locald.dyY.clear();
          }
          com.tencent.mm.wallet_core.a.remove(locald.getClass().hashCode());
          locald.eGZ();
        }
        break;
        if (this.DbN != 2) {
          break label408;
        }
        getIntent().putExtra("key_pay_reslut_type", 1001);
        break label408;
        i = this.mPayInfo.dDH;
        break label439;
      }
      label593:
      com.tencent.mm.plugin.wallet.a.s.eGW();
      if (com.tencent.mm.plugin.wallet.a.s.eGX().eJI())
      {
        if (this.mPayInfo == null)
        {
          i = 0;
          label615:
          if (this.mPayInfo != null) {
            break label649;
          }
        }
        for (localObject = "";; localObject = this.mPayInfo.dmw)
        {
          af.f(i, (String)localObject, 4, "");
          break;
          i = this.mPayInfo.dDH;
          break label615;
        }
      }
      if (this.mPayInfo == null)
      {
        i = 0;
        if (this.mPayInfo != null) {
          break label705;
        }
      }
      for (localObject = "";; localObject = this.mPayInfo.dmw)
      {
        af.f(i, (String)localObject, 7, "");
        break;
        i = this.mPayInfo.dDH;
        break label670;
      }
    }
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496008;
  }
  
  protected final PayInfo getPayInfo()
  {
    AppMethodBeat.i(69470);
    if (this.mPayInfo == null) {
      this.mPayInfo = ((PayInfo)getIntent().getParcelableExtra("key_pay_info"));
    }
    PayInfo localPayInfo = this.mPayInfo;
    AppMethodBeat.o(69470);
    return localPayInfo;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69438);
    al.b(getWindow());
    MMScrollView localMMScrollView = (MMScrollView)findViewById(2131306834);
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.yvk = ((Button)findViewById(2131306815));
    this.yvk.setClickable(false);
    this.yvk.setEnabled(false);
    this.Dbn = ((TextView)findViewById(2131306804));
    this.Dbo = ((TextView)findViewById(2131306803));
    this.Dbq = ((TextView)findViewById(2131306785));
    this.Dbv = ((TextView)findViewById(2131306781));
    this.Dbp = ((TextView)findViewById(2131306791));
    this.Dbu = ((TextView)findViewById(2131306811));
    this.Dbp.getPaint().setFlags(16);
    this.Dbr = ((TextView)findViewById(2131306816));
    this.Dbs = ((TextView)findViewById(2131306812));
    this.Dbs.setOnClickListener(new w()
    {
      public final void ccc()
      {
        AppMethodBeat.i(69416);
        WalletPayUI.this.c(false, 0, "");
        AppMethodBeat.o(69416);
      }
    });
    this.Dbt = ((ImageView)findViewById(2131306778));
    this.Dbt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69417);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WalletPayUI.this.Dbk) {
          WalletPayUI.this.Dbt.setImageResource(2131233555);
        }
        for (WalletPayUI.this.Dbk = false;; WalletPayUI.this.Dbk = true)
        {
          WalletPayUI.this.Dbx.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69417);
          return;
          WalletPayUI.this.Dbt.setImageResource(2131233558);
        }
      }
    });
    this.Dbw = ((LinearLayout)findViewById(2131306788));
    this.Dbx = new a();
    this.yvk.setOnClickListener(new w()
    {
      public final void ccc()
      {
        AppMethodBeat.i(69418);
        com.tencent.mm.plugin.wallet.a.s.eGW();
        int i;
        if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJI())
        {
          if (WalletPayUI.this.mPayInfo != null) {
            break label73;
          }
          i = 0;
          if (WalletPayUI.this.mPayInfo != null) {
            break label87;
          }
        }
        label73:
        label87:
        for (String str = "";; str = WalletPayUI.this.mPayInfo.dmw)
        {
          af.f(i, str, 6, "");
          WalletPayUI.this.eHu();
          WalletPayUI.this.Dbm = true;
          AppMethodBeat.o(69418);
          return;
          i = WalletPayUI.this.mPayInfo.dDH;
          break;
        }
      }
    });
    this.yvk.setText(2131765657);
    this.DbA = ((TextView)findViewById(2131303187));
    this.DbB = ((LinearLayout)findViewById(2131303186));
    updateView();
    AppMethodBeat.o(69438);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69464);
    if (this.DbI)
    {
      String str1 = this.TAG;
      boolean bool1;
      label87:
      String str2;
      int i;
      if ((getPayInfo() == null) || (!getPayInfo().unK))
      {
        bool1 = true;
        ae.i(str1, "case 1 %s,  stack %s", new Object[] { Boolean.valueOf(bool1), bu.fpN().toString() });
        str1 = this.TAG;
        com.tencent.mm.plugin.wallet.a.s.eGW();
        if (com.tencent.mm.plugin.wallet.a.s.eGX().eJH()) {
          break label196;
        }
        bool1 = true;
        ae.d(str1, "case 2 %s,", new Object[] { Boolean.valueOf(bool1) });
        str2 = this.TAG;
        if (this.CQh != null) {
          break label201;
        }
        i = 0;
        label121:
        if (this.CQi != null) {
          break label212;
        }
      }
      label196:
      label201:
      label212:
      for (str1 = "";; str1 = this.CQi.field_forbidWord)
      {
        ae.d(str2, "case 3 mBankcardList %s, mDefaultBankcard %s", new Object[] { Integer.valueOf(i), str1 });
        if ((getPayInfo() != null) && (getPayInfo().unK)) {
          break label224;
        }
        ae.i(this.TAG, "get isTransparent1");
        AppMethodBeat.o(69464);
        return false;
        bool1 = false;
        break;
        bool1 = false;
        break label87;
        i = this.CQh.size();
        break label121;
      }
      label224:
      com.tencent.mm.plugin.wallet.a.s.eGW();
      if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJH())
      {
        ae.i(this.TAG, "get isTransparent2");
        AppMethodBeat.o(69464);
        return false;
      }
      if ((this.CQh != null) && ((this.CQh.size() == 0) || ((this.CQi != null) && (!bu.isNullOrNil(this.CQi.field_forbidWord)))))
      {
        str1 = this.TAG;
        if ((this.CQh != null) && (this.CQh.size() == 0))
        {
          bool1 = true;
          if ((this.CQi == null) || (bu.isNullOrNil(this.CQi.field_forbidWord))) {
            break label378;
          }
        }
        label378:
        for (boolean bool2 = true;; bool2 = false)
        {
          ae.i(str1, "get isTransparent3 1 %s 2 %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(69464);
          return false;
          bool1 = false;
          break;
        }
      }
      ae.i(this.TAG, "get isTransparent4");
      AppMethodBeat.o(69464);
      return true;
    }
    ae.i(this.TAG, "get isTransparent5");
    AppMethodBeat.o(69464);
    return true;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69462);
    ae.i(this.TAG, "onAcvityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(69462);
      return;
      if (paramInt2 == -1)
      {
        if (paramIntent != null)
        {
          this.DbH = paramIntent.getIntExtra("auto_deduct_flag", -1);
          if ((this.yvS != null) && (this.yvS.DpU != null)) {
            this.yvS.DpU.DbH = this.DbH;
          }
          getPayInfo().FEs = this.DbH;
          if (this.DbH == 1)
          {
            getPayInfo().FEt = paramIntent.getStringExtra("deduct_bank_type");
            getPayInfo().FEu = paramIntent.getStringExtra("deduct_bind_serial");
          }
        }
        this.DbG = true;
        onProgressFinish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(13958, new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(69462);
        return;
        finish();
      }
      this.Dby.dismiss();
      this.Dbm = false;
      eHo();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69429);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.TAG = ("MicroMsg.WalletPayUI@" + hashCode());
    if (Dbb)
    {
      ae.w(this.TAG, "has Undestory WalletPayUI!");
      com.tencent.mm.plugin.report.service.g.yxI.n(965L, 1L, 1L);
      VW(2);
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    Dbb = true;
    long l = System.currentTimeMillis();
    int j = getIntent().getIntExtra("key_context_hashcode", -1);
    paramBundle = new b[Dbc.size()];
    ae.i(this.TAG, "WalletPayUI check %s this %s fromHashCode %s", new Object[] { Integer.valueOf(Dbc.size()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
    paramBundle = (b[])Dbc.toArray(paramBundle);
    int k = paramBundle.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = paramBundle[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localObject.lRT.get();
      if (localWalletPayUI != null)
      {
        ae.w(this.TAG, "has old payui, both finish %s", new Object[] { Integer.valueOf(localWalletPayUI.hashCode()) });
        if ((j != localObject.aHQ) || (j == -1)) {
          break label290;
        }
        localWalletPayUI.VW(2);
        com.tencent.mm.plugin.report.service.g.yxI.n(965L, 41L, 1L);
      }
      for (;;)
      {
        Dbc.remove(localObject);
        localWalletPayUI.finish();
        i += 1;
        break;
        label290:
        localWalletPayUI.VW(1);
        com.tencent.mm.plugin.report.service.g.yxI.n(965L, 40L, 1L);
      }
    }
    this.DbP = new b((byte)0);
    this.DbP.timestamp = l;
    this.DbP.aHQ = j;
    this.DbP.lRT = new WeakReference(this);
    Dbc.add(this.DbP);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.e(this.TAG, "hy: account not ready. finish now");
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    getWindow().getDecorView().postDelayed(this.DbO, 5000L);
    this.DbQ = bu.fpO();
    com.tencent.mm.sdk.b.a.IvT.c(this.ytq);
    com.tencent.mm.plugin.wallet_core.model.k.Wf(5);
    this.ypV = com.tencent.mm.plugin.wallet.a.aT(getIntent());
    setMMTitle(2131765707);
    this.mPayInfo = getPayInfo();
    this.Dbi = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
    this.Dbj = bu.bI(getIntent().getStringExtra("key_force_use_bind_serail"), "");
    this.yqw = getIntent().getStringExtra("key_receiver_true_name");
    if ((this.mPayInfo == null) || (this.mPayInfo.FEr == 0L))
    {
      this.Dbz = System.currentTimeMillis();
      com.tencent.mm.plugin.wallet.a.s.eGW();
      if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJH())
      {
        if (this.mPayInfo != null) {
          break label683;
        }
        i = 0;
        label559:
        if (this.mPayInfo != null) {
          break label694;
        }
        paramBundle = "";
        label569:
        af.f(i, paramBundle, 1, "");
      }
      if (eHn()) {
        break label763;
      }
      ae.d(this.TAG, "PayInfo = " + this.mPayInfo);
      if ((this.mPayInfo == null) || (bu.isNullOrNil(this.mPayInfo.dmw))) {
        break label705;
      }
      eHo();
      com.tencent.mm.plugin.secinforeport.a.d.yRQ.asyncReportPaySecurityInfoThroughCgi();
      initView();
    }
    for (;;)
    {
      if (this.mPayInfo != null) {
        com.tencent.mm.plugin.wallet.pay.a.b.aFt(this.mPayInfo.FEx);
      }
      AppMethodBeat.o(69429);
      return;
      this.Dbz = this.mPayInfo.FEr;
      break;
      label683:
      i = this.mPayInfo.dDH;
      break label559;
      label694:
      paramBundle = this.mPayInfo.dmw;
      break label569;
      label705:
      if ((this.mPayInfo != null) && (!bu.isNullOrNil(this.mPayInfo.errMsg))) {}
      for (paramBundle = this.mPayInfo.errMsg;; paramBundle = getString(2131765700))
      {
        com.tencent.mm.ui.base.h.a(this, paramBundle, null, false, new WalletPayUI.23(this));
        break;
      }
      label763:
      ae.i(this.TAG, "hy: pay end on create. finish");
      finish();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69431);
    if (this.Das != null)
    {
      this.Das.closeTipDialog();
      this.Das.release();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.ytq);
    this.Dat = null;
    getWindow().getDecorView().removeCallbacks(this.DbO);
    Dbc.remove(this.DbP);
    Dbb = false;
    long l = System.currentTimeMillis();
    b[] arrayOfb = new b[Dbc.size()];
    arrayOfb = (b[])Dbc.toArray(arrayOfb);
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localb.lRT.get();
      if ((localWalletPayUI != null) && (l - localb.timestamp > 600000L))
      {
        ae.w(this.TAG, "has old payui, both finish");
        com.tencent.mm.plugin.report.service.g.yxI.n(965L, 2L, 1L);
        Dbc.remove(localb);
        localWalletPayUI.VW(1);
        localWalletPayUI.finish();
      }
      i += 1;
    }
    if (this.mPayInfo != null) {
      com.tencent.mm.plugin.wallet.pay.a.b.aFu(this.mPayInfo.FEx);
    }
    setAuthState(false);
    super.onDestroy();
    AppMethodBeat.o(69431);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69435);
    if (paramInt == 4)
    {
      if (isAuthDoing())
      {
        ae.w(this.TAG, "block when authening");
        AppMethodBeat.o(69435);
        return true;
      }
      if ((this.Dby != null) && (this.mPayInfo != null) && (this.mPayInfo.unK) && (!this.mNetSceneMgr.isProcessing())) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(69435);
        return true;
        hideVKB();
        showDialog(1000);
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(69435);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    int j = 1;
    AppMethodBeat.i(69436);
    ae.i(this.TAG, "onNewIntent");
    setIntent(paramIntent);
    if (!eHn())
    {
      ae.w(this.TAG, "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
      if (paramIntent.getBooleanExtra("send_cancel_event", true)) {
        m(0, getIntent());
      }
      this.isPaySuccess = false;
    }
    if (paramIntent.getBooleanExtra("direc_change_bankcard", false))
    {
      um(true);
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false))) {
      this.DbD = true;
    }
    for (int i = 1; i != 0; i = 0)
    {
      ae.i(this.TAG, "isFromBindCard is true");
      eHo();
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_is_realname_verify_process", false)))
    {
      this.DbE = true;
      i = j;
      if (i == 0) {
        break label196;
      }
      ae.i(this.TAG, "isFromRealNameVerify is true");
      finish();
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(69436);
      return;
      i = 0;
      break;
      label196:
      ae.e(this.TAG, "isFromBindCard is false,isFromRealNameVerify is false");
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69473);
    super.onPause();
    if (this.Dat != null) {
      this.Dat.onActivityPause();
    }
    AppMethodBeat.o(69473);
  }
  
  public boolean onProgressFinish()
  {
    boolean bool2 = false;
    AppMethodBeat.i(69463);
    ae.i(this.TAG, "onProgressFinish isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.DbL) });
    com.tencent.mm.sdk.b.a.IvT.l(new yk());
    int i;
    int j;
    label93:
    Object localObject;
    label104:
    boolean bool1;
    if ((this.yvS != null) && (this.yvS.DpU != null) && (!this.DbG))
    {
      i = 1;
      if ((i == 0) && (!eHz()))
      {
        if (this.mPayInfo != null) {
          break label140;
        }
        j = 0;
        if (this.mPayInfo != null) {
          break label151;
        }
        localObject = "";
        af.f(j, (String)localObject, 2, "");
      }
      if (!this.DbL) {
        break label163;
      }
      ul(true);
      bool1 = true;
    }
    for (;;)
    {
      AppMethodBeat.o(69463);
      return bool1;
      i = 0;
      break;
      label140:
      j = this.mPayInfo.dDH;
      break label93;
      label151:
      localObject = this.mPayInfo.dmw;
      break label104;
      label163:
      if (this.DbF)
      {
        bool1 = true;
      }
      else if (i != 0)
      {
        localObject = new Intent(this, WalletPayDeductUI.class);
        ((Intent)localObject).putExtra("orders", this.yvS);
        startActivityForResult((Intent)localObject, 0);
        bool1 = true;
      }
      else if (getContentView().getVisibility() != 0)
      {
        if ((!this.Dbm) && (aVv()))
        {
          ul(true);
          this.Dbm = true;
        }
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (getContentView().getVisibility() == 0)
        {
          bool1 = bool2;
          if (this.yvS != null)
          {
            bool1 = bool2;
            if (this.yvS.DpU != null)
            {
              bool1 = bool2;
              if (this.yvk.isEnabled())
              {
                bool1 = bool2;
                if (!this.DbJ)
                {
                  this.yvk.performClick();
                  this.DbJ = true;
                  bool1 = bool2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69433);
    ae.i(this.TAG, "hy: onResume isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.DbL) });
    if (!isProcessing())
    {
      if (!bu.isNullOrNil(this.Dbj)) {
        this.CQi = eHy();
      }
    }
    else
    {
      if (!this.DbM) {
        break label149;
      }
      ae.i(this.TAG, "onResume isResumePassFinish");
      this.DbM = false;
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(69433);
      return;
      if (this.CQi == null)
      {
        com.tencent.mm.plugin.wallet.a.s.eGW();
        this.CQi = com.tencent.mm.plugin.wallet.a.s.eGX().a(null, null, eHB(), false);
        break;
      }
      com.tencent.mm.plugin.wallet.a.s.eGW();
      this.CQi = com.tencent.mm.plugin.wallet.a.s.eGX().a(null, this.CQi.field_bindSerial, eHB(), false);
      break;
      label149:
      if ((this.Dbg) && (getContentViewVisibility() != 0) && ((this.Dby == null) || (!this.Dby.isShowing())))
      {
        ae.i(this.TAG, "hy: has started process and is transparent and no pwd appeared. finish self");
        finish();
      }
      else if (this.Dat != null)
      {
        this.Dat.eKV();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(69457);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn, paramBoolean);
    if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
      setAuthState(false);
    }
    AppMethodBeat.o(69457);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(69458);
    ae.i(this.TAG, "errorType %s errCode %s, errmsg %s, scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    boolean bool;
    Object localObject1;
    label308:
    label343:
    label503:
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.c.f))
      {
        this.mPayResultType = 1;
        this.Dbd = ((com.tencent.mm.plugin.wallet.pay.a.c.f)paramn);
        paramString = (com.tencent.mm.plugin.wallet.pay.a.c.f)paramn;
        if (paramString.isJumpRemind())
        {
          paramn = paramString.getJumpRemind();
          paramn.fVQ();
          paramn.a(this, new com.tencent.mm.wallet_core.c.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(69403);
              if (paramn.fVP())
              {
                WalletPayUI.a(WalletPayUI.this, paramString);
                AppMethodBeat.o(69403);
                return;
              }
              WalletPayUI.this.finish();
              AppMethodBeat.o(69403);
            }
            
            public final void onEnter() {}
            
            public final void onUrlCancel()
            {
              AppMethodBeat.i(69405);
              if (paramn.fVP())
              {
                WalletPayUI.a(WalletPayUI.this, paramString);
                AppMethodBeat.o(69405);
                return;
              }
              WalletPayUI.this.finish();
              AppMethodBeat.o(69405);
            }
            
            public final void onUrlOk()
            {
              AppMethodBeat.i(69404);
              if (paramn.fVP())
              {
                WalletPayUI.a(WalletPayUI.this, paramString);
                AppMethodBeat.o(69404);
                return;
              }
              WalletPayUI.this.eHo();
              AppMethodBeat.o(69404);
            }
          });
          AppMethodBeat.o(69458);
          return true;
        }
        a(paramString);
      }
      while (!(paramn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        updateView();
        AppMethodBeat.o(69458);
        return true;
      }
      this.mPayResultType = 1;
      paramn = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramn;
      paramString = getInput();
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putParcelable("key_bankcard", this.CQi);
      paramString.putString("key_bank_type", this.CQi.field_bankcardType);
      if (!bu.isNullOrNil(this.jth)) {
        paramString.putString("key_pwd1", this.jth);
      }
      paramString.putString("kreq_token", paramn.getToken());
      paramString.putParcelable("key_authen", paramn.CZU);
      if (!paramn.CZS)
      {
        bool = true;
        paramString.putBoolean("key_need_verify_sms", bool);
        paramString.putInt("key_can_verify_tail", paramn.CZY);
        paramString.putString("key_verify_tail_wording", paramn.CZZ);
        localObject1 = getInput();
        if (paramn.Daa != 1) {
          break label628;
        }
        bool = true;
        ((Bundle)localObject1).putBoolean("key_block_bind_new_card", bool);
        if (!bu.isNullOrNil(paramn.CZV)) {
          break label634;
        }
        paramString.putString("key_mobile", this.CQi.field_mobile);
        paramString.putString("key_QADNA_URL", paramn.CZW);
        if (!paramn.isPaySuccess) {
          break label649;
        }
        if (this.ypV != null)
        {
          this.ypV.cp(10003, "");
          localObject1 = this.ypV;
          com.tencent.mm.plugin.report.service.g.yxI.f(13455, new Object[] { ((com.tencent.mm.plugin.wallet.a)localObject1).CNW, Long.valueOf(System.currentTimeMillis()), ((com.tencent.mm.plugin.wallet.a)localObject1).CNX });
        }
        paramString.putParcelable("key_orders", paramn.CZT);
        if (this.mPayInfo != null)
        {
          ae.i(this.TAG, "payscene %d", new Object[] { Integer.valueOf(this.mPayInfo.dDH) });
          if (8 == this.mPayInfo.dDH)
          {
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQJ, Boolean.TRUE);
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("pwd", this.jth);
        localObject2 = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class);
        paramInt1 = 0;
        if (!((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).cSs()) {
          break label663;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
        ((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).a(paramn.eHc(), true, this.mPayInfo.DpN, (Bundle)localObject1);
        paramString.putInt("key_pay_flag", 3);
        paramn = paramn.wNL;
        if (paramn != null) {
          paramString.putParcelable("key_realname_guide_helper", paramn);
        }
        aw(paramString);
        AppMethodBeat.o(69458);
        return true;
        bool = false;
        break;
        label628:
        bool = false;
        break label308;
        label634:
        paramString.putString("key_mobile", paramn.CZV);
        break label343;
        label649:
        paramString.putParcelable("key_orders", this.yvS);
        break label503;
        label663:
        if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).cSt()) {
          paramInt1 = 2;
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("pwd", this.jth);
      localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.mPayInfo.DAm == 1)
      {
        bool = true;
        label732:
        ((com.tencent.mm.plugin.fingerprint.d.a)localObject2).a(bool, false, (Bundle)localObject1);
        if ((paramInt2 != -1) && (paramInt2 != -500)) {
          break label858;
        }
      }
      label858:
      for (this.mPayResultType = 3;; this.mPayResultType = 2) {
        switch (paramInt2)
        {
        default: 
          AppMethodBeat.o(69458);
          return false;
          bool = false;
          break label732;
        }
      }
      paramn = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramn;
      this.Dbl = getInput();
      this.Dbl.putParcelable("key_pay_info", this.mPayInfo);
      this.Dbl.putParcelable("key_bankcard", this.CQi);
      if (!bu.isNullOrNil(this.jth)) {
        this.Dbl.putString("key_pwd1", this.jth);
      }
      this.Dbl.putString("kreq_token", paramn.getToken());
      this.Dbl.putParcelable("key_authen", paramn.CZU);
      localObject1 = this.Dbl;
      if (!paramn.CZS)
      {
        bool = true;
        label980:
        ((Bundle)localObject1).putBoolean("key_need_verify_sms", bool);
        this.Dbl.putString("key_mobile", this.CQi.field_mobile);
        this.Dbl.putInt("key_err_code", paramInt2);
        this.Dbl.putParcelable("key_orders", this.yvS);
        if (!bu.isNullOrNil(paramString)) {
          break label1446;
        }
        paramString = getString(2131765705, new Object[] { this.CQi.field_desc, this.CQi.field_mobile });
      }
    }
    label1446:
    for (;;)
    {
      com.tencent.mm.ui.base.h.e(this, paramString, "", getString(2131765704), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69406);
          WalletPayUI.this.Dbl.putInt("key_pay_flag", 3);
          WalletPayUI.this.aw(WalletPayUI.this.Dbl);
          AppMethodBeat.o(69406);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69407);
          if (WalletPayUI.this.isTransparent()) {
            WalletPayUI.this.finish();
          }
          AppMethodBeat.o(69407);
        }
      });
      AppMethodBeat.o(69458);
      return true;
      bool = false;
      break label980;
      this.mPayInfo.FEq = paramInt2;
      eHi();
      AppMethodBeat.o(69458);
      return true;
      this.mPayInfo.FEq = paramInt2;
      bool = false;
      if (paramInt2 == 100100) {
        bool = true;
      }
      if (this.Das == null) {
        this.Das = new a(this, this);
      }
      this.Das.b(bool, this.mPayInfo.dwi, this.mPayInfo.dmw);
      ae.i(this.TAG, "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool)));
      AppMethodBeat.o(69458);
      return true;
      if ((this.CQi == null) || (this.yvS == null)) {
        break;
      }
      this.CQi.Dmi = this.yvS.dmw;
      if ((this.CQh != null) && (this.CQh.size() > 1)) {
        d(true, 4, paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(69458);
        return true;
        c(true, 4, paramString);
      }
      if (!(paramn instanceof com.tencent.mm.plugin.wallet.pay.a.c.f)) {
        break;
      }
      this.DbI = true;
      eHz();
      if (paramInt2 == 416)
      {
        ae.e(this.TAG, "errCode is 416 need real name verify!");
        this.mPayResultType = 2;
        this.DbF = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
        paramString.putString("realname_verify_process_jump_plugin", "wallet");
        if (this.mPayInfo != null) {}
        for (paramInt1 = this.mPayInfo.dDH;; paramInt1 = 0)
        {
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramn, paramString, paramInt1);
          AppMethodBeat.o(69458);
          return bool;
        }
      }
      this.mPayResultType = 3;
      ae.i(this.TAG, "errCode is %d , not need real name verify!", new Object[] { Integer.valueOf(paramInt2) });
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean shouldEnsureSoterConnection()
  {
    return true;
  }
  
  protected final void ul(boolean paramBoolean)
  {
    AppMethodBeat.i(69446);
    if ((paramBoolean) && (!eHA()))
    {
      AppMethodBeat.o(69446);
      return;
    }
    if (this.Dar != null)
    {
      this.Dbe = com.tencent.mm.plugin.wallet_core.ui.e.DtH.a(this.yvS);
      com.tencent.mm.plugin.wallet.a.j localj = this.Dbe.aGi(this.Dar.Doq);
      if ((localj == null) || (localj.CYE != 0.0D)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.DbK != null)
      {
        if (this.DbK.Dae == 0)
        {
          ae.i(this.TAG, "need real name,stop");
          b(this.DbK);
          AppMethodBeat.o(69446);
          return;
        }
        if ((this.DbK.Dae == 1) && (i != 0))
        {
          ae.i(this.TAG, "need real name, zero stop");
          b(this.DbK);
        }
      }
      if (this.Daf != null)
      {
        if ((this.Daf.CZN == 1) && (!bu.isNullOrNil(this.Daf.kCZ)) && (!bu.isNullOrNil(this.Daf.kDa)) && (!bu.isNullOrNil(this.Daf.CZO)))
        {
          if ((this.mPayInfo != null) && (this.yvS != null) && (this.yvS.DpP != null) && (this.yvS.DpP.size() > 0))
          {
            if (this.mPayInfo.dDH != 8) {
              break label371;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.yvS.DpP.get(0)).dmx });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.Daf.CZO, "", this.Daf.kDa, this.Daf.kCZ, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69389);
                ae.i(WalletPayUI.this.TAG, "click continue pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.yvS != null) && (WalletPayUI.this.yvS.DpP != null) && (WalletPayUI.this.yvS.DpP.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.dDH != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.g.yxI.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.yvS.DpP.get(0)).dmx });
                }
                for (;;)
                {
                  WalletPayUI.g(WalletPayUI.this);
                  AppMethodBeat.o(69389);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.g.yxI.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.yvS.DpP.get(0)).dmx });
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69390);
                ae.i(WalletPayUI.this.TAG, "click cancel pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.yvS != null) && (WalletPayUI.this.yvS.DpP != null) && (WalletPayUI.this.yvS.DpP.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.dDH != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.g.yxI.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.yvS.DpP.get(0)).dmx });
                }
                for (;;)
                {
                  WalletPayUI.this.finish();
                  AppMethodBeat.o(69390);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.g.yxI.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.yvS.DpP.get(0)).dmx });
                }
              }
            });
            AppMethodBeat.o(69446);
            return;
            label371:
            com.tencent.mm.plugin.report.service.g.yxI.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.yvS.DpP.get(0)).dmx });
          }
        }
        if ((this.Daf.CZN == 2) && (!bu.isNullOrNil(this.Daf.CZO)) && (!bu.isNullOrNil(this.Daf.CZP)))
        {
          ae.i(this.TAG, "pay has been blocked");
          if ((this.mPayInfo != null) && (this.yvS != null) && (this.yvS.DpP != null) && (this.yvS.DpP.size() > 0))
          {
            if (this.mPayInfo.dDH != 8) {
              break label624;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.yvS.DpP.get(0)).dmx });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.Daf.CZO, "", this.Daf.CZP, false, new WalletPayUI.6(this));
            AppMethodBeat.o(69446);
            return;
            label624:
            com.tencent.mm.plugin.report.service.g.yxI.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.yvS.DpP.get(0)).dmx });
          }
        }
      }
      eHv();
      AppMethodBeat.o(69446);
      return;
    }
  }
  
  protected final void um(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(69451);
    if (!aVv())
    {
      AppMethodBeat.o(69451);
      return;
    }
    this.Dau = false;
    ae.i(this.TAG, "pay with old bankcard! from statck %s", new Object[] { bu.fpN().toString() });
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label230;
      }
    }
    label230:
    for (Object localObject = "";; localObject = this.mPayInfo.dmw)
    {
      af.f(i, (String)localObject, 8, "");
      if (this.Dby != null)
      {
        ae.w(this.TAG, "close previous cashier dialog");
        this.Dby.dismiss();
      }
      this.Dau = false;
      if (!eHa()) {
        break label242;
      }
      this.Dby = new WcPayCashierDialog(getContext());
      localObject = (WcPayCashierDialog)this.Dby;
      PayInfo localPayInfo = this.mPayInfo;
      Orders localOrders = this.yvS;
      FavorPayInfo localFavorPayInfo = this.Dar;
      Bankcard localBankcard = this.CQi;
      if (!this.Dbi) {
        bool = true;
      }
      ((WcPayCashierDialog)localObject).a(localPayInfo, localOrders, localFavorPayInfo, localBankcard, bool, paramBoolean);
      ((WcPayCashierDialog)localObject).DCL = new WcPayCashierDialog.a()
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, Bankcard paramAnonymousBankcard)
        {
          AppMethodBeat.i(69392);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            ae.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.g.yxI.n(965L, 3L, 1L);
            AppMethodBeat.o(69392);
            return;
          }
          WalletPayUI.i(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.Dar = paramAnonymousFavorPayInfo;
          WalletPayUI.this.CQi = paramAnonymousBankcard;
          paramAnonymousBankcard = WalletPayUI.this.TAG;
          int i;
          if (WalletPayUI.this.Dar == null)
          {
            paramAnonymousFavorPayInfo = "";
            ae.i(paramAnonymousBankcard, "WalletPwdDialog showAlert with favinfo %s", new Object[] { paramAnonymousFavorPayInfo });
            if (!bu.isNullOrNil(paramAnonymousString))
            {
              if (WalletPayUI.this.mPayInfo != null) {
                break label193;
              }
              i = 0;
              label131:
              if (WalletPayUI.this.mPayInfo != null) {
                break label208;
              }
            }
          }
          label193:
          label208:
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.dmw)
          {
            af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.jth = paramAnonymousString;
            WalletPayUI.this.un(false);
            com.tencent.mm.plugin.wallet_core.utils.f.eMB();
            AppMethodBeat.o(69392);
            return;
            paramAnonymousFavorPayInfo = WalletPayUI.this.Dar.toString();
            break;
            i = WalletPayUI.this.mPayInfo.dDH;
            break label131;
          }
        }
        
        public final void eFU()
        {
          AppMethodBeat.i(69394);
          ae.i(WalletPayUI.this.TAG, "click add new bankcard");
          Object localObject = com.tencent.mm.plugin.wallet_core.model.g.eII();
          if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bnS())
          {
            com.tencent.mm.ui.base.h.c(WalletPayUI.this.getContext(), ((com.tencent.mm.plugin.wallet_core.model.g)localObject).wRu, WalletPayUI.this.getString(2131755906), true);
            AppMethodBeat.o(69394);
            return;
          }
          int i;
          if (WalletPayUI.this.mPayInfo == null)
          {
            i = 0;
            if (WalletPayUI.this.mPayInfo != null) {
              break label138;
            }
          }
          label138:
          for (localObject = "";; localObject = WalletPayUI.this.mPayInfo.dmw)
          {
            af.f(i, (String)localObject, 14, "");
            WalletPayUI.this.Dby.dismiss();
            WalletPayUI.this.Dby = null;
            WalletPayUI.this.eHx();
            AppMethodBeat.o(69394);
            return;
            i = WalletPayUI.this.mPayInfo.dDH;
            break;
          }
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(69393);
          ae.i(WalletPayUI.this.TAG, "cashier dialog canceled");
          WalletPayUI.j(WalletPayUI.this);
          int i;
          if (WalletPayUI.this.mPayInfo == null)
          {
            i = 0;
            if (WalletPayUI.this.mPayInfo != null) {
              break label96;
            }
          }
          label96:
          for (String str = "";; str = WalletPayUI.this.mPayInfo.dmw)
          {
            af.f(i, str, 10, "");
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            AppMethodBeat.o(69393);
            return;
            i = WalletPayUI.this.mPayInfo.dDH;
            break;
          }
        }
      };
      ((WcPayCashierDialog)localObject).show();
      addDialog((Dialog)localObject);
      AppMethodBeat.o(69451);
      return;
      i = this.mPayInfo.dDH;
      break;
    }
    label242:
    if (!this.Dbi) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Dby = com.tencent.mm.plugin.wallet_core.ui.s.a(this, paramBoolean, this.yvS, this.Dar, this.CQi, this.mPayInfo, this.yqw, new s.c()new View.OnClickListener
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(69395);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            ae.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.g.yxI.n(965L, 3L, 1L);
            AppMethodBeat.o(69395);
            return;
          }
          WalletPayUI.k(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.Dar = paramAnonymousFavorPayInfo;
          String str = WalletPayUI.this.TAG;
          if (WalletPayUI.this.Dar == null) {}
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.Dar.toString())
          {
            ae.i(str, "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s", new Object[] { paramAnonymousFavorPayInfo, Boolean.valueOf(paramAnonymousBoolean) });
            if ((WalletPayUI.this.Dar == null) || (!paramAnonymousBoolean)) {
              break;
            }
            WalletPayUI.this.aW(-100, true);
            AppMethodBeat.o(69395);
            return;
          }
          int i;
          if (!bu.isNullOrNil(paramAnonymousString))
          {
            if (WalletPayUI.this.mPayInfo != null) {
              break label232;
            }
            i = 0;
            if (WalletPayUI.this.mPayInfo != null) {
              break label247;
            }
          }
          label232:
          label247:
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.dmw)
          {
            af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.jth = paramAnonymousString;
            WalletPayUI.this.un(false);
            com.tencent.mm.plugin.wallet_core.utils.f.eMB();
            WalletPayUI.this.Dat = null;
            AppMethodBeat.o(69395);
            return;
            i = WalletPayUI.this.mPayInfo.dDH;
            break;
          }
        }
      }, new View.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69396);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i(WalletPayUI.this.TAG, "WalletPwdDialog event1 %s", new Object[] { bu.fpN().toString() });
          WalletPayUI.this.Dar = ((FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUI.this.Dar != null) {
            WalletPayUI.this.Dar.Dou = "";
          }
          WalletPayUI.this.d(false, 0, "");
          WalletPayUI.this.Dby.dismiss();
          WalletPayUI.this.jth = null;
          WalletPayUI.this.Dby = null;
          WalletPayUI.this.Dat = null;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69396);
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          int i = 0;
          AppMethodBeat.i(69397);
          ae.i(WalletPayUI.this.TAG, "WalletPwdDialog event2 %s", new Object[] { bu.fpN().toString() });
          WalletPayUI.l(WalletPayUI.this);
          WalletPayUI.j(WalletPayUI.this);
          if (WalletPayUI.this.mPayInfo == null) {
            if (WalletPayUI.this.mPayInfo != null) {
              break label151;
            }
          }
          label151:
          for (String str = "";; str = WalletPayUI.this.mPayInfo.dmw)
          {
            af.f(i, str, 10, "");
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            WalletPayUI.this.jth = null;
            WalletPayUI.this.Dby = null;
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            WalletPayUI.this.Dat = null;
            AppMethodBeat.o(69397);
            return;
            i = WalletPayUI.this.mPayInfo.dDH;
            break;
          }
        }
      });
      this.Dat = ((com.tencent.mm.plugin.wallet_core.ui.f)this.Dby);
      AppMethodBeat.o(69451);
      return;
    }
  }
  
  protected void un(boolean paramBoolean)
  {
    AppMethodBeat.i(69467);
    com.tencent.mm.plugin.wallet.pay.a.a.b localb = com.tencent.mm.plugin.wallet.pay.a.a.a(eHs(), this.yvS, paramBoolean);
    if (this.yvS != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_reqKey", this.yvS.dmw);
      if ((this.yvS.DpP != null) && (this.yvS.DpP.size() > 0)) {
        localBundle.putString("key_TransId", ((Orders.Commodity)this.yvS.DpP.get(0)).dmx);
      }
      localBundle.putLong("key_SessionId", this.Dbz);
      localb.setProcessName("PayProcess");
      localb.setProcessBundle(localBundle);
    }
    if (this.mPayInfo != null)
    {
      if ((this.mPayInfo.dDH != 6) || (this.mPayInfo.FEn != 100)) {
        break label255;
      }
      localb.setScene(100);
    }
    for (;;)
    {
      doSceneProgress(localb);
      if ((this.mPayInfo != null) && (8 == this.mPayInfo.dDH) && (this.mPayInfo.hwN != null))
      {
        long l = this.mPayInfo.hwN.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.g.yxI.f(13956, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - l) });
      }
      AppMethodBeat.o(69467);
      return;
      label255:
      localb.setScene(this.mPayInfo.dDH);
    }
  }
  
  protected final void updateView()
  {
    AppMethodBeat.i(69439);
    if ((this.yvS != null) && (this.yvS.DpP != null) && (this.yvS.DpP.size() > 0))
    {
      this.Dbn.setText(com.tencent.mm.wallet_core.ui.f.C(this.yvS.dmz));
      this.Dbq.setText(com.tencent.mm.wallet_core.ui.f.bai(this.yvS.wSq));
      this.Dbx.notifyDataSetChanged();
      if (this.yvS.DpP.size() > 1)
      {
        this.Dbt.setVisibility(0);
        this.Dbo.setText(getString(2131765708, new Object[] { ((Orders.Commodity)this.yvS.DpP.get(0)).desc, this.yvS.DpP.size() }));
        this.Dbk = false;
      }
    }
    else
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.dDH == 48)) {
        this.Dbo.setText(2131762090);
      }
      this.Dbr.setVisibility(8);
      this.Dbs.setVisibility(8);
      this.DbA.setVisibility(8);
      this.DbB.setVisibility(8);
      this.yvk.setText(2131765657);
      if ((this.CQi == null) || (!this.CQi.eIy())) {
        break label542;
      }
      if (bu.isNullOrNil(this.CQi.field_forbidWord)) {
        break label522;
      }
      this.Dbr.setText(this.CQi.field_forbidWord);
      this.Dbr.setVisibility(4);
      this.Dbs.setVisibility(8);
      com.tencent.mm.plugin.wallet.a.s.eGW();
      if (com.tencent.mm.plugin.wallet.a.s.eGX().eJI()) {
        eHp();
      }
      label329:
      com.tencent.mm.plugin.wallet.a.s.eGW();
      if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJI())
      {
        com.tencent.mm.plugin.wallet.a.s.eGW();
        if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJJ()) {
          break label590;
        }
      }
    }
    label424:
    label571:
    label590:
    for (int i = 1;; i = 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131306782);
      if ((i != 0) && (this.Dar != null) && (this.Dbe != null) && (this.Dbf) && (this.yvS != null))
      {
        eHr();
        this.Dbv.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69423);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            int i;
            if (WalletPayUI.this.mPayInfo == null)
            {
              i = 0;
              if (WalletPayUI.this.mPayInfo != null) {
                break label137;
              }
            }
            label137:
            for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dmw)
            {
              af.f(i, paramAnonymousView, 12, "");
              com.tencent.mm.plugin.wallet_core.ui.n.a(WalletPayUI.this.getContext(), WalletPayUI.this.yvS, WalletPayUI.this.Dar.Doq, new n.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  int j = 1;
                  AppMethodBeat.i(69422);
                  WalletPayUI.this.Dar = paramAnonymous2FavorPayInfo;
                  Object localObject = WalletPayUI.this.TAG;
                  int i;
                  label82:
                  label98:
                  boolean bool;
                  if (paramAnonymous2FavorPayInfo == null)
                  {
                    paramAnonymous2FavorPayInfo = "";
                    ae.i((String)localObject, "WalletFavorDialog onSelectionDone %s", new Object[] { paramAnonymous2FavorPayInfo });
                    if (WalletPayUI.this.Dar != null)
                    {
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label467;
                      }
                      i = 0;
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label485;
                      }
                      paramAnonymous2FavorPayInfo = "";
                      af.f(i, paramAnonymous2FavorPayInfo, 15, WalletPayUI.this.Dar.Doq);
                      if ((WalletPayUI.this.CQi != null) && (!com.tencent.mm.plugin.wallet_core.ui.d.a(WalletPayUI.this.Dar, WalletPayUI.this.CQi))) {
                        break label502;
                      }
                      WalletPayUI.this.Dbs.setVisibility(8);
                      WalletPayUI.this.yvk.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69419);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bd(paramAnonymous3View);
                          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                          ae.i(WalletPayUI.this.TAG, "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
                          WalletPayUI.this.c(false, 0, "");
                          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                          AppMethodBeat.o(69419);
                        }
                      });
                      bool = true;
                    }
                  }
                  for (;;)
                  {
                    label197:
                    ae.i(WalletPayUI.this.TAG, "needBindBankCard %s", new Object[] { Boolean.valueOf(bool) });
                    WalletPayUI.c(WalletPayUI.this).setVisibility(0);
                    WalletPayUI.d(WalletPayUI.this).setVisibility(0);
                    if (WalletPayUI.this.Dar != null)
                    {
                      WalletPayUI.this.Dbe = com.tencent.mm.plugin.wallet_core.ui.e.DtH.a(WalletPayUI.this.yvS);
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.Dbe.aGi(WalletPayUI.this.Dar.Doq);
                      if ((paramAnonymous2FavorPayInfo != null) && (paramAnonymous2FavorPayInfo.CYE == 0.0D))
                      {
                        WalletPayUI.c(WalletPayUI.this).setVisibility(8);
                        WalletPayUI.d(WalletPayUI.this).setVisibility(8);
                        bool = false;
                      }
                    }
                    for (i = j;; i = 0)
                    {
                      if (!bool)
                      {
                        WalletPayUI.this.Dbr.setVisibility(8);
                        WalletPayUI.this.Dbs.setVisibility(0);
                        WalletPayUI.this.yvk.setOnClickListener(new View.OnClickListener()
                        {
                          public final void onClick(View paramAnonymous3View)
                          {
                            AppMethodBeat.i(69421);
                            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                            localb.bd(paramAnonymous3View);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                            WalletPayUI.this.eHu();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(69421);
                          }
                        });
                      }
                      if (i != 0) {
                        WalletPayUI.this.Dbs.setVisibility(8);
                      }
                      WalletPayUI.this.eHr();
                      AppMethodBeat.o(69422);
                      return;
                      paramAnonymous2FavorPayInfo = paramAnonymous2FavorPayInfo.toString();
                      break;
                      label467:
                      i = WalletPayUI.this.mPayInfo.dDH;
                      break label82;
                      label485:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.mPayInfo.dmw;
                      break label98;
                      label502:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.Dbe.aGi(WalletPayUI.this.Dar.Doq);
                      if ((paramAnonymous2FavorPayInfo == null) || (!WalletPayUI.this.CQi.eIy())) {
                        break label644;
                      }
                      com.tencent.mm.plugin.wallet.a.s.eGW();
                      localObject = com.tencent.mm.plugin.wallet.a.s.eGX().CRg;
                      double d = paramAnonymous2FavorPayInfo.CYE;
                      if ((localObject == null) || (((Bankcard)localObject).Dmj >= d)) {
                        break label644;
                      }
                      ae.i(WalletPayUI.this.TAG, "balance not meet");
                      WalletPayUI.this.Dbs.setVisibility(8);
                      WalletPayUI.this.yvk.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69420);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bd(paramAnonymous3View);
                          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                          ae.i(WalletPayUI.this.TAG, "Balance amount not meet, after favor selection! payWithNewBankcard");
                          WalletPayUI.this.c(false, 0, "");
                          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                          AppMethodBeat.o(69420);
                        }
                      });
                      bool = true;
                      break label197;
                    }
                    label644:
                    bool = false;
                  }
                }
              }, null);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69423);
              return;
              i = WalletPayUI.this.mPayInfo.dDH;
              break;
            }
          }
        });
        localLinearLayout.setVisibility(0);
        if ((this.yvS == null) || (this.CQh == null) || (this.mPayInfo == null)) {
          break label571;
        }
        this.yvk.setClickable(true);
        this.yvk.setEnabled(true);
      }
      for (;;)
      {
        if (this.yvS == null) {
          this.Dbs.setVisibility(8);
        }
        AppMethodBeat.o(69439);
        return;
        this.Dbo.setText(((Orders.Commodity)this.yvS.DpP.get(0)).desc);
        this.Dbt.setVisibility(8);
        break;
        com.tencent.mm.plugin.wallet.a.s.eGW();
        if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJI()) {
          break label329;
        }
        eHp();
        break label329;
        com.tencent.mm.plugin.wallet.a.s.eGW();
        if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJJ()) {
          break label329;
        }
        eHp();
        break label329;
        localLinearLayout.setVisibility(8);
        break label424;
        this.yvk.setClickable(false);
        this.yvk.setEnabled(false);
      }
    }
  }
  
  protected final class a
  {
    protected a() {}
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(69426);
      WalletPayUI.this.Dbw.removeAllViews();
      int i;
      ViewGroup.LayoutParams localLayoutParams;
      int j;
      label41:
      View localView;
      TextView localTextView1;
      TextView localTextView2;
      Orders.Commodity localCommodity;
      String str2;
      String str1;
      label290:
      label333:
      if (WalletPayUI.this.mCount == 0)
      {
        i = 0;
        localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
        j = 0;
        if (j >= i) {
          break label565;
        }
        localView = ((LayoutInflater)WalletPayUI.this.getSystemService("layout_inflater")).inflate(2131496004, null);
        localTextView1 = (TextView)localView.findViewById(2131306777);
        localTextView2 = (TextView)localView.findViewById(2131306798);
        localCommodity = (Orders.Commodity)WalletPayUI.this.yvS.DpP.get(j);
        str2 = "";
        str1 = str2;
        if (WalletPayUI.this.mPayInfo != null) {
          if ((WalletPayUI.this.mPayInfo.dDH != 32) && (WalletPayUI.this.mPayInfo.dDH != 33) && (WalletPayUI.this.mPayInfo.dDH != 31))
          {
            str1 = str2;
            if (WalletPayUI.this.mPayInfo.dDH != 48) {}
          }
          else
          {
            str1 = WalletPayUI.this.mPayInfo.hwN.getString("extinfo_key_1", "");
            if (bu.isNullOrNil(str1)) {
              break label443;
            }
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.storage.an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUK(str1);
            if (localan == null) {
              break label418;
            }
            str1 = localan.adG();
          }
        }
        label252:
        if (localCommodity != null)
        {
          if (bu.isNullOrNil(str1)) {
            break label461;
          }
          localTextView2.setText(str1);
          localTextView2.setVisibility(0);
          ((TextView)localView.findViewById(2131306799)).setVisibility(0);
          if (bu.isNullOrNil(localCommodity.desc)) {
            break label530;
          }
          localTextView1.setText(localCommodity.desc);
          localTextView1.setVisibility(8);
          ((TextView)localView.findViewById(2131306779)).setVisibility(8);
          if ((bu.isNullOrNil(str1)) && (bu.isNullOrNil(localCommodity.wSf))) {
            break label555;
          }
          localView.setVisibility(0);
        }
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        localView.measure(-2, -2);
        WalletPayUI.this.Dbw.addView(localView);
        j += 1;
        break label41;
        if (WalletPayUI.this.Dbk)
        {
          i = WalletPayUI.this.mCount;
          break;
        }
        i = 1;
        break;
        label418:
        ae.e(WalletPayUI.this.TAG, "can not found contact for user::".concat(String.valueOf(str1)));
        str1 = str2;
        break label252;
        label443:
        ae.e(WalletPayUI.this.TAG, "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        str1 = str2;
        break label252;
        label461:
        if (!bu.isNullOrNil(localCommodity.wSf))
        {
          localTextView2.setText(localCommodity.wSf);
          localTextView2.setVisibility(0);
          ((TextView)localView.findViewById(2131306799)).setVisibility(0);
          break label290;
        }
        ((TextView)localView.findViewById(2131306799)).setVisibility(8);
        localTextView2.setVisibility(8);
        break label290;
        label530:
        ((TextView)localView.findViewById(2131306779)).setVisibility(8);
        localTextView1.setVisibility(8);
        break label333;
        label555:
        localView.setVisibility(8);
      }
      label565:
      AppMethodBeat.o(69426);
    }
  }
  
  final class b
  {
    int aHQ;
    WeakReference<WalletPayUI> lRT;
    long timestamp;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
 * JD-Core Version:    0.7.0.1
 */