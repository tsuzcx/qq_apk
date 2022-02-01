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
import com.tencent.mm.g.a.wz;
import com.tencent.mm.g.a.xj;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.g.a.xk.a;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.plugin.wallet_core.ui.n.b;
import com.tencent.mm.plugin.wallet_core.ui.s.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ai;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.c.m.a;
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
  private static boolean zQN;
  private static List<b> zQO;
  public String TAG;
  private boolean isPaySuccess;
  public String ixc;
  protected int mCount;
  protected PayInfo mPayInfo;
  private String vCS;
  protected com.tencent.mm.plugin.wallet.a vCr;
  private com.tencent.mm.sdk.b.c vFM;
  protected Button vHH;
  protected Orders vIq;
  protected ArrayList<Bankcard> zGg;
  protected Bankcard zGh;
  private com.tencent.mm.plugin.wallet.pay.a.d zPR;
  private com.tencent.mm.plugin.wallet.pay.a.c.f zQP;
  protected com.tencent.mm.plugin.wallet_core.ui.d zQQ;
  private boolean zQR;
  protected boolean zQS;
  private d.a zQT;
  protected boolean zQU;
  protected String zQV;
  protected boolean zQW;
  public Bundle zQX;
  protected boolean zQY;
  protected TextView zQZ;
  public FavorPayInfo zQd;
  private a zQe;
  com.tencent.mm.plugin.wallet_core.ui.f zQf;
  private boolean zQg;
  private Runnable zRA;
  private b zRB;
  private long zRC;
  protected TextView zRa;
  private TextView zRb;
  protected TextView zRc;
  protected TextView zRd;
  protected TextView zRe;
  protected ImageView zRf;
  private TextView zRg;
  private TextView zRh;
  protected LinearLayout zRi;
  protected a zRj;
  public Dialog zRk;
  private long zRl;
  private TextView zRm;
  private LinearLayout zRn;
  private boolean zRo;
  private boolean zRp;
  private boolean zRq;
  private boolean zRr;
  private boolean zRs;
  private int zRt;
  private boolean zRu;
  private boolean zRv;
  private com.tencent.mm.plugin.wallet.pay.a.c.f zRw;
  private boolean zRx;
  private boolean zRy;
  private int zRz;
  
  static
  {
    AppMethodBeat.i(69482);
    zQN = false;
    zQO = new ArrayList();
    AppMethodBeat.o(69482);
  }
  
  public WalletPayUI()
  {
    AppMethodBeat.i(69427);
    this.TAG = "MicroMsg.WalletPayUI";
    this.vIq = null;
    this.zQP = null;
    this.mCount = 0;
    this.ixc = null;
    this.zGg = null;
    this.zGh = null;
    this.zQd = null;
    this.zQQ = null;
    this.zQR = false;
    this.isPaySuccess = false;
    this.zQS = false;
    this.zQU = false;
    this.zQV = "";
    this.mPayInfo = null;
    this.zQW = false;
    this.zQX = null;
    this.zQY = false;
    this.zRl = 0L;
    this.zRo = true;
    this.zRp = false;
    this.zRq = false;
    this.zRr = false;
    this.zRs = false;
    this.zRt = -1;
    this.zRu = false;
    this.zRv = false;
    this.vCr = null;
    this.zRx = false;
    this.zRy = false;
    this.zPR = null;
    this.zRz = 0;
    this.zRA = new WalletPayUI.1(this);
    this.zRC = 0L;
    this.vFM = new com.tencent.mm.sdk.b.c() {};
    this.zQg = false;
    AppMethodBeat.o(69427);
  }
  
  private void Ro(int paramInt)
  {
    AppMethodBeat.i(69428);
    this.zRz = paramInt;
    ad.i(this.TAG, "markForceFinish errorType %s %s", new Object[] { Integer.valueOf(paramInt), bt.eGN().toString() });
    AppMethodBeat.o(69428);
  }
  
  private void a(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    AppMethodBeat.i(69456);
    ad.i(this.TAG, "stopRealname realnameGuideFlag %s guide_type %s", new Object[] { paramf.dCT, Integer.valueOf(paramf.zPQ) });
    label109:
    Object localObject;
    label150:
    int j;
    if (("1".equals(paramf.dCT)) || ("2".equals(paramf.dCT)))
    {
      this.zRw = paramf;
      this.zPR = paramf.zPR;
      this.zRu = true;
      this.vIq = paramf.vIq;
      if (this.vIq == null) {
        break label523;
      }
      i = this.vIq.Afx.size();
      this.mCount = i;
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("get mOrders! bankcardTag : ");
      if (this.vIq == null) {
        break label528;
      }
      paramf = Integer.valueOf(this.vIq.zWA);
      ad.d((String)localObject, paramf);
      aKT();
      if ((this.vIq != null) && (this.vIq.Afy != null))
      {
        this.zQQ = com.tencent.mm.plugin.wallet_core.ui.e.Ajp.a(this.vIq);
        if (this.zQQ != null)
        {
          if (this.zQQ.edL().size() > 0) {
            this.zQR = true;
          }
          this.zQd = this.zQQ.aup(this.vIq.Afy.zOr);
          this.zQd.Aeb = this.zQQ.auq(this.zQd.Aeb);
          ad.i(this.TAG, "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", new Object[] { this.vIq.Afy.zOr, this.zQd.Aeb, this.zQd.Aeb, this.zQd.toString() });
        }
      }
      if ((this.vIq != null) && (this.zGg != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.vIq);
        paramf = com.tencent.mm.plugin.report.service.h.vKh;
        j = this.mPayInfo.dtb;
        com.tencent.mm.plugin.wallet.a.s.dZT();
        if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecF()) {
          break label534;
        }
      }
    }
    label523:
    label528:
    label534:
    for (int i = 2;; i = 1)
    {
      paramf.f(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.vIq.dcH * 100.0D)), this.vIq.uop });
      if ((this.vIq == null) || (this.vIq.Afx == null)) {
        break label598;
      }
      paramf = new LinkedList();
      localObject = this.vIq.Afx.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramf.add(((Orders.Commodity)((Iterator)localObject).next()).dcF);
      }
      this.zRw = null;
      break;
      i = 0;
      break label109;
      paramf = "";
      break label150;
    }
    if (paramf.size() > 0)
    {
      localObject = new xj();
      ((xj)localObject).dDv.dDx = paramf;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.vCr != null) {
        this.vCr.ce(10001, (String)paramf.get(0));
      }
    }
    label598:
    if ((this.vIq != null) && (this.vIq.AfV != null) && (this.vIq.AfV.AgS == 1) && (!bt.isNullOrNil(this.vIq.AfV.uns)))
    {
      this.zQU = true;
      this.zQV = this.vIq.AfV.uns;
    }
    com.tencent.mm.plugin.wallet.a.s.dZT();
    this.zGg = com.tencent.mm.plugin.wallet.a.s.dZU().sD(eay());
    if (!bt.isNullOrNil(this.zQV))
    {
      this.zGh = eav();
      paramf = bt.by(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!bt.isNullOrNil(paramf)) {
        this.zGh = atH(paramf);
      }
      this.vHH.setClickable(true);
      if (bt.isNullOrNil(com.tencent.mm.plugin.wallet_core.model.s.ecc().Aiv)) {
        break label1031;
      }
      this.zRg.setVisibility(0);
      this.zRg.setText(com.tencent.mm.plugin.wallet_core.model.s.ecc().Aiv);
      label773:
      if ((this.vIq != null) && (this.zGg != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.vIq);
        paramf = com.tencent.mm.plugin.report.service.h.vKh;
        j = this.mPayInfo.dtb;
        com.tencent.mm.plugin.wallet.a.s.dZT();
        if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecF()) {
          break label1052;
        }
        i = 2;
        label832:
        paramf.f(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.vIq.dcH * 100.0D)), this.vIq.uop });
      }
      if (this.zRp) {
        aF(0, false);
      }
      if (getPayInfo().Cos != null) {
        break label1057;
      }
    }
    label1031:
    label1052:
    label1057:
    for (long l = 0L;; l = getPayInfo().Cos.getLong("wallet_pay_key_check_time"))
    {
      if (l > 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(641L, 4L, 1L, true);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(641L, 5L, bt.vM(l), true);
      }
      if (this.zRC > 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(641L, 7L, 1L, true);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(641L, 8L, bt.vM(this.zRC), true);
      }
      AppMethodBeat.o(69456);
      return;
      com.tencent.mm.plugin.wallet.a.s.dZT();
      this.zGh = com.tencent.mm.plugin.wallet.a.s.dZU().a(null, null, eay(), false);
      break;
      this.zRg.setVisibility(8);
      this.zRg.setText("");
      break label773;
      i = 1;
      break label832;
    }
  }
  
  private Bankcard atH(String paramString)
  {
    AppMethodBeat.i(69461);
    com.tencent.mm.plugin.wallet.a.s.dZT();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.dZU().sC(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (bt.nullAsNil(paramString).equals(localBankcard.field_bindSerial))
        {
          ad.i(this.TAG, "hy: get given bankcard");
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
    if ("1".equals(paramf.dCT))
    {
      ad.i(this.TAG, "need realname verify");
      this.zRr = true;
      paramf = new Bundle();
      paramf.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
      paramf.putString("realname_verify_process_jump_plugin", "wallet");
      isTransparent();
      if (this.mPayInfo != null) {
        i = this.mPayInfo.dtb;
      }
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf, null, i);
      AppMethodBeat.o(69474);
      return bool;
    }
    if ("2".equals(paramf.dCT))
    {
      ad.i(this.TAG, "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf.dCU, paramf.dCX, paramf.dCV, paramf.dCW, isTransparent(), null);
      AppMethodBeat.o(69474);
      return bool;
    }
    ad.i(this.TAG, "realnameGuideFlag =  " + paramf.dCT);
    AppMethodBeat.o(69474);
    return false;
  }
  
  private boolean dZX()
  {
    AppMethodBeat.i(69449);
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fsp, Integer.valueOf(0))).intValue();
    if ((com.tencent.mm.sdk.a.b.eEQ()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
      i = 1;
    }
    if ((i == 1) || ((this.vIq != null) && (this.vIq.AfU == 1)))
    {
      AppMethodBeat.o(69449);
      return true;
    }
    AppMethodBeat.o(69449);
    return false;
  }
  
  private boolean eak()
  {
    AppMethodBeat.i(69430);
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("intent_pay_end")))
    {
      ad.i(this.TAG, "hy: pay end. finish the activity");
      if (localBundle.getBoolean("intent_pay_end", false))
      {
        ad.d(this.TAG, "pay done... errCode:" + localBundle.getInt("intent_pay_end_errcode"));
        ad.d(this.TAG, "pay done INTENT_PAY_APP_URL:" + localBundle.getString("intent_pay_app_url"));
        ad.d(this.TAG, "pay done INTENT_PAY_END:" + localBundle.getBoolean("intent_pay_end", false));
        l(-1, getIntent());
      }
      for (this.isPaySuccess = true;; this.isPaySuccess = false)
      {
        AppMethodBeat.o(69430);
        return true;
        ad.d(this.TAG, "pay cancel");
        l(0, getIntent());
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
    ad.i(this.TAG, "hy: pay not end");
    AppMethodBeat.o(69430);
    return false;
  }
  
  private void eam()
  {
    AppMethodBeat.i(69440);
    if (this.vIq == null)
    {
      ad.e(this.TAG, "updatePaymentMethodForFavor mOrders is null");
      AppMethodBeat.o(69440);
      return;
    }
    this.zRe.setVisibility(8);
    this.zRd.setVisibility(8);
    this.vHH.setText(2131765657);
    this.zRm.setVisibility(0);
    this.zRn.setVisibility(0);
    View localView = this.zRn.findViewById(2131297100);
    Object localObject = this.zRn.findViewById(2131296454);
    final CheckedTextView localCheckedTextView1;
    final CheckedTextView localCheckedTextView2;
    int i;
    if ("CFT".equals(this.vIq.Afs))
    {
      ((View)localObject).setVisibility(8);
      localCheckedTextView1 = (CheckedTextView)this.zRn.findViewById(2131297092);
      localCheckedTextView2 = (CheckedTextView)this.zRn.findViewById(2131296453);
      localView.setEnabled(true);
      if ((this.vIq == null) || (this.vIq.Afx == null) || (this.vIq.Afx.size() <= 0)) {
        break label772;
      }
      if (this.vIq.Afh != 1) {
        break label574;
      }
      i = 1;
    }
    label772:
    for (;;)
    {
      label200:
      if (this.zGh == null)
      {
        localView.setVisibility(8);
        label213:
        ((View)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69425);
            localCheckedTextView1.setChecked(false);
            localCheckedTextView2.setChecked(true);
            WalletPayUI.a(WalletPayUI.this, true);
            WalletPayUI.e(WalletPayUI.this);
            AppMethodBeat.o(69425);
          }
        });
        this.zRm.setVisibility(0);
        this.zRn.setVisibility(0);
        if (this.zQd == null) {
          break label767;
        }
        this.zQQ = com.tencent.mm.plugin.wallet_core.ui.e.Ajp.a(this.vIq);
        localObject = this.zQQ.aum(this.zQd.Aeb);
        if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).zOq != 0.0D)) {
          break label767;
        }
        this.zRn.setVisibility(8);
        this.zRm.setVisibility(8);
      }
      label486:
      label767:
      for (int j = 1;; j = 0)
      {
        this.zRo = true;
        if (j != 0) {
          this.zRo = false;
        }
        localCheckedTextView1.setChecked(false);
        localCheckedTextView2.setChecked(true);
        ad.i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.vIq.Afz);
        if (this.vIq.Afz == 1)
        {
          this.zRn.findViewById(2131299147).setVisibility(0);
          ((TextView)this.zRn.findViewById(2131299146)).setText(this.vIq.AfA);
          if (!TextUtils.isEmpty(this.vIq.AfB))
          {
            ((TextView)this.zRn.findViewById(2131299862)).setText(" (" + this.vIq.AfB + ")");
            if ((this.zGh != null) && (this.zGh.ebv()) && (!TextUtils.isEmpty(this.zGh.field_forbidWord)))
            {
              localView.setEnabled(false);
              localCheckedTextView1.setVisibility(8);
              ((TextView)this.zRn.findViewById(2131297107)).setText(this.zGh.field_forbidWord);
            }
          }
        }
        for (;;)
        {
          ean();
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
              localCheckedTextView1.setChecked(true);
              localCheckedTextView2.setChecked(false);
              WalletPayUI.a(WalletPayUI.this, false);
              WalletPayUI.e(WalletPayUI.this);
              AppMethodBeat.o(69424);
            }
          });
          break label213;
          ((TextView)this.zRn.findViewById(2131299862)).setText("");
          break label486;
          this.zRn.findViewById(2131299147).setVisibility(8);
          if ((this.zGh != null) && (this.zGh.ebv()) && (!TextUtils.isEmpty(this.zGh.field_forbidWord)))
          {
            localView.setEnabled(false);
            localCheckedTextView1.setVisibility(8);
            ((TextView)this.zRn.findViewById(2131297107)).setText(this.zGh.field_forbidWord);
          }
          else if ((this.zGh != null) && (this.zGh.ebv()) && (TextUtils.isEmpty(this.zGh.field_forbidWord)) && (i == 0))
          {
            localCheckedTextView1.setChecked(true);
            localCheckedTextView2.setChecked(false);
            this.zRo = false;
          }
        }
      }
      label574:
      i = 0;
    }
  }
  
  private void ean()
  {
    AppMethodBeat.i(69441);
    if (this.zRo)
    {
      this.vHH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int j = 0;
          AppMethodBeat.i(69387);
          com.tencent.mm.plugin.wallet.a.s.dZT();
          int i;
          if (com.tencent.mm.plugin.wallet.a.s.dZU().ecG())
          {
            if (WalletPayUI.this.mPayInfo == null)
            {
              i = 0;
              if (WalletPayUI.this.mPayInfo != null) {
                break label141;
              }
              paramAnonymousView = "";
              label45:
              com.tencent.mm.wallet_core.c.af.f(i, paramAnonymousView, 6, "");
            }
          }
          else
          {
            if (WalletPayUI.this.vIq.Afz != 1) {
              break label183;
            }
            com.tencent.mm.plugin.wallet.a.s.dZT();
            if (com.tencent.mm.plugin.wallet.a.s.dZU().ecG())
            {
              if (WalletPayUI.this.mPayInfo != null) {
                break label155;
              }
              i = j;
              label93:
              if (WalletPayUI.this.mPayInfo != null) {
                break label169;
              }
            }
          }
          label141:
          label155:
          label169:
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dcE)
          {
            com.tencent.mm.wallet_core.c.af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.f(WalletPayUI.this);
            AppMethodBeat.o(69387);
            return;
            i = WalletPayUI.this.mPayInfo.dtb;
            break;
            paramAnonymousView = WalletPayUI.this.mPayInfo.dcE;
            break label45;
            i = WalletPayUI.this.mPayInfo.dtb;
            break label93;
          }
          label183:
          ad.i(WalletPayUI.this.TAG, "SimpleReg , assigned userinfo pay! payWithNewBankcard");
          com.tencent.mm.plugin.wallet.a.s.dZT();
          if (com.tencent.mm.plugin.wallet.a.s.dZU().ecG())
          {
            if (WalletPayUI.this.mPayInfo != null) {
              break label258;
            }
            i = 0;
            if (WalletPayUI.this.mPayInfo != null) {
              break label272;
            }
          }
          label258:
          label272:
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dcE)
          {
            com.tencent.mm.wallet_core.c.af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.this.b(false, 0, "");
            AppMethodBeat.o(69387);
            return;
            i = WalletPayUI.this.mPayInfo.dtb;
            break;
          }
        }
      });
      AppMethodBeat.o(69441);
      return;
    }
    this.vHH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69388);
        WalletPayUI.this.ear();
        AppMethodBeat.o(69388);
      }
    });
    AppMethodBeat.o(69441);
  }
  
  private void eas()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(69447);
    com.tencent.mm.plugin.report.service.h.vKh.f(13958, new Object[] { Integer.valueOf(1) });
    if ((this.mPayInfo != null) && (8 == this.mPayInfo.dtb))
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(13955, new Object[] { Integer.valueOf(2) });
      if (this.mPayInfo.Cos != null)
      {
        long l = this.mPayInfo.Cos.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.vKh.f(13956, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    Object localObject;
    if (this.zQd != null)
    {
      this.zQQ = com.tencent.mm.plugin.wallet_core.ui.e.Ajp.a(this.vIq);
      localObject = this.zQQ.aum(this.zQd.Aeb);
      if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).zOq != 0.0D)) {}
    }
    for (;;)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.wallet.a.s.dZT();
        if (com.tencent.mm.plugin.wallet.a.s.dZU().ecG())
        {
          ad.i(this.TAG, "payWithoutPassword zeroPay");
          if (this.mPayInfo == null)
          {
            i = k;
            if (this.mPayInfo != null) {
              break label258;
            }
          }
          label258:
          for (localObject = "";; localObject = this.mPayInfo.dcE)
          {
            com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 3, "");
            eat();
            AppMethodBeat.o(69447);
            return;
            i = this.mPayInfo.dtb;
            break;
          }
        }
        ad.i(this.TAG, "has useful bankcard ! payWithOldBankcard zeroPay");
        eaf();
        AppMethodBeat.o(69447);
        return;
      }
      if (this.zQU)
      {
        ad.i(this.TAG, "hy: start do pay with force use given bankcard");
        if (!bt.isNullOrNil(this.zQV))
        {
          this.zGh = eav();
          eaf();
          AppMethodBeat.o(69447);
          return;
        }
        com.tencent.mm.plugin.wallet.a.s.dZT();
        if (com.tencent.mm.plugin.wallet.a.s.dZU().ecH()) {
          if (this.mPayInfo == null)
          {
            i = 0;
            if (this.mPayInfo != null) {
              break label406;
            }
            localObject = "";
            label370:
            com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 17, "");
          }
        }
        label406:
        do
        {
          b(false, 0, "");
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.dtb;
          break;
          localObject = this.mPayInfo.dcE;
          break label370;
          com.tencent.mm.plugin.wallet.a.s.dZT();
        } while (!com.tencent.mm.plugin.wallet.a.s.dZU().ecG());
        if (this.mPayInfo == null)
        {
          i = 0;
          label440:
          if (this.mPayInfo != null) {
            break label474;
          }
        }
        label474:
        for (localObject = "";; localObject = this.mPayInfo.dcE)
        {
          com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.dtb;
          break label440;
        }
      }
      localObject = bt.by(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!bt.isNullOrNil((String)localObject)) {
        this.zGh = atH((String)localObject);
      }
      if (this.zGh == null)
      {
        if ((this.zGg != null) && (this.zGg.size() > 0))
        {
          ad.i(this.TAG, " no last pay bankcard ! jump to select bankcard!");
          c(false, 8, "");
          AppMethodBeat.o(69447);
          return;
        }
        ad.i(this.TAG, "default bankcard not found! payWithNewBankcard");
        com.tencent.mm.plugin.wallet.a.s.dZT();
        if (com.tencent.mm.plugin.wallet.a.s.dZU().ecH()) {
          if (this.mPayInfo == null)
          {
            i = 0;
            if (this.mPayInfo != null) {
              break label650;
            }
            localObject = "";
            label614:
            com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 17, "");
          }
        }
        label650:
        do
        {
          b(false, 0, "");
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.dtb;
          break;
          localObject = this.mPayInfo.dcE;
          break label614;
          com.tencent.mm.plugin.wallet.a.s.dZT();
        } while (!com.tencent.mm.plugin.wallet.a.s.dZU().ecG());
        if (this.mPayInfo == null)
        {
          i = 0;
          label684:
          if (this.mPayInfo != null) {
            break label718;
          }
        }
        label718:
        for (localObject = "";; localObject = this.mPayInfo.dcE)
        {
          com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.dtb;
          break label684;
        }
      }
      i = this.zGh.a(this.vIq.zWA, this.vIq);
      if (this.vCr != null) {
        this.vCr.ce(10002, "");
      }
      if (i != 0)
      {
        ad.i(this.TAG, "main bankcard(" + i + ") is useless! jump to select bankcard!");
        c(false, i, "");
        AppMethodBeat.o(69447);
        return;
      }
      com.tencent.mm.plugin.wallet.a.s.dZT();
      if (com.tencent.mm.plugin.wallet.a.s.dZU().ecG())
      {
        ad.i(this.TAG, "payWithoutPassword");
        if (this.mPayInfo == null)
        {
          i = j;
          if (this.mPayInfo != null) {
            break label891;
          }
        }
        label891:
        for (localObject = "";; localObject = this.mPayInfo.dcE)
        {
          com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 3, "");
          eat();
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.dtb;
          break;
        }
      }
      ad.i(this.TAG, "has useful bankcard ! payWithOldBankcard");
      eaf();
      AppMethodBeat.o(69447);
      return;
      i = 0;
    }
  }
  
  private void eat()
  {
    AppMethodBeat.i(69448);
    sv(true);
    com.tencent.mm.plugin.wallet_core.utils.f.eft();
    AppMethodBeat.o(69448);
  }
  
  private Bankcard eav()
  {
    AppMethodBeat.i(69460);
    com.tencent.mm.plugin.wallet.a.s.dZT();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.dZU().sC(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (bt.nullAsNil(this.zQV).equals(localBankcard.field_bindSerial))
        {
          ad.i(this.TAG, "hy: get given bankcard");
          AppMethodBeat.o(69460);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(69460);
    return null;
  }
  
  private boolean eaw()
  {
    AppMethodBeat.i(69465);
    if (isTransparent())
    {
      setContentViewVisibility(4);
      ai.r(this, 0);
      AppMethodBeat.o(69465);
      return false;
    }
    setContentViewVisibility(0);
    ai.r(this, getActionbarColor());
    AppMethodBeat.o(69465);
    return true;
  }
  
  private boolean eax()
  {
    AppMethodBeat.i(69468);
    if ((this.vIq != null) && (this.vIq.Afo))
    {
      com.tencent.mm.kernel.g.afC();
      if (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(196614, Boolean.TRUE)).booleanValue())
      {
        Object localObject = getLayoutInflater().inflate(2131496007, null);
        CheckBox localCheckBox = (CheckBox)((View)localObject).findViewById(2131305890);
        fh((View)localObject);
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
  
  private void fh(View paramView)
  {
    AppMethodBeat.i(69469);
    paramView = (TextView)paramView.findViewById(2131302708);
    paramView.setText(Html.fromHtml(String.format(getResources().getString(2131765701), new Object[] { getResources().getString(2131764964) })));
    paramView.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69469);
  }
  
  private void l(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(69437);
    if ((this.mPayInfo != null) && (this.mPayInfo.dtb == 46) && (this.vIq != null))
    {
      paramIntent.putExtra("key_total_fee", this.vIq.dcH);
      ad.i(this.TAG, "sentCancelEvent set fee:%s", new Object[] { Double.valueOf(this.vIq.dcH) });
    }
    xk localxk = new xk();
    localxk.dDy.intent = paramIntent;
    xk.a locala;
    if (this.zRz == 1)
    {
      localxk.dDy.dDz = 1000;
      localxk.dDy.result = paramInt;
      locala = localxk.dDy;
      if (this.mPayInfo != null) {
        break label217;
      }
    }
    label217:
    for (paramIntent = "";; paramIntent = this.mPayInfo.dcE)
    {
      locala.dcE = paramIntent;
      localxk.dDy.dDB = 1;
      if ((this.mPayInfo != null) && (paramInt == 0)) {
        com.tencent.mm.plugin.wallet.pay.a.b.b.ax(this.mPayInfo.dcE, this.mPayInfo.dtb, this.mPayInfo.channel);
      }
      com.tencent.mm.sdk.b.a.ESL.l(localxk);
      AppMethodBeat.o(69437);
      return;
      if (this.zRz != 2) {
        break;
      }
      localxk.dDy.dDz = 1001;
      break;
    }
  }
  
  protected final void aF(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(69455);
    com.tencent.mm.plugin.report.service.h.vKh.f(13958, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.h.vKh.f(13955, new Object[] { Integer.valueOf(4) });
    if (this.mPayInfo == null) {
      if (this.mPayInfo != null) {
        break label226;
      }
    }
    label226:
    for (Object localObject = "";; localObject = this.mPayInfo.dcE)
    {
      com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 11, "");
      localObject = getInput();
      ((Bundle)localObject).putInt("key_main_bankcard_state", paramInt);
      ((Bundle)localObject).putParcelable("key_orders", this.vIq);
      ((Bundle)localObject).putParcelable("key_pay_info", this.mPayInfo);
      ((Bundle)localObject).putParcelable("key_authen", eap());
      ((Bundle)localObject).putString("key_pwd1", this.ixc);
      ((Bundle)localObject).putInt("key_pay_flag", 3);
      ((Bundle)localObject).putInt("key_err_code", -1004);
      ((Bundle)localObject).putParcelable("key_favor_pay_info", this.zQd);
      ((Bundle)localObject).putBoolean("key_is_filter_bank_type", paramBoolean);
      if (this.zGh != null) {
        ((Bundle)localObject).putString("key_is_cur_bankcard_bind_serial", this.zGh.field_bindSerial);
      }
      al((Bundle)localObject);
      AppMethodBeat.o(69455);
      return;
      i = this.mPayInfo.dtb;
      break;
    }
  }
  
  protected final boolean aKT()
  {
    AppMethodBeat.i(69459);
    String str2;
    String str1;
    if ((this.vIq == null) || (this.vIq.Afx == null) || (this.vIq.Afx.size() <= 0))
    {
      ad.w(this.TAG, "mOrders info is Illegal!");
      if ((this.zQP != null) && (this.zQP.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      str2 = getString(2131765550);
      str1 = str2;
      if (this.zQP != null)
      {
        str1 = str2;
        if (!bt.isNullOrNil(this.zQP.errMsg)) {
          str1 = this.zQP.errMsg;
        }
      }
      ad.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.d(getContext(), str1, "", new WalletPayUI.19(this));
      AppMethodBeat.o(69459);
      return false;
    }
    if ((this.zQU) && (!bt.isNullOrNil(this.zQV)) && (eav() == null))
    {
      if ((this.zQP != null) && (this.zQP.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      ad.w(this.TAG, "hy: should use given bankcard, but resolved as null. show error msg and quit");
      str2 = getString(2131765550);
      str1 = str2;
      if (this.zQP != null)
      {
        str1 = str2;
        if (!bt.isNullOrNil(this.zQP.errMsg)) {
          str1 = this.zQP.errMsg;
        }
      }
      ad.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.d(getContext(), str1, "", new WalletPayUI.20(this));
      AppMethodBeat.o(69459);
      return false;
    }
    AppMethodBeat.o(69459);
    return true;
  }
  
  protected void al(Bundle paramBundle)
  {
    AppMethodBeat.i(69471);
    this.zQS = true;
    if (this.vIq != null)
    {
      paramBundle.putInt("key_support_bankcard", this.vIq.zWA);
      paramBundle.putString("key_reqKey", this.vIq.dcE);
      if ((this.vIq.Afx != null) && (this.vIq.Afx.size() > 0)) {
        paramBundle.putString("key_TransId", ((Orders.Commodity)this.vIq.Afx.get(0)).dcF);
      }
      paramBundle.putLong("key_SessionId", this.zRl);
    }
    if (this.mPayInfo != null) {
      paramBundle.putInt("key_scene", this.mPayInfo.dtb);
    }
    if (!eaq()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      paramBundle.putInt("is_deduct_open", this.zRt);
      this.zQT = new WalletPayUI.26(this);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, paramBundle, this.zQT);
      AppMethodBeat.o(69471);
      return;
    }
  }
  
  protected final void b(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69452);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
    com.tencent.mm.plugin.wallet.a.s.dZT();
    ad.d(str, com.tencent.mm.plugin.wallet.a.s.dZU().ecF() + ", need confirm ? " + paramBoolean);
    if (paramBoolean)
    {
      if (!bt.isNullOrNil(paramString)) {
        break label130;
      }
      paramString = Bankcard.ac(this, paramInt);
    }
    label130:
    for (;;)
    {
      com.tencent.mm.ui.base.h.d(this, paramString, "", getString(2131765660), getString(2131755691), new WalletPayUI.11(this), new WalletPayUI.13(this));
      AppMethodBeat.o(69452);
      return;
      eau();
      AppMethodBeat.o(69452);
      return;
    }
  }
  
  public final void c(boolean paramBoolean, final int paramInt, String paramString)
  {
    AppMethodBeat.i(69453);
    ad.d(this.TAG, "pay with select bankcard! need confirm ? ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (!bt.isNullOrNil(paramString)) {
        break label118;
      }
      paramString = Bankcard.ac(this, paramInt);
    }
    label118:
    for (;;)
    {
      com.tencent.mm.ui.base.h.d(this, paramString, "", getString(2131765679), getString(2131755691), new DialogInterface.OnClickListener()new WalletPayUI.15
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69401);
          if (WalletPayUI.m(WalletPayUI.this))
          {
            WalletPayUI.this.su(true);
            AppMethodBeat.o(69401);
            return;
          }
          WalletPayUI.this.aF(paramInt, false);
          AppMethodBeat.o(69401);
        }
      }, new WalletPayUI.15(this));
      AppMethodBeat.o(69453);
      return;
      if (dZX())
      {
        su(true);
        AppMethodBeat.o(69453);
        return;
      }
      aF(paramInt, false);
      AppMethodBeat.o(69453);
      return;
    }
  }
  
  public final void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69472);
    ad.i(this.TAG, "onGenFinish callback");
    if (paramBoolean)
    {
      ad.i(this.TAG, "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.dlK = paramString1;
      this.mPayInfo.dlL = paramString2;
      sv(false);
      com.tencent.mm.plugin.wallet_core.utils.f.eft();
      AppMethodBeat.o(69472);
      return;
    }
    ad.e(this.TAG, "onGenFinish callback, result.isSuccess is false");
    sv(false);
    com.tencent.mm.plugin.wallet_core.utils.f.eft();
    AppMethodBeat.o(69472);
  }
  
  protected final void cE()
  {
    AppMethodBeat.i(69439);
    if ((this.vIq != null) && (this.vIq.Afx != null) && (this.vIq.Afx.size() > 0))
    {
      this.zQZ.setText(com.tencent.mm.wallet_core.ui.e.D(this.vIq.dcH));
      this.zRc.setText(com.tencent.mm.wallet_core.ui.e.aNd(this.vIq.uop));
      this.zRj.notifyDataSetChanged();
      if (this.vIq.Afx.size() > 1)
      {
        this.zRf.setVisibility(0);
        this.zRa.setText(getString(2131765708, new Object[] { ((Orders.Commodity)this.vIq.Afx.get(0)).desc, this.vIq.Afx.size() }));
        this.zQW = false;
      }
    }
    else
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.dtb == 48)) {
        this.zRa.setText(2131762090);
      }
      this.zRd.setVisibility(8);
      this.zRe.setVisibility(8);
      this.zRm.setVisibility(8);
      this.zRn.setVisibility(8);
      this.vHH.setText(2131765657);
      if ((this.zGh == null) || (!this.zGh.ebv())) {
        break label542;
      }
      if (bt.isNullOrNil(this.zGh.field_forbidWord)) {
        break label522;
      }
      this.zRd.setText(this.zGh.field_forbidWord);
      this.zRd.setVisibility(4);
      this.zRe.setVisibility(8);
      com.tencent.mm.plugin.wallet.a.s.dZT();
      if (com.tencent.mm.plugin.wallet.a.s.dZU().ecG()) {
        eam();
      }
      label329:
      com.tencent.mm.plugin.wallet.a.s.dZT();
      if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecG())
      {
        com.tencent.mm.plugin.wallet.a.s.dZT();
        if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecH()) {
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
      if ((i != 0) && (this.zQd != null) && (this.zQQ != null) && (this.zQR) && (this.vIq != null))
      {
        eao();
        this.zRh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69423);
            int i;
            if (WalletPayUI.this.mPayInfo == null)
            {
              i = 0;
              if (WalletPayUI.this.mPayInfo != null) {
                break label96;
              }
            }
            label96:
            for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dcE)
            {
              com.tencent.mm.wallet_core.c.af.f(i, paramAnonymousView, 12, "");
              com.tencent.mm.plugin.wallet_core.ui.n.a(WalletPayUI.this.getContext(), WalletPayUI.this.vIq, WalletPayUI.this.zQd.Aeb, new n.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  int j = 1;
                  AppMethodBeat.i(69422);
                  WalletPayUI.this.zQd = paramAnonymous2FavorPayInfo;
                  Object localObject = WalletPayUI.this.TAG;
                  int i;
                  label82:
                  label98:
                  boolean bool;
                  if (paramAnonymous2FavorPayInfo == null)
                  {
                    paramAnonymous2FavorPayInfo = "";
                    ad.i((String)localObject, "WalletFavorDialog onSelectionDone %s", new Object[] { paramAnonymous2FavorPayInfo });
                    if (WalletPayUI.this.zQd != null)
                    {
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label467;
                      }
                      i = 0;
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label485;
                      }
                      paramAnonymous2FavorPayInfo = "";
                      com.tencent.mm.wallet_core.c.af.f(i, paramAnonymous2FavorPayInfo, 15, WalletPayUI.this.zQd.Aeb);
                      if ((WalletPayUI.this.zGh != null) && (!com.tencent.mm.plugin.wallet_core.ui.d.a(WalletPayUI.this.zQd, WalletPayUI.this.zGh))) {
                        break label502;
                      }
                      WalletPayUI.this.zRe.setVisibility(8);
                      WalletPayUI.this.vHH.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69419);
                          ad.i(WalletPayUI.this.TAG, "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
                          WalletPayUI.this.b(false, 0, "");
                          AppMethodBeat.o(69419);
                        }
                      });
                      bool = true;
                    }
                  }
                  for (;;)
                  {
                    label197:
                    ad.i(WalletPayUI.this.TAG, "needBindBankCard %s", new Object[] { Boolean.valueOf(bool) });
                    WalletPayUI.c(WalletPayUI.this).setVisibility(0);
                    WalletPayUI.d(WalletPayUI.this).setVisibility(0);
                    if (WalletPayUI.this.zQd != null)
                    {
                      WalletPayUI.this.zQQ = com.tencent.mm.plugin.wallet_core.ui.e.Ajp.a(WalletPayUI.this.vIq);
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.zQQ.aum(WalletPayUI.this.zQd.Aeb);
                      if ((paramAnonymous2FavorPayInfo != null) && (paramAnonymous2FavorPayInfo.zOq == 0.0D))
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
                        WalletPayUI.this.zRd.setVisibility(8);
                        WalletPayUI.this.zRe.setVisibility(0);
                        WalletPayUI.this.vHH.setOnClickListener(new View.OnClickListener()
                        {
                          public final void onClick(View paramAnonymous3View)
                          {
                            AppMethodBeat.i(69421);
                            WalletPayUI.this.ear();
                            AppMethodBeat.o(69421);
                          }
                        });
                      }
                      if (i != 0) {
                        WalletPayUI.this.zRe.setVisibility(8);
                      }
                      WalletPayUI.this.eao();
                      AppMethodBeat.o(69422);
                      return;
                      paramAnonymous2FavorPayInfo = paramAnonymous2FavorPayInfo.toString();
                      break;
                      label467:
                      i = WalletPayUI.this.mPayInfo.dtb;
                      break label82;
                      label485:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.mPayInfo.dcE;
                      break label98;
                      label502:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.zQQ.aum(WalletPayUI.this.zQd.Aeb);
                      if ((paramAnonymous2FavorPayInfo == null) || (!WalletPayUI.this.zGh.ebv())) {
                        break label644;
                      }
                      com.tencent.mm.plugin.wallet.a.s.dZT();
                      localObject = com.tencent.mm.plugin.wallet.a.s.dZU().zHd;
                      double d = paramAnonymous2FavorPayInfo.zOq;
                      if ((localObject == null) || (((Bankcard)localObject).AbU >= d)) {
                        break label644;
                      }
                      ad.i(WalletPayUI.this.TAG, "balance not meet");
                      WalletPayUI.this.zRe.setVisibility(8);
                      WalletPayUI.this.vHH.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69420);
                          ad.i(WalletPayUI.this.TAG, "Balance amount not meet, after favor selection! payWithNewBankcard");
                          WalletPayUI.this.b(false, 0, "");
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
              AppMethodBeat.o(69423);
              return;
              i = WalletPayUI.this.mPayInfo.dtb;
              break;
            }
          }
        });
        localLinearLayout.setVisibility(0);
        if ((this.vIq == null) || (this.zGg == null) || (this.mPayInfo == null)) {
          break label571;
        }
        this.vHH.setClickable(true);
        this.vHH.setEnabled(true);
      }
      for (;;)
      {
        if (this.vIq == null) {
          this.zRe.setVisibility(8);
        }
        AppMethodBeat.o(69439);
        return;
        this.zRa.setText(((Orders.Commodity)this.vIq.Afx.get(0)).desc);
        this.zRf.setVisibility(8);
        break;
        com.tencent.mm.plugin.wallet.a.s.dZT();
        if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecG()) {
          break label329;
        }
        eam();
        break label329;
        com.tencent.mm.plugin.wallet.a.s.dZT();
        if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecH()) {
          break label329;
        }
        eam();
        break label329;
        localLinearLayout.setVisibility(8);
        break label424;
        this.vHH.setClickable(false);
        this.vHH.setEnabled(false);
      }
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
      eaf();
    }
    AppMethodBeat.o(69466);
  }
  
  protected void eaf()
  {
    AppMethodBeat.i(69450);
    su(false);
    AppMethodBeat.o(69450);
  }
  
  protected void eal()
  {
    int i = 2;
    AppMethodBeat.i(69432);
    com.tencent.mm.plugin.report.service.h.vKh.f(11850, new Object[] { Integer.valueOf(2), Integer.valueOf(this.mPayInfo.dtb) });
    if (this.mPayInfo.dtb == 11) {
      i = 3;
    }
    Object localObject = this.mPayInfo;
    if ((localObject == null) || (bt.isNullOrNil(((PayInfo)localObject).dcE)))
    {
      ad.i("MicroMsg.CgiManager", "no payInfo or reqKey");
      localObject = null;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessName("PayProcess");
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessSessionId(this.zRl);
        if ((this.mPayInfo.dtb != 6) || (this.mPayInfo.Cop != 100)) {
          break label446;
        }
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(100);
        label134:
        if (!this.mPayInfo.Coq) {
          break label460;
        }
      }
    }
    label446:
    label460:
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress((com.tencent.mm.al.n)localObject, true, bool);
      AppMethodBeat.o(69432);
      return;
      String str = ((PayInfo)localObject).dcE;
      ad.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", new Object[] { str });
      ad.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
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
      ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(this.mPayInfo.dtb);
      break label134;
    }
  }
  
  public final void eao()
  {
    AppMethodBeat.i(69442);
    com.tencent.mm.plugin.wallet.a.j localj = this.zQQ.aum(this.zQd.Aeb);
    List localList = this.zQQ.edL();
    com.tencent.mm.plugin.wallet.a.h localh = this.zQQ.Ajk;
    Object localObject1 = "";
    double d2;
    Object localObject2;
    int i;
    double d1;
    if (localj != null)
    {
      d2 = localj.zOy;
      if (d2 > 0.0D)
      {
        localObject2 = localj.zOA;
        int j = 1;
        localObject1 = localObject2;
        i = j;
        d1 = d2;
        if (!bt.isNullOrNil(localj.zOB))
        {
          localObject1 = (String)localObject2 + "," + localj.zOB;
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
      if ((d1 > 0.0D) && (localh != null) && (localh.zOu == 0))
      {
        if (localj != null) {
          this.zQZ.setText(com.tencent.mm.wallet_core.ui.e.D(localj.zOx));
        }
        this.zRc.setText(com.tencent.mm.wallet_core.ui.e.aNd(this.vIq.uop));
        this.zRb.setText(com.tencent.mm.wallet_core.ui.e.d(this.vIq.dcH, this.vIq.uop));
        this.zRb.setVisibility(0);
      }
      for (;;)
      {
        if (!bt.isNullOrNil((String)localObject2)) {
          this.zRh.setText((CharSequence)localObject2);
        }
        AppMethodBeat.o(69442);
        return;
        this.zQZ.setText(com.tencent.mm.wallet_core.ui.e.D(this.vIq.dcH));
        this.zRc.setText(com.tencent.mm.wallet_core.ui.e.aNd(this.vIq.uop));
        this.zRb.setVisibility(8);
      }
      i = 0;
      d1 = d2;
      continue;
      i = 0;
      d1 = 0.0D;
    }
  }
  
  protected final Authen eap()
  {
    AppMethodBeat.i(69443);
    Authen localAuthen = new Authen();
    if (eaq()) {}
    for (localAuthen.dtM = 3;; localAuthen.dtM = 6)
    {
      if (!bt.isNullOrNil(this.ixc)) {
        localAuthen.Abg = this.ixc;
      }
      if (this.zGh != null)
      {
        localAuthen.uns = this.zGh.field_bindSerial;
        localAuthen.dca = this.zGh.field_bankcardType;
      }
      if ((this.zQd != null) && (this.zQQ != null) && (this.zQQ.edI()))
      {
        localAuthen.Abq = this.zQd.Aeb;
        localAuthen.Abp = this.zQd.Aee;
      }
      localAuthen.uXi = this.mPayInfo;
      AppMethodBeat.o(69443);
      return localAuthen;
    }
  }
  
  protected final boolean eaq()
  {
    AppMethodBeat.i(69444);
    if ((this.zGh != null) && (this.vIq != null) && (this.vIq.zWA == 3))
    {
      if (this.zGh.eby())
      {
        AppMethodBeat.o(69444);
        return true;
      }
      AppMethodBeat.o(69444);
      return false;
    }
    if ((this.vIq != null) && (!Bankcard.Rw(this.vIq.zWA)))
    {
      AppMethodBeat.o(69444);
      return true;
    }
    AppMethodBeat.o(69444);
    return false;
  }
  
  protected final void ear()
  {
    AppMethodBeat.i(69445);
    st(true);
    AppMethodBeat.o(69445);
  }
  
  protected final void eau()
  {
    AppMethodBeat.i(69454);
    Bundle localBundle = getIntent().getExtras();
    com.tencent.mm.plugin.wallet.a.s.dZT();
    if (com.tencent.mm.plugin.wallet.a.s.dZU().ecF()) {}
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("key_pay_flag", i);
      localBundle.putParcelable("key_orders", this.vIq);
      localBundle.putParcelable("key_pay_info", this.mPayInfo);
      localBundle.putParcelable("key_favor_pay_info", this.zQd);
      al(localBundle);
      AppMethodBeat.o(69454);
      return;
    }
  }
  
  protected final boolean eay()
  {
    return (this.mPayInfo != null) && (this.mPayInfo.dtb != 11);
  }
  
  public void finish()
  {
    AppMethodBeat.i(69434);
    ad.i(this.TAG, "finish %s %s mPayResultType:%s", new Object[] { Integer.valueOf(hashCode()), bt.eGN().toString(), Integer.valueOf(this.mPayResultType) });
    cancelQRPay();
    if ((this.vIq != null) && (!this.vIq.Afx.isEmpty())) {
      getIntent().putExtra("key_trans_id", ((Orders.Commodity)this.vIq.Afx.get(0)).dcF);
    }
    if (this.mPayInfo != null) {
      getIntent().putExtra("key_reqKey", this.mPayInfo.dcE);
    }
    com.tencent.mm.wallet_core.d locald;
    if (this.isPaySuccess)
    {
      if (this.vIq != null) {
        getIntent().putExtra("key_total_fee", this.vIq.dcH);
      }
      getIntent().putExtra("key_pay_reslut_type", 1);
      l(-1, getIntent());
      setResult(-1, getIntent());
      locald = getProcess();
      if (locald != null) {
        if (locald.IbL == null) {
          break label717;
        }
      }
    }
    label408:
    label439:
    label570:
    label581:
    label717:
    for (Object localObject = (Context)locald.IbL.get();; localObject = null)
    {
      if (this == localObject)
      {
        ad.i(this.TAG, "remove process end callback to prevent ui leak");
        locald.fjp();
      }
      super.finish();
      AppMethodBeat.o(69434);
      return;
      if ((this.mPayInfo != null) && (this.mPayInfo.dtb == 8) && (this.vIq != null))
      {
        this.mPayInfo.Coy = 0;
        doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.a(eap(), this.vIq, true), false);
        if (this.mPayInfo.Cos != null)
        {
          long l = this.mPayInfo.Cos.getLong("extinfo_key_9");
          com.tencent.mm.plugin.report.service.h.vKh.f(13956, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      l(0, getIntent());
      getIntent().putExtra("key_pay_reslut_type", this.mPayResultType);
      int i;
      if (this.zRz == 1)
      {
        getIntent().putExtra("key_pay_reslut_type", 1000);
        setResult(0, getIntent());
        com.tencent.mm.plugin.wallet.a.s.dZT();
        if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecH()) {
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
      for (localObject = "";; localObject = this.mPayInfo.dcE)
      {
        com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 18, "");
        localObject = com.tencent.mm.wallet_core.a.aMX("PayProcess").iterator();
        while (((Iterator)localObject).hasNext())
        {
          locald = (com.tencent.mm.wallet_core.d)((Iterator)localObject).next();
          locald.H(new Object[] { "specEndProcessWithoutFinish" });
          if (locald.dow != null) {
            locald.dow.clear();
          }
          com.tencent.mm.wallet_core.a.remove(locald.getClass().hashCode());
          locald.dZW();
        }
        break;
        if (this.zRz != 2) {
          break label408;
        }
        getIntent().putExtra("key_pay_reslut_type", 1001);
        break label408;
        i = this.mPayInfo.dtb;
        break label439;
      }
      label593:
      com.tencent.mm.plugin.wallet.a.s.dZT();
      if (com.tencent.mm.plugin.wallet.a.s.dZU().ecG())
      {
        if (this.mPayInfo == null)
        {
          i = 0;
          label615:
          if (this.mPayInfo != null) {
            break label649;
          }
        }
        for (localObject = "";; localObject = this.mPayInfo.dcE)
        {
          com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 4, "");
          break;
          i = this.mPayInfo.dtb;
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
      for (localObject = "";; localObject = this.mPayInfo.dcE)
      {
        com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 7, "");
        break;
        i = this.mPayInfo.dtb;
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
    ai.b(getWindow());
    MMScrollView localMMScrollView = (MMScrollView)findViewById(2131306834);
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.vHH = ((Button)findViewById(2131306815));
    this.vHH.setClickable(false);
    this.vHH.setEnabled(false);
    this.zQZ = ((TextView)findViewById(2131306804));
    this.zRa = ((TextView)findViewById(2131306803));
    this.zRc = ((TextView)findViewById(2131306785));
    this.zRh = ((TextView)findViewById(2131306781));
    this.zRb = ((TextView)findViewById(2131306791));
    this.zRg = ((TextView)findViewById(2131306811));
    this.zRb.getPaint().setFlags(16);
    this.zRd = ((TextView)findViewById(2131306816));
    this.zRe = ((TextView)findViewById(2131306812));
    this.zRe.setOnClickListener(new com.tencent.mm.ui.v()
    {
      public final void bOU()
      {
        AppMethodBeat.i(69416);
        WalletPayUI.this.b(false, 0, "");
        AppMethodBeat.o(69416);
      }
    });
    this.zRf = ((ImageView)findViewById(2131306778));
    this.zRf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69417);
        if (WalletPayUI.this.zQW) {
          WalletPayUI.this.zRf.setImageResource(2131233555);
        }
        for (WalletPayUI.this.zQW = false;; WalletPayUI.this.zQW = true)
        {
          WalletPayUI.this.zRj.notifyDataSetChanged();
          AppMethodBeat.o(69417);
          return;
          WalletPayUI.this.zRf.setImageResource(2131233558);
        }
      }
    });
    this.zRi = ((LinearLayout)findViewById(2131306788));
    this.zRj = new a();
    this.vHH.setOnClickListener(new com.tencent.mm.ui.v()
    {
      public final void bOU()
      {
        AppMethodBeat.i(69418);
        com.tencent.mm.plugin.wallet.a.s.dZT();
        int i;
        if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecG())
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
        for (String str = "";; str = WalletPayUI.this.mPayInfo.dcE)
        {
          com.tencent.mm.wallet_core.c.af.f(i, str, 6, "");
          WalletPayUI.this.ear();
          WalletPayUI.this.zQY = true;
          AppMethodBeat.o(69418);
          return;
          i = WalletPayUI.this.mPayInfo.dtb;
          break;
        }
      }
    });
    this.vHH.setText(2131765657);
    this.zRm = ((TextView)findViewById(2131303187));
    this.zRn = ((LinearLayout)findViewById(2131303186));
    cE();
    AppMethodBeat.o(69438);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69464);
    if (this.zRu)
    {
      String str1 = this.TAG;
      boolean bool1;
      label87:
      String str2;
      int i;
      if ((getPayInfo() == null) || (!getPayInfo().rWX))
      {
        bool1 = true;
        ad.i(str1, "case 1 %s,  stack %s", new Object[] { Boolean.valueOf(bool1), bt.eGN().toString() });
        str1 = this.TAG;
        com.tencent.mm.plugin.wallet.a.s.dZT();
        if (com.tencent.mm.plugin.wallet.a.s.dZU().ecF()) {
          break label196;
        }
        bool1 = true;
        ad.d(str1, "case 2 %s,", new Object[] { Boolean.valueOf(bool1) });
        str2 = this.TAG;
        if (this.zGg != null) {
          break label201;
        }
        i = 0;
        label121:
        if (this.zGh != null) {
          break label212;
        }
      }
      label196:
      label201:
      label212:
      for (str1 = "";; str1 = this.zGh.field_forbidWord)
      {
        ad.d(str2, "case 3 mBankcardList %s, mDefaultBankcard %s", new Object[] { Integer.valueOf(i), str1 });
        if ((getPayInfo() != null) && (getPayInfo().rWX)) {
          break label224;
        }
        ad.i(this.TAG, "get isTransparent1");
        AppMethodBeat.o(69464);
        return false;
        bool1 = false;
        break;
        bool1 = false;
        break label87;
        i = this.zGg.size();
        break label121;
      }
      label224:
      com.tencent.mm.plugin.wallet.a.s.dZT();
      if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecF())
      {
        ad.i(this.TAG, "get isTransparent2");
        AppMethodBeat.o(69464);
        return false;
      }
      if ((this.zGg != null) && ((this.zGg.size() == 0) || ((this.zGh != null) && (!bt.isNullOrNil(this.zGh.field_forbidWord)))))
      {
        str1 = this.TAG;
        if ((this.zGg != null) && (this.zGg.size() == 0))
        {
          bool1 = true;
          if ((this.zGh == null) || (bt.isNullOrNil(this.zGh.field_forbidWord))) {
            break label378;
          }
        }
        label378:
        for (boolean bool2 = true;; bool2 = false)
        {
          ad.i(str1, "get isTransparent3 1 %s 2 %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(69464);
          return false;
          bool1 = false;
          break;
        }
      }
      ad.i(this.TAG, "get isTransparent4");
      AppMethodBeat.o(69464);
      return true;
    }
    ad.i(this.TAG, "get isTransparent5");
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
    ad.i(this.TAG, "onAcvityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
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
          this.zRt = paramIntent.getIntExtra("auto_deduct_flag", -1);
          if ((this.vIq != null) && (this.vIq.AfC != null)) {
            this.vIq.AfC.zRt = this.zRt;
          }
          getPayInfo().Cov = this.zRt;
          if (this.zRt == 1)
          {
            getPayInfo().Cow = paramIntent.getStringExtra("deduct_bank_type");
            getPayInfo().Cox = paramIntent.getStringExtra("deduct_bind_serial");
          }
        }
        this.zRs = true;
        onProgressFinish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(13958, new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(69462);
        return;
        finish();
      }
      this.zRk.dismiss();
      this.zQY = false;
      eal();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69429);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.TAG = ("MicroMsg.WalletPayUI@" + hashCode());
    if (zQN)
    {
      ad.w(this.TAG, "has Undestory WalletPayUI!");
      com.tencent.mm.plugin.report.service.h.vKh.m(965L, 1L, 1L);
      Ro(2);
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    zQN = true;
    long l = System.currentTimeMillis();
    int j = getIntent().getIntExtra("key_context_hashcode", -1);
    paramBundle = new b[zQO.size()];
    ad.i(this.TAG, "WalletPayUI check %s this %s fromHashCode %s", new Object[] { Integer.valueOf(zQO.size()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
    paramBundle = (b[])zQO.toArray(paramBundle);
    int k = paramBundle.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = paramBundle[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localObject.kOy.get();
      if (localWalletPayUI != null)
      {
        ad.w(this.TAG, "has old payui, both finish %s", new Object[] { Integer.valueOf(localWalletPayUI.hashCode()) });
        if ((j != localObject.aFj) || (j == -1)) {
          break label290;
        }
        localWalletPayUI.Ro(2);
        com.tencent.mm.plugin.report.service.h.vKh.m(965L, 41L, 1L);
      }
      for (;;)
      {
        zQO.remove(localObject);
        localWalletPayUI.finish();
        i += 1;
        break;
        label290:
        localWalletPayUI.Ro(1);
        com.tencent.mm.plugin.report.service.h.vKh.m(965L, 40L, 1L);
      }
    }
    this.zRB = new b((byte)0);
    this.zRB.timestamp = l;
    this.zRB.aFj = j;
    this.zRB.kOy = new WeakReference(this);
    zQO.add(this.zRB);
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e(this.TAG, "hy: account not ready. finish now");
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    getWindow().getDecorView().postDelayed(this.zRA, 5000L);
    this.zRC = bt.eGO();
    com.tencent.mm.sdk.b.a.ESL.c(this.vFM);
    com.tencent.mm.plugin.wallet_core.model.k.Rx(5);
    this.vCr = com.tencent.mm.plugin.wallet.a.aL(getIntent());
    setMMTitle(2131765707);
    this.mPayInfo = getPayInfo();
    this.zQU = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
    this.zQV = bt.by(getIntent().getStringExtra("key_force_use_bind_serail"), "");
    this.vCS = getIntent().getStringExtra("key_receiver_true_name");
    if ((this.mPayInfo == null) || (this.mPayInfo.Cou == 0L))
    {
      this.zRl = System.currentTimeMillis();
      com.tencent.mm.plugin.wallet.a.s.dZT();
      if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecF())
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
        com.tencent.mm.wallet_core.c.af.f(i, paramBundle, 1, "");
      }
      if (eak()) {
        break label763;
      }
      ad.d(this.TAG, "PayInfo = " + this.mPayInfo);
      if ((this.mPayInfo == null) || (bt.isNullOrNil(this.mPayInfo.dcE))) {
        break label705;
      }
      eal();
      com.tencent.mm.plugin.secinforeport.a.d.wcE.asyncReportPaySecurityInfoThroughCgi();
      initView();
    }
    for (;;)
    {
      if (this.mPayInfo != null) {
        com.tencent.mm.plugin.wallet.pay.a.b.atA(this.mPayInfo.CoA);
      }
      AppMethodBeat.o(69429);
      return;
      this.zRl = this.mPayInfo.Cou;
      break;
      label683:
      i = this.mPayInfo.dtb;
      break label559;
      label694:
      paramBundle = this.mPayInfo.dcE;
      break label569;
      label705:
      if ((this.mPayInfo != null) && (!bt.isNullOrNil(this.mPayInfo.errMsg))) {}
      for (paramBundle = this.mPayInfo.errMsg;; paramBundle = getString(2131765700))
      {
        com.tencent.mm.ui.base.h.a(this, paramBundle, null, false, new WalletPayUI.23(this));
        break;
      }
      label763:
      ad.i(this.TAG, "hy: pay end on create. finish");
      finish();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69431);
    if (this.zQe != null)
    {
      this.zQe.closeTipDialog();
      this.zQe.release();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.vFM);
    this.zQf = null;
    getWindow().getDecorView().removeCallbacks(this.zRA);
    zQO.remove(this.zRB);
    zQN = false;
    long l = System.currentTimeMillis();
    b[] arrayOfb = new b[zQO.size()];
    arrayOfb = (b[])zQO.toArray(arrayOfb);
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localb.kOy.get();
      if ((localWalletPayUI != null) && (l - localb.timestamp > 600000L))
      {
        ad.w(this.TAG, "has old payui, both finish");
        com.tencent.mm.plugin.report.service.h.vKh.m(965L, 2L, 1L);
        zQO.remove(localb);
        localWalletPayUI.Ro(1);
        localWalletPayUI.finish();
      }
      i += 1;
    }
    if (this.mPayInfo != null) {
      com.tencent.mm.plugin.wallet.pay.a.b.atB(this.mPayInfo.CoA);
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
        ad.w(this.TAG, "block when authening");
        AppMethodBeat.o(69435);
        return true;
      }
      if ((this.zRk != null) && (this.mPayInfo != null) && (this.mPayInfo.rWX) && (!this.mNetSceneMgr.isProcessing())) {
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
    ad.i(this.TAG, "onNewIntent");
    setIntent(paramIntent);
    if (!eak())
    {
      ad.w(this.TAG, "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
      if (paramIntent.getBooleanExtra("send_cancel_event", true)) {
        l(0, getIntent());
      }
      this.isPaySuccess = false;
    }
    if (paramIntent.getBooleanExtra("direc_change_bankcard", false))
    {
      su(true);
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false))) {
      this.zRp = true;
    }
    for (int i = 1; i != 0; i = 0)
    {
      ad.i(this.TAG, "isFromBindCard is true");
      eal();
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_is_realname_verify_process", false)))
    {
      this.zRq = true;
      i = j;
      if (i == 0) {
        break label196;
      }
      ad.i(this.TAG, "isFromRealNameVerify is true");
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
      ad.e(this.TAG, "isFromBindCard is false,isFromRealNameVerify is false");
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69473);
    super.onPause();
    if (this.zQf != null) {
      this.zQf.onActivityPause();
    }
    AppMethodBeat.o(69473);
  }
  
  public boolean onProgressFinish()
  {
    boolean bool2 = false;
    AppMethodBeat.i(69463);
    ad.i(this.TAG, "onProgressFinish isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.zRx) });
    com.tencent.mm.sdk.b.a.ESL.l(new wz());
    int i;
    int j;
    label93:
    Object localObject;
    label104:
    boolean bool1;
    if ((this.vIq != null) && (this.vIq.AfC != null) && (!this.zRs))
    {
      i = 1;
      if ((i == 0) && (!eaw()))
      {
        if (this.mPayInfo != null) {
          break label140;
        }
        j = 0;
        if (this.mPayInfo != null) {
          break label151;
        }
        localObject = "";
        com.tencent.mm.wallet_core.c.af.f(j, (String)localObject, 2, "");
      }
      if (!this.zRx) {
        break label163;
      }
      st(true);
      bool1 = true;
    }
    for (;;)
    {
      AppMethodBeat.o(69463);
      return bool1;
      i = 0;
      break;
      label140:
      j = this.mPayInfo.dtb;
      break label93;
      label151:
      localObject = this.mPayInfo.dcE;
      break label104;
      label163:
      if (this.zRr)
      {
        bool1 = true;
      }
      else if (i != 0)
      {
        localObject = new Intent(this, WalletPayDeductUI.class);
        ((Intent)localObject).putExtra("orders", this.vIq);
        startActivityForResult((Intent)localObject, 0);
        bool1 = true;
      }
      else if (getContentView().getVisibility() != 0)
      {
        if ((!this.zQY) && (aKT()))
        {
          st(true);
          this.zQY = true;
        }
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (getContentView().getVisibility() == 0)
        {
          bool1 = bool2;
          if (this.vIq != null)
          {
            bool1 = bool2;
            if (this.vIq.AfC != null)
            {
              bool1 = bool2;
              if (this.vHH.isEnabled())
              {
                bool1 = bool2;
                if (!this.zRv)
                {
                  this.vHH.performClick();
                  this.zRv = true;
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
    ad.i(this.TAG, "hy: onResume isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.zRx) });
    if (!isProcessing())
    {
      if (!bt.isNullOrNil(this.zQV)) {
        this.zGh = eav();
      }
    }
    else
    {
      if (!this.zRy) {
        break label149;
      }
      ad.i(this.TAG, "onResume isResumePassFinish");
      this.zRy = false;
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(69433);
      return;
      if (this.zGh == null)
      {
        com.tencent.mm.plugin.wallet.a.s.dZT();
        this.zGh = com.tencent.mm.plugin.wallet.a.s.dZU().a(null, null, eay(), false);
        break;
      }
      com.tencent.mm.plugin.wallet.a.s.dZT();
      this.zGh = com.tencent.mm.plugin.wallet.a.s.dZU().a(null, this.zGh.field_bindSerial, eay(), false);
      break;
      label149:
      if ((this.zQS) && (getContentViewVisibility() != 0) && ((this.zRk == null) || (!this.zRk.isShowing())))
      {
        ad.i(this.TAG, "hy: has started process and is transparent and no pwd appeared. finish self");
        finish();
      }
      else if (this.zQf != null)
      {
        this.zQf.edM();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(69457);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn, paramBoolean);
    if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
      setAuthState(false);
    }
    AppMethodBeat.o(69457);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(69458);
    ad.i(this.TAG, "errorType %s errCode %s, errmsg %s, scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    boolean bool;
    Object localObject1;
    label411:
    label446:
    label606:
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.c.f))
      {
        this.mPayResultType = 1;
        this.zQP = ((com.tencent.mm.plugin.wallet.pay.a.c.f)paramn);
        paramString = (com.tencent.mm.plugin.wallet.pay.a.c.f)paramn;
        if (paramString.isJumpRemind())
        {
          paramn = paramString.getJumpRemind();
          if ((paramn.Idy == null) || (bt.isNullOrNil(paramn.Idy.path))) {}
          for (;;)
          {
            paramn.a(this, new com.tencent.mm.wallet_core.c.f()
            {
              public final void onCancel()
              {
                AppMethodBeat.i(69403);
                if (paramn.fjU())
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
                if (paramn.fjU())
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
                if (paramn.fjU())
                {
                  WalletPayUI.a(WalletPayUI.this, paramString);
                  AppMethodBeat.o(69404);
                  return;
                }
                WalletPayUI.this.eal();
                AppMethodBeat.o(69404);
              }
            });
            AppMethodBeat.o(69458);
            return true;
            if (paramn.Idy.path.contains("clientversion")) {
              ad.w("MicroMsg.JumpRemind", "url.path contain clientversion");
            } else {
              paramn.Idy.path = com.tencent.mm.ui.tools.v.q(paramn.Idy.path, new String[] { "clientversion" + "=" + com.tencent.mm.protocal.d.CpK });
            }
          }
        }
        a(paramString);
      }
      while (!(paramn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        cE();
        AppMethodBeat.o(69458);
        return true;
      }
      this.mPayResultType = 1;
      paramn = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramn;
      paramString = getInput();
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putParcelable("key_bankcard", this.zGh);
      paramString.putString("key_bank_type", this.zGh.field_bankcardType);
      if (!bt.isNullOrNil(this.ixc)) {
        paramString.putString("key_pwd1", this.ixc);
      }
      paramString.putString("kreq_token", paramn.getToken());
      paramString.putParcelable("key_authen", paramn.zPG);
      if (!paramn.zPE)
      {
        bool = true;
        paramString.putBoolean("key_need_verify_sms", bool);
        paramString.putInt("key_can_verify_tail", paramn.zPK);
        paramString.putString("key_verify_tail_wording", paramn.zPL);
        localObject1 = getInput();
        if (paramn.zPM != 1) {
          break label731;
        }
        bool = true;
        ((Bundle)localObject1).putBoolean("key_block_bind_new_card", bool);
        if (!bt.isNullOrNil(paramn.zPH)) {
          break label737;
        }
        paramString.putString("key_mobile", this.zGh.field_mobile);
        paramString.putString("key_QADNA_URL", paramn.zPI);
        if (!paramn.isPaySuccess) {
          break label752;
        }
        if (this.vCr != null)
        {
          this.vCr.ce(10003, "");
          localObject1 = this.vCr;
          com.tencent.mm.plugin.report.service.h.vKh.f(13455, new Object[] { ((com.tencent.mm.plugin.wallet.a)localObject1).zDW, Long.valueOf(System.currentTimeMillis()), ((com.tencent.mm.plugin.wallet.a)localObject1).zDX });
        }
        paramString.putParcelable("key_orders", paramn.zPF);
        if (this.mPayInfo != null)
        {
          ad.i(this.TAG, "payscene %d", new Object[] { Integer.valueOf(this.mPayInfo.dtb) });
          if (8 == this.mPayInfo.dtb)
          {
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fme, Boolean.TRUE);
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("pwd", this.ixc);
        localObject2 = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class);
        paramInt1 = 0;
        if (!((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).cum()) {
          break label766;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
        ((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).a(paramn.dZZ(), true, this.mPayInfo.Afv, (Bundle)localObject1);
        paramString.putInt("key_pay_flag", 3);
        paramn = paramn.ujM;
        if (paramn != null) {
          paramString.putParcelable("key_realname_guide_helper", paramn);
        }
        al(paramString);
        AppMethodBeat.o(69458);
        return true;
        bool = false;
        break;
        label731:
        bool = false;
        break label411;
        label737:
        paramString.putString("key_mobile", paramn.zPH);
        break label446;
        label752:
        paramString.putParcelable("key_orders", this.vIq);
        break label606;
        label766:
        if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).cun()) {
          paramInt1 = 2;
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("pwd", this.ixc);
      localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.mPayInfo.ApW == 1)
      {
        bool = true;
        label835:
        ((com.tencent.mm.plugin.fingerprint.d.a)localObject2).a(bool, false, (Bundle)localObject1);
        if ((paramInt2 != -1) && (paramInt2 != -500)) {
          break label962;
        }
      }
      label962:
      for (this.mPayResultType = 3;; this.mPayResultType = 2) {
        switch (paramInt2)
        {
        default: 
          AppMethodBeat.o(69458);
          return false;
          bool = false;
          break label835;
        }
      }
      paramn = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramn;
      this.zQX = getInput();
      this.zQX.putParcelable("key_pay_info", this.mPayInfo);
      this.zQX.putParcelable("key_bankcard", this.zGh);
      if (!bt.isNullOrNil(this.ixc)) {
        this.zQX.putString("key_pwd1", this.ixc);
      }
      this.zQX.putString("kreq_token", paramn.getToken());
      this.zQX.putParcelable("key_authen", paramn.zPG);
      localObject1 = this.zQX;
      if (!paramn.zPE)
      {
        bool = true;
        label1084:
        ((Bundle)localObject1).putBoolean("key_need_verify_sms", bool);
        this.zQX.putString("key_mobile", this.zGh.field_mobile);
        this.zQX.putInt("key_err_code", paramInt2);
        this.zQX.putParcelable("key_orders", this.vIq);
        if (!bt.isNullOrNil(paramString)) {
          break label1550;
        }
        paramString = getString(2131765705, new Object[] { this.zGh.field_desc, this.zGh.field_mobile });
      }
    }
    label1550:
    for (;;)
    {
      com.tencent.mm.ui.base.h.d(this, paramString, "", getString(2131765704), getString(2131755691), new WalletPayUI.17(this), new WalletPayUI.18(this));
      AppMethodBeat.o(69458);
      return true;
      bool = false;
      break label1084;
      this.mPayInfo.Cot = paramInt2;
      eaf();
      AppMethodBeat.o(69458);
      return true;
      this.mPayInfo.Cot = paramInt2;
      bool = false;
      if (paramInt2 == 100100) {
        bool = true;
      }
      if (this.zQe == null) {
        this.zQe = new a(this, this);
      }
      this.zQe.a(bool, this.mPayInfo.dlI, this.mPayInfo.dcE);
      ad.i(this.TAG, "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool)));
      AppMethodBeat.o(69458);
      return true;
      if ((this.zGh == null) || (this.vIq == null)) {
        break;
      }
      this.zGh.AbT = this.vIq.dcE;
      if ((this.zGg != null) && (this.zGg.size() > 1)) {
        c(true, 4, paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(69458);
        return true;
        b(true, 4, paramString);
      }
      if (!(paramn instanceof com.tencent.mm.plugin.wallet.pay.a.c.f)) {
        break;
      }
      this.zRu = true;
      eaw();
      if (paramInt2 == 416)
      {
        ad.e(this.TAG, "errCode is 416 need real name verify!");
        this.mPayResultType = 2;
        this.zRr = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
        paramString.putString("realname_verify_process_jump_plugin", "wallet");
        if (this.mPayInfo != null) {}
        for (paramInt1 = this.mPayInfo.dtb;; paramInt1 = 0)
        {
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramn, paramString, paramInt1);
          AppMethodBeat.o(69458);
          return bool;
        }
      }
      this.mPayResultType = 3;
      ad.i(this.TAG, "errCode is %d , not need real name verify!", new Object[] { Integer.valueOf(paramInt2) });
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
  
  protected final void st(boolean paramBoolean)
  {
    AppMethodBeat.i(69446);
    if ((paramBoolean) && (!eax()))
    {
      AppMethodBeat.o(69446);
      return;
    }
    if (this.zQd != null)
    {
      this.zQQ = com.tencent.mm.plugin.wallet_core.ui.e.Ajp.a(this.vIq);
      com.tencent.mm.plugin.wallet.a.j localj = this.zQQ.aum(this.zQd.Aeb);
      if ((localj == null) || (localj.zOq != 0.0D)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.zRw != null)
      {
        if (this.zRw.zPQ == 0)
        {
          ad.i(this.TAG, "need real name,stop");
          b(this.zRw);
          AppMethodBeat.o(69446);
          return;
        }
        if ((this.zRw.zPQ == 1) && (i != 0))
        {
          ad.i(this.TAG, "need real name, zero stop");
          b(this.zRw);
        }
      }
      if (this.zPR != null)
      {
        if ((this.zPR.zPz == 1) && (!bt.isNullOrNil(this.zPR.tfH)) && (!bt.isNullOrNil(this.zPR.tfI)) && (!bt.isNullOrNil(this.zPR.zPA)))
        {
          if ((this.mPayInfo != null) && (this.vIq != null) && (this.vIq.Afx != null) && (this.vIq.Afx.size() > 0))
          {
            if (this.mPayInfo.dtb != 8) {
              break label371;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.vIq.Afx.get(0)).dcF });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.zPR.zPA, "", this.zPR.tfI, this.zPR.tfH, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69389);
                ad.i(WalletPayUI.this.TAG, "click continue pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.vIq != null) && (WalletPayUI.this.vIq.Afx != null) && (WalletPayUI.this.vIq.Afx.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.dtb != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.h.vKh.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.vIq.Afx.get(0)).dcF });
                }
                for (;;)
                {
                  WalletPayUI.g(WalletPayUI.this);
                  AppMethodBeat.o(69389);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.h.vKh.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.vIq.Afx.get(0)).dcF });
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69390);
                ad.i(WalletPayUI.this.TAG, "click cancel pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.vIq != null) && (WalletPayUI.this.vIq.Afx != null) && (WalletPayUI.this.vIq.Afx.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.dtb != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.h.vKh.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.vIq.Afx.get(0)).dcF });
                }
                for (;;)
                {
                  WalletPayUI.this.finish();
                  AppMethodBeat.o(69390);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.h.vKh.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.vIq.Afx.get(0)).dcF });
                }
              }
            });
            AppMethodBeat.o(69446);
            return;
            label371:
            com.tencent.mm.plugin.report.service.h.vKh.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.vIq.Afx.get(0)).dcF });
          }
        }
        if ((this.zPR.zPz == 2) && (!bt.isNullOrNil(this.zPR.zPA)) && (!bt.isNullOrNil(this.zPR.zPB)))
        {
          ad.i(this.TAG, "pay has been blocked");
          if ((this.mPayInfo != null) && (this.vIq != null) && (this.vIq.Afx != null) && (this.vIq.Afx.size() > 0))
          {
            if (this.mPayInfo.dtb != 8) {
              break label624;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.vIq.Afx.get(0)).dcF });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.zPR.zPA, "", this.zPR.zPB, false, new WalletPayUI.6(this));
            AppMethodBeat.o(69446);
            return;
            label624:
            com.tencent.mm.plugin.report.service.h.vKh.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.vIq.Afx.get(0)).dcF });
          }
        }
      }
      eas();
      AppMethodBeat.o(69446);
      return;
    }
  }
  
  protected final void su(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(69451);
    if (!aKT())
    {
      AppMethodBeat.o(69451);
      return;
    }
    this.zQg = false;
    ad.i(this.TAG, "pay with old bankcard! from statck %s", new Object[] { bt.eGN().toString() });
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label230;
      }
    }
    label230:
    for (Object localObject = "";; localObject = this.mPayInfo.dcE)
    {
      com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 8, "");
      if (this.zRk != null)
      {
        ad.w(this.TAG, "close previous cashier dialog");
        this.zRk.dismiss();
      }
      this.zQg = false;
      if (!dZX()) {
        break label242;
      }
      this.zRk = new WcPayCashierDialog(getContext());
      localObject = (WcPayCashierDialog)this.zRk;
      PayInfo localPayInfo = this.mPayInfo;
      Orders localOrders = this.vIq;
      FavorPayInfo localFavorPayInfo = this.zQd;
      Bankcard localBankcard = this.zGh;
      if (!this.zQU) {
        bool = true;
      }
      ((WcPayCashierDialog)localObject).a(localPayInfo, localOrders, localFavorPayInfo, localBankcard, bool, paramBoolean);
      ((WcPayCashierDialog)localObject).Asv = new WcPayCashierDialog.a()
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, Bankcard paramAnonymousBankcard)
        {
          AppMethodBeat.i(69392);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            ad.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.h.vKh.m(965L, 3L, 1L);
            AppMethodBeat.o(69392);
            return;
          }
          WalletPayUI.i(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.zQd = paramAnonymousFavorPayInfo;
          WalletPayUI.this.zGh = paramAnonymousBankcard;
          paramAnonymousBankcard = WalletPayUI.this.TAG;
          int i;
          if (WalletPayUI.this.zQd == null)
          {
            paramAnonymousFavorPayInfo = "";
            ad.i(paramAnonymousBankcard, "WalletPwdDialog showAlert with favinfo %s", new Object[] { paramAnonymousFavorPayInfo });
            if (!bt.isNullOrNil(paramAnonymousString))
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.dcE)
          {
            com.tencent.mm.wallet_core.c.af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.ixc = paramAnonymousString;
            WalletPayUI.this.sv(false);
            com.tencent.mm.plugin.wallet_core.utils.f.eft();
            AppMethodBeat.o(69392);
            return;
            paramAnonymousFavorPayInfo = WalletPayUI.this.zQd.toString();
            break;
            i = WalletPayUI.this.mPayInfo.dtb;
            break label131;
          }
        }
        
        public final void dYS()
        {
          AppMethodBeat.i(69394);
          ad.i(WalletPayUI.this.TAG, "click add new bankcard");
          Object localObject = com.tencent.mm.plugin.wallet_core.model.g.ebF();
          if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bcB())
          {
            com.tencent.mm.ui.base.h.c(WalletPayUI.this.getContext(), ((com.tencent.mm.plugin.wallet_core.model.g)localObject).unt, WalletPayUI.this.getString(2131755906), true);
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
          for (localObject = "";; localObject = WalletPayUI.this.mPayInfo.dcE)
          {
            com.tencent.mm.wallet_core.c.af.f(i, (String)localObject, 14, "");
            WalletPayUI.this.zRk.dismiss();
            WalletPayUI.this.zRk = null;
            WalletPayUI.this.eau();
            AppMethodBeat.o(69394);
            return;
            i = WalletPayUI.this.mPayInfo.dtb;
            break;
          }
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(69393);
          ad.i(WalletPayUI.this.TAG, "cashier dialog canceled");
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
          for (String str = "";; str = WalletPayUI.this.mPayInfo.dcE)
          {
            com.tencent.mm.wallet_core.c.af.f(i, str, 10, "");
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            AppMethodBeat.o(69393);
            return;
            i = WalletPayUI.this.mPayInfo.dtb;
            break;
          }
        }
      };
      ((WcPayCashierDialog)localObject).show();
      addDialog((Dialog)localObject);
      AppMethodBeat.o(69451);
      return;
      i = this.mPayInfo.dtb;
      break;
    }
    label242:
    if (!this.zQU) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.zRk = com.tencent.mm.plugin.wallet_core.ui.s.a(this, paramBoolean, this.vIq, this.zQd, this.zGh, this.mPayInfo, this.vCS, new s.c()new View.OnClickListener
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(69395);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            ad.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.h.vKh.m(965L, 3L, 1L);
            AppMethodBeat.o(69395);
            return;
          }
          WalletPayUI.k(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.zQd = paramAnonymousFavorPayInfo;
          String str = WalletPayUI.this.TAG;
          if (WalletPayUI.this.zQd == null) {}
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.zQd.toString())
          {
            ad.i(str, "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s", new Object[] { paramAnonymousFavorPayInfo, Boolean.valueOf(paramAnonymousBoolean) });
            if ((WalletPayUI.this.zQd == null) || (!paramAnonymousBoolean)) {
              break;
            }
            WalletPayUI.this.aF(-100, true);
            AppMethodBeat.o(69395);
            return;
          }
          int i;
          if (!bt.isNullOrNil(paramAnonymousString))
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.dcE)
          {
            com.tencent.mm.wallet_core.c.af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.ixc = paramAnonymousString;
            WalletPayUI.this.sv(false);
            com.tencent.mm.plugin.wallet_core.utils.f.eft();
            WalletPayUI.this.zQf = null;
            AppMethodBeat.o(69395);
            return;
            i = WalletPayUI.this.mPayInfo.dtb;
            break;
          }
        }
      }, new View.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69396);
          ad.i(WalletPayUI.this.TAG, "WalletPwdDialog event1 %s", new Object[] { bt.eGN().toString() });
          WalletPayUI.this.zQd = ((FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUI.this.zQd != null) {
            WalletPayUI.this.zQd.Aef = "";
          }
          WalletPayUI.this.c(false, 0, "");
          WalletPayUI.this.zRk.dismiss();
          WalletPayUI.this.ixc = null;
          WalletPayUI.this.zRk = null;
          WalletPayUI.this.zQf = null;
          AppMethodBeat.o(69396);
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          int i = 0;
          AppMethodBeat.i(69397);
          ad.i(WalletPayUI.this.TAG, "WalletPwdDialog event2 %s", new Object[] { bt.eGN().toString() });
          WalletPayUI.l(WalletPayUI.this);
          WalletPayUI.j(WalletPayUI.this);
          if (WalletPayUI.this.mPayInfo == null) {
            if (WalletPayUI.this.mPayInfo != null) {
              break label151;
            }
          }
          label151:
          for (String str = "";; str = WalletPayUI.this.mPayInfo.dcE)
          {
            com.tencent.mm.wallet_core.c.af.f(i, str, 10, "");
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            WalletPayUI.this.ixc = null;
            WalletPayUI.this.zRk = null;
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            WalletPayUI.this.zQf = null;
            AppMethodBeat.o(69397);
            return;
            i = WalletPayUI.this.mPayInfo.dtb;
            break;
          }
        }
      });
      this.zQf = ((com.tencent.mm.plugin.wallet_core.ui.f)this.zRk);
      AppMethodBeat.o(69451);
      return;
    }
  }
  
  protected void sv(boolean paramBoolean)
  {
    AppMethodBeat.i(69467);
    com.tencent.mm.plugin.wallet.pay.a.a.b localb = com.tencent.mm.plugin.wallet.pay.a.a.a(eap(), this.vIq, paramBoolean);
    if (this.vIq != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_reqKey", this.vIq.dcE);
      if ((this.vIq.Afx != null) && (this.vIq.Afx.size() > 0)) {
        localBundle.putString("key_TransId", ((Orders.Commodity)this.vIq.Afx.get(0)).dcF);
      }
      localBundle.putLong("key_SessionId", this.zRl);
      localb.setProcessName("PayProcess");
      localb.setProcessBundle(localBundle);
    }
    if (this.mPayInfo != null)
    {
      if ((this.mPayInfo.dtb != 6) || (this.mPayInfo.Cop != 100)) {
        break label255;
      }
      localb.setScene(100);
    }
    for (;;)
    {
      doSceneProgress(localb);
      if ((this.mPayInfo != null) && (8 == this.mPayInfo.dtb) && (this.mPayInfo.Cos != null))
      {
        long l = this.mPayInfo.Cos.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.vKh.f(13956, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - l) });
      }
      AppMethodBeat.o(69467);
      return;
      label255:
      localb.setScene(this.mPayInfo.dtb);
    }
  }
  
  protected final class a
  {
    protected a() {}
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(69426);
      WalletPayUI.this.zRi.removeAllViews();
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
        localCommodity = (Orders.Commodity)WalletPayUI.this.vIq.Afx.get(j);
        str2 = "";
        str1 = str2;
        if (WalletPayUI.this.mPayInfo != null) {
          if ((WalletPayUI.this.mPayInfo.dtb != 32) && (WalletPayUI.this.mPayInfo.dtb != 33) && (WalletPayUI.this.mPayInfo.dtb != 31))
          {
            str1 = str2;
            if (WalletPayUI.this.mPayInfo.dtb != 48) {}
          }
          else
          {
            str1 = WalletPayUI.this.mPayInfo.Cos.getString("extinfo_key_1", "");
            if (bt.isNullOrNil(str1)) {
              break label443;
            }
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.storage.af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(str1);
            if (localaf == null) {
              break label418;
            }
            str1 = localaf.ZX();
          }
        }
        label252:
        if (localCommodity != null)
        {
          if (bt.isNullOrNil(str1)) {
            break label461;
          }
          localTextView2.setText(str1);
          localTextView2.setVisibility(0);
          ((TextView)localView.findViewById(2131306799)).setVisibility(0);
          if (bt.isNullOrNil(localCommodity.desc)) {
            break label530;
          }
          localTextView1.setText(localCommodity.desc);
          localTextView1.setVisibility(8);
          ((TextView)localView.findViewById(2131306779)).setVisibility(8);
          if ((bt.isNullOrNil(str1)) && (bt.isNullOrNil(localCommodity.uoe))) {
            break label555;
          }
          localView.setVisibility(0);
        }
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        localView.measure(-2, -2);
        WalletPayUI.this.zRi.addView(localView);
        j += 1;
        break label41;
        if (WalletPayUI.this.zQW)
        {
          i = WalletPayUI.this.mCount;
          break;
        }
        i = 1;
        break;
        label418:
        ad.e(WalletPayUI.this.TAG, "can not found contact for user::".concat(String.valueOf(str1)));
        str1 = str2;
        break label252;
        label443:
        ad.e(WalletPayUI.this.TAG, "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        str1 = str2;
        break label252;
        label461:
        if (!bt.isNullOrNil(localCommodity.uoe))
        {
          localTextView2.setText(localCommodity.uoe);
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
    int aFj;
    WeakReference<WalletPayUI> kOy;
    long timestamp;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
 * JD-Core Version:    0.7.0.1
 */