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
import android.text.Editable;
import android.text.SpannableString;
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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.a.xd.b;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.d;
import com.tencent.mm.plugin.wallet.balance.model.d.a;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.b.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.v;
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
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private String dcE;
  private View hIZ;
  private Button iwY;
  com.tencent.mm.ui.widget.a.e sheet;
  private com.tencent.mm.sdk.b.c<kb> ujv;
  private double vzp;
  private String xWG;
  private boolean zGA;
  private int zGB;
  private int zGC;
  private com.tencent.mm.plugin.wallet.balance.model.b zGD;
  private Runnable zGE;
  private boolean zGF;
  private boolean zGG;
  private boolean zGH;
  private boolean zGI;
  private ArrayList<Bankcard> zGg;
  private Bankcard zGh;
  private String zGi;
  private WalletFormView zGj;
  private LinearLayout zGk;
  private View zGl;
  private TextView zGm;
  private TextView zGn;
  private TextView zGo;
  private TextView zGp;
  private TextView zGq;
  private ViewGroup zGr;
  private ViewGroup zGs;
  private int zGt;
  private int zGu;
  private int zGv;
  private double zGw;
  private int zGx;
  private int zGy;
  private DecimalFormat zGz;
  
  public WalletBalanceFetchUI()
  {
    AppMethodBeat.i(68606);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 270);
    this.dcE = null;
    this.zGt = 0;
    this.zGu = 0;
    this.zGv = 0;
    this.zGw = 0.0D;
    this.zGx = -1;
    this.zGy = 0;
    this.zGz = new DecimalFormat("0.00");
    this.zGA = false;
    this.zGB = 0;
    this.zGC = 0;
    this.zGE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68576);
        WalletBalanceFetchUI.a(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68576);
      }
    };
    this.zGF = false;
    this.zGG = false;
    this.zGH = false;
    this.zGI = false;
    this.ujv = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68606);
  }
  
  private double A(double paramDouble)
  {
    AppMethodBeat.i(68617);
    s.dZT();
    am localam = s.dZU();
    paramDouble = Math.max(com.tencent.mm.wallet_core.ui.e.c(paramDouble - localam.Ail.vAJ, this.zGh.field_fetch_charge_rate, RoundingMode.HALF_UP), this.zGw);
    AppMethodBeat.o(68617);
    return paramDouble;
  }
  
  private void a(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(174434);
    Bundle localBundle = new Bundle();
    localBundle.putInt("payScene", 21);
    localBundle.putString("totalFee", com.tencent.mm.wallet_core.ui.e.b(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localBundle.putString("feeType", paramString1);
    localBundle.putString("bankType", paramString2);
    localBundle.putString("bindSerial", paramString3);
    localBundle.putString("operation", String.valueOf(paramInt));
    localBundle.putString("reportSessionId", this.xWG);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "startWalletBalanceFetchUseCase totalFee：%s reportSessionId %s", new Object[] { com.tencent.mm.wallet_core.ui.e.b(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString(), this.xWG });
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWalletBalanceFetchUseCase(this, localBundle);
    AppMethodBeat.o(174434);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(68618);
    if (!bt.isNullOrNil(this.dcE))
    {
      Object localObject = new PayInfo();
      ((PayInfo)localObject).dcE = this.dcE;
      ((PayInfo)localObject).dtb = 21;
      getInput().putParcelable("key_pay_info", (Parcelable)localObject);
      localObject = new Orders();
      ((Orders)localObject).dcH = (paramd.vAP - paramd.vAF);
      ((Orders)localObject).Afg = (paramd.vAP - paramd.vAF);
      ((Orders)localObject).Afx.add(new Orders.Commodity());
      ((Orders)localObject).vAF = paramd.vAF;
      getInput().putString("key_fetch_cashier_encode_str", paramd.zEj);
      getInput().putParcelable("key_orders", (Parcelable)localObject);
      getInput().putParcelable("key_bankcard", this.zGh);
      getInput().putString("key_fetch_cashier_desc", paramd.zEg);
      getInput().putString("key_report_session_id", this.xWG);
      if (getProcess() == null)
      {
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, getInput(), null);
        AppMethodBeat.o(68618);
        return;
      }
      getNetController().q(new Object[] { getInput() });
      AppMethodBeat.o(68618);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
    AppMethodBeat.o(68618);
  }
  
  private void aM(Intent paramIntent)
  {
    AppMethodBeat.i(68627);
    this.zGA = aN(paramIntent);
    if (this.zGA)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
      PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
      paramIntent = localPayInfo;
      if (localPayInfo == null)
      {
        paramIntent = new PayInfo();
        paramIntent.dcE = this.dcE;
        paramIntent.dtb = 21;
      }
      doSceneForceProgress(new aa(paramIntent.dcE));
    }
    AppMethodBeat.o(68627);
  }
  
  private static boolean aN(Intent paramIntent)
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
    if (!this.zGF) {}
    for (boolean bool1 = c(paramd);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = false;
      }
      if ((!bool2) && (!this.zGG)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!this.zGH) {
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
    if (paramd.zEb)
    {
      this.zGF = true;
      com.tencent.mm.ui.base.h.a(this, false, paramd.zEc, "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68581);
          paramAnonymousDialogInterface.dismiss();
          if (!WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd))
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd.dlJ);
            WalletBalanceFetchUI.b(WalletBalanceFetchUI.this, paramd);
          }
          AppMethodBeat.o(68581);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68582);
          paramAnonymousDialogInterface.dismiss();
          WalletBalanceFetchUI.p(WalletBalanceFetchUI.this);
          AppMethodBeat.o(68582);
        }
      });
      AppMethodBeat.o(68624);
      return true;
    }
    AppMethodBeat.o(68624);
    return false;
  }
  
  private void cE()
  {
    AppMethodBeat.i(68613);
    final ImageView localImageView;
    Object localObject;
    if (this.zGj.getTitleTv() != null)
    {
      this.zGj.getTitleTv().setText(String.format(getString(2131762486), new Object[] { ah.fkg() }));
      localImageView = (ImageView)this.zGk.findViewById(2131297166);
      if (this.zGh == null) {
        break label482;
      }
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.zGh.field_bankcardType, this.zGh.ebu());
      if (locale != null) {
        localObject = locale.dct;
      }
      localImageView.setImageBitmap(null);
      if (!this.zGh.ebv()) {
        break label387;
      }
      localImageView.setBackgroundResource(2131234612);
      label121:
      ((TextView)this.zGk.findViewById(2131297091)).setText(getString(2131765024, new Object[] { this.zGh.field_bankName, this.zGh.field_bankcardTail }));
      ((TextView)this.zGk.findViewById(2131297091)).setVisibility(0);
      if (!bt.isNullOrNil(this.zGh.field_fetchArriveTimeWording))
      {
        ((TextView)this.zGk.findViewById(2131300742)).setText(this.zGh.field_fetchArriveTimeWording);
        ((TextView)this.zGk.findViewById(2131300742)).setVisibility(0);
        if (this.zGh.field_is_hightlight_pre_arrive_time_wording != 1) {
          break label453;
        }
        ((TextView)this.zGk.findViewById(2131300742)).setTextColor(getResources().getColor(2131099777));
      }
      label275:
      this.zGo.setText("");
      this.zGo.setVisibility(8);
      label294:
      s.dZT();
      localObject = s.dZU().zHd.Aca;
      if (bt.isNullOrNil((String)localObject)) {
        break label573;
      }
      this.zGn.setVisibility(0);
      this.zGn.setText((CharSequence)localObject);
      label331:
      if (this.zGB != 1) {
        break label585;
      }
      this.zGr.setVisibility(8);
      this.zGs.setVisibility(0);
    }
    for (;;)
    {
      dYU();
      dYV();
      cri();
      AppMethodBeat.o(68613);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
      break;
      label387:
      localObject = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      com.tencent.mm.platformtools.u.a(new u.a()
      {
        public final void l(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68602);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68601);
              if ((WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null) && (WalletBalanceFetchUI.22.this.zGS != null) && (WalletBalanceFetchUI.22.this.zGS.getTag() != null) && (WalletBalanceFetchUI.22.this.zGS.getTag().equals(WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial))) {
                WalletBalanceFetchUI.22.this.zGS.setImageBitmap(paramAnonymousBitmap);
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
      localImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, getResources().getDimensionPixelOffset(2131167003), getResources().getDimensionPixelOffset(2131167003), true, false));
      break label121;
      label453:
      ((TextView)this.zGk.findViewById(2131300742)).setTextColor(getResources().getColor(2131100490));
      break label275;
      label482:
      localImageView.setImageBitmap(null);
      ((TextView)this.zGk.findViewById(2131297091)).setText(this.zGi);
      ((TextView)this.zGk.findViewById(2131300742)).setText("");
      ((TextView)this.zGk.findViewById(2131300742)).setVisibility(8);
      ((ImageView)this.zGk.findViewById(2131297166)).setImageBitmap(null);
      this.zGo.setVisibility(8);
      break label294;
      label573:
      this.zGn.setVisibility(8);
      break label331;
      label585:
      this.zGr.setVisibility(0);
      this.zGs.setVisibility(8);
    }
  }
  
  private void cri()
  {
    AppMethodBeat.i(68614);
    s.dZT();
    final com.tencent.mm.plugin.wallet_core.model.b localb = s.dZU().Ail;
    removeAllOptionMenu();
    if ((localb != null) && (localb.AbC != null) && (localb.AbC.AbE != null) && (localb.AbC.AbE.length > 0)) {
      addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68605);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletBalanceFetchUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.HrX = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(68603);
              b.c[] arrayOfc = WalletBalanceFetchUI.23.this.zGU.AbC.AbE;
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
          paramAnonymousMenuItem.HrY = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68604);
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
              if ((WalletBalanceFetchUI.23.this.zGU.AbC.AbE != null) && (paramAnonymous2Int < WalletBalanceFetchUI.23.this.zGU.AbC.AbE.length))
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.23.this.zGU.AbC.AbE[paramAnonymous2Int];
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.uaQ), paramAnonymous2MenuItem.ntj });
                switch (paramAnonymous2MenuItem.uaQ)
                {
                }
              }
              for (;;)
              {
                AppMethodBeat.o(68604);
                return;
                com.tencent.mm.wallet_core.ui.e.p(WalletBalanceFetchUI.this.getContext(), paramAnonymous2MenuItem.ntj, true);
                AppMethodBeat.o(68604);
                return;
                com.tencent.mm.wallet_core.ui.e.v(paramAnonymous2MenuItem.username, paramAnonymous2MenuItem.path, 0, 1000);
              }
            }
          };
          paramAnonymousMenuItem.csG();
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
    paramd = paramd.zEe;
    if ((paramd != null) && ((!TextUtils.isEmpty(paramd.Aby)) || ((paramd.Abz != null) && (paramd.Abz.size() > 0))))
    {
      this.zGH = true;
      com.tencent.mm.plugin.wallet_core.ui.m.a(this, paramd, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68583);
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
          if (WalletBalanceFetchUI.dZc())
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, WalletBalanceFetchUI.s(WalletBalanceFetchUI.this), "1", paramAnonymousDialogInterface, str, WalletBalanceFetchUI.t(WalletBalanceFetchUI.this));
            AppMethodBeat.o(68583);
            return;
          }
          WalletBalanceFetchUI.this.doSceneProgress(new d(WalletBalanceFetchUI.s(WalletBalanceFetchUI.this), "CNY", paramAnonymousDialogInterface, WalletBalanceFetchUI.t(WalletBalanceFetchUI.this)));
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
      AppMethodBeat.o(68625);
      return true;
    }
    AppMethodBeat.o(68625);
    return false;
  }
  
  private void dYT()
  {
    AppMethodBeat.i(68612);
    if (this.zGh != null)
    {
      this.zGw = com.tencent.mm.wallet_core.ui.e.b(this.zGh.Acq, "100", RoundingMode.HALF_UP);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "min charge fee: %s", new Object[] { Double.valueOf(this.zGw) });
    }
    AppMethodBeat.o(68612);
  }
  
  private void dYU()
  {
    AppMethodBeat.i(68615);
    if ((this.vzp > 0.0D) && (this.zGh != null))
    {
      this.iwY.setEnabled(true);
      AppMethodBeat.o(68615);
      return;
    }
    this.iwY.setEnabled(false);
    AppMethodBeat.o(68615);
  }
  
  private void dYV()
  {
    AppMethodBeat.i(68616);
    double d;
    StringBuilder localStringBuilder;
    if (this.zGB == 0)
    {
      this.vzp = bt.getDouble(this.zGj.getText(), 0.0D);
      d = this.vzp;
      s.dZT();
      if ((d != s.dZU().zHd.AbW) && (this.zGh != null))
      {
        d = this.vzp;
        s.dZT();
        if (d != s.dZU().zHd.AbW - this.zGh.field_full_fetch_charge_fee) {
          this.zGy = 0;
        }
      }
      localStringBuilder = new StringBuilder();
      d = this.vzp;
      s.dZT();
      if (d <= s.dZU().zHd.AbU) {
        break label181;
      }
      this.zGq.setVisibility(8);
      this.zGp.setTextColor(getResources().getColor(2131099803));
      localStringBuilder.append(getString(2131764997));
    }
    for (;;)
    {
      this.zGp.setText(localStringBuilder.toString());
      AppMethodBeat.o(68616);
      return;
      label181:
      String str;
      if ((this.zGh != null) && (this.zGt != 0) && ((this.zGt != 1) || (this.zGh.field_fetch_charge_rate > 0.0D)) && ((this.zGt != 1) || (this.zGh.field_fetch_charge_rate <= 0.0D) || (this.zGu != 0)))
      {
        d = this.zGw;
        s.dZT();
        if (d < s.dZU().zHd.AbW) {}
      }
      else
      {
        this.zGq.setVisibility(0);
        this.zGp.setTextColor(getResources().getColor(2131100490));
        s.dZT();
        str = s.dZU().zHd.Acb;
        if (!bt.isNullOrNil(str)) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          s.dZT();
          localStringBuilder.append(getString(2131764988, new Object[] { com.tencent.mm.wallet_core.ui.e.d(s.dZU().zHd.AbW, "CNY") }));
        }
      }
      if ((this.zGt == 1) && (this.zGh.field_fetch_charge_rate > 0.0D) && (this.zGu == 1) && ((this.vzp <= 0.0D) || (!this.zGj.aKX())))
      {
        this.zGq.setVisibility(0);
        this.zGp.setTextColor(getResources().getColor(2131100490));
        s.dZT();
        str = s.dZU().zHd.Acb;
        if (!bt.isNullOrNil(str)) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          s.dZT();
          localStringBuilder.append(getString(2131764988, new Object[] { com.tencent.mm.wallet_core.ui.e.d(s.dZU().zHd.AbW, "CNY") }));
        }
      }
      if ((this.zGt == 1) && (this.zGh.field_fetch_charge_rate > 0.0D) && (this.zGu == 1))
      {
        this.zGq.setVisibility(8);
        this.zGp.setTextColor(getResources().getColor(2131100490));
        d = this.vzp;
        s.dZT();
        if ((d == s.dZU().zHd.AbW - this.zGh.field_full_fetch_charge_fee) && (this.zGh.field_full_fetch_charge_fee > 0.0D))
        {
          if (!bt.isNullOrNil(this.zGh.Acp)) {
            localStringBuilder.append(String.format(this.zGh.Acp, new Object[] { com.tencent.mm.wallet_core.ui.e.d(this.zGh.field_full_fetch_charge_fee, "CNY") }));
          } else {
            localStringBuilder.append(getString(2131764970, new Object[] { com.tencent.mm.wallet_core.ui.e.d(this.zGh.field_full_fetch_charge_fee, "CNY"), this.zGh.field_fetch_charge_rate * 100.0D + "%" }));
          }
        }
        else if (!bt.isNullOrNil(this.zGh.Acp)) {
          localStringBuilder.append(String.format(this.zGh.Acp, new Object[] { com.tencent.mm.wallet_core.ui.e.d(A(this.vzp), "CNY") }));
        } else {
          localStringBuilder.append(getString(2131764970, new Object[] { com.tencent.mm.wallet_core.ui.e.d(A(this.vzp), "CNY"), this.zGh.field_fetch_charge_rate * 100.0D + "%" }));
        }
      }
    }
  }
  
  private void dYW()
  {
    AppMethodBeat.i(68620);
    fetchData();
    cE();
    dYZ();
    AppMethodBeat.o(68620);
  }
  
  private void dYX()
  {
    this.zGF = false;
    this.zGG = false;
    this.zGH = false;
    this.zGI = false;
  }
  
  private void dYY()
  {
    AppMethodBeat.i(68628);
    Object localObject = com.tencent.mm.plugin.wallet_core.model.g.ebF();
    if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bcB())
    {
      com.tencent.mm.ui.base.h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).unt, getString(2131755906), true);
      AppMethodBeat.o(68628);
      return;
    }
    Bundle localBundle = new Bundle();
    PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
    localObject = localPayInfo;
    if (localPayInfo == null)
    {
      localObject = new PayInfo();
      ((PayInfo)localObject).dcE = this.dcE;
      ((PayInfo)localObject).dtb = 21;
    }
    if (localObject != null) {
      localBundle.putParcelable("key_pay_info", (Parcelable)localObject);
    }
    localBundle.putInt("key_scene", 21);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_is_bind_bankcard", true);
    localBundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.zDZ);
    localBundle.putBoolean("key_bind_show_change_card", true);
    if (g(this, localBundle))
    {
      AppMethodBeat.o(68628);
      return;
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, localBundle, null);
    AppMethodBeat.o(68628);
  }
  
  private void dYZ()
  {
    AppMethodBeat.i(68630);
    if (this.zGt != 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.zGt);
      AppMethodBeat.o(68630);
      return;
    }
    com.tencent.mm.kernel.g.afC();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkF, Boolean.FALSE)).booleanValue();
    s.dZT();
    com.tencent.mm.plugin.wallet_core.model.b localb = s.dZU().Ail;
    if ((localb != null) && (!bool))
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131765687, new Object[] { com.tencent.mm.wallet_core.ui.e.E(localb.vAJ) }), getString(2131765688), getString(2131765291), getString(2131765689), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68586);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.h.vKh.f(16398, new Object[] { WalletBalanceFetchUI.d(WalletBalanceFetchUI.this), Integer.valueOf(4), "", "" });
          AppMethodBeat.o(68586);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68587);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", WalletBalanceFetchUI.this.getString(2131765260));
          localIntent.putExtra("showShare", false);
          com.tencent.mm.wallet_core.ui.e.X(WalletBalanceFetchUI.this.getContext(), localIntent);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.h.vKh.f(16398, new Object[] { WalletBalanceFetchUI.d(WalletBalanceFetchUI.this), Integer.valueOf(3), "", "" });
          AppMethodBeat.o(68587);
        }
      }, 2131101171);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FkF, Boolean.TRUE);
    }
    AppMethodBeat.o(68630);
  }
  
  private static boolean dZa()
  {
    AppMethodBeat.i(174433);
    com.tencent.mm.wallet_core.b.fjk();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.a.b.a.pom, true);
    com.tencent.mm.wallet_core.b.fjk();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.a.b.a.prg, false);
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
    s.dZT();
    am localam = s.dZU();
    Object localObject2;
    Object localObject3;
    int i;
    Object localObject4;
    if (this.zGA)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      if ((this.zGg != null) && (this.zGg.size() > 0)) {
        ((ArrayList)localObject1).addAll(this.zGg);
      }
      this.zGg = localam.edb();
      if ((this.zGg != null) && (this.zGg.size() > 0)) {
        ((ArrayList)localObject2).addAll(this.zGg);
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
        localObject1 = localam.a(this.zGg, null, false, true);
      }
      for (;;)
      {
        i = 0;
        if ((this.zGg != null) && (i < this.zGg.size()))
        {
          localObject2 = (Bankcard)this.zGg.get(i);
          if ((localObject1 != null) && (localObject2 != null) && (((Bankcard)localObject1).field_bindSerial.equals(((Bankcard)localObject2).field_bindSerial))) {
            this.zGx = i;
          }
        }
        else
        {
          this.zGh = ((Bankcard)localObject1);
          this.zGA = false;
          localObject3 = com.tencent.mm.plugin.report.service.h.vKh;
          localObject4 = this.xWG;
          if (this.zGh == null) {
            break label587;
          }
          localObject1 = this.zGh.field_bankcardType;
          label373:
          if (this.zGh == null) {
            break label594;
          }
          localObject2 = this.zGh.field_bindSerial;
          ((com.tencent.mm.plugin.report.service.h)localObject3).f(16398, new Object[] { localObject4, Integer.valueOf(1), localObject1, localObject2 });
          if (localam.Ail == null) {
            break label602;
          }
          this.zGt = localam.Ail.zGt;
          this.zGu = localam.Ail.zGu;
          dYT();
          this.zGv = localam.Ail.zGv;
        }
        for (;;)
        {
          this.zGB = 0;
          this.zGC = 0;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.zGt + " is_cal_charge:" + this.zGu + " min_charge_fee:" + this.zGw + " is_full_fetch_direct:" + this.zGv);
          AppMethodBeat.o(68609);
          return;
          i += 1;
          break;
          this.zGg = localam.edb();
          this.zGh = localam.a(this.zGg, null, false, true);
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
    com.tencent.mm.wallet_core.b.fjk();
    if (com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.a.b.a.pre, false))
    {
      com.tencent.mm.sdk.b.a.ESL.b(this.ujv);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:true");
      com.tencent.mm.wallet_core.c.ab.jZ(6, paramBundle.getInt("key_bind_scene"));
      z.abt(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(68631);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:false");
    AppMethodBeat.o(68631);
    return false;
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
    this.hIZ = findViewById(2131299904);
    this.zGk = ((LinearLayout)findViewById(2131297090));
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int j = 0;
        AppMethodBeat.i(68591);
        WalletBalanceFetchUI.this.hideTenpayKB();
        s.dZT();
        final ArrayList localArrayList = s.dZU().edb();
        s.dZT();
        Object localObject1 = s.dZU().Ail;
        String str = "";
        if (localObject1 != null)
        {
          paramAnonymousView = ((com.tencent.mm.plugin.wallet_core.model.b)localObject1).AbB;
          str = ((com.tencent.mm.plugin.wallet_core.model.b)localObject1).AbA;
        }
        for (;;)
        {
          if (localArrayList == null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "debit is null");
            AppMethodBeat.o(68591);
            return;
          }
          localObject1 = WalletBalanceFetchUI.this;
          Object localObject2 = WalletBalanceFetchUI.this.getContext();
          Bankcard localBankcard = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this);
          n.d local1 = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68590);
              if (paramAnonymous2Int < localArrayList.size())
              {
                WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, (Bankcard)localArrayList.get(paramAnonymous2Int));
                WalletBalanceFetchUI.c(WalletBalanceFetchUI.this);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[] { WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_desc });
                localh = com.tencent.mm.plugin.report.service.h.vKh;
                str2 = WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
                if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null)
                {
                  paramAnonymous2MenuItem = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bankcardType;
                  if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) == null) {
                    break label207;
                  }
                }
                label207:
                for (str1 = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial;; str1 = "")
                {
                  localh.f(16398, new Object[] { str2, Integer.valueOf(2), paramAnonymous2MenuItem, str1 });
                  WalletBalanceFetchUI.f(WalletBalanceFetchUI.this);
                  WalletBalanceFetchUI.dZb();
                  AppMethodBeat.o(68590);
                  return;
                  paramAnonymous2MenuItem = "";
                  break;
                }
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "add new card");
              WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
              com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
              String str2 = WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
              if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null)
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bankcardType;
                label274:
                if (WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) == null) {
                  break label343;
                }
              }
              label343:
              for (String str1 = WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial;; str1 = "")
              {
                localh.f(16398, new Object[] { str2, Integer.valueOf(9), paramAnonymous2MenuItem, str1 });
                break;
                paramAnonymous2MenuItem = "";
                break label274;
              }
            }
          };
          if ((((WalletBalanceFetchUI)localObject1).sheet != null) && (((WalletBalanceFetchUI)localObject1).sheet.isShowing()))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "mmBottomSheet != null && mmBottomSheet.isShowing(),dont show bottomSheet");
            AppMethodBeat.o(68591);
            return;
          }
          ((WalletBalanceFetchUI)localObject1).sheet = new com.tencent.mm.ui.widget.a.e((Context)localObject2, 2, true);
          ((WalletBalanceFetchUI)localObject1).sheet.HrX = new WalletBalanceFetchUI.11((WalletBalanceFetchUI)localObject1, localArrayList, (Context)localObject2);
          ((WalletBalanceFetchUI)localObject1).sheet.HrY = local1;
          ((WalletBalanceFetchUI)localObject1).sheet.HFm = true;
          localObject2 = LayoutInflater.from((Context)localObject2).inflate(2131495898, null);
          if (!bt.isNullOrNil(str)) {
            ((TextView)((View)localObject2).findViewById(2131297202)).setText(str);
          }
          if (!bt.isNullOrNil(paramAnonymousView)) {
            ((TextView)((View)localObject2).findViewById(2131297201)).setText(paramAnonymousView);
          }
          ((WalletBalanceFetchUI)localObject1).sheet.J((View)localObject2, false);
          int i = localArrayList.size();
          int k;
          if (localBankcard != null)
          {
            k = i;
            if (j >= localArrayList.size()) {
              break label334;
            }
            if (!((Bankcard)localArrayList.get(j)).field_bindSerial.equals(localBankcard.field_bindSerial)) {
              break label358;
            }
            i = j;
          }
          label334:
          label358:
          for (;;)
          {
            j += 1;
            break;
            k = i;
            ((WalletBalanceFetchUI)localObject1).sheet.hRK = k;
            ((WalletBalanceFetchUI)localObject1).sheet.csG();
            AppMethodBeat.o(68591);
            return;
          }
          paramAnonymousView = "";
        }
      }
    };
    this.zGl = findViewById(2131297090);
    this.zGl.setOnClickListener((View.OnClickListener)localObject);
    this.zGk.setOnClickListener((View.OnClickListener)localObject);
    this.zGj = ((WalletFormView)findViewById(2131297093));
    setEditFocusListener(this.zGj, 2, false);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.zGj);
    this.zGj.setOnInputValidChangeListener(this);
    this.iwY = ((Button)findViewById(2131302852));
    this.iwY.setOnClickListener(new v()
    {
      public final void bOU()
      {
        AppMethodBeat.i(68596);
        WalletBalanceFetchUI.g(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68596);
      }
    });
    this.iwY.setEnabled(false);
    this.zGm = ((TextView)findViewById(2131306652));
    this.zGn = ((TextView)findViewById(2131297095));
    this.zGo = ((TextView)findViewById(2131297094));
    this.zGp = ((TextView)findViewById(2131299902));
    this.zGq = ((TextView)findViewById(2131299900));
    this.zGr = ((ViewGroup)findViewById(2131299901));
    this.zGs = ((ViewGroup)findViewById(2131299903));
    this.zGq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68597);
        WalletBalanceFetchUI.h(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68597);
      }
    });
    this.zGj.a(new TextWatcher()
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
          WalletBalanceFetchUI.dZb();
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
    localObject = new xd();
    ((xd)localObject).dCC.scene = "3";
    ((xd)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68600);
        if (!bt.isNullOrNil(this.nYZ.dCD.dCE))
        {
          com.tencent.mm.wallet_core.ui.e.a(WalletBalanceFetchUI.n(WalletBalanceFetchUI.this), this.nYZ.dCD.dCE, this.nYZ.dCD.content, this.nYZ.dCD.url);
          AppMethodBeat.o(68600);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
        AppMethodBeat.o(68600);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
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
        paramInt2 = this.zGx;
        this.zGx = paramInt1;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is ".concat(String.valueOf(paramInt1)));
        if ((this.zGg == null) || (paramInt1 < 0) || (paramInt1 >= this.zGg.size())) {
          if ((this.zGg == null) || (paramInt1 < 0) || (paramInt1 > this.zGg.size()))
          {
            this.zGh = null;
            dYY();
          }
        }
        for (;;)
        {
          cE();
          AppMethodBeat.o(68622);
          return;
          this.zGx = paramInt2;
          break;
          this.zGh = ((Bankcard)this.zGg.get(paramInt1));
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
    this.xWG = UUID.randomUUID().toString();
    super.onCreate(paramBundle);
    aM(getIntent());
    fetchData();
    this.zGi = getString(2131765025);
    initView();
    cE();
    com.tencent.mm.wallet_core.c.ab.jZ(4, 0);
    AppMethodBeat.o(68607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68608);
    aq.az(this.zGE);
    super.onDestroy();
    AppMethodBeat.o(68608);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(68621);
    this.zGj.gF(null);
    AppMethodBeat.o(68621);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68626);
    dYX();
    aM(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(68626);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68611);
    dYX();
    super.onResume();
    AppMethodBeat.o(68611);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(68619);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof d))
      {
        paramString = (d)paramn;
        this.zGF = false;
        if (!this.zGI) {
          this.zGG = false;
        }
        this.zGH = false;
        this.zGI = false;
        boolean bool;
        if ("1".equals(paramString.dCT))
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
          if ("2".equals(paramString.dCT))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.dCU, paramString.dCX, paramString.dCV, paramString.dCW, isTransparent(), null);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + paramString.dCT);
            bool = false;
          }
        }
        if (paramString.zEh) {
          if (paramString.zEi != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "debugIdentifyInfoCompleteDialog() show");
            Object localObject = paramString.zEi.title;
            String str1 = paramString.zEi.content;
            String str2 = paramString.zEi.zEk;
            paramn = paramString.zEi.zEl;
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
            ((Dialog)localObject).setOnCancelListener(new WalletBalanceFetchUI.13(this, (Dialog)localObject));
            localImageView.setOnClickListener(new WalletBalanceFetchUI.14(this, (Dialog)localObject));
            localButton.setOnClickListener(new WalletBalanceFetchUI.15(this, this, paramn, (Dialog)localObject));
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
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBalanceFetchUI", "fetchScene.accountTipDialog == null");
          break;
        }
        label491:
        af.v(21, paramString.dlJ, paramInt2);
        if (!b(paramString))
        {
          this.dcE = paramString.dlJ;
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
        dYW();
        if (paramString.isJumpRemind())
        {
          paramn = paramString.getJumpRemind();
          paramn.a(this, new com.tencent.mm.wallet_core.c.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(68578);
              if (paramn.fjU()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(68578);
            }
            
            public final void onEnter() {}
            
            public final void onUrlCancel()
            {
              AppMethodBeat.i(68580);
              if (paramn.fjU()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(68580);
            }
            
            public final void onUrlOk()
            {
              AppMethodBeat.i(68579);
              if (paramn.fjU()) {
                WalletBalanceFetchUI.o(WalletBalanceFetchUI.this);
              }
              AppMethodBeat.o(68579);
            }
          });
          AppMethodBeat.o(68619);
          return true;
          if ((paramn instanceof d))
          {
            af.v(21, "", paramInt2);
            dYX();
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