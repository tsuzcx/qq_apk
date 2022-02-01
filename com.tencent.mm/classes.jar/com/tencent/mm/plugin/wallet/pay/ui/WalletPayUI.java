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
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.g.a.xu;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.xv.a;
import com.tencent.mm.g.a.yd;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.aj;
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
  private static boolean Bjh;
  private static List<b> Bji;
  protected ArrayList<Bankcard> AYt;
  protected Bankcard AYu;
  private boolean BiA;
  private com.tencent.mm.plugin.wallet.pay.a.d Bil;
  public FavorPayInfo Bix;
  private a Biy;
  com.tencent.mm.plugin.wallet_core.ui.f Biz;
  private TextView BjA;
  private TextView BjB;
  protected LinearLayout BjC;
  protected a BjD;
  public Dialog BjE;
  private long BjF;
  private TextView BjG;
  private LinearLayout BjH;
  private boolean BjI;
  private boolean BjJ;
  private boolean BjK;
  private boolean BjL;
  private boolean BjM;
  private int BjN;
  private boolean BjO;
  private boolean BjP;
  private com.tencent.mm.plugin.wallet.pay.a.c.f BjQ;
  private boolean BjR;
  private boolean BjS;
  private int BjT;
  private Runnable BjU;
  private b BjV;
  private long BjW;
  private com.tencent.mm.plugin.wallet.pay.a.c.f Bjj;
  protected com.tencent.mm.plugin.wallet_core.ui.d Bjk;
  private boolean Bjl;
  protected boolean Bjm;
  private d.a Bjn;
  protected boolean Bjo;
  protected String Bjp;
  protected boolean Bjq;
  public Bundle Bjr;
  protected boolean Bjs;
  protected TextView Bjt;
  protected TextView Bju;
  private TextView Bjv;
  protected TextView Bjw;
  protected TextView Bjx;
  protected TextView Bjy;
  protected ImageView Bjz;
  public String TAG;
  public String iXf;
  private boolean isPaySuccess;
  protected int mCount;
  protected PayInfo mPayInfo;
  private String wMX;
  protected com.tencent.mm.plugin.wallet.a wMw;
  private com.tencent.mm.sdk.b.c wPR;
  protected Button wRL;
  protected Orders wSu;
  
  static
  {
    AppMethodBeat.i(69482);
    Bjh = false;
    Bji = new ArrayList();
    AppMethodBeat.o(69482);
  }
  
  public WalletPayUI()
  {
    AppMethodBeat.i(69427);
    this.TAG = "MicroMsg.WalletPayUI";
    this.wSu = null;
    this.Bjj = null;
    this.mCount = 0;
    this.iXf = null;
    this.AYt = null;
    this.AYu = null;
    this.Bix = null;
    this.Bjk = null;
    this.Bjl = false;
    this.isPaySuccess = false;
    this.Bjm = false;
    this.Bjo = false;
    this.Bjp = "";
    this.mPayInfo = null;
    this.Bjq = false;
    this.Bjr = null;
    this.Bjs = false;
    this.BjF = 0L;
    this.BjI = true;
    this.BjJ = false;
    this.BjK = false;
    this.BjL = false;
    this.BjM = false;
    this.BjN = -1;
    this.BjO = false;
    this.BjP = false;
    this.wMw = null;
    this.BjR = false;
    this.BjS = false;
    this.Bil = null;
    this.BjT = 0;
    this.BjU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69386);
        ac.i(WalletPayUI.this.TAG, "auto reset create flag");
        WalletPayUI.adZ();
        AppMethodBeat.o(69386);
      }
    };
    this.BjW = 0L;
    this.wPR = new com.tencent.mm.sdk.b.c() {};
    this.BiA = false;
    AppMethodBeat.o(69427);
  }
  
  private void Tx(int paramInt)
  {
    AppMethodBeat.i(69428);
    this.BjT = paramInt;
    ac.i(this.TAG, "markForceFinish errorType %s %s", new Object[] { Integer.valueOf(paramInt), bs.eWi().toString() });
    AppMethodBeat.o(69428);
  }
  
  private void a(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    AppMethodBeat.i(69456);
    ac.i(this.TAG, "stopRealname realnameGuideFlag %s guide_type %s", new Object[] { paramf.dAF, Integer.valueOf(paramf.Bik) });
    label109:
    Object localObject;
    label150:
    int j;
    if (("1".equals(paramf.dAF)) || ("2".equals(paramf.dAF)))
    {
      this.BjQ = paramf;
      this.Bil = paramf.Bil;
      this.BjO = true;
      this.wSu = paramf.wSu;
      if (this.wSu == null) {
        break label523;
      }
      i = this.wSu.BxR.size();
      this.mCount = i;
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("get mOrders! bankcardTag : ");
      if (this.wSu == null) {
        break label528;
      }
      paramf = Integer.valueOf(this.wSu.BoU);
      ac.d((String)localObject, paramf);
      aRK();
      if ((this.wSu != null) && (this.wSu.BxS != null))
      {
        this.Bjk = com.tencent.mm.plugin.wallet_core.ui.e.BBL.a(this.wSu);
        if (this.Bjk != null)
        {
          if (this.Bjk.etg().size() > 0) {
            this.Bjl = true;
          }
          this.Bix = this.Bjk.azH(this.wSu.BxS.BgL);
          this.Bix.Bwv = this.Bjk.azI(this.Bix.Bwv);
          ac.i(this.TAG, "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", new Object[] { this.wSu.BxS.BgL, this.Bix.Bwv, this.Bix.Bwv, this.Bix.toString() });
        }
      }
      if ((this.wSu != null) && (this.AYt != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.wSu);
        paramf = com.tencent.mm.plugin.report.service.h.wUl;
        j = this.mPayInfo.dqL;
        com.tencent.mm.plugin.wallet.a.s.epp();
        if (!com.tencent.mm.plugin.wallet.a.s.epq().esa()) {
          break label534;
        }
      }
    }
    label523:
    label528:
    label534:
    for (int i = 2;; i = 1)
    {
      paramf.f(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.wSu.daf * 100.0D)), this.wSu.vxl });
      if ((this.wSu == null) || (this.wSu.BxR == null)) {
        break label598;
      }
      paramf = new LinkedList();
      localObject = this.wSu.BxR.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramf.add(((Orders.Commodity)((Iterator)localObject).next()).dad);
      }
      this.BjQ = null;
      break;
      i = 0;
      break label109;
      paramf = "";
      break label150;
    }
    if (paramf.size() > 0)
    {
      localObject = new xu();
      ((xu)localObject).dBh.dBj = paramf;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.wMw != null) {
        this.wMw.ch(10001, (String)paramf.get(0));
      }
    }
    label598:
    if ((this.wSu != null) && (this.wSu.Byp != null) && (this.wSu.Byp.Bzm == 1) && (!bs.isNullOrNil(this.wSu.Byp.vwo)))
    {
      this.Bjo = true;
      this.Bjp = this.wSu.Byp.vwo;
    }
    com.tencent.mm.plugin.wallet.a.s.epp();
    this.AYt = com.tencent.mm.plugin.wallet.a.s.epq().tE(epU());
    if (!bs.isNullOrNil(this.Bjp))
    {
      this.AYu = epR();
      paramf = bs.bG(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!bs.isNullOrNil(paramf)) {
        this.AYu = ayZ(paramf);
      }
      this.wRL.setClickable(true);
      if (bs.isNullOrNil(com.tencent.mm.plugin.wallet_core.model.s.ery().BAQ)) {
        break label1031;
      }
      this.BjA.setVisibility(0);
      this.BjA.setText(com.tencent.mm.plugin.wallet_core.model.s.ery().BAQ);
      label773:
      if ((this.wSu != null) && (this.AYt != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.wSu);
        paramf = com.tencent.mm.plugin.report.service.h.wUl;
        j = this.mPayInfo.dqL;
        com.tencent.mm.plugin.wallet.a.s.epp();
        if (!com.tencent.mm.plugin.wallet.a.s.epq().esa()) {
          break label1052;
        }
        i = 2;
        label832:
        paramf.f(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.wSu.daf * 100.0D)), this.wSu.vxl });
      }
      if (this.BjJ) {
        aJ(0, false);
      }
      if (getPayInfo().hbR != null) {
        break label1057;
      }
    }
    label1031:
    label1052:
    label1057:
    for (long l = 0L;; l = getPayInfo().hbR.getLong("wallet_pay_key_check_time"))
    {
      if (l > 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(641L, 4L, 1L, true);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(641L, 5L, bs.Ap(l), true);
      }
      if (this.BjW > 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(641L, 7L, 1L, true);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(641L, 8L, bs.Ap(this.BjW), true);
      }
      AppMethodBeat.o(69456);
      return;
      com.tencent.mm.plugin.wallet.a.s.epp();
      this.AYu = com.tencent.mm.plugin.wallet.a.s.epq().a(null, null, epU(), false);
      break;
      this.BjA.setVisibility(8);
      this.BjA.setText("");
      break label773;
      i = 1;
      break label832;
    }
  }
  
  private Bankcard ayZ(String paramString)
  {
    AppMethodBeat.i(69461);
    com.tencent.mm.plugin.wallet.a.s.epp();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.epq().tD(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (bs.nullAsNil(paramString).equals(localBankcard.field_bindSerial))
        {
          ac.i(this.TAG, "hy: get given bankcard");
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
    if ("1".equals(paramf.dAF))
    {
      ac.i(this.TAG, "need realname verify");
      this.BjL = true;
      paramf = new Bundle();
      paramf.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
      paramf.putString("realname_verify_process_jump_plugin", "wallet");
      isTransparent();
      if (this.mPayInfo != null) {
        i = this.mPayInfo.dqL;
      }
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf, null, i);
      AppMethodBeat.o(69474);
      return bool;
    }
    if ("2".equals(paramf.dAF))
    {
      ac.i(this.TAG, "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf.dAG, paramf.dAJ, paramf.dAH, paramf.dAI, isTransparent(), null);
      AppMethodBeat.o(69474);
      return bool;
    }
    ac.i(this.TAG, "realnameGuideFlag =  " + paramf.dAF);
    AppMethodBeat.o(69474);
    return false;
  }
  
  private boolean epG()
  {
    AppMethodBeat.i(69430);
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("intent_pay_end")))
    {
      ac.i(this.TAG, "hy: pay end. finish the activity");
      if (localBundle.getBoolean("intent_pay_end", false))
      {
        ac.d(this.TAG, "pay done... errCode:" + localBundle.getInt("intent_pay_end_errcode"));
        ac.d(this.TAG, "pay done INTENT_PAY_APP_URL:" + localBundle.getString("intent_pay_app_url"));
        ac.d(this.TAG, "pay done INTENT_PAY_END:" + localBundle.getBoolean("intent_pay_end", false));
        m(-1, getIntent());
      }
      for (this.isPaySuccess = true;; this.isPaySuccess = false)
      {
        AppMethodBeat.o(69430);
        return true;
        ac.d(this.TAG, "pay cancel");
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
    ac.i(this.TAG, "hy: pay not end");
    AppMethodBeat.o(69430);
    return false;
  }
  
  private void epI()
  {
    AppMethodBeat.i(69440);
    if (this.wSu == null)
    {
      ac.e(this.TAG, "updatePaymentMethodForFavor mOrders is null");
      AppMethodBeat.o(69440);
      return;
    }
    this.Bjy.setVisibility(8);
    this.Bjx.setVisibility(8);
    this.wRL.setText(2131765657);
    this.BjG.setVisibility(0);
    this.BjH.setVisibility(0);
    View localView = this.BjH.findViewById(2131297100);
    Object localObject = this.BjH.findViewById(2131296454);
    final CheckedTextView localCheckedTextView1;
    final CheckedTextView localCheckedTextView2;
    int i;
    if ("CFT".equals(this.wSu.BxM))
    {
      ((View)localObject).setVisibility(8);
      localCheckedTextView1 = (CheckedTextView)this.BjH.findViewById(2131297092);
      localCheckedTextView2 = (CheckedTextView)this.BjH.findViewById(2131296453);
      localView.setEnabled(true);
      if ((this.wSu == null) || (this.wSu.BxR == null) || (this.wSu.BxR.size() <= 0)) {
        break label772;
      }
      if (this.wSu.BxB != 1) {
        break label574;
      }
      i = 1;
    }
    label772:
    for (;;)
    {
      label200:
      if (this.AYu == null)
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
        this.BjG.setVisibility(0);
        this.BjH.setVisibility(0);
        if (this.Bix == null) {
          break label767;
        }
        this.Bjk = com.tencent.mm.plugin.wallet_core.ui.e.BBL.a(this.wSu);
        localObject = this.Bjk.azE(this.Bix.Bwv);
        if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).BgK != 0.0D)) {
          break label767;
        }
        this.BjH.setVisibility(8);
        this.BjG.setVisibility(8);
      }
      label486:
      label767:
      for (int j = 1;; j = 0)
      {
        this.BjI = true;
        if (j != 0) {
          this.BjI = false;
        }
        localCheckedTextView1.setChecked(false);
        localCheckedTextView2.setChecked(true);
        ac.i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.wSu.BxT);
        if (this.wSu.BxT == 1)
        {
          this.BjH.findViewById(2131299147).setVisibility(0);
          ((TextView)this.BjH.findViewById(2131299146)).setText(this.wSu.BxU);
          if (!TextUtils.isEmpty(this.wSu.BxV))
          {
            ((TextView)this.BjH.findViewById(2131299862)).setText(" (" + this.wSu.BxV + ")");
            if ((this.AYu != null) && (this.AYu.eqR()) && (!TextUtils.isEmpty(this.AYu.field_forbidWord)))
            {
              localView.setEnabled(false);
              localCheckedTextView1.setVisibility(8);
              ((TextView)this.BjH.findViewById(2131297107)).setText(this.AYu.field_forbidWord);
            }
          }
        }
        for (;;)
        {
          epJ();
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
          ((TextView)this.BjH.findViewById(2131299862)).setText("");
          break label486;
          this.BjH.findViewById(2131299147).setVisibility(8);
          if ((this.AYu != null) && (this.AYu.eqR()) && (!TextUtils.isEmpty(this.AYu.field_forbidWord)))
          {
            localView.setEnabled(false);
            localCheckedTextView1.setVisibility(8);
            ((TextView)this.BjH.findViewById(2131297107)).setText(this.AYu.field_forbidWord);
          }
          else if ((this.AYu != null) && (this.AYu.eqR()) && (TextUtils.isEmpty(this.AYu.field_forbidWord)) && (i == 0))
          {
            localCheckedTextView1.setChecked(true);
            localCheckedTextView2.setChecked(false);
            this.BjI = false;
          }
        }
      }
      label574:
      i = 0;
    }
  }
  
  private void epJ()
  {
    AppMethodBeat.i(69441);
    if (this.BjI)
    {
      this.wRL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int j = 0;
          AppMethodBeat.i(69387);
          com.tencent.mm.plugin.wallet.a.s.epp();
          int i;
          if (com.tencent.mm.plugin.wallet.a.s.epq().esb())
          {
            if (WalletPayUI.this.mPayInfo == null)
            {
              i = 0;
              if (WalletPayUI.this.mPayInfo != null) {
                break label141;
              }
              paramAnonymousView = "";
              label45:
              af.f(i, paramAnonymousView, 6, "");
            }
          }
          else
          {
            if (WalletPayUI.this.wSu.BxT != 1) {
              break label183;
            }
            com.tencent.mm.plugin.wallet.a.s.epp();
            if (com.tencent.mm.plugin.wallet.a.s.epq().esb())
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
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dac)
          {
            af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.f(WalletPayUI.this);
            AppMethodBeat.o(69387);
            return;
            i = WalletPayUI.this.mPayInfo.dqL;
            break;
            paramAnonymousView = WalletPayUI.this.mPayInfo.dac;
            break label45;
            i = WalletPayUI.this.mPayInfo.dqL;
            break label93;
          }
          label183:
          ac.i(WalletPayUI.this.TAG, "SimpleReg , assigned userinfo pay! payWithNewBankcard");
          com.tencent.mm.plugin.wallet.a.s.epp();
          if (com.tencent.mm.plugin.wallet.a.s.epq().esb())
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
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dac)
          {
            af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.this.c(false, 0, "");
            AppMethodBeat.o(69387);
            return;
            i = WalletPayUI.this.mPayInfo.dqL;
            break;
          }
        }
      });
      AppMethodBeat.o(69441);
      return;
    }
    this.wRL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69388);
        WalletPayUI.this.epN();
        AppMethodBeat.o(69388);
      }
    });
    AppMethodBeat.o(69441);
  }
  
  private void epO()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(69447);
    com.tencent.mm.plugin.report.service.h.wUl.f(13958, new Object[] { Integer.valueOf(1) });
    if ((this.mPayInfo != null) && (8 == this.mPayInfo.dqL))
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(13955, new Object[] { Integer.valueOf(2) });
      if (this.mPayInfo.hbR != null)
      {
        long l = this.mPayInfo.hbR.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.wUl.f(13956, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    Object localObject;
    if (this.Bix != null)
    {
      this.Bjk = com.tencent.mm.plugin.wallet_core.ui.e.BBL.a(this.wSu);
      localObject = this.Bjk.azE(this.Bix.Bwv);
      if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).BgK != 0.0D)) {}
    }
    for (;;)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.wallet.a.s.epp();
        if (com.tencent.mm.plugin.wallet.a.s.epq().esb())
        {
          ac.i(this.TAG, "payWithoutPassword zeroPay");
          if (this.mPayInfo == null)
          {
            i = k;
            if (this.mPayInfo != null) {
              break label258;
            }
          }
          label258:
          for (localObject = "";; localObject = this.mPayInfo.dac)
          {
            af.f(i, (String)localObject, 3, "");
            epP();
            AppMethodBeat.o(69447);
            return;
            i = this.mPayInfo.dqL;
            break;
          }
        }
        ac.i(this.TAG, "has useful bankcard ! payWithOldBankcard zeroPay");
        epB();
        AppMethodBeat.o(69447);
        return;
      }
      if (this.Bjo)
      {
        ac.i(this.TAG, "hy: start do pay with force use given bankcard");
        if (!bs.isNullOrNil(this.Bjp))
        {
          this.AYu = epR();
          epB();
          AppMethodBeat.o(69447);
          return;
        }
        com.tencent.mm.plugin.wallet.a.s.epp();
        if (com.tencent.mm.plugin.wallet.a.s.epq().esc()) {
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
          i = this.mPayInfo.dqL;
          break;
          localObject = this.mPayInfo.dac;
          break label370;
          com.tencent.mm.plugin.wallet.a.s.epp();
        } while (!com.tencent.mm.plugin.wallet.a.s.epq().esb());
        if (this.mPayInfo == null)
        {
          i = 0;
          label440:
          if (this.mPayInfo != null) {
            break label474;
          }
        }
        label474:
        for (localObject = "";; localObject = this.mPayInfo.dac)
        {
          af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.dqL;
          break label440;
        }
      }
      localObject = bs.bG(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!bs.isNullOrNil((String)localObject)) {
        this.AYu = ayZ((String)localObject);
      }
      if (this.AYu == null)
      {
        if ((this.AYt != null) && (this.AYt.size() > 0))
        {
          ac.i(this.TAG, " no last pay bankcard ! jump to select bankcard!");
          d(false, 8, "");
          AppMethodBeat.o(69447);
          return;
        }
        ac.i(this.TAG, "default bankcard not found! payWithNewBankcard");
        com.tencent.mm.plugin.wallet.a.s.epp();
        if (com.tencent.mm.plugin.wallet.a.s.epq().esc()) {
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
          i = this.mPayInfo.dqL;
          break;
          localObject = this.mPayInfo.dac;
          break label614;
          com.tencent.mm.plugin.wallet.a.s.epp();
        } while (!com.tencent.mm.plugin.wallet.a.s.epq().esb());
        if (this.mPayInfo == null)
        {
          i = 0;
          label684:
          if (this.mPayInfo != null) {
            break label718;
          }
        }
        label718:
        for (localObject = "";; localObject = this.mPayInfo.dac)
        {
          af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.dqL;
          break label684;
        }
      }
      i = this.AYu.a(this.wSu.BoU, this.wSu);
      if (this.wMw != null) {
        this.wMw.ch(10002, "");
      }
      if (i != 0)
      {
        ac.i(this.TAG, "main bankcard(" + i + ") is useless! jump to select bankcard!");
        d(false, i, "");
        AppMethodBeat.o(69447);
        return;
      }
      com.tencent.mm.plugin.wallet.a.s.epp();
      if (com.tencent.mm.plugin.wallet.a.s.epq().esb())
      {
        ac.i(this.TAG, "payWithoutPassword");
        if (this.mPayInfo == null)
        {
          i = j;
          if (this.mPayInfo != null) {
            break label891;
          }
        }
        label891:
        for (localObject = "";; localObject = this.mPayInfo.dac)
        {
          af.f(i, (String)localObject, 3, "");
          epP();
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.dqL;
          break;
        }
      }
      ac.i(this.TAG, "has useful bankcard ! payWithOldBankcard");
      epB();
      AppMethodBeat.o(69447);
      return;
      i = 0;
    }
  }
  
  private void epP()
  {
    AppMethodBeat.i(69448);
    tw(true);
    com.tencent.mm.plugin.wallet_core.utils.f.euN();
    AppMethodBeat.o(69448);
  }
  
  private Bankcard epR()
  {
    AppMethodBeat.i(69460);
    com.tencent.mm.plugin.wallet.a.s.epp();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.epq().tD(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (bs.nullAsNil(this.Bjp).equals(localBankcard.field_bindSerial))
        {
          ac.i(this.TAG, "hy: get given bankcard");
          AppMethodBeat.o(69460);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(69460);
    return null;
  }
  
  private boolean epS()
  {
    AppMethodBeat.i(69465);
    if (isTransparent())
    {
      setContentViewVisibility(4);
      aj.r(this, 0);
      AppMethodBeat.o(69465);
      return false;
    }
    setContentViewVisibility(0);
    aj.r(this, getActionbarColor());
    AppMethodBeat.o(69465);
    return true;
  }
  
  private boolean epT()
  {
    AppMethodBeat.i(69468);
    if ((this.wSu != null) && (this.wSu.BxI))
    {
      com.tencent.mm.kernel.g.agS();
      if (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(196614, Boolean.TRUE)).booleanValue())
      {
        Object localObject = getLayoutInflater().inflate(2131496007, null);
        final CheckBox localCheckBox = (CheckBox)((View)localObject).findViewById(2131305890);
        fu((View)localObject);
        ((TextView)((View)localObject).findViewById(2131305896)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69410);
            paramAnonymousView = localCheckBox;
            if (!localCheckBox.isChecked()) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousView.setChecked(bool);
              AppMethodBeat.o(69410);
              return;
            }
          }
        });
        localObject = com.tencent.mm.ui.base.h.a(this, getString(2131765703), (View)localObject, getString(2131765184), getString(2131765799), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(69411);
            if (localCheckBox.isChecked())
            {
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agR().agA().set(196614, Boolean.FALSE);
            }
            WalletPayUI.this.tu(false);
            AppMethodBeat.o(69411);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(69413);
            WalletPayUI.this.finish();
            AppMethodBeat.o(69413);
          }
        });
        ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
        localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(69414);
            paramAnonymousCompoundButton = this.Bkb.getButton(-2);
            if (paramAnonymousBoolean)
            {
              paramAnonymousCompoundButton.setEnabled(false);
              AppMethodBeat.o(69414);
              return;
            }
            paramAnonymousCompoundButton.setEnabled(true);
            AppMethodBeat.o(69414);
          }
        });
        AppMethodBeat.o(69468);
        return false;
      }
    }
    AppMethodBeat.o(69468);
    return true;
  }
  
  private boolean ept()
  {
    AppMethodBeat.i(69449);
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQg, Integer.valueOf(0))).intValue();
    if ((com.tencent.mm.sdk.a.b.eUk()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
      i = 1;
    }
    if ((i == 1) || ((this.wSu != null) && (this.wSu.Byo == 1)))
    {
      AppMethodBeat.o(69449);
      return true;
    }
    AppMethodBeat.o(69449);
    return false;
  }
  
  private void fu(View paramView)
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
    if ((this.mPayInfo != null) && (this.mPayInfo.dqL == 46) && (this.wSu != null))
    {
      paramIntent.putExtra("key_total_fee", this.wSu.daf);
      ac.i(this.TAG, "sentCancelEvent set fee:%s", new Object[] { Double.valueOf(this.wSu.daf) });
    }
    xv localxv = new xv();
    localxv.dBk.intent = paramIntent;
    xv.a locala;
    if (this.BjT == 1)
    {
      localxv.dBk.dBl = 1000;
      localxv.dBk.result = paramInt;
      locala = localxv.dBk;
      if (this.mPayInfo != null) {
        break label217;
      }
    }
    label217:
    for (paramIntent = "";; paramIntent = this.mPayInfo.dac)
    {
      locala.dac = paramIntent;
      localxv.dBk.dBn = 1;
      if ((this.mPayInfo != null) && (paramInt == 0)) {
        com.tencent.mm.plugin.wallet.pay.a.b.b.aw(this.mPayInfo.dac, this.mPayInfo.dqL, this.mPayInfo.channel);
      }
      com.tencent.mm.sdk.b.a.GpY.l(localxv);
      AppMethodBeat.o(69437);
      return;
      if (this.BjT != 2) {
        break;
      }
      localxv.dBk.dBl = 1001;
      break;
    }
  }
  
  protected final void aJ(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(69455);
    com.tencent.mm.plugin.report.service.h.wUl.f(13958, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.h.wUl.f(13955, new Object[] { Integer.valueOf(4) });
    if (this.mPayInfo == null) {
      if (this.mPayInfo != null) {
        break label226;
      }
    }
    label226:
    for (Object localObject = "";; localObject = this.mPayInfo.dac)
    {
      af.f(i, (String)localObject, 11, "");
      localObject = getInput();
      ((Bundle)localObject).putInt("key_main_bankcard_state", paramInt);
      ((Bundle)localObject).putParcelable("key_orders", this.wSu);
      ((Bundle)localObject).putParcelable("key_pay_info", this.mPayInfo);
      ((Bundle)localObject).putParcelable("key_authen", epL());
      ((Bundle)localObject).putString("key_pwd1", this.iXf);
      ((Bundle)localObject).putInt("key_pay_flag", 3);
      ((Bundle)localObject).putInt("key_err_code", -1004);
      ((Bundle)localObject).putParcelable("key_favor_pay_info", this.Bix);
      ((Bundle)localObject).putBoolean("key_is_filter_bank_type", paramBoolean);
      if (this.AYu != null) {
        ((Bundle)localObject).putString("key_is_cur_bankcard_bind_serial", this.AYu.field_bindSerial);
      }
      aq((Bundle)localObject);
      AppMethodBeat.o(69455);
      return;
      i = this.mPayInfo.dqL;
      break;
    }
  }
  
  protected final boolean aRK()
  {
    AppMethodBeat.i(69459);
    String str2;
    String str1;
    if ((this.wSu == null) || (this.wSu.BxR == null) || (this.wSu.BxR.size() <= 0))
    {
      ac.w(this.TAG, "mOrders info is Illegal!");
      if ((this.Bjj != null) && (this.Bjj.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      str2 = getString(2131765550);
      str1 = str2;
      if (this.Bjj != null)
      {
        str1 = str2;
        if (!bs.isNullOrNil(this.Bjj.errMsg)) {
          str1 = this.Bjj.errMsg;
        }
      }
      ac.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.d(getContext(), str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69408);
          WalletPayUI.this.finish();
          AppMethodBeat.o(69408);
        }
      });
      AppMethodBeat.o(69459);
      return false;
    }
    if ((this.Bjo) && (!bs.isNullOrNil(this.Bjp)) && (epR() == null))
    {
      if ((this.Bjj != null) && (this.Bjj.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      ac.w(this.TAG, "hy: should use given bankcard, but resolved as null. show error msg and quit");
      str2 = getString(2131765550);
      str1 = str2;
      if (this.Bjj != null)
      {
        str1 = str2;
        if (!bs.isNullOrNil(this.Bjj.errMsg)) {
          str1 = this.Bjj.errMsg;
        }
      }
      ac.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
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
    AppMethodBeat.o(69459);
    return true;
  }
  
  protected void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(69471);
    this.Bjm = true;
    if (this.wSu != null)
    {
      paramBundle.putInt("key_support_bankcard", this.wSu.BoU);
      paramBundle.putString("key_reqKey", this.wSu.dac);
      if ((this.wSu.BxR != null) && (this.wSu.BxR.size() > 0)) {
        paramBundle.putString("key_TransId", ((Orders.Commodity)this.wSu.BxR.get(0)).dad);
      }
      paramBundle.putLong("key_SessionId", this.BjF);
    }
    if (this.mPayInfo != null) {
      paramBundle.putInt("key_scene", this.mPayInfo.dqL);
    }
    if (!epM()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      paramBundle.putInt("is_deduct_open", this.BjN);
      this.Bjn = new d.a()
      {
        public final Intent r(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(69415);
          ac.i(WalletPayUI.this.TAG, "pay process end");
          WalletPayUI.this.Bjm = false;
          paramAnonymousBundle = new Intent();
          AppMethodBeat.o(69415);
          return paramAnonymousBundle;
        }
      };
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, paramBundle, this.Bjn);
      AppMethodBeat.o(69471);
      return;
    }
  }
  
  protected final void c(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69452);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
    com.tencent.mm.plugin.wallet.a.s.epp();
    ac.d(str, com.tencent.mm.plugin.wallet.a.s.epq().esa() + ", need confirm ? " + paramBoolean);
    if (paramBoolean)
    {
      if (!bs.isNullOrNil(paramString)) {
        break label130;
      }
      paramString = Bankcard.ai(this, paramInt);
    }
    label130:
    for (;;)
    {
      com.tencent.mm.ui.base.h.d(this, paramString, "", getString(2131765660), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69398);
          WalletPayUI.this.epQ();
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
      epQ();
      AppMethodBeat.o(69452);
      return;
    }
  }
  
  public final void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69472);
    ac.i(this.TAG, "onGenFinish callback");
    if (paramBoolean)
    {
      ac.i(this.TAG, "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.djs = paramString1;
      this.mPayInfo.djt = paramString2;
      tw(false);
      com.tencent.mm.plugin.wallet_core.utils.f.euN();
      AppMethodBeat.o(69472);
      return;
    }
    ac.e(this.TAG, "onGenFinish callback, result.isSuccess is false");
    tw(false);
    com.tencent.mm.plugin.wallet_core.utils.f.euN();
    AppMethodBeat.o(69472);
  }
  
  protected final void cL()
  {
    AppMethodBeat.i(69439);
    if ((this.wSu != null) && (this.wSu.BxR != null) && (this.wSu.BxR.size() > 0))
    {
      this.Bjt.setText(com.tencent.mm.wallet_core.ui.e.C(this.wSu.daf));
      this.Bjw.setText(com.tencent.mm.wallet_core.ui.e.aSG(this.wSu.vxl));
      this.BjD.notifyDataSetChanged();
      if (this.wSu.BxR.size() > 1)
      {
        this.Bjz.setVisibility(0);
        this.Bju.setText(getString(2131765708, new Object[] { ((Orders.Commodity)this.wSu.BxR.get(0)).desc, this.wSu.BxR.size() }));
        this.Bjq = false;
      }
    }
    else
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.dqL == 48)) {
        this.Bju.setText(2131762090);
      }
      this.Bjx.setVisibility(8);
      this.Bjy.setVisibility(8);
      this.BjG.setVisibility(8);
      this.BjH.setVisibility(8);
      this.wRL.setText(2131765657);
      if ((this.AYu == null) || (!this.AYu.eqR())) {
        break label542;
      }
      if (bs.isNullOrNil(this.AYu.field_forbidWord)) {
        break label522;
      }
      this.Bjx.setText(this.AYu.field_forbidWord);
      this.Bjx.setVisibility(4);
      this.Bjy.setVisibility(8);
      com.tencent.mm.plugin.wallet.a.s.epp();
      if (com.tencent.mm.plugin.wallet.a.s.epq().esb()) {
        epI();
      }
      label329:
      com.tencent.mm.plugin.wallet.a.s.epp();
      if (!com.tencent.mm.plugin.wallet.a.s.epq().esb())
      {
        com.tencent.mm.plugin.wallet.a.s.epp();
        if (!com.tencent.mm.plugin.wallet.a.s.epq().esc()) {
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
      if ((i != 0) && (this.Bix != null) && (this.Bjk != null) && (this.Bjl) && (this.wSu != null))
      {
        epK();
        this.BjB.setOnClickListener(new View.OnClickListener()
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
            for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dac)
            {
              af.f(i, paramAnonymousView, 12, "");
              com.tencent.mm.plugin.wallet_core.ui.n.a(WalletPayUI.this.getContext(), WalletPayUI.this.wSu, WalletPayUI.this.Bix.Bwv, new n.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  int j = 1;
                  AppMethodBeat.i(69422);
                  WalletPayUI.this.Bix = paramAnonymous2FavorPayInfo;
                  Object localObject = WalletPayUI.this.TAG;
                  int i;
                  label82:
                  label98:
                  boolean bool;
                  if (paramAnonymous2FavorPayInfo == null)
                  {
                    paramAnonymous2FavorPayInfo = "";
                    ac.i((String)localObject, "WalletFavorDialog onSelectionDone %s", new Object[] { paramAnonymous2FavorPayInfo });
                    if (WalletPayUI.this.Bix != null)
                    {
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label467;
                      }
                      i = 0;
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label485;
                      }
                      paramAnonymous2FavorPayInfo = "";
                      af.f(i, paramAnonymous2FavorPayInfo, 15, WalletPayUI.this.Bix.Bwv);
                      if ((WalletPayUI.this.AYu != null) && (!com.tencent.mm.plugin.wallet_core.ui.d.a(WalletPayUI.this.Bix, WalletPayUI.this.AYu))) {
                        break label502;
                      }
                      WalletPayUI.this.Bjy.setVisibility(8);
                      WalletPayUI.this.wRL.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69419);
                          ac.i(WalletPayUI.this.TAG, "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
                          WalletPayUI.this.c(false, 0, "");
                          AppMethodBeat.o(69419);
                        }
                      });
                      bool = true;
                    }
                  }
                  for (;;)
                  {
                    label197:
                    ac.i(WalletPayUI.this.TAG, "needBindBankCard %s", new Object[] { Boolean.valueOf(bool) });
                    WalletPayUI.c(WalletPayUI.this).setVisibility(0);
                    WalletPayUI.d(WalletPayUI.this).setVisibility(0);
                    if (WalletPayUI.this.Bix != null)
                    {
                      WalletPayUI.this.Bjk = com.tencent.mm.plugin.wallet_core.ui.e.BBL.a(WalletPayUI.this.wSu);
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.Bjk.azE(WalletPayUI.this.Bix.Bwv);
                      if ((paramAnonymous2FavorPayInfo != null) && (paramAnonymous2FavorPayInfo.BgK == 0.0D))
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
                        WalletPayUI.this.Bjx.setVisibility(8);
                        WalletPayUI.this.Bjy.setVisibility(0);
                        WalletPayUI.this.wRL.setOnClickListener(new View.OnClickListener()
                        {
                          public final void onClick(View paramAnonymous3View)
                          {
                            AppMethodBeat.i(69421);
                            WalletPayUI.this.epN();
                            AppMethodBeat.o(69421);
                          }
                        });
                      }
                      if (i != 0) {
                        WalletPayUI.this.Bjy.setVisibility(8);
                      }
                      WalletPayUI.this.epK();
                      AppMethodBeat.o(69422);
                      return;
                      paramAnonymous2FavorPayInfo = paramAnonymous2FavorPayInfo.toString();
                      break;
                      label467:
                      i = WalletPayUI.this.mPayInfo.dqL;
                      break label82;
                      label485:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.mPayInfo.dac;
                      break label98;
                      label502:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.Bjk.azE(WalletPayUI.this.Bix.Bwv);
                      if ((paramAnonymous2FavorPayInfo == null) || (!WalletPayUI.this.AYu.eqR())) {
                        break label644;
                      }
                      com.tencent.mm.plugin.wallet.a.s.epp();
                      localObject = com.tencent.mm.plugin.wallet.a.s.epq().AZp;
                      double d = paramAnonymous2FavorPayInfo.BgK;
                      if ((localObject == null) || (((Bankcard)localObject).Buo >= d)) {
                        break label644;
                      }
                      ac.i(WalletPayUI.this.TAG, "balance not meet");
                      WalletPayUI.this.Bjy.setVisibility(8);
                      WalletPayUI.this.wRL.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69420);
                          ac.i(WalletPayUI.this.TAG, "Balance amount not meet, after favor selection! payWithNewBankcard");
                          WalletPayUI.this.c(false, 0, "");
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
              i = WalletPayUI.this.mPayInfo.dqL;
              break;
            }
          }
        });
        localLinearLayout.setVisibility(0);
        if ((this.wSu == null) || (this.AYt == null) || (this.mPayInfo == null)) {
          break label571;
        }
        this.wRL.setClickable(true);
        this.wRL.setEnabled(true);
      }
      for (;;)
      {
        if (this.wSu == null) {
          this.Bjy.setVisibility(8);
        }
        AppMethodBeat.o(69439);
        return;
        this.Bju.setText(((Orders.Commodity)this.wSu.BxR.get(0)).desc);
        this.Bjz.setVisibility(8);
        break;
        com.tencent.mm.plugin.wallet.a.s.epp();
        if (!com.tencent.mm.plugin.wallet.a.s.epq().esb()) {
          break label329;
        }
        epI();
        break label329;
        com.tencent.mm.plugin.wallet.a.s.epp();
        if (!com.tencent.mm.plugin.wallet.a.s.epq().esc()) {
          break label329;
        }
        epI();
        break label329;
        localLinearLayout.setVisibility(8);
        break label424;
        this.wRL.setClickable(false);
        this.wRL.setEnabled(false);
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
      epB();
    }
    AppMethodBeat.o(69466);
  }
  
  public final void d(boolean paramBoolean, final int paramInt, String paramString)
  {
    AppMethodBeat.i(69453);
    ac.d(this.TAG, "pay with select bankcard! need confirm ? ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (!bs.isNullOrNil(paramString)) {
        break label118;
      }
      paramString = Bankcard.ai(this, paramInt);
    }
    label118:
    for (;;)
    {
      com.tencent.mm.ui.base.h.d(this, paramString, "", getString(2131765679), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69401);
          if (WalletPayUI.m(WalletPayUI.this))
          {
            WalletPayUI.this.tv(true);
            AppMethodBeat.o(69401);
            return;
          }
          WalletPayUI.this.aJ(paramInt, false);
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
      if (ept())
      {
        tv(true);
        AppMethodBeat.o(69453);
        return;
      }
      aJ(paramInt, false);
      AppMethodBeat.o(69453);
      return;
    }
  }
  
  protected void epB()
  {
    AppMethodBeat.i(69450);
    tv(false);
    AppMethodBeat.o(69450);
  }
  
  protected void epH()
  {
    int i = 2;
    AppMethodBeat.i(69432);
    com.tencent.mm.plugin.report.service.h.wUl.f(11850, new Object[] { Integer.valueOf(2), Integer.valueOf(this.mPayInfo.dqL) });
    if (this.mPayInfo.dqL == 11) {
      i = 3;
    }
    Object localObject = this.mPayInfo;
    if ((localObject == null) || (bs.isNullOrNil(((PayInfo)localObject).dac)))
    {
      ac.i("MicroMsg.CgiManager", "no payInfo or reqKey");
      localObject = null;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessName("PayProcess");
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessSessionId(this.BjF);
        if ((this.mPayInfo.dqL != 6) || (this.mPayInfo.DGI != 100)) {
          break label446;
        }
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(100);
        label134:
        if (!this.mPayInfo.DGJ) {
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
      String str = ((PayInfo)localObject).dac;
      ac.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", new Object[] { str });
      ac.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
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
      ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(this.mPayInfo.dqL);
      break label134;
    }
  }
  
  public final void epK()
  {
    AppMethodBeat.i(69442);
    com.tencent.mm.plugin.wallet.a.j localj = this.Bjk.azE(this.Bix.Bwv);
    List localList = this.Bjk.etg();
    com.tencent.mm.plugin.wallet.a.h localh = this.Bjk.BBG;
    Object localObject1 = "";
    double d2;
    Object localObject2;
    int i;
    double d1;
    if (localj != null)
    {
      d2 = localj.BgS;
      if (d2 > 0.0D)
      {
        localObject2 = localj.BgU;
        int j = 1;
        localObject1 = localObject2;
        i = j;
        d1 = d2;
        if (!bs.isNullOrNil(localj.BgV))
        {
          localObject1 = (String)localObject2 + "," + localj.BgV;
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
      if ((d1 > 0.0D) && (localh != null) && (localh.BgO == 0))
      {
        if (localj != null) {
          this.Bjt.setText(com.tencent.mm.wallet_core.ui.e.C(localj.BgR));
        }
        this.Bjw.setText(com.tencent.mm.wallet_core.ui.e.aSG(this.wSu.vxl));
        this.Bjv.setText(com.tencent.mm.wallet_core.ui.e.d(this.wSu.daf, this.wSu.vxl));
        this.Bjv.setVisibility(0);
      }
      for (;;)
      {
        if (!bs.isNullOrNil((String)localObject2)) {
          this.BjB.setText((CharSequence)localObject2);
        }
        AppMethodBeat.o(69442);
        return;
        this.Bjt.setText(com.tencent.mm.wallet_core.ui.e.C(this.wSu.daf));
        this.Bjw.setText(com.tencent.mm.wallet_core.ui.e.aSG(this.wSu.vxl));
        this.Bjv.setVisibility(8);
      }
      i = 0;
      d1 = d2;
      continue;
      i = 0;
      d1 = 0.0D;
    }
  }
  
  protected final Authen epL()
  {
    AppMethodBeat.i(69443);
    Authen localAuthen = new Authen();
    if (epM()) {}
    for (localAuthen.drx = 3;; localAuthen.drx = 6)
    {
      if (!bs.isNullOrNil(this.iXf)) {
        localAuthen.BtA = this.iXf;
      }
      if (this.AYu != null)
      {
        localAuthen.vwo = this.AYu.field_bindSerial;
        localAuthen.cZz = this.AYu.field_bankcardType;
      }
      if ((this.Bix != null) && (this.Bjk != null) && (this.Bjk.etd()))
      {
        localAuthen.BtK = this.Bix.Bwv;
        localAuthen.BtJ = this.Bix.Bwy;
      }
      localAuthen.wfX = this.mPayInfo;
      AppMethodBeat.o(69443);
      return localAuthen;
    }
  }
  
  protected final boolean epM()
  {
    AppMethodBeat.i(69444);
    if ((this.AYu != null) && (this.wSu != null) && (this.wSu.BoU == 3))
    {
      if (this.AYu.eqU())
      {
        AppMethodBeat.o(69444);
        return true;
      }
      AppMethodBeat.o(69444);
      return false;
    }
    if ((this.wSu != null) && (!Bankcard.TF(this.wSu.BoU)))
    {
      AppMethodBeat.o(69444);
      return true;
    }
    AppMethodBeat.o(69444);
    return false;
  }
  
  protected final void epN()
  {
    AppMethodBeat.i(69445);
    tu(true);
    AppMethodBeat.o(69445);
  }
  
  protected final void epQ()
  {
    AppMethodBeat.i(69454);
    Bundle localBundle = getIntent().getExtras();
    com.tencent.mm.plugin.wallet.a.s.epp();
    if (com.tencent.mm.plugin.wallet.a.s.epq().esa()) {}
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("key_pay_flag", i);
      localBundle.putParcelable("key_orders", this.wSu);
      localBundle.putParcelable("key_pay_info", this.mPayInfo);
      localBundle.putParcelable("key_favor_pay_info", this.Bix);
      aq(localBundle);
      AppMethodBeat.o(69454);
      return;
    }
  }
  
  protected final boolean epU()
  {
    return (this.mPayInfo != null) && (this.mPayInfo.dqL != 11);
  }
  
  public void finish()
  {
    AppMethodBeat.i(69434);
    ac.i(this.TAG, "finish %s %s mPayResultType:%s", new Object[] { Integer.valueOf(hashCode()), bs.eWi().toString(), Integer.valueOf(this.mPayResultType) });
    cancelQRPay();
    if ((this.wSu != null) && (!this.wSu.BxR.isEmpty())) {
      getIntent().putExtra("key_trans_id", ((Orders.Commodity)this.wSu.BxR.get(0)).dad);
    }
    if (this.mPayInfo != null) {
      getIntent().putExtra("key_reqKey", this.mPayInfo.dac);
    }
    com.tencent.mm.wallet_core.d locald;
    if (this.isPaySuccess)
    {
      if (this.wSu != null) {
        getIntent().putExtra("key_total_fee", this.wSu.daf);
      }
      getIntent().putExtra("key_pay_reslut_type", 1);
      m(-1, getIntent());
      setResult(-1, getIntent());
      locald = getProcess();
      if (locald != null) {
        if (locald.JDn == null) {
          break label717;
        }
      }
    }
    label408:
    label439:
    label570:
    label581:
    label717:
    for (Object localObject = (Context)locald.JDn.get();; localObject = null)
    {
      if (this == localObject)
      {
        ac.i(this.TAG, "remove process end callback to prevent ui leak");
        locald.fzE();
      }
      super.finish();
      AppMethodBeat.o(69434);
      return;
      if ((this.mPayInfo != null) && (this.mPayInfo.dqL == 8) && (this.wSu != null))
      {
        this.mPayInfo.DGQ = 0;
        doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.a(epL(), this.wSu, true), false);
        if (this.mPayInfo.hbR != null)
        {
          long l = this.mPayInfo.hbR.getLong("extinfo_key_9");
          com.tencent.mm.plugin.report.service.h.wUl.f(13956, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      m(0, getIntent());
      getIntent().putExtra("key_pay_reslut_type", this.mPayResultType);
      int i;
      if (this.BjT == 1)
      {
        getIntent().putExtra("key_pay_reslut_type", 1000);
        setResult(0, getIntent());
        com.tencent.mm.plugin.wallet.a.s.epp();
        if (!com.tencent.mm.plugin.wallet.a.s.epq().esc()) {
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
      for (localObject = "";; localObject = this.mPayInfo.dac)
      {
        af.f(i, (String)localObject, 18, "");
        localObject = com.tencent.mm.wallet_core.a.aSA("PayProcess").iterator();
        while (((Iterator)localObject).hasNext())
        {
          locald = (com.tencent.mm.wallet_core.d)((Iterator)localObject).next();
          locald.J(new Object[] { "specEndProcessWithoutFinish" });
          if (locald.dmf != null) {
            locald.dmf.clear();
          }
          com.tencent.mm.wallet_core.a.remove(locald.getClass().hashCode());
          locald.eps();
        }
        break;
        if (this.BjT != 2) {
          break label408;
        }
        getIntent().putExtra("key_pay_reslut_type", 1001);
        break label408;
        i = this.mPayInfo.dqL;
        break label439;
      }
      label593:
      com.tencent.mm.plugin.wallet.a.s.epp();
      if (com.tencent.mm.plugin.wallet.a.s.epq().esb())
      {
        if (this.mPayInfo == null)
        {
          i = 0;
          label615:
          if (this.mPayInfo != null) {
            break label649;
          }
        }
        for (localObject = "";; localObject = this.mPayInfo.dac)
        {
          af.f(i, (String)localObject, 4, "");
          break;
          i = this.mPayInfo.dqL;
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
      for (localObject = "";; localObject = this.mPayInfo.dac)
      {
        af.f(i, (String)localObject, 7, "");
        break;
        i = this.mPayInfo.dqL;
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
    aj.b(getWindow());
    MMScrollView localMMScrollView = (MMScrollView)findViewById(2131306834);
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.wRL = ((Button)findViewById(2131306815));
    this.wRL.setClickable(false);
    this.wRL.setEnabled(false);
    this.Bjt = ((TextView)findViewById(2131306804));
    this.Bju = ((TextView)findViewById(2131306803));
    this.Bjw = ((TextView)findViewById(2131306785));
    this.BjB = ((TextView)findViewById(2131306781));
    this.Bjv = ((TextView)findViewById(2131306791));
    this.BjA = ((TextView)findViewById(2131306811));
    this.Bjv.getPaint().setFlags(16);
    this.Bjx = ((TextView)findViewById(2131306816));
    this.Bjy = ((TextView)findViewById(2131306812));
    this.Bjy.setOnClickListener(new w()
    {
      public final void bWk()
      {
        AppMethodBeat.i(69416);
        WalletPayUI.this.c(false, 0, "");
        AppMethodBeat.o(69416);
      }
    });
    this.Bjz = ((ImageView)findViewById(2131306778));
    this.Bjz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69417);
        if (WalletPayUI.this.Bjq) {
          WalletPayUI.this.Bjz.setImageResource(2131233555);
        }
        for (WalletPayUI.this.Bjq = false;; WalletPayUI.this.Bjq = true)
        {
          WalletPayUI.this.BjD.notifyDataSetChanged();
          AppMethodBeat.o(69417);
          return;
          WalletPayUI.this.Bjz.setImageResource(2131233558);
        }
      }
    });
    this.BjC = ((LinearLayout)findViewById(2131306788));
    this.BjD = new a();
    this.wRL.setOnClickListener(new w()
    {
      public final void bWk()
      {
        AppMethodBeat.i(69418);
        com.tencent.mm.plugin.wallet.a.s.epp();
        int i;
        if (!com.tencent.mm.plugin.wallet.a.s.epq().esb())
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
        for (String str = "";; str = WalletPayUI.this.mPayInfo.dac)
        {
          af.f(i, str, 6, "");
          WalletPayUI.this.epN();
          WalletPayUI.this.Bjs = true;
          AppMethodBeat.o(69418);
          return;
          i = WalletPayUI.this.mPayInfo.dqL;
          break;
        }
      }
    });
    this.wRL.setText(2131765657);
    this.BjG = ((TextView)findViewById(2131303187));
    this.BjH = ((LinearLayout)findViewById(2131303186));
    cL();
    AppMethodBeat.o(69438);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69464);
    if (this.BjO)
    {
      String str1 = this.TAG;
      boolean bool1;
      label87:
      String str2;
      int i;
      if ((getPayInfo() == null) || (!getPayInfo().teP))
      {
        bool1 = true;
        ac.i(str1, "case 1 %s,  stack %s", new Object[] { Boolean.valueOf(bool1), bs.eWi().toString() });
        str1 = this.TAG;
        com.tencent.mm.plugin.wallet.a.s.epp();
        if (com.tencent.mm.plugin.wallet.a.s.epq().esa()) {
          break label196;
        }
        bool1 = true;
        ac.d(str1, "case 2 %s,", new Object[] { Boolean.valueOf(bool1) });
        str2 = this.TAG;
        if (this.AYt != null) {
          break label201;
        }
        i = 0;
        label121:
        if (this.AYu != null) {
          break label212;
        }
      }
      label196:
      label201:
      label212:
      for (str1 = "";; str1 = this.AYu.field_forbidWord)
      {
        ac.d(str2, "case 3 mBankcardList %s, mDefaultBankcard %s", new Object[] { Integer.valueOf(i), str1 });
        if ((getPayInfo() != null) && (getPayInfo().teP)) {
          break label224;
        }
        ac.i(this.TAG, "get isTransparent1");
        AppMethodBeat.o(69464);
        return false;
        bool1 = false;
        break;
        bool1 = false;
        break label87;
        i = this.AYt.size();
        break label121;
      }
      label224:
      com.tencent.mm.plugin.wallet.a.s.epp();
      if (!com.tencent.mm.plugin.wallet.a.s.epq().esa())
      {
        ac.i(this.TAG, "get isTransparent2");
        AppMethodBeat.o(69464);
        return false;
      }
      if ((this.AYt != null) && ((this.AYt.size() == 0) || ((this.AYu != null) && (!bs.isNullOrNil(this.AYu.field_forbidWord)))))
      {
        str1 = this.TAG;
        if ((this.AYt != null) && (this.AYt.size() == 0))
        {
          bool1 = true;
          if ((this.AYu == null) || (bs.isNullOrNil(this.AYu.field_forbidWord))) {
            break label378;
          }
        }
        label378:
        for (boolean bool2 = true;; bool2 = false)
        {
          ac.i(str1, "get isTransparent3 1 %s 2 %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(69464);
          return false;
          bool1 = false;
          break;
        }
      }
      ac.i(this.TAG, "get isTransparent4");
      AppMethodBeat.o(69464);
      return true;
    }
    ac.i(this.TAG, "get isTransparent5");
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
    ac.i(this.TAG, "onAcvityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
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
          this.BjN = paramIntent.getIntExtra("auto_deduct_flag", -1);
          if ((this.wSu != null) && (this.wSu.BxW != null)) {
            this.wSu.BxW.BjN = this.BjN;
          }
          getPayInfo().DGN = this.BjN;
          if (this.BjN == 1)
          {
            getPayInfo().DGO = paramIntent.getStringExtra("deduct_bank_type");
            getPayInfo().DGP = paramIntent.getStringExtra("deduct_bind_serial");
          }
        }
        this.BjM = true;
        onProgressFinish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(13958, new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(69462);
        return;
        finish();
      }
      this.BjE.dismiss();
      this.Bjs = false;
      epH();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69429);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.TAG = ("MicroMsg.WalletPayUI@" + hashCode());
    if (Bjh)
    {
      ac.w(this.TAG, "has Undestory WalletPayUI!");
      com.tencent.mm.plugin.report.service.h.wUl.n(965L, 1L, 1L);
      Tx(2);
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    Bjh = true;
    long l = System.currentTimeMillis();
    int j = getIntent().getIntExtra("key_context_hashcode", -1);
    paramBundle = new b[Bji.size()];
    ac.i(this.TAG, "WalletPayUI check %s this %s fromHashCode %s", new Object[] { Integer.valueOf(Bji.size()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
    paramBundle = (b[])Bji.toArray(paramBundle);
    int k = paramBundle.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = paramBundle[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localObject.lpX.get();
      if (localWalletPayUI != null)
      {
        ac.w(this.TAG, "has old payui, both finish %s", new Object[] { Integer.valueOf(localWalletPayUI.hashCode()) });
        if ((j != localObject.aFZ) || (j == -1)) {
          break label290;
        }
        localWalletPayUI.Tx(2);
        com.tencent.mm.plugin.report.service.h.wUl.n(965L, 41L, 1L);
      }
      for (;;)
      {
        Bji.remove(localObject);
        localWalletPayUI.finish();
        i += 1;
        break;
        label290:
        localWalletPayUI.Tx(1);
        com.tencent.mm.plugin.report.service.h.wUl.n(965L, 40L, 1L);
      }
    }
    this.BjV = new b((byte)0);
    this.BjV.timestamp = l;
    this.BjV.aFZ = j;
    this.BjV.lpX = new WeakReference(this);
    Bji.add(this.BjV);
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.e(this.TAG, "hy: account not ready. finish now");
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    getWindow().getDecorView().postDelayed(this.BjU, 5000L);
    this.BjW = bs.eWj();
    com.tencent.mm.sdk.b.a.GpY.c(this.wPR);
    com.tencent.mm.plugin.wallet_core.model.k.TG(5);
    this.wMw = com.tencent.mm.plugin.wallet.a.aN(getIntent());
    setMMTitle(2131765707);
    this.mPayInfo = getPayInfo();
    this.Bjo = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
    this.Bjp = bs.bG(getIntent().getStringExtra("key_force_use_bind_serail"), "");
    this.wMX = getIntent().getStringExtra("key_receiver_true_name");
    if ((this.mPayInfo == null) || (this.mPayInfo.DGM == 0L))
    {
      this.BjF = System.currentTimeMillis();
      com.tencent.mm.plugin.wallet.a.s.epp();
      if (!com.tencent.mm.plugin.wallet.a.s.epq().esa())
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
      if (epG()) {
        break label763;
      }
      ac.d(this.TAG, "PayInfo = " + this.mPayInfo);
      if ((this.mPayInfo == null) || (bs.isNullOrNil(this.mPayInfo.dac))) {
        break label705;
      }
      epH();
      com.tencent.mm.plugin.secinforeport.a.d.xnP.asyncReportPaySecurityInfoThroughCgi();
      initView();
    }
    for (;;)
    {
      if (this.mPayInfo != null) {
        com.tencent.mm.plugin.wallet.pay.a.b.ayS(this.mPayInfo.DGS);
      }
      AppMethodBeat.o(69429);
      return;
      this.BjF = this.mPayInfo.DGM;
      break;
      label683:
      i = this.mPayInfo.dqL;
      break label559;
      label694:
      paramBundle = this.mPayInfo.dac;
      break label569;
      label705:
      if ((this.mPayInfo != null) && (!bs.isNullOrNil(this.mPayInfo.errMsg))) {}
      for (paramBundle = this.mPayInfo.errMsg;; paramBundle = getString(2131765700))
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
      ac.i(this.TAG, "hy: pay end on create. finish");
      finish();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69431);
    if (this.Biy != null)
    {
      this.Biy.closeTipDialog();
      this.Biy.release();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.wPR);
    this.Biz = null;
    getWindow().getDecorView().removeCallbacks(this.BjU);
    Bji.remove(this.BjV);
    Bjh = false;
    long l = System.currentTimeMillis();
    b[] arrayOfb = new b[Bji.size()];
    arrayOfb = (b[])Bji.toArray(arrayOfb);
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localb.lpX.get();
      if ((localWalletPayUI != null) && (l - localb.timestamp > 600000L))
      {
        ac.w(this.TAG, "has old payui, both finish");
        com.tencent.mm.plugin.report.service.h.wUl.n(965L, 2L, 1L);
        Bji.remove(localb);
        localWalletPayUI.Tx(1);
        localWalletPayUI.finish();
      }
      i += 1;
    }
    if (this.mPayInfo != null) {
      com.tencent.mm.plugin.wallet.pay.a.b.ayT(this.mPayInfo.DGS);
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
        ac.w(this.TAG, "block when authening");
        AppMethodBeat.o(69435);
        return true;
      }
      if ((this.BjE != null) && (this.mPayInfo != null) && (this.mPayInfo.teP) && (!this.mNetSceneMgr.isProcessing())) {
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
    ac.i(this.TAG, "onNewIntent");
    setIntent(paramIntent);
    if (!epG())
    {
      ac.w(this.TAG, "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
      if (paramIntent.getBooleanExtra("send_cancel_event", true)) {
        m(0, getIntent());
      }
      this.isPaySuccess = false;
    }
    if (paramIntent.getBooleanExtra("direc_change_bankcard", false))
    {
      tv(true);
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false))) {
      this.BjJ = true;
    }
    for (int i = 1; i != 0; i = 0)
    {
      ac.i(this.TAG, "isFromBindCard is true");
      epH();
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_is_realname_verify_process", false)))
    {
      this.BjK = true;
      i = j;
      if (i == 0) {
        break label196;
      }
      ac.i(this.TAG, "isFromRealNameVerify is true");
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
      ac.e(this.TAG, "isFromBindCard is false,isFromRealNameVerify is false");
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69473);
    super.onPause();
    if (this.Biz != null) {
      this.Biz.onActivityPause();
    }
    AppMethodBeat.o(69473);
  }
  
  public boolean onProgressFinish()
  {
    boolean bool2 = false;
    AppMethodBeat.i(69463);
    ac.i(this.TAG, "onProgressFinish isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.BjR) });
    com.tencent.mm.sdk.b.a.GpY.l(new xk());
    int i;
    int j;
    label93:
    Object localObject;
    label104:
    boolean bool1;
    if ((this.wSu != null) && (this.wSu.BxW != null) && (!this.BjM))
    {
      i = 1;
      if ((i == 0) && (!epS()))
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
      if (!this.BjR) {
        break label163;
      }
      tu(true);
      bool1 = true;
    }
    for (;;)
    {
      AppMethodBeat.o(69463);
      return bool1;
      i = 0;
      break;
      label140:
      j = this.mPayInfo.dqL;
      break label93;
      label151:
      localObject = this.mPayInfo.dac;
      break label104;
      label163:
      if (this.BjL)
      {
        bool1 = true;
      }
      else if (i != 0)
      {
        localObject = new Intent(this, WalletPayDeductUI.class);
        ((Intent)localObject).putExtra("orders", this.wSu);
        startActivityForResult((Intent)localObject, 0);
        bool1 = true;
      }
      else if (getContentView().getVisibility() != 0)
      {
        if ((!this.Bjs) && (aRK()))
        {
          tu(true);
          this.Bjs = true;
        }
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (getContentView().getVisibility() == 0)
        {
          bool1 = bool2;
          if (this.wSu != null)
          {
            bool1 = bool2;
            if (this.wSu.BxW != null)
            {
              bool1 = bool2;
              if (this.wRL.isEnabled())
              {
                bool1 = bool2;
                if (!this.BjP)
                {
                  this.wRL.performClick();
                  this.BjP = true;
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
    ac.i(this.TAG, "hy: onResume isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.BjR) });
    if (!isProcessing())
    {
      if (!bs.isNullOrNil(this.Bjp)) {
        this.AYu = epR();
      }
    }
    else
    {
      if (!this.BjS) {
        break label149;
      }
      ac.i(this.TAG, "onResume isResumePassFinish");
      this.BjS = false;
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(69433);
      return;
      if (this.AYu == null)
      {
        com.tencent.mm.plugin.wallet.a.s.epp();
        this.AYu = com.tencent.mm.plugin.wallet.a.s.epq().a(null, null, epU(), false);
        break;
      }
      com.tencent.mm.plugin.wallet.a.s.epp();
      this.AYu = com.tencent.mm.plugin.wallet.a.s.epq().a(null, this.AYu.field_bindSerial, epU(), false);
      break;
      label149:
      if ((this.Bjm) && (getContentViewVisibility() != 0) && ((this.BjE == null) || (!this.BjE.isShowing())))
      {
        ac.i(this.TAG, "hy: has started process and is transparent and no pwd appeared. finish self");
        finish();
      }
      else if (this.Biz != null)
      {
        this.Biz.eth();
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
    ac.i(this.TAG, "errorType %s errCode %s, errmsg %s, scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
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
        this.Bjj = ((com.tencent.mm.plugin.wallet.pay.a.c.f)paramn);
        paramString = (com.tencent.mm.plugin.wallet.pay.a.c.f)paramn;
        if (paramString.isJumpRemind())
        {
          paramn = paramString.getJumpRemind();
          paramn.fAk();
          paramn.a(this, new com.tencent.mm.wallet_core.c.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(69403);
              if (paramn.fAj())
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
              if (paramn.fAj())
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
              if (paramn.fAj())
              {
                WalletPayUI.a(WalletPayUI.this, paramString);
                AppMethodBeat.o(69404);
                return;
              }
              WalletPayUI.this.epH();
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
        cL();
        AppMethodBeat.o(69458);
        return true;
      }
      this.mPayResultType = 1;
      paramn = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramn;
      paramString = getInput();
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putParcelable("key_bankcard", this.AYu);
      paramString.putString("key_bank_type", this.AYu.field_bankcardType);
      if (!bs.isNullOrNil(this.iXf)) {
        paramString.putString("key_pwd1", this.iXf);
      }
      paramString.putString("kreq_token", paramn.getToken());
      paramString.putParcelable("key_authen", paramn.Bia);
      if (!paramn.BhY)
      {
        bool = true;
        paramString.putBoolean("key_need_verify_sms", bool);
        paramString.putInt("key_can_verify_tail", paramn.Bie);
        paramString.putString("key_verify_tail_wording", paramn.Bif);
        localObject1 = getInput();
        if (paramn.Big != 1) {
          break label628;
        }
        bool = true;
        ((Bundle)localObject1).putBoolean("key_block_bind_new_card", bool);
        if (!bs.isNullOrNil(paramn.Bib)) {
          break label634;
        }
        paramString.putString("key_mobile", this.AYu.field_mobile);
        paramString.putString("key_QADNA_URL", paramn.Bic);
        if (!paramn.isPaySuccess) {
          break label649;
        }
        if (this.wMw != null)
        {
          this.wMw.ch(10003, "");
          localObject1 = this.wMw;
          com.tencent.mm.plugin.report.service.h.wUl.f(13455, new Object[] { ((com.tencent.mm.plugin.wallet.a)localObject1).AWj, Long.valueOf(System.currentTimeMillis()), ((com.tencent.mm.plugin.wallet.a)localObject1).AWk });
        }
        paramString.putParcelable("key_orders", paramn.BhZ);
        if (this.mPayInfo != null)
        {
          ac.i(this.TAG, "payscene %d", new Object[] { Integer.valueOf(this.mPayInfo.dqL) });
          if (8 == this.mPayInfo.dqL)
          {
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJT, Boolean.TRUE);
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("pwd", this.iXf);
        localObject2 = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class);
        paramInt1 = 0;
        if (!((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).cHy()) {
          break label663;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
        ((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).a(paramn.epv(), true, this.mPayInfo.BxP, (Bundle)localObject1);
        paramString.putInt("key_pay_flag", 3);
        paramn = paramn.vsI;
        if (paramn != null) {
          paramString.putParcelable("key_realname_guide_helper", paramn);
        }
        aq(paramString);
        AppMethodBeat.o(69458);
        return true;
        bool = false;
        break;
        label628:
        bool = false;
        break label308;
        label634:
        paramString.putString("key_mobile", paramn.Bib);
        break label343;
        label649:
        paramString.putParcelable("key_orders", this.wSu);
        break label503;
        label663:
        if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).cHz()) {
          paramInt1 = 2;
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("pwd", this.iXf);
      localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.mPayInfo.BIq == 1)
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
      this.Bjr = getInput();
      this.Bjr.putParcelable("key_pay_info", this.mPayInfo);
      this.Bjr.putParcelable("key_bankcard", this.AYu);
      if (!bs.isNullOrNil(this.iXf)) {
        this.Bjr.putString("key_pwd1", this.iXf);
      }
      this.Bjr.putString("kreq_token", paramn.getToken());
      this.Bjr.putParcelable("key_authen", paramn.Bia);
      localObject1 = this.Bjr;
      if (!paramn.BhY)
      {
        bool = true;
        label980:
        ((Bundle)localObject1).putBoolean("key_need_verify_sms", bool);
        this.Bjr.putString("key_mobile", this.AYu.field_mobile);
        this.Bjr.putInt("key_err_code", paramInt2);
        this.Bjr.putParcelable("key_orders", this.wSu);
        if (!bs.isNullOrNil(paramString)) {
          break label1446;
        }
        paramString = getString(2131765705, new Object[] { this.AYu.field_desc, this.AYu.field_mobile });
      }
    }
    label1446:
    for (;;)
    {
      com.tencent.mm.ui.base.h.d(this, paramString, "", getString(2131765704), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69406);
          WalletPayUI.this.Bjr.putInt("key_pay_flag", 3);
          WalletPayUI.this.aq(WalletPayUI.this.Bjr);
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
      this.mPayInfo.DGL = paramInt2;
      epB();
      AppMethodBeat.o(69458);
      return true;
      this.mPayInfo.DGL = paramInt2;
      bool = false;
      if (paramInt2 == 100100) {
        bool = true;
      }
      if (this.Biy == null) {
        this.Biy = new a(this, this);
      }
      this.Biy.b(bool, this.mPayInfo.djq, this.mPayInfo.dac);
      ac.i(this.TAG, "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool)));
      AppMethodBeat.o(69458);
      return true;
      if ((this.AYu == null) || (this.wSu == null)) {
        break;
      }
      this.AYu.Bun = this.wSu.dac;
      if ((this.AYt != null) && (this.AYt.size() > 1)) {
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
      this.BjO = true;
      epS();
      if (paramInt2 == 416)
      {
        ac.e(this.TAG, "errCode is 416 need real name verify!");
        this.mPayResultType = 2;
        this.BjL = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
        paramString.putString("realname_verify_process_jump_plugin", "wallet");
        if (this.mPayInfo != null) {}
        for (paramInt1 = this.mPayInfo.dqL;; paramInt1 = 0)
        {
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramn, paramString, paramInt1);
          AppMethodBeat.o(69458);
          return bool;
        }
      }
      this.mPayResultType = 3;
      ac.i(this.TAG, "errCode is %d , not need real name verify!", new Object[] { Integer.valueOf(paramInt2) });
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
  
  protected final void tu(boolean paramBoolean)
  {
    AppMethodBeat.i(69446);
    if ((paramBoolean) && (!epT()))
    {
      AppMethodBeat.o(69446);
      return;
    }
    if (this.Bix != null)
    {
      this.Bjk = com.tencent.mm.plugin.wallet_core.ui.e.BBL.a(this.wSu);
      com.tencent.mm.plugin.wallet.a.j localj = this.Bjk.azE(this.Bix.Bwv);
      if ((localj == null) || (localj.BgK != 0.0D)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.BjQ != null)
      {
        if (this.BjQ.Bik == 0)
        {
          ac.i(this.TAG, "need real name,stop");
          b(this.BjQ);
          AppMethodBeat.o(69446);
          return;
        }
        if ((this.BjQ.Bik == 1) && (i != 0))
        {
          ac.i(this.TAG, "need real name, zero stop");
          b(this.BjQ);
        }
      }
      if (this.Bil != null)
      {
        if ((this.Bil.BhT == 1) && (!bs.isNullOrNil(this.Bil.unW)) && (!bs.isNullOrNil(this.Bil.unX)) && (!bs.isNullOrNil(this.Bil.BhU)))
        {
          if ((this.mPayInfo != null) && (this.wSu != null) && (this.wSu.BxR != null) && (this.wSu.BxR.size() > 0))
          {
            if (this.mPayInfo.dqL != 8) {
              break label371;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.wSu.BxR.get(0)).dad });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.Bil.BhU, "", this.Bil.unX, this.Bil.unW, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69389);
                ac.i(WalletPayUI.this.TAG, "click continue pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.wSu != null) && (WalletPayUI.this.wSu.BxR != null) && (WalletPayUI.this.wSu.BxR.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.dqL != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.h.wUl.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.wSu.BxR.get(0)).dad });
                }
                for (;;)
                {
                  WalletPayUI.g(WalletPayUI.this);
                  AppMethodBeat.o(69389);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.h.wUl.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.wSu.BxR.get(0)).dad });
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69390);
                ac.i(WalletPayUI.this.TAG, "click cancel pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.wSu != null) && (WalletPayUI.this.wSu.BxR != null) && (WalletPayUI.this.wSu.BxR.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.dqL != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.h.wUl.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.wSu.BxR.get(0)).dad });
                }
                for (;;)
                {
                  WalletPayUI.this.finish();
                  AppMethodBeat.o(69390);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.h.wUl.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.wSu.BxR.get(0)).dad });
                }
              }
            });
            AppMethodBeat.o(69446);
            return;
            label371:
            com.tencent.mm.plugin.report.service.h.wUl.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.wSu.BxR.get(0)).dad });
          }
        }
        if ((this.Bil.BhT == 2) && (!bs.isNullOrNil(this.Bil.BhU)) && (!bs.isNullOrNil(this.Bil.BhV)))
        {
          ac.i(this.TAG, "pay has been blocked");
          if ((this.mPayInfo != null) && (this.wSu != null) && (this.wSu.BxR != null) && (this.wSu.BxR.size() > 0))
          {
            if (this.mPayInfo.dqL != 8) {
              break label624;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.wSu.BxR.get(0)).dad });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.Bil.BhU, "", this.Bil.BhV, false, new DialogInterface.OnClickListener()
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
            com.tencent.mm.plugin.report.service.h.wUl.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.wSu.BxR.get(0)).dad });
          }
        }
      }
      epO();
      AppMethodBeat.o(69446);
      return;
    }
  }
  
  protected final void tv(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(69451);
    if (!aRK())
    {
      AppMethodBeat.o(69451);
      return;
    }
    this.BiA = false;
    ac.i(this.TAG, "pay with old bankcard! from statck %s", new Object[] { bs.eWi().toString() });
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label230;
      }
    }
    label230:
    for (Object localObject = "";; localObject = this.mPayInfo.dac)
    {
      af.f(i, (String)localObject, 8, "");
      if (this.BjE != null)
      {
        ac.w(this.TAG, "close previous cashier dialog");
        this.BjE.dismiss();
      }
      this.BiA = false;
      if (!ept()) {
        break label242;
      }
      this.BjE = new WcPayCashierDialog(getContext());
      localObject = (WcPayCashierDialog)this.BjE;
      PayInfo localPayInfo = this.mPayInfo;
      Orders localOrders = this.wSu;
      FavorPayInfo localFavorPayInfo = this.Bix;
      Bankcard localBankcard = this.AYu;
      if (!this.Bjo) {
        bool = true;
      }
      ((WcPayCashierDialog)localObject).a(localPayInfo, localOrders, localFavorPayInfo, localBankcard, bool, paramBoolean);
      ((WcPayCashierDialog)localObject).BKP = new WcPayCashierDialog.a()
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, Bankcard paramAnonymousBankcard)
        {
          AppMethodBeat.i(69392);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            ac.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.h.wUl.n(965L, 3L, 1L);
            AppMethodBeat.o(69392);
            return;
          }
          WalletPayUI.i(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.Bix = paramAnonymousFavorPayInfo;
          WalletPayUI.this.AYu = paramAnonymousBankcard;
          paramAnonymousBankcard = WalletPayUI.this.TAG;
          int i;
          if (WalletPayUI.this.Bix == null)
          {
            paramAnonymousFavorPayInfo = "";
            ac.i(paramAnonymousBankcard, "WalletPwdDialog showAlert with favinfo %s", new Object[] { paramAnonymousFavorPayInfo });
            if (!bs.isNullOrNil(paramAnonymousString))
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.dac)
          {
            af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.iXf = paramAnonymousString;
            WalletPayUI.this.tw(false);
            com.tencent.mm.plugin.wallet_core.utils.f.euN();
            AppMethodBeat.o(69392);
            return;
            paramAnonymousFavorPayInfo = WalletPayUI.this.Bix.toString();
            break;
            i = WalletPayUI.this.mPayInfo.dqL;
            break label131;
          }
        }
        
        public final void eoo()
        {
          AppMethodBeat.i(69394);
          ac.i(WalletPayUI.this.TAG, "click add new bankcard");
          Object localObject = com.tencent.mm.plugin.wallet_core.model.g.erb();
          if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bjw())
          {
            com.tencent.mm.ui.base.h.c(WalletPayUI.this.getContext(), ((com.tencent.mm.plugin.wallet_core.model.g)localObject).vwp, WalletPayUI.this.getString(2131755906), true);
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
          for (localObject = "";; localObject = WalletPayUI.this.mPayInfo.dac)
          {
            af.f(i, (String)localObject, 14, "");
            WalletPayUI.this.BjE.dismiss();
            WalletPayUI.this.BjE = null;
            WalletPayUI.this.epQ();
            AppMethodBeat.o(69394);
            return;
            i = WalletPayUI.this.mPayInfo.dqL;
            break;
          }
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(69393);
          ac.i(WalletPayUI.this.TAG, "cashier dialog canceled");
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
          for (String str = "";; str = WalletPayUI.this.mPayInfo.dac)
          {
            af.f(i, str, 10, "");
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            AppMethodBeat.o(69393);
            return;
            i = WalletPayUI.this.mPayInfo.dqL;
            break;
          }
        }
      };
      ((WcPayCashierDialog)localObject).show();
      addDialog((Dialog)localObject);
      AppMethodBeat.o(69451);
      return;
      i = this.mPayInfo.dqL;
      break;
    }
    label242:
    if (!this.Bjo) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.BjE = com.tencent.mm.plugin.wallet_core.ui.s.a(this, paramBoolean, this.wSu, this.Bix, this.AYu, this.mPayInfo, this.wMX, new s.c()new View.OnClickListener
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(69395);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            ac.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.h.wUl.n(965L, 3L, 1L);
            AppMethodBeat.o(69395);
            return;
          }
          WalletPayUI.k(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.Bix = paramAnonymousFavorPayInfo;
          String str = WalletPayUI.this.TAG;
          if (WalletPayUI.this.Bix == null) {}
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.Bix.toString())
          {
            ac.i(str, "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s", new Object[] { paramAnonymousFavorPayInfo, Boolean.valueOf(paramAnonymousBoolean) });
            if ((WalletPayUI.this.Bix == null) || (!paramAnonymousBoolean)) {
              break;
            }
            WalletPayUI.this.aJ(-100, true);
            AppMethodBeat.o(69395);
            return;
          }
          int i;
          if (!bs.isNullOrNil(paramAnonymousString))
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.dac)
          {
            af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.iXf = paramAnonymousString;
            WalletPayUI.this.tw(false);
            com.tencent.mm.plugin.wallet_core.utils.f.euN();
            WalletPayUI.this.Biz = null;
            AppMethodBeat.o(69395);
            return;
            i = WalletPayUI.this.mPayInfo.dqL;
            break;
          }
        }
      }, new View.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69396);
          ac.i(WalletPayUI.this.TAG, "WalletPwdDialog event1 %s", new Object[] { bs.eWi().toString() });
          WalletPayUI.this.Bix = ((FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUI.this.Bix != null) {
            WalletPayUI.this.Bix.Bwz = "";
          }
          WalletPayUI.this.d(false, 0, "");
          WalletPayUI.this.BjE.dismiss();
          WalletPayUI.this.iXf = null;
          WalletPayUI.this.BjE = null;
          WalletPayUI.this.Biz = null;
          AppMethodBeat.o(69396);
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          int i = 0;
          AppMethodBeat.i(69397);
          ac.i(WalletPayUI.this.TAG, "WalletPwdDialog event2 %s", new Object[] { bs.eWi().toString() });
          WalletPayUI.l(WalletPayUI.this);
          WalletPayUI.j(WalletPayUI.this);
          if (WalletPayUI.this.mPayInfo == null) {
            if (WalletPayUI.this.mPayInfo != null) {
              break label151;
            }
          }
          label151:
          for (String str = "";; str = WalletPayUI.this.mPayInfo.dac)
          {
            af.f(i, str, 10, "");
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            WalletPayUI.this.iXf = null;
            WalletPayUI.this.BjE = null;
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            WalletPayUI.this.Biz = null;
            AppMethodBeat.o(69397);
            return;
            i = WalletPayUI.this.mPayInfo.dqL;
            break;
          }
        }
      });
      this.Biz = ((com.tencent.mm.plugin.wallet_core.ui.f)this.BjE);
      AppMethodBeat.o(69451);
      return;
    }
  }
  
  protected void tw(boolean paramBoolean)
  {
    AppMethodBeat.i(69467);
    com.tencent.mm.plugin.wallet.pay.a.a.b localb = com.tencent.mm.plugin.wallet.pay.a.a.a(epL(), this.wSu, paramBoolean);
    if (this.wSu != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_reqKey", this.wSu.dac);
      if ((this.wSu.BxR != null) && (this.wSu.BxR.size() > 0)) {
        localBundle.putString("key_TransId", ((Orders.Commodity)this.wSu.BxR.get(0)).dad);
      }
      localBundle.putLong("key_SessionId", this.BjF);
      localb.setProcessName("PayProcess");
      localb.setProcessBundle(localBundle);
    }
    if (this.mPayInfo != null)
    {
      if ((this.mPayInfo.dqL != 6) || (this.mPayInfo.DGI != 100)) {
        break label255;
      }
      localb.setScene(100);
    }
    for (;;)
    {
      doSceneProgress(localb);
      if ((this.mPayInfo != null) && (8 == this.mPayInfo.dqL) && (this.mPayInfo.hbR != null))
      {
        long l = this.mPayInfo.hbR.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.wUl.f(13956, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - l) });
      }
      AppMethodBeat.o(69467);
      return;
      label255:
      localb.setScene(this.mPayInfo.dqL);
    }
  }
  
  protected final class a
  {
    protected a() {}
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(69426);
      WalletPayUI.this.BjC.removeAllViews();
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
        localCommodity = (Orders.Commodity)WalletPayUI.this.wSu.BxR.get(j);
        str2 = "";
        str1 = str2;
        if (WalletPayUI.this.mPayInfo != null) {
          if ((WalletPayUI.this.mPayInfo.dqL != 32) && (WalletPayUI.this.mPayInfo.dqL != 33) && (WalletPayUI.this.mPayInfo.dqL != 31))
          {
            str1 = str2;
            if (WalletPayUI.this.mPayInfo.dqL != 48) {}
          }
          else
          {
            str1 = WalletPayUI.this.mPayInfo.hbR.getString("extinfo_key_1", "");
            if (bs.isNullOrNil(str1)) {
              break label443;
            }
            com.tencent.mm.kernel.g.agS();
            ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(str1);
            if (localai == null) {
              break label418;
            }
            str1 = localai.aaS();
          }
        }
        label252:
        if (localCommodity != null)
        {
          if (bs.isNullOrNil(str1)) {
            break label461;
          }
          localTextView2.setText(str1);
          localTextView2.setVisibility(0);
          ((TextView)localView.findViewById(2131306799)).setVisibility(0);
          if (bs.isNullOrNil(localCommodity.desc)) {
            break label530;
          }
          localTextView1.setText(localCommodity.desc);
          localTextView1.setVisibility(8);
          ((TextView)localView.findViewById(2131306779)).setVisibility(8);
          if ((bs.isNullOrNil(str1)) && (bs.isNullOrNil(localCommodity.vxa))) {
            break label555;
          }
          localView.setVisibility(0);
        }
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        localView.measure(-2, -2);
        WalletPayUI.this.BjC.addView(localView);
        j += 1;
        break label41;
        if (WalletPayUI.this.Bjq)
        {
          i = WalletPayUI.this.mCount;
          break;
        }
        i = 1;
        break;
        label418:
        ac.e(WalletPayUI.this.TAG, "can not found contact for user::".concat(String.valueOf(str1)));
        str1 = str2;
        break label252;
        label443:
        ac.e(WalletPayUI.this.TAG, "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        str1 = str2;
        break label252;
        label461:
        if (!bs.isNullOrNil(localCommodity.vxa))
        {
          localTextView2.setText(localCommodity.vxa);
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
    int aFZ;
    WeakReference<WalletPayUI> lpX;
    long timestamp;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
 * JD-Core Version:    0.7.0.1
 */