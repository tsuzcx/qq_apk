package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ab;
import com.tencent.mm.plugin.wallet.balance.model.lqt.aj;
import com.tencent.mm.plugin.wallet.balance.model.lqt.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.protocal.protobuf.ehr;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.e.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.model.a.a;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class WalletLqtPlanAddUI
  extends WalletLqtBasePresenterUI
  implements WcPayKeyboard.a
{
  private static final int DWZ;
  private static final int Vfo;
  private int JjQ;
  private HashMap<String, Integer> Kkr;
  private com.tencent.mm.plugin.wallet.ui.a MBw;
  private IListener<ng> Myr;
  private LinearLayout VfA;
  private Button VfB;
  private CheckBox VfC;
  private TextView VfD;
  private LinearLayout VfE;
  private View VfF;
  private View VfG;
  private View VfH;
  private ab VfI;
  private boolean VfJ;
  private String VfK;
  private List<Bankcard> VfL;
  private dcc VfM;
  private ehr VfN;
  private boolean VfO;
  private edt VfP;
  private LinearLayout VfQ;
  private long VfR;
  private int VfS;
  private String VfT;
  private String VfU;
  private String[] VfV;
  private Button VfW;
  private Button VfX;
  private Button VfY;
  private RelativeLayout VfZ;
  private ScrollView Vfp;
  private TextView Vfq;
  private TextView Vfr;
  private TextView Vfs;
  private TextView Vft;
  private WalletFormView Vfu;
  private TextView Vfv;
  private CdnImageView Vfw;
  private TextView Vfx;
  private LinearLayout Vfy;
  private TextView Vfz;
  private List<env> Vga;
  private boolean Vgb;
  private boolean Vgc;
  private boolean Vgd;
  private int mMode;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private String mTitle;
  private WcPayKeyboard pJb;
  
  static
  {
    AppMethodBeat.i(68896);
    Vfo = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 48);
    DWZ = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(68896);
  }
  
  public WalletLqtPlanAddUI()
  {
    AppMethodBeat.i(68865);
    this.VfI = ((ab)aI(ab.class));
    this.JjQ = 0;
    this.VfJ = false;
    this.VfL = new ArrayList();
    this.VfP = new edt();
    this.Vga = new ArrayList();
    this.Vgb = false;
    this.Vgc = true;
    this.Vgd = true;
    this.Kkr = new HashMap();
    this.Myr = new IListener(f.hfK) {};
    AppMethodBeat.o(68865);
  }
  
  private void Hm(final boolean paramBoolean)
  {
    final Dialog localDialog = null;
    AppMethodBeat.i(68871);
    Log.i("MicroMsg.WalletLqtPlanAddUI", "do pre add plan: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    int i;
    if ((this.mMode == 2) && (this.VfP != null))
    {
      i = this.VfP.UZF;
      localDialog = com.tencent.mm.wallet_core.ui.l.c(getContext(), false, null);
    }
    for (;;)
    {
      t localt = new t();
      localt.d(new com.tencent.mm.plugin.wallet.balance.model.lqt.l(this.mMode, i));
      localt.a(new a.a() {}, 0L);
      AppMethodBeat.o(68871);
      return;
      i = 0;
    }
  }
  
  private void arM(int paramInt)
  {
    AppMethodBeat.i(316481);
    Log.i("MicroMsg.WalletLqtPlanAddUI", "go to check pwd");
    Intent localIntent = new Intent(this, WalletCheckPwdNewUI.class);
    localIntent.putExtra("scene", 3);
    MMApplicationContext.getContext();
    localIntent.putExtra("title", "");
    localIntent.putExtra("subtitle", aj.arK(paramInt));
    startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(316481);
  }
  
  private Bankcard bga(String paramString)
  {
    AppMethodBeat.i(68878);
    Iterator localIterator = this.VfL.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if (localBankcard.field_bindSerial.equals(paramString))
      {
        AppMethodBeat.o(68878);
        return localBankcard;
      }
    }
    paramString = u.iiC().bgD(paramString);
    AppMethodBeat.o(68878);
    return paramString;
  }
  
  private void c(final Button paramButton)
  {
    AppMethodBeat.i(68879);
    paramButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(316431);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this).setText(paramButton.getText().toString().substring(1));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(316431);
      }
    });
    AppMethodBeat.o(68879);
  }
  
  private void ifo()
  {
    AppMethodBeat.i(68873);
    if (this.mMode == 2)
    {
      BigDecimal localBigDecimal = i.b(this.VfP.ihV, "100", 2, RoundingMode.HALF_UP);
      if (localBigDecimal.intValue() == localBigDecimal.doubleValue())
      {
        this.Vfu.setText(localBigDecimal.intValue());
        AppMethodBeat.o(68873);
        return;
      }
      this.Vfu.setText(localBigDecimal.toString());
    }
    AppMethodBeat.o(68873);
  }
  
  private void ifp()
  {
    AppMethodBeat.i(68874);
    final Bankcard localBankcard = bga(this.VfP.UZA);
    if (localBankcard != null)
    {
      this.Vft.setVisibility(8);
      if (Util.isNullOrNil(localBankcard.field_bankcardTypeName)) {
        this.Vfx.setText(String.format("%s(%s)", new Object[] { this.VfP.JFk, this.VfP.MEp }));
      }
      for (;;)
      {
        this.Vfw.setTag(this.VfP.UZA);
        if (!localBankcard.ihV()) {
          break;
        }
        this.Vfw.setImageResource(a.e.wallet_balance_manager_logo_small);
        AppMethodBeat.o(68874);
        return;
        this.Vfx.setText(String.format("%s %s(%s)", new Object[] { this.VfP.JFk, localBankcard.field_bankcardTypeName, this.VfP.MEp }));
      }
      Object localObject = "";
      e locale = com.tencent.mm.plugin.wallet_core.d.b.j(this, localBankcard.field_bankcardType, localBankcard.ihU());
      if (locale != null) {
        localObject = locale.MpW;
      }
      localObject = r.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject));
      if (localObject != null) {
        this.Vfw.setImageBitmap((Bitmap)localObject);
      }
      r.a(new r.a()
      {
        public final void k(String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(316437);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(316518);
              if ((WalletLqtPlanAddUI.16.this.Vgj != null) && (WalletLqtPlanAddUI.x(WalletLqtPlanAddUI.this).getTag() != null) && (WalletLqtPlanAddUI.x(WalletLqtPlanAddUI.this).getTag().equals(WalletLqtPlanAddUI.16.this.Vgj.field_bindSerial))) {
                WalletLqtPlanAddUI.x(WalletLqtPlanAddUI.this).setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(316518);
            }
          });
          AppMethodBeat.o(316437);
        }
      });
      AppMethodBeat.o(68874);
      return;
    }
    this.Vft.setVisibility(0);
    AppMethodBeat.o(68874);
  }
  
  private void ifq()
  {
    AppMethodBeat.i(68875);
    int i = this.VfP.day - 1;
    Log.i("MicroMsg.WalletLqtPlanAddUI", "select day index: %s", new Object[] { Integer.valueOf(i) });
    if ((i >= 0) && (i < this.VfV.length))
    {
      this.Vfs.setVisibility(8);
      this.Vfz.setText(this.VfV[i]);
      AppMethodBeat.o(68875);
      return;
    }
    this.Vfs.setVisibility(0);
    AppMethodBeat.o(68875);
  }
  
  private void ifr()
  {
    AppMethodBeat.i(68876);
    double d = Util.getDouble(this.Vfu.getText(), 0.0D);
    Log.i("MicroMsg.WalletLqtPlanAddUI", "money: %s", new Object[] { Double.valueOf(d) });
    Bankcard localBankcard = bga(this.VfP.UZA);
    if ((localBankcard != null) && (d > localBankcard.field_dayQuotaKind))
    {
      Log.i("MicroMsg.WalletLqtPlanAddUI", "show over alert");
      this.Vfv.setText(this.VfU);
      this.Vfv.setTextColor(getResources().getColor(a.c.red_text_color));
      this.VfQ.setVisibility(0);
      AppMethodBeat.o(68876);
      return;
    }
    this.Vfv.setText(this.VfK);
    this.Vfv.setTextColor(getResources().getColor(a.c.normal_color));
    this.VfQ.setVisibility(0);
    AppMethodBeat.o(68876);
  }
  
  private void ifs()
  {
    AppMethodBeat.i(68877);
    this.VfE.setVisibility(8);
    AppMethodBeat.o(68877);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(68872);
    ifo();
    ifp();
    ifq();
    ifs();
    ifr();
    this.Vfp.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(316435);
        if (WalletLqtPlanAddUI.v(WalletLqtPlanAddUI.this) != null) {
          WalletLqtPlanAddUI.v(WalletLqtPlanAddUI.this).setVisibility(0);
        }
        p.a(WalletLqtPlanAddUI.this, WalletLqtPlanAddUI.n(WalletLqtPlanAddUI.this), WalletLqtPlanAddUI.this.findViewById(a.f.parent_view_rl), WalletLqtPlanAddUI.w(WalletLqtPlanAddUI.this), WalletLqtPlanAddUI.v(WalletLqtPlanAddUI.this), 24);
        AppMethodBeat.o(316435);
      }
    });
    AppMethodBeat.o(68872);
  }
  
  private static String xx(long paramLong)
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
  
  public final void cY(float paramFloat)
  {
    AppMethodBeat.i(68882);
    Log.i("MicroMsg.WalletLqtPlanAddUI", "onUpdateWcPayKeyboardHeight");
    if (this.Vgd)
    {
      this.Vgd = false;
      int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
      Rect localRect = new Rect();
      this.Vfy.getGlobalVisibleRect(localRect);
      Log.i("MicroMsg.WalletLqtPlanAddUI", "screenHeight：%s，mWcKeyboard.getHeight():%s,pageBottomRect.bottom:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mWcKeyboard.getHeight()), Integer.valueOf(localRect.bottom) });
      if (i - this.mWcKeyboard.getHeight() - localRect.bottom <= bd.fromDPToPix(this, 22)) {
        break label145;
      }
    }
    label145:
    for (boolean bool = false;; bool = true)
    {
      this.Vgc = bool;
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
    this.Vfp = ((ScrollView)findViewById(a.f.lpsu_root_view));
    this.Vfq = ((TextView)findViewById(a.f.lpsu_money_title_tv));
    this.Vfr = ((TextView)findViewById(a.f.lpsu_money_subtitle_tv));
    this.Vfs = ((TextView)findViewById(a.f.lpsu_plan_date_title));
    this.Vft = ((TextView)findViewById(a.f.lpsu_plan_bank_title));
    this.Vfu = ((WalletFormView)findViewById(a.f.lpsu_money_et));
    this.Vfv = ((TextView)findViewById(a.f.lpsu_hint_tv));
    this.Vfw = ((CdnImageView)findViewById(a.f.lpsu_bank_iv));
    this.Vfx = ((TextView)findViewById(a.f.lpsu_bank_tv));
    this.Vfy = ((LinearLayout)findViewById(a.f.lpsu_bank_layout));
    this.Vfz = ((TextView)findViewById(a.f.lpsu_plan_date_tv));
    this.VfA = ((LinearLayout)findViewById(a.f.lpsu_plan_date_layout));
    this.VfB = ((Button)findViewById(a.f.lpsu_btn));
    this.VfC = ((CheckBox)findViewById(a.f.lpsu_protocol_cb));
    this.VfD = ((TextView)findViewById(a.f.lpsu_protocol_tv));
    this.VfE = ((LinearLayout)findViewById(a.f.lpsu_protocol_layout));
    this.VfQ = ((LinearLayout)findViewById(a.f.lpsu_hint_layout));
    this.pJb = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    this.VfF = findViewById(a.f.lpsu_top);
    this.VfG = findViewById(a.f.lpsu_top_inner);
    this.VfH = findViewById(a.f.lpsu_bottom);
    this.VfZ = ((RelativeLayout)findViewById(a.f.recommand_keyboard_ll));
    this.VfW = ((Button)findViewById(a.f.recommand_money_first));
    this.VfX = ((Button)findViewById(a.f.recommand_money_second));
    this.VfY = ((Button)findViewById(a.f.recommand_money_third));
    this.Vfu.aGD(0);
    this.Vfu.setTitleText(ai.jOX());
    setWPKeyboard(this.Vfu.getContentEt(), false, false);
    if (d.rb(28)) {
      this.Vfu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68833);
          WalletFormView localWalletFormView = WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this);
          if (localWalletFormView.agVJ != null)
          {
            localWalletFormView.agVJ.setFocusable(true);
            localWalletFormView.agVJ.requestFocus();
          }
          AppMethodBeat.o(68833);
        }
      });
    }
    this.pJb.setActionText(getString(a.i.app_sure));
    this.pJb.Oi(false);
    ((RelativeLayout.LayoutParams)this.pJb.getLayoutParams()).addRule(12);
    this.Vfu.getContentEt().setOnEditorActionListener(new WalletLqtPlanAddUI.12(this));
    this.VfB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68857);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
        if ((WalletLqtPlanAddUI.e(WalletLqtPlanAddUI.this) != null) && (!Util.isNullOrNil(WalletLqtPlanAddUI.e(WalletLqtPlanAddUI.this).title)))
        {
          WalletLqtPlanAddUI.f(WalletLqtPlanAddUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68857);
          return;
        }
        WalletLqtPlanAddUI.g(WalletLqtPlanAddUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68857);
      }
    });
    this.VfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68858);
        WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
        AppMethodBeat.o(68858);
      }
    });
    this.Vfy.setOnClickListener(new WalletLqtPlanAddUI.31(this));
    this.VfA.setOnClickListener(new WalletLqtPlanAddUI.32(this));
    this.Vfu.a(new TextWatcher()
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
        WalletLqtPlanAddUI.j(WalletLqtPlanAddUI.this);
        WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
        if (j == 0)
        {
          WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).Oi(false);
          AppMethodBeat.o(68861);
          return;
        }
        WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).Oi(true);
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
        if (WalletLqtPlanAddUI.b(WalletLqtPlanAddUI.this).jOp())
        {
          AppMethodBeat.o(68863);
          return;
        }
        WalletLqtPlanAddUI.k(WalletLqtPlanAddUI.this).post(new Runnable()
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
    this.Vfp.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68864);
        if ((WalletLqtPlanAddUI.l(WalletLqtPlanAddUI.this).isShown()) && (WalletLqtPlanAddUI.m(WalletLqtPlanAddUI.this).jOm()))
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
    this.VfZ.setVisibility(8);
    c(this.VfW);
    c(this.VfX);
    c(this.VfY);
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
        i = i.qx(this.Vfu.getText(), "100");
        str2 = this.VfP.hAk;
        str3 = this.VfP.MEp;
        str4 = this.VfP.UZA;
        j = this.VfP.day;
        k = this.VfP.UZF;
        localDialog = com.tencent.mm.wallet_core.ui.l.c(getContext(), false, null);
        localObject = this.VfI.Vaw;
        g.a(str1, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
        {
          public final void onInterrupt(Object paramAnonymousObject)
          {
            AppMethodBeat.i(68837);
            localDialog.dismiss();
            if ((paramAnonymousObject instanceof m)) {
              ((m)paramAnonymousObject).U(WalletLqtPlanAddUI.this.getContext(), false);
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
        i = i.qx(this.Vfu.getText(), "100");
        j = this.VfP.UZF;
        str2 = this.VfP.hAk;
        str3 = this.VfP.MEp;
        str4 = this.VfP.UZA;
        k = this.VfP.day;
        localDialog = com.tencent.mm.wallet_core.ui.l.c(getContext(), false, null);
        localObject = this.VfI.Vax;
        g.a(Integer.valueOf(j), str2, str3, str4, Integer.valueOf(i), Integer.valueOf(k), str1).c((com.tencent.mm.vending.c.a)localObject).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
        {
          public final void onInterrupt(Object paramAnonymousObject)
          {
            AppMethodBeat.i(68839);
            localDialog.dismiss();
            if ((paramAnonymousObject instanceof m)) {
              ((m)paramAnonymousObject).U(WalletLqtPlanAddUI.this.getContext(), false);
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
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    this.mMode = getIntent().getIntExtra("key_mode", 0);
    if (this.mMode == 2) {}
    try
    {
      paramBundle = new edt();
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_plan_item");
      if (arrayOfByte != null)
      {
        this.VfP = ((edt)paramBundle.parseFrom(arrayOfByte));
        this.VfR = this.VfP.ihV;
        this.VfS = this.VfP.day;
        this.VfT = this.VfP.UZA;
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
      Hm(true);
      AppMethodBeat.o(68866);
    }
    this.VfV = new String[28];
    i = 0;
    while (i < 28)
    {
      this.VfV[i] = getString(a.i.wallet_lqt_plan_date, new Object[] { String.valueOf(i + 1) });
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
    if ((this.pJb.isShown()) && (Util.isNullOrNil(this.Vfu.getText())))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI
 * JD-Core Version:    0.7.0.1
 */