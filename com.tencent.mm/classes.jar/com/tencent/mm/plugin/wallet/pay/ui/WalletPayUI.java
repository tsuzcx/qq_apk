package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.va;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vk.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.SimpleCashierInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.af;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.tenpay.model.n;
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
  private static boolean tWA;
  private static List<WalletPayUI.b> tWB;
  public String TAG;
  public String gJv;
  private boolean isPaySuccess;
  protected int mCount;
  protected PayInfo mPayInfo;
  private String qlK;
  protected com.tencent.mm.plugin.wallet.a qlj;
  private com.tencent.mm.sdk.b.c qoE;
  protected Button qqy;
  protected Orders qrf;
  protected ArrayList<Bankcard> tNG;
  protected Bankcard tNH;
  private com.tencent.mm.plugin.wallet.pay.a.d tVD;
  public FavorPayInfo tVQ;
  private a tVR;
  com.tencent.mm.plugin.wallet_core.ui.d tVS;
  private boolean tVT;
  private com.tencent.mm.plugin.wallet.pay.a.c.f tWC;
  protected com.tencent.mm.plugin.wallet_core.ui.b tWD;
  private boolean tWE;
  protected boolean tWF;
  private c.a tWG;
  protected boolean tWH;
  protected String tWI;
  protected boolean tWJ;
  public Bundle tWK;
  protected boolean tWL;
  protected TextView tWM;
  protected TextView tWN;
  private TextView tWO;
  protected TextView tWP;
  protected TextView tWQ;
  protected TextView tWR;
  protected ImageView tWS;
  private TextView tWT;
  private TextView tWU;
  protected LinearLayout tWV;
  protected WalletPayUI.a tWW;
  public Dialog tWX;
  private long tWY;
  private TextView tWZ;
  private LinearLayout tXa;
  private boolean tXb;
  private boolean tXc;
  private boolean tXd;
  private boolean tXe;
  private boolean tXf;
  private int tXg;
  private boolean tXh;
  private boolean tXi;
  private com.tencent.mm.plugin.wallet.pay.a.c.f tXj;
  private boolean tXk;
  private boolean tXl;
  private int tXm;
  private Runnable tXn;
  private WalletPayUI.b tXo;
  private long tXp;
  
  static
  {
    AppMethodBeat.i(46126);
    tWA = false;
    tWB = new ArrayList();
    AppMethodBeat.o(46126);
  }
  
  public WalletPayUI()
  {
    AppMethodBeat.i(46076);
    this.TAG = "MicroMsg.WalletPayUI";
    this.qrf = null;
    this.tWC = null;
    this.mCount = 0;
    this.gJv = null;
    this.tNG = null;
    this.tNH = null;
    this.tVQ = null;
    this.tWD = null;
    this.tWE = false;
    this.isPaySuccess = false;
    this.tWF = false;
    this.tWH = false;
    this.tWI = "";
    this.mPayInfo = null;
    this.tWJ = false;
    this.tWK = null;
    this.tWL = false;
    this.tWY = 0L;
    this.tXb = true;
    this.tXc = false;
    this.tXd = false;
    this.tXe = false;
    this.tXf = false;
    this.tXg = -1;
    this.tXh = false;
    this.tXi = false;
    this.qlj = null;
    this.tXk = false;
    this.tXl = false;
    this.tVD = null;
    this.tXm = 0;
    this.tXn = new WalletPayUI.1(this);
    this.tXp = 0L;
    this.qoE = new WalletPayUI.12(this);
    this.tVT = false;
    AppMethodBeat.o(46076);
  }
  
  private void Io(int paramInt)
  {
    AppMethodBeat.i(46077);
    this.tXm = paramInt;
    ab.i(this.TAG, "markForceFinish errorType %s %s", new Object[] { Integer.valueOf(paramInt), bo.dtY().toString() });
    AppMethodBeat.o(46077);
  }
  
  private void a(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    AppMethodBeat.i(46104);
    ab.i(this.TAG, "stopRealname realnameGuideFlag %s guide_type %s", new Object[] { paramf.cLV, Integer.valueOf(paramf.tVC) });
    label107:
    Object localObject;
    label148:
    int j;
    if (("1".equals(paramf.cLV)) || ("2".equals(paramf.cLV)))
    {
      this.tXj = paramf;
      this.tVD = paramf.tVD;
      this.tXh = true;
      this.qrf = paramf.qrf;
      if (this.qrf == null) {
        break label521;
      }
      i = this.qrf.ujl.size();
      this.mCount = i;
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("get mOrders! bankcardTag : ");
      if (this.qrf == null) {
        break label526;
      }
      paramf = Integer.valueOf(this.qrf.ubU);
      ab.d((String)localObject, paramf);
      asr();
      if ((this.qrf != null) && (this.qrf.ujm != null))
      {
        this.tWD = com.tencent.mm.plugin.wallet_core.ui.c.umO.a(this.qrf);
        if (this.tWD != null)
        {
          if (this.tWD.cVp().size() > 0) {
            this.tWE = true;
          }
          this.tVQ = this.tWD.afG(this.qrf.ujm.tUf);
          this.tVQ.uhU = this.tWD.afH(this.tVQ.uhU);
          ab.i(this.TAG, "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", new Object[] { this.qrf.ujm.tUf, this.tVQ.uhU, this.tVQ.uhU, this.tVQ.toString() });
        }
      }
      if ((this.qrf != null) && (this.tNG != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.d.a(this.mPayInfo, this.qrf);
        paramf = com.tencent.mm.plugin.report.service.h.qsU;
        j = this.mPayInfo.cCD;
        s.cRG();
        if (!s.cRH().cUl()) {
          break label532;
        }
      }
    }
    label521:
    label526:
    label532:
    for (int i = 2;; i = 1)
    {
      paramf.e(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.qrf.cnL * 100.0D)), this.qrf.ppp });
      if ((this.qrf == null) || (this.qrf.ujl == null)) {
        break label596;
      }
      paramf = new LinkedList();
      localObject = this.qrf.ujl.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramf.add(((Orders.Commodity)((Iterator)localObject).next()).cnJ);
      }
      this.tXj = null;
      break;
      i = 0;
      break label107;
      paramf = "";
      break label148;
    }
    if (paramf.size() > 0)
    {
      localObject = new vj();
      ((vj)localObject).cMx.cMz = paramf;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.qlj != null) {
        this.qlj.bs(10001, (String)paramf.get(0));
      }
    }
    label596:
    if ((this.qrf != null) && (this.qrf.ujJ != null) && (this.qrf.ujJ.ukG == 1) && (!bo.isNullOrNil(this.qrf.ujJ.por)))
    {
      this.tWH = true;
      this.tWI = this.qrf.ujJ.por;
    }
    s.cRG();
    this.tNG = s.cRH().nI(cSm());
    if (!bo.isNullOrNil(this.tWI))
    {
      this.tNH = cSj();
      paramf = bo.bf(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!bo.isNullOrNil(paramf)) {
        this.tNH = afd(paramf);
      }
      this.qqy.setClickable(true);
      if (bo.isNullOrNil(t.cTN().uma)) {
        break label1028;
      }
      this.tWT.setVisibility(0);
      this.tWT.setText(t.cTN().uma);
      label771:
      if ((this.qrf != null) && (this.tNG != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.d.a(this.mPayInfo, this.qrf);
        paramf = com.tencent.mm.plugin.report.service.h.qsU;
        j = this.mPayInfo.cCD;
        s.cRG();
        if (!s.cRH().cUl()) {
          break label1049;
        }
        i = 2;
        label830:
        paramf.e(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.qrf.cnL * 100.0D)), this.qrf.ppp });
      }
      if (this.tXc) {
        ar(0, false);
      }
      if (getPayInfo().wgv != null) {
        break label1054;
      }
    }
    label1028:
    label1049:
    label1054:
    for (long l = 0L;; l = getPayInfo().wgv.getLong("wallet_pay_key_check_time"))
    {
      if (l > 0L)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(641L, 4L, 1L, true);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(641L, 5L, bo.hl(l), true);
      }
      if (this.tXp > 0L)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(641L, 7L, 1L, true);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(641L, 8L, bo.hl(this.tXp), true);
      }
      AppMethodBeat.o(46104);
      return;
      s.cRG();
      this.tNH = s.cRH().a(null, null, cSm(), false);
      break;
      this.tWT.setVisibility(8);
      this.tWT.setText("");
      break label771;
      i = 1;
      break label830;
    }
  }
  
  private Bankcard afd(String paramString)
  {
    AppMethodBeat.i(46108);
    s.cRG();
    Object localObject = s.cRH().nH(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (bo.nullAsNil(paramString).equals(localBankcard.field_bindSerial))
        {
          ab.i(this.TAG, "hy: get given bankcard");
          AppMethodBeat.o(46108);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(46108);
    return null;
  }
  
  private boolean b(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    int i = 0;
    AppMethodBeat.i(46121);
    boolean bool;
    if ("1".equals(paramf.cLV))
    {
      ab.i(this.TAG, "need realname verify");
      this.tXe = true;
      paramf = new Bundle();
      paramf.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
      paramf.putString("realname_verify_process_jump_plugin", "wallet");
      isTransparent();
      if (this.mPayInfo != null) {
        i = this.mPayInfo.cCD;
      }
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf, null, i);
      AppMethodBeat.o(46121);
      return bool;
    }
    if ("2".equals(paramf.cLV))
    {
      ab.i(this.TAG, "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf.cLW, paramf.cLZ, paramf.cLX, paramf.cLY, isTransparent(), null);
      AppMethodBeat.o(46121);
      return bool;
    }
    ab.i(this.TAG, "realnameGuideFlag =  " + paramf.cLV);
    AppMethodBeat.o(46121);
    return false;
  }
  
  private boolean cRK()
  {
    AppMethodBeat.i(138087);
    int i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJq, Integer.valueOf(0))).intValue();
    if ((com.tencent.mm.sdk.a.b.dsf()) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE)) {
      i = 1;
    }
    if ((i == 1) || ((this.qrf != null) && (this.qrf.ujI == 1)))
    {
      AppMethodBeat.o(138087);
      return true;
    }
    AppMethodBeat.o(138087);
    return false;
  }
  
  private boolean cRY()
  {
    AppMethodBeat.i(46079);
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("intent_pay_end")))
    {
      ab.i(this.TAG, "hy: pay end. finish the activity");
      if (localBundle.getBoolean("intent_pay_end", false))
      {
        ab.d(this.TAG, "pay done... errCode:" + localBundle.getInt("intent_pay_end_errcode"));
        ab.d(this.TAG, "pay done INTENT_PAY_APP_URL:" + localBundle.getString("intent_pay_app_url"));
        ab.d(this.TAG, "pay done INTENT_PAY_END:" + localBundle.getBoolean("intent_pay_end", false));
        l(-1, getIntent());
      }
      for (this.isPaySuccess = true;; this.isPaySuccess = false)
      {
        AppMethodBeat.o(46079);
        return true;
        ab.d(this.TAG, "pay cancel");
        l(0, getIntent());
      }
    }
    if ((localBundle != null) && (localBundle.getBoolean("key_is_realname_verify_process")))
    {
      switch (localBundle.getInt("realname_verify_process_ret", 0))
      {
      default: 
        AppMethodBeat.o(46079);
        return false;
      }
      AppMethodBeat.o(46079);
      return true;
    }
    ab.i(this.TAG, "hy: pay not end");
    AppMethodBeat.o(46079);
    return false;
  }
  
  private void cSa()
  {
    AppMethodBeat.i(46089);
    if (this.qrf == null)
    {
      ab.e(this.TAG, "updatePaymentMethodForFavor mOrders is null");
      AppMethodBeat.o(46089);
      return;
    }
    this.tWR.setVisibility(8);
    this.tWQ.setVisibility(8);
    this.qqy.setText(2131305443);
    this.tWZ.setVisibility(0);
    this.tXa.setVisibility(0);
    View localView = this.tXa.findViewById(2131829338);
    Object localObject = this.tXa.findViewById(2131829342);
    CheckedTextView localCheckedTextView1;
    CheckedTextView localCheckedTextView2;
    int i;
    if ("CFT".equals(this.qrf.ujh))
    {
      ((View)localObject).setVisibility(8);
      localCheckedTextView1 = (CheckedTextView)this.tXa.findViewById(2131829341);
      localCheckedTextView2 = (CheckedTextView)this.tXa.findViewById(2131829347);
      localView.setEnabled(true);
      if ((this.qrf == null) || (this.qrf.ujl == null) || (this.qrf.ujl.size() <= 0)) {
        break label772;
      }
      if (this.qrf.uiW != 1) {
        break label574;
      }
      i = 1;
    }
    label772:
    for (;;)
    {
      label200:
      if (this.tNH == null)
      {
        localView.setVisibility(8);
        label213:
        ((View)localObject).setOnClickListener(new WalletPayUI.32(this, localCheckedTextView1, localCheckedTextView2));
        this.tWZ.setVisibility(0);
        this.tXa.setVisibility(0);
        if (this.tVQ == null) {
          break label767;
        }
        this.tWD = com.tencent.mm.plugin.wallet_core.ui.c.umO.a(this.qrf);
        localObject = this.tWD.afD(this.tVQ.uhU);
        if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).tUe != 0.0D)) {
          break label767;
        }
        this.tXa.setVisibility(8);
        this.tWZ.setVisibility(8);
      }
      label486:
      label767:
      for (int j = 1;; j = 0)
      {
        this.tXb = true;
        if (j != 0) {
          this.tXb = false;
        }
        localCheckedTextView1.setChecked(false);
        localCheckedTextView2.setChecked(true);
        ab.i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.qrf.ujn);
        if (this.qrf.ujn == 1)
        {
          this.tXa.findViewById(2131829344).setVisibility(0);
          ((TextView)this.tXa.findViewById(2131829345)).setText(this.qrf.ujo);
          if (!TextUtils.isEmpty(this.qrf.ujp))
          {
            ((TextView)this.tXa.findViewById(2131829346)).setText(" (" + this.qrf.ujp + ")");
            if ((this.tNH != null) && (this.tNH.cTf()) && (!TextUtils.isEmpty(this.tNH.field_forbidWord)))
            {
              localView.setEnabled(false);
              localCheckedTextView1.setVisibility(8);
              ((TextView)this.tXa.findViewById(2131829340)).setText(this.tNH.field_forbidWord);
            }
          }
        }
        for (;;)
        {
          cSb();
          AppMethodBeat.o(46089);
          return;
          ((View)localObject).setVisibility(0);
          break;
          i = 0;
          break label200;
          localView.setVisibility(0);
          localView.setOnClickListener(new WalletPayUI.31(this, localCheckedTextView1, localCheckedTextView2));
          break label213;
          ((TextView)this.tXa.findViewById(2131829346)).setText("");
          break label486;
          this.tXa.findViewById(2131829344).setVisibility(8);
          if ((this.tNH != null) && (this.tNH.cTf()) && (!TextUtils.isEmpty(this.tNH.field_forbidWord)))
          {
            localView.setEnabled(false);
            localCheckedTextView1.setVisibility(8);
            ((TextView)this.tXa.findViewById(2131829340)).setText(this.tNH.field_forbidWord);
          }
          else if ((this.tNH != null) && (this.tNH.cTf()) && (TextUtils.isEmpty(this.tNH.field_forbidWord)) && (i == 0))
          {
            localCheckedTextView1.setChecked(true);
            localCheckedTextView2.setChecked(false);
            this.tXb = false;
          }
        }
      }
      label574:
      i = 0;
    }
  }
  
  private void cSb()
  {
    AppMethodBeat.i(46090);
    if (this.tXb)
    {
      this.qqy.setOnClickListener(new WalletPayUI.2(this));
      AppMethodBeat.o(46090);
      return;
    }
    this.qqy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(46036);
        WalletPayUI.this.cSf();
        AppMethodBeat.o(46036);
      }
    });
    AppMethodBeat.o(46090);
  }
  
  private void cSg()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(46096);
    com.tencent.mm.plugin.report.service.h.qsU.e(13958, new Object[] { Integer.valueOf(1) });
    if ((this.mPayInfo != null) && (8 == this.mPayInfo.cCD))
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(13955, new Object[] { Integer.valueOf(2) });
      if (this.mPayInfo.wgv != null)
      {
        long l = this.mPayInfo.wgv.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.qsU.e(13956, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    Object localObject;
    if (this.tVQ != null)
    {
      this.tWD = com.tencent.mm.plugin.wallet_core.ui.c.umO.a(this.qrf);
      localObject = this.tWD.afD(this.tVQ.uhU);
      if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).tUe != 0.0D)) {}
    }
    for (;;)
    {
      if (i != 0)
      {
        s.cRG();
        if (s.cRH().cUm())
        {
          ab.i(this.TAG, "payWithoutPassword zeroPay");
          if (this.mPayInfo == null)
          {
            i = k;
            if (this.mPayInfo != null) {
              break label258;
            }
          }
          label258:
          for (localObject = "";; localObject = this.mPayInfo.cnI)
          {
            ad.e(i, (String)localObject, 3, "");
            cSh();
            AppMethodBeat.o(46096);
            return;
            i = this.mPayInfo.cCD;
            break;
          }
        }
        ab.i(this.TAG, "has useful bankcard ! payWithOldBankcard zeroPay");
        cRT();
        AppMethodBeat.o(46096);
        return;
      }
      if (this.tWH)
      {
        ab.i(this.TAG, "hy: start do pay with force use given bankcard");
        if (!bo.isNullOrNil(this.tWI))
        {
          this.tNH = cSj();
          cRT();
          AppMethodBeat.o(46096);
          return;
        }
        s.cRG();
        if (s.cRH().cUn()) {
          if (this.mPayInfo == null)
          {
            i = 0;
            if (this.mPayInfo != null) {
              break label406;
            }
            localObject = "";
            label370:
            ad.e(i, (String)localObject, 17, "");
          }
        }
        label406:
        do
        {
          b(false, 0, "");
          AppMethodBeat.o(46096);
          return;
          i = this.mPayInfo.cCD;
          break;
          localObject = this.mPayInfo.cnI;
          break label370;
          s.cRG();
        } while (!s.cRH().cUm());
        if (this.mPayInfo == null)
        {
          i = 0;
          label440:
          if (this.mPayInfo != null) {
            break label474;
          }
        }
        label474:
        for (localObject = "";; localObject = this.mPayInfo.cnI)
        {
          ad.e(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.cCD;
          break label440;
        }
      }
      localObject = bo.bf(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!bo.isNullOrNil((String)localObject)) {
        this.tNH = afd((String)localObject);
      }
      if (this.tNH == null)
      {
        if ((this.tNG != null) && (this.tNG.size() > 0))
        {
          ab.i(this.TAG, " no last pay bankcard ! jump to select bankcard!");
          c(false, 8, "");
          AppMethodBeat.o(46096);
          return;
        }
        ab.i(this.TAG, "default bankcard not found! payWithNewBankcard");
        s.cRG();
        if (s.cRH().cUn()) {
          if (this.mPayInfo == null)
          {
            i = 0;
            if (this.mPayInfo != null) {
              break label650;
            }
            localObject = "";
            label614:
            ad.e(i, (String)localObject, 17, "");
          }
        }
        label650:
        do
        {
          b(false, 0, "");
          AppMethodBeat.o(46096);
          return;
          i = this.mPayInfo.cCD;
          break;
          localObject = this.mPayInfo.cnI;
          break label614;
          s.cRG();
        } while (!s.cRH().cUm());
        if (this.mPayInfo == null)
        {
          i = 0;
          label684:
          if (this.mPayInfo != null) {
            break label718;
          }
        }
        label718:
        for (localObject = "";; localObject = this.mPayInfo.cnI)
        {
          ad.e(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.cCD;
          break label684;
        }
      }
      i = this.tNH.a(this.qrf.ubU, this.qrf);
      if (this.qlj != null) {
        this.qlj.bs(10002, "");
      }
      if (i != 0)
      {
        ab.i(this.TAG, "main bankcard(" + i + ") is useless! jump to select bankcard!");
        c(false, i, "");
        AppMethodBeat.o(46096);
        return;
      }
      s.cRG();
      if (s.cRH().cUm())
      {
        ab.i(this.TAG, "payWithoutPassword");
        if (this.mPayInfo == null)
        {
          i = j;
          if (this.mPayInfo != null) {
            break label891;
          }
        }
        label891:
        for (localObject = "";; localObject = this.mPayInfo.cnI)
        {
          ad.e(i, (String)localObject, 3, "");
          cSh();
          AppMethodBeat.o(46096);
          return;
          i = this.mPayInfo.cCD;
          break;
        }
      }
      ab.i(this.TAG, "has useful bankcard ! payWithOldBankcard");
      cRT();
      AppMethodBeat.o(46096);
      return;
      i = 0;
    }
  }
  
  private void cSh()
  {
    AppMethodBeat.i(46097);
    nB(true);
    com.tencent.mm.plugin.wallet_core.utils.d.cWY();
    AppMethodBeat.o(46097);
  }
  
  private Bankcard cSj()
  {
    AppMethodBeat.i(46107);
    s.cRG();
    Object localObject = s.cRH().nH(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (bo.nullAsNil(this.tWI).equals(localBankcard.field_bindSerial))
        {
          ab.i(this.TAG, "hy: get given bankcard");
          AppMethodBeat.o(46107);
          return localBankcard;
        }
      }
    }
    AppMethodBeat.o(46107);
    return null;
  }
  
  private boolean cSk()
  {
    AppMethodBeat.i(46112);
    if (isTransparent())
    {
      setContentViewVisibility(4);
      af.o(this, 0);
      AppMethodBeat.o(46112);
      return false;
    }
    setContentViewVisibility(0);
    af.o(this, getActionbarColor());
    AppMethodBeat.o(46112);
    return true;
  }
  
  private boolean cSl()
  {
    AppMethodBeat.i(46115);
    if ((this.qrf != null) && (this.qrf.ujd))
    {
      com.tencent.mm.kernel.g.RM();
      if (((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(196614, Boolean.TRUE)).booleanValue())
      {
        Object localObject = getLayoutInflater().inflate(2130971230, null);
        CheckBox localCheckBox = (CheckBox)((View)localObject).findViewById(2131829326);
        et((View)localObject);
        ((TextView)((View)localObject).findViewById(2131823916)).setOnClickListener(new WalletPayUI.21(this, localCheckBox));
        localObject = com.tencent.mm.ui.base.h.a(this, getString(2131305488), (View)localObject, getString(2131304992), getString(2131305583), new WalletPayUI.22(this, localCheckBox), new WalletPayUI.24(this));
        ((com.tencent.mm.ui.widget.b.c)localObject).setCancelable(false);
        localCheckBox.setOnCheckedChangeListener(new WalletPayUI.25(this, (com.tencent.mm.ui.widget.b.c)localObject));
        AppMethodBeat.o(46115);
        return false;
      }
    }
    AppMethodBeat.o(46115);
    return true;
  }
  
  private void et(View paramView)
  {
    AppMethodBeat.i(46116);
    paramView = (TextView)paramView.findViewById(2131826532);
    paramView.setText(Html.fromHtml(String.format(getResources().getString(2131305486), new Object[] { getResources().getString(2131304781) })));
    paramView.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(46116);
  }
  
  private void l(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(46086);
    if ((this.mPayInfo != null) && (this.mPayInfo.cCD == 46) && (this.qrf != null))
    {
      paramIntent.putExtra("key_total_fee", this.qrf.cnL);
      ab.i(this.TAG, "sentCancelEvent set fee:%s", new Object[] { Double.valueOf(this.qrf.cnL) });
    }
    vk localvk = new vk();
    localvk.cMA.intent = paramIntent;
    vk.a locala;
    if (this.tXm == 1)
    {
      localvk.cMA.cMB = 1000;
      localvk.cMA.result = paramInt;
      locala = localvk.cMA;
      if (this.mPayInfo != null) {
        break label217;
      }
    }
    label217:
    for (paramIntent = "";; paramIntent = this.mPayInfo.cnI)
    {
      locala.cnI = paramIntent;
      localvk.cMA.cMD = 1;
      if ((this.mPayInfo != null) && (paramInt == 0)) {
        com.tencent.mm.plugin.wallet.pay.a.b.b.av(this.mPayInfo.cnI, this.mPayInfo.cCD, this.mPayInfo.cCy);
      }
      com.tencent.mm.sdk.b.a.ymk.l(localvk);
      AppMethodBeat.o(46086);
      return;
      if (this.tXm != 2) {
        break;
      }
      localvk.cMA.cMB = 1001;
      break;
    }
  }
  
  protected void Z(Bundle paramBundle)
  {
    AppMethodBeat.i(46118);
    this.tWF = true;
    if (this.qrf != null)
    {
      paramBundle.putInt("key_support_bankcard", this.qrf.ubU);
      paramBundle.putString("key_reqKey", this.qrf.cnI);
      if ((this.qrf.ujl != null) && (this.qrf.ujl.size() > 0)) {
        paramBundle.putString("key_TransId", ((Orders.Commodity)this.qrf.ujl.get(0)).cnJ);
      }
      paramBundle.putLong("key_SessionId", this.tWY);
    }
    if (this.mPayInfo != null) {
      paramBundle.putInt("key_scene", this.mPayInfo.cCD);
    }
    if (!cSe()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      paramBundle.putInt("is_deduct_open", this.tXg);
      this.tWG = new WalletPayUI.26(this);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, paramBundle, this.tWG);
      AppMethodBeat.o(46118);
      return;
    }
  }
  
  protected final void ar(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(46103);
    com.tencent.mm.plugin.report.service.h.qsU.e(13958, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.h.qsU.e(13955, new Object[] { Integer.valueOf(4) });
    if (this.mPayInfo == null) {
      if (this.mPayInfo != null) {
        break label226;
      }
    }
    label226:
    for (Object localObject = "";; localObject = this.mPayInfo.cnI)
    {
      ad.e(i, (String)localObject, 11, "");
      localObject = getInput();
      ((Bundle)localObject).putInt("key_main_bankcard_state", paramInt);
      ((Bundle)localObject).putParcelable("key_orders", this.qrf);
      ((Bundle)localObject).putParcelable("key_pay_info", this.mPayInfo);
      ((Bundle)localObject).putParcelable("key_authen", cSd());
      ((Bundle)localObject).putString("key_pwd1", this.gJv);
      ((Bundle)localObject).putInt("key_pay_flag", 3);
      ((Bundle)localObject).putInt("key_err_code", -1004);
      ((Bundle)localObject).putParcelable("key_favor_pay_info", this.tVQ);
      ((Bundle)localObject).putBoolean("key_is_filter_bank_type", paramBoolean);
      if (this.tNH != null) {
        ((Bundle)localObject).putString("key_is_cur_bankcard_bind_serial", this.tNH.field_bindSerial);
      }
      Z((Bundle)localObject);
      AppMethodBeat.o(46103);
      return;
      i = this.mPayInfo.cCD;
      break;
    }
  }
  
  protected final boolean asr()
  {
    AppMethodBeat.i(46106);
    String str2;
    String str1;
    if ((this.qrf == null) || (this.qrf.ujl == null) || (this.qrf.ujl.size() <= 0))
    {
      ab.w(this.TAG, "mOrders info is Illegal!");
      if ((this.tWC != null) && (this.tWC.isJumpRemind()))
      {
        AppMethodBeat.o(46106);
        return false;
      }
      str2 = getString(2131305336);
      str1 = str2;
      if (this.tWC != null)
      {
        str1 = str2;
        if (!bo.isNullOrNil(this.tWC.errMsg)) {
          str1 = this.tWC.errMsg;
        }
      }
      ab.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.a(getContext(), str1, "", new WalletPayUI.19(this));
      AppMethodBeat.o(46106);
      return false;
    }
    if ((this.tWH) && (!bo.isNullOrNil(this.tWI)) && (cSj() == null))
    {
      if ((this.tWC != null) && (this.tWC.isJumpRemind()))
      {
        AppMethodBeat.o(46106);
        return false;
      }
      ab.w(this.TAG, "hy: should use given bankcard, but resolved as null. show error msg and quit");
      str2 = getString(2131305336);
      str1 = str2;
      if (this.tWC != null)
      {
        str1 = str2;
        if (!bo.isNullOrNil(this.tWC.errMsg)) {
          str1 = this.tWC.errMsg;
        }
      }
      ab.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.a(getContext(), str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(46058);
          WalletPayUI.this.finish();
          AppMethodBeat.o(46058);
        }
      });
      AppMethodBeat.o(46106);
      return false;
    }
    AppMethodBeat.o(46106);
    return true;
  }
  
  protected final void b(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(46100);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
    s.cRG();
    ab.d(str, s.cRH().cUl() + ", need confirm ? " + paramBoolean);
    if (paramBoolean)
    {
      if (!bo.isNullOrNil(paramString)) {
        break label130;
      }
      paramString = Bankcard.aa(this, paramInt);
    }
    label130:
    for (;;)
    {
      com.tencent.mm.ui.base.h.d(this, paramString, "", getString(2131305446), getString(2131296888), new WalletPayUI.11(this), new WalletPayUI.13(this));
      AppMethodBeat.o(46100);
      return;
      cSi();
      AppMethodBeat.o(46100);
      return;
    }
  }
  
  protected final void bJ()
  {
    AppMethodBeat.i(46088);
    if ((this.qrf != null) && (this.qrf.ujl != null) && (this.qrf.ujl.size() > 0))
    {
      this.tWM.setText(com.tencent.mm.wallet_core.ui.e.E(this.qrf.cnL));
      this.tWP.setText(com.tencent.mm.wallet_core.ui.e.awa(this.qrf.ppp));
      this.tWW.notifyDataSetChanged();
      if (this.qrf.ujl.size() > 1)
      {
        this.tWS.setVisibility(0);
        this.tWN.setText(getString(2131305493, new Object[] { ((Orders.Commodity)this.qrf.ujl.get(0)).desc, this.qrf.ujl.size() }));
        this.tWJ = false;
      }
    }
    else
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.cCD == 48)) {
        this.tWN.setText(2131302211);
      }
      this.tWQ.setVisibility(8);
      this.tWR.setVisibility(8);
      this.tWZ.setVisibility(8);
      this.tXa.setVisibility(8);
      this.qqy.setText(2131305443);
      if ((this.tNH == null) || (!this.tNH.cTf())) {
        break label542;
      }
      if (bo.isNullOrNil(this.tNH.field_forbidWord)) {
        break label522;
      }
      this.tWQ.setText(this.tNH.field_forbidWord);
      this.tWQ.setVisibility(4);
      this.tWR.setVisibility(8);
      s.cRG();
      if (s.cRH().cUm()) {
        cSa();
      }
      label329:
      s.cRG();
      if (!s.cRH().cUm())
      {
        s.cRG();
        if (!s.cRH().cUn()) {
          break label590;
        }
      }
    }
    label424:
    label571:
    label590:
    for (int i = 1;; i = 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131829332);
      if ((i != 0) && (this.tVQ != null) && (this.tWD != null) && (this.tWE) && (this.qrf != null))
      {
        cSc();
        this.tWU.setOnClickListener(new WalletPayUI.30(this));
        localLinearLayout.setVisibility(0);
        if ((this.qrf == null) || (this.tNG == null) || (this.mPayInfo == null)) {
          break label571;
        }
        this.qqy.setClickable(true);
        this.qqy.setEnabled(true);
      }
      for (;;)
      {
        if (this.qrf == null) {
          this.tWR.setVisibility(8);
        }
        AppMethodBeat.o(46088);
        return;
        this.tWN.setText(((Orders.Commodity)this.qrf.ujl.get(0)).desc);
        this.tWS.setVisibility(8);
        break;
        s.cRG();
        if (!s.cRH().cUm()) {
          break label329;
        }
        cSa();
        break label329;
        s.cRG();
        if (!s.cRH().cUn()) {
          break label329;
        }
        cSa();
        break label329;
        localLinearLayout.setVisibility(8);
        break label424;
        this.qqy.setClickable(false);
        this.qqy.setEnabled(false);
      }
    }
  }
  
  public final void c(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(46101);
    ab.d(this.TAG, "pay with select bankcard! need confirm ? ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (!bo.isNullOrNil(paramString)) {
        break label118;
      }
      paramString = Bankcard.aa(this, paramInt);
    }
    label118:
    for (;;)
    {
      com.tencent.mm.ui.base.h.d(this, paramString, "", getString(2131305465), getString(2131296888), new WalletPayUI.14(this, paramInt), new WalletPayUI.15(this));
      AppMethodBeat.o(46101);
      return;
      if (cRK())
      {
        nA(true);
        AppMethodBeat.o(46101);
        return;
      }
      ar(paramInt, false);
      AppMethodBeat.o(46101);
      return;
    }
  }
  
  public final void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(46119);
    ab.i(this.TAG, "onGenFinish callback");
    if (paramBoolean)
    {
      ab.i(this.TAG, "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.cwl = paramString1;
      this.mPayInfo.cwm = paramString2;
      nB(false);
      com.tencent.mm.plugin.wallet_core.utils.d.cWY();
      AppMethodBeat.o(46119);
      return;
    }
    ab.e(this.TAG, "onGenFinish callback, result.isSuccess is false");
    nB(false);
    com.tencent.mm.plugin.wallet_core.utils.d.cWY();
    AppMethodBeat.o(46119);
  }
  
  protected void cRT()
  {
    AppMethodBeat.i(46098);
    nA(false);
    AppMethodBeat.o(46098);
  }
  
  protected void cRZ()
  {
    int i = 2;
    AppMethodBeat.i(46081);
    com.tencent.mm.plugin.report.service.h.qsU.e(11850, new Object[] { Integer.valueOf(2), Integer.valueOf(this.mPayInfo.cCD) });
    if (this.mPayInfo.cCD == 11) {
      i = 3;
    }
    Object localObject = this.mPayInfo;
    if ((localObject == null) || (bo.isNullOrNil(((PayInfo)localObject).cnI)))
    {
      ab.i("MicroMsg.CgiManager", "no payInfo or reqKey");
      localObject = null;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessName("PayProcess");
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessSessionId(this.tWY);
        if ((this.mPayInfo.cCD != 6) || (this.mPayInfo.wgs != 100)) {
          break label446;
        }
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(100);
        label134:
        if (!this.mPayInfo.wgt) {
          break label460;
        }
      }
    }
    label446:
    label460:
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress((com.tencent.mm.ai.m)localObject, true, bool);
      AppMethodBeat.o(46081);
      return;
      String str = ((PayInfo)localObject).cnI;
      ab.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", new Object[] { str });
      ab.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
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
      ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(this.mPayInfo.cCD);
      break label134;
    }
  }
  
  public final void cSc()
  {
    AppMethodBeat.i(46091);
    com.tencent.mm.plugin.wallet.a.j localj = this.tWD.afD(this.tVQ.uhU);
    List localList = this.tWD.cVp();
    com.tencent.mm.plugin.wallet.a.h localh = this.tWD.umI;
    Object localObject1 = "";
    double d2;
    Object localObject2;
    int i;
    double d1;
    if (localj != null)
    {
      d2 = localj.tUm;
      if (d2 > 0.0D)
      {
        localObject2 = localj.tUo;
        int j = 1;
        localObject1 = localObject2;
        i = j;
        d1 = d2;
        if (!bo.isNullOrNil(localj.tUp))
        {
          localObject1 = (String)localObject2 + "," + localj.tUp;
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
          localObject2 = (String)localObject1 + getContext().getString(2131305527);
        }
      }
      if ((d1 > 0.0D) && (localh != null) && (localh.tUi == 0))
      {
        if (localj != null) {
          this.tWM.setText(com.tencent.mm.wallet_core.ui.e.E(localj.tUl));
        }
        this.tWP.setText(com.tencent.mm.wallet_core.ui.e.awa(this.qrf.ppp));
        this.tWO.setText(com.tencent.mm.wallet_core.ui.e.e(this.qrf.cnL, this.qrf.ppp));
        this.tWO.setVisibility(0);
      }
      for (;;)
      {
        if (!bo.isNullOrNil((String)localObject2)) {
          this.tWU.setText((CharSequence)localObject2);
        }
        AppMethodBeat.o(46091);
        return;
        this.tWM.setText(com.tencent.mm.wallet_core.ui.e.E(this.qrf.cnL));
        this.tWP.setText(com.tencent.mm.wallet_core.ui.e.awa(this.qrf.ppp));
        this.tWO.setVisibility(8);
      }
      i = 0;
      d1 = d2;
      continue;
      i = 0;
      d1 = 0.0D;
    }
  }
  
  protected final Authen cSd()
  {
    AppMethodBeat.i(46092);
    Authen localAuthen = new Authen();
    if (cSe()) {}
    for (localAuthen.bsY = 3;; localAuthen.bsY = 6)
    {
      if (!bo.isNullOrNil(this.gJv)) {
        localAuthen.ueW = this.gJv;
      }
      if (this.tNH != null)
      {
        localAuthen.por = this.tNH.field_bindSerial;
        localAuthen.poq = this.tNH.field_bankcardType;
      }
      if ((this.tVQ != null) && (this.tWD != null) && (this.tWD.cVm()))
      {
        localAuthen.ufh = this.tVQ.uhU;
        localAuthen.ufg = this.tVQ.uhX;
      }
      localAuthen.pVo = this.mPayInfo;
      AppMethodBeat.o(46092);
      return localAuthen;
    }
  }
  
  protected final boolean cSe()
  {
    AppMethodBeat.i(46093);
    if ((this.tNH != null) && (this.qrf != null) && (this.qrf.ubU == 3))
    {
      if (this.tNH.cTi())
      {
        AppMethodBeat.o(46093);
        return true;
      }
      AppMethodBeat.o(46093);
      return false;
    }
    if ((this.qrf != null) && (!Bankcard.Ix(this.qrf.ubU)))
    {
      AppMethodBeat.o(46093);
      return true;
    }
    AppMethodBeat.o(46093);
    return false;
  }
  
  protected final void cSf()
  {
    AppMethodBeat.i(46094);
    nz(true);
    AppMethodBeat.o(46094);
  }
  
  protected final void cSi()
  {
    AppMethodBeat.i(46102);
    Bundle localBundle = getIntent().getExtras();
    s.cRG();
    if (s.cRH().cUl()) {}
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("key_pay_flag", i);
      localBundle.putParcelable("key_orders", this.qrf);
      localBundle.putParcelable("key_pay_info", this.mPayInfo);
      localBundle.putParcelable("key_favor_pay_info", this.tVQ);
      Z(localBundle);
      AppMethodBeat.o(46102);
      return;
    }
  }
  
  protected final boolean cSm()
  {
    return (this.mPayInfo != null) && (this.mPayInfo.cCD != 11);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(46113);
    if (paramInt == 0)
    {
      if (isTransparent())
      {
        finish();
        AppMethodBeat.o(46113);
      }
    }
    else if (paramInt == 1) {
      cRT();
    }
    AppMethodBeat.o(46113);
  }
  
  public void finish()
  {
    AppMethodBeat.i(46083);
    ab.i(this.TAG, "finish %s %s mPayResultType:%s", new Object[] { Integer.valueOf(hashCode()), bo.dtY().toString(), Integer.valueOf(this.mPayResultType) });
    cancelQRPay();
    if ((this.qrf != null) && (!this.qrf.ujl.isEmpty())) {
      getIntent().putExtra("key_trans_id", ((Orders.Commodity)this.qrf.ujl.get(0)).cnJ);
    }
    if (this.mPayInfo != null) {
      getIntent().putExtra("key_reqKey", this.mPayInfo.cnI);
    }
    if (this.isPaySuccess)
    {
      if (this.qrf != null) {
        getIntent().putExtra("key_total_fee", this.qrf.cnL);
      }
      getIntent().putExtra("key_pay_reslut_type", 1);
      l(-1, getIntent());
      setResult(-1, getIntent());
      localObject = getProcess();
      if ((localObject != null) && (this == (Context)((com.tencent.mm.wallet_core.c)localObject).AVC.get()))
      {
        ab.i(this.TAG, "remove process end callback to prevent ui leak");
        ((com.tencent.mm.wallet_core.c)localObject).dRN();
      }
      super.finish();
      AppMethodBeat.o(46083);
      return;
    }
    if ((this.mPayInfo != null) && (this.mPayInfo.cCD == 8) && (this.qrf != null))
    {
      this.mPayInfo.wgB = 0;
      doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.a(cSd(), this.qrf, true), false);
      if (this.mPayInfo.wgv != null)
      {
        long l = this.mPayInfo.wgv.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.qsU.e(13956, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    l(0, getIntent());
    getIntent().putExtra("key_pay_reslut_type", this.mPayResultType);
    label396:
    int i;
    if (this.tXm == 1)
    {
      getIntent().putExtra("key_pay_reslut_type", 1000);
      setResult(0, getIntent());
      s.cRG();
      if (!s.cRH().cUn()) {
        break label581;
      }
      if (this.mPayInfo != null) {
        break label558;
      }
      i = 0;
      label427:
      if (this.mPayInfo != null) {
        break label569;
      }
    }
    label558:
    label569:
    for (Object localObject = "";; localObject = this.mPayInfo.cnI)
    {
      ad.e(i, (String)localObject, 18, "");
      localObject = com.tencent.mm.wallet_core.a.avV("PayProcess").iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.wallet_core.c localc = (com.tencent.mm.wallet_core.c)((Iterator)localObject).next();
        localc.G(new Object[] { "specEndProcessWithoutFinish" });
        if (localc.mEJ != null) {
          localc.mEJ.clear();
        }
        com.tencent.mm.wallet_core.a.remove(localc.getClass().hashCode());
        localc.cRJ();
      }
      break;
      if (this.tXm != 2) {
        break label396;
      }
      getIntent().putExtra("key_pay_reslut_type", 1001);
      break label396;
      i = this.mPayInfo.cCD;
      break label427;
    }
    label581:
    s.cRG();
    if (s.cRH().cUm())
    {
      if (this.mPayInfo == null)
      {
        i = 0;
        label603:
        if (this.mPayInfo != null) {
          break label637;
        }
      }
      label637:
      for (localObject = "";; localObject = this.mPayInfo.cnI)
      {
        ad.e(i, (String)localObject, 4, "");
        break;
        i = this.mPayInfo.cCD;
        break label603;
      }
    }
    if (this.mPayInfo == null)
    {
      i = 0;
      label658:
      if (this.mPayInfo != null) {
        break label693;
      }
    }
    label693:
    for (localObject = "";; localObject = this.mPayInfo.cnI)
    {
      ad.e(i, (String)localObject, 7, "");
      break;
      i = this.mPayInfo.cCD;
      break label658;
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
    return 2130971231;
  }
  
  protected final PayInfo getPayInfo()
  {
    AppMethodBeat.i(46117);
    if (this.mPayInfo == null) {
      this.mPayInfo = ((PayInfo)getIntent().getParcelableExtra("key_pay_info"));
    }
    PayInfo localPayInfo = this.mPayInfo;
    AppMethodBeat.o(46117);
    return localPayInfo;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46087);
    af.a(getWindow());
    MMScrollView localMMScrollView = (MMScrollView)findViewById(2131823477);
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.qqy = ((Button)findViewById(2131829349));
    this.qqy.setClickable(false);
    this.qqy.setEnabled(false);
    this.tWM = ((TextView)findViewById(2131829260));
    this.tWN = ((TextView)findViewById(2131829328));
    this.tWP = ((TextView)findViewById(2131829329));
    this.tWU = ((TextView)findViewById(2131829334));
    this.tWO = ((TextView)findViewById(2131829330));
    this.tWT = ((TextView)findViewById(2131829348));
    this.tWO.getPaint().setFlags(16);
    this.tWQ = ((TextView)findViewById(2131829351));
    this.tWR = ((TextView)findViewById(2131829350));
    this.tWR.setOnClickListener(new WalletPayUI.27(this));
    this.tWS = ((ImageView)findViewById(2131829335));
    this.tWS.setOnClickListener(new WalletPayUI.28(this));
    this.tWV = ((LinearLayout)findViewById(2131829331));
    this.tWW = new WalletPayUI.a(this);
    this.qqy.setOnClickListener(new WalletPayUI.29(this));
    this.qqy.setText(2131305443);
    this.tWZ = ((TextView)findViewById(2131829336));
    this.tXa = ((LinearLayout)findViewById(2131829337));
    bJ();
    AppMethodBeat.o(46087);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(46111);
    if (this.tXh)
    {
      String str1 = this.TAG;
      boolean bool1;
      label87:
      String str2;
      int i;
      if ((getPayInfo() == null) || (!getPayInfo().nnQ))
      {
        bool1 = true;
        ab.i(str1, "case 1 %s,  stack %s", new Object[] { Boolean.valueOf(bool1), bo.dtY().toString() });
        str1 = this.TAG;
        s.cRG();
        if (s.cRH().cUl()) {
          break label196;
        }
        bool1 = true;
        ab.d(str1, "case 2 %s,", new Object[] { Boolean.valueOf(bool1) });
        str2 = this.TAG;
        if (this.tNG != null) {
          break label201;
        }
        i = 0;
        label121:
        if (this.tNH != null) {
          break label212;
        }
      }
      label196:
      label201:
      label212:
      for (str1 = "";; str1 = this.tNH.field_forbidWord)
      {
        ab.d(str2, "case 3 mBankcardList %s, mDefaultBankcard %s", new Object[] { Integer.valueOf(i), str1 });
        if ((getPayInfo() != null) && (getPayInfo().nnQ)) {
          break label224;
        }
        ab.i(this.TAG, "get isTransparent1");
        AppMethodBeat.o(46111);
        return false;
        bool1 = false;
        break;
        bool1 = false;
        break label87;
        i = this.tNG.size();
        break label121;
      }
      label224:
      s.cRG();
      if (!s.cRH().cUl())
      {
        ab.i(this.TAG, "get isTransparent2");
        AppMethodBeat.o(46111);
        return false;
      }
      if ((this.tNG != null) && ((this.tNG.size() == 0) || ((this.tNH != null) && (!bo.isNullOrNil(this.tNH.field_forbidWord)))))
      {
        str1 = this.TAG;
        if ((this.tNG != null) && (this.tNG.size() == 0))
        {
          bool1 = true;
          if ((this.tNH == null) || (bo.isNullOrNil(this.tNH.field_forbidWord))) {
            break label378;
          }
        }
        label378:
        for (boolean bool2 = true;; bool2 = false)
        {
          ab.i(str1, "get isTransparent3 1 %s 2 %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(46111);
          return false;
          bool1 = false;
          break;
        }
      }
      ab.i(this.TAG, "get isTransparent4");
      AppMethodBeat.o(46111);
      return true;
    }
    ab.i(this.TAG, "get isTransparent5");
    AppMethodBeat.o(46111);
    return true;
  }
  
  protected final void nA(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(46099);
    if (!asr())
    {
      AppMethodBeat.o(46099);
      return;
    }
    this.tVT = false;
    ab.i(this.TAG, "pay with old bankcard! from statck %s", new Object[] { bo.dtY().toString() });
    int i;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label230;
      }
    }
    label230:
    for (Object localObject = "";; localObject = this.mPayInfo.cnI)
    {
      ad.e(i, (String)localObject, 8, "");
      if (this.tWX != null)
      {
        ab.w(this.TAG, "close previous cashier dialog");
        this.tWX.dismiss();
      }
      this.tVT = false;
      if (!cRK()) {
        break label242;
      }
      this.tWX = new WcPayCashierDialog(getContext());
      localObject = (WcPayCashierDialog)this.tWX;
      PayInfo localPayInfo = this.mPayInfo;
      Orders localOrders = this.qrf;
      FavorPayInfo localFavorPayInfo = this.tVQ;
      Bankcard localBankcard = this.tNH;
      if (!this.tWH) {
        bool = true;
      }
      ((WcPayCashierDialog)localObject).a(localPayInfo, localOrders, localFavorPayInfo, localBankcard, bool, paramBoolean);
      ((WcPayCashierDialog)localObject).uvB = new WalletPayUI.7(this);
      ((WcPayCashierDialog)localObject).show();
      addDialog((Dialog)localObject);
      AppMethodBeat.o(46099);
      return;
      i = this.mPayInfo.cCD;
      break;
    }
    label242:
    if (!this.tWH) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.tWX = q.a(this, paramBoolean, this.qrf, this.tVQ, this.tNH, this.mPayInfo, this.qlK, new WalletPayUI.8(this), new WalletPayUI.9(this), new WalletPayUI.10(this));
      this.tVS = ((com.tencent.mm.plugin.wallet_core.ui.d)this.tWX);
      AppMethodBeat.o(46099);
      return;
    }
  }
  
  protected void nB(boolean paramBoolean)
  {
    AppMethodBeat.i(46114);
    com.tencent.mm.plugin.wallet.pay.a.a.b localb = com.tencent.mm.plugin.wallet.pay.a.a.a(cSd(), this.qrf, paramBoolean);
    if (this.qrf != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_reqKey", this.qrf.cnI);
      if ((this.qrf.ujl != null) && (this.qrf.ujl.size() > 0)) {
        localBundle.putString("key_TransId", ((Orders.Commodity)this.qrf.ujl.get(0)).cnJ);
      }
      localBundle.putLong("key_SessionId", this.tWY);
      localb.setProcessName("PayProcess");
      localb.setProcessBundle(localBundle);
    }
    if (this.mPayInfo != null)
    {
      if ((this.mPayInfo.cCD != 6) || (this.mPayInfo.wgs != 100)) {
        break label255;
      }
      localb.setScene(100);
    }
    for (;;)
    {
      doSceneProgress(localb);
      if ((this.mPayInfo != null) && (8 == this.mPayInfo.cCD) && (this.mPayInfo.wgv != null))
      {
        long l = this.mPayInfo.wgv.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.qsU.e(13956, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - l) });
      }
      AppMethodBeat.o(46114);
      return;
      label255:
      localb.setScene(this.mPayInfo.cCD);
    }
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  protected final void nz(boolean paramBoolean)
  {
    AppMethodBeat.i(46095);
    if ((paramBoolean) && (!cSl()))
    {
      AppMethodBeat.o(46095);
      return;
    }
    if (this.tVQ != null)
    {
      this.tWD = com.tencent.mm.plugin.wallet_core.ui.c.umO.a(this.qrf);
      com.tencent.mm.plugin.wallet.a.j localj = this.tWD.afD(this.tVQ.uhU);
      if ((localj == null) || (localj.tUe != 0.0D)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.tXj != null)
      {
        if (this.tXj.tVC == 0)
        {
          ab.i(this.TAG, "need real name,stop");
          b(this.tXj);
          AppMethodBeat.o(46095);
          return;
        }
        if ((this.tXj.tVC == 1) && (i != 0))
        {
          ab.i(this.TAG, "need real name, zero stop");
          b(this.tXj);
        }
      }
      if (this.tVD != null)
      {
        if ((this.tVD.tVm == 1) && (!bo.isNullOrNil(this.tVD.opC)) && (!bo.isNullOrNil(this.tVD.opD)) && (!bo.isNullOrNil(this.tVD.tVn)))
        {
          if ((this.mPayInfo != null) && (this.qrf != null) && (this.qrf.ujl != null) && (this.qrf.ujl.size() > 0))
          {
            if (this.mPayInfo.cCD != 8) {
              break label371;
            }
            com.tencent.mm.plugin.report.service.h.qsU.e(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.qrf.ujl.get(0)).cnJ });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.tVD.tVn, "", this.tVD.opD, this.tVD.opC, false, new WalletPayUI.4(this), new WalletPayUI.5(this));
            AppMethodBeat.o(46095);
            return;
            label371:
            com.tencent.mm.plugin.report.service.h.qsU.e(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.qrf.ujl.get(0)).cnJ });
          }
        }
        if ((this.tVD.tVm == 2) && (!bo.isNullOrNil(this.tVD.tVn)) && (!bo.isNullOrNil(this.tVD.tVo)))
        {
          ab.i(this.TAG, "pay has been blocked");
          if ((this.mPayInfo != null) && (this.qrf != null) && (this.qrf.ujl != null) && (this.qrf.ujl.size() > 0))
          {
            if (this.mPayInfo.cCD != 8) {
              break label624;
            }
            com.tencent.mm.plugin.report.service.h.qsU.e(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.qrf.ujl.get(0)).cnJ });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.tVD.tVn, "", this.tVD.tVo, false, new WalletPayUI.6(this));
            AppMethodBeat.o(46095);
            return;
            label624:
            com.tencent.mm.plugin.report.service.h.qsU.e(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.qrf.ujl.get(0)).cnJ });
          }
        }
      }
      cSg();
      AppMethodBeat.o(46095);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(46109);
    ab.i(this.TAG, "onAcvityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(46109);
      return;
      if (paramInt2 == -1)
      {
        if (paramIntent != null)
        {
          this.tXg = paramIntent.getIntExtra("auto_deduct_flag", -1);
          if ((this.qrf != null) && (this.qrf.ujq != null)) {
            this.qrf.ujq.tXg = this.tXg;
          }
          getPayInfo().wgy = this.tXg;
          if (this.tXg == 1)
          {
            getPayInfo().wgz = paramIntent.getStringExtra("deduct_bank_type");
            getPayInfo().wgA = paramIntent.getStringExtra("deduct_bind_serial");
          }
        }
        this.tXf = true;
        onProgressFinish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(13958, new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(46109);
        return;
        finish();
      }
      this.tWX.dismiss();
      this.tWL = false;
      cRZ();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46078);
    super.onCreate(paramBundle);
    this.TAG = ("MicroMsg.WalletPayUI@" + hashCode());
    if (tWA)
    {
      ab.w(this.TAG, "has Undestory WalletPayUI!");
      com.tencent.mm.plugin.report.service.h.qsU.j(965L, 1L, 1L);
      Io(2);
      finish();
      AppMethodBeat.o(46078);
      return;
    }
    tWA = true;
    long l = System.currentTimeMillis();
    int j = getIntent().getIntExtra("key_context_hashcode", -1);
    paramBundle = new WalletPayUI.b[tWB.size()];
    ab.i(this.TAG, "WalletPayUI check %s this %s fromHashCode %s", new Object[] { Integer.valueOf(tWB.size()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
    paramBundle = (WalletPayUI.b[])tWB.toArray(paramBundle);
    int k = paramBundle.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = paramBundle[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localObject.tXz.get();
      if (localWalletPayUI != null)
      {
        ab.w(this.TAG, "has old payui, both finish %s", new Object[] { Integer.valueOf(localWalletPayUI.hashCode()) });
        if ((j != localObject.axc) || (j == -1)) {
          break label285;
        }
        localWalletPayUI.Io(2);
        com.tencent.mm.plugin.report.service.h.qsU.j(965L, 41L, 1L);
      }
      for (;;)
      {
        tWB.remove(localObject);
        localWalletPayUI.finish();
        i += 1;
        break;
        label285:
        localWalletPayUI.Io(1);
        com.tencent.mm.plugin.report.service.h.qsU.j(965L, 40L, 1L);
      }
    }
    this.tXo = new WalletPayUI.b(this, (byte)0);
    this.tXo.timestamp = l;
    this.tXo.axc = j;
    this.tXo.tXz = new WeakReference(this);
    tWB.add(this.tXo);
    if (!com.tencent.mm.kernel.g.RG())
    {
      ab.e(this.TAG, "hy: account not ready. finish now");
      finish();
      AppMethodBeat.o(46078);
      return;
    }
    getWindow().getDecorView().postDelayed(this.tXn, 5000L);
    this.tXp = bo.aoy();
    com.tencent.mm.sdk.b.a.ymk.c(this.qoE);
    com.tencent.mm.plugin.wallet_core.model.m.Iy(5);
    this.qlj = com.tencent.mm.plugin.wallet.a.as(getIntent());
    setMMTitle(2131305492);
    this.mPayInfo = getPayInfo();
    this.tWH = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
    this.tWI = bo.bf(getIntent().getStringExtra("key_force_use_bind_serail"), "");
    this.qlK = getIntent().getStringExtra("key_receiver_true_name");
    if ((this.mPayInfo == null) || (this.mPayInfo.wgx == 0L))
    {
      this.tWY = System.currentTimeMillis();
      s.cRG();
      if (!s.cRH().cUl())
      {
        if (this.mPayInfo != null) {
          break label672;
        }
        i = 0;
        label554:
        if (this.mPayInfo != null) {
          break label683;
        }
        paramBundle = "";
        label564:
        ad.e(i, paramBundle, 1, "");
      }
      if (cRY()) {
        break label752;
      }
      ab.d(this.TAG, "PayInfo = " + this.mPayInfo);
      if ((this.mPayInfo == null) || (bo.isNullOrNil(this.mPayInfo.cnI))) {
        break label694;
      }
      cRZ();
      initView();
    }
    for (;;)
    {
      if (this.mPayInfo != null) {
        com.tencent.mm.plugin.wallet.pay.a.b.aeW(this.mPayInfo.wgD);
      }
      AppMethodBeat.o(46078);
      return;
      this.tWY = this.mPayInfo.wgx;
      break;
      label672:
      i = this.mPayInfo.cCD;
      break label554;
      label683:
      paramBundle = this.mPayInfo.cnI;
      break label564;
      label694:
      if ((this.mPayInfo != null) && (!bo.isNullOrNil(this.mPayInfo.errMsg))) {}
      for (paramBundle = this.mPayInfo.errMsg;; paramBundle = getString(2131305485))
      {
        com.tencent.mm.ui.base.h.a(this, paramBundle, null, false, new WalletPayUI.23(this));
        break;
      }
      label752:
      ab.i(this.TAG, "hy: pay end on create. finish");
      finish();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46080);
    if (this.tVR != null)
    {
      this.tVR.cRP();
      this.tVR.release();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.qoE);
    this.tVS = null;
    getWindow().getDecorView().removeCallbacks(this.tXn);
    tWB.remove(this.tXo);
    tWA = false;
    long l = System.currentTimeMillis();
    WalletPayUI.b[] arrayOfb = new WalletPayUI.b[tWB.size()];
    arrayOfb = (WalletPayUI.b[])tWB.toArray(arrayOfb);
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      WalletPayUI.b localb = arrayOfb[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localb.tXz.get();
      if ((localWalletPayUI != null) && (l - localb.timestamp > 600000L))
      {
        ab.w(this.TAG, "has old payui, both finish");
        com.tencent.mm.plugin.report.service.h.qsU.j(965L, 2L, 1L);
        tWB.remove(localb);
        localWalletPayUI.Io(1);
        localWalletPayUI.finish();
      }
      i += 1;
    }
    if (this.mPayInfo != null) {
      com.tencent.mm.plugin.wallet.pay.a.b.aeX(this.mPayInfo.wgD);
    }
    setAuthState(false);
    super.onDestroy();
    AppMethodBeat.o(46080);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(46084);
    if (paramInt == 4)
    {
      if (isAuthDoing())
      {
        ab.w(this.TAG, "block when authening");
        AppMethodBeat.o(46084);
        return true;
      }
      if ((this.tWX != null) && (this.mPayInfo != null) && (this.mPayInfo.nnQ) && (!this.mNetSceneMgr.isProcessing())) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(46084);
        return true;
        hideVKB();
        showDialog(1000);
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(46084);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    int j = 1;
    AppMethodBeat.i(46085);
    ab.i(this.TAG, "onNewIntent");
    setIntent(paramIntent);
    if (!cRY())
    {
      ab.w(this.TAG, "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
      if (paramIntent.getBooleanExtra("send_cancel_event", true)) {
        l(0, getIntent());
      }
      this.isPaySuccess = false;
    }
    if (paramIntent.getBooleanExtra("direc_change_bankcard", false))
    {
      nA(true);
      AppMethodBeat.o(46085);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false))) {
      this.tXc = true;
    }
    for (int i = 1; i != 0; i = 0)
    {
      ab.i(this.TAG, "isFromBindCard is true");
      cRZ();
      AppMethodBeat.o(46085);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_is_realname_verify_process", false)))
    {
      this.tXd = true;
      i = j;
      if (i == 0) {
        break label196;
      }
      ab.i(this.TAG, "isFromRealNameVerify is true");
      finish();
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(46085);
      return;
      i = 0;
      break;
      label196:
      ab.e(this.TAG, "isFromBindCard is false,isFromRealNameVerify is false");
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(46120);
    super.onPause();
    if (this.tVS != null) {
      this.tVS.onActivityPause();
    }
    AppMethodBeat.o(46120);
  }
  
  public boolean onProgressFinish()
  {
    boolean bool2 = false;
    AppMethodBeat.i(46110);
    ab.i(this.TAG, "onProgressFinish isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.tXk) });
    com.tencent.mm.sdk.b.a.ymk.l(new va());
    int i;
    int j;
    label93:
    Object localObject;
    label104:
    boolean bool1;
    if ((this.qrf != null) && (this.qrf.ujq != null) && (!this.tXf))
    {
      i = 1;
      if ((i == 0) && (!cSk()))
      {
        if (this.mPayInfo != null) {
          break label140;
        }
        j = 0;
        if (this.mPayInfo != null) {
          break label151;
        }
        localObject = "";
        ad.e(j, (String)localObject, 2, "");
      }
      if (!this.tXk) {
        break label163;
      }
      nz(true);
      bool1 = true;
    }
    for (;;)
    {
      AppMethodBeat.o(46110);
      return bool1;
      i = 0;
      break;
      label140:
      j = this.mPayInfo.cCD;
      break label93;
      label151:
      localObject = this.mPayInfo.cnI;
      break label104;
      label163:
      if (this.tXe)
      {
        bool1 = true;
      }
      else if (i != 0)
      {
        localObject = new Intent(this, WalletPayDeductUI.class);
        ((Intent)localObject).putExtra("orders", this.qrf);
        startActivityForResult((Intent)localObject, 0);
        bool1 = true;
      }
      else if (getContentView().getVisibility() != 0)
      {
        if ((!this.tWL) && (asr()))
        {
          nz(true);
          this.tWL = true;
        }
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (getContentView().getVisibility() == 0)
        {
          bool1 = bool2;
          if (this.qrf != null)
          {
            bool1 = bool2;
            if (this.qrf.ujq != null)
            {
              bool1 = bool2;
              if (this.qqy.isEnabled())
              {
                bool1 = bool2;
                if (!this.tXi)
                {
                  this.qqy.performClick();
                  this.tXi = true;
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
    AppMethodBeat.i(46082);
    ab.i(this.TAG, "hy: onResume isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.tXk) });
    if (!isProcessing())
    {
      if (!bo.isNullOrNil(this.tWI)) {
        this.tNH = cSj();
      }
    }
    else
    {
      if (!this.tXl) {
        break label149;
      }
      ab.i(this.TAG, "onResume isResumePassFinish");
      this.tXl = false;
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(46082);
      return;
      if (this.tNH == null)
      {
        s.cRG();
        this.tNH = s.cRH().a(null, null, cSm(), false);
        break;
      }
      s.cRG();
      this.tNH = s.cRH().a(null, this.tNH.field_bindSerial, cSm(), false);
      break;
      label149:
      if ((this.tWF) && (getContentViewVisibility() != 0) && ((this.tWX == null) || (!this.tWX.isShowing())))
      {
        ab.i(this.TAG, "hy: has started process and is transparent and no pwd appeared. finish self");
        finish();
      }
      else if (this.tVS != null)
      {
        this.tVS.cVq();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(142357);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm, paramBoolean);
    if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
      setAuthState(false);
    }
    AppMethodBeat.o(142357);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(46105);
    ab.i(this.TAG, "errorType %s errCode %s, errmsg %s, scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    boolean bool;
    Object localObject;
    label303:
    label338:
    label498:
    l locall;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.c.f))
      {
        this.mPayResultType = 1;
        this.tWC = ((com.tencent.mm.plugin.wallet.pay.a.c.f)paramm);
        paramString = (com.tencent.mm.plugin.wallet.pay.a.c.f)paramm;
        if (paramString.isJumpRemind())
        {
          paramm = paramString.getJumpRemind();
          paramm.a(this, new com.tencent.mm.wallet_core.c.e()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(46052);
              if (paramm.dSl())
              {
                WalletPayUI.a(WalletPayUI.this, paramString);
                AppMethodBeat.o(46052);
                return;
              }
              WalletPayUI.this.finish();
              AppMethodBeat.o(46052);
            }
            
            public final void onEnter() {}
            
            public final void onUrlCancel()
            {
              AppMethodBeat.i(46054);
              if (paramm.dSl())
              {
                WalletPayUI.a(WalletPayUI.this, paramString);
                AppMethodBeat.o(46054);
                return;
              }
              WalletPayUI.this.finish();
              AppMethodBeat.o(46054);
            }
            
            public final void onUrlOk()
            {
              AppMethodBeat.i(46053);
              if (paramm.dSl())
              {
                WalletPayUI.a(WalletPayUI.this, paramString);
                AppMethodBeat.o(46053);
                return;
              }
              WalletPayUI.this.cRZ();
              AppMethodBeat.o(46053);
            }
          });
          AppMethodBeat.o(46105);
          return true;
        }
        a(paramString);
      }
      while (!(paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        bJ();
        AppMethodBeat.o(46105);
        return true;
      }
      this.mPayResultType = 1;
      paramm = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
      paramString = getInput();
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putParcelable("key_bankcard", this.tNH);
      paramString.putString("key_bank_type", this.tNH.field_bankcardType);
      if (!bo.isNullOrNil(this.gJv)) {
        paramString.putString("key_pwd1", this.gJv);
      }
      paramString.putString("kreq_token", paramm.getToken());
      paramString.putParcelable("key_authen", paramm.tVs);
      if (!paramm.tVq)
      {
        bool = true;
        paramString.putBoolean("key_need_verify_sms", bool);
        paramString.putInt("key_can_verify_tail", paramm.tVw);
        paramString.putString("key_verify_tail_wording", paramm.tVx);
        localObject = getInput();
        if (paramm.tVy != 1) {
          break label617;
        }
        bool = true;
        ((Bundle)localObject).putBoolean("key_block_bind_new_card", bool);
        if (!bo.isNullOrNil(paramm.tVt)) {
          break label623;
        }
        paramString.putString("key_mobile", this.tNH.field_mobile);
        paramString.putString("key_QADNA_URL", paramm.tVu);
        if (!paramm.isPaySuccess) {
          break label638;
        }
        if (this.qlj != null)
        {
          this.qlj.bs(10003, "");
          localObject = this.qlj;
          com.tencent.mm.plugin.report.service.h.qsU.e(13455, new Object[] { ((com.tencent.mm.plugin.wallet.a)localObject).tLS, Long.valueOf(System.currentTimeMillis()), ((com.tencent.mm.plugin.wallet.a)localObject).tLT });
        }
        paramString.putParcelable("key_orders", paramm.tVr);
        if (this.mPayInfo != null)
        {
          ab.i(this.TAG, "payscene %d", new Object[] { Integer.valueOf(this.mPayInfo.cCD) });
          if (8 == this.mPayInfo.cCD)
          {
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yDG, Boolean.TRUE);
          }
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("pwd", this.gJv);
        locall = (l)com.tencent.mm.kernel.g.E(l.class);
        paramInt1 = 0;
        if (!locall.byS()) {
          break label652;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        ((Bundle)localObject).putInt("key_open_biometric_type", paramInt1);
        locall.a(paramm.cRM(), true, (Bundle)localObject);
        paramString.putInt("key_pay_flag", 3);
        paramm = paramm.plg;
        if (paramm != null) {
          paramString.putParcelable("key_realname_guide_helper", paramm);
        }
        Z(paramString);
        AppMethodBeat.o(46105);
        return true;
        bool = false;
        break;
        label617:
        bool = false;
        break label303;
        label623:
        paramString.putString("key_mobile", paramm.tVt);
        break label338;
        label638:
        paramString.putParcelable("key_orders", this.qrf);
        break label498;
        label652:
        if (locall.byV()) {
          paramInt1 = 2;
        }
      }
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("pwd", this.gJv);
      locall = (l)com.tencent.mm.kernel.g.E(l.class);
      if (this.mPayInfo.utc == 1)
      {
        bool = true;
        label721:
        locall.a(bool, false, (Bundle)localObject);
        if ((paramInt2 != -1) && (paramInt2 != -500)) {
          break label850;
        }
      }
      label850:
      for (this.mPayResultType = 3;; this.mPayResultType = 2) {
        switch (paramInt2)
        {
        default: 
          AppMethodBeat.o(46105);
          return false;
          bool = false;
          break label721;
        }
      }
      paramm = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
      this.tWK = getInput();
      this.tWK.putParcelable("key_pay_info", this.mPayInfo);
      this.tWK.putParcelable("key_bankcard", this.tNH);
      if (!bo.isNullOrNil(this.gJv)) {
        this.tWK.putString("key_pwd1", this.gJv);
      }
      this.tWK.putString("kreq_token", paramm.getToken());
      this.tWK.putParcelable("key_authen", paramm.tVs);
      localObject = this.tWK;
      if (!paramm.tVq)
      {
        bool = true;
        label972:
        ((Bundle)localObject).putBoolean("key_need_verify_sms", bool);
        this.tWK.putString("key_mobile", this.tNH.field_mobile);
        this.tWK.putInt("key_err_code", paramInt2);
        this.tWK.putParcelable("key_orders", this.qrf);
        if (!bo.isNullOrNil(paramString)) {
          break label1438;
        }
        paramString = getString(2131305490, new Object[] { this.tNH.field_desc, this.tNH.field_mobile });
      }
    }
    label1438:
    for (;;)
    {
      com.tencent.mm.ui.base.h.d(this, paramString, "", getString(2131305489), getString(2131296888), new WalletPayUI.17(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(46056);
          if (WalletPayUI.this.isTransparent()) {
            WalletPayUI.this.finish();
          }
          AppMethodBeat.o(46056);
        }
      });
      AppMethodBeat.o(46105);
      return true;
      bool = false;
      break label972;
      this.mPayInfo.wgw = paramInt2;
      cRT();
      AppMethodBeat.o(46105);
      return true;
      this.mPayInfo.wgw = paramInt2;
      bool = false;
      if (paramInt2 == 100100) {
        bool = true;
      }
      if (this.tVR == null) {
        this.tVR = new a(this, this);
      }
      this.tVR.a(bool, this.mPayInfo.cwj, this.mPayInfo.cnI);
      ab.i(this.TAG, "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool)));
      AppMethodBeat.o(46105);
      return true;
      if ((this.tNH == null) || (this.qrf == null)) {
        break;
      }
      this.tNH.ufL = this.qrf.cnI;
      if ((this.tNG != null) && (this.tNG.size() > 1)) {
        c(true, 4, paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(46105);
        return true;
        b(true, 4, paramString);
      }
      if (!(paramm instanceof com.tencent.mm.plugin.wallet.pay.a.c.f)) {
        break;
      }
      this.tXh = true;
      cSk();
      if (paramInt2 == 416)
      {
        ab.e(this.TAG, "errCode is 416 need real name verify!");
        this.mPayResultType = 2;
        this.tXe = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
        paramString.putString("realname_verify_process_jump_plugin", "wallet");
        if (this.mPayInfo != null) {}
        for (paramInt1 = this.mPayInfo.cCD;; paramInt1 = 0)
        {
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramm, paramString, paramInt1);
          AppMethodBeat.o(46105);
          return bool;
        }
      }
      this.mPayResultType = 3;
      ab.i(this.TAG, "errCode is %d , not need real name verify!", new Object[] { Integer.valueOf(paramInt2) });
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
 * JD-Core Version:    0.7.0.1
 */