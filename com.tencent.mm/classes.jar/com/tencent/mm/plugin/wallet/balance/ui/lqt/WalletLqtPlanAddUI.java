package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.k;
import com.tencent.mm.plugin.wallet.balance.model.lqt.r;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.csw;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.c.a.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.h;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtPlanAddUI
  extends WalletLqtBasePresenterUI
  implements WcPayKeyboard.a
{
  private static final int CTi;
  private static final int CTj;
  private View CTA;
  private View CTB;
  private View CTC;
  private x CTD;
  private boolean CTE;
  private String CTF;
  private List<Bankcard> CTG;
  private bqi CTH;
  private cnj CTI;
  private boolean CTJ;
  private clj CTK;
  private LinearLayout CTL;
  private long CTM;
  private int CTN;
  private String CTO;
  private String CTP;
  private String[] CTQ;
  private Button CTR;
  private Button CTS;
  private Button CTT;
  private RelativeLayout CTU;
  private List<csw> CTV;
  private boolean CTW;
  private boolean CTX;
  private boolean CTY;
  private ScrollView CTk;
  private TextView CTl;
  private TextView CTm;
  private TextView CTn;
  private TextView CTo;
  private WalletFormView CTp;
  private TextView CTq;
  private CdnImageView CTr;
  private TextView CTs;
  private LinearLayout CTt;
  private TextView CTu;
  private LinearLayout CTv;
  private Button CTw;
  private CheckBox CTx;
  private TextView CTy;
  private LinearLayout CTz;
  private int mMode;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private String mTitle;
  private int uNI;
  private com.tencent.mm.sdk.b.c<kt> wNu;
  private WcPayKeyboard ymE;
  
  static
  {
    AppMethodBeat.i(68896);
    CTi = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 48);
    CTj = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8);
    AppMethodBeat.o(68896);
  }
  
  public WalletLqtPlanAddUI()
  {
    AppMethodBeat.i(68865);
    this.CTD = ((x)am(x.class));
    this.uNI = 0;
    this.CTE = false;
    this.CTG = new ArrayList();
    this.CTK = new clj();
    this.CTV = new ArrayList();
    this.CTW = false;
    this.CTX = true;
    this.CTY = true;
    this.wNu = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68865);
  }
  
  private static String CE(long paramLong)
  {
    AppMethodBeat.i(68880);
    String str = String.valueOf(paramLong);
    if (str.length() == 1)
    {
      str = "0.0".concat(String.valueOf(paramLong));
      AppMethodBeat.o(68880);
      return str;
    }
    if (str.length() == 2)
    {
      str = "0.".concat(String.valueOf(paramLong));
      AppMethodBeat.o(68880);
      return str;
    }
    str = str.substring(0, str.length() - 2);
    AppMethodBeat.o(68880);
    return str;
  }
  
  private Bankcard aFo(String paramString)
  {
    AppMethodBeat.i(68878);
    Iterator localIterator = this.CTG.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if (localBankcard.field_bindSerial.equals(paramString))
      {
        AppMethodBeat.o(68878);
        return localBankcard;
      }
    }
    paramString = t.eJf().aFN(paramString);
    AppMethodBeat.o(68878);
    return paramString;
  }
  
  private void e(final Button paramButton)
  {
    AppMethodBeat.i(68879);
    paramButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68850);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this).setText(paramButton.getText().toString().substring(1));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68850);
      }
    });
    AppMethodBeat.o(68879);
  }
  
  private void eGA()
  {
    AppMethodBeat.i(68876);
    double d = bu.getDouble(this.CTp.getText(), 0.0D);
    ae.i("MicroMsg.WalletLqtPlanAddUI", "money: %s", new Object[] { Double.valueOf(d) });
    Bankcard localBankcard = aFo(this.CTK.COw);
    if ((localBankcard != null) && (d > localBankcard.field_dayQuotaKind))
    {
      ae.i("MicroMsg.WalletLqtPlanAddUI", "show over alert");
      this.CTq.setText(this.CTP);
      this.CTq.setTextColor(getResources().getColor(2131100800));
      this.CTL.setVisibility(0);
      AppMethodBeat.o(68876);
      return;
    }
    this.CTq.setText(this.CTF);
    this.CTq.setTextColor(getResources().getColor(2131100707));
    this.CTL.setVisibility(0);
    AppMethodBeat.o(68876);
  }
  
  private void eGB()
  {
    AppMethodBeat.i(68877);
    if ((this.CTI != null) && (!bu.isNullOrNil(this.CTI.title)))
    {
      this.CTy.setClickable(true);
      this.CTy.setOnTouchListener(new n(this));
      q localq = new q(new q.a()
      {
        public final void dN(View paramAnonymousView)
        {
          AppMethodBeat.i(68847);
          f.p(WalletLqtPlanAddUI.this.getContext(), WalletLqtPlanAddUI.u(WalletLqtPlanAddUI.this).url, true);
          AppMethodBeat.o(68847);
        }
      });
      String str = getString(2131765472);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
      localSpannableStringBuilder.append(this.CTI.title);
      localSpannableStringBuilder.setSpan(localq, str.length(), localSpannableStringBuilder.length(), 18);
      this.CTy.setText(localSpannableStringBuilder);
      if (this.CTI.Hzu) {
        this.CTx.setChecked(true);
      }
      this.CTz.setVisibility(0);
      AppMethodBeat.o(68877);
      return;
    }
    this.CTz.setVisibility(8);
    AppMethodBeat.o(68877);
  }
  
  private void eGx()
  {
    AppMethodBeat.i(68873);
    if (this.mMode == 2)
    {
      BigDecimal localBigDecimal = f.b(this.CTK.dPq, "100", 2, RoundingMode.HALF_UP);
      if (localBigDecimal.intValue() == localBigDecimal.doubleValue())
      {
        this.CTp.setText(localBigDecimal.intValue());
        AppMethodBeat.o(68873);
        return;
      }
      this.CTp.setText(localBigDecimal.toString());
    }
    AppMethodBeat.o(68873);
  }
  
  private void eGy()
  {
    AppMethodBeat.i(68874);
    final Bankcard localBankcard = aFo(this.CTK.COw);
    if (localBankcard != null)
    {
      this.CTo.setVisibility(8);
      if (bu.isNullOrNil(localBankcard.field_bankcardTypeName)) {
        this.CTs.setText(String.format("%s(%s)", new Object[] { this.CTK.uVs, this.CTK.wSp }));
      }
      for (;;)
      {
        this.CTr.setTag(this.CTK.COw);
        if (!localBankcard.eIy()) {
          break;
        }
        this.CTr.setImageResource(2131234612);
        AppMethodBeat.o(68874);
        return;
        this.CTs.setText(String.format("%s %s(%s)", new Object[] { this.CTK.uVs, localBankcard.field_bankcardTypeName, this.CTK.wSp }));
      }
      Object localObject = "";
      e locale = com.tencent.mm.plugin.wallet_core.d.b.i(this, localBankcard.field_bankcardType, localBankcard.eIx());
      if (locale != null) {
        localObject = locale.wFJ;
      }
      localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      if (localObject != null) {
        this.CTr.setImageBitmap((Bitmap)localObject);
      }
      u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68845);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68844);
              if ((WalletLqtPlanAddUI.11.this.CUc != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag() != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag().equals(WalletLqtPlanAddUI.11.this.CUc.field_bindSerial))) {
                WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(68844);
            }
          });
          AppMethodBeat.o(68845);
        }
      });
      AppMethodBeat.o(68874);
      return;
    }
    this.CTo.setVisibility(0);
    AppMethodBeat.o(68874);
  }
  
  private void eGz()
  {
    AppMethodBeat.i(68875);
    int i = this.CTK.fMJ - 1;
    ae.i("MicroMsg.WalletLqtPlanAddUI", "select day index: %s", new Object[] { Integer.valueOf(i) });
    if ((i >= 0) && (i < this.CTQ.length))
    {
      this.CTn.setVisibility(8);
      this.CTu.setText(this.CTQ[i]);
      AppMethodBeat.o(68875);
      return;
    }
    this.CTn.setVisibility(0);
    AppMethodBeat.o(68875);
  }
  
  private void ud(final boolean paramBoolean)
  {
    final Dialog localDialog = null;
    AppMethodBeat.i(68871);
    ae.i("MicroMsg.WalletLqtPlanAddUI", "do pre add plan: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    int i;
    if ((this.mMode == 2) && (this.CTK != null))
    {
      i = this.CTK.COB;
      localDialog = h.c(getContext(), false, null);
    }
    for (;;)
    {
      r localr = new r();
      localr.b(new k(this.mMode, i));
      localr.a(new a.a() {}, 0L);
      AppMethodBeat.o(68871);
      return;
      i = 0;
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(68872);
    eGx();
    eGy();
    eGz();
    eGB();
    eGA();
    this.CTk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68843);
        if (WalletLqtPlanAddUI.r(WalletLqtPlanAddUI.this) != null) {
          WalletLqtPlanAddUI.r(WalletLqtPlanAddUI.this).setVisibility(0);
        }
        p.a(WalletLqtPlanAddUI.this, WalletLqtPlanAddUI.l(WalletLqtPlanAddUI.this), WalletLqtPlanAddUI.this.findViewById(2131303141), WalletLqtPlanAddUI.s(WalletLqtPlanAddUI.this), WalletLqtPlanAddUI.r(WalletLqtPlanAddUI.this), 24);
        AppMethodBeat.o(68843);
      }
    });
    AppMethodBeat.o(68872);
  }
  
  public final void bv(float paramFloat)
  {
    AppMethodBeat.i(68882);
    ae.i("MicroMsg.WalletLqtPlanAddUI", "onUpdateWcPayKeyboardHeight");
    if (this.CTY)
    {
      this.CTY = false;
      int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
      Rect localRect = new Rect();
      this.CTt.getGlobalVisibleRect(localRect);
      ae.i("MicroMsg.WalletLqtPlanAddUI", "screenHeight：%s，mWcKeyboard.getHeight():%s,pageBottomRect.bottom:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mWcKeyboard.getHeight()), Integer.valueOf(localRect.bottom) });
      if (i - this.mWcKeyboard.getHeight() - localRect.bottom <= aq.fromDPToPix(this, 22)) {
        break label145;
      }
    }
    label145:
    for (boolean bool = false;; bool = true)
    {
      this.CTX = bool;
      AppMethodBeat.o(68882);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494622;
  }
  
  public void hideWcKb()
  {
    AppMethodBeat.i(68881);
    if (this.mWcKeyboard != null)
    {
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(false);
      }
      this.mWcKeyboard.hideWcKb();
    }
    AppMethodBeat.o(68881);
  }
  
  public void initView()
  {
    AppMethodBeat.i(68867);
    this.CTk = ((ScrollView)findViewById(2131301632));
    this.CTl = ((TextView)findViewById(2131301623));
    this.CTm = ((TextView)findViewById(2131301622));
    this.CTn = ((TextView)findViewById(2131301627));
    this.CTo = ((TextView)findViewById(2131301625));
    this.CTp = ((WalletFormView)findViewById(2131301617));
    this.CTq = ((TextView)findViewById(2131301616));
    this.CTr = ((CdnImageView)findViewById(2131301610));
    this.CTs = ((TextView)findViewById(2131301612));
    this.CTt = ((LinearLayout)findViewById(2131301611));
    this.CTu = ((TextView)findViewById(2131301628));
    this.CTv = ((LinearLayout)findViewById(2131301626));
    this.CTw = ((Button)findViewById(2131301614));
    this.CTx = ((CheckBox)findViewById(2131301629));
    this.CTy = ((TextView)findViewById(2131301631));
    this.CTz = ((LinearLayout)findViewById(2131301630));
    this.CTL = ((LinearLayout)findViewById(2131301615));
    this.ymE = ((WcPayKeyboard)findViewById(2131307020));
    this.CTA = findViewById(2131301633);
    this.CTB = findViewById(2131301634);
    this.CTC = findViewById(2131301613);
    this.CTU = ((RelativeLayout)findViewById(2131303856));
    this.CTR = ((Button)findViewById(2131303857));
    this.CTS = ((Button)findViewById(2131303858));
    this.CTT = ((Button)findViewById(2131303859));
    this.CTp.setContentPadding$3b4dfe4b(0);
    this.CTp.setTitleText(ah.fWc());
    setWPKeyboard(this.CTp.getContentEt(), false, false);
    if (d.lA(28)) {
      this.CTp.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68833);
          WalletFormView localWalletFormView = WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this);
          if (localWalletFormView.LXo != null)
          {
            localWalletFormView.LXo.setFocusable(true);
            localWalletFormView.LXo.requestFocus();
          }
          AppMethodBeat.o(68833);
        }
      });
    }
    this.ymE.setActionText(getString(2131755903));
    this.ymE.zx(false);
    ((RelativeLayout.LayoutParams)this.ymE.getLayoutParams()).addRule(12);
    this.CTp.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(68846);
        if ((paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
        {
          ae.i("MicroMsg.WalletLqtPlanAddUI", "click enter");
          WalletLqtPlanAddUI.this.hideWcKb();
          AppMethodBeat.o(68846);
          return true;
        }
        AppMethodBeat.o(68846);
        return true;
      }
    });
    this.CTw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68857);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).isShown()) {
          WalletLqtPlanAddUI.this.hideWcKb();
        }
        ae.i("MicroMsg.WalletLqtPlanAddUI", "click btn");
        WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
        if (!WalletLqtPlanAddUI.d(WalletLqtPlanAddUI.this).isEnabled())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68857);
          return;
        }
        if (WalletLqtPlanAddUI.e(WalletLqtPlanAddUI.this) == 1) {
          WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, 0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68857);
          return;
          WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, 4);
        }
      }
    });
    this.CTx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68858);
        WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
        AppMethodBeat.o(68858);
      }
    });
    this.CTt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68859);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletLqtPlanAddUI.f(WalletLqtPlanAddUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68859);
      }
    });
    this.CTv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68860);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletLqtPlanAddUI.g(WalletLqtPlanAddUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68860);
      }
    });
    this.CTp.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(68861);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 2)) {
          paramAnonymousEditable.delete(i + 3, j);
        }
        WalletLqtPlanAddUI.h(WalletLqtPlanAddUI.this);
        WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
        if (j == 0)
        {
          WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).zx(false);
          AppMethodBeat.o(68861);
          return;
        }
        WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).zx(true);
        AppMethodBeat.o(68861);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.mTenpayKBStateListener = new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68863);
        ae.i("MicroMsg.WalletLqtPlanAddUI", "onVisibleStateChange() visitable:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).fVv())
        {
          AppMethodBeat.o(68863);
          return;
        }
        WalletLqtPlanAddUI.i(WalletLqtPlanAddUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68862);
            WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, paramAnonymousBoolean);
            AppMethodBeat.o(68862);
          }
        });
        AppMethodBeat.o(68863);
      }
    };
    setTenpayKBStateListener(this.mTenpayKBStateListener);
    this.CTk.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68864);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if ((WalletLqtPlanAddUI.j(WalletLqtPlanAddUI.this).isShown()) && (WalletLqtPlanAddUI.k(WalletLqtPlanAddUI.this).fVs()))
        {
          WalletLqtPlanAddUI.this.hideWcKb();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(68864);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(68864);
        return false;
      }
    });
    setResult(0);
    this.CTU.setVisibility(8);
    e(this.CTR);
    e(this.CTS);
    e(this.CTT);
    setWcKbHeightListener(this);
    AppMethodBeat.o(68867);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68870);
    ae.i("MicroMsg.WalletLqtPlanAddUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1;
    int i;
    String str2;
    String str3;
    String str4;
    int j;
    int k;
    final Dialog localDialog;
    Object localObject;
    if (paramInt1 == 0) {
      if (paramInt2 == -1)
      {
        str1 = paramIntent.getStringExtra("encrypt_pwd");
        i = f.mN(this.CTp.getText(), "100");
        str2 = this.CTK.dlT;
        str3 = this.CTK.wSp;
        str4 = this.CTK.COw;
        j = this.CTK.fMJ;
        k = this.CTK.COB;
        localDialog = h.c(getContext(), false, null);
        localObject = this.CTD.CPn;
        g.a(str1, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
        {
          public final void ce(Object paramAnonymousObject)
          {
            AppMethodBeat.i(68837);
            localDialog.dismiss();
            if ((paramAnonymousObject instanceof m)) {
              ((m)paramAnonymousObject).D(WalletLqtPlanAddUI.this.getContext(), false);
            }
            AppMethodBeat.o(68837);
          }
        });
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(68870);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -1))
      {
        str1 = paramIntent.getStringExtra("encrypt_pwd");
        i = f.mN(this.CTp.getText(), "100");
        j = this.CTK.COB;
        str2 = this.CTK.dlT;
        str3 = this.CTK.wSp;
        str4 = this.CTK.COw;
        k = this.CTK.fMJ;
        localDialog = h.c(getContext(), false, null);
        localObject = this.CTD.CPo;
        g.a(Integer.valueOf(j), str2, str3, str4, Integer.valueOf(i), Integer.valueOf(k), str1).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
        {
          public final void ce(Object paramAnonymousObject)
          {
            AppMethodBeat.i(68839);
            localDialog.dismiss();
            if ((paramAnonymousObject instanceof m)) {
              ((m)paramAnonymousObject).D(WalletLqtPlanAddUI.this.getContext(), false);
            }
            AppMethodBeat.o(68839);
          }
        });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68866);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    this.mMode = getIntent().getIntExtra("key_mode", 0);
    if (this.mMode == 2) {}
    try
    {
      paramBundle = new clj();
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_plan_item");
      if (arrayOfByte != null)
      {
        this.CTK = ((clj)paramBundle.parseFrom(arrayOfByte));
        this.CTM = this.CTK.dPq;
        this.CTN = this.CTK.fMJ;
        this.CTO = this.CTK.COw;
      }
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        int i;
        ae.printErrStackTrace("MicroMsg.WalletLqtPlanAddUI", paramBundle, "", new Object[0]);
      }
      initView();
      updateView();
      ud(true);
      AppMethodBeat.o(68866);
    }
    this.CTQ = new String[28];
    i = 0;
    while (i < 28)
    {
      this.CTQ[i] = getString(2131765429, new Object[] { String.valueOf(i + 1) });
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68868);
    super.onDestroy();
    AppMethodBeat.o(68868);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68869);
    if ((this.ymE.isShown()) && (bu.isNullOrNil(this.CTp.getText())))
    {
      hideWcKb();
      AppMethodBeat.o(68869);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68869);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI
 * JD-Core Version:    0.7.0.1
 */