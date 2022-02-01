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
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.aa;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ab;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ab.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac.6;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac.7;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac.8;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac.9;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ad.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ad.d;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af;
import com.tencent.mm.plugin.wallet.balance.model.lqt.s.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
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
  private aa CPG;
  private ab CPH;
  private Bankcard CQi;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ac CVC;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ad CVD;
  private ViewGroup CVE;
  private WalletFormView CVF;
  private TextView CVG;
  private TextView CVH;
  private TextView CVI;
  private ImageView CVJ;
  private TextView CVK;
  private TextView CVL;
  private ViewGroup CVM;
  private TextView CVN;
  private CheckBox CVO;
  private TextView CVP;
  private TextView CVQ;
  private TextView CVR;
  private WalletLqtArriveTimeLayout CVS;
  private ScrollView CVT;
  private LinearLayout CVU;
  private TextView CVW;
  private TextView CVX;
  private CharSequence CVY;
  private Bankcard CVZ;
  private int CWa;
  private String CWb;
  private String CWc;
  private long CWd;
  private String CWe;
  private String CWf;
  private boolean CWg;
  private List<Bankcard> CWh;
  private boolean CWi;
  private boolean CWj;
  protected boolean CWk;
  private String CWl;
  private boolean CWm;
  private int CWn;
  private s.a CWo;
  private Runnable CWp;
  private int accountType;
  private Dialog iXW;
  private int mode;
  private int state;
  private TextView vHE;
  private HashMap<String, Integer> vtZ;
  private com.tencent.mm.sdk.b.c<kt> wNu;
  public Runnable ync;
  
  public WalletLqtSaveFetchUI()
  {
    AppMethodBeat.i(69009);
    this.CPG = ((aa)aq(aa.class));
    this.CPH = ((ab)am(ab.class));
    this.CVC = new com.tencent.mm.plugin.wallet.balance.model.lqt.ac(this.CPG, this.CPH, this);
    this.CVD = new com.tencent.mm.plugin.wallet.balance.model.lqt.ad(this.CVC);
    this.CWd = -1L;
    this.CWg = false;
    this.CWi = true;
    this.CWj = false;
    this.CWk = false;
    this.CWl = "";
    this.CWm = false;
    this.CWn = ak.getContext().getResources().getColor(2131099734);
    this.CWo = new s.a()
    {
      public final void eFP()
      {
        AppMethodBeat.i(69002);
        ae.i("MicroMsg.WalletLqtSaveFetchUI", "cache updated");
        WalletLqtSaveFetchUI.this.hideLoading();
        WalletLqtSaveFetchUI.this.eGF();
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
          if (!bu.isNullOrNil(str)) {
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, str);
          }
        }
        AppMethodBeat.o(69002);
      }
    };
    this.vtZ = new HashMap();
    this.state = 0;
    this.ync = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190116);
        if ((WalletLqtSaveFetchUI.y(WalletLqtSaveFetchUI.this) == 2) && (WalletLqtSaveFetchUI.this.isHandleAutoShowNormalStWcKb())) {
          WalletLqtSaveFetchUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(190116);
      }
    };
    this.CWp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190117);
        WalletLqtSaveFetchUI.this.showNormalStWcKb();
        AppMethodBeat.o(190117);
      }
    };
    this.wNu = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(69009);
  }
  
  private void H(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(69014);
    ae.d("MicroMsg.WalletLqtSaveFetchUI", "update arrive time layout: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    is localis;
    if (this.mode == 2)
    {
      localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.v.eFR().eFS();
      if (!this.CVS.CRV)
      {
        if (localObject == null)
        {
          ae.w("MicroMsg.WalletLqtSaveFetchUI", "no cache!");
          AppMethodBeat.o(69014);
          return;
        }
        if (this.CQi.eIy())
        {
          ae.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
          this.CVS.q(((ceq)localObject).Hrs, false);
          this.CVS.aFl(paramString);
        }
        for (;;)
        {
          this.CVS.setVisibility(4);
          eGJ();
          AppMethodBeat.o(69014);
          return;
          if (((ceq)localObject).Hrt != null)
          {
            localObject = ((ceq)localObject).Hrt.iterator();
            while (((Iterator)localObject).hasNext())
            {
              localis = (is)((Iterator)localObject).next();
              if (localis.FTN.equals(this.CQi.field_bindSerial))
              {
                ae.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                this.CVS.q(localis.FUd, false);
                this.CVS.aFl(paramString);
              }
            }
          }
        }
      }
      if (paramBoolean)
      {
        if (!this.CQi.eIy()) {
          break label273;
        }
        ae.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
        this.CVS.q(((ceq)localObject).Hrs, true);
      }
    }
    for (;;)
    {
      this.CVS.setVisibility(4);
      this.CVS.aFl(paramString);
      AppMethodBeat.o(69014);
      return;
      label273:
      if (((ceq)localObject).Hrt != null)
      {
        localObject = ((ceq)localObject).Hrt.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localis = (is)((Iterator)localObject).next();
          if (localis.FTN.equals(this.CQi.field_bindSerial))
          {
            ae.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
            this.CVS.q(localis.FUd, true);
          }
        }
      }
    }
  }
  
  private boolean aFs(String paramString)
  {
    AppMethodBeat.i(69011);
    if (!bu.isNullOrNil(paramString)) {
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
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).zf(false);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).aZi(paramString);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).aZp(str1);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).aZo(str2);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).a(true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69003);
              f.p(WalletLqtSaveFetchUI.this.getContext(), this.CWG, false);
              AppMethodBeat.o(69003);
            }
          });
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).fQv().show();
          AppMethodBeat.o(69011);
          return true;
        }
      }
      catch (JSONException paramString)
      {
        ae.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(69011);
    return false;
  }
  
  private void cj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182506);
    ae.i("MicroMsg.WalletLqtSaveFetchUI", "update tips: %s", new Object[] { paramString });
    long l = f.mO(String.valueOf(paramString), "100");
    Object localObject;
    if (l > 0L) {
      if (this.mode == 1) {
        if (this.CQi != null) {
          if (this.CQi.eIy())
          {
            if ((this.CVZ != null) && (l > kx(this.CVZ.Dmj, "100")))
            {
              this.CVK.setText(getString(2131765492));
              this.CVK.setTextColor(getResources().getColor(2131099804));
              this.CWg = false;
              uf(false);
              if (l > 0L) {
                break label1279;
              }
              this.CWi = true;
              AppMethodBeat.o(182506);
              return;
            }
            if ((com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.COQ >= 0) && (l > com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.COQ) && (!bu.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.CON)) && (!bu.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.COO)) && (!bu.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.COP)))
            {
              paramString = new q(new q.a()
              {
                public final void dN(View paramAnonymousView)
                {
                  AppMethodBeat.i(190113);
                  ae.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                  f.a(WalletLqtSaveFetchUI.this.getContext(), com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.COP, true, 1);
                  AppMethodBeat.o(190113);
                }
              });
              localObject = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject).append(com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.CON);
              ((SpannableStringBuilder)localObject).append(com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.COO);
              ((SpannableStringBuilder)localObject).setSpan(paramString, com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.CON.length(), ((SpannableStringBuilder)localObject).length(), 18);
              if ((this.CVK.getText() == null) || (!this.CVK.getText().equals(((SpannableStringBuilder)localObject).toString()))) {
                com.tencent.mm.plugin.report.service.g.yxI.f(17084, new Object[] { Integer.valueOf(9) });
              }
              this.CVK.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(getContext()));
              this.CVK.setClickable(true);
              this.CVK.setText((CharSequence)localObject);
            }
          }
        }
      }
    }
    for (;;)
    {
      this.CVK.setTextColor(this.CWn);
      this.CWg = false;
      uf(false);
      break;
      this.CVK.setText(this.CVY);
      this.CVK.setTextColor(this.CWn);
      this.CWg = true;
      uf(true);
      break;
      if ((this.CQi.field_dayQuotaKind > 0.0D) && (l > kx(this.CQi.field_dayQuotaKind, "100")))
      {
        this.CVK.setText(getString(2131765493));
        this.CVK.setTextColor(getResources().getColor(2131099804));
        this.CWg = false;
        uf(false);
        break;
      }
      this.CVK.setText("");
      this.CWg = true;
      uf(true);
      break;
      this.CWg = true;
      uf(true);
      break;
      if (this.mode != 2) {
        break;
      }
      localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.v.eFR();
      int k;
      label587:
      int i;
      int j;
      if (((com.tencent.mm.plugin.wallet.balance.model.lqt.v)localObject).eFS() == null)
      {
        k = 0;
        if ((this.CQi == null) || (!this.CQi.eIy())) {
          break label702;
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
            this.CVK.setText(getString(2131765398));
            this.CVK.setTextColor(getResources().getColor(2131099804));
            this.CWg = false;
            eGG();
            uf(false);
            this.CVU.setVisibility(8);
            break;
            k = ((com.tencent.mm.plugin.wallet.balance.model.lqt.v)localObject).eFS().Hro;
            break label587;
            label702:
            ceq localceq = com.tencent.mm.plugin.wallet.balance.model.lqt.v.eFR().eFS();
            if (localceq == null)
            {
              i = 0;
              j = 0;
              continue;
            }
            i = localceq.Hrq;
            j = 0;
            continue;
          }
          this.CVK.setText(this.CVY);
          this.CVK.setTextColor(this.CWn);
          this.CWg = true;
          H(paramBoolean, paramString);
          uf(true);
          this.CVU.setVisibility(8);
          break;
        }
      }
      if (l > k)
      {
        this.CVK.setText(getString(2131765398));
        this.CVK.setTextColor(getResources().getColor(2131099804));
        this.CVU.setVisibility(8);
        this.CWg = false;
        eGG();
        uf(false);
        this.CVU.setVisibility(8);
        break;
      }
      if (l > i)
      {
        paramString = getString(2131765385, new Object[] { Double.valueOf(kw(String.valueOf(k), "100")) });
        this.CVK.setTextColor(this.CWn);
        this.CVK.setText(paramString);
        this.CVU.setVisibility(0);
        paramString = getString(2131765409, new Object[] { Double.valueOf(kw(String.valueOf(i), "100")) });
        i = paramString.length();
        paramString = new SpannableString(paramString + getString(2131765412));
        paramString.setSpan(new a(new a.a()
        {
          public final void aRM()
          {
            AppMethodBeat.i(190114);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, this.CWB.eFS());
            AppMethodBeat.o(190114);
          }
        }), i, paramString.length(), 18);
        this.CVW.setText(paramString);
        this.CWg = false;
        eGG();
        uf(false);
        break;
      }
      if ((this.CQi != null) && (!this.CQi.eIy()) && (this.CQi.field_dayQuotaKind > 0.0D) && (l > kx(this.CQi.field_dayQuotaKind, "100")))
      {
        this.CVU.setVisibility(0);
        this.CVW.setText(getString(2131765400, new Object[] { Double.valueOf(this.CQi.field_dayQuotaKind) }));
        this.CWg = false;
        eGG();
        uf(false);
        break;
      }
      this.CVK.setText(this.CVY);
      this.CVK.setTextColor(this.CWn);
      this.CWg = true;
      H(paramBoolean, paramString);
      uf(true);
      this.CVU.setVisibility(8);
      break;
      if (this.mode == 1)
      {
        if ((this.CQi != null) && (this.CQi.eIy())) {
          this.CVK.setText(this.CVY);
        } else {
          this.CVK.setText("");
        }
      }
      else
      {
        this.CVK.setText(this.CVY);
        eGG();
      }
    }
    label1279:
    this.CWi = false;
    AppMethodBeat.o(182506);
  }
  
  private void eGG()
  {
    AppMethodBeat.i(69013);
    WalletLqtArriveTimeLayout localWalletLqtArriveTimeLayout = this.CVS;
    localWalletLqtArriveTimeLayout.CRV = false;
    if (localWalletLqtArriveTimeLayout.CRR != null) {
      localWalletLqtArriveTimeLayout.CRR.clear();
    }
    localWalletLqtArriveTimeLayout.CRT = null;
    localWalletLqtArriveTimeLayout.CRS.clear();
    localWalletLqtArriveTimeLayout.setVisibility(4);
    AppMethodBeat.o(69013);
  }
  
  private void eGH()
  {
    AppMethodBeat.i(190130);
    this.vtZ.clear();
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this, 2, true);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW;
    this.CWh = com.tencent.mm.plugin.wallet.balance.model.lqt.s.VN(this.mode);
    localObject1 = null;
    if (this.CQi != null) {
      localObject1 = this.CQi.field_bindSerial;
    }
    Object localObject2 = localObject1;
    if (bu.isNullOrNil((String)localObject1))
    {
      localObject2 = this.CWe;
      if (bu.isNullOrNil(this.CWe)) {
        com.tencent.mm.kernel.g.ajS();
      }
    }
    for (localObject1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXs, "");; localObject1 = localObject2)
    {
      int i = 0;
      int k;
      for (int j = 0; i < this.CWh.size(); j = k)
      {
        localObject2 = (Bankcard)this.CWh.get(i);
        k = j;
        if (!bu.isNullOrNil(((Bankcard)localObject2).field_bindSerial))
        {
          k = j;
          if (((String)localObject1).equals(((Bankcard)localObject2).field_bindSerial)) {
            k = i;
          }
        }
        i += 1;
      }
      locale.LfS = new n.d()
      {
        public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(190089);
          int j = WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).size();
          int i = 0;
          final Bankcard localBankcard;
          Object localObject1;
          if (i < j)
          {
            localBankcard = (Bankcard)WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).get(i);
            localObject1 = com.tencent.mm.plugin.wallet_core.d.b.i(WalletLqtSaveFetchUI.this, localBankcard.field_bankcardType, localBankcard.eIx());
            if (localObject1 == null) {
              break label917;
            }
          }
          label917:
          for (final String str1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject1).wFJ;; str1 = "")
          {
            Bitmap localBitmap = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str1));
            u.a(new u.a()
            {
              public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(190086);
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(190085);
                    ae.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletLqtSaveFetchUI.3.1.this.wQL });
                    if (WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).containsKey(paramAnonymous2String))
                    {
                      int i = ((Integer)WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).get(paramAnonymous2String)).intValue();
                      if ((i < WalletLqtSaveFetchUI.3.1.this.vuh.size()) && (WalletLqtSaveFetchUI.3.1.this.vuh.getItem(i) != null))
                      {
                        WalletLqtSaveFetchUI.3.1.this.vuh.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.h.a(paramAnonymous2Bitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), true, false)));
                        WalletLqtSaveFetchUI.3.this.jol.fQA();
                      }
                    }
                    AppMethodBeat.o(190085);
                  }
                });
                AppMethodBeat.o(190086);
              }
            });
            Drawable localDrawable = null;
            Object localObject4 = null;
            localObject1 = "";
            if (!bu.isNullOrNil(localBankcard.field_forbidWord)) {
              localObject1 = localBankcard.field_forbidWord;
            }
            Object localObject3;
            Object localObject2;
            label161:
            String str2;
            if (bu.isNullOrNil(localBankcard.field_forbid_title))
            {
              localObject3 = new SpannableStringBuilder((CharSequence)localObject1);
              localObject2 = localObject1;
              localObject1 = localObject3;
              localObject3 = localObject1;
              if (bu.ah((CharSequence)localObject1))
              {
                localObject3 = localObject1;
                if (!bu.isNullOrNil(localBankcard.field_prompt_info_prompt_text))
                {
                  localObject1 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
                  localObject3 = localObject1;
                  if (!bu.isNullOrNil(localBankcard.field_prompt_info_jump_text))
                  {
                    localObject3 = localObject1;
                    if (!bu.isNullOrNil(localBankcard.field_prompt_info_jump_url))
                    {
                      ((SpannableStringBuilder)localObject1).append(localBankcard.field_prompt_info_jump_text);
                      ((SpannableStringBuilder)localObject1).setSpan(new q(new q.a()
                      {
                        public final void dN(View paramAnonymous2View)
                        {
                          AppMethodBeat.i(190088);
                          f.aY(WalletLqtSaveFetchUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
                          com.tencent.mm.plugin.report.service.g.yxI.f(20216, new Object[] { Integer.valueOf(2), localBankcard.field_prompt_info_jump_url });
                          AppMethodBeat.o(190088);
                        }
                      }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject1).length(), 33);
                      localObject3 = localObject1;
                    }
                  }
                }
              }
              str2 = localBankcard.field_desc;
              if (!localBankcard.eIy()) {
                break label602;
              }
              localObject1 = str2;
              if (localBankcard.Dmj >= 0.0D) {
                localObject1 = str2 + WalletLqtSaveFetchUI.this.getString(2131764999, new Object[] { f.D(localBankcard.Dmj) });
              }
              ae.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), localObject1, localObject3 });
              localDrawable = WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234612);
              if (bu.isNullOrNil((String)localObject2)) {
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
                  AppMethodBeat.i(190087);
                  paramAnonymous2View = localBankcard.field_forbid_url;
                  Intent localIntent = new Intent();
                  ae.i("MicroMsg.WalletLqtSaveFetchUI", "go to url %s", new Object[] { paramAnonymous2View });
                  localIntent.putExtra("rawUrl", paramAnonymous2View);
                  localIntent.putExtra("geta8key_username", com.tencent.mm.model.v.aAC());
                  localIntent.putExtra("pay_channel", 1);
                  f.an(WalletLqtSaveFetchUI.this.getContext(), localIntent);
                  AppMethodBeat.o(190087);
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
              localObject1 = com.tencent.mm.sdk.platformtools.h.a(localBitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), true, false);
            }
            ae.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localObject3 });
            if (localObject1 == null)
            {
              localObject4 = null;
              label680:
              if (bu.isNullOrNil((String)localObject2)) {
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
            localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW;
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              bool = true;
              ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tZ(bool);
              if (!bool) {
                break label803;
              }
              localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).COG;
              label766:
              if (localObject1 == null) {
                break label813;
              }
            }
            label803:
            label813:
            for (bool = ((bws)localObject1).HjB;; bool = false)
            {
              if (!bool) {
                break label819;
              }
              ae.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
              AppMethodBeat.o(190089);
              return;
              bool = false;
              break;
              localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).COH;
              break label766;
            }
            label819:
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              paramAnonymousl.a(j, WalletLqtSaveFetchUI.this.getString(2131765496), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234603), false);
              AppMethodBeat.o(190089);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) {
              paramAnonymousl.a(j, WalletLqtSaveFetchUI.this.getString(2131765404), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234603), false);
            }
            AppMethodBeat.o(190089);
            return;
          }
        }
      };
      locale.KtV = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(190090);
          WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).clear();
          AppMethodBeat.o(190090);
        }
      };
      locale.LfT = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(190091);
          if (locale != null)
          {
            locale.bqD();
            if (paramAnonymousInt < WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).size())
            {
              paramAnonymousMenuItem = (Bankcard)WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).get(paramAnonymousInt);
              WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, paramAnonymousMenuItem.field_bindSerial);
              WalletLqtSaveFetchUI.n(WalletLqtSaveFetchUI.this);
              if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
              {
                WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).dHv();
                AppMethodBeat.o(190091);
                return;
              }
              WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText());
              AppMethodBeat.o(190091);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
              AppMethodBeat.o(190091);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) {
              WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(190091);
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
        locale.xFq = true;
        locale.iNL = j;
        locale.Ltv = true;
        locale.P((View)localObject1, false);
        locale.cPF();
        AppMethodBeat.o(190130);
        return;
        ((TextView)((View)localObject1).findViewById(2131301708)).setText(2131765396);
        ((TextView)((View)localObject1).findViewById(2131301707)).setText(2131765395);
      }
    }
  }
  
  private List<Bankcard> eGI()
  {
    AppMethodBeat.i(69016);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tX(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.eGW();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.eGX().eKf();
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
        if (localBankcard.eIy())
        {
          com.tencent.mm.plugin.wallet.a.s.eGW();
          if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJJ())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.eIy()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((this.mode == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.eIy()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label200:
    AppMethodBeat.o(69016);
    return localObject2;
  }
  
  private void eGJ()
  {
    AppMethodBeat.i(69019);
    this.CVT.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190112);
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        WalletLqtSaveFetchUI.this.findViewById(2131301702).getLocationInWindow(arrayOfInt1);
        WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).getLocationInWindow(arrayOfInt2);
        ae.d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
        WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
        AppMethodBeat.o(190112);
      }
    }, 100L);
    AppMethodBeat.o(69019);
  }
  
  private static double kw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69032);
    try
    {
      if (bu.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
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
      ae.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
      AppMethodBeat.o(69032);
    }
  }
  
  private static int kx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69033);
    try
    {
      double d1 = bu.getDouble(paramString1, 0.0D);
      double d2 = bu.getDouble(paramString2, 0.0D);
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
      ae.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramString1, "", new Object[0]);
      AppMethodBeat.o(69033);
    }
    return 0;
  }
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(69021);
    this.mWcKeyboard.zx(paramBoolean);
    AppMethodBeat.o(69021);
  }
  
  private void ue(boolean paramBoolean)
  {
    AppMethodBeat.i(69015);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tX(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.eGW();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.eGX().eKf();
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
        if (localBankcard.eIy())
        {
          com.tencent.mm.plugin.wallet.a.s.eGW();
          if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJJ())
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
      if (!bu.isNullOrNil(this.CWf))
      {
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject1 = (Bankcard)((List)localObject2).get(i);
          if ((!bu.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.CWf.equals(((Bankcard)localObject1).field_bindSerial))) {
            this.CQi = ((Bankcard)localObject1);
          }
          i += 1;
        }
      }
      if ((bu.isNullOrNil(this.CWf)) || (this.CQi == null))
      {
        localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW;
        if (this.mode == 1) {}
        for (bool = true;; bool = false)
        {
          this.CQi = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tW(bool);
          if ((bu.isNullOrNil(this.CWe)) || (this.CQi != null)) {
            break;
          }
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = (Bankcard)((List)localObject2).get(i);
            if ((!bu.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.CWe.equals(((Bankcard)localObject1).field_bindSerial))) {
              this.CQi = ((Bankcard)localObject1);
            }
            i += 1;
          }
        }
      }
    }
    else if (!bu.isNullOrNil(this.CWe))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = (Bankcard)((List)localObject2).get(i);
        if ((!bu.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.CWe.equals(((Bankcard)localObject1).field_bindSerial))) {
          this.CQi = ((Bankcard)localObject1);
        }
        i += 1;
      }
    }
    if (this.CQi != null) {}
    for (localObject1 = this.CQi.field_bindSerial;; localObject1 = "")
    {
      ae.i("MicroMsg.WalletLqtSaveFetchUI", "defaultBankcard: %s, save mCurrentSerial: %s, useDefault: %s", new Object[] { localObject1, this.CWe, Boolean.valueOf(paramBoolean) });
      if (this.CQi != null) {
        break;
      }
      com.tencent.mm.plugin.wallet.a.s.eGW();
      this.CQi = com.tencent.mm.plugin.wallet.a.s.eGX().CRg;
      if (this.CQi != null) {
        break;
      }
      finish();
      AppMethodBeat.o(69015);
      return;
    }
    if (this.CQi.eIy())
    {
      this.CVH.setText(this.CQi.field_desc);
      this.CVH.setText(this.CQi.field_desc);
      this.CVH.setVisibility(0);
      this.CVJ.setTag(this.CQi.field_bindSerial);
      if (this.CVJ != null)
      {
        localObject1 = "";
        localObject2 = com.tencent.mm.plugin.wallet_core.d.b.i(this, this.CQi.field_bankcardType, this.CQi.eIx());
        if (localObject2 != null) {
          localObject1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject2).wFJ;
        }
        this.CVJ.setImageBitmap(null);
        if (!this.CQi.eIy()) {
          break label1294;
        }
        this.CVJ.setImageResource(2131234612);
      }
      label715:
      this.CVP.setVisibility(8);
      this.CVQ.setVisibility(8);
      if ((this.mode != 2) && (this.mode == 1) && (!this.CQi.eIy()) && (!bu.isNullOrNil(this.CQi.field_avail_save_wording)))
      {
        this.CVP.setText(this.CQi.field_avail_save_wording);
        this.CVP.setVisibility(0);
      }
      if (this.mode != 1) {
        break label1378;
      }
      localObject1 = getIntent().getStringArrayListExtra("lqt_protocol_list");
      paramBoolean = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0) || (!paramBoolean)) {
        break label1366;
      }
      this.CVM.setVisibility(0);
      this.CVO.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
      this.CVM.setOnClickListener(new WalletLqtSaveFetchUI.8(this));
      this.CVO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(190095);
          if (!paramAnonymousBoolean)
          {
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, false);
            AppMethodBeat.o(190095);
            return;
          }
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, true);
          AppMethodBeat.o(190095);
        }
      });
      localObject2 = getString(2131765483);
      i = ((String)localObject2).length();
      localObject2 = new SpannableString((String)localObject2 + getString(2131765484));
      ((SpannableString)localObject2).setSpan(new a(new a.a()
      {
        public final void aRM()
        {
          AppMethodBeat.i(190098);
          com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(WalletLqtSaveFetchUI.this, 1, false);
          locale.LfS = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(190096);
              Iterator localIterator = WalletLqtSaveFetchUI.10.this.CWv.iterator();
              int i = 0;
              while (localIterator.hasNext())
              {
                paramAnonymous2l.add(0, i, 0, ((String)localIterator.next()).split("\\|\\|")[0]);
                i += 1;
              }
              AppMethodBeat.o(190096);
            }
          };
          locale.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(190097);
              paramAnonymous2Int = paramAnonymous2MenuItem.getItemId();
              if (paramAnonymous2Int < WalletLqtSaveFetchUI.10.this.CWv.size())
              {
                paramAnonymous2MenuItem = ((String)WalletLqtSaveFetchUI.10.this.CWv.get(paramAnonymous2Int)).split("\\|\\|")[1];
                f.p(WalletLqtSaveFetchUI.this, paramAnonymous2MenuItem, false);
              }
              AppMethodBeat.o(190097);
            }
          };
          locale.cPF();
          AppMethodBeat.o(190098);
        }
      }), i, ((SpannableString)localObject2).length(), 17);
      this.CVN.setText((CharSequence)localObject2);
      this.CVN.setClickable(true);
      this.CVN.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
    }
    for (;;)
    {
      if (this.mode == 1)
      {
        if ((this.CQi != null) && (this.CQi.eIy()))
        {
          this.CVK.setText(this.CVY);
          localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW;
          ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tZ(true);
          localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).COG;
          if (localObject1 != null)
          {
            if ((((bws)localObject1).HjI != null) && (!bu.isNullOrNil(((bws)localObject1).HjI.Hzs)))
            {
              localObject2 = new SpannableStringBuilder(((bws)localObject1).HjI.Hzs);
              if ((!bu.isNullOrNil(((bws)localObject1).HjI.Hzt)) && (!bu.isNullOrNil(((bws)localObject1).HjI.oGf)))
              {
                ((SpannableStringBuilder)localObject2).append(((bws)localObject1).HjI.Hzt);
                ((SpannableStringBuilder)localObject2).setSpan(new q(new q.a()
                {
                  public final void dN(View paramAnonymousView)
                  {
                    AppMethodBeat.i(190084);
                    ae.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                    f.a(WalletLqtSaveFetchUI.this.getContext(), this.CWr.HjI.oGf, true, 1);
                    com.tencent.mm.plugin.report.service.g.yxI.f(20216, new Object[] { Integer.valueOf(1), this.CWr.HjI.oGf });
                    AppMethodBeat.o(190084);
                  }
                }), ((bws)localObject1).HjI.Hzs.length(), ((SpannableStringBuilder)localObject2).length(), 18);
              }
              this.CVI.setText((CharSequence)localObject2);
              this.CVI.setClickable(true);
              this.CVI.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(getContext()));
              this.CVI.setVisibility(0);
              this.CWn = getResources().getColor(2131099732);
              AppMethodBeat.o(69015);
              return;
              this.CVH.setText(getString(2131765024, new Object[] { this.CQi.field_bankName, this.CQi.field_bankcardTail }));
              break;
              label1294:
              localObject1 = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject1));
              u.a(new u.a()
              {
                public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
                {
                  AppMethodBeat.i(69008);
                  ar.f(new Runnable()
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
              localObject1 = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject1, getResources().getDimensionPixelOffset(2131167003), getResources().getDimensionPixelOffset(2131167003), true, false);
              this.CVJ.setImageBitmap((Bitmap)localObject1);
              break label715;
              label1366:
              this.CVM.setVisibility(8);
              continue;
              label1378:
              if (this.mode != 2) {
                continue;
              }
              findViewById(2131306747).setVisibility(8);
              this.CVU.setVisibility(8);
              this.CVM.setVisibility(8);
              this.CVL.setVisibility(8);
              localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.v.eFR();
              if ((this.CQi != null) && (this.CQi.eIy()))
              {
                i = getIntent().getIntExtra("lqt_balance", 0);
                if (com.tencent.mm.platformtools.ac.iSI) {
                  i = 50000000;
                }
                if (i <= 0) {
                  continue;
                }
                localObject1 = getString(2131765410, new Object[] { Double.valueOf(kw(String.valueOf(i), "100")) });
                int j = ((String)localObject1).length();
                localObject1 = new SpannableString((String)localObject1 + " " + getString(2131765413));
                ((SpannableString)localObject1).setSpan(new a(new a.a()
                {
                  public final void aRM()
                  {
                    AppMethodBeat.i(69006);
                    WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).setText(f.C(WalletLqtSaveFetchUI.ky(i, "100")));
                    WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
                    WalletLqtSaveFetchUI.this.showWcKb();
                    AppMethodBeat.o(69006);
                  }
                }), j, ((SpannableString)localObject1).length(), 18);
                this.CVY = ((CharSequence)localObject1);
                this.CVK.setText((CharSequence)localObject1);
                continue;
              }
              if (((com.tencent.mm.plugin.wallet.balance.model.lqt.v)localObject1).eFS() == null) {}
              for (i = 0;; i = ((com.tencent.mm.plugin.wallet.balance.model.lqt.v)localObject1).eFS().Hro)
              {
                if (((com.tencent.mm.plugin.wallet.balance.model.lqt.v)localObject1).eFS() != null) {
                  ((com.tencent.mm.plugin.wallet.balance.model.lqt.v)localObject1).eFS();
                }
                if (com.tencent.mm.platformtools.ac.iSI) {
                  i = 100000000;
                }
                localObject1 = getString(2131765385, new Object[] { Double.valueOf(kw(String.valueOf(i), "100")) });
                this.CVY = ((CharSequence)localObject1);
                this.CVK.setText((CharSequence)localObject1);
                break;
              }
            }
            this.CVI.setVisibility(8);
            this.CWn = getResources().getColor(2131099734);
          }
          AppMethodBeat.o(69015);
          return;
        }
        this.CVK.setText("");
        this.CVI.setVisibility(8);
      }
    }
    AppMethodBeat.o(69015);
  }
  
  private void uf(boolean paramBoolean)
  {
    AppMethodBeat.i(69022);
    ae.i("MicroMsg.WalletLqtSaveFetchUI", "check enable: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.CWj) });
    if ((!paramBoolean) || (this.CWj))
    {
      lG(false);
      AppMethodBeat.o(69022);
      return;
    }
    if (this.mode == 1)
    {
      if (this.CVM.getVisibility() == 0)
      {
        if ((this.CVO.isChecked()) && (this.CWg))
        {
          lG(true);
          AppMethodBeat.o(69022);
          return;
        }
        lG(false);
        AppMethodBeat.o(69022);
        return;
      }
      if (this.CWg)
      {
        lG(true);
        AppMethodBeat.o(69022);
      }
    }
    else
    {
      if ((this.CWg) && ((this.CVS.getSelectRedeemType() != null) || (this.CVS.getRedeemTypeList() == null) || (this.CVS.getRedeemTypeList().isEmpty())))
      {
        if (this.CVS.getSelectRedeemType() == null) {}
        for (Integer localInteger = null;; localInteger = Integer.valueOf(this.CVS.getSelectRedeemType().HyA))
        {
          ae.v("MicroMsg.WalletLqtSaveFetchUI", "redeem type: %s", new Object[] { localInteger });
          lG(true);
          AppMethodBeat.o(69022);
          return;
        }
      }
      lG(false);
    }
    AppMethodBeat.o(69022);
  }
  
  public final void aOP()
  {
    AppMethodBeat.i(69029);
    if (this.iXW != null) {
      this.iXW.dismiss();
    }
    AppMethodBeat.o(69029);
  }
  
  public final void bv(float paramFloat) {}
  
  public final void eGF()
  {
    AppMethodBeat.i(69012);
    if (this.mode == 1)
    {
      this.CVZ = com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.eFL();
      if (this.CVZ == null)
      {
        com.tencent.mm.plugin.wallet.a.s.eGW();
        this.CVZ = com.tencent.mm.plugin.wallet.a.s.eGX().CRg;
      }
      Object localObject;
      int i;
      if (this.CVZ != null)
      {
        localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.eFM();
        i = com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.eFN();
        if (i != 0) {
          break label189;
        }
        this.CVY = ((CharSequence)localObject);
        if (this.CVK != null) {
          this.CVK.setText(this.CVY);
        }
      }
      if (this.CVE != null) {
        this.CVE.setVisibility(0);
      }
      if (!bu.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.COR))
      {
        this.vHE.setText(com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.COR);
        this.vHE.setVisibility(0);
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.v.eFR().eFS();
        if ((localObject != null) && (((ceq)localObject).HgN) && (((ceq)localObject).Hru != null)) {
          af.a(getContext(), ((ceq)localObject).Hru);
        }
        ue(true);
        AppMethodBeat.o(69012);
        return;
        label189:
        if (i == 1)
        {
          i = ((String)localObject).length();
          localObject = new SpannableString((String)localObject + getString(2131765384));
          ((SpannableString)localObject).setSpan(new a(new a.a()
          {
            public final void aRM()
            {
              AppMethodBeat.i(69004);
              WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).setText(f.C(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).Dmj));
              WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
              WalletLqtSaveFetchUI.this.showWcKb();
              AppMethodBeat.o(69004);
            }
          }), i + 1, ((SpannableString)localObject).length(), 18);
          this.CVY = ((CharSequence)localObject);
          break;
        }
        ae.w("MicroMsg.WalletLqtSaveFetchUI", "unknown func: %s", new Object[] { Integer.valueOf(i) });
        this.CVY = ((CharSequence)localObject);
        break;
        this.vHE.setVisibility(8);
      }
    }
    if (this.CVS.CRV)
    {
      ue(false);
      AppMethodBeat.o(69012);
      return;
    }
    ue(true);
    AppMethodBeat.o(69012);
  }
  
  public final void eGK()
  {
    this.CWk = false;
  }
  
  public final void eGL()
  {
    AppMethodBeat.i(69031);
    ar.ay(this.ync);
    ar.ay(this.CWp);
    AppMethodBeat.o(69031);
  }
  
  public int getLayoutId()
  {
    return 2131495978;
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(69026);
    ae.d("MicroMsg.WalletLqtSaveFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.CWk), Boolean.valueOf(this.mWcKeyboard.fVu()) });
    if ((!this.CWk) && (this.mWcKeyboard.fVu()))
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
    ae.i("MicroMsg.WalletLqtSaveFetchUI", "onActivityResult() requestCode:%s", new Object[] { Integer.valueOf(paramInt1) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.CVD.CPX.iK(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(69027);
      return;
    }
    if (paramIntent != null) {
      paramIntent.putExtra(com.tencent.mm.plugin.wallet.balance.model.lqt.ac.CPF, this.CWe);
    }
    com.tencent.mm.plugin.wallet.balance.model.lqt.ac localac = this.CVC;
    String str;
    Object localObject;
    if ((paramInt1 == com.tencent.mm.plugin.wallet.balance.model.lqt.ac.CPD) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra(com.tencent.mm.plugin.wallet.balance.model.lqt.ac.CPF);
      paramIntent = (Orders)paramIntent.getParcelableExtra("key_orders");
      if ((paramIntent != null) && (paramIntent.DpP != null) && (paramIntent.DpP.size() > 0))
      {
        ae.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s, reqkey: %s", new Object[] { Integer.valueOf(localac.hashCode()), Integer.valueOf(localac.accountType), paramIntent.dmw });
        localac.dmx = ((Orders.Commodity)paramIntent.DpP.get(0)).dmx;
        paramIntent = (String)localac.CPP.get(paramIntent.dmw);
        if (!bu.isNullOrNil(paramIntent)) {
          localac.CPJ = paramIntent;
        }
        if ((localac.CPI instanceof WalletLqtSaveFetchUI))
        {
          ((WalletLqtSaveFetchUI)localac.CPI).CWk = true;
          ((WalletLqtSaveFetchUI)localac.CPI).eGL();
        }
        ae.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
        localac.CPI.showLoading(false);
        paramIntent = localac.CPI.getIntent().getStringExtra("operate_id");
        localObject = localac.CPH.CPz;
        com.tencent.mm.vending.g.g.a(localac.CPJ, localac.dmx, Integer.valueOf(localac.CPK), Integer.valueOf(localac.accountType), paramIntent, Integer.valueOf(localac.CPO)).c((com.tencent.mm.vending.c.a)localObject).f(new ac.7(localac, str)).a(new ac.6(localac));
      }
      AppMethodBeat.o(69027);
      return;
    }
    if ((paramInt1 == com.tencent.mm.plugin.wallet.balance.model.lqt.ac.CPE) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra(com.tencent.mm.plugin.wallet.balance.model.lqt.ac.CPF);
      localObject = paramIntent.getStringExtra("lqt_fetch_enc_pwd");
      paramIntent = paramIntent.getStringExtra("lqt_redeem_listid");
      ae.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", new Object[] { Integer.valueOf(localac.hashCode()), Integer.valueOf(localac.accountType), paramIntent });
      if ((localac.CPI instanceof WalletLqtSaveFetchUI))
      {
        ((WalletLqtSaveFetchUI)localac.CPI).CWk = true;
        ((WalletLqtSaveFetchUI)localac.CPI).eGL();
      }
      ae.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", new Object[] { Integer.valueOf(localac.hashCode()), paramIntent });
      if (bu.isNullOrNil(localac.CPM))
      {
        ae.i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", new Object[] { Integer.valueOf(localac.hashCode()), paramIntent });
        localac.CPM = paramIntent;
      }
      paramIntent = localac.CPI.getIntent().getStringExtra("operate_id");
      localac.CPI.showLoading(true);
      ab.c localc = localac.CPH.CPA;
      com.tencent.mm.vending.g.g.b(Integer.valueOf(localac.CPL), localObject, localac.CPM, Integer.valueOf(localac.accountType), paramIntent).c(localc).f(new ac.9(localac, str)).a(new ac.8(localac));
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
    ae.i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
    this.CVF = ((WalletFormView)findViewById(2131301701));
    this.CVJ = ((ImageView)findViewById(2131297166));
    this.CVK = ((TextView)findViewById(2131301698));
    this.CVL = ((TextView)findViewById(2131301699));
    this.CVG = ((TextView)findViewById(2131301702));
    this.CVH = ((TextView)findViewById(2131301638));
    this.CVR = ((TextView)findViewById(2131306836));
    this.vHE = ((TextView)findViewById(2131301706));
    this.CVX = ((TextView)findViewById(2131301700));
    this.CVM = ((ViewGroup)findViewById(2131301703));
    this.CVN = ((TextView)findViewById(2131301705));
    this.CVO = ((CheckBox)findViewById(2131301704));
    this.CVE = ((ViewGroup)findViewById(2131301985));
    this.CVP = ((TextView)findViewById(2131300742));
    this.CVQ = ((TextView)findViewById(2131300743));
    this.CVI = ((TextView)findViewById(2131307277));
    this.CVS = ((WalletLqtArriveTimeLayout)findViewById(2131301696));
    this.CVT = ((ScrollView)findViewById(2131301693));
    this.CVU = ((LinearLayout)findViewById(2131301675));
    this.CVW = ((TextView)findViewById(2131301676));
    this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
    int i = getIntent().getIntExtra("entrance_type", 0);
    this.CVC.mode = this.mode;
    this.CVC.CPO = i;
    this.CWa = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
    this.CWb = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
    this.CWc = getIntent().getStringExtra("lqt_profile_wording");
    this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.ajS();
      this.CWe = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXt, ""));
      if (bu.isNullOrNil(this.CWe))
      {
        com.tencent.mm.kernel.g.ajS();
        this.CWe = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXs, ""));
      }
      this.CWf = getIntent().getStringExtra("card_serial");
      ae.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", new Object[] { Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.CWe });
      this.CVF.getTitleTv().setText(ah.fWc());
      this.mWcKeyboard = ((WcPayKeyboard)findViewById(2131307020));
      paramBundle = (RelativeLayout.LayoutParams)this.mWcKeyboard.getLayoutParams();
      paramBundle.addRule(12);
      this.mWcKeyboard.setLayoutParams(paramBundle);
      if (this.mode != 1) {
        break label1107;
      }
      setWPKeyboard(this.CVF.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(2131765499));
      label636:
      if (com.tencent.mm.compatible.util.d.lC(27)) {
        this.CVF.fWE();
      }
      setWcKbHeightListener(this);
      if (this.mode != 1) {
        break label1142;
      }
      this.CVG.setText(getString(2131765491));
      this.CVR.setText(getString(2131765494));
      label692:
      this.CVF.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(190099);
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
            AppMethodBeat.o(190099);
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
          AppMethodBeat.i(190100);
          if (paramAnonymousBoolean)
          {
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
            {
              WalletLqtSaveFetchUI.r(WalletLqtSaveFetchUI.this);
              AppMethodBeat.o(190100);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1) {
              AppMethodBeat.o(190100);
            }
          }
          else
          {
            WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).scrollTo(0, 0);
            if ((WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) && (bu.isNullOrNil(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText()))) {
              WalletLqtSaveFetchUI.t(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(190100);
        }
      });
      paramBundle = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190109);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if (bu.aO(WalletLqtSaveFetchUI.u(WalletLqtSaveFetchUI.this)) < 800L)
          {
            ae.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(190109);
            return;
          }
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, bu.HQ());
          final int k = WalletLqtSaveFetchUI.kz(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText(), "100");
          if (k > 0)
          {
            WalletLqtSaveFetchUI.this.hideWcKb();
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) != 1) {
              break label260;
            }
            ae.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
            if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.COS))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(190109);
              return;
            }
            paramAnonymousView = WalletLqtSaveFetchUI.w(WalletLqtSaveFetchUI.this).CPU;
            com.tencent.mm.vending.g.g.h(Integer.valueOf(k), Integer.valueOf(WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this)), WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this)).c(paramAnonymousView).f(new com.tencent.mm.vending.c.a()
            {
              private Void a(cpk paramAnonymous2cpk)
              {
                AppMethodBeat.i(190103);
                ae.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", new Object[] { Integer.valueOf(paramAnonymous2cpk.HAV) });
                WalletLqtSaveFetchUI.this.eGL();
                Object localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                ((Intent)localObject).putExtra("key_amount", f.a(k, "100", 2, RoundingMode.HALF_UP));
                ((Intent)localObject).putExtra("key_mode", 1);
                ((Intent)localObject).putExtra("profile_date_wording", paramAnonymous2cpk.HAX);
                ((Intent)localObject).putExtra("profile_upgrade_wording", paramAnonymous2cpk.HAW);
                if (paramAnonymous2cpk.HAY != null) {}
                try
                {
                  ((Intent)localObject).putExtra("key_guide_cell", paramAnonymous2cpk.HAY.toByteArray());
                  ((Intent)localObject).putExtra("entrance_type", WalletLqtSaveFetchUI.this.getIntent().getIntExtra("entrance_type", 0));
                  paramAnonymous2cpk = WalletLqtSaveFetchUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2cpk, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2cpk.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2cpk, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  WalletLqtSaveFetchUI.this.finish();
                  paramAnonymous2cpk = LEs;
                  AppMethodBeat.o(190103);
                  return paramAnonymous2cpk;
                }
                catch (IOException paramAnonymous2cpk)
                {
                  for (;;)
                  {
                    ae.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramAnonymous2cpk, "", new Object[0]);
                  }
                }
              }
            }).a(new com.tencent.mm.vending.g.d.a()
            {
              public final void ce(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(190102);
                ae.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", new Object[] { paramAnonymous2Object });
                WalletLqtSaveFetchUI.this.aOP();
                if (paramAnonymous2Object != null) {
                  if (!(paramAnonymous2Object instanceof String)) {
                    break label74;
                  }
                }
                label74:
                for (paramAnonymous2Object = paramAnonymous2Object.toString();; paramAnonymous2Object = WalletLqtSaveFetchUI.this.getString(2131765420))
                {
                  com.tencent.mm.ui.base.h.d(WalletLqtSaveFetchUI.this, paramAnonymous2Object, "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(190101);
                      ae.i("MicroMsg.WalletLqtSaveFetchUI", "SAVE MMAlert Interrupt click");
                      AppMethodBeat.o(190101);
                    }
                  });
                  AppMethodBeat.o(190102);
                  return;
                }
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(190109);
            return;
            label260:
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
            {
              ae.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
              if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW.COT))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(190109);
                return;
              }
              localObject = null;
              paramAnonymousView = (View)localObject;
              if (WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this) != null)
              {
                paramAnonymousView = (View)localObject;
                if (!WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).eIy())
                {
                  paramAnonymousView = new in();
                  paramAnonymousView.uVs = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankName;
                  paramAnonymousView.dlT = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankcardType;
                  paramAnonymousView.FTN = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bindSerial;
                  paramAnonymousView.wSp = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankcardTail;
                }
              }
              int i = -1;
              if (WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getSelectRedeemType() != null) {
                i = WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getSelectRedeemType().HyA;
              }
              int j = i;
              if (WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this) != null)
              {
                j = i;
                if (!WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).eIy())
                {
                  ae.i("MicroMsg.WalletLqtSaveFetchUI", "choose bankcard");
                  int m = f.mN(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText(), "100");
                  localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.v.eFR().eFS();
                  if ((((ceq)localObject).Hrv >= 0) && (m > ((ceq)localObject).Hrv))
                  {
                    ae.i("MicroMsg.WalletLqtSaveFetchUI", "choose slow redeem");
                    WalletLqtSaveFetchUI.x(WalletLqtSaveFetchUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(190109);
                    return;
                  }
                  j = i;
                  if (((ceq)localObject).Hrv >= 0)
                  {
                    j = i;
                    if (m < ((ceq)localObject).Hrv)
                    {
                      ae.i("MicroMsg.WalletLqtSaveFetchUI", "choose fast redeem");
                      j = 0;
                    }
                  }
                }
              }
              WalletLqtSaveFetchUI.w(WalletLqtSaveFetchUI.this).CPV.a(k, WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this), j, paramAnonymousView).f(new com.tencent.mm.vending.c.a()
              {
                private Void a(ctf paramAnonymous2ctf)
                {
                  AppMethodBeat.i(190107);
                  ae.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", new Object[] { paramAnonymous2ctf, Boolean.valueOf(paramAnonymous2ctf.HEl), Boolean.valueOf(paramAnonymous2ctf.HEm) });
                  WalletLqtSaveFetchUI.this.eGL();
                  Object localObject;
                  if ((paramAnonymous2ctf.HEl) && (paramAnonymous2ctf.HEm))
                  {
                    localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                    ((Intent)localObject).putExtra("key_amount", f.a(k, "100", 2, RoundingMode.HALF_UP));
                    ((Intent)localObject).putExtra("key_mode", 2);
                    paramAnonymous2ctf = WalletLqtSaveFetchUI.this;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2ctf, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymous2ctf.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2ctf, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  for (;;)
                  {
                    WalletLqtSaveFetchUI.this.finish();
                    paramAnonymous2ctf = LEs;
                    AppMethodBeat.o(190107);
                    return paramAnonymous2ctf;
                    localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishProgressNewUI.class);
                    try
                    {
                      ((Intent)localObject).putExtra("key_redeem_res", paramAnonymous2ctf.toByteArray());
                      paramAnonymous2ctf = WalletLqtSaveFetchUI.this;
                      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2ctf, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramAnonymous2ctf.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2ctf, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    catch (Exception paramAnonymous2ctf)
                    {
                      for (;;)
                      {
                        ae.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramAnonymous2ctf, "pass redeemFundRes error: %s", new Object[] { paramAnonymous2ctf.getMessage() });
                      }
                    }
                  }
                }
              }).a(new com.tencent.mm.vending.g.d.a()
              {
                public final void ce(Object paramAnonymous2Object)
                {
                  boolean bool = false;
                  AppMethodBeat.i(190106);
                  WalletLqtSaveFetchUI.this.CWk = false;
                  WalletLqtSaveFetchUI.this.aOP();
                  if (paramAnonymous2Object != null)
                  {
                    if ((paramAnonymous2Object instanceof ctf)) {
                      bool = com.tencent.mm.wallet_core.d.h.a(WalletLqtSaveFetchUI.this, null, 1000, ((ctf)paramAnonymous2Object).oGt, ((ctf)paramAnonymous2Object).oGu);
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
                        AppMethodBeat.i(190105);
                        ae.i("MicroMsg.WalletLqtSaveFetchUI", "fetch MMAlert Interrupt click");
                        AppMethodBeat.o(190105);
                      }
                    });
                    AppMethodBeat.o(190106);
                    return;
                  }
                }
              });
            }
          }
        }
      };
      this.CVF.getContentEt().setOnEditorActionListener(new WalletLqtSaveFetchUI.15(this, paramBundle));
      if (!bu.isNullOrNil(this.CWc)) {
        this.mWcKeyboard.setTipText(this.CWc);
      }
      if (this.mode == 2) {
        this.CVS.setCallback(new WalletLqtArriveTimeLayout.a()
        {
          public final void eGo()
          {
            AppMethodBeat.i(190111);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, true);
            AppMethodBeat.o(190111);
          }
        });
      }
      this.CVK.setText("");
      this.CVK.setClickable(true);
      this.CVK.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      uf(false);
      this.CVW.setClickable(true);
      this.CVW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      if (this.mode != 1) {
        break label1191;
      }
      this.CVE.setVisibility(4);
      if (i != 8) {
        break label1181;
      }
      setMMTitle(2131765498);
      this.mWcKeyboard.showNormalStWcKb();
    }
    for (;;)
    {
      if (this.CVH.findViewById(2131306835) != null) {
        this.CVH.findViewById(2131306835).setVisibility(8);
      }
      paramBundle = new WalletLqtSaveFetchUI.1(this);
      this.CVH.setOnClickListener(paramBundle);
      if (findViewById(2131297947) != null) {
        findViewById(2131297947).setOnClickListener(paramBundle);
      }
      eGF();
      paramBundle = com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW;
      s.a locala = this.CWo;
      paramBundle.COV.add(locala);
      this.CVE.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(68982);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if ((WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this).isShown()) && (WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).fVs()))
          {
            WalletLqtSaveFetchUI.d(WalletLqtSaveFetchUI.this).fVq();
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(68982);
            return true;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(68982);
          return false;
        }
      });
      this.state = 1;
      paramBundle = getIntent().getStringExtra("fill_money");
      if (bu.getDouble(paramBundle, 0.0D) > 0.0D)
      {
        this.CVF.setText(paramBundle);
        cj(paramBundle, false);
      }
      if ((this.mode == 2) && (com.tencent.mm.plugin.wallet.balance.model.lqt.v.eFR().eFS() == null)) {
        showLoading(false);
      }
      AppMethodBeat.o(69010);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.f(20287, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.kernel.g.ajS();
      this.CWe = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXu, ""));
      break;
      label1107:
      this.isVKBFirstTimeShown = false;
      setWPKeyboard(this.CVF.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(2131765415));
      break label636;
      label1142:
      if (this.mode != 2) {
        break label692;
      }
      this.CVG.setText(getString(2131765397));
      this.CVR.setText(getString(2131765402));
      break label692;
      label1181:
      setMMTitle(2131765499);
      continue;
      label1191:
      setMMTitle(2131765415);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69030);
    super.onDestroy();
    eGL();
    com.tencent.mm.plugin.wallet.balance.model.lqt.s locals = com.tencent.mm.plugin.wallet.balance.model.lqt.s.COW;
    s.a locala = this.CWo;
    locals.COV.remove(locala);
    this.CVC = null;
    this.CVD = null;
    AppMethodBeat.o(69030);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(69025);
    ae.i("MicroMsg.WalletLqtSaveFetchUI", "onDialogDismiss()");
    ar.o(this.ync, 300L);
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
    ae.i("MicroMsg.WalletLqtSaveFetchUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    paramIntent = eGI();
    this.CVD.CPX.iK(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(69017);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69024);
    super.onPause();
    ae.i("MicroMsg.WalletLqtSaveFetchUI", "onPause()");
    if (!this.mWcKeyboard.fVt()) {
      this.state = 3;
    }
    AppMethodBeat.o(69024);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69023);
    super.onResume();
    ae.i("MicroMsg.WalletLqtSaveFetchUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      ar.o(this.CWp, 300L);
    }
    this.state = 2;
    AppMethodBeat.o(69023);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(69028);
    com.tencent.mm.plugin.wallet.balance.model.lqt.ac localac = this.CVC;
    ae.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
    {
      com.tencent.mm.plugin.wallet.a.s.eGW();
      localac.CPN = com.tencent.mm.plugin.wallet.a.s.eGX().CRg;
      if (localac.iVo != null)
      {
        localac.iVo.F(new Object[] { paramn });
        localac.iVo.resume();
      }
    }
    ae.i("MicroMsg.WalletLqtSaveFetchUI", "onSceneEnd");
    eGF();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI
 * JD-Core Version:    0.7.0.1
 */