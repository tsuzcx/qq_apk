package com.tencent.mm.plugin.wallet.balance.ui.lqt;

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
import com.tencent.mm.g.a.kj;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.aa;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ab.c;
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
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.dho;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.protocal.protobuf.il;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
  private aa AXS;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ab AXT;
  private Bankcard AYu;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ac BdI;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ad BdJ;
  private ViewGroup BdK;
  private WalletFormView BdL;
  private TextView BdM;
  private TextView BdN;
  private TextView BdO;
  private ImageView BdP;
  private TextView BdQ;
  private TextView BdR;
  private ViewGroup BdS;
  private TextView BdT;
  private CheckBox BdU;
  private TextView BdV;
  private TextView BdW;
  private TextView BdX;
  private WalletLqtArriveTimeLayout BdY;
  private ScrollView BdZ;
  private LinearLayout Bea;
  private TextView Beb;
  private TextView Bec;
  private CharSequence Bed;
  private Bankcard Bee;
  private int Bef;
  private String Beg;
  private String Beh;
  private long Bei;
  private String Bej;
  private String Bek;
  private boolean Bel;
  private List<Bankcard> Bem;
  private boolean Ben;
  private boolean Beo;
  protected boolean Bep;
  private String Beq;
  private boolean Ber;
  private s.a Bes;
  private Runnable Bet;
  private int accountType;
  private Dialog iBT;
  private int mode;
  private int state;
  private HashMap<String, Integer> ufk;
  private TextView usX;
  private com.tencent.mm.sdk.b.c<kj> vsr;
  public Runnable wJB;
  
  public WalletLqtSaveFetchUI()
  {
    AppMethodBeat.i(69009);
    this.AXS = ((aa)aq(aa.class));
    this.AXT = ((com.tencent.mm.plugin.wallet.balance.model.lqt.ab)am(com.tencent.mm.plugin.wallet.balance.model.lqt.ab.class));
    this.BdI = new com.tencent.mm.plugin.wallet.balance.model.lqt.ac(this.AXS, this.AXT, this);
    this.BdJ = new com.tencent.mm.plugin.wallet.balance.model.lqt.ad(this.BdI);
    this.Bei = -1L;
    this.Bel = false;
    this.Ben = true;
    this.Beo = false;
    this.Bep = false;
    this.Beq = "";
    this.Ber = false;
    this.Bes = new s.a()
    {
      public final void eoi()
      {
        AppMethodBeat.i(69002);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "cache updated");
        WalletLqtSaveFetchUI.this.hideLoading();
        WalletLqtSaveFetchUI.this.eoY();
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
          if (!bs.isNullOrNil(str)) {
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, str);
          }
        }
        AppMethodBeat.o(69002);
      }
    };
    this.ufk = new HashMap();
    this.state = 0;
    this.wJB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207230);
        if ((WalletLqtSaveFetchUI.y(WalletLqtSaveFetchUI.this) == 2) && (WalletLqtSaveFetchUI.this.isHandleAutoShowNormalStWcKb())) {
          WalletLqtSaveFetchUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(207230);
      }
    };
    this.Bet = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207231);
        WalletLqtSaveFetchUI.this.showNormalStWcKb();
        AppMethodBeat.o(207231);
      }
    };
    this.vsr = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(69009);
  }
  
  private void A(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(69014);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WalletLqtSaveFetchUI", "update arrive time layout: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    il localil;
    if (this.mode == 2)
    {
      localObject = v.eok().eol();
      if (!this.BdY.Bad)
      {
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WalletLqtSaveFetchUI", "no cache!");
          AppMethodBeat.o(69014);
          return;
        }
        if (this.AYu.eqR())
        {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
          this.BdY.o(((bzf)localObject).Fog, false);
          this.BdY.ayK(paramString);
        }
        for (;;)
        {
          this.BdY.setVisibility(4);
          epc();
          AppMethodBeat.o(69014);
          return;
          if (((bzf)localObject).Foh != null)
          {
            localObject = ((bzf)localObject).Foh.iterator();
            while (((Iterator)localObject).hasNext())
            {
              localil = (il)((Iterator)localObject).next();
              if (localil.DVW.equals(this.AYu.field_bindSerial))
              {
                com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                this.BdY.o(localil.DWm, false);
                this.BdY.ayK(paramString);
              }
            }
          }
        }
      }
      if (paramBoolean)
      {
        if (!this.AYu.eqR()) {
          break label268;
        }
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
        this.BdY.o(((bzf)localObject).Fog, true);
      }
    }
    for (;;)
    {
      this.BdY.setVisibility(4);
      this.BdY.ayK(paramString);
      AppMethodBeat.o(69014);
      return;
      label268:
      if (((bzf)localObject).Foh != null)
      {
        localObject = ((bzf)localObject).Foh.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localil = (il)((Iterator)localObject).next();
          if (localil.DVW.equals(this.AYu.field_bindSerial))
          {
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
            this.BdY.o(localil.DWm, true);
          }
        }
      }
    }
  }
  
  private boolean ayR(String paramString)
  {
    AppMethodBeat.i(69011);
    if (!bs.isNullOrNil(paramString)) {
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
          localObject1 = new com.tencent.mm.ui.widget.a.d.a(getContext());
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).yf(false);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).aRI(paramString);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).aRP(str1);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).aRO(str2);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).a(true, new WalletLqtSaveFetchUI.31(this, (String)localObject2));
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).fvp().show();
          AppMethodBeat.o(69011);
          return true;
        }
      }
      catch (JSONException paramString)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69011);
    return false;
  }
  
  private void bX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182506);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "update tips: %s", new Object[] { paramString });
    long l = com.tencent.mm.wallet_core.ui.e.mk(String.valueOf(paramString), "100");
    Object localObject;
    if (l > 0L) {
      if (this.mode == 1) {
        if (this.AYu != null) {
          if (this.AYu.eqR())
          {
            if ((this.Bee != null) && (l > jW(this.Bee.Buo, "100")))
            {
              this.BdQ.setText(getString(2131765492));
              this.BdQ.setTextColor(getResources().getColor(2131099804));
              this.Bel = false;
              to(false);
              if (l > 0L) {
                break label1308;
              }
              this.Ben = true;
              AppMethodBeat.o(182506);
              return;
            }
            if ((com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AXc >= 0) && (l > com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AXc) && (!bs.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AWZ)) && (!bs.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AXa)) && (!bs.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AXb)))
            {
              paramString = new q(new q.a()
              {
                public final void dK(View paramAnonymousView)
                {
                  AppMethodBeat.i(207227);
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                  com.tencent.mm.wallet_core.ui.e.a(WalletLqtSaveFetchUI.this.getContext(), com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AXb, true, 1);
                  AppMethodBeat.o(207227);
                }
              });
              localObject = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject).append(com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AWZ);
              ((SpannableStringBuilder)localObject).append(com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AXa);
              ((SpannableStringBuilder)localObject).setSpan(paramString, com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AWZ.length(), ((SpannableStringBuilder)localObject).length(), 18);
              if ((this.BdQ.getText() == null) || (!this.BdQ.getText().equals(((SpannableStringBuilder)localObject).toString()))) {
                com.tencent.mm.plugin.report.service.h.wUl.f(17084, new Object[] { Integer.valueOf(9) });
              }
              this.BdQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(getContext()));
              this.BdQ.setClickable(true);
              this.BdQ.setText((CharSequence)localObject);
            }
          }
        }
      }
    }
    for (;;)
    {
      this.BdQ.setTextColor(getResources().getColor(2131099734));
      this.Bel = false;
      to(false);
      break;
      this.BdQ.setText(this.Bed);
      this.BdQ.setTextColor(getResources().getColor(2131099734));
      this.Bel = true;
      to(true);
      break;
      if ((this.AYu.field_dayQuotaKind > 0.0D) && (l > jW(this.AYu.field_dayQuotaKind, "100")))
      {
        this.BdQ.setText(getString(2131765493));
        this.BdQ.setTextColor(getResources().getColor(2131099804));
        this.Bel = false;
        to(false);
        break;
      }
      this.BdQ.setText("");
      this.Bel = true;
      to(true);
      break;
      this.Bel = true;
      to(true);
      break;
      if (this.mode != 2) {
        break;
      }
      localObject = v.eok();
      int k;
      label598:
      int i;
      int j;
      if (((v)localObject).eol() == null)
      {
        k = 0;
        if ((this.AYu == null) || (!this.AYu.eqR())) {
          break label713;
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
            this.BdQ.setText(getString(2131765398));
            this.BdQ.setTextColor(getResources().getColor(2131099804));
            this.Bel = false;
            eoZ();
            to(false);
            this.Bea.setVisibility(8);
            break;
            k = ((v)localObject).eol().Foc;
            break label598;
            label713:
            bzf localbzf = v.eok().eol();
            if (localbzf == null)
            {
              i = 0;
              j = 0;
              continue;
            }
            i = localbzf.Foe;
            j = 0;
            continue;
          }
          this.BdQ.setText(this.Bed);
          this.BdQ.setTextColor(getResources().getColor(2131099734));
          this.Bel = true;
          A(paramBoolean, paramString);
          to(true);
          this.Bea.setVisibility(8);
          break;
        }
      }
      if (l > k)
      {
        this.BdQ.setText(getString(2131765398));
        this.BdQ.setTextColor(getResources().getColor(2131099804));
        this.Bea.setVisibility(8);
        this.Bel = false;
        eoZ();
        to(false);
        this.Bea.setVisibility(8);
        break;
      }
      if (l > i)
      {
        paramString = getString(2131765385, new Object[] { Double.valueOf(jV(String.valueOf(k), "100")) });
        this.BdQ.setTextColor(getResources().getColor(2131099734));
        this.BdQ.setText(paramString);
        this.Bea.setVisibility(0);
        paramString = getString(2131765409, new Object[] { Double.valueOf(jV(String.valueOf(i), "100")) });
        i = paramString.length();
        paramString = new SpannableString(paramString + getString(2131765412));
        paramString.setSpan(new a(new a.a()
        {
          public final void aOb()
          {
            AppMethodBeat.i(207228);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, this.BeF.eol());
            AppMethodBeat.o(207228);
          }
        }), i, paramString.length(), 18);
        this.Beb.setText(paramString);
        this.Bel = false;
        eoZ();
        to(false);
        break;
      }
      if ((this.AYu != null) && (!this.AYu.eqR()) && (this.AYu.field_dayQuotaKind > 0.0D) && (l > jW(this.AYu.field_dayQuotaKind, "100")))
      {
        this.Bea.setVisibility(0);
        this.Beb.setText(getString(2131765400, new Object[] { Double.valueOf(this.AYu.field_dayQuotaKind) }));
        this.Bel = false;
        eoZ();
        to(false);
        break;
      }
      this.BdQ.setText(this.Bed);
      this.BdQ.setTextColor(getResources().getColor(2131099734));
      this.Bel = true;
      A(paramBoolean, paramString);
      to(true);
      this.Bea.setVisibility(8);
      break;
      if (this.mode == 1)
      {
        if ((this.AYu != null) && (this.AYu.eqR())) {
          this.BdQ.setText(this.Bed);
        } else {
          this.BdQ.setText("");
        }
      }
      else
      {
        this.BdQ.setText(this.Bed);
        eoZ();
      }
    }
    label1308:
    this.Ben = false;
    AppMethodBeat.o(182506);
  }
  
  private void eoZ()
  {
    AppMethodBeat.i(69013);
    WalletLqtArriveTimeLayout localWalletLqtArriveTimeLayout = this.BdY;
    localWalletLqtArriveTimeLayout.Bad = false;
    if (localWalletLqtArriveTimeLayout.AZZ != null) {
      localWalletLqtArriveTimeLayout.AZZ.clear();
    }
    localWalletLqtArriveTimeLayout.Bab = null;
    localWalletLqtArriveTimeLayout.Baa.clear();
    localWalletLqtArriveTimeLayout.setVisibility(4);
    AppMethodBeat.o(69013);
  }
  
  private void epa()
  {
    AppMethodBeat.i(207244);
    this.ufk.clear();
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this, 2, true);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi;
    this.Bem = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Tn(this.mode);
    localObject1 = null;
    if (this.AYu != null) {
      localObject1 = this.AYu.field_bindSerial;
    }
    Object localObject2 = localObject1;
    if (bs.isNullOrNil((String)localObject1))
    {
      localObject2 = this.Bej;
      if (bs.isNullOrNil(this.Bej)) {
        com.tencent.mm.kernel.g.agS();
      }
    }
    for (localObject1 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQv, "");; localObject1 = localObject2)
    {
      int i = 0;
      int k;
      for (int j = 0; i < this.Bem.size(); j = k)
      {
        localObject2 = (Bankcard)this.Bem.get(i);
        k = j;
        if (!bs.isNullOrNil(((Bankcard)localObject2).field_bindSerial))
        {
          k = j;
          if (((String)localObject1).equals(((Bankcard)localObject2).field_bindSerial)) {
            k = i;
          }
        }
        i += 1;
      }
      locale.ISu = new n.c()
      {
        public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(207203);
          int j = WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).size();
          int i = 0;
          final Bankcard localBankcard;
          Object localObject1;
          if (i < j)
          {
            localBankcard = (Bankcard)WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).get(i);
            localObject1 = com.tencent.mm.plugin.wallet_core.d.b.i(WalletLqtSaveFetchUI.this, localBankcard.field_bankcardType, localBankcard.eqQ());
            if (localObject1 == null) {
              break label917;
            }
          }
          label917:
          for (final String str1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject1).vkI;; str1 = "")
          {
            Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str1));
            com.tencent.mm.platformtools.u.a(new u.a()
            {
              public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(207200);
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(207199);
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletLqtSaveFetchUI.3.1.this.vvG });
                    if (WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).containsKey(paramAnonymous2String))
                    {
                      int i = ((Integer)WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).get(paramAnonymous2String)).intValue();
                      if ((i < WalletLqtSaveFetchUI.3.1.this.ufs.size()) && (WalletLqtSaveFetchUI.3.1.this.ufs.getItem(i) != null))
                      {
                        WalletLqtSaveFetchUI.3.1.this.ufs.getItem(i).setIcon(new BitmapDrawable(f.a(paramAnonymous2Bitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), true, false)));
                        WalletLqtSaveFetchUI.3.this.iSj.fvu();
                      }
                    }
                    AppMethodBeat.o(207199);
                  }
                });
                AppMethodBeat.o(207200);
              }
            });
            Drawable localDrawable = null;
            Object localObject4 = null;
            localObject1 = "";
            if (!bs.isNullOrNil(localBankcard.field_forbidWord)) {
              localObject1 = localBankcard.field_forbidWord;
            }
            Object localObject3;
            Object localObject2;
            label161:
            String str2;
            if (bs.isNullOrNil(localBankcard.field_forbid_title))
            {
              localObject3 = new SpannableStringBuilder((CharSequence)localObject1);
              localObject2 = localObject1;
              localObject1 = localObject3;
              localObject3 = localObject1;
              if (bs.aj((CharSequence)localObject1))
              {
                localObject3 = localObject1;
                if (!bs.isNullOrNil(localBankcard.field_prompt_info_prompt_text))
                {
                  localObject1 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
                  localObject3 = localObject1;
                  if (!bs.isNullOrNil(localBankcard.field_prompt_info_jump_text))
                  {
                    localObject3 = localObject1;
                    if (!bs.isNullOrNil(localBankcard.field_prompt_info_jump_url))
                    {
                      ((SpannableStringBuilder)localObject1).append(localBankcard.field_prompt_info_jump_text);
                      ((SpannableStringBuilder)localObject1).setSpan(new q(new q.a()
                      {
                        public final void dK(View paramAnonymous2View)
                        {
                          AppMethodBeat.i(207202);
                          com.tencent.mm.wallet_core.ui.e.aT(WalletLqtSaveFetchUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
                          com.tencent.mm.plugin.report.service.h.wUl.f(20216, new Object[] { Integer.valueOf(2), localBankcard.field_prompt_info_jump_url });
                          AppMethodBeat.o(207202);
                        }
                      }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject1).length(), 33);
                      localObject3 = localObject1;
                    }
                  }
                }
              }
              str2 = localBankcard.field_desc;
              if (!localBankcard.eqR()) {
                break label602;
              }
              localObject1 = str2;
              if (localBankcard.Buo >= 0.0D) {
                localObject1 = str2 + WalletLqtSaveFetchUI.this.getString(2131764999, new Object[] { com.tencent.mm.wallet_core.ui.e.D(localBankcard.Buo) });
              }
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), localObject1, localObject3 });
              localDrawable = WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234612);
              if (bs.isNullOrNil((String)localObject2)) {
                break label596;
              }
            }
            label596:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousl.b(i, (CharSequence)localObject1, (CharSequence)localObject3, localDrawable, bool);
              localObject1 = localObject4;
              if (localObject1 == null) {
                WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).put(str1, Integer.valueOf(i));
              }
              i += 1;
              break;
              localObject2 = (String)localObject1 + " ";
              localObject1 = new SpannableStringBuilder((String)localObject2 + localBankcard.field_forbid_title);
              localObject3 = new com.tencent.mm.plugin.wallet_core.ui.l(WalletLqtSaveFetchUI.this)
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(207201);
                  paramAnonymous2View = localBankcard.field_forbid_url;
                  Intent localIntent = new Intent();
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "go to url %s", new Object[] { paramAnonymous2View });
                  localIntent.putExtra("rawUrl", paramAnonymous2View);
                  localIntent.putExtra("geta8key_username", com.tencent.mm.model.u.axw());
                  localIntent.putExtra("pay_channel", 1);
                  com.tencent.mm.wallet_core.ui.e.al(WalletLqtSaveFetchUI.this.getContext(), localIntent);
                  AppMethodBeat.o(207201);
                }
              };
              int k = ((String)localObject2).length();
              int m = ((String)localObject2).length() + localBankcard.field_forbid_title.length();
              ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(WalletLqtSaveFetchUI.this.getResources().getColor(2131100547)), k, m, 33);
              ((SpannableStringBuilder)localObject1).setSpan(localObject3, k, m, 33);
              break label161;
            }
            label602:
            localObject1 = localDrawable;
            if (localBitmap != null) {
              localObject1 = f.a(localBitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), true, false);
            }
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localObject3 });
            if (localObject1 == null)
            {
              localObject4 = null;
              label680:
              if (bs.isNullOrNil((String)localObject2)) {
                break label722;
              }
            }
            label722:
            for (bool = true;; bool = false)
            {
              paramAnonymousl.b(i, str2, (CharSequence)localObject3, (Drawable)localObject4, bool);
              break;
              localObject4 = new BitmapDrawable((Bitmap)localObject1);
              break label680;
            }
            localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi;
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              bool = true;
              ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).ti(bool);
              if (!bool) {
                break label803;
              }
              localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).AWS;
              label766:
              if (localObject1 == null) {
                break label813;
              }
            }
            label803:
            label813:
            for (bool = ((brl)localObject1).Fgy;; bool = false)
            {
              if (!bool) {
                break label819;
              }
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
              AppMethodBeat.o(207203);
              return;
              bool = false;
              break;
              localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).AWT;
              break label766;
            }
            label819:
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              paramAnonymousl.a(j, WalletLqtSaveFetchUI.this.getString(2131765496), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234603), false);
              AppMethodBeat.o(207203);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) {
              paramAnonymousl.a(j, WalletLqtSaveFetchUI.this.getString(2131765404), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234603), false);
            }
            AppMethodBeat.o(207203);
            return;
          }
        }
      };
      locale.Ihj = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(207204);
          WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).clear();
          AppMethodBeat.o(207204);
        }
      };
      locale.ISv = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(207205);
          if (locale != null)
          {
            locale.bmi();
            if (paramAnonymousInt < WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).size())
            {
              paramAnonymousMenuItem = (Bankcard)WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).get(paramAnonymousInt);
              WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, paramAnonymousMenuItem.field_bindSerial);
              WalletLqtSaveFetchUI.n(WalletLqtSaveFetchUI.this);
              if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
              {
                WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).dtH();
                AppMethodBeat.o(207205);
                return;
              }
              WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText());
              AppMethodBeat.o(207205);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
              AppMethodBeat.o(207205);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) {
              WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(207205);
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
        locale.whK = true;
        locale.irP = j;
        locale.JfJ = true;
        locale.J((View)localObject1, false);
        locale.cED();
        AppMethodBeat.o(207244);
        return;
        ((TextView)((View)localObject1).findViewById(2131301708)).setText(2131765396);
        ((TextView)((View)localObject1).findViewById(2131301707)).setText(2131765395);
      }
    }
  }
  
  private List<Bankcard> epb()
  {
    AppMethodBeat.i(69016);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tg(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.epp();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.epq().esy();
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
        if (localBankcard.eqR())
        {
          com.tencent.mm.plugin.wallet.a.s.epp();
          if (!com.tencent.mm.plugin.wallet.a.s.epq().esc())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.eqR()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((this.mode == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.eqR()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label200:
    AppMethodBeat.o(69016);
    return localObject2;
  }
  
  private void epc()
  {
    AppMethodBeat.i(69019);
    this.BdZ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207226);
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        WalletLqtSaveFetchUI.this.findViewById(2131301702).getLocationInWindow(arrayOfInt1);
        WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).getLocationInWindow(arrayOfInt2);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
        WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
        AppMethodBeat.o(207226);
      }
    }, 100L);
    AppMethodBeat.o(69019);
  }
  
  private static double jV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69032);
    try
    {
      if (bs.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
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
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
      AppMethodBeat.o(69032);
    }
  }
  
  private static int jW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69033);
    try
    {
      double d1 = bs.getDouble(paramString1, 0.0D);
      double d2 = bs.getDouble(paramString2, 0.0D);
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
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
      AppMethodBeat.o(69033);
    }
    return 0;
  }
  
  private void ln(boolean paramBoolean)
  {
    AppMethodBeat.i(69021);
    this.mWcKeyboard.yw(paramBoolean);
    AppMethodBeat.o(69021);
  }
  
  private void tn(boolean paramBoolean)
  {
    AppMethodBeat.i(69015);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tg(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.epp();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.epq().esy();
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
        if (localBankcard.eqR())
        {
          com.tencent.mm.plugin.wallet.a.s.epp();
          if (!com.tencent.mm.plugin.wallet.a.s.epq().esc())
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
      if (!bs.isNullOrNil(this.Bek))
      {
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject1 = (Bankcard)((List)localObject2).get(i);
          if ((!bs.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.Bek.equals(((Bankcard)localObject1).field_bindSerial))) {
            this.AYu = ((Bankcard)localObject1);
          }
          i += 1;
        }
      }
      if ((bs.isNullOrNil(this.Bek)) || (this.AYu == null))
      {
        localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi;
        if (this.mode == 1) {}
        for (bool = true;; bool = false)
        {
          this.AYu = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tf(bool);
          if ((bs.isNullOrNil(this.Bej)) || (this.AYu != null)) {
            break;
          }
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = (Bankcard)((List)localObject2).get(i);
            if ((!bs.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.Bej.equals(((Bankcard)localObject1).field_bindSerial))) {
              this.AYu = ((Bankcard)localObject1);
            }
            i += 1;
          }
        }
      }
    }
    else if (!bs.isNullOrNil(this.Bej))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = (Bankcard)((List)localObject2).get(i);
        if ((!bs.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.Bej.equals(((Bankcard)localObject1).field_bindSerial))) {
          this.AYu = ((Bankcard)localObject1);
        }
        i += 1;
      }
    }
    if (this.AYu != null) {}
    for (localObject1 = this.AYu.field_bindSerial;; localObject1 = "")
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "defaultBankcard: %s, save mCurrentSerial: %s, useDefault: %s", new Object[] { localObject1, this.Bej, Boolean.valueOf(paramBoolean) });
      if (this.AYu != null) {
        break;
      }
      com.tencent.mm.plugin.wallet.a.s.epp();
      this.AYu = com.tencent.mm.plugin.wallet.a.s.epq().AZp;
      if (this.AYu != null) {
        break;
      }
      finish();
      AppMethodBeat.o(69015);
      return;
    }
    if (this.AYu.eqR())
    {
      this.BdN.setText(this.AYu.field_desc);
      this.BdN.setText(this.AYu.field_desc);
      this.BdN.setVisibility(0);
      this.BdP.setTag(this.AYu.field_bindSerial);
      if (this.BdP != null)
      {
        localObject1 = "";
        localObject2 = com.tencent.mm.plugin.wallet_core.d.b.i(this, this.AYu.field_bankcardType, this.AYu.eqQ());
        if (localObject2 != null) {
          localObject1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject2).vkI;
        }
        this.BdP.setImageBitmap(null);
        if (!this.AYu.eqR()) {
          break label1279;
        }
        this.BdP.setImageResource(2131234612);
      }
      label714:
      this.BdV.setVisibility(8);
      this.BdW.setVisibility(8);
      if ((this.mode != 2) && (this.mode == 1) && (!this.AYu.eqR()) && (!bs.isNullOrNil(this.AYu.field_avail_save_wording)))
      {
        this.BdV.setText(this.AYu.field_avail_save_wording);
        this.BdV.setVisibility(0);
      }
      if (this.mode != 1) {
        break label1363;
      }
      localObject1 = getIntent().getStringArrayListExtra("lqt_protocol_list");
      paramBoolean = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0) || (!paramBoolean)) {
        break label1351;
      }
      this.BdS.setVisibility(0);
      this.BdU.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
      this.BdS.setOnClickListener(new WalletLqtSaveFetchUI.8(this));
      this.BdU.setOnCheckedChangeListener(new WalletLqtSaveFetchUI.9(this));
      localObject2 = getString(2131765483);
      i = ((String)localObject2).length();
      localObject2 = new SpannableString((String)localObject2 + getString(2131765484));
      ((SpannableString)localObject2).setSpan(new a(new a.a()
      {
        public final void aOb()
        {
          AppMethodBeat.i(207212);
          com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(WalletLqtSaveFetchUI.this, 1, false);
          locale.ISu = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(207210);
              Iterator localIterator = WalletLqtSaveFetchUI.10.this.Bez.iterator();
              int i = 0;
              while (localIterator.hasNext())
              {
                paramAnonymous2l.add(0, i, 0, ((String)localIterator.next()).split("\\|\\|")[0]);
                i += 1;
              }
              AppMethodBeat.o(207210);
            }
          };
          locale.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(207211);
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
              if (paramAnonymous2Int < WalletLqtSaveFetchUI.10.this.Bez.size())
              {
                paramAnonymous2MenuItem = ((String)WalletLqtSaveFetchUI.10.this.Bez.get(paramAnonymous2Int)).split("\\|\\|")[1];
                com.tencent.mm.wallet_core.ui.e.o(WalletLqtSaveFetchUI.this, paramAnonymous2MenuItem, false);
              }
              AppMethodBeat.o(207211);
            }
          };
          locale.cED();
          AppMethodBeat.o(207212);
        }
      }), i, ((SpannableString)localObject2).length(), 17);
      this.BdT.setText((CharSequence)localObject2);
      this.BdT.setClickable(true);
      this.BdT.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
    }
    for (;;)
    {
      if (this.mode == 1)
      {
        if ((this.AYu != null) && (this.AYu.eqR()))
        {
          this.BdQ.setText(this.Bed);
          localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi;
          ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).ti(true);
          localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).AWS;
          if (localObject1 != null)
          {
            if ((((brl)localObject1).FgF != null) && (!bs.isNullOrNil(((brl)localObject1).FgF.FvM)))
            {
              localObject2 = new SpannableStringBuilder(((brl)localObject1).FgF.FvM);
              if ((!bs.isNullOrNil(((brl)localObject1).FgF.FvN)) && (!bs.isNullOrNil(((brl)localObject1).FgF.nWj)))
              {
                ((SpannableStringBuilder)localObject2).append(((brl)localObject1).FgF.FvN);
                ((SpannableStringBuilder)localObject2).setSpan(new q(new q.a()
                {
                  public final void dK(View paramAnonymousView)
                  {
                    AppMethodBeat.i(207198);
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                    com.tencent.mm.wallet_core.ui.e.a(WalletLqtSaveFetchUI.this.getContext(), this.Bev.FgF.nWj, true, 1);
                    com.tencent.mm.plugin.report.service.h.wUl.f(20216, new Object[] { Integer.valueOf(1), this.Bev.FgF.nWj });
                    AppMethodBeat.o(207198);
                  }
                }), ((brl)localObject1).FgF.FvM.length(), ((SpannableStringBuilder)localObject2).length(), 18);
              }
              this.BdO.setText((CharSequence)localObject2);
              this.BdO.setClickable(true);
              this.BdO.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(getContext()));
              this.BdO.setVisibility(0);
              AppMethodBeat.o(69015);
              return;
              this.BdN.setText(getString(2131765024, new Object[] { this.AYu.field_bankName, this.AYu.field_bankcardTail }));
              break;
              label1279:
              localObject1 = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject1));
              com.tencent.mm.platformtools.u.a(new u.a()
              {
                public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
                {
                  AppMethodBeat.i(69008);
                  ap.f(new Runnable()
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
                break label714;
              }
              localObject1 = f.a((Bitmap)localObject1, getResources().getDimensionPixelOffset(2131167003), getResources().getDimensionPixelOffset(2131167003), true, false);
              this.BdP.setImageBitmap((Bitmap)localObject1);
              break label714;
              label1351:
              this.BdS.setVisibility(8);
              continue;
              label1363:
              if (this.mode != 2) {
                continue;
              }
              findViewById(2131306747).setVisibility(8);
              this.Bea.setVisibility(8);
              this.BdS.setVisibility(8);
              this.BdR.setVisibility(8);
              localObject1 = v.eok();
              if ((this.AYu != null) && (this.AYu.eqR()))
              {
                i = getIntent().getIntExtra("lqt_balance", 0);
                if (com.tencent.mm.platformtools.ab.iwH) {
                  i = 50000000;
                }
                if (i <= 0) {
                  continue;
                }
                localObject1 = getString(2131765410, new Object[] { Double.valueOf(jV(String.valueOf(i), "100")) });
                int j = ((String)localObject1).length();
                localObject1 = new SpannableString((String)localObject1 + " " + getString(2131765413));
                ((SpannableString)localObject1).setSpan(new a(new a.a()
                {
                  public final void aOb()
                  {
                    AppMethodBeat.i(69006);
                    WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).setText(com.tencent.mm.wallet_core.ui.e.C(WalletLqtSaveFetchUI.jX(i, "100")));
                    WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
                    WalletLqtSaveFetchUI.this.showWcKb();
                    AppMethodBeat.o(69006);
                  }
                }), j, ((SpannableString)localObject1).length(), 18);
                this.Bed = ((CharSequence)localObject1);
                this.BdQ.setText((CharSequence)localObject1);
                continue;
              }
              if (((v)localObject1).eol() == null) {}
              for (i = 0;; i = ((v)localObject1).eol().Foc)
              {
                if (((v)localObject1).eol() != null) {
                  ((v)localObject1).eol();
                }
                if (com.tencent.mm.platformtools.ab.iwH) {
                  i = 100000000;
                }
                localObject1 = getString(2131765385, new Object[] { Double.valueOf(jV(String.valueOf(i), "100")) });
                this.Bed = ((CharSequence)localObject1);
                this.BdQ.setText((CharSequence)localObject1);
                break;
              }
            }
            this.BdO.setVisibility(8);
          }
          AppMethodBeat.o(69015);
          return;
        }
        this.BdQ.setText("");
        this.BdO.setVisibility(8);
      }
    }
    AppMethodBeat.o(69015);
  }
  
  private void to(boolean paramBoolean)
  {
    AppMethodBeat.i(69022);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "check enable: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Beo) });
    if ((!paramBoolean) || (this.Beo))
    {
      ln(false);
      AppMethodBeat.o(69022);
      return;
    }
    if (this.mode == 1)
    {
      if (this.BdS.getVisibility() == 0)
      {
        if ((this.BdU.isChecked()) && (this.Bel))
        {
          ln(true);
          AppMethodBeat.o(69022);
          return;
        }
        ln(false);
        AppMethodBeat.o(69022);
        return;
      }
      if (this.Bel)
      {
        ln(true);
        AppMethodBeat.o(69022);
      }
    }
    else
    {
      if ((this.Bel) && ((this.BdY.getSelectRedeemType() != null) || (this.BdY.getRedeemTypeList() == null) || (this.BdY.getRedeemTypeList().isEmpty())))
      {
        if (this.BdY.getSelectRedeemType() == null) {}
        for (Integer localInteger = null;; localInteger = Integer.valueOf(this.BdY.getSelectRedeemType().FuV))
        {
          com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WalletLqtSaveFetchUI", "redeem type: %s", new Object[] { localInteger });
          ln(true);
          AppMethodBeat.o(69022);
          return;
        }
      }
      ln(false);
    }
    AppMethodBeat.o(69022);
  }
  
  public final void aLi()
  {
    AppMethodBeat.i(69029);
    if (this.iBT != null) {
      this.iBT.dismiss();
    }
    AppMethodBeat.o(69029);
  }
  
  public final void bs(float paramFloat) {}
  
  public final void eoY()
  {
    AppMethodBeat.i(69012);
    if (this.mode == 1)
    {
      this.Bee = com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.eoe();
      if (this.Bee == null)
      {
        com.tencent.mm.plugin.wallet.a.s.epp();
        this.Bee = com.tencent.mm.plugin.wallet.a.s.epq().AZp;
      }
      Object localObject;
      int i;
      if (this.Bee != null)
      {
        localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.eof();
        i = com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.eog();
        if (i != 0) {
          break label189;
        }
        this.Bed = ((CharSequence)localObject);
        if (this.BdQ != null) {
          this.BdQ.setText(this.Bed);
        }
      }
      if (this.BdK != null) {
        this.BdK.setVisibility(0);
      }
      if (!bs.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AXd))
      {
        this.usX.setText(com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AXd);
        this.usX.setVisibility(0);
      }
      for (;;)
      {
        localObject = v.eok().eol();
        if ((localObject != null) && (((bzf)localObject).FdJ) && (((bzf)localObject).Foi != null)) {
          af.a(getContext(), ((bzf)localObject).Foi);
        }
        tn(true);
        AppMethodBeat.o(69012);
        return;
        label189:
        if (i == 1)
        {
          i = ((String)localObject).length();
          localObject = new SpannableString((String)localObject + getString(2131765384));
          ((SpannableString)localObject).setSpan(new a(new a.a()
          {
            public final void aOb()
            {
              AppMethodBeat.i(69004);
              WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).setText(com.tencent.mm.wallet_core.ui.e.C(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).Buo));
              WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
              WalletLqtSaveFetchUI.this.showWcKb();
              AppMethodBeat.o(69004);
            }
          }), i + 1, ((SpannableString)localObject).length(), 18);
          this.Bed = ((CharSequence)localObject);
          break;
        }
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WalletLqtSaveFetchUI", "unknown func: %s", new Object[] { Integer.valueOf(i) });
        this.Bed = ((CharSequence)localObject);
        break;
        this.usX.setVisibility(8);
      }
    }
    if (this.BdY.Bad)
    {
      tn(false);
      AppMethodBeat.o(69012);
      return;
    }
    tn(true);
    AppMethodBeat.o(69012);
  }
  
  public final void epd()
  {
    this.Bep = false;
  }
  
  public final void epe()
  {
    AppMethodBeat.i(69031);
    ap.aB(this.wJB);
    ap.aB(this.Bet);
    AppMethodBeat.o(69031);
  }
  
  public int getLayoutId()
  {
    return 2131495978;
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(69026);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WalletLqtSaveFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.Bep), Boolean.valueOf(this.mWcKeyboard.fzO()) });
    if ((!this.Bep) && (this.mWcKeyboard.fzO()))
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "onActivityResult() requestCode:%s", new Object[] { Integer.valueOf(paramInt1) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.BdJ.AYj.it(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(69027);
      return;
    }
    if (paramIntent != null) {
      paramIntent.putExtra(com.tencent.mm.plugin.wallet.balance.model.lqt.ac.AXR, this.Bej);
    }
    com.tencent.mm.plugin.wallet.balance.model.lqt.ac localac = this.BdI;
    String str;
    Object localObject;
    if ((paramInt1 == com.tencent.mm.plugin.wallet.balance.model.lqt.ac.AXP) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra(com.tencent.mm.plugin.wallet.balance.model.lqt.ac.AXR);
      paramIntent = (Orders)paramIntent.getParcelableExtra("key_orders");
      if ((paramIntent != null) && (paramIntent.BxR != null) && (paramIntent.BxR.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s, reqkey: %s", new Object[] { Integer.valueOf(localac.hashCode()), Integer.valueOf(localac.accountType), paramIntent.dac });
        localac.dad = ((Orders.Commodity)paramIntent.BxR.get(0)).dad;
        paramIntent = (String)localac.AYb.get(paramIntent.dac);
        if (!bs.isNullOrNil(paramIntent)) {
          localac.AXV = paramIntent;
        }
        if ((localac.AXU instanceof WalletLqtSaveFetchUI))
        {
          ((WalletLqtSaveFetchUI)localac.AXU).Bep = true;
          ((WalletLqtSaveFetchUI)localac.AXU).epe();
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
        localac.AXU.showLoading(false);
        paramIntent = localac.AXU.getIntent().getStringExtra("operate_id");
        localObject = localac.AXT.AXL;
        com.tencent.mm.vending.g.g.a(localac.AXV, localac.dad, Integer.valueOf(localac.AXW), Integer.valueOf(localac.accountType), paramIntent, Integer.valueOf(localac.AYa)).c((com.tencent.mm.vending.c.a)localObject).f(new ac.7(localac, str)).a(new ac.6(localac));
      }
      AppMethodBeat.o(69027);
      return;
    }
    if ((paramInt1 == com.tencent.mm.plugin.wallet.balance.model.lqt.ac.AXQ) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra(com.tencent.mm.plugin.wallet.balance.model.lqt.ac.AXR);
      localObject = paramIntent.getStringExtra("lqt_fetch_enc_pwd");
      paramIntent = paramIntent.getStringExtra("lqt_redeem_listid");
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", new Object[] { Integer.valueOf(localac.hashCode()), Integer.valueOf(localac.accountType), paramIntent });
      if ((localac.AXU instanceof WalletLqtSaveFetchUI))
      {
        ((WalletLqtSaveFetchUI)localac.AXU).Bep = true;
        ((WalletLqtSaveFetchUI)localac.AXU).epe();
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", new Object[] { Integer.valueOf(localac.hashCode()), paramIntent });
      if (bs.isNullOrNil(localac.AXY))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", new Object[] { Integer.valueOf(localac.hashCode()), paramIntent });
        localac.AXY = paramIntent;
      }
      paramIntent = localac.AXU.getIntent().getStringExtra("operate_id");
      localac.AXU.showLoading(true);
      ab.c localc = localac.AXT.AXM;
      com.tencent.mm.vending.g.g.b(Integer.valueOf(localac.AXX), localObject, localac.AXY, Integer.valueOf(localac.accountType), paramIntent).c(localc).f(new ac.9(localac, str)).a(new ac.8(localac));
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
    this.BdL = ((WalletFormView)findViewById(2131301701));
    this.BdP = ((ImageView)findViewById(2131297166));
    this.BdQ = ((TextView)findViewById(2131301698));
    this.BdR = ((TextView)findViewById(2131301699));
    this.BdM = ((TextView)findViewById(2131301702));
    this.BdN = ((TextView)findViewById(2131301638));
    this.BdX = ((TextView)findViewById(2131306836));
    this.usX = ((TextView)findViewById(2131301706));
    this.Bec = ((TextView)findViewById(2131301700));
    this.BdS = ((ViewGroup)findViewById(2131301703));
    this.BdT = ((TextView)findViewById(2131301705));
    this.BdU = ((CheckBox)findViewById(2131301704));
    this.BdK = ((ViewGroup)findViewById(2131301985));
    this.BdV = ((TextView)findViewById(2131300742));
    this.BdW = ((TextView)findViewById(2131300743));
    this.BdO = ((TextView)findViewById(2131307277));
    this.BdY = ((WalletLqtArriveTimeLayout)findViewById(2131301696));
    this.BdZ = ((ScrollView)findViewById(2131301693));
    this.Bea = ((LinearLayout)findViewById(2131301675));
    this.Beb = ((TextView)findViewById(2131301676));
    this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
    int i = getIntent().getIntExtra("entrance_type", 0);
    this.BdI.mode = this.mode;
    this.BdI.AYa = i;
    this.Bef = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
    this.Beg = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
    this.Beh = getIntent().getStringExtra("lqt_profile_wording");
    this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.agS();
      this.Bej = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQw, ""));
      if (bs.isNullOrNil(this.Bej))
      {
        com.tencent.mm.kernel.g.agS();
        this.Bej = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQv, ""));
      }
      this.Bek = getIntent().getStringExtra("card_serial");
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", new Object[] { Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.Bej });
      this.BdL.getTitleTv().setText(ah.fAw());
      this.mWcKeyboard = ((WcPayKeyboard)findViewById(2131307020));
      paramBundle = (RelativeLayout.LayoutParams)this.mWcKeyboard.getLayoutParams();
      paramBundle.addRule(12);
      this.mWcKeyboard.setLayoutParams(paramBundle);
      if (this.mode != 1) {
        break label1105;
      }
      setWPKeyboard(this.BdL.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(2131765499));
      label634:
      if (com.tencent.mm.compatible.util.d.lb(27)) {
        this.BdL.fAY();
      }
      setWcKbHeightListener(this);
      if (this.mode != 1) {
        break label1140;
      }
      this.BdM.setText(getString(2131765491));
      this.BdX.setText(getString(2131765494));
      label690:
      this.BdL.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(207213);
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
            AppMethodBeat.o(207213);
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
          AppMethodBeat.i(207214);
          if (paramAnonymousBoolean)
          {
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
            {
              WalletLqtSaveFetchUI.r(WalletLqtSaveFetchUI.this);
              AppMethodBeat.o(207214);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1) {
              AppMethodBeat.o(207214);
            }
          }
          else
          {
            WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).scrollTo(0, 0);
            if ((WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) && (bs.isNullOrNil(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText()))) {
              WalletLqtSaveFetchUI.t(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(207214);
        }
      });
      paramBundle = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207223);
          if (bs.aO(WalletLqtSaveFetchUI.u(WalletLqtSaveFetchUI.this)) < 800L)
          {
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
            AppMethodBeat.o(207223);
            return;
          }
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, bs.Gn());
          final int k = WalletLqtSaveFetchUI.jY(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText(), "100");
          if (k > 0)
          {
            WalletLqtSaveFetchUI.this.hideWcKb();
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
              if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AXe))
              {
                AppMethodBeat.o(207223);
                return;
              }
              paramAnonymousView = WalletLqtSaveFetchUI.w(WalletLqtSaveFetchUI.this).AYg;
              com.tencent.mm.vending.g.g.h(Integer.valueOf(k), Integer.valueOf(WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this)), WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this)).c(paramAnonymousView).f(new com.tencent.mm.vending.c.a()
              {
                private Void a(cjq paramAnonymous2cjq)
                {
                  AppMethodBeat.i(207217);
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", new Object[] { Integer.valueOf(paramAnonymous2cjq.Fxq) });
                  WalletLqtSaveFetchUI.this.epe();
                  Object localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                  ((Intent)localObject).putExtra("key_amount", com.tencent.mm.wallet_core.ui.e.b(k, "100", RoundingMode.HALF_UP));
                  ((Intent)localObject).putExtra("key_mode", 1);
                  ((Intent)localObject).putExtra("profile_date_wording", paramAnonymous2cjq.Fxs);
                  ((Intent)localObject).putExtra("profile_upgrade_wording", paramAnonymous2cjq.Fxr);
                  if (paramAnonymous2cjq.Fxt != null) {}
                  try
                  {
                    ((Intent)localObject).putExtra("key_guide_cell", paramAnonymous2cjq.Fxt.toByteArray());
                    ((Intent)localObject).putExtra("entrance_type", WalletLqtSaveFetchUI.this.getIntent().getIntExtra("entrance_type", 0));
                    paramAnonymous2cjq = WalletLqtSaveFetchUI.this;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2cjq, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymous2cjq.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2cjq, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    WalletLqtSaveFetchUI.this.finish();
                    paramAnonymous2cjq = Jql;
                    AppMethodBeat.o(207217);
                    return paramAnonymous2cjq;
                  }
                  catch (IOException paramAnonymous2cjq)
                  {
                    for (;;)
                    {
                      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramAnonymous2cjq, "", new Object[0]);
                    }
                  }
                }
              }).a(new WalletLqtSaveFetchUI.14.1(this));
              AppMethodBeat.o(207223);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
              if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi.AXf))
              {
                AppMethodBeat.o(207223);
                return;
              }
              bzf localbzf = null;
              paramAnonymousView = localbzf;
              if (WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this) != null)
              {
                paramAnonymousView = localbzf;
                if (!WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).eqR())
                {
                  paramAnonymousView = new ig();
                  paramAnonymousView.tGS = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankName;
                  paramAnonymousView.cZz = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankcardType;
                  paramAnonymousView.DVW = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bindSerial;
                  paramAnonymousView.vxk = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankcardTail;
                }
              }
              int i = -1;
              if (WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getSelectRedeemType() != null) {
                i = WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getSelectRedeemType().FuV;
              }
              int j = i;
              if (WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this) != null)
              {
                j = i;
                if (!WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).eqR())
                {
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "choose bankcard");
                  int m = com.tencent.mm.wallet_core.ui.e.mj(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText(), "100");
                  localbzf = v.eok().eol();
                  if ((localbzf.Foj >= 0) && (m > localbzf.Foj))
                  {
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "choose slow redeem");
                    WalletLqtSaveFetchUI.x(WalletLqtSaveFetchUI.this);
                    AppMethodBeat.o(207223);
                    return;
                  }
                  j = i;
                  if (localbzf.Foj >= 0)
                  {
                    j = i;
                    if (m < localbzf.Foj)
                    {
                      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "choose fast redeem");
                      j = 0;
                    }
                  }
                }
              }
              WalletLqtSaveFetchUI.w(WalletLqtSaveFetchUI.this).AYh.a(k, WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this), j, paramAnonymousView).f(new com.tencent.mm.vending.c.a()
              {
                private Void a(cni paramAnonymous2cni)
                {
                  AppMethodBeat.i(207221);
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", new Object[] { paramAnonymous2cni, Boolean.valueOf(paramAnonymous2cni.FAx), Boolean.valueOf(paramAnonymous2cni.FAy) });
                  WalletLqtSaveFetchUI.this.epe();
                  Object localObject;
                  if ((paramAnonymous2cni.FAx) && (paramAnonymous2cni.FAy))
                  {
                    localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                    ((Intent)localObject).putExtra("key_amount", com.tencent.mm.wallet_core.ui.e.b(k, "100", RoundingMode.HALF_UP));
                    ((Intent)localObject).putExtra("key_mode", 2);
                    paramAnonymous2cni = WalletLqtSaveFetchUI.this;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2cni, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymous2cni.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2cni, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  for (;;)
                  {
                    WalletLqtSaveFetchUI.this.finish();
                    paramAnonymous2cni = Jql;
                    AppMethodBeat.o(207221);
                    return paramAnonymous2cni;
                    localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishProgressNewUI.class);
                    try
                    {
                      ((Intent)localObject).putExtra("key_redeem_res", paramAnonymous2cni.toByteArray());
                      paramAnonymous2cni = WalletLqtSaveFetchUI.this;
                      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2cni, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramAnonymous2cni.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2cni, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    catch (Exception paramAnonymous2cni)
                    {
                      for (;;)
                      {
                        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramAnonymous2cni, "pass redeemFundRes error: %s", new Object[] { paramAnonymous2cni.getMessage() });
                      }
                    }
                  }
                }
              }).a(new com.tencent.mm.vending.g.d.a()
              {
                public final void cc(Object paramAnonymous2Object)
                {
                  boolean bool = false;
                  AppMethodBeat.i(207220);
                  WalletLqtSaveFetchUI.this.Bep = false;
                  WalletLqtSaveFetchUI.this.aLi();
                  if (paramAnonymous2Object != null)
                  {
                    if ((paramAnonymous2Object instanceof cni)) {
                      bool = com.tencent.mm.wallet_core.d.h.a(WalletLqtSaveFetchUI.this, null, 1000, ((cni)paramAnonymous2Object).nWx, ((cni)paramAnonymous2Object).nWy);
                    }
                    if (!bool) {
                      if (!(paramAnonymous2Object instanceof String)) {
                        break label112;
                      }
                    }
                  }
                  label112:
                  for (paramAnonymous2Object = paramAnonymous2Object.toString();; paramAnonymous2Object = WalletLqtSaveFetchUI.this.getString(2131765420))
                  {
                    com.tencent.mm.ui.base.h.d(WalletLqtSaveFetchUI.this, paramAnonymous2Object, "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(207219);
                        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "fetch MMAlert Interrupt click");
                        AppMethodBeat.o(207219);
                      }
                    });
                    AppMethodBeat.o(207220);
                    return;
                  }
                }
              });
            }
          }
          AppMethodBeat.o(207223);
        }
      };
      this.BdL.getContentEt().setOnEditorActionListener(new WalletLqtSaveFetchUI.15(this, paramBundle));
      if (!bs.isNullOrNil(this.Beh)) {
        this.mWcKeyboard.setTipText(this.Beh);
      }
      if (this.mode == 2) {
        this.BdY.setCallback(new WalletLqtSaveFetchUI.16(this));
      }
      this.BdQ.setText("");
      this.BdQ.setClickable(true);
      this.BdQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      to(false);
      this.Beb.setClickable(true);
      this.Beb.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      if (this.mode != 1) {
        break label1189;
      }
      this.BdK.setVisibility(4);
      if (i != 8) {
        break label1179;
      }
      setMMTitle(2131765498);
      this.mWcKeyboard.showNormalStWcKb();
    }
    for (;;)
    {
      if (this.BdN.findViewById(2131306835) != null) {
        this.BdN.findViewById(2131306835).setVisibility(8);
      }
      paramBundle = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68967);
          WalletLqtSaveFetchUI.this.hideTenpayKB();
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this);
          com.tencent.mm.plugin.report.service.h.wUl.f(20287, new Object[] { Integer.valueOf(3) });
          AppMethodBeat.o(68967);
        }
      };
      this.BdN.setOnClickListener(paramBundle);
      if (findViewById(2131297947) != null) {
        findViewById(2131297947).setOnClickListener(paramBundle);
      }
      eoY();
      paramBundle = com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi;
      s.a locala = this.Bes;
      paramBundle.AXh.add(locala);
      this.BdK.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(68982);
          if ((WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this).isShown()) && (WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).fzM()))
          {
            WalletLqtSaveFetchUI.d(WalletLqtSaveFetchUI.this).fzK();
            AppMethodBeat.o(68982);
            return true;
          }
          AppMethodBeat.o(68982);
          return false;
        }
      });
      this.state = 1;
      paramBundle = getIntent().getStringExtra("fill_money");
      if (bs.getDouble(paramBundle, 0.0D) > 0.0D)
      {
        this.BdL.setText(paramBundle);
        bX(paramBundle, false);
      }
      if ((this.mode == 2) && (v.eok().eol() == null)) {
        showLoading(false);
      }
      AppMethodBeat.o(69010);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.f(20287, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.kernel.g.agS();
      this.Bej = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQx, ""));
      break;
      label1105:
      this.isVKBFirstTimeShown = false;
      setWPKeyboard(this.BdL.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(2131765415));
      break label634;
      label1140:
      if (this.mode != 2) {
        break label690;
      }
      this.BdM.setText(getString(2131765397));
      this.BdX.setText(getString(2131765402));
      break label690;
      label1179:
      setMMTitle(2131765499);
      continue;
      label1189:
      setMMTitle(2131765415);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69030);
    super.onDestroy();
    epe();
    com.tencent.mm.plugin.wallet.balance.model.lqt.s locals = com.tencent.mm.plugin.wallet.balance.model.lqt.s.AXi;
    s.a locala = this.Bes;
    locals.AXh.remove(locala);
    this.BdI = null;
    this.BdJ = null;
    AppMethodBeat.o(69030);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(69025);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "onDialogDismiss()");
    ap.n(this.wJB, 300L);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    paramIntent = epb();
    this.BdJ.AYj.it(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(69017);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69024);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "onPause()");
    if (!this.mWcKeyboard.fzN()) {
      this.state = 3;
    }
    AppMethodBeat.o(69024);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69023);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      ap.n(this.Bet, 300L);
    }
    this.state = 2;
    AppMethodBeat.o(69023);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(69028);
    com.tencent.mm.plugin.wallet.balance.model.lqt.ac localac = this.BdI;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
    {
      com.tencent.mm.plugin.wallet.a.s.epp();
      localac.AXZ = com.tencent.mm.plugin.wallet.a.s.epq().AZp;
      if (localac.izm != null)
      {
        localac.izm.F(new Object[] { paramn });
        localac.izm.resume();
      }
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletLqtSaveFetchUI", "onSceneEnd");
    eoY();
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