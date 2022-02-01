package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.d;
import com.tencent.mm.plugin.wallet.balance.model.d.a;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.b.c;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public class WalletBalanceFetchUI
  extends WalletBaseUI
  implements WcPayKeyboard.a, WalletFormView.a
{
  private static final String Hvz;
  private IListener<lj> AJa;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  protected boolean HvA;
  private Runnable HvB;
  private boolean HvC;
  private boolean HvD;
  private boolean HvE;
  private boolean HvF;
  private ArrayList<Bankcard> Hva;
  private Bankcard Hvb;
  private String Hvc;
  private WalletFormView Hvd;
  private LinearLayout Hve;
  private View Hvf;
  private TextView Hvg;
  private TextView Hvh;
  private TextView Hvi;
  private TextView Hvj;
  private ViewGroup Hvk;
  private ViewGroup Hvl;
  private int Hvm;
  private int Hvn;
  private int Hvo;
  private double Hvp;
  private int Hvq;
  private DecimalFormat Hvr;
  private boolean Hvs;
  private int Hvt;
  private int Hvu;
  private com.tencent.mm.plugin.wallet.balance.model.b Hvv;
  private int Hvw;
  com.tencent.mm.plugin.wallet.ui.a Hvx;
  private Runnable Hvy;
  private String dDL;
  private View jBN;
  private double jVp;
  public Runnable jVx;
  private String lem;
  private int state;
  private int whv;
  HashMap<String, Integer> yNN;
  
  static
  {
    AppMethodBeat.i(213907);
    Hvz = "http://" + WeChatHosts.domainString(2131761715) + "/touch/product/wechatwallet_app.html?platform=15&scene_id=kf4";
    AppMethodBeat.o(213907);
  }
  
  public WalletBalanceFetchUI()
  {
    AppMethodBeat.i(68606);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    this.dDL = null;
    this.Hvm = 0;
    this.Hvn = 0;
    this.Hvo = 0;
    this.Hvp = 0.0D;
    this.whv = -1;
    this.Hvq = 0;
    this.Hvr = new DecimalFormat("0.00");
    this.Hvs = false;
    this.Hvt = 0;
    this.Hvu = 0;
    this.Hvw = MMApplicationContext.getContext().getResources().getColor(2131099748);
    this.Hvy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68576);
        WalletBalanceFetchUI.a(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68576);
      }
    };
    this.state = 0;
    this.HvA = false;
    this.jVx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68600);
        if ((WalletBalanceFetchUI.n(WalletBalanceFetchUI.this) == 2) && (WalletBalanceFetchUI.this.isHandleAutoShowNormalStWcKb())) {
          WalletBalanceFetchUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(68600);
      }
    };
    this.HvB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213895);
        WalletBalanceFetchUI.this.showNormalStWcKb();
        AppMethodBeat.o(213895);
      }
    };
    this.HvC = false;
    this.HvD = false;
    this.HvE = false;
    this.HvF = false;
    this.yNN = new HashMap();
    this.AJa = new IListener() {};
    AppMethodBeat.o(68606);
  }
  
  private void a(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(174434);
    Bundle localBundle = new Bundle();
    localBundle.putInt("payScene", 21);
    localBundle.putString("totalFee", com.tencent.mm.wallet_core.ui.f.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localBundle.putString("feeType", paramString1);
    localBundle.putString("bankType", paramString2);
    localBundle.putString("bindSerial", paramString3);
    localBundle.putString("operation", String.valueOf(paramInt));
    localBundle.putString("reportSessionId", this.lem);
    Log.i("MicroMsg.WalletBalanceFetchUI", "startWalletBalanceFetchUseCase totalFee：%s reportSessionId %s", new Object[] { com.tencent.mm.wallet_core.ui.f.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString(), this.lem });
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startWalletBalanceFetchUseCase(this, localBundle);
    AppMethodBeat.o(174434);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(68618);
    if (!Util.isNullOrNil(this.dDL))
    {
      Object localObject = new PayInfo();
      ((PayInfo)localObject).dDL = this.dDL;
      ((PayInfo)localObject).dVv = 21;
      getInput().putParcelable("key_pay_info", (Parcelable)localObject);
      localObject = new Orders();
      ((Orders)localObject).dDO = (paramd.Cpj - paramd.CoZ);
      ((Orders)localObject).HYM = (paramd.Cpj - paramd.CoZ);
      ((Orders)localObject).HZd.add(new Orders.Commodity());
      ((Orders)localObject).CoZ = paramd.CoZ;
      getInput().putString("key_fetch_cashier_encode_str", paramd.Htb);
      getInput().putParcelable("key_orders", (Parcelable)localObject);
      getInput().putParcelable("key_bankcard", this.Hvb);
      getInput().putString("key_fetch_cashier_desc", paramd.HsY);
      getInput().putString("key_report_session_id", this.lem);
      if (getProcess() == null)
      {
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, getInput(), null);
        AppMethodBeat.o(68618);
        return;
      }
      getNetController().r(new Object[] { getInput() });
      AppMethodBeat.o(68618);
      return;
    }
    Log.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
    AppMethodBeat.o(68618);
  }
  
  private boolean b(d paramd)
  {
    boolean bool3 = false;
    AppMethodBeat.i(68623);
    if (!this.HvC) {}
    for (boolean bool1 = c(paramd);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = false;
      }
      if ((!bool2) && (!this.HvD)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!this.HvE) {
            bool2 = d(paramd);
          }
        }
        AppMethodBeat.o(68623);
        return bool2;
      }
    }
  }
  
  private void bf(Intent paramIntent)
  {
    AppMethodBeat.i(68627);
    this.Hvs = bg(paramIntent);
    if (this.Hvs)
    {
      Log.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
      PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
      paramIntent = localPayInfo;
      if (localPayInfo == null)
      {
        paramIntent = new PayInfo();
        paramIntent.dDL = this.dDL;
        paramIntent.dVv = 21;
      }
      doSceneForceProgress(new aa(paramIntent.dDL));
    }
    AppMethodBeat.o(68627);
  }
  
  private static boolean bg(Intent paramIntent)
  {
    AppMethodBeat.i(68629);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false)))
    {
      AppMethodBeat.o(68629);
      return true;
    }
    AppMethodBeat.o(68629);
    return false;
  }
  
  private boolean c(final d paramd)
  {
    AppMethodBeat.i(68624);
    if (paramd.HsT)
    {
      this.HvC = true;
      com.tencent.mm.ui.base.h.a(this, false, paramd.HsU, "", getString(2131755921), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68583);
          paramAnonymousDialogInterface.dismiss();
          if (!WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd))
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd.dNQ);
            WalletBalanceFetchUI.b(WalletBalanceFetchUI.this, paramd);
          }
          AppMethodBeat.o(68583);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68584);
          paramAnonymousDialogInterface.dismiss();
          WalletBalanceFetchUI.p(WalletBalanceFetchUI.this);
          AppMethodBeat.o(68584);
        }
      });
      AppMethodBeat.o(68624);
      return true;
    }
    AppMethodBeat.o(68624);
    return false;
  }
  
  private boolean d(d paramd)
  {
    AppMethodBeat.i(68625);
    paramd = paramd.HsW;
    if ((paramd != null) && ((!TextUtils.isEmpty(paramd.HVg)) || ((paramd.HVh != null) && (paramd.HVh.size() > 0))))
    {
      this.HvE = true;
      com.tencent.mm.plugin.wallet_core.ui.m.a(this, paramd, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(213877);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = "";
          String str = "";
          if (WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) != null)
          {
            paramAnonymousDialogInterface = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bankcardType;
            str = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bindSerial;
          }
          WalletBalanceFetchUI.q(WalletBalanceFetchUI.this);
          WalletBalanceFetchUI.r(WalletBalanceFetchUI.this);
          if (WalletBalanceFetchUI.fNm())
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, WalletBalanceFetchUI.s(WalletBalanceFetchUI.this), "1", paramAnonymousDialogInterface, str, WalletBalanceFetchUI.t(WalletBalanceFetchUI.this));
            AppMethodBeat.o(213877);
            return;
          }
          WalletBalanceFetchUI.this.doSceneProgress(new d(WalletBalanceFetchUI.s(WalletBalanceFetchUI.this), "CNY", paramAnonymousDialogInterface, WalletBalanceFetchUI.t(WalletBalanceFetchUI.this)));
          AppMethodBeat.o(213877);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68586);
          paramAnonymousDialogInterface.dismiss();
          WalletBalanceFetchUI.p(WalletBalanceFetchUI.this);
          AppMethodBeat.o(68586);
        }
      });
      AppMethodBeat.o(68625);
      return true;
    }
    AppMethodBeat.o(68625);
    return false;
  }
  
  private void dzO()
  {
    AppMethodBeat.i(68614);
    s.fOg();
    final com.tencent.mm.plugin.wallet_core.model.b localb = s.fOh().IbO;
    removeAllOptionMenu();
    if ((localb != null) && (localb.HVk != null) && (localb.HVk.HVm != null) && (localb.HVk.HVm.length > 0)) {
      addIconOptionMenu(0, 2131689495, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(213871);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletBalanceFetchUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.HLX = new o.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
            {
              AppMethodBeat.i(213869);
              b.c[] arrayOfc = WalletBalanceFetchUI.2.this.HvH.HVk.HVm;
              int k = arrayOfc.length;
              int i = 0;
              int j = 0;
              if (i < k)
              {
                b.c localc = arrayOfc[i];
                if (!Util.isNullOrNil(localc.title))
                {
                  if (Util.isNullOrNil(localc.desc)) {
                    break label91;
                  }
                  paramAnonymous2m.a(j, localc.title, localc.desc, 0);
                }
                for (;;)
                {
                  j += 1;
                  i += 1;
                  break;
                  label91:
                  paramAnonymous2m.d(j, localc.title);
                }
              }
              AppMethodBeat.o(213869);
            }
          };
          paramAnonymousMenuItem.HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(213870);
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
              if ((WalletBalanceFetchUI.2.this.HvH.HVk.HVm != null) && (paramAnonymous2Int < WalletBalanceFetchUI.2.this.HvH.HVk.HVm.length))
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.2.this.HvH.HVk.HVm[paramAnonymous2Int];
                Log.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.uSc), paramAnonymous2MenuItem.pTL });
                switch (paramAnonymous2MenuItem.uSc)
                {
                }
              }
              for (;;)
              {
                AppMethodBeat.o(213870);
                return;
                com.tencent.mm.wallet_core.ui.f.p(WalletBalanceFetchUI.this.getContext(), paramAnonymous2MenuItem.pTL, true);
                AppMethodBeat.o(213870);
                return;
                com.tencent.mm.wallet_core.ui.f.u(paramAnonymous2MenuItem.username, paramAnonymous2MenuItem.path, 0, 1000);
              }
            }
          };
          paramAnonymousMenuItem.dGm();
          AppMethodBeat.o(213871);
          return true;
        }
      });
    }
    AppMethodBeat.o(68614);
  }
  
  private static boolean eNx()
  {
    AppMethodBeat.i(174433);
    com.tencent.mm.wallet_core.b.hgC();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.rWd, true);
    com.tencent.mm.wallet_core.b.hgC();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.rZW, false);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(174433);
      return true;
    }
    AppMethodBeat.o(174433);
    return false;
  }
  
  private void fNd()
  {
    AppMethodBeat.i(213898);
    if ((Util.getDouble(this.Hvd.getText(), 0.0D) <= 0.0D) || (!this.Hvd.bql()))
    {
      this.mWcKeyboard.DH(false);
      AppMethodBeat.o(213898);
      return;
    }
    this.mWcKeyboard.DH(true);
    AppMethodBeat.o(213898);
  }
  
  private void fNe()
  {
    AppMethodBeat.i(68612);
    if (this.Hvb != null)
    {
      this.Hvp = com.tencent.mm.wallet_core.ui.f.a(this.Hvb.HVX, "100", 2, RoundingMode.HALF_UP);
      Log.i("MicroMsg.WalletBalanceFetchUI", "min charge fee: %s", new Object[] { Double.valueOf(this.Hvp) });
    }
    AppMethodBeat.o(68612);
  }
  
  private void fNf()
  {
    AppMethodBeat.i(68616);
    if (this.Hvt == 0)
    {
      this.jVp = Util.getDouble(this.Hvd.getText(), 0.0D);
      double d = this.jVp;
      s.fOg();
      if ((d != s.fOh().Hwc.HVE) && (this.Hvb != null))
      {
        d = this.jVp;
        s.fOg();
        if (d != s.fOh().Hwc.HVE - this.Hvb.field_full_fetch_charge_fee) {
          this.Hvq = 0;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int j = -1;
      d = this.jVp;
      s.fOg();
      int i;
      if (d > s.fOh().Hwc.HVC)
      {
        this.Hvi.setVisibility(8);
        this.Hvh.setTextColor(getResources().getColor(2131099818));
        localStringBuilder.append(getString(2131767440));
        i = j;
      }
      while (i == -1)
      {
        this.Hvh.setClickable(false);
        this.Hvh.setOnTouchListener(null);
        this.Hvh.setText(localStringBuilder.toString());
        AppMethodBeat.o(68616);
        return;
        String str;
        if ((this.Hvb != null) && (this.Hvm != 0) && ((this.Hvm != 1) || (this.Hvb.field_fetch_charge_rate > 0.0D)) && ((this.Hvm != 1) || (this.Hvb.field_fetch_charge_rate <= 0.0D) || (this.Hvn != 0)))
        {
          d = this.Hvp;
          s.fOg();
          if (d < s.fOh().Hwc.HVE) {}
        }
        else
        {
          this.Hvh.setTextColor(this.Hvw);
          s.fOg();
          str = s.fOh().Hwc.HVJ;
          if (!Util.isNullOrNil(str)) {
            localStringBuilder.append(str);
          }
          for (;;)
          {
            localStringBuilder.append("，");
            i = localStringBuilder.length();
            localStringBuilder.append(getString(2131767419));
            break;
            Log.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
            s.fOg();
            localStringBuilder.append(getString(2131767431, new Object[] { com.tencent.mm.wallet_core.ui.f.d(s.fOh().Hwc.HVE, "CNY") }));
          }
        }
        if ((this.Hvm == 1) && (this.Hvb.field_fetch_charge_rate > 0.0D) && (this.Hvn == 1) && ((this.jVp <= 0.0D) || (!this.Hvd.bql())))
        {
          this.Hvh.setTextColor(this.Hvw);
          s.fOg();
          str = s.fOh().Hwc.HVJ;
          if (!Util.isNullOrNil(str)) {
            localStringBuilder.append(str);
          }
          for (;;)
          {
            localStringBuilder.append("，");
            i = localStringBuilder.length();
            localStringBuilder.append(getString(2131767419));
            break;
            Log.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
            s.fOg();
            localStringBuilder.append(getString(2131767431, new Object[] { com.tencent.mm.wallet_core.ui.f.d(s.fOh().Hwc.HVE, "CNY") }));
          }
        }
        i = j;
        if (this.Hvm == 1)
        {
          i = j;
          if (this.Hvb.field_fetch_charge_rate > 0.0D)
          {
            i = j;
            if (this.Hvn == 1)
            {
              this.Hvi.setVisibility(8);
              this.Hvh.setTextColor(this.Hvw);
              d = this.jVp;
              s.fOg();
              if ((d == s.fOh().Hwc.HVE - this.Hvb.field_full_fetch_charge_fee) && (this.Hvb.field_full_fetch_charge_fee > 0.0D))
              {
                if (!Util.isNullOrNil(this.Hvb.HVW))
                {
                  localStringBuilder.append(String.format(this.Hvb.HVW, new Object[] { com.tencent.mm.wallet_core.ui.f.d(this.Hvb.field_full_fetch_charge_fee, "CNY") }));
                  i = j;
                }
                else
                {
                  localStringBuilder.append(getString(2131767413, new Object[] { com.tencent.mm.wallet_core.ui.f.d(this.Hvb.field_full_fetch_charge_fee, "CNY"), this.Hvb.field_fetch_charge_rate * 100.0D + "%" }));
                  i = j;
                }
              }
              else if (!Util.isNullOrNil(this.Hvb.HVW))
              {
                localStringBuilder.append(String.format(this.Hvb.HVW, new Object[] { com.tencent.mm.wallet_core.ui.f.d(z(this.jVp), "CNY") }));
                i = j;
              }
              else
              {
                localStringBuilder.append(getString(2131767413, new Object[] { com.tencent.mm.wallet_core.ui.f.d(z(this.jVp), "CNY"), this.Hvb.field_fetch_charge_rate * 100.0D + "%" }));
                i = j;
              }
            }
          }
        }
      }
      com.tencent.mm.wallet_core.ui.f.a(this.Hvh, localStringBuilder.toString(), i, localStringBuilder.length(), new com.tencent.mm.wallet_core.ui.e(new e.a()
      {
        public final void bmr()
        {
          AppMethodBeat.i(213872);
          WalletBalanceFetchUI.i(WalletBalanceFetchUI.this);
          AppMethodBeat.o(213872);
        }
      }), getContext());
    }
    AppMethodBeat.o(68616);
  }
  
  private void fNg()
  {
    AppMethodBeat.i(213902);
    s.fOg();
    final Bankcard localBankcard = s.fOh().Hwc;
    if ((this.Hvb != null) && (!Util.isNullOrNil(localBankcard.field_prompt_info_prompt_text)))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
      if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_text)) {
        localSpannableStringBuilder.append(localBankcard.field_prompt_info_jump_text);
      }
      localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dF(View paramAnonymousView)
        {
          AppMethodBeat.i(213873);
          if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_url))
          {
            com.tencent.mm.wallet_core.ui.f.bn(WalletBalanceFetchUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
            com.tencent.mm.plugin.report.service.h.CyF.a(20216, new Object[] { Integer.valueOf(4), localBankcard.field_prompt_info_jump_url });
          }
          AppMethodBeat.o(213873);
        }
      }), localBankcard.field_prompt_info_prompt_text.length(), localSpannableStringBuilder.length(), 18);
      this.Hvj.setText(localSpannableStringBuilder);
      this.Hvj.setOnTouchListener(new o(getContext()));
      this.Hvj.setVisibility(0);
      this.Hvw = getContext().getResources().getColor(2131099746);
      this.Hvh.setTextColor(this.Hvw);
      AppMethodBeat.o(213902);
      return;
    }
    this.Hvj.setText("");
    this.Hvj.setVisibility(8);
    this.Hvw = getContext().getResources().getColor(2131099748);
    this.Hvh.setTextColor(this.Hvw);
    AppMethodBeat.o(213902);
  }
  
  private void fNh()
  {
    AppMethodBeat.i(68620);
    fetchData();
    updateView();
    fNk();
    AppMethodBeat.o(68620);
  }
  
  private void fNi()
  {
    this.HvC = false;
    this.HvD = false;
    this.HvE = false;
    this.HvF = false;
  }
  
  private void fNj()
  {
    AppMethodBeat.i(68628);
    Object localObject = com.tencent.mm.plugin.wallet_core.model.g.fQl();
    if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bJw())
    {
      com.tencent.mm.ui.base.h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).ANp, getString(2131755998), true);
      AppMethodBeat.o(68628);
      return;
    }
    Bundle localBundle = new Bundle();
    PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
    localObject = localPayInfo;
    if (localPayInfo == null)
    {
      localObject = new PayInfo();
      ((PayInfo)localObject).dDL = this.dDL;
      ((PayInfo)localObject).dVv = 21;
    }
    if (localObject != null) {
      localBundle.putParcelable("key_pay_info", (Parcelable)localObject);
    }
    localBundle.putInt("key_scene", 21);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_is_bind_bankcard", true);
    localBundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.HsQ);
    localBundle.putBoolean("key_bind_show_change_card", true);
    if (h(this, localBundle))
    {
      AppMethodBeat.o(68628);
      return;
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, localBundle, null);
    AppMethodBeat.o(68628);
  }
  
  private void fNk()
  {
    AppMethodBeat.i(68630);
    if (this.Hvm != 0)
    {
      Log.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.Hvm);
      AppMethodBeat.o(68630);
      return;
    }
    com.tencent.mm.kernel.g.aAi();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXl, Boolean.FALSE)).booleanValue();
    s.fOg();
    com.tencent.mm.plugin.wallet_core.model.b localb = s.fOh().IbO;
    if ((localb != null) && (!bool))
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131768140, new Object[] { com.tencent.mm.wallet_core.ui.f.D(localb.Cpd) }), getString(2131768141), getString(2131767734), getString(2131768142), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(213879);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.h.CyF.a(16398, new Object[] { WalletBalanceFetchUI.e(WalletBalanceFetchUI.this), Integer.valueOf(4), "", "" });
          AppMethodBeat.o(213879);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(213880);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", WalletBalanceFetchUI.this.getString(2131767703));
          localIntent.putExtra("showShare", false);
          com.tencent.mm.wallet_core.ui.f.aA(WalletBalanceFetchUI.this.getContext(), localIntent);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.h.CyF.a(16398, new Object[] { WalletBalanceFetchUI.e(WalletBalanceFetchUI.this), Integer.valueOf(3), "", "" });
          AppMethodBeat.o(213880);
        }
      }, 2131101414);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXl, Boolean.TRUE);
    }
    AppMethodBeat.o(68630);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(68609);
    s.fOg();
    an localan = s.fOh();
    Object localObject2;
    Object localObject3;
    int i;
    Object localObject4;
    if (this.Hvs)
    {
      Log.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      if ((this.Hva != null) && (this.Hva.size() > 0)) {
        ((ArrayList)localObject1).addAll(this.Hva);
      }
      this.Hva = localan.fRG();
      if ((this.Hva != null) && (this.Hva.size() > 0)) {
        ((ArrayList)localObject2).addAll(this.Hva);
      }
      if ((((ArrayList)localObject1).size() <= 0) || (((ArrayList)localObject2).size() <= 0)) {
        break label617;
      }
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        localObject4 = (Bankcard)((ArrayList)localObject1).get(i);
        int j = 0;
        while (j < ((ArrayList)localObject2).size())
        {
          Bankcard localBankcard = (Bankcard)((ArrayList)localObject2).get(j);
          if ((localObject4 != null) && (localBankcard != null) && (((Bankcard)localObject4).field_bindSerial.equals(localBankcard.field_bindSerial))) {
            ((ArrayList)localObject3).add(localBankcard);
          }
          j += 1;
        }
        i += 1;
      }
      if (((ArrayList)localObject3).size() > 0) {
        ((ArrayList)localObject2).removeAll((Collection)localObject3);
      }
      if (((ArrayList)localObject2).size() <= 0) {
        break label617;
      }
    }
    label347:
    label617:
    for (Object localObject1 = (Bankcard)((ArrayList)localObject2).get(0);; localObject1 = null)
    {
      if (localObject1 == null) {
        localObject1 = localan.a(this.Hva, null, false, true);
      }
      for (;;)
      {
        i = 0;
        if ((this.Hva != null) && (i < this.Hva.size()))
        {
          localObject2 = (Bankcard)this.Hva.get(i);
          if ((localObject1 != null) && (localObject2 != null) && (((Bankcard)localObject1).field_bindSerial.equals(((Bankcard)localObject2).field_bindSerial))) {
            this.whv = i;
          }
        }
        else
        {
          this.Hvb = ((Bankcard)localObject1);
          this.Hvs = false;
          localObject3 = com.tencent.mm.plugin.report.service.h.CyF;
          localObject4 = this.lem;
          if (this.Hvb == null) {
            break label587;
          }
          localObject1 = this.Hvb.field_bankcardType;
          label373:
          if (this.Hvb == null) {
            break label594;
          }
          localObject2 = this.Hvb.field_bindSerial;
          ((com.tencent.mm.plugin.report.service.h)localObject3).a(16398, new Object[] { localObject4, Integer.valueOf(1), localObject1, localObject2 });
          if (localan.IbO == null) {
            break label602;
          }
          this.Hvm = localan.IbO.Hvm;
          this.Hvn = localan.IbO.Hvn;
          fNe();
          this.Hvo = localan.IbO.Hvo;
        }
        for (;;)
        {
          this.Hvt = 0;
          this.Hvu = 0;
          Log.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.Hvm + " is_cal_charge:" + this.Hvn + " min_charge_fee:" + this.Hvp + " is_full_fetch_direct:" + this.Hvo);
          AppMethodBeat.o(68609);
          return;
          i += 1;
          break;
          this.Hva = localan.fRG();
          this.Hvb = localan.a(this.Hva, null, false, true);
          break label347;
          localObject1 = "";
          break label373;
          localObject2 = "";
          break label389;
          Log.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
      }
    }
  }
  
  private boolean h(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(68631);
    com.tencent.mm.wallet_core.b.hgC();
    if (com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.rZU, true))
    {
      EventCenter.instance.add(this.AJa);
      Log.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:true");
      ab.mg(6, paramBundle.getInt("key_bind_scene"));
      com.tencent.mm.wallet_core.c.z.aqh(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(68631);
      return true;
    }
    Log.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:false");
    AppMethodBeat.o(68631);
    return false;
  }
  
  private void updateView()
  {
    AppMethodBeat.i(68613);
    final ImageView localImageView;
    Object localObject;
    if (this.Hvd.getTitleTv() != null)
    {
      this.Hvd.getTitleTv().setText(String.format(getString(2131764553), new Object[] { ah.hhz() }));
      localImageView = (ImageView)this.Hve.findViewById(2131297310);
      if (this.Hvb == null) {
        break label443;
      }
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.Hvb.field_bankcardType, this.Hvb.fQa());
      if (locale != null) {
        localObject = locale.AAU;
      }
      localImageView.setImageBitmap(null);
      if (!this.Hvb.fQb()) {
        break label348;
      }
      localImageView.setBackgroundResource(2131235574);
      label121:
      ((TextView)this.Hve.findViewById(2131297236)).setText(getString(2131767467, new Object[] { this.Hvb.field_bankName, this.Hvb.field_bankcardTail }));
      ((TextView)this.Hve.findViewById(2131297236)).setVisibility(0);
      if (!Util.isNullOrNil(this.Hvb.field_fetchArriveTimeWording))
      {
        ((TextView)this.Hve.findViewById(2131302329)).setText(this.Hvb.field_fetchArriveTimeWording);
        ((TextView)this.Hve.findViewById(2131302329)).setVisibility(0);
        if (this.Hvb.field_is_hightlight_pre_arrive_time_wording != 1) {
          break label414;
        }
        ((TextView)this.Hve.findViewById(2131302329)).setTextColor(getResources().getColor(2131099792));
      }
      label275:
      s.fOg();
      Util.isNullOrNil(s.fOh().Hwc.HVI);
      if (this.Hvt != 1) {
        break label525;
      }
      this.Hvk.setVisibility(8);
      this.Hvl.setVisibility(0);
    }
    for (;;)
    {
      fNf();
      fNg();
      dzO();
      AppMethodBeat.o(68613);
      return;
      Log.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
      break;
      label348:
      localObject = u.a(new c((String)localObject));
      u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(213897);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(213896);
              if ((WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) != null) && (WalletBalanceFetchUI.28.this.HvT != null) && (WalletBalanceFetchUI.28.this.HvT.getTag() != null) && (WalletBalanceFetchUI.28.this.HvT.getTag().equals(WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bindSerial))) {
                WalletBalanceFetchUI.28.this.HvT.setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(213896);
            }
          });
          AppMethodBeat.o(213897);
        }
      });
      if ((localObject == null) || (localObject == null)) {
        break label121;
      }
      localImageView.setImageBitmap(BitmapUtil.extractThumbNail((Bitmap)localObject, getResources().getDimensionPixelOffset(2131167138), getResources().getDimensionPixelOffset(2131167138), true, false));
      break label121;
      label414:
      ((TextView)this.Hve.findViewById(2131302329)).setTextColor(getResources().getColor(2131100594));
      break label275;
      label443:
      localImageView.setImageBitmap(null);
      ((TextView)this.Hve.findViewById(2131297236)).setText(this.Hvc);
      ((TextView)this.Hve.findViewById(2131302329)).setText("");
      ((TextView)this.Hve.findViewById(2131302329)).setVisibility(8);
      ((ImageView)this.Hve.findViewById(2131297310)).setImageBitmap(null);
      break label275;
      label525:
      this.Hvk.setVisibility(0);
      this.Hvl.setVisibility(8);
    }
  }
  
  private double z(double paramDouble)
  {
    AppMethodBeat.i(68617);
    s.fOg();
    an localan = s.fOh();
    paramDouble = Math.max(com.tencent.mm.wallet_core.ui.f.b(paramDouble - localan.IbO.Cpd, this.Hvb.field_fetch_charge_rate, RoundingMode.HALF_UP), this.Hvp);
    AppMethodBeat.o(68617);
    return paramDouble;
  }
  
  public final void bO(float paramFloat)
  {
    AppMethodBeat.i(213903);
    if (this.jBN != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jBN.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      Log.d("MicroMsg.WalletBalanceFetchUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.jBN.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(213903);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496880;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68610);
    setMMTitle(2131767437);
    this.jBN = findViewById(2131300604);
    this.Hve = ((LinearLayout)findViewById(2131297235));
    com.tencent.mm.ui.ao.a(((TextView)this.Hve.findViewById(2131297236)).getPaint(), 0.8F);
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68591);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).hgN();
        s.fOg();
        final ArrayList localArrayList = s.fOh().fRG();
        s.fOg();
        localObject1 = s.fOh().IbO;
        if (localObject1 != null) {
          paramAnonymousView = ((com.tencent.mm.plugin.wallet_core.model.b)localObject1).HVj;
        }
        for (localObject1 = ((com.tencent.mm.plugin.wallet_core.model.b)localObject1).HVi;; localObject1 = "")
        {
          if (localArrayList == null) {
            Log.i("MicroMsg.WalletBalanceFetchUI", "debit is null");
          }
          WalletBalanceFetchUI localWalletBalanceFetchUI = WalletBalanceFetchUI.this;
          Object localObject2 = WalletBalanceFetchUI.this.getContext();
          Bankcard localBankcard = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this);
          new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68590);
              if ((localArrayList != null) && (paramAnonymous2Int < localArrayList.size()))
              {
                WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, (Bankcard)localArrayList.get(paramAnonymous2Int));
                WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
                Log.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[] { WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_desc });
                localh = com.tencent.mm.plugin.report.service.h.CyF;
                str2 = WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
                if (WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) != null)
                {
                  paramAnonymous2MenuItem = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bankcardType;
                  if (WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) == null) {
                    break label214;
                  }
                }
                label214:
                for (str1 = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bindSerial;; str1 = "")
                {
                  localh.a(16398, new Object[] { str2, Integer.valueOf(2), paramAnonymous2MenuItem, str1 });
                  WalletBalanceFetchUI.g(WalletBalanceFetchUI.this);
                  WalletBalanceFetchUI.fNl();
                  AppMethodBeat.o(68590);
                  return;
                  paramAnonymous2MenuItem = "";
                  break;
                }
              }
              Log.i("MicroMsg.WalletBalanceFetchUI", "add new card");
              WalletBalanceFetchUI.f(WalletBalanceFetchUI.this);
              com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
              String str2 = WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
              if (WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) != null)
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bankcardType;
                label281:
                if (WalletBalanceFetchUI.c(WalletBalanceFetchUI.this) == null) {
                  break label350;
                }
              }
              label350:
              for (String str1 = WalletBalanceFetchUI.c(WalletBalanceFetchUI.this).field_bindSerial;; str1 = "")
              {
                localh.a(16398, new Object[] { str2, Integer.valueOf(9), paramAnonymous2MenuItem, str1 });
                break;
                paramAnonymous2MenuItem = "";
                break label281;
              }
            }
          };
          if ((localWalletBalanceFetchUI.Hvx != null) && (localWalletBalanceFetchUI.Hvx.qAx.isShowing())) {
            Log.i("MicroMsg.WalletBalanceFetchUI", "mmBottomSheet != null && mmBottomSheet.isShowing(),dont show bottomSheet");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68591);
            return;
            localWalletBalanceFetchUI.yNN.clear();
            localWalletBalanceFetchUI.Hvx = new com.tencent.mm.plugin.wallet.ui.a((Context)localObject2);
            localWalletBalanceFetchUI.Hvx.HLX = new WalletBalanceFetchUI.14(localWalletBalanceFetchUI, localArrayList, (Context)localObject2);
            localObject2 = new com.tencent.mm.ui.base.m(localWalletBalanceFetchUI);
            ((com.tencent.mm.ui.base.m)localObject2).a(0, localWalletBalanceFetchUI.getString(2131767438), null, localWalletBalanceFetchUI.getResources().getDrawable(2131690865), localWalletBalanceFetchUI.getResources().getColor(2131099749), false);
            localWalletBalanceFetchUI.Hvx.a((com.tencent.mm.ui.base.m)localObject2, new WalletBalanceFetchUI.15(localWalletBalanceFetchUI));
            localWalletBalanceFetchUI.Hvx.a(new WalletBalanceFetchUI.16(localWalletBalanceFetchUI, localArrayList));
            localObject2 = View.inflate(localWalletBalanceFetchUI, 2131495345, null);
            TextView localTextView = (TextView)((View)localObject2).findViewById(2131304007);
            if (!Util.isNullOrNil((String)localObject1)) {
              localTextView.setText((CharSequence)localObject1);
            }
            if (!Util.isNullOrNil(paramAnonymousView)) {
              ((TextView)((View)localObject2).findViewById(2131304006)).setText(paramAnonymousView);
            }
            com.tencent.mm.ui.ao.a(localTextView.getPaint(), 0.8F);
            ((View)localObject2).findViewById(2131299577).setVisibility(0);
            ((View)localObject2).findViewById(2131303975).setOnClickListener(new WalletBalanceFetchUI.17(localWalletBalanceFetchUI));
            localWalletBalanceFetchUI.Hvx.setTitleView((View)localObject2);
            int k = 0;
            if (localArrayList != null)
            {
              int j = localArrayList.size();
              k = j;
              if (localBankcard != null)
              {
                int i = 0;
                for (;;)
                {
                  k = j;
                  if (i >= localArrayList.size()) {
                    break;
                  }
                  if (((Bankcard)localArrayList.get(i)).field_bindSerial.equals(localBankcard.field_bindSerial)) {
                    j = i;
                  }
                  i += 1;
                }
              }
            }
            localWalletBalanceFetchUI.Hvx.HMg = true;
            localWalletBalanceFetchUI.Hvx.jKz = k;
            localWalletBalanceFetchUI.Hvx.HMf = true;
            localWalletBalanceFetchUI.Hvx.T(localWalletBalanceFetchUI.getResources().getString(2131767686));
            localWalletBalanceFetchUI.Hvx.dGm();
          }
          paramAnonymousView = "";
        }
      }
    };
    this.Hvf = findViewById(2131297235);
    this.Hvf.setOnClickListener((View.OnClickListener)localObject);
    this.Hve.setOnClickListener((View.OnClickListener)localObject);
    this.Hvd = ((WalletFormView)findViewById(2131297238));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.Hvd);
    this.Hvd.setOnInputValidChangeListener(this);
    this.mWcKeyboard = new WcPayKeyboard(this);
    this.mWcKeyboard.s(this);
    setWPKeyboard(this.Hvd.getContentEt(), true, false);
    this.mWcKeyboard.setActionText(getString(2131767447));
    this.Hvd.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(213893);
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66)) {
          WalletBalanceFetchUI.h(WalletBalanceFetchUI.this);
        }
        AppMethodBeat.o(213893);
        return true;
      }
    });
    this.Hvg = ((TextView)findViewById(2131310112));
    this.Hvh = ((TextView)findViewById(2131300602));
    this.Hvi = ((TextView)findViewById(2131300599));
    this.Hvj = ((TextView)findViewById(2131300600));
    this.Hvk = ((ViewGroup)findViewById(2131300601));
    this.Hvl = ((ViewGroup)findViewById(2131300603));
    com.tencent.mm.ui.ao.a(this.Hvi.getPaint(), 0.8F);
    this.Hvi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68597);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletBalanceFetchUI.i(WalletBalanceFetchUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68597);
      }
    });
    this.Hvd.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(68598);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        str.length();
        int j = str.lastIndexOf(".");
        int k = str.length();
        if ((i >= 0) && (k - i > 3)) {
          WalletFormView.a(WalletBalanceFetchUI.j(WalletBalanceFetchUI.this).getContentEt(), str, i + 3, k);
        }
        for (;;)
        {
          WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, Util.getDouble(paramAnonymousEditable.toString(), 0.0D));
          WalletBalanceFetchUI.fNl();
          WalletBalanceFetchUI.k(WalletBalanceFetchUI.this);
          WalletBalanceFetchUI.l(WalletBalanceFetchUI.this);
          AppMethodBeat.o(68598);
          return;
          if (j != i) {
            WalletFormView.a(WalletBalanceFetchUI.j(WalletBalanceFetchUI.this).getContentEt(), str, j, k);
          }
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    localObject = new zt();
    ((zt)localObject).efM.scene = "3";
    ((zt)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213894);
        if (!Util.isNullOrNil(this.qBN.efN.efO))
        {
          com.tencent.mm.wallet_core.ui.f.a(WalletBalanceFetchUI.m(WalletBalanceFetchUI.this), this.qBN.efN.efO, this.qBN.efN.content, this.qBN.efN.url);
          AppMethodBeat.o(213894);
          return;
        }
        Log.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
        AppMethodBeat.o(213894);
      }
    };
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(68610);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(213901);
    Log.d("MicroMsg.WalletBalanceFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.HvA), Boolean.valueOf(this.mWcKeyboard.hgR()) });
    if ((!this.HvA) && (this.mWcKeyboard.hgR()))
    {
      AppMethodBeat.o(213901);
      return true;
    }
    AppMethodBeat.o(213901);
    return false;
  }
  
  public boolean isTransparent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68622);
    if (paramInt1 == 1)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramInt1 = paramIntent.getIntExtra("key_select_index", -1);
        paramInt2 = this.whv;
        this.whv = paramInt1;
        Log.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is ".concat(String.valueOf(paramInt1)));
        if ((this.Hva == null) || (paramInt1 < 0) || (paramInt1 >= this.Hva.size())) {
          if ((this.Hva == null) || (paramInt1 < 0) || (paramInt1 > this.Hva.size()))
          {
            this.Hvb = null;
            fNj();
          }
        }
        for (;;)
        {
          updateView();
          AppMethodBeat.o(68622);
          return;
          this.whv = paramInt2;
          break;
          this.Hvb = ((Bankcard)this.Hva.get(paramInt1));
        }
      }
      Log.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
      AppMethodBeat.o(68622);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(68622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68607);
    this.lem = UUID.randomUUID().toString();
    super.onCreate(paramBundle);
    hideActionbarLine();
    bf(getIntent());
    fetchData();
    this.Hvc = getString(2131767468);
    initView();
    updateView();
    ab.mg(4, 0);
    AppMethodBeat.o(68607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68608);
    MMHandlerThread.removeRunnable(this.Hvy);
    MMHandlerThread.removeRunnable(this.jVx);
    MMHandlerThread.removeRunnable(this.HvB);
    super.onDestroy();
    AppMethodBeat.o(68608);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(213900);
    Log.i("MicroMsg.WalletBalanceFetchUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
    AppMethodBeat.o(213900);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(68621);
    this.Hvd.hK(null);
    AppMethodBeat.o(68621);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68626);
    fNi();
    bf(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(68626);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(213899);
    super.onPause();
    if (!this.mWcKeyboard.hgQ()) {
      this.state = 3;
    }
    AppMethodBeat.o(213899);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68611);
    fNi();
    super.onResume();
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.HvB, 300L);
    }
    this.state = 2;
    fNd();
    AppMethodBeat.o(68611);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(68619);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof d))
      {
        paramString = (d)paramq;
        this.HvC = false;
        if (!this.HvF) {
          this.HvD = false;
        }
        this.HvE = false;
        this.HvF = false;
        boolean bool;
        if ("1".equals(paramString.egd))
        {
          Log.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
          paramq = new Bundle();
          paramq.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
          paramq.putString("realname_verify_process_jump_plugin", "wallet");
          isTransparent();
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramq, null, 0);
        }
        while (bool)
        {
          AppMethodBeat.o(68619);
          return false;
          if ("2".equals(paramString.egd))
          {
            Log.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.ege, paramString.egh, paramString.egf, paramString.egg, isTransparent(), null);
          }
          else
          {
            Log.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + paramString.egd);
            bool = false;
          }
        }
        if (paramString.HsZ) {
          if (paramString.Hta != null)
          {
            Log.i("MicroMsg.WalletBalanceFetchUI", "debugIdentifyInfoCompleteDialog() show");
            Object localObject = paramString.Hta.title;
            String str1 = paramString.Hta.content;
            String str2 = paramString.Hta.gTt;
            paramq = paramString.Hta.Htc;
            Log.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog()");
            View localView = LayoutInflater.from(this).inflate(2131496879, null);
            ImageView localImageView = (ImageView)localView.findViewById(2131298778);
            Button localButton = (Button)localView.findViewById(2131298979);
            ((TextView)localView.findViewById(2131304338)).setText((CharSequence)localObject);
            ((TextView)localView.findViewById(2131304333)).setText(str1);
            ((Button)localView.findViewById(2131298979)).setText(str2);
            localObject = new com.tencent.mm.plugin.crashfix.b.a(this, 2131821772);
            ((Dialog)localObject).setContentView(localView);
            ((Dialog)localObject).setTitle(null);
            ((Dialog)localObject).setOnCancelListener(new WalletBalanceFetchUI.18(this, (Dialog)localObject));
            localImageView.setOnClickListener(new WalletBalanceFetchUI.19(this, (Dialog)localObject));
            localButton.setOnClickListener(new WalletBalanceFetchUI.20(this, this, paramq, (Dialog)localObject));
            ((Dialog)localObject).show();
            com.tencent.mm.ui.base.h.a(this, (Dialog)localObject);
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label491;
          }
          AppMethodBeat.o(68619);
          return false;
          Log.i("MicroMsg.WalletBalanceFetchUI", "fetchScene.accountTipDialog == null");
          break;
        }
        label491:
        af.z(21, paramString.dNQ, paramInt2);
        if (!b(paramString))
        {
          this.dDL = paramString.dNQ;
          a(paramString);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68619);
      return false;
      if ((paramq instanceof ad))
      {
        paramString = (ad)paramq;
        fNh();
        if (paramString.isJumpRemind())
        {
          paramq = paramString.getJumpRemind();
          paramq.a(this, new com.tencent.mm.wallet_core.c.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(213874);
              if (paramq.hhm()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(213874);
            }
            
            public final void onEnter() {}
            
            public final void onUrlCancel()
            {
              AppMethodBeat.i(213876);
              if (paramq.hhm()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(213876);
            }
            
            public final void onUrlOk()
            {
              AppMethodBeat.i(213875);
              if (paramq.hhm()) {
                WalletBalanceFetchUI.o(WalletBalanceFetchUI.this);
              }
              AppMethodBeat.o(213875);
            }
          });
          AppMethodBeat.o(68619);
          return true;
          if ((paramq instanceof d))
          {
            af.z(21, "", paramInt2);
            fNi();
            MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
          }
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI
 * JD-Core Version:    0.7.0.1
 */