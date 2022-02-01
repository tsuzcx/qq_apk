package com.tencent.mm.plugin.wallet.balance.ui.lqt;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.k;
import com.tencent.mm.plugin.wallet.balance.model.lqt.r;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.wallet_core.c.a.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
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
  private static final int CBB;
  private static final int CBC;
  private ScrollView CBD;
  private TextView CBE;
  private TextView CBF;
  private TextView CBG;
  private TextView CBH;
  private WalletFormView CBI;
  private TextView CBJ;
  private CdnImageView CBK;
  private TextView CBL;
  private LinearLayout CBM;
  private TextView CBN;
  private LinearLayout CBO;
  private Button CBP;
  private CheckBox CBQ;
  private TextView CBS;
  private LinearLayout CBT;
  private View CBU;
  private View CBV;
  private View CBW;
  private x CBX;
  private boolean CBY;
  private String CBZ;
  private List<Bankcard> CCa;
  private bpp CCb;
  private cmp CCc;
  private boolean CCd;
  private ckp CCe;
  private LinearLayout CCf;
  private long CCg;
  private int CCh;
  private String CCi;
  private String CCj;
  private String[] CCk;
  private Button CCl;
  private Button CCm;
  private Button CCn;
  private RelativeLayout CCo;
  private List<csc> CCp;
  private boolean CCq;
  private boolean CCr;
  private boolean CCs;
  private int mMode;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private String mTitle;
  private int uCd;
  private com.tencent.mm.sdk.b.c<ks> wxJ;
  private WcPayKeyboard xWL;
  
  static
  {
    AppMethodBeat.i(68896);
    CBB = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 48);
    CBC = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 8);
    AppMethodBeat.o(68896);
  }
  
  public WalletLqtPlanAddUI()
  {
    AppMethodBeat.i(68865);
    this.CBX = ((x)am(x.class));
    this.uCd = 0;
    this.CBY = false;
    this.CCa = new ArrayList();
    this.CCe = new ckp();
    this.CCp = new ArrayList();
    this.CCq = false;
    this.CCr = true;
    this.CCs = true;
    this.wxJ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68865);
  }
  
  private static String Cg(long paramLong)
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
  
  private Bankcard aDV(String paramString)
  {
    AppMethodBeat.i(68878);
    Iterator localIterator = this.CCa.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if (localBankcard.field_bindSerial.equals(paramString))
      {
        AppMethodBeat.o(68878);
        return localBankcard;
      }
    }
    paramString = t.eFy().aEt(paramString);
    AppMethodBeat.o(68878);
    return paramString;
  }
  
  private void e(Button paramButton)
  {
    AppMethodBeat.i(68879);
    paramButton.setOnClickListener(new WalletLqtPlanAddUI.16(this, paramButton));
    AppMethodBeat.o(68879);
  }
  
  private void eCQ()
  {
    AppMethodBeat.i(68873);
    if (this.mMode == 2)
    {
      BigDecimal localBigDecimal = com.tencent.mm.wallet_core.ui.e.b(this.CCe.dOa, "100", 2, RoundingMode.HALF_UP);
      if (localBigDecimal.intValue() == localBigDecimal.doubleValue())
      {
        this.CBI.setText(localBigDecimal.intValue());
        AppMethodBeat.o(68873);
        return;
      }
      this.CBI.setText(localBigDecimal.toString());
    }
    AppMethodBeat.o(68873);
  }
  
  private void eCR()
  {
    AppMethodBeat.i(68874);
    final Bankcard localBankcard = aDV(this.CCe.CwR);
    if (localBankcard != null)
    {
      this.CBH.setVisibility(8);
      if (bt.isNullOrNil(localBankcard.field_bankcardTypeName)) {
        this.CBL.setText(String.format("%s(%s)", new Object[] { this.CCe.uJF, this.CCe.wCE }));
      }
      for (;;)
      {
        this.CBK.setTag(this.CCe.CwR);
        if (!localBankcard.eER()) {
          break;
        }
        this.CBK.setImageResource(2131234612);
        AppMethodBeat.o(68874);
        return;
        this.CBL.setText(String.format("%s %s(%s)", new Object[] { this.CCe.uJF, localBankcard.field_bankcardTypeName, this.CCe.wCE }));
      }
      Object localObject = "";
      com.tencent.mm.plugin.wallet_core.model.e locale = com.tencent.mm.plugin.wallet_core.d.b.i(this, localBankcard.field_bankcardType, localBankcard.eEQ());
      if (locale != null) {
        localObject = locale.wqa;
      }
      localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      if (localObject != null) {
        this.CBK.setImageBitmap((Bitmap)localObject);
      }
      u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68845);
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68844);
              if ((WalletLqtPlanAddUI.11.this.CCw != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag() != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag().equals(WalletLqtPlanAddUI.11.this.CCw.field_bindSerial))) {
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
    this.CBH.setVisibility(0);
    AppMethodBeat.o(68874);
  }
  
  private void eCS()
  {
    AppMethodBeat.i(68875);
    int i = this.CCe.fKG - 1;
    ad.i("MicroMsg.WalletLqtPlanAddUI", "select day index: %s", new Object[] { Integer.valueOf(i) });
    if ((i >= 0) && (i < this.CCk.length))
    {
      this.CBG.setVisibility(8);
      this.CBN.setText(this.CCk[i]);
      AppMethodBeat.o(68875);
      return;
    }
    this.CBG.setVisibility(0);
    AppMethodBeat.o(68875);
  }
  
  private void eCT()
  {
    AppMethodBeat.i(68876);
    double d = bt.getDouble(this.CBI.getText(), 0.0D);
    ad.i("MicroMsg.WalletLqtPlanAddUI", "money: %s", new Object[] { Double.valueOf(d) });
    Bankcard localBankcard = aDV(this.CCe.CwR);
    if ((localBankcard != null) && (d > localBankcard.field_dayQuotaKind))
    {
      ad.i("MicroMsg.WalletLqtPlanAddUI", "show over alert");
      this.CBJ.setText(this.CCj);
      this.CBJ.setTextColor(getResources().getColor(2131100800));
      this.CCf.setVisibility(0);
      AppMethodBeat.o(68876);
      return;
    }
    this.CBJ.setText(this.CBZ);
    this.CBJ.setTextColor(getResources().getColor(2131100707));
    this.CCf.setVisibility(0);
    AppMethodBeat.o(68876);
  }
  
  private void eCU()
  {
    AppMethodBeat.i(68877);
    if ((this.CCc != null) && (!bt.isNullOrNil(this.CCc.title)))
    {
      this.CBS.setClickable(true);
      this.CBS.setOnTouchListener(new n(this));
      q localq = new q(new q.a()
      {
        public final void dN(View paramAnonymousView)
        {
          AppMethodBeat.i(68847);
          com.tencent.mm.wallet_core.ui.e.o(WalletLqtPlanAddUI.this.getContext(), WalletLqtPlanAddUI.u(WalletLqtPlanAddUI.this).url, true);
          AppMethodBeat.o(68847);
        }
      });
      String str = getString(2131765472);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
      localSpannableStringBuilder.append(this.CCc.title);
      localSpannableStringBuilder.setSpan(localq, str.length(), localSpannableStringBuilder.length(), 18);
      this.CBS.setText(localSpannableStringBuilder);
      if (this.CCc.HfU) {
        this.CBQ.setChecked(true);
      }
      this.CBT.setVisibility(0);
      AppMethodBeat.o(68877);
      return;
    }
    this.CBT.setVisibility(8);
    AppMethodBeat.o(68877);
  }
  
  private void tW(final boolean paramBoolean)
  {
    final Dialog localDialog = null;
    AppMethodBeat.i(68871);
    ad.i("MicroMsg.WalletLqtPlanAddUI", "do pre add plan: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    int i;
    if ((this.mMode == 2) && (this.CCe != null))
    {
      i = this.CCe.CwW;
      localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
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
    eCQ();
    eCR();
    eCS();
    eCU();
    eCT();
    this.CBD.post(new WalletLqtPlanAddUI.10(this));
    AppMethodBeat.o(68872);
  }
  
  public final void bv(float paramFloat)
  {
    AppMethodBeat.i(68882);
    ad.i("MicroMsg.WalletLqtPlanAddUI", "onUpdateWcPayKeyboardHeight");
    if (this.CCs)
    {
      this.CCs = false;
      int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
      Rect localRect = new Rect();
      this.CBM.getGlobalVisibleRect(localRect);
      ad.i("MicroMsg.WalletLqtPlanAddUI", "screenHeight：%s，mWcKeyboard.getHeight():%s,pageBottomRect.bottom:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mWcKeyboard.getHeight()), Integer.valueOf(localRect.bottom) });
      if (i - this.mWcKeyboard.getHeight() - localRect.bottom <= com.tencent.mm.ui.aq.fromDPToPix(this, 22)) {
        break label145;
      }
    }
    label145:
    for (boolean bool = false;; bool = true)
    {
      this.CCr = bool;
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
    this.CBD = ((ScrollView)findViewById(2131301632));
    this.CBE = ((TextView)findViewById(2131301623));
    this.CBF = ((TextView)findViewById(2131301622));
    this.CBG = ((TextView)findViewById(2131301627));
    this.CBH = ((TextView)findViewById(2131301625));
    this.CBI = ((WalletFormView)findViewById(2131301617));
    this.CBJ = ((TextView)findViewById(2131301616));
    this.CBK = ((CdnImageView)findViewById(2131301610));
    this.CBL = ((TextView)findViewById(2131301612));
    this.CBM = ((LinearLayout)findViewById(2131301611));
    this.CBN = ((TextView)findViewById(2131301628));
    this.CBO = ((LinearLayout)findViewById(2131301626));
    this.CBP = ((Button)findViewById(2131301614));
    this.CBQ = ((CheckBox)findViewById(2131301629));
    this.CBS = ((TextView)findViewById(2131301631));
    this.CBT = ((LinearLayout)findViewById(2131301630));
    this.CCf = ((LinearLayout)findViewById(2131301615));
    this.xWL = ((WcPayKeyboard)findViewById(2131307020));
    this.CBU = findViewById(2131301633);
    this.CBV = findViewById(2131301634);
    this.CBW = findViewById(2131301613);
    this.CCo = ((RelativeLayout)findViewById(2131303856));
    this.CCl = ((Button)findViewById(2131303857));
    this.CCm = ((Button)findViewById(2131303858));
    this.CCn = ((Button)findViewById(2131303859));
    this.CBI.setContentPadding$3b4dfe4b(0);
    this.CBI.setTitleText(ah.fRG());
    setWPKeyboard(this.CBI.getContentEt(), false, false);
    if (d.ly(28)) {
      this.CBI.post(new WalletLqtPlanAddUI.1(this));
    }
    this.xWL.setActionText(getString(2131755903));
    this.xWL.zj(false);
    ((RelativeLayout.LayoutParams)this.xWL.getLayoutParams()).addRule(12);
    this.CBI.getContentEt().setOnEditorActionListener(new WalletLqtPlanAddUI.12(this));
    this.CBP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68857);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).isShown()) {
          WalletLqtPlanAddUI.this.hideWcKb();
        }
        ad.i("MicroMsg.WalletLqtPlanAddUI", "click btn");
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
    this.CBQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68858);
        WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
        AppMethodBeat.o(68858);
      }
    });
    this.CBM.setOnClickListener(new WalletLqtPlanAddUI.25(this));
    this.CBO.setOnClickListener(new WalletLqtPlanAddUI.26(this));
    this.CBI.a(new TextWatcher()
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
          WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).zj(false);
          AppMethodBeat.o(68861);
          return;
        }
        WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).zj(true);
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
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).fQZ())
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
    this.CBD.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68864);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if ((WalletLqtPlanAddUI.j(WalletLqtPlanAddUI.this).isShown()) && (WalletLqtPlanAddUI.k(WalletLqtPlanAddUI.this).fQW()))
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
    this.CCo.setVisibility(8);
    e(this.CCl);
    e(this.CCm);
    e(this.CCn);
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
        i = com.tencent.mm.wallet_core.ui.e.mH(this.CBI.getText(), "100");
        str2 = this.CCe.dkR;
        str3 = this.CCe.wCE;
        str4 = this.CCe.CwR;
        j = this.CCe.fKG;
        k = this.CCe.CwW;
        localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
        localObject = this.CBX.CxI;
        com.tencent.mm.vending.g.g.a(str1, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
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
        i = com.tencent.mm.wallet_core.ui.e.mH(this.CBI.getText(), "100");
        j = this.CCe.CwW;
        str2 = this.CCe.dkR;
        str3 = this.CCe.wCE;
        str4 = this.CCe.CwR;
        k = this.CCe.fKG;
        localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
        localObject = this.CBX.CxJ;
        com.tencent.mm.vending.g.g.a(Integer.valueOf(j), str2, str3, str4, Integer.valueOf(i), Integer.valueOf(k), str1).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
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
      paramBundle = new ckp();
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_plan_item");
      if (arrayOfByte != null)
      {
        this.CCe = ((ckp)paramBundle.parseFrom(arrayOfByte));
        this.CCg = this.CCe.dOa;
        this.CCh = this.CCe.fKG;
        this.CCi = this.CCe.CwR;
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
      updateView();
      tW(true);
      AppMethodBeat.o(68866);
    }
    this.CCk = new String[28];
    i = 0;
    while (i < 28)
    {
      this.CCk[i] = getString(2131765429, new Object[] { String.valueOf(i + 1) });
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
    if ((this.xWL.isShown()) && (bt.isNullOrNil(this.CBI.getText())))
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