package com.tencent.mm.pluginsdk.ui.chat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
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
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.ui.d.b;
import com.tencent.mm.plugin.groupsolitaire.ui.d.c;
import com.tencent.mm.plugin.groupsolitaire.ui.d.d;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.4;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.a;
import com.tencent.mm.plugin.transvoice.ui.SoundWaveView;
import com.tencent.mm.plugin.transvoice.ui.SoundWaveView.d;
import com.tencent.mm.plugin.transvoice.ui.b.d;
import com.tencent.mm.pluginsdk.model.app.ag;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.chatting.c.x.a;
import com.tencent.mm.ui.chatting.c.x.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ChatFooter
  extends FrameLayout
  implements h.a, com.tencent.mm.ui.tools.g
{
  private static int CcI;
  private static final int[] CeD;
  private static final int[] CeE;
  public static final String CeO;
  private static int count;
  private int AHD;
  private final long ANIMATION_DURATION;
  f BUS;
  public n BWH;
  public boolean BWK;
  public ImageButton CbA;
  private View CbB;
  public ChatFooterBottom CbC;
  private TextView CbD;
  public ImageButton CbE;
  public ImageView CbF;
  public ImageButton CbG;
  public View CbH;
  private com.tencent.mm.ui.widget.a.d CbI;
  public LinearLayout CbJ;
  public RelativeLayout CbK;
  private TextView CbL;
  private WeImageView CbM;
  private i CbN;
  public m CbO;
  private com.tencent.mm.plugin.groupsolitaire.ui.d CbP;
  private b CbQ;
  private ChatFooter.g CbR;
  private ChatFooter.f CbS;
  private ClipboardManager CbT;
  public final a CbU;
  public boolean CbV;
  private boolean CbW;
  public boolean CbX;
  public ViewGroup CbY;
  private TextView CbZ;
  public String Cbw;
  public AppPanel Cbx;
  public TextView Cby;
  private Button Cbz;
  public ChatFooter.c CcA;
  public d CcB;
  private m.a CcC;
  private boolean CcD;
  public MMFragment CcE;
  public ChatFooter.b CcF;
  private Animation CcG;
  private Animation CcH;
  public ViewGroup CcJ;
  private View CcK;
  private BlurView CcL;
  private View CcM;
  private View CcN;
  private ImageView CcO;
  private ImageView CcP;
  private View CcQ;
  private TextView CcR;
  private ImageView CcS;
  private View CcT;
  private View CcU;
  private WeImageView CcV;
  private TextView CcW;
  private View CcX;
  private WeImageView CcY;
  private TextView CcZ;
  private View Cca;
  private InputMethodManager Ccb;
  private int Ccc;
  private boolean Ccd;
  private boolean Cce;
  private boolean Ccf;
  public boolean Ccg;
  private boolean Cch;
  private boolean Cci;
  public int Ccj;
  private int Cck;
  private ChattingScrollLayout Ccl;
  private boolean Ccm;
  private int Ccn;
  private int Cco;
  private boolean Ccp;
  private boolean Ccq;
  private boolean Ccr;
  private int Ccs;
  private int Cct;
  private int Ccu;
  private boolean Ccv;
  private x.c Ccw;
  private x.a Ccx;
  private d.c Ccy;
  com.tencent.mm.g.b.a.c Ccz;
  private ViewGroup CdA;
  private TextView CdB;
  private ViewGroup CdC;
  private ViewGroup CdD;
  private View CdE;
  private View CdF;
  private WeImageView CdG;
  private WeImageView CdH;
  private View CdI;
  private View CdJ;
  private ViewGroup CdK;
  private View CdL;
  private View CdM;
  private WeImageView CdN;
  private WeImageView CdO;
  private View CdP;
  private View CdQ;
  private WeImageView CdR;
  private ViewGroup CdS;
  private View CdT;
  private View CdU;
  private View CdV;
  private WeImageView CdW;
  private View CdX;
  private int CdY;
  private int CdZ;
  private View Cda;
  private BlurView Cdb;
  private com.tencent.mm.plugin.transvoice.ui.b Cdc;
  private com.tencent.mm.plugin.transvoice.a.a Cdd;
  private com.tencent.mm.modelvoiceaddr.h Cde;
  public o Cdf;
  private com.tencent.mm.plugin.transvoice.a.c Cdg;
  private ChatFooter.l Cdh;
  private j Cdi;
  private k Cdj;
  private boolean Cdk;
  private boolean Cdl;
  public boolean Cdm;
  private float Cdn;
  private o Cdo;
  private View Cdp;
  private View Cdq;
  private ViewGroup Cdr;
  private EditText Cds;
  private SoundWaveView Cdt;
  private ImageView Cdu;
  private ViewGroup Cdv;
  private TextView Cdw;
  private WeImageView Cdx;
  public LanguageChoiceLayout Cdy;
  private TextView Cdz;
  private int CeA;
  private int CeB;
  private int CeC;
  private int CeF;
  private boolean CeG;
  private final int CeH;
  private final int CeI;
  private volatile boolean CeJ;
  private com.tencent.mm.sdk.platformtools.ap CeK;
  private boolean CeL;
  private int CeM;
  private boolean CeN;
  private int CeP;
  private View CeQ;
  private int CeR;
  private int CeS;
  private int CeT;
  private int CeU;
  private int CeV;
  private int CeW;
  private Runnable CeX;
  private Runnable CeY;
  private int CeZ;
  private boolean Cea;
  private ChatFooterPanel.a Ceb;
  private AppPanel.b Cec;
  private ChatFooter.b Ced;
  public i Cee;
  private int Cef;
  private boolean Ceg;
  private int Ceh;
  private TextWatcher Cei;
  ValueAnimator Cej;
  ValueAnimator Cek;
  ValueAnimator Cel;
  ValueAnimator Cem;
  ValueAnimator Cen;
  ValueAnimator.AnimatorUpdateListener Ceo;
  private int[] Cep;
  private final int Ceq;
  private final int Cer;
  private final int Ces;
  private final int Cet;
  private final int Ceu;
  private final int Cev;
  private final float Cew;
  private int Cex;
  private int Cey;
  private int Cez;
  private int Cfa;
  e Cfb;
  e Cfc;
  private Map<Integer, String> Cfd;
  private boolean Cfe;
  private Activity activity;
  public String dpv;
  private boolean fNO;
  public Button fPz;
  public ChatFooterPanel fSY;
  private com.tencent.mm.ui.tools.h ftZ;
  private View hFi;
  private ViewGroup hSI;
  private int mEi;
  public final com.tencent.mm.sdk.platformtools.ap mHandler;
  private int maxHeight;
  private boolean omf;
  private final com.tencent.mm.sdk.platformtools.ap oms;
  public View qeC;
  private ImageView qeD;
  public View qeE;
  public View qeF;
  public boolean srJ;
  public String toUser;
  public MMEditText tqv;
  public o yJL;
  private TextView yJM;
  private ImageView yJN;
  public View yJO;
  private int yVZ;
  com.tencent.mm.plugin.transvoice.a.b yYa;
  private String yYf;
  private int yYg;
  private av yYh;
  private boolean yYi;
  private com.tencent.mm.sdk.platformtools.ap yYk;
  private com.tencent.mm.modelvoiceaddr.b.b yYs;
  private List<String> yYt;
  
  static
  {
    AppMethodBeat.i(31717);
    count = 0;
    CeD = new int[] { 0, 15, 30, 45, 60, 75, 90, 95, 100 };
    CeE = new int[] { 2131689547, 2131689548, 2131689549, 2131689550, 2131689551, 2131689552, 2131689553, 2131689554 };
    CeO = aj.getPackageName() + "chat_footer_sp";
    AppMethodBeat.o(31717);
  }
  
  public ChatFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooter(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31573);
    this.hFi = null;
    this.tqv = null;
    this.fPz = null;
    this.Cby = null;
    this.CbR = null;
    this.CbS = null;
    this.CbT = null;
    this.CbU = new a((byte)0);
    this.CbV = false;
    this.CbW = false;
    this.CbX = false;
    this.omf = false;
    this.Cce = false;
    this.Ccf = false;
    this.Ccg = false;
    this.BWK = false;
    this.Cch = true;
    this.Cci = false;
    this.Ccj = 0;
    this.Cck = -1;
    this.Cco = 0;
    this.srJ = false;
    this.Ccp = false;
    this.Ccq = true;
    this.Ccr = false;
    this.Ccv = false;
    this.Ccw = null;
    this.Ccx = new x.a()
    {
      public final void hide()
      {
        AppMethodBeat.i(184906);
        if (ChatFooter.a(ChatFooter.this) != null) {
          ChatFooter.a(ChatFooter.this).setBackgroundResource(2131232870);
        }
        AppMethodBeat.o(184906);
      }
      
      public final void show()
      {
        AppMethodBeat.i(184905);
        if (ChatFooter.a(ChatFooter.this) != null) {
          ChatFooter.a(ChatFooter.this).setBackgroundResource(2131232871);
        }
        AppMethodBeat.o(184905);
      }
    };
    this.Ccy = new d.c()
    {
      public final int cFo()
      {
        AppMethodBeat.i(185759);
        if (ChatFooter.b(ChatFooter.this) != null)
        {
          int i = ChatFooter.b(ChatFooter.this).cFo();
          AppMethodBeat.o(185759);
          return i;
        }
        AppMethodBeat.o(185759);
        return 0;
      }
      
      public final boolean cFp()
      {
        AppMethodBeat.i(185760);
        if (ChatFooter.c(ChatFooter.this) == 0)
        {
          AppMethodBeat.o(185760);
          return true;
        }
        AppMethodBeat.o(185760);
        return false;
      }
    };
    this.Ccz = new com.tencent.mm.g.b.a.c();
    this.CcC = new m.a()
    {
      public final void clear()
      {
        AppMethodBeat.i(185778);
        ChatFooter.this.cFq();
        AppMethodBeat.o(185778);
      }
    };
    this.mHandler = new com.tencent.mm.sdk.platformtools.ap()
    {
      @SuppressLint({"NewApi"})
      @TargetApi(11)
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(185786);
        switch (paramAnonymousMessage.what)
        {
        }
        do
        {
          AppMethodBeat.o(185786);
          return;
        } while ((ChatFooter.d(ChatFooter.this) == null) || (paramAnonymousMessage.obj == null));
        boolean bool = ((Boolean)paramAnonymousMessage.obj).booleanValue();
        if (bool) {
          ChatFooter.d(ChatFooter.this).setAlpha(1.0F);
        }
        for (;;)
        {
          ChatFooter.a(ChatFooter.this, bool);
          break;
          ChatFooter.d(ChatFooter.this).setAlpha(0.5F);
        }
      }
    };
    this.CcD = false;
    this.fNO = false;
    paramAttributeSet = com.tencent.mm.plugin.transvoice.a.c.yWx;
    this.Cdg = com.tencent.mm.plugin.transvoice.a.c.dQE();
    this.Cdh = ChatFooter.l.CfS;
    this.Cdi = j.CfK;
    this.Cdj = k.CfO;
    this.Cdk = false;
    this.Cdl = false;
    this.Cdm = false;
    this.Cdn = 0.5F;
    this.Cea = true;
    this.Ceb = new ChatFooterPanel.a()
    {
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(185772);
        ChatFooter.ap(ChatFooter.this);
        ChatFooter.at(ChatFooter.this);
        ChatFooter.x(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.as(ChatFooter.this);
        try
        {
          ChatFooter.d(ChatFooter.this).aMd(paramAnonymousString);
          ChatFooter.this.Ccz.dFq += 1L;
          AppMethodBeat.o(185772);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.ChatFooter", paramAnonymousString, "", new Object[0]);
          }
        }
      }
      
      public final void btF()
      {
        AppMethodBeat.i(185771);
        ChatFooter.ap(ChatFooter.this);
        ChatFooter.at(ChatFooter.this);
        ChatFooter.x(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.as(ChatFooter.this);
        InputConnection localInputConnection = ChatFooter.d(ChatFooter.this).getInputConnection();
        if (localInputConnection != null)
        {
          localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
          localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
        }
        ChatFooter.this.Ccz.dFq -= 1L;
        AppMethodBeat.o(185771);
      }
      
      public final void cqY()
      {
        AppMethodBeat.i(185769);
        ChatFooter.ap(ChatFooter.this);
        ChatFooter.aq(ChatFooter.this).setVisibility(0);
        ChatFooter.ar(ChatFooter.this).setVisibility(0);
        ChatFooter.x(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.as(ChatFooter.this);
        if (ChatFooter.k(ChatFooter.this) != null) {
          ChatFooter.k(ChatFooter.this).performClick();
        }
        AppMethodBeat.o(185769);
      }
      
      public final void lf(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185770);
        ad.i("MicroMsg.ChatFooter", "onToSendTextEnable: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        ChatFooter.ap(ChatFooter.this);
        ChatFooter.at(ChatFooter.this);
        ChatFooter.x(ChatFooter.this).setVisibility(8);
        ChatFooter.as(ChatFooter.this);
        if (ChatFooter.d(ChatFooter.this) != null) {
          ChatFooter.this.setToSendTextColor(paramAnonymousBoolean);
        }
        AppMethodBeat.o(185770);
      }
    };
    this.Cec = new AppPanel.b()
    {
      public final void eyM()
      {
        AppMethodBeat.i(185773);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ChatFooter.e(ChatFooter.this), "android.permission.RECORD_AUDIO", 80, "", "");
        ad.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), ChatFooter.e(ChatFooter.this) });
        if (!bool)
        {
          AppMethodBeat.o(185773);
          return;
        }
        int i = az.aeS().auR();
        if ((i == 4) || (i == 6))
        {
          ChatFooter.au(ChatFooter.this);
          AppMethodBeat.o(185773);
          return;
        }
        if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
          ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.h.j(ChatFooter.this.getContext(), 2131764895, 2131755906));
        }
        AppMethodBeat.o(185773);
      }
    };
    this.Ced = new ChatFooter.b()
    {
      public final com.tencent.mm.ui.chatting.h.b ezT()
      {
        return null;
      }
      
      public final String getTalkerUserName()
      {
        AppMethodBeat.i(191286);
        if (ChatFooter.f(ChatFooter.this) == null)
        {
          str = ChatFooter.av(ChatFooter.this);
          AppMethodBeat.o(191286);
          return str;
        }
        String str = ChatFooter.f(ChatFooter.this).getTalkerUserName();
        AppMethodBeat.o(191286);
        return str;
      }
    };
    this.oms = new com.tencent.mm.sdk.platformtools.ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(191291);
        super.handleMessage(paramAnonymousMessage);
        ad.d("MicroMsg.ChatFooter", "pennqin, dismiss window by too short.");
        ChatFooter.x(ChatFooter.this).setBackgroundResource(2131232725);
        ChatFooter.x(ChatFooter.this).setEnabled(true);
        if (ChatFooter.this.Cdm)
        {
          ChatFooter.ay(ChatFooter.this);
          AppMethodBeat.o(191291);
          return;
        }
        if (ChatFooter.L(ChatFooter.this) != null) {
          ChatFooter.L(ChatFooter.this).dismiss();
        }
        AppMethodBeat.o(191291);
      }
    };
    this.Cef = 0;
    this.Ceg = false;
    this.Ceh = 1;
    this.Cei = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(191292);
        int i;
        int j;
        int m;
        int k;
        if (paramAnonymousEditable != null)
        {
          i = ChatFooter.az(ChatFooter.this).getWidth();
          j = ChatFooter.aA(ChatFooter.this).getLineCount();
          m = j - ChatFooter.aB(ChatFooter.this);
          if ((m != 0) && (ChatFooter.this.Cfb == ChatFooter.e.Cfy) && (i == ChatFooter.aC(ChatFooter.this)))
          {
            i = ao.fromDPToPix(ChatFooter.this.getContext(), 5);
            k = ChatFooter.aA(ChatFooter.this).getLineHeight() * m;
            if (m <= 0) {
              break label251;
            }
            m = ChatFooter.az(ChatFooter.this).getHeight();
            if (!ChatFooter.this.srJ) {
              break label257;
            }
            ChatFooter.c(ChatFooter.this, Math.min(Math.max(ChatFooter.aD(ChatFooter.this), i + (m + k)), ChatFooter.aE(ChatFooter.this)));
          }
        }
        for (;;)
        {
          ad.d("MicroMsg.ChatFooter", "afterTextChanged transHeight:%s, nowLineCount:%s, lastLineCount:%s", new Object[] { Integer.valueOf(ChatFooter.aG(ChatFooter.this)), Integer.valueOf(j), Integer.valueOf(ChatFooter.aB(ChatFooter.this)) });
          ChatFooter.aH(ChatFooter.this);
          ChatFooter.d(ChatFooter.this, j);
          if (1 == ChatFooter.z(ChatFooter.this).yWv) {
            ChatFooter.z(ChatFooter.this).yWu = 1;
          }
          AppMethodBeat.o(191292);
          return;
          label251:
          i = -i;
          break;
          label257:
          ChatFooter.c(ChatFooter.this, Math.min(Math.max(ChatFooter.aD(ChatFooter.this), i + (m + k)), ChatFooter.aF(ChatFooter.this)));
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.Cej = ValueAnimator.ofInt(new int[] { 250, 960 }).setDuration(200L);
    this.Cek = ValueAnimator.ofInt(new int[] { 40, 800 }).setDuration(200L);
    this.Cel = ValueAnimator.ofInt(new int[] { 72, 0 }).setDuration(200L);
    this.Cem = ValueAnimator.ofInt(new int[] { 22, 0 }).setDuration(200L);
    this.Cen = ValueAnimator.ofInt(new int[] { 8, 0 }).setDuration(200L);
    this.Ceo = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(179771);
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)ChatFooter.bb(ChatFooter.this).getLayoutParams();
        FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)ChatFooter.bc(ChatFooter.this).getLayoutParams();
        if (ChatFooter.this.Cej == paramAnonymousValueAnimator)
        {
          localLayoutParams1.width = ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          localLayoutParams2.width = ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        }
        for (;;)
        {
          ChatFooter.bb(ChatFooter.this).setLayoutParams(localLayoutParams1);
          ChatFooter.bc(ChatFooter.this).setLayoutParams(localLayoutParams2);
          AppMethodBeat.o(179771);
          return;
          if (ChatFooter.this.Cek == paramAnonymousValueAnimator)
          {
            localLayoutParams1.height = ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.height = ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Cel == paramAnonymousValueAnimator)
          {
            localLayoutParams1.topMargin = ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.topMargin = ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Cem == paramAnonymousValueAnimator)
          {
            localLayoutParams1.rightMargin = ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.rightMargin = ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Cen == paramAnonymousValueAnimator)
          {
            localLayoutParams1.bottomMargin = ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.bottomMargin = ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        }
      }
    };
    this.Cep = new int[] { 2131689996, 2131689997, 2131689998, 2131689999, 2131690000, 2131690001, 2131690002, 2131690003, 2131690004, 2131690005 };
    this.ANIMATION_DURATION = 200L;
    this.Ceq = 60;
    this.Cer = ao.fromDPToPix(getContext(), 114);
    this.Ces = (com.tencent.mm.ui.ap.cf(getContext()).x - ao.fromDPToPix(getContext(), 32));
    this.Cet = ao.fromDPToPix(getContext(), 92);
    this.Ceu = Math.min(ao.fromDPToPix(getContext(), 320), com.tencent.mm.ui.ap.cf(getContext()).x - ao.fromDPToPix(getContext(), 32));
    this.Cev = ao.fromDPToPix(getContext(), 176);
    this.Cew = (ao.fromDPToPix(getContext(), 160) / 50.0F);
    this.Cex = ao.fromDPToPix(getContext(), 114);
    this.maxHeight = 0;
    this.Cey = 0;
    this.Cez = 0;
    this.CeA = 0;
    this.CeB = ao.fromDPToPix(getContext(), 176);
    this.CeC = 60;
    this.CeF = 0;
    this.CeG = false;
    this.CeH = 4097;
    this.CeI = 4098;
    this.CeK = new com.tencent.mm.sdk.platformtools.ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(191308);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(191308);
          return;
          ChatFooter.h(ChatFooter.this, true);
          paramAnonymousMessage = ChatFooter.bm(ChatFooter.this).getLayoutParams();
          int i = ChatFooter.bm(ChatFooter.this).getBottom() - ChatFooter.bm(ChatFooter.this).getTop();
          if (ChatFooter.this.ezq())
          {
            if (ChatFooter.v(ChatFooter.this) != null) {
              ChatFooter.v(ChatFooter.this).setVisibility(8);
            }
            ChatFooter.this.setAppPanelVisible(8);
            ChatFooter.bm(ChatFooter.this).setVisibility(4);
          }
          if (i <= 3)
          {
            ChatFooter.h(ChatFooter.this, false);
            ChatFooter.bm(ChatFooter.this).setVisibility(4);
            ChatFooter.g(ChatFooter.this, ChatFooter.this.getKeyBordHeightPX());
            AppMethodBeat.o(191308);
            return;
          }
          paramAnonymousMessage.height = Math.max(i - 60, 1);
          ad.e("MicroMsg.ChatFooter", "mBottomPanelAnim:bottomPanel height:" + paramAnonymousMessage.height);
          ChatFooter.bm(ChatFooter.this).setLayoutParams(paramAnonymousMessage);
          ChatFooter.bn(ChatFooter.this);
        }
      }
    };
    this.CeL = false;
    this.CeM = 0;
    this.CeN = false;
    this.CeP = -1;
    this.CeQ = null;
    this.CeR = ao.ap(getContext(), 2131165229);
    this.CeS = ao.ap(getContext(), 2131165294);
    this.CeT = ao.fromDPToPix(getContext(), 25);
    this.CeU = ao.fromDPToPix(getContext(), 55);
    this.CeV = 0;
    this.CeW = ao.fromDPToPix(getContext(), 50);
    this.CeX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(191316);
        ChatFooter.this.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(191315);
            if (ChatFooter.k.CfQ == ChatFooter.ai(ChatFooter.this))
            {
              ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764709));
              ChatFooter.al(ChatFooter.this);
            }
            for (;;)
            {
              ChatFooter.br(ChatFooter.this);
              AppMethodBeat.o(191315);
              return;
              ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764713));
              ChatFooter.aj(ChatFooter.this);
            }
          }
        }, 100L);
        AppMethodBeat.o(191316);
      }
    };
    this.CeY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(191317);
        ChatFooter.H(ChatFooter.this).dismiss();
        AppMethodBeat.o(191317);
      }
    };
    this.CeZ = ao.fromDPToPix(getContext(), 16);
    this.Cfa = ao.fromDPToPix(getContext(), 25);
    this.Cfb = e.Cfw;
    this.Cfc = this.Cfb;
    this.Cfd = new HashMap();
    this.Cfe = false;
    this.yYs = new com.tencent.mm.modelvoiceaddr.b.b();
    this.yYt = new ArrayList();
    this.yYf = "";
    this.yYg = 0;
    this.yYi = false;
    this.yVZ = com.tencent.mm.modelvoiceaddr.g.hEm;
    long l = System.currentTimeMillis();
    this.Ccb = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.hFi = inflate(paramContext, 2131493397, this);
    this.tqv = ((MMEditText)this.hFi.findViewById(2131298072));
    this.ftZ = new com.tencent.mm.ui.tools.h((Activity)paramContext);
    this.ftZ.Hro = this;
    this.CbT = ((ClipboardManager)paramContext.getApplicationContext().getSystemService("clipboard"));
    if (ai.eRQ()) {
      this.tqv.setImeOptions(268435456);
    }
    com.tencent.mm.ui.tools.b.c.d(this.tqv).aaj(bt.getInt(com.tencent.mm.m.g.Zd().getValue("InputLimitSessionTextMsg"), 8192) * 2).a(null);
    this.tqv.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
    this.tqv.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {}
    });
    if (Build.VERSION.SDK_INT == 28) {
      this.tqv.setBreakStrategy(1);
    }
    paramAttributeSet = new pv();
    paramAttributeSet.dvv.dvx = this.tqv;
    paramAttributeSet.dvv.dvw = new com.tencent.mm.pluginsdk.ui.a.a()
    {
      public final void aBI(final String paramAnonymousString)
      {
        AppMethodBeat.i(185818);
        ad.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", new Object[] { paramAnonymousString });
        if ((bt.isNullOrNil(ChatFooter.f(ChatFooter.this).getTalkerUserName())) || (bt.isNullOrNil(paramAnonymousString)))
        {
          ad.e("MicroMsg.ChatFooter", "onImageReceived, error args");
          AppMethodBeat.o(185818);
          return;
        }
        com.tencent.mm.ui.base.h.a(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(2131758654), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2Int = 1;
            AppMethodBeat.i(185817);
            boolean bool = u.f(paramAnonymousString, ChatFooter.f(ChatFooter.this).getTalkerUserName(), true);
            paramAnonymous2DialogInterface = ChatFooter.this;
            if (bool) {}
            for (;;)
            {
              ChatFooter.a(paramAnonymous2DialogInterface, paramAnonymous2Int, paramAnonymousString);
              AppMethodBeat.o(185817);
              return;
              paramAnonymous2Int = 0;
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(185818);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.l(paramAttributeSet);
    this.CbJ = ((LinearLayout)this.hFi.findViewById(2131305724));
    this.CbH = this.hFi.findViewById(2131305739);
    this.CbC = ((ChatFooterBottom)findViewById(2131298067));
    this.hSI = ((ViewGroup)findViewById(2131297957));
    this.CbB = findViewById(2131298090);
    this.CbE = ((ImageButton)this.hFi.findViewById(2131298054));
    this.CbF = ((ImageView)this.hFi.findViewById(2131298055));
    this.fPz = ((Button)this.hFi.findViewById(2131298168));
    this.CbK = ((RelativeLayout)this.hFi.findViewById(2131302539));
    this.CbL = ((TextView)this.hFi.findViewById(2131302537));
    this.CbM = ((WeImageView)this.hFi.findViewById(2131302538));
    this.fPz.setTextSize(0, com.tencent.mm.cd.a.ap(paramContext, 2131165563) * com.tencent.mm.cd.a.hQ(paramContext));
    this.Cbz = ((Button)this.hFi.findViewById(2131306529));
    this.CbA = ((ImageButton)findViewById(2131298149));
    mU(false);
    ezz();
    this.CbN = new i(getContext(), getRootView(), this, new i.a()
    {
      public final void aCf(String paramAnonymousString)
      {
        AppMethodBeat.i(185752);
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(paramAnonymousString);
        if (ChatFooter.g(ChatFooter.this) != null) {
          localIntent.putExtra("GalleryUI_FromUser", ChatFooter.g(ChatFooter.this));
        }
        if (ChatFooter.h(ChatFooter.this) != null) {
          localIntent.putExtra("GalleryUI_ToUser", ChatFooter.h(ChatFooter.this));
        }
        localIntent.putExtra("query_source_type", 3);
        localIntent.putExtra("preview_image", true);
        localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
        localIntent.putExtra("max_select_count", 1);
        localIntent.addFlags(67108864);
        if (ChatFooter.i(ChatFooter.this) != null)
        {
          com.tencent.mm.bs.d.a(ChatFooter.i(ChatFooter.this), "gallery", ".ui.GalleryEntryUI", localIntent, 217);
          AppMethodBeat.o(185752);
          return;
        }
        com.tencent.mm.bs.d.b(paramContext, "gallery", ".ui.GalleryEntryUI", localIntent, 217);
        AppMethodBeat.o(185752);
      }
    });
    this.CbN.Cgr = this;
    paramAttributeSet = getContext();
    getRootView();
    this.CbO = new m(paramAttributeSet);
    this.CbO.CcC = this.CcC;
    ad.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[] { Integer.valueOf(this.tqv.getImeOptions()) });
    this.tqv.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(185753);
        if ((paramAnonymousInt == 4) || ((paramAnonymousInt == 0) && (ChatFooter.j(ChatFooter.this))))
        {
          ChatFooter.k(ChatFooter.this).performClick();
          AppMethodBeat.o(185753);
          return true;
        }
        AppMethodBeat.o(185753);
        return false;
      }
    });
    this.tqv.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(185754);
        ChatFooter.this.setToSendTextColor(true);
        if (ChatFooter.l(ChatFooter.this) != null) {
          ChatFooter.l(ChatFooter.this).W(paramAnonymousMotionEvent);
        }
        ChatFooter.m(ChatFooter.this);
        AppMethodBeat.o(185754);
        return false;
      }
    });
    this.tqv.setOnLongClickListener(new ChatFooter.5(this, paramContext));
    this.tqv.setCustomSelectionActionModeCallback(new ChatFooter.6(this, paramContext));
    this.fPz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool2 = true;
        for (;;)
        {
          boolean bool1;
          label258:
          try
          {
            AppMethodBeat.i(31499);
            paramAnonymousView = ChatFooter.d(ChatFooter.this).getText().toString();
            ad.i("MicroMsg.ChatFooter", "send msg onClick");
            if ((paramAnonymousView.trim().length() == 0) && (paramAnonymousView.length() != 0))
            {
              ad.d("MicroMsg.ChatFooter", "empty message cant be sent");
              if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
                ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.h.j(ChatFooter.this.getContext(), 2131757154, 2131755906));
              }
              ChatFooter.this.ezw();
              AppMethodBeat.o(31499);
              return;
            }
            ChatFooter.c(ChatFooter.this, false);
            int i = ChatFooter.d(ChatFooter.this).getPasterLen();
            ad.i("MicroMsg.ChatFooter", "pasteLen %d", new Object[] { Integer.valueOf(i) });
            if ((i > 0) && (ChatFooter.o(ChatFooter.this) != null))
            {
              localObject = ChatFooter.o(ChatFooter.this).getText();
              if ((localObject != null) && (bt.nullAsNil(((CharSequence)localObject).toString()).equals(paramAnonymousView)))
              {
                ad.i("MicroMsg.ChatFooter", "paste clip board to send");
                ChatFooter.c(ChatFooter.this, true);
              }
            }
            if (ChatFooter.p(ChatFooter.this) == null) {
              break label328;
            }
            Object localObject = ChatFooter.p(ChatFooter.this);
            if (((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).ssc == null) {
              break label323;
            }
            bool1 = ((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).ssc.isShowing();
          }
          finally {}
          if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0) && (ChatFooter.l(ChatFooter.this) != null)) {
            ChatFooter.this.cFq();
          }
          ChatFooter.a(ChatFooter.this, paramAnonymousView.length());
          if (ChatFooter.a(ChatFooter.this, paramAnonymousView))
          {
            ad.i("MicroMsg.ChatFooter", "this is a quote msg");
            continue;
            label323:
            bool1 = false;
          }
          else
          {
            label328:
            while (!bool1)
            {
              bool1 = false;
              break label258;
              if (ChatFooter.a(ChatFooter.this, paramAnonymousView, bool1))
              {
                ad.i("MicroMsg.ChatFooter", "this is a group solitatire msg");
                break;
              }
              if ((ChatFooter.l(ChatFooter.this) == null) || (!ChatFooter.l(ChatFooter.this).afG(paramAnonymousView))) {
                break;
              }
              ChatFooter.q(ChatFooter.this);
              ChatFooter.d(ChatFooter.this).clearComposingText();
              break;
            }
            bool1 = bool2;
          }
        }
      }
    });
    if (ai.eRP()) {}
    label2279:
    for (;;)
    {
      boolean bool = false;
      label1655:
      this.Cdm = bool;
      this.Cdn = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxp, 0.5F);
      ad.i("MicroMsg.ChatFooter", "isNewTrans2Txt:%s, transOperationAreaFactor:%s", new Object[] { Boolean.valueOf(this.Cdm), Float.valueOf(this.Cdn) });
      this.Cdd = new com.tencent.mm.plugin.transvoice.a.a();
      if (this.Cdm)
      {
        this.CdZ = ((int)(com.tencent.mm.cd.a.hV(paramContext) * this.Cdn));
        ad.d("MicroMsg.ChatFooter", "newVoice2txtVoiceModeChangeLine: %s, newVoice2txtTransModeChangeLine: %s.", new Object[] { Integer.valueOf(this.CdY), Integer.valueOf(this.CdZ) });
        this.Cbz.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(31512);
            if (paramAnonymousView != ChatFooter.x(ChatFooter.this))
            {
              AppMethodBeat.o(31512);
              return false;
            }
            if (ChatFooter.this.Cfb == ChatFooter.e.Cfw)
            {
              ChatFooter.b(ChatFooter.this, com.tencent.mm.ui.ap.cf(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(2131166976) - com.tencent.mm.ui.aq.eb(paramContext));
              switch (paramAnonymousMotionEvent.getAction())
              {
              }
            }
            for (;;)
            {
              AppMethodBeat.o(31512);
              return true;
              ChatFooter.b(ChatFooter.this, com.tencent.mm.ui.ap.cf(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(2131166976) - com.tencent.mm.ui.aq.eb(paramContext) + ChatFooter.y(ChatFooter.this));
              break;
              ChatFooter.z(ChatFooter.this).yWs = 1;
              paramAnonymousView = com.tencent.mm.cl.a.FFw;
              com.tencent.mm.cl.a.vg(false);
              ChatFooter.z(ChatFooter.this).lKF = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).yWf = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.z(ChatFooter.this).yWg = ((int)paramAnonymousMotionEvent.getRawY());
              ChatFooter.a(ChatFooter.this, null);
              long l = System.nanoTime();
              ChatFooter.a(ChatFooter.this, new com.tencent.mm.modelvoiceaddr.h(String.valueOf(l & 0xFFFFFFFF)));
              ChatFooter.B(ChatFooter.this).b(ChatFooter.A(ChatFooter.this));
              if ((ChatFooter.this.getContext() instanceof Activity)) {
                ((Activity)ChatFooter.this.getContext()).getWindow().addFlags(128);
              }
              ChatFooter.x(ChatFooter.this).setBackgroundResource(2131233811);
              ChatFooter.x(ChatFooter.this).setText(2131757094);
              if (ChatFooter.l(ChatFooter.this) != null) {
                ChatFooter.l(ChatFooter.this).cNZ();
              }
              ChatFooter.x(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757050));
              continue;
              if ((ChatFooter.C(ChatFooter.this) == null) || (!ChatFooter.C(ChatFooter.this).isShowing()))
              {
                ad.e("MicroMsg.NewVoice2txt", "window status err!!!");
              }
              else if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getX() < ChatFooter.x(ChatFooter.this).getWidth()) && (paramAnonymousMotionEvent.getRawY() > ChatFooter.D(ChatFooter.this)))
              {
                if (ChatFooter.this.Cfb != ChatFooter.e.Cfw)
                {
                  ChatFooter.this.Cfc = ChatFooter.this.Cfb;
                  ChatFooter.this.Cfb = ChatFooter.e.Cfw;
                  ChatFooter.E(ChatFooter.this);
                }
              }
              else if (paramAnonymousMotionEvent.getRawX() > ChatFooter.F(ChatFooter.this))
              {
                if (ChatFooter.e.Cfy != ChatFooter.this.Cfb)
                {
                  ChatFooter.this.Cfc = ChatFooter.this.Cfb;
                  ChatFooter.this.Cfb = ChatFooter.e.Cfy;
                  ChatFooter.E(ChatFooter.this);
                }
              }
              else if (ChatFooter.e.Cfx != ChatFooter.this.Cfb)
              {
                ChatFooter.this.Cfc = ChatFooter.this.Cfb;
                ChatFooter.this.Cfb = ChatFooter.e.Cfx;
                ChatFooter.E(ChatFooter.this);
                continue;
                ad.d("MicroMsg.NewVoice2txt", "begin finishCutShortSentence.");
                ChatFooter.B(ChatFooter.this).dQB();
                ad.d("MicroMsg.NewVoice2txt", "end finishCutShortSentence.");
                ChatFooter.z(ChatFooter.this).yWh = System.currentTimeMillis();
                ChatFooter.z(ChatFooter.this).yWi = ((int)paramAnonymousMotionEvent.getRawX());
                ChatFooter.z(ChatFooter.this).yWj = ((int)paramAnonymousMotionEvent.getRawY());
                if ((ChatFooter.this.yYa != null) && (ChatFooter.G(ChatFooter.this)))
                {
                  ChatFooter.this.yYa.yWa = false;
                  paramAnonymousView = ChatFooter.this.yYa;
                  ad.d("MicroMsg.SceneVoiceInputAddr2", "reTrigger!!! canReTrigger: %s.", new Object[] { Boolean.valueOf(paramAnonymousView.yWb) });
                  if ((paramAnonymousView.yWb) && ((!((com.tencent.mm.modelvoiceaddr.c)paramAnonymousView.hEj).aDM()) || (!com.tencent.mm.kernel.g.aeS().a(paramAnonymousView.hEj, 0)))) {
                    paramAnonymousView.dQD();
                  }
                }
                if ((ChatFooter.this.getContext() instanceof Activity)) {
                  ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                }
                ChatFooter.this.ezy();
              }
            }
          }
        });
        this.Cej.addUpdateListener(this.Ceo);
        this.Cek.addUpdateListener(this.Ceo);
        this.Cel.addUpdateListener(this.Ceo);
        this.Cem.addUpdateListener(this.Ceo);
        this.Cen.addUpdateListener(this.Ceo);
      }
      for (;;)
      {
        this.CbA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185761);
            ChatFooter.w(ChatFooter.this);
            AppMethodBeat.o(185761);
          }
        });
        eyW();
        this.CbE.setVisibility(0);
        this.CbE.setContentDescription(getContext().getString(2131757042));
        this.CbE.setOnClickListener(new ChatFooter.11(this));
        ad.i("MicroMsg.ChatFooter", "[init]");
        this.CbB.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return true;
          }
        });
        this.Ccn = (((Activity)paramContext).getWindow().getAttributes().softInputMode & 0xF0);
        if ((this.Ccn != 16) && (this.Ccn != 48))
        {
          com.tencent.mm.plugin.report.service.h.vKh.dB(1062, 8);
          if (this.Ccn != 16) {
            this.Ccn = 48;
          }
        }
        this.Cct = z.in(paramContext);
        Vf(getKeyBordHeightPX());
        if (com.tencent.mm.compatible.util.d.lf(24)) {
          this.Ccp = ((Activity)getContext()).isInMultiWindowMode();
        }
        eyV();
        this.CbM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31502);
            ChatFooter.q(ChatFooter.this);
            AppMethodBeat.o(31502);
          }
        });
        ad.d("MicroMsg.ChatFooter", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(31573);
        return;
        if (aov()) {
          break;
        }
        paramAttributeSet = ac.ir(aj.getContext());
        if ((!paramAttributeSet.equals("zh_CN")) && (!paramAttributeSet.equals("zh_HK")) && (!paramAttributeSet.equals("zh_TW")) && (!paramAttributeSet.equals("en"))) {
          break;
        }
        if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
        {
          bool = true;
          break label1655;
        }
        if (1 != ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxo, 1)) {
          break label2279;
        }
        bool = true;
        break label1655;
        CcI = com.tencent.mm.cd.a.hV(paramContext) / 2 + com.tencent.mm.cd.a.fromDPToPix(paramContext, 30);
        this.Cdc = new com.tencent.mm.plugin.transvoice.ui.b(paramContext);
        this.Cdc.yYv = new b.d()
        {
          public final boolean a(String paramAnonymousString, Long paramAnonymousLong)
          {
            AppMethodBeat.i(185765);
            ad.i("MicroMsg.ChatFooter", "onVoiceMsgSend, fileName: %s.", new Object[] { paramAnonymousString });
            if (paramAnonymousLong != null) {}
            for (int i = paramAnonymousLong.intValue();; i = 0)
            {
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                boolean bool = ChatFooter.l(ChatFooter.this).dC(paramAnonymousString, i);
                AppMethodBeat.o(185765);
                return bool;
              }
              AppMethodBeat.o(185765);
              return false;
            }
          }
          
          public final void asS(final String paramAnonymousString)
          {
            AppMethodBeat.i(185764);
            ChatFooter.this.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(185762);
                ad.i("MicroMsg.ChatFooter", "onTxtMsgSend, msg is null or nil? %s.", new Object[] { Boolean.valueOf(bt.isNullOrNil(paramAnonymousString)) });
                if ((ChatFooter.l(ChatFooter.this) != null) && (!bt.isNullOrNil(paramAnonymousString))) {
                  ChatFooter.l(ChatFooter.this).afG(paramAnonymousString);
                }
                AppMethodBeat.o(185762);
              }
            }, 200L);
            AppMethodBeat.o(185764);
          }
          
          public final void asT(String paramAnonymousString)
          {
            AppMethodBeat.i(185766);
            if (ChatFooter.l(ChatFooter.this) != null) {
              ChatFooter.l(ChatFooter.this).afH(paramAnonymousString);
            }
            AppMethodBeat.o(185766);
          }
          
          public final void dQS()
          {
            AppMethodBeat.i(185763);
            if (ChatFooter.H(ChatFooter.this).isShowing()) {
              ChatFooter.H(ChatFooter.this).dismiss();
            }
            ChatFooter.I(ChatFooter.this);
            AppMethodBeat.o(185763);
          }
        };
        this.Cbz.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(185767);
            if (paramAnonymousView != ChatFooter.x(ChatFooter.this))
            {
              AppMethodBeat.o(185767);
              return false;
            }
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(185767);
              return true;
              ad.i("MicroMsg.RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[] { Integer.valueOf(ChatFooter.cKs()) });
              paramAnonymousView = com.tencent.mm.cl.a.FFw;
              com.tencent.mm.cl.a.vg(false);
              ChatFooter.z(ChatFooter.this).lKF = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).yWf = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.z(ChatFooter.this).yWg = ((int)paramAnonymousMotionEvent.getRawY());
              ChatFooter.J(ChatFooter.this);
              if ((ChatFooter.K(ChatFooter.this)) && (ChatFooter.L(ChatFooter.this) != null))
              {
                ChatFooter.M(ChatFooter.this);
                if (ChatFooter.N(ChatFooter.this) != null) {
                  ChatFooter.N(ChatFooter.this).getBlurController().destroy();
                }
                if (ChatFooter.O(ChatFooter.this) != null) {
                  ChatFooter.O(ChatFooter.this).getBlurController().destroy();
                }
              }
              ad.i("MicroMsg.RcdBtnEvent", "trans voice opener: %s, blur mode opener: %s.", new Object[] { Boolean.valueOf(ChatFooter.P(ChatFooter.this)), ChatFooter.Q(ChatFooter.this) });
              if (ChatFooter.P(ChatFooter.this)) {}
              for (ChatFooter.z(ChatFooter.this).yWs = 1;; ChatFooter.z(ChatFooter.this).yWs = 0)
              {
                ChatFooter.a(ChatFooter.this, null);
                long l = System.nanoTime();
                ChatFooter.a(ChatFooter.this, new com.tencent.mm.modelvoiceaddr.h(String.valueOf(l & 0xFFFFFFFF)));
                ChatFooter.B(ChatFooter.this).b(ChatFooter.A(ChatFooter.this));
                if ((ChatFooter.this.getContext() instanceof Activity)) {
                  ((Activity)ChatFooter.this.getContext()).getWindow().addFlags(128);
                }
                if ((ChatFooter.R(ChatFooter.this)) || (ChatFooter.S(ChatFooter.this))) {
                  break;
                }
                ChatFooter.d(ChatFooter.this, true);
                ChatFooter.x(ChatFooter.this).setBackgroundResource(2131233811);
                ChatFooter.x(ChatFooter.this).setText(2131757094);
                if (ChatFooter.l(ChatFooter.this) != null) {
                  ChatFooter.l(ChatFooter.this).cNZ();
                }
                ChatFooter.x(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757050));
                break;
              }
              if ((ChatFooter.L(ChatFooter.this) == null) || (!ChatFooter.L(ChatFooter.this).isShowing()))
              {
                if (ChatFooter.L(ChatFooter.this) == null) {}
                for (boolean bool = true;; bool = false)
                {
                  ad.e("MicroMsg.RcdBtnEvent", "hint window status err, window is null: %s.", new Object[] { Boolean.valueOf(bool) });
                  break;
                }
              }
              if (ChatFooter.P(ChatFooter.this))
              {
                if ((ChatFooter.T(ChatFooter.this) == null) || (ChatFooter.U(ChatFooter.this) == null)) {
                  ad.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! voice2txtRealHintArea is %s, voice2txtOpeLayout is %s.", new Object[] { ChatFooter.T(ChatFooter.this), ChatFooter.U(ChatFooter.this) });
                }
                if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getY() > -ChatFooter.V(ChatFooter.this) / 3) && (paramAnonymousMotionEvent.getX() < ChatFooter.x(ChatFooter.this).getWidth()))
                {
                  if (ChatFooter.W(ChatFooter.this) != ChatFooter.l.CfT)
                  {
                    ad.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_1.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.CfT);
                    if (ChatFooter.X(ChatFooter.this))
                    {
                      ChatFooter.Y(ChatFooter.this).animate().cancel();
                      ChatFooter.Z(ChatFooter.this).animate().cancel();
                      if (ChatFooter.j.CfL == ChatFooter.Q(ChatFooter.this))
                      {
                        ChatFooter.N(ChatFooter.this).setAlpha(0.5F);
                        ChatFooter.N(ChatFooter.this).animate().alpha(1.0F).setDuration(300L).start();
                        ChatFooter.N(ChatFooter.this).Yj(ChatFooter.this.getResources().getColor(2131101069)).G(ChatFooter.e(ChatFooter.this).getWindow().getDecorView().getBackground()).vY(true);
                      }
                      for (;;)
                      {
                        ChatFooter.H(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(200L).start();
                        ChatFooter.aa(ChatFooter.this).setVisibility(0);
                        ChatFooter.ab(ChatFooter.this).setVisibility(8);
                        ChatFooter.U(ChatFooter.this).setVisibility(8);
                        ChatFooter.a(ChatFooter.this, ChatFooter.k.CfO);
                        ChatFooter.ac(ChatFooter.this);
                        break;
                        ChatFooter.T(ChatFooter.this).setBackgroundResource(2131234483);
                      }
                    }
                  }
                }
                else
                {
                  if (ChatFooter.W(ChatFooter.this) != ChatFooter.l.CfU)
                  {
                    ad.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_2.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.CfU);
                    if (!ChatFooter.X(ChatFooter.this)) {
                      ChatFooter.ad(ChatFooter.this);
                    }
                    ad.i("MicroMsg.RcdBtnEvent", "init rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.ezR()) });
                    if (paramAnonymousMotionEvent.getRawX() > ChatFooter.ezR())
                    {
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.CfP);
                      ad.i("MicroMsg.RcdBtnEvent", "init MODE_TRANS");
                      label1030:
                      if (ChatFooter.j.CfL != ChatFooter.Q(ChatFooter.this)) {
                        break label1308;
                      }
                      ChatFooter.N(ChatFooter.this).Yj(0).G(null).vY(false);
                    }
                    for (;;)
                    {
                      ChatFooter.H(ChatFooter.this).getContentView().animate().alpha(1.0F).setDuration(200L).start();
                      ChatFooter.aa(ChatFooter.this).setVisibility(8);
                      ChatFooter.ab(ChatFooter.this).setVisibility(0);
                      ChatFooter.U(ChatFooter.this).setVisibility(0);
                      ChatFooter.Y(ChatFooter.this).setVisibility(0);
                      ChatFooter.Z(ChatFooter.this).setVisibility(0);
                      ChatFooter.Y(ChatFooter.this).setAlpha(0.0F);
                      ChatFooter.Z(ChatFooter.this).setAlpha(0.0F);
                      ChatFooter.Y(ChatFooter.this).animate().translationX(ChatFooter.ag(ChatFooter.this)).translationY(ChatFooter.af(ChatFooter.this)).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(150L).withEndAction(ChatFooter.ae(ChatFooter.this)).start();
                      ChatFooter.Z(ChatFooter.this).animate().translationX(ChatFooter.ag(ChatFooter.this)).translationY(ChatFooter.af(ChatFooter.this)).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(150L).start();
                      break;
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.CfQ);
                      ad.i("MicroMsg.RcdBtnEvent", "init MODE_CANCEL");
                      break label1030;
                      label1308:
                      ChatFooter.T(ChatFooter.this).setBackgroundColor(0);
                    }
                  }
                  if (ChatFooter.ah(ChatFooter.this))
                  {
                    ad.i("MicroMsg.RcdBtnEvent", "active rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.ezR()) });
                    if ((paramAnonymousMotionEvent.getRawX() > ChatFooter.ezR()) && (ChatFooter.k.CfP != ChatFooter.ai(ChatFooter.this)))
                    {
                      ad.i("MicroMsg.RcdBtnEvent", "active MODE_TRANS.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.CfP);
                      ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764713));
                      ChatFooter.aj(ChatFooter.this);
                      ChatFooter.ak(ChatFooter.this);
                    }
                    else if ((paramAnonymousMotionEvent.getRawX() <= ChatFooter.ezR()) && (ChatFooter.k.CfQ != ChatFooter.ai(ChatFooter.this)))
                    {
                      ad.i("MicroMsg.RcdBtnEvent", "active MODE_CANCEL.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.CfQ);
                      ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764709));
                      ChatFooter.al(ChatFooter.this);
                      ChatFooter.am(ChatFooter.this);
                    }
                  }
                }
              }
              else
              {
                if ((ChatFooter.an(ChatFooter.this) == null) || (ChatFooter.ao(ChatFooter.this) == null)) {
                  ad.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", new Object[] { ChatFooter.an(ChatFooter.this), ChatFooter.ao(ChatFooter.this) });
                }
                if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getY() > -ChatFooter.V(ChatFooter.this) / 2) && (paramAnonymousMotionEvent.getX() < ChatFooter.x(ChatFooter.this).getWidth()))
                {
                  if (ChatFooter.an(ChatFooter.this) != null) {
                    ChatFooter.an(ChatFooter.this).setVisibility(0);
                  }
                  if (ChatFooter.ao(ChatFooter.this) != null)
                  {
                    ChatFooter.x(ChatFooter.this).setText(2131757094);
                    ChatFooter.ao(ChatFooter.this).setVisibility(8);
                  }
                }
                else
                {
                  if (ChatFooter.an(ChatFooter.this) != null) {
                    ChatFooter.an(ChatFooter.this).setVisibility(8);
                  }
                  if (ChatFooter.ao(ChatFooter.this) != null)
                  {
                    ChatFooter.x(ChatFooter.this).setTextSize(0, com.tencent.mm.cd.a.ap(ChatFooter.this.getContext(), 2131165517) * com.tencent.mm.cd.a.hQ(ChatFooter.this.getContext()));
                    ChatFooter.x(ChatFooter.this).setText(2131757078);
                    ChatFooter.ao(ChatFooter.this).setVisibility(0);
                    continue;
                    ChatFooter.B(ChatFooter.this).dQB();
                    if ((ChatFooter.this.getContext() instanceof Activity)) {
                      ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                    }
                    ChatFooter.z(ChatFooter.this).yWh = System.currentTimeMillis();
                    ChatFooter.z(ChatFooter.this).yWi = ((int)paramAnonymousMotionEvent.getRawX());
                    ChatFooter.z(ChatFooter.this).yWj = ((int)paramAnonymousMotionEvent.getRawY());
                    ad.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.cKs()) });
                    ChatFooter.this.ezy();
                    ad.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.ezS()) });
                  }
                }
              }
            }
          }
        });
        this.Cbz.setOnKeyListener(new View.OnKeyListener()
        {
          public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(185768);
            switch (paramAnonymousKeyEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(185768);
              return false;
              if (((paramAnonymousInt == 23) || (paramAnonymousInt == 66)) && (!ChatFooter.S(ChatFooter.this)) && (!ChatFooter.R(ChatFooter.this)))
              {
                ChatFooter.e(ChatFooter.this, true);
                ChatFooter.x(ChatFooter.this).setBackgroundResource(2131233811);
                ChatFooter.x(ChatFooter.this).setText(2131757094);
                if (ChatFooter.l(ChatFooter.this) != null) {
                  ChatFooter.l(ChatFooter.this).cNZ();
                }
                ChatFooter.x(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757050));
                continue;
                if ((paramAnonymousInt == 23) || (paramAnonymousInt == 66))
                {
                  ChatFooter.x(ChatFooter.this).setBackgroundResource(2131232725);
                  ChatFooter.x(ChatFooter.this).setText(2131757093);
                  if (ChatFooter.l(ChatFooter.this) != null) {
                    ChatFooter.l(ChatFooter.this).cNU();
                  }
                  ChatFooter.e(ChatFooter.this, false);
                }
              }
            }
          }
        });
      }
    }
  }
  
  private void UZ(int paramInt)
  {
    AppMethodBeat.i(31593);
    if (this.CbA == null)
    {
      AppMethodBeat.o(31593);
      return;
    }
    if (paramInt == 2131231707) {}
    for (int i = 1;; i = 0)
    {
      if (this.CbA != null)
      {
        if (i == 0) {
          break label83;
        }
        this.CbA.setContentDescription(getContext().getString(2131757049));
      }
      for (;;)
      {
        this.CbA.setImageResource(paramInt);
        this.CbA.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(31593);
        return;
        label83:
        this.CbA.setContentDescription(getContext().getString(2131757048));
      }
    }
  }
  
  private void Ve(int paramInt)
  {
    AppMethodBeat.i(31666);
    if (paramInt == this.Ccj)
    {
      AppMethodBeat.o(31666);
      return;
    }
    if (this.fPz.getVisibility() == 8) {
      ezw();
    }
    if (((paramInt == 0) && (this.CbH.getVisibility() == 8)) || (paramInt == 3) || ((paramInt == 0) && (this.CbH.getVisibility() == 8))) {
      ezw();
    }
    AppMethodBeat.o(31666);
  }
  
  private void Vf(int paramInt)
  {
    AppMethodBeat.i(31680);
    ad.i("MicroMsg.ChatFooter", "[refreshBottomHeight] keyborPx:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.compatible.util.i.eFi();
    int i;
    if ((af.aHH(this.Cbw)) || (af.aHI(this.Cbw)))
    {
      paramInt = com.tencent.mm.compatible.util.i.h(getContext(), paramInt, 43);
      i = com.tencent.mm.api.aa.bh(getContext());
      if ((!this.Cch) || (this.Ccp)) {
        break label353;
      }
    }
    label353:
    for (this.Cct = paramInt;; this.Cct = z.in(getContext()))
    {
      paramInt = Math.max(i, this.Cct);
      this.Ccu = paramInt;
      if (paramInt != this.Ccs) {
        this.Ccs = paramInt;
      }
      ad.i("MicroMsg.ChatFooter", "refreshBottomHeight: %s, %s, %s, %s", new Object[] { Boolean.valueOf(this.Cch), Boolean.valueOf(this.Ccp), Integer.valueOf(this.Cct), Integer.valueOf(this.Ccs) });
      Object localObject = this.CbC.getLayoutParams();
      if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != this.Ccs))
      {
        ((ViewGroup.LayoutParams)localObject).height = this.Ccs;
        this.CbC.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.CbC.requestLayout();
      }
      if (this.Ccm)
      {
        paramInt = -this.Ccs;
        localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
        if ((localObject != null) && (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != paramInt))
        {
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
          setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.Cbx != null)
      {
        this.Cbx.setPortHeighPx(this.Cct);
        this.Cbx.eyI();
      }
      if (this.BWH != null)
      {
        paramInt = this.Cct + this.CbB.getHeight();
        localObject = this.BWH.getLayoutParams();
        if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != paramInt))
        {
          ((ViewGroup.LayoutParams)localObject).height = paramInt;
          this.BWH.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(31680);
      return;
      paramInt = com.tencent.mm.compatible.util.i.ay(getContext(), paramInt);
      break;
    }
  }
  
  private void a(boolean paramBoolean, final Runnable paramRunnable)
  {
    AppMethodBeat.i(31658);
    if (paramBoolean)
    {
      if (this.fSY == null) {
        eyV();
      }
      this.fSY.animate().cancel();
      if ((this.fSY.getVisibility() == 0) && (this.fSY.getAlpha() == 1.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(31658);
        }
      }
      else
      {
        this.fSY.setVisibility(0);
        this.fSY.setAlpha(0.0F);
        this.fSY.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
        AppMethodBeat.o(31658);
      }
    }
    else if ((this.fSY == null) || (this.fSY.getVisibility() == 4) || (this.fSY.getAlpha() == 0.0F))
    {
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(31658);
      }
    }
    else
    {
      this.fSY.animate().cancel();
      this.fSY.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185364);
          ChatFooter.v(ChatFooter.this).setVisibility(4);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(185364);
        }
      }).start();
    }
    AppMethodBeat.o(31658);
  }
  
  private void a(boolean paramBoolean, final Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(163216);
    if (paramBoolean)
    {
      if (this.Cbx == null) {
        eyW();
      }
      this.Cbx.animate().cancel();
      if ((this.Cbx.getVisibility() == 0) && (this.Cbx.getAlpha() == 1.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(163216);
        }
      }
      else
      {
        setAppPanelVisible(0);
        this.Cbx.setAlpha(0.0F);
        this.Cbx.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).setListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(191303);
            ChatFooter.bj(ChatFooter.this);
            ChatFooter.bk(ChatFooter.this).animate().setListener(null);
            AppMethodBeat.o(191303);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        }).start();
        this.Cbx.setUncertainEnterLocation(paramInt);
        AppMethodBeat.o(163216);
      }
    }
    else
    {
      this.Cbx.animate().cancel();
      if ((this.Cbx.getVisibility() == 4) || (this.Cbx.getAlpha() == 0.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(163216);
        }
      }
      else {
        this.Cbx.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185363);
            ChatFooter.this.setAppPanelVisible(4);
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(185363);
          }
        });
      }
    }
    AppMethodBeat.o(163216);
  }
  
  private void aB(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31599);
    if (paramBoolean1)
    {
      if ((this.CbK.getTag() != null) && ((this.CbK.getTag() instanceof bl)))
      {
        this.CbK.setVisibility(0);
        bl localbl = (bl)this.CbK.getTag();
        this.CbL.setText(com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), com.tencent.mm.plugin.msgquote.model.a.a(getContext(), this.CbL.getTextSize(), localbl)));
        AppMethodBeat.o(31599);
        return;
      }
      this.CbK.setVisibility(8);
      AppMethodBeat.o(31599);
      return;
    }
    if (paramBoolean2)
    {
      this.CbK.setTag(null);
      this.CbL.setText("");
    }
    this.CbK.setVisibility(8);
    AppMethodBeat.o(31599);
  }
  
  static boolean aCe(String paramString)
  {
    AppMethodBeat.i(163219);
    boolean bool = ax.aFC("plus_uncertain_enter").getBoolean(paramString, false);
    AppMethodBeat.o(163219);
    return bool;
  }
  
  private void aF(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185825);
    if (1 == paramInt3) {}
    for (boolean bool = true; ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3)) && (paramInt2 == 0); bool = false)
    {
      if (this.Ccw == null) {
        break label101;
      }
      this.Ccw.we(bool);
      AppMethodBeat.o(185825);
      return;
    }
    if ((paramInt1 == 0) && ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3)) && (this.Ccw != null)) {
      this.Ccw.wf(bool);
    }
    label101:
    AppMethodBeat.o(185825);
  }
  
  private static boolean aov()
  {
    AppMethodBeat.i(185402);
    if (aj.getContext().getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(185402);
      return true;
    }
    AppMethodBeat.o(185402);
    return false;
  }
  
  private void b(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185824);
    ezt();
    if (this.Ccl != null)
    {
      if ((this.Ccr) && (this.Ccj == 1))
      {
        this.Ccl.c(0, false, paramInt2, paramInt3);
        AppMethodBeat.o(185824);
        return;
      }
      this.Ccl.c(paramInt1, paramBoolean, paramInt2, paramInt3);
      AppMethodBeat.o(185824);
      return;
    }
    if ((this.Ccj == 0) || (this.Ccj == 1)) {
      this.CbC.setVisibility(8);
    }
    ad.e("MicroMsg.ChatFooter", "scrollParent: scrollParent is not ChattingScrollLayout");
    AppMethodBeat.o(185824);
  }
  
  private boolean cFm()
  {
    AppMethodBeat.i(31608);
    if (this.CbP != null)
    {
      boolean bool = this.CbP.cFm();
      AppMethodBeat.o(31608);
      return bool;
    }
    AppMethodBeat.o(31608);
    return false;
  }
  
  private boolean cr(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(179783);
    if (ezx())
    {
      AppMethodBeat.o(179783);
      return false;
    }
    if ((this.CcF == null) || (bt.isNullOrNil(this.CcF.getTalkerUserName())))
    {
      ad.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg username == null");
      AppMethodBeat.o(179783);
      return false;
    }
    try
    {
      String str = this.CcF.getTalkerUserName();
      if ((((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).adh(str)) && (paramBoolean))
      {
        this.CbP.cFn();
        try
        {
          localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).Tk(paramString);
          paramString = (String)localObject;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject;
            ad.e("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          }
          com.tencent.mm.plugin.groupsolitaire.b.b.b(locala1);
          locala2 = com.tencent.mm.plugin.groupsolitaire.b.b.a(localException, this.CbP.ssn, locala1);
          if (!locala2.srb) {
            break label296;
          }
          com.tencent.mm.plugin.groupsolitaire.b.b.c(locala2);
          label296:
          locala2.field_lastActiveTime = ce.asT();
          if (locala1 == null) {
            break label391;
          }
        }
        localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().gJ(paramString, str);
        if ((((Integer)((Pair)localObject).first).intValue() > 0) && (((Pair)localObject).second != null))
        {
          localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second;
          com.tencent.mm.plugin.groupsolitaire.b.b.a(str, u.aqG(), (com.tencent.mm.plugin.groupsolitaire.c.a)localObject);
          com.tencent.mm.plugin.groupsolitaire.c.a locala1 = com.tencent.mm.plugin.groupsolitaire.b.b.a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(str, ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_key, true), u.aqG(), 1);
          if (locala1 == null)
          {
            ad.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg storageGroupSolitatire == null");
            AppMethodBeat.o(179783);
            return false;
          }
          com.tencent.mm.plugin.groupsolitaire.c.a locala2;
          paramBoolean = true;
          com.tencent.mm.plugin.groupsolitaire.b.b.a(locala2, paramBoolean, true);
          PluginGroupSolitaire localPluginGroupSolitaire = (PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class);
          if (locala1.field_active == 0) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            localPluginGroupSolitaire.sendGroupSolitatire(paramString, str, localException, locala2, locala1, paramBoolean);
            if (this.CbQ != null) {
              this.CbQ.adu(paramString);
            }
            this.CbP.reset();
            eyS();
            AppMethodBeat.o(179783);
            return true;
            label391:
            paramBoolean = false;
            break;
          }
        }
      }
      AppMethodBeat.o(179783);
      return false;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg() Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      AppMethodBeat.o(179783);
    }
    return false;
  }
  
  private void eyW()
  {
    AppMethodBeat.i(31594);
    String str;
    if (this.CcF == null)
    {
      str = this.Cbw;
      this.Cbx = ((AppPanel)findViewById(2131297977));
      this.Cbx.setOnSwitchPanelListener(this.Cec);
      this.Cbx.setChattingContext(this.Ced);
      this.Cbx.setPortHeighPx(z.in(getContext()));
      if ((!w.to(str)) && (!w.tg(str))) {
        break label124;
      }
      this.Cbx.init(0);
    }
    for (;;)
    {
      this.CbD = ((TextView)findViewById(2131297978));
      AppMethodBeat.o(31594);
      return;
      str = this.CcF.getTalkerUserName();
      break;
      label124:
      if (w.sE(str)) {
        this.Cbx.init(4);
      } else if (w.pF(str)) {
        this.Cbx.init(2);
      } else {
        this.Cbx.init(1);
      }
    }
  }
  
  private void eyY()
  {
    AppMethodBeat.i(185399);
    this.Cej.start();
    this.Cek.start();
    this.Cel.start();
    this.Cem.start();
    this.Cen.start();
    this.CdT.animate().alpha(1.0F).setDuration(200L).start();
    this.CdU.animate().alpha(1.0F).setDuration(200L).start();
    this.CdD.animate().alpha(1.0F).translationY(0.0F).setDuration(300L).start();
    ezI();
    AppMethodBeat.o(185399);
  }
  
  private void eyZ()
  {
    AppMethodBeat.i(31617);
    if (this.Ccd)
    {
      this.qeE.setVisibility(8);
      this.qeF.setVisibility(8);
      this.yJO.setVisibility(8);
      this.qeC.setVisibility(8);
      this.CcJ.setVisibility(0);
      this.CcM.setVisibility(0);
      this.CcN.setVisibility(0);
      this.CcP.setVisibility(8);
      this.CcQ.setVisibility(0);
      this.CcR.setVisibility(8);
      this.CcT.setVisibility(8);
      this.CcU.setVisibility(8);
      this.CcX.setVisibility(8);
      this.Cdj = k.CfO;
      this.Cdh = ChatFooter.l.CfS;
      AppMethodBeat.o(31617);
      return;
    }
    this.qeE.setVisibility(0);
    this.qeF.setVisibility(8);
    this.yJO.setVisibility(8);
    this.qeC.setVisibility(8);
    this.CcJ.setVisibility(8);
    AppMethodBeat.o(31617);
  }
  
  private void ezC()
  {
    AppMethodBeat.i(31687);
    this.CcU.setVisibility(8);
    this.CcX.setVisibility(8);
    this.CcU.setScaleX(0.5F);
    this.CcU.setScaleY(0.5F);
    this.CcX.setScaleX(0.5F);
    this.CcX.setScaleY(0.5F);
    this.CcU.setTranslationX(this.CeT);
    this.CcU.setTranslationY(-this.CeU);
    this.CcX.setTranslationX(-this.CeT);
    this.CcX.setTranslationY(-this.CeU);
    ezD();
    ezE();
    AppMethodBeat.o(31687);
  }
  
  private void ezD()
  {
    AppMethodBeat.i(31688);
    this.CcV.setIconColor(getResources().getColor(2131100020));
    this.CcW.setTextColor(getResources().getColor(2131101072));
    this.CcU.setBackgroundDrawable(getResources().getDrawable(2131234484));
    AppMethodBeat.o(31688);
  }
  
  private void ezE()
  {
    AppMethodBeat.i(31689);
    this.CcY.setIconColor(getResources().getColor(2131100020));
    this.CcZ.setTextColor(getResources().getColor(2131101072));
    this.CcX.setBackgroundDrawable(getResources().getDrawable(2131234484));
    AppMethodBeat.o(31689);
  }
  
  private void ezF()
  {
    AppMethodBeat.i(31690);
    String str = ac.ir(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
    {
      this.CcS.setImageResource(2131691370);
      this.CcY.setImageResource(2131691372);
      AppMethodBeat.o(31690);
      return;
    }
    if (str.equals("en"))
    {
      this.CcS.setImageResource(2131691371);
      this.CcY.setImageResource(2131691373);
    }
    AppMethodBeat.o(31690);
  }
  
  private void ezG()
  {
    AppMethodBeat.i(185403);
    int k = this.Cdr.getWidth();
    int m = this.Cdr.getHeight();
    int j = 0;
    int i = 0;
    switch (77.Cfo[this.Cfb.ordinal()])
    {
    }
    for (;;)
    {
      ad.i("MicroMsg.ChatFooter", "beginWidth:%s, endWidth:%s, beginHeight:%s, endHeight:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i) });
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { k, j }).setDuration(200L);
      localValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(185810);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).width = i;
          ChatFooter.az(ChatFooter.this).requestLayout();
          AppMethodBeat.o(185810);
        }
      });
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { m, i }).setDuration(200L);
      localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(191318);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).height = i;
          ChatFooter.az(ChatFooter.this).requestLayout();
          AppMethodBeat.o(191318);
        }
      });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
      localAnimatorSet.start();
      AppMethodBeat.o(185403);
      return;
      j = this.CeB;
      i = this.CeA;
      continue;
      j = this.Ces;
      i = this.Cex;
      continue;
      j = this.Cet;
      i = this.CeA;
    }
  }
  
  private void ezH()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(185404);
    float f3 = this.Cdr.getTranslationX();
    float f1 = f2;
    switch (77.Cfo[this.Cfb.ordinal()])
    {
    }
    for (f1 = f2;; f1 = -(com.tencent.mm.ui.ap.cf(getContext()).x / 2 - ao.fromDPToPix(getContext(), 76)))
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f3, f1 }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(191319);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ChatFooter.az(ChatFooter.this).setTranslationX(f);
          AppMethodBeat.o(191319);
        }
      });
      localValueAnimator.start();
      AppMethodBeat.o(185404);
      return;
    }
  }
  
  private void ezI()
  {
    AppMethodBeat.i(185405);
    this.Cdr.setAlpha(0.0F);
    this.Cdr.setTranslationY(ao.fromDPToPix(getContext(), 56));
    this.Cdu.setAlpha(0);
    this.Cdu.setTranslationY(ao.fromDPToPix(getContext(), 56));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.Cdr, "translationY", new float[] { this.Cdr.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.Cdr, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.Cdu, "translationY", new float[] { this.Cdu.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofInt(this.Cdu, "alpha", new int[] { 0, 255 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    localAnimatorSet.start();
    AppMethodBeat.o(185405);
  }
  
  private void ezJ()
  {
    AppMethodBeat.i(185406);
    this.Cdt.setVisibility(8);
    this.Cdw.setVisibility(0);
    this.Cdw.setTextColor(getContext().getResources().getColor(2131100017));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.CdA.getLayoutParams();
    localLayoutParams.addRule(13);
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    this.Cdw.setText(String.format(getContext().getResources().getString(2131761571), new Object[] { Integer.valueOf(this.CeC) }));
    this.CdA.requestLayout();
    AppMethodBeat.o(185406);
  }
  
  private void ezK()
  {
    AppMethodBeat.i(185407);
    this.Cdt.setVisibility(8);
    this.Cdw.setVisibility(0);
    this.Cdw.setTextColor(getContext().getResources().getColor(2131100482));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.CdA.getLayoutParams();
    localLayoutParams.removeRule(13);
    localLayoutParams.addRule(21);
    localLayoutParams.addRule(12);
    this.Cdw.setText(String.format(getContext().getResources().getString(2131761571), new Object[] { Integer.valueOf(this.CeC) }));
    this.CdA.requestLayout();
    AppMethodBeat.o(185407);
  }
  
  private void ezL()
  {
    AppMethodBeat.i(185408);
    this.Cdt.setVisibility(0);
    this.Cdw.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.CdA.getLayoutParams();
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    localLayoutParams.addRule(13);
    this.CdA.requestLayout();
    ((RelativeLayout.LayoutParams)this.Cdt.getLayoutParams()).bottomMargin = 0;
    this.Cdt.requestLayout();
    AppMethodBeat.o(185408);
  }
  
  private void ezM()
  {
    AppMethodBeat.i(185409);
    this.CdT.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).withEndAction(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185811);
        ChatFooter.bs(ChatFooter.this).setVisibility(8);
        ChatFooter.bt(ChatFooter.this).v(ChatFooter.this.getResources().getColor(2131100017), 0.5F);
        AppMethodBeat.o(185811);
      }
    }).start();
    this.CdU.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).start();
    this.CdV.animate().translationY(0.0F).setDuration(100L).start();
    if (this.CeC < 10) {
      ezJ();
    }
    for (;;)
    {
      this.CdB.setVisibility(0);
      this.Cdz.setVisibility(8);
      this.Cds.setVisibility(8);
      this.Cdu.setImageDrawable(am.i(getContext(), 2131690496, getContext().getResources().getColor(2131099759)));
      this.Cdu.animate().translationX(0.0F).setDuration(150L).start();
      this.Cdr.setActivated(true);
      ezG();
      ezH();
      AppMethodBeat.o(185409);
      return;
      ezL();
      this.Cdt.a(SoundWaveView.d.yXL);
    }
  }
  
  private void ezN()
  {
    AppMethodBeat.i(185410);
    this.CdI.setVisibility(4);
    this.CdG.v(getResources().getColor(2131099828), 0.5F);
    this.CdE.setBackgroundDrawable(getResources().getDrawable(2131233437));
    this.CdE.animate().scaleX(1.0F).scaleY(1.0F).setDuration(150L).start();
    AppMethodBeat.o(185410);
  }
  
  private void ezO()
  {
    AppMethodBeat.i(185411);
    this.CdJ.setVisibility(4);
    this.CdH.v(getResources().getColor(2131099828), 0.5F);
    this.CdF.setBackgroundDrawable(getResources().getDrawable(2131233437));
    this.CdF.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    AppMethodBeat.o(185411);
  }
  
  private void ezP()
  {
    AppMethodBeat.i(185412);
    int j = ao.fromDPToPix(getContext(), 20);
    if ((this.Cds.getText() != null) && (this.Cds.getText().length() > 0)) {}
    for (int i = this.Cds.getText().length();; i = 0)
    {
      this.Cds.setSelection(i);
      this.Cds.setPadding(j, j, j, j);
      this.CdD.setVisibility(8);
      this.CdB.setVisibility(8);
      this.CdS.setVisibility(4);
      this.CdK.setVisibility(0);
      this.Cdx.setVisibility(0);
      com.tencent.mm.cl.a.a locala = com.tencent.mm.cl.a.FFw;
      com.tencent.mm.cl.a.eOT();
      this.Cdw.setVisibility(8);
      this.Cdt.setVisibility(8);
      AppMethodBeat.o(185412);
      return;
    }
  }
  
  private void ezn()
  {
    AppMethodBeat.i(31640);
    this.hFi.findViewById(2131298170).setVisibility(0);
    AppMethodBeat.o(31640);
  }
  
  private void ezo()
  {
    AppMethodBeat.i(31641);
    ad.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
    this.Ccf = false;
    this.tqv.setImeOptions(0);
    this.tqv.setInputType(this.tqv.getInputType() | 0x40);
    AppMethodBeat.o(31641);
  }
  
  private void ezt()
  {
    AppMethodBeat.i(31660);
    if (this.Ccl == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ChattingScrollLayout))
      {
        this.Ccl = ((ChattingScrollLayout)localViewParent);
        this.Ccm = true;
      }
    }
    AppMethodBeat.o(31660);
  }
  
  private void ezu()
  {
    AppMethodBeat.i(31668);
    if (!this.Cci)
    {
      ad.i("MicroMsg.ChatFooter", "updateKeyboardProvider: not resumed %s", new Object[] { bt.eGN() });
      AppMethodBeat.o(31668);
      return;
    }
    if ((this.Ccp) || (!this.Cch))
    {
      this.ftZ.close();
      ((Activity)getContext()).getWindow().setSoftInputMode(18);
      AppMethodBeat.o(31668);
      return;
    }
    ((Activity)getContext()).getWindow().setSoftInputMode(this.Ccn | 0x2);
    this.ftZ.start();
    AppMethodBeat.o(31668);
  }
  
  private int getDefaultLangType()
  {
    AppMethodBeat.i(185418);
    int i = com.tencent.mm.modelvoiceaddr.g.hEl;
    String str = ac.ir(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW"))) {
      i = com.tencent.mm.modelvoiceaddr.g.hEm;
    }
    for (;;)
    {
      AppMethodBeat.o(185418);
      return i;
      if (str.equals("en")) {
        i = com.tencent.mm.modelvoiceaddr.g.hEo;
      }
    }
  }
  
  private int getTransLangTypeByTalker()
  {
    AppMethodBeat.i(185417);
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voice2txt_sp", 0);
    int j = localSharedPreferences.getInt(this.Cbw, com.tencent.mm.modelvoiceaddr.g.hEl);
    if (this.Cdy != null)
    {
      Iterator localIterator = this.Cdy.yWK.fvw.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((com.tencent.mm.plugin.transvoice.ui.a.a.a)localIterator.next()).yYO != j);
      for (i = 1; i == 0; i = 0)
      {
        i = getDefaultLangType();
        if (com.tencent.mm.modelvoiceaddr.g.hEl != i) {
          localSharedPreferences.edit().putInt(this.Cbw, i).apply();
        }
        AppMethodBeat.o(185417);
        return i;
      }
      AppMethodBeat.o(185417);
      return j;
    }
    int i = getDefaultLangType();
    if (com.tencent.mm.modelvoiceaddr.g.hEl != i) {
      localSharedPreferences.edit().putInt(this.Cbw, i).apply();
    }
    AppMethodBeat.o(185417);
    return i;
  }
  
  private void h(int paramInt1, boolean paramBoolean, final int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(163218);
    ad.i("MicroMsg.ChatFooter", "switchPanel: %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    if (this.Ccv)
    {
      AppMethodBeat.o(163218);
      return;
    }
    if ((paramInt1 != 0) && (u.aro().booleanValue()) && (this.CcA != null))
    {
      this.CcA.a(Boolean.TRUE, Boolean.FALSE);
      this.CcA.b(Boolean.TRUE, Boolean.FALSE);
    }
    Ve(paramInt1);
    switch (paramInt1)
    {
    default: 
      if (((this.Ccj != 0) || (paramInt1 != 1)) && ((this.Ccj != 1) || (paramInt1 != 0))) {
        break;
      }
    }
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      aF(this.Ccj, paramInt1, paramInt2);
      this.Ccj = paramInt1;
      com.tencent.mm.emoji.b.a locala;
      label198:
      int j;
      if (this.Ccj == 2)
      {
        uq(true);
        locala = com.tencent.mm.emoji.b.a.fRa;
        com.tencent.mm.emoji.b.a.ack();
        j = this.Cco;
        if (this.Ccw != null) {
          break label436;
        }
      }
      label436:
      for (paramInt1 = i;; paramInt1 = this.Ccw.cFo())
      {
        b(j, paramBoolean, paramInt2, paramInt1);
        if (this.CbS != null) {
          this.CbS.iP(this.Ccj, this.Cco);
        }
        AppMethodBeat.o(163218);
        return;
        if ((!this.Cch) || (this.Ccp)) {}
        for (this.Cco = 0;; this.Cco = this.mEi)
        {
          a(false, null);
          a(false, null, -1);
          break;
        }
        this.Cco = this.Ccu;
        this.CbC.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(191304);
            ChatFooter.bl(ChatFooter.this);
            AppMethodBeat.o(191304);
          }
        }, -1);
        break;
        this.Cco = this.Cct;
        this.CbC.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185367);
            ChatFooter.f(ChatFooter.this, paramInt2);
            AppMethodBeat.o(185367);
          }
        });
        this.CbN.ezZ();
        un(false);
        if (this.Ccc != 2) {
          break;
        }
        Vc(1);
        break;
        this.Cco = 0;
        a(false, null);
        a(false, null, -1);
        exL();
        ezv();
        break;
        uq(false);
        locala = com.tencent.mm.emoji.b.a.fRa;
        com.tencent.mm.emoji.b.a.acl();
        break label198;
      }
    }
  }
  
  private void mU(boolean paramBoolean)
  {
    AppMethodBeat.i(31584);
    this.fNO = paramBoolean;
    if (this.CcG == null)
    {
      this.CcG = AnimationUtils.loadAnimation(getContext(), 2130772095);
      this.CcG.setDuration(150L);
    }
    if (this.CcH == null)
    {
      this.CcH = AnimationUtils.loadAnimation(getContext(), 2130772100);
      this.CcH.setDuration(150L);
    }
    if ((this.fPz == null) || (this.CbE == null))
    {
      ad.i("MicroMsg.ChatFooter", "canSend:%B, return sendBtn == null || mAttachButton == null", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31584);
      return;
    }
    if (this.CcD)
    {
      if (this.CbE.getVisibility() != 0) {
        this.CbE.setVisibility(0);
      }
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.fPz.getVisibility() == 0) && (paramBoolean))
    {
      ad.i("MicroMsg.ChatFooter", "canSend true ! sendBtn is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.CbE.getVisibility() == 0) && (!paramBoolean))
    {
      ad.i("MicroMsg.ChatFooter", "canSend false ! AttachButton is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if (paramBoolean)
    {
      ezB();
      this.CbE.startAnimation(this.CcH);
      this.CbE.setVisibility(8);
      ur(false);
    }
    for (;;)
    {
      ad.i("MicroMsg.ChatFooter", "jacks canSend:%B", new Object[] { Boolean.valueOf(paramBoolean) });
      this.fPz.getParent().requestLayout();
      AppMethodBeat.o(31584);
      return;
      this.CbE.startAnimation(this.CcG);
      if (!this.CbW)
      {
        this.CbE.setVisibility(0);
        ur(true);
      }
      ezA();
    }
  }
  
  private void setNewVoice2TxtCountDown(int paramInt)
  {
    AppMethodBeat.i(185400);
    if ((paramInt > 60) || (paramInt < 0))
    {
      ad.w("MicroMsg.ChatFooter", "skip by invalid quantity:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(185400);
      return;
    }
    switch (77.Cfo[this.Cfb.ordinal()])
    {
    }
    for (;;)
    {
      this.CeC = paramInt;
      AppMethodBeat.o(185400);
      return;
      int i = 60 - paramInt;
      int j = (int)(this.Cew * i);
      this.CeB = Math.min(this.Cev + j, this.Ceu);
      ad.d("MicroMsg.ChatFooter", "voiceWidth:%s, duration:%s, offset:%s", new Object[] { Integer.valueOf(this.CeB), Integer.valueOf(i), Integer.valueOf(j) });
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.Cdr.getWidth(), this.CeB }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(185387);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).width = i;
          ChatFooter.az(ChatFooter.this).requestLayout();
          AppMethodBeat.o(185387);
        }
      });
      localValueAnimator.start();
      if (paramInt < 10)
      {
        ezJ();
        continue;
        if (paramInt < 10) {
          ezK();
        }
      }
    }
  }
  
  private void uo(boolean paramBoolean)
  {
    AppMethodBeat.i(31598);
    if (paramBoolean)
    {
      this.CbJ.setVisibility(0);
      this.CbH.setVisibility(0);
      aB(true, false);
      AppMethodBeat.o(31598);
      return;
    }
    this.CbJ.setVisibility(8);
    this.CbH.setVisibility(8);
    aB(false, false);
    AppMethodBeat.o(31598);
  }
  
  private void uq(boolean paramBoolean)
  {
    AppMethodBeat.i(31673);
    if (this.CbG == null)
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((this.CeG) && (paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((!this.CeG) && (!paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    this.CeG = paramBoolean;
    if (paramBoolean)
    {
      this.CbG.setImageDrawable(getContext().getResources().getDrawable(2131231706));
      AppMethodBeat.o(31673);
      return;
    }
    this.CbG.setImageDrawable(getContext().getResources().getDrawable(2131690564));
    AppMethodBeat.o(31673);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void Va(int paramInt)
  {
    AppMethodBeat.i(31616);
    Object localObject1;
    if (this.Cdm)
    {
      if (this.Cdo == null)
      {
        this.Cdo = new o(View.inflate(getContext(), 2131495020, null), -1, -1, true);
        this.Cdo.setSoftInputMode(16);
        this.Cdo.setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(191293);
            if ((ChatFooter.this.Cfb == ChatFooter.e.Cfy) && (ChatFooter.aI(ChatFooter.this)))
            {
              ad.i("MicroMsg.ChatFooter", "dismiss from keyback, need cancelRecording");
              ChatFooter.z(ChatFooter.this).setExitType(6);
              ChatFooter.l(ChatFooter.this).cNY();
            }
            ChatFooter.aJ(ChatFooter.this);
            AppMethodBeat.o(191293);
          }
        });
        this.Cdp = this.Cdo.getContentView().findViewById(2131302815);
        this.Cdq = this.Cdo.getContentView().findViewById(2131302837);
        this.Cdr = ((ViewGroup)this.Cdo.getContentView().findViewById(2131302811));
        this.Cdt = ((SoundWaveView)this.Cdo.getContentView().findViewById(2131302817));
        this.Cds = ((EditText)this.Cdo.getContentView().findViewById(2131302809));
        this.Cdu = ((ImageView)this.Cdo.getContentView().findViewById(2131302808));
        this.Cdv = ((ViewGroup)this.Cdo.getContentView().findViewById(2131302816));
        this.Cdw = ((TextView)this.Cdo.getContentView().findViewById(2131302807));
        this.Cdx = ((WeImageView)this.Cdo.getContentView().findViewById(2131302812));
        this.Cdy = ((LanguageChoiceLayout)this.Cdo.getContentView().findViewById(2131302829));
        this.Cdz = ((TextView)this.Cdo.getContentView().findViewById(2131302813));
        this.CdA = ((ViewGroup)this.Cdo.getContentView().findViewById(2131302818));
        this.CdB = ((TextView)this.Cdo.getContentView().findViewById(2131302810));
        this.Cdy.setSelectLanguageListener(new LanguageChoiceLayout.a()
        {
          public final void PD(int paramAnonymousInt)
          {
            AppMethodBeat.i(191294);
            ChatFooter.e(ChatFooter.this, paramAnonymousInt);
            if (bt.isNullOrNil((String)ChatFooter.aL(ChatFooter.this).get(Integer.valueOf(ChatFooter.aK(ChatFooter.this)))))
            {
              long l2 = System.nanoTime() | 0xFFFFFFFF;
              long l1 = l2;
              if (l2 < 0L) {
                l1 = Math.abs(l2);
              }
              com.tencent.mm.modelvoiceaddr.h localh = new com.tencent.mm.modelvoiceaddr.h(String.valueOf(l1));
              ChatFooter.A(ChatFooter.this).a(localh);
              ChatFooter.this.getContext().getSharedPreferences("voice2txt_sp", 0).edit().putInt(ChatFooter.av(ChatFooter.this), ChatFooter.aK(ChatFooter.this)).apply();
              ChatFooter.this.a(ChatFooter.aK(ChatFooter.this), false, localh, true);
            }
            for (;;)
            {
              ChatFooter.z(ChatFooter.this).yWl = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).yWo = 0;
              ChatFooter.z(ChatFooter.this).yWp = 0L;
              ChatFooter.z(ChatFooter.this).yWq = 0;
              ChatFooter.z(ChatFooter.this).yWt = 0;
              ChatFooter.z(ChatFooter.this).yWu = 0;
              ChatFooter.z(ChatFooter.this).yWv = 0;
              AppMethodBeat.o(191294);
              return;
              ChatFooter.aM(ChatFooter.this);
            }
          }
        });
        this.Cdx.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(191295);
            if (ChatFooter.aN(ChatFooter.this)) {
              ChatFooter.aO(ChatFooter.this).hideSoftInputFromWindow(ChatFooter.aA(ChatFooter.this).getWindowToken(), 0);
            }
            paramAnonymousView = ChatFooter.aP(ChatFooter.this);
            int i = ChatFooter.aK(ChatFooter.this);
            paramAnonymousView.setVisibility(0);
            paramAnonymousView.yWI.post(new LanguageChoiceLayout.4(paramAnonymousView, i));
            AppMethodBeat.o(191295);
          }
        });
        this.Cds.setMaxLines(2147483647);
        this.Cds.setHorizontallyScrolling(false);
        this.Cds.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(191296);
            if ((4 == paramAnonymousInt) || (66 == paramAnonymousKeyEvent.getAction()))
            {
              paramAnonymousTextView = ChatFooter.aA(ChatFooter.this).getText().toString();
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                if (!bt.isNullOrNil(paramAnonymousTextView)) {
                  ChatFooter.l(ChatFooter.this).afG(paramAnonymousTextView);
                }
                ChatFooter.l(ChatFooter.this).cNY();
              }
              AppMethodBeat.o(191296);
              return true;
            }
            AppMethodBeat.o(191296);
            return false;
          }
        });
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(31533);
            ChatFooter.aQ(ChatFooter.this);
            AppMethodBeat.o(31533);
          }
        });
        this.Cds.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(191297);
            if (ChatFooter.aR(ChatFooter.this))
            {
              ChatFooter.f(ChatFooter.this, false);
              if (ChatFooter.this.yYa != null) {
                ChatFooter.this.yYa.ak(false, true);
              }
              ChatFooter.aS(ChatFooter.this).stopTimer();
              ChatFooter.aA(ChatFooter.this).setText((CharSequence)ChatFooter.aL(ChatFooter.this).get(Integer.valueOf(ChatFooter.aK(ChatFooter.this))));
              ChatFooter.z(ChatFooter.this).yWt = 0;
              ChatFooter.z(ChatFooter.this).yWp = System.currentTimeMillis();
              ChatFooter.aT(ChatFooter.this);
            }
            ChatFooter.z(ChatFooter.this).yWv = 1;
            AppMethodBeat.o(191297);
            return false;
          }
        });
        this.CdC = ((ViewGroup)this.Cdo.getContentView().findViewById(2131302814));
        this.CdD = ((ViewGroup)this.Cdo.getContentView().findViewById(2131302840));
        this.CdE = this.Cdo.getContentView().findViewById(2131302804);
        this.CdF = this.Cdo.getContentView().findViewById(2131302838);
        this.CdG = ((WeImageView)this.Cdo.getContentView().findViewById(2131302805));
        this.CdH = ((WeImageView)this.Cdo.getContentView().findViewById(2131302839));
        this.CdI = this.Cdo.getContentView().findViewById(2131302806);
        this.CdJ = this.Cdo.getContentView().findViewById(2131302842);
        this.CdK = ((ViewGroup)this.Cdo.getContentView().findViewById(2131302841));
        this.CdL = this.Cdo.getContentView().findViewById(2131302820);
        this.CdL.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185353);
            ChatFooter.aU(ChatFooter.this);
            ChatFooter.z(ChatFooter.this).setExitType(6);
            ChatFooter.l(ChatFooter.this).cNY();
            AppMethodBeat.o(185353);
          }
        });
        this.CdM = this.Cdo.getContentView().findViewById(2131302835);
        this.CdM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185787);
            if (ChatFooter.l(ChatFooter.this) != null)
            {
              ChatFooter.aU(ChatFooter.this);
              ChatFooter.z(ChatFooter.this).setExitType(7);
              ChatFooter.l(ChatFooter.this).dC(ChatFooter.l(ChatFooter.this).getFileName(), ChatFooter.aV(ChatFooter.this));
              ChatFooter.ay(ChatFooter.this);
            }
            AppMethodBeat.o(185787);
          }
        });
        this.CdP = this.Cdo.getContentView().findViewById(2131302832);
        this.CdP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(191298);
            if ((ChatFooter.aW(ChatFooter.this).getVisibility() == 0) && (8 == ChatFooter.aX(ChatFooter.this).getVisibility()))
            {
              paramAnonymousView = ChatFooter.aA(ChatFooter.this).getText().toString();
              if ((ChatFooter.l(ChatFooter.this) != null) && (!bt.isNullOrNil(paramAnonymousView)))
              {
                ChatFooter.aU(ChatFooter.this);
                ChatFooter.z(ChatFooter.this).yWn = ChatFooter.aK(ChatFooter.this);
                ChatFooter.z(ChatFooter.this).yWr = paramAnonymousView.length();
                if (1 != ChatFooter.z(ChatFooter.this).yWu) {
                  break label169;
                }
                ChatFooter.z(ChatFooter.this).setExitType(8);
              }
            }
            for (;;)
            {
              ChatFooter.l(ChatFooter.this).afG(paramAnonymousView);
              ChatFooter.l(ChatFooter.this).cNY();
              ChatFooter.b(ChatFooter.this, paramAnonymousView);
              AppMethodBeat.o(191298);
              return;
              label169:
              ChatFooter.z(ChatFooter.this).setExitType(5);
            }
          }
        });
        this.CdN = ((WeImageView)this.Cdo.getContentView().findViewById(2131302821));
        this.CdO = ((WeImageView)this.Cdo.getContentView().findViewById(2131302836));
        this.CdQ = this.Cdo.getContentView().findViewById(2131302834);
        this.CdR = ((WeImageView)this.Cdo.getContentView().findViewById(2131302833));
        this.CdS = ((ViewGroup)this.Cdo.getContentView().findViewById(2131302843));
        this.CdT = this.Cdo.getContentView().findViewById(2131302845);
        this.CdU = this.Cdo.getContentView().findViewById(2131302847);
        this.CdV = this.Cdo.getContentView().findViewById(2131302846);
        this.CdW = ((WeImageView)this.Cdo.getContentView().findViewById(2131302844));
        localObject1 = (RelativeLayout.LayoutParams)this.CdS.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).height = (getContext().getResources().getDimensionPixelSize(2131166976) + com.tencent.mm.ui.aq.eb(getContext()));
        this.CdS.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (FrameLayout.LayoutParams)this.CdW.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (com.tencent.mm.ui.aq.eb(getContext()) + ao.fromDPToPix(getContext(), 14));
        this.CdW.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.yYh = new av(new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(191299);
            int i = ChatFooter.aY(ChatFooter.this);
            ChatFooter.aZ(ChatFooter.this);
            switch (i % 3)
            {
            }
            for (;;)
            {
              ChatFooter.ba(ChatFooter.this);
              AppMethodBeat.o(191299);
              return true;
              ChatFooter.c(ChatFooter.this, "·");
              continue;
              ChatFooter.c(ChatFooter.this, "··");
              continue;
              ChatFooter.c(ChatFooter.this, "···");
            }
          }
        }, true);
        this.yYk = new com.tencent.mm.sdk.platformtools.ap(new ap.a()
        {
          public final boolean handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(191300);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(191300);
              return true;
              ChatFooter.z(ChatFooter.this).yWo = 1;
              ChatFooter.z(ChatFooter.this).yWp = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).yWt = 0;
              ChatFooter.aS(ChatFooter.this).stopTimer();
              if (ChatFooter.this.yYa != null) {
                ChatFooter.this.yYa.ak(false, false);
              }
              if (!bt.isNullOrNil((String)ChatFooter.aL(ChatFooter.this).get(Integer.valueOf(ChatFooter.aK(ChatFooter.this)))))
              {
                ChatFooter.aA(ChatFooter.this).setFocusable(true);
                ChatFooter.aA(ChatFooter.this).setFocusableInTouchMode(true);
                ChatFooter.aA(ChatFooter.this).requestFocus();
              }
              ChatFooter.aM(ChatFooter.this);
              ChatFooter.aT(ChatFooter.this);
            }
          }
        });
        this.CdX = this.Cdo.getContentView().findViewById(2131302819);
        this.Cdo.setClippingEnabled(false);
      }
      paramInt = getTransLangTypeByTalker();
      if (com.tencent.mm.modelvoiceaddr.g.hEl == paramInt)
      {
        this.yVZ = com.tencent.mm.modelvoiceaddr.g.hEm;
        if (this.Cdy != null) {
          this.Cdy.setSelectedLang(this.yVZ);
        }
        ad.d("MicroMsg.ChatFooter", "curTxt:%s", new Object[] { Integer.valueOf(this.Cfd.size()) });
        if ((com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FxE, true)) || (!com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FxF, true))) {
          break label1662;
        }
        this.CdB.setTranslationY(ao.fromDPToPix(getContext(), 12));
        this.CdB.setVisibility(0);
        this.CdB.setAlpha(0.0F);
        this.CdB.setText(getContext().getResources().getString(2131761574));
        this.CdB.animate().alpha(1.0F).translationY(0.0F).setDuration(1000L).setStartDelay(500L).start();
        label1180:
        this.Cdr.setTranslationY(0.0F);
        this.Cdu.setTranslationY(0.0F);
        this.Cdx.setTranslationY(0.0F);
        this.CdC.setTranslationY(0.0F);
        paramInt = ao.fromDPToPix(getContext(), 20);
        this.Cds.setPadding(paramInt, paramInt, paramInt, 0);
        this.Cds.addTextChangedListener(this.Cei);
        this.Cds.setVisibility(8);
        this.Cds.setCursorVisible(false);
        this.Cdt.setVisibility(0);
        this.Cdz.setVisibility(8);
        this.CdP.setEnabled(true);
        this.Cdr.setActivated(true);
        this.CdR.setImageDrawable(am.i(getContext(), 2131690391, getContext().getResources().getColor(2131099699)));
        this.Cdu.setImageDrawable(am.i(getContext(), 2131690496, getContext().getResources().getColor(2131099759)));
        localObject1 = (FrameLayout.LayoutParams)this.CdT.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = ao.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = ao.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = ao.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = ao.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = ao.fromDPToPix(getContext(), 8);
        this.CdT.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.CdT.setAlpha(0.0F);
        localObject1 = (FrameLayout.LayoutParams)this.CdU.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = ao.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = ao.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = ao.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = ao.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = ao.fromDPToPix(getContext(), 8);
        this.CdU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.CdU.setAlpha(0.0F);
        this.CdD.setTranslationY(this.Cfa);
        this.CdD.setAlpha(0.0F);
        this.Cdt.setVisibility(8);
        this.CdX.setVisibility(0);
        if (!ai.Eq()) {
          break label1746;
        }
        this.Cdq.setBackground(getContext().getResources().getDrawable(2131233433));
      }
      for (;;)
      {
        this.CeN = false;
        this.Cdo.showAtLocation(this, 49, 0, 0);
        eyY();
        this.Cdx.setVisibility(8);
        AppMethodBeat.o(31616);
        return;
        this.yVZ = paramInt;
        break;
        label1662:
        this.CdB.setTranslationY(ao.fromDPToPix(getContext(), 30));
        this.CdB.setVisibility(0);
        this.CdB.setAlpha(0.0F);
        this.CdB.setText(getContext().getResources().getString(2131761578));
        this.CdB.animate().alpha(1.0F).translationY(0.0F).setDuration(200L).setStartDelay(0L).start();
        break label1180;
        label1746:
        this.Cdq.setBackground(getContext().getResources().getDrawable(2131233434));
      }
    }
    this.Cef = 0;
    int i;
    if (this.Ccd) {
      i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 280);
    }
    for (;;)
    {
      int j = BackwardSupportUtil.b.g(getContext(), 50.0F);
      if (paramInt + j < i)
      {
        this.Cef = -1;
        if (this.yJL == null)
        {
          this.yJL = new o(View.inflate(getContext(), 2131495869, null), -1, -2);
          this.CbY = ((ViewGroup)this.yJL.getContentView().findViewById(2131306525));
          this.qeE = this.yJL.getContentView().findViewById(2131306519);
          this.qeD = ((ImageView)this.yJL.getContentView().findViewById(2131306631));
          this.CbZ = ((TextView)this.yJL.getContentView().findViewById(2131306528));
          this.CbZ.setTextSize(0, com.tencent.mm.cd.a.ap(getContext(), 2131166735) * com.tencent.mm.cd.a.hQ(getContext()));
          this.qeF = this.yJL.getContentView().findViewById(2131306521);
          this.yJM = ((TextView)this.yJL.getContentView().findViewById(2131306523));
          this.yJM.setTextSize(0, com.tencent.mm.cd.a.ap(getContext(), 2131166735) * com.tencent.mm.cd.a.hQ(getContext()));
          this.yJN = ((ImageView)this.yJL.getContentView().findViewById(2131306522));
          this.yJO = this.yJL.getContentView().findViewById(2131306524);
          this.qeC = this.yJL.getContentView().findViewById(2131306526);
          this.CcJ = ((ViewGroup)this.yJL.getContentView().findViewById(2131306474));
          this.CcK = this.yJL.getContentView().findViewById(2131306467);
          this.CcN = this.yJL.getContentView().findViewById(2131306478);
          this.CcO = ((ImageView)this.yJL.getContentView().findViewById(2131306479));
          this.CcP = ((ImageView)this.yJL.getContentView().findViewById(2131306466));
          this.CcQ = this.yJL.getContentView().findViewById(2131306468);
          this.CcR = ((TextView)this.yJL.getContentView().findViewById(2131306471));
          this.CcS = ((ImageView)this.yJL.getContentView().findViewById(2131306469));
          this.CcT = this.yJL.getContentView().findViewById(2131306473);
          this.CcU = this.yJL.getContentView().findViewById(2131306463);
          this.CcV = ((WeImageView)this.yJL.getContentView().findViewById(2131306464));
          this.CcW = ((TextView)this.yJL.getContentView().findViewById(2131306465));
          this.CcX = this.yJL.getContentView().findViewById(2131306475);
          this.CcY = ((WeImageView)this.yJL.getContentView().findViewById(2131306476));
          this.CcZ = ((TextView)this.yJL.getContentView().findViewById(2131306477));
          this.Cda = View.inflate(getContext(), 2131494417, null);
        }
      }
      try
      {
        if (j.CfL == this.Cdi)
        {
          localObject1 = this.activity.getWindow().getDecorView();
          Drawable localDrawable = ((View)localObject1).getBackground();
          this.CcL = new BlurView(getContext());
          paramInt = com.tencent.mm.cd.a.fromDPToPix(getContext(), 14);
          BlurView localBlurView = this.CcL.w((ViewGroup)localObject1).Yj(getResources().getColor(2131101069)).G(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).bJ(15.0F).eUg();
          localBlurView.Hx = (paramInt * 1.0F);
          localBlurView.Gja = true;
          localBlurView.Yk(this.Cef).eUh();
          this.Cdb = new BlurView(getContext());
          this.Cdb.Yj(getResources().getColor(2131101069));
          this.Cdb.w((ViewGroup)localObject1).G(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).bJ(15.0F).eUg().eUh();
        }
        ad.i("MicroMsg.ChatFooter", "transVoiceBlurMode: %s.", new Object[] { this.Cdi });
        switch (77.Cfn[this.Cdi.ordinal()])
        {
        default: 
          this.Cdf.setClippingEnabled(false);
          this.Cdf.getContentView().setAlpha(0.0F);
          this.Cdf.setOnDismissListener(new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(191301);
              ChatFooter.H(ChatFooter.this).getContentView().setAlpha(0.0F);
              AppMethodBeat.o(191301);
            }
          });
          ((TextView)this.yJL.getContentView().findViewById(2131306470)).setTextSize(0, com.tencent.mm.cd.a.ap(getContext(), 2131166968) * com.tencent.mm.cd.a.hQ(getContext()));
          eyZ();
          if (this.Cef != -1)
          {
            this.qeC.setVisibility(8);
            this.CbY.setVisibility(8);
            this.yJO.setVisibility(0);
            new com.tencent.mm.sdk.platformtools.ap().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(185359);
                if (ChatFooter.P(ChatFooter.this))
                {
                  ChatFooter.an(ChatFooter.this).setVisibility(8);
                  ChatFooter.T(ChatFooter.this).setVisibility(0);
                  AppMethodBeat.o(185359);
                  return;
                }
                ChatFooter.an(ChatFooter.this).setVisibility(0);
                ChatFooter.T(ChatFooter.this).setVisibility(8);
                AppMethodBeat.o(185359);
              }
            });
            if (this.Ccd)
            {
              ezF();
              this.Cdl = false;
              ezC();
              this.Cdf.showAtLocation(this, 49, 0, 0);
              this.Cdk = false;
              if (this.CeL)
              {
                this.CeL = false;
                if (j.CfL != this.Cdi) {
                  break label3117;
                }
                this.CcL.Yj(getResources().getColor(2131101069)).G(this.activity.getWindow().getDecorView().getBackground()).vY(true);
              }
            }
            this.yJL.showAtLocation(this, 49, 0, this.Cef);
          }
          else
          {
            AppMethodBeat.o(31616);
            return;
            i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 180);
            continue;
            this.Cef = ((paramInt - i) / 2 + j);
          }
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.Cdi = j.CfM;
          this.Ceg = true;
          continue;
          this.CcJ.removeView(this.CcK);
          Object localObject2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(2131166964), getResources().getDimensionPixelSize(2131166964));
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          this.CcL.addView(this.CcK, (ViewGroup.LayoutParams)localObject2);
          this.CcJ.addView(this.CcL, (ViewGroup.LayoutParams)localObject2);
          this.CcM = this.CcL;
          localObject2 = new FrameLayout.LayoutParams(-1, -1);
          this.Cdb.addView(this.Cda, (ViewGroup.LayoutParams)localObject2);
          this.Cdf = new o(this.Cdb, -1, -1);
          continue;
          this.CcM = this.CcK;
          this.CcM.setBackgroundResource(2131234483);
          this.Cda.setBackgroundColor(getResources().getColor(2131101071));
          this.Cdf = new o(this.Cda, -1, -1);
          continue;
          label3117:
          this.CcM.setBackgroundResource(2131234483);
        }
      }
    }
  }
  
  public final void Vb(int paramInt)
  {
    AppMethodBeat.i(31622);
    if (this.Cdm)
    {
      if ((this.Cdt != null) && (this.Cdt.getVisibility() == 0)) {
        this.Cdt.PE(paramInt);
      }
      AppMethodBeat.o(31622);
      return;
    }
    if (this.Ccd)
    {
      i = 0;
      for (;;)
      {
        if (i < CeE.length)
        {
          if ((paramInt >= CeD[i]) && (paramInt < CeD[(i + 1)])) {
            this.CcO.setBackgroundDrawable(com.tencent.mm.cd.a.l(getContext(), CeE[i]));
          }
        }
        else
        {
          if ((paramInt != -1) || (this.yJL == null)) {
            break;
          }
          this.yJL.dismiss();
          this.yJO.setVisibility(0);
          this.CbY.setVisibility(8);
          this.qeC.setVisibility(8);
          AppMethodBeat.o(31622);
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < CeE.length)
      {
        if ((paramInt >= CeD[i]) && (paramInt < CeD[(i + 1)])) {
          this.qeD.setBackgroundDrawable(com.tencent.mm.cd.a.l(getContext(), CeE[i]));
        }
      }
      else
      {
        if ((paramInt == -1) && (this.yJL != null))
        {
          this.yJL.dismiss();
          this.yJO.setVisibility(0);
          this.CbY.setVisibility(8);
          this.qeC.setVisibility(8);
        }
        AppMethodBeat.o(31622);
        return;
      }
      i += 1;
    }
  }
  
  public final void Vc(int paramInt)
  {
    AppMethodBeat.i(31624);
    this.Ccc = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31624);
      return;
      uo(true);
      this.Cbz.setVisibility(8);
      UZ(2131231707);
      AppMethodBeat.o(31624);
      return;
      uo(false);
      this.Cbz.setVisibility(0);
      ezw();
      UZ(2131231706);
      if ((u.aro().booleanValue()) && (this.CcA != null))
      {
        ChatFooter.c localc = this.CcA;
        Boolean localBoolean = Boolean.TRUE;
        localc.b(localBoolean, localBoolean);
      }
    }
  }
  
  public final void Vd(int paramInt)
  {
    AppMethodBeat.i(185823);
    b(paramInt, true, 0, 0);
    AppMethodBeat.o(185823);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, com.tencent.mm.modelvoiceaddr.h paramh, boolean paramBoolean2)
  {
    AppMethodBeat.i(185826);
    ad.d("MicroMsg.ChatFooter", "startTrans, hasStartTrans: %s, isForce: %s.", new Object[] { Boolean.valueOf(this.Cfe), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean2) {
      if (this.Cfe)
      {
        if (this.yYa != null) {
          this.yYa.ak(false, true);
        }
        this.yYk.removeMessages(5000);
        this.yYh.stopTimer();
      }
    }
    while (!this.Cfe)
    {
      this.Cfe = true;
      this.yYa = new com.tencent.mm.plugin.transvoice.a.b(paramh, paramInt, new g.b()
      {
        public final void aDQ()
        {
          AppMethodBeat.i(191324);
          ad.d("MicroMsg.ChatFooter", "onRecordFin.");
          AppMethodBeat.o(191324);
        }
        
        public final void aDU()
        {
          AppMethodBeat.i(191325);
          if ((ChatFooter.this.yYa != null) && (!ChatFooter.this.yYa.yWa))
          {
            ad.d("MicroMsg.ChatFooter", "onRecognizeFinish, %s.", new Object[] { Boolean.valueOf(ChatFooter.this.yYa.yWa) });
            ChatFooter.z(ChatFooter.this).yWt = 1;
            ChatFooter.z(ChatFooter.this).yWp = System.currentTimeMillis();
            ChatFooter.f(ChatFooter.this, false);
            ChatFooter.aT(ChatFooter.this);
            ChatFooter.this.yYa = null;
            ChatFooter.bv(ChatFooter.this).removeMessages(5000);
            ChatFooter.aS(ChatFooter.this).stopTimer();
            ChatFooter.aM(ChatFooter.this);
          }
          AppMethodBeat.o(191325);
        }
        
        public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(191322);
          ad.d("MicroMsg.ChatFooter", "newVoice2txt onRes, %s.", new Object[] { ChatFooter.this.yYa });
          ChatFooter.bu(ChatFooter.this).clear();
          if (!bt.gL(paramAnonymousList)) {
            ChatFooter.bu(ChatFooter.this).addAll(paramAnonymousList);
          }
          if (!ChatFooter.aR(ChatFooter.this))
          {
            ChatFooter.f(ChatFooter.this, true);
            ChatFooter.aA(ChatFooter.this).setFocusable(true);
            ChatFooter.aA(ChatFooter.this).setFocusableInTouchMode(true);
            ChatFooter.aA(ChatFooter.this).requestFocus();
          }
          if ((ChatFooter.this.yYa != null) && (!ChatFooter.this.yYa.yWa))
          {
            ChatFooter.bv(ChatFooter.this).removeMessages(5000);
            ChatFooter.bv(ChatFooter.this).sendEmptyMessageDelayed(5000, 5000L);
          }
          if (!bt.isNullOrNil(paramAnonymousArrayOfString[0]))
          {
            ChatFooter.aL(ChatFooter.this).put(Integer.valueOf(ChatFooter.aK(ChatFooter.this)), paramAnonymousArrayOfString[0]);
            if (ChatFooter.aL(ChatFooter.this) != null) {
              ChatFooter.z(ChatFooter.this).yWq = paramAnonymousArrayOfString[0].length();
            }
            ad.d("MicroMsg.ChatFooter", "newVoice2txt onRes, curTxt: %s.", new Object[] { paramAnonymousArrayOfString[0] });
          }
          AppMethodBeat.o(191322);
        }
        
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
        {
          AppMethodBeat.i(191323);
          ad.d("MicroMsg.ChatFooter", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong) });
          ChatFooter.z(ChatFooter.this).yWt = 0;
          ChatFooter.z(ChatFooter.this).yWp = System.currentTimeMillis();
          ChatFooter.aT(ChatFooter.this);
          AppMethodBeat.o(191323);
        }
      });
      this.yYa.yWa = paramBoolean1;
      this.yYa.start();
      this.yYh.av(500L, 500L);
      AppMethodBeat.o(185826);
      return;
    }
    AppMethodBeat.o(185826);
  }
  
  public final void a(Context paramContext, Activity paramActivity)
  {
    boolean bool2 = true;
    AppMethodBeat.i(31575);
    ad.i("MicroMsg.ChatFooter", "onResume: %s, %s", new Object[] { Boolean.valueOf(z.ip(paramContext)), Integer.valueOf(getContext().getResources().getConfiguration().orientation) });
    this.Cci = true;
    this.activity = paramActivity;
    if ((this.Ccn == 48) && (this.Ccj == 1) && (!this.Ccv))
    {
      this.srJ = false;
      h(0, false, -1);
    }
    boolean bool1 = bool2;
    if (getContext().getResources().getConfiguration().orientation != 1)
    {
      if (z.ip(paramContext)) {
        bool1 = bool2;
      }
    }
    else
    {
      this.Cch = bool1;
      if (com.tencent.mm.compatible.util.d.lf(24)) {
        this.Ccp = ((Activity)getContext()).isInMultiWindowMode();
      }
      ezu();
      ezz();
      if (com.tencent.mm.pluginsdk.model.app.aq.evU().BQX) {
        com.tencent.mm.pluginsdk.model.app.aq.evU().he(aj.getContext());
      }
      if ((!this.CbC.ezU()) && (this.fSY != null)) {
        this.fSY.onResume();
      }
      if ((this.CcD) || (!this.Ccf)) {
        break label293;
      }
      ezo();
    }
    for (;;)
    {
      Vf(getKeyBordHeightPX());
      if (this.Cbx != null) {
        this.Cbx.context = paramContext;
      }
      this.CbN.Cgq = false;
      if (!this.BWK) {
        ezn();
      }
      eyU();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184931);
          com.tencent.mm.compatible.util.i.v(ChatFooter.e(ChatFooter.this));
          AppMethodBeat.o(184931);
        }
      });
      AppMethodBeat.o(31575);
      return;
      bool1 = false;
      break;
      label293:
      if ((this.CcD) && (!this.Ccf)) {
        ezm();
      }
    }
  }
  
  public final void a(ChatFooter.b paramb)
  {
    AppMethodBeat.i(31574);
    this.CcF = paramb;
    this.CbP = new com.tencent.mm.plugin.groupsolitaire.ui.d(getContext(), this.CcF.ezT(), new d.d()
    {
      public final void adu(String paramAnonymousString)
      {
        AppMethodBeat.i(185758);
        if ((ChatFooter.l(ChatFooter.this) != null) && (!bt.isNullOrNil(paramAnonymousString))) {
          ChatFooter.l(ChatFooter.this).adu(paramAnonymousString);
        }
        AppMethodBeat.o(185758);
      }
      
      public final void cFq()
      {
        AppMethodBeat.i(185757);
        ChatFooter.this.cFq();
        ChatFooter.this.eyS();
        AppMethodBeat.o(185757);
      }
    });
    this.CbP.ssr = this.Ccy;
    AppMethodBeat.o(31574);
  }
  
  public final void a(final ChatFooter.h paramh)
  {
    AppMethodBeat.i(185822);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185361);
        ChatFooter.x(ChatFooter.this).setBackgroundResource(2131232725);
        ChatFooter.x(ChatFooter.this).setText(2131757093);
        if (ChatFooter.this.Cdm)
        {
          switch (ChatFooter.77.Cfp[paramh.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(185361);
            return;
            if (ChatFooter.C(ChatFooter.this) != null) {
              ChatFooter.ay(ChatFooter.this);
            }
          }
        }
        if (ChatFooter.L(ChatFooter.this) != null)
        {
          ChatFooter.L(ChatFooter.this).dismiss();
          if (ChatFooter.H(ChatFooter.this) != null) {
            ChatFooter.H(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(300L).withEndAction(ChatFooter.bd(ChatFooter.this)).start();
          }
          ChatFooter.be(ChatFooter.this).setVisibility(0);
          ChatFooter.bf(ChatFooter.this).setVisibility(8);
          ChatFooter.bg(ChatFooter.this).setVisibility(8);
          ChatFooter.ao(ChatFooter.this).setVisibility(8);
          ChatFooter.U(ChatFooter.this).setVisibility(8);
          ChatFooter.an(ChatFooter.this).setVisibility(0);
        }
        ChatFooter.e(ChatFooter.this, false);
        ChatFooter.d(ChatFooter.this, false);
        AppMethodBeat.o(185361);
      }
    });
    AppMethodBeat.o(185822);
  }
  
  public final void aC(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31632);
    this.Cbx.ud(paramBoolean1);
    this.Cbx.ue(paramBoolean2);
    AppMethodBeat.o(31632);
  }
  
  public final boolean aC(bl parambl)
  {
    AppMethodBeat.i(31678);
    this.CbK.setTag(parambl);
    this.Ccc = 1;
    uo(true);
    this.Cbz.setVisibility(8);
    UZ(2131231707);
    if (this.BWH != null)
    {
      this.BWH.setVisibility(8);
      this.BWK = false;
      this.BWH.reset();
    }
    showVKB();
    un(true);
    aCd("");
    AppMethodBeat.o(31678);
    return true;
  }
  
  public final void aCd(String paramString)
  {
    AppMethodBeat.i(31675);
    com.tencent.mm.plugin.groupsolitaire.ui.d locald;
    String str2;
    if ((this.CbP != null) && (this.fPz != null) && (this.CcF != null))
    {
      locald = this.CbP;
      str2 = this.CcF.getTalkerUserName();
      localObject = this.fPz;
      ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow supportAnalyze:%s supportShow:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).adg(str2)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).adh(str2)) });
      locald.sss = ((View)localObject);
      locald.content = paramString;
      if (((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).adg(str2))
      {
        if ((bt.isNullOrNil(paramString)) || (paramString.equals(locald.ssg))) {
          break label324;
        }
        com.tencent.e.h.Iye.aNW("GroupSolitaireCheck");
      }
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).Tk(paramString);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    locald.ssp.setContent(paramString);
    locald.ssp.adt(locald.srH);
    com.tencent.e.h.Iye.a(locald.ssp, 500L, "GroupSolitaireCheck");
    Object localObject = paramString;
    if (bt.isNullOrNil(locald.ssg))
    {
      locald.ssq.setContent(paramString);
      locald.ssq.adt(locald.srH);
      com.tencent.e.h.Iye.a(locald.ssq, 500L, "GroupSolitaireCopyCheck");
      localObject = paramString;
    }
    for (;;)
    {
      locald.ssg = ((String)localObject);
      locald.srH = str2;
      AppMethodBeat.o(31675);
      return;
      label324:
      String str1 = paramString;
      if (bt.isNullOrNil(paramString))
      {
        locald.cFn();
        str1 = paramString;
      }
    }
  }
  
  public final void aN(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31602);
    if (this.CbU.Cfv.containsKey(paramString1)) {}
    Object localObject;
    for (paramString1 = (LinkedList)this.CbU.Cfv.get(paramString1);; paramString1 = (String)localObject)
    {
      localObject = new HashMap(1);
      ((HashMap)localObject).put(paramString3, paramString2);
      paramString1.add(localObject);
      AppMethodBeat.o(31602);
      return;
      localObject = new LinkedList();
      this.CbU.Cfv.put(paramString1, localObject);
    }
  }
  
  public final void aP(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(31625);
    Vc(paramInt);
    switch (paramInt)
    {
    default: 
      setVisibility(0);
      AppMethodBeat.o(31625);
      return;
    case 1: 
      if (paramBoolean)
      {
        un(true);
        showVKB();
        if (this.tqv.length() > 0) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          mU(paramBoolean);
          AppMethodBeat.o(31625);
          return;
        }
      }
      if (this.tqv.length() > 0) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        mU(paramBoolean);
        AppMethodBeat.o(31625);
        return;
      }
    }
    g(0, true, -1);
    mU(false);
    AppMethodBeat.o(31625);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(31615);
    this.Cee = new i(paramTextWatcher);
    this.tqv.addTextChangedListener(this.Cee);
    AppMethodBeat.o(31615);
  }
  
  public final void bSf()
  {
    AppMethodBeat.i(31610);
    this.Cdg.setExitType(1);
    this.Cbz.setEnabled(false);
    this.Cbz.setBackgroundResource(2131233809);
    if (this.Cdm)
    {
      this.Cdq.setVisibility(8);
      this.Cdp.setVisibility(0);
      this.Cdo.update();
      this.oms.sendEmptyMessageDelayed(0, 500L);
      AppMethodBeat.o(31610);
      return;
    }
    if (this.yJL != null)
    {
      this.qeC.setVisibility(0);
      this.CbY.setVisibility(8);
      this.yJO.setVisibility(8);
      this.yJL.update();
      this.Cdf.dismiss();
    }
    this.oms.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(31610);
  }
  
  public final void cFq()
  {
    AppMethodBeat.i(31679);
    if (this.tqv != null)
    {
      this.tqv.setText("");
      eyR();
    }
    AppMethodBeat.o(31679);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31578);
    if (this.fSY != null)
    {
      ad.i("MicroMsg.ChatFooter", "jacks chat footer destroy smiley panel");
      this.fSY.exm();
      this.fSY.destroy();
      this.fSY.animate().cancel();
      this.fSY = null;
    }
    if (this.BWH != null)
    {
      this.BWH.destroy();
      this.BWH = null;
      this.BWK = false;
    }
    if (this.CbQ != null) {
      this.CbQ.release();
    }
    if (this.CbO != null)
    {
      this.CbO.CcC = null;
      this.CbO.CgB = null;
      this.CbO.hide();
    }
    if (this.yJL != null)
    {
      if (this.CcL != null) {
        this.CcL.getBlurController().destroy();
      }
      if (this.Cdb != null) {
        this.Cdb.getBlurController().destroy();
      }
    }
    ad.i("MicroMsg.ChatFooter", "jacks destroy chat footer.");
    AppMethodBeat.o(31578);
  }
  
  public final void exL()
  {
    AppMethodBeat.i(31601);
    if (!this.BWK)
    {
      AppMethodBeat.o(31601);
      return;
    }
    this.BWK = false;
    if (this.BWH != null)
    {
      int i = getKeyBordHeightPX();
      int j = this.CbB.getHeight();
      this.BWH.animate().cancel();
      this.BWH.animate().translationY(i + j).withEndAction(new ChatFooter.24(this)).start();
    }
    this.tqv.setText("");
    AppMethodBeat.o(31601);
  }
  
  public final void exn()
  {
    AppMethodBeat.i(31591);
    this.Ccg = true;
    if (this.fSY != null) {
      this.fSY.exn();
    }
    AppMethodBeat.o(31591);
  }
  
  public final void eyR()
  {
    AppMethodBeat.i(31572);
    if (this.Ccz != null)
    {
      com.tencent.mm.g.b.a.c localc = this.Ccz;
      localc.dFp = 0L;
      localc.dFn = 0L;
      localc.dFo = 0L;
      localc.dFq = 0L;
      localc.bq(0L).br(0L);
    }
    AppMethodBeat.o(31572);
  }
  
  public final void eyS()
  {
    AppMethodBeat.i(31581);
    if (!bt.ai(this.CbL.getText())) {
      this.CbL.setText("");
    }
    if (this.CbK.getTag() != null) {
      this.CbK.setTag(null);
    }
    this.CbK.setVisibility(8);
    AppMethodBeat.o(31581);
  }
  
  public final void eyT()
  {
    AppMethodBeat.i(31583);
    if (this.Cbx == null)
    {
      AppMethodBeat.o(31583);
      return;
    }
    this.Cbx.eyu();
    AppMethodBeat.o(31583);
  }
  
  public final void eyU()
  {
    AppMethodBeat.i(31587);
    this.CbG = ((ImageButton)this.hFi.findViewById(2131298172));
    this.CbG.setVisibility(0);
    if (!com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FtB, true)) {
      this.hFi.findViewById(2131298173).setVisibility(0);
    }
    for (;;)
    {
      this.hFi.findViewById(2131298173).setVisibility(8);
      this.CbG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184916);
          paramAnonymousView = com.tencent.mm.emoji.b.a.fRa;
          com.tencent.mm.emoji.b.a.acj();
          if (ChatFooter.l(ChatFooter.this) != null) {
            ChatFooter.l(ChatFooter.this).cOa();
          }
          if (ChatFooter.c(ChatFooter.this) == 2)
          {
            ChatFooter.this.showVKB();
            AppMethodBeat.o(184916);
            return;
          }
          if (ChatFooter.s(ChatFooter.this)) {
            ChatFooter.this.exn();
          }
          ChatFooter.this.eyX();
          if (!com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FtB, false))
          {
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtB, Boolean.TRUE);
            ChatFooter.t(ChatFooter.this).findViewById(2131298173).setVisibility(8);
          }
          AppMethodBeat.o(184916);
        }
      });
      if (this.CbO != null) {
        this.CbO.CgA = this.CbG;
      }
      if (this.CbP != null) {
        this.CbP.ssd = this.hFi;
      }
      AppMethodBeat.o(31587);
      return;
      this.hFi.findViewById(2131298173).setVisibility(8);
    }
  }
  
  public final void eyV()
  {
    boolean bool = true;
    AppMethodBeat.i(31590);
    if ((e.Cgj == null) || (getContext() == null))
    {
      if (getContext() == null)
      {
        ad.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", new Object[] { bt.eGN() });
        this.fSY = new d(aj.getContext());
        AppMethodBeat.o(31590);
        return;
      }
      this.fSY = new d(getContext());
      AppMethodBeat.o(31590);
      return;
    }
    if (this.fSY != null) {
      this.fSY.destroy();
    }
    this.fSY = e.Cgj.es(getContext());
    ChatFooterPanel localChatFooterPanel;
    if (this.fSY != null)
    {
      this.fSY.setEntranceScene(ChatFooterPanel.BUU);
      this.fSY.setVisibility(8);
      this.fSY.setFooterType(this.AHD);
      if (this.CbC != null) {
        this.CbC.addView(this.fSY, -1, -1);
      }
      this.fSY.setOnTextOperationListener(this.Ceb);
      localChatFooterPanel = this.fSY;
      if (this.tqv.getText().length() <= 0) {
        break label269;
      }
    }
    for (;;)
    {
      localChatFooterPanel.setSendButtonEnable(bool);
      if (this.CcF != null) {
        this.fSY.setTalkerName(this.CcF.getTalkerUserName());
      }
      this.fSY.onResume();
      if (this.Ccg) {
        exn();
      }
      setSmileyPanelCallback(this.BUS);
      AppMethodBeat.o(31590);
      return;
      label269:
      bool = false;
    }
  }
  
  public final void eyX()
  {
    AppMethodBeat.i(31597);
    this.Ccc = 1;
    uo(true);
    this.Cbz.setVisibility(8);
    UZ(2131231707);
    if (this.BWH != null)
    {
      this.BWH.setVisibility(8);
      this.BWK = false;
      this.BWH.reset();
    }
    g(2, true, -1);
    AppMethodBeat.o(31597);
  }
  
  public final void ezA()
  {
    AppMethodBeat.i(31685);
    if ((this.fPz == null) || (this.fPz.getVisibility() == 8))
    {
      AppMethodBeat.o(31685);
      return;
    }
    if (this.CeR == 0)
    {
      this.CeR = this.fPz.getWidth();
      this.CeS = this.CbE.getWidth();
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.CeR, this.CeS });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(185804);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bo(ChatFooter.this)) / (ChatFooter.bp(ChatFooter.this) - ChatFooter.bo(ChatFooter.this));
        ChatFooter.k(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(185804);
      }
    });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(185807);
        ChatFooter.k(ChatFooter.this).setVisibility(8);
        AppMethodBeat.o(185807);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(185806);
        if (!ChatFooter.bq(ChatFooter.this))
        {
          ChatFooter.k(ChatFooter.this).setVisibility(8);
          AppMethodBeat.o(185806);
          return;
        }
        ad.i("MicroMsg.ChatFooter", "animHideSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bq(ChatFooter.this)) });
        ChatFooter.this.ezB();
        AppMethodBeat.o(185806);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(185805);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(185805);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.start();
    AppMethodBeat.o(31685);
  }
  
  public final void ezB()
  {
    AppMethodBeat.i(31686);
    if (this.fPz == null)
    {
      AppMethodBeat.o(31686);
      return;
    }
    if (this.CeR == 0)
    {
      this.CeR = this.fPz.getWidth();
      this.CeS = this.CbE.getWidth();
    }
    if (this.CeR == 0)
    {
      this.fPz.startAnimation(this.CcG);
      this.fPz.setVisibility(0);
      AppMethodBeat.o(31686);
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.CeS, this.CeR });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(191311);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bo(ChatFooter.this)) / (ChatFooter.bp(ChatFooter.this) - ChatFooter.bo(ChatFooter.this));
        ChatFooter.k(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(191311);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(191314);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.i(ChatFooter.this, false);
        AppMethodBeat.o(191314);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(191313);
        paramAnonymousAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousAnimator.width = -2;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousAnimator);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.i(ChatFooter.this, false);
        if (!ChatFooter.bq(ChatFooter.this))
        {
          ad.i("MicroMsg.ChatFooter", "animShowSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bq(ChatFooter.this)) });
          ChatFooter.r(ChatFooter.this).setVisibility(0);
          ChatFooter.i(ChatFooter.this, true);
          ChatFooter.this.ezA();
        }
        AppMethodBeat.o(191313);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(191312);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(191312);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(31686);
  }
  
  public final boolean ezQ()
  {
    AppMethodBeat.i(185416);
    if ((this.Cdo != null) && (this.Cdo.isShowing()))
    {
      AppMethodBeat.o(185416);
      return true;
    }
    AppMethodBeat.o(185416);
    return false;
  }
  
  public final void eza()
  {
    AppMethodBeat.i(31620);
    if (this.Cdm)
    {
      this.Cdt.setVisibility(0);
      this.CdX.setVisibility(8);
      AppMethodBeat.o(31620);
      return;
    }
    this.yJO.setVisibility(8);
    this.CbY.setVisibility(0);
    AppMethodBeat.o(31620);
  }
  
  public final void ezb()
  {
    AppMethodBeat.i(31626);
    uo(true);
    this.CbA.setVisibility(8);
    this.Cbz.setVisibility(8);
    AppMethodBeat.o(31626);
  }
  
  public final void ezc()
  {
    AppMethodBeat.i(31627);
    if (this.CbA != null) {
      this.CbA.setVisibility(0);
    }
    AppMethodBeat.o(31627);
  }
  
  public final void ezd()
  {
    AppMethodBeat.i(31628);
    AppPanel localAppPanel = this.Cbx;
    localAppPanel.Cal.CaH.value = false;
    localAppPanel.eyE();
    AppMethodBeat.o(31628);
  }
  
  public final void eze()
  {
    AppMethodBeat.i(31629);
    AppPanel localAppPanel = this.Cbx;
    localAppPanel.Cal.CaZ.value = false;
    localAppPanel.eyE();
    AppMethodBeat.o(31629);
  }
  
  public final void ezf()
  {
    AppMethodBeat.i(31630);
    AppPanel localAppPanel = this.Cbx;
    localAppPanel.Cal.CaI.value = false;
    localAppPanel.eyE();
    AppMethodBeat.o(31630);
  }
  
  public final void ezg()
  {
    AppMethodBeat.i(31631);
    AppPanel localAppPanel = this.Cbx;
    localAppPanel.Cal.CaL.value = false;
    localAppPanel.eyE();
    AppMethodBeat.o(31631);
  }
  
  public final void ezh()
  {
    AppMethodBeat.i(31635);
    AppPanel localAppPanel = this.Cbx;
    localAppPanel.Cat = true;
    localAppPanel.Cal.ul(false);
    localAppPanel.eyE();
    ad.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", new Object[] { bt.eGN().toString() });
    AppMethodBeat.o(31635);
  }
  
  public final void ezi()
  {
    this.Cbx.Caw = true;
  }
  
  public final void ezj()
  {
    AppMethodBeat.i(31636);
    AppPanel localAppPanel = this.Cbx;
    localAppPanel.Cau = true;
    localAppPanel.Cal.ui(false);
    localAppPanel.eyE();
    ad.i("MicroMsg.AppPanel", "disableServiceRemittance %s", new Object[] { bt.eGN().toString() });
    AppMethodBeat.o(31636);
  }
  
  public final void ezk()
  {
    AppMethodBeat.i(31637);
    if (this.CbG != null) {
      this.CbG.setVisibility(8);
    }
    AppMethodBeat.o(31637);
  }
  
  public final void ezl()
  {
    AppMethodBeat.i(31638);
    AppPanel localAppPanel = this.Cbx;
    localAppPanel.Cav = true;
    localAppPanel.Cal.um(false);
    localAppPanel.eyE();
    AppMethodBeat.o(31638);
  }
  
  public final void ezm()
  {
    AppMethodBeat.i(31639);
    ad.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
    this.Ccf = true;
    this.tqv.setImeOptions(4);
    this.tqv.setInputType(this.tqv.getInputType() & 0xFFFFFFBF);
    AppMethodBeat.o(31639);
  }
  
  public final boolean ezp()
  {
    AppMethodBeat.i(31645);
    if ((this.CcE == null) || (this.CcE.getView() == null))
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Object localObject = this.CcE.getView().findViewById(2131302320);
    if (localObject == null)
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Rect localRect = new Rect();
    ((View)localObject).getGlobalVisibleRect(localRect);
    if (com.tencent.mm.compatible.util.d.lf(28))
    {
      localObject = ((View)localObject).getRootWindowInsets().getDisplayCutout();
      if (localObject == null) {}
    }
    for (int i = ((DisplayCutout)localObject).getSafeInsetLeft();; i = 0)
    {
      if (localRect.left > i)
      {
        AppMethodBeat.o(31645);
        return true;
      }
      AppMethodBeat.o(31645);
      return false;
    }
  }
  
  public final boolean ezq()
  {
    return this.Ccj != 0;
  }
  
  public final void ezr()
  {
    AppMethodBeat.i(31653);
    postDelayed(new ChatFooter.46(this), 500L);
    AppMethodBeat.o(31653);
  }
  
  public final void ezs()
  {
    AppMethodBeat.i(31655);
    if ((this.BWH != null) && (this.BWH.isShown())) {
      this.BWH.eAc();
    }
    AppMethodBeat.o(31655);
  }
  
  public final void ezv()
  {
    AppMethodBeat.i(191327);
    if (this.CbO != null)
    {
      this.CbO.CgC = false;
      this.CbO.hide();
    }
    AppMethodBeat.o(191327);
  }
  
  public final void ezw()
  {
    AppMethodBeat.i(31674);
    if (this.CbP != null) {
      this.CbP.cFn();
    }
    AppMethodBeat.o(31674);
  }
  
  public final boolean ezx()
  {
    AppMethodBeat.i(31677);
    if ((this.CbK.getTag() != null) && ((this.CbK.getTag() instanceof bl)) && (this.CbJ.isShown()) && (this.CbK.isShown()))
    {
      AppMethodBeat.o(31677);
      return true;
    }
    AppMethodBeat.o(31677);
    return false;
  }
  
  public final void ezy()
  {
    AppMethodBeat.i(31681);
    this.Cbz.setBackgroundResource(2131232725);
    this.Cbz.setText(2131757093);
    Object localObject;
    if (this.Cdm)
    {
      if (!this.CeN)
      {
        this.CeN = true;
        if (this.CbQ == null) {
          break label299;
        }
        this.Cdg.yWk = this.CbQ.Ou();
        if ((this.Cdo == null) || (!this.Cdo.isShowing())) {
          break label299;
        }
        if (e.Cfx == this.Cfb)
        {
          this.Cea = false;
          this.CbQ.cNX();
          this.Cdg.setExitType(2);
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FxF, Boolean.FALSE);
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        AppMethodBeat.o(31681);
        return;
      }
      if (e.Cfy == this.Cfb)
      {
        if (this.CeM <= 0) {
          this.CeM = ((int)this.CbQ.Ou());
        }
        if (!bt.isNullOrNil(this.CbQ.getFileName()))
        {
          localObject = com.tencent.mm.cl.a.FFw;
          com.tencent.mm.cl.a.a.aJU(this.CbQ.getFileName());
        }
        this.CbQ.cNV();
        ezP();
        this.yYk.sendEmptyMessageDelayed(5000, 5000L);
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FxF, Boolean.FALSE);
        AppMethodBeat.o(31681);
        return;
      }
      if (e.Cfw == this.Cfb)
      {
        this.Cea = false;
        this.CbQ.cNU();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FxE, Boolean.FALSE);
      }
      label299:
      AppMethodBeat.o(31681);
      return;
    }
    this.omf = false;
    if (this.CbQ != null)
    {
      this.Cdg.yWk = this.CbQ.Ou();
      if (this.Ccd)
      {
        if (k.CfO != this.Cdj)
        {
          this.CeL = true;
          if ((this.yJL != null) && (this.yJL.isShowing()))
          {
            if (k.CfQ == this.Cdj)
            {
              ad.i("MicroMsg.ChatFooter", "do not send voice.");
              this.Cdg.setExitType(2);
              this.CbQ.cNX();
              AppMethodBeat.o(31681);
              return;
            }
            ad.i("MicroMsg.ChatFooter", "trans voice to txt.");
            this.CbQ.cNV();
            localObject = this.CbQ.getFileName();
            final long l = this.CbQ.Ou();
            ad.i("transvoice", "fileName: %s, voiceLen: %d.", new Object[] { localObject, Long.valueOf(l) });
            if (ay.isConnected(getContext()))
            {
              if (this.Cde.isValid())
              {
                this.Cdc.asQ((String)localObject);
                this.Cdc.yYc = l;
                this.Cdc.talker = this.Cbw;
                this.Cdc.show();
                this.Cdc.c(this.Cde);
                this.Ccq = false;
                AppMethodBeat.o(31681);
                return;
              }
              this.Cdg.setExitType(3);
              locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
              locala.aMg(getResources().getString(2131764730));
              locala.aMm(getResources().getString(2131764731));
              locala.aaD(getResources().getColor(2131099770));
              locala.b(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(185799);
                  ChatFooter.l(ChatFooter.this).afH(this.cPO);
                  AppMethodBeat.o(185799);
                }
              });
              locala.wX(false);
              locala.fft().show();
              AppMethodBeat.o(31681);
              return;
            }
            this.Cdg.setExitType(4);
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
            locala.aMg(getResources().getString(2131761547));
            locala.aMm(getResources().getString(2131761549));
            locala.aaD(getResources().getColor(2131099770));
            locala.aMn(getResources().getString(2131761548));
            locala.b(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(191309);
                ChatFooter.l(ChatFooter.this).dC(this.cPO, (int)l);
                AppMethodBeat.o(191309);
              }
            });
            locala.c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(191310);
                ChatFooter.l(ChatFooter.this).afH(this.cPO);
                AppMethodBeat.o(191310);
              }
            });
            locala.fft().show();
            AppMethodBeat.o(31681);
          }
        }
        else
        {
          this.CbQ.cNU();
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        if ((this.qeF != null) && (this.qeF.getVisibility() == 0))
        {
          this.Cdg.setExitType(2);
          this.CbQ.cNX();
          AppMethodBeat.o(31681);
          return;
        }
        this.CbQ.cNU();
      }
    }
    AppMethodBeat.o(31681);
  }
  
  public final void ezz()
  {
    AppMethodBeat.i(31683);
    az.arV();
    this.CcD = ((Boolean)com.tencent.mm.model.c.afk().get(66832, Boolean.FALSE)).booleanValue();
    if (this.tqv != null) {
      this.tqv.setEnableSendBtn(this.CcD);
    }
    AppMethodBeat.o(31683);
  }
  
  public final int fB(String paramString, int paramInt)
  {
    AppMethodBeat.i(163213);
    int i = paramInt;
    if (this.CbU.Cfv.containsKey(paramString))
    {
      i = paramInt;
      if (((LinkedList)this.CbU.Cfv.get(paramString)).size() > 0) {
        i = paramInt | 0x1;
      }
    }
    paramInt = i;
    if (this.CbX) {
      paramInt = i | 0x2;
    }
    AppMethodBeat.o(163213);
    return paramInt;
  }
  
  public final void fu(View paramView)
  {
    int i = -1;
    AppMethodBeat.i(163212);
    if (this.CbQ != null) {
      this.CbQ.cOb();
    }
    ad.i("MicroMsg.ChatFooter", "click attach btn: %s, %s", new Object[] { Integer.valueOf(this.Cbx.getVisibility()), Boolean.valueOf(this.CbC.ezU()) });
    if (this.Ccj == 3)
    {
      if (this.Ccc == 1)
      {
        showVKB();
        AppMethodBeat.o(163212);
        return;
      }
      g(0, true, -1);
      AppMethodBeat.o(163212);
      return;
    }
    Object localObject;
    if (paramView == null)
    {
      g(3, true, i);
      if ((this.BWH != null) && (this.BWH.getVisibility() == 0) && (this.BWK))
      {
        ad.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
        this.BWH.setVisibility(8);
        this.BWK = false;
        this.BWH.reset();
      }
      paramView = com.tencent.mm.pluginsdk.model.app.aq.evU();
      localObject = aj.getContext();
      if ((com.tencent.mm.kernel.g.afw()) && (localObject != null)) {
        break label284;
      }
      label187:
      com.tencent.mm.pluginsdk.model.app.aq.evU().he(aj.getContext());
      if ((w.sm(this.toUser)) && (com.tencent.mm.chatroom.d.aa.UU()))
      {
        paramView = this.toUser;
        if (!w.ty(paramView)) {
          break label529;
        }
        i = 2;
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject = new com.tencent.mm.g.b.a.n();
        ((com.tencent.mm.g.b.a.n)localObject).fV(paramView);
        ((com.tencent.mm.g.b.a.n)localObject).dFf = 1L;
        ((com.tencent.mm.g.b.a.n)localObject).dHG = i;
        ((com.tencent.mm.g.b.a.n)localObject).aBj();
        AppMethodBeat.o(163212);
        return;
        if (paramView.getTag() == null) {
          break;
        }
        i = ((Integer)paramView.getTag()).intValue();
        break;
        try
        {
          label284:
          String str = com.tencent.mm.m.g.Zd().getValue("ShowAPPSuggestion");
          if ((bt.isNullOrNil(str)) || (Integer.valueOf(str).intValue() != 1)) {
            ad.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[] { str });
          }
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[] { localException.getMessage() });
          if (paramView.BQR)
          {
            ad.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
            break label187;
          }
          ad.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
          paramView.BQR = true;
          if (System.currentTimeMillis() - paramView.BQU < 43200000L)
          {
            ad.d("MicroMsg.SuggestionAppListLogic", "not now");
            paramView.BQR = false;
            break label187;
          }
          com.tencent.mm.kernel.g.afC();
          paramView.BQU = com.tencent.mm.kernel.g.afB().afk().Wx(352275);
          if (System.currentTimeMillis() - paramView.BQU < 43200000L)
          {
            ad.w("MicroMsg.SuggestionAppListLogic", "not now sp");
            paramView.BQR = false;
            break label187;
          }
          if (paramView.lang == null) {
            paramView.lang = ac.f(((Context)localObject).getSharedPreferences(aj.eFD(), 0));
          }
          paramView = new ag(paramView.lang, new LinkedList());
          com.tencent.mm.plugin.s.a.cZT();
          com.tencent.mm.pluginsdk.model.app.e.a(4, paramView);
        }
      }
      break label187;
      label529:
      if (w.tx(paramView)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void g(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(163217);
    ad.i("MicroMsg.ChatFooter", "configPanel: %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.srJ), Boolean.valueOf(this.Ccp), Boolean.valueOf(this.Cch) });
    int i;
    int j;
    label98:
    int k;
    if ((this.Ccp) || (!this.Cch))
    {
      i = 1;
      if ((paramInt1 != 1) || (this.srJ)) {
        break label194;
      }
      j = 1;
      if ((paramInt1 == 1) || (!this.srJ)) {
        break label200;
      }
      k = 1;
      label113:
      if ((i == 0) && ((j != 0) || (k != 0))) {
        break label206;
      }
      h(paramInt1, paramBoolean, paramInt2);
      label135:
      if (j != 0) {
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185794);
            ChatFooter.a(ChatFooter.this, true);
            ChatFooter.this.setToSendTextColor(true);
            boolean bool = ChatFooter.aO(ChatFooter.this).showSoftInput(ChatFooter.d(ChatFooter.this), 0);
            ad.i("MicroMsg.ChatFooter", "showSoftInput %b", new Object[] { Boolean.valueOf(bool) });
            if (!bool) {
              ChatFooter.this.postDelayed(this, 10L);
            }
            AppMethodBeat.o(185794);
          }
        });
      }
      if (k != 0) {
        hideVKB();
      }
      if (i != 0) {
        if (paramInt1 != 1) {
          break label214;
        }
      }
    }
    label194:
    label200:
    label206:
    label214:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.srJ = paramBoolean;
      AppMethodBeat.o(163217);
      return;
      i = 0;
      break;
      j = 0;
      break label98;
      k = 0;
      break label113;
      this.Cck = paramInt1;
      break label135;
    }
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163215);
    ArrayList localArrayList = this.Cbx.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163215);
    return localArrayList;
  }
  
  public String getAtSomebody()
  {
    return this.CbU.Cft;
  }
  
  public int getBarGroupHeight()
  {
    AppMethodBeat.i(31585);
    if (this.Cca == null) {
      this.Cca = findViewById(2131298090);
    }
    if (this.Cca != null)
    {
      i = this.Cca.getHeight();
      AppMethodBeat.o(31585);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131165299);
    AppMethodBeat.o(31585);
    return i;
  }
  
  public f getCallback()
  {
    return this.BUS;
  }
  
  public char getCharAtCursor()
  {
    AppMethodBeat.i(31614);
    int i = getSelectionStart();
    if (i <= 0)
    {
      AppMethodBeat.o(31614);
      return 'x';
    }
    char c = getLastText().charAt(i - 1);
    AppMethodBeat.o(31614);
    return c;
  }
  
  public int getCurrentScrollHeight()
  {
    return this.Cco;
  }
  
  public x.a getIOnToDoBarCallback()
  {
    return this.Ccx;
  }
  
  public int getInsertPos()
  {
    return this.CbU.Cfu;
  }
  
  public boolean getIsVoiceInputPanleShow()
  {
    return this.BWK;
  }
  
  public int getKeyBordHeightPX()
  {
    AppMethodBeat.i(31671);
    int i = z.in(getContext());
    AppMethodBeat.o(31671);
    return i;
  }
  
  public String getLastContent()
  {
    return this.CbU.Cfs;
  }
  
  public long getLastQuoteMsgId()
  {
    AppMethodBeat.i(31612);
    if ((this.CbK.getTag() != null) && ((this.CbK.getTag() instanceof bl)))
    {
      long l = ((bl)this.CbK.getTag()).field_msgId;
      AppMethodBeat.o(31612);
      return l;
    }
    AppMethodBeat.o(31612);
    return 0L;
  }
  
  public String getLastText()
  {
    AppMethodBeat.i(31611);
    if (this.tqv == null)
    {
      AppMethodBeat.o(31611);
      return "";
    }
    String str = this.tqv.getText().toString();
    AppMethodBeat.o(31611);
    return str;
  }
  
  public int getMode()
  {
    return this.Ccc;
  }
  
  public View getPanel()
  {
    return this.CbC;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(31613);
    int i = this.tqv.getSelectionStart();
    AppMethodBeat.o(31613);
    return i;
  }
  
  public int getSmieyType()
  {
    return 0;
  }
  
  public int getYFromBottom()
  {
    AppMethodBeat.i(31684);
    int i;
    if (this.Ccj == 0) {
      i = getHeight() - this.Ccs;
    }
    for (;;)
    {
      AppMethodBeat.o(31684);
      return i;
      int j = getHeight() - this.Ccs + getKeyBordHeightPX();
      i = j;
      if (this.Ccw != null) {
        i = j - this.Ccw.cFo();
      }
    }
  }
  
  public final boolean hideVKB()
  {
    AppMethodBeat.i(31659);
    if (getKeyBordHeightPX() / 2 <= getBottom())
    {
      boolean bool = bt.hideVKB(this);
      AppMethodBeat.o(31659);
      return bool;
    }
    AppMethodBeat.o(31659);
    return false;
  }
  
  public final void k(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(31582);
    if ((this.CbK.getTag() != null) && ((this.CbK.getTag() instanceof bl)) && (bt.aw(paramLong, ((bl)this.CbK.getTag()).field_msgId))) {
      com.tencent.mm.sdk.platformtools.aq.f(new ChatFooter.55(this, paramBoolean));
    }
    AppMethodBeat.o(31582);
  }
  
  public final HashMap<String, String> kD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31603);
    long l = System.currentTimeMillis();
    if (bt.isNullOrNil(paramString2))
    {
      if (this.CbU.Cfv.containsKey(paramString1)) {
        this.CbU.Cfv.remove(paramString1);
      }
      AppMethodBeat.o(31603);
      return null;
    }
    if ((!this.CbU.Cfv.containsKey(paramString1)) || (((LinkedList)this.CbU.Cfv.get(paramString1)).size() <= 0))
    {
      AppMethodBeat.o(31603);
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
    ad.i("MicroMsg.ChatFooter", "after split @ :%s", new Object[] { localObject });
    if (((List)localObject).size() <= 0)
    {
      ((LinkedList)this.CbU.Cfv.get(paramString1)).clear();
      AppMethodBeat.o(31603);
      return null;
    }
    paramString1 = (LinkedList)this.CbU.Cfv.get(paramString1);
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      ad.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", new Object[] { Integer.valueOf(paramString1.size()) });
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
      ad.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", new Object[] { Integer.valueOf(paramString2.size()) });
      ((HashMap)localObject).put("atuserlist", "<![CDATA[" + bt.n(paramString2, ",") + "]]>");
      paramString1.clear();
      ad.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(31603);
      return localObject;
    }
    ad.w("MicroMsg.ChatFooter", "list is null or size 0");
    AppMethodBeat.o(31603);
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(31579);
    super.onAttachedToWindow();
    ezu();
    ezt();
    Vf(getKeyBordHeightPX());
    AppMethodBeat.o(31579);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31643);
    super.onConfigurationChanged(paramConfiguration);
    if (com.tencent.mm.compatible.util.d.lf(24)) {
      this.Ccp = ((Activity)getContext()).isInMultiWindowMode();
    }
    if (paramConfiguration.orientation == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.Cch = bool;
      g(0, false, -1);
      ezu();
      ad.i("MicroMsg.ChatFooter", "onConfigurationChanged: %s, %s, %s", new Object[] { paramConfiguration, Boolean.valueOf(this.Cch), Boolean.valueOf(this.Ccp) });
      Vf(getKeyBordHeightPX());
      AppMethodBeat.o(31643);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(31580);
    super.onDetachedFromWindow();
    this.ftZ.close();
    this.Ccl = null;
    this.Ccm = false;
    AppMethodBeat.o(31580);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31669);
    ad.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", new Object[] { Integer.valueOf(View.MeasureSpec.getSize(paramInt2)), Integer.valueOf(getMeasuredHeight()) });
    super.onMeasure(paramInt1, paramInt2);
    ad.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    AppMethodBeat.o(31669);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(31577);
    ad.i("MicroMsg.ChatFooter", "onPause");
    this.Cci = false;
    if ((this.Ccn == 48) && (this.Ccj == 1) && (!this.Ccv))
    {
      this.srJ = false;
      h(0, true, -1);
    }
    this.ftZ.close();
    if (this.fSY != null) {
      this.fSY.onPause();
    }
    if ((this.BWK) && (this.BWH != null)) {
      this.BWH.pause();
    }
    if (this.CbQ != null) {
      this.CbQ.onPause();
    }
    if (this.CbO != null) {
      this.CbO.hide();
    }
    if ((this.yJL != null) && (this.yJL.isShowing())) {
      this.yJL.dismiss();
    }
    ezw();
    AppMethodBeat.o(31577);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31672);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ad.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(31672);
  }
  
  public void setAppPanelListener(AppPanel.a parama)
  {
    AppMethodBeat.i(31649);
    this.Cbx.setAppPanelListener(parama);
    AppMethodBeat.o(31649);
  }
  
  public void setAppPanelTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(31595);
    if ((this.CbD == null) || (this.Cbx == null))
    {
      AppMethodBeat.o(31595);
      return;
    }
    this.CbD.setText(paramCharSequence);
    if (!bt.ai(paramCharSequence)) {
      if (this.Cbx.getVisibility() != 0) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      setAppPanelTipVisible(bool);
      AppMethodBeat.o(31595);
      return;
    }
  }
  
  public void setAppPanelTipVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(31596);
    if (this.CbD == null)
    {
      AppMethodBeat.o(31596);
      return;
    }
    if (TextUtils.isEmpty(this.CbD.getText()))
    {
      this.CbD.setVisibility(8);
      AppMethodBeat.o(31596);
      return;
    }
    if (paramBoolean)
    {
      localObject = this.CbD.getContext();
      i = this.CbC.getHeight();
      int j = getKeyBordHeightPX();
      int k = com.tencent.mm.cd.a.fromDPToPix((Context)localObject, 32);
      localObject = this.CbD.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (i - j + k);
        this.CbD.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    Object localObject = this.CbD;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      AppMethodBeat.o(31596);
      return;
    }
  }
  
  public void setAppPanelUnCertainEnterArrayList(ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(163214);
    this.Cbx.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163214);
  }
  
  public void setAppPanelVisible(int paramInt)
  {
    AppMethodBeat.i(31642);
    if (this.Cbx != null) {
      this.Cbx.setVisibility(paramInt);
    }
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      setAppPanelTipVisible(bool);
      AppMethodBeat.o(31642);
      return;
    }
  }
  
  public void setAtSomebody(String paramString)
  {
    this.CbU.Cft = paramString;
  }
  
  public void setBottomPanelVisibility(int paramInt)
  {
    AppMethodBeat.i(31644);
    if (paramInt == 0)
    {
      this.CbC.setVisibility(paramInt);
      AppMethodBeat.o(31644);
      return;
    }
    g(0, true, -1);
    AppMethodBeat.o(31644);
  }
  
  public void setCattingRootLayoutId(int paramInt)
  {
    this.CeQ = null;
    this.CeP = paramInt;
  }
  
  public void setDefaultSmileyByDetail(String paramString)
  {
    AppMethodBeat.i(31600);
    if (!bt.isNullOrNil(paramString))
    {
      if (this.fSY == null) {
        eyV();
      }
      this.fSY.setDefaultEmojiByDetail(paramString);
    }
    AppMethodBeat.o(31600);
  }
  
  @TargetApi(11)
  public void setEditTextOnDragListener(View.OnDragListener paramOnDragListener)
  {
    AppMethodBeat.i(31647);
    this.tqv.setOnDragListener(paramOnDragListener);
    AppMethodBeat.o(31647);
  }
  
  public void setExitType(int paramInt)
  {
    AppMethodBeat.i(185414);
    c.a locala = com.tencent.mm.plugin.transvoice.a.c.yWx;
    com.tencent.mm.plugin.transvoice.a.c.dQE().setExitType(paramInt);
    AppMethodBeat.o(185414);
  }
  
  public void setFooterEventListener(b paramb)
  {
    this.CbQ = paramb;
  }
  
  public void setFooterType(int paramInt)
  {
    AppMethodBeat.i(31576);
    this.AHD = paramInt;
    if (this.fSY != null) {
      this.fSY.setFooterType(paramInt);
    }
    AppMethodBeat.o(31576);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(31609);
    if (this.tqv != null) {
      this.tqv.setHint(paramString);
    }
    AppMethodBeat.o(31609);
  }
  
  public void setIOnTodoViewCallback(x.c paramc)
  {
    this.Ccw = paramc;
  }
  
  public void setIgnoreScroll(Boolean paramBoolean)
  {
    AppMethodBeat.i(31661);
    this.Ccv = paramBoolean.booleanValue();
    AppMethodBeat.o(31661);
  }
  
  public void setInsertPos(int paramInt)
  {
    this.CbU.Cfu = paramInt;
  }
  
  public void setIsMultiWindow(boolean paramBoolean)
  {
    AppMethodBeat.i(31667);
    ad.i("MicroMsg.ChatFooter", "setIsMultiWindow: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Ccp = paramBoolean;
    ezu();
    AppMethodBeat.o(31667);
  }
  
  public void setKeyboardShow(Boolean paramBoolean)
  {
    AppMethodBeat.i(31662);
    this.srJ = paramBoolean.booleanValue();
    AppMethodBeat.o(31662);
  }
  
  public void setLastContent(String paramString)
  {
    this.CbU.Cfs = paramString;
  }
  
  public void setLastQuoteMsgId(long paramLong)
  {
    AppMethodBeat.i(31605);
    if (paramLong != 0L)
    {
      bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramLong);
      if (((localbl.esg & 0x4) == 4) || (localbl.getType() == 10000))
      {
        ad.e("MicroMsg.ChatFooter", "msg(%s) is revoked!", new Object[] { localbl.getType() + "," + (localbl.esg & 0x4) });
        com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(2131761359), "", true);
        AppMethodBeat.o(31605);
        return;
      }
      this.CbK.setTag(localbl);
      AppMethodBeat.o(31605);
      return;
    }
    this.CbK.setTag(null);
    AppMethodBeat.o(31605);
  }
  
  public void setLastText(String paramString)
  {
    AppMethodBeat.i(31606);
    w(paramString, -1, true);
    AppMethodBeat.o(31606);
  }
  
  public void setLbsMode(boolean paramBoolean)
  {
    this.CbW = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    AppMethodBeat.i(31623);
    aP(paramInt, true);
    AppMethodBeat.o(31623);
  }
  
  public void setOnEditFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(31648);
    this.tqv.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(31648);
  }
  
  public void setOnFooterPanelSwitchListener(ChatFooter.f paramf)
  {
    this.CbS = paramf;
  }
  
  public void setOnFooterSwitchListener(ChatFooter.g paramg)
  {
    AppMethodBeat.i(31650);
    this.CbR = paramg;
    if (paramg == null)
    {
      AppMethodBeat.o(31650);
      return;
    }
    paramg = findViewById(2131298150);
    paramg.setVisibility(0);
    paramg.setOnClickListener(new ChatFooter.43(this));
    AppMethodBeat.o(31650);
  }
  
  public void setRecordNormalWording(String paramString)
  {
    AppMethodBeat.i(31618);
    if ((paramString == null) || (this.CbZ == null))
    {
      AppMethodBeat.o(31618);
      return;
    }
    this.CbZ.setText(paramString);
    AppMethodBeat.o(31618);
  }
  
  public void setSetTolastCustomPage(boolean paramBoolean) {}
  
  public void setSmileyPanelCallback(f paramf)
  {
    AppMethodBeat.i(31592);
    this.BUS = paramf;
    if (this.fSY != null) {
      this.fSY.setCallback(paramf);
    }
    AppMethodBeat.o(31592);
  }
  
  public void setSmileyPanelCallback2(j paramj)
  {
    this.CbO.CgB = paramj;
  }
  
  public void setSwitchButtonMode(int paramInt)
  {
    AppMethodBeat.i(31651);
    if (paramInt == this.CeF)
    {
      AppMethodBeat.o(31651);
      return;
    }
    this.CeF = paramInt;
    ImageView localImageView1 = (ImageView)findViewById(2131305574);
    ImageView localImageView2 = (ImageView)findViewById(2131303025);
    if (this.CeF == 1)
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
      AppMethodBeat.o(31651);
      return;
    }
    localImageView1.setVisibility(0);
    localImageView2.setVisibility(8);
    AppMethodBeat.o(31651);
  }
  
  public void setTipsShowCallback(ChatFooter.c paramc)
  {
    this.CcA = paramc;
  }
  
  @TargetApi(11)
  public void setToSendTextColor(final boolean paramBoolean)
  {
    AppMethodBeat.i(31652);
    if (com.tencent.mm.compatible.util.d.lf(11))
    {
      com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a()
      {
        public final void run()
        {
          AppMethodBeat.i(31551);
          Message localMessage = new Message();
          localMessage.what = 1002;
          localMessage.obj = Boolean.valueOf(paramBoolean);
          ChatFooter.bi(ChatFooter.this).sendMessage(localMessage);
          AppMethodBeat.o(31551);
        }
      });
      AppMethodBeat.o(31652);
      return;
    }
    if (paramBoolean)
    {
      this.tqv.setTextColor(getResources().getColor(2131100636));
      AppMethodBeat.o(31652);
      return;
    }
    this.tqv.setTextColor(getResources().getColor(2131100482));
    un(false);
    AppMethodBeat.o(31652);
  }
  
  public void setUserName(String paramString)
  {
    AppMethodBeat.i(31682);
    this.Cbw = paramString;
    if (this.fSY != null) {
      this.fSY.setTalkerName(this.Cbw);
    }
    if (this.Cbx != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ChatFooter", "setusername: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (this.Cbx == null) {
        break label167;
      }
      if ((!w.to(this.Cbw)) && (!w.tg(this.Cbw))) {
        break;
      }
      this.Cbx.setServiceShowFlag(0);
      AppMethodBeat.o(31682);
      return;
    }
    if (w.sE(this.Cbw))
    {
      this.Cbx.setServiceShowFlag(4);
      AppMethodBeat.o(31682);
      return;
    }
    if (w.pF(this.Cbw))
    {
      this.Cbx.setServiceShowFlag(2);
      AppMethodBeat.o(31682);
      return;
    }
    this.Cbx.setServiceShowFlag(1);
    label167:
    AppMethodBeat.o(31682);
  }
  
  public void setVoice2txtCountDown(int paramInt)
  {
    AppMethodBeat.i(31619);
    if (-1 == paramInt)
    {
      this.CcN.setVisibility(0);
      this.CcP.setVisibility(8);
      AppMethodBeat.o(31619);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 10))
    {
      if (8 == this.CcP.getVisibility())
      {
        this.CcN.setVisibility(8);
        this.CcP.setVisibility(0);
      }
      if (this.CcP != null) {
        this.CcP.setImageResource(this.Cep[paramInt]);
      }
    }
    AppMethodBeat.o(31619);
  }
  
  public void setVoiceInputShowCallback(d paramd)
  {
    this.CcB = paramd;
  }
  
  public void setVoiceReactArea(int paramInt)
  {
    AppMethodBeat.i(185401);
    if (this.Cdm)
    {
      setNewVoice2TxtCountDown(paramInt);
      AppMethodBeat.o(185401);
      return;
    }
    if (paramInt < 10)
    {
      if (this.Ccd)
      {
        setVoice2txtCountDown(paramInt);
        AppMethodBeat.o(185401);
        return;
      }
      if (-1 == paramInt)
      {
        setRecordNormalWording(getResources().getString(2131757076));
        AppMethodBeat.o(185401);
        return;
      }
      setRecordNormalWording(getResources().getQuantityString(2131623938, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    }
    AppMethodBeat.o(185401);
  }
  
  public void setWordCountLimit(int paramInt)
  {
    AppMethodBeat.i(31646);
    this.Cby = ((TextView)this.hFi.findViewById(2131298212));
    this.tqv.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(31646);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(31656);
    if ((this.CcE != null) && (this.CcE.isSupportNavigationSwipeBack()) && (this.CcE.getSwipeBackLayout() != null)) {
      this.CcE.getSwipeBackLayout().setOnceDisEnableGesture(true);
    }
    if (!ezp())
    {
      g(1, true, -1);
      AppMethodBeat.o(31656);
      return;
    }
    ad.i("changelcai", "isScrolling!! pass this event!");
    AppMethodBeat.o(31656);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(31670);
    ad.i("MicroMsg.ChatFooter", "onKeyboardHeightChanged: %s, %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(this.Ccn) });
    if (!this.Ccq)
    {
      AppMethodBeat.o(31670);
      return;
    }
    int i;
    if ((this.Cdm) && (this.Cdo != null) && (this.Cdo.isShowing()))
    {
      Object localObject;
      if (paramInt <= 0)
      {
        this.Cds.setCursorVisible(false);
        this.srJ = false;
        this.CdC.animate().translationY(0.0F).setDuration(200L).start();
        this.Cdr.animate().translationY(0.0F).setDuration(200L).start();
        this.Cdu.animate().translationY(0.0F).setDuration(200L).start();
        this.Cdx.animate().translationY(0.0F).setDuration(200L).start();
        if (this.Cdr.getHeight() < this.Cez)
        {
          localObject = ValueAnimator.ofInt(new int[] { this.Cdr.getHeight(), this.Cez }).setDuration(200L);
          ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              AppMethodBeat.i(191305);
              int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
              ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).height = i;
              ChatFooter.az(ChatFooter.this).requestLayout();
              AppMethodBeat.o(191305);
            }
          });
          ((ValueAnimator)localObject).start();
          AppMethodBeat.o(31670);
        }
      }
      else
      {
        this.Cds.setCursorVisible(true);
        this.srJ = true;
        ad.d("MicroMsg.ChatFooter", "height:%s, WeUIToolHelper.getDisplayRealSize(getContext()).y - newVoice2txtOpeArea.getBottom():%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.ui.ap.cf(getContext()).y - this.CdC.getBottom()) });
        i = com.tencent.mm.ui.ap.cf(getContext()).y;
        localObject = new int[2];
        this.CdC.getLocationOnScreen((int[])localObject);
        j = localObject[1];
        int k = this.CdC.getHeight();
        int m = com.tencent.mm.ui.ap.eb(getContext());
        this.CdC.animate().translationY(-(paramInt - (i - (j + k)) + m)).setDuration(200L).start();
        paramInt = i - (this.CdC.getHeight() + paramInt) - ao.fromDPToPix(getContext(), 24);
        i = this.Cdr.getHeight() + this.Cdu.getHeight() + ao.fromDPToPix(getContext(), 48);
        ad.d("MicroMsg.ChatFooter", "leftSpcaeDown:%s, editDown:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        this.Cey = (paramInt - ao.fromDPToPix(getContext(), 52));
        this.Cez = this.Cdr.getHeight();
        localObject = new int[2];
        this.Cdu.getLocationOnScreen((int[])localObject);
        j = localObject[1] + this.Cdu.getHeight();
        if (j > paramInt)
        {
          j -= paramInt;
          if (i > paramInt)
          {
            k = this.Cdr.getLayoutParams().height;
            localObject = ValueAnimator.ofInt(new int[] { k, k - (i - paramInt) }).setDuration(200L);
            ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
              {
                AppMethodBeat.i(191306);
                int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
                ChatFooter.az(ChatFooter.this).getLayoutParams().height = i;
                ChatFooter.az(ChatFooter.this).requestLayout();
                AppMethodBeat.o(191306);
              }
            });
            ((ValueAnimator)localObject).start();
          }
          this.Cdr.animate().translationY(-j).setDuration(200L).start();
          this.Cdu.animate().translationY(-j).setDuration(200L).start();
          this.Cdx.animate().translationY(-j).setDuration(200L).start();
        }
      }
      AppMethodBeat.o(31670);
      return;
    }
    if ((!this.Ccp) && (this.Cch))
    {
      if (this.Ccr == paramBoolean) {
        break label782;
      }
      i = 1;
      this.Ccr = paramBoolean;
      if (paramInt <= 0) {
        break label842;
      }
      if (this.mEi == paramInt) {
        break label914;
      }
      this.mEi = paramInt;
      com.tencent.mm.compatible.util.i.A(getContext(), paramInt);
      Vf(paramInt);
    }
    label782:
    label914:
    for (paramInt = 1;; paramInt = 0)
    {
      if (!this.srJ)
      {
        h(1, true, -1);
        this.Cck = -1;
      }
      while ((paramInt == 0) && (i == 0))
      {
        this.srJ = true;
        if (this.CbQ != null) {
          this.CbQ.nb(this.srJ);
        }
        AppMethodBeat.o(31670);
        return;
        i = 0;
        break;
      }
      this.Cco = this.mEi;
      i = this.Cco;
      if (this.Ccw == null) {}
      for (paramInt = j;; paramInt = this.Ccw.cFo())
      {
        b(i, true, 1, paramInt);
        break;
      }
      label842:
      if (this.srJ)
      {
        if (this.Cck == -1) {
          break label904;
        }
        h(this.Cck, true, -1);
        this.Cck = -1;
      }
      for (;;)
      {
        if (this.Ccj == 1)
        {
          ad.i("MicroMsg.ChatFooter", "keyboard not open");
          h(0, true, -1);
        }
        this.srJ = false;
        break;
        h(0, true, -1);
      }
    }
  }
  
  public final void uf(boolean paramBoolean)
  {
    AppMethodBeat.i(31633);
    this.Cbx.uf(paramBoolean);
    AppMethodBeat.o(31633);
  }
  
  public final void ug(boolean paramBoolean)
  {
    AppMethodBeat.i(31634);
    this.Cbx.ug(paramBoolean);
    AppMethodBeat.o(31634);
  }
  
  public final void un(boolean paramBoolean)
  {
    AppMethodBeat.i(31588);
    ad.i("MicroMsg.ChatFooter", "pureForcusEdtChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.tqv });
    if (this.tqv == null)
    {
      AppMethodBeat.o(31588);
      return;
    }
    if (paramBoolean)
    {
      this.tqv.requestFocus();
      AppMethodBeat.o(31588);
      return;
    }
    this.tqv.clearFocus();
    AppMethodBeat.o(31588);
  }
  
  public final void up(boolean paramBoolean)
  {
    AppMethodBeat.i(31654);
    ad.i("MicroMsg.ChatFooter", "withoutLastText: ");
    hideVKB();
    un(paramBoolean);
    AppMethodBeat.o(31654);
  }
  
  public final void ur(boolean paramBoolean)
  {
    AppMethodBeat.i(163220);
    if (this.CbE == null)
    {
      ad.e("MicroMsg.ChatFooter", "mAttachButton is null");
      AppMethodBeat.o(163220);
      return;
    }
    if (this.CbF != null) {
      if ((paramBoolean) && (getAppPanelUnCertainEnterArrayList() != null) && (getAppPanelUnCertainEnterArrayList().size() > 0))
      {
        Iterator localIterator = getAppPanelUnCertainEnterArrayList().iterator();
        a.a locala;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          locala = (a.a)localIterator.next();
        } while ((locala.Cbj != 1) || (aCe(locala.Cbi)));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.CbF.setVisibility(0);
        AppMethodBeat.o(163220);
        return;
      }
      this.CbF.setVisibility(8);
      AppMethodBeat.o(163220);
      return;
    }
  }
  
  public final void w(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(31607);
    if (cFm())
    {
      ad.i("MicroMsg.ChatFooter", "setLastText() isBackFromGroupSolitatire");
      AppMethodBeat.o(31607);
      return;
    }
    if ((paramBoolean) && ((paramString == null) || (paramString.length() == 0) || (this.tqv == null)))
    {
      this.tqv.setText("");
      eyR();
      AppMethodBeat.o(31607);
      return;
    }
    this.CbV = true;
    this.tqv.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), paramString, this.tqv.getTextSize()));
    this.CbV = false;
    if ((paramInt < 0) || (paramInt > this.tqv.getText().length()))
    {
      this.tqv.setSelection(this.tqv.getText().length());
      AppMethodBeat.o(31607);
      return;
    }
    this.tqv.setSelection(paramInt);
    AppMethodBeat.o(31607);
  }
  
  public static final class a
  {
    public String Cfs;
    String Cft;
    int Cfu;
    HashMap<String, LinkedList<HashMap<String, String>>> Cfv;
    
    private a()
    {
      AppMethodBeat.i(31558);
      this.Cfv = new HashMap();
      AppMethodBeat.o(31558);
    }
  }
  
  public static abstract interface d
  {
    public abstract void j(Boolean paramBoolean);
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(185398);
      Cfw = new e("MODE_VOICE", 0);
      Cfx = new e("MODE_CANCEL", 1);
      Cfy = new e("MODE_TRANS", 2);
      Cfz = new e[] { Cfw, Cfx, Cfy };
      AppMethodBeat.o(185398);
    }
    
    private e() {}
  }
  
  public final class i
    implements TextWatcher
  {
    TextWatcher CfH;
    private boolean CfI;
    private boolean CfJ;
    
    public i(TextWatcher paramTextWatcher)
    {
      AppMethodBeat.i(31559);
      this.CfI = false;
      this.CfJ = com.tencent.mm.compatible.util.d.lg(11);
      this.CfH = paramTextWatcher;
      AppMethodBeat.o(31559);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      boolean bool = true;
      AppMethodBeat.i(31560);
      if ((ChatFooter.j(ChatFooter.this)) && (this.CfI) && (paramEditable.length() > 0))
      {
        this.CfI = false;
        ChatFooter.d(ChatFooter.this).setText(paramEditable.subSequence(0, paramEditable.length() - 1));
        if (ChatFooter.d(ChatFooter.this).length() > 0)
        {
          ChatFooter.k(ChatFooter.this).performClick();
          ad.i("MicroMsg.ChatFooter", "enter button, do send");
        }
        ad.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        AppMethodBeat.o(31560);
        return;
      }
      this.CfH.afterTextChanged(paramEditable);
      if (ChatFooter.u(ChatFooter.this) != null)
      {
        if (ChatFooter.d(ChatFooter.this).getLineCount() > 1)
        {
          ChatFooter.u(ChatFooter.this).setVisibility(0);
          ChatFooter.u(ChatFooter.this).setText(paramEditable.length() + "/140");
        }
      }
      else {
        if ((paramEditable.length() <= 0) || (paramEditable.toString().trim().length() <= 0)) {
          break label300;
        }
      }
      for (;;)
      {
        ChatFooter.b(ChatFooter.this, bool);
        if (ChatFooter.v(ChatFooter.this) != null) {
          ChatFooter.v(ChatFooter.this).setSendButtonEnable(bool);
        }
        ad.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        AppMethodBeat.o(31560);
        return;
        ChatFooter.u(ChatFooter.this).setVisibility(8);
        break;
        label300:
        bool = false;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(31561);
      this.CfH.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      ad.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
      AppMethodBeat.o(31561);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(31562);
      if ((ChatFooter.j(ChatFooter.this)) && (paramInt2 == 0) && (paramInt1 == paramCharSequence.length() - 1) && (paramInt3 == 1) && (paramCharSequence.charAt(paramCharSequence.length() - 1) == '\n'))
      {
        ad.i("MicroMsg.ChatFooter", "text changed, enter button");
        this.CfI = true;
        AppMethodBeat.o(31562);
        return;
      }
      this.CfH.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      ChatFooter.this.Ccz.dFo += 1L;
      ChatFooter.this.Ccz.PY();
      if (ChatFooter.this.Ccz.dFl == 0L) {
        ChatFooter.this.Ccz.PX();
      }
      AppMethodBeat.o(31562);
    }
  }
  
  static enum j
  {
    static
    {
      AppMethodBeat.i(31565);
      CfK = new j("MODE_INVALID", 0);
      CfL = new j("MODE_BLUR", 1);
      CfM = new j("MODE_NORMAL", 2);
      CfN = new j[] { CfK, CfL, CfM };
      AppMethodBeat.o(31565);
    }
    
    private j() {}
  }
  
  static enum k
  {
    static
    {
      AppMethodBeat.i(31568);
      CfO = new k("MODE_INVALID", 0);
      CfP = new k("MODE_TRANS", 1);
      CfQ = new k("MODE_CANCEL", 2);
      CfR = new k[] { CfO, CfP, CfQ };
      AppMethodBeat.o(31568);
    }
    
    private k() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter
 * JD-Core Version:    0.7.0.1
 */