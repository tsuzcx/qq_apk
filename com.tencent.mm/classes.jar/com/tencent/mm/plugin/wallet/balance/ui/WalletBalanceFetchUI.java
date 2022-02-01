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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.b;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.d;
import com.tencent.mm.plugin.wallet.balance.model.d.a;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.b.c;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public class WalletBalanceFetchUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private ArrayList<Bankcard> CyC;
  private Bankcard CyD;
  private String CyE;
  private WalletFormView CyF;
  private LinearLayout CyG;
  private View CyH;
  private TextView CyI;
  private TextView CyJ;
  private TextView CyK;
  private TextView CyL;
  private TextView CyM;
  private TextView CyN;
  private ViewGroup CyO;
  private ViewGroup CyP;
  private int CyQ;
  private int CyR;
  private int CyS;
  private double CyT;
  private int CyU;
  private DecimalFormat CyV;
  private boolean CyW;
  private int CyX;
  private int CyY;
  private com.tencent.mm.plugin.wallet.balance.model.b CyZ;
  private int Cza;
  private Runnable Czb;
  private boolean Czc;
  private boolean Czd;
  private boolean Cze;
  private boolean Czf;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private String dlu;
  private View iCR;
  private String jXQ;
  private Button jqk;
  private int sQX;
  com.tencent.mm.ui.widget.a.e sheet;
  private com.tencent.mm.sdk.b.c<ks> wxJ;
  private double xXb;
  
  public WalletBalanceFetchUI()
  {
    AppMethodBeat.i(68606);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 270);
    this.dlu = null;
    this.CyQ = 0;
    this.CyR = 0;
    this.CyS = 0;
    this.CyT = 0.0D;
    this.sQX = -1;
    this.CyU = 0;
    this.CyV = new DecimalFormat("0.00");
    this.CyW = false;
    this.CyX = 0;
    this.CyY = 0;
    this.Cza = aj.getContext().getResources().getColor(2131099734);
    this.Czb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68576);
        WalletBalanceFetchUI.a(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68576);
      }
    };
    this.Czc = false;
    this.Czd = false;
    this.Cze = false;
    this.Czf = false;
    this.wxJ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68606);
  }
  
  private void a(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(174434);
    Bundle localBundle = new Bundle();
    localBundle.putInt("payScene", 21);
    localBundle.putString("totalFee", com.tencent.mm.wallet_core.ui.e.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localBundle.putString("feeType", paramString1);
    localBundle.putString("bankType", paramString2);
    localBundle.putString("bindSerial", paramString3);
    localBundle.putString("operation", String.valueOf(paramInt));
    localBundle.putString("reportSessionId", this.jXQ);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "startWalletBalanceFetchUseCase totalFee：%s reportSessionId %s", new Object[] { com.tencent.mm.wallet_core.ui.e.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString(), this.jXQ });
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWalletBalanceFetchUseCase(this, localBundle);
    AppMethodBeat.o(174434);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(68618);
    if (!bt.isNullOrNil(this.dlu))
    {
      Object localObject = new PayInfo();
      ((PayInfo)localObject).dlu = this.dlu;
      ((PayInfo)localObject).dCC = 21;
      getInput().putParcelable("key_pay_info", (Parcelable)localObject);
      localObject = new Orders();
      ((Orders)localObject).dlx = (paramd.xYB - paramd.xYr);
      ((Orders)localObject).CXT = (paramd.xYB - paramd.xYr);
      ((Orders)localObject).CYk.add(new Orders.Commodity());
      ((Orders)localObject).xYr = paramd.xYr;
      getInput().putString("key_fetch_cashier_encode_str", paramd.CwF);
      getInput().putParcelable("key_orders", (Parcelable)localObject);
      getInput().putParcelable("key_bankcard", this.CyD);
      getInput().putString("key_fetch_cashier_desc", paramd.CwC);
      getInput().putString("key_report_session_id", this.jXQ);
      if (getProcess() == null)
      {
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, getInput(), null);
        AppMethodBeat.o(68618);
        return;
      }
      getNetController().s(new Object[] { getInput() });
      AppMethodBeat.o(68618);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
    AppMethodBeat.o(68618);
  }
  
  private void aT(Intent paramIntent)
  {
    AppMethodBeat.i(68627);
    this.CyW = aU(paramIntent);
    if (this.CyW)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
      PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
      paramIntent = localPayInfo;
      if (localPayInfo == null)
      {
        paramIntent = new PayInfo();
        paramIntent.dlu = this.dlu;
        paramIntent.dCC = 21;
      }
      doSceneForceProgress(new aa(paramIntent.dlu));
    }
    AppMethodBeat.o(68627);
  }
  
  private static boolean aU(Intent paramIntent)
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
  
  private boolean b(d paramd)
  {
    boolean bool3 = false;
    AppMethodBeat.i(68623);
    if (!this.Czc) {}
    for (boolean bool1 = c(paramd);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = false;
      }
      if ((!bool2) && (!this.Czd)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!this.Cze) {
            bool2 = d(paramd);
          }
        }
        AppMethodBeat.o(68623);
        return bool2;
      }
    }
  }
  
  private boolean c(final d paramd)
  {
    AppMethodBeat.i(68624);
    if (paramd.Cwx)
    {
      this.Czc = true;
      h.a(this, false, paramd.Cwy, "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68582);
          paramAnonymousDialogInterface.dismiss();
          if (!WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd))
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd.dve);
            WalletBalanceFetchUI.b(WalletBalanceFetchUI.this, paramd);
          }
          AppMethodBeat.o(68582);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68583);
          paramAnonymousDialogInterface.dismiss();
          WalletBalanceFetchUI.p(WalletBalanceFetchUI.this);
          AppMethodBeat.o(68583);
        }
      });
      AppMethodBeat.o(68624);
      return true;
    }
    AppMethodBeat.o(68624);
    return false;
  }
  
  private void cJW()
  {
    AppMethodBeat.i(68614);
    s.eDp();
    final com.tencent.mm.plugin.wallet_core.model.b localb = s.eDq().DaY;
    removeAllOptionMenu();
    if ((localb != null) && (localb.CUl != null) && (localb.CUl.CUn != null) && (localb.CUl.CUn.length > 0)) {
      addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68605);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletBalanceFetchUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.KJy = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(68603);
              b.c[] arrayOfc = WalletBalanceFetchUI.24.this.Czs.CUl.CUn;
              int k = arrayOfc.length;
              int i = 0;
              int j = 0;
              if (i < k)
              {
                b.c localc = arrayOfc[i];
                if (!bt.isNullOrNil(localc.title))
                {
                  if (bt.isNullOrNil(localc.desc)) {
                    break label91;
                  }
                  paramAnonymous2l.a(j, localc.title, localc.desc, 0);
                }
                for (;;)
                {
                  j += 1;
                  i += 1;
                  break;
                  label91:
                  paramAnonymous2l.c(j, localc.title);
                }
              }
              AppMethodBeat.o(68603);
            }
          };
          paramAnonymousMenuItem.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68604);
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
              if ((WalletBalanceFetchUI.24.this.Czs.CUl.CUn != null) && (paramAnonymous2Int < WalletBalanceFetchUI.24.this.Czs.CUl.CUn.length))
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.24.this.Czs.CUl.CUn[paramAnonymous2Int];
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.uxt), paramAnonymous2MenuItem.ozD });
                switch (paramAnonymous2MenuItem.uxt)
                {
                }
              }
              for (;;)
              {
                AppMethodBeat.o(68604);
                return;
                com.tencent.mm.wallet_core.ui.e.o(WalletBalanceFetchUI.this.getContext(), paramAnonymous2MenuItem.ozD, true);
                AppMethodBeat.o(68604);
                return;
                com.tencent.mm.wallet_core.ui.e.v(paramAnonymous2MenuItem.username, paramAnonymous2MenuItem.path, 0, 1000);
              }
            }
          };
          paramAnonymousMenuItem.cMW();
          AppMethodBeat.o(68605);
          return true;
        }
      });
    }
    AppMethodBeat.o(68614);
  }
  
  private boolean d(d paramd)
  {
    AppMethodBeat.i(68625);
    paramd = paramd.CwA;
    if ((paramd != null) && ((!TextUtils.isEmpty(paramd.CUh)) || ((paramd.CUi != null) && (paramd.CUi.size() > 0))))
    {
      this.Cze = true;
      com.tencent.mm.plugin.wallet_core.ui.m.a(this, paramd, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68584);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = "";
          String str = "";
          if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null)
          {
            paramAnonymousDialogInterface = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bankcardType;
            str = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial;
          }
          WalletBalanceFetchUI.q(WalletBalanceFetchUI.this);
          WalletBalanceFetchUI.r(WalletBalanceFetchUI.this);
          if (WalletBalanceFetchUI.eCx())
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, WalletBalanceFetchUI.s(WalletBalanceFetchUI.this), "1", paramAnonymousDialogInterface, str, WalletBalanceFetchUI.t(WalletBalanceFetchUI.this));
            AppMethodBeat.o(68584);
            return;
          }
          WalletBalanceFetchUI.this.doSceneProgress(new d(WalletBalanceFetchUI.s(WalletBalanceFetchUI.this), "CNY", paramAnonymousDialogInterface, WalletBalanceFetchUI.t(WalletBalanceFetchUI.this)));
          AppMethodBeat.o(68584);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(199195);
          paramAnonymousDialogInterface.dismiss();
          WalletBalanceFetchUI.p(WalletBalanceFetchUI.this);
          AppMethodBeat.o(199195);
        }
      });
      AppMethodBeat.o(68625);
      return true;
    }
    AppMethodBeat.o(68625);
    return false;
  }
  
  private void eCn()
  {
    AppMethodBeat.i(68612);
    if (this.CyD != null)
    {
      this.CyT = com.tencent.mm.wallet_core.ui.e.a(this.CyD.CUZ, "100", 2, RoundingMode.HALF_UP);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "min charge fee: %s", new Object[] { Double.valueOf(this.CyT) });
    }
    AppMethodBeat.o(68612);
  }
  
  private void eCo()
  {
    AppMethodBeat.i(68615);
    if ((this.xXb > 0.0D) && (this.CyD != null))
    {
      this.jqk.setEnabled(true);
      AppMethodBeat.o(68615);
      return;
    }
    this.jqk.setEnabled(false);
    AppMethodBeat.o(68615);
  }
  
  private void eCp()
  {
    AppMethodBeat.i(68616);
    double d;
    StringBuilder localStringBuilder;
    if (this.CyX == 0)
    {
      this.xXb = bt.getDouble(this.CyF.getText(), 0.0D);
      d = this.xXb;
      s.eDp();
      if ((d != s.eDq().CzB.CUF) && (this.CyD != null))
      {
        d = this.xXb;
        s.eDp();
        if (d != s.eDq().CzB.CUF - this.CyD.field_full_fetch_charge_fee) {
          this.CyU = 0;
        }
      }
      localStringBuilder = new StringBuilder();
      d = this.xXb;
      s.eDp();
      if (d <= s.eDq().CzB.CUD) {
        break label181;
      }
      this.CyM.setVisibility(8);
      this.CyL.setTextColor(getResources().getColor(2131099803));
      localStringBuilder.append(getString(2131764997));
    }
    for (;;)
    {
      this.CyL.setText(localStringBuilder.toString());
      AppMethodBeat.o(68616);
      return;
      label181:
      String str;
      if ((this.CyD != null) && (this.CyQ != 0) && ((this.CyQ != 1) || (this.CyD.field_fetch_charge_rate > 0.0D)) && ((this.CyQ != 1) || (this.CyD.field_fetch_charge_rate <= 0.0D) || (this.CyR != 0)))
      {
        d = this.CyT;
        s.eDp();
        if (d < s.eDq().CzB.CUF) {}
      }
      else
      {
        this.CyM.setVisibility(0);
        this.CyL.setTextColor(this.Cza);
        s.eDp();
        str = s.eDq().CzB.CUK;
        if (!bt.isNullOrNil(str)) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          s.eDp();
          localStringBuilder.append(getString(2131764988, new Object[] { com.tencent.mm.wallet_core.ui.e.d(s.eDq().CzB.CUF, "CNY") }));
        }
      }
      if ((this.CyQ == 1) && (this.CyD.field_fetch_charge_rate > 0.0D) && (this.CyR == 1) && ((this.xXb <= 0.0D) || (!this.CyF.aVa())))
      {
        this.CyM.setVisibility(0);
        this.CyL.setTextColor(this.Cza);
        s.eDp();
        str = s.eDq().CzB.CUK;
        if (!bt.isNullOrNil(str)) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          s.eDp();
          localStringBuilder.append(getString(2131764988, new Object[] { com.tencent.mm.wallet_core.ui.e.d(s.eDq().CzB.CUF, "CNY") }));
        }
      }
      if ((this.CyQ == 1) && (this.CyD.field_fetch_charge_rate > 0.0D) && (this.CyR == 1))
      {
        this.CyM.setVisibility(8);
        this.CyL.setTextColor(this.Cza);
        d = this.xXb;
        s.eDp();
        if ((d == s.eDq().CzB.CUF - this.CyD.field_full_fetch_charge_fee) && (this.CyD.field_full_fetch_charge_fee > 0.0D))
        {
          if (!bt.isNullOrNil(this.CyD.CUY)) {
            localStringBuilder.append(String.format(this.CyD.CUY, new Object[] { com.tencent.mm.wallet_core.ui.e.d(this.CyD.field_full_fetch_charge_fee, "CNY") }));
          } else {
            localStringBuilder.append(getString(2131764970, new Object[] { com.tencent.mm.wallet_core.ui.e.d(this.CyD.field_full_fetch_charge_fee, "CNY"), this.CyD.field_fetch_charge_rate * 100.0D + "%" }));
          }
        }
        else if (!bt.isNullOrNil(this.CyD.CUY)) {
          localStringBuilder.append(String.format(this.CyD.CUY, new Object[] { com.tencent.mm.wallet_core.ui.e.d(z(this.xXb), "CNY") }));
        } else {
          localStringBuilder.append(getString(2131764970, new Object[] { com.tencent.mm.wallet_core.ui.e.d(z(this.xXb), "CNY"), this.CyD.field_fetch_charge_rate * 100.0D + "%" }));
        }
      }
    }
  }
  
  private void eCq()
  {
    AppMethodBeat.i(199204);
    s.eDp();
    final Bankcard localBankcard = s.eDq().CzB;
    if ((this.CyD != null) && (!bt.isNullOrNil(localBankcard.field_prompt_info_prompt_text)))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
      if (!bt.isNullOrNil(localBankcard.field_prompt_info_jump_text)) {
        localSpannableStringBuilder.append(localBankcard.field_prompt_info_jump_text);
      }
      localSpannableStringBuilder.setSpan(new q(new q.a()
      {
        public final void dN(View paramAnonymousView)
        {
          AppMethodBeat.i(199191);
          if (!bt.isNullOrNil(localBankcard.field_prompt_info_jump_url))
          {
            com.tencent.mm.wallet_core.ui.e.aW(WalletBalanceFetchUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
            com.tencent.mm.plugin.report.service.g.yhR.f(20216, new Object[] { Integer.valueOf(4), localBankcard.field_prompt_info_jump_url });
          }
          AppMethodBeat.o(199191);
        }
      }), localBankcard.field_prompt_info_prompt_text.length(), localSpannableStringBuilder.length(), 18);
      this.CyN.setText(localSpannableStringBuilder);
      this.CyN.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(getContext()));
      this.CyN.setVisibility(0);
      this.Cza = getContext().getResources().getColor(2131099732);
      this.CyL.setTextColor(this.Cza);
      AppMethodBeat.o(199204);
      return;
    }
    this.CyN.setText("");
    this.CyN.setVisibility(8);
    this.Cza = getContext().getResources().getColor(2131099734);
    this.CyL.setTextColor(this.Cza);
    AppMethodBeat.o(199204);
  }
  
  private void eCr()
  {
    AppMethodBeat.i(68620);
    fetchData();
    updateView();
    eCu();
    AppMethodBeat.o(68620);
  }
  
  private void eCs()
  {
    this.Czc = false;
    this.Czd = false;
    this.Cze = false;
    this.Czf = false;
  }
  
  private void eCt()
  {
    AppMethodBeat.i(68628);
    Object localObject = com.tencent.mm.plugin.wallet_core.model.g.eFb();
    if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bni())
    {
      h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).wBJ, getString(2131755906), true);
      AppMethodBeat.o(68628);
      return;
    }
    Bundle localBundle = new Bundle();
    PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
    localObject = localPayInfo;
    if (localPayInfo == null)
    {
      localObject = new PayInfo();
      ((PayInfo)localObject).dlu = this.dlu;
      ((PayInfo)localObject).dCC = 21;
    }
    if (localObject != null) {
      localBundle.putParcelable("key_pay_info", (Parcelable)localObject);
    }
    localBundle.putInt("key_scene", 21);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_is_bind_bankcard", true);
    localBundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.Cwu);
    localBundle.putBoolean("key_bind_show_change_card", true);
    if (g(this, localBundle))
    {
      AppMethodBeat.o(68628);
      return;
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, localBundle, null);
    AppMethodBeat.o(68628);
  }
  
  private void eCu()
  {
    AppMethodBeat.i(68630);
    if (this.CyQ != 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.CyQ);
      AppMethodBeat.o(68630);
      return;
    }
    com.tencent.mm.kernel.g.ajD();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IuM, Boolean.FALSE)).booleanValue();
    s.eDp();
    com.tencent.mm.plugin.wallet_core.model.b localb = s.eDq().DaY;
    if ((localb != null) && (!bool))
    {
      h.a(this, getString(2131765687, new Object[] { com.tencent.mm.wallet_core.ui.e.D(localb.xYv) }), getString(2131765688), getString(2131765291), getString(2131765689), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68587);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.g.yhR.f(16398, new Object[] { WalletBalanceFetchUI.d(WalletBalanceFetchUI.this), Integer.valueOf(4), "", "" });
          AppMethodBeat.o(68587);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(199197);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", WalletBalanceFetchUI.this.getString(2131765260));
          localIntent.putExtra("showShare", false);
          com.tencent.mm.wallet_core.ui.e.an(WalletBalanceFetchUI.this.getContext(), localIntent);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.g.yhR.f(16398, new Object[] { WalletBalanceFetchUI.d(WalletBalanceFetchUI.this), Integer.valueOf(3), "", "" });
          AppMethodBeat.o(199197);
        }
      }, 2131101171);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IuM, Boolean.TRUE);
    }
    AppMethodBeat.o(68630);
  }
  
  private static boolean eCv()
  {
    AppMethodBeat.i(174433);
    com.tencent.mm.wallet_core.b.fQJ();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qwl, true);
    com.tencent.mm.wallet_core.b.fQJ();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qzz, false);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(174433);
      return true;
    }
    AppMethodBeat.o(174433);
    return false;
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(68609);
    s.eDp();
    an localan = s.eDq();
    Object localObject2;
    Object localObject3;
    int i;
    Object localObject4;
    if (this.CyW)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      if ((this.CyC != null) && (this.CyC.size() > 0)) {
        ((ArrayList)localObject1).addAll(this.CyC);
      }
      this.CyC = localan.eGw();
      if ((this.CyC != null) && (this.CyC.size() > 0)) {
        ((ArrayList)localObject2).addAll(this.CyC);
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
        localObject1 = localan.a(this.CyC, null, false, true);
      }
      for (;;)
      {
        i = 0;
        if ((this.CyC != null) && (i < this.CyC.size()))
        {
          localObject2 = (Bankcard)this.CyC.get(i);
          if ((localObject1 != null) && (localObject2 != null) && (((Bankcard)localObject1).field_bindSerial.equals(((Bankcard)localObject2).field_bindSerial))) {
            this.sQX = i;
          }
        }
        else
        {
          this.CyD = ((Bankcard)localObject1);
          this.CyW = false;
          localObject3 = com.tencent.mm.plugin.report.service.g.yhR;
          localObject4 = this.jXQ;
          if (this.CyD == null) {
            break label587;
          }
          localObject1 = this.CyD.field_bankcardType;
          label373:
          if (this.CyD == null) {
            break label594;
          }
          localObject2 = this.CyD.field_bindSerial;
          ((com.tencent.mm.plugin.report.service.g)localObject3).f(16398, new Object[] { localObject4, Integer.valueOf(1), localObject1, localObject2 });
          if (localan.DaY == null) {
            break label602;
          }
          this.CyQ = localan.DaY.CyQ;
          this.CyR = localan.DaY.CyR;
          eCn();
          this.CyS = localan.DaY.CyS;
        }
        for (;;)
        {
          this.CyX = 0;
          this.CyY = 0;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.CyQ + " is_cal_charge:" + this.CyR + " min_charge_fee:" + this.CyT + " is_full_fetch_direct:" + this.CyS);
          AppMethodBeat.o(68609);
          return;
          i += 1;
          break;
          this.CyC = localan.eGw();
          this.CyD = localan.a(this.CyC, null, false, true);
          break label347;
          localObject1 = "";
          break label373;
          localObject2 = "";
          break label389;
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
      }
    }
  }
  
  private boolean g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(68631);
    com.tencent.mm.wallet_core.b.fQJ();
    if (com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qzx, false))
    {
      com.tencent.mm.sdk.b.a.IbL.b(this.wxJ);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:true");
      ab.kB(6, paramBundle.getInt("key_bind_scene"));
      z.agm(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(68631);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:false");
    AppMethodBeat.o(68631);
    return false;
  }
  
  private void updateView()
  {
    AppMethodBeat.i(68613);
    final ImageView localImageView;
    Object localObject;
    if (this.CyF.getTitleTv() != null)
    {
      this.CyF.getTitleTv().setText(String.format(getString(2131762486), new Object[] { ah.fRG() }));
      localImageView = (ImageView)this.CyG.findViewById(2131297166);
      if (this.CyD == null) {
        break label486;
      }
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.i(this, this.CyD.field_bankcardType, this.CyD.eEQ());
      if (locale != null) {
        localObject = locale.wqa;
      }
      localImageView.setImageBitmap(null);
      if (!this.CyD.eER()) {
        break label391;
      }
      localImageView.setBackgroundResource(2131234612);
      label121:
      ((TextView)this.CyG.findViewById(2131297091)).setText(getString(2131765024, new Object[] { this.CyD.field_bankName, this.CyD.field_bankcardTail }));
      ((TextView)this.CyG.findViewById(2131297091)).setVisibility(0);
      if (!bt.isNullOrNil(this.CyD.field_fetchArriveTimeWording))
      {
        ((TextView)this.CyG.findViewById(2131300742)).setText(this.CyD.field_fetchArriveTimeWording);
        ((TextView)this.CyG.findViewById(2131300742)).setVisibility(0);
        if (this.CyD.field_is_hightlight_pre_arrive_time_wording != 1) {
          break label457;
        }
        ((TextView)this.CyG.findViewById(2131300742)).setTextColor(getResources().getColor(2131099777));
      }
      label275:
      this.CyK.setText("");
      this.CyK.setVisibility(8);
      label294:
      s.eDp();
      localObject = s.eDq().CzB.CUJ;
      if (bt.isNullOrNil((String)localObject)) {
        break label577;
      }
      this.CyJ.setVisibility(0);
      this.CyJ.setText((CharSequence)localObject);
      label331:
      if (this.CyX != 1) {
        break label589;
      }
      this.CyO.setVisibility(8);
      this.CyP.setVisibility(0);
    }
    for (;;)
    {
      eCo();
      eCp();
      eCq();
      cJW();
      AppMethodBeat.o(68613);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
      break;
      label391:
      localObject = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      com.tencent.mm.platformtools.u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68602);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68601);
              if ((WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null) && (WalletBalanceFetchUI.23.this.Czq != null) && (WalletBalanceFetchUI.23.this.Czq.getTag() != null) && (WalletBalanceFetchUI.23.this.Czq.getTag().equals(WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial))) {
                WalletBalanceFetchUI.23.this.Czq.setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(68601);
            }
          });
          AppMethodBeat.o(68602);
        }
      });
      if ((localObject == null) || (localObject == null)) {
        break label121;
      }
      localImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, getResources().getDimensionPixelOffset(2131167003), getResources().getDimensionPixelOffset(2131167003), true, false));
      break label121;
      label457:
      ((TextView)this.CyG.findViewById(2131300742)).setTextColor(getResources().getColor(2131100490));
      break label275;
      label486:
      localImageView.setImageBitmap(null);
      ((TextView)this.CyG.findViewById(2131297091)).setText(this.CyE);
      ((TextView)this.CyG.findViewById(2131300742)).setText("");
      ((TextView)this.CyG.findViewById(2131300742)).setVisibility(8);
      ((ImageView)this.CyG.findViewById(2131297166)).setImageBitmap(null);
      this.CyK.setVisibility(8);
      break label294;
      label577:
      this.CyJ.setVisibility(8);
      break label331;
      label589:
      this.CyO.setVisibility(0);
      this.CyP.setVisibility(8);
    }
  }
  
  private double z(double paramDouble)
  {
    AppMethodBeat.i(68617);
    s.eDp();
    an localan = s.eDq();
    paramDouble = Math.max(com.tencent.mm.wallet_core.ui.e.b(paramDouble - localan.DaY.xYv, this.CyD.field_fetch_charge_rate, RoundingMode.HALF_UP), this.CyT);
    AppMethodBeat.o(68617);
    return paramDouble;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495900;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68610);
    setMMTitle(2131764994);
    this.iCR = findViewById(2131299904);
    this.CyG = ((LinearLayout)findViewById(2131297090));
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68591);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        WalletBalanceFetchUI.this.hideTenpayKB();
        s.eDp();
        final ArrayList localArrayList = s.eDq().eGw();
        s.eDp();
        Object localObject2 = s.eDq().DaY;
        localObject1 = "";
        if (localObject2 != null)
        {
          paramAnonymousView = ((com.tencent.mm.plugin.wallet_core.model.b)localObject2).CUk;
          localObject1 = ((com.tencent.mm.plugin.wallet_core.model.b)localObject2).CUj;
        }
        for (;;)
        {
          if (localArrayList == null) {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "debit is null");
          }
          localObject2 = WalletBalanceFetchUI.this;
          Object localObject3 = WalletBalanceFetchUI.this.getContext();
          Bankcard localBankcard = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this);
          n.e local1 = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68590);
              if ((localArrayList != null) && (paramAnonymous2Int < localArrayList.size()))
              {
                WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, (Bankcard)localArrayList.get(paramAnonymous2Int));
                WalletBalanceFetchUI.c(WalletBalanceFetchUI.this);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[] { WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_desc });
                localg = com.tencent.mm.plugin.report.service.g.yhR;
                str2 = WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
                if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null)
                {
                  paramAnonymous2MenuItem = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bankcardType;
                  if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) == null) {
                    break label214;
                  }
                }
                label214:
                for (str1 = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial;; str1 = "")
                {
                  localg.f(16398, new Object[] { str2, Integer.valueOf(2), paramAnonymous2MenuItem, str1 });
                  WalletBalanceFetchUI.f(WalletBalanceFetchUI.this);
                  WalletBalanceFetchUI.eCw();
                  AppMethodBeat.o(68590);
                  return;
                  paramAnonymous2MenuItem = "";
                  break;
                }
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "add new card");
              WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
              com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
              String str2 = WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
              if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null)
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bankcardType;
                label281:
                if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) == null) {
                  break label350;
                }
              }
              label350:
              for (String str1 = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial;; str1 = "")
              {
                localg.f(16398, new Object[] { str2, Integer.valueOf(9), paramAnonymous2MenuItem, str1 });
                break;
                paramAnonymous2MenuItem = "";
                break label281;
              }
            }
          };
          if ((((WalletBalanceFetchUI)localObject2).sheet != null) && (((WalletBalanceFetchUI)localObject2).sheet.isShowing()))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "mmBottomSheet != null && mmBottomSheet.isShowing(),dont show bottomSheet");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68591);
            return;
          }
          ((WalletBalanceFetchUI)localObject2).sheet = new com.tencent.mm.ui.widget.a.e((Context)localObject3, 2, true);
          ((WalletBalanceFetchUI)localObject2).sheet.KJy = new WalletBalanceFetchUI.13((WalletBalanceFetchUI)localObject2, localArrayList, (Context)localObject3);
          ((WalletBalanceFetchUI)localObject2).sheet.KJz = local1;
          ((WalletBalanceFetchUI)localObject2).sheet.KWX = true;
          localObject3 = LayoutInflater.from((Context)localObject3).inflate(2131495898, null);
          if (!bt.isNullOrNil((String)localObject1)) {
            ((TextView)((View)localObject3).findViewById(2131297202)).setText((CharSequence)localObject1);
          }
          if (!bt.isNullOrNil(paramAnonymousView)) {
            ((TextView)((View)localObject3).findViewById(2131297201)).setText(paramAnonymousView);
          }
          ((WalletBalanceFetchUI)localObject2).sheet.K((View)localObject3, false);
          int i;
          if (localArrayList != null)
          {
            i = localArrayList.size();
            if (localBankcard != null)
            {
              int j = 0;
              for (;;)
              {
                k = i;
                if (j >= localArrayList.size()) {
                  break;
                }
                if (!((Bankcard)localArrayList.get(j)).field_bindSerial.equals(localBankcard.field_bindSerial)) {
                  break label398;
                }
                i = j;
                label367:
                j += 1;
              }
            }
          }
          for (int k = i;; k = 0)
          {
            ((WalletBalanceFetchUI)localObject2).sheet.iKS = k;
            ((WalletBalanceFetchUI)localObject2).sheet.cMW();
            break;
            label398:
            break label367;
          }
          paramAnonymousView = "";
        }
      }
    };
    this.CyH = findViewById(2131297090);
    this.CyH.setOnClickListener((View.OnClickListener)localObject);
    this.CyG.setOnClickListener((View.OnClickListener)localObject);
    this.CyF = ((WalletFormView)findViewById(2131297093));
    setEditFocusListener(this.CyF, 2, false);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.CyF);
    this.CyF.setOnInputValidChangeListener(this);
    this.jqk = ((Button)findViewById(2131302852));
    this.jqk.setOnClickListener(new w()
    {
      public final void caN()
      {
        AppMethodBeat.i(68596);
        WalletBalanceFetchUI.g(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68596);
      }
    });
    this.jqk.setEnabled(false);
    this.CyI = ((TextView)findViewById(2131306652));
    this.CyJ = ((TextView)findViewById(2131297095));
    this.CyK = ((TextView)findViewById(2131297094));
    this.CyL = ((TextView)findViewById(2131299902));
    this.CyM = ((TextView)findViewById(2131299900));
    this.CyN = ((TextView)findViewById(2131308104));
    this.CyO = ((ViewGroup)findViewById(2131299901));
    this.CyP = ((ViewGroup)findViewById(2131299903));
    this.CyM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68597);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletBalanceFetchUI.h(WalletBalanceFetchUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68597);
      }
    });
    this.CyF.a(new TextWatcher()
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
          WalletFormView.a(WalletBalanceFetchUI.i(WalletBalanceFetchUI.this).getContentEt(), str, i + 3, k);
        }
        for (;;)
        {
          WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, bt.getDouble(paramAnonymousEditable.toString(), 0.0D));
          WalletBalanceFetchUI.j(WalletBalanceFetchUI.this);
          WalletBalanceFetchUI.eCw();
          WalletBalanceFetchUI.k(WalletBalanceFetchUI.this);
          AppMethodBeat.o(68598);
          return;
          if (j != i) {
            WalletFormView.a(WalletBalanceFetchUI.i(WalletBalanceFetchUI.this).getContentEt(), str, j, k);
          }
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68599);
        if (paramAnonymousBoolean)
        {
          WalletBalanceFetchUI.l(WalletBalanceFetchUI.this);
          AppMethodBeat.o(68599);
          return;
        }
        WalletBalanceFetchUI.m(WalletBalanceFetchUI.this).scrollTo(0, 0);
        AppMethodBeat.o(68599);
      }
    });
    localObject = new yi();
    ((yi)localObject).dMB.scene = "3";
    ((yi)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68600);
        if (!bt.isNullOrNil(this.pfP.dMC.dMD))
        {
          com.tencent.mm.wallet_core.ui.e.a(WalletBalanceFetchUI.n(WalletBalanceFetchUI.this), this.pfP.dMC.dMD, this.pfP.dMC.content, this.pfP.dMC.url);
          AppMethodBeat.o(68600);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
        AppMethodBeat.o(68600);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(68610);
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
        paramInt2 = this.sQX;
        this.sQX = paramInt1;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is ".concat(String.valueOf(paramInt1)));
        if ((this.CyC == null) || (paramInt1 < 0) || (paramInt1 >= this.CyC.size())) {
          if ((this.CyC == null) || (paramInt1 < 0) || (paramInt1 > this.CyC.size()))
          {
            this.CyD = null;
            eCt();
          }
        }
        for (;;)
        {
          updateView();
          AppMethodBeat.o(68622);
          return;
          this.sQX = paramInt2;
          break;
          this.CyD = ((Bankcard)this.CyC.get(paramInt1));
        }
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
      AppMethodBeat.o(68622);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(68622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68607);
    this.jXQ = UUID.randomUUID().toString();
    super.onCreate(paramBundle);
    aT(getIntent());
    fetchData();
    this.CyE = getString(2131765025);
    initView();
    updateView();
    ab.kB(4, 0);
    AppMethodBeat.o(68607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68608);
    aq.aA(this.Czb);
    super.onDestroy();
    AppMethodBeat.o(68608);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(68621);
    this.CyF.ho(null);
    AppMethodBeat.o(68621);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68626);
    eCs();
    aT(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(68626);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68611);
    eCs();
    super.onResume();
    AppMethodBeat.o(68611);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(68619);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof d))
      {
        paramString = (d)paramn;
        this.Czc = false;
        if (!this.Czf) {
          this.Czd = false;
        }
        this.Cze = false;
        this.Czf = false;
        boolean bool;
        if ("1".equals(paramString.dMS))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
          paramn = new Bundle();
          paramn.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
          paramn.putString("realname_verify_process_jump_plugin", "wallet");
          isTransparent();
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramn, null, 0);
        }
        while (bool)
        {
          AppMethodBeat.o(68619);
          return false;
          if ("2".equals(paramString.dMS))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.dMT, paramString.dMW, paramString.dMU, paramString.dMV, isTransparent(), null);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + paramString.dMS);
            bool = false;
          }
        }
        if (paramString.CwD) {
          if (paramString.CwE != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "debugIdentifyInfoCompleteDialog() show");
            Object localObject = paramString.CwE.title;
            String str1 = paramString.CwE.content;
            String str2 = paramString.CwE.CwG;
            paramn = paramString.CwE.CwH;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog()");
            View localView = LayoutInflater.from(this).inflate(2131495899, null);
            ImageView localImageView = (ImageView)localView.findViewById(2131298370);
            Button localButton = (Button)localView.findViewById(2131298548);
            ((TextView)localView.findViewById(2131302000)).setText((CharSequence)localObject);
            ((TextView)localView.findViewById(2131301996)).setText(str1);
            ((Button)localView.findViewById(2131298548)).setText(str2);
            localObject = new com.tencent.mm.plugin.crashfix.b.a(this, 2131821723);
            ((Dialog)localObject).setContentView(localView);
            ((Dialog)localObject).setTitle(null);
            ((Dialog)localObject).setOnCancelListener(new WalletBalanceFetchUI.14(this, (Dialog)localObject));
            localImageView.setOnClickListener(new WalletBalanceFetchUI.15(this, (Dialog)localObject));
            localButton.setOnClickListener(new WalletBalanceFetchUI.16(this, this, paramn, (Dialog)localObject));
            ((Dialog)localObject).show();
            h.a(this, (Dialog)localObject);
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label491;
          }
          AppMethodBeat.o(68619);
          return false;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "fetchScene.accountTipDialog == null");
          break;
        }
        label491:
        af.w(21, paramString.dve, paramInt2);
        if (!b(paramString))
        {
          this.dlu = paramString.dve;
          a(paramString);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68619);
      return false;
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.ad)paramn;
        eCr();
        if (paramString.isJumpRemind())
        {
          paramn = paramString.getJumpRemind();
          paramn.a(this, new f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(199192);
              if (paramn.fRt()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(199192);
            }
            
            public final void onEnter() {}
            
            public final void onUrlCancel()
            {
              AppMethodBeat.i(199194);
              if (paramn.fRt()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(199194);
            }
            
            public final void onUrlOk()
            {
              AppMethodBeat.i(199193);
              if (paramn.fRt()) {
                WalletBalanceFetchUI.o(WalletBalanceFetchUI.this);
              }
              AppMethodBeat.o(199193);
            }
          });
          AppMethodBeat.o(68619);
          return true;
          if ((paramn instanceof d))
          {
            af.w(21, "", paramInt2);
            eCs();
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