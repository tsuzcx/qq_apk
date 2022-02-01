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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
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
  private static int Dva;
  private static final int[] DwU;
  private static final int[] DwV;
  public static final String Dxf;
  private static int count;
  private final long ANIMATION_DURATION;
  private int AjO;
  com.tencent.mm.plugin.transvoice.a.b AlP;
  private String AlU;
  private int AlV;
  private au AlW;
  private boolean AlX;
  private com.tencent.mm.sdk.platformtools.ao AlZ;
  private com.tencent.mm.modelvoiceaddr.b.b Amh;
  private List<String> Ami;
  private int Anl;
  private int BZU;
  f Dni;
  public n DoY;
  public boolean Dpb;
  public String DtO;
  public AppPanel DtP;
  public TextView DtQ;
  private Button DtR;
  public ImageButton DtS;
  private View DtT;
  public ChatFooterBottom DtU;
  private TextView DtV;
  public ImageButton DtW;
  public ImageView DtX;
  public ImageButton DtY;
  public View DtZ;
  private boolean DuA;
  public int DuB;
  private int DuC;
  private ChattingScrollLayout DuD;
  private boolean DuE;
  private int DuF;
  private int DuG;
  private boolean DuH;
  private boolean DuI;
  private boolean DuJ;
  private int DuK;
  private int DuL;
  private int DuM;
  private boolean DuN;
  private x.c DuO;
  private x.a DuP;
  private d.c DuQ;
  com.tencent.mm.g.b.a.c DuR;
  public c DuS;
  public d DuT;
  private m.a DuU;
  private boolean DuV;
  public MMFragment DuW;
  public b DuX;
  private Animation DuY;
  private Animation DuZ;
  private com.tencent.mm.ui.widget.a.d Dua;
  public LinearLayout Dub;
  public RelativeLayout Duc;
  private TextView Dud;
  private WeImageView Due;
  private i Duf;
  public m Dug;
  private com.tencent.mm.plugin.groupsolitaire.ui.d Duh;
  private b Dui;
  private g Duj;
  private f Duk;
  private ClipboardManager Dul;
  public final a Dum;
  public boolean Dun;
  private boolean Duo;
  public boolean Dup;
  public ViewGroup Duq;
  private TextView Dur;
  private View Dus;
  private InputMethodManager Dut;
  private int Duu;
  private boolean Duv;
  private boolean Duw;
  private boolean Dux;
  public boolean Duy;
  private boolean Duz;
  private j DvA;
  private k DvB;
  private boolean DvC;
  private boolean DvD;
  public boolean DvE;
  private float DvF;
  private o DvG;
  private View DvH;
  private View DvI;
  private ViewGroup DvJ;
  private EditText DvK;
  private SoundWaveView DvL;
  private ImageView DvM;
  private ViewGroup DvN;
  private TextView DvO;
  private WeImageView DvP;
  public LanguageChoiceLayout DvQ;
  private TextView DvR;
  private ViewGroup DvS;
  private TextView DvT;
  private ViewGroup DvU;
  private ViewGroup DvV;
  private View DvW;
  private View DvX;
  private WeImageView DvY;
  private WeImageView DvZ;
  public ViewGroup Dvb;
  private View Dvc;
  private BlurView Dvd;
  private View Dve;
  private View Dvf;
  private ImageView Dvg;
  private ImageView Dvh;
  private View Dvi;
  private TextView Dvj;
  private ImageView Dvk;
  private View Dvl;
  private View Dvm;
  private WeImageView Dvn;
  private TextView Dvo;
  private View Dvp;
  private WeImageView Dvq;
  private TextView Dvr;
  private View Dvs;
  private BlurView Dvt;
  private com.tencent.mm.plugin.transvoice.ui.b Dvu;
  private com.tencent.mm.plugin.transvoice.a.a Dvv;
  private com.tencent.mm.modelvoiceaddr.h Dvw;
  public o Dvx;
  private com.tencent.mm.plugin.transvoice.a.c Dvy;
  private ChatFooter.l Dvz;
  private TextWatcher DwA;
  ValueAnimator DwB;
  ValueAnimator DwC;
  ValueAnimator DwD;
  ValueAnimator DwE;
  ValueAnimator DwF;
  ValueAnimator.AnimatorUpdateListener DwG;
  private int[] DwH;
  private final int DwI;
  private final int DwJ;
  private final int DwK;
  private final int DwL;
  private final int DwM;
  private final int DwN;
  private final float DwO;
  private int DwP;
  private int DwQ;
  private int DwR;
  private int DwS;
  private int DwT;
  private int DwW;
  private boolean DwX;
  private final int DwY;
  private final int DwZ;
  private View Dwa;
  private View Dwb;
  private ViewGroup Dwc;
  private View Dwd;
  private View Dwe;
  private WeImageView Dwf;
  private WeImageView Dwg;
  private View Dwh;
  private View Dwi;
  private WeImageView Dwj;
  private ViewGroup Dwk;
  private View Dwl;
  private View Dwm;
  private View Dwn;
  private WeImageView Dwo;
  private View Dwp;
  private int Dwq;
  private int Dwr;
  private boolean Dws;
  private ChatFooterPanel.a Dwt;
  private AppPanel.b Dwu;
  private b Dwv;
  public i Dww;
  private int Dwx;
  private boolean Dwy;
  private int Dwz;
  private volatile boolean Dxa;
  private com.tencent.mm.sdk.platformtools.ao Dxb;
  private boolean Dxc;
  private int Dxd;
  private boolean Dxe;
  private int Dxg;
  private View Dxh;
  private int Dxi;
  private int Dxj;
  private int Dxk;
  private int Dxl;
  private int Dxm;
  private int Dxn;
  private Runnable Dxo;
  private Runnable Dxp;
  private int Dxq;
  private int Dxr;
  e Dxs;
  e Dxt;
  private Map<Integer, String> Dxu;
  private boolean Dxv;
  private Activity activity;
  public String dng;
  private boolean fRz;
  public Button fTu;
  public ChatFooterPanel fWT;
  private com.tencent.mm.ui.tools.h fxG;
  private View ifK;
  private ViewGroup isN;
  public final com.tencent.mm.sdk.platformtools.ao mHandler;
  private int maxHeight;
  private int ngo;
  private boolean oPF;
  private final com.tencent.mm.sdk.platformtools.ao oPS;
  public View qNf;
  private ImageView qNg;
  public View qNh;
  public View qNi;
  public String toUser;
  public boolean tzA;
  public MMEditText uyM;
  public o zWY;
  private TextView zWZ;
  private ImageView zXa;
  public View zXb;
  
  static
  {
    AppMethodBeat.i(31717);
    count = 0;
    DwU = new int[] { 0, 15, 30, 45, 60, 75, 90, 95, 100 };
    DwV = new int[] { 2131689547, 2131689548, 2131689549, 2131689550, 2131689551, 2131689552, 2131689553, 2131689554 };
    Dxf = com.tencent.mm.sdk.platformtools.ai.getPackageName() + "chat_footer_sp";
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
    this.ifK = null;
    this.uyM = null;
    this.fTu = null;
    this.DtQ = null;
    this.Duj = null;
    this.Duk = null;
    this.Dul = null;
    this.Dum = new a((byte)0);
    this.Dun = false;
    this.Duo = false;
    this.Dup = false;
    this.oPF = false;
    this.Duw = false;
    this.Dux = false;
    this.Duy = false;
    this.Dpb = false;
    this.Duz = true;
    this.DuA = false;
    this.DuB = 0;
    this.DuC = -1;
    this.DuG = 0;
    this.tzA = false;
    this.DuH = false;
    this.DuI = true;
    this.DuJ = false;
    this.DuN = false;
    this.DuO = null;
    this.DuP = new x.a()
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
    this.DuQ = new d.c()
    {
      public final int cSy()
      {
        AppMethodBeat.i(185759);
        if (ChatFooter.b(ChatFooter.this) != null)
        {
          int i = ChatFooter.b(ChatFooter.this).cSy();
          AppMethodBeat.o(185759);
          return i;
        }
        AppMethodBeat.o(185759);
        return 0;
      }
      
      public final boolean cSz()
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
    this.DuR = new com.tencent.mm.g.b.a.c();
    this.DuU = new m.a()
    {
      public final void clear()
      {
        AppMethodBeat.i(185778);
        ChatFooter.this.cSA();
        AppMethodBeat.o(185778);
      }
    };
    this.mHandler = new com.tencent.mm.sdk.platformtools.ao()
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
    this.DuV = false;
    this.fRz = false;
    paramAttributeSet = com.tencent.mm.plugin.transvoice.a.c.Akm;
    this.Dvy = com.tencent.mm.plugin.transvoice.a.c.efd();
    this.Dvz = ChatFooter.l.Dyj;
    this.DvA = j.Dyb;
    this.DvB = k.Dyf;
    this.DvC = false;
    this.DvD = false;
    this.DvE = false;
    this.DvF = 0.5F;
    this.Dws = true;
    this.Dwt = new ChatFooterPanel.a()
    {
      public final void amb()
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
        ChatFooter.this.DuR.dDd -= 1L;
        AppMethodBeat.o(185771);
      }
      
      public final void amc()
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
          ChatFooter.d(ChatFooter.this).aRF(paramAnonymousString);
          ChatFooter.this.DuR.dDd += 1L;
          AppMethodBeat.o(185772);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.ChatFooter", paramAnonymousString, "", new Object[0]);
          }
        }
      }
      
      public final void dS(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185770);
        ac.i("MicroMsg.ChatFooter", "onToSendTextEnable: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
    this.Dwu = new AppPanel.b()
    {
      public final void eOh()
      {
        AppMethodBeat.i(185773);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ChatFooter.e(ChatFooter.this), "android.permission.RECORD_AUDIO", 80, "", "");
        ac.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), ChatFooter.e(ChatFooter.this) });
        if (!bool)
        {
          AppMethodBeat.o(185773);
          return;
        }
        int i = az.agi().aBK();
        if ((i == 4) || (i == 6))
        {
          ChatFooter.au(ChatFooter.this);
          AppMethodBeat.o(185773);
          return;
        }
        if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
          ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.h.l(ChatFooter.this.getContext(), 2131764895, 2131755906));
        }
        AppMethodBeat.o(185773);
      }
    };
    this.Dwv = new b()
    {
      public final com.tencent.mm.ui.chatting.h.b ePn()
      {
        return null;
      }
      
      public final String getTalkerUserName()
      {
        AppMethodBeat.i(196140);
        if (ChatFooter.f(ChatFooter.this) == null)
        {
          str = ChatFooter.av(ChatFooter.this);
          AppMethodBeat.o(196140);
          return str;
        }
        String str = ChatFooter.f(ChatFooter.this).getTalkerUserName();
        AppMethodBeat.o(196140);
        return str;
      }
    };
    this.oPS = new com.tencent.mm.sdk.platformtools.ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(196145);
        super.handleMessage(paramAnonymousMessage);
        ac.d("MicroMsg.ChatFooter", "pennqin, dismiss window by too short.");
        ChatFooter.x(ChatFooter.this).setBackgroundResource(2131232725);
        ChatFooter.x(ChatFooter.this).setEnabled(true);
        if (ChatFooter.this.DvE)
        {
          ChatFooter.ay(ChatFooter.this);
          AppMethodBeat.o(196145);
          return;
        }
        if (ChatFooter.L(ChatFooter.this) != null) {
          ChatFooter.L(ChatFooter.this).dismiss();
        }
        AppMethodBeat.o(196145);
      }
    };
    this.Dwx = 0;
    this.Dwy = false;
    this.Dwz = 1;
    this.DwA = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(196146);
        int i;
        int j;
        int m;
        int k;
        if (paramAnonymousEditable != null)
        {
          i = ChatFooter.az(ChatFooter.this).getWidth();
          j = ChatFooter.aA(ChatFooter.this).getLineCount();
          m = j - ChatFooter.aB(ChatFooter.this);
          if ((m != 0) && (ChatFooter.this.Dxs == ChatFooter.e.DxP) && (i == ChatFooter.aC(ChatFooter.this)))
          {
            i = com.tencent.mm.ui.ao.fromDPToPix(ChatFooter.this.getContext(), 5);
            k = ChatFooter.aA(ChatFooter.this).getLineHeight() * m;
            if (m <= 0) {
              break label251;
            }
            m = ChatFooter.az(ChatFooter.this).getHeight();
            if (!ChatFooter.this.tzA) {
              break label257;
            }
            ChatFooter.c(ChatFooter.this, Math.min(Math.max(ChatFooter.aD(ChatFooter.this), i + (m + k)), ChatFooter.aE(ChatFooter.this)));
          }
        }
        for (;;)
        {
          ac.d("MicroMsg.ChatFooter", "afterTextChanged transHeight:%s, nowLineCount:%s, lastLineCount:%s", new Object[] { Integer.valueOf(ChatFooter.aG(ChatFooter.this)), Integer.valueOf(j), Integer.valueOf(ChatFooter.aB(ChatFooter.this)) });
          ChatFooter.aH(ChatFooter.this);
          ChatFooter.d(ChatFooter.this, j);
          if (1 == ChatFooter.z(ChatFooter.this).Akk) {
            ChatFooter.z(ChatFooter.this).Akj = 1;
          }
          AppMethodBeat.o(196146);
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
    this.DwB = ValueAnimator.ofInt(new int[] { 250, 960 }).setDuration(200L);
    this.DwC = ValueAnimator.ofInt(new int[] { 40, 800 }).setDuration(200L);
    this.DwD = ValueAnimator.ofInt(new int[] { 72, 0 }).setDuration(200L);
    this.DwE = ValueAnimator.ofInt(new int[] { 22, 0 }).setDuration(200L);
    this.DwF = ValueAnimator.ofInt(new int[] { 8, 0 }).setDuration(200L);
    this.DwG = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(179771);
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)ChatFooter.bb(ChatFooter.this).getLayoutParams();
        FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)ChatFooter.bc(ChatFooter.this).getLayoutParams();
        if (ChatFooter.this.DwB == paramAnonymousValueAnimator)
        {
          localLayoutParams1.width = com.tencent.mm.ui.ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          localLayoutParams2.width = com.tencent.mm.ui.ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        }
        for (;;)
        {
          ChatFooter.bb(ChatFooter.this).setLayoutParams(localLayoutParams1);
          ChatFooter.bc(ChatFooter.this).setLayoutParams(localLayoutParams2);
          AppMethodBeat.o(179771);
          return;
          if (ChatFooter.this.DwC == paramAnonymousValueAnimator)
          {
            localLayoutParams1.height = com.tencent.mm.ui.ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.height = com.tencent.mm.ui.ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.DwD == paramAnonymousValueAnimator)
          {
            localLayoutParams1.topMargin = com.tencent.mm.ui.ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.topMargin = com.tencent.mm.ui.ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.DwE == paramAnonymousValueAnimator)
          {
            localLayoutParams1.rightMargin = com.tencent.mm.ui.ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.rightMargin = com.tencent.mm.ui.ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.DwF == paramAnonymousValueAnimator)
          {
            localLayoutParams1.bottomMargin = com.tencent.mm.ui.ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.bottomMargin = com.tencent.mm.ui.ao.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        }
      }
    };
    this.DwH = new int[] { 2131689996, 2131689997, 2131689998, 2131689999, 2131690000, 2131690001, 2131690002, 2131690003, 2131690004, 2131690005 };
    this.ANIMATION_DURATION = 200L;
    this.DwI = 60;
    this.DwJ = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 114);
    this.DwK = (com.tencent.mm.ui.ap.cl(getContext()).x - com.tencent.mm.ui.ao.fromDPToPix(getContext(), 32));
    this.DwL = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 92);
    this.DwM = Math.min(com.tencent.mm.ui.ao.fromDPToPix(getContext(), 320), com.tencent.mm.ui.ap.cl(getContext()).x - com.tencent.mm.ui.ao.fromDPToPix(getContext(), 32));
    this.DwN = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 176);
    this.DwO = (com.tencent.mm.ui.ao.fromDPToPix(getContext(), 160) / 50.0F);
    this.DwP = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 114);
    this.maxHeight = 0;
    this.DwQ = 0;
    this.DwR = 0;
    this.Anl = 0;
    this.DwS = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 176);
    this.DwT = 60;
    this.DwW = 0;
    this.DwX = false;
    this.DwY = 4097;
    this.DwZ = 4098;
    this.Dxb = new com.tencent.mm.sdk.platformtools.ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(196162);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(196162);
          return;
          ChatFooter.h(ChatFooter.this, true);
          paramAnonymousMessage = ChatFooter.bm(ChatFooter.this).getLayoutParams();
          int i = ChatFooter.bm(ChatFooter.this).getBottom() - ChatFooter.bm(ChatFooter.this).getTop();
          if (ChatFooter.this.eOK())
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
            AppMethodBeat.o(196162);
            return;
          }
          paramAnonymousMessage.height = Math.max(i - 60, 1);
          ac.e("MicroMsg.ChatFooter", "mBottomPanelAnim:bottomPanel height:" + paramAnonymousMessage.height);
          ChatFooter.bm(ChatFooter.this).setLayoutParams(paramAnonymousMessage);
          ChatFooter.bn(ChatFooter.this);
        }
      }
    };
    this.Dxc = false;
    this.Dxd = 0;
    this.Dxe = false;
    this.Dxg = -1;
    this.Dxh = null;
    this.Dxi = com.tencent.mm.ui.ao.av(getContext(), 2131165229);
    this.Dxj = com.tencent.mm.ui.ao.av(getContext(), 2131165294);
    this.Dxk = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 25);
    this.Dxl = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 55);
    this.Dxm = 0;
    this.Dxn = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 50);
    this.Dxo = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196170);
        ChatFooter.this.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196169);
            if (ChatFooter.k.Dyh == ChatFooter.ai(ChatFooter.this))
            {
              ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764709));
              ChatFooter.al(ChatFooter.this);
            }
            for (;;)
            {
              ChatFooter.br(ChatFooter.this);
              AppMethodBeat.o(196169);
              return;
              ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764713));
              ChatFooter.aj(ChatFooter.this);
            }
          }
        }, 100L);
        AppMethodBeat.o(196170);
      }
    };
    this.Dxp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196171);
        ChatFooter.H(ChatFooter.this).dismiss();
        AppMethodBeat.o(196171);
      }
    };
    this.Dxq = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 16);
    this.Dxr = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 25);
    this.Dxs = e.DxN;
    this.Dxt = this.Dxs;
    this.Dxu = new HashMap();
    this.Dxv = false;
    this.Amh = new com.tencent.mm.modelvoiceaddr.b.b();
    this.Ami = new ArrayList();
    this.AlU = "";
    this.AlV = 0;
    this.AlX = false;
    this.AjO = com.tencent.mm.modelvoiceaddr.g.ieO;
    long l = System.currentTimeMillis();
    this.Dut = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.ifK = inflate(paramContext, 2131493397, this);
    this.uyM = ((MMEditText)this.ifK.findViewById(2131298072));
    this.fxG = new com.tencent.mm.ui.tools.h((Activity)paramContext);
    this.fxG.IRL = this;
    this.Dul = ((ClipboardManager)paramContext.getApplicationContext().getSystemService("clipboard"));
    if (aj.fhA()) {
      this.uyM.setImeOptions(268435456);
    }
    com.tencent.mm.ui.tools.b.c.d(this.uyM).acw(bs.getInt(com.tencent.mm.m.g.ZY().getValue("InputLimitSessionTextMsg"), 8192) * 2).a(null);
    this.uyM.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
    this.uyM.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {}
    });
    if (Build.VERSION.SDK_INT == 28) {
      this.uyM.setBreakStrategy(1);
    }
    paramAttributeSet = new qe();
    paramAttributeSet.dth.dtj = this.uyM;
    paramAttributeSet.dth.dti = new com.tencent.mm.pluginsdk.ui.a.a()
    {
      public final void aHa(final String paramAnonymousString)
      {
        AppMethodBeat.i(185818);
        ac.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", new Object[] { paramAnonymousString });
        if ((bs.isNullOrNil(ChatFooter.f(ChatFooter.this).getTalkerUserName())) || (bs.isNullOrNil(paramAnonymousString)))
        {
          ac.e("MicroMsg.ChatFooter", "onImageReceived, error args");
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
    com.tencent.mm.sdk.b.a.GpY.l(paramAttributeSet);
    this.Dub = ((LinearLayout)this.ifK.findViewById(2131305724));
    this.DtZ = this.ifK.findViewById(2131305739);
    this.DtU = ((ChatFooterBottom)findViewById(2131298067));
    this.isN = ((ViewGroup)findViewById(2131297957));
    this.DtT = findViewById(2131298090);
    this.DtW = ((ImageButton)this.ifK.findViewById(2131298054));
    this.DtX = ((ImageView)this.ifK.findViewById(2131298055));
    this.fTu = ((Button)this.ifK.findViewById(2131298168));
    this.Duc = ((RelativeLayout)this.ifK.findViewById(2131302539));
    this.Dud = ((TextView)this.ifK.findViewById(2131302537));
    this.Due = ((WeImageView)this.ifK.findViewById(2131302538));
    this.fTu.setTextSize(0, com.tencent.mm.cc.a.av(paramContext, 2131165563) * com.tencent.mm.cc.a.ib(paramContext));
    this.DtR = ((Button)this.ifK.findViewById(2131306529));
    this.DtS = ((ImageButton)findViewById(2131298149));
    nM(false);
    eOT();
    this.Duf = new i(getContext(), getRootView(), this, new i.a()
    {
      public final void aHx(String paramAnonymousString)
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
          com.tencent.mm.br.d.a(ChatFooter.i(ChatFooter.this), "gallery", ".ui.GalleryEntryUI", localIntent, 217);
          AppMethodBeat.o(185752);
          return;
        }
        com.tencent.mm.br.d.b(paramContext, "gallery", ".ui.GalleryEntryUI", localIntent, 217);
        AppMethodBeat.o(185752);
      }
    });
    this.Duf.DyI = this;
    paramAttributeSet = getContext();
    getRootView();
    this.Dug = new m(paramAttributeSet);
    this.Dug.DuU = this.DuU;
    ac.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[] { Integer.valueOf(this.uyM.getImeOptions()) });
    this.uyM.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.uyM.setOnTouchListener(new View.OnTouchListener()
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
    this.uyM.setOnLongClickListener(new ChatFooter.5(this, paramContext));
    this.uyM.setCustomSelectionActionModeCallback(new ChatFooter.6(this, paramContext));
    this.fTu.setOnClickListener(new View.OnClickListener()
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
            ac.i("MicroMsg.ChatFooter", "send msg onClick");
            if ((paramAnonymousView.trim().length() == 0) && (paramAnonymousView.length() != 0))
            {
              ac.d("MicroMsg.ChatFooter", "empty message cant be sent");
              if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
                ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.h.l(ChatFooter.this.getContext(), 2131757154, 2131755906));
              }
              ChatFooter.this.eOQ();
              AppMethodBeat.o(31499);
              return;
            }
            ChatFooter.c(ChatFooter.this, false);
            int i = ChatFooter.d(ChatFooter.this).getPasterLen();
            ac.i("MicroMsg.ChatFooter", "pasteLen %d", new Object[] { Integer.valueOf(i) });
            if ((i > 0) && (ChatFooter.o(ChatFooter.this) != null))
            {
              localObject = ChatFooter.o(ChatFooter.this).getText();
              if ((localObject != null) && (bs.nullAsNil(((CharSequence)localObject).toString()).equals(paramAnonymousView)))
              {
                ac.i("MicroMsg.ChatFooter", "paste clip board to send");
                ChatFooter.c(ChatFooter.this, true);
              }
            }
            if (ChatFooter.p(ChatFooter.this) == null) {
              break label328;
            }
            Object localObject = ChatFooter.p(ChatFooter.this);
            if (((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).tzS == null) {
              break label323;
            }
            bool1 = ((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).tzS.isShowing();
          }
          finally {}
          if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0) && (ChatFooter.l(ChatFooter.this) != null)) {
            ChatFooter.this.cSA();
          }
          ChatFooter.a(ChatFooter.this, paramAnonymousView.length());
          if (ChatFooter.a(ChatFooter.this, paramAnonymousView))
          {
            ac.i("MicroMsg.ChatFooter", "this is a quote msg");
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
                ac.i("MicroMsg.ChatFooter", "this is a group solitatire msg");
                break;
              }
              if ((ChatFooter.l(ChatFooter.this) == null) || (!ChatFooter.l(ChatFooter.this).akA(paramAnonymousView))) {
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
    if (aj.fhz()) {}
    label2279:
    for (;;)
    {
      boolean bool = false;
      label1655:
      this.DvE = bool;
      this.DvF = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbI, 0.5F);
      ac.i("MicroMsg.ChatFooter", "isNewTrans2Txt:%s, transOperationAreaFactor:%s", new Object[] { Boolean.valueOf(this.DvE), Float.valueOf(this.DvF) });
      this.Dvv = new com.tencent.mm.plugin.transvoice.a.a();
      if (this.DvE)
      {
        this.Dwr = ((int)(com.tencent.mm.cc.a.ig(paramContext) * this.DvF));
        ac.d("MicroMsg.ChatFooter", "newVoice2txtVoiceModeChangeLine: %s, newVoice2txtTransModeChangeLine: %s.", new Object[] { Integer.valueOf(this.Dwq), Integer.valueOf(this.Dwr) });
        this.DtR.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(31512);
            if (paramAnonymousView != ChatFooter.x(ChatFooter.this))
            {
              AppMethodBeat.o(31512);
              return false;
            }
            if (ChatFooter.this.Dxs == ChatFooter.e.DxN)
            {
              ChatFooter.b(ChatFooter.this, com.tencent.mm.ui.ap.cl(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(2131166976) - com.tencent.mm.ui.aq.ej(paramContext));
              switch (paramAnonymousMotionEvent.getAction())
              {
              }
            }
            for (;;)
            {
              AppMethodBeat.o(31512);
              return true;
              ChatFooter.b(ChatFooter.this, com.tencent.mm.ui.ap.cl(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(2131166976) - com.tencent.mm.ui.aq.ej(paramContext) + ChatFooter.y(ChatFooter.this));
              break;
              ChatFooter.z(ChatFooter.this).Akh = 1;
              paramAnonymousView = com.tencent.mm.ck.a.Hez;
              com.tencent.mm.ck.a.wi(false);
              ChatFooter.z(ChatFooter.this).mmC = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).AjU = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.z(ChatFooter.this).AjV = ((int)paramAnonymousMotionEvent.getRawY());
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
                ChatFooter.l(ChatFooter.this).dbG();
              }
              ChatFooter.x(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757050));
              continue;
              if ((ChatFooter.C(ChatFooter.this) == null) || (!ChatFooter.C(ChatFooter.this).isShowing()))
              {
                ac.e("MicroMsg.NewVoice2txt", "window status err!!!");
              }
              else if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getX() < ChatFooter.x(ChatFooter.this).getWidth()) && (paramAnonymousMotionEvent.getRawY() > ChatFooter.D(ChatFooter.this)))
              {
                if (ChatFooter.this.Dxs != ChatFooter.e.DxN)
                {
                  ChatFooter.this.Dxt = ChatFooter.this.Dxs;
                  ChatFooter.this.Dxs = ChatFooter.e.DxN;
                  ChatFooter.E(ChatFooter.this);
                }
              }
              else if (paramAnonymousMotionEvent.getRawX() > ChatFooter.F(ChatFooter.this))
              {
                if (ChatFooter.e.DxP != ChatFooter.this.Dxs)
                {
                  ChatFooter.this.Dxt = ChatFooter.this.Dxs;
                  ChatFooter.this.Dxs = ChatFooter.e.DxP;
                  ChatFooter.E(ChatFooter.this);
                }
              }
              else if (ChatFooter.e.DxO != ChatFooter.this.Dxs)
              {
                ChatFooter.this.Dxt = ChatFooter.this.Dxs;
                ChatFooter.this.Dxs = ChatFooter.e.DxO;
                ChatFooter.E(ChatFooter.this);
                continue;
                ac.d("MicroMsg.NewVoice2txt", "begin finishCutShortSentence.");
                ChatFooter.B(ChatFooter.this).efa();
                ac.d("MicroMsg.NewVoice2txt", "end finishCutShortSentence.");
                ChatFooter.z(ChatFooter.this).AjW = System.currentTimeMillis();
                ChatFooter.z(ChatFooter.this).AjX = ((int)paramAnonymousMotionEvent.getRawX());
                ChatFooter.z(ChatFooter.this).AjY = ((int)paramAnonymousMotionEvent.getRawY());
                if ((ChatFooter.this.AlP != null) && (ChatFooter.G(ChatFooter.this)))
                {
                  ChatFooter.this.AlP.AjP = false;
                  paramAnonymousView = ChatFooter.this.AlP;
                  ac.d("MicroMsg.SceneVoiceInputAddr2", "reTrigger!!! canReTrigger: %s.", new Object[] { Boolean.valueOf(paramAnonymousView.AjQ) });
                  if ((paramAnonymousView.AjQ) && ((!((com.tencent.mm.modelvoiceaddr.c)paramAnonymousView.ieL).aKD()) || (!com.tencent.mm.kernel.g.agi().a(paramAnonymousView.ieL, 0)))) {
                    paramAnonymousView.efc();
                  }
                }
                if ((ChatFooter.this.getContext() instanceof Activity)) {
                  ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                }
                ChatFooter.this.eOS();
              }
            }
          }
        });
        this.DwB.addUpdateListener(this.DwG);
        this.DwC.addUpdateListener(this.DwG);
        this.DwD.addUpdateListener(this.DwG);
        this.DwE.addUpdateListener(this.DwG);
        this.DwF.addUpdateListener(this.DwG);
      }
      for (;;)
      {
        this.DtS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185761);
            ChatFooter.w(ChatFooter.this);
            AppMethodBeat.o(185761);
          }
        });
        eOq();
        this.DtW.setVisibility(0);
        this.DtW.setContentDescription(getContext().getString(2131757042));
        this.DtW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = -1;
            AppMethodBeat.i(31504);
            Object localObject1 = ChatFooter.r(ChatFooter.this);
            ChatFooter localChatFooter = ChatFooter.this;
            int i = j;
            if (localChatFooter.getAppPanelUnCertainEnterArrayList() != null)
            {
              i = j;
              if (localChatFooter.getAppPanelUnCertainEnterArrayList().size() > 0)
              {
                i = 0;
                int k;
                for (j = -1; i < localChatFooter.getAppPanelUnCertainEnterArrayList().size(); j = k)
                {
                  Object localObject2 = (a.a)localChatFooter.getAppPanelUnCertainEnterArrayList().get(i);
                  k = j;
                  if (((a.a)localObject2).DtB == 1)
                  {
                    k = j;
                    if (!ChatFooter.aHw(((a.a)localObject2).DtA))
                    {
                      localObject2 = ((a.a)localObject2).DtA;
                      aw.aKT("plus_uncertain_enter").edit().putBoolean((String)localObject2, true);
                      k = j;
                      if (j == -1) {
                        k = i;
                      }
                    }
                  }
                  i += 1;
                }
                i = j;
              }
            }
            localChatFooter.DtX.setVisibility(8);
            ((ImageButton)localObject1).setTag(Integer.valueOf(i));
            ChatFooter.this.fH(paramAnonymousView);
            if ((u.aye().booleanValue()) && (ChatFooter.this.DuS != null))
            {
              paramAnonymousView = ChatFooter.this.DuS;
              localObject1 = Boolean.TRUE;
              paramAnonymousView.a((Boolean)localObject1, (Boolean)localObject1);
            }
            AppMethodBeat.o(31504);
          }
        });
        ac.i("MicroMsg.ChatFooter", "[init]");
        this.DtT.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return true;
          }
        });
        this.DuF = (((Activity)paramContext).getWindow().getAttributes().softInputMode & 0xF0);
        if ((this.DuF != 16) && (this.DuF != 48))
        {
          com.tencent.mm.plugin.report.service.h.wUl.dB(1062, 8);
          if (this.DuF != 16) {
            this.DuF = 48;
          }
        }
        this.DuL = y.iy(paramContext);
        Xo(getKeyBordHeightPX());
        if (com.tencent.mm.compatible.util.d.kZ(24)) {
          this.DuH = ((Activity)getContext()).isInMultiWindowMode();
        }
        eOp();
        this.Due.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31502);
            ChatFooter.q(ChatFooter.this);
            AppMethodBeat.o(31502);
          }
        });
        ac.d("MicroMsg.ChatFooter", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(31573);
        return;
        if (aly()) {
          break;
        }
        paramAttributeSet = ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext());
        if ((!paramAttributeSet.equals("zh_CN")) && (!paramAttributeSet.equals("zh_HK")) && (!paramAttributeSet.equals("zh_TW")) && (!paramAttributeSet.equals("en"))) {
          break;
        }
        if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
        {
          bool = true;
          break label1655;
        }
        if (1 != ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbH, 1)) {
          break label2279;
        }
        bool = true;
        break label1655;
        Dva = com.tencent.mm.cc.a.ig(paramContext) / 2 + com.tencent.mm.cc.a.fromDPToPix(paramContext, 30);
        this.Dvu = new com.tencent.mm.plugin.transvoice.ui.b(paramContext);
        this.Dvu.Amk = new b.d()
        {
          public final void ayb(final String paramAnonymousString)
          {
            AppMethodBeat.i(185764);
            ChatFooter.this.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(185762);
                ac.i("MicroMsg.ChatFooter", "onTxtMsgSend, msg is null or nil? %s.", new Object[] { Boolean.valueOf(bs.isNullOrNil(paramAnonymousString)) });
                if ((ChatFooter.l(ChatFooter.this) != null) && (!bs.isNullOrNil(paramAnonymousString))) {
                  ChatFooter.l(ChatFooter.this).akA(paramAnonymousString);
                }
                AppMethodBeat.o(185762);
              }
            }, 200L);
            AppMethodBeat.o(185764);
          }
          
          public final void ayc(String paramAnonymousString)
          {
            AppMethodBeat.i(185766);
            if (ChatFooter.l(ChatFooter.this) != null) {
              ChatFooter.l(ChatFooter.this).akB(paramAnonymousString);
            }
            AppMethodBeat.o(185766);
          }
          
          public final boolean b(String paramAnonymousString, Long paramAnonymousLong)
          {
            AppMethodBeat.i(185765);
            ac.i("MicroMsg.ChatFooter", "onVoiceMsgSend, fileName: %s.", new Object[] { paramAnonymousString });
            if (paramAnonymousLong != null) {}
            for (int i = paramAnonymousLong.intValue();; i = 0)
            {
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                boolean bool = ChatFooter.l(ChatFooter.this).dI(paramAnonymousString, i);
                AppMethodBeat.o(185765);
                return bool;
              }
              AppMethodBeat.o(185765);
              return false;
            }
          }
          
          public final void efr()
          {
            AppMethodBeat.i(185763);
            if (ChatFooter.H(ChatFooter.this).isShowing()) {
              ChatFooter.H(ChatFooter.this).dismiss();
            }
            ChatFooter.I(ChatFooter.this);
            AppMethodBeat.o(185763);
          }
        };
        this.DtR.setOnTouchListener(new View.OnTouchListener()
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
              ac.i("MicroMsg.RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[] { Integer.valueOf(ChatFooter.cXX()) });
              paramAnonymousView = com.tencent.mm.ck.a.Hez;
              com.tencent.mm.ck.a.wi(false);
              ChatFooter.z(ChatFooter.this).mmC = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).AjU = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.z(ChatFooter.this).AjV = ((int)paramAnonymousMotionEvent.getRawY());
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
              ac.i("MicroMsg.RcdBtnEvent", "trans voice opener: %s, blur mode opener: %s.", new Object[] { Boolean.valueOf(ChatFooter.P(ChatFooter.this)), ChatFooter.Q(ChatFooter.this) });
              if (ChatFooter.P(ChatFooter.this)) {}
              for (ChatFooter.z(ChatFooter.this).Akh = 1;; ChatFooter.z(ChatFooter.this).Akh = 0)
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
                  ChatFooter.l(ChatFooter.this).dbG();
                }
                ChatFooter.x(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757050));
                break;
              }
              if ((ChatFooter.L(ChatFooter.this) == null) || (!ChatFooter.L(ChatFooter.this).isShowing()))
              {
                if (ChatFooter.L(ChatFooter.this) == null) {}
                for (boolean bool = true;; bool = false)
                {
                  ac.e("MicroMsg.RcdBtnEvent", "hint window status err, window is null: %s.", new Object[] { Boolean.valueOf(bool) });
                  break;
                }
              }
              if (ChatFooter.P(ChatFooter.this))
              {
                if ((ChatFooter.T(ChatFooter.this) == null) || (ChatFooter.U(ChatFooter.this) == null)) {
                  ac.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! voice2txtRealHintArea is %s, voice2txtOpeLayout is %s.", new Object[] { ChatFooter.T(ChatFooter.this), ChatFooter.U(ChatFooter.this) });
                }
                if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getY() > -ChatFooter.V(ChatFooter.this) / 3) && (paramAnonymousMotionEvent.getX() < ChatFooter.x(ChatFooter.this).getWidth()))
                {
                  if (ChatFooter.W(ChatFooter.this) != ChatFooter.l.Dyk)
                  {
                    ac.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_1.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.Dyk);
                    if (ChatFooter.X(ChatFooter.this))
                    {
                      ChatFooter.Y(ChatFooter.this).animate().cancel();
                      ChatFooter.Z(ChatFooter.this).animate().cancel();
                      if (ChatFooter.j.Dyc == ChatFooter.Q(ChatFooter.this))
                      {
                        ChatFooter.N(ChatFooter.this).setAlpha(0.5F);
                        ChatFooter.N(ChatFooter.this).animate().alpha(1.0F).setDuration(300L).start();
                        ChatFooter.N(ChatFooter.this).aau(ChatFooter.this.getResources().getColor(2131101069)).F(ChatFooter.e(ChatFooter.this).getWindow().getDecorView().getBackground()).xc(true);
                      }
                      for (;;)
                      {
                        ChatFooter.H(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(200L).start();
                        ChatFooter.aa(ChatFooter.this).setVisibility(0);
                        ChatFooter.ab(ChatFooter.this).setVisibility(8);
                        ChatFooter.U(ChatFooter.this).setVisibility(8);
                        ChatFooter.a(ChatFooter.this, ChatFooter.k.Dyf);
                        ChatFooter.ac(ChatFooter.this);
                        break;
                        ChatFooter.T(ChatFooter.this).setBackgroundResource(2131234483);
                      }
                    }
                  }
                }
                else
                {
                  if (ChatFooter.W(ChatFooter.this) != ChatFooter.l.Dyl)
                  {
                    ac.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_2.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.Dyl);
                    if (!ChatFooter.X(ChatFooter.this)) {
                      ChatFooter.ad(ChatFooter.this);
                    }
                    ac.i("MicroMsg.RcdBtnEvent", "init rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.ePl()) });
                    if (paramAnonymousMotionEvent.getRawX() > ChatFooter.ePl())
                    {
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Dyg);
                      ac.i("MicroMsg.RcdBtnEvent", "init MODE_TRANS");
                      label1030:
                      if (ChatFooter.j.Dyc != ChatFooter.Q(ChatFooter.this)) {
                        break label1308;
                      }
                      ChatFooter.N(ChatFooter.this).aau(0).F(null).xc(false);
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
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Dyh);
                      ac.i("MicroMsg.RcdBtnEvent", "init MODE_CANCEL");
                      break label1030;
                      label1308:
                      ChatFooter.T(ChatFooter.this).setBackgroundColor(0);
                    }
                  }
                  if (ChatFooter.ah(ChatFooter.this))
                  {
                    ac.i("MicroMsg.RcdBtnEvent", "active rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.ePl()) });
                    if ((paramAnonymousMotionEvent.getRawX() > ChatFooter.ePl()) && (ChatFooter.k.Dyg != ChatFooter.ai(ChatFooter.this)))
                    {
                      ac.i("MicroMsg.RcdBtnEvent", "active MODE_TRANS.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Dyg);
                      ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764713));
                      ChatFooter.aj(ChatFooter.this);
                      ChatFooter.ak(ChatFooter.this);
                    }
                    else if ((paramAnonymousMotionEvent.getRawX() <= ChatFooter.ePl()) && (ChatFooter.k.Dyh != ChatFooter.ai(ChatFooter.this)))
                    {
                      ac.i("MicroMsg.RcdBtnEvent", "active MODE_CANCEL.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Dyh);
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
                  ac.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", new Object[] { ChatFooter.an(ChatFooter.this), ChatFooter.ao(ChatFooter.this) });
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
                    ChatFooter.x(ChatFooter.this).setTextSize(0, com.tencent.mm.cc.a.av(ChatFooter.this.getContext(), 2131165517) * com.tencent.mm.cc.a.ib(ChatFooter.this.getContext()));
                    ChatFooter.x(ChatFooter.this).setText(2131757078);
                    ChatFooter.ao(ChatFooter.this).setVisibility(0);
                    continue;
                    ChatFooter.B(ChatFooter.this).efa();
                    if ((ChatFooter.this.getContext() instanceof Activity)) {
                      ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                    }
                    ChatFooter.z(ChatFooter.this).AjW = System.currentTimeMillis();
                    ChatFooter.z(ChatFooter.this).AjX = ((int)paramAnonymousMotionEvent.getRawX());
                    ChatFooter.z(ChatFooter.this).AjY = ((int)paramAnonymousMotionEvent.getRawY());
                    ac.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.cXX()) });
                    ChatFooter.this.eOS();
                    ac.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.ePm()) });
                  }
                }
              }
            }
          }
        });
        this.DtR.setOnKeyListener(new View.OnKeyListener()
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
                  ChatFooter.l(ChatFooter.this).dbG();
                }
                ChatFooter.x(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757050));
                continue;
                if ((paramAnonymousInt == 23) || (paramAnonymousInt == 66))
                {
                  ChatFooter.x(ChatFooter.this).setBackgroundResource(2131232725);
                  ChatFooter.x(ChatFooter.this).setText(2131757093);
                  if (ChatFooter.l(ChatFooter.this) != null) {
                    ChatFooter.l(ChatFooter.this).dbB();
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
  
  private void Xi(int paramInt)
  {
    AppMethodBeat.i(31593);
    if (this.DtS == null)
    {
      AppMethodBeat.o(31593);
      return;
    }
    if (paramInt == 2131231707) {}
    for (int i = 1;; i = 0)
    {
      if (this.DtS != null)
      {
        if (i == 0) {
          break label83;
        }
        this.DtS.setContentDescription(getContext().getString(2131757049));
      }
      for (;;)
      {
        this.DtS.setImageResource(paramInt);
        this.DtS.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(31593);
        return;
        label83:
        this.DtS.setContentDescription(getContext().getString(2131757048));
      }
    }
  }
  
  private void Xn(int paramInt)
  {
    AppMethodBeat.i(31666);
    if (paramInt == this.DuB)
    {
      AppMethodBeat.o(31666);
      return;
    }
    if (this.fTu.getVisibility() == 8) {
      eOQ();
    }
    if (((paramInt == 0) && (this.DtZ.getVisibility() == 8)) || (paramInt == 3) || ((paramInt == 0) && (this.DtZ.getVisibility() == 8))) {
      eOQ();
    }
    AppMethodBeat.o(31666);
  }
  
  private void Xo(int paramInt)
  {
    AppMethodBeat.i(31680);
    ac.i("MicroMsg.ChatFooter", "[refreshBottomHeight] keyborPx:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.compatible.util.i.eUC();
    int i;
    if ((com.tencent.mm.storage.ai.aNc(this.DtO)) || (com.tencent.mm.storage.ai.aNd(this.DtO)))
    {
      paramInt = com.tencent.mm.compatible.util.i.j(getContext(), paramInt, 43);
      i = com.tencent.mm.api.aa.bi(getContext());
      if ((!this.Duz) || (this.DuH)) {
        break label353;
      }
    }
    label353:
    for (this.DuL = paramInt;; this.DuL = y.iy(getContext()))
    {
      paramInt = Math.max(i, this.DuL);
      this.DuM = paramInt;
      if (paramInt != this.DuK) {
        this.DuK = paramInt;
      }
      ac.i("MicroMsg.ChatFooter", "refreshBottomHeight: %s, %s, %s, %s", new Object[] { Boolean.valueOf(this.Duz), Boolean.valueOf(this.DuH), Integer.valueOf(this.DuL), Integer.valueOf(this.DuK) });
      Object localObject = this.DtU.getLayoutParams();
      if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != this.DuK))
      {
        ((ViewGroup.LayoutParams)localObject).height = this.DuK;
        this.DtU.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.DtU.requestLayout();
      }
      if (this.DuE)
      {
        paramInt = -this.DuK;
        localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
        if ((localObject != null) && (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != paramInt))
        {
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
          setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.DtP != null)
      {
        this.DtP.setPortHeighPx(this.DuL);
        this.DtP.eOd();
      }
      if (this.DoY != null)
      {
        paramInt = this.DuL + this.DtT.getHeight();
        localObject = this.DoY.getLayoutParams();
        if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != paramInt))
        {
          ((ViewGroup.LayoutParams)localObject).height = paramInt;
          this.DoY.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(31680);
      return;
      paramInt = com.tencent.mm.compatible.util.i.aE(getContext(), paramInt);
      break;
    }
  }
  
  private void a(boolean paramBoolean, final Runnable paramRunnable)
  {
    AppMethodBeat.i(31658);
    if (paramBoolean)
    {
      if (this.fWT == null) {
        eOp();
      }
      this.fWT.animate().cancel();
      if ((this.fWT.getVisibility() == 0) && (this.fWT.getAlpha() == 1.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(31658);
        }
      }
      else
      {
        this.fWT.setVisibility(0);
        this.fWT.setAlpha(0.0F);
        this.fWT.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
        AppMethodBeat.o(31658);
      }
    }
    else if ((this.fWT == null) || (this.fWT.getVisibility() == 4) || (this.fWT.getAlpha() == 0.0F))
    {
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(31658);
      }
    }
    else
    {
      this.fWT.animate().cancel();
      this.fWT.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
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
      if (this.DtP == null) {
        eOq();
      }
      this.DtP.animate().cancel();
      if ((this.DtP.getVisibility() == 0) && (this.DtP.getAlpha() == 1.0F))
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
        this.DtP.setAlpha(0.0F);
        this.DtP.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).setListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(196157);
            ChatFooter.bj(ChatFooter.this);
            ChatFooter.bk(ChatFooter.this).animate().setListener(null);
            AppMethodBeat.o(196157);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        }).start();
        this.DtP.setUncertainEnterLocation(paramInt);
        AppMethodBeat.o(163216);
      }
    }
    else
    {
      this.DtP.animate().cancel();
      if ((this.DtP.getVisibility() == 4) || (this.DtP.getAlpha() == 0.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(163216);
        }
      }
      else {
        this.DtP.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
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
  
  private void aF(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31599);
    if (paramBoolean1)
    {
      if ((this.Duc.getTag() != null) && ((this.Duc.getTag() instanceof bo)))
      {
        this.Duc.setVisibility(0);
        bo localbo = (bo)this.Duc.getTag();
        this.Dud.setText(com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), com.tencent.mm.plugin.msgquote.model.a.a(getContext(), this.Dud.getTextSize(), localbo)));
        AppMethodBeat.o(31599);
        return;
      }
      this.Duc.setVisibility(8);
      AppMethodBeat.o(31599);
      return;
    }
    if (paramBoolean2)
    {
      this.Duc.setTag(null);
      this.Dud.setText("");
    }
    this.Duc.setVisibility(8);
    AppMethodBeat.o(31599);
  }
  
  private void aG(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185825);
    if (1 == paramInt3) {}
    for (boolean bool = true; ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3)) && (paramInt2 == 0); bool = false)
    {
      if (this.DuO == null) {
        break label101;
      }
      this.DuO.xi(bool);
      AppMethodBeat.o(185825);
      return;
    }
    if ((paramInt1 == 0) && ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3)) && (this.DuO != null)) {
      this.DuO.xj(bool);
    }
    label101:
    AppMethodBeat.o(185825);
  }
  
  static boolean aHw(String paramString)
  {
    AppMethodBeat.i(163219);
    boolean bool = aw.aKT("plus_uncertain_enter").getBoolean(paramString, false);
    AppMethodBeat.o(163219);
    return bool;
  }
  
  private static boolean aly()
  {
    AppMethodBeat.i(185402);
    if (com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getConfiguration().orientation == 2)
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
    eON();
    if (this.DuD != null)
    {
      if ((this.DuJ) && (this.DuB == 1))
      {
        this.DuD.c(0, false, paramInt2, paramInt3);
        AppMethodBeat.o(185824);
        return;
      }
      this.DuD.c(paramInt1, paramBoolean, paramInt2, paramInt3);
      AppMethodBeat.o(185824);
      return;
    }
    if ((this.DuB == 0) || (this.DuB == 1)) {
      this.DtU.setVisibility(8);
    }
    ac.e("MicroMsg.ChatFooter", "scrollParent: scrollParent is not ChattingScrollLayout");
    AppMethodBeat.o(185824);
  }
  
  private boolean cSw()
  {
    AppMethodBeat.i(31608);
    if (this.Duh != null)
    {
      boolean bool = this.Duh.cSw();
      AppMethodBeat.o(31608);
      return bool;
    }
    AppMethodBeat.o(31608);
    return false;
  }
  
  private boolean cx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(179783);
    if (eOR())
    {
      AppMethodBeat.o(179783);
      return false;
    }
    if ((this.DuX == null) || (bs.isNullOrNil(this.DuX.getTalkerUserName())))
    {
      ac.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg username == null");
      AppMethodBeat.o(179783);
      return false;
    }
    try
    {
      String str = this.DuX.getTalkerUserName();
      if ((((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).ahZ(str)) && (paramBoolean))
      {
        this.Duh.cSx();
        try
        {
          localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).Xw(paramString);
          paramString = (String)localObject;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject;
            ac.e("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          }
          com.tencent.mm.plugin.groupsolitaire.b.b.b(locala1);
          locala2 = com.tencent.mm.plugin.groupsolitaire.b.b.a(localException, this.Duh.tAd, locala1);
          if (!locala2.tyT) {
            break label296;
          }
          com.tencent.mm.plugin.groupsolitaire.b.b.c(locala2);
          label296:
          locala2.field_lastActiveTime = ce.azK();
          if (locala1 == null) {
            break label391;
          }
        }
        localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().ha(paramString, str);
        if ((((Integer)((Pair)localObject).first).intValue() > 0) && (((Pair)localObject).second != null))
        {
          localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second;
          com.tencent.mm.plugin.groupsolitaire.b.b.a(str, u.axw(), (com.tencent.mm.plugin.groupsolitaire.c.a)localObject);
          com.tencent.mm.plugin.groupsolitaire.c.a locala1 = com.tencent.mm.plugin.groupsolitaire.b.b.a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(str, ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_key, true), u.axw(), 1);
          if (locala1 == null)
          {
            ac.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg storageGroupSolitatire == null");
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
            if (this.Dui != null) {
              this.Dui.aim(paramString);
            }
            this.Duh.reset();
            eOm();
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
      ac.e("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg() Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      AppMethodBeat.o(179783);
    }
    return false;
  }
  
  private void eOH()
  {
    AppMethodBeat.i(31640);
    this.ifK.findViewById(2131298170).setVisibility(0);
    AppMethodBeat.o(31640);
  }
  
  private void eOI()
  {
    AppMethodBeat.i(31641);
    ac.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
    this.Dux = false;
    this.uyM.setImeOptions(0);
    this.uyM.setInputType(this.uyM.getInputType() | 0x40);
    AppMethodBeat.o(31641);
  }
  
  private void eON()
  {
    AppMethodBeat.i(31660);
    if (this.DuD == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ChattingScrollLayout))
      {
        this.DuD = ((ChattingScrollLayout)localViewParent);
        this.DuE = true;
      }
    }
    AppMethodBeat.o(31660);
  }
  
  private void eOO()
  {
    AppMethodBeat.i(31668);
    if (!this.DuA)
    {
      ac.i("MicroMsg.ChatFooter", "updateKeyboardProvider: not resumed %s", new Object[] { bs.eWi() });
      AppMethodBeat.o(31668);
      return;
    }
    if ((this.DuH) || (!this.Duz))
    {
      this.fxG.close();
      ((Activity)getContext()).getWindow().setSoftInputMode(18);
      AppMethodBeat.o(31668);
      return;
    }
    ((Activity)getContext()).getWindow().setSoftInputMode(this.DuF | 0x2);
    this.fxG.start();
    AppMethodBeat.o(31668);
  }
  
  private void eOW()
  {
    AppMethodBeat.i(31687);
    this.Dvm.setVisibility(8);
    this.Dvp.setVisibility(8);
    this.Dvm.setScaleX(0.5F);
    this.Dvm.setScaleY(0.5F);
    this.Dvp.setScaleX(0.5F);
    this.Dvp.setScaleY(0.5F);
    this.Dvm.setTranslationX(this.Dxk);
    this.Dvm.setTranslationY(-this.Dxl);
    this.Dvp.setTranslationX(-this.Dxk);
    this.Dvp.setTranslationY(-this.Dxl);
    eOX();
    eOY();
    AppMethodBeat.o(31687);
  }
  
  private void eOX()
  {
    AppMethodBeat.i(31688);
    this.Dvn.setIconColor(getResources().getColor(2131100020));
    this.Dvo.setTextColor(getResources().getColor(2131101072));
    this.Dvm.setBackgroundDrawable(getResources().getDrawable(2131234484));
    AppMethodBeat.o(31688);
  }
  
  private void eOY()
  {
    AppMethodBeat.i(31689);
    this.Dvq.setIconColor(getResources().getColor(2131100020));
    this.Dvr.setTextColor(getResources().getColor(2131101072));
    this.Dvp.setBackgroundDrawable(getResources().getDrawable(2131234484));
    AppMethodBeat.o(31689);
  }
  
  private void eOZ()
  {
    AppMethodBeat.i(31690);
    String str = ab.iC(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
    {
      this.Dvk.setImageResource(2131691370);
      this.Dvq.setImageResource(2131691372);
      AppMethodBeat.o(31690);
      return;
    }
    if (str.equals("en"))
    {
      this.Dvk.setImageResource(2131691371);
      this.Dvq.setImageResource(2131691373);
    }
    AppMethodBeat.o(31690);
  }
  
  private void eOq()
  {
    AppMethodBeat.i(31594);
    String str;
    if (this.DuX == null)
    {
      str = this.DtO;
      this.DtP = ((AppPanel)findViewById(2131297977));
      this.DtP.setOnSwitchPanelListener(this.Dwu);
      this.DtP.setChattingContext(this.Dwv);
      this.DtP.setPortHeighPx(y.iy(getContext()));
      if ((!w.xr(str)) && (!w.xj(str))) {
        break label124;
      }
      this.DtP.init(0);
    }
    for (;;)
    {
      this.DtV = ((TextView)findViewById(2131297978));
      AppMethodBeat.o(31594);
      return;
      str = this.DuX.getTalkerUserName();
      break;
      label124:
      if (w.wH(str)) {
        this.DtP.init(4);
      } else if (w.sQ(str)) {
        this.DtP.init(2);
      } else {
        this.DtP.init(1);
      }
    }
  }
  
  private void eOs()
  {
    AppMethodBeat.i(185399);
    this.DwB.start();
    this.DwC.start();
    this.DwD.start();
    this.DwE.start();
    this.DwF.start();
    this.Dwl.animate().alpha(1.0F).setDuration(200L).start();
    this.Dwm.animate().alpha(1.0F).setDuration(200L).start();
    this.DvV.animate().alpha(1.0F).translationY(0.0F).setDuration(300L).start();
    ePc();
    AppMethodBeat.o(185399);
  }
  
  private void eOt()
  {
    AppMethodBeat.i(31617);
    if (this.Duv)
    {
      this.qNh.setVisibility(8);
      this.qNi.setVisibility(8);
      this.zXb.setVisibility(8);
      this.qNf.setVisibility(8);
      this.Dvb.setVisibility(0);
      this.Dve.setVisibility(0);
      this.Dvf.setVisibility(0);
      this.Dvh.setVisibility(8);
      this.Dvi.setVisibility(0);
      this.Dvj.setVisibility(8);
      this.Dvl.setVisibility(8);
      this.Dvm.setVisibility(8);
      this.Dvp.setVisibility(8);
      this.DvB = k.Dyf;
      this.Dvz = ChatFooter.l.Dyj;
      AppMethodBeat.o(31617);
      return;
    }
    this.qNh.setVisibility(0);
    this.qNi.setVisibility(8);
    this.zXb.setVisibility(8);
    this.qNf.setVisibility(8);
    this.Dvb.setVisibility(8);
    AppMethodBeat.o(31617);
  }
  
  private void ePa()
  {
    AppMethodBeat.i(185403);
    int k = this.DvJ.getWidth();
    int m = this.DvJ.getHeight();
    int j = 0;
    int i = 0;
    switch (77.DxF[this.Dxs.ordinal()])
    {
    }
    for (;;)
    {
      ac.i("MicroMsg.ChatFooter", "beginWidth:%s, endWidth:%s, beginHeight:%s, endHeight:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i) });
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
          AppMethodBeat.i(196172);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).height = i;
          ChatFooter.az(ChatFooter.this).requestLayout();
          AppMethodBeat.o(196172);
        }
      });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
      localAnimatorSet.start();
      AppMethodBeat.o(185403);
      return;
      j = this.DwS;
      i = this.Anl;
      continue;
      j = this.DwK;
      i = this.DwP;
      continue;
      j = this.DwL;
      i = this.Anl;
    }
  }
  
  private void ePb()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(185404);
    float f3 = this.DvJ.getTranslationX();
    float f1 = f2;
    switch (77.DxF[this.Dxs.ordinal()])
    {
    }
    for (f1 = f2;; f1 = -(com.tencent.mm.ui.ap.cl(getContext()).x / 2 - com.tencent.mm.ui.ao.fromDPToPix(getContext(), 76)))
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f3, f1 }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(196173);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ChatFooter.az(ChatFooter.this).setTranslationX(f);
          AppMethodBeat.o(196173);
        }
      });
      localValueAnimator.start();
      AppMethodBeat.o(185404);
      return;
    }
  }
  
  private void ePc()
  {
    AppMethodBeat.i(185405);
    this.DvJ.setAlpha(0.0F);
    this.DvJ.setTranslationY(com.tencent.mm.ui.ao.fromDPToPix(getContext(), 56));
    this.DvM.setAlpha(0);
    this.DvM.setTranslationY(com.tencent.mm.ui.ao.fromDPToPix(getContext(), 56));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.DvJ, "translationY", new float[] { this.DvJ.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.DvJ, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.DvM, "translationY", new float[] { this.DvM.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofInt(this.DvM, "alpha", new int[] { 0, 255 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    localAnimatorSet.start();
    AppMethodBeat.o(185405);
  }
  
  private void ePd()
  {
    AppMethodBeat.i(185406);
    this.DvL.setVisibility(8);
    this.DvO.setVisibility(0);
    this.DvO.setTextColor(getContext().getResources().getColor(2131100017));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.DvS.getLayoutParams();
    localLayoutParams.addRule(13);
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    this.DvO.setText(String.format(getContext().getResources().getString(2131761571), new Object[] { Integer.valueOf(this.DwT) }));
    this.DvS.requestLayout();
    AppMethodBeat.o(185406);
  }
  
  private void ePe()
  {
    AppMethodBeat.i(185407);
    this.DvL.setVisibility(8);
    this.DvO.setVisibility(0);
    this.DvO.setTextColor(getContext().getResources().getColor(2131100482));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.DvS.getLayoutParams();
    localLayoutParams.removeRule(13);
    localLayoutParams.addRule(21);
    localLayoutParams.addRule(12);
    this.DvO.setText(String.format(getContext().getResources().getString(2131761571), new Object[] { Integer.valueOf(this.DwT) }));
    this.DvS.requestLayout();
    AppMethodBeat.o(185407);
  }
  
  private void ePf()
  {
    AppMethodBeat.i(185408);
    this.DvL.setVisibility(0);
    this.DvO.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.DvS.getLayoutParams();
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    localLayoutParams.addRule(13);
    this.DvS.requestLayout();
    ((RelativeLayout.LayoutParams)this.DvL.getLayoutParams()).bottomMargin = 0;
    this.DvL.requestLayout();
    AppMethodBeat.o(185408);
  }
  
  private void ePg()
  {
    AppMethodBeat.i(185409);
    this.Dwl.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).withEndAction(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185811);
        ChatFooter.bs(ChatFooter.this).setVisibility(8);
        ChatFooter.bt(ChatFooter.this).v(ChatFooter.this.getResources().getColor(2131100017), 0.5F);
        AppMethodBeat.o(185811);
      }
    }).start();
    this.Dwm.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).start();
    this.Dwn.animate().translationY(0.0F).setDuration(100L).start();
    if (this.DwT < 10) {
      ePd();
    }
    for (;;)
    {
      this.DvT.setVisibility(0);
      this.DvR.setVisibility(8);
      this.DvK.setVisibility(8);
      this.DvM.setImageDrawable(am.k(getContext(), 2131690496, getContext().getResources().getColor(2131099759)));
      this.DvM.animate().translationX(0.0F).setDuration(150L).start();
      this.DvJ.setActivated(true);
      ePa();
      ePb();
      AppMethodBeat.o(185409);
      return;
      ePf();
      this.DvL.a(SoundWaveView.d.AlA);
    }
  }
  
  private void ePh()
  {
    AppMethodBeat.i(185410);
    this.Dwa.setVisibility(4);
    this.DvY.v(getResources().getColor(2131099828), 0.5F);
    this.DvW.setBackgroundDrawable(getResources().getDrawable(2131233437));
    this.DvW.animate().scaleX(1.0F).scaleY(1.0F).setDuration(150L).start();
    AppMethodBeat.o(185410);
  }
  
  private void ePi()
  {
    AppMethodBeat.i(185411);
    this.Dwb.setVisibility(4);
    this.DvZ.v(getResources().getColor(2131099828), 0.5F);
    this.DvX.setBackgroundDrawable(getResources().getDrawable(2131233437));
    this.DvX.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    AppMethodBeat.o(185411);
  }
  
  private void ePj()
  {
    AppMethodBeat.i(185412);
    int j = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 20);
    if ((this.DvK.getText() != null) && (this.DvK.getText().length() > 0)) {}
    for (int i = this.DvK.getText().length();; i = 0)
    {
      this.DvK.setSelection(i);
      this.DvK.setPadding(j, j, j, j);
      this.DvV.setVisibility(8);
      this.DvT.setVisibility(8);
      this.Dwk.setVisibility(4);
      this.Dwc.setVisibility(0);
      this.DvP.setVisibility(0);
      com.tencent.mm.ck.a.a locala = com.tencent.mm.ck.a.Hez;
      com.tencent.mm.ck.a.fex();
      this.DvO.setVisibility(8);
      this.DvL.setVisibility(8);
      AppMethodBeat.o(185412);
      return;
    }
  }
  
  private int getDefaultLangType()
  {
    AppMethodBeat.i(185418);
    int i = com.tencent.mm.modelvoiceaddr.g.ieN;
    String str = ab.iC(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW"))) {
      i = com.tencent.mm.modelvoiceaddr.g.ieO;
    }
    for (;;)
    {
      AppMethodBeat.o(185418);
      return i;
      if (str.equals("en")) {
        i = com.tencent.mm.modelvoiceaddr.g.ieQ;
      }
    }
  }
  
  private int getTransLangTypeByTalker()
  {
    AppMethodBeat.i(185417);
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voice2txt_sp", 0);
    int j = localSharedPreferences.getInt(this.DtO, com.tencent.mm.modelvoiceaddr.g.ieN);
    if (this.DvQ != null)
    {
      Iterator localIterator = this.DvQ.Aky.fzd.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((com.tencent.mm.plugin.transvoice.ui.a.a.a)localIterator.next()).AmD != j);
      for (i = 1; i == 0; i = 0)
      {
        i = getDefaultLangType();
        if (com.tencent.mm.modelvoiceaddr.g.ieN != i) {
          localSharedPreferences.edit().putInt(this.DtO, i).apply();
        }
        AppMethodBeat.o(185417);
        return i;
      }
      AppMethodBeat.o(185417);
      return j;
    }
    int i = getDefaultLangType();
    if (com.tencent.mm.modelvoiceaddr.g.ieN != i) {
      localSharedPreferences.edit().putInt(this.DtO, i).apply();
    }
    AppMethodBeat.o(185417);
    return i;
  }
  
  private void h(int paramInt1, boolean paramBoolean, final int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(163218);
    ac.i("MicroMsg.ChatFooter", "switchPanel: %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    if (this.DuN)
    {
      AppMethodBeat.o(163218);
      return;
    }
    if ((paramInt1 != 0) && (u.aye().booleanValue()) && (this.DuS != null))
    {
      this.DuS.a(Boolean.TRUE, Boolean.FALSE);
      this.DuS.b(Boolean.TRUE, Boolean.FALSE);
    }
    Xn(paramInt1);
    switch (paramInt1)
    {
    default: 
      if (((this.DuB != 0) || (paramInt1 != 1)) && ((this.DuB != 1) || (paramInt1 != 0))) {
        break;
      }
    }
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      aG(this.DuB, paramInt1, paramInt2);
      this.DuB = paramInt1;
      com.tencent.mm.emoji.b.a locala;
      label198:
      int j;
      if (this.DuB == 2)
      {
        vs(true);
        locala = com.tencent.mm.emoji.b.a.fUV;
        com.tencent.mm.emoji.b.a.adq();
        j = this.DuG;
        if (this.DuO != null) {
          break label436;
        }
      }
      label436:
      for (paramInt1 = i;; paramInt1 = this.DuO.cSy())
      {
        b(j, paramBoolean, paramInt2, paramInt1);
        if (this.Duk != null) {
          this.Duk.jc(this.DuB, this.DuG);
        }
        AppMethodBeat.o(163218);
        return;
        if ((!this.Duz) || (this.DuH)) {}
        for (this.DuG = 0;; this.DuG = this.ngo)
        {
          a(false, null);
          a(false, null, -1);
          break;
        }
        this.DuG = this.DuM;
        this.DtU.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196158);
            ChatFooter.bl(ChatFooter.this);
            AppMethodBeat.o(196158);
          }
        }, -1);
        break;
        this.DuG = this.DuL;
        this.DtU.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185367);
            ChatFooter.f(ChatFooter.this, paramInt2);
            AppMethodBeat.o(185367);
          }
        });
        this.Duf.ePt();
        vp(false);
        if (this.Duu != 2) {
          break;
        }
        Xl(1);
        break;
        this.DuG = 0;
        a(false, null);
        a(false, null, -1);
        eNf();
        eOP();
        break;
        vs(false);
        locala = com.tencent.mm.emoji.b.a.fUV;
        com.tencent.mm.emoji.b.a.adr();
        break label198;
      }
    }
  }
  
  private void nM(boolean paramBoolean)
  {
    AppMethodBeat.i(31584);
    this.fRz = paramBoolean;
    if (this.DuY == null)
    {
      this.DuY = AnimationUtils.loadAnimation(getContext(), 2130772095);
      this.DuY.setDuration(150L);
    }
    if (this.DuZ == null)
    {
      this.DuZ = AnimationUtils.loadAnimation(getContext(), 2130772100);
      this.DuZ.setDuration(150L);
    }
    if ((this.fTu == null) || (this.DtW == null))
    {
      ac.i("MicroMsg.ChatFooter", "canSend:%B, return sendBtn == null || mAttachButton == null", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31584);
      return;
    }
    if (this.DuV)
    {
      if (this.DtW.getVisibility() != 0) {
        this.DtW.setVisibility(0);
      }
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.fTu.getVisibility() == 0) && (paramBoolean))
    {
      ac.i("MicroMsg.ChatFooter", "canSend true ! sendBtn is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.DtW.getVisibility() == 0) && (!paramBoolean))
    {
      ac.i("MicroMsg.ChatFooter", "canSend false ! AttachButton is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if (paramBoolean)
    {
      eOV();
      this.DtW.startAnimation(this.DuZ);
      this.DtW.setVisibility(8);
      vt(false);
    }
    for (;;)
    {
      ac.i("MicroMsg.ChatFooter", "jacks canSend:%B", new Object[] { Boolean.valueOf(paramBoolean) });
      this.fTu.getParent().requestLayout();
      AppMethodBeat.o(31584);
      return;
      this.DtW.startAnimation(this.DuY);
      if (!this.Duo)
      {
        this.DtW.setVisibility(0);
        vt(true);
      }
      eOU();
    }
  }
  
  private void setNewVoice2TxtCountDown(int paramInt)
  {
    AppMethodBeat.i(185400);
    if ((paramInt > 60) || (paramInt < 0))
    {
      ac.w("MicroMsg.ChatFooter", "skip by invalid quantity:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(185400);
      return;
    }
    switch (77.DxF[this.Dxs.ordinal()])
    {
    }
    for (;;)
    {
      this.DwT = paramInt;
      AppMethodBeat.o(185400);
      return;
      int i = 60 - paramInt;
      int j = (int)(this.DwO * i);
      this.DwS = Math.min(this.DwN + j, this.DwM);
      ac.d("MicroMsg.ChatFooter", "voiceWidth:%s, duration:%s, offset:%s", new Object[] { Integer.valueOf(this.DwS), Integer.valueOf(i), Integer.valueOf(j) });
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.DvJ.getWidth(), this.DwS }).setDuration(200L);
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
        ePd();
        continue;
        if (paramInt < 10) {
          ePe();
        }
      }
    }
  }
  
  private void vq(boolean paramBoolean)
  {
    AppMethodBeat.i(31598);
    if (paramBoolean)
    {
      this.Dub.setVisibility(0);
      this.DtZ.setVisibility(0);
      aF(true, false);
      AppMethodBeat.o(31598);
      return;
    }
    this.Dub.setVisibility(8);
    this.DtZ.setVisibility(8);
    aF(false, false);
    AppMethodBeat.o(31598);
  }
  
  private void vs(boolean paramBoolean)
  {
    AppMethodBeat.i(31673);
    if (this.DtY == null)
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((this.DwX) && (paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((!this.DwX) && (!paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    this.DwX = paramBoolean;
    if (paramBoolean)
    {
      this.DtY.setImageDrawable(getContext().getResources().getDrawable(2131231706));
      AppMethodBeat.o(31673);
      return;
    }
    this.DtY.setImageDrawable(getContext().getResources().getDrawable(2131690564));
    AppMethodBeat.o(31673);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void Xj(int paramInt)
  {
    AppMethodBeat.i(31616);
    Object localObject1;
    if (this.DvE)
    {
      if (this.DvG == null)
      {
        this.DvG = new o(View.inflate(getContext(), 2131495020, null), -1, -1, true);
        this.DvG.setSoftInputMode(16);
        this.DvG.setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(196147);
            if ((ChatFooter.this.Dxs == ChatFooter.e.DxP) && (ChatFooter.aI(ChatFooter.this)))
            {
              ac.i("MicroMsg.ChatFooter", "dismiss from keyback, need cancelRecording");
              ChatFooter.z(ChatFooter.this).setExitType(6);
              ChatFooter.l(ChatFooter.this).dbF();
            }
            ChatFooter.aJ(ChatFooter.this);
            AppMethodBeat.o(196147);
          }
        });
        this.DvH = this.DvG.getContentView().findViewById(2131302815);
        this.DvI = this.DvG.getContentView().findViewById(2131302837);
        this.DvJ = ((ViewGroup)this.DvG.getContentView().findViewById(2131302811));
        this.DvL = ((SoundWaveView)this.DvG.getContentView().findViewById(2131302817));
        this.DvK = ((EditText)this.DvG.getContentView().findViewById(2131302809));
        this.DvM = ((ImageView)this.DvG.getContentView().findViewById(2131302808));
        this.DvN = ((ViewGroup)this.DvG.getContentView().findViewById(2131302816));
        this.DvO = ((TextView)this.DvG.getContentView().findViewById(2131302807));
        this.DvP = ((WeImageView)this.DvG.getContentView().findViewById(2131302812));
        this.DvQ = ((LanguageChoiceLayout)this.DvG.getContentView().findViewById(2131302829));
        this.DvR = ((TextView)this.DvG.getContentView().findViewById(2131302813));
        this.DvS = ((ViewGroup)this.DvG.getContentView().findViewById(2131302818));
        this.DvT = ((TextView)this.DvG.getContentView().findViewById(2131302810));
        this.DvQ.setSelectLanguageListener(new LanguageChoiceLayout.a()
        {
          public final void RJ(int paramAnonymousInt)
          {
            AppMethodBeat.i(196148);
            ChatFooter.e(ChatFooter.this, paramAnonymousInt);
            if (bs.isNullOrNil((String)ChatFooter.aL(ChatFooter.this).get(Integer.valueOf(ChatFooter.aK(ChatFooter.this)))))
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
              ChatFooter.z(ChatFooter.this).Aka = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).Akd = 0;
              ChatFooter.z(ChatFooter.this).Ake = 0L;
              ChatFooter.z(ChatFooter.this).Akf = 0;
              ChatFooter.z(ChatFooter.this).Aki = 0;
              ChatFooter.z(ChatFooter.this).Akj = 0;
              ChatFooter.z(ChatFooter.this).Akk = 0;
              AppMethodBeat.o(196148);
              return;
              ChatFooter.aM(ChatFooter.this);
            }
          }
        });
        this.DvP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(196149);
            if (ChatFooter.aN(ChatFooter.this)) {
              ChatFooter.aO(ChatFooter.this).hideSoftInputFromWindow(ChatFooter.aA(ChatFooter.this).getWindowToken(), 0);
            }
            paramAnonymousView = ChatFooter.aP(ChatFooter.this);
            int i = ChatFooter.aK(ChatFooter.this);
            paramAnonymousView.setVisibility(0);
            paramAnonymousView.gDh.post(new LanguageChoiceLayout.4(paramAnonymousView, i));
            AppMethodBeat.o(196149);
          }
        });
        this.DvK.setMaxLines(2147483647);
        this.DvK.setHorizontallyScrolling(false);
        this.DvK.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(196150);
            if ((4 == paramAnonymousInt) || (66 == paramAnonymousKeyEvent.getAction()))
            {
              paramAnonymousTextView = ChatFooter.aA(ChatFooter.this).getText().toString();
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                if (!bs.isNullOrNil(paramAnonymousTextView)) {
                  ChatFooter.l(ChatFooter.this).akA(paramAnonymousTextView);
                }
                ChatFooter.l(ChatFooter.this).dbF();
              }
              AppMethodBeat.o(196150);
              return true;
            }
            AppMethodBeat.o(196150);
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
        this.DvK.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(196151);
            if (ChatFooter.aR(ChatFooter.this))
            {
              ChatFooter.f(ChatFooter.this, false);
              if (ChatFooter.this.AlP != null) {
                ChatFooter.this.AlP.an(false, true);
              }
              ChatFooter.aS(ChatFooter.this).stopTimer();
              ChatFooter.aA(ChatFooter.this).setText((CharSequence)ChatFooter.aL(ChatFooter.this).get(Integer.valueOf(ChatFooter.aK(ChatFooter.this))));
              ChatFooter.z(ChatFooter.this).Aki = 0;
              ChatFooter.z(ChatFooter.this).Ake = System.currentTimeMillis();
              ChatFooter.aT(ChatFooter.this);
            }
            ChatFooter.z(ChatFooter.this).Akk = 1;
            AppMethodBeat.o(196151);
            return false;
          }
        });
        this.DvU = ((ViewGroup)this.DvG.getContentView().findViewById(2131302814));
        this.DvV = ((ViewGroup)this.DvG.getContentView().findViewById(2131302840));
        this.DvW = this.DvG.getContentView().findViewById(2131302804);
        this.DvX = this.DvG.getContentView().findViewById(2131302838);
        this.DvY = ((WeImageView)this.DvG.getContentView().findViewById(2131302805));
        this.DvZ = ((WeImageView)this.DvG.getContentView().findViewById(2131302839));
        this.Dwa = this.DvG.getContentView().findViewById(2131302806);
        this.Dwb = this.DvG.getContentView().findViewById(2131302842);
        this.Dwc = ((ViewGroup)this.DvG.getContentView().findViewById(2131302841));
        this.Dwd = this.DvG.getContentView().findViewById(2131302820);
        this.Dwd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185353);
            ChatFooter.aU(ChatFooter.this);
            ChatFooter.z(ChatFooter.this).setExitType(6);
            ChatFooter.l(ChatFooter.this).dbF();
            AppMethodBeat.o(185353);
          }
        });
        this.Dwe = this.DvG.getContentView().findViewById(2131302835);
        this.Dwe.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185787);
            if (ChatFooter.l(ChatFooter.this) != null)
            {
              ChatFooter.aU(ChatFooter.this);
              ChatFooter.z(ChatFooter.this).setExitType(7);
              ChatFooter.l(ChatFooter.this).dI(ChatFooter.l(ChatFooter.this).getFileName(), ChatFooter.aV(ChatFooter.this));
              ChatFooter.ay(ChatFooter.this);
            }
            AppMethodBeat.o(185787);
          }
        });
        this.Dwh = this.DvG.getContentView().findViewById(2131302832);
        this.Dwh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(196152);
            if ((ChatFooter.aW(ChatFooter.this).getVisibility() == 0) && (8 == ChatFooter.aX(ChatFooter.this).getVisibility()))
            {
              paramAnonymousView = ChatFooter.aA(ChatFooter.this).getText().toString();
              if ((ChatFooter.l(ChatFooter.this) != null) && (!bs.isNullOrNil(paramAnonymousView)))
              {
                ChatFooter.aU(ChatFooter.this);
                ChatFooter.z(ChatFooter.this).Akc = ChatFooter.aK(ChatFooter.this);
                ChatFooter.z(ChatFooter.this).Akg = paramAnonymousView.length();
                if (1 != ChatFooter.z(ChatFooter.this).Akj) {
                  break label169;
                }
                ChatFooter.z(ChatFooter.this).setExitType(8);
              }
            }
            for (;;)
            {
              ChatFooter.l(ChatFooter.this).akA(paramAnonymousView);
              ChatFooter.l(ChatFooter.this).dbF();
              ChatFooter.b(ChatFooter.this, paramAnonymousView);
              AppMethodBeat.o(196152);
              return;
              label169:
              ChatFooter.z(ChatFooter.this).setExitType(5);
            }
          }
        });
        this.Dwf = ((WeImageView)this.DvG.getContentView().findViewById(2131302821));
        this.Dwg = ((WeImageView)this.DvG.getContentView().findViewById(2131302836));
        this.Dwi = this.DvG.getContentView().findViewById(2131302834);
        this.Dwj = ((WeImageView)this.DvG.getContentView().findViewById(2131302833));
        this.Dwk = ((ViewGroup)this.DvG.getContentView().findViewById(2131302843));
        this.Dwl = this.DvG.getContentView().findViewById(2131302845);
        this.Dwm = this.DvG.getContentView().findViewById(2131302847);
        this.Dwn = this.DvG.getContentView().findViewById(2131302846);
        this.Dwo = ((WeImageView)this.DvG.getContentView().findViewById(2131302844));
        localObject1 = (RelativeLayout.LayoutParams)this.Dwk.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).height = (getContext().getResources().getDimensionPixelSize(2131166976) + com.tencent.mm.ui.aq.ej(getContext()));
        this.Dwk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (FrameLayout.LayoutParams)this.Dwo.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (com.tencent.mm.ui.aq.ej(getContext()) + com.tencent.mm.ui.ao.fromDPToPix(getContext(), 14));
        this.Dwo.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.AlW = new au(new au.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(196153);
            int i = ChatFooter.aY(ChatFooter.this);
            ChatFooter.aZ(ChatFooter.this);
            switch (i % 3)
            {
            }
            for (;;)
            {
              ChatFooter.ba(ChatFooter.this);
              AppMethodBeat.o(196153);
              return true;
              ChatFooter.c(ChatFooter.this, "·");
              continue;
              ChatFooter.c(ChatFooter.this, "··");
              continue;
              ChatFooter.c(ChatFooter.this, "···");
            }
          }
        }, true);
        this.AlZ = new com.tencent.mm.sdk.platformtools.ao(new ao.a()
        {
          public final boolean handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(196154);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(196154);
              return true;
              ChatFooter.z(ChatFooter.this).Akd = 1;
              ChatFooter.z(ChatFooter.this).Ake = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).Aki = 0;
              ChatFooter.aS(ChatFooter.this).stopTimer();
              if (ChatFooter.this.AlP != null) {
                ChatFooter.this.AlP.an(false, false);
              }
              if (!bs.isNullOrNil((String)ChatFooter.aL(ChatFooter.this).get(Integer.valueOf(ChatFooter.aK(ChatFooter.this)))))
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
        this.Dwp = this.DvG.getContentView().findViewById(2131302819);
        this.DvG.setClippingEnabled(false);
      }
      paramInt = getTransLangTypeByTalker();
      if (com.tencent.mm.modelvoiceaddr.g.ieN == paramInt)
      {
        this.AjO = com.tencent.mm.modelvoiceaddr.g.ieO;
        if (this.DvQ != null) {
          this.DvQ.setSelectedLang(this.AjO);
        }
        ac.d("MicroMsg.ChatFooter", "curTxt:%s", new Object[] { Integer.valueOf(this.Dxu.size()) });
        if ((com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GWy, true)) || (!com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GWz, true))) {
          break label1662;
        }
        this.DvT.setTranslationY(com.tencent.mm.ui.ao.fromDPToPix(getContext(), 12));
        this.DvT.setVisibility(0);
        this.DvT.setAlpha(0.0F);
        this.DvT.setText(getContext().getResources().getString(2131761574));
        this.DvT.animate().alpha(1.0F).translationY(0.0F).setDuration(1000L).setStartDelay(500L).start();
        label1180:
        this.DvJ.setTranslationY(0.0F);
        this.DvM.setTranslationY(0.0F);
        this.DvP.setTranslationY(0.0F);
        this.DvU.setTranslationY(0.0F);
        paramInt = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 20);
        this.DvK.setPadding(paramInt, paramInt, paramInt, 0);
        this.DvK.addTextChangedListener(this.DwA);
        this.DvK.setVisibility(8);
        this.DvK.setCursorVisible(false);
        this.DvL.setVisibility(0);
        this.DvR.setVisibility(8);
        this.Dwh.setEnabled(true);
        this.DvJ.setActivated(true);
        this.Dwj.setImageDrawable(am.k(getContext(), 2131690391, getContext().getResources().getColor(2131099699)));
        this.DvM.setImageDrawable(am.k(getContext(), 2131690496, getContext().getResources().getColor(2131099759)));
        localObject1 = (FrameLayout.LayoutParams)this.Dwl.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 8);
        this.Dwl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.Dwl.setAlpha(0.0F);
        localObject1 = (FrameLayout.LayoutParams)this.Dwm.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ui.ao.fromDPToPix(getContext(), 8);
        this.Dwm.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.Dwm.setAlpha(0.0F);
        this.DvV.setTranslationY(this.Dxr);
        this.DvV.setAlpha(0.0F);
        this.DvL.setVisibility(8);
        this.Dwp.setVisibility(0);
        if (!aj.DT()) {
          break label1746;
        }
        this.DvI.setBackground(getContext().getResources().getDrawable(2131233433));
      }
      for (;;)
      {
        this.Dxe = false;
        this.DvG.showAtLocation(this, 49, 0, 0);
        eOs();
        this.DvP.setVisibility(8);
        AppMethodBeat.o(31616);
        return;
        this.AjO = paramInt;
        break;
        label1662:
        this.DvT.setTranslationY(com.tencent.mm.ui.ao.fromDPToPix(getContext(), 30));
        this.DvT.setVisibility(0);
        this.DvT.setAlpha(0.0F);
        this.DvT.setText(getContext().getResources().getString(2131761578));
        this.DvT.animate().alpha(1.0F).translationY(0.0F).setDuration(200L).setStartDelay(0L).start();
        break label1180;
        label1746:
        this.DvI.setBackground(getContext().getResources().getDrawable(2131233434));
      }
    }
    this.Dwx = 0;
    int i;
    if (this.Duv) {
      i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 280);
    }
    for (;;)
    {
      int j = BackwardSupportUtil.b.g(getContext(), 50.0F);
      if (paramInt + j < i)
      {
        this.Dwx = -1;
        if (this.zWY == null)
        {
          this.zWY = new o(View.inflate(getContext(), 2131495869, null), -1, -2);
          this.Duq = ((ViewGroup)this.zWY.getContentView().findViewById(2131306525));
          this.qNh = this.zWY.getContentView().findViewById(2131306519);
          this.qNg = ((ImageView)this.zWY.getContentView().findViewById(2131306631));
          this.Dur = ((TextView)this.zWY.getContentView().findViewById(2131306528));
          this.Dur.setTextSize(0, com.tencent.mm.cc.a.av(getContext(), 2131166735) * com.tencent.mm.cc.a.ib(getContext()));
          this.qNi = this.zWY.getContentView().findViewById(2131306521);
          this.zWZ = ((TextView)this.zWY.getContentView().findViewById(2131306523));
          this.zWZ.setTextSize(0, com.tencent.mm.cc.a.av(getContext(), 2131166735) * com.tencent.mm.cc.a.ib(getContext()));
          this.zXa = ((ImageView)this.zWY.getContentView().findViewById(2131306522));
          this.zXb = this.zWY.getContentView().findViewById(2131306524);
          this.qNf = this.zWY.getContentView().findViewById(2131306526);
          this.Dvb = ((ViewGroup)this.zWY.getContentView().findViewById(2131306474));
          this.Dvc = this.zWY.getContentView().findViewById(2131306467);
          this.Dvf = this.zWY.getContentView().findViewById(2131306478);
          this.Dvg = ((ImageView)this.zWY.getContentView().findViewById(2131306479));
          this.Dvh = ((ImageView)this.zWY.getContentView().findViewById(2131306466));
          this.Dvi = this.zWY.getContentView().findViewById(2131306468);
          this.Dvj = ((TextView)this.zWY.getContentView().findViewById(2131306471));
          this.Dvk = ((ImageView)this.zWY.getContentView().findViewById(2131306469));
          this.Dvl = this.zWY.getContentView().findViewById(2131306473);
          this.Dvm = this.zWY.getContentView().findViewById(2131306463);
          this.Dvn = ((WeImageView)this.zWY.getContentView().findViewById(2131306464));
          this.Dvo = ((TextView)this.zWY.getContentView().findViewById(2131306465));
          this.Dvp = this.zWY.getContentView().findViewById(2131306475);
          this.Dvq = ((WeImageView)this.zWY.getContentView().findViewById(2131306476));
          this.Dvr = ((TextView)this.zWY.getContentView().findViewById(2131306477));
          this.Dvs = View.inflate(getContext(), 2131494417, null);
        }
      }
      try
      {
        if (j.Dyc == this.DvA)
        {
          localObject1 = this.activity.getWindow().getDecorView();
          Drawable localDrawable = ((View)localObject1).getBackground();
          this.Dvd = new BlurView(getContext());
          paramInt = com.tencent.mm.cc.a.fromDPToPix(getContext(), 14);
          BlurView localBlurView = this.Dvd.x((ViewGroup)localObject1).aau(getResources().getColor(2131101069)).F(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).bR(15.0F).fjT();
          localBlurView.Iv = (paramInt * 1.0F);
          localBlurView.HIP = true;
          localBlurView.aav(this.Dwx).fjU();
          this.Dvt = new BlurView(getContext());
          this.Dvt.aau(getResources().getColor(2131101069));
          this.Dvt.x((ViewGroup)localObject1).F(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).bR(15.0F).fjT().fjU();
        }
        ac.i("MicroMsg.ChatFooter", "transVoiceBlurMode: %s.", new Object[] { this.DvA });
        switch (77.DxE[this.DvA.ordinal()])
        {
        default: 
          this.Dvx.setClippingEnabled(false);
          this.Dvx.getContentView().setAlpha(0.0F);
          this.Dvx.setOnDismissListener(new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(196155);
              ChatFooter.H(ChatFooter.this).getContentView().setAlpha(0.0F);
              AppMethodBeat.o(196155);
            }
          });
          ((TextView)this.zWY.getContentView().findViewById(2131306470)).setTextSize(0, com.tencent.mm.cc.a.av(getContext(), 2131166968) * com.tencent.mm.cc.a.ib(getContext()));
          eOt();
          if (this.Dwx != -1)
          {
            this.qNf.setVisibility(8);
            this.Duq.setVisibility(8);
            this.zXb.setVisibility(0);
            new com.tencent.mm.sdk.platformtools.ao().post(new Runnable()
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
            if (this.Duv)
            {
              eOZ();
              this.DvD = false;
              eOW();
              this.Dvx.showAtLocation(this, 49, 0, 0);
              this.DvC = false;
              if (this.Dxc)
              {
                this.Dxc = false;
                if (j.Dyc != this.DvA) {
                  break label3117;
                }
                this.Dvd.aau(getResources().getColor(2131101069)).F(this.activity.getWindow().getDecorView().getBackground()).xc(true);
              }
            }
            this.zWY.showAtLocation(this, 49, 0, this.Dwx);
          }
          else
          {
            AppMethodBeat.o(31616);
            return;
            i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 180);
            continue;
            this.Dwx = ((paramInt - i) / 2 + j);
          }
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.DvA = j.Dyd;
          this.Dwy = true;
          continue;
          this.Dvb.removeView(this.Dvc);
          Object localObject2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(2131166964), getResources().getDimensionPixelSize(2131166964));
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          this.Dvd.addView(this.Dvc, (ViewGroup.LayoutParams)localObject2);
          this.Dvb.addView(this.Dvd, (ViewGroup.LayoutParams)localObject2);
          this.Dve = this.Dvd;
          localObject2 = new FrameLayout.LayoutParams(-1, -1);
          this.Dvt.addView(this.Dvs, (ViewGroup.LayoutParams)localObject2);
          this.Dvx = new o(this.Dvt, -1, -1);
          continue;
          this.Dve = this.Dvc;
          this.Dve.setBackgroundResource(2131234483);
          this.Dvs.setBackgroundColor(getResources().getColor(2131101071));
          this.Dvx = new o(this.Dvs, -1, -1);
          continue;
          label3117:
          this.Dve.setBackgroundResource(2131234483);
        }
      }
    }
  }
  
  public final void Xk(int paramInt)
  {
    AppMethodBeat.i(31622);
    if (this.DvE)
    {
      if ((this.DvL != null) && (this.DvL.getVisibility() == 0)) {
        this.DvL.RK(paramInt);
      }
      AppMethodBeat.o(31622);
      return;
    }
    if (this.Duv)
    {
      i = 0;
      for (;;)
      {
        if (i < DwV.length)
        {
          if ((paramInt >= DwU[i]) && (paramInt < DwU[(i + 1)])) {
            this.Dvg.setBackgroundDrawable(com.tencent.mm.cc.a.l(getContext(), DwV[i]));
          }
        }
        else
        {
          if ((paramInt != -1) || (this.zWY == null)) {
            break;
          }
          this.zWY.dismiss();
          this.zXb.setVisibility(0);
          this.Duq.setVisibility(8);
          this.qNf.setVisibility(8);
          AppMethodBeat.o(31622);
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < DwV.length)
      {
        if ((paramInt >= DwU[i]) && (paramInt < DwU[(i + 1)])) {
          this.qNg.setBackgroundDrawable(com.tencent.mm.cc.a.l(getContext(), DwV[i]));
        }
      }
      else
      {
        if ((paramInt == -1) && (this.zWY != null))
        {
          this.zWY.dismiss();
          this.zXb.setVisibility(0);
          this.Duq.setVisibility(8);
          this.qNf.setVisibility(8);
        }
        AppMethodBeat.o(31622);
        return;
      }
      i += 1;
    }
  }
  
  public final void Xl(int paramInt)
  {
    AppMethodBeat.i(31624);
    this.Duu = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31624);
      return;
      vq(true);
      this.DtR.setVisibility(8);
      Xi(2131231707);
      AppMethodBeat.o(31624);
      return;
      vq(false);
      this.DtR.setVisibility(0);
      eOQ();
      Xi(2131231706);
      if ((u.aye().booleanValue()) && (this.DuS != null))
      {
        c localc = this.DuS;
        Boolean localBoolean = Boolean.TRUE;
        localc.b(localBoolean, localBoolean);
      }
    }
  }
  
  public final void Xm(int paramInt)
  {
    AppMethodBeat.i(185823);
    b(paramInt, true, 0, 0);
    AppMethodBeat.o(185823);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, com.tencent.mm.modelvoiceaddr.h paramh, boolean paramBoolean2)
  {
    AppMethodBeat.i(185826);
    ac.d("MicroMsg.ChatFooter", "startTrans, hasStartTrans: %s, isForce: %s.", new Object[] { Boolean.valueOf(this.Dxv), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean2) {
      if (this.Dxv)
      {
        if (this.AlP != null) {
          this.AlP.an(false, true);
        }
        this.AlZ.removeMessages(5000);
        this.AlW.stopTimer();
      }
    }
    while (!this.Dxv)
    {
      this.Dxv = true;
      this.AlP = new com.tencent.mm.plugin.transvoice.a.b(paramh, paramInt, new g.b()
      {
        public final void aKH()
        {
          AppMethodBeat.i(196178);
          ac.d("MicroMsg.ChatFooter", "onRecordFin.");
          AppMethodBeat.o(196178);
        }
        
        public final void aKL()
        {
          AppMethodBeat.i(196179);
          if ((ChatFooter.this.AlP != null) && (!ChatFooter.this.AlP.AjP))
          {
            ac.d("MicroMsg.ChatFooter", "onRecognizeFinish, %s.", new Object[] { Boolean.valueOf(ChatFooter.this.AlP.AjP) });
            ChatFooter.z(ChatFooter.this).Aki = 1;
            ChatFooter.z(ChatFooter.this).Ake = System.currentTimeMillis();
            ChatFooter.f(ChatFooter.this, false);
            ChatFooter.aT(ChatFooter.this);
            ChatFooter.this.AlP = null;
            ChatFooter.bv(ChatFooter.this).removeMessages(5000);
            ChatFooter.aS(ChatFooter.this).stopTimer();
            ChatFooter.aM(ChatFooter.this);
          }
          AppMethodBeat.o(196179);
        }
        
        public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(196176);
          ac.d("MicroMsg.ChatFooter", "newVoice2txt onRes, %s.", new Object[] { ChatFooter.this.AlP });
          ChatFooter.bu(ChatFooter.this).clear();
          if (!bs.gY(paramAnonymousList)) {
            ChatFooter.bu(ChatFooter.this).addAll(paramAnonymousList);
          }
          if (!ChatFooter.aR(ChatFooter.this))
          {
            ChatFooter.f(ChatFooter.this, true);
            ChatFooter.aA(ChatFooter.this).setFocusable(true);
            ChatFooter.aA(ChatFooter.this).setFocusableInTouchMode(true);
            ChatFooter.aA(ChatFooter.this).requestFocus();
          }
          if ((ChatFooter.this.AlP != null) && (!ChatFooter.this.AlP.AjP))
          {
            ChatFooter.bv(ChatFooter.this).removeMessages(5000);
            ChatFooter.bv(ChatFooter.this).sendEmptyMessageDelayed(5000, 5000L);
          }
          if (!bs.isNullOrNil(paramAnonymousArrayOfString[0]))
          {
            ChatFooter.aL(ChatFooter.this).put(Integer.valueOf(ChatFooter.aK(ChatFooter.this)), paramAnonymousArrayOfString[0]);
            if (ChatFooter.aL(ChatFooter.this) != null) {
              ChatFooter.z(ChatFooter.this).Akf = paramAnonymousArrayOfString[0].length();
            }
            ac.d("MicroMsg.ChatFooter", "newVoice2txt onRes, curTxt: %s.", new Object[] { paramAnonymousArrayOfString[0] });
          }
          AppMethodBeat.o(196176);
        }
        
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
        {
          AppMethodBeat.i(196177);
          ac.d("MicroMsg.ChatFooter", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong) });
          ChatFooter.z(ChatFooter.this).Aki = 0;
          ChatFooter.z(ChatFooter.this).Ake = System.currentTimeMillis();
          ChatFooter.aT(ChatFooter.this);
          AppMethodBeat.o(196177);
        }
      });
      this.AlP.AjP = paramBoolean1;
      this.AlP.start();
      this.AlW.au(500L, 500L);
      AppMethodBeat.o(185826);
      return;
    }
    AppMethodBeat.o(185826);
  }
  
  public final void a(Context paramContext, Activity paramActivity)
  {
    boolean bool2 = true;
    AppMethodBeat.i(31575);
    ac.i("MicroMsg.ChatFooter", "onResume: %s, %s", new Object[] { Boolean.valueOf(y.iA(paramContext)), Integer.valueOf(getContext().getResources().getConfiguration().orientation) });
    this.DuA = true;
    this.activity = paramActivity;
    if ((this.DuF == 48) && (this.DuB == 1) && (!this.DuN))
    {
      this.tzA = false;
      h(0, false, -1);
    }
    boolean bool1 = bool2;
    if (getContext().getResources().getConfiguration().orientation != 1)
    {
      if (y.iA(paramContext)) {
        bool1 = bool2;
      }
    }
    else
    {
      this.Duz = bool1;
      if (com.tencent.mm.compatible.util.d.kZ(24)) {
        this.DuH = ((Activity)getContext()).isInMultiWindowMode();
      }
      eOO();
      eOT();
      if (com.tencent.mm.pluginsdk.model.app.aq.eLo().Djn) {
        com.tencent.mm.pluginsdk.model.app.aq.eLo().hp(com.tencent.mm.sdk.platformtools.ai.getContext());
      }
      if ((!this.DtU.ePo()) && (this.fWT != null)) {
        this.fWT.onResume();
      }
      if ((this.DuV) || (!this.Dux)) {
        break label293;
      }
      eOI();
    }
    for (;;)
    {
      Xo(getKeyBordHeightPX());
      if (this.DtP != null) {
        this.DtP.context = paramContext;
      }
      this.Duf.DyH = false;
      if (!this.Dpb) {
        eOH();
      }
      eOo();
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
      if ((this.DuV) && (!this.Dux)) {
        eOG();
      }
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(31574);
    this.DuX = paramb;
    this.Duh = new com.tencent.mm.plugin.groupsolitaire.ui.d(getContext(), this.DuX.ePn(), new d.d()
    {
      public final void aim(String paramAnonymousString)
      {
        AppMethodBeat.i(185758);
        if ((ChatFooter.l(ChatFooter.this) != null) && (!bs.isNullOrNil(paramAnonymousString))) {
          ChatFooter.l(ChatFooter.this).aim(paramAnonymousString);
        }
        AppMethodBeat.o(185758);
      }
      
      public final void cSA()
      {
        AppMethodBeat.i(185757);
        ChatFooter.this.cSA();
        ChatFooter.this.eOm();
        AppMethodBeat.o(185757);
      }
    });
    this.Duh.tAh = this.DuQ;
    AppMethodBeat.o(31574);
  }
  
  public final void a(final h paramh)
  {
    AppMethodBeat.i(185822);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185361);
        ChatFooter.x(ChatFooter.this).setBackgroundResource(2131232725);
        ChatFooter.x(ChatFooter.this).setText(2131757093);
        if (ChatFooter.this.DvE)
        {
          switch (ChatFooter.77.DxG[paramh.ordinal()])
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
  
  public final boolean aE(bo parambo)
  {
    AppMethodBeat.i(31678);
    if (this.Dui != null) {
      this.Dui.dbJ();
    }
    this.Duc.setTag(parambo);
    this.Duu = 1;
    vq(true);
    this.DtR.setVisibility(8);
    Xi(2131231707);
    if (this.DoY != null)
    {
      this.DoY.setVisibility(8);
      this.Dpb = false;
      this.DoY.reset();
    }
    showVKB();
    vp(true);
    aHv("");
    AppMethodBeat.o(31678);
    return true;
  }
  
  public final void aG(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31632);
    this.DtP.ve(paramBoolean1);
    this.DtP.vf(paramBoolean2);
    AppMethodBeat.o(31632);
  }
  
  public final void aHv(String paramString)
  {
    AppMethodBeat.i(31675);
    com.tencent.mm.plugin.groupsolitaire.ui.d locald;
    String str2;
    if ((this.Duh != null) && (this.fTu != null) && (this.DuX != null))
    {
      locald = this.Duh;
      str2 = this.DuX.getTalkerUserName();
      localObject = this.fTu;
      ac.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow supportAnalyze:%s supportShow:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).ahY(str2)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).ahZ(str2)) });
      locald.tAi = ((View)localObject);
      locald.content = paramString;
      if (((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).ahY(str2))
      {
        if ((bs.isNullOrNil(paramString)) || (paramString.equals(locald.tzW))) {
          break label324;
        }
        com.tencent.e.h.JZN.aTz("GroupSolitaireCheck");
      }
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).Xw(paramString);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    locald.tAf.setContent(paramString);
    locald.tAf.ail(locald.tzy);
    com.tencent.e.h.JZN.a(locald.tAf, 500L, "GroupSolitaireCheck");
    Object localObject = paramString;
    if (bs.isNullOrNil(locald.tzW))
    {
      locald.tAg.setContent(paramString);
      locald.tAg.ail(locald.tzy);
      com.tencent.e.h.JZN.a(locald.tAg, 500L, "GroupSolitaireCopyCheck");
      localObject = paramString;
    }
    for (;;)
    {
      locald.tzW = ((String)localObject);
      locald.tzy = str2;
      AppMethodBeat.o(31675);
      return;
      label324:
      String str1 = paramString;
      if (bs.isNullOrNil(paramString))
      {
        locald.cSx();
        str1 = paramString;
      }
    }
  }
  
  public final void aQ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31602);
    if (this.Dum.DxM.containsKey(paramString1)) {}
    Object localObject;
    for (paramString1 = (LinkedList)this.Dum.DxM.get(paramString1);; paramString1 = (String)localObject)
    {
      localObject = new HashMap(1);
      ((HashMap)localObject).put(paramString3, paramString2);
      paramString1.add(localObject);
      AppMethodBeat.o(31602);
      return;
      localObject = new LinkedList();
      this.Dum.DxM.put(paramString1, localObject);
    }
  }
  
  public final void aT(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(31625);
    Xl(paramInt);
    switch (paramInt)
    {
    default: 
      setVisibility(0);
      AppMethodBeat.o(31625);
      return;
    case 1: 
      if (paramBoolean)
      {
        vp(true);
        showVKB();
        if (this.uyM.length() > 0) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          nM(paramBoolean);
          AppMethodBeat.o(31625);
          return;
        }
      }
      if (this.uyM.length() > 0) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        nM(paramBoolean);
        AppMethodBeat.o(31625);
        return;
      }
    }
    g(0, true, -1);
    nM(false);
    AppMethodBeat.o(31625);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(31615);
    this.Dww = new i(paramTextWatcher);
    this.uyM.addTextChangedListener(this.Dww);
    AppMethodBeat.o(31615);
  }
  
  public final void bZu()
  {
    AppMethodBeat.i(31610);
    this.Dvy.setExitType(1);
    this.DtR.setEnabled(false);
    this.DtR.setBackgroundResource(2131233809);
    if (this.DvE)
    {
      this.DvI.setVisibility(8);
      this.DvH.setVisibility(0);
      this.DvG.update();
      this.oPS.sendEmptyMessageDelayed(0, 500L);
      AppMethodBeat.o(31610);
      return;
    }
    if (this.zWY != null)
    {
      this.qNf.setVisibility(0);
      this.Duq.setVisibility(8);
      this.zXb.setVisibility(8);
      this.zWY.update();
      this.Dvx.dismiss();
    }
    this.oPS.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(31610);
  }
  
  public final void cSA()
  {
    AppMethodBeat.i(31679);
    if (this.uyM != null)
    {
      this.uyM.setText("");
      eOl();
    }
    AppMethodBeat.o(31679);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31578);
    if (this.fWT != null)
    {
      ac.i("MicroMsg.ChatFooter", "jacks chat footer destroy smiley panel");
      this.fWT.eMG();
      this.fWT.destroy();
      this.fWT.animate().cancel();
      this.fWT = null;
    }
    if (this.DoY != null)
    {
      this.DoY.destroy();
      this.DoY = null;
      this.Dpb = false;
    }
    if (this.Dui != null) {
      this.Dui.release();
    }
    if (this.Dug != null)
    {
      this.Dug.DuU = null;
      this.Dug.DyS = null;
      this.Dug.hide();
    }
    if (this.zWY != null)
    {
      if (this.Dvd != null) {
        this.Dvd.getBlurController().destroy();
      }
      if (this.Dvt != null) {
        this.Dvt.getBlurController().destroy();
      }
    }
    ac.i("MicroMsg.ChatFooter", "jacks destroy chat footer.");
    AppMethodBeat.o(31578);
  }
  
  public final void eMH()
  {
    AppMethodBeat.i(31591);
    this.Duy = true;
    if (this.fWT != null) {
      this.fWT.eMH();
    }
    AppMethodBeat.o(31591);
  }
  
  public final void eNf()
  {
    AppMethodBeat.i(31601);
    if (!this.Dpb)
    {
      AppMethodBeat.o(31601);
      return;
    }
    this.Dpb = false;
    if (this.DoY != null)
    {
      int i = getKeyBordHeightPX();
      int j = this.DtT.getHeight();
      this.DoY.animate().cancel();
      this.DoY.animate().translationY(i + j).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196144);
          if (ChatFooter.ax(ChatFooter.this) != null)
          {
            ChatFooter.ax(ChatFooter.this).destroy();
            ChatFooter.ax(ChatFooter.this).setVisibility(8);
          }
          AppMethodBeat.o(196144);
        }
      }).start();
    }
    this.uyM.setText("");
    AppMethodBeat.o(31601);
  }
  
  public final void eOA()
  {
    AppMethodBeat.i(31631);
    AppPanel localAppPanel = this.DtP;
    localAppPanel.DsB.Dtc.value = false;
    localAppPanel.eNZ();
    AppMethodBeat.o(31631);
  }
  
  public final void eOB()
  {
    AppMethodBeat.i(31635);
    AppPanel localAppPanel = this.DtP;
    localAppPanel.DsJ = true;
    localAppPanel.DsB.vm(false);
    localAppPanel.eNZ();
    ac.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", new Object[] { bs.eWi().toString() });
    AppMethodBeat.o(31635);
  }
  
  public final void eOC()
  {
    this.DtP.DsM = true;
  }
  
  public final void eOD()
  {
    AppMethodBeat.i(31636);
    AppPanel localAppPanel = this.DtP;
    localAppPanel.DsK = true;
    localAppPanel.DsB.vj(false);
    localAppPanel.eNZ();
    ac.i("MicroMsg.AppPanel", "disableServiceRemittance %s", new Object[] { bs.eWi().toString() });
    AppMethodBeat.o(31636);
  }
  
  public final void eOE()
  {
    AppMethodBeat.i(31637);
    if (this.DtY != null) {
      this.DtY.setVisibility(8);
    }
    AppMethodBeat.o(31637);
  }
  
  public final void eOF()
  {
    AppMethodBeat.i(31638);
    AppPanel localAppPanel = this.DtP;
    localAppPanel.DsL = true;
    localAppPanel.DsB.vn(false);
    localAppPanel.eNZ();
    AppMethodBeat.o(31638);
  }
  
  public final void eOG()
  {
    AppMethodBeat.i(31639);
    ac.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
    this.Dux = true;
    this.uyM.setImeOptions(4);
    this.uyM.setInputType(this.uyM.getInputType() & 0xFFFFFFBF);
    AppMethodBeat.o(31639);
  }
  
  public final boolean eOJ()
  {
    AppMethodBeat.i(31645);
    if ((this.DuW == null) || (this.DuW.getView() == null))
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Object localObject = this.DuW.getView().findViewById(2131302320);
    if (localObject == null)
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Rect localRect = new Rect();
    ((View)localObject).getGlobalVisibleRect(localRect);
    if (com.tencent.mm.compatible.util.d.kZ(28))
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
  
  public final boolean eOK()
  {
    return this.DuB != 0;
  }
  
  public final void eOL()
  {
    AppMethodBeat.i(31653);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31552);
        ac.i("MicroMsg.ChatFooter", "withLastText: ");
        ChatFooter.this.showVKB();
        ChatFooter.a(ChatFooter.this, true);
        AppMethodBeat.o(31552);
      }
    }, 500L);
    AppMethodBeat.o(31653);
  }
  
  public final void eOM()
  {
    AppMethodBeat.i(31655);
    if ((this.DoY != null) && (this.DoY.isShown())) {
      this.DoY.ePw();
    }
    AppMethodBeat.o(31655);
  }
  
  public final void eOP()
  {
    AppMethodBeat.i(196181);
    if (this.Dug != null)
    {
      this.Dug.DyT = false;
      this.Dug.hide();
    }
    AppMethodBeat.o(196181);
  }
  
  public final void eOQ()
  {
    AppMethodBeat.i(31674);
    if (this.Duh != null) {
      this.Duh.cSx();
    }
    AppMethodBeat.o(31674);
  }
  
  public final boolean eOR()
  {
    AppMethodBeat.i(31677);
    if ((this.Duc.getTag() != null) && ((this.Duc.getTag() instanceof bo)) && (this.Dub.isShown()) && (this.Duc.isShown()))
    {
      AppMethodBeat.o(31677);
      return true;
    }
    AppMethodBeat.o(31677);
    return false;
  }
  
  public final void eOS()
  {
    AppMethodBeat.i(31681);
    this.DtR.setBackgroundResource(2131232725);
    this.DtR.setText(2131757093);
    Object localObject;
    if (this.DvE)
    {
      if (!this.Dxe)
      {
        this.Dxe = true;
        if (this.Dui == null) {
          break label299;
        }
        this.Dvy.AjZ = this.Dui.Oq();
        if ((this.DvG == null) || (!this.DvG.isShowing())) {
          break label299;
        }
        if (e.DxO == this.Dxs)
        {
          this.Dws = false;
          this.Dui.dbE();
          this.Dvy.setExitType(2);
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWz, Boolean.FALSE);
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        AppMethodBeat.o(31681);
        return;
      }
      if (e.DxP == this.Dxs)
      {
        if (this.Dxd <= 0) {
          this.Dxd = ((int)this.Dui.Oq());
        }
        if (!bs.isNullOrNil(this.Dui.getFileName()))
        {
          localObject = com.tencent.mm.ck.a.Hez;
          com.tencent.mm.ck.a.a.aPs(this.Dui.getFileName());
        }
        this.Dui.dbC();
        ePj();
        this.AlZ.sendEmptyMessageDelayed(5000, 5000L);
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWz, Boolean.FALSE);
        AppMethodBeat.o(31681);
        return;
      }
      if (e.DxN == this.Dxs)
      {
        this.Dws = false;
        this.Dui.dbB();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWy, Boolean.FALSE);
      }
      label299:
      AppMethodBeat.o(31681);
      return;
    }
    this.oPF = false;
    if (this.Dui != null)
    {
      this.Dvy.AjZ = this.Dui.Oq();
      if (this.Duv)
      {
        if (k.Dyf != this.DvB)
        {
          this.Dxc = true;
          if ((this.zWY != null) && (this.zWY.isShowing()))
          {
            if (k.Dyh == this.DvB)
            {
              ac.i("MicroMsg.ChatFooter", "do not send voice.");
              this.Dvy.setExitType(2);
              this.Dui.dbE();
              AppMethodBeat.o(31681);
              return;
            }
            ac.i("MicroMsg.ChatFooter", "trans voice to txt.");
            this.Dui.dbC();
            localObject = this.Dui.getFileName();
            final long l = this.Dui.Oq();
            ac.i("transvoice", "fileName: %s, voiceLen: %d.", new Object[] { localObject, Long.valueOf(l) });
            if (ax.isConnected(getContext()))
            {
              if (this.Dvw.isValid())
              {
                this.Dvu.axZ((String)localObject);
                this.Dvu.AlR = l;
                this.Dvu.talker = this.DtO;
                this.Dvu.show();
                this.Dvu.c(this.Dvw);
                this.DuI = false;
                AppMethodBeat.o(31681);
                return;
              }
              this.Dvy.setExitType(3);
              locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
              locala.aRI(getResources().getString(2131764730));
              locala.aRO(getResources().getString(2131764731));
              locala.acO(getResources().getColor(2131099770));
              locala.b(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(185799);
                  ChatFooter.l(ChatFooter.this).akB(this.cNj);
                  AppMethodBeat.o(185799);
                }
              });
              locala.yf(false);
              locala.fvp().show();
              AppMethodBeat.o(31681);
              return;
            }
            this.Dvy.setExitType(4);
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
            locala.aRI(getResources().getString(2131761547));
            locala.aRO(getResources().getString(2131761549));
            locala.acO(getResources().getColor(2131099770));
            locala.aRP(getResources().getString(2131761548));
            locala.b(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(196163);
                ChatFooter.l(ChatFooter.this).dI(this.cNj, (int)l);
                AppMethodBeat.o(196163);
              }
            });
            locala.c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(196164);
                ChatFooter.l(ChatFooter.this).akB(this.cNj);
                AppMethodBeat.o(196164);
              }
            });
            locala.fvp().show();
            AppMethodBeat.o(31681);
          }
        }
        else
        {
          this.Dui.dbB();
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        if ((this.qNi != null) && (this.qNi.getVisibility() == 0))
        {
          this.Dvy.setExitType(2);
          this.Dui.dbE();
          AppMethodBeat.o(31681);
          return;
        }
        this.Dui.dbB();
      }
    }
    AppMethodBeat.o(31681);
  }
  
  public final void eOT()
  {
    AppMethodBeat.i(31683);
    az.ayM();
    this.DuV = ((Boolean)com.tencent.mm.model.c.agA().get(66832, Boolean.FALSE)).booleanValue();
    if (this.uyM != null) {
      this.uyM.setEnableSendBtn(this.DuV);
    }
    AppMethodBeat.o(31683);
  }
  
  public final void eOU()
  {
    AppMethodBeat.i(31685);
    if ((this.fTu == null) || (this.fTu.getVisibility() == 8))
    {
      AppMethodBeat.o(31685);
      return;
    }
    if (this.Dxi == 0)
    {
      this.Dxi = this.fTu.getWidth();
      this.Dxj = this.DtW.getWidth();
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.Dxi, this.Dxj });
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
        ac.i("MicroMsg.ChatFooter", "animHideSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bq(ChatFooter.this)) });
        ChatFooter.this.eOV();
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
  
  public final void eOV()
  {
    AppMethodBeat.i(31686);
    if (this.fTu == null)
    {
      AppMethodBeat.o(31686);
      return;
    }
    if (this.Dxi == 0)
    {
      this.Dxi = this.fTu.getWidth();
      this.Dxj = this.DtW.getWidth();
    }
    if (this.Dxi == 0)
    {
      this.fTu.startAnimation(this.DuY);
      this.fTu.setVisibility(0);
      AppMethodBeat.o(31686);
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.Dxj, this.Dxi });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(196165);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bo(ChatFooter.this)) / (ChatFooter.bp(ChatFooter.this) - ChatFooter.bo(ChatFooter.this));
        ChatFooter.k(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(196165);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(196168);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.i(ChatFooter.this, false);
        AppMethodBeat.o(196168);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(196167);
        paramAnonymousAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousAnimator.width = -2;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousAnimator);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.i(ChatFooter.this, false);
        if (!ChatFooter.bq(ChatFooter.this))
        {
          ac.i("MicroMsg.ChatFooter", "animShowSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bq(ChatFooter.this)) });
          ChatFooter.r(ChatFooter.this).setVisibility(0);
          ChatFooter.i(ChatFooter.this, true);
          ChatFooter.this.eOU();
        }
        AppMethodBeat.o(196167);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(196166);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(196166);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(31686);
  }
  
  public final void eOl()
  {
    AppMethodBeat.i(31572);
    if (this.DuR != null)
    {
      com.tencent.mm.g.b.a.c localc = this.DuR;
      localc.dDc = 0L;
      localc.dDa = 0L;
      localc.dDb = 0L;
      localc.dDd = 0L;
      localc.bn(0L).bo(0L);
    }
    AppMethodBeat.o(31572);
  }
  
  public final void eOm()
  {
    AppMethodBeat.i(31581);
    if (!bs.aj(this.Dud.getText())) {
      this.Dud.setText("");
    }
    if (this.Duc.getTag() != null) {
      this.Duc.setTag(null);
    }
    this.Duc.setVisibility(8);
    AppMethodBeat.o(31581);
  }
  
  public final void eOn()
  {
    AppMethodBeat.i(31583);
    if (this.DtP == null)
    {
      AppMethodBeat.o(31583);
      return;
    }
    this.DtP.eNO();
    AppMethodBeat.o(31583);
  }
  
  public final void eOo()
  {
    AppMethodBeat.i(31587);
    this.DtY = ((ImageButton)this.ifK.findViewById(2131298172));
    this.DtY.setVisibility(0);
    if (!com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GRv, true)) {
      this.ifK.findViewById(2131298173).setVisibility(0);
    }
    for (;;)
    {
      this.ifK.findViewById(2131298173).setVisibility(8);
      this.DtY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184916);
          paramAnonymousView = com.tencent.mm.emoji.b.a.fUV;
          com.tencent.mm.emoji.b.a.adp();
          if (ChatFooter.l(ChatFooter.this) != null) {
            ChatFooter.l(ChatFooter.this).dbH();
          }
          if (ChatFooter.c(ChatFooter.this) == 2)
          {
            ChatFooter.this.showVKB();
            AppMethodBeat.o(184916);
            return;
          }
          if (ChatFooter.s(ChatFooter.this)) {
            ChatFooter.this.eMH();
          }
          ChatFooter.this.eOr();
          if (!com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GRv, false))
          {
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRv, Boolean.TRUE);
            ChatFooter.t(ChatFooter.this).findViewById(2131298173).setVisibility(8);
          }
          AppMethodBeat.o(184916);
        }
      });
      if (this.Dug != null) {
        this.Dug.DyR = this.DtY;
      }
      if (this.Duh != null) {
        this.Duh.tzT = this.ifK;
      }
      AppMethodBeat.o(31587);
      return;
      this.ifK.findViewById(2131298173).setVisibility(8);
    }
  }
  
  public final void eOp()
  {
    boolean bool = true;
    AppMethodBeat.i(31590);
    if ((e.DyA == null) || (getContext() == null))
    {
      if (getContext() == null)
      {
        ac.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", new Object[] { bs.eWi() });
        this.fWT = new d(com.tencent.mm.sdk.platformtools.ai.getContext());
        AppMethodBeat.o(31590);
        return;
      }
      this.fWT = new d(getContext());
      AppMethodBeat.o(31590);
      return;
    }
    if (this.fWT != null) {
      this.fWT.destroy();
    }
    this.fWT = e.DyA.eA(getContext());
    ChatFooterPanel localChatFooterPanel;
    if (this.fWT != null)
    {
      this.fWT.setEntranceScene(ChatFooterPanel.Dnk);
      this.fWT.setVisibility(8);
      this.fWT.setFooterType(this.BZU);
      if (this.DtU != null) {
        this.DtU.addView(this.fWT, -1, -1);
      }
      this.fWT.setOnTextOperationListener(this.Dwt);
      localChatFooterPanel = this.fWT;
      if (this.uyM.getText().length() <= 0) {
        break label269;
      }
    }
    for (;;)
    {
      localChatFooterPanel.setSendButtonEnable(bool);
      if (this.DuX != null) {
        this.fWT.setTalkerName(this.DuX.getTalkerUserName());
      }
      this.fWT.onResume();
      if (this.Duy) {
        eMH();
      }
      setSmileyPanelCallback(this.Dni);
      AppMethodBeat.o(31590);
      return;
      label269:
      bool = false;
    }
  }
  
  public final void eOr()
  {
    AppMethodBeat.i(31597);
    this.Duu = 1;
    vq(true);
    this.DtR.setVisibility(8);
    Xi(2131231707);
    if (this.DoY != null)
    {
      this.DoY.setVisibility(8);
      this.Dpb = false;
      this.DoY.reset();
    }
    g(2, true, -1);
    AppMethodBeat.o(31597);
  }
  
  public final void eOu()
  {
    AppMethodBeat.i(31620);
    if (this.DvE)
    {
      this.DvL.setVisibility(0);
      this.Dwp.setVisibility(8);
      AppMethodBeat.o(31620);
      return;
    }
    this.zXb.setVisibility(8);
    this.Duq.setVisibility(0);
    AppMethodBeat.o(31620);
  }
  
  public final void eOv()
  {
    AppMethodBeat.i(31626);
    vq(true);
    this.DtS.setVisibility(8);
    this.DtR.setVisibility(8);
    AppMethodBeat.o(31626);
  }
  
  public final void eOw()
  {
    AppMethodBeat.i(31627);
    if (this.DtS != null) {
      this.DtS.setVisibility(0);
    }
    AppMethodBeat.o(31627);
  }
  
  public final void eOx()
  {
    AppMethodBeat.i(31628);
    AppPanel localAppPanel = this.DtP;
    localAppPanel.DsB.DsY.value = false;
    localAppPanel.eNZ();
    AppMethodBeat.o(31628);
  }
  
  public final void eOy()
  {
    AppMethodBeat.i(31629);
    AppPanel localAppPanel = this.DtP;
    localAppPanel.DsB.Dtq.value = false;
    localAppPanel.eNZ();
    AppMethodBeat.o(31629);
  }
  
  public final void eOz()
  {
    AppMethodBeat.i(31630);
    AppPanel localAppPanel = this.DtP;
    localAppPanel.DsB.DsZ.value = false;
    localAppPanel.eNZ();
    AppMethodBeat.o(31630);
  }
  
  public final boolean ePk()
  {
    AppMethodBeat.i(185416);
    if ((this.DvG != null) && (this.DvG.isShowing()))
    {
      AppMethodBeat.o(185416);
      return true;
    }
    AppMethodBeat.o(185416);
    return false;
  }
  
  public final int fG(String paramString, int paramInt)
  {
    AppMethodBeat.i(163213);
    int i = paramInt;
    if (this.Dum.DxM.containsKey(paramString))
    {
      i = paramInt;
      if (((LinkedList)this.Dum.DxM.get(paramString)).size() > 0) {
        i = paramInt | 0x1;
      }
    }
    paramInt = i;
    if (this.Dup) {
      paramInt = i | 0x2;
    }
    AppMethodBeat.o(163213);
    return paramInt;
  }
  
  public final void fH(View paramView)
  {
    int i = -1;
    AppMethodBeat.i(163212);
    if (this.Dui != null) {
      this.Dui.dbI();
    }
    ac.i("MicroMsg.ChatFooter", "click attach btn: %s, %s", new Object[] { Integer.valueOf(this.DtP.getVisibility()), Boolean.valueOf(this.DtU.ePo()) });
    if (this.DuB == 3)
    {
      if (this.Duu == 1)
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
      if ((this.DoY != null) && (this.DoY.getVisibility() == 0) && (this.Dpb))
      {
        ac.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
        this.DoY.setVisibility(8);
        this.Dpb = false;
        this.DoY.reset();
      }
      paramView = com.tencent.mm.pluginsdk.model.app.aq.eLo();
      localObject = com.tencent.mm.sdk.platformtools.ai.getContext();
      if ((com.tencent.mm.kernel.g.agM()) && (localObject != null)) {
        break label284;
      }
      label187:
      com.tencent.mm.pluginsdk.model.app.aq.eLo().hp(com.tencent.mm.sdk.platformtools.ai.getContext());
      if ((w.wp(this.toUser)) && (com.tencent.mm.chatroom.d.aa.VQ()))
      {
        paramView = this.toUser;
        if (!w.xB(paramView)) {
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
        ((com.tencent.mm.g.b.a.n)localObject).fL(paramView);
        ((com.tencent.mm.g.b.a.n)localObject).dCS = 1L;
        ((com.tencent.mm.g.b.a.n)localObject).dFt = i;
        ((com.tencent.mm.g.b.a.n)localObject).aHZ();
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
          String str = com.tencent.mm.m.g.ZY().getValue("ShowAPPSuggestion");
          if ((bs.isNullOrNil(str)) || (Integer.valueOf(str).intValue() != 1)) {
            ac.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[] { str });
          }
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[] { localException.getMessage() });
          if (paramView.Djh)
          {
            ac.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
            break label187;
          }
          ac.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
          paramView.Djh = true;
          if (System.currentTimeMillis() - paramView.Djk < 43200000L)
          {
            ac.d("MicroMsg.SuggestionAppListLogic", "not now");
            paramView.Djh = false;
            break label187;
          }
          com.tencent.mm.kernel.g.agS();
          paramView.Djk = com.tencent.mm.kernel.g.agR().agA().YH(352275);
          if (System.currentTimeMillis() - paramView.Djk < 43200000L)
          {
            ac.w("MicroMsg.SuggestionAppListLogic", "not now sp");
            paramView.Djh = false;
            break label187;
          }
          if (paramView.lang == null) {
            paramView.lang = ab.f(((Context)localObject).getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0));
          }
          paramView = new ag(paramView.lang, new LinkedList());
          com.tencent.mm.plugin.s.a.dnB();
          com.tencent.mm.pluginsdk.model.app.e.a(4, paramView);
        }
      }
      break label187;
      label529:
      if (w.xA(paramView)) {
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
    ac.i("MicroMsg.ChatFooter", "configPanel: %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.tzA), Boolean.valueOf(this.DuH), Boolean.valueOf(this.Duz) });
    int i;
    int j;
    label98:
    int k;
    if ((this.DuH) || (!this.Duz))
    {
      i = 1;
      if ((paramInt1 != 1) || (this.tzA)) {
        break label194;
      }
      j = 1;
      if ((paramInt1 == 1) || (!this.tzA)) {
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
            ac.i("MicroMsg.ChatFooter", "showSoftInput %b", new Object[] { Boolean.valueOf(bool) });
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
      this.tzA = paramBoolean;
      AppMethodBeat.o(163217);
      return;
      i = 0;
      break;
      j = 0;
      break label98;
      k = 0;
      break label113;
      this.DuC = paramInt1;
      break label135;
    }
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163215);
    ArrayList localArrayList = this.DtP.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163215);
    return localArrayList;
  }
  
  public String getAtSomebody()
  {
    return this.Dum.DxK;
  }
  
  public int getBarGroupHeight()
  {
    AppMethodBeat.i(31585);
    if (this.Dus == null) {
      this.Dus = findViewById(2131298090);
    }
    if (this.Dus != null)
    {
      i = this.Dus.getHeight();
      AppMethodBeat.o(31585);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131165299);
    AppMethodBeat.o(31585);
    return i;
  }
  
  public f getCallback()
  {
    return this.Dni;
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
    return this.DuG;
  }
  
  public x.a getIOnToDoBarCallback()
  {
    return this.DuP;
  }
  
  public int getInsertPos()
  {
    return this.Dum.DxL;
  }
  
  public boolean getIsVoiceInputPanleShow()
  {
    return this.Dpb;
  }
  
  public int getKeyBordHeightPX()
  {
    AppMethodBeat.i(31671);
    int i = y.iy(getContext());
    AppMethodBeat.o(31671);
    return i;
  }
  
  public String getLastContent()
  {
    return this.Dum.DxJ;
  }
  
  public long getLastQuoteMsgId()
  {
    AppMethodBeat.i(31612);
    if ((this.Duc.getTag() != null) && ((this.Duc.getTag() instanceof bo)))
    {
      long l = ((bo)this.Duc.getTag()).field_msgId;
      AppMethodBeat.o(31612);
      return l;
    }
    AppMethodBeat.o(31612);
    return 0L;
  }
  
  public String getLastText()
  {
    AppMethodBeat.i(31611);
    if (this.uyM == null)
    {
      AppMethodBeat.o(31611);
      return "";
    }
    String str = this.uyM.getText().toString();
    AppMethodBeat.o(31611);
    return str;
  }
  
  public int getMode()
  {
    return this.Duu;
  }
  
  public View getPanel()
  {
    return this.DtU;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(31613);
    int i = this.uyM.getSelectionStart();
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
    if (this.DuB == 0) {
      i = getHeight() - this.DuK;
    }
    for (;;)
    {
      AppMethodBeat.o(31684);
      return i;
      int j = getHeight() - this.DuK + getKeyBordHeightPX();
      i = j;
      if (this.DuO != null) {
        i = j - this.DuO.cSy();
      }
    }
  }
  
  public final boolean hideVKB()
  {
    AppMethodBeat.i(31659);
    if (getKeyBordHeightPX() / 2 <= getBottom())
    {
      boolean bool = bs.hideVKB(this);
      AppMethodBeat.o(31659);
      return bool;
    }
    AppMethodBeat.o(31659);
    return false;
  }
  
  public final void k(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(31582);
    if ((this.Duc.getTag() != null) && ((this.Duc.getTag() instanceof bo)) && (bs.av(paramLong, ((bo)this.Duc.getTag()).field_msgId))) {
      com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185798);
          if (!paramBoolean) {
            com.tencent.mm.ui.base.h.c(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(2131761359), "", true);
          }
          ChatFooter.this.eOm();
          AppMethodBeat.o(185798);
        }
      });
    }
    AppMethodBeat.o(31582);
  }
  
  public final HashMap<String, String> la(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31603);
    long l = System.currentTimeMillis();
    if (bs.isNullOrNil(paramString2))
    {
      if (this.Dum.DxM.containsKey(paramString1)) {
        this.Dum.DxM.remove(paramString1);
      }
      AppMethodBeat.o(31603);
      return null;
    }
    if ((!this.Dum.DxM.containsKey(paramString1)) || (((LinkedList)this.Dum.DxM.get(paramString1)).size() <= 0))
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
    ac.i("MicroMsg.ChatFooter", "after split @ :%s", new Object[] { localObject });
    if (((List)localObject).size() <= 0)
    {
      ((LinkedList)this.Dum.DxM.get(paramString1)).clear();
      AppMethodBeat.o(31603);
      return null;
    }
    paramString1 = (LinkedList)this.Dum.DxM.get(paramString1);
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      ac.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", new Object[] { Integer.valueOf(paramString1.size()) });
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
      ac.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", new Object[] { Integer.valueOf(paramString2.size()) });
      ((HashMap)localObject).put("atuserlist", "<![CDATA[" + bs.n(paramString2, ",") + "]]>");
      paramString1.clear();
      ac.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(31603);
      return localObject;
    }
    ac.w("MicroMsg.ChatFooter", "list is null or size 0");
    AppMethodBeat.o(31603);
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(31579);
    super.onAttachedToWindow();
    eOO();
    eON();
    Xo(getKeyBordHeightPX());
    AppMethodBeat.o(31579);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31643);
    super.onConfigurationChanged(paramConfiguration);
    if (com.tencent.mm.compatible.util.d.kZ(24)) {
      this.DuH = ((Activity)getContext()).isInMultiWindowMode();
    }
    if (paramConfiguration.orientation == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.Duz = bool;
      g(0, false, -1);
      eOO();
      ac.i("MicroMsg.ChatFooter", "onConfigurationChanged: %s, %s, %s", new Object[] { paramConfiguration, Boolean.valueOf(this.Duz), Boolean.valueOf(this.DuH) });
      Xo(getKeyBordHeightPX());
      AppMethodBeat.o(31643);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(31580);
    super.onDetachedFromWindow();
    this.fxG.close();
    this.DuD = null;
    this.DuE = false;
    AppMethodBeat.o(31580);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31669);
    ac.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", new Object[] { Integer.valueOf(View.MeasureSpec.getSize(paramInt2)), Integer.valueOf(getMeasuredHeight()) });
    super.onMeasure(paramInt1, paramInt2);
    ac.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    AppMethodBeat.o(31669);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(31577);
    ac.i("MicroMsg.ChatFooter", "onPause");
    this.DuA = false;
    if ((this.DuF == 48) && (this.DuB == 1) && (!this.DuN))
    {
      this.tzA = false;
      h(0, true, -1);
    }
    this.fxG.close();
    if (this.fWT != null) {
      this.fWT.onPause();
    }
    if ((this.Dpb) && (this.DoY != null)) {
      this.DoY.pause();
    }
    if (this.Dui != null) {
      this.Dui.onPause();
    }
    if (this.Dug != null) {
      this.Dug.hide();
    }
    if ((this.zWY != null) && (this.zWY.isShowing())) {
      this.zWY.dismiss();
    }
    eOQ();
    AppMethodBeat.o(31577);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31672);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ac.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(31672);
  }
  
  public void setAppPanelListener(AppPanel.a parama)
  {
    AppMethodBeat.i(31649);
    this.DtP.setAppPanelListener(parama);
    AppMethodBeat.o(31649);
  }
  
  public void setAppPanelTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(31595);
    if ((this.DtV == null) || (this.DtP == null))
    {
      AppMethodBeat.o(31595);
      return;
    }
    this.DtV.setText(paramCharSequence);
    if (!bs.aj(paramCharSequence)) {
      if (this.DtP.getVisibility() != 0) {
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
    if (this.DtV == null)
    {
      AppMethodBeat.o(31596);
      return;
    }
    if (TextUtils.isEmpty(this.DtV.getText()))
    {
      this.DtV.setVisibility(8);
      AppMethodBeat.o(31596);
      return;
    }
    if (paramBoolean)
    {
      localObject = this.DtV.getContext();
      i = this.DtU.getHeight();
      int j = getKeyBordHeightPX();
      int k = com.tencent.mm.cc.a.fromDPToPix((Context)localObject, 32);
      localObject = this.DtV.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (i - j + k);
        this.DtV.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    Object localObject = this.DtV;
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
    this.DtP.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163214);
  }
  
  public void setAppPanelVisible(int paramInt)
  {
    AppMethodBeat.i(31642);
    if (this.DtP != null) {
      this.DtP.setVisibility(paramInt);
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
    this.Dum.DxK = paramString;
  }
  
  public void setBottomPanelVisibility(int paramInt)
  {
    AppMethodBeat.i(31644);
    if (paramInt == 0)
    {
      this.DtU.setVisibility(paramInt);
      AppMethodBeat.o(31644);
      return;
    }
    g(0, true, -1);
    AppMethodBeat.o(31644);
  }
  
  public void setCattingRootLayoutId(int paramInt)
  {
    this.Dxh = null;
    this.Dxg = paramInt;
  }
  
  public void setDefaultSmileyByDetail(String paramString)
  {
    AppMethodBeat.i(31600);
    if (!bs.isNullOrNil(paramString))
    {
      if (this.fWT == null) {
        eOp();
      }
      this.fWT.setDefaultEmojiByDetail(paramString);
    }
    AppMethodBeat.o(31600);
  }
  
  @TargetApi(11)
  public void setEditTextOnDragListener(View.OnDragListener paramOnDragListener)
  {
    AppMethodBeat.i(31647);
    this.uyM.setOnDragListener(paramOnDragListener);
    AppMethodBeat.o(31647);
  }
  
  public void setExitType(int paramInt)
  {
    AppMethodBeat.i(185414);
    c.a locala = com.tencent.mm.plugin.transvoice.a.c.Akm;
    com.tencent.mm.plugin.transvoice.a.c.efd().setExitType(paramInt);
    AppMethodBeat.o(185414);
  }
  
  public void setFooterEventListener(b paramb)
  {
    this.Dui = paramb;
  }
  
  public void setFooterType(int paramInt)
  {
    AppMethodBeat.i(31576);
    this.BZU = paramInt;
    if (this.fWT != null) {
      this.fWT.setFooterType(paramInt);
    }
    AppMethodBeat.o(31576);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(31609);
    if (this.uyM != null) {
      this.uyM.setHint(paramString);
    }
    AppMethodBeat.o(31609);
  }
  
  public void setIOnTodoViewCallback(x.c paramc)
  {
    this.DuO = paramc;
  }
  
  public void setIgnoreScroll(Boolean paramBoolean)
  {
    AppMethodBeat.i(31661);
    this.DuN = paramBoolean.booleanValue();
    AppMethodBeat.o(31661);
  }
  
  public void setInsertPos(int paramInt)
  {
    this.Dum.DxL = paramInt;
  }
  
  public void setIsMultiWindow(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(31667);
    ac.i("MicroMsg.ChatFooter", "setIsMultiWindow: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.DuH != paramBoolean) {}
    for (;;)
    {
      this.DuH = paramBoolean;
      eOO();
      if (i != 0)
      {
        Xo(getKeyBordHeightPX());
        g(0, false, -1);
      }
      AppMethodBeat.o(31667);
      return;
      i = 0;
    }
  }
  
  public void setKeyboardShow(Boolean paramBoolean)
  {
    AppMethodBeat.i(31662);
    this.tzA = paramBoolean.booleanValue();
    AppMethodBeat.o(31662);
  }
  
  public void setLastContent(String paramString)
  {
    this.Dum.DxJ = paramString;
  }
  
  public void setLastQuoteMsgId(long paramLong)
  {
    AppMethodBeat.i(31605);
    if (paramLong != 0L)
    {
      bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramLong);
      if (((localbo.euk & 0x4) == 4) || (localbo.getType() == 10000))
      {
        ac.e("MicroMsg.ChatFooter", "msg(%s) is revoked!", new Object[] { localbo.getType() + "," + (localbo.euk & 0x4) });
        com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(2131761359), "", true);
        AppMethodBeat.o(31605);
        return;
      }
      this.Duc.setTag(localbo);
      AppMethodBeat.o(31605);
      return;
    }
    this.Duc.setTag(null);
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
    this.Duo = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    AppMethodBeat.i(31623);
    aT(paramInt, true);
    AppMethodBeat.o(31623);
  }
  
  public void setOnEditFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(31648);
    this.uyM.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(31648);
  }
  
  public void setOnFooterPanelSwitchListener(f paramf)
  {
    this.Duk = paramf;
  }
  
  public void setOnFooterSwitchListener(g paramg)
  {
    AppMethodBeat.i(31650);
    this.Duj = paramg;
    if (paramg == null)
    {
      AppMethodBeat.o(31650);
      return;
    }
    paramg = findViewById(2131298150);
    paramg.setVisibility(0);
    paramg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196156);
        if (ChatFooter.bh(ChatFooter.this) != null) {
          ChatFooter.bh(ChatFooter.this).vu(false);
        }
        AppMethodBeat.o(196156);
      }
    });
    AppMethodBeat.o(31650);
  }
  
  public void setRecordNormalWording(String paramString)
  {
    AppMethodBeat.i(31618);
    if ((paramString == null) || (this.Dur == null))
    {
      AppMethodBeat.o(31618);
      return;
    }
    this.Dur.setText(paramString);
    AppMethodBeat.o(31618);
  }
  
  public void setSetTolastCustomPage(boolean paramBoolean) {}
  
  public void setSmileyPanelCallback(f paramf)
  {
    AppMethodBeat.i(31592);
    this.Dni = paramf;
    if (this.fWT != null) {
      this.fWT.setCallback(paramf);
    }
    AppMethodBeat.o(31592);
  }
  
  public void setSmileyPanelCallback2(j paramj)
  {
    this.Dug.DyS = paramj;
  }
  
  public void setSwitchButtonMode(int paramInt)
  {
    AppMethodBeat.i(31651);
    if (paramInt == this.DwW)
    {
      AppMethodBeat.o(31651);
      return;
    }
    this.DwW = paramInt;
    ImageView localImageView1 = (ImageView)findViewById(2131305574);
    ImageView localImageView2 = (ImageView)findViewById(2131303025);
    if (this.DwW == 1)
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
  
  public void setTipsShowCallback(c paramc)
  {
    this.DuS = paramc;
  }
  
  @TargetApi(11)
  public void setToSendTextColor(final boolean paramBoolean)
  {
    AppMethodBeat.i(31652);
    if (com.tencent.mm.compatible.util.d.kZ(11))
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
      this.uyM.setTextColor(getResources().getColor(2131100636));
      AppMethodBeat.o(31652);
      return;
    }
    this.uyM.setTextColor(getResources().getColor(2131100482));
    vp(false);
    AppMethodBeat.o(31652);
  }
  
  public void setUserName(String paramString)
  {
    AppMethodBeat.i(31682);
    this.DtO = paramString;
    if (this.fWT != null) {
      this.fWT.setTalkerName(this.DtO);
    }
    if (this.DtP != null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.ChatFooter", "setusername: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (this.DtP == null) {
        break label167;
      }
      if ((!w.xr(this.DtO)) && (!w.xj(this.DtO))) {
        break;
      }
      this.DtP.setServiceShowFlag(0);
      AppMethodBeat.o(31682);
      return;
    }
    if (w.wH(this.DtO))
    {
      this.DtP.setServiceShowFlag(4);
      AppMethodBeat.o(31682);
      return;
    }
    if (w.sQ(this.DtO))
    {
      this.DtP.setServiceShowFlag(2);
      AppMethodBeat.o(31682);
      return;
    }
    this.DtP.setServiceShowFlag(1);
    label167:
    AppMethodBeat.o(31682);
  }
  
  public void setVoice2txtCountDown(int paramInt)
  {
    AppMethodBeat.i(31619);
    if (-1 == paramInt)
    {
      this.Dvf.setVisibility(0);
      this.Dvh.setVisibility(8);
      AppMethodBeat.o(31619);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 10))
    {
      if (8 == this.Dvh.getVisibility())
      {
        this.Dvf.setVisibility(8);
        this.Dvh.setVisibility(0);
      }
      if (this.Dvh != null) {
        this.Dvh.setImageResource(this.DwH[paramInt]);
      }
    }
    AppMethodBeat.o(31619);
  }
  
  public void setVoiceInputShowCallback(d paramd)
  {
    this.DuT = paramd;
  }
  
  public void setVoiceReactArea(int paramInt)
  {
    AppMethodBeat.i(185401);
    if (this.DvE)
    {
      setNewVoice2TxtCountDown(paramInt);
      AppMethodBeat.o(185401);
      return;
    }
    if (paramInt < 10)
    {
      if (this.Duv)
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
    this.DtQ = ((TextView)this.ifK.findViewById(2131298212));
    this.uyM.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(31646);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(31656);
    if ((this.DuW != null) && (this.DuW.isSupportNavigationSwipeBack()) && (this.DuW.getSwipeBackLayout() != null)) {
      this.DuW.getSwipeBackLayout().setOnceDisEnableGesture(true);
    }
    if (!eOJ())
    {
      g(1, true, -1);
      AppMethodBeat.o(31656);
      return;
    }
    ac.i("changelcai", "isScrolling!! pass this event!");
    AppMethodBeat.o(31656);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(31670);
    ac.i("MicroMsg.ChatFooter", "onKeyboardHeightChanged: %s, %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(this.DuF) });
    if (!this.DuI)
    {
      AppMethodBeat.o(31670);
      return;
    }
    int i;
    if ((this.DvE) && (this.DvG != null) && (this.DvG.isShowing()))
    {
      Object localObject;
      if (paramInt <= 0)
      {
        this.DvK.setCursorVisible(false);
        this.tzA = false;
        this.DvU.animate().translationY(0.0F).setDuration(200L).start();
        this.DvJ.animate().translationY(0.0F).setDuration(200L).start();
        this.DvM.animate().translationY(0.0F).setDuration(200L).start();
        this.DvP.animate().translationY(0.0F).setDuration(200L).start();
        if (this.DvJ.getHeight() < this.DwR)
        {
          localObject = ValueAnimator.ofInt(new int[] { this.DvJ.getHeight(), this.DwR }).setDuration(200L);
          ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              AppMethodBeat.i(196159);
              int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
              ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).height = i;
              ChatFooter.az(ChatFooter.this).requestLayout();
              AppMethodBeat.o(196159);
            }
          });
          ((ValueAnimator)localObject).start();
          AppMethodBeat.o(31670);
        }
      }
      else
      {
        this.DvK.setCursorVisible(true);
        this.tzA = true;
        ac.d("MicroMsg.ChatFooter", "height:%s, WeUIToolHelper.getDisplayRealSize(getContext()).y - newVoice2txtOpeArea.getBottom():%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.ui.ap.cl(getContext()).y - this.DvU.getBottom()) });
        i = com.tencent.mm.ui.ap.cl(getContext()).y;
        localObject = new int[2];
        this.DvU.getLocationOnScreen((int[])localObject);
        j = localObject[1];
        int k = this.DvU.getHeight();
        int m = com.tencent.mm.ui.ap.ej(getContext());
        this.DvU.animate().translationY(-(paramInt - (i - (j + k)) + m)).setDuration(200L).start();
        paramInt = i - (this.DvU.getHeight() + paramInt) - com.tencent.mm.ui.ao.fromDPToPix(getContext(), 24);
        i = this.DvJ.getHeight() + this.DvM.getHeight() + com.tencent.mm.ui.ao.fromDPToPix(getContext(), 48);
        ac.d("MicroMsg.ChatFooter", "leftSpcaeDown:%s, editDown:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        this.DwQ = (paramInt - com.tencent.mm.ui.ao.fromDPToPix(getContext(), 52));
        this.DwR = this.DvJ.getHeight();
        localObject = new int[2];
        this.DvM.getLocationOnScreen((int[])localObject);
        j = localObject[1] + this.DvM.getHeight();
        if (j > paramInt)
        {
          j -= paramInt;
          if (i > paramInt)
          {
            k = this.DvJ.getLayoutParams().height;
            localObject = ValueAnimator.ofInt(new int[] { k, k - (i - paramInt) }).setDuration(200L);
            ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
              {
                AppMethodBeat.i(196160);
                int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
                ChatFooter.az(ChatFooter.this).getLayoutParams().height = i;
                ChatFooter.az(ChatFooter.this).requestLayout();
                AppMethodBeat.o(196160);
              }
            });
            ((ValueAnimator)localObject).start();
          }
          this.DvJ.animate().translationY(-j).setDuration(200L).start();
          this.DvM.animate().translationY(-j).setDuration(200L).start();
          this.DvP.animate().translationY(-j).setDuration(200L).start();
        }
      }
      AppMethodBeat.o(31670);
      return;
    }
    if ((!this.DuH) && (this.Duz))
    {
      if (this.DuJ == paramBoolean) {
        break label782;
      }
      i = 1;
      this.DuJ = paramBoolean;
      if (paramInt <= 0) {
        break label842;
      }
      if (this.ngo == paramInt) {
        break label914;
      }
      this.ngo = paramInt;
      com.tencent.mm.compatible.util.i.A(getContext(), paramInt);
      Xo(paramInt);
    }
    label782:
    label914:
    for (paramInt = 1;; paramInt = 0)
    {
      if (!this.tzA)
      {
        h(1, true, -1);
        this.DuC = -1;
      }
      while ((paramInt == 0) && (i == 0))
      {
        this.tzA = true;
        if (this.Dui != null) {
          this.Dui.nU(this.tzA);
        }
        AppMethodBeat.o(31670);
        return;
        i = 0;
        break;
      }
      this.DuG = this.ngo;
      i = this.DuG;
      if (this.DuO == null) {}
      for (paramInt = j;; paramInt = this.DuO.cSy())
      {
        b(i, true, 1, paramInt);
        break;
      }
      label842:
      if (this.tzA)
      {
        if (this.DuC == -1) {
          break label904;
        }
        h(this.DuC, true, -1);
        this.DuC = -1;
      }
      for (;;)
      {
        if (this.DuB == 1)
        {
          ac.i("MicroMsg.ChatFooter", "keyboard not open");
          h(0, true, -1);
        }
        this.tzA = false;
        break;
        h(0, true, -1);
      }
    }
  }
  
  public final void vg(boolean paramBoolean)
  {
    AppMethodBeat.i(31633);
    this.DtP.vg(paramBoolean);
    AppMethodBeat.o(31633);
  }
  
  public final void vh(boolean paramBoolean)
  {
    AppMethodBeat.i(31634);
    this.DtP.vh(paramBoolean);
    AppMethodBeat.o(31634);
  }
  
  public final void vp(boolean paramBoolean)
  {
    AppMethodBeat.i(31588);
    ac.i("MicroMsg.ChatFooter", "pureForcusEdtChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.uyM });
    if (this.uyM == null)
    {
      AppMethodBeat.o(31588);
      return;
    }
    if (paramBoolean)
    {
      this.uyM.requestFocus();
      AppMethodBeat.o(31588);
      return;
    }
    this.uyM.clearFocus();
    AppMethodBeat.o(31588);
  }
  
  public final void vr(boolean paramBoolean)
  {
    AppMethodBeat.i(31654);
    ac.i("MicroMsg.ChatFooter", "withoutLastText: ");
    hideVKB();
    vp(paramBoolean);
    AppMethodBeat.o(31654);
  }
  
  public final void vt(boolean paramBoolean)
  {
    AppMethodBeat.i(163220);
    if (this.DtW == null)
    {
      ac.e("MicroMsg.ChatFooter", "mAttachButton is null");
      AppMethodBeat.o(163220);
      return;
    }
    if (this.DtX != null) {
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
        } while ((locala.DtB != 1) || (aHw(locala.DtA)));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.DtX.setVisibility(0);
        AppMethodBeat.o(163220);
        return;
      }
      this.DtX.setVisibility(8);
      AppMethodBeat.o(163220);
      return;
    }
  }
  
  public final void w(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(31607);
    if (cSw())
    {
      ac.i("MicroMsg.ChatFooter", "setLastText() isBackFromGroupSolitatire");
      AppMethodBeat.o(31607);
      return;
    }
    if ((paramBoolean) && ((paramString == null) || (paramString.length() == 0) || (this.uyM == null)))
    {
      this.uyM.setText("");
      eOl();
      AppMethodBeat.o(31607);
      return;
    }
    this.Dun = true;
    this.uyM.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), paramString, this.uyM.getTextSize()));
    this.Dun = false;
    if ((paramInt < 0) || (paramInt > this.uyM.getText().length()))
    {
      this.uyM.setSelection(this.uyM.getText().length());
      AppMethodBeat.o(31607);
      return;
    }
    this.uyM.setSelection(paramInt);
    AppMethodBeat.o(31607);
  }
  
  public static final class a
  {
    public String DxJ;
    String DxK;
    int DxL;
    HashMap<String, LinkedList<HashMap<String, String>>> DxM;
    
    private a()
    {
      AppMethodBeat.i(31558);
      this.DxM = new HashMap();
      AppMethodBeat.o(31558);
    }
  }
  
  public static abstract interface b
  {
    public abstract com.tencent.mm.ui.chatting.h.b ePn();
    
    public abstract String getTalkerUserName();
  }
  
  public static abstract interface c
  {
    public abstract void a(Boolean paramBoolean1, Boolean paramBoolean2);
    
    public abstract void b(Boolean paramBoolean1, Boolean paramBoolean2);
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
      DxN = new e("MODE_VOICE", 0);
      DxO = new e("MODE_CANCEL", 1);
      DxP = new e("MODE_TRANS", 2);
      DxQ = new e[] { DxN, DxO, DxP };
      AppMethodBeat.o(185398);
    }
    
    private e() {}
  }
  
  public static abstract interface f
  {
    public abstract void jc(int paramInt1, int paramInt2);
  }
  
  public static abstract interface g
  {
    public abstract boolean vu(boolean paramBoolean);
  }
  
  public static enum h
  {
    static
    {
      AppMethodBeat.i(185821);
      DxR = new h("SendVoice", 0);
      DxS = new h("StopRecord", 1);
      DxT = new h("Reset", 2);
      DxU = new h("Cancel", 3);
      DxV = new h("Pause", 4);
      DxW = new h("Error", 5);
      DxX = new h[] { DxR, DxS, DxT, DxU, DxV, DxW };
      AppMethodBeat.o(185821);
    }
    
    private h() {}
  }
  
  public final class i
    implements TextWatcher
  {
    TextWatcher DxY;
    private boolean DxZ;
    private boolean Dya;
    
    public i(TextWatcher paramTextWatcher)
    {
      AppMethodBeat.i(31559);
      this.DxZ = false;
      this.Dya = com.tencent.mm.compatible.util.d.la(11);
      this.DxY = paramTextWatcher;
      AppMethodBeat.o(31559);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      boolean bool = true;
      AppMethodBeat.i(31560);
      if ((ChatFooter.j(ChatFooter.this)) && (this.DxZ) && (paramEditable.length() > 0))
      {
        this.DxZ = false;
        ChatFooter.d(ChatFooter.this).setText(paramEditable.subSequence(0, paramEditable.length() - 1));
        if (ChatFooter.d(ChatFooter.this).length() > 0)
        {
          ChatFooter.k(ChatFooter.this).performClick();
          ac.i("MicroMsg.ChatFooter", "enter button, do send");
        }
        ac.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        AppMethodBeat.o(31560);
        return;
      }
      this.DxY.afterTextChanged(paramEditable);
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
        ac.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
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
      this.DxY.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      ac.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
      AppMethodBeat.o(31561);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(31562);
      if ((ChatFooter.j(ChatFooter.this)) && (paramInt2 == 0) && (paramInt1 == paramCharSequence.length() - 1) && (paramInt3 == 1) && (paramCharSequence.charAt(paramCharSequence.length() - 1) == '\n'))
      {
        ac.i("MicroMsg.ChatFooter", "text changed, enter button");
        this.DxZ = true;
        AppMethodBeat.o(31562);
        return;
      }
      this.DxY.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      ChatFooter.this.DuR.dDb += 1L;
      ChatFooter.this.DuR.PU();
      if (ChatFooter.this.DuR.dCY == 0L) {
        ChatFooter.this.DuR.PT();
      }
      AppMethodBeat.o(31562);
    }
  }
  
  static enum j
  {
    static
    {
      AppMethodBeat.i(31565);
      Dyb = new j("MODE_INVALID", 0);
      Dyc = new j("MODE_BLUR", 1);
      Dyd = new j("MODE_NORMAL", 2);
      Dye = new j[] { Dyb, Dyc, Dyd };
      AppMethodBeat.o(31565);
    }
    
    private j() {}
  }
  
  static enum k
  {
    static
    {
      AppMethodBeat.i(31568);
      Dyf = new k("MODE_INVALID", 0);
      Dyg = new k("MODE_TRANS", 1);
      Dyh = new k("MODE_CANCEL", 2);
      Dyi = new k[] { Dyf, Dyg, Dyh };
      AppMethodBeat.o(31568);
    }
    
    private k() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter
 * JD-Core Version:    0.7.0.1
 */