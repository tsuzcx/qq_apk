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
import com.tencent.mm.ak.a.a;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.g.a.yo.b;
import com.tencent.mm.model.v;
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
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
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
  private DecimalFormat CQA;
  private boolean CQB;
  private int CQC;
  private int CQD;
  private com.tencent.mm.plugin.wallet.balance.model.b CQE;
  private int CQF;
  private Runnable CQG;
  private boolean CQH;
  private boolean CQI;
  private boolean CQJ;
  private boolean CQK;
  private ArrayList<Bankcard> CQh;
  private Bankcard CQi;
  private String CQj;
  private WalletFormView CQk;
  private LinearLayout CQl;
  private View CQm;
  private TextView CQn;
  private TextView CQo;
  private TextView CQp;
  private TextView CQq;
  private TextView CQr;
  private TextView CQs;
  private ViewGroup CQt;
  private ViewGroup CQu;
  private int CQv;
  private int CQw;
  private int CQx;
  private double CQy;
  private int CQz;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private String dmw;
  private View iFK;
  private Button jtd;
  private String kbf;
  com.tencent.mm.ui.widget.a.e sheet;
  private int tci;
  private com.tencent.mm.sdk.b.c<kt> wNu;
  private double ymU;
  
  public WalletBalanceFetchUI()
  {
    AppMethodBeat.i(68606);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 270);
    this.dmw = null;
    this.CQv = 0;
    this.CQw = 0;
    this.CQx = 0;
    this.CQy = 0.0D;
    this.tci = -1;
    this.CQz = 0;
    this.CQA = new DecimalFormat("0.00");
    this.CQB = false;
    this.CQC = 0;
    this.CQD = 0;
    this.CQF = ak.getContext().getResources().getColor(2131099734);
    this.CQG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68576);
        WalletBalanceFetchUI.a(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68576);
      }
    };
    this.CQH = false;
    this.CQI = false;
    this.CQJ = false;
    this.CQK = false;
    this.wNu = new com.tencent.mm.sdk.b.c() {};
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
    localBundle.putString("reportSessionId", this.kbf);
    ae.i("MicroMsg.WalletBalanceFetchUI", "startWalletBalanceFetchUseCase totalFee：%s reportSessionId %s", new Object[] { com.tencent.mm.wallet_core.ui.f.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString(), this.kbf });
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWalletBalanceFetchUseCase(this, localBundle);
    AppMethodBeat.o(174434);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(68618);
    if (!bu.isNullOrNil(this.dmw))
    {
      Object localObject = new PayInfo();
      ((PayInfo)localObject).dmw = this.dmw;
      ((PayInfo)localObject).dDH = 21;
      getInput().putParcelable("key_pay_info", (Parcelable)localObject);
      localObject = new Orders();
      ((Orders)localObject).dmz = (paramd.yot - paramd.yoj);
      ((Orders)localObject).Dpy = (paramd.yot - paramd.yoj);
      ((Orders)localObject).DpP.add(new Orders.Commodity());
      ((Orders)localObject).yoj = paramd.yoj;
      getInput().putString("key_fetch_cashier_encode_str", paramd.COk);
      getInput().putParcelable("key_orders", (Parcelable)localObject);
      getInput().putParcelable("key_bankcard", this.CQi);
      getInput().putString("key_fetch_cashier_desc", paramd.COh);
      getInput().putString("key_report_session_id", this.kbf);
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
    ae.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
    AppMethodBeat.o(68618);
  }
  
  private void aU(Intent paramIntent)
  {
    AppMethodBeat.i(68627);
    this.CQB = aV(paramIntent);
    if (this.CQB)
    {
      ae.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
      PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
      paramIntent = localPayInfo;
      if (localPayInfo == null)
      {
        paramIntent = new PayInfo();
        paramIntent.dmw = this.dmw;
        paramIntent.dDH = 21;
      }
      doSceneForceProgress(new aa(paramIntent.dmw));
    }
    AppMethodBeat.o(68627);
  }
  
  private static boolean aV(Intent paramIntent)
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
    if (!this.CQH) {}
    for (boolean bool1 = c(paramd);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = false;
      }
      if ((!bool2) && (!this.CQI)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!this.CQJ) {
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
    if (paramd.COc)
    {
      this.CQH = true;
      com.tencent.mm.ui.base.h.a(this, false, paramd.COd, "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68582);
          paramAnonymousDialogInterface.dismiss();
          if (!WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd))
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd.dwj);
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
  
  private void cMz()
  {
    AppMethodBeat.i(68614);
    s.eGW();
    final com.tencent.mm.plugin.wallet_core.model.b localb = s.eGX().DsC;
    removeAllOptionMenu();
    if ((localb != null) && (localb.DlR != null) && (localb.DlR.DlT != null) && (localb.DlR.DlT.length > 0)) {
      addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68605);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletBalanceFetchUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.LfS = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(68603);
              b.c[] arrayOfc = WalletBalanceFetchUI.24.this.CQX.DlR.DlT;
              int k = arrayOfc.length;
              int i = 0;
              int j = 0;
              if (i < k)
              {
                b.c localc = arrayOfc[i];
                if (!bu.isNullOrNil(localc.title))
                {
                  if (bu.isNullOrNil(localc.desc)) {
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
                  paramAnonymous2l.d(j, localc.title);
                }
              }
              AppMethodBeat.o(68603);
            }
          };
          paramAnonymousMenuItem.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68604);
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
              if ((WalletBalanceFetchUI.24.this.CQX.DlR.DlT != null) && (paramAnonymous2Int < WalletBalanceFetchUI.24.this.CQX.DlR.DlT.length))
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.24.this.CQX.DlR.DlT[paramAnonymous2Int];
                ae.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.uIW), paramAnonymous2MenuItem.oGf });
                switch (paramAnonymous2MenuItem.uIW)
                {
                }
              }
              for (;;)
              {
                AppMethodBeat.o(68604);
                return;
                com.tencent.mm.wallet_core.ui.f.p(WalletBalanceFetchUI.this.getContext(), paramAnonymous2MenuItem.oGf, true);
                AppMethodBeat.o(68604);
                return;
                com.tencent.mm.wallet_core.ui.f.u(paramAnonymous2MenuItem.username, paramAnonymous2MenuItem.path, 0, 1000);
              }
            }
          };
          paramAnonymousMenuItem.cPF();
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
    paramd = paramd.COf;
    if ((paramd != null) && ((!TextUtils.isEmpty(paramd.DlN)) || ((paramd.DlO != null) && (paramd.DlO.size() > 0))))
    {
      this.CQJ = true;
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
          if (WalletBalanceFetchUI.eGe())
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
          AppMethodBeat.i(190052);
          paramAnonymousDialogInterface.dismiss();
          WalletBalanceFetchUI.p(WalletBalanceFetchUI.this);
          AppMethodBeat.o(190052);
        }
      });
      AppMethodBeat.o(68625);
      return true;
    }
    AppMethodBeat.o(68625);
    return false;
  }
  
  private static boolean dMx()
  {
    AppMethodBeat.i(174433);
    com.tencent.mm.wallet_core.b.fVf();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qDk, true);
    com.tencent.mm.wallet_core.b.fVf();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qGF, false);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(174433);
      return true;
    }
    AppMethodBeat.o(174433);
    return false;
  }
  
  private void eFV()
  {
    AppMethodBeat.i(68612);
    if (this.CQi != null)
    {
      this.CQy = com.tencent.mm.wallet_core.ui.f.a(this.CQi.DmF, "100", 2, RoundingMode.HALF_UP);
      ae.i("MicroMsg.WalletBalanceFetchUI", "min charge fee: %s", new Object[] { Double.valueOf(this.CQy) });
    }
    AppMethodBeat.o(68612);
  }
  
  private void eFW()
  {
    AppMethodBeat.i(68615);
    if ((this.ymU > 0.0D) && (this.CQi != null))
    {
      this.jtd.setEnabled(true);
      AppMethodBeat.o(68615);
      return;
    }
    this.jtd.setEnabled(false);
    AppMethodBeat.o(68615);
  }
  
  private void eFX()
  {
    AppMethodBeat.i(68616);
    double d;
    StringBuilder localStringBuilder;
    if (this.CQC == 0)
    {
      this.ymU = bu.getDouble(this.CQk.getText(), 0.0D);
      d = this.ymU;
      s.eGW();
      if ((d != s.eGX().CRg.Dml) && (this.CQi != null))
      {
        d = this.ymU;
        s.eGW();
        if (d != s.eGX().CRg.Dml - this.CQi.field_full_fetch_charge_fee) {
          this.CQz = 0;
        }
      }
      localStringBuilder = new StringBuilder();
      d = this.ymU;
      s.eGW();
      if (d <= s.eGX().CRg.Dmj) {
        break label181;
      }
      this.CQr.setVisibility(8);
      this.CQq.setTextColor(getResources().getColor(2131099803));
      localStringBuilder.append(getString(2131764997));
    }
    for (;;)
    {
      this.CQq.setText(localStringBuilder.toString());
      AppMethodBeat.o(68616);
      return;
      label181:
      String str;
      if ((this.CQi != null) && (this.CQv != 0) && ((this.CQv != 1) || (this.CQi.field_fetch_charge_rate > 0.0D)) && ((this.CQv != 1) || (this.CQi.field_fetch_charge_rate <= 0.0D) || (this.CQw != 0)))
      {
        d = this.CQy;
        s.eGW();
        if (d < s.eGX().CRg.Dml) {}
      }
      else
      {
        this.CQr.setVisibility(0);
        this.CQq.setTextColor(this.CQF);
        s.eGW();
        str = s.eGX().CRg.Dmq;
        if (!bu.isNullOrNil(str)) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          ae.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          s.eGW();
          localStringBuilder.append(getString(2131764988, new Object[] { com.tencent.mm.wallet_core.ui.f.d(s.eGX().CRg.Dml, "CNY") }));
        }
      }
      if ((this.CQv == 1) && (this.CQi.field_fetch_charge_rate > 0.0D) && (this.CQw == 1) && ((this.ymU <= 0.0D) || (!this.CQk.aVz())))
      {
        this.CQr.setVisibility(0);
        this.CQq.setTextColor(this.CQF);
        s.eGW();
        str = s.eGX().CRg.Dmq;
        if (!bu.isNullOrNil(str)) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          ae.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          s.eGW();
          localStringBuilder.append(getString(2131764988, new Object[] { com.tencent.mm.wallet_core.ui.f.d(s.eGX().CRg.Dml, "CNY") }));
        }
      }
      if ((this.CQv == 1) && (this.CQi.field_fetch_charge_rate > 0.0D) && (this.CQw == 1))
      {
        this.CQr.setVisibility(8);
        this.CQq.setTextColor(this.CQF);
        d = this.ymU;
        s.eGW();
        if ((d == s.eGX().CRg.Dml - this.CQi.field_full_fetch_charge_fee) && (this.CQi.field_full_fetch_charge_fee > 0.0D))
        {
          if (!bu.isNullOrNil(this.CQi.DmE)) {
            localStringBuilder.append(String.format(this.CQi.DmE, new Object[] { com.tencent.mm.wallet_core.ui.f.d(this.CQi.field_full_fetch_charge_fee, "CNY") }));
          } else {
            localStringBuilder.append(getString(2131764970, new Object[] { com.tencent.mm.wallet_core.ui.f.d(this.CQi.field_full_fetch_charge_fee, "CNY"), this.CQi.field_fetch_charge_rate * 100.0D + "%" }));
          }
        }
        else if (!bu.isNullOrNil(this.CQi.DmE)) {
          localStringBuilder.append(String.format(this.CQi.DmE, new Object[] { com.tencent.mm.wallet_core.ui.f.d(z(this.ymU), "CNY") }));
        } else {
          localStringBuilder.append(getString(2131764970, new Object[] { com.tencent.mm.wallet_core.ui.f.d(z(this.ymU), "CNY"), this.CQi.field_fetch_charge_rate * 100.0D + "%" }));
        }
      }
    }
  }
  
  private void eFY()
  {
    AppMethodBeat.i(190061);
    s.eGW();
    final Bankcard localBankcard = s.eGX().CRg;
    if ((this.CQi != null) && (!bu.isNullOrNil(localBankcard.field_prompt_info_prompt_text)))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
      if (!bu.isNullOrNil(localBankcard.field_prompt_info_jump_text)) {
        localSpannableStringBuilder.append(localBankcard.field_prompt_info_jump_text);
      }
      localSpannableStringBuilder.setSpan(new q(new q.a()
      {
        public final void dN(View paramAnonymousView)
        {
          AppMethodBeat.i(190048);
          if (!bu.isNullOrNil(localBankcard.field_prompt_info_jump_url))
          {
            com.tencent.mm.wallet_core.ui.f.aY(WalletBalanceFetchUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
            com.tencent.mm.plugin.report.service.g.yxI.f(20216, new Object[] { Integer.valueOf(4), localBankcard.field_prompt_info_jump_url });
          }
          AppMethodBeat.o(190048);
        }
      }), localBankcard.field_prompt_info_prompt_text.length(), localSpannableStringBuilder.length(), 18);
      this.CQs.setText(localSpannableStringBuilder);
      this.CQs.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(getContext()));
      this.CQs.setVisibility(0);
      this.CQF = getContext().getResources().getColor(2131099732);
      this.CQq.setTextColor(this.CQF);
      AppMethodBeat.o(190061);
      return;
    }
    this.CQs.setText("");
    this.CQs.setVisibility(8);
    this.CQF = getContext().getResources().getColor(2131099734);
    this.CQq.setTextColor(this.CQF);
    AppMethodBeat.o(190061);
  }
  
  private void eFZ()
  {
    AppMethodBeat.i(68620);
    fetchData();
    updateView();
    eGc();
    AppMethodBeat.o(68620);
  }
  
  private void eGa()
  {
    this.CQH = false;
    this.CQI = false;
    this.CQJ = false;
    this.CQK = false;
  }
  
  private void eGb()
  {
    AppMethodBeat.i(68628);
    Object localObject = com.tencent.mm.plugin.wallet_core.model.g.eII();
    if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bnS())
    {
      com.tencent.mm.ui.base.h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).wRu, getString(2131755906), true);
      AppMethodBeat.o(68628);
      return;
    }
    Bundle localBundle = new Bundle();
    PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
    localObject = localPayInfo;
    if (localPayInfo == null)
    {
      localObject = new PayInfo();
      ((PayInfo)localObject).dmw = this.dmw;
      ((PayInfo)localObject).dDH = 21;
    }
    if (localObject != null) {
      localBundle.putParcelable("key_pay_info", (Parcelable)localObject);
    }
    localBundle.putInt("key_scene", 21);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_is_bind_bankcard", true);
    localBundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.CNZ);
    localBundle.putBoolean("key_bind_show_change_card", true);
    if (g(this, localBundle))
    {
      AppMethodBeat.o(68628);
      return;
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, localBundle, null);
    AppMethodBeat.o(68628);
  }
  
  private void eGc()
  {
    AppMethodBeat.i(68630);
    if (this.CQv != 0)
    {
      ae.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.CQv);
      AppMethodBeat.o(68630);
      return;
    }
    com.tencent.mm.kernel.g.ajS();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPk, Boolean.FALSE)).booleanValue();
    s.eGW();
    com.tencent.mm.plugin.wallet_core.model.b localb = s.eGX().DsC;
    if ((localb != null) && (!bool))
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131765687, new Object[] { com.tencent.mm.wallet_core.ui.f.D(localb.yon) }), getString(2131765688), getString(2131765291), getString(2131765689), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68587);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.g.yxI.f(16398, new Object[] { WalletBalanceFetchUI.d(WalletBalanceFetchUI.this), Integer.valueOf(4), "", "" });
          AppMethodBeat.o(68587);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(190054);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", WalletBalanceFetchUI.this.getString(2131765260));
          localIntent.putExtra("showShare", false);
          com.tencent.mm.wallet_core.ui.f.an(WalletBalanceFetchUI.this.getContext(), localIntent);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.g.yxI.f(16398, new Object[] { WalletBalanceFetchUI.d(WalletBalanceFetchUI.this), Integer.valueOf(3), "", "" });
          AppMethodBeat.o(190054);
        }
      }, 2131101171);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPk, Boolean.TRUE);
    }
    AppMethodBeat.o(68630);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(68609);
    s.eGW();
    an localan = s.eGX();
    Object localObject2;
    Object localObject3;
    int i;
    Object localObject4;
    if (this.CQB)
    {
      ae.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      if ((this.CQh != null) && (this.CQh.size() > 0)) {
        ((ArrayList)localObject1).addAll(this.CQh);
      }
      this.CQh = localan.eKd();
      if ((this.CQh != null) && (this.CQh.size() > 0)) {
        ((ArrayList)localObject2).addAll(this.CQh);
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
        localObject1 = localan.a(this.CQh, null, false, true);
      }
      for (;;)
      {
        i = 0;
        if ((this.CQh != null) && (i < this.CQh.size()))
        {
          localObject2 = (Bankcard)this.CQh.get(i);
          if ((localObject1 != null) && (localObject2 != null) && (((Bankcard)localObject1).field_bindSerial.equals(((Bankcard)localObject2).field_bindSerial))) {
            this.tci = i;
          }
        }
        else
        {
          this.CQi = ((Bankcard)localObject1);
          this.CQB = false;
          localObject3 = com.tencent.mm.plugin.report.service.g.yxI;
          localObject4 = this.kbf;
          if (this.CQi == null) {
            break label587;
          }
          localObject1 = this.CQi.field_bankcardType;
          label373:
          if (this.CQi == null) {
            break label594;
          }
          localObject2 = this.CQi.field_bindSerial;
          ((com.tencent.mm.plugin.report.service.g)localObject3).f(16398, new Object[] { localObject4, Integer.valueOf(1), localObject1, localObject2 });
          if (localan.DsC == null) {
            break label602;
          }
          this.CQv = localan.DsC.CQv;
          this.CQw = localan.DsC.CQw;
          eFV();
          this.CQx = localan.DsC.CQx;
        }
        for (;;)
        {
          this.CQC = 0;
          this.CQD = 0;
          ae.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.CQv + " is_cal_charge:" + this.CQw + " min_charge_fee:" + this.CQy + " is_full_fetch_direct:" + this.CQx);
          AppMethodBeat.o(68609);
          return;
          i += 1;
          break;
          this.CQh = localan.eKd();
          this.CQi = localan.a(this.CQh, null, false, true);
          break label347;
          localObject1 = "";
          break label373;
          localObject2 = "";
          break label389;
          ae.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
      }
    }
  }
  
  private boolean g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(68631);
    com.tencent.mm.wallet_core.b.fVf();
    if (com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qGD, false))
    {
      com.tencent.mm.sdk.b.a.IvT.b(this.wNu);
      ae.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:true");
      ab.kI(6, paramBundle.getInt("key_bind_scene"));
      z.agV(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(68631);
      return true;
    }
    ae.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:false");
    AppMethodBeat.o(68631);
    return false;
  }
  
  private void updateView()
  {
    AppMethodBeat.i(68613);
    final ImageView localImageView;
    Object localObject;
    if (this.CQk.getTitleTv() != null)
    {
      this.CQk.getTitleTv().setText(String.format(getString(2131762486), new Object[] { ah.fWc() }));
      localImageView = (ImageView)this.CQl.findViewById(2131297166);
      if (this.CQi == null) {
        break label486;
      }
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.i(this, this.CQi.field_bankcardType, this.CQi.eIx());
      if (locale != null) {
        localObject = locale.wFJ;
      }
      localImageView.setImageBitmap(null);
      if (!this.CQi.eIy()) {
        break label391;
      }
      localImageView.setBackgroundResource(2131234612);
      label121:
      ((TextView)this.CQl.findViewById(2131297091)).setText(getString(2131765024, new Object[] { this.CQi.field_bankName, this.CQi.field_bankcardTail }));
      ((TextView)this.CQl.findViewById(2131297091)).setVisibility(0);
      if (!bu.isNullOrNil(this.CQi.field_fetchArriveTimeWording))
      {
        ((TextView)this.CQl.findViewById(2131300742)).setText(this.CQi.field_fetchArriveTimeWording);
        ((TextView)this.CQl.findViewById(2131300742)).setVisibility(0);
        if (this.CQi.field_is_hightlight_pre_arrive_time_wording != 1) {
          break label457;
        }
        ((TextView)this.CQl.findViewById(2131300742)).setTextColor(getResources().getColor(2131099777));
      }
      label275:
      this.CQp.setText("");
      this.CQp.setVisibility(8);
      label294:
      s.eGW();
      localObject = s.eGX().CRg.Dmp;
      if (bu.isNullOrNil((String)localObject)) {
        break label577;
      }
      this.CQo.setVisibility(0);
      this.CQo.setText((CharSequence)localObject);
      label331:
      if (this.CQC != 1) {
        break label589;
      }
      this.CQt.setVisibility(8);
      this.CQu.setVisibility(0);
    }
    for (;;)
    {
      eFW();
      eFX();
      eFY();
      cMz();
      AppMethodBeat.o(68613);
      return;
      ae.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
      break;
      label391:
      localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68602);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68601);
              if ((WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null) && (WalletBalanceFetchUI.23.this.CQV != null) && (WalletBalanceFetchUI.23.this.CQV.getTag() != null) && (WalletBalanceFetchUI.23.this.CQV.getTag().equals(WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial))) {
                WalletBalanceFetchUI.23.this.CQV.setImageBitmap(paramAnonymousBitmap);
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
      localImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, getResources().getDimensionPixelOffset(2131167003), getResources().getDimensionPixelOffset(2131167003), true, false));
      break label121;
      label457:
      ((TextView)this.CQl.findViewById(2131300742)).setTextColor(getResources().getColor(2131100490));
      break label275;
      label486:
      localImageView.setImageBitmap(null);
      ((TextView)this.CQl.findViewById(2131297091)).setText(this.CQj);
      ((TextView)this.CQl.findViewById(2131300742)).setText("");
      ((TextView)this.CQl.findViewById(2131300742)).setVisibility(8);
      ((ImageView)this.CQl.findViewById(2131297166)).setImageBitmap(null);
      this.CQp.setVisibility(8);
      break label294;
      label577:
      this.CQo.setVisibility(8);
      break label331;
      label589:
      this.CQt.setVisibility(0);
      this.CQu.setVisibility(8);
    }
  }
  
  private double z(double paramDouble)
  {
    AppMethodBeat.i(68617);
    s.eGW();
    an localan = s.eGX();
    paramDouble = Math.max(com.tencent.mm.wallet_core.ui.f.b(paramDouble - localan.DsC.yon, this.CQi.field_fetch_charge_rate, RoundingMode.HALF_UP), this.CQy);
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
    this.iFK = findViewById(2131299904);
    this.CQl = ((LinearLayout)findViewById(2131297090));
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68591);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        WalletBalanceFetchUI.this.hideTenpayKB();
        s.eGW();
        final ArrayList localArrayList = s.eGX().eKd();
        s.eGW();
        Object localObject2 = s.eGX().DsC;
        localObject1 = "";
        if (localObject2 != null)
        {
          paramAnonymousView = ((com.tencent.mm.plugin.wallet_core.model.b)localObject2).DlQ;
          localObject1 = ((com.tencent.mm.plugin.wallet_core.model.b)localObject2).DlP;
        }
        for (;;)
        {
          if (localArrayList == null) {
            ae.i("MicroMsg.WalletBalanceFetchUI", "debit is null");
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
                ae.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[] { WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_desc });
                localg = com.tencent.mm.plugin.report.service.g.yxI;
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
                  WalletBalanceFetchUI.eGd();
                  AppMethodBeat.o(68590);
                  return;
                  paramAnonymous2MenuItem = "";
                  break;
                }
              }
              ae.i("MicroMsg.WalletBalanceFetchUI", "add new card");
              WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
              com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
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
            ae.i("MicroMsg.WalletBalanceFetchUI", "mmBottomSheet != null && mmBottomSheet.isShowing(),dont show bottomSheet");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68591);
            return;
          }
          ((WalletBalanceFetchUI)localObject2).sheet = new com.tencent.mm.ui.widget.a.e((Context)localObject3, 2, true);
          ((WalletBalanceFetchUI)localObject2).sheet.LfS = new WalletBalanceFetchUI.13((WalletBalanceFetchUI)localObject2, localArrayList, (Context)localObject3);
          ((WalletBalanceFetchUI)localObject2).sheet.LfT = local1;
          ((WalletBalanceFetchUI)localObject2).sheet.Ltv = true;
          localObject3 = LayoutInflater.from((Context)localObject3).inflate(2131495898, null);
          if (!bu.isNullOrNil((String)localObject1)) {
            ((TextView)((View)localObject3).findViewById(2131297202)).setText((CharSequence)localObject1);
          }
          if (!bu.isNullOrNil(paramAnonymousView)) {
            ((TextView)((View)localObject3).findViewById(2131297201)).setText(paramAnonymousView);
          }
          ((WalletBalanceFetchUI)localObject2).sheet.P((View)localObject3, false);
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
            ((WalletBalanceFetchUI)localObject2).sheet.iNL = k;
            ((WalletBalanceFetchUI)localObject2).sheet.cPF();
            break;
            label398:
            break label367;
          }
          paramAnonymousView = "";
        }
      }
    };
    this.CQm = findViewById(2131297090);
    this.CQm.setOnClickListener((View.OnClickListener)localObject);
    this.CQl.setOnClickListener((View.OnClickListener)localObject);
    this.CQk = ((WalletFormView)findViewById(2131297093));
    setEditFocusListener(this.CQk, 2, false);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.CQk);
    this.CQk.setOnInputValidChangeListener(this);
    this.jtd = ((Button)findViewById(2131302852));
    this.jtd.setOnClickListener(new w()
    {
      public final void ccc()
      {
        AppMethodBeat.i(68596);
        WalletBalanceFetchUI.g(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68596);
      }
    });
    this.jtd.setEnabled(false);
    this.CQn = ((TextView)findViewById(2131306652));
    this.CQo = ((TextView)findViewById(2131297095));
    this.CQp = ((TextView)findViewById(2131297094));
    this.CQq = ((TextView)findViewById(2131299902));
    this.CQr = ((TextView)findViewById(2131299900));
    this.CQs = ((TextView)findViewById(2131308104));
    this.CQt = ((ViewGroup)findViewById(2131299901));
    this.CQu = ((ViewGroup)findViewById(2131299903));
    this.CQr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68597);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletBalanceFetchUI.h(WalletBalanceFetchUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68597);
      }
    });
    this.CQk.a(new TextWatcher()
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
          WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, bu.getDouble(paramAnonymousEditable.toString(), 0.0D));
          WalletBalanceFetchUI.j(WalletBalanceFetchUI.this);
          WalletBalanceFetchUI.eGd();
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
    localObject = new yo();
    ((yo)localObject).dNR.scene = "3";
    ((yo)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68600);
        if (!bu.isNullOrNil(this.pmv.dNS.dNT))
        {
          com.tencent.mm.wallet_core.ui.f.a(WalletBalanceFetchUI.n(WalletBalanceFetchUI.this), this.pmv.dNS.dNT, this.pmv.dNS.content, this.pmv.dNS.url);
          AppMethodBeat.o(68600);
          return;
        }
        ae.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
        AppMethodBeat.o(68600);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
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
        paramInt2 = this.tci;
        this.tci = paramInt1;
        ae.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is ".concat(String.valueOf(paramInt1)));
        if ((this.CQh == null) || (paramInt1 < 0) || (paramInt1 >= this.CQh.size())) {
          if ((this.CQh == null) || (paramInt1 < 0) || (paramInt1 > this.CQh.size()))
          {
            this.CQi = null;
            eGb();
          }
        }
        for (;;)
        {
          updateView();
          AppMethodBeat.o(68622);
          return;
          this.tci = paramInt2;
          break;
          this.CQi = ((Bankcard)this.CQh.get(paramInt1));
        }
      }
      ae.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
      AppMethodBeat.o(68622);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(68622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68607);
    this.kbf = UUID.randomUUID().toString();
    super.onCreate(paramBundle);
    aU(getIntent());
    fetchData();
    this.CQj = getString(2131765025);
    initView();
    updateView();
    ab.kI(4, 0);
    AppMethodBeat.o(68607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68608);
    ar.ay(this.CQG);
    super.onDestroy();
    AppMethodBeat.o(68608);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(68621);
    this.CQk.ht(null);
    AppMethodBeat.o(68621);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68626);
    eGa();
    aU(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(68626);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68611);
    eGa();
    super.onResume();
    AppMethodBeat.o(68611);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(68619);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof d))
      {
        paramString = (d)paramn;
        this.CQH = false;
        if (!this.CQK) {
          this.CQI = false;
        }
        this.CQJ = false;
        this.CQK = false;
        boolean bool;
        if ("1".equals(paramString.dOi))
        {
          ae.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
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
          if ("2".equals(paramString.dOi))
          {
            ae.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.dOj, paramString.dOm, paramString.dOk, paramString.dOl, isTransparent(), null);
          }
          else
          {
            ae.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + paramString.dOi);
            bool = false;
          }
        }
        if (paramString.COi) {
          if (paramString.COj != null)
          {
            ae.i("MicroMsg.WalletBalanceFetchUI", "debugIdentifyInfoCompleteDialog() show");
            Object localObject = paramString.COj.title;
            String str1 = paramString.COj.content;
            String str2 = paramString.COj.COl;
            paramn = paramString.COj.COm;
            ae.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog()");
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
          ae.i("MicroMsg.WalletBalanceFetchUI", "fetchScene.accountTipDialog == null");
          break;
        }
        label491:
        af.w(21, paramString.dwj, paramInt2);
        if (!b(paramString))
        {
          this.dmw = paramString.dwj;
          a(paramString);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68619);
      return false;
      if ((paramn instanceof ad))
      {
        paramString = (ad)paramn;
        eFZ();
        if (paramString.isJumpRemind())
        {
          paramn = paramString.getJumpRemind();
          paramn.a(this, new com.tencent.mm.wallet_core.c.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(190049);
              if (paramn.fVP()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(190049);
            }
            
            public final void onEnter() {}
            
            public final void onUrlCancel()
            {
              AppMethodBeat.i(190051);
              if (paramn.fVP()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(190051);
            }
            
            public final void onUrlOk()
            {
              AppMethodBeat.i(190050);
              if (paramn.fVP()) {
                WalletBalanceFetchUI.o(WalletBalanceFetchUI.this);
              }
              AppMethodBeat.o(190050);
            }
          });
          AppMethodBeat.o(68619);
          return true;
          if ((paramn instanceof d))
          {
            af.w(21, "", paramInt2);
            eGa();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI
 * JD-Core Version:    0.7.0.1
 */