package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.b.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class WalletBalanceFetchUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private String bMX = null;
  private final int eYf = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 270);
  private Button frP;
  private View ipf;
  private double nzU;
  private TextView qgA;
  private TextView qgB;
  private int qgC = 0;
  private int qgD = 0;
  private int qgE = 0;
  private double qgF = 0.0D;
  private int qgG = -1;
  private int qgH = 0;
  private DecimalFormat qgI = new DecimalFormat("0.00");
  private boolean qgJ = false;
  private boolean qgK = false;
  private boolean qgL = false;
  private boolean qgM = false;
  private boolean qgN = false;
  private ArrayList<Bankcard> qgr;
  private Bankcard qgs;
  private String qgt;
  private WalletFormView qgu;
  private LinearLayout qgv;
  private View qgw;
  private TextView qgx;
  private TextView qgy;
  private TextView qgz;
  
  private void Z(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false))) {}
    for (boolean bool = true;; bool = false)
    {
      this.qgJ = bool;
      if (this.qgJ)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
        PayInfo localPayInfo = (PayInfo)this.BX.get("key_pay_info");
        paramIntent = localPayInfo;
        if (localPayInfo == null)
        {
          paramIntent = new PayInfo();
          paramIntent.bMX = this.bMX;
          paramIntent.bUV = 21;
        }
        if (!com.tencent.mm.plugin.wallet.b.a.bUG()) {
          break;
        }
        a(new v(paramIntent.bMX), true, false);
      }
      return;
    }
    a(new com.tencent.mm.plugin.wallet_core.c.y(paramIntent.bMX, 4), true, false);
  }
  
  private void a(com.tencent.mm.plugin.wallet.balance.a.b paramb)
  {
    if (!bk.bl(this.bMX))
    {
      Object localObject = new PayInfo();
      ((PayInfo)localObject).bMX = this.bMX;
      ((PayInfo)localObject).bUV = 21;
      this.BX.putParcelable("key_pay_info", (Parcelable)localObject);
      localObject = new Orders();
      ((Orders)localObject).nCq = (paramb.nyN - paramb.nyC);
      ((Orders)localObject).qwx = (paramb.nyN - paramb.nyC);
      ((Orders)localObject).qwN.add(new Orders.Commodity());
      ((Orders)localObject).nyC = paramb.nyC;
      this.BX.putParcelable("key_orders", (Parcelable)localObject);
      this.BX.putParcelable("key_bankcard", this.qgs);
      if (cNj() == null)
      {
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, this.BX, null);
        return;
      }
      cNk().m(new Object[] { this.BX });
      return;
    }
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
  }
  
  private void aZ()
  {
    final ImageView localImageView;
    Object localObject;
    if (this.qgu.getTitleTv() != null)
    {
      this.qgu.getTitleTv().setText(String.format(getString(a.i.remittance_fee_tips), new Object[] { ab.cML() }));
      localImageView = (ImageView)this.qgv.findViewById(a.f.bankcard_logo_iv);
      if (this.qgs == null) {
        break label495;
      }
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.h(this, this.qgs.field_bankcardType, this.qgs.bUP());
      if (locale != null) {
        localObject = locale.mEi;
      }
      localImageView.setImageBitmap(null);
      if (!this.qgs.bUQ()) {
        break label404;
      }
      localImageView.setBackgroundResource(a.e.wallet_balance_manager_logo_small);
      label115:
      ((TextView)this.qgv.findViewById(a.f.balance_bankcard_tv)).setText(getString(a.i.wallet_balance_save_bankcard_tips, new Object[] { this.qgs.field_bankName, this.qgs.field_bankcardTail }));
      ((TextView)this.qgv.findViewById(a.f.balance_bankcard_tv)).setVisibility(0);
      if (!bk.bl(this.qgs.field_fetchArriveTimeWording))
      {
        ((TextView)this.qgv.findViewById(a.f.hint_1)).setText(this.qgs.field_fetchArriveTimeWording);
        ((TextView)this.qgv.findViewById(a.f.hint_1)).setVisibility(0);
        if (this.qgs.field_is_hightlight_pre_arrive_time_wording != 1) {
          break label470;
        }
        ((TextView)this.qgv.findViewById(a.f.hint_1)).setTextColor(Color.parseColor("#FA962A"));
      }
      label265:
      this.qgz.setText("");
      this.qgz.setVisibility(8);
      label284:
      p.bTK();
      localObject = p.bTL().qhj.qtE;
      if (bk.bl((String)localObject)) {
        break label586;
      }
      this.qgy.setVisibility(0);
      this.qgy.setText((CharSequence)localObject);
    }
    for (;;)
    {
      bTk();
      p.bTK();
      localObject = p.bTL().qzh;
      this.mController.removeAllOptionMenu();
      if ((localObject != null) && (((com.tencent.mm.plugin.wallet_core.model.b)localObject).qth != null) && (((com.tencent.mm.plugin.wallet_core.model.b)localObject).qth.qtj != null) && (((com.tencent.mm.plugin.wallet_core.model.b)localObject).qth.qtj.length > 0)) {
        addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new WalletBalanceFetchUI.18(this, (com.tencent.mm.plugin.wallet_core.model.b)localObject));
      }
      return;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
      break;
      label404:
      localObject = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      x.a(new x.a()
      {
        public final void l(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          ai.d(new WalletBalanceFetchUI.17.1(this, paramAnonymousBitmap));
        }
      });
      if ((localObject == null) || (localObject == null)) {
        break label115;
      }
      localImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject, getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false));
      break label115;
      label470:
      ((TextView)this.qgv.findViewById(a.f.hint_1)).setTextColor(Color.parseColor("#B2B2B2"));
      break label265;
      label495:
      localImageView.setImageBitmap(null);
      ((TextView)this.qgv.findViewById(a.f.balance_bankcard_tv)).setText(this.qgt);
      ((TextView)this.qgv.findViewById(a.f.hint_1)).setText("");
      ((TextView)this.qgv.findViewById(a.f.hint_1)).setVisibility(8);
      ((ImageView)this.qgv.findViewById(a.f.bankcard_logo_iv)).setImageBitmap(null);
      this.qgz.setVisibility(8);
      break label284;
      label586:
      this.qgy.setVisibility(8);
    }
  }
  
  private boolean b(com.tencent.mm.plugin.wallet.balance.a.b paramb)
  {
    boolean bool1;
    if (!this.qgK) {
      if (paramb.qfk)
      {
        this.qgK = true;
        h.a(this, false, paramb.qfl, "", getString(a.i.app_ok), getString(a.i.app_cancel), new WalletBalanceFetchUI.3(this, paramb), new WalletBalanceFetchUI.4(this));
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!this.qgL)
        {
          com.tencent.mm.plugin.wallet_core.model.b localb = paramb.qfm;
          if ((localb == null) || ((TextUtils.isEmpty(localb.qtd)) && ((localb.qte == null) || (localb.qte.size() <= 0)))) {
            break label235;
          }
          this.qgL = true;
          com.tencent.mm.plugin.wallet_core.ui.i.a(this, localb, false, new WalletBalanceFetchUI.5(this, paramb), new WalletBalanceFetchUI.6(this));
          bool2 = true;
        }
      }
      for (;;)
      {
        if ((!bool2) && (!this.qgM))
        {
          paramb = paramb.qfn;
          if ((paramb != null) && ((!TextUtils.isEmpty(paramb.qtd)) || ((paramb.qte != null) && (paramb.qte.size() > 0))))
          {
            this.qgM = true;
            com.tencent.mm.plugin.wallet_core.ui.i.a(this, paramb, true, new DialogInterface.OnClickListener()new WalletBalanceFetchUI.8
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                paramAnonymousDialogInterface.dismiss();
                paramAnonymousDialogInterface = "";
                if (WalletBalanceFetchUI.a(WalletBalanceFetchUI.this) != null) {
                  paramAnonymousDialogInterface = WalletBalanceFetchUI.a(WalletBalanceFetchUI.this).field_bankcardType;
                }
                WalletBalanceFetchUI.l(WalletBalanceFetchUI.this);
                WalletBalanceFetchUI.m(WalletBalanceFetchUI.this);
                WalletBalanceFetchUI.this.a(new com.tencent.mm.plugin.wallet.balance.a.b(WalletBalanceFetchUI.n(WalletBalanceFetchUI.this), "CNY", paramAnonymousDialogInterface, WalletBalanceFetchUI.o(WalletBalanceFetchUI.this)), true, true);
              }
            }, new WalletBalanceFetchUI.8(this));
            return true;
            bool1 = false;
            break;
            label235:
            bool2 = false;
            continue;
          }
          return false;
        }
      }
      return bool2;
      bool1 = false;
    }
  }
  
  private void bTk()
  {
    this.nzU = bk.getDouble(this.qgu.getText(), 0.0D);
    double d;
    StringBuilder localStringBuilder;
    if ((this.nzU > 0.0D) && (this.qgs != null))
    {
      this.frP.setEnabled(true);
      d = this.nzU;
      p.bTK();
      if ((d != p.bTL().qhj.qtA) && (this.qgs != null))
      {
        d = this.nzU;
        p.bTK();
        if (d != p.bTL().qhj.qtA - this.qgs.field_full_fetch_charge_fee) {
          this.qgH = 0;
        }
      }
      localStringBuilder = new StringBuilder();
      d = this.nzU;
      p.bTK();
      if (d <= p.bTL().qhj.qty) {
        break label200;
      }
      this.qgB.setVisibility(8);
      this.qgA.setTextColor(getResources().getColor(a.c.red));
      localStringBuilder.append(getString(a.i.wallet_balance_input_amount_exceed_balance_tips));
    }
    for (;;)
    {
      this.qgA.setText(localStringBuilder.toString());
      return;
      this.frP.setEnabled(false);
      break;
      label200:
      Object localObject;
      if ((this.qgs != null) && (this.qgC != 0) && ((this.qgC != 1) || (this.qgs.field_fetch_charge_rate > 0.0D)) && ((this.qgC != 1) || (this.qgs.field_fetch_charge_rate <= 0.0D) || (this.qgD != 0)))
      {
        d = this.qgF;
        p.bTK();
        if (d < p.bTL().qhj.qtA) {}
      }
      else
      {
        this.qgB.setVisibility(0);
        this.qgA.setTextColor(getResources().getColor(a.c.hint_text_color));
        p.bTK();
        localObject = p.bTL().qhj.qtF;
        if (!bk.bl((String)localObject)) {
          localStringBuilder.append((String)localObject);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          p.bTK();
          d = p.bTL().qhj.qtA;
          localStringBuilder.append(getString(a.i.wallet_balance_fetch_fetch_fee, new Object[] { com.tencent.mm.wallet_core.ui.e.d(d, "CNY") }));
        }
      }
      if ((this.qgC == 1) && (this.qgs.field_fetch_charge_rate > 0.0D) && (this.qgD == 1) && ((this.nzU <= 0.0D) || (!this.qgu.YL())))
      {
        this.qgB.setVisibility(0);
        this.qgA.setTextColor(getResources().getColor(a.c.hint_text_color));
        p.bTK();
        localObject = p.bTL().qhj.qtF;
        if (!bk.bl((String)localObject)) {
          localStringBuilder.append((String)localObject);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          p.bTK();
          d = p.bTL().qhj.qtA;
          localStringBuilder.append(getString(a.i.wallet_balance_fetch_fetch_fee, new Object[] { com.tencent.mm.wallet_core.ui.e.d(d, "CNY") }));
        }
      }
      if ((this.qgC == 1) && (this.qgs.field_fetch_charge_rate > 0.0D) && (this.qgD == 1))
      {
        this.qgB.setVisibility(8);
        this.qgA.setTextColor(getResources().getColor(a.c.hint_text_color));
        d = this.nzU;
        p.bTK();
        if ((d == p.bTL().qhj.qtA - this.qgs.field_full_fetch_charge_fee) && (this.qgs.field_full_fetch_charge_fee > 0.0D))
        {
          localStringBuilder.append(getString(a.i.wallet_balance_additional_deduction_fee_tips_1, new Object[] { com.tencent.mm.wallet_core.ui.e.d(this.qgs.field_full_fetch_charge_fee, "CNY"), this.qgs.field_fetch_charge_rate * 100.0D + "%" }));
        }
        else
        {
          int i = a.i.wallet_balance_additional_deduction_fee_tips_1;
          d = this.nzU;
          p.bTK();
          localObject = p.bTL();
          localStringBuilder.append(getString(i, new Object[] { com.tencent.mm.wallet_core.ui.e.d(Math.max(Math.round((d - ((ag)localObject).qzh.nyG) * this.qgs.field_fetch_charge_rate * 100.0D) / 100.0D, ((ag)localObject).qzh.qgF), "CNY"), this.qgs.field_fetch_charge_rate * 100.0D + "%" }));
        }
      }
    }
  }
  
  private void bTl()
  {
    this.qgK = false;
    this.qgL = false;
    this.qgM = false;
    this.qgN = false;
  }
  
  private void bTm()
  {
    Object localObject = com.tencent.mm.plugin.wallet_core.model.g.bUY();
    if (((com.tencent.mm.plugin.wallet_core.model.g)localObject).akH())
    {
      h.b(this, ((com.tencent.mm.plugin.wallet_core.model.g)localObject).mOd, getString(a.i.app_tip), true);
      return;
    }
    Bundle localBundle = new Bundle();
    PayInfo localPayInfo = (PayInfo)this.BX.get("key_pay_info");
    localObject = localPayInfo;
    if (localPayInfo == null)
    {
      localObject = new PayInfo();
      ((PayInfo)localObject).bMX = this.bMX;
      ((PayInfo)localObject).bUV = 21;
    }
    if (localObject != null) {
      localBundle.putParcelable("key_pay_info", (Parcelable)localObject);
    }
    localBundle.putInt("key_scene", 21);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_is_bind_bankcard", true);
    localBundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.qfi);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, localBundle, null);
  }
  
  private void bwc()
  {
    p.bTK();
    ag localag = p.bTL();
    Object localObject2;
    int i;
    if (this.qgJ)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      if ((this.qgr != null) && (this.qgr.size() > 0)) {
        ((ArrayList)localObject1).addAll(this.qgr);
      }
      this.qgr = localag.bWb();
      if ((this.qgr != null) && (this.qgr.size() > 0)) {
        ((ArrayList)localObject2).addAll(this.qgr);
      }
      if ((((ArrayList)localObject1).size() <= 0) || (((ArrayList)localObject2).size() <= 0)) {
        break label510;
      }
      ArrayList localArrayList = new ArrayList();
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        Bankcard localBankcard1 = (Bankcard)((ArrayList)localObject1).get(i);
        int j = 0;
        while (j < ((ArrayList)localObject2).size())
        {
          Bankcard localBankcard2 = (Bankcard)((ArrayList)localObject2).get(j);
          if ((localBankcard1 != null) && (localBankcard2 != null) && (localBankcard1.field_bindSerial.equals(localBankcard2.field_bindSerial))) {
            localArrayList.add(localBankcard2);
          }
          j += 1;
        }
        i += 1;
      }
      if (localArrayList.size() > 0) {
        ((ArrayList)localObject2).removeAll(localArrayList);
      }
      if (((ArrayList)localObject2).size() <= 0) {
        break label510;
      }
    }
    label340:
    label496:
    label510:
    for (Object localObject1 = (Bankcard)((ArrayList)localObject2).get(0);; localObject1 = null)
    {
      if (localObject1 == null) {
        localObject1 = localag.a(this.qgr, null, false, true);
      }
      for (;;)
      {
        i = 0;
        if ((this.qgr != null) && (i < this.qgr.size()))
        {
          localObject2 = (Bankcard)this.qgr.get(i);
          if ((localObject1 != null) && (localObject2 != null) && (((Bankcard)localObject1).field_bindSerial.equals(((Bankcard)localObject2).field_bindSerial))) {
            this.qgG = i;
          }
        }
        else
        {
          this.qgs = ((Bankcard)localObject1);
          this.qgJ = false;
          if (localag.qzh == null) {
            break label496;
          }
          this.qgC = localag.qzh.qgC;
          this.qgD = localag.qzh.qgD;
          this.qgF = localag.qzh.qgF;
          this.qgE = localag.qzh.qgE;
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.qgC + " is_cal_charge:" + this.qgD + " min_charge_fee:" + this.qgF + " is_full_fetch_direct:" + this.qgE);
          return;
          i += 1;
          break;
          this.qgr = localag.bWb();
          this.qgs = localag.a(this.qgr, null, false, true);
          break label340;
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
      }
    }
  }
  
  public final boolean aSk()
  {
    return false;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.balance.a.b))
      {
        paramString = (com.tencent.mm.plugin.wallet.balance.a.b)paramm;
        this.qgK = false;
        if (!this.qgN) {
          this.qgL = false;
        }
        this.qgM = false;
        this.qgN = false;
        if ("1".equals(paramString.cdl))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
          paramm = new Bundle();
          paramm.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
          paramm.putString("realname_verify_process_jump_plugin", "wallet");
          str = paramString.cdm;
          str = paramString.cdn;
          str = paramString.cdo;
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramm, null, 0);
          if (!bool) {
            break label215;
          }
        }
      }
    }
    label215:
    while (!(paramm instanceof com.tencent.mm.plugin.wallet.balance.a.b))
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              String str;
              boolean bool;
              return false;
              if ("2".equals(paramString.cdl))
              {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
                bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.cdm, paramString.cdp, paramString.cdn, paramString.cdo, false, null);
              }
              else
              {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + paramString.cdl);
                bool = false;
              }
            }
            aa.l(21, paramString.bOT, paramInt2);
          } while (b(paramString));
          this.bMX = paramString.bOT;
          a(paramString);
          return false;
        } while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.y));
        paramString = (com.tencent.mm.plugin.wallet_core.c.y)paramm;
      } while (!paramString.cMv());
      paramm = paramString.lQQ;
      paramm.a(this, new WalletBalanceFetchUI.2(this, paramm, paramString));
      return true;
    }
    aa.l(21, "", paramInt2);
    bTl();
    return false;
  }
  
  public final void gG(boolean paramBoolean)
  {
    this.qgu.eq(null);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_balance_fetch_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.wallet_balance_fetch_title);
    this.ipf = findViewById(a.f.fetch_root_view);
    this.qgv = ((LinearLayout)findViewById(a.f.balance_bankcard_layout));
    Object localObject = new WalletBalanceFetchUI.1(this);
    this.qgw = findViewById(a.f.balance_bankcard_layout);
    this.qgw.setOnClickListener((View.OnClickListener)localObject);
    this.qgv.setOnClickListener((View.OnClickListener)localObject);
    this.qgu = ((WalletFormView)findViewById(a.f.balance_fee));
    e(this.qgu, 2, false);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.qgu);
    this.qgu.setOnInputValidChangeListener(this);
    this.frP = ((Button)findViewById(a.f.next_btn));
    this.frP.setOnClickListener(new WalletBalanceFetchUI.12(this));
    this.frP.setEnabled(false);
    this.qgx = ((TextView)findViewById(a.f.wallet_balance_manager_banner));
    this.qgy = ((TextView)findViewById(a.f.balance_fetch_max_tv));
    this.qgz = ((TextView)findViewById(a.f.balance_fetch_arrive_time));
    this.qgA = ((TextView)findViewById(a.f.fetch_desc_tips_tv));
    this.qgB = ((TextView)findViewById(a.f.fetch_all_tv));
    this.qgB.setOnClickListener(new WalletBalanceFetchUI.13(this));
    this.qgu.a(new WalletBalanceFetchUI.14(this));
    this.lTH = new WalletBalanceFetchUI.15(this);
    localObject = new ti();
    ((ti)localObject).ccU.bso = "3";
    ((ti)localObject).bFJ = new WalletBalanceFetchUI.16(this, (ti)localObject);
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramInt1 = paramIntent.getIntExtra("key_select_index", -1);
        paramInt2 = this.qgG;
        this.qgG = paramInt1;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is " + paramInt1);
        if ((this.qgr == null) || (paramInt1 < 0) || (paramInt1 >= this.qgr.size())) {
          if ((this.qgr == null) || (paramInt1 < 0) || (paramInt1 > this.qgr.size()))
          {
            this.qgs = null;
            bTm();
          }
        }
        for (;;)
        {
          aZ();
          return;
          this.qgG = paramInt2;
          break;
          this.qgs = ((Bankcard)this.qgr.get(paramInt1));
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Z(getIntent());
    bwc();
    this.qgt = getString(a.i.wallet_balance_save_bind_new_card_to_fetch);
    initView();
    aZ();
    w.fT(4, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    bTl();
    Z(paramIntent);
  }
  
  public void onResume()
  {
    bTl();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI
 * JD-Core Version:    0.7.0.1
 */