package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.balance.a.a.aa;
import com.tencent.mm.plugin.wallet.balance.a.a.aa.d;
import com.tencent.mm.plugin.wallet.balance.a.a.ac;
import com.tencent.mm.plugin.wallet.balance.a.a.p;
import com.tencent.mm.plugin.wallet.balance.a.a.p.a;
import com.tencent.mm.plugin.wallet.balance.a.a.y;
import com.tencent.mm.plugin.wallet.balance.a.a.y.c;
import com.tencent.mm.plugin.wallet.balance.a.a.z.6;
import com.tencent.mm.plugin.wallet.balance.a.a.z.7;
import com.tencent.mm.plugin.wallet.balance.a.a.z.8;
import com.tencent.mm.plugin.wallet.balance.a.a.z.9;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletLqtSaveFetchUI
  extends WalletLqtBasePresenterUI
  implements WcPayKeyboard.a
{
  private int accountType;
  private Dialog gpx;
  private int mode;
  private TextView osb;
  private HashMap<String, Integer> pnv;
  private WcPayKeyboard qnK;
  private Bankcard tNH;
  private com.tencent.mm.plugin.wallet.balance.a.a.x tNh;
  private y tNi;
  private WalletFormView tRA;
  private TextView tRB;
  private TextView tRC;
  private ImageView tRD;
  private TextView tRE;
  private TextView tRF;
  private ViewGroup tRG;
  private TextView tRH;
  private CheckBox tRI;
  private TextView tRJ;
  private TextView tRK;
  private TextView tRL;
  private WalletLqtArriveTimeLayout tRM;
  private ScrollView tRN;
  private CharSequence tRO;
  private Bankcard tRP;
  private int tRQ;
  private String tRR;
  private String tRS;
  private long tRT;
  private String tRU;
  private boolean tRV;
  private List<Bankcard> tRW;
  private boolean tRX;
  private p.a tRY;
  private com.tencent.mm.plugin.wallet.balance.a.a.z tRx;
  private aa tRy;
  private ViewGroup tRz;
  
  public WalletLqtSaveFetchUI()
  {
    AppMethodBeat.i(45676);
    this.tNh = ((com.tencent.mm.plugin.wallet.balance.a.a.x)T(com.tencent.mm.plugin.wallet.balance.a.a.x.class));
    this.tNi = ((y)P(y.class));
    this.tRx = new com.tencent.mm.plugin.wallet.balance.a.a.z(this.tNh, this.tNi, this);
    this.tRy = new aa(this.tRx);
    this.tRT = -1L;
    this.tRV = false;
    this.tRX = true;
    this.tRY = new WalletLqtSaveFetchUI.19(this);
    this.pnv = new HashMap();
    AppMethodBeat.o(45676);
  }
  
  private boolean aeV(String paramString)
  {
    AppMethodBeat.i(154276);
    if (!bo.isNullOrNil(paramString)) {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        Object localObject1 = ((JSONObject)localObject2).optString("guide_flag");
        paramString = ((JSONObject)localObject2).optString("guide_wording");
        String str1 = ((JSONObject)localObject2).optString("left_button_wording");
        String str2 = ((JSONObject)localObject2).optString("right_button_wording");
        localObject2 = ((JSONObject)localObject2).optString("upload_credit_url");
        if ("2".equals(localObject1))
        {
          localObject1 = new c.a(getContext());
          ((c.a)localObject1).rG(false);
          ((c.a)localObject1).avn(paramString);
          ((c.a)localObject1).avt(str1);
          ((c.a)localObject1).avs(str2);
          ((c.a)localObject1).a(true, new WalletLqtSaveFetchUI.20(this, (String)localObject2));
          ((c.a)localObject1).aLZ().show();
          AppMethodBeat.o(154276);
          return true;
        }
      }
      catch (JSONException paramString)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(154276);
    return false;
  }
  
  private void cRs()
  {
    AppMethodBeat.i(45679);
    WalletLqtArriveTimeLayout localWalletLqtArriveTimeLayout = this.tRM;
    localWalletLqtArriveTimeLayout.tPf = false;
    if (localWalletLqtArriveTimeLayout.tPb != null) {
      localWalletLqtArriveTimeLayout.tPb.clear();
    }
    localWalletLqtArriveTimeLayout.tPd = null;
    localWalletLqtArriveTimeLayout.tPc.clear();
    localWalletLqtArriveTimeLayout.setVisibility(4);
    AppMethodBeat.o(45679);
  }
  
  private List<Bankcard> cRt()
  {
    AppMethodBeat.i(45682);
    Object localObject1 = p.tMy;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((p)localObject1).nl(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.cRG();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.cRH().cUJ();
      }
      localObject2 = new LinkedList();
      if (localObject1 != null) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label200;
        }
        Bankcard localBankcard = (Bankcard)((Iterator)localObject1).next();
        if (localBankcard.cTf())
        {
          com.tencent.mm.plugin.wallet.a.s.cRG();
          if (!com.tencent.mm.plugin.wallet.a.s.cRH().cUn())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.cTf()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((this.mode == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.cTf()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label200:
    AppMethodBeat.o(45682);
    return localObject2;
  }
  
  private void cRu()
  {
    AppMethodBeat.i(45685);
    this.tRN.postDelayed(new WalletLqtSaveFetchUI.16(this), 100L);
    AppMethodBeat.o(45685);
  }
  
  private static double gV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(45696);
    try
    {
      if (bo.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim())
      {
        double d = new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), 5, 2).doubleValue();
        AppMethodBeat.o(45696);
        return d;
      }
      return 0.0D;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
      AppMethodBeat.o(45696);
    }
  }
  
  private static int gW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(45697);
    try
    {
      double d1 = bo.getDouble(paramString1, 0.0D);
      double d2 = bo.getDouble(paramString2, 0.0D);
      if (d1 == 0.0D) {
        paramString1 = "0";
      }
      paramString1 = new BigDecimal(paramString1);
      if (d2 == 0.0D) {
        paramString2 = "0";
      }
      int i = paramString1.multiply(new BigDecimal(paramString2)).intValue();
      AppMethodBeat.o(45697);
      return i;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
      AppMethodBeat.o(45697);
    }
    return 0;
  }
  
  private void kw(boolean paramBoolean)
  {
    AppMethodBeat.i(45686);
    this.qnK.rP(paramBoolean);
    AppMethodBeat.o(45686);
  }
  
  private void nr(boolean paramBoolean)
  {
    AppMethodBeat.i(45681);
    Object localObject1 = p.tMy;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((p)localObject1).nl(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.cRG();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.cRH().cUJ();
      }
      localObject2 = new LinkedList();
      if (localObject1 != null) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label204;
        }
        Bankcard localBankcard = (Bankcard)((Iterator)localObject1).next();
        if (localBankcard.cTf())
        {
          com.tencent.mm.plugin.wallet.a.s.cRG();
          if (!com.tencent.mm.plugin.wallet.a.s.cRH().cUn())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && (localBankcard.field_support_lqt_turn_in == 1)) {
          ((List)localObject2).add(localBankcard);
        }
        if ((this.mode == 2) && (localBankcard.field_support_lqt_turn_out == 1)) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label204:
    int i;
    if (paramBoolean)
    {
      localObject1 = p.tMy;
      if (this.mode == 1) {}
      for (bool = true;; bool = false)
      {
        this.tNH = ((p)localObject1).nk(bool);
        if ((bo.isNullOrNil(this.tRU)) || (this.tNH != null)) {
          break;
        }
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject1 = (Bankcard)((List)localObject2).get(i);
          if ((!bo.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.tRU.equals(((Bankcard)localObject1).field_bindSerial))) {
            this.tNH = ((Bankcard)localObject1);
          }
          i += 1;
        }
      }
    }
    if (!bo.isNullOrNil(this.tRU))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = (Bankcard)((List)localObject2).get(i);
        if ((!bo.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.tRU.equals(((Bankcard)localObject1).field_bindSerial))) {
          this.tNH = ((Bankcard)localObject1);
        }
        i += 1;
      }
    }
    if (this.tNH != null) {}
    for (localObject1 = this.tNH.field_bindSerial;; localObject1 = "")
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletLqtSaveFetchUI", "defaultBankcard: %s, save mCurrentSerial: %s, useDefault: %s", new Object[] { localObject1, this.tRU, Boolean.valueOf(paramBoolean) });
      if (this.tNH != null) {
        break;
      }
      com.tencent.mm.plugin.wallet.a.s.cRG();
      this.tNH = com.tencent.mm.plugin.wallet.a.s.cRH().tOD;
      if (this.tNH != null) {
        break;
      }
      finish();
      AppMethodBeat.o(45681);
      return;
    }
    if (this.tNH.cTf())
    {
      this.tRC.setText(this.tNH.field_desc);
      this.tRC.setText(this.tNH.field_desc);
      this.tRC.setVisibility(0);
      this.tRD.setTag(this.tNH.field_bindSerial);
      if (this.tRD != null)
      {
        localObject1 = "";
        localObject2 = com.tencent.mm.plugin.wallet_core.d.b.h(this, this.tNH.field_bankcardType, this.tNH.cTe());
        if (localObject2 != null) {
          localObject1 = ((com.tencent.mm.plugin.wallet_core.model.g)localObject2).pek;
        }
        this.tRD.setImageBitmap(null);
        if (!this.tNH.cTf()) {
          break label1007;
        }
        this.tRD.setImageResource(2130840794);
      }
      label623:
      this.tRJ.setVisibility(8);
      this.tRK.setVisibility(8);
      if ((this.mode != 2) && (this.mode == 1) && (!this.tNH.cTf()) && (!bo.isNullOrNil(this.tNH.field_avail_save_wording)))
      {
        this.tRJ.setText(this.tNH.field_avail_save_wording);
        this.tRJ.setVisibility(0);
      }
      setMMTitle("");
      if (this.mode != 1) {
        break label1091;
      }
      localObject1 = getIntent().getStringArrayListExtra("lqt_protocol_list");
      paramBoolean = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0) || (!paramBoolean)) {
        break label1079;
      }
      this.tRG.setVisibility(0);
      this.tRI.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
      this.tRG.setOnClickListener(new WalletLqtSaveFetchUI.7(this));
      this.tRI.setOnCheckedChangeListener(new WalletLqtSaveFetchUI.8(this));
      localObject2 = getString(2131305274);
      i = ((String)localObject2).length();
      localObject2 = new SpannableString((String)localObject2 + getString(2131305275));
      ((SpannableString)localObject2).setSpan(new a(new WalletLqtSaveFetchUI.9(this, (ArrayList)localObject1)), i, ((SpannableString)localObject2).length(), 17);
      this.tRH.setText((CharSequence)localObject2);
      this.tRH.setClickable(true);
      this.tRH.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
    }
    for (;;)
    {
      if (this.mode == 1)
      {
        if ((this.tNH != null) && (this.tNH.cTf()))
        {
          this.tRE.setText(this.tRO);
          AppMethodBeat.o(45681);
          return;
          this.tRC.setText(getString(2131304840, new Object[] { this.tNH.field_bankName, this.tNH.field_bankcardTail }));
          break;
          label1007:
          localObject1 = com.tencent.mm.platformtools.x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject1));
          com.tencent.mm.platformtools.x.a(new WalletLqtSaveFetchUI.25(this));
          if (localObject1 == null) {
            break label623;
          }
          localObject1 = d.a((Bitmap)localObject1, getResources().getDimensionPixelOffset(2131428824), getResources().getDimensionPixelOffset(2131428824), true, false);
          this.tRD.setImageBitmap((Bitmap)localObject1);
          break label623;
          label1079:
          this.tRG.setVisibility(8);
          continue;
          label1091:
          if (this.mode != 2) {
            continue;
          }
          findViewById(2131829209).setVisibility(8);
          this.tRG.setVisibility(8);
          this.tRF.setVisibility(8);
          localObject1 = com.tencent.mm.plugin.wallet.balance.a.a.s.cQR();
          if ((this.tNH != null) && (this.tNH.cTf()))
          {
            i = getIntent().getIntExtra("lqt_balance", 0);
            if (com.tencent.mm.platformtools.ae.glG) {
              i = 50000000;
            }
            if (i <= 0) {
              continue;
            }
            localObject1 = getString(2131305209, new Object[] { Double.valueOf(gV(String.valueOf(i), "100")) });
            j = ((String)localObject1).length();
            localObject1 = new SpannableString((String)localObject1 + getString(2131305212));
            ((SpannableString)localObject1).setSpan(new a(new WalletLqtSaveFetchUI.22(this, i)), j, ((SpannableString)localObject1).length(), 18);
            this.tRO = ((CharSequence)localObject1);
            this.tRE.setText((CharSequence)localObject1);
            continue;
          }
          if (((com.tencent.mm.plugin.wallet.balance.a.a.s)localObject1).tMM == null)
          {
            i = 0;
            label1303:
            if (((com.tencent.mm.plugin.wallet.balance.a.a.s)localObject1).tMM != null) {
              break label1472;
            }
          }
          label1472:
          for (int j = 0;; j = ((com.tencent.mm.plugin.wallet.balance.a.a.s)localObject1).tMM.xwn)
          {
            if (com.tencent.mm.platformtools.ae.glG)
            {
              i = 100000000;
              j = 50000000;
            }
            localObject2 = getString(2131305210, new Object[] { Double.valueOf(gV(String.valueOf(i), "100")), Double.valueOf(gV(String.valueOf(j), "100")) });
            i = ((String)localObject2).length();
            localObject2 = new SpannableString((String)localObject2 + getString(2131305211));
            ((SpannableString)localObject2).setSpan(new a(new WalletLqtSaveFetchUI.23(this, (com.tencent.mm.plugin.wallet.balance.a.a.s)localObject1)), i, ((SpannableString)localObject2).length(), 18);
            this.tRO = ((CharSequence)localObject2);
            this.tRE.setText((CharSequence)localObject2);
            break;
            i = ((com.tencent.mm.plugin.wallet.balance.a.a.s)localObject1).tMM.xwl;
            break label1303;
          }
        }
        this.tRE.setText("");
      }
    }
    AppMethodBeat.o(45681);
  }
  
  private void ns(boolean paramBoolean)
  {
    AppMethodBeat.i(45687);
    if (paramBoolean)
    {
      if (this.mode == 1)
      {
        if (this.tRG.getVisibility() == 0)
        {
          if ((this.tRI.isChecked()) && (this.tRV))
          {
            kw(true);
            AppMethodBeat.o(45687);
            return;
          }
          kw(false);
          AppMethodBeat.o(45687);
          return;
        }
        if (!this.tRV) {
          break label203;
        }
        kw(true);
        AppMethodBeat.o(45687);
        return;
      }
      if ((this.tRV) && (this.tRM.getVisibility() == 0) && ((this.tRM.getSelectRedeemType() != null) || (this.tRM.getRedeemTypeList() == null) || (this.tRM.getRedeemTypeList().isEmpty())))
      {
        if (this.tRM.getSelectRedeemType() == null) {}
        for (Integer localInteger = null;; localInteger = Integer.valueOf(this.tRM.getSelectRedeemType().xBD))
        {
          com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WalletLqtSaveFetchUI", "redeem type: %s", new Object[] { localInteger });
          kw(true);
          AppMethodBeat.o(45687);
          return;
        }
      }
    }
    kw(false);
    label203:
    AppMethodBeat.o(45687);
  }
  
  private void v(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(45680);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletLqtSaveFetchUI", "update arrive time layout: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    boolean bool;
    if (this.mode == 2) {
      if (!this.tRM.tPf)
      {
        localObject = com.tencent.mm.plugin.wallet.balance.a.a.s.cQR().tMM;
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletLqtSaveFetchUI", "no cache!");
          AppMethodBeat.o(45680);
          return;
        }
        if (this.tNH.cTf())
        {
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
          this.tRM.setRedeemTypeList(((bhh)localObject).xwp);
          this.tRM.aeR(paramString);
          if ((((bhh)localObject).xwp == null) || (((bhh)localObject).xwp.isEmpty())) {
            break label297;
          }
          bool = true;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletLqtSaveFetchUI", "show title: %s", new Object[] { Boolean.valueOf(bool) });
      cRu();
      AppMethodBeat.o(45680);
      return;
      if (((bhh)localObject).xwq != null)
      {
        localObject = ((bhh)localObject).xwq.iterator();
        paramBoolean = false;
        bool = paramBoolean;
        if (((Iterator)localObject).hasNext())
        {
          hh localhh = (hh)((Iterator)localObject).next();
          if (localhh.wtS.equals(this.tNH.field_bindSerial))
          {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
            this.tRM.setRedeemTypeList(localhh.wtZ);
            this.tRM.aeR(paramString);
            if ((localhh.wtZ != null) && (!localhh.wtZ.isEmpty())) {
              paramBoolean = true;
            }
          }
          for (;;)
          {
            break;
            this.tRM.aeR(paramString);
            AppMethodBeat.o(45680);
            return;
          }
        }
      }
      else
      {
        label297:
        bool = false;
      }
    }
  }
  
  public final void XJ(String paramString)
  {
    AppMethodBeat.i(45694);
    Toast.makeText(this, paramString, 1).show();
    AppMethodBeat.o(45694);
  }
  
  public final void aCV()
  {
    AppMethodBeat.i(45692);
    if (this.gpx != null) {
      this.gpx.dismiss();
    }
    AppMethodBeat.o(45692);
  }
  
  public final void aV(float paramFloat)
  {
    AppMethodBeat.i(142343);
    if (this.tRN != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.tRN.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletLqtSaveFetchUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.tRN.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(142343);
  }
  
  public final void cRr()
  {
    AppMethodBeat.i(45678);
    Object localObject;
    int i;
    if (this.mode == 1)
    {
      this.tRP = p.tMy.cQM();
      if (this.tRP == null)
      {
        com.tencent.mm.plugin.wallet.a.s.cRG();
        this.tRP = com.tencent.mm.plugin.wallet.a.s.cRH().tOD;
      }
      if (this.tRP != null)
      {
        localObject = p.tMy.cQN();
        i = p.tMy.cQO();
        if (i != 0) {
          break label189;
        }
        this.tRO = ((CharSequence)localObject);
        if (this.tRE != null) {
          this.tRE.setText(this.tRO);
        }
      }
      if (this.tRz != null) {
        this.tRz.setVisibility(0);
      }
      if (bo.isNullOrNil(p.tMy.tMu)) {
        break label295;
      }
      this.osb.setText(p.tMy.tMu);
      this.osb.setVisibility(0);
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.wallet.balance.a.a.s.cQR().tMM;
      if ((localObject != null) && (((bhh)localObject).xoA) && (((bhh)localObject).xwr != null)) {
        ac.a(getContext(), ((bhh)localObject).xwr);
      }
      nr(true);
      AppMethodBeat.o(45678);
      return;
      label189:
      if (i == 1)
      {
        i = ((String)localObject).length();
        localObject = new SpannableString((String)localObject + getString(2131305185));
        ((SpannableString)localObject).setSpan(new a(new WalletLqtSaveFetchUI.21(this)), i + 1, ((SpannableString)localObject).length(), 18);
        this.tRO = ((CharSequence)localObject);
        break;
      }
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletLqtSaveFetchUI", "unknown func: %s", new Object[] { Integer.valueOf(i) });
      this.tRO = ((CharSequence)localObject);
      break;
      label295:
      this.osb.setVisibility(8);
    }
  }
  
  public final void cRv()
  {
    boolean bool = true;
    AppMethodBeat.i(45693);
    p localp;
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJv, this.tRU);
      localp = p.tMy;
      if (this.mode != 1) {
        break label114;
      }
    }
    for (;;)
    {
      if (localp.nj(bool))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletLqtSaveFetchUI", "saveOrfetchDone, req again after deal");
        this.tRy.tNw.gv(this.mode, this.accountType);
      }
      AppMethodBeat.o(45693);
      return;
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJw, this.tRU);
      break;
      label114:
      bool = false;
    }
  }
  
  public int getLayoutId()
  {
    return 2130971202;
  }
  
  public final void nt(boolean paramBoolean)
  {
    AppMethodBeat.i(45691);
    if ((this.gpx == null) || (!this.gpx.isShowing()))
    {
      if (paramBoolean)
      {
        this.gpx = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        AppMethodBeat.o(45691);
        return;
      }
      this.gpx = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    }
    AppMethodBeat.o(45691);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45689);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.tRy.tNw.gv(this.mode, this.accountType).f(new WalletLqtSaveFetchUI.18(this));
      AppMethodBeat.o(45689);
      return;
    }
    com.tencent.mm.plugin.wallet.balance.a.a.z localz = this.tRx;
    Object localObject;
    if ((paramInt1 == com.tencent.mm.plugin.wallet.balance.a.a.z.tNf) && (paramInt2 == -1))
    {
      paramIntent = (Orders)paramIntent.getParcelableExtra("key_orders");
      if ((paramIntent != null) && (paramIntent.ujl != null) && (paramIntent.ujl.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s, reqkey: %s", new Object[] { Integer.valueOf(localz.hashCode()), Integer.valueOf(localz.accountType), paramIntent.cnI });
        localz.cnJ = ((Orders.Commodity)paramIntent.ujl.get(0)).cnJ;
        paramIntent = (String)localz.tNp.get(paramIntent.cnI);
        if (!bo.isNullOrNil(paramIntent)) {
          localz.tNk = paramIntent;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
        localz.tNj.nt(false);
        paramIntent = localz.tNj.getIntent().getStringExtra("operate_id");
        localObject = localz.tNi.tNb;
        f.a(localz.tNk, localz.cnJ, Integer.valueOf(localz.tNl), Integer.valueOf(localz.accountType), paramIntent).c((com.tencent.mm.vending.c.a)localObject).f(new z.7(localz)).a(new z.6(localz));
      }
      AppMethodBeat.o(45689);
      return;
    }
    if ((paramInt1 == com.tencent.mm.plugin.wallet.balance.a.a.z.tNg) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra("lqt_fetch_enc_pwd");
      paramIntent = paramIntent.getStringExtra("lqt_redeem_listid");
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", new Object[] { Integer.valueOf(localz.hashCode()), Integer.valueOf(localz.accountType), paramIntent });
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", new Object[] { Integer.valueOf(localz.hashCode()), paramIntent });
      if (bo.isNullOrNil(localz.tNn))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", new Object[] { Integer.valueOf(localz.hashCode()), paramIntent });
        localz.tNn = paramIntent;
      }
      paramIntent = localz.tNj.getIntent().getStringExtra("operate_id");
      localz.tNj.nt(true);
      y.c localc = localz.tNi.tNc;
      f.a(Integer.valueOf(localz.tNm), localObject, localz.tNn, Integer.valueOf(localz.accountType), paramIntent).c(localc).f(new z.9(localz)).a(new z.8(localz));
    }
    AppMethodBeat.o(45689);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45677);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131689505));
    hideActionbarLine();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
    this.tRA = ((WalletFormView)findViewById(2131829207));
    this.tRD = ((ImageView)findViewById(2131828940));
    this.tRE = ((TextView)findViewById(2131829208));
    this.tRF = ((TextView)findViewById(2131829210));
    this.tRB = ((TextView)findViewById(2131829206));
    this.tRC = ((TextView)findViewById(2131829204));
    this.tRL = ((TextView)findViewById(2131820696));
    this.osb = ((TextView)findViewById(2131829212));
    this.tRG = ((ViewGroup)findViewById(2131829213));
    this.tRH = ((TextView)findViewById(2131829215));
    this.tRI = ((CheckBox)findViewById(2131829214));
    this.tRz = ((ViewGroup)findViewById(2131824647));
    this.tRJ = ((TextView)findViewById(2131828942));
    this.tRK = ((TextView)findViewById(2131828943));
    this.tRM = ((WalletLqtArriveTimeLayout)findViewById(2131829211));
    this.tRN = ((ScrollView)findViewById(2131829202));
    this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
    this.tRQ = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
    this.tRR = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
    this.tRS = getIntent().getStringExtra("lqt_profile_wording");
    this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.RM();
      this.tRU = ((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJv, ""));
      if (bo.isNullOrNil(this.tRU))
      {
        com.tencent.mm.kernel.g.RM();
        this.tRU = ((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJu, ""));
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", new Object[] { Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.tRU });
      this.tRA.getTitleTv().setText(com.tencent.mm.wallet_core.c.ae.dSz());
      this.qnK = ((WcPayKeyboard)findViewById(2131829492));
      paramBundle = (RelativeLayout.LayoutParams)this.qnK.getLayoutParams();
      paramBundle.addRule(12);
      this.qnK.setLayoutParams(paramBundle);
      if (this.mode != 1) {
        break label866;
      }
      setWPKeyboard(this.tRA.getContentEt(), false, false);
      this.qnK.setActionText(getString(2131305286));
      label535:
      setWcKbHeightListener(this);
      if (this.mode != 1) {
        break label901;
      }
      this.tRB.setText(getString(2131305279));
      this.tRL.setText(getString(2131305282));
    }
    for (;;)
    {
      this.tRA.a(new WalletLqtSaveFetchUI.10(this));
      setTenpayKBStateListener(new WalletLqtSaveFetchUI.11(this));
      paramBundle = new WalletLqtSaveFetchUI.13(this);
      this.tRA.getContentEt().setOnEditorActionListener(new WalletLqtSaveFetchUI.14(this, paramBundle));
      if (!bo.isNullOrNil(this.tRS)) {
        this.qnK.setTipText(this.tRS);
      }
      if (this.mode == 2) {
        this.tRM.setCallback(new WalletLqtSaveFetchUI.15(this));
      }
      this.tRE.setText("");
      this.tRE.setClickable(true);
      this.tRE.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
      ns(false);
      if (this.mode == 1) {
        this.tRz.setVisibility(4);
      }
      if (this.tRC.findViewById(2131820695) != null) {
        this.tRC.findViewById(2131820695).setVisibility(8);
      }
      paramBundle = new WalletLqtSaveFetchUI.1(this);
      this.tRC.setOnClickListener(paramBundle);
      if (findViewById(2131828939) != null) {
        findViewById(2131828939).setOnClickListener(paramBundle);
      }
      cRr();
      paramBundle = p.tMy;
      p.a locala = this.tRY;
      paramBundle.tMx.add(locala);
      this.tRz.setOnTouchListener(new WalletLqtSaveFetchUI.12(this));
      AppMethodBeat.o(45677);
      return;
      com.tencent.mm.kernel.g.RM();
      this.tRU = ((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJw, ""));
      break;
      label866:
      this.isVKBFirstTimeShown = false;
      setWPKeyboard(this.tRA.getContentEt(), false, false);
      this.qnK.setActionText(getString(2131305214));
      break label535;
      label901:
      if (this.mode == 2)
      {
        this.tRB.setText(getString(2131305197));
        this.tRL.setText(getString(2131305202));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45695);
    super.onDestroy();
    p localp = p.tMy;
    p.a locala = this.tRY;
    localp.tMx.remove(locala);
    this.tRx = null;
    this.tRy = null;
    AppMethodBeat.o(45695);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(45684);
    if ((this.qnK != null) && (this.qnK.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(45684);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(45684);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(45683);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletLqtSaveFetchUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    paramIntent = cRt();
    this.tRy.tNw.gv(this.mode, this.accountType).f(new WalletLqtSaveFetchUI.5(this, paramIntent));
    AppMethodBeat.o(45683);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45688);
    super.onResume();
    AppMethodBeat.o(45688);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(45690);
    com.tencent.mm.plugin.wallet.balance.a.a.z localz = this.tRx;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
    {
      com.tencent.mm.plugin.wallet.a.s.cRG();
      localz.tNo = com.tencent.mm.plugin.wallet.a.s.cRH().tOD;
      if (localz.gnD != null)
      {
        localz.gnD.C(new Object[] { paramm });
        localz.gnD.resume();
      }
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletLqtSaveFetchUI", "onSceneEnd");
    cRr();
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    AppMethodBeat.o(45690);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI
 * JD-Core Version:    0.7.0.1
 */