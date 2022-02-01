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
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
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
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.api.ad;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.f.a.sj;
import com.tencent.mm.f.b.a.al;
import com.tencent.mm.f.b.a.og;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.ui.d.b;
import com.tencent.mm.plugin.groupsolitaire.ui.d.c;
import com.tencent.mm.plugin.groupsolitaire.ui.d.d;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.4;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.a;
import com.tencent.mm.plugin.transvoice.ui.SoundWaveView;
import com.tencent.mm.plugin.transvoice.ui.SoundWaveView.d;
import com.tencent.mm.plugin.transvoice.ui.b.d;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.model.app.af;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.eql;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ay;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.chatting.d.ac.a;
import com.tencent.mm.ui.chatting.d.ac.c;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.MMEditText.d;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.MaxHeightScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;

public class ChatFooter
  extends FrameLayout
  implements com.tencent.mm.plugin.websearch.a.a.a, h.a, com.tencent.mm.ui.tools.h
{
  private static com.tencent.mm.plugin.websearch.a.a.c RjA;
  private static int Rko;
  private static final int[] Rmi;
  private static final int[] Rmj;
  public static final String Rmt;
  private static int count;
  private final long ANIMATION_DURATION;
  public boolean BSf;
  public com.tencent.mm.ui.widget.cedit.api.c KQB;
  public com.tencent.mm.ui.base.r MkT;
  private TextView MkU;
  private ImageView MkV;
  public View MkW;
  private int NgX;
  com.tencent.mm.plugin.transvoice.a.b NiX;
  private String Njc;
  private int Njd;
  private MTimerHandler Nje;
  private boolean Njf;
  private MMHandler Njh;
  private com.tencent.mm.modelvoiceaddr.b.b Njq;
  private List<String> Njr;
  private int Nmf;
  private int PAa;
  f Rcf;
  public n RdV;
  public boolean RdY;
  public String RiT;
  public AppPanel RiU;
  public TextView RiV;
  private Button RiW;
  public ImageButton RiX;
  private View RiY;
  public ChatFooterBottom RiZ;
  public ViewGroup RjB;
  private TextView RjC;
  private View RjD;
  private InputMethodManager RjE;
  private int RjF;
  private boolean RjG;
  private boolean RjH;
  private boolean RjI;
  public boolean RjJ;
  public boolean RjK;
  private boolean RjL;
  private int RjM;
  private ChattingScrollLayout RjN;
  private boolean RjO;
  private int RjP;
  private int RjQ;
  private boolean RjR;
  public boolean RjS;
  private boolean RjT;
  private int RjU;
  private boolean RjV;
  private int RjW;
  private int RjX;
  private int RjY;
  private int RjZ;
  private TextView Rja;
  public ImageButton Rjb;
  public ImageView Rjc;
  public ImageButton Rjd;
  public MaxHeightScrollView Rje;
  private com.tencent.mm.ui.widget.a.d Rjf;
  public LinearLayout Rjg;
  public RelativeLayout Rjh;
  private RelativeLayout Rji;
  private TextView Rjj;
  private ImageView Rjk;
  private TextView Rjl;
  private WeImageView Rjm;
  private i Rjn;
  public m Rjo;
  private com.tencent.mm.plugin.groupsolitaire.ui.d Rjp;
  private b Rjq;
  private g Rjr;
  private f Rjs;
  public final a Rjt;
  public boolean Rju;
  private boolean Rjv;
  public boolean Rjw;
  private boolean Rjx;
  private boolean Rjy;
  private ImageView Rjz;
  private View RkA;
  private WeImageView RkB;
  private TextView RkC;
  private View RkD;
  private WeImageView RkE;
  private TextView RkF;
  private View RkG;
  private BlurView RkH;
  private com.tencent.mm.plugin.transvoice.ui.b RkI;
  private com.tencent.mm.plugin.transvoice.a.a RkJ;
  private com.tencent.mm.modelvoiceaddr.h RkK;
  public com.tencent.mm.ui.base.r RkL;
  private com.tencent.mm.plugin.transvoice.a.c RkM;
  private l RkN;
  private j RkO;
  private k RkP;
  private boolean RkQ;
  private boolean RkR;
  public boolean RkS;
  private float RkT;
  private com.tencent.mm.ui.base.r RkU;
  private View RkV;
  private View RkW;
  private ViewGroup RkX;
  private EditText RkY;
  private SoundWaveView RkZ;
  private boolean Rka;
  private String Rkb;
  private ac.c Rkc;
  private ac.a Rkd;
  private d.c Rke;
  com.tencent.mm.f.b.a.m Rkf;
  public c Rkg;
  public d Rkh;
  private m.a Rki;
  private boolean Rkj;
  public MMFragment Rkk;
  public b Rkl;
  private Animation Rkm;
  private Animation Rkn;
  public ViewGroup Rkp;
  private View Rkq;
  private BlurView Rkr;
  private View Rks;
  private View Rkt;
  private ImageView Rku;
  private ImageView Rkv;
  private View Rkw;
  private TextView Rkx;
  private ImageView Rky;
  private View Rkz;
  private View RlA;
  private View RlB;
  private WeImageView RlC;
  private View RlD;
  private int RlE;
  private int RlF;
  private boolean RlG;
  private ChatFooterPanel.a RlH;
  private AppPanel.b RlI;
  private b RlJ;
  public i RlK;
  private int RlL;
  private boolean RlM;
  private int RlN;
  private TextWatcher RlO;
  ValueAnimator RlP;
  ValueAnimator RlQ;
  ValueAnimator RlR;
  ValueAnimator RlS;
  ValueAnimator RlT;
  ValueAnimator.AnimatorUpdateListener RlU;
  private int[] RlV;
  private final int RlW;
  private final int RlX;
  private final int RlY;
  private final int RlZ;
  private ImageView Rla;
  private ViewGroup Rlb;
  private TextView Rlc;
  private WeImageView Rld;
  public LanguageChoiceLayout Rle;
  private TextView Rlf;
  private ViewGroup Rlg;
  private TextView Rlh;
  private ViewGroup Rli;
  private ViewGroup Rlj;
  private View Rlk;
  private View Rll;
  private WeImageView Rlm;
  private WeImageView Rln;
  private View Rlo;
  private View Rlp;
  private ViewGroup Rlq;
  private View Rlr;
  private View Rls;
  private WeImageView Rlt;
  private WeImageView Rlu;
  private View Rlv;
  private View Rlw;
  private WeImageView Rlx;
  private ViewGroup Rly;
  private View Rlz;
  private int RmA;
  private int RmB;
  private Runnable RmC;
  private Runnable RmD;
  private int RmE;
  private int RmF;
  e RmG;
  e RmH;
  private Map<Integer, String> RmI;
  private boolean RmJ;
  private final int Rma;
  private final int Rmb;
  private final float Rmc;
  private int Rmd;
  private int Rme;
  private int Rmf;
  private int Rmg;
  private int Rmh;
  private int Rmk;
  private boolean Rml;
  private final int Rmm;
  private final int Rmn;
  private volatile boolean Rmo;
  private MMHandler Rmp;
  private boolean Rmq;
  private int Rmr;
  private boolean Rms;
  private int Rmu;
  private View Rmv;
  private int Rmw;
  private int Rmx;
  private int Rmy;
  private int Rmz;
  private Activity activity;
  private String fLi;
  private View fyN;
  public int jJL;
  private boolean jJo;
  public Button jLo;
  public ChatFooterPanel jPN;
  private com.tencent.mm.ui.tools.i jij;
  private ViewGroup mCC;
  public final MMHandler mHandler;
  private String mSessionId;
  private int maxHeight;
  private int pIk;
  private String toUser;
  private final MMHandler urD;
  private boolean urq;
  public View wLn;
  private ImageView wLo;
  public View wLp;
  public View wLq;
  private boolean zQA;
  
  static
  {
    AppMethodBeat.i(31717);
    count = 0;
    Rmi = new int[] { 0, 15, 30, 45, 60, 75, 90, 95, 100 };
    Rmj = new int[] { R.k.amp1, R.k.amp2, R.k.amp3, R.k.amp4, R.k.amp5, R.k.amp6, R.k.amp7, R.k.amp8 };
    Rmt = MMApplicationContext.getPackageName() + "chat_footer_sp";
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
    this.fyN = null;
    this.KQB = null;
    this.jLo = null;
    this.RiV = null;
    this.Rjr = null;
    this.Rjs = null;
    this.Rjt = new a((byte)0);
    this.Rju = false;
    this.Rjv = false;
    this.Rjw = false;
    this.Rjx = false;
    this.Rjy = false;
    this.urq = false;
    this.RjH = false;
    this.RjI = false;
    this.RjJ = false;
    this.RdY = false;
    this.RjK = false;
    this.RjL = true;
    this.zQA = false;
    this.jJL = 0;
    this.RjM = -1;
    this.RjQ = 0;
    this.BSf = false;
    this.RjR = false;
    this.RjS = true;
    this.RjT = false;
    this.RjU = 0;
    this.RjV = false;
    this.Rka = false;
    this.Rkb = com.tencent.mm.plugin.fts.a.d.Sx(73);
    this.mSessionId = com.tencent.mm.plugin.fts.a.d.Sx(73);
    this.Rkc = null;
    this.Rkd = new ac.a()
    {
      public final void hide()
      {
        AppMethodBeat.i(184906);
        if (ChatFooter.a(ChatFooter.this) != null) {
          ChatFooter.a(ChatFooter.this).setBackgroundResource(R.g.list_item_top_normal);
        }
        AppMethodBeat.o(184906);
      }
      
      public final void show()
      {
        AppMethodBeat.i(184905);
        if (ChatFooter.a(ChatFooter.this) != null) {
          ChatFooter.a(ChatFooter.this).setBackgroundResource(R.g.list_item_top_normal_no_line);
        }
        AppMethodBeat.o(184905);
      }
    };
    this.Rke = new d.c()
    {
      public final int eBE()
      {
        AppMethodBeat.i(185759);
        if (ChatFooter.b(ChatFooter.this) != null)
        {
          int i = ChatFooter.b(ChatFooter.this).eBE();
          AppMethodBeat.o(185759);
          return i;
        }
        AppMethodBeat.o(185759);
        return 0;
      }
      
      public final boolean eBF()
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
    this.Rkf = new com.tencent.mm.f.b.a.m();
    this.Rki = new m.a()
    {
      public final void clear()
      {
        AppMethodBeat.i(185778);
        ChatFooter.this.eBG();
        AppMethodBeat.o(185778);
      }
    };
    this.mHandler = new MMHandler()
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
    this.Rkj = false;
    this.jJo = false;
    paramAttributeSet = com.tencent.mm.plugin.transvoice.a.c.Nhv;
    this.RkM = com.tencent.mm.plugin.transvoice.a.c.gsv();
    this.RkN = l.Rnx;
    this.RkO = j.Rnp;
    this.RkP = k.Rnt;
    this.RkQ = false;
    this.RkR = false;
    this.RkS = false;
    this.RkT = 0.5F;
    this.RlG = true;
    this.RlH = new ChatFooterPanel.a()
    {
      public final void aDN()
      {
        AppMethodBeat.i(275734);
        ChatFooter.at(ChatFooter.this);
        ChatFooter.au(ChatFooter.this).setVisibility(0);
        ChatFooter.av(ChatFooter.this).setVisibility(0);
        ChatFooter.B(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.c(ChatFooter.this, R.g.dnf);
        if (ChatFooter.k(ChatFooter.this) != null) {
          ChatFooter.k(ChatFooter.this).performClick();
        }
        AppMethodBeat.o(275734);
      }
      
      public final void aDO()
      {
        AppMethodBeat.i(275741);
        ChatFooter.at(ChatFooter.this);
        ChatFooter.aw(ChatFooter.this);
        ChatFooter.B(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.c(ChatFooter.this, R.g.dnf);
        InputConnection localInputConnection = ChatFooter.d(ChatFooter.this).getInputConnection();
        if (localInputConnection != null)
        {
          localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
          localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
        }
        ChatFooter.this.Rkf.geM -= 1L;
        AppMethodBeat.o(275741);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(275745);
        ChatFooter.at(ChatFooter.this);
        ChatFooter.aw(ChatFooter.this);
        ChatFooter.B(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.c(ChatFooter.this, R.g.dnf);
        try
        {
          ChatFooter.d(ChatFooter.this).bBa(paramAnonymousString);
          ChatFooter.this.Rkf.geM += 1L;
          AppMethodBeat.o(275745);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ChatFooter", paramAnonymousString, "", new Object[0]);
          }
        }
      }
      
      public final void eE(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(275738);
        Log.i("MicroMsg.ChatFooter", "onToSendTextEnable: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ChatFooter.c(ChatFooter.this) == 2)
        {
          ChatFooter.at(ChatFooter.this);
          ChatFooter.aw(ChatFooter.this);
          ChatFooter.B(ChatFooter.this).setVisibility(8);
          ChatFooter.c(ChatFooter.this, R.g.dnf);
          if (ChatFooter.d(ChatFooter.this) != null) {
            ChatFooter.this.setToSendTextColor(paramAnonymousBoolean);
          }
        }
        AppMethodBeat.o(275738);
      }
    };
    this.RlI = new AppPanel.b()
    {
      public final void hla()
      {
        AppMethodBeat.i(284929);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ChatFooter.e(ChatFooter.this), "android.permission.RECORD_AUDIO", 80, "", "");
        Log.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), ChatFooter.e(ChatFooter.this) });
        if (!bool)
        {
          AppMethodBeat.o(284929);
          return;
        }
        int i = bh.aGY().bih();
        if ((i == 4) || (i == 6))
        {
          ChatFooter.ax(ChatFooter.this);
          AppMethodBeat.o(284929);
          return;
        }
        if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
          ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.h.p(ChatFooter.this.getContext(), R.l.voip_net_unavailable, R.l.app_tip));
        }
        AppMethodBeat.o(284929);
      }
    };
    this.RlJ = new b()
    {
      public final String getTalkerUserName()
      {
        AppMethodBeat.i(287745);
        if (ChatFooter.f(ChatFooter.this) == null)
        {
          str = ChatFooter.r(ChatFooter.this);
          AppMethodBeat.o(287745);
          return str;
        }
        String str = ChatFooter.f(ChatFooter.this).getTalkerUserName();
        AppMethodBeat.o(287745);
        return str;
      }
      
      public final com.tencent.mm.ui.chatting.i.b hmo()
      {
        return null;
      }
      
      public final com.tencent.mm.ui.chatting.e.a hmp()
      {
        return null;
      }
    };
    this.urD = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(265147);
        super.handleMessage(paramAnonymousMessage);
        Log.d("MicroMsg.ChatFooter", "pennqin, dismiss window by too short.");
        ChatFooter.B(ChatFooter.this).setBackgroundResource(R.g.input_bg);
        ChatFooter.B(ChatFooter.this).setEnabled(true);
        if (ChatFooter.this.RkS)
        {
          ChatFooter.L(ChatFooter.this);
          w.w(ChatFooter.this.getContext(), ChatFooter.this.getContext().getResources().getString(R.l.chatfooter_too_short_new), R.k.voice_to_short);
          AppMethodBeat.o(265147);
          return;
        }
        if (ChatFooter.M(ChatFooter.this) != null) {
          ChatFooter.M(ChatFooter.this).dismiss();
        }
        AppMethodBeat.o(265147);
      }
    };
    this.RlL = 0;
    this.RlM = false;
    this.RlN = 1;
    this.RlO = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(269815);
        int i;
        int j;
        int m;
        int k;
        if (paramAnonymousEditable != null)
        {
          i = ChatFooter.aA(ChatFooter.this).getWidth();
          j = ChatFooter.aB(ChatFooter.this).getLineCount();
          m = j - ChatFooter.aC(ChatFooter.this);
          if ((m != 0) && (ChatFooter.this.RmG == ChatFooter.e.Rne) && (i == ChatFooter.aD(ChatFooter.this)))
          {
            i = aw.fromDPToPix(ChatFooter.this.getContext(), 5);
            k = ChatFooter.aB(ChatFooter.this).getLineHeight() * m;
            if (m <= 0) {
              break label251;
            }
            m = ChatFooter.aA(ChatFooter.this).getHeight();
            if (!ChatFooter.this.BSf) {
              break label257;
            }
            ChatFooter.d(ChatFooter.this, Math.min(Math.max(ChatFooter.aE(ChatFooter.this), i + (m + k)), ChatFooter.aF(ChatFooter.this)));
          }
        }
        for (;;)
        {
          Log.d("MicroMsg.ChatFooter", "afterTextChanged transHeight:%s, nowLineCount:%s, lastLineCount:%s", new Object[] { Integer.valueOf(ChatFooter.aH(ChatFooter.this)), Integer.valueOf(j), Integer.valueOf(ChatFooter.aC(ChatFooter.this)) });
          ChatFooter.aI(ChatFooter.this);
          ChatFooter.e(ChatFooter.this, j);
          if (1 == ChatFooter.D(ChatFooter.this).Nht) {
            ChatFooter.D(ChatFooter.this).Nhs = 1;
          }
          AppMethodBeat.o(269815);
          return;
          label251:
          i = -i;
          break;
          label257:
          ChatFooter.d(ChatFooter.this, Math.min(Math.max(ChatFooter.aE(ChatFooter.this), i + (m + k)), ChatFooter.aG(ChatFooter.this)));
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.RlP = ValueAnimator.ofInt(new int[] { 250, 960 }).setDuration(200L);
    this.RlQ = ValueAnimator.ofInt(new int[] { 40, 800 }).setDuration(200L);
    this.RlR = ValueAnimator.ofInt(new int[] { 72, 0 }).setDuration(200L);
    this.RlS = ValueAnimator.ofInt(new int[] { 22, 0 }).setDuration(200L);
    this.RlT = ValueAnimator.ofInt(new int[] { 8, 0 }).setDuration(200L);
    this.RlU = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(220726);
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)ChatFooter.bg(ChatFooter.this).getLayoutParams();
        FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)ChatFooter.bh(ChatFooter.this).getLayoutParams();
        if (ChatFooter.this.RlP == paramAnonymousValueAnimator)
        {
          localLayoutParams1.width = aw.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          localLayoutParams2.width = aw.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        }
        for (;;)
        {
          ChatFooter.bg(ChatFooter.this).setLayoutParams(localLayoutParams1);
          ChatFooter.bh(ChatFooter.this).setLayoutParams(localLayoutParams2);
          AppMethodBeat.o(220726);
          return;
          if (ChatFooter.this.RlQ == paramAnonymousValueAnimator)
          {
            localLayoutParams1.height = aw.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.height = aw.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.RlR == paramAnonymousValueAnimator)
          {
            localLayoutParams1.topMargin = aw.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.topMargin = aw.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.RlS == paramAnonymousValueAnimator)
          {
            localLayoutParams1.rightMargin = aw.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.rightMargin = aw.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.RlT == paramAnonymousValueAnimator)
          {
            localLayoutParams1.bottomMargin = aw.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.bottomMargin = aw.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        }
      }
    };
    this.RlV = new int[] { R.k.count_down_0, R.k.count_down_1, R.k.count_down_2, R.k.count_down_3, R.k.count_down_4, R.k.count_down_5, R.k.count_down_6, R.k.count_down_7, R.k.count_down_8, R.k.count_down_9 };
    this.ANIMATION_DURATION = 200L;
    this.RlW = 60;
    this.RlX = aw.fromDPToPix(getContext(), 114);
    this.RlY = (com.tencent.mm.ui.ax.au(getContext()).x - aw.fromDPToPix(getContext(), 32));
    this.RlZ = aw.fromDPToPix(getContext(), 92);
    this.Rma = Math.min(aw.fromDPToPix(getContext(), 320), com.tencent.mm.ui.ax.au(getContext()).x - aw.fromDPToPix(getContext(), 32));
    this.Rmb = aw.fromDPToPix(getContext(), 176);
    this.Rmc = (aw.fromDPToPix(getContext(), 160) / 50.0F);
    this.Rmd = aw.fromDPToPix(getContext(), 114);
    this.maxHeight = 0;
    this.Rme = 0;
    this.Rmf = 0;
    this.Nmf = 0;
    this.Rmg = aw.fromDPToPix(getContext(), 176);
    this.Rmh = 60;
    this.Rmk = 0;
    this.Rml = false;
    this.Rmm = 4097;
    this.Rmn = 4098;
    this.Rmp = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(280238);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(280238);
          return;
          ChatFooter.j(ChatFooter.this, true);
          paramAnonymousMessage = ChatFooter.bt(ChatFooter.this).getLayoutParams();
          int i = ChatFooter.bt(ChatFooter.this).getBottom() - ChatFooter.bt(ChatFooter.this).getTop();
          if (ChatFooter.this.hlI())
          {
            if (ChatFooter.z(ChatFooter.this) != null) {
              ChatFooter.z(ChatFooter.this).setVisibility(8);
            }
            ChatFooter.this.setAppPanelVisible(8);
            ChatFooter.bt(ChatFooter.this).setVisibility(4);
          }
          if (i <= 3)
          {
            ChatFooter.j(ChatFooter.this, false);
            ChatFooter.bt(ChatFooter.this).setVisibility(4);
            ChatFooter.j(ChatFooter.this, ChatFooter.this.getKeyBordHeightPX());
            AppMethodBeat.o(280238);
            return;
          }
          paramAnonymousMessage.height = Math.max(i - 60, 1);
          Log.e("MicroMsg.ChatFooter", "mBottomPanelAnim:bottomPanel height:" + paramAnonymousMessage.height);
          ChatFooter.bt(ChatFooter.this).setLayoutParams(paramAnonymousMessage);
          ChatFooter.bu(ChatFooter.this);
        }
      }
    };
    this.Rmq = false;
    this.Rmr = 0;
    this.Rms = false;
    this.Rmu = -1;
    this.Rmv = null;
    this.Rmw = aw.aZ(getContext(), R.f.ChattingFootSendMinWidth);
    this.Rmx = aw.aZ(getContext(), R.f.Edge_4A);
    this.Rmy = aw.fromDPToPix(getContext(), 25);
    this.Rmz = aw.fromDPToPix(getContext(), 55);
    this.RmA = 0;
    this.RmB = aw.fromDPToPix(getContext(), 50);
    this.RmC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(278264);
        ChatFooter.this.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218482);
            if (ChatFooter.k.Rnv == ChatFooter.am(ChatFooter.this))
            {
              ChatFooter.af(ChatFooter.this).setText(ChatFooter.this.getResources().getText(R.l.eUH));
              ChatFooter.ap(ChatFooter.this);
            }
            for (;;)
            {
              ChatFooter.by(ChatFooter.this);
              AppMethodBeat.o(218482);
              return;
              ChatFooter.af(ChatFooter.this).setText(ChatFooter.this.getResources().getText(R.l.eUJ));
              ChatFooter.an(ChatFooter.this);
            }
          }
        }, 100L);
        AppMethodBeat.o(278264);
      }
    };
    this.RmD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(286438);
        ChatFooter.N(ChatFooter.this).dismiss();
        AppMethodBeat.o(286438);
      }
    };
    this.RmE = aw.fromDPToPix(getContext(), 16);
    this.RmF = aw.fromDPToPix(getContext(), 25);
    this.RmG = e.Rnc;
    this.RmH = this.RmG;
    this.RmI = new HashMap();
    this.RmJ = false;
    this.Njq = new com.tencent.mm.modelvoiceaddr.b.b();
    this.Njr = new ArrayList();
    this.Njc = "";
    this.Njd = 0;
    this.Njf = false;
    this.NgX = com.tencent.mm.modelvoiceaddr.g.mlT;
    long l = System.currentTimeMillis();
    this.RjE = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.fyN = inflate(paramContext, R.i.eco, this);
    this.KQB = ((com.tencent.mm.ui.widget.cedit.api.c)findViewById(R.h.dxd));
    this.KQB.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.ag(PluginWebSearch.class)).isUseSysEditText());
    this.jij = new com.tencent.mm.ui.tools.i((Activity)paramContext);
    this.jij.XSx = this;
    if (com.tencent.mm.ui.ar.hIF()) {
      this.KQB.setImeOptions(268435456);
    }
    paramAttributeSet = com.tencent.mm.ui.widget.cedit.api.d.a(this.KQB);
    paramInt = 8192;
    if (com.tencent.mm.kernel.h.aHB()) {
      paramInt = Util.getInt(com.tencent.mm.n.h.axc().getValue("InputLimitSessionTextMsg"), 8192);
    }
    paramAttributeSet.axx(paramInt * 2).a(null);
    this.KQB.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
    paramAttributeSet = new a.e()
    {
      public final void B(List<a.c> paramAnonymousList, int paramAnonymousInt)
      {
        AppMethodBeat.i(273365);
        long l = cm.bfF();
        if ((paramAnonymousInt != 8) && (paramAnonymousInt != 1))
        {
          if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineC2CTag())
          {
            localChatFooter = ChatFooter.this;
            if ((localChatFooter.Rkl == null) || (localChatFooter.Rkl.hmp() == null) || ((!((com.tencent.mm.ui.chatting.d.b.h)localChatFooter.Rkl.hmp().bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK()) && (!((com.tencent.mm.ui.chatting.d.b.i)localChatFooter.Rkl.hmp().bC(com.tencent.mm.ui.chatting.d.b.i.class)).hOP()))) {
              break label379;
            }
            paramAnonymousInt = 0;
            if (paramAnonymousInt != 0)
            {
              paramAnonymousList.add(new a.c(paramContext.getString(R.l.tag_search_word), 2));
              ChatFooter.d(ChatFooter.this).hZx();
              if (!ab.Lj(ChatFooter.r(ChatFooter.this))) {
                break label384;
              }
              paramAnonymousInt = 2;
              label175:
              com.tencent.mm.plugin.websearch.a.b.a(paramAnonymousInt, ChatFooter.r(ChatFooter.this), ChatFooter.s(ChatFooter.this), 1, "", ChatFooter.t(ChatFooter.this), 1, l);
            }
          }
          ChatFooter localChatFooter = ChatFooter.this;
          if ((localChatFooter.Rkl == null) || (localChatFooter.Rkl.hmp() == null) || ((!((com.tencent.mm.ui.chatting.d.b.h)localChatFooter.Rkl.hmp().bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK()) && (!((com.tencent.mm.ui.chatting.d.b.i)localChatFooter.Rkl.hmp().bC(com.tencent.mm.ui.chatting.d.b.i.class)).hOP()))) {
            break label389;
          }
          paramAnonymousInt = 0;
          label286:
          if (paramAnonymousInt != 0)
          {
            paramAnonymousList.add(new a.c(paramContext.getString(R.l.find_friends_search), 3));
            ChatFooter.d(ChatFooter.this).hZx();
            if (!ab.Lj(ChatFooter.r(ChatFooter.this))) {
              break label394;
            }
          }
        }
        label384:
        label389:
        label394:
        for (paramAnonymousInt = 2;; paramAnonymousInt = 1)
        {
          com.tencent.mm.plugin.websearch.a.b.a(paramAnonymousInt, ChatFooter.r(ChatFooter.this), ChatFooter.s(ChatFooter.this), 1, "", ChatFooter.t(ChatFooter.this), 2, l);
          AppMethodBeat.o(273365);
          return;
          label379:
          paramAnonymousInt = 1;
          break;
          paramAnonymousInt = 1;
          break label175;
          paramAnonymousInt = 1;
          break label286;
        }
      }
      
      public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
      {
        AppMethodBeat.i(273366);
        long l2 = cm.bfF();
        if (paramAnonymousc.id == 2)
        {
          ChatFooter.d(ChatFooter.this).getText().insert(ChatFooter.d(ChatFooter.this).getSelectionStart(), paramContext.getString(R.l.tag_search_word));
          ChatFooter.d(ChatFooter.this).hZx();
          if (ab.Lj(ChatFooter.r(ChatFooter.this))) {}
          for (i = 2;; i = 1)
          {
            com.tencent.mm.plugin.websearch.a.b.a(i, ChatFooter.r(ChatFooter.this), ChatFooter.s(ChatFooter.this), 2, "", ChatFooter.t(ChatFooter.this), 1, l2);
            AppMethodBeat.o(273366);
            return;
          }
        }
        long l1;
        if (paramAnonymousc.id == 3)
        {
          ChatFooter.d(ChatFooter.this).clearFocus();
          ChatFooter.u(ChatFooter.this);
          paramAnonymousView = ChatFooter.d(ChatFooter.this).getText().toString();
          paramAnonymousc = com.tencent.mm.plugin.websearch.a.c.PAp;
          Object localObject1 = ChatFooter.this.getContext();
          paramAnonymousc = ChatFooter.r(ChatFooter.this);
          Object localObject2 = ChatFooter.this;
          paramAnonymousString = ChatFooter.t(ChatFooter.this);
          i = ChatFooter.d(ChatFooter.this).getSelectionStart();
          p.k(localObject1, "context");
          p.k(paramAnonymousc, "talker");
          p.k(localObject2, "listener");
          p.k(paramAnonymousView, "query");
          p.k(paramAnonymousString, "sessionId");
          aa.f localf = new aa.f();
          localf.aaBC = new eql();
          HashMap localHashMap = new HashMap();
          ((Map)localHashMap).put("scene", "72");
          ((Map)localHashMap).put("sessionId", paramAnonymousString);
          ((Map)localHashMap).put("subSessionId", paramAnonymousString);
          ((Map)localHashMap).put("isHomePage", "1");
          if (!TextUtils.isEmpty((CharSequence)paramAnonymousView))
          {
            Map localMap = (Map)localHashMap;
            String str = q.an(paramAnonymousView, "utf8");
            p.j(str, "URLEncoder.encode(query, \"utf8\")");
            localMap.put("query", str);
            ((Map)localHashMap).put("cursorIndex", String.valueOf(i));
          }
          com.tencent.mm.plugin.websearch.a.c.ba((Map)localHashMap);
          ((eql)localf.aaBC).url = com.tencent.mm.plugin.websearch.a.c.aZ((Map)localHashMap);
          ((eql)localf.aaBC).talker = paramAnonymousc;
          ((eql)localf.aaBC).sessionId = paramAnonymousString;
          ((eql)localf.aaBC).scene = 72;
          ((eql)localf.aaBC).fwe = "";
          ((eql)localf.aaBC).jQi = "";
          ((eql)localf.aaBC).xbJ = 2;
          localObject2 = new com.tencent.mm.plugin.websearch.a.c.a((com.tencent.mm.plugin.websearch.a.a.a)localObject2, localf, paramAnonymousc, paramAnonymousString);
          localObject1 = new com.tencent.mm.plugin.websearch.a.a.c((Context)localObject1, (eql)localf.aaBC, (com.tencent.mm.plugin.websearch.a.a.a)localObject2);
          ((com.tencent.mm.plugin.websearch.a.a.c)localObject1).show();
          localObject2 = ((com.tencent.mm.plugin.websearch.a.a.c)localObject1).getWindow();
          if (localObject2 != null) {
            ((Window)localObject2).setLayout(-1, -1);
          }
          localObject2 = new og();
          ((og)localObject2).giq = 1L;
          ((og)localObject2).hbm = 0L;
          ((og)localObject2).hbn = 2L;
          ((og)localObject2).gDb = cm.bfF();
          if (!ab.Lj(paramAnonymousc)) {
            break label782;
          }
          l1 = 2L;
          ((og)localObject2).gpu = l1;
          ((og)localObject2).Fe(paramAnonymousc);
          ((og)localObject2).Ff(paramAnonymousString);
          ((og)localObject2).Fg(paramAnonymousView);
          ((og)localObject2).bpa();
          com.tencent.mm.plugin.websearch.api.ar.a((com.tencent.mm.plugin.report.a)localObject2);
          Log.i(com.tencent.mm.plugin.websearch.a.c.TAG, "startTagSearchDialog url:" + ((eql)localf.aaBC).url);
          ChatFooter.e((com.tencent.mm.plugin.websearch.a.a.c)localObject1);
          ChatFooter.d(ChatFooter.this).hZx();
          if (!ab.Lj(ChatFooter.r(ChatFooter.this))) {
            break label788;
          }
        }
        label782:
        label788:
        for (int i = 2;; i = 1)
        {
          com.tencent.mm.plugin.websearch.a.b.a(i, ChatFooter.r(ChatFooter.this), ChatFooter.s(ChatFooter.this), 2, paramAnonymousView, ChatFooter.t(ChatFooter.this), 2, l2);
          ChatFooter.c(ChatFooter.this, com.tencent.mm.plugin.fts.a.d.Sx(73));
          AppMethodBeat.o(273366);
          return;
          l1 = 1L;
          break;
        }
      }
    };
    this.KQB.a(((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(paramContext), paramAttributeSet);
    this.KQB.setKeyCodeEnterListener(new MMEditText.d()
    {
      private long PKa = 0L;
      
      public final boolean aqF(int paramAnonymousInt)
      {
        AppMethodBeat.i(282521);
        if ((paramAnonymousInt == 66) && (cm.bfE() - this.PKa > 1000L) && (com.tencent.mm.ui.ar.hIO()) && (com.tencent.mm.ui.ar.hIH()))
        {
          Log.i("MicroMsg.ChatFooter", "KeyCode Enter");
          this.PKa = cm.bfE();
          ChatFooter.k(ChatFooter.this).performClick();
          AppMethodBeat.o(282521);
          return true;
        }
        AppMethodBeat.o(282521);
        return false;
      }
    });
    this.KQB.addTextChangedListener(new TextWatcher()
    {
      private List<ForegroundColorSpan> KQU;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(278593);
        paramAnonymousEditable = ChatFooter.d(ChatFooter.this).getText();
        Object localObject = this.KQU.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramAnonymousEditable.removeSpan((ForegroundColorSpan)((Iterator)localObject).next());
        }
        this.KQU.clear();
        localObject = ChatFooter.d(ChatFooter.this).getText().toString();
        if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineC2CTag())
        {
          localObject = k.a.Rsi.matcher((CharSequence)localObject);
          while (((Matcher)localObject).find())
          {
            int i = ((Matcher)localObject).start();
            int j = ((Matcher)localObject).end();
            ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(ChatFooter.this.getResources().getColor(R.e.Link_100));
            this.KQU.add(localForegroundColorSpan);
            paramAnonymousEditable.setSpan(localForegroundColorSpan, i, j, 33);
          }
        }
        AppMethodBeat.o(278593);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (RjA != null)
    {
      RjA.dismiss();
      RjA = null;
    }
    paramAttributeSet = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(279064);
        Log.i("MicroMsg.ChatFooter", "onFocusChange: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(279064);
      }
    };
    this.KQB.setOnFocusChangeListener(paramAttributeSet);
    if (Build.VERSION.SDK_INT == 28) {
      this.KQB.setBreakStrategy(1);
    }
    paramAttributeSet = new sj();
    paramAttributeSet.fRQ.fRR = new com.tencent.mm.pluginsdk.ui.a.a()
    {
      public final void bqX(final String paramAnonymousString)
      {
        AppMethodBeat.i(185818);
        Log.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", new Object[] { paramAnonymousString });
        if ((Util.isNullOrNil(ChatFooter.f(ChatFooter.this).getTalkerUserName())) || (Util.isNullOrNil(paramAnonymousString)))
        {
          Log.e("MicroMsg.ChatFooter", "onImageReceived, error args");
          AppMethodBeat.o(185818);
          return;
        }
        com.tencent.mm.ui.base.h.a(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(R.l.eEr), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2Int = 1;
            AppMethodBeat.i(185817);
            boolean bool = z.f(paramAnonymousString, ChatFooter.f(ChatFooter.this).getTalkerUserName(), true);
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
    EventCenter.instance.publish(paramAttributeSet);
    this.Rjg = ((LinearLayout)this.fyN.findViewById(R.h.dWt));
    this.Rje = ((MaxHeightScrollView)this.fyN.findViewById(R.h.dWv));
    this.KQB.setMaxHeight(this.Rje.getMaxHeight() - this.Rje.getPaddingBottom() - this.Rje.getPaddingTop());
    this.RiZ = ((ChatFooterBottom)findViewById(R.h.dwY));
    this.mCC = ((ViewGroup)findViewById(R.h.dvn));
    this.RiY = findViewById(R.h.dxu);
    this.Rjb = ((ImageButton)this.fyN.findViewById(R.h.dwS));
    this.Rjc = ((ImageView)this.fyN.findViewById(R.h.dwT));
    this.jLo = ((Button)this.fyN.findViewById(R.h.dzh));
    this.Rjh = ((RelativeLayout)this.fyN.findViewById(R.h.dMX));
    this.Rji = ((RelativeLayout)this.fyN.findViewById(R.h.dIY));
    this.Rjj = ((TextView)this.fyN.findViewById(R.h.dIZ));
    this.Rjk = ((ImageView)this.fyN.findViewById(R.h.dIX));
    this.Rjl = ((TextView)this.fyN.findViewById(R.h.dMV));
    this.Rjm = ((WeImageView)this.fyN.findViewById(R.h.dMW));
    this.Rjz = ((ImageView)this.fyN.findViewById(R.h.dRo));
    this.jLo.setTextSize(0, com.tencent.mm.ci.a.aZ(paramContext, R.f.SmallBtnTextSize) * com.tencent.mm.ci.a.km(paramContext));
    this.RiW = ((Button)this.fyN.findViewById(R.h.eak));
    this.RiX = ((ImageButton)findViewById(R.h.dyF));
    tV(false);
    hlR();
    this.Rjn = new i(getContext(), getRootView(), this, new i.a()
    {
      public final void brv(String paramAnonymousString)
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
          com.tencent.mm.by.c.a(ChatFooter.i(ChatFooter.this), "gallery", ".ui.GalleryEntryUI", localIntent, 217);
          AppMethodBeat.o(185752);
          return;
        }
        com.tencent.mm.by.c.b(paramContext, "gallery", ".ui.GalleryEntryUI", localIntent, 217);
        AppMethodBeat.o(185752);
      }
    });
    this.Rjn.RnW = this;
    paramAttributeSet = getContext();
    getRootView();
    this.KQB.hZx();
    this.Rjo = new m(paramAttributeSet);
    this.Rjo.Rki = this.Rki;
    Log.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[] { Integer.valueOf(this.KQB.getImeOptions()) });
    this.KQB.a(new com.tencent.mm.ui.widget.cedit.api.c.a()
    {
      public final boolean rQ(int paramAnonymousInt)
      {
        AppMethodBeat.i(291416);
        if ((paramAnonymousInt == 4) || ((paramAnonymousInt == 0) && (ChatFooter.j(ChatFooter.this))))
        {
          ChatFooter.k(ChatFooter.this).performClick();
          AppMethodBeat.o(291416);
          return true;
        }
        AppMethodBeat.o(291416);
        return false;
      }
    });
    paramAttributeSet = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(185754);
        ChatFooter.this.setToSendTextColor(true);
        if (ChatFooter.l(ChatFooter.this) != null) {
          ChatFooter.l(ChatFooter.this).ag(paramAnonymousMotionEvent);
        }
        ChatFooter.m(ChatFooter.this);
        AppMethodBeat.o(185754);
        return false;
      }
    };
    this.KQB.setOnTouchListener(paramAttributeSet);
    paramAttributeSet = new ChatFooter.5(this, paramContext);
    this.KQB.setOnLongClickListener(paramAttributeSet);
    this.KQB.setCustomSelectionActionModeCallback(new ChatFooter.6(this, paramContext));
    this.jLo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        for (;;)
        {
          boolean bool;
          label308:
          try
          {
            AppMethodBeat.i(31499);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            paramAnonymousView = ChatFooter.d(ChatFooter.this).getText().toString();
            Log.i("MicroMsg.ChatFooter", "send msg onClick");
            if ((paramAnonymousView.trim().length() == 0) && (paramAnonymousView.length() != 0))
            {
              Log.d("MicroMsg.ChatFooter", "empty message cant be sent");
              if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
                ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.h.p(ChatFooter.this.getContext(), R.l.euK, R.l.app_tip));
              }
              ChatFooter.this.hlO();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(31499);
              return;
            }
            ChatFooter.c(ChatFooter.this, false);
            if (TextUtils.equals(ChatFooter.d(ChatFooter.this).getText().toString(), ChatFooter.d(ChatFooter.this).getPasterContent()))
            {
              Log.i("MicroMsg.ChatFooter", "paste clip board to send");
              ChatFooter.c(ChatFooter.this, true);
            }
            ChatFooter.d(ChatFooter.this, ChatFooter.d(ChatFooter.this).getSimilarPasteChange());
            ChatFooter.e(ChatFooter.this, ClipboardHelper.isCopyFromWX(ChatFooter.d(ChatFooter.this).getText()));
            ChatFooter.d(ChatFooter.this).hZA();
            if (ChatFooter.o(ChatFooter.this) == null) {
              break label378;
            }
            localObject = ChatFooter.o(ChatFooter.this);
            if (((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).DqF == null) {
              break label373;
            }
            bool = ((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).DqF.isShowing();
          }
          finally {}
          if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0) && (ChatFooter.l(ChatFooter.this) != null)) {
            ChatFooter.this.eBG();
          }
          ChatFooter.a(ChatFooter.this, paramAnonymousView.length());
          if (ChatFooter.a(ChatFooter.this, paramAnonymousView))
          {
            Log.i("MicroMsg.ChatFooter", "this is a quote msg");
            continue;
            label373:
            bool = false;
          }
          else
          {
            label378:
            while (!bool)
            {
              bool = false;
              break label308;
              if (ChatFooter.a(ChatFooter.this, paramAnonymousView, bool))
              {
                Log.i("MicroMsg.ChatFooter", "this is a group solitatire msg");
                break;
              }
              if ((ChatFooter.l(ChatFooter.this) == null) || (!ChatFooter.l(ChatFooter.this).aNX(paramAnonymousView))) {
                break;
              }
              ChatFooter.p(ChatFooter.this);
              ChatFooter.d(ChatFooter.this).clearComposingText();
              ChatFooter.b(ChatFooter.this, paramAnonymousView);
              break;
            }
            bool = true;
          }
        }
      }
    });
    if (com.tencent.mm.ui.ar.hIE()) {}
    label1936:
    label2602:
    for (;;)
    {
      boolean bool = false;
      this.RkS = bool;
      this.RkT = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWM, 0.5F);
      Log.i("MicroMsg.ChatFooter", "isNewTrans2Txt:%s, transOperationAreaFactor:%s", new Object[] { Boolean.valueOf(this.RkS), Float.valueOf(this.RkT) });
      this.RkJ = new com.tencent.mm.plugin.transvoice.a.a();
      if (this.RkS)
      {
        paramInt = com.tencent.mm.ui.ar.au(paramContext).x;
        this.RlF = ((int)(paramInt * this.RkT));
        Log.d("MicroMsg.ChatFooter", "newVoice2txtVoiceModeChangeLine: %s, newVoice2txtTransModeChangeLine: %s, screenWidth:%s", new Object[] { Integer.valueOf(this.RlE), Integer.valueOf(this.RlF), Integer.valueOf(paramInt) });
        this.RiW.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(222531);
            if (paramAnonymousView != ChatFooter.B(ChatFooter.this))
            {
              AppMethodBeat.o(222531);
              return false;
            }
            if (ChatFooter.this.RmG == ChatFooter.e.Rnc)
            {
              ChatFooter.b(ChatFooter.this, com.tencent.mm.ui.ax.au(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(R.f.dlP) - ay.aB(paramContext));
              switch (paramAnonymousMotionEvent.getAction())
              {
              }
            }
            for (;;)
            {
              AppMethodBeat.o(222531);
              return true;
              ChatFooter.b(ChatFooter.this, com.tencent.mm.ui.ax.au(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(R.f.dlP) - ay.aB(paramContext) + ChatFooter.C(ChatFooter.this));
              break;
              ChatFooter.D(ChatFooter.this).Nhq = 1;
              paramAnonymousView = com.tencent.mm.cq.a.VPo;
              com.tencent.mm.cq.a.Ff(false);
              ChatFooter.D(ChatFooter.this).rgW = System.currentTimeMillis();
              ChatFooter.D(ChatFooter.this).Nhd = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.D(ChatFooter.this).Nhe = ((int)paramAnonymousMotionEvent.getRawY());
              ChatFooter.a(ChatFooter.this, null);
              long l = System.nanoTime();
              ChatFooter.a(ChatFooter.this, new com.tencent.mm.modelvoiceaddr.h(String.valueOf(l & 0xFFFFFFFF)));
              ChatFooter.F(ChatFooter.this).b(ChatFooter.E(ChatFooter.this));
              if ((ChatFooter.this.getContext() instanceof Activity)) {
                ((Activity)ChatFooter.this.getContext()).getWindow().addFlags(128);
              }
              ChatFooter.B(ChatFooter.this).setBackgroundResource(R.g.record_shape_press);
              ChatFooter.B(ChatFooter.this).setText(R.l.chatfooter_releasetofinish);
              if (ChatFooter.l(ChatFooter.this) != null) {
                ChatFooter.l(ChatFooter.this).eRu();
              }
              ChatFooter.B(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(R.l.chat_footer_switch_press_btn));
              continue;
              if ((ChatFooter.G(ChatFooter.this) == null) || (!ChatFooter.G(ChatFooter.this).isShowing()))
              {
                Log.e("MicroMsg.NewVoice2txt", "window status err!!!");
              }
              else if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getX() < ChatFooter.B(ChatFooter.this).getWidth()) && (paramAnonymousMotionEvent.getRawY() > ChatFooter.H(ChatFooter.this)))
              {
                if (ChatFooter.this.RmG != ChatFooter.e.Rnc)
                {
                  ChatFooter.this.RmH = ChatFooter.this.RmG;
                  ChatFooter.this.RmG = ChatFooter.e.Rnc;
                  ChatFooter.I(ChatFooter.this);
                }
              }
              else if (paramAnonymousMotionEvent.getX() > ChatFooter.J(ChatFooter.this))
              {
                if (ChatFooter.e.Rne != ChatFooter.this.RmG) {
                  if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(paramAnonymousView.getContext()))
                  {
                    ChatFooter.this.RmG = ChatFooter.e.Rnd;
                    ChatFooter.this.RmH = ChatFooter.this.RmG;
                    ChatFooter.I(ChatFooter.this);
                  }
                  else
                  {
                    ChatFooter.this.RmH = ChatFooter.this.RmG;
                    ChatFooter.this.RmG = ChatFooter.e.Rne;
                    ChatFooter.I(ChatFooter.this);
                  }
                }
              }
              else if (ChatFooter.e.Rnd != ChatFooter.this.RmG)
              {
                ChatFooter.this.RmH = ChatFooter.this.RmG;
                ChatFooter.this.RmG = ChatFooter.e.Rnd;
                ChatFooter.I(ChatFooter.this);
                continue;
                Log.d("MicroMsg.NewVoice2txt", "begin finishCutShortSentence.");
                ChatFooter.F(ChatFooter.this).gss();
                Log.d("MicroMsg.NewVoice2txt", "end finishCutShortSentence.");
                ChatFooter.D(ChatFooter.this).Nhf = System.currentTimeMillis();
                ChatFooter.D(ChatFooter.this).Nhg = ((int)paramAnonymousMotionEvent.getRawX());
                ChatFooter.D(ChatFooter.this).Nhh = ((int)paramAnonymousMotionEvent.getRawY());
                if ((ChatFooter.this.NiX != null) && (ChatFooter.K(ChatFooter.this)))
                {
                  if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(paramAnonymousView.getContext()))
                  {
                    ChatFooter.B(ChatFooter.this).setBackgroundResource(R.g.input_bg);
                    ChatFooter.B(ChatFooter.this).setEnabled(true);
                    if (ChatFooter.this.RkS) {
                      ChatFooter.L(ChatFooter.this);
                    }
                    if (ChatFooter.M(ChatFooter.this) == null) {
                      continue;
                    }
                    ChatFooter.M(ChatFooter.this).dismiss();
                    continue;
                  }
                  ChatFooter.this.NiX.NgY = false;
                  paramAnonymousView = ChatFooter.this.NiX;
                  Log.d("MicroMsg.SceneVoiceInputAddr2", "reTrigger!!! canReTrigger: %s.", new Object[] { Boolean.valueOf(paramAnonymousView.NgZ) });
                  if ((paramAnonymousView.NgZ) && ((!((com.tencent.mm.modelvoiceaddr.c)paramAnonymousView.mlQ).brP()) || (!com.tencent.mm.kernel.h.aGY().a(paramAnonymousView.mlQ, 0)))) {
                    paramAnonymousView.gsu();
                  }
                }
                if ((ChatFooter.this.getContext() instanceof Activity)) {
                  ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                }
                ChatFooter.this.hlQ();
              }
            }
          }
        });
        this.RlP.addUpdateListener(this.RlU);
        this.RlQ.addUpdateListener(this.RlU);
        this.RlR.addUpdateListener(this.RlU);
        this.RlS.addUpdateListener(this.RlU);
        this.RlT.addUpdateListener(this.RlU);
      }
      for (;;)
      {
        this.RiX.setOnClickListener(new ChatFooter.20(this));
        hlm();
        this.Rjb.setVisibility(0);
        this.Rjb.setContentDescription(getContext().getString(R.l.chat_footer_app_btn_fold));
        this.Rjb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = -1;
            AppMethodBeat.i(273425);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
            localObject1 = ChatFooter.v(ChatFooter.this);
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
                  if (((a.a)localObject2).red_dot == 1)
                  {
                    k = j;
                    if (!ChatFooter.bru(((a.a)localObject2).RiB))
                    {
                      localObject2 = ((a.a)localObject2).RiB;
                      MultiProcessMMKV.getMMKV("plus_uncertain_enter").edit().putBoolean((String)localObject2, true);
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
            localChatFooter.Rjc.setVisibility(8);
            ((ImageButton)localObject1).setTag(Integer.valueOf(i));
            ChatFooter.this.hy(paramAnonymousView);
            if ((z.bdS().booleanValue()) && (ChatFooter.this.Rkg != null))
            {
              paramAnonymousView = ChatFooter.this.Rkg;
              localObject1 = Boolean.TRUE;
              paramAnonymousView.a((Boolean)localObject1, (Boolean)localObject1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(273425);
          }
        });
        Log.i("MicroMsg.ChatFooter", "[init]");
        this.RiY.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return true;
          }
        });
        this.RjP = (((Activity)paramContext).getWindow().getAttributes().softInputMode & 0xF0);
        if ((this.RjP != 16) && (this.RjP != 48))
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1062, 8);
          if (this.RjP != 16) {
            this.RjP = 48;
          }
        }
        this.RjX = KeyBoardUtil.getValidPanelHeight(paramContext);
        aqE(getKeyBordHeightPX());
        if (com.tencent.mm.compatible.util.d.qV(24)) {
          this.RjR = ((Activity)getContext()).isInMultiWindowMode();
        }
        hll();
        this.Rjm.setOnClickListener(new ChatFooter.9(this));
        this.Rjk.setOnClickListener(new ChatFooter.10(this));
        this.Rjj.setOnClickListener(new ChatFooter.11(this));
        Log.d("MicroMsg.ChatFooter", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(31573);
        return;
        if (isLandscape()) {
          break;
        }
        paramAttributeSet = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        if ((!paramAttributeSet.equals("zh_CN")) && (!paramAttributeSet.equals("zh_HK")) && (!paramAttributeSet.equals("zh_TW")) && (!paramAttributeSet.equals("en"))) {
          break;
        }
        if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
        {
          bool = true;
          break label1936;
        }
        if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWL, 1)) {
          break label2602;
        }
        bool = true;
        break label1936;
        Rko = com.tencent.mm.ci.a.kr(paramContext) / 2 + com.tencent.mm.ci.a.fromDPToPix(paramContext, 30);
        this.RkI = new com.tencent.mm.plugin.transvoice.ui.b(paramContext);
        this.RkI.Njt = new b.d()
        {
          public final void bfn(final String paramAnonymousString)
          {
            AppMethodBeat.i(271999);
            ChatFooter.this.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(185341);
                Log.i("MicroMsg.ChatFooter", "onTxtMsgSend, msg is null or nil? %s.", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramAnonymousString)) });
                if ((ChatFooter.l(ChatFooter.this) != null) && (!Util.isNullOrNil(paramAnonymousString))) {
                  ChatFooter.l(ChatFooter.this).aNX(paramAnonymousString);
                }
                AppMethodBeat.o(185341);
              }
            }, 200L);
            AppMethodBeat.o(271999);
          }
          
          public final void bfo(String paramAnonymousString)
          {
            AppMethodBeat.i(272004);
            if (ChatFooter.l(ChatFooter.this) != null) {
              ChatFooter.l(ChatFooter.this).aNY(paramAnonymousString);
            }
            AppMethodBeat.o(272004);
          }
          
          public final boolean d(String paramAnonymousString, Long paramAnonymousLong)
          {
            AppMethodBeat.i(272002);
            Log.i("MicroMsg.ChatFooter", "onVoiceMsgSend, fileName: %s.", new Object[] { paramAnonymousString });
            if (paramAnonymousLong != null) {}
            for (int i = paramAnonymousLong.intValue();; i = 0)
            {
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                boolean bool = ChatFooter.l(ChatFooter.this).eV(paramAnonymousString, i);
                AppMethodBeat.o(272002);
                return bool;
              }
              AppMethodBeat.o(272002);
              return false;
            }
          }
          
          public final void gsJ()
          {
            AppMethodBeat.i(271997);
            if (ChatFooter.N(ChatFooter.this).isShowing()) {
              ChatFooter.N(ChatFooter.this).dismiss();
            }
            ChatFooter.this.RjS = true;
            AppMethodBeat.o(271997);
          }
        };
        this.RiW.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(289890);
            if (paramAnonymousView != ChatFooter.B(ChatFooter.this))
            {
              AppMethodBeat.o(289890);
              return false;
            }
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(289890);
              return true;
              Log.i("MicroMsg.RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[] { Integer.valueOf(ChatFooter.hml()) });
              paramAnonymousView = com.tencent.mm.cq.a.VPo;
              com.tencent.mm.cq.a.Ff(false);
              ChatFooter.D(ChatFooter.this).rgW = System.currentTimeMillis();
              ChatFooter.D(ChatFooter.this).Nhd = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.D(ChatFooter.this).Nhe = ((int)paramAnonymousMotionEvent.getRawY());
              ChatFooter.O(ChatFooter.this);
              if ((ChatFooter.P(ChatFooter.this)) && (ChatFooter.M(ChatFooter.this) != null))
              {
                ChatFooter.Q(ChatFooter.this);
                if (ChatFooter.R(ChatFooter.this) != null) {
                  ChatFooter.R(ChatFooter.this).getBlurController().destroy();
                }
                if (ChatFooter.S(ChatFooter.this) != null) {
                  ChatFooter.S(ChatFooter.this).getBlurController().destroy();
                }
              }
              Log.i("MicroMsg.RcdBtnEvent", "trans voice opener: %s, blur mode opener: %s.", new Object[] { Boolean.valueOf(ChatFooter.T(ChatFooter.this)), ChatFooter.U(ChatFooter.this) });
              if (ChatFooter.T(ChatFooter.this)) {}
              for (ChatFooter.D(ChatFooter.this).Nhq = 1;; ChatFooter.D(ChatFooter.this).Nhq = 0)
              {
                ChatFooter.a(ChatFooter.this, null);
                long l = System.nanoTime();
                ChatFooter.a(ChatFooter.this, new com.tencent.mm.modelvoiceaddr.h(String.valueOf(l & 0xFFFFFFFF)));
                ChatFooter.F(ChatFooter.this).b(ChatFooter.E(ChatFooter.this));
                if ((ChatFooter.this.getContext() instanceof Activity)) {
                  ((Activity)ChatFooter.this.getContext()).getWindow().addFlags(128);
                }
                if ((ChatFooter.V(ChatFooter.this)) || (ChatFooter.W(ChatFooter.this))) {
                  break;
                }
                ChatFooter.f(ChatFooter.this, true);
                ChatFooter.B(ChatFooter.this).setBackgroundResource(R.g.record_shape_press);
                ChatFooter.B(ChatFooter.this).setText(R.l.chatfooter_releasetofinish);
                if (ChatFooter.l(ChatFooter.this) != null) {
                  ChatFooter.l(ChatFooter.this).eRu();
                }
                ChatFooter.B(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(R.l.chat_footer_switch_press_btn));
                break;
              }
              if ((ChatFooter.M(ChatFooter.this) == null) || (!ChatFooter.M(ChatFooter.this).isShowing()))
              {
                if (ChatFooter.M(ChatFooter.this) == null) {}
                for (boolean bool = true;; bool = false)
                {
                  Log.e("MicroMsg.RcdBtnEvent", "hint window status err, window is null: %s.", new Object[] { Boolean.valueOf(bool) });
                  break;
                }
              }
              if (ChatFooter.T(ChatFooter.this))
              {
                if ((ChatFooter.X(ChatFooter.this) == null) || (ChatFooter.Y(ChatFooter.this) == null)) {
                  Log.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! voice2txtRealHintArea is %s, voice2txtOpeLayout is %s.", new Object[] { ChatFooter.X(ChatFooter.this), ChatFooter.Y(ChatFooter.this) });
                }
                if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getY() > -ChatFooter.Z(ChatFooter.this) / 3) && (paramAnonymousMotionEvent.getX() < ChatFooter.B(ChatFooter.this).getWidth()))
                {
                  if (ChatFooter.aa(ChatFooter.this) != ChatFooter.l.Rny)
                  {
                    Log.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_1.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.Rny);
                    if (ChatFooter.ab(ChatFooter.this))
                    {
                      ChatFooter.ac(ChatFooter.this).animate().cancel();
                      ChatFooter.ad(ChatFooter.this).animate().cancel();
                      if (ChatFooter.j.Rnq == ChatFooter.U(ChatFooter.this))
                      {
                        ChatFooter.R(ChatFooter.this).setAlpha(0.5F);
                        ChatFooter.R(ChatFooter.this).animate().alpha(1.0F).setDuration(300L).start();
                        ChatFooter.R(ChatFooter.this).auW(ChatFooter.this.getResources().getColor(R.e.dkM)).L(ChatFooter.e(ChatFooter.this).getWindow().getDecorView().getBackground()).Gd(true);
                      }
                      for (;;)
                      {
                        ChatFooter.N(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(200L).start();
                        ChatFooter.ae(ChatFooter.this).setVisibility(0);
                        ChatFooter.af(ChatFooter.this).setVisibility(8);
                        ChatFooter.Y(ChatFooter.this).setVisibility(8);
                        ChatFooter.a(ChatFooter.this, ChatFooter.k.Rnt);
                        ChatFooter.ag(ChatFooter.this);
                        break;
                        ChatFooter.X(ChatFooter.this).setBackgroundResource(R.g.dpt);
                      }
                    }
                  }
                }
                else
                {
                  if (ChatFooter.aa(ChatFooter.this) != ChatFooter.l.Rnz)
                  {
                    Log.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_2.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.Rnz);
                    if (!ChatFooter.ab(ChatFooter.this)) {
                      ChatFooter.ah(ChatFooter.this);
                    }
                    Log.i("MicroMsg.RcdBtnEvent", "init rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.hmm()) });
                    if (paramAnonymousMotionEvent.getRawX() > ChatFooter.hmm())
                    {
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Rnu);
                      Log.i("MicroMsg.RcdBtnEvent", "init MODE_TRANS");
                      label1034:
                      if (ChatFooter.j.Rnq != ChatFooter.U(ChatFooter.this)) {
                        break label1312;
                      }
                      ChatFooter.R(ChatFooter.this).auW(0).L(null).Gd(false);
                    }
                    for (;;)
                    {
                      ChatFooter.N(ChatFooter.this).getContentView().animate().alpha(1.0F).setDuration(200L).start();
                      ChatFooter.ae(ChatFooter.this).setVisibility(8);
                      ChatFooter.af(ChatFooter.this).setVisibility(0);
                      ChatFooter.Y(ChatFooter.this).setVisibility(0);
                      ChatFooter.ac(ChatFooter.this).setVisibility(0);
                      ChatFooter.ad(ChatFooter.this).setVisibility(0);
                      ChatFooter.ac(ChatFooter.this).setAlpha(0.0F);
                      ChatFooter.ad(ChatFooter.this).setAlpha(0.0F);
                      ChatFooter.ac(ChatFooter.this).animate().translationX(ChatFooter.ak(ChatFooter.this)).translationY(ChatFooter.aj(ChatFooter.this)).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(150L).withEndAction(ChatFooter.ai(ChatFooter.this)).start();
                      ChatFooter.ad(ChatFooter.this).animate().translationX(ChatFooter.ak(ChatFooter.this)).translationY(ChatFooter.aj(ChatFooter.this)).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(150L).start();
                      break;
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Rnv);
                      Log.i("MicroMsg.RcdBtnEvent", "init MODE_CANCEL");
                      break label1034;
                      label1312:
                      ChatFooter.X(ChatFooter.this).setBackgroundColor(0);
                    }
                  }
                  if (ChatFooter.al(ChatFooter.this))
                  {
                    Log.i("MicroMsg.RcdBtnEvent", "active rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.hmm()) });
                    if ((paramAnonymousMotionEvent.getRawX() > ChatFooter.hmm()) && (ChatFooter.k.Rnu != ChatFooter.am(ChatFooter.this)))
                    {
                      Log.i("MicroMsg.RcdBtnEvent", "active MODE_TRANS.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Rnu);
                      ChatFooter.af(ChatFooter.this).setText(ChatFooter.this.getResources().getText(R.l.eUJ));
                      ChatFooter.an(ChatFooter.this);
                      ChatFooter.ao(ChatFooter.this);
                    }
                    else if ((paramAnonymousMotionEvent.getRawX() <= ChatFooter.hmm()) && (ChatFooter.k.Rnv != ChatFooter.am(ChatFooter.this)))
                    {
                      Log.i("MicroMsg.RcdBtnEvent", "active MODE_CANCEL.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.Rnv);
                      ChatFooter.af(ChatFooter.this).setText(ChatFooter.this.getResources().getText(R.l.eUH));
                      ChatFooter.ap(ChatFooter.this);
                      ChatFooter.aq(ChatFooter.this);
                    }
                  }
                }
              }
              else
              {
                if ((ChatFooter.ar(ChatFooter.this) == null) || (ChatFooter.as(ChatFooter.this) == null)) {
                  Log.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", new Object[] { ChatFooter.ar(ChatFooter.this), ChatFooter.as(ChatFooter.this) });
                }
                if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getY() > -ChatFooter.Z(ChatFooter.this) / 2) && (paramAnonymousMotionEvent.getX() < ChatFooter.B(ChatFooter.this).getWidth()))
                {
                  if (ChatFooter.ar(ChatFooter.this) != null) {
                    ChatFooter.ar(ChatFooter.this).setVisibility(0);
                  }
                  if (ChatFooter.as(ChatFooter.this) != null)
                  {
                    ChatFooter.B(ChatFooter.this).setText(R.l.chatfooter_releasetofinish);
                    ChatFooter.as(ChatFooter.this).setVisibility(8);
                  }
                }
                else
                {
                  if (ChatFooter.ar(ChatFooter.this) != null) {
                    ChatFooter.ar(ChatFooter.this).setVisibility(8);
                  }
                  if (ChatFooter.as(ChatFooter.this) != null)
                  {
                    ChatFooter.B(ChatFooter.this).setTextSize(0, com.tencent.mm.ci.a.aZ(ChatFooter.this.getContext(), R.f.NormalTextSize) * com.tencent.mm.ci.a.km(ChatFooter.this.getContext()));
                    ChatFooter.B(ChatFooter.this).setText(R.l.chatfooter_cancel_tips);
                    ChatFooter.as(ChatFooter.this).setVisibility(0);
                    continue;
                    ChatFooter.F(ChatFooter.this).gss();
                    if ((ChatFooter.this.getContext() instanceof Activity)) {
                      ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                    }
                    ChatFooter.D(ChatFooter.this).Nhf = System.currentTimeMillis();
                    ChatFooter.D(ChatFooter.this).Nhg = ((int)paramAnonymousMotionEvent.getRawX());
                    ChatFooter.D(ChatFooter.this).Nhh = ((int)paramAnonymousMotionEvent.getRawY());
                    Log.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.hml()) });
                    ChatFooter.this.hlQ();
                    Log.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.hmn()) });
                  }
                }
              }
            }
          }
        });
        this.RiW.setOnKeyListener(new View.OnKeyListener()
        {
          public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(280181);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            localb.sg(paramAnonymousInt);
            localb.bn(paramAnonymousKeyEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$31", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
            switch (paramAnonymousKeyEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$31", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(280181);
              return false;
              if (((paramAnonymousInt == 23) || (paramAnonymousInt == 66)) && (!ChatFooter.W(ChatFooter.this)) && (!ChatFooter.V(ChatFooter.this)))
              {
                ChatFooter.g(ChatFooter.this, true);
                ChatFooter.B(ChatFooter.this).setBackgroundResource(R.g.record_shape_press);
                ChatFooter.B(ChatFooter.this).setText(R.l.chatfooter_releasetofinish);
                if (ChatFooter.l(ChatFooter.this) != null) {
                  ChatFooter.l(ChatFooter.this).eRu();
                }
                ChatFooter.B(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(R.l.chat_footer_switch_press_btn));
                continue;
                if ((paramAnonymousInt == 23) || (paramAnonymousInt == 66))
                {
                  ChatFooter.B(ChatFooter.this).setBackgroundResource(R.g.input_bg);
                  ChatFooter.B(ChatFooter.this).setText(R.l.chatfooter_presstorcd);
                  if (ChatFooter.l(ChatFooter.this) != null) {
                    ChatFooter.l(ChatFooter.this).eRp();
                  }
                  ChatFooter.g(ChatFooter.this, false);
                }
              }
            }
          }
        });
      }
    }
  }
  
  private void Em(boolean paramBoolean)
  {
    AppMethodBeat.i(285099);
    En(paramBoolean);
    hlk();
    AppMethodBeat.o(285099);
  }
  
  private void Eo(boolean paramBoolean)
  {
    AppMethodBeat.i(31598);
    if (paramBoolean)
    {
      this.Rjg.setVisibility(0);
      this.Rje.setVisibility(0);
      bi(true, false);
      AppMethodBeat.o(31598);
      return;
    }
    this.Rjg.setVisibility(8);
    this.Rje.setVisibility(8);
    bi(false, false);
    AppMethodBeat.o(31598);
  }
  
  private void Er(boolean paramBoolean)
  {
    AppMethodBeat.i(31673);
    if (this.Rjd == null)
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((this.Rml) && (paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((!this.Rml) && (!paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    this.Rml = paramBoolean;
    if (paramBoolean)
    {
      this.Rjd.setImageDrawable(getContext().getResources().getDrawable(R.g.chatting_setmode_keyboard_btn));
      AppMethodBeat.o(31673);
      return;
    }
    this.Rjd.setImageDrawable(getContext().getResources().getDrawable(R.k.icons_outlined_emoji));
    AppMethodBeat.o(31673);
  }
  
  private void a(boolean paramBoolean, final Runnable paramRunnable)
  {
    AppMethodBeat.i(31658);
    if (paramBoolean)
    {
      if (this.jPN == null) {
        hll();
      }
      this.jPN.animate().cancel();
      if ((this.jPN.getVisibility() == 0) && (this.jPN.getAlpha() == 1.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(31658);
        }
      }
      else
      {
        this.jPN.setVisibility(0);
        this.jPN.setAlpha(0.0F);
        this.jPN.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
        this.jPN.setToSendText(this.KQB.getText().toString());
        AppMethodBeat.o(31658);
      }
    }
    else if ((this.jPN == null) || (this.jPN.getVisibility() == 4) || (this.jPN.getAlpha() == 0.0F))
    {
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(31658);
      }
    }
    else
    {
      this.jPN.animate().cancel();
      this.jPN.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(272418);
          ChatFooter.z(ChatFooter.this).setVisibility(4);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(272418);
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
      if (this.RiU == null) {
        hlm();
      }
      this.RiU.animate().cancel();
      if ((this.RiU.getVisibility() == 0) && (this.RiU.getAlpha() == 1.0F)) {
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    }
    for (;;)
    {
      this.KQB.hZw();
      AppMethodBeat.o(163216);
      return;
      setAppPanelVisible(0);
      this.RiU.setAlpha(0.0F);
      this.RiU.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(280739);
          ChatFooter.bo(ChatFooter.this);
          ChatFooter.bp(ChatFooter.this).animate().setListener(null);
          AppMethodBeat.o(280739);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      this.RiU.setUncertainEnterLocation(paramInt);
      this.RiU.bfU();
      continue;
      this.RiU.animate().cancel();
      if ((this.RiU.getVisibility() == 4) || (this.RiU.getAlpha() == 0.0F))
      {
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
      else {
        this.RiU.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(290224);
            ChatFooter.this.setAppPanelVisible(4);
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(290224);
          }
        });
      }
    }
  }
  
  private void aV(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185825);
    if (1 == paramInt3) {}
    for (boolean bool = true; ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) && (paramInt2 == 0); bool = false)
    {
      if (this.Rkc == null) {
        break label111;
      }
      this.Rkc.Gk(bool);
      AppMethodBeat.o(185825);
      return;
    }
    if ((paramInt1 == 0) && ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 4)) && (this.Rkc != null)) {
      this.Rkc.Gl(bool);
    }
    label111:
    AppMethodBeat.o(185825);
  }
  
  private void appendText(String paramString)
  {
    AppMethodBeat.i(285100);
    if (this.KQB == null)
    {
      AppMethodBeat.o(285100);
      return;
    }
    this.KQB.append(paramString);
    this.KQB.setSelection(this.KQB.getText().length());
    this.KQB.hZB();
    AppMethodBeat.o(285100);
  }
  
  private void aqD(int paramInt)
  {
    AppMethodBeat.i(31666);
    if (paramInt == this.jJL)
    {
      AppMethodBeat.o(31666);
      return;
    }
    if (this.jLo.getVisibility() == 8) {
      hlO();
    }
    if (((paramInt == 0) && (this.Rje.getVisibility() == 8)) || (paramInt == 3) || ((paramInt == 0) && (this.Rje.getVisibility() == 8))) {
      hlO();
    }
    AppMethodBeat.o(31666);
  }
  
  private void aqE(int paramInt)
  {
    AppMethodBeat.i(31680);
    Log.i("MicroMsg.ChatFooter", "[refreshBottomHeight] keyborPx:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.compatible.util.i.setFixedHeight(false);
    int i;
    if ((as.bvK(this.RiT)) || (as.bvL(this.RiT)))
    {
      paramInt = com.tencent.mm.compatible.util.i.getValidPanelHeight(getContext(), paramInt, 43);
      i = ad.bC(getContext());
      if ((!this.RjL) || (this.RjR)) {
        break label367;
      }
    }
    label367:
    for (this.RjX = paramInt;; this.RjX = KeyBoardUtil.getValidPanelHeight(getContext()))
    {
      paramInt = Math.max(i, this.RjX);
      this.RjY = paramInt;
      if (paramInt != this.RjW) {
        this.RjW = paramInt;
      }
      Log.i("MicroMsg.ChatFooter", "refreshBottomHeight: %s, %s, %s, %s, %s", new Object[] { Boolean.valueOf(this.RjL), Boolean.valueOf(this.RjR), Integer.valueOf(this.RjX), Integer.valueOf(this.RjW), Boolean.valueOf(KeyBoardUtil.isPortOrientation(getContext())) });
      Object localObject = this.RiZ.getLayoutParams();
      if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != this.RjW))
      {
        ((ViewGroup.LayoutParams)localObject).height = this.RjW;
        this.RiZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.RiZ.requestLayout();
      }
      if (this.RjO)
      {
        paramInt = -this.RjW;
        localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
        if ((localObject != null) && (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != paramInt))
        {
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
          setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.RiU != null)
      {
        this.RiU.setPortHeighPx(this.RjX);
        this.RiU.hkX();
      }
      if (this.RdV != null)
      {
        paramInt = this.RjX + this.RiY.getHeight();
        localObject = this.RdV.getLayoutParams();
        if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != paramInt))
        {
          ((ViewGroup.LayoutParams)localObject).height = paramInt;
          this.RdV.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(31680);
      return;
      paramInt = com.tencent.mm.compatible.util.i.getValidPanelHeight(getContext(), paramInt);
      break;
    }
  }
  
  private void aqy(int paramInt)
  {
    AppMethodBeat.i(31593);
    if (this.RiX == null)
    {
      AppMethodBeat.o(31593);
      return;
    }
    if (paramInt == R.g.dnf) {}
    for (int i = 1;; i = 0)
    {
      if (this.RiX != null)
      {
        if (i == 0) {
          break label83;
        }
        this.RiX.setContentDescription(getContext().getString(R.l.chat_footer_switch_mode_voice_btn));
      }
      for (;;)
      {
        this.RiX.setImageResource(paramInt);
        this.RiX.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(31593);
        return;
        label83:
        this.RiX.setContentDescription(getContext().getString(R.l.chat_footer_switch_mode_keybord_btn));
      }
    }
  }
  
  private void b(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185824);
    hlL();
    if (this.RjN != null)
    {
      if ((this.RjV) && (this.jJL == 1))
      {
        this.RjN.c(0, false, paramInt2, paramInt3);
        AppMethodBeat.o(185824);
        return;
      }
      this.RjN.c(paramInt1, paramBoolean, paramInt2, paramInt3);
      AppMethodBeat.o(185824);
      return;
    }
    if ((this.jJL == 0) || (this.jJL == 1)) {
      this.RiZ.setVisibility(8);
    }
    Log.e("MicroMsg.ChatFooter", "scrollParent: scrollParent is not ChattingScrollLayout");
    AppMethodBeat.o(185824);
  }
  
  private void bi(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31599);
    if (paramBoolean1)
    {
      if ((this.Rjh.getTag() != null) && ((this.Rjh.getTag() instanceof ca)))
      {
        this.Rjh.setVisibility(0);
        ca localca = (ca)this.Rjh.getTag();
        this.Rjl.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), com.tencent.mm.plugin.msgquote.model.a.a(getContext(), this.Rjl.getTextSize(), localca)));
        AppMethodBeat.o(31599);
        return;
      }
      this.Rjh.setVisibility(8);
      AppMethodBeat.o(31599);
      return;
    }
    if (paramBoolean2)
    {
      this.Rjh.setTag(null);
      this.Rjl.setText("");
    }
    this.Rjh.setVisibility(8);
    AppMethodBeat.o(31599);
  }
  
  static boolean bru(String paramString)
  {
    AppMethodBeat.i(163219);
    boolean bool = MultiProcessMMKV.getMMKV("plus_uncertain_enter").getBoolean(paramString, false);
    AppMethodBeat.o(163219);
    return bool;
  }
  
  private boolean jdMethod_do(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(179783);
    if (hlP())
    {
      AppMethodBeat.o(179783);
      return false;
    }
    if ((this.Rkl == null) || (Util.isNullOrNil(this.Rkl.getTalkerUserName())))
    {
      Log.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg username == null");
      AppMethodBeat.o(179783);
      return false;
    }
    try
    {
      String str = this.Rkl.getTalkerUserName();
      if ((((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aKU(str)) && (paramBoolean))
      {
        this.Rjp.eBD();
        try
        {
          localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.a.class)).atQ(paramString);
          paramString = (String)localObject;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject;
            Log.e("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          }
          com.tencent.mm.plugin.groupsolitaire.b.b.b(locala1);
          locala2 = com.tencent.mm.plugin.groupsolitaire.b.b.a(localException, this.Rjp.DqP, locala1);
          if (!locala2.DpH) {
            break label296;
          }
          com.tencent.mm.plugin.groupsolitaire.b.b.c(locala2);
          label296:
          locala2.field_lastActiveTime = cm.bfF();
          if (locala1 == null) {
            break label391;
          }
        }
        localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().ij(paramString, str);
        if ((((Integer)((Pair)localObject).first).intValue() > 0) && (((Pair)localObject).second != null))
        {
          localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second;
          com.tencent.mm.plugin.groupsolitaire.b.b.a(str, z.bcZ(), (com.tencent.mm.plugin.groupsolitaire.c.a)localObject);
          com.tencent.mm.plugin.groupsolitaire.c.a locala1 = com.tencent.mm.plugin.groupsolitaire.b.b.a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().t(str, ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_key, true), z.bcZ(), 1);
          if (locala1 == null)
          {
            Log.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg storageGroupSolitatire == null");
            AppMethodBeat.o(179783);
            return false;
          }
          com.tencent.mm.plugin.groupsolitaire.c.a locala2;
          paramBoolean = true;
          com.tencent.mm.plugin.groupsolitaire.b.b.a(locala2, paramBoolean, true);
          PluginGroupSolitaire localPluginGroupSolitaire = (PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class);
          if (locala1.field_active == 0) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            localPluginGroupSolitaire.sendGroupSolitatire(paramString, str, localException, locala2, locala1, paramBoolean);
            if (this.Rjq != null) {
              this.Rjq.aLh(paramString);
            }
            this.Rjp.reset();
            hlh();
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
      Log.e("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg() Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      AppMethodBeat.o(179783);
    }
    return false;
  }
  
  private boolean eBC()
  {
    AppMethodBeat.i(31608);
    if (this.Rjp != null)
    {
      boolean bool = this.Rjp.eBC();
      AppMethodBeat.o(31608);
      return bool;
    }
    AppMethodBeat.o(31608);
    return false;
  }
  
  private int getDefaultLangType()
  {
    AppMethodBeat.i(185418);
    int i = com.tencent.mm.modelvoiceaddr.g.mlS;
    String str = LocaleUtil.getCurrentLanguage(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW"))) {
      i = com.tencent.mm.modelvoiceaddr.g.mlT;
    }
    for (;;)
    {
      AppMethodBeat.o(185418);
      return i;
      if (str.equals("en")) {
        i = com.tencent.mm.modelvoiceaddr.g.mlV;
      }
    }
  }
  
  private int getTransLangTypeByTalker()
  {
    AppMethodBeat.i(185417);
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voice2txt_sp", 0);
    int j = localSharedPreferences.getInt(this.RiT, com.tencent.mm.modelvoiceaddr.g.mlS);
    if (this.Rle != null)
    {
      Iterator localIterator = this.Rle.NhH.jjG.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((com.tencent.mm.plugin.transvoice.ui.a.a.a)localIterator.next()).NjM != j);
      for (i = 1; i == 0; i = 0)
      {
        i = getDefaultLangType();
        if (com.tencent.mm.modelvoiceaddr.g.mlS != i) {
          localSharedPreferences.edit().putInt(this.RiT, i).apply();
        }
        AppMethodBeat.o(185417);
        return i;
      }
      AppMethodBeat.o(185417);
      return j;
    }
    int i = getDefaultLangType();
    if (com.tencent.mm.modelvoiceaddr.g.mlS != i) {
      localSharedPreferences.edit().putInt(this.RiT, i).apply();
    }
    AppMethodBeat.o(185417);
    return i;
  }
  
  private void hlF()
  {
    AppMethodBeat.i(31640);
    this.fyN.findViewById(R.h.dzi).setVisibility(0);
    AppMethodBeat.o(31640);
  }
  
  private void hlG()
  {
    AppMethodBeat.i(31641);
    Log.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
    this.RjI = false;
    this.KQB.setImeOptions(0);
    this.KQB.setInputType(this.KQB.getInputType() | 0x40);
    AppMethodBeat.o(31641);
  }
  
  private void hlL()
  {
    AppMethodBeat.i(31660);
    if (this.RjN == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ChattingScrollLayout))
      {
        this.RjN = ((ChattingScrollLayout)localViewParent);
        this.RjO = true;
      }
    }
    AppMethodBeat.o(31660);
  }
  
  private void hlM()
  {
    AppMethodBeat.i(31668);
    if (!this.zQA)
    {
      Log.i("MicroMsg.ChatFooter", "updateKeyboardProvider: not resumed %s", new Object[] { Util.getStack() });
      AppMethodBeat.o(31668);
      return;
    }
    if ((this.RjR) || (!this.RjL))
    {
      this.jij.close();
      ((Activity)getContext()).getWindow().setSoftInputMode(18);
      AppMethodBeat.o(31668);
      return;
    }
    ((Activity)getContext()).getWindow().setSoftInputMode(this.RjP | 0x2);
    this.jij.start();
    AppMethodBeat.o(31668);
  }
  
  private void hlW()
  {
    AppMethodBeat.i(31687);
    this.RkA.setVisibility(8);
    this.RkD.setVisibility(8);
    this.RkA.setScaleX(0.5F);
    this.RkA.setScaleY(0.5F);
    this.RkD.setScaleX(0.5F);
    this.RkD.setScaleY(0.5F);
    this.RkA.setTranslationX(this.Rmy);
    this.RkA.setTranslationY(-this.Rmz);
    this.RkD.setTranslationX(-this.Rmy);
    this.RkD.setTranslationY(-this.Rmz);
    hlX();
    hlY();
    AppMethodBeat.o(31687);
  }
  
  private void hlX()
  {
    AppMethodBeat.i(31688);
    this.RkB.setIconColor(getResources().getColor(R.e.black_per90));
    this.RkC.setTextColor(getResources().getColor(R.e.dkO));
    this.RkA.setBackgroundDrawable(getResources().getDrawable(R.g.voice2txt_normal_bg));
    AppMethodBeat.o(31688);
  }
  
  private void hlY()
  {
    AppMethodBeat.i(31689);
    this.RkE.setIconColor(getResources().getColor(R.e.black_per90));
    this.RkF.setTextColor(getResources().getColor(R.e.dkO));
    this.RkD.setBackgroundDrawable(getResources().getDrawable(R.g.voice2txt_normal_bg));
    AppMethodBeat.o(31689);
  }
  
  private void hlZ()
  {
    AppMethodBeat.i(31690);
    String str = LocaleUtil.getCurrentLanguage(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
    {
      this.Rky.setImageResource(R.k.voice2txt_hint_trans_chs);
      this.RkE.setImageResource(R.k.voice2txt_trans_chs_img);
      AppMethodBeat.o(31690);
      return;
    }
    if (str.equals("en"))
    {
      this.Rky.setImageResource(R.k.voice2txt_hint_trans_eng);
      this.RkE.setImageResource(R.k.voice2txt_trans_eng_img);
    }
    AppMethodBeat.o(31690);
  }
  
  private void hlf()
  {
    AppMethodBeat.i(31572);
    if (this.Rkf != null)
    {
      com.tencent.mm.f.b.a.m localm = this.Rkf;
      localm.geL = 0L;
      localm.geJ = 0L;
      localm.geK = 0L;
      localm.geM = 0L;
      localm.bZ(0L).ca(0L);
    }
    AppMethodBeat.o(31572);
  }
  
  private void hlk()
  {
    if (this.fyN == null) {}
  }
  
  private void hlm()
  {
    AppMethodBeat.i(31594);
    String str;
    if (this.Rkl == null)
    {
      str = this.RiT;
      this.RiU = ((AppPanel)findViewById(R.h.dvu));
      this.RiU.setOnSwitchPanelListener(this.RlI);
      this.RiU.setChattingContext(this.RlJ);
      this.RiU.setPortHeighPx(KeyBoardUtil.getValidPanelHeight(getContext()));
      if ((!ab.QX(str)) && (!ab.QO(str))) {
        break label124;
      }
      this.RiU.init(0);
    }
    for (;;)
    {
      this.Rja = ((TextView)findViewById(R.h.dvv));
      AppMethodBeat.o(31594);
      return;
      str = this.Rkl.getTalkerUserName();
      break;
      label124:
      if (ab.Qm(str)) {
        this.RiU.init(4);
      } else if (ab.Lj(str)) {
        this.RiU.init(2);
      } else {
        this.RiU.init(1);
      }
    }
  }
  
  private void hlo()
  {
    AppMethodBeat.i(185399);
    this.RlP.start();
    this.RlQ.start();
    this.RlR.start();
    this.RlS.start();
    this.RlT.start();
    this.Rlz.animate().alpha(1.0F).setDuration(200L).start();
    this.RlA.animate().alpha(1.0F).setDuration(200L).start();
    this.Rlj.animate().alpha(1.0F).translationY(0.0F).setDuration(300L).start();
    hmc();
    AppMethodBeat.o(185399);
  }
  
  private void hlp()
  {
    AppMethodBeat.i(31617);
    if (this.RjG)
    {
      this.wLp.setVisibility(8);
      this.wLq.setVisibility(8);
      this.MkW.setVisibility(8);
      this.wLn.setVisibility(8);
      this.Rkp.setVisibility(0);
      this.Rks.setVisibility(0);
      this.Rkt.setVisibility(0);
      this.Rkv.setVisibility(8);
      this.Rkw.setVisibility(0);
      this.Rkx.setVisibility(8);
      this.Rkz.setVisibility(8);
      this.RkA.setVisibility(8);
      this.RkD.setVisibility(8);
      this.RkP = k.Rnt;
      this.RkN = l.Rnx;
      AppMethodBeat.o(31617);
      return;
    }
    this.wLp.setVisibility(0);
    this.wLq.setVisibility(8);
    this.MkW.setVisibility(8);
    this.wLn.setVisibility(8);
    this.Rkp.setVisibility(8);
    AppMethodBeat.o(31617);
  }
  
  private void hma()
  {
    AppMethodBeat.i(185403);
    int k = this.RkX.getWidth();
    int m = this.RkX.getHeight();
    int j = 0;
    int i = 0;
    switch (85.RmU[this.RmG.ordinal()])
    {
    }
    for (;;)
    {
      Log.i("MicroMsg.ChatFooter", "beginWidth:%s, endWidth:%s, beginHeight:%s, endHeight:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i) });
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { k, j }).setDuration(200L);
      localValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(263346);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.aA(ChatFooter.this).getLayoutParams()).width = i;
          ChatFooter.aA(ChatFooter.this).requestLayout();
          AppMethodBeat.o(263346);
        }
      });
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { m, i }).setDuration(200L);
      localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(208904);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.aA(ChatFooter.this).getLayoutParams()).height = i;
          ChatFooter.aA(ChatFooter.this).requestLayout();
          AppMethodBeat.o(208904);
        }
      });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
      localAnimatorSet.start();
      AppMethodBeat.o(185403);
      return;
      j = this.Rmg;
      i = this.Nmf;
      continue;
      j = this.RlY;
      i = this.Rmd;
      continue;
      j = this.RlZ;
      i = this.Nmf;
    }
  }
  
  private void hmb()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(185404);
    float f3 = this.RkX.getTranslationX();
    float f1 = f2;
    switch (85.RmU[this.RmG.ordinal()])
    {
    }
    for (f1 = f2;; f1 = -(com.tencent.mm.ui.ax.au(getContext()).x / 2 - aw.fromDPToPix(getContext(), 76)))
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f3, f1 }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(211617);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ChatFooter.aA(ChatFooter.this).setTranslationX(f);
          AppMethodBeat.o(211617);
        }
      });
      localValueAnimator.start();
      AppMethodBeat.o(185404);
      return;
    }
  }
  
  private void hmc()
  {
    AppMethodBeat.i(185405);
    this.RkX.setAlpha(0.0F);
    this.RkX.setTranslationY(aw.fromDPToPix(getContext(), 56));
    this.Rla.setAlpha(0);
    this.Rla.setTranslationY(aw.fromDPToPix(getContext(), 56));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.RkX, "translationY", new float[] { this.RkX.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.RkX, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.Rla, "translationY", new float[] { this.Rla.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofInt(this.Rla, "alpha", new int[] { 0, 255 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    localAnimatorSet.start();
    AppMethodBeat.o(185405);
  }
  
  private void hmd()
  {
    AppMethodBeat.i(185406);
    this.RkZ.setVisibility(8);
    this.Rlc.setVisibility(0);
    this.Rlc.setTextColor(getContext().getResources().getColor(R.e.black));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Rlg.getLayoutParams();
    localLayoutParams.addRule(13);
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    this.Rlc.setText(String.format(getContext().getResources().getString(R.l.eMz), new Object[] { Integer.valueOf(this.Rmh) }));
    this.Rlg.requestLayout();
    AppMethodBeat.o(185406);
  }
  
  private void hme()
  {
    AppMethodBeat.i(185407);
    this.RkZ.setVisibility(8);
    this.Rlc.setVisibility(0);
    this.Rlc.setTextColor(getContext().getResources().getColor(R.e.half_alpha_black));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Rlg.getLayoutParams();
    localLayoutParams.removeRule(13);
    localLayoutParams.addRule(21);
    localLayoutParams.addRule(12);
    this.Rlc.setText(String.format(getContext().getResources().getString(R.l.eMz), new Object[] { Integer.valueOf(this.Rmh) }));
    this.Rlg.requestLayout();
    AppMethodBeat.o(185407);
  }
  
  private void hmf()
  {
    AppMethodBeat.i(185408);
    this.RkZ.setVisibility(0);
    this.Rlc.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Rlg.getLayoutParams();
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    localLayoutParams.addRule(13);
    this.Rlg.requestLayout();
    ((RelativeLayout.LayoutParams)this.RkZ.getLayoutParams()).bottomMargin = 0;
    this.RkZ.requestLayout();
    AppMethodBeat.o(185408);
  }
  
  private void hmg()
  {
    AppMethodBeat.i(185409);
    this.Rlz.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).withEndAction(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(275245);
        ChatFooter.bz(ChatFooter.this).setVisibility(8);
        ChatFooter.bA(ChatFooter.this).C(ChatFooter.this.getResources().getColor(R.e.black), 0.5F);
        AppMethodBeat.o(275245);
      }
    }).start();
    this.RlA.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).start();
    this.RlB.animate().translationY(0.0F).setDuration(100L).start();
    if (this.Rmh < 10) {
      hmd();
    }
    for (;;)
    {
      this.Rlh.setVisibility(0);
      this.Rlf.setVisibility(8);
      this.RkY.setVisibility(8);
      this.Rla.setImageDrawable(au.o(getContext(), R.k.icons_filled_voice2txt_cursor, getContext().getResources().getColor(R.e.LightGreen)));
      this.Rla.animate().translationX(0.0F).setDuration(150L).start();
      this.RkX.setActivated(true);
      hma();
      hmb();
      AppMethodBeat.o(185409);
      return;
      hmf();
      this.RkZ.a(SoundWaveView.d.NiI);
    }
  }
  
  private void hmh()
  {
    AppMethodBeat.i(185410);
    this.Rlo.setVisibility(4);
    this.Rlm.C(getResources().getColor(R.e.White), 0.5F);
    this.Rlk.setBackgroundDrawable(getResources().getDrawable(R.g.doj));
    this.Rlk.animate().scaleX(1.0F).scaleY(1.0F).setDuration(150L).start();
    AppMethodBeat.o(185410);
  }
  
  private void hmi()
  {
    AppMethodBeat.i(185411);
    this.Rlp.setVisibility(4);
    this.Rln.C(getResources().getColor(R.e.White), 0.5F);
    this.Rll.setBackgroundDrawable(getResources().getDrawable(R.g.doj));
    this.Rll.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    AppMethodBeat.o(185411);
  }
  
  private void hmj()
  {
    AppMethodBeat.i(185412);
    int j = aw.fromDPToPix(getContext(), 20);
    if ((this.RkY.getText() != null) && (this.RkY.getText().length() > 0)) {}
    for (int i = this.RkY.getText().length();; i = 0)
    {
      this.RkY.setSelection(i);
      this.RkY.setPadding(j, j, j, j);
      this.Rlj.setVisibility(8);
      this.Rlh.setVisibility(8);
      this.Rly.setVisibility(4);
      this.Rlq.setVisibility(0);
      this.Rld.setVisibility(0);
      com.tencent.mm.cq.a.a locala = com.tencent.mm.cq.a.VPo;
      com.tencent.mm.cq.a.hFa();
      this.Rlc.setVisibility(8);
      this.RkZ.setVisibility(8);
      AppMethodBeat.o(185412);
      return;
    }
  }
  
  private static boolean isLandscape()
  {
    AppMethodBeat.i(185402);
    if (MMApplicationContext.getContext().getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(185402);
      return true;
    }
    AppMethodBeat.o(185402);
    return false;
  }
  
  private void l(int paramInt1, boolean paramBoolean, final int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(163218);
    Log.i("MicroMsg.ChatFooter", "switchPanel: %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    if (this.Rka)
    {
      AppMethodBeat.o(163218);
      return;
    }
    if ((paramInt1 != 0) && (z.bdS().booleanValue()) && (this.Rkg != null))
    {
      this.Rkg.a(Boolean.TRUE, Boolean.FALSE);
      this.Rkg.b(Boolean.TRUE, Boolean.FALSE);
    }
    aqD(paramInt1);
    if (this.RiY != null) {
      this.RiY.setVisibility(0);
    }
    this.Rji.setVisibility(8);
    switch (paramInt1)
    {
    default: 
      if (((this.jJL != 0) || (paramInt1 != 1)) && ((this.jJL != 1) || (paramInt1 != 0))) {
        break;
      }
    }
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      aV(this.jJL, paramInt1, paramInt2);
      int i;
      label211:
      Object localObject;
      label237:
      int k;
      if (this.jJL != paramInt1)
      {
        i = 1;
        this.jJL = paramInt1;
        if (this.jJL != 2) {
          break label564;
        }
        Er(true);
        localObject = com.tencent.mm.emoji.c.b.jNn;
        com.tencent.mm.emoji.c.b.aCZ();
        k = this.RjQ;
        if (this.Rkc != null) {
          break label580;
        }
      }
      label564:
      label580:
      for (paramInt1 = j;; paramInt1 = this.Rkc.eBE())
      {
        b(k, paramBoolean, paramInt2, paramInt1);
        if (i != 0) {
          com.tencent.e.h.ZvG.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(254201);
              if ((ChatFooter.f(ChatFooter.this) != null) && (ChatFooter.f(ChatFooter.this).hmp() != null))
              {
                com.tencent.mm.ui.chatting.d.b.ax localax = (com.tencent.mm.ui.chatting.d.b.ax)ChatFooter.f(ChatFooter.this).hmp().bC(com.tencent.mm.ui.chatting.d.b.ax.class);
                if (localax != null) {
                  localax.hQY();
                }
              }
              AppMethodBeat.o(254201);
            }
          }, 300L);
        }
        if (this.Rjs != null) {
          this.Rjs.lX(this.jJL, this.RjQ);
        }
        AppMethodBeat.o(163218);
        return;
        if ((!this.RjL) || (this.RjR)) {}
        for (this.RjQ = 0;; this.RjQ = this.pIk)
        {
          a(false, null);
          a(false, null, -1);
          localObject = com.tencent.mm.plugin.hld.f.l.DHK;
          if (!com.tencent.mm.plugin.hld.f.l.eHA()) {
            break;
          }
          this.Rji.setVisibility(0);
          localObject = com.tencent.mm.plugin.hld.f.l.DHK;
          com.tencent.mm.plugin.hld.f.l.eHB().putInt("ime_old_user_guide_show", 2);
          break;
        }
        this.RjQ = this.RjY;
        this.RiZ.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249619);
            ChatFooter.bs(ChatFooter.this);
            AppMethodBeat.o(249619);
          }
        }, -1);
        break;
        this.RjQ = this.RjX;
        this.RiZ.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197270);
            ChatFooter.i(ChatFooter.this, paramInt2);
            AppMethodBeat.o(197270);
          }
        });
        this.Rjn.hmw();
        Em(false);
        if (this.RjF != 2) {
          break;
        }
        aqB(1);
        break;
        this.RjQ = 0;
        a(false, null);
        a(false, null, -1);
        hjU();
        hlN();
        break;
        if (this.RiY != null) {
          this.RiY.setVisibility(4);
        }
        this.RjQ = this.RjZ;
        a(false, null);
        a(false, null, -1);
        break;
        i = 0;
        break label211;
        Er(false);
        localObject = com.tencent.mm.emoji.c.b.jNn;
        com.tencent.mm.emoji.c.b.aDa();
        break label237;
      }
    }
  }
  
  private void setNewVoice2TxtCountDown(int paramInt)
  {
    AppMethodBeat.i(185400);
    if ((paramInt > 60) || (paramInt < 0))
    {
      Log.w("MicroMsg.ChatFooter", "skip by invalid quantity:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(185400);
      return;
    }
    switch (85.RmU[this.RmG.ordinal()])
    {
    }
    for (;;)
    {
      this.Rmh = paramInt;
      AppMethodBeat.o(185400);
      return;
      int i = 60 - paramInt;
      int j = (int)(this.Rmc * i);
      this.Rmg = Math.min(this.Rmb + j, this.Rma);
      Log.d("MicroMsg.ChatFooter", "voiceWidth:%s, duration:%s, offset:%s", new Object[] { Integer.valueOf(this.Rmg), Integer.valueOf(i), Integer.valueOf(j) });
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.RkX.getWidth(), this.Rmg }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(271083);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.aA(ChatFooter.this).getLayoutParams()).width = i;
          ChatFooter.aA(ChatFooter.this).requestLayout();
          AppMethodBeat.o(271083);
        }
      });
      localValueAnimator.start();
      if (paramInt < 10)
      {
        hmd();
        continue;
        if (paramInt < 10) {
          hme();
        }
      }
    }
  }
  
  private void tV(boolean paramBoolean)
  {
    AppMethodBeat.i(31584);
    this.jJo = paramBoolean;
    if (this.Rkm == null)
    {
      this.Rkm = AnimationUtils.loadAnimation(getContext(), R.a.pop_in);
      this.Rkm.setDuration(150L);
    }
    if (this.Rkn == null)
    {
      this.Rkn = AnimationUtils.loadAnimation(getContext(), R.a.pop_out);
      this.Rkn.setDuration(150L);
    }
    if ((this.jLo == null) || (this.Rjb == null))
    {
      Log.i("MicroMsg.ChatFooter", "canSend:%B, return sendBtn == null || mAttachButton == null", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31584);
      return;
    }
    if (this.Rkj)
    {
      if (this.Rjb.getVisibility() != 0) {
        this.Rjb.setVisibility(0);
      }
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.jLo.getVisibility() == 0) && (paramBoolean))
    {
      Log.i("MicroMsg.ChatFooter", "canSend true ! sendBtn is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.Rjb.getVisibility() == 0) && (!paramBoolean))
    {
      Log.i("MicroMsg.ChatFooter", "canSend false ! AttachButton is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if (paramBoolean)
    {
      hlU();
      this.Rjb.startAnimation(this.Rkn);
      this.Rjb.setVisibility(8);
      Es(false);
    }
    for (;;)
    {
      Log.i("MicroMsg.ChatFooter", "jacks canSend:%B", new Object[] { Boolean.valueOf(paramBoolean) });
      this.jLo.getParent().requestLayout();
      AppMethodBeat.o(31584);
      return;
      this.Rjb.startAnimation(this.Rkm);
      if ((!this.Rjv) && (!this.RjK))
      {
        this.Rjb.setVisibility(0);
        Es(true);
      }
      hlT();
    }
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(31670);
    Log.i("MicroMsg.ChatFooter", "onKeyboardHeightChanged: %s, %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(this.RjP) });
    if (!this.RjS)
    {
      AppMethodBeat.o(31670);
      return;
    }
    Object localObject = this.KQB;
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.widget.cedit.api.c)localObject).Hm(bool);
      if (!this.RjT)
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
        if (((diw)com.tencent.mm.plugin.secdata.ui.a.a.c(getContext(), 4, diw.class)).TQp != 1) {
          break label149;
        }
      }
      if (paramInt > 0) {
        break;
      }
      this.BSf = false;
      AppMethodBeat.o(31670);
      return;
    }
    this.BSf = true;
    AppMethodBeat.o(31670);
    return;
    label149:
    if (com.tencent.mm.ui.f.a.hWR())
    {
      if (paramInt <= 0)
      {
        this.BSf = false;
        AppMethodBeat.o(31670);
        return;
      }
      this.BSf = true;
      AppMethodBeat.o(31670);
      return;
    }
    int i;
    if ((this.RkS) && (this.RkU != null) && (this.RkU.isShowing()))
    {
      if ((paramInt <= 0) || (u.kL(getContext())))
      {
        this.BSf = false;
        if (u.kL(getContext())) {
          this.BSf = true;
        }
        this.RkY.setCursorVisible(false);
        this.Rli.animate().translationY(0.0F).setDuration(200L).start();
        this.RkX.animate().translationY(0.0F).setDuration(200L).start();
        this.Rla.animate().translationY(0.0F).setDuration(200L).start();
        this.Rld.animate().translationY(0.0F).setDuration(200L).start();
        if (this.RkX.getHeight() < this.Rmf)
        {
          localObject = ValueAnimator.ofInt(new int[] { this.RkX.getHeight(), this.Rmf }).setDuration(200L);
          ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              AppMethodBeat.i(271217);
              int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
              ((ViewGroup.MarginLayoutParams)ChatFooter.aA(ChatFooter.this).getLayoutParams()).height = i;
              ChatFooter.aA(ChatFooter.this).requestLayout();
              AppMethodBeat.o(271217);
            }
          });
          ((ValueAnimator)localObject).start();
          AppMethodBeat.o(31670);
        }
      }
      else
      {
        this.BSf = true;
        this.RkY.setCursorVisible(true);
        Log.d("MicroMsg.ChatFooter", "height:%s, WeUIToolHelper.getDisplayRealSize(getContext()).y - newVoice2txtOpeArea.getBottom():%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.ui.ax.au(getContext()).y - this.Rli.getBottom()) });
        i = com.tencent.mm.ui.ax.au(getContext()).y;
        localObject = new int[2];
        this.Rli.getLocationOnScreen((int[])localObject);
        j = localObject[1];
        int k = this.Rli.getHeight();
        int m = com.tencent.mm.ui.ax.aB(getContext());
        this.Rli.animate().translationY(-(paramInt - (i - (j + k)) + m)).setDuration(200L).start();
        paramInt = i - (this.Rli.getHeight() + paramInt) - aw.fromDPToPix(getContext(), 24);
        i = this.RkX.getHeight() + this.Rla.getHeight() + aw.fromDPToPix(getContext(), 48);
        Log.d("MicroMsg.ChatFooter", "leftSpcaeDown:%s, editDown:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        this.Rme = (paramInt - aw.fromDPToPix(getContext(), 52));
        if (this.Rme < this.RlX)
        {
          Log.i("MicroMsg.ChatFooter", "invalid maxHeightWhenKeyboard, value:%s", new Object[] { Integer.valueOf(this.Rme) });
          this.Rme = this.RlX;
        }
        this.Rmf = this.RkX.getHeight();
        localObject = new int[2];
        this.Rla.getLocationOnScreen((int[])localObject);
        j = localObject[1] + this.Rla.getHeight();
        if (j > paramInt)
        {
          j -= paramInt;
          if (i > paramInt)
          {
            k = this.RkX.getLayoutParams().height;
            localObject = ValueAnimator.ofInt(new int[] { k, k - (i - paramInt) }).setDuration(200L);
            ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
              {
                AppMethodBeat.i(288350);
                int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
                ChatFooter.aA(ChatFooter.this).getLayoutParams().height = i;
                ChatFooter.aA(ChatFooter.this).requestLayout();
                AppMethodBeat.o(288350);
              }
            });
            ((ValueAnimator)localObject).start();
          }
          this.RkX.animate().translationY(-j).setDuration(200L).start();
          this.Rla.animate().translationY(-j).setDuration(200L).start();
          this.Rld.animate().translationY(-j).setDuration(200L).start();
        }
      }
      AppMethodBeat.o(31670);
      return;
    }
    if ((!this.RjR) && (this.RjL))
    {
      if (this.RjV == paramBoolean) {
        break label972;
      }
      i = 1;
      this.RjV = paramBoolean;
      if (paramInt <= 0) {
        break label1032;
      }
      if (this.pIk == paramInt) {
        break label1104;
      }
      this.pIk = paramInt;
      com.tencent.mm.compatible.util.i.E(getContext(), paramInt);
      aqE(paramInt);
    }
    label972:
    label1104:
    for (paramInt = 1;; paramInt = 0)
    {
      if (!this.BSf)
      {
        l(1, true, -1);
        this.RjM = -1;
      }
      while ((paramInt == 0) && (i == 0))
      {
        this.BSf = true;
        if (this.Rjq != null) {
          this.Rjq.ua(this.BSf);
        }
        AppMethodBeat.o(31670);
        return;
        i = 0;
        break;
      }
      this.RjQ = this.pIk;
      i = this.RjQ;
      if (this.Rkc == null) {}
      for (paramInt = j;; paramInt = this.Rkc.eBE())
      {
        b(i, true, 1, paramInt);
        break;
      }
      if (this.BSf)
      {
        if (this.RjM == -1) {
          break label1094;
        }
        l(this.RjM, true, -1);
        this.RjM = -1;
      }
      for (;;)
      {
        if (this.jJL == 1)
        {
          Log.i("MicroMsg.ChatFooter", "keyboard not open");
          l(0, true, -1);
        }
        this.BSf = false;
        break;
        l(0, true, -1);
      }
    }
  }
  
  public final void D(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(31607);
    if (eBC())
    {
      Log.i("MicroMsg.ChatFooter", "setLastText() isBackFromGroupSolitatire");
      AppMethodBeat.o(31607);
      return;
    }
    if ((paramBoolean) && ((paramString == null) || (paramString.length() == 0) || (this.KQB == null)))
    {
      this.KQB.setText("");
      hlf();
      AppMethodBeat.o(31607);
      return;
    }
    this.Rju = true;
    this.KQB.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), paramString, this.KQB.getTextSize()));
    this.Rju = false;
    if ((paramInt < 0) || (paramInt > this.KQB.getText().length()))
    {
      this.KQB.setSelection(this.KQB.getText().length());
      AppMethodBeat.o(31607);
      return;
    }
    this.KQB.setSelection(paramInt);
    AppMethodBeat.o(31607);
  }
  
  public final void Ed(boolean paramBoolean)
  {
    AppMethodBeat.i(31633);
    this.RiU.Ed(paramBoolean);
    AppMethodBeat.o(31633);
  }
  
  public final void Ee(boolean paramBoolean)
  {
    AppMethodBeat.i(31634);
    this.RiU.Ee(paramBoolean);
    AppMethodBeat.o(31634);
  }
  
  public final void En(boolean paramBoolean)
  {
    AppMethodBeat.i(31588);
    Log.i("MicroMsg.ChatFooter", "pureForcusEdtChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.KQB });
    if (this.KQB == null)
    {
      AppMethodBeat.o(31588);
      return;
    }
    if (paramBoolean)
    {
      this.KQB.hZB();
      AppMethodBeat.o(31588);
      return;
    }
    this.KQB.clearFocus();
    AppMethodBeat.o(31588);
  }
  
  public final void Ep(boolean paramBoolean)
  {
    AppMethodBeat.i(31654);
    Log.i("MicroMsg.ChatFooter", "withoutLastText: ");
    hideVKB();
    hlk();
    En(paramBoolean);
    AppMethodBeat.o(31654);
  }
  
  public final void Eq(boolean paramBoolean)
  {
    AppMethodBeat.i(293348);
    k(0, paramBoolean, -1);
    AppMethodBeat.o(293348);
  }
  
  public final void Es(boolean paramBoolean)
  {
    AppMethodBeat.i(163220);
    if (this.Rjb == null)
    {
      Log.e("MicroMsg.ChatFooter", "mAttachButton is null");
      AppMethodBeat.o(163220);
      return;
    }
    if (this.Rjc != null) {
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
        } while ((locala.red_dot != 1) || (bru(locala.RiB)));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.Rjc.setVisibility(0);
        AppMethodBeat.o(163220);
        return;
      }
      this.Rjc.setVisibility(8);
      AppMethodBeat.o(163220);
      return;
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean1, com.tencent.mm.modelvoiceaddr.h paramh, boolean paramBoolean2)
  {
    AppMethodBeat.i(185826);
    Log.d("MicroMsg.ChatFooter", "startTrans, hasStartTrans: %s, isForce: %s.", new Object[] { Boolean.valueOf(this.RmJ), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean2) {
      if (this.RmJ)
      {
        if (this.NiX != null) {
          this.NiX.aM(false, true);
        }
        this.Njh.removeMessages(5000);
        this.Nje.stopTimer();
      }
    }
    while (!this.RmJ)
    {
      this.RmJ = true;
      this.NiX = new com.tencent.mm.plugin.transvoice.a.b(paramh, paramInt, new g.b()
      {
        public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(279868);
          Log.d("MicroMsg.ChatFooter", "newVoice2txt onRes, %s.", new Object[] { ChatFooter.this.NiX });
          ChatFooter.bB(ChatFooter.this).clear();
          if (!Util.isNullOrNil(paramAnonymousList)) {
            ChatFooter.bB(ChatFooter.this).addAll(paramAnonymousList);
          }
          if (!ChatFooter.aS(ChatFooter.this))
          {
            ChatFooter.h(ChatFooter.this, true);
            ChatFooter.aB(ChatFooter.this).setFocusable(true);
            ChatFooter.aB(ChatFooter.this).setFocusableInTouchMode(true);
            ChatFooter.aB(ChatFooter.this).requestFocus();
          }
          if ((ChatFooter.this.NiX != null) && (!ChatFooter.this.NiX.NgY))
          {
            ChatFooter.bC(ChatFooter.this).removeMessages(5000);
            ChatFooter.bC(ChatFooter.this).sendEmptyMessageDelayed(5000, 5000L);
          }
          if (!Util.isNullOrNil(paramAnonymousArrayOfString[0]))
          {
            ChatFooter.aM(ChatFooter.this).put(Integer.valueOf(ChatFooter.aL(ChatFooter.this)), paramAnonymousArrayOfString[0]);
            if (ChatFooter.aM(ChatFooter.this) != null) {
              ChatFooter.D(ChatFooter.this).Nho = paramAnonymousArrayOfString[0].length();
            }
            Log.d("MicroMsg.ChatFooter", "newVoice2txt onRes, curTxt: %s.", new Object[] { paramAnonymousArrayOfString[0] });
          }
          AppMethodBeat.o(279868);
        }
        
        public final void brT()
        {
          AppMethodBeat.i(279870);
          Log.d("MicroMsg.ChatFooter", "onRecordFin.");
          AppMethodBeat.o(279870);
        }
        
        public final void brX()
        {
          AppMethodBeat.i(279871);
          if ((ChatFooter.this.NiX != null) && (!ChatFooter.this.NiX.NgY))
          {
            Log.d("MicroMsg.ChatFooter", "onRecognizeFinish, %s.", new Object[] { Boolean.valueOf(ChatFooter.this.NiX.NgY) });
            ChatFooter.D(ChatFooter.this).Nhr = 1;
            ChatFooter.D(ChatFooter.this).Nhn = System.currentTimeMillis();
            ChatFooter.h(ChatFooter.this, false);
            ChatFooter.aU(ChatFooter.this);
            ChatFooter.this.NiX = null;
            ChatFooter.bC(ChatFooter.this).removeMessages(5000);
            ChatFooter.aT(ChatFooter.this).stopTimer();
            ChatFooter.aN(ChatFooter.this);
          }
          AppMethodBeat.o(279871);
        }
        
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
        {
          AppMethodBeat.i(279869);
          Log.d("MicroMsg.ChatFooter", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong) });
          ChatFooter.D(ChatFooter.this).Nhr = 0;
          ChatFooter.D(ChatFooter.this).Nhn = System.currentTimeMillis();
          ChatFooter.aU(ChatFooter.this);
          AppMethodBeat.o(279869);
        }
      });
      this.NiX.NgY = paramBoolean1;
      this.NiX.start();
      this.Nje.startTimer(500L);
      AppMethodBeat.o(185826);
      return;
    }
    AppMethodBeat.o(185826);
  }
  
  public final void a(Context paramContext, Activity paramActivity)
  {
    boolean bool2 = true;
    AppMethodBeat.i(31575);
    Log.i("MicroMsg.ChatFooter", "onResume: %s, %s", new Object[] { Boolean.valueOf(KeyBoardUtil.isPortOrientation(paramContext)), Integer.valueOf(getContext().getResources().getConfiguration().orientation) });
    this.zQA = true;
    this.activity = paramActivity;
    if ((this.RjP == 48) && (this.jJL == 1) && (!this.Rka))
    {
      this.BSf = false;
      l(0, false, -1);
    }
    boolean bool1 = bool2;
    if (getContext().getResources().getConfiguration().orientation != 1)
    {
      if (KeyBoardUtil.isPortOrientation(paramContext)) {
        bool1 = bool2;
      }
    }
    else
    {
      this.RjL = bool1;
      if (com.tencent.mm.compatible.util.d.qV(24)) {
        this.RjR = ((Activity)getContext()).isInMultiWindowMode();
      }
      hlM();
      hlR();
      if (ap.hhK().QXL) {
        ap.hhK().jx(MMApplicationContext.getContext());
      }
      if ((!this.RiZ.hmq()) && (this.jPN != null)) {
        this.jPN.onResume();
      }
      if ((this.Rkj) || (!this.RjI)) {
        break label332;
      }
      hlG();
    }
    for (;;)
    {
      aqE(getKeyBordHeightPX());
      if (this.RiU != null) {
        this.RiU.context = paramContext;
      }
      this.Rjn.RnV = false;
      if (!this.RdY) {
        hlF();
      }
      hlj();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184931);
          com.tencent.mm.compatible.util.i.u(ChatFooter.e(ChatFooter.this));
          AppMethodBeat.o(184931);
        }
      });
      if ((this.RjN != null) && (this.Rkl != null)) {
        this.RjN.a((ChattingScrollLayout.a)this.Rkl.hmp().bC(com.tencent.mm.ui.chatting.d.b.r.class));
      }
      AppMethodBeat.o(31575);
      return;
      bool1 = false;
      break;
      label332:
      if ((this.Rkj) && (!this.RjI)) {
        hlE();
      }
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(31574);
    this.Rkl = paramb;
    this.Rjp = new com.tencent.mm.plugin.groupsolitaire.ui.d(getContext(), this.Rkl.hmo(), new d.d()
    {
      public final void aLh(String paramAnonymousString)
      {
        AppMethodBeat.i(273668);
        if ((ChatFooter.l(ChatFooter.this) != null) && (!Util.isNullOrNil(paramAnonymousString))) {
          ChatFooter.l(ChatFooter.this).aLh(paramAnonymousString);
        }
        AppMethodBeat.o(273668);
      }
      
      public final void eBG()
      {
        AppMethodBeat.i(273667);
        ChatFooter.this.eBG();
        ChatFooter.this.hlh();
        AppMethodBeat.o(273667);
      }
    });
    this.Rjp.DqT = this.Rke;
    AppMethodBeat.o(31574);
  }
  
  public final void a(final h paramh)
  {
    AppMethodBeat.i(185822);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185794);
        ChatFooter.B(ChatFooter.this).setBackgroundResource(R.g.input_bg);
        ChatFooter.B(ChatFooter.this).setText(R.l.chatfooter_presstorcd);
        if (ChatFooter.this.RkS)
        {
          switch (ChatFooter.85.RmV[paramh.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(185794);
            return;
            if (ChatFooter.G(ChatFooter.this) != null) {
              ChatFooter.L(ChatFooter.this);
            }
          }
        }
        if (ChatFooter.M(ChatFooter.this) != null)
        {
          ChatFooter.M(ChatFooter.this).dismiss();
          if (ChatFooter.N(ChatFooter.this) != null) {
            ChatFooter.N(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(300L).withEndAction(ChatFooter.bi(ChatFooter.this)).start();
          }
          ChatFooter.bj(ChatFooter.this).setVisibility(0);
          ChatFooter.bk(ChatFooter.this).setVisibility(8);
          ChatFooter.bl(ChatFooter.this).setVisibility(8);
          ChatFooter.as(ChatFooter.this).setVisibility(8);
          ChatFooter.Y(ChatFooter.this).setVisibility(8);
          ChatFooter.ar(ChatFooter.this).setVisibility(0);
        }
        ChatFooter.g(ChatFooter.this, false);
        ChatFooter.f(ChatFooter.this, false);
        AppMethodBeat.o(185794);
      }
    });
    AppMethodBeat.o(185822);
  }
  
  public final void a(ccn paramccn) {}
  
  public final void a(String paramString, Boolean paramBoolean, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(285145);
    if (paramBoolean.booleanValue()) {
      a.b.d(this.Rjz, paramString);
    }
    for (;;)
    {
      setHint(paramCharSequence);
      this.Rjz.setVisibility(0);
      AppMethodBeat.o(285145);
      return;
      a.b.c(this.Rjz, paramString);
    }
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(31615);
    this.RlK = new i(paramTextWatcher);
    this.KQB.addTextChangedListener(this.RlK);
    AppMethodBeat.o(31615);
  }
  
  public final void aqA(int paramInt)
  {
    AppMethodBeat.i(31622);
    if (this.RkS)
    {
      if ((this.RkZ != null) && (this.RkZ.getVisibility() == 0)) {
        this.RkZ.ajY(paramInt);
      }
      AppMethodBeat.o(31622);
      return;
    }
    if (this.RjG)
    {
      i = 0;
      for (;;)
      {
        if (i < Rmj.length)
        {
          if ((paramInt >= Rmi[i]) && (paramInt < Rmi[(i + 1)])) {
            this.Rku.setBackgroundDrawable(com.tencent.mm.ci.a.m(getContext(), Rmj[i]));
          }
        }
        else
        {
          if ((paramInt != -1) || (this.MkT == null)) {
            break;
          }
          this.MkT.dismiss();
          this.MkW.setVisibility(0);
          this.RjB.setVisibility(8);
          this.wLn.setVisibility(8);
          AppMethodBeat.o(31622);
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < Rmj.length)
      {
        if ((paramInt >= Rmi[i]) && (paramInt < Rmi[(i + 1)])) {
          this.wLo.setBackgroundDrawable(com.tencent.mm.ci.a.m(getContext(), Rmj[i]));
        }
      }
      else
      {
        if ((paramInt == -1) && (this.MkT != null))
        {
          this.MkT.dismiss();
          this.MkW.setVisibility(0);
          this.RjB.setVisibility(8);
          this.wLn.setVisibility(8);
        }
        AppMethodBeat.o(31622);
        return;
      }
      i += 1;
    }
  }
  
  public final void aqB(int paramInt)
  {
    AppMethodBeat.i(31624);
    this.RjF = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31624);
      return;
      Eo(true);
      this.RiW.setVisibility(8);
      aqy(R.g.dnf);
      AppMethodBeat.o(31624);
      return;
      Eo(false);
      this.RiW.setVisibility(0);
      hlO();
      aqy(R.g.chatting_setmode_keyboard_btn);
      if ((z.bdS().booleanValue()) && (this.Rkg != null))
      {
        c localc = this.Rkg;
        Boolean localBoolean = Boolean.TRUE;
        localc.b(localBoolean, localBoolean);
      }
    }
  }
  
  public final void aqC(int paramInt)
  {
    AppMethodBeat.i(185823);
    b(paramInt, true, 0, 0);
    AppMethodBeat.o(185823);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void aqz(int paramInt)
  {
    AppMethodBeat.i(31616);
    Object localObject1;
    if (this.RkS)
    {
      if (this.RkU == null)
      {
        this.RkU = new com.tencent.mm.ui.base.r(View.inflate(getContext(), R.i.dOM, null), -1, -1, true);
        this.RkU.setSoftInputMode(16);
        this.RkU.setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(286311);
            if ((ChatFooter.this.RmG == ChatFooter.e.Rne) && (ChatFooter.aJ(ChatFooter.this)))
            {
              Log.i("MicroMsg.ChatFooter", "dismiss from keyback, need cancelRecording");
              ChatFooter.D(ChatFooter.this).setExitType(6);
              ChatFooter.l(ChatFooter.this).eRt();
            }
            ChatFooter.aK(ChatFooter.this);
            ChatFooter.f(ChatFooter.this, 0);
            AppMethodBeat.o(286311);
          }
        });
        this.RkV = this.RkU.getContentView().findViewById(R.h.dOQ);
        this.RkW = this.RkU.getContentView().findViewById(R.h.dPd);
        this.RkX = ((ViewGroup)this.RkU.getContentView().findViewById(R.h.dOM));
        this.RkZ = ((SoundWaveView)this.RkU.getContentView().findViewById(R.h.dOS));
        this.RkY = ((EditText)this.RkU.getContentView().findViewById(R.h.dOK));
        this.Rla = ((ImageView)this.RkU.getContentView().findViewById(R.h.dOJ));
        this.Rlb = ((ViewGroup)this.RkU.getContentView().findViewById(R.h.dOR));
        this.Rlc = ((TextView)this.RkU.getContentView().findViewById(R.h.dOI));
        this.Rld = ((WeImageView)this.RkU.getContentView().findViewById(R.h.dON));
        this.Rle = ((LanguageChoiceLayout)this.RkU.getContentView().findViewById(R.h.dOX));
        this.Rlf = ((TextView)this.RkU.getContentView().findViewById(R.h.dOO));
        this.Rlg = ((ViewGroup)this.RkU.getContentView().findViewById(R.h.dOT));
        this.Rlh = ((TextView)this.RkU.getContentView().findViewById(R.h.dOL));
        this.Rle.setSelectLanguageListener(new LanguageChoiceLayout.a()
        {
          public final void ajX(int paramAnonymousInt)
          {
            AppMethodBeat.i(291529);
            ChatFooter.g(ChatFooter.this, paramAnonymousInt);
            if (Util.isNullOrNil((String)ChatFooter.aM(ChatFooter.this).get(Integer.valueOf(ChatFooter.aL(ChatFooter.this)))))
            {
              long l2 = System.nanoTime() | 0xFFFFFFFF;
              long l1 = l2;
              if (l2 < 0L) {
                l1 = Math.abs(l2);
              }
              com.tencent.mm.modelvoiceaddr.h localh = new com.tencent.mm.modelvoiceaddr.h(String.valueOf(l1));
              ChatFooter.E(ChatFooter.this).a(localh);
              ChatFooter.this.getContext().getSharedPreferences("voice2txt_sp", 0).edit().putInt(ChatFooter.r(ChatFooter.this), ChatFooter.aL(ChatFooter.this)).apply();
              ChatFooter.this.a(ChatFooter.aL(ChatFooter.this), false, localh, true);
            }
            for (;;)
            {
              ChatFooter.D(ChatFooter.this).Nhj = System.currentTimeMillis();
              ChatFooter.D(ChatFooter.this).Nhm = 0;
              ChatFooter.D(ChatFooter.this).Nhn = 0L;
              ChatFooter.D(ChatFooter.this).Nho = 0;
              ChatFooter.D(ChatFooter.this).Nhr = 0;
              ChatFooter.D(ChatFooter.this).Nhs = 0;
              ChatFooter.D(ChatFooter.this).Nht = 0;
              AppMethodBeat.o(291529);
              return;
              ChatFooter.aN(ChatFooter.this);
            }
          }
        });
        this.Rld.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(286224);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (ChatFooter.aO(ChatFooter.this)) {
              ChatFooter.aP(ChatFooter.this).hideSoftInputFromWindow(ChatFooter.aB(ChatFooter.this).getWindowToken(), 0);
            }
            paramAnonymousView = ChatFooter.aQ(ChatFooter.this);
            int i = ChatFooter.aL(ChatFooter.this);
            paramAnonymousView.setVisibility(0);
            paramAnonymousView.kGW.post(new LanguageChoiceLayout.4(paramAnonymousView, i));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(286224);
          }
        });
        this.RkY.setMaxLines(2147483647);
        this.RkY.setHorizontallyScrolling(false);
        this.RkY.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(268725);
            if ((4 == paramAnonymousInt) || (66 == paramAnonymousKeyEvent.getAction()))
            {
              paramAnonymousTextView = ChatFooter.aB(ChatFooter.this).getText().toString();
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                if (!Util.isNullOrNil(paramAnonymousTextView)) {
                  ChatFooter.l(ChatFooter.this).aNX(paramAnonymousTextView);
                }
                ChatFooter.l(ChatFooter.this).eRt();
              }
              AppMethodBeat.o(268725);
              return true;
            }
            AppMethodBeat.o(268725);
            return false;
          }
        });
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185357);
            ChatFooter.aR(ChatFooter.this);
            AppMethodBeat.o(185357);
          }
        });
        this.RkY.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(291594);
            if (ChatFooter.aS(ChatFooter.this))
            {
              ChatFooter.h(ChatFooter.this, false);
              if (ChatFooter.this.NiX != null) {
                ChatFooter.this.NiX.aM(false, true);
              }
              ChatFooter.aT(ChatFooter.this).stopTimer();
              ChatFooter.aB(ChatFooter.this).setText((CharSequence)ChatFooter.aM(ChatFooter.this).get(Integer.valueOf(ChatFooter.aL(ChatFooter.this))));
              ChatFooter.D(ChatFooter.this).Nhr = 0;
              ChatFooter.D(ChatFooter.this).Nhn = System.currentTimeMillis();
              ChatFooter.aU(ChatFooter.this);
            }
            ChatFooter.D(ChatFooter.this).Nht = 1;
            AppMethodBeat.o(291594);
            return false;
          }
        });
        this.Rli = ((ViewGroup)this.RkU.getContentView().findViewById(R.h.dOP));
        this.Rlj = ((ViewGroup)this.RkU.getContentView().findViewById(R.h.dPg));
        this.Rlk = this.RkU.getContentView().findViewById(R.h.dOF);
        this.Rll = this.RkU.getContentView().findViewById(R.h.dPe);
        this.Rlm = ((WeImageView)this.RkU.getContentView().findViewById(R.h.dOG));
        this.Rln = ((WeImageView)this.RkU.getContentView().findViewById(R.h.dPf));
        this.Rlo = this.RkU.getContentView().findViewById(R.h.dOH);
        this.Rlp = this.RkU.getContentView().findViewById(R.h.dPi);
        this.Rlq = ((ViewGroup)this.RkU.getContentView().findViewById(R.h.dPh));
        this.Rlr = this.RkU.getContentView().findViewById(R.h.dOV);
        this.Rlr.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(266617);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            ChatFooter.aV(ChatFooter.this);
            ChatFooter.D(ChatFooter.this).setExitType(6);
            ChatFooter.l(ChatFooter.this).eRt();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(266617);
          }
        });
        this.Rls = this.RkU.getContentView().findViewById(R.h.dPb);
        this.Rls.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185360);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (ChatFooter.l(ChatFooter.this) != null)
            {
              ChatFooter.aV(ChatFooter.this);
              ChatFooter.D(ChatFooter.this).setExitType(7);
              ChatFooter.l(ChatFooter.this).eV(ChatFooter.l(ChatFooter.this).getFileName(), ChatFooter.aW(ChatFooter.this));
              ChatFooter.L(ChatFooter.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(185360);
          }
        });
        this.Rlv = this.RkU.getContentView().findViewById(R.h.dOY);
        this.Rlv.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185793);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$48", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if ((ChatFooter.aX(ChatFooter.this).getVisibility() == 0) && (8 == ChatFooter.aY(ChatFooter.this).getVisibility()))
            {
              paramAnonymousView = ChatFooter.aB(ChatFooter.this).getText().toString();
              if ((ChatFooter.l(ChatFooter.this) != null) && (!Util.isNullOrNil(paramAnonymousView)))
              {
                ChatFooter.aV(ChatFooter.this);
                ChatFooter.D(ChatFooter.this).Nhl = ChatFooter.aL(ChatFooter.this);
                ChatFooter.D(ChatFooter.this).Nhp = paramAnonymousView.length();
                if (1 != ChatFooter.D(ChatFooter.this).Nhs) {
                  break label210;
                }
                ChatFooter.D(ChatFooter.this).setExitType(8);
              }
            }
            for (;;)
            {
              ChatFooter.l(ChatFooter.this).aNX(paramAnonymousView);
              ChatFooter.l(ChatFooter.this).eRt();
              ChatFooter.d(ChatFooter.this, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$48", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(185793);
              return;
              label210:
              ChatFooter.D(ChatFooter.this).setExitType(5);
            }
          }
        });
        this.Rlt = ((WeImageView)this.RkU.getContentView().findViewById(R.h.dOW));
        this.Rlu = ((WeImageView)this.RkU.getContentView().findViewById(R.h.dPc));
        this.Rlw = this.RkU.getContentView().findViewById(R.h.dPa);
        this.Rlx = ((WeImageView)this.RkU.getContentView().findViewById(R.h.dOZ));
        this.Rly = ((ViewGroup)this.RkU.getContentView().findViewById(R.h.dPj));
        this.Rlz = this.RkU.getContentView().findViewById(R.h.dPl);
        this.RlA = this.RkU.getContentView().findViewById(R.h.dPn);
        this.RlB = this.RkU.getContentView().findViewById(R.h.dPm);
        this.RlC = ((WeImageView)this.RkU.getContentView().findViewById(R.h.dPk));
        localObject1 = (RelativeLayout.LayoutParams)this.Rly.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).height = (getContext().getResources().getDimensionPixelSize(R.f.dlP) + ay.aB(getContext()));
        this.Rly.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (FrameLayout.LayoutParams)this.RlC.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (ay.aB(getContext()) + aw.fromDPToPix(getContext(), 14));
        this.RlC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.Nje = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(290676);
            int i = ChatFooter.aZ(ChatFooter.this);
            ChatFooter.ba(ChatFooter.this);
            switch (i % 3)
            {
            }
            for (;;)
            {
              ChatFooter.bb(ChatFooter.this);
              AppMethodBeat.o(290676);
              return true;
              ChatFooter.e(ChatFooter.this, "·");
              continue;
              ChatFooter.e(ChatFooter.this, "··");
              continue;
              ChatFooter.e(ChatFooter.this, "···");
            }
          }
        }, true);
        this.Njh = new MMHandler(new MMHandler.Callback()
        {
          public final boolean handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(279448);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(279448);
              return true;
              ChatFooter.D(ChatFooter.this).Nhm = 1;
              ChatFooter.D(ChatFooter.this).Nhn = System.currentTimeMillis();
              ChatFooter.D(ChatFooter.this).Nhr = 0;
              ChatFooter.aT(ChatFooter.this).stopTimer();
              if (ChatFooter.this.NiX != null) {
                ChatFooter.this.NiX.aM(false, false);
              }
              if (!Util.isNullOrNil((String)ChatFooter.aM(ChatFooter.this).get(Integer.valueOf(ChatFooter.aL(ChatFooter.this)))))
              {
                ChatFooter.aB(ChatFooter.this).setFocusable(true);
                ChatFooter.aB(ChatFooter.this).setFocusableInTouchMode(true);
                ChatFooter.aB(ChatFooter.this).requestFocus();
              }
              ChatFooter.aN(ChatFooter.this);
              ChatFooter.aU(ChatFooter.this);
            }
          }
        });
        this.RlD = this.RkU.getContentView().findViewById(R.h.dOU);
        this.RkU.setClippingEnabled(false);
      }
      paramInt = getTransLangTypeByTalker();
      if (com.tencent.mm.modelvoiceaddr.g.mlS == paramInt)
      {
        this.NgX = com.tencent.mm.modelvoiceaddr.g.mlT;
        if (this.Rle != null) {
          this.Rle.setSelectedLang(this.NgX);
        }
        Log.d("MicroMsg.ChatFooter", "curTxt:%s", new Object[] { Integer.valueOf(this.RmI.size()) });
        if ((com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VCW, true)) || (!com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VCX, true))) {
          break label1675;
        }
        this.Rlh.setTranslationY(aw.fromDPToPix(getContext(), 12));
        this.Rlh.setVisibility(0);
        this.Rlh.setAlpha(0.0F);
        this.Rlh.setText(getContext().getResources().getString(R.l.eMC));
        this.Rlh.animate().alpha(1.0F).translationY(0.0F).setDuration(1000L).setStartDelay(500L).start();
        label1180:
        this.RkX.setTranslationY(0.0F);
        this.Rla.setTranslationY(0.0F);
        this.Rld.setTranslationY(0.0F);
        this.Rli.setTranslationY(0.0F);
        paramInt = aw.fromDPToPix(getContext(), 20);
        this.RkY.setPadding(paramInt, paramInt, paramInt, 0);
        this.RkY.addTextChangedListener(this.RlO);
        this.RkY.setVisibility(8);
        this.RkY.setCursorVisible(false);
        this.RkZ.setVisibility(0);
        this.Rlf.setVisibility(8);
        this.Rlv.setEnabled(true);
        this.RkX.setActivated(true);
        this.Rlx.setImageDrawable(au.o(getContext(), R.k.icons_filled_done, getContext().getResources().getColor(R.e.Brand)));
        this.Rla.setImageDrawable(au.o(getContext(), R.k.icons_filled_voice2txt_cursor, getContext().getResources().getColor(R.e.LightGreen)));
        localObject1 = (FrameLayout.LayoutParams)this.Rlz.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = aw.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = aw.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = aw.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = aw.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = aw.fromDPToPix(getContext(), 8);
        this.Rlz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.Rlz.setAlpha(0.0F);
        localObject1 = (FrameLayout.LayoutParams)this.RlA.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = aw.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = aw.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = aw.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = aw.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = aw.fromDPToPix(getContext(), 8);
        this.RlA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.RlA.setAlpha(0.0F);
        this.Rlj.setTranslationY(this.RmF);
        this.Rlj.setAlpha(0.0F);
        this.RkZ.setVisibility(8);
        this.RlD.setVisibility(0);
        if (!com.tencent.mm.ui.ar.isDarkMode()) {
          break label1759;
        }
        this.RkW.setBackground(getContext().getResources().getDrawable(R.g.doh));
      }
      for (;;)
      {
        this.Rms = false;
        this.RkU.showAtLocation(this, 49, 0, 0);
        hlo();
        this.Rld.setVisibility(8);
        post(new Runnable()
        {
          public final void run()
          {
            int i = 1;
            AppMethodBeat.i(31552);
            ChatFooter.bc(ChatFooter.this);
            if (ChatFooter.bd(ChatFooter.this) != null)
            {
              ChattingScrollLayout localChattingScrollLayout = ChatFooter.bd(ChatFooter.this);
              int j = ChatFooter.be(ChatFooter.this).getHeight();
              int k = ChatFooter.bf(ChatFooter.this).getHeight();
              int m = com.tencent.mm.ui.ax.aB(ChatFooter.this.getContext());
              int n = ChatFooter.a(ChatFooter.this).getHeight();
              if ((localChattingScrollLayout.RnK == null) || (localChattingScrollLayout.RnK.getListView() == null)) {
                break label317;
              }
              int i1 = localChattingScrollLayout.RnK.getListView().getFirstVisiblePosition();
              int i2 = localChattingScrollLayout.RnK.getListView().getHeaderViewsCount();
              i1 = localChattingScrollLayout.RnK.getListView().getLastVisiblePosition() - localChattingScrollLayout.RnK.getListView().getHeaderViewsCount() - (i1 - i2);
              if ((i1 < 0) || (i1 >= localChattingScrollLayout.RnK.getListView().getChildCount())) {
                break label317;
              }
              View localView = localChattingScrollLayout.RnK.getListView().getChildAt(i1);
              if (localView == null) {
                break label317;
              }
              int[] arrayOfInt = new int[2];
              localView.getLocationOnScreen(arrayOfInt);
              i1 = arrayOfInt[1];
              if (localView.getHeight() + i1 <= com.tencent.mm.ui.ax.au(localChattingScrollLayout.getContext()).y - (j + k - m - n)) {
                break label317;
              }
            }
            for (;;)
            {
              if (i != 0)
              {
                ChatFooter.h(ChatFooter.this, ChatFooter.be(ChatFooter.this).getHeight() + ChatFooter.bf(ChatFooter.this).getHeight() - com.tencent.mm.ui.ax.aB(ChatFooter.this.getContext()) - ChatFooter.a(ChatFooter.this).getHeight());
                ChatFooter.f(ChatFooter.this, 4);
              }
              AppMethodBeat.o(31552);
              return;
              label317:
              i = 0;
            }
          }
        });
        AppMethodBeat.o(31616);
        return;
        this.NgX = paramInt;
        break;
        label1675:
        this.Rlh.setTranslationY(aw.fromDPToPix(getContext(), 30));
        this.Rlh.setVisibility(0);
        this.Rlh.setAlpha(0.0F);
        this.Rlh.setText(getContext().getResources().getString(R.l.eMD));
        this.Rlh.animate().alpha(1.0F).translationY(0.0F).setDuration(200L).setStartDelay(0L).start();
        break label1180;
        label1759:
        this.RkW.setBackground(getContext().getResources().getDrawable(R.g.doi));
      }
    }
    this.RlL = 0;
    int i;
    if (this.RjG) {
      i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 280);
    }
    for (;;)
    {
      int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 50.0F);
      if (paramInt + j < i)
      {
        this.RlL = -1;
        if (this.MkT == null)
        {
          this.MkT = new com.tencent.mm.ui.base.r(View.inflate(getContext(), R.i.elU, null), -1, -2);
          this.RjB = ((ViewGroup)this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_rcding));
          this.wLp = this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_anim_area);
          this.wLo = ((ImageView)this.MkT.getContentView().findViewById(R.h.eav));
          this.RjC = ((TextView)this.MkT.getContentView().findViewById(R.h.eaj));
          this.RjC.setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), R.f.dlE) * com.tencent.mm.ci.a.km(getContext()));
          this.wLq = this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_cancel_area);
          this.MkU = ((TextView)this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_cancel_text));
          this.MkU.setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), R.f.dlE) * com.tencent.mm.ci.a.km(getContext()));
          this.MkV = ((ImageView)this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_cancel_icon));
          this.MkW = this.MkT.getContentView().findViewById(R.h.eai);
          this.wLn = this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_tooshort);
          this.Rkp = ((ViewGroup)this.MkT.getContentView().findViewById(R.h.dZN));
          this.Rkq = this.MkT.getContentView().findViewById(R.h.dZH);
          this.Rkt = this.MkT.getContentView().findViewById(R.h.dZR);
          this.Rku = ((ImageView)this.MkT.getContentView().findViewById(R.h.dZS));
          this.Rkv = ((ImageView)this.MkT.getContentView().findViewById(R.h.dZG));
          this.Rkw = this.MkT.getContentView().findViewById(R.h.dZI);
          this.Rkx = ((TextView)this.MkT.getContentView().findViewById(R.h.dZL));
          this.Rky = ((ImageView)this.MkT.getContentView().findViewById(R.h.dZJ));
          this.Rkz = this.MkT.getContentView().findViewById(R.h.dZM);
          this.RkA = this.MkT.getContentView().findViewById(R.h.dZD);
          this.RkB = ((WeImageView)this.MkT.getContentView().findViewById(R.h.dZE));
          this.RkC = ((TextView)this.MkT.getContentView().findViewById(R.h.dZF));
          this.RkD = this.MkT.getContentView().findViewById(R.h.dZO);
          this.RkE = ((WeImageView)this.MkT.getContentView().findViewById(R.h.dZP));
          this.RkF = ((TextView)this.MkT.getContentView().findViewById(R.h.dZQ));
          this.RkG = View.inflate(getContext(), R.i.ehu, null);
        }
      }
      try
      {
        if (j.Rnq == this.RkO)
        {
          localObject1 = this.activity.getWindow().getDecorView();
          Drawable localDrawable = ((View)localObject1).getBackground();
          this.Rkr = new BlurView(getContext());
          paramInt = com.tencent.mm.ci.a.fromDPToPix(getContext(), 14);
          BlurView localBlurView = this.Rkr.T((ViewGroup)localObject1).auW(getResources().getColor(R.e.dkM)).L(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).cO(15.0F).hLz();
          localBlurView.zj = (paramInt * 1.0F);
          localBlurView.WvM = true;
          localBlurView.auX(this.RlL).hLA();
          this.RkH = new BlurView(getContext());
          this.RkH.auW(getResources().getColor(R.e.dkM));
          this.RkH.T((ViewGroup)localObject1).L(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).cO(15.0F).hLz().hLA();
        }
        Log.i("MicroMsg.ChatFooter", "transVoiceBlurMode: %s.", new Object[] { this.RkO });
        switch (85.RmT[this.RkO.ordinal()])
        {
        default: 
          this.RkL.setClippingEnabled(false);
          this.RkL.getContentView().setAlpha(0.0F);
          this.RkL.setOnDismissListener(new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(287528);
              ChatFooter.N(ChatFooter.this).getContentView().setAlpha(0.0F);
              AppMethodBeat.o(287528);
            }
          });
          ((TextView)this.MkT.getContentView().findViewById(R.h.dZK)).setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), R.f.dlO) * com.tencent.mm.ci.a.km(getContext()));
          hlp();
          if (this.RlL != -1)
          {
            this.wLn.setVisibility(8);
            this.RjB.setVisibility(8);
            this.MkW.setVisibility(0);
            new MMHandler().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(185363);
                if (ChatFooter.T(ChatFooter.this))
                {
                  ChatFooter.ar(ChatFooter.this).setVisibility(8);
                  ChatFooter.X(ChatFooter.this).setVisibility(0);
                  AppMethodBeat.o(185363);
                  return;
                }
                ChatFooter.ar(ChatFooter.this).setVisibility(0);
                ChatFooter.X(ChatFooter.this).setVisibility(8);
                AppMethodBeat.o(185363);
              }
            });
            if (this.RjG)
            {
              hlZ();
              this.RkR = false;
              hlW();
              this.RkL.showAtLocation(this, 49, 0, 0);
              this.RkQ = false;
              if (this.Rmq)
              {
                this.Rmq = false;
                if (j.Rnq != this.RkO) {
                  break label3133;
                }
                this.Rkr.auW(getResources().getColor(R.e.dkM)).L(this.activity.getWindow().getDecorView().getBackground()).Gd(true);
              }
            }
            this.MkT.showAtLocation(this, 49, 0, this.RlL);
          }
          else
          {
            AppMethodBeat.o(31616);
            return;
            i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 180);
            continue;
            this.RlL = ((paramInt - i) / 2 + j);
          }
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.RkO = j.Rnr;
          this.RlM = true;
          continue;
          this.Rkp.removeView(this.Rkq);
          Object localObject2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.f.dlN), getResources().getDimensionPixelSize(R.f.dlN));
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          this.Rkr.addView(this.Rkq, (ViewGroup.LayoutParams)localObject2);
          this.Rkp.addView(this.Rkr, (ViewGroup.LayoutParams)localObject2);
          this.Rks = this.Rkr;
          localObject2 = new FrameLayout.LayoutParams(-1, -1);
          this.RkH.addView(this.RkG, (ViewGroup.LayoutParams)localObject2);
          this.RkL = new com.tencent.mm.ui.base.r(this.RkH, -1, -1);
          continue;
          this.Rks = this.Rkq;
          this.Rks.setBackgroundResource(R.g.dpt);
          this.RkG.setBackgroundColor(getResources().getColor(R.e.dkN));
          this.RkL = new com.tencent.mm.ui.base.r(this.RkG, -1, -1);
          continue;
          label3133:
          this.Rks.setBackgroundResource(R.g.dpt);
        }
      }
    }
  }
  
  public final void bM(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(31625);
    aqB(paramInt);
    switch (paramInt)
    {
    default: 
      setVisibility(0);
      AppMethodBeat.o(31625);
      return;
    case 1: 
      if (paramBoolean)
      {
        Em(true);
        showVKB();
        if (this.KQB.length() > 0) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          tV(paramBoolean);
          AppMethodBeat.o(31625);
          return;
        }
      }
      if (this.KQB.length() > 0) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        tV(paramBoolean);
        AppMethodBeat.o(31625);
        return;
      }
    }
    k(0, true, -1);
    tV(false);
    AppMethodBeat.o(31625);
  }
  
  public final void be(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31602);
    if (this.Rjt.Rnb.containsKey(paramString1)) {}
    Object localObject;
    for (paramString1 = (LinkedList)this.Rjt.Rnb.get(paramString1);; paramString1 = (String)localObject)
    {
      localObject = new HashMap(1);
      ((HashMap)localObject).put(paramString3, paramString2);
      paramString1.add(localObject);
      AppMethodBeat.o(31602);
      return;
      localObject = new LinkedList();
      this.Rjt.Rnb.put(paramString1, localObject);
    }
  }
  
  public final void bj(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31632);
    this.RiU.Eb(paramBoolean1);
    this.RiU.Ec(paramBoolean2);
    AppMethodBeat.o(31632);
  }
  
  public final boolean bm(ca paramca)
  {
    AppMethodBeat.i(31678);
    if (this.Rjq != null) {
      this.Rjq.eRx();
    }
    this.Rjh.setTag(paramca);
    this.RjF = 1;
    Eo(true);
    this.RiW.setVisibility(8);
    aqy(R.g.dnf);
    if (this.RdV != null)
    {
      this.RdV.setVisibility(8);
      this.RdY = false;
      this.RdV.reset();
    }
    showVKB();
    Em(true);
    brt("");
    AppMethodBeat.o(31678);
    return true;
  }
  
  public final void brt(String paramString)
  {
    AppMethodBeat.i(31675);
    com.tencent.mm.plugin.groupsolitaire.ui.d locald;
    String str2;
    if ((this.Rjp != null) && (this.jLo != null) && (this.Rkl != null))
    {
      locald = this.Rjp;
      str2 = this.Rkl.getTalkerUserName();
      localObject = this.jLo;
      Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow supportAnalyze:%s supportShow:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aKT(str2)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aKU(str2)) });
      locald.DqU = ((View)localObject);
      locald.content = paramString;
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aKT(str2))
      {
        if ((Util.isNullOrNil(paramString)) || (paramString.equals(locald.DqJ))) {
          break label324;
        }
        com.tencent.e.h.ZvG.bDh("GroupSolitaireCheck");
      }
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.a.class)).atQ(paramString);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    locald.DqR.setContent(paramString);
    locald.DqR.aLg(locald.Dqm);
    com.tencent.e.h.ZvG.a(locald.DqR, 500L, "GroupSolitaireCheck");
    Object localObject = paramString;
    if (Util.isNullOrNil(locald.DqJ))
    {
      locald.DqS.setContent(paramString);
      locald.DqS.aLg(locald.Dqm);
      com.tencent.e.h.ZvG.a(locald.DqS, 500L, "GroupSolitaireCopyCheck");
      localObject = paramString;
    }
    for (;;)
    {
      locald.DqJ = ((String)localObject);
      locald.Dqm = str2;
      AppMethodBeat.o(31675);
      return;
      label324:
      String str1 = paramString;
      if (Util.isNullOrNil(paramString))
      {
        locald.eBD();
        str1 = paramString;
      }
    }
  }
  
  public final void cRI()
  {
    AppMethodBeat.i(31610);
    this.RkM.setExitType(1);
    this.RiW.setEnabled(false);
    this.RiW.setBackgroundResource(R.g.record_shape_disable);
    if (this.RkS)
    {
      this.RkU.update();
      this.urD.sendEmptyMessageDelayed(0, 500L);
      AppMethodBeat.o(31610);
      return;
    }
    if (this.MkT != null)
    {
      this.wLn.setVisibility(0);
      this.RjB.setVisibility(8);
      this.MkW.setVisibility(8);
      this.MkT.update();
      this.RkL.dismiss();
    }
    this.urD.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(31610);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31578);
    if (this.jPN != null)
    {
      Log.i("MicroMsg.ChatFooter", "jacks chat footer destroy smiley panel");
      this.jPN.hjm();
      this.jPN.destroy();
      this.jPN.animate().cancel();
      this.jPN = null;
    }
    if (this.RdV != null)
    {
      this.RdV.destroy();
      this.RdV = null;
      this.RdY = false;
    }
    if (this.Rjq != null) {
      this.Rjq.release();
    }
    if (this.Rjo != null)
    {
      this.Rjo.Rki = null;
      this.Rjo.Rog = null;
      this.Rjo.hide();
    }
    if (this.MkT != null)
    {
      if (this.Rkr != null) {
        this.Rkr.getBlurController().destroy();
      }
      if (this.RkH != null) {
        this.RkH.getBlurController().destroy();
      }
    }
    Log.i("MicroMsg.ChatFooter", "jacks destroy chat footer.");
    this.KQB.destroy();
    AppMethodBeat.o(31578);
  }
  
  public final void eBG()
  {
    AppMethodBeat.i(31679);
    if (this.KQB != null)
    {
      this.KQB.setText("");
      hlf();
      if (this.jPN != null) {
        this.jPN.setToSendText("");
      }
    }
    AppMethodBeat.o(31679);
  }
  
  public final void gO(String paramString, int paramInt)
  {
    AppMethodBeat.i(285153);
    if (paramInt == 2)
    {
      appendText("#" + paramString + " ");
      AppMethodBeat.o(285153);
      return;
    }
    appendText(paramString + " ");
    AppMethodBeat.o(285153);
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163215);
    ArrayList localArrayList = this.RiU.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163215);
    return localArrayList;
  }
  
  public String getAtSomebody()
  {
    return this.Rjt.RmZ;
  }
  
  public int getBarGroupHeight()
  {
    AppMethodBeat.i(31585);
    if (this.RjD == null) {
      this.RjD = findViewById(R.h.dxu);
    }
    if (this.RjD != null)
    {
      i = this.RjD.getHeight();
      AppMethodBeat.o(31585);
      return i;
    }
    int i = getResources().getDimensionPixelSize(R.f.Edge_7A);
    AppMethodBeat.o(31585);
    return i;
  }
  
  public f getCallback()
  {
    return this.Rcf;
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
    return this.RjQ;
  }
  
  public ac.a getIOnToDoBarCallback()
  {
    return this.Rkd;
  }
  
  public int getInsertPos()
  {
    return this.Rjt.Rna;
  }
  
  public boolean getIsVoiceInputPanleShow()
  {
    return this.RdY;
  }
  
  public int getKeyBordHeightPX()
  {
    AppMethodBeat.i(31671);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    AppMethodBeat.o(31671);
    return i;
  }
  
  public String getLastContent()
  {
    return this.Rjt.RmY;
  }
  
  public long getLastQuoteMsgId()
  {
    AppMethodBeat.i(31612);
    if ((this.Rjh.getTag() != null) && ((this.Rjh.getTag() instanceof ca)))
    {
      long l = ((ca)this.Rjh.getTag()).field_msgId;
      AppMethodBeat.o(31612);
      return l;
    }
    AppMethodBeat.o(31612);
    return 0L;
  }
  
  public String getLastText()
  {
    AppMethodBeat.i(31611);
    if (this.KQB == null)
    {
      AppMethodBeat.o(31611);
      return "";
    }
    String str = this.KQB.getText().toString();
    AppMethodBeat.o(31611);
    return str;
  }
  
  public int getMode()
  {
    return this.RjF;
  }
  
  public View getPanel()
  {
    return this.RiZ;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(31613);
    int i = this.KQB.getSelectionStart();
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
    if (this.jJL == 0) {
      i = getHeight() - this.RjW;
    }
    for (;;)
    {
      AppMethodBeat.o(31684);
      return i;
      int j = getHeight() - this.RjW + getKeyBordHeightPX();
      i = j;
      if (this.Rkc != null) {
        i = j - this.Rkc.eBE();
      }
    }
  }
  
  public final boolean hideVKB()
  {
    AppMethodBeat.i(31659);
    if (getKeyBordHeightPX() / 2 <= getBottom())
    {
      boolean bool = Util.hideVKB(this);
      AppMethodBeat.o(31659);
      return bool;
    }
    AppMethodBeat.o(31659);
    return false;
  }
  
  public final void hjU()
  {
    AppMethodBeat.i(31601);
    if (!this.RdY)
    {
      AppMethodBeat.o(31601);
      return;
    }
    this.RdY = false;
    if (this.RdV != null)
    {
      int i = getKeyBordHeightPX();
      int j = this.RiY.getHeight();
      this.RdV.animate().cancel();
      this.RdV.animate().translationY(i + j).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(31531);
          if (ChatFooter.az(ChatFooter.this) != null)
          {
            ChatFooter.az(ChatFooter.this).destroy();
            ChatFooter.az(ChatFooter.this).setVisibility(8);
          }
          AppMethodBeat.o(31531);
        }
      }).start();
    }
    this.KQB.setText("");
    AppMethodBeat.o(31601);
  }
  
  public final void hjp()
  {
    AppMethodBeat.i(31591);
    this.RjJ = true;
    if (this.jPN != null) {
      this.jPN.hjp();
    }
    AppMethodBeat.o(31591);
  }
  
  public final void hlA()
  {
    AppMethodBeat.i(285110);
    this.RiU.hkL();
    AppMethodBeat.o(285110);
  }
  
  public final void hlB()
  {
    AppMethodBeat.i(285112);
    AppPanel localAppPanel = this.RiU;
    localAppPanel.RhB.Ria.value = false;
    localAppPanel.hkT();
    AppMethodBeat.o(285112);
  }
  
  public final void hlC()
  {
    AppMethodBeat.i(31637);
    if (this.Rjd != null) {
      this.Rjd.setVisibility(8);
    }
    AppMethodBeat.o(31637);
  }
  
  public final void hlD()
  {
    AppMethodBeat.i(31638);
    AppPanel localAppPanel = this.RiU;
    localAppPanel.RhL = true;
    localAppPanel.RhB.Ek(false);
    localAppPanel.hkT();
    AppMethodBeat.o(31638);
  }
  
  public final void hlE()
  {
    AppMethodBeat.i(31639);
    Log.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
    this.RjI = true;
    this.KQB.setImeOptions(4);
    this.KQB.setInputType(this.KQB.getInputType() & 0xFFFFFFBF);
    AppMethodBeat.o(31639);
  }
  
  public final boolean hlH()
  {
    AppMethodBeat.i(31645);
    if ((this.Rkk == null) || (this.Rkk.getView() == null))
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Object localObject = this.Rkk.getView().findViewById(R.h.mm_content_fl);
    if (localObject == null)
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Rect localRect = new Rect();
    ((View)localObject).getGlobalVisibleRect(localRect);
    if (com.tencent.mm.compatible.util.d.qV(28))
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
  
  public final boolean hlI()
  {
    return this.jJL != 0;
  }
  
  public final void hlJ()
  {
    AppMethodBeat.i(31653);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185796);
        Log.i("MicroMsg.ChatFooter", "withLastText: ");
        ChatFooter.this.showVKB();
        ChatFooter.a(ChatFooter.this, true);
        AppMethodBeat.o(185796);
      }
    }, 500L);
    AppMethodBeat.o(31653);
  }
  
  public final void hlK()
  {
    AppMethodBeat.i(31655);
    if ((this.RdV != null) && (this.RdV.isShown())) {
      this.RdV.hmz();
    }
    AppMethodBeat.o(31655);
  }
  
  public final void hlN()
  {
    AppMethodBeat.i(285139);
    if (this.Rjo != null)
    {
      this.Rjo.Roh = false;
      this.Rjo.hide();
    }
    AppMethodBeat.o(285139);
  }
  
  public final void hlO()
  {
    AppMethodBeat.i(31674);
    if (this.Rjp != null) {
      this.Rjp.eBD();
    }
    AppMethodBeat.o(31674);
  }
  
  public final boolean hlP()
  {
    AppMethodBeat.i(31677);
    if ((this.Rjh.getTag() != null) && ((this.Rjh.getTag() instanceof ca)) && (this.Rjg.isShown()) && (this.Rjh.isShown()))
    {
      AppMethodBeat.o(31677);
      return true;
    }
    AppMethodBeat.o(31677);
    return false;
  }
  
  public final void hlQ()
  {
    AppMethodBeat.i(31681);
    this.RiW.setBackgroundResource(R.g.input_bg);
    this.RiW.setText(R.l.chatfooter_presstorcd);
    Object localObject;
    if (this.RkS)
    {
      if (!this.Rms)
      {
        this.Rms = true;
        if (this.Rjq == null) {
          break label299;
        }
        this.RkM.Nhi = this.Rjq.aff();
        if ((this.RkU == null) || (!this.RkU.isShowing())) {
          break label299;
        }
        if (e.Rnd == this.RmG)
        {
          this.RlG = false;
          this.Rjq.eRs();
          this.RkM.setExitType(2);
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCX, Boolean.FALSE);
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        AppMethodBeat.o(31681);
        return;
      }
      if (e.Rne == this.RmG)
      {
        if (this.Rmr <= 0) {
          this.Rmr = ((int)this.Rjq.aff());
        }
        if (!Util.isNullOrNil(this.Rjq.getFileName()))
        {
          localObject = com.tencent.mm.cq.a.VPo;
          com.tencent.mm.cq.a.a.byi(this.Rjq.getFileName());
        }
        this.Rjq.eRq();
        hmj();
        this.Njh.sendEmptyMessageDelayed(5000, 5000L);
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCX, Boolean.FALSE);
        AppMethodBeat.o(31681);
        return;
      }
      if (e.Rnc == this.RmG)
      {
        this.RlG = false;
        this.Rjq.eRp();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCW, Boolean.FALSE);
      }
      label299:
      AppMethodBeat.o(31681);
      return;
    }
    this.urq = false;
    if (this.Rjq != null)
    {
      this.RkM.Nhi = this.Rjq.aff();
      if (this.RjG)
      {
        if (k.Rnt != this.RkP)
        {
          this.Rmq = true;
          if ((this.MkT != null) && (this.MkT.isShowing()))
          {
            if (k.Rnv == this.RkP)
            {
              Log.i("MicroMsg.ChatFooter", "do not send voice.");
              this.RkM.setExitType(2);
              this.Rjq.eRs();
              AppMethodBeat.o(31681);
              return;
            }
            Log.i("MicroMsg.ChatFooter", "trans voice to txt.");
            this.Rjq.eRq();
            localObject = this.Rjq.getFileName();
            final long l = this.Rjq.aff();
            Log.i("transvoice", "fileName: %s, voiceLen: %d.", new Object[] { localObject, Long.valueOf(l) });
            if (NetStatusUtil.isConnected(getContext()))
            {
              if (this.RkK.isValid())
              {
                this.RkI.bfl((String)localObject);
                this.RkI.NiZ = l;
                this.RkI.talker = this.RiT;
                this.RkI.show();
                this.RkI.c(this.RkK);
                this.RjS = false;
                AppMethodBeat.o(31681);
                return;
              }
              this.RkM.setExitType(3);
              locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
              locala.bBd(getResources().getString(R.l.eUT));
              locala.bBj(getResources().getString(R.l.eUU));
              locala.ayl(getResources().getColor(R.e.Link_100));
              locala.c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(285404);
                  ChatFooter.l(ChatFooter.this).aNY(this.val$fileName);
                  AppMethodBeat.o(285404);
                }
              });
              locala.HG(false);
              locala.icu().show();
              AppMethodBeat.o(31681);
              return;
            }
            this.RkM.setExitType(4);
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
            locala.bBd(getResources().getString(R.l.eMs));
            locala.bBj(getResources().getString(R.l.eMu));
            locala.ayl(getResources().getColor(R.e.Link_100));
            locala.bBk(getResources().getString(R.l.eMt));
            locala.c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(292189);
                ChatFooter.l(ChatFooter.this).eV(this.val$fileName, (int)l);
                AppMethodBeat.o(292189);
              }
            });
            locala.d(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(268307);
                ChatFooter.l(ChatFooter.this).aNY(this.val$fileName);
                AppMethodBeat.o(268307);
              }
            });
            locala.icu().show();
            AppMethodBeat.o(31681);
          }
        }
        else
        {
          this.Rjq.eRp();
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        if ((this.wLq != null) && (this.wLq.getVisibility() == 0))
        {
          this.RkM.setExitType(2);
          this.Rjq.eRs();
          AppMethodBeat.o(31681);
          return;
        }
        this.Rjq.eRp();
      }
    }
    AppMethodBeat.o(31681);
  }
  
  public final void hlR()
  {
    AppMethodBeat.i(31683);
    bh.beI();
    this.Rkj = ((Boolean)com.tencent.mm.model.c.aHp().b(66832, Boolean.FALSE)).booleanValue();
    if (this.KQB != null) {
      this.KQB.setEnableSendBtn(this.Rkj);
    }
    AppMethodBeat.o(31683);
  }
  
  public final boolean hlS()
  {
    AppMethodBeat.i(285147);
    if ((this.Rkl != null) && (this.Rkl.hmp() != null))
    {
      if ((!((com.tencent.mm.ui.chatting.d.b.h)this.Rkl.hmp().bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK()) && (!((com.tencent.mm.ui.chatting.d.b.i)this.Rkl.hmp().bC(com.tencent.mm.ui.chatting.d.b.i.class)).hOP()))
      {
        AppMethodBeat.o(285147);
        return true;
      }
      AppMethodBeat.o(285147);
      return false;
    }
    AppMethodBeat.o(285147);
    return true;
  }
  
  public final void hlT()
  {
    AppMethodBeat.i(31685);
    if ((this.jLo == null) || (this.jLo.getVisibility() == 8))
    {
      AppMethodBeat.o(31685);
      return;
    }
    if (this.Rmw == 0)
    {
      this.Rmw = this.jLo.getWidth();
      this.Rmx = this.Rjb.getWidth();
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.Rmw, this.Rmx });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(185810);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bv(ChatFooter.this)) / (ChatFooter.bw(ChatFooter.this) - ChatFooter.bv(ChatFooter.this));
        ChatFooter.k(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(185810);
      }
    });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(268458);
        ChatFooter.k(ChatFooter.this).setVisibility(8);
        AppMethodBeat.o(268458);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(268457);
        if (!ChatFooter.bx(ChatFooter.this))
        {
          ChatFooter.k(ChatFooter.this).setVisibility(8);
          AppMethodBeat.o(268457);
          return;
        }
        Log.i("MicroMsg.ChatFooter", "animHideSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bx(ChatFooter.this)) });
        ChatFooter.this.hlU();
        AppMethodBeat.o(268457);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(268455);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(268455);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.start();
    AppMethodBeat.o(31685);
  }
  
  public final void hlU()
  {
    AppMethodBeat.i(31686);
    if (this.jLo == null)
    {
      AppMethodBeat.o(31686);
      return;
    }
    if (this.Rmw == 0)
    {
      this.Rmw = this.jLo.getWidth();
      this.Rmx = this.Rjb.getWidth();
    }
    if (this.Rmw == 0)
    {
      this.jLo.startAnimation(this.Rkm);
      this.jLo.setVisibility(0);
      AppMethodBeat.o(31686);
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.Rmx, this.Rmw });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(292403);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bv(ChatFooter.this)) / (ChatFooter.bw(ChatFooter.this) - ChatFooter.bv(ChatFooter.this));
        ChatFooter.k(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(292403);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(286674);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        ChatFooter.v(ChatFooter.this).setVisibility(8);
        ChatFooter.k(ChatFooter.this, false);
        AppMethodBeat.o(286674);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(286672);
        paramAnonymousAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousAnimator.width = -2;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousAnimator);
        ChatFooter.v(ChatFooter.this).setVisibility(8);
        ChatFooter.k(ChatFooter.this, false);
        if (!ChatFooter.bx(ChatFooter.this))
        {
          Log.i("MicroMsg.ChatFooter", "animShowSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bx(ChatFooter.this)) });
          ChatFooter.v(ChatFooter.this).setVisibility(0);
          ChatFooter.k(ChatFooter.this, true);
          ChatFooter.this.hlT();
        }
        AppMethodBeat.o(286672);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(286670);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(286670);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(31686);
  }
  
  public final void hlV()
  {
    AppMethodBeat.i(285148);
    if ((this.Rjb != null) && (this.Rjb.getVisibility() == 0))
    {
      Es(true);
      AppMethodBeat.o(285148);
      return;
    }
    AppMethodBeat.o(285148);
  }
  
  public final void hlg()
  {
    AppMethodBeat.i(285087);
    if (!Util.isNullOrNil(this.KQB.getText()))
    {
      this.KQB.setText("");
      if (this.jPN != null) {
        this.jPN.setToSendText("");
      }
    }
    En(false);
    hlf();
    AppMethodBeat.o(285087);
  }
  
  public final void hlh()
  {
    AppMethodBeat.i(31581);
    if (!Util.isNullOrNil(this.Rjl.getText())) {
      this.Rjl.setText("");
    }
    if (this.Rjh.getTag() != null) {
      this.Rjh.setTag(null);
    }
    this.Rjh.setVisibility(8);
    AppMethodBeat.o(31581);
  }
  
  public final void hli()
  {
    AppMethodBeat.i(31583);
    if (this.RiU == null)
    {
      AppMethodBeat.o(31583);
      return;
    }
    this.RiU.hkI();
    AppMethodBeat.o(31583);
  }
  
  public final void hlj()
  {
    AppMethodBeat.i(31587);
    this.Rjd = ((ImageButton)this.fyN.findViewById(R.h.dzk));
    this.Rjd.setVisibility(0);
    if (!com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vvm, true)) {
      this.fyN.findViewById(R.h.dzl).setVisibility(0);
    }
    for (;;)
    {
      this.fyN.findViewById(R.h.dzl).setVisibility(8);
      this.Rjd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(228158);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = com.tencent.mm.emoji.c.b.jNn;
          com.tencent.mm.emoji.c.b.aCY();
          if (ChatFooter.l(ChatFooter.this) != null) {
            ChatFooter.l(ChatFooter.this).eRv();
          }
          if (ChatFooter.c(ChatFooter.this) == 2) {
            ChatFooter.this.showVKB();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228158);
            return;
            if (ChatFooter.w(ChatFooter.this)) {
              ChatFooter.this.hjp();
            }
            ChatFooter.this.hln();
            if (!com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vvm, false))
            {
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvm, Boolean.TRUE);
              ChatFooter.x(ChatFooter.this).findViewById(R.h.dzl).setVisibility(8);
            }
          }
        }
      });
      if (this.Rjo != null) {
        this.Rjo.Rof = this.Rjd;
      }
      if (this.Rjp != null) {
        this.Rjp.DqG = this.fyN;
      }
      AppMethodBeat.o(31587);
      return;
      this.fyN.findViewById(R.h.dzl).setVisibility(8);
    }
  }
  
  public final void hll()
  {
    boolean bool = true;
    AppMethodBeat.i(31590);
    if ((e.RnO == null) || (getContext() == null))
    {
      if (getContext() == null)
      {
        Log.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", new Object[] { Util.getStack() });
        this.jPN = new d(MMApplicationContext.getContext());
        AppMethodBeat.o(31590);
        return;
      }
      this.jPN = new d(getContext());
      AppMethodBeat.o(31590);
      return;
    }
    if (this.jPN != null) {
      this.jPN.destroy();
    }
    this.jPN = e.RnO.fd(getContext());
    ChatFooterPanel localChatFooterPanel;
    if (this.jPN != null)
    {
      this.jPN.setEntranceScene(ChatFooterPanel.Rch);
      this.jPN.setVisibility(8);
      this.jPN.setFooterType(this.PAa);
      if (this.RiZ != null) {
        this.RiZ.addView(this.jPN, -1, -1);
      }
      this.jPN.setOnTextOperationListener(this.RlH);
      localChatFooterPanel = this.jPN;
      if (this.KQB.getText().length() <= 0) {
        break label271;
      }
    }
    for (;;)
    {
      localChatFooterPanel.setSendButtonEnable(bool);
      if (this.Rkl != null) {
        this.jPN.setTalkerName(this.Rkl.getTalkerUserName());
      }
      this.jPN.onResume();
      if (this.RjJ) {
        hjp();
      }
      setSmileyPanelCallback(this.Rcf);
      AppMethodBeat.o(31590);
      return;
      label271:
      bool = false;
    }
  }
  
  public final void hln()
  {
    AppMethodBeat.i(31597);
    this.RjF = 1;
    Eo(true);
    if (this.KQB.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      tV(bool);
      this.RiW.setVisibility(8);
      aqy(R.g.dnf);
      if (this.RdV != null)
      {
        this.RdV.setVisibility(8);
        this.RdY = false;
        this.RdV.reset();
      }
      k(2, true, -1);
      AppMethodBeat.o(31597);
      return;
    }
  }
  
  public final void hlq()
  {
    AppMethodBeat.i(31620);
    if (this.RkS)
    {
      this.RkZ.setVisibility(0);
      this.RlD.setVisibility(8);
      AppMethodBeat.o(31620);
      return;
    }
    this.MkW.setVisibility(8);
    this.RjB.setVisibility(0);
    AppMethodBeat.o(31620);
  }
  
  public final void hlr()
  {
    AppMethodBeat.i(31626);
    Eo(true);
    this.RiX.setVisibility(8);
    this.RiW.setVisibility(8);
    AppMethodBeat.o(31626);
  }
  
  public final void hls()
  {
    AppMethodBeat.i(31627);
    if (this.RiX != null) {
      this.RiX.setVisibility(0);
    }
    AppMethodBeat.o(31627);
  }
  
  public final void hlt()
  {
    AppMethodBeat.i(31628);
    AppPanel localAppPanel = this.RiU;
    localAppPanel.RhB.RhY.value = false;
    localAppPanel.hkT();
    AppMethodBeat.o(31628);
  }
  
  public final void hlu()
  {
    AppMethodBeat.i(31629);
    AppPanel localAppPanel = this.RiU;
    localAppPanel.RhB.Riq.value = false;
    localAppPanel.hkT();
    AppMethodBeat.o(31629);
  }
  
  public final void hlv()
  {
    AppMethodBeat.i(31630);
    AppPanel localAppPanel = this.RiU;
    localAppPanel.RhB.RhZ.value = false;
    localAppPanel.hkT();
    AppMethodBeat.o(31630);
  }
  
  public final void hlw()
  {
    AppMethodBeat.i(31631);
    AppPanel localAppPanel = this.RiU;
    localAppPanel.RhB.Ric.value = false;
    localAppPanel.hkT();
    AppMethodBeat.o(31631);
  }
  
  public final void hlx()
  {
    AppMethodBeat.i(31635);
    AppPanel localAppPanel = this.RiU;
    localAppPanel.RhJ = true;
    localAppPanel.RhB.Ej(false);
    localAppPanel.hkT();
    Log.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(31635);
  }
  
  public final void hly()
  {
    this.RiU.RhM = true;
  }
  
  public final void hlz()
  {
    AppMethodBeat.i(31636);
    AppPanel localAppPanel = this.RiU;
    localAppPanel.RhK = true;
    localAppPanel.RhB.Eg(false);
    localAppPanel.hkT();
    Log.i("MicroMsg.AppPanel", "disableServiceRemittance %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(31636);
  }
  
  public final boolean hmk()
  {
    AppMethodBeat.i(185416);
    if ((this.RkU != null) && (this.RkU.isShowing()))
    {
      AppMethodBeat.o(185416);
      return true;
    }
    AppMethodBeat.o(185416);
    return false;
  }
  
  public final int ht(String paramString, int paramInt)
  {
    AppMethodBeat.i(163213);
    int i = paramInt;
    if (this.Rjt.Rnb.containsKey(paramString))
    {
      i = paramInt;
      if (((LinkedList)this.Rjt.Rnb.get(paramString)).size() > 0) {
        i = paramInt | 0x1;
      }
    }
    paramInt = i;
    if (this.Rjw)
    {
      if (this.Rjy)
      {
        paramInt = 4;
        paramInt = i | paramInt;
      }
    }
    else
    {
      i = paramInt;
      if (this.Rjx) {
        if (!this.Rjy) {
          break label107;
        }
      }
    }
    label107:
    for (i = 16;; i = 32)
    {
      i = paramInt | i;
      AppMethodBeat.o(163213);
      return i;
      paramInt = 8;
      break;
    }
  }
  
  public final void hy(View paramView)
  {
    int i = -1;
    AppMethodBeat.i(163212);
    if (this.Rjq != null) {
      this.Rjq.eRw();
    }
    Log.i("MicroMsg.ChatFooter", "click attach btn: %s, %s", new Object[] { Integer.valueOf(this.RiU.getVisibility()), Boolean.valueOf(this.RiZ.hmq()) });
    if (this.jJL == 3)
    {
      if (this.RjF == 1)
      {
        showVKB();
        AppMethodBeat.o(163212);
        return;
      }
      k(0, true, -1);
      AppMethodBeat.o(163212);
      return;
    }
    Object localObject;
    if (paramView == null)
    {
      k(3, true, i);
      if ((this.RdV != null) && (this.RdV.getVisibility() == 0) && (this.RdY))
      {
        Log.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
        this.RdV.setVisibility(8);
        this.RdY = false;
        this.RdV.reset();
      }
      paramView = ap.hhK();
      localObject = MMApplicationContext.getContext();
      if ((com.tencent.mm.kernel.h.aHB()) && (localObject != null)) {
        break label284;
      }
      label187:
      ap.hhK().jx(MMApplicationContext.getContext());
      if ((ab.PP(this.toUser)) && (aa.asf()))
      {
        paramView = this.toUser;
        if (!ab.Rh(paramView)) {
          break label530;
        }
        i = 2;
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject = new al();
        ((al)localObject).jd(paramView);
        ((al)localObject).geB = 1L;
        ((al)localObject).giO = i;
        ((al)localObject).bpa();
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
          String str = com.tencent.mm.n.h.axc().getValue("ShowAPPSuggestion");
          if ((Util.isNullOrNil(str)) || (Integer.valueOf(str).intValue() != 1)) {
            Log.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[] { str });
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[] { localException.getMessage() });
          if (paramView.QXF)
          {
            Log.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
            break label187;
          }
          Log.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
          paramView.QXF = true;
          if (System.currentTimeMillis() - paramView.QXI < 43200000L)
          {
            Log.d("MicroMsg.SuggestionAppListLogic", "not now");
            paramView.QXF = false;
            break label187;
          }
          com.tencent.mm.kernel.h.aHH();
          paramView.QXI = com.tencent.mm.kernel.h.aHG().aHp().ahV(352275);
          if (System.currentTimeMillis() - paramView.QXI < 43200000L)
          {
            Log.w("MicroMsg.SuggestionAppListLogic", "not now sp");
            paramView.QXF = false;
            break label187;
          }
          if (paramView.lang == null) {
            paramView.lang = LocaleUtil.loadApplicationLanguage(((Context)localObject).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), (Context)localObject);
          }
          paramView = new af(paramView.lang, new LinkedList());
          com.tencent.mm.plugin.ab.a.fmC();
          com.tencent.mm.pluginsdk.model.app.e.a(4, paramView);
        }
      }
      break label187;
      label530:
      if (ab.Rg(paramView)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void k(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(163217);
    Log.i("MicroMsg.ChatFooter", "configPanel: %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.BSf), Boolean.valueOf(this.RjR), Boolean.valueOf(this.RjL) });
    int i;
    int j;
    label98:
    int k;
    if ((this.RjR) || (!this.RjL))
    {
      i = 1;
      if ((paramInt1 != 1) || (this.BSf)) {
        break label199;
      }
      j = 1;
      if ((paramInt1 == 1) || (!this.BSf)) {
        break label205;
      }
      k = 1;
      label113:
      if ((i == 0) && ((j != 0) || (k != 0))) {
        break label211;
      }
      l(paramInt1, paramBoolean, paramInt2);
      label135:
      if (j != 0)
      {
        this.RjU = 0;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(271986);
            ChatFooter.a(ChatFooter.this, true);
            ChatFooter.this.setToSendTextColor(true);
            boolean bool = ChatFooter.aP(ChatFooter.this).showSoftInput(ChatFooter.d(ChatFooter.this).hZx(), 0);
            ChatFooter.bq(ChatFooter.this);
            Log.i("MicroMsg.ChatFooter", "showSoftInput %b, %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(ChatFooter.br(ChatFooter.this)) });
            if ((!bool) && (ChatFooter.br(ChatFooter.this) < 10)) {
              ChatFooter.this.postDelayed(this, 100L);
            }
            AppMethodBeat.o(271986);
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
      this.BSf = paramBoolean;
      AppMethodBeat.o(163217);
      return;
      i = 0;
      break;
      j = 0;
      break label98;
      k = 0;
      break label113;
      this.RjM = paramInt1;
      break label135;
    }
  }
  
  public final void ns(String paramString1, String paramString2)
  {
    AppMethodBeat.i(285093);
    this.fLi = paramString1;
    this.toUser = paramString2;
    if (this.KQB != null) {
      if (!ab.Lj(paramString2)) {
        break label73;
      }
    }
    label73:
    for (int i = 2;; i = 1)
    {
      this.KQB.getInputExtras(true).putInt("wechat_scene", i);
      this.KQB.getInputExtras(true).putBoolean("if_support_wx_emoji", true);
      AppMethodBeat.o(285093);
      return;
    }
  }
  
  public final HashMap<String, String> nt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31603);
    long l = System.currentTimeMillis();
    if (Util.isNullOrNil(paramString2))
    {
      if (this.Rjt.Rnb.containsKey(paramString1)) {
        this.Rjt.Rnb.remove(paramString1);
      }
      AppMethodBeat.o(31603);
      return null;
    }
    if ((!this.Rjt.Rnb.containsKey(paramString1)) || (((LinkedList)this.Rjt.Rnb.get(paramString1)).size() <= 0))
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
    Log.i("MicroMsg.ChatFooter", "after split @ :%s", new Object[] { localObject });
    if (((List)localObject).size() <= 0)
    {
      ((LinkedList)this.Rjt.Rnb.get(paramString1)).clear();
      AppMethodBeat.o(31603);
      return null;
    }
    paramString1 = (LinkedList)this.Rjt.Rnb.get(paramString1);
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      Log.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", new Object[] { Integer.valueOf(paramString1.size()) });
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
      Log.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", new Object[] { Integer.valueOf(paramString2.size()) });
      ((HashMap)localObject).put("atuserlist", "<![CDATA[" + Util.listToString(paramString2, ",") + "]]>");
      paramString1.clear();
      Log.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(31603);
      return localObject;
    }
    Log.w("MicroMsg.ChatFooter", "list is null or size 0");
    AppMethodBeat.o(31603);
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(31579);
    super.onAttachedToWindow();
    hlM();
    hlL();
    aqE(getKeyBordHeightPX());
    AppMethodBeat.o(31579);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31643);
    super.onConfigurationChanged(paramConfiguration);
    if (com.tencent.mm.compatible.util.d.qV(24)) {
      this.RjR = ((Activity)getContext()).isInMultiWindowMode();
    }
    if (paramConfiguration.orientation == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.RjL = bool;
      k(0, false, -1);
      hlM();
      Log.i("MicroMsg.ChatFooter", "onConfigurationChanged: %s, %s, %s", new Object[] { paramConfiguration, Boolean.valueOf(this.RjL), Boolean.valueOf(this.RjR) });
      aqE(getKeyBordHeightPX());
      paramConfiguration = com.tencent.mm.plugin.patmsg.ui.b.GKZ;
      paramConfiguration = com.tencent.mm.plugin.patmsg.ui.b.fmZ();
      if (paramConfiguration != null) {
        paramConfiguration.dismiss();
      }
      if (com.tencent.mm.ui.chatting.atsomeone.d.hWR()) {
        com.tencent.mm.ui.chatting.atsomeone.d.dismissDialog();
      }
      AppMethodBeat.o(31643);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(31580);
    super.onDetachedFromWindow();
    this.jij.close();
    this.RjN = null;
    this.RjO = false;
    AppMethodBeat.o(31580);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(285155);
    this.KQB.hZB();
    this.RjT = false;
    showVKB();
    RjA = null;
    AppMethodBeat.o(285155);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31669);
    Log.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", new Object[] { Integer.valueOf(View.MeasureSpec.getSize(paramInt2)), Integer.valueOf(getMeasuredHeight()) });
    super.onMeasure(paramInt1, paramInt2);
    Log.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    AppMethodBeat.o(31669);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(31577);
    Log.i("MicroMsg.ChatFooter", "onPause");
    this.zQA = false;
    if ((this.RjP == 48) && (this.jJL == 1) && (!this.Rka))
    {
      this.BSf = false;
      l(0, true, -1);
    }
    this.jij.close();
    if (this.jPN != null) {
      this.jPN.onPause();
    }
    if ((this.RdY) && (this.RdV != null)) {
      this.RdV.pause();
    }
    if (this.Rjq != null) {
      this.Rjq.onPause();
    }
    if (this.Rjo != null) {
      this.Rjo.hide();
    }
    if ((this.MkT != null) && (this.MkT.isShowing())) {
      this.MkT.dismiss();
    }
    hlO();
    this.KQB.onPause();
    AppMethodBeat.o(31577);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31672);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(31672);
  }
  
  public final void q(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(31582);
    if ((this.Rjh.getTag() != null) && ((this.Rjh.getTag() instanceof ca)) && (Util.isEqual(paramLong, ((ca)this.Rjh.getTag()).field_msgId))) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185798);
          if (!paramBoolean) {
            com.tencent.mm.ui.base.h.c(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(R.l.eMc), "", true);
          }
          ChatFooter.this.hlh();
          AppMethodBeat.o(185798);
        }
      });
    }
    AppMethodBeat.o(31582);
  }
  
  public void setAppPanelListener(AppPanel.a parama)
  {
    AppMethodBeat.i(31649);
    this.RiU.setAppPanelListener(parama);
    AppMethodBeat.o(31649);
  }
  
  public void setAppPanelTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(31595);
    if ((this.Rja == null) || (this.RiU == null))
    {
      AppMethodBeat.o(31595);
      return;
    }
    this.Rja.setText(paramCharSequence);
    if (!Util.isNullOrNil(paramCharSequence)) {
      if (this.RiU.getVisibility() != 0) {
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
    if (this.Rja == null)
    {
      AppMethodBeat.o(31596);
      return;
    }
    if (TextUtils.isEmpty(this.Rja.getText()))
    {
      this.Rja.setVisibility(8);
      AppMethodBeat.o(31596);
      return;
    }
    if (paramBoolean)
    {
      localObject = this.Rja.getContext();
      i = this.RiZ.getHeight();
      int j = getKeyBordHeightPX();
      int k = com.tencent.mm.ci.a.fromDPToPix((Context)localObject, 32);
      localObject = this.Rja.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (i - j + k);
        this.Rja.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    Object localObject = this.Rja;
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
    this.RiU.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163214);
  }
  
  public void setAppPanelVisible(int paramInt)
  {
    AppMethodBeat.i(31642);
    if (this.RiU != null) {
      this.RiU.setVisibility(paramInt);
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
    this.Rjt.RmZ = paramString;
  }
  
  public void setBottomPanelVisibility(int paramInt)
  {
    AppMethodBeat.i(31644);
    if (paramInt == 0)
    {
      this.RiZ.setVisibility(paramInt);
      AppMethodBeat.o(31644);
      return;
    }
    k(0, true, -1);
    AppMethodBeat.o(31644);
  }
  
  public void setCattingRootLayoutId(int paramInt)
  {
    this.Rmv = null;
    this.Rmu = paramInt;
  }
  
  public void setDefaultSmileyByDetail(String paramString)
  {
    AppMethodBeat.i(31600);
    if (!Util.isNullOrNil(paramString))
    {
      if (this.jPN == null) {
        hll();
      }
      this.jPN.setDefaultEmojiByDetail(paramString);
    }
    AppMethodBeat.o(31600);
  }
  
  @TargetApi(11)
  public void setEditTextOnDragListener(View.OnDragListener paramOnDragListener)
  {
    AppMethodBeat.i(31647);
    this.KQB.setOnDragListener(paramOnDragListener);
    AppMethodBeat.o(31647);
  }
  
  public void setExitType(int paramInt)
  {
    AppMethodBeat.i(185414);
    com.tencent.mm.plugin.transvoice.a.c.a locala = com.tencent.mm.plugin.transvoice.a.c.Nhv;
    com.tencent.mm.plugin.transvoice.a.c.gsv().setExitType(paramInt);
    AppMethodBeat.o(185414);
  }
  
  public void setFooterEventListener(b paramb)
  {
    this.Rjq = paramb;
  }
  
  public void setFooterStatus(boolean paramBoolean) {}
  
  public void setFooterType(int paramInt)
  {
    AppMethodBeat.i(31576);
    this.PAa = paramInt;
    if (this.jPN != null) {
      this.jPN.setFooterType(paramInt);
    }
    AppMethodBeat.o(31576);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(285104);
    if (this.KQB != null) {
      this.KQB.setHint(paramCharSequence);
    }
    AppMethodBeat.o(285104);
  }
  
  public void setIOnTodoViewCallback(ac.c paramc)
  {
    this.Rkc = paramc;
  }
  
  public void setIgnoreScroll(Boolean paramBoolean)
  {
    AppMethodBeat.i(31661);
    this.Rka = paramBoolean.booleanValue();
    AppMethodBeat.o(31661);
  }
  
  public void setInsertPos(int paramInt)
  {
    this.Rjt.Rna = paramInt;
  }
  
  public void setIsMultiWindow(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(31667);
    Log.i("MicroMsg.ChatFooter", "setIsMultiWindow: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.RjR != paramBoolean) {}
    for (;;)
    {
      this.RjR = paramBoolean;
      hlM();
      if (i != 0)
      {
        aqE(getKeyBordHeightPX());
        k(0, false, -1);
      }
      AppMethodBeat.o(31667);
      return;
      i = 0;
    }
  }
  
  public void setKeyboardShow(Boolean paramBoolean)
  {
    AppMethodBeat.i(31662);
    this.BSf = paramBoolean.booleanValue();
    AppMethodBeat.o(31662);
  }
  
  public void setLastContent(String paramString)
  {
    this.Rjt.RmY = paramString;
  }
  
  public void setLastQuoteMsgId(long paramLong)
  {
    AppMethodBeat.i(31605);
    if (paramLong != 0L)
    {
      ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(paramLong);
      if (((localca.hxx & 0x4) == 4) || (localca.getType() == 10000))
      {
        Log.e("MicroMsg.ChatFooter", "msg(%s) is revoked!", new Object[] { localca.getType() + "," + (localca.hxx & 0x4) });
        com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(R.l.eMc), "", true);
        AppMethodBeat.o(31605);
        return;
      }
      this.Rjh.setTag(localca);
      AppMethodBeat.o(31605);
      return;
    }
    this.Rjh.setTag(null);
    AppMethodBeat.o(31605);
  }
  
  public void setLastText(String paramString)
  {
    AppMethodBeat.i(31606);
    D(paramString, -1, true);
    AppMethodBeat.o(31606);
  }
  
  public void setLbsMode(boolean paramBoolean)
  {
    this.Rjv = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    AppMethodBeat.i(31623);
    bM(paramInt, true);
    AppMethodBeat.o(31623);
  }
  
  public void setOnEditFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(31648);
    this.KQB.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(31648);
  }
  
  public void setOnFooterPanelSwitchListener(f paramf)
  {
    this.Rjs = paramf;
  }
  
  public void setOnFooterSwitchListener(g paramg)
  {
    AppMethodBeat.i(31650);
    this.Rjr = paramg;
    if (paramg == null)
    {
      AppMethodBeat.o(31650);
      return;
    }
    paramg = findViewById(R.h.dyG);
    paramg.setVisibility(0);
    paramg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(289948);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$56", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ChatFooter.bm(ChatFooter.this) != null) {
          ChatFooter.bm(ChatFooter.this).Et(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$56", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289948);
      }
    });
    AppMethodBeat.o(31650);
  }
  
  public void setRecordNormalWording(String paramString)
  {
    AppMethodBeat.i(31618);
    if ((paramString == null) || (this.RjC == null))
    {
      AppMethodBeat.o(31618);
      return;
    }
    this.RjC.setText(paramString);
    AppMethodBeat.o(31618);
  }
  
  public void setSetTolastCustomPage(boolean paramBoolean) {}
  
  public void setSmileyPanelCallback(f paramf)
  {
    AppMethodBeat.i(31592);
    this.Rcf = paramf;
    if (this.jPN != null) {
      this.jPN.setCallback(paramf);
    }
    AppMethodBeat.o(31592);
  }
  
  public void setSmileyPanelCallback2(j paramj)
  {
    this.Rjo.Rog = paramj;
  }
  
  public void setSwitchButtonMode(int paramInt)
  {
    AppMethodBeat.i(31651);
    if (paramInt == this.Rmk)
    {
      AppMethodBeat.o(31651);
      return;
    }
    this.Rmk = paramInt;
    ImageView localImageView1 = (ImageView)findViewById(R.h.dVW);
    ImageView localImageView2 = (ImageView)findViewById(R.h.dQD);
    if (this.Rmk == 1)
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
    this.Rkg = paramc;
  }
  
  @TargetApi(11)
  public void setToSendTextColor(final boolean paramBoolean)
  {
    AppMethodBeat.i(31652);
    if (com.tencent.mm.compatible.util.d.qV(11))
    {
      com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a()
      {
        public final void run()
        {
          AppMethodBeat.i(185367);
          Message localMessage = new Message();
          localMessage.what = 1002;
          localMessage.obj = Boolean.valueOf(paramBoolean);
          ChatFooter.bn(ChatFooter.this).sendMessage(localMessage);
          AppMethodBeat.o(185367);
        }
      });
      AppMethodBeat.o(31652);
      return;
    }
    if (paramBoolean)
    {
      this.KQB.setTextColor(getResources().getColor(R.e.mm_edit_text_color));
      AppMethodBeat.o(31652);
      return;
    }
    this.KQB.setTextColor(getResources().getColor(R.e.half_alpha_black));
    Em(false);
    AppMethodBeat.o(31652);
  }
  
  public void setUserName(String paramString)
  {
    AppMethodBeat.i(31682);
    this.RiT = paramString;
    if (this.jPN != null) {
      this.jPN.setTalkerName(this.RiT);
    }
    if (this.RiU != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ChatFooter", "setusername: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (this.RiU == null) {
        break label167;
      }
      if ((!ab.QX(this.RiT)) && (!ab.QO(this.RiT))) {
        break;
      }
      this.RiU.setServiceShowFlag(0);
      AppMethodBeat.o(31682);
      return;
    }
    if (ab.Qm(this.RiT))
    {
      this.RiU.setServiceShowFlag(4);
      AppMethodBeat.o(31682);
      return;
    }
    if (ab.Lj(this.RiT))
    {
      this.RiU.setServiceShowFlag(2);
      AppMethodBeat.o(31682);
      return;
    }
    this.RiU.setServiceShowFlag(1);
    label167:
    AppMethodBeat.o(31682);
  }
  
  public void setVoice2txtCountDown(int paramInt)
  {
    AppMethodBeat.i(31619);
    if (-1 == paramInt)
    {
      this.Rkt.setVisibility(0);
      this.Rkv.setVisibility(8);
      AppMethodBeat.o(31619);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 10))
    {
      if (8 == this.Rkv.getVisibility())
      {
        this.Rkt.setVisibility(8);
        this.Rkv.setVisibility(0);
      }
      if (this.Rkv != null) {
        this.Rkv.setImageResource(this.RlV[paramInt]);
      }
    }
    AppMethodBeat.o(31619);
  }
  
  public void setVoiceInputShowCallback(d paramd)
  {
    this.Rkh = paramd;
  }
  
  public void setVoiceReactArea(int paramInt)
  {
    AppMethodBeat.i(185401);
    if (this.RkS)
    {
      setNewVoice2TxtCountDown(paramInt);
      AppMethodBeat.o(185401);
      return;
    }
    if (paramInt < 10)
    {
      if (this.RjG)
      {
        setVoice2txtCountDown(paramInt);
        AppMethodBeat.o(185401);
        return;
      }
      if (-1 == paramInt)
      {
        setRecordNormalWording(getResources().getString(R.l.chatfooter_cancel_rcd));
        AppMethodBeat.o(185401);
        return;
      }
      setRecordNormalWording(getResources().getQuantityString(R.j.emj, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    }
    AppMethodBeat.o(185401);
  }
  
  public void setWordCountLimit(int paramInt)
  {
    AppMethodBeat.i(31646);
    this.RiV = ((TextView)this.fyN.findViewById(R.h.chatting_wordcount_tv));
    this.KQB.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(31646);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(31656);
    if ((this.Rkk != null) && (this.Rkk.isSupportNavigationSwipeBack()) && (this.Rkk.getSwipeBackLayout() != null)) {
      this.Rkk.getSwipeBackLayout().setOnceDisEnableGesture(true);
    }
    if (!hlH())
    {
      k(1, true, -1);
      AppMethodBeat.o(31656);
      return;
    }
    Log.i("MicroMsg.ChatFooter", "isScrolling!! pass this event!");
    AppMethodBeat.o(31656);
  }
  
  public static final class a
  {
    public String RmY;
    String RmZ;
    int Rna;
    HashMap<String, LinkedList<HashMap<String, String>>> Rnb;
    
    private a()
    {
      AppMethodBeat.i(31558);
      this.Rnb = new HashMap();
      AppMethodBeat.o(31558);
    }
  }
  
  public static abstract interface b
  {
    public abstract String getTalkerUserName();
    
    public abstract com.tencent.mm.ui.chatting.i.b hmo();
    
    public abstract com.tencent.mm.ui.chatting.e.a hmp();
  }
  
  public static abstract interface c
  {
    public abstract void a(Boolean paramBoolean1, Boolean paramBoolean2);
    
    public abstract void b(Boolean paramBoolean1, Boolean paramBoolean2);
  }
  
  public static abstract interface d
  {
    public abstract void x(Boolean paramBoolean);
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(185398);
      Rnc = new e("MODE_VOICE", 0);
      Rnd = new e("MODE_CANCEL", 1);
      Rne = new e("MODE_TRANS", 2);
      Rnf = new e[] { Rnc, Rnd, Rne };
      AppMethodBeat.o(185398);
    }
    
    private e() {}
  }
  
  public static abstract interface f
  {
    public abstract void lX(int paramInt1, int paramInt2);
  }
  
  public static abstract interface g
  {
    public abstract boolean Et(boolean paramBoolean);
  }
  
  public static enum h
  {
    static
    {
      AppMethodBeat.i(185821);
      Rng = new h("SendVoice", 0);
      Rnh = new h("StopRecord", 1);
      Rni = new h("Reset", 2);
      Rnj = new h("Cancel", 3);
      Rnk = new h("Pause", 4);
      Rnl = new h("Error", 5);
      Rnm = new h[] { Rng, Rnh, Rni, Rnj, Rnk, Rnl };
      AppMethodBeat.o(185821);
    }
    
    private h() {}
  }
  
  public final class i
    implements TextWatcher
  {
    TextWatcher JiE;
    private boolean Rnn;
    private boolean Rno;
    
    public i(TextWatcher paramTextWatcher)
    {
      AppMethodBeat.i(31559);
      this.Rnn = false;
      this.Rno = com.tencent.mm.compatible.util.d.qW(11);
      this.JiE = paramTextWatcher;
      AppMethodBeat.o(31559);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      boolean bool = true;
      AppMethodBeat.i(31560);
      if ((ChatFooter.j(ChatFooter.this)) && (this.Rnn) && (paramEditable.length() > 0))
      {
        this.Rnn = false;
        ChatFooter.d(ChatFooter.this).setText(paramEditable.subSequence(0, paramEditable.length() - 1));
        if (ChatFooter.d(ChatFooter.this).length() > 0)
        {
          ChatFooter.k(ChatFooter.this).performClick();
          Log.i("MicroMsg.ChatFooter", "enter button, do send");
        }
        Log.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        AppMethodBeat.o(31560);
        return;
      }
      this.JiE.afterTextChanged(paramEditable);
      if (ChatFooter.y(ChatFooter.this) != null)
      {
        if (ChatFooter.d(ChatFooter.this).getLineCount() > 1)
        {
          ChatFooter.y(ChatFooter.this).setVisibility(0);
          ChatFooter.y(ChatFooter.this).setText(paramEditable.length() + "/140");
        }
      }
      else {
        if ((paramEditable.length() <= 0) || (paramEditable.toString().trim().length() <= 0)) {
          break label306;
        }
      }
      for (;;)
      {
        ChatFooter.b(ChatFooter.this, bool);
        if (ChatFooter.z(ChatFooter.this) != null) {
          ChatFooter.z(ChatFooter.this).setSendButtonEnable(bool);
        }
        Log.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        AppMethodBeat.o(31560);
        return;
        ChatFooter.y(ChatFooter.this).setVisibility(8);
        break;
        label306:
        bool = false;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(31561);
      this.JiE.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      Log.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
      AppMethodBeat.o(31561);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(31562);
      if ((ChatFooter.j(ChatFooter.this)) && (paramInt2 == 0) && (paramInt1 == paramCharSequence.length() - 1) && (paramInt3 == 1) && (paramCharSequence.charAt(paramCharSequence.length() - 1) == '\n'))
      {
        Log.i("MicroMsg.ChatFooter", "text changed, enter button");
        this.Rnn = true;
        AppMethodBeat.o(31562);
        return;
      }
      long l = Util.currentTicks();
      int j = 0;
      int i = j;
      Spannable localSpannable;
      int k;
      Object localObject1;
      if (paramInt3 > 0)
      {
        i = j;
        if ((paramCharSequence instanceof Spannable))
        {
          localSpannable = (Spannable)paramCharSequence;
          k = paramInt1 + paramInt3;
          localObject1 = (com.tencent.mm.ui.widget.a[])localSpannable.getSpans(paramInt1, k, com.tencent.mm.ui.widget.a.class);
          if (localObject1 != null)
          {
            i = j;
            if (localObject1.length > 0) {}
          }
          else
          {
            localObject1 = (SpanWatcher[])localSpannable.getSpans(0, localSpannable.length(), SpanWatcher.class);
            if (localObject1 == null) {
              break label532;
            }
            j = localObject1.length;
            int m = localObject1.length;
            i = 0;
            while (i < m)
            {
              localSpannable.removeSpan(localObject1[i]);
              i += 1;
            }
          }
        }
      }
      label532:
      for (i = j;; i = 0)
      {
        Object localObject2 = com.tencent.mm.cl.h.htZ();
        ChatFooter.this.getContext();
        float f = ChatFooter.d(ChatFooter.this).getTextSize();
        if (!Util.isNullOrNil(localSpannable.toString()))
        {
          j = Math.round(f);
          PInt localPInt = new PInt();
          localPInt.value = ((com.tencent.mm.cl.h)localObject2).UYU;
          localObject2 = com.tencent.mm.cl.b.htF().a(localSpannable, j, localPInt, paramInt1, k);
          com.tencent.mm.cl.g.htS().a((Spannable)localObject2, j, localPInt.value, paramInt1, k);
        }
        if (localObject1 != null)
        {
          k = localObject1.length;
          j = 0;
          while (j < k)
          {
            localSpannable.setSpan(localObject1[j], 0, localSpannable.length(), 18);
            j += 1;
          }
        }
        Log.i("MicroMsg.ChatFooter", "onTextChanged: cost %s; start:%s, count:%s, watcherCount:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(i) });
        this.JiE.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        ChatFooter.this.Rkf.geK += 1L;
        ChatFooter.this.Rkf.agL();
        if (ChatFooter.this.Rkf.geH == 0L) {
          ChatFooter.this.Rkf.agK();
        }
        if (ChatFooter.z(ChatFooter.this) != null) {
          ChatFooter.z(ChatFooter.this).setToSendText(ChatFooter.d(ChatFooter.this).getText().toString());
        }
        AppMethodBeat.o(31562);
        return;
      }
    }
  }
  
  static enum j
  {
    static
    {
      AppMethodBeat.i(31565);
      Rnp = new j("MODE_INVALID", 0);
      Rnq = new j("MODE_BLUR", 1);
      Rnr = new j("MODE_NORMAL", 2);
      Rns = new j[] { Rnp, Rnq, Rnr };
      AppMethodBeat.o(31565);
    }
    
    private j() {}
  }
  
  static enum k
  {
    static
    {
      AppMethodBeat.i(31568);
      Rnt = new k("MODE_INVALID", 0);
      Rnu = new k("MODE_TRANS", 1);
      Rnv = new k("MODE_CANCEL", 2);
      Rnw = new k[] { Rnt, Rnu, Rnv };
      AppMethodBeat.o(31568);
    }
    
    private k() {}
  }
  
  static enum l
  {
    static
    {
      AppMethodBeat.i(31571);
      Rnx = new l("MODE_HINT_INVALID", 0);
      Rny = new l("MODE_HINT_1", 1);
      Rnz = new l("MODE_HINT_2", 2);
      RnA = new l[] { Rnx, Rny, Rnz };
      AppMethodBeat.o(31571);
    }
    
    private l() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter
 * JD-Core Version:    0.7.0.1
 */