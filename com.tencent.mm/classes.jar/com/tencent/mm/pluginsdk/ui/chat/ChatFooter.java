package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.nj;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChatFooter
  extends LinearLayout
  implements ViewTreeObserver.OnGlobalLayoutListener, h.a
{
  private static int count = 0;
  private static final int[] eMV = { R.g.amp1, R.g.amp2, R.g.amp3, R.g.amp4, R.g.amp5, R.g.amp6, R.g.amp7 };
  private static final int[] ibm = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private Activity activity;
  public String bRO;
  private Context context;
  private View eML = null;
  private boolean ibC = false;
  private final com.tencent.mm.sdk.platformtools.ah ibJ = new ChatFooter.14(this);
  private ImageView ibu;
  public ChatFooterPanel jpC;
  public View kch;
  public View kci;
  public View kcj;
  public View kck;
  public MMEditText lXN = null;
  public Button lXO = null;
  public final com.tencent.mm.sdk.platformtools.ah mHandler = new ChatFooter.12(this);
  private int oXF = -1;
  private int oXG = -1;
  public o pBG;
  private TextView pBH;
  private ImageView pBI;
  public View pBJ;
  private int qVq;
  f rZt;
  public n saW;
  public boolean saZ = false;
  private String seQ;
  public AppPanel seR;
  public TextView seS = null;
  private Button seT;
  public ImageButton seU;
  public ChatFooterBottom seV;
  private TextView seW;
  public ImageButton seX;
  public ImageButton seY;
  public View seZ;
  private AppPanel.b sfA = new ChatFooter.11(this);
  public ChatFooter.f sfB;
  private int sfC = 0;
  private com.tencent.mm.sdk.b.c sfD = new ChatFooter.17(this);
  private boolean sfE = false;
  private int sfF = 0;
  private final int sfG = 0;
  private final int sfH = 1;
  private final int sfI = 2;
  private final int sfJ = 3;
  private final int sfK = 20;
  private final int sfL = 21;
  private final int sfM = 22;
  private final int sfN = 23;
  private int sfO = 0;
  private int sfP = 0;
  private int sfQ = -1;
  private int sfR = -1;
  private boolean sfS = false;
  private final int sfT = 4097;
  private final int sfU = 4098;
  private volatile boolean sfV;
  private com.tencent.mm.sdk.platformtools.ah sfW = new ChatFooter.25(this);
  private int sfX = -1;
  private int sfY = -1;
  private int sfZ = -1;
  private com.tencent.mm.ui.widget.a.c sfa;
  private i sfb;
  public m sfc;
  private b sfd;
  private ChatFooter.e sfe = null;
  public final ChatFooter.a sff = new ChatFooter.a((byte)0);
  public boolean sfg = false;
  private boolean sfh = false;
  private TextView sfi;
  private InputMethodManager sfj;
  private int sfk;
  private boolean sfl = false;
  private boolean sfm = false;
  public boolean sfn = false;
  private boolean sfo = true;
  com.tencent.mm.h.b.a.b sfp = new com.tencent.mm.h.b.a.b();
  public ChatFooter.c sfq;
  public ChatFooter.d sfr;
  private m.a sfs = new ChatFooter.1(this);
  private boolean sft = false;
  public com.tencent.mm.ui.x sfu;
  public ChatFooter.b sfv;
  private boolean sfw = false;
  private Animation sfx;
  private Animation sfy;
  private ChatFooterPanel.a sfz = new ChatFooter.10(this);
  private View sga = null;
  public boolean sgb = true;
  private int sgc = 0;
  public String toUser;
  
  public ChatFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    long l = System.currentTimeMillis();
    this.sfj = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.eML = inflate(paramContext, R.i.chatting_footer, this);
    this.lXN = ((MMEditText)this.eML.findViewById(R.h.chatting_content_et));
    com.tencent.mm.ui.tools.a.c.d(this.lXN).Ig(com.tencent.mm.m.b.Ab()).a(null);
    this.lXN.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
    this.lXN.setOnFocusChangeListener(new ChatFooter.26(this));
    paramAttributeSet = new nj();
    paramAttributeSet.bWZ.bXb = this.lXN;
    paramAttributeSet.bWZ.bXa = new ChatFooter.27(this);
    com.tencent.mm.sdk.b.a.udP.m(paramAttributeSet);
    this.seZ = this.eML.findViewById(R.h.text_panel_ll);
    this.seV = ((ChatFooterBottom)findViewById(R.h.chatting_bottom_panel));
    this.seX = ((ImageButton)this.eML.findViewById(R.h.chatting_attach_btn));
    this.lXO = ((Button)this.eML.findViewById(R.h.chatting_send_btn));
    getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.lXO.setTextSize(0, com.tencent.mm.cb.a.ab(paramContext, R.f.HintTextSize) * com.tencent.mm.cb.a.ff(paramContext));
    this.seT = ((Button)this.eML.findViewById(R.h.voice_record_bt));
    this.seU = ((ImageButton)findViewById(R.h.chatting_mode_btn));
    ho(false);
    cnJ();
    this.sfb = new i(getContext(), getRootView(), this, new ChatFooter.28(this, paramContext));
    this.sfb.sgz = this;
    paramContext = getContext();
    getRootView();
    this.sfc = new m(paramContext);
    this.sfc.sfs = this.sfs;
    y.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[] { Integer.valueOf(this.lXN.getImeOptions()) });
    this.lXN.setOnEditorActionListener(new ChatFooter.29(this));
    this.lXN.setOnTouchListener(new ChatFooter.30(this));
    this.lXN.setOnLongClickListener(new ChatFooter.2(this));
    this.lXO.setOnClickListener(new ChatFooter.3(this));
    this.seT.setOnTouchListener(new ChatFooter.8(this));
    this.seT.setOnKeyListener(new ChatFooter.9(this));
    this.seU.setOnClickListener(new ChatFooter.7(this));
    cnf();
    this.seX.setVisibility(0);
    this.seX.setContentDescription(getContext().getString(R.l.chat_footer_app_btn_fold));
    this.seX.setOnClickListener(new ChatFooter.5(this));
    y.i("MicroMsg.ChatFooter", "[init]");
    En(-1);
    findViewById(R.h.chatting_foot_bar_group).setOnTouchListener(new ChatFooter.4(this));
    y.d("MicroMsg.ChatFooter", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void Ei(int paramInt)
  {
    if (this.seU == null) {
      return;
    }
    if (paramInt == R.g.chatting_setmode_voice_btn) {}
    for (int i = 1;; i = 0)
    {
      if (this.seU != null)
      {
        if (i == 0) {
          break label65;
        }
        this.seU.setContentDescription(getContext().getString(R.l.chat_footer_switch_mode_voice_btn));
      }
      for (;;)
      {
        this.seU.setImageResource(paramInt);
        this.seU.setPadding(0, 0, 0, 0);
        return;
        label65:
        this.seU.setContentDescription(getContext().getString(R.l.chat_footer_switch_mode_keybord_btn));
      }
    }
  }
  
  private void El(int paramInt)
  {
    this.sfk = paramInt;
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.seZ.setVisibility(0);
      this.seT.setVisibility(8);
      Ei(R.g.chatting_setmode_voice_btn);
      return;
      this.seZ.setVisibility(8);
      this.seT.setVisibility(0);
      Ei(R.g.chatting_setmode_keyboard_btn);
    } while ((!q.GS().booleanValue()) || (this.sfq == null));
    this.sfq.b(Boolean.valueOf(true), Boolean.valueOf(true));
  }
  
  private void Em(int paramInt)
  {
    com.tencent.mm.compatible.util.j.ah(getContext(), paramInt);
  }
  
  private void En(int paramInt)
  {
    y.i("MicroMsg.ChatFooter", "[refreshBootomHeight] keyborPx:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.compatible.util.j.cqv();
    if ((ad.aaU(this.seQ)) || (ad.aaV(this.seQ))) {}
    for (paramInt = com.tencent.mm.compatible.util.j.f(this.context, paramInt, 43);; paramInt = com.tencent.mm.compatible.util.j.aj(this.context, paramInt))
    {
      this.sfO = paramInt;
      Em(paramInt);
      Object localObject;
      if ((paramInt > 0) && (this.seV != null))
      {
        y.d("MicroMsg.ChatFooter", "set bottom panel height: %d", new Object[] { Integer.valueOf(paramInt) });
        localObject = new LinearLayout.LayoutParams(-1, 0);
        ((ViewGroup.LayoutParams)localObject).height = paramInt;
        y.e("MicroMsg.ChatFooter", "refreshBootomHeight:bottomPanel height:" + ((ViewGroup.LayoutParams)localObject).height);
        this.seV.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.seR != null)
      {
        this.seR.setPortHeighPx(paramInt);
        localObject = this.seR;
        y.i("MicroMsg.AppPanel", "[forceRefreshSize]");
        ((AppPanel)localObject).cmX();
        ((AppPanel)localObject).si();
      }
      if (this.saW != null)
      {
        this.saW.setPortHeightPX(paramInt);
        this.saW.cmX();
      }
      if (this.jpC != null)
      {
        if (!cnF()) {
          cnB();
        }
        this.jpC.setPortHeightPx(paramInt);
        this.jpC.sn();
      }
      return;
    }
  }
  
  private void cmB()
  {
    if (!this.saZ) {
      return;
    }
    View localView = findViewById(R.h.chatting_foot_bar_group);
    this.saZ = false;
    if (this.saW != null)
    {
      this.saW.destroy();
      this.saW.setVisibility(8);
    }
    localView.setVisibility(0);
    this.lXN.setVisibility(0);
    this.lXN.setText("");
    lZ(true);
    cnw();
    r(0, -1, false);
  }
  
  private void cnG()
  {
    this.seV.setVisibility(8);
    setAppPanelVisible(8);
    if (this.jpC != null) {
      this.jpC.setVisibility(8);
    }
    md(false);
  }
  
  private void cnf()
  {
    String str;
    if (this.sfv == null)
    {
      str = this.seQ;
      this.seR = ((AppPanel)findViewById(R.h.chatting_app_panel));
      this.seR.setOnSwitchPanelListener(this.sfA);
      this.seR.setPortHeighPx(u.fy(this.context));
      if ((!s.hU(str)) && (!s.hN(str))) {
        break label101;
      }
      this.seR.init(0);
    }
    for (;;)
    {
      this.seW = ((TextView)findViewById(R.h.chatting_app_panel_tip));
      return;
      str = this.sfv.getTalkerUserName();
      break;
      label101:
      if (s.hl(str)) {
        this.seR.init(4);
      } else if (s.fn(str)) {
        this.seR.init(2);
      } else {
        this.seR.init(1);
      }
    }
  }
  
  private void ho(boolean paramBoolean)
  {
    if (this.sfx == null)
    {
      this.sfx = AnimationUtils.loadAnimation(getContext(), R.a.pop_in);
      this.sfx.setDuration(150L);
    }
    if (this.sfy == null)
    {
      this.sfy = AnimationUtils.loadAnimation(getContext(), R.a.pop_out);
      this.sfy.setDuration(150L);
    }
    if ((this.lXO == null) || (this.seX == null)) {}
    do
    {
      do
      {
        return;
        if (!this.sft) {
          break;
        }
      } while (this.seX.getVisibility() == 0);
      this.seX.setVisibility(0);
      return;
    } while (((this.lXO.getVisibility() == 0) && (paramBoolean)) || ((this.seX.getVisibility() == 0) && (!paramBoolean)));
    if (paramBoolean)
    {
      this.lXO.startAnimation(this.sfx);
      this.lXO.setVisibility(0);
      this.seX.startAnimation(this.sfy);
      this.seX.setVisibility(8);
    }
    for (;;)
    {
      y.i("MicroMsg.ChatFooter", "jacks canSend:%B", new Object[] { Boolean.valueOf(paramBoolean) });
      this.lXO.getParent().requestLayout();
      return;
      this.seX.startAnimation(this.sfx);
      if (!this.sfh) {
        this.seX.setVisibility(0);
      }
      this.lXO.startAnimation(this.sfy);
      this.lXO.setVisibility(8);
    }
  }
  
  @TargetApi(24)
  private boolean isInMultiWindowMode()
  {
    if (((getContext() instanceof Activity)) && (com.tencent.mm.compatible.util.d.gF(24)))
    {
      boolean bool = ((Activity)getContext()).isInMultiWindowMode();
      y.i("MicroMsg.ChatFooter", "isInMultiWindow %b ", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    return false;
  }
  
  private void md(boolean paramBoolean)
  {
    if (this.seY == null) {}
    while (((this.sfS) && (paramBoolean)) || ((!this.sfS) && (!paramBoolean))) {
      return;
    }
    this.sfS = paramBoolean;
    if (paramBoolean)
    {
      this.seY.setImageDrawable(getContext().getResources().getDrawable(R.g.chatting_setmode_keyboard_btn));
      return;
    }
    this.seY.setImageDrawable(getContext().getResources().getDrawable(R.g.chatting_setmode_biaoqing_btn));
  }
  
  public final void Ej(int paramInt)
  {
    this.sfC = 0;
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 180);
    int j = BackwardSupportUtil.b.b(getContext(), 50.0F);
    if (paramInt + j < i) {}
    for (this.sfC = -1;; this.sfC = ((paramInt - i) / 2 + j))
    {
      if (this.pBG == null)
      {
        this.pBG = new o(View.inflate(getContext(), R.i.voice_rcd_hint_window, null), -1, -2);
        this.ibu = ((ImageView)this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_anim));
        this.kcj = this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_anim_area);
        this.kck = this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_cancel_area);
        this.pBH = ((TextView)this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_cancel_text));
        this.pBI = ((ImageView)this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_cancel_icon));
        this.pBJ = this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_loading);
        this.kch = this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_rcding);
        this.kci = this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_tooshort);
        this.sfi = ((TextView)this.pBG.getContentView().findViewById(R.h.voice_rcd_normal_wording));
      }
      if (this.sfC != -1)
      {
        this.kci.setVisibility(8);
        this.kch.setVisibility(8);
        this.pBJ.setVisibility(0);
        new com.tencent.mm.sdk.platformtools.ah().post(new ChatFooter.15(this));
        this.pBG.showAtLocation(this, 49, 0, this.sfC);
      }
      return;
    }
  }
  
  public final void Ek(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < eMV.length)
      {
        if ((paramInt >= ibm[i]) && (paramInt < ibm[(i + 1)])) {
          this.ibu.setBackgroundDrawable(com.tencent.mm.cb.a.g(getContext(), eMV[i]));
        }
      }
      else
      {
        if ((paramInt == -1) && (this.pBG != null))
        {
          this.pBG.dismiss();
          this.pBJ.setVisibility(0);
          this.kch.setVisibility(8);
          this.kci.setVisibility(8);
        }
        return;
      }
      i += 1;
    }
  }
  
  public final void T(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppPanel localAppPanel = this.seR;
    if (!paramBoolean1) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localAppPanel.sdT.seu.value = paramBoolean1;
      localAppPanel.cmV();
      y.d("MicroMsg.AppPanel", "enable " + paramBoolean1 + " isVoipPluginEnable " + localAppPanel.sdT.sev.value);
      this.seR.lU(paramBoolean2);
      return;
    }
  }
  
  public final void a(Context paramContext, Activity paramActivity)
  {
    this.activity = paramActivity;
    cnJ();
    if (aq.clf().rVw) {
      aq.clf().eS(ae.getContext());
    }
    if (this.jpC != null) {
      this.jpC.onResume();
    }
    if ((!this.sft) && (this.sfm))
    {
      y.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
      this.sfm = false;
      this.lXN.setImeOptions(0);
      this.lXN.setInputType(this.lXN.getInputType() | 0x40);
    }
    for (;;)
    {
      if (u.fA(paramContext) != this.sfo) {
        si();
      }
      if (this.seR != null) {
        this.seR.context = paramContext;
      }
      this.context = paramContext;
      this.sfb.sgy = false;
      if (!this.saZ)
      {
        this.eML.findViewById(R.h.chatting_send_group).setVisibility(0);
        this.lXN.setVisibility(0);
      }
      cnw();
      post(new ChatFooter.22(this));
      com.tencent.mm.sdk.b.a.udP.c(this.sfD);
      return;
      if ((this.sft) && (!this.sfm)) {
        cnA();
      }
    }
  }
  
  public final void aRj()
  {
    post(new Runnable()
    {
      public final void run()
      {
        if (ChatFooter.E(ChatFooter.this) != null)
        {
          ChatFooter.E(ChatFooter.this).dismiss();
          ChatFooter.F(ChatFooter.this).setVisibility(0);
          ChatFooter.G(ChatFooter.this).setVisibility(8);
          ChatFooter.H(ChatFooter.this).setVisibility(8);
          ChatFooter.x(ChatFooter.this).setVisibility(8);
          ChatFooter.w(ChatFooter.this).setVisibility(0);
        }
        ChatFooter.s(ChatFooter.this).setBackgroundDrawable(com.tencent.mm.cb.a.g(ChatFooter.this.getContext(), R.g.record_shape_normal));
        ChatFooter.s(ChatFooter.this).setText(R.l.chatfooter_presstorcd);
        ChatFooter.d(ChatFooter.this, false);
        ChatFooter.c(ChatFooter.this, false);
      }
    });
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    this.sfB = new ChatFooter.f(this, paramTextWatcher);
    this.lXN.addTextChangedListener(this.sfB);
  }
  
  public final void ak(String paramString1, String paramString2, String paramString3)
  {
    if (this.sff.sgl.containsKey(paramString1)) {}
    Object localObject;
    for (paramString1 = (LinkedList)this.sff.sgl.get(paramString1);; paramString1 = (String)localObject)
    {
      localObject = new HashMap(1);
      ((HashMap)localObject).put(paramString3, paramString2);
      paramString1.add(localObject);
      return;
      localObject = new LinkedList();
      this.sff.sgl.put(paramString1, localObject);
    }
  }
  
  public final void al(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    El(paramInt);
    switch (paramInt)
    {
    default: 
      setVisibility(0);
      return;
    case 1: 
      lZ(true);
      cnG();
      if (paramBoolean)
      {
        showVKB();
        if (this.lXN.length() > 0) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          ho(paramBoolean);
          return;
        }
      }
      if (this.lXN.length() > 0) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        ho(paramBoolean);
        return;
      }
    }
    r(0, -1, false);
    ho(false);
  }
  
  public final void cVs()
  {
    boolean bool = true;
    if (this.context == null) {
      if (this.activity != null) {
        break label55;
      }
    }
    for (;;)
    {
      y.e("MicroMsg.ChatFooter", "[initSmiley] activity = null? %s", new Object[] { Boolean.valueOf(bool) });
      if (this.activity == null) {
        break;
      }
      this.context = this.activity.getBaseContext();
      return;
      label55:
      bool = false;
    }
    this.context = getContext();
  }
  
  public final void cnA()
  {
    y.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
    this.sfm = true;
    this.lXN.setImeOptions(4);
    this.lXN.setInputType(this.lXN.getInputType() & 0xFFFFFFBF);
  }
  
  public final void cnB()
  {
    if (this.jpC != null) {
      this.jpC.refresh();
    }
  }
  
  public final boolean cnC()
  {
    if ((this.sfu == null) || (this.sfu.getView() == null)) {}
    Rect localRect;
    do
    {
      return false;
      localRect = new Rect();
      this.sfu.getView().getGlobalVisibleRect(localRect);
    } while (localRect.left <= 0);
    return true;
  }
  
  public final boolean cnD()
  {
    return this.seV.getVisibility() == 0;
  }
  
  public final void cnE()
  {
    r(2, 20, false);
  }
  
  public final boolean cnF()
  {
    int i = com.tencent.mm.ui.ak.gv(this.context);
    y.i("MicroMsg.ChatFooter", "is show key board %d, %d, %d", new Object[] { Integer.valueOf(this.oXG), Integer.valueOf(this.oXF), Integer.valueOf(i) });
    return (this.oXG > 0) && (this.oXG < this.oXF - i);
  }
  
  public final void cnH()
  {
    this.ibC = false;
    this.seT.setBackgroundDrawable(com.tencent.mm.cb.a.g(getContext(), R.g.record_shape_normal));
    this.seT.setText(R.l.chatfooter_presstorcd);
    if (this.sfd != null)
    {
      if ((this.kck != null) && (this.kck.getVisibility() == 0)) {
        this.sfd.bhh();
      }
    }
    else {
      return;
    }
    this.sfd.bhf();
  }
  
  public final boolean cnI()
  {
    return this.sfP - getTop() > 50;
  }
  
  public final void cnJ()
  {
    au.Hx();
    this.sft = ((Boolean)com.tencent.mm.model.c.Dz().get(66832, Boolean.valueOf(false))).booleanValue();
  }
  
  public final void cnb()
  {
    if (this.sfp != null)
    {
      com.tencent.mm.h.b.a.b localb = this.sfp;
      localb.cfF = 0L;
      localb.cfD = 0L;
      localb.cfE = 0L;
      localb.cfG = 0L;
      localb.al(0L).am(0L);
    }
  }
  
  public final void cnc()
  {
    if (this.seR == null) {
      return;
    }
    this.seR.cmT();
  }
  
  public final void cnd()
  {
    if (this.sfd != null) {
      this.sfd.bhk();
    }
    if ((this.seR.getVisibility() == 0) && (!this.seV.cbz))
    {
      if (this.sfk == 1)
      {
        showVKB();
        return;
      }
      r(0, -1, false);
      return;
    }
    r(2, 22, true);
    if ((this.saW != null) && (this.saW.getVisibility() == 0) && (this.saZ))
    {
      y.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
      this.saW.setVisibility(8);
      this.saZ = false;
      this.saW.reset();
    }
    Object localObject = aq.clf();
    Context localContext = ae.getContext();
    if ((!com.tencent.mm.kernel.g.DK()) || (localContext == null)) {}
    for (;;)
    {
      aq.clf().eS(ae.getContext());
      return;
      try
      {
        String str = com.tencent.mm.m.g.AA().getValue("ShowAPPSuggestion");
        if ((bk.bl(str)) || (Integer.valueOf(str).intValue() != 1)) {
          y.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[] { str });
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[] { localException.getMessage() });
        if (((aq)localObject).rVq)
        {
          y.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
        }
        else
        {
          y.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
          ((aq)localObject).rVq = true;
          if (System.currentTimeMillis() - ((aq)localObject).rVt < 43200000L)
          {
            y.d("MicroMsg.SuggestionAppListLogic", "not now");
            ((aq)localObject).rVq = false;
          }
          else
          {
            com.tencent.mm.kernel.g.DQ();
            ((aq)localObject).rVt = com.tencent.mm.kernel.g.DP().Dz().Fm(352275);
            if (System.currentTimeMillis() - ((aq)localObject).rVt < 43200000L)
            {
              y.w("MicroMsg.SuggestionAppListLogic", "not now sp");
              ((aq)localObject).rVq = false;
            }
            else
            {
              if (((aq)localObject).lang == null) {
                ((aq)localObject).lang = com.tencent.mm.sdk.platformtools.x.d(localContext.getSharedPreferences(ae.cqR(), 0));
              }
              localObject = new com.tencent.mm.pluginsdk.model.app.ah(((aq)localObject).lang, new LinkedList());
              com.tencent.mm.plugin.z.a.brq();
              com.tencent.mm.pluginsdk.model.app.d.a(4, (com.tencent.mm.pluginsdk.model.app.x)localObject);
            }
          }
        }
      }
    }
  }
  
  public final void cne()
  {
    boolean bool = true;
    cVs();
    if ((e.sgr == null) || (this.context == null)) {
      if (this.context == null)
      {
        y.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", new Object[] { bk.csb() });
        this.jpC = new d(ae.getContext());
      }
    }
    do
    {
      return;
      this.jpC = new d(this.context);
      return;
      if (this.jpC != null) {
        this.jpC.destroy();
      }
      this.jpC = e.sgr.cX(this.context);
    } while (this.jpC == null);
    this.jpC.setEntranceScene(ChatFooterPanel.rZv);
    if (this.jpC != null) {
      this.jpC.setVisibility(8);
    }
    if (this.jpC != null) {
      this.jpC.setFooterType(this.qVq);
    }
    if (this.seV != null) {
      this.seV.addView(this.jpC, -1, -2);
    }
    if (this.jpC != null) {
      this.jpC.setOnTextOperationListener(this.sfz);
    }
    if (this.jpC != null)
    {
      ChatFooterPanel localChatFooterPanel = this.jpC;
      if (this.lXN.getText().length() > 0) {
        localChatFooterPanel.setSendButtonEnable(bool);
      }
    }
    else if (this.jpC != null)
    {
      if (this.sfv != null) {
        this.jpC.setTalkerName(this.sfv.getTalkerUserName());
      }
      if (!com.tencent.mm.compatible.util.j.fA(getContext())) {
        break label327;
      }
      this.jpC.setPortHeightPx(getKeyBordHeightPX());
    }
    for (;;)
    {
      if (!bk.bl(this.lXN.getText().toString())) {
        this.jpC.sm();
      }
      if (this.sfn) {
        sk();
      }
      setSmileyPanelCallback(this.rZt);
      return;
      bool = false;
      break;
      label327:
      this.jpC.setPortHeightPx(com.tencent.mm.compatible.util.j.fy(getContext()));
    }
  }
  
  public final void cng()
  {
    this.sfk = 1;
    this.seZ.setVisibility(0);
    this.seT.setVisibility(8);
    Ei(R.g.chatting_setmode_voice_btn);
    if (this.saW != null)
    {
      this.saW.setVisibility(8);
      this.saZ = false;
      this.saW.reset();
    }
    r(2, 21, true);
  }
  
  public final void cnh()
  {
    this.seT.setEnabled(false);
    this.seT.setBackgroundDrawable(com.tencent.mm.cb.a.g(getContext(), R.g.record_shape_disable));
    if (this.pBG != null)
    {
      this.kci.setVisibility(0);
      this.kch.setVisibility(8);
      this.pBJ.setVisibility(8);
      this.pBG.update();
    }
    this.ibJ.sendEmptyMessageDelayed(0, 500L);
  }
  
  public final void cni()
  {
    this.pBJ.setVisibility(8);
    this.kch.setVisibility(0);
  }
  
  public final void cnj()
  {
    this.seZ.setVisibility(0);
    this.seU.setVisibility(8);
    this.seT.setVisibility(8);
  }
  
  public final void cnk()
  {
    if (this.seU != null) {
      this.seU.setVisibility(0);
    }
  }
  
  public final void cnl()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sdT.sep.value = false;
    localAppPanel.cmV();
  }
  
  public final void cnm()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sdT.seI.value = false;
    localAppPanel.cmV();
  }
  
  public final void cnn()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sdT.seq.value = false;
    localAppPanel.cmV();
  }
  
  public final void cno()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sdT.ses.value = false;
    localAppPanel.cmV();
  }
  
  public final void cnp()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sdT.set.value = false;
    localAppPanel.cmV();
  }
  
  public final void cnq()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sdT.seH.value = false;
    localAppPanel.cmV();
  }
  
  public final void cnr()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.seb = true;
    localAppPanel.sdT.lX(false);
    localAppPanel.cmV();
    y.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", new Object[] { bk.csb().toString() });
  }
  
  public final void cns()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sec = true;
    localAppPanel.sdT.lW(false);
    localAppPanel.cmV();
  }
  
  public final void cnt()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sdT.seA.value = false;
    localAppPanel.cmV();
    y.d("MicroMsg.AppPanel", "disableTalkroom enable false");
  }
  
  public final void cnu()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sdT.seF.value = false;
    localAppPanel.cmV();
  }
  
  public final void cnv()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sdT.sez.value = false;
    localAppPanel.cmV();
  }
  
  public final void cnw()
  {
    this.seY = ((ImageButton)this.eML.findViewById(R.h.chatting_smiley_btn));
    this.seY.setVisibility(0);
    this.seY.setOnClickListener(new ChatFooter.6(this));
    if (this.sfc != null) {
      this.sfc.sgI = this.seY;
    }
  }
  
  public final void cnx()
  {
    if (this.seY != null) {
      this.seY.setVisibility(8);
    }
  }
  
  public final void cny()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sed = true;
    localAppPanel.sdT.lY(false);
    localAppPanel.cmV();
  }
  
  public final void cnz()
  {
    AppPanel localAppPanel = this.seR;
    localAppPanel.sdT.seN.value = false;
    localAppPanel.cmV();
  }
  
  public final void destroy()
  {
    if (this.jpC != null)
    {
      y.i("MicroMsg.ChatFooter", "jacks chat footer desctory smiley panel");
      this.jpC.sj();
      this.jpC.destroy();
      this.jpC = null;
    }
    if (this.saW != null)
    {
      this.saW.destroy();
      this.saW = null;
      this.saZ = false;
    }
    if (this.sfd != null) {
      this.sfd.release();
    }
    if (this.sfc != null)
    {
      this.sfc.sfs = null;
      this.sfc.sgJ = null;
      this.sfc.hide();
    }
    y.d("MicroMsg.ChatFooter", "jacks destroy");
  }
  
  public final HashMap<String, String> fU(String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    if (bk.bl(paramString2))
    {
      if (this.sff.sgl.containsKey(paramString1)) {
        this.sff.sgl.remove(paramString1);
      }
      return null;
    }
    if ((!this.sff.sgl.containsKey(paramString1)) || (((LinkedList)this.sff.sgl.get(paramString1)).size() <= 0)) {
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
    y.i("MicroMsg.ChatFooter", "after split @ :%s", new Object[] { localObject });
    if (((List)localObject).size() <= 0)
    {
      ((LinkedList)this.sff.sgl.get(paramString1)).clear();
      return null;
    }
    paramString1 = (LinkedList)this.sff.sgl.get(paramString1);
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      y.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", new Object[] { Integer.valueOf(paramString1.size()) });
      paramString2 = new LinkedList();
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label347;
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
      label347:
      localObject = new HashMap(1);
      y.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", new Object[] { Integer.valueOf(paramString2.size()) });
      ((HashMap)localObject).put("atuserlist", "<![CDATA[" + bk.c(paramString2, ",") + "]]>");
      paramString1.clear();
      y.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return localObject;
    }
    y.w("MicroMsg.ChatFooter", "list is null or size 0");
    return null;
  }
  
  public String getAtSomebody()
  {
    return this.sff.sgj;
  }
  
  public int getBarGroupHeight()
  {
    return findViewById(R.h.chatting_foot_bar_group).getHeight();
  }
  
  public f getCallback()
  {
    return this.rZt;
  }
  
  public char getCharAtCursor()
  {
    int i = getSelectionStart();
    if (i <= 0) {
      return 'x';
    }
    return getLastText().charAt(i - 1);
  }
  
  public int getInsertPos()
  {
    return this.sff.sgk;
  }
  
  public boolean getIsVoiceInputPanleShow()
  {
    return this.saZ;
  }
  
  public int getKeyBordHeightPX()
  {
    return com.tencent.mm.compatible.util.j.u(getContext(), true);
  }
  
  public String getLastContent()
  {
    return this.sff.sgi;
  }
  
  public String getLastText()
  {
    if (this.lXN == null) {
      return "";
    }
    return this.lXN.getText().toString();
  }
  
  public int getMode()
  {
    return this.sfk;
  }
  
  public View getPanel()
  {
    return this.seV;
  }
  
  public int getSelectionStart()
  {
    return this.lXN.getSelectionStart();
  }
  
  public int getSmieyType()
  {
    return 0;
  }
  
  public int getYFromBottom()
  {
    int k = com.tencent.mm.compatible.util.j.fy(getContext());
    int j = getHeight();
    int i = j;
    if (j < k) {
      i = j + k;
    }
    return i;
  }
  
  public final void lZ(boolean paramBoolean)
  {
    if (this.lXN == null) {
      return;
    }
    if (paramBoolean)
    {
      this.lXN.requestFocus();
      return;
    }
    this.lXN.clearFocus();
  }
  
  public final void ma(boolean paramBoolean)
  {
    if (this.jpC != null) {
      this.jpC.i(paramBoolean, false);
    }
  }
  
  public final void mb(boolean paramBoolean)
  {
    AppPanel localAppPanel = this.seR;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAppPanel.sdT.seK.value = paramBoolean;
      localAppPanel.cmV();
      y.d("MicroMsg.AppPanel", "enable " + localAppPanel.sdT.seK.value + " isMultiTalkEnable " + paramBoolean);
      return;
    }
  }
  
  public final void mc(boolean paramBoolean)
  {
    AppPanel localAppPanel = this.seR;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAppPanel.sdT.seD.value = paramBoolean;
      localAppPanel.cmV();
      return;
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.activity == null) || (this.activity.getWindow() == null) || (this.activity.getWindow().getDecorView() == null)) {}
    int m;
    int j;
    int k;
    do
    {
      do
      {
        return;
        if (this.sfZ == -1)
        {
          y.w("MicroMsg.ChatFooter", "chattingui layout id == -1!");
          return;
        }
        if (this.sga == null) {
          this.sga = this.activity.getWindow().getDecorView().findViewById(this.sfZ);
        }
        if (this.sga == null)
        {
          y.e("MicroMsg.ChatFooter", "can't get chattinguilayout by chattinguilayoutid: %d", new Object[] { Integer.valueOf(this.sfZ) });
          return;
        }
        m = this.sga.getHeight();
        i = this.sga.getWidth();
        y.d("MicroMsg.ChatFooter", "ashutest::keybord:ChatFooter measure height: %d, height: %d", new Object[] { Integer.valueOf(this.sga.getMeasuredHeight()), Integer.valueOf(m) });
        if (this.sfR < m) {
          this.sfR = m;
        }
        this.sfQ = m;
        if (this.sfX <= 0)
        {
          this.sfX = m;
          return;
        }
        if (this.sfY <= 0)
        {
          this.sfY = i;
          return;
        }
      } while ((this.sfX == m) && (this.sfY == i));
      if ((cnF()) && (this.sfw))
      {
        this.sfw = false;
        y.d("MicroMsg.ChatFooter", "keybord:Chatfooter Show keybord & hide diy panel by onGlobalLayout");
        postDelayed(new Runnable()
        {
          public final void run()
          {
            ChatFooter.this.cnE();
          }
        }, 10L);
      }
      y.d("MicroMsg.ChatFooter", "keybord:Chatfooter keybord old: %d, new: %d", new Object[] { Integer.valueOf(this.sfX), Integer.valueOf(m) });
      j = com.tencent.mm.ui.ak.gv(this.context);
      k = Math.abs(this.sfX - m);
      if (k > j) {
        this.sfX = m;
      }
      m = Math.abs(this.sfY - i);
      this.sfY = i;
      y.i("MicroMsg.ChatFooter", "alvinluo widthDiff: %d", new Object[] { Integer.valueOf(m) });
      if (!this.sgb) {
        break;
      }
      if (k == 0) {
        break label599;
      }
    } while (!com.tencent.mm.compatible.util.j.fA(this.context));
    if (k > j)
    {
      y.i("MicroMsg.ChatFooter", "alvinluo keyboard current height: %d heightPx:%d", new Object[] { Integer.valueOf(this.sfO), Integer.valueOf(k) });
      if ((this.sfO != k) || (k == -1))
      {
        j = com.tencent.mm.compatible.util.j.fy(this.context);
        y.d("MicroMsg.ChatFooter", "alvinluo valid panel height: %d", new Object[] { Integer.valueOf(j) });
        i = com.tencent.mm.compatible.util.j.fx(this.context);
        m = com.tencent.mm.compatible.util.j.fw(this.context);
        if (k >= i) {
          break label659;
        }
      }
    }
    label659:
    for (int i = j;; i = k)
    {
      if (i > m) {
        i = j;
      }
      for (;;)
      {
        if (this.sfE)
        {
          this.sfE = false;
          j = i;
          if (i < this.sfO) {
            j = this.sfO;
          }
          this.sfO = j;
          En(j);
          i = j;
          Em(i);
        }
        for (;;)
        {
          y.d("MicroMsg.ChatFooter", "keybord:Chatfooter Keyboard Size: " + k);
          return;
          this.sfO = i;
          y.i("MicroMsg.ChatFooter", "jacks calc keyBord dialog height:%d", new Object[] { Integer.valueOf(this.sfO) });
          En(i);
          break;
          label599:
          if (this.seR != null)
          {
            this.seR.setNeedRefreshHeight(true);
            this.seR.si();
          }
          if (this.jpC != null)
          {
            this.jpC.setPortHeightPx(com.tencent.mm.compatible.util.j.fy(this.context));
            cnB();
            this.jpC.sn();
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.d("MicroMsg.ChatFooter", "keybord:ChatFooter onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.oXF < paramInt4)
    {
      paramInt1 = paramInt4;
      this.oXF = paramInt1;
      this.oXG = paramInt4;
      if (getTop() != 0)
      {
        if (getTop() > this.sfP) {
          this.sfP = getTop();
        }
        if (this.sfP - getTop() <= 50) {
          break label154;
        }
        if (this.sfd != null) {
          this.sfd.hq(true);
        }
      }
      label141:
      if (paramBoolean) {
        break label174;
      }
    }
    label154:
    label174:
    m localm;
    do
    {
      do
      {
        return;
        paramInt1 = this.oXF;
        break;
        if (this.sfd == null) {
          break label141;
        }
        this.sfd.hq(false);
        break label141;
      } while (this.sfc == null);
      localm = this.sfc;
    } while (!localm.sgH.isShowing());
    localm.sgH.dismiss();
    localm.cnO();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", new Object[] { Integer.valueOf(View.MeasureSpec.getSize(paramInt2)), Integer.valueOf(getMeasuredHeight()) });
    super.onMeasure(paramInt1, paramInt2);
    y.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
  }
  
  public final void onPause()
  {
    this.sfw = true;
    if (this.jpC != null) {
      this.jpC.onPause();
    }
    if ((this.saZ) && (this.saW != null)) {
      this.saW.pause();
    }
    if (this.sfd != null) {
      this.sfd.onPause();
    }
    if (this.sfc != null) {
      this.sfc.hide();
    }
    this.sgb = false;
    com.tencent.mm.sdk.b.a.udP.d(this.sfD);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    y.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public final void r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramBoolean)
    {
      if ((q.GS().booleanValue()) && (this.sfq != null))
      {
        this.sfq.a(Boolean.valueOf(true), Boolean.valueOf(false));
        this.sfq.b(Boolean.valueOf(true), Boolean.valueOf(false));
      }
      this.seX.setContentDescription(getContext().getString(R.l.chat_footer_app_btn_expand));
      switch (paramInt1)
      {
      default: 
        bool1 = false;
        if (((bool1) && (paramInt2 != 21) && (this.seY != null)) || ((this.seY != null) && (!bool1) && ((paramInt2 == 21) || (paramInt2 == 20)))) {
          md(false);
        }
        if ((paramInt1 == 0) && (!bool1)) {
          md(false);
        }
        break;
      }
    }
    label334:
    while ((!bool1) || (paramInt2 == 22))
    {
      return;
      this.seV.setIsHide(true);
      if ((!u.fA(this.context)) || (isInMultiWindowMode())) {
        this.seV.setVisibility(8);
      }
      lZ(true);
      setToSendTextColor(true);
      this.sfj.showSoftInput(this.lXN, 0);
      bool1 = paramBoolean;
      break;
      Object localObject;
      if (paramInt2 == 22)
      {
        if (this.seR == null) {
          cnf();
        }
        this.seR.cmX();
        if (this.jpC != null) {
          this.jpC.setVisibility(8);
        }
        setAppPanelVisible(0);
        localObject = this.sfb;
        i.2 local2 = new i.2((i)localObject, ((i)localObject).context.getMainLooper());
        au.DS().O(new i.3((i)localObject, local2));
        lZ(false);
        if (this.sfk == 2) {
          El(1);
        }
        if ((!cnF()) || (!com.tencent.mm.compatible.util.j.fA(getContext())) || (isInMultiWindowMode())) {
          break label536;
        }
        post(new ChatFooter.23(this));
        y.i("MicroMsg.ChatFooter", "bottom panel will show lately");
      }
      for (;;)
      {
        if ((!cnF()) || (!com.tencent.mm.compatible.util.j.fA(getContext())))
        {
          localObject = this.seV.getLayoutParams();
          if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height == 0))
          {
            ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.compatible.util.j.fy(getContext());
            y.e("MicroMsg.ChatFooter", "configPannel():bottomPanel height:" + ((ViewGroup.LayoutParams)localObject).height);
            this.seV.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        bk.hideVKB(this);
        bool1 = paramBoolean;
        break;
        if (paramInt2 != 21) {
          break label334;
        }
        if (this.seR != null) {
          setAppPanelVisible(8);
        }
        if (this.jpC == null) {
          cne();
        }
        if (this.jpC != null) {
          this.jpC.setVisibility(0);
        }
        md(true);
        lZ(true);
        break label334;
        this.seV.setVisibility(0);
      }
      this.seV.setIsHide(true);
      if (!u.fA(this.context)) {
        this.seV.setVisibility(8);
      }
      lZ(true);
      setToSendTextColor(true);
      bool1 = paramBoolean;
      break;
      this.seX.setContentDescription(getContext().getString(R.l.chat_footer_app_btn_fold));
      switch (paramInt1)
      {
      default: 
        bool1 = paramBoolean;
        break;
      case 0: 
        bk.hideVKB(this);
        lZ(false);
        bool1 = paramBoolean;
        if (this.saZ) {
          break;
        }
        cnG();
        bool1 = paramBoolean;
        break;
      case 1: 
        bk.hideVKB(this);
        bool1 = paramBoolean;
        break;
      case 2: 
        if (paramInt2 == 20)
        {
          if (this.saZ)
          {
            bk.hideVKB(this);
            bool1 = paramBoolean;
            break;
          }
          cnG();
          bool1 = paramBoolean;
          break;
        }
        if (paramInt2 == 22)
        {
          setAppPanelVisible(8);
          bool1 = paramBoolean;
          break;
        }
        if (paramInt2 == 21)
        {
          bool1 = paramBoolean;
          if (this.jpC == null) {
            break;
          }
          this.jpC.setVisibility(8);
          bool1 = paramBoolean;
          break;
        }
        bool1 = paramBoolean;
        if (paramInt2 != 23) {
          break;
        }
        cmB();
        cnG();
        bool1 = paramBoolean;
        break;
      }
    }
    label536:
    if (this.lXN.length() > 0) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ho(paramBoolean);
      return;
    }
  }
  
  public final void r(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && ((paramString == null) || (paramString.length() == 0) || (this.lXN == null)))
    {
      this.lXN.setText("");
      cnb();
      return;
    }
    this.sfg = true;
    this.lXN.setText(com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), paramString, this.lXN.getTextSize()));
    this.sfg = false;
    if ((paramInt < 0) || (paramInt > this.lXN.getText().length()))
    {
      this.lXN.setSelection(this.lXN.getText().length());
      return;
    }
    this.lXN.setSelection(paramInt);
  }
  
  public void setAppPanelListener(AppPanel.a parama)
  {
    this.seR.setAppPanelListener(parama);
  }
  
  public void setAppPanelTip(CharSequence paramCharSequence)
  {
    if ((this.seW == null) || (this.seR == null)) {}
    do
    {
      return;
      this.seW.setText(paramCharSequence);
    } while (bk.L(paramCharSequence));
    if (this.seR.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      setAppPanelTipVisible(bool);
      return;
    }
  }
  
  public void setAppPanelTipVisible(boolean paramBoolean)
  {
    if (this.seW == null) {
      return;
    }
    if (TextUtils.isEmpty(this.seW.getText()))
    {
      this.seW.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      localObject = this.seW.getContext();
      this.seR.getPageMaxRowCount();
      i = com.tencent.mm.cb.a.fromDPToPix((Context)localObject, 32);
      localObject = this.seW.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams))) {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
      }
    }
    Object localObject = this.seW;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      return;
    }
  }
  
  public void setAppPanelVisible(int paramInt)
  {
    if (this.seR != null) {
      this.seR.setVisibility(paramInt);
    }
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      setAppPanelTipVisible(bool);
      return;
    }
  }
  
  public void setAtSomebody(String paramString)
  {
    this.sff.sgj = paramString;
  }
  
  public void setBottomPanelVisibility(int paramInt)
  {
    if (paramInt == 0)
    {
      this.seV.setVisibility(paramInt);
      return;
    }
    cnE();
  }
  
  public void setCattingRootLayoutId(int paramInt)
  {
    this.sga = null;
    this.sfZ = paramInt;
  }
  
  public void setDefaultSmileyByDetail(String paramString)
  {
    if (!bk.bl(paramString))
    {
      if (this.jpC == null) {
        cne();
      }
      this.jpC.setDefaultEmojiByDetail(paramString);
    }
  }
  
  @TargetApi(11)
  public void setEditTextOnDragListener(View.OnDragListener paramOnDragListener)
  {
    this.lXN.setOnDragListener(paramOnDragListener);
  }
  
  public void setFooterEventListener(b paramb)
  {
    this.sfd = paramb;
  }
  
  public void setFooterType(int paramInt)
  {
    this.qVq = paramInt;
    if (this.jpC != null) {
      this.jpC.setFooterType(paramInt);
    }
  }
  
  public void setHint(String paramString)
  {
    if (this.lXN != null) {
      this.lXN.setHint(paramString);
    }
  }
  
  public void setInsertPos(int paramInt)
  {
    this.sff.sgk = paramInt;
  }
  
  public void setLastContent(String paramString)
  {
    this.sff.sgi = paramString;
  }
  
  public void setLastText(String paramString)
  {
    r(paramString, -1, true);
  }
  
  public void setLbsMode(boolean paramBoolean)
  {
    this.sfh = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    al(paramInt, true);
  }
  
  public void setOnEditFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.lXN.setOnFocusChangeListener(paramOnFocusChangeListener);
  }
  
  public void setOnFooterSwitchListener(ChatFooter.e parame)
  {
    this.sfe = parame;
    if (parame == null) {
      return;
    }
    parame = findViewById(R.h.chatting_mode_switcher);
    parame.setVisibility(0);
    parame.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (ChatFooter.J(ChatFooter.this) != null) {
          ChatFooter.J(ChatFooter.this).me(false);
        }
      }
    });
  }
  
  public void setRecordNormalWording(String paramString)
  {
    if ((paramString == null) || (this.sfi == null)) {
      return;
    }
    this.sfi.setText(paramString);
  }
  
  public void setSetTolastCustomPage(boolean paramBoolean) {}
  
  public void setSmileyPanelCallback(f paramf)
  {
    this.rZt = paramf;
    if (this.jpC != null) {
      this.jpC.setCallback(paramf);
    }
  }
  
  public void setSmileyPanelCallback2(j paramj)
  {
    this.sfc.sgJ = paramj;
  }
  
  public void setSwitchButtonMode(int paramInt)
  {
    if (paramInt == this.sfF) {
      return;
    }
    this.sfF = paramInt;
    ImageView localImageView1 = (ImageView)findViewById(R.h.switch_btn);
    ImageView localImageView2 = (ImageView)findViewById(R.h.open_mini_program_btn);
    if (this.sfF == 1)
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
      return;
    }
    localImageView1.setVisibility(0);
    localImageView2.setVisibility(8);
  }
  
  public void setTipsShowCallback(ChatFooter.c paramc)
  {
    this.sfq = paramc;
  }
  
  @TargetApi(11)
  public void setToSendTextColor(boolean paramBoolean)
  {
    if (com.tencent.mm.compatible.util.d.gF(11))
    {
      com.tencent.mm.compatible.a.a.a(11, new ChatFooter.19(this, paramBoolean));
      return;
    }
    if (paramBoolean)
    {
      this.lXN.setTextColor(getResources().getColor(R.e.mm_edit_text_color));
      return;
    }
    this.lXN.setTextColor(getResources().getColor(R.e.half_alpha_black));
    lZ(false);
  }
  
  public void setUserName(String paramString)
  {
    this.seQ = paramString;
    if (this.jpC != null) {
      this.jpC.setTalkerName(this.seQ);
    }
    if (this.seR != null)
    {
      if ((!s.hU(this.seQ)) && (!s.hN(this.seQ))) {
        break label64;
      }
      this.seR.setServiceShowFlag(0);
    }
    for (;;)
    {
      En(-1);
      return;
      label64:
      if (s.hl(this.seQ)) {
        this.seR.setServiceShowFlag(4);
      } else if (s.fn(this.seQ)) {
        this.seR.setServiceShowFlag(2);
      } else {
        this.seR.setServiceShowFlag(1);
      }
    }
  }
  
  public void setVoiceInputShowCallback(ChatFooter.d paramd)
  {
    this.sfr = paramd;
  }
  
  public void setWordCountLimit(int paramInt)
  {
    this.seS = ((TextView)this.eML.findViewById(R.h.chatting_wordcount_tv));
    this.lXN.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  public final void showVKB()
  {
    if ((this.sfu != null) && (this.sfu.isSupportNavigationSwipeBack()) && (this.sfu.getSwipeBackLayout() != null)) {
      this.sfu.getSwipeBackLayout().setOnceDisEnableGesture(true);
    }
    post(new ChatFooter.21(this));
  }
  
  public final void si()
  {
    y.i("MicroMsg.ChatFooter", "[dealOrientationChange]");
    cmB();
    cnG();
    En(-1);
    this.sfE = true;
    this.sfo = u.fA(this.context);
    cnB();
    if (this.jpC != null) {
      this.jpC.si();
    }
  }
  
  public final void sk()
  {
    this.sfn = true;
    if (this.jpC != null) {
      this.jpC.sk();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter
 * JD-Core Version:    0.7.0.1
 */