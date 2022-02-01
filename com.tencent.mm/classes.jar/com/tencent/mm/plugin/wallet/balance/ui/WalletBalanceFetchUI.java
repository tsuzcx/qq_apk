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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.g.a.xo.b;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.d;
import com.tencent.mm.plugin.wallet.balance.model.d.a;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.b.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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
  private TextView AYA;
  private TextView AYB;
  private TextView AYC;
  private TextView AYD;
  private ViewGroup AYE;
  private ViewGroup AYF;
  private int AYG;
  private int AYH;
  private int AYI;
  private double AYJ;
  private int AYK;
  private DecimalFormat AYL;
  private boolean AYM;
  private int AYN;
  private int AYO;
  private com.tencent.mm.plugin.wallet.balance.model.b AYP;
  private Runnable AYQ;
  private boolean AYR;
  private boolean AYS;
  private boolean AYT;
  private boolean AYU;
  private ArrayList<Bankcard> AYt;
  private Bankcard AYu;
  private String AYv;
  private WalletFormView AYw;
  private LinearLayout AYx;
  private View AYy;
  private TextView AYz;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private String dac;
  private Button iXb;
  private View ijA;
  private String jDP;
  private int rUm;
  com.tencent.mm.ui.widget.a.e sheet;
  private com.tencent.mm.sdk.b.c<kj> vsr;
  private double wJu;
  
  public WalletBalanceFetchUI()
  {
    AppMethodBeat.i(68606);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 270);
    this.dac = null;
    this.AYG = 0;
    this.AYH = 0;
    this.AYI = 0;
    this.AYJ = 0.0D;
    this.rUm = -1;
    this.AYK = 0;
    this.AYL = new DecimalFormat("0.00");
    this.AYM = false;
    this.AYN = 0;
    this.AYO = 0;
    this.AYQ = new WalletBalanceFetchUI.1(this);
    this.AYR = false;
    this.AYS = false;
    this.AYT = false;
    this.AYU = false;
    this.vsr = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68606);
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
    localBundle.putString("reportSessionId", this.jDP);
    ac.i("MicroMsg.WalletBalanceFetchUI", "startWalletBalanceFetchUseCase totalFee：%s reportSessionId %s", new Object[] { com.tencent.mm.wallet_core.ui.e.b(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString(), this.jDP });
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWalletBalanceFetchUseCase(this, localBundle);
    AppMethodBeat.o(174434);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(68618);
    if (!bs.isNullOrNil(this.dac))
    {
      Object localObject = new PayInfo();
      ((PayInfo)localObject).dac = this.dac;
      ((PayInfo)localObject).dqL = 21;
      getInput().putParcelable("key_pay_info", (Parcelable)localObject);
      localObject = new Orders();
      ((Orders)localObject).daf = (paramd.wKU - paramd.wKK);
      ((Orders)localObject).BxA = (paramd.wKU - paramd.wKK);
      ((Orders)localObject).BxR.add(new Orders.Commodity());
      ((Orders)localObject).wKK = paramd.wKK;
      getInput().putString("key_fetch_cashier_encode_str", paramd.AWw);
      getInput().putParcelable("key_orders", (Parcelable)localObject);
      getInput().putParcelable("key_bankcard", this.AYu);
      getInput().putString("key_fetch_cashier_desc", paramd.AWt);
      getInput().putString("key_report_session_id", this.jDP);
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
    ac.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
    AppMethodBeat.o(68618);
  }
  
  private void aO(Intent paramIntent)
  {
    AppMethodBeat.i(68627);
    this.AYM = aP(paramIntent);
    if (this.AYM)
    {
      ac.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
      PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
      paramIntent = localPayInfo;
      if (localPayInfo == null)
      {
        paramIntent = new PayInfo();
        paramIntent.dac = this.dac;
        paramIntent.dqL = 21;
      }
      doSceneForceProgress(new aa(paramIntent.dac));
    }
    AppMethodBeat.o(68627);
  }
  
  private static boolean aP(Intent paramIntent)
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
    if (!this.AYR) {}
    for (boolean bool1 = c(paramd);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = false;
      }
      if ((!bool2) && (!this.AYS)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!this.AYT) {
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
    if (paramd.AWo)
    {
      this.AYR = true;
      com.tencent.mm.ui.base.h.a(this, false, paramd.AWp, "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68581);
          paramAnonymousDialogInterface.dismiss();
          if (!WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd))
          {
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, paramd.djr);
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
  
  private void cBW()
  {
    AppMethodBeat.i(68614);
    s.epp();
    final com.tencent.mm.plugin.wallet_core.model.b localb = s.epq().BAG;
    removeAllOptionMenu();
    if ((localb != null) && (localb.BtW != null) && (localb.BtW.BtY != null) && (localb.BtW.BtY.length > 0)) {
      addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68605);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(WalletBalanceFetchUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.ISu = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(68603);
              b.c[] arrayOfc = WalletBalanceFetchUI.23.this.AZg.BtW.BtY;
              int k = arrayOfc.length;
              int i = 0;
              int j = 0;
              if (i < k)
              {
                b.c localc = arrayOfc[i];
                if (!bs.isNullOrNil(localc.title))
                {
                  if (bs.isNullOrNil(localc.desc)) {
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
          paramAnonymousMenuItem.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68604);
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
              if ((WalletBalanceFetchUI.23.this.AZg.BtW.BtY != null) && (paramAnonymous2Int < WalletBalanceFetchUI.23.this.AZg.BtW.BtY.length))
              {
                paramAnonymous2MenuItem = WalletBalanceFetchUI.23.this.AZg.BtW.BtY[paramAnonymous2Int];
                ac.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.vjP), paramAnonymous2MenuItem.nWj });
                switch (paramAnonymous2MenuItem.vjP)
                {
                }
              }
              for (;;)
              {
                AppMethodBeat.o(68604);
                return;
                com.tencent.mm.wallet_core.ui.e.o(WalletBalanceFetchUI.this.getContext(), paramAnonymous2MenuItem.nWj, true);
                AppMethodBeat.o(68604);
                return;
                com.tencent.mm.wallet_core.ui.e.v(paramAnonymous2MenuItem.username, paramAnonymous2MenuItem.path, 0, 1000);
              }
            }
          };
          paramAnonymousMenuItem.cED();
          AppMethodBeat.o(68605);
          return true;
        }
      });
    }
    AppMethodBeat.o(68614);
  }
  
  private void cL()
  {
    AppMethodBeat.i(68613);
    final ImageView localImageView;
    Object localObject;
    if (this.AYw.getTitleTv() != null)
    {
      this.AYw.getTitleTv().setText(String.format(getString(2131762486), new Object[] { ah.fAw() }));
      localImageView = (ImageView)this.AYx.findViewById(2131297166);
      if (this.AYu == null) {
        break label481;
      }
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.i(this, this.AYu.field_bankcardType, this.AYu.eqQ());
      if (locale != null) {
        localObject = locale.vkI;
      }
      localImageView.setImageBitmap(null);
      if (!this.AYu.eqR()) {
        break label386;
      }
      localImageView.setBackgroundResource(2131234612);
      label121:
      ((TextView)this.AYx.findViewById(2131297091)).setText(getString(2131765024, new Object[] { this.AYu.field_bankName, this.AYu.field_bankcardTail }));
      ((TextView)this.AYx.findViewById(2131297091)).setVisibility(0);
      if (!bs.isNullOrNil(this.AYu.field_fetchArriveTimeWording))
      {
        ((TextView)this.AYx.findViewById(2131300742)).setText(this.AYu.field_fetchArriveTimeWording);
        ((TextView)this.AYx.findViewById(2131300742)).setVisibility(0);
        if (this.AYu.field_is_hightlight_pre_arrive_time_wording != 1) {
          break label452;
        }
        ((TextView)this.AYx.findViewById(2131300742)).setTextColor(getResources().getColor(2131099777));
      }
      label275:
      this.AYB.setText("");
      this.AYB.setVisibility(8);
      label294:
      s.epp();
      localObject = s.epq().AZp.Buu;
      if (bs.isNullOrNil((String)localObject)) {
        break label572;
      }
      this.AYA.setVisibility(0);
      this.AYA.setText((CharSequence)localObject);
      label331:
      if (this.AYN != 1) {
        break label584;
      }
      this.AYE.setVisibility(8);
      this.AYF.setVisibility(0);
    }
    for (;;)
    {
      eoq();
      eor();
      cBW();
      AppMethodBeat.o(68613);
      return;
      ac.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
      break;
      label386:
      localObject = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      com.tencent.mm.platformtools.u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68602);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68601);
              if ((WalletBalanceFetchUI.b(WalletBalanceFetchUI.this) != null) && (WalletBalanceFetchUI.22.this.AZe != null) && (WalletBalanceFetchUI.22.this.AZe.getTag() != null) && (WalletBalanceFetchUI.22.this.AZe.getTag().equals(WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_bindSerial))) {
                WalletBalanceFetchUI.22.this.AZe.setImageBitmap(paramAnonymousBitmap);
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
      label452:
      ((TextView)this.AYx.findViewById(2131300742)).setTextColor(getResources().getColor(2131100490));
      break label275;
      label481:
      localImageView.setImageBitmap(null);
      ((TextView)this.AYx.findViewById(2131297091)).setText(this.AYv);
      ((TextView)this.AYx.findViewById(2131300742)).setText("");
      ((TextView)this.AYx.findViewById(2131300742)).setVisibility(8);
      ((ImageView)this.AYx.findViewById(2131297166)).setImageBitmap(null);
      this.AYB.setVisibility(8);
      break label294;
      label572:
      this.AYA.setVisibility(8);
      break label331;
      label584:
      this.AYE.setVisibility(0);
      this.AYF.setVisibility(8);
    }
  }
  
  private boolean d(d paramd)
  {
    AppMethodBeat.i(68625);
    paramd = paramd.AWr;
    if ((paramd != null) && ((!TextUtils.isEmpty(paramd.BtS)) || ((paramd.BtT != null) && (paramd.BtT.size() > 0))))
    {
      this.AYT = true;
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
          if (WalletBalanceFetchUI.eoy())
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
  
  private void eop()
  {
    AppMethodBeat.i(68612);
    if (this.AYu != null)
    {
      this.AYJ = com.tencent.mm.wallet_core.ui.e.b(this.AYu.BuK, "100", RoundingMode.HALF_UP);
      ac.i("MicroMsg.WalletBalanceFetchUI", "min charge fee: %s", new Object[] { Double.valueOf(this.AYJ) });
    }
    AppMethodBeat.o(68612);
  }
  
  private void eoq()
  {
    AppMethodBeat.i(68615);
    if ((this.wJu > 0.0D) && (this.AYu != null))
    {
      this.iXb.setEnabled(true);
      AppMethodBeat.o(68615);
      return;
    }
    this.iXb.setEnabled(false);
    AppMethodBeat.o(68615);
  }
  
  private void eor()
  {
    AppMethodBeat.i(68616);
    double d;
    StringBuilder localStringBuilder;
    if (this.AYN == 0)
    {
      this.wJu = bs.getDouble(this.AYw.getText(), 0.0D);
      d = this.wJu;
      s.epp();
      if ((d != s.epq().AZp.Buq) && (this.AYu != null))
      {
        d = this.wJu;
        s.epp();
        if (d != s.epq().AZp.Buq - this.AYu.field_full_fetch_charge_fee) {
          this.AYK = 0;
        }
      }
      localStringBuilder = new StringBuilder();
      d = this.wJu;
      s.epp();
      if (d <= s.epq().AZp.Buo) {
        break label181;
      }
      this.AYD.setVisibility(8);
      this.AYC.setTextColor(getResources().getColor(2131099803));
      localStringBuilder.append(getString(2131764997));
    }
    for (;;)
    {
      this.AYC.setText(localStringBuilder.toString());
      AppMethodBeat.o(68616);
      return;
      label181:
      String str;
      if ((this.AYu != null) && (this.AYG != 0) && ((this.AYG != 1) || (this.AYu.field_fetch_charge_rate > 0.0D)) && ((this.AYG != 1) || (this.AYu.field_fetch_charge_rate <= 0.0D) || (this.AYH != 0)))
      {
        d = this.AYJ;
        s.epp();
        if (d < s.epq().AZp.Buq) {}
      }
      else
      {
        this.AYD.setVisibility(0);
        this.AYC.setTextColor(getResources().getColor(2131100490));
        s.epp();
        str = s.epq().AZp.Buv;
        if (!bs.isNullOrNil(str)) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          ac.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          s.epp();
          localStringBuilder.append(getString(2131764988, new Object[] { com.tencent.mm.wallet_core.ui.e.d(s.epq().AZp.Buq, "CNY") }));
        }
      }
      if ((this.AYG == 1) && (this.AYu.field_fetch_charge_rate > 0.0D) && (this.AYH == 1) && ((this.wJu <= 0.0D) || (!this.AYw.aRO())))
      {
        this.AYD.setVisibility(0);
        this.AYC.setTextColor(getResources().getColor(2131100490));
        s.epp();
        str = s.epq().AZp.Buv;
        if (!bs.isNullOrNil(str)) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          ac.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          s.epp();
          localStringBuilder.append(getString(2131764988, new Object[] { com.tencent.mm.wallet_core.ui.e.d(s.epq().AZp.Buq, "CNY") }));
        }
      }
      if ((this.AYG == 1) && (this.AYu.field_fetch_charge_rate > 0.0D) && (this.AYH == 1))
      {
        this.AYD.setVisibility(8);
        this.AYC.setTextColor(getResources().getColor(2131100490));
        d = this.wJu;
        s.epp();
        if ((d == s.epq().AZp.Buq - this.AYu.field_full_fetch_charge_fee) && (this.AYu.field_full_fetch_charge_fee > 0.0D))
        {
          if (!bs.isNullOrNil(this.AYu.BuJ)) {
            localStringBuilder.append(String.format(this.AYu.BuJ, new Object[] { com.tencent.mm.wallet_core.ui.e.d(this.AYu.field_full_fetch_charge_fee, "CNY") }));
          } else {
            localStringBuilder.append(getString(2131764970, new Object[] { com.tencent.mm.wallet_core.ui.e.d(this.AYu.field_full_fetch_charge_fee, "CNY"), this.AYu.field_fetch_charge_rate * 100.0D + "%" }));
          }
        }
        else if (!bs.isNullOrNil(this.AYu.BuJ)) {
          localStringBuilder.append(String.format(this.AYu.BuJ, new Object[] { com.tencent.mm.wallet_core.ui.e.d(z(this.wJu), "CNY") }));
        } else {
          localStringBuilder.append(getString(2131764970, new Object[] { com.tencent.mm.wallet_core.ui.e.d(z(this.wJu), "CNY"), this.AYu.field_fetch_charge_rate * 100.0D + "%" }));
        }
      }
    }
  }
  
  private void eos()
  {
    AppMethodBeat.i(68620);
    fetchData();
    cL();
    eov();
    AppMethodBeat.o(68620);
  }
  
  private void eot()
  {
    this.AYR = false;
    this.AYS = false;
    this.AYT = false;
    this.AYU = false;
  }
  
  private void eou()
  {
    AppMethodBeat.i(68628);
    Object localObject = com.tencent.mm.plugin.wallet_core.model.g.erb();
    if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).bjw())
    {
      com.tencent.mm.ui.base.h.c(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).vwp, getString(2131755906), true);
      AppMethodBeat.o(68628);
      return;
    }
    Bundle localBundle = new Bundle();
    PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
    localObject = localPayInfo;
    if (localPayInfo == null)
    {
      localObject = new PayInfo();
      ((PayInfo)localObject).dac = this.dac;
      ((PayInfo)localObject).dqL = 21;
    }
    if (localObject != null) {
      localBundle.putParcelable("key_pay_info", (Parcelable)localObject);
    }
    localBundle.putInt("key_scene", 21);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_is_bind_bankcard", true);
    localBundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.AWm);
    localBundle.putBoolean("key_bind_show_change_card", true);
    if (g(this, localBundle))
    {
      AppMethodBeat.o(68628);
      return;
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, localBundle, null);
    AppMethodBeat.o(68628);
  }
  
  private void eov()
  {
    AppMethodBeat.i(68630);
    if (this.AYG != 0)
    {
      ac.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.AYG);
      AppMethodBeat.o(68630);
      return;
    }
    com.tencent.mm.kernel.g.agS();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIu, Boolean.FALSE)).booleanValue();
    s.epp();
    com.tencent.mm.plugin.wallet_core.model.b localb = s.epq().BAG;
    if ((localb != null) && (!bool))
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131765687, new Object[] { com.tencent.mm.wallet_core.ui.e.D(localb.wKO) }), getString(2131765688), getString(2131765291), getString(2131765689), new WalletBalanceFetchUI.9(this), new WalletBalanceFetchUI.10(this), 2131101171);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIu, Boolean.TRUE);
    }
    AppMethodBeat.o(68630);
  }
  
  private static boolean eow()
  {
    AppMethodBeat.i(174433);
    com.tencent.mm.wallet_core.b.fzz();
    boolean bool1 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.a.b.a.pRO, true);
    com.tencent.mm.wallet_core.b.fzz();
    boolean bool2 = com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.a.b.a.pUT, false);
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
    s.epp();
    am localam = s.epq();
    Object localObject2;
    Object localObject3;
    int i;
    Object localObject4;
    if (this.AYM)
    {
      ac.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      if ((this.AYt != null) && (this.AYt.size() > 0)) {
        ((ArrayList)localObject1).addAll(this.AYt);
      }
      this.AYt = localam.esw();
      if ((this.AYt != null) && (this.AYt.size() > 0)) {
        ((ArrayList)localObject2).addAll(this.AYt);
      }
      if ((((ArrayList)localObject1).size() <= 0) || (((ArrayList)localObject2).size() <= 0)) {
        break label614;
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
        break label614;
      }
    }
    label346:
    label614:
    for (Object localObject1 = (Bankcard)((ArrayList)localObject2).get(0);; localObject1 = null)
    {
      if (localObject1 == null) {
        localObject1 = localam.a(this.AYt, null, false, true);
      }
      for (;;)
      {
        i = 0;
        if ((this.AYt != null) && (i < this.AYt.size()))
        {
          localObject2 = (Bankcard)this.AYt.get(i);
          if ((localObject1 != null) && (localObject2 != null) && (((Bankcard)localObject1).field_bindSerial.equals(((Bankcard)localObject2).field_bindSerial))) {
            this.rUm = i;
          }
        }
        else
        {
          this.AYu = ((Bankcard)localObject1);
          this.AYM = false;
          localObject3 = com.tencent.mm.plugin.report.service.h.wUl;
          localObject4 = this.jDP;
          if (this.AYu == null) {
            break label585;
          }
          localObject1 = this.AYu.field_bankcardType;
          label372:
          if (this.AYu == null) {
            break label592;
          }
          localObject2 = this.AYu.field_bindSerial;
          ((com.tencent.mm.plugin.report.service.h)localObject3).f(16398, new Object[] { localObject4, Integer.valueOf(1), localObject1, localObject2 });
          if (localam.BAG == null) {
            break label600;
          }
          this.AYG = localam.BAG.AYG;
          this.AYH = localam.BAG.AYH;
          eop();
          this.AYI = localam.BAG.AYI;
        }
        for (;;)
        {
          this.AYN = 0;
          this.AYO = 0;
          ac.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.AYG + " is_cal_charge:" + this.AYH + " min_charge_fee:" + this.AYJ + " is_full_fetch_direct:" + this.AYI);
          AppMethodBeat.o(68609);
          return;
          i += 1;
          break;
          this.AYt = localam.esw();
          this.AYu = localam.a(this.AYt, null, false, true);
          break label346;
          localObject1 = "";
          break label372;
          localObject2 = "";
          break label388;
          ac.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
      }
    }
  }
  
  private boolean g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(68631);
    com.tencent.mm.wallet_core.b.fzz();
    if (com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.a.b.a.pUR, false))
    {
      com.tencent.mm.sdk.b.a.GpY.b(this.vsr);
      ac.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:true");
      ab.km(6, paramBundle.getInt("key_bind_scene"));
      z.adM(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(68631);
      return true;
    }
    ac.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:false");
    AppMethodBeat.o(68631);
    return false;
  }
  
  private double z(double paramDouble)
  {
    AppMethodBeat.i(68617);
    s.epp();
    am localam = s.epq();
    paramDouble = Math.max(com.tencent.mm.wallet_core.ui.e.c(paramDouble - localam.BAG.wKO, this.AYu.field_fetch_charge_rate, RoundingMode.HALF_UP), this.AYJ);
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
    this.ijA = findViewById(2131299904);
    this.AYx = ((LinearLayout)findViewById(2131297090));
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int j = 0;
        AppMethodBeat.i(68591);
        WalletBalanceFetchUI.this.hideTenpayKB();
        s.epp();
        final ArrayList localArrayList = s.epq().esw();
        s.epp();
        Object localObject1 = s.epq().BAG;
        String str = "";
        if (localObject1 != null)
        {
          paramAnonymousView = ((com.tencent.mm.plugin.wallet_core.model.b)localObject1).BtV;
          str = ((com.tencent.mm.plugin.wallet_core.model.b)localObject1).BtU;
        }
        for (;;)
        {
          if (localArrayList == null)
          {
            ac.i("MicroMsg.WalletBalanceFetchUI", "debit is null");
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
                ac.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", new Object[] { WalletBalanceFetchUI.b(WalletBalanceFetchUI.this).field_desc });
                localh = com.tencent.mm.plugin.report.service.h.wUl;
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
                  WalletBalanceFetchUI.eox();
                  AppMethodBeat.o(68590);
                  return;
                  paramAnonymous2MenuItem = "";
                  break;
                }
              }
              ac.i("MicroMsg.WalletBalanceFetchUI", "add new card");
              WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
              com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
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
            ac.i("MicroMsg.WalletBalanceFetchUI", "mmBottomSheet != null && mmBottomSheet.isShowing(),dont show bottomSheet");
            AppMethodBeat.o(68591);
            return;
          }
          ((WalletBalanceFetchUI)localObject1).sheet = new com.tencent.mm.ui.widget.a.e((Context)localObject2, 2, true);
          ((WalletBalanceFetchUI)localObject1).sheet.ISu = new WalletBalanceFetchUI.11((WalletBalanceFetchUI)localObject1, localArrayList, (Context)localObject2);
          ((WalletBalanceFetchUI)localObject1).sheet.ISv = local1;
          ((WalletBalanceFetchUI)localObject1).sheet.JfJ = true;
          localObject2 = LayoutInflater.from((Context)localObject2).inflate(2131495898, null);
          if (!bs.isNullOrNil(str)) {
            ((TextView)((View)localObject2).findViewById(2131297202)).setText(str);
          }
          if (!bs.isNullOrNil(paramAnonymousView)) {
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
            ((WalletBalanceFetchUI)localObject1).sheet.irP = k;
            ((WalletBalanceFetchUI)localObject1).sheet.cED();
            AppMethodBeat.o(68591);
            return;
          }
          paramAnonymousView = "";
        }
      }
    };
    this.AYy = findViewById(2131297090);
    this.AYy.setOnClickListener((View.OnClickListener)localObject);
    this.AYx.setOnClickListener((View.OnClickListener)localObject);
    this.AYw = ((WalletFormView)findViewById(2131297093));
    setEditFocusListener(this.AYw, 2, false);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.AYw);
    this.AYw.setOnInputValidChangeListener(this);
    this.iXb = ((Button)findViewById(2131302852));
    this.iXb.setOnClickListener(new w()
    {
      public final void bWk()
      {
        AppMethodBeat.i(68596);
        WalletBalanceFetchUI.g(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68596);
      }
    });
    this.iXb.setEnabled(false);
    this.AYz = ((TextView)findViewById(2131306652));
    this.AYA = ((TextView)findViewById(2131297095));
    this.AYB = ((TextView)findViewById(2131297094));
    this.AYC = ((TextView)findViewById(2131299902));
    this.AYD = ((TextView)findViewById(2131299900));
    this.AYE = ((ViewGroup)findViewById(2131299901));
    this.AYF = ((ViewGroup)findViewById(2131299903));
    this.AYD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68597);
        WalletBalanceFetchUI.h(WalletBalanceFetchUI.this);
        AppMethodBeat.o(68597);
      }
    });
    this.AYw.a(new TextWatcher()
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
          WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, bs.getDouble(paramAnonymousEditable.toString(), 0.0D));
          WalletBalanceFetchUI.j(WalletBalanceFetchUI.this);
          WalletBalanceFetchUI.eox();
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
    localObject = new xo();
    ((xo)localObject).dAo.scene = "3";
    ((xo)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68600);
        if (!bs.isNullOrNil(this.oCu.dAp.dAq))
        {
          com.tencent.mm.wallet_core.ui.e.a(WalletBalanceFetchUI.n(WalletBalanceFetchUI.this), this.oCu.dAp.dAq, this.oCu.dAp.content, this.oCu.dAp.url);
          AppMethodBeat.o(68600);
          return;
        }
        ac.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
        AppMethodBeat.o(68600);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
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
        paramInt2 = this.rUm;
        this.rUm = paramInt1;
        ac.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is ".concat(String.valueOf(paramInt1)));
        if ((this.AYt == null) || (paramInt1 < 0) || (paramInt1 >= this.AYt.size())) {
          if ((this.AYt == null) || (paramInt1 < 0) || (paramInt1 > this.AYt.size()))
          {
            this.AYu = null;
            eou();
          }
        }
        for (;;)
        {
          cL();
          AppMethodBeat.o(68622);
          return;
          this.rUm = paramInt2;
          break;
          this.AYu = ((Bankcard)this.AYt.get(paramInt1));
        }
      }
      ac.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
      AppMethodBeat.o(68622);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(68622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68607);
    this.jDP = UUID.randomUUID().toString();
    super.onCreate(paramBundle);
    aO(getIntent());
    fetchData();
    this.AYv = getString(2131765025);
    initView();
    cL();
    ab.km(4, 0);
    AppMethodBeat.o(68607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68608);
    ap.aB(this.AYQ);
    super.onDestroy();
    AppMethodBeat.o(68608);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(68621);
    this.AYw.gX(null);
    AppMethodBeat.o(68621);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68626);
    eot();
    aO(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(68626);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68611);
    eot();
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
        this.AYR = false;
        if (!this.AYU) {
          this.AYS = false;
        }
        this.AYT = false;
        this.AYU = false;
        boolean bool;
        if ("1".equals(paramString.dAF))
        {
          ac.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
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
          if ("2".equals(paramString.dAF))
          {
            ac.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.dAG, paramString.dAJ, paramString.dAH, paramString.dAI, isTransparent(), null);
          }
          else
          {
            ac.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + paramString.dAF);
            bool = false;
          }
        }
        if (paramString.AWu) {
          if (paramString.AWv != null)
          {
            ac.i("MicroMsg.WalletBalanceFetchUI", "debugIdentifyInfoCompleteDialog() show");
            Object localObject = paramString.AWv.title;
            String str1 = paramString.AWv.content;
            String str2 = paramString.AWv.AWx;
            paramn = paramString.AWv.AWy;
            ac.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog()");
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
            break label485;
          }
          AppMethodBeat.o(68619);
          return false;
          ac.i("MicroMsg.WalletBalanceFetchUI", "fetchScene.accountTipDialog == null");
          break;
        }
        label485:
        af.x(21, paramString.djr, paramInt2);
        if (!b(paramString))
        {
          this.dac = paramString.djr;
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
        eos();
        if (paramString.isJumpRemind())
        {
          paramn = paramString.getJumpRemind();
          paramn.a(this, new com.tencent.mm.wallet_core.c.f()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(68578);
              if (paramn.fAj()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(68578);
            }
            
            public final void onEnter() {}
            
            public final void onUrlCancel()
            {
              AppMethodBeat.i(68580);
              if (paramn.fAj()) {
                WalletBalanceFetchUI.this.finish();
              }
              AppMethodBeat.o(68580);
            }
            
            public final void onUrlOk()
            {
              AppMethodBeat.i(68579);
              if (paramn.fAj()) {
                WalletBalanceFetchUI.o(WalletBalanceFetchUI.this);
              }
              AppMethodBeat.o(68579);
            }
          });
          AppMethodBeat.o(68619);
          return true;
          if ((paramn instanceof d))
          {
            af.x(21, "", paramInt2);
            eot();
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