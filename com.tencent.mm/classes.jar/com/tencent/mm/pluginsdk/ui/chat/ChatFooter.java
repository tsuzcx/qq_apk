package com.tencent.mm.pluginsdk.ui.chat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.MMBottomSheetBehavior;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnDragListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.og;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.plugin.transvoice.ui.b.x;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class ChatFooter
  extends LinearLayout
  implements h.a, com.tencent.mm.ui.tools.g
{
  private static int count = 0;
  private static int vWR;
  private static final int[] vXA = { 0, 15, 30, 45, 60, 75, 90, 95, 100 };
  private static final int[] vXB = { 2131230792, 2131230793, 2131230794, 2131230795, 2131230796, 2131230797, 2131230798, 2131230799 };
  private Activity activity;
  public String czp;
  private com.tencent.mm.ui.tools.h ehl;
  public ChatFooterPanel eys;
  private View gcq;
  public final ak mHandler;
  private boolean mwK;
  public View mwP;
  private ImageView mwQ;
  public View mwR;
  public View mwS;
  private final ak mwX;
  private ViewGroup oPl;
  public MMEditText oxm;
  public Button oxn;
  private int sMo;
  private boolean sMp;
  public o tdq;
  private TextView tdr;
  private ImageView tds;
  public View tdt;
  public String toUser;
  private int uKC;
  f vQk;
  public n vSd;
  public boolean vSg;
  private String vVU;
  public AppPanel vVV;
  public TextView vVW;
  private Button vVX;
  public ImageButton vVY;
  private View vVZ;
  private int vWA;
  private int vWB;
  public boolean vWC;
  private boolean vWD;
  private boolean vWE;
  private boolean vWF;
  private int vWG;
  private int vWH;
  com.tencent.mm.g.b.a.b vWI;
  public ChatFooter.c vWJ;
  public ChatFooter.d vWK;
  private m.a vWL;
  private boolean vWM;
  public MMFragment vWN;
  public ChatFooter.b vWO;
  private Animation vWP;
  private Animation vWQ;
  public ViewGroup vWS;
  private View vWT;
  private BlurView vWU;
  private View vWV;
  private View vWW;
  private ImageView vWX;
  private ImageView vWY;
  private View vWZ;
  public ChatFooterBottom vWa;
  private TextView vWb;
  public ImageButton vWc;
  public ImageButton vWd;
  public View vWe;
  private com.tencent.mm.ui.widget.b.c vWf;
  private i vWg;
  public m vWh;
  private b vWi;
  private ChatFooter.e vWj;
  public final ChatFooter.a vWk;
  public boolean vWl;
  private boolean vWm;
  public ViewGroup vWn;
  private TextView vWo;
  private InputMethodManager vWp;
  private int vWq;
  boolean vWr;
  private boolean vWs;
  private boolean vWt;
  public boolean vWu;
  private boolean vWv;
  public int vWw;
  private int vWx;
  private ChattingScrollLayout vWy;
  private boolean vWz;
  private com.tencent.mm.sdk.b.c vXC;
  private int vXD;
  private boolean vXE;
  private final int vXF;
  private final int vXG;
  private volatile boolean vXH;
  private ak vXI;
  private boolean vXJ;
  private int vXK;
  private View vXL;
  private int vXM;
  private int vXN;
  private int vXO;
  private int vXP;
  private int vXQ;
  private int vXR;
  private Runnable vXS;
  private Runnable vXT;
  private TextView vXa;
  private ImageView vXb;
  private View vXc;
  private View vXd;
  private WeImageView vXe;
  private TextView vXf;
  private View vXg;
  private WeImageView vXh;
  private TextView vXi;
  private View vXj;
  private BlurView vXk;
  private com.tencent.mm.plugin.transvoice.ui.b vXl;
  private com.tencent.mm.plugin.transvoice.a.a vXm;
  private com.tencent.mm.modelvoiceaddr.h vXn;
  public o vXo;
  private com.tencent.mm.plugin.transvoice.a.c vXp;
  private ChatFooter.i vXq;
  private ChatFooter.g vXr;
  private ChatFooter.h vXs;
  private boolean vXt;
  private boolean vXu;
  private ChatFooterPanel.a vXv;
  private AppPanel.b vXw;
  public ChatFooter.f vXx;
  private int vXy;
  private int[] vXz;
  
  public ChatFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27830);
    this.gcq = null;
    this.oxm = null;
    this.oxn = null;
    this.vVW = null;
    this.vWj = null;
    this.vWk = new ChatFooter.a((byte)0);
    this.vWl = false;
    this.vWm = false;
    this.mwK = false;
    this.vWs = false;
    this.vWt = false;
    this.vWu = false;
    this.vSg = false;
    this.vWv = true;
    this.vWw = 0;
    this.vWx = -1;
    this.vWB = 0;
    this.vWC = false;
    this.vWD = false;
    this.vWE = true;
    this.vWF = false;
    this.vWI = new com.tencent.mm.g.b.a.b();
    this.vWL = new ChatFooter.1(this);
    this.mHandler = new ChatFooter.12(this);
    this.vWM = false;
    this.sMp = false;
    paramAttributeSet = com.tencent.mm.plugin.transvoice.a.c.tpD;
    this.vXp = com.tencent.mm.plugin.transvoice.a.c.cKY();
    this.vXq = ChatFooter.i.vYs;
    this.vXr = ChatFooter.g.vYk;
    this.vXs = ChatFooter.h.vYo;
    this.vXt = false;
    this.vXu = false;
    this.vXv = new ChatFooter.14(this);
    this.vXw = new ChatFooter.15(this);
    this.mwX = new ChatFooter.18(this);
    this.vXy = 0;
    this.vXz = new int[] { 2131231192, 2131231193, 2131231194, 2131231195, 2131231196, 2131231197, 2131231198, 2131231199, 2131231200, 2131231201 };
    this.vXC = new ChatFooter.23(this);
    this.vXD = 0;
    this.vXE = false;
    this.vXF = 4097;
    this.vXG = 4098;
    this.vXI = new ChatFooter.33(this);
    this.vXJ = false;
    this.vXK = -1;
    this.vXL = null;
    this.vXM = al.ap(getContext(), 2131427536);
    this.vXN = al.ap(getContext(), 2131427591);
    this.vXO = al.fromDPToPix(getContext(), 25);
    this.vXP = al.fromDPToPix(getContext(), 55);
    this.vXQ = 0;
    this.vXR = al.fromDPToPix(getContext(), 50);
    this.vXS = new ChatFooter.41(this);
    this.vXT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156080);
        ChatFooter.s(ChatFooter.this).dismiss();
        AppMethodBeat.o(156080);
      }
    };
    long l = System.currentTimeMillis();
    this.vWp = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.gcq = inflate(paramContext, 2130969036, this);
    this.oxm = ((MMEditText)this.gcq.findViewById(2131822478));
    this.ehl = new com.tencent.mm.ui.tools.h((Activity)paramContext);
    this.ehl.Avp = this;
    if (af.dDm()) {
      this.oxm.setImeOptions(268435456);
    }
    com.tencent.mm.ui.tools.b.c.d(this.oxm).QS(bo.getInt(com.tencent.mm.m.g.Nq().getValue("InputLimitSessionTextMsg"), 8192) * 2).a(null);
    this.oxm.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
    this.oxm.setOnFocusChangeListener(new ChatFooter.43(this));
    if (com.tencent.mm.compatible.util.d.fv(28)) {
      this.oxm.setBreakStrategy(1);
    }
    paramAttributeSet = new og();
    paramAttributeSet.cEQ.cES = this.oxm;
    paramAttributeSet.cEQ.cER = new ChatFooter.45(this);
    com.tencent.mm.sdk.b.a.ymk.l(paramAttributeSet);
    this.vWe = this.gcq.findViewById(2131822477);
    this.vWa = ((ChatFooterBottom)findViewById(2131822486));
    this.oPl = ((ViewGroup)findViewById(2131822471));
    this.vVZ = findViewById(2131822472);
    this.vWc = ((ImageButton)this.gcq.findViewById(2131822484));
    this.oxn = ((Button)this.gcq.findViewById(2131822485));
    this.oxn.setTextSize(0, com.tencent.mm.cb.a.ap(paramContext, 2131427849) * com.tencent.mm.cb.a.gr(paramContext));
    this.vVX = ((Button)this.gcq.findViewById(2131822479));
    this.vVY = ((ImageButton)findViewById(2131822476));
    jf(false);
    doH();
    this.vWg = new i(getContext(), getRootView(), this, new ChatFooter.46(this, paramContext));
    this.vWg.vYR = this;
    paramAttributeSet = getContext();
    getRootView();
    this.vWh = new m(paramAttributeSet);
    this.vWh.vWL = this.vWL;
    ab.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[] { Integer.valueOf(this.oxm.getImeOptions()) });
    this.oxm.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(27822);
        if ((paramAnonymousInt == 4) || ((paramAnonymousInt == 0) && (ChatFooter.g(ChatFooter.this))))
        {
          ChatFooter.h(ChatFooter.this).performClick();
          AppMethodBeat.o(27822);
          return true;
        }
        AppMethodBeat.o(27822);
        return false;
      }
    });
    this.oxm.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(27823);
        ChatFooter.this.setToSendTextColor(true);
        if (ChatFooter.i(ChatFooter.this) != null) {
          ChatFooter.i(ChatFooter.this).M(paramAnonymousMotionEvent);
        }
        ChatFooter.j(ChatFooter.this);
        AppMethodBeat.o(27823);
        return false;
      }
    });
    this.oxm.setOnLongClickListener(new ChatFooter.2(this, paramContext));
    this.oxm.setCustomSelectionActionModeCallback(new ChatFooter.3(this, paramContext));
    this.oxn.setOnClickListener(new ChatFooter.4(this));
    vWR = com.tencent.mm.cb.a.gw(paramContext) / 2 + com.tencent.mm.cb.a.fromDPToPix(paramContext, 30);
    this.vXl = new com.tencent.mm.plugin.transvoice.ui.b(paramContext);
    this.vXl.tqz = new ChatFooter.9(this);
    this.vXm = new com.tencent.mm.plugin.transvoice.a.a(new ChatFooter.10(this));
    this.vVX.setOnTouchListener(new ChatFooter.11(this));
    this.vVX.setOnKeyListener(new ChatFooter.13(this));
    this.vVY.setOnClickListener(new ChatFooter.8(this));
    doi();
    this.vWc.setVisibility(0);
    this.vWc.setContentDescription(getContext().getString(2131298096));
    this.vWc.setOnClickListener(new ChatFooter.6(this));
    ab.i("MicroMsg.ChatFooter", "[init]");
    this.vVZ.setOnTouchListener(new ChatFooter.5(this));
    this.vWA = (((Activity)paramContext).getWindow().getAttributes().softInputMode & 0xF0);
    this.vWH = com.tencent.mm.sdk.platformtools.x.gL(paramContext);
    Ml(getKeyBordHeightPX());
    if (com.tencent.mm.compatible.util.d.fv(24)) {
      setIsMultiWindow(((Activity)paramContext).isInMultiWindowMode());
    }
    ab.d("MicroMsg.ChatFooter", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(27830);
  }
  
  private void Mh(int paramInt)
  {
    AppMethodBeat.i(27845);
    if (this.vVY == null)
    {
      AppMethodBeat.o(27845);
      return;
    }
    if (paramInt == 2130838351) {}
    for (int i = 1;; i = 0)
    {
      if (this.vVY != null)
      {
        if (i == 0) {
          break label83;
        }
        this.vVY.setContentDescription(getContext().getString(2131298102));
      }
      for (;;)
      {
        this.vVY.setImageResource(paramInt);
        this.vVY.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(27845);
        return;
        label83:
        this.vVY.setContentDescription(getContext().getString(2131298101));
      }
    }
  }
  
  private void Ml(int paramInt)
  {
    AppMethodBeat.i(153725);
    ab.i("MicroMsg.ChatFooter", "[refreshBottomHeight] keyborPx:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.compatible.util.j.dss();
    if ((com.tencent.mm.storage.ad.arf(this.vVU)) || (com.tencent.mm.storage.ad.arg(this.vVU)))
    {
      paramInt = com.tencent.mm.compatible.util.j.f(getContext(), paramInt, 43);
      if ((!this.vWv) || (this.vWD)) {
        break label377;
      }
    }
    for (this.vWH = paramInt;; this.vWH = paramInt)
    {
      if (paramInt != this.vWG) {
        this.vWG = paramInt;
      }
      ab.i("MicroMsg.ChatFooter", "refreshBottomHeight: %s, %s, %s, %s", new Object[] { Boolean.valueOf(this.vWv), Boolean.valueOf(this.vWD), Integer.valueOf(this.vWH), Integer.valueOf(this.vWG) });
      Object localObject = this.vWa.getLayoutParams();
      if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != this.vWG))
      {
        ((ViewGroup.LayoutParams)localObject).height = this.vWG;
        this.vWa.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.vWa.requestLayout();
      }
      if (this.vWz)
      {
        paramInt = -this.vWG;
        localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
        if ((localObject != null) && (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != paramInt))
        {
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
          setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.vVV != null)
      {
        this.vVV.setPortHeighPx(this.vWH);
        this.vVV.AD();
      }
      if (this.vSd != null)
      {
        paramInt = this.vWH + this.vVZ.getHeight();
        localObject = this.vSd.getLayoutParams();
        if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != paramInt))
        {
          ((ViewGroup.LayoutParams)localObject).height = paramInt;
          this.vSd.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.eys != null)
      {
        if ((!this.vWC) && (!this.vWa.doR())) {
          doz();
        }
        this.eys.setPortHeightPx(this.vWH);
        this.eys.AD();
      }
      AppMethodBeat.o(153725);
      return;
      paramInt = com.tencent.mm.compatible.util.j.aw(getContext(), paramInt);
      break;
      label377:
      paramInt = com.tencent.mm.sdk.platformtools.x.gL(getContext());
    }
  }
  
  private void a(boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(153718);
    if (paramBoolean)
    {
      if (this.vVV == null) {
        doi();
      }
      this.vVV.animate().cancel();
      if ((this.vVV.getVisibility() == 0) && (this.vVV.getAlpha() == 1.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(153718);
        }
      }
      else
      {
        setAppPanelVisible(0);
        this.vVV.setAlpha(0.0F);
        this.vVV.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
        AppMethodBeat.o(153718);
      }
    }
    else
    {
      this.vVV.animate().cancel();
      if ((this.vVV.getVisibility() == 4) || (this.vVV.getAlpha() == 0.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(153718);
        }
      }
      else {
        this.vVV.animate().setDuration(200L).alpha(0.0F).withEndAction(new ChatFooter.27(this, paramRunnable));
      }
    }
    AppMethodBeat.o(153718);
  }
  
  private void aC(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(153723);
    ab.i("MicroMsg.ChatFooter", "switchPanel: %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if ((paramInt != 0) && (r.ZU().booleanValue()) && (this.vWJ != null))
    {
      this.vWJ.a(Boolean.TRUE, Boolean.FALSE);
      this.vWJ.b(Boolean.TRUE, Boolean.FALSE);
    }
    switch (paramInt)
    {
    default: 
      if (((this.vWw != 0) || (paramInt != 1)) && ((this.vWw != 1) || (paramInt != 0))) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      this.vWw = paramInt;
      com.tencent.mm.emoji.c.a locala;
      if (this.vWw == 2)
      {
        pt(true);
        locala = com.tencent.mm.emoji.c.a.exi;
        com.tencent.mm.emoji.c.a.OY();
      }
      for (;;)
      {
        g(this.vWB, paramBoolean, i);
        AppMethodBeat.o(153723);
        return;
        if ((!this.vWv) || (this.vWD)) {}
        for (this.vWB = 0;; this.vWB = this.sMo)
        {
          b(false, null);
          a(false, null);
          break;
        }
        this.vWB = this.vWH;
        this.vWa.setVisibility(0);
        a(false, new ChatFooter.30(this));
        pr(true);
        break;
        this.vWB = this.vWH;
        this.vWa.setVisibility(0);
        b(false, new ChatFooter.31(this));
        this.vWg.doU();
        pr(false);
        if (this.vWq != 2) {
          break;
        }
        Mk(1);
        break;
        this.vWB = 0;
        b(false, null);
        a(false, null);
        dnr();
        break;
        pt(false);
        locala = com.tencent.mm.emoji.c.a.exi;
        com.tencent.mm.emoji.c.a.OZ();
      }
    }
  }
  
  private void b(boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(153719);
    if (paramBoolean)
    {
      if (this.eys == null) {
        doh();
      }
      this.eys.animate().cancel();
      if ((this.eys.getVisibility() == 0) && (this.eys.getAlpha() == 1.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(153719);
        }
      }
      else
      {
        this.eys.setVisibility(0);
        this.eys.setAlpha(0.0F);
        this.eys.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
        AppMethodBeat.o(153719);
      }
    }
    else if ((this.eys == null) || (this.eys.getVisibility() == 4) || (this.eys.getAlpha() == 0.0F))
    {
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(153719);
      }
    }
    else
    {
      this.eys.animate().cancel();
      this.eys.animate().setDuration(200L).alpha(0.0F).withEndAction(new ChatFooter.28(this, paramRunnable)).start();
    }
    AppMethodBeat.o(153719);
  }
  
  private void doE()
  {
    AppMethodBeat.i(153720);
    if (this.vWy == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ChattingScrollLayout))
      {
        this.vWy = ((ChattingScrollLayout)localViewParent);
        this.vWz = true;
      }
    }
    AppMethodBeat.o(153720);
  }
  
  private void doF()
  {
    AppMethodBeat.i(156082);
    if ((this.vWD) || (!this.vWv))
    {
      this.ehl.close();
      ((Activity)getContext()).getWindow().setSoftInputMode(18);
      AppMethodBeat.o(156082);
      return;
    }
    this.ehl.start();
    ((Activity)getContext()).getWindow().setSoftInputMode(this.vWA | 0x2);
    AppMethodBeat.o(156082);
  }
  
  private void doK()
  {
    AppMethodBeat.i(155466);
    this.vXd.setVisibility(8);
    this.vXg.setVisibility(8);
    this.vXd.setScaleX(0.5F);
    this.vXd.setScaleY(0.5F);
    this.vXg.setScaleX(0.5F);
    this.vXg.setScaleY(0.5F);
    this.vXd.setTranslationX(this.vXO);
    this.vXd.setTranslationY(-this.vXP);
    this.vXg.setTranslationX(-this.vXO);
    this.vXg.setTranslationY(-this.vXP);
    doL();
    doM();
    AppMethodBeat.o(155466);
  }
  
  private void doL()
  {
    AppMethodBeat.i(156083);
    this.vXe.setIconColor(getResources().getColor(2131689765));
    this.vXf.setTextColor(getResources().getColor(2131690623));
    this.vXd.setBackgroundDrawable(getResources().getDrawable(2130840671));
    this.vXd.setScaleX(1.0F);
    this.vXd.setScaleY(1.0F);
    AppMethodBeat.o(156083);
  }
  
  private void doM()
  {
    AppMethodBeat.i(156084);
    this.vXh.setIconColor(getResources().getColor(2131689765));
    this.vXi.setTextColor(getResources().getColor(2131690623));
    this.vXg.setBackgroundDrawable(getResources().getDrawable(2130840671));
    this.vXg.setScaleX(1.0F);
    this.vXg.setScaleY(1.0F);
    AppMethodBeat.o(156084);
  }
  
  private void doN()
  {
    AppMethodBeat.i(155468);
    String str = aa.gP(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
    {
      this.vXb.setImageResource(2131232161);
      this.vXh.setImageResource(2131232163);
      AppMethodBeat.o(155468);
      return;
    }
    if (str == "en")
    {
      this.vXb.setImageResource(2131232162);
      this.vXh.setImageResource(2131232164);
    }
    AppMethodBeat.o(155468);
  }
  
  private void doi()
  {
    AppMethodBeat.i(27846);
    String str;
    if (this.vWO == null)
    {
      str = this.vVU;
      this.vVV = ((AppPanel)findViewById(2131822487));
      this.vVV.setOnSwitchPanelListener(this.vXw);
      this.vVV.setPortHeighPx(com.tencent.mm.sdk.platformtools.x.gL(getContext()));
      if ((!t.oD(str)) && (!t.ow(str))) {
        break label113;
      }
      this.vVV.init(0);
    }
    for (;;)
    {
      this.vWb = ((TextView)findViewById(2131822488));
      AppMethodBeat.o(27846);
      return;
      str = this.vWO.getTalkerUserName();
      break;
      label113:
      if (t.nU(str)) {
        this.vVV.init(4);
      } else if (t.lA(str)) {
        this.vVV.init(2);
      } else {
        this.vVV.init(1);
      }
    }
  }
  
  private void dok()
  {
    AppMethodBeat.i(155463);
    if (this.vWr)
    {
      this.mwR.setVisibility(8);
      this.mwS.setVisibility(8);
      this.tdt.setVisibility(8);
      this.mwP.setVisibility(8);
      this.vWS.setVisibility(0);
      this.vWV.setVisibility(0);
      this.vWW.setVisibility(0);
      this.vWY.setVisibility(8);
      this.vWZ.setVisibility(0);
      this.vXa.setVisibility(8);
      this.vXc.setVisibility(8);
      this.vXd.setVisibility(8);
      this.vXg.setVisibility(8);
      this.vXs = ChatFooter.h.vYo;
      this.vXq = ChatFooter.i.vYs;
      AppMethodBeat.o(155463);
      return;
    }
    this.mwR.setVisibility(0);
    this.mwS.setVisibility(8);
    this.tdt.setVisibility(8);
    this.mwP.setVisibility(8);
    this.vWS.setVisibility(8);
    AppMethodBeat.o(155463);
  }
  
  private void dox()
  {
    AppMethodBeat.i(27884);
    this.gcq.findViewById(2131822482).setVisibility(0);
    AppMethodBeat.o(27884);
  }
  
  private void doy()
  {
    AppMethodBeat.i(27885);
    ab.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
    this.vWt = false;
    this.oxm.setImeOptions(0);
    this.oxm.setInputType(this.oxm.getInputType() | 0x40);
    AppMethodBeat.o(27885);
  }
  
  private void g(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(153721);
    doE();
    if (this.vWy != null) {
      if ((this.vWF) && (this.vWw == 1)) {
        this.vWy.h(0, false, paramInt2);
      }
    }
    for (;;)
    {
      this.vWB = -1;
      AppMethodBeat.o(153721);
      return;
      this.vWy.h(paramInt1, paramBoolean, paramInt2);
      continue;
      if ((this.vWw == 0) || (this.vWw == 1)) {
        this.vWa.setVisibility(8);
      }
      ab.e("MicroMsg.ChatFooter", "scrollParent: scrollParent is not ChattingScrollLayout");
    }
  }
  
  private void jf(boolean paramBoolean)
  {
    AppMethodBeat.i(27836);
    this.sMp = paramBoolean;
    if (this.vWP == null)
    {
      this.vWP = AnimationUtils.loadAnimation(getContext(), 2131034217);
      this.vWP.setDuration(150L);
    }
    if (this.vWQ == null)
    {
      this.vWQ = AnimationUtils.loadAnimation(getContext(), 2131034222);
      this.vWQ.setDuration(150L);
    }
    if ((this.oxn == null) || (this.vWc == null))
    {
      ab.i("MicroMsg.ChatFooter", "canSend:%B, return sendBtn == null || mAttachButton == null", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(27836);
      return;
    }
    if (this.vWM)
    {
      if (this.vWc.getVisibility() != 0) {
        this.vWc.setVisibility(0);
      }
      AppMethodBeat.o(27836);
      return;
    }
    if ((this.oxn.getVisibility() == 0) && (paramBoolean))
    {
      ab.i("MicroMsg.ChatFooter", "canSend true ! sendBtn is visible");
      AppMethodBeat.o(27836);
      return;
    }
    if ((this.vWc.getVisibility() == 0) && (!paramBoolean))
    {
      ab.i("MicroMsg.ChatFooter", "canSend false ! AttachButton is visible");
      AppMethodBeat.o(27836);
      return;
    }
    if (paramBoolean)
    {
      doJ();
      this.vWc.startAnimation(this.vWQ);
      this.vWc.setVisibility(8);
    }
    for (;;)
    {
      ab.i("MicroMsg.ChatFooter", "jacks canSend:%B", new Object[] { Boolean.valueOf(paramBoolean) });
      this.oxn.getParent().requestLayout();
      AppMethodBeat.o(27836);
      return;
      this.vWc.startAnimation(this.vWP);
      if (!this.vWm) {
        this.vWc.setVisibility(0);
      }
      doI();
    }
  }
  
  private void pt(boolean paramBoolean)
  {
    AppMethodBeat.i(27913);
    if (this.vWd == null)
    {
      AppMethodBeat.o(27913);
      return;
    }
    if ((this.vXE) && (paramBoolean))
    {
      AppMethodBeat.o(27913);
      return;
    }
    if ((!this.vXE) && (!paramBoolean))
    {
      AppMethodBeat.o(27913);
      return;
    }
    this.vXE = paramBoolean;
    if (paramBoolean)
    {
      this.vWd.setImageDrawable(getContext().getResources().getDrawable(2130838350));
      AppMethodBeat.o(27913);
      return;
    }
    this.vWd.setImageDrawable(getContext().getResources().getDrawable(2130838345));
    AppMethodBeat.o(27913);
  }
  
  private void setGrayBgFullScreen(View paramView)
  {
    AppMethodBeat.i(155462);
    paramView.setSystemUiVisibility(5894);
    AppMethodBeat.o(155462);
  }
  
  public final void Az()
  {
    AppMethodBeat.i(27843);
    this.vWu = true;
    if (this.eys != null) {
      this.eys.Az();
    }
    AppMethodBeat.o(27843);
  }
  
  public final void Mi(int paramInt)
  {
    AppMethodBeat.i(27862);
    this.vXy = 0;
    int i;
    int j;
    label52:
    Object localObject;
    if (this.vWr)
    {
      i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 280);
      j = BackwardSupportUtil.b.b(getContext(), 50.0F);
      if (paramInt + j >= i) {
        break label1138;
      }
      this.vXy = -1;
      if (this.tdq == null)
      {
        this.tdq = new o(View.inflate(getContext(), 2130971099, null), -1, -2);
        this.vWn = ((ViewGroup)this.tdq.getContentView().findViewById(2131824071));
        this.mwR = this.tdq.getContentView().findViewById(2131824072);
        this.mwQ = ((ImageView)this.tdq.getContentView().findViewById(2131828776));
        this.vWo = ((TextView)this.tdq.getContentView().findViewById(2131828777));
        this.vWo.setTextSize(0, com.tencent.mm.cb.a.ap(getContext(), 2131428639) * com.tencent.mm.cb.a.gr(getContext()));
        this.mwS = this.tdq.getContentView().findViewById(2131824076);
        this.tdr = ((TextView)this.tdq.getContentView().findViewById(2131824078));
        this.tdr.setTextSize(0, com.tencent.mm.cb.a.ap(getContext(), 2131428639) * com.tencent.mm.cb.a.gr(getContext()));
        this.tds = ((ImageView)this.tdq.getContentView().findViewById(2131824077));
        this.tdt = this.tdq.getContentView().findViewById(2131828796);
        this.mwP = this.tdq.getContentView().findViewById(2131824079);
        this.vWS = ((ViewGroup)this.tdq.getContentView().findViewById(2131828778));
        this.vWT = this.tdq.getContentView().findViewById(2131828786);
        this.vWW = this.tdq.getContentView().findViewById(2131828788);
        this.vWX = ((ImageView)this.tdq.getContentView().findViewById(2131828790));
        this.vWY = ((ImageView)this.tdq.getContentView().findViewById(2131828791));
        this.vWZ = this.tdq.getContentView().findViewById(2131828793);
        this.vXa = ((TextView)this.tdq.getContentView().findViewById(2131828792));
        this.vXb = ((ImageView)this.tdq.getContentView().findViewById(2131828795));
        this.vXc = this.tdq.getContentView().findViewById(2131828779);
        this.vXd = this.tdq.getContentView().findViewById(2131828780);
        this.vXe = ((WeImageView)this.tdq.getContentView().findViewById(2131828781));
        this.vXf = ((TextView)this.tdq.getContentView().findViewById(2131828782));
        this.vXg = this.tdq.getContentView().findViewById(2131828783);
        this.vXh = ((WeImageView)this.tdq.getContentView().findViewById(2131828784));
        this.vXi = ((TextView)this.tdq.getContentView().findViewById(2131828785));
        this.vXj = View.inflate(getContext(), 2130969846, null);
        localObject = this.activity.getWindow().getDecorView();
        Drawable localDrawable = ((View)localObject).getBackground();
        this.vWU = new BlurView(getContext());
        paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 14);
        BlurView localBlurView = this.vWU.t((ViewGroup)localObject).Pd(getResources().getColor(2131690619)).x(localDrawable).b(new com.tencent.mm.ui.blur.e(getContext())).bx(15.0F).dFn();
        localBlurView.kq = (paramInt * 1.0F);
        localBlurView.zuU = true;
        localBlurView.Pe(this.vXy).dFo();
        this.vXk = new BlurView(getContext());
        this.vXk.Pd(getResources().getColor(2131690619));
        this.vXk.t((ViewGroup)localObject).x(localDrawable).b(new com.tencent.mm.ui.blur.e(getContext())).bx(15.0F).dFn().dFo();
        ab.i("MicroMsg.ChatFooter", "transVoiceBlurMode: %s.", new Object[] { this.vXr });
        switch (ChatFooter.44.vYa[this.vXr.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      this.vXo.setClippingEnabled(false);
      setGrayBgFullScreen(this.vXo.getContentView());
      this.vXo.getContentView().setAlpha(0.0F);
      this.vXo.setOnDismissListener(new ChatFooter.19(this));
      ((TextView)this.tdq.getContentView().findViewById(2131828794)).setTextSize(0, com.tencent.mm.cb.a.ap(getContext(), 2131428792) * com.tencent.mm.cb.a.gr(getContext()));
      dok();
      if (this.vXy != -1)
      {
        this.mwP.setVisibility(8);
        this.vWn.setVisibility(8);
        this.tdt.setVisibility(0);
        new ak().post(new ChatFooter.20(this));
        if (this.vWr)
        {
          doN();
          this.vXu = false;
          doK();
          this.vXo.showAtLocation(this, 49, 0, 0);
          this.vXt = false;
          if (this.vXJ)
          {
            this.vXJ = false;
            if (ChatFooter.g.vYl == this.vXr) {
              this.vWU.Pd(getResources().getColor(2131690619)).x(this.activity.getWindow().getDecorView().getBackground()).qQ(true);
            }
          }
        }
        this.tdq.showAtLocation(this, 49, 0, this.vXy);
      }
      AppMethodBeat.o(27862);
      return;
      i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 180);
      break;
      label1138:
      this.vXy = ((paramInt - i) / 2 + j);
      break label52;
      this.vWS.removeView(this.vWT);
      localObject = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(2131428788), getResources().getDimensionPixelSize(2131428788));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      this.vWU.addView(this.vWT, (ViewGroup.LayoutParams)localObject);
      this.vWS.addView(this.vWU, (ViewGroup.LayoutParams)localObject);
      this.vWV = this.vWU;
      localObject = new FrameLayout.LayoutParams(-1, -1);
      this.vXk.addView(this.vXj, (ViewGroup.LayoutParams)localObject);
      this.vXo = new o(this.vXk, -1, -1);
      continue;
      this.vWV = this.vWT;
      this.vWV.setBackgroundResource(2130840670);
      this.vXj.setBackgroundColor(Color.parseColor("#3A000000"));
      this.vXo = new o(this.vXj, -1, -1);
    }
  }
  
  public final void Mj(int paramInt)
  {
    AppMethodBeat.i(27866);
    if (this.vWr)
    {
      i = 0;
      for (;;)
      {
        if (i < vXB.length)
        {
          if ((paramInt >= vXA[i]) && (paramInt < vXA[(i + 1)])) {
            this.vWX.setBackgroundDrawable(com.tencent.mm.cb.a.k(getContext(), vXB[i]));
          }
        }
        else
        {
          if ((paramInt != -1) || (this.tdq == null)) {
            break;
          }
          this.tdq.dismiss();
          this.tdt.setVisibility(0);
          this.vWn.setVisibility(8);
          this.mwP.setVisibility(8);
          AppMethodBeat.o(27866);
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < vXB.length)
      {
        if ((paramInt >= vXA[i]) && (paramInt < vXA[(i + 1)])) {
          this.mwQ.setBackgroundDrawable(com.tencent.mm.cb.a.k(getContext(), vXB[i]));
        }
      }
      else
      {
        if ((paramInt == -1) && (this.tdq != null))
        {
          this.tdq.dismiss();
          this.tdt.setVisibility(0);
          this.vWn.setVisibility(8);
          this.mwP.setVisibility(8);
        }
        AppMethodBeat.o(27866);
        return;
      }
      i += 1;
    }
  }
  
  public final void Mk(int paramInt)
  {
    AppMethodBeat.i(27868);
    this.vWq = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27868);
      return;
      this.vWe.setVisibility(0);
      this.vVX.setVisibility(8);
      Mh(2130838351);
      AppMethodBeat.o(27868);
      return;
      this.vWe.setVisibility(8);
      this.vVX.setVisibility(0);
      Mh(2130838350);
      if ((r.ZU().booleanValue()) && (this.vWJ != null))
      {
        ChatFooter.c localc = this.vWJ;
        Boolean localBoolean = Boolean.TRUE;
        localc.b(localBoolean, localBoolean);
      }
    }
  }
  
  public final void a(Context paramContext, Activity paramActivity)
  {
    AppMethodBeat.i(27831);
    ab.i("MicroMsg.ChatFooter", "onResume: ");
    this.activity = paramActivity;
    if ((this.vWA == 48) && (this.vWw == 1))
    {
      this.vWC = false;
      aC(0, false);
    }
    doF();
    doH();
    if (am.dlO().vMk) {
      am.dlO().fS(ah.getContext());
    }
    if ((!this.vWa.doR()) && (this.eys != null)) {
      this.eys.onResume();
    }
    if ((!this.vWM) && (this.vWt)) {
      doy();
    }
    for (;;)
    {
      if (com.tencent.mm.sdk.platformtools.x.gN(paramContext) != this.vWv) {
        dnV();
      }
      Ml(getKeyBordHeightPX());
      if (this.vVV != null) {
        this.vVV.context = paramContext;
      }
      this.vWg.vYQ = false;
      if (!this.vSg) {
        dox();
      }
      dog();
      post(new ChatFooter.22(this));
      com.tencent.mm.sdk.b.a.ymk.c(this.vXC);
      AppMethodBeat.o(27831);
      return;
      if ((this.vWM) && (!this.vWt)) {
        dow();
      }
    }
  }
  
  public final void aA(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(27869);
    Mk(paramInt);
    switch (paramInt)
    {
    default: 
      setVisibility(0);
      AppMethodBeat.o(27869);
      return;
    case 1: 
      if (paramBoolean)
      {
        pr(true);
        showVKB();
        if (this.oxm.length() > 0) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          jf(paramBoolean);
          AppMethodBeat.o(27869);
          return;
        }
      }
      if (this.oxm.length() > 0) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        jf(paramBoolean);
        AppMethodBeat.o(27869);
        return;
      }
    }
    aB(0, true);
    jf(false);
    AppMethodBeat.o(27869);
  }
  
  public final void aA(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(27852);
    if (this.vWk.vYg.containsKey(paramString1)) {}
    Object localObject;
    for (paramString1 = (LinkedList)this.vWk.vYg.get(paramString1);; paramString1 = (String)localObject)
    {
      localObject = new HashMap(1);
      ((HashMap)localObject).put(paramString3, paramString2);
      paramString1.add(localObject);
      AppMethodBeat.o(27852);
      return;
      localObject = new LinkedList();
      this.vWk.vYg.put(paramString1, localObject);
    }
  }
  
  public final void aB(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(153722);
    ab.i("MicroMsg.ChatFooter", "configPanel: %s, %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.vWC) });
    int i;
    int j;
    label77:
    int k;
    if ((this.vWD) || (!this.vWv))
    {
      i = 1;
      if ((paramInt != 1) || (this.vWC)) {
        break label169;
      }
      j = 1;
      if ((paramInt == 1) || (!this.vWC)) {
        break label175;
      }
      k = 1;
      label92:
      if ((i == 0) && ((j != 0) || (k != 0))) {
        break label181;
      }
      aC(paramInt, paramBoolean);
      label112:
      if (j != 0) {
        post(new ChatFooter.29(this));
      }
      if (k != 0) {
        hideVKB();
      }
      if (i != 0) {
        if (paramInt != 1) {
          break label189;
        }
      }
    }
    label169:
    label175:
    label181:
    label189:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.vWC = paramBoolean;
      AppMethodBeat.o(153722);
      return;
      i = 0;
      break;
      j = 0;
      break label77;
      k = 0;
      break label92;
      this.vWx = paramInt;
      break label112;
    }
  }
  
  public final void ad(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(27876);
    this.vVV.ph(paramBoolean1);
    this.vVV.pi(paramBoolean2);
    AppMethodBeat.o(27876);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(27861);
    this.vXx = new ChatFooter.f(this, paramTextWatcher);
    this.oxm.addTextChangedListener(this.vXx);
    AppMethodBeat.o(27861);
  }
  
  public final void bxy()
  {
    AppMethodBeat.i(27865);
    post(new ChatFooter.21(this));
    AppMethodBeat.o(27865);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(27834);
    if (this.eys != null)
    {
      ab.i("MicroMsg.ChatFooter", "jacks chat footer desctory smiley panel");
      this.eys.Ay();
      this.eys.destroy();
      this.eys.animate().cancel();
      this.eys = null;
    }
    if (this.vSd != null)
    {
      this.vSd.destroy();
      this.vSd = null;
      this.vSg = false;
    }
    if (this.vWi != null) {
      this.vWi.release();
    }
    if (this.vWh != null)
    {
      this.vWh.vWL = null;
      this.vWh.vZc = null;
      this.vWh.hide();
    }
    if (this.tdq != null)
    {
      if (this.vWU != null) {
        this.vWU.getBlurController().destroy();
      }
      if (this.vXk != null) {
        this.vXk.getBlurController().destroy();
      }
    }
    ab.d("MicroMsg.ChatFooter", "jacks destroy");
    AppMethodBeat.o(27834);
  }
  
  public final void dhO()
  {
    AppMethodBeat.i(27857);
    this.vXp.GV(1);
    this.vVX.setEnabled(false);
    this.vVX.setBackgroundDrawable(com.tencent.mm.cb.a.k(getContext(), 2130840128));
    if (this.tdq != null)
    {
      this.mwP.setVisibility(0);
      this.vWn.setVisibility(8);
      this.tdt.setVisibility(8);
      this.tdq.update();
      this.vXo.dismiss();
    }
    this.mwX.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(27857);
  }
  
  public final void dnV()
  {
    boolean bool = true;
    AppMethodBeat.i(27888);
    ab.i("MicroMsg.ChatFooter", "[dealOrientationChange]");
    if (getContext().getResources().getConfiguration().orientation == 1) {}
    for (;;)
    {
      this.vWv = bool;
      doz();
      aB(0, false);
      AppMethodBeat.o(27888);
      return;
      bool = false;
    }
  }
  
  public final void dnr()
  {
    AppMethodBeat.i(27851);
    if (!this.vSg)
    {
      AppMethodBeat.o(27851);
      return;
    }
    this.vSg = false;
    if (this.vSd != null)
    {
      int i = getKeyBordHeightPX();
      int j = this.vVZ.getHeight();
      this.vSd.animate().cancel();
      this.vSd.animate().translationY(i + j).withEndAction(new ChatFooter.17(this)).start();
    }
    this.oxm.setText("");
    AppMethodBeat.o(27851);
  }
  
  public final boolean doA()
  {
    AppMethodBeat.i(27891);
    if ((this.vWN == null) || (this.vWN.getView() == null))
    {
      AppMethodBeat.o(27891);
      return false;
    }
    Object localObject = this.vWN.getView().findViewById(2131826124);
    if (localObject == null)
    {
      AppMethodBeat.o(27891);
      return false;
    }
    Rect localRect = new Rect();
    ((View)localObject).getGlobalVisibleRect(localRect);
    if (com.tencent.mm.compatible.util.d.fv(28))
    {
      localObject = ((View)localObject).getRootWindowInsets().getDisplayCutout();
      if (localObject == null) {}
    }
    for (int i = ((DisplayCutout)localObject).getSafeInsetLeft();; i = 0)
    {
      if (localRect.left > i)
      {
        AppMethodBeat.o(27891);
        return true;
      }
      AppMethodBeat.o(27891);
      return false;
    }
  }
  
  public final boolean doB()
  {
    AppMethodBeat.i(27892);
    if (this.vWw != 0)
    {
      AppMethodBeat.o(27892);
      return true;
    }
    AppMethodBeat.o(27892);
    return false;
  }
  
  public final void doC()
  {
    AppMethodBeat.i(27900);
    ab.i("MicroMsg.ChatFooter", "withLastText: ");
    showVKB();
    pr(true);
    AppMethodBeat.o(27900);
  }
  
  public final void doD()
  {
    AppMethodBeat.i(153717);
    if ((this.vSd != null) && (this.vSd.isShown())) {
      this.vSd.doX();
    }
    AppMethodBeat.o(153717);
  }
  
  public final void doG()
  {
    AppMethodBeat.i(27916);
    this.mwK = false;
    this.vVX.setBackgroundDrawable(com.tencent.mm.cb.a.k(getContext(), 2130840961));
    this.vVX.setText(2131298127);
    if (this.vWi != null)
    {
      this.vXp.tpq = this.vWi.EN();
      if (this.vWr)
      {
        if ((this.tdq != null) && (this.tdq.isShowing()) && (ChatFooter.h.vYo != this.vXs))
        {
          this.vXJ = true;
          if (ChatFooter.h.vYq == this.vXs)
          {
            ab.d("MicroMsg.ChatFooter", "do not send voice.");
            this.vXp.GV(2);
            this.vWi.bPh();
            AppMethodBeat.o(27916);
            return;
          }
          ab.d("MicroMsg.ChatFooter", "trans voice to txt.");
          this.vWi.bPf();
          Object localObject1 = this.vWi.getFileName();
          long l = this.vWi.EN();
          ab.d("transvoice", "fileName: %s, voiceLen: %d.", new Object[] { localObject1, Long.valueOf(l) });
          if (at.isConnected(getContext()))
          {
            localObject2 = this.vXn;
            int i;
            Object localObject3;
            if ((((com.tencent.mm.modelvoiceaddr.h)localObject2).gbQ == null) || (((com.tencent.mm.modelvoiceaddr.h)localObject2).gbQ.isEmpty()))
            {
              i = 0;
              if (i == 0) {
                break label643;
              }
              localObject2 = this.vXl;
              if (!bo.isNullOrNil((String)localObject1))
              {
                ((com.tencent.mm.plugin.transvoice.ui.b)localObject2).tqh = ((String)localObject1);
                localObject2 = com.tencent.mm.cj.a.yTb;
                if (localObject1 == null) {
                  a.f.b.j.ebi();
                }
                a.f.b.j.q(localObject1, "<set-?>");
                com.tencent.mm.cj.a.ati((String)localObject1);
              }
              this.vXl.tqg = l;
              this.vXl.talker = this.vVU;
              this.vXl.show();
              localObject1 = this.vXl;
              localObject2 = this.vXn;
              a.f.b.j.q(localObject2, "container");
              localObject3 = ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).getWindow();
              if (localObject3 != null) {
                ((Window)localObject3).setDimAmount(0.5F);
              }
              localObject3 = ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).tpN;
              if (localObject3 != null) {
                ((MMBottomSheetBehavior)localObject3).bC();
              }
              ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).tpU = false;
              ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).mxI = false;
              i = ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).tqp.getInt(((com.tencent.mm.plugin.transvoice.ui.b)localObject1).talker, 0);
              if (i != 0) {
                break label619;
              }
              localObject3 = aa.gP(((com.tencent.mm.plugin.transvoice.ui.b)localObject1).getContext());
              if ((!a.f.b.j.e(localObject3, "zh_CN")) && (!a.f.b.j.e(localObject3, "zh_HK")) && (!a.f.b.j.e(localObject3, "zh_TW"))) {
                break label599;
              }
              ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).gbb = 1;
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).tpS.tps = ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).gbb;
              ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).cLb();
              localObject3 = ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).tqo;
              if (localObject3 != null) {
                ((ak)localObject3).sendEmptyMessageDelayed(5000, 5000L);
              }
              localObject3 = ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).tql;
              if (localObject3 != null) {
                ((ap)localObject3).ag(500L, 500L);
              }
              ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).gaW = ((com.tencent.mm.modelvoiceaddr.h)localObject2);
              ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).tqe = new com.tencent.mm.plugin.transvoice.a.b((com.tencent.mm.modelvoiceaddr.h)localObject2, ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).gbb, (g.b)new b.x((com.tencent.mm.plugin.transvoice.ui.b)localObject1));
              localObject1 = ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).tqe;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.transvoice.a.b)localObject1).start();
              }
              this.vWE = false;
              AppMethodBeat.o(27916);
              return;
              i = 1;
              break;
              label599:
              if (a.f.b.j.e(localObject3, "en"))
              {
                ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).gbb = 4;
                continue;
                label619:
                if ((1 == i) || (2 == i) || (4 == i)) {
                  ((com.tencent.mm.plugin.transvoice.ui.b)localObject1).gbb = i;
                }
              }
            }
            label643:
            this.vXp.GV(3);
            localObject2 = new c.a(getContext());
            ((c.a)localObject2).avn(getResources().getString(2131306252));
            ((c.a)localObject2).avs(getResources().getString(2131306253));
            ((c.a)localObject2).Rk(getResources().getColor(2131689571));
            ((c.a)localObject2).a(new ChatFooter.34(this, (String)localObject1));
            ((c.a)localObject2).rG(false);
            ((c.a)localObject2).aLZ().show();
            AppMethodBeat.o(27916);
            return;
          }
          this.vXp.GV(4);
          Object localObject2 = new c.a(getContext());
          ((c.a)localObject2).avn(getResources().getString(2131306196));
          ((c.a)localObject2).avs(getResources().getString(2131306198));
          ((c.a)localObject2).Rk(getResources().getColor(2131689571));
          ((c.a)localObject2).avt(getResources().getString(2131306197));
          ((c.a)localObject2).a(new ChatFooter.35(this, (String)localObject1, l));
          ((c.a)localObject2).b(new ChatFooter.36(this, (String)localObject1));
          ((c.a)localObject2).aLZ().show();
          AppMethodBeat.o(27916);
          return;
        }
        this.vWi.bPe();
        AppMethodBeat.o(27916);
        return;
      }
      if ((this.mwS != null) && (this.mwS.getVisibility() == 0))
      {
        this.vXp.GV(2);
        this.vWi.bPh();
        AppMethodBeat.o(27916);
        return;
      }
      this.vWi.bPe();
    }
    AppMethodBeat.o(27916);
  }
  
  public final void doH()
  {
    AppMethodBeat.i(27919);
    aw.aaz();
    this.vWM = ((Boolean)com.tencent.mm.model.c.Ru().get(66832, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(27919);
  }
  
  public final void doI()
  {
    AppMethodBeat.i(153726);
    if ((this.oxn == null) || (this.oxn.getVisibility() == 8))
    {
      AppMethodBeat.o(153726);
      return;
    }
    if (this.vXM == 0)
    {
      this.vXM = this.oxn.getWidth();
      this.vXN = this.vWc.getWidth();
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.vXM, this.vXN });
    localValueAnimator.addUpdateListener(new ChatFooter.37(this));
    localValueAnimator.addListener(new ChatFooter.38(this));
    localValueAnimator.setDuration(150L);
    localValueAnimator.start();
    AppMethodBeat.o(153726);
  }
  
  public final void doJ()
  {
    AppMethodBeat.i(153727);
    if (this.oxn == null)
    {
      AppMethodBeat.o(153727);
      return;
    }
    if (this.vXM == 0)
    {
      this.vXM = this.oxn.getWidth();
      this.vXN = this.vWc.getWidth();
    }
    if (this.vXM == 0)
    {
      this.oxn.startAnimation(this.vWP);
      this.oxn.setVisibility(0);
      AppMethodBeat.o(153727);
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.vXN, this.vXM });
    localValueAnimator.addUpdateListener(new ChatFooter.39(this));
    localValueAnimator.setDuration(150L);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(156077);
        ChatFooter.h(ChatFooter.this).setVisibility(0);
        ChatFooter.ay(ChatFooter.this).setVisibility(8);
        AppMethodBeat.o(156077);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(155450);
        paramAnonymousAnimator = ChatFooter.h(ChatFooter.this).getLayoutParams();
        paramAnonymousAnimator.width = -2;
        ChatFooter.h(ChatFooter.this).setLayoutParams(paramAnonymousAnimator);
        ChatFooter.ay(ChatFooter.this).setVisibility(8);
        if (!ChatFooter.ax(ChatFooter.this))
        {
          ab.i("MicroMsg.ChatFooter", "animShowSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.ax(ChatFooter.this)) });
          ChatFooter.ay(ChatFooter.this).setVisibility(0);
          ChatFooter.this.doI();
        }
        AppMethodBeat.o(155450);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(156076);
        ChatFooter.h(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(156076);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(153727);
  }
  
  public final void dod()
  {
    AppMethodBeat.i(27829);
    if (this.vWI != null)
    {
      com.tencent.mm.g.b.a.b localb = this.vWI;
      localb.cOm = 0L;
      localb.cOk = 0L;
      localb.cOl = 0L;
      localb.cOn = 0L;
      localb.aI(0L).aJ(0L);
    }
    AppMethodBeat.o(27829);
  }
  
  public final void doe()
  {
    AppMethodBeat.i(27835);
    if (this.vVV == null)
    {
      AppMethodBeat.o(27835);
      return;
    }
    this.vVV.dnL();
    AppMethodBeat.o(27835);
  }
  
  public final void dof()
  {
    AppMethodBeat.i(27838);
    if (this.vWi != null) {
      this.vWi.bPk();
    }
    ab.i("MicroMsg.ChatFooter", "click attach btn: %s, %s", new Object[] { Integer.valueOf(this.vVV.getVisibility()), Boolean.valueOf(this.vWa.doR()) });
    if (this.vWw == 3)
    {
      if (this.vWq == 1)
      {
        showVKB();
        AppMethodBeat.o(27838);
        return;
      }
      aB(0, true);
      AppMethodBeat.o(27838);
      return;
    }
    aB(3, true);
    if ((this.vSd != null) && (this.vSd.getVisibility() == 0) && (this.vSg))
    {
      ab.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
      this.vSd.setVisibility(8);
      this.vSg = false;
      this.vSd.reset();
    }
    Object localObject = am.dlO();
    Context localContext = ah.getContext();
    if ((!com.tencent.mm.kernel.g.RG()) || (localContext == null)) {}
    for (;;)
    {
      am.dlO().fS(ah.getContext());
      AppMethodBeat.o(27838);
      return;
      try
      {
        String str = com.tencent.mm.m.g.Nq().getValue("ShowAPPSuggestion");
        if ((bo.isNullOrNil(str)) || (Integer.valueOf(str).intValue() != 1)) {
          ab.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[] { str });
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[] { localException.getMessage() });
        if (((am)localObject).vMe)
        {
          ab.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
        }
        else
        {
          ab.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
          ((am)localObject).vMe = true;
          if (System.currentTimeMillis() - ((am)localObject).vMh < 43200000L)
          {
            ab.d("MicroMsg.SuggestionAppListLogic", "not now");
            ((am)localObject).vMe = false;
          }
          else
          {
            com.tencent.mm.kernel.g.RM();
            ((am)localObject).vMh = com.tencent.mm.kernel.g.RL().Ru().Ns(352275);
            if (System.currentTimeMillis() - ((am)localObject).vMh < 43200000L)
            {
              ab.w("MicroMsg.SuggestionAppListLogic", "not now sp");
              ((am)localObject).vMe = false;
            }
            else
            {
              if (((am)localObject).lang == null) {
                ((am)localObject).lang = aa.f(localContext.getSharedPreferences(ah.dsP(), 0));
              }
              localObject = new com.tencent.mm.pluginsdk.model.app.ad(((am)localObject).lang, new LinkedList());
              com.tencent.mm.plugin.s.a.caf();
              com.tencent.mm.pluginsdk.model.app.d.a(4, (com.tencent.mm.pluginsdk.model.app.x)localObject);
            }
          }
        }
      }
    }
  }
  
  public final void dog()
  {
    AppMethodBeat.i(27839);
    this.vWd = ((ImageButton)this.gcq.findViewById(2131822480));
    this.vWd.setVisibility(0);
    if (!com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yKq, true)) {
      this.gcq.findViewById(2131822481).setVisibility(0);
    }
    for (;;)
    {
      this.gcq.findViewById(2131822481).setVisibility(8);
      this.vWd.setOnClickListener(new ChatFooter.7(this));
      if (this.vWh != null) {
        this.vWh.vZb = this.vWd;
      }
      AppMethodBeat.o(27839);
      return;
      this.gcq.findViewById(2131822481).setVisibility(8);
    }
  }
  
  public final void doh()
  {
    boolean bool = true;
    AppMethodBeat.i(27841);
    if ((e.vYI == null) || (getContext() == null))
    {
      if (getContext() == null)
      {
        ab.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", new Object[] { bo.dtY() });
        this.eys = new d(ah.getContext());
        AppMethodBeat.o(27841);
        return;
      }
      this.eys = new d(getContext());
      AppMethodBeat.o(27841);
      return;
    }
    if (this.eys != null) {
      this.eys.destroy();
    }
    this.eys = e.vYI.dK(getContext());
    ChatFooterPanel localChatFooterPanel;
    if (this.eys != null)
    {
      this.eys.setEntranceScene(ChatFooterPanel.vQm);
      this.eys.setVisibility(8);
      this.eys.setFooterType(this.uKC);
      if (this.vWa != null) {
        this.vWa.addView(this.eys, -1, -1);
      }
      this.eys.setOnTextOperationListener(this.vXv);
      localChatFooterPanel = this.eys;
      if (this.oxm.getText().length() <= 0) {
        break label310;
      }
    }
    for (;;)
    {
      localChatFooterPanel.setSendButtonEnable(bool);
      if (this.vWO != null) {
        this.eys.setTalkerName(this.vWO.getTalkerUserName());
      }
      this.eys.setPortHeightPx(getKeyBordHeightPX());
      this.eys.AD();
      if (!bo.isNullOrNil(this.oxm.getText().toString())) {
        this.eys.AC();
      }
      this.eys.onResume();
      if (this.vWu) {
        Az();
      }
      setSmileyPanelCallback(this.vQk);
      AppMethodBeat.o(27841);
      return;
      label310:
      bool = false;
    }
  }
  
  public final void doj()
  {
    AppMethodBeat.i(27849);
    this.vWq = 1;
    this.vWe.setVisibility(0);
    this.vVX.setVisibility(8);
    Mh(2130838351);
    if (this.vSd != null)
    {
      this.vSd.setVisibility(8);
      this.vSg = false;
      this.vSd.reset();
    }
    aB(2, true);
    AppMethodBeat.o(27849);
  }
  
  public final void dol()
  {
    AppMethodBeat.i(27864);
    this.tdt.setVisibility(8);
    this.vWn.setVisibility(0);
    AppMethodBeat.o(27864);
  }
  
  public final void dom()
  {
    AppMethodBeat.i(27870);
    this.vWe.setVisibility(0);
    this.vVY.setVisibility(8);
    this.vVX.setVisibility(8);
    AppMethodBeat.o(27870);
  }
  
  public final void don()
  {
    AppMethodBeat.i(27871);
    if (this.vVY != null) {
      this.vVY.setVisibility(0);
    }
    AppMethodBeat.o(27871);
  }
  
  public final void doo()
  {
    AppMethodBeat.i(27872);
    AppPanel localAppPanel = this.vVV;
    localAppPanel.vUY.vVu.value = false;
    localAppPanel.dnT();
    AppMethodBeat.o(27872);
  }
  
  public final void dop()
  {
    AppMethodBeat.i(27873);
    AppPanel localAppPanel = this.vVV;
    localAppPanel.vUY.vVM.value = false;
    localAppPanel.dnT();
    AppMethodBeat.o(27873);
  }
  
  public final void doq()
  {
    AppMethodBeat.i(27874);
    AppPanel localAppPanel = this.vVV;
    localAppPanel.vUY.vVv.value = false;
    localAppPanel.dnT();
    AppMethodBeat.o(27874);
  }
  
  public final void dor()
  {
    AppMethodBeat.i(27875);
    AppPanel localAppPanel = this.vVV;
    localAppPanel.vUY.vVy.value = false;
    localAppPanel.dnT();
    AppMethodBeat.o(27875);
  }
  
  public final void dos()
  {
    AppMethodBeat.i(27879);
    AppPanel localAppPanel = this.vVV;
    localAppPanel.vVg = true;
    localAppPanel.vUY.pp(false);
    localAppPanel.dnT();
    ab.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", new Object[] { bo.dtY().toString() });
    AppMethodBeat.o(27879);
  }
  
  public final void dot()
  {
    AppMethodBeat.i(27880);
    AppPanel localAppPanel = this.vVV;
    localAppPanel.vVh = true;
    localAppPanel.vUY.pm(false);
    localAppPanel.dnT();
    ab.i("MicroMsg.AppPanel", "disableServiceRemittance %s", new Object[] { bo.dtY().toString() });
    AppMethodBeat.o(27880);
  }
  
  public final void dou()
  {
    AppMethodBeat.i(27881);
    if (this.vWd != null) {
      this.vWd.setVisibility(8);
    }
    AppMethodBeat.o(27881);
  }
  
  public final void dov()
  {
    AppMethodBeat.i(27882);
    AppPanel localAppPanel = this.vVV;
    localAppPanel.vVi = true;
    localAppPanel.vUY.pq(false);
    localAppPanel.dnT();
    AppMethodBeat.o(27882);
  }
  
  public final void dow()
  {
    AppMethodBeat.i(27883);
    ab.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
    this.vWt = true;
    this.oxm.setImeOptions(4);
    this.oxm.setInputType(this.oxm.getInputType() & 0xFFFFFFBF);
    AppMethodBeat.o(27883);
  }
  
  public final void doz()
  {
    AppMethodBeat.i(27886);
    if ((!this.vWa.doR()) && (this.eys != null)) {
      this.eys.refresh();
    }
    AppMethodBeat.o(27886);
  }
  
  public String getAtSomebody()
  {
    return this.vWk.vYe;
  }
  
  public int getBarGroupHeight()
  {
    AppMethodBeat.i(27837);
    int i = findViewById(2131822472).getHeight();
    AppMethodBeat.o(27837);
    return i;
  }
  
  public f getCallback()
  {
    return this.vQk;
  }
  
  public char getCharAtCursor()
  {
    AppMethodBeat.i(27860);
    int i = getSelectionStart();
    if (i <= 0)
    {
      AppMethodBeat.o(27860);
      return 'x';
    }
    char c = getLastText().charAt(i - 1);
    AppMethodBeat.o(27860);
    return c;
  }
  
  public int getInsertPos()
  {
    return this.vWk.vYf;
  }
  
  public boolean getIsVoiceInputPanleShow()
  {
    return this.vSg;
  }
  
  public int getKeyBordHeightPX()
  {
    AppMethodBeat.i(27911);
    int i = com.tencent.mm.sdk.platformtools.x.gL(getContext());
    AppMethodBeat.o(27911);
    return i;
  }
  
  public String getLastContent()
  {
    return this.vWk.vYd;
  }
  
  public String getLastText()
  {
    AppMethodBeat.i(27858);
    if (this.oxm == null)
    {
      AppMethodBeat.o(27858);
      return "";
    }
    String str = this.oxm.getText().toString();
    AppMethodBeat.o(27858);
    return str;
  }
  
  public int getMode()
  {
    return this.vWq;
  }
  
  public View getPanel()
  {
    return this.vWa;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(27859);
    int i = this.oxm.getSelectionStart();
    AppMethodBeat.o(27859);
    return i;
  }
  
  public int getSmieyType()
  {
    return 0;
  }
  
  public boolean getTransVoiceOpener()
  {
    return this.vWr;
  }
  
  public int getYFromBottom()
  {
    AppMethodBeat.i(27921);
    if (this.vWw == 0)
    {
      i = getHeight();
      j = this.vWG;
      AppMethodBeat.o(27921);
      return i - j;
    }
    int i = getHeight();
    int j = this.vWG;
    int k = getKeyBordHeightPX();
    AppMethodBeat.o(27921);
    return i - j + k;
  }
  
  public final HashMap<String, String> hW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27853);
    long l = System.currentTimeMillis();
    if (bo.isNullOrNil(paramString2))
    {
      if (this.vWk.vYg.containsKey(paramString1)) {
        this.vWk.vYg.remove(paramString1);
      }
      AppMethodBeat.o(27853);
      return null;
    }
    if ((!this.vWk.vYg.containsKey(paramString1)) || (((LinkedList)this.vWk.vYg.get(paramString1)).size() <= 0))
    {
      AppMethodBeat.o(27853);
      return null;
    }
    Object localObject = new LinkedList();
    int j;
    for (int i = 0; i < paramString2.length(); i = j + 1)
    {
      i = paramString2.indexOf("@", i);
      if (i == -1) {
        break;
      }
      j = paramString2.indexOf(' ', i);
      if ((j == -1) || (j - i > 40)) {
        break;
      }
      ((List)localObject).add(paramString2.substring(i + 1, j));
    }
    ab.i("MicroMsg.ChatFooter", "after split @ :%s", new Object[] { localObject });
    if (((List)localObject).size() <= 0)
    {
      ((LinkedList)this.vWk.vYg.get(paramString1)).clear();
      AppMethodBeat.o(27853);
      return null;
    }
    paramString1 = (LinkedList)this.vWk.vYg.get(paramString1);
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      ab.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", new Object[] { Integer.valueOf(paramString1.size()) });
      paramString2 = new LinkedList();
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label371;
        }
        String str = (String)((Iterator)localObject).next();
        Iterator localIterator = paramString1.iterator();
        if (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          if (!localHashMap.containsKey(str)) {
            break;
          }
          paramString2.add(localHashMap.get(str));
        }
      }
      label371:
      localObject = new HashMap(1);
      ab.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", new Object[] { Integer.valueOf(paramString2.size()) });
      ((HashMap)localObject).put("atuserlist", "<![CDATA[" + bo.d(paramString2, ",") + "]]>");
      paramString1.clear();
      ab.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(27853);
      return localObject;
    }
    ab.w("MicroMsg.ChatFooter", "list is null or size 0");
    AppMethodBeat.o(27853);
    return null;
  }
  
  public final boolean hideVKB()
  {
    AppMethodBeat.i(27904);
    if (getKeyBordHeightPX() / 2 <= getBottom())
    {
      boolean bool = bo.hideVKB(this);
      AppMethodBeat.o(27904);
      return bool;
    }
    AppMethodBeat.o(27904);
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(153715);
    super.onAttachedToWindow();
    doF();
    doE();
    Ml(getKeyBordHeightPX());
    AppMethodBeat.o(153715);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(27889);
    super.onConfigurationChanged(paramConfiguration);
    if (com.tencent.mm.compatible.util.d.fv(24)) {
      setIsMultiWindow(((Activity)getContext()).isInMultiWindowMode());
    }
    doF();
    ab.i("MicroMsg.ChatFooter", "onConfigurationChanged: %s, %s, %s", new Object[] { paramConfiguration, Boolean.valueOf(this.vWv), Boolean.valueOf(this.vWD) });
    Ml(getKeyBordHeightPX());
    AppMethodBeat.o(27889);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(153716);
    super.onDetachedFromWindow();
    this.ehl.close();
    this.vWy = null;
    this.vWz = false;
    AppMethodBeat.o(153716);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27909);
    ab.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", new Object[] { Integer.valueOf(View.MeasureSpec.getSize(paramInt2)), Integer.valueOf(getMeasuredHeight()) });
    super.onMeasure(paramInt1, paramInt2);
    ab.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    AppMethodBeat.o(27909);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(27833);
    ab.i("MicroMsg.ChatFooter", "onPause: ");
    if ((this.vWA == 48) && (this.vWw == 1))
    {
      this.vWC = false;
      aC(0, true);
    }
    this.ehl.close();
    if (this.eys != null) {
      this.eys.onPause();
    }
    if ((this.vSg) && (this.vSd != null)) {
      this.vSd.pause();
    }
    if (this.vWi != null) {
      this.vWi.onPause();
    }
    if (this.vWh != null) {
      this.vWh.hide();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.vXC);
    if ((this.tdq != null) && (this.tdq.isShowing())) {
      this.tdq.dismiss();
    }
    AppMethodBeat.o(27833);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(27912);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ab.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(27912);
  }
  
  public final void pj(boolean paramBoolean)
  {
    AppMethodBeat.i(27877);
    this.vVV.pj(paramBoolean);
    AppMethodBeat.o(27877);
  }
  
  public final void pk(boolean paramBoolean)
  {
    AppMethodBeat.i(27878);
    this.vVV.pk(paramBoolean);
    AppMethodBeat.o(27878);
  }
  
  public final void pr(boolean paramBoolean)
  {
    AppMethodBeat.i(27840);
    ab.i("MicroMsg.ChatFooter", "pureForcusEdtChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.oxm });
    if (this.oxm == null)
    {
      AppMethodBeat.o(27840);
      return;
    }
    if (paramBoolean)
    {
      this.oxm.requestFocus();
      AppMethodBeat.o(27840);
      return;
    }
    this.oxm.clearFocus();
    AppMethodBeat.o(27840);
  }
  
  public final void ps(boolean paramBoolean)
  {
    AppMethodBeat.i(27901);
    ab.i("MicroMsg.ChatFooter", "withoutLastText: ");
    hideVKB();
    pr(paramBoolean);
    AppMethodBeat.o(27901);
  }
  
  public void setAppPanelListener(AppPanel.a parama)
  {
    AppMethodBeat.i(27896);
    this.vVV.setAppPanelListener(parama);
    AppMethodBeat.o(27896);
  }
  
  public void setAppPanelTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(27847);
    if ((this.vWb == null) || (this.vVV == null))
    {
      AppMethodBeat.o(27847);
      return;
    }
    this.vWb.setText(paramCharSequence);
    if (!bo.aa(paramCharSequence)) {
      if (this.vVV.getVisibility() != 0) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      setAppPanelTipVisible(bool);
      AppMethodBeat.o(27847);
      return;
    }
  }
  
  public void setAppPanelTipVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(27848);
    if (this.vWb == null)
    {
      AppMethodBeat.o(27848);
      return;
    }
    if (TextUtils.isEmpty(this.vWb.getText()))
    {
      this.vWb.setVisibility(8);
      AppMethodBeat.o(27848);
      return;
    }
    if (paramBoolean)
    {
      localObject = this.vWb.getContext();
      i = this.vWa.getHeight();
      int j = getKeyBordHeightPX();
      int k = com.tencent.mm.cb.a.fromDPToPix((Context)localObject, 32);
      localObject = this.vWb.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (i - j + k);
        this.vWb.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    Object localObject = this.vWb;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      AppMethodBeat.o(27848);
      return;
    }
  }
  
  public void setAppPanelVisible(int paramInt)
  {
    AppMethodBeat.i(27887);
    if (this.vVV != null) {
      this.vVV.setVisibility(paramInt);
    }
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      setAppPanelTipVisible(bool);
      AppMethodBeat.o(27887);
      return;
    }
  }
  
  public void setAtSomebody(String paramString)
  {
    this.vWk.vYe = paramString;
  }
  
  public void setBottomPanelVisibility(int paramInt)
  {
    AppMethodBeat.i(27890);
    if (paramInt == 0)
    {
      this.vWa.setVisibility(paramInt);
      AppMethodBeat.o(27890);
      return;
    }
    aB(0, true);
    AppMethodBeat.o(27890);
  }
  
  public void setCattingRootLayoutId(int paramInt)
  {
    this.vXL = null;
    this.vXK = paramInt;
  }
  
  public void setDefaultSmileyByDetail(String paramString)
  {
    AppMethodBeat.i(27850);
    if (!bo.isNullOrNil(paramString))
    {
      if (this.eys == null) {
        doh();
      }
      this.eys.setDefaultEmojiByDetail(paramString);
    }
    AppMethodBeat.o(27850);
  }
  
  @TargetApi(11)
  public void setEditTextOnDragListener(View.OnDragListener paramOnDragListener)
  {
    AppMethodBeat.i(27894);
    this.oxm.setOnDragListener(paramOnDragListener);
    AppMethodBeat.o(27894);
  }
  
  public void setFooterEventListener(b paramb)
  {
    this.vWi = paramb;
  }
  
  public void setFooterType(int paramInt)
  {
    AppMethodBeat.i(27832);
    this.uKC = paramInt;
    if (this.eys != null) {
      this.eys.setFooterType(paramInt);
    }
    AppMethodBeat.o(27832);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(27856);
    if (this.oxm != null) {
      this.oxm.setHint(paramString);
    }
    AppMethodBeat.o(27856);
  }
  
  public void setInsertPos(int paramInt)
  {
    this.vWk.vYf = paramInt;
  }
  
  public void setIsMultiWindow(boolean paramBoolean)
  {
    AppMethodBeat.i(155465);
    ab.i("MicroMsg.ChatFooter", "setIsMultiWindow: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vWD = paramBoolean;
    doF();
    AppMethodBeat.o(155465);
  }
  
  public void setLastContent(String paramString)
  {
    this.vWk.vYd = paramString;
  }
  
  public void setLastText(String paramString)
  {
    AppMethodBeat.i(27854);
    u(paramString, -1, true);
    AppMethodBeat.o(27854);
  }
  
  public void setLbsMode(boolean paramBoolean)
  {
    this.vWm = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    AppMethodBeat.i(27867);
    aA(paramInt, true);
    AppMethodBeat.o(27867);
  }
  
  public void setOnEditFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(27895);
    this.oxm.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(27895);
  }
  
  public void setOnFooterSwitchListener(ChatFooter.e parame)
  {
    AppMethodBeat.i(27897);
    this.vWj = parame;
    if (parame == null)
    {
      AppMethodBeat.o(27897);
      return;
    }
    parame = findViewById(2131822473);
    parame.setVisibility(0);
    parame.setOnClickListener(new ChatFooter.24(this));
    AppMethodBeat.o(27897);
  }
  
  public void setRecordNormalWording(String paramString)
  {
    AppMethodBeat.i(27863);
    if ((paramString == null) || (this.vWo == null))
    {
      AppMethodBeat.o(27863);
      return;
    }
    this.vWo.setText(paramString);
    AppMethodBeat.o(27863);
  }
  
  public void setSetTolastCustomPage(boolean paramBoolean) {}
  
  public void setSmileyPanelCallback(f paramf)
  {
    AppMethodBeat.i(27844);
    this.vQk = paramf;
    if (this.eys != null) {
      this.eys.setCallback(paramf);
    }
    AppMethodBeat.o(27844);
  }
  
  public void setSmileyPanelCallback2(j paramj)
  {
    this.vWh.vZc = paramj;
  }
  
  public void setSwitchButtonMode(int paramInt)
  {
    AppMethodBeat.i(27898);
    if (paramInt == this.vXD)
    {
      AppMethodBeat.o(27898);
      return;
    }
    this.vXD = paramInt;
    ImageView localImageView1 = (ImageView)findViewById(2131822474);
    ImageView localImageView2 = (ImageView)findViewById(2131822475);
    if (this.vXD == 1)
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
      AppMethodBeat.o(27898);
      return;
    }
    localImageView1.setVisibility(0);
    localImageView2.setVisibility(8);
    AppMethodBeat.o(27898);
  }
  
  public void setTipsShowCallback(ChatFooter.c paramc)
  {
    this.vWJ = paramc;
  }
  
  @TargetApi(11)
  public void setToSendTextColor(boolean paramBoolean)
  {
    AppMethodBeat.i(27899);
    if (com.tencent.mm.compatible.util.d.fv(11))
    {
      com.tencent.mm.compatible.a.a.a(11, new ChatFooter.25(this, paramBoolean));
      AppMethodBeat.o(27899);
      return;
    }
    if (paramBoolean)
    {
      this.oxm.setTextColor(getResources().getColor(2131690766));
      AppMethodBeat.o(27899);
      return;
    }
    this.oxm.setTextColor(getResources().getColor(2131690159));
    pr(false);
    AppMethodBeat.o(27899);
  }
  
  public void setUserName(String paramString)
  {
    AppMethodBeat.i(27918);
    this.vVU = paramString;
    if (this.eys != null) {
      this.eys.setTalkerName(this.vVU);
    }
    if (this.vVV != null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.ChatFooter", "setusername: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (this.vVV == null) {
        break label167;
      }
      if ((!t.oD(this.vVU)) && (!t.ow(this.vVU))) {
        break;
      }
      this.vVV.setServiceShowFlag(0);
      AppMethodBeat.o(27918);
      return;
    }
    if (t.nU(this.vVU))
    {
      this.vVV.setServiceShowFlag(4);
      AppMethodBeat.o(27918);
      return;
    }
    if (t.lA(this.vVU))
    {
      this.vVV.setServiceShowFlag(2);
      AppMethodBeat.o(27918);
      return;
    }
    this.vVV.setServiceShowFlag(1);
    label167:
    AppMethodBeat.o(27918);
  }
  
  public void setVoice2txtCountDown(int paramInt)
  {
    AppMethodBeat.i(155464);
    if (-1 == paramInt)
    {
      this.vWW.setVisibility(0);
      this.vWY.setVisibility(8);
      AppMethodBeat.o(155464);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 10))
    {
      if (8 == this.vWY.getVisibility())
      {
        this.vWW.setVisibility(8);
        this.vWY.setVisibility(0);
      }
      if (this.vWY != null) {
        this.vWY.setImageResource(this.vXz[paramInt]);
      }
    }
    AppMethodBeat.o(155464);
  }
  
  public void setVoiceInputShowCallback(ChatFooter.d paramd)
  {
    this.vWK = paramd;
  }
  
  public void setWordCountLimit(int paramInt)
  {
    AppMethodBeat.i(27893);
    this.vVW = ((TextView)this.gcq.findViewById(2131822483));
    this.oxm.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(27893);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(27903);
    if ((this.vWN != null) && (this.vWN.isSupportNavigationSwipeBack()) && (this.vWN.getSwipeBackLayout() != null)) {
      this.vWN.getSwipeBackLayout().setOnceDisEnableGesture(true);
    }
    post(new ChatFooter.26(this));
    AppMethodBeat.o(27903);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(156696);
    ab.i("MicroMsg.ChatFooter", "onKeyboardHeightChanged: %s, %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(this.vWA) });
    if (!this.vWE)
    {
      AppMethodBeat.o(156696);
      return;
    }
    int i;
    if ((!this.vWD) && (this.vWv))
    {
      if (this.vWF == paramBoolean) {
        break label172;
      }
      i = 1;
      this.vWF = paramBoolean;
      if (paramInt <= 0) {
        break label207;
      }
      if (this.sMo != paramInt)
      {
        this.sMo = paramInt;
        com.tencent.mm.compatible.util.j.z(getContext(), paramInt);
        Ml(paramInt);
        j = 1;
      }
      if (this.vWC) {
        break label177;
      }
      aC(1, true);
      this.vWx = -1;
    }
    for (;;)
    {
      this.vWC = true;
      if (this.vWi != null) {
        this.vWi.jj(this.vWC);
      }
      AppMethodBeat.o(156696);
      return;
      label172:
      i = 0;
      break;
      label177:
      if ((j != 0) || (i != 0))
      {
        this.vWB = this.sMo;
        g(this.vWB, true, 1);
      }
    }
    label207:
    if (this.vWC)
    {
      if (this.vWx == -1) {
        break label244;
      }
      aC(this.vWx, true);
      this.vWx = -1;
    }
    for (;;)
    {
      this.vWC = false;
      break;
      label244:
      aC(0, true);
    }
  }
  
  public final void u(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(27855);
    if ((paramBoolean) && ((paramString == null) || (paramString.length() == 0) || (this.oxm == null)))
    {
      this.oxm.setText("");
      dod();
      AppMethodBeat.o(27855);
      return;
    }
    this.vWl = true;
    this.oxm.setText(com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), paramString, this.oxm.getTextSize()));
    this.vWl = false;
    if ((paramInt < 0) || (paramInt > this.oxm.getText().length()))
    {
      this.oxm.setSelection(this.oxm.getText().length());
      AppMethodBeat.o(27855);
      return;
    }
    this.oxm.setSelection(paramInt);
    AppMethodBeat.o(27855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter
 * JD-Core Version:    0.7.0.1
 */