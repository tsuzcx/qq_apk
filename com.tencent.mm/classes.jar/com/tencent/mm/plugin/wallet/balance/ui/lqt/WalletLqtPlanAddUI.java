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
import android.text.SpannableStringBuilder;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.k;
import com.tencent.mm.plugin.wallet.balance.model.lqt.r;
import com.tencent.mm.plugin.wallet.balance.model.lqt.z;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.picker.c.b;
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
  private static final int Hys;
  private static final int Hyt;
  private IListener<lj> AJa;
  private TextView HyA;
  private CdnImageView HyB;
  private TextView HyC;
  private LinearLayout HyD;
  private TextView HyE;
  private LinearLayout HyF;
  private Button HyG;
  private CheckBox HyH;
  private TextView HyI;
  private LinearLayout HyJ;
  private View HyK;
  private View HyL;
  private View HyM;
  private z HyN;
  private boolean HyO;
  private String HyP;
  private List<Bankcard> HyQ;
  private cda HyR;
  private dfd HyS;
  private boolean HyT;
  private dbt HyU;
  private LinearLayout HyV;
  private long HyW;
  private int HyX;
  private String HyY;
  private String HyZ;
  private ScrollView Hyu;
  private TextView Hyv;
  private TextView Hyw;
  private TextView Hyx;
  private TextView Hyy;
  private WalletFormView Hyz;
  private String[] Hza;
  private Button Hzb;
  private Button Hzc;
  private Button Hzd;
  private RelativeLayout Hze;
  private List<dlf> Hzf;
  private boolean Hzg;
  private boolean Hzh;
  private boolean Hzi;
  private WcPayKeyboard jVg;
  private int mMode;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private String mTitle;
  private int ygg;
  
  static
  {
    AppMethodBeat.i(68896);
    Hys = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 48);
    Hyt = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(68896);
  }
  
  public WalletLqtPlanAddUI()
  {
    AppMethodBeat.i(68865);
    this.HyN = ((z)aq(z.class));
    this.ygg = 0;
    this.HyO = false;
    this.HyQ = new ArrayList();
    this.HyU = new dbt();
    this.Hzf = new ArrayList();
    this.Hzg = false;
    this.Hzh = true;
    this.Hzi = true;
    this.AJa = new IListener() {};
    AppMethodBeat.o(68865);
  }
  
  private static String LR(long paramLong)
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
  
  private Bankcard aUM(String paramString)
  {
    AppMethodBeat.i(68878);
    Iterator localIterator = this.HyQ.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if (localBankcard.field_bindSerial.equals(paramString))
      {
        AppMethodBeat.o(68878);
        return localBankcard;
      }
    }
    paramString = t.fQI().aVm(paramString);
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
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this).setText(paramButton.getText().toString().substring(1));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68850);
      }
    });
    AppMethodBeat.o(68879);
  }
  
  private void fNI()
  {
    AppMethodBeat.i(68873);
    if (this.mMode == 2)
    {
      BigDecimal localBigDecimal = f.b(this.HyU.eht, "100", 2, RoundingMode.HALF_UP);
      if (localBigDecimal.intValue() == localBigDecimal.doubleValue())
      {
        this.Hyz.setText(localBigDecimal.intValue());
        AppMethodBeat.o(68873);
        return;
      }
      this.Hyz.setText(localBigDecimal.toString());
    }
    AppMethodBeat.o(68873);
  }
  
  private void fNJ()
  {
    AppMethodBeat.i(68874);
    final Bankcard localBankcard = aUM(this.HyU.Htm);
    if (localBankcard != null)
    {
      this.Hyy.setVisibility(8);
      if (Util.isNullOrNil(localBankcard.field_bankcardTypeName)) {
        this.HyC.setText(String.format("%s(%s)", new Object[] { this.HyU.ynT, this.HyU.AOk }));
      }
      for (;;)
      {
        this.HyB.setTag(this.HyU.Htm);
        if (!localBankcard.fQb()) {
          break;
        }
        this.HyB.setImageResource(2131235574);
        AppMethodBeat.o(68874);
        return;
        this.HyC.setText(String.format("%s %s(%s)", new Object[] { this.HyU.ynT, localBankcard.field_bankcardTypeName, this.HyU.AOk }));
      }
      Object localObject = "";
      e locale = com.tencent.mm.plugin.wallet_core.d.b.j(this, localBankcard.field_bankcardType, localBankcard.fQa());
      if (locale != null) {
        localObject = locale.AAU;
      }
      localObject = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      if (localObject != null) {
        this.HyB.setImageBitmap((Bitmap)localObject);
      }
      u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68845);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68844);
              if ((WalletLqtPlanAddUI.11.this.Hzm != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag() != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag().equals(WalletLqtPlanAddUI.11.this.Hzm.field_bindSerial))) {
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
    this.Hyy.setVisibility(0);
    AppMethodBeat.o(68874);
  }
  
  private void fNK()
  {
    AppMethodBeat.i(68875);
    int i = this.HyU.grV - 1;
    Log.i("MicroMsg.WalletLqtPlanAddUI", "select day index: %s", new Object[] { Integer.valueOf(i) });
    if ((i >= 0) && (i < this.Hza.length))
    {
      this.Hyx.setVisibility(8);
      this.HyE.setText(this.Hza[i]);
      AppMethodBeat.o(68875);
      return;
    }
    this.Hyx.setVisibility(0);
    AppMethodBeat.o(68875);
  }
  
  private void fNL()
  {
    AppMethodBeat.i(68876);
    double d = Util.getDouble(this.Hyz.getText(), 0.0D);
    Log.i("MicroMsg.WalletLqtPlanAddUI", "money: %s", new Object[] { Double.valueOf(d) });
    Bankcard localBankcard = aUM(this.HyU.Htm);
    if ((localBankcard != null) && (d > localBankcard.field_dayQuotaKind))
    {
      Log.i("MicroMsg.WalletLqtPlanAddUI", "show over alert");
      this.HyA.setText(this.HyZ);
      this.HyA.setTextColor(getResources().getColor(2131100996));
      this.HyV.setVisibility(0);
      AppMethodBeat.o(68876);
      return;
    }
    this.HyA.setText(this.HyP);
    this.HyA.setTextColor(getResources().getColor(2131100900));
    this.HyV.setVisibility(0);
    AppMethodBeat.o(68876);
  }
  
  private void fNM()
  {
    AppMethodBeat.i(68877);
    if ((this.HyS != null) && (!Util.isNullOrNil(this.HyS.title)))
    {
      this.HyI.setClickable(true);
      this.HyI.setOnTouchListener(new o(this));
      q localq = new q(new q.a()
      {
        public final void dF(View paramAnonymousView)
        {
          AppMethodBeat.i(68847);
          f.p(WalletLqtPlanAddUI.this.getContext(), WalletLqtPlanAddUI.u(WalletLqtPlanAddUI.this).url, true);
          AppMethodBeat.o(68847);
        }
      });
      String str = getString(2131767921);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
      localSpannableStringBuilder.append(this.HyS.title);
      localSpannableStringBuilder.setSpan(localq, str.length(), localSpannableStringBuilder.length(), 18);
      this.HyI.setText(localSpannableStringBuilder);
      if (this.HyS.MKd) {
        this.HyH.setChecked(true);
      }
      this.HyJ.setVisibility(0);
      AppMethodBeat.o(68877);
      return;
    }
    this.HyJ.setVisibility(8);
    AppMethodBeat.o(68877);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(68872);
    fNI();
    fNJ();
    fNK();
    fNM();
    fNL();
    this.Hyu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68843);
        if (WalletLqtPlanAddUI.r(WalletLqtPlanAddUI.this) != null) {
          WalletLqtPlanAddUI.r(WalletLqtPlanAddUI.this).setVisibility(0);
        }
        p.a(WalletLqtPlanAddUI.this, WalletLqtPlanAddUI.l(WalletLqtPlanAddUI.this), WalletLqtPlanAddUI.this.findViewById(2131305783), WalletLqtPlanAddUI.s(WalletLqtPlanAddUI.this), WalletLqtPlanAddUI.r(WalletLqtPlanAddUI.this), 24);
        AppMethodBeat.o(68843);
      }
    });
    AppMethodBeat.o(68872);
  }
  
  private void xN(final boolean paramBoolean)
  {
    final Dialog localDialog = null;
    AppMethodBeat.i(68871);
    Log.i("MicroMsg.WalletLqtPlanAddUI", "do pre add plan: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    int i;
    if ((this.mMode == 2) && (this.HyU != null))
    {
      i = this.HyU.Htr;
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
  
  public final void bO(float paramFloat)
  {
    AppMethodBeat.i(68882);
    Log.i("MicroMsg.WalletLqtPlanAddUI", "onUpdateWcPayKeyboardHeight");
    if (this.Hzi)
    {
      this.Hzi = false;
      int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
      Rect localRect = new Rect();
      this.HyD.getGlobalVisibleRect(localRect);
      Log.i("MicroMsg.WalletLqtPlanAddUI", "screenHeight：%s，mWcKeyboard.getHeight():%s,pageBottomRect.bottom:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mWcKeyboard.getHeight()), Integer.valueOf(localRect.bottom) });
      if (i - this.mWcKeyboard.getHeight() - localRect.bottom <= at.fromDPToPix(this, 22)) {
        break label145;
      }
    }
    label145:
    for (boolean bool = false;; bool = true)
    {
      this.Hzh = bool;
      AppMethodBeat.o(68882);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495344;
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
    this.Hyu = ((ScrollView)findViewById(2131303901));
    this.Hyv = ((TextView)findViewById(2131303892));
    this.Hyw = ((TextView)findViewById(2131303891));
    this.Hyx = ((TextView)findViewById(2131303896));
    this.Hyy = ((TextView)findViewById(2131303894));
    this.Hyz = ((WalletFormView)findViewById(2131303886));
    this.HyA = ((TextView)findViewById(2131303885));
    this.HyB = ((CdnImageView)findViewById(2131303879));
    this.HyC = ((TextView)findViewById(2131303881));
    this.HyD = ((LinearLayout)findViewById(2131303880));
    this.HyE = ((TextView)findViewById(2131303897));
    this.HyF = ((LinearLayout)findViewById(2131303895));
    this.HyG = ((Button)findViewById(2131303883));
    this.HyH = ((CheckBox)findViewById(2131303898));
    this.HyI = ((TextView)findViewById(2131303900));
    this.HyJ = ((LinearLayout)findViewById(2131303899));
    this.HyV = ((LinearLayout)findViewById(2131303884));
    this.jVg = ((WcPayKeyboard)findViewById(2131310544));
    this.HyK = findViewById(2131303902);
    this.HyL = findViewById(2131303903);
    this.HyM = findViewById(2131303882);
    this.Hze = ((RelativeLayout)findViewById(2131306665));
    this.Hzb = ((Button)findViewById(2131306666));
    this.Hzc = ((Button)findViewById(2131306667));
    this.Hzd = ((Button)findViewById(2131306668));
    this.Hyz.setContentPadding$3b4dfe4b(0);
    this.Hyz.setTitleText(ah.hhz());
    setWPKeyboard(this.Hyz.getContentEt(), false, false);
    if (d.oD(28)) {
      this.Hyz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68833);
          WalletFormView localWalletFormView = WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this);
          if (localWalletFormView.Rwe != null)
          {
            localWalletFormView.Rwe.setFocusable(true);
            localWalletFormView.Rwe.requestFocus();
          }
          AppMethodBeat.o(68833);
        }
      });
    }
    this.jVg.setActionText(getString(2131755995));
    this.jVg.DH(false);
    ((RelativeLayout.LayoutParams)this.jVg.getLayoutParams()).addRule(12);
    this.Hyz.getContentEt().setOnEditorActionListener(new WalletLqtPlanAddUI.12(this));
    this.HyG.setOnClickListener(new WalletLqtPlanAddUI.23(this));
    this.HyH.setOnCheckedChangeListener(new WalletLqtPlanAddUI.24(this));
    this.HyD.setOnClickListener(new WalletLqtPlanAddUI.25(this));
    this.HyF.setOnClickListener(new WalletLqtPlanAddUI.26(this));
    this.Hyz.a(new WalletLqtPlanAddUI.27(this));
    this.mTenpayKBStateListener = new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68863);
        Log.i("MicroMsg.WalletLqtPlanAddUI", "onVisibleStateChange() visitable:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).hgS())
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
    this.Hyu.setOnTouchListener(new WalletLqtPlanAddUI.29(this));
    setResult(0);
    this.Hze.setVisibility(8);
    e(this.Hzb);
    e(this.Hzc);
    e(this.Hzd);
    setWcKbHeightListener(this);
    AppMethodBeat.o(68867);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68870);
    Log.i("MicroMsg.WalletLqtPlanAddUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        i = f.nE(this.Hyz.getText(), "100");
        str2 = this.HyU.dDj;
        str3 = this.HyU.AOk;
        str4 = this.HyU.Htm;
        j = this.HyU.grV;
        k = this.HyU.Htr;
        localDialog = h.c(getContext(), false, null);
        localObject = this.HyN.Hue;
        g.a(str1, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
        {
          public final void cn(Object paramAnonymousObject)
          {
            AppMethodBeat.i(68837);
            localDialog.dismiss();
            if ((paramAnonymousObject instanceof m)) {
              ((m)paramAnonymousObject).G(WalletLqtPlanAddUI.this.getContext(), false);
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
        i = f.nE(this.Hyz.getText(), "100");
        j = this.HyU.Htr;
        str2 = this.HyU.dDj;
        str3 = this.HyU.AOk;
        str4 = this.HyU.Htm;
        k = this.HyU.grV;
        localDialog = h.c(getContext(), false, null);
        localObject = this.HyN.Huf;
        g.a(Integer.valueOf(j), str2, str3, str4, Integer.valueOf(i), Integer.valueOf(k), str1).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
        {
          public final void cn(Object paramAnonymousObject)
          {
            AppMethodBeat.i(68839);
            localDialog.dismiss();
            if ((paramAnonymousObject instanceof m)) {
              ((m)paramAnonymousObject).G(WalletLqtPlanAddUI.this.getContext(), false);
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
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    this.mMode = getIntent().getIntExtra("key_mode", 0);
    if (this.mMode == 2) {}
    try
    {
      paramBundle = new dbt();
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_plan_item");
      if (arrayOfByte != null)
      {
        this.HyU = ((dbt)paramBundle.parseFrom(arrayOfByte));
        this.HyW = this.HyU.eht;
        this.HyX = this.HyU.grV;
        this.HyY = this.HyU.Htm;
      }
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        int i;
        Log.printErrStackTrace("MicroMsg.WalletLqtPlanAddUI", paramBundle, "", new Object[0]);
      }
      initView();
      updateView();
      xN(true);
      AppMethodBeat.o(68866);
    }
    this.Hza = new String[28];
    i = 0;
    while (i < 28)
    {
      this.Hza[i] = getString(2131767878, new Object[] { String.valueOf(i + 1) });
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
    if ((this.jVg.isShown()) && (Util.isNullOrNil(this.Hyz.getText())))
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