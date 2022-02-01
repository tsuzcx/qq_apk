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
import com.tencent.mm.g.a.kb;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.k;
import com.tencent.mm.plugin.wallet.balance.model.lqt.r;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
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
  private static final int zJc;
  private static final int zJd;
  private int mMode;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private String mTitle;
  private int srD;
  private com.tencent.mm.sdk.b.c<kb> ujv;
  private WcPayKeyboard vyZ;
  private List<Bankcard> zJA;
  private bhn zJB;
  private ccm zJC;
  private boolean zJD;
  private car zJE;
  private LinearLayout zJF;
  private long zJG;
  private int zJH;
  private String zJI;
  private String zJJ;
  private String[] zJK;
  private Button zJL;
  private Button zJM;
  private Button zJN;
  private RelativeLayout zJO;
  private List<chw> zJP;
  private boolean zJQ;
  private boolean zJR;
  private boolean zJS;
  private ScrollView zJe;
  private TextView zJf;
  private TextView zJg;
  private TextView zJh;
  private TextView zJi;
  private WalletFormView zJj;
  private TextView zJk;
  private CdnImageView zJl;
  private TextView zJm;
  private LinearLayout zJn;
  private TextView zJo;
  private LinearLayout zJp;
  private Button zJq;
  private CheckBox zJr;
  private TextView zJs;
  private LinearLayout zJt;
  private View zJu;
  private View zJv;
  private View zJw;
  private x zJx;
  private boolean zJy;
  private String zJz;
  
  static
  {
    AppMethodBeat.i(68896);
    zJc = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 48);
    zJd = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 8);
    AppMethodBeat.o(68896);
  }
  
  public WalletLqtPlanAddUI()
  {
    AppMethodBeat.i(68865);
    this.zJx = ((x)am(x.class));
    this.srD = 0;
    this.zJy = false;
    this.zJA = new ArrayList();
    this.zJE = new car();
    this.zJP = new ArrayList();
    this.zJQ = false;
    this.zJR = true;
    this.zJS = true;
    this.ujv = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68865);
  }
  
  private Bankcard atv(String paramString)
  {
    AppMethodBeat.i(68878);
    Iterator localIterator = this.zJA.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if (localBankcard.field_bindSerial.equals(paramString))
      {
        AppMethodBeat.o(68878);
        return localBankcard;
      }
    }
    paramString = s.ecc().atT(paramString);
    AppMethodBeat.o(68878);
    return paramString;
  }
  
  private void cE()
  {
    AppMethodBeat.i(68872);
    dZu();
    dZv();
    dZw();
    dZy();
    dZx();
    this.zJe.post(new Runnable()
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
  
  private void dZu()
  {
    AppMethodBeat.i(68873);
    if (this.mMode == 2)
    {
      BigDecimal localBigDecimal = com.tencent.mm.wallet_core.ui.e.a(this.zJE.dEb, "100", 2, RoundingMode.HALF_UP);
      if (localBigDecimal.intValue() == localBigDecimal.doubleValue())
      {
        this.zJj.setText(localBigDecimal.intValue());
        AppMethodBeat.o(68873);
        return;
      }
      this.zJj.setText(localBigDecimal.toString());
    }
    AppMethodBeat.o(68873);
  }
  
  private void dZv()
  {
    AppMethodBeat.i(68874);
    final Bankcard localBankcard = atv(this.zJE.zEv);
    if (localBankcard != null)
    {
      this.zJi.setVisibility(8);
      if (bt.isNullOrNil(localBankcard.field_bankcardTypeName)) {
        this.zJm.setText(String.format("%s(%s)", new Object[] { this.zJE.szi, this.zJE.uoo }));
      }
      for (;;)
      {
        this.zJl.setTag(this.zJE.zEv);
        if (!localBankcard.ebv()) {
          break;
        }
        this.zJl.setImageResource(2131234612);
        AppMethodBeat.o(68874);
        return;
        this.zJm.setText(String.format("%s %s(%s)", new Object[] { this.zJE.szi, localBankcard.field_bankcardTypeName, this.zJE.uoo }));
      }
      Object localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = b.j(this, localBankcard.field_bankcardType, localBankcard.ebu());
      if (locale != null) {
        localObject = locale.dct;
      }
      localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      if (localObject != null) {
        this.zJl.setImageBitmap((Bitmap)localObject);
      }
      u.a(new u.a()
      {
        public final void l(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68845);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68844);
              if ((WalletLqtPlanAddUI.11.this.zJW != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag() != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag().equals(WalletLqtPlanAddUI.11.this.zJW.field_bindSerial))) {
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
    this.zJi.setVisibility(0);
    AppMethodBeat.o(68874);
  }
  
  private void dZw()
  {
    AppMethodBeat.i(68875);
    int i = this.zJE.foG - 1;
    ad.i("MicroMsg.WalletLqtPlanAddUI", "select day index: %s", new Object[] { Integer.valueOf(i) });
    if ((i >= 0) && (i < this.zJK.length))
    {
      this.zJh.setVisibility(8);
      this.zJo.setText(this.zJK[i]);
      AppMethodBeat.o(68875);
      return;
    }
    this.zJh.setVisibility(0);
    AppMethodBeat.o(68875);
  }
  
  private void dZx()
  {
    AppMethodBeat.i(68876);
    double d = bt.getDouble(this.zJj.getText(), 0.0D);
    ad.i("MicroMsg.WalletLqtPlanAddUI", "money: %s", new Object[] { Double.valueOf(d) });
    Bankcard localBankcard = atv(this.zJE.zEv);
    if ((localBankcard != null) && (d > localBankcard.field_dayQuotaKind))
    {
      ad.i("MicroMsg.WalletLqtPlanAddUI", "show over alert");
      this.zJk.setText(this.zJJ);
      this.zJk.setTextColor(getResources().getColor(2131100800));
      this.zJF.setVisibility(0);
      AppMethodBeat.o(68876);
      return;
    }
    this.zJk.setText(this.zJz);
    this.zJk.setTextColor(getResources().getColor(2131100707));
    this.zJF.setVisibility(0);
    AppMethodBeat.o(68876);
  }
  
  private void dZy()
  {
    AppMethodBeat.i(68877);
    if ((this.zJC != null) && (!bt.isNullOrNil(this.zJC.title)))
    {
      this.zJs.setClickable(true);
      this.zJs.setOnTouchListener(new n(this));
      q localq = new q(new WalletLqtPlanAddUI.13(this));
      String str = getString(2131765472);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
      localSpannableStringBuilder.append(this.zJC.title);
      localSpannableStringBuilder.setSpan(localq, str.length(), localSpannableStringBuilder.length(), 18);
      this.zJs.setText(localSpannableStringBuilder);
      if (this.zJC.DYS) {
        this.zJr.setChecked(true);
      }
      this.zJt.setVisibility(0);
      AppMethodBeat.o(68877);
      return;
    }
    this.zJt.setVisibility(8);
    AppMethodBeat.o(68877);
  }
  
  private void e(final Button paramButton)
  {
    AppMethodBeat.i(68879);
    paramButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68850);
        WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this).setText(paramButton.getText().toString().substring(1));
        AppMethodBeat.o(68850);
      }
    });
    AppMethodBeat.o(68879);
  }
  
  private void sl(boolean paramBoolean)
  {
    Dialog localDialog = null;
    AppMethodBeat.i(68871);
    ad.i("MicroMsg.WalletLqtPlanAddUI", "do pre add plan: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    int i;
    if ((this.mMode == 2) && (this.zJE != null))
    {
      i = this.zJE.zEA;
      localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
    }
    for (;;)
    {
      r localr = new r();
      localr.b(new k(this.mMode, i));
      localr.a(new WalletLqtPlanAddUI.3(this, paramBoolean, localDialog), 0L);
      AppMethodBeat.o(68871);
      return;
      i = 0;
    }
  }
  
  private static String uR(long paramLong)
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
  
  public final void bk(float paramFloat)
  {
    AppMethodBeat.i(68882);
    ad.i("MicroMsg.WalletLqtPlanAddUI", "onUpdateWcPayKeyboardHeight");
    if (this.zJS)
    {
      this.zJS = false;
      int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
      Rect localRect = new Rect();
      this.zJn.getGlobalVisibleRect(localRect);
      ad.i("MicroMsg.WalletLqtPlanAddUI", "screenHeight：%s，mWcKeyboard.getHeight():%s,pageBottomRect.bottom:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mWcKeyboard.getHeight()), Integer.valueOf(localRect.bottom) });
      if (i - this.mWcKeyboard.getHeight() - localRect.bottom <= ao.fromDPToPix(this, 22)) {
        break label145;
      }
    }
    label145:
    for (boolean bool = false;; bool = true)
    {
      this.zJR = bool;
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
    this.zJe = ((ScrollView)findViewById(2131301632));
    this.zJf = ((TextView)findViewById(2131301623));
    this.zJg = ((TextView)findViewById(2131301622));
    this.zJh = ((TextView)findViewById(2131301627));
    this.zJi = ((TextView)findViewById(2131301625));
    this.zJj = ((WalletFormView)findViewById(2131301617));
    this.zJk = ((TextView)findViewById(2131301616));
    this.zJl = ((CdnImageView)findViewById(2131301610));
    this.zJm = ((TextView)findViewById(2131301612));
    this.zJn = ((LinearLayout)findViewById(2131301611));
    this.zJo = ((TextView)findViewById(2131301628));
    this.zJp = ((LinearLayout)findViewById(2131301626));
    this.zJq = ((Button)findViewById(2131301614));
    this.zJr = ((CheckBox)findViewById(2131301629));
    this.zJs = ((TextView)findViewById(2131301631));
    this.zJt = ((LinearLayout)findViewById(2131301630));
    this.zJF = ((LinearLayout)findViewById(2131301615));
    this.vyZ = ((WcPayKeyboard)findViewById(2131307020));
    this.zJu = findViewById(2131301633);
    this.zJv = findViewById(2131301634);
    this.zJw = findViewById(2131301613);
    this.zJO = ((RelativeLayout)findViewById(2131303856));
    this.zJL = ((Button)findViewById(2131303857));
    this.zJM = ((Button)findViewById(2131303858));
    this.zJN = ((Button)findViewById(2131303859));
    this.zJj.setContentPadding$3b4dfe4b(0);
    this.zJj.setTitleText(ah.fkg());
    setWPKeyboard(this.zJj.getContentEt(), false, false);
    if (d.lf(28)) {
      this.zJj.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68833);
          WalletFormView localWalletFormView = WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this);
          if (localWalletFormView.IfT != null)
          {
            localWalletFormView.IfT.setFocusable(true);
            localWalletFormView.IfT.requestFocus();
          }
          AppMethodBeat.o(68833);
        }
      });
    }
    this.vyZ.setActionText(getString(2131755903));
    this.vyZ.xm(false);
    ((RelativeLayout.LayoutParams)this.vyZ.getLayoutParams()).addRule(12);
    this.zJj.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(68846);
        if ((paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
        {
          ad.i("MicroMsg.WalletLqtPlanAddUI", "click enter");
          WalletLqtPlanAddUI.this.hideWcKb();
          AppMethodBeat.o(68846);
          return true;
        }
        AppMethodBeat.o(68846);
        return true;
      }
    });
    this.zJq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68857);
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).isShown()) {
          WalletLqtPlanAddUI.this.hideWcKb();
        }
        ad.i("MicroMsg.WalletLqtPlanAddUI", "click btn");
        WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
        if (!WalletLqtPlanAddUI.d(WalletLqtPlanAddUI.this).isEnabled())
        {
          AppMethodBeat.o(68857);
          return;
        }
        if (WalletLqtPlanAddUI.e(WalletLqtPlanAddUI.this) == 1)
        {
          WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, 0);
          AppMethodBeat.o(68857);
          return;
        }
        WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, 4);
        AppMethodBeat.o(68857);
      }
    });
    this.zJr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68858);
        WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
        AppMethodBeat.o(68858);
      }
    });
    this.zJn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68859);
        WalletLqtPlanAddUI.f(WalletLqtPlanAddUI.this);
        AppMethodBeat.o(68859);
      }
    });
    this.zJp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68860);
        WalletLqtPlanAddUI.g(WalletLqtPlanAddUI.this);
        AppMethodBeat.o(68860);
      }
    });
    this.zJj.a(new TextWatcher()
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
          WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).xm(false);
          AppMethodBeat.o(68861);
          return;
        }
        WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).xm(true);
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
        ad.i("MicroMsg.WalletLqtPlanAddUI", "onVisibleStateChange() visitable:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).fjA())
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
    this.zJe.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68864);
        if ((WalletLqtPlanAddUI.j(WalletLqtPlanAddUI.this).isShown()) && (WalletLqtPlanAddUI.k(WalletLqtPlanAddUI.this).fjx()))
        {
          WalletLqtPlanAddUI.this.hideWcKb();
          AppMethodBeat.o(68864);
          return true;
        }
        AppMethodBeat.o(68864);
        return false;
      }
    });
    setResult(0);
    this.zJO.setVisibility(8);
    e(this.zJL);
    e(this.zJM);
    e(this.zJN);
    setWcKbHeightListener(this);
    AppMethodBeat.o(68867);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68870);
    ad.i("MicroMsg.WalletLqtPlanAddUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        i = com.tencent.mm.wallet_core.ui.e.lM(this.zJj.getText(), "100");
        str2 = this.zJE.dca;
        str3 = this.zJE.uoo;
        str4 = this.zJE.zEv;
        j = this.zJE.foG;
        k = this.zJE.zEA;
        localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
        localObject = this.zJx.zFm;
        com.tencent.mm.vending.g.g.a(str1, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new WalletLqtPlanAddUI.4(this, localDialog));
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
        i = com.tencent.mm.wallet_core.ui.e.lM(this.zJj.getText(), "100");
        j = this.zJE.zEA;
        str2 = this.zJE.dca;
        str3 = this.zJE.uoo;
        str4 = this.zJE.zEv;
        k = this.zJE.foG;
        localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
        localObject = this.zJx.zFn;
        com.tencent.mm.vending.g.g.a(Integer.valueOf(j), str2, str3, str4, Integer.valueOf(i), Integer.valueOf(k), str1).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new WalletLqtPlanAddUI.6(this, localDialog));
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
      paramBundle = new car();
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_plan_item");
      if (arrayOfByte != null)
      {
        this.zJE = ((car)paramBundle.parseFrom(arrayOfByte));
        this.zJG = this.zJE.dEb;
        this.zJH = this.zJE.foG;
        this.zJI = this.zJE.zEv;
      }
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        int i;
        ad.printErrStackTrace("MicroMsg.WalletLqtPlanAddUI", paramBundle, "", new Object[0]);
      }
      initView();
      cE();
      sl(true);
      AppMethodBeat.o(68866);
    }
    this.zJK = new String[28];
    i = 0;
    while (i < 28)
    {
      this.zJK[i] = getString(2131765429, new Object[] { String.valueOf(i + 1) });
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
    if ((this.vyZ.isShown()) && (bt.isNullOrNil(this.zJj.getText())))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI
 * JD-Core Version:    0.7.0.1
 */