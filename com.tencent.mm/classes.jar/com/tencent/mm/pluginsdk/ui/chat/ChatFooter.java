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
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
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
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.ui.d.b;
import com.tencent.mm.plugin.groupsolitaire.ui.d.c;
import com.tencent.mm.plugin.groupsolitaire.ui.d.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.4;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.a;
import com.tencent.mm.plugin.transvoice.ui.SoundWaveView;
import com.tencent.mm.plugin.transvoice.ui.SoundWaveView.d;
import com.tencent.mm.plugin.transvoice.ui.b.d;
import com.tencent.mm.pluginsdk.model.app.af;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.chatting.d.z.a;
import com.tencent.mm.ui.chatting.d.z.c;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
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
  private static int Faj;
  private static final int[] Fcd;
  private static final int[] Fce;
  public static final String Fco;
  private static int count;
  private final long ANIMATION_DURATION;
  private int BBA;
  com.tencent.mm.plugin.transvoice.a.b BDA;
  private String BDF;
  private int BDG;
  private av BDH;
  private boolean BDI;
  private com.tencent.mm.sdk.platformtools.ap BDK;
  private com.tencent.mm.modelvoiceaddr.b.b BDT;
  private List<String> BDU;
  private int BFy;
  public o BoC;
  private TextView BoD;
  private ImageView BoE;
  public View BoF;
  private int DCQ;
  f ESn;
  public n EUc;
  public boolean EUf;
  public String EYT;
  public AppPanel EYU;
  public TextView EYV;
  private Button EYW;
  public ImageButton EYX;
  private View EYY;
  public ChatFooterBottom EYZ;
  private int EZA;
  private boolean EZB;
  private boolean EZC;
  private boolean EZD;
  public boolean EZE;
  public boolean EZF;
  private boolean EZG;
  private boolean EZH;
  public int EZI;
  private int EZJ;
  private ChattingScrollLayout EZK;
  private boolean EZL;
  private int EZM;
  private int EZN;
  private boolean EZO;
  private boolean EZP;
  private int EZQ;
  private boolean EZR;
  private int EZS;
  private int EZT;
  private int EZU;
  private int EZV;
  private boolean EZW;
  private z.c EZX;
  private z.a EZY;
  private d.c EZZ;
  private TextView EZa;
  public ImageButton EZb;
  public ImageView EZc;
  public ImageButton EZd;
  public View EZe;
  private com.tencent.mm.ui.widget.a.d EZf;
  public LinearLayout EZg;
  public RelativeLayout EZh;
  private TextView EZi;
  private WeImageView EZj;
  private i EZk;
  public m EZl;
  private com.tencent.mm.plugin.groupsolitaire.ui.d EZm;
  private b EZn;
  private g EZo;
  private f EZp;
  private ClipboardManager EZq;
  public final a EZr;
  public boolean EZs;
  private boolean EZt;
  public boolean EZu;
  private ImageView EZv;
  public ViewGroup EZw;
  private TextView EZx;
  private View EZy;
  private InputMethodManager EZz;
  private TextView FaA;
  private View FaB;
  private BlurView FaC;
  private com.tencent.mm.plugin.transvoice.ui.b FaD;
  private com.tencent.mm.plugin.transvoice.a.a FaE;
  private com.tencent.mm.modelvoiceaddr.h FaF;
  public o FaG;
  private com.tencent.mm.plugin.transvoice.a.c FaH;
  private ChatFooter.l FaI;
  private j FaJ;
  private ChatFooter.k FaK;
  private boolean FaL;
  private boolean FaM;
  public boolean FaN;
  private float FaO;
  private o FaP;
  private View FaQ;
  private View FaR;
  private ViewGroup FaS;
  private EditText FaT;
  private SoundWaveView FaU;
  private ImageView FaV;
  private ViewGroup FaW;
  private TextView FaX;
  private WeImageView FaY;
  public LanguageChoiceLayout FaZ;
  com.tencent.mm.g.b.a.d Faa;
  public c Fab;
  public d Fac;
  private m.a Fad;
  private boolean Fae;
  public MMFragment Faf;
  public b Fag;
  private Animation Fah;
  private Animation Fai;
  public ViewGroup Fak;
  private View Fal;
  private BlurView Fam;
  private View Fan;
  private View Fao;
  private ImageView Fap;
  private ImageView Faq;
  private View Far;
  private TextView Fas;
  private ImageView Fat;
  private View Fau;
  private View Fav;
  private WeImageView Faw;
  private TextView Fax;
  private View Fay;
  private WeImageView Faz;
  private int FbA;
  private boolean FbB;
  private ChatFooterPanel.a FbC;
  private AppPanel.b FbD;
  private b FbE;
  public i FbF;
  private int FbG;
  private boolean FbH;
  private int FbI;
  private TextWatcher FbJ;
  ValueAnimator FbK;
  ValueAnimator FbL;
  ValueAnimator FbM;
  ValueAnimator FbN;
  ValueAnimator FbO;
  ValueAnimator.AnimatorUpdateListener FbP;
  private int[] FbQ;
  private final int FbR;
  private final int FbS;
  private final int FbT;
  private final int FbU;
  private final int FbV;
  private final int FbW;
  private final float FbX;
  private int FbY;
  private int FbZ;
  private TextView Fba;
  private ViewGroup Fbb;
  private TextView Fbc;
  private ViewGroup Fbd;
  private ViewGroup Fbe;
  private View Fbf;
  private View Fbg;
  private WeImageView Fbh;
  private WeImageView Fbi;
  private View Fbj;
  private View Fbk;
  private ViewGroup Fbl;
  private View Fbm;
  private View Fbn;
  private WeImageView Fbo;
  private WeImageView Fbp;
  private View Fbq;
  private View Fbr;
  private WeImageView Fbs;
  private ViewGroup Fbt;
  private View Fbu;
  private View Fbv;
  private View Fbw;
  private WeImageView Fbx;
  private View Fby;
  private int Fbz;
  private int FcA;
  e FcB;
  e FcC;
  private Map<Integer, String> FcD;
  private boolean FcE;
  private int Fca;
  private int Fcb;
  private int Fcc;
  private int Fcf;
  private boolean Fcg;
  private final int Fch;
  private final int Fci;
  private volatile boolean Fcj;
  private com.tencent.mm.sdk.platformtools.ap Fck;
  private boolean Fcl;
  private int Fcm;
  private boolean Fcn;
  private int Fcp;
  private View Fcq;
  private int Fcr;
  private int Fcs;
  private int Fct;
  private int Fcu;
  private int Fcv;
  private int Fcw;
  private Runnable Fcx;
  private Runnable Fcy;
  private int Fcz;
  private Activity activity;
  private String dyU;
  private com.tencent.mm.ui.tools.h fQT;
  private boolean gkZ;
  public Button gmY;
  private ViewGroup iLQ;
  private View ize;
  public final com.tencent.mm.sdk.platformtools.ap mHandler;
  private int maxHeight;
  private int nGK;
  public ChatFooterPanel pWJ;
  private final com.tencent.mm.sdk.platformtools.ap ptC;
  private boolean ptn;
  public View rxh;
  private ImageView rxi;
  public View rxj;
  public View rxk;
  private String toUser;
  public boolean uCj;
  public MMEditText vBp;
  
  static
  {
    AppMethodBeat.i(31717);
    count = 0;
    Fcd = new int[] { 0, 15, 30, 45, 60, 75, 90, 95, 100 };
    Fce = new int[] { 2131689547, 2131689548, 2131689549, 2131689550, 2131689551, 2131689552, 2131689553, 2131689554 };
    Fco = aj.getPackageName() + "chat_footer_sp";
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
    this.ize = null;
    this.vBp = null;
    this.gmY = null;
    this.EYV = null;
    this.EZo = null;
    this.EZp = null;
    this.EZq = null;
    this.EZr = new a((byte)0);
    this.EZs = false;
    this.EZt = false;
    this.EZu = false;
    this.ptn = false;
    this.EZC = false;
    this.EZD = false;
    this.EZE = false;
    this.EUf = false;
    this.EZF = false;
    this.EZG = true;
    this.EZH = false;
    this.EZI = 0;
    this.EZJ = -1;
    this.EZN = 0;
    this.uCj = false;
    this.EZO = false;
    this.EZP = true;
    this.EZQ = 0;
    this.EZR = false;
    this.EZW = false;
    this.EZX = null;
    this.EZY = new z.a()
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
    this.EZZ = new d.c()
    {
      public final int dbF()
      {
        AppMethodBeat.i(185759);
        if (ChatFooter.b(ChatFooter.this) != null)
        {
          int i = ChatFooter.b(ChatFooter.this).dbF();
          AppMethodBeat.o(185759);
          return i;
        }
        AppMethodBeat.o(185759);
        return 0;
      }
      
      public final boolean dbG()
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
    this.Faa = new com.tencent.mm.g.b.a.d();
    this.Fad = new m.a()
    {
      public final void clear()
      {
        AppMethodBeat.i(185778);
        ChatFooter.this.dbH();
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
    this.Fae = false;
    this.gkZ = false;
    paramAttributeSet = com.tencent.mm.plugin.transvoice.a.c.BBY;
    this.FaH = com.tencent.mm.plugin.transvoice.a.c.eru();
    this.FaI = ChatFooter.l.Fds;
    this.FaJ = j.Fdk;
    this.FaK = ChatFooter.k.Fdo;
    this.FaL = false;
    this.FaM = false;
    this.FaN = false;
    this.FaO = 0.5F;
    this.FbB = true;
    this.FbC = new ChatFooterPanel.a()
    {
      public final void aoO()
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
        ChatFooter.this.Faa.dPS -= 1L;
        AppMethodBeat.o(185771);
      }
      
      public final void aoP()
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
          ChatFooter.d(ChatFooter.this).aXD(paramAnonymousString);
          ChatFooter.this.Faa.dPS += 1L;
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
      
      public final void dU(boolean paramAnonymousBoolean)
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
    this.FbD = new AppPanel.b()
    {
      public final void fdg()
      {
        AppMethodBeat.i(185773);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ChatFooter.e(ChatFooter.this), "android.permission.RECORD_AUDIO", 80, "", "");
        ad.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), ChatFooter.e(ChatFooter.this) });
        if (!bool)
        {
          AppMethodBeat.o(185773);
          return;
        }
        int i = ba.aiU().aEN();
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
    this.FbE = new b()
    {
      public final com.tencent.mm.ui.chatting.i.b feo()
      {
        return null;
      }
      
      public final com.tencent.mm.ui.chatting.e.a fep()
      {
        return null;
      }
      
      public final String getTalkerUserName()
      {
        AppMethodBeat.i(193470);
        if (ChatFooter.f(ChatFooter.this) == null)
        {
          str = ChatFooter.av(ChatFooter.this);
          AppMethodBeat.o(193470);
          return str;
        }
        String str = ChatFooter.f(ChatFooter.this).getTalkerUserName();
        AppMethodBeat.o(193470);
        return str;
      }
    };
    this.ptC = new com.tencent.mm.sdk.platformtools.ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(193475);
        super.handleMessage(paramAnonymousMessage);
        ad.d("MicroMsg.ChatFooter", "pennqin, dismiss window by too short.");
        ChatFooter.x(ChatFooter.this).setBackgroundResource(2131232725);
        ChatFooter.x(ChatFooter.this).setEnabled(true);
        if (ChatFooter.this.FaN)
        {
          ChatFooter.ay(ChatFooter.this);
          t.w(ChatFooter.this.getContext(), ChatFooter.this.getContext().getResources().getString(2131757096), 2131691379);
          AppMethodBeat.o(193475);
          return;
        }
        if (ChatFooter.L(ChatFooter.this) != null) {
          ChatFooter.L(ChatFooter.this).dismiss();
        }
        AppMethodBeat.o(193475);
      }
    };
    this.FbG = 0;
    this.FbH = false;
    this.FbI = 1;
    this.FbJ = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(193476);
        int i;
        int j;
        int m;
        int k;
        if (paramAnonymousEditable != null)
        {
          i = ChatFooter.az(ChatFooter.this).getWidth();
          j = ChatFooter.aA(ChatFooter.this).getLineCount();
          m = j - ChatFooter.aB(ChatFooter.this);
          if ((m != 0) && (ChatFooter.this.FcB == ChatFooter.e.FcY) && (i == ChatFooter.aC(ChatFooter.this)))
          {
            i = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), 5);
            k = ChatFooter.aA(ChatFooter.this).getLineHeight() * m;
            if (m <= 0) {
              break label251;
            }
            m = ChatFooter.az(ChatFooter.this).getHeight();
            if (!ChatFooter.this.uCj) {
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
          if (1 == ChatFooter.z(ChatFooter.this).BBW) {
            ChatFooter.z(ChatFooter.this).BBV = 1;
          }
          AppMethodBeat.o(193476);
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
    this.FbK = ValueAnimator.ofInt(new int[] { 250, 960 }).setDuration(200L);
    this.FbL = ValueAnimator.ofInt(new int[] { 40, 800 }).setDuration(200L);
    this.FbM = ValueAnimator.ofInt(new int[] { 72, 0 }).setDuration(200L);
    this.FbN = ValueAnimator.ofInt(new int[] { 22, 0 }).setDuration(200L);
    this.FbO = ValueAnimator.ofInt(new int[] { 8, 0 }).setDuration(200L);
    this.FbP = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(31546);
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)ChatFooter.bf(ChatFooter.this).getLayoutParams();
        FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)ChatFooter.bg(ChatFooter.this).getLayoutParams();
        if (ChatFooter.this.FbK == paramAnonymousValueAnimator)
        {
          localLayoutParams1.width = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          localLayoutParams2.width = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        }
        for (;;)
        {
          ChatFooter.bf(ChatFooter.this).setLayoutParams(localLayoutParams1);
          ChatFooter.bg(ChatFooter.this).setLayoutParams(localLayoutParams2);
          AppMethodBeat.o(31546);
          return;
          if (ChatFooter.this.FbL == paramAnonymousValueAnimator)
          {
            localLayoutParams1.height = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.height = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.FbM == paramAnonymousValueAnimator)
          {
            localLayoutParams1.topMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.topMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.FbN == paramAnonymousValueAnimator)
          {
            localLayoutParams1.rightMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.rightMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.FbO == paramAnonymousValueAnimator)
          {
            localLayoutParams1.bottomMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.bottomMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        }
      }
    };
    this.FbQ = new int[] { 2131689996, 2131689997, 2131689998, 2131689999, 2131690000, 2131690001, 2131690002, 2131690003, 2131690004, 2131690005 };
    this.ANIMATION_DURATION = 200L;
    this.FbR = 60;
    this.FbS = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 114);
    this.FbT = (ar.ci(getContext()).x - com.tencent.mm.ui.aq.fromDPToPix(getContext(), 32));
    this.FbU = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 92);
    this.FbV = Math.min(com.tencent.mm.ui.aq.fromDPToPix(getContext(), 320), ar.ci(getContext()).x - com.tencent.mm.ui.aq.fromDPToPix(getContext(), 32));
    this.FbW = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 176);
    this.FbX = (com.tencent.mm.ui.aq.fromDPToPix(getContext(), 160) / 50.0F);
    this.FbY = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 114);
    this.maxHeight = 0;
    this.FbZ = 0;
    this.Fca = 0;
    this.BFy = 0;
    this.Fcb = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 176);
    this.Fcc = 60;
    this.Fcf = 0;
    this.Fcg = false;
    this.Fch = 4097;
    this.Fci = 4098;
    this.Fck = new com.tencent.mm.sdk.platformtools.ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(193492);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(193492);
          return;
          ChatFooter.h(ChatFooter.this, true);
          paramAnonymousMessage = ChatFooter.bs(ChatFooter.this).getLayoutParams();
          int i = ChatFooter.bs(ChatFooter.this).getBottom() - ChatFooter.bs(ChatFooter.this).getTop();
          if (ChatFooter.this.fdK())
          {
            if (ChatFooter.v(ChatFooter.this) != null) {
              ChatFooter.v(ChatFooter.this).setVisibility(8);
            }
            ChatFooter.this.setAppPanelVisible(8);
            ChatFooter.bs(ChatFooter.this).setVisibility(4);
          }
          if (i <= 3)
          {
            ChatFooter.h(ChatFooter.this, false);
            ChatFooter.bs(ChatFooter.this).setVisibility(4);
            ChatFooter.i(ChatFooter.this, ChatFooter.this.getKeyBordHeightPX());
            AppMethodBeat.o(193492);
            return;
          }
          paramAnonymousMessage.height = Math.max(i - 60, 1);
          ad.e("MicroMsg.ChatFooter", "mBottomPanelAnim:bottomPanel height:" + paramAnonymousMessage.height);
          ChatFooter.bs(ChatFooter.this).setLayoutParams(paramAnonymousMessage);
          ChatFooter.bt(ChatFooter.this);
        }
      }
    };
    this.Fcl = false;
    this.Fcm = 0;
    this.Fcn = false;
    this.Fcp = -1;
    this.Fcq = null;
    this.Fcr = com.tencent.mm.ui.aq.ay(getContext(), 2131165229);
    this.Fcs = com.tencent.mm.ui.aq.ay(getContext(), 2131165294);
    this.Fct = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 25);
    this.Fcu = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 55);
    this.Fcv = 0;
    this.Fcw = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 50);
    this.Fcx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193503);
        ChatFooter.this.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185380);
            if (ChatFooter.k.Fdq == ChatFooter.ai(ChatFooter.this))
            {
              ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764709));
              ChatFooter.al(ChatFooter.this);
            }
            for (;;)
            {
              ChatFooter.bv(ChatFooter.this);
              AppMethodBeat.o(185380);
              return;
              ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764713));
              ChatFooter.aj(ChatFooter.this);
            }
          }
        }, 100L);
        AppMethodBeat.o(193503);
      }
    };
    this.Fcy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193504);
        ChatFooter.H(ChatFooter.this).dismiss();
        AppMethodBeat.o(193504);
      }
    };
    this.Fcz = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 16);
    this.FcA = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 25);
    this.FcB = e.FcW;
    this.FcC = this.FcB;
    this.FcD = new HashMap();
    this.FcE = false;
    this.BDT = new com.tencent.mm.modelvoiceaddr.b.b();
    this.BDU = new ArrayList();
    this.BDF = "";
    this.BDG = 0;
    this.BDI = false;
    this.BBA = com.tencent.mm.modelvoiceaddr.g.iyi;
    long l = System.currentTimeMillis();
    this.EZz = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.ize = inflate(paramContext, 2131493397, this);
    this.vBp = ((MMEditText)this.ize.findViewById(2131298072));
    this.fQT = new com.tencent.mm.ui.tools.h((Activity)paramContext);
    this.fQT.KIP = this;
    this.EZq = ((ClipboardManager)paramContext.getApplicationContext().getSystemService("clipboard"));
    if (al.fxN()) {
      this.vBp.setImeOptions(268435456);
    }
    com.tencent.mm.ui.tools.b.c.d(this.vBp).aeU(bt.getInt(com.tencent.mm.n.g.acA().getValue("InputLimitSessionTextMsg"), 8192) * 2).a(null);
    this.vBp.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
    this.vBp.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(193511);
        ad.i("MicroMsg.ChatFooter", "onFocusChange: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(193511);
      }
    });
    if (Build.VERSION.SDK_INT == 28) {
      this.vBp.setBreakStrategy(1);
    }
    paramAttributeSet = new qp();
    paramAttributeSet.dFj.dFl = this.vBp;
    paramAttributeSet.dFj.dFk = new com.tencent.mm.pluginsdk.ui.a.a()
    {
      public final void aMD(final String paramAnonymousString)
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
    com.tencent.mm.sdk.b.a.IbL.l(paramAttributeSet);
    this.EZg = ((LinearLayout)this.ize.findViewById(2131305724));
    this.EZe = this.ize.findViewById(2131305739);
    this.EYZ = ((ChatFooterBottom)findViewById(2131298067));
    this.iLQ = ((ViewGroup)findViewById(2131297957));
    this.EYY = findViewById(2131298090);
    this.EZb = ((ImageButton)this.ize.findViewById(2131298054));
    this.EZc = ((ImageView)this.ize.findViewById(2131298055));
    this.gmY = ((Button)this.ize.findViewById(2131298168));
    this.EZh = ((RelativeLayout)this.ize.findViewById(2131302539));
    this.EZi = ((TextView)this.ize.findViewById(2131302537));
    this.EZj = ((WeImageView)this.ize.findViewById(2131302538));
    this.EZv = ((ImageView)this.ize.findViewById(2131308107));
    this.gmY.setTextSize(0, com.tencent.mm.cc.a.ay(paramContext, 2131165563) * com.tencent.mm.cc.a.ik(paramContext));
    this.EYW = ((Button)this.ize.findViewById(2131306529));
    this.EYX = ((ImageButton)findViewById(2131298149));
    og(false);
    fdT();
    this.EZk = new i(getContext(), getRootView(), this, new i.a()
    {
      public final void aNa(String paramAnonymousString)
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
    this.EZk.FdR = this;
    paramAttributeSet = getContext();
    getRootView();
    this.EZl = new m(paramAttributeSet);
    this.EZl.Fad = this.Fad;
    ad.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[] { Integer.valueOf(this.vBp.getImeOptions()) });
    this.vBp.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.vBp.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(185754);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$12", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        ChatFooter.this.setToSendTextColor(true);
        if (ChatFooter.l(ChatFooter.this) != null) {
          ChatFooter.l(ChatFooter.this).V(paramAnonymousMotionEvent);
        }
        ChatFooter.m(ChatFooter.this);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$12", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(185754);
        return false;
      }
    });
    this.vBp.setOnLongClickListener(new ChatFooter.5(this, paramContext));
    this.vBp.setCustomSelectionActionModeCallback(new ActionMode.Callback()
    {
      public final boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
      
      public final boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        AppMethodBeat.i(185756);
        paramAnonymousActionMode = com.tencent.mm.pluginsdk.i.a.faq();
        com.tencent.mm.plugin.report.service.g.yhR.n(1014L, 5L, 1L);
        com.tencent.mm.plugin.c.a.aVi();
        if (com.tencent.mm.plugin.c.a.z(paramAnonymousActionMode))
        {
          ad.i("MicroMsg.ChatFooter", "anti paste text %s", new Object[] { paramAnonymousActionMode });
          com.tencent.mm.plugin.report.service.g.yhR.n(1014L, 6L, 1L);
          if (paramAnonymousMenu.size() > 0)
          {
            paramAnonymousMenu.removeItem(16908322);
            if (com.tencent.mm.compatible.util.d.ly(23)) {
              paramAnonymousMenu.removeItem(16908340);
            }
          }
        }
        AppMethodBeat.o(185756);
        return true;
      }
      
      public final void onDestroyActionMode(ActionMode paramAnonymousActionMode) {}
      
      public final boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return false;
      }
    });
    this.gmY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        for (;;)
        {
          boolean bool;
          label299:
          try
          {
            AppMethodBeat.i(31499);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = ChatFooter.d(ChatFooter.this).getText().toString();
            ad.i("MicroMsg.ChatFooter", "send msg onClick");
            if ((paramAnonymousView.trim().length() == 0) && (paramAnonymousView.length() != 0))
            {
              ad.d("MicroMsg.ChatFooter", "empty message cant be sent");
              if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
                ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.h.l(ChatFooter.this.getContext(), 2131757154, 2131755906));
              }
              ChatFooter.this.fdQ();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
              break label369;
            }
            localObject = ChatFooter.p(ChatFooter.this);
            if (((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).uCB == null) {
              break label364;
            }
            bool = ((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).uCB.isShowing();
          }
          finally {}
          if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0) && (ChatFooter.l(ChatFooter.this) != null)) {
            ChatFooter.this.dbH();
          }
          ChatFooter.a(ChatFooter.this, paramAnonymousView.length());
          if (ChatFooter.a(ChatFooter.this, paramAnonymousView))
          {
            ad.i("MicroMsg.ChatFooter", "this is a quote msg");
            continue;
            label364:
            bool = false;
          }
          else
          {
            label369:
            while (!bool)
            {
              bool = false;
              break label299;
              if (ChatFooter.a(ChatFooter.this, paramAnonymousView, bool))
              {
                ad.i("MicroMsg.ChatFooter", "this is a group solitatire msg");
                break;
              }
              if ((ChatFooter.l(ChatFooter.this) == null) || (!ChatFooter.l(ChatFooter.this).apn(paramAnonymousView))) {
                break;
              }
              ChatFooter.q(ChatFooter.this);
              ChatFooter.d(ChatFooter.this).clearComposingText();
              break;
            }
            bool = true;
          }
        }
      }
    });
    if (al.fxM()) {}
    label2306:
    for (;;)
    {
      boolean bool = false;
      label1682:
      this.FaN = bool;
      this.FaO = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHk, 0.5F);
      ad.i("MicroMsg.ChatFooter", "isNewTrans2Txt:%s, transOperationAreaFactor:%s", new Object[] { Boolean.valueOf(this.FaN), Float.valueOf(this.FaO) });
      this.FaE = new com.tencent.mm.plugin.transvoice.a.a();
      if (this.FaN)
      {
        this.FbA = ((int)(com.tencent.mm.cc.a.ip(paramContext) * this.FaO));
        ad.d("MicroMsg.ChatFooter", "newVoice2txtVoiceModeChangeLine: %s, newVoice2txtTransModeChangeLine: %s.", new Object[] { Integer.valueOf(this.Fbz), Integer.valueOf(this.FbA) });
        this.EYW.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(31512);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$22", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            if (paramAnonymousView != ChatFooter.x(ChatFooter.this))
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$22", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(31512);
              return false;
            }
            if (ChatFooter.this.FcB == ChatFooter.e.FcW)
            {
              ChatFooter.b(ChatFooter.this, ar.ci(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(2131166976) - as.ej(paramContext));
              switch (paramAnonymousMotionEvent.getAction())
              {
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$22", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(31512);
              return true;
              ChatFooter.b(ChatFooter.this, ar.ci(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(2131166976) - as.ej(paramContext) + ChatFooter.y(ChatFooter.this));
              break;
              ChatFooter.z(ChatFooter.this).BBT = 1;
              paramAnonymousView = com.tencent.mm.ck.a.IRP;
              com.tencent.mm.ck.a.wU(false);
              ChatFooter.z(ChatFooter.this).mNe = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).BBG = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.z(ChatFooter.this).BBH = ((int)paramAnonymousMotionEvent.getRawY());
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
                ChatFooter.l(ChatFooter.this).dla();
              }
              ChatFooter.x(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757050));
              continue;
              if ((ChatFooter.C(ChatFooter.this) == null) || (!ChatFooter.C(ChatFooter.this).isShowing()))
              {
                ad.e("MicroMsg.NewVoice2txt", "window status err!!!");
              }
              else if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getX() < ChatFooter.x(ChatFooter.this).getWidth()) && (paramAnonymousMotionEvent.getRawY() > ChatFooter.D(ChatFooter.this)))
              {
                if (ChatFooter.this.FcB != ChatFooter.e.FcW)
                {
                  ChatFooter.this.FcC = ChatFooter.this.FcB;
                  ChatFooter.this.FcB = ChatFooter.e.FcW;
                  ChatFooter.E(ChatFooter.this);
                }
              }
              else if (paramAnonymousMotionEvent.getRawX() > ChatFooter.F(ChatFooter.this))
              {
                if (ChatFooter.e.FcY != ChatFooter.this.FcB)
                {
                  ChatFooter.this.FcC = ChatFooter.this.FcB;
                  ChatFooter.this.FcB = ChatFooter.e.FcY;
                  ChatFooter.E(ChatFooter.this);
                }
              }
              else if (ChatFooter.e.FcX != ChatFooter.this.FcB)
              {
                ChatFooter.this.FcC = ChatFooter.this.FcB;
                ChatFooter.this.FcB = ChatFooter.e.FcX;
                ChatFooter.E(ChatFooter.this);
                continue;
                ad.d("MicroMsg.NewVoice2txt", "begin finishCutShortSentence.");
                ChatFooter.B(ChatFooter.this).err();
                ad.d("MicroMsg.NewVoice2txt", "end finishCutShortSentence.");
                ChatFooter.z(ChatFooter.this).BBI = System.currentTimeMillis();
                ChatFooter.z(ChatFooter.this).BBJ = ((int)paramAnonymousMotionEvent.getRawX());
                ChatFooter.z(ChatFooter.this).BBK = ((int)paramAnonymousMotionEvent.getRawY());
                if ((ChatFooter.this.BDA != null) && (ChatFooter.G(ChatFooter.this)))
                {
                  ChatFooter.this.BDA.BBB = false;
                  paramAnonymousView = ChatFooter.this.BDA;
                  ad.d("MicroMsg.SceneVoiceInputAddr2", "reTrigger!!! canReTrigger: %s.", new Object[] { Boolean.valueOf(paramAnonymousView.BBC) });
                  if ((paramAnonymousView.BBC) && ((!((com.tencent.mm.modelvoiceaddr.c)paramAnonymousView.iyf).aNM()) || (!com.tencent.mm.kernel.g.aiU().a(paramAnonymousView.iyf, 0)))) {
                    paramAnonymousView.ert();
                  }
                }
                if ((ChatFooter.this.getContext() instanceof Activity)) {
                  ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                }
                ChatFooter.this.fdS();
              }
            }
          }
        });
        this.FbK.addUpdateListener(this.FbP);
        this.FbL.addUpdateListener(this.FbP);
        this.FbM.addUpdateListener(this.FbP);
        this.FbN.addUpdateListener(this.FbP);
        this.FbO.addUpdateListener(this.FbP);
      }
      for (;;)
      {
        this.EYX.setOnClickListener(new ChatFooter.14(this));
        fdp();
        this.EZb.setVisibility(0);
        this.EZb.setContentDescription(getContext().getString(2131757042));
        this.EZb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = -1;
            AppMethodBeat.i(31504);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
            localObject1 = ChatFooter.r(ChatFooter.this);
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
                  if (((a.a)localObject2).EYG == 1)
                  {
                    k = j;
                    if (!ChatFooter.aMZ(((a.a)localObject2).EYF))
                    {
                      localObject2 = ((a.a)localObject2).EYF;
                      ax.aQz("plus_uncertain_enter").edit().putBoolean((String)localObject2, true);
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
            localChatFooter.EZc.setVisibility(8);
            ((ImageButton)localObject1).setTag(Integer.valueOf(i));
            ChatFooter.this.fW(paramAnonymousView);
            if ((u.aBd().booleanValue()) && (ChatFooter.this.Fab != null))
            {
              paramAnonymousView = ChatFooter.this.Fab;
              localObject1 = Boolean.TRUE;
              paramAnonymousView.a((Boolean)localObject1, (Boolean)localObject1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(31504);
          }
        });
        ad.i("MicroMsg.ChatFooter", "[init]");
        this.EYY.setOnTouchListener(new ChatFooter.8(this));
        this.EZM = (((Activity)paramContext).getWindow().getAttributes().softInputMode & 0xF0);
        if ((this.EZM != 16) && (this.EZM != 48))
        {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1062, 8);
          if (this.EZM != 16) {
            this.EZM = 48;
          }
        }
        this.EZT = z.iI(paramContext);
        Zk(getKeyBordHeightPX());
        if (com.tencent.mm.compatible.util.d.ly(24)) {
          this.EZO = ((Activity)getContext()).isInMultiWindowMode();
        }
        fdo();
        this.EZj.setOnClickListener(new ChatFooter.9(this));
        ad.d("MicroMsg.ChatFooter", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(31573);
        return;
        if (aol()) {
          break;
        }
        paramAttributeSet = ac.iM(aj.getContext());
        if ((!paramAttributeSet.equals("zh_CN")) && (!paramAttributeSet.equals("zh_HK")) && (!paramAttributeSet.equals("zh_TW")) && (!paramAttributeSet.equals("en"))) {
          break;
        }
        if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.DEBUG))
        {
          bool = true;
          break label1682;
        }
        if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHj, 1)) {
          break label2306;
        }
        bool = true;
        break label1682;
        Faj = com.tencent.mm.cc.a.ip(paramContext) / 2 + com.tencent.mm.cc.a.fromDPToPix(paramContext, 30);
        this.FaD = new com.tencent.mm.plugin.transvoice.ui.b(paramContext);
        this.FaD.BDW = new b.d()
        {
          public final void aDg(final String paramAnonymousString)
          {
            AppMethodBeat.i(185764);
            ChatFooter.this.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(185762);
                ad.i("MicroMsg.ChatFooter", "onTxtMsgSend, msg is null or nil? %s.", new Object[] { Boolean.valueOf(bt.isNullOrNil(paramAnonymousString)) });
                if ((ChatFooter.l(ChatFooter.this) != null) && (!bt.isNullOrNil(paramAnonymousString))) {
                  ChatFooter.l(ChatFooter.this).apn(paramAnonymousString);
                }
                AppMethodBeat.o(185762);
              }
            }, 200L);
            AppMethodBeat.o(185764);
          }
          
          public final void aDh(String paramAnonymousString)
          {
            AppMethodBeat.i(185766);
            if (ChatFooter.l(ChatFooter.this) != null) {
              ChatFooter.l(ChatFooter.this).apo(paramAnonymousString);
            }
            AppMethodBeat.o(185766);
          }
          
          public final boolean b(String paramAnonymousString, Long paramAnonymousLong)
          {
            AppMethodBeat.i(185765);
            ad.i("MicroMsg.ChatFooter", "onVoiceMsgSend, fileName: %s.", new Object[] { paramAnonymousString });
            if (paramAnonymousLong != null) {}
            for (int i = paramAnonymousLong.intValue();; i = 0)
            {
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                boolean bool = ChatFooter.l(ChatFooter.this).dZ(paramAnonymousString, i);
                AppMethodBeat.o(185765);
                return bool;
              }
              AppMethodBeat.o(185765);
              return false;
            }
          }
          
          public final void erI()
          {
            AppMethodBeat.i(185763);
            if (ChatFooter.H(ChatFooter.this).isShowing()) {
              ChatFooter.H(ChatFooter.this).dismiss();
            }
            ChatFooter.I(ChatFooter.this);
            AppMethodBeat.o(185763);
          }
        };
        this.EYW.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(185767);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$24", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            if (paramAnonymousView != ChatFooter.x(ChatFooter.this))
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$24", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(185767);
              return false;
            }
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$24", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(185767);
              return true;
              ad.i("MicroMsg.RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[] { Integer.valueOf(ChatFooter.dhj()) });
              paramAnonymousView = com.tencent.mm.ck.a.IRP;
              com.tencent.mm.ck.a.wU(false);
              ChatFooter.z(ChatFooter.this).mNe = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).BBG = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.z(ChatFooter.this).BBH = ((int)paramAnonymousMotionEvent.getRawY());
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
              for (ChatFooter.z(ChatFooter.this).BBT = 1;; ChatFooter.z(ChatFooter.this).BBT = 0)
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
                  ChatFooter.l(ChatFooter.this).dla();
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
                  if (ChatFooter.W(ChatFooter.this) != ChatFooter.l.Fdt)
                  {
                    ad.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_1.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.Fdt);
                    if (ChatFooter.X(ChatFooter.this))
                    {
                      ChatFooter.Y(ChatFooter.this).animate().cancel();
                      ChatFooter.Z(ChatFooter.this).animate().cancel();
                      if (ChatFooter.j.Fdl == ChatFooter.Q(ChatFooter.this))
                      {
                        ChatFooter.N(ChatFooter.this).setAlpha(0.5F);
                        ChatFooter.N(ChatFooter.this).animate().alpha(1.0F).setDuration(300L).start();
                        ChatFooter.N(ChatFooter.this).acE(ChatFooter.this.getResources().getColor(2131101069)).F(ChatFooter.e(ChatFooter.this).getWindow().getDecorView().getBackground()).xN(true);
                      }
                      for (;;)
                      {
                        ChatFooter.H(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(200L).start();
                        ChatFooter.aa(ChatFooter.this).setVisibility(0);
                        ChatFooter.ab(ChatFooter.this).setVisibility(8);
                        ChatFooter.U(ChatFooter.this).setVisibility(8);
                        ChatFooter.a(ChatFooter.this, ChatFooter.k.Fdo);
                        ChatFooter.ac(ChatFooter.this);
                        break;
                        ChatFooter.T(ChatFooter.this).setBackgroundResource(2131234483);
                      }
                    }
                  }
                }
                else
                {
                  if (ChatFooter.W(ChatFooter.this) != ChatFooter.l.Fdu)
                  {
                    ad.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_2.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.Fdu);
                    if (!ChatFooter.X(ChatFooter.this)) {
                      ChatFooter.ad(ChatFooter.this);
                    }
                    ad.i("MicroMsg.RcdBtnEvent", "init rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.fem()) });
                    if (paramAnonymousMotionEvent.getRawX() > ChatFooter.fem())
                    {
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Fdp);
                      ad.i("MicroMsg.RcdBtnEvent", "init MODE_TRANS");
                      label1097:
                      if (ChatFooter.j.Fdl != ChatFooter.Q(ChatFooter.this)) {
                        break label1375;
                      }
                      ChatFooter.N(ChatFooter.this).acE(0).F(null).xN(false);
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
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Fdq);
                      ad.i("MicroMsg.RcdBtnEvent", "init MODE_CANCEL");
                      break label1097;
                      label1375:
                      ChatFooter.T(ChatFooter.this).setBackgroundColor(0);
                    }
                  }
                  if (ChatFooter.ah(ChatFooter.this))
                  {
                    ad.i("MicroMsg.RcdBtnEvent", "active rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.fem()) });
                    if ((paramAnonymousMotionEvent.getRawX() > ChatFooter.fem()) && (ChatFooter.k.Fdp != ChatFooter.ai(ChatFooter.this)))
                    {
                      ad.i("MicroMsg.RcdBtnEvent", "active MODE_TRANS.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Fdp);
                      ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764713));
                      ChatFooter.aj(ChatFooter.this);
                      ChatFooter.ak(ChatFooter.this);
                    }
                    else if ((paramAnonymousMotionEvent.getRawX() <= ChatFooter.fem()) && (ChatFooter.k.Fdq != ChatFooter.ai(ChatFooter.this)))
                    {
                      ad.i("MicroMsg.RcdBtnEvent", "active MODE_CANCEL.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Fdq);
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
                    ChatFooter.x(ChatFooter.this).setTextSize(0, com.tencent.mm.cc.a.ay(ChatFooter.this.getContext(), 2131165517) * com.tencent.mm.cc.a.ik(ChatFooter.this.getContext()));
                    ChatFooter.x(ChatFooter.this).setText(2131757078);
                    ChatFooter.ao(ChatFooter.this).setVisibility(0);
                    continue;
                    ChatFooter.B(ChatFooter.this).err();
                    if ((ChatFooter.this.getContext() instanceof Activity)) {
                      ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                    }
                    ChatFooter.z(ChatFooter.this).BBI = System.currentTimeMillis();
                    ChatFooter.z(ChatFooter.this).BBJ = ((int)paramAnonymousMotionEvent.getRawX());
                    ChatFooter.z(ChatFooter.this).BBK = ((int)paramAnonymousMotionEvent.getRawY());
                    ad.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.dhj()) });
                    ChatFooter.this.fdS();
                    ad.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.fen()) });
                  }
                }
              }
            }
          }
        });
        this.EYW.setOnKeyListener(new View.OnKeyListener()
        {
          public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(185768);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.mr(paramAnonymousInt);
            localb.bd(paramAnonymousKeyEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$25", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
            switch (paramAnonymousKeyEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$25", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(185768);
              return false;
              if (((paramAnonymousInt == 23) || (paramAnonymousInt == 66)) && (!ChatFooter.S(ChatFooter.this)) && (!ChatFooter.R(ChatFooter.this)))
              {
                ChatFooter.e(ChatFooter.this, true);
                ChatFooter.x(ChatFooter.this).setBackgroundResource(2131233811);
                ChatFooter.x(ChatFooter.this).setText(2131757094);
                if (ChatFooter.l(ChatFooter.this) != null) {
                  ChatFooter.l(ChatFooter.this).dla();
                }
                ChatFooter.x(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757050));
                continue;
                if ((paramAnonymousInt == 23) || (paramAnonymousInt == 66))
                {
                  ChatFooter.x(ChatFooter.this).setBackgroundResource(2131232725);
                  ChatFooter.x(ChatFooter.this).setText(2131757093);
                  if (ChatFooter.l(ChatFooter.this) != null) {
                    ChatFooter.l(ChatFooter.this).dkV();
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
  
  private void Ze(int paramInt)
  {
    AppMethodBeat.i(31593);
    if (this.EYX == null)
    {
      AppMethodBeat.o(31593);
      return;
    }
    if (paramInt == 2131231707) {}
    for (int i = 1;; i = 0)
    {
      if (this.EYX != null)
      {
        if (i == 0) {
          break label83;
        }
        this.EYX.setContentDescription(getContext().getString(2131757049));
      }
      for (;;)
      {
        this.EYX.setImageResource(paramInt);
        this.EYX.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(31593);
        return;
        label83:
        this.EYX.setContentDescription(getContext().getString(2131757048));
      }
    }
  }
  
  private void Zj(int paramInt)
  {
    AppMethodBeat.i(31666);
    if (paramInt == this.EZI)
    {
      AppMethodBeat.o(31666);
      return;
    }
    if (this.gmY.getVisibility() == 8) {
      fdQ();
    }
    if (((paramInt == 0) && (this.EZe.getVisibility() == 8)) || (paramInt == 3) || ((paramInt == 0) && (this.EZe.getVisibility() == 8))) {
      fdQ();
    }
    AppMethodBeat.o(31666);
  }
  
  private void Zk(int paramInt)
  {
    AppMethodBeat.i(31680);
    ad.i("MicroMsg.ChatFooter", "[refreshBottomHeight] keyborPx:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.compatible.util.i.fkg();
    int i;
    if ((am.aSQ(this.EYT)) || (am.aSR(this.EYT)))
    {
      paramInt = com.tencent.mm.compatible.util.i.j(getContext(), paramInt, 43);
      i = com.tencent.mm.api.aa.bi(getContext());
      if ((!this.EZG) || (this.EZO)) {
        break label353;
      }
    }
    label353:
    for (this.EZT = paramInt;; this.EZT = z.iI(getContext()))
    {
      paramInt = Math.max(i, this.EZT);
      this.EZU = paramInt;
      if (paramInt != this.EZS) {
        this.EZS = paramInt;
      }
      ad.i("MicroMsg.ChatFooter", "refreshBottomHeight: %s, %s, %s, %s", new Object[] { Boolean.valueOf(this.EZG), Boolean.valueOf(this.EZO), Integer.valueOf(this.EZT), Integer.valueOf(this.EZS) });
      Object localObject = this.EYZ.getLayoutParams();
      if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != this.EZS))
      {
        ((ViewGroup.LayoutParams)localObject).height = this.EZS;
        this.EYZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.EYZ.requestLayout();
      }
      if (this.EZL)
      {
        paramInt = -this.EZS;
        localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
        if ((localObject != null) && (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != paramInt))
        {
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
          setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.EYU != null)
      {
        this.EYU.setPortHeighPx(this.EZT);
        this.EYU.fdc();
      }
      if (this.EUc != null)
      {
        paramInt = this.EZT + this.EYY.getHeight();
        localObject = this.EUc.getLayoutParams();
        if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != paramInt))
        {
          ((ViewGroup.LayoutParams)localObject).height = paramInt;
          this.EUc.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(31680);
      return;
      paramInt = com.tencent.mm.compatible.util.i.aH(getContext(), paramInt);
      break;
    }
  }
  
  private void a(boolean paramBoolean, final Runnable paramRunnable)
  {
    AppMethodBeat.i(31658);
    if (paramBoolean)
    {
      if (this.pWJ == null) {
        fdo();
      }
      this.pWJ.animate().cancel();
      if ((this.pWJ.getVisibility() == 0) && (this.pWJ.getAlpha() == 1.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(31658);
        }
      }
      else
      {
        this.pWJ.setVisibility(0);
        this.pWJ.setAlpha(0.0F);
        this.pWJ.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
        AppMethodBeat.o(31658);
      }
    }
    else if ((this.pWJ == null) || (this.pWJ.getVisibility() == 4) || (this.pWJ.getAlpha() == 0.0F))
    {
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(31658);
      }
    }
    else
    {
      this.pWJ.animate().cancel();
      this.pWJ.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185794);
          ChatFooter.v(ChatFooter.this).setVisibility(4);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(185794);
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
      if (this.EYU == null) {
        fdp();
      }
      this.EYU.animate().cancel();
      if ((this.EYU.getVisibility() == 0) && (this.EYU.getAlpha() == 1.0F))
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
        this.EYU.setAlpha(0.0F);
        this.EYU.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).setListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(193487);
            ChatFooter.bn(ChatFooter.this);
            ChatFooter.bo(ChatFooter.this).animate().setListener(null);
            AppMethodBeat.o(193487);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        }).start();
        this.EYU.setUncertainEnterLocation(paramInt);
        AppMethodBeat.o(163216);
      }
    }
    else
    {
      this.EYU.animate().cancel();
      if ((this.EYU.getVisibility() == 4) || (this.EYU.getAlpha() == 0.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(163216);
        }
      }
      else {
        this.EYU.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185364);
            ChatFooter.this.setAppPanelVisible(4);
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(185364);
          }
        });
      }
    }
    AppMethodBeat.o(163216);
  }
  
  private void aI(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185825);
    if (1 == paramInt3) {}
    for (boolean bool = true; ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) && (paramInt2 == 0); bool = false)
    {
      if (this.EZX == null) {
        break label111;
      }
      this.EZX.xT(bool);
      AppMethodBeat.o(185825);
      return;
    }
    if ((paramInt1 == 0) && ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 4)) && (this.EZX != null)) {
      this.EZX.xU(bool);
    }
    label111:
    AppMethodBeat.o(185825);
  }
  
  private void aM(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31599);
    if (paramBoolean1)
    {
      if ((this.EZh.getTag() != null) && ((this.EZh.getTag() instanceof bu)))
      {
        this.EZh.setVisibility(0);
        bu localbu = (bu)this.EZh.getTag();
        this.EZi.setText(k.c(getContext(), com.tencent.mm.plugin.msgquote.model.a.a(getContext(), this.EZi.getTextSize(), localbu)));
        AppMethodBeat.o(31599);
        return;
      }
      this.EZh.setVisibility(8);
      AppMethodBeat.o(31599);
      return;
    }
    if (paramBoolean2)
    {
      this.EZh.setTag(null);
      this.EZi.setText("");
    }
    this.EZh.setVisibility(8);
    AppMethodBeat.o(31599);
  }
  
  static boolean aMZ(String paramString)
  {
    AppMethodBeat.i(163219);
    boolean bool = ax.aQz("plus_uncertain_enter").getBoolean(paramString, false);
    AppMethodBeat.o(163219);
    return bool;
  }
  
  private static boolean aol()
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
    fdN();
    if (this.EZK != null)
    {
      if ((this.EZR) && (this.EZI == 1))
      {
        this.EZK.c(0, false, paramInt2, paramInt3);
        AppMethodBeat.o(185824);
        return;
      }
      this.EZK.c(paramInt1, paramBoolean, paramInt2, paramInt3);
      AppMethodBeat.o(185824);
      return;
    }
    if ((this.EZI == 0) || (this.EZI == 1)) {
      this.EYZ.setVisibility(8);
    }
    ad.e("MicroMsg.ChatFooter", "scrollParent: scrollParent is not ChattingScrollLayout");
    AppMethodBeat.o(185824);
  }
  
  private boolean cC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(179783);
    if (fdR())
    {
      AppMethodBeat.o(179783);
      return false;
    }
    if ((this.Fag == null) || (bt.isNullOrNil(this.Fag.getTalkerUserName())))
    {
      ad.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg username == null");
      AppMethodBeat.o(179783);
      return false;
    }
    try
    {
      String str = this.Fag.getTalkerUserName();
      if ((((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).amM(str)) && (paramBoolean))
      {
        this.EZm.dbE();
        try
        {
          localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).abd(paramString);
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
          locala2 = com.tencent.mm.plugin.groupsolitaire.b.b.a(localException, this.EZm.uCM, locala1);
          if (!locala2.uBC) {
            break label296;
          }
          com.tencent.mm.plugin.groupsolitaire.b.b.c(locala2);
          label296:
          locala2.field_lastActiveTime = cf.aCN();
          if (locala1 == null) {
            break label391;
          }
        }
        localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hm(paramString, str);
        if ((((Integer)((Pair)localObject).first).intValue() > 0) && (((Pair)localObject).second != null))
        {
          localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second;
          com.tencent.mm.plugin.groupsolitaire.b.b.a(str, u.aAm(), (com.tencent.mm.plugin.groupsolitaire.c.a)localObject);
          com.tencent.mm.plugin.groupsolitaire.c.a locala1 = com.tencent.mm.plugin.groupsolitaire.b.b.a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(str, ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_key, true), u.aAm(), 1);
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
            if (this.EZn != null) {
              this.EZn.amZ(paramString);
            }
            this.EZm.reset();
            fdl();
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
  
  private boolean dbD()
  {
    AppMethodBeat.i(31608);
    if (this.EZm != null)
    {
      boolean bool = this.EZm.dbD();
      AppMethodBeat.o(31608);
      return bool;
    }
    AppMethodBeat.o(31608);
    return false;
  }
  
  private void fdH()
  {
    AppMethodBeat.i(31640);
    this.ize.findViewById(2131298170).setVisibility(0);
    AppMethodBeat.o(31640);
  }
  
  private void fdI()
  {
    AppMethodBeat.i(31641);
    ad.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
    this.EZD = false;
    this.vBp.setImeOptions(0);
    this.vBp.setInputType(this.vBp.getInputType() | 0x40);
    AppMethodBeat.o(31641);
  }
  
  private void fdN()
  {
    AppMethodBeat.i(31660);
    if (this.EZK == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ChattingScrollLayout))
      {
        this.EZK = ((ChattingScrollLayout)localViewParent);
        this.EZL = true;
      }
    }
    AppMethodBeat.o(31660);
  }
  
  private void fdO()
  {
    AppMethodBeat.i(31668);
    if (!this.EZH)
    {
      ad.i("MicroMsg.ChatFooter", "updateKeyboardProvider: not resumed %s", new Object[] { bt.flS() });
      AppMethodBeat.o(31668);
      return;
    }
    if ((this.EZO) || (!this.EZG))
    {
      this.fQT.close();
      ((Activity)getContext()).getWindow().setSoftInputMode(18);
      AppMethodBeat.o(31668);
      return;
    }
    ((Activity)getContext()).getWindow().setSoftInputMode(this.EZM | 0x2);
    this.fQT.start();
    AppMethodBeat.o(31668);
  }
  
  private void fdX()
  {
    AppMethodBeat.i(31687);
    this.Fav.setVisibility(8);
    this.Fay.setVisibility(8);
    this.Fav.setScaleX(0.5F);
    this.Fav.setScaleY(0.5F);
    this.Fay.setScaleX(0.5F);
    this.Fay.setScaleY(0.5F);
    this.Fav.setTranslationX(this.Fct);
    this.Fav.setTranslationY(-this.Fcu);
    this.Fay.setTranslationX(-this.Fct);
    this.Fay.setTranslationY(-this.Fcu);
    fdY();
    fdZ();
    AppMethodBeat.o(31687);
  }
  
  private void fdY()
  {
    AppMethodBeat.i(31688);
    this.Faw.setIconColor(getResources().getColor(2131100020));
    this.Fax.setTextColor(getResources().getColor(2131101072));
    this.Fav.setBackgroundDrawable(getResources().getDrawable(2131234484));
    AppMethodBeat.o(31688);
  }
  
  private void fdZ()
  {
    AppMethodBeat.i(31689);
    this.Faz.setIconColor(getResources().getColor(2131100020));
    this.FaA.setTextColor(getResources().getColor(2131101072));
    this.Fay.setBackgroundDrawable(getResources().getDrawable(2131234484));
    AppMethodBeat.o(31689);
  }
  
  private void fdp()
  {
    AppMethodBeat.i(31594);
    String str;
    if (this.Fag == null)
    {
      str = this.EYT;
      this.EYU = ((AppPanel)findViewById(2131297977));
      this.EYU.setOnSwitchPanelListener(this.FbD);
      this.EYU.setChattingContext(this.FbE);
      this.EYU.setPortHeighPx(z.iI(getContext()));
      if ((!w.Ap(str)) && (!w.Ag(str))) {
        break label124;
      }
      this.EYU.init(0);
    }
    for (;;)
    {
      this.EZa = ((TextView)findViewById(2131297978));
      AppMethodBeat.o(31594);
      return;
      str = this.Fag.getTalkerUserName();
      break;
      label124:
      if (w.zE(str)) {
        this.EYU.init(4);
      } else if (w.vF(str)) {
        this.EYU.init(2);
      } else {
        this.EYU.init(1);
      }
    }
  }
  
  private void fdr()
  {
    AppMethodBeat.i(185399);
    this.FbK.start();
    this.FbL.start();
    this.FbM.start();
    this.FbN.start();
    this.FbO.start();
    this.Fbu.animate().alpha(1.0F).setDuration(200L).start();
    this.Fbv.animate().alpha(1.0F).setDuration(200L).start();
    this.Fbe.animate().alpha(1.0F).translationY(0.0F).setDuration(300L).start();
    fed();
    AppMethodBeat.o(185399);
  }
  
  private void fds()
  {
    AppMethodBeat.i(31617);
    if (this.EZB)
    {
      this.rxj.setVisibility(8);
      this.rxk.setVisibility(8);
      this.BoF.setVisibility(8);
      this.rxh.setVisibility(8);
      this.Fak.setVisibility(0);
      this.Fan.setVisibility(0);
      this.Fao.setVisibility(0);
      this.Faq.setVisibility(8);
      this.Far.setVisibility(0);
      this.Fas.setVisibility(8);
      this.Fau.setVisibility(8);
      this.Fav.setVisibility(8);
      this.Fay.setVisibility(8);
      this.FaK = ChatFooter.k.Fdo;
      this.FaI = ChatFooter.l.Fds;
      AppMethodBeat.o(31617);
      return;
    }
    this.rxj.setVisibility(0);
    this.rxk.setVisibility(8);
    this.BoF.setVisibility(8);
    this.rxh.setVisibility(8);
    this.Fak.setVisibility(8);
    AppMethodBeat.o(31617);
  }
  
  private void fea()
  {
    AppMethodBeat.i(31690);
    String str = ac.iM(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
    {
      this.Fat.setImageResource(2131691370);
      this.Faz.setImageResource(2131691372);
      AppMethodBeat.o(31690);
      return;
    }
    if (str.equals("en"))
    {
      this.Fat.setImageResource(2131691371);
      this.Faz.setImageResource(2131691373);
    }
    AppMethodBeat.o(31690);
  }
  
  private void feb()
  {
    AppMethodBeat.i(185403);
    int k = this.FaS.getWidth();
    int m = this.FaS.getHeight();
    int j = 0;
    int i = 0;
    switch (78.FcO[this.FcB.ordinal()])
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
          AppMethodBeat.i(193505);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).width = i;
          ChatFooter.az(ChatFooter.this).requestLayout();
          AppMethodBeat.o(193505);
        }
      });
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { m, i }).setDuration(200L);
      localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(193506);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).height = i;
          ChatFooter.az(ChatFooter.this).requestLayout();
          AppMethodBeat.o(193506);
        }
      });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
      localAnimatorSet.start();
      AppMethodBeat.o(185403);
      return;
      j = this.Fcb;
      i = this.BFy;
      continue;
      j = this.FbT;
      i = this.FbY;
      continue;
      j = this.FbU;
      i = this.BFy;
    }
  }
  
  private void fec()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(185404);
    float f3 = this.FaS.getTranslationX();
    float f1 = f2;
    switch (78.FcO[this.FcB.ordinal()])
    {
    }
    for (f1 = f2;; f1 = -(ar.ci(getContext()).x / 2 - com.tencent.mm.ui.aq.fromDPToPix(getContext(), 76)))
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f3, f1 }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(193507);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ChatFooter.az(ChatFooter.this).setTranslationX(f);
          AppMethodBeat.o(193507);
        }
      });
      localValueAnimator.start();
      AppMethodBeat.o(185404);
      return;
    }
  }
  
  private void fed()
  {
    AppMethodBeat.i(185405);
    this.FaS.setAlpha(0.0F);
    this.FaS.setTranslationY(com.tencent.mm.ui.aq.fromDPToPix(getContext(), 56));
    this.FaV.setAlpha(0);
    this.FaV.setTranslationY(com.tencent.mm.ui.aq.fromDPToPix(getContext(), 56));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.FaS, "translationY", new float[] { this.FaS.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.FaS, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.FaV, "translationY", new float[] { this.FaV.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofInt(this.FaV, "alpha", new int[] { 0, 255 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    localAnimatorSet.start();
    AppMethodBeat.o(185405);
  }
  
  private void fee()
  {
    AppMethodBeat.i(185406);
    this.FaU.setVisibility(8);
    this.FaX.setVisibility(0);
    this.FaX.setTextColor(getContext().getResources().getColor(2131100017));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Fbb.getLayoutParams();
    localLayoutParams.addRule(13);
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    this.FaX.setText(String.format(getContext().getResources().getString(2131761571), new Object[] { Integer.valueOf(this.Fcc) }));
    this.Fbb.requestLayout();
    AppMethodBeat.o(185406);
  }
  
  private void fef()
  {
    AppMethodBeat.i(185407);
    this.FaU.setVisibility(8);
    this.FaX.setVisibility(0);
    this.FaX.setTextColor(getContext().getResources().getColor(2131100482));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Fbb.getLayoutParams();
    localLayoutParams.removeRule(13);
    localLayoutParams.addRule(21);
    localLayoutParams.addRule(12);
    this.FaX.setText(String.format(getContext().getResources().getString(2131761571), new Object[] { Integer.valueOf(this.Fcc) }));
    this.Fbb.requestLayout();
    AppMethodBeat.o(185407);
  }
  
  private void feg()
  {
    AppMethodBeat.i(185408);
    this.FaU.setVisibility(0);
    this.FaX.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Fbb.getLayoutParams();
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    localLayoutParams.addRule(13);
    this.Fbb.requestLayout();
    ((RelativeLayout.LayoutParams)this.FaU.getLayoutParams()).bottomMargin = 0;
    this.FaU.requestLayout();
    AppMethodBeat.o(185408);
  }
  
  private void feh()
  {
    AppMethodBeat.i(185409);
    this.Fbu.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).withEndAction(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193508);
        ChatFooter.by(ChatFooter.this).setVisibility(8);
        ChatFooter.bz(ChatFooter.this).x(ChatFooter.this.getResources().getColor(2131100017), 0.5F);
        AppMethodBeat.o(193508);
      }
    }).start();
    this.Fbv.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).start();
    this.Fbw.animate().translationY(0.0F).setDuration(100L).start();
    if (this.Fcc < 10) {
      fee();
    }
    for (;;)
    {
      this.Fbc.setVisibility(0);
      this.Fba.setVisibility(8);
      this.FaT.setVisibility(8);
      this.FaV.setImageDrawable(ao.k(getContext(), 2131690496, getContext().getResources().getColor(2131099759)));
      this.FaV.animate().translationX(0.0F).setDuration(150L).start();
      this.FaS.setActivated(true);
      feb();
      fec();
      AppMethodBeat.o(185409);
      return;
      feg();
      this.FaU.a(SoundWaveView.d.BDl);
    }
  }
  
  private void fei()
  {
    AppMethodBeat.i(185410);
    this.Fbj.setVisibility(4);
    this.Fbh.x(getResources().getColor(2131099828), 0.5F);
    this.Fbf.setBackgroundDrawable(getResources().getDrawable(2131233437));
    this.Fbf.animate().scaleX(1.0F).scaleY(1.0F).setDuration(150L).start();
    AppMethodBeat.o(185410);
  }
  
  private void fej()
  {
    AppMethodBeat.i(185411);
    this.Fbk.setVisibility(4);
    this.Fbi.x(getResources().getColor(2131099828), 0.5F);
    this.Fbg.setBackgroundDrawable(getResources().getDrawable(2131233437));
    this.Fbg.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    AppMethodBeat.o(185411);
  }
  
  private void fek()
  {
    AppMethodBeat.i(185412);
    int j = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 20);
    if ((this.FaT.getText() != null) && (this.FaT.getText().length() > 0)) {}
    for (int i = this.FaT.getText().length();; i = 0)
    {
      this.FaT.setSelection(i);
      this.FaT.setPadding(j, j, j, j);
      this.Fbe.setVisibility(8);
      this.Fbc.setVisibility(8);
      this.Fbt.setVisibility(4);
      this.Fbl.setVisibility(0);
      this.FaY.setVisibility(0);
      com.tencent.mm.ck.a.a locala = com.tencent.mm.ck.a.IRP;
      com.tencent.mm.ck.a.fuE();
      this.FaX.setVisibility(8);
      this.FaU.setVisibility(8);
      AppMethodBeat.o(185412);
      return;
    }
  }
  
  private int getDefaultLangType()
  {
    AppMethodBeat.i(185418);
    int i = com.tencent.mm.modelvoiceaddr.g.iyh;
    String str = ac.iM(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW"))) {
      i = com.tencent.mm.modelvoiceaddr.g.iyi;
    }
    for (;;)
    {
      AppMethodBeat.o(185418);
      return i;
      if (str.equals("en")) {
        i = com.tencent.mm.modelvoiceaddr.g.iyk;
      }
    }
  }
  
  private int getTransLangTypeByTalker()
  {
    AppMethodBeat.i(185417);
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voice2txt_sp", 0);
    int j = localSharedPreferences.getInt(this.EYT, com.tencent.mm.modelvoiceaddr.g.iyh);
    if (this.FaZ != null)
    {
      Iterator localIterator = this.FaZ.BCk.fSq.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((com.tencent.mm.plugin.transvoice.ui.a.a.a)localIterator.next()).BEp != j);
      for (i = 1; i == 0; i = 0)
      {
        i = getDefaultLangType();
        if (com.tencent.mm.modelvoiceaddr.g.iyh != i) {
          localSharedPreferences.edit().putInt(this.EYT, i).apply();
        }
        AppMethodBeat.o(185417);
        return i;
      }
      AppMethodBeat.o(185417);
      return j;
    }
    int i = getDefaultLangType();
    if (com.tencent.mm.modelvoiceaddr.g.iyh != i) {
      localSharedPreferences.edit().putInt(this.EYT, i).apply();
    }
    AppMethodBeat.o(185417);
    return i;
  }
  
  private void h(int paramInt1, boolean paramBoolean, final int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(163218);
    ad.i("MicroMsg.ChatFooter", "switchPanel: %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    if (this.EZW)
    {
      AppMethodBeat.o(163218);
      return;
    }
    if ((paramInt1 != 0) && (u.aBd().booleanValue()) && (this.Fab != null))
    {
      this.Fab.a(Boolean.TRUE, Boolean.FALSE);
      this.Fab.b(Boolean.TRUE, Boolean.FALSE);
    }
    Zj(paramInt1);
    if (this.EYY != null) {
      this.EYY.setVisibility(0);
    }
    switch (paramInt1)
    {
    default: 
      if (((this.EZI != 0) || (paramInt1 != 1)) && ((this.EZI != 1) || (paramInt1 != 0))) {
        break;
      }
    }
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      aI(this.EZI, paramInt1, paramInt2);
      this.EZI = paramInt1;
      com.tencent.mm.emoji.b.a locala;
      label218:
      int j;
      if (this.EZI == 2)
      {
        we(true);
        locala = com.tencent.mm.emoji.b.a.goy;
        com.tencent.mm.emoji.b.a.afW();
        j = this.EZN;
        if (this.EZX != null) {
          break label495;
        }
      }
      label495:
      for (paramInt1 = i;; paramInt1 = this.EZX.dbF())
      {
        b(j, paramBoolean, paramInt2, paramInt1);
        if (this.EZp != null) {
          this.EZp.jo(this.EZI, this.EZN);
        }
        AppMethodBeat.o(163218);
        return;
        if ((!this.EZG) || (this.EZO)) {}
        for (this.EZN = 0;; this.EZN = this.nGK)
        {
          a(false, null);
          a(false, null, -1);
          break;
        }
        this.EZN = this.EZU;
        this.EYZ.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185367);
            ChatFooter.br(ChatFooter.this);
            AppMethodBeat.o(185367);
          }
        }, -1);
        break;
        this.EZN = this.EZT;
        this.EYZ.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185796);
            ChatFooter.h(ChatFooter.this, paramInt2);
            AppMethodBeat.o(185796);
          }
        });
        this.EZk.fev();
        wb(false);
        if (this.EZA != 2) {
          break;
        }
        Zh(1);
        break;
        this.EZN = 0;
        a(false, null);
        a(false, null, -1);
        fce();
        fdP();
        break;
        if (this.EYY != null) {
          this.EYY.setVisibility(4);
        }
        this.EZN = this.EZV;
        a(false, null);
        a(false, null, -1);
        break;
        we(false);
        locala = com.tencent.mm.emoji.b.a.goy;
        com.tencent.mm.emoji.b.a.afX();
        break label218;
      }
    }
  }
  
  private void og(boolean paramBoolean)
  {
    AppMethodBeat.i(31584);
    this.gkZ = paramBoolean;
    if (this.Fah == null)
    {
      this.Fah = AnimationUtils.loadAnimation(getContext(), 2130772095);
      this.Fah.setDuration(150L);
    }
    if (this.Fai == null)
    {
      this.Fai = AnimationUtils.loadAnimation(getContext(), 2130772100);
      this.Fai.setDuration(150L);
    }
    if ((this.gmY == null) || (this.EZb == null))
    {
      ad.i("MicroMsg.ChatFooter", "canSend:%B, return sendBtn == null || mAttachButton == null", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31584);
      return;
    }
    if (this.Fae)
    {
      if (this.EZb.getVisibility() != 0) {
        this.EZb.setVisibility(0);
      }
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.gmY.getVisibility() == 0) && (paramBoolean))
    {
      ad.i("MicroMsg.ChatFooter", "canSend true ! sendBtn is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.EZb.getVisibility() == 0) && (!paramBoolean))
    {
      ad.i("MicroMsg.ChatFooter", "canSend false ! AttachButton is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if (paramBoolean)
    {
      fdW();
      this.EZb.startAnimation(this.Fai);
      this.EZb.setVisibility(8);
      wf(false);
    }
    for (;;)
    {
      ad.i("MicroMsg.ChatFooter", "jacks canSend:%B", new Object[] { Boolean.valueOf(paramBoolean) });
      this.gmY.getParent().requestLayout();
      AppMethodBeat.o(31584);
      return;
      this.EZb.startAnimation(this.Fah);
      if ((!this.EZt) && (!this.EZF))
      {
        this.EZb.setVisibility(0);
        wf(true);
      }
      fdV();
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
    switch (78.FcO[this.FcB.ordinal()])
    {
    }
    for (;;)
    {
      this.Fcc = paramInt;
      AppMethodBeat.o(185400);
      return;
      int i = 60 - paramInt;
      int j = (int)(this.FbX * i);
      this.Fcb = Math.min(this.FbW + j, this.FbV);
      ad.d("MicroMsg.ChatFooter", "voiceWidth:%s, duration:%s, offset:%s", new Object[] { Integer.valueOf(this.Fcb), Integer.valueOf(i), Integer.valueOf(j) });
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.FaS.getWidth(), this.Fcb }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      localValueAnimator.start();
      if (paramInt < 10)
      {
        fee();
        continue;
        if (paramInt < 10) {
          fef();
        }
      }
    }
  }
  
  private void wc(boolean paramBoolean)
  {
    AppMethodBeat.i(31598);
    if (paramBoolean)
    {
      this.EZg.setVisibility(0);
      this.EZe.setVisibility(0);
      aM(true, false);
      AppMethodBeat.o(31598);
      return;
    }
    this.EZg.setVisibility(8);
    this.EZe.setVisibility(8);
    aM(false, false);
    AppMethodBeat.o(31598);
  }
  
  private void we(boolean paramBoolean)
  {
    AppMethodBeat.i(31673);
    if (this.EZd == null)
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((this.Fcg) && (paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((!this.Fcg) && (!paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    this.Fcg = paramBoolean;
    if (paramBoolean)
    {
      this.EZd.setImageDrawable(getContext().getResources().getDrawable(2131231706));
      AppMethodBeat.o(31673);
      return;
    }
    this.EZd.setImageDrawable(getContext().getResources().getDrawable(2131690564));
    AppMethodBeat.o(31673);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void Zf(int paramInt)
  {
    AppMethodBeat.i(31616);
    Object localObject1;
    if (this.FaN)
    {
      if (this.FaP == null)
      {
        this.FaP = new o(View.inflate(getContext(), 2131495020, null), -1, -1, true);
        this.FaP.setSoftInputMode(16);
        this.FaP.setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(193477);
            if ((ChatFooter.this.FcB == ChatFooter.e.FcY) && (ChatFooter.aI(ChatFooter.this)))
            {
              ad.i("MicroMsg.ChatFooter", "dismiss from keyback, need cancelRecording");
              ChatFooter.z(ChatFooter.this).setExitType(6);
              ChatFooter.l(ChatFooter.this).dkZ();
            }
            ChatFooter.aJ(ChatFooter.this);
            ChatFooter.e(ChatFooter.this, 0);
            AppMethodBeat.o(193477);
          }
        });
        this.FaQ = this.FaP.getContentView().findViewById(2131302815);
        this.FaR = this.FaP.getContentView().findViewById(2131302837);
        this.FaS = ((ViewGroup)this.FaP.getContentView().findViewById(2131302811));
        this.FaU = ((SoundWaveView)this.FaP.getContentView().findViewById(2131302817));
        this.FaT = ((EditText)this.FaP.getContentView().findViewById(2131302809));
        this.FaV = ((ImageView)this.FaP.getContentView().findViewById(2131302808));
        this.FaW = ((ViewGroup)this.FaP.getContentView().findViewById(2131302816));
        this.FaX = ((TextView)this.FaP.getContentView().findViewById(2131302807));
        this.FaY = ((WeImageView)this.FaP.getContentView().findViewById(2131302812));
        this.FaZ = ((LanguageChoiceLayout)this.FaP.getContentView().findViewById(2131302829));
        this.Fba = ((TextView)this.FaP.getContentView().findViewById(2131302813));
        this.Fbb = ((ViewGroup)this.FaP.getContentView().findViewById(2131302818));
        this.Fbc = ((TextView)this.FaP.getContentView().findViewById(2131302810));
        this.FaZ.setSelectLanguageListener(new LanguageChoiceLayout.a()
        {
          public final void Tt(int paramAnonymousInt)
          {
            AppMethodBeat.i(193478);
            ChatFooter.f(ChatFooter.this, paramAnonymousInt);
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
              ChatFooter.z(ChatFooter.this).BBM = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).BBP = 0;
              ChatFooter.z(ChatFooter.this).BBQ = 0L;
              ChatFooter.z(ChatFooter.this).BBR = 0;
              ChatFooter.z(ChatFooter.this).BBU = 0;
              ChatFooter.z(ChatFooter.this).BBV = 0;
              ChatFooter.z(ChatFooter.this).BBW = 0;
              AppMethodBeat.o(193478);
              return;
              ChatFooter.aM(ChatFooter.this);
            }
          }
        });
        this.FaY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(193479);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (ChatFooter.aN(ChatFooter.this)) {
              ChatFooter.aO(ChatFooter.this).hideSoftInputFromWindow(ChatFooter.aA(ChatFooter.this).getWindowToken(), 0);
            }
            paramAnonymousView = ChatFooter.aP(ChatFooter.this);
            int i = ChatFooter.aK(ChatFooter.this);
            paramAnonymousView.setVisibility(0);
            paramAnonymousView.gWR.post(new LanguageChoiceLayout.4(paramAnonymousView, i));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(193479);
          }
        });
        this.FaT.setMaxLines(2147483647);
        this.FaT.setHorizontallyScrolling(false);
        this.FaT.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(193480);
            if ((4 == paramAnonymousInt) || (66 == paramAnonymousKeyEvent.getAction()))
            {
              paramAnonymousTextView = ChatFooter.aA(ChatFooter.this).getText().toString();
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                if (!bt.isNullOrNil(paramAnonymousTextView)) {
                  ChatFooter.l(ChatFooter.this).apn(paramAnonymousTextView);
                }
                ChatFooter.l(ChatFooter.this).dkZ();
              }
              AppMethodBeat.o(193480);
              return true;
            }
            AppMethodBeat.o(193480);
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
        this.FaT.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(193481);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$39", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            if (ChatFooter.aR(ChatFooter.this))
            {
              ChatFooter.f(ChatFooter.this, false);
              if (ChatFooter.this.BDA != null) {
                ChatFooter.this.BDA.ar(false, true);
              }
              ChatFooter.aS(ChatFooter.this).stopTimer();
              ChatFooter.aA(ChatFooter.this).setText((CharSequence)ChatFooter.aL(ChatFooter.this).get(Integer.valueOf(ChatFooter.aK(ChatFooter.this))));
              ChatFooter.z(ChatFooter.this).BBU = 0;
              ChatFooter.z(ChatFooter.this).BBQ = System.currentTimeMillis();
              ChatFooter.aT(ChatFooter.this);
            }
            ChatFooter.z(ChatFooter.this).BBW = 1;
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$39", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(193481);
            return false;
          }
        });
        this.Fbd = ((ViewGroup)this.FaP.getContentView().findViewById(2131302814));
        this.Fbe = ((ViewGroup)this.FaP.getContentView().findViewById(2131302840));
        this.Fbf = this.FaP.getContentView().findViewById(2131302804);
        this.Fbg = this.FaP.getContentView().findViewById(2131302838);
        this.Fbh = ((WeImageView)this.FaP.getContentView().findViewById(2131302805));
        this.Fbi = ((WeImageView)this.FaP.getContentView().findViewById(2131302839));
        this.Fbj = this.FaP.getContentView().findViewById(2131302806);
        this.Fbk = this.FaP.getContentView().findViewById(2131302842);
        this.Fbl = ((ViewGroup)this.FaP.getContentView().findViewById(2131302841));
        this.Fbm = this.FaP.getContentView().findViewById(2131302820);
        this.Fbm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185353);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ChatFooter.aU(ChatFooter.this);
            ChatFooter.z(ChatFooter.this).setExitType(6);
            ChatFooter.l(ChatFooter.this).dkZ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(185353);
          }
        });
        this.Fbn = this.FaP.getContentView().findViewById(2131302835);
        this.Fbn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185787);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (ChatFooter.l(ChatFooter.this) != null)
            {
              ChatFooter.aU(ChatFooter.this);
              ChatFooter.z(ChatFooter.this).setExitType(7);
              ChatFooter.l(ChatFooter.this).dZ(ChatFooter.l(ChatFooter.this).getFileName(), ChatFooter.aV(ChatFooter.this));
              ChatFooter.ay(ChatFooter.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(185787);
          }
        });
        this.Fbq = this.FaP.getContentView().findViewById(2131302832);
        this.Fbq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(193482);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if ((ChatFooter.aW(ChatFooter.this).getVisibility() == 0) && (8 == ChatFooter.aX(ChatFooter.this).getVisibility()))
            {
              paramAnonymousView = ChatFooter.aA(ChatFooter.this).getText().toString();
              if ((ChatFooter.l(ChatFooter.this) != null) && (!bt.isNullOrNil(paramAnonymousView)))
              {
                ChatFooter.aU(ChatFooter.this);
                ChatFooter.z(ChatFooter.this).BBO = ChatFooter.aK(ChatFooter.this);
                ChatFooter.z(ChatFooter.this).BBS = paramAnonymousView.length();
                if (1 != ChatFooter.z(ChatFooter.this).BBV) {
                  break label210;
                }
                ChatFooter.z(ChatFooter.this).setExitType(8);
              }
            }
            for (;;)
            {
              ChatFooter.l(ChatFooter.this).apn(paramAnonymousView);
              ChatFooter.l(ChatFooter.this).dkZ();
              ChatFooter.b(ChatFooter.this, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(193482);
              return;
              label210:
              ChatFooter.z(ChatFooter.this).setExitType(5);
            }
          }
        });
        this.Fbo = ((WeImageView)this.FaP.getContentView().findViewById(2131302821));
        this.Fbp = ((WeImageView)this.FaP.getContentView().findViewById(2131302836));
        this.Fbr = this.FaP.getContentView().findViewById(2131302834);
        this.Fbs = ((WeImageView)this.FaP.getContentView().findViewById(2131302833));
        this.Fbt = ((ViewGroup)this.FaP.getContentView().findViewById(2131302843));
        this.Fbu = this.FaP.getContentView().findViewById(2131302845);
        this.Fbv = this.FaP.getContentView().findViewById(2131302847);
        this.Fbw = this.FaP.getContentView().findViewById(2131302846);
        this.Fbx = ((WeImageView)this.FaP.getContentView().findViewById(2131302844));
        localObject1 = (RelativeLayout.LayoutParams)this.Fbt.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).height = (getContext().getResources().getDimensionPixelSize(2131166976) + as.ej(getContext()));
        this.Fbt.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (FrameLayout.LayoutParams)this.Fbx.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (as.ej(getContext()) + com.tencent.mm.ui.aq.fromDPToPix(getContext(), 14));
        this.Fbx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.BDH = new av(new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(193483);
            int i = ChatFooter.aY(ChatFooter.this);
            ChatFooter.aZ(ChatFooter.this);
            switch (i % 3)
            {
            }
            for (;;)
            {
              ChatFooter.ba(ChatFooter.this);
              AppMethodBeat.o(193483);
              return true;
              ChatFooter.c(ChatFooter.this, "·");
              continue;
              ChatFooter.c(ChatFooter.this, "··");
              continue;
              ChatFooter.c(ChatFooter.this, "···");
            }
          }
        }, true);
        this.BDK = new com.tencent.mm.sdk.platformtools.ap(new ap.a()
        {
          public final boolean handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(193484);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(193484);
              return true;
              ChatFooter.z(ChatFooter.this).BBP = 1;
              ChatFooter.z(ChatFooter.this).BBQ = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).BBU = 0;
              ChatFooter.aS(ChatFooter.this).stopTimer();
              if (ChatFooter.this.BDA != null) {
                ChatFooter.this.BDA.ar(false, false);
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
        this.Fby = this.FaP.getContentView().findViewById(2131302819);
        this.FaP.setClippingEnabled(false);
      }
      paramInt = getTransLangTypeByTalker();
      if (com.tencent.mm.modelvoiceaddr.g.iyh == paramInt)
      {
        this.BBA = com.tencent.mm.modelvoiceaddr.g.iyi;
        if (this.FaZ != null) {
          this.FaZ.setSelectedLang(this.BBA);
        }
        ad.d("MicroMsg.ChatFooter", "curTxt:%s", new Object[] { Integer.valueOf(this.FcD.size()) });
        if ((com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IJw, true)) || (!com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IJx, true))) {
          break label1675;
        }
        this.Fbc.setTranslationY(com.tencent.mm.ui.aq.fromDPToPix(getContext(), 12));
        this.Fbc.setVisibility(0);
        this.Fbc.setAlpha(0.0F);
        this.Fbc.setText(getContext().getResources().getString(2131761574));
        this.Fbc.animate().alpha(1.0F).translationY(0.0F).setDuration(1000L).setStartDelay(500L).start();
        label1180:
        this.FaS.setTranslationY(0.0F);
        this.FaV.setTranslationY(0.0F);
        this.FaY.setTranslationY(0.0F);
        this.Fbd.setTranslationY(0.0F);
        paramInt = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 20);
        this.FaT.setPadding(paramInt, paramInt, paramInt, 0);
        this.FaT.addTextChangedListener(this.FbJ);
        this.FaT.setVisibility(8);
        this.FaT.setCursorVisible(false);
        this.FaU.setVisibility(0);
        this.Fba.setVisibility(8);
        this.Fbq.setEnabled(true);
        this.FaS.setActivated(true);
        this.Fbs.setImageDrawable(ao.k(getContext(), 2131690391, getContext().getResources().getColor(2131099699)));
        this.FaV.setImageDrawable(ao.k(getContext(), 2131690496, getContext().getResources().getColor(2131099759)));
        localObject1 = (FrameLayout.LayoutParams)this.Fbu.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 8);
        this.Fbu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.Fbu.setAlpha(0.0F);
        localObject1 = (FrameLayout.LayoutParams)this.Fbv.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 8);
        this.Fbv.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.Fbv.setAlpha(0.0F);
        this.Fbe.setTranslationY(this.FcA);
        this.Fbe.setAlpha(0.0F);
        this.FaU.setVisibility(8);
        this.Fby.setVisibility(0);
        if (!al.isDarkMode()) {
          break label1759;
        }
        this.FaR.setBackground(getContext().getResources().getDrawable(2131233433));
      }
      for (;;)
      {
        this.Fcn = false;
        this.FaP.showAtLocation(this, 49, 0, 0);
        fdr();
        this.FaY.setVisibility(8);
        post(new Runnable()
        {
          public final void run()
          {
            int i = 1;
            AppMethodBeat.i(185791);
            ChatFooter.bb(ChatFooter.this);
            if (ChatFooter.bd(ChatFooter.this) != null)
            {
              ChattingScrollLayout localChattingScrollLayout = ChatFooter.bd(ChatFooter.this);
              int j = ChatFooter.bc(ChatFooter.this).getHeight();
              int k = ChatFooter.be(ChatFooter.this).getHeight();
              int m = ar.ej(ChatFooter.this.getContext());
              int n = ChatFooter.a(ChatFooter.this).getHeight();
              if ((localChattingScrollLayout.FdF == null) || (localChattingScrollLayout.FdF.getListView() == null)) {
                break label315;
              }
              int i1 = localChattingScrollLayout.FdF.getListView().getFirstVisiblePosition();
              int i2 = localChattingScrollLayout.FdF.getListView().getHeaderViewsCount();
              i1 = localChattingScrollLayout.FdF.getListView().getLastVisiblePosition() - localChattingScrollLayout.FdF.getListView().getHeaderViewsCount() - (i1 - i2);
              if ((i1 < 0) || (i1 >= localChattingScrollLayout.FdF.getListView().getChildCount())) {
                break label315;
              }
              View localView = localChattingScrollLayout.FdF.getListView().getChildAt(i1);
              if (localView == null) {
                break label315;
              }
              int[] arrayOfInt = new int[2];
              localView.getLocationOnScreen(arrayOfInt);
              i1 = arrayOfInt[1];
              if (localView.getHeight() + i1 <= ar.ci(localChattingScrollLayout.getContext()).y - (j + k - m - n)) {
                break label315;
              }
            }
            for (;;)
            {
              if (i != 0)
              {
                ChatFooter.g(ChatFooter.this, ChatFooter.bc(ChatFooter.this).getHeight() + ChatFooter.be(ChatFooter.this).getHeight() - ar.ej(ChatFooter.this.getContext()) - ChatFooter.a(ChatFooter.this).getHeight());
                ChatFooter.e(ChatFooter.this, 4);
              }
              AppMethodBeat.o(185791);
              return;
              label315:
              i = 0;
            }
          }
        });
        AppMethodBeat.o(31616);
        return;
        this.BBA = paramInt;
        break;
        label1675:
        this.Fbc.setTranslationY(com.tencent.mm.ui.aq.fromDPToPix(getContext(), 30));
        this.Fbc.setVisibility(0);
        this.Fbc.setAlpha(0.0F);
        this.Fbc.setText(getContext().getResources().getString(2131761578));
        this.Fbc.animate().alpha(1.0F).translationY(0.0F).setDuration(200L).setStartDelay(0L).start();
        break label1180;
        label1759:
        this.FaR.setBackground(getContext().getResources().getDrawable(2131233434));
      }
    }
    this.FbG = 0;
    int i;
    if (this.EZB) {
      i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 280);
    }
    for (;;)
    {
      int j = BackwardSupportUtil.b.g(getContext(), 50.0F);
      if (paramInt + j < i)
      {
        this.FbG = -1;
        if (this.BoC == null)
        {
          this.BoC = new o(View.inflate(getContext(), 2131495869, null), -1, -2);
          this.EZw = ((ViewGroup)this.BoC.getContentView().findViewById(2131306525));
          this.rxj = this.BoC.getContentView().findViewById(2131306519);
          this.rxi = ((ImageView)this.BoC.getContentView().findViewById(2131306631));
          this.EZx = ((TextView)this.BoC.getContentView().findViewById(2131306528));
          this.EZx.setTextSize(0, com.tencent.mm.cc.a.ay(getContext(), 2131166735) * com.tencent.mm.cc.a.ik(getContext()));
          this.rxk = this.BoC.getContentView().findViewById(2131306521);
          this.BoD = ((TextView)this.BoC.getContentView().findViewById(2131306523));
          this.BoD.setTextSize(0, com.tencent.mm.cc.a.ay(getContext(), 2131166735) * com.tencent.mm.cc.a.ik(getContext()));
          this.BoE = ((ImageView)this.BoC.getContentView().findViewById(2131306522));
          this.BoF = this.BoC.getContentView().findViewById(2131306524);
          this.rxh = this.BoC.getContentView().findViewById(2131306526);
          this.Fak = ((ViewGroup)this.BoC.getContentView().findViewById(2131306474));
          this.Fal = this.BoC.getContentView().findViewById(2131306467);
          this.Fao = this.BoC.getContentView().findViewById(2131306478);
          this.Fap = ((ImageView)this.BoC.getContentView().findViewById(2131306479));
          this.Faq = ((ImageView)this.BoC.getContentView().findViewById(2131306466));
          this.Far = this.BoC.getContentView().findViewById(2131306468);
          this.Fas = ((TextView)this.BoC.getContentView().findViewById(2131306471));
          this.Fat = ((ImageView)this.BoC.getContentView().findViewById(2131306469));
          this.Fau = this.BoC.getContentView().findViewById(2131306473);
          this.Fav = this.BoC.getContentView().findViewById(2131306463);
          this.Faw = ((WeImageView)this.BoC.getContentView().findViewById(2131306464));
          this.Fax = ((TextView)this.BoC.getContentView().findViewById(2131306465));
          this.Fay = this.BoC.getContentView().findViewById(2131306475);
          this.Faz = ((WeImageView)this.BoC.getContentView().findViewById(2131306476));
          this.FaA = ((TextView)this.BoC.getContentView().findViewById(2131306477));
          this.FaB = View.inflate(getContext(), 2131494417, null);
        }
      }
      try
      {
        if (j.Fdl == this.FaJ)
        {
          localObject1 = this.activity.getWindow().getDecorView();
          Drawable localDrawable = ((View)localObject1).getBackground();
          this.Fam = new BlurView(getContext());
          paramInt = com.tencent.mm.cc.a.fromDPToPix(getContext(), 14);
          BlurView localBlurView = this.Fam.B((ViewGroup)localObject1).acE(getResources().getColor(2131101069)).F(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).bW(15.0F).fAi();
          localBlurView.Kn = (paramInt * 1.0F);
          localBlurView.JwG = true;
          localBlurView.acF(this.FbG).fAj();
          this.FaC = new BlurView(getContext());
          this.FaC.acE(getResources().getColor(2131101069));
          this.FaC.B((ViewGroup)localObject1).F(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).bW(15.0F).fAi().fAj();
        }
        ad.i("MicroMsg.ChatFooter", "transVoiceBlurMode: %s.", new Object[] { this.FaJ });
        switch (78.FcN[this.FaJ.ordinal()])
        {
        default: 
          this.FaG.setClippingEnabled(false);
          this.FaG.getContentView().setAlpha(0.0F);
          this.FaG.setOnDismissListener(new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(193485);
              ChatFooter.H(ChatFooter.this).getContentView().setAlpha(0.0F);
              AppMethodBeat.o(193485);
            }
          });
          ((TextView)this.BoC.getContentView().findViewById(2131306470)).setTextSize(0, com.tencent.mm.cc.a.ay(getContext(), 2131166968) * com.tencent.mm.cc.a.ik(getContext()));
          fds();
          if (this.FbG != -1)
          {
            this.rxh.setVisibility(8);
            this.EZw.setVisibility(8);
            this.BoF.setVisibility(0);
            new com.tencent.mm.sdk.platformtools.ap().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(185792);
                if (ChatFooter.P(ChatFooter.this))
                {
                  ChatFooter.an(ChatFooter.this).setVisibility(8);
                  ChatFooter.T(ChatFooter.this).setVisibility(0);
                  AppMethodBeat.o(185792);
                  return;
                }
                ChatFooter.an(ChatFooter.this).setVisibility(0);
                ChatFooter.T(ChatFooter.this).setVisibility(8);
                AppMethodBeat.o(185792);
              }
            });
            if (this.EZB)
            {
              fea();
              this.FaM = false;
              fdX();
              this.FaG.showAtLocation(this, 49, 0, 0);
              this.FaL = false;
              if (this.Fcl)
              {
                this.Fcl = false;
                if (j.Fdl != this.FaJ) {
                  break label3133;
                }
                this.Fam.acE(getResources().getColor(2131101069)).F(this.activity.getWindow().getDecorView().getBackground()).xN(true);
              }
            }
            this.BoC.showAtLocation(this, 49, 0, this.FbG);
          }
          else
          {
            AppMethodBeat.o(31616);
            return;
            i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 180);
            continue;
            this.FbG = ((paramInt - i) / 2 + j);
          }
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.FaJ = j.Fdm;
          this.FbH = true;
          continue;
          this.Fak.removeView(this.Fal);
          Object localObject2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(2131166964), getResources().getDimensionPixelSize(2131166964));
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          this.Fam.addView(this.Fal, (ViewGroup.LayoutParams)localObject2);
          this.Fak.addView(this.Fam, (ViewGroup.LayoutParams)localObject2);
          this.Fan = this.Fam;
          localObject2 = new FrameLayout.LayoutParams(-1, -1);
          this.FaC.addView(this.FaB, (ViewGroup.LayoutParams)localObject2);
          this.FaG = new o(this.FaC, -1, -1);
          continue;
          this.Fan = this.Fal;
          this.Fan.setBackgroundResource(2131234483);
          this.FaB.setBackgroundColor(getResources().getColor(2131101071));
          this.FaG = new o(this.FaB, -1, -1);
          continue;
          label3133:
          this.Fan.setBackgroundResource(2131234483);
        }
      }
    }
  }
  
  public final void Zg(int paramInt)
  {
    AppMethodBeat.i(31622);
    if (this.FaN)
    {
      if ((this.FaU != null) && (this.FaU.getVisibility() == 0)) {
        this.FaU.Tu(paramInt);
      }
      AppMethodBeat.o(31622);
      return;
    }
    if (this.EZB)
    {
      i = 0;
      for (;;)
      {
        if (i < Fce.length)
        {
          if ((paramInt >= Fcd[i]) && (paramInt < Fcd[(i + 1)])) {
            this.Fap.setBackgroundDrawable(com.tencent.mm.cc.a.l(getContext(), Fce[i]));
          }
        }
        else
        {
          if ((paramInt != -1) || (this.BoC == null)) {
            break;
          }
          this.BoC.dismiss();
          this.BoF.setVisibility(0);
          this.EZw.setVisibility(8);
          this.rxh.setVisibility(8);
          AppMethodBeat.o(31622);
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < Fce.length)
      {
        if ((paramInt >= Fcd[i]) && (paramInt < Fcd[(i + 1)])) {
          this.rxi.setBackgroundDrawable(com.tencent.mm.cc.a.l(getContext(), Fce[i]));
        }
      }
      else
      {
        if ((paramInt == -1) && (this.BoC != null))
        {
          this.BoC.dismiss();
          this.BoF.setVisibility(0);
          this.EZw.setVisibility(8);
          this.rxh.setVisibility(8);
        }
        AppMethodBeat.o(31622);
        return;
      }
      i += 1;
    }
  }
  
  public final void Zh(int paramInt)
  {
    AppMethodBeat.i(31624);
    this.EZA = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31624);
      return;
      wc(true);
      this.EYW.setVisibility(8);
      Ze(2131231707);
      AppMethodBeat.o(31624);
      return;
      wc(false);
      this.EYW.setVisibility(0);
      fdQ();
      Ze(2131231706);
      if ((u.aBd().booleanValue()) && (this.Fab != null))
      {
        c localc = this.Fab;
        Boolean localBoolean = Boolean.TRUE;
        localc.b(localBoolean, localBoolean);
      }
    }
  }
  
  public final void Zi(int paramInt)
  {
    AppMethodBeat.i(185823);
    b(paramInt, true, 0, 0);
    AppMethodBeat.o(185823);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, com.tencent.mm.modelvoiceaddr.h paramh, boolean paramBoolean2)
  {
    AppMethodBeat.i(185826);
    ad.d("MicroMsg.ChatFooter", "startTrans, hasStartTrans: %s, isForce: %s.", new Object[] { Boolean.valueOf(this.FcE), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean2) {
      if (this.FcE)
      {
        if (this.BDA != null) {
          this.BDA.ar(false, true);
        }
        this.BDK.removeMessages(5000);
        this.BDH.stopTimer();
      }
    }
    while (!this.FcE)
    {
      this.FcE = true;
      this.BDA = new com.tencent.mm.plugin.transvoice.a.b(paramh, paramInt, new g.b()
      {
        public final void aNQ()
        {
          AppMethodBeat.i(193514);
          ad.d("MicroMsg.ChatFooter", "onRecordFin.");
          AppMethodBeat.o(193514);
        }
        
        public final void aNU()
        {
          AppMethodBeat.i(193515);
          if ((ChatFooter.this.BDA != null) && (!ChatFooter.this.BDA.BBB))
          {
            ad.d("MicroMsg.ChatFooter", "onRecognizeFinish, %s.", new Object[] { Boolean.valueOf(ChatFooter.this.BDA.BBB) });
            ChatFooter.z(ChatFooter.this).BBU = 1;
            ChatFooter.z(ChatFooter.this).BBQ = System.currentTimeMillis();
            ChatFooter.f(ChatFooter.this, false);
            ChatFooter.aT(ChatFooter.this);
            ChatFooter.this.BDA = null;
            ChatFooter.bC(ChatFooter.this).removeMessages(5000);
            ChatFooter.aS(ChatFooter.this).stopTimer();
            ChatFooter.aM(ChatFooter.this);
          }
          AppMethodBeat.o(193515);
        }
        
        public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(193512);
          ad.d("MicroMsg.ChatFooter", "newVoice2txt onRes, %s.", new Object[] { ChatFooter.this.BDA });
          ChatFooter.bB(ChatFooter.this).clear();
          if (!bt.hj(paramAnonymousList)) {
            ChatFooter.bB(ChatFooter.this).addAll(paramAnonymousList);
          }
          if (!ChatFooter.aR(ChatFooter.this))
          {
            ChatFooter.f(ChatFooter.this, true);
            ChatFooter.aA(ChatFooter.this).setFocusable(true);
            ChatFooter.aA(ChatFooter.this).setFocusableInTouchMode(true);
            ChatFooter.aA(ChatFooter.this).requestFocus();
          }
          if ((ChatFooter.this.BDA != null) && (!ChatFooter.this.BDA.BBB))
          {
            ChatFooter.bC(ChatFooter.this).removeMessages(5000);
            ChatFooter.bC(ChatFooter.this).sendEmptyMessageDelayed(5000, 5000L);
          }
          if (!bt.isNullOrNil(paramAnonymousArrayOfString[0]))
          {
            ChatFooter.aL(ChatFooter.this).put(Integer.valueOf(ChatFooter.aK(ChatFooter.this)), paramAnonymousArrayOfString[0]);
            if (ChatFooter.aL(ChatFooter.this) != null) {
              ChatFooter.z(ChatFooter.this).BBR = paramAnonymousArrayOfString[0].length();
            }
            ad.d("MicroMsg.ChatFooter", "newVoice2txt onRes, curTxt: %s.", new Object[] { paramAnonymousArrayOfString[0] });
          }
          AppMethodBeat.o(193512);
        }
        
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
        {
          AppMethodBeat.i(193513);
          ad.d("MicroMsg.ChatFooter", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong) });
          ChatFooter.z(ChatFooter.this).BBU = 0;
          ChatFooter.z(ChatFooter.this).BBQ = System.currentTimeMillis();
          ChatFooter.aT(ChatFooter.this);
          AppMethodBeat.o(193513);
        }
      });
      this.BDA.BBB = paramBoolean1;
      this.BDA.start();
      this.BDH.az(500L, 500L);
      AppMethodBeat.o(185826);
      return;
    }
    AppMethodBeat.o(185826);
  }
  
  public final void a(Context paramContext, Activity paramActivity)
  {
    boolean bool2 = true;
    AppMethodBeat.i(31575);
    ad.i("MicroMsg.ChatFooter", "onResume: %s, %s", new Object[] { Boolean.valueOf(z.iK(paramContext)), Integer.valueOf(getContext().getResources().getConfiguration().orientation) });
    this.EZH = true;
    this.activity = paramActivity;
    if ((this.EZM == 48) && (this.EZI == 1) && (!this.EZW))
    {
      this.uCj = false;
      h(0, false, -1);
    }
    boolean bool1 = bool2;
    if (getContext().getResources().getConfiguration().orientation != 1)
    {
      if (z.iK(paramContext)) {
        bool1 = bool2;
      }
    }
    else
    {
      this.EZG = bool1;
      if (com.tencent.mm.compatible.util.d.ly(24)) {
        this.EZO = ((Activity)getContext()).isInMultiWindowMode();
      }
      fdO();
      fdT();
      if (com.tencent.mm.pluginsdk.model.app.ap.faj().EOd) {
        com.tencent.mm.pluginsdk.model.app.ap.faj().hu(aj.getContext());
      }
      if ((!this.EYZ.feq()) && (this.pWJ != null)) {
        this.pWJ.onResume();
      }
      if ((this.Fae) || (!this.EZD)) {
        break label293;
      }
      fdI();
    }
    for (;;)
    {
      Zk(getKeyBordHeightPX());
      if (this.EYU != null) {
        this.EYU.context = paramContext;
      }
      this.EZk.FdQ = false;
      if (!this.EUf) {
        fdH();
      }
      fdn();
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
      if ((this.Fae) && (!this.EZD)) {
        fdG();
      }
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(31574);
    this.Fag = paramb;
    this.EZm = new com.tencent.mm.plugin.groupsolitaire.ui.d(getContext(), this.Fag.feo(), new d.d()
    {
      public final void amZ(String paramAnonymousString)
      {
        AppMethodBeat.i(185758);
        if ((ChatFooter.l(ChatFooter.this) != null) && (!bt.isNullOrNil(paramAnonymousString))) {
          ChatFooter.l(ChatFooter.this).amZ(paramAnonymousString);
        }
        AppMethodBeat.o(185758);
      }
      
      public final void dbH()
      {
        AppMethodBeat.i(185757);
        ChatFooter.this.dbH();
        ChatFooter.this.fdl();
        AppMethodBeat.o(185757);
      }
    });
    this.EZm.uCQ = this.EZZ;
    AppMethodBeat.o(31574);
  }
  
  public final void a(final h paramh)
  {
    AppMethodBeat.i(185822);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185362);
        ChatFooter.x(ChatFooter.this).setBackgroundResource(2131232725);
        ChatFooter.x(ChatFooter.this).setText(2131757093);
        if (ChatFooter.this.FaN)
        {
          switch (ChatFooter.78.FcP[paramh.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(185362);
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
            ChatFooter.H(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(300L).withEndAction(ChatFooter.bh(ChatFooter.this)).start();
          }
          ChatFooter.bi(ChatFooter.this).setVisibility(0);
          ChatFooter.bj(ChatFooter.this).setVisibility(8);
          ChatFooter.bk(ChatFooter.this).setVisibility(8);
          ChatFooter.ao(ChatFooter.this).setVisibility(8);
          ChatFooter.U(ChatFooter.this).setVisibility(8);
          ChatFooter.an(ChatFooter.this).setVisibility(0);
        }
        ChatFooter.e(ChatFooter.this, false);
        ChatFooter.d(ChatFooter.this, false);
        AppMethodBeat.o(185362);
      }
    });
    AppMethodBeat.o(185822);
  }
  
  public final void a(String paramString, Boolean paramBoolean, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(193520);
    if (paramBoolean.booleanValue()) {
      a.b.d(this.EZv, paramString);
    }
    for (;;)
    {
      setHint(paramCharSequence);
      this.EZv.setVisibility(0);
      AppMethodBeat.o(193520);
      return;
      a.b.c(this.EZv, paramString);
    }
  }
  
  public final boolean aH(bu parambu)
  {
    AppMethodBeat.i(31678);
    if (this.EZn != null) {
      this.EZn.dld();
    }
    this.EZh.setTag(parambu);
    this.EZA = 1;
    wc(true);
    this.EYW.setVisibility(8);
    Ze(2131231707);
    if (this.EUc != null)
    {
      this.EUc.setVisibility(8);
      this.EUf = false;
      this.EUc.reset();
    }
    showVKB();
    wb(true);
    aMY("");
    AppMethodBeat.o(31678);
    return true;
  }
  
  public final void aMY(String paramString)
  {
    AppMethodBeat.i(31675);
    com.tencent.mm.plugin.groupsolitaire.ui.d locald;
    String str2;
    if ((this.EZm != null) && (this.gmY != null) && (this.Fag != null))
    {
      locald = this.EZm;
      str2 = this.Fag.getTalkerUserName();
      localObject = this.gmY;
      ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow supportAnalyze:%s supportShow:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).amL(str2)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).amM(str2)) });
      locald.uCR = ((View)localObject);
      locald.content = paramString;
      if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).amL(str2))
      {
        if ((bt.isNullOrNil(paramString)) || (paramString.equals(locald.uCF))) {
          break label324;
        }
        com.tencent.e.h.LTJ.aZz("GroupSolitaireCheck");
      }
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).abd(paramString);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    locald.uCO.setContent(paramString);
    locald.uCO.amY(locald.uCh);
    com.tencent.e.h.LTJ.a(locald.uCO, 500L, "GroupSolitaireCheck");
    Object localObject = paramString;
    if (bt.isNullOrNil(locald.uCF))
    {
      locald.uCP.setContent(paramString);
      locald.uCP.amY(locald.uCh);
      com.tencent.e.h.LTJ.a(locald.uCP, 500L, "GroupSolitaireCopyCheck");
      localObject = paramString;
    }
    for (;;)
    {
      locald.uCF = ((String)localObject);
      locald.uCh = str2;
      AppMethodBeat.o(31675);
      return;
      label324:
      String str1 = paramString;
      if (bt.isNullOrNil(paramString))
      {
        locald.dbE();
        str1 = paramString;
      }
    }
  }
  
  public final void aN(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31632);
    this.EYU.vQ(paramBoolean1);
    this.EYU.vR(paramBoolean2);
    AppMethodBeat.o(31632);
  }
  
  public final void aY(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31602);
    if (this.EZr.FcV.containsKey(paramString1)) {}
    Object localObject;
    for (paramString1 = (LinkedList)this.EZr.FcV.get(paramString1);; paramString1 = (String)localObject)
    {
      localObject = new HashMap(1);
      ((HashMap)localObject).put(paramString3, paramString2);
      paramString1.add(localObject);
      AppMethodBeat.o(31602);
      return;
      localObject = new LinkedList();
      this.EZr.FcV.put(paramString1, localObject);
    }
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(31615);
    this.FbF = new i(paramTextWatcher);
    this.vBp.addTextChangedListener(this.FbF);
    AppMethodBeat.o(31615);
  }
  
  public final void ba(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(31625);
    Zh(paramInt);
    switch (paramInt)
    {
    default: 
      setVisibility(0);
      AppMethodBeat.o(31625);
      return;
    case 1: 
      if (paramBoolean)
      {
        wb(true);
        showVKB();
        if (this.vBp.length() > 0) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          og(paramBoolean);
          AppMethodBeat.o(31625);
          return;
        }
      }
      if (this.vBp.length() > 0) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        og(paramBoolean);
        AppMethodBeat.o(31625);
        return;
      }
    }
    g(0, true, -1);
    og(false);
    AppMethodBeat.o(31625);
  }
  
  public final void cdY()
  {
    AppMethodBeat.i(31610);
    this.FaH.setExitType(1);
    this.EYW.setEnabled(false);
    this.EYW.setBackgroundResource(2131233809);
    if (this.FaN)
    {
      this.FaP.update();
      this.ptC.sendEmptyMessageDelayed(0, 500L);
      AppMethodBeat.o(31610);
      return;
    }
    if (this.BoC != null)
    {
      this.rxh.setVisibility(0);
      this.EZw.setVisibility(8);
      this.BoF.setVisibility(8);
      this.BoC.update();
      this.FaG.dismiss();
    }
    this.ptC.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(31610);
  }
  
  public final void dbH()
  {
    AppMethodBeat.i(31679);
    if (this.vBp != null)
    {
      this.vBp.setText("");
      fdk();
    }
    AppMethodBeat.o(31679);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31578);
    if (this.pWJ != null)
    {
      ad.i("MicroMsg.ChatFooter", "jacks chat footer destroy smiley panel");
      this.pWJ.fbE();
      this.pWJ.destroy();
      this.pWJ.animate().cancel();
      this.pWJ = null;
    }
    if (this.EUc != null)
    {
      this.EUc.destroy();
      this.EUc = null;
      this.EUf = false;
    }
    if (this.EZn != null) {
      this.EZn.release();
    }
    if (this.EZl != null)
    {
      this.EZl.Fad = null;
      this.EZl.Feb = null;
      this.EZl.hide();
    }
    if (this.BoC != null)
    {
      if (this.Fam != null) {
        this.Fam.getBlurController().destroy();
      }
      if (this.FaC != null) {
        this.FaC.getBlurController().destroy();
      }
    }
    ad.i("MicroMsg.ChatFooter", "jacks destroy chat footer.");
    AppMethodBeat.o(31578);
  }
  
  public final void fW(View paramView)
  {
    int i = -1;
    AppMethodBeat.i(163212);
    if (this.EZn != null) {
      this.EZn.dlc();
    }
    ad.i("MicroMsg.ChatFooter", "click attach btn: %s, %s", new Object[] { Integer.valueOf(this.EYU.getVisibility()), Boolean.valueOf(this.EYZ.feq()) });
    if (this.EZI == 3)
    {
      if (this.EZA == 1)
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
      if ((this.EUc != null) && (this.EUc.getVisibility() == 0) && (this.EUf))
      {
        ad.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
        this.EUc.setVisibility(8);
        this.EUf = false;
        this.EUc.reset();
      }
      paramView = com.tencent.mm.pluginsdk.model.app.ap.faj();
      localObject = aj.getContext();
      if ((com.tencent.mm.kernel.g.ajx()) && (localObject != null)) {
        break label284;
      }
      label187:
      com.tencent.mm.pluginsdk.model.app.ap.faj().hu(aj.getContext());
      if ((w.zk(this.toUser)) && (com.tencent.mm.chatroom.d.aa.Yh()))
      {
        paramView = this.toUser;
        if (!w.Az(paramView)) {
          break label529;
        }
        i = 2;
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject = new com.tencent.mm.g.b.a.q();
        ((com.tencent.mm.g.b.a.q)localObject).gN(paramView);
        ((com.tencent.mm.g.b.a.q)localObject).dPH = 1L;
        ((com.tencent.mm.g.b.a.q)localObject).dSy = i;
        ((com.tencent.mm.g.b.a.q)localObject).aLk();
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
          String str = com.tencent.mm.n.g.acA().getValue("ShowAPPSuggestion");
          if ((bt.isNullOrNil(str)) || (Integer.valueOf(str).intValue() != 1)) {
            ad.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[] { str });
          }
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[] { localException.getMessage() });
          if (paramView.ENX)
          {
            ad.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
            break label187;
          }
          ad.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
          paramView.ENX = true;
          if (System.currentTimeMillis() - paramView.EOa < 43200000L)
          {
            ad.d("MicroMsg.SuggestionAppListLogic", "not now");
            paramView.ENX = false;
            break label187;
          }
          com.tencent.mm.kernel.g.ajD();
          paramView.EOa = com.tencent.mm.kernel.g.ajC().ajl().aaQ(352275);
          if (System.currentTimeMillis() - paramView.EOa < 43200000L)
          {
            ad.w("MicroMsg.SuggestionAppListLogic", "not now sp");
            paramView.ENX = false;
            break label187;
          }
          if (paramView.lang == null) {
            paramView.lang = ac.f(((Context)localObject).getSharedPreferences(aj.fkC(), 0));
          }
          paramView = new af(paramView.lang, new LinkedList());
          com.tencent.mm.plugin.s.a.dxT();
          com.tencent.mm.pluginsdk.model.app.e.a(4, paramView);
        }
      }
      break label187;
      label529:
      if (w.Ay(paramView)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void fbF()
  {
    AppMethodBeat.i(31591);
    this.EZE = true;
    if (this.pWJ != null) {
      this.pWJ.fbF();
    }
    AppMethodBeat.o(31591);
  }
  
  public final void fce()
  {
    AppMethodBeat.i(31601);
    if (!this.EUf)
    {
      AppMethodBeat.o(31601);
      return;
    }
    this.EUf = false;
    if (this.EUc != null)
    {
      int i = getKeyBordHeightPX();
      int j = this.EYY.getHeight();
      this.EUc.animate().cancel();
      this.EUc.animate().translationY(i + j).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193474);
          if (ChatFooter.ax(ChatFooter.this) != null)
          {
            ChatFooter.ax(ChatFooter.this).destroy();
            ChatFooter.ax(ChatFooter.this).setVisibility(8);
          }
          AppMethodBeat.o(193474);
        }
      }).start();
    }
    this.vBp.setText("");
    AppMethodBeat.o(31601);
  }
  
  public final void fdA()
  {
    AppMethodBeat.i(31635);
    AppPanel localAppPanel = this.EYU;
    localAppPanel.EXN = true;
    localAppPanel.EXF.vY(false);
    localAppPanel.fcY();
    ad.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", new Object[] { bt.flS().toString() });
    AppMethodBeat.o(31635);
  }
  
  public final void fdB()
  {
    this.EYU.EXQ = true;
  }
  
  public final void fdC()
  {
    AppMethodBeat.i(31636);
    AppPanel localAppPanel = this.EYU;
    localAppPanel.EXO = true;
    localAppPanel.EXF.vV(false);
    localAppPanel.fcY();
    ad.i("MicroMsg.AppPanel", "disableServiceRemittance %s", new Object[] { bt.flS().toString() });
    AppMethodBeat.o(31636);
  }
  
  public final void fdD()
  {
    AppMethodBeat.i(193518);
    AppPanel localAppPanel = this.EYU;
    localAppPanel.EXF.EYe.value = false;
    localAppPanel.fcY();
    AppMethodBeat.o(193518);
  }
  
  public final void fdE()
  {
    AppMethodBeat.i(31637);
    if (this.EZd != null) {
      this.EZd.setVisibility(8);
    }
    AppMethodBeat.o(31637);
  }
  
  public final void fdF()
  {
    AppMethodBeat.i(31638);
    AppPanel localAppPanel = this.EYU;
    localAppPanel.EXP = true;
    localAppPanel.EXF.vZ(false);
    localAppPanel.fcY();
    AppMethodBeat.o(31638);
  }
  
  public final void fdG()
  {
    AppMethodBeat.i(31639);
    ad.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
    this.EZD = true;
    this.vBp.setImeOptions(4);
    this.vBp.setInputType(this.vBp.getInputType() & 0xFFFFFFBF);
    AppMethodBeat.o(31639);
  }
  
  public final boolean fdJ()
  {
    AppMethodBeat.i(31645);
    if ((this.Faf == null) || (this.Faf.getView() == null))
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Object localObject = this.Faf.getView().findViewById(2131302320);
    if (localObject == null)
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Rect localRect = new Rect();
    ((View)localObject).getGlobalVisibleRect(localRect);
    if (com.tencent.mm.compatible.util.d.ly(28))
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
  
  public final boolean fdK()
  {
    return this.EZI != 0;
  }
  
  public final void fdL()
  {
    AppMethodBeat.i(31653);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179780);
        ad.i("MicroMsg.ChatFooter", "withLastText: ");
        ChatFooter.this.showVKB();
        ChatFooter.a(ChatFooter.this, true);
        AppMethodBeat.o(179780);
      }
    }, 500L);
    AppMethodBeat.o(31653);
  }
  
  public final void fdM()
  {
    AppMethodBeat.i(31655);
    if ((this.EUc != null) && (this.EUc.isShown())) {
      this.EUc.fey();
    }
    AppMethodBeat.o(31655);
  }
  
  public final void fdP()
  {
    AppMethodBeat.i(193519);
    if (this.EZl != null)
    {
      this.EZl.Fec = false;
      this.EZl.hide();
    }
    AppMethodBeat.o(193519);
  }
  
  public final void fdQ()
  {
    AppMethodBeat.i(31674);
    if (this.EZm != null) {
      this.EZm.dbE();
    }
    AppMethodBeat.o(31674);
  }
  
  public final boolean fdR()
  {
    AppMethodBeat.i(31677);
    if ((this.EZh.getTag() != null) && ((this.EZh.getTag() instanceof bu)) && (this.EZg.isShown()) && (this.EZh.isShown()))
    {
      AppMethodBeat.o(31677);
      return true;
    }
    AppMethodBeat.o(31677);
    return false;
  }
  
  public final void fdS()
  {
    AppMethodBeat.i(31681);
    this.EYW.setBackgroundResource(2131232725);
    this.EYW.setText(2131757093);
    Object localObject;
    if (this.FaN)
    {
      if (!this.Fcn)
      {
        this.Fcn = true;
        if (this.EZn == null) {
          break label299;
        }
        this.FaH.BBL = this.EZn.PZ();
        if ((this.FaP == null) || (!this.FaP.isShowing())) {
          break label299;
        }
        if (e.FcX == this.FcB)
        {
          this.FbB = false;
          this.EZn.dkY();
          this.FaH.setExitType(2);
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJx, Boolean.FALSE);
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        AppMethodBeat.o(31681);
        return;
      }
      if (e.FcY == this.FcB)
      {
        if (this.Fcm <= 0) {
          this.Fcm = ((int)this.EZn.PZ());
        }
        if (!bt.isNullOrNil(this.EZn.getFileName()))
        {
          localObject = com.tencent.mm.ck.a.IRP;
          com.tencent.mm.ck.a.a.aVj(this.EZn.getFileName());
        }
        this.EZn.dkW();
        fek();
        this.BDK.sendEmptyMessageDelayed(5000, 5000L);
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJx, Boolean.FALSE);
        AppMethodBeat.o(31681);
        return;
      }
      if (e.FcW == this.FcB)
      {
        this.FbB = false;
        this.EZn.dkV();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJw, Boolean.FALSE);
      }
      label299:
      AppMethodBeat.o(31681);
      return;
    }
    this.ptn = false;
    if (this.EZn != null)
    {
      this.FaH.BBL = this.EZn.PZ();
      if (this.EZB)
      {
        if (ChatFooter.k.Fdo != this.FaK)
        {
          this.Fcl = true;
          if ((this.BoC != null) && (this.BoC.isShowing()))
          {
            if (ChatFooter.k.Fdq == this.FaK)
            {
              ad.i("MicroMsg.ChatFooter", "do not send voice.");
              this.FaH.setExitType(2);
              this.EZn.dkY();
              AppMethodBeat.o(31681);
              return;
            }
            ad.i("MicroMsg.ChatFooter", "trans voice to txt.");
            this.EZn.dkW();
            localObject = this.EZn.getFileName();
            final long l = this.EZn.PZ();
            ad.i("transvoice", "fileName: %s, voiceLen: %d.", new Object[] { localObject, Long.valueOf(l) });
            if (ay.isConnected(getContext()))
            {
              if (this.FaF.isValid())
              {
                this.FaD.aDe((String)localObject);
                this.FaD.BDC = l;
                this.FaD.talker = this.EYT;
                this.FaD.show();
                this.FaD.c(this.FaF);
                this.EZP = false;
                AppMethodBeat.o(31681);
                return;
              }
              this.FaH.setExitType(3);
              locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
              locala.aXG(getResources().getString(2131764730));
              locala.aXM(getResources().getString(2131764731));
              locala.afn(getResources().getColor(2131099770));
              locala.c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(193493);
                  ChatFooter.l(ChatFooter.this).apo(this.cYz);
                  AppMethodBeat.o(193493);
                }
              });
              locala.yR(false);
              locala.fMb().show();
              AppMethodBeat.o(31681);
              return;
            }
            this.FaH.setExitType(4);
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
            locala.aXG(getResources().getString(2131761547));
            locala.aXM(getResources().getString(2131761549));
            locala.afn(getResources().getColor(2131099770));
            locala.aXN(getResources().getString(2131761548));
            locala.c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(193494);
                ChatFooter.l(ChatFooter.this).dZ(this.cYz, (int)l);
                AppMethodBeat.o(193494);
              }
            });
            locala.d(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(193495);
                ChatFooter.l(ChatFooter.this).apo(this.cYz);
                AppMethodBeat.o(193495);
              }
            });
            locala.fMb().show();
            AppMethodBeat.o(31681);
          }
        }
        else
        {
          this.EZn.dkV();
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        if ((this.rxk != null) && (this.rxk.getVisibility() == 0))
        {
          this.FaH.setExitType(2);
          this.EZn.dkY();
          AppMethodBeat.o(31681);
          return;
        }
        this.EZn.dkV();
      }
    }
    AppMethodBeat.o(31681);
  }
  
  public final void fdT()
  {
    AppMethodBeat.i(31683);
    ba.aBQ();
    this.Fae = ((Boolean)com.tencent.mm.model.c.ajl().get(66832, Boolean.FALSE)).booleanValue();
    if (this.vBp != null) {
      this.vBp.setEnableSendBtn(this.Fae);
    }
    AppMethodBeat.o(31683);
  }
  
  public final boolean fdU()
  {
    AppMethodBeat.i(193521);
    if ((this.Fag != null) && (this.Fag.fep() != null))
    {
      if (!((com.tencent.mm.ui.chatting.d.b.h)this.Fag.fep().bh(com.tencent.mm.ui.chatting.d.b.h.class)).fDl())
      {
        AppMethodBeat.o(193521);
        return true;
      }
      AppMethodBeat.o(193521);
      return false;
    }
    AppMethodBeat.o(193521);
    return true;
  }
  
  public final void fdV()
  {
    AppMethodBeat.i(31685);
    if ((this.gmY == null) || (this.gmY.getVisibility() == 8))
    {
      AppMethodBeat.o(31685);
      return;
    }
    if (this.Fcr == 0)
    {
      this.Fcr = this.gmY.getWidth();
      this.Fcs = this.EZb.getWidth();
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.Fcr, this.Fcs });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(193496);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bu(ChatFooter.this)) / (ChatFooter.bw(ChatFooter.this) - ChatFooter.bu(ChatFooter.this));
        ChatFooter.k(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(193496);
      }
    });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(193499);
        ChatFooter.k(ChatFooter.this).setVisibility(8);
        AppMethodBeat.o(193499);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(193498);
        if (!ChatFooter.bx(ChatFooter.this))
        {
          ChatFooter.k(ChatFooter.this).setVisibility(8);
          AppMethodBeat.o(193498);
          return;
        }
        ad.i("MicroMsg.ChatFooter", "animHideSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bx(ChatFooter.this)) });
        ChatFooter.this.fdW();
        AppMethodBeat.o(193498);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(193497);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(193497);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.start();
    AppMethodBeat.o(31685);
  }
  
  public final void fdW()
  {
    AppMethodBeat.i(31686);
    if (this.gmY == null)
    {
      AppMethodBeat.o(31686);
      return;
    }
    if (this.Fcr == 0)
    {
      this.Fcr = this.gmY.getWidth();
      this.Fcs = this.EZb.getWidth();
    }
    if (this.Fcr == 0)
    {
      this.gmY.startAnimation(this.Fah);
      this.gmY.setVisibility(0);
      AppMethodBeat.o(31686);
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.Fcs, this.Fcr });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(185383);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bu(ChatFooter.this)) / (ChatFooter.bw(ChatFooter.this) - ChatFooter.bu(ChatFooter.this));
        ChatFooter.k(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(185383);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(193502);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.i(ChatFooter.this, false);
        AppMethodBeat.o(193502);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(193501);
        paramAnonymousAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousAnimator.width = -2;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousAnimator);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.i(ChatFooter.this, false);
        if (!ChatFooter.bx(ChatFooter.this))
        {
          ad.i("MicroMsg.ChatFooter", "animShowSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bx(ChatFooter.this)) });
          ChatFooter.r(ChatFooter.this).setVisibility(0);
          ChatFooter.i(ChatFooter.this, true);
          ChatFooter.this.fdV();
        }
        AppMethodBeat.o(193501);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(193500);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(193500);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(31686);
  }
  
  public final void fdk()
  {
    AppMethodBeat.i(31572);
    if (this.Faa != null)
    {
      com.tencent.mm.g.b.a.d locald = this.Faa;
      locald.dPR = 0L;
      locald.dPP = 0L;
      locald.dPQ = 0L;
      locald.dPS = 0L;
      locald.bn(0L).bo(0L);
    }
    AppMethodBeat.o(31572);
  }
  
  public final void fdl()
  {
    AppMethodBeat.i(31581);
    if (!bt.ai(this.EZi.getText())) {
      this.EZi.setText("");
    }
    if (this.EZh.getTag() != null) {
      this.EZh.setTag(null);
    }
    this.EZh.setVisibility(8);
    AppMethodBeat.o(31581);
  }
  
  public final void fdm()
  {
    AppMethodBeat.i(31583);
    if (this.EYU == null)
    {
      AppMethodBeat.o(31583);
      return;
    }
    this.EYU.fcN();
    AppMethodBeat.o(31583);
  }
  
  public final void fdn()
  {
    AppMethodBeat.i(31587);
    this.EZd = ((ImageButton)this.ize.findViewById(2131298172));
    this.EZd.setVisibility(0);
    if (!com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IDZ, true)) {
      this.ize.findViewById(2131298173).setVisibility(0);
    }
    for (;;)
    {
      this.ize.findViewById(2131298173).setVisibility(8);
      this.EZd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184916);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = com.tencent.mm.emoji.b.a.goy;
          com.tencent.mm.emoji.b.a.afV();
          if (ChatFooter.l(ChatFooter.this) != null) {
            ChatFooter.l(ChatFooter.this).dlb();
          }
          if (ChatFooter.c(ChatFooter.this) == 2) {
            ChatFooter.this.showVKB();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(184916);
            return;
            if (ChatFooter.s(ChatFooter.this)) {
              ChatFooter.this.fbF();
            }
            ChatFooter.this.fdq();
            if (!com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IDZ, false))
            {
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDZ, Boolean.TRUE);
              ChatFooter.t(ChatFooter.this).findViewById(2131298173).setVisibility(8);
            }
          }
        }
      });
      if (this.EZl != null) {
        this.EZl.Fea = this.EZd;
      }
      if (this.EZm != null) {
        this.EZm.uCC = this.ize;
      }
      AppMethodBeat.o(31587);
      return;
      this.ize.findViewById(2131298173).setVisibility(8);
    }
  }
  
  public final void fdo()
  {
    boolean bool = true;
    AppMethodBeat.i(31590);
    if ((e.FdJ == null) || (getContext() == null))
    {
      if (getContext() == null)
      {
        ad.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", new Object[] { bt.flS() });
        this.pWJ = new d(aj.getContext());
        AppMethodBeat.o(31590);
        return;
      }
      this.pWJ = new d(getContext());
      AppMethodBeat.o(31590);
      return;
    }
    if (this.pWJ != null) {
      this.pWJ.destroy();
    }
    this.pWJ = e.FdJ.eA(getContext());
    ChatFooterPanel localChatFooterPanel;
    if (this.pWJ != null)
    {
      this.pWJ.setEntranceScene(ChatFooterPanel.ESp);
      this.pWJ.setVisibility(8);
      this.pWJ.setFooterType(this.DCQ);
      if (this.EYZ != null) {
        this.EYZ.addView(this.pWJ, -1, -1);
      }
      this.pWJ.setOnTextOperationListener(this.FbC);
      localChatFooterPanel = this.pWJ;
      if (this.vBp.getText().length() <= 0) {
        break label269;
      }
    }
    for (;;)
    {
      localChatFooterPanel.setSendButtonEnable(bool);
      if (this.Fag != null) {
        this.pWJ.setTalkerName(this.Fag.getTalkerUserName());
      }
      this.pWJ.onResume();
      if (this.EZE) {
        fbF();
      }
      setSmileyPanelCallback(this.ESn);
      AppMethodBeat.o(31590);
      return;
      label269:
      bool = false;
    }
  }
  
  public final void fdq()
  {
    AppMethodBeat.i(31597);
    this.EZA = 1;
    wc(true);
    if (this.vBp.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      og(bool);
      this.EYW.setVisibility(8);
      Ze(2131231707);
      if (this.EUc != null)
      {
        this.EUc.setVisibility(8);
        this.EUf = false;
        this.EUc.reset();
      }
      g(2, true, -1);
      AppMethodBeat.o(31597);
      return;
    }
  }
  
  public final void fdt()
  {
    AppMethodBeat.i(31620);
    if (this.FaN)
    {
      this.FaU.setVisibility(0);
      this.Fby.setVisibility(8);
      AppMethodBeat.o(31620);
      return;
    }
    this.BoF.setVisibility(8);
    this.EZw.setVisibility(0);
    AppMethodBeat.o(31620);
  }
  
  public final void fdu()
  {
    AppMethodBeat.i(31626);
    wc(true);
    this.EYX.setVisibility(8);
    this.EYW.setVisibility(8);
    AppMethodBeat.o(31626);
  }
  
  public final void fdv()
  {
    AppMethodBeat.i(31627);
    if (this.EYX != null) {
      this.EYX.setVisibility(0);
    }
    AppMethodBeat.o(31627);
  }
  
  public final void fdw()
  {
    AppMethodBeat.i(31628);
    AppPanel localAppPanel = this.EYU;
    localAppPanel.EXF.EYc.value = false;
    localAppPanel.fcY();
    AppMethodBeat.o(31628);
  }
  
  public final void fdx()
  {
    AppMethodBeat.i(31629);
    AppPanel localAppPanel = this.EYU;
    localAppPanel.EXF.EYu.value = false;
    localAppPanel.fcY();
    AppMethodBeat.o(31629);
  }
  
  public final void fdy()
  {
    AppMethodBeat.i(31630);
    AppPanel localAppPanel = this.EYU;
    localAppPanel.EXF.EYd.value = false;
    localAppPanel.fcY();
    AppMethodBeat.o(31630);
  }
  
  public final void fdz()
  {
    AppMethodBeat.i(31631);
    AppPanel localAppPanel = this.EYU;
    localAppPanel.EXF.EYg.value = false;
    localAppPanel.fcY();
    AppMethodBeat.o(31631);
  }
  
  public final boolean fel()
  {
    AppMethodBeat.i(185416);
    if ((this.FaP != null) && (this.FaP.isShowing()))
    {
      AppMethodBeat.o(185416);
      return true;
    }
    AppMethodBeat.o(185416);
    return false;
  }
  
  public final void g(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(163217);
    ad.i("MicroMsg.ChatFooter", "configPanel: %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uCj), Boolean.valueOf(this.EZO), Boolean.valueOf(this.EZG) });
    int i;
    int j;
    label98:
    int k;
    if ((this.EZO) || (!this.EZG))
    {
      i = 1;
      if ((paramInt1 != 1) || (this.uCj)) {
        break label199;
      }
      j = 1;
      if ((paramInt1 == 1) || (!this.uCj)) {
        break label205;
      }
      k = 1;
      label113:
      if ((i == 0) && ((j != 0) || (k != 0))) {
        break label211;
      }
      h(paramInt1, paramBoolean, paramInt2);
      label135:
      if (j != 0)
      {
        this.EZQ = 0;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193488);
            ChatFooter.a(ChatFooter.this, true);
            ChatFooter.this.setToSendTextColor(true);
            boolean bool = ChatFooter.aO(ChatFooter.this).showSoftInput(ChatFooter.d(ChatFooter.this), 0);
            ChatFooter.bp(ChatFooter.this);
            ad.i("MicroMsg.ChatFooter", "showSoftInput %b, %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(ChatFooter.bq(ChatFooter.this)) });
            if ((!bool) && (ChatFooter.bq(ChatFooter.this) < 10)) {
              ChatFooter.this.postDelayed(this, 100L);
            }
            AppMethodBeat.o(193488);
          }
        });
      }
      if (k != 0) {
        hideVKB();
      }
      if (i != 0) {
        if (paramInt1 != 1) {
          break label219;
        }
      }
    }
    label199:
    label205:
    label211:
    label219:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.uCj = paramBoolean;
      AppMethodBeat.o(163217);
      return;
      i = 0;
      break;
      j = 0;
      break label98;
      k = 0;
      break label113;
      this.EZJ = paramInt1;
      break label135;
    }
  }
  
  public final int gd(String paramString, int paramInt)
  {
    AppMethodBeat.i(163213);
    int i = paramInt;
    if (this.EZr.FcV.containsKey(paramString))
    {
      i = paramInt;
      if (((LinkedList)this.EZr.FcV.get(paramString)).size() > 0) {
        i = paramInt | 0x1;
      }
    }
    paramInt = i;
    if (this.EZu) {
      paramInt = i | 0x2;
    }
    AppMethodBeat.o(163213);
    return paramInt;
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163215);
    ArrayList localArrayList = this.EYU.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163215);
    return localArrayList;
  }
  
  public String getAtSomebody()
  {
    return this.EZr.FcT;
  }
  
  public int getBarGroupHeight()
  {
    AppMethodBeat.i(31585);
    if (this.EZy == null) {
      this.EZy = findViewById(2131298090);
    }
    if (this.EZy != null)
    {
      i = this.EZy.getHeight();
      AppMethodBeat.o(31585);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131165299);
    AppMethodBeat.o(31585);
    return i;
  }
  
  public f getCallback()
  {
    return this.ESn;
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
    return this.EZN;
  }
  
  public z.a getIOnToDoBarCallback()
  {
    return this.EZY;
  }
  
  public int getInsertPos()
  {
    return this.EZr.FcU;
  }
  
  public boolean getIsVoiceInputPanleShow()
  {
    return this.EUf;
  }
  
  public int getKeyBordHeightPX()
  {
    AppMethodBeat.i(31671);
    int i = z.iI(getContext());
    AppMethodBeat.o(31671);
    return i;
  }
  
  public String getLastContent()
  {
    return this.EZr.FcS;
  }
  
  public long getLastQuoteMsgId()
  {
    AppMethodBeat.i(31612);
    if ((this.EZh.getTag() != null) && ((this.EZh.getTag() instanceof bu)))
    {
      long l = ((bu)this.EZh.getTag()).field_msgId;
      AppMethodBeat.o(31612);
      return l;
    }
    AppMethodBeat.o(31612);
    return 0L;
  }
  
  public String getLastText()
  {
    AppMethodBeat.i(31611);
    if (this.vBp == null)
    {
      AppMethodBeat.o(31611);
      return "";
    }
    String str = this.vBp.getText().toString();
    AppMethodBeat.o(31611);
    return str;
  }
  
  public int getMode()
  {
    return this.EZA;
  }
  
  public View getPanel()
  {
    return this.EYZ;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(31613);
    int i = this.vBp.getSelectionStart();
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
    if (this.EZI == 0) {
      i = getHeight() - this.EZS;
    }
    for (;;)
    {
      AppMethodBeat.o(31684);
      return i;
      int j = getHeight() - this.EZS + getKeyBordHeightPX();
      i = j;
      if (this.EZX != null) {
        i = j - this.EZX.dbF();
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
  
  public final void k(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(31582);
    if ((this.EZh.getTag() != null) && ((this.EZh.getTag() instanceof bu)) && (bt.aA(paramLong, ((bu)this.EZh.getTag()).field_msgId))) {
      com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185798);
          if (!paramBoolean) {
            com.tencent.mm.ui.base.h.c(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(2131761359), "", true);
          }
          ChatFooter.this.fdl();
          AppMethodBeat.o(185798);
        }
      });
    }
    AppMethodBeat.o(31582);
  }
  
  public final void lx(String paramString1, String paramString2)
  {
    this.dyU = paramString1;
    this.toUser = paramString2;
  }
  
  public final HashMap<String, String> ly(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31603);
    long l = System.currentTimeMillis();
    if (bt.isNullOrNil(paramString2))
    {
      if (this.EZr.FcV.containsKey(paramString1)) {
        this.EZr.FcV.remove(paramString1);
      }
      AppMethodBeat.o(31603);
      return null;
    }
    if ((!this.EZr.FcV.containsKey(paramString1)) || (((LinkedList)this.EZr.FcV.get(paramString1)).size() <= 0))
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
      ((LinkedList)this.EZr.FcV.get(paramString1)).clear();
      AppMethodBeat.o(31603);
      return null;
    }
    paramString1 = (LinkedList)this.EZr.FcV.get(paramString1);
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
      ((HashMap)localObject).put("atuserlist", "<![CDATA[" + bt.m(paramString2, ",") + "]]>");
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
    fdO();
    fdN();
    Zk(getKeyBordHeightPX());
    AppMethodBeat.o(31579);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31643);
    super.onConfigurationChanged(paramConfiguration);
    if (com.tencent.mm.compatible.util.d.ly(24)) {
      this.EZO = ((Activity)getContext()).isInMultiWindowMode();
    }
    if (paramConfiguration.orientation == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.EZG = bool;
      g(0, false, -1);
      fdO();
      ad.i("MicroMsg.ChatFooter", "onConfigurationChanged: %s, %s, %s", new Object[] { paramConfiguration, Boolean.valueOf(this.EZG), Boolean.valueOf(this.EZO) });
      Zk(getKeyBordHeightPX());
      AppMethodBeat.o(31643);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(31580);
    super.onDetachedFromWindow();
    this.fQT.close();
    this.EZK = null;
    this.EZL = false;
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
    this.EZH = false;
    if ((this.EZM == 48) && (this.EZI == 1) && (!this.EZW))
    {
      this.uCj = false;
      h(0, true, -1);
    }
    this.fQT.close();
    if (this.pWJ != null) {
      this.pWJ.onPause();
    }
    if ((this.EUf) && (this.EUc != null)) {
      this.EUc.pause();
    }
    if (this.EZn != null) {
      this.EZn.onPause();
    }
    if (this.EZl != null) {
      this.EZl.hide();
    }
    if ((this.BoC != null) && (this.BoC.isShowing())) {
      this.BoC.dismiss();
    }
    fdQ();
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
    this.EYU.setAppPanelListener(parama);
    AppMethodBeat.o(31649);
  }
  
  public void setAppPanelTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(31595);
    if ((this.EZa == null) || (this.EYU == null))
    {
      AppMethodBeat.o(31595);
      return;
    }
    this.EZa.setText(paramCharSequence);
    if (!bt.ai(paramCharSequence)) {
      if (this.EYU.getVisibility() != 0) {
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
    if (this.EZa == null)
    {
      AppMethodBeat.o(31596);
      return;
    }
    if (TextUtils.isEmpty(this.EZa.getText()))
    {
      this.EZa.setVisibility(8);
      AppMethodBeat.o(31596);
      return;
    }
    if (paramBoolean)
    {
      localObject = this.EZa.getContext();
      i = this.EYZ.getHeight();
      int j = getKeyBordHeightPX();
      int k = com.tencent.mm.cc.a.fromDPToPix((Context)localObject, 32);
      localObject = this.EZa.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (i - j + k);
        this.EZa.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    Object localObject = this.EZa;
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
    this.EYU.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163214);
  }
  
  public void setAppPanelVisible(int paramInt)
  {
    AppMethodBeat.i(31642);
    if (this.EYU != null) {
      this.EYU.setVisibility(paramInt);
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
    this.EZr.FcT = paramString;
  }
  
  public void setBottomPanelVisibility(int paramInt)
  {
    AppMethodBeat.i(31644);
    if (paramInt == 0)
    {
      this.EYZ.setVisibility(paramInt);
      AppMethodBeat.o(31644);
      return;
    }
    g(0, true, -1);
    AppMethodBeat.o(31644);
  }
  
  public void setCattingRootLayoutId(int paramInt)
  {
    this.Fcq = null;
    this.Fcp = paramInt;
  }
  
  public void setDefaultSmileyByDetail(String paramString)
  {
    AppMethodBeat.i(31600);
    if (!bt.isNullOrNil(paramString))
    {
      if (this.pWJ == null) {
        fdo();
      }
      this.pWJ.setDefaultEmojiByDetail(paramString);
    }
    AppMethodBeat.o(31600);
  }
  
  @TargetApi(11)
  public void setEditTextOnDragListener(View.OnDragListener paramOnDragListener)
  {
    AppMethodBeat.i(31647);
    this.vBp.setOnDragListener(paramOnDragListener);
    AppMethodBeat.o(31647);
  }
  
  public void setExitType(int paramInt)
  {
    AppMethodBeat.i(185414);
    c.a locala = com.tencent.mm.plugin.transvoice.a.c.BBY;
    com.tencent.mm.plugin.transvoice.a.c.eru().setExitType(paramInt);
    AppMethodBeat.o(185414);
  }
  
  public void setFooterEventListener(b paramb)
  {
    this.EZn = paramb;
  }
  
  public void setFooterStatus(boolean paramBoolean) {}
  
  public void setFooterType(int paramInt)
  {
    AppMethodBeat.i(31576);
    this.DCQ = paramInt;
    if (this.pWJ != null) {
      this.pWJ.setFooterType(paramInt);
    }
    AppMethodBeat.o(31576);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(193517);
    if (this.vBp != null) {
      this.vBp.setHint(paramCharSequence);
    }
    AppMethodBeat.o(193517);
  }
  
  public void setIOnTodoViewCallback(z.c paramc)
  {
    this.EZX = paramc;
  }
  
  public void setIgnoreScroll(Boolean paramBoolean)
  {
    AppMethodBeat.i(31661);
    this.EZW = paramBoolean.booleanValue();
    AppMethodBeat.o(31661);
  }
  
  public void setInsertPos(int paramInt)
  {
    this.EZr.FcU = paramInt;
  }
  
  public void setIsMultiWindow(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(31667);
    ad.i("MicroMsg.ChatFooter", "setIsMultiWindow: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.EZO != paramBoolean) {}
    for (;;)
    {
      this.EZO = paramBoolean;
      fdO();
      if (i != 0)
      {
        Zk(getKeyBordHeightPX());
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
    this.uCj = paramBoolean.booleanValue();
    AppMethodBeat.o(31662);
  }
  
  public void setLastContent(String paramString)
  {
    this.EZr.FcS = paramString;
  }
  
  public void setLastQuoteMsgId(long paramLong)
  {
    AppMethodBeat.i(31605);
    if (paramLong != 0L)
    {
      bu localbu = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(paramLong);
      if (((localbu.eLr & 0x4) == 4) || (localbu.getType() == 10000))
      {
        ad.e("MicroMsg.ChatFooter", "msg(%s) is revoked!", new Object[] { localbu.getType() + "," + (localbu.eLr & 0x4) });
        com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(2131761359), "", true);
        AppMethodBeat.o(31605);
        return;
      }
      this.EZh.setTag(localbu);
      AppMethodBeat.o(31605);
      return;
    }
    this.EZh.setTag(null);
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
    this.EZt = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    AppMethodBeat.i(31623);
    ba(paramInt, true);
    AppMethodBeat.o(31623);
  }
  
  public void setOnEditFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(31648);
    this.vBp.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(31648);
  }
  
  public void setOnFooterPanelSwitchListener(f paramf)
  {
    this.EZp = paramf;
  }
  
  public void setOnFooterSwitchListener(g paramg)
  {
    AppMethodBeat.i(31650);
    this.EZo = paramg;
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
        AppMethodBeat.i(193486);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$50", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ChatFooter.bl(ChatFooter.this) != null) {
          ChatFooter.bl(ChatFooter.this).wg(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$50", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193486);
      }
    });
    AppMethodBeat.o(31650);
  }
  
  public void setRecordNormalWording(String paramString)
  {
    AppMethodBeat.i(31618);
    if ((paramString == null) || (this.EZx == null))
    {
      AppMethodBeat.o(31618);
      return;
    }
    this.EZx.setText(paramString);
    AppMethodBeat.o(31618);
  }
  
  public void setSetTolastCustomPage(boolean paramBoolean) {}
  
  public void setSmileyPanelCallback(f paramf)
  {
    AppMethodBeat.i(31592);
    this.ESn = paramf;
    if (this.pWJ != null) {
      this.pWJ.setCallback(paramf);
    }
    AppMethodBeat.o(31592);
  }
  
  public void setSmileyPanelCallback2(j paramj)
  {
    this.EZl.Feb = paramj;
  }
  
  public void setSwitchButtonMode(int paramInt)
  {
    AppMethodBeat.i(31651);
    if (paramInt == this.Fcf)
    {
      AppMethodBeat.o(31651);
      return;
    }
    this.Fcf = paramInt;
    ImageView localImageView1 = (ImageView)findViewById(2131305574);
    ImageView localImageView2 = (ImageView)findViewById(2131303025);
    if (this.Fcf == 1)
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
    this.Fab = paramc;
  }
  
  @TargetApi(11)
  public void setToSendTextColor(final boolean paramBoolean)
  {
    AppMethodBeat.i(31652);
    if (com.tencent.mm.compatible.util.d.ly(11))
    {
      com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a()
      {
        public final void run()
        {
          AppMethodBeat.i(31552);
          Message localMessage = new Message();
          localMessage.what = 1002;
          localMessage.obj = Boolean.valueOf(paramBoolean);
          ChatFooter.bm(ChatFooter.this).sendMessage(localMessage);
          AppMethodBeat.o(31552);
        }
      });
      AppMethodBeat.o(31652);
      return;
    }
    if (paramBoolean)
    {
      this.vBp.setTextColor(getResources().getColor(2131100636));
      AppMethodBeat.o(31652);
      return;
    }
    this.vBp.setTextColor(getResources().getColor(2131100482));
    wb(false);
    AppMethodBeat.o(31652);
  }
  
  public void setUserName(String paramString)
  {
    AppMethodBeat.i(31682);
    this.EYT = paramString;
    if (this.pWJ != null) {
      this.pWJ.setTalkerName(this.EYT);
    }
    if (this.EYU != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ChatFooter", "setusername: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (this.EYU == null) {
        break label167;
      }
      if ((!w.Ap(this.EYT)) && (!w.Ag(this.EYT))) {
        break;
      }
      this.EYU.setServiceShowFlag(0);
      AppMethodBeat.o(31682);
      return;
    }
    if (w.zE(this.EYT))
    {
      this.EYU.setServiceShowFlag(4);
      AppMethodBeat.o(31682);
      return;
    }
    if (w.vF(this.EYT))
    {
      this.EYU.setServiceShowFlag(2);
      AppMethodBeat.o(31682);
      return;
    }
    this.EYU.setServiceShowFlag(1);
    label167:
    AppMethodBeat.o(31682);
  }
  
  public void setVoice2txtCountDown(int paramInt)
  {
    AppMethodBeat.i(31619);
    if (-1 == paramInt)
    {
      this.Fao.setVisibility(0);
      this.Faq.setVisibility(8);
      AppMethodBeat.o(31619);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 10))
    {
      if (8 == this.Faq.getVisibility())
      {
        this.Fao.setVisibility(8);
        this.Faq.setVisibility(0);
      }
      if (this.Faq != null) {
        this.Faq.setImageResource(this.FbQ[paramInt]);
      }
    }
    AppMethodBeat.o(31619);
  }
  
  public void setVoiceInputShowCallback(d paramd)
  {
    this.Fac = paramd;
  }
  
  public void setVoiceReactArea(int paramInt)
  {
    AppMethodBeat.i(185401);
    if (this.FaN)
    {
      setNewVoice2TxtCountDown(paramInt);
      AppMethodBeat.o(185401);
      return;
    }
    if (paramInt < 10)
    {
      if (this.EZB)
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
    this.EYV = ((TextView)this.ize.findViewById(2131298212));
    this.vBp.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(31646);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(31656);
    if ((this.Faf != null) && (this.Faf.isSupportNavigationSwipeBack()) && (this.Faf.getSwipeBackLayout() != null)) {
      this.Faf.getSwipeBackLayout().setOnceDisEnableGesture(true);
    }
    if (!fdJ())
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
    ad.i("MicroMsg.ChatFooter", "onKeyboardHeightChanged: %s, %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(this.EZM) });
    if (!this.EZP)
    {
      AppMethodBeat.o(31670);
      return;
    }
    int i;
    if ((this.FaN) && (this.FaP != null) && (this.FaP.isShowing()))
    {
      Object localObject;
      if (paramInt <= 0)
      {
        this.FaT.setCursorVisible(false);
        this.uCj = false;
        this.Fbd.animate().translationY(0.0F).setDuration(200L).start();
        this.FaS.animate().translationY(0.0F).setDuration(200L).start();
        this.FaV.animate().translationY(0.0F).setDuration(200L).start();
        this.FaY.animate().translationY(0.0F).setDuration(200L).start();
        if (this.FaS.getHeight() < this.Fca)
        {
          localObject = ValueAnimator.ofInt(new int[] { this.FaS.getHeight(), this.Fca }).setDuration(200L);
          ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              AppMethodBeat.i(193489);
              int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
              ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).height = i;
              ChatFooter.az(ChatFooter.this).requestLayout();
              AppMethodBeat.o(193489);
            }
          });
          ((ValueAnimator)localObject).start();
          AppMethodBeat.o(31670);
        }
      }
      else
      {
        this.FaT.setCursorVisible(true);
        this.uCj = true;
        ad.d("MicroMsg.ChatFooter", "height:%s, WeUIToolHelper.getDisplayRealSize(getContext()).y - newVoice2txtOpeArea.getBottom():%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ar.ci(getContext()).y - this.Fbd.getBottom()) });
        i = ar.ci(getContext()).y;
        localObject = new int[2];
        this.Fbd.getLocationOnScreen((int[])localObject);
        j = localObject[1];
        int k = this.Fbd.getHeight();
        int m = ar.ej(getContext());
        this.Fbd.animate().translationY(-(paramInt - (i - (j + k)) + m)).setDuration(200L).start();
        paramInt = i - (this.Fbd.getHeight() + paramInt) - com.tencent.mm.ui.aq.fromDPToPix(getContext(), 24);
        i = this.FaS.getHeight() + this.FaV.getHeight() + com.tencent.mm.ui.aq.fromDPToPix(getContext(), 48);
        ad.d("MicroMsg.ChatFooter", "leftSpcaeDown:%s, editDown:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        this.FbZ = (paramInt - com.tencent.mm.ui.aq.fromDPToPix(getContext(), 52));
        if (this.FbZ < this.FbS)
        {
          ad.i("MicroMsg.ChatFooter", "invalid maxHeightWhenKeyboard, value:%s", new Object[] { Integer.valueOf(this.FbZ) });
          this.FbZ = this.FbS;
        }
        this.Fca = this.FaS.getHeight();
        localObject = new int[2];
        this.FaV.getLocationOnScreen((int[])localObject);
        j = localObject[1] + this.FaV.getHeight();
        if (j > paramInt)
        {
          j -= paramInt;
          if (i > paramInt)
          {
            k = this.FaS.getLayoutParams().height;
            localObject = ValueAnimator.ofInt(new int[] { k, k - (i - paramInt) }).setDuration(200L);
            ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
              {
                AppMethodBeat.i(193490);
                int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
                ChatFooter.az(ChatFooter.this).getLayoutParams().height = i;
                ChatFooter.az(ChatFooter.this).requestLayout();
                AppMethodBeat.o(193490);
              }
            });
            ((ValueAnimator)localObject).start();
          }
          this.FaS.animate().translationY(-j).setDuration(200L).start();
          this.FaV.animate().translationY(-j).setDuration(200L).start();
          this.FaY.animate().translationY(-j).setDuration(200L).start();
        }
      }
      AppMethodBeat.o(31670);
      return;
    }
    if ((!this.EZO) && (this.EZG))
    {
      if (this.EZR == paramBoolean) {
        break label824;
      }
      i = 1;
      this.EZR = paramBoolean;
      if (paramInt <= 0) {
        break label884;
      }
      if (this.nGK == paramInt) {
        break label956;
      }
      this.nGK = paramInt;
      com.tencent.mm.compatible.util.i.A(getContext(), paramInt);
      Zk(paramInt);
    }
    label824:
    label956:
    for (paramInt = 1;; paramInt = 0)
    {
      if (!this.uCj)
      {
        h(1, true, -1);
        this.EZJ = -1;
      }
      while ((paramInt == 0) && (i == 0))
      {
        this.uCj = true;
        if (this.EZn != null) {
          this.EZn.oo(this.uCj);
        }
        AppMethodBeat.o(31670);
        return;
        i = 0;
        break;
      }
      this.EZN = this.nGK;
      i = this.EZN;
      if (this.EZX == null) {}
      for (paramInt = j;; paramInt = this.EZX.dbF())
      {
        b(i, true, 1, paramInt);
        break;
      }
      label884:
      if (this.uCj)
      {
        if (this.EZJ == -1) {
          break label946;
        }
        h(this.EZJ, true, -1);
        this.EZJ = -1;
      }
      for (;;)
      {
        if (this.EZI == 1)
        {
          ad.i("MicroMsg.ChatFooter", "keyboard not open");
          h(0, true, -1);
        }
        this.uCj = false;
        break;
        h(0, true, -1);
      }
    }
  }
  
  public final void vS(boolean paramBoolean)
  {
    AppMethodBeat.i(31633);
    this.EYU.vS(paramBoolean);
    AppMethodBeat.o(31633);
  }
  
  public final void vT(boolean paramBoolean)
  {
    AppMethodBeat.i(31634);
    this.EYU.vT(paramBoolean);
    AppMethodBeat.o(31634);
  }
  
  public final void w(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(31607);
    if (dbD())
    {
      ad.i("MicroMsg.ChatFooter", "setLastText() isBackFromGroupSolitatire");
      AppMethodBeat.o(31607);
      return;
    }
    if ((paramBoolean) && ((paramString == null) || (paramString.length() == 0) || (this.vBp == null)))
    {
      this.vBp.setText("");
      fdk();
      AppMethodBeat.o(31607);
      return;
    }
    this.EZs = true;
    this.vBp.setText(k.b(getContext(), paramString, this.vBp.getTextSize()));
    this.EZs = false;
    if ((paramInt < 0) || (paramInt > this.vBp.getText().length()))
    {
      this.vBp.setSelection(this.vBp.getText().length());
      AppMethodBeat.o(31607);
      return;
    }
    this.vBp.setSelection(paramInt);
    AppMethodBeat.o(31607);
  }
  
  public final void wb(boolean paramBoolean)
  {
    AppMethodBeat.i(31588);
    ad.i("MicroMsg.ChatFooter", "pureForcusEdtChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.vBp });
    if (this.vBp == null)
    {
      AppMethodBeat.o(31588);
      return;
    }
    if (paramBoolean)
    {
      this.vBp.requestFocus();
      AppMethodBeat.o(31588);
      return;
    }
    this.vBp.clearFocus();
    AppMethodBeat.o(31588);
  }
  
  public final void wd(boolean paramBoolean)
  {
    AppMethodBeat.i(31654);
    ad.i("MicroMsg.ChatFooter", "withoutLastText: ");
    hideVKB();
    wb(paramBoolean);
    AppMethodBeat.o(31654);
  }
  
  public final void wf(boolean paramBoolean)
  {
    AppMethodBeat.i(163220);
    if (this.EZb == null)
    {
      ad.e("MicroMsg.ChatFooter", "mAttachButton is null");
      AppMethodBeat.o(163220);
      return;
    }
    if (this.EZc != null) {
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
        } while ((locala.EYG != 1) || (aMZ(locala.EYF)));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.EZc.setVisibility(0);
        AppMethodBeat.o(163220);
        return;
      }
      this.EZc.setVisibility(8);
      AppMethodBeat.o(163220);
      return;
    }
  }
  
  public static final class a
  {
    public String FcS;
    String FcT;
    int FcU;
    HashMap<String, LinkedList<HashMap<String, String>>> FcV;
    
    private a()
    {
      AppMethodBeat.i(31558);
      this.FcV = new HashMap();
      AppMethodBeat.o(31558);
    }
  }
  
  public static abstract interface b
  {
    public abstract com.tencent.mm.ui.chatting.i.b feo();
    
    public abstract com.tencent.mm.ui.chatting.e.a fep();
    
    public abstract String getTalkerUserName();
  }
  
  public static abstract interface c
  {
    public abstract void a(Boolean paramBoolean1, Boolean paramBoolean2);
    
    public abstract void b(Boolean paramBoolean1, Boolean paramBoolean2);
  }
  
  public static abstract interface d
  {
    public abstract void m(Boolean paramBoolean);
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(185398);
      FcW = new e("MODE_VOICE", 0);
      FcX = new e("MODE_CANCEL", 1);
      FcY = new e("MODE_TRANS", 2);
      FcZ = new e[] { FcW, FcX, FcY };
      AppMethodBeat.o(185398);
    }
    
    private e() {}
  }
  
  public static abstract interface f
  {
    public abstract void jo(int paramInt1, int paramInt2);
  }
  
  public static abstract interface g
  {
    public abstract boolean wg(boolean paramBoolean);
  }
  
  public static enum h
  {
    static
    {
      AppMethodBeat.i(185821);
      Fda = new h("SendVoice", 0);
      Fdb = new h("StopRecord", 1);
      Fdc = new h("Reset", 2);
      Fdd = new h("Cancel", 3);
      Fde = new h("Pause", 4);
      Fdf = new h("Error", 5);
      Fdg = new h[] { Fda, Fdb, Fdc, Fdd, Fde, Fdf };
      AppMethodBeat.o(185821);
    }
    
    private h() {}
  }
  
  public final class i
    implements TextWatcher
  {
    TextWatcher Fdh;
    private boolean Fdi;
    private boolean Fdj;
    
    public i(TextWatcher paramTextWatcher)
    {
      AppMethodBeat.i(31559);
      this.Fdi = false;
      this.Fdj = com.tencent.mm.compatible.util.d.lz(11);
      this.Fdh = paramTextWatcher;
      AppMethodBeat.o(31559);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      boolean bool = true;
      AppMethodBeat.i(31560);
      if ((ChatFooter.j(ChatFooter.this)) && (this.Fdi) && (paramEditable.length() > 0))
      {
        this.Fdi = false;
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
      this.Fdh.afterTextChanged(paramEditable);
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
      this.Fdh.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      ad.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
      AppMethodBeat.o(31561);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(31562);
      if ((ChatFooter.j(ChatFooter.this)) && (paramInt2 == 0) && (paramInt1 == paramCharSequence.length() - 1) && (paramInt3 == 1) && (paramCharSequence.charAt(paramCharSequence.length() - 1) == '\n'))
      {
        ad.i("MicroMsg.ChatFooter", "text changed, enter button");
        this.Fdi = true;
        AppMethodBeat.o(31562);
        return;
      }
      this.Fdh.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      ChatFooter.this.Faa.dPQ += 1L;
      ChatFooter.this.Faa.RG();
      if (ChatFooter.this.Faa.dPN == 0L) {
        ChatFooter.this.Faa.RF();
      }
      AppMethodBeat.o(31562);
    }
  }
  
  static enum j
  {
    static
    {
      AppMethodBeat.i(31565);
      Fdk = new j("MODE_INVALID", 0);
      Fdl = new j("MODE_BLUR", 1);
      Fdm = new j("MODE_NORMAL", 2);
      Fdn = new j[] { Fdk, Fdl, Fdm };
      AppMethodBeat.o(31565);
    }
    
    private j() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter
 * JD-Core Version:    0.7.0.1
 */