package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.a.d.a;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.c.a;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public class WalletBalanceFetchUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private String cnI;
  private Button gJr;
  private View iCk;
  private double qlk;
  private String smv;
  private ArrayList<Bankcard> tNG;
  private Bankcard tNH;
  private String tNI;
  private WalletFormView tNJ;
  private LinearLayout tNK;
  private View tNL;
  private TextView tNM;
  private TextView tNN;
  private TextView tNO;
  private TextView tNP;
  private TextView tNQ;
  private ViewGroup tNR;
  private ViewGroup tNS;
  private int tNT;
  private int tNU;
  private int tNV;
  private double tNW;
  private int tNX;
  private int tNY;
  private DecimalFormat tNZ;
  private boolean tOa;
  private int tOb;
  private int tOc;
  private com.tencent.mm.plugin.wallet.balance.a.b tOd;
  private Runnable tOe;
  private boolean tOf;
  private boolean tOg;
  private boolean tOh;
  private boolean tOi;
  
  public WalletBalanceFetchUI()
  {
    AppMethodBeat.i(45386);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 270);
    this.cnI = null;
    this.tNT = 0;
    this.tNU = 0;
    this.tNV = 0;
    this.tNW = 0.0D;
    this.tNX = -1;
    this.tNY = 0;
    this.tNZ = new DecimalFormat("0.00");
    this.tOa = false;
    this.tOb = 0;
    this.tOc = 0;
    this.tOe = new WalletBalanceFetchUI.1(this);
    this.tOf = false;
    this.tOg = false;
    this.tOh = false;
    this.tOi = false;
    AppMethodBeat.o(45386);
  }
  
  private double B(double paramDouble)
  {
    AppMethodBeat.i(45397);
    s.cRG();
    am localam = s.cRH();
    paramDouble = Math.max(com.tencent.mm.wallet_core.ui.e.c(paramDouble - localam.ulR.qjH, this.tNH.field_fetch_charge_rate, RoundingMode.HALF_UP), this.tNW);
    AppMethodBeat.o(45397);
    return paramDouble;
  }
  
  private void a(com.tencent.mm.plugin.wallet.balance.a.d paramd)
  {
    AppMethodBeat.i(45398);
    if (!bo.isNullOrNil(this.cnI))
    {
      Object localObject = new PayInfo();
      ((PayInfo)localObject).cnI = this.cnI;
      ((PayInfo)localObject).cCD = 21;
      getInput().putParcelable("key_pay_info", (Parcelable)localObject);
      localObject = new Orders();
      ((Orders)localObject).cnL = (paramd.qjN - paramd.qjD);
      ((Orders)localObject).uiV = (paramd.qjN - paramd.qjD);
      ((Orders)localObject).ujl.add(new Orders.Commodity());
      ((Orders)localObject).qjD = paramd.qjD;
      getInput().putString("key_fetch_cashier_encode_str", paramd.tMf);
      getInput().putParcelable("key_orders", (Parcelable)localObject);
      getInput().putParcelable("key_bankcard", this.tNH);
      getInput().putString("key_fetch_cashier_desc", paramd.tMc);
      getInput().putString("key_report_session_id", this.smv);
      if (getProcess() == null)
      {
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, getInput(), null);
        AppMethodBeat.o(45398);
        return;
      }
      getNetController().p(new Object[] { getInput() });
      AppMethodBeat.o(45398);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
    AppMethodBeat.o(45398);
  }
  
  private void at(Intent paramIntent)
  {
    AppMethodBeat.i(45409);
    this.tOa = au(paramIntent);
    if (this.tOa)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
      PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
      paramIntent = localPayInfo;
      if (localPayInfo == null)
      {
        paramIntent = new PayInfo();
        paramIntent.cnI = this.cnI;
        paramIntent.cCD = 21;
      }
      doSceneForceProgress(new y(paramIntent.cnI));
    }
    AppMethodBeat.o(45409);
  }
  
  private static boolean au(Intent paramIntent)
  {
    AppMethodBeat.i(45411);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false)))
    {
      AppMethodBeat.o(45411);
      return true;
    }
    AppMethodBeat.o(45411);
    return false;
  }
  
  private boolean b(com.tencent.mm.plugin.wallet.balance.a.d paramd)
  {
    boolean bool3 = false;
    AppMethodBeat.i(45403);
    if (!this.tOf) {}
    for (boolean bool1 = c(paramd);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = false;
      }
      if ((!bool2) && (!this.tOg)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!this.tOh) {
            bool2 = d(paramd);
          }
        }
        AppMethodBeat.o(45403);
        return bool2;
      }
    }
  }
  
  private void bJ()
  {
    AppMethodBeat.i(45393);
    ImageView localImageView;
    Object localObject;
    if (this.tNJ.getTitleTv() != null)
    {
      this.tNJ.getTitleTv().setText(String.format(getString(2131302580), new Object[] { ae.dSz() }));
      localImageView = (ImageView)this.tNK.findViewById(2131828940);
      if (this.tNH == null) {
        break label474;
      }
      localObject = "";
      com.tencent.mm.plugin.wallet_core.model.g localg = com.tencent.mm.plugin.wallet_core.d.b.h(this, this.tNH.field_bankcardType, this.tNH.cTe());
      if (localg != null) {
        localObject = localg.pek;
      }
      localImageView.setImageBitmap(null);
      if (!this.tNH.cTf()) {
        break label383;
      }
      localImageView.setBackgroundResource(2130840794);
      label121:
      ((TextView)this.tNK.findViewById(2131828941)).setText(getString(2131304840, new Object[] { this.tNH.field_bankName, this.tNH.field_bankcardTail }));
      ((TextView)this.tNK.findViewById(2131828941)).setVisibility(0);
      if (!bo.isNullOrNil(this.tNH.field_fetchArriveTimeWording))
      {
        ((TextView)this.tNK.findViewById(2131828942)).setText(this.tNH.field_fetchArriveTimeWording);
        ((TextView)this.tNK.findViewById(2131828942)).setVisibility(0);
        if (this.tNH.field_is_hightlight_pre_arrive_time_wording != 1) {
          break label449;
        }
        ((TextView)this.tNK.findViewById(2131828942)).setTextColor(Color.parseColor("#FA962A"));
      }
      label271:
      this.tNO.setText("");
      this.tNO.setVisibility(8);
      label290:
      s.cRG();
      localObject = s.cRH().tOD.ufS;
      if (bo.isNullOrNil((String)localObject)) {
        break label565;
      }
      this.tNN.setVisibility(0);
      this.tNN.setText((CharSequence)localObject);
      label327:
      if (this.tOb != 1) {
        break label577;
      }
      this.tNR.setVisibility(8);
      this.tNS.setVisibility(0);
    }
    for (;;)
    {
      cQW();
      cQX();
      cFq();
      AppMethodBeat.o(45393);
      return;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
      break;
      label383:
      localObject = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      x.a(new WalletBalanceFetchUI.21(this, localImageView));
      if ((localObject == null) || (localObject == null)) {
        break label121;
      }
      localImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, getResources().getDimensionPixelOffset(2131428824), getResources().getDimensionPixelOffset(2131428824), true, false));
      break label121;
      label449:
      ((TextView)this.tNK.findViewById(2131828942)).setTextColor(Color.parseColor("#B2B2B2"));
      break label271;
      label474:
      localImageView.setImageBitmap(null);
      ((TextView)this.tNK.findViewById(2131828941)).setText(this.tNI);
      ((TextView)this.tNK.findViewById(2131828942)).setText("");
      ((TextView)this.tNK.findViewById(2131828942)).setVisibility(8);
      ((ImageView)this.tNK.findViewById(2131828940)).setImageBitmap(null);
      this.tNO.setVisibility(8);
      break label290;
      label565:
      this.tNN.setVisibility(8);
      break label327;
      label577:
      this.tNR.setVisibility(0);
      this.tNS.setVisibility(8);
    }
  }
  
  private boolean c(com.tencent.mm.plugin.wallet.balance.a.d paramd)
  {
    AppMethodBeat.i(142278);
    if (paramd.tLX)
    {
      this.tOf = true;
      com.tencent.mm.ui.base.h.a(this, false, paramd.tLY, "", getString(2131297018), getString(2131296888), new WalletBalanceFetchUI.4(this, paramd), new WalletBalanceFetchUI.5(this));
      AppMethodBeat.o(142278);
      return true;
    }
    AppMethodBeat.o(142278);
    return false;
  }
  
  private void cFq()
  {
    AppMethodBeat.i(45394);
    s.cRG();
    com.tencent.mm.plugin.wallet_core.model.c localc = s.cRH().ulR;
    removeAllOptionMenu();
    if ((localc != null) && (localc.ufs != null) && (localc.ufs.ufu != null) && (localc.ufs.ufu.length > 0)) {
      addIconOptionMenu(0, 2131230740, new WalletBalanceFetchUI.22(this, localc));
    }
    AppMethodBeat.o(45394);
  }
  
  private void cQV()
  {
    AppMethodBeat.i(45392);
    if (this.tNH != null)
    {
      this.tNW = com.tencent.mm.wallet_core.ui.e.b(this.tNH.ugh, "100", RoundingMode.HALF_UP);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "min charge fee: %s", new Object[] { Double.valueOf(this.tNW) });
    }
    AppMethodBeat.o(45392);
  }
  
  private void cQW()
  {
    AppMethodBeat.i(45395);
    if ((this.qlk > 0.0D) && (this.tNH != null))
    {
      this.gJr.setEnabled(true);
      AppMethodBeat.o(45395);
      return;
    }
    this.gJr.setEnabled(false);
    AppMethodBeat.o(45395);
  }
  
  private void cQX()
  {
    AppMethodBeat.i(45396);
    double d;
    StringBuilder localStringBuilder;
    if (this.tOb == 0)
    {
      this.qlk = bo.getDouble(this.tNJ.getText(), 0.0D);
      d = this.qlk;
      s.cRG();
      if ((d != s.cRH().tOD.ufO) && (this.tNH != null))
      {
        d = this.qlk;
        s.cRG();
        if (d != s.cRH().tOD.ufO - this.tNH.field_full_fetch_charge_fee) {
          this.tNY = 0;
        }
      }
      localStringBuilder = new StringBuilder();
      d = this.qlk;
      s.cRG();
      if (d <= s.cRH().tOD.ufM) {
        break label181;
      }
      this.tNQ.setVisibility(8);
      this.tNP.setTextColor(getResources().getColor(2131690391));
      localStringBuilder.append(getString(2131304814));
    }
    for (;;)
    {
      this.tNP.setText(localStringBuilder.toString());
      AppMethodBeat.o(45396);
      return;
      label181:
      String str;
      if ((this.tNH != null) && (this.tNT != 0) && ((this.tNT != 1) || (this.tNH.field_fetch_charge_rate > 0.0D)) && ((this.tNT != 1) || (this.tNH.field_fetch_charge_rate <= 0.0D) || (this.tNU != 0)))
      {
        d = this.tNW;
        s.cRG();
        if (d < s.cRH().tOD.ufO) {}
      }
      else
      {
        this.tNQ.setVisibility(0);
        this.tNP.setTextColor(getResources().getColor(2131690168));
        s.cRG();
        str = s.cRH().tOD.ufT;
        if (!bo.isNullOrNil(str)) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          s.cRG();
          localStringBuilder.append(getString(2131304805, new Object[] { com.tencent.mm.wallet_core.ui.e.e(s.cRH().tOD.ufO, "CNY") }));
        }
      }
      if ((this.tNT == 1) && (this.tNH.field_fetch_charge_rate > 0.0D) && (this.tNU == 1) && ((this.qlk <= 0.0D) || (!this.tNJ.asv())))
      {
        this.tNQ.setVisibility(0);
        this.tNP.setTextColor(getResources().getColor(2131690168));
        s.cRG();
        str = s.cRH().tOD.ufT;
        if (!bo.isNullOrNil(str)) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          localStringBuilder.append("，");
          break;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
          s.cRG();
          localStringBuilder.append(getString(2131304805, new Object[] { com.tencent.mm.wallet_core.ui.e.e(s.cRH().tOD.ufO, "CNY") }));
        }
      }
      if ((this.tNT == 1) && (this.tNH.field_fetch_charge_rate > 0.0D) && (this.tNU == 1))
      {
        this.tNQ.setVisibility(8);
        this.tNP.setTextColor(getResources().getColor(2131690168));
        d = this.qlk;
        s.cRG();
        if ((d == s.cRH().tOD.ufO - this.tNH.field_full_fetch_charge_fee) && (this.tNH.field_full_fetch_charge_fee > 0.0D))
        {
          if (!bo.isNullOrNil(this.tNH.ugg)) {
            localStringBuilder.append(String.format(this.tNH.ugg, new Object[] { com.tencent.mm.wallet_core.ui.e.e(this.tNH.field_full_fetch_charge_fee, "CNY") }));
          } else {
            localStringBuilder.append(getString(2131304787, new Object[] { com.tencent.mm.wallet_core.ui.e.e(this.tNH.field_full_fetch_charge_fee, "CNY"), this.tNH.field_fetch_charge_rate * 100.0D + "%" }));
          }
        }
        else if (!bo.isNullOrNil(this.tNH.ugg)) {
          localStringBuilder.append(String.format(this.tNH.ugg, new Object[] { com.tencent.mm.wallet_core.ui.e.e(B(this.qlk), "CNY") }));
        } else {
          localStringBuilder.append(getString(2131304787, new Object[] { com.tencent.mm.wallet_core.ui.e.e(B(this.qlk), "CNY"), this.tNH.field_fetch_charge_rate * 100.0D + "%" }));
        }
      }
    }
  }
  
  private void cQY()
  {
    AppMethodBeat.i(45400);
    fetchData();
    bJ();
    cRb();
    AppMethodBeat.o(45400);
  }
  
  private void cQZ()
  {
    this.tOf = false;
    this.tOg = false;
    this.tOh = false;
    this.tOi = false;
  }
  
  private void cRa()
  {
    AppMethodBeat.i(45410);
    Object localObject = i.cTp();
    if (((i)localObject).Pk())
    {
      com.tencent.mm.ui.base.h.b(this, ((i)localObject).pot, getString(2131297087), true);
      AppMethodBeat.o(45410);
      return;
    }
    Bundle localBundle = new Bundle();
    PayInfo localPayInfo = (PayInfo)getInput().get("key_pay_info");
    localObject = localPayInfo;
    if (localPayInfo == null)
    {
      localObject = new PayInfo();
      ((PayInfo)localObject).cnI = this.cnI;
      ((PayInfo)localObject).cCD = 21;
    }
    if (localObject != null) {
      localBundle.putParcelable("key_pay_info", (Parcelable)localObject);
    }
    localBundle.putInt("key_scene", 21);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("key_is_bind_bankcard", true);
    localBundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.tLV);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, localBundle, null);
    AppMethodBeat.o(45410);
  }
  
  private void cRb()
  {
    AppMethodBeat.i(45412);
    if (this.tNT != 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.tNT);
      AppMethodBeat.o(45412);
      return;
    }
    com.tencent.mm.kernel.g.RM();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCj, Boolean.FALSE)).booleanValue();
    s.cRG();
    com.tencent.mm.plugin.wallet_core.model.c localc = s.cRH().ulR;
    if ((localc != null) && (!bool))
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131305473, new Object[] { com.tencent.mm.wallet_core.ui.e.F(localc.qjH) }), getString(2131305474), getString(2131305099), getString(2131305475), new WalletBalanceFetchUI.9(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45364);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", WalletBalanceFetchUI.this.getString(2131305068));
          localIntent.putExtra("showShare", false);
          com.tencent.mm.bq.d.b(WalletBalanceFetchUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.report.service.h.qsU.e(16398, new Object[] { WalletBalanceFetchUI.d(WalletBalanceFetchUI.this), Integer.valueOf(3), "", "" });
          AppMethodBeat.o(45364);
        }
      }, 2131690701);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCj, Boolean.TRUE);
    }
    AppMethodBeat.o(45412);
  }
  
  private boolean d(com.tencent.mm.plugin.wallet.balance.a.d paramd)
  {
    AppMethodBeat.i(45407);
    paramd = paramd.tMa;
    if ((paramd != null) && ((!TextUtils.isEmpty(paramd.ufo)) || ((paramd.ufp != null) && (paramd.ufp.size() > 0))))
    {
      this.tOh = true;
      com.tencent.mm.plugin.wallet_core.ui.k.a(this, paramd, new WalletBalanceFetchUI.6(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45361);
          paramAnonymousDialogInterface.dismiss();
          WalletBalanceFetchUI.o(WalletBalanceFetchUI.this);
          AppMethodBeat.o(45361);
        }
      });
      AppMethodBeat.o(45407);
      return true;
    }
    AppMethodBeat.o(45407);
    return false;
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(45389);
    s.cRG();
    am localam = s.cRH();
    Object localObject2;
    Object localObject3;
    int i;
    Object localObject4;
    if (this.tOa)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      if ((this.tNG != null) && (this.tNG.size() > 0)) {
        ((ArrayList)localObject1).addAll(this.tNG);
      }
      this.tNG = localam.cUH();
      if ((this.tNG != null) && (this.tNG.size() > 0)) {
        ((ArrayList)localObject2).addAll(this.tNG);
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
        localObject1 = localam.a(this.tNG, null, false, true);
      }
      for (;;)
      {
        i = 0;
        if ((this.tNG != null) && (i < this.tNG.size()))
        {
          localObject2 = (Bankcard)this.tNG.get(i);
          if ((localObject1 != null) && (localObject2 != null) && (((Bankcard)localObject1).field_bindSerial.equals(((Bankcard)localObject2).field_bindSerial))) {
            this.tNX = i;
          }
        }
        else
        {
          this.tNH = ((Bankcard)localObject1);
          this.tOa = false;
          localObject3 = com.tencent.mm.plugin.report.service.h.qsU;
          localObject4 = this.smv;
          if (this.tNH == null) {
            break label587;
          }
          localObject1 = this.tNH.field_bankcardType;
          label373:
          if (this.tNH == null) {
            break label594;
          }
          localObject2 = this.tNH.field_bindSerial;
          ((com.tencent.mm.plugin.report.service.h)localObject3).e(16398, new Object[] { localObject4, Integer.valueOf(1), localObject1, localObject2 });
          if (localam.ulR == null) {
            break label602;
          }
          this.tNT = localam.ulR.tNT;
          this.tNU = localam.ulR.tNU;
          cQV();
          this.tNV = localam.ulR.tNV;
        }
        for (;;)
        {
          this.tOb = 0;
          this.tOc = 0;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.tNT + " is_cal_charge:" + this.tNU + " min_charge_fee:" + this.tNW + " is_full_fetch_direct:" + this.tNV);
          AppMethodBeat.o(45389);
          return;
          i += 1;
          break;
          this.tNG = localam.cUH();
          this.tNH = localam.a(this.tNG, null, false, true);
          break label347;
          localObject1 = "";
          break label373;
          localObject2 = "";
          break label389;
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
      }
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971128;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45390);
    setMMTitle(2131304811);
    this.iCk = findViewById(2131828935);
    this.tNK = ((LinearLayout)findViewById(2131828938));
    Object localObject = new WalletBalanceFetchUI.12(this);
    this.tNL = findViewById(2131828938);
    this.tNL.setOnClickListener((View.OnClickListener)localObject);
    this.tNK.setOnClickListener((View.OnClickListener)localObject);
    this.tNJ = ((WalletFormView)findViewById(2131828944));
    setEditFocusListener(this.tNJ, 2, false);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.tNJ);
    this.tNJ.setOnInputValidChangeListener(this);
    this.gJr = ((Button)findViewById(2131822914));
    this.gJr.setOnClickListener(new WalletBalanceFetchUI.16(this));
    this.gJr.setEnabled(false);
    this.tNM = ((TextView)findViewById(2131828936));
    this.tNN = ((TextView)findViewById(2131828937));
    this.tNO = ((TextView)findViewById(2131828949));
    this.tNP = ((TextView)findViewById(2131828946));
    this.tNQ = ((TextView)findViewById(2131828947));
    this.tNR = ((ViewGroup)findViewById(2131828945));
    this.tNS = ((ViewGroup)findViewById(2131828948));
    this.tNQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(45377);
        WalletBalanceFetchUI.h(WalletBalanceFetchUI.this);
        AppMethodBeat.o(45377);
      }
    });
    this.tNJ.a(new WalletBalanceFetchUI.18(this));
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(45379);
        if (paramAnonymousBoolean)
        {
          WalletBalanceFetchUI.k(WalletBalanceFetchUI.this);
          AppMethodBeat.o(45379);
          return;
        }
        WalletBalanceFetchUI.l(WalletBalanceFetchUI.this).scrollTo(0, 0);
        AppMethodBeat.o(45379);
      }
    });
    localObject = new vd();
    ((vd)localObject).cLE.bSd = "3";
    ((vd)localObject).callback = new WalletBalanceFetchUI.20(this, (vd)localObject);
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(45390);
  }
  
  public boolean isTransparent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45402);
    if (paramInt1 == 1)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramInt1 = paramIntent.getIntExtra("key_select_index", -1);
        paramInt2 = this.tNX;
        this.tNX = paramInt1;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is ".concat(String.valueOf(paramInt1)));
        if ((this.tNG == null) || (paramInt1 < 0) || (paramInt1 >= this.tNG.size())) {
          if ((this.tNG == null) || (paramInt1 < 0) || (paramInt1 > this.tNG.size()))
          {
            this.tNH = null;
            cRa();
          }
        }
        for (;;)
        {
          bJ();
          AppMethodBeat.o(45402);
          return;
          this.tNX = paramInt2;
          break;
          this.tNH = ((Bankcard)this.tNG.get(paramInt1));
        }
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
      AppMethodBeat.o(45402);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(45402);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45387);
    this.smv = UUID.randomUUID().toString();
    super.onCreate(paramBundle);
    at(getIntent());
    fetchData();
    this.tNI = getString(2131304841);
    initView();
    bJ();
    com.tencent.mm.wallet_core.c.z.id(4, 0);
    AppMethodBeat.o(45387);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45388);
    al.ae(this.tOe);
    super.onDestroy();
    AppMethodBeat.o(45388);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(45401);
    this.tNJ.fE(null);
    AppMethodBeat.o(45401);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(45408);
    cQZ();
    at(paramIntent);
    AppMethodBeat.o(45408);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45391);
    cQZ();
    super.onResume();
    AppMethodBeat.o(45391);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45399);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.balance.a.d))
      {
        paramString = (com.tencent.mm.plugin.wallet.balance.a.d)paramm;
        this.tOf = false;
        if (!this.tOi) {
          this.tOg = false;
        }
        this.tOh = false;
        this.tOi = false;
        boolean bool;
        if ("1".equals(paramString.cLV))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
          paramm = new Bundle();
          paramm.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
          paramm.putString("realname_verify_process_jump_plugin", "wallet");
          isTransparent();
          bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramm, null, 0);
        }
        while (bool)
        {
          AppMethodBeat.o(45399);
          return false;
          if ("2".equals(paramString.cLV))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
            bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString.cLW, paramString.cLZ, paramString.cLX, paramString.cLY, isTransparent(), null);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + paramString.cLV);
            bool = false;
          }
        }
        if (paramString.tMd) {
          if (paramString.tMe != null)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "debugIdentifyInfoCompleteDialog() show");
            Object localObject = paramString.tMe.title;
            String str1 = paramString.tMe.content;
            String str2 = paramString.tMe.tMg;
            paramm = paramString.tMe.tMh;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog()");
            View localView = LayoutInflater.from(this).inflate(2130971127, null);
            ImageView localImageView = (ImageView)localView.findViewById(2131822762);
            Button localButton = (Button)localView.findViewById(2131828934);
            ((TextView)localView.findViewById(2131828932)).setText((CharSequence)localObject);
            ((TextView)localView.findViewById(2131828933)).setText(str1);
            ((Button)localView.findViewById(2131828934)).setText(str2);
            localObject = new com.tencent.mm.plugin.crashfix.b.a(this, 2131493881);
            ((Dialog)localObject).setContentView(localView);
            ((Dialog)localObject).setTitle(null);
            ((Dialog)localObject).setOnCancelListener(new WalletBalanceFetchUI.13(this, (Dialog)localObject));
            localImageView.setOnClickListener(new WalletBalanceFetchUI.14(this, (Dialog)localObject));
            localButton.setOnClickListener(new WalletBalanceFetchUI.15(this, this, paramm, (Dialog)localObject));
            ((Dialog)localObject).show();
            com.tencent.mm.ui.base.h.a(this, (Dialog)localObject);
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label491;
          }
          AppMethodBeat.o(45399);
          return false;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceFetchUI", "fetchScene.accountTipDialog == null");
          break;
        }
        label491:
        ad.q(21, paramString.cwk, paramInt2);
        if (!b(paramString))
        {
          this.cnI = paramString.cwk;
          a(paramString);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(45399);
      return false;
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.ab)paramm;
        cQY();
        if (paramString.isJumpRemind())
        {
          paramm = paramString.getJumpRemind();
          paramm.a(this, new WalletBalanceFetchUI.3(this, paramm, paramString));
          AppMethodBeat.o(45399);
          return true;
          if ((paramm instanceof com.tencent.mm.plugin.wallet.balance.a.d))
          {
            ad.q(21, "", paramInt2);
            cQZ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI
 * JD-Core Version:    0.7.0.1
 */