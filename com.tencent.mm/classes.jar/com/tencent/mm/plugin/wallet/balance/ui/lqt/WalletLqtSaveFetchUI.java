package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.model.lqt.aa;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ab.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac.6;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac.7;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac.8;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac.9;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ad.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ad.d;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af;
import com.tencent.mm.plugin.wallet.balance.model.lqt.s.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.v;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.bmv;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
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
  private Dialog ibM;
  private int mode;
  private HashMap<String, Integer> sWX;
  private int state;
  private TextView tkE;
  private com.tencent.mm.sdk.b.c<kb> ujv;
  public Runnable vzw;
  private aa zFF;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ab zFG;
  private Bankcard zGh;
  private TextView zLA;
  private TextView zLB;
  private ViewGroup zLC;
  private TextView zLD;
  private CheckBox zLE;
  private TextView zLF;
  private TextView zLG;
  private TextView zLH;
  private WalletLqtArriveTimeLayout zLI;
  private ScrollView zLJ;
  private LinearLayout zLK;
  private TextView zLL;
  private TextView zLM;
  private CharSequence zLN;
  private Bankcard zLO;
  private int zLP;
  private String zLQ;
  private String zLR;
  private long zLS;
  private String zLT;
  private String zLU;
  private boolean zLV;
  private List<Bankcard> zLW;
  private boolean zLX;
  private boolean zLY;
  protected boolean zLZ;
  private ac zLt;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ad zLu;
  private ViewGroup zLv;
  private WalletFormView zLw;
  private TextView zLx;
  private TextView zLy;
  private ImageView zLz;
  private String zMa;
  private boolean zMb;
  private s.a zMc;
  private Runnable zMd;
  
  public WalletLqtSaveFetchUI()
  {
    AppMethodBeat.i(69009);
    this.zFF = ((aa)aq(aa.class));
    this.zFG = ((com.tencent.mm.plugin.wallet.balance.model.lqt.ab)am(com.tencent.mm.plugin.wallet.balance.model.lqt.ab.class));
    this.zLt = new ac(this.zFF, this.zFG, this);
    this.zLu = new com.tencent.mm.plugin.wallet.balance.model.lqt.ad(this.zLt);
    this.zLS = -1L;
    this.zLV = false;
    this.zLX = true;
    this.zLY = false;
    this.zLZ = false;
    this.zMa = "";
    this.zMb = false;
    this.zMc = new s.a()
    {
      public final void dYM()
      {
        AppMethodBeat.i(69002);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "cache updated");
        WalletLqtSaveFetchUI.this.hideLoading();
        WalletLqtSaveFetchUI.this.dZC();
        WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this);
        if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
        {
          WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(69001);
              WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).setMinimumHeight(WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getHeight());
              AppMethodBeat.o(69001);
            }
          });
          AppMethodBeat.o(69002);
          return;
        }
        if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
        {
          String str = WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText();
          if (!bt.isNullOrNil(str)) {
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, str);
          }
        }
        AppMethodBeat.o(69002);
      }
    };
    this.sWX = new HashMap();
    this.state = 0;
    this.vzw = new WalletLqtSaveFetchUI.20(this);
    this.zMd = new WalletLqtSaveFetchUI.21(this);
    this.ujv = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(69009);
  }
  
  private boolean atz(String paramString)
  {
    AppMethodBeat.i(69011);
    if (!bt.isNullOrNil(paramString)) {
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
          localObject1 = new d.a(getContext());
          ((d.a)localObject1).wX(false);
          ((d.a)localObject1).aMg(paramString);
          ((d.a)localObject1).aMn(str1);
          ((d.a)localObject1).aMm(str2);
          ((d.a)localObject1).a(true, new WalletLqtSaveFetchUI.25(this, (String)localObject2));
          ((d.a)localObject1).fft().show();
          AppMethodBeat.o(69011);
          return true;
        }
      }
      catch (JSONException paramString)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69011);
    return false;
  }
  
  private void bQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182506);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "update tips: %s", new Object[] { paramString });
    long l = com.tencent.mm.wallet_core.ui.e.lN(String.valueOf(paramString), "100");
    Object localObject;
    if (l > 0L) {
      if (this.mode == 1) {
        if (this.zGh != null) {
          if (this.zGh.ebv())
          {
            if ((this.zLO != null) && (l > jz(this.zLO.AbU, "100")))
            {
              this.zLA.setText(getString(2131765492));
              this.zLA.setTextColor(getResources().getColor(2131099804));
              this.zLV = false;
              sn(false);
              if (l > 0L) {
                break label1309;
              }
              this.zLX = true;
              AppMethodBeat.o(182506);
              return;
            }
            if ((com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zEP >= 0) && (l > com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zEP) && (!bt.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zEM)) && (!bt.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zEN)) && (!bt.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zEO)))
            {
              paramString = new q(new q.a()
              {
                public final void dI(View paramAnonymousView)
                {
                  AppMethodBeat.i(68995);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                  com.tencent.mm.wallet_core.ui.e.a(WalletLqtSaveFetchUI.this.getContext(), com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zEO, true, 1);
                  AppMethodBeat.o(68995);
                }
              });
              localObject = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject).append(com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zEM);
              ((SpannableStringBuilder)localObject).append(com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zEN);
              ((SpannableStringBuilder)localObject).setSpan(paramString, com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zEM.length(), ((SpannableStringBuilder)localObject).length(), 18);
              if ((this.zLA.getText() == null) || (!this.zLA.getText().equals(((SpannableStringBuilder)localObject).toString()))) {
                h.vKh.f(17084, new Object[] { Integer.valueOf(9) });
              }
              this.zLA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(getContext()));
              this.zLA.setClickable(true);
              this.zLA.setText((CharSequence)localObject);
            }
          }
        }
      }
    }
    for (;;)
    {
      this.zLA.setTextColor(getResources().getColor(2131100212));
      this.zLV = false;
      sn(false);
      break;
      this.zLA.setText(this.zLN);
      this.zLA.setTextColor(getResources().getColor(2131100212));
      this.zLV = true;
      sn(true);
      break;
      if ((this.zGh.field_dayQuotaKind > 0.0D) && (l > jz(this.zGh.field_dayQuotaKind, "100")))
      {
        this.zLA.setText(getString(2131765493));
        this.zLA.setTextColor(getResources().getColor(2131099804));
        this.zLV = false;
        sn(false);
        break;
      }
      this.zLA.setText("");
      this.zLV = true;
      sn(true);
      break;
      this.zLV = true;
      sn(true);
      break;
      if (this.mode != 2) {
        break;
      }
      localObject = v.dYO();
      int k;
      label599:
      int i;
      int j;
      if (((v)localObject).dYP() == null)
      {
        k = 0;
        if ((this.zGh == null) || (!this.zGh.ebv())) {
          break label714;
        }
        i = getIntent().getIntExtra("lqt_balance", 0);
        j = 1;
      }
      for (;;)
      {
        if (j != 0)
        {
          if (l > i)
          {
            this.zLA.setText(getString(2131765398));
            this.zLA.setTextColor(getResources().getColor(2131099804));
            this.zLV = false;
            dZD();
            sn(false);
            this.zLK.setVisibility(8);
            break;
            k = ((v)localObject).dYP().DRI;
            break label599;
            label714:
            buo localbuo = v.dYO().dYP();
            if (localbuo == null)
            {
              i = 0;
              j = 0;
              continue;
            }
            i = localbuo.DRK;
            j = 0;
            continue;
          }
          this.zLA.setText(this.zLN);
          this.zLA.setTextColor(getResources().getColor(2131100212));
          this.zLV = true;
          z(paramBoolean, paramString);
          sn(true);
          this.zLK.setVisibility(8);
          break;
        }
      }
      if (l > k)
      {
        this.zLA.setText(getString(2131765398));
        this.zLA.setTextColor(getResources().getColor(2131099804));
        this.zLK.setVisibility(8);
        this.zLV = false;
        dZD();
        sn(false);
        this.zLK.setVisibility(8);
        break;
      }
      if (l > i)
      {
        paramString = getString(2131765385, new Object[] { Double.valueOf(jy(String.valueOf(k), "100")) });
        this.zLA.setTextColor(getResources().getColor(2131100212));
        this.zLA.setText(paramString);
        this.zLK.setVisibility(0);
        paramString = getString(2131765409, new Object[] { Double.valueOf(jy(String.valueOf(i), "100")) });
        i = paramString.length();
        paramString = new SpannableString(paramString + getString(2131765412));
        paramString.setSpan(new a(new a.a()
        {
          public final void aHn()
          {
            AppMethodBeat.i(187117);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, this.zMo.dYP());
            AppMethodBeat.o(187117);
          }
        }), i, paramString.length(), 18);
        this.zLL.setText(paramString);
        this.zLV = false;
        dZD();
        sn(false);
        break;
      }
      if ((this.zGh != null) && (!this.zGh.ebv()) && (this.zGh.field_dayQuotaKind > 0.0D) && (l > jz(this.zGh.field_dayQuotaKind, "100")))
      {
        this.zLK.setVisibility(0);
        this.zLL.setText(getString(2131765400, new Object[] { Double.valueOf(this.zGh.field_dayQuotaKind) }));
        this.zLV = false;
        dZD();
        sn(false);
        break;
      }
      this.zLA.setText(this.zLN);
      this.zLA.setTextColor(getResources().getColor(2131100212));
      this.zLV = true;
      z(paramBoolean, paramString);
      sn(true);
      this.zLK.setVisibility(8);
      break;
      if (this.mode == 1)
      {
        if ((this.zGh != null) && (this.zGh.ebv())) {
          this.zLA.setText(this.zLN);
        } else {
          this.zLA.setText("");
        }
      }
      else
      {
        this.zLA.setText(this.zLN);
        dZD();
      }
    }
    label1309:
    this.zLX = false;
    AppMethodBeat.o(182506);
  }
  
  private void dZD()
  {
    AppMethodBeat.i(69013);
    WalletLqtArriveTimeLayout localWalletLqtArriveTimeLayout = this.zLI;
    localWalletLqtArriveTimeLayout.zHR = false;
    if (localWalletLqtArriveTimeLayout.zHN != null) {
      localWalletLqtArriveTimeLayout.zHN.clear();
    }
    localWalletLqtArriveTimeLayout.zHP = null;
    localWalletLqtArriveTimeLayout.zHO.clear();
    localWalletLqtArriveTimeLayout.setVisibility(4);
    AppMethodBeat.o(69013);
  }
  
  private void dZE()
  {
    AppMethodBeat.i(187126);
    this.sWX.clear();
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this, 2, true);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV;
    this.zLW = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Re(this.mode);
    localObject1 = null;
    if (this.zGh != null) {
      localObject1 = this.zGh.field_bindSerial;
    }
    Object localObject2 = localObject1;
    if (bt.isNullOrNil((String)localObject1))
    {
      localObject2 = this.zLT;
      if (bt.isNullOrNil(this.zLT)) {
        com.tencent.mm.kernel.g.afC();
      }
    }
    for (localObject1 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FsD, "");; localObject1 = localObject2)
    {
      int i = 0;
      int k;
      for (int j = 0; i < this.zLW.size(); j = k)
      {
        localObject2 = (Bankcard)this.zLW.get(i);
        k = j;
        if (!bt.isNullOrNil(((Bankcard)localObject2).field_bindSerial))
        {
          k = j;
          if (((String)localObject1).equals(((Bankcard)localObject2).field_bindSerial)) {
            k = i;
          }
        }
        i += 1;
      }
      locale.HrX = new n.c()
      {
        public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(68970);
          int j = WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).size();
          int i = 0;
          Bankcard localBankcard;
          Object localObject1;
          if (i < j)
          {
            localBankcard = (Bankcard)WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).get(i);
            localObject1 = com.tencent.mm.plugin.wallet_core.d.b.j(WalletLqtSaveFetchUI.this, localBankcard.field_bankcardType, localBankcard.ebu());
            if (localObject1 == null) {
              break label725;
            }
          }
          label157:
          label415:
          label579:
          label725:
          for (final String str1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject1).dct;; str1 = "")
          {
            Bitmap localBitmap = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str1));
            u.a(new u.a()
            {
              public final void l(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(68969);
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(68968);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletLqtSaveFetchUI.2.1.this.umK });
                    if (WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).containsKey(paramAnonymous2String))
                    {
                      int i = ((Integer)WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).get(paramAnonymous2String)).intValue();
                      if ((i < WalletLqtSaveFetchUI.2.1.this.sXf.size()) && (WalletLqtSaveFetchUI.2.1.this.sXf.getItem(i) != null))
                      {
                        WalletLqtSaveFetchUI.2.1.this.sXf.getItem(i).setIcon(new BitmapDrawable(f.a(paramAnonymous2Bitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), true, false)));
                        WalletLqtSaveFetchUI.2.this.ise.ffw();
                      }
                    }
                    AppMethodBeat.o(68968);
                  }
                });
                AppMethodBeat.o(68969);
              }
            });
            Object localObject4 = null;
            Object localObject3 = null;
            localObject1 = "";
            if (!bt.isNullOrNil(localBankcard.field_forbidWord)) {
              localObject1 = localBankcard.field_forbidWord;
            }
            SpannableString localSpannableString;
            Object localObject2;
            String str2;
            if (bt.isNullOrNil(localBankcard.field_forbid_title))
            {
              localSpannableString = new SpannableString((CharSequence)localObject1);
              localObject2 = localObject1;
              str2 = localBankcard.field_desc;
              if (!localBankcard.ebv()) {
                break label415;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localSpannableString });
              localObject1 = WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234612);
              if (!bt.isNullOrNil((String)localObject2)) {
                break label409;
              }
            }
            for (boolean bool = false;; bool = true)
            {
              paramAnonymousl.b(i, str2, localSpannableString, (Drawable)localObject1, bool);
              localObject1 = localObject3;
              if (localObject1 == null) {
                WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).put(str1, Integer.valueOf(i));
              }
              i += 1;
              break;
              localObject2 = (String)localObject1 + " ";
              localSpannableString = new SpannableString((String)localObject2 + localBankcard.field_forbid_title);
              localObject1 = new com.tencent.mm.plugin.wallet_core.ui.l(WalletLqtSaveFetchUI.this)
              {
                public final void onClick(View paramAnonymous2View) {}
              };
              int k = ((String)localObject2).length();
              int m = ((String)localObject2).length() + localBankcard.field_forbid_title.length();
              localSpannableString.setSpan(new ForegroundColorSpan(WalletLqtSaveFetchUI.this.getResources().getColor(2131101130)), k, m, 33);
              localSpannableString.setSpan(localObject1, k, m, 33);
              break label157;
            }
            localObject1 = localObject4;
            if (localBitmap != null) {
              localObject1 = f.a(localBitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), true, false);
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localSpannableString });
            if (localObject1 == null)
            {
              localObject3 = null;
              label493:
              if (!bt.isNullOrNil((String)localObject2)) {
                break label535;
              }
            }
            for (bool = false;; bool = true)
            {
              paramAnonymousl.b(i, str2, localSpannableString, (Drawable)localObject3, bool);
              break;
              localObject3 = new BitmapDrawable((Bitmap)localObject1);
              break label493;
            }
            localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV;
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              bool = true;
              ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).sh(bool);
              if (!bool) {
                break label615;
              }
              localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).zEF;
              if (localObject1 == null) {
                break label625;
              }
            }
            label615:
            label625:
            for (bool = ((bmv)localObject1).DKj;; bool = false)
            {
              if (!bool) {
                break label631;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
              AppMethodBeat.o(68970);
              return;
              bool = false;
              break;
              localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).zEG;
              break label579;
            }
            label631:
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              paramAnonymousl.a(j, WalletLqtSaveFetchUI.this.getString(2131765496), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234603), false);
              AppMethodBeat.o(68970);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) {
              paramAnonymousl.a(j, WalletLqtSaveFetchUI.this.getString(2131765404), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234603), false);
            }
            AppMethodBeat.o(68970);
            return;
          }
        }
      };
      locale.GHn = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(68971);
          WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).clear();
          AppMethodBeat.o(68971);
        }
      };
      locale.HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(68972);
          if (locale != null)
          {
            locale.bfo();
            if (paramAnonymousInt < WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).size())
            {
              paramAnonymousMenuItem = (Bankcard)WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).get(paramAnonymousInt);
              WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, paramAnonymousMenuItem.field_bindSerial);
              WalletLqtSaveFetchUI.n(WalletLqtSaveFetchUI.this);
              if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
              {
                WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).dga();
                AppMethodBeat.o(68972);
                return;
              }
              WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText());
              AppMethodBeat.o(68972);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
              AppMethodBeat.o(68972);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) {
              WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(68972);
        }
      };
      localObject1 = View.inflate(this, 2131494623, null);
      if (this.mode == 1)
      {
        ((TextView)((View)localObject1).findViewById(2131301708)).setText(2131765490);
        ((TextView)((View)localObject1).findViewById(2131301707)).setText(2131765489);
      }
      for (;;)
      {
        locale.uYV = true;
        locale.hRK = j;
        locale.HFm = true;
        locale.J((View)localObject1, false);
        locale.csG();
        AppMethodBeat.o(187126);
        return;
        ((TextView)((View)localObject1).findViewById(2131301708)).setText(2131765396);
        ((TextView)((View)localObject1).findViewById(2131301707)).setText(2131765395);
      }
    }
  }
  
  private List<Bankcard> dZF()
  {
    AppMethodBeat.i(69016);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).sf(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.dZT();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.dZU().edd();
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
        if (localBankcard.ebv())
        {
          com.tencent.mm.plugin.wallet.a.s.dZT();
          if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecH())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.ebv()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((this.mode == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.ebv()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label200:
    AppMethodBeat.o(69016);
    return localObject2;
  }
  
  private void dZG()
  {
    AppMethodBeat.i(69019);
    this.zLJ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68994);
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        WalletLqtSaveFetchUI.this.findViewById(2131301702).getLocationInWindow(arrayOfInt1);
        WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).getLocationInWindow(arrayOfInt2);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
        WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
        AppMethodBeat.o(68994);
      }
    }, 100L);
    AppMethodBeat.o(69019);
  }
  
  private static double jy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69032);
    try
    {
      if (bt.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim())
      {
        double d = new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), 5, 2).doubleValue();
        AppMethodBeat.o(69032);
        return d;
      }
      return 0.0D;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
      AppMethodBeat.o(69032);
    }
  }
  
  private static int jz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69033);
    try
    {
      double d1 = bt.getDouble(paramString1, 0.0D);
      double d2 = bt.getDouble(paramString2, 0.0D);
      if (d1 == 0.0D) {
        paramString1 = "0";
      }
      paramString1 = new BigDecimal(paramString1);
      if (d2 == 0.0D) {
        paramString2 = "0";
      }
      int i = paramString1.multiply(new BigDecimal(paramString2)).intValue();
      AppMethodBeat.o(69033);
      return i;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
      AppMethodBeat.o(69033);
    }
    return 0;
  }
  
  private void kJ(boolean paramBoolean)
  {
    AppMethodBeat.i(69021);
    this.mWcKeyboard.xm(paramBoolean);
    AppMethodBeat.o(69021);
  }
  
  private void sm(boolean paramBoolean)
  {
    AppMethodBeat.i(69015);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).sf(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.dZT();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.dZU().edd();
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
        if (localBankcard.ebv())
        {
          com.tencent.mm.plugin.wallet.a.s.dZT();
          if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecH())
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
    final int i;
    if (paramBoolean)
    {
      if (!bt.isNullOrNil(this.zLU))
      {
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject1 = (Bankcard)((List)localObject2).get(i);
          if ((!bt.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.zLU.equals(((Bankcard)localObject1).field_bindSerial))) {
            this.zGh = ((Bankcard)localObject1);
          }
          i += 1;
        }
      }
      if ((bt.isNullOrNil(this.zLU)) || (this.zGh == null))
      {
        localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV;
        if (this.mode == 1) {}
        for (bool = true;; bool = false)
        {
          this.zGh = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).se(bool);
          if ((bt.isNullOrNil(this.zLT)) || (this.zGh != null)) {
            break;
          }
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = (Bankcard)((List)localObject2).get(i);
            if ((!bt.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.zLT.equals(((Bankcard)localObject1).field_bindSerial))) {
              this.zGh = ((Bankcard)localObject1);
            }
            i += 1;
          }
        }
      }
    }
    else if (!bt.isNullOrNil(this.zLT))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = (Bankcard)((List)localObject2).get(i);
        if ((!bt.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.zLT.equals(((Bankcard)localObject1).field_bindSerial))) {
          this.zGh = ((Bankcard)localObject1);
        }
        i += 1;
      }
    }
    if (this.zGh != null) {}
    for (localObject1 = this.zGh.field_bindSerial;; localObject1 = "")
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "defaultBankcard: %s, save mCurrentSerial: %s, useDefault: %s", new Object[] { localObject1, this.zLT, Boolean.valueOf(paramBoolean) });
      if (this.zGh != null) {
        break;
      }
      com.tencent.mm.plugin.wallet.a.s.dZT();
      this.zGh = com.tencent.mm.plugin.wallet.a.s.dZU().zHd;
      if (this.zGh != null) {
        break;
      }
      finish();
      AppMethodBeat.o(69015);
      return;
    }
    if (this.zGh.ebv())
    {
      this.zLy.setText(this.zGh.field_desc);
      this.zLy.setText(this.zGh.field_desc);
      this.zLy.setVisibility(0);
      this.zLz.setTag(this.zGh.field_bindSerial);
      if (this.zLz != null)
      {
        localObject1 = "";
        localObject2 = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.zGh.field_bankcardType, this.zGh.ebu());
        if (localObject2 != null) {
          localObject1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject2).dct;
        }
        this.zLz.setImageBitmap(null);
        if (!this.zGh.ebv()) {
          break label1093;
        }
        this.zLz.setImageResource(2131234612);
      }
      label715:
      this.zLF.setVisibility(8);
      this.zLG.setVisibility(8);
      if ((this.mode != 2) && (this.mode == 1) && (!this.zGh.ebv()) && (!bt.isNullOrNil(this.zGh.field_avail_save_wording)))
      {
        this.zLF.setText(this.zGh.field_avail_save_wording);
        this.zLF.setVisibility(0);
      }
      if (this.mode != 1) {
        break label1177;
      }
      localObject1 = getIntent().getStringArrayListExtra("lqt_protocol_list");
      paramBoolean = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0) || (!paramBoolean)) {
        break label1165;
      }
      this.zLC.setVisibility(0);
      this.zLE.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
      this.zLC.setOnClickListener(new WalletLqtSaveFetchUI.7(this));
      this.zLE.setOnCheckedChangeListener(new WalletLqtSaveFetchUI.8(this));
      localObject2 = getString(2131765483);
      i = ((String)localObject2).length();
      localObject2 = new SpannableString((String)localObject2 + getString(2131765484));
      ((SpannableString)localObject2).setSpan(new a(new a.a()
      {
        public final void aHn()
        {
          AppMethodBeat.i(68979);
          com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(WalletLqtSaveFetchUI.this, 1, false);
          locale.HrX = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(68977);
              Iterator localIterator = WalletLqtSaveFetchUI.9.this.zMi.iterator();
              int i = 0;
              while (localIterator.hasNext())
              {
                paramAnonymous2l.add(0, i, 0, ((String)localIterator.next()).split("\\|\\|")[0]);
                i += 1;
              }
              AppMethodBeat.o(68977);
            }
          };
          locale.HrY = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68978);
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
              if (paramAnonymous2Int < WalletLqtSaveFetchUI.9.this.zMi.size())
              {
                paramAnonymous2MenuItem = ((String)WalletLqtSaveFetchUI.9.this.zMi.get(paramAnonymous2Int)).split("\\|\\|")[1];
                com.tencent.mm.wallet_core.ui.e.p(WalletLqtSaveFetchUI.this, paramAnonymous2MenuItem, false);
              }
              AppMethodBeat.o(68978);
            }
          };
          locale.csG();
          AppMethodBeat.o(68979);
        }
      }), i, ((SpannableString)localObject2).length(), 17);
      this.zLD.setText((CharSequence)localObject2);
      this.zLD.setClickable(true);
      this.zLD.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
    }
    for (;;)
    {
      if (this.mode == 1)
      {
        if ((this.zGh != null) && (this.zGh.ebv()))
        {
          this.zLA.setText(this.zLN);
          AppMethodBeat.o(69015);
          return;
          this.zLy.setText(getString(2131765024, new Object[] { this.zGh.field_bankName, this.zGh.field_bankcardTail }));
          break;
          label1093:
          localObject1 = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject1));
          u.a(new u.a()
          {
            public final void l(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(69008);
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(69007);
                  if ((WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this) != null) && (WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this) != null) && (WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).getTag() != null) && (WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).getTag().equals(WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bindSerial))) {
                    WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this).setImageBitmap(paramAnonymousBitmap);
                  }
                  AppMethodBeat.o(69007);
                }
              });
              AppMethodBeat.o(69008);
            }
          });
          if (localObject1 == null) {
            break label715;
          }
          localObject1 = f.a((Bitmap)localObject1, getResources().getDimensionPixelOffset(2131167003), getResources().getDimensionPixelOffset(2131167003), true, false);
          this.zLz.setImageBitmap((Bitmap)localObject1);
          break label715;
          label1165:
          this.zLC.setVisibility(8);
          continue;
          label1177:
          if (this.mode != 2) {
            continue;
          }
          findViewById(2131306747).setVisibility(8);
          this.zLK.setVisibility(8);
          this.zLC.setVisibility(8);
          this.zLB.setVisibility(8);
          localObject1 = v.dYO();
          if ((this.zGh != null) && (this.zGh.ebv()))
          {
            i = getIntent().getIntExtra("lqt_balance", 0);
            if (com.tencent.mm.platformtools.ab.hWD) {
              i = 50000000;
            }
            if (i <= 0) {
              continue;
            }
            localObject1 = getString(2131765410, new Object[] { Double.valueOf(jy(String.valueOf(i), "100")) });
            int j = ((String)localObject1).length();
            localObject1 = new SpannableString((String)localObject1 + " " + getString(2131765413));
            ((SpannableString)localObject1).setSpan(new a(new a.a()
            {
              public final void aHn()
              {
                AppMethodBeat.i(69006);
                WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).setText(com.tencent.mm.wallet_core.ui.e.D(WalletLqtSaveFetchUI.jA(i, "100")));
                WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
                WalletLqtSaveFetchUI.this.showWcKb();
                AppMethodBeat.o(69006);
              }
            }), j, ((SpannableString)localObject1).length(), 18);
            this.zLN = ((CharSequence)localObject1);
            this.zLA.setText((CharSequence)localObject1);
            continue;
          }
          if (((v)localObject1).dYP() == null) {}
          for (i = 0;; i = ((v)localObject1).dYP().DRI)
          {
            if (((v)localObject1).dYP() != null) {
              ((v)localObject1).dYP();
            }
            if (com.tencent.mm.platformtools.ab.hWD) {
              i = 100000000;
            }
            localObject1 = getString(2131765385, new Object[] { Double.valueOf(jy(String.valueOf(i), "100")) });
            this.zLN = ((CharSequence)localObject1);
            this.zLA.setText((CharSequence)localObject1);
            break;
          }
        }
        this.zLA.setText("");
      }
    }
    AppMethodBeat.o(69015);
  }
  
  private void sn(boolean paramBoolean)
  {
    AppMethodBeat.i(69022);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "check enable: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.zLY) });
    if ((!paramBoolean) || (this.zLY))
    {
      kJ(false);
      AppMethodBeat.o(69022);
      return;
    }
    if (this.mode == 1)
    {
      if (this.zLC.getVisibility() == 0)
      {
        if ((this.zLE.isChecked()) && (this.zLV))
        {
          kJ(true);
          AppMethodBeat.o(69022);
          return;
        }
        kJ(false);
        AppMethodBeat.o(69022);
        return;
      }
      if (this.zLV)
      {
        kJ(true);
        AppMethodBeat.o(69022);
      }
    }
    else
    {
      if ((this.zLV) && (this.zLI.getVisibility() == 0) && ((this.zLI.getSelectRedeemType() != null) || (this.zLI.getRedeemTypeList() == null) || (this.zLI.getRedeemTypeList().isEmpty())))
      {
        if (this.zLI.getSelectRedeemType() == null) {}
        for (Integer localInteger = null;; localInteger = Integer.valueOf(this.zLI.getSelectRedeemType().DYb))
        {
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletLqtSaveFetchUI", "redeem type: %s", new Object[] { localInteger });
          kJ(true);
          AppMethodBeat.o(69022);
          return;
        }
      }
      kJ(false);
    }
    AppMethodBeat.o(69022);
  }
  
  private void z(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(69014);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "update arrive time layout: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    if localif;
    if (this.mode == 2)
    {
      localObject = v.dYO().dYP();
      if (!this.zLI.zHR)
      {
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletLqtSaveFetchUI", "no cache!");
          AppMethodBeat.o(69014);
          return;
        }
        if (this.zGh.ebv())
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
          this.zLI.n(((buo)localObject).DRM, false);
          this.zLI.ats(paramString);
        }
        for (;;)
        {
          dZG();
          AppMethodBeat.o(69014);
          return;
          if (((buo)localObject).DRN != null)
          {
            localObject = ((buo)localObject).DRN.iterator();
            while (((Iterator)localObject).hasNext())
            {
              localif = (if)((Iterator)localObject).next();
              if (localif.CDx.equals(this.zGh.field_bindSerial))
              {
                com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                this.zLI.n(localif.CDN, false);
                this.zLI.ats(paramString);
              }
            }
          }
        }
      }
      if (paramBoolean)
      {
        if (!this.zGh.ebv()) {
          break label257;
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
        this.zLI.n(((buo)localObject).DRM, true);
      }
    }
    for (;;)
    {
      this.zLI.ats(paramString);
      AppMethodBeat.o(69014);
      return;
      label257:
      if (((buo)localObject).DRN != null)
      {
        localObject = ((buo)localObject).DRN.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localif = (if)((Iterator)localObject).next();
          if (localif.CDx.equals(this.zGh.field_bindSerial))
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
            this.zLI.n(localif.CDN, true);
          }
        }
      }
    }
  }
  
  public final void aEr()
  {
    AppMethodBeat.i(69029);
    if (this.ibM != null) {
      this.ibM.dismiss();
    }
    AppMethodBeat.o(69029);
  }
  
  public final void bk(float paramFloat) {}
  
  public final void dZC()
  {
    AppMethodBeat.i(69012);
    if (this.mode == 1)
    {
      this.zLO = com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.dYI();
      if (this.zLO == null)
      {
        com.tencent.mm.plugin.wallet.a.s.dZT();
        this.zLO = com.tencent.mm.plugin.wallet.a.s.dZU().zHd;
      }
      Object localObject;
      int i;
      if (this.zLO != null)
      {
        localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.dYJ();
        i = com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.dYK();
        if (i != 0) {
          break label189;
        }
        this.zLN = ((CharSequence)localObject);
        if (this.zLA != null) {
          this.zLA.setText(this.zLN);
        }
      }
      if (this.zLv != null) {
        this.zLv.setVisibility(0);
      }
      if (!bt.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zEQ))
      {
        this.tkE.setText(com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zEQ);
        this.tkE.setVisibility(0);
      }
      for (;;)
      {
        localObject = v.dYO().dYP();
        if ((localObject != null) && (((buo)localObject).DIo) && (((buo)localObject).DRO != null)) {
          af.a(getContext(), ((buo)localObject).DRO);
        }
        sm(true);
        AppMethodBeat.o(69012);
        return;
        label189:
        if (i == 1)
        {
          i = ((String)localObject).length();
          localObject = new SpannableString((String)localObject + getString(2131765384));
          ((SpannableString)localObject).setSpan(new a(new a.a()
          {
            public final void aHn()
            {
              AppMethodBeat.i(69004);
              WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).setText(com.tencent.mm.wallet_core.ui.e.D(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).AbU));
              WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
              WalletLqtSaveFetchUI.this.showWcKb();
              AppMethodBeat.o(69004);
            }
          }), i + 1, ((SpannableString)localObject).length(), 18);
          this.zLN = ((CharSequence)localObject);
          break;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletLqtSaveFetchUI", "unknown func: %s", new Object[] { Integer.valueOf(i) });
        this.zLN = ((CharSequence)localObject);
        break;
        this.tkE.setVisibility(8);
      }
    }
    if (this.zLI.zHR)
    {
      sm(false);
      AppMethodBeat.o(69012);
      return;
    }
    sm(true);
    AppMethodBeat.o(69012);
  }
  
  public final void dZH()
  {
    this.zLZ = false;
  }
  
  public final void dZI()
  {
    AppMethodBeat.i(69031);
    aq.az(this.vzw);
    aq.az(this.zMd);
    AppMethodBeat.o(69031);
  }
  
  public int getLayoutId()
  {
    return 2131495978;
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(69026);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.zLZ), Boolean.valueOf(this.mWcKeyboard.fjz()) });
    if ((!this.zLZ) && (this.mWcKeyboard.fjz()))
    {
      AppMethodBeat.o(69026);
      return true;
    }
    AppMethodBeat.o(69026);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69027);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "onActivityResult() requestCode:%s", new Object[] { Integer.valueOf(paramInt1) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.zLu.zFW.ie(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(69027);
      return;
    }
    if (paramIntent != null) {
      paramIntent.putExtra(ac.zFE, this.zLT);
    }
    ac localac = this.zLt;
    String str;
    Object localObject;
    if ((paramInt1 == ac.zFC) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra(ac.zFE);
      paramIntent = (Orders)paramIntent.getParcelableExtra("key_orders");
      if ((paramIntent != null) && (paramIntent.Afx != null) && (paramIntent.Afx.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s, reqkey: %s", new Object[] { Integer.valueOf(localac.hashCode()), Integer.valueOf(localac.accountType), paramIntent.dcE });
        localac.dcF = ((Orders.Commodity)paramIntent.Afx.get(0)).dcF;
        paramIntent = (String)localac.zFO.get(paramIntent.dcE);
        if (!bt.isNullOrNil(paramIntent)) {
          localac.zFI = paramIntent;
        }
        if ((localac.zFH instanceof WalletLqtSaveFetchUI))
        {
          ((WalletLqtSaveFetchUI)localac.zFH).zLZ = true;
          ((WalletLqtSaveFetchUI)localac.zFH).dZI();
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
        localac.zFH.showLoading(false);
        paramIntent = localac.zFH.getIntent().getStringExtra("operate_id");
        localObject = localac.zFG.zFy;
        com.tencent.mm.vending.g.g.a(localac.zFI, localac.dcF, Integer.valueOf(localac.zFJ), Integer.valueOf(localac.accountType), paramIntent, Integer.valueOf(localac.zFN)).c((com.tencent.mm.vending.c.a)localObject).f(new ac.7(localac, str)).a(new ac.6(localac));
      }
      AppMethodBeat.o(69027);
      return;
    }
    if ((paramInt1 == ac.zFD) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra(ac.zFE);
      localObject = paramIntent.getStringExtra("lqt_fetch_enc_pwd");
      paramIntent = paramIntent.getStringExtra("lqt_redeem_listid");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", new Object[] { Integer.valueOf(localac.hashCode()), Integer.valueOf(localac.accountType), paramIntent });
      if ((localac.zFH instanceof WalletLqtSaveFetchUI))
      {
        ((WalletLqtSaveFetchUI)localac.zFH).zLZ = true;
        ((WalletLqtSaveFetchUI)localac.zFH).dZI();
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", new Object[] { Integer.valueOf(localac.hashCode()), paramIntent });
      if (bt.isNullOrNil(localac.zFL))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", new Object[] { Integer.valueOf(localac.hashCode()), paramIntent });
        localac.zFL = paramIntent;
      }
      paramIntent = localac.zFH.getIntent().getStringExtra("operate_id");
      localac.zFH.showLoading(true);
      ab.c localc = localac.zFG.zFz;
      com.tencent.mm.vending.g.g.b(Integer.valueOf(localac.zFK), localObject, localac.zFL, Integer.valueOf(localac.accountType), paramIntent).c(localc).f(new ac.9(localac, str)).a(new ac.8(localac));
    }
    AppMethodBeat.o(69027);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69010);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131100705));
    hideActionbarLine();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
    this.zLw = ((WalletFormView)findViewById(2131301701));
    this.zLz = ((ImageView)findViewById(2131297166));
    this.zLA = ((TextView)findViewById(2131301698));
    this.zLB = ((TextView)findViewById(2131301699));
    this.zLx = ((TextView)findViewById(2131301702));
    this.zLy = ((TextView)findViewById(2131301638));
    this.zLH = ((TextView)findViewById(2131306836));
    this.tkE = ((TextView)findViewById(2131301706));
    this.zLM = ((TextView)findViewById(2131301700));
    this.zLC = ((ViewGroup)findViewById(2131301703));
    this.zLD = ((TextView)findViewById(2131301705));
    this.zLE = ((CheckBox)findViewById(2131301704));
    this.zLv = ((ViewGroup)findViewById(2131301985));
    this.zLF = ((TextView)findViewById(2131300742));
    this.zLG = ((TextView)findViewById(2131300743));
    this.zLI = ((WalletLqtArriveTimeLayout)findViewById(2131301696));
    this.zLJ = ((ScrollView)findViewById(2131301693));
    this.zLK = ((LinearLayout)findViewById(2131301675));
    this.zLL = ((TextView)findViewById(2131301676));
    this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
    int i = getIntent().getIntExtra("entrance_type", 0);
    this.zLt.mode = this.mode;
    this.zLt.zFN = i;
    this.zLP = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
    this.zLQ = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
    this.zLR = getIntent().getStringExtra("lqt_profile_wording");
    this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.afC();
      this.zLT = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FsE, ""));
      if (bt.isNullOrNil(this.zLT))
      {
        com.tencent.mm.kernel.g.afC();
        this.zLT = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FsD, ""));
      }
      this.zLU = getIntent().getStringExtra("card_serial");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", new Object[] { Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.zLT });
      this.zLw.getTitleTv().setText(ah.fkg());
      this.mWcKeyboard = ((WcPayKeyboard)findViewById(2131307020));
      paramBundle = (RelativeLayout.LayoutParams)this.mWcKeyboard.getLayoutParams();
      paramBundle.addRule(12);
      this.mWcKeyboard.setLayoutParams(paramBundle);
      if (this.mode != 1) {
        break label1073;
      }
      setWPKeyboard(this.zLw.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(2131765499));
      label622:
      if (com.tencent.mm.compatible.util.d.lh(27)) {
        this.zLw.fkI();
      }
      setWcKbHeightListener(this);
      if (this.mode != 1) {
        break label1108;
      }
      this.zLx.setText(getString(2131765491));
      this.zLH.setText(getString(2131765494));
      label678:
      this.zLw.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(68980);
          if (paramAnonymousEditable.toString().startsWith(".")) {
            paramAnonymousEditable.insert(0, "0");
          }
          String str = paramAnonymousEditable.toString();
          int i = str.indexOf(".");
          int j = str.length();
          if ((i >= 0) && (j - i > 3)) {
            WalletFormView.a(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getContentEt(), str, i + 3, j);
          }
          for (;;)
          {
            paramAnonymousEditable = paramAnonymousEditable.toString();
            WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, paramAnonymousEditable);
            WalletLqtSaveFetchUI.d(WalletLqtSaveFetchUI.this, paramAnonymousEditable);
            AppMethodBeat.o(68980);
            return;
            if (i > 12) {
              WalletFormView.a(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getContentEt(), str, 12, i);
            } else if ((i == -1) && (j > 12)) {
              WalletFormView.a(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getContentEt(), str, 12, j);
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
          AppMethodBeat.i(68981);
          if (paramAnonymousBoolean)
          {
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
            {
              WalletLqtSaveFetchUI.r(WalletLqtSaveFetchUI.this);
              AppMethodBeat.o(68981);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1) {
              AppMethodBeat.o(68981);
            }
          }
          else
          {
            WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).scrollTo(0, 0);
            if ((WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) && (bt.isNullOrNil(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText()))) {
              WalletLqtSaveFetchUI.t(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(68981);
        }
      });
      paramBundle = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68991);
          if (bt.aS(WalletLqtSaveFetchUI.u(WalletLqtSaveFetchUI.this)) < 800L)
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
            AppMethodBeat.o(68991);
            return;
          }
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, bt.GC());
          int j = WalletLqtSaveFetchUI.jB(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText(), "100");
          if (j > 0)
          {
            WalletLqtSaveFetchUI.this.hideWcKb();
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
              if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zER))
              {
                AppMethodBeat.o(68991);
                return;
              }
              paramAnonymousView = WalletLqtSaveFetchUI.w(WalletLqtSaveFetchUI.this).zFT;
              com.tencent.mm.vending.g.g.h(Integer.valueOf(j), Integer.valueOf(WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this)), WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this)).c(paramAnonymousView).f(new WalletLqtSaveFetchUI.13.2(this, j)).a(new WalletLqtSaveFetchUI.13.1(this));
              AppMethodBeat.o(68991);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
              if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV.zES))
              {
                AppMethodBeat.o(68991);
                return;
              }
              ad.a locala = null;
              paramAnonymousView = locala;
              if (WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this) != null)
              {
                paramAnonymousView = locala;
                if (!WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).ebv())
                {
                  paramAnonymousView = new ia();
                  paramAnonymousView.szi = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankName;
                  paramAnonymousView.dca = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankcardType;
                  paramAnonymousView.CDx = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bindSerial;
                  paramAnonymousView.uoo = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankcardTail;
                }
              }
              int i = -1;
              if (WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getSelectRedeemType() != null) {
                i = WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getSelectRedeemType().DYb;
              }
              locala = WalletLqtSaveFetchUI.w(WalletLqtSaveFetchUI.this).zFU;
              com.tencent.mm.vending.g.g.b(Integer.valueOf(j), Integer.valueOf(WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this)), Integer.valueOf(i), paramAnonymousView).c(locala).f(new WalletLqtSaveFetchUI.13.4(this, j)).a(new WalletLqtSaveFetchUI.13.3(this));
            }
          }
          AppMethodBeat.o(68991);
        }
      };
      this.zLw.getContentEt().setOnEditorActionListener(new WalletLqtSaveFetchUI.14(this, paramBundle));
      if (!bt.isNullOrNil(this.zLR)) {
        this.mWcKeyboard.setTipText(this.zLR);
      }
      if (this.mode == 2) {
        this.zLI.setCallback(new WalletLqtSaveFetchUI.15(this));
      }
      this.zLA.setText("");
      this.zLA.setClickable(true);
      this.zLA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      sn(false);
      this.zLL.setClickable(true);
      this.zLL.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      if (this.mode != 1) {
        break label1157;
      }
      this.zLv.setVisibility(4);
      if (i != 8) {
        break label1147;
      }
      setMMTitle(2131765498);
      this.mWcKeyboard.showNormalStWcKb();
    }
    for (;;)
    {
      if (this.zLy.findViewById(2131306835) != null) {
        this.zLy.findViewById(2131306835).setVisibility(8);
      }
      paramBundle = new WalletLqtSaveFetchUI.1(this);
      this.zLy.setOnClickListener(paramBundle);
      if (findViewById(2131297947) != null) {
        findViewById(2131297947).setOnClickListener(paramBundle);
      }
      dZC();
      paramBundle = com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV;
      s.a locala = this.zMc;
      paramBundle.zEU.add(locala);
      this.zLv.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(68982);
          if ((WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this).isShown()) && (WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).fjx()))
          {
            WalletLqtSaveFetchUI.d(WalletLqtSaveFetchUI.this).fjv();
            AppMethodBeat.o(68982);
            return true;
          }
          AppMethodBeat.o(68982);
          return false;
        }
      });
      this.state = 1;
      paramBundle = getIntent().getStringExtra("fill_money");
      if (bt.getDouble(paramBundle, 0.0D) > 0.0D)
      {
        this.zLw.setText(paramBundle);
        bQ(paramBundle, false);
      }
      if ((this.mode == 2) && (v.dYO().dYP() == null)) {
        showLoading(false);
      }
      AppMethodBeat.o(69010);
      return;
      com.tencent.mm.kernel.g.afC();
      this.zLT = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FsF, ""));
      break;
      label1073:
      this.isVKBFirstTimeShown = false;
      setWPKeyboard(this.zLw.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(2131765415));
      break label622;
      label1108:
      if (this.mode != 2) {
        break label678;
      }
      this.zLx.setText(getString(2131765397));
      this.zLH.setText(getString(2131765402));
      break label678;
      label1147:
      setMMTitle(2131765499);
      continue;
      label1157:
      setMMTitle(2131765415);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69030);
    super.onDestroy();
    dZI();
    com.tencent.mm.plugin.wallet.balance.model.lqt.s locals = com.tencent.mm.plugin.wallet.balance.model.lqt.s.zEV;
    s.a locala = this.zMc;
    locals.zEU.remove(locala);
    this.zLt = null;
    this.zLu = null;
    AppMethodBeat.o(69030);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(69025);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "onDialogDismiss()");
    aq.n(this.vzw, 300L);
    AppMethodBeat.o(69025);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69018);
    if ((this.mWcKeyboard != null) && (this.mWcKeyboard.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(69018);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(69018);
    return bool;
  }
  
  public void onNewIntent(final Intent paramIntent)
  {
    AppMethodBeat.i(69017);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    paramIntent = dZF();
    this.zLu.zFW.ie(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(69017);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69024);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "onPause()");
    if (!this.mWcKeyboard.fjy()) {
      this.state = 3;
    }
    AppMethodBeat.o(69024);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69023);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      aq.n(this.zMd, 300L);
    }
    this.state = 2;
    AppMethodBeat.o(69023);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(69028);
    ac localac = this.zLt;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
    {
      com.tencent.mm.plugin.wallet.a.s.dZT();
      localac.zFM = com.tencent.mm.plugin.wallet.a.s.dZU().zHd;
      if (localac.hZi != null)
      {
        localac.hZi.D(new Object[] { paramn });
        localac.hZi.resume();
      }
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "onSceneEnd");
    dZC();
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    AppMethodBeat.o(69028);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI
 * JD-Core Version:    0.7.0.1
 */