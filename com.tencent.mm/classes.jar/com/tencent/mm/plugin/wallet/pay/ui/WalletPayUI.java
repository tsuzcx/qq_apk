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
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.aaw;
import com.tencent.mm.f.a.abg;
import com.tencent.mm.f.a.abh;
import com.tencent.mm.f.a.abh.a;
import com.tencent.mm.f.a.abp;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.a.c.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.o.b;
import com.tencent.mm.plugin.wallet_core.ui.t;
import com.tencent.mm.plugin.wallet_core.ui.t.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
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
  private static boolean OyJ;
  private static List<b> OyK;
  private String IoL;
  protected com.tencent.mm.plugin.wallet.a Iol;
  private IListener IrT;
  protected Button Iub;
  protected Orders Ivh;
  protected ArrayList<Bankcard> OmN;
  protected Bankcard OmO;
  private com.tencent.mm.plugin.wallet.pay.a.d OxM;
  public FavorPayInfo OxY;
  private a OxZ;
  private com.tencent.mm.plugin.wallet.pay.a.c.f OyL;
  protected com.tencent.mm.plugin.wallet_core.ui.e OyM;
  private boolean OyN;
  protected boolean OyO;
  private d.a OyP;
  protected boolean OyQ;
  protected String OyR;
  protected boolean OyS;
  public Bundle OyT;
  protected boolean OyU;
  protected TextView OyV;
  protected TextView OyW;
  private TextView OyX;
  protected TextView OyY;
  protected TextView OyZ;
  com.tencent.mm.plugin.wallet_core.ui.g Oya;
  private boolean Oyb;
  protected TextView Oza;
  protected ImageView Ozb;
  private TextView Ozc;
  private TextView Ozd;
  protected LinearLayout Oze;
  protected a Ozf;
  public Dialog Ozg;
  private long Ozh;
  private TextView Ozi;
  private LinearLayout Ozj;
  private boolean Ozk;
  private boolean Ozl;
  private boolean Ozm;
  private boolean Ozn;
  private boolean Ozo;
  private int Ozp;
  private boolean Ozq;
  private boolean Ozr;
  private com.tencent.mm.plugin.wallet.pay.a.c.f Ozs;
  private boolean Ozt;
  private boolean Ozu;
  private int Ozv;
  private Runnable Ozw;
  private b Ozx;
  private long Ozy;
  public String TAG;
  private boolean isPaySuccess;
  protected int mCount;
  protected PayInfo mPayInfo;
  public String njf;
  
  static
  {
    AppMethodBeat.i(69482);
    OyJ = false;
    OyK = new ArrayList();
    AppMethodBeat.o(69482);
  }
  
  public WalletPayUI()
  {
    AppMethodBeat.i(69427);
    this.TAG = "MicroMsg.WalletPayUI";
    this.Ivh = null;
    this.OyL = null;
    this.mCount = 0;
    this.njf = null;
    this.OmN = null;
    this.OmO = null;
    this.OxY = null;
    this.OyM = null;
    this.OyN = false;
    this.isPaySuccess = false;
    this.OyO = false;
    this.OyQ = false;
    this.OyR = "";
    this.mPayInfo = null;
    this.OyS = false;
    this.OyT = null;
    this.OyU = false;
    this.Ozh = 0L;
    this.Ozk = true;
    this.Ozl = false;
    this.Ozm = false;
    this.Ozn = false;
    this.Ozo = false;
    this.Ozp = -1;
    this.Ozq = false;
    this.Ozr = false;
    this.Iol = null;
    this.Ozt = false;
    this.Ozu = false;
    this.OxM = null;
    this.Ozv = 0;
    this.Ozw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69386);
        Log.i(WalletPayUI.this.TAG, "auto reset create flag");
        WalletPayUI.Yy();
        AppMethodBeat.o(69386);
      }
    };
    this.Ozy = 0L;
    this.IrT = new IListener() {};
    this.Oyb = false;
    AppMethodBeat.o(69427);
  }
  
  private void a(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    AppMethodBeat.i(69456);
    Log.i(this.TAG, "stopRealname realnameGuideFlag %s guide_type %s", new Object[] { paramf.gat, Integer.valueOf(paramf.OxL) });
    label109:
    Object localObject;
    label150:
    int j;
    if (("1".equals(paramf.gat)) || ("2".equals(paramf.gat)))
    {
      this.Ozs = paramf;
      this.OxM = paramf.OxM;
      this.Ozq = true;
      this.Ivh = paramf.Ivh;
      if (this.Ivh == null) {
        break label523;
      }
      i = this.Ivh.ORd.size();
      this.mCount = i;
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("get mOrders! bankcardTag : ");
      if (this.Ivh == null) {
        break label528;
      }
      paramf = Integer.valueOf(this.Ivh.OIp);
      Log.d((String)localObject, paramf);
      bAu();
      if ((this.Ivh != null) && (this.Ivh.ORe != null))
      {
        this.OyM = com.tencent.mm.plugin.wallet_core.ui.f.OVk.a(this.Ivh);
        if (this.OyM != null)
        {
          if (this.OyM.gLg().size() > 0) {
            this.OyN = true;
          }
          this.OxY = this.OyM.bhv(this.Ivh.ORe.Owm);
          this.OxY.OPI = this.OyM.bhw(this.OxY.OPI);
          Log.i(this.TAG, "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", new Object[] { this.Ivh.ORe.Owm, this.OxY.OPI, this.OxY.OPI, this.OxY.toString() });
        }
      }
      if ((this.Ivh != null) && (this.OmN != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.j.a(this.mPayInfo, this.Ivh);
        paramf = com.tencent.mm.plugin.report.service.h.IzE;
        j = this.mPayInfo.fOY;
        s.gGL();
        if (!s.gGM().gJQ()) {
          break label534;
        }
      }
    }
    label523:
    label528:
    label534:
    for (int i = 2;; i = 1)
    {
      paramf.a(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.Ivh.fwy * 100.0D)), this.Ivh.GHz });
      if ((this.Ivh == null) || (this.Ivh.ORd == null)) {
        break label598;
      }
      paramf = new LinkedList();
      localObject = this.Ivh.ORd.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramf.add(((Orders.Commodity)((Iterator)localObject).next()).fww);
      }
      this.Ozs = null;
      break;
      i = 0;
      break label109;
      paramf = "";
      break label150;
    }
    if (paramf.size() > 0)
    {
      localObject = new abg();
      ((abg)localObject).gaW.gaY = paramf;
      EventCenter.instance.publish((IEvent)localObject);
      if (this.Iol != null) {
        this.Iol.cH(10001, (String)paramf.get(0));
      }
    }
    label598:
    if ((this.Ivh != null) && (this.Ivh.ORB != null) && (this.Ivh.ORB.OSH == 1) && (!Util.isNullOrNil(this.Ivh.ORB.GGC)))
    {
      this.OyQ = true;
      this.OyR = this.Ivh.ORB.GGC;
    }
    s.gGL();
    this.OmN = s.gGM().Cf(gGW());
    if (!Util.isNullOrNil(this.OyR))
    {
      this.OmO = gHo();
      paramf = Util.nullAs(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!Util.isNullOrNil(paramf)) {
        this.OmO = bgH(paramf);
      }
      this.Iub.setClickable(true);
      if (Util.isNullOrNil(u.gJo().OUk)) {
        break label1031;
      }
      this.Ozc.setVisibility(0);
      this.Ozc.setText(u.gJo().OUk);
      label773:
      if ((this.Ivh != null) && (this.OmN != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.j.a(this.mPayInfo, this.Ivh);
        paramf = com.tencent.mm.plugin.report.service.h.IzE;
        j = this.mPayInfo.fOY;
        s.gGL();
        if (!s.gGM().gJQ()) {
          break label1052;
        }
        i = 2;
        label832:
        paramf.a(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.Ivh.fwy * 100.0D)), this.Ivh.GHz });
      }
      if (this.Ozl) {
        bz(0, false);
      }
      if (getPayInfo().lfu != null) {
        break label1057;
      }
    }
    label1031:
    label1052:
    label1057:
    for (long l = 0L;; l = getPayInfo().lfu.getLong("wallet_pay_key_check_time"))
    {
      if (l > 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(641L, 4L, 1L, true);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(641L, 5L, Util.milliSecondsToNow(l), true);
      }
      if (this.Ozy > 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(641L, 7L, 1L, true);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(641L, 8L, Util.milliSecondsToNow(this.Ozy), true);
      }
      AppMethodBeat.o(69456);
      return;
      s.gGL();
      this.OmO = s.gGM().a(null, null, gGW(), false);
      break;
      this.Ozc.setVisibility(8);
      this.Ozc.setText("");
      break label773;
      i = 1;
      break label832;
    }
  }
  
  private void aml(int paramInt)
  {
    AppMethodBeat.i(69428);
    this.Ozv = paramInt;
    Log.i(this.TAG, "markForceFinish errorType %s %s", new Object[] { Integer.valueOf(paramInt), Util.getStack().toString() });
    AppMethodBeat.o(69428);
  }
  
  private boolean b(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    int i = 0;
    AppMethodBeat.i(69474);
    boolean bool;
    if ("1".equals(paramf.gat))
    {
      Log.i(this.TAG, "need realname verify");
      this.Ozn = true;
      paramf = new Bundle();
      paramf.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
      paramf.putString("realname_verify_process_jump_plugin", "wallet");
      isTransparent();
      if (this.mPayInfo != null) {
        i = this.mPayInfo.fOY;
      }
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf, null, i);
      AppMethodBeat.o(69474);
      return bool;
    }
    if ("2".equals(paramf.gat))
    {
      Log.i(this.TAG, "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf.gau, paramf.gax, paramf.gav, paramf.gaw, isTransparent(), null);
      AppMethodBeat.o(69474);
      return bool;
    }
    Log.i(this.TAG, "realnameGuideFlag =  " + paramf.gat);
    AppMethodBeat.o(69474);
    return false;
  }
  
  private Bankcard bgH(String paramString)
  {
    AppMethodBeat.i(69461);
    s.gGL();
    Object localObject = s.gGM().Ce(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (Util.nullAsNil(paramString).equals(localBankcard.field_bindSerial))
        {
          Log.i(this.TAG, "hy: get given bankcard");
          AppMethodBeat.o(69461);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(69461);
    return null;
  }
  
  private boolean gGP()
  {
    AppMethodBeat.i(69449);
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtF, Integer.valueOf(0))).intValue();
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      i = 1;
    }
    if ((i == 1) || ((this.Ivh != null) && (this.Ivh.ORA == 1)))
    {
      AppMethodBeat.o(69449);
      return true;
    }
    AppMethodBeat.o(69449);
    return false;
  }
  
  private boolean gHd()
  {
    AppMethodBeat.i(69430);
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("intent_pay_end")))
    {
      Log.i(this.TAG, "hy: pay end. finish the activity");
      if (localBundle.getBoolean("intent_pay_end", false))
      {
        Log.d(this.TAG, "pay done... errCode:" + localBundle.getInt("intent_pay_end_errcode"));
        Log.d(this.TAG, "pay done INTENT_PAY_APP_URL:" + localBundle.getString("intent_pay_app_url"));
        Log.d(this.TAG, "pay done INTENT_PAY_END:" + localBundle.getBoolean("intent_pay_end", false));
        m(-1, getIntent());
      }
      for (this.isPaySuccess = true;; this.isPaySuccess = false)
      {
        AppMethodBeat.o(69430);
        return true;
        Log.d(this.TAG, "pay cancel");
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
    Log.i(this.TAG, "hy: pay not end");
    AppMethodBeat.o(69430);
    return false;
  }
  
  private void gHf()
  {
    AppMethodBeat.i(69440);
    if (this.Ivh == null)
    {
      Log.e(this.TAG, "updatePaymentMethodForFavor mOrders is null");
      AppMethodBeat.o(69440);
      return;
    }
    this.Oza.setVisibility(8);
    this.OyZ.setVisibility(8);
    this.Iub.setText(a.i.wallet_pay);
    this.Ozi.setVisibility(0);
    this.Ozj.setVisibility(0);
    View localView = this.Ozj.findViewById(a.f.balance_layout);
    Object localObject = this.Ozj.findViewById(a.f.add_bankcard_layout);
    final CheckedTextView localCheckedTextView1;
    final CheckedTextView localCheckedTextView2;
    int i;
    if ("CFT".equals(this.Ivh.OQY))
    {
      ((View)localObject).setVisibility(8);
      localCheckedTextView1 = (CheckedTextView)this.Ozj.findViewById(a.f.balance_check);
      localCheckedTextView2 = (CheckedTextView)this.Ozj.findViewById(a.f.add_bank_check);
      localView.setEnabled(true);
      if ((this.Ivh == null) || (this.Ivh.ORd == null) || (this.Ivh.ORd.size() <= 0)) {
        break label772;
      }
      if (this.Ivh.OQN != 1) {
        break label574;
      }
      i = 1;
    }
    label772:
    for (;;)
    {
      label200:
      if (this.OmO == null)
      {
        localView.setVisibility(8);
        label213:
        ((View)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69425);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            localCheckedTextView1.setChecked(false);
            localCheckedTextView2.setChecked(true);
            WalletPayUI.a(WalletPayUI.this, true);
            WalletPayUI.e(WalletPayUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69425);
          }
        });
        this.Ozi.setVisibility(0);
        this.Ozj.setVisibility(0);
        if (this.OxY == null) {
          break label767;
        }
        this.OyM = com.tencent.mm.plugin.wallet_core.ui.f.OVk.a(this.Ivh);
        localObject = this.OyM.bhs(this.OxY.OPI);
        if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).Owl != 0.0D)) {
          break label767;
        }
        this.Ozj.setVisibility(8);
        this.Ozi.setVisibility(8);
      }
      label486:
      label767:
      for (int j = 1;; j = 0)
      {
        this.Ozk = true;
        if (j != 0) {
          this.Ozk = false;
        }
        localCheckedTextView1.setChecked(false);
        localCheckedTextView2.setChecked(true);
        Log.i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.Ivh.ORf);
        if (this.Ivh.ORf == 1)
        {
          this.Ozj.findViewById(a.f.discount_wording_layout).setVisibility(0);
          ((TextView)this.Ozj.findViewById(a.f.discount_wording)).setText(this.Ivh.ORg);
          if (!TextUtils.isEmpty(this.Ivh.ORh))
          {
            ((TextView)this.Ozj.findViewById(a.f.favor_rule_wording)).setText(" (" + this.Ivh.ORh + ")");
            if ((this.OmO != null) && (this.OmO.gIH()) && (!TextUtils.isEmpty(this.OmO.field_forbidWord)))
            {
              localView.setEnabled(false);
              localCheckedTextView1.setVisibility(8);
              ((TextView)this.Ozj.findViewById(a.f.balance_tips)).setText(this.OmO.field_forbidWord);
            }
          }
        }
        for (;;)
        {
          gHg();
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
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              localCheckedTextView1.setChecked(true);
              localCheckedTextView2.setChecked(false);
              WalletPayUI.a(WalletPayUI.this, false);
              WalletPayUI.e(WalletPayUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69424);
            }
          });
          break label213;
          ((TextView)this.Ozj.findViewById(a.f.favor_rule_wording)).setText("");
          break label486;
          this.Ozj.findViewById(a.f.discount_wording_layout).setVisibility(8);
          if ((this.OmO != null) && (this.OmO.gIH()) && (!TextUtils.isEmpty(this.OmO.field_forbidWord)))
          {
            localView.setEnabled(false);
            localCheckedTextView1.setVisibility(8);
            ((TextView)this.Ozj.findViewById(a.f.balance_tips)).setText(this.OmO.field_forbidWord);
          }
          else if ((this.OmO != null) && (this.OmO.gIH()) && (TextUtils.isEmpty(this.OmO.field_forbidWord)) && (i == 0))
          {
            localCheckedTextView1.setChecked(true);
            localCheckedTextView2.setChecked(false);
            this.Ozk = false;
          }
        }
      }
      label574:
      i = 0;
    }
  }
  
  private void gHg()
  {
    AppMethodBeat.i(69441);
    if (this.Ozk)
    {
      this.Iub.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int j = 0;
          AppMethodBeat.i(69387);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          s.gGL();
          int i;
          if (s.gGM().gJR())
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
            if (WalletPayUI.this.Ivh.ORf != 1) {
              break label227;
            }
            s.gGL();
            if (s.gGM().gJR())
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
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.fwv)
          {
            af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.f(WalletPayUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69387);
            return;
            i = WalletPayUI.this.mPayInfo.fOY;
            break;
            paramAnonymousView = WalletPayUI.this.mPayInfo.fwv;
            break label77;
            i = WalletPayUI.this.mPayInfo.fOY;
            break label125;
          }
          label227:
          Log.i(WalletPayUI.this.TAG, "SimpleReg , assigned userinfo pay! payWithNewBankcard");
          s.gGL();
          if (s.gGM().gJR())
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
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.fwv)
          {
            af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.this.d(false, 0, "");
            break;
            i = WalletPayUI.this.mPayInfo.fOY;
            break label264;
          }
        }
      });
      AppMethodBeat.o(69441);
      return;
    }
    this.Iub.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69388);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletPayUI.this.gHk();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69388);
      }
    });
    AppMethodBeat.o(69441);
  }
  
  private void gHl()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(69447);
    com.tencent.mm.plugin.report.service.h.IzE.a(13958, new Object[] { Integer.valueOf(1) });
    if ((this.mPayInfo != null) && (8 == this.mPayInfo.fOY))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(13955, new Object[] { Integer.valueOf(2) });
      if (this.mPayInfo.lfu != null)
      {
        long l = this.mPayInfo.lfu.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.IzE.a(13956, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    Object localObject;
    if (this.OxY != null)
    {
      this.OyM = com.tencent.mm.plugin.wallet_core.ui.f.OVk.a(this.Ivh);
      localObject = this.OyM.bhs(this.OxY.OPI);
      if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).Owl != 0.0D)) {}
    }
    for (;;)
    {
      if (i != 0)
      {
        s.gGL();
        if (s.gGM().gJR())
        {
          Log.i(this.TAG, "payWithoutPassword zeroPay");
          if (this.mPayInfo == null)
          {
            i = k;
            if (this.mPayInfo != null) {
              break label258;
            }
          }
          label258:
          for (localObject = "";; localObject = this.mPayInfo.fwv)
          {
            af.f(i, (String)localObject, 3, "");
            gHm();
            AppMethodBeat.o(69447);
            return;
            i = this.mPayInfo.fOY;
            break;
          }
        }
        Log.i(this.TAG, "has useful bankcard ! payWithOldBankcard zeroPay");
        gGY();
        AppMethodBeat.o(69447);
        return;
      }
      if (this.OyQ)
      {
        Log.i(this.TAG, "hy: start do pay with force use given bankcard");
        if (!Util.isNullOrNil(this.OyR))
        {
          this.OmO = gHo();
          gGY();
          AppMethodBeat.o(69447);
          return;
        }
        s.gGL();
        if (s.gGM().gJS()) {
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
          d(false, 0, "");
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.fOY;
          break;
          localObject = this.mPayInfo.fwv;
          break label370;
          s.gGL();
        } while (!s.gGM().gJR());
        if (this.mPayInfo == null)
        {
          i = 0;
          label440:
          if (this.mPayInfo != null) {
            break label474;
          }
        }
        label474:
        for (localObject = "";; localObject = this.mPayInfo.fwv)
        {
          af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.fOY;
          break label440;
        }
      }
      localObject = Util.nullAs(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!Util.isNullOrNil((String)localObject)) {
        this.OmO = bgH((String)localObject);
      }
      if (this.OmO == null)
      {
        if ((this.OmN != null) && (this.OmN.size() > 0))
        {
          Log.i(this.TAG, " no last pay bankcard ! jump to select bankcard!");
          e(false, 8, "");
          AppMethodBeat.o(69447);
          return;
        }
        Log.i(this.TAG, "default bankcard not found! payWithNewBankcard");
        s.gGL();
        if (s.gGM().gJS()) {
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
          d(false, 0, "");
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.fOY;
          break;
          localObject = this.mPayInfo.fwv;
          break label614;
          s.gGL();
        } while (!s.gGM().gJR());
        if (this.mPayInfo == null)
        {
          i = 0;
          label684:
          if (this.mPayInfo != null) {
            break label718;
          }
        }
        label718:
        for (localObject = "";; localObject = this.mPayInfo.fwv)
        {
          af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.fOY;
          break label684;
        }
      }
      i = this.OmO.a(this.Ivh.OIp, this.Ivh);
      if (this.Iol != null) {
        this.Iol.cH(10002, "");
      }
      if (i != 0)
      {
        Log.i(this.TAG, "main bankcard(" + i + ") is useless! jump to select bankcard!");
        e(false, i, "");
        AppMethodBeat.o(69447);
        return;
      }
      s.gGL();
      if (s.gGM().gJR())
      {
        Log.i(this.TAG, "payWithoutPassword");
        if (this.mPayInfo == null)
        {
          i = j;
          if (this.mPayInfo != null) {
            break label891;
          }
        }
        label891:
        for (localObject = "";; localObject = this.mPayInfo.fwv)
        {
          af.f(i, (String)localObject, 3, "");
          gHm();
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.fOY;
          break;
        }
      }
      Log.i(this.TAG, "has useful bankcard ! payWithOldBankcard");
      gGY();
      AppMethodBeat.o(69447);
      return;
      i = 0;
    }
  }
  
  private void gHm()
  {
    AppMethodBeat.i(69448);
    BS(true);
    com.tencent.mm.plugin.wallet_core.utils.j.gMO();
    AppMethodBeat.o(69448);
  }
  
  private Bankcard gHo()
  {
    AppMethodBeat.i(69460);
    s.gGL();
    Object localObject = s.gGM().Ce(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (Util.nullAsNil(this.OyR).equals(localBankcard.field_bindSerial))
        {
          Log.i(this.TAG, "hy: get given bankcard");
          AppMethodBeat.o(69460);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(69460);
    return null;
  }
  
  private boolean gHp()
  {
    AppMethodBeat.i(69465);
    if (isTransparent())
    {
      setContentViewVisibility(4);
      ar.r(this, 0);
      AppMethodBeat.o(69465);
      return false;
    }
    setContentViewVisibility(0);
    ar.r(this, getActionbarColor());
    AppMethodBeat.o(69465);
    return true;
  }
  
  private boolean gHq()
  {
    AppMethodBeat.i(69468);
    if ((this.Ivh != null) && (this.Ivh.OQU))
    {
      com.tencent.mm.kernel.h.aHH();
      if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(196614, Boolean.TRUE)).booleanValue())
      {
        Object localObject = getLayoutInflater().inflate(a.g.wallet_pay_oversea_tip, null);
        final CheckBox localCheckBox = (CheckBox)((View)localObject).findViewById(a.f.tips_cb);
        hj((View)localObject);
        ((TextView)((View)localObject).findViewById(a.f.tips_tv)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(271299);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = localCheckBox;
            if (!localCheckBox.isChecked()) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousView.setChecked(bool);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(271299);
              return;
            }
          }
        });
        localObject = com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_pay_oversea_title), (View)localObject, getString(a.i.wallet_card_wx_check_agree), getString(a.i.wallet_refuse_message), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(69413);
            if (localCheckBox.isChecked())
            {
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().aHp().i(196614, Boolean.FALSE);
            }
            WalletPayUI.this.BQ(false);
            AppMethodBeat.o(69413);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(276012);
            WalletPayUI.this.finish();
            AppMethodBeat.o(276012);
          }
        });
        ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
        localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(256893);
            paramAnonymousCompoundButton = this.OzD.ayb(-2);
            if (paramAnonymousBoolean)
            {
              paramAnonymousCompoundButton.setEnabled(false);
              AppMethodBeat.o(256893);
              return;
            }
            paramAnonymousCompoundButton.setEnabled(true);
            AppMethodBeat.o(256893);
          }
        });
        AppMethodBeat.o(69468);
        return false;
      }
    }
    AppMethodBeat.o(69468);
    return true;
  }
  
  private void hj(View paramView)
  {
    AppMethodBeat.i(69469);
    paramView = (TextView)paramView.findViewById(a.f.network_tips_content);
    paramView.setText(Html.fromHtml(String.format(getResources().getString(a.i.wallet_pay_oversea_content), new Object[] { getResources().getString(a.i.wallet_agreen_oversea) })));
    paramView.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69469);
  }
  
  private void m(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(69437);
    if ((this.mPayInfo != null) && (this.mPayInfo.fOY == 46) && (this.Ivh != null))
    {
      paramIntent.putExtra("key_total_fee", this.Ivh.fwy);
      Log.i(this.TAG, "sentCancelEvent set fee:%s", new Object[] { Double.valueOf(this.Ivh.fwy) });
    }
    abh localabh = new abh();
    localabh.gaZ.intent = paramIntent;
    abh.a locala;
    if (this.Ozv == 1)
    {
      localabh.gaZ.gba = 1000;
      localabh.gaZ.result = paramInt;
      locala = localabh.gaZ;
      if (this.mPayInfo != null) {
        break label217;
      }
    }
    label217:
    for (paramIntent = "";; paramIntent = this.mPayInfo.fwv)
    {
      locala.fwv = paramIntent;
      localabh.gaZ.gbc = 1;
      if ((this.mPayInfo != null) && (paramInt == 0)) {
        com.tencent.mm.plugin.wallet.pay.a.b.b.aG(this.mPayInfo.fwv, this.mPayInfo.fOY, this.mPayInfo.channel);
      }
      EventCenter.instance.publish(localabh);
      AppMethodBeat.o(69437);
      return;
      if (this.Ozv != 2) {
        break;
      }
      localabh.gaZ.gba = 1001;
      break;
    }
  }
  
  protected final void BQ(boolean paramBoolean)
  {
    AppMethodBeat.i(69446);
    if ((paramBoolean) && (!gHq()))
    {
      AppMethodBeat.o(69446);
      return;
    }
    if (this.OxY != null)
    {
      this.OyM = com.tencent.mm.plugin.wallet_core.ui.f.OVk.a(this.Ivh);
      com.tencent.mm.plugin.wallet.a.j localj = this.OyM.bhs(this.OxY.OPI);
      if ((localj == null) || (localj.Owl != 0.0D)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.Ozs != null)
      {
        if (this.Ozs.OxL == 0)
        {
          Log.i(this.TAG, "need real name,stop");
          b(this.Ozs);
          AppMethodBeat.o(69446);
          return;
        }
        if ((this.Ozs.OxL == 1) && (i != 0))
        {
          Log.i(this.TAG, "need real name, zero stop");
          b(this.Ozs);
        }
      }
      if (this.OxM != null)
      {
        if ((this.OxM.Oxu == 1) && (!Util.isNullOrNil(this.OxM.oDJ)) && (!Util.isNullOrNil(this.OxM.oDK)) && (!Util.isNullOrNil(this.OxM.Oxv)))
        {
          if ((this.mPayInfo != null) && (this.Ivh != null) && (this.Ivh.ORd != null) && (this.Ivh.ORd.size() > 0))
          {
            if (this.mPayInfo.fOY != 8) {
              break label371;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.Ivh.ORd.get(0)).fww });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.OxM.Oxv, "", this.OxM.oDK, this.OxM.oDJ, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69389);
                Log.i(WalletPayUI.this.TAG, "click continue pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.Ivh != null) && (WalletPayUI.this.Ivh.ORd != null) && (WalletPayUI.this.Ivh.ORd.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.fOY != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.h.IzE.a(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.Ivh.ORd.get(0)).fww });
                }
                for (;;)
                {
                  WalletPayUI.g(WalletPayUI.this);
                  AppMethodBeat.o(69389);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.h.IzE.a(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.Ivh.ORd.get(0)).fww });
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69390);
                Log.i(WalletPayUI.this.TAG, "click cancel pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.Ivh != null) && (WalletPayUI.this.Ivh.ORd != null) && (WalletPayUI.this.Ivh.ORd.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.fOY != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.h.IzE.a(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.Ivh.ORd.get(0)).fww });
                }
                for (;;)
                {
                  WalletPayUI.this.finish();
                  AppMethodBeat.o(69390);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.h.IzE.a(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.Ivh.ORd.get(0)).fww });
                }
              }
            });
            AppMethodBeat.o(69446);
            return;
            label371:
            com.tencent.mm.plugin.report.service.h.IzE.a(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.Ivh.ORd.get(0)).fww });
          }
        }
        if ((this.OxM.Oxu == 2) && (!Util.isNullOrNil(this.OxM.Oxv)) && (!Util.isNullOrNil(this.OxM.Oxw)))
        {
          Log.i(this.TAG, "pay has been blocked");
          if ((this.mPayInfo != null) && (this.Ivh != null) && (this.Ivh.ORd != null) && (this.Ivh.ORd.size() > 0))
          {
            if (this.mPayInfo.fOY != 8) {
              break label624;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.Ivh.ORd.get(0)).fww });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.OxM.Oxv, "", this.OxM.Oxw, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69391);
                WalletPayUI.this.finish();
                AppMethodBeat.o(69391);
              }
            });
            AppMethodBeat.o(69446);
            return;
            label624:
            com.tencent.mm.plugin.report.service.h.IzE.a(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.Ivh.ORd.get(0)).fww });
          }
        }
      }
      gHl();
      AppMethodBeat.o(69446);
      return;
    }
  }
  
  protected final void BR(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(69451);
    if (!bAu())
    {
      AppMethodBeat.o(69451);
      return;
    }
    this.Oyb = false;
    Log.i(this.TAG, "pay with old bankcard! from statck %s", new Object[] { Util.getStack().toString() });
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label230;
      }
    }
    label230:
    for (Object localObject = "";; localObject = this.mPayInfo.fwv)
    {
      af.f(i, (String)localObject, 8, "");
      if (this.Ozg != null)
      {
        Log.w(this.TAG, "close previous cashier dialog");
        this.Ozg.dismiss();
      }
      this.Oyb = false;
      if (!gGP()) {
        break label242;
      }
      this.Ozg = new WcPayCashierDialog(getContext());
      localObject = (WcPayCashierDialog)this.Ozg;
      PayInfo localPayInfo = this.mPayInfo;
      Orders localOrders = this.Ivh;
      FavorPayInfo localFavorPayInfo = this.OxY;
      Bankcard localBankcard = this.OmO;
      if (!this.OyQ) {
        bool = true;
      }
      ((WcPayCashierDialog)localObject).a(localPayInfo, localOrders, localFavorPayInfo, localBankcard, bool, paramBoolean);
      ((WcPayCashierDialog)localObject).Pep = new WcPayCashierDialog.a()
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, Bankcard paramAnonymousBankcard)
        {
          AppMethodBeat.i(69392);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            Log.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.h.IzE.p(965L, 3L, 1L);
            AppMethodBeat.o(69392);
            return;
          }
          WalletPayUI.i(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.OxY = paramAnonymousFavorPayInfo;
          WalletPayUI.this.OmO = paramAnonymousBankcard;
          paramAnonymousBankcard = WalletPayUI.this.TAG;
          int i;
          if (WalletPayUI.this.OxY == null)
          {
            paramAnonymousFavorPayInfo = "";
            Log.i(paramAnonymousBankcard, "WalletPwdDialog showAlert with favinfo %s", new Object[] { paramAnonymousFavorPayInfo });
            if (!Util.isNullOrNil(paramAnonymousString))
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.fwv)
          {
            af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.njf = paramAnonymousString;
            WalletPayUI.this.BS(false);
            com.tencent.mm.plugin.wallet_core.utils.j.gMO();
            AppMethodBeat.o(69392);
            return;
            paramAnonymousFavorPayInfo = WalletPayUI.this.OxY.toString();
            break;
            i = WalletPayUI.this.mPayInfo.fOY;
            break label131;
          }
        }
        
        public final void gFG()
        {
          AppMethodBeat.i(69394);
          Log.i(WalletPayUI.this.TAG, "click add new bankcard");
          Object localObject = com.tencent.mm.plugin.wallet_core.model.g.gIR();
          if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bVd())
          {
            com.tencent.mm.ui.base.h.c(WalletPayUI.this.getContext(), ((com.tencent.mm.plugin.wallet_core.model.g)localObject).GGD, WalletPayUI.this.getString(a.i.app_tip), true);
            AppMethodBeat.o(69394);
            return;
          }
          int i;
          if (WalletPayUI.this.mPayInfo == null)
          {
            i = 0;
            if (WalletPayUI.this.mPayInfo != null) {
              break label139;
            }
          }
          label139:
          for (localObject = "";; localObject = WalletPayUI.this.mPayInfo.fwv)
          {
            af.f(i, (String)localObject, 14, "");
            WalletPayUI.this.Ozg.dismiss();
            WalletPayUI.this.Ozg = null;
            WalletPayUI.this.gHn();
            AppMethodBeat.o(69394);
            return;
            i = WalletPayUI.this.mPayInfo.fOY;
            break;
          }
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(69393);
          Log.i(WalletPayUI.this.TAG, "cashier dialog canceled");
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
          for (String str = "";; str = WalletPayUI.this.mPayInfo.fwv)
          {
            af.f(i, str, 10, "");
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            AppMethodBeat.o(69393);
            return;
            i = WalletPayUI.this.mPayInfo.fOY;
            break;
          }
        }
      };
      ((WcPayCashierDialog)localObject).show();
      addDialog((Dialog)localObject);
      AppMethodBeat.o(69451);
      return;
      i = this.mPayInfo.fOY;
      break;
    }
    label242:
    if (!this.OyQ) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Ozg = t.a(this, paramBoolean, this.Ivh, this.OxY, this.OmO, this.mPayInfo, this.IoL, new t.c()new View.OnClickListener
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(69395);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            Log.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.h.IzE.p(965L, 3L, 1L);
            AppMethodBeat.o(69395);
            return;
          }
          WalletPayUI.k(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.OxY = paramAnonymousFavorPayInfo;
          String str = WalletPayUI.this.TAG;
          if (WalletPayUI.this.OxY == null) {}
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.OxY.toString())
          {
            Log.i(str, "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s", new Object[] { paramAnonymousFavorPayInfo, Boolean.valueOf(paramAnonymousBoolean) });
            if ((WalletPayUI.this.OxY == null) || (!paramAnonymousBoolean)) {
              break;
            }
            WalletPayUI.this.bz(-100, true);
            AppMethodBeat.o(69395);
            return;
          }
          int i;
          if (!Util.isNullOrNil(paramAnonymousString))
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.fwv)
          {
            af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.njf = paramAnonymousString;
            WalletPayUI.this.BS(false);
            com.tencent.mm.plugin.wallet_core.utils.j.gMO();
            WalletPayUI.this.Oya = null;
            AppMethodBeat.o(69395);
            return;
            i = WalletPayUI.this.mPayInfo.fOY;
            break;
          }
        }
      }, new View.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69396);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i(WalletPayUI.this.TAG, "WalletPwdDialog event1 %s", new Object[] { Util.getStack().toString() });
          WalletPayUI.this.OxY = ((FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUI.this.OxY != null) {
            WalletPayUI.this.OxY.OPM = "";
          }
          WalletPayUI.this.e(false, 0, "");
          WalletPayUI.this.Ozg.dismiss();
          WalletPayUI.this.njf = null;
          WalletPayUI.this.Ozg = null;
          WalletPayUI.this.Oya = null;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69396);
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          int i = 0;
          AppMethodBeat.i(69397);
          Log.i(WalletPayUI.this.TAG, "WalletPwdDialog event2 %s", new Object[] { Util.getStack().toString() });
          WalletPayUI.l(WalletPayUI.this);
          WalletPayUI.j(WalletPayUI.this);
          if (WalletPayUI.this.mPayInfo == null) {
            if (WalletPayUI.this.mPayInfo != null) {
              break label151;
            }
          }
          label151:
          for (String str = "";; str = WalletPayUI.this.mPayInfo.fwv)
          {
            af.f(i, str, 10, "");
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            WalletPayUI.this.njf = null;
            WalletPayUI.this.Ozg = null;
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            WalletPayUI.this.Oya = null;
            AppMethodBeat.o(69397);
            return;
            i = WalletPayUI.this.mPayInfo.fOY;
            break;
          }
        }
      });
      this.Oya = ((com.tencent.mm.plugin.wallet_core.ui.g)this.Ozg);
      AppMethodBeat.o(69451);
      return;
    }
  }
  
  protected void BS(boolean paramBoolean)
  {
    AppMethodBeat.i(69467);
    com.tencent.mm.plugin.wallet.pay.a.a.b localb = com.tencent.mm.plugin.wallet.pay.a.a.a(gHi(), this.Ivh, paramBoolean);
    if (this.Ivh != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_reqKey", this.Ivh.fwv);
      if ((this.Ivh.ORd != null) && (this.Ivh.ORd.size() > 0)) {
        localBundle.putString("key_TransId", ((Orders.Commodity)this.Ivh.ORd.get(0)).fww);
      }
      localBundle.putLong("key_SessionId", this.Ozh);
      localb.setProcessName("PayProcess");
      localb.setProcessBundle(localBundle);
    }
    if (this.mPayInfo != null)
    {
      if ((this.mPayInfo.fOY != 6) || (this.mPayInfo.Rzf != 100)) {
        break label255;
      }
      localb.setScene(100);
    }
    for (;;)
    {
      doSceneProgress(localb);
      if ((this.mPayInfo != null) && (8 == this.mPayInfo.fOY) && (this.mPayInfo.lfu != null))
      {
        long l = this.mPayInfo.lfu.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.IzE.a(13956, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - l) });
      }
      AppMethodBeat.o(69467);
      return;
      label255:
      localb.setScene(this.mPayInfo.fOY);
    }
  }
  
  protected void aE(Bundle paramBundle)
  {
    AppMethodBeat.i(69471);
    this.OyO = true;
    if (this.Ivh != null)
    {
      paramBundle.putInt("key_support_bankcard", this.Ivh.OIp);
      paramBundle.putString("key_reqKey", this.Ivh.fwv);
      if ((this.Ivh.ORd != null) && (this.Ivh.ORd.size() > 0)) {
        paramBundle.putString("key_TransId", ((Orders.Commodity)this.Ivh.ORd.get(0)).fww);
      }
      paramBundle.putLong("key_SessionId", this.Ozh);
    }
    if (this.mPayInfo != null) {
      paramBundle.putInt("key_scene", this.mPayInfo.fOY);
    }
    if (!gHj()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      paramBundle.putInt("is_deduct_open", this.Ozp);
      this.OyP = new d.a()
      {
        public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(274478);
          Log.i(WalletPayUI.this.TAG, "pay process end");
          WalletPayUI.this.OyO = false;
          paramAnonymousBundle = new Intent();
          AppMethodBeat.o(274478);
          return paramAnonymousBundle;
        }
      };
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, paramBundle, this.OyP);
      AppMethodBeat.o(69471);
      return;
    }
  }
  
  protected final boolean bAu()
  {
    AppMethodBeat.i(69459);
    String str2;
    String str1;
    if ((this.Ivh == null) || (this.Ivh.ORd == null) || (this.Ivh.ORd.size() <= 0))
    {
      Log.w(this.TAG, "mOrders info is Illegal!");
      if ((this.OyL != null) && (this.OyL.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      str2 = getString(a.i.wallet_order_info_err);
      str1 = str2;
      if (this.OyL != null)
      {
        str1 = str2;
        if (!Util.isNullOrNil(this.OyL.errMsg)) {
          str1 = this.OyL.errMsg;
        }
      }
      Log.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.d(getContext(), str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69409);
          WalletPayUI.this.finish();
          AppMethodBeat.o(69409);
        }
      });
      AppMethodBeat.o(69459);
      return false;
    }
    if ((this.OyQ) && (!Util.isNullOrNil(this.OyR)) && (gHo() == null))
    {
      if ((this.OyL != null) && (this.OyL.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      Log.w(this.TAG, "hy: should use given bankcard, but resolved as null. show error msg and quit");
      str2 = getString(a.i.wallet_order_info_err);
      str1 = str2;
      if (this.OyL != null)
      {
        str1 = str2;
        if (!Util.isNullOrNil(this.OyL.errMsg)) {
          str1 = this.OyL.errMsg;
        }
      }
      Log.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.d(getContext(), str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(200482);
          WalletPayUI.this.finish();
          AppMethodBeat.o(200482);
        }
      });
      AppMethodBeat.o(69459);
      return false;
    }
    AppMethodBeat.o(69459);
    return true;
  }
  
  protected final void bz(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(69455);
    com.tencent.mm.plugin.report.service.h.IzE.a(13958, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.h.IzE.a(13955, new Object[] { Integer.valueOf(4) });
    if (this.mPayInfo == null) {
      if (this.mPayInfo != null) {
        break label226;
      }
    }
    label226:
    for (Object localObject = "";; localObject = this.mPayInfo.fwv)
    {
      af.f(i, (String)localObject, 11, "");
      localObject = getInput();
      ((Bundle)localObject).putInt("key_main_bankcard_state", paramInt);
      ((Bundle)localObject).putParcelable("key_orders", this.Ivh);
      ((Bundle)localObject).putParcelable("key_pay_info", this.mPayInfo);
      ((Bundle)localObject).putParcelable("key_authen", gHi());
      ((Bundle)localObject).putString("key_pwd1", this.njf);
      ((Bundle)localObject).putInt("key_pay_flag", 3);
      ((Bundle)localObject).putInt("key_err_code", -1004);
      ((Bundle)localObject).putParcelable("key_favor_pay_info", this.OxY);
      ((Bundle)localObject).putBoolean("key_is_filter_bank_type", paramBoolean);
      if (this.OmO != null) {
        ((Bundle)localObject).putString("key_is_cur_bankcard_bind_serial", this.OmO.field_bindSerial);
      }
      aE((Bundle)localObject);
      AppMethodBeat.o(69455);
      return;
      i = this.mPayInfo.fOY;
      break;
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
      gGY();
    }
    AppMethodBeat.o(69466);
  }
  
  protected final void d(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69452);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
    s.gGL();
    Log.d(str, s.gGM().gJQ() + ", need confirm ? " + paramBoolean);
    if (paramBoolean)
    {
      if (!Util.isNullOrNil(paramString)) {
        break label130;
      }
      paramString = Bankcard.aM(this, paramInt);
    }
    label130:
    for (;;)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, "", getString(a.i.wallet_pay_bankcard_add), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69398);
          WalletPayUI.this.gHn();
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
      gHn();
      AppMethodBeat.o(69452);
      return;
    }
  }
  
  public final void e(boolean paramBoolean, final int paramInt, String paramString)
  {
    AppMethodBeat.i(69453);
    Log.d(this.TAG, "pay with select bankcard! need confirm ? ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (!Util.isNullOrNil(paramString)) {
        break label118;
      }
      paramString = Bankcard.aM(this, paramInt);
    }
    label118:
    for (;;)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, "", getString(a.i.wallet_pay_bankcard_select), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69401);
          if (WalletPayUI.m(WalletPayUI.this))
          {
            WalletPayUI.this.BR(true);
            AppMethodBeat.o(69401);
            return;
          }
          WalletPayUI.this.bz(paramInt, false);
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
      if (gGP())
      {
        BR(true);
        AppMethodBeat.o(69453);
        return;
      }
      bz(paramInt, false);
      AppMethodBeat.o(69453);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(69434);
    Log.i(this.TAG, "finish %s %s mPayResultType:%s", new Object[] { Integer.valueOf(hashCode()), Util.getStack().toString(), Integer.valueOf(this.mPayResultType) });
    cancelQRPay();
    if ((this.Ivh != null) && (!this.Ivh.ORd.isEmpty())) {
      getIntent().putExtra("key_trans_id", ((Orders.Commodity)this.Ivh.ORd.get(0)).fww);
    }
    if (this.mPayInfo != null) {
      getIntent().putExtra("key_reqKey", this.mPayInfo.fwv);
    }
    com.tencent.mm.wallet_core.d locald;
    if (this.isPaySuccess)
    {
      if (this.Ivh != null) {
        getIntent().putExtra("key_total_fee", this.Ivh.fwy);
      }
      getIntent().putExtra("key_pay_reslut_type", 1);
      m(-1, getIntent());
      setResult(-1, getIntent());
      locald = getProcess();
      if (locald != null) {
        if (locald.YTy == null) {
          break label717;
        }
      }
    }
    label408:
    label439:
    label570:
    label581:
    label717:
    for (Object localObject = (Context)locald.YTy.get();; localObject = null)
    {
      if (this == localObject)
      {
        Log.i(this.TAG, "remove process end callback to prevent ui leak");
        locald.iij();
      }
      super.finish();
      AppMethodBeat.o(69434);
      return;
      if ((this.mPayInfo != null) && (this.mPayInfo.fOY == 8) && (this.Ivh != null))
      {
        this.mPayInfo.Rzn = 0;
        doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.a(gHi(), this.Ivh, true), false);
        if (this.mPayInfo.lfu != null)
        {
          long l = this.mPayInfo.lfu.getLong("extinfo_key_9");
          com.tencent.mm.plugin.report.service.h.IzE.a(13956, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      m(0, getIntent());
      getIntent().putExtra("key_pay_reslut_type", this.mPayResultType);
      int i;
      if (this.Ozv == 1)
      {
        getIntent().putExtra("key_pay_reslut_type", 1000);
        setResult(0, getIntent());
        s.gGL();
        if (!s.gGM().gJS()) {
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
      for (localObject = "";; localObject = this.mPayInfo.fwv)
      {
        af.f(i, (String)localObject, 18, "");
        localObject = com.tencent.mm.wallet_core.a.bCh("PayProcess").iterator();
        while (((Iterator)localObject).hasNext())
        {
          locald = (com.tencent.mm.wallet_core.d)((Iterator)localObject).next();
          locald.L(new Object[] { "specEndProcessWithoutFinish" });
          if (locald.fKb != null) {
            locald.fKb.clear();
          }
          com.tencent.mm.wallet_core.a.remove(locald.getClass().hashCode());
          locald.gGO();
        }
        break;
        if (this.Ozv != 2) {
          break label408;
        }
        getIntent().putExtra("key_pay_reslut_type", 1001);
        break label408;
        i = this.mPayInfo.fOY;
        break label439;
      }
      label593:
      s.gGL();
      if (s.gGM().gJR())
      {
        if (this.mPayInfo == null)
        {
          i = 0;
          label615:
          if (this.mPayInfo != null) {
            break label649;
          }
        }
        for (localObject = "";; localObject = this.mPayInfo.fwv)
        {
          af.f(i, (String)localObject, 4, "");
          break;
          i = this.mPayInfo.fOY;
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
      for (localObject = "";; localObject = this.mPayInfo.fwv)
      {
        af.f(i, (String)localObject, 7, "");
        break;
        i = this.mPayInfo.fOY;
        break label670;
      }
    }
  }
  
  protected final boolean gGW()
  {
    return (this.mPayInfo != null) && (this.mPayInfo.fOY != 11);
  }
  
  protected void gGY()
  {
    AppMethodBeat.i(69450);
    BR(false);
    AppMethodBeat.o(69450);
  }
  
  protected void gHe()
  {
    int i = 2;
    AppMethodBeat.i(69432);
    com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(2), Integer.valueOf(this.mPayInfo.fOY) });
    if (this.mPayInfo.fOY == 11) {
      i = 3;
    }
    Object localObject = this.mPayInfo;
    if ((localObject == null) || (Util.isNullOrNil(((PayInfo)localObject).fwv)))
    {
      Log.i("MicroMsg.CgiManager", "no payInfo or reqKey");
      localObject = null;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessName("PayProcess");
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessSessionId(this.Ozh);
        if ((this.mPayInfo.fOY != 6) || (this.mPayInfo.Rzf != 100)) {
          break label446;
        }
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(100);
        label134:
        if (!this.mPayInfo.Rzg) {
          break label460;
        }
      }
    }
    label446:
    label460:
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress((q)localObject, true, bool);
      AppMethodBeat.o(69432);
      return;
      String str = ((PayInfo)localObject).fwv;
      Log.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", new Object[] { str });
      Log.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
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
        localObject = new c((PayInfo)localObject, i);
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
      ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(this.mPayInfo.fOY);
      break label134;
    }
  }
  
  public final void gHh()
  {
    AppMethodBeat.i(69442);
    com.tencent.mm.plugin.wallet.a.j localj = this.OyM.bhs(this.OxY.OPI);
    List localList = this.OyM.gLg();
    com.tencent.mm.plugin.wallet.a.h localh = this.OyM.OVf;
    Object localObject1 = "";
    double d2;
    Object localObject2;
    int i;
    double d1;
    if (localj != null)
    {
      d2 = localj.Owt;
      if (d2 > 0.0D)
      {
        localObject2 = localj.Owv;
        int j = 1;
        localObject1 = localObject2;
        i = j;
        d1 = d2;
        if (!Util.isNullOrNil(localj.Oww))
        {
          localObject1 = (String)localObject2 + "," + localj.Oww;
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
          localObject2 = (String)localObject1 + getContext().getString(a.i.wallet_pwd_dialog_more_favors);
        }
      }
      if ((d1 > 0.0D) && (localh != null) && (localh.Owp == 0))
      {
        if (localj != null) {
          this.OyV.setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(localj.Ows));
        }
        this.OyY.setText(com.tencent.mm.wallet_core.ui.g.bCn(this.Ivh.GHz));
        this.OyX.setText(com.tencent.mm.wallet_core.ui.g.d(this.Ivh.fwy, this.Ivh.GHz));
        this.OyX.setVisibility(0);
      }
      for (;;)
      {
        if (!Util.isNullOrNil((String)localObject2)) {
          this.Ozd.setText((CharSequence)localObject2);
        }
        AppMethodBeat.o(69442);
        return;
        this.OyV.setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(this.Ivh.fwy));
        this.OyY.setText(com.tencent.mm.wallet_core.ui.g.bCn(this.Ivh.GHz));
        this.OyX.setVisibility(8);
      }
      i = 0;
      d1 = d2;
      continue;
      i = 0;
      d1 = 0.0D;
    }
  }
  
  protected final Authen gHi()
  {
    AppMethodBeat.i(69443);
    Authen localAuthen = new Authen();
    if (gHj()) {}
    for (localAuthen.cUP = 3;; localAuthen.cUP = 6)
    {
      if (!Util.isNullOrNil(this.njf)) {
        localAuthen.OMP = this.njf;
      }
      if (this.OmO != null)
      {
        localAuthen.GGC = this.OmO.field_bindSerial;
        localAuthen.fvP = this.OmO.field_bankcardType;
      }
      if ((this.OxY != null) && (this.OyM != null) && (this.OyM.gLd()))
      {
        localAuthen.OMZ = this.OxY.OPI;
        localAuthen.OMY = this.OxY.OPL;
      }
      localAuthen.HzF = this.mPayInfo;
      AppMethodBeat.o(69443);
      return localAuthen;
    }
  }
  
  protected final boolean gHj()
  {
    AppMethodBeat.i(69444);
    if ((this.OmO != null) && (this.Ivh != null) && (this.Ivh.OIp == 3))
    {
      if (this.OmO.gIK())
      {
        AppMethodBeat.o(69444);
        return true;
      }
      AppMethodBeat.o(69444);
      return false;
    }
    if ((this.Ivh != null) && (!Bankcard.amv(this.Ivh.OIp)))
    {
      AppMethodBeat.o(69444);
      return true;
    }
    AppMethodBeat.o(69444);
    return false;
  }
  
  protected final void gHk()
  {
    AppMethodBeat.i(69445);
    BQ(true);
    AppMethodBeat.o(69445);
  }
  
  protected final void gHn()
  {
    AppMethodBeat.i(69454);
    Bundle localBundle = getIntent().getExtras();
    s.gGL();
    if (s.gGM().gJQ()) {}
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("key_pay_flag", i);
      localBundle.putParcelable("key_orders", this.Ivh);
      localBundle.putParcelable("key_pay_info", this.mPayInfo);
      localBundle.putParcelable("key_favor_pay_info", this.OxY);
      aE(localBundle);
      AppMethodBeat.o(69454);
      return;
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
    return a.g.wallet_pay_ui;
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
  
  public final void h(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69472);
    Log.i(this.TAG, "onGenFinish callback");
    if (paramBoolean)
    {
      Log.i(this.TAG, "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.fHc = paramString1;
      this.mPayInfo.fHd = paramString2;
      BS(false);
      com.tencent.mm.plugin.wallet_core.utils.j.gMO();
      AppMethodBeat.o(69472);
      return;
    }
    Log.e(this.TAG, "onGenFinish callback, result.isSuccess is false");
    BS(false);
    com.tencent.mm.plugin.wallet_core.utils.j.gMO();
    AppMethodBeat.o(69472);
  }
  
  public void initView()
  {
    AppMethodBeat.i(69438);
    ar.e(getWindow());
    MMScrollView localMMScrollView = (MMScrollView)findViewById(a.f.wallet_sv);
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.Iub = ((Button)findViewById(a.f.wallet_pay_pay));
    this.Iub.setClickable(false);
    this.Iub.setEnabled(false);
    this.OyV = ((TextView)findViewById(a.f.wallet_order_info_total_fee));
    this.OyW = ((TextView)findViewById(a.f.wallet_order_info_total_desc));
    this.OyY = ((TextView)findViewById(a.f.wallet_order_info_fee_type));
    this.Ozd = ((TextView)findViewById(a.f.wallet_order_info_favor));
    this.OyX = ((TextView)findViewById(a.f.wallet_order_info_origin_fee));
    this.Ozc = ((TextView)findViewById(a.f.wallet_pay_anti_trick_tips));
    this.OyX.getPaint().setFlags(16);
    this.OyZ = ((TextView)findViewById(a.f.wallet_pay_tips));
    this.Oza = ((TextView)findViewById(a.f.wallet_pay_bind_bankcard));
    this.Oza.setOnClickListener(new aa()
    {
      public final void cOw()
      {
        AppMethodBeat.i(69416);
        WalletPayUI.this.d(false, 0, "");
        AppMethodBeat.o(69416);
      }
    });
    this.Ozb = ((ImageView)findViewById(a.f.wallet_order_info_desc_more_btn));
    this.Ozb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69417);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (WalletPayUI.this.OyS) {
          WalletPayUI.this.Ozb.setImageResource(a.e.pay_dital_bill_guid_down);
        }
        for (WalletPayUI.this.OyS = false;; WalletPayUI.this.OyS = true)
        {
          WalletPayUI.this.Ozf.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69417);
          return;
          WalletPayUI.this.Ozb.setImageResource(a.e.pay_dital_bill_guid_up);
        }
      }
    });
    this.Oze = ((LinearLayout)findViewById(a.f.wallet_order_info_lv));
    this.Ozf = new a();
    this.Iub.setOnClickListener(new aa()
    {
      public final void cOw()
      {
        AppMethodBeat.i(69418);
        s.gGL();
        int i;
        if (!s.gGM().gJR())
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
        for (String str = "";; str = WalletPayUI.this.mPayInfo.fwv)
        {
          af.f(i, str, 6, "");
          WalletPayUI.this.gHk();
          WalletPayUI.this.OyU = true;
          AppMethodBeat.o(69418);
          return;
          i = WalletPayUI.this.mPayInfo.fOY;
          break;
        }
      }
    });
    this.Iub.setText(a.i.wallet_pay);
    this.Ozi = ((TextView)findViewById(a.f.payment_method_tips));
    this.Ozj = ((LinearLayout)findViewById(a.f.payment_method_layout));
    updateView();
    AppMethodBeat.o(69438);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69464);
    if (this.Ozq)
    {
      String str1 = this.TAG;
      boolean bool1;
      label87:
      String str2;
      int i;
      if ((getPayInfo() == null) || (!getPayInfo().cpf))
      {
        bool1 = true;
        Log.i(str1, "case 1 %s,  stack %s", new Object[] { Boolean.valueOf(bool1), Util.getStack().toString() });
        str1 = this.TAG;
        s.gGL();
        if (s.gGM().gJQ()) {
          break label196;
        }
        bool1 = true;
        Log.d(str1, "case 2 %s,", new Object[] { Boolean.valueOf(bool1) });
        str2 = this.TAG;
        if (this.OmN != null) {
          break label201;
        }
        i = 0;
        label121:
        if (this.OmO != null) {
          break label212;
        }
      }
      label196:
      label201:
      label212:
      for (str1 = "";; str1 = this.OmO.field_forbidWord)
      {
        Log.d(str2, "case 3 mBankcardList %s, mDefaultBankcard %s", new Object[] { Integer.valueOf(i), str1 });
        if ((getPayInfo() != null) && (getPayInfo().cpf)) {
          break label224;
        }
        Log.i(this.TAG, "get isTransparent1");
        AppMethodBeat.o(69464);
        return false;
        bool1 = false;
        break;
        bool1 = false;
        break label87;
        i = this.OmN.size();
        break label121;
      }
      label224:
      s.gGL();
      if (!s.gGM().gJQ())
      {
        Log.i(this.TAG, "get isTransparent2");
        AppMethodBeat.o(69464);
        return false;
      }
      if ((this.OmN != null) && ((this.OmN.size() == 0) || ((this.OmO != null) && (!Util.isNullOrNil(this.OmO.field_forbidWord)))))
      {
        str1 = this.TAG;
        if ((this.OmN != null) && (this.OmN.size() == 0))
        {
          bool1 = true;
          if ((this.OmO == null) || (Util.isNullOrNil(this.OmO.field_forbidWord))) {
            break label378;
          }
        }
        label378:
        for (boolean bool2 = true;; bool2 = false)
        {
          Log.i(str1, "get isTransparent3 1 %s 2 %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(69464);
          return false;
          bool1 = false;
          break;
        }
      }
      Log.i(this.TAG, "get isTransparent4");
      AppMethodBeat.o(69464);
      return true;
    }
    Log.i(this.TAG, "get isTransparent5");
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
    Log.i(this.TAG, "onAcvityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
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
          this.Ozp = paramIntent.getIntExtra("auto_deduct_flag", -1);
          if ((this.Ivh != null) && (this.Ivh.ORi != null)) {
            this.Ivh.ORi.Ozp = this.Ozp;
          }
          getPayInfo().Rzk = this.Ozp;
          if (this.Ozp == 1)
          {
            getPayInfo().Rzl = paramIntent.getStringExtra("deduct_bank_type");
            getPayInfo().Rzm = paramIntent.getStringExtra("deduct_bind_serial");
          }
        }
        this.Ozo = true;
        onProgressFinish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(13958, new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(69462);
        return;
        finish();
      }
      this.Ozg.dismiss();
      this.OyU = false;
      gHe();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69429);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.TAG = ("MicroMsg.WalletPayUI@" + hashCode());
    if (OyJ)
    {
      Log.w(this.TAG, "has Undestory WalletPayUI!");
      com.tencent.mm.plugin.report.service.h.IzE.p(965L, 1L, 1L);
      aml(2);
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    OyJ = true;
    long l = System.currentTimeMillis();
    int j = getIntent().getIntExtra("key_context_hashcode", -1);
    paramBundle = new b[OyK.size()];
    Log.i(this.TAG, "WalletPayUI check %s this %s fromHashCode %s", new Object[] { Integer.valueOf(OyK.size()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
    paramBundle = (b[])OyK.toArray(paramBundle);
    int k = paramBundle.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = paramBundle[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localObject.pZE.get();
      if (localWalletPayUI != null)
      {
        Log.w(this.TAG, "has old payui, both finish %s", new Object[] { Integer.valueOf(localWalletPayUI.hashCode()) });
        if ((j != localObject.aNf) || (j == -1)) {
          break label290;
        }
        localWalletPayUI.aml(2);
        com.tencent.mm.plugin.report.service.h.IzE.p(965L, 41L, 1L);
      }
      for (;;)
      {
        OyK.remove(localObject);
        localWalletPayUI.finish();
        i += 1;
        break;
        label290:
        localWalletPayUI.aml(1);
        com.tencent.mm.plugin.report.service.h.IzE.p(965L, 40L, 1L);
      }
    }
    this.Ozx = new b((byte)0);
    this.Ozx.timestamp = l;
    this.Ozx.aNf = j;
    this.Ozx.pZE = new WeakReference(this);
    OyK.add(this.Ozx);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.e(this.TAG, "hy: account not ready. finish now");
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    getWindow().getDecorView().postDelayed(this.Ozw, 5000L);
    this.Ozy = Util.nowMilliSecond();
    EventCenter.instance.addListener(this.IrT);
    com.tencent.mm.plugin.wallet_core.model.k.amw(5);
    this.Iol = com.tencent.mm.plugin.wallet.a.be(getIntent());
    setMMTitle(a.i.wallet_pay_ui_title);
    this.mPayInfo = getPayInfo();
    this.OyQ = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
    this.OyR = Util.nullAs(getIntent().getStringExtra("key_force_use_bind_serail"), "");
    this.IoL = getIntent().getStringExtra("key_receiver_true_name");
    if ((this.mPayInfo == null) || (this.mPayInfo.Rzj == 0L))
    {
      this.Ozh = System.currentTimeMillis();
      s.gGL();
      if (!s.gGM().gJQ())
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
      if (gHd()) {
        break label763;
      }
      Log.d(this.TAG, "PayInfo = " + this.mPayInfo);
      if ((this.mPayInfo == null) || (Util.isNullOrNil(this.mPayInfo.fwv))) {
        break label705;
      }
      gHe();
      com.tencent.mm.plugin.secinforeport.a.d.Jcm.asyncReportPaySecurityInfoThroughCgi();
      initView();
    }
    for (;;)
    {
      if (this.mPayInfo != null) {
        com.tencent.mm.plugin.wallet.pay.a.b.bgA(this.mPayInfo.Rzp);
      }
      AppMethodBeat.o(69429);
      return;
      this.Ozh = this.mPayInfo.Rzj;
      break;
      label683:
      i = this.mPayInfo.fOY;
      break label559;
      label694:
      paramBundle = this.mPayInfo.fwv;
      break label569;
      label705:
      if ((this.mPayInfo != null) && (!Util.isNullOrNil(this.mPayInfo.errMsg))) {}
      for (paramBundle = this.mPayInfo.errMsg;; paramBundle = getString(a.i.wallet_pay_orders_illegal))
      {
        com.tencent.mm.ui.base.h.a(this, paramBundle, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(69412);
            WalletPayUI.this.finish();
            AppMethodBeat.o(69412);
          }
        });
        break;
      }
      label763:
      Log.i(this.TAG, "hy: pay end on create. finish");
      finish();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69431);
    if (this.OxZ != null)
    {
      this.OxZ.closeTipDialog();
      this.OxZ.release();
    }
    EventCenter.instance.removeListener(this.IrT);
    this.Oya = null;
    getWindow().getDecorView().removeCallbacks(this.Ozw);
    OyK.remove(this.Ozx);
    OyJ = false;
    long l = System.currentTimeMillis();
    b[] arrayOfb = new b[OyK.size()];
    arrayOfb = (b[])OyK.toArray(arrayOfb);
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localb.pZE.get();
      if ((localWalletPayUI != null) && (l - localb.timestamp > 600000L))
      {
        Log.w(this.TAG, "has old payui, both finish");
        com.tencent.mm.plugin.report.service.h.IzE.p(965L, 2L, 1L);
        OyK.remove(localb);
        localWalletPayUI.aml(1);
        localWalletPayUI.finish();
      }
      i += 1;
    }
    if (this.mPayInfo != null) {
      com.tencent.mm.plugin.wallet.pay.a.b.bgB(this.mPayInfo.Rzp);
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
        Log.w(this.TAG, "block when authening");
        AppMethodBeat.o(69435);
        return true;
      }
      if ((this.Ozg != null) && (this.mPayInfo != null) && (this.mPayInfo.cpf) && (!this.mNetSceneMgr.isProcessing())) {
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
    Log.i(this.TAG, "onNewIntent");
    setIntent(paramIntent);
    if (!gHd())
    {
      Log.w(this.TAG, "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
      if (paramIntent.getBooleanExtra("send_cancel_event", true)) {
        m(0, getIntent());
      }
      this.isPaySuccess = false;
    }
    if (paramIntent.getBooleanExtra("direc_change_bankcard", false))
    {
      BR(true);
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false))) {
      this.Ozl = true;
    }
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(this.TAG, "isFromBindCard is true");
      gHe();
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_is_realname_verify_process", false)))
    {
      this.Ozm = true;
      i = j;
      if (i == 0) {
        break label196;
      }
      Log.i(this.TAG, "isFromRealNameVerify is true");
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
      Log.e(this.TAG, "isFromBindCard is false,isFromRealNameVerify is false");
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69473);
    super.onPause();
    if (this.Oya != null) {
      this.Oya.onActivityPause();
    }
    AppMethodBeat.o(69473);
  }
  
  public boolean onProgressFinish()
  {
    boolean bool2 = false;
    AppMethodBeat.i(69463);
    Log.i(this.TAG, "onProgressFinish isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.Ozt) });
    EventCenter.instance.publish(new aaw());
    int i;
    int j;
    label93:
    Object localObject;
    label104:
    boolean bool1;
    if ((this.Ivh != null) && (this.Ivh.ORi != null) && (!this.Ozo))
    {
      i = 1;
      if ((i == 0) && (!gHp()))
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
      if (!this.Ozt) {
        break label163;
      }
      BQ(true);
      bool1 = true;
    }
    for (;;)
    {
      AppMethodBeat.o(69463);
      return bool1;
      i = 0;
      break;
      label140:
      j = this.mPayInfo.fOY;
      break label93;
      label151:
      localObject = this.mPayInfo.fwv;
      break label104;
      label163:
      if (this.Ozn)
      {
        bool1 = true;
      }
      else if (i != 0)
      {
        localObject = new Intent(this, WalletPayDeductUI.class);
        ((Intent)localObject).putExtra("orders", this.Ivh);
        startActivityForResult((Intent)localObject, 0);
        bool1 = true;
      }
      else if (getContentView().getVisibility() != 0)
      {
        if ((!this.OyU) && (bAu()))
        {
          BQ(true);
          this.OyU = true;
        }
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (getContentView().getVisibility() == 0)
        {
          bool1 = bool2;
          if (this.Ivh != null)
          {
            bool1 = bool2;
            if (this.Ivh.ORi != null)
            {
              bool1 = bool2;
              if (this.Iub.isEnabled())
              {
                bool1 = bool2;
                if (!this.Ozr)
                {
                  this.Iub.performClick();
                  this.Ozr = true;
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
    Log.i(this.TAG, "hy: onResume isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.Ozt) });
    if (!isProcessing())
    {
      if (!Util.isNullOrNil(this.OyR)) {
        this.OmO = gHo();
      }
    }
    else
    {
      if (!this.Ozu) {
        break label149;
      }
      Log.i(this.TAG, "onResume isResumePassFinish");
      this.Ozu = false;
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(69433);
      return;
      if (this.OmO == null)
      {
        s.gGL();
        this.OmO = s.gGM().a(null, null, gGW(), false);
        break;
      }
      s.gGL();
      this.OmO = s.gGM().a(null, this.OmO.field_bindSerial, gGW(), false);
      break;
      label149:
      if ((this.OyO) && (getContentViewVisibility() != 0) && ((this.Ozg == null) || (!this.Ozg.isShowing())))
      {
        Log.i(this.TAG, "hy: has started process and is transparent and no pwd appeared. finish self");
        finish();
      }
      else if (this.Oya != null)
      {
        this.Oya.onActivityResume();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(69457);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq, paramBoolean);
    if ((paramq instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
      setAuthState(false);
    }
    AppMethodBeat.o(69457);
  }
  
  public boolean onSceneEnd(int paramInt1, final int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(69458);
    Log.i(this.TAG, "errorType %s errCode %s, errmsg %s, scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    boolean bool;
    Object localObject1;
    label308:
    label343:
    label503:
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pay.a.c.f))
      {
        this.mPayResultType = 1;
        this.OyL = ((com.tencent.mm.plugin.wallet.pay.a.c.f)paramq);
        paramString = (com.tencent.mm.plugin.wallet.pay.a.c.f)paramq;
        if (paramString.isJumpRemind())
        {
          paramq = paramString.getJumpRemind();
          paramq.iiP();
          paramq.a(this, new com.tencent.mm.wallet_core.c.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(69403);
              if (paramq.iiO())
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
              if (paramq.iiO())
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
              if (paramq.iiO())
              {
                WalletPayUI.a(WalletPayUI.this, paramString);
                AppMethodBeat.o(69404);
                return;
              }
              WalletPayUI.this.gHe();
              AppMethodBeat.o(69404);
            }
          });
          AppMethodBeat.o(69458);
          return true;
        }
        a(paramString);
      }
      while (!(paramq instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        updateView();
        AppMethodBeat.o(69458);
        return true;
      }
      this.mPayResultType = 1;
      paramq = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramq;
      paramString = getInput();
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putParcelable("key_bankcard", this.OmO);
      paramString.putString("key_bank_type", this.OmO.field_bankcardType);
      if (!Util.isNullOrNil(this.njf)) {
        paramString.putString("key_pwd1", this.njf);
      }
      paramString.putString("kreq_token", paramq.getToken());
      paramString.putParcelable("key_authen", paramq.OxB);
      if (!paramq.Oxz)
      {
        bool = true;
        paramString.putBoolean("key_need_verify_sms", bool);
        paramString.putInt("key_can_verify_tail", paramq.OxF);
        paramString.putString("key_verify_tail_wording", paramq.OxG);
        localObject1 = getInput();
        if (paramq.OxH != 1) {
          break label628;
        }
        bool = true;
        ((Bundle)localObject1).putBoolean("key_block_bind_new_card", bool);
        if (!Util.isNullOrNil(paramq.OxC)) {
          break label634;
        }
        paramString.putString("key_mobile", this.OmO.field_mobile);
        paramString.putString("key_QADNA_URL", paramq.OxD);
        if (!paramq.isPaySuccess) {
          break label649;
        }
        if (this.Iol != null)
        {
          this.Iol.cH(10003, "");
          localObject1 = this.Iol;
          com.tencent.mm.plugin.report.service.h.IzE.a(13455, new Object[] { ((com.tencent.mm.plugin.wallet.a)localObject1).Oky, Long.valueOf(System.currentTimeMillis()), ((com.tencent.mm.plugin.wallet.a)localObject1).Okz });
        }
        paramString.putParcelable("key_orders", paramq.OxA);
        if (this.mPayInfo != null)
        {
          Log.i(this.TAG, "payscene %d", new Object[] { Integer.valueOf(this.mPayInfo.fOY) });
          if (8 == this.mPayInfo.fOY)
          {
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmK, Boolean.TRUE);
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("pwd", this.njf);
        localObject2 = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.b.a.i.class);
        paramInt1 = 0;
        if (!((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).eoM()) {
          break label663;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
        ((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).a(paramq.gGR(), true, this.mPayInfo.ORb, (Bundle)localObject1);
        paramString.putInt("key_pay_flag", 3);
        paramq = paramq.GCy;
        if (paramq != null) {
          paramString.putParcelable("key_realname_guide_helper", paramq);
        }
        aE(paramString);
        AppMethodBeat.o(69458);
        return true;
        bool = false;
        break;
        label628:
        bool = false;
        break label308;
        label634:
        paramString.putString("key_mobile", paramq.OxC);
        break label343;
        label649:
        paramString.putParcelable("key_orders", this.Ivh);
        break label503;
        label663:
        if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).eoN()) {
          paramInt1 = 2;
        }
      }
    }
    if ((paramq instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("pwd", this.njf);
      localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.mPayInfo.PbP == 1)
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
      paramq = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramq;
      this.OyT = getInput();
      this.OyT.putParcelable("key_pay_info", this.mPayInfo);
      this.OyT.putParcelable("key_bankcard", this.OmO);
      if (!Util.isNullOrNil(this.njf)) {
        this.OyT.putString("key_pwd1", this.njf);
      }
      this.OyT.putString("kreq_token", paramq.getToken());
      this.OyT.putParcelable("key_authen", paramq.OxB);
      localObject1 = this.OyT;
      if (!paramq.Oxz)
      {
        bool = true;
        label980:
        ((Bundle)localObject1).putBoolean("key_need_verify_sms", bool);
        this.OyT.putString("key_mobile", this.OmO.field_mobile);
        this.OyT.putInt("key_err_code", paramInt2);
        this.OyT.putParcelable("key_orders", this.Ivh);
        if (!Util.isNullOrNil(paramString)) {
          break label1507;
        }
        paramString = getString(a.i.wallet_pay_reset_info_tips, new Object[] { this.OmO.field_desc, this.OmO.field_mobile });
      }
    }
    label1507:
    for (;;)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, "", getString(a.i.wallet_pay_reset_info), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69406);
          WalletPayUI.this.OyT.putInt("key_pay_flag", 3);
          WalletPayUI.this.aE(WalletPayUI.this.OyT);
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
      this.mPayInfo.Rzi = paramInt2;
      gGY();
      AppMethodBeat.o(69458);
      return true;
      this.mPayInfo.Rzi = paramInt2;
      bool = false;
      if (paramInt2 == 100100) {
        bool = true;
      }
      if (this.OxZ == null) {
        this.OxZ = new a(this, this);
      }
      this.OxZ.c(bool, this.mPayInfo.fHa, this.mPayInfo.fwv);
      Log.i(this.TAG, "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool)));
      AppMethodBeat.o(69458);
      return true;
      if ((this.OmO == null) || (this.Ivh == null)) {
        break;
      }
      this.OmO.ONC = this.Ivh.fwv;
      if ((this.mPayInfo != null) && ((this.mPayInfo.fOY == 45) || (this.mPayInfo.fOY == 52))) {
        com.tencent.mm.ui.base.h.a(getContext(), paramString, "", getString(a.i.app_ok), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(69408);
            if (WalletPayUI.this.getProcess() != null) {
              com.tencent.mm.wallet_core.a.b(WalletPayUI.this.getContext(), WalletPayUI.this.getInput(), paramInt2);
            }
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            AppMethodBeat.o(69408);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(69458);
        return true;
        if ((this.OmN != null) && (this.OmN.size() > 1)) {
          e(true, 4, paramString);
        } else {
          d(true, 4, paramString);
        }
      }
      if (!(paramq instanceof com.tencent.mm.plugin.wallet.pay.a.c.f)) {
        break;
      }
      this.Ozq = true;
      gHp();
      if (paramInt2 == 416)
      {
        Log.e(this.TAG, "errCode is 416 need real name verify!");
        this.mPayResultType = 2;
        this.Ozn = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
        paramString.putString("realname_verify_process_jump_plugin", "wallet");
        if (this.mPayInfo != null) {}
        for (paramInt1 = this.mPayInfo.fOY;; paramInt1 = 0)
        {
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramq, paramString, paramInt1);
          AppMethodBeat.o(69458);
          return bool;
        }
      }
      this.mPayResultType = 3;
      Log.i(this.TAG, "errCode is %d , not need real name verify!", new Object[] { Integer.valueOf(paramInt2) });
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
  
  protected final void updateView()
  {
    AppMethodBeat.i(69439);
    if ((this.Ivh != null) && (this.Ivh.ORd != null) && (this.Ivh.ORd.size() > 0))
    {
      this.OyV.setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(this.Ivh.fwy));
      this.OyY.setText(com.tencent.mm.wallet_core.ui.g.bCn(this.Ivh.GHz));
      this.Ozf.notifyDataSetChanged();
      if (this.Ivh.ORd.size() > 1)
      {
        this.Ozb.setVisibility(0);
        this.OyW.setText(getString(a.i.wallet_pay_ui_title_desc, new Object[] { ((Orders.Commodity)this.Ivh.ORd.get(0)).desc, this.Ivh.ORd.size() }));
        this.OyS = false;
      }
    }
    else
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.fOY == 48)) {
        this.OyW.setText(a.i.qr_reward_grant_btn);
      }
      this.OyZ.setVisibility(8);
      this.Oza.setVisibility(8);
      this.Ozi.setVisibility(8);
      this.Ozj.setVisibility(8);
      this.Iub.setText(a.i.wallet_pay);
      if ((this.OmO == null) || (!this.OmO.gIH())) {
        break label542;
      }
      if (Util.isNullOrNil(this.OmO.field_forbidWord)) {
        break label522;
      }
      this.OyZ.setText(this.OmO.field_forbidWord);
      this.OyZ.setVisibility(4);
      this.Oza.setVisibility(8);
      s.gGL();
      if (s.gGM().gJR()) {
        gHf();
      }
      label329:
      s.gGL();
      if (!s.gGM().gJR())
      {
        s.gGL();
        if (!s.gGM().gJS()) {
          break label590;
        }
      }
    }
    label424:
    label571:
    label590:
    for (int i = 1;; i = 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)findViewById(a.f.wallet_order_info_favor_ll);
      if ((i != 0) && (this.OxY != null) && (this.OyM != null) && (this.OyN) && (this.Ivh != null))
      {
        gHh();
        this.Ozd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69423);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            int i;
            if (WalletPayUI.this.mPayInfo == null)
            {
              i = 0;
              if (WalletPayUI.this.mPayInfo != null) {
                break label137;
              }
            }
            label137:
            for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.fwv)
            {
              af.f(i, paramAnonymousView, 12, "");
              o.a(WalletPayUI.this.getContext(), WalletPayUI.this.Ivh, WalletPayUI.this.OxY.OPI, new o.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  int j = 1;
                  AppMethodBeat.i(69422);
                  WalletPayUI.this.OxY = paramAnonymous2FavorPayInfo;
                  Object localObject = WalletPayUI.this.TAG;
                  int i;
                  label82:
                  label98:
                  boolean bool;
                  if (paramAnonymous2FavorPayInfo == null)
                  {
                    paramAnonymous2FavorPayInfo = "";
                    Log.i((String)localObject, "WalletFavorDialog onSelectionDone %s", new Object[] { paramAnonymous2FavorPayInfo });
                    if (WalletPayUI.this.OxY != null)
                    {
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label467;
                      }
                      i = 0;
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label485;
                      }
                      paramAnonymous2FavorPayInfo = "";
                      af.f(i, paramAnonymous2FavorPayInfo, 15, WalletPayUI.this.OxY.OPI);
                      if ((WalletPayUI.this.OmO != null) && (!com.tencent.mm.plugin.wallet_core.ui.e.a(WalletPayUI.this.OxY, WalletPayUI.this.OmO))) {
                        break label502;
                      }
                      WalletPayUI.this.Oza.setVisibility(8);
                      WalletPayUI.this.Iub.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69419);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bn(paramAnonymous3View);
                          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                          Log.i(WalletPayUI.this.TAG, "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
                          WalletPayUI.this.d(false, 0, "");
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
                    Log.i(WalletPayUI.this.TAG, "needBindBankCard %s", new Object[] { Boolean.valueOf(bool) });
                    WalletPayUI.c(WalletPayUI.this).setVisibility(0);
                    WalletPayUI.d(WalletPayUI.this).setVisibility(0);
                    if (WalletPayUI.this.OxY != null)
                    {
                      WalletPayUI.this.OyM = com.tencent.mm.plugin.wallet_core.ui.f.OVk.a(WalletPayUI.this.Ivh);
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.OyM.bhs(WalletPayUI.this.OxY.OPI);
                      if ((paramAnonymous2FavorPayInfo != null) && (paramAnonymous2FavorPayInfo.Owl == 0.0D))
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
                        WalletPayUI.this.OyZ.setVisibility(8);
                        WalletPayUI.this.Oza.setVisibility(0);
                        WalletPayUI.this.Iub.setOnClickListener(new View.OnClickListener()
                        {
                          public final void onClick(View paramAnonymous3View)
                          {
                            AppMethodBeat.i(69421);
                            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                            localb.bn(paramAnonymous3View);
                            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                            WalletPayUI.this.gHk();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(69421);
                          }
                        });
                      }
                      if (i != 0) {
                        WalletPayUI.this.Oza.setVisibility(8);
                      }
                      WalletPayUI.this.gHh();
                      AppMethodBeat.o(69422);
                      return;
                      paramAnonymous2FavorPayInfo = paramAnonymous2FavorPayInfo.toString();
                      break;
                      label467:
                      i = WalletPayUI.this.mPayInfo.fOY;
                      break label82;
                      label485:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.mPayInfo.fwv;
                      break label98;
                      label502:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.OyM.bhs(WalletPayUI.this.OxY.OPI);
                      if ((paramAnonymous2FavorPayInfo == null) || (!WalletPayUI.this.OmO.gIH())) {
                        break label644;
                      }
                      s.gGL();
                      localObject = s.gGM().OnP;
                      double d = paramAnonymous2FavorPayInfo.Owl;
                      if ((localObject == null) || (((Bankcard)localObject).OND >= d)) {
                        break label644;
                      }
                      Log.i(WalletPayUI.this.TAG, "balance not meet");
                      WalletPayUI.this.Oza.setVisibility(8);
                      WalletPayUI.this.Iub.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69420);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bn(paramAnonymous3View);
                          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                          Log.i(WalletPayUI.this.TAG, "Balance amount not meet, after favor selection! payWithNewBankcard");
                          WalletPayUI.this.d(false, 0, "");
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
              i = WalletPayUI.this.mPayInfo.fOY;
              break;
            }
          }
        });
        localLinearLayout.setVisibility(0);
        if ((this.Ivh == null) || (this.OmN == null) || (this.mPayInfo == null)) {
          break label571;
        }
        this.Iub.setClickable(true);
        this.Iub.setEnabled(true);
      }
      for (;;)
      {
        if (this.Ivh == null) {
          this.Oza.setVisibility(8);
        }
        AppMethodBeat.o(69439);
        return;
        this.OyW.setText(((Orders.Commodity)this.Ivh.ORd.get(0)).desc);
        this.Ozb.setVisibility(8);
        break;
        s.gGL();
        if (!s.gGM().gJR()) {
          break label329;
        }
        gHf();
        break label329;
        s.gGL();
        if (!s.gGM().gJS()) {
          break label329;
        }
        gHf();
        break label329;
        localLinearLayout.setVisibility(8);
        break label424;
        this.Iub.setClickable(false);
        this.Iub.setEnabled(false);
      }
    }
  }
  
  protected final class a
  {
    protected a() {}
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(69426);
      WalletPayUI.this.Oze.removeAllViews();
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
      label294:
      label338:
      if (WalletPayUI.this.mCount == 0)
      {
        i = 0;
        localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
        j = 0;
        if (j >= i) {
          break label573;
        }
        localView = ((LayoutInflater)WalletPayUI.this.getSystemService("layout_inflater")).inflate(a.g.wallet_pay_item, null);
        localTextView1 = (TextView)localView.findViewById(a.f.wallet_order_info_desc);
        localTextView2 = (TextView)localView.findViewById(a.f.wallet_order_info_spid);
        localCommodity = (Orders.Commodity)WalletPayUI.this.Ivh.ORd.get(j);
        str2 = "";
        str1 = str2;
        if (WalletPayUI.this.mPayInfo != null) {
          if ((WalletPayUI.this.mPayInfo.fOY != 32) && (WalletPayUI.this.mPayInfo.fOY != 33) && (WalletPayUI.this.mPayInfo.fOY != 31))
          {
            str1 = str2;
            if (WalletPayUI.this.mPayInfo.fOY != 48) {}
          }
          else
          {
            str1 = WalletPayUI.this.mPayInfo.lfu.getString("extinfo_key_1", "");
            if (Util.isNullOrNil(str1)) {
              break label448;
            }
            com.tencent.mm.kernel.h.aHH();
            as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(str1);
            if (localas == null) {
              break label423;
            }
            str1 = localas.ays();
          }
        }
        label255:
        if (localCommodity != null)
        {
          if (Util.isNullOrNil(str1)) {
            break label466;
          }
          localTextView2.setText(str1);
          localTextView2.setVisibility(0);
          ((TextView)localView.findViewById(a.f.wallet_order_info_spid_title)).setVisibility(0);
          if (Util.isNullOrNil(localCommodity.desc)) {
            break label537;
          }
          localTextView1.setText(localCommodity.desc);
          localTextView1.setVisibility(8);
          ((TextView)localView.findViewById(a.f.wallet_order_info_desc_title)).setVisibility(8);
          if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(localCommodity.GHo))) {
            break label563;
          }
          localView.setVisibility(0);
        }
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        localView.measure(-2, -2);
        WalletPayUI.this.Oze.addView(localView);
        j += 1;
        break label41;
        if (WalletPayUI.this.OyS)
        {
          i = WalletPayUI.this.mCount;
          break;
        }
        i = 1;
        break;
        label423:
        Log.e(WalletPayUI.this.TAG, "can not found contact for user::".concat(String.valueOf(str1)));
        str1 = str2;
        break label255;
        label448:
        Log.e(WalletPayUI.this.TAG, "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        str1 = str2;
        break label255;
        label466:
        if (!Util.isNullOrNil(localCommodity.GHo))
        {
          localTextView2.setText(localCommodity.GHo);
          localTextView2.setVisibility(0);
          ((TextView)localView.findViewById(a.f.wallet_order_info_spid_title)).setVisibility(0);
          break label294;
        }
        ((TextView)localView.findViewById(a.f.wallet_order_info_spid_title)).setVisibility(8);
        localTextView2.setVisibility(8);
        break label294;
        label537:
        ((TextView)localView.findViewById(a.f.wallet_order_info_desc_title)).setVisibility(8);
        localTextView1.setVisibility(8);
        break label338;
        label563:
        localView.setVisibility(8);
      }
      label573:
      AppMethodBeat.o(69426);
    }
  }
  
  final class b
  {
    int aNf;
    WeakReference<WalletPayUI> pZE;
    long timestamp;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
 * JD-Core Version:    0.7.0.1
 */