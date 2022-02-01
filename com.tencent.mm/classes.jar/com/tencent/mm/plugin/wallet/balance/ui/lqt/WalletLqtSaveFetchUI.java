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
import com.tencent.mm.g.a.ks;
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
import com.tencent.mm.plugin.wallet.balance.model.lqt.v;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.dnd;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ac CDW;
  private com.tencent.mm.plugin.wallet.balance.model.lqt.ad CDX;
  private ViewGroup CDY;
  private WalletFormView CDZ;
  private List<Bankcard> CEA;
  private boolean CEB;
  private boolean CEC;
  protected boolean CED;
  private String CEE;
  private boolean CEF;
  private int CEG;
  private s.a CEH;
  private Runnable CEI;
  private TextView CEa;
  private TextView CEb;
  private TextView CEc;
  private ImageView CEd;
  private TextView CEe;
  private TextView CEf;
  private ViewGroup CEg;
  private TextView CEh;
  private CheckBox CEi;
  private TextView CEj;
  private TextView CEk;
  private TextView CEl;
  private WalletLqtArriveTimeLayout CEm;
  private ScrollView CEn;
  private LinearLayout CEo;
  private TextView CEp;
  private TextView CEq;
  private CharSequence CEr;
  private Bankcard CEs;
  private int CEt;
  private String CEu;
  private String CEv;
  private long CEw;
  private String CEx;
  private String CEy;
  private boolean CEz;
  private Bankcard CyD;
  private aa Cyb;
  private ab Cyc;
  private int accountType;
  private Dialog iVd;
  private int mode;
  private int state;
  private HashMap<String, Integer> vhT;
  private TextView vvA;
  private com.tencent.mm.sdk.b.c<ks> wxJ;
  public Runnable xXi;
  
  public WalletLqtSaveFetchUI()
  {
    AppMethodBeat.i(69009);
    this.Cyb = ((aa)aq(aa.class));
    this.Cyc = ((ab)am(ab.class));
    this.CDW = new com.tencent.mm.plugin.wallet.balance.model.lqt.ac(this.Cyb, this.Cyc, this);
    this.CDX = new com.tencent.mm.plugin.wallet.balance.model.lqt.ad(this.CDW);
    this.CEw = -1L;
    this.CEz = false;
    this.CEB = true;
    this.CEC = false;
    this.CED = false;
    this.CEE = "";
    this.CEF = false;
    this.CEG = aj.getContext().getResources().getColor(2131099734);
    this.CEH = new s.a()
    {
      public final void eCh()
      {
        AppMethodBeat.i(69002);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "cache updated");
        WalletLqtSaveFetchUI.this.hideLoading();
        WalletLqtSaveFetchUI.this.eCY();
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
    this.vhT = new HashMap();
    this.state = 0;
    this.xXi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199258);
        if ((WalletLqtSaveFetchUI.y(WalletLqtSaveFetchUI.this) == 2) && (WalletLqtSaveFetchUI.this.isHandleAutoShowNormalStWcKb())) {
          WalletLqtSaveFetchUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(199258);
      }
    };
    this.CEI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199259);
        WalletLqtSaveFetchUI.this.showNormalStWcKb();
        AppMethodBeat.o(199259);
      }
    };
    this.wxJ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(69009);
  }
  
  private void F(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(69014);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "update arrive time layout: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    is localis;
    if (this.mode == 2)
    {
      localObject = v.eCj().eCk();
      if (!this.CEm.CAq)
      {
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletLqtSaveFetchUI", "no cache!");
          AppMethodBeat.o(69014);
          return;
        }
        if (this.CyD.eER())
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
          this.CEm.q(((cdw)localObject).GXS, false);
          this.CEm.aDS(paramString);
        }
        for (;;)
        {
          this.CEm.setVisibility(4);
          eDc();
          AppMethodBeat.o(69014);
          return;
          if (((cdw)localObject).GXT != null)
          {
            localObject = ((cdw)localObject).GXT.iterator();
            while (((Iterator)localObject).hasNext())
            {
              localis = (is)((Iterator)localObject).next();
              if (localis.FBs.equals(this.CyD.field_bindSerial))
              {
                com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                this.CEm.q(localis.FBI, false);
                this.CEm.aDS(paramString);
              }
            }
          }
        }
      }
      if (paramBoolean)
      {
        if (!this.CyD.eER()) {
          break label273;
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
        this.CEm.q(((cdw)localObject).GXS, true);
      }
    }
    for (;;)
    {
      this.CEm.setVisibility(4);
      this.CEm.aDS(paramString);
      AppMethodBeat.o(69014);
      return;
      label273:
      if (((cdw)localObject).GXT != null)
      {
        localObject = ((cdw)localObject).GXT.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localis = (is)((Iterator)localObject).next();
          if (localis.FBs.equals(this.CyD.field_bindSerial))
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
            this.CEm.q(localis.FBI, true);
          }
        }
      }
    }
  }
  
  private boolean aDZ(String paramString)
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
          localObject1 = new com.tencent.mm.ui.widget.a.d.a(getContext());
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).yR(false);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).aXG(paramString);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).aXN(str1);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).aXM(str2);
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).a(true, new WalletLqtSaveFetchUI.31(this, (String)localObject2));
          ((com.tencent.mm.ui.widget.a.d.a)localObject1).fMb().show();
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
  
  private void cf(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(182506);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "update tips: %s", new Object[] { paramString });
    long l = com.tencent.mm.wallet_core.ui.e.mI(String.valueOf(paramString), "100");
    Object localObject;
    if (l > 0L) {
      if (this.mode == 1) {
        if (this.CyD != null) {
          if (this.CyD.eER())
          {
            if ((this.CEs != null) && (l > kq(this.CEs.CUD, "100")))
            {
              this.CEe.setText(getString(2131765492));
              this.CEe.setTextColor(getResources().getColor(2131099804));
              this.CEz = false;
              tY(false);
              if (l > 0L) {
                break label1279;
              }
              this.CEB = true;
              AppMethodBeat.o(182506);
              return;
            }
            if ((com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxl >= 0) && (l > com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxl) && (!bt.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxi)) && (!bt.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxj)) && (!bt.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxk)))
            {
              paramString = new q(new q.a()
              {
                public final void dN(View paramAnonymousView)
                {
                  AppMethodBeat.i(199255);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                  com.tencent.mm.wallet_core.ui.e.a(WalletLqtSaveFetchUI.this.getContext(), com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxk, true, 1);
                  AppMethodBeat.o(199255);
                }
              });
              localObject = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject).append(com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxi);
              ((SpannableStringBuilder)localObject).append(com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxj);
              ((SpannableStringBuilder)localObject).setSpan(paramString, com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxi.length(), ((SpannableStringBuilder)localObject).length(), 18);
              if ((this.CEe.getText() == null) || (!this.CEe.getText().equals(((SpannableStringBuilder)localObject).toString()))) {
                com.tencent.mm.plugin.report.service.g.yhR.f(17084, new Object[] { Integer.valueOf(9) });
              }
              this.CEe.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(getContext()));
              this.CEe.setClickable(true);
              this.CEe.setText((CharSequence)localObject);
            }
          }
        }
      }
    }
    for (;;)
    {
      this.CEe.setTextColor(this.CEG);
      this.CEz = false;
      tY(false);
      break;
      this.CEe.setText(this.CEr);
      this.CEe.setTextColor(this.CEG);
      this.CEz = true;
      tY(true);
      break;
      if ((this.CyD.field_dayQuotaKind > 0.0D) && (l > kq(this.CyD.field_dayQuotaKind, "100")))
      {
        this.CEe.setText(getString(2131765493));
        this.CEe.setTextColor(getResources().getColor(2131099804));
        this.CEz = false;
        tY(false);
        break;
      }
      this.CEe.setText("");
      this.CEz = true;
      tY(true);
      break;
      this.CEz = true;
      tY(true);
      break;
      if (this.mode != 2) {
        break;
      }
      localObject = v.eCj();
      int k;
      label587:
      int i;
      int j;
      if (((v)localObject).eCk() == null)
      {
        k = 0;
        if ((this.CyD == null) || (!this.CyD.eER())) {
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
            this.CEe.setText(getString(2131765398));
            this.CEe.setTextColor(getResources().getColor(2131099804));
            this.CEz = false;
            eCZ();
            tY(false);
            this.CEo.setVisibility(8);
            break;
            k = ((v)localObject).eCk().GXO;
            break label587;
            label702:
            cdw localcdw = v.eCj().eCk();
            if (localcdw == null)
            {
              i = 0;
              j = 0;
              continue;
            }
            i = localcdw.GXQ;
            j = 0;
            continue;
          }
          this.CEe.setText(this.CEr);
          this.CEe.setTextColor(this.CEG);
          this.CEz = true;
          F(paramBoolean, paramString);
          tY(true);
          this.CEo.setVisibility(8);
          break;
        }
      }
      if (l > k)
      {
        this.CEe.setText(getString(2131765398));
        this.CEe.setTextColor(getResources().getColor(2131099804));
        this.CEo.setVisibility(8);
        this.CEz = false;
        eCZ();
        tY(false);
        this.CEo.setVisibility(8);
        break;
      }
      if (l > i)
      {
        paramString = getString(2131765385, new Object[] { Double.valueOf(kp(String.valueOf(k), "100")) });
        this.CEe.setTextColor(this.CEG);
        this.CEe.setText(paramString);
        this.CEo.setVisibility(0);
        paramString = getString(2131765409, new Object[] { Double.valueOf(kp(String.valueOf(i), "100")) });
        i = paramString.length();
        paramString = new SpannableString(paramString + getString(2131765412));
        paramString.setSpan(new a(new a.a()
        {
          public final void aRn()
          {
            AppMethodBeat.i(199256);
            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, this.CEU.eCk());
            AppMethodBeat.o(199256);
          }
        }), i, paramString.length(), 18);
        this.CEp.setText(paramString);
        this.CEz = false;
        eCZ();
        tY(false);
        break;
      }
      if ((this.CyD != null) && (!this.CyD.eER()) && (this.CyD.field_dayQuotaKind > 0.0D) && (l > kq(this.CyD.field_dayQuotaKind, "100")))
      {
        this.CEo.setVisibility(0);
        this.CEp.setText(getString(2131765400, new Object[] { Double.valueOf(this.CyD.field_dayQuotaKind) }));
        this.CEz = false;
        eCZ();
        tY(false);
        break;
      }
      this.CEe.setText(this.CEr);
      this.CEe.setTextColor(this.CEG);
      this.CEz = true;
      F(paramBoolean, paramString);
      tY(true);
      this.CEo.setVisibility(8);
      break;
      if (this.mode == 1)
      {
        if ((this.CyD != null) && (this.CyD.eER())) {
          this.CEe.setText(this.CEr);
        } else {
          this.CEe.setText("");
        }
      }
      else
      {
        this.CEe.setText(this.CEr);
        eCZ();
      }
    }
    label1279:
    this.CEB = false;
    AppMethodBeat.o(182506);
  }
  
  private void eCZ()
  {
    AppMethodBeat.i(69013);
    WalletLqtArriveTimeLayout localWalletLqtArriveTimeLayout = this.CEm;
    localWalletLqtArriveTimeLayout.CAq = false;
    if (localWalletLqtArriveTimeLayout.CAm != null) {
      localWalletLqtArriveTimeLayout.CAm.clear();
    }
    localWalletLqtArriveTimeLayout.CAo = null;
    localWalletLqtArriveTimeLayout.CAn.clear();
    localWalletLqtArriveTimeLayout.setVisibility(4);
    AppMethodBeat.o(69013);
  }
  
  private void eDa()
  {
    AppMethodBeat.i(199272);
    this.vhT.clear();
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this, 2, true);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr;
    this.CEA = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Vg(this.mode);
    localObject1 = null;
    if (this.CyD != null) {
      localObject1 = this.CyD.field_bindSerial;
    }
    Object localObject2 = localObject1;
    if (bt.isNullOrNil((String)localObject1))
    {
      localObject2 = this.CEx;
      if (bt.isNullOrNil(this.CEx)) {
        com.tencent.mm.kernel.g.ajD();
      }
    }
    for (localObject1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICS, "");; localObject1 = localObject2)
    {
      int i = 0;
      int k;
      for (int j = 0; i < this.CEA.size(); j = k)
      {
        localObject2 = (Bankcard)this.CEA.get(i);
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
      locale.KJy = new n.d()
      {
        public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(199231);
          int j = WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).size();
          int i = 0;
          final Bankcard localBankcard;
          Object localObject1;
          if (i < j)
          {
            localBankcard = (Bankcard)WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).get(i);
            localObject1 = com.tencent.mm.plugin.wallet_core.d.b.i(WalletLqtSaveFetchUI.this, localBankcard.field_bankcardType, localBankcard.eEQ());
            if (localObject1 == null) {
              break label917;
            }
          }
          label917:
          for (final String str1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject1).wqa;; str1 = "")
          {
            Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str1));
            com.tencent.mm.platformtools.u.a(new u.a()
            {
              public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(199228);
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(199227);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletLqtSaveFetchUI.3.1.this.wBa });
                    if (WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).containsKey(paramAnonymous2String))
                    {
                      int i = ((Integer)WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).get(paramAnonymous2String)).intValue();
                      if ((i < WalletLqtSaveFetchUI.3.1.this.vic.size()) && (WalletLqtSaveFetchUI.3.1.this.vic.getItem(i) != null))
                      {
                        WalletLqtSaveFetchUI.3.1.this.vic.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.a(paramAnonymous2Bitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), true, false)));
                        WalletLqtSaveFetchUI.3.this.jlr.fMg();
                      }
                    }
                    AppMethodBeat.o(199227);
                  }
                });
                AppMethodBeat.o(199228);
              }
            });
            Drawable localDrawable = null;
            Object localObject4 = null;
            localObject1 = "";
            if (!bt.isNullOrNil(localBankcard.field_forbidWord)) {
              localObject1 = localBankcard.field_forbidWord;
            }
            Object localObject3;
            Object localObject2;
            label161:
            String str2;
            if (bt.isNullOrNil(localBankcard.field_forbid_title))
            {
              localObject3 = new SpannableStringBuilder((CharSequence)localObject1);
              localObject2 = localObject1;
              localObject1 = localObject3;
              localObject3 = localObject1;
              if (bt.ai((CharSequence)localObject1))
              {
                localObject3 = localObject1;
                if (!bt.isNullOrNil(localBankcard.field_prompt_info_prompt_text))
                {
                  localObject1 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
                  localObject3 = localObject1;
                  if (!bt.isNullOrNil(localBankcard.field_prompt_info_jump_text))
                  {
                    localObject3 = localObject1;
                    if (!bt.isNullOrNil(localBankcard.field_prompt_info_jump_url))
                    {
                      ((SpannableStringBuilder)localObject1).append(localBankcard.field_prompt_info_jump_text);
                      ((SpannableStringBuilder)localObject1).setSpan(new q(new q.a()
                      {
                        public final void dN(View paramAnonymous2View)
                        {
                          AppMethodBeat.i(199230);
                          com.tencent.mm.wallet_core.ui.e.aW(WalletLqtSaveFetchUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
                          com.tencent.mm.plugin.report.service.g.yhR.f(20216, new Object[] { Integer.valueOf(2), localBankcard.field_prompt_info_jump_url });
                          AppMethodBeat.o(199230);
                        }
                      }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject1).length(), 33);
                      localObject3 = localObject1;
                    }
                  }
                }
              }
              str2 = localBankcard.field_desc;
              if (!localBankcard.eER()) {
                break label602;
              }
              localObject1 = str2;
              if (localBankcard.CUD >= 0.0D) {
                localObject1 = str2 + WalletLqtSaveFetchUI.this.getString(2131764999, new Object[] { com.tencent.mm.wallet_core.ui.e.D(localBankcard.CUD) });
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), localObject1, localObject3 });
              localDrawable = WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234612);
              if (bt.isNullOrNil((String)localObject2)) {
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
                  AppMethodBeat.i(199229);
                  paramAnonymous2View = localBankcard.field_forbid_url;
                  Intent localIntent = new Intent();
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "go to url %s", new Object[] { paramAnonymous2View });
                  localIntent.putExtra("rawUrl", paramAnonymous2View);
                  localIntent.putExtra("geta8key_username", com.tencent.mm.model.u.aAm());
                  localIntent.putExtra("pay_channel", 1);
                  com.tencent.mm.wallet_core.ui.e.an(WalletLqtSaveFetchUI.this.getContext(), localIntent);
                  AppMethodBeat.o(199229);
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
              localObject1 = com.tencent.mm.sdk.platformtools.g.a(localBitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(2131167003), true, false);
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localObject3 });
            if (localObject1 == null)
            {
              localObject4 = null;
              label680:
              if (bt.isNullOrNil((String)localObject2)) {
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
            localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr;
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              bool = true;
              ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tS(bool);
              if (!bool) {
                break label803;
              }
              localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).Cxb;
              label766:
              if (localObject1 == null) {
                break label813;
              }
            }
            label803:
            label813:
            for (bool = ((bvy)localObject1).GQa;; bool = false)
            {
              if (!bool) {
                break label819;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
              AppMethodBeat.o(199231);
              return;
              bool = false;
              break;
              localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).Cxc;
              break label766;
            }
            label819:
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              paramAnonymousl.a(j, WalletLqtSaveFetchUI.this.getString(2131765496), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234603), false);
              AppMethodBeat.o(199231);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) {
              paramAnonymousl.a(j, WalletLqtSaveFetchUI.this.getString(2131765404), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(2131234603), false);
            }
            AppMethodBeat.o(199231);
            return;
          }
        }
      };
      locale.JXC = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(199232);
          WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this).clear();
          AppMethodBeat.o(199232);
        }
      };
      locale.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(199233);
          if (locale != null)
          {
            locale.bpT();
            if (paramAnonymousInt < WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).size())
            {
              paramAnonymousMenuItem = (Bankcard)WalletLqtSaveFetchUI.l(WalletLqtSaveFetchUI.this).get(paramAnonymousInt);
              WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, paramAnonymousMenuItem.field_bindSerial);
              WalletLqtSaveFetchUI.n(WalletLqtSaveFetchUI.this);
              if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
              {
                WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).dEe();
                AppMethodBeat.o(199233);
                return;
              }
              WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText());
              AppMethodBeat.o(199233);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1)
            {
              WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
              AppMethodBeat.o(199233);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) {
              WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(199233);
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
        locale.xpt = true;
        locale.iKS = j;
        locale.KWX = true;
        locale.K((View)localObject1, false);
        locale.cMW();
        AppMethodBeat.o(199272);
        return;
        ((TextView)((View)localObject1).findViewById(2131301708)).setText(2131765396);
        ((TextView)((View)localObject1).findViewById(2131301707)).setText(2131765395);
      }
    }
  }
  
  private List<Bankcard> eDb()
  {
    AppMethodBeat.i(69016);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tQ(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.eDp();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.eDq().eGy();
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
        if (localBankcard.eER())
        {
          com.tencent.mm.plugin.wallet.a.s.eDp();
          if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGc())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((this.mode == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.eER()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((this.mode == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.eER()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label200:
    AppMethodBeat.o(69016);
    return localObject2;
  }
  
  private void eDc()
  {
    AppMethodBeat.i(69019);
    this.CEn.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199254);
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        WalletLqtSaveFetchUI.this.findViewById(2131301702).getLocationInWindow(arrayOfInt1);
        WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).getLocationInWindow(arrayOfInt2);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
        WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
        AppMethodBeat.o(199254);
      }
    }, 100L);
    AppMethodBeat.o(69019);
  }
  
  private static double kp(String paramString1, String paramString2)
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
  
  private static int kq(String paramString1, String paramString2)
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
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(69021);
    this.mWcKeyboard.zj(paramBoolean);
    AppMethodBeat.o(69021);
  }
  
  private void tX(boolean paramBoolean)
  {
    AppMethodBeat.i(69015);
    Object localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr;
    boolean bool;
    Object localObject2;
    if (this.mode == 1)
    {
      bool = true;
      localObject2 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tQ(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.eDp();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.eDq().eGy();
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
        if (localBankcard.eER())
        {
          com.tencent.mm.plugin.wallet.a.s.eDp();
          if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGc())
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
      if (!bt.isNullOrNil(this.CEy))
      {
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject1 = (Bankcard)((List)localObject2).get(i);
          if ((!bt.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.CEy.equals(((Bankcard)localObject1).field_bindSerial))) {
            this.CyD = ((Bankcard)localObject1);
          }
          i += 1;
        }
      }
      if ((bt.isNullOrNil(this.CEy)) || (this.CyD == null))
      {
        localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr;
        if (this.mode == 1) {}
        for (bool = true;; bool = false)
        {
          this.CyD = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tP(bool);
          if ((bt.isNullOrNil(this.CEx)) || (this.CyD != null)) {
            break;
          }
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject1 = (Bankcard)((List)localObject2).get(i);
            if ((!bt.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.CEx.equals(((Bankcard)localObject1).field_bindSerial))) {
              this.CyD = ((Bankcard)localObject1);
            }
            i += 1;
          }
        }
      }
    }
    else if (!bt.isNullOrNil(this.CEx))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = (Bankcard)((List)localObject2).get(i);
        if ((!bt.isNullOrNil(((Bankcard)localObject1).field_bindSerial)) && (this.CEx.equals(((Bankcard)localObject1).field_bindSerial))) {
          this.CyD = ((Bankcard)localObject1);
        }
        i += 1;
      }
    }
    if (this.CyD != null) {}
    for (localObject1 = this.CyD.field_bindSerial;; localObject1 = "")
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "defaultBankcard: %s, save mCurrentSerial: %s, useDefault: %s", new Object[] { localObject1, this.CEx, Boolean.valueOf(paramBoolean) });
      if (this.CyD != null) {
        break;
      }
      com.tencent.mm.plugin.wallet.a.s.eDp();
      this.CyD = com.tencent.mm.plugin.wallet.a.s.eDq().CzB;
      if (this.CyD != null) {
        break;
      }
      finish();
      AppMethodBeat.o(69015);
      return;
    }
    if (this.CyD.eER())
    {
      this.CEb.setText(this.CyD.field_desc);
      this.CEb.setText(this.CyD.field_desc);
      this.CEb.setVisibility(0);
      this.CEd.setTag(this.CyD.field_bindSerial);
      if (this.CEd != null)
      {
        localObject1 = "";
        localObject2 = com.tencent.mm.plugin.wallet_core.d.b.i(this, this.CyD.field_bankcardType, this.CyD.eEQ());
        if (localObject2 != null) {
          localObject1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject2).wqa;
        }
        this.CEd.setImageBitmap(null);
        if (!this.CyD.eER()) {
          break label1294;
        }
        this.CEd.setImageResource(2131234612);
      }
      label715:
      this.CEj.setVisibility(8);
      this.CEk.setVisibility(8);
      if ((this.mode != 2) && (this.mode == 1) && (!this.CyD.eER()) && (!bt.isNullOrNil(this.CyD.field_avail_save_wording)))
      {
        this.CEj.setText(this.CyD.field_avail_save_wording);
        this.CEj.setVisibility(0);
      }
      if (this.mode != 1) {
        break label1378;
      }
      localObject1 = getIntent().getStringArrayListExtra("lqt_protocol_list");
      paramBoolean = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0) || (!paramBoolean)) {
        break label1366;
      }
      this.CEg.setVisibility(0);
      this.CEi.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
      this.CEg.setOnClickListener(new WalletLqtSaveFetchUI.8(this));
      this.CEi.setOnCheckedChangeListener(new WalletLqtSaveFetchUI.9(this));
      localObject2 = getString(2131765483);
      i = ((String)localObject2).length();
      localObject2 = new SpannableString((String)localObject2 + getString(2131765484));
      ((SpannableString)localObject2).setSpan(new a(new WalletLqtSaveFetchUI.10(this, (ArrayList)localObject1)), i, ((SpannableString)localObject2).length(), 17);
      this.CEh.setText((CharSequence)localObject2);
      this.CEh.setClickable(true);
      this.CEh.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n());
    }
    for (;;)
    {
      if (this.mode == 1)
      {
        if ((this.CyD != null) && (this.CyD.eER()))
        {
          this.CEe.setText(this.CEr);
          localObject1 = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr;
          ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).tS(true);
          localObject1 = ((com.tencent.mm.plugin.wallet.balance.model.lqt.s)localObject1).Cxb;
          if (localObject1 != null)
          {
            if ((((bvy)localObject1).GQh != null) && (!bt.isNullOrNil(((bvy)localObject1).GQh.HfS)))
            {
              localObject2 = new SpannableStringBuilder(((bvy)localObject1).GQh.HfS);
              if ((!bt.isNullOrNil(((bvy)localObject1).GQh.HfT)) && (!bt.isNullOrNil(((bvy)localObject1).GQh.ozD)))
              {
                ((SpannableStringBuilder)localObject2).append(((bvy)localObject1).GQh.HfT);
                ((SpannableStringBuilder)localObject2).setSpan(new q(new q.a()
                {
                  public final void dN(View paramAnonymousView)
                  {
                    AppMethodBeat.i(199226);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                    com.tencent.mm.wallet_core.ui.e.a(WalletLqtSaveFetchUI.this.getContext(), this.CEK.GQh.ozD, true, 1);
                    com.tencent.mm.plugin.report.service.g.yhR.f(20216, new Object[] { Integer.valueOf(1), this.CEK.GQh.ozD });
                    AppMethodBeat.o(199226);
                  }
                }), ((bvy)localObject1).GQh.HfS.length(), ((SpannableStringBuilder)localObject2).length(), 18);
              }
              this.CEc.setText((CharSequence)localObject2);
              this.CEc.setClickable(true);
              this.CEc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(getContext()));
              this.CEc.setVisibility(0);
              this.CEG = getResources().getColor(2131099732);
              AppMethodBeat.o(69015);
              return;
              this.CEb.setText(getString(2131765024, new Object[] { this.CyD.field_bankName, this.CyD.field_bankcardTail }));
              break;
              label1294:
              localObject1 = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject1));
              com.tencent.mm.platformtools.u.a(new u.a()
              {
                public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
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
              localObject1 = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject1, getResources().getDimensionPixelOffset(2131167003), getResources().getDimensionPixelOffset(2131167003), true, false);
              this.CEd.setImageBitmap((Bitmap)localObject1);
              break label715;
              label1366:
              this.CEg.setVisibility(8);
              continue;
              label1378:
              if (this.mode != 2) {
                continue;
              }
              findViewById(2131306747).setVisibility(8);
              this.CEo.setVisibility(8);
              this.CEg.setVisibility(8);
              this.CEf.setVisibility(8);
              localObject1 = v.eCj();
              if ((this.CyD != null) && (this.CyD.eER()))
              {
                i = getIntent().getIntExtra("lqt_balance", 0);
                if (com.tencent.mm.platformtools.ac.iPP) {
                  i = 50000000;
                }
                if (i <= 0) {
                  continue;
                }
                localObject1 = getString(2131765410, new Object[] { Double.valueOf(kp(String.valueOf(i), "100")) });
                int j = ((String)localObject1).length();
                localObject1 = new SpannableString((String)localObject1 + " " + getString(2131765413));
                ((SpannableString)localObject1).setSpan(new a(new a.a()
                {
                  public final void aRn()
                  {
                    AppMethodBeat.i(69006);
                    WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).setText(com.tencent.mm.wallet_core.ui.e.C(WalletLqtSaveFetchUI.kr(i, "100")));
                    WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
                    WalletLqtSaveFetchUI.this.showWcKb();
                    AppMethodBeat.o(69006);
                  }
                }), j, ((SpannableString)localObject1).length(), 18);
                this.CEr = ((CharSequence)localObject1);
                this.CEe.setText((CharSequence)localObject1);
                continue;
              }
              if (((v)localObject1).eCk() == null) {}
              for (i = 0;; i = ((v)localObject1).eCk().GXO)
              {
                if (((v)localObject1).eCk() != null) {
                  ((v)localObject1).eCk();
                }
                if (com.tencent.mm.platformtools.ac.iPP) {
                  i = 100000000;
                }
                localObject1 = getString(2131765385, new Object[] { Double.valueOf(kp(String.valueOf(i), "100")) });
                this.CEr = ((CharSequence)localObject1);
                this.CEe.setText((CharSequence)localObject1);
                break;
              }
            }
            this.CEc.setVisibility(8);
            this.CEG = getResources().getColor(2131099734);
          }
          AppMethodBeat.o(69015);
          return;
        }
        this.CEe.setText("");
        this.CEc.setVisibility(8);
      }
    }
    AppMethodBeat.o(69015);
  }
  
  private void tY(boolean paramBoolean)
  {
    AppMethodBeat.i(69022);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "check enable: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.CEC) });
    if ((!paramBoolean) || (this.CEC))
    {
      lG(false);
      AppMethodBeat.o(69022);
      return;
    }
    if (this.mode == 1)
    {
      if (this.CEg.getVisibility() == 0)
      {
        if ((this.CEi.isChecked()) && (this.CEz))
        {
          lG(true);
          AppMethodBeat.o(69022);
          return;
        }
        lG(false);
        AppMethodBeat.o(69022);
        return;
      }
      if (this.CEz)
      {
        lG(true);
        AppMethodBeat.o(69022);
      }
    }
    else
    {
      if ((this.CEz) && ((this.CEm.getSelectRedeemType() != null) || (this.CEm.getRedeemTypeList() == null) || (this.CEm.getRedeemTypeList().isEmpty())))
      {
        if (this.CEm.getSelectRedeemType() == null) {}
        for (Integer localInteger = null;; localInteger = Integer.valueOf(this.CEm.getSelectRedeemType().Hfa))
        {
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletLqtSaveFetchUI", "redeem type: %s", new Object[] { localInteger });
          lG(true);
          AppMethodBeat.o(69022);
          return;
        }
      }
      lG(false);
    }
    AppMethodBeat.o(69022);
  }
  
  public final void aOs()
  {
    AppMethodBeat.i(69029);
    if (this.iVd != null) {
      this.iVd.dismiss();
    }
    AppMethodBeat.o(69029);
  }
  
  public final void bv(float paramFloat) {}
  
  public final void eCY()
  {
    AppMethodBeat.i(69012);
    if (this.mode == 1)
    {
      this.CEs = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.eCd();
      if (this.CEs == null)
      {
        com.tencent.mm.plugin.wallet.a.s.eDp();
        this.CEs = com.tencent.mm.plugin.wallet.a.s.eDq().CzB;
      }
      Object localObject;
      int i;
      if (this.CEs != null)
      {
        localObject = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.eCe();
        i = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.eCf();
        if (i != 0) {
          break label189;
        }
        this.CEr = ((CharSequence)localObject);
        if (this.CEe != null) {
          this.CEe.setText(this.CEr);
        }
      }
      if (this.CDY != null) {
        this.CDY.setVisibility(0);
      }
      if (!bt.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxm))
      {
        this.vvA.setText(com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxm);
        this.vvA.setVisibility(0);
      }
      for (;;)
      {
        localObject = v.eCj().eCk();
        if ((localObject != null) && (((cdw)localObject).GNn) && (((cdw)localObject).GXU != null)) {
          af.a(getContext(), ((cdw)localObject).GXU);
        }
        tX(true);
        AppMethodBeat.o(69012);
        return;
        label189:
        if (i == 1)
        {
          i = ((String)localObject).length();
          localObject = new SpannableString((String)localObject + getString(2131765384));
          ((SpannableString)localObject).setSpan(new a(new a.a()
          {
            public final void aRn()
            {
              AppMethodBeat.i(69004);
              WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).setText(com.tencent.mm.wallet_core.ui.e.C(WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this).CUD));
              WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getContentEt().requestFocus();
              WalletLqtSaveFetchUI.this.showWcKb();
              AppMethodBeat.o(69004);
            }
          }), i + 1, ((SpannableString)localObject).length(), 18);
          this.CEr = ((CharSequence)localObject);
          break;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletLqtSaveFetchUI", "unknown func: %s", new Object[] { Integer.valueOf(i) });
        this.CEr = ((CharSequence)localObject);
        break;
        this.vvA.setVisibility(8);
      }
    }
    if (this.CEm.CAq)
    {
      tX(false);
      AppMethodBeat.o(69012);
      return;
    }
    tX(true);
    AppMethodBeat.o(69012);
  }
  
  public final void eDd()
  {
    this.CED = false;
  }
  
  public final void eDe()
  {
    AppMethodBeat.i(69031);
    aq.aA(this.xXi);
    aq.aA(this.CEI);
    AppMethodBeat.o(69031);
  }
  
  public int getLayoutId()
  {
    return 2131495978;
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(69026);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.CED), Boolean.valueOf(this.mWcKeyboard.fQY()) });
    if ((!this.CED) && (this.mWcKeyboard.fQY()))
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
      this.CDX.Cys.iG(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(69027);
      return;
    }
    if (paramIntent != null) {
      paramIntent.putExtra(com.tencent.mm.plugin.wallet.balance.model.lqt.ac.Cya, this.CEx);
    }
    com.tencent.mm.plugin.wallet.balance.model.lqt.ac localac = this.CDW;
    String str;
    Object localObject;
    if ((paramInt1 == com.tencent.mm.plugin.wallet.balance.model.lqt.ac.CxY) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra(com.tencent.mm.plugin.wallet.balance.model.lqt.ac.Cya);
      paramIntent = (Orders)paramIntent.getParcelableExtra("key_orders");
      if ((paramIntent != null) && (paramIntent.CYk != null) && (paramIntent.CYk.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s, reqkey: %s", new Object[] { Integer.valueOf(localac.hashCode()), Integer.valueOf(localac.accountType), paramIntent.dlu });
        localac.dlv = ((Orders.Commodity)paramIntent.CYk.get(0)).dlv;
        paramIntent = (String)localac.Cyk.get(paramIntent.dlu);
        if (!bt.isNullOrNil(paramIntent)) {
          localac.Cye = paramIntent;
        }
        if ((localac.Cyd instanceof WalletLqtSaveFetchUI))
        {
          ((WalletLqtSaveFetchUI)localac.Cyd).CED = true;
          ((WalletLqtSaveFetchUI)localac.Cyd).eDe();
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
        localac.Cyd.showLoading(false);
        paramIntent = localac.Cyd.getIntent().getStringExtra("operate_id");
        localObject = localac.Cyc.CxU;
        com.tencent.mm.vending.g.g.a(localac.Cye, localac.dlv, Integer.valueOf(localac.Cyf), Integer.valueOf(localac.accountType), paramIntent, Integer.valueOf(localac.Cyj)).c((com.tencent.mm.vending.c.a)localObject).f(new ac.7(localac, str)).a(new ac.6(localac));
      }
      AppMethodBeat.o(69027);
      return;
    }
    if ((paramInt1 == com.tencent.mm.plugin.wallet.balance.model.lqt.ac.CxZ) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra(com.tencent.mm.plugin.wallet.balance.model.lqt.ac.Cya);
      localObject = paramIntent.getStringExtra("lqt_fetch_enc_pwd");
      paramIntent = paramIntent.getStringExtra("lqt_redeem_listid");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", new Object[] { Integer.valueOf(localac.hashCode()), Integer.valueOf(localac.accountType), paramIntent });
      if ((localac.Cyd instanceof WalletLqtSaveFetchUI))
      {
        ((WalletLqtSaveFetchUI)localac.Cyd).CED = true;
        ((WalletLqtSaveFetchUI)localac.Cyd).eDe();
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", new Object[] { Integer.valueOf(localac.hashCode()), paramIntent });
      if (bt.isNullOrNil(localac.Cyh))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", new Object[] { Integer.valueOf(localac.hashCode()), paramIntent });
        localac.Cyh = paramIntent;
      }
      paramIntent = localac.Cyd.getIntent().getStringExtra("operate_id");
      localac.Cyd.showLoading(true);
      ab.c localc = localac.Cyc.CxV;
      com.tencent.mm.vending.g.g.b(Integer.valueOf(localac.Cyg), localObject, localac.Cyh, Integer.valueOf(localac.accountType), paramIntent).c(localc).f(new ac.9(localac, str)).a(new ac.8(localac));
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
    this.CDZ = ((WalletFormView)findViewById(2131301701));
    this.CEd = ((ImageView)findViewById(2131297166));
    this.CEe = ((TextView)findViewById(2131301698));
    this.CEf = ((TextView)findViewById(2131301699));
    this.CEa = ((TextView)findViewById(2131301702));
    this.CEb = ((TextView)findViewById(2131301638));
    this.CEl = ((TextView)findViewById(2131306836));
    this.vvA = ((TextView)findViewById(2131301706));
    this.CEq = ((TextView)findViewById(2131301700));
    this.CEg = ((ViewGroup)findViewById(2131301703));
    this.CEh = ((TextView)findViewById(2131301705));
    this.CEi = ((CheckBox)findViewById(2131301704));
    this.CDY = ((ViewGroup)findViewById(2131301985));
    this.CEj = ((TextView)findViewById(2131300742));
    this.CEk = ((TextView)findViewById(2131300743));
    this.CEc = ((TextView)findViewById(2131307277));
    this.CEm = ((WalletLqtArriveTimeLayout)findViewById(2131301696));
    this.CEn = ((ScrollView)findViewById(2131301693));
    this.CEo = ((LinearLayout)findViewById(2131301675));
    this.CEp = ((TextView)findViewById(2131301676));
    this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
    int i = getIntent().getIntExtra("entrance_type", 0);
    this.CDW.mode = this.mode;
    this.CDW.Cyj = i;
    this.CEt = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
    this.CEu = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
    this.CEv = getIntent().getStringExtra("lqt_profile_wording");
    this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.ajD();
      this.CEx = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICT, ""));
      if (bt.isNullOrNil(this.CEx))
      {
        com.tencent.mm.kernel.g.ajD();
        this.CEx = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICS, ""));
      }
      this.CEy = getIntent().getStringExtra("card_serial");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", new Object[] { Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.CEx });
      this.CDZ.getTitleTv().setText(ah.fRG());
      this.mWcKeyboard = ((WcPayKeyboard)findViewById(2131307020));
      paramBundle = (RelativeLayout.LayoutParams)this.mWcKeyboard.getLayoutParams();
      paramBundle.addRule(12);
      this.mWcKeyboard.setLayoutParams(paramBundle);
      if (this.mode != 1) {
        break label1107;
      }
      setWPKeyboard(this.CDZ.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(2131765499));
      label636:
      if (com.tencent.mm.compatible.util.d.lA(27)) {
        this.CDZ.fSi();
      }
      setWcKbHeightListener(this);
      if (this.mode != 1) {
        break label1142;
      }
      this.CEa.setText(getString(2131765491));
      this.CEl.setText(getString(2131765494));
      label692:
      this.CDZ.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(199241);
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
            AppMethodBeat.o(199241);
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
          AppMethodBeat.i(199242);
          if (paramAnonymousBoolean)
          {
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
            {
              WalletLqtSaveFetchUI.r(WalletLqtSaveFetchUI.this);
              AppMethodBeat.o(199242);
              return;
            }
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 1) {
              AppMethodBeat.o(199242);
            }
          }
          else
          {
            WalletLqtSaveFetchUI.s(WalletLqtSaveFetchUI.this).scrollTo(0, 0);
            if ((WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2) && (bt.isNullOrNil(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText()))) {
              WalletLqtSaveFetchUI.t(WalletLqtSaveFetchUI.this);
            }
          }
          AppMethodBeat.o(199242);
        }
      });
      paramBundle = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199251);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if (bt.aO(WalletLqtSaveFetchUI.u(WalletLqtSaveFetchUI.this)) < 800L)
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(199251);
            return;
          }
          WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, bt.HI());
          final int k = WalletLqtSaveFetchUI.ks(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText(), "100");
          if (k > 0)
          {
            WalletLqtSaveFetchUI.this.hideWcKb();
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) != 1) {
              break label260;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
            if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxn))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(199251);
              return;
            }
            paramAnonymousView = WalletLqtSaveFetchUI.w(WalletLqtSaveFetchUI.this).Cyp;
            com.tencent.mm.vending.g.g.h(Integer.valueOf(k), Integer.valueOf(WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this)), WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this)).c(paramAnonymousView).f(new com.tencent.mm.vending.c.a()
            {
              private Void a(coq paramAnonymous2coq)
              {
                AppMethodBeat.i(199245);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", new Object[] { Integer.valueOf(paramAnonymous2coq.Hhv) });
                WalletLqtSaveFetchUI.this.eDe();
                Object localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                ((Intent)localObject).putExtra("key_amount", com.tencent.mm.wallet_core.ui.e.a(k, "100", 2, RoundingMode.HALF_UP));
                ((Intent)localObject).putExtra("key_mode", 1);
                ((Intent)localObject).putExtra("profile_date_wording", paramAnonymous2coq.Hhx);
                ((Intent)localObject).putExtra("profile_upgrade_wording", paramAnonymous2coq.Hhw);
                if (paramAnonymous2coq.Hhy != null) {}
                try
                {
                  ((Intent)localObject).putExtra("key_guide_cell", paramAnonymous2coq.Hhy.toByteArray());
                  ((Intent)localObject).putExtra("entrance_type", WalletLqtSaveFetchUI.this.getIntent().getIntExtra("entrance_type", 0));
                  paramAnonymous2coq = WalletLqtSaveFetchUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2coq, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2coq.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2coq, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  WalletLqtSaveFetchUI.this.finish();
                  paramAnonymous2coq = LhQ;
                  AppMethodBeat.o(199245);
                  return paramAnonymous2coq;
                }
                catch (IOException paramAnonymous2coq)
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramAnonymous2coq, "", new Object[0]);
                  }
                }
              }
            }).a(new com.tencent.mm.vending.g.d.a()
            {
              public final void ce(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(199244);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", new Object[] { paramAnonymous2Object });
                WalletLqtSaveFetchUI.this.aOs();
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
                      AppMethodBeat.i(199243);
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "SAVE MMAlert Interrupt click");
                      AppMethodBeat.o(199243);
                    }
                  });
                  AppMethodBeat.o(199244);
                  return;
                }
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(199251);
            return;
            label260:
            if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI.this) == 2)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
              if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr.Cxo))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(199251);
                return;
              }
              localObject = null;
              paramAnonymousView = (View)localObject;
              if (WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this) != null)
              {
                paramAnonymousView = (View)localObject;
                if (!WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).eER())
                {
                  paramAnonymousView = new in();
                  paramAnonymousView.uJF = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankName;
                  paramAnonymousView.dkR = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankcardType;
                  paramAnonymousView.FBs = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bindSerial;
                  paramAnonymousView.wCE = WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).field_bankcardTail;
                }
              }
              int i = -1;
              if (WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getSelectRedeemType() != null) {
                i = WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this).getSelectRedeemType().Hfa;
              }
              int j = i;
              if (WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this) != null)
              {
                j = i;
                if (!WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this).eER())
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "choose bankcard");
                  int m = com.tencent.mm.wallet_core.ui.e.mH(WalletLqtSaveFetchUI.h(WalletLqtSaveFetchUI.this).getText(), "100");
                  localObject = v.eCj().eCk();
                  if ((((cdw)localObject).GXV >= 0) && (m > ((cdw)localObject).GXV))
                  {
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "choose slow redeem");
                    WalletLqtSaveFetchUI.x(WalletLqtSaveFetchUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(199251);
                    return;
                  }
                  j = i;
                  if (((cdw)localObject).GXV >= 0)
                  {
                    j = i;
                    if (m < ((cdw)localObject).GXV)
                    {
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "choose fast redeem");
                      j = 0;
                    }
                  }
                }
              }
              WalletLqtSaveFetchUI.w(WalletLqtSaveFetchUI.this).Cyq.a(k, WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this), j, paramAnonymousView).f(new com.tencent.mm.vending.c.a()
              {
                private Void a(csl paramAnonymous2csl)
                {
                  AppMethodBeat.i(199249);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", new Object[] { paramAnonymous2csl, Boolean.valueOf(paramAnonymous2csl.HkL), Boolean.valueOf(paramAnonymous2csl.HkM) });
                  WalletLqtSaveFetchUI.this.eDe();
                  Object localObject;
                  if ((paramAnonymous2csl.HkL) && (paramAnonymous2csl.HkM))
                  {
                    localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                    ((Intent)localObject).putExtra("key_amount", com.tencent.mm.wallet_core.ui.e.a(k, "100", 2, RoundingMode.HALF_UP));
                    ((Intent)localObject).putExtra("key_mode", 2);
                    paramAnonymous2csl = WalletLqtSaveFetchUI.this;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2csl, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymous2csl.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2csl, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  for (;;)
                  {
                    WalletLqtSaveFetchUI.this.finish();
                    paramAnonymous2csl = LhQ;
                    AppMethodBeat.o(199249);
                    return paramAnonymous2csl;
                    localObject = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishProgressNewUI.class);
                    try
                    {
                      ((Intent)localObject).putExtra("key_redeem_res", paramAnonymous2csl.toByteArray());
                      paramAnonymous2csl = WalletLqtSaveFetchUI.this;
                      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2csl, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramAnonymous2csl.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                      com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2csl, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$21$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    catch (Exception paramAnonymous2csl)
                    {
                      for (;;)
                      {
                        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramAnonymous2csl, "pass redeemFundRes error: %s", new Object[] { paramAnonymous2csl.getMessage() });
                      }
                    }
                  }
                }
              }).a(new com.tencent.mm.vending.g.d.a()
              {
                public final void ce(Object paramAnonymous2Object)
                {
                  boolean bool = false;
                  AppMethodBeat.i(199248);
                  WalletLqtSaveFetchUI.this.CED = false;
                  WalletLqtSaveFetchUI.this.aOs();
                  if (paramAnonymous2Object != null)
                  {
                    if ((paramAnonymous2Object instanceof csl)) {
                      bool = com.tencent.mm.wallet_core.d.h.a(WalletLqtSaveFetchUI.this, null, 1000, ((csl)paramAnonymous2Object).ozR, ((csl)paramAnonymous2Object).ozS);
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
                        AppMethodBeat.i(199247);
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "fetch MMAlert Interrupt click");
                        AppMethodBeat.o(199247);
                      }
                    });
                    AppMethodBeat.o(199248);
                    return;
                  }
                }
              });
            }
          }
        }
      };
      this.CDZ.getContentEt().setOnEditorActionListener(new WalletLqtSaveFetchUI.15(this, paramBundle));
      if (!bt.isNullOrNil(this.CEv)) {
        this.mWcKeyboard.setTipText(this.CEv);
      }
      if (this.mode == 2) {
        this.CEm.setCallback(new WalletLqtSaveFetchUI.16(this));
      }
      this.CEe.setText("");
      this.CEe.setClickable(true);
      this.CEe.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      tY(false);
      this.CEp.setClickable(true);
      this.CEp.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      if (this.mode != 1) {
        break label1191;
      }
      this.CDY.setVisibility(4);
      if (i != 8) {
        break label1181;
      }
      setMMTitle(2131765498);
      this.mWcKeyboard.showNormalStWcKb();
    }
    for (;;)
    {
      if (this.CEb.findViewById(2131306835) != null) {
        this.CEb.findViewById(2131306835).setVisibility(8);
      }
      paramBundle = new WalletLqtSaveFetchUI.1(this);
      this.CEb.setOnClickListener(paramBundle);
      if (findViewById(2131297947) != null) {
        findViewById(2131297947).setOnClickListener(paramBundle);
      }
      eCY();
      paramBundle = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr;
      s.a locala = this.CEH;
      paramBundle.Cxq.add(locala);
      this.CDY.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(68982);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if ((WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this).isShown()) && (WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this).fQW()))
          {
            WalletLqtSaveFetchUI.d(WalletLqtSaveFetchUI.this).fQU();
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
      if (bt.getDouble(paramBundle, 0.0D) > 0.0D)
      {
        this.CDZ.setText(paramBundle);
        cf(paramBundle, false);
      }
      if ((this.mode == 2) && (v.eCj().eCk() == null)) {
        showLoading(false);
      }
      AppMethodBeat.o(69010);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(20287, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.kernel.g.ajD();
      this.CEx = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICU, ""));
      break;
      label1107:
      this.isVKBFirstTimeShown = false;
      setWPKeyboard(this.CDZ.getContentEt(), false, false);
      this.mWcKeyboard.setActionText(getString(2131765415));
      break label636;
      label1142:
      if (this.mode != 2) {
        break label692;
      }
      this.CEa.setText(getString(2131765397));
      this.CEl.setText(getString(2131765402));
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
    eDe();
    com.tencent.mm.plugin.wallet.balance.model.lqt.s locals = com.tencent.mm.plugin.wallet.balance.model.lqt.s.Cxr;
    s.a locala = this.CEH;
    locals.Cxq.remove(locala);
    this.CDW = null;
    this.CDX = null;
    AppMethodBeat.o(69030);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(69025);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "onDialogDismiss()");
    aq.o(this.xXi, 300L);
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
    paramIntent = eDb();
    this.CDX.Cys.iG(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(69017);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69024);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "onPause()");
    if (!this.mWcKeyboard.fQX()) {
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
      aq.o(this.CEI, 300L);
    }
    this.state = 2;
    AppMethodBeat.o(69023);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(69028);
    com.tencent.mm.plugin.wallet.balance.model.lqt.ac localac = this.CDW;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
    {
      com.tencent.mm.plugin.wallet.a.s.eDp();
      localac.Cyi = com.tencent.mm.plugin.wallet.a.s.eDq().CzB;
      if (localac.iSv != null)
      {
        localac.iSv.G(new Object[] { paramn });
        localac.iSv.resume();
      }
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchUI", "onSceneEnd");
    eCY();
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