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
import com.tencent.mm.g.a.kj;
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
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static final int Bbo;
  private static final int Bbp;
  private TextView BbA;
  private LinearLayout BbB;
  private Button BbC;
  private CheckBox BbD;
  private TextView BbE;
  private LinearLayout BbF;
  private View BbG;
  private View BbH;
  private View BbI;
  private x BbJ;
  private boolean BbK;
  private String BbL;
  private List<Bankcard> BbM;
  private blf BbN;
  private chp BbO;
  private boolean BbP;
  private cfq BbQ;
  private LinearLayout BbR;
  private long BbS;
  private int BbT;
  private String BbU;
  private String BbV;
  private String[] BbW;
  private Button BbX;
  private Button BbY;
  private Button BbZ;
  private ScrollView Bbq;
  private TextView Bbr;
  private TextView Bbs;
  private TextView Bbt;
  private TextView Bbu;
  private WalletFormView Bbv;
  private TextView Bbw;
  private CdnImageView Bbx;
  private TextView Bby;
  private LinearLayout Bbz;
  private RelativeLayout Bca;
  private List<cmz> Bcb;
  private boolean Bcc;
  private boolean Bcd;
  private boolean Bce;
  private int mMode;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private String mTitle;
  private int tzu;
  private com.tencent.mm.sdk.b.c<kj> vsr;
  private WcPayKeyboard wJe;
  
  static
  {
    AppMethodBeat.i(68896);
    Bbo = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 48);
    Bbp = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 8);
    AppMethodBeat.o(68896);
  }
  
  public WalletLqtPlanAddUI()
  {
    AppMethodBeat.i(68865);
    this.BbJ = ((x)am(x.class));
    this.tzu = 0;
    this.BbK = false;
    this.BbM = new ArrayList();
    this.BbQ = new cfq();
    this.Bcb = new ArrayList();
    this.Bcc = false;
    this.Bcd = true;
    this.Bce = true;
    this.vsr = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68865);
  }
  
  private Bankcard ayN(String paramString)
  {
    AppMethodBeat.i(68878);
    Iterator localIterator = this.BbM.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if (localBankcard.field_bindSerial.equals(paramString))
      {
        AppMethodBeat.o(68878);
        return localBankcard;
      }
    }
    paramString = s.ery().azl(paramString);
    AppMethodBeat.o(68878);
    return paramString;
  }
  
  private void cL()
  {
    AppMethodBeat.i(68872);
    eoQ();
    eoR();
    eoS();
    eoU();
    eoT();
    this.Bbq.post(new Runnable()
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
  
  private void eoQ()
  {
    AppMethodBeat.i(68873);
    if (this.mMode == 2)
    {
      BigDecimal localBigDecimal = com.tencent.mm.wallet_core.ui.e.a(this.BbQ.dBN, "100", 2, RoundingMode.HALF_UP);
      if (localBigDecimal.intValue() == localBigDecimal.doubleValue())
      {
        this.Bbv.setText(localBigDecimal.intValue());
        AppMethodBeat.o(68873);
        return;
      }
      this.Bbv.setText(localBigDecimal.toString());
    }
    AppMethodBeat.o(68873);
  }
  
  private void eoR()
  {
    AppMethodBeat.i(68874);
    final Bankcard localBankcard = ayN(this.BbQ.AWI);
    if (localBankcard != null)
    {
      this.Bbu.setVisibility(8);
      if (bs.isNullOrNil(localBankcard.field_bankcardTypeName)) {
        this.Bby.setText(String.format("%s(%s)", new Object[] { this.BbQ.tGS, this.BbQ.vxk }));
      }
      for (;;)
      {
        this.Bbx.setTag(this.BbQ.AWI);
        if (!localBankcard.eqR()) {
          break;
        }
        this.Bbx.setImageResource(2131234612);
        AppMethodBeat.o(68874);
        return;
        this.Bby.setText(String.format("%s %s(%s)", new Object[] { this.BbQ.tGS, localBankcard.field_bankcardTypeName, this.BbQ.vxk }));
      }
      Object localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = b.i(this, localBankcard.field_bankcardType, localBankcard.eqQ());
      if (locale != null) {
        localObject = locale.vkI;
      }
      localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      if (localObject != null) {
        this.Bbx.setImageBitmap((Bitmap)localObject);
      }
      u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68845);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68844);
              if ((WalletLqtPlanAddUI.11.this.Bci != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag() != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag().equals(WalletLqtPlanAddUI.11.this.Bci.field_bindSerial))) {
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
    this.Bbu.setVisibility(0);
    AppMethodBeat.o(68874);
  }
  
  private void eoS()
  {
    AppMethodBeat.i(68875);
    int i = this.BbQ.fsg - 1;
    ac.i("MicroMsg.WalletLqtPlanAddUI", "select day index: %s", new Object[] { Integer.valueOf(i) });
    if ((i >= 0) && (i < this.BbW.length))
    {
      this.Bbt.setVisibility(8);
      this.BbA.setText(this.BbW[i]);
      AppMethodBeat.o(68875);
      return;
    }
    this.Bbt.setVisibility(0);
    AppMethodBeat.o(68875);
  }
  
  private void eoT()
  {
    AppMethodBeat.i(68876);
    double d = bs.getDouble(this.Bbv.getText(), 0.0D);
    ac.i("MicroMsg.WalletLqtPlanAddUI", "money: %s", new Object[] { Double.valueOf(d) });
    Bankcard localBankcard = ayN(this.BbQ.AWI);
    if ((localBankcard != null) && (d > localBankcard.field_dayQuotaKind))
    {
      ac.i("MicroMsg.WalletLqtPlanAddUI", "show over alert");
      this.Bbw.setText(this.BbV);
      this.Bbw.setTextColor(getResources().getColor(2131100800));
      this.BbR.setVisibility(0);
      AppMethodBeat.o(68876);
      return;
    }
    this.Bbw.setText(this.BbL);
    this.Bbw.setTextColor(getResources().getColor(2131100707));
    this.BbR.setVisibility(0);
    AppMethodBeat.o(68876);
  }
  
  private void eoU()
  {
    AppMethodBeat.i(68877);
    if ((this.BbO != null) && (!bs.isNullOrNil(this.BbO.title)))
    {
      this.BbE.setClickable(true);
      this.BbE.setOnTouchListener(new n(this));
      q localq = new q(new WalletLqtPlanAddUI.13(this));
      String str = getString(2131765472);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
      localSpannableStringBuilder.append(this.BbO.title);
      localSpannableStringBuilder.setSpan(localq, str.length(), localSpannableStringBuilder.length(), 18);
      this.BbE.setText(localSpannableStringBuilder);
      if (this.BbO.FvO) {
        this.BbD.setChecked(true);
      }
      this.BbF.setVisibility(0);
      AppMethodBeat.o(68877);
      return;
    }
    this.BbF.setVisibility(8);
    AppMethodBeat.o(68877);
  }
  
  private void tm(boolean paramBoolean)
  {
    Dialog localDialog = null;
    AppMethodBeat.i(68871);
    ac.i("MicroMsg.WalletLqtPlanAddUI", "do pre add plan: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    int i;
    if ((this.mMode == 2) && (this.BbQ != null))
    {
      i = this.BbQ.AWN;
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
  
  private static String zu(long paramLong)
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
  
  public final void bs(float paramFloat)
  {
    AppMethodBeat.i(68882);
    ac.i("MicroMsg.WalletLqtPlanAddUI", "onUpdateWcPayKeyboardHeight");
    if (this.Bce)
    {
      this.Bce = false;
      int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
      Rect localRect = new Rect();
      this.Bbz.getGlobalVisibleRect(localRect);
      ac.i("MicroMsg.WalletLqtPlanAddUI", "screenHeight：%s，mWcKeyboard.getHeight():%s,pageBottomRect.bottom:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mWcKeyboard.getHeight()), Integer.valueOf(localRect.bottom) });
      if (i - this.mWcKeyboard.getHeight() - localRect.bottom <= ao.fromDPToPix(this, 22)) {
        break label145;
      }
    }
    label145:
    for (boolean bool = false;; bool = true)
    {
      this.Bcd = bool;
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
    this.Bbq = ((ScrollView)findViewById(2131301632));
    this.Bbr = ((TextView)findViewById(2131301623));
    this.Bbs = ((TextView)findViewById(2131301622));
    this.Bbt = ((TextView)findViewById(2131301627));
    this.Bbu = ((TextView)findViewById(2131301625));
    this.Bbv = ((WalletFormView)findViewById(2131301617));
    this.Bbw = ((TextView)findViewById(2131301616));
    this.Bbx = ((CdnImageView)findViewById(2131301610));
    this.Bby = ((TextView)findViewById(2131301612));
    this.Bbz = ((LinearLayout)findViewById(2131301611));
    this.BbA = ((TextView)findViewById(2131301628));
    this.BbB = ((LinearLayout)findViewById(2131301626));
    this.BbC = ((Button)findViewById(2131301614));
    this.BbD = ((CheckBox)findViewById(2131301629));
    this.BbE = ((TextView)findViewById(2131301631));
    this.BbF = ((LinearLayout)findViewById(2131301630));
    this.BbR = ((LinearLayout)findViewById(2131301615));
    this.wJe = ((WcPayKeyboard)findViewById(2131307020));
    this.BbG = findViewById(2131301633);
    this.BbH = findViewById(2131301634);
    this.BbI = findViewById(2131301613);
    this.Bca = ((RelativeLayout)findViewById(2131303856));
    this.BbX = ((Button)findViewById(2131303857));
    this.BbY = ((Button)findViewById(2131303858));
    this.BbZ = ((Button)findViewById(2131303859));
    this.Bbv.setContentPadding$3b4dfe4b(0);
    this.Bbv.setTitleText(ah.fAw());
    setWPKeyboard(this.Bbv.getContentEt(), false, false);
    if (d.kZ(28)) {
      this.Bbv.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68833);
          WalletFormView localWalletFormView = WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this);
          if (localWalletFormView.JHv != null)
          {
            localWalletFormView.JHv.setFocusable(true);
            localWalletFormView.JHv.requestFocus();
          }
          AppMethodBeat.o(68833);
        }
      });
    }
    this.wJe.setActionText(getString(2131755903));
    this.wJe.yw(false);
    ((RelativeLayout.LayoutParams)this.wJe.getLayoutParams()).addRule(12);
    this.Bbv.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(68846);
        if ((paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
        {
          ac.i("MicroMsg.WalletLqtPlanAddUI", "click enter");
          WalletLqtPlanAddUI.this.hideWcKb();
          AppMethodBeat.o(68846);
          return true;
        }
        AppMethodBeat.o(68846);
        return true;
      }
    });
    this.BbC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68857);
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).isShown()) {
          WalletLqtPlanAddUI.this.hideWcKb();
        }
        ac.i("MicroMsg.WalletLqtPlanAddUI", "click btn");
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
    this.BbD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68858);
        WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
        AppMethodBeat.o(68858);
      }
    });
    this.Bbz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68859);
        WalletLqtPlanAddUI.f(WalletLqtPlanAddUI.this);
        AppMethodBeat.o(68859);
      }
    });
    this.BbB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68860);
        WalletLqtPlanAddUI.g(WalletLqtPlanAddUI.this);
        AppMethodBeat.o(68860);
      }
    });
    this.Bbv.a(new TextWatcher()
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
          WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).yw(false);
          AppMethodBeat.o(68861);
          return;
        }
        WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).yw(true);
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
        ac.i("MicroMsg.WalletLqtPlanAddUI", "onVisibleStateChange() visitable:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).fzP())
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
    this.Bbq.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68864);
        if ((WalletLqtPlanAddUI.j(WalletLqtPlanAddUI.this).isShown()) && (WalletLqtPlanAddUI.k(WalletLqtPlanAddUI.this).fzM()))
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
    this.Bca.setVisibility(8);
    e(this.BbX);
    e(this.BbY);
    e(this.BbZ);
    setWcKbHeightListener(this);
    AppMethodBeat.o(68867);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68870);
    ac.i("MicroMsg.WalletLqtPlanAddUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        i = com.tencent.mm.wallet_core.ui.e.mj(this.Bbv.getText(), "100");
        str2 = this.BbQ.cZz;
        str3 = this.BbQ.vxk;
        str4 = this.BbQ.AWI;
        j = this.BbQ.fsg;
        k = this.BbQ.AWN;
        localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
        localObject = this.BbJ.AXz;
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
        i = com.tencent.mm.wallet_core.ui.e.mj(this.Bbv.getText(), "100");
        j = this.BbQ.AWN;
        str2 = this.BbQ.cZz;
        str3 = this.BbQ.vxk;
        str4 = this.BbQ.AWI;
        k = this.BbQ.fsg;
        localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
        localObject = this.BbJ.AXA;
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
      paramBundle = new cfq();
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_plan_item");
      if (arrayOfByte != null)
      {
        this.BbQ = ((cfq)paramBundle.parseFrom(arrayOfByte));
        this.BbS = this.BbQ.dBN;
        this.BbT = this.BbQ.fsg;
        this.BbU = this.BbQ.AWI;
      }
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        int i;
        ac.printErrStackTrace("MicroMsg.WalletLqtPlanAddUI", paramBundle, "", new Object[0]);
      }
      initView();
      cL();
      tm(true);
      AppMethodBeat.o(68866);
    }
    this.BbW = new String[28];
    i = 0;
    while (i < 28)
    {
      this.BbW[i] = getString(2131765429, new Object[] { String.valueOf(i + 1) });
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
    if ((this.wJe.isShown()) && (bs.isNullOrNil(this.Bbv.getText())))
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