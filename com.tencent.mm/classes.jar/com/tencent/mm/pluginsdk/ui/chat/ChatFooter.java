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
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
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
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.chatting.d.b.at;
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
  private static int FsH;
  private static final int[] FuB;
  private static final int[] FuC;
  public static final String FuM;
  private static int count;
  private final long ANIMATION_DURATION;
  public o BGb;
  private TextView BGc;
  private ImageView BGd;
  public View BGe;
  private int BSY;
  com.tencent.mm.plugin.transvoice.a.b BUY;
  private String BVd;
  private int BVe;
  private aw BVf;
  private boolean BVg;
  private com.tencent.mm.sdk.platformtools.aq BVi;
  private com.tencent.mm.modelvoiceaddr.b.b BVr;
  private List<String> BVs;
  private int BWW;
  private int DUO;
  f FkI;
  public boolean FmA;
  public n Fmx;
  public ImageView FrA;
  public ImageButton FrB;
  public View FrC;
  private com.tencent.mm.ui.widget.a.d FrD;
  public LinearLayout FrE;
  public RelativeLayout FrF;
  private TextView FrG;
  private WeImageView FrH;
  private i FrI;
  public m FrJ;
  private com.tencent.mm.plugin.groupsolitaire.ui.d FrK;
  private b FrL;
  private g FrM;
  private f FrN;
  private ClipboardManager FrO;
  public final a FrP;
  public boolean FrQ;
  private boolean FrR;
  public boolean FrS;
  private ImageView FrT;
  public ViewGroup FrU;
  private TextView FrV;
  private View FrW;
  private InputMethodManager FrX;
  private int FrY;
  private boolean FrZ;
  public String Frr;
  public AppPanel Frs;
  public TextView Frt;
  private Button Fru;
  public ImageButton Frv;
  private View Frw;
  public ChatFooterBottom Frx;
  private TextView Fry;
  public ImageButton Frz;
  public d FsA;
  private m.a FsB;
  private boolean FsC;
  public MMFragment FsD;
  public b FsE;
  private Animation FsF;
  private Animation FsG;
  public ViewGroup FsI;
  private View FsJ;
  private BlurView FsK;
  private View FsL;
  private View FsM;
  private ImageView FsN;
  private ImageView FsO;
  private View FsP;
  private TextView FsQ;
  private ImageView FsR;
  private View FsS;
  private View FsT;
  private WeImageView FsU;
  private TextView FsV;
  private View FsW;
  private WeImageView FsX;
  private TextView FsY;
  private View FsZ;
  private boolean Fsa;
  private boolean Fsb;
  public boolean Fsc;
  public boolean Fsd;
  private boolean Fse;
  private boolean Fsf;
  public int Fsg;
  private int Fsh;
  private ChattingScrollLayout Fsi;
  private boolean Fsj;
  private int Fsk;
  private int Fsl;
  private boolean Fsm;
  private boolean Fsn;
  private int Fso;
  private boolean Fsp;
  private int Fsq;
  private int Fsr;
  private int Fss;
  private int Fst;
  private boolean Fsu;
  private z.c Fsv;
  private z.a Fsw;
  private d.c Fsx;
  com.tencent.mm.g.b.a.d Fsy;
  public c Fsz;
  private TextView FtA;
  private ViewGroup FtB;
  private ViewGroup FtC;
  private View FtD;
  private View FtE;
  private WeImageView FtF;
  private WeImageView FtG;
  private View FtH;
  private View FtI;
  private ViewGroup FtJ;
  private View FtK;
  private View FtL;
  private WeImageView FtM;
  private WeImageView FtN;
  private View FtO;
  private View FtP;
  private WeImageView FtQ;
  private ViewGroup FtR;
  private View FtS;
  private View FtT;
  private View FtU;
  private WeImageView FtV;
  private View FtW;
  private int FtX;
  private int FtY;
  private boolean FtZ;
  private BlurView Fta;
  private com.tencent.mm.plugin.transvoice.ui.b Ftb;
  private com.tencent.mm.plugin.transvoice.a.a Ftc;
  private com.tencent.mm.modelvoiceaddr.h Ftd;
  public o Fte;
  private com.tencent.mm.plugin.transvoice.a.c Ftf;
  private ChatFooter.l Ftg;
  private j Fth;
  private k Fti;
  private boolean Ftj;
  private boolean Ftk;
  public boolean Ftl;
  private float Ftm;
  private o Ftn;
  private View Fto;
  private View Ftp;
  private ViewGroup Ftq;
  private EditText Ftr;
  private SoundWaveView Fts;
  private ImageView Ftt;
  private ViewGroup Ftu;
  private TextView Ftv;
  private WeImageView Ftw;
  public LanguageChoiceLayout Ftx;
  private TextView Fty;
  private ViewGroup Ftz;
  private int FuA;
  private int FuD;
  private boolean FuE;
  private final int FuF;
  private final int FuG;
  private volatile boolean FuH;
  private com.tencent.mm.sdk.platformtools.aq FuI;
  private boolean FuJ;
  private int FuK;
  private boolean FuL;
  private int FuN;
  private View FuO;
  private int FuP;
  private int FuQ;
  private int FuR;
  private int FuS;
  private int FuT;
  private int FuU;
  private Runnable FuV;
  private Runnable FuW;
  private int FuX;
  private int FuY;
  e FuZ;
  private ChatFooterPanel.a Fua;
  private AppPanel.b Fub;
  private b Fuc;
  public i Fud;
  private int Fue;
  private boolean Fuf;
  private int Fug;
  private TextWatcher Fuh;
  ValueAnimator Fui;
  ValueAnimator Fuj;
  ValueAnimator Fuk;
  ValueAnimator Ful;
  ValueAnimator Fum;
  ValueAnimator.AnimatorUpdateListener Fun;
  private int[] Fuo;
  private final int Fup;
  private final int Fuq;
  private final int Fur;
  private final int Fus;
  private final int Fut;
  private final int Fuu;
  private final float Fuv;
  private int Fuw;
  private int Fux;
  private int Fuy;
  private int Fuz;
  e Fva;
  private Map<Integer, String> Fvb;
  private boolean Fvc;
  private Activity activity;
  private String dzZ;
  private com.tencent.mm.ui.tools.h fSZ;
  private boolean gnu;
  public Button gpu;
  private View iBX;
  private ViewGroup iOJ;
  public final com.tencent.mm.sdk.platformtools.aq mHandler;
  private int maxHeight;
  private int nMm;
  private final com.tencent.mm.sdk.platformtools.aq pAg;
  private boolean pzT;
  public ChatFooterPanel qdo;
  public View rFt;
  private ImageView rFu;
  public View rFv;
  public View rFw;
  private String toUser;
  public boolean uNO;
  public MMEditText vNt;
  
  static
  {
    AppMethodBeat.i(31717);
    count = 0;
    FuB = new int[] { 0, 15, 30, 45, 60, 75, 90, 95, 100 };
    FuC = new int[] { 2131689547, 2131689548, 2131689549, 2131689550, 2131689551, 2131689552, 2131689553, 2131689554 };
    FuM = ak.getPackageName() + "chat_footer_sp";
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
    this.iBX = null;
    this.vNt = null;
    this.gpu = null;
    this.Frt = null;
    this.FrM = null;
    this.FrN = null;
    this.FrO = null;
    this.FrP = new a((byte)0);
    this.FrQ = false;
    this.FrR = false;
    this.FrS = false;
    this.pzT = false;
    this.Fsa = false;
    this.Fsb = false;
    this.Fsc = false;
    this.FmA = false;
    this.Fsd = false;
    this.Fse = true;
    this.Fsf = false;
    this.Fsg = 0;
    this.Fsh = -1;
    this.Fsl = 0;
    this.uNO = false;
    this.Fsm = false;
    this.Fsn = true;
    this.Fso = 0;
    this.Fsp = false;
    this.Fsu = false;
    this.Fsv = null;
    this.Fsw = new z.a()
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
    this.Fsx = new d.c()
    {
      public final int dew()
      {
        AppMethodBeat.i(185759);
        if (ChatFooter.b(ChatFooter.this) != null)
        {
          int i = ChatFooter.b(ChatFooter.this).dew();
          AppMethodBeat.o(185759);
          return i;
        }
        AppMethodBeat.o(185759);
        return 0;
      }
      
      public final boolean dex()
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
    this.Fsy = new com.tencent.mm.g.b.a.d();
    this.FsB = new m.a()
    {
      public final void clear()
      {
        AppMethodBeat.i(185778);
        ChatFooter.this.dey();
        AppMethodBeat.o(185778);
      }
    };
    this.mHandler = new com.tencent.mm.sdk.platformtools.aq()
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
    this.FsC = false;
    this.gnu = false;
    paramAttributeSet = com.tencent.mm.plugin.transvoice.a.c.BTw;
    this.Ftf = com.tencent.mm.plugin.transvoice.a.c.evb();
    this.Ftg = ChatFooter.l.FvQ;
    this.Fth = j.FvI;
    this.Fti = k.FvM;
    this.Ftj = false;
    this.Ftk = false;
    this.Ftl = false;
    this.Ftm = 0.5F;
    this.FtZ = true;
    this.Fua = new ChatFooterPanel.a()
    {
      public final void apc()
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
        ChatFooter.this.Fsy.dRi -= 1L;
        AppMethodBeat.o(185771);
      }
      
      public final void apd()
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
          ChatFooter.d(ChatFooter.this).aZf(paramAnonymousString);
          ChatFooter.this.Fsy.dRi += 1L;
          AppMethodBeat.o(185772);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.ChatFooter", paramAnonymousString, "", new Object[0]);
          }
        }
      }
      
      public final void dW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185770);
        ae.i("MicroMsg.ChatFooter", "onToSendTextEnable: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
    this.Fub = new AppPanel.b()
    {
      public final void fgU()
      {
        AppMethodBeat.i(185773);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ChatFooter.e(ChatFooter.this), "android.permission.RECORD_AUDIO", 80, "", "");
        ae.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), ChatFooter.e(ChatFooter.this) });
        if (!bool)
        {
          AppMethodBeat.o(185773);
          return;
        }
        int i = bc.ajj().aFd();
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
    this.Fuc = new b()
    {
      public final com.tencent.mm.ui.chatting.i.b fie()
      {
        return null;
      }
      
      public final com.tencent.mm.ui.chatting.e.a fif()
      {
        return null;
      }
      
      public final String getTalkerUserName()
      {
        AppMethodBeat.i(186752);
        if (ChatFooter.f(ChatFooter.this) == null)
        {
          str = ChatFooter.av(ChatFooter.this);
          AppMethodBeat.o(186752);
          return str;
        }
        String str = ChatFooter.f(ChatFooter.this).getTalkerUserName();
        AppMethodBeat.o(186752);
        return str;
      }
    };
    this.pAg = new com.tencent.mm.sdk.platformtools.aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(186757);
        super.handleMessage(paramAnonymousMessage);
        ae.d("MicroMsg.ChatFooter", "pennqin, dismiss window by too short.");
        ChatFooter.x(ChatFooter.this).setBackgroundResource(2131232725);
        ChatFooter.x(ChatFooter.this).setEnabled(true);
        if (ChatFooter.this.Ftl)
        {
          ChatFooter.ay(ChatFooter.this);
          t.v(ChatFooter.this.getContext(), ChatFooter.this.getContext().getResources().getString(2131757096), 2131691379);
          AppMethodBeat.o(186757);
          return;
        }
        if (ChatFooter.L(ChatFooter.this) != null) {
          ChatFooter.L(ChatFooter.this).dismiss();
        }
        AppMethodBeat.o(186757);
      }
    };
    this.Fue = 0;
    this.Fuf = false;
    this.Fug = 1;
    this.Fuh = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(186758);
        int i;
        int j;
        int m;
        int k;
        if (paramAnonymousEditable != null)
        {
          i = ChatFooter.az(ChatFooter.this).getWidth();
          j = ChatFooter.aA(ChatFooter.this).getLineCount();
          m = j - ChatFooter.aB(ChatFooter.this);
          if ((m != 0) && (ChatFooter.this.FuZ == ChatFooter.e.Fvw) && (i == ChatFooter.aC(ChatFooter.this)))
          {
            i = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), 5);
            k = ChatFooter.aA(ChatFooter.this).getLineHeight() * m;
            if (m <= 0) {
              break label251;
            }
            m = ChatFooter.az(ChatFooter.this).getHeight();
            if (!ChatFooter.this.uNO) {
              break label257;
            }
            ChatFooter.c(ChatFooter.this, Math.min(Math.max(ChatFooter.aD(ChatFooter.this), i + (m + k)), ChatFooter.aE(ChatFooter.this)));
          }
        }
        for (;;)
        {
          ae.d("MicroMsg.ChatFooter", "afterTextChanged transHeight:%s, nowLineCount:%s, lastLineCount:%s", new Object[] { Integer.valueOf(ChatFooter.aG(ChatFooter.this)), Integer.valueOf(j), Integer.valueOf(ChatFooter.aB(ChatFooter.this)) });
          ChatFooter.aH(ChatFooter.this);
          ChatFooter.d(ChatFooter.this, j);
          if (1 == ChatFooter.z(ChatFooter.this).BTu) {
            ChatFooter.z(ChatFooter.this).BTt = 1;
          }
          AppMethodBeat.o(186758);
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
    this.Fui = ValueAnimator.ofInt(new int[] { 250, 960 }).setDuration(200L);
    this.Fuj = ValueAnimator.ofInt(new int[] { 40, 800 }).setDuration(200L);
    this.Fuk = ValueAnimator.ofInt(new int[] { 72, 0 }).setDuration(200L);
    this.Ful = ValueAnimator.ofInt(new int[] { 22, 0 }).setDuration(200L);
    this.Fum = ValueAnimator.ofInt(new int[] { 8, 0 }).setDuration(200L);
    this.Fun = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(31546);
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)ChatFooter.bf(ChatFooter.this).getLayoutParams();
        FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)ChatFooter.bg(ChatFooter.this).getLayoutParams();
        if (ChatFooter.this.Fui == paramAnonymousValueAnimator)
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
          if (ChatFooter.this.Fuj == paramAnonymousValueAnimator)
          {
            localLayoutParams1.height = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.height = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Fuk == paramAnonymousValueAnimator)
          {
            localLayoutParams1.topMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.topMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Ful == paramAnonymousValueAnimator)
          {
            localLayoutParams1.rightMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.rightMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Fum == paramAnonymousValueAnimator)
          {
            localLayoutParams1.bottomMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.bottomMargin = com.tencent.mm.ui.aq.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        }
      }
    };
    this.Fuo = new int[] { 2131689996, 2131689997, 2131689998, 2131689999, 2131690000, 2131690001, 2131690002, 2131690003, 2131690004, 2131690005 };
    this.ANIMATION_DURATION = 200L;
    this.Fup = 60;
    this.Fuq = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 114);
    this.Fur = (com.tencent.mm.ui.ar.ck(getContext()).x - com.tencent.mm.ui.aq.fromDPToPix(getContext(), 32));
    this.Fus = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 92);
    this.Fut = Math.min(com.tencent.mm.ui.aq.fromDPToPix(getContext(), 320), com.tencent.mm.ui.ar.ck(getContext()).x - com.tencent.mm.ui.aq.fromDPToPix(getContext(), 32));
    this.Fuu = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 176);
    this.Fuv = (com.tencent.mm.ui.aq.fromDPToPix(getContext(), 160) / 50.0F);
    this.Fuw = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 114);
    this.maxHeight = 0;
    this.Fux = 0;
    this.Fuy = 0;
    this.BWW = 0;
    this.Fuz = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 176);
    this.FuA = 60;
    this.FuD = 0;
    this.FuE = false;
    this.FuF = 4097;
    this.FuG = 4098;
    this.FuI = new com.tencent.mm.sdk.platformtools.aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(186775);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(186775);
          return;
          ChatFooter.h(ChatFooter.this, true);
          paramAnonymousMessage = ChatFooter.bs(ChatFooter.this).getLayoutParams();
          int i = ChatFooter.bs(ChatFooter.this).getBottom() - ChatFooter.bs(ChatFooter.this).getTop();
          if (ChatFooter.this.fhz())
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
            AppMethodBeat.o(186775);
            return;
          }
          paramAnonymousMessage.height = Math.max(i - 60, 1);
          ae.e("MicroMsg.ChatFooter", "mBottomPanelAnim:bottomPanel height:" + paramAnonymousMessage.height);
          ChatFooter.bs(ChatFooter.this).setLayoutParams(paramAnonymousMessage);
          ChatFooter.bt(ChatFooter.this);
        }
      }
    };
    this.FuJ = false;
    this.FuK = 0;
    this.FuL = false;
    this.FuN = -1;
    this.FuO = null;
    this.FuP = com.tencent.mm.ui.aq.ay(getContext(), 2131165229);
    this.FuQ = com.tencent.mm.ui.aq.ay(getContext(), 2131165294);
    this.FuR = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 25);
    this.FuS = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 55);
    this.FuT = 0;
    this.FuU = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 50);
    this.FuV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186786);
        ChatFooter.this.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185808);
            if (ChatFooter.k.FvO == ChatFooter.ai(ChatFooter.this))
            {
              ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764709));
              ChatFooter.al(ChatFooter.this);
            }
            for (;;)
            {
              ChatFooter.bx(ChatFooter.this);
              AppMethodBeat.o(185808);
              return;
              ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764713));
              ChatFooter.aj(ChatFooter.this);
            }
          }
        }, 100L);
        AppMethodBeat.o(186786);
      }
    };
    this.FuW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186787);
        ChatFooter.H(ChatFooter.this).dismiss();
        AppMethodBeat.o(186787);
      }
    };
    this.FuX = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 16);
    this.FuY = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 25);
    this.FuZ = e.Fvu;
    this.Fva = this.FuZ;
    this.Fvb = new HashMap();
    this.Fvc = false;
    this.BVr = new com.tencent.mm.modelvoiceaddr.b.b();
    this.BVs = new ArrayList();
    this.BVd = "";
    this.BVe = 0;
    this.BVg = false;
    this.BSY = com.tencent.mm.modelvoiceaddr.g.iBb;
    long l = System.currentTimeMillis();
    this.FrX = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.iBX = inflate(paramContext, 2131493397, this);
    this.vNt = ((MMEditText)this.iBX.findViewById(2131298072));
    this.fSZ = new com.tencent.mm.ui.tools.h((Activity)paramContext);
    this.fSZ.Lfj = this;
    this.FrO = ((ClipboardManager)paramContext.getApplicationContext().getSystemService("clipboard"));
    if (al.fBP()) {
      this.vNt.setImeOptions(268435456);
    }
    paramAttributeSet = com.tencent.mm.ui.tools.b.c.d(this.vNt);
    paramInt = 8192;
    if (com.tencent.mm.kernel.g.ajM()) {
      paramInt = bu.getInt(com.tencent.mm.n.g.acL().getValue("InputLimitSessionTextMsg"), 8192);
    }
    paramAttributeSet.afD(paramInt * 2).a(null);
    this.vNt.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
    this.vNt.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(186794);
        ae.i("MicroMsg.ChatFooter", "onFocusChange: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(186794);
      }
    });
    if (Build.VERSION.SDK_INT == 28) {
      this.vNt.setBreakStrategy(1);
    }
    paramAttributeSet = new qq();
    paramAttributeSet.dGo.dGq = this.vNt;
    paramAttributeSet.dGo.dGp = new com.tencent.mm.pluginsdk.ui.a.a()
    {
      public final void aNZ(final String paramAnonymousString)
      {
        AppMethodBeat.i(185818);
        ae.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", new Object[] { paramAnonymousString });
        if ((bu.isNullOrNil(ChatFooter.f(ChatFooter.this).getTalkerUserName())) || (bu.isNullOrNil(paramAnonymousString)))
        {
          ae.e("MicroMsg.ChatFooter", "onImageReceived, error args");
          AppMethodBeat.o(185818);
          return;
        }
        com.tencent.mm.ui.base.h.a(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(2131758654), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2Int = 1;
            AppMethodBeat.i(185817);
            boolean bool = v.f(paramAnonymousString, ChatFooter.f(ChatFooter.this).getTalkerUserName(), true);
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
    com.tencent.mm.sdk.b.a.IvT.l(paramAttributeSet);
    this.FrE = ((LinearLayout)this.iBX.findViewById(2131305724));
    this.FrC = this.iBX.findViewById(2131305739);
    this.Frx = ((ChatFooterBottom)findViewById(2131298067));
    this.iOJ = ((ViewGroup)findViewById(2131297957));
    this.Frw = findViewById(2131298090);
    this.Frz = ((ImageButton)this.iBX.findViewById(2131298054));
    this.FrA = ((ImageView)this.iBX.findViewById(2131298055));
    this.gpu = ((Button)this.iBX.findViewById(2131298168));
    this.FrF = ((RelativeLayout)this.iBX.findViewById(2131302539));
    this.FrG = ((TextView)this.iBX.findViewById(2131302537));
    this.FrH = ((WeImageView)this.iBX.findViewById(2131302538));
    this.FrT = ((ImageView)this.iBX.findViewById(2131308512));
    this.gpu.setTextSize(0, com.tencent.mm.cb.a.ay(paramContext, 2131165563) * com.tencent.mm.cb.a.ip(paramContext));
    this.Fru = ((Button)this.iBX.findViewById(2131306529));
    this.Frv = ((ImageButton)findViewById(2131298149));
    ol(false);
    fhI();
    this.FrI = new i(getContext(), getRootView(), this, new i.a()
    {
      public final void aOx(String paramAnonymousString)
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
    this.FrI.Fwp = this;
    paramAttributeSet = getContext();
    getRootView();
    this.FrJ = new m(paramAttributeSet);
    this.FrJ.FsB = this.FsB;
    ae.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[] { Integer.valueOf(this.vNt.getImeOptions()) });
    this.vNt.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.vNt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(185754);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$12", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        ChatFooter.this.setToSendTextColor(true);
        if (ChatFooter.l(ChatFooter.this) != null) {
          ChatFooter.l(ChatFooter.this).T(paramAnonymousMotionEvent);
        }
        ChatFooter.m(ChatFooter.this);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$12", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(185754);
        return false;
      }
    });
    this.vNt.setOnLongClickListener(new ChatFooter.5(this, paramContext));
    this.vNt.setCustomSelectionActionModeCallback(new ChatFooter.6(this, paramContext));
    this.gpu.setOnClickListener(new View.OnClickListener()
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            paramAnonymousView = ChatFooter.d(ChatFooter.this).getText().toString();
            ae.i("MicroMsg.ChatFooter", "send msg onClick");
            if ((paramAnonymousView.trim().length() == 0) && (paramAnonymousView.length() != 0))
            {
              ae.d("MicroMsg.ChatFooter", "empty message cant be sent");
              if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
                ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.h.l(ChatFooter.this.getContext(), 2131757154, 2131755906));
              }
              ChatFooter.this.fhF();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(31499);
              return;
            }
            ChatFooter.c(ChatFooter.this, false);
            int i = ChatFooter.d(ChatFooter.this).getPasterLen();
            ae.i("MicroMsg.ChatFooter", "pasteLen %d", new Object[] { Integer.valueOf(i) });
            if ((i > 0) && (ChatFooter.o(ChatFooter.this) != null))
            {
              localObject = ChatFooter.o(ChatFooter.this).getText();
              if ((localObject != null) && (bu.nullAsNil(((CharSequence)localObject).toString()).equals(paramAnonymousView)))
              {
                ae.i("MicroMsg.ChatFooter", "paste clip board to send");
                ChatFooter.c(ChatFooter.this, true);
              }
            }
            if (ChatFooter.p(ChatFooter.this) == null) {
              break label369;
            }
            localObject = ChatFooter.p(ChatFooter.this);
            if (((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).uOg == null) {
              break label364;
            }
            bool = ((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).uOg.isShowing();
          }
          finally {}
          if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0) && (ChatFooter.l(ChatFooter.this) != null)) {
            ChatFooter.this.dey();
          }
          ChatFooter.a(ChatFooter.this, paramAnonymousView.length());
          if (ChatFooter.a(ChatFooter.this, paramAnonymousView))
          {
            ae.i("MicroMsg.ChatFooter", "this is a quote msg");
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
                ae.i("MicroMsg.ChatFooter", "this is a group solitatire msg");
                break;
              }
              if ((ChatFooter.l(ChatFooter.this) == null) || (!ChatFooter.l(ChatFooter.this).aqs(paramAnonymousView))) {
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
    if (al.fBO()) {}
    label2320:
    for (;;)
    {
      boolean bool = false;
      label1696:
      this.Ftl = bool;
      this.Ftm = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOQ, 0.5F);
      ae.i("MicroMsg.ChatFooter", "isNewTrans2Txt:%s, transOperationAreaFactor:%s", new Object[] { Boolean.valueOf(this.Ftl), Float.valueOf(this.Ftm) });
      this.Ftc = new com.tencent.mm.plugin.transvoice.a.a();
      if (this.Ftl)
      {
        this.FtY = ((int)(com.tencent.mm.cb.a.iu(paramContext) * this.Ftm));
        ae.d("MicroMsg.ChatFooter", "newVoice2txtVoiceModeChangeLine: %s, newVoice2txtTransModeChangeLine: %s.", new Object[] { Integer.valueOf(this.FtX), Integer.valueOf(this.FtY) });
        this.Fru.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(31512);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$22", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            if (paramAnonymousView != ChatFooter.x(ChatFooter.this))
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$22", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(31512);
              return false;
            }
            if (ChatFooter.this.FuZ == ChatFooter.e.Fvu)
            {
              ChatFooter.b(ChatFooter.this, com.tencent.mm.ui.ar.ck(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(2131166976) - as.en(paramContext));
              switch (paramAnonymousMotionEvent.getAction())
              {
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$22", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(31512);
              return true;
              ChatFooter.b(ChatFooter.this, com.tencent.mm.ui.ar.ck(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(2131166976) - as.en(paramContext) + ChatFooter.y(ChatFooter.this));
              break;
              ChatFooter.z(ChatFooter.this).BTr = 1;
              paramAnonymousView = com.tencent.mm.cj.a.Jmx;
              com.tencent.mm.cj.a.xc(false);
              ChatFooter.z(ChatFooter.this).mSh = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).BTe = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.z(ChatFooter.this).BTf = ((int)paramAnonymousMotionEvent.getRawY());
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
                ChatFooter.l(ChatFooter.this).doa();
              }
              ChatFooter.x(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757050));
              continue;
              if ((ChatFooter.C(ChatFooter.this) == null) || (!ChatFooter.C(ChatFooter.this).isShowing()))
              {
                ae.e("MicroMsg.NewVoice2txt", "window status err!!!");
              }
              else if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getX() < ChatFooter.x(ChatFooter.this).getWidth()) && (paramAnonymousMotionEvent.getRawY() > ChatFooter.D(ChatFooter.this)))
              {
                if (ChatFooter.this.FuZ != ChatFooter.e.Fvu)
                {
                  ChatFooter.this.Fva = ChatFooter.this.FuZ;
                  ChatFooter.this.FuZ = ChatFooter.e.Fvu;
                  ChatFooter.E(ChatFooter.this);
                }
              }
              else if (paramAnonymousMotionEvent.getRawX() > ChatFooter.F(ChatFooter.this))
              {
                if (ChatFooter.e.Fvw != ChatFooter.this.FuZ)
                {
                  ChatFooter.this.Fva = ChatFooter.this.FuZ;
                  ChatFooter.this.FuZ = ChatFooter.e.Fvw;
                  ChatFooter.E(ChatFooter.this);
                }
              }
              else if (ChatFooter.e.Fvv != ChatFooter.this.FuZ)
              {
                ChatFooter.this.Fva = ChatFooter.this.FuZ;
                ChatFooter.this.FuZ = ChatFooter.e.Fvv;
                ChatFooter.E(ChatFooter.this);
                continue;
                ae.d("MicroMsg.NewVoice2txt", "begin finishCutShortSentence.");
                ChatFooter.B(ChatFooter.this).euY();
                ae.d("MicroMsg.NewVoice2txt", "end finishCutShortSentence.");
                ChatFooter.z(ChatFooter.this).BTg = System.currentTimeMillis();
                ChatFooter.z(ChatFooter.this).BTh = ((int)paramAnonymousMotionEvent.getRawX());
                ChatFooter.z(ChatFooter.this).BTi = ((int)paramAnonymousMotionEvent.getRawY());
                if ((ChatFooter.this.BUY != null) && (ChatFooter.G(ChatFooter.this)))
                {
                  ChatFooter.this.BUY.BSZ = false;
                  paramAnonymousView = ChatFooter.this.BUY;
                  ae.d("MicroMsg.SceneVoiceInputAddr2", "reTrigger!!! canReTrigger: %s.", new Object[] { Boolean.valueOf(paramAnonymousView.BTa) });
                  if ((paramAnonymousView.BTa) && ((!((com.tencent.mm.modelvoiceaddr.c)paramAnonymousView.iAY).aOk()) || (!com.tencent.mm.kernel.g.ajj().a(paramAnonymousView.iAY, 0)))) {
                    paramAnonymousView.eva();
                  }
                }
                if ((ChatFooter.this.getContext() instanceof Activity)) {
                  ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                }
                ChatFooter.this.fhH();
              }
            }
          }
        });
        this.Fui.addUpdateListener(this.Fun);
        this.Fuj.addUpdateListener(this.Fun);
        this.Fuk.addUpdateListener(this.Fun);
        this.Ful.addUpdateListener(this.Fun);
        this.Fum.addUpdateListener(this.Fun);
      }
      for (;;)
      {
        this.Frv.setOnClickListener(new ChatFooter.14(this));
        fhe();
        this.Frz.setVisibility(0);
        this.Frz.setContentDescription(getContext().getString(2131757042));
        this.Frz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = -1;
            AppMethodBeat.i(31504);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
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
                  if (((a.a)localObject2).Fra == 1)
                  {
                    k = j;
                    if (!ChatFooter.aOw(((a.a)localObject2).FqZ))
                    {
                      localObject2 = ((a.a)localObject2).FqZ;
                      ay.aRW("plus_uncertain_enter").edit().putBoolean((String)localObject2, true);
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
            localChatFooter.FrA.setVisibility(8);
            ((ImageButton)localObject1).setTag(Integer.valueOf(i));
            ChatFooter.this.fV(paramAnonymousView);
            if ((v.aBt().booleanValue()) && (ChatFooter.this.Fsz != null))
            {
              paramAnonymousView = ChatFooter.this.Fsz;
              localObject1 = Boolean.TRUE;
              paramAnonymousView.a((Boolean)localObject1, (Boolean)localObject1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(31504);
          }
        });
        ae.i("MicroMsg.ChatFooter", "[init]");
        this.Frw.setOnTouchListener(new ChatFooter.8(this));
        this.Fsk = (((Activity)paramContext).getWindow().getAttributes().softInputMode & 0xF0);
        if ((this.Fsk != 16) && (this.Fsk != 48))
        {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1062, 8);
          if (this.Fsk != 16) {
            this.Fsk = 48;
          }
        }
        this.Fsr = com.tencent.mm.sdk.platformtools.aa.iN(paramContext);
        ZQ(getKeyBordHeightPX());
        if (com.tencent.mm.compatible.util.d.lA(24)) {
          this.Fsm = ((Activity)getContext()).isInMultiWindowMode();
        }
        fhd();
        this.FrH.setOnClickListener(new ChatFooter.9(this));
        ae.d("MicroMsg.ChatFooter", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(31573);
        return;
        if (aoA()) {
          break;
        }
        paramAttributeSet = ad.iR(ak.getContext());
        if ((!paramAttributeSet.equals("zh_CN")) && (!paramAttributeSet.equals("zh_HK")) && (!paramAttributeSet.equals("zh_TW")) && (!paramAttributeSet.equals("en"))) {
          break;
        }
        if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.DEBUG))
        {
          bool = true;
          break label1696;
        }
        if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOP, 1)) {
          break label2320;
        }
        bool = true;
        break label1696;
        FsH = com.tencent.mm.cb.a.iu(paramContext) / 2 + com.tencent.mm.cb.a.fromDPToPix(paramContext, 30);
        this.Ftb = new com.tencent.mm.plugin.transvoice.ui.b(paramContext);
        this.Ftb.BVu = new b.d()
        {
          public final void aEA(String paramAnonymousString)
          {
            AppMethodBeat.i(185766);
            if (ChatFooter.l(ChatFooter.this) != null) {
              ChatFooter.l(ChatFooter.this).aqt(paramAnonymousString);
            }
            AppMethodBeat.o(185766);
          }
          
          public final void aEz(final String paramAnonymousString)
          {
            AppMethodBeat.i(185764);
            ChatFooter.this.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(185762);
                ae.i("MicroMsg.ChatFooter", "onTxtMsgSend, msg is null or nil? %s.", new Object[] { Boolean.valueOf(bu.isNullOrNil(paramAnonymousString)) });
                if ((ChatFooter.l(ChatFooter.this) != null) && (!bu.isNullOrNil(paramAnonymousString))) {
                  ChatFooter.l(ChatFooter.this).aqs(paramAnonymousString);
                }
                AppMethodBeat.o(185762);
              }
            }, 200L);
            AppMethodBeat.o(185764);
          }
          
          public final boolean b(String paramAnonymousString, Long paramAnonymousLong)
          {
            AppMethodBeat.i(185765);
            ae.i("MicroMsg.ChatFooter", "onVoiceMsgSend, fileName: %s.", new Object[] { paramAnonymousString });
            if (paramAnonymousLong != null) {}
            for (int i = paramAnonymousLong.intValue();; i = 0)
            {
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                boolean bool = ChatFooter.l(ChatFooter.this).eg(paramAnonymousString, i);
                AppMethodBeat.o(185765);
                return bool;
              }
              AppMethodBeat.o(185765);
              return false;
            }
          }
          
          public final void evp()
          {
            AppMethodBeat.i(185763);
            if (ChatFooter.H(ChatFooter.this).isShowing()) {
              ChatFooter.H(ChatFooter.this).dismiss();
            }
            ChatFooter.I(ChatFooter.this);
            AppMethodBeat.o(185763);
          }
        };
        this.Fru.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(185767);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$24", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
              ae.i("MicroMsg.RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[] { Integer.valueOf(ChatFooter.dki()) });
              paramAnonymousView = com.tencent.mm.cj.a.Jmx;
              com.tencent.mm.cj.a.xc(false);
              ChatFooter.z(ChatFooter.this).mSh = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).BTe = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.z(ChatFooter.this).BTf = ((int)paramAnonymousMotionEvent.getRawY());
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
              ae.i("MicroMsg.RcdBtnEvent", "trans voice opener: %s, blur mode opener: %s.", new Object[] { Boolean.valueOf(ChatFooter.P(ChatFooter.this)), ChatFooter.Q(ChatFooter.this) });
              if (ChatFooter.P(ChatFooter.this)) {}
              for (ChatFooter.z(ChatFooter.this).BTr = 1;; ChatFooter.z(ChatFooter.this).BTr = 0)
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
                  ChatFooter.l(ChatFooter.this).doa();
                }
                ChatFooter.x(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757050));
                break;
              }
              if ((ChatFooter.L(ChatFooter.this) == null) || (!ChatFooter.L(ChatFooter.this).isShowing()))
              {
                if (ChatFooter.L(ChatFooter.this) == null) {}
                for (boolean bool = true;; bool = false)
                {
                  ae.e("MicroMsg.RcdBtnEvent", "hint window status err, window is null: %s.", new Object[] { Boolean.valueOf(bool) });
                  break;
                }
              }
              if (ChatFooter.P(ChatFooter.this))
              {
                if ((ChatFooter.T(ChatFooter.this) == null) || (ChatFooter.U(ChatFooter.this) == null)) {
                  ae.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! voice2txtRealHintArea is %s, voice2txtOpeLayout is %s.", new Object[] { ChatFooter.T(ChatFooter.this), ChatFooter.U(ChatFooter.this) });
                }
                if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getY() > -ChatFooter.V(ChatFooter.this) / 3) && (paramAnonymousMotionEvent.getX() < ChatFooter.x(ChatFooter.this).getWidth()))
                {
                  if (ChatFooter.W(ChatFooter.this) != ChatFooter.l.FvR)
                  {
                    ae.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_1.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.FvR);
                    if (ChatFooter.X(ChatFooter.this))
                    {
                      ChatFooter.Y(ChatFooter.this).animate().cancel();
                      ChatFooter.Z(ChatFooter.this).animate().cancel();
                      if (ChatFooter.j.FvJ == ChatFooter.Q(ChatFooter.this))
                      {
                        ChatFooter.N(ChatFooter.this).setAlpha(0.5F);
                        ChatFooter.N(ChatFooter.this).animate().alpha(1.0F).setDuration(300L).start();
                        ChatFooter.N(ChatFooter.this).adm(ChatFooter.this.getResources().getColor(2131101069)).G(ChatFooter.e(ChatFooter.this).getWindow().getDecorView().getBackground()).xU(true);
                      }
                      for (;;)
                      {
                        ChatFooter.H(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(200L).start();
                        ChatFooter.aa(ChatFooter.this).setVisibility(0);
                        ChatFooter.ab(ChatFooter.this).setVisibility(8);
                        ChatFooter.U(ChatFooter.this).setVisibility(8);
                        ChatFooter.a(ChatFooter.this, ChatFooter.k.FvM);
                        ChatFooter.ac(ChatFooter.this);
                        break;
                        ChatFooter.T(ChatFooter.this).setBackgroundResource(2131234483);
                      }
                    }
                  }
                }
                else
                {
                  if (ChatFooter.W(ChatFooter.this) != ChatFooter.l.FvS)
                  {
                    ae.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_2.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.FvS);
                    if (!ChatFooter.X(ChatFooter.this)) {
                      ChatFooter.ad(ChatFooter.this);
                    }
                    ae.i("MicroMsg.RcdBtnEvent", "init rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.fic()) });
                    if (paramAnonymousMotionEvent.getRawX() > ChatFooter.fic())
                    {
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.FvN);
                      ae.i("MicroMsg.RcdBtnEvent", "init MODE_TRANS");
                      label1097:
                      if (ChatFooter.j.FvJ != ChatFooter.Q(ChatFooter.this)) {
                        break label1375;
                      }
                      ChatFooter.N(ChatFooter.this).adm(0).G(null).xU(false);
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
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.FvO);
                      ae.i("MicroMsg.RcdBtnEvent", "init MODE_CANCEL");
                      break label1097;
                      label1375:
                      ChatFooter.T(ChatFooter.this).setBackgroundColor(0);
                    }
                  }
                  if (ChatFooter.ah(ChatFooter.this))
                  {
                    ae.i("MicroMsg.RcdBtnEvent", "active rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.fic()) });
                    if ((paramAnonymousMotionEvent.getRawX() > ChatFooter.fic()) && (ChatFooter.k.FvN != ChatFooter.ai(ChatFooter.this)))
                    {
                      ae.i("MicroMsg.RcdBtnEvent", "active MODE_TRANS.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.FvN);
                      ChatFooter.ab(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131764713));
                      ChatFooter.aj(ChatFooter.this);
                      ChatFooter.ak(ChatFooter.this);
                    }
                    else if ((paramAnonymousMotionEvent.getRawX() <= ChatFooter.fic()) && (ChatFooter.k.FvO != ChatFooter.ai(ChatFooter.this)))
                    {
                      ae.i("MicroMsg.RcdBtnEvent", "active MODE_CANCEL.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.FvO);
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
                  ae.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", new Object[] { ChatFooter.an(ChatFooter.this), ChatFooter.ao(ChatFooter.this) });
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
                    ChatFooter.x(ChatFooter.this).setTextSize(0, com.tencent.mm.cb.a.ay(ChatFooter.this.getContext(), 2131165517) * com.tencent.mm.cb.a.ip(ChatFooter.this.getContext()));
                    ChatFooter.x(ChatFooter.this).setText(2131757078);
                    ChatFooter.ao(ChatFooter.this).setVisibility(0);
                    continue;
                    ChatFooter.B(ChatFooter.this).euY();
                    if ((ChatFooter.this.getContext() instanceof Activity)) {
                      ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                    }
                    ChatFooter.z(ChatFooter.this).BTg = System.currentTimeMillis();
                    ChatFooter.z(ChatFooter.this).BTh = ((int)paramAnonymousMotionEvent.getRawX());
                    ChatFooter.z(ChatFooter.this).BTi = ((int)paramAnonymousMotionEvent.getRawY());
                    ae.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.dki()) });
                    ChatFooter.this.fhH();
                    ae.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.fid()) });
                  }
                }
              }
            }
          }
        });
        this.Fru.setOnKeyListener(new View.OnKeyListener()
        {
          public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(185768);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.mu(paramAnonymousInt);
            localb.bd(paramAnonymousKeyEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$25", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
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
                  ChatFooter.l(ChatFooter.this).doa();
                }
                ChatFooter.x(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757050));
                continue;
                if ((paramAnonymousInt == 23) || (paramAnonymousInt == 66))
                {
                  ChatFooter.x(ChatFooter.this).setBackgroundResource(2131232725);
                  ChatFooter.x(ChatFooter.this).setText(2131757093);
                  if (ChatFooter.l(ChatFooter.this) != null) {
                    ChatFooter.l(ChatFooter.this).dnV();
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
  
  private void ZK(int paramInt)
  {
    AppMethodBeat.i(31593);
    if (this.Frv == null)
    {
      AppMethodBeat.o(31593);
      return;
    }
    if (paramInt == 2131231707) {}
    for (int i = 1;; i = 0)
    {
      if (this.Frv != null)
      {
        if (i == 0) {
          break label83;
        }
        this.Frv.setContentDescription(getContext().getString(2131757049));
      }
      for (;;)
      {
        this.Frv.setImageResource(paramInt);
        this.Frv.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(31593);
        return;
        label83:
        this.Frv.setContentDescription(getContext().getString(2131757048));
      }
    }
  }
  
  private void ZP(int paramInt)
  {
    AppMethodBeat.i(31666);
    if (paramInt == this.Fsg)
    {
      AppMethodBeat.o(31666);
      return;
    }
    if (this.gpu.getVisibility() == 8) {
      fhF();
    }
    if (((paramInt == 0) && (this.FrC.getVisibility() == 8)) || (paramInt == 3) || ((paramInt == 0) && (this.FrC.getVisibility() == 8))) {
      fhF();
    }
    AppMethodBeat.o(31666);
  }
  
  private void ZQ(int paramInt)
  {
    AppMethodBeat.i(31680);
    ae.i("MicroMsg.ChatFooter", "[refreshBottomHeight] keyborPx:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.compatible.util.i.foa();
    int i;
    if ((an.aUq(this.Frr)) || (an.aUr(this.Frr)))
    {
      paramInt = com.tencent.mm.compatible.util.i.j(getContext(), paramInt, 43);
      i = com.tencent.mm.api.aa.bj(getContext());
      if ((!this.Fse) || (this.Fsm)) {
        break label353;
      }
    }
    label353:
    for (this.Fsr = paramInt;; this.Fsr = com.tencent.mm.sdk.platformtools.aa.iN(getContext()))
    {
      paramInt = Math.max(i, this.Fsr);
      this.Fss = paramInt;
      if (paramInt != this.Fsq) {
        this.Fsq = paramInt;
      }
      ae.i("MicroMsg.ChatFooter", "refreshBottomHeight: %s, %s, %s, %s", new Object[] { Boolean.valueOf(this.Fse), Boolean.valueOf(this.Fsm), Integer.valueOf(this.Fsr), Integer.valueOf(this.Fsq) });
      Object localObject = this.Frx.getLayoutParams();
      if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != this.Fsq))
      {
        ((ViewGroup.LayoutParams)localObject).height = this.Fsq;
        this.Frx.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.Frx.requestLayout();
      }
      if (this.Fsj)
      {
        paramInt = -this.Fsq;
        localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
        if ((localObject != null) && (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != paramInt))
        {
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
          setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.Frs != null)
      {
        this.Frs.setPortHeighPx(this.Fsr);
        this.Frs.fgQ();
      }
      if (this.Fmx != null)
      {
        paramInt = this.Fsr + this.Frw.getHeight();
        localObject = this.Fmx.getLayoutParams();
        if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != paramInt))
        {
          ((ViewGroup.LayoutParams)localObject).height = paramInt;
          this.Fmx.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
      if (this.qdo == null) {
        fhd();
      }
      this.qdo.animate().cancel();
      if ((this.qdo.getVisibility() == 0) && (this.qdo.getAlpha() == 1.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(31658);
        }
      }
      else
      {
        this.qdo.setVisibility(0);
        this.qdo.setAlpha(0.0F);
        this.qdo.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
        AppMethodBeat.o(31658);
      }
    }
    else if ((this.qdo == null) || (this.qdo.getVisibility() == 4) || (this.qdo.getAlpha() == 0.0F))
    {
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(31658);
      }
    }
    else
    {
      this.qdo.animate().cancel();
      this.qdo.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
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
      if (this.Frs == null) {
        fhe();
      }
      this.Frs.animate().cancel();
      if ((this.Frs.getVisibility() == 0) && (this.Frs.getAlpha() == 1.0F))
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
        this.Frs.setAlpha(0.0F);
        this.Frs.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).setListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(186769);
            ChatFooter.bn(ChatFooter.this);
            ChatFooter.bo(ChatFooter.this).animate().setListener(null);
            AppMethodBeat.o(186769);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        }).start();
        this.Frs.setUncertainEnterLocation(paramInt);
        this.Frs.refresh();
        AppMethodBeat.o(163216);
      }
    }
    else
    {
      this.Frs.animate().cancel();
      if ((this.Frs.getVisibility() == 4) || (this.Frs.getAlpha() == 0.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(163216);
        }
      }
      else {
        this.Frs.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
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
  
  private void aJ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185825);
    if (1 == paramInt3) {}
    for (boolean bool = true; ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) && (paramInt2 == 0); bool = false)
    {
      if (this.Fsv == null) {
        break label111;
      }
      this.Fsv.ya(bool);
      AppMethodBeat.o(185825);
      return;
    }
    if ((paramInt1 == 0) && ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 4)) && (this.Fsv != null)) {
      this.Fsv.yb(bool);
    }
    label111:
    AppMethodBeat.o(185825);
  }
  
  private void aL(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31599);
    if (paramBoolean1)
    {
      if ((this.FrF.getTag() != null) && ((this.FrF.getTag() instanceof bv)))
      {
        this.FrF.setVisibility(0);
        bv localbv = (bv)this.FrF.getTag();
        this.FrG.setText(k.c(getContext(), com.tencent.mm.plugin.msgquote.model.a.a(getContext(), this.FrG.getTextSize(), localbv)));
        AppMethodBeat.o(31599);
        return;
      }
      this.FrF.setVisibility(8);
      AppMethodBeat.o(31599);
      return;
    }
    if (paramBoolean2)
    {
      this.FrF.setTag(null);
      this.FrG.setText("");
    }
    this.FrF.setVisibility(8);
    AppMethodBeat.o(31599);
  }
  
  static boolean aOw(String paramString)
  {
    AppMethodBeat.i(163219);
    boolean bool = ay.aRW("plus_uncertain_enter").getBoolean(paramString, false);
    AppMethodBeat.o(163219);
    return bool;
  }
  
  private static boolean aoA()
  {
    AppMethodBeat.i(185402);
    if (ak.getContext().getResources().getConfiguration().orientation == 2)
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
    fhC();
    if (this.Fsi != null)
    {
      if ((this.Fsp) && (this.Fsg == 1))
      {
        this.Fsi.c(0, false, paramInt2, paramInt3);
        AppMethodBeat.o(185824);
        return;
      }
      this.Fsi.c(paramInt1, paramBoolean, paramInt2, paramInt3);
      AppMethodBeat.o(185824);
      return;
    }
    if ((this.Fsg == 0) || (this.Fsg == 1)) {
      this.Frx.setVisibility(8);
    }
    ae.e("MicroMsg.ChatFooter", "scrollParent: scrollParent is not ChattingScrollLayout");
    AppMethodBeat.o(185824);
  }
  
  private boolean cG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(179783);
    if (fhG())
    {
      AppMethodBeat.o(179783);
      return false;
    }
    if ((this.FsE == null) || (bu.isNullOrNil(this.FsE.getTalkerUserName())))
    {
      ae.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg username == null");
      AppMethodBeat.o(179783);
      return false;
    }
    try
    {
      String str = this.FsE.getTalkerUserName();
      if ((((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).anN(str)) && (paramBoolean))
      {
        this.FrK.dev();
        try
        {
          localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).abU(paramString);
          paramString = (String)localObject;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject;
            ae.e("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          }
          com.tencent.mm.plugin.groupsolitaire.b.b.b(locala1);
          locala2 = com.tencent.mm.plugin.groupsolitaire.b.b.a(localException, this.FrK.uOr, locala1);
          if (!locala2.uNh) {
            break label296;
          }
          com.tencent.mm.plugin.groupsolitaire.b.b.c(locala2);
          label296:
          locala2.field_lastActiveTime = ch.aDd();
          if (locala1 == null) {
            break label391;
          }
        }
        localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().ht(paramString, str);
        if ((((Integer)((Pair)localObject).first).intValue() > 0) && (((Pair)localObject).second != null))
        {
          localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second;
          com.tencent.mm.plugin.groupsolitaire.b.b.a(str, v.aAC(), (com.tencent.mm.plugin.groupsolitaire.c.a)localObject);
          com.tencent.mm.plugin.groupsolitaire.c.a locala1 = com.tencent.mm.plugin.groupsolitaire.b.b.a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(str, ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_key, true), v.aAC(), 1);
          if (locala1 == null)
          {
            ae.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg storageGroupSolitatire == null");
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
            if (this.FrL != null) {
              this.FrL.aoa(paramString);
            }
            this.FrK.reset();
            fha();
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
      ae.e("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg() Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      AppMethodBeat.o(179783);
    }
    return false;
  }
  
  private boolean deu()
  {
    AppMethodBeat.i(31608);
    if (this.FrK != null)
    {
      boolean bool = this.FrK.deu();
      AppMethodBeat.o(31608);
      return bool;
    }
    AppMethodBeat.o(31608);
    return false;
  }
  
  private void fhC()
  {
    AppMethodBeat.i(31660);
    if (this.Fsi == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ChattingScrollLayout))
      {
        this.Fsi = ((ChattingScrollLayout)localViewParent);
        this.Fsj = true;
      }
    }
    AppMethodBeat.o(31660);
  }
  
  private void fhD()
  {
    AppMethodBeat.i(31668);
    if (!this.Fsf)
    {
      ae.i("MicroMsg.ChatFooter", "updateKeyboardProvider: not resumed %s", new Object[] { bu.fpN() });
      AppMethodBeat.o(31668);
      return;
    }
    if ((this.Fsm) || (!this.Fse))
    {
      this.fSZ.close();
      ((Activity)getContext()).getWindow().setSoftInputMode(18);
      AppMethodBeat.o(31668);
      return;
    }
    ((Activity)getContext()).getWindow().setSoftInputMode(this.Fsk | 0x2);
    this.fSZ.start();
    AppMethodBeat.o(31668);
  }
  
  private void fhN()
  {
    AppMethodBeat.i(31687);
    this.FsT.setVisibility(8);
    this.FsW.setVisibility(8);
    this.FsT.setScaleX(0.5F);
    this.FsT.setScaleY(0.5F);
    this.FsW.setScaleX(0.5F);
    this.FsW.setScaleY(0.5F);
    this.FsT.setTranslationX(this.FuR);
    this.FsT.setTranslationY(-this.FuS);
    this.FsW.setTranslationX(-this.FuR);
    this.FsW.setTranslationY(-this.FuS);
    fhO();
    fhP();
    AppMethodBeat.o(31687);
  }
  
  private void fhO()
  {
    AppMethodBeat.i(31688);
    this.FsU.setIconColor(getResources().getColor(2131100020));
    this.FsV.setTextColor(getResources().getColor(2131101072));
    this.FsT.setBackgroundDrawable(getResources().getDrawable(2131234484));
    AppMethodBeat.o(31688);
  }
  
  private void fhP()
  {
    AppMethodBeat.i(31689);
    this.FsX.setIconColor(getResources().getColor(2131100020));
    this.FsY.setTextColor(getResources().getColor(2131101072));
    this.FsW.setBackgroundDrawable(getResources().getDrawable(2131234484));
    AppMethodBeat.o(31689);
  }
  
  private void fhQ()
  {
    AppMethodBeat.i(31690);
    String str = ad.iR(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
    {
      this.FsR.setImageResource(2131691370);
      this.FsX.setImageResource(2131691372);
      AppMethodBeat.o(31690);
      return;
    }
    if (str.equals("en"))
    {
      this.FsR.setImageResource(2131691371);
      this.FsX.setImageResource(2131691373);
    }
    AppMethodBeat.o(31690);
  }
  
  private void fhR()
  {
    AppMethodBeat.i(185403);
    int k = this.Ftq.getWidth();
    int m = this.Ftq.getHeight();
    int j = 0;
    int i = 0;
    switch (79.Fvm[this.FuZ.ordinal()])
    {
    }
    for (;;)
    {
      ae.i("MicroMsg.ChatFooter", "beginWidth:%s, endWidth:%s, beginHeight:%s, endHeight:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i) });
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { k, j }).setDuration(200L);
      localValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(186789);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).width = i;
          ChatFooter.az(ChatFooter.this).requestLayout();
          AppMethodBeat.o(186789);
        }
      });
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { m, i }).setDuration(200L);
      localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(186790);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).height = i;
          ChatFooter.az(ChatFooter.this).requestLayout();
          AppMethodBeat.o(186790);
        }
      });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
      localAnimatorSet.start();
      AppMethodBeat.o(185403);
      return;
      j = this.Fuz;
      i = this.BWW;
      continue;
      j = this.Fur;
      i = this.Fuw;
      continue;
      j = this.Fus;
      i = this.BWW;
    }
  }
  
  private void fhS()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(185404);
    float f3 = this.Ftq.getTranslationX();
    float f1 = f2;
    switch (79.Fvm[this.FuZ.ordinal()])
    {
    }
    for (f1 = f2;; f1 = -(com.tencent.mm.ui.ar.ck(getContext()).x / 2 - com.tencent.mm.ui.aq.fromDPToPix(getContext(), 76)))
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f3, f1 }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(186791);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ChatFooter.az(ChatFooter.this).setTranslationX(f);
          AppMethodBeat.o(186791);
        }
      });
      localValueAnimator.start();
      AppMethodBeat.o(185404);
      return;
    }
  }
  
  private void fhT()
  {
    AppMethodBeat.i(185405);
    this.Ftq.setAlpha(0.0F);
    this.Ftq.setTranslationY(com.tencent.mm.ui.aq.fromDPToPix(getContext(), 56));
    this.Ftt.setAlpha(0);
    this.Ftt.setTranslationY(com.tencent.mm.ui.aq.fromDPToPix(getContext(), 56));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.Ftq, "translationY", new float[] { this.Ftq.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.Ftq, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.Ftt, "translationY", new float[] { this.Ftt.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofInt(this.Ftt, "alpha", new int[] { 0, 255 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    localAnimatorSet.start();
    AppMethodBeat.o(185405);
  }
  
  private void fhU()
  {
    AppMethodBeat.i(185406);
    this.Fts.setVisibility(8);
    this.Ftv.setVisibility(0);
    this.Ftv.setTextColor(getContext().getResources().getColor(2131100017));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Ftz.getLayoutParams();
    localLayoutParams.addRule(13);
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    this.Ftv.setText(String.format(getContext().getResources().getString(2131761571), new Object[] { Integer.valueOf(this.FuA) }));
    this.Ftz.requestLayout();
    AppMethodBeat.o(185406);
  }
  
  private void fhV()
  {
    AppMethodBeat.i(185407);
    this.Fts.setVisibility(8);
    this.Ftv.setVisibility(0);
    this.Ftv.setTextColor(getContext().getResources().getColor(2131100482));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Ftz.getLayoutParams();
    localLayoutParams.removeRule(13);
    localLayoutParams.addRule(21);
    localLayoutParams.addRule(12);
    this.Ftv.setText(String.format(getContext().getResources().getString(2131761571), new Object[] { Integer.valueOf(this.FuA) }));
    this.Ftz.requestLayout();
    AppMethodBeat.o(185407);
  }
  
  private void fhW()
  {
    AppMethodBeat.i(185408);
    this.Fts.setVisibility(0);
    this.Ftv.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Ftz.getLayoutParams();
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    localLayoutParams.addRule(13);
    this.Ftz.requestLayout();
    ((RelativeLayout.LayoutParams)this.Fts.getLayoutParams()).bottomMargin = 0;
    this.Fts.requestLayout();
    AppMethodBeat.o(185408);
  }
  
  private void fhX()
  {
    AppMethodBeat.i(185409);
    this.FtS.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).withEndAction(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186792);
        ChatFooter.by(ChatFooter.this).setVisibility(8);
        ChatFooter.bz(ChatFooter.this).w(ChatFooter.this.getResources().getColor(2131100017), 0.5F);
        AppMethodBeat.o(186792);
      }
    }).start();
    this.FtT.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).start();
    this.FtU.animate().translationY(0.0F).setDuration(100L).start();
    if (this.FuA < 10) {
      fhU();
    }
    for (;;)
    {
      this.FtA.setVisibility(0);
      this.Fty.setVisibility(8);
      this.Ftr.setVisibility(8);
      this.Ftt.setImageDrawable(ao.k(getContext(), 2131690496, getContext().getResources().getColor(2131099759)));
      this.Ftt.animate().translationX(0.0F).setDuration(150L).start();
      this.Ftq.setActivated(true);
      fhR();
      fhS();
      AppMethodBeat.o(185409);
      return;
      fhW();
      this.Fts.a(SoundWaveView.d.BUJ);
    }
  }
  
  private void fhY()
  {
    AppMethodBeat.i(185410);
    this.FtH.setVisibility(4);
    this.FtF.w(getResources().getColor(2131099828), 0.5F);
    this.FtD.setBackgroundDrawable(getResources().getDrawable(2131233437));
    this.FtD.animate().scaleX(1.0F).scaleY(1.0F).setDuration(150L).start();
    AppMethodBeat.o(185410);
  }
  
  private void fhZ()
  {
    AppMethodBeat.i(185411);
    this.FtI.setVisibility(4);
    this.FtG.w(getResources().getColor(2131099828), 0.5F);
    this.FtE.setBackgroundDrawable(getResources().getDrawable(2131233437));
    this.FtE.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    AppMethodBeat.o(185411);
  }
  
  private void fhe()
  {
    AppMethodBeat.i(31594);
    String str;
    if (this.FsE == null)
    {
      str = this.Frr;
      this.Frs = ((AppPanel)findViewById(2131297977));
      this.Frs.setOnSwitchPanelListener(this.Fub);
      this.Frs.setChattingContext(this.Fuc);
      this.Frs.setPortHeighPx(com.tencent.mm.sdk.platformtools.aa.iN(getContext()));
      if ((!x.AZ(str)) && (!x.AQ(str))) {
        break label124;
      }
      this.Frs.init(0);
    }
    for (;;)
    {
      this.Fry = ((TextView)findViewById(2131297978));
      AppMethodBeat.o(31594);
      return;
      str = this.FsE.getTalkerUserName();
      break;
      label124:
      if (x.Ao(str)) {
        this.Frs.init(4);
      } else if (x.wb(str)) {
        this.Frs.init(2);
      } else {
        this.Frs.init(1);
      }
    }
  }
  
  private void fhg()
  {
    AppMethodBeat.i(185399);
    this.Fui.start();
    this.Fuj.start();
    this.Fuk.start();
    this.Ful.start();
    this.Fum.start();
    this.FtS.animate().alpha(1.0F).setDuration(200L).start();
    this.FtT.animate().alpha(1.0F).setDuration(200L).start();
    this.FtC.animate().alpha(1.0F).translationY(0.0F).setDuration(300L).start();
    fhT();
    AppMethodBeat.o(185399);
  }
  
  private void fhh()
  {
    AppMethodBeat.i(31617);
    if (this.FrZ)
    {
      this.rFv.setVisibility(8);
      this.rFw.setVisibility(8);
      this.BGe.setVisibility(8);
      this.rFt.setVisibility(8);
      this.FsI.setVisibility(0);
      this.FsL.setVisibility(0);
      this.FsM.setVisibility(0);
      this.FsO.setVisibility(8);
      this.FsP.setVisibility(0);
      this.FsQ.setVisibility(8);
      this.FsS.setVisibility(8);
      this.FsT.setVisibility(8);
      this.FsW.setVisibility(8);
      this.Fti = k.FvM;
      this.Ftg = ChatFooter.l.FvQ;
      AppMethodBeat.o(31617);
      return;
    }
    this.rFv.setVisibility(0);
    this.rFw.setVisibility(8);
    this.BGe.setVisibility(8);
    this.rFt.setVisibility(8);
    this.FsI.setVisibility(8);
    AppMethodBeat.o(31617);
  }
  
  private void fhw()
  {
    AppMethodBeat.i(31640);
    this.iBX.findViewById(2131298170).setVisibility(0);
    AppMethodBeat.o(31640);
  }
  
  private void fhx()
  {
    AppMethodBeat.i(31641);
    ae.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
    this.Fsb = false;
    this.vNt.setImeOptions(0);
    this.vNt.setInputType(this.vNt.getInputType() | 0x40);
    AppMethodBeat.o(31641);
  }
  
  private void fia()
  {
    AppMethodBeat.i(185412);
    int j = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 20);
    if ((this.Ftr.getText() != null) && (this.Ftr.getText().length() > 0)) {}
    for (int i = this.Ftr.getText().length();; i = 0)
    {
      this.Ftr.setSelection(i);
      this.Ftr.setPadding(j, j, j, j);
      this.FtC.setVisibility(8);
      this.FtA.setVisibility(8);
      this.FtR.setVisibility(4);
      this.FtJ.setVisibility(0);
      this.Ftw.setVisibility(0);
      com.tencent.mm.cj.a.a locala = com.tencent.mm.cj.a.Jmx;
      com.tencent.mm.cj.a.fyF();
      this.Ftv.setVisibility(8);
      this.Fts.setVisibility(8);
      AppMethodBeat.o(185412);
      return;
    }
  }
  
  private int getDefaultLangType()
  {
    AppMethodBeat.i(185418);
    int i = com.tencent.mm.modelvoiceaddr.g.iBa;
    String str = ad.iR(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW"))) {
      i = com.tencent.mm.modelvoiceaddr.g.iBb;
    }
    for (;;)
    {
      AppMethodBeat.o(185418);
      return i;
      if (str.equals("en")) {
        i = com.tencent.mm.modelvoiceaddr.g.iBd;
      }
    }
  }
  
  private int getTransLangTypeByTalker()
  {
    AppMethodBeat.i(185417);
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voice2txt_sp", 0);
    int j = localSharedPreferences.getInt(this.Frr, com.tencent.mm.modelvoiceaddr.g.iBa);
    if (this.Ftx != null)
    {
      Iterator localIterator = this.Ftx.BTI.fUw.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((com.tencent.mm.plugin.transvoice.ui.a.a.a)localIterator.next()).BVN != j);
      for (i = 1; i == 0; i = 0)
      {
        i = getDefaultLangType();
        if (com.tencent.mm.modelvoiceaddr.g.iBa != i) {
          localSharedPreferences.edit().putInt(this.Frr, i).apply();
        }
        AppMethodBeat.o(185417);
        return i;
      }
      AppMethodBeat.o(185417);
      return j;
    }
    int i = getDefaultLangType();
    if (com.tencent.mm.modelvoiceaddr.g.iBa != i) {
      localSharedPreferences.edit().putInt(this.Frr, i).apply();
    }
    AppMethodBeat.o(185417);
    return i;
  }
  
  private void h(int paramInt1, boolean paramBoolean, final int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(163218);
    ae.i("MicroMsg.ChatFooter", "switchPanel: %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    if (this.Fsu)
    {
      AppMethodBeat.o(163218);
      return;
    }
    if ((paramInt1 != 0) && (v.aBt().booleanValue()) && (this.Fsz != null))
    {
      this.Fsz.a(Boolean.TRUE, Boolean.FALSE);
      this.Fsz.b(Boolean.TRUE, Boolean.FALSE);
    }
    ZP(paramInt1);
    if (this.Frw != null) {
      this.Frw.setVisibility(0);
    }
    switch (paramInt1)
    {
    default: 
      if (((this.Fsg != 0) || (paramInt1 != 1)) && ((this.Fsg != 1) || (paramInt1 != 0))) {
        break;
      }
    }
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      aJ(this.Fsg, paramInt1, paramInt2);
      int i;
      label203:
      com.tencent.mm.emoji.b.a locala;
      label229:
      int k;
      if (this.Fsg != paramInt1)
      {
        i = 1;
        this.Fsg = paramInt1;
        if (this.Fsg != 2) {
          break label521;
        }
        wm(true);
        locala = com.tencent.mm.emoji.b.a.gqT;
        com.tencent.mm.emoji.b.a.agk();
        k = this.Fsl;
        if (this.Fsv != null) {
          break label537;
        }
      }
      label521:
      label537:
      for (paramInt1 = j;; paramInt1 = this.Fsv.dew())
      {
        b(k, paramBoolean, paramInt2, paramInt1);
        if (i != 0) {
          com.tencent.e.h.MqF.r(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186771);
              if ((ChatFooter.f(ChatFooter.this) != null) && (ChatFooter.f(ChatFooter.this).fif() != null))
              {
                at localat = (at)ChatFooter.f(ChatFooter.this).fif().bh(at.class);
                if (localat != null) {
                  localat.fJr();
                }
              }
              AppMethodBeat.o(186771);
            }
          }, 300L);
        }
        if (this.FrN != null) {
          this.FrN.js(this.Fsg, this.Fsl);
        }
        AppMethodBeat.o(163218);
        return;
        if ((!this.Fse) || (this.Fsm)) {}
        for (this.Fsl = 0;; this.Fsl = this.nMm)
        {
          a(false, null);
          a(false, null, -1);
          break;
        }
        this.Fsl = this.Fss;
        this.Frx.setVisibility(0);
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
        this.Fsl = this.Fsr;
        this.Frx.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185796);
            ChatFooter.h(ChatFooter.this, paramInt2);
            AppMethodBeat.o(185796);
          }
        });
        this.FrI.fil();
        wj(false);
        if (this.FrY != 2) {
          break;
        }
        ZN(1);
        break;
        this.Fsl = 0;
        a(false, null);
        a(false, null, -1);
        ffS();
        fhE();
        break;
        if (this.Frw != null) {
          this.Frw.setVisibility(4);
        }
        this.Fsl = this.Fst;
        a(false, null);
        a(false, null, -1);
        break;
        i = 0;
        break label203;
        wm(false);
        locala = com.tencent.mm.emoji.b.a.gqT;
        com.tencent.mm.emoji.b.a.agl();
        break label229;
      }
    }
  }
  
  private void ol(boolean paramBoolean)
  {
    AppMethodBeat.i(31584);
    this.gnu = paramBoolean;
    if (this.FsF == null)
    {
      this.FsF = AnimationUtils.loadAnimation(getContext(), 2130772095);
      this.FsF.setDuration(150L);
    }
    if (this.FsG == null)
    {
      this.FsG = AnimationUtils.loadAnimation(getContext(), 2130772100);
      this.FsG.setDuration(150L);
    }
    if ((this.gpu == null) || (this.Frz == null))
    {
      ae.i("MicroMsg.ChatFooter", "canSend:%B, return sendBtn == null || mAttachButton == null", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31584);
      return;
    }
    if (this.FsC)
    {
      if (this.Frz.getVisibility() != 0) {
        this.Frz.setVisibility(0);
      }
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.gpu.getVisibility() == 0) && (paramBoolean))
    {
      ae.i("MicroMsg.ChatFooter", "canSend true ! sendBtn is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.Frz.getVisibility() == 0) && (!paramBoolean))
    {
      ae.i("MicroMsg.ChatFooter", "canSend false ! AttachButton is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if (paramBoolean)
    {
      fhL();
      this.Frz.startAnimation(this.FsG);
      this.Frz.setVisibility(8);
      wn(false);
    }
    for (;;)
    {
      ae.i("MicroMsg.ChatFooter", "jacks canSend:%B", new Object[] { Boolean.valueOf(paramBoolean) });
      this.gpu.getParent().requestLayout();
      AppMethodBeat.o(31584);
      return;
      this.Frz.startAnimation(this.FsF);
      if ((!this.FrR) && (!this.Fsd))
      {
        this.Frz.setVisibility(0);
        wn(true);
      }
      fhK();
    }
  }
  
  private void setNewVoice2TxtCountDown(int paramInt)
  {
    AppMethodBeat.i(185400);
    if ((paramInt > 60) || (paramInt < 0))
    {
      ae.w("MicroMsg.ChatFooter", "skip by invalid quantity:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(185400);
      return;
    }
    switch (79.Fvm[this.FuZ.ordinal()])
    {
    }
    for (;;)
    {
      this.FuA = paramInt;
      AppMethodBeat.o(185400);
      return;
      int i = 60 - paramInt;
      int j = (int)(this.Fuv * i);
      this.Fuz = Math.min(this.Fuu + j, this.Fut);
      ae.d("MicroMsg.ChatFooter", "voiceWidth:%s, duration:%s, offset:%s", new Object[] { Integer.valueOf(this.Fuz), Integer.valueOf(i), Integer.valueOf(j) });
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.Ftq.getWidth(), this.Fuz }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(186788);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).width = i;
          ChatFooter.az(ChatFooter.this).requestLayout();
          AppMethodBeat.o(186788);
        }
      });
      localValueAnimator.start();
      if (paramInt < 10)
      {
        fhU();
        continue;
        if (paramInt < 10) {
          fhV();
        }
      }
    }
  }
  
  private void wk(boolean paramBoolean)
  {
    AppMethodBeat.i(31598);
    if (paramBoolean)
    {
      this.FrE.setVisibility(0);
      this.FrC.setVisibility(0);
      aL(true, false);
      AppMethodBeat.o(31598);
      return;
    }
    this.FrE.setVisibility(8);
    this.FrC.setVisibility(8);
    aL(false, false);
    AppMethodBeat.o(31598);
  }
  
  private void wm(boolean paramBoolean)
  {
    AppMethodBeat.i(31673);
    if (this.FrB == null)
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((this.FuE) && (paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((!this.FuE) && (!paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    this.FuE = paramBoolean;
    if (paramBoolean)
    {
      this.FrB.setImageDrawable(getContext().getResources().getDrawable(2131231706));
      AppMethodBeat.o(31673);
      return;
    }
    this.FrB.setImageDrawable(getContext().getResources().getDrawable(2131690564));
    AppMethodBeat.o(31673);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void ZL(int paramInt)
  {
    AppMethodBeat.i(31616);
    Object localObject1;
    if (this.Ftl)
    {
      if (this.Ftn == null)
      {
        this.Ftn = new o(View.inflate(getContext(), 2131495020, null), -1, -1, true);
        this.Ftn.setSoftInputMode(16);
        this.Ftn.setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(186759);
            if ((ChatFooter.this.FuZ == ChatFooter.e.Fvw) && (ChatFooter.aI(ChatFooter.this)))
            {
              ae.i("MicroMsg.ChatFooter", "dismiss from keyback, need cancelRecording");
              ChatFooter.z(ChatFooter.this).setExitType(6);
              ChatFooter.l(ChatFooter.this).dnZ();
            }
            ChatFooter.aJ(ChatFooter.this);
            ChatFooter.e(ChatFooter.this, 0);
            AppMethodBeat.o(186759);
          }
        });
        this.Fto = this.Ftn.getContentView().findViewById(2131302815);
        this.Ftp = this.Ftn.getContentView().findViewById(2131302837);
        this.Ftq = ((ViewGroup)this.Ftn.getContentView().findViewById(2131302811));
        this.Fts = ((SoundWaveView)this.Ftn.getContentView().findViewById(2131302817));
        this.Ftr = ((EditText)this.Ftn.getContentView().findViewById(2131302809));
        this.Ftt = ((ImageView)this.Ftn.getContentView().findViewById(2131302808));
        this.Ftu = ((ViewGroup)this.Ftn.getContentView().findViewById(2131302816));
        this.Ftv = ((TextView)this.Ftn.getContentView().findViewById(2131302807));
        this.Ftw = ((WeImageView)this.Ftn.getContentView().findViewById(2131302812));
        this.Ftx = ((LanguageChoiceLayout)this.Ftn.getContentView().findViewById(2131302829));
        this.Fty = ((TextView)this.Ftn.getContentView().findViewById(2131302813));
        this.Ftz = ((ViewGroup)this.Ftn.getContentView().findViewById(2131302818));
        this.FtA = ((TextView)this.Ftn.getContentView().findViewById(2131302810));
        this.Ftx.setSelectLanguageListener(new LanguageChoiceLayout.a()
        {
          public final void Ua(int paramAnonymousInt)
          {
            AppMethodBeat.i(186760);
            ChatFooter.f(ChatFooter.this, paramAnonymousInt);
            if (bu.isNullOrNil((String)ChatFooter.aL(ChatFooter.this).get(Integer.valueOf(ChatFooter.aK(ChatFooter.this)))))
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
              ChatFooter.z(ChatFooter.this).BTk = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).BTn = 0;
              ChatFooter.z(ChatFooter.this).BTo = 0L;
              ChatFooter.z(ChatFooter.this).BTp = 0;
              ChatFooter.z(ChatFooter.this).BTs = 0;
              ChatFooter.z(ChatFooter.this).BTt = 0;
              ChatFooter.z(ChatFooter.this).BTu = 0;
              AppMethodBeat.o(186760);
              return;
              ChatFooter.aM(ChatFooter.this);
            }
          }
        });
        this.Ftw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186761);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (ChatFooter.aN(ChatFooter.this)) {
              ChatFooter.aO(ChatFooter.this).hideSoftInputFromWindow(ChatFooter.aA(ChatFooter.this).getWindowToken(), 0);
            }
            paramAnonymousView = ChatFooter.aP(ChatFooter.this);
            int i = ChatFooter.aK(ChatFooter.this);
            paramAnonymousView.setVisibility(0);
            paramAnonymousView.gZE.post(new LanguageChoiceLayout.4(paramAnonymousView, i));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186761);
          }
        });
        this.Ftr.setMaxLines(2147483647);
        this.Ftr.setHorizontallyScrolling(false);
        this.Ftr.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(186762);
            if ((4 == paramAnonymousInt) || (66 == paramAnonymousKeyEvent.getAction()))
            {
              paramAnonymousTextView = ChatFooter.aA(ChatFooter.this).getText().toString();
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                if (!bu.isNullOrNil(paramAnonymousTextView)) {
                  ChatFooter.l(ChatFooter.this).aqs(paramAnonymousTextView);
                }
                ChatFooter.l(ChatFooter.this).dnZ();
              }
              AppMethodBeat.o(186762);
              return true;
            }
            AppMethodBeat.o(186762);
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
        this.Ftr.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(186763);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$39", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            if (ChatFooter.aR(ChatFooter.this))
            {
              ChatFooter.f(ChatFooter.this, false);
              if (ChatFooter.this.BUY != null) {
                ChatFooter.this.BUY.aq(false, true);
              }
              ChatFooter.aS(ChatFooter.this).stopTimer();
              ChatFooter.aA(ChatFooter.this).setText((CharSequence)ChatFooter.aL(ChatFooter.this).get(Integer.valueOf(ChatFooter.aK(ChatFooter.this))));
              ChatFooter.z(ChatFooter.this).BTs = 0;
              ChatFooter.z(ChatFooter.this).BTo = System.currentTimeMillis();
              ChatFooter.aT(ChatFooter.this);
            }
            ChatFooter.z(ChatFooter.this).BTu = 1;
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$39", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(186763);
            return false;
          }
        });
        this.FtB = ((ViewGroup)this.Ftn.getContentView().findViewById(2131302814));
        this.FtC = ((ViewGroup)this.Ftn.getContentView().findViewById(2131302840));
        this.FtD = this.Ftn.getContentView().findViewById(2131302804);
        this.FtE = this.Ftn.getContentView().findViewById(2131302838);
        this.FtF = ((WeImageView)this.Ftn.getContentView().findViewById(2131302805));
        this.FtG = ((WeImageView)this.Ftn.getContentView().findViewById(2131302839));
        this.FtH = this.Ftn.getContentView().findViewById(2131302806);
        this.FtI = this.Ftn.getContentView().findViewById(2131302842);
        this.FtJ = ((ViewGroup)this.Ftn.getContentView().findViewById(2131302841));
        this.FtK = this.Ftn.getContentView().findViewById(2131302820);
        this.FtK.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185353);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ChatFooter.aU(ChatFooter.this);
            ChatFooter.z(ChatFooter.this).setExitType(6);
            ChatFooter.l(ChatFooter.this).dnZ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(185353);
          }
        });
        this.FtL = this.Ftn.getContentView().findViewById(2131302835);
        this.FtL.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185787);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (ChatFooter.l(ChatFooter.this) != null)
            {
              ChatFooter.aU(ChatFooter.this);
              ChatFooter.z(ChatFooter.this).setExitType(7);
              ChatFooter.l(ChatFooter.this).eg(ChatFooter.l(ChatFooter.this).getFileName(), ChatFooter.aV(ChatFooter.this));
              ChatFooter.ay(ChatFooter.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(185787);
          }
        });
        this.FtO = this.Ftn.getContentView().findViewById(2131302832);
        this.FtO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186764);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if ((ChatFooter.aW(ChatFooter.this).getVisibility() == 0) && (8 == ChatFooter.aX(ChatFooter.this).getVisibility()))
            {
              paramAnonymousView = ChatFooter.aA(ChatFooter.this).getText().toString();
              if ((ChatFooter.l(ChatFooter.this) != null) && (!bu.isNullOrNil(paramAnonymousView)))
              {
                ChatFooter.aU(ChatFooter.this);
                ChatFooter.z(ChatFooter.this).BTm = ChatFooter.aK(ChatFooter.this);
                ChatFooter.z(ChatFooter.this).BTq = paramAnonymousView.length();
                if (1 != ChatFooter.z(ChatFooter.this).BTt) {
                  break label210;
                }
                ChatFooter.z(ChatFooter.this).setExitType(8);
              }
            }
            for (;;)
            {
              ChatFooter.l(ChatFooter.this).aqs(paramAnonymousView);
              ChatFooter.l(ChatFooter.this).dnZ();
              ChatFooter.b(ChatFooter.this, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(186764);
              return;
              label210:
              ChatFooter.z(ChatFooter.this).setExitType(5);
            }
          }
        });
        this.FtM = ((WeImageView)this.Ftn.getContentView().findViewById(2131302821));
        this.FtN = ((WeImageView)this.Ftn.getContentView().findViewById(2131302836));
        this.FtP = this.Ftn.getContentView().findViewById(2131302834);
        this.FtQ = ((WeImageView)this.Ftn.getContentView().findViewById(2131302833));
        this.FtR = ((ViewGroup)this.Ftn.getContentView().findViewById(2131302843));
        this.FtS = this.Ftn.getContentView().findViewById(2131302845);
        this.FtT = this.Ftn.getContentView().findViewById(2131302847);
        this.FtU = this.Ftn.getContentView().findViewById(2131302846);
        this.FtV = ((WeImageView)this.Ftn.getContentView().findViewById(2131302844));
        localObject1 = (RelativeLayout.LayoutParams)this.FtR.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).height = (getContext().getResources().getDimensionPixelSize(2131166976) + as.en(getContext()));
        this.FtR.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (FrameLayout.LayoutParams)this.FtV.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (as.en(getContext()) + com.tencent.mm.ui.aq.fromDPToPix(getContext(), 14));
        this.FtV.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.BVf = new aw(new aw.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(186765);
            int i = ChatFooter.aY(ChatFooter.this);
            ChatFooter.aZ(ChatFooter.this);
            switch (i % 3)
            {
            }
            for (;;)
            {
              ChatFooter.ba(ChatFooter.this);
              AppMethodBeat.o(186765);
              return true;
              ChatFooter.c(ChatFooter.this, "·");
              continue;
              ChatFooter.c(ChatFooter.this, "··");
              continue;
              ChatFooter.c(ChatFooter.this, "···");
            }
          }
        }, true);
        this.BVi = new com.tencent.mm.sdk.platformtools.aq(new aq.a()
        {
          public final boolean handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(186766);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(186766);
              return true;
              ChatFooter.z(ChatFooter.this).BTn = 1;
              ChatFooter.z(ChatFooter.this).BTo = System.currentTimeMillis();
              ChatFooter.z(ChatFooter.this).BTs = 0;
              ChatFooter.aS(ChatFooter.this).stopTimer();
              if (ChatFooter.this.BUY != null) {
                ChatFooter.this.BUY.aq(false, false);
              }
              if (!bu.isNullOrNil((String)ChatFooter.aL(ChatFooter.this).get(Integer.valueOf(ChatFooter.aK(ChatFooter.this)))))
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
        this.FtW = this.Ftn.getContentView().findViewById(2131302819);
        this.Ftn.setClippingEnabled(false);
      }
      paramInt = getTransLangTypeByTalker();
      if (com.tencent.mm.modelvoiceaddr.g.iBa == paramInt)
      {
        this.BSY = com.tencent.mm.modelvoiceaddr.g.iBb;
        if (this.Ftx != null) {
          this.Ftx.setSelectedLang(this.BSY);
        }
        ae.d("MicroMsg.ChatFooter", "curTxt:%s", new Object[] { Integer.valueOf(this.Fvb.size()) });
        if ((com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.Jec, true)) || (!com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.Jed, true))) {
          break label1675;
        }
        this.FtA.setTranslationY(com.tencent.mm.ui.aq.fromDPToPix(getContext(), 12));
        this.FtA.setVisibility(0);
        this.FtA.setAlpha(0.0F);
        this.FtA.setText(getContext().getResources().getString(2131761574));
        this.FtA.animate().alpha(1.0F).translationY(0.0F).setDuration(1000L).setStartDelay(500L).start();
        label1180:
        this.Ftq.setTranslationY(0.0F);
        this.Ftt.setTranslationY(0.0F);
        this.Ftw.setTranslationY(0.0F);
        this.FtB.setTranslationY(0.0F);
        paramInt = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 20);
        this.Ftr.setPadding(paramInt, paramInt, paramInt, 0);
        this.Ftr.addTextChangedListener(this.Fuh);
        this.Ftr.setVisibility(8);
        this.Ftr.setCursorVisible(false);
        this.Fts.setVisibility(0);
        this.Fty.setVisibility(8);
        this.FtO.setEnabled(true);
        this.Ftq.setActivated(true);
        this.FtQ.setImageDrawable(ao.k(getContext(), 2131690391, getContext().getResources().getColor(2131099699)));
        this.Ftt.setImageDrawable(ao.k(getContext(), 2131690496, getContext().getResources().getColor(2131099759)));
        localObject1 = (FrameLayout.LayoutParams)this.FtS.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 8);
        this.FtS.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.FtS.setAlpha(0.0F);
        localObject1 = (FrameLayout.LayoutParams)this.FtT.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 8);
        this.FtT.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.FtT.setAlpha(0.0F);
        this.FtC.setTranslationY(this.FuY);
        this.FtC.setAlpha(0.0F);
        this.Fts.setVisibility(8);
        this.FtW.setVisibility(0);
        if (!al.isDarkMode()) {
          break label1759;
        }
        this.Ftp.setBackground(getContext().getResources().getDrawable(2131233433));
      }
      for (;;)
      {
        this.FuL = false;
        this.Ftn.showAtLocation(this, 49, 0, 0);
        fhg();
        this.Ftw.setVisibility(8);
        post(new Runnable()
        {
          public final void run()
          {
            int i = 1;
            AppMethodBeat.i(185791);
            ChatFooter.bb(ChatFooter.this);
            if (ChatFooter.bc(ChatFooter.this) != null)
            {
              ChattingScrollLayout localChattingScrollLayout = ChatFooter.bc(ChatFooter.this);
              int j = ChatFooter.bd(ChatFooter.this).getHeight();
              int k = ChatFooter.be(ChatFooter.this).getHeight();
              int m = com.tencent.mm.ui.ar.en(ChatFooter.this.getContext());
              int n = ChatFooter.a(ChatFooter.this).getHeight();
              if ((localChattingScrollLayout.Fwd == null) || (localChattingScrollLayout.Fwd.getListView() == null)) {
                break label315;
              }
              int i1 = localChattingScrollLayout.Fwd.getListView().getFirstVisiblePosition();
              int i2 = localChattingScrollLayout.Fwd.getListView().getHeaderViewsCount();
              i1 = localChattingScrollLayout.Fwd.getListView().getLastVisiblePosition() - localChattingScrollLayout.Fwd.getListView().getHeaderViewsCount() - (i1 - i2);
              if ((i1 < 0) || (i1 >= localChattingScrollLayout.Fwd.getListView().getChildCount())) {
                break label315;
              }
              View localView = localChattingScrollLayout.Fwd.getListView().getChildAt(i1);
              if (localView == null) {
                break label315;
              }
              int[] arrayOfInt = new int[2];
              localView.getLocationOnScreen(arrayOfInt);
              i1 = arrayOfInt[1];
              if (localView.getHeight() + i1 <= com.tencent.mm.ui.ar.ck(localChattingScrollLayout.getContext()).y - (j + k - m - n)) {
                break label315;
              }
            }
            for (;;)
            {
              if (i != 0)
              {
                ChatFooter.g(ChatFooter.this, ChatFooter.bd(ChatFooter.this).getHeight() + ChatFooter.be(ChatFooter.this).getHeight() - com.tencent.mm.ui.ar.en(ChatFooter.this.getContext()) - ChatFooter.a(ChatFooter.this).getHeight());
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
        this.BSY = paramInt;
        break;
        label1675:
        this.FtA.setTranslationY(com.tencent.mm.ui.aq.fromDPToPix(getContext(), 30));
        this.FtA.setVisibility(0);
        this.FtA.setAlpha(0.0F);
        this.FtA.setText(getContext().getResources().getString(2131761578));
        this.FtA.animate().alpha(1.0F).translationY(0.0F).setDuration(200L).setStartDelay(0L).start();
        break label1180;
        label1759:
        this.Ftp.setBackground(getContext().getResources().getDrawable(2131233434));
      }
    }
    this.Fue = 0;
    int i;
    if (this.FrZ) {
      i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 280);
    }
    for (;;)
    {
      int j = BackwardSupportUtil.b.h(getContext(), 50.0F);
      if (paramInt + j < i)
      {
        this.Fue = -1;
        if (this.BGb == null)
        {
          this.BGb = new o(View.inflate(getContext(), 2131495869, null), -1, -2);
          this.FrU = ((ViewGroup)this.BGb.getContentView().findViewById(2131306525));
          this.rFv = this.BGb.getContentView().findViewById(2131306519);
          this.rFu = ((ImageView)this.BGb.getContentView().findViewById(2131306631));
          this.FrV = ((TextView)this.BGb.getContentView().findViewById(2131306528));
          this.FrV.setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131166735) * com.tencent.mm.cb.a.ip(getContext()));
          this.rFw = this.BGb.getContentView().findViewById(2131306521);
          this.BGc = ((TextView)this.BGb.getContentView().findViewById(2131306523));
          this.BGc.setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131166735) * com.tencent.mm.cb.a.ip(getContext()));
          this.BGd = ((ImageView)this.BGb.getContentView().findViewById(2131306522));
          this.BGe = this.BGb.getContentView().findViewById(2131306524);
          this.rFt = this.BGb.getContentView().findViewById(2131306526);
          this.FsI = ((ViewGroup)this.BGb.getContentView().findViewById(2131306474));
          this.FsJ = this.BGb.getContentView().findViewById(2131306467);
          this.FsM = this.BGb.getContentView().findViewById(2131306478);
          this.FsN = ((ImageView)this.BGb.getContentView().findViewById(2131306479));
          this.FsO = ((ImageView)this.BGb.getContentView().findViewById(2131306466));
          this.FsP = this.BGb.getContentView().findViewById(2131306468);
          this.FsQ = ((TextView)this.BGb.getContentView().findViewById(2131306471));
          this.FsR = ((ImageView)this.BGb.getContentView().findViewById(2131306469));
          this.FsS = this.BGb.getContentView().findViewById(2131306473);
          this.FsT = this.BGb.getContentView().findViewById(2131306463);
          this.FsU = ((WeImageView)this.BGb.getContentView().findViewById(2131306464));
          this.FsV = ((TextView)this.BGb.getContentView().findViewById(2131306465));
          this.FsW = this.BGb.getContentView().findViewById(2131306475);
          this.FsX = ((WeImageView)this.BGb.getContentView().findViewById(2131306476));
          this.FsY = ((TextView)this.BGb.getContentView().findViewById(2131306477));
          this.FsZ = View.inflate(getContext(), 2131494417, null);
        }
      }
      try
      {
        if (j.FvJ == this.Fth)
        {
          localObject1 = this.activity.getWindow().getDecorView();
          Drawable localDrawable = ((View)localObject1).getBackground();
          this.FsK = new BlurView(getContext());
          paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 14);
          BlurView localBlurView = this.FsK.B((ViewGroup)localObject1).adm(getResources().getColor(2131101069)).G(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).bU(15.0F).fEk();
          localBlurView.Kn = (paramInt * 1.0F);
          localBlurView.JRw = true;
          localBlurView.adn(this.Fue).fEl();
          this.Fta = new BlurView(getContext());
          this.Fta.adm(getResources().getColor(2131101069));
          this.Fta.B((ViewGroup)localObject1).G(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).bU(15.0F).fEk().fEl();
        }
        ae.i("MicroMsg.ChatFooter", "transVoiceBlurMode: %s.", new Object[] { this.Fth });
        switch (79.Fvl[this.Fth.ordinal()])
        {
        default: 
          this.Fte.setClippingEnabled(false);
          this.Fte.getContentView().setAlpha(0.0F);
          this.Fte.setOnDismissListener(new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(186767);
              ChatFooter.H(ChatFooter.this).getContentView().setAlpha(0.0F);
              AppMethodBeat.o(186767);
            }
          });
          ((TextView)this.BGb.getContentView().findViewById(2131306470)).setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131166968) * com.tencent.mm.cb.a.ip(getContext()));
          fhh();
          if (this.Fue != -1)
          {
            this.rFt.setVisibility(8);
            this.FrU.setVisibility(8);
            this.BGe.setVisibility(0);
            new com.tencent.mm.sdk.platformtools.aq().post(new Runnable()
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
            if (this.FrZ)
            {
              fhQ();
              this.Ftk = false;
              fhN();
              this.Fte.showAtLocation(this, 49, 0, 0);
              this.Ftj = false;
              if (this.FuJ)
              {
                this.FuJ = false;
                if (j.FvJ != this.Fth) {
                  break label3133;
                }
                this.FsK.adm(getResources().getColor(2131101069)).G(this.activity.getWindow().getDecorView().getBackground()).xU(true);
              }
            }
            this.BGb.showAtLocation(this, 49, 0, this.Fue);
          }
          else
          {
            AppMethodBeat.o(31616);
            return;
            i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 180);
            continue;
            this.Fue = ((paramInt - i) / 2 + j);
          }
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.Fth = j.FvK;
          this.Fuf = true;
          continue;
          this.FsI.removeView(this.FsJ);
          Object localObject2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(2131166964), getResources().getDimensionPixelSize(2131166964));
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          this.FsK.addView(this.FsJ, (ViewGroup.LayoutParams)localObject2);
          this.FsI.addView(this.FsK, (ViewGroup.LayoutParams)localObject2);
          this.FsL = this.FsK;
          localObject2 = new FrameLayout.LayoutParams(-1, -1);
          this.Fta.addView(this.FsZ, (ViewGroup.LayoutParams)localObject2);
          this.Fte = new o(this.Fta, -1, -1);
          continue;
          this.FsL = this.FsJ;
          this.FsL.setBackgroundResource(2131234483);
          this.FsZ.setBackgroundColor(getResources().getColor(2131101071));
          this.Fte = new o(this.FsZ, -1, -1);
          continue;
          label3133:
          this.FsL.setBackgroundResource(2131234483);
        }
      }
    }
  }
  
  public final void ZM(int paramInt)
  {
    AppMethodBeat.i(31622);
    if (this.Ftl)
    {
      if ((this.Fts != null) && (this.Fts.getVisibility() == 0)) {
        this.Fts.Ub(paramInt);
      }
      AppMethodBeat.o(31622);
      return;
    }
    if (this.FrZ)
    {
      i = 0;
      for (;;)
      {
        if (i < FuC.length)
        {
          if ((paramInt >= FuB[i]) && (paramInt < FuB[(i + 1)])) {
            this.FsN.setBackgroundDrawable(com.tencent.mm.cb.a.l(getContext(), FuC[i]));
          }
        }
        else
        {
          if ((paramInt != -1) || (this.BGb == null)) {
            break;
          }
          this.BGb.dismiss();
          this.BGe.setVisibility(0);
          this.FrU.setVisibility(8);
          this.rFt.setVisibility(8);
          AppMethodBeat.o(31622);
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < FuC.length)
      {
        if ((paramInt >= FuB[i]) && (paramInt < FuB[(i + 1)])) {
          this.rFu.setBackgroundDrawable(com.tencent.mm.cb.a.l(getContext(), FuC[i]));
        }
      }
      else
      {
        if ((paramInt == -1) && (this.BGb != null))
        {
          this.BGb.dismiss();
          this.BGe.setVisibility(0);
          this.FrU.setVisibility(8);
          this.rFt.setVisibility(8);
        }
        AppMethodBeat.o(31622);
        return;
      }
      i += 1;
    }
  }
  
  public final void ZN(int paramInt)
  {
    AppMethodBeat.i(31624);
    this.FrY = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31624);
      return;
      wk(true);
      this.Fru.setVisibility(8);
      ZK(2131231707);
      AppMethodBeat.o(31624);
      return;
      wk(false);
      this.Fru.setVisibility(0);
      fhF();
      ZK(2131231706);
      if ((v.aBt().booleanValue()) && (this.Fsz != null))
      {
        c localc = this.Fsz;
        Boolean localBoolean = Boolean.TRUE;
        localc.b(localBoolean, localBoolean);
      }
    }
  }
  
  public final void ZO(int paramInt)
  {
    AppMethodBeat.i(185823);
    b(paramInt, true, 0, 0);
    AppMethodBeat.o(185823);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, com.tencent.mm.modelvoiceaddr.h paramh, boolean paramBoolean2)
  {
    AppMethodBeat.i(185826);
    ae.d("MicroMsg.ChatFooter", "startTrans, hasStartTrans: %s, isForce: %s.", new Object[] { Boolean.valueOf(this.Fvc), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean2) {
      if (this.Fvc)
      {
        if (this.BUY != null) {
          this.BUY.aq(false, true);
        }
        this.BVi.removeMessages(5000);
        this.BVf.stopTimer();
      }
    }
    while (!this.Fvc)
    {
      this.Fvc = true;
      this.BUY = new com.tencent.mm.plugin.transvoice.a.b(paramh, paramInt, new g.b()
      {
        public final void aOo()
        {
          AppMethodBeat.i(186798);
          ae.d("MicroMsg.ChatFooter", "onRecordFin.");
          AppMethodBeat.o(186798);
        }
        
        public final void aOs()
        {
          AppMethodBeat.i(186799);
          if ((ChatFooter.this.BUY != null) && (!ChatFooter.this.BUY.BSZ))
          {
            ae.d("MicroMsg.ChatFooter", "onRecognizeFinish, %s.", new Object[] { Boolean.valueOf(ChatFooter.this.BUY.BSZ) });
            ChatFooter.z(ChatFooter.this).BTs = 1;
            ChatFooter.z(ChatFooter.this).BTo = System.currentTimeMillis();
            ChatFooter.f(ChatFooter.this, false);
            ChatFooter.aT(ChatFooter.this);
            ChatFooter.this.BUY = null;
            ChatFooter.bB(ChatFooter.this).removeMessages(5000);
            ChatFooter.aS(ChatFooter.this).stopTimer();
            ChatFooter.aM(ChatFooter.this);
          }
          AppMethodBeat.o(186799);
        }
        
        public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(186796);
          ae.d("MicroMsg.ChatFooter", "newVoice2txt onRes, %s.", new Object[] { ChatFooter.this.BUY });
          ChatFooter.bA(ChatFooter.this).clear();
          if (!bu.ht(paramAnonymousList)) {
            ChatFooter.bA(ChatFooter.this).addAll(paramAnonymousList);
          }
          if (!ChatFooter.aR(ChatFooter.this))
          {
            ChatFooter.f(ChatFooter.this, true);
            ChatFooter.aA(ChatFooter.this).setFocusable(true);
            ChatFooter.aA(ChatFooter.this).setFocusableInTouchMode(true);
            ChatFooter.aA(ChatFooter.this).requestFocus();
          }
          if ((ChatFooter.this.BUY != null) && (!ChatFooter.this.BUY.BSZ))
          {
            ChatFooter.bB(ChatFooter.this).removeMessages(5000);
            ChatFooter.bB(ChatFooter.this).sendEmptyMessageDelayed(5000, 5000L);
          }
          if (!bu.isNullOrNil(paramAnonymousArrayOfString[0]))
          {
            ChatFooter.aL(ChatFooter.this).put(Integer.valueOf(ChatFooter.aK(ChatFooter.this)), paramAnonymousArrayOfString[0]);
            if (ChatFooter.aL(ChatFooter.this) != null) {
              ChatFooter.z(ChatFooter.this).BTp = paramAnonymousArrayOfString[0].length();
            }
            ae.d("MicroMsg.ChatFooter", "newVoice2txt onRes, curTxt: %s.", new Object[] { paramAnonymousArrayOfString[0] });
          }
          AppMethodBeat.o(186796);
        }
        
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
        {
          AppMethodBeat.i(186797);
          ae.d("MicroMsg.ChatFooter", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong) });
          ChatFooter.z(ChatFooter.this).BTs = 0;
          ChatFooter.z(ChatFooter.this).BTo = System.currentTimeMillis();
          ChatFooter.aT(ChatFooter.this);
          AppMethodBeat.o(186797);
        }
      });
      this.BUY.BSZ = paramBoolean1;
      this.BUY.start();
      this.BVf.ay(500L, 500L);
      AppMethodBeat.o(185826);
      return;
    }
    AppMethodBeat.o(185826);
  }
  
  public final void a(Context paramContext, Activity paramActivity)
  {
    boolean bool2 = true;
    AppMethodBeat.i(31575);
    ae.i("MicroMsg.ChatFooter", "onResume: %s, %s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.aa.iP(paramContext)), Integer.valueOf(getContext().getResources().getConfiguration().orientation) });
    this.Fsf = true;
    this.activity = paramActivity;
    if ((this.Fsk == 48) && (this.Fsg == 1) && (!this.Fsu))
    {
      this.uNO = false;
      h(0, false, -1);
    }
    boolean bool1 = bool2;
    if (getContext().getResources().getConfiguration().orientation != 1)
    {
      if (com.tencent.mm.sdk.platformtools.aa.iP(paramContext)) {
        bool1 = bool2;
      }
    }
    else
    {
      this.Fse = bool1;
      if (com.tencent.mm.compatible.util.d.lA(24)) {
        this.Fsm = ((Activity)getContext()).isInMultiWindowMode();
      }
      fhD();
      fhI();
      if (ap.fdX().Fgz) {
        ap.fdX().hA(ak.getContext());
      }
      if ((!this.Frx.fig()) && (this.qdo != null)) {
        this.qdo.onResume();
      }
      if ((this.FsC) || (!this.Fsb)) {
        break label293;
      }
      fhx();
    }
    for (;;)
    {
      ZQ(getKeyBordHeightPX());
      if (this.Frs != null) {
        this.Frs.context = paramContext;
      }
      this.FrI.Fwo = false;
      if (!this.FmA) {
        fhw();
      }
      fhc();
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
      if ((this.FsC) && (!this.Fsb)) {
        fhv();
      }
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(31574);
    this.FsE = paramb;
    this.FrK = new com.tencent.mm.plugin.groupsolitaire.ui.d(getContext(), this.FsE.fie(), new d.d()
    {
      public final void aoa(String paramAnonymousString)
      {
        AppMethodBeat.i(185758);
        if ((ChatFooter.l(ChatFooter.this) != null) && (!bu.isNullOrNil(paramAnonymousString))) {
          ChatFooter.l(ChatFooter.this).aoa(paramAnonymousString);
        }
        AppMethodBeat.o(185758);
      }
      
      public final void dey()
      {
        AppMethodBeat.i(185757);
        ChatFooter.this.dey();
        ChatFooter.this.fha();
        AppMethodBeat.o(185757);
      }
    });
    this.FrK.uOv = this.Fsx;
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
        if (ChatFooter.this.Ftl)
        {
          switch (ChatFooter.79.Fvn[paramh.ordinal()])
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
    AppMethodBeat.i(186804);
    if (paramBoolean.booleanValue()) {
      a.b.d(this.FrT, paramString);
    }
    for (;;)
    {
      setHint(paramCharSequence);
      this.FrT.setVisibility(0);
      AppMethodBeat.o(186804);
      return;
      a.b.c(this.FrT, paramString);
    }
  }
  
  public final boolean aG(bv parambv)
  {
    AppMethodBeat.i(31678);
    if (this.FrL != null) {
      this.FrL.dod();
    }
    this.FrF.setTag(parambv);
    this.FrY = 1;
    wk(true);
    this.Fru.setVisibility(8);
    ZK(2131231707);
    if (this.Fmx != null)
    {
      this.Fmx.setVisibility(8);
      this.FmA = false;
      this.Fmx.reset();
    }
    showVKB();
    wj(true);
    aOv("");
    AppMethodBeat.o(31678);
    return true;
  }
  
  public final void aM(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31632);
    this.Frs.vY(paramBoolean1);
    this.Frs.vZ(paramBoolean2);
    AppMethodBeat.o(31632);
  }
  
  public final void aOv(String paramString)
  {
    AppMethodBeat.i(31675);
    com.tencent.mm.plugin.groupsolitaire.ui.d locald;
    String str2;
    if ((this.FrK != null) && (this.gpu != null) && (this.FsE != null))
    {
      locald = this.FrK;
      str2 = this.FsE.getTalkerUserName();
      localObject = this.gpu;
      ae.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow supportAnalyze:%s supportShow:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).anM(str2)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).anN(str2)) });
      locald.uOw = ((View)localObject);
      locald.content = paramString;
      if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).anM(str2))
      {
        if ((bu.isNullOrNil(paramString)) || (paramString.equals(locald.uOk))) {
          break label324;
        }
        com.tencent.e.h.MqF.bbc("GroupSolitaireCheck");
      }
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).abU(paramString);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    locald.uOt.setContent(paramString);
    locald.uOt.anZ(locald.uNM);
    com.tencent.e.h.MqF.a(locald.uOt, 500L, "GroupSolitaireCheck");
    Object localObject = paramString;
    if (bu.isNullOrNil(locald.uOk))
    {
      locald.uOu.setContent(paramString);
      locald.uOu.anZ(locald.uNM);
      com.tencent.e.h.MqF.a(locald.uOu, 500L, "GroupSolitaireCopyCheck");
      localObject = paramString;
    }
    for (;;)
    {
      locald.uOk = ((String)localObject);
      locald.uNM = str2;
      AppMethodBeat.o(31675);
      return;
      label324:
      String str1 = paramString;
      if (bu.isNullOrNil(paramString))
      {
        locald.dev();
        str1 = paramString;
      }
    }
  }
  
  public final void aZ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31602);
    if (this.FrP.Fvt.containsKey(paramString1)) {}
    Object localObject;
    for (paramString1 = (LinkedList)this.FrP.Fvt.get(paramString1);; paramString1 = (String)localObject)
    {
      localObject = new HashMap(1);
      ((HashMap)localObject).put(paramString3, paramString2);
      paramString1.add(localObject);
      AppMethodBeat.o(31602);
      return;
      localObject = new LinkedList();
      this.FrP.Fvt.put(paramString1, localObject);
    }
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(31615);
    this.Fud = new i(paramTextWatcher);
    this.vNt.addTextChangedListener(this.Fud);
    AppMethodBeat.o(31615);
  }
  
  public final void bg(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(31625);
    ZN(paramInt);
    switch (paramInt)
    {
    default: 
      setVisibility(0);
      AppMethodBeat.o(31625);
      return;
    case 1: 
      if (paramBoolean)
      {
        wj(true);
        showVKB();
        if (this.vNt.length() > 0) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          ol(paramBoolean);
          AppMethodBeat.o(31625);
          return;
        }
      }
      if (this.vNt.length() > 0) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        ol(paramBoolean);
        AppMethodBeat.o(31625);
        return;
      }
    }
    g(0, true, -1);
    ol(false);
    AppMethodBeat.o(31625);
  }
  
  public final void cfn()
  {
    AppMethodBeat.i(31610);
    this.Ftf.setExitType(1);
    this.Fru.setEnabled(false);
    this.Fru.setBackgroundResource(2131233809);
    if (this.Ftl)
    {
      this.Ftn.update();
      this.pAg.sendEmptyMessageDelayed(0, 500L);
      AppMethodBeat.o(31610);
      return;
    }
    if (this.BGb != null)
    {
      this.rFt.setVisibility(0);
      this.FrU.setVisibility(8);
      this.BGe.setVisibility(8);
      this.BGb.update();
      this.Fte.dismiss();
    }
    this.pAg.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(31610);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31578);
    if (this.qdo != null)
    {
      ae.i("MicroMsg.ChatFooter", "jacks chat footer destroy smiley panel");
      this.qdo.ffs();
      this.qdo.destroy();
      this.qdo.animate().cancel();
      this.qdo = null;
    }
    if (this.Fmx != null)
    {
      this.Fmx.destroy();
      this.Fmx = null;
      this.FmA = false;
    }
    if (this.FrL != null) {
      this.FrL.release();
    }
    if (this.FrJ != null)
    {
      this.FrJ.FsB = null;
      this.FrJ.Fwz = null;
      this.FrJ.hide();
    }
    if (this.BGb != null)
    {
      if (this.FsK != null) {
        this.FsK.getBlurController().destroy();
      }
      if (this.Fta != null) {
        this.Fta.getBlurController().destroy();
      }
    }
    ae.i("MicroMsg.ChatFooter", "jacks destroy chat footer.");
    AppMethodBeat.o(31578);
  }
  
  public final void dey()
  {
    AppMethodBeat.i(31679);
    if (this.vNt != null)
    {
      this.vNt.setText("");
      fgZ();
    }
    AppMethodBeat.o(31679);
  }
  
  public final void fV(View paramView)
  {
    int i = -1;
    AppMethodBeat.i(163212);
    if (this.FrL != null) {
      this.FrL.doc();
    }
    ae.i("MicroMsg.ChatFooter", "click attach btn: %s, %s", new Object[] { Integer.valueOf(this.Frs.getVisibility()), Boolean.valueOf(this.Frx.fig()) });
    if (this.Fsg == 3)
    {
      if (this.FrY == 1)
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
      if ((this.Fmx != null) && (this.Fmx.getVisibility() == 0) && (this.FmA))
      {
        ae.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
        this.Fmx.setVisibility(8);
        this.FmA = false;
        this.Fmx.reset();
      }
      paramView = ap.fdX();
      localObject = ak.getContext();
      if ((com.tencent.mm.kernel.g.ajM()) && (localObject != null)) {
        break label284;
      }
      label187:
      ap.fdX().hA(ak.getContext());
      if ((x.zU(this.toUser)) && (com.tencent.mm.chatroom.d.aa.Yr()))
      {
        paramView = this.toUser;
        if (!x.Bj(paramView)) {
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
        ((com.tencent.mm.g.b.a.q)localObject).gT(paramView);
        ((com.tencent.mm.g.b.a.q)localObject).dQX = 1L;
        ((com.tencent.mm.g.b.a.q)localObject).dTO = i;
        ((com.tencent.mm.g.b.a.q)localObject).aLH();
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
          String str = com.tencent.mm.n.g.acL().getValue("ShowAPPSuggestion");
          if ((bu.isNullOrNil(str)) || (Integer.valueOf(str).intValue() != 1)) {
            ae.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[] { str });
          }
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[] { localException.getMessage() });
          if (paramView.Fgt)
          {
            ae.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
            break label187;
          }
          ae.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
          paramView.Fgt = true;
          if (System.currentTimeMillis() - paramView.Fgw < 43200000L)
          {
            ae.d("MicroMsg.SuggestionAppListLogic", "not now");
            paramView.Fgt = false;
            break label187;
          }
          com.tencent.mm.kernel.g.ajS();
          paramView.Fgw = com.tencent.mm.kernel.g.ajR().ajA().aby(352275);
          if (System.currentTimeMillis() - paramView.Fgw < 43200000L)
          {
            ae.w("MicroMsg.SuggestionAppListLogic", "not now sp");
            paramView.Fgt = false;
            break label187;
          }
          if (paramView.lang == null) {
            paramView.lang = ad.f(((Context)localObject).getSharedPreferences(ak.fow(), 0));
          }
          paramView = new af(paramView.lang, new LinkedList());
          com.tencent.mm.plugin.s.a.dBj();
          com.tencent.mm.pluginsdk.model.app.e.a(4, paramView);
        }
      }
      break label187;
      label529:
      if (x.Bi(paramView)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void ffS()
  {
    AppMethodBeat.i(31601);
    if (!this.FmA)
    {
      AppMethodBeat.o(31601);
      return;
    }
    this.FmA = false;
    if (this.Fmx != null)
    {
      int i = getKeyBordHeightPX();
      int j = this.Frw.getHeight();
      this.Fmx.animate().cancel();
      this.Fmx.animate().translationY(i + j).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186756);
          if (ChatFooter.ax(ChatFooter.this) != null)
          {
            ChatFooter.ax(ChatFooter.this).destroy();
            ChatFooter.ax(ChatFooter.this).setVisibility(8);
          }
          AppMethodBeat.o(186756);
        }
      }).start();
    }
    this.vNt.setText("");
    AppMethodBeat.o(31601);
  }
  
  public final void fft()
  {
    AppMethodBeat.i(31591);
    this.Fsc = true;
    if (this.qdo != null) {
      this.qdo.fft();
    }
    AppMethodBeat.o(31591);
  }
  
  public final void fgZ()
  {
    AppMethodBeat.i(31572);
    if (this.Fsy != null)
    {
      com.tencent.mm.g.b.a.d locald = this.Fsy;
      locald.dRh = 0L;
      locald.dRf = 0L;
      locald.dRg = 0L;
      locald.dRi = 0L;
      locald.bn(0L).bo(0L);
    }
    AppMethodBeat.o(31572);
  }
  
  public final void fhA()
  {
    AppMethodBeat.i(31653);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179780);
        ae.i("MicroMsg.ChatFooter", "withLastText: ");
        ChatFooter.this.showVKB();
        ChatFooter.a(ChatFooter.this, true);
        AppMethodBeat.o(179780);
      }
    }, 500L);
    AppMethodBeat.o(31653);
  }
  
  public final void fhB()
  {
    AppMethodBeat.i(31655);
    if ((this.Fmx != null) && (this.Fmx.isShown())) {
      this.Fmx.fio();
    }
    AppMethodBeat.o(31655);
  }
  
  public final void fhE()
  {
    AppMethodBeat.i(186803);
    if (this.FrJ != null)
    {
      this.FrJ.FwA = false;
      this.FrJ.hide();
    }
    AppMethodBeat.o(186803);
  }
  
  public final void fhF()
  {
    AppMethodBeat.i(31674);
    if (this.FrK != null) {
      this.FrK.dev();
    }
    AppMethodBeat.o(31674);
  }
  
  public final boolean fhG()
  {
    AppMethodBeat.i(31677);
    if ((this.FrF.getTag() != null) && ((this.FrF.getTag() instanceof bv)) && (this.FrE.isShown()) && (this.FrF.isShown()))
    {
      AppMethodBeat.o(31677);
      return true;
    }
    AppMethodBeat.o(31677);
    return false;
  }
  
  public final void fhH()
  {
    AppMethodBeat.i(31681);
    this.Fru.setBackgroundResource(2131232725);
    this.Fru.setText(2131757093);
    Object localObject;
    if (this.Ftl)
    {
      if (!this.FuL)
      {
        this.FuL = true;
        if (this.FrL == null) {
          break label299;
        }
        this.Ftf.BTj = this.FrL.PY();
        if ((this.Ftn == null) || (!this.Ftn.isShowing())) {
          break label299;
        }
        if (e.Fvv == this.FuZ)
        {
          this.FtZ = false;
          this.FrL.dnY();
          this.Ftf.setExitType(2);
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jed, Boolean.FALSE);
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        AppMethodBeat.o(31681);
        return;
      }
      if (e.Fvw == this.FuZ)
      {
        if (this.FuK <= 0) {
          this.FuK = ((int)this.FrL.PY());
        }
        if (!bu.isNullOrNil(this.FrL.getFileName()))
        {
          localObject = com.tencent.mm.cj.a.Jmx;
          com.tencent.mm.cj.a.a.aWK(this.FrL.getFileName());
        }
        this.FrL.dnW();
        fia();
        this.BVi.sendEmptyMessageDelayed(5000, 5000L);
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jed, Boolean.FALSE);
        AppMethodBeat.o(31681);
        return;
      }
      if (e.Fvu == this.FuZ)
      {
        this.FtZ = false;
        this.FrL.dnV();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jec, Boolean.FALSE);
      }
      label299:
      AppMethodBeat.o(31681);
      return;
    }
    this.pzT = false;
    if (this.FrL != null)
    {
      this.Ftf.BTj = this.FrL.PY();
      if (this.FrZ)
      {
        if (k.FvM != this.Fti)
        {
          this.FuJ = true;
          if ((this.BGb != null) && (this.BGb.isShowing()))
          {
            if (k.FvO == this.Fti)
            {
              ae.i("MicroMsg.ChatFooter", "do not send voice.");
              this.Ftf.setExitType(2);
              this.FrL.dnY();
              AppMethodBeat.o(31681);
              return;
            }
            ae.i("MicroMsg.ChatFooter", "trans voice to txt.");
            this.FrL.dnW();
            localObject = this.FrL.getFileName();
            final long l = this.FrL.PY();
            ae.i("transvoice", "fileName: %s, voiceLen: %d.", new Object[] { localObject, Long.valueOf(l) });
            if (az.isConnected(getContext()))
            {
              if (this.Ftd.isValid())
              {
                this.Ftb.aEx((String)localObject);
                this.Ftb.BVa = l;
                this.Ftb.talker = this.Frr;
                this.Ftb.show();
                this.Ftb.c(this.Ftd);
                this.Fsn = false;
                AppMethodBeat.o(31681);
                return;
              }
              this.Ftf.setExitType(3);
              locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
              locala.aZi(getResources().getString(2131764730));
              locala.aZo(getResources().getString(2131764731));
              locala.afW(getResources().getColor(2131099770));
              locala.c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(186776);
                  ChatFooter.l(ChatFooter.this).aqt(this.cZx);
                  AppMethodBeat.o(186776);
                }
              });
              locala.zf(false);
              locala.fQv().show();
              AppMethodBeat.o(31681);
              return;
            }
            this.Ftf.setExitType(4);
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
            locala.aZi(getResources().getString(2131761547));
            locala.aZo(getResources().getString(2131761549));
            locala.afW(getResources().getColor(2131099770));
            locala.aZp(getResources().getString(2131761548));
            locala.c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(186777);
                ChatFooter.l(ChatFooter.this).eg(this.cZx, (int)l);
                AppMethodBeat.o(186777);
              }
            });
            locala.d(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(186778);
                ChatFooter.l(ChatFooter.this).aqt(this.cZx);
                AppMethodBeat.o(186778);
              }
            });
            locala.fQv().show();
            AppMethodBeat.o(31681);
          }
        }
        else
        {
          this.FrL.dnV();
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        if ((this.rFw != null) && (this.rFw.getVisibility() == 0))
        {
          this.Ftf.setExitType(2);
          this.FrL.dnY();
          AppMethodBeat.o(31681);
          return;
        }
        this.FrL.dnV();
      }
    }
    AppMethodBeat.o(31681);
  }
  
  public final void fhI()
  {
    AppMethodBeat.i(31683);
    bc.aCg();
    this.FsC = ((Boolean)com.tencent.mm.model.c.ajA().get(66832, Boolean.FALSE)).booleanValue();
    if (this.vNt != null) {
      this.vNt.setEnableSendBtn(this.FsC);
    }
    AppMethodBeat.o(31683);
  }
  
  public final boolean fhJ()
  {
    AppMethodBeat.i(186805);
    if ((this.FsE != null) && (this.FsE.fif() != null))
    {
      if ((!((com.tencent.mm.ui.chatting.d.b.h)this.FsE.fif().bh(com.tencent.mm.ui.chatting.d.b.h.class)).fHo()) && (!((com.tencent.mm.ui.chatting.d.b.i)this.FsE.fif().bh(com.tencent.mm.ui.chatting.d.b.i.class)).fHq()))
      {
        AppMethodBeat.o(186805);
        return true;
      }
      AppMethodBeat.o(186805);
      return false;
    }
    AppMethodBeat.o(186805);
    return true;
  }
  
  public final void fhK()
  {
    AppMethodBeat.i(31685);
    if ((this.gpu == null) || (this.gpu.getVisibility() == 8))
    {
      AppMethodBeat.o(31685);
      return;
    }
    if (this.FuP == 0)
    {
      this.FuP = this.gpu.getWidth();
      this.FuQ = this.Frz.getWidth();
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.FuP, this.FuQ });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(186779);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bu(ChatFooter.this)) / (ChatFooter.bv(ChatFooter.this) - ChatFooter.bu(ChatFooter.this));
        ChatFooter.k(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(186779);
      }
    });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186782);
        ChatFooter.k(ChatFooter.this).setVisibility(8);
        AppMethodBeat.o(186782);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186781);
        if (!ChatFooter.bw(ChatFooter.this))
        {
          ChatFooter.k(ChatFooter.this).setVisibility(8);
          AppMethodBeat.o(186781);
          return;
        }
        ae.i("MicroMsg.ChatFooter", "animHideSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bw(ChatFooter.this)) });
        ChatFooter.this.fhL();
        AppMethodBeat.o(186781);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186780);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(186780);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.start();
    AppMethodBeat.o(31685);
  }
  
  public final void fhL()
  {
    AppMethodBeat.i(31686);
    if (this.gpu == null)
    {
      AppMethodBeat.o(31686);
      return;
    }
    if (this.FuP == 0)
    {
      this.FuP = this.gpu.getWidth();
      this.FuQ = this.Frz.getWidth();
    }
    if (this.FuP == 0)
    {
      this.gpu.startAnimation(this.FsF);
      this.gpu.setVisibility(0);
      AppMethodBeat.o(31686);
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.FuQ, this.FuP });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(185384);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bu(ChatFooter.this)) / (ChatFooter.bv(ChatFooter.this) - ChatFooter.bu(ChatFooter.this));
        ChatFooter.k(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(185384);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186785);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.i(ChatFooter.this, false);
        AppMethodBeat.o(186785);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186784);
        paramAnonymousAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousAnimator.width = -2;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousAnimator);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.i(ChatFooter.this, false);
        if (!ChatFooter.bw(ChatFooter.this))
        {
          ae.i("MicroMsg.ChatFooter", "animShowSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bw(ChatFooter.this)) });
          ChatFooter.r(ChatFooter.this).setVisibility(0);
          ChatFooter.i(ChatFooter.this, true);
          ChatFooter.this.fhK();
        }
        AppMethodBeat.o(186784);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186783);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(186783);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(31686);
  }
  
  public final void fhM()
  {
    AppMethodBeat.i(186806);
    if ((this.Frz != null) && (this.Frz.getVisibility() == 0))
    {
      wn(true);
      AppMethodBeat.o(186806);
      return;
    }
    AppMethodBeat.o(186806);
  }
  
  public final void fha()
  {
    AppMethodBeat.i(31581);
    if (!bu.ah(this.FrG.getText())) {
      this.FrG.setText("");
    }
    if (this.FrF.getTag() != null) {
      this.FrF.setTag(null);
    }
    this.FrF.setVisibility(8);
    AppMethodBeat.o(31581);
  }
  
  public final void fhb()
  {
    AppMethodBeat.i(31583);
    if (this.Frs == null)
    {
      AppMethodBeat.o(31583);
      return;
    }
    this.Frs.fgB();
    AppMethodBeat.o(31583);
  }
  
  public final void fhc()
  {
    AppMethodBeat.i(31587);
    this.FrB = ((ImageButton)this.iBX.findViewById(2131298172));
    this.FrB.setVisibility(0);
    if (!com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IYz, true)) {
      this.iBX.findViewById(2131298173).setVisibility(0);
    }
    for (;;)
    {
      this.iBX.findViewById(2131298173).setVisibility(8);
      this.FrB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184916);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = com.tencent.mm.emoji.b.a.gqT;
          com.tencent.mm.emoji.b.a.agj();
          if (ChatFooter.l(ChatFooter.this) != null) {
            ChatFooter.l(ChatFooter.this).dob();
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
              ChatFooter.this.fft();
            }
            ChatFooter.this.fhf();
            if (!com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IYz, false))
            {
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYz, Boolean.TRUE);
              ChatFooter.t(ChatFooter.this).findViewById(2131298173).setVisibility(8);
            }
          }
        }
      });
      if (this.FrJ != null) {
        this.FrJ.Fwy = this.FrB;
      }
      if (this.FrK != null) {
        this.FrK.uOh = this.iBX;
      }
      AppMethodBeat.o(31587);
      return;
      this.iBX.findViewById(2131298173).setVisibility(8);
    }
  }
  
  public final void fhd()
  {
    boolean bool = true;
    AppMethodBeat.i(31590);
    if ((e.Fwh == null) || (getContext() == null))
    {
      if (getContext() == null)
      {
        ae.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", new Object[] { bu.fpN() });
        this.qdo = new d(ak.getContext());
        AppMethodBeat.o(31590);
        return;
      }
      this.qdo = new d(getContext());
      AppMethodBeat.o(31590);
      return;
    }
    if (this.qdo != null) {
      this.qdo.destroy();
    }
    this.qdo = e.Fwh.eE(getContext());
    ChatFooterPanel localChatFooterPanel;
    if (this.qdo != null)
    {
      this.qdo.setEntranceScene(ChatFooterPanel.FkK);
      this.qdo.setVisibility(8);
      this.qdo.setFooterType(this.DUO);
      if (this.Frx != null) {
        this.Frx.addView(this.qdo, -1, -1);
      }
      this.qdo.setOnTextOperationListener(this.Fua);
      localChatFooterPanel = this.qdo;
      if (this.vNt.getText().length() <= 0) {
        break label269;
      }
    }
    for (;;)
    {
      localChatFooterPanel.setSendButtonEnable(bool);
      if (this.FsE != null) {
        this.qdo.setTalkerName(this.FsE.getTalkerUserName());
      }
      this.qdo.onResume();
      if (this.Fsc) {
        fft();
      }
      setSmileyPanelCallback(this.FkI);
      AppMethodBeat.o(31590);
      return;
      label269:
      bool = false;
    }
  }
  
  public final void fhf()
  {
    AppMethodBeat.i(31597);
    this.FrY = 1;
    wk(true);
    if (this.vNt.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ol(bool);
      this.Fru.setVisibility(8);
      ZK(2131231707);
      if (this.Fmx != null)
      {
        this.Fmx.setVisibility(8);
        this.FmA = false;
        this.Fmx.reset();
      }
      g(2, true, -1);
      AppMethodBeat.o(31597);
      return;
    }
  }
  
  public final void fhi()
  {
    AppMethodBeat.i(31620);
    if (this.Ftl)
    {
      this.Fts.setVisibility(0);
      this.FtW.setVisibility(8);
      AppMethodBeat.o(31620);
      return;
    }
    this.BGe.setVisibility(8);
    this.FrU.setVisibility(0);
    AppMethodBeat.o(31620);
  }
  
  public final void fhj()
  {
    AppMethodBeat.i(31626);
    wk(true);
    this.Frv.setVisibility(8);
    this.Fru.setVisibility(8);
    AppMethodBeat.o(31626);
  }
  
  public final void fhk()
  {
    AppMethodBeat.i(31627);
    if (this.Frv != null) {
      this.Frv.setVisibility(0);
    }
    AppMethodBeat.o(31627);
  }
  
  public final void fhl()
  {
    AppMethodBeat.i(31628);
    AppPanel localAppPanel = this.Frs;
    localAppPanel.FpZ.Fqw.value = false;
    localAppPanel.fgM();
    AppMethodBeat.o(31628);
  }
  
  public final void fhm()
  {
    AppMethodBeat.i(31629);
    AppPanel localAppPanel = this.Frs;
    localAppPanel.FpZ.FqO.value = false;
    localAppPanel.fgM();
    AppMethodBeat.o(31629);
  }
  
  public final void fhn()
  {
    AppMethodBeat.i(31630);
    AppPanel localAppPanel = this.Frs;
    localAppPanel.FpZ.Fqx.value = false;
    localAppPanel.fgM();
    AppMethodBeat.o(31630);
  }
  
  public final void fho()
  {
    AppMethodBeat.i(31631);
    AppPanel localAppPanel = this.Frs;
    localAppPanel.FpZ.FqA.value = false;
    localAppPanel.fgM();
    AppMethodBeat.o(31631);
  }
  
  public final void fhp()
  {
    AppMethodBeat.i(31635);
    AppPanel localAppPanel = this.Frs;
    localAppPanel.Fqh = true;
    localAppPanel.FpZ.wg(false);
    localAppPanel.fgM();
    ae.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", new Object[] { bu.fpN().toString() });
    AppMethodBeat.o(31635);
  }
  
  public final void fhq()
  {
    this.Frs.Fqk = true;
  }
  
  public final void fhr()
  {
    AppMethodBeat.i(31636);
    AppPanel localAppPanel = this.Frs;
    localAppPanel.Fqi = true;
    localAppPanel.FpZ.wd(false);
    localAppPanel.fgM();
    ae.i("MicroMsg.AppPanel", "disableServiceRemittance %s", new Object[] { bu.fpN().toString() });
    AppMethodBeat.o(31636);
  }
  
  public final void fhs()
  {
    AppMethodBeat.i(186802);
    AppPanel localAppPanel = this.Frs;
    localAppPanel.FpZ.Fqy.value = false;
    localAppPanel.fgM();
    AppMethodBeat.o(186802);
  }
  
  public final void fht()
  {
    AppMethodBeat.i(31637);
    if (this.FrB != null) {
      this.FrB.setVisibility(8);
    }
    AppMethodBeat.o(31637);
  }
  
  public final void fhu()
  {
    AppMethodBeat.i(31638);
    AppPanel localAppPanel = this.Frs;
    localAppPanel.Fqj = true;
    localAppPanel.FpZ.wh(false);
    localAppPanel.fgM();
    AppMethodBeat.o(31638);
  }
  
  public final void fhv()
  {
    AppMethodBeat.i(31639);
    ae.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
    this.Fsb = true;
    this.vNt.setImeOptions(4);
    this.vNt.setInputType(this.vNt.getInputType() & 0xFFFFFFBF);
    AppMethodBeat.o(31639);
  }
  
  public final boolean fhy()
  {
    AppMethodBeat.i(31645);
    if ((this.FsD == null) || (this.FsD.getView() == null))
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Object localObject = this.FsD.getView().findViewById(2131302320);
    if (localObject == null)
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Rect localRect = new Rect();
    ((View)localObject).getGlobalVisibleRect(localRect);
    if (com.tencent.mm.compatible.util.d.lA(28))
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
  
  public final boolean fhz()
  {
    return this.Fsg != 0;
  }
  
  public final boolean fib()
  {
    AppMethodBeat.i(185416);
    if ((this.Ftn != null) && (this.Ftn.isShowing()))
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
    ae.i("MicroMsg.ChatFooter", "configPanel: %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uNO), Boolean.valueOf(this.Fsm), Boolean.valueOf(this.Fse) });
    int i;
    int j;
    label98:
    int k;
    if ((this.Fsm) || (!this.Fse))
    {
      i = 1;
      if ((paramInt1 != 1) || (this.uNO)) {
        break label199;
      }
      j = 1;
      if ((paramInt1 == 1) || (!this.uNO)) {
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
        this.Fso = 0;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186770);
            ChatFooter.a(ChatFooter.this, true);
            ChatFooter.this.setToSendTextColor(true);
            boolean bool = ChatFooter.aO(ChatFooter.this).showSoftInput(ChatFooter.d(ChatFooter.this), 0);
            ChatFooter.bp(ChatFooter.this);
            ae.i("MicroMsg.ChatFooter", "showSoftInput %b, %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(ChatFooter.bq(ChatFooter.this)) });
            if ((!bool) && (ChatFooter.bq(ChatFooter.this) < 10)) {
              ChatFooter.this.postDelayed(this, 100L);
            }
            AppMethodBeat.o(186770);
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
      this.uNO = paramBoolean;
      AppMethodBeat.o(163217);
      return;
      i = 0;
      break;
      j = 0;
      break label98;
      k = 0;
      break label113;
      this.Fsh = paramInt1;
      break label135;
    }
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163215);
    ArrayList localArrayList = this.Frs.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163215);
    return localArrayList;
  }
  
  public String getAtSomebody()
  {
    return this.FrP.Fvr;
  }
  
  public int getBarGroupHeight()
  {
    AppMethodBeat.i(31585);
    if (this.FrW == null) {
      this.FrW = findViewById(2131298090);
    }
    if (this.FrW != null)
    {
      i = this.FrW.getHeight();
      AppMethodBeat.o(31585);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131165299);
    AppMethodBeat.o(31585);
    return i;
  }
  
  public f getCallback()
  {
    return this.FkI;
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
    return this.Fsl;
  }
  
  public z.a getIOnToDoBarCallback()
  {
    return this.Fsw;
  }
  
  public int getInsertPos()
  {
    return this.FrP.Fvs;
  }
  
  public boolean getIsVoiceInputPanleShow()
  {
    return this.FmA;
  }
  
  public int getKeyBordHeightPX()
  {
    AppMethodBeat.i(31671);
    int i = com.tencent.mm.sdk.platformtools.aa.iN(getContext());
    AppMethodBeat.o(31671);
    return i;
  }
  
  public String getLastContent()
  {
    return this.FrP.Fvq;
  }
  
  public long getLastQuoteMsgId()
  {
    AppMethodBeat.i(31612);
    if ((this.FrF.getTag() != null) && ((this.FrF.getTag() instanceof bv)))
    {
      long l = ((bv)this.FrF.getTag()).field_msgId;
      AppMethodBeat.o(31612);
      return l;
    }
    AppMethodBeat.o(31612);
    return 0L;
  }
  
  public String getLastText()
  {
    AppMethodBeat.i(31611);
    if (this.vNt == null)
    {
      AppMethodBeat.o(31611);
      return "";
    }
    String str = this.vNt.getText().toString();
    AppMethodBeat.o(31611);
    return str;
  }
  
  public int getMode()
  {
    return this.FrY;
  }
  
  public View getPanel()
  {
    return this.Frx;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(31613);
    int i = this.vNt.getSelectionStart();
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
    if (this.Fsg == 0) {
      i = getHeight() - this.Fsq;
    }
    for (;;)
    {
      AppMethodBeat.o(31684);
      return i;
      int j = getHeight() - this.Fsq + getKeyBordHeightPX();
      i = j;
      if (this.Fsv != null) {
        i = j - this.Fsv.dew();
      }
    }
  }
  
  public final int gm(String paramString, int paramInt)
  {
    AppMethodBeat.i(163213);
    int i = paramInt;
    if (this.FrP.Fvt.containsKey(paramString))
    {
      i = paramInt;
      if (((LinkedList)this.FrP.Fvt.get(paramString)).size() > 0) {
        i = paramInt | 0x1;
      }
    }
    paramInt = i;
    if (this.FrS) {
      paramInt = i | 0x2;
    }
    AppMethodBeat.o(163213);
    return paramInt;
  }
  
  public final boolean hideVKB()
  {
    AppMethodBeat.i(31659);
    if (getKeyBordHeightPX() / 2 <= getBottom())
    {
      boolean bool = bu.hideVKB(this);
      AppMethodBeat.o(31659);
      return bool;
    }
    AppMethodBeat.o(31659);
    return false;
  }
  
  public final void k(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(31582);
    if ((this.FrF.getTag() != null) && ((this.FrF.getTag() instanceof bv)) && (bu.az(paramLong, ((bv)this.FrF.getTag()).field_msgId))) {
      com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185798);
          if (!paramBoolean) {
            com.tencent.mm.ui.base.h.c(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(2131761359), "", true);
          }
          ChatFooter.this.fha();
          AppMethodBeat.o(185798);
        }
      });
    }
    AppMethodBeat.o(31582);
  }
  
  public final void lE(String paramString1, String paramString2)
  {
    this.dzZ = paramString1;
    this.toUser = paramString2;
  }
  
  public final HashMap<String, String> lF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31603);
    long l = System.currentTimeMillis();
    if (bu.isNullOrNil(paramString2))
    {
      if (this.FrP.Fvt.containsKey(paramString1)) {
        this.FrP.Fvt.remove(paramString1);
      }
      AppMethodBeat.o(31603);
      return null;
    }
    if ((!this.FrP.Fvt.containsKey(paramString1)) || (((LinkedList)this.FrP.Fvt.get(paramString1)).size() <= 0))
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
    ae.i("MicroMsg.ChatFooter", "after split @ :%s", new Object[] { localObject });
    if (((List)localObject).size() <= 0)
    {
      ((LinkedList)this.FrP.Fvt.get(paramString1)).clear();
      AppMethodBeat.o(31603);
      return null;
    }
    paramString1 = (LinkedList)this.FrP.Fvt.get(paramString1);
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      ae.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", new Object[] { Integer.valueOf(paramString1.size()) });
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
      ae.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", new Object[] { Integer.valueOf(paramString2.size()) });
      ((HashMap)localObject).put("atuserlist", "<![CDATA[" + bu.m(paramString2, ",") + "]]>");
      paramString1.clear();
      ae.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(31603);
      return localObject;
    }
    ae.w("MicroMsg.ChatFooter", "list is null or size 0");
    AppMethodBeat.o(31603);
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(31579);
    super.onAttachedToWindow();
    fhD();
    fhC();
    ZQ(getKeyBordHeightPX());
    AppMethodBeat.o(31579);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31643);
    super.onConfigurationChanged(paramConfiguration);
    if (com.tencent.mm.compatible.util.d.lA(24)) {
      this.Fsm = ((Activity)getContext()).isInMultiWindowMode();
    }
    if (paramConfiguration.orientation == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.Fse = bool;
      g(0, false, -1);
      fhD();
      ae.i("MicroMsg.ChatFooter", "onConfigurationChanged: %s, %s, %s", new Object[] { paramConfiguration, Boolean.valueOf(this.Fse), Boolean.valueOf(this.Fsm) });
      ZQ(getKeyBordHeightPX());
      AppMethodBeat.o(31643);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(31580);
    super.onDetachedFromWindow();
    this.fSZ.close();
    this.Fsi = null;
    this.Fsj = false;
    AppMethodBeat.o(31580);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31669);
    ae.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", new Object[] { Integer.valueOf(View.MeasureSpec.getSize(paramInt2)), Integer.valueOf(getMeasuredHeight()) });
    super.onMeasure(paramInt1, paramInt2);
    ae.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    AppMethodBeat.o(31669);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(31577);
    ae.i("MicroMsg.ChatFooter", "onPause");
    this.Fsf = false;
    if ((this.Fsk == 48) && (this.Fsg == 1) && (!this.Fsu))
    {
      this.uNO = false;
      h(0, true, -1);
    }
    this.fSZ.close();
    if (this.qdo != null) {
      this.qdo.onPause();
    }
    if ((this.FmA) && (this.Fmx != null)) {
      this.Fmx.pause();
    }
    if (this.FrL != null) {
      this.FrL.onPause();
    }
    if (this.FrJ != null) {
      this.FrJ.hide();
    }
    if ((this.BGb != null) && (this.BGb.isShowing())) {
      this.BGb.dismiss();
    }
    fhF();
    AppMethodBeat.o(31577);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31672);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ae.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(31672);
  }
  
  public void setAppPanelListener(AppPanel.a parama)
  {
    AppMethodBeat.i(31649);
    this.Frs.setAppPanelListener(parama);
    AppMethodBeat.o(31649);
  }
  
  public void setAppPanelTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(31595);
    if ((this.Fry == null) || (this.Frs == null))
    {
      AppMethodBeat.o(31595);
      return;
    }
    this.Fry.setText(paramCharSequence);
    if (!bu.ah(paramCharSequence)) {
      if (this.Frs.getVisibility() != 0) {
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
    if (this.Fry == null)
    {
      AppMethodBeat.o(31596);
      return;
    }
    if (TextUtils.isEmpty(this.Fry.getText()))
    {
      this.Fry.setVisibility(8);
      AppMethodBeat.o(31596);
      return;
    }
    if (paramBoolean)
    {
      localObject = this.Fry.getContext();
      i = this.Frx.getHeight();
      int j = getKeyBordHeightPX();
      int k = com.tencent.mm.cb.a.fromDPToPix((Context)localObject, 32);
      localObject = this.Fry.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (i - j + k);
        this.Fry.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    Object localObject = this.Fry;
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
    this.Frs.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163214);
  }
  
  public void setAppPanelVisible(int paramInt)
  {
    AppMethodBeat.i(31642);
    if (this.Frs != null) {
      this.Frs.setVisibility(paramInt);
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
    this.FrP.Fvr = paramString;
  }
  
  public void setBottomPanelVisibility(int paramInt)
  {
    AppMethodBeat.i(31644);
    if (paramInt == 0)
    {
      this.Frx.setVisibility(paramInt);
      AppMethodBeat.o(31644);
      return;
    }
    g(0, true, -1);
    AppMethodBeat.o(31644);
  }
  
  public void setCattingRootLayoutId(int paramInt)
  {
    this.FuO = null;
    this.FuN = paramInt;
  }
  
  public void setDefaultSmileyByDetail(String paramString)
  {
    AppMethodBeat.i(31600);
    if (!bu.isNullOrNil(paramString))
    {
      if (this.qdo == null) {
        fhd();
      }
      this.qdo.setDefaultEmojiByDetail(paramString);
    }
    AppMethodBeat.o(31600);
  }
  
  @TargetApi(11)
  public void setEditTextOnDragListener(View.OnDragListener paramOnDragListener)
  {
    AppMethodBeat.i(31647);
    this.vNt.setOnDragListener(paramOnDragListener);
    AppMethodBeat.o(31647);
  }
  
  public void setExitType(int paramInt)
  {
    AppMethodBeat.i(185414);
    c.a locala = com.tencent.mm.plugin.transvoice.a.c.BTw;
    com.tencent.mm.plugin.transvoice.a.c.evb().setExitType(paramInt);
    AppMethodBeat.o(185414);
  }
  
  public void setFooterEventListener(b paramb)
  {
    this.FrL = paramb;
  }
  
  public void setFooterStatus(boolean paramBoolean) {}
  
  public void setFooterType(int paramInt)
  {
    AppMethodBeat.i(31576);
    this.DUO = paramInt;
    if (this.qdo != null) {
      this.qdo.setFooterType(paramInt);
    }
    AppMethodBeat.o(31576);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(186801);
    if (this.vNt != null) {
      this.vNt.setHint(paramCharSequence);
    }
    AppMethodBeat.o(186801);
  }
  
  public void setIOnTodoViewCallback(z.c paramc)
  {
    this.Fsv = paramc;
  }
  
  public void setIgnoreScroll(Boolean paramBoolean)
  {
    AppMethodBeat.i(31661);
    this.Fsu = paramBoolean.booleanValue();
    AppMethodBeat.o(31661);
  }
  
  public void setInsertPos(int paramInt)
  {
    this.FrP.Fvs = paramInt;
  }
  
  public void setIsMultiWindow(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(31667);
    ae.i("MicroMsg.ChatFooter", "setIsMultiWindow: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.Fsm != paramBoolean) {}
    for (;;)
    {
      this.Fsm = paramBoolean;
      fhD();
      if (i != 0)
      {
        ZQ(getKeyBordHeightPX());
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
    this.uNO = paramBoolean.booleanValue();
    AppMethodBeat.o(31662);
  }
  
  public void setLastContent(String paramString)
  {
    this.FrP.Fvq = paramString;
  }
  
  public void setLastQuoteMsgId(long paramLong)
  {
    AppMethodBeat.i(31605);
    if (paramLong != 0L)
    {
      bv localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramLong);
      if (((localbv.eNc & 0x4) == 4) || (localbv.getType() == 10000))
      {
        ae.e("MicroMsg.ChatFooter", "msg(%s) is revoked!", new Object[] { localbv.getType() + "," + (localbv.eNc & 0x4) });
        com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(2131761359), "", true);
        AppMethodBeat.o(31605);
        return;
      }
      this.FrF.setTag(localbv);
      AppMethodBeat.o(31605);
      return;
    }
    this.FrF.setTag(null);
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
    this.FrR = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    AppMethodBeat.i(31623);
    bg(paramInt, true);
    AppMethodBeat.o(31623);
  }
  
  public void setOnEditFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(31648);
    this.vNt.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(31648);
  }
  
  public void setOnFooterPanelSwitchListener(f paramf)
  {
    this.FrN = paramf;
  }
  
  public void setOnFooterSwitchListener(g paramg)
  {
    AppMethodBeat.i(31650);
    this.FrM = paramg;
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
        AppMethodBeat.i(186768);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$50", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ChatFooter.bl(ChatFooter.this) != null) {
          ChatFooter.bl(ChatFooter.this).wo(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$50", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186768);
      }
    });
    AppMethodBeat.o(31650);
  }
  
  public void setRecordNormalWording(String paramString)
  {
    AppMethodBeat.i(31618);
    if ((paramString == null) || (this.FrV == null))
    {
      AppMethodBeat.o(31618);
      return;
    }
    this.FrV.setText(paramString);
    AppMethodBeat.o(31618);
  }
  
  public void setSetTolastCustomPage(boolean paramBoolean) {}
  
  public void setSmileyPanelCallback(f paramf)
  {
    AppMethodBeat.i(31592);
    this.FkI = paramf;
    if (this.qdo != null) {
      this.qdo.setCallback(paramf);
    }
    AppMethodBeat.o(31592);
  }
  
  public void setSmileyPanelCallback2(j paramj)
  {
    this.FrJ.Fwz = paramj;
  }
  
  public void setSwitchButtonMode(int paramInt)
  {
    AppMethodBeat.i(31651);
    if (paramInt == this.FuD)
    {
      AppMethodBeat.o(31651);
      return;
    }
    this.FuD = paramInt;
    ImageView localImageView1 = (ImageView)findViewById(2131305574);
    ImageView localImageView2 = (ImageView)findViewById(2131303025);
    if (this.FuD == 1)
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
    this.Fsz = paramc;
  }
  
  @TargetApi(11)
  public void setToSendTextColor(final boolean paramBoolean)
  {
    AppMethodBeat.i(31652);
    if (com.tencent.mm.compatible.util.d.lA(11))
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
      this.vNt.setTextColor(getResources().getColor(2131100636));
      AppMethodBeat.o(31652);
      return;
    }
    this.vNt.setTextColor(getResources().getColor(2131100482));
    wj(false);
    AppMethodBeat.o(31652);
  }
  
  public void setUserName(String paramString)
  {
    AppMethodBeat.i(31682);
    this.Frr = paramString;
    if (this.qdo != null) {
      this.qdo.setTalkerName(this.Frr);
    }
    if (this.Frs != null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.ChatFooter", "setusername: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (this.Frs == null) {
        break label167;
      }
      if ((!x.AZ(this.Frr)) && (!x.AQ(this.Frr))) {
        break;
      }
      this.Frs.setServiceShowFlag(0);
      AppMethodBeat.o(31682);
      return;
    }
    if (x.Ao(this.Frr))
    {
      this.Frs.setServiceShowFlag(4);
      AppMethodBeat.o(31682);
      return;
    }
    if (x.wb(this.Frr))
    {
      this.Frs.setServiceShowFlag(2);
      AppMethodBeat.o(31682);
      return;
    }
    this.Frs.setServiceShowFlag(1);
    label167:
    AppMethodBeat.o(31682);
  }
  
  public void setVoice2txtCountDown(int paramInt)
  {
    AppMethodBeat.i(31619);
    if (-1 == paramInt)
    {
      this.FsM.setVisibility(0);
      this.FsO.setVisibility(8);
      AppMethodBeat.o(31619);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 10))
    {
      if (8 == this.FsO.getVisibility())
      {
        this.FsM.setVisibility(8);
        this.FsO.setVisibility(0);
      }
      if (this.FsO != null) {
        this.FsO.setImageResource(this.Fuo[paramInt]);
      }
    }
    AppMethodBeat.o(31619);
  }
  
  public void setVoiceInputShowCallback(d paramd)
  {
    this.FsA = paramd;
  }
  
  public void setVoiceReactArea(int paramInt)
  {
    AppMethodBeat.i(185401);
    if (this.Ftl)
    {
      setNewVoice2TxtCountDown(paramInt);
      AppMethodBeat.o(185401);
      return;
    }
    if (paramInt < 10)
    {
      if (this.FrZ)
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
    this.Frt = ((TextView)this.iBX.findViewById(2131298212));
    this.vNt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(31646);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(31656);
    if ((this.FsD != null) && (this.FsD.isSupportNavigationSwipeBack()) && (this.FsD.getSwipeBackLayout() != null)) {
      this.FsD.getSwipeBackLayout().setOnceDisEnableGesture(true);
    }
    if (!fhy())
    {
      g(1, true, -1);
      AppMethodBeat.o(31656);
      return;
    }
    ae.i("changelcai", "isScrolling!! pass this event!");
    AppMethodBeat.o(31656);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(31670);
    ae.i("MicroMsg.ChatFooter", "onKeyboardHeightChanged: %s, %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(this.Fsk) });
    if (!this.Fsn)
    {
      AppMethodBeat.o(31670);
      return;
    }
    int i;
    if ((this.Ftl) && (this.Ftn != null) && (this.Ftn.isShowing()))
    {
      Object localObject;
      if (paramInt <= 0)
      {
        this.Ftr.setCursorVisible(false);
        this.uNO = false;
        this.FtB.animate().translationY(0.0F).setDuration(200L).start();
        this.Ftq.animate().translationY(0.0F).setDuration(200L).start();
        this.Ftt.animate().translationY(0.0F).setDuration(200L).start();
        this.Ftw.animate().translationY(0.0F).setDuration(200L).start();
        if (this.Ftq.getHeight() < this.Fuy)
        {
          localObject = ValueAnimator.ofInt(new int[] { this.Ftq.getHeight(), this.Fuy }).setDuration(200L);
          ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              AppMethodBeat.i(186772);
              int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
              ((ViewGroup.MarginLayoutParams)ChatFooter.az(ChatFooter.this).getLayoutParams()).height = i;
              ChatFooter.az(ChatFooter.this).requestLayout();
              AppMethodBeat.o(186772);
            }
          });
          ((ValueAnimator)localObject).start();
          AppMethodBeat.o(31670);
        }
      }
      else
      {
        this.Ftr.setCursorVisible(true);
        this.uNO = true;
        ae.d("MicroMsg.ChatFooter", "height:%s, WeUIToolHelper.getDisplayRealSize(getContext()).y - newVoice2txtOpeArea.getBottom():%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.ui.ar.ck(getContext()).y - this.FtB.getBottom()) });
        i = com.tencent.mm.ui.ar.ck(getContext()).y;
        localObject = new int[2];
        this.FtB.getLocationOnScreen((int[])localObject);
        j = localObject[1];
        int k = this.FtB.getHeight();
        int m = com.tencent.mm.ui.ar.en(getContext());
        this.FtB.animate().translationY(-(paramInt - (i - (j + k)) + m)).setDuration(200L).start();
        paramInt = i - (this.FtB.getHeight() + paramInt) - com.tencent.mm.ui.aq.fromDPToPix(getContext(), 24);
        i = this.Ftq.getHeight() + this.Ftt.getHeight() + com.tencent.mm.ui.aq.fromDPToPix(getContext(), 48);
        ae.d("MicroMsg.ChatFooter", "leftSpcaeDown:%s, editDown:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        this.Fux = (paramInt - com.tencent.mm.ui.aq.fromDPToPix(getContext(), 52));
        if (this.Fux < this.Fuq)
        {
          ae.i("MicroMsg.ChatFooter", "invalid maxHeightWhenKeyboard, value:%s", new Object[] { Integer.valueOf(this.Fux) });
          this.Fux = this.Fuq;
        }
        this.Fuy = this.Ftq.getHeight();
        localObject = new int[2];
        this.Ftt.getLocationOnScreen((int[])localObject);
        j = localObject[1] + this.Ftt.getHeight();
        if (j > paramInt)
        {
          j -= paramInt;
          if (i > paramInt)
          {
            k = this.Ftq.getLayoutParams().height;
            localObject = ValueAnimator.ofInt(new int[] { k, k - (i - paramInt) }).setDuration(200L);
            ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
              {
                AppMethodBeat.i(186773);
                int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
                ChatFooter.az(ChatFooter.this).getLayoutParams().height = i;
                ChatFooter.az(ChatFooter.this).requestLayout();
                AppMethodBeat.o(186773);
              }
            });
            ((ValueAnimator)localObject).start();
          }
          this.Ftq.animate().translationY(-j).setDuration(200L).start();
          this.Ftt.animate().translationY(-j).setDuration(200L).start();
          this.Ftw.animate().translationY(-j).setDuration(200L).start();
        }
      }
      AppMethodBeat.o(31670);
      return;
    }
    if ((!this.Fsm) && (this.Fse))
    {
      if (this.Fsp == paramBoolean) {
        break label824;
      }
      i = 1;
      this.Fsp = paramBoolean;
      if (paramInt <= 0) {
        break label884;
      }
      if (this.nMm == paramInt) {
        break label956;
      }
      this.nMm = paramInt;
      com.tencent.mm.compatible.util.i.A(getContext(), paramInt);
      ZQ(paramInt);
    }
    label824:
    label956:
    for (paramInt = 1;; paramInt = 0)
    {
      if (!this.uNO)
      {
        h(1, true, -1);
        this.Fsh = -1;
      }
      while ((paramInt == 0) && (i == 0))
      {
        this.uNO = true;
        if (this.FrL != null) {
          this.FrL.ot(this.uNO);
        }
        AppMethodBeat.o(31670);
        return;
        i = 0;
        break;
      }
      this.Fsl = this.nMm;
      i = this.Fsl;
      if (this.Fsv == null) {}
      for (paramInt = j;; paramInt = this.Fsv.dew())
      {
        b(i, true, 1, paramInt);
        break;
      }
      label884:
      if (this.uNO)
      {
        if (this.Fsh == -1) {
          break label946;
        }
        h(this.Fsh, true, -1);
        this.Fsh = -1;
      }
      for (;;)
      {
        if (this.Fsg == 1)
        {
          ae.i("MicroMsg.ChatFooter", "keyboard not open");
          h(0, true, -1);
        }
        this.uNO = false;
        break;
        h(0, true, -1);
      }
    }
  }
  
  public final void w(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(31607);
    if (deu())
    {
      ae.i("MicroMsg.ChatFooter", "setLastText() isBackFromGroupSolitatire");
      AppMethodBeat.o(31607);
      return;
    }
    if ((paramBoolean) && ((paramString == null) || (paramString.length() == 0) || (this.vNt == null)))
    {
      this.vNt.setText("");
      fgZ();
      AppMethodBeat.o(31607);
      return;
    }
    this.FrQ = true;
    this.vNt.setText(k.b(getContext(), paramString, this.vNt.getTextSize()));
    this.FrQ = false;
    if ((paramInt < 0) || (paramInt > this.vNt.getText().length()))
    {
      this.vNt.setSelection(this.vNt.getText().length());
      AppMethodBeat.o(31607);
      return;
    }
    this.vNt.setSelection(paramInt);
    AppMethodBeat.o(31607);
  }
  
  public final void wa(boolean paramBoolean)
  {
    AppMethodBeat.i(31633);
    this.Frs.wa(paramBoolean);
    AppMethodBeat.o(31633);
  }
  
  public final void wb(boolean paramBoolean)
  {
    AppMethodBeat.i(31634);
    this.Frs.wb(paramBoolean);
    AppMethodBeat.o(31634);
  }
  
  public final void wj(boolean paramBoolean)
  {
    AppMethodBeat.i(31588);
    ae.i("MicroMsg.ChatFooter", "pureForcusEdtChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.vNt });
    if (this.vNt == null)
    {
      AppMethodBeat.o(31588);
      return;
    }
    if (paramBoolean)
    {
      this.vNt.requestFocus();
      AppMethodBeat.o(31588);
      return;
    }
    this.vNt.clearFocus();
    AppMethodBeat.o(31588);
  }
  
  public final void wl(boolean paramBoolean)
  {
    AppMethodBeat.i(31654);
    ae.i("MicroMsg.ChatFooter", "withoutLastText: ");
    hideVKB();
    wj(paramBoolean);
    AppMethodBeat.o(31654);
  }
  
  public final void wn(boolean paramBoolean)
  {
    AppMethodBeat.i(163220);
    if (this.Frz == null)
    {
      ae.e("MicroMsg.ChatFooter", "mAttachButton is null");
      AppMethodBeat.o(163220);
      return;
    }
    if (this.FrA != null) {
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
        } while ((locala.Fra != 1) || (aOw(locala.FqZ)));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.FrA.setVisibility(0);
        AppMethodBeat.o(163220);
        return;
      }
      this.FrA.setVisibility(8);
      AppMethodBeat.o(163220);
      return;
    }
  }
  
  public static final class a
  {
    public String Fvq;
    String Fvr;
    int Fvs;
    HashMap<String, LinkedList<HashMap<String, String>>> Fvt;
    
    private a()
    {
      AppMethodBeat.i(31558);
      this.Fvt = new HashMap();
      AppMethodBeat.o(31558);
    }
  }
  
  public static abstract interface b
  {
    public abstract com.tencent.mm.ui.chatting.i.b fie();
    
    public abstract com.tencent.mm.ui.chatting.e.a fif();
    
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
      Fvu = new e("MODE_VOICE", 0);
      Fvv = new e("MODE_CANCEL", 1);
      Fvw = new e("MODE_TRANS", 2);
      Fvx = new e[] { Fvu, Fvv, Fvw };
      AppMethodBeat.o(185398);
    }
    
    private e() {}
  }
  
  public static abstract interface f
  {
    public abstract void js(int paramInt1, int paramInt2);
  }
  
  public static abstract interface g
  {
    public abstract boolean wo(boolean paramBoolean);
  }
  
  public static enum h
  {
    static
    {
      AppMethodBeat.i(185821);
      Fvy = new h("SendVoice", 0);
      Fvz = new h("StopRecord", 1);
      FvA = new h("Reset", 2);
      FvB = new h("Cancel", 3);
      FvC = new h("Pause", 4);
      FvD = new h("Error", 5);
      FvE = new h[] { Fvy, Fvz, FvA, FvB, FvC, FvD };
      AppMethodBeat.o(185821);
    }
    
    private h() {}
  }
  
  public final class i
    implements TextWatcher
  {
    TextWatcher FvF;
    private boolean FvG;
    private boolean FvH;
    
    public i(TextWatcher paramTextWatcher)
    {
      AppMethodBeat.i(31559);
      this.FvG = false;
      this.FvH = com.tencent.mm.compatible.util.d.lB(11);
      this.FvF = paramTextWatcher;
      AppMethodBeat.o(31559);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      boolean bool = true;
      AppMethodBeat.i(31560);
      if ((ChatFooter.j(ChatFooter.this)) && (this.FvG) && (paramEditable.length() > 0))
      {
        this.FvG = false;
        ChatFooter.d(ChatFooter.this).setText(paramEditable.subSequence(0, paramEditable.length() - 1));
        if (ChatFooter.d(ChatFooter.this).length() > 0)
        {
          ChatFooter.k(ChatFooter.this).performClick();
          ae.i("MicroMsg.ChatFooter", "enter button, do send");
        }
        ae.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        AppMethodBeat.o(31560);
        return;
      }
      this.FvF.afterTextChanged(paramEditable);
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
        ae.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
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
      this.FvF.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      ae.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
      AppMethodBeat.o(31561);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(31562);
      if ((ChatFooter.j(ChatFooter.this)) && (paramInt2 == 0) && (paramInt1 == paramCharSequence.length() - 1) && (paramInt3 == 1) && (paramCharSequence.charAt(paramCharSequence.length() - 1) == '\n'))
      {
        ae.i("MicroMsg.ChatFooter", "text changed, enter button");
        this.FvG = true;
        AppMethodBeat.o(31562);
        return;
      }
      this.FvF.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      ChatFooter.this.Fsy.dRg += 1L;
      ChatFooter.this.Fsy.RF();
      if (ChatFooter.this.Fsy.dRd == 0L) {
        ChatFooter.this.Fsy.RE();
      }
      AppMethodBeat.o(31562);
    }
  }
  
  static enum j
  {
    static
    {
      AppMethodBeat.i(31565);
      FvI = new j("MODE_INVALID", 0);
      FvJ = new j("MODE_BLUR", 1);
      FvK = new j("MODE_NORMAL", 2);
      FvL = new j[] { FvI, FvJ, FvK };
      AppMethodBeat.o(31565);
    }
    
    private j() {}
  }
  
  static enum k
  {
    static
    {
      AppMethodBeat.i(31568);
      FvM = new k("MODE_INVALID", 0);
      FvN = new k("MODE_TRANS", 1);
      FvO = new k("MODE_CANCEL", 2);
      FvP = new k[] { FvM, FvN, FvO };
      AppMethodBeat.o(31568);
    }
    
    private k() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter
 * JD-Core Version:    0.7.0.1
 */