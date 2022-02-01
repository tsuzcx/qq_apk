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
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
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
import android.view.View.OnLongClickListener;
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
import com.tencent.mm.ak.t;
import com.tencent.mm.api.ad;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.g.b.a.lj;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.ui.d.b;
import com.tencent.mm.plugin.groupsolitaire.ui.d.c;
import com.tencent.mm.plugin.groupsolitaire.ui.d.d;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.4;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout.a;
import com.tencent.mm.plugin.transvoice.ui.SoundWaveView;
import com.tencent.mm.plugin.transvoice.ui.SoundWaveView.d;
import com.tencent.mm.plugin.transvoice.ui.b.d;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.egj;
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
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.chatting.d.ab.a;
import com.tencent.mm.ui.chatting.d.ab.c;
import com.tencent.mm.ui.chatting.d.b.r;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
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
import kotlin.g.b.z.f;

public class ChatFooter
  extends FrameLayout
  implements com.tencent.mm.plugin.websearch.a.a.a, h.a, com.tencent.mm.ui.tools.g
{
  private static com.tencent.mm.plugin.websearch.a.a.c KiM;
  private static int KjB;
  public static final String KlG;
  private static final int[] Klv;
  private static final int[] Klw;
  private static int count;
  private final long ANIMATION_DURATION;
  public com.tencent.mm.ui.widget.cedit.api.c ECK;
  public com.tencent.mm.ui.base.p FQS;
  private TextView FQT;
  private ImageView FQU;
  public View FQV;
  private int GtE;
  com.tencent.mm.plugin.transvoice.a.b GvE;
  private String GvJ;
  private int GvK;
  private MTimerHandler GvL;
  private boolean GvM;
  private MMHandler GvO;
  private com.tencent.mm.modelvoiceaddr.b.b GvX;
  private List<String> GvY;
  private int GyD;
  private int IFI;
  f KbA;
  public n Kdp;
  public boolean Kds;
  private i KiA;
  public m KiB;
  private com.tencent.mm.plugin.groupsolitaire.ui.d KiC;
  private b KiD;
  private g KiE;
  private f KiF;
  public final a KiG;
  public boolean KiH;
  private boolean KiI;
  public boolean KiJ;
  private boolean KiK;
  private ImageView KiL;
  public ViewGroup KiN;
  private TextView KiO;
  private View KiP;
  private InputMethodManager KiQ;
  private int KiR;
  private boolean KiS;
  private boolean KiT;
  private boolean KiU;
  public boolean KiV;
  public boolean KiW;
  private boolean KiX;
  public int KiY;
  private int KiZ;
  public String Kij;
  public AppPanel Kik;
  public TextView Kil;
  private Button Kim;
  public ImageButton Kin;
  private View Kio;
  public ChatFooterBottom Kip;
  private TextView Kiq;
  public ImageButton Kir;
  public ImageView Kis;
  public ImageButton Kit;
  public MaxHeightScrollView Kiu;
  private com.tencent.mm.ui.widget.a.d Kiv;
  public LinearLayout Kiw;
  public RelativeLayout Kix;
  private TextView Kiy;
  private WeImageView Kiz;
  private Animation KjA;
  public ViewGroup KjC;
  private View KjD;
  private BlurView KjE;
  private View KjF;
  private View KjG;
  private ImageView KjH;
  private ImageView KjI;
  private View KjJ;
  private TextView KjK;
  private ImageView KjL;
  private View KjM;
  private View KjN;
  private WeImageView KjO;
  private TextView KjP;
  private View KjQ;
  private WeImageView KjR;
  private TextView KjS;
  private View KjT;
  private BlurView KjU;
  private com.tencent.mm.plugin.transvoice.ui.b KjV;
  private com.tencent.mm.plugin.transvoice.a.a KjW;
  private com.tencent.mm.modelvoiceaddr.h KjX;
  public com.tencent.mm.ui.base.p KjY;
  private com.tencent.mm.plugin.transvoice.a.c KjZ;
  private ChattingScrollLayout Kja;
  private boolean Kjb;
  private int Kjc;
  private int Kjd;
  private boolean Kje;
  public boolean Kjf;
  private boolean Kjg;
  private int Kjh;
  private boolean Kji;
  private int Kjj;
  private int Kjk;
  private int Kjl;
  private int Kjm;
  private boolean Kjn;
  private String Kjo;
  private ab.c Kjp;
  private ab.a Kjq;
  private d.c Kjr;
  com.tencent.mm.g.b.a.j Kjs;
  public c Kjt;
  public d Kju;
  private m.a Kjv;
  private boolean Kjw;
  public MMFragment Kjx;
  public b Kjy;
  private Animation Kjz;
  private WeImageView KkA;
  private View KkB;
  private View KkC;
  private ViewGroup KkD;
  private View KkE;
  private View KkF;
  private WeImageView KkG;
  private WeImageView KkH;
  private View KkI;
  private View KkJ;
  private WeImageView KkK;
  private ViewGroup KkL;
  private View KkM;
  private View KkN;
  private View KkO;
  private WeImageView KkP;
  private View KkQ;
  private int KkR;
  private int KkS;
  private boolean KkT;
  private ChatFooterPanel.a KkU;
  private AppPanel.b KkV;
  private b KkW;
  public i KkX;
  private int KkY;
  private boolean KkZ;
  private l Kka;
  private j Kkb;
  private k Kkc;
  private boolean Kkd;
  private boolean Kke;
  public boolean Kkf;
  private float Kkg;
  private com.tencent.mm.ui.base.p Kkh;
  private View Kki;
  private View Kkj;
  private ViewGroup Kkk;
  private EditText Kkl;
  private SoundWaveView Kkm;
  private ImageView Kkn;
  private ViewGroup Kko;
  private TextView Kkp;
  private WeImageView Kkq;
  public LanguageChoiceLayout Kkr;
  private TextView Kks;
  private ViewGroup Kkt;
  private TextView Kku;
  private ViewGroup Kkv;
  private ViewGroup Kkw;
  private View Kkx;
  private View Kky;
  private WeImageView Kkz;
  private final int KlA;
  private volatile boolean KlB;
  private MMHandler KlC;
  private boolean KlD;
  private int KlE;
  private boolean KlF;
  private int KlH;
  private View KlI;
  private int KlJ;
  private int KlK;
  private int KlL;
  private int KlM;
  private int KlN;
  private int KlO;
  private Runnable KlP;
  private Runnable KlQ;
  private int KlR;
  private int KlS;
  e KlT;
  e KlU;
  private Map<Integer, String> KlV;
  private boolean KlW;
  private int Kla;
  private TextWatcher Klb;
  ValueAnimator Klc;
  ValueAnimator Kld;
  ValueAnimator Kle;
  ValueAnimator Klf;
  ValueAnimator Klg;
  ValueAnimator.AnimatorUpdateListener Klh;
  private int[] Kli;
  private final int Klj;
  private final int Klk;
  private final int Kll;
  private final int Klm;
  private final int Kln;
  private final int Klo;
  private final float Klp;
  private int Klq;
  private int Klr;
  private int Kls;
  private int Klt;
  private int Klu;
  private int Klx;
  private boolean Kly;
  private final int Klz;
  private Activity activity;
  private String dRL;
  private boolean gYo;
  private com.tencent.mm.ui.tools.h gyh;
  public Button han;
  private ViewGroup jLy;
  private View jxm;
  public final MMHandler mHandler;
  private String mSessionId;
  private int maxHeight;
  private int oXi;
  private boolean qPk;
  private final MMHandler qPx;
  public ChatFooterPanel rum;
  public View teZ;
  private ImageView tfa;
  public View tfb;
  public View tfc;
  private String toUser;
  private boolean wxq;
  public boolean xfU;
  
  static
  {
    AppMethodBeat.i(31717);
    count = 0;
    Klv = new int[] { 0, 15, 30, 45, 60, 75, 90, 95, 100 };
    Klw = new int[] { 2131689550, 2131689551, 2131689552, 2131689553, 2131689554, 2131689555, 2131689556, 2131689557 };
    KlG = MMApplicationContext.getPackageName() + "chat_footer_sp";
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
    this.jxm = null;
    this.ECK = null;
    this.han = null;
    this.Kil = null;
    this.KiE = null;
    this.KiF = null;
    this.KiG = new a((byte)0);
    this.KiH = false;
    this.KiI = false;
    this.KiJ = false;
    this.KiK = false;
    this.qPk = false;
    this.KiT = false;
    this.KiU = false;
    this.KiV = false;
    this.Kds = false;
    this.KiW = false;
    this.KiX = true;
    this.wxq = false;
    this.KiY = 0;
    this.KiZ = -1;
    this.Kjd = 0;
    this.xfU = false;
    this.Kje = false;
    this.Kjf = true;
    this.Kjg = false;
    this.Kjh = 0;
    this.Kji = false;
    this.Kjn = false;
    this.Kjo = com.tencent.mm.plugin.fts.a.d.Nj(73);
    this.mSessionId = com.tencent.mm.plugin.fts.a.d.Nj(73);
    this.Kjp = null;
    this.Kjq = new ab.a()
    {
      public final void hide()
      {
        AppMethodBeat.i(184906);
        if (ChatFooter.a(ChatFooter.this) != null) {
          ChatFooter.a(ChatFooter.this).setBackgroundResource(2131233330);
        }
        AppMethodBeat.o(184906);
      }
      
      public final void show()
      {
        AppMethodBeat.i(184905);
        if (ChatFooter.a(ChatFooter.this) != null) {
          ChatFooter.a(ChatFooter.this).setBackgroundResource(2131233331);
        }
        AppMethodBeat.o(184905);
      }
    };
    this.Kjr = new d.c()
    {
      public final int dYg()
      {
        AppMethodBeat.i(185759);
        if (ChatFooter.b(ChatFooter.this) != null)
        {
          int i = ChatFooter.b(ChatFooter.this).dYg();
          AppMethodBeat.o(185759);
          return i;
        }
        AppMethodBeat.o(185759);
        return 0;
      }
      
      public final boolean dYh()
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
    this.Kjs = new com.tencent.mm.g.b.a.j();
    this.Kjv = new m.a()
    {
      public final void clear()
      {
        AppMethodBeat.i(185778);
        ChatFooter.this.dYi();
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
    this.Kjw = false;
    this.gYo = false;
    paramAttributeSet = com.tencent.mm.plugin.transvoice.a.c.Guc;
    this.KjZ = com.tencent.mm.plugin.transvoice.a.c.fAu();
    this.Kka = l.KmL;
    this.Kkb = j.KmD;
    this.Kkc = k.KmH;
    this.Kkd = false;
    this.Kke = false;
    this.Kkf = false;
    this.Kkg = 0.5F;
    this.KkT = true;
    this.KkU = new ChatFooterPanel.a()
    {
      public final void aHC()
      {
        AppMethodBeat.i(232243);
        ChatFooter.as(ChatFooter.this);
        ChatFooter.aw(ChatFooter.this);
        ChatFooter.A(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.av(ChatFooter.this);
        InputConnection localInputConnection = ChatFooter.d(ChatFooter.this).getInputConnection();
        if (localInputConnection != null)
        {
          localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
          localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
        }
        ChatFooter.this.Kjs.ekh -= 1L;
        AppMethodBeat.o(232243);
      }
      
      public final void aHD()
      {
        AppMethodBeat.i(232241);
        ChatFooter.as(ChatFooter.this);
        ChatFooter.at(ChatFooter.this).setVisibility(0);
        ChatFooter.au(ChatFooter.this).setVisibility(0);
        ChatFooter.A(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.av(ChatFooter.this);
        if (ChatFooter.k(ChatFooter.this) != null) {
          ChatFooter.k(ChatFooter.this).performClick();
        }
        AppMethodBeat.o(232241);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(232244);
        ChatFooter.as(ChatFooter.this);
        ChatFooter.aw(ChatFooter.this);
        ChatFooter.A(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.av(ChatFooter.this);
        try
        {
          ChatFooter.d(ChatFooter.this).bol(paramAnonymousString);
          ChatFooter.this.Kjs.ekh += 1L;
          AppMethodBeat.o(232244);
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
      
      public final void eP(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(232242);
        Log.i("MicroMsg.ChatFooter", "onToSendTextEnable: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        ChatFooter.as(ChatFooter.this);
        ChatFooter.aw(ChatFooter.this);
        ChatFooter.A(ChatFooter.this).setVisibility(8);
        ChatFooter.av(ChatFooter.this);
        if (ChatFooter.d(ChatFooter.this) != null) {
          ChatFooter.this.setToSendTextColor(paramAnonymousBoolean);
        }
        AppMethodBeat.o(232242);
      }
    };
    this.KkV = new AppPanel.b()
    {
      public final void gqc()
      {
        AppMethodBeat.i(232245);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ChatFooter.e(ChatFooter.this), "android.permission.RECORD_AUDIO", 80, "", "");
        Log.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), ChatFooter.e(ChatFooter.this) });
        if (!bool)
        {
          AppMethodBeat.o(232245);
          return;
        }
        int i = bg.azz().aYS();
        if ((i == 4) || (i == 6))
        {
          ChatFooter.ax(ChatFooter.this);
          AppMethodBeat.o(232245);
          return;
        }
        if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
          ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.h.n(ChatFooter.this.getContext(), 2131767334, 2131755998));
        }
        AppMethodBeat.o(232245);
      }
    };
    this.KkW = new b()
    {
      public final String getTalkerUserName()
      {
        AppMethodBeat.i(232246);
        if (ChatFooter.f(ChatFooter.this) == null)
        {
          str = ChatFooter.q(ChatFooter.this);
          AppMethodBeat.o(232246);
          return str;
        }
        String str = ChatFooter.f(ChatFooter.this).getTalkerUserName();
        AppMethodBeat.o(232246);
        return str;
      }
      
      public final com.tencent.mm.ui.chatting.i.b grp()
      {
        return null;
      }
      
      public final com.tencent.mm.ui.chatting.e.a grq()
      {
        return null;
      }
    };
    this.qPx = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(232250);
        super.handleMessage(paramAnonymousMessage);
        Log.d("MicroMsg.ChatFooter", "pennqin, dismiss window by too short.");
        ChatFooter.A(ChatFooter.this).setBackgroundResource(2131233164);
        ChatFooter.A(ChatFooter.this).setEnabled(true);
        if (ChatFooter.this.Kkf)
        {
          ChatFooter.K(ChatFooter.this);
          u.u(ChatFooter.this.getContext(), ChatFooter.this.getContext().getResources().getString(2131757297), 2131691713);
          AppMethodBeat.o(232250);
          return;
        }
        if (ChatFooter.L(ChatFooter.this) != null) {
          ChatFooter.L(ChatFooter.this).dismiss();
        }
        AppMethodBeat.o(232250);
      }
    };
    this.KkY = 0;
    this.KkZ = false;
    this.Kla = 1;
    this.Klb = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(232251);
        int i;
        int j;
        int m;
        int k;
        if (paramAnonymousEditable != null)
        {
          i = ChatFooter.aA(ChatFooter.this).getWidth();
          j = ChatFooter.aB(ChatFooter.this).getLineCount();
          m = j - ChatFooter.aC(ChatFooter.this);
          if ((m != 0) && (ChatFooter.this.KlT == ChatFooter.e.Kmr) && (i == ChatFooter.aD(ChatFooter.this)))
          {
            i = at.fromDPToPix(ChatFooter.this.getContext(), 5);
            k = ChatFooter.aB(ChatFooter.this).getLineHeight() * m;
            if (m <= 0) {
              break label251;
            }
            m = ChatFooter.aA(ChatFooter.this).getHeight();
            if (!ChatFooter.this.xfU) {
              break label257;
            }
            ChatFooter.c(ChatFooter.this, Math.min(Math.max(ChatFooter.aE(ChatFooter.this), i + (m + k)), ChatFooter.aF(ChatFooter.this)));
          }
        }
        for (;;)
        {
          Log.d("MicroMsg.ChatFooter", "afterTextChanged transHeight:%s, nowLineCount:%s, lastLineCount:%s", new Object[] { Integer.valueOf(ChatFooter.aH(ChatFooter.this)), Integer.valueOf(j), Integer.valueOf(ChatFooter.aC(ChatFooter.this)) });
          ChatFooter.aI(ChatFooter.this);
          ChatFooter.d(ChatFooter.this, j);
          if (1 == ChatFooter.C(ChatFooter.this).Gua) {
            ChatFooter.C(ChatFooter.this).GtZ = 1;
          }
          AppMethodBeat.o(232251);
          return;
          label251:
          i = -i;
          break;
          label257:
          ChatFooter.c(ChatFooter.this, Math.min(Math.max(ChatFooter.aE(ChatFooter.this), i + (m + k)), ChatFooter.aG(ChatFooter.this)));
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.Klc = ValueAnimator.ofInt(new int[] { 250, 960 }).setDuration(200L);
    this.Kld = ValueAnimator.ofInt(new int[] { 40, 800 }).setDuration(200L);
    this.Kle = ValueAnimator.ofInt(new int[] { 72, 0 }).setDuration(200L);
    this.Klf = ValueAnimator.ofInt(new int[] { 22, 0 }).setDuration(200L);
    this.Klg = ValueAnimator.ofInt(new int[] { 8, 0 }).setDuration(200L);
    this.Klh = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(232261);
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)ChatFooter.bg(ChatFooter.this).getLayoutParams();
        FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)ChatFooter.bh(ChatFooter.this).getLayoutParams();
        if (ChatFooter.this.Klc == paramAnonymousValueAnimator)
        {
          localLayoutParams1.width = at.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          localLayoutParams2.width = at.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        }
        for (;;)
        {
          ChatFooter.bg(ChatFooter.this).setLayoutParams(localLayoutParams1);
          ChatFooter.bh(ChatFooter.this).setLayoutParams(localLayoutParams2);
          AppMethodBeat.o(232261);
          return;
          if (ChatFooter.this.Kld == paramAnonymousValueAnimator)
          {
            localLayoutParams1.height = at.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.height = at.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Kle == paramAnonymousValueAnimator)
          {
            localLayoutParams1.topMargin = at.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.topMargin = at.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Klf == paramAnonymousValueAnimator)
          {
            localLayoutParams1.rightMargin = at.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.rightMargin = at.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Klg == paramAnonymousValueAnimator)
          {
            localLayoutParams1.bottomMargin = at.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.bottomMargin = at.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        }
      }
    };
    this.Kli = new int[] { 2131690025, 2131690026, 2131690027, 2131690028, 2131690029, 2131690030, 2131690031, 2131690032, 2131690033, 2131690034 };
    this.ANIMATION_DURATION = 200L;
    this.Klj = 60;
    this.Klk = at.fromDPToPix(getContext(), 114);
    this.Kll = (au.az(getContext()).x - at.fromDPToPix(getContext(), 32));
    this.Klm = at.fromDPToPix(getContext(), 92);
    this.Kln = Math.min(at.fromDPToPix(getContext(), 320), au.az(getContext()).x - at.fromDPToPix(getContext(), 32));
    this.Klo = at.fromDPToPix(getContext(), 176);
    this.Klp = (at.fromDPToPix(getContext(), 160) / 50.0F);
    this.Klq = at.fromDPToPix(getContext(), 114);
    this.maxHeight = 0;
    this.Klr = 0;
    this.Kls = 0;
    this.GyD = 0;
    this.Klt = at.fromDPToPix(getContext(), 176);
    this.Klu = 60;
    this.Klx = 0;
    this.Kly = false;
    this.Klz = 4097;
    this.KlA = 4098;
    this.KlC = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(232270);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(232270);
          return;
          ChatFooter.i(ChatFooter.this, true);
          paramAnonymousMessage = ChatFooter.bt(ChatFooter.this).getLayoutParams();
          int i = ChatFooter.bt(ChatFooter.this).getBottom() - ChatFooter.bt(ChatFooter.this).getTop();
          if (ChatFooter.this.gqJ())
          {
            if (ChatFooter.y(ChatFooter.this) != null) {
              ChatFooter.y(ChatFooter.this).setVisibility(8);
            }
            ChatFooter.this.setAppPanelVisible(8);
            ChatFooter.bt(ChatFooter.this).setVisibility(4);
          }
          if (i <= 3)
          {
            ChatFooter.i(ChatFooter.this, false);
            ChatFooter.bt(ChatFooter.this).setVisibility(4);
            ChatFooter.i(ChatFooter.this, ChatFooter.this.getKeyBordHeightPX());
            AppMethodBeat.o(232270);
            return;
          }
          paramAnonymousMessage.height = Math.max(i - 60, 1);
          Log.e("MicroMsg.ChatFooter", "mBottomPanelAnim:bottomPanel height:" + paramAnonymousMessage.height);
          ChatFooter.bt(ChatFooter.this).setLayoutParams(paramAnonymousMessage);
          ChatFooter.bu(ChatFooter.this);
        }
      }
    };
    this.KlD = false;
    this.KlE = 0;
    this.KlF = false;
    this.KlH = -1;
    this.KlI = null;
    this.KlJ = at.aH(getContext(), 2131165232);
    this.KlK = at.aH(getContext(), 2131165303);
    this.KlL = at.fromDPToPix(getContext(), 25);
    this.KlM = at.fromDPToPix(getContext(), 55);
    this.KlN = 0;
    this.KlO = at.fromDPToPix(getContext(), 50);
    this.KlP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185390);
        ChatFooter.this.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(232280);
            if (ChatFooter.k.KmJ == ChatFooter.al(ChatFooter.this))
            {
              ChatFooter.ae(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131767146));
              ChatFooter.ao(ChatFooter.this);
            }
            for (;;)
            {
              ChatFooter.by(ChatFooter.this);
              AppMethodBeat.o(232280);
              return;
              ChatFooter.ae(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131767150));
              ChatFooter.am(ChatFooter.this);
            }
          }
        }, 100L);
        AppMethodBeat.o(185390);
      }
    };
    this.KlQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185811);
        ChatFooter.M(ChatFooter.this).dismiss();
        AppMethodBeat.o(185811);
      }
    };
    this.KlR = at.fromDPToPix(getContext(), 16);
    this.KlS = at.fromDPToPix(getContext(), 25);
    this.KlT = e.Kmp;
    this.KlU = this.KlT;
    this.KlV = new HashMap();
    this.KlW = false;
    this.GvX = new com.tencent.mm.modelvoiceaddr.b.b();
    this.GvY = new ArrayList();
    this.GvJ = "";
    this.GvK = 0;
    this.GvM = false;
    this.GtE = com.tencent.mm.modelvoiceaddr.g.jwq;
    long l = System.currentTimeMillis();
    this.KiQ = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.jxm = inflate(paramContext, 2131493491, this);
    this.ECK = ((com.tencent.mm.ui.widget.cedit.api.c)findViewById(2131298415));
    this.ECK.refresh(((PluginWebSearch)com.tencent.mm.kernel.g.ah(PluginWebSearch.class)).isUseSysEditText());
    this.gyh = new com.tencent.mm.ui.tools.h((Activity)paramContext);
    this.gyh.Quk = this;
    if (com.tencent.mm.ui.ao.gJI()) {
      this.ECK.setImeOptions(268435456);
    }
    paramAttributeSet = com.tencent.mm.ui.widget.cedit.api.d.a(this.ECK);
    paramInt = 8192;
    if (com.tencent.mm.kernel.g.aAc()) {
      paramInt = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("InputLimitSessionTextMsg"), 8192);
    }
    paramAttributeSet.aoq(paramInt * 2).a(null);
    this.ECK.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
    paramAttributeSet = new a.e()
    {
      public final void A(List<a.c> paramAnonymousList, int paramAnonymousInt)
      {
        AppMethodBeat.i(232223);
        long l = cl.aWB();
        if ((paramAnonymousInt != 8) && (paramAnonymousInt != 1))
        {
          if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineC2CTag())
          {
            localChatFooter = ChatFooter.this;
            if ((localChatFooter.Kjy == null) || (localChatFooter.Kjy.grq() == null) || ((!((com.tencent.mm.ui.chatting.d.b.h)localChatFooter.Kjy.grq().bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu()) && (!((com.tencent.mm.ui.chatting.d.b.i)localChatFooter.Kjy.grq().bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw()))) {
              break label377;
            }
            paramAnonymousInt = 0;
            if (paramAnonymousInt != 0)
            {
              paramAnonymousList.add(new a.c(paramContext.getString(2131766606), 2));
              ChatFooter.d(ChatFooter.this).gYG();
              if (!ab.Eq(ChatFooter.q(ChatFooter.this))) {
                break label382;
              }
              paramAnonymousInt = 2;
              label174:
              com.tencent.mm.plugin.websearch.a.b.a(paramAnonymousInt, ChatFooter.q(ChatFooter.this), ChatFooter.r(ChatFooter.this), 1, "", ChatFooter.s(ChatFooter.this), 1, l);
            }
          }
          ChatFooter localChatFooter = ChatFooter.this;
          if ((localChatFooter.Kjy == null) || (localChatFooter.Kjy.grq() == null) || ((!((com.tencent.mm.ui.chatting.d.b.h)localChatFooter.Kjy.grq().bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu()) && (!((com.tencent.mm.ui.chatting.d.b.i)localChatFooter.Kjy.grq().bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw()))) {
            break label387;
          }
          paramAnonymousInt = 0;
          label285:
          if (paramAnonymousInt != 0)
          {
            paramAnonymousList.add(new a.c(paramContext.getString(2131759440), 3));
            ChatFooter.d(ChatFooter.this).gYG();
            if (!ab.Eq(ChatFooter.q(ChatFooter.this))) {
              break label392;
            }
          }
        }
        label387:
        label392:
        for (paramAnonymousInt = 2;; paramAnonymousInt = 1)
        {
          com.tencent.mm.plugin.websearch.a.b.a(paramAnonymousInt, ChatFooter.q(ChatFooter.this), ChatFooter.r(ChatFooter.this), 1, "", ChatFooter.s(ChatFooter.this), 2, l);
          AppMethodBeat.o(232223);
          return;
          label377:
          paramAnonymousInt = 1;
          break;
          label382:
          paramAnonymousInt = 1;
          break label174;
          paramAnonymousInt = 1;
          break label285;
        }
      }
      
      public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
      {
        AppMethodBeat.i(232224);
        long l2 = cl.aWB();
        if (paramAnonymousc.id == 2)
        {
          ChatFooter.d(ChatFooter.this).getText().insert(ChatFooter.d(ChatFooter.this).getSelectionStart(), paramContext.getString(2131766606));
          ChatFooter.d(ChatFooter.this).gYG();
          if (ab.Eq(ChatFooter.q(ChatFooter.this))) {}
          for (i = 2;; i = 1)
          {
            com.tencent.mm.plugin.websearch.a.b.a(i, ChatFooter.q(ChatFooter.this), ChatFooter.r(ChatFooter.this), 2, "", ChatFooter.s(ChatFooter.this), 1, l2);
            AppMethodBeat.o(232224);
            return;
          }
        }
        long l1;
        if (paramAnonymousc.id == 3)
        {
          ChatFooter.d(ChatFooter.this).clearFocus();
          ChatFooter.t(ChatFooter.this);
          paramAnonymousView = ChatFooter.d(ChatFooter.this).getText().toString();
          paramAnonymousc = com.tencent.mm.plugin.websearch.a.c.IFY;
          Object localObject1 = ChatFooter.this.getContext();
          paramAnonymousc = ChatFooter.q(ChatFooter.this);
          Object localObject2 = ChatFooter.this;
          paramAnonymousString = ChatFooter.s(ChatFooter.this);
          i = ChatFooter.d(ChatFooter.this).getSelectionStart();
          kotlin.g.b.p.h(localObject1, "context");
          kotlin.g.b.p.h(paramAnonymousc, "talker");
          kotlin.g.b.p.h(localObject2, "listener");
          kotlin.g.b.p.h(paramAnonymousView, "query");
          kotlin.g.b.p.h(paramAnonymousString, "sessionId");
          z.f localf = new z.f();
          localf.SYG = new egj();
          HashMap localHashMap = new HashMap();
          ((Map)localHashMap).put("scene", "72");
          ((Map)localHashMap).put("sessionId", paramAnonymousString);
          ((Map)localHashMap).put("subSessionId", paramAnonymousString);
          ((Map)localHashMap).put("isHomePage", "1");
          if (!TextUtils.isEmpty((CharSequence)paramAnonymousView))
          {
            Map localMap = (Map)localHashMap;
            String str = q.encode(paramAnonymousView, "utf8");
            kotlin.g.b.p.g(str, "URLEncoder.encode(query, \"utf8\")");
            localMap.put("query", str);
            ((Map)localHashMap).put("cursorIndex", String.valueOf(i));
          }
          com.tencent.mm.plugin.websearch.a.c.bg((Map)localHashMap);
          ((egj)localf.SYG).url = com.tencent.mm.plugin.websearch.a.c.bf((Map)localHashMap);
          ((egj)localf.SYG).talker = paramAnonymousc;
          ((egj)localf.SYG).sessionId = paramAnonymousString;
          ((egj)localf.SYG).scene = 72;
          ((egj)localf.SYG).dDv = "";
          ((egj)localf.SYG).hes = "";
          ((egj)localf.SYG).vkj = 2;
          localObject2 = new com.tencent.mm.plugin.websearch.a.c.a((com.tencent.mm.plugin.websearch.a.a.a)localObject2, localf, paramAnonymousc, paramAnonymousString);
          localObject1 = new com.tencent.mm.plugin.websearch.a.a.c((Context)localObject1, (egj)localf.SYG, (com.tencent.mm.plugin.websearch.a.a.a)localObject2);
          ((com.tencent.mm.plugin.websearch.a.a.c)localObject1).show();
          localObject2 = ((com.tencent.mm.plugin.websearch.a.a.c)localObject1).getWindow();
          if (localObject2 != null) {
            ((Window)localObject2).setLayout(-1, -1);
          }
          localObject2 = new lj();
          ((lj)localObject2).enl = 1L;
          ((lj)localObject2).eYC = 0L;
          ((lj)localObject2).eYD = 2L;
          ((lj)localObject2).eEP = cl.aWB();
          if (!ab.Eq(paramAnonymousc)) {
            break label781;
          }
          l1 = 2L;
          ((lj)localObject2).etp = l1;
          ((lj)localObject2).yD(paramAnonymousc);
          ((lj)localObject2).yE(paramAnonymousString);
          ((lj)localObject2).yF(paramAnonymousView);
          ((lj)localObject2).bfK();
          com.tencent.mm.plugin.websearch.api.ar.a((com.tencent.mm.plugin.report.a)localObject2);
          Log.i(com.tencent.mm.plugin.websearch.a.c.TAG, "startTagSearchDialog url:" + ((egj)localf.SYG).url);
          ChatFooter.e((com.tencent.mm.plugin.websearch.a.a.c)localObject1);
          ChatFooter.d(ChatFooter.this).gYG();
          if (!ab.Eq(ChatFooter.q(ChatFooter.this))) {
            break label787;
          }
        }
        label781:
        label787:
        for (int i = 2;; i = 1)
        {
          com.tencent.mm.plugin.websearch.a.b.a(i, ChatFooter.q(ChatFooter.this), ChatFooter.r(ChatFooter.this), 2, paramAnonymousView, ChatFooter.s(ChatFooter.this), 2, l2);
          ChatFooter.c(ChatFooter.this, com.tencent.mm.plugin.fts.a.d.Nj(73));
          AppMethodBeat.o(232224);
          return;
          l1 = 1L;
          break;
        }
      }
    };
    this.ECK.a(((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(paramContext), paramAttributeSet);
    this.ECK.setKeyCodeEnterListener(new MMEditText.d()
    {
      private long INI = 0L;
      
      public final boolean aiD(int paramAnonymousInt)
      {
        AppMethodBeat.i(232225);
        if ((paramAnonymousInt == 66) && (cl.aWA() - this.INI > 1000L) && (com.tencent.mm.ui.ao.gJN()) && (com.tencent.mm.ui.aw.b(com.tencent.mm.ui.aw.gWy(), ChatFooter.e(ChatFooter.this).getTaskId())))
        {
          Log.i("MicroMsg.ChatFooter", "KeyCode Enter");
          this.INI = cl.aWA();
          ChatFooter.k(ChatFooter.this).performClick();
          AppMethodBeat.o(232225);
          return true;
        }
        AppMethodBeat.o(232225);
        return false;
      }
    });
    this.ECK.addTextChangedListener(new TextWatcher()
    {
      private List<ForegroundColorSpan> EDf;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(232227);
        paramAnonymousEditable = ChatFooter.d(ChatFooter.this).getText();
        Object localObject = this.EDf.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramAnonymousEditable.removeSpan((ForegroundColorSpan)((Iterator)localObject).next());
        }
        this.EDf.clear();
        localObject = ChatFooter.d(ChatFooter.this).getText().toString();
        if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineC2CTag())
        {
          localObject = k.a.Krb.matcher((CharSequence)localObject);
          while (((Matcher)localObject).find())
          {
            int i = ((Matcher)localObject).start();
            int j = ((Matcher)localObject).end();
            ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(ChatFooter.this.getResources().getColor(2131099784));
            this.EDf.add(localForegroundColorSpan);
            paramAnonymousEditable.setSpan(localForegroundColorSpan, i, j, 33);
          }
        }
        AppMethodBeat.o(232227);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (KiM != null)
    {
      KiM.dismiss();
      KiM = null;
    }
    paramAttributeSet = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(232284);
        Log.i("MicroMsg.ChatFooter", "onFocusChange: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(232284);
      }
    };
    this.ECK.setOnFocusChangeListener(paramAttributeSet);
    if (Build.VERSION.SDK_INT == 28) {
      this.ECK.setBreakStrategy(1);
    }
    paramAttributeSet = new rk();
    paramAttributeSet.dXZ.dYa = new com.tencent.mm.pluginsdk.ui.a.a()
    {
      public final void beB(final String paramAnonymousString)
      {
        AppMethodBeat.i(185818);
        Log.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", new Object[] { paramAnonymousString });
        if ((Util.isNullOrNil(ChatFooter.f(ChatFooter.this).getTalkerUserName())) || (Util.isNullOrNil(paramAnonymousString)))
        {
          Log.e("MicroMsg.ChatFooter", "onImageReceived, error args");
          AppMethodBeat.o(185818);
          return;
        }
        com.tencent.mm.ui.base.h.a(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(2131758959), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    this.Kiw = ((LinearLayout)this.jxm.findViewById(2131308991));
    this.Kiu = ((MaxHeightScrollView)this.jxm.findViewById(2131309006));
    this.ECK.setMaxHeight(this.Kiu.getMaxHeight() - this.Kiu.getPaddingBottom() - this.Kiu.getPaddingTop());
    this.Kip = ((ChatFooterBottom)findViewById(2131298409));
    this.jLy = ((ViewGroup)findViewById(2131298293));
    this.Kio = findViewById(2131298434);
    this.Kir = ((ImageButton)this.jxm.findViewById(2131298395));
    this.Kis = ((ImageView)this.jxm.findViewById(2131298396));
    this.han = ((Button)this.jxm.findViewById(2131298547));
    this.Kix = ((RelativeLayout)this.jxm.findViewById(2131304970));
    this.Kiy = ((TextView)this.jxm.findViewById(2131304968));
    this.Kiz = ((WeImageView)this.jxm.findViewById(2131304969));
    this.KiL = ((ImageView)this.jxm.findViewById(2131306142));
    this.han.setTextSize(0, com.tencent.mm.cb.a.aH(paramContext, 2131165581) * com.tencent.mm.cb.a.ji(paramContext));
    this.Kim = ((Button)this.jxm.findViewById(2131309989));
    this.Kin = ((ImageButton)findViewById(2131298512));
    qT(false);
    gqS();
    this.KiA = new i(getContext(), getRootView(), this, new i.a()
    {
      public final void beZ(String paramAnonymousString)
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
          com.tencent.mm.br.c.a(ChatFooter.i(ChatFooter.this), "gallery", ".ui.GalleryEntryUI", localIntent, 217);
          AppMethodBeat.o(185752);
          return;
        }
        com.tencent.mm.br.c.b(paramContext, "gallery", ".ui.GalleryEntryUI", localIntent, 217);
        AppMethodBeat.o(185752);
      }
    });
    this.KiA.Knk = this;
    paramAttributeSet = getContext();
    getRootView();
    this.ECK.gYG();
    this.KiB = new m(paramAttributeSet);
    this.KiB.Kjv = this.Kjv;
    Log.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[] { Integer.valueOf(this.ECK.getImeOptions()) });
    this.ECK.a(new com.tencent.mm.ui.widget.cedit.api.c.a()
    {
      public final boolean ZY(int paramAnonymousInt)
      {
        AppMethodBeat.i(232222);
        if ((paramAnonymousInt == 4) || ((paramAnonymousInt == 0) && (ChatFooter.j(ChatFooter.this))))
        {
          ChatFooter.k(ChatFooter.this).performClick();
          AppMethodBeat.o(232222);
          return true;
        }
        AppMethodBeat.o(232222);
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
          ChatFooter.l(ChatFooter.this).X(paramAnonymousMotionEvent);
        }
        ChatFooter.m(ChatFooter.this);
        AppMethodBeat.o(185754);
        return false;
      }
    };
    this.ECK.setOnTouchListener(paramAttributeSet);
    paramAttributeSet = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185755);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        paramAnonymousView = ClipboardHelper.getText(paramContext);
        com.tencent.mm.plugin.report.service.h.CyF.n(1014L, 0L, 1L);
        com.tencent.mm.plugin.c.a.bqE();
        if (com.tencent.mm.plugin.c.a.D(paramAnonymousView))
        {
          com.tencent.mm.plugin.report.service.h.CyF.n(1014L, 1L, 1L);
          Log.i("MicroMsg.ChatFooter", "anti paste text %s", new Object[] { paramAnonymousView });
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(185755);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(185755);
        return false;
      }
    };
    this.ECK.setOnLongClickListener(paramAttributeSet);
    this.ECK.setCustomSelectionActionModeCallback(new ActionMode.Callback()
    {
      public final boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
      
      public final boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        AppMethodBeat.i(185756);
        paramAnonymousActionMode = ClipboardHelper.getText(paramContext);
        com.tencent.mm.plugin.report.service.h.CyF.n(1014L, 5L, 1L);
        com.tencent.mm.plugin.c.a.bqE();
        if (com.tencent.mm.plugin.c.a.D(paramAnonymousActionMode))
        {
          Log.i("MicroMsg.ChatFooter", "anti paste text %s", new Object[] { paramAnonymousActionMode });
          com.tencent.mm.plugin.report.service.h.CyF.n(1014L, 6L, 1L);
          if (paramAnonymousMenu.size() > 0)
          {
            paramAnonymousMenu.removeItem(16908322);
            if (com.tencent.mm.compatible.util.d.oD(23)) {
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
    this.han.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        for (;;)
        {
          boolean bool;
          label274:
          try
          {
            AppMethodBeat.i(31499);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            paramAnonymousView = ChatFooter.d(ChatFooter.this).getText().toString();
            Log.i("MicroMsg.ChatFooter", "send msg onClick");
            if ((paramAnonymousView.trim().length() == 0) && (paramAnonymousView.length() != 0))
            {
              Log.d("MicroMsg.ChatFooter", "empty message cant be sent");
              if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
                ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.h.n(ChatFooter.this.getContext(), 2131757358, 2131755998));
              }
              ChatFooter.this.gqP();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(31499);
              return;
            }
            ChatFooter.c(ChatFooter.this, false);
            if (TextUtils.equals(ChatFooter.d(ChatFooter.this).getText().toString(), ChatFooter.d(ChatFooter.this).getPasterContent()))
            {
              Log.i("MicroMsg.ChatFooter", "paste clip board to send");
              ChatFooter.c(ChatFooter.this, true);
              ChatFooter.d(ChatFooter.this, ClipboardHelper.isCopyFromWX(ChatFooter.d(ChatFooter.this).getText()));
            }
            if (ChatFooter.o(ChatFooter.this) == null) {
              break label344;
            }
            localObject = ChatFooter.o(ChatFooter.this);
            if (((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).ygD == null) {
              break label339;
            }
            bool = ((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).ygD.isShowing();
          }
          finally {}
          if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0) && (ChatFooter.l(ChatFooter.this) != null)) {
            ChatFooter.this.dYi();
          }
          ChatFooter.a(ChatFooter.this, paramAnonymousView.length());
          if (ChatFooter.a(ChatFooter.this, paramAnonymousView))
          {
            Log.i("MicroMsg.ChatFooter", "this is a quote msg");
            continue;
            label339:
            bool = false;
          }
          else
          {
            label344:
            while (!bool)
            {
              bool = false;
              break label274;
              if (ChatFooter.a(ChatFooter.this, paramAnonymousView, bool))
              {
                Log.i("MicroMsg.ChatFooter", "this is a group solitatire msg");
                break;
              }
              if ((ChatFooter.l(ChatFooter.this) == null) || (!ChatFooter.l(ChatFooter.this).aDN(paramAnonymousView))) {
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
    if (com.tencent.mm.ui.ao.gJH()) {}
    label2504:
    for (;;)
    {
      boolean bool = false;
      label1880:
      this.Kkf = bool;
      this.Kkg = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slX, 0.5F);
      Log.i("MicroMsg.ChatFooter", "isNewTrans2Txt:%s, transOperationAreaFactor:%s", new Object[] { Boolean.valueOf(this.Kkf), Float.valueOf(this.Kkg) });
      this.KjW = new com.tencent.mm.plugin.transvoice.a.a();
      if (this.Kkf)
      {
        this.KkS = ((int)(com.tencent.mm.cb.a.jn(paramContext) * this.Kkg));
        Log.d("MicroMsg.ChatFooter", "newVoice2txtVoiceModeChangeLine: %s, newVoice2txtTransModeChangeLine: %s.", new Object[] { Integer.valueOf(this.KkR), Integer.valueOf(this.KkS) });
        this.Kim.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(232234);
            if (paramAnonymousView != ChatFooter.A(ChatFooter.this))
            {
              AppMethodBeat.o(232234);
              return false;
            }
            if (ChatFooter.this.KlT == ChatFooter.e.Kmp)
            {
              ChatFooter.b(ChatFooter.this, au.az(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(2131167111) - av.aD(paramContext));
              switch (paramAnonymousMotionEvent.getAction())
              {
              }
            }
            for (;;)
            {
              AppMethodBeat.o(232234);
              return true;
              ChatFooter.b(ChatFooter.this, au.az(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(2131167111) - av.aD(paramContext) + ChatFooter.B(ChatFooter.this));
              break;
              ChatFooter.C(ChatFooter.this).GtX = 1;
              paramAnonymousView = com.tencent.mm.cj.a.Owq;
              com.tencent.mm.cj.a.AQ(false);
              ChatFooter.C(ChatFooter.this).ofl = System.currentTimeMillis();
              ChatFooter.C(ChatFooter.this).GtK = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.C(ChatFooter.this).GtL = ((int)paramAnonymousMotionEvent.getRawY());
              ChatFooter.a(ChatFooter.this, null);
              long l = System.nanoTime();
              ChatFooter.a(ChatFooter.this, new com.tencent.mm.modelvoiceaddr.h(String.valueOf(l & 0xFFFFFFFF)));
              ChatFooter.E(ChatFooter.this).b(ChatFooter.D(ChatFooter.this));
              if ((ChatFooter.this.getContext() instanceof Activity)) {
                ((Activity)ChatFooter.this.getContext()).getWindow().addFlags(128);
              }
              ChatFooter.A(ChatFooter.this).setBackgroundResource(2131234634);
              ChatFooter.A(ChatFooter.this).setText(2131757295);
              if (ChatFooter.l(ChatFooter.this) != null) {
                ChatFooter.l(ChatFooter.this).ehN();
              }
              ChatFooter.A(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757222));
              continue;
              if ((ChatFooter.F(ChatFooter.this) == null) || (!ChatFooter.F(ChatFooter.this).isShowing()))
              {
                Log.e("MicroMsg.NewVoice2txt", "window status err!!!");
              }
              else if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getX() < ChatFooter.A(ChatFooter.this).getWidth()) && (paramAnonymousMotionEvent.getRawY() > ChatFooter.G(ChatFooter.this)))
              {
                if (ChatFooter.this.KlT != ChatFooter.e.Kmp)
                {
                  ChatFooter.this.KlU = ChatFooter.this.KlT;
                  ChatFooter.this.KlT = ChatFooter.e.Kmp;
                  ChatFooter.H(ChatFooter.this);
                }
              }
              else if (paramAnonymousMotionEvent.getRawX() > ChatFooter.I(ChatFooter.this))
              {
                if (ChatFooter.e.Kmr != ChatFooter.this.KlT) {
                  if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(paramAnonymousView.getContext()))
                  {
                    ChatFooter.this.KlT = ChatFooter.e.Kmq;
                    ChatFooter.this.KlU = ChatFooter.this.KlT;
                    ChatFooter.H(ChatFooter.this);
                  }
                  else
                  {
                    ChatFooter.this.KlU = ChatFooter.this.KlT;
                    ChatFooter.this.KlT = ChatFooter.e.Kmr;
                    ChatFooter.H(ChatFooter.this);
                  }
                }
              }
              else if (ChatFooter.e.Kmq != ChatFooter.this.KlT)
              {
                ChatFooter.this.KlU = ChatFooter.this.KlT;
                ChatFooter.this.KlT = ChatFooter.e.Kmq;
                ChatFooter.H(ChatFooter.this);
                continue;
                Log.d("MicroMsg.NewVoice2txt", "begin finishCutShortSentence.");
                ChatFooter.E(ChatFooter.this).fAr();
                Log.d("MicroMsg.NewVoice2txt", "end finishCutShortSentence.");
                ChatFooter.C(ChatFooter.this).GtM = System.currentTimeMillis();
                ChatFooter.C(ChatFooter.this).GtN = ((int)paramAnonymousMotionEvent.getRawX());
                ChatFooter.C(ChatFooter.this).GtO = ((int)paramAnonymousMotionEvent.getRawY());
                if ((ChatFooter.this.GvE != null) && (ChatFooter.J(ChatFooter.this)))
                {
                  if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(paramAnonymousView.getContext()))
                  {
                    ChatFooter.A(ChatFooter.this).setBackgroundResource(2131233164);
                    ChatFooter.A(ChatFooter.this).setEnabled(true);
                    if (ChatFooter.this.Kkf) {
                      ChatFooter.K(ChatFooter.this);
                    }
                    if (ChatFooter.L(ChatFooter.this) == null) {
                      continue;
                    }
                    ChatFooter.L(ChatFooter.this).dismiss();
                    continue;
                  }
                  ChatFooter.this.GvE.GtF = false;
                  paramAnonymousView = ChatFooter.this.GvE;
                  Log.d("MicroMsg.SceneVoiceInputAddr2", "reTrigger!!! canReTrigger: %s.", new Object[] { Boolean.valueOf(paramAnonymousView.GtG) });
                  if ((paramAnonymousView.GtG) && ((!((com.tencent.mm.modelvoiceaddr.c)paramAnonymousView.jwn).bir()) || (!com.tencent.mm.kernel.g.azz().a(paramAnonymousView.jwn, 0)))) {
                    paramAnonymousView.fAt();
                  }
                }
                if ((ChatFooter.this.getContext() instanceof Activity)) {
                  ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                }
                ChatFooter.this.gqR();
              }
            }
          }
        });
        this.Klc.addUpdateListener(this.Klh);
        this.Kld.addUpdateListener(this.Klh);
        this.Kle.addUpdateListener(this.Klh);
        this.Klf.addUpdateListener(this.Klh);
        this.Klg.addUpdateListener(this.Klh);
      }
      for (;;)
      {
        this.Kin.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(232233);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            ChatFooter.z(ChatFooter.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(232233);
          }
        });
        gqn();
        this.Kir.setVisibility(0);
        this.Kir.setContentDescription(getContext().getString(2131757214));
        this.Kir.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = -1;
            AppMethodBeat.i(232231);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
            localObject1 = ChatFooter.u(ChatFooter.this);
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
                  if (((a.a)localObject2).KhR == 1)
                  {
                    k = j;
                    if (!ChatFooter.beY(((a.a)localObject2).KhQ))
                    {
                      localObject2 = ((a.a)localObject2).KhQ;
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
            localChatFooter.Kis.setVisibility(8);
            ((ImageButton)localObject1).setTag(Integer.valueOf(i));
            ChatFooter.this.go(paramAnonymousView);
            if ((z.aUQ().booleanValue()) && (ChatFooter.this.Kjt != null))
            {
              paramAnonymousView = ChatFooter.this.Kjt;
              localObject1 = Boolean.TRUE;
              paramAnonymousView.a((Boolean)localObject1, (Boolean)localObject1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(232231);
          }
        });
        Log.i("MicroMsg.ChatFooter", "[init]");
        this.Kio.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return true;
          }
        });
        this.Kjc = (((Activity)paramContext).getWindow().getAttributes().softInputMode & 0xF0);
        if ((this.Kjc != 16) && (this.Kjc != 48))
        {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1062, 8);
          if (this.Kjc != 16) {
            this.Kjc = 48;
          }
        }
        this.Kjk = KeyBoardUtil.getValidPanelHeight(paramContext);
        aiC(getKeyBordHeightPX());
        if (com.tencent.mm.compatible.util.d.oD(24)) {
          this.Kje = ((Activity)getContext()).isInMultiWindowMode();
        }
        gqm();
        this.Kiz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31502);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            ChatFooter.p(ChatFooter.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(31502);
          }
        });
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
          break label1880;
        }
        if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slW, 1)) {
          break label2504;
        }
        bool = true;
        break label1880;
        KjB = com.tencent.mm.cb.a.jn(paramContext) / 2 + com.tencent.mm.cb.a.fromDPToPix(paramContext, 30);
        this.KjV = new com.tencent.mm.plugin.transvoice.ui.b(paramContext);
        this.KjV.Gwa = new b.d()
        {
          public final void aTP(final String paramAnonymousString)
          {
            AppMethodBeat.i(232236);
            ChatFooter.this.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(31506);
                Log.i("MicroMsg.ChatFooter", "onTxtMsgSend, msg is null or nil? %s.", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramAnonymousString)) });
                if ((ChatFooter.l(ChatFooter.this) != null) && (!Util.isNullOrNil(paramAnonymousString))) {
                  ChatFooter.l(ChatFooter.this).aDN(paramAnonymousString);
                }
                AppMethodBeat.o(31506);
              }
            }, 200L);
            AppMethodBeat.o(232236);
          }
          
          public final void aTQ(String paramAnonymousString)
          {
            AppMethodBeat.i(232238);
            if (ChatFooter.l(ChatFooter.this) != null) {
              ChatFooter.l(ChatFooter.this).aDO(paramAnonymousString);
            }
            AppMethodBeat.o(232238);
          }
          
          public final boolean b(String paramAnonymousString, Long paramAnonymousLong)
          {
            AppMethodBeat.i(232237);
            Log.i("MicroMsg.ChatFooter", "onVoiceMsgSend, fileName: %s.", new Object[] { paramAnonymousString });
            if (paramAnonymousLong != null) {}
            for (int i = paramAnonymousLong.intValue();; i = 0)
            {
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                boolean bool = ChatFooter.l(ChatFooter.this).eu(paramAnonymousString, i);
                AppMethodBeat.o(232237);
                return bool;
              }
              AppMethodBeat.o(232237);
              return false;
            }
          }
          
          public final void fAI()
          {
            AppMethodBeat.i(232235);
            if (ChatFooter.M(ChatFooter.this).isShowing()) {
              ChatFooter.M(ChatFooter.this).dismiss();
            }
            ChatFooter.this.Kjf = true;
            AppMethodBeat.o(232235);
          }
        };
        this.Kim.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(232239);
            if (paramAnonymousView != ChatFooter.A(ChatFooter.this))
            {
              AppMethodBeat.o(232239);
              return false;
            }
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(232239);
              return true;
              Log.i("MicroMsg.RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[] { Integer.valueOf(ChatFooter.grm()) });
              paramAnonymousView = com.tencent.mm.cj.a.Owq;
              com.tencent.mm.cj.a.AQ(false);
              ChatFooter.C(ChatFooter.this).ofl = System.currentTimeMillis();
              ChatFooter.C(ChatFooter.this).GtK = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.C(ChatFooter.this).GtL = ((int)paramAnonymousMotionEvent.getRawY());
              ChatFooter.N(ChatFooter.this);
              if ((ChatFooter.O(ChatFooter.this)) && (ChatFooter.L(ChatFooter.this) != null))
              {
                ChatFooter.P(ChatFooter.this);
                if (ChatFooter.Q(ChatFooter.this) != null) {
                  ChatFooter.Q(ChatFooter.this).getBlurController().destroy();
                }
                if (ChatFooter.R(ChatFooter.this) != null) {
                  ChatFooter.R(ChatFooter.this).getBlurController().destroy();
                }
              }
              Log.i("MicroMsg.RcdBtnEvent", "trans voice opener: %s, blur mode opener: %s.", new Object[] { Boolean.valueOf(ChatFooter.S(ChatFooter.this)), ChatFooter.T(ChatFooter.this) });
              if (ChatFooter.S(ChatFooter.this)) {}
              for (ChatFooter.C(ChatFooter.this).GtX = 1;; ChatFooter.C(ChatFooter.this).GtX = 0)
              {
                ChatFooter.a(ChatFooter.this, null);
                long l = System.nanoTime();
                ChatFooter.a(ChatFooter.this, new com.tencent.mm.modelvoiceaddr.h(String.valueOf(l & 0xFFFFFFFF)));
                ChatFooter.E(ChatFooter.this).b(ChatFooter.D(ChatFooter.this));
                if ((ChatFooter.this.getContext() instanceof Activity)) {
                  ((Activity)ChatFooter.this.getContext()).getWindow().addFlags(128);
                }
                if ((ChatFooter.U(ChatFooter.this)) || (ChatFooter.V(ChatFooter.this))) {
                  break;
                }
                ChatFooter.e(ChatFooter.this, true);
                ChatFooter.A(ChatFooter.this).setBackgroundResource(2131234634);
                ChatFooter.A(ChatFooter.this).setText(2131757295);
                if (ChatFooter.l(ChatFooter.this) != null) {
                  ChatFooter.l(ChatFooter.this).ehN();
                }
                ChatFooter.A(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757222));
                break;
              }
              if ((ChatFooter.L(ChatFooter.this) == null) || (!ChatFooter.L(ChatFooter.this).isShowing()))
              {
                if (ChatFooter.L(ChatFooter.this) == null) {}
                for (boolean bool = true;; bool = false)
                {
                  Log.e("MicroMsg.RcdBtnEvent", "hint window status err, window is null: %s.", new Object[] { Boolean.valueOf(bool) });
                  break;
                }
              }
              if (ChatFooter.S(ChatFooter.this))
              {
                if ((ChatFooter.W(ChatFooter.this) == null) || (ChatFooter.X(ChatFooter.this) == null)) {
                  Log.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! voice2txtRealHintArea is %s, voice2txtOpeLayout is %s.", new Object[] { ChatFooter.W(ChatFooter.this), ChatFooter.X(ChatFooter.this) });
                }
                if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getY() > -ChatFooter.Y(ChatFooter.this) / 3) && (paramAnonymousMotionEvent.getX() < ChatFooter.A(ChatFooter.this).getWidth()))
                {
                  if (ChatFooter.Z(ChatFooter.this) != ChatFooter.l.KmM)
                  {
                    Log.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_1.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.KmM);
                    if (ChatFooter.aa(ChatFooter.this))
                    {
                      ChatFooter.ab(ChatFooter.this).animate().cancel();
                      ChatFooter.ac(ChatFooter.this).animate().cancel();
                      if (ChatFooter.j.KmE == ChatFooter.T(ChatFooter.this))
                      {
                        ChatFooter.Q(ChatFooter.this).setAlpha(0.5F);
                        ChatFooter.Q(ChatFooter.this).animate().alpha(1.0F).setDuration(300L).start();
                        ChatFooter.Q(ChatFooter.this).alW(ChatFooter.this.getResources().getColor(2131101312)).F(ChatFooter.e(ChatFooter.this).getWindow().getDecorView().getBackground()).BJ(true);
                      }
                      for (;;)
                      {
                        ChatFooter.M(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(200L).start();
                        ChatFooter.ad(ChatFooter.this).setVisibility(0);
                        ChatFooter.ae(ChatFooter.this).setVisibility(8);
                        ChatFooter.X(ChatFooter.this).setVisibility(8);
                        ChatFooter.a(ChatFooter.this, ChatFooter.k.KmH);
                        ChatFooter.af(ChatFooter.this);
                        break;
                        ChatFooter.W(ChatFooter.this).setBackgroundResource(2131235439);
                      }
                    }
                  }
                }
                else
                {
                  if (ChatFooter.Z(ChatFooter.this) != ChatFooter.l.KmN)
                  {
                    Log.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_2.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.KmN);
                    if (!ChatFooter.aa(ChatFooter.this)) {
                      ChatFooter.ag(ChatFooter.this);
                    }
                    Log.i("MicroMsg.RcdBtnEvent", "init rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.grn()) });
                    if (paramAnonymousMotionEvent.getRawX() > ChatFooter.grn())
                    {
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.KmI);
                      Log.i("MicroMsg.RcdBtnEvent", "init MODE_TRANS");
                      label1030:
                      if (ChatFooter.j.KmE != ChatFooter.T(ChatFooter.this)) {
                        break label1308;
                      }
                      ChatFooter.Q(ChatFooter.this).alW(0).F(null).BJ(false);
                    }
                    for (;;)
                    {
                      ChatFooter.M(ChatFooter.this).getContentView().animate().alpha(1.0F).setDuration(200L).start();
                      ChatFooter.ad(ChatFooter.this).setVisibility(8);
                      ChatFooter.ae(ChatFooter.this).setVisibility(0);
                      ChatFooter.X(ChatFooter.this).setVisibility(0);
                      ChatFooter.ab(ChatFooter.this).setVisibility(0);
                      ChatFooter.ac(ChatFooter.this).setVisibility(0);
                      ChatFooter.ab(ChatFooter.this).setAlpha(0.0F);
                      ChatFooter.ac(ChatFooter.this).setAlpha(0.0F);
                      ChatFooter.ab(ChatFooter.this).animate().translationX(ChatFooter.aj(ChatFooter.this)).translationY(ChatFooter.ai(ChatFooter.this)).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(150L).withEndAction(ChatFooter.ah(ChatFooter.this)).start();
                      ChatFooter.ac(ChatFooter.this).animate().translationX(ChatFooter.aj(ChatFooter.this)).translationY(ChatFooter.ai(ChatFooter.this)).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(150L).start();
                      break;
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.KmJ);
                      Log.i("MicroMsg.RcdBtnEvent", "init MODE_CANCEL");
                      break label1030;
                      label1308:
                      ChatFooter.W(ChatFooter.this).setBackgroundColor(0);
                    }
                  }
                  if (ChatFooter.ak(ChatFooter.this))
                  {
                    Log.i("MicroMsg.RcdBtnEvent", "active rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.grn()) });
                    if ((paramAnonymousMotionEvent.getRawX() > ChatFooter.grn()) && (ChatFooter.k.KmI != ChatFooter.al(ChatFooter.this)))
                    {
                      Log.i("MicroMsg.RcdBtnEvent", "active MODE_TRANS.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.KmI);
                      ChatFooter.ae(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131767150));
                      ChatFooter.am(ChatFooter.this);
                      ChatFooter.an(ChatFooter.this);
                    }
                    else if ((paramAnonymousMotionEvent.getRawX() <= ChatFooter.grn()) && (ChatFooter.k.KmJ != ChatFooter.al(ChatFooter.this)))
                    {
                      Log.i("MicroMsg.RcdBtnEvent", "active MODE_CANCEL.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.KmJ);
                      ChatFooter.ae(ChatFooter.this).setText(ChatFooter.this.getResources().getText(2131767146));
                      ChatFooter.ao(ChatFooter.this);
                      ChatFooter.ap(ChatFooter.this);
                    }
                  }
                }
              }
              else
              {
                if ((ChatFooter.aq(ChatFooter.this) == null) || (ChatFooter.ar(ChatFooter.this) == null)) {
                  Log.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", new Object[] { ChatFooter.aq(ChatFooter.this), ChatFooter.ar(ChatFooter.this) });
                }
                if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getY() > -ChatFooter.Y(ChatFooter.this) / 2) && (paramAnonymousMotionEvent.getX() < ChatFooter.A(ChatFooter.this).getWidth()))
                {
                  if (ChatFooter.aq(ChatFooter.this) != null) {
                    ChatFooter.aq(ChatFooter.this).setVisibility(0);
                  }
                  if (ChatFooter.ar(ChatFooter.this) != null)
                  {
                    ChatFooter.A(ChatFooter.this).setText(2131757295);
                    ChatFooter.ar(ChatFooter.this).setVisibility(8);
                  }
                }
                else
                {
                  if (ChatFooter.aq(ChatFooter.this) != null) {
                    ChatFooter.aq(ChatFooter.this).setVisibility(8);
                  }
                  if (ChatFooter.ar(ChatFooter.this) != null)
                  {
                    ChatFooter.A(ChatFooter.this).setTextSize(0, com.tencent.mm.cb.a.aH(ChatFooter.this.getContext(), 2131165535) * com.tencent.mm.cb.a.ji(ChatFooter.this.getContext()));
                    ChatFooter.A(ChatFooter.this).setText(2131757279);
                    ChatFooter.ar(ChatFooter.this).setVisibility(0);
                    continue;
                    ChatFooter.E(ChatFooter.this).fAr();
                    if ((ChatFooter.this.getContext() instanceof Activity)) {
                      ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                    }
                    ChatFooter.C(ChatFooter.this).GtM = System.currentTimeMillis();
                    ChatFooter.C(ChatFooter.this).GtN = ((int)paramAnonymousMotionEvent.getRawX());
                    ChatFooter.C(ChatFooter.this).GtO = ((int)paramAnonymousMotionEvent.getRawY());
                    Log.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.grm()) });
                    ChatFooter.this.gqR();
                    Log.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.gro()) });
                  }
                }
              }
            }
          }
        });
        this.Kim.setOnKeyListener(new View.OnKeyListener()
        {
          public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(232240);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            localb.pH(paramAnonymousInt);
            localb.bm(paramAnonymousKeyEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$29", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
            switch (paramAnonymousKeyEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$29", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(232240);
              return false;
              if (((paramAnonymousInt == 23) || (paramAnonymousInt == 66)) && (!ChatFooter.V(ChatFooter.this)) && (!ChatFooter.U(ChatFooter.this)))
              {
                ChatFooter.f(ChatFooter.this, true);
                ChatFooter.A(ChatFooter.this).setBackgroundResource(2131234634);
                ChatFooter.A(ChatFooter.this).setText(2131757295);
                if (ChatFooter.l(ChatFooter.this) != null) {
                  ChatFooter.l(ChatFooter.this).ehN();
                }
                ChatFooter.A(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(2131757222));
                continue;
                if ((paramAnonymousInt == 23) || (paramAnonymousInt == 66))
                {
                  ChatFooter.A(ChatFooter.this).setBackgroundResource(2131233164);
                  ChatFooter.A(ChatFooter.this).setText(2131757294);
                  if (ChatFooter.l(ChatFooter.this) != null) {
                    ChatFooter.l(ChatFooter.this).ehI();
                  }
                  ChatFooter.f(ChatFooter.this, false);
                }
              }
            }
          }
        });
      }
    }
  }
  
  private void Ai(boolean paramBoolean)
  {
    AppMethodBeat.i(31598);
    if (paramBoolean)
    {
      this.Kiw.setVisibility(0);
      this.Kiu.setVisibility(0);
      aW(true, false);
      AppMethodBeat.o(31598);
      return;
    }
    this.Kiw.setVisibility(8);
    this.Kiu.setVisibility(8);
    aW(false, false);
    AppMethodBeat.o(31598);
  }
  
  private void Al(boolean paramBoolean)
  {
    AppMethodBeat.i(31673);
    if (this.Kit == null)
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((this.Kly) && (paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((!this.Kly) && (!paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    this.Kly = paramBoolean;
    if (paramBoolean)
    {
      this.Kit.setImageDrawable(getContext().getResources().getDrawable(2131231777));
      AppMethodBeat.o(31673);
      return;
    }
    this.Kit.setImageDrawable(getContext().getResources().getDrawable(2131690793));
    AppMethodBeat.o(31673);
  }
  
  private void a(boolean paramBoolean, final Runnable paramRunnable)
  {
    AppMethodBeat.i(31658);
    if (paramBoolean)
    {
      if (this.rum == null) {
        gqm();
      }
      this.rum.animate().cancel();
      if ((this.rum.getVisibility() == 0) && (this.rum.getAlpha() == 1.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(31658);
        }
      }
      else
      {
        this.rum.setVisibility(0);
        this.rum.setAlpha(0.0F);
        this.rum.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
        this.rum.setToSendText(this.ECK.getText().toString());
        AppMethodBeat.o(31658);
      }
    }
    else if ((this.rum == null) || (this.rum.getVisibility() == 4) || (this.rum.getAlpha() == 0.0F))
    {
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(31658);
      }
    }
    else
    {
      this.rum.animate().cancel();
      this.rum.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232265);
          ChatFooter.y(ChatFooter.this).setVisibility(4);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(232265);
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
      if (this.Kik == null) {
        gqn();
      }
      this.Kik.animate().cancel();
      if ((this.Kik.getVisibility() == 0) && (this.Kik.getAlpha() == 1.0F)) {
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    }
    for (;;)
    {
      this.ECK.gYF();
      AppMethodBeat.o(163216);
      return;
      setAppPanelVisible(0);
      this.Kik.setAlpha(0.0F);
      this.Kik.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(232264);
          ChatFooter.bo(ChatFooter.this);
          ChatFooter.bp(ChatFooter.this).animate().setListener(null);
          AppMethodBeat.o(232264);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      this.Kik.setUncertainEnterLocation(paramInt);
      this.Kik.refresh();
      continue;
      this.Kik.animate().cancel();
      if ((this.Kik.getVisibility() == 4) || (this.Kik.getAlpha() == 0.0F))
      {
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
      else {
        this.Kik.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185796);
            ChatFooter.this.setAppPanelVisible(4);
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(185796);
          }
        });
      }
    }
  }
  
  private void aR(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185825);
    if (1 == paramInt3) {}
    for (boolean bool = true; ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) && (paramInt2 == 0); bool = false)
    {
      if (this.Kjp == null) {
        break label111;
      }
      this.Kjp.BP(bool);
      AppMethodBeat.o(185825);
      return;
    }
    if ((paramInt1 == 0) && ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 4)) && (this.Kjp != null)) {
      this.Kjp.BQ(bool);
    }
    label111:
    AppMethodBeat.o(185825);
  }
  
  private void aW(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31599);
    if (paramBoolean1)
    {
      if ((this.Kix.getTag() != null) && ((this.Kix.getTag() instanceof ca)))
      {
        this.Kix.setVisibility(0);
        ca localca = (ca)this.Kix.getTag();
        this.Kiy.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), com.tencent.mm.plugin.msgquote.model.a.a(getContext(), this.Kiy.getTextSize(), localca)));
        AppMethodBeat.o(31599);
        return;
      }
      this.Kix.setVisibility(8);
      AppMethodBeat.o(31599);
      return;
    }
    if (paramBoolean2)
    {
      this.Kix.setTag(null);
      this.Kiy.setText("");
    }
    this.Kix.setVisibility(8);
    AppMethodBeat.o(31599);
  }
  
  private void aiB(int paramInt)
  {
    AppMethodBeat.i(31666);
    if (paramInt == this.KiY)
    {
      AppMethodBeat.o(31666);
      return;
    }
    if (this.han.getVisibility() == 8) {
      gqP();
    }
    if (((paramInt == 0) && (this.Kiu.getVisibility() == 8)) || (paramInt == 3) || ((paramInt == 0) && (this.Kiu.getVisibility() == 8))) {
      gqP();
    }
    AppMethodBeat.o(31666);
  }
  
  private void aiC(int paramInt)
  {
    AppMethodBeat.i(31680);
    Log.i("MicroMsg.ChatFooter", "[refreshBottomHeight] keyborPx:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.compatible.util.i.setFixedHeight(false);
    int i;
    if ((as.bjp(this.Kij)) || (as.bjq(this.Kij)))
    {
      paramInt = com.tencent.mm.compatible.util.i.getValidPanelHeight(getContext(), paramInt, 43);
      i = ad.bD(getContext());
      if ((!this.KiX) || (this.Kje)) {
        break label367;
      }
    }
    label367:
    for (this.Kjk = paramInt;; this.Kjk = KeyBoardUtil.getValidPanelHeight(getContext()))
    {
      paramInt = Math.max(i, this.Kjk);
      this.Kjl = paramInt;
      if (paramInt != this.Kjj) {
        this.Kjj = paramInt;
      }
      Log.i("MicroMsg.ChatFooter", "refreshBottomHeight: %s, %s, %s, %s, %s", new Object[] { Boolean.valueOf(this.KiX), Boolean.valueOf(this.Kje), Integer.valueOf(this.Kjk), Integer.valueOf(this.Kjj), Boolean.valueOf(KeyBoardUtil.isPortOrientation(getContext())) });
      Object localObject = this.Kip.getLayoutParams();
      if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != this.Kjj))
      {
        ((ViewGroup.LayoutParams)localObject).height = this.Kjj;
        this.Kip.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.Kip.requestLayout();
      }
      if (this.Kjb)
      {
        paramInt = -this.Kjj;
        localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
        if ((localObject != null) && (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != paramInt))
        {
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
          setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.Kik != null)
      {
        this.Kik.setPortHeighPx(this.Kjk);
        this.Kik.gpZ();
      }
      if (this.Kdp != null)
      {
        paramInt = this.Kjk + this.Kio.getHeight();
        localObject = this.Kdp.getLayoutParams();
        if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != paramInt))
        {
          ((ViewGroup.LayoutParams)localObject).height = paramInt;
          this.Kdp.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(31680);
      return;
      paramInt = com.tencent.mm.compatible.util.i.getValidPanelHeight(getContext(), paramInt);
      break;
    }
  }
  
  private void aiw(int paramInt)
  {
    AppMethodBeat.i(31593);
    if (this.Kin == null)
    {
      AppMethodBeat.o(31593);
      return;
    }
    if (paramInt == 2131231778) {}
    for (int i = 1;; i = 0)
    {
      if (this.Kin != null)
      {
        if (i == 0) {
          break label83;
        }
        this.Kin.setContentDescription(getContext().getString(2131757221));
      }
      for (;;)
      {
        this.Kin.setImageResource(paramInt);
        this.Kin.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(31593);
        return;
        label83:
        this.Kin.setContentDescription(getContext().getString(2131757220));
      }
    }
  }
  
  private void appendText(String paramString)
  {
    AppMethodBeat.i(232296);
    if (this.ECK == null)
    {
      AppMethodBeat.o(232296);
      return;
    }
    this.ECK.append(paramString);
    this.ECK.setSelection(this.ECK.getText().length());
    this.ECK.gYJ();
    AppMethodBeat.o(232296);
  }
  
  private void b(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185824);
    gqM();
    if (this.Kja != null)
    {
      if ((this.Kji) && (this.KiY == 1))
      {
        this.Kja.c(0, false, paramInt2, paramInt3);
        AppMethodBeat.o(185824);
        return;
      }
      this.Kja.c(paramInt1, paramBoolean, paramInt2, paramInt3);
      AppMethodBeat.o(185824);
      return;
    }
    if ((this.KiY == 0) || (this.KiY == 1)) {
      this.Kip.setVisibility(8);
    }
    Log.e("MicroMsg.ChatFooter", "scrollParent: scrollParent is not ChattingScrollLayout");
    AppMethodBeat.o(185824);
  }
  
  static boolean beY(String paramString)
  {
    AppMethodBeat.i(163219);
    boolean bool = MultiProcessMMKV.getMMKV("plus_uncertain_enter").getBoolean(paramString, false);
    AppMethodBeat.o(163219);
    return bool;
  }
  
  private boolean dYe()
  {
    AppMethodBeat.i(31608);
    if (this.KiC != null)
    {
      boolean bool = this.KiC.dYe();
      AppMethodBeat.o(31608);
      return bool;
    }
    AppMethodBeat.o(31608);
    return false;
  }
  
  private boolean db(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(179783);
    if (gqQ())
    {
      AppMethodBeat.o(179783);
      return false;
    }
    if ((this.Kjy == null) || (Util.isNullOrNil(this.Kjy.getTalkerUserName())))
    {
      Log.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg username == null");
      AppMethodBeat.o(179783);
      return false;
    }
    try
    {
      String str = this.Kjy.getTalkerUserName();
      if ((((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.j.class)).aBg(str)) && (paramBoolean))
      {
        this.KiC.dYf();
        try
        {
          localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.a.class)).alW(paramString);
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
          locala2 = com.tencent.mm.plugin.groupsolitaire.b.b.a(localException, this.KiC.ygN, locala1);
          if (!locala2.yfF) {
            break label296;
          }
          com.tencent.mm.plugin.groupsolitaire.b.b.c(locala2);
          label296:
          locala2.field_lastActiveTime = cl.aWB();
          if (locala1 == null) {
            break label391;
          }
        }
        localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ia(paramString, str);
        if ((((Integer)((Pair)localObject).first).intValue() > 0) && (((Pair)localObject).second != null))
        {
          localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second;
          com.tencent.mm.plugin.groupsolitaire.b.b.a(str, z.aTY(), (com.tencent.mm.plugin.groupsolitaire.c.a)localObject);
          com.tencent.mm.plugin.groupsolitaire.c.a locala1 = com.tencent.mm.plugin.groupsolitaire.b.b.a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(str, ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_key, true), z.aTY(), 1);
          if (locala1 == null)
          {
            Log.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg storageGroupSolitatire == null");
            AppMethodBeat.o(179783);
            return false;
          }
          com.tencent.mm.plugin.groupsolitaire.c.a locala2;
          paramBoolean = true;
          com.tencent.mm.plugin.groupsolitaire.b.b.a(locala2, paramBoolean, true);
          PluginGroupSolitaire localPluginGroupSolitaire = (PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class);
          if (locala1.field_active == 0) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            localPluginGroupSolitaire.sendGroupSolitatire(paramString, str, localException, locala2, locala1, paramBoolean);
            if (this.KiD != null) {
              this.KiD.aBt(paramString);
            }
            this.KiC.reset();
            gqj();
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
  
  private int getDefaultLangType()
  {
    AppMethodBeat.i(185418);
    int i = com.tencent.mm.modelvoiceaddr.g.jwp;
    String str = LocaleUtil.getCurrentLanguage(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW"))) {
      i = com.tencent.mm.modelvoiceaddr.g.jwq;
    }
    for (;;)
    {
      AppMethodBeat.o(185418);
      return i;
      if (str.equals("en")) {
        i = com.tencent.mm.modelvoiceaddr.g.jws;
      }
    }
  }
  
  private int getTransLangTypeByTalker()
  {
    AppMethodBeat.i(185417);
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voice2txt_sp", 0);
    int j = localSharedPreferences.getInt(this.Kij, com.tencent.mm.modelvoiceaddr.g.jwp);
    if (this.Kkr != null)
    {
      Iterator localIterator = this.Kkr.Guo.gzD.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((com.tencent.mm.plugin.transvoice.ui.a.a.a)localIterator.next()).Gwt != j);
      for (i = 1; i == 0; i = 0)
      {
        i = getDefaultLangType();
        if (com.tencent.mm.modelvoiceaddr.g.jwp != i) {
          localSharedPreferences.edit().putInt(this.Kij, i).apply();
        }
        AppMethodBeat.o(185417);
        return i;
      }
      AppMethodBeat.o(185417);
      return j;
    }
    int i = getDefaultLangType();
    if (com.tencent.mm.modelvoiceaddr.g.jwp != i) {
      localSharedPreferences.edit().putInt(this.Kij, i).apply();
    }
    AppMethodBeat.o(185417);
    return i;
  }
  
  private void gqG()
  {
    AppMethodBeat.i(31640);
    this.jxm.findViewById(2131298549).setVisibility(0);
    AppMethodBeat.o(31640);
  }
  
  private void gqH()
  {
    AppMethodBeat.i(31641);
    Log.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
    this.KiU = false;
    this.ECK.setImeOptions(0);
    this.ECK.setInputType(this.ECK.getInputType() | 0x40);
    AppMethodBeat.o(31641);
  }
  
  private void gqM()
  {
    AppMethodBeat.i(31660);
    if (this.Kja == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ChattingScrollLayout))
      {
        this.Kja = ((ChattingScrollLayout)localViewParent);
        this.Kjb = true;
      }
    }
    AppMethodBeat.o(31660);
  }
  
  private void gqN()
  {
    AppMethodBeat.i(31668);
    if (!this.wxq)
    {
      Log.i("MicroMsg.ChatFooter", "updateKeyboardProvider: not resumed %s", new Object[] { Util.getStack() });
      AppMethodBeat.o(31668);
      return;
    }
    if ((this.Kje) || (!this.KiX))
    {
      this.gyh.close();
      ((Activity)getContext()).getWindow().setSoftInputMode(18);
      AppMethodBeat.o(31668);
      return;
    }
    ((Activity)getContext()).getWindow().setSoftInputMode(this.Kjc | 0x2);
    this.gyh.start();
    AppMethodBeat.o(31668);
  }
  
  private void gqX()
  {
    AppMethodBeat.i(31687);
    this.KjN.setVisibility(8);
    this.KjQ.setVisibility(8);
    this.KjN.setScaleX(0.5F);
    this.KjN.setScaleY(0.5F);
    this.KjQ.setScaleX(0.5F);
    this.KjQ.setScaleY(0.5F);
    this.KjN.setTranslationX(this.KlL);
    this.KjN.setTranslationY(-this.KlM);
    this.KjQ.setTranslationX(-this.KlL);
    this.KjQ.setTranslationY(-this.KlM);
    gqY();
    gqZ();
    AppMethodBeat.o(31687);
  }
  
  private void gqY()
  {
    AppMethodBeat.i(31688);
    this.KjO.setIconColor(getResources().getColor(2131100046));
    this.KjP.setTextColor(getResources().getColor(2131101315));
    this.KjN.setBackgroundDrawable(getResources().getDrawable(2131235440));
    AppMethodBeat.o(31688);
  }
  
  private void gqZ()
  {
    AppMethodBeat.i(31689);
    this.KjR.setIconColor(getResources().getColor(2131100046));
    this.KjS.setTextColor(getResources().getColor(2131101315));
    this.KjQ.setBackgroundDrawable(getResources().getDrawable(2131235440));
    AppMethodBeat.o(31689);
  }
  
  private void gqh()
  {
    AppMethodBeat.i(31572);
    if (this.Kjs != null)
    {
      com.tencent.mm.g.b.a.j localj = this.Kjs;
      localj.ekg = 0L;
      localj.eke = 0L;
      localj.ekf = 0L;
      localj.ekh = 0L;
      localj.bK(0L).bL(0L);
    }
    AppMethodBeat.o(31572);
  }
  
  private void gqn()
  {
    AppMethodBeat.i(31594);
    String str;
    if (this.Kjy == null)
    {
      str = this.Kij;
      this.Kik = ((AppPanel)findViewById(2131298318));
      this.Kik.setOnSwitchPanelListener(this.KkV);
      this.Kik.setChattingContext(this.KkW);
      this.Kik.setPortHeighPx(KeyBoardUtil.getValidPanelHeight(getContext()));
      if ((!ab.JE(str)) && (!ab.Jv(str))) {
        break label124;
      }
      this.Kik.init(0);
    }
    for (;;)
    {
      this.Kiq = ((TextView)findViewById(2131298319));
      AppMethodBeat.o(31594);
      return;
      str = this.Kjy.getTalkerUserName();
      break;
      label124:
      if (ab.IT(str)) {
        this.Kik.init(4);
      } else if (ab.Eq(str)) {
        this.Kik.init(2);
      } else {
        this.Kik.init(1);
      }
    }
  }
  
  private void gqp()
  {
    AppMethodBeat.i(185399);
    this.Klc.start();
    this.Kld.start();
    this.Kle.start();
    this.Klf.start();
    this.Klg.start();
    this.KkM.animate().alpha(1.0F).setDuration(200L).start();
    this.KkN.animate().alpha(1.0F).setDuration(200L).start();
    this.Kkw.animate().alpha(1.0F).translationY(0.0F).setDuration(300L).start();
    grd();
    AppMethodBeat.o(185399);
  }
  
  private void gqq()
  {
    AppMethodBeat.i(31617);
    if (this.KiS)
    {
      this.tfb.setVisibility(8);
      this.tfc.setVisibility(8);
      this.FQV.setVisibility(8);
      this.teZ.setVisibility(8);
      this.KjC.setVisibility(0);
      this.KjF.setVisibility(0);
      this.KjG.setVisibility(0);
      this.KjI.setVisibility(8);
      this.KjJ.setVisibility(0);
      this.KjK.setVisibility(8);
      this.KjM.setVisibility(8);
      this.KjN.setVisibility(8);
      this.KjQ.setVisibility(8);
      this.Kkc = k.KmH;
      this.Kka = l.KmL;
      AppMethodBeat.o(31617);
      return;
    }
    this.tfb.setVisibility(0);
    this.tfc.setVisibility(8);
    this.FQV.setVisibility(8);
    this.teZ.setVisibility(8);
    this.KjC.setVisibility(8);
    AppMethodBeat.o(31617);
  }
  
  private void gra()
  {
    AppMethodBeat.i(31690);
    String str = LocaleUtil.getCurrentLanguage(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
    {
      this.KjL.setImageResource(2131691704);
      this.KjR.setImageResource(2131691706);
      AppMethodBeat.o(31690);
      return;
    }
    if (str.equals("en"))
    {
      this.KjL.setImageResource(2131691705);
      this.KjR.setImageResource(2131691707);
    }
    AppMethodBeat.o(31690);
  }
  
  private void grb()
  {
    AppMethodBeat.i(185403);
    int k = this.Kkk.getWidth();
    int m = this.Kkk.getHeight();
    int j = 0;
    int i = 0;
    switch (83.Kmh[this.KlT.ordinal()])
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
          AppMethodBeat.i(232283);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.aA(ChatFooter.this).getLayoutParams()).width = i;
          ChatFooter.aA(ChatFooter.this).requestLayout();
          AppMethodBeat.o(232283);
        }
      });
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { m, i }).setDuration(200L);
      localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(232285);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.aA(ChatFooter.this).getLayoutParams()).height = i;
          ChatFooter.aA(ChatFooter.this).requestLayout();
          AppMethodBeat.o(232285);
        }
      });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
      localAnimatorSet.start();
      AppMethodBeat.o(185403);
      return;
      j = this.Klt;
      i = this.GyD;
      continue;
      j = this.Kll;
      i = this.Klq;
      continue;
      j = this.Klm;
      i = this.GyD;
    }
  }
  
  private void grc()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(185404);
    float f3 = this.Kkk.getTranslationX();
    float f1 = f2;
    switch (83.Kmh[this.KlT.ordinal()])
    {
    }
    for (f1 = f2;; f1 = -(au.az(getContext()).x / 2 - at.fromDPToPix(getContext(), 76)))
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f3, f1 }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(232286);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ChatFooter.aA(ChatFooter.this).setTranslationX(f);
          AppMethodBeat.o(232286);
        }
      });
      localValueAnimator.start();
      AppMethodBeat.o(185404);
      return;
    }
  }
  
  private void grd()
  {
    AppMethodBeat.i(185405);
    this.Kkk.setAlpha(0.0F);
    this.Kkk.setTranslationY(at.fromDPToPix(getContext(), 56));
    this.Kkn.setAlpha(0);
    this.Kkn.setTranslationY(at.fromDPToPix(getContext(), 56));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.Kkk, "translationY", new float[] { this.Kkk.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.Kkk, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.Kkn, "translationY", new float[] { this.Kkn.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofInt(this.Kkn, "alpha", new int[] { 0, 255 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    localAnimatorSet.start();
    AppMethodBeat.o(185405);
  }
  
  private void gre()
  {
    AppMethodBeat.i(185406);
    this.Kkm.setVisibility(8);
    this.Kkp.setVisibility(0);
    this.Kkp.setTextColor(getContext().getResources().getColor(2131100042));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Kkt.getLayoutParams();
    localLayoutParams.addRule(13);
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    this.Kkp.setText(String.format(getContext().getResources().getString(2131763538), new Object[] { Integer.valueOf(this.Klu) }));
    this.Kkt.requestLayout();
    AppMethodBeat.o(185406);
  }
  
  private void grf()
  {
    AppMethodBeat.i(185407);
    this.Kkm.setVisibility(8);
    this.Kkp.setVisibility(0);
    this.Kkp.setTextColor(getContext().getResources().getColor(2131100584));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Kkt.getLayoutParams();
    localLayoutParams.removeRule(13);
    localLayoutParams.addRule(21);
    localLayoutParams.addRule(12);
    this.Kkp.setText(String.format(getContext().getResources().getString(2131763538), new Object[] { Integer.valueOf(this.Klu) }));
    this.Kkt.requestLayout();
    AppMethodBeat.o(185407);
  }
  
  private void grg()
  {
    AppMethodBeat.i(185408);
    this.Kkm.setVisibility(0);
    this.Kkp.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Kkt.getLayoutParams();
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    localLayoutParams.addRule(13);
    this.Kkt.requestLayout();
    ((RelativeLayout.LayoutParams)this.Kkm.getLayoutParams()).bottomMargin = 0;
    this.Kkm.requestLayout();
    AppMethodBeat.o(185408);
  }
  
  private void grh()
  {
    AppMethodBeat.i(185409);
    this.KkM.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).withEndAction(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(232287);
        ChatFooter.bz(ChatFooter.this).setVisibility(8);
        ChatFooter.bA(ChatFooter.this).C(ChatFooter.this.getResources().getColor(2131100042), 0.5F);
        AppMethodBeat.o(232287);
      }
    }).start();
    this.KkN.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).start();
    this.KkO.animate().translationY(0.0F).setDuration(100L).start();
    if (this.Klu < 10) {
      gre();
    }
    for (;;)
    {
      this.Kku.setVisibility(0);
      this.Kks.setVisibility(8);
      this.Kkl.setVisibility(8);
      this.Kkn.setImageDrawable(com.tencent.mm.ui.ar.m(getContext(), 2131690705, getContext().getResources().getColor(2131099773)));
      this.Kkn.animate().translationX(0.0F).setDuration(150L).start();
      this.Kkk.setActivated(true);
      grb();
      grc();
      AppMethodBeat.o(185409);
      return;
      grg();
      this.Kkm.a(SoundWaveView.d.Gvp);
    }
  }
  
  private void gri()
  {
    AppMethodBeat.i(185410);
    this.KkB.setVisibility(4);
    this.Kkz.C(getResources().getColor(2131099844), 0.5F);
    this.Kkx.setBackgroundDrawable(getResources().getDrawable(2131234240));
    this.Kkx.animate().scaleX(1.0F).scaleY(1.0F).setDuration(150L).start();
    AppMethodBeat.o(185410);
  }
  
  private void grj()
  {
    AppMethodBeat.i(185411);
    this.KkC.setVisibility(4);
    this.KkA.C(getResources().getColor(2131099844), 0.5F);
    this.Kky.setBackgroundDrawable(getResources().getDrawable(2131234240));
    this.Kky.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    AppMethodBeat.o(185411);
  }
  
  private void grk()
  {
    AppMethodBeat.i(185412);
    int j = at.fromDPToPix(getContext(), 20);
    if ((this.Kkl.getText() != null) && (this.Kkl.getText().length() > 0)) {}
    for (int i = this.Kkl.getText().length();; i = 0)
    {
      this.Kkl.setSelection(i);
      this.Kkl.setPadding(j, j, j, j);
      this.Kkw.setVisibility(8);
      this.Kku.setVisibility(8);
      this.KkL.setVisibility(4);
      this.KkD.setVisibility(0);
      this.Kkq.setVisibility(0);
      com.tencent.mm.cj.a.a locala = com.tencent.mm.cj.a.Owq;
      com.tencent.mm.cj.a.gGt();
      this.Kkp.setVisibility(8);
      this.Kkm.setVisibility(8);
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
  
  private void j(int paramInt1, boolean paramBoolean, final int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(163218);
    Log.i("MicroMsg.ChatFooter", "switchPanel: %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    if (this.Kjn)
    {
      AppMethodBeat.o(163218);
      return;
    }
    if ((paramInt1 != 0) && (z.aUQ().booleanValue()) && (this.Kjt != null))
    {
      this.Kjt.a(Boolean.TRUE, Boolean.FALSE);
      this.Kjt.b(Boolean.TRUE, Boolean.FALSE);
    }
    aiB(paramInt1);
    if (this.Kio != null) {
      this.Kio.setVisibility(0);
    }
    switch (paramInt1)
    {
    default: 
      if (((this.KiY != 0) || (paramInt1 != 1)) && ((this.KiY != 1) || (paramInt1 != 0))) {
        break;
      }
    }
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      aR(this.KiY, paramInt1, paramInt2);
      int i;
      label203:
      com.tencent.mm.emoji.c.b localb;
      label229:
      int k;
      if (this.KiY != paramInt1)
      {
        i = 1;
        this.KiY = paramInt1;
        if (this.KiY != 2) {
          break label521;
        }
        Al(true);
        localb = com.tencent.mm.emoji.c.b.hcd;
        com.tencent.mm.emoji.c.b.awa();
        k = this.Kjd;
        if (this.Kjp != null) {
          break label537;
        }
      }
      label521:
      label537:
      for (paramInt1 = j;; paramInt1 = this.Kjp.dYg())
      {
        b(k, paramBoolean, paramInt2, paramInt1);
        if (i != 0) {
          com.tencent.f.h.RTc.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(232269);
              if ((ChatFooter.f(ChatFooter.this) != null) && (ChatFooter.f(ChatFooter.this).grq() != null))
              {
                com.tencent.mm.ui.chatting.d.b.aw localaw = (com.tencent.mm.ui.chatting.d.b.aw)ChatFooter.f(ChatFooter.this).grq().bh(com.tencent.mm.ui.chatting.d.b.aw.class);
                if (localaw != null) {
                  localaw.gRB();
                }
              }
              AppMethodBeat.o(232269);
            }
          }, 300L);
        }
        if (this.KiF != null) {
          this.KiF.kE(this.KiY, this.Kjd);
        }
        AppMethodBeat.o(163218);
        return;
        if ((!this.KiX) || (this.Kje)) {}
        for (this.Kjd = 0;; this.Kjd = this.oXi)
        {
          a(false, null);
          a(false, null, -1);
          break;
        }
        this.Kjd = this.Kjl;
        this.Kip.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(232267);
            ChatFooter.bs(ChatFooter.this);
            AppMethodBeat.o(232267);
          }
        }, -1);
        break;
        this.Kjd = this.Kjk;
        this.Kip.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(232268);
            ChatFooter.h(ChatFooter.this, paramInt2);
            AppMethodBeat.o(232268);
          }
        });
        this.KiA.grx();
        Ah(false);
        if (this.KiR != 2) {
          break;
        }
        aiz(1);
        break;
        this.Kjd = 0;
        a(false, null);
        a(false, null, -1);
        gpb();
        gqO();
        break;
        if (this.Kio != null) {
          this.Kio.setVisibility(4);
        }
        this.Kjd = this.Kjm;
        a(false, null);
        a(false, null, -1);
        break;
        i = 0;
        break label203;
        Al(false);
        localb = com.tencent.mm.emoji.c.b.hcd;
        com.tencent.mm.emoji.c.b.awb();
        break label229;
      }
    }
  }
  
  private void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(31584);
    this.gYo = paramBoolean;
    if (this.Kjz == null)
    {
      this.Kjz = AnimationUtils.loadAnimation(getContext(), 2130772119);
      this.Kjz.setDuration(150L);
    }
    if (this.KjA == null)
    {
      this.KjA = AnimationUtils.loadAnimation(getContext(), 2130772124);
      this.KjA.setDuration(150L);
    }
    if ((this.han == null) || (this.Kir == null))
    {
      Log.i("MicroMsg.ChatFooter", "canSend:%B, return sendBtn == null || mAttachButton == null", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31584);
      return;
    }
    if (this.Kjw)
    {
      if (this.Kir.getVisibility() != 0) {
        this.Kir.setVisibility(0);
      }
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.han.getVisibility() == 0) && (paramBoolean))
    {
      Log.i("MicroMsg.ChatFooter", "canSend true ! sendBtn is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.Kir.getVisibility() == 0) && (!paramBoolean))
    {
      Log.i("MicroMsg.ChatFooter", "canSend false ! AttachButton is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if (paramBoolean)
    {
      gqV();
      this.Kir.startAnimation(this.KjA);
      this.Kir.setVisibility(8);
      Am(false);
    }
    for (;;)
    {
      Log.i("MicroMsg.ChatFooter", "jacks canSend:%B", new Object[] { Boolean.valueOf(paramBoolean) });
      this.han.getParent().requestLayout();
      AppMethodBeat.o(31584);
      return;
      this.Kir.startAnimation(this.Kjz);
      if ((!this.KiI) && (!this.KiW))
      {
        this.Kir.setVisibility(0);
        Am(true);
      }
      gqU();
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
    switch (83.Kmh[this.KlT.ordinal()])
    {
    }
    for (;;)
    {
      this.Klu = paramInt;
      AppMethodBeat.o(185400);
      return;
      int i = 60 - paramInt;
      int j = (int)(this.Klp * i);
      this.Klt = Math.min(this.Klo + j, this.Kln);
      Log.d("MicroMsg.ChatFooter", "voiceWidth:%s, duration:%s, offset:%s", new Object[] { Integer.valueOf(this.Klt), Integer.valueOf(i), Integer.valueOf(j) });
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.Kkk.getWidth(), this.Klt }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(232282);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          ((ViewGroup.MarginLayoutParams)ChatFooter.aA(ChatFooter.this).getLayoutParams()).width = i;
          ChatFooter.aA(ChatFooter.this).requestLayout();
          AppMethodBeat.o(232282);
        }
      });
      localValueAnimator.start();
      if (paramInt < 10)
      {
        gre();
        continue;
        if (paramInt < 10) {
          grf();
        }
      }
    }
  }
  
  public final void Ah(boolean paramBoolean)
  {
    AppMethodBeat.i(31588);
    Log.i("MicroMsg.ChatFooter", "pureForcusEdtChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.ECK });
    if (this.ECK == null)
    {
      AppMethodBeat.o(31588);
      return;
    }
    if (paramBoolean)
    {
      this.ECK.gYJ();
      AppMethodBeat.o(31588);
      return;
    }
    this.ECK.clearFocus();
    AppMethodBeat.o(31588);
  }
  
  public final void Aj(boolean paramBoolean)
  {
    AppMethodBeat.i(31654);
    Log.i("MicroMsg.ChatFooter", "withoutLastText: ");
    hideVKB();
    Ah(paramBoolean);
    AppMethodBeat.o(31654);
  }
  
  public final void Ak(boolean paramBoolean)
  {
    AppMethodBeat.i(258252);
    i(0, paramBoolean, -1);
    AppMethodBeat.o(258252);
  }
  
  public final void Am(boolean paramBoolean)
  {
    AppMethodBeat.i(163220);
    if (this.Kir == null)
    {
      Log.e("MicroMsg.ChatFooter", "mAttachButton is null");
      AppMethodBeat.o(163220);
      return;
    }
    if (this.Kis != null) {
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
        } while ((locala.KhR != 1) || (beY(locala.KhQ)));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.Kis.setVisibility(0);
        AppMethodBeat.o(163220);
        return;
      }
      this.Kis.setVisibility(8);
      AppMethodBeat.o(163220);
      return;
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean1, com.tencent.mm.modelvoiceaddr.h paramh, boolean paramBoolean2)
  {
    AppMethodBeat.i(185826);
    Log.d("MicroMsg.ChatFooter", "startTrans, hasStartTrans: %s, isForce: %s.", new Object[] { Boolean.valueOf(this.KlW), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean2) {
      if (this.KlW)
      {
        if (this.GvE != null) {
          this.GvE.az(false, true);
        }
        this.GvO.removeMessages(5000);
        this.GvL.stopTimer();
      }
    }
    while (!this.KlW)
    {
      this.KlW = true;
      this.GvE = new com.tencent.mm.plugin.transvoice.a.b(paramh, paramInt, new g.b()
      {
        public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(232290);
          Log.d("MicroMsg.ChatFooter", "newVoice2txt onRes, %s.", new Object[] { ChatFooter.this.GvE });
          ChatFooter.bB(ChatFooter.this).clear();
          if (!Util.isNullOrNil(paramAnonymousList)) {
            ChatFooter.bB(ChatFooter.this).addAll(paramAnonymousList);
          }
          if (!ChatFooter.aS(ChatFooter.this))
          {
            ChatFooter.g(ChatFooter.this, true);
            ChatFooter.aB(ChatFooter.this).setFocusable(true);
            ChatFooter.aB(ChatFooter.this).setFocusableInTouchMode(true);
            ChatFooter.aB(ChatFooter.this).requestFocus();
          }
          if ((ChatFooter.this.GvE != null) && (!ChatFooter.this.GvE.GtF))
          {
            ChatFooter.bC(ChatFooter.this).removeMessages(5000);
            ChatFooter.bC(ChatFooter.this).sendEmptyMessageDelayed(5000, 5000L);
          }
          if (!Util.isNullOrNil(paramAnonymousArrayOfString[0]))
          {
            ChatFooter.aM(ChatFooter.this).put(Integer.valueOf(ChatFooter.aL(ChatFooter.this)), paramAnonymousArrayOfString[0]);
            if (ChatFooter.aM(ChatFooter.this) != null) {
              ChatFooter.C(ChatFooter.this).GtV = paramAnonymousArrayOfString[0].length();
            }
            Log.d("MicroMsg.ChatFooter", "newVoice2txt onRes, curTxt: %s.", new Object[] { paramAnonymousArrayOfString[0] });
          }
          AppMethodBeat.o(232290);
        }
        
        public final void biv()
        {
          AppMethodBeat.i(232292);
          Log.d("MicroMsg.ChatFooter", "onRecordFin.");
          AppMethodBeat.o(232292);
        }
        
        public final void biz()
        {
          AppMethodBeat.i(232293);
          if ((ChatFooter.this.GvE != null) && (!ChatFooter.this.GvE.GtF))
          {
            Log.d("MicroMsg.ChatFooter", "onRecognizeFinish, %s.", new Object[] { Boolean.valueOf(ChatFooter.this.GvE.GtF) });
            ChatFooter.C(ChatFooter.this).GtY = 1;
            ChatFooter.C(ChatFooter.this).GtU = System.currentTimeMillis();
            ChatFooter.g(ChatFooter.this, false);
            ChatFooter.aU(ChatFooter.this);
            ChatFooter.this.GvE = null;
            ChatFooter.bC(ChatFooter.this).removeMessages(5000);
            ChatFooter.aT(ChatFooter.this).stopTimer();
            ChatFooter.aN(ChatFooter.this);
          }
          AppMethodBeat.o(232293);
        }
        
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
        {
          AppMethodBeat.i(232291);
          Log.d("MicroMsg.ChatFooter", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong) });
          ChatFooter.C(ChatFooter.this).GtY = 0;
          ChatFooter.C(ChatFooter.this).GtU = System.currentTimeMillis();
          ChatFooter.aU(ChatFooter.this);
          AppMethodBeat.o(232291);
        }
      });
      this.GvE.GtF = paramBoolean1;
      this.GvE.start();
      this.GvL.startTimer(500L);
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
    this.wxq = true;
    this.activity = paramActivity;
    if ((this.Kjc == 48) && (this.KiY == 1) && (!this.Kjn))
    {
      this.xfU = false;
      j(0, false, -1);
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
      this.KiX = bool1;
      if (com.tencent.mm.compatible.util.d.oD(24)) {
        this.Kje = ((Activity)getContext()).isInMultiWindowMode();
      }
      gqN();
      gqS();
      if (ap.gni().JXr) {
        ap.gni().iu(MMApplicationContext.getContext());
      }
      if ((!this.Kip.grr()) && (this.rum != null)) {
        this.rum.onResume();
      }
      if ((this.Kjw) || (!this.KiU)) {
        break label332;
      }
      gqH();
    }
    for (;;)
    {
      aiC(getKeyBordHeightPX());
      if (this.Kik != null) {
        this.Kik.context = paramContext;
      }
      this.KiA.Knj = false;
      if (!this.Kds) {
        gqG();
      }
      gql();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184931);
          com.tencent.mm.compatible.util.i.v(ChatFooter.e(ChatFooter.this));
          AppMethodBeat.o(184931);
        }
      });
      if ((this.Kja != null) && (this.Kjy != null)) {
        this.Kja.a((ChattingScrollLayout.a)this.Kjy.grq().bh(r.class));
      }
      AppMethodBeat.o(31575);
      return;
      bool1 = false;
      break;
      label332:
      if ((this.Kjw) && (!this.KiU)) {
        gqF();
      }
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(31574);
    this.Kjy = paramb;
    this.KiC = new com.tencent.mm.plugin.groupsolitaire.ui.d(getContext(), this.Kjy.grp(), new d.d()
    {
      public final void aBt(String paramAnonymousString)
      {
        AppMethodBeat.i(232230);
        if ((ChatFooter.l(ChatFooter.this) != null) && (!Util.isNullOrNil(paramAnonymousString))) {
          ChatFooter.l(ChatFooter.this).aBt(paramAnonymousString);
        }
        AppMethodBeat.o(232230);
      }
      
      public final void dYi()
      {
        AppMethodBeat.i(232229);
        ChatFooter.this.dYi();
        ChatFooter.this.gqj();
        AppMethodBeat.o(232229);
      }
    });
    this.KiC.ygR = this.Kjr;
    AppMethodBeat.o(31574);
  }
  
  public final void a(final h paramh)
  {
    AppMethodBeat.i(185822);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185363);
        ChatFooter.A(ChatFooter.this).setBackgroundResource(2131233164);
        ChatFooter.A(ChatFooter.this).setText(2131757294);
        if (ChatFooter.this.Kkf)
        {
          switch (ChatFooter.83.Kmi[paramh.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(185363);
            return;
            if (ChatFooter.F(ChatFooter.this) != null) {
              ChatFooter.K(ChatFooter.this);
            }
          }
        }
        if (ChatFooter.L(ChatFooter.this) != null)
        {
          ChatFooter.L(ChatFooter.this).dismiss();
          if (ChatFooter.M(ChatFooter.this) != null) {
            ChatFooter.M(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(300L).withEndAction(ChatFooter.bi(ChatFooter.this)).start();
          }
          ChatFooter.bj(ChatFooter.this).setVisibility(0);
          ChatFooter.bk(ChatFooter.this).setVisibility(8);
          ChatFooter.bl(ChatFooter.this).setVisibility(8);
          ChatFooter.ar(ChatFooter.this).setVisibility(8);
          ChatFooter.X(ChatFooter.this).setVisibility(8);
          ChatFooter.aq(ChatFooter.this).setVisibility(0);
        }
        ChatFooter.f(ChatFooter.this, false);
        ChatFooter.e(ChatFooter.this, false);
        AppMethodBeat.o(185363);
      }
    });
    AppMethodBeat.o(185822);
  }
  
  public final void a(buv parambuv) {}
  
  public final void a(String paramString, Boolean paramBoolean, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(232302);
    if (paramBoolean.booleanValue()) {
      a.b.d(this.KiL, paramString);
    }
    for (;;)
    {
      setHint(paramCharSequence);
      this.KiL.setVisibility(0);
      AppMethodBeat.o(232302);
      return;
      a.b.c(this.KiL, paramString);
    }
  }
  
  public final boolean aT(ca paramca)
  {
    AppMethodBeat.i(31678);
    if (this.KiD != null) {
      this.KiD.ehQ();
    }
    this.Kix.setTag(paramca);
    this.KiR = 1;
    Ai(true);
    this.Kim.setVisibility(8);
    aiw(2131231778);
    if (this.Kdp != null)
    {
      this.Kdp.setVisibility(8);
      this.Kds = false;
      this.Kdp.reset();
    }
    showVKB();
    Ah(true);
    beX("");
    AppMethodBeat.o(31678);
    return true;
  }
  
  public final void aX(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31632);
    this.Kik.zW(paramBoolean1);
    this.Kik.zX(paramBoolean2);
    AppMethodBeat.o(31632);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(31615);
    this.KkX = new i(paramTextWatcher);
    this.ECK.addTextChangedListener(this.KkX);
    AppMethodBeat.o(31615);
  }
  
  public final void aiA(int paramInt)
  {
    AppMethodBeat.i(185823);
    b(paramInt, true, 0, 0);
    AppMethodBeat.o(185823);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void aix(int paramInt)
  {
    AppMethodBeat.i(31616);
    Object localObject1;
    if (this.Kkf)
    {
      if (this.Kkh == null)
      {
        this.Kkh = new com.tencent.mm.ui.base.p(View.inflate(getContext(), 2131495852, null), -1, -1, true);
        this.Kkh.setSoftInputMode(16);
        this.Kkh.setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(179765);
            if ((ChatFooter.this.KlT == ChatFooter.e.Kmr) && (ChatFooter.aJ(ChatFooter.this)))
            {
              Log.i("MicroMsg.ChatFooter", "dismiss from keyback, need cancelRecording");
              ChatFooter.C(ChatFooter.this).setExitType(6);
              ChatFooter.l(ChatFooter.this).ehM();
            }
            ChatFooter.aK(ChatFooter.this);
            ChatFooter.e(ChatFooter.this, 0);
            AppMethodBeat.o(179765);
          }
        });
        this.Kki = this.Kkh.getContentView().findViewById(2131305385);
        this.Kkj = this.Kkh.getContentView().findViewById(2131305407);
        this.Kkk = ((ViewGroup)this.Kkh.getContentView().findViewById(2131305381));
        this.Kkm = ((SoundWaveView)this.Kkh.getContentView().findViewById(2131305387));
        this.Kkl = ((EditText)this.Kkh.getContentView().findViewById(2131305379));
        this.Kkn = ((ImageView)this.Kkh.getContentView().findViewById(2131305378));
        this.Kko = ((ViewGroup)this.Kkh.getContentView().findViewById(2131305386));
        this.Kkp = ((TextView)this.Kkh.getContentView().findViewById(2131305377));
        this.Kkq = ((WeImageView)this.Kkh.getContentView().findViewById(2131305382));
        this.Kkr = ((LanguageChoiceLayout)this.Kkh.getContentView().findViewById(2131305399));
        this.Kks = ((TextView)this.Kkh.getContentView().findViewById(2131305383));
        this.Kkt = ((ViewGroup)this.Kkh.getContentView().findViewById(2131305388));
        this.Kku = ((TextView)this.Kkh.getContentView().findViewById(2131305380));
        this.Kkr.setSelectLanguageListener(new LanguageChoiceLayout.a()
        {
          public final void acq(int paramAnonymousInt)
          {
            AppMethodBeat.i(232252);
            ChatFooter.f(ChatFooter.this, paramAnonymousInt);
            if (Util.isNullOrNil((String)ChatFooter.aM(ChatFooter.this).get(Integer.valueOf(ChatFooter.aL(ChatFooter.this)))))
            {
              long l2 = System.nanoTime() | 0xFFFFFFFF;
              long l1 = l2;
              if (l2 < 0L) {
                l1 = Math.abs(l2);
              }
              com.tencent.mm.modelvoiceaddr.h localh = new com.tencent.mm.modelvoiceaddr.h(String.valueOf(l1));
              ChatFooter.D(ChatFooter.this).a(localh);
              ChatFooter.this.getContext().getSharedPreferences("voice2txt_sp", 0).edit().putInt(ChatFooter.q(ChatFooter.this), ChatFooter.aL(ChatFooter.this)).apply();
              ChatFooter.this.a(ChatFooter.aL(ChatFooter.this), false, localh, true);
            }
            for (;;)
            {
              ChatFooter.C(ChatFooter.this).GtQ = System.currentTimeMillis();
              ChatFooter.C(ChatFooter.this).GtT = 0;
              ChatFooter.C(ChatFooter.this).GtU = 0L;
              ChatFooter.C(ChatFooter.this).GtV = 0;
              ChatFooter.C(ChatFooter.this).GtY = 0;
              ChatFooter.C(ChatFooter.this).GtZ = 0;
              ChatFooter.C(ChatFooter.this).Gua = 0;
              AppMethodBeat.o(232252);
              return;
              ChatFooter.aN(ChatFooter.this);
            }
          }
        });
        this.Kkq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(185353);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (ChatFooter.aO(ChatFooter.this)) {
              ChatFooter.aP(ChatFooter.this).hideSoftInputFromWindow(ChatFooter.aB(ChatFooter.this).getWindowToken(), 0);
            }
            paramAnonymousView = ChatFooter.aQ(ChatFooter.this);
            int i = ChatFooter.aL(ChatFooter.this);
            paramAnonymousView.setVisibility(0);
            paramAnonymousView.hSz.post(new LanguageChoiceLayout.4(paramAnonymousView, i));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(185353);
          }
        });
        this.Kkl.setMaxLines(2147483647);
        this.Kkl.setHorizontallyScrolling(false);
        this.Kkl.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(232253);
            if ((4 == paramAnonymousInt) || (66 == paramAnonymousKeyEvent.getAction()))
            {
              paramAnonymousTextView = ChatFooter.aB(ChatFooter.this).getText().toString();
              if (ChatFooter.l(ChatFooter.this) != null)
              {
                if (!Util.isNullOrNil(paramAnonymousTextView)) {
                  ChatFooter.l(ChatFooter.this).aDN(paramAnonymousTextView);
                }
                ChatFooter.l(ChatFooter.this).ehM();
              }
              AppMethodBeat.o(232253);
              return true;
            }
            AppMethodBeat.o(232253);
            return false;
          }
        });
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(31531);
            ChatFooter.aR(ChatFooter.this);
            AppMethodBeat.o(31531);
          }
        });
        this.Kkl.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(232254);
            if (ChatFooter.aS(ChatFooter.this))
            {
              ChatFooter.g(ChatFooter.this, false);
              if (ChatFooter.this.GvE != null) {
                ChatFooter.this.GvE.az(false, true);
              }
              ChatFooter.aT(ChatFooter.this).stopTimer();
              ChatFooter.aB(ChatFooter.this).setText((CharSequence)ChatFooter.aM(ChatFooter.this).get(Integer.valueOf(ChatFooter.aL(ChatFooter.this))));
              ChatFooter.C(ChatFooter.this).GtY = 0;
              ChatFooter.C(ChatFooter.this).GtU = System.currentTimeMillis();
              ChatFooter.aU(ChatFooter.this);
            }
            ChatFooter.C(ChatFooter.this).Gua = 1;
            AppMethodBeat.o(232254);
            return false;
          }
        });
        this.Kkv = ((ViewGroup)this.Kkh.getContentView().findViewById(2131305384));
        this.Kkw = ((ViewGroup)this.Kkh.getContentView().findViewById(2131305410));
        this.Kkx = this.Kkh.getContentView().findViewById(2131305374);
        this.Kky = this.Kkh.getContentView().findViewById(2131305408);
        this.Kkz = ((WeImageView)this.Kkh.getContentView().findViewById(2131305375));
        this.KkA = ((WeImageView)this.Kkh.getContentView().findViewById(2131305409));
        this.KkB = this.Kkh.getContentView().findViewById(2131305376);
        this.KkC = this.Kkh.getContentView().findViewById(2131305412);
        this.KkD = ((ViewGroup)this.Kkh.getContentView().findViewById(2131305411));
        this.KkE = this.Kkh.getContentView().findViewById(2131305390);
        this.KkE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(232255);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            ChatFooter.aV(ChatFooter.this);
            ChatFooter.C(ChatFooter.this).setExitType(6);
            ChatFooter.l(ChatFooter.this).ehM();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(232255);
          }
        });
        this.KkF = this.Kkh.getContentView().findViewById(2131305405);
        this.KkF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(232256);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (ChatFooter.l(ChatFooter.this) != null)
            {
              ChatFooter.aV(ChatFooter.this);
              ChatFooter.C(ChatFooter.this).setExitType(7);
              ChatFooter.l(ChatFooter.this).eu(ChatFooter.l(ChatFooter.this).getFileName(), ChatFooter.aW(ChatFooter.this));
              ChatFooter.K(ChatFooter.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(232256);
          }
        });
        this.KkI = this.Kkh.getContentView().findViewById(2131305402);
        this.KkI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(232257);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if ((ChatFooter.aX(ChatFooter.this).getVisibility() == 0) && (8 == ChatFooter.aY(ChatFooter.this).getVisibility()))
            {
              paramAnonymousView = ChatFooter.aB(ChatFooter.this).getText().toString();
              if ((ChatFooter.l(ChatFooter.this) != null) && (!Util.isNullOrNil(paramAnonymousView)))
              {
                ChatFooter.aV(ChatFooter.this);
                ChatFooter.C(ChatFooter.this).GtS = ChatFooter.aL(ChatFooter.this);
                ChatFooter.C(ChatFooter.this).GtW = paramAnonymousView.length();
                if (1 != ChatFooter.C(ChatFooter.this).GtZ) {
                  break label210;
                }
                ChatFooter.C(ChatFooter.this).setExitType(8);
              }
            }
            for (;;)
            {
              ChatFooter.l(ChatFooter.this).aDN(paramAnonymousView);
              ChatFooter.l(ChatFooter.this).ehM();
              ChatFooter.d(ChatFooter.this, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(232257);
              return;
              label210:
              ChatFooter.C(ChatFooter.this).setExitType(5);
            }
          }
        });
        this.KkG = ((WeImageView)this.Kkh.getContentView().findViewById(2131305391));
        this.KkH = ((WeImageView)this.Kkh.getContentView().findViewById(2131305406));
        this.KkJ = this.Kkh.getContentView().findViewById(2131305404);
        this.KkK = ((WeImageView)this.Kkh.getContentView().findViewById(2131305403));
        this.KkL = ((ViewGroup)this.Kkh.getContentView().findViewById(2131305413));
        this.KkM = this.Kkh.getContentView().findViewById(2131305415);
        this.KkN = this.Kkh.getContentView().findViewById(2131305417);
        this.KkO = this.Kkh.getContentView().findViewById(2131305416);
        this.KkP = ((WeImageView)this.Kkh.getContentView().findViewById(2131305414));
        localObject1 = (RelativeLayout.LayoutParams)this.KkL.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).height = (getContext().getResources().getDimensionPixelSize(2131167111) + av.aD(getContext()));
        this.KkL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (FrameLayout.LayoutParams)this.KkP.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (av.aD(getContext()) + at.fromDPToPix(getContext(), 14));
        this.KkP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.GvL = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(232258);
            int i = ChatFooter.aZ(ChatFooter.this);
            ChatFooter.ba(ChatFooter.this);
            switch (i % 3)
            {
            }
            for (;;)
            {
              ChatFooter.bb(ChatFooter.this);
              AppMethodBeat.o(232258);
              return true;
              ChatFooter.e(ChatFooter.this, "·");
              continue;
              ChatFooter.e(ChatFooter.this, "··");
              continue;
              ChatFooter.e(ChatFooter.this, "···");
            }
          }
        }, true);
        this.GvO = new MMHandler(new MMHandler.Callback()
        {
          public final boolean handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(232259);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(232259);
              return true;
              ChatFooter.C(ChatFooter.this).GtT = 1;
              ChatFooter.C(ChatFooter.this).GtU = System.currentTimeMillis();
              ChatFooter.C(ChatFooter.this).GtY = 0;
              ChatFooter.aT(ChatFooter.this).stopTimer();
              if (ChatFooter.this.GvE != null) {
                ChatFooter.this.GvE.az(false, false);
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
        this.KkQ = this.Kkh.getContentView().findViewById(2131305389);
        this.Kkh.setClippingEnabled(false);
      }
      paramInt = getTransLangTypeByTalker();
      if (com.tencent.mm.modelvoiceaddr.g.jwp == paramInt)
      {
        this.GtE = com.tencent.mm.modelvoiceaddr.g.jwq;
        if (this.Kkr != null) {
          this.Kkr.setSelectedLang(this.GtE);
        }
        Log.d("MicroMsg.ChatFooter", "curTxt:%s", new Object[] { Integer.valueOf(this.KlV.size()) });
        if ((com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.OnI, true)) || (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.OnJ, true))) {
          break label1675;
        }
        this.Kku.setTranslationY(at.fromDPToPix(getContext(), 12));
        this.Kku.setVisibility(0);
        this.Kku.setAlpha(0.0F);
        this.Kku.setText(getContext().getResources().getString(2131763541));
        this.Kku.animate().alpha(1.0F).translationY(0.0F).setDuration(1000L).setStartDelay(500L).start();
        label1180:
        this.Kkk.setTranslationY(0.0F);
        this.Kkn.setTranslationY(0.0F);
        this.Kkq.setTranslationY(0.0F);
        this.Kkv.setTranslationY(0.0F);
        paramInt = at.fromDPToPix(getContext(), 20);
        this.Kkl.setPadding(paramInt, paramInt, paramInt, 0);
        this.Kkl.addTextChangedListener(this.Klb);
        this.Kkl.setVisibility(8);
        this.Kkl.setCursorVisible(false);
        this.Kkm.setVisibility(0);
        this.Kks.setVisibility(8);
        this.KkI.setEnabled(true);
        this.Kkk.setActivated(true);
        this.KkK.setImageDrawable(com.tencent.mm.ui.ar.m(getContext(), 2131690537, getContext().getResources().getColor(2131099710)));
        this.Kkn.setImageDrawable(com.tencent.mm.ui.ar.m(getContext(), 2131690705, getContext().getResources().getColor(2131099773)));
        localObject1 = (FrameLayout.LayoutParams)this.KkM.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = at.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = at.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = at.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = at.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = at.fromDPToPix(getContext(), 8);
        this.KkM.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.KkM.setAlpha(0.0F);
        localObject1 = (FrameLayout.LayoutParams)this.KkN.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).width = at.fromDPToPix(getContext(), 250);
        ((FrameLayout.LayoutParams)localObject1).height = at.fromDPToPix(getContext(), 40);
        ((FrameLayout.LayoutParams)localObject1).topMargin = at.fromDPToPix(getContext(), 72);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = at.fromDPToPix(getContext(), 22);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = at.fromDPToPix(getContext(), 8);
        this.KkN.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.KkN.setAlpha(0.0F);
        this.Kkw.setTranslationY(this.KlS);
        this.Kkw.setAlpha(0.0F);
        this.Kkm.setVisibility(8);
        this.KkQ.setVisibility(0);
        if (!com.tencent.mm.ui.ao.isDarkMode()) {
          break label1759;
        }
        this.Kkj.setBackground(getContext().getResources().getDrawable(2131234236));
      }
      for (;;)
      {
        this.KlF = false;
        this.Kkh.showAtLocation(this, 49, 0, 0);
        gqp();
        this.Kkq.setVisibility(8);
        post(new Runnable()
        {
          public final void run()
          {
            int i = 1;
            AppMethodBeat.i(185362);
            ChatFooter.bc(ChatFooter.this);
            if (ChatFooter.bd(ChatFooter.this) != null)
            {
              ChattingScrollLayout localChattingScrollLayout = ChatFooter.bd(ChatFooter.this);
              int j = ChatFooter.be(ChatFooter.this).getHeight();
              int k = ChatFooter.bf(ChatFooter.this).getHeight();
              int m = au.aD(ChatFooter.this.getContext());
              int n = ChatFooter.a(ChatFooter.this).getHeight();
              if ((localChattingScrollLayout.KmY == null) || (localChattingScrollLayout.KmY.getListView() == null)) {
                break label315;
              }
              int i1 = localChattingScrollLayout.KmY.getListView().getFirstVisiblePosition();
              int i2 = localChattingScrollLayout.KmY.getListView().getHeaderViewsCount();
              i1 = localChattingScrollLayout.KmY.getListView().getLastVisiblePosition() - localChattingScrollLayout.KmY.getListView().getHeaderViewsCount() - (i1 - i2);
              if ((i1 < 0) || (i1 >= localChattingScrollLayout.KmY.getListView().getChildCount())) {
                break label315;
              }
              View localView = localChattingScrollLayout.KmY.getListView().getChildAt(i1);
              if (localView == null) {
                break label315;
              }
              int[] arrayOfInt = new int[2];
              localView.getLocationOnScreen(arrayOfInt);
              i1 = arrayOfInt[1];
              if (localView.getHeight() + i1 <= au.az(localChattingScrollLayout.getContext()).y - (j + k - m - n)) {
                break label315;
              }
            }
            for (;;)
            {
              if (i != 0)
              {
                ChatFooter.g(ChatFooter.this, ChatFooter.be(ChatFooter.this).getHeight() + ChatFooter.bf(ChatFooter.this).getHeight() - au.aD(ChatFooter.this.getContext()) - ChatFooter.a(ChatFooter.this).getHeight());
                ChatFooter.e(ChatFooter.this, 4);
              }
              AppMethodBeat.o(185362);
              return;
              label315:
              i = 0;
            }
          }
        });
        AppMethodBeat.o(31616);
        return;
        this.GtE = paramInt;
        break;
        label1675:
        this.Kku.setTranslationY(at.fromDPToPix(getContext(), 30));
        this.Kku.setVisibility(0);
        this.Kku.setAlpha(0.0F);
        this.Kku.setText(getContext().getResources().getString(2131763545));
        this.Kku.animate().alpha(1.0F).translationY(0.0F).setDuration(200L).setStartDelay(0L).start();
        break label1180;
        label1759:
        this.Kkj.setBackground(getContext().getResources().getDrawable(2131234237));
      }
    }
    this.KkY = 0;
    int i;
    if (this.KiS) {
      i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 280);
    }
    for (;;)
    {
      int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 50.0F);
      if (paramInt + j < i)
      {
        this.KkY = -1;
        if (this.FQS == null)
        {
          this.FQS = new com.tencent.mm.ui.base.p(View.inflate(getContext(), 2131496849, null), -1, -2);
          this.KiN = ((ViewGroup)this.FQS.getContentView().findViewById(2131309985));
          this.tfb = this.FQS.getContentView().findViewById(2131309979);
          this.tfa = ((ImageView)this.FQS.getContentView().findViewById(2131310091));
          this.KiO = ((TextView)this.FQS.getContentView().findViewById(2131309988));
          this.KiO.setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131166855) * com.tencent.mm.cb.a.ji(getContext()));
          this.tfc = this.FQS.getContentView().findViewById(2131309981);
          this.FQT = ((TextView)this.FQS.getContentView().findViewById(2131309983));
          this.FQT.setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131166855) * com.tencent.mm.cb.a.ji(getContext()));
          this.FQU = ((ImageView)this.FQS.getContentView().findViewById(2131309982));
          this.FQV = this.FQS.getContentView().findViewById(2131309984);
          this.teZ = this.FQS.getContentView().findViewById(2131309986);
          this.KjC = ((ViewGroup)this.FQS.getContentView().findViewById(2131309933));
          this.KjD = this.FQS.getContentView().findViewById(2131309926);
          this.KjG = this.FQS.getContentView().findViewById(2131309937);
          this.KjH = ((ImageView)this.FQS.getContentView().findViewById(2131309938));
          this.KjI = ((ImageView)this.FQS.getContentView().findViewById(2131309925));
          this.KjJ = this.FQS.getContentView().findViewById(2131309927);
          this.KjK = ((TextView)this.FQS.getContentView().findViewById(2131309930));
          this.KjL = ((ImageView)this.FQS.getContentView().findViewById(2131309928));
          this.KjM = this.FQS.getContentView().findViewById(2131309932);
          this.KjN = this.FQS.getContentView().findViewById(2131309922);
          this.KjO = ((WeImageView)this.FQS.getContentView().findViewById(2131309923));
          this.KjP = ((TextView)this.FQS.getContentView().findViewById(2131309924));
          this.KjQ = this.FQS.getContentView().findViewById(2131309934);
          this.KjR = ((WeImageView)this.FQS.getContentView().findViewById(2131309935));
          this.KjS = ((TextView)this.FQS.getContentView().findViewById(2131309936));
          this.KjT = View.inflate(getContext(), 2131494989, null);
        }
      }
      try
      {
        if (j.KmE == this.Kkb)
        {
          localObject1 = this.activity.getWindow().getDecorView();
          Drawable localDrawable = ((View)localObject1).getBackground();
          this.KjE = new BlurView(getContext());
          paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 14);
          BlurView localBlurView = this.KjE.L((ViewGroup)localObject1).alW(getResources().getColor(2131101312)).F(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).cw(15.0F).gMs();
          localBlurView.Kx = (paramInt * 1.0F);
          localBlurView.PcA = true;
          localBlurView.alX(this.KkY).gMt();
          this.KjU = new BlurView(getContext());
          this.KjU.alW(getResources().getColor(2131101312));
          this.KjU.L((ViewGroup)localObject1).F(localDrawable).b(new com.tencent.mm.ui.blur.f(getContext())).cw(15.0F).gMs().gMt();
        }
        Log.i("MicroMsg.ChatFooter", "transVoiceBlurMode: %s.", new Object[] { this.Kkb });
        switch (83.Kmg[this.Kkb.ordinal()])
        {
        default: 
          this.KjY.setClippingEnabled(false);
          this.KjY.getContentView().setAlpha(0.0F);
          this.KjY.setOnDismissListener(new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(232260);
              ChatFooter.M(ChatFooter.this).getContentView().setAlpha(0.0F);
              AppMethodBeat.o(232260);
            }
          });
          ((TextView)this.FQS.getContentView().findViewById(2131309929)).setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131167103) * com.tencent.mm.cb.a.ji(getContext()));
          gqq();
          if (this.KkY != -1)
          {
            this.teZ.setVisibility(8);
            this.KiN.setVisibility(8);
            this.FQV.setVisibility(0);
            new MMHandler().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(31552);
                if (ChatFooter.S(ChatFooter.this))
                {
                  ChatFooter.aq(ChatFooter.this).setVisibility(8);
                  ChatFooter.W(ChatFooter.this).setVisibility(0);
                  AppMethodBeat.o(31552);
                  return;
                }
                ChatFooter.aq(ChatFooter.this).setVisibility(0);
                ChatFooter.W(ChatFooter.this).setVisibility(8);
                AppMethodBeat.o(31552);
              }
            });
            if (this.KiS)
            {
              gra();
              this.Kke = false;
              gqX();
              this.KjY.showAtLocation(this, 49, 0, 0);
              this.Kkd = false;
              if (this.KlD)
              {
                this.KlD = false;
                if (j.KmE != this.Kkb) {
                  break label3133;
                }
                this.KjE.alW(getResources().getColor(2131101312)).F(this.activity.getWindow().getDecorView().getBackground()).BJ(true);
              }
            }
            this.FQS.showAtLocation(this, 49, 0, this.KkY);
          }
          else
          {
            AppMethodBeat.o(31616);
            return;
            i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 180);
            continue;
            this.KkY = ((paramInt - i) / 2 + j);
          }
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.Kkb = j.KmF;
          this.KkZ = true;
          continue;
          this.KjC.removeView(this.KjD);
          Object localObject2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(2131167099), getResources().getDimensionPixelSize(2131167099));
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          this.KjE.addView(this.KjD, (ViewGroup.LayoutParams)localObject2);
          this.KjC.addView(this.KjE, (ViewGroup.LayoutParams)localObject2);
          this.KjF = this.KjE;
          localObject2 = new FrameLayout.LayoutParams(-1, -1);
          this.KjU.addView(this.KjT, (ViewGroup.LayoutParams)localObject2);
          this.KjY = new com.tencent.mm.ui.base.p(this.KjU, -1, -1);
          continue;
          this.KjF = this.KjD;
          this.KjF.setBackgroundResource(2131235439);
          this.KjT.setBackgroundColor(getResources().getColor(2131101314));
          this.KjY = new com.tencent.mm.ui.base.p(this.KjT, -1, -1);
          continue;
          label3133:
          this.KjF.setBackgroundResource(2131235439);
        }
      }
    }
  }
  
  public final void aiy(int paramInt)
  {
    AppMethodBeat.i(31622);
    if (this.Kkf)
    {
      if ((this.Kkm != null) && (this.Kkm.getVisibility() == 0)) {
        this.Kkm.acr(paramInt);
      }
      AppMethodBeat.o(31622);
      return;
    }
    if (this.KiS)
    {
      i = 0;
      for (;;)
      {
        if (i < Klw.length)
        {
          if ((paramInt >= Klv[i]) && (paramInt < Klv[(i + 1)])) {
            this.KjH.setBackgroundDrawable(com.tencent.mm.cb.a.l(getContext(), Klw[i]));
          }
        }
        else
        {
          if ((paramInt != -1) || (this.FQS == null)) {
            break;
          }
          this.FQS.dismiss();
          this.FQV.setVisibility(0);
          this.KiN.setVisibility(8);
          this.teZ.setVisibility(8);
          AppMethodBeat.o(31622);
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < Klw.length)
      {
        if ((paramInt >= Klv[i]) && (paramInt < Klv[(i + 1)])) {
          this.tfa.setBackgroundDrawable(com.tencent.mm.cb.a.l(getContext(), Klw[i]));
        }
      }
      else
      {
        if ((paramInt == -1) && (this.FQS != null))
        {
          this.FQS.dismiss();
          this.FQV.setVisibility(0);
          this.KiN.setVisibility(8);
          this.teZ.setVisibility(8);
        }
        AppMethodBeat.o(31622);
        return;
      }
      i += 1;
    }
  }
  
  public final void aiz(int paramInt)
  {
    AppMethodBeat.i(31624);
    this.KiR = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31624);
      return;
      Ai(true);
      this.Kim.setVisibility(8);
      aiw(2131231778);
      AppMethodBeat.o(31624);
      return;
      Ai(false);
      this.Kim.setVisibility(0);
      gqP();
      aiw(2131231777);
      if ((z.aUQ().booleanValue()) && (this.Kjt != null))
      {
        c localc = this.Kjt;
        Boolean localBoolean = Boolean.TRUE;
        localc.b(localBoolean, localBoolean);
      }
    }
  }
  
  public final void bA(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(31625);
    aiz(paramInt);
    switch (paramInt)
    {
    default: 
      setVisibility(0);
      AppMethodBeat.o(31625);
      return;
    case 1: 
      if (paramBoolean)
      {
        Ah(true);
        showVKB();
        if (this.ECK.length() > 0) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          qT(paramBoolean);
          AppMethodBeat.o(31625);
          return;
        }
      }
      if (this.ECK.length() > 0) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        qT(paramBoolean);
        AppMethodBeat.o(31625);
        return;
      }
    }
    i(0, true, -1);
    qT(false);
    AppMethodBeat.o(31625);
  }
  
  public final void beX(String paramString)
  {
    AppMethodBeat.i(31675);
    com.tencent.mm.plugin.groupsolitaire.ui.d locald;
    String str2;
    if ((this.KiC != null) && (this.han != null) && (this.Kjy != null))
    {
      locald = this.KiC;
      str2 = this.Kjy.getTalkerUserName();
      localObject = this.han;
      Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow supportAnalyze:%s supportShow:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.j.class)).aBf(str2)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.j.class)).aBg(str2)) });
      locald.ygS = ((View)localObject);
      locald.content = paramString;
      if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.j.class)).aBf(str2))
      {
        if ((Util.isNullOrNil(paramString)) || (paramString.equals(locald.ygH))) {
          break label324;
        }
        com.tencent.f.h.RTc.bqo("GroupSolitaireCheck");
      }
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.a.class)).alW(paramString);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    locald.ygP.setContent(paramString);
    locald.ygP.aBs(locald.ygk);
    com.tencent.f.h.RTc.a(locald.ygP, 500L, "GroupSolitaireCheck");
    Object localObject = paramString;
    if (Util.isNullOrNil(locald.ygH))
    {
      locald.ygQ.setContent(paramString);
      locald.ygQ.aBs(locald.ygk);
      com.tencent.f.h.RTc.a(locald.ygQ, 500L, "GroupSolitaireCopyCheck");
      localObject = paramString;
    }
    for (;;)
    {
      locald.ygH = ((String)localObject);
      locald.ygk = str2;
      AppMethodBeat.o(31675);
      return;
      label324:
      String str1 = paramString;
      if (Util.isNullOrNil(paramString))
      {
        locald.dYf();
        str1 = paramString;
      }
    }
  }
  
  public final void bj(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31602);
    if (this.KiG.Kmo.containsKey(paramString1)) {}
    Object localObject;
    for (paramString1 = (LinkedList)this.KiG.Kmo.get(paramString1);; paramString1 = (String)localObject)
    {
      localObject = new HashMap(1);
      ((HashMap)localObject).put(paramString3, paramString2);
      paramString1.add(localObject);
      AppMethodBeat.o(31602);
      return;
      localObject = new LinkedList();
      this.KiG.Kmo.put(paramString1, localObject);
    }
  }
  
  public final void cDd()
  {
    AppMethodBeat.i(31610);
    this.KjZ.setExitType(1);
    this.Kim.setEnabled(false);
    this.Kim.setBackgroundResource(2131234632);
    if (this.Kkf)
    {
      this.Kkh.update();
      this.qPx.sendEmptyMessageDelayed(0, 500L);
      AppMethodBeat.o(31610);
      return;
    }
    if (this.FQS != null)
    {
      this.teZ.setVisibility(0);
      this.KiN.setVisibility(8);
      this.FQV.setVisibility(8);
      this.FQS.update();
      this.KjY.dismiss();
    }
    this.qPx.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(31610);
  }
  
  public final void dYi()
  {
    AppMethodBeat.i(31679);
    if (this.ECK != null)
    {
      this.ECK.setText("");
      gqh();
      if (this.rum != null) {
        this.rum.setToSendText("");
      }
    }
    AppMethodBeat.o(31679);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31578);
    if (this.rum != null)
    {
      Log.i("MicroMsg.ChatFooter", "jacks chat footer destroy smiley panel");
      this.rum.goC();
      this.rum.destroy();
      this.rum.animate().cancel();
      this.rum = null;
    }
    if (this.Kdp != null)
    {
      this.Kdp.destroy();
      this.Kdp = null;
      this.Kds = false;
    }
    if (this.KiD != null) {
      this.KiD.release();
    }
    if (this.KiB != null)
    {
      this.KiB.Kjv = null;
      this.KiB.Knu = null;
      this.KiB.hide();
    }
    if (this.FQS != null)
    {
      if (this.KjE != null) {
        this.KjE.getBlurController().destroy();
      }
      if (this.KjU != null) {
        this.KjU.getBlurController().destroy();
      }
    }
    Log.i("MicroMsg.ChatFooter", "jacks destroy chat footer.");
    this.ECK.destroy();
    AppMethodBeat.o(31578);
  }
  
  public final int gK(String paramString, int paramInt)
  {
    AppMethodBeat.i(163213);
    int i = paramInt;
    if (this.KiG.Kmo.containsKey(paramString))
    {
      i = paramInt;
      if (((LinkedList)this.KiG.Kmo.get(paramString)).size() > 0) {
        i = paramInt | 0x1;
      }
    }
    paramInt = i;
    if (this.KiJ) {
      if (!this.KiK) {
        break label78;
      }
    }
    label78:
    for (paramInt = 4;; paramInt = 8)
    {
      paramInt = i | paramInt;
      AppMethodBeat.o(163213);
      return paramInt;
    }
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163215);
    ArrayList localArrayList = this.Kik.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163215);
    return localArrayList;
  }
  
  public String getAtSomebody()
  {
    return this.KiG.Kmm;
  }
  
  public int getBarGroupHeight()
  {
    AppMethodBeat.i(31585);
    if (this.KiP == null) {
      this.KiP = findViewById(2131298434);
    }
    if (this.KiP != null)
    {
      i = this.KiP.getHeight();
      AppMethodBeat.o(31585);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131165310);
    AppMethodBeat.o(31585);
    return i;
  }
  
  public f getCallback()
  {
    return this.KbA;
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
    return this.Kjd;
  }
  
  public ab.a getIOnToDoBarCallback()
  {
    return this.Kjq;
  }
  
  public int getInsertPos()
  {
    return this.KiG.Kmn;
  }
  
  public boolean getIsVoiceInputPanleShow()
  {
    return this.Kds;
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
    return this.KiG.Kml;
  }
  
  public long getLastQuoteMsgId()
  {
    AppMethodBeat.i(31612);
    if ((this.Kix.getTag() != null) && ((this.Kix.getTag() instanceof ca)))
    {
      long l = ((ca)this.Kix.getTag()).field_msgId;
      AppMethodBeat.o(31612);
      return l;
    }
    AppMethodBeat.o(31612);
    return 0L;
  }
  
  public String getLastText()
  {
    AppMethodBeat.i(31611);
    if (this.ECK == null)
    {
      AppMethodBeat.o(31611);
      return "";
    }
    String str = this.ECK.getText().toString();
    AppMethodBeat.o(31611);
    return str;
  }
  
  public int getMode()
  {
    return this.KiR;
  }
  
  public View getPanel()
  {
    return this.Kip;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(31613);
    int i = this.ECK.getSelectionStart();
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
    if (this.KiY == 0) {
      i = getHeight() - this.Kjj;
    }
    for (;;)
    {
      AppMethodBeat.o(31684);
      return i;
      int j = getHeight() - this.Kjj + getKeyBordHeightPX();
      i = j;
      if (this.Kjp != null) {
        i = j - this.Kjp.dYg();
      }
    }
  }
  
  public final void gf(String paramString, int paramInt)
  {
    AppMethodBeat.i(232305);
    if (paramInt == 2)
    {
      appendText("#" + paramString + " ");
      AppMethodBeat.o(232305);
      return;
    }
    appendText(paramString + " ");
    AppMethodBeat.o(232305);
  }
  
  public final void go(View paramView)
  {
    int i = -1;
    AppMethodBeat.i(163212);
    if (this.KiD != null) {
      this.KiD.ehP();
    }
    Log.i("MicroMsg.ChatFooter", "click attach btn: %s, %s", new Object[] { Integer.valueOf(this.Kik.getVisibility()), Boolean.valueOf(this.Kip.grr()) });
    if (this.KiY == 3)
    {
      if (this.KiR == 1)
      {
        showVKB();
        AppMethodBeat.o(163212);
        return;
      }
      i(0, true, -1);
      AppMethodBeat.o(163212);
      return;
    }
    Object localObject;
    if (paramView == null)
    {
      i(3, true, i);
      if ((this.Kdp != null) && (this.Kdp.getVisibility() == 0) && (this.Kds))
      {
        Log.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
        this.Kdp.setVisibility(8);
        this.Kds = false;
        this.Kdp.reset();
      }
      paramView = ap.gni();
      localObject = MMApplicationContext.getContext();
      if ((com.tencent.mm.kernel.g.aAc()) && (localObject != null)) {
        break label284;
      }
      label187:
      ap.gni().iu(MMApplicationContext.getContext());
      if ((ab.Ix(this.toUser)) && (aa.ame()))
      {
        paramView = this.toUser;
        if (!ab.JO(paramView)) {
          break label530;
        }
        i = 2;
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject = new com.tencent.mm.g.b.a.af();
        ((com.tencent.mm.g.b.a.af)localObject).ik(paramView);
        ((com.tencent.mm.g.b.a.af)localObject).ejW = 1L;
        ((com.tencent.mm.g.b.a.af)localObject).enM = i;
        ((com.tencent.mm.g.b.a.af)localObject).bfK();
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
          String str = com.tencent.mm.n.h.aqJ().getValue("ShowAPPSuggestion");
          if ((Util.isNullOrNil(str)) || (Integer.valueOf(str).intValue() != 1)) {
            Log.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[] { str });
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[] { localException.getMessage() });
          if (paramView.JXl)
          {
            Log.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
            break label187;
          }
          Log.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
          paramView.JXl = true;
          if (System.currentTimeMillis() - paramView.JXo < 43200000L)
          {
            Log.d("MicroMsg.SuggestionAppListLogic", "not now");
            paramView.JXl = false;
            break label187;
          }
          com.tencent.mm.kernel.g.aAi();
          paramView.JXo = com.tencent.mm.kernel.g.aAh().azQ().akg(352275);
          if (System.currentTimeMillis() - paramView.JXo < 43200000L)
          {
            Log.w("MicroMsg.SuggestionAppListLogic", "not now sp");
            paramView.JXl = false;
            break label187;
          }
          if (paramView.lang == null) {
            paramView.lang = LocaleUtil.loadApplicationLanguage(((Context)localObject).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), (Context)localObject);
          }
          paramView = new com.tencent.mm.pluginsdk.model.app.af(paramView.lang, new LinkedList());
          com.tencent.mm.plugin.r.a.eAV();
          com.tencent.mm.pluginsdk.model.app.e.a(4, paramView);
        }
      }
      break label187;
      label530:
      if (ab.JN(paramView)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void goD()
  {
    AppMethodBeat.i(31591);
    this.KiV = true;
    if (this.rum != null) {
      this.rum.goD();
    }
    AppMethodBeat.o(31591);
  }
  
  public final void gpb()
  {
    AppMethodBeat.i(31601);
    if (!this.Kds)
    {
      AppMethodBeat.o(31601);
      return;
    }
    this.Kds = false;
    if (this.Kdp != null)
    {
      int i = getKeyBordHeightPX();
      int j = this.Kio.getHeight();
      this.Kdp.animate().cancel();
      this.Kdp.animate().translationY(i + j).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(31529);
          if (ChatFooter.az(ChatFooter.this) != null)
          {
            ChatFooter.az(ChatFooter.this).destroy();
            ChatFooter.az(ChatFooter.this).setVisibility(8);
          }
          AppMethodBeat.o(31529);
        }
      }).start();
    }
    this.ECK.setText("");
    AppMethodBeat.o(31601);
  }
  
  public final void gqA()
  {
    AppMethodBeat.i(31636);
    AppPanel localAppPanel = this.Kik;
    localAppPanel.KgZ = true;
    localAppPanel.KgQ.Ab(false);
    localAppPanel.gpV();
    Log.i("MicroMsg.AppPanel", "disableServiceRemittance %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(31636);
  }
  
  public final void gqB()
  {
    AppMethodBeat.i(232298);
    this.Kik.gpN();
    AppMethodBeat.o(232298);
  }
  
  public final void gqC()
  {
    AppMethodBeat.i(232299);
    AppPanel localAppPanel = this.Kik;
    localAppPanel.KgQ.Khp.value = false;
    localAppPanel.gpV();
    AppMethodBeat.o(232299);
  }
  
  public final void gqD()
  {
    AppMethodBeat.i(31637);
    if (this.Kit != null) {
      this.Kit.setVisibility(8);
    }
    AppMethodBeat.o(31637);
  }
  
  public final void gqE()
  {
    AppMethodBeat.i(31638);
    AppPanel localAppPanel = this.Kik;
    localAppPanel.Kha = true;
    localAppPanel.KgQ.Af(false);
    localAppPanel.gpV();
    AppMethodBeat.o(31638);
  }
  
  public final void gqF()
  {
    AppMethodBeat.i(31639);
    Log.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
    this.KiU = true;
    this.ECK.setImeOptions(4);
    this.ECK.setInputType(this.ECK.getInputType() & 0xFFFFFFBF);
    AppMethodBeat.o(31639);
  }
  
  public final boolean gqI()
  {
    AppMethodBeat.i(31645);
    if ((this.Kjx == null) || (this.Kjx.getView() == null))
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Object localObject = this.Kjx.getView().findViewById(2131304715);
    if (localObject == null)
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Rect localRect = new Rect();
    ((View)localObject).getGlobalVisibleRect(localRect);
    if (com.tencent.mm.compatible.util.d.oD(28))
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
  
  public final boolean gqJ()
  {
    return this.KiY != 0;
  }
  
  public final void gqK()
  {
    AppMethodBeat.i(31653);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(232263);
        Log.i("MicroMsg.ChatFooter", "withLastText: ");
        ChatFooter.this.showVKB();
        ChatFooter.a(ChatFooter.this, true);
        AppMethodBeat.o(232263);
      }
    }, 500L);
    AppMethodBeat.o(31653);
  }
  
  public final void gqL()
  {
    AppMethodBeat.i(31655);
    if ((this.Kdp != null) && (this.Kdp.isShown())) {
      this.Kdp.grA();
    }
    AppMethodBeat.o(31655);
  }
  
  public final void gqO()
  {
    AppMethodBeat.i(232301);
    if (this.KiB != null)
    {
      this.KiB.Knv = false;
      this.KiB.hide();
    }
    AppMethodBeat.o(232301);
  }
  
  public final void gqP()
  {
    AppMethodBeat.i(31674);
    if (this.KiC != null) {
      this.KiC.dYf();
    }
    AppMethodBeat.o(31674);
  }
  
  public final boolean gqQ()
  {
    AppMethodBeat.i(31677);
    if ((this.Kix.getTag() != null) && ((this.Kix.getTag() instanceof ca)) && (this.Kiw.isShown()) && (this.Kix.isShown()))
    {
      AppMethodBeat.o(31677);
      return true;
    }
    AppMethodBeat.o(31677);
    return false;
  }
  
  public final void gqR()
  {
    AppMethodBeat.i(31681);
    this.Kim.setBackgroundResource(2131233164);
    this.Kim.setText(2131757294);
    Object localObject;
    if (this.Kkf)
    {
      if (!this.KlF)
      {
        this.KlF = true;
        if (this.KiD == null) {
          break label299;
        }
        this.KjZ.GtP = this.KiD.aas();
        if ((this.Kkh == null) || (!this.Kkh.isShowing())) {
          break label299;
        }
        if (e.Kmq == this.KlT)
        {
          this.KkT = false;
          this.KiD.ehL();
          this.KjZ.setExitType(2);
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OnJ, Boolean.FALSE);
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        AppMethodBeat.o(31681);
        return;
      }
      if (e.Kmr == this.KlT)
      {
        if (this.KlE <= 0) {
          this.KlE = ((int)this.KiD.aas());
        }
        if (!Util.isNullOrNil(this.KiD.getFileName()))
        {
          localObject = com.tencent.mm.cj.a.Owq;
          com.tencent.mm.cj.a.a.blJ(this.KiD.getFileName());
        }
        this.KiD.ehJ();
        grk();
        this.GvO.sendEmptyMessageDelayed(5000, 5000L);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OnJ, Boolean.FALSE);
        AppMethodBeat.o(31681);
        return;
      }
      if (e.Kmp == this.KlT)
      {
        this.KkT = false;
        this.KiD.ehI();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OnI, Boolean.FALSE);
      }
      label299:
      AppMethodBeat.o(31681);
      return;
    }
    this.qPk = false;
    if (this.KiD != null)
    {
      this.KjZ.GtP = this.KiD.aas();
      if (this.KiS)
      {
        if (k.KmH != this.Kkc)
        {
          this.KlD = true;
          if ((this.FQS != null) && (this.FQS.isShowing()))
          {
            if (k.KmJ == this.Kkc)
            {
              Log.i("MicroMsg.ChatFooter", "do not send voice.");
              this.KjZ.setExitType(2);
              this.KiD.ehL();
              AppMethodBeat.o(31681);
              return;
            }
            Log.i("MicroMsg.ChatFooter", "trans voice to txt.");
            this.KiD.ehJ();
            localObject = this.KiD.getFileName();
            final long l = this.KiD.aas();
            Log.i("transvoice", "fileName: %s, voiceLen: %d.", new Object[] { localObject, Long.valueOf(l) });
            if (NetStatusUtil.isConnected(getContext()))
            {
              if (this.KjX.isValid())
              {
                this.KjV.aTN((String)localObject);
                this.KjV.GvG = l;
                this.KjV.talker = this.Kij;
                this.KjV.show();
                this.KjV.c(this.KjX);
                this.Kjf = false;
                AppMethodBeat.o(31681);
                return;
              }
              this.KjZ.setExitType(3);
              locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
              locala.boo(getResources().getString(2131767167));
              locala.bou(getResources().getString(2131767168));
              locala.aoX(getResources().getColor(2131099784));
              locala.c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(232271);
                  ChatFooter.l(ChatFooter.this).aDO(this.val$fileName);
                  AppMethodBeat.o(232271);
                }
              });
              locala.Dk(false);
              locala.hbn().show();
              AppMethodBeat.o(31681);
              return;
            }
            this.KjZ.setExitType(4);
            com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(getContext());
            locala.boo(getResources().getString(2131763513));
            locala.bou(getResources().getString(2131763515));
            locala.aoX(getResources().getColor(2131099784));
            locala.bov(getResources().getString(2131763514));
            locala.c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(232272);
                ChatFooter.l(ChatFooter.this).eu(this.val$fileName, (int)l);
                AppMethodBeat.o(232272);
              }
            });
            locala.d(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(232273);
                ChatFooter.l(ChatFooter.this).aDO(this.val$fileName);
                AppMethodBeat.o(232273);
              }
            });
            locala.hbn().show();
            AppMethodBeat.o(31681);
          }
        }
        else
        {
          this.KiD.ehI();
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        if ((this.tfc != null) && (this.tfc.getVisibility() == 0))
        {
          this.KjZ.setExitType(2);
          this.KiD.ehL();
          AppMethodBeat.o(31681);
          return;
        }
        this.KiD.ehI();
      }
    }
    AppMethodBeat.o(31681);
  }
  
  public final void gqS()
  {
    AppMethodBeat.i(31683);
    bg.aVF();
    this.Kjw = ((Boolean)com.tencent.mm.model.c.azQ().get(66832, Boolean.FALSE)).booleanValue();
    if (this.ECK != null) {
      this.ECK.setEnableSendBtn(this.Kjw);
    }
    AppMethodBeat.o(31683);
  }
  
  public final boolean gqT()
  {
    AppMethodBeat.i(232303);
    if ((this.Kjy != null) && (this.Kjy.grq() != null))
    {
      if ((!((com.tencent.mm.ui.chatting.d.b.h)this.Kjy.grq().bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu()) && (!((com.tencent.mm.ui.chatting.d.b.i)this.Kjy.grq().bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw()))
      {
        AppMethodBeat.o(232303);
        return true;
      }
      AppMethodBeat.o(232303);
      return false;
    }
    AppMethodBeat.o(232303);
    return true;
  }
  
  public final void gqU()
  {
    AppMethodBeat.i(31685);
    if ((this.han == null) || (this.han.getVisibility() == 8))
    {
      AppMethodBeat.o(31685);
      return;
    }
    if (this.KlJ == 0)
    {
      this.KlJ = this.han.getWidth();
      this.KlK = this.Kir.getWidth();
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.KlJ, this.KlK });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(185386);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bv(ChatFooter.this)) / (ChatFooter.bw(ChatFooter.this) - ChatFooter.bv(ChatFooter.this));
        ChatFooter.k(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(185386);
      }
    });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(232276);
        ChatFooter.k(ChatFooter.this).setVisibility(8);
        AppMethodBeat.o(232276);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(232275);
        if (!ChatFooter.bx(ChatFooter.this))
        {
          ChatFooter.k(ChatFooter.this).setVisibility(8);
          AppMethodBeat.o(232275);
          return;
        }
        Log.i("MicroMsg.ChatFooter", "animHideSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bx(ChatFooter.this)) });
        ChatFooter.this.gqV();
        AppMethodBeat.o(232275);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(232274);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(232274);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.start();
    AppMethodBeat.o(31685);
  }
  
  public final void gqV()
  {
    AppMethodBeat.i(31686);
    if (this.han == null)
    {
      AppMethodBeat.o(31686);
      return;
    }
    if (this.KlJ == 0)
    {
      this.KlJ = this.han.getWidth();
      this.KlK = this.Kir.getWidth();
    }
    if (this.KlJ == 0)
    {
      this.han.startAnimation(this.Kjz);
      this.han.setVisibility(0);
      AppMethodBeat.o(31686);
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.KlK, this.KlJ });
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
    localValueAnimator.setDuration(150L);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(232279);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        ChatFooter.u(ChatFooter.this).setVisibility(8);
        ChatFooter.j(ChatFooter.this, false);
        AppMethodBeat.o(232279);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(232278);
        paramAnonymousAnimator = ChatFooter.k(ChatFooter.this).getLayoutParams();
        paramAnonymousAnimator.width = -2;
        ChatFooter.k(ChatFooter.this).setLayoutParams(paramAnonymousAnimator);
        ChatFooter.u(ChatFooter.this).setVisibility(8);
        ChatFooter.j(ChatFooter.this, false);
        if (!ChatFooter.bx(ChatFooter.this))
        {
          Log.i("MicroMsg.ChatFooter", "animShowSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bx(ChatFooter.this)) });
          ChatFooter.u(ChatFooter.this).setVisibility(0);
          ChatFooter.j(ChatFooter.this, true);
          ChatFooter.this.gqU();
        }
        AppMethodBeat.o(232278);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(232277);
        ChatFooter.k(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(232277);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(31686);
  }
  
  public final void gqW()
  {
    AppMethodBeat.i(232304);
    if ((this.Kir != null) && (this.Kir.getVisibility() == 0))
    {
      Am(true);
      AppMethodBeat.o(232304);
      return;
    }
    AppMethodBeat.o(232304);
  }
  
  public final void gqi()
  {
    AppMethodBeat.i(232295);
    if (!Util.isNullOrNil(this.ECK.getText()))
    {
      this.ECK.setText("");
      if (this.rum != null) {
        this.rum.setToSendText("");
      }
    }
    Ah(false);
    gqh();
    AppMethodBeat.o(232295);
  }
  
  public final void gqj()
  {
    AppMethodBeat.i(31581);
    if (!Util.isNullOrNil(this.Kiy.getText())) {
      this.Kiy.setText("");
    }
    if (this.Kix.getTag() != null) {
      this.Kix.setTag(null);
    }
    this.Kix.setVisibility(8);
    AppMethodBeat.o(31581);
  }
  
  public final void gqk()
  {
    AppMethodBeat.i(31583);
    if (this.Kik == null)
    {
      AppMethodBeat.o(31583);
      return;
    }
    this.Kik.gpK();
    AppMethodBeat.o(31583);
  }
  
  public final void gql()
  {
    AppMethodBeat.i(31587);
    this.Kit = ((ImageButton)this.jxm.findViewById(2131298551));
    this.Kit.setVisibility(0);
    if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.OgW, true)) {
      this.jxm.findViewById(2131298552).setVisibility(0);
    }
    for (;;)
    {
      this.jxm.findViewById(2131298552).setVisibility(8);
      this.Kit.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(232232);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = com.tencent.mm.emoji.c.b.hcd;
          com.tencent.mm.emoji.c.b.avZ();
          if (ChatFooter.l(ChatFooter.this) != null) {
            ChatFooter.l(ChatFooter.this).ehO();
          }
          if (ChatFooter.c(ChatFooter.this) == 2) {
            ChatFooter.this.showVKB();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(232232);
            return;
            if (ChatFooter.v(ChatFooter.this)) {
              ChatFooter.this.goD();
            }
            ChatFooter.this.gqo();
            if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.OgW, false))
            {
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgW, Boolean.TRUE);
              ChatFooter.w(ChatFooter.this).findViewById(2131298552).setVisibility(8);
            }
          }
        }
      });
      if (this.KiB != null) {
        this.KiB.Knt = this.Kit;
      }
      if (this.KiC != null) {
        this.KiC.ygE = this.jxm;
      }
      AppMethodBeat.o(31587);
      return;
      this.jxm.findViewById(2131298552).setVisibility(8);
    }
  }
  
  public final void gqm()
  {
    boolean bool = true;
    AppMethodBeat.i(31590);
    if ((e.Knc == null) || (getContext() == null))
    {
      if (getContext() == null)
      {
        Log.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", new Object[] { Util.getStack() });
        this.rum = new d(MMApplicationContext.getContext());
        AppMethodBeat.o(31590);
        return;
      }
      this.rum = new d(getContext());
      AppMethodBeat.o(31590);
      return;
    }
    if (this.rum != null) {
      this.rum.destroy();
    }
    this.rum = e.Knc.eZ(getContext());
    ChatFooterPanel localChatFooterPanel;
    if (this.rum != null)
    {
      this.rum.setEntranceScene(ChatFooterPanel.KbC);
      this.rum.setVisibility(8);
      this.rum.setFooterType(this.IFI);
      if (this.Kip != null) {
        this.Kip.addView(this.rum, -1, -1);
      }
      this.rum.setOnTextOperationListener(this.KkU);
      localChatFooterPanel = this.rum;
      if (this.ECK.getText().length() <= 0) {
        break label271;
      }
    }
    for (;;)
    {
      localChatFooterPanel.setSendButtonEnable(bool);
      if (this.Kjy != null) {
        this.rum.setTalkerName(this.Kjy.getTalkerUserName());
      }
      this.rum.onResume();
      if (this.KiV) {
        goD();
      }
      setSmileyPanelCallback(this.KbA);
      AppMethodBeat.o(31590);
      return;
      label271:
      bool = false;
    }
  }
  
  public final void gqo()
  {
    AppMethodBeat.i(31597);
    this.KiR = 1;
    Ai(true);
    if (this.ECK.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      qT(bool);
      this.Kim.setVisibility(8);
      aiw(2131231778);
      if (this.Kdp != null)
      {
        this.Kdp.setVisibility(8);
        this.Kds = false;
        this.Kdp.reset();
      }
      i(2, true, -1);
      AppMethodBeat.o(31597);
      return;
    }
  }
  
  public final void gqr()
  {
    AppMethodBeat.i(31620);
    if (this.Kkf)
    {
      this.Kkm.setVisibility(0);
      this.KkQ.setVisibility(8);
      AppMethodBeat.o(31620);
      return;
    }
    this.FQV.setVisibility(8);
    this.KiN.setVisibility(0);
    AppMethodBeat.o(31620);
  }
  
  public final void gqs()
  {
    AppMethodBeat.i(31626);
    Ai(true);
    this.Kin.setVisibility(8);
    this.Kim.setVisibility(8);
    AppMethodBeat.o(31626);
  }
  
  public final void gqt()
  {
    AppMethodBeat.i(31627);
    if (this.Kin != null) {
      this.Kin.setVisibility(0);
    }
    AppMethodBeat.o(31627);
  }
  
  public final void gqu()
  {
    AppMethodBeat.i(31628);
    AppPanel localAppPanel = this.Kik;
    localAppPanel.KgQ.Khn.value = false;
    localAppPanel.gpV();
    AppMethodBeat.o(31628);
  }
  
  public final void gqv()
  {
    AppMethodBeat.i(31629);
    AppPanel localAppPanel = this.Kik;
    localAppPanel.KgQ.KhF.value = false;
    localAppPanel.gpV();
    AppMethodBeat.o(31629);
  }
  
  public final void gqw()
  {
    AppMethodBeat.i(31630);
    AppPanel localAppPanel = this.Kik;
    localAppPanel.KgQ.Kho.value = false;
    localAppPanel.gpV();
    AppMethodBeat.o(31630);
  }
  
  public final void gqx()
  {
    AppMethodBeat.i(31631);
    AppPanel localAppPanel = this.Kik;
    localAppPanel.KgQ.Khr.value = false;
    localAppPanel.gpV();
    AppMethodBeat.o(31631);
  }
  
  public final void gqy()
  {
    AppMethodBeat.i(31635);
    AppPanel localAppPanel = this.Kik;
    localAppPanel.KgY = true;
    localAppPanel.KgQ.Ae(false);
    localAppPanel.gpV();
    Log.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(31635);
  }
  
  public final void gqz()
  {
    this.Kik.Khb = true;
  }
  
  public final boolean grl()
  {
    AppMethodBeat.i(185416);
    if ((this.Kkh != null) && (this.Kkh.isShowing()))
    {
      AppMethodBeat.o(185416);
      return true;
    }
    AppMethodBeat.o(185416);
    return false;
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
  
  public final void i(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(163217);
    Log.i("MicroMsg.ChatFooter", "configPanel: %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.xfU), Boolean.valueOf(this.Kje), Boolean.valueOf(this.KiX) });
    int i;
    int j;
    label98:
    int k;
    if ((this.Kje) || (!this.KiX))
    {
      i = 1;
      if ((paramInt1 != 1) || (this.xfU)) {
        break label199;
      }
      j = 1;
      if ((paramInt1 == 1) || (!this.xfU)) {
        break label205;
      }
      k = 1;
      label113:
      if ((i == 0) && ((j != 0) || (k != 0))) {
        break label211;
      }
      j(paramInt1, paramBoolean, paramInt2);
      label135:
      if (j != 0)
      {
        this.Kjh = 0;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(232266);
            ChatFooter.a(ChatFooter.this, true);
            ChatFooter.this.setToSendTextColor(true);
            boolean bool = ChatFooter.aP(ChatFooter.this).showSoftInput(ChatFooter.d(ChatFooter.this).gYG(), 0);
            ChatFooter.bq(ChatFooter.this);
            Log.i("MicroMsg.ChatFooter", "showSoftInput %b, %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(ChatFooter.br(ChatFooter.this)) });
            if ((!bool) && (ChatFooter.br(ChatFooter.this) < 10)) {
              ChatFooter.this.postDelayed(this, 100L);
            }
            AppMethodBeat.o(232266);
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
      this.xfU = paramBoolean;
      AppMethodBeat.o(163217);
      return;
      i = 0;
      break;
      j = 0;
      break label98;
      k = 0;
      break label113;
      this.KiZ = paramInt1;
      break label135;
    }
  }
  
  public final void l(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(31582);
    if ((this.Kix.getTag() != null) && ((this.Kix.getTag() instanceof ca)) && (Util.isEqual(paramLong, ((ca)this.Kix.getTag()).field_msgId))) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185798);
          if (!paramBoolean) {
            com.tencent.mm.ui.base.h.c(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(2131763193), "", true);
          }
          ChatFooter.this.gqj();
          AppMethodBeat.o(185798);
        }
      });
    }
    AppMethodBeat.o(31582);
  }
  
  public final void mC(String paramString1, String paramString2)
  {
    this.dRL = paramString1;
    this.toUser = paramString2;
  }
  
  public final HashMap<String, String> mD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31603);
    long l = System.currentTimeMillis();
    if (Util.isNullOrNil(paramString2))
    {
      if (this.KiG.Kmo.containsKey(paramString1)) {
        this.KiG.Kmo.remove(paramString1);
      }
      AppMethodBeat.o(31603);
      return null;
    }
    if ((!this.KiG.Kmo.containsKey(paramString1)) || (((LinkedList)this.KiG.Kmo.get(paramString1)).size() <= 0))
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
      ((LinkedList)this.KiG.Kmo.get(paramString1)).clear();
      AppMethodBeat.o(31603);
      return null;
    }
    paramString1 = (LinkedList)this.KiG.Kmo.get(paramString1);
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
    gqN();
    gqM();
    aiC(getKeyBordHeightPX());
    AppMethodBeat.o(31579);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31643);
    super.onConfigurationChanged(paramConfiguration);
    if (com.tencent.mm.compatible.util.d.oD(24)) {
      this.Kje = ((Activity)getContext()).isInMultiWindowMode();
    }
    if (paramConfiguration.orientation == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.KiX = bool;
      i(0, false, -1);
      gqN();
      Log.i("MicroMsg.ChatFooter", "onConfigurationChanged: %s, %s, %s", new Object[] { paramConfiguration, Boolean.valueOf(this.KiX), Boolean.valueOf(this.Kje) });
      aiC(getKeyBordHeightPX());
      paramConfiguration = com.tencent.mm.plugin.patmsg.ui.b.ARN;
      paramConfiguration = com.tencent.mm.plugin.patmsg.ui.b.eBs();
      if (paramConfiguration != null) {
        paramConfiguration.dismiss();
      }
      AppMethodBeat.o(31643);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(31580);
    super.onDetachedFromWindow();
    this.gyh.close();
    this.Kja = null;
    this.Kjb = false;
    AppMethodBeat.o(31580);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(232306);
    this.ECK.gYJ();
    this.Kjg = false;
    showVKB();
    KiM = null;
    AppMethodBeat.o(232306);
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
    this.wxq = false;
    if ((this.Kjc == 48) && (this.KiY == 1) && (!this.Kjn))
    {
      this.xfU = false;
      j(0, true, -1);
    }
    this.gyh.close();
    if (this.rum != null) {
      this.rum.onPause();
    }
    if ((this.Kds) && (this.Kdp != null)) {
      this.Kdp.pause();
    }
    if (this.KiD != null) {
      this.KiD.onPause();
    }
    if (this.KiB != null) {
      this.KiB.hide();
    }
    if ((this.FQS != null) && (this.FQS.isShowing())) {
      this.FQS.dismiss();
    }
    gqP();
    this.ECK.onPause();
    AppMethodBeat.o(31577);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31672);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(31672);
  }
  
  public void setAppPanelListener(AppPanel.a parama)
  {
    AppMethodBeat.i(31649);
    this.Kik.setAppPanelListener(parama);
    AppMethodBeat.o(31649);
  }
  
  public void setAppPanelTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(31595);
    if ((this.Kiq == null) || (this.Kik == null))
    {
      AppMethodBeat.o(31595);
      return;
    }
    this.Kiq.setText(paramCharSequence);
    if (!Util.isNullOrNil(paramCharSequence)) {
      if (this.Kik.getVisibility() != 0) {
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
    if (this.Kiq == null)
    {
      AppMethodBeat.o(31596);
      return;
    }
    if (TextUtils.isEmpty(this.Kiq.getText()))
    {
      this.Kiq.setVisibility(8);
      AppMethodBeat.o(31596);
      return;
    }
    if (paramBoolean)
    {
      localObject = this.Kiq.getContext();
      i = this.Kip.getHeight();
      int j = getKeyBordHeightPX();
      int k = com.tencent.mm.cb.a.fromDPToPix((Context)localObject, 32);
      localObject = this.Kiq.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (i - j + k);
        this.Kiq.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    Object localObject = this.Kiq;
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
    this.Kik.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163214);
  }
  
  public void setAppPanelVisible(int paramInt)
  {
    AppMethodBeat.i(31642);
    if (this.Kik != null) {
      this.Kik.setVisibility(paramInt);
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
    this.KiG.Kmm = paramString;
  }
  
  public void setBottomPanelVisibility(int paramInt)
  {
    AppMethodBeat.i(31644);
    if (paramInt == 0)
    {
      this.Kip.setVisibility(paramInt);
      AppMethodBeat.o(31644);
      return;
    }
    i(0, true, -1);
    AppMethodBeat.o(31644);
  }
  
  public void setCattingRootLayoutId(int paramInt)
  {
    this.KlI = null;
    this.KlH = paramInt;
  }
  
  public void setDefaultSmileyByDetail(String paramString)
  {
    AppMethodBeat.i(31600);
    if (!Util.isNullOrNil(paramString))
    {
      if (this.rum == null) {
        gqm();
      }
      this.rum.setDefaultEmojiByDetail(paramString);
    }
    AppMethodBeat.o(31600);
  }
  
  @TargetApi(11)
  public void setEditTextOnDragListener(View.OnDragListener paramOnDragListener)
  {
    AppMethodBeat.i(31647);
    this.ECK.setOnDragListener(paramOnDragListener);
    AppMethodBeat.o(31647);
  }
  
  public void setExitType(int paramInt)
  {
    AppMethodBeat.i(185414);
    com.tencent.mm.plugin.transvoice.a.c.a locala = com.tencent.mm.plugin.transvoice.a.c.Guc;
    com.tencent.mm.plugin.transvoice.a.c.fAu().setExitType(paramInt);
    AppMethodBeat.o(185414);
  }
  
  public void setFooterEventListener(b paramb)
  {
    this.KiD = paramb;
  }
  
  public void setFooterStatus(boolean paramBoolean) {}
  
  public void setFooterType(int paramInt)
  {
    AppMethodBeat.i(31576);
    this.IFI = paramInt;
    if (this.rum != null) {
      this.rum.setFooterType(paramInt);
    }
    AppMethodBeat.o(31576);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(232297);
    if (this.ECK != null) {
      this.ECK.setHint(paramCharSequence);
    }
    AppMethodBeat.o(232297);
  }
  
  public void setIOnTodoViewCallback(ab.c paramc)
  {
    this.Kjp = paramc;
  }
  
  public void setIgnoreScroll(Boolean paramBoolean)
  {
    AppMethodBeat.i(31661);
    this.Kjn = paramBoolean.booleanValue();
    AppMethodBeat.o(31661);
  }
  
  public void setInsertPos(int paramInt)
  {
    this.KiG.Kmn = paramInt;
  }
  
  public void setIsMultiWindow(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(31667);
    Log.i("MicroMsg.ChatFooter", "setIsMultiWindow: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.Kje != paramBoolean) {}
    for (;;)
    {
      this.Kje = paramBoolean;
      gqN();
      if (i != 0)
      {
        aiC(getKeyBordHeightPX());
        i(0, false, -1);
      }
      AppMethodBeat.o(31667);
      return;
      i = 0;
    }
  }
  
  public void setKeyboardShow(Boolean paramBoolean)
  {
    AppMethodBeat.i(31662);
    this.xfU = paramBoolean.booleanValue();
    AppMethodBeat.o(31662);
  }
  
  public void setLastContent(String paramString)
  {
    this.KiG.Kml = paramString;
  }
  
  public void setLastQuoteMsgId(long paramLong)
  {
    AppMethodBeat.i(31605);
    if (paramLong != 0L)
    {
      ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramLong);
      if (((localca.fqJ & 0x4) == 4) || (localca.getType() == 10000))
      {
        Log.e("MicroMsg.ChatFooter", "msg(%s) is revoked!", new Object[] { localca.getType() + "," + (localca.fqJ & 0x4) });
        com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(2131763193), "", true);
        AppMethodBeat.o(31605);
        return;
      }
      this.Kix.setTag(localca);
      AppMethodBeat.o(31605);
      return;
    }
    this.Kix.setTag(null);
    AppMethodBeat.o(31605);
  }
  
  public void setLastText(String paramString)
  {
    AppMethodBeat.i(31606);
    z(paramString, -1, true);
    AppMethodBeat.o(31606);
  }
  
  public void setLbsMode(boolean paramBoolean)
  {
    this.KiI = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    AppMethodBeat.i(31623);
    bA(paramInt, true);
    AppMethodBeat.o(31623);
  }
  
  public void setOnEditFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(31648);
    this.ECK.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(31648);
  }
  
  public void setOnFooterPanelSwitchListener(f paramf)
  {
    this.KiF = paramf;
  }
  
  public void setOnFooterSwitchListener(g paramg)
  {
    AppMethodBeat.i(31650);
    this.KiE = paramg;
    if (paramg == null)
    {
      AppMethodBeat.o(31650);
      return;
    }
    paramg = findViewById(2131298513);
    paramg.setVisibility(0);
    paramg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232262);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ChatFooter.bm(ChatFooter.this) != null) {
          ChatFooter.bm(ChatFooter.this).An(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232262);
      }
    });
    AppMethodBeat.o(31650);
  }
  
  public void setRecordNormalWording(String paramString)
  {
    AppMethodBeat.i(31618);
    if ((paramString == null) || (this.KiO == null))
    {
      AppMethodBeat.o(31618);
      return;
    }
    this.KiO.setText(paramString);
    AppMethodBeat.o(31618);
  }
  
  public void setSetTolastCustomPage(boolean paramBoolean) {}
  
  public void setSmileyPanelCallback(f paramf)
  {
    AppMethodBeat.i(31592);
    this.KbA = paramf;
    if (this.rum != null) {
      this.rum.setCallback(paramf);
    }
    AppMethodBeat.o(31592);
  }
  
  public void setSmileyPanelCallback2(j paramj)
  {
    this.KiB.Knu = paramj;
  }
  
  public void setSwitchButtonMode(int paramInt)
  {
    AppMethodBeat.i(31651);
    if (paramInt == this.Klx)
    {
      AppMethodBeat.o(31651);
      return;
    }
    this.Klx = paramInt;
    ImageView localImageView1 = (ImageView)findViewById(2131308798);
    ImageView localImageView2 = (ImageView)findViewById(2131305628);
    if (this.Klx == 1)
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
    this.Kjt = paramc;
  }
  
  @TargetApi(11)
  public void setToSendTextColor(final boolean paramBoolean)
  {
    AppMethodBeat.i(31652);
    if (com.tencent.mm.compatible.util.d.oD(11))
    {
      com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a()
      {
        public final void run()
        {
          AppMethodBeat.i(185794);
          Message localMessage = new Message();
          localMessage.what = 1002;
          localMessage.obj = Boolean.valueOf(paramBoolean);
          ChatFooter.bn(ChatFooter.this).sendMessage(localMessage);
          AppMethodBeat.o(185794);
        }
      });
      AppMethodBeat.o(31652);
      return;
    }
    if (paramBoolean)
    {
      this.ECK.setTextColor(getResources().getColor(2131100806));
      AppMethodBeat.o(31652);
      return;
    }
    this.ECK.setTextColor(getResources().getColor(2131100584));
    Ah(false);
    AppMethodBeat.o(31652);
  }
  
  public void setUserName(String paramString)
  {
    AppMethodBeat.i(31682);
    this.Kij = paramString;
    if (this.rum != null) {
      this.rum.setTalkerName(this.Kij);
    }
    if (this.Kik != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ChatFooter", "setusername: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (this.Kik == null) {
        break label167;
      }
      if ((!ab.JE(this.Kij)) && (!ab.Jv(this.Kij))) {
        break;
      }
      this.Kik.setServiceShowFlag(0);
      AppMethodBeat.o(31682);
      return;
    }
    if (ab.IT(this.Kij))
    {
      this.Kik.setServiceShowFlag(4);
      AppMethodBeat.o(31682);
      return;
    }
    if (ab.Eq(this.Kij))
    {
      this.Kik.setServiceShowFlag(2);
      AppMethodBeat.o(31682);
      return;
    }
    this.Kik.setServiceShowFlag(1);
    label167:
    AppMethodBeat.o(31682);
  }
  
  public void setVoice2txtCountDown(int paramInt)
  {
    AppMethodBeat.i(31619);
    if (-1 == paramInt)
    {
      this.KjG.setVisibility(0);
      this.KjI.setVisibility(8);
      AppMethodBeat.o(31619);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 10))
    {
      if (8 == this.KjI.getVisibility())
      {
        this.KjG.setVisibility(8);
        this.KjI.setVisibility(0);
      }
      if (this.KjI != null) {
        this.KjI.setImageResource(this.Kli[paramInt]);
      }
    }
    AppMethodBeat.o(31619);
  }
  
  public void setVoiceInputShowCallback(d paramd)
  {
    this.Kju = paramd;
  }
  
  public void setVoiceReactArea(int paramInt)
  {
    AppMethodBeat.i(185401);
    if (this.Kkf)
    {
      setNewVoice2TxtCountDown(paramInt);
      AppMethodBeat.o(185401);
      return;
    }
    if (paramInt < 10)
    {
      if (this.KiS)
      {
        setVoice2txtCountDown(paramInt);
        AppMethodBeat.o(185401);
        return;
      }
      if (-1 == paramInt)
      {
        setRecordNormalWording(getResources().getString(2131757277));
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
    this.Kil = ((TextView)this.jxm.findViewById(2131298594));
    this.ECK.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(31646);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(31656);
    if ((this.Kjx != null) && (this.Kjx.isSupportNavigationSwipeBack()) && (this.Kjx.getSwipeBackLayout() != null)) {
      this.Kjx.getSwipeBackLayout().setOnceDisEnableGesture(true);
    }
    if (!gqI())
    {
      i(1, true, -1);
      AppMethodBeat.o(31656);
      return;
    }
    Log.i("MicroMsg.ChatFooter", "isScrolling!! pass this event!");
    AppMethodBeat.o(31656);
  }
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(31670);
    Log.i("MicroMsg.ChatFooter", "onKeyboardHeightChanged: %s, %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(this.Kjc) });
    if (!this.Kjf)
    {
      AppMethodBeat.o(31670);
      return;
    }
    Object localObject = this.ECK;
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.widget.cedit.api.c)localObject).CS(bool);
      if (!this.Kjg)
      {
        localObject = SecDataUIC.CWq;
        if (((czj)SecDataUIC.a.c(getContext(), 4, czj.class)).MEF != 1) {
          break label149;
        }
      }
      if (paramInt > 0) {
        break;
      }
      this.xfU = false;
      AppMethodBeat.o(31670);
      return;
    }
    this.xfU = true;
    AppMethodBeat.o(31670);
    return;
    label149:
    int i;
    if ((this.Kkf) && (this.Kkh != null) && (this.Kkh.isShowing()))
    {
      if (paramInt <= 0)
      {
        this.xfU = false;
        this.Kkl.setCursorVisible(false);
        this.Kkv.animate().translationY(0.0F).setDuration(200L).start();
        this.Kkk.animate().translationY(0.0F).setDuration(200L).start();
        this.Kkn.animate().translationY(0.0F).setDuration(200L).start();
        this.Kkq.animate().translationY(0.0F).setDuration(200L).start();
        if (this.Kkk.getHeight() < this.Kls)
        {
          localObject = ValueAnimator.ofInt(new int[] { this.Kkk.getHeight(), this.Kls }).setDuration(200L);
          ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              AppMethodBeat.i(185376);
              int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
              ((ViewGroup.MarginLayoutParams)ChatFooter.aA(ChatFooter.this).getLayoutParams()).height = i;
              ChatFooter.aA(ChatFooter.this).requestLayout();
              AppMethodBeat.o(185376);
            }
          });
          ((ValueAnimator)localObject).start();
          AppMethodBeat.o(31670);
        }
      }
      else
      {
        this.xfU = true;
        this.Kkl.setCursorVisible(true);
        Log.d("MicroMsg.ChatFooter", "height:%s, WeUIToolHelper.getDisplayRealSize(getContext()).y - newVoice2txtOpeArea.getBottom():%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(au.az(getContext()).y - this.Kkv.getBottom()) });
        i = au.az(getContext()).y;
        localObject = new int[2];
        this.Kkv.getLocationOnScreen((int[])localObject);
        j = localObject[1];
        int k = this.Kkv.getHeight();
        int m = au.aD(getContext());
        this.Kkv.animate().translationY(-(paramInt - (i - (j + k)) + m)).setDuration(200L).start();
        paramInt = i - (this.Kkv.getHeight() + paramInt) - at.fromDPToPix(getContext(), 24);
        i = this.Kkk.getHeight() + this.Kkn.getHeight() + at.fromDPToPix(getContext(), 48);
        Log.d("MicroMsg.ChatFooter", "leftSpcaeDown:%s, editDown:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        this.Klr = (paramInt - at.fromDPToPix(getContext(), 52));
        if (this.Klr < this.Klk)
        {
          Log.i("MicroMsg.ChatFooter", "invalid maxHeightWhenKeyboard, value:%s", new Object[] { Integer.valueOf(this.Klr) });
          this.Klr = this.Klk;
        }
        this.Kls = this.Kkk.getHeight();
        localObject = new int[2];
        this.Kkn.getLocationOnScreen((int[])localObject);
        j = localObject[1] + this.Kkn.getHeight();
        if (j > paramInt)
        {
          j -= paramInt;
          if (i > paramInt)
          {
            k = this.Kkk.getLayoutParams().height;
            localObject = ValueAnimator.ofInt(new int[] { k, k - (i - paramInt) }).setDuration(200L);
            ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
              {
                AppMethodBeat.i(185804);
                int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
                ChatFooter.aA(ChatFooter.this).getLayoutParams().height = i;
                ChatFooter.aA(ChatFooter.this).requestLayout();
                AppMethodBeat.o(185804);
              }
            });
            ((ValueAnimator)localObject).start();
          }
          this.Kkk.animate().translationY(-j).setDuration(200L).start();
          this.Kkn.animate().translationY(-j).setDuration(200L).start();
          this.Kkq.animate().translationY(-j).setDuration(200L).start();
        }
      }
      AppMethodBeat.o(31670);
      return;
    }
    if ((!this.Kje) && (this.KiX))
    {
      if (this.Kji == paramBoolean) {
        break label913;
      }
      i = 1;
      this.Kji = paramBoolean;
      if (paramInt <= 0) {
        break label973;
      }
      if (this.oXi == paramInt) {
        break label1045;
      }
      this.oXi = paramInt;
      com.tencent.mm.compatible.util.i.C(getContext(), paramInt);
      aiC(paramInt);
    }
    label913:
    label1045:
    for (paramInt = 1;; paramInt = 0)
    {
      if (!this.xfU)
      {
        j(1, true, -1);
        this.KiZ = -1;
      }
      while ((paramInt == 0) && (i == 0))
      {
        this.xfU = true;
        if (this.KiD != null) {
          this.KiD.qY(this.xfU);
        }
        AppMethodBeat.o(31670);
        return;
        i = 0;
        break;
      }
      this.Kjd = this.oXi;
      i = this.Kjd;
      if (this.Kjp == null) {}
      for (paramInt = j;; paramInt = this.Kjp.dYg())
      {
        b(i, true, 1, paramInt);
        break;
      }
      label973:
      if (this.xfU)
      {
        if (this.KiZ == -1) {
          break label1035;
        }
        j(this.KiZ, true, -1);
        this.KiZ = -1;
      }
      for (;;)
      {
        if (this.KiY == 1)
        {
          Log.i("MicroMsg.ChatFooter", "keyboard not open");
          j(0, true, -1);
        }
        this.xfU = false;
        break;
        j(0, true, -1);
      }
    }
  }
  
  public final void z(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(31607);
    if (dYe())
    {
      Log.i("MicroMsg.ChatFooter", "setLastText() isBackFromGroupSolitatire");
      AppMethodBeat.o(31607);
      return;
    }
    if ((paramBoolean) && ((paramString == null) || (paramString.length() == 0) || (this.ECK == null)))
    {
      this.ECK.setText("");
      gqh();
      AppMethodBeat.o(31607);
      return;
    }
    this.KiH = true;
    this.ECK.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), paramString, this.ECK.getTextSize()));
    this.KiH = false;
    if ((paramInt < 0) || (paramInt > this.ECK.getText().length()))
    {
      this.ECK.setSelection(this.ECK.getText().length());
      AppMethodBeat.o(31607);
      return;
    }
    this.ECK.setSelection(paramInt);
    AppMethodBeat.o(31607);
  }
  
  public final void zY(boolean paramBoolean)
  {
    AppMethodBeat.i(31633);
    this.Kik.zY(paramBoolean);
    AppMethodBeat.o(31633);
  }
  
  public final void zZ(boolean paramBoolean)
  {
    AppMethodBeat.i(31634);
    this.Kik.zZ(paramBoolean);
    AppMethodBeat.o(31634);
  }
  
  public static final class a
  {
    public String Kml;
    String Kmm;
    int Kmn;
    HashMap<String, LinkedList<HashMap<String, String>>> Kmo;
    
    private a()
    {
      AppMethodBeat.i(31558);
      this.Kmo = new HashMap();
      AppMethodBeat.o(31558);
    }
  }
  
  public static abstract interface b
  {
    public abstract String getTalkerUserName();
    
    public abstract com.tencent.mm.ui.chatting.i.b grp();
    
    public abstract com.tencent.mm.ui.chatting.e.a grq();
  }
  
  public static abstract interface c
  {
    public abstract void a(Boolean paramBoolean1, Boolean paramBoolean2);
    
    public abstract void b(Boolean paramBoolean1, Boolean paramBoolean2);
  }
  
  public static abstract interface d
  {
    public abstract void q(Boolean paramBoolean);
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(185398);
      Kmp = new e("MODE_VOICE", 0);
      Kmq = new e("MODE_CANCEL", 1);
      Kmr = new e("MODE_TRANS", 2);
      Kms = new e[] { Kmp, Kmq, Kmr };
      AppMethodBeat.o(185398);
    }
    
    private e() {}
  }
  
  public static abstract interface f
  {
    public abstract void kE(int paramInt1, int paramInt2);
  }
  
  public static abstract interface g
  {
    public abstract boolean An(boolean paramBoolean);
  }
  
  public static enum h
  {
    static
    {
      AppMethodBeat.i(185821);
      Kmt = new h("SendVoice", 0);
      Kmu = new h("StopRecord", 1);
      Kmv = new h("Reset", 2);
      Kmw = new h("Cancel", 3);
      Kmx = new h("Pause", 4);
      Kmy = new h("Error", 5);
      Kmz = new h[] { Kmt, Kmu, Kmv, Kmw, Kmx, Kmy };
      AppMethodBeat.o(185821);
    }
    
    private h() {}
  }
  
  public final class i
    implements TextWatcher
  {
    TextWatcher KmA;
    private boolean KmB;
    private boolean KmC;
    
    public i(TextWatcher paramTextWatcher)
    {
      AppMethodBeat.i(31559);
      this.KmB = false;
      this.KmC = com.tencent.mm.compatible.util.d.oE(11);
      this.KmA = paramTextWatcher;
      AppMethodBeat.o(31559);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      boolean bool = true;
      AppMethodBeat.i(31560);
      if ((ChatFooter.j(ChatFooter.this)) && (this.KmB) && (paramEditable.length() > 0))
      {
        this.KmB = false;
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
      this.KmA.afterTextChanged(paramEditable);
      if (ChatFooter.x(ChatFooter.this) != null)
      {
        if (ChatFooter.d(ChatFooter.this).getLineCount() > 1)
        {
          ChatFooter.x(ChatFooter.this).setVisibility(0);
          ChatFooter.x(ChatFooter.this).setText(paramEditable.length() + "/140");
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
        if (ChatFooter.y(ChatFooter.this) != null) {
          ChatFooter.y(ChatFooter.this).setSendButtonEnable(bool);
        }
        Log.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        AppMethodBeat.o(31560);
        return;
        ChatFooter.x(ChatFooter.this).setVisibility(8);
        break;
        label306:
        bool = false;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(31561);
      this.KmA.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      Log.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
      AppMethodBeat.o(31561);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(31562);
      if ((ChatFooter.j(ChatFooter.this)) && (paramInt2 == 0) && (paramInt1 == paramCharSequence.length() - 1) && (paramInt3 == 1) && (paramCharSequence.charAt(paramCharSequence.length() - 1) == '\n'))
      {
        Log.i("MicroMsg.ChatFooter", "text changed, enter button");
        this.KmB = true;
        AppMethodBeat.o(31562);
        return;
      }
      this.KmA.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      ChatFooter.this.Kjs.ekf += 1L;
      ChatFooter.this.Kjs.abY();
      if (ChatFooter.this.Kjs.ekc == 0L) {
        ChatFooter.this.Kjs.abX();
      }
      if (ChatFooter.y(ChatFooter.this) != null) {
        ChatFooter.y(ChatFooter.this).setToSendText(ChatFooter.d(ChatFooter.this).getText().toString());
      }
      AppMethodBeat.o(31562);
    }
  }
  
  static enum j
  {
    static
    {
      AppMethodBeat.i(31565);
      KmD = new j("MODE_INVALID", 0);
      KmE = new j("MODE_BLUR", 1);
      KmF = new j("MODE_NORMAL", 2);
      KmG = new j[] { KmD, KmE, KmF };
      AppMethodBeat.o(31565);
    }
    
    private j() {}
  }
  
  static enum k
  {
    static
    {
      AppMethodBeat.i(31568);
      KmH = new k("MODE_INVALID", 0);
      KmI = new k("MODE_TRANS", 1);
      KmJ = new k("MODE_CANCEL", 2);
      KmK = new k[] { KmH, KmI, KmJ };
      AppMethodBeat.o(31568);
    }
    
    private k() {}
  }
  
  static enum l
  {
    static
    {
      AppMethodBeat.i(31571);
      KmL = new l("MODE_HINT_INVALID", 0);
      KmM = new l("MODE_HINT_1", 1);
      KmN = new l("MODE_HINT_2", 2);
      KmO = new l[] { KmL, KmM, KmN };
      AppMethodBeat.o(31571);
    }
    
    private l() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter
 * JD-Core Version:    0.7.0.1
 */