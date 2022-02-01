package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.act;
import com.tencent.mm.autogen.a.add;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.autogen.a.ade.a;
import com.tencent.mm.autogen.a.adm;
import com.tencent.mm.plugin.wallet.model.j;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.plugin.wallet_core.ui.p.b;
import com.tencent.mm.plugin.wallet_core.ui.u.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.e.a;
import com.tencent.mm.wallet_core.model.ag;
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
  private static boolean VnU;
  private static List<b> VnV;
  private IListener CUH;
  protected com.tencent.mm.plugin.wallet.a OlE;
  private String Ome;
  protected Button OrJ;
  protected Orders OsJ;
  public String TAG;
  protected ArrayList<Bankcard> Vbt;
  protected Bankcard Vbu;
  private com.tencent.mm.plugin.wallet.pay.a.d VmX;
  private com.tencent.mm.plugin.wallet.pay.a.c.f VnW;
  protected com.tencent.mm.plugin.wallet_core.ui.f VnX;
  private boolean VnY;
  protected boolean VnZ;
  protected FavorPayInfo Vnj;
  private a Vnk;
  com.tencent.mm.plugin.wallet_core.ui.h Vnl;
  private boolean Vnm;
  private int VoA;
  private boolean VoB;
  private boolean VoC;
  private com.tencent.mm.plugin.wallet.pay.a.c.f VoD;
  private boolean VoE;
  private boolean VoF;
  private int VoG;
  private Runnable VoH;
  private b VoI;
  private long VoJ;
  private e.a Voa;
  protected boolean Vob;
  protected String Voc;
  protected boolean Vod;
  protected Bundle Voe;
  protected boolean Vof;
  protected TextView Vog;
  protected TextView Voh;
  private TextView Voi;
  protected TextView Voj;
  protected TextView Vok;
  protected TextView Vol;
  protected ImageView Vom;
  private TextView Von;
  private TextView Voo;
  protected LinearLayout Vop;
  protected a Voq;
  protected Dialog Vor;
  private long Vos;
  private TextView Vot;
  private LinearLayout Vou;
  private boolean Vov;
  private boolean Vow;
  private boolean Vox;
  private boolean Voy;
  private boolean Voz;
  private boolean isPaySuccess;
  protected int mCount;
  protected PayInfo mPayInfo;
  protected String qgt;
  
  static
  {
    AppMethodBeat.i(69482);
    VnU = false;
    VnV = new ArrayList();
    AppMethodBeat.o(69482);
  }
  
  public WalletPayUI()
  {
    AppMethodBeat.i(69427);
    this.TAG = "MicroMsg.WalletPayUI";
    this.OsJ = null;
    this.VnW = null;
    this.mCount = 0;
    this.qgt = null;
    this.Vbt = null;
    this.Vbu = null;
    this.Vnj = null;
    this.VnX = null;
    this.VnY = false;
    this.isPaySuccess = false;
    this.VnZ = false;
    this.Vob = false;
    this.Voc = "";
    this.mPayInfo = null;
    this.Vod = false;
    this.Voe = null;
    this.Vof = false;
    this.Vos = 0L;
    this.Vov = true;
    this.Vow = false;
    this.Vox = false;
    this.Voy = false;
    this.Voz = false;
    this.VoA = -1;
    this.VoB = false;
    this.VoC = false;
    this.OlE = null;
    this.VoE = false;
    this.VoF = false;
    this.VmX = null;
    this.VoG = 0;
    this.VoH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69386);
        Log.i(WalletPayUI.this.TAG, "auto reset create flag");
        WalletPayUI.aAs();
        AppMethodBeat.o(69386);
      }
    };
    this.VoJ = 0L;
    this.CUH = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Vnm = false;
    AppMethodBeat.o(69427);
  }
  
  private void a(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    AppMethodBeat.i(69456);
    Log.i(this.TAG, "stopRealname realnameGuideFlag %s guide_type %s", new Object[] { paramf.igC, Integer.valueOf(paramf.VmW) });
    label109:
    Object localObject;
    label150:
    int j;
    if (("1".equals(paramf.igC)) || ("2".equals(paramf.igC)))
    {
      this.VoD = paramf;
      this.VmX = paramf.VmX;
      this.VoB = true;
      this.OsJ = paramf.OsJ;
      if (this.OsJ == null) {
        break label529;
      }
      i = this.OsJ.VGX.size();
      this.mCount = i;
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("get mOrders! bankcardTag : ");
      if (this.OsJ == null) {
        break label534;
      }
      paramf = Integer.valueOf(this.OsJ.Vyb);
      Log.d((String)localObject, paramf);
      bZk();
      if ((this.OsJ != null) && (this.OsJ.VGY != null))
      {
        this.VnX = com.tencent.mm.plugin.wallet_core.ui.g.VLx.a(this.OsJ);
        if (this.VnX != null)
        {
          paramf = this.VnX.ikx();
          if ((paramf != null) && (paramf.size() > 0)) {
            this.VnY = true;
          }
          this.Vnj = this.VnX.bhe(this.OsJ.VGY.Vlx);
          this.Vnj.VFC = this.VnX.bhf(this.Vnj.VFC);
          Log.i(this.TAG, "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", new Object[] { this.OsJ.VGY.Vlx, this.Vnj.VFC, this.Vnj.VFC, this.Vnj.toString() });
        }
      }
      if ((this.OsJ != null) && (this.Vbt != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.m.a(this.mPayInfo, this.OsJ);
        paramf = com.tencent.mm.plugin.report.service.h.OAn;
        j = this.mPayInfo.hUR;
        com.tencent.mm.plugin.wallet.model.p.ifO();
        if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijf()) {
          break label540;
        }
      }
    }
    label529:
    label534:
    label540:
    for (int i = 2;; i = 1)
    {
      paramf.b(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.OsJ.hAW * 100.0D)), this.OsJ.MEq });
      if ((this.OsJ == null) || (this.OsJ.VGX == null)) {
        break label601;
      }
      paramf = new LinkedList();
      localObject = this.OsJ.VGX.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramf.add(((Orders.Commodity)((Iterator)localObject).next()).hAU);
      }
      this.VoD = null;
      break;
      i = 0;
      break label109;
      paramf = "";
      break label150;
    }
    if (paramf.size() > 0)
    {
      localObject = new add();
      ((add)localObject).ihg.ihi = paramf;
      ((add)localObject).publish();
      if (this.OlE != null) {
        this.OlE.dx(10001, (String)paramf.get(0));
      }
    }
    label601:
    if ((this.OsJ != null) && (this.OsJ.VHv != null) && (this.OsJ.VHv.VIO == 1) && (!Util.isNullOrNil(this.OsJ.VHv.MDt)))
    {
      this.Vob = true;
      this.Voc = this.OsJ.VHv.MDt;
    }
    com.tencent.mm.plugin.wallet.model.p.ifO();
    this.Vbt = com.tencent.mm.plugin.wallet.model.p.ifP().HK(ifZ());
    if (!Util.isNullOrNil(this.Voc))
    {
      this.Vbu = igs();
      paramf = Util.nullAs(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!Util.isNullOrNil(paramf)) {
        this.Vbu = bgn(paramf);
      }
      this.OrJ.setClickable(true);
      if (Util.isNullOrNil(com.tencent.mm.plugin.wallet_core.model.u.iiC().VKq)) {
        break label1034;
      }
      this.Von.setVisibility(0);
      this.Von.setText(com.tencent.mm.plugin.wallet_core.model.u.iiC().VKq);
      label776:
      if ((this.OsJ != null) && (this.Vbt != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.m.a(this.mPayInfo, this.OsJ);
        paramf = com.tencent.mm.plugin.report.service.h.OAn;
        j = this.mPayInfo.hUR;
        com.tencent.mm.plugin.wallet.model.p.ifO();
        if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijf()) {
          break label1055;
        }
        i = 2;
        label835:
        paramf.b(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.OsJ.hAW * 100.0D)), this.OsJ.MEq });
      }
      if (this.Vow) {
        ch(0, false);
      }
      if (getPayInfo().nKf != null) {
        break label1060;
      }
    }
    label1034:
    label1055:
    label1060:
    for (long l = 0L;; l = getPayInfo().nKf.getLong("wallet_pay_key_check_time"))
    {
      if (l > 0L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(641L, 4L, 1L, true);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(641L, 5L, Util.milliSecondsToNow(l), true);
      }
      if (this.VoJ > 0L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(641L, 7L, 1L, true);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(641L, 8L, Util.milliSecondsToNow(this.VoJ), true);
      }
      AppMethodBeat.o(69456);
      return;
      com.tencent.mm.plugin.wallet.model.p.ifO();
      this.Vbu = com.tencent.mm.plugin.wallet.model.p.ifP().a(null, null, ifZ(), false);
      break;
      this.Von.setVisibility(8);
      this.Von.setText("");
      break label776;
      i = 1;
      break label835;
    }
  }
  
  private void arV(int paramInt)
  {
    AppMethodBeat.i(69428);
    this.VoG = paramInt;
    Log.i(this.TAG, "markForceFinish errorType %s %s", new Object[] { Integer.valueOf(paramInt), Util.getStack().toString() });
    AppMethodBeat.o(69428);
  }
  
  private boolean b(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    int i = 0;
    AppMethodBeat.i(69474);
    boolean bool;
    if ("1".equals(paramf.igC))
    {
      Log.i(this.TAG, "need realname verify");
      this.Voy = true;
      paramf = new Bundle();
      paramf.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
      paramf.putString("realname_verify_process_jump_plugin", "wallet");
      isTransparent();
      if (this.mPayInfo != null) {
        i = this.mPayInfo.hUR;
      }
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf, null, i);
      AppMethodBeat.o(69474);
      return bool;
    }
    if ("2".equals(paramf.igC))
    {
      Log.i(this.TAG, "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf.igD, paramf.igG, paramf.igE, paramf.igF, isTransparent(), null);
      AppMethodBeat.o(69474);
      return bool;
    }
    Log.i(this.TAG, "realnameGuideFlag =  " + paramf.igC);
    AppMethodBeat.o(69474);
    return false;
  }
  
  private boolean bZk()
  {
    AppMethodBeat.i(69459);
    String str2;
    String str1;
    if ((this.OsJ == null) || (this.OsJ.VGX == null) || (this.OsJ.VGX.size() <= 0))
    {
      Log.w(this.TAG, "mOrders info is Illegal!");
      if ((this.VnW != null) && (this.VnW.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      str2 = getString(a.i.wallet_order_info_err);
      str1 = str2;
      if (this.VnW != null)
      {
        str1 = str2;
        if (!Util.isNullOrNil(this.VnW.errMsg)) {
          str1 = this.VnW.errMsg;
        }
      }
      Log.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.k.d(getContext(), str1, "", new DialogInterface.OnClickListener()
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
    if ((this.Vob) && (!Util.isNullOrNil(this.Voc)) && (igs() == null))
    {
      if ((this.VnW != null) && (this.VnW.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      Log.w(this.TAG, "hy: should use given bankcard, but resolved as null. show error msg and quit");
      str2 = getString(a.i.wallet_order_info_err);
      str1 = str2;
      if (this.VnW != null)
      {
        str1 = str2;
        if (!Util.isNullOrNil(this.VnW.errMsg)) {
          str1 = this.VnW.errMsg;
        }
      }
      Log.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.k.d(getContext(), str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(315514);
          WalletPayUI.this.finish();
          AppMethodBeat.o(315514);
        }
      });
      AppMethodBeat.o(69459);
      return false;
    }
    AppMethodBeat.o(69459);
    return true;
  }
  
  private Bankcard bgn(String paramString)
  {
    AppMethodBeat.i(69461);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    Object localObject = com.tencent.mm.plugin.wallet.model.p.ifP().HJ(true);
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
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
  
  private PayInfo getPayInfo()
  {
    AppMethodBeat.i(69470);
    if (this.mPayInfo == null) {
      this.mPayInfo = ((PayInfo)getIntent().getParcelableExtra("key_pay_info"));
    }
    PayInfo localPayInfo = this.mPayInfo;
    AppMethodBeat.o(69470);
    return localPayInfo;
  }
  
  private boolean ifS()
  {
    AppMethodBeat.i(69449);
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVk, Integer.valueOf(0))).intValue();
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      i = 1;
    }
    if ((i == 1) || ((this.OsJ != null) && (this.OsJ.VHu == 1)))
    {
      AppMethodBeat.o(69449);
      return true;
    }
    AppMethodBeat.o(69449);
    return false;
  }
  
  private boolean ifZ()
  {
    return (this.mPayInfo != null) && (this.mPayInfo.hUR != 11);
  }
  
  private boolean igh()
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
        p(-1, getIntent());
      }
      for (this.isPaySuccess = true;; this.isPaySuccess = false)
      {
        AppMethodBeat.o(69430);
        return true;
        Log.d(this.TAG, "pay cancel");
        p(0, getIntent());
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
  
  private void igj()
  {
    AppMethodBeat.i(69440);
    if (this.OsJ == null)
    {
      Log.e(this.TAG, "updatePaymentMethodForFavor mOrders is null");
      AppMethodBeat.o(69440);
      return;
    }
    this.Vol.setVisibility(8);
    this.Vok.setVisibility(8);
    this.OrJ.setText(a.i.wallet_pay);
    this.Vot.setVisibility(0);
    this.Vou.setVisibility(0);
    View localView = this.Vou.findViewById(a.f.balance_layout);
    Object localObject = this.Vou.findViewById(a.f.add_bankcard_layout);
    final CheckedTextView localCheckedTextView1;
    final CheckedTextView localCheckedTextView2;
    int i;
    if ("CFT".equals(this.OsJ.VGS))
    {
      ((View)localObject).setVisibility(8);
      localCheckedTextView1 = (CheckedTextView)this.Vou.findViewById(a.f.balance_check);
      localCheckedTextView2 = (CheckedTextView)this.Vou.findViewById(a.f.add_bank_check);
      localView.setEnabled(true);
      if ((this.OsJ == null) || (this.OsJ.VGX == null) || (this.OsJ.VGX.size() <= 0)) {
        break label757;
      }
      if (this.OsJ.VGH != 1) {
        break label565;
      }
      i = 1;
    }
    for (;;)
    {
      label200:
      if (this.Vbu == null)
      {
        localView.setVisibility(8);
        label213:
        ((View)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69425);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            localCheckedTextView1.setChecked(false);
            localCheckedTextView2.setChecked(true);
            WalletPayUI.a(WalletPayUI.this, true);
            WalletPayUI.e(WalletPayUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69425);
          }
        });
        this.Vot.setVisibility(0);
        this.Vou.setVisibility(0);
        if (this.Vnj == null) {
          break label752;
        }
        this.VnX = com.tencent.mm.plugin.wallet_core.ui.g.VLx.a(this.OsJ);
        localObject = this.VnX.bhb(this.Vnj.VFC);
        if ((localObject == null) || (((j)localObject).Vlw != 0.0D)) {
          break label752;
        }
        this.Vou.setVisibility(8);
        this.Vot.setVisibility(8);
      }
      label480:
      label752:
      for (int j = 1;; j = 0)
      {
        this.Vov = true;
        if (j != 0) {
          this.Vov = false;
        }
        localCheckedTextView1.setChecked(false);
        localCheckedTextView2.setChecked(true);
        Log.i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.OsJ.VGZ);
        if (this.OsJ.VGZ == 1)
        {
          this.Vou.findViewById(a.f.discount_wording_layout).setVisibility(0);
          ((TextView)this.Vou.findViewById(a.f.discount_wording)).setText(this.OsJ.VHa);
          if (!TextUtils.isEmpty(this.OsJ.VHb))
          {
            ((TextView)this.Vou.findViewById(a.f.favor_rule_wording)).setText(" (" + this.OsJ.VHb + ")");
            if ((this.Vbu != null) && (this.Vbu.ihV()) && (!TextUtils.isEmpty(this.Vbu.field_forbidWord)))
            {
              localView.setEnabled(false);
              localCheckedTextView1.setVisibility(8);
              ((TextView)this.Vou.findViewById(a.f.balance_tips)).setText(this.Vbu.field_forbidWord);
            }
          }
        }
        for (;;)
        {
          igk();
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
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              localCheckedTextView1.setChecked(true);
              localCheckedTextView2.setChecked(false);
              WalletPayUI.a(WalletPayUI.this, false);
              WalletPayUI.e(WalletPayUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69424);
            }
          });
          break label213;
          ((TextView)this.Vou.findViewById(a.f.favor_rule_wording)).setText("");
          break label480;
          this.Vou.findViewById(a.f.discount_wording_layout).setVisibility(8);
          if ((this.Vbu != null) && (this.Vbu.ihV()) && (!TextUtils.isEmpty(this.Vbu.field_forbidWord)))
          {
            localView.setEnabled(false);
            localCheckedTextView1.setVisibility(8);
            ((TextView)this.Vou.findViewById(a.f.balance_tips)).setText(this.Vbu.field_forbidWord);
          }
          else if ((this.Vbu != null) && (this.Vbu.ihV()) && (TextUtils.isEmpty(this.Vbu.field_forbidWord)) && (i == 0))
          {
            localCheckedTextView1.setChecked(true);
            localCheckedTextView2.setChecked(false);
            this.Vov = false;
          }
        }
      }
      label565:
      label757:
      i = 0;
    }
  }
  
  private void igk()
  {
    AppMethodBeat.i(69441);
    if (this.Vov)
    {
      this.OrJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int j = 0;
          AppMethodBeat.i(69387);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.plugin.wallet.model.p.ifO();
          int i;
          if (com.tencent.mm.plugin.wallet.model.p.ifP().ijg())
          {
            if (WalletPayUI.this.mPayInfo == null)
            {
              i = 0;
              if (WalletPayUI.this.mPayInfo != null) {
                break label185;
              }
              paramAnonymousView = "";
              label77:
              ag.g(i, paramAnonymousView, 6, "");
            }
          }
          else
          {
            if (WalletPayUI.this.OsJ.VGZ != 1) {
              break label227;
            }
            com.tencent.mm.plugin.wallet.model.p.ifO();
            if (com.tencent.mm.plugin.wallet.model.p.ifP().ijg())
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
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.hAT)
          {
            ag.g(i, paramAnonymousView, 5, "");
            WalletPayUI.f(WalletPayUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69387);
            return;
            i = WalletPayUI.this.mPayInfo.hUR;
            break;
            paramAnonymousView = WalletPayUI.this.mPayInfo.hAT;
            break label77;
            i = WalletPayUI.this.mPayInfo.hUR;
            break label125;
          }
          label227:
          Log.i(WalletPayUI.this.TAG, "SimpleReg , assigned userinfo pay! payWithNewBankcard");
          com.tencent.mm.plugin.wallet.model.p.ifO();
          if (com.tencent.mm.plugin.wallet.model.p.ifP().ijg())
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
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.hAT)
          {
            ag.g(i, paramAnonymousView, 5, "");
            WalletPayUI.this.e(false, 0, "");
            break;
            i = WalletPayUI.this.mPayInfo.hUR;
            break label264;
          }
        }
      });
      AppMethodBeat.o(69441);
      return;
    }
    this.OrJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69388);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletPayUI.this.igo();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69388);
      }
    });
    AppMethodBeat.o(69441);
  }
  
  private Authen igm()
  {
    AppMethodBeat.i(69443);
    Authen localAuthen = new Authen();
    if (ign()) {}
    for (localAuthen.eQp = 3;; localAuthen.eQp = 6)
    {
      if (!Util.isNullOrNil(this.qgt)) {
        localAuthen.VCA = this.qgt;
      }
      if (this.Vbu != null)
      {
        localAuthen.MDt = this.Vbu.field_bindSerial;
        localAuthen.hAk = this.Vbu.field_bankcardType;
      }
      if ((this.Vnj != null) && (this.VnX != null) && (this.VnX.iku()))
      {
        localAuthen.VCK = this.Vnj.VFC;
        localAuthen.VCJ = this.Vnj.VFF;
      }
      localAuthen.Nxi = this.mPayInfo;
      AppMethodBeat.o(69443);
      return localAuthen;
    }
  }
  
  private boolean ign()
  {
    AppMethodBeat.i(69444);
    if ((this.Vbu != null) && (this.OsJ != null) && (this.OsJ.Vyb == 3))
    {
      if (this.Vbu.ihY())
      {
        AppMethodBeat.o(69444);
        return true;
      }
      AppMethodBeat.o(69444);
      return false;
    }
    if ((this.OsJ != null) && (!Bankcard.asi(this.OsJ.Vyb)))
    {
      AppMethodBeat.o(69444);
      return true;
    }
    AppMethodBeat.o(69444);
    return false;
  }
  
  private void igp()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(69447);
    com.tencent.mm.plugin.report.service.h.OAn.b(13958, new Object[] { Integer.valueOf(1) });
    if ((this.mPayInfo != null) && (8 == this.mPayInfo.hUR))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(13955, new Object[] { Integer.valueOf(2) });
      if (this.mPayInfo.nKf != null)
      {
        long l = this.mPayInfo.nKf.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.OAn.b(13956, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    Object localObject;
    if (this.Vnj != null)
    {
      this.VnX = com.tencent.mm.plugin.wallet_core.ui.g.VLx.a(this.OsJ);
      localObject = this.VnX.bhb(this.Vnj.VFC);
      if ((localObject == null) || (((j)localObject).Vlw != 0.0D)) {}
    }
    for (;;)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.wallet.model.p.ifO();
        if (com.tencent.mm.plugin.wallet.model.p.ifP().ijg())
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
          for (localObject = "";; localObject = this.mPayInfo.hAT)
          {
            ag.g(i, (String)localObject, 3, "");
            igq();
            AppMethodBeat.o(69447);
            return;
            i = this.mPayInfo.hUR;
            break;
          }
        }
        Log.i(this.TAG, "has useful bankcard ! payWithOldBankcard zeroPay");
        Hw(false);
        AppMethodBeat.o(69447);
        return;
      }
      if (this.Vob)
      {
        Log.i(this.TAG, "hy: start do pay with force use given bankcard");
        if (!Util.isNullOrNil(this.Voc))
        {
          this.Vbu = igs();
          Hw(false);
          AppMethodBeat.o(69447);
          return;
        }
        com.tencent.mm.plugin.wallet.model.p.ifO();
        if (com.tencent.mm.plugin.wallet.model.p.ifP().ijh()) {
          if (this.mPayInfo == null)
          {
            i = 0;
            if (this.mPayInfo != null) {
              break label408;
            }
            localObject = "";
            label372:
            ag.g(i, (String)localObject, 17, "");
          }
        }
        label408:
        do
        {
          e(false, 0, "");
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.hUR;
          break;
          localObject = this.mPayInfo.hAT;
          break label372;
          com.tencent.mm.plugin.wallet.model.p.ifO();
        } while (!com.tencent.mm.plugin.wallet.model.p.ifP().ijg());
        if (this.mPayInfo == null)
        {
          i = 0;
          label442:
          if (this.mPayInfo != null) {
            break label476;
          }
        }
        label476:
        for (localObject = "";; localObject = this.mPayInfo.hAT)
        {
          ag.g(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.hUR;
          break label442;
        }
      }
      localObject = Util.nullAs(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!Util.isNullOrNil((String)localObject)) {
        this.Vbu = bgn((String)localObject);
      }
      if (this.Vbu == null)
      {
        if ((this.Vbt != null) && (this.Vbt.size() > 0))
        {
          Log.i(this.TAG, " no last pay bankcard ! jump to select bankcard!");
          f(false, 8, "");
          AppMethodBeat.o(69447);
          return;
        }
        Log.i(this.TAG, "default bankcard not found! payWithNewBankcard");
        com.tencent.mm.plugin.wallet.model.p.ifO();
        if (com.tencent.mm.plugin.wallet.model.p.ifP().ijh()) {
          if (this.mPayInfo == null)
          {
            i = 0;
            if (this.mPayInfo != null) {
              break label652;
            }
            localObject = "";
            label616:
            ag.g(i, (String)localObject, 17, "");
          }
        }
        label652:
        do
        {
          e(false, 0, "");
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.hUR;
          break;
          localObject = this.mPayInfo.hAT;
          break label616;
          com.tencent.mm.plugin.wallet.model.p.ifO();
        } while (!com.tencent.mm.plugin.wallet.model.p.ifP().ijg());
        if (this.mPayInfo == null)
        {
          i = 0;
          label686:
          if (this.mPayInfo != null) {
            break label720;
          }
        }
        label720:
        for (localObject = "";; localObject = this.mPayInfo.hAT)
        {
          ag.g(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.hUR;
          break label686;
        }
      }
      i = this.Vbu.a(this.OsJ.Vyb, this.OsJ);
      if (this.OlE != null) {
        this.OlE.dx(10002, "");
      }
      if (i != 0)
      {
        Log.i(this.TAG, "main bankcard(" + i + ") is useless! jump to select bankcard!");
        f(false, i, "");
        AppMethodBeat.o(69447);
        return;
      }
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (com.tencent.mm.plugin.wallet.model.p.ifP().ijg())
      {
        Log.i(this.TAG, "payWithoutPassword");
        if (this.mPayInfo == null)
        {
          i = j;
          if (this.mPayInfo != null) {
            break label893;
          }
        }
        label893:
        for (localObject = "";; localObject = this.mPayInfo.hAT)
        {
          ag.g(i, (String)localObject, 3, "");
          igq();
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.hUR;
          break;
        }
      }
      Log.i(this.TAG, "has useful bankcard ! payWithOldBankcard");
      Hw(false);
      AppMethodBeat.o(69447);
      return;
      i = 0;
    }
  }
  
  private void igq()
  {
    AppMethodBeat.i(69448);
    Hx(true);
    com.tencent.mm.plugin.wallet_core.utils.m.imd();
    AppMethodBeat.o(69448);
  }
  
  private Bankcard igs()
  {
    AppMethodBeat.i(69460);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    Object localObject = com.tencent.mm.plugin.wallet.model.p.ifP().HJ(true);
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (Util.nullAsNil(this.Voc).equals(localBankcard.field_bindSerial))
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
  
  private boolean igt()
  {
    AppMethodBeat.i(69465);
    if (isTransparent())
    {
      setContentViewVisibility(4);
      aw.t(this, 0);
      AppMethodBeat.o(69465);
      return false;
    }
    setContentViewVisibility(0);
    aw.t(this, getActionbarColor());
    AppMethodBeat.o(69465);
    return true;
  }
  
  private boolean igu()
  {
    AppMethodBeat.i(69468);
    if ((this.OsJ != null) && (this.OsJ.VGO))
    {
      com.tencent.mm.kernel.h.baF();
      if (((Boolean)com.tencent.mm.kernel.h.baE().ban().d(196614, Boolean.TRUE)).booleanValue())
      {
        Object localObject = getLayoutInflater().inflate(a.g.wallet_pay_oversea_tip, null);
        CheckBox localCheckBox = (CheckBox)((View)localObject).findViewById(a.f.tips_cb);
        kx((View)localObject);
        ((TextView)((View)localObject).findViewById(a.f.tips_tv)).setOnClickListener(new WalletPayUI.22(this, localCheckBox));
        localObject = com.tencent.mm.ui.base.k.a(this, getString(a.i.wallet_pay_oversea_title), (View)localObject, getString(a.i.wallet_card_wx_check_agree), getString(a.i.wallet_refuse_message), new WalletPayUI.24(this, localCheckBox), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(315518);
            WalletPayUI.this.finish();
            AppMethodBeat.o(315518);
          }
        });
        ((com.tencent.mm.ui.widget.a.e)localObject).setCancelable(false);
        localCheckBox.setOnCheckedChangeListener(new WalletPayUI.26(this, (com.tencent.mm.ui.widget.a.e)localObject));
        AppMethodBeat.o(69468);
        return false;
      }
    }
    AppMethodBeat.o(69468);
    return true;
  }
  
  private void kx(View paramView)
  {
    AppMethodBeat.i(69469);
    paramView = (TextView)paramView.findViewById(a.f.network_tips_content);
    paramView.setText(Html.fromHtml(String.format(getResources().getString(a.i.wallet_pay_oversea_content), new Object[] { getResources().getString(a.i.wallet_agreen_oversea) })));
    paramView.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69469);
  }
  
  private void p(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(69437);
    if ((this.mPayInfo != null) && (this.mPayInfo.hUR == 46) && (this.OsJ != null))
    {
      paramIntent.putExtra("key_total_fee", this.OsJ.hAW);
      Log.i(this.TAG, "sentCancelEvent set fee:%s", new Object[] { Double.valueOf(this.OsJ.hAW) });
    }
    ade localade = new ade();
    localade.ihj.intent = paramIntent;
    ade.a locala;
    if (this.VoG == 1)
    {
      localade.ihj.ihk = 1000;
      localade.ihj.result = paramInt;
      locala = localade.ihj;
      if (this.mPayInfo != null) {
        break label214;
      }
    }
    label214:
    for (paramIntent = "";; paramIntent = this.mPayInfo.hAT)
    {
      locala.hAT = paramIntent;
      localade.ihj.ihm = 1;
      if ((this.mPayInfo != null) && (paramInt == 0)) {
        com.tencent.mm.plugin.wallet.pay.a.b.b.aO(this.mPayInfo.hAT, this.mPayInfo.hUR, this.mPayInfo.channel);
      }
      localade.publish();
      AppMethodBeat.o(69437);
      return;
      if (this.VoG != 2) {
        break;
      }
      localade.ihj.ihk = 1001;
      break;
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(69439);
    if ((this.OsJ != null) && (this.OsJ.VGX != null) && (this.OsJ.VGX.size() > 0))
    {
      this.Vog.setText(com.tencent.mm.wallet_core.ui.i.formatMoney2f(this.OsJ.hAW));
      this.Voj.setText(com.tencent.mm.wallet_core.ui.i.bEL(this.OsJ.MEq));
      this.Voq.notifyDataSetChanged();
      if (this.OsJ.VGX.size() > 1)
      {
        this.Vom.setVisibility(0);
        this.Voh.setText(getString(a.i.wallet_pay_ui_title_desc, new Object[] { ((Orders.Commodity)this.OsJ.VGX.get(0)).desc, this.OsJ.VGX.size() }));
        this.Vod = false;
      }
    }
    else
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.hUR == 48)) {
        this.Voh.setText(a.i.qr_reward_grant_btn);
      }
      this.Vok.setVisibility(8);
      this.Vol.setVisibility(8);
      this.Vot.setVisibility(8);
      this.Vou.setVisibility(8);
      this.OrJ.setText(a.i.wallet_pay);
      if ((this.Vbu == null) || (!this.Vbu.ihV())) {
        break label542;
      }
      if (Util.isNullOrNil(this.Vbu.field_forbidWord)) {
        break label522;
      }
      this.Vok.setText(this.Vbu.field_forbidWord);
      this.Vok.setVisibility(4);
      this.Vol.setVisibility(8);
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (com.tencent.mm.plugin.wallet.model.p.ifP().ijg()) {
        igj();
      }
      label329:
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijg())
      {
        com.tencent.mm.plugin.wallet.model.p.ifO();
        if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijh()) {
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
      if ((i != 0) && (this.Vnj != null) && (this.VnX != null) && (this.VnY) && (this.OsJ != null))
      {
        igl();
        this.Voo.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69423);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            int i;
            if (WalletPayUI.this.mPayInfo == null)
            {
              i = 0;
              if (WalletPayUI.this.mPayInfo != null) {
                break label137;
              }
            }
            label137:
            for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.hAT)
            {
              ag.g(i, paramAnonymousView, 12, "");
              com.tencent.mm.plugin.wallet_core.ui.p.a(WalletPayUI.this.getContext(), WalletPayUI.this.OsJ, WalletPayUI.this.Vnj.VFC, new p.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  int j = 1;
                  AppMethodBeat.i(69422);
                  WalletPayUI.this.Vnj = paramAnonymous2FavorPayInfo;
                  Object localObject = WalletPayUI.this.TAG;
                  int i;
                  label82:
                  label98:
                  boolean bool;
                  if (paramAnonymous2FavorPayInfo == null)
                  {
                    paramAnonymous2FavorPayInfo = "";
                    Log.i((String)localObject, "WalletFavorDialog onSelectionDone %s", new Object[] { paramAnonymous2FavorPayInfo });
                    if (WalletPayUI.this.Vnj != null)
                    {
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label467;
                      }
                      i = 0;
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label485;
                      }
                      paramAnonymous2FavorPayInfo = "";
                      ag.g(i, paramAnonymous2FavorPayInfo, 15, WalletPayUI.this.Vnj.VFC);
                      if ((WalletPayUI.this.Vbu != null) && (!com.tencent.mm.plugin.wallet_core.ui.f.a(WalletPayUI.this.Vnj, WalletPayUI.this.Vbu))) {
                        break label502;
                      }
                      WalletPayUI.this.Vol.setVisibility(8);
                      WalletPayUI.this.OrJ.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69419);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.cH(paramAnonymous3View);
                          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                          Log.i(WalletPayUI.this.TAG, "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
                          WalletPayUI.this.e(false, 0, "");
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
                    if (WalletPayUI.this.Vnj != null)
                    {
                      WalletPayUI.this.VnX = com.tencent.mm.plugin.wallet_core.ui.g.VLx.a(WalletPayUI.this.OsJ);
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.VnX.bhb(WalletPayUI.this.Vnj.VFC);
                      if ((paramAnonymous2FavorPayInfo != null) && (paramAnonymous2FavorPayInfo.Vlw == 0.0D))
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
                        WalletPayUI.this.Vok.setVisibility(8);
                        WalletPayUI.this.Vol.setVisibility(0);
                        WalletPayUI.this.OrJ.setOnClickListener(new View.OnClickListener()
                        {
                          public final void onClick(View paramAnonymous3View)
                          {
                            AppMethodBeat.i(69421);
                            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                            localb.cH(paramAnonymous3View);
                            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                            WalletPayUI.this.igo();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(69421);
                          }
                        });
                      }
                      if (i != 0) {
                        WalletPayUI.this.Vol.setVisibility(8);
                      }
                      WalletPayUI.this.igl();
                      AppMethodBeat.o(69422);
                      return;
                      paramAnonymous2FavorPayInfo = paramAnonymous2FavorPayInfo.toString();
                      break;
                      label467:
                      i = WalletPayUI.this.mPayInfo.hUR;
                      break label82;
                      label485:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.mPayInfo.hAT;
                      break label98;
                      label502:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.VnX.bhb(WalletPayUI.this.Vnj.VFC);
                      if ((paramAnonymous2FavorPayInfo == null) || (!WalletPayUI.this.Vbu.ihV())) {
                        break label644;
                      }
                      com.tencent.mm.plugin.wallet.model.p.ifO();
                      localObject = com.tencent.mm.plugin.wallet.model.p.ifP().VcF;
                      double d = paramAnonymous2FavorPayInfo.Vlw;
                      if ((localObject == null) || (((Bankcard)localObject).VDo >= d)) {
                        break label644;
                      }
                      Log.i(WalletPayUI.this.TAG, "balance not meet");
                      WalletPayUI.this.Vol.setVisibility(8);
                      WalletPayUI.this.OrJ.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69420);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.cH(paramAnonymous3View);
                          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                          Log.i(WalletPayUI.this.TAG, "Balance amount not meet, after favor selection! payWithNewBankcard");
                          WalletPayUI.this.e(false, 0, "");
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
              i = WalletPayUI.this.mPayInfo.hUR;
              break;
            }
          }
        });
        localLinearLayout.setVisibility(0);
        if ((this.OsJ == null) || (this.Vbt == null) || (this.mPayInfo == null)) {
          break label571;
        }
        this.OrJ.setClickable(true);
        this.OrJ.setEnabled(true);
      }
      for (;;)
      {
        if (this.OsJ == null) {
          this.Vol.setVisibility(8);
        }
        AppMethodBeat.o(69439);
        return;
        this.Voh.setText(((Orders.Commodity)this.OsJ.VGX.get(0)).desc);
        this.Vom.setVisibility(8);
        break;
        com.tencent.mm.plugin.wallet.model.p.ifO();
        if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijg()) {
          break label329;
        }
        igj();
        break label329;
        com.tencent.mm.plugin.wallet.model.p.ifO();
        if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijh()) {
          break label329;
        }
        igj();
        break label329;
        localLinearLayout.setVisibility(8);
        break label424;
        this.OrJ.setClickable(false);
        this.OrJ.setEnabled(false);
      }
    }
  }
  
  protected final void Hv(boolean paramBoolean)
  {
    AppMethodBeat.i(69446);
    if ((paramBoolean) && (!igu()))
    {
      AppMethodBeat.o(69446);
      return;
    }
    if (this.Vnj != null)
    {
      this.VnX = com.tencent.mm.plugin.wallet_core.ui.g.VLx.a(this.OsJ);
      j localj = this.VnX.bhb(this.Vnj.VFC);
      if ((localj == null) || (localj.Vlw != 0.0D)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.VoD != null)
      {
        if (this.VoD.VmW == 0)
        {
          Log.i(this.TAG, "need real name,stop");
          b(this.VoD);
          AppMethodBeat.o(69446);
          return;
        }
        if ((this.VoD.VmW == 1) && (i != 0))
        {
          Log.i(this.TAG, "need real name, zero stop");
          b(this.VoD);
        }
      }
      if (this.VmX != null)
      {
        if ((this.VmX.VmF == 1) && (!Util.isNullOrNil(this.VmX.rGU)) && (!Util.isNullOrNil(this.VmX.right_button_wording)) && (!Util.isNullOrNil(this.VmX.VmG)))
        {
          if ((this.mPayInfo != null) && (this.OsJ != null) && (this.OsJ.VGX != null) && (this.OsJ.VGX.size() > 0))
          {
            if (this.mPayInfo.hUR != 8) {
              break label371;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.OsJ.VGX.get(0)).hAU });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.k.a(getContext(), this.VmX.VmG, "", this.VmX.right_button_wording, this.VmX.rGU, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69389);
                Log.i(WalletPayUI.this.TAG, "click continue pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.OsJ != null) && (WalletPayUI.this.OsJ.VGX != null) && (WalletPayUI.this.OsJ.VGX.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.hUR != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.h.OAn.b(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.OsJ.VGX.get(0)).hAU });
                }
                for (;;)
                {
                  WalletPayUI.g(WalletPayUI.this);
                  AppMethodBeat.o(69389);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.h.OAn.b(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.OsJ.VGX.get(0)).hAU });
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69390);
                Log.i(WalletPayUI.this.TAG, "click cancel pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.OsJ != null) && (WalletPayUI.this.OsJ.VGX != null) && (WalletPayUI.this.OsJ.VGX.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.hUR != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.h.OAn.b(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.OsJ.VGX.get(0)).hAU });
                }
                for (;;)
                {
                  WalletPayUI.this.finish();
                  AppMethodBeat.o(69390);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.h.OAn.b(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.OsJ.VGX.get(0)).hAU });
                }
              }
            });
            AppMethodBeat.o(69446);
            return;
            label371:
            com.tencent.mm.plugin.report.service.h.OAn.b(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.OsJ.VGX.get(0)).hAU });
          }
        }
        if ((this.VmX.VmF == 2) && (!Util.isNullOrNil(this.VmX.VmG)) && (!Util.isNullOrNil(this.VmX.VmH)))
        {
          Log.i(this.TAG, "pay has been blocked");
          if ((this.mPayInfo != null) && (this.OsJ != null) && (this.OsJ.VGX != null) && (this.OsJ.VGX.size() > 0))
          {
            if (this.mPayInfo.hUR != 8) {
              break label624;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.OsJ.VGX.get(0)).hAU });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.k.a(getContext(), this.VmX.VmG, "", this.VmX.VmH, false, new DialogInterface.OnClickListener()
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
            com.tencent.mm.plugin.report.service.h.OAn.b(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.OsJ.VGX.get(0)).hAU });
          }
        }
      }
      igp();
      AppMethodBeat.o(69446);
      return;
    }
  }
  
  protected final void Hw(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(69451);
    if (!bZk())
    {
      AppMethodBeat.o(69451);
      return;
    }
    this.Vnm = false;
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
    for (Object localObject = "";; localObject = this.mPayInfo.hAT)
    {
      ag.g(i, (String)localObject, 8, "");
      if (this.Vor != null)
      {
        Log.w(this.TAG, "close previous cashier dialog");
        this.Vor.dismiss();
      }
      this.Vnm = false;
      if (!ifS()) {
        break label242;
      }
      this.Vor = new WcPayCashierDialog(getContext());
      localObject = (WcPayCashierDialog)this.Vor;
      PayInfo localPayInfo = this.mPayInfo;
      Orders localOrders = this.OsJ;
      FavorPayInfo localFavorPayInfo = this.Vnj;
      Bankcard localBankcard = this.Vbu;
      if (!this.Vob) {
        bool = true;
      }
      ((WcPayCashierDialog)localObject).a(localPayInfo, localOrders, localFavorPayInfo, localBankcard, bool, paramBoolean);
      ((WcPayCashierDialog)localObject).VUX = new WcPayCashierDialog.a()
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, Bankcard paramAnonymousBankcard)
        {
          AppMethodBeat.i(69392);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            Log.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.h.OAn.p(965L, 3L, 1L);
            AppMethodBeat.o(69392);
            return;
          }
          WalletPayUI.i(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.Vnj = paramAnonymousFavorPayInfo;
          WalletPayUI.this.Vbu = paramAnonymousBankcard;
          paramAnonymousBankcard = WalletPayUI.this.TAG;
          int i;
          if (WalletPayUI.this.Vnj == null)
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.hAT)
          {
            ag.g(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.qgt = paramAnonymousString;
            WalletPayUI.this.Hx(false);
            com.tencent.mm.plugin.wallet_core.utils.m.imd();
            AppMethodBeat.o(69392);
            return;
            paramAnonymousFavorPayInfo = WalletPayUI.this.Vnj.toString();
            break;
            i = WalletPayUI.this.mPayInfo.hUR;
            break label131;
          }
        }
        
        public final void ieE()
        {
          AppMethodBeat.i(69394);
          Log.i(WalletPayUI.this.TAG, "click add new bankcard");
          Object localObject = com.tencent.mm.plugin.wallet_core.model.g.iif();
          if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).cvt())
          {
            com.tencent.mm.ui.base.k.c(WalletPayUI.this.getContext(), ((com.tencent.mm.plugin.wallet_core.model.g)localObject).MDu, WalletPayUI.this.getString(a.i.app_tip), true);
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
          for (localObject = "";; localObject = WalletPayUI.this.mPayInfo.hAT)
          {
            ag.g(i, (String)localObject, 14, "");
            WalletPayUI.this.Vor.dismiss();
            WalletPayUI.this.Vor = null;
            WalletPayUI.this.igr();
            AppMethodBeat.o(69394);
            return;
            i = WalletPayUI.this.mPayInfo.hUR;
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
          for (String str = "";; str = WalletPayUI.this.mPayInfo.hAT)
          {
            ag.g(i, str, 10, "");
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            AppMethodBeat.o(69393);
            return;
            i = WalletPayUI.this.mPayInfo.hUR;
            break;
          }
        }
      };
      ((WcPayCashierDialog)localObject).show();
      addDialog((Dialog)localObject);
      AppMethodBeat.o(69451);
      return;
      i = this.mPayInfo.hUR;
      break;
    }
    label242:
    if (!this.Vob) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Vor = com.tencent.mm.plugin.wallet_core.ui.u.a(this, paramBoolean, this.OsJ, this.Vnj, this.Vbu, this.mPayInfo, this.Ome, new u.c()new View.OnClickListener
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(69395);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            Log.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.h.OAn.p(965L, 3L, 1L);
            AppMethodBeat.o(69395);
            return;
          }
          WalletPayUI.k(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.Vnj = paramAnonymousFavorPayInfo;
          String str = WalletPayUI.this.TAG;
          if (WalletPayUI.this.Vnj == null) {}
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.Vnj.toString())
          {
            Log.i(str, "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s", new Object[] { paramAnonymousFavorPayInfo, Boolean.valueOf(paramAnonymousBoolean) });
            if ((WalletPayUI.this.Vnj == null) || (!paramAnonymousBoolean)) {
              break;
            }
            WalletPayUI.this.ch(-100, true);
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.hAT)
          {
            ag.g(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.qgt = paramAnonymousString;
            WalletPayUI.this.Hx(false);
            com.tencent.mm.plugin.wallet_core.utils.m.imd();
            WalletPayUI.this.Vnl = null;
            AppMethodBeat.o(69395);
            return;
            i = WalletPayUI.this.mPayInfo.hUR;
            break;
          }
        }
      }, new View.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69396);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i(WalletPayUI.this.TAG, "WalletPwdDialog event1 %s", new Object[] { Util.getStack().toString() });
          WalletPayUI.this.Vnj = ((FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUI.this.Vnj != null) {
            WalletPayUI.this.Vnj.VFG = "";
          }
          WalletPayUI.this.f(false, 0, "");
          WalletPayUI.this.Vor.dismiss();
          WalletPayUI.this.qgt = null;
          WalletPayUI.this.Vor = null;
          WalletPayUI.this.Vnl = null;
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
          for (String str = "";; str = WalletPayUI.this.mPayInfo.hAT)
          {
            ag.g(i, str, 10, "");
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            WalletPayUI.this.qgt = null;
            WalletPayUI.this.Vor = null;
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            WalletPayUI.this.Vnl = null;
            AppMethodBeat.o(69397);
            return;
            i = WalletPayUI.this.mPayInfo.hUR;
            break;
          }
        }
      });
      this.Vnl = ((com.tencent.mm.plugin.wallet_core.ui.h)this.Vor);
      AppMethodBeat.o(69451);
      return;
    }
  }
  
  protected final void Hx(boolean paramBoolean)
  {
    AppMethodBeat.i(69467);
    com.tencent.mm.plugin.wallet.pay.a.a.b localb = com.tencent.mm.plugin.wallet.pay.a.a.a(igm(), this.OsJ, paramBoolean);
    if (this.OsJ != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_reqKey", this.OsJ.hAT);
      if ((this.OsJ.VGX != null) && (this.OsJ.VGX.size() > 0)) {
        localBundle.putString("key_TransId", ((Orders.Commodity)this.OsJ.VGX.get(0)).hAU);
      }
      localBundle.putLong("key_SessionId", this.Vos);
      localb.setProcessName("PayProcess");
      localb.setProcessBundle(localBundle);
    }
    if (this.mPayInfo != null)
    {
      if ((this.mPayInfo.hUR != 6) || (this.mPayInfo.YvD != 100)) {
        break label255;
      }
      localb.setScene(100);
    }
    for (;;)
    {
      doSceneProgress(localb);
      if ((this.mPayInfo != null) && (8 == this.mPayInfo.hUR) && (this.mPayInfo.nKf != null))
      {
        long l = this.mPayInfo.nKf.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.OAn.b(13956, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - l) });
      }
      AppMethodBeat.o(69467);
      return;
      label255:
      localb.setScene(this.mPayInfo.hUR);
    }
  }
  
  protected final void bh(Bundle paramBundle)
  {
    AppMethodBeat.i(69471);
    this.VnZ = true;
    if (this.OsJ != null)
    {
      paramBundle.putInt("key_support_bankcard", this.OsJ.Vyb);
      paramBundle.putString("key_reqKey", this.OsJ.hAT);
      if ((this.OsJ.VGX != null) && (this.OsJ.VGX.size() > 0)) {
        paramBundle.putString("key_TransId", ((Orders.Commodity)this.OsJ.VGX.get(0)).hAU);
      }
      paramBundle.putLong("key_SessionId", this.Vos);
    }
    if (this.mPayInfo != null) {
      paramBundle.putInt("key_scene", this.mPayInfo.hUR);
    }
    if (!ign()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      paramBundle.putInt("is_deduct_open", this.VoA);
      this.Voa = new e.a()
      {
        public final Intent v(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(315520);
          Log.i(WalletPayUI.this.TAG, "pay process end");
          WalletPayUI.this.VnZ = false;
          paramAnonymousBundle = new Intent();
          AppMethodBeat.o(315520);
          return paramAnonymousBundle;
        }
      };
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, paramBundle, this.Voa);
      AppMethodBeat.o(69471);
      return;
    }
  }
  
  protected final void ch(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(69455);
    com.tencent.mm.plugin.report.service.h.OAn.b(13958, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.h.OAn.b(13955, new Object[] { Integer.valueOf(4) });
    if (this.mPayInfo == null) {
      if (this.mPayInfo != null) {
        break label226;
      }
    }
    label226:
    for (Object localObject = "";; localObject = this.mPayInfo.hAT)
    {
      ag.g(i, (String)localObject, 11, "");
      localObject = getInput();
      ((Bundle)localObject).putInt("key_main_bankcard_state", paramInt);
      ((Bundle)localObject).putParcelable("key_orders", this.OsJ);
      ((Bundle)localObject).putParcelable("key_pay_info", this.mPayInfo);
      ((Bundle)localObject).putParcelable("key_authen", igm());
      ((Bundle)localObject).putString("key_pwd1", this.qgt);
      ((Bundle)localObject).putInt("key_pay_flag", 3);
      ((Bundle)localObject).putInt("key_err_code", -1004);
      ((Bundle)localObject).putParcelable("key_favor_pay_info", this.Vnj);
      ((Bundle)localObject).putBoolean("key_is_filter_bank_type", paramBoolean);
      if (this.Vbu != null) {
        ((Bundle)localObject).putString("key_is_cur_bankcard_bind_serial", this.Vbu.field_bindSerial);
      }
      bh((Bundle)localObject);
      AppMethodBeat.o(69455);
      return;
      i = this.mPayInfo.hUR;
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
      Hw(false);
    }
    AppMethodBeat.o(69466);
  }
  
  protected final void e(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69452);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
    com.tencent.mm.plugin.wallet.model.p.ifO();
    Log.d(str, com.tencent.mm.plugin.wallet.model.p.ifP().ijf() + ", need confirm ? " + paramBoolean);
    if (paramBoolean)
    {
      if (!Util.isNullOrNil(paramString)) {
        break label130;
      }
      paramString = Bankcard.be(this, paramInt);
    }
    label130:
    for (;;)
    {
      com.tencent.mm.ui.base.k.b(this, paramString, "", getString(a.i.wallet_pay_bankcard_add), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69398);
          WalletPayUI.this.igr();
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
      igr();
      AppMethodBeat.o(69452);
      return;
    }
  }
  
  protected final void f(boolean paramBoolean, final int paramInt, String paramString)
  {
    AppMethodBeat.i(69453);
    Log.d(this.TAG, "pay with select bankcard! need confirm ? ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (!Util.isNullOrNil(paramString)) {
        break label118;
      }
      paramString = Bankcard.be(this, paramInt);
    }
    label118:
    for (;;)
    {
      com.tencent.mm.ui.base.k.b(this, paramString, "", getString(a.i.wallet_pay_bankcard_select), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69401);
          if (WalletPayUI.m(WalletPayUI.this))
          {
            WalletPayUI.this.Hw(true);
            AppMethodBeat.o(69401);
            return;
          }
          WalletPayUI.this.ch(paramInt, false);
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
      if (ifS())
      {
        Hw(true);
        AppMethodBeat.o(69453);
        return;
      }
      ch(paramInt, false);
      AppMethodBeat.o(69453);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(69434);
    Log.i(this.TAG, "finish %s %s mPayResultType:%s", new Object[] { Integer.valueOf(hashCode()), Util.getStack().toString(), Integer.valueOf(this.mPayResultType) });
    cancelQRPay();
    if ((this.OsJ != null) && (!this.OsJ.VGX.isEmpty())) {
      getIntent().putExtra("key_trans_id", ((Orders.Commodity)this.OsJ.VGX.get(0)).hAU);
    }
    if (this.mPayInfo != null) {
      getIntent().putExtra("key_reqKey", this.mPayInfo.hAT);
    }
    if (this.isPaySuccess)
    {
      if (this.OsJ != null) {
        getIntent().putExtra("key_total_fee", this.OsJ.hAW);
      }
      getIntent().putExtra("key_pay_reslut_type", 1);
      p(-1, getIntent());
      setResult(-1, getIntent());
      localObject = getProcess();
      if ((localObject != null) && (this == ((com.tencent.mm.wallet_core.e)localObject).jOe()))
      {
        Log.i(this.TAG, "remove process end callback to prevent ui leak");
        ((com.tencent.mm.wallet_core.e)localObject).jOd();
      }
      super.finish();
      AppMethodBeat.o(69434);
      return;
    }
    if ((this.mPayInfo != null) && (this.mPayInfo.hUR == 8) && (this.OsJ != null))
    {
      this.mPayInfo.YvL = 0;
      doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.a(igm(), this.OsJ, true), false);
      if (this.mPayInfo.nKf != null)
      {
        long l = this.mPayInfo.nKf.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.OAn.b(13956, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    p(0, getIntent());
    getIntent().putExtra("key_pay_reslut_type", this.mPayResultType);
    label390:
    int i;
    if (this.VoG == 1)
    {
      getIntent().putExtra("key_pay_reslut_type", 1000);
      setResult(0, getIntent());
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijh()) {
        break label575;
      }
      if (this.mPayInfo != null) {
        break label552;
      }
      i = 0;
      label421:
      if (this.mPayInfo != null) {
        break label563;
      }
    }
    label552:
    label563:
    for (Object localObject = "";; localObject = this.mPayInfo.hAT)
    {
      ag.g(i, (String)localObject, 18, "");
      localObject = com.tencent.mm.wallet_core.a.bEC("PayProcess").iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.wallet_core.e locale = (com.tencent.mm.wallet_core.e)((Iterator)localObject).next();
        locale.P(new Object[] { "specEndProcessWithoutFinish" });
        if (locale.hPH != null) {
          locale.hPH.clear();
        }
        com.tencent.mm.wallet_core.a.remove(locale.getClass().hashCode());
        locale.ifR();
      }
      break;
      if (this.VoG != 2) {
        break label390;
      }
      getIntent().putExtra("key_pay_reslut_type", 1001);
      break label390;
      i = this.mPayInfo.hUR;
      break label421;
    }
    label575:
    com.tencent.mm.plugin.wallet.model.p.ifO();
    if (com.tencent.mm.plugin.wallet.model.p.ifP().ijg())
    {
      if (this.mPayInfo == null)
      {
        i = 0;
        label597:
        if (this.mPayInfo != null) {
          break label631;
        }
      }
      label631:
      for (localObject = "";; localObject = this.mPayInfo.hAT)
      {
        ag.g(i, (String)localObject, 4, "");
        break;
        i = this.mPayInfo.hUR;
        break label597;
      }
    }
    if (this.mPayInfo == null)
    {
      i = 0;
      label652:
      if (this.mPayInfo != null) {
        break label687;
      }
    }
    label687:
    for (localObject = "";; localObject = this.mPayInfo.hAT)
    {
      ag.g(i, (String)localObject, 7, "");
      break;
      i = this.mPayInfo.hUR;
      break label652;
    }
  }
  
  public final void g(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69472);
    Log.i(this.TAG, "onGenFinish callback");
    if (paramBoolean)
    {
      Log.i(this.TAG, "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.hMz = paramString1;
      this.mPayInfo.hMA = paramString2;
      Hx(false);
      com.tencent.mm.plugin.wallet_core.utils.m.imd();
      AppMethodBeat.o(69472);
      return;
    }
    Log.e(this.TAG, "onGenFinish callback, result.isSuccess is false");
    Hx(false);
    com.tencent.mm.plugin.wallet_core.utils.m.imd();
    AppMethodBeat.o(69472);
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
  
  protected final void igi()
  {
    int i = 2;
    AppMethodBeat.i(69432);
    com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(2), Integer.valueOf(this.mPayInfo.hUR) });
    if (this.mPayInfo.hUR == 11) {
      i = 3;
    }
    com.tencent.mm.plugin.wallet.pay.a.c.f localf = com.tencent.mm.plugin.wallet.pay.a.a.a(this.mPayInfo, i);
    if (localf != null)
    {
      localf.setProcessName("PayProcess");
      localf.setProcessSessionId(this.Vos);
      if ((this.mPayInfo.hUR != 6) || (this.mPayInfo.YvD != 100)) {
        break label139;
      }
      localf.setScene(100);
      if (!this.mPayInfo.YvE) {
        break label153;
      }
    }
    label139:
    label153:
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress(localf, true, bool);
      AppMethodBeat.o(69432);
      return;
      localf.setScene(this.mPayInfo.hUR);
      break;
    }
  }
  
  public final void igl()
  {
    AppMethodBeat.i(69442);
    j localj = this.VnX.bhb(this.Vnj.VFC);
    List localList = this.VnX.ikx();
    com.tencent.mm.plugin.wallet.model.h localh = this.VnX.VLs;
    Object localObject1 = "";
    double d2;
    Object localObject2;
    int i;
    double d1;
    if (localj != null)
    {
      d2 = localj.VlE;
      if (d2 > 0.0D)
      {
        localObject2 = localj.VlG;
        int j = 1;
        localObject1 = localObject2;
        i = j;
        d1 = d2;
        if (!Util.isNullOrNil(localj.VlH))
        {
          localObject1 = (String)localObject2 + "," + localj.VlH;
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
        if (localList != null)
        {
          localObject2 = localObject1;
          if (localList.size() > 0) {
            localObject2 = (String)localObject1 + getContext().getString(a.i.wallet_pwd_dialog_more_favors);
          }
        }
      }
      if ((d1 > 0.0D) && (localh != null) && (localh.VlA == 0))
      {
        if (localj != null) {
          this.Vog.setText(com.tencent.mm.wallet_core.ui.i.formatMoney2f(localj.VlD));
        }
        this.Voj.setText(com.tencent.mm.wallet_core.ui.i.bEL(this.OsJ.MEq));
        this.Voi.setText(com.tencent.mm.wallet_core.ui.i.e(this.OsJ.hAW, this.OsJ.MEq));
        this.Voi.setVisibility(0);
      }
      for (;;)
      {
        if (!Util.isNullOrNil((String)localObject2)) {
          this.Voo.setText((CharSequence)localObject2);
        }
        AppMethodBeat.o(69442);
        return;
        this.Vog.setText(com.tencent.mm.wallet_core.ui.i.formatMoney2f(this.OsJ.hAW));
        this.Voj.setText(com.tencent.mm.wallet_core.ui.i.bEL(this.OsJ.MEq));
        this.Voi.setVisibility(8);
      }
      i = 0;
      d1 = d2;
      continue;
      i = 0;
      d1 = 0.0D;
    }
  }
  
  protected final void igo()
  {
    AppMethodBeat.i(69445);
    Hv(true);
    AppMethodBeat.o(69445);
  }
  
  protected final void igr()
  {
    AppMethodBeat.i(69454);
    Bundle localBundle = getIntent().getExtras();
    com.tencent.mm.plugin.wallet.model.p.ifO();
    if (com.tencent.mm.plugin.wallet.model.p.ifP().ijf()) {}
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("key_pay_flag", i);
      localBundle.putParcelable("key_orders", this.OsJ);
      localBundle.putParcelable("key_pay_info", this.mPayInfo);
      localBundle.putParcelable("key_favor_pay_info", this.Vnj);
      bh(localBundle);
      AppMethodBeat.o(69454);
      return;
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(69438);
    aw.g(getWindow());
    MMScrollView localMMScrollView = (MMScrollView)findViewById(a.f.wallet_sv);
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.OrJ = ((Button)findViewById(a.f.wallet_pay_pay));
    this.OrJ.setClickable(false);
    this.OrJ.setEnabled(false);
    this.Vog = ((TextView)findViewById(a.f.wallet_order_info_total_fee));
    this.Voh = ((TextView)findViewById(a.f.wallet_order_info_total_desc));
    this.Voj = ((TextView)findViewById(a.f.wallet_order_info_fee_type));
    this.Voo = ((TextView)findViewById(a.f.wallet_order_info_favor));
    this.Voi = ((TextView)findViewById(a.f.wallet_order_info_origin_fee));
    this.Von = ((TextView)findViewById(a.f.wallet_pay_anti_trick_tips));
    this.Voi.getPaint().setFlags(16);
    this.Vok = ((TextView)findViewById(a.f.wallet_pay_tips));
    this.Vol = ((TextView)findViewById(a.f.wallet_pay_bind_bankcard));
    this.Vol.setOnClickListener(new ac()
    {
      public final void dsb()
      {
        AppMethodBeat.i(69416);
        WalletPayUI.this.e(false, 0, "");
        AppMethodBeat.o(69416);
      }
    });
    this.Vom = ((ImageView)findViewById(a.f.wallet_order_info_desc_more_btn));
    this.Vom.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69417);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (WalletPayUI.this.Vod) {
          WalletPayUI.this.Vom.setImageResource(a.e.pay_dital_bill_guid_down);
        }
        for (WalletPayUI.this.Vod = false;; WalletPayUI.this.Vod = true)
        {
          WalletPayUI.this.Voq.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69417);
          return;
          WalletPayUI.this.Vom.setImageResource(a.e.pay_dital_bill_guid_up);
        }
      }
    });
    this.Vop = ((LinearLayout)findViewById(a.f.wallet_order_info_lv));
    this.Voq = new a();
    this.OrJ.setOnClickListener(new ac()
    {
      public final void dsb()
      {
        AppMethodBeat.i(69418);
        com.tencent.mm.plugin.wallet.model.p.ifO();
        int i;
        if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijg())
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
        for (String str = "";; str = WalletPayUI.this.mPayInfo.hAT)
        {
          ag.g(i, str, 6, "");
          WalletPayUI.this.igo();
          WalletPayUI.this.Vof = true;
          AppMethodBeat.o(69418);
          return;
          i = WalletPayUI.this.mPayInfo.hUR;
          break;
        }
      }
    });
    this.OrJ.setText(a.i.wallet_pay);
    this.Vot = ((TextView)findViewById(a.f.payment_method_tips));
    this.Vou = ((LinearLayout)findViewById(a.f.payment_method_layout));
    updateView();
    AppMethodBeat.o(69438);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69464);
    if (this.VoB)
    {
      String str1 = this.TAG;
      boolean bool1;
      label87:
      String str2;
      int i;
      if ((getPayInfo() == null) || (!getPayInfo().egT))
      {
        bool1 = true;
        Log.i(str1, "case 1 %s,  stack %s", new Object[] { Boolean.valueOf(bool1), Util.getStack().toString() });
        str1 = this.TAG;
        com.tencent.mm.plugin.wallet.model.p.ifO();
        if (com.tencent.mm.plugin.wallet.model.p.ifP().ijf()) {
          break label196;
        }
        bool1 = true;
        Log.d(str1, "case 2 %s,", new Object[] { Boolean.valueOf(bool1) });
        str2 = this.TAG;
        if (this.Vbt != null) {
          break label201;
        }
        i = 0;
        label121:
        if (this.Vbu != null) {
          break label212;
        }
      }
      label196:
      label201:
      label212:
      for (str1 = "";; str1 = this.Vbu.field_forbidWord)
      {
        Log.d(str2, "case 3 mBankcardList %s, mDefaultBankcard %s", new Object[] { Integer.valueOf(i), str1 });
        if ((getPayInfo() != null) && (getPayInfo().egT)) {
          break label224;
        }
        Log.i(this.TAG, "get isTransparent1");
        AppMethodBeat.o(69464);
        return false;
        bool1 = false;
        break;
        bool1 = false;
        break label87;
        i = this.Vbt.size();
        break label121;
      }
      label224:
      if ((this.mPayInfo.hUR == 45) || (this.mPayInfo.hUR == 52))
      {
        Log.i(this.TAG, "lqt must be transparent");
        AppMethodBeat.o(69464);
        return true;
      }
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijf())
      {
        Log.i(this.TAG, "get isTransparent2");
        AppMethodBeat.o(69464);
        return false;
      }
      if ((this.Vbt != null) && ((this.Vbt.size() == 0) || ((this.Vbu != null) && (!Util.isNullOrNil(this.Vbu.field_forbidWord)))))
      {
        str1 = this.TAG;
        if ((this.Vbt != null) && (this.Vbt.size() == 0))
        {
          bool1 = true;
          if ((this.Vbu == null) || (Util.isNullOrNil(this.Vbu.field_forbidWord))) {
            break label420;
          }
        }
        label420:
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
          this.VoA = paramIntent.getIntExtra("auto_deduct_flag", -1);
          if ((this.OsJ != null) && (this.OsJ.VHc != null)) {
            this.OsJ.VHc.VoA = this.VoA;
          }
          getPayInfo().YvI = this.VoA;
          if (this.VoA == 1)
          {
            getPayInfo().YvJ = paramIntent.getStringExtra("deduct_bank_type");
            getPayInfo().YvK = paramIntent.getStringExtra("deduct_bind_serial");
          }
        }
        this.Voz = true;
        onProgressFinish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(13958, new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(69462);
        return;
        finish();
      }
      this.Vor.dismiss();
      this.Vof = false;
      igi();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69429);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.TAG = ("MicroMsg.WalletPayUI@" + hashCode());
    if (VnU)
    {
      Log.w(this.TAG, "has Undestory WalletPayUI!");
      com.tencent.mm.plugin.report.service.h.OAn.p(965L, 1L, 1L);
      arV(2);
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    VnU = true;
    long l = System.currentTimeMillis();
    int j = getIntent().getIntExtra("key_context_hashcode", -1);
    paramBundle = new b[VnV.size()];
    Log.i(this.TAG, "WalletPayUI check %s this %s fromHashCode %s", new Object[] { Integer.valueOf(VnV.size()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
    paramBundle = (b[])VnV.toArray(paramBundle);
    int k = paramBundle.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = paramBundle[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localObject.tey.get();
      if (localWalletPayUI != null)
      {
        Log.w(this.TAG, "has old payui, both finish %s", new Object[] { Integer.valueOf(localWalletPayUI.hashCode()) });
        if ((j != localObject.cHb) || (j == -1)) {
          break label290;
        }
        localWalletPayUI.arV(2);
        com.tencent.mm.plugin.report.service.h.OAn.p(965L, 41L, 1L);
      }
      for (;;)
      {
        VnV.remove(localObject);
        localWalletPayUI.finish();
        i += 1;
        break;
        label290:
        localWalletPayUI.arV(1);
        com.tencent.mm.plugin.report.service.h.OAn.p(965L, 40L, 1L);
      }
    }
    this.VoI = new b((byte)0);
    this.VoI.timestamp = l;
    this.VoI.cHb = j;
    this.VoI.tey = new WeakReference(this);
    VnV.add(this.VoI);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e(this.TAG, "hy: account not ready. finish now");
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    getWindow().getDecorView().postDelayed(this.VoH, 5000L);
    this.VoJ = Util.nowMilliSecond();
    this.CUH.alive();
    com.tencent.mm.plugin.wallet_core.model.k.asj(5);
    this.OlE = com.tencent.mm.plugin.wallet.a.bE(getIntent());
    setMMTitle(a.i.wallet_pay_ui_title);
    this.mPayInfo = getPayInfo();
    this.Vob = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
    this.Voc = Util.nullAs(getIntent().getStringExtra("key_force_use_bind_serail"), "");
    this.Ome = getIntent().getStringExtra("key_receiver_true_name");
    if ((this.mPayInfo == null) || (this.mPayInfo.YvH == 0L))
    {
      this.Vos = System.currentTimeMillis();
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijf())
      {
        if (this.mPayInfo != null) {
          break label679;
        }
        i = 0;
        label555:
        if (this.mPayInfo != null) {
          break label690;
        }
        paramBundle = "";
        label565:
        ag.g(i, paramBundle, 1, "");
      }
      if (igh()) {
        break label759;
      }
      Log.d(this.TAG, "PayInfo = " + this.mPayInfo);
      if ((this.mPayInfo == null) || (Util.isNullOrNil(this.mPayInfo.hAT))) {
        break label701;
      }
      igi();
      com.tencent.mm.plugin.secinforeport.a.d.Pmb.asyncReportPaySecurityInfoThroughCgi();
      initView();
    }
    for (;;)
    {
      if (this.mPayInfo != null) {
        com.tencent.mm.plugin.wallet.pay.a.b.bgg(this.mPayInfo.YvN);
      }
      AppMethodBeat.o(69429);
      return;
      this.Vos = this.mPayInfo.YvH;
      break;
      label679:
      i = this.mPayInfo.hUR;
      break label555;
      label690:
      paramBundle = this.mPayInfo.hAT;
      break label565;
      label701:
      if ((this.mPayInfo != null) && (!Util.isNullOrNil(this.mPayInfo.errMsg))) {}
      for (paramBundle = this.mPayInfo.errMsg;; paramBundle = getString(a.i.wallet_pay_orders_illegal))
      {
        com.tencent.mm.ui.base.k.a(this, paramBundle, null, false, new DialogInterface.OnClickListener()
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
      label759:
      Log.i(this.TAG, "hy: pay end on create. finish");
      finish();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69431);
    if (this.Vnk != null)
    {
      this.Vnk.closeTipDialog();
      this.Vnk.release();
    }
    this.CUH.dead();
    this.Vnl = null;
    getWindow().getDecorView().removeCallbacks(this.VoH);
    VnV.remove(this.VoI);
    VnU = false;
    long l = System.currentTimeMillis();
    b[] arrayOfb = new b[VnV.size()];
    arrayOfb = (b[])VnV.toArray(arrayOfb);
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localb.tey.get();
      if ((localWalletPayUI != null) && (l - localb.timestamp > 600000L))
      {
        Log.w(this.TAG, "has old payui, both finish");
        com.tencent.mm.plugin.report.service.h.OAn.p(965L, 2L, 1L);
        VnV.remove(localb);
        localWalletPayUI.arV(1);
        localWalletPayUI.finish();
      }
      i += 1;
    }
    if (this.mPayInfo != null) {
      com.tencent.mm.plugin.wallet.pay.a.b.bgh(this.mPayInfo.YvN);
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
      if ((this.Vor != null) && (this.mPayInfo != null) && (this.mPayInfo.egT) && (!this.mNetSceneMgr.isProcessing())) {
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
    if (!igh())
    {
      Log.w(this.TAG, "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
      if (paramIntent.getBooleanExtra("send_cancel_event", true)) {
        p(0, getIntent());
      }
      this.isPaySuccess = false;
    }
    if (paramIntent.getBooleanExtra("direc_change_bankcard", false))
    {
      Hw(true);
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false))) {
      this.Vow = true;
    }
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(this.TAG, "isFromBindCard is true");
      igi();
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_is_realname_verify_process", false)))
    {
      this.Vox = true;
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
    if (this.Vnl != null) {
      this.Vnl.onActivityPause();
    }
    AppMethodBeat.o(69473);
  }
  
  public boolean onProgressFinish()
  {
    boolean bool2 = false;
    AppMethodBeat.i(69463);
    Log.i(this.TAG, "onProgressFinish isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.VoE) });
    new act().publish();
    int i;
    int j;
    label90:
    Object localObject;
    label101:
    boolean bool1;
    if ((this.OsJ != null) && (this.OsJ.VHc != null) && (!this.Voz))
    {
      i = 1;
      if ((i == 0) && (!igt()))
      {
        if (this.mPayInfo != null) {
          break label137;
        }
        j = 0;
        if (this.mPayInfo != null) {
          break label148;
        }
        localObject = "";
        ag.g(j, (String)localObject, 2, "");
      }
      if (!this.VoE) {
        break label160;
      }
      Hv(true);
      bool1 = true;
    }
    for (;;)
    {
      AppMethodBeat.o(69463);
      return bool1;
      i = 0;
      break;
      label137:
      j = this.mPayInfo.hUR;
      break label90;
      label148:
      localObject = this.mPayInfo.hAT;
      break label101;
      label160:
      if (this.Voy)
      {
        bool1 = true;
      }
      else if (i != 0)
      {
        localObject = new Intent(this, WalletPayDeductUI.class);
        ((Intent)localObject).putExtra("orders", this.OsJ);
        startActivityForResult((Intent)localObject, 0);
        bool1 = true;
      }
      else if (getContentView().getVisibility() != 0)
      {
        if ((!this.Vof) && (bZk()))
        {
          Hv(true);
          this.Vof = true;
        }
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (getContentView().getVisibility() == 0)
        {
          bool1 = bool2;
          if (this.OsJ != null)
          {
            bool1 = bool2;
            if (this.OsJ.VHc != null)
            {
              bool1 = bool2;
              if (this.OrJ.isEnabled())
              {
                bool1 = bool2;
                if (!this.VoC)
                {
                  this.OrJ.performClick();
                  this.VoC = true;
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
    Log.i(this.TAG, "hy: onResume isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.VoE) });
    if (!isProcessing())
    {
      if (!Util.isNullOrNil(this.Voc)) {
        this.Vbu = igs();
      }
    }
    else
    {
      if (!this.VoF) {
        break label149;
      }
      Log.i(this.TAG, "onResume isResumePassFinish");
      this.VoF = false;
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(69433);
      return;
      if (this.Vbu == null)
      {
        com.tencent.mm.plugin.wallet.model.p.ifO();
        this.Vbu = com.tencent.mm.plugin.wallet.model.p.ifP().a(null, null, ifZ(), false);
        break;
      }
      com.tencent.mm.plugin.wallet.model.p.ifO();
      this.Vbu = com.tencent.mm.plugin.wallet.model.p.ifP().a(null, this.Vbu.field_bindSerial, ifZ(), false);
      break;
      label149:
      if ((this.VnZ) && (getContentViewVisibility() != 0) && ((this.Vor == null) || (!this.Vor.isShowing())))
      {
        Log.i(this.TAG, "hy: has started process and is transparent and no pwd appeared. finish self");
        finish();
      }
      else if (this.Vnl != null)
      {
        this.Vnl.onActivityResume();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(69457);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp, paramBoolean);
    if ((paramp instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
      setAuthState(false);
    }
    AppMethodBeat.o(69457);
  }
  
  public boolean onSceneEnd(int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(69458);
    Log.i(this.TAG, "errorType %s errCode %s, errmsg %s, scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp });
    boolean bool;
    Object localObject1;
    label310:
    label345:
    label505:
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof com.tencent.mm.plugin.wallet.pay.a.c.f))
      {
        this.mPayResultType = 1;
        this.VnW = ((com.tencent.mm.plugin.wallet.pay.a.c.f)paramp);
        paramString = (com.tencent.mm.plugin.wallet.pay.a.c.f)paramp;
        if (paramString.isJumpRemind())
        {
          paramp = paramString.getJumpRemind();
          paramp.jOK();
          if (paramp.a(this, new com.tencent.mm.wallet_core.model.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(69403);
              if (paramp.jOJ())
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
              if (paramp.jOJ())
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
              if (paramp.jOJ())
              {
                WalletPayUI.a(WalletPayUI.this, paramString);
                AppMethodBeat.o(69404);
                return;
              }
              WalletPayUI.this.igi();
              AppMethodBeat.o(69404);
            }
          }))
          {
            AppMethodBeat.o(69458);
            return true;
          }
        }
        a(paramString);
      }
      while (!(paramp instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        updateView();
        AppMethodBeat.o(69458);
        return true;
      }
      this.mPayResultType = 1;
      paramp = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramp;
      paramString = getInput();
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putParcelable("key_bankcard", this.Vbu);
      paramString.putString("key_bank_type", this.Vbu.field_bankcardType);
      if (!Util.isNullOrNil(this.qgt)) {
        paramString.putString("key_pwd1", this.qgt);
      }
      paramString.putString("kreq_token", paramp.getToken());
      paramString.putParcelable("key_authen", paramp.VmM);
      if (!paramp.VmK)
      {
        bool = true;
        paramString.putBoolean("key_need_verify_sms", bool);
        paramString.putInt("key_can_verify_tail", paramp.VmQ);
        paramString.putString("key_verify_tail_wording", paramp.VmR);
        localObject1 = getInput();
        if (paramp.VmS != 1) {
          break label630;
        }
        bool = true;
        ((Bundle)localObject1).putBoolean("key_block_bind_new_card", bool);
        if (!Util.isNullOrNil(paramp.VmN)) {
          break label636;
        }
        paramString.putString("key_mobile", this.Vbu.field_mobile);
        paramString.putString("key_QADNA_URL", paramp.VmO);
        if (!paramp.isPaySuccess) {
          break label651;
        }
        if (this.OlE != null)
        {
          this.OlE.dx(10003, "");
          localObject1 = this.OlE;
          com.tencent.mm.plugin.report.service.h.OAn.b(13455, new Object[] { ((com.tencent.mm.plugin.wallet.a)localObject1).UYV, Long.valueOf(System.currentTimeMillis()), ((com.tencent.mm.plugin.wallet.a)localObject1).UYW });
        }
        paramString.putParcelable("key_orders", paramp.VmL);
        if (this.mPayInfo != null)
        {
          Log.i(this.TAG, "payscene %d", new Object[] { Integer.valueOf(this.mPayInfo.hUR) });
          if (8 == this.mPayInfo.hUR)
          {
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acOf, Boolean.TRUE);
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("pwd", this.qgt);
        localObject2 = (com.tencent.mm.plugin.fingerprint.mgr.a.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.mgr.a.i.class);
        paramInt1 = 0;
        if (!((com.tencent.mm.plugin.fingerprint.mgr.a.i)localObject2).ftP()) {
          break label665;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
        ((com.tencent.mm.plugin.fingerprint.mgr.a.i)localObject2).a(paramp.ifU(), true, this.mPayInfo.VGV, (Bundle)localObject1);
        paramString.putInt("key_pay_flag", 3);
        paramp = paramp.MyJ;
        if (paramp != null) {
          paramString.putParcelable("key_realname_guide_helper", paramp);
        }
        bh(paramString);
        AppMethodBeat.o(69458);
        return true;
        bool = false;
        break;
        label630:
        bool = false;
        break label310;
        label636:
        paramString.putString("key_mobile", paramp.VmN);
        break label345;
        label651:
        paramString.putParcelable("key_orders", this.OsJ);
        break label505;
        label665:
        if (((com.tencent.mm.plugin.fingerprint.mgr.a.i)localObject2).ftQ()) {
          paramInt1 = 2;
        }
      }
    }
    if ((paramp instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("pwd", this.qgt);
      localObject2 = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
      if (this.mPayInfo.VSv == 1)
      {
        bool = true;
        label734:
        ((com.tencent.mm.plugin.fingerprint.c.a)localObject2).a(bool, false, (Bundle)localObject1);
        if ((paramInt2 != -1) && (paramInt2 != -500)) {
          break label862;
        }
      }
      label862:
      for (this.mPayResultType = 3;; this.mPayResultType = 2) {
        switch (paramInt2)
        {
        default: 
          AppMethodBeat.o(69458);
          return false;
          bool = false;
          break label734;
        }
      }
      paramp = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramp;
      this.Voe = getInput();
      this.Voe.putParcelable("key_pay_info", this.mPayInfo);
      this.Voe.putParcelable("key_bankcard", this.Vbu);
      if (!Util.isNullOrNil(this.qgt)) {
        this.Voe.putString("key_pwd1", this.qgt);
      }
      this.Voe.putString("kreq_token", paramp.getToken());
      this.Voe.putParcelable("key_authen", paramp.VmM);
      localObject1 = this.Voe;
      if (!paramp.VmK)
      {
        bool = true;
        label984:
        ((Bundle)localObject1).putBoolean("key_need_verify_sms", bool);
        this.Voe.putString("key_mobile", this.Vbu.field_mobile);
        this.Voe.putInt("key_err_code", paramInt2);
        this.Voe.putParcelable("key_orders", this.OsJ);
        if (!Util.isNullOrNil(paramString)) {
          break label1512;
        }
        paramString = getString(a.i.wallet_pay_reset_info_tips, new Object[] { this.Vbu.field_desc, this.Vbu.field_mobile });
      }
    }
    label1512:
    for (;;)
    {
      com.tencent.mm.ui.base.k.b(this, paramString, "", getString(a.i.wallet_pay_reset_info), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69406);
          WalletPayUI.this.Voe.putInt("key_pay_flag", 3);
          WalletPayUI.this.bh(WalletPayUI.this.Voe);
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
      break label984;
      this.mPayInfo.YvG = paramInt2;
      Hw(false);
      AppMethodBeat.o(69458);
      return true;
      this.mPayInfo.YvG = paramInt2;
      bool = false;
      if (paramInt2 == 100100) {
        bool = true;
      }
      if (this.Vnk == null) {
        this.Vnk = new a(this, this);
      }
      this.Vnk.d(bool, this.mPayInfo.hMx, this.mPayInfo.hAT);
      Log.i(this.TAG, "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool)));
      AppMethodBeat.o(69458);
      return true;
      if ((this.Vbu == null) || (this.OsJ == null)) {
        break;
      }
      this.Vbu.VDn = this.OsJ.hAT;
      if ((this.mPayInfo != null) && ((this.mPayInfo.hUR == 45) || (this.mPayInfo.hUR == 52))) {
        com.tencent.mm.ui.base.k.a(getContext(), paramString, "", getString(a.i.app_ok), new DialogInterface.OnClickListener()
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
        if ((this.Vbt != null) && (this.Vbt.size() > 1)) {
          f(true, 4, paramString);
        } else {
          e(true, 4, paramString);
        }
      }
      if (!(paramp instanceof com.tencent.mm.plugin.wallet.pay.a.c.f)) {
        break;
      }
      this.VoB = true;
      igt();
      if (paramInt2 == 416)
      {
        Log.e(this.TAG, "errCode is 416 need real name verify!");
        this.mPayResultType = 2;
        this.Voy = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
        paramString.putString("realname_verify_process_jump_plugin", "wallet");
        if (this.mPayInfo != null) {}
        for (paramInt1 = this.mPayInfo.hUR;; paramInt1 = 0)
        {
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramp, paramString, paramInt1);
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
  
  protected final class a
  {
    protected a() {}
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(69426);
      WalletPayUI.this.Vop.removeAllViews();
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
        localCommodity = (Orders.Commodity)WalletPayUI.this.OsJ.VGX.get(j);
        str2 = "";
        str1 = str2;
        if (WalletPayUI.this.mPayInfo != null) {
          if ((WalletPayUI.this.mPayInfo.hUR != 32) && (WalletPayUI.this.mPayInfo.hUR != 33) && (WalletPayUI.this.mPayInfo.hUR != 31))
          {
            str1 = str2;
            if (WalletPayUI.this.mPayInfo.hUR != 48) {}
          }
          else
          {
            str1 = WalletPayUI.this.mPayInfo.nKf.getString("extinfo_key_1", "");
            if (Util.isNullOrNil(str1)) {
              break label448;
            }
            com.tencent.mm.kernel.h.baF();
            au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(str1);
            if (localau == null) {
              break label423;
            }
            str1 = localau.aSV();
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
          if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(localCommodity.MEf))) {
            break label563;
          }
          localView.setVisibility(0);
        }
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        localView.measure(-2, -2);
        WalletPayUI.this.Vop.addView(localView);
        j += 1;
        break label41;
        if (WalletPayUI.this.Vod)
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
        if (!Util.isNullOrNil(localCommodity.MEf))
        {
          localTextView2.setText(localCommodity.MEf);
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
    int cHb;
    WeakReference<WalletPayUI> tey;
    long timestamp;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
 * JD-Core Version:    0.7.0.1
 */