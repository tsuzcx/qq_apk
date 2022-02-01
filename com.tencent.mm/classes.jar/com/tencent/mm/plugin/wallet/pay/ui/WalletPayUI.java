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
import com.tencent.mm.g.a.ye;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.g.a.yp.a;
import com.tencent.mm.g.a.yx;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.plugin.wallet_core.ui.n.b;
import com.tencent.mm.plugin.wallet_core.ui.s.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  private static boolean CJv;
  private static List<b> CJw;
  public FavorPayInfo CIL;
  private a CIM;
  com.tencent.mm.plugin.wallet_core.ui.f CIN;
  private boolean CIO;
  private com.tencent.mm.plugin.wallet.pay.a.d CIz;
  protected boolean CJA;
  private d.a CJB;
  protected boolean CJC;
  protected String CJD;
  protected boolean CJE;
  public Bundle CJF;
  protected boolean CJG;
  protected TextView CJH;
  protected TextView CJI;
  private TextView CJJ;
  protected TextView CJK;
  protected TextView CJL;
  protected TextView CJM;
  protected ImageView CJN;
  private TextView CJO;
  private TextView CJP;
  protected LinearLayout CJQ;
  protected a CJR;
  public Dialog CJS;
  private long CJT;
  private TextView CJU;
  private LinearLayout CJV;
  private boolean CJW;
  private boolean CJX;
  private boolean CJY;
  private boolean CJZ;
  private com.tencent.mm.plugin.wallet.pay.a.c.f CJx;
  protected com.tencent.mm.plugin.wallet_core.ui.d CJy;
  private boolean CJz;
  private boolean CKa;
  private int CKb;
  private boolean CKc;
  private boolean CKd;
  private com.tencent.mm.plugin.wallet.pay.a.c.f CKe;
  private boolean CKf;
  private boolean CKg;
  private int CKh;
  private Runnable CKi;
  private b CKj;
  private long CKk;
  protected ArrayList<Bankcard> CyC;
  protected Bankcard CyD;
  public String TAG;
  private boolean isPaySuccess;
  public String jqo;
  protected int mCount;
  protected PayInfo mPayInfo;
  private String yaF;
  protected com.tencent.mm.plugin.wallet.a yad;
  private com.tencent.mm.sdk.b.c ydz;
  protected Button yft;
  protected Orders ygb;
  
  static
  {
    AppMethodBeat.i(69482);
    CJv = false;
    CJw = new ArrayList();
    AppMethodBeat.o(69482);
  }
  
  public WalletPayUI()
  {
    AppMethodBeat.i(69427);
    this.TAG = "MicroMsg.WalletPayUI";
    this.ygb = null;
    this.CJx = null;
    this.mCount = 0;
    this.jqo = null;
    this.CyC = null;
    this.CyD = null;
    this.CIL = null;
    this.CJy = null;
    this.CJz = false;
    this.isPaySuccess = false;
    this.CJA = false;
    this.CJC = false;
    this.CJD = "";
    this.mPayInfo = null;
    this.CJE = false;
    this.CJF = null;
    this.CJG = false;
    this.CJT = 0L;
    this.CJW = true;
    this.CJX = false;
    this.CJY = false;
    this.CJZ = false;
    this.CKa = false;
    this.CKb = -1;
    this.CKc = false;
    this.CKd = false;
    this.yad = null;
    this.CKf = false;
    this.CKg = false;
    this.CIz = null;
    this.CKh = 0;
    this.CKi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69386);
        ad.i(WalletPayUI.this.TAG, "auto reset create flag");
        WalletPayUI.Jy();
        AppMethodBeat.o(69386);
      }
    };
    this.CKk = 0L;
    this.ydz = new com.tencent.mm.sdk.b.c() {};
    this.CIO = false;
    AppMethodBeat.o(69427);
  }
  
  private void Vp(int paramInt)
  {
    AppMethodBeat.i(69428);
    this.CKh = paramInt;
    ad.i(this.TAG, "markForceFinish errorType %s %s", new Object[] { Integer.valueOf(paramInt), bt.flS().toString() });
    AppMethodBeat.o(69428);
  }
  
  private void a(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    AppMethodBeat.i(69456);
    ad.i(this.TAG, "stopRealname realnameGuideFlag %s guide_type %s", new Object[] { paramf.dMS, Integer.valueOf(paramf.CIy) });
    label109:
    Object localObject;
    label150:
    int j;
    if (("1".equals(paramf.dMS)) || ("2".equals(paramf.dMS)))
    {
      this.CKe = paramf;
      this.CIz = paramf.CIz;
      this.CKc = true;
      this.ygb = paramf.ygb;
      if (this.ygb == null) {
        break label523;
      }
      i = this.ygb.CYk.size();
      this.mCount = i;
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("get mOrders! bankcardTag : ");
      if (this.ygb == null) {
        break label528;
      }
      paramf = Integer.valueOf(this.ygb.CPj);
      ad.d((String)localObject, paramf);
      aUW();
      if ((this.ygb != null) && (this.ygb.CYl != null))
      {
        this.CJy = com.tencent.mm.plugin.wallet_core.ui.e.Dcd.a(this.ygb);
        if (this.CJy != null)
        {
          if (this.CJy.eHm().size() > 0) {
            this.CJz = true;
          }
          this.CIL = this.CJy.aER(this.ygb.CYl.CGZ);
          this.CIL.CWL = this.CJy.aES(this.CIL.CWL);
          ad.i(this.TAG, "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", new Object[] { this.ygb.CYl.CGZ, this.CIL.CWL, this.CIL.CWL, this.CIL.toString() });
        }
      }
      if ((this.ygb != null) && (this.CyC != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.ygb);
        paramf = com.tencent.mm.plugin.report.service.g.yhR;
        j = this.mPayInfo.dCC;
        com.tencent.mm.plugin.wallet.a.s.eDp();
        if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGa()) {
          break label534;
        }
      }
    }
    label523:
    label528:
    label534:
    for (int i = 2;; i = 1)
    {
      paramf.f(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.ygb.dlx * 100.0D)), this.ygb.wCF });
      if ((this.ygb == null) || (this.ygb.CYk == null)) {
        break label598;
      }
      paramf = new LinkedList();
      localObject = this.ygb.CYk.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramf.add(((Orders.Commodity)((Iterator)localObject).next()).dlv);
      }
      this.CKe = null;
      break;
      i = 0;
      break label109;
      paramf = "";
      break label150;
    }
    if (paramf.size() > 0)
    {
      localObject = new yo();
      ((yo)localObject).dNu.dNw = paramf;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.yad != null) {
        this.yad.cp(10001, (String)paramf.get(0));
      }
    }
    label598:
    if ((this.ygb != null) && (this.ygb.CYI != null) && (this.ygb.CYI.CZF == 1) && (!bt.isNullOrNil(this.ygb.CYI.wBI)))
    {
      this.CJC = true;
      this.CJD = this.ygb.CYI.wBI;
    }
    com.tencent.mm.plugin.wallet.a.s.eDp();
    this.CyC = com.tencent.mm.plugin.wallet.a.s.eDq().uo(eDU());
    if (!bt.isNullOrNil(this.CJD))
    {
      this.CyD = eDR();
      paramf = bt.bI(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!bt.isNullOrNil(paramf)) {
        this.CyD = aEh(paramf);
      }
      this.yft.setClickable(true);
      if (bt.isNullOrNil(t.eFy().Dbi)) {
        break label1031;
      }
      this.CJO.setVisibility(0);
      this.CJO.setText(t.eFy().Dbi);
      label773:
      if ((this.ygb != null) && (this.CyC != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.ygb);
        paramf = com.tencent.mm.plugin.report.service.g.yhR;
        j = this.mPayInfo.dCC;
        com.tencent.mm.plugin.wallet.a.s.eDp();
        if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGa()) {
          break label1052;
        }
        i = 2;
        label832:
        paramf.f(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.ygb.dlx * 100.0D)), this.ygb.wCF });
      }
      if (this.CJX) {
        aQ(0, false);
      }
      if (getPayInfo().htZ != null) {
        break label1057;
      }
    }
    label1031:
    label1052:
    label1057:
    for (long l = 0L;; l = getPayInfo().htZ.getLong("wallet_pay_key_check_time"))
    {
      if (l > 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(641L, 4L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(641L, 5L, bt.Df(l), true);
      }
      if (this.CKk > 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(641L, 7L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(641L, 8L, bt.Df(this.CKk), true);
      }
      AppMethodBeat.o(69456);
      return;
      com.tencent.mm.plugin.wallet.a.s.eDp();
      this.CyD = com.tencent.mm.plugin.wallet.a.s.eDq().a(null, null, eDU(), false);
      break;
      this.CJO.setVisibility(8);
      this.CJO.setText("");
      break label773;
      i = 1;
      break label832;
    }
  }
  
  private Bankcard aEh(String paramString)
  {
    AppMethodBeat.i(69461);
    com.tencent.mm.plugin.wallet.a.s.eDp();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.eDq().un(true);
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
    if ("1".equals(paramf.dMS))
    {
      ad.i(this.TAG, "need realname verify");
      this.CJZ = true;
      paramf = new Bundle();
      paramf.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
      paramf.putString("realname_verify_process_jump_plugin", "wallet");
      isTransparent();
      if (this.mPayInfo != null) {
        i = this.mPayInfo.dCC;
      }
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf, null, i);
      AppMethodBeat.o(69474);
      return bool;
    }
    if ("2".equals(paramf.dMS))
    {
      ad.i(this.TAG, "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf.dMT, paramf.dMW, paramf.dMU, paramf.dMV, isTransparent(), null);
      AppMethodBeat.o(69474);
      return bool;
    }
    ad.i(this.TAG, "realnameGuideFlag =  " + paramf.dMS);
    AppMethodBeat.o(69474);
    return false;
  }
  
  private boolean eDG()
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
        m(-1, getIntent());
      }
      for (this.isPaySuccess = true;; this.isPaySuccess = false)
      {
        AppMethodBeat.o(69430);
        return true;
        ad.d(this.TAG, "pay cancel");
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
    ad.i(this.TAG, "hy: pay not end");
    AppMethodBeat.o(69430);
    return false;
  }
  
  private void eDI()
  {
    AppMethodBeat.i(69440);
    if (this.ygb == null)
    {
      ad.e(this.TAG, "updatePaymentMethodForFavor mOrders is null");
      AppMethodBeat.o(69440);
      return;
    }
    this.CJM.setVisibility(8);
    this.CJL.setVisibility(8);
    this.yft.setText(2131765657);
    this.CJU.setVisibility(0);
    this.CJV.setVisibility(0);
    View localView = this.CJV.findViewById(2131297100);
    Object localObject = this.CJV.findViewById(2131296454);
    final CheckedTextView localCheckedTextView1;
    final CheckedTextView localCheckedTextView2;
    int i;
    if ("CFT".equals(this.ygb.CYf))
    {
      ((View)localObject).setVisibility(8);
      localCheckedTextView1 = (CheckedTextView)this.CJV.findViewById(2131297092);
      localCheckedTextView2 = (CheckedTextView)this.CJV.findViewById(2131296453);
      localView.setEnabled(true);
      if ((this.ygb == null) || (this.ygb.CYk == null) || (this.ygb.CYk.size() <= 0)) {
        break label772;
      }
      if (this.ygb.CXU != 1) {
        break label574;
      }
      i = 1;
    }
    label772:
    for (;;)
    {
      label200:
      if (this.CyD == null)
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            localCheckedTextView1.setChecked(false);
            localCheckedTextView2.setChecked(true);
            WalletPayUI.a(WalletPayUI.this, true);
            WalletPayUI.e(WalletPayUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69425);
          }
        });
        this.CJU.setVisibility(0);
        this.CJV.setVisibility(0);
        if (this.CIL == null) {
          break label767;
        }
        this.CJy = com.tencent.mm.plugin.wallet_core.ui.e.Dcd.a(this.ygb);
        localObject = this.CJy.aEO(this.CIL.CWL);
        if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).CGY != 0.0D)) {
          break label767;
        }
        this.CJV.setVisibility(8);
        this.CJU.setVisibility(8);
      }
      label486:
      label767:
      for (int j = 1;; j = 0)
      {
        this.CJW = true;
        if (j != 0) {
          this.CJW = false;
        }
        localCheckedTextView1.setChecked(false);
        localCheckedTextView2.setChecked(true);
        ad.i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.ygb.CYm);
        if (this.ygb.CYm == 1)
        {
          this.CJV.findViewById(2131299147).setVisibility(0);
          ((TextView)this.CJV.findViewById(2131299146)).setText(this.ygb.CYn);
          if (!TextUtils.isEmpty(this.ygb.CYo))
          {
            ((TextView)this.CJV.findViewById(2131299862)).setText(" (" + this.ygb.CYo + ")");
            if ((this.CyD != null) && (this.CyD.eER()) && (!TextUtils.isEmpty(this.CyD.field_forbidWord)))
            {
              localView.setEnabled(false);
              localCheckedTextView1.setVisibility(8);
              ((TextView)this.CJV.findViewById(2131297107)).setText(this.CyD.field_forbidWord);
            }
          }
        }
        for (;;)
        {
          eDJ();
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
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              localCheckedTextView1.setChecked(true);
              localCheckedTextView2.setChecked(false);
              WalletPayUI.a(WalletPayUI.this, false);
              WalletPayUI.e(WalletPayUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69424);
            }
          });
          break label213;
          ((TextView)this.CJV.findViewById(2131299862)).setText("");
          break label486;
          this.CJV.findViewById(2131299147).setVisibility(8);
          if ((this.CyD != null) && (this.CyD.eER()) && (!TextUtils.isEmpty(this.CyD.field_forbidWord)))
          {
            localView.setEnabled(false);
            localCheckedTextView1.setVisibility(8);
            ((TextView)this.CJV.findViewById(2131297107)).setText(this.CyD.field_forbidWord);
          }
          else if ((this.CyD != null) && (this.CyD.eER()) && (TextUtils.isEmpty(this.CyD.field_forbidWord)) && (i == 0))
          {
            localCheckedTextView1.setChecked(true);
            localCheckedTextView2.setChecked(false);
            this.CJW = false;
          }
        }
      }
      label574:
      i = 0;
    }
  }
  
  private void eDJ()
  {
    AppMethodBeat.i(69441);
    if (this.CJW)
    {
      this.yft.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int j = 0;
          AppMethodBeat.i(69387);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.plugin.wallet.a.s.eDp();
          int i;
          if (com.tencent.mm.plugin.wallet.a.s.eDq().eGb())
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
            if (WalletPayUI.this.ygb.CYm != 1) {
              break label227;
            }
            com.tencent.mm.plugin.wallet.a.s.eDp();
            if (com.tencent.mm.plugin.wallet.a.s.eDq().eGb())
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
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dlu)
          {
            af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.f(WalletPayUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69387);
            return;
            i = WalletPayUI.this.mPayInfo.dCC;
            break;
            paramAnonymousView = WalletPayUI.this.mPayInfo.dlu;
            break label77;
            i = WalletPayUI.this.mPayInfo.dCC;
            break label125;
          }
          label227:
          ad.i(WalletPayUI.this.TAG, "SimpleReg , assigned userinfo pay! payWithNewBankcard");
          com.tencent.mm.plugin.wallet.a.s.eDp();
          if (com.tencent.mm.plugin.wallet.a.s.eDq().eGb())
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
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dlu)
          {
            af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.this.c(false, 0, "");
            break;
            i = WalletPayUI.this.mPayInfo.dCC;
            break label264;
          }
        }
      });
      AppMethodBeat.o(69441);
      return;
    }
    this.yft.setOnClickListener(new WalletPayUI.3(this));
    AppMethodBeat.o(69441);
  }
  
  private void eDO()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(69447);
    com.tencent.mm.plugin.report.service.g.yhR.f(13958, new Object[] { Integer.valueOf(1) });
    if ((this.mPayInfo != null) && (8 == this.mPayInfo.dCC))
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(13955, new Object[] { Integer.valueOf(2) });
      if (this.mPayInfo.htZ != null)
      {
        long l = this.mPayInfo.htZ.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.g.yhR.f(13956, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    Object localObject;
    if (this.CIL != null)
    {
      this.CJy = com.tencent.mm.plugin.wallet_core.ui.e.Dcd.a(this.ygb);
      localObject = this.CJy.aEO(this.CIL.CWL);
      if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).CGY != 0.0D)) {}
    }
    for (;;)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.wallet.a.s.eDp();
        if (com.tencent.mm.plugin.wallet.a.s.eDq().eGb())
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
          for (localObject = "";; localObject = this.mPayInfo.dlu)
          {
            af.f(i, (String)localObject, 3, "");
            eDP();
            AppMethodBeat.o(69447);
            return;
            i = this.mPayInfo.dCC;
            break;
          }
        }
        ad.i(this.TAG, "has useful bankcard ! payWithOldBankcard zeroPay");
        eDB();
        AppMethodBeat.o(69447);
        return;
      }
      if (this.CJC)
      {
        ad.i(this.TAG, "hy: start do pay with force use given bankcard");
        if (!bt.isNullOrNil(this.CJD))
        {
          this.CyD = eDR();
          eDB();
          AppMethodBeat.o(69447);
          return;
        }
        com.tencent.mm.plugin.wallet.a.s.eDp();
        if (com.tencent.mm.plugin.wallet.a.s.eDq().eGc()) {
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
          i = this.mPayInfo.dCC;
          break;
          localObject = this.mPayInfo.dlu;
          break label370;
          com.tencent.mm.plugin.wallet.a.s.eDp();
        } while (!com.tencent.mm.plugin.wallet.a.s.eDq().eGb());
        if (this.mPayInfo == null)
        {
          i = 0;
          label440:
          if (this.mPayInfo != null) {
            break label474;
          }
        }
        label474:
        for (localObject = "";; localObject = this.mPayInfo.dlu)
        {
          af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.dCC;
          break label440;
        }
      }
      localObject = bt.bI(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!bt.isNullOrNil((String)localObject)) {
        this.CyD = aEh((String)localObject);
      }
      if (this.CyD == null)
      {
        if ((this.CyC != null) && (this.CyC.size() > 0))
        {
          ad.i(this.TAG, " no last pay bankcard ! jump to select bankcard!");
          d(false, 8, "");
          AppMethodBeat.o(69447);
          return;
        }
        ad.i(this.TAG, "default bankcard not found! payWithNewBankcard");
        com.tencent.mm.plugin.wallet.a.s.eDp();
        if (com.tencent.mm.plugin.wallet.a.s.eDq().eGc()) {
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
          i = this.mPayInfo.dCC;
          break;
          localObject = this.mPayInfo.dlu;
          break label614;
          com.tencent.mm.plugin.wallet.a.s.eDp();
        } while (!com.tencent.mm.plugin.wallet.a.s.eDq().eGb());
        if (this.mPayInfo == null)
        {
          i = 0;
          label684:
          if (this.mPayInfo != null) {
            break label718;
          }
        }
        label718:
        for (localObject = "";; localObject = this.mPayInfo.dlu)
        {
          af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.dCC;
          break label684;
        }
      }
      i = this.CyD.a(this.ygb.CPj, this.ygb);
      if (this.yad != null) {
        this.yad.cp(10002, "");
      }
      if (i != 0)
      {
        ad.i(this.TAG, "main bankcard(" + i + ") is useless! jump to select bankcard!");
        d(false, i, "");
        AppMethodBeat.o(69447);
        return;
      }
      com.tencent.mm.plugin.wallet.a.s.eDp();
      if (com.tencent.mm.plugin.wallet.a.s.eDq().eGb())
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
        for (localObject = "";; localObject = this.mPayInfo.dlu)
        {
          af.f(i, (String)localObject, 3, "");
          eDP();
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.dCC;
          break;
        }
      }
      ad.i(this.TAG, "has useful bankcard ! payWithOldBankcard");
      eDB();
      AppMethodBeat.o(69447);
      return;
      i = 0;
    }
  }
  
  private void eDP()
  {
    AppMethodBeat.i(69448);
    ug(true);
    com.tencent.mm.plugin.wallet_core.utils.f.eIT();
    AppMethodBeat.o(69448);
  }
  
  private Bankcard eDR()
  {
    AppMethodBeat.i(69460);
    com.tencent.mm.plugin.wallet.a.s.eDp();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.eDq().un(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (bt.nullAsNil(this.CJD).equals(localBankcard.field_bindSerial))
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
  
  private boolean eDS()
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
  
  private boolean eDT()
  {
    AppMethodBeat.i(69468);
    if ((this.ygb != null) && (this.ygb.CYb))
    {
      com.tencent.mm.kernel.g.ajD();
      if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(196614, Boolean.TRUE)).booleanValue())
      {
        Object localObject = getLayoutInflater().inflate(2131496007, null);
        CheckBox localCheckBox = (CheckBox)((View)localObject).findViewById(2131305890);
        fJ((View)localObject);
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
  
  private boolean eDt()
  {
    AppMethodBeat.i(69449);
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICA, Integer.valueOf(0))).intValue();
    if ((com.tencent.mm.sdk.a.b.fjN()) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)) {
      i = 1;
    }
    if ((i == 1) || ((this.ygb != null) && (this.ygb.CYH == 1)))
    {
      AppMethodBeat.o(69449);
      return true;
    }
    AppMethodBeat.o(69449);
    return false;
  }
  
  private void fJ(View paramView)
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
    if ((this.mPayInfo != null) && (this.mPayInfo.dCC == 46) && (this.ygb != null))
    {
      paramIntent.putExtra("key_total_fee", this.ygb.dlx);
      ad.i(this.TAG, "sentCancelEvent set fee:%s", new Object[] { Double.valueOf(this.ygb.dlx) });
    }
    yp localyp = new yp();
    localyp.dNx.intent = paramIntent;
    yp.a locala;
    if (this.CKh == 1)
    {
      localyp.dNx.dNy = 1000;
      localyp.dNx.result = paramInt;
      locala = localyp.dNx;
      if (this.mPayInfo != null) {
        break label217;
      }
    }
    label217:
    for (paramIntent = "";; paramIntent = this.mPayInfo.dlu)
    {
      locala.dlu = paramIntent;
      localyp.dNx.dNA = 1;
      if ((this.mPayInfo != null) && (paramInt == 0)) {
        com.tencent.mm.plugin.wallet.pay.a.b.b.aA(this.mPayInfo.dlu, this.mPayInfo.dCC, this.mPayInfo.channel);
      }
      com.tencent.mm.sdk.b.a.IbL.l(localyp);
      AppMethodBeat.o(69437);
      return;
      if (this.CKh != 2) {
        break;
      }
      localyp.dNx.dNy = 1001;
      break;
    }
  }
  
  protected final void aQ(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(69455);
    com.tencent.mm.plugin.report.service.g.yhR.f(13958, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.g.yhR.f(13955, new Object[] { Integer.valueOf(4) });
    if (this.mPayInfo == null) {
      if (this.mPayInfo != null) {
        break label226;
      }
    }
    label226:
    for (Object localObject = "";; localObject = this.mPayInfo.dlu)
    {
      af.f(i, (String)localObject, 11, "");
      localObject = getInput();
      ((Bundle)localObject).putInt("key_main_bankcard_state", paramInt);
      ((Bundle)localObject).putParcelable("key_orders", this.ygb);
      ((Bundle)localObject).putParcelable("key_pay_info", this.mPayInfo);
      ((Bundle)localObject).putParcelable("key_authen", eDL());
      ((Bundle)localObject).putString("key_pwd1", this.jqo);
      ((Bundle)localObject).putInt("key_pay_flag", 3);
      ((Bundle)localObject).putInt("key_err_code", -1004);
      ((Bundle)localObject).putParcelable("key_favor_pay_info", this.CIL);
      ((Bundle)localObject).putBoolean("key_is_filter_bank_type", paramBoolean);
      if (this.CyD != null) {
        ((Bundle)localObject).putString("key_is_cur_bankcard_bind_serial", this.CyD.field_bindSerial);
      }
      av((Bundle)localObject);
      AppMethodBeat.o(69455);
      return;
      i = this.mPayInfo.dCC;
      break;
    }
  }
  
  protected final boolean aUW()
  {
    AppMethodBeat.i(69459);
    String str2;
    String str1;
    if ((this.ygb == null) || (this.ygb.CYk == null) || (this.ygb.CYk.size() <= 0))
    {
      ad.w(this.TAG, "mOrders info is Illegal!");
      if ((this.CJx != null) && (this.CJx.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      str2 = getString(2131765550);
      str1 = str2;
      if (this.CJx != null)
      {
        str1 = str2;
        if (!bt.isNullOrNil(this.CJx.errMsg)) {
          str1 = this.CJx.errMsg;
        }
      }
      ad.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.d(getContext(), str1, "", new WalletPayUI.19(this));
      AppMethodBeat.o(69459);
      return false;
    }
    if ((this.CJC) && (!bt.isNullOrNil(this.CJD)) && (eDR() == null))
    {
      if ((this.CJx != null) && (this.CJx.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      ad.w(this.TAG, "hy: should use given bankcard, but resolved as null. show error msg and quit");
      str2 = getString(2131765550);
      str1 = str2;
      if (this.CJx != null)
      {
        str1 = str2;
        if (!bt.isNullOrNil(this.CJx.errMsg)) {
          str1 = this.CJx.errMsg;
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
  
  protected void av(Bundle paramBundle)
  {
    AppMethodBeat.i(69471);
    this.CJA = true;
    if (this.ygb != null)
    {
      paramBundle.putInt("key_support_bankcard", this.ygb.CPj);
      paramBundle.putString("key_reqKey", this.ygb.dlu);
      if ((this.ygb.CYk != null) && (this.ygb.CYk.size() > 0)) {
        paramBundle.putString("key_TransId", ((Orders.Commodity)this.ygb.CYk.get(0)).dlv);
      }
      paramBundle.putLong("key_SessionId", this.CJT);
    }
    if (this.mPayInfo != null) {
      paramBundle.putInt("key_scene", this.mPayInfo.dCC);
    }
    if (!eDM()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      paramBundle.putInt("is_deduct_open", this.CKb);
      this.CJB = new d.a()
      {
        public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(69415);
          ad.i(WalletPayUI.this.TAG, "pay process end");
          WalletPayUI.this.CJA = false;
          paramAnonymousBundle = new Intent();
          AppMethodBeat.o(69415);
          return paramAnonymousBundle;
        }
      };
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, paramBundle, this.CJB);
      AppMethodBeat.o(69471);
      return;
    }
  }
  
  protected final void c(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69452);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
    com.tencent.mm.plugin.wallet.a.s.eDp();
    ad.d(str, com.tencent.mm.plugin.wallet.a.s.eDq().eGa() + ", need confirm ? " + paramBoolean);
    if (paramBoolean)
    {
      if (!bt.isNullOrNil(paramString)) {
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
          WalletPayUI.this.eDQ();
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
      eDQ();
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
      eDB();
    }
    AppMethodBeat.o(69466);
  }
  
  public final void d(boolean paramBoolean, final int paramInt, String paramString)
  {
    AppMethodBeat.i(69453);
    ad.d(this.TAG, "pay with select bankcard! need confirm ? ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (!bt.isNullOrNil(paramString)) {
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
            WalletPayUI.this.uf(true);
            AppMethodBeat.o(69401);
            return;
          }
          WalletPayUI.this.aQ(paramInt, false);
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
      if (eDt())
      {
        uf(true);
        AppMethodBeat.o(69453);
        return;
      }
      aQ(paramInt, false);
      AppMethodBeat.o(69453);
      return;
    }
  }
  
  public final void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69472);
    ad.i(this.TAG, "onGenFinish callback");
    if (paramBoolean)
    {
      ad.i(this.TAG, "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.dvf = paramString1;
      this.mPayInfo.dvg = paramString2;
      ug(false);
      com.tencent.mm.plugin.wallet_core.utils.f.eIT();
      AppMethodBeat.o(69472);
      return;
    }
    ad.e(this.TAG, "onGenFinish callback, result.isSuccess is false");
    ug(false);
    com.tencent.mm.plugin.wallet_core.utils.f.eIT();
    AppMethodBeat.o(69472);
  }
  
  protected void eDB()
  {
    AppMethodBeat.i(69450);
    uf(false);
    AppMethodBeat.o(69450);
  }
  
  protected void eDH()
  {
    int i = 2;
    AppMethodBeat.i(69432);
    com.tencent.mm.plugin.report.service.g.yhR.f(11850, new Object[] { Integer.valueOf(2), Integer.valueOf(this.mPayInfo.dCC) });
    if (this.mPayInfo.dCC == 11) {
      i = 3;
    }
    Object localObject = this.mPayInfo;
    if ((localObject == null) || (bt.isNullOrNil(((PayInfo)localObject).dlu)))
    {
      ad.i("MicroMsg.CgiManager", "no payInfo or reqKey");
      localObject = null;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessName("PayProcess");
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessSessionId(this.CJT);
        if ((this.mPayInfo.dCC != 6) || (this.mPayInfo.FlP != 100)) {
          break label446;
        }
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(100);
        label134:
        if (!this.mPayInfo.FlQ) {
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
      String str = ((PayInfo)localObject).dlu;
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
      ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(this.mPayInfo.dCC);
      break label134;
    }
  }
  
  public final void eDK()
  {
    AppMethodBeat.i(69442);
    com.tencent.mm.plugin.wallet.a.j localj = this.CJy.aEO(this.CIL.CWL);
    List localList = this.CJy.eHm();
    com.tencent.mm.plugin.wallet.a.h localh = this.CJy.DbY;
    Object localObject1 = "";
    double d2;
    Object localObject2;
    int i;
    double d1;
    if (localj != null)
    {
      d2 = localj.CHg;
      if (d2 > 0.0D)
      {
        localObject2 = localj.CHi;
        int j = 1;
        localObject1 = localObject2;
        i = j;
        d1 = d2;
        if (!bt.isNullOrNil(localj.CHj))
        {
          localObject1 = (String)localObject2 + "," + localj.CHj;
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
      if ((d1 > 0.0D) && (localh != null) && (localh.CHc == 0))
      {
        if (localj != null) {
          this.CJH.setText(com.tencent.mm.wallet_core.ui.e.C(localj.CHf));
        }
        this.CJK.setText(com.tencent.mm.wallet_core.ui.e.aYF(this.ygb.wCF));
        this.CJJ.setText(com.tencent.mm.wallet_core.ui.e.d(this.ygb.dlx, this.ygb.wCF));
        this.CJJ.setVisibility(0);
      }
      for (;;)
      {
        if (!bt.isNullOrNil((String)localObject2)) {
          this.CJP.setText((CharSequence)localObject2);
        }
        AppMethodBeat.o(69442);
        return;
        this.CJH.setText(com.tencent.mm.wallet_core.ui.e.C(this.ygb.dlx));
        this.CJK.setText(com.tencent.mm.wallet_core.ui.e.aYF(this.ygb.wCF));
        this.CJJ.setVisibility(8);
      }
      i = 0;
      d1 = d2;
      continue;
      i = 0;
      d1 = 0.0D;
    }
  }
  
  protected final Authen eDL()
  {
    AppMethodBeat.i(69443);
    Authen localAuthen = new Authen();
    if (eDM()) {}
    for (localAuthen.dDp = 3;; localAuthen.dDp = 6)
    {
      if (!bt.isNullOrNil(this.jqo)) {
        localAuthen.CTP = this.jqo;
      }
      if (this.CyD != null)
      {
        localAuthen.wBI = this.CyD.field_bindSerial;
        localAuthen.dkR = this.CyD.field_bankcardType;
      }
      if ((this.CIL != null) && (this.CJy != null) && (this.CJy.eHj()))
      {
        localAuthen.CTZ = this.CIL.CWL;
        localAuthen.CTY = this.CIL.CWO;
      }
      localAuthen.xnF = this.mPayInfo;
      AppMethodBeat.o(69443);
      return localAuthen;
    }
  }
  
  protected final boolean eDM()
  {
    AppMethodBeat.i(69444);
    if ((this.CyD != null) && (this.ygb != null) && (this.ygb.CPj == 3))
    {
      if (this.CyD.eEU())
      {
        AppMethodBeat.o(69444);
        return true;
      }
      AppMethodBeat.o(69444);
      return false;
    }
    if ((this.ygb != null) && (!Bankcard.Vx(this.ygb.CPj)))
    {
      AppMethodBeat.o(69444);
      return true;
    }
    AppMethodBeat.o(69444);
    return false;
  }
  
  protected final void eDN()
  {
    AppMethodBeat.i(69445);
    ue(true);
    AppMethodBeat.o(69445);
  }
  
  protected final void eDQ()
  {
    AppMethodBeat.i(69454);
    Bundle localBundle = getIntent().getExtras();
    com.tencent.mm.plugin.wallet.a.s.eDp();
    if (com.tencent.mm.plugin.wallet.a.s.eDq().eGa()) {}
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("key_pay_flag", i);
      localBundle.putParcelable("key_orders", this.ygb);
      localBundle.putParcelable("key_pay_info", this.mPayInfo);
      localBundle.putParcelable("key_favor_pay_info", this.CIL);
      av(localBundle);
      AppMethodBeat.o(69454);
      return;
    }
  }
  
  protected final boolean eDU()
  {
    return (this.mPayInfo != null) && (this.mPayInfo.dCC != 11);
  }
  
  public void finish()
  {
    AppMethodBeat.i(69434);
    ad.i(this.TAG, "finish %s %s mPayResultType:%s", new Object[] { Integer.valueOf(hashCode()), bt.flS().toString(), Integer.valueOf(this.mPayResultType) });
    cancelQRPay();
    if ((this.ygb != null) && (!this.ygb.CYk.isEmpty())) {
      getIntent().putExtra("key_trans_id", ((Orders.Commodity)this.ygb.CYk.get(0)).dlv);
    }
    if (this.mPayInfo != null) {
      getIntent().putExtra("key_reqKey", this.mPayInfo.dlu);
    }
    com.tencent.mm.wallet_core.d locald;
    if (this.isPaySuccess)
    {
      if (this.ygb != null) {
        getIntent().putExtra("key_total_fee", this.ygb.dlx);
      }
      getIntent().putExtra("key_pay_reslut_type", 1);
      m(-1, getIntent());
      setResult(-1, getIntent());
      locald = getProcess();
      if (locald != null) {
        if (locald.Lwt == null) {
          break label717;
        }
      }
    }
    label408:
    label439:
    label570:
    label581:
    label717:
    for (Object localObject = (Context)locald.Lwt.get();; localObject = null)
    {
      if (this == localObject)
      {
        ad.i(this.TAG, "remove process end callback to prevent ui leak");
        locald.fQO();
      }
      super.finish();
      AppMethodBeat.o(69434);
      return;
      if ((this.mPayInfo != null) && (this.mPayInfo.dCC == 8) && (this.ygb != null))
      {
        this.mPayInfo.FlX = 0;
        doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.a(eDL(), this.ygb, true), false);
        if (this.mPayInfo.htZ != null)
        {
          long l = this.mPayInfo.htZ.getLong("extinfo_key_9");
          com.tencent.mm.plugin.report.service.g.yhR.f(13956, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      m(0, getIntent());
      getIntent().putExtra("key_pay_reslut_type", this.mPayResultType);
      int i;
      if (this.CKh == 1)
      {
        getIntent().putExtra("key_pay_reslut_type", 1000);
        setResult(0, getIntent());
        com.tencent.mm.plugin.wallet.a.s.eDp();
        if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGc()) {
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
      for (localObject = "";; localObject = this.mPayInfo.dlu)
      {
        af.f(i, (String)localObject, 18, "");
        localObject = com.tencent.mm.wallet_core.a.aYz("PayProcess").iterator();
        while (((Iterator)localObject).hasNext())
        {
          locald = (com.tencent.mm.wallet_core.d)((Iterator)localObject).next();
          locald.K(new Object[] { "specEndProcessWithoutFinish" });
          if (locald.dxT != null) {
            locald.dxT.clear();
          }
          com.tencent.mm.wallet_core.a.remove(locald.getClass().hashCode());
          locald.eDs();
        }
        break;
        if (this.CKh != 2) {
          break label408;
        }
        getIntent().putExtra("key_pay_reslut_type", 1001);
        break label408;
        i = this.mPayInfo.dCC;
        break label439;
      }
      label593:
      com.tencent.mm.plugin.wallet.a.s.eDp();
      if (com.tencent.mm.plugin.wallet.a.s.eDq().eGb())
      {
        if (this.mPayInfo == null)
        {
          i = 0;
          label615:
          if (this.mPayInfo != null) {
            break label649;
          }
        }
        for (localObject = "";; localObject = this.mPayInfo.dlu)
        {
          af.f(i, (String)localObject, 4, "");
          break;
          i = this.mPayInfo.dCC;
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
      for (localObject = "";; localObject = this.mPayInfo.dlu)
      {
        af.f(i, (String)localObject, 7, "");
        break;
        i = this.mPayInfo.dCC;
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
    this.yft = ((Button)findViewById(2131306815));
    this.yft.setClickable(false);
    this.yft.setEnabled(false);
    this.CJH = ((TextView)findViewById(2131306804));
    this.CJI = ((TextView)findViewById(2131306803));
    this.CJK = ((TextView)findViewById(2131306785));
    this.CJP = ((TextView)findViewById(2131306781));
    this.CJJ = ((TextView)findViewById(2131306791));
    this.CJO = ((TextView)findViewById(2131306811));
    this.CJJ.getPaint().setFlags(16);
    this.CJL = ((TextView)findViewById(2131306816));
    this.CJM = ((TextView)findViewById(2131306812));
    this.CJM.setOnClickListener(new w()
    {
      public final void caN()
      {
        AppMethodBeat.i(69416);
        WalletPayUI.this.c(false, 0, "");
        AppMethodBeat.o(69416);
      }
    });
    this.CJN = ((ImageView)findViewById(2131306778));
    this.CJN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69417);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (WalletPayUI.this.CJE) {
          WalletPayUI.this.CJN.setImageResource(2131233555);
        }
        for (WalletPayUI.this.CJE = false;; WalletPayUI.this.CJE = true)
        {
          WalletPayUI.this.CJR.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69417);
          return;
          WalletPayUI.this.CJN.setImageResource(2131233558);
        }
      }
    });
    this.CJQ = ((LinearLayout)findViewById(2131306788));
    this.CJR = new a();
    this.yft.setOnClickListener(new w()
    {
      public final void caN()
      {
        AppMethodBeat.i(69418);
        com.tencent.mm.plugin.wallet.a.s.eDp();
        int i;
        if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGb())
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
        for (String str = "";; str = WalletPayUI.this.mPayInfo.dlu)
        {
          af.f(i, str, 6, "");
          WalletPayUI.this.eDN();
          WalletPayUI.this.CJG = true;
          AppMethodBeat.o(69418);
          return;
          i = WalletPayUI.this.mPayInfo.dCC;
          break;
        }
      }
    });
    this.yft.setText(2131765657);
    this.CJU = ((TextView)findViewById(2131303187));
    this.CJV = ((LinearLayout)findViewById(2131303186));
    updateView();
    AppMethodBeat.o(69438);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69464);
    if (this.CKc)
    {
      String str1 = this.TAG;
      boolean bool1;
      label87:
      String str2;
      int i;
      if ((getPayInfo() == null) || (!getPayInfo().ucG))
      {
        bool1 = true;
        ad.i(str1, "case 1 %s,  stack %s", new Object[] { Boolean.valueOf(bool1), bt.flS().toString() });
        str1 = this.TAG;
        com.tencent.mm.plugin.wallet.a.s.eDp();
        if (com.tencent.mm.plugin.wallet.a.s.eDq().eGa()) {
          break label196;
        }
        bool1 = true;
        ad.d(str1, "case 2 %s,", new Object[] { Boolean.valueOf(bool1) });
        str2 = this.TAG;
        if (this.CyC != null) {
          break label201;
        }
        i = 0;
        label121:
        if (this.CyD != null) {
          break label212;
        }
      }
      label196:
      label201:
      label212:
      for (str1 = "";; str1 = this.CyD.field_forbidWord)
      {
        ad.d(str2, "case 3 mBankcardList %s, mDefaultBankcard %s", new Object[] { Integer.valueOf(i), str1 });
        if ((getPayInfo() != null) && (getPayInfo().ucG)) {
          break label224;
        }
        ad.i(this.TAG, "get isTransparent1");
        AppMethodBeat.o(69464);
        return false;
        bool1 = false;
        break;
        bool1 = false;
        break label87;
        i = this.CyC.size();
        break label121;
      }
      label224:
      com.tencent.mm.plugin.wallet.a.s.eDp();
      if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGa())
      {
        ad.i(this.TAG, "get isTransparent2");
        AppMethodBeat.o(69464);
        return false;
      }
      if ((this.CyC != null) && ((this.CyC.size() == 0) || ((this.CyD != null) && (!bt.isNullOrNil(this.CyD.field_forbidWord)))))
      {
        str1 = this.TAG;
        if ((this.CyC != null) && (this.CyC.size() == 0))
        {
          bool1 = true;
          if ((this.CyD == null) || (bt.isNullOrNil(this.CyD.field_forbidWord))) {
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
          this.CKb = paramIntent.getIntExtra("auto_deduct_flag", -1);
          if ((this.ygb != null) && (this.ygb.CYp != null)) {
            this.ygb.CYp.CKb = this.CKb;
          }
          getPayInfo().FlU = this.CKb;
          if (this.CKb == 1)
          {
            getPayInfo().FlV = paramIntent.getStringExtra("deduct_bank_type");
            getPayInfo().FlW = paramIntent.getStringExtra("deduct_bind_serial");
          }
        }
        this.CKa = true;
        onProgressFinish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(13958, new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(69462);
        return;
        finish();
      }
      this.CJS.dismiss();
      this.CJG = false;
      eDH();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69429);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.TAG = ("MicroMsg.WalletPayUI@" + hashCode());
    if (CJv)
    {
      ad.w(this.TAG, "has Undestory WalletPayUI!");
      com.tencent.mm.plugin.report.service.g.yhR.n(965L, 1L, 1L);
      Vp(2);
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    CJv = true;
    long l = System.currentTimeMillis();
    int j = getIntent().getIntExtra("key_context_hashcode", -1);
    paramBundle = new b[CJw.size()];
    ad.i(this.TAG, "WalletPayUI check %s this %s fromHashCode %s", new Object[] { Integer.valueOf(CJw.size()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
    paramBundle = (b[])CJw.toArray(paramBundle);
    int k = paramBundle.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = paramBundle[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localObject.lNs.get();
      if (localWalletPayUI != null)
      {
        ad.w(this.TAG, "has old payui, both finish %s", new Object[] { Integer.valueOf(localWalletPayUI.hashCode()) });
        if ((j != localObject.aHQ) || (j == -1)) {
          break label290;
        }
        localWalletPayUI.Vp(2);
        com.tencent.mm.plugin.report.service.g.yhR.n(965L, 41L, 1L);
      }
      for (;;)
      {
        CJw.remove(localObject);
        localWalletPayUI.finish();
        i += 1;
        break;
        label290:
        localWalletPayUI.Vp(1);
        com.tencent.mm.plugin.report.service.g.yhR.n(965L, 40L, 1L);
      }
    }
    this.CKj = new b((byte)0);
    this.CKj.timestamp = l;
    this.CKj.aHQ = j;
    this.CKj.lNs = new WeakReference(this);
    CJw.add(this.CKj);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.e(this.TAG, "hy: account not ready. finish now");
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    getWindow().getDecorView().postDelayed(this.CKi, 5000L);
    this.CKk = bt.flT();
    com.tencent.mm.sdk.b.a.IbL.c(this.ydz);
    com.tencent.mm.plugin.wallet_core.model.k.Vy(5);
    this.yad = com.tencent.mm.plugin.wallet.a.aS(getIntent());
    setMMTitle(2131765707);
    this.mPayInfo = getPayInfo();
    this.CJC = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
    this.CJD = bt.bI(getIntent().getStringExtra("key_force_use_bind_serail"), "");
    this.yaF = getIntent().getStringExtra("key_receiver_true_name");
    if ((this.mPayInfo == null) || (this.mPayInfo.FlT == 0L))
    {
      this.CJT = System.currentTimeMillis();
      com.tencent.mm.plugin.wallet.a.s.eDp();
      if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGa())
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
      if (eDG()) {
        break label763;
      }
      ad.d(this.TAG, "PayInfo = " + this.mPayInfo);
      if ((this.mPayInfo == null) || (bt.isNullOrNil(this.mPayInfo.dlu))) {
        break label705;
      }
      eDH();
      com.tencent.mm.plugin.secinforeport.a.d.yBQ.asyncReportPaySecurityInfoThroughCgi();
      initView();
    }
    for (;;)
    {
      if (this.mPayInfo != null) {
        com.tencent.mm.plugin.wallet.pay.a.b.aEa(this.mPayInfo.FlZ);
      }
      AppMethodBeat.o(69429);
      return;
      this.CJT = this.mPayInfo.FlT;
      break;
      label683:
      i = this.mPayInfo.dCC;
      break label559;
      label694:
      paramBundle = this.mPayInfo.dlu;
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
    if (this.CIM != null)
    {
      this.CIM.closeTipDialog();
      this.CIM.release();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.ydz);
    this.CIN = null;
    getWindow().getDecorView().removeCallbacks(this.CKi);
    CJw.remove(this.CKj);
    CJv = false;
    long l = System.currentTimeMillis();
    b[] arrayOfb = new b[CJw.size()];
    arrayOfb = (b[])CJw.toArray(arrayOfb);
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localb.lNs.get();
      if ((localWalletPayUI != null) && (l - localb.timestamp > 600000L))
      {
        ad.w(this.TAG, "has old payui, both finish");
        com.tencent.mm.plugin.report.service.g.yhR.n(965L, 2L, 1L);
        CJw.remove(localb);
        localWalletPayUI.Vp(1);
        localWalletPayUI.finish();
      }
      i += 1;
    }
    if (this.mPayInfo != null) {
      com.tencent.mm.plugin.wallet.pay.a.b.aEb(this.mPayInfo.FlZ);
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
      if ((this.CJS != null) && (this.mPayInfo != null) && (this.mPayInfo.ucG) && (!this.mNetSceneMgr.isProcessing())) {
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
    if (!eDG())
    {
      ad.w(this.TAG, "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
      if (paramIntent.getBooleanExtra("send_cancel_event", true)) {
        m(0, getIntent());
      }
      this.isPaySuccess = false;
    }
    if (paramIntent.getBooleanExtra("direc_change_bankcard", false))
    {
      uf(true);
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false))) {
      this.CJX = true;
    }
    for (int i = 1; i != 0; i = 0)
    {
      ad.i(this.TAG, "isFromBindCard is true");
      eDH();
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_is_realname_verify_process", false)))
    {
      this.CJY = true;
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
    if (this.CIN != null) {
      this.CIN.onActivityPause();
    }
    AppMethodBeat.o(69473);
  }
  
  public boolean onProgressFinish()
  {
    boolean bool2 = false;
    AppMethodBeat.i(69463);
    ad.i(this.TAG, "onProgressFinish isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.CKf) });
    com.tencent.mm.sdk.b.a.IbL.l(new ye());
    int i;
    int j;
    label93:
    Object localObject;
    label104:
    boolean bool1;
    if ((this.ygb != null) && (this.ygb.CYp != null) && (!this.CKa))
    {
      i = 1;
      if ((i == 0) && (!eDS()))
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
      if (!this.CKf) {
        break label163;
      }
      ue(true);
      bool1 = true;
    }
    for (;;)
    {
      AppMethodBeat.o(69463);
      return bool1;
      i = 0;
      break;
      label140:
      j = this.mPayInfo.dCC;
      break label93;
      label151:
      localObject = this.mPayInfo.dlu;
      break label104;
      label163:
      if (this.CJZ)
      {
        bool1 = true;
      }
      else if (i != 0)
      {
        localObject = new Intent(this, WalletPayDeductUI.class);
        ((Intent)localObject).putExtra("orders", this.ygb);
        startActivityForResult((Intent)localObject, 0);
        bool1 = true;
      }
      else if (getContentView().getVisibility() != 0)
      {
        if ((!this.CJG) && (aUW()))
        {
          ue(true);
          this.CJG = true;
        }
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (getContentView().getVisibility() == 0)
        {
          bool1 = bool2;
          if (this.ygb != null)
          {
            bool1 = bool2;
            if (this.ygb.CYp != null)
            {
              bool1 = bool2;
              if (this.yft.isEnabled())
              {
                bool1 = bool2;
                if (!this.CKd)
                {
                  this.yft.performClick();
                  this.CKd = true;
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
    ad.i(this.TAG, "hy: onResume isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.CKf) });
    if (!isProcessing())
    {
      if (!bt.isNullOrNil(this.CJD)) {
        this.CyD = eDR();
      }
    }
    else
    {
      if (!this.CKg) {
        break label149;
      }
      ad.i(this.TAG, "onResume isResumePassFinish");
      this.CKg = false;
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(69433);
      return;
      if (this.CyD == null)
      {
        com.tencent.mm.plugin.wallet.a.s.eDp();
        this.CyD = com.tencent.mm.plugin.wallet.a.s.eDq().a(null, null, eDU(), false);
        break;
      }
      com.tencent.mm.plugin.wallet.a.s.eDp();
      this.CyD = com.tencent.mm.plugin.wallet.a.s.eDq().a(null, this.CyD.field_bindSerial, eDU(), false);
      break;
      label149:
      if ((this.CJA) && (getContentViewVisibility() != 0) && ((this.CJS == null) || (!this.CJS.isShowing())))
      {
        ad.i(this.TAG, "hy: has started process and is transparent and no pwd appeared. finish self");
        finish();
      }
      else if (this.CIN != null)
      {
        this.CIN.eHn();
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
    label308:
    label343:
    label503:
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.c.f))
      {
        this.mPayResultType = 1;
        this.CJx = ((com.tencent.mm.plugin.wallet.pay.a.c.f)paramn);
        paramString = (com.tencent.mm.plugin.wallet.pay.a.c.f)paramn;
        if (paramString.isJumpRemind())
        {
          paramn = paramString.getJumpRemind();
          paramn.fRu();
          paramn.a(this, new com.tencent.mm.wallet_core.c.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(69403);
              if (paramn.fRt())
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
              if (paramn.fRt())
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
              if (paramn.fRt())
              {
                WalletPayUI.a(WalletPayUI.this, paramString);
                AppMethodBeat.o(69404);
                return;
              }
              WalletPayUI.this.eDH();
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
      paramString.putParcelable("key_bankcard", this.CyD);
      paramString.putString("key_bank_type", this.CyD.field_bankcardType);
      if (!bt.isNullOrNil(this.jqo)) {
        paramString.putString("key_pwd1", this.jqo);
      }
      paramString.putString("kreq_token", paramn.getToken());
      paramString.putParcelable("key_authen", paramn.CIo);
      if (!paramn.CIm)
      {
        bool = true;
        paramString.putBoolean("key_need_verify_sms", bool);
        paramString.putInt("key_can_verify_tail", paramn.CIs);
        paramString.putString("key_verify_tail_wording", paramn.CIt);
        localObject1 = getInput();
        if (paramn.CIu != 1) {
          break label628;
        }
        bool = true;
        ((Bundle)localObject1).putBoolean("key_block_bind_new_card", bool);
        if (!bt.isNullOrNil(paramn.CIp)) {
          break label634;
        }
        paramString.putString("key_mobile", this.CyD.field_mobile);
        paramString.putString("key_QADNA_URL", paramn.CIq);
        if (!paramn.isPaySuccess) {
          break label649;
        }
        if (this.yad != null)
        {
          this.yad.cp(10003, "");
          localObject1 = this.yad;
          com.tencent.mm.plugin.report.service.g.yhR.f(13455, new Object[] { ((com.tencent.mm.plugin.wallet.a)localObject1).Cwr, Long.valueOf(System.currentTimeMillis()), ((com.tencent.mm.plugin.wallet.a)localObject1).Cws });
        }
        paramString.putParcelable("key_orders", paramn.CIn);
        if (this.mPayInfo != null)
        {
          ad.i(this.TAG, "payscene %d", new Object[] { Integer.valueOf(this.mPayInfo.dCC) });
          if (8 == this.mPayInfo.dCC)
          {
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwl, Boolean.TRUE);
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("pwd", this.jqo);
        localObject2 = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class);
        paramInt1 = 0;
        if (!((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).cPN()) {
          break label663;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
        ((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).a(paramn.eDv(), true, this.mPayInfo.CYi, (Bundle)localObject1);
        paramString.putInt("key_pay_flag", 3);
        paramn = paramn.wya;
        if (paramn != null) {
          paramString.putParcelable("key_realname_guide_helper", paramn);
        }
        av(paramString);
        AppMethodBeat.o(69458);
        return true;
        bool = false;
        break;
        label628:
        bool = false;
        break label308;
        label634:
        paramString.putString("key_mobile", paramn.CIp);
        break label343;
        label649:
        paramString.putParcelable("key_orders", this.ygb);
        break label503;
        label663:
        if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).cPO()) {
          paramInt1 = 2;
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("pwd", this.jqo);
      localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.mPayInfo.DiI == 1)
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
      this.CJF = getInput();
      this.CJF.putParcelable("key_pay_info", this.mPayInfo);
      this.CJF.putParcelable("key_bankcard", this.CyD);
      if (!bt.isNullOrNil(this.jqo)) {
        this.CJF.putString("key_pwd1", this.jqo);
      }
      this.CJF.putString("kreq_token", paramn.getToken());
      this.CJF.putParcelable("key_authen", paramn.CIo);
      localObject1 = this.CJF;
      if (!paramn.CIm)
      {
        bool = true;
        label980:
        ((Bundle)localObject1).putBoolean("key_need_verify_sms", bool);
        this.CJF.putString("key_mobile", this.CyD.field_mobile);
        this.CJF.putInt("key_err_code", paramInt2);
        this.CJF.putParcelable("key_orders", this.ygb);
        if (!bt.isNullOrNil(paramString)) {
          break label1446;
        }
        paramString = getString(2131765705, new Object[] { this.CyD.field_desc, this.CyD.field_mobile });
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
          WalletPayUI.this.CJF.putInt("key_pay_flag", 3);
          WalletPayUI.this.av(WalletPayUI.this.CJF);
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
      this.mPayInfo.FlS = paramInt2;
      eDB();
      AppMethodBeat.o(69458);
      return true;
      this.mPayInfo.FlS = paramInt2;
      bool = false;
      if (paramInt2 == 100100) {
        bool = true;
      }
      if (this.CIM == null) {
        this.CIM = new a(this, this);
      }
      this.CIM.b(bool, this.mPayInfo.dvd, this.mPayInfo.dlu);
      ad.i(this.TAG, "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool)));
      AppMethodBeat.o(69458);
      return true;
      if ((this.CyD == null) || (this.ygb == null)) {
        break;
      }
      this.CyD.CUC = this.ygb.dlu;
      if ((this.CyC != null) && (this.CyC.size() > 1)) {
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
      this.CKc = true;
      eDS();
      if (paramInt2 == 416)
      {
        ad.e(this.TAG, "errCode is 416 need real name verify!");
        this.mPayResultType = 2;
        this.CJZ = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
        paramString.putString("realname_verify_process_jump_plugin", "wallet");
        if (this.mPayInfo != null) {}
        for (paramInt1 = this.mPayInfo.dCC;; paramInt1 = 0)
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
  
  protected final void ue(boolean paramBoolean)
  {
    AppMethodBeat.i(69446);
    if ((paramBoolean) && (!eDT()))
    {
      AppMethodBeat.o(69446);
      return;
    }
    if (this.CIL != null)
    {
      this.CJy = com.tencent.mm.plugin.wallet_core.ui.e.Dcd.a(this.ygb);
      com.tencent.mm.plugin.wallet.a.j localj = this.CJy.aEO(this.CIL.CWL);
      if ((localj == null) || (localj.CGY != 0.0D)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.CKe != null)
      {
        if (this.CKe.CIy == 0)
        {
          ad.i(this.TAG, "need real name,stop");
          b(this.CKe);
          AppMethodBeat.o(69446);
          return;
        }
        if ((this.CKe.CIy == 1) && (i != 0))
        {
          ad.i(this.TAG, "need real name, zero stop");
          b(this.CKe);
        }
      }
      if (this.CIz != null)
      {
        if ((this.CIz.CIh == 1) && (!bt.isNullOrNil(this.CIz.kzK)) && (!bt.isNullOrNil(this.CIz.kzL)) && (!bt.isNullOrNil(this.CIz.CIi)))
        {
          if ((this.mPayInfo != null) && (this.ygb != null) && (this.ygb.CYk != null) && (this.ygb.CYk.size() > 0))
          {
            if (this.mPayInfo.dCC != 8) {
              break label371;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.ygb.CYk.get(0)).dlv });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.CIz.CIi, "", this.CIz.kzL, this.CIz.kzK, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69389);
                ad.i(WalletPayUI.this.TAG, "click continue pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.ygb != null) && (WalletPayUI.this.ygb.CYk != null) && (WalletPayUI.this.ygb.CYk.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.dCC != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.g.yhR.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.ygb.CYk.get(0)).dlv });
                }
                for (;;)
                {
                  WalletPayUI.g(WalletPayUI.this);
                  AppMethodBeat.o(69389);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.g.yhR.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.ygb.CYk.get(0)).dlv });
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69390);
                ad.i(WalletPayUI.this.TAG, "click cancel pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.ygb != null) && (WalletPayUI.this.ygb.CYk != null) && (WalletPayUI.this.ygb.CYk.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.dCC != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.g.yhR.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.ygb.CYk.get(0)).dlv });
                }
                for (;;)
                {
                  WalletPayUI.this.finish();
                  AppMethodBeat.o(69390);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.g.yhR.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.ygb.CYk.get(0)).dlv });
                }
              }
            });
            AppMethodBeat.o(69446);
            return;
            label371:
            com.tencent.mm.plugin.report.service.g.yhR.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.ygb.CYk.get(0)).dlv });
          }
        }
        if ((this.CIz.CIh == 2) && (!bt.isNullOrNil(this.CIz.CIi)) && (!bt.isNullOrNil(this.CIz.CIj)))
        {
          ad.i(this.TAG, "pay has been blocked");
          if ((this.mPayInfo != null) && (this.ygb != null) && (this.ygb.CYk != null) && (this.ygb.CYk.size() > 0))
          {
            if (this.mPayInfo.dCC != 8) {
              break label624;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.ygb.CYk.get(0)).dlv });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.CIz.CIi, "", this.CIz.CIj, false, new WalletPayUI.6(this));
            AppMethodBeat.o(69446);
            return;
            label624:
            com.tencent.mm.plugin.report.service.g.yhR.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.ygb.CYk.get(0)).dlv });
          }
        }
      }
      eDO();
      AppMethodBeat.o(69446);
      return;
    }
  }
  
  protected final void uf(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(69451);
    if (!aUW())
    {
      AppMethodBeat.o(69451);
      return;
    }
    this.CIO = false;
    ad.i(this.TAG, "pay with old bankcard! from statck %s", new Object[] { bt.flS().toString() });
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label230;
      }
    }
    label230:
    for (Object localObject = "";; localObject = this.mPayInfo.dlu)
    {
      af.f(i, (String)localObject, 8, "");
      if (this.CJS != null)
      {
        ad.w(this.TAG, "close previous cashier dialog");
        this.CJS.dismiss();
      }
      this.CIO = false;
      if (!eDt()) {
        break label242;
      }
      this.CJS = new WcPayCashierDialog(getContext());
      localObject = (WcPayCashierDialog)this.CJS;
      PayInfo localPayInfo = this.mPayInfo;
      Orders localOrders = this.ygb;
      FavorPayInfo localFavorPayInfo = this.CIL;
      Bankcard localBankcard = this.CyD;
      if (!this.CJC) {
        bool = true;
      }
      ((WcPayCashierDialog)localObject).a(localPayInfo, localOrders, localFavorPayInfo, localBankcard, bool, paramBoolean);
      ((WcPayCashierDialog)localObject).Dlh = new WcPayCashierDialog.a()
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, Bankcard paramAnonymousBankcard)
        {
          AppMethodBeat.i(69392);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            ad.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.g.yhR.n(965L, 3L, 1L);
            AppMethodBeat.o(69392);
            return;
          }
          WalletPayUI.i(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.CIL = paramAnonymousFavorPayInfo;
          WalletPayUI.this.CyD = paramAnonymousBankcard;
          paramAnonymousBankcard = WalletPayUI.this.TAG;
          int i;
          if (WalletPayUI.this.CIL == null)
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.dlu)
          {
            af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.jqo = paramAnonymousString;
            WalletPayUI.this.ug(false);
            com.tencent.mm.plugin.wallet_core.utils.f.eIT();
            AppMethodBeat.o(69392);
            return;
            paramAnonymousFavorPayInfo = WalletPayUI.this.CIL.toString();
            break;
            i = WalletPayUI.this.mPayInfo.dCC;
            break label131;
          }
        }
        
        public final void eCm()
        {
          AppMethodBeat.i(69394);
          ad.i(WalletPayUI.this.TAG, "click add new bankcard");
          Object localObject = com.tencent.mm.plugin.wallet_core.model.g.eFb();
          if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bni())
          {
            com.tencent.mm.ui.base.h.c(WalletPayUI.this.getContext(), ((com.tencent.mm.plugin.wallet_core.model.g)localObject).wBJ, WalletPayUI.this.getString(2131755906), true);
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
          for (localObject = "";; localObject = WalletPayUI.this.mPayInfo.dlu)
          {
            af.f(i, (String)localObject, 14, "");
            WalletPayUI.this.CJS.dismiss();
            WalletPayUI.this.CJS = null;
            WalletPayUI.this.eDQ();
            AppMethodBeat.o(69394);
            return;
            i = WalletPayUI.this.mPayInfo.dCC;
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
          for (String str = "";; str = WalletPayUI.this.mPayInfo.dlu)
          {
            af.f(i, str, 10, "");
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            AppMethodBeat.o(69393);
            return;
            i = WalletPayUI.this.mPayInfo.dCC;
            break;
          }
        }
      };
      ((WcPayCashierDialog)localObject).show();
      addDialog((Dialog)localObject);
      AppMethodBeat.o(69451);
      return;
      i = this.mPayInfo.dCC;
      break;
    }
    label242:
    if (!this.CJC) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.CJS = com.tencent.mm.plugin.wallet_core.ui.s.a(this, paramBoolean, this.ygb, this.CIL, this.CyD, this.mPayInfo, this.yaF, new s.c()new View.OnClickListener
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(69395);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            ad.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.g.yhR.n(965L, 3L, 1L);
            AppMethodBeat.o(69395);
            return;
          }
          WalletPayUI.k(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.CIL = paramAnonymousFavorPayInfo;
          String str = WalletPayUI.this.TAG;
          if (WalletPayUI.this.CIL == null) {}
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.CIL.toString())
          {
            ad.i(str, "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s", new Object[] { paramAnonymousFavorPayInfo, Boolean.valueOf(paramAnonymousBoolean) });
            if ((WalletPayUI.this.CIL == null) || (!paramAnonymousBoolean)) {
              break;
            }
            WalletPayUI.this.aQ(-100, true);
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.dlu)
          {
            af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.jqo = paramAnonymousString;
            WalletPayUI.this.ug(false);
            com.tencent.mm.plugin.wallet_core.utils.f.eIT();
            WalletPayUI.this.CIN = null;
            AppMethodBeat.o(69395);
            return;
            i = WalletPayUI.this.mPayInfo.dCC;
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i(WalletPayUI.this.TAG, "WalletPwdDialog event1 %s", new Object[] { bt.flS().toString() });
          WalletPayUI.this.CIL = ((FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUI.this.CIL != null) {
            WalletPayUI.this.CIL.CWP = "";
          }
          WalletPayUI.this.d(false, 0, "");
          WalletPayUI.this.CJS.dismiss();
          WalletPayUI.this.jqo = null;
          WalletPayUI.this.CJS = null;
          WalletPayUI.this.CIN = null;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69396);
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          int i = 0;
          AppMethodBeat.i(69397);
          ad.i(WalletPayUI.this.TAG, "WalletPwdDialog event2 %s", new Object[] { bt.flS().toString() });
          WalletPayUI.l(WalletPayUI.this);
          WalletPayUI.j(WalletPayUI.this);
          if (WalletPayUI.this.mPayInfo == null) {
            if (WalletPayUI.this.mPayInfo != null) {
              break label151;
            }
          }
          label151:
          for (String str = "";; str = WalletPayUI.this.mPayInfo.dlu)
          {
            af.f(i, str, 10, "");
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            WalletPayUI.this.jqo = null;
            WalletPayUI.this.CJS = null;
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            WalletPayUI.this.CIN = null;
            AppMethodBeat.o(69397);
            return;
            i = WalletPayUI.this.mPayInfo.dCC;
            break;
          }
        }
      });
      this.CIN = ((com.tencent.mm.plugin.wallet_core.ui.f)this.CJS);
      AppMethodBeat.o(69451);
      return;
    }
  }
  
  protected void ug(boolean paramBoolean)
  {
    AppMethodBeat.i(69467);
    com.tencent.mm.plugin.wallet.pay.a.a.b localb = com.tencent.mm.plugin.wallet.pay.a.a.a(eDL(), this.ygb, paramBoolean);
    if (this.ygb != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_reqKey", this.ygb.dlu);
      if ((this.ygb.CYk != null) && (this.ygb.CYk.size() > 0)) {
        localBundle.putString("key_TransId", ((Orders.Commodity)this.ygb.CYk.get(0)).dlv);
      }
      localBundle.putLong("key_SessionId", this.CJT);
      localb.setProcessName("PayProcess");
      localb.setProcessBundle(localBundle);
    }
    if (this.mPayInfo != null)
    {
      if ((this.mPayInfo.dCC != 6) || (this.mPayInfo.FlP != 100)) {
        break label255;
      }
      localb.setScene(100);
    }
    for (;;)
    {
      doSceneProgress(localb);
      if ((this.mPayInfo != null) && (8 == this.mPayInfo.dCC) && (this.mPayInfo.htZ != null))
      {
        long l = this.mPayInfo.htZ.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.g.yhR.f(13956, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - l) });
      }
      AppMethodBeat.o(69467);
      return;
      label255:
      localb.setScene(this.mPayInfo.dCC);
    }
  }
  
  protected final void updateView()
  {
    AppMethodBeat.i(69439);
    if ((this.ygb != null) && (this.ygb.CYk != null) && (this.ygb.CYk.size() > 0))
    {
      this.CJH.setText(com.tencent.mm.wallet_core.ui.e.C(this.ygb.dlx));
      this.CJK.setText(com.tencent.mm.wallet_core.ui.e.aYF(this.ygb.wCF));
      this.CJR.notifyDataSetChanged();
      if (this.ygb.CYk.size() > 1)
      {
        this.CJN.setVisibility(0);
        this.CJI.setText(getString(2131765708, new Object[] { ((Orders.Commodity)this.ygb.CYk.get(0)).desc, this.ygb.CYk.size() }));
        this.CJE = false;
      }
    }
    else
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.dCC == 48)) {
        this.CJI.setText(2131762090);
      }
      this.CJL.setVisibility(8);
      this.CJM.setVisibility(8);
      this.CJU.setVisibility(8);
      this.CJV.setVisibility(8);
      this.yft.setText(2131765657);
      if ((this.CyD == null) || (!this.CyD.eER())) {
        break label542;
      }
      if (bt.isNullOrNil(this.CyD.field_forbidWord)) {
        break label522;
      }
      this.CJL.setText(this.CyD.field_forbidWord);
      this.CJL.setVisibility(4);
      this.CJM.setVisibility(8);
      com.tencent.mm.plugin.wallet.a.s.eDp();
      if (com.tencent.mm.plugin.wallet.a.s.eDq().eGb()) {
        eDI();
      }
      label329:
      com.tencent.mm.plugin.wallet.a.s.eDp();
      if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGb())
      {
        com.tencent.mm.plugin.wallet.a.s.eDp();
        if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGc()) {
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
      if ((i != 0) && (this.CIL != null) && (this.CJy != null) && (this.CJz) && (this.ygb != null))
      {
        eDK();
        this.CJP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69423);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            int i;
            if (WalletPayUI.this.mPayInfo == null)
            {
              i = 0;
              if (WalletPayUI.this.mPayInfo != null) {
                break label137;
              }
            }
            label137:
            for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dlu)
            {
              af.f(i, paramAnonymousView, 12, "");
              com.tencent.mm.plugin.wallet_core.ui.n.a(WalletPayUI.this.getContext(), WalletPayUI.this.ygb, WalletPayUI.this.CIL.CWL, new n.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  int j = 1;
                  AppMethodBeat.i(69422);
                  WalletPayUI.this.CIL = paramAnonymous2FavorPayInfo;
                  Object localObject = WalletPayUI.this.TAG;
                  int i;
                  label82:
                  label98:
                  boolean bool;
                  if (paramAnonymous2FavorPayInfo == null)
                  {
                    paramAnonymous2FavorPayInfo = "";
                    ad.i((String)localObject, "WalletFavorDialog onSelectionDone %s", new Object[] { paramAnonymous2FavorPayInfo });
                    if (WalletPayUI.this.CIL != null)
                    {
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label467;
                      }
                      i = 0;
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label485;
                      }
                      paramAnonymous2FavorPayInfo = "";
                      af.f(i, paramAnonymous2FavorPayInfo, 15, WalletPayUI.this.CIL.CWL);
                      if ((WalletPayUI.this.CyD != null) && (!com.tencent.mm.plugin.wallet_core.ui.d.a(WalletPayUI.this.CIL, WalletPayUI.this.CyD))) {
                        break label502;
                      }
                      WalletPayUI.this.CJM.setVisibility(8);
                      WalletPayUI.this.yft.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69419);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bd(paramAnonymous3View);
                          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                          ad.i(WalletPayUI.this.TAG, "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
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
                    ad.i(WalletPayUI.this.TAG, "needBindBankCard %s", new Object[] { Boolean.valueOf(bool) });
                    WalletPayUI.c(WalletPayUI.this).setVisibility(0);
                    WalletPayUI.d(WalletPayUI.this).setVisibility(0);
                    if (WalletPayUI.this.CIL != null)
                    {
                      WalletPayUI.this.CJy = com.tencent.mm.plugin.wallet_core.ui.e.Dcd.a(WalletPayUI.this.ygb);
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.CJy.aEO(WalletPayUI.this.CIL.CWL);
                      if ((paramAnonymous2FavorPayInfo != null) && (paramAnonymous2FavorPayInfo.CGY == 0.0D))
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
                        WalletPayUI.this.CJL.setVisibility(8);
                        WalletPayUI.this.CJM.setVisibility(0);
                        WalletPayUI.this.yft.setOnClickListener(new View.OnClickListener()
                        {
                          public final void onClick(View paramAnonymous3View)
                          {
                            AppMethodBeat.i(69421);
                            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                            localb.bd(paramAnonymous3View);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                            WalletPayUI.this.eDN();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(69421);
                          }
                        });
                      }
                      if (i != 0) {
                        WalletPayUI.this.CJM.setVisibility(8);
                      }
                      WalletPayUI.this.eDK();
                      AppMethodBeat.o(69422);
                      return;
                      paramAnonymous2FavorPayInfo = paramAnonymous2FavorPayInfo.toString();
                      break;
                      label467:
                      i = WalletPayUI.this.mPayInfo.dCC;
                      break label82;
                      label485:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.mPayInfo.dlu;
                      break label98;
                      label502:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.CJy.aEO(WalletPayUI.this.CIL.CWL);
                      if ((paramAnonymous2FavorPayInfo == null) || (!WalletPayUI.this.CyD.eER())) {
                        break label644;
                      }
                      com.tencent.mm.plugin.wallet.a.s.eDp();
                      localObject = com.tencent.mm.plugin.wallet.a.s.eDq().CzB;
                      double d = paramAnonymous2FavorPayInfo.CGY;
                      if ((localObject == null) || (((Bankcard)localObject).CUD >= d)) {
                        break label644;
                      }
                      ad.i(WalletPayUI.this.TAG, "balance not meet");
                      WalletPayUI.this.CJM.setVisibility(8);
                      WalletPayUI.this.yft.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69420);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bd(paramAnonymous3View);
                          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                          ad.i(WalletPayUI.this.TAG, "Balance amount not meet, after favor selection! payWithNewBankcard");
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
              i = WalletPayUI.this.mPayInfo.dCC;
              break;
            }
          }
        });
        localLinearLayout.setVisibility(0);
        if ((this.ygb == null) || (this.CyC == null) || (this.mPayInfo == null)) {
          break label571;
        }
        this.yft.setClickable(true);
        this.yft.setEnabled(true);
      }
      for (;;)
      {
        if (this.ygb == null) {
          this.CJM.setVisibility(8);
        }
        AppMethodBeat.o(69439);
        return;
        this.CJI.setText(((Orders.Commodity)this.ygb.CYk.get(0)).desc);
        this.CJN.setVisibility(8);
        break;
        com.tencent.mm.plugin.wallet.a.s.eDp();
        if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGb()) {
          break label329;
        }
        eDI();
        break label329;
        com.tencent.mm.plugin.wallet.a.s.eDp();
        if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGc()) {
          break label329;
        }
        eDI();
        break label329;
        localLinearLayout.setVisibility(8);
        break label424;
        this.yft.setClickable(false);
        this.yft.setEnabled(false);
      }
    }
  }
  
  protected final class a
  {
    protected a() {}
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(69426);
      WalletPayUI.this.CJQ.removeAllViews();
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
        localCommodity = (Orders.Commodity)WalletPayUI.this.ygb.CYk.get(j);
        str2 = "";
        str1 = str2;
        if (WalletPayUI.this.mPayInfo != null) {
          if ((WalletPayUI.this.mPayInfo.dCC != 32) && (WalletPayUI.this.mPayInfo.dCC != 33) && (WalletPayUI.this.mPayInfo.dCC != 31))
          {
            str1 = str2;
            if (WalletPayUI.this.mPayInfo.dCC != 48) {}
          }
          else
          {
            str1 = WalletPayUI.this.mPayInfo.htZ.getString("extinfo_key_1", "");
            if (bt.isNullOrNil(str1)) {
              break label443;
            }
            com.tencent.mm.kernel.g.ajD();
            am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTj(str1);
            if (localam == null) {
              break label418;
            }
            str1 = localam.adv();
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
          if ((bt.isNullOrNil(str1)) && (bt.isNullOrNil(localCommodity.wCu))) {
            break label555;
          }
          localView.setVisibility(0);
        }
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        localView.measure(-2, -2);
        WalletPayUI.this.CJQ.addView(localView);
        j += 1;
        break label41;
        if (WalletPayUI.this.CJE)
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
        if (!bt.isNullOrNil(localCommodity.wCu))
        {
          localTextView2.setText(localCommodity.wCu);
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
    WeakReference<WalletPayUI> lNs;
    long timestamp;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
 * JD-Core Version:    0.7.0.1
 */