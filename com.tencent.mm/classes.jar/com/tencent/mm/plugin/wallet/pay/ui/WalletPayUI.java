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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.aaa.a;
import com.tencent.mm.g.a.aai;
import com.tencent.mm.g.a.zp;
import com.tencent.mm.g.a.zz;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet.pay.a.c.c;
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
import com.tencent.mm.ui.x;
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
  private static boolean HGP;
  private static List<b> HGQ;
  protected com.tencent.mm.plugin.wallet.a CqM;
  private String Crn;
  private IListener Cuh;
  protected Orders CwO;
  protected Button Cwg;
  private com.tencent.mm.plugin.wallet.pay.a.d HFT;
  private com.tencent.mm.plugin.wallet.pay.a.c.f HGR;
  protected com.tencent.mm.plugin.wallet_core.ui.d HGS;
  private boolean HGT;
  protected boolean HGU;
  private d.a HGV;
  protected boolean HGW;
  protected String HGX;
  protected boolean HGY;
  public Bundle HGZ;
  public FavorPayInfo HGf;
  private a HGg;
  com.tencent.mm.plugin.wallet_core.ui.f HGh;
  private boolean HGi;
  private boolean HHA;
  private int HHB;
  private Runnable HHC;
  private b HHD;
  private long HHE;
  protected boolean HHa;
  protected TextView HHb;
  protected TextView HHc;
  private TextView HHd;
  protected TextView HHe;
  protected TextView HHf;
  protected TextView HHg;
  protected ImageView HHh;
  private TextView HHi;
  private TextView HHj;
  protected LinearLayout HHk;
  protected a HHl;
  public Dialog HHm;
  private long HHn;
  private TextView HHo;
  private LinearLayout HHp;
  private boolean HHq;
  private boolean HHr;
  private boolean HHs;
  private boolean HHt;
  private boolean HHu;
  private int HHv;
  private boolean HHw;
  private boolean HHx;
  private com.tencent.mm.plugin.wallet.pay.a.c.f HHy;
  private boolean HHz;
  protected ArrayList<Bankcard> Hva;
  protected Bankcard Hvb;
  public String TAG;
  private boolean isPaySuccess;
  public String krw;
  protected int mCount;
  protected PayInfo mPayInfo;
  
  static
  {
    AppMethodBeat.i(69482);
    HGP = false;
    HGQ = new ArrayList();
    AppMethodBeat.o(69482);
  }
  
  public WalletPayUI()
  {
    AppMethodBeat.i(69427);
    this.TAG = "MicroMsg.WalletPayUI";
    this.CwO = null;
    this.HGR = null;
    this.mCount = 0;
    this.krw = null;
    this.Hva = null;
    this.Hvb = null;
    this.HGf = null;
    this.HGS = null;
    this.HGT = false;
    this.isPaySuccess = false;
    this.HGU = false;
    this.HGW = false;
    this.HGX = "";
    this.mPayInfo = null;
    this.HGY = false;
    this.HGZ = null;
    this.HHa = false;
    this.HHn = 0L;
    this.HHq = true;
    this.HHr = false;
    this.HHs = false;
    this.HHt = false;
    this.HHu = false;
    this.HHv = -1;
    this.HHw = false;
    this.HHx = false;
    this.CqM = null;
    this.HHz = false;
    this.HHA = false;
    this.HFT = null;
    this.HHB = 0;
    this.HHC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69386);
        Log.i(WalletPayUI.this.TAG, "auto reset create flag");
        WalletPayUI.TT();
        AppMethodBeat.o(69386);
      }
    };
    this.HHE = 0L;
    this.Cuh = new IListener() {};
    this.HGi = false;
    AppMethodBeat.o(69427);
  }
  
  private void a(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    AppMethodBeat.i(69456);
    Log.i(this.TAG, "stopRealname realnameGuideFlag %s guide_type %s", new Object[] { paramf.egd, Integer.valueOf(paramf.HFS) });
    label109:
    Object localObject;
    label150:
    int j;
    if (("1".equals(paramf.egd)) || ("2".equals(paramf.egd)))
    {
      this.HHy = paramf;
      this.HFT = paramf.HFT;
      this.HHw = true;
      this.CwO = paramf.CwO;
      if (this.CwO == null) {
        break label523;
      }
      i = this.CwO.HZd.size();
      this.mCount = i;
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("get mOrders! bankcardTag : ");
      if (this.CwO == null) {
        break label528;
      }
      paramf = Integer.valueOf(this.CwO.HQg);
      Log.d((String)localObject, paramf);
      bqg();
      if ((this.CwO != null) && (this.CwO.HZe != null))
      {
        this.HGS = com.tencent.mm.plugin.wallet_core.ui.e.IcT.a(this.CwO);
        if (this.HGS != null)
        {
          if (this.HGS.fSz().size() > 0) {
            this.HGT = true;
          }
          this.HGf = this.HGS.aVM(this.CwO.HZe.HEt);
          this.HGf.HXI = this.HGS.aVN(this.HGf.HXI);
          Log.i(this.TAG, "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", new Object[] { this.CwO.HZe.HEt, this.HGf.HXI, this.HGf.HXI, this.HGf.toString() });
        }
      }
      if ((this.CwO != null) && (this.Hva != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.CwO);
        paramf = com.tencent.mm.plugin.report.service.h.CyF;
        j = this.mPayInfo.dVv;
        com.tencent.mm.plugin.wallet.a.s.fOg();
        if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRk()) {
          break label534;
        }
      }
    }
    label523:
    label528:
    label534:
    for (int i = 2;; i = 1)
    {
      paramf.a(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.CwO.dDO * 100.0D)), this.CwO.AOl });
      if ((this.CwO == null) || (this.CwO.HZd == null)) {
        break label598;
      }
      paramf = new LinkedList();
      localObject = this.CwO.HZd.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramf.add(((Orders.Commodity)((Iterator)localObject).next()).dDM);
      }
      this.HHy = null;
      break;
      i = 0;
      break label109;
      paramf = "";
      break label150;
    }
    if (paramf.size() > 0)
    {
      localObject = new zz();
      ((zz)localObject).egG.egI = paramf;
      EventCenter.instance.publish((IEvent)localObject);
      if (this.CqM != null) {
        this.CqM.cG(10001, (String)paramf.get(0));
      }
    }
    label598:
    if ((this.CwO != null) && (this.CwO.HZB != null) && (this.CwO.HZB.Iaw == 1) && (!Util.isNullOrNil(this.CwO.HZB.ANo)))
    {
      this.HGW = true;
      this.HGX = this.CwO.HZB.ANo;
    }
    com.tencent.mm.plugin.wallet.a.s.fOg();
    this.Hva = com.tencent.mm.plugin.wallet.a.s.fOh().yk(fOL());
    if (!Util.isNullOrNil(this.HGX))
    {
      this.Hvb = fOI();
      paramf = Util.nullAs(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!Util.isNullOrNil(paramf)) {
        this.Hvb = aUY(paramf);
      }
      this.Cwg.setClickable(true);
      if (Util.isNullOrNil(t.fQI().IbY)) {
        break label1031;
      }
      this.HHi.setVisibility(0);
      this.HHi.setText(t.fQI().IbY);
      label773:
      if ((this.CwO != null) && (this.Hva != null) && (this.mPayInfo != null))
      {
        com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.CwO);
        paramf = com.tencent.mm.plugin.report.service.h.CyF;
        j = this.mPayInfo.dVv;
        com.tencent.mm.plugin.wallet.a.s.fOg();
        if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRk()) {
          break label1052;
        }
        i = 2;
        label832:
        paramf.a(10690, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf((int)(this.CwO.dDO * 100.0D)), this.CwO.AOl });
      }
      if (this.HHr) {
        bo(0, false);
      }
      if (getPayInfo().iqp != null) {
        break label1057;
      }
    }
    label1031:
    label1052:
    label1057:
    for (long l = 0L;; l = getPayInfo().iqp.getLong("wallet_pay_key_check_time"))
    {
      if (l > 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(641L, 4L, 1L, true);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(641L, 5L, Util.milliSecondsToNow(l), true);
      }
      if (this.HHE > 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(641L, 7L, 1L, true);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(641L, 8L, Util.milliSecondsToNow(this.HHE), true);
      }
      AppMethodBeat.o(69456);
      return;
      com.tencent.mm.plugin.wallet.a.s.fOg();
      this.Hvb = com.tencent.mm.plugin.wallet.a.s.fOh().a(null, null, fOL(), false);
      break;
      this.HHi.setVisibility(8);
      this.HHi.setText("");
      break label773;
      i = 1;
      break label832;
    }
  }
  
  private Bankcard aUY(String paramString)
  {
    AppMethodBeat.i(69461);
    com.tencent.mm.plugin.wallet.a.s.fOg();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.fOh().yj(true);
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
  
  private void aey(int paramInt)
  {
    AppMethodBeat.i(69428);
    this.HHB = paramInt;
    Log.i(this.TAG, "markForceFinish errorType %s %s", new Object[] { Integer.valueOf(paramInt), Util.getStack().toString() });
    AppMethodBeat.o(69428);
  }
  
  private boolean b(com.tencent.mm.plugin.wallet.pay.a.c.f paramf)
  {
    int i = 0;
    AppMethodBeat.i(69474);
    boolean bool;
    if ("1".equals(paramf.egd))
    {
      Log.i(this.TAG, "need realname verify");
      this.HHt = true;
      paramf = new Bundle();
      paramf.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
      paramf.putString("realname_verify_process_jump_plugin", "wallet");
      isTransparent();
      if (this.mPayInfo != null) {
        i = this.mPayInfo.dVv;
      }
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf, null, i);
      AppMethodBeat.o(69474);
      return bool;
    }
    if ("2".equals(paramf.egd))
    {
      Log.i(this.TAG, "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramf.ege, paramf.egh, paramf.egf, paramf.egg, isTransparent(), null);
      AppMethodBeat.o(69474);
      return bool;
    }
    Log.i(this.TAG, "realnameGuideFlag =  " + paramf.egd);
    AppMethodBeat.o(69474);
    return false;
  }
  
  private void fOA()
  {
    AppMethodBeat.i(69441);
    if (this.HHq)
    {
      this.Cwg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int j = 0;
          AppMethodBeat.i(69387);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.wallet.a.s.fOg();
          int i;
          if (com.tencent.mm.plugin.wallet.a.s.fOh().fRl())
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
            if (WalletPayUI.this.CwO.HZf != 1) {
              break label227;
            }
            com.tencent.mm.plugin.wallet.a.s.fOg();
            if (com.tencent.mm.plugin.wallet.a.s.fOh().fRl())
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
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dDL)
          {
            af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.f(WalletPayUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69387);
            return;
            i = WalletPayUI.this.mPayInfo.dVv;
            break;
            paramAnonymousView = WalletPayUI.this.mPayInfo.dDL;
            break label77;
            i = WalletPayUI.this.mPayInfo.dVv;
            break label125;
          }
          label227:
          Log.i(WalletPayUI.this.TAG, "SimpleReg , assigned userinfo pay! payWithNewBankcard");
          com.tencent.mm.plugin.wallet.a.s.fOg();
          if (com.tencent.mm.plugin.wallet.a.s.fOh().fRl())
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
          for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dDL)
          {
            af.f(i, paramAnonymousView, 5, "");
            WalletPayUI.this.c(false, 0, "");
            break;
            i = WalletPayUI.this.mPayInfo.dVv;
            break label264;
          }
        }
      });
      AppMethodBeat.o(69441);
      return;
    }
    this.Cwg.setOnClickListener(new WalletPayUI.3(this));
    AppMethodBeat.o(69441);
  }
  
  private void fOF()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(69447);
    com.tencent.mm.plugin.report.service.h.CyF.a(13958, new Object[] { Integer.valueOf(1) });
    if ((this.mPayInfo != null) && (8 == this.mPayInfo.dVv))
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(13955, new Object[] { Integer.valueOf(2) });
      if (this.mPayInfo.iqp != null)
      {
        long l = this.mPayInfo.iqp.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.CyF.a(13956, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    Object localObject;
    if (this.HGf != null)
    {
      this.HGS = com.tencent.mm.plugin.wallet_core.ui.e.IcT.a(this.CwO);
      localObject = this.HGS.aVJ(this.HGf.HXI);
      if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).HEs != 0.0D)) {}
    }
    for (;;)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.wallet.a.s.fOg();
        if (com.tencent.mm.plugin.wallet.a.s.fOh().fRl())
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
          for (localObject = "";; localObject = this.mPayInfo.dDL)
          {
            af.f(i, (String)localObject, 3, "");
            fOG();
            AppMethodBeat.o(69447);
            return;
            i = this.mPayInfo.dVv;
            break;
          }
        }
        Log.i(this.TAG, "has useful bankcard ! payWithOldBankcard zeroPay");
        fOs();
        AppMethodBeat.o(69447);
        return;
      }
      if (this.HGW)
      {
        Log.i(this.TAG, "hy: start do pay with force use given bankcard");
        if (!Util.isNullOrNil(this.HGX))
        {
          this.Hvb = fOI();
          fOs();
          AppMethodBeat.o(69447);
          return;
        }
        com.tencent.mm.plugin.wallet.a.s.fOg();
        if (com.tencent.mm.plugin.wallet.a.s.fOh().fRm()) {
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
          i = this.mPayInfo.dVv;
          break;
          localObject = this.mPayInfo.dDL;
          break label370;
          com.tencent.mm.plugin.wallet.a.s.fOg();
        } while (!com.tencent.mm.plugin.wallet.a.s.fOh().fRl());
        if (this.mPayInfo == null)
        {
          i = 0;
          label440:
          if (this.mPayInfo != null) {
            break label474;
          }
        }
        label474:
        for (localObject = "";; localObject = this.mPayInfo.dDL)
        {
          af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.dVv;
          break label440;
        }
      }
      localObject = Util.nullAs(getIntent().getStringExtra("key_is_use_default_card"), "");
      if (!Util.isNullOrNil((String)localObject)) {
        this.Hvb = aUY((String)localObject);
      }
      if (this.Hvb == null)
      {
        if ((this.Hva != null) && (this.Hva.size() > 0))
        {
          Log.i(this.TAG, " no last pay bankcard ! jump to select bankcard!");
          d(false, 8, "");
          AppMethodBeat.o(69447);
          return;
        }
        Log.i(this.TAG, "default bankcard not found! payWithNewBankcard");
        com.tencent.mm.plugin.wallet.a.s.fOg();
        if (com.tencent.mm.plugin.wallet.a.s.fOh().fRm()) {
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
          i = this.mPayInfo.dVv;
          break;
          localObject = this.mPayInfo.dDL;
          break label614;
          com.tencent.mm.plugin.wallet.a.s.fOg();
        } while (!com.tencent.mm.plugin.wallet.a.s.fOh().fRl());
        if (this.mPayInfo == null)
        {
          i = 0;
          label684:
          if (this.mPayInfo != null) {
            break label718;
          }
        }
        label718:
        for (localObject = "";; localObject = this.mPayInfo.dDL)
        {
          af.f(i, (String)localObject, 5, "");
          break;
          i = this.mPayInfo.dVv;
          break label684;
        }
      }
      i = this.Hvb.a(this.CwO.HQg, this.CwO);
      if (this.CqM != null) {
        this.CqM.cG(10002, "");
      }
      if (i != 0)
      {
        Log.i(this.TAG, "main bankcard(" + i + ") is useless! jump to select bankcard!");
        d(false, i, "");
        AppMethodBeat.o(69447);
        return;
      }
      com.tencent.mm.plugin.wallet.a.s.fOg();
      if (com.tencent.mm.plugin.wallet.a.s.fOh().fRl())
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
        for (localObject = "";; localObject = this.mPayInfo.dDL)
        {
          af.f(i, (String)localObject, 3, "");
          fOG();
          AppMethodBeat.o(69447);
          return;
          i = this.mPayInfo.dVv;
          break;
        }
      }
      Log.i(this.TAG, "has useful bankcard ! payWithOldBankcard");
      fOs();
      AppMethodBeat.o(69447);
      return;
      i = 0;
    }
  }
  
  private void fOG()
  {
    AppMethodBeat.i(69448);
    xY(true);
    com.tencent.mm.plugin.wallet_core.utils.f.fUi();
    AppMethodBeat.o(69448);
  }
  
  private Bankcard fOI()
  {
    AppMethodBeat.i(69460);
    com.tencent.mm.plugin.wallet.a.s.fOg();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.fOh().yj(true);
    if (((ArrayList)localObject).size() != 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bankcard localBankcard = (Bankcard)((Iterator)localObject).next();
        if (Util.nullAsNil(this.HGX).equals(localBankcard.field_bindSerial))
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
  
  private boolean fOJ()
  {
    AppMethodBeat.i(69465);
    if (isTransparent())
    {
      setContentViewVisibility(4);
      com.tencent.mm.ui.ao.q(this, 0);
      AppMethodBeat.o(69465);
      return false;
    }
    setContentViewVisibility(0);
    com.tencent.mm.ui.ao.q(this, getActionbarColor());
    AppMethodBeat.o(69465);
    return true;
  }
  
  private boolean fOK()
  {
    AppMethodBeat.i(69468);
    if ((this.CwO != null) && (this.CwO.HYU))
    {
      com.tencent.mm.kernel.g.aAi();
      if (((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(196614, Boolean.TRUE)).booleanValue())
      {
        Object localObject = getLayoutInflater().inflate(2131496987, null);
        CheckBox localCheckBox = (CheckBox)((View)localObject).findViewById(2131309173);
        ga((View)localObject);
        ((TextView)((View)localObject).findViewById(2131309187)).setOnClickListener(new WalletPayUI.22(this, localCheckBox));
        localObject = com.tencent.mm.ui.base.h.a(this, getString(2131768156), (View)localObject, getString(2131767627), getString(2131768252), new WalletPayUI.24(this, localCheckBox), new WalletPayUI.25(this));
        ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
        localCheckBox.setOnCheckedChangeListener(new WalletPayUI.26(this, (com.tencent.mm.ui.widget.a.d)localObject));
        AppMethodBeat.o(69468);
        return false;
      }
    }
    AppMethodBeat.o(69468);
    return true;
  }
  
  private boolean fOk()
  {
    AppMethodBeat.i(69449);
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oft, Integer.valueOf(0))).intValue();
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      i = 1;
    }
    if ((i == 1) || ((this.CwO != null) && (this.CwO.HZA == 1)))
    {
      AppMethodBeat.o(69449);
      return true;
    }
    AppMethodBeat.o(69449);
    return false;
  }
  
  private boolean fOx()
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
  
  private void fOz()
  {
    AppMethodBeat.i(69440);
    if (this.CwO == null)
    {
      Log.e(this.TAG, "updatePaymentMethodForFavor mOrders is null");
      AppMethodBeat.o(69440);
      return;
    }
    this.HHg.setVisibility(8);
    this.HHf.setVisibility(8);
    this.Cwg.setText(2131768110);
    this.HHo.setVisibility(0);
    this.HHp.setVisibility(0);
    View localView = this.HHp.findViewById(2131297243);
    Object localObject = this.HHp.findViewById(2131296526);
    final CheckedTextView localCheckedTextView1;
    final CheckedTextView localCheckedTextView2;
    int i;
    if ("CFT".equals(this.CwO.HYY))
    {
      ((View)localObject).setVisibility(8);
      localCheckedTextView1 = (CheckedTextView)this.HHp.findViewById(2131297237);
      localCheckedTextView2 = (CheckedTextView)this.HHp.findViewById(2131296525);
      localView.setEnabled(true);
      if ((this.CwO == null) || (this.CwO.HZd == null) || (this.CwO.HZd.size() <= 0)) {
        break label772;
      }
      if (this.CwO.HYN != 1) {
        break label574;
      }
      i = 1;
    }
    label772:
    for (;;)
    {
      label200:
      if (this.Hvb == null)
      {
        localView.setVisibility(8);
        label213:
        ((View)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69425);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            localCheckedTextView1.setChecked(false);
            localCheckedTextView2.setChecked(true);
            WalletPayUI.a(WalletPayUI.this, true);
            WalletPayUI.e(WalletPayUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69425);
          }
        });
        this.HHo.setVisibility(0);
        this.HHp.setVisibility(0);
        if (this.HGf == null) {
          break label767;
        }
        this.HGS = com.tencent.mm.plugin.wallet_core.ui.e.IcT.a(this.CwO);
        localObject = this.HGS.aVJ(this.HGf.HXI);
        if ((localObject == null) || (((com.tencent.mm.plugin.wallet.a.j)localObject).HEs != 0.0D)) {
          break label767;
        }
        this.HHp.setVisibility(8);
        this.HHo.setVisibility(8);
      }
      label486:
      label767:
      for (int j = 1;; j = 0)
      {
        this.HHq = true;
        if (j != 0) {
          this.HHq = false;
        }
        localCheckedTextView1.setChecked(false);
        localCheckedTextView2.setChecked(true);
        Log.i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.CwO.HZf);
        if (this.CwO.HZf == 1)
        {
          this.HHp.findViewById(2131299674).setVisibility(0);
          ((TextView)this.HHp.findViewById(2131299673)).setText(this.CwO.HZg);
          if (!TextUtils.isEmpty(this.CwO.HZh))
          {
            ((TextView)this.HHp.findViewById(2131300542)).setText(" (" + this.CwO.HZh + ")");
            if ((this.Hvb != null) && (this.Hvb.fQb()) && (!TextUtils.isEmpty(this.Hvb.field_forbidWord)))
            {
              localView.setEnabled(false);
              localCheckedTextView1.setVisibility(8);
              ((TextView)this.HHp.findViewById(2131297250)).setText(this.Hvb.field_forbidWord);
            }
          }
        }
        for (;;)
        {
          fOA();
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
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              localCheckedTextView1.setChecked(true);
              localCheckedTextView2.setChecked(false);
              WalletPayUI.a(WalletPayUI.this, false);
              WalletPayUI.e(WalletPayUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69424);
            }
          });
          break label213;
          ((TextView)this.HHp.findViewById(2131300542)).setText("");
          break label486;
          this.HHp.findViewById(2131299674).setVisibility(8);
          if ((this.Hvb != null) && (this.Hvb.fQb()) && (!TextUtils.isEmpty(this.Hvb.field_forbidWord)))
          {
            localView.setEnabled(false);
            localCheckedTextView1.setVisibility(8);
            ((TextView)this.HHp.findViewById(2131297250)).setText(this.Hvb.field_forbidWord);
          }
          else if ((this.Hvb != null) && (this.Hvb.fQb()) && (TextUtils.isEmpty(this.Hvb.field_forbidWord)) && (i == 0))
          {
            localCheckedTextView1.setChecked(true);
            localCheckedTextView2.setChecked(false);
            this.HHq = false;
          }
        }
      }
      label574:
      i = 0;
    }
  }
  
  private void ga(View paramView)
  {
    AppMethodBeat.i(69469);
    paramView = (TextView)paramView.findViewById(2131305273);
    paramView.setText(Html.fromHtml(String.format(getResources().getString(2131768154), new Object[] { getResources().getString(2131767405) })));
    paramView.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69469);
  }
  
  private void m(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(69437);
    if ((this.mPayInfo != null) && (this.mPayInfo.dVv == 46) && (this.CwO != null))
    {
      paramIntent.putExtra("key_total_fee", this.CwO.dDO);
      Log.i(this.TAG, "sentCancelEvent set fee:%s", new Object[] { Double.valueOf(this.CwO.dDO) });
    }
    aaa localaaa = new aaa();
    localaaa.egJ.intent = paramIntent;
    aaa.a locala;
    if (this.HHB == 1)
    {
      localaaa.egJ.egK = 1000;
      localaaa.egJ.result = paramInt;
      locala = localaaa.egJ;
      if (this.mPayInfo != null) {
        break label217;
      }
    }
    label217:
    for (paramIntent = "";; paramIntent = this.mPayInfo.dDL)
    {
      locala.dDL = paramIntent;
      localaaa.egJ.egM = 1;
      if ((this.mPayInfo != null) && (paramInt == 0)) {
        com.tencent.mm.plugin.wallet.pay.a.b.b.aD(this.mPayInfo.dDL, this.mPayInfo.dVv, this.mPayInfo.channel);
      }
      EventCenter.instance.publish(localaaa);
      AppMethodBeat.o(69437);
      return;
      if (this.HHB != 2) {
        break;
      }
      localaaa.egJ.egK = 1001;
      break;
    }
  }
  
  protected void aI(Bundle paramBundle)
  {
    AppMethodBeat.i(69471);
    this.HGU = true;
    if (this.CwO != null)
    {
      paramBundle.putInt("key_support_bankcard", this.CwO.HQg);
      paramBundle.putString("key_reqKey", this.CwO.dDL);
      if ((this.CwO.HZd != null) && (this.CwO.HZd.size() > 0)) {
        paramBundle.putString("key_TransId", ((Orders.Commodity)this.CwO.HZd.get(0)).dDM);
      }
      paramBundle.putLong("key_SessionId", this.HHn);
    }
    if (this.mPayInfo != null) {
      paramBundle.putInt("key_scene", this.mPayInfo.dVv);
    }
    if (!fOD()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      paramBundle.putInt("is_deduct_open", this.HHv);
      this.HGV = new d.a()
      {
        public final Intent q(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(214057);
          Log.i(WalletPayUI.this.TAG, "pay process end");
          WalletPayUI.this.HGU = false;
          paramAnonymousBundle = new Intent();
          AppMethodBeat.o(214057);
          return paramAnonymousBundle;
        }
      };
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, paramBundle, this.HGV);
      AppMethodBeat.o(69471);
      return;
    }
  }
  
  protected final void bo(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(69455);
    com.tencent.mm.plugin.report.service.h.CyF.a(13958, new Object[] { Integer.valueOf(2) });
    com.tencent.mm.plugin.report.service.h.CyF.a(13955, new Object[] { Integer.valueOf(4) });
    if (this.mPayInfo == null) {
      if (this.mPayInfo != null) {
        break label226;
      }
    }
    label226:
    for (Object localObject = "";; localObject = this.mPayInfo.dDL)
    {
      af.f(i, (String)localObject, 11, "");
      localObject = getInput();
      ((Bundle)localObject).putInt("key_main_bankcard_state", paramInt);
      ((Bundle)localObject).putParcelable("key_orders", this.CwO);
      ((Bundle)localObject).putParcelable("key_pay_info", this.mPayInfo);
      ((Bundle)localObject).putParcelable("key_authen", fOC());
      ((Bundle)localObject).putString("key_pwd1", this.krw);
      ((Bundle)localObject).putInt("key_pay_flag", 3);
      ((Bundle)localObject).putInt("key_err_code", -1004);
      ((Bundle)localObject).putParcelable("key_favor_pay_info", this.HGf);
      ((Bundle)localObject).putBoolean("key_is_filter_bank_type", paramBoolean);
      if (this.Hvb != null) {
        ((Bundle)localObject).putString("key_is_cur_bankcard_bind_serial", this.Hvb.field_bindSerial);
      }
      aI((Bundle)localObject);
      AppMethodBeat.o(69455);
      return;
      i = this.mPayInfo.dVv;
      break;
    }
  }
  
  protected final boolean bqg()
  {
    AppMethodBeat.i(69459);
    String str2;
    String str1;
    if ((this.CwO == null) || (this.CwO.HZd == null) || (this.CwO.HZd.size() <= 0))
    {
      Log.w(this.TAG, "mOrders info is Illegal!");
      if ((this.HGR != null) && (this.HGR.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      str2 = getString(2131767999);
      str1 = str2;
      if (this.HGR != null)
      {
        str1 = str2;
        if (!Util.isNullOrNil(this.HGR.errMsg)) {
          str1 = this.HGR.errMsg;
        }
      }
      Log.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.d(getContext(), str1, "", new WalletPayUI.20(this));
      AppMethodBeat.o(69459);
      return false;
    }
    if ((this.HGW) && (!Util.isNullOrNil(this.HGX)) && (fOI() == null))
    {
      if ((this.HGR != null) && (this.HGR.isJumpRemind()))
      {
        AppMethodBeat.o(69459);
        return false;
      }
      Log.w(this.TAG, "hy: should use given bankcard, but resolved as null. show error msg and quit");
      str2 = getString(2131767999);
      str1 = str2;
      if (this.HGR != null)
      {
        str1 = str2;
        if (!Util.isNullOrNil(this.HGR.errMsg)) {
          str1 = this.HGR.errMsg;
        }
      }
      Log.i(this.TAG, "checkInfo() errMsg:%s", new Object[] { str1 });
      com.tencent.mm.ui.base.h.d(getContext(), str1, "", new WalletPayUI.21(this));
      AppMethodBeat.o(69459);
      return false;
    }
    AppMethodBeat.o(69459);
    return true;
  }
  
  protected final void c(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69452);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
    com.tencent.mm.plugin.wallet.a.s.fOg();
    Log.d(str, com.tencent.mm.plugin.wallet.a.s.fOh().fRk() + ", need confirm ? " + paramBoolean);
    if (paramBoolean)
    {
      if (!Util.isNullOrNil(paramString)) {
        break label130;
      }
      paramString = Bankcard.au(this, paramInt);
    }
    label130:
    for (;;)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, "", getString(2131768113), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69398);
          WalletPayUI.this.fOH();
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
      fOH();
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
      fOs();
    }
    AppMethodBeat.o(69466);
  }
  
  public final void d(boolean paramBoolean, final int paramInt, String paramString)
  {
    AppMethodBeat.i(69453);
    Log.d(this.TAG, "pay with select bankcard! need confirm ? ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (!Util.isNullOrNil(paramString)) {
        break label118;
      }
      paramString = Bankcard.au(this, paramInt);
    }
    label118:
    for (;;)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, "", getString(2131768132), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69401);
          if (WalletPayUI.m(WalletPayUI.this))
          {
            WalletPayUI.this.xX(true);
            AppMethodBeat.o(69401);
            return;
          }
          WalletPayUI.this.bo(paramInt, false);
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
      if (fOk())
      {
        xX(true);
        AppMethodBeat.o(69453);
        return;
      }
      bo(paramInt, false);
      AppMethodBeat.o(69453);
      return;
    }
  }
  
  public final void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69472);
    Log.i(this.TAG, "onGenFinish callback");
    if (paramBoolean)
    {
      Log.i(this.TAG, "onGenFinish callback, result.isSuccess is true");
      this.mPayInfo.dNR = paramString1;
      this.mPayInfo.dNS = paramString2;
      xY(false);
      com.tencent.mm.plugin.wallet_core.utils.f.fUi();
      AppMethodBeat.o(69472);
      return;
    }
    Log.e(this.TAG, "onGenFinish callback, result.isSuccess is false");
    xY(false);
    com.tencent.mm.plugin.wallet_core.utils.f.fUi();
    AppMethodBeat.o(69472);
  }
  
  public final void fOB()
  {
    AppMethodBeat.i(69442);
    com.tencent.mm.plugin.wallet.a.j localj = this.HGS.aVJ(this.HGf.HXI);
    List localList = this.HGS.fSz();
    com.tencent.mm.plugin.wallet.a.h localh = this.HGS.IcO;
    Object localObject1 = "";
    double d2;
    Object localObject2;
    int i;
    double d1;
    if (localj != null)
    {
      d2 = localj.HEA;
      if (d2 > 0.0D)
      {
        localObject2 = localj.HEC;
        int j = 1;
        localObject1 = localObject2;
        i = j;
        d1 = d2;
        if (!Util.isNullOrNil(localj.HED))
        {
          localObject1 = (String)localObject2 + "," + localj.HED;
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
          localObject2 = (String)localObject1 + getContext().getString(2131768195);
        }
      }
      if ((d1 > 0.0D) && (localh != null) && (localh.HEw == 0))
      {
        if (localj != null) {
          this.HHb.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(localj.HEz));
        }
        this.HHe.setText(com.tencent.mm.wallet_core.ui.f.bpq(this.CwO.AOl));
        this.HHd.setText(com.tencent.mm.wallet_core.ui.f.d(this.CwO.dDO, this.CwO.AOl));
        this.HHd.setVisibility(0);
      }
      for (;;)
      {
        if (!Util.isNullOrNil((String)localObject2)) {
          this.HHj.setText((CharSequence)localObject2);
        }
        AppMethodBeat.o(69442);
        return;
        this.HHb.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.CwO.dDO));
        this.HHe.setText(com.tencent.mm.wallet_core.ui.f.bpq(this.CwO.AOl));
        this.HHd.setVisibility(8);
      }
      i = 0;
      d1 = d2;
      continue;
      i = 0;
      d1 = 0.0D;
    }
  }
  
  protected final Authen fOC()
  {
    AppMethodBeat.i(69443);
    Authen localAuthen = new Authen();
    if (fOD()) {}
    for (localAuthen.cSx = 3;; localAuthen.cSx = 6)
    {
      if (!Util.isNullOrNil(this.krw)) {
        localAuthen.HUO = this.krw;
      }
      if (this.Hvb != null)
      {
        localAuthen.ANo = this.Hvb.field_bindSerial;
        localAuthen.dDj = this.Hvb.field_bankcardType;
      }
      if ((this.HGf != null) && (this.HGS != null) && (this.HGS.fSw()))
      {
        localAuthen.HUY = this.HGf.HXI;
        localAuthen.HUX = this.HGf.HXL;
      }
      localAuthen.BDB = this.mPayInfo;
      AppMethodBeat.o(69443);
      return localAuthen;
    }
  }
  
  protected final boolean fOD()
  {
    AppMethodBeat.i(69444);
    if ((this.Hvb != null) && (this.CwO != null) && (this.CwO.HQg == 3))
    {
      if (this.Hvb.fQe())
      {
        AppMethodBeat.o(69444);
        return true;
      }
      AppMethodBeat.o(69444);
      return false;
    }
    if ((this.CwO != null) && (!Bankcard.aeI(this.CwO.HQg)))
    {
      AppMethodBeat.o(69444);
      return true;
    }
    AppMethodBeat.o(69444);
    return false;
  }
  
  protected final void fOE()
  {
    AppMethodBeat.i(69445);
    xW(true);
    AppMethodBeat.o(69445);
  }
  
  protected final void fOH()
  {
    AppMethodBeat.i(69454);
    Bundle localBundle = getIntent().getExtras();
    com.tencent.mm.plugin.wallet.a.s.fOg();
    if (com.tencent.mm.plugin.wallet.a.s.fOh().fRk()) {}
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("key_pay_flag", i);
      localBundle.putParcelable("key_orders", this.CwO);
      localBundle.putParcelable("key_pay_info", this.mPayInfo);
      localBundle.putParcelable("key_favor_pay_info", this.HGf);
      aI(localBundle);
      AppMethodBeat.o(69454);
      return;
    }
  }
  
  protected final boolean fOL()
  {
    return (this.mPayInfo != null) && (this.mPayInfo.dVv != 11);
  }
  
  protected void fOs()
  {
    AppMethodBeat.i(69450);
    xX(false);
    AppMethodBeat.o(69450);
  }
  
  protected void fOy()
  {
    int i = 2;
    AppMethodBeat.i(69432);
    com.tencent.mm.plugin.report.service.h.CyF.a(11850, new Object[] { Integer.valueOf(2), Integer.valueOf(this.mPayInfo.dVv) });
    if (this.mPayInfo.dVv == 11) {
      i = 3;
    }
    Object localObject = this.mPayInfo;
    if ((localObject == null) || (Util.isNullOrNil(((PayInfo)localObject).dDL)))
    {
      Log.i("MicroMsg.CgiManager", "no payInfo or reqKey");
      localObject = null;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessName("PayProcess");
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setProcessSessionId(this.HHn);
        if ((this.mPayInfo.dVv != 6) || (this.mPayInfo.Kxr != 100)) {
          break label446;
        }
        ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(100);
        label134:
        if (!this.mPayInfo.Kxs) {
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
      String str = ((PayInfo)localObject).dDL;
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
      ((com.tencent.mm.plugin.wallet.pay.a.c.f)localObject).setScene(this.mPayInfo.dVv);
      break label134;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(69434);
    Log.i(this.TAG, "finish %s %s mPayResultType:%s", new Object[] { Integer.valueOf(hashCode()), Util.getStack().toString(), Integer.valueOf(this.mPayResultType) });
    cancelQRPay();
    if ((this.CwO != null) && (!this.CwO.HZd.isEmpty())) {
      getIntent().putExtra("key_trans_id", ((Orders.Commodity)this.CwO.HZd.get(0)).dDM);
    }
    if (this.mPayInfo != null) {
      getIntent().putExtra("key_reqKey", this.mPayInfo.dDL);
    }
    com.tencent.mm.wallet_core.d locald;
    if (this.isPaySuccess)
    {
      if (this.CwO != null) {
        getIntent().putExtra("key_total_fee", this.CwO.dDO);
      }
      getIntent().putExtra("key_pay_reslut_type", 1);
      m(-1, getIntent());
      setResult(-1, getIntent());
      locald = getProcess();
      if (locald != null) {
        if (locald.RrY == null) {
          break label717;
        }
      }
    }
    label408:
    label439:
    label570:
    label581:
    label717:
    for (Object localObject = (Context)locald.RrY.get();; localObject = null)
    {
      if (this == localObject)
      {
        Log.i(this.TAG, "remove process end callback to prevent ui leak");
        locald.hgH();
      }
      super.finish();
      AppMethodBeat.o(69434);
      return;
      if ((this.mPayInfo != null) && (this.mPayInfo.dVv == 8) && (this.CwO != null))
      {
        this.mPayInfo.Kxz = 0;
        doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.a(fOC(), this.CwO, true), false);
        if (this.mPayInfo.iqp != null)
        {
          long l = this.mPayInfo.iqp.getLong("extinfo_key_9");
          com.tencent.mm.plugin.report.service.h.CyF.a(13956, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      m(0, getIntent());
      getIntent().putExtra("key_pay_reslut_type", this.mPayResultType);
      int i;
      if (this.HHB == 1)
      {
        getIntent().putExtra("key_pay_reslut_type", 1000);
        setResult(0, getIntent());
        com.tencent.mm.plugin.wallet.a.s.fOg();
        if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRm()) {
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
      for (localObject = "";; localObject = this.mPayInfo.dDL)
      {
        af.f(i, (String)localObject, 18, "");
        localObject = com.tencent.mm.wallet_core.a.bpk("PayProcess").iterator();
        while (((Iterator)localObject).hasNext())
        {
          locald = (com.tencent.mm.wallet_core.d)((Iterator)localObject).next();
          locald.K(new Object[] { "specEndProcessWithoutFinish" });
          if (locald.dQL != null) {
            locald.dQL.clear();
          }
          com.tencent.mm.wallet_core.a.remove(locald.getClass().hashCode());
          locald.fOj();
        }
        break;
        if (this.HHB != 2) {
          break label408;
        }
        getIntent().putExtra("key_pay_reslut_type", 1001);
        break label408;
        i = this.mPayInfo.dVv;
        break label439;
      }
      label593:
      com.tencent.mm.plugin.wallet.a.s.fOg();
      if (com.tencent.mm.plugin.wallet.a.s.fOh().fRl())
      {
        if (this.mPayInfo == null)
        {
          i = 0;
          label615:
          if (this.mPayInfo != null) {
            break label649;
          }
        }
        for (localObject = "";; localObject = this.mPayInfo.dDL)
        {
          af.f(i, (String)localObject, 4, "");
          break;
          i = this.mPayInfo.dVv;
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
      for (localObject = "";; localObject = this.mPayInfo.dDL)
      {
        af.f(i, (String)localObject, 7, "");
        break;
        i = this.mPayInfo.dVv;
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
    return 2131496988;
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
    com.tencent.mm.ui.ao.e(getWindow());
    MMScrollView localMMScrollView = (MMScrollView)findViewById(2131310296);
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.Cwg = ((Button)findViewById(2131310276));
    this.Cwg.setClickable(false);
    this.Cwg.setEnabled(false);
    this.HHb = ((TextView)findViewById(2131310265));
    this.HHc = ((TextView)findViewById(2131310264));
    this.HHe = ((TextView)findViewById(2131310246));
    this.HHj = ((TextView)findViewById(2131310242));
    this.HHd = ((TextView)findViewById(2131310252));
    this.HHi = ((TextView)findViewById(2131310272));
    this.HHd.getPaint().setFlags(16);
    this.HHf = ((TextView)findViewById(2131310277));
    this.HHg = ((TextView)findViewById(2131310273));
    this.HHg.setOnClickListener(new x()
    {
      public final void czW()
      {
        AppMethodBeat.i(69416);
        WalletPayUI.this.c(false, 0, "");
        AppMethodBeat.o(69416);
      }
    });
    this.HHh = ((ImageView)findViewById(2131310239));
    this.HHh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69417);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (WalletPayUI.this.HGY) {
          WalletPayUI.this.HHh.setImageResource(2131234362);
        }
        for (WalletPayUI.this.HGY = false;; WalletPayUI.this.HGY = true)
        {
          WalletPayUI.this.HHl.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69417);
          return;
          WalletPayUI.this.HHh.setImageResource(2131234365);
        }
      }
    });
    this.HHk = ((LinearLayout)findViewById(2131310249));
    this.HHl = new a();
    this.Cwg.setOnClickListener(new x()
    {
      public final void czW()
      {
        AppMethodBeat.i(69418);
        com.tencent.mm.plugin.wallet.a.s.fOg();
        int i;
        if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRl())
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
        for (String str = "";; str = WalletPayUI.this.mPayInfo.dDL)
        {
          af.f(i, str, 6, "");
          WalletPayUI.this.fOE();
          WalletPayUI.this.HHa = true;
          AppMethodBeat.o(69418);
          return;
          i = WalletPayUI.this.mPayInfo.dVv;
          break;
        }
      }
    });
    this.Cwg.setText(2131768110);
    this.HHo = ((TextView)findViewById(2131305853));
    this.HHp = ((LinearLayout)findViewById(2131305852));
    updateView();
    AppMethodBeat.o(69438);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69464);
    if (this.HHw)
    {
      String str1 = this.TAG;
      boolean bool1;
      label87:
      String str2;
      int i;
      if ((getPayInfo() == null) || (!getPayInfo().crp))
      {
        bool1 = true;
        Log.i(str1, "case 1 %s,  stack %s", new Object[] { Boolean.valueOf(bool1), Util.getStack().toString() });
        str1 = this.TAG;
        com.tencent.mm.plugin.wallet.a.s.fOg();
        if (com.tencent.mm.plugin.wallet.a.s.fOh().fRk()) {
          break label196;
        }
        bool1 = true;
        Log.d(str1, "case 2 %s,", new Object[] { Boolean.valueOf(bool1) });
        str2 = this.TAG;
        if (this.Hva != null) {
          break label201;
        }
        i = 0;
        label121:
        if (this.Hvb != null) {
          break label212;
        }
      }
      label196:
      label201:
      label212:
      for (str1 = "";; str1 = this.Hvb.field_forbidWord)
      {
        Log.d(str2, "case 3 mBankcardList %s, mDefaultBankcard %s", new Object[] { Integer.valueOf(i), str1 });
        if ((getPayInfo() != null) && (getPayInfo().crp)) {
          break label224;
        }
        Log.i(this.TAG, "get isTransparent1");
        AppMethodBeat.o(69464);
        return false;
        bool1 = false;
        break;
        bool1 = false;
        break label87;
        i = this.Hva.size();
        break label121;
      }
      label224:
      com.tencent.mm.plugin.wallet.a.s.fOg();
      if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRk())
      {
        Log.i(this.TAG, "get isTransparent2");
        AppMethodBeat.o(69464);
        return false;
      }
      if ((this.Hva != null) && ((this.Hva.size() == 0) || ((this.Hvb != null) && (!Util.isNullOrNil(this.Hvb.field_forbidWord)))))
      {
        str1 = this.TAG;
        if ((this.Hva != null) && (this.Hva.size() == 0))
        {
          bool1 = true;
          if ((this.Hvb == null) || (Util.isNullOrNil(this.Hvb.field_forbidWord))) {
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
          this.HHv = paramIntent.getIntExtra("auto_deduct_flag", -1);
          if ((this.CwO != null) && (this.CwO.HZi != null)) {
            this.CwO.HZi.HHv = this.HHv;
          }
          getPayInfo().Kxw = this.HHv;
          if (this.HHv == 1)
          {
            getPayInfo().Kxx = paramIntent.getStringExtra("deduct_bank_type");
            getPayInfo().Kxy = paramIntent.getStringExtra("deduct_bind_serial");
          }
        }
        this.HHu = true;
        onProgressFinish();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(13958, new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(69462);
        return;
        finish();
      }
      this.HHm.dismiss();
      this.HHa = false;
      fOy();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69429);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.TAG = ("MicroMsg.WalletPayUI@" + hashCode());
    if (HGP)
    {
      Log.w(this.TAG, "has Undestory WalletPayUI!");
      com.tencent.mm.plugin.report.service.h.CyF.n(965L, 1L, 1L);
      aey(2);
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    HGP = true;
    long l = System.currentTimeMillis();
    int j = getIntent().getIntExtra("key_context_hashcode", -1);
    paramBundle = new b[HGQ.size()];
    Log.i(this.TAG, "WalletPayUI check %s this %s fromHashCode %s", new Object[] { Integer.valueOf(HGQ.size()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
    paramBundle = (b[])HGQ.toArray(paramBundle);
    int k = paramBundle.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = paramBundle[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localObject.mZg.get();
      if (localWalletPayUI != null)
      {
        Log.w(this.TAG, "has old payui, both finish %s", new Object[] { Integer.valueOf(localWalletPayUI.hashCode()) });
        if ((j != localObject.aHK) || (j == -1)) {
          break label290;
        }
        localWalletPayUI.aey(2);
        com.tencent.mm.plugin.report.service.h.CyF.n(965L, 41L, 1L);
      }
      for (;;)
      {
        HGQ.remove(localObject);
        localWalletPayUI.finish();
        i += 1;
        break;
        label290:
        localWalletPayUI.aey(1);
        com.tencent.mm.plugin.report.service.h.CyF.n(965L, 40L, 1L);
      }
    }
    this.HHD = new b((byte)0);
    this.HHD.timestamp = l;
    this.HHD.aHK = j;
    this.HHD.mZg = new WeakReference(this);
    HGQ.add(this.HHD);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.e(this.TAG, "hy: account not ready. finish now");
      finish();
      AppMethodBeat.o(69429);
      return;
    }
    getWindow().getDecorView().postDelayed(this.HHC, 5000L);
    this.HHE = Util.nowMilliSecond();
    EventCenter.instance.addListener(this.Cuh);
    com.tencent.mm.plugin.wallet_core.model.k.aeJ(5);
    this.CqM = com.tencent.mm.plugin.wallet.a.be(getIntent());
    setMMTitle(2131768160);
    this.mPayInfo = getPayInfo();
    this.HGW = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
    this.HGX = Util.nullAs(getIntent().getStringExtra("key_force_use_bind_serail"), "");
    this.Crn = getIntent().getStringExtra("key_receiver_true_name");
    if ((this.mPayInfo == null) || (this.mPayInfo.Kxv == 0L))
    {
      this.HHn = System.currentTimeMillis();
      com.tencent.mm.plugin.wallet.a.s.fOg();
      if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRk())
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
      if (fOx()) {
        break label763;
      }
      Log.d(this.TAG, "PayInfo = " + this.mPayInfo);
      if ((this.mPayInfo == null) || (Util.isNullOrNil(this.mPayInfo.dDL))) {
        break label705;
      }
      fOy();
      com.tencent.mm.plugin.secinforeport.a.d.CWG.asyncReportPaySecurityInfoThroughCgi();
      initView();
    }
    for (;;)
    {
      if (this.mPayInfo != null) {
        com.tencent.mm.plugin.wallet.pay.a.b.aUR(this.mPayInfo.KxB);
      }
      AppMethodBeat.o(69429);
      return;
      this.HHn = this.mPayInfo.Kxv;
      break;
      label683:
      i = this.mPayInfo.dVv;
      break label559;
      label694:
      paramBundle = this.mPayInfo.dDL;
      break label569;
      label705:
      if ((this.mPayInfo != null) && (!Util.isNullOrNil(this.mPayInfo.errMsg))) {}
      for (paramBundle = this.mPayInfo.errMsg;; paramBundle = getString(2131768153))
      {
        com.tencent.mm.ui.base.h.a(this, paramBundle, null, false, new WalletPayUI.23(this));
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
    if (this.HGg != null)
    {
      this.HGg.closeTipDialog();
      this.HGg.release();
    }
    EventCenter.instance.removeListener(this.Cuh);
    this.HGh = null;
    getWindow().getDecorView().removeCallbacks(this.HHC);
    HGQ.remove(this.HHD);
    HGP = false;
    long l = System.currentTimeMillis();
    b[] arrayOfb = new b[HGQ.size()];
    arrayOfb = (b[])HGQ.toArray(arrayOfb);
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      WalletPayUI localWalletPayUI = (WalletPayUI)localb.mZg.get();
      if ((localWalletPayUI != null) && (l - localb.timestamp > 600000L))
      {
        Log.w(this.TAG, "has old payui, both finish");
        com.tencent.mm.plugin.report.service.h.CyF.n(965L, 2L, 1L);
        HGQ.remove(localb);
        localWalletPayUI.aey(1);
        localWalletPayUI.finish();
      }
      i += 1;
    }
    if (this.mPayInfo != null) {
      com.tencent.mm.plugin.wallet.pay.a.b.aUS(this.mPayInfo.KxB);
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
      if ((this.HHm != null) && (this.mPayInfo != null) && (this.mPayInfo.crp) && (!this.mNetSceneMgr.isProcessing())) {
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
    if (!fOx())
    {
      Log.w(this.TAG, "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
      if (paramIntent.getBooleanExtra("send_cancel_event", true)) {
        m(0, getIntent());
      }
      this.isPaySuccess = false;
    }
    if (paramIntent.getBooleanExtra("direc_change_bankcard", false))
    {
      xX(true);
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false))) {
      this.HHr = true;
    }
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(this.TAG, "isFromBindCard is true");
      fOy();
      AppMethodBeat.o(69436);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_is_realname_verify_process", false)))
    {
      this.HHs = true;
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
    if (this.HGh != null) {
      this.HGh.onActivityPause();
    }
    AppMethodBeat.o(69473);
  }
  
  public boolean onProgressFinish()
  {
    boolean bool2 = false;
    AppMethodBeat.i(69463);
    Log.i(this.TAG, "onProgressFinish isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.HHz) });
    EventCenter.instance.publish(new zp());
    int i;
    int j;
    label93:
    Object localObject;
    label104:
    boolean bool1;
    if ((this.CwO != null) && (this.CwO.HZi != null) && (!this.HHu))
    {
      i = 1;
      if ((i == 0) && (!fOJ()))
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
      if (!this.HHz) {
        break label163;
      }
      xW(true);
      bool1 = true;
    }
    for (;;)
    {
      AppMethodBeat.o(69463);
      return bool1;
      i = 0;
      break;
      label140:
      j = this.mPayInfo.dVv;
      break label93;
      label151:
      localObject = this.mPayInfo.dDL;
      break label104;
      label163:
      if (this.HHt)
      {
        bool1 = true;
      }
      else if (i != 0)
      {
        localObject = new Intent(this, WalletPayDeductUI.class);
        ((Intent)localObject).putExtra("orders", this.CwO);
        startActivityForResult((Intent)localObject, 0);
        bool1 = true;
      }
      else if (getContentView().getVisibility() != 0)
      {
        if ((!this.HHa) && (bqg()))
        {
          xW(true);
          this.HHa = true;
        }
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (getContentView().getVisibility() == 0)
        {
          bool1 = bool2;
          if (this.CwO != null)
          {
            bool1 = bool2;
            if (this.CwO.HZi != null)
            {
              bool1 = bool2;
              if (this.Cwg.isEnabled())
              {
                bool1 = bool2;
                if (!this.HHx)
                {
                  this.Cwg.performClick();
                  this.HHx = true;
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
    Log.i(this.TAG, "hy: onResume isFromH5RealNameVerify %s", new Object[] { Boolean.valueOf(this.HHz) });
    if (!isProcessing())
    {
      if (!Util.isNullOrNil(this.HGX)) {
        this.Hvb = fOI();
      }
    }
    else
    {
      if (!this.HHA) {
        break label149;
      }
      Log.i(this.TAG, "onResume isResumePassFinish");
      this.HHA = false;
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(69433);
      return;
      if (this.Hvb == null)
      {
        com.tencent.mm.plugin.wallet.a.s.fOg();
        this.Hvb = com.tencent.mm.plugin.wallet.a.s.fOh().a(null, null, fOL(), false);
        break;
      }
      com.tencent.mm.plugin.wallet.a.s.fOg();
      this.Hvb = com.tencent.mm.plugin.wallet.a.s.fOh().a(null, this.Hvb.field_bindSerial, fOL(), false);
      break;
      label149:
      if ((this.HGU) && (getContentViewVisibility() != 0) && ((this.HHm == null) || (!this.HHm.isShowing())))
      {
        Log.i(this.TAG, "hy: has started process and is transparent and no pwd appeared. finish self");
        finish();
      }
      else if (this.HGh != null)
      {
        this.HGh.fSA();
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
        this.HGR = ((com.tencent.mm.plugin.wallet.pay.a.c.f)paramq);
        paramString = (com.tencent.mm.plugin.wallet.pay.a.c.f)paramq;
        if (paramString.isJumpRemind())
        {
          paramq = paramString.getJumpRemind();
          paramq.hhn();
          paramq.a(this, new com.tencent.mm.wallet_core.c.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(69403);
              if (paramq.hhm())
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
              if (paramq.hhm())
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
              if (paramq.hhm())
              {
                WalletPayUI.a(WalletPayUI.this, paramString);
                AppMethodBeat.o(69404);
                return;
              }
              WalletPayUI.this.fOy();
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
      paramString.putParcelable("key_bankcard", this.Hvb);
      paramString.putString("key_bank_type", this.Hvb.field_bankcardType);
      if (!Util.isNullOrNil(this.krw)) {
        paramString.putString("key_pwd1", this.krw);
      }
      paramString.putString("kreq_token", paramq.getToken());
      paramString.putParcelable("key_authen", paramq.HFI);
      if (!paramq.HFG)
      {
        bool = true;
        paramString.putBoolean("key_need_verify_sms", bool);
        paramString.putInt("key_can_verify_tail", paramq.HFM);
        paramString.putString("key_verify_tail_wording", paramq.HFN);
        localObject1 = getInput();
        if (paramq.HFO != 1) {
          break label628;
        }
        bool = true;
        ((Bundle)localObject1).putBoolean("key_block_bind_new_card", bool);
        if (!Util.isNullOrNil(paramq.HFJ)) {
          break label634;
        }
        paramString.putString("key_mobile", this.Hvb.field_mobile);
        paramString.putString("key_QADNA_URL", paramq.HFK);
        if (!paramq.isPaySuccess) {
          break label649;
        }
        if (this.CqM != null)
        {
          this.CqM.cG(10003, "");
          localObject1 = this.CqM;
          com.tencent.mm.plugin.report.service.h.CyF.a(13455, new Object[] { ((com.tencent.mm.plugin.wallet.a)localObject1).HsN, Long.valueOf(System.currentTimeMillis()), ((com.tencent.mm.plugin.wallet.a)localObject1).HsO });
        }
        paramString.putParcelable("key_orders", paramq.HFH);
        if (this.mPayInfo != null)
        {
          Log.i(this.TAG, "payscene %d", new Object[] { Integer.valueOf(this.mPayInfo.dVv) });
          if (8 == this.mPayInfo.dVv)
          {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYK, Boolean.TRUE);
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("pwd", this.krw);
        localObject2 = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class);
        paramInt1 = 0;
        if (!((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).dKn()) {
          break label663;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        ((Bundle)localObject1).putInt("key_open_biometric_type", paramInt1);
        ((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).a(paramq.fOm(), true, this.mPayInfo.HZb, (Bundle)localObject1);
        paramString.putInt("key_pay_flag", 3);
        paramq = paramq.AJr;
        if (paramq != null) {
          paramString.putParcelable("key_realname_guide_helper", paramq);
        }
        aI(paramString);
        AppMethodBeat.o(69458);
        return true;
        bool = false;
        break;
        label628:
        bool = false;
        break label308;
        label634:
        paramString.putString("key_mobile", paramq.HFJ);
        break label343;
        label649:
        paramString.putParcelable("key_orders", this.CwO);
        break label503;
        label663:
        if (((com.tencent.mm.plugin.fingerprint.b.a.i)localObject2).dKo()) {
          paramInt1 = 2;
        }
      }
    }
    if ((paramq instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("pwd", this.krw);
      localObject2 = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (this.mPayInfo.Ijy == 1)
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
      this.HGZ = getInput();
      this.HGZ.putParcelable("key_pay_info", this.mPayInfo);
      this.HGZ.putParcelable("key_bankcard", this.Hvb);
      if (!Util.isNullOrNil(this.krw)) {
        this.HGZ.putString("key_pwd1", this.krw);
      }
      this.HGZ.putString("kreq_token", paramq.getToken());
      this.HGZ.putParcelable("key_authen", paramq.HFI);
      localObject1 = this.HGZ;
      if (!paramq.HFG)
      {
        bool = true;
        label980:
        ((Bundle)localObject1).putBoolean("key_need_verify_sms", bool);
        this.HGZ.putString("key_mobile", this.Hvb.field_mobile);
        this.HGZ.putInt("key_err_code", paramInt2);
        this.HGZ.putParcelable("key_orders", this.CwO);
        if (!Util.isNullOrNil(paramString)) {
          break label1507;
        }
        paramString = getString(2131768158, new Object[] { this.Hvb.field_desc, this.Hvb.field_mobile });
      }
    }
    label1507:
    for (;;)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, "", getString(2131768157), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69406);
          WalletPayUI.this.HGZ.putInt("key_pay_flag", 3);
          WalletPayUI.this.aI(WalletPayUI.this.HGZ);
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
      this.mPayInfo.Kxu = paramInt2;
      fOs();
      AppMethodBeat.o(69458);
      return true;
      this.mPayInfo.Kxu = paramInt2;
      bool = false;
      if (paramInt2 == 100100) {
        bool = true;
      }
      if (this.HGg == null) {
        this.HGg = new a(this, this);
      }
      this.HGg.b(bool, this.mPayInfo.dNP, this.mPayInfo.dDL);
      Log.i(this.TAG, "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(bool)));
      AppMethodBeat.o(69458);
      return true;
      if ((this.Hvb == null) || (this.CwO == null)) {
        break;
      }
      this.Hvb.HVB = this.CwO.dDL;
      if ((this.mPayInfo != null) && ((this.mPayInfo.dVv == 45) || (this.mPayInfo.dVv == 52))) {
        com.tencent.mm.ui.base.h.a(getContext(), paramString, "", getString(2131755921), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(69408);
            if (WalletPayUI.this.getProcess() != null) {
              com.tencent.mm.wallet_core.a.c(WalletPayUI.this.getContext(), WalletPayUI.this.getInput(), paramInt2);
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
        if ((this.Hva != null) && (this.Hva.size() > 1)) {
          d(true, 4, paramString);
        } else {
          c(true, 4, paramString);
        }
      }
      if (!(paramq instanceof com.tencent.mm.plugin.wallet.pay.a.c.f)) {
        break;
      }
      this.HHw = true;
      fOJ();
      if (paramInt2 == 416)
      {
        Log.e(this.TAG, "errCode is 416 need real name verify!");
        this.mPayResultType = 2;
        this.HHt = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
        paramString.putString("realname_verify_process_jump_plugin", "wallet");
        if (this.mPayInfo != null) {}
        for (paramInt1 = this.mPayInfo.dVv;; paramInt1 = 0)
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
    if ((this.CwO != null) && (this.CwO.HZd != null) && (this.CwO.HZd.size() > 0))
    {
      this.HHb.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.CwO.dDO));
      this.HHe.setText(com.tencent.mm.wallet_core.ui.f.bpq(this.CwO.AOl));
      this.HHl.notifyDataSetChanged();
      if (this.CwO.HZd.size() > 1)
      {
        this.HHh.setVisibility(0);
        this.HHc.setText(getString(2131768161, new Object[] { ((Orders.Commodity)this.CwO.HZd.get(0)).desc, this.CwO.HZd.size() }));
        this.HGY = false;
      }
    }
    else
    {
      if ((this.mPayInfo != null) && (this.mPayInfo.dVv == 48)) {
        this.HHc.setText(2131764111);
      }
      this.HHf.setVisibility(8);
      this.HHg.setVisibility(8);
      this.HHo.setVisibility(8);
      this.HHp.setVisibility(8);
      this.Cwg.setText(2131768110);
      if ((this.Hvb == null) || (!this.Hvb.fQb())) {
        break label542;
      }
      if (Util.isNullOrNil(this.Hvb.field_forbidWord)) {
        break label522;
      }
      this.HHf.setText(this.Hvb.field_forbidWord);
      this.HHf.setVisibility(4);
      this.HHg.setVisibility(8);
      com.tencent.mm.plugin.wallet.a.s.fOg();
      if (com.tencent.mm.plugin.wallet.a.s.fOh().fRl()) {
        fOz();
      }
      label329:
      com.tencent.mm.plugin.wallet.a.s.fOg();
      if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRl())
      {
        com.tencent.mm.plugin.wallet.a.s.fOg();
        if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRm()) {
          break label590;
        }
      }
    }
    label424:
    label571:
    label590:
    for (int i = 1;; i = 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131310243);
      if ((i != 0) && (this.HGf != null) && (this.HGS != null) && (this.HGT) && (this.CwO != null))
      {
        fOB();
        this.HHj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69423);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            int i;
            if (WalletPayUI.this.mPayInfo == null)
            {
              i = 0;
              if (WalletPayUI.this.mPayInfo != null) {
                break label137;
              }
            }
            label137:
            for (paramAnonymousView = "";; paramAnonymousView = WalletPayUI.this.mPayInfo.dDL)
            {
              af.f(i, paramAnonymousView, 12, "");
              com.tencent.mm.plugin.wallet_core.ui.n.a(WalletPayUI.this.getContext(), WalletPayUI.this.CwO, WalletPayUI.this.HGf.HXI, new n.b()
              {
                public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
                {
                  int j = 1;
                  AppMethodBeat.i(69422);
                  WalletPayUI.this.HGf = paramAnonymous2FavorPayInfo;
                  Object localObject = WalletPayUI.this.TAG;
                  int i;
                  label82:
                  label98:
                  boolean bool;
                  if (paramAnonymous2FavorPayInfo == null)
                  {
                    paramAnonymous2FavorPayInfo = "";
                    Log.i((String)localObject, "WalletFavorDialog onSelectionDone %s", new Object[] { paramAnonymous2FavorPayInfo });
                    if (WalletPayUI.this.HGf != null)
                    {
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label467;
                      }
                      i = 0;
                      if (WalletPayUI.this.mPayInfo != null) {
                        break label485;
                      }
                      paramAnonymous2FavorPayInfo = "";
                      af.f(i, paramAnonymous2FavorPayInfo, 15, WalletPayUI.this.HGf.HXI);
                      if ((WalletPayUI.this.Hvb != null) && (!com.tencent.mm.plugin.wallet_core.ui.d.a(WalletPayUI.this.HGf, WalletPayUI.this.Hvb))) {
                        break label502;
                      }
                      WalletPayUI.this.HHg.setVisibility(8);
                      WalletPayUI.this.Cwg.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69419);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bm(paramAnonymous3View);
                          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                          Log.i(WalletPayUI.this.TAG, "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
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
                    Log.i(WalletPayUI.this.TAG, "needBindBankCard %s", new Object[] { Boolean.valueOf(bool) });
                    WalletPayUI.c(WalletPayUI.this).setVisibility(0);
                    WalletPayUI.d(WalletPayUI.this).setVisibility(0);
                    if (WalletPayUI.this.HGf != null)
                    {
                      WalletPayUI.this.HGS = com.tencent.mm.plugin.wallet_core.ui.e.IcT.a(WalletPayUI.this.CwO);
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.HGS.aVJ(WalletPayUI.this.HGf.HXI);
                      if ((paramAnonymous2FavorPayInfo != null) && (paramAnonymous2FavorPayInfo.HEs == 0.0D))
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
                        WalletPayUI.this.HHf.setVisibility(8);
                        WalletPayUI.this.HHg.setVisibility(0);
                        WalletPayUI.this.Cwg.setOnClickListener(new View.OnClickListener()
                        {
                          public final void onClick(View paramAnonymous3View)
                          {
                            AppMethodBeat.i(69421);
                            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                            localb.bm(paramAnonymous3View);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                            WalletPayUI.this.fOE();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(69421);
                          }
                        });
                      }
                      if (i != 0) {
                        WalletPayUI.this.HHg.setVisibility(8);
                      }
                      WalletPayUI.this.fOB();
                      AppMethodBeat.o(69422);
                      return;
                      paramAnonymous2FavorPayInfo = paramAnonymous2FavorPayInfo.toString();
                      break;
                      label467:
                      i = WalletPayUI.this.mPayInfo.dVv;
                      break label82;
                      label485:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.mPayInfo.dDL;
                      break label98;
                      label502:
                      paramAnonymous2FavorPayInfo = WalletPayUI.this.HGS.aVJ(WalletPayUI.this.HGf.HXI);
                      if ((paramAnonymous2FavorPayInfo == null) || (!WalletPayUI.this.Hvb.fQb())) {
                        break label644;
                      }
                      com.tencent.mm.plugin.wallet.a.s.fOg();
                      localObject = com.tencent.mm.plugin.wallet.a.s.fOh().Hwc;
                      double d = paramAnonymous2FavorPayInfo.HEs;
                      if ((localObject == null) || (((Bankcard)localObject).HVC >= d)) {
                        break label644;
                      }
                      Log.i(WalletPayUI.this.TAG, "balance not meet");
                      WalletPayUI.this.HHg.setVisibility(8);
                      WalletPayUI.this.Cwg.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous3View)
                        {
                          AppMethodBeat.i(69420);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bm(paramAnonymous3View);
                          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$7$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                          Log.i(WalletPayUI.this.TAG, "Balance amount not meet, after favor selection! payWithNewBankcard");
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
              i = WalletPayUI.this.mPayInfo.dVv;
              break;
            }
          }
        });
        localLinearLayout.setVisibility(0);
        if ((this.CwO == null) || (this.Hva == null) || (this.mPayInfo == null)) {
          break label571;
        }
        this.Cwg.setClickable(true);
        this.Cwg.setEnabled(true);
      }
      for (;;)
      {
        if (this.CwO == null) {
          this.HHg.setVisibility(8);
        }
        AppMethodBeat.o(69439);
        return;
        this.HHc.setText(((Orders.Commodity)this.CwO.HZd.get(0)).desc);
        this.HHh.setVisibility(8);
        break;
        com.tencent.mm.plugin.wallet.a.s.fOg();
        if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRl()) {
          break label329;
        }
        fOz();
        break label329;
        com.tencent.mm.plugin.wallet.a.s.fOg();
        if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRm()) {
          break label329;
        }
        fOz();
        break label329;
        localLinearLayout.setVisibility(8);
        break label424;
        this.Cwg.setClickable(false);
        this.Cwg.setEnabled(false);
      }
    }
  }
  
  protected final void xW(boolean paramBoolean)
  {
    AppMethodBeat.i(69446);
    if ((paramBoolean) && (!fOK()))
    {
      AppMethodBeat.o(69446);
      return;
    }
    if (this.HGf != null)
    {
      this.HGS = com.tencent.mm.plugin.wallet_core.ui.e.IcT.a(this.CwO);
      com.tencent.mm.plugin.wallet.a.j localj = this.HGS.aVJ(this.HGf.HXI);
      if ((localj == null) || (localj.HEs != 0.0D)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.HHy != null)
      {
        if (this.HHy.HFS == 0)
        {
          Log.i(this.TAG, "need real name,stop");
          b(this.HHy);
          AppMethodBeat.o(69446);
          return;
        }
        if ((this.HHy.HFS == 1) && (i != 0))
        {
          Log.i(this.TAG, "need real name, zero stop");
          b(this.HHy);
        }
      }
      if (this.HFT != null)
      {
        if ((this.HFT.HFB == 1) && (!Util.isNullOrNil(this.HFT.lHA)) && (!Util.isNullOrNil(this.HFT.lHB)) && (!Util.isNullOrNil(this.HFT.HFC)))
        {
          if ((this.mPayInfo != null) && (this.CwO != null) && (this.CwO.HZd != null) && (this.CwO.HZd.size() > 0))
          {
            if (this.mPayInfo.dVv != 8) {
              break label371;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.CwO.HZd.get(0)).dDM });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.HFT.HFC, "", this.HFT.lHB, this.HFT.lHA, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69389);
                Log.i(WalletPayUI.this.TAG, "click continue pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.CwO != null) && (WalletPayUI.this.CwO.HZd != null) && (WalletPayUI.this.CwO.HZd.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.dVv != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.h.CyF.a(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.CwO.HZd.get(0)).dDM });
                }
                for (;;)
                {
                  WalletPayUI.g(WalletPayUI.this);
                  AppMethodBeat.o(69389);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.h.CyF.a(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)WalletPayUI.this.CwO.HZd.get(0)).dDM });
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69390);
                Log.i(WalletPayUI.this.TAG, "click cancel pay");
                if ((WalletPayUI.this.mPayInfo != null) && (WalletPayUI.this.CwO != null) && (WalletPayUI.this.CwO.HZd != null) && (WalletPayUI.this.CwO.HZd.size() > 0))
                {
                  if (WalletPayUI.this.mPayInfo.dVv != 8) {
                    break label155;
                  }
                  com.tencent.mm.plugin.report.service.h.CyF.a(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.CwO.HZd.get(0)).dDM });
                }
                for (;;)
                {
                  WalletPayUI.this.finish();
                  AppMethodBeat.o(69390);
                  return;
                  label155:
                  com.tencent.mm.plugin.report.service.h.CyF.a(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2), ((Orders.Commodity)WalletPayUI.this.CwO.HZd.get(0)).dDM });
                }
              }
            });
            AppMethodBeat.o(69446);
            return;
            label371:
            com.tencent.mm.plugin.report.service.h.CyF.a(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Orders.Commodity)this.CwO.HZd.get(0)).dDM });
          }
        }
        if ((this.HFT.HFB == 2) && (!Util.isNullOrNil(this.HFT.HFC)) && (!Util.isNullOrNil(this.HFT.HFD)))
        {
          Log.i(this.TAG, "pay has been blocked");
          if ((this.mPayInfo != null) && (this.CwO != null) && (this.CwO.HZd != null) && (this.CwO.HZd.size() > 0))
          {
            if (this.mPayInfo.dVv != 8) {
              break label624;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.CwO.HZd.get(0)).dDM });
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.a(getContext(), this.HFT.HFC, "", this.HFT.HFD, false, new WalletPayUI.6(this));
            AppMethodBeat.o(69446);
            return;
            label624:
            com.tencent.mm.plugin.report.service.h.CyF.a(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Orders.Commodity)this.CwO.HZd.get(0)).dDM });
          }
        }
      }
      fOF();
      AppMethodBeat.o(69446);
      return;
    }
  }
  
  protected final void xX(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(69451);
    if (!bqg())
    {
      AppMethodBeat.o(69451);
      return;
    }
    this.HGi = false;
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
    for (Object localObject = "";; localObject = this.mPayInfo.dDL)
    {
      af.f(i, (String)localObject, 8, "");
      if (this.HHm != null)
      {
        Log.w(this.TAG, "close previous cashier dialog");
        this.HHm.dismiss();
      }
      this.HGi = false;
      if (!fOk()) {
        break label242;
      }
      this.HHm = new WcPayCashierDialog(getContext());
      localObject = (WcPayCashierDialog)this.HHm;
      PayInfo localPayInfo = this.mPayInfo;
      Orders localOrders = this.CwO;
      FavorPayInfo localFavorPayInfo = this.HGf;
      Bankcard localBankcard = this.Hvb;
      if (!this.HGW) {
        bool = true;
      }
      ((WcPayCashierDialog)localObject).a(localPayInfo, localOrders, localFavorPayInfo, localBankcard, bool, paramBoolean);
      ((WcPayCashierDialog)localObject).IlX = new WcPayCashierDialog.a()
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, Bankcard paramAnonymousBankcard)
        {
          AppMethodBeat.i(69392);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            Log.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.h.CyF.n(965L, 3L, 1L);
            AppMethodBeat.o(69392);
            return;
          }
          WalletPayUI.i(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.HGf = paramAnonymousFavorPayInfo;
          WalletPayUI.this.Hvb = paramAnonymousBankcard;
          paramAnonymousBankcard = WalletPayUI.this.TAG;
          int i;
          if (WalletPayUI.this.HGf == null)
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.dDL)
          {
            af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.krw = paramAnonymousString;
            WalletPayUI.this.xY(false);
            com.tencent.mm.plugin.wallet_core.utils.f.fUi();
            AppMethodBeat.o(69392);
            return;
            paramAnonymousFavorPayInfo = WalletPayUI.this.HGf.toString();
            break;
            i = WalletPayUI.this.mPayInfo.dVv;
            break label131;
          }
        }
        
        public final void fNc()
        {
          AppMethodBeat.i(69394);
          Log.i(WalletPayUI.this.TAG, "click add new bankcard");
          Object localObject = com.tencent.mm.plugin.wallet_core.model.g.fQl();
          if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bJw())
          {
            com.tencent.mm.ui.base.h.c(WalletPayUI.this.getContext(), ((com.tencent.mm.plugin.wallet_core.model.g)localObject).ANp, WalletPayUI.this.getString(2131755998), true);
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
          for (localObject = "";; localObject = WalletPayUI.this.mPayInfo.dDL)
          {
            af.f(i, (String)localObject, 14, "");
            WalletPayUI.this.HHm.dismiss();
            WalletPayUI.this.HHm = null;
            WalletPayUI.this.fOH();
            AppMethodBeat.o(69394);
            return;
            i = WalletPayUI.this.mPayInfo.dVv;
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
          for (String str = "";; str = WalletPayUI.this.mPayInfo.dDL)
          {
            af.f(i, str, 10, "");
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            AppMethodBeat.o(69393);
            return;
            i = WalletPayUI.this.mPayInfo.dVv;
            break;
          }
        }
      };
      ((WcPayCashierDialog)localObject).show();
      addDialog((Dialog)localObject);
      AppMethodBeat.o(69451);
      return;
      i = this.mPayInfo.dVv;
      break;
    }
    label242:
    if (!this.HGW) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.HHm = com.tencent.mm.plugin.wallet_core.ui.s.a(this, paramBoolean, this.CwO, this.HGf, this.Hvb, this.mPayInfo, this.Crn, new s.c()new View.OnClickListener
      {
        public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(69395);
          if (WalletPayUI.h(WalletPayUI.this))
          {
            Log.w(WalletPayUI.this.TAG, "has received canceled");
            com.tencent.mm.plugin.report.service.h.CyF.n(965L, 3L, 1L);
            AppMethodBeat.o(69395);
            return;
          }
          WalletPayUI.k(WalletPayUI.this);
          WalletPayUI.this.hideVKB();
          WalletPayUI.this.HGf = paramAnonymousFavorPayInfo;
          String str = WalletPayUI.this.TAG;
          if (WalletPayUI.this.HGf == null) {}
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.HGf.toString())
          {
            Log.i(str, "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s", new Object[] { paramAnonymousFavorPayInfo, Boolean.valueOf(paramAnonymousBoolean) });
            if ((WalletPayUI.this.HGf == null) || (!paramAnonymousBoolean)) {
              break;
            }
            WalletPayUI.this.bo(-100, true);
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
          for (paramAnonymousFavorPayInfo = "";; paramAnonymousFavorPayInfo = WalletPayUI.this.mPayInfo.dDL)
          {
            af.f(i, paramAnonymousFavorPayInfo, 9, "");
            WalletPayUI.this.krw = paramAnonymousString;
            WalletPayUI.this.xY(false);
            com.tencent.mm.plugin.wallet_core.utils.f.fUi();
            WalletPayUI.this.HGh = null;
            AppMethodBeat.o(69395);
            return;
            i = WalletPayUI.this.mPayInfo.dVv;
            break;
          }
        }
      }, new View.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69396);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i(WalletPayUI.this.TAG, "WalletPwdDialog event1 %s", new Object[] { Util.getStack().toString() });
          WalletPayUI.this.HGf = ((FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUI.this.HGf != null) {
            WalletPayUI.this.HGf.HXM = "";
          }
          WalletPayUI.this.d(false, 0, "");
          WalletPayUI.this.HHm.dismiss();
          WalletPayUI.this.krw = null;
          WalletPayUI.this.HHm = null;
          WalletPayUI.this.HGh = null;
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
          for (String str = "";; str = WalletPayUI.this.mPayInfo.dDL)
          {
            af.f(i, str, 10, "");
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            WalletPayUI.this.krw = null;
            WalletPayUI.this.HHm = null;
            if (WalletPayUI.this.isTransparent()) {
              WalletPayUI.this.finish();
            }
            WalletPayUI.this.HGh = null;
            AppMethodBeat.o(69397);
            return;
            i = WalletPayUI.this.mPayInfo.dVv;
            break;
          }
        }
      });
      this.HGh = ((com.tencent.mm.plugin.wallet_core.ui.f)this.HHm);
      AppMethodBeat.o(69451);
      return;
    }
  }
  
  protected void xY(boolean paramBoolean)
  {
    AppMethodBeat.i(69467);
    com.tencent.mm.plugin.wallet.pay.a.a.b localb = com.tencent.mm.plugin.wallet.pay.a.a.a(fOC(), this.CwO, paramBoolean);
    if (this.CwO != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_reqKey", this.CwO.dDL);
      if ((this.CwO.HZd != null) && (this.CwO.HZd.size() > 0)) {
        localBundle.putString("key_TransId", ((Orders.Commodity)this.CwO.HZd.get(0)).dDM);
      }
      localBundle.putLong("key_SessionId", this.HHn);
      localb.setProcessName("PayProcess");
      localb.setProcessBundle(localBundle);
    }
    if (this.mPayInfo != null)
    {
      if ((this.mPayInfo.dVv != 6) || (this.mPayInfo.Kxr != 100)) {
        break label255;
      }
      localb.setScene(100);
    }
    for (;;)
    {
      doSceneProgress(localb);
      if ((this.mPayInfo != null) && (8 == this.mPayInfo.dVv) && (this.mPayInfo.iqp != null))
      {
        long l = this.mPayInfo.iqp.getLong("extinfo_key_9");
        com.tencent.mm.plugin.report.service.h.CyF.a(13956, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - l) });
      }
      AppMethodBeat.o(69467);
      return;
      label255:
      localb.setScene(this.mPayInfo.dVv);
    }
  }
  
  protected final class a
  {
    protected a() {}
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(69426);
      WalletPayUI.this.HHk.removeAllViews();
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
        localView = ((LayoutInflater)WalletPayUI.this.getSystemService("layout_inflater")).inflate(2131496984, null);
        localTextView1 = (TextView)localView.findViewById(2131310238);
        localTextView2 = (TextView)localView.findViewById(2131310259);
        localCommodity = (Orders.Commodity)WalletPayUI.this.CwO.HZd.get(j);
        str2 = "";
        str1 = str2;
        if (WalletPayUI.this.mPayInfo != null) {
          if ((WalletPayUI.this.mPayInfo.dVv != 32) && (WalletPayUI.this.mPayInfo.dVv != 33) && (WalletPayUI.this.mPayInfo.dVv != 31))
          {
            str1 = str2;
            if (WalletPayUI.this.mPayInfo.dVv != 48) {}
          }
          else
          {
            str1 = WalletPayUI.this.mPayInfo.iqp.getString("extinfo_key_1", "");
            if (Util.isNullOrNil(str1)) {
              break label443;
            }
            com.tencent.mm.kernel.g.aAi();
            as localas = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjJ(str1);
            if (localas == null) {
              break label418;
            }
            str1 = localas.arJ();
          }
        }
        label252:
        if (localCommodity != null)
        {
          if (Util.isNullOrNil(str1)) {
            break label461;
          }
          localTextView2.setText(str1);
          localTextView2.setVisibility(0);
          ((TextView)localView.findViewById(2131310260)).setVisibility(0);
          if (Util.isNullOrNil(localCommodity.desc)) {
            break label530;
          }
          localTextView1.setText(localCommodity.desc);
          localTextView1.setVisibility(8);
          ((TextView)localView.findViewById(2131310240)).setVisibility(8);
          if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(localCommodity.AOa))) {
            break label555;
          }
          localView.setVisibility(0);
        }
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        localView.measure(-2, -2);
        WalletPayUI.this.HHk.addView(localView);
        j += 1;
        break label41;
        if (WalletPayUI.this.HGY)
        {
          i = WalletPayUI.this.mCount;
          break;
        }
        i = 1;
        break;
        label418:
        Log.e(WalletPayUI.this.TAG, "can not found contact for user::".concat(String.valueOf(str1)));
        str1 = str2;
        break label252;
        label443:
        Log.e(WalletPayUI.this.TAG, "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        str1 = str2;
        break label252;
        label461:
        if (!Util.isNullOrNil(localCommodity.AOa))
        {
          localTextView2.setText(localCommodity.AOa);
          localTextView2.setVisibility(0);
          ((TextView)localView.findViewById(2131310260)).setVisibility(0);
          break label290;
        }
        ((TextView)localView.findViewById(2131310260)).setVisibility(8);
        localTextView2.setVisibility(8);
        break label290;
        label530:
        ((TextView)localView.findViewById(2131310240)).setVisibility(8);
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
    int aHK;
    WeakReference<WalletPayUI> mZg;
    long timestamp;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI
 * JD-Core Version:    0.7.0.1
 */