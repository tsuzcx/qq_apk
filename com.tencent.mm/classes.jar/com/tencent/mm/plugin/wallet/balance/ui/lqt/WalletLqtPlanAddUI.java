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
import com.tencent.mm.f.a.ma;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.aa;
import com.tencent.mm.plugin.wallet.balance.model.lqt.k;
import com.tencent.mm.plugin.wallet.balance.model.lqt.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.clu;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dux;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
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
  private static final int Oqj;
  private static final int Oqk;
  private int Dqi;
  private IListener<ma> GCj;
  private LinearLayout OqA;
  private View OqB;
  private View OqC;
  private View OqD;
  private aa OqE;
  private boolean OqF;
  private String OqG;
  private List<Bankcard> OqH;
  private clu OqI;
  private dox OqJ;
  private boolean OqK;
  private dli OqL;
  private LinearLayout OqM;
  private long OqN;
  private int OqO;
  private String OqP;
  private String OqQ;
  private String[] OqR;
  private Button OqS;
  private Button OqT;
  private Button OqU;
  private RelativeLayout OqV;
  private List<dux> OqW;
  private boolean OqX;
  private boolean OqY;
  private boolean OqZ;
  private ScrollView Oql;
  private TextView Oqm;
  private TextView Oqn;
  private TextView Oqo;
  private TextView Oqp;
  private WalletFormView Oqq;
  private TextView Oqr;
  private CdnImageView Oqs;
  private TextView Oqt;
  private LinearLayout Oqu;
  private TextView Oqv;
  private LinearLayout Oqw;
  private Button Oqx;
  private CheckBox Oqy;
  private TextView Oqz;
  private int mMode;
  private WcPayKeyboard mMt;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private String mTitle;
  
  static
  {
    AppMethodBeat.i(68896);
    Oqj = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 48);
    Oqk = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(68896);
  }
  
  public WalletLqtPlanAddUI()
  {
    AppMethodBeat.i(68865);
    this.OqE = ((aa)ap(aa.class));
    this.Dqi = 0;
    this.OqF = false;
    this.OqH = new ArrayList();
    this.OqL = new dli();
    this.OqW = new ArrayList();
    this.OqX = false;
    this.OqY = true;
    this.OqZ = true;
    this.GCj = new IListener() {};
    AppMethodBeat.o(68865);
  }
  
  private void BH(boolean paramBoolean)
  {
    Dialog localDialog = null;
    AppMethodBeat.i(68871);
    Log.i("MicroMsg.WalletLqtPlanAddUI", "do pre add plan: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    int i;
    if ((this.mMode == 2) && (this.OqL != null))
    {
      i = this.OqL.Olc;
      localDialog = i.c(getContext(), false, null);
    }
    for (;;)
    {
      s locals = new s();
      locals.d(new k(this.mMode, i));
      locals.a(new WalletLqtPlanAddUI.3(this, paramBoolean, localDialog), 0L);
      AppMethodBeat.o(68871);
      return;
      i = 0;
    }
  }
  
  private static String Tp(long paramLong)
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
  
  private Bankcard bgv(String paramString)
  {
    AppMethodBeat.i(68878);
    Iterator localIterator = this.OqH.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if (localBankcard.field_bindSerial.equals(paramString))
      {
        AppMethodBeat.o(68878);
        return localBankcard;
      }
    }
    paramString = com.tencent.mm.plugin.wallet_core.model.u.gJo().bgV(paramString);
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
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this).setText(paramButton.getText().toString().substring(1));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68850);
      }
    });
    AppMethodBeat.o(68879);
  }
  
  private void gGn()
  {
    AppMethodBeat.i(68873);
    if (this.mMode == 2)
    {
      BigDecimal localBigDecimal = com.tencent.mm.wallet_core.ui.g.b(this.OqL.gbJ, "100", 2, RoundingMode.HALF_UP);
      if (localBigDecimal.intValue() == localBigDecimal.doubleValue())
      {
        this.Oqq.setText(localBigDecimal.intValue());
        AppMethodBeat.o(68873);
        return;
      }
      this.Oqq.setText(localBigDecimal.toString());
    }
    AppMethodBeat.o(68873);
  }
  
  private void gGo()
  {
    AppMethodBeat.i(68874);
    final Bankcard localBankcard = bgv(this.OqL.OkX);
    if (localBankcard != null)
    {
      this.Oqp.setVisibility(8);
      if (Util.isNullOrNil(localBankcard.field_bankcardTypeName)) {
        this.Oqt.setText(String.format("%s(%s)", new Object[] { this.OqL.DNV, this.OqL.GHy }));
      }
      for (;;)
      {
        this.Oqs.setTag(this.OqL.OkX);
        if (!localBankcard.gIH()) {
          break;
        }
        this.Oqs.setImageResource(a.e.wallet_balance_manager_logo_small);
        AppMethodBeat.o(68874);
        return;
        this.Oqt.setText(String.format("%s %s(%s)", new Object[] { this.OqL.DNV, localBankcard.field_bankcardTypeName, this.OqL.GHy }));
      }
      Object localObject = "";
      e locale = com.tencent.mm.plugin.wallet_core.d.b.j(this, localBankcard.field_bankcardType, localBankcard.gIG());
      if (locale != null) {
        localObject = locale.GtW;
      }
      localObject = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      if (localObject != null) {
        this.Oqs.setImageBitmap((Bitmap)localObject);
      }
      com.tencent.mm.platformtools.u.a(new u.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(68845);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68844);
              if ((WalletLqtPlanAddUI.11.this.Ord != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag() != null) && (WalletLqtPlanAddUI.t(WalletLqtPlanAddUI.this).getTag().equals(WalletLqtPlanAddUI.11.this.Ord.field_bindSerial))) {
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
    this.Oqp.setVisibility(0);
    AppMethodBeat.o(68874);
  }
  
  private void gGp()
  {
    AppMethodBeat.i(68875);
    int i = this.OqL.day - 1;
    Log.i("MicroMsg.WalletLqtPlanAddUI", "select day index: %s", new Object[] { Integer.valueOf(i) });
    if ((i >= 0) && (i < this.OqR.length))
    {
      this.Oqo.setVisibility(8);
      this.Oqv.setText(this.OqR[i]);
      AppMethodBeat.o(68875);
      return;
    }
    this.Oqo.setVisibility(0);
    AppMethodBeat.o(68875);
  }
  
  private void gGq()
  {
    AppMethodBeat.i(68876);
    double d = Util.getDouble(this.Oqq.getText(), 0.0D);
    Log.i("MicroMsg.WalletLqtPlanAddUI", "money: %s", new Object[] { Double.valueOf(d) });
    Bankcard localBankcard = bgv(this.OqL.OkX);
    if ((localBankcard != null) && (d > localBankcard.field_dayQuotaKind))
    {
      Log.i("MicroMsg.WalletLqtPlanAddUI", "show over alert");
      this.Oqr.setText(this.OqQ);
      this.Oqr.setTextColor(getResources().getColor(a.c.red_text_color));
      this.OqM.setVisibility(0);
      AppMethodBeat.o(68876);
      return;
    }
    this.Oqr.setText(this.OqG);
    this.Oqr.setTextColor(getResources().getColor(a.c.normal_color));
    this.OqM.setVisibility(0);
    AppMethodBeat.o(68876);
  }
  
  private void gGr()
  {
    AppMethodBeat.i(68877);
    if ((this.OqJ != null) && (!Util.isNullOrNil(this.OqJ.title)))
    {
      this.Oqz.setClickable(true);
      this.Oqz.setOnTouchListener(new o(this));
      r localr = new r(new WalletLqtPlanAddUI.13(this));
      String str = getString(a.i.wallet_lqt_plan_protocal_prefix_text);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
      localSpannableStringBuilder.append(this.OqJ.title);
      localSpannableStringBuilder.setSpan(localr, str.length(), localSpannableStringBuilder.length(), 18);
      this.Oqz.setText(localSpannableStringBuilder);
      if (this.OqJ.TVW) {
        this.Oqy.setChecked(true);
      }
      this.OqA.setVisibility(0);
      AppMethodBeat.o(68877);
      return;
    }
    this.OqA.setVisibility(8);
    AppMethodBeat.o(68877);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(68872);
    gGn();
    gGo();
    gGp();
    gGr();
    gGq();
    this.Oql.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68843);
        if (WalletLqtPlanAddUI.r(WalletLqtPlanAddUI.this) != null) {
          WalletLqtPlanAddUI.r(WalletLqtPlanAddUI.this).setVisibility(0);
        }
        q.a(WalletLqtPlanAddUI.this, WalletLqtPlanAddUI.l(WalletLqtPlanAddUI.this), WalletLqtPlanAddUI.this.findViewById(a.f.parent_view_rl), WalletLqtPlanAddUI.s(WalletLqtPlanAddUI.this), WalletLqtPlanAddUI.r(WalletLqtPlanAddUI.this), 24);
        AppMethodBeat.o(68843);
      }
    });
    AppMethodBeat.o(68872);
  }
  
  public final void bU(float paramFloat)
  {
    AppMethodBeat.i(68882);
    Log.i("MicroMsg.WalletLqtPlanAddUI", "onUpdateWcPayKeyboardHeight");
    if (this.OqZ)
    {
      this.OqZ = false;
      int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
      Rect localRect = new Rect();
      this.Oqu.getGlobalVisibleRect(localRect);
      Log.i("MicroMsg.WalletLqtPlanAddUI", "screenHeight：%s，mWcKeyboard.getHeight():%s,pageBottomRect.bottom:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mWcKeyboard.getHeight()), Integer.valueOf(localRect.bottom) });
      if (i - this.mWcKeyboard.getHeight() - localRect.bottom <= aw.fromDPToPix(this, 22)) {
        break label145;
      }
    }
    label145:
    for (boolean bool = false;; bool = true)
    {
      this.OqY = bool;
      AppMethodBeat.o(68882);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return a.g.lqt_plan_save_ui;
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
    this.Oql = ((ScrollView)findViewById(a.f.lpsu_root_view));
    this.Oqm = ((TextView)findViewById(a.f.lpsu_money_title_tv));
    this.Oqn = ((TextView)findViewById(a.f.lpsu_money_subtitle_tv));
    this.Oqo = ((TextView)findViewById(a.f.lpsu_plan_date_title));
    this.Oqp = ((TextView)findViewById(a.f.lpsu_plan_bank_title));
    this.Oqq = ((WalletFormView)findViewById(a.f.lpsu_money_et));
    this.Oqr = ((TextView)findViewById(a.f.lpsu_hint_tv));
    this.Oqs = ((CdnImageView)findViewById(a.f.lpsu_bank_iv));
    this.Oqt = ((TextView)findViewById(a.f.lpsu_bank_tv));
    this.Oqu = ((LinearLayout)findViewById(a.f.lpsu_bank_layout));
    this.Oqv = ((TextView)findViewById(a.f.lpsu_plan_date_tv));
    this.Oqw = ((LinearLayout)findViewById(a.f.lpsu_plan_date_layout));
    this.Oqx = ((Button)findViewById(a.f.lpsu_btn));
    this.Oqy = ((CheckBox)findViewById(a.f.lpsu_protocol_cb));
    this.Oqz = ((TextView)findViewById(a.f.lpsu_protocol_tv));
    this.OqA = ((LinearLayout)findViewById(a.f.lpsu_protocol_layout));
    this.OqM = ((LinearLayout)findViewById(a.f.lpsu_hint_layout));
    this.mMt = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    this.OqB = findViewById(a.f.lpsu_top);
    this.OqC = findViewById(a.f.lpsu_top_inner);
    this.OqD = findViewById(a.f.lpsu_bottom);
    this.OqV = ((RelativeLayout)findViewById(a.f.recommand_keyboard_ll));
    this.OqS = ((Button)findViewById(a.f.recommand_money_first));
    this.OqT = ((Button)findViewById(a.f.recommand_money_second));
    this.OqU = ((Button)findViewById(a.f.recommand_money_third));
    this.Oqq.azN(0);
    this.Oqq.setTitleText(ah.ijb());
    setWPKeyboard(this.Oqq.getContentEt(), false, false);
    if (d.qV(28)) {
      this.Oqq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68833);
          WalletFormView localWalletFormView = WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this);
          if (localWalletFormView.YXE != null)
          {
            localWalletFormView.YXE.setFocusable(true);
            localWalletFormView.YXE.requestFocus();
          }
          AppMethodBeat.o(68833);
        }
      });
    }
    this.mMt.setActionText(getString(a.i.app_sure));
    this.mMt.Ih(false);
    ((RelativeLayout.LayoutParams)this.mMt.getLayoutParams()).addRule(12);
    this.Oqq.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(68846);
        if ((paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
        {
          Log.i("MicroMsg.WalletLqtPlanAddUI", "click enter");
          WalletLqtPlanAddUI.this.hideWcKb();
          AppMethodBeat.o(68846);
          return true;
        }
        AppMethodBeat.o(68846);
        return true;
      }
    });
    this.Oqx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68857);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).isShown()) {
          WalletLqtPlanAddUI.this.hideWcKb();
        }
        Log.i("MicroMsg.WalletLqtPlanAddUI", "click btn");
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
    this.Oqy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68858);
        WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
        AppMethodBeat.o(68858);
      }
    });
    this.Oqu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68859);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletLqtPlanAddUI.f(WalletLqtPlanAddUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68859);
      }
    });
    this.Oqw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68860);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletLqtPlanAddUI.g(WalletLqtPlanAddUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68860);
      }
    });
    this.Oqq.a(new TextWatcher()
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
          WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).Ih(false);
          AppMethodBeat.o(68861);
          return;
        }
        WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).Ih(true);
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
        Log.i("MicroMsg.WalletLqtPlanAddUI", "onVisibleStateChange() visitable:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).iiu())
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
    this.Oql.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68864);
        if ((WalletLqtPlanAddUI.j(WalletLqtPlanAddUI.this).isShown()) && (WalletLqtPlanAddUI.k(WalletLqtPlanAddUI.this).iir()))
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
    this.OqV.setVisibility(8);
    e(this.OqS);
    e(this.OqT);
    e(this.OqU);
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
        i = com.tencent.mm.wallet_core.ui.g.oz(this.Oqq.getText(), "100");
        str2 = this.OqL.fvP;
        str3 = this.OqL.GHy;
        str4 = this.OqL.OkX;
        j = this.OqL.day;
        k = this.OqL.Olc;
        localDialog = i.c(getContext(), false, null);
        localObject = this.OqE.OlQ;
        com.tencent.mm.vending.g.g.b(str1, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new WalletLqtPlanAddUI.4(this, localDialog));
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
        i = com.tencent.mm.wallet_core.ui.g.oz(this.Oqq.getText(), "100");
        j = this.OqL.Olc;
        str2 = this.OqL.fvP;
        str3 = this.OqL.GHy;
        str4 = this.OqL.OkX;
        k = this.OqL.day;
        localDialog = i.c(getContext(), false, null);
        localObject = this.OqE.OlR;
        com.tencent.mm.vending.g.g.b(Integer.valueOf(j), str2, str3, str4, Integer.valueOf(i), Integer.valueOf(k), str1).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new WalletLqtPlanAddUI.6(this, localDialog));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68866);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    this.mMode = getIntent().getIntExtra("key_mode", 0);
    if (this.mMode == 2) {}
    try
    {
      paramBundle = new dli();
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_plan_item");
      if (arrayOfByte != null)
      {
        this.OqL = ((dli)paramBundle.parseFrom(arrayOfByte));
        this.OqN = this.OqL.gbJ;
        this.OqO = this.OqL.day;
        this.OqP = this.OqL.OkX;
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
      BH(true);
      AppMethodBeat.o(68866);
    }
    this.OqR = new String[28];
    i = 0;
    while (i < 28)
    {
      this.OqR[i] = getString(a.i.wallet_lqt_plan_date, new Object[] { String.valueOf(i + 1) });
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
    if ((this.mMt.isShown()) && (Util.isNullOrNil(this.Oqq.getText())))
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