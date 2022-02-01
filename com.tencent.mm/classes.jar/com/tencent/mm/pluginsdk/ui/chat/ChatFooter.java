package com.tencent.mm.pluginsdk.ui.chat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
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
import android.view.View.OnLayoutChangeListener;
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
import androidx.lifecycle.q;
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
import com.tencent.mm.api.ae;
import com.tencent.mm.autogen.a.pu;
import com.tencent.mm.autogen.a.pu.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.o;
import com.tencent.mm.autogen.mmdata.rpt.ry;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.ui.d.a;
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
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.o.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.tools.ScrollControlListView;
import com.tencent.mm.pluginsdk.ui.tools.tips.TipsPopupWindow;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.ebg;
import com.tencent.mm.protocal.protobuf.flp;
import com.tencent.mm.sdk.event.IListener;
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
import com.tencent.mm.smiley.EmojiHelper;
import com.tencent.mm.smiley.QQSmileyManager;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bg;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.component.af.a;
import com.tencent.mm.ui.chatting.component.af.c;
import com.tencent.mm.ui.chatting.component.api.ao;
import com.tencent.mm.ui.chatting.component.api.bd.a;
import com.tencent.mm.ui.chatting.component.api.bd.b;
import com.tencent.mm.ui.chatting.component.api.bd.c;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.component.bq.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText.d;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.cedit.api.MMFlexEditText;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.util.b.a;
import com.tencent.mm.view.MaxHeightScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.ah.f;

public class ChatFooter
  extends FrameLayout
  implements com.tencent.mm.plugin.websearch.b.a.a, h.a, com.tencent.mm.ui.tools.h
{
  private static com.tencent.mm.plugin.websearch.b.a.c YfL;
  private static int YgC;
  public static final String YiH;
  private static final int[] Yiw;
  private static final int[] Yix;
  private static int count;
  private final long ANIMATION_DURATION;
  public View AhK;
  private ImageView AhL;
  public View AhM;
  public View AhN;
  public MMFragment Fgt;
  public boolean HDO;
  private m.a IqP;
  public com.tencent.mm.ui.widget.cedit.api.c Rqt;
  public v SOn;
  private TextView SOo;
  private ImageView SOp;
  public View SOq;
  private int TTV;
  com.tencent.mm.plugin.transvoice.model.b TVW;
  private String TWb;
  private int TWc;
  private MTimerHandler TWd;
  private boolean TWe;
  private MMHandler TWg;
  private com.tencent.mm.modelvoiceaddr.b.b TWo;
  private List<String> TWp;
  private int TZL;
  private int Wqp;
  f XYk;
  public n Yab;
  public boolean Yae;
  private b YfA;
  private g YfB;
  private f YfC;
  public final a YfD;
  public boolean YfE;
  private boolean YfF;
  public boolean YfG;
  private boolean YfH;
  private boolean YfI;
  public String YfJ;
  private ImageView YfK;
  public ViewGroup YfM;
  private TextView YfN;
  private View YfO;
  private int YfP;
  private boolean YfQ;
  private boolean YfR;
  private boolean YfS;
  public boolean YfT;
  public boolean YfU;
  private boolean YfV;
  private int YfW;
  private ChattingScrollLayout YfX;
  private boolean YfY;
  private int YfZ;
  public String Yfa;
  public AppPanel Yfb;
  public TextView Yfc;
  private Button Yfd;
  public ImageButton Yfe;
  private View Yff;
  public ChatFooterBottom Yfg;
  private TextView Yfh;
  public ImageButton Yfi;
  public ImageView Yfj;
  public ImageButton Yfk;
  public MaxHeightScrollView Yfl;
  private com.tencent.mm.ui.widget.a.e Yfm;
  public LinearLayout Yfn;
  public RelativeLayout Yfo;
  private RelativeLayout Yfp;
  private TextView Yfq;
  private ImageView Yfr;
  private TextView Yfs;
  private ImageView Yft;
  private ImageView Yfu;
  private FrameLayout Yfv;
  private WeImageView Yfw;
  private i Yfx;
  public m Yfy;
  private com.tencent.mm.plugin.groupsolitaire.ui.d Yfz;
  private boolean YgA;
  private Runnable YgB;
  public ViewGroup YgD;
  private View YgE;
  private BlurView YgF;
  private View YgG;
  private View YgH;
  private ImageView YgI;
  private ImageView YgJ;
  private View YgK;
  private TextView YgL;
  private ImageView YgM;
  private View YgN;
  private View YgO;
  private WeImageView YgP;
  private TextView YgQ;
  private View YgR;
  private WeImageView YgS;
  private TextView YgT;
  private View YgU;
  private BlurView YgV;
  private com.tencent.mm.plugin.transvoice.ui.b YgW;
  private com.tencent.mm.plugin.transvoice.model.a YgX;
  private com.tencent.mm.modelvoiceaddr.h YgY;
  public v YgZ;
  private int Yga;
  private boolean Ygb;
  public boolean Ygc;
  private boolean Ygd;
  private int Yge;
  private boolean Ygf;
  private int Ygg;
  private int Ygh;
  private int Ygi;
  private int Ygj;
  private boolean Ygk;
  private String Ygl;
  private af.c Ygm;
  private af.a Ygn;
  private bq.d Ygo;
  private bd.b Ygp;
  private d.c Ygq;
  o Ygr;
  public c Ygs;
  public d Ygt;
  private boolean Ygu;
  public b Ygv;
  private Animation Ygw;
  private Animation Ygx;
  private boolean Ygy;
  private TipsPopupWindow Ygz;
  private WeImageView YhA;
  private WeImageView YhB;
  private View YhC;
  private View YhD;
  private ViewGroup YhE;
  private View YhF;
  private View YhG;
  private WeImageView YhH;
  private WeImageView YhI;
  private View YhJ;
  private View YhK;
  private WeImageView YhL;
  private ViewGroup YhM;
  private View YhN;
  private View YhO;
  private View YhP;
  private WeImageView YhQ;
  private View YhR;
  private int YhS;
  private int YhT;
  private boolean YhU;
  private ChatFooterPanel.a YhV;
  private AppPanel.b YhW;
  private b YhX;
  public i YhY;
  private int YhZ;
  private com.tencent.mm.plugin.transvoice.model.c Yha;
  private ChatFooter.l Yhb;
  private j Yhc;
  private k Yhd;
  private boolean Yhe;
  private boolean Yhf;
  public boolean Yhg;
  private float Yhh;
  private v Yhi;
  private View Yhj;
  private View Yhk;
  private ViewGroup Yhl;
  private EditText Yhm;
  private SoundWaveView Yhn;
  private ImageView Yho;
  private ViewGroup Yhp;
  private TextView Yhq;
  private WeImageView Yhr;
  public LanguageChoiceLayout Yhs;
  private TextView Yht;
  private ViewGroup Yhu;
  private TextView Yhv;
  private ViewGroup Yhw;
  private ViewGroup Yhx;
  private View Yhy;
  private View Yhz;
  private final int YiA;
  private final int YiB;
  private volatile boolean YiC;
  private MMHandler YiD;
  private boolean YiE;
  private int YiF;
  private boolean YiG;
  private int YiI;
  private View YiJ;
  private int YiK;
  private int YiL;
  private int YiM;
  private int YiN;
  private int YiO;
  private int YiP;
  private Runnable YiQ;
  private Runnable YiR;
  private int YiS;
  private int YiT;
  e YiU;
  e YiV;
  private Map<Integer, String> YiW;
  private boolean YiX;
  private boolean Yia;
  private int Yib;
  private TextWatcher Yic;
  ValueAnimator Yid;
  ValueAnimator Yie;
  ValueAnimator Yif;
  ValueAnimator Yig;
  ValueAnimator Yih;
  ValueAnimator.AnimatorUpdateListener Yii;
  private int[] Yij;
  private final int Yik;
  private final int Yil;
  private final int Yim;
  private final int Yin;
  private final int Yio;
  private final int Yip;
  private final float Yiq;
  private int Yir;
  private int Yis;
  private int Yit;
  private int Yiu;
  private int Yiv;
  private int Yiy;
  private boolean Yiz;
  private Activity activity;
  private boolean cqi;
  private View hDw;
  private String hQQ;
  private InputMethodManager inputMethodManager;
  private IListener lAx;
  private com.tencent.mm.ui.tools.i lKz;
  public final MMHandler mHandler;
  private String mSessionId;
  private int maxHeight;
  private boolean miH;
  public int mjd;
  public Button mkz;
  public ChatFooterPanel moD;
  private ViewGroup pzj;
  private int sNb;
  private String toUser;
  private boolean xxL;
  private final MMHandler xxY;
  
  static
  {
    AppMethodBeat.i(31717);
    count = 0;
    Yiw = new int[] { 0, 15, 30, 45, 60, 75, 90, 95, 100 };
    Yix = new int[] { R.k.amp1, R.k.amp2, R.k.amp3, R.k.amp4, R.k.amp5, R.k.amp6, R.k.amp7, R.k.amp8 };
    YiH = MMApplicationContext.getPackageName() + "chat_footer_sp";
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
    this.hDw = null;
    this.Rqt = null;
    this.mkz = null;
    this.Yfc = null;
    this.YfB = null;
    this.YfC = null;
    this.YfD = new a((byte)0);
    this.YfE = false;
    this.YfF = false;
    this.YfG = false;
    this.YfH = false;
    this.YfI = false;
    this.YfJ = null;
    this.xxL = false;
    this.YfR = false;
    this.YfS = false;
    this.YfT = false;
    this.Yae = false;
    this.YfU = false;
    this.YfV = true;
    this.cqi = false;
    this.mjd = 0;
    this.YfW = -1;
    this.Yga = 0;
    this.HDO = false;
    this.Ygb = false;
    this.Ygc = true;
    this.Ygd = false;
    this.Yge = 0;
    this.Ygf = false;
    this.Ygk = false;
    this.Ygl = com.tencent.mm.plugin.fts.a.d.We(73);
    this.mSessionId = com.tencent.mm.plugin.fts.a.d.We(73);
    this.Ygm = null;
    this.Ygn = new af.a()
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
    this.Ygo = null;
    this.Ygp = new bd.b()
    {
      public final void aal(String paramAnonymousString)
      {
        AppMethodBeat.i(245401);
        ChatFooter.b(ChatFooter.this).setText(paramAnonymousString);
        ChatFooter.b(ChatFooter.this).setSelection(paramAnonymousString.length());
        AppMethodBeat.o(245401);
      }
    };
    this.Ygq = new d.c()
    {
      public final int fJG()
      {
        AppMethodBeat.i(245383);
        if (ChatFooter.c(ChatFooter.this) != null)
        {
          int i = ChatFooter.c(ChatFooter.this).fJG();
          AppMethodBeat.o(245383);
          return i;
        }
        AppMethodBeat.o(245383);
        return 0;
      }
      
      public final boolean fJH()
      {
        AppMethodBeat.i(245388);
        if (ChatFooter.d(ChatFooter.this) == 0)
        {
          AppMethodBeat.o(245388);
          return true;
        }
        AppMethodBeat.o(245388);
        return false;
      }
    };
    this.Ygr = new o();
    this.IqP = new m.a()
    {
      public final void clear()
      {
        AppMethodBeat.i(245362);
        ChatFooter.this.fJI();
        AppMethodBeat.o(245362);
      }
    };
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(245337);
        switch (paramAnonymousMessage.what)
        {
        }
        do
        {
          AppMethodBeat.o(245337);
          return;
        } while ((ChatFooter.b(ChatFooter.this) == null) || (paramAnonymousMessage.obj == null));
        boolean bool = ((Boolean)paramAnonymousMessage.obj).booleanValue();
        if (bool) {
          ChatFooter.b(ChatFooter.this).setAlpha(1.0F);
        }
        for (;;)
        {
          ChatFooter.a(ChatFooter.this, bool);
          break;
          ChatFooter.b(ChatFooter.this).setAlpha(0.5F);
        }
      }
    };
    this.Ygu = false;
    this.miH = false;
    this.Ygy = false;
    this.YgA = false;
    this.YgB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185777);
        Log.d("MicroMsg.ChatFooter", "onDataChangedListener run() called");
        ChatFooter.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185341);
            Log.d("MicroMsg.ChatFooter", "onDataChangedListener run() post called");
            if (ChatFooter.C(ChatFooter.this))
            {
              ChatFooter.f(ChatFooter.this, false);
              boolean bool = ChatFooter.e(ChatFooter.b(ChatFooter.this).getText());
              ChatFooter.b(ChatFooter.this, bool);
              ChatFooter.b(ChatFooter.this).getSizeAnimController().resume();
              if ((ChatFooter.p(ChatFooter.this) != null) && (ChatFooter.p(ChatFooter.this).iNh() != null)) {
                ((com.tencent.mm.ui.chatting.component.api.bd)ChatFooter.p(ChatFooter.this).iNh().cm(com.tencent.mm.ui.chatting.component.api.bd.class)).getSizeAnimController().resume();
              }
            }
            AppMethodBeat.o(185341);
          }
        });
        ChatFooter.b(ChatFooter.this).getSizeAnimController().cancel();
        if ((ChatFooter.p(ChatFooter.this) != null) && (ChatFooter.p(ChatFooter.this).iNh() != null)) {
          ((com.tencent.mm.ui.chatting.component.api.bd)ChatFooter.p(ChatFooter.this).iNh().cm(com.tencent.mm.ui.chatting.component.api.bd.class)).getSizeAnimController().cancel();
        }
        AppMethodBeat.o(185777);
      }
    };
    paramAttributeSet = com.tencent.mm.plugin.transvoice.model.c.TUa;
    this.Yha = com.tencent.mm.plugin.transvoice.model.c.hPD();
    this.Yhb = ChatFooter.l.YjN;
    this.Yhc = j.YjF;
    this.Yhd = k.YjJ;
    this.Yhe = false;
    this.Yhf = false;
    this.Yhg = false;
    this.Yhh = 0.5F;
    this.YhU = true;
    this.YhV = new ChatFooterPanel.a()
    {
      public final void aWL()
      {
        AppMethodBeat.i(245361);
        ChatFooter.aB(ChatFooter.this);
        ChatFooter.aC(ChatFooter.this).setVisibility(0);
        ChatFooter.aD(ChatFooter.this).setVisibility(0);
        ChatFooter.J(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.c(ChatFooter.this, R.g.fnr);
        if (ChatFooter.j(ChatFooter.this) != null) {
          ChatFooter.j(ChatFooter.this).performClick();
        }
        AppMethodBeat.o(245361);
      }
      
      public final void aWM()
      {
        AppMethodBeat.i(245371);
        ChatFooter.aB(ChatFooter.this);
        ChatFooter.aE(ChatFooter.this);
        ChatFooter.J(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.c(ChatFooter.this, R.g.fnr);
        InputConnection localInputConnection = ChatFooter.b(ChatFooter.this).getInputConnection();
        if (localInputConnection != null)
        {
          localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
          localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
        }
        ChatFooter.this.Ygr.ill -= 1L;
        AppMethodBeat.o(245371);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(245374);
        ChatFooter.aB(ChatFooter.this);
        ChatFooter.aE(ChatFooter.this);
        ChatFooter.J(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.c(ChatFooter.this, R.g.fnr);
        try
        {
          ChatFooter.b(ChatFooter.this).bDt(paramAnonymousString);
          ChatFooter.this.Ygr.ill += 1L;
          AppMethodBeat.o(245374);
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
      
      public final void fp(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(245366);
        Log.i("MicroMsg.ChatFooter", "onToSendTextEnable: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ChatFooter.d(ChatFooter.this) == 2)
        {
          ChatFooter.aB(ChatFooter.this);
          ChatFooter.aE(ChatFooter.this);
          ChatFooter.J(ChatFooter.this).setVisibility(8);
          ChatFooter.c(ChatFooter.this, R.g.fnr);
          if (ChatFooter.b(ChatFooter.this) != null) {
            ChatFooter.this.setToSendTextColor(paramAnonymousBoolean);
          }
        }
        AppMethodBeat.o(245366);
      }
    };
    this.YhW = new AppPanel.b()
    {
      public final void iLR()
      {
        AppMethodBeat.i(245363);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ChatFooter.e(ChatFooter.this), "android.permission.RECORD_AUDIO", 80, "");
        Log.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), ChatFooter.e(ChatFooter.this) });
        if (!bool)
        {
          AppMethodBeat.o(245363);
          return;
        }
        int i = bh.aZW().bFQ();
        if ((i == 4) || (i == 6))
        {
          ChatFooter.aF(ChatFooter.this);
          AppMethodBeat.o(245363);
          return;
        }
        if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
          ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.k.s(ChatFooter.this.getContext(), R.l.voip_net_unavailable, R.l.app_tip));
        }
        AppMethodBeat.o(245363);
      }
    };
    this.YhX = new b()
    {
      public final String getTalkerUserName()
      {
        AppMethodBeat.i(245357);
        if (ChatFooter.p(ChatFooter.this) == null)
        {
          str = ChatFooter.u(ChatFooter.this);
          AppMethodBeat.o(245357);
          return str;
        }
        String str = ChatFooter.p(ChatFooter.this).getTalkerUserName();
        AppMethodBeat.o(245357);
        return str;
      }
      
      public final com.tencent.mm.ui.chatting.g.b iNg()
      {
        return null;
      }
      
      public final com.tencent.mm.ui.chatting.d.a iNh()
      {
        AppMethodBeat.i(245368);
        if (ChatFooter.p(ChatFooter.this) == null)
        {
          AppMethodBeat.o(245368);
          return null;
        }
        com.tencent.mm.ui.chatting.d.a locala = ChatFooter.p(ChatFooter.this).iNh();
        AppMethodBeat.o(245368);
        return locala;
      }
    };
    this.xxY = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(179769);
        super.handleMessage(paramAnonymousMessage);
        Log.d("MicroMsg.ChatFooter", "pennqin, dismiss window by too short.");
        ChatFooter.J(ChatFooter.this).setBackgroundResource(R.g.input_bg);
        ChatFooter.J(ChatFooter.this).setEnabled(true);
        if (ChatFooter.this.Yhg)
        {
          ChatFooter.T(ChatFooter.this);
          aa.y(ChatFooter.this.getContext(), ChatFooter.this.getContext().getResources().getString(R.l.chatfooter_too_short_new), R.k.voice_to_short);
          AppMethodBeat.o(179769);
          return;
        }
        if (ChatFooter.U(ChatFooter.this) != null) {
          ChatFooter.U(ChatFooter.this).dismiss();
        }
        AppMethodBeat.o(179769);
      }
    };
    this.YhZ = 0;
    this.Yia = false;
    this.Yib = 1;
    this.Yic = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(245376);
        int i;
        int j;
        int m;
        int k;
        if (paramAnonymousEditable != null)
        {
          i = ChatFooter.aI(ChatFooter.this).getWidth();
          j = ChatFooter.aJ(ChatFooter.this).getLineCount();
          m = j - ChatFooter.aK(ChatFooter.this);
          if ((m != 0) && (ChatFooter.this.YiU == ChatFooter.e.Yju) && (i == ChatFooter.aL(ChatFooter.this)))
          {
            i = com.tencent.mm.ui.bd.fromDPToPix(ChatFooter.this.getContext(), 5);
            k = ChatFooter.aJ(ChatFooter.this).getLineHeight() * m;
            if (m <= 0) {
              break label251;
            }
            m = ChatFooter.aI(ChatFooter.this).getHeight();
            if (!ChatFooter.this.HDO) {
              break label257;
            }
            ChatFooter.d(ChatFooter.this, Math.min(Math.max(ChatFooter.aM(ChatFooter.this), i + (m + k)), ChatFooter.aN(ChatFooter.this)));
          }
        }
        for (;;)
        {
          Log.d("MicroMsg.ChatFooter", "afterTextChanged transHeight:%s, nowLineCount:%s, lastLineCount:%s", new Object[] { Integer.valueOf(ChatFooter.aP(ChatFooter.this)), Integer.valueOf(j), Integer.valueOf(ChatFooter.aK(ChatFooter.this)) });
          ChatFooter.aQ(ChatFooter.this);
          ChatFooter.e(ChatFooter.this, j);
          if (1 == ChatFooter.L(ChatFooter.this).TUs) {
            ChatFooter.L(ChatFooter.this).TUr = 1;
          }
          AppMethodBeat.o(245376);
          return;
          label251:
          i = -i;
          break;
          label257:
          ChatFooter.d(ChatFooter.this, Math.min(Math.max(ChatFooter.aM(ChatFooter.this), i + (m + k)), ChatFooter.aO(ChatFooter.this)));
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.Yid = ValueAnimator.ofInt(new int[] { 250, 960 }).setDuration(200L);
    this.Yie = ValueAnimator.ofInt(new int[] { 40, 800 }).setDuration(200L);
    this.Yif = ValueAnimator.ofInt(new int[] { 72, 0 }).setDuration(200L);
    this.Yig = ValueAnimator.ofInt(new int[] { 22, 0 }).setDuration(200L);
    this.Yih = ValueAnimator.ofInt(new int[] { 8, 0 }).setDuration(200L);
    this.Yii = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(245332);
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)ChatFooter.bo(ChatFooter.this).getLayoutParams();
        FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)ChatFooter.bp(ChatFooter.this).getLayoutParams();
        if (ChatFooter.this.Yid == paramAnonymousValueAnimator)
        {
          localLayoutParams1.width = com.tencent.mm.ui.bd.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          localLayoutParams2.width = com.tencent.mm.ui.bd.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        }
        for (;;)
        {
          ChatFooter.bo(ChatFooter.this).setLayoutParams(localLayoutParams1);
          ChatFooter.bp(ChatFooter.this).setLayoutParams(localLayoutParams2);
          AppMethodBeat.o(245332);
          return;
          if (ChatFooter.this.Yie == paramAnonymousValueAnimator)
          {
            localLayoutParams1.height = com.tencent.mm.ui.bd.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.height = com.tencent.mm.ui.bd.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Yif == paramAnonymousValueAnimator)
          {
            localLayoutParams1.topMargin = com.tencent.mm.ui.bd.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.topMargin = com.tencent.mm.ui.bd.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Yig == paramAnonymousValueAnimator)
          {
            localLayoutParams1.rightMargin = com.tencent.mm.ui.bd.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.rightMargin = com.tencent.mm.ui.bd.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          else if (ChatFooter.this.Yih == paramAnonymousValueAnimator)
          {
            localLayoutParams1.bottomMargin = com.tencent.mm.ui.bd.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
            localLayoutParams2.bottomMargin = com.tencent.mm.ui.bd.fromDPToPix(ChatFooter.this.getContext(), ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        }
      }
    };
    this.Yij = new int[] { R.k.count_down_0, R.k.count_down_1, R.k.count_down_2, R.k.count_down_3, R.k.count_down_4, R.k.count_down_5, R.k.count_down_6, R.k.count_down_7, R.k.count_down_8, R.k.count_down_9 };
    this.ANIMATION_DURATION = 200L;
    this.Yik = 60;
    this.Yil = com.tencent.mm.ui.bd.fromDPToPix(getContext(), 114);
    this.Yim = (com.tencent.mm.ui.bf.bf(getContext()).x - com.tencent.mm.ui.bd.fromDPToPix(getContext(), 32));
    this.Yin = com.tencent.mm.ui.bd.fromDPToPix(getContext(), 92);
    this.Yio = Math.min(com.tencent.mm.ui.bd.fromDPToPix(getContext(), 320), com.tencent.mm.ui.bf.bf(getContext()).x - com.tencent.mm.ui.bd.fromDPToPix(getContext(), 32));
    this.Yip = com.tencent.mm.ui.bd.fromDPToPix(getContext(), 176);
    this.Yiq = (com.tencent.mm.ui.bd.fromDPToPix(getContext(), 160) / 50.0F);
    this.Yir = com.tencent.mm.ui.bd.fromDPToPix(getContext(), 114);
    this.maxHeight = 0;
    this.Yis = 0;
    this.Yit = 0;
    this.TZL = 0;
    this.Yiu = com.tencent.mm.ui.bd.fromDPToPix(getContext(), 176);
    this.Yiv = 60;
    this.Yiy = 0;
    this.Yiz = false;
    this.YiA = 4097;
    this.YiB = 4098;
    this.YiD = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(245311);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(245311);
          return;
          ChatFooter.k(ChatFooter.this, true);
          paramAnonymousMessage = ChatFooter.bB(ChatFooter.this).getLayoutParams();
          int i = ChatFooter.bB(ChatFooter.this).getBottom() - ChatFooter.bB(ChatFooter.this).getTop();
          if (ChatFooter.this.iMz())
          {
            if (ChatFooter.H(ChatFooter.this) != null) {
              ChatFooter.H(ChatFooter.this).setVisibility(8);
            }
            ChatFooter.this.setAppPanelVisible(8);
            ChatFooter.bB(ChatFooter.this).setVisibility(4);
          }
          if (i <= 3)
          {
            ChatFooter.k(ChatFooter.this, false);
            ChatFooter.bB(ChatFooter.this).setVisibility(4);
            ChatFooter.j(ChatFooter.this, ChatFooter.this.getKeyBordHeightPX());
            AppMethodBeat.o(245311);
            return;
          }
          paramAnonymousMessage.height = Math.max(i - 60, 1);
          Log.e("MicroMsg.ChatFooter", "mBottomPanelAnim:bottomPanel height:" + paramAnonymousMessage.height);
          ChatFooter.bB(ChatFooter.this).setLayoutParams(paramAnonymousMessage);
          ChatFooter.bC(ChatFooter.this);
        }
      }
    };
    this.YiE = false;
    this.YiF = 0;
    this.YiG = false;
    this.YiI = -1;
    this.YiJ = null;
    this.YiK = com.tencent.mm.ui.bd.bs(getContext(), R.f.ChattingFootSendMinWidth);
    this.YiL = com.tencent.mm.ui.bd.bs(getContext(), R.f.Edge_4A);
    this.YiM = com.tencent.mm.ui.bd.fromDPToPix(getContext(), 25);
    this.YiN = com.tencent.mm.ui.bd.fromDPToPix(getContext(), 55);
    this.YiO = 0;
    this.YiP = com.tencent.mm.ui.bd.fromDPToPix(getContext(), 50);
    this.YiQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245430);
        ChatFooter.this.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(245346);
            if (ChatFooter.k.YjL == ChatFooter.au(ChatFooter.this))
            {
              ChatFooter.an(ChatFooter.this).setText(ChatFooter.this.getResources().getText(R.l.gXI));
              ChatFooter.ax(ChatFooter.this);
            }
            for (;;)
            {
              ChatFooter.bG(ChatFooter.this);
              AppMethodBeat.o(245346);
              return;
              ChatFooter.an(ChatFooter.this).setText(ChatFooter.this.getResources().getText(R.l.gXK));
              ChatFooter.av(ChatFooter.this);
            }
          }
        }, 100L);
        AppMethodBeat.o(245430);
      }
    };
    this.YiR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245434);
        ChatFooter.V(ChatFooter.this).dismiss();
        AppMethodBeat.o(245434);
      }
    };
    this.YiS = com.tencent.mm.ui.bd.fromDPToPix(getContext(), 16);
    this.YiT = com.tencent.mm.ui.bd.fromDPToPix(getContext(), 25);
    this.YiU = e.Yjs;
    this.YiV = this.YiU;
    this.YiW = new HashMap();
    this.YiX = false;
    this.TWo = new com.tencent.mm.modelvoiceaddr.b.b();
    this.TWp = new ArrayList();
    this.TWb = "";
    this.TWc = 0;
    this.TWe = false;
    this.TTV = g.pfF;
    this.lAx = new IListener(com.tencent.mm.app.f.hfK) {};
    long l = System.currentTimeMillis();
    this.inputMethodManager = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.hDw = inflate(paramContext, R.i.geW, this);
    this.Rqt = ((com.tencent.mm.ui.widget.cedit.api.c)findViewById(R.h.fxx));
    this.Rqt.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.az(PluginWebSearch.class)).isUseSysEditText());
    this.lKz = new com.tencent.mm.ui.tools.i((Activity)paramContext);
    this.lKz.afIL = this;
    if (aw.jkQ()) {
      this.Rqt.setImeOptions(268435456);
    }
    paramAttributeSet = com.tencent.mm.ui.widget.cedit.api.d.a(this.Rqt);
    paramInt = 8192;
    if (com.tencent.mm.kernel.h.baz()) {
      paramInt = Util.getInt(com.tencent.mm.k.i.aRC().getValue("InputLimitSessionTextMsg"), 8192);
    }
    paramAttributeSet.aEg(paramInt * 2).a(null);
    this.Rqt.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
    paramAttributeSet = new a.e()
    {
      public final void I(List<a.c> paramAnonymousList, int paramAnonymousInt)
      {
        AppMethodBeat.i(245391);
        long l = cn.getSyncServerTimeSecond();
        if ((paramAnonymousInt != 8) && (paramAnonymousInt != 1))
        {
          if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineC2CTag())
          {
            localChatFooter = ChatFooter.this;
            if ((localChatFooter.Ygv == null) || (localChatFooter.Ygv.iNh() == null) || ((!((com.tencent.mm.ui.chatting.component.api.i)localChatFooter.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.i.class)).jrA()) && (!((com.tencent.mm.ui.chatting.component.api.r)localChatFooter.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.r.class)).jrT()) && (!((com.tencent.mm.ui.chatting.component.api.k)localChatFooter.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.k.class)).jrF()))) {
              break label522;
            }
            paramAnonymousInt = 0;
            if ((paramAnonymousInt != 0) && (!com.tencent.mm.plugin.websearch.api.aj.aBu()))
            {
              paramAnonymousList.add(new a.c(paramContext.getString(R.l.tag_search_word), 2));
              ChatFooter.b(ChatFooter.this).jEG();
              if (!au.bwE(ChatFooter.u(ChatFooter.this))) {
                break label527;
              }
              paramAnonymousInt = 2;
              label207:
              com.tencent.mm.plugin.websearch.b.b.a(paramAnonymousInt, ChatFooter.u(ChatFooter.this), ChatFooter.v(ChatFooter.this), 1, "", ChatFooter.w(ChatFooter.this), 1, l);
            }
          }
          ChatFooter localChatFooter = ChatFooter.this;
          if ((localChatFooter.Ygv != null) && (localChatFooter.Ygv.iNh() != null) && ((((com.tencent.mm.ui.chatting.component.api.i)localChatFooter.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.i.class)).jrA()) || (((com.tencent.mm.ui.chatting.component.api.r)localChatFooter.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.r.class)).jrT()) || (((com.tencent.mm.ui.chatting.component.api.k)localChatFooter.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.k.class)).jrF())))
          {
            paramAnonymousInt = 0;
            label344:
            if ((paramAnonymousInt != 0) && (!com.tencent.mm.plugin.websearch.api.aj.aBu()))
            {
              paramAnonymousList.add(new a.c(paramContext.getString(R.l.find_friends_search), 3));
              ChatFooter.b(ChatFooter.this).jEG();
              if (!au.bwE(ChatFooter.u(ChatFooter.this))) {
                break label537;
              }
            }
          }
          label522:
          label527:
          label537:
          for (paramAnonymousInt = 2;; paramAnonymousInt = 1)
          {
            com.tencent.mm.plugin.websearch.b.b.a(paramAnonymousInt, ChatFooter.u(ChatFooter.this), ChatFooter.v(ChatFooter.this), 1, "", ChatFooter.w(ChatFooter.this), 2, l);
            if ((!ChatFooter.x(ChatFooter.this)) || (ChatFooter.y(ChatFooter.this) == null) || (ChatFooter.y(ChatFooter.this).jsr())) {
              break label542;
            }
            paramAnonymousList.add(new a.c(paramContext.getString(R.l.menu_translate_while_write_enable), 4));
            paramAnonymousList = com.tencent.mm.plugin.translate.b.c.TSK;
            com.tencent.mm.plugin.translate.b.c.beI(ChatFooter.p(ChatFooter.this).getTalkerUserName());
            AppMethodBeat.o(245391);
            return;
            paramAnonymousInt = 1;
            break;
            paramAnonymousInt = 1;
            break label207;
            paramAnonymousInt = 1;
            break label344;
          }
          label542:
          if ((ChatFooter.x(ChatFooter.this)) && (ChatFooter.y(ChatFooter.this) != null) && (ChatFooter.y(ChatFooter.this).jsr()))
          {
            paramAnonymousList.add(new a.c(paramContext.getString(R.l.menu_translate_while_write_disable), 5));
            paramAnonymousList = com.tencent.mm.plugin.translate.b.c.TSK;
            com.tencent.mm.plugin.translate.b.c.beK(ChatFooter.p(ChatFooter.this).getTalkerUserName());
          }
        }
        AppMethodBeat.o(245391);
      }
      
      public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
      {
        AppMethodBeat.i(245397);
        long l2 = cn.getSyncServerTimeSecond();
        int i;
        if (paramAnonymousc.id == 2)
        {
          ChatFooter.b(ChatFooter.this).getText().insert(ChatFooter.b(ChatFooter.this).getSelectionStart(), paramContext.getString(R.l.tag_search_word));
          ChatFooter.b(ChatFooter.this).jEG();
          if (au.bwE(ChatFooter.u(ChatFooter.this))) {}
          for (i = 2;; i = 1)
          {
            com.tencent.mm.plugin.websearch.b.b.a(i, ChatFooter.u(ChatFooter.this), ChatFooter.v(ChatFooter.this), 2, "", ChatFooter.w(ChatFooter.this), 1, l2);
            AppMethodBeat.o(245397);
            return;
          }
        }
        if (paramAnonymousc.id == 3)
        {
          ChatFooter.b(ChatFooter.this).clearFocus();
          ChatFooter.z(ChatFooter.this);
          paramAnonymousc = ChatFooter.b(ChatFooter.this).getText().toString();
          paramAnonymousView = com.tencent.mm.plugin.websearch.b.c.WqP;
          Object localObject1 = ChatFooter.this.getContext();
          paramAnonymousString = ChatFooter.u(ChatFooter.this);
          ChatFooter localChatFooter = ChatFooter.this;
          String str = ChatFooter.w(ChatFooter.this);
          i = ChatFooter.b(ChatFooter.this).getSelectionStart();
          kotlin.g.b.s.u(localObject1, "context");
          kotlin.g.b.s.u(paramAnonymousString, "talker");
          kotlin.g.b.s.u(localChatFooter, "listener");
          kotlin.g.b.s.u(paramAnonymousc, "query");
          kotlin.g.b.s.u(str, "sessionId");
          ah.f localf = new ah.f();
          localf.aqH = new flp();
          HashMap localHashMap = new HashMap();
          ((Map)localHashMap).put("scene", "72");
          ((Map)localHashMap).put("sessionId", str);
          ((Map)localHashMap).put("subSessionId", str);
          ((Map)localHashMap).put("isHomePage", "1");
          if (!TextUtils.isEmpty((CharSequence)paramAnonymousc))
          {
            paramAnonymousView = (Map)localHashMap;
            localObject2 = com.tencent.mm.compatible.util.r.as(paramAnonymousc, "utf8");
            kotlin.g.b.s.s(localObject2, "encode(query, \"utf8\")");
            paramAnonymousView.put("query", localObject2);
            ((Map)localHashMap).put("cursorIndex", String.valueOf(i));
          }
          Object localObject2 = (Map)localHashMap;
          long l1;
          if (Util.isOverseasUser((Context)localObject1))
          {
            paramAnonymousView = "1";
            ((Map)localObject2).put("isOverseaApp", paramAnonymousView);
            com.tencent.mm.plugin.websearch.b.c.br((Map)localHashMap);
            ((flp)localf.aqH).url = com.tencent.mm.plugin.websearch.b.c.bs((Map)localHashMap);
            ((flp)localf.aqH).talker = paramAnonymousString;
            ((flp)localf.aqH).sessionId = str;
            ((flp)localf.aqH).scene = 72;
            ((flp)localf.aqH).hAB = "";
            ((flp)localf.aqH).mpa = "";
            ((flp)localf.aqH).ACR = 2;
            paramAnonymousView = new com.tencent.mm.plugin.websearch.b.c.a(localChatFooter, localf, paramAnonymousString, str);
            paramAnonymousView = new com.tencent.mm.plugin.websearch.b.a.c((Context)localObject1, (flp)localf.aqH, (com.tencent.mm.plugin.websearch.b.a.a)paramAnonymousView);
            paramAnonymousView.show();
            localObject1 = paramAnonymousView.getWindow();
            if (localObject1 != null) {
              ((Window)localObject1).setLayout(-1, -1);
            }
            localObject1 = new ry();
            ((ry)localObject1).ioV = 1L;
            ((ry)localObject1).jwW = 0L;
            ((ry)localObject1).jwX = 2L;
            ((ry)localObject1).iow = cn.getSyncServerTimeSecond();
            if (!au.bwE(paramAnonymousString)) {
              break label817;
            }
            l1 = 2L;
            label660:
            ((ry)localObject1).izg = l1;
            ((ry)localObject1).yJ(paramAnonymousString);
            ((ry)localObject1).yK(str);
            ((ry)localObject1).yL(paramAnonymousc);
            ((ry)localObject1).bMH();
            as.a((com.tencent.mm.plugin.report.a)localObject1);
            Log.i(com.tencent.mm.plugin.websearch.b.c.TAG, kotlin.g.b.s.X("startTagSearchDialog url:", ((flp)localf.aqH).url));
            ChatFooter.d(paramAnonymousView);
            ChatFooter.b(ChatFooter.this).jEG();
            if (!au.bwE(ChatFooter.u(ChatFooter.this))) {
              break label823;
            }
          }
          label817:
          label823:
          for (i = 2;; i = 1)
          {
            com.tencent.mm.plugin.websearch.b.b.a(i, ChatFooter.u(ChatFooter.this), ChatFooter.v(ChatFooter.this), 2, paramAnonymousc, ChatFooter.w(ChatFooter.this), 2, l2);
            ChatFooter.d(ChatFooter.this, com.tencent.mm.plugin.fts.a.d.We(73));
            AppMethodBeat.o(245397);
            return;
            paramAnonymousView = "0";
            break;
            l1 = 1L;
            break label660;
          }
        }
        if (paramAnonymousc.id == 4)
        {
          if (ChatFooter.y(ChatFooter.this) != null)
          {
            ChatFooter.y(ChatFooter.this).LY(true);
            if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adhW, false))
            {
              paramAnonymousView = com.tencent.mm.util.i.agtt;
              if (com.tencent.mm.util.i.a(b.a.agqH, 0) != 1) {}
            }
            else
            {
              ChatFooter.A(ChatFooter.this);
              com.tencent.mm.kernel.h.baE().ban().set(at.a.adhW, Boolean.TRUE);
            }
            paramAnonymousView = com.tencent.mm.plugin.translate.b.c.TSK;
            com.tencent.mm.plugin.translate.b.c.beH(ChatFooter.p(ChatFooter.this).getTalkerUserName());
          }
          ChatFooter.b(ChatFooter.this).cRR();
          AppMethodBeat.o(245397);
          return;
        }
        if (paramAnonymousc.id == 5)
        {
          if (ChatFooter.y(ChatFooter.this) != null)
          {
            ChatFooter.y(ChatFooter.this).LY(false);
            paramAnonymousView = com.tencent.mm.plugin.translate.b.c.TSK;
            com.tencent.mm.plugin.translate.b.c.beJ(ChatFooter.p(ChatFooter.this).getTalkerUserName());
          }
          ChatFooter.b(ChatFooter.this).cRR();
        }
        AppMethodBeat.o(245397);
      }
    };
    this.Rqt.a(((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(paramContext), paramAttributeSet);
    this.Rqt.setKeyCodeEnterListener(new MMEditText.d()
    {
      private long WAt = 0L;
      
      public final boolean awK(int paramAnonymousInt)
      {
        AppMethodBeat.i(245387);
        if ((paramAnonymousInt == 66) && (cn.bDw() - this.WAt > 1000L) && (aw.jlc()) && (aw.jkS()))
        {
          Log.i("MicroMsg.ChatFooter", "KeyCode Enter");
          this.WAt = cn.bDw();
          ChatFooter.j(ChatFooter.this).performClick();
          AppMethodBeat.o(245387);
          return true;
        }
        AppMethodBeat.o(245387);
        return false;
      }
    });
    this.Rqt.addTextChangedListener(new TextWatcher()
    {
      private List<ForegroundColorSpan> RqM;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(245392);
        paramAnonymousEditable = ChatFooter.b(ChatFooter.this).getText();
        Object localObject = this.RqM.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramAnonymousEditable.removeSpan((ForegroundColorSpan)((Iterator)localObject).next());
        }
        this.RqM.clear();
        localObject = ChatFooter.b(ChatFooter.this).getText().toString();
        if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineC2CTag())
        {
          Matcher localMatcher = o.a.YoB.matcher((CharSequence)localObject);
          while (localMatcher.find())
          {
            int i = localMatcher.start();
            int j = localMatcher.end();
            ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(ChatFooter.this.getResources().getColor(R.e.Link_100));
            this.RqM.add(localForegroundColorSpan);
            paramAnonymousEditable.setSpan(localForegroundColorSpan, i, j, 33);
          }
        }
        if ((ChatFooter.p(ChatFooter.this) != null) && (ChatFooter.p(ChatFooter.this).iNh() != null)) {
          ((com.tencent.mm.ui.chatting.component.api.bd)ChatFooter.p(ChatFooter.this).iNh().cm(com.tencent.mm.ui.chatting.component.api.bd.class)).bAW((String)localObject);
        }
        ChatFooter.B(ChatFooter.this);
        AppMethodBeat.o(245392);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (YfL != null)
    {
      YfL.dismiss();
      YfL = null;
    }
    this.Rqt.getSizeAnimController().Lw(true);
    this.Rqt.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(245390);
        if (ChatFooter.p(ChatFooter.this) != null)
        {
          paramAnonymousInt1 = ChatFooter.b(ChatFooter.this).getMeasuredHeight() - ChatFooter.b(ChatFooter.this).getMinimumHeight();
          if (paramAnonymousInt1 > 0)
          {
            paramAnonymousInt1 = (int)(paramAnonymousInt1 * 1.3D);
            paramAnonymousView = ChatFooter.p(ChatFooter.this).iNh();
            if ((paramAnonymousView.aezP.getListView() instanceof ScrollControlListView)) {
              ((ScrollControlListView)paramAnonymousView.aezP.getListView()).setExtraScrollDistance(paramAnonymousInt1);
            }
          }
        }
        AppMethodBeat.o(245390);
      }
    });
    paramAttributeSet = new ChatFooter.87(this);
    this.Rqt.setOnFocusChangeListener(paramAttributeSet);
    if (Build.VERSION.SDK_INT == 28) {
      this.Rqt.setBreakStrategy(1);
    }
    this.Yfn = ((LinearLayout)this.hDw.findViewById(R.h.fYZ));
    this.Yfl = ((MaxHeightScrollView)this.hDw.findViewById(R.h.fZb));
    this.Rqt.setMaxHeight(this.Yfl.getMaxHeight() - this.Yfl.getPaddingBottom() - this.Yfl.getPaddingTop());
    this.Yfg = ((ChatFooterBottom)findViewById(R.h.fxr));
    this.pzj = ((ViewGroup)findViewById(R.h.fvE));
    this.Yff = findViewById(R.h.fxP);
    this.Yfi = ((ImageButton)this.hDw.findViewById(R.h.fxj));
    this.Yfj = ((ImageView)this.hDw.findViewById(R.h.fxk));
    this.mkz = ((Button)this.hDw.findViewById(R.h.fzZ));
    this.Yfo = ((RelativeLayout)this.hDw.findViewById(R.h.fOL));
    this.Yfp = ((RelativeLayout)this.hDw.findViewById(R.h.fKt));
    this.Yfq = ((TextView)this.hDw.findViewById(R.h.fKu));
    this.Yfr = ((ImageView)this.hDw.findViewById(R.h.fKs));
    this.Yfs = ((TextView)this.hDw.findViewById(R.h.fOJ));
    this.Yfv = ((FrameLayout)this.hDw.findViewById(R.h.fOH));
    this.Yft = ((ImageView)this.hDw.findViewById(R.h.fOI));
    this.Yfu = ((ImageView)this.hDw.findViewById(R.h.fOM));
    this.Yfw = ((WeImageView)this.hDw.findViewById(R.h.fOK));
    this.YfK = ((ImageView)this.hDw.findViewById(R.h.fTq));
    this.mkz.setTextSize(0, com.tencent.mm.cd.a.bs(paramContext, R.f.SmallBtnTextSize) * com.tencent.mm.cd.a.jO(paramContext));
    this.Yfd = ((Button)this.hDw.findViewById(R.h.gda));
    this.Yfe = ((ImageButton)findViewById(R.h.fzp));
    yk(false);
    iMI();
    this.Yfx = new i(getContext(), getRootView(), this, new i.a()
    {
      public final void brj(String paramAnonymousString)
      {
        AppMethodBeat.i(185752);
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(paramAnonymousString);
        if (ChatFooter.f(ChatFooter.this) != null) {
          localIntent.putExtra("GalleryUI_FromUser", ChatFooter.f(ChatFooter.this));
        }
        if (ChatFooter.g(ChatFooter.this) != null) {
          localIntent.putExtra("GalleryUI_ToUser", ChatFooter.g(ChatFooter.this));
        }
        localIntent.putExtra("query_source_type", 3);
        localIntent.putExtra("preview_image", true);
        localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
        localIntent.putExtra("max_select_count", 1);
        localIntent.addFlags(67108864);
        if (ChatFooter.h(ChatFooter.this) != null)
        {
          com.tencent.mm.br.c.a(ChatFooter.h(ChatFooter.this), "gallery", ".ui.GalleryEntryUI", localIntent, 217);
          AppMethodBeat.o(185752);
          return;
        }
        com.tencent.mm.br.c.b(paramContext, "gallery", ".ui.GalleryEntryUI", localIntent, 217);
        AppMethodBeat.o(185752);
      }
    });
    this.Yfx.Ykn = this;
    paramAttributeSet = getContext();
    getRootView();
    this.Rqt.jEG();
    this.Yfy = new m(paramAttributeSet);
    this.Yfy.IqP = this.IqP;
    Log.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[] { Integer.valueOf(this.Rqt.getImeOptions()) });
    this.Rqt.a(new com.tencent.mm.ui.widget.cedit.api.c.a()
    {
      public final boolean rR(int paramAnonymousInt)
      {
        AppMethodBeat.i(245428);
        if ((paramAnonymousInt == 4) || ((paramAnonymousInt == 0) && (ChatFooter.i(ChatFooter.this))))
        {
          ChatFooter.j(ChatFooter.this).performClick();
          AppMethodBeat.o(245428);
          return true;
        }
        AppMethodBeat.o(245428);
        return false;
      }
    });
    paramAttributeSet = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(185754);
        ChatFooter.this.setToSendTextColor(true);
        if (ChatFooter.k(ChatFooter.this) != null) {
          ChatFooter.k(ChatFooter.this).ah(paramAnonymousMotionEvent);
        }
        ChatFooter.l(ChatFooter.this);
        AppMethodBeat.o(185754);
        return false;
      }
    };
    this.Rqt.setOnTouchListener(paramAttributeSet);
    paramAttributeSet = new ChatFooter.5(this);
    this.Rqt.setOnLongClickListener(paramAttributeSet);
    this.Rqt.setCustomSelectionActionModeCallback(new ActionMode.Callback()
    {
      public final boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
      
      public final boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        AppMethodBeat.i(185756);
        paramAnonymousActionMode = ClipboardHelper.getText(paramContext);
        com.tencent.mm.plugin.report.service.h.OAn.p(1014L, 5L, 1L);
        com.tencent.mm.plugin.c.a.caJ();
        if (com.tencent.mm.plugin.c.a.O(paramAnonymousActionMode))
        {
          Log.i("MicroMsg.ChatFooter", "anti paste text %s", new Object[] { paramAnonymousActionMode });
          com.tencent.mm.plugin.report.service.h.OAn.p(1014L, 6L, 1L);
          if (paramAnonymousMenu.size() > 0)
          {
            paramAnonymousMenu.removeItem(16908322);
            if (com.tencent.mm.compatible.util.d.rb(23)) {
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
    this.mkz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        for (;;)
        {
          boolean bool;
          label449:
          try
          {
            AppMethodBeat.i(31499);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            paramAnonymousView = ChatFooter.b(ChatFooter.this).getText().toString();
            localObject = MMFlexEditText.afWC;
            paramAnonymousView = paramAnonymousView.replaceAll(String.valueOf(MMFlexEditText.jFn()), "");
            Log.i("MicroMsg.ChatFooter", "send msg onClick");
            if ((paramAnonymousView.trim().length() == 0) && (paramAnonymousView.length() != 0))
            {
              Log.d("MicroMsg.ChatFooter", "empty message cant be sent");
              if ((ChatFooter.n(ChatFooter.this) == null) || (!ChatFooter.n(ChatFooter.this).isShowing())) {
                ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.k.s(ChatFooter.this.getContext(), R.l.gxi, R.l.app_tip));
              }
              ChatFooter.this.iMF();
              localObject = ChatFooter.this;
              if ((((ChatFooter)localObject).Ygv != null) && (((ChatFooter)localObject).Ygv.iNh() != null)) {
                ((ao)((ChatFooter)localObject).Ygv.iNh().cm(ao.class)).jsW();
              }
              if ((ChatFooter.p(ChatFooter.this) != null) && (ChatFooter.p(ChatFooter.this).iNh() != null))
              {
                ((com.tencent.mm.ui.chatting.component.api.bd)ChatFooter.p(ChatFooter.this).iNh().cm(com.tencent.mm.ui.chatting.component.api.bd.class)).bAX(paramAnonymousView);
                ChatFooter.r(ChatFooter.this);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(31499);
              return;
            }
            ChatFooter.c(ChatFooter.this, false);
            if (TextUtils.equals(ChatFooter.b(ChatFooter.this).getText().toString(), ChatFooter.b(ChatFooter.this).getPasterContent()))
            {
              Log.i("MicroMsg.ChatFooter", "paste clip board to send");
              ChatFooter.c(ChatFooter.this, true);
            }
            ChatFooter.d(ChatFooter.this, ChatFooter.b(ChatFooter.this).getSimilarPasteChange());
            ChatFooter.a(ChatFooter.this, ChatFooter.b(ChatFooter.this).getSimilarPasteSeqStr());
            ChatFooter.e(ChatFooter.this, ClipboardHelper.isCopyFromWX(ChatFooter.b(ChatFooter.this).getText()));
            ChatFooter.b(ChatFooter.this).jFl();
            if (ChatFooter.o(ChatFooter.this) == null) {
              break label599;
            }
            localObject = ChatFooter.o(ChatFooter.this);
            if (((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).Jkn == null) {
              break label594;
            }
            bool = ((com.tencent.mm.plugin.groupsolitaire.ui.d)localObject).Jkn.isShowing();
          }
          finally {}
          if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0) && (ChatFooter.k(ChatFooter.this) != null))
          {
            ChatFooter.f(ChatFooter.this, true);
            ChatFooter.b(ChatFooter.this).getSizeAnimController().pause();
            if ((ChatFooter.p(ChatFooter.this) != null) && (ChatFooter.p(ChatFooter.this).iNh() != null)) {
              ((com.tencent.mm.ui.chatting.component.api.bd)ChatFooter.p(ChatFooter.this).iNh().cm(com.tencent.mm.ui.chatting.component.api.bd.class)).getSizeAnimController().adMx = true;
            }
            ChatFooter.this.fJI();
          }
          ChatFooter.a(ChatFooter.this, paramAnonymousView.length());
          if (ChatFooter.b(ChatFooter.this, paramAnonymousView))
          {
            Log.i("MicroMsg.ChatFooter", "this is a quote msg");
            continue;
            label594:
            bool = false;
          }
          else
          {
            label599:
            while (!bool)
            {
              bool = false;
              break label449;
              if (ChatFooter.a(ChatFooter.this, paramAnonymousView, bool))
              {
                Log.i("MicroMsg.ChatFooter", "this is a group solitatire msg");
                break;
              }
              if ((ChatFooter.k(ChatFooter.this) == null) || (!ChatFooter.k(ChatFooter.this).aKU(paramAnonymousView))) {
                break;
              }
              ChatFooter.q(ChatFooter.this);
              ChatFooter.b(ChatFooter.this).clearComposingText();
              ChatFooter.c(ChatFooter.this, paramAnonymousView);
              break;
            }
            bool = true;
          }
        }
      }
    });
    if (aw.jkP()) {}
    label2726:
    for (;;)
    {
      boolean bool = false;
      label2046:
      this.Yhg = bool;
      this.Yhh = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpr, 0.5F);
      Log.i("MicroMsg.ChatFooter", "isNewTrans2Txt:%s, transOperationAreaFactor:%s", new Object[] { Boolean.valueOf(this.Yhg), Float.valueOf(this.Yhh) });
      this.YgX = new com.tencent.mm.plugin.transvoice.model.a();
      if (this.Yhg)
      {
        paramAttributeSet = aw.bf(paramContext);
        if (paramAttributeSet != null)
        {
          paramInt = paramAttributeSet.x;
          label2141:
          this.YhT = ((int)(paramInt * this.Yhh));
          Log.d("MicroMsg.ChatFooter", "newVoice2txtVoiceModeChangeLine: %s, newVoice2txtTransModeChangeLine: %s, screenWidth:%s", new Object[] { Integer.valueOf(this.YhS), Integer.valueOf(this.YhT), Integer.valueOf(paramInt) });
          this.Yfd.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(245378);
              if (paramAnonymousView != ChatFooter.J(ChatFooter.this))
              {
                AppMethodBeat.o(245378);
                return false;
              }
              if (ChatFooter.this.YiU == ChatFooter.e.Yjs)
              {
                ChatFooter.b(ChatFooter.this, com.tencent.mm.ui.bf.bf(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(R.f.fmh) - bg.bk(paramContext));
                switch (paramAnonymousMotionEvent.getAction())
                {
                }
              }
              for (;;)
              {
                AppMethodBeat.o(245378);
                return true;
                ChatFooter.b(ChatFooter.this, com.tencent.mm.ui.bf.bf(ChatFooter.this.getContext()).y - paramContext.getResources().getDimensionPixelSize(R.f.fmh) - bg.bk(paramContext) + ChatFooter.K(ChatFooter.this));
                break;
                ChatFooter.L(ChatFooter.this).TUp = 1;
                paramAnonymousView = com.tencent.mm.cj.a.adtq;
                com.tencent.mm.cj.a.KP(false);
                ChatFooter.L(ChatFooter.this).uoS = System.currentTimeMillis();
                ChatFooter.L(ChatFooter.this).TUc = ((int)paramAnonymousMotionEvent.getRawX());
                ChatFooter.L(ChatFooter.this).TUd = ((int)paramAnonymousMotionEvent.getRawY());
                ChatFooter.a(ChatFooter.this, null);
                long l = System.nanoTime();
                ChatFooter.a(ChatFooter.this, new com.tencent.mm.modelvoiceaddr.h(String.valueOf(l & 0xFFFFFFFF)));
                ChatFooter.N(ChatFooter.this).b(ChatFooter.M(ChatFooter.this));
                if ((ChatFooter.this.getContext() instanceof Activity)) {
                  ((Activity)ChatFooter.this.getContext()).getWindow().addFlags(128);
                }
                ChatFooter.J(ChatFooter.this).setBackgroundResource(R.g.record_shape_press);
                ChatFooter.J(ChatFooter.this).setText(R.l.chatfooter_releasetofinish);
                if (ChatFooter.k(ChatFooter.this) != null) {
                  ChatFooter.k(ChatFooter.this).gad();
                }
                ChatFooter.J(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(R.l.chat_footer_switch_press_btn));
                continue;
                if ((ChatFooter.O(ChatFooter.this) == null) || (!ChatFooter.O(ChatFooter.this).isShowing()))
                {
                  Log.e("MicroMsg.NewVoice2txt", "window status err!!!");
                }
                else if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getX() < ChatFooter.J(ChatFooter.this).getWidth()) && (paramAnonymousMotionEvent.getRawY() > ChatFooter.P(ChatFooter.this)))
                {
                  if (ChatFooter.this.YiU != ChatFooter.e.Yjs)
                  {
                    ChatFooter.this.YiV = ChatFooter.this.YiU;
                    ChatFooter.this.YiU = ChatFooter.e.Yjs;
                    ChatFooter.Q(ChatFooter.this);
                  }
                }
                else if (paramAnonymousMotionEvent.getX() > ChatFooter.R(ChatFooter.this))
                {
                  if (ChatFooter.e.Yju != ChatFooter.this.YiU) {
                    if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(paramAnonymousView.getContext()))
                    {
                      ChatFooter.this.YiU = ChatFooter.e.Yjt;
                      ChatFooter.this.YiV = ChatFooter.this.YiU;
                      ChatFooter.Q(ChatFooter.this);
                    }
                    else
                    {
                      ChatFooter.this.YiV = ChatFooter.this.YiU;
                      ChatFooter.this.YiU = ChatFooter.e.Yju;
                      ChatFooter.Q(ChatFooter.this);
                    }
                  }
                }
                else if (ChatFooter.e.Yjt != ChatFooter.this.YiU)
                {
                  ChatFooter.this.YiV = ChatFooter.this.YiU;
                  ChatFooter.this.YiU = ChatFooter.e.Yjt;
                  ChatFooter.Q(ChatFooter.this);
                  continue;
                  Log.d("MicroMsg.NewVoice2txt", "begin finishCutShortSentence.");
                  ChatFooter.N(ChatFooter.this).hPA();
                  Log.d("MicroMsg.NewVoice2txt", "end finishCutShortSentence.");
                  ChatFooter.L(ChatFooter.this).TUe = System.currentTimeMillis();
                  ChatFooter.L(ChatFooter.this).TUf = ((int)paramAnonymousMotionEvent.getRawX());
                  ChatFooter.L(ChatFooter.this).TUg = ((int)paramAnonymousMotionEvent.getRawY());
                  if ((ChatFooter.this.TVW != null) && (ChatFooter.S(ChatFooter.this)))
                  {
                    if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(paramAnonymousView.getContext()))
                    {
                      ChatFooter.J(ChatFooter.this).setBackgroundResource(R.g.input_bg);
                      ChatFooter.J(ChatFooter.this).setEnabled(true);
                      if (ChatFooter.this.Yhg) {
                        ChatFooter.T(ChatFooter.this);
                      }
                      if (ChatFooter.U(ChatFooter.this) == null) {
                        continue;
                      }
                      ChatFooter.U(ChatFooter.this).dismiss();
                      continue;
                    }
                    ChatFooter.this.TVW.TTW = false;
                    paramAnonymousView = ChatFooter.this.TVW;
                    Log.d("MicroMsg.SceneVoiceInputAddr2", "reTrigger!!! canReTrigger: %s.", new Object[] { Boolean.valueOf(paramAnonymousView.TTX) });
                    if ((paramAnonymousView.TTX) && ((!((com.tencent.mm.modelvoiceaddr.c)paramAnonymousView.pfC).bPv()) || (!com.tencent.mm.kernel.h.aZW().a(paramAnonymousView.pfC, 0)))) {
                      paramAnonymousView.hPC();
                    }
                  }
                  if ((ChatFooter.this.getContext() instanceof Activity)) {
                    ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                  }
                  ChatFooter.this.iMH();
                }
              }
            }
          });
          this.Yid.addUpdateListener(this.Yii);
          this.Yie.addUpdateListener(this.Yii);
          this.Yif.addUpdateListener(this.Yii);
          this.Yig.addUpdateListener(this.Yii);
          this.Yih.addUpdateListener(this.Yii);
        }
      }
      for (;;)
      {
        this.Yfe.setOnClickListener(new ChatFooter.26(this));
        iMd();
        this.Yfi.setVisibility(0);
        this.Yfi.setContentDescription(getContext().getString(R.l.chat_footer_app_btn_fold));
        this.Yfi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = -1;
            AppMethodBeat.i(245381);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
            localObject1 = ChatFooter.D(ChatFooter.this);
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
                    if (!ChatFooter.bri(((a.a)localObject2).YeJ))
                    {
                      localObject2 = ((a.a)localObject2).YeJ;
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
            localChatFooter.Yfj.setVisibility(8);
            ((ImageButton)localObject1).setTag(Integer.valueOf(i));
            ChatFooter.this.kO(paramAnonymousView);
            if ((z.bBK().booleanValue()) && (ChatFooter.this.Ygs != null))
            {
              paramAnonymousView = ChatFooter.this.Ygs;
              localObject1 = Boolean.TRUE;
              paramAnonymousView.a((Boolean)localObject1, (Boolean)localObject1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245381);
          }
        });
        Log.i("MicroMsg.ChatFooter", "[init]");
        this.Yff.setOnTouchListener(new ChatFooter.8(this));
        this.YfZ = (((Activity)paramContext).getWindow().getAttributes().softInputMode & 0xF0);
        if ((this.YfZ != 16) && (this.YfZ != 48))
        {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1062, 8);
          if (this.YfZ != 16) {
            this.YfZ = 48;
          }
        }
        this.Ygh = KeyBoardUtil.getValidPanelHeight(paramContext);
        awJ(getKeyBordHeightPX());
        if (com.tencent.mm.compatible.util.d.rb(24)) {
          this.Ygb = ((Activity)getContext()).isInMultiWindowMode();
        }
        iMc();
        this.Yfw.setOnClickListener(new ChatFooter.9(this));
        this.Yfr.setOnClickListener(new ChatFooter.10(this));
        this.Yfq.setOnClickListener(new ChatFooter.11(this));
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
          break label2046;
        }
        if (1 != ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpq, 1)) {
          break label2726;
        }
        bool = true;
        break label2046;
        paramInt = com.tencent.mm.cd.a.ms(paramContext);
        break label2141;
        YgC = com.tencent.mm.cd.a.ms(paramContext) / 2 + com.tencent.mm.cd.a.fromDPToPix(paramContext, 30);
        this.YgW = new com.tencent.mm.plugin.transvoice.ui.b(paramContext);
        this.YgW.TWr = new b.d()
        {
          public final void beT(final String paramAnonymousString)
          {
            AppMethodBeat.i(245370);
            ChatFooter.this.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(245340);
                Log.i("MicroMsg.ChatFooter", "onTxtMsgSend, msg is null or nil? %s.", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramAnonymousString)) });
                if ((ChatFooter.k(ChatFooter.this) != null) && (!Util.isNullOrNil(paramAnonymousString))) {
                  ChatFooter.k(ChatFooter.this).aKU(paramAnonymousString);
                }
                AppMethodBeat.o(245340);
              }
            }, 200L);
            AppMethodBeat.o(245370);
          }
          
          public final void beU(String paramAnonymousString)
          {
            AppMethodBeat.i(245375);
            if (ChatFooter.k(ChatFooter.this) != null) {
              ChatFooter.k(ChatFooter.this).aKV(paramAnonymousString);
            }
            AppMethodBeat.o(245375);
          }
          
          public final boolean e(String paramAnonymousString, Long paramAnonymousLong)
          {
            AppMethodBeat.i(245373);
            Log.i("MicroMsg.ChatFooter", "onVoiceMsgSend, fileName: %s.", new Object[] { paramAnonymousString });
            if (paramAnonymousLong != null) {}
            for (int i = paramAnonymousLong.intValue();; i = 0)
            {
              if (ChatFooter.k(ChatFooter.this) != null)
              {
                boolean bool = ChatFooter.k(ChatFooter.this).fN(paramAnonymousString, i);
                AppMethodBeat.o(245373);
                return bool;
              }
              AppMethodBeat.o(245373);
              return false;
            }
          }
          
          public final void hPS()
          {
            AppMethodBeat.i(245367);
            if (ChatFooter.V(ChatFooter.this).isShowing()) {
              ChatFooter.V(ChatFooter.this).dismiss();
            }
            ChatFooter.this.Ygc = true;
            AppMethodBeat.o(245367);
          }
        };
        this.Yfd.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(245399);
            if (paramAnonymousView != ChatFooter.J(ChatFooter.this))
            {
              AppMethodBeat.o(245399);
              return false;
            }
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(245399);
              return true;
              Log.i("MicroMsg.RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[] { Integer.valueOf(ChatFooter.iNc()) });
              paramAnonymousView = com.tencent.mm.cj.a.adtq;
              com.tencent.mm.cj.a.KP(false);
              ChatFooter.L(ChatFooter.this).uoS = System.currentTimeMillis();
              ChatFooter.L(ChatFooter.this).TUc = ((int)paramAnonymousMotionEvent.getRawX());
              ChatFooter.L(ChatFooter.this).TUd = ((int)paramAnonymousMotionEvent.getRawY());
              ChatFooter.W(ChatFooter.this);
              if ((ChatFooter.X(ChatFooter.this)) && (ChatFooter.U(ChatFooter.this) != null))
              {
                ChatFooter.Y(ChatFooter.this);
                if (ChatFooter.Z(ChatFooter.this) != null) {
                  ChatFooter.Z(ChatFooter.this).getBlurController().destroy();
                }
                if (ChatFooter.aa(ChatFooter.this) != null) {
                  ChatFooter.aa(ChatFooter.this).getBlurController().destroy();
                }
              }
              Log.i("MicroMsg.RcdBtnEvent", "trans voice opener: %s, blur mode opener: %s.", new Object[] { Boolean.valueOf(ChatFooter.ab(ChatFooter.this)), ChatFooter.ac(ChatFooter.this) });
              if (ChatFooter.ab(ChatFooter.this)) {}
              for (ChatFooter.L(ChatFooter.this).TUp = 1;; ChatFooter.L(ChatFooter.this).TUp = 0)
              {
                ChatFooter.a(ChatFooter.this, null);
                long l = System.nanoTime();
                ChatFooter.a(ChatFooter.this, new com.tencent.mm.modelvoiceaddr.h(String.valueOf(l & 0xFFFFFFFF)));
                ChatFooter.N(ChatFooter.this).b(ChatFooter.M(ChatFooter.this));
                if ((ChatFooter.this.getContext() instanceof Activity)) {
                  ((Activity)ChatFooter.this.getContext()).getWindow().addFlags(128);
                }
                if ((ChatFooter.ad(ChatFooter.this)) || (ChatFooter.ae(ChatFooter.this))) {
                  break;
                }
                ChatFooter.g(ChatFooter.this, true);
                ChatFooter.J(ChatFooter.this).setBackgroundResource(R.g.record_shape_press);
                ChatFooter.J(ChatFooter.this).setText(R.l.chatfooter_releasetofinish);
                if (ChatFooter.k(ChatFooter.this) != null) {
                  ChatFooter.k(ChatFooter.this).gad();
                }
                ChatFooter.J(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(R.l.chat_footer_switch_press_btn));
                break;
              }
              if ((ChatFooter.U(ChatFooter.this) == null) || (!ChatFooter.U(ChatFooter.this).isShowing()))
              {
                if (ChatFooter.U(ChatFooter.this) == null) {}
                for (boolean bool = true;; bool = false)
                {
                  Log.e("MicroMsg.RcdBtnEvent", "hint window status err, window is null: %s.", new Object[] { Boolean.valueOf(bool) });
                  break;
                }
              }
              if (ChatFooter.ab(ChatFooter.this))
              {
                if ((ChatFooter.af(ChatFooter.this) == null) || (ChatFooter.ag(ChatFooter.this) == null)) {
                  Log.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! voice2txtRealHintArea is %s, voice2txtOpeLayout is %s.", new Object[] { ChatFooter.af(ChatFooter.this), ChatFooter.ag(ChatFooter.this) });
                }
                if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getY() > -ChatFooter.ah(ChatFooter.this) / 3) && (paramAnonymousMotionEvent.getX() < ChatFooter.J(ChatFooter.this).getWidth()))
                {
                  if (ChatFooter.ai(ChatFooter.this) != ChatFooter.l.YjO)
                  {
                    Log.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_1.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.YjO);
                    if (ChatFooter.aj(ChatFooter.this))
                    {
                      ChatFooter.ak(ChatFooter.this).animate().cancel();
                      ChatFooter.al(ChatFooter.this).animate().cancel();
                      if (ChatFooter.j.YjG == ChatFooter.ac(ChatFooter.this))
                      {
                        ChatFooter.Z(ChatFooter.this).setAlpha(0.5F);
                        ChatFooter.Z(ChatFooter.this).animate().alpha(1.0F).setDuration(300L).start();
                        ChatFooter.Z(ChatFooter.this).aBy(ChatFooter.this.getResources().getColor(R.e.flc)).V(ChatFooter.e(ChatFooter.this).getWindow().getDecorView().getBackground()).LP(true);
                      }
                      for (;;)
                      {
                        ChatFooter.V(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(200L).start();
                        ChatFooter.am(ChatFooter.this).setVisibility(0);
                        ChatFooter.an(ChatFooter.this).setVisibility(8);
                        ChatFooter.ag(ChatFooter.this).setVisibility(8);
                        ChatFooter.a(ChatFooter.this, ChatFooter.k.YjJ);
                        ChatFooter.ao(ChatFooter.this);
                        break;
                        ChatFooter.af(ChatFooter.this).setBackgroundResource(R.g.fpI);
                      }
                    }
                  }
                }
                else
                {
                  if (ChatFooter.ai(ChatFooter.this) != ChatFooter.l.YjP)
                  {
                    Log.i("MicroMsg.RcdBtnEvent", "active MODE_HINT_2.");
                    ChatFooter.a(ChatFooter.this, ChatFooter.l.YjP);
                    if (!ChatFooter.aj(ChatFooter.this)) {
                      ChatFooter.ap(ChatFooter.this);
                    }
                    Log.i("MicroMsg.RcdBtnEvent", "init rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.iNd()) });
                    if (paramAnonymousMotionEvent.getRawX() > ChatFooter.iNd())
                    {
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.YjK);
                      Log.i("MicroMsg.RcdBtnEvent", "init MODE_TRANS");
                      label1034:
                      if (ChatFooter.j.YjG != ChatFooter.ac(ChatFooter.this)) {
                        break label1312;
                      }
                      ChatFooter.Z(ChatFooter.this).aBy(0).V(null).LP(false);
                    }
                    for (;;)
                    {
                      ChatFooter.V(ChatFooter.this).getContentView().animate().alpha(1.0F).setDuration(200L).start();
                      ChatFooter.am(ChatFooter.this).setVisibility(8);
                      ChatFooter.an(ChatFooter.this).setVisibility(0);
                      ChatFooter.ag(ChatFooter.this).setVisibility(0);
                      ChatFooter.ak(ChatFooter.this).setVisibility(0);
                      ChatFooter.al(ChatFooter.this).setVisibility(0);
                      ChatFooter.ak(ChatFooter.this).setAlpha(0.0F);
                      ChatFooter.al(ChatFooter.this).setAlpha(0.0F);
                      ChatFooter.ak(ChatFooter.this).animate().translationX(ChatFooter.as(ChatFooter.this)).translationY(ChatFooter.ar(ChatFooter.this)).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(150L).withEndAction(ChatFooter.aq(ChatFooter.this)).start();
                      ChatFooter.al(ChatFooter.this).animate().translationX(ChatFooter.as(ChatFooter.this)).translationY(ChatFooter.ar(ChatFooter.this)).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(150L).start();
                      break;
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.YjL);
                      Log.i("MicroMsg.RcdBtnEvent", "init MODE_CANCEL");
                      break label1034;
                      label1312:
                      ChatFooter.af(ChatFooter.this).setBackgroundColor(0);
                    }
                  }
                  if (ChatFooter.at(ChatFooter.this))
                  {
                    Log.i("MicroMsg.RcdBtnEvent", "active rx: %f, x: %f, shw: %d.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getX()), Integer.valueOf(ChatFooter.iNd()) });
                    if ((paramAnonymousMotionEvent.getRawX() > ChatFooter.iNd()) && (ChatFooter.k.YjK != ChatFooter.au(ChatFooter.this)))
                    {
                      Log.i("MicroMsg.RcdBtnEvent", "active MODE_TRANS.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.YjK);
                      ChatFooter.an(ChatFooter.this).setText(ChatFooter.this.getResources().getText(R.l.gXK));
                      ChatFooter.av(ChatFooter.this);
                      ChatFooter.aw(ChatFooter.this);
                    }
                    else if ((paramAnonymousMotionEvent.getRawX() <= ChatFooter.iNd()) && (ChatFooter.k.YjL != ChatFooter.au(ChatFooter.this)))
                    {
                      Log.i("MicroMsg.RcdBtnEvent", "active MODE_CANCEL.");
                      ChatFooter.a(ChatFooter.this, ChatFooter.k.YjL);
                      ChatFooter.an(ChatFooter.this).setText(ChatFooter.this.getResources().getText(R.l.gXI));
                      ChatFooter.ax(ChatFooter.this);
                      ChatFooter.ay(ChatFooter.this);
                    }
                  }
                }
              }
              else
              {
                if ((ChatFooter.az(ChatFooter.this) == null) || (ChatFooter.aA(ChatFooter.this) == null)) {
                  Log.e("MicroMsg.RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", new Object[] { ChatFooter.az(ChatFooter.this), ChatFooter.aA(ChatFooter.this) });
                }
                if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getY() > -ChatFooter.ah(ChatFooter.this) / 2) && (paramAnonymousMotionEvent.getX() < ChatFooter.J(ChatFooter.this).getWidth()))
                {
                  if (ChatFooter.az(ChatFooter.this) != null) {
                    ChatFooter.az(ChatFooter.this).setVisibility(0);
                  }
                  if (ChatFooter.aA(ChatFooter.this) != null)
                  {
                    ChatFooter.J(ChatFooter.this).setText(R.l.chatfooter_releasetofinish);
                    ChatFooter.aA(ChatFooter.this).setVisibility(8);
                  }
                }
                else
                {
                  if (ChatFooter.az(ChatFooter.this) != null) {
                    ChatFooter.az(ChatFooter.this).setVisibility(8);
                  }
                  if (ChatFooter.aA(ChatFooter.this) != null)
                  {
                    ChatFooter.J(ChatFooter.this).setTextSize(0, com.tencent.mm.cd.a.bs(ChatFooter.this.getContext(), R.f.NormalTextSize) * com.tencent.mm.cd.a.jO(ChatFooter.this.getContext()));
                    ChatFooter.J(ChatFooter.this).setText(R.l.chatfooter_cancel_tips);
                    ChatFooter.aA(ChatFooter.this).setVisibility(0);
                    continue;
                    ChatFooter.N(ChatFooter.this).hPA();
                    if ((ChatFooter.this.getContext() instanceof Activity)) {
                      ((Activity)ChatFooter.this.getContext()).getWindow().clearFlags(128);
                    }
                    ChatFooter.L(ChatFooter.this).TUe = System.currentTimeMillis();
                    ChatFooter.L(ChatFooter.this).TUf = ((int)paramAnonymousMotionEvent.getRawX());
                    ChatFooter.L(ChatFooter.this).TUg = ((int)paramAnonymousMotionEvent.getRawY());
                    Log.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.iNc()) });
                    ChatFooter.this.iMH();
                    Log.i("MicroMsg.RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.iNe()) });
                  }
                }
              }
            }
          }
        });
        this.Yfd.setOnKeyListener(new View.OnKeyListener()
        {
          public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(245360);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            localb.sc(paramAnonymousInt);
            localb.cH(paramAnonymousKeyEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$36", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
            switch (paramAnonymousKeyEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$36", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(245360);
              return false;
              if (((paramAnonymousInt == 23) || (paramAnonymousInt == 66)) && (!ChatFooter.ae(ChatFooter.this)) && (!ChatFooter.ad(ChatFooter.this)))
              {
                ChatFooter.h(ChatFooter.this, true);
                ChatFooter.J(ChatFooter.this).setBackgroundResource(R.g.record_shape_press);
                ChatFooter.J(ChatFooter.this).setText(R.l.chatfooter_releasetofinish);
                if (ChatFooter.k(ChatFooter.this) != null) {
                  ChatFooter.k(ChatFooter.this).gad();
                }
                ChatFooter.J(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(R.l.chat_footer_switch_press_btn));
                continue;
                if ((paramAnonymousInt == 23) || (paramAnonymousInt == 66))
                {
                  ChatFooter.J(ChatFooter.this).setBackgroundResource(R.g.input_bg);
                  ChatFooter.J(ChatFooter.this).setText(R.l.chatfooter_presstorcd);
                  if (ChatFooter.k(ChatFooter.this) != null) {
                    ChatFooter.k(ChatFooter.this).fZY();
                  }
                  ChatFooter.h(ChatFooter.this, false);
                }
              }
            }
          }
        });
      }
    }
  }
  
  private void JX(boolean paramBoolean)
  {
    AppMethodBeat.i(245454);
    JY(paramBoolean);
    iMb();
    AppMethodBeat.o(245454);
  }
  
  private void JZ(boolean paramBoolean)
  {
    AppMethodBeat.i(31598);
    if (paramBoolean)
    {
      this.Yfn.setVisibility(0);
      this.Yfl.setVisibility(0);
      bF(true, false);
      AppMethodBeat.o(31598);
      return;
    }
    this.Yfn.setVisibility(8);
    this.Yfl.setVisibility(8);
    bF(false, false);
    AppMethodBeat.o(31598);
  }
  
  private void Kc(boolean paramBoolean)
  {
    AppMethodBeat.i(31673);
    if (this.Yfk == null)
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((this.Yiz) && (paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    if ((!this.Yiz) && (!paramBoolean))
    {
      AppMethodBeat.o(31673);
      return;
    }
    this.Yiz = paramBoolean;
    if (paramBoolean)
    {
      this.Yfk.setImageDrawable(getContext().getResources().getDrawable(R.g.chatting_setmode_keyboard_btn));
      this.Yfk.setContentDescription(getContext().getResources().getString(R.l.chatfooter_keyboard_acc_desc));
      AppMethodBeat.o(31673);
      return;
    }
    this.Yfk.setImageDrawable(getContext().getResources().getDrawable(R.k.icons_outlined_emoji));
    this.Yfk.setContentDescription(getContext().getResources().getString(R.l.chatfooter_emoji_acc_desc));
    AppMethodBeat.o(31673);
  }
  
  private void a(boolean paramBoolean, final Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(163216);
    if (paramBoolean)
    {
      if (this.Yfb == null) {
        iMd();
      }
      this.Yfb.animate().cancel();
      if ((this.Yfb.getVisibility() == 0) && (this.Yfb.getAlpha() == 1.0F)) {
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    }
    for (;;)
    {
      this.Rqt.jEF();
      AppMethodBeat.o(163216);
      return;
      setAppPanelVisible(0);
      this.Yfb.setAlpha(0.0F);
      this.Yfb.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(185379);
          AppMethodBeat.o(185379);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(185378);
          ChatFooter.bw(ChatFooter.this);
          ChatFooter.bx(ChatFooter.this).animate().setListener(null);
          AppMethodBeat.o(185378);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(185377);
          AppMethodBeat.o(185377);
        }
      }).start();
      this.Yfb.setUncertainEnterLocation(paramInt);
      this.Yfb.bDL();
      continue;
      this.Yfb.animate().cancel();
      if ((this.Yfb.getVisibility() == 4) || (this.Yfb.getAlpha() == 0.0F))
      {
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
      else {
        this.Yfb.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185381);
            ChatFooter.this.setAppPanelVisible(4);
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(185381);
          }
        });
      }
    }
  }
  
  private void appendText(String paramString)
  {
    AppMethodBeat.i(245456);
    if (this.Rqt == null)
    {
      AppMethodBeat.o(245456);
      return;
    }
    this.Rqt.append(paramString);
    this.Rqt.setSelection(this.Rqt.getText().length());
    this.Rqt.jEJ();
    AppMethodBeat.o(245456);
  }
  
  private void awC(int paramInt)
  {
    AppMethodBeat.i(31593);
    if (this.Yfe == null)
    {
      AppMethodBeat.o(31593);
      return;
    }
    if (paramInt == R.g.fnr) {}
    for (int i = 1;; i = 0)
    {
      if (this.Yfe != null)
      {
        if (i == 0) {
          break label83;
        }
        this.Yfe.setContentDescription(getContext().getString(R.l.chat_footer_switch_mode_voice_btn));
      }
      for (;;)
      {
        this.Yfe.setImageResource(paramInt);
        this.Yfe.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(31593);
        return;
        label83:
        this.Yfe.setContentDescription(getContext().getString(R.l.chat_footer_switch_mode_keybord_btn));
      }
    }
  }
  
  private void awG(int paramInt)
  {
    AppMethodBeat.i(245484);
    if ((this.Ygv == null) || (this.Ygv.iNh() == null))
    {
      AppMethodBeat.o(245484);
      return;
    }
    switch (paramInt)
    {
    default: 
      setVisibility(0);
      AppMethodBeat.o(245484);
      return;
    case 1: 
      ((com.tencent.mm.ui.chatting.component.api.bd)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.bd.class)).jum();
      AppMethodBeat.o(245484);
      return;
    }
    ((com.tencent.mm.ui.chatting.component.api.bd)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.bd.class)).jul();
    AppMethodBeat.o(245484);
  }
  
  private void awI(int paramInt)
  {
    AppMethodBeat.i(31666);
    if (paramInt == this.mjd)
    {
      AppMethodBeat.o(31666);
      return;
    }
    if (this.mkz.getVisibility() == 8) {
      iMF();
    }
    if (((paramInt == 0) && (this.Yfl.getVisibility() == 8)) || (paramInt == 3) || ((paramInt == 0) && (this.Yfl.getVisibility() == 8))) {
      iMF();
    }
    AppMethodBeat.o(31666);
  }
  
  private void awJ(int paramInt)
  {
    AppMethodBeat.i(31680);
    Log.i("MicroMsg.ChatFooter", "[refreshBottomHeight] keyborPx:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.compatible.util.j.setFixedHeight(false);
    int i;
    if ((au.bwO(this.Yfa)) || (au.bwP(this.Yfa)))
    {
      paramInt = com.tencent.mm.compatible.util.j.getValidPanelHeight(getContext(), paramInt, 43);
      i = ae.cp(getContext());
      if ((!this.YfV) || (this.Ygb)) {
        break label367;
      }
    }
    label367:
    for (this.Ygh = paramInt;; this.Ygh = KeyBoardUtil.getValidPanelHeight(getContext()))
    {
      paramInt = Math.max(i, this.Ygh);
      this.Ygi = paramInt;
      if (paramInt != this.Ygg) {
        this.Ygg = paramInt;
      }
      Log.i("MicroMsg.ChatFooter", "refreshBottomHeight: %s, %s, %s, %s, %s", new Object[] { Boolean.valueOf(this.YfV), Boolean.valueOf(this.Ygb), Integer.valueOf(this.Ygh), Integer.valueOf(this.Ygg), Boolean.valueOf(KeyBoardUtil.isPortOrientation(getContext())) });
      Object localObject = this.Yfg.getLayoutParams();
      if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != this.Ygg))
      {
        ((ViewGroup.LayoutParams)localObject).height = this.Ygg;
        this.Yfg.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.Yfg.requestLayout();
      }
      if (this.YfY)
      {
        paramInt = -this.Ygg;
        localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
        if ((localObject != null) && (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != paramInt))
        {
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
          setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.Yfb != null)
      {
        this.Yfb.setPortHeighPx(this.Ygh);
        this.Yfb.iLO();
      }
      if (this.Yab != null)
      {
        paramInt = this.Ygh + this.Yff.getHeight();
        localObject = this.Yab.getLayoutParams();
        if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height != paramInt))
        {
          ((ViewGroup.LayoutParams)localObject).height = paramInt;
          this.Yab.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(31680);
      return;
      paramInt = com.tencent.mm.compatible.util.j.getValidPanelHeight(getContext(), paramInt);
      break;
    }
  }
  
  private void bF(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31599);
    if (paramBoolean1)
    {
      if ((this.Yfo.getTag() != null) && ((this.Yfo.getTag() instanceof cc)))
      {
        this.Yfo.setVisibility(0);
        Object localObject = (cc)this.Yfo.getTag();
        this.Yfs.setText(p.b(getContext(), com.tencent.mm.plugin.msgquote.model.a.a(getContext(), this.Yfs.getTextSize(), (cc)localObject)));
        localObject = (RelativeLayout.LayoutParams)this.Yfs.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.ui.bd.bs(getContext(), R.f.Edge_4A);
        ((RelativeLayout.LayoutParams)localObject).topMargin = com.tencent.mm.ui.bd.bs(getContext(), R.f.Edge_0_25A);
        ((RelativeLayout.LayoutParams)localObject).removeRule(10);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        this.Yfs.setGravity(19);
        this.Yfs.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (ViewGroup.MarginLayoutParams)this.Yfv.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.ui.bd.bs(getContext(), R.f.Edge_0_25A);
        this.Yfv.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.Yfv.setVisibility(8);
        this.Yft.setVisibility(8);
        this.Yfu.setVisibility(8);
        AppMethodBeat.o(31599);
        return;
      }
      this.Yfo.setVisibility(8);
      this.Yft.setVisibility(8);
      this.Yfu.setVisibility(8);
      AppMethodBeat.o(31599);
      return;
    }
    if (paramBoolean2)
    {
      this.Yfo.setTag(null);
      this.Yfs.setText("");
      this.Yft.setImageBitmap(null);
      this.Yfu.setImageDrawable(null);
    }
    this.Yft.setVisibility(8);
    this.Yfu.setVisibility(8);
    this.Yfo.setVisibility(8);
    AppMethodBeat.o(31599);
  }
  
  static boolean bri(String paramString)
  {
    AppMethodBeat.i(163219);
    boolean bool = MultiProcessMMKV.getMMKV("plus_uncertain_enter").getBoolean(paramString, false);
    AppMethodBeat.o(163219);
    return bool;
  }
  
  private void bw(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185825);
    if (1 == paramInt3) {}
    for (boolean bool = true; ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) && (paramInt2 == 0); bool = false)
    {
      if (this.Ygm == null) {
        break label111;
      }
      this.Ygm.LW(bool);
      AppMethodBeat.o(185825);
      return;
    }
    if ((paramInt1 == 0) && ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 4)) && (this.Ygm != null)) {
      this.Ygm.LX(bool);
    }
    label111:
    AppMethodBeat.o(185825);
  }
  
  private void c(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185824);
    iMC();
    if (this.YfX != null)
    {
      if ((this.Ygf) && (this.mjd == 1))
      {
        this.YfX.d(0, false, paramInt2, paramInt3);
        AppMethodBeat.o(185824);
        return;
      }
      this.YfX.d(paramInt1, paramBoolean, paramInt2, paramInt3);
      AppMethodBeat.o(185824);
      return;
    }
    if ((this.mjd == 0) || (this.mjd == 1)) {
      this.Yfg.setVisibility(8);
    }
    Log.e("MicroMsg.ChatFooter", "scrollParent: scrollParent is not ChattingScrollLayout");
    AppMethodBeat.o(185824);
  }
  
  private boolean dY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(179783);
    if (iMG())
    {
      AppMethodBeat.o(179783);
      return false;
    }
    if ((this.Ygv == null) || (Util.isNullOrNil(this.Ygv.getTalkerUserName())))
    {
      Log.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg username == null");
      AppMethodBeat.o(179783);
      return false;
    }
    try
    {
      String str = this.Ygv.getTalkerUserName();
      if ((((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aHL(str)) && (paramBoolean))
      {
        this.Yfz.fJF();
        try
        {
          localObject = ((com.tencent.mm.plugin.emoji.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.a.class)).anH(paramString);
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
          locala2 = com.tencent.mm.plugin.groupsolitaire.b.b.a(localException, this.Yfz.Jkx, locala1);
          if (!locala2.Jjp) {
            break label296;
          }
          com.tencent.mm.plugin.groupsolitaire.b.b.c(locala2);
          label296:
          locala2.field_lastActiveTime = cn.getSyncServerTimeSecond();
          if (locala1 == null) {
            break label391;
          }
        }
        localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().jq(paramString, str);
        if ((((Integer)((Pair)localObject).first).intValue() > 0) && (((Pair)localObject).second != null))
        {
          localObject = (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second;
          com.tencent.mm.plugin.groupsolitaire.b.b.a(str, z.bAM(), (com.tencent.mm.plugin.groupsolitaire.c.a)localObject);
          com.tencent.mm.plugin.groupsolitaire.c.a locala1 = com.tencent.mm.plugin.groupsolitaire.b.b.a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().A(str, ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_key, true), z.bAM(), 1);
          if (locala1 == null)
          {
            Log.i("MicroMsg.ChatFooter", "ifInterceptGroupSolitatireMsg storageGroupSolitatire == null");
            AppMethodBeat.o(179783);
            return false;
          }
          com.tencent.mm.plugin.groupsolitaire.c.a locala2;
          paramBoolean = true;
          com.tencent.mm.plugin.groupsolitaire.b.b.a(locala2, paramBoolean, true);
          PluginGroupSolitaire localPluginGroupSolitaire = (PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class);
          if (locala1.field_active == 0) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            localPluginGroupSolitaire.sendGroupSolitatire(paramString, str, localException, locala2, locala1, paramBoolean);
            if (this.YfA != null) {
              this.YfA.aHY(paramString);
            }
            this.Yfz.reset();
            iLY();
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
  
  private void e(boolean paramBoolean, final Runnable paramRunnable)
  {
    AppMethodBeat.i(31658);
    if (paramBoolean)
    {
      if (this.moD == null) {
        iMc();
      }
      this.moD.animate().cancel();
      if ((this.moD.getVisibility() == 0) && (this.moD.getAlpha() == 1.0F))
      {
        if (paramRunnable != null)
        {
          paramRunnable.run();
          AppMethodBeat.o(31658);
        }
      }
      else
      {
        this.moD.setVisibility(0);
        this.moD.setAlpha(0.0F);
        this.moD.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
        this.moD.setToSendText(this.Rqt.getText().toString());
        AppMethodBeat.o(31658);
      }
    }
    else if ((this.moD == null) || (this.moD.getVisibility() == 4) || (this.moD.getAlpha() == 0.0F))
    {
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(31658);
      }
    }
    else
    {
      this.moD.animate().cancel();
      this.moD.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185382);
          ChatFooter.H(ChatFooter.this).setVisibility(4);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(185382);
        }
      }).start();
    }
    AppMethodBeat.o(31658);
  }
  
  private boolean fJE()
  {
    AppMethodBeat.i(31608);
    if (this.Yfz != null)
    {
      boolean bool = this.Yfz.fJE();
      AppMethodBeat.o(31608);
      return bool;
    }
    AppMethodBeat.o(31608);
    return false;
  }
  
  private int getDefaultLangType()
  {
    AppMethodBeat.i(185418);
    int i = g.pfE;
    String str = LocaleUtil.getCurrentLanguage(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW"))) {
      i = g.pfF;
    }
    for (;;)
    {
      AppMethodBeat.o(185418);
      return i;
      if (str.equals("en")) {
        i = g.pfH;
      }
    }
  }
  
  private int getTransLangTypeByTalker()
  {
    AppMethodBeat.i(185417);
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voice2txt_sp", 0);
    int j = localSharedPreferences.getInt(this.Yfa, g.pfE);
    if (this.Yhs != null)
    {
      Iterator localIterator = this.Yhs.TUF.lMl.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((com.tencent.mm.plugin.transvoice.ui.a.a.a)localIterator.next()).TWH != j);
      for (i = 1; i == 0; i = 0)
      {
        i = getDefaultLangType();
        if (g.pfE != i) {
          localSharedPreferences.edit().putInt(this.Yfa, i).apply();
        }
        AppMethodBeat.o(185417);
        return i;
      }
      AppMethodBeat.o(185417);
      return j;
    }
    int i = getDefaultLangType();
    if (g.pfE != i) {
      localSharedPreferences.edit().putInt(this.Yfa, i).apply();
    }
    AppMethodBeat.o(185417);
    return i;
  }
  
  private void iLW()
  {
    AppMethodBeat.i(31572);
    if (this.Ygr != null)
    {
      o localo = this.Ygr;
      localo.ilk = 0L;
      localo.ili = 0L;
      localo.ilj = 0L;
      localo.ill = 0L;
      localo.eq(0L).er(0L);
    }
    AppMethodBeat.o(31572);
  }
  
  private void iMC()
  {
    AppMethodBeat.i(31660);
    if (this.YfX == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ChattingScrollLayout))
      {
        this.YfX = ((ChattingScrollLayout)localViewParent);
        this.YfY = true;
      }
    }
    AppMethodBeat.o(31660);
  }
  
  private void iMD()
  {
    AppMethodBeat.i(31668);
    if (!this.cqi)
    {
      Log.i("MicroMsg.ChatFooter", "updateKeyboardProvider: not resumed %s", new Object[] { Util.getStack() });
      AppMethodBeat.o(31668);
      return;
    }
    if ((this.Ygb) || (!this.YfV))
    {
      this.lKz.close();
      ((Activity)getContext()).getWindow().setSoftInputMode(18);
      AppMethodBeat.o(31668);
      return;
    }
    ((Activity)getContext()).getWindow().setSoftInputMode(this.YfZ);
    this.lKz.start();
    AppMethodBeat.o(31668);
  }
  
  private void iMN()
  {
    AppMethodBeat.i(31687);
    this.YgO.setVisibility(8);
    this.YgR.setVisibility(8);
    this.YgO.setScaleX(0.5F);
    this.YgO.setScaleY(0.5F);
    this.YgR.setScaleX(0.5F);
    this.YgR.setScaleY(0.5F);
    this.YgO.setTranslationX(this.YiM);
    this.YgO.setTranslationY(-this.YiN);
    this.YgR.setTranslationX(-this.YiM);
    this.YgR.setTranslationY(-this.YiN);
    iMO();
    iMP();
    AppMethodBeat.o(31687);
  }
  
  private void iMO()
  {
    AppMethodBeat.i(31688);
    this.YgP.setIconColor(getResources().getColor(R.e.black_per90));
    this.YgQ.setTextColor(getResources().getColor(R.e.fle));
    this.YgO.setBackgroundDrawable(getResources().getDrawable(R.g.voice2txt_normal_bg));
    AppMethodBeat.o(31688);
  }
  
  private void iMP()
  {
    AppMethodBeat.i(31689);
    this.YgS.setIconColor(getResources().getColor(R.e.black_per90));
    this.YgT.setTextColor(getResources().getColor(R.e.fle));
    this.YgR.setBackgroundDrawable(getResources().getDrawable(R.g.voice2txt_normal_bg));
    AppMethodBeat.o(31689);
  }
  
  private void iMQ()
  {
    AppMethodBeat.i(31690);
    String str = LocaleUtil.getCurrentLanguage(getContext());
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
    {
      this.YgM.setImageResource(R.k.voice2txt_hint_trans_chs);
      this.YgS.setImageResource(R.k.voice2txt_trans_chs_img);
      AppMethodBeat.o(31690);
      return;
    }
    if (str.equals("en"))
    {
      this.YgM.setImageResource(R.k.voice2txt_hint_trans_eng);
      this.YgS.setImageResource(R.k.voice2txt_trans_eng_img);
    }
    AppMethodBeat.o(31690);
  }
  
  private void iMR()
  {
    AppMethodBeat.i(185403);
    int k = this.Yhl.getWidth();
    int m = this.Yhl.getHeight();
    int j = 0;
    int i = 0;
    switch (92.Yjm[this.YiU.ordinal()])
    {
    }
    for (;;)
    {
      Log.i("MicroMsg.ChatFooter", "beginWidth:%s, endWidth:%s, beginHeight:%s, endHeight:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i) });
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { k, j }).setDuration(200L);
      localValueAnimator1.addUpdateListener(new ChatFooter.84(this));
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { m, i }).setDuration(200L);
      localValueAnimator2.addUpdateListener(new ChatFooter.85(this));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
      localAnimatorSet.start();
      AppMethodBeat.o(185403);
      return;
      j = this.Yiu;
      i = this.TZL;
      continue;
      j = this.Yim;
      i = this.Yir;
      continue;
      j = this.Yin;
      i = this.TZL;
    }
  }
  
  private void iMS()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(185404);
    float f3 = this.Yhl.getTranslationX();
    float f1 = f2;
    switch (92.Yjm[this.YiU.ordinal()])
    {
    }
    for (f1 = f2;; f1 = -(com.tencent.mm.ui.bf.bf(getContext()).x / 2 - com.tencent.mm.ui.bd.fromDPToPix(getContext(), 76)))
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f3, f1 }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ChatFooter.86(this));
      localValueAnimator.start();
      AppMethodBeat.o(185404);
      return;
    }
  }
  
  private void iMT()
  {
    AppMethodBeat.i(185405);
    this.Yhl.setAlpha(0.0F);
    this.Yhl.setTranslationY(com.tencent.mm.ui.bd.fromDPToPix(getContext(), 56));
    this.Yho.setAlpha(0);
    this.Yho.setTranslationY(com.tencent.mm.ui.bd.fromDPToPix(getContext(), 56));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.Yhl, "translationY", new float[] { this.Yhl.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.Yhl, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.Yho, "translationY", new float[] { this.Yho.getTranslationY(), 0.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofInt(this.Yho, "alpha", new int[] { 0, 255 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    localAnimatorSet.start();
    AppMethodBeat.o(185405);
  }
  
  private void iMU()
  {
    AppMethodBeat.i(185406);
    this.Yhn.setVisibility(8);
    this.Yhq.setVisibility(0);
    this.Yhq.setTextColor(getContext().getResources().getColor(R.e.black));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Yhu.getLayoutParams();
    localLayoutParams.addRule(13);
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    this.Yhq.setText(String.format(getContext().getResources().getString(R.l.gOG), new Object[] { Integer.valueOf(this.Yiv) }));
    this.Yhu.requestLayout();
    AppMethodBeat.o(185406);
  }
  
  private void iMV()
  {
    AppMethodBeat.i(185407);
    this.Yhn.setVisibility(8);
    this.Yhq.setVisibility(0);
    this.Yhq.setTextColor(getContext().getResources().getColor(R.e.half_alpha_black));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Yhu.getLayoutParams();
    localLayoutParams.removeRule(13);
    localLayoutParams.addRule(21);
    localLayoutParams.addRule(12);
    this.Yhq.setText(String.format(getContext().getResources().getString(R.l.gOG), new Object[] { Integer.valueOf(this.Yiv) }));
    this.Yhu.requestLayout();
    AppMethodBeat.o(185407);
  }
  
  private void iMW()
  {
    AppMethodBeat.i(185408);
    this.Yhn.setVisibility(0);
    this.Yhq.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Yhu.getLayoutParams();
    localLayoutParams.removeRule(21);
    localLayoutParams.removeRule(12);
    localLayoutParams.addRule(13);
    this.Yhu.requestLayout();
    ((RelativeLayout.LayoutParams)this.Yhn.getLayoutParams()).bottomMargin = 0;
    this.Yhn.requestLayout();
    AppMethodBeat.o(185408);
  }
  
  private void iMX()
  {
    AppMethodBeat.i(185409);
    this.YhN.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).withEndAction(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245414);
        ChatFooter.bH(ChatFooter.this).setVisibility(8);
        ChatFooter.bI(ChatFooter.this).F(ChatFooter.this.getResources().getColor(R.e.black), 0.5F);
        AppMethodBeat.o(245414);
      }
    }).start();
    this.YhO.animate().translationY(0.0F).alpha(1.0F).setDuration(100L).start();
    this.YhP.animate().translationY(0.0F).setDuration(100L).start();
    if (this.Yiv < 10) {
      iMU();
    }
    for (;;)
    {
      this.Yhv.setVisibility(0);
      this.Yht.setVisibility(8);
      this.Yhm.setVisibility(8);
      this.Yho.setImageDrawable(bb.m(getContext(), R.k.icons_filled_voice2txt_cursor, getContext().getResources().getColor(R.e.LightGreen)));
      this.Yho.animate().translationX(0.0F).setDuration(150L).start();
      this.Yhl.setActivated(true);
      iMR();
      iMS();
      AppMethodBeat.o(185409);
      return;
      iMW();
      this.Yhn.a(SoundWaveView.d.TVG);
    }
  }
  
  private void iMY()
  {
    AppMethodBeat.i(185410);
    this.YhC.setVisibility(4);
    this.YhA.F(getResources().getColor(R.e.White), 0.5F);
    this.Yhy.setBackgroundDrawable(getResources().getDrawable(R.g.foH));
    this.Yhy.animate().scaleX(1.0F).scaleY(1.0F).setDuration(150L).start();
    AppMethodBeat.o(185410);
  }
  
  private void iMZ()
  {
    AppMethodBeat.i(185411);
    this.YhD.setVisibility(4);
    this.YhB.F(getResources().getColor(R.e.White), 0.5F);
    this.Yhz.setBackgroundDrawable(getResources().getDrawable(R.g.foH));
    this.Yhz.animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    AppMethodBeat.o(185411);
  }
  
  private void iMb()
  {
    if (this.hDw == null) {}
  }
  
  private void iMd()
  {
    AppMethodBeat.i(31594);
    String str;
    if (this.Ygv == null)
    {
      str = this.Yfa;
      this.Yfb = ((AppPanel)findViewById(R.h.fvL));
      this.Yfb.setOnSwitchPanelListener(this.YhW);
      this.Yfb.setChattingContext(this.YhX);
      this.Yfb.setPortHeighPx(KeyBoardUtil.getValidPanelHeight(getContext()));
      if ((!ab.IV(str)) && (!au.bws(str))) {
        break label124;
      }
      this.Yfb.sE(0);
    }
    for (;;)
    {
      this.Yfh = ((TextView)findViewById(R.h.fvM));
      AppMethodBeat.o(31594);
      return;
      str = this.Ygv.getTalkerUserName();
      break;
      label124:
      if (ab.IS(str)) {
        this.Yfb.sE(4);
      } else if (au.bwE(str)) {
        this.Yfb.sE(2);
      } else {
        this.Yfb.sE(1);
      }
    }
  }
  
  private void iMf()
  {
    AppMethodBeat.i(185399);
    this.Yid.start();
    this.Yie.start();
    this.Yif.start();
    this.Yig.start();
    this.Yih.start();
    this.YhN.animate().alpha(1.0F).setDuration(200L).start();
    this.YhO.animate().alpha(1.0F).setDuration(200L).start();
    this.Yhx.animate().alpha(1.0F).translationY(0.0F).setDuration(300L).start();
    iMT();
    AppMethodBeat.o(185399);
  }
  
  private void iMg()
  {
    AppMethodBeat.i(31617);
    if (this.YfQ)
    {
      this.AhM.setVisibility(8);
      this.AhN.setVisibility(8);
      this.SOq.setVisibility(8);
      this.AhK.setVisibility(8);
      this.YgD.setVisibility(0);
      this.YgG.setVisibility(0);
      this.YgH.setVisibility(0);
      this.YgJ.setVisibility(8);
      this.YgK.setVisibility(0);
      this.YgL.setVisibility(8);
      this.YgN.setVisibility(8);
      this.YgO.setVisibility(8);
      this.YgR.setVisibility(8);
      this.Yhd = k.YjJ;
      this.Yhb = ChatFooter.l.YjN;
      AppMethodBeat.o(31617);
      return;
    }
    this.AhM.setVisibility(0);
    this.AhN.setVisibility(8);
    this.SOq.setVisibility(8);
    this.AhK.setVisibility(8);
    this.YgD.setVisibility(8);
    AppMethodBeat.o(31617);
  }
  
  private void iMw()
  {
    AppMethodBeat.i(31640);
    this.hDw.findViewById(R.h.fAa).setVisibility(0);
    AppMethodBeat.o(31640);
  }
  
  private void iMx()
  {
    AppMethodBeat.i(31641);
    Log.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
    this.YfS = false;
    this.Rqt.setImeOptions(0);
    this.Rqt.setInputType(this.Rqt.getInputType() | 0x40);
    AppMethodBeat.o(31641);
  }
  
  private void iNa()
  {
    AppMethodBeat.i(185412);
    int j = com.tencent.mm.ui.bd.fromDPToPix(getContext(), 20);
    if ((this.Yhm.getText() != null) && (this.Yhm.getText().length() > 0)) {}
    for (int i = this.Yhm.getText().length();; i = 0)
    {
      this.Yhm.setSelection(i);
      this.Yhm.setPadding(j, j, j, j);
      this.Yhx.setVisibility(8);
      this.Yhv.setVisibility(8);
      this.YhM.setVisibility(4);
      this.YhE.setVisibility(0);
      this.Yhr.setVisibility(0);
      com.tencent.mm.cj.a.a locala = com.tencent.mm.cj.a.adtq;
      com.tencent.mm.cj.a.jhm();
      this.Yhq.setVisibility(8);
      this.Yhn.setVisibility(8);
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
  
  private void setDelaySendAnim(boolean paramBoolean)
  {
    AppMethodBeat.i(245452);
    com.tencent.mm.ui.widget.cedit.api.c localc = this.Rqt;
    int i = R.h.fzt;
    if (paramBoolean) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = null)
    {
      localc.setTag(i, localBoolean);
      AppMethodBeat.o(245452);
      return;
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
    switch (92.Yjm[this.YiU.ordinal()])
    {
    }
    for (;;)
    {
      this.Yiv = paramInt;
      AppMethodBeat.o(185400);
      return;
      int i = 60 - paramInt;
      int j = (int)(this.Yiq * i);
      this.Yiu = Math.min(this.Yip + j, this.Yio);
      Log.d("MicroMsg.ChatFooter", "voiceWidth:%s, duration:%s, offset:%s", new Object[] { Integer.valueOf(this.Yiu), Integer.valueOf(i), Integer.valueOf(j) });
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.Yhl.getWidth(), this.Yiu }).setDuration(200L);
      localValueAnimator.addUpdateListener(new ChatFooter.83(this));
      localValueAnimator.start();
      if (paramInt < 10)
      {
        iMU();
        continue;
        if (paramInt < 10) {
          iMV();
        }
      }
    }
  }
  
  private void t(int paramInt1, boolean paramBoolean, final int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(163218);
    Log.i("MicroMsg.ChatFooter", "switchPanel: %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    if (this.Ygk)
    {
      AppMethodBeat.o(163218);
      return;
    }
    if ((paramInt1 != 0) && (z.bBK().booleanValue()) && (this.Ygs != null))
    {
      this.Ygs.a(Boolean.TRUE, Boolean.FALSE);
      this.Ygs.b(Boolean.TRUE, Boolean.FALSE);
    }
    awI(paramInt1);
    if (this.Yff != null) {
      this.Yff.setVisibility(0);
    }
    this.Yfp.setVisibility(8);
    switch (paramInt1)
    {
    default: 
      if (((this.mjd != 0) || (paramInt1 != 1)) && ((this.mjd != 1) || (paramInt1 != 0))) {
        break;
      }
    }
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      bw(this.mjd, paramInt1, paramInt2);
      int i;
      label211:
      Object localObject;
      label237:
      int k;
      if (this.mjd != paramInt1)
      {
        i = 1;
        this.mjd = paramInt1;
        if (this.mjd != 2) {
          break label632;
        }
        Kc(true);
        localObject = com.tencent.mm.emoji.d.b.mmj;
        com.tencent.mm.emoji.d.b.aVZ();
        k = this.Yga;
        if (this.Ygm != null) {
          break label648;
        }
      }
      label648:
      for (paramInt1 = j;; paramInt1 = this.Ygm.fJG())
      {
        c(k, paramBoolean, paramInt2, paramInt1);
        if (i != 0) {
          com.tencent.threadpool.h.ahAA.p(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(245317);
              if ((ChatFooter.p(ChatFooter.this) != null) && (ChatFooter.p(ChatFooter.this).iNh() != null))
              {
                com.tencent.mm.ui.chatting.component.api.bf localbf = (com.tencent.mm.ui.chatting.component.api.bf)ChatFooter.p(ChatFooter.this).iNh().cm(com.tencent.mm.ui.chatting.component.api.bf.class);
                if (localbf != null) {
                  localbf.jux();
                }
              }
              AppMethodBeat.o(245317);
            }
          }, 300L);
        }
        if (this.YfC != null) {
          this.YfC.nM(this.mjd, this.Yga);
        }
        if ((this.Ygv != null) && (this.Ygv.iNh() != null) && (this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.j.class) != null)) {
          ((com.tencent.mm.ui.chatting.component.api.j)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.j.class)).cG(this.mjd, this.Yae);
        }
        AppMethodBeat.o(163218);
        return;
        if ((!this.YfV) || (this.Ygb)) {}
        for (this.Yga = 0;; this.Yga = this.sNb)
        {
          e(false, null);
          a(false, null, -1);
          localObject = com.tencent.mm.plugin.hld.f.l.JyV;
          if (!com.tencent.mm.plugin.hld.f.l.fPj()) {
            break;
          }
          this.Yfp.setVisibility(0);
          localObject = com.tencent.mm.plugin.hld.f.l.JyV;
          com.tencent.mm.plugin.hld.f.l.fPk().putInt("ime_old_user_guide_show", 2);
          break;
        }
        this.Yga = this.Ygi;
        this.Yfg.setVisibility(0);
        a(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(245316);
            ChatFooter.bA(ChatFooter.this);
            AppMethodBeat.o(245316);
          }
        }, -1);
        break;
        this.Yga = this.Ygh;
        this.Yfg.setVisibility(0);
        e(false, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(245319);
            ChatFooter.i(ChatFooter.this, paramInt2);
            AppMethodBeat.o(245319);
          }
        });
        this.Yfx.iNm();
        JX(false);
        if (this.YfP != 2) {
          break;
        }
        awF(1);
        break;
        this.Yga = 0;
        e(false, null);
        a(false, null, -1);
        iKM();
        iME();
        break;
        if (this.Yff != null) {
          this.Yff.setVisibility(4);
        }
        this.Yga = this.Ygj;
        e(false, null);
        a(false, null, -1);
        break;
        i = 0;
        break label211;
        label632:
        Kc(false);
        localObject = com.tencent.mm.emoji.d.b.mmj;
        com.tencent.mm.emoji.d.b.aWa();
        break label237;
      }
    }
  }
  
  private void yk(boolean paramBoolean)
  {
    AppMethodBeat.i(31584);
    this.miH = paramBoolean;
    if (this.Ygw == null)
    {
      this.Ygw = AnimationUtils.loadAnimation(getContext(), R.a.pop_in);
      this.Ygw.setDuration(150L);
    }
    if (this.Ygx == null)
    {
      this.Ygx = AnimationUtils.loadAnimation(getContext(), R.a.pop_out);
      this.Ygx.setDuration(150L);
    }
    if ((this.mkz == null) || (this.Yfi == null))
    {
      Log.i("MicroMsg.ChatFooter", "canSend:%B, return sendBtn == null || mAttachButton == null", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31584);
      return;
    }
    if (this.Ygu)
    {
      if (this.Yfi.getVisibility() != 0) {
        this.Yfi.setVisibility(0);
      }
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.mkz.getVisibility() == 0) && (paramBoolean))
    {
      Log.i("MicroMsg.ChatFooter", "canSend true ! sendBtn is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if ((this.Yfi.getVisibility() == 0) && (!paramBoolean))
    {
      Log.i("MicroMsg.ChatFooter", "canSend false ! AttachButton is visible");
      AppMethodBeat.o(31584);
      return;
    }
    if (paramBoolean)
    {
      iML();
      this.Yfi.startAnimation(this.Ygx);
      this.Yfi.setVisibility(8);
      Kd(false);
    }
    for (;;)
    {
      Log.i("MicroMsg.ChatFooter", "jacks canSend:".concat(String.valueOf(paramBoolean)));
      this.mkz.getParent().requestLayout();
      AppMethodBeat.o(31584);
      return;
      this.Yfi.startAnimation(this.Ygw);
      if ((!this.YfF) && (!this.YfU))
      {
        this.Yfi.setVisibility(0);
        Kd(true);
      }
      iMK();
    }
  }
  
  public final void F(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(31607);
    if (fJE())
    {
      Log.i("MicroMsg.ChatFooter", "setLastText() isBackFromGroupSolitatire");
      AppMethodBeat.o(31607);
      return;
    }
    if ((paramBoolean) && ((paramString == null) || (paramString.length() == 0) || (this.Rqt == null)))
    {
      this.Rqt.setText("");
      iLW();
      AppMethodBeat.o(31607);
      return;
    }
    this.YfE = true;
    this.Rqt.setText(p.b(getContext(), paramString, this.Rqt.getTextSize()));
    this.YfE = false;
    if ((paramInt < 0) || (paramInt > this.Rqt.getText().length()))
    {
      this.Rqt.setSelection(this.Rqt.getText().length());
      AppMethodBeat.o(31607);
      return;
    }
    this.Rqt.setSelection(paramInt);
    AppMethodBeat.o(31607);
  }
  
  public final void JN(boolean paramBoolean)
  {
    AppMethodBeat.i(31633);
    this.Yfb.JN(paramBoolean);
    AppMethodBeat.o(31633);
  }
  
  public final void JO(boolean paramBoolean)
  {
    AppMethodBeat.i(31634);
    this.Yfb.JO(paramBoolean);
    AppMethodBeat.o(31634);
  }
  
  public final void JY(boolean paramBoolean)
  {
    AppMethodBeat.i(31588);
    Log.i("MicroMsg.ChatFooter", "pureForcusEdtChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.Rqt });
    if (this.Rqt == null)
    {
      AppMethodBeat.o(31588);
      return;
    }
    if (paramBoolean)
    {
      this.Rqt.jEJ();
      AppMethodBeat.o(31588);
      return;
    }
    this.Rqt.clearFocus();
    AppMethodBeat.o(31588);
  }
  
  public final void Ka(boolean paramBoolean)
  {
    AppMethodBeat.i(31654);
    Log.i("MicroMsg.ChatFooter", "withoutLastText: ");
    hideVKB();
    iMb();
    JY(paramBoolean);
    AppMethodBeat.o(31654);
  }
  
  public final void Kb(boolean paramBoolean)
  {
    AppMethodBeat.i(369601);
    s(0, paramBoolean, -1);
    AppMethodBeat.o(369601);
  }
  
  public final void Kd(boolean paramBoolean)
  {
    AppMethodBeat.i(163220);
    if (this.Yfi == null)
    {
      Log.e("MicroMsg.ChatFooter", "mAttachButton is null");
      AppMethodBeat.o(163220);
      return;
    }
    if (this.Yfj != null) {
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
        } while ((locala.red_dot != 1) || (bri(locala.YeJ)));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.Yfj.setVisibility(0);
        AppMethodBeat.o(163220);
        return;
      }
      this.Yfj.setVisibility(8);
      AppMethodBeat.o(163220);
      return;
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean1, com.tencent.mm.modelvoiceaddr.h paramh, boolean paramBoolean2)
  {
    AppMethodBeat.i(185826);
    Log.d("MicroMsg.ChatFooter", "startTrans, hasStartTrans: %s, isForce: %s.", new Object[] { Boolean.valueOf(this.YiX), Boolean.valueOf(paramBoolean2) });
    this.Yhm.setImportantForAccessibility(2);
    if (paramBoolean2) {
      if (this.YiX)
      {
        if (this.TVW != null) {
          this.TVW.bj(false, true);
        }
        this.TWg.removeMessages(5000);
        this.TWd.stopTimer();
      }
    }
    while (!this.YiX)
    {
      this.YiX = true;
      this.TVW = new com.tencent.mm.plugin.transvoice.model.b(paramh, paramInt, new g.b()
      {
        public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(245410);
          Log.d("MicroMsg.ChatFooter", "newVoice2txt onRes, %s.", new Object[] { ChatFooter.this.TVW });
          ChatFooter.bJ(ChatFooter.this).clear();
          if (!Util.isNullOrNil(paramAnonymousList)) {
            ChatFooter.bJ(ChatFooter.this).addAll(paramAnonymousList);
          }
          if (!ChatFooter.ba(ChatFooter.this))
          {
            ChatFooter.i(ChatFooter.this, true);
            ChatFooter.aJ(ChatFooter.this).setFocusable(true);
            ChatFooter.aJ(ChatFooter.this).setFocusableInTouchMode(true);
          }
          if ((ChatFooter.this.TVW != null) && (!ChatFooter.this.TVW.TTW))
          {
            ChatFooter.bK(ChatFooter.this).removeMessages(5000);
            ChatFooter.bK(ChatFooter.this).sendEmptyMessageDelayed(5000, 5000L);
          }
          if (!Util.isNullOrNil(paramAnonymousArrayOfString[0]))
          {
            ChatFooter.aU(ChatFooter.this).put(Integer.valueOf(ChatFooter.aT(ChatFooter.this)), paramAnonymousArrayOfString[0]);
            if (ChatFooter.aU(ChatFooter.this) != null) {
              ChatFooter.L(ChatFooter.this).TUn = paramAnonymousArrayOfString[0].length();
            }
            Log.d("MicroMsg.ChatFooter", "newVoice2txt onRes, curTxt: %s.", new Object[] { paramAnonymousArrayOfString[0] });
          }
          AppMethodBeat.o(245410);
        }
        
        public final void bPD()
        {
          AppMethodBeat.i(245427);
          ChatFooter.aJ(ChatFooter.this).setImportantForAccessibility(0);
          if ((ChatFooter.this.TVW != null) && (!ChatFooter.this.TVW.TTW))
          {
            Log.d("MicroMsg.ChatFooter", "onRecognizeFinish, %s.", new Object[] { Boolean.valueOf(ChatFooter.this.TVW.TTW) });
            ChatFooter.L(ChatFooter.this).TUq = 1;
            ChatFooter.L(ChatFooter.this).TUm = System.currentTimeMillis();
            ChatFooter.aJ(ChatFooter.this).requestFocus();
            ChatFooter.i(ChatFooter.this, false);
            ChatFooter.bc(ChatFooter.this);
            ChatFooter.this.TVW = null;
            ChatFooter.bK(ChatFooter.this).removeMessages(5000);
            ChatFooter.bb(ChatFooter.this).stopTimer();
            ChatFooter.aV(ChatFooter.this);
          }
          AppMethodBeat.o(245427);
        }
        
        public final void bPz()
        {
          AppMethodBeat.i(245423);
          Log.d("MicroMsg.ChatFooter", "onRecordFin.");
          AppMethodBeat.o(245423);
        }
        
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
        {
          AppMethodBeat.i(245419);
          Log.d("MicroMsg.ChatFooter", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong) });
          ChatFooter.L(ChatFooter.this).TUq = 0;
          ChatFooter.L(ChatFooter.this).TUm = System.currentTimeMillis();
          ChatFooter.bc(ChatFooter.this);
          ChatFooter.aJ(ChatFooter.this).setImportantForAccessibility(0);
          AppMethodBeat.o(245419);
        }
      });
      this.TVW.TTW = paramBoolean1;
      this.TVW.start();
      this.TWd.startTimer(500L);
      AppMethodBeat.o(185826);
      return;
    }
    AppMethodBeat.o(185826);
  }
  
  public final void a(Context paramContext, Activity paramActivity)
  {
    AppMethodBeat.i(31575);
    Log.i("MicroMsg.ChatFooter", "onResume: %s, %s", new Object[] { Boolean.valueOf(KeyBoardUtil.isPortOrientation(paramContext)), Integer.valueOf(getContext().getResources().getConfiguration().orientation) });
    this.cqi = true;
    this.activity = paramActivity;
    if ((this.YfZ == 48) && (this.mjd == 1) && (!this.Ygk))
    {
      this.HDO = false;
      t(0, false, -1);
    }
    boolean bool;
    if ((getContext().getResources().getConfiguration().orientation == 1) || (KeyBoardUtil.isPortOrientation(paramContext)))
    {
      bool = true;
      this.YfV = bool;
      if (com.tencent.mm.compatible.util.d.rb(24)) {
        this.Ygb = ((Activity)getContext()).isInMultiWindowMode();
      }
      iMD();
      iMI();
      if (com.tencent.mm.pluginsdk.model.app.at.iIM().XTJ) {
        com.tencent.mm.pluginsdk.model.app.at.iIM().lu(MMApplicationContext.getContext());
      }
      if (this.moD != null)
      {
        if (!this.Yfg.iNi()) {
          this.moD.onResume();
        }
        this.moD.setShowSearch(true);
      }
      if ((this.Ygu) || (!this.YfS)) {
        break label340;
      }
      iMx();
    }
    for (;;)
    {
      awJ(getKeyBordHeightPX());
      if (this.Yfb != null) {
        this.Yfb.context = paramContext;
      }
      this.Yfx.Ykm = false;
      if (!this.Yae) {
        iMw();
      }
      iMa();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185798);
          com.tencent.mm.compatible.util.j.w(ChatFooter.e(ChatFooter.this));
          AppMethodBeat.o(185798);
        }
      });
      if ((this.YfX != null) && (this.Ygv != null)) {
        this.YfX.a((ChattingScrollLayout.a)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.u.class));
      }
      this.lAx.alive();
      AppMethodBeat.o(31575);
      return;
      bool = false;
      break;
      label340:
      if ((this.Ygu) && (!this.YfS)) {
        iMv();
      }
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(31574);
    this.Ygv = paramb;
    this.Yfz = new com.tencent.mm.plugin.groupsolitaire.ui.d(getContext(), this.Ygv.iNg(), new d.d()
    {
      public final void aHY(String paramAnonymousString)
      {
        AppMethodBeat.i(245380);
        if ((ChatFooter.k(ChatFooter.this) != null) && (!Util.isNullOrNil(paramAnonymousString))) {
          ChatFooter.k(ChatFooter.this).aHY(paramAnonymousString);
        }
        AppMethodBeat.o(245380);
      }
      
      public final void fJI()
      {
        AppMethodBeat.i(245377);
        ChatFooter.this.fJI();
        ChatFooter.this.iLY();
        AppMethodBeat.o(245377);
      }
    });
    this.Yfz.JkB = this.Ygq;
    paramb = (com.tencent.mm.ui.chatting.component.api.m)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.m.class);
    paramb.aZ(this.YgB);
    this.Rqt.getSizeAnimController().a(paramb);
    if ((this.Ygv != null) && (this.Ygv.iNh() != null)) {
      ((com.tencent.mm.ui.chatting.component.api.bd)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.bd.class)).getSizeAnimController().adMC = paramb;
    }
    AppMethodBeat.o(31574);
  }
  
  public final void a(final h paramh)
  {
    AppMethodBeat.i(185822);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245331);
        ChatFooter.J(ChatFooter.this).setBackgroundResource(R.g.input_bg);
        ChatFooter.J(ChatFooter.this).setText(R.l.chatfooter_presstorcd);
        if (ChatFooter.this.Yhg)
        {
          switch (ChatFooter.92.Yjn[paramh.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(245331);
            return;
            if (ChatFooter.O(ChatFooter.this) != null) {
              ChatFooter.T(ChatFooter.this);
            }
          }
        }
        if (ChatFooter.U(ChatFooter.this) != null)
        {
          ChatFooter.U(ChatFooter.this).dismiss();
          if (ChatFooter.V(ChatFooter.this) != null) {
            ChatFooter.V(ChatFooter.this).getContentView().animate().alpha(0.0F).setDuration(300L).withEndAction(ChatFooter.bq(ChatFooter.this)).start();
          }
          ChatFooter.br(ChatFooter.this).setVisibility(0);
          ChatFooter.bs(ChatFooter.this).setVisibility(8);
          ChatFooter.bt(ChatFooter.this).setVisibility(8);
          ChatFooter.aA(ChatFooter.this).setVisibility(8);
          ChatFooter.ag(ChatFooter.this).setVisibility(8);
          ChatFooter.az(ChatFooter.this).setVisibility(0);
        }
        ChatFooter.h(ChatFooter.this, false);
        ChatFooter.g(ChatFooter.this, false);
        AppMethodBeat.o(245331);
      }
    });
    AppMethodBeat.o(185822);
  }
  
  public final void a(cry paramcry) {}
  
  public final void a(String paramString, Boolean paramBoolean, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(245942);
    if (paramBoolean.booleanValue()) {
      a.b.h(this.YfK, paramString);
    }
    for (;;)
    {
      setHint(paramCharSequence);
      this.YfK.setVisibility(0);
      AppMethodBeat.o(245942);
      return;
      a.b.g(this.YfK, paramString);
    }
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(31615);
    this.YhY = new i(paramTextWatcher);
    this.Rqt.addTextChangedListener(this.YhY);
    AppMethodBeat.o(31615);
  }
  
  /* Error */
  public final void awD(int paramInt)
  {
    // Byte code:
    //   0: sipush 31616
    //   3: invokestatic 549	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 758	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhg	Z
    //   10: ifeq +1772 -> 1782
    //   13: aload_0
    //   14: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   17: ifnonnull +983 -> 1000
    //   20: aload_0
    //   21: new 1984	com/tencent/mm/ui/base/v
    //   24: dup
    //   25: aload_0
    //   26: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   29: getstatic 3955	com/tencent/mm/R$i:fQN	I
    //   32: aconst_null
    //   33: invokestatic 3956	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   36: iconst_m1
    //   37: iconst_m1
    //   38: iconst_1
    //   39: invokespecial 3959	com/tencent/mm/ui/base/v:<init>	(Landroid/view/View;IIZ)V
    //   42: putfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   45: aload_0
    //   46: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   49: bipush 16
    //   51: invokevirtual 3960	com/tencent/mm/ui/base/v:setSoftInputMode	(I)V
    //   54: aload_0
    //   55: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   58: new 76	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$40
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 3961	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$40:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   66: invokevirtual 3965	com/tencent/mm/ui/base/v:setOnDismissListener	(Landroid/widget/PopupWindow$OnDismissListener;)V
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   74: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   77: getstatic 3969	com/tencent/mm/R$h:fQR	I
    //   80: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   83: putfield 2485	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhj	Landroid/view/View;
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   91: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   94: getstatic 3972	com/tencent/mm/R$h:fRe	I
    //   97: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   100: putfield 2482	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhk	Landroid/view/View;
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   108: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   111: getstatic 3973	com/tencent/mm/R$h:fQN	I
    //   114: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   117: checkcast 1237	android/view/ViewGroup
    //   120: putfield 1913	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhl	Landroid/view/ViewGroup;
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   128: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   131: getstatic 3976	com/tencent/mm/R$h:fQT	I
    //   134: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   137: checkcast 1929	com/tencent/mm/plugin/transvoice/ui/SoundWaveView
    //   140: putfield 1927	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhn	Lcom/tencent/mm/plugin/transvoice/ui/SoundWaveView;
    //   143: aload_0
    //   144: aload_0
    //   145: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   148: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   151: getstatic 3979	com/tencent/mm/R$h:fQL	I
    //   154: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   157: checkcast 1891	android/widget/EditText
    //   160: putfield 1889	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhm	Landroid/widget/EditText;
    //   163: aload_0
    //   164: aload_0
    //   165: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   168: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   171: getstatic 3982	com/tencent/mm/R$h:fQK	I
    //   174: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   177: checkcast 1256	android/widget/ImageView
    //   180: putfield 1894	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yho	Landroid/widget/ImageView;
    //   183: aload_0
    //   184: aload_0
    //   185: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   188: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   191: getstatic 3985	com/tencent/mm/R$h:fQS	I
    //   194: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   197: checkcast 1237	android/view/ViewGroup
    //   200: putfield 3987	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhp	Landroid/view/ViewGroup;
    //   203: aload_0
    //   204: aload_0
    //   205: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   208: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   211: getstatic 3990	com/tencent/mm/R$h:fQJ	I
    //   214: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   217: checkcast 1280	android/widget/TextView
    //   220: putfield 1932	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhq	Landroid/widget/TextView;
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   228: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   231: getstatic 3993	com/tencent/mm/R$h:fQO	I
    //   234: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   237: checkcast 1312	com/tencent/mm/ui/widget/imageview/WeImageView
    //   240: putfield 2554	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhr	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   243: aload_0
    //   244: aload_0
    //   245: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   248: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   251: getstatic 3996	com/tencent/mm/R$h:fQY	I
    //   254: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   257: checkcast 2467	com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout
    //   260: putfield 2465	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhs	Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout;
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   268: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   271: getstatic 3999	com/tencent/mm/R$h:fQP	I
    //   274: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   277: checkcast 1280	android/widget/TextView
    //   280: putfield 1887	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yht	Landroid/widget/TextView;
    //   283: aload_0
    //   284: aload_0
    //   285: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   288: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   291: getstatic 4002	com/tencent/mm/R$h:fQU	I
    //   294: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   297: checkcast 1237	android/view/ViewGroup
    //   300: putfield 1934	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhu	Landroid/view/ViewGroup;
    //   303: aload_0
    //   304: aload_0
    //   305: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   308: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   311: getstatic 4005	com/tencent/mm/R$h:fQM	I
    //   314: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   317: checkcast 1280	android/widget/TextView
    //   320: putfield 1884	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhv	Landroid/widget/TextView;
    //   323: aload_0
    //   324: getfield 2465	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhs	Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout;
    //   327: new 78	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$41
    //   330: dup
    //   331: aload_0
    //   332: invokespecial 4006	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$41:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   335: invokevirtual 4010	com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout:setSelectLanguageListener	(Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$a;)V
    //   338: aload_0
    //   339: getfield 2554	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhr	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   342: new 80	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$42
    //   345: dup
    //   346: aload_0
    //   347: invokespecial 4011	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$42:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   350: invokevirtual 1561	com/tencent/mm/ui/widget/imageview/WeImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   353: aload_0
    //   354: getfield 1889	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhm	Landroid/widget/EditText;
    //   357: ldc_w 4012
    //   360: invokevirtual 4015	android/widget/EditText:setMaxLines	(I)V
    //   363: aload_0
    //   364: getfield 1889	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhm	Landroid/widget/EditText;
    //   367: iconst_0
    //   368: invokevirtual 4018	android/widget/EditText:setHorizontallyScrolling	(Z)V
    //   371: aload_0
    //   372: getfield 1889	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhm	Landroid/widget/EditText;
    //   375: new 82	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$43
    //   378: dup
    //   379: aload_0
    //   380: invokespecial 4019	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$43:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   383: invokevirtual 4023	android/widget/EditText:setOnEditorActionListener	(Landroid/widget/TextView$OnEditorActionListener;)V
    //   386: aload_0
    //   387: new 86	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$45
    //   390: dup
    //   391: aload_0
    //   392: invokespecial 4024	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$45:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   395: invokevirtual 3887	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:post	(Ljava/lang/Runnable;)Z
    //   398: pop
    //   399: aload_0
    //   400: getfield 1889	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhm	Landroid/widget/EditText;
    //   403: new 88	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$46
    //   406: dup
    //   407: aload_0
    //   408: invokespecial 4025	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$46:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   411: invokevirtual 4026	android/widget/EditText:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   414: aload_0
    //   415: aload_0
    //   416: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   419: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   422: getstatic 4029	com/tencent/mm/R$h:fQQ	I
    //   425: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   428: checkcast 1237	android/view/ViewGroup
    //   431: putfield 2956	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhw	Landroid/view/ViewGroup;
    //   434: aload_0
    //   435: aload_0
    //   436: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   439: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   442: getstatic 4032	com/tencent/mm/R$h:fRh	I
    //   445: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   448: checkcast 1237	android/view/ViewGroup
    //   451: putfield 2461	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhx	Landroid/view/ViewGroup;
    //   454: aload_0
    //   455: aload_0
    //   456: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   459: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   462: getstatic 4035	com/tencent/mm/R$h:fQG	I
    //   465: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   468: putfield 1969	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhy	Landroid/view/View;
    //   471: aload_0
    //   472: aload_0
    //   473: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   476: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   479: getstatic 4038	com/tencent/mm/R$h:fRf	I
    //   482: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   485: putfield 1867	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhz	Landroid/view/View;
    //   488: aload_0
    //   489: aload_0
    //   490: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   493: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   496: getstatic 4041	com/tencent/mm/R$h:fQH	I
    //   499: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   502: checkcast 1312	com/tencent/mm/ui/widget/imageview/WeImageView
    //   505: putfield 1967	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhA	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   508: aload_0
    //   509: aload_0
    //   510: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   513: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   516: getstatic 4044	com/tencent/mm/R$h:fRg	I
    //   519: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   522: checkcast 1312	com/tencent/mm/ui/widget/imageview/WeImageView
    //   525: putfield 1852	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhB	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   528: aload_0
    //   529: aload_0
    //   530: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   533: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   536: getstatic 4047	com/tencent/mm/R$h:fQI	I
    //   539: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   542: putfield 1965	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhC	Landroid/view/View;
    //   545: aload_0
    //   546: aload_0
    //   547: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   550: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   553: getstatic 4050	com/tencent/mm/R$h:fRj	I
    //   556: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   559: putfield 1849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhD	Landroid/view/View;
    //   562: aload_0
    //   563: aload_0
    //   564: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   567: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   570: getstatic 4053	com/tencent/mm/R$h:fRi	I
    //   573: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   576: checkcast 1237	android/view/ViewGroup
    //   579: putfield 2453	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhE	Landroid/view/ViewGroup;
    //   582: aload_0
    //   583: aload_0
    //   584: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   587: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   590: getstatic 4056	com/tencent/mm/R$h:fQW	I
    //   593: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   596: putfield 4058	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhF	Landroid/view/View;
    //   599: aload_0
    //   600: getfield 4058	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhF	Landroid/view/View;
    //   603: new 90	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$47
    //   606: dup
    //   607: aload_0
    //   608: invokespecial 4059	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$47:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   611: invokevirtual 4060	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   614: aload_0
    //   615: aload_0
    //   616: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   619: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   622: getstatic 4063	com/tencent/mm/R$h:fRc	I
    //   625: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   628: putfield 4065	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhG	Landroid/view/View;
    //   631: aload_0
    //   632: getfield 4065	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhG	Landroid/view/View;
    //   635: new 92	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$48
    //   638: dup
    //   639: aload_0
    //   640: invokespecial 4066	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$48:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   643: invokevirtual 4060	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   646: aload_0
    //   647: aload_0
    //   648: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   651: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   654: getstatic 4069	com/tencent/mm/R$h:fQZ	I
    //   657: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   660: putfield 2531	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhJ	Landroid/view/View;
    //   663: aload_0
    //   664: getfield 2531	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhJ	Landroid/view/View;
    //   667: new 94	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$49
    //   670: dup
    //   671: aload_0
    //   672: invokespecial 4070	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$49:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   675: invokevirtual 4060	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   678: aload_0
    //   679: aload_0
    //   680: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   683: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   686: getstatic 4073	com/tencent/mm/R$h:fQX	I
    //   689: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   692: checkcast 1312	com/tencent/mm/ui/widget/imageview/WeImageView
    //   695: putfield 4075	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhH	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   698: aload_0
    //   699: aload_0
    //   700: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   703: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   706: getstatic 4078	com/tencent/mm/R$h:fRd	I
    //   709: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   712: checkcast 1312	com/tencent/mm/ui/widget/imageview/WeImageView
    //   715: putfield 4080	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhI	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   718: aload_0
    //   719: aload_0
    //   720: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   723: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   726: getstatic 4083	com/tencent/mm/R$h:fRb	I
    //   729: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   732: putfield 2456	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhK	Landroid/view/View;
    //   735: aload_0
    //   736: aload_0
    //   737: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   740: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   743: getstatic 4086	com/tencent/mm/R$h:fRa	I
    //   746: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   749: checkcast 1312	com/tencent/mm/ui/widget/imageview/WeImageView
    //   752: putfield 2458	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhL	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   755: aload_0
    //   756: aload_0
    //   757: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   760: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   763: getstatic 4089	com/tencent/mm/R$h:fRk	I
    //   766: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   769: checkcast 1237	android/view/ViewGroup
    //   772: putfield 2463	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhM	Landroid/view/ViewGroup;
    //   775: aload_0
    //   776: aload_0
    //   777: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   780: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   783: getstatic 4092	com/tencent/mm/R$h:fRm	I
    //   786: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   789: putfield 1798	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhN	Landroid/view/View;
    //   792: aload_0
    //   793: aload_0
    //   794: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   797: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   800: getstatic 4095	com/tencent/mm/R$h:fRo	I
    //   803: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   806: putfield 1830	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhO	Landroid/view/View;
    //   809: aload_0
    //   810: aload_0
    //   811: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   814: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   817: getstatic 4098	com/tencent/mm/R$h:fRn	I
    //   820: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   823: putfield 1832	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhP	Landroid/view/View;
    //   826: aload_0
    //   827: aload_0
    //   828: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   831: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   834: getstatic 4101	com/tencent/mm/R$h:fRl	I
    //   837: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   840: checkcast 1312	com/tencent/mm/ui/widget/imageview/WeImageView
    //   843: putfield 2905	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhQ	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   846: aload_0
    //   847: getfield 2463	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhM	Landroid/view/ViewGroup;
    //   850: invokevirtual 1938	android/view/ViewGroup:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   853: checkcast 1940	android/widget/RelativeLayout$LayoutParams
    //   856: astore 4
    //   858: aload 4
    //   860: aload_0
    //   861: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   864: invokevirtual 1749	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   867: getstatic 4104	com/tencent/mm/R$f:fmh	I
    //   870: invokevirtual 2595	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   873: aload_0
    //   874: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   877: invokestatic 4108	com/tencent/mm/ui/bg:bk	(Landroid/content/Context;)I
    //   880: iadd
    //   881: putfield 4109	android/widget/RelativeLayout$LayoutParams:height	I
    //   884: aload_0
    //   885: getfield 2463	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhM	Landroid/view/ViewGroup;
    //   888: aload 4
    //   890: invokevirtual 4110	android/view/ViewGroup:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   893: aload_0
    //   894: getfield 2905	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhQ	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   897: invokevirtual 4111	com/tencent/mm/ui/widget/imageview/WeImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   900: checkcast 2137	android/widget/FrameLayout$LayoutParams
    //   903: astore 4
    //   905: aload 4
    //   907: aload_0
    //   908: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   911: invokestatic 4108	com/tencent/mm/ui/bg:bk	(Landroid/content/Context;)I
    //   914: aload_0
    //   915: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   918: bipush 14
    //   920: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   923: iadd
    //   924: putfield 2172	android/widget/FrameLayout$LayoutParams:bottomMargin	I
    //   927: aload_0
    //   928: getfield 2905	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhQ	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   931: aload 4
    //   933: invokevirtual 4112	com/tencent/mm/ui/widget/imageview/WeImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   936: aload_0
    //   937: new 2489	com/tencent/mm/sdk/platformtools/MTimerHandler
    //   940: dup
    //   941: new 96	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$50
    //   944: dup
    //   945: aload_0
    //   946: invokespecial 4113	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$50:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   949: iconst_1
    //   950: invokespecial 4116	com/tencent/mm/sdk/platformtools/MTimerHandler:<init>	(Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;Z)V
    //   953: putfield 2487	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:TWd	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   956: aload_0
    //   957: new 2496	com/tencent/mm/sdk/platformtools/MMHandler
    //   960: dup
    //   961: new 98	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$51
    //   964: dup
    //   965: aload_0
    //   966: invokespecial 4117	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$51:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   969: invokespecial 4120	com/tencent/mm/sdk/platformtools/MMHandler:<init>	(Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;)V
    //   972: putfield 2494	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:TWg	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   975: aload_0
    //   976: aload_0
    //   977: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   980: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   983: getstatic 4123	com/tencent/mm/R$h:fQV	I
    //   986: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   989: putfield 4125	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhR	Landroid/view/View;
    //   992: aload_0
    //   993: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   996: iconst_0
    //   997: invokevirtual 4128	com/tencent/mm/ui/base/v:setClippingEnabled	(Z)V
    //   1000: aload_0
    //   1001: invokespecial 4130	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getTransLangTypeByTalker	()I
    //   1004: istore_1
    //   1005: getstatic 3271	com/tencent/mm/modelvoiceaddr/g:pfE	I
    //   1008: iload_1
    //   1009: if_icmpne +658 -> 1667
    //   1012: aload_0
    //   1013: getstatic 990	com/tencent/mm/modelvoiceaddr/g:pfF	I
    //   1016: putfield 992	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:TTV	I
    //   1019: aload_0
    //   1020: getfield 2465	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhs	Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout;
    //   1023: ifnull +14 -> 1037
    //   1026: aload_0
    //   1027: getfield 2465	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhs	Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout;
    //   1030: aload_0
    //   1031: getfield 992	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:TTV	I
    //   1034: invokevirtual 4133	com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout:setSelectedLang	(I)V
    //   1037: ldc_w 1378
    //   1040: ldc_w 4135
    //   1043: iconst_1
    //   1044: anewarray 1382	java/lang/Object
    //   1047: dup
    //   1048: iconst_0
    //   1049: aload_0
    //   1050: getfield 965	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YiW	Ljava/util/Map;
    //   1053: invokeinterface 4136 1 0
    //   1058: invokestatic 1391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1061: aastore
    //   1062: invokestatic 1396	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1065: invokestatic 3693	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   1068: invokevirtual 3699	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   1071: getstatic 4139	com/tencent/mm/storage/at$a:adfQ	Lcom/tencent/mm/storage/at$a;
    //   1074: iconst_1
    //   1075: invokevirtual 3710	com/tencent/mm/storage/aq:getBoolean	(Lcom/tencent/mm/storage/at$a;Z)Z
    //   1078: ifne +597 -> 1675
    //   1081: invokestatic 3693	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   1084: invokevirtual 3699	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   1087: getstatic 4142	com/tencent/mm/storage/at$a:adfR	Lcom/tencent/mm/storage/at$a;
    //   1090: iconst_1
    //   1091: invokevirtual 3710	com/tencent/mm/storage/aq:getBoolean	(Lcom/tencent/mm/storage/at$a;Z)Z
    //   1094: ifeq +581 -> 1675
    //   1097: aload_0
    //   1098: getfield 1884	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhv	Landroid/widget/TextView;
    //   1101: aload_0
    //   1102: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1105: bipush 12
    //   1107: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1110: i2f
    //   1111: invokevirtual 4143	android/widget/TextView:setTranslationY	(F)V
    //   1114: aload_0
    //   1115: getfield 1884	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhv	Landroid/widget/TextView;
    //   1118: iconst_0
    //   1119: invokevirtual 1885	android/widget/TextView:setVisibility	(I)V
    //   1122: aload_0
    //   1123: getfield 1884	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhv	Landroid/widget/TextView;
    //   1126: fconst_0
    //   1127: invokevirtual 4144	android/widget/TextView:setAlpha	(F)V
    //   1130: aload_0
    //   1131: getfield 1884	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhv	Landroid/widget/TextView;
    //   1134: aload_0
    //   1135: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1138: invokevirtual 1749	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1141: getstatic 4147	com/tencent/mm/R$l:gOJ	I
    //   1144: invokevirtual 1768	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1147: invokevirtual 2153	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1150: aload_0
    //   1151: getfield 1884	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhv	Landroid/widget/TextView;
    //   1154: invokevirtual 4148	android/widget/TextView:animate	()Landroid/view/ViewPropertyAnimator;
    //   1157: fconst_1
    //   1158: invokevirtual 1811	android/view/ViewPropertyAnimator:alpha	(F)Landroid/view/ViewPropertyAnimator;
    //   1161: fconst_0
    //   1162: invokevirtual 1808	android/view/ViewPropertyAnimator:translationY	(F)Landroid/view/ViewPropertyAnimator;
    //   1165: ldc2_w 4149
    //   1168: invokevirtual 1816	android/view/ViewPropertyAnimator:setDuration	(J)Landroid/view/ViewPropertyAnimator;
    //   1171: ldc2_w 3841
    //   1174: invokevirtual 4153	android/view/ViewPropertyAnimator:setStartDelay	(J)Landroid/view/ViewPropertyAnimator;
    //   1177: invokevirtual 1828	android/view/ViewPropertyAnimator:start	()V
    //   1180: aload_0
    //   1181: getfield 1913	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhl	Landroid/view/ViewGroup;
    //   1184: fconst_0
    //   1185: invokevirtual 3428	android/view/ViewGroup:setTranslationY	(F)V
    //   1188: aload_0
    //   1189: getfield 1894	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yho	Landroid/widget/ImageView;
    //   1192: fconst_0
    //   1193: invokevirtual 3431	android/widget/ImageView:setTranslationY	(F)V
    //   1196: aload_0
    //   1197: getfield 2554	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhr	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   1200: fconst_0
    //   1201: invokevirtual 4154	com/tencent/mm/ui/widget/imageview/WeImageView:setTranslationY	(F)V
    //   1204: aload_0
    //   1205: getfield 2956	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhw	Landroid/view/ViewGroup;
    //   1208: fconst_0
    //   1209: invokevirtual 3428	android/view/ViewGroup:setTranslationY	(F)V
    //   1212: aload_0
    //   1213: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1216: bipush 20
    //   1218: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1221: istore_1
    //   1222: aload_0
    //   1223: getfield 1889	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhm	Landroid/widget/EditText;
    //   1226: iload_1
    //   1227: iload_1
    //   1228: iload_1
    //   1229: iconst_0
    //   1230: invokevirtual 3538	android/widget/EditText:setPadding	(IIII)V
    //   1233: aload_0
    //   1234: getfield 1889	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhm	Landroid/widget/EditText;
    //   1237: aload_0
    //   1238: getfield 784	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yic	Landroid/text/TextWatcher;
    //   1241: invokevirtual 4155	android/widget/EditText:addTextChangedListener	(Landroid/text/TextWatcher;)V
    //   1244: aload_0
    //   1245: getfield 1889	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhm	Landroid/widget/EditText;
    //   1248: bipush 8
    //   1250: invokevirtual 1892	android/widget/EditText:setVisibility	(I)V
    //   1253: aload_0
    //   1254: getfield 1889	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhm	Landroid/widget/EditText;
    //   1257: iconst_0
    //   1258: invokevirtual 4158	android/widget/EditText:setCursorVisible	(Z)V
    //   1261: aload_0
    //   1262: getfield 1927	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhn	Lcom/tencent/mm/plugin/transvoice/ui/SoundWaveView;
    //   1265: iconst_0
    //   1266: invokevirtual 1930	com/tencent/mm/plugin/transvoice/ui/SoundWaveView:setVisibility	(I)V
    //   1269: aload_0
    //   1270: getfield 1887	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yht	Landroid/widget/TextView;
    //   1273: bipush 8
    //   1275: invokevirtual 1885	android/widget/TextView:setVisibility	(I)V
    //   1278: aload_0
    //   1279: getfield 2531	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhJ	Landroid/view/View;
    //   1282: iconst_1
    //   1283: invokevirtual 2534	android/view/View:setEnabled	(Z)V
    //   1286: aload_0
    //   1287: getfield 1913	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhl	Landroid/view/ViewGroup;
    //   1290: iconst_1
    //   1291: invokevirtual 1916	android/view/ViewGroup:setActivated	(Z)V
    //   1294: aload_0
    //   1295: getfield 2458	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhL	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   1298: aload_0
    //   1299: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1302: getstatic 2537	com/tencent/mm/R$k:icons_filled_done	I
    //   1305: aload_0
    //   1306: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1309: invokevirtual 1749	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1312: getstatic 2540	com/tencent/mm/R$e:Brand	I
    //   1315: invokevirtual 1862	android/content/res/Resources:getColor	(I)I
    //   1318: invokestatic 1906	com/tencent/mm/ui/bb:m	(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;
    //   1321: invokevirtual 2541	com/tencent/mm/ui/widget/imageview/WeImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1324: aload_0
    //   1325: getfield 1894	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yho	Landroid/widget/ImageView;
    //   1328: aload_0
    //   1329: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1332: getstatic 1897	com/tencent/mm/R$k:icons_filled_voice2txt_cursor	I
    //   1335: aload_0
    //   1336: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1339: invokevirtual 1749	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1342: getstatic 1900	com/tencent/mm/R$e:LightGreen	I
    //   1345: invokevirtual 1862	android/content/res/Resources:getColor	(I)I
    //   1348: invokestatic 1906	com/tencent/mm/ui/bb:m	(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;
    //   1351: invokevirtual 1907	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1354: aload_0
    //   1355: getfield 1798	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhN	Landroid/view/View;
    //   1358: invokevirtual 4159	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1361: checkcast 2137	android/widget/FrameLayout$LayoutParams
    //   1364: astore 4
    //   1366: aload 4
    //   1368: aload_0
    //   1369: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1372: sipush 250
    //   1375: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1378: putfield 4162	android/widget/FrameLayout$LayoutParams:width	I
    //   1381: aload 4
    //   1383: aload_0
    //   1384: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1387: bipush 40
    //   1389: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1392: putfield 4163	android/widget/FrameLayout$LayoutParams:height	I
    //   1395: aload 4
    //   1397: aload_0
    //   1398: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1401: bipush 72
    //   1403: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1406: putfield 2171	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   1409: aload 4
    //   1411: aload_0
    //   1412: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1415: bipush 22
    //   1417: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1420: putfield 2168	android/widget/FrameLayout$LayoutParams:rightMargin	I
    //   1423: aload 4
    //   1425: aload_0
    //   1426: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1429: bipush 8
    //   1431: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1434: putfield 2172	android/widget/FrameLayout$LayoutParams:bottomMargin	I
    //   1437: aload_0
    //   1438: getfield 1798	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhN	Landroid/view/View;
    //   1441: aload 4
    //   1443: invokevirtual 2176	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1446: aload_0
    //   1447: getfield 1798	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhN	Landroid/view/View;
    //   1450: fconst_0
    //   1451: invokevirtual 4164	android/view/View:setAlpha	(F)V
    //   1454: aload_0
    //   1455: getfield 1830	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhO	Landroid/view/View;
    //   1458: invokevirtual 4159	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1461: checkcast 2137	android/widget/FrameLayout$LayoutParams
    //   1464: astore 4
    //   1466: aload 4
    //   1468: aload_0
    //   1469: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1472: sipush 250
    //   1475: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1478: putfield 4162	android/widget/FrameLayout$LayoutParams:width	I
    //   1481: aload 4
    //   1483: aload_0
    //   1484: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1487: bipush 40
    //   1489: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1492: putfield 4163	android/widget/FrameLayout$LayoutParams:height	I
    //   1495: aload 4
    //   1497: aload_0
    //   1498: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1501: bipush 72
    //   1503: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1506: putfield 2171	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   1509: aload 4
    //   1511: aload_0
    //   1512: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1515: bipush 22
    //   1517: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1520: putfield 2168	android/widget/FrameLayout$LayoutParams:rightMargin	I
    //   1523: aload 4
    //   1525: aload_0
    //   1526: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1529: bipush 8
    //   1531: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1534: putfield 2172	android/widget/FrameLayout$LayoutParams:bottomMargin	I
    //   1537: aload_0
    //   1538: getfield 1830	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhO	Landroid/view/View;
    //   1541: aload 4
    //   1543: invokevirtual 2176	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1546: aload_0
    //   1547: getfield 1830	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhO	Landroid/view/View;
    //   1550: fconst_0
    //   1551: invokevirtual 4164	android/view/View:setAlpha	(F)V
    //   1554: aload_0
    //   1555: getfield 2461	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhx	Landroid/view/ViewGroup;
    //   1558: aload_0
    //   1559: getfield 953	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YiT	I
    //   1562: i2f
    //   1563: invokevirtual 3428	android/view/ViewGroup:setTranslationY	(F)V
    //   1566: aload_0
    //   1567: getfield 2461	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhx	Landroid/view/ViewGroup;
    //   1570: fconst_0
    //   1571: invokevirtual 3427	android/view/ViewGroup:setAlpha	(F)V
    //   1574: aload_0
    //   1575: getfield 1927	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhn	Lcom/tencent/mm/plugin/transvoice/ui/SoundWaveView;
    //   1578: bipush 8
    //   1580: invokevirtual 1930	com/tencent/mm/plugin/transvoice/ui/SoundWaveView:setVisibility	(I)V
    //   1583: aload_0
    //   1584: getfield 4125	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhR	Landroid/view/View;
    //   1587: iconst_0
    //   1588: invokevirtual 1850	android/view/View:setVisibility	(I)V
    //   1591: invokestatic 4167	com/tencent/mm/ui/aw:isDarkMode	()Z
    //   1594: ifeq +165 -> 1759
    //   1597: aload_0
    //   1598: getfield 2482	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhk	Landroid/view/View;
    //   1601: aload_0
    //   1602: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1605: invokevirtual 1749	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1608: getstatic 4170	com/tencent/mm/R$g:foF	I
    //   1611: invokevirtual 1760	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1614: invokevirtual 4173	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   1617: aload_0
    //   1618: iconst_0
    //   1619: putfield 916	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YiG	Z
    //   1622: aload_0
    //   1623: getfield 1786	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhi	Lcom/tencent/mm/ui/base/v;
    //   1626: aload_0
    //   1627: bipush 49
    //   1629: iconst_0
    //   1630: iconst_0
    //   1631: invokevirtual 4177	com/tencent/mm/ui/base/v:showAtLocation	(Landroid/view/View;III)V
    //   1634: aload_0
    //   1635: invokespecial 4179	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:iMf	()V
    //   1638: aload_0
    //   1639: getfield 2554	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhr	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   1642: bipush 8
    //   1644: invokevirtual 2459	com/tencent/mm/ui/widget/imageview/WeImageView:setVisibility	(I)V
    //   1647: aload_0
    //   1648: new 100	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$52
    //   1651: dup
    //   1652: aload_0
    //   1653: invokespecial 4180	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$52:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   1656: invokevirtual 3887	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:post	(Ljava/lang/Runnable;)Z
    //   1659: pop
    //   1660: sipush 31616
    //   1663: invokestatic 606	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1666: return
    //   1667: aload_0
    //   1668: iload_1
    //   1669: putfield 992	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:TTV	I
    //   1672: goto -653 -> 1019
    //   1675: aload_0
    //   1676: getfield 1884	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhv	Landroid/widget/TextView;
    //   1679: aload_0
    //   1680: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1683: bipush 30
    //   1685: invokestatic 855	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   1688: i2f
    //   1689: invokevirtual 4143	android/widget/TextView:setTranslationY	(F)V
    //   1692: aload_0
    //   1693: getfield 1884	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhv	Landroid/widget/TextView;
    //   1696: iconst_0
    //   1697: invokevirtual 1885	android/widget/TextView:setVisibility	(I)V
    //   1700: aload_0
    //   1701: getfield 1884	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhv	Landroid/widget/TextView;
    //   1704: fconst_0
    //   1705: invokevirtual 4144	android/widget/TextView:setAlpha	(F)V
    //   1708: aload_0
    //   1709: getfield 1884	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhv	Landroid/widget/TextView;
    //   1712: aload_0
    //   1713: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1716: invokevirtual 1749	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1719: getstatic 4183	com/tencent/mm/R$l:gOK	I
    //   1722: invokevirtual 1768	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1725: invokevirtual 2153	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1728: aload_0
    //   1729: getfield 1884	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhv	Landroid/widget/TextView;
    //   1732: invokevirtual 4148	android/widget/TextView:animate	()Landroid/view/ViewPropertyAnimator;
    //   1735: fconst_1
    //   1736: invokevirtual 1811	android/view/ViewPropertyAnimator:alpha	(F)Landroid/view/ViewPropertyAnimator;
    //   1739: fconst_0
    //   1740: invokevirtual 1808	android/view/ViewPropertyAnimator:translationY	(F)Landroid/view/ViewPropertyAnimator;
    //   1743: ldc2_w 791
    //   1746: invokevirtual 1816	android/view/ViewPropertyAnimator:setDuration	(J)Landroid/view/ViewPropertyAnimator;
    //   1749: lconst_0
    //   1750: invokevirtual 4153	android/view/ViewPropertyAnimator:setStartDelay	(J)Landroid/view/ViewPropertyAnimator;
    //   1753: invokevirtual 1828	android/view/ViewPropertyAnimator:start	()V
    //   1756: goto -576 -> 1180
    //   1759: aload_0
    //   1760: getfield 2482	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhk	Landroid/view/View;
    //   1763: aload_0
    //   1764: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1767: invokevirtual 1749	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1770: getstatic 4186	com/tencent/mm/R$g:foG	I
    //   1773: invokevirtual 1760	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1776: invokevirtual 4173	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   1779: goto -162 -> 1617
    //   1782: aload_0
    //   1783: iconst_0
    //   1784: putfield 777	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhZ	I
    //   1787: aload_0
    //   1788: getfield 2009	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YfQ	Z
    //   1791: ifeq +1110 -> 2901
    //   1794: aload_0
    //   1795: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1798: sipush 280
    //   1801: invokestatic 1615	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1804: istore_2
    //   1805: aload_0
    //   1806: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1809: ldc_w 883
    //   1812: invokestatic 4191	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$BitmapFactory:fromDPToPix	(Landroid/content/Context;F)I
    //   1815: istore_3
    //   1816: iload_1
    //   1817: iload_3
    //   1818: iadd
    //   1819: iload_2
    //   1820: if_icmpge +1095 -> 2915
    //   1823: aload_0
    //   1824: iconst_m1
    //   1825: putfield 777	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhZ	I
    //   1828: aload_0
    //   1829: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   1832: ifnonnull +893 -> 2725
    //   1835: aload_0
    //   1836: new 1984	com/tencent/mm/ui/base/v
    //   1839: dup
    //   1840: aload_0
    //   1841: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1844: getstatic 4194	com/tencent/mm/R$i:goY	I
    //   1847: aconst_null
    //   1848: invokestatic 3956	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1851: iconst_m1
    //   1852: bipush 254
    //   1854: invokespecial 4196	com/tencent/mm/ui/base/v:<init>	(Landroid/view/View;II)V
    //   1857: putfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   1860: aload_0
    //   1861: aload_0
    //   1862: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   1865: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   1868: getstatic 4199	com/tencent/mm/R$h:voice_rcd_hint_rcding	I
    //   1871: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   1874: checkcast 1237	android/view/ViewGroup
    //   1877: putfield 2962	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YfM	Landroid/view/ViewGroup;
    //   1880: aload_0
    //   1881: aload_0
    //   1882: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   1885: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   1888: getstatic 4202	com/tencent/mm/R$h:voice_rcd_hint_anim_area	I
    //   1891: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   1894: putfield 2783	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:AhM	Landroid/view/View;
    //   1897: aload_0
    //   1898: aload_0
    //   1899: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   1902: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   1905: getstatic 4205	com/tencent/mm/R$h:gdl	I
    //   1908: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   1911: checkcast 1256	android/widget/ImageView
    //   1914: putfield 4207	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:AhL	Landroid/widget/ImageView;
    //   1917: aload_0
    //   1918: aload_0
    //   1919: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   1922: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   1925: getstatic 4210	com/tencent/mm/R$h:gcZ	I
    //   1928: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   1931: checkcast 1280	android/widget/TextView
    //   1934: putfield 4212	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YfN	Landroid/widget/TextView;
    //   1937: aload_0
    //   1938: getfield 4212	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YfN	Landroid/widget/TextView;
    //   1941: iconst_0
    //   1942: aload_0
    //   1943: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1946: getstatic 4215	com/tencent/mm/R$f:flW	I
    //   1949: invokestatic 1325	com/tencent/mm/cd/a:bs	(Landroid/content/Context;I)I
    //   1952: i2f
    //   1953: aload_0
    //   1954: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   1957: invokestatic 1329	com/tencent/mm/cd/a:jO	(Landroid/content/Context;)F
    //   1960: fmul
    //   1961: invokevirtual 4216	android/widget/TextView:setTextSize	(IF)V
    //   1964: aload_0
    //   1965: aload_0
    //   1966: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   1969: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   1972: getstatic 4219	com/tencent/mm/R$h:voice_rcd_hint_cancel_area	I
    //   1975: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   1978: putfield 2321	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:AhN	Landroid/view/View;
    //   1981: aload_0
    //   1982: aload_0
    //   1983: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   1986: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   1989: getstatic 4222	com/tencent/mm/R$h:voice_rcd_hint_cancel_text	I
    //   1992: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   1995: checkcast 1280	android/widget/TextView
    //   1998: putfield 4224	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOo	Landroid/widget/TextView;
    //   2001: aload_0
    //   2002: getfield 4224	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOo	Landroid/widget/TextView;
    //   2005: iconst_0
    //   2006: aload_0
    //   2007: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   2010: getstatic 4215	com/tencent/mm/R$f:flW	I
    //   2013: invokestatic 1325	com/tencent/mm/cd/a:bs	(Landroid/content/Context;I)I
    //   2016: i2f
    //   2017: aload_0
    //   2018: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   2021: invokestatic 1329	com/tencent/mm/cd/a:jO	(Landroid/content/Context;)F
    //   2024: fmul
    //   2025: invokevirtual 4216	android/widget/TextView:setTextSize	(IF)V
    //   2028: aload_0
    //   2029: aload_0
    //   2030: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2033: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2036: getstatic 4227	com/tencent/mm/R$h:voice_rcd_hint_cancel_icon	I
    //   2039: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2042: checkcast 1256	android/widget/ImageView
    //   2045: putfield 4229	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOp	Landroid/widget/ImageView;
    //   2048: aload_0
    //   2049: aload_0
    //   2050: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2053: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2056: getstatic 4232	com/tencent/mm/R$h:gcY	I
    //   2059: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2062: putfield 2977	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOq	Landroid/view/View;
    //   2065: aload_0
    //   2066: aload_0
    //   2067: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2070: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2073: getstatic 4235	com/tencent/mm/R$h:voice_rcd_hint_tooshort	I
    //   2076: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2079: putfield 2980	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:AhK	Landroid/view/View;
    //   2082: aload_0
    //   2083: aload_0
    //   2084: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2087: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2090: getstatic 4238	com/tencent/mm/R$h:gcB	I
    //   2093: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2096: checkcast 1237	android/view/ViewGroup
    //   2099: putfield 3517	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgD	Landroid/view/ViewGroup;
    //   2102: aload_0
    //   2103: aload_0
    //   2104: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2107: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2110: getstatic 4241	com/tencent/mm/R$h:gcv	I
    //   2113: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2116: putfield 4243	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgE	Landroid/view/View;
    //   2119: aload_0
    //   2120: aload_0
    //   2121: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2124: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2127: getstatic 4246	com/tencent/mm/R$h:gcF	I
    //   2130: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2133: putfield 3519	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgH	Landroid/view/View;
    //   2136: aload_0
    //   2137: aload_0
    //   2138: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2141: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2144: getstatic 4249	com/tencent/mm/R$h:gcG	I
    //   2147: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2150: checkcast 1256	android/widget/ImageView
    //   2153: putfield 4251	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgI	Landroid/widget/ImageView;
    //   2156: aload_0
    //   2157: aload_0
    //   2158: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2161: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2164: getstatic 4254	com/tencent/mm/R$h:gcu	I
    //   2167: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2170: checkcast 1256	android/widget/ImageView
    //   2173: putfield 3521	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgJ	Landroid/widget/ImageView;
    //   2176: aload_0
    //   2177: aload_0
    //   2178: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2181: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2184: getstatic 4257	com/tencent/mm/R$h:gcw	I
    //   2187: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2190: putfield 2631	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgK	Landroid/view/View;
    //   2193: aload_0
    //   2194: aload_0
    //   2195: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2198: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2201: getstatic 4260	com/tencent/mm/R$h:gcz	I
    //   2204: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2207: checkcast 1280	android/widget/TextView
    //   2210: putfield 2634	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgL	Landroid/widget/TextView;
    //   2213: aload_0
    //   2214: aload_0
    //   2215: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2218: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2221: getstatic 4263	com/tencent/mm/R$h:gcx	I
    //   2224: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2227: checkcast 1256	android/widget/ImageView
    //   2230: putfield 3380	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgM	Landroid/widget/ImageView;
    //   2233: aload_0
    //   2234: aload_0
    //   2235: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2238: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2241: getstatic 4266	com/tencent/mm/R$h:gcA	I
    //   2244: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2247: putfield 2619	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgN	Landroid/view/View;
    //   2250: aload_0
    //   2251: aload_0
    //   2252: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2255: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2258: getstatic 4269	com/tencent/mm/R$h:gcr	I
    //   2261: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2264: putfield 2625	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgO	Landroid/view/View;
    //   2267: aload_0
    //   2268: aload_0
    //   2269: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2272: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2275: getstatic 4272	com/tencent/mm/R$h:gcs	I
    //   2278: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2281: checkcast 1312	com/tencent/mm/ui/widget/imageview/WeImageView
    //   2284: putfield 2684	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgP	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   2287: aload_0
    //   2288: aload_0
    //   2289: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2292: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2295: getstatic 4275	com/tencent/mm/R$h:gct	I
    //   2298: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2301: checkcast 1280	android/widget/TextView
    //   2304: putfield 2689	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgQ	Landroid/widget/TextView;
    //   2307: aload_0
    //   2308: aload_0
    //   2309: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2312: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2315: getstatic 4278	com/tencent/mm/R$h:gcC	I
    //   2318: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2321: putfield 2628	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgR	Landroid/view/View;
    //   2324: aload_0
    //   2325: aload_0
    //   2326: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2329: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2332: getstatic 4281	com/tencent/mm/R$h:gcD	I
    //   2335: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2338: checkcast 1312	com/tencent/mm/ui/widget/imageview/WeImageView
    //   2341: putfield 2666	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgS	Lcom/tencent/mm/ui/widget/imageview/WeImageView;
    //   2344: aload_0
    //   2345: aload_0
    //   2346: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2349: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2352: getstatic 4284	com/tencent/mm/R$h:gcE	I
    //   2355: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2358: checkcast 1280	android/widget/TextView
    //   2361: putfield 2671	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgT	Landroid/widget/TextView;
    //   2364: aload_0
    //   2365: aload_0
    //   2366: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   2369: getstatic 4287	com/tencent/mm/R$i:gkp	I
    //   2372: aconst_null
    //   2373: invokestatic 3956	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2376: putfield 4289	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgU	Landroid/view/View;
    //   2379: getstatic 2026	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$j:YjG	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$j;
    //   2382: aload_0
    //   2383: getfield 747	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhc	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$j;
    //   2386: if_acmpne +207 -> 2593
    //   2389: aload_0
    //   2390: getfield 1697	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:activity	Landroid/app/Activity;
    //   2393: invokevirtual 1508	android/app/Activity:getWindow	()Landroid/view/Window;
    //   2396: invokevirtual 4292	android/view/Window:getDecorView	()Landroid/view/View;
    //   2399: astore 4
    //   2401: aload 4
    //   2403: invokevirtual 4293	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   2406: astore 5
    //   2408: aload_0
    //   2409: new 4295	com/tencent/mm/ui/blur/BlurView
    //   2412: dup
    //   2413: aload_0
    //   2414: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   2417: invokespecial 4296	com/tencent/mm/ui/blur/BlurView:<init>	(Landroid/content/Context;)V
    //   2420: putfield 2078	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgF	Lcom/tencent/mm/ui/blur/BlurView;
    //   2423: aload_0
    //   2424: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   2427: bipush 14
    //   2429: invokestatic 1615	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   2432: istore_1
    //   2433: aload_0
    //   2434: getfield 2078	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgF	Lcom/tencent/mm/ui/blur/BlurView;
    //   2437: aload 4
    //   2439: checkcast 1237	android/view/ViewGroup
    //   2442: invokevirtual 4299	com/tencent/mm/ui/blur/BlurView:ad	(Landroid/view/ViewGroup;)Lcom/tencent/mm/ui/blur/BlurView;
    //   2445: aload_0
    //   2446: invokevirtual 1853	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getResources	()Landroid/content/res/Resources;
    //   2449: getstatic 4302	com/tencent/mm/R$e:flc	I
    //   2452: invokevirtual 1862	android/content/res/Resources:getColor	(I)I
    //   2455: invokevirtual 4306	com/tencent/mm/ui/blur/BlurView:aBy	(I)Lcom/tencent/mm/ui/blur/BlurView;
    //   2458: aload 5
    //   2460: invokevirtual 4309	com/tencent/mm/ui/blur/BlurView:V	(Landroid/graphics/drawable/Drawable;)Lcom/tencent/mm/ui/blur/BlurView;
    //   2463: new 4311	com/tencent/mm/ui/blur/f
    //   2466: dup
    //   2467: aload_0
    //   2468: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   2471: invokespecial 4312	com/tencent/mm/ui/blur/f:<init>	(Landroid/content/Context;)V
    //   2474: invokevirtual 4315	com/tencent/mm/ui/blur/BlurView:b	(Lcom/tencent/mm/ui/blur/b;)Lcom/tencent/mm/ui/blur/BlurView;
    //   2477: ldc_w 4316
    //   2480: invokevirtual 4320	com/tencent/mm/ui/blur/BlurView:eb	(F)Lcom/tencent/mm/ui/blur/BlurView;
    //   2483: invokevirtual 4324	com/tencent/mm/ui/blur/BlurView:joa	()Lcom/tencent/mm/ui/blur/BlurView;
    //   2486: astore 6
    //   2488: aload 6
    //   2490: iload_1
    //   2491: i2f
    //   2492: fconst_1
    //   2493: fmul
    //   2494: putfield 4327	com/tencent/mm/ui/blur/BlurView:Rx	F
    //   2497: aload 6
    //   2499: iconst_1
    //   2500: putfield 4330	com/tencent/mm/ui/blur/BlurView:aedd	Z
    //   2503: aload 6
    //   2505: aload_0
    //   2506: getfield 777	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhZ	I
    //   2509: invokevirtual 4333	com/tencent/mm/ui/blur/BlurView:aBz	(I)Lcom/tencent/mm/ui/blur/BlurView;
    //   2512: invokevirtual 4336	com/tencent/mm/ui/blur/BlurView:job	()Lcom/tencent/mm/ui/blur/BlurView;
    //   2515: pop
    //   2516: aload_0
    //   2517: new 4295	com/tencent/mm/ui/blur/BlurView
    //   2520: dup
    //   2521: aload_0
    //   2522: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   2525: invokespecial 4296	com/tencent/mm/ui/blur/BlurView:<init>	(Landroid/content/Context;)V
    //   2528: putfield 2608	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgV	Lcom/tencent/mm/ui/blur/BlurView;
    //   2531: aload_0
    //   2532: getfield 2608	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgV	Lcom/tencent/mm/ui/blur/BlurView;
    //   2535: aload_0
    //   2536: invokevirtual 1853	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getResources	()Landroid/content/res/Resources;
    //   2539: getstatic 4302	com/tencent/mm/R$e:flc	I
    //   2542: invokevirtual 1862	android/content/res/Resources:getColor	(I)I
    //   2545: invokevirtual 4306	com/tencent/mm/ui/blur/BlurView:aBy	(I)Lcom/tencent/mm/ui/blur/BlurView;
    //   2548: pop
    //   2549: aload_0
    //   2550: getfield 2608	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgV	Lcom/tencent/mm/ui/blur/BlurView;
    //   2553: aload 4
    //   2555: checkcast 1237	android/view/ViewGroup
    //   2558: invokevirtual 4299	com/tencent/mm/ui/blur/BlurView:ad	(Landroid/view/ViewGroup;)Lcom/tencent/mm/ui/blur/BlurView;
    //   2561: aload 5
    //   2563: invokevirtual 4309	com/tencent/mm/ui/blur/BlurView:V	(Landroid/graphics/drawable/Drawable;)Lcom/tencent/mm/ui/blur/BlurView;
    //   2566: new 4311	com/tencent/mm/ui/blur/f
    //   2569: dup
    //   2570: aload_0
    //   2571: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   2574: invokespecial 4312	com/tencent/mm/ui/blur/f:<init>	(Landroid/content/Context;)V
    //   2577: invokevirtual 4315	com/tencent/mm/ui/blur/BlurView:b	(Lcom/tencent/mm/ui/blur/b;)Lcom/tencent/mm/ui/blur/BlurView;
    //   2580: ldc_w 4316
    //   2583: invokevirtual 4320	com/tencent/mm/ui/blur/BlurView:eb	(F)Lcom/tencent/mm/ui/blur/BlurView;
    //   2586: invokevirtual 4324	com/tencent/mm/ui/blur/BlurView:joa	()Lcom/tencent/mm/ui/blur/BlurView;
    //   2589: invokevirtual 4336	com/tencent/mm/ui/blur/BlurView:job	()Lcom/tencent/mm/ui/blur/BlurView;
    //   2592: pop
    //   2593: ldc_w 1378
    //   2596: ldc_w 4338
    //   2599: iconst_1
    //   2600: anewarray 1382	java/lang/Object
    //   2603: dup
    //   2604: iconst_0
    //   2605: aload_0
    //   2606: getfield 747	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhc	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$j;
    //   2609: aastore
    //   2610: invokestatic 1454	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2613: getstatic 4341	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$92:Yjl	[I
    //   2616: aload_0
    //   2617: getfield 747	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhc	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$j;
    //   2620: invokevirtual 4342	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$j:ordinal	()I
    //   2623: iaload
    //   2624: tableswitch	default:+28 -> 2652, 1:+322->2946, 2:+454->3078, 3:+454->3078
    //   2653: getfield 2002	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgZ	Lcom/tencent/mm/ui/base/v;
    //   2656: iconst_0
    //   2657: invokevirtual 4128	com/tencent/mm/ui/base/v:setClippingEnabled	(Z)V
    //   2660: aload_0
    //   2661: getfield 2002	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgZ	Lcom/tencent/mm/ui/base/v;
    //   2664: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2667: fconst_0
    //   2668: invokevirtual 4164	android/view/View:setAlpha	(F)V
    //   2671: aload_0
    //   2672: getfield 2002	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgZ	Lcom/tencent/mm/ui/base/v;
    //   2675: new 102	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$53
    //   2678: dup
    //   2679: aload_0
    //   2680: invokespecial 4343	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$53:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   2683: invokevirtual 3965	com/tencent/mm/ui/base/v:setOnDismissListener	(Landroid/widget/PopupWindow$OnDismissListener;)V
    //   2686: aload_0
    //   2687: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2690: invokevirtual 3966	com/tencent/mm/ui/base/v:getContentView	()Landroid/view/View;
    //   2693: getstatic 4346	com/tencent/mm/R$h:gcy	I
    //   2696: invokevirtual 1201	android/view/View:findViewById	(I)Landroid/view/View;
    //   2699: checkcast 1280	android/widget/TextView
    //   2702: iconst_0
    //   2703: aload_0
    //   2704: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   2707: getstatic 4349	com/tencent/mm/R$f:fmg	I
    //   2710: invokestatic 1325	com/tencent/mm/cd/a:bs	(Landroid/content/Context;I)I
    //   2713: i2f
    //   2714: aload_0
    //   2715: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   2718: invokestatic 1329	com/tencent/mm/cd/a:jO	(Landroid/content/Context;)F
    //   2721: fmul
    //   2722: invokevirtual 4216	android/widget/TextView:setTextSize	(IF)V
    //   2725: aload_0
    //   2726: invokespecial 4351	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:iMg	()V
    //   2729: aload_0
    //   2730: getfield 777	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhZ	I
    //   2733: iconst_m1
    //   2734: if_icmpeq +160 -> 2894
    //   2737: aload_0
    //   2738: getfield 2980	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:AhK	Landroid/view/View;
    //   2741: bipush 8
    //   2743: invokevirtual 1850	android/view/View:setVisibility	(I)V
    //   2746: aload_0
    //   2747: getfield 2962	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YfM	Landroid/view/ViewGroup;
    //   2750: bipush 8
    //   2752: invokevirtual 2454	android/view/ViewGroup:setVisibility	(I)V
    //   2755: aload_0
    //   2756: getfield 2977	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOq	Landroid/view/View;
    //   2759: iconst_0
    //   2760: invokevirtual 1850	android/view/View:setVisibility	(I)V
    //   2763: new 2496	com/tencent/mm/sdk/platformtools/MMHandler
    //   2766: dup
    //   2767: invokespecial 4352	com/tencent/mm/sdk/platformtools/MMHandler:<init>	()V
    //   2770: new 104	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$54
    //   2773: dup
    //   2774: aload_0
    //   2775: invokespecial 4353	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$54:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   2778: invokevirtual 4354	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   2781: pop
    //   2782: aload_0
    //   2783: getfield 2009	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YfQ	Z
    //   2786: ifeq +93 -> 2879
    //   2789: aload_0
    //   2790: invokespecial 4356	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:iMQ	()V
    //   2793: aload_0
    //   2794: iconst_0
    //   2795: putfield 756	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhf	Z
    //   2798: aload_0
    //   2799: invokespecial 2639	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:iMN	()V
    //   2802: aload_0
    //   2803: getfield 2002	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgZ	Lcom/tencent/mm/ui/base/v;
    //   2806: aload_0
    //   2807: bipush 49
    //   2809: iconst_0
    //   2810: iconst_0
    //   2811: invokevirtual 4177	com/tencent/mm/ui/base/v:showAtLocation	(Landroid/view/View;III)V
    //   2814: aload_0
    //   2815: iconst_0
    //   2816: putfield 754	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhe	Z
    //   2819: aload_0
    //   2820: getfield 912	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YiE	Z
    //   2823: ifeq +56 -> 2879
    //   2826: aload_0
    //   2827: iconst_0
    //   2828: putfield 912	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YiE	Z
    //   2831: getstatic 2026	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$j:YjG	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$j;
    //   2834: aload_0
    //   2835: getfield 747	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhc	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$j;
    //   2838: if_acmpne +295 -> 3133
    //   2841: aload_0
    //   2842: getfield 2078	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgF	Lcom/tencent/mm/ui/blur/BlurView;
    //   2845: aload_0
    //   2846: invokevirtual 1853	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getResources	()Landroid/content/res/Resources;
    //   2849: getstatic 4302	com/tencent/mm/R$e:flc	I
    //   2852: invokevirtual 1862	android/content/res/Resources:getColor	(I)I
    //   2855: invokevirtual 4306	com/tencent/mm/ui/blur/BlurView:aBy	(I)Lcom/tencent/mm/ui/blur/BlurView;
    //   2858: aload_0
    //   2859: getfield 1697	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:activity	Landroid/app/Activity;
    //   2862: invokevirtual 1508	android/app/Activity:getWindow	()Landroid/view/Window;
    //   2865: invokevirtual 4292	android/view/Window:getDecorView	()Landroid/view/View;
    //   2868: invokevirtual 4293	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   2871: invokevirtual 4309	com/tencent/mm/ui/blur/BlurView:V	(Landroid/graphics/drawable/Drawable;)Lcom/tencent/mm/ui/blur/BlurView;
    //   2874: iconst_1
    //   2875: invokevirtual 4360	com/tencent/mm/ui/blur/BlurView:LP	(Z)Lcom/tencent/mm/ui/blur/BlurView;
    //   2878: pop
    //   2879: aload_0
    //   2880: getfield 1999	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:SOn	Lcom/tencent/mm/ui/base/v;
    //   2883: aload_0
    //   2884: bipush 49
    //   2886: iconst_0
    //   2887: aload_0
    //   2888: getfield 777	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhZ	I
    //   2891: invokevirtual 4177	com/tencent/mm/ui/base/v:showAtLocation	(Landroid/view/View;III)V
    //   2894: sipush 31616
    //   2897: invokestatic 606	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2900: return
    //   2901: aload_0
    //   2902: invokevirtual 849	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   2905: sipush 180
    //   2908: invokestatic 1615	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   2911: istore_2
    //   2912: goto -1107 -> 1805
    //   2915: aload_0
    //   2916: iload_1
    //   2917: iload_2
    //   2918: isub
    //   2919: iconst_2
    //   2920: idiv
    //   2921: iload_3
    //   2922: iadd
    //   2923: putfield 777	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YhZ	I
    //   2926: goto -1098 -> 1828
    //   2929: astore 4
    //   2931: aload_0
    //   2932: getstatic 2074	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$j:YjH	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$j;
    //   2935: putfield 747	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yhc	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$j;
    //   2938: aload_0
    //   2939: iconst_1
    //   2940: putfield 779	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:Yia	Z
    //   2943: goto -350 -> 2593
    //   2946: aload_0
    //   2947: getfield 3517	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgD	Landroid/view/ViewGroup;
    //   2950: aload_0
    //   2951: getfield 4243	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgE	Landroid/view/View;
    //   2954: invokevirtual 4363	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   2957: new 1940	android/widget/RelativeLayout$LayoutParams
    //   2960: dup
    //   2961: aload_0
    //   2962: invokevirtual 1853	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getResources	()Landroid/content/res/Resources;
    //   2965: getstatic 4366	com/tencent/mm/R$f:fmf	I
    //   2968: invokevirtual 2595	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   2971: aload_0
    //   2972: invokevirtual 1853	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getResources	()Landroid/content/res/Resources;
    //   2975: getstatic 4366	com/tencent/mm/R$f:fmf	I
    //   2978: invokevirtual 2595	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   2981: invokespecial 4367	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   2984: astore 4
    //   2986: aload 4
    //   2988: bipush 14
    //   2990: invokevirtual 1943	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   2993: aload 4
    //   2995: bipush 10
    //   2997: invokevirtual 1943	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   3000: aload_0
    //   3001: getfield 2078	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgF	Lcom/tencent/mm/ui/blur/BlurView;
    //   3004: aload_0
    //   3005: getfield 4243	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgE	Landroid/view/View;
    //   3008: aload 4
    //   3010: invokevirtual 4368	com/tencent/mm/ui/blur/BlurView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   3013: aload_0
    //   3014: getfield 3517	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgD	Landroid/view/ViewGroup;
    //   3017: aload_0
    //   3018: getfield 2078	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgF	Lcom/tencent/mm/ui/blur/BlurView;
    //   3021: aload 4
    //   3023: invokevirtual 4369	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   3026: aload_0
    //   3027: aload_0
    //   3028: getfield 2078	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgF	Lcom/tencent/mm/ui/blur/BlurView;
    //   3031: putfield 2616	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgG	Landroid/view/View;
    //   3034: new 2137	android/widget/FrameLayout$LayoutParams
    //   3037: dup
    //   3038: iconst_m1
    //   3039: iconst_m1
    //   3040: invokespecial 2139	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   3043: astore 4
    //   3045: aload_0
    //   3046: getfield 2608	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgV	Lcom/tencent/mm/ui/blur/BlurView;
    //   3049: aload_0
    //   3050: getfield 4289	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgU	Landroid/view/View;
    //   3053: aload 4
    //   3055: invokevirtual 4368	com/tencent/mm/ui/blur/BlurView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   3058: aload_0
    //   3059: new 1984	com/tencent/mm/ui/base/v
    //   3062: dup
    //   3063: aload_0
    //   3064: getfield 2608	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgV	Lcom/tencent/mm/ui/blur/BlurView;
    //   3067: iconst_m1
    //   3068: iconst_m1
    //   3069: invokespecial 4196	com/tencent/mm/ui/base/v:<init>	(Landroid/view/View;II)V
    //   3072: putfield 2002	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgZ	Lcom/tencent/mm/ui/base/v;
    //   3075: goto -423 -> 2652
    //   3078: aload_0
    //   3079: aload_0
    //   3080: getfield 4243	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgE	Landroid/view/View;
    //   3083: putfield 2616	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgG	Landroid/view/View;
    //   3086: aload_0
    //   3087: getfield 2616	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgG	Landroid/view/View;
    //   3090: getstatic 4372	com/tencent/mm/R$g:fpI	I
    //   3093: invokevirtual 4375	android/view/View:setBackgroundResource	(I)V
    //   3096: aload_0
    //   3097: getfield 4289	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgU	Landroid/view/View;
    //   3100: aload_0
    //   3101: invokevirtual 1853	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getResources	()Landroid/content/res/Resources;
    //   3104: getstatic 4378	com/tencent/mm/R$e:fld	I
    //   3107: invokevirtual 1862	android/content/res/Resources:getColor	(I)I
    //   3110: invokevirtual 4381	android/view/View:setBackgroundColor	(I)V
    //   3113: aload_0
    //   3114: new 1984	com/tencent/mm/ui/base/v
    //   3117: dup
    //   3118: aload_0
    //   3119: getfield 4289	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgU	Landroid/view/View;
    //   3122: iconst_m1
    //   3123: iconst_m1
    //   3124: invokespecial 4196	com/tencent/mm/ui/base/v:<init>	(Landroid/view/View;II)V
    //   3127: putfield 2002	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgZ	Lcom/tencent/mm/ui/base/v;
    //   3130: goto -478 -> 2652
    //   3133: aload_0
    //   3134: getfield 2616	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:YgG	Landroid/view/View;
    //   3137: getstatic 4372	com/tencent/mm/R$g:fpI	I
    //   3140: invokevirtual 4375	android/view/View:setBackgroundResource	(I)V
    //   3143: goto -264 -> 2879
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3146	0	this	ChatFooter
    //   0	3146	1	paramInt	int
    //   1804	1115	2	i	int
    //   1815	1108	3	j	int
    //   856	1698	4	localObject1	Object
    //   2929	1	4	localObject2	Object
    //   2984	70	4	localObject3	Object
    //   2406	156	5	localDrawable	android.graphics.drawable.Drawable
    //   2486	18	6	localBlurView	BlurView
    // Exception table:
    //   from	to	target	type
    //   2379	2593	2929	finally
  }
  
  public final void awE(int paramInt)
  {
    AppMethodBeat.i(31622);
    if (this.Yhg)
    {
      if ((this.Yhn != null) && (this.Yhn.getVisibility() == 0)) {
        this.Yhn.apr(paramInt);
      }
      AppMethodBeat.o(31622);
      return;
    }
    if (this.YfQ)
    {
      i = 0;
      for (;;)
      {
        if (i < Yix.length)
        {
          if ((paramInt >= Yiw[i]) && (paramInt < Yiw[(i + 1)])) {
            this.YgI.setBackgroundDrawable(com.tencent.mm.cd.a.m(getContext(), Yix[i]));
          }
        }
        else
        {
          if ((paramInt != -1) || (this.SOn == null)) {
            break;
          }
          this.SOn.dismiss();
          this.SOq.setVisibility(0);
          this.YfM.setVisibility(8);
          this.AhK.setVisibility(8);
          AppMethodBeat.o(31622);
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < Yix.length)
      {
        if ((paramInt >= Yiw[i]) && (paramInt < Yiw[(i + 1)])) {
          this.AhL.setBackgroundDrawable(com.tencent.mm.cd.a.m(getContext(), Yix[i]));
        }
      }
      else
      {
        if ((paramInt == -1) && (this.SOn != null))
        {
          this.SOn.dismiss();
          this.SOq.setVisibility(0);
          this.YfM.setVisibility(8);
          this.AhK.setVisibility(8);
        }
        AppMethodBeat.o(31622);
        return;
      }
      i += 1;
    }
  }
  
  public final void awF(int paramInt)
  {
    AppMethodBeat.i(31624);
    this.YfP = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31624);
      return;
      JZ(true);
      this.Yfd.setVisibility(8);
      awC(R.g.fnr);
      AppMethodBeat.o(31624);
      return;
      JZ(false);
      this.Yfd.setVisibility(0);
      iMF();
      awC(R.g.chatting_setmode_keyboard_btn);
      if ((z.bBK().booleanValue()) && (this.Ygs != null))
      {
        c localc = this.Ygs;
        Boolean localBoolean = Boolean.TRUE;
        localc.b(localBoolean, localBoolean);
      }
    }
  }
  
  public final void awH(int paramInt)
  {
    AppMethodBeat.i(185823);
    c(paramInt, true, 0, 0);
    AppMethodBeat.o(185823);
  }
  
  public final boolean bC(cc paramcc)
  {
    AppMethodBeat.i(31678);
    if (this.YfA != null) {
      this.YfA.gag();
    }
    this.Yfo.setTag(paramcc);
    this.YfP = 1;
    JZ(true);
    this.Yfd.setVisibility(8);
    awC(R.g.fnr);
    if (this.Yab != null)
    {
      this.Yab.setVisibility(8);
      this.Yae = false;
      this.Yab.reset();
    }
    showVKB();
    JX(true);
    brh("");
    AppMethodBeat.o(31678);
    return true;
  }
  
  public final void bG(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31632);
    this.Yfb.JL(paramBoolean1);
    this.Yfb.JM(paramBoolean2);
    AppMethodBeat.o(31632);
  }
  
  public final void brh(String paramString)
  {
    AppMethodBeat.i(31675);
    com.tencent.mm.plugin.groupsolitaire.ui.d locald;
    String str2;
    if ((this.Yfz != null) && (this.mkz != null) && (this.Ygv != null))
    {
      locald = this.Yfz;
      str2 = this.Ygv.getTalkerUserName();
      localObject = this.mkz;
      Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow supportAnalyze:%s supportShow:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aHK(str2)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aHL(str2)) });
      locald.JkC = ((View)localObject);
      locald.content = paramString;
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aHK(str2))
      {
        if ((Util.isNullOrNil(paramString)) || (paramString.equals(locald.Jkr))) {
          break label342;
        }
        com.tencent.threadpool.h.ahAA.bFQ("GroupSolitaireCheck");
        localObject = MMFlexEditText.afWC;
        paramString = paramString.replaceAll(String.valueOf(MMFlexEditText.jFn()), "");
      }
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.emoji.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.a.class)).anH(paramString);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "checkIfShow() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    locald.Jkz.setContent(paramString);
    locald.Jkz.aHX(locald.JjU);
    com.tencent.threadpool.h.ahAA.a(locald.Jkz, 500L, "GroupSolitaireCheck");
    Object localObject = paramString;
    if (Util.isNullOrNil(locald.Jkr))
    {
      locald.JkA.setContent(paramString);
      locald.JkA.aHX(locald.JjU);
      com.tencent.threadpool.h.ahAA.a(locald.JkA, 500L, "GroupSolitaireCopyCheck");
    }
    label342:
    String str1;
    for (localObject = paramString;; str1 = paramString)
    {
      locald.Jkr = ((String)localObject);
      locald.JjU = str2;
      AppMethodBeat.o(31675);
      return;
      if (Util.isNullOrNil(paramString)) {
        locald.fJF();
      }
    }
  }
  
  public final void by(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31602);
    if (this.YfD.Yjr.containsKey(paramString1)) {}
    Object localObject;
    for (paramString1 = (LinkedList)this.YfD.Yjr.get(paramString1);; paramString1 = (String)localObject)
    {
      localObject = new HashMap(1);
      ((HashMap)localObject).put(paramString3, paramString2);
      paramString1.add(localObject);
      AppMethodBeat.o(31602);
      return;
      localObject = new LinkedList();
      this.YfD.Yjr.put(paramString1, localObject);
    }
  }
  
  public final void cu(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(31625);
    awF(paramInt);
    awG(paramInt);
    switch (paramInt)
    {
    default: 
      setVisibility(0);
      AppMethodBeat.o(31625);
      return;
    case 1: 
      if (paramBoolean)
      {
        JX(true);
        showVKB();
        if (this.Rqt.length() > 0) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          yk(paramBoolean);
          AppMethodBeat.o(31625);
          return;
        }
      }
      if (this.Rqt.length() > 0) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        yk(paramBoolean);
        AppMethodBeat.o(31625);
        return;
      }
    }
    s(0, true, -1);
    yk(false);
    AppMethodBeat.o(31625);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(31578);
    if (this.moD != null)
    {
      Log.i("MicroMsg.ChatFooter", "jacks chat footer destroy smiley panel");
      this.moD.iKg();
      this.moD.destroy();
      this.moD.animate().cancel();
      this.moD = null;
    }
    if (this.Yab != null)
    {
      this.Yab.destroy();
      this.Yab = null;
      this.Yae = false;
    }
    if (this.YfA != null) {
      this.YfA.release();
    }
    if (this.Yfy != null)
    {
      this.Yfy.IqP = null;
      this.Yfy.Ykx = null;
      this.Yfy.hide();
    }
    if (this.SOn != null)
    {
      if (this.YgF != null) {
        this.YgF.getBlurController().destroy();
      }
      if (this.YgV != null) {
        this.YgV.getBlurController().destroy();
      }
    }
    Log.i("MicroMsg.ChatFooter", "jacks destroy chat footer.");
    this.Rqt.destroy();
    AppMethodBeat.o(31578);
  }
  
  public final void dwb()
  {
    AppMethodBeat.i(31610);
    this.Yha.setExitType(1);
    this.Yfd.setEnabled(false);
    this.Yfd.setBackgroundResource(R.g.record_shape_disable);
    if (this.Yhg)
    {
      this.Yhi.update();
      this.xxY.sendEmptyMessageDelayed(0, 500L);
      AppMethodBeat.o(31610);
      return;
    }
    if (this.SOn != null)
    {
      this.AhK.setVisibility(0);
      this.YfM.setVisibility(8);
      this.SOq.setVisibility(8);
      this.SOn.update();
      this.YgZ.dismiss();
    }
    this.xxY.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(31610);
  }
  
  public final void fJI()
  {
    AppMethodBeat.i(31679);
    if (this.Rqt != null)
    {
      this.Rqt.setText("");
      iLW();
      if (this.moD != null) {
        this.moD.setToSendText("");
      }
    }
    AppMethodBeat.o(31679);
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163215);
    ArrayList localArrayList = this.Yfb.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163215);
    return localArrayList;
  }
  
  public String getAtSomebody()
  {
    return this.YfD.Yjp;
  }
  
  public int getBarGroupHeight()
  {
    AppMethodBeat.i(31585);
    if (this.YfO == null) {
      this.YfO = findViewById(R.h.fxP);
    }
    if (this.YfO != null)
    {
      i = this.YfO.getHeight();
      AppMethodBeat.o(31585);
      return i;
    }
    int i = getResources().getDimensionPixelSize(R.f.Edge_7A);
    AppMethodBeat.o(31585);
    return i;
  }
  
  public f getCallback()
  {
    return this.XYk;
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
  
  public ChatFooterPanel getChatFooterPanel()
  {
    return this.moD;
  }
  
  public int getCurrentScrollHeight()
  {
    return this.Yga;
  }
  
  public af.a getIOnToDoBarCallback()
  {
    return this.Ygn;
  }
  
  public bd.b getIOnTranslateResCallback()
  {
    return this.Ygp;
  }
  
  public int getInsertPos()
  {
    return this.YfD.Yjq;
  }
  
  public boolean getIsVoiceInputPanleShow()
  {
    return this.Yae;
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
    return this.YfD.Yjo;
  }
  
  public long getLastQuoteMsgId()
  {
    AppMethodBeat.i(31612);
    if ((this.Yfo.getTag() != null) && ((this.Yfo.getTag() instanceof cc)))
    {
      long l = ((cc)this.Yfo.getTag()).field_msgId;
      AppMethodBeat.o(31612);
      return l;
    }
    AppMethodBeat.o(31612);
    return 0L;
  }
  
  public String getLastText()
  {
    AppMethodBeat.i(31611);
    if (this.Rqt == null)
    {
      AppMethodBeat.o(31611);
      return "";
    }
    String str = this.Rqt.getText().toString();
    AppMethodBeat.o(31611);
    return str;
  }
  
  public int getMode()
  {
    return this.YfP;
  }
  
  public View getPanel()
  {
    return this.Yfg;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(31613);
    int i = this.Rqt.getSelectionStart();
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
    if (this.mjd == 0) {
      i = getHeight() - this.Ygg;
    }
    for (;;)
    {
      AppMethodBeat.o(31684);
      return i;
      int j = getHeight() - this.Ygg + getKeyBordHeightPX();
      i = j;
      if (this.Ygm != null) {
        i = j - this.Ygm.fJG();
      }
    }
  }
  
  public final void hN(String paramString, int paramInt)
  {
    AppMethodBeat.i(245945);
    if (paramInt == 2)
    {
      appendText("#" + paramString + " ");
      AppMethodBeat.o(245945);
      return;
    }
    appendText(paramString + " ");
    AppMethodBeat.o(245945);
  }
  
  public final boolean hideVKB()
  {
    AppMethodBeat.i(31659);
    boolean bool;
    if (aw.jkS())
    {
      bool = Util.hideVKB(this);
      Log.i("MicroMsg.ChatFooter", "hideVKB status：%s, view:%s, stack:%s", new Object[] { Boolean.valueOf(bool), this, Util.getStack() });
      AppMethodBeat.o(31659);
      return bool;
    }
    if (getKeyBordHeightPX() / 2 <= getBottom())
    {
      bool = Util.hideVKB(this);
      AppMethodBeat.o(31659);
      return bool;
    }
    Log.i("MicroMsg.ChatFooter", "hideVKB failed!!!");
    AppMethodBeat.o(31659);
    return false;
  }
  
  public final int iB(String paramString, int paramInt)
  {
    AppMethodBeat.i(163213);
    int i = paramInt;
    if (this.YfD.Yjr.containsKey(paramString))
    {
      i = paramInt;
      if (((LinkedList)this.YfD.Yjr.get(paramString)).size() > 0) {
        i = paramInt | 0x1;
      }
    }
    paramInt = i;
    if (this.YfG)
    {
      if (this.YfI)
      {
        paramInt = 4;
        paramInt = i | paramInt;
      }
    }
    else
    {
      i = paramInt;
      if (this.YfH) {
        if (!this.YfI) {
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
  
  public final void iKM()
  {
    AppMethodBeat.i(31601);
    if (!this.Yae)
    {
      AppMethodBeat.o(31601);
      return;
    }
    this.Yae = false;
    if (this.Yab != null)
    {
      int i = getKeyBordHeightPX();
      int j = this.Yff.getHeight();
      this.Yab.animate().cancel();
      this.Yab.animate().translationY(i + j).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179768);
          if (ChatFooter.aH(ChatFooter.this) != null)
          {
            ChatFooter.aH(ChatFooter.this).destroy();
            ChatFooter.aH(ChatFooter.this).setVisibility(8);
          }
          AppMethodBeat.o(179768);
        }
      }).start();
    }
    this.Rqt.setText("");
    AppMethodBeat.o(31601);
  }
  
  public final void iKh()
  {
    AppMethodBeat.i(31591);
    this.YfT = true;
    if (this.moD != null) {
      this.moD.iKh();
    }
    AppMethodBeat.o(31591);
  }
  
  public final void iLX()
  {
    AppMethodBeat.i(245935);
    if (!Util.isNullOrNil(this.Rqt.getText()))
    {
      this.Rqt.setText("");
      if (this.moD != null) {
        this.moD.setToSendText("");
      }
    }
    JY(false);
    iLW();
    AppMethodBeat.o(245935);
  }
  
  public final void iLY()
  {
    AppMethodBeat.i(31581);
    if (!Util.isNullOrNil(this.Yfs.getText())) {
      this.Yfs.setText("");
    }
    this.Yft.setImageBitmap(null);
    this.Yfu.setImageDrawable(null);
    if (this.Yfo.getTag() != null) {
      this.Yfo.setTag(null);
    }
    this.Yft.setVisibility(8);
    this.Yfu.setVisibility(8);
    this.Yfo.setVisibility(8);
    AppMethodBeat.o(31581);
  }
  
  public final void iLZ()
  {
    AppMethodBeat.i(31583);
    if (this.Yfb == null)
    {
      AppMethodBeat.o(31583);
      return;
    }
    this.Yfb.iLz();
    AppMethodBeat.o(31583);
  }
  
  public final void iMA()
  {
    AppMethodBeat.i(31653);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245323);
        Log.i("MicroMsg.ChatFooter", "withLastText: ");
        ChatFooter.this.showVKB();
        ChatFooter.a(ChatFooter.this, true);
        AppMethodBeat.o(245323);
      }
    }, 500L);
    AppMethodBeat.o(31653);
  }
  
  public final void iMB()
  {
    AppMethodBeat.i(31655);
    if ((this.Yab != null) && (this.Yab.isShown())) {
      this.Yab.iNp();
    }
    AppMethodBeat.o(31655);
  }
  
  public final void iME()
  {
    AppMethodBeat.i(245941);
    if (this.Yfy != null)
    {
      this.Yfy.Yky = false;
      this.Yfy.hide();
    }
    AppMethodBeat.o(245941);
  }
  
  public final void iMF()
  {
    AppMethodBeat.i(31674);
    if (this.Yfz != null) {
      this.Yfz.fJF();
    }
    AppMethodBeat.o(31674);
  }
  
  public final boolean iMG()
  {
    AppMethodBeat.i(31677);
    if ((this.Yfo.getTag() != null) && ((this.Yfo.getTag() instanceof cc)) && (this.Yfn.isShown()) && (this.Yfo.isShown()))
    {
      AppMethodBeat.o(31677);
      return true;
    }
    AppMethodBeat.o(31677);
    return false;
  }
  
  public final void iMH()
  {
    AppMethodBeat.i(31681);
    this.Yfd.setBackgroundResource(R.g.input_bg);
    this.Yfd.setText(R.l.chatfooter_presstorcd);
    Object localObject;
    if (this.Yhg)
    {
      if (!this.YiG)
      {
        this.YiG = true;
        if (this.YfA == null) {
          break label299;
        }
        this.Yha.TUh = this.YfA.aHd();
        if ((this.Yhi == null) || (!this.Yhi.isShowing())) {
          break label299;
        }
        if (e.Yjt == this.YiU)
        {
          this.YhU = false;
          this.YfA.gab();
          this.Yha.setExitType(2);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adfR, Boolean.FALSE);
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        AppMethodBeat.o(31681);
        return;
      }
      if (e.Yju == this.YiU)
      {
        if (this.YiF <= 0) {
          this.YiF = ((int)this.YfA.aHd());
        }
        if (!Util.isNullOrNil(this.YfA.getFileName()))
        {
          localObject = com.tencent.mm.cj.a.adtq;
          com.tencent.mm.cj.a.a.bzD(this.YfA.getFileName());
        }
        this.YfA.fZZ();
        iNa();
        this.TWg.sendEmptyMessageDelayed(5000, 5000L);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adfR, Boolean.FALSE);
        AppMethodBeat.o(31681);
        return;
      }
      if (e.Yjs == this.YiU)
      {
        this.YhU = false;
        this.YfA.fZY();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adfQ, Boolean.FALSE);
      }
      label299:
      AppMethodBeat.o(31681);
      return;
    }
    this.xxL = false;
    if (this.YfA != null)
    {
      this.Yha.TUh = this.YfA.aHd();
      if (this.YfQ)
      {
        if (k.YjJ != this.Yhd)
        {
          this.YiE = true;
          if ((this.SOn != null) && (this.SOn.isShowing()))
          {
            if (k.YjL == this.Yhd)
            {
              Log.i("MicroMsg.ChatFooter", "do not send voice.");
              this.Yha.setExitType(2);
              this.YfA.gab();
              AppMethodBeat.o(31681);
              return;
            }
            Log.i("MicroMsg.ChatFooter", "trans voice to txt.");
            this.YfA.fZZ();
            localObject = this.YfA.getFileName();
            final long l = this.YfA.aHd();
            Log.i("transvoice", "fileName: %s, voiceLen: %d.", new Object[] { localObject, Long.valueOf(l) });
            if (NetStatusUtil.isConnected(getContext()))
            {
              if (this.YgY.isValid())
              {
                this.YgW.beR((String)localObject);
                this.YgW.TVY = l;
                this.YgW.talker = this.Yfa;
                this.YgW.show();
                this.YgW.c(this.YgY);
                this.Ygc = false;
                AppMethodBeat.o(31681);
                return;
              }
              this.Yha.setExitType(3);
              locala = new e.a(getContext());
              locala.bDw(getResources().getString(R.l.gXU));
              locala.bDC(getResources().getString(R.l.gXV));
              locala.aET(getResources().getColor(R.e.Link_100));
              locala.c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(245314);
                  ChatFooter.k(ChatFooter.this).aKV(this.val$fileName);
                  AppMethodBeat.o(245314);
                }
              });
              locala.NC(false);
              locala.jHH().show();
              AppMethodBeat.o(31681);
              return;
            }
            this.Yha.setExitType(4);
            e.a locala = new e.a(getContext());
            locala.bDw(getResources().getString(R.l.gOz));
            locala.bDC(getResources().getString(R.l.gOB));
            locala.aET(getResources().getColor(R.e.Link_100));
            locala.bDD(getResources().getString(R.l.gOA));
            locala.c(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(245309);
                ChatFooter.k(ChatFooter.this).fN(this.val$fileName, (int)l);
                AppMethodBeat.o(245309);
              }
            });
            locala.d(new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(245441);
                ChatFooter.k(ChatFooter.this).aKV(this.val$fileName);
                AppMethodBeat.o(245441);
              }
            });
            locala.jHH().show();
            AppMethodBeat.o(31681);
          }
        }
        else
        {
          this.YfA.fZY();
          AppMethodBeat.o(31681);
        }
      }
      else
      {
        if ((this.AhN != null) && (this.AhN.getVisibility() == 0))
        {
          this.Yha.setExitType(2);
          this.YfA.gab();
          AppMethodBeat.o(31681);
          return;
        }
        this.YfA.fZY();
      }
    }
    AppMethodBeat.o(31681);
  }
  
  public final void iMI()
  {
    AppMethodBeat.i(31683);
    bh.bCz();
    this.Ygu = ((Boolean)com.tencent.mm.model.c.ban().d(66832, Boolean.FALSE)).booleanValue();
    if (this.Rqt != null) {
      this.Rqt.setEnableSendBtn(this.Ygu);
    }
    AppMethodBeat.o(31683);
  }
  
  public final boolean iMJ()
  {
    AppMethodBeat.i(245943);
    if ((this.Ygv != null) && (this.Ygv.iNh() != null))
    {
      if ((!((com.tencent.mm.ui.chatting.component.api.i)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.i.class)).jrA()) && (!((com.tencent.mm.ui.chatting.component.api.r)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.r.class)).jrT()) && (!((com.tencent.mm.ui.chatting.component.api.k)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.k.class)).jrF()))
      {
        AppMethodBeat.o(245943);
        return true;
      }
      AppMethodBeat.o(245943);
      return false;
    }
    AppMethodBeat.o(245943);
    return true;
  }
  
  public final void iMK()
  {
    AppMethodBeat.i(31685);
    if ((this.mkz == null) || (this.mkz.getVisibility() == 8))
    {
      AppMethodBeat.o(31685);
      return;
    }
    if (this.YiK == 0)
    {
      this.YiK = this.mkz.getWidth();
      this.YiL = this.Yfi.getWidth();
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.YiK, this.YiL });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(245440);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.j(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.j(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bD(ChatFooter.this)) / (ChatFooter.bE(ChatFooter.this) - ChatFooter.bD(ChatFooter.this));
        ChatFooter.j(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(245440);
      }
    });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(245450);
        ChatFooter.j(ChatFooter.this).setVisibility(8);
        AppMethodBeat.o(245450);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(245446);
        Log.d("MicroMsg.ChatFooter", "onAnimationEnd()");
        if (!ChatFooter.bF(ChatFooter.this))
        {
          ChatFooter.j(ChatFooter.this).setVisibility(8);
          AppMethodBeat.o(245446);
          return;
        }
        Log.i("MicroMsg.ChatFooter", "animHideSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bF(ChatFooter.this)) });
        ChatFooter.this.iML();
        AppMethodBeat.o(245446);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(245443);
        Log.d("MicroMsg.ChatFooter", "onAnimationStart: ");
        ChatFooter.j(ChatFooter.this).setVisibility(0);
        AppMethodBeat.o(245443);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.start();
    AppMethodBeat.o(31685);
  }
  
  public final void iML()
  {
    AppMethodBeat.i(31686);
    if (this.mkz == null)
    {
      AppMethodBeat.o(31686);
      return;
    }
    if (this.YiK == 0)
    {
      this.YiK = this.mkz.getWidth();
      this.YiL = this.Yfi.getWidth();
    }
    if (this.YiK == 0)
    {
      this.mkz.startAnimation(this.Ygw);
      this.mkz.setVisibility(0);
      AppMethodBeat.o(31686);
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { this.YiL, this.YiK });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(245444);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramAnonymousValueAnimator = ChatFooter.j(ChatFooter.this).getLayoutParams();
        paramAnonymousValueAnimator.width = i;
        ChatFooter.j(ChatFooter.this).setLayoutParams(paramAnonymousValueAnimator);
        float f = (i - ChatFooter.bD(ChatFooter.this)) / (ChatFooter.bE(ChatFooter.this) - ChatFooter.bD(ChatFooter.this));
        ChatFooter.j(ChatFooter.this).setAlpha(f);
        AppMethodBeat.o(245444);
      }
    });
    localValueAnimator.setDuration(150L);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(245451);
        ChatFooter.j(ChatFooter.this).setVisibility(0);
        ChatFooter.D(ChatFooter.this).setVisibility(8);
        ChatFooter.l(ChatFooter.this, false);
        AppMethodBeat.o(245451);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(245448);
        paramAnonymousAnimator = ChatFooter.j(ChatFooter.this).getLayoutParams();
        paramAnonymousAnimator.width = -2;
        ChatFooter.j(ChatFooter.this).setLayoutParams(paramAnonymousAnimator);
        ChatFooter.D(ChatFooter.this).setVisibility(8);
        ChatFooter.l(ChatFooter.this, false);
        if (!ChatFooter.bF(ChatFooter.this))
        {
          Log.i("MicroMsg.ChatFooter", "animShowSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.bF(ChatFooter.this)) });
          ChatFooter.D(ChatFooter.this).setVisibility(0);
          ChatFooter.l(ChatFooter.this, true);
          ChatFooter.this.iMK();
        }
        ChatFooter.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(245424);
            ChatFooter.b(ChatFooter.this).getSizeAnimController().Lw(true);
            AppMethodBeat.o(245424);
          }
        });
        AppMethodBeat.o(245448);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(245442);
        ChatFooter.j(ChatFooter.this).setVisibility(0);
        ChatFooter.b(ChatFooter.this).getSizeAnimController().Lw(false);
        AppMethodBeat.o(245442);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(31686);
  }
  
  public final void iMM()
  {
    AppMethodBeat.i(245944);
    if ((this.Yfi != null) && (this.Yfi.getVisibility() == 0))
    {
      Kd(true);
      AppMethodBeat.o(245944);
      return;
    }
    AppMethodBeat.o(245944);
  }
  
  public final void iMa()
  {
    AppMethodBeat.i(31587);
    this.Yfk = ((ImageButton)this.hDw.findViewById(R.h.fAe));
    this.Yfk.setVisibility(0);
    if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acWV, true)) {
      this.hDw.findViewById(R.h.fAf).setVisibility(0);
    }
    for (;;)
    {
      this.hDw.findViewById(R.h.fAf).setVisibility(8);
      this.Yfk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(245385);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = com.tencent.mm.emoji.d.b.mmj;
          com.tencent.mm.emoji.d.b.aVY();
          if (ChatFooter.k(ChatFooter.this) != null) {
            ChatFooter.k(ChatFooter.this).gae();
          }
          if (ChatFooter.d(ChatFooter.this) == 2) {
            ChatFooter.this.showVKB();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245385);
            return;
            if (ChatFooter.E(ChatFooter.this)) {
              ChatFooter.this.iKh();
            }
            ChatFooter.this.iMe();
            if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acWV, false))
            {
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acWV, Boolean.TRUE);
              ChatFooter.F(ChatFooter.this).findViewById(R.h.fAf).setVisibility(8);
            }
          }
        }
      });
      if (this.Yfy != null) {
        this.Yfy.Ykw = this.Yfk;
      }
      if (this.Yfz != null) {
        this.Yfz.Jko = this.hDw;
      }
      AppMethodBeat.o(31587);
      return;
      this.hDw.findViewById(R.h.fAf).setVisibility(8);
    }
  }
  
  public final void iMc()
  {
    boolean bool = true;
    AppMethodBeat.i(31590);
    if ((e.Ykf == null) || (getContext() == null))
    {
      if (getContext() == null)
      {
        Log.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", new Object[] { Util.getStack() });
        this.moD = new d(MMApplicationContext.getContext());
        AppMethodBeat.o(31590);
        return;
      }
      this.moD = new d(getContext());
      AppMethodBeat.o(31590);
      return;
    }
    if (this.moD != null) {
      this.moD.destroy();
    }
    this.moD = e.Ykf.fZ(getContext());
    ChatFooterPanel localChatFooterPanel;
    if (this.moD != null)
    {
      this.moD.setShowSearch(true);
      this.moD.setEntranceScene(ChatFooterPanel.XYm);
      this.moD.setVisibility(8);
      this.moD.setFooterType(this.Wqp);
      if (this.Yfg != null) {
        this.Yfg.addView(this.moD, -1, -1);
      }
      this.moD.setOnTextOperationListener(this.YhV);
      localChatFooterPanel = this.moD;
      if (this.Rqt.getText().length() <= 0) {
        break label279;
      }
    }
    for (;;)
    {
      localChatFooterPanel.setSendButtonEnable(bool);
      if (this.Ygv != null) {
        this.moD.setTalkerName(this.Ygv.getTalkerUserName());
      }
      this.moD.onResume();
      if (this.YfT) {
        iKh();
      }
      setSmileyPanelCallback(this.XYk);
      AppMethodBeat.o(31590);
      return;
      label279:
      bool = false;
    }
  }
  
  public final void iMe()
  {
    AppMethodBeat.i(31597);
    this.YfP = 1;
    JZ(true);
    if (this.Rqt.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      yk(bool);
      this.Yfd.setVisibility(8);
      awC(R.g.fnr);
      if (this.Yab != null)
      {
        this.Yab.setVisibility(8);
        this.Yae = false;
        this.Yab.reset();
      }
      s(2, true, -1);
      AppMethodBeat.o(31597);
      return;
    }
  }
  
  public final void iMh()
  {
    AppMethodBeat.i(31620);
    if (this.Yhg)
    {
      this.Yhn.setVisibility(0);
      this.YhR.setVisibility(8);
      AppMethodBeat.o(31620);
      return;
    }
    this.SOq.setVisibility(8);
    this.YfM.setVisibility(0);
    AppMethodBeat.o(31620);
  }
  
  public final void iMi()
  {
    AppMethodBeat.i(31626);
    JZ(true);
    this.Yfe.setVisibility(8);
    this.Yfd.setVisibility(8);
    AppMethodBeat.o(31626);
  }
  
  public final void iMj()
  {
    AppMethodBeat.i(31627);
    if (this.Yfe != null) {
      this.Yfe.setVisibility(0);
    }
    AppMethodBeat.o(31627);
  }
  
  public final void iMk()
  {
    AppMethodBeat.i(31628);
    AppPanel localAppPanel = this.Yfb;
    localAppPanel.YdH.Yee.value = false;
    localAppPanel.iLL();
    AppMethodBeat.o(31628);
  }
  
  public final void iMl()
  {
    AppMethodBeat.i(31629);
    AppPanel localAppPanel = this.Yfb;
    localAppPanel.YdH.Yew.value = false;
    localAppPanel.iLL();
    AppMethodBeat.o(31629);
  }
  
  public final void iMm()
  {
    AppMethodBeat.i(31630);
    AppPanel localAppPanel = this.Yfb;
    localAppPanel.YdH.Yef.value = false;
    localAppPanel.iLL();
    AppMethodBeat.o(31630);
  }
  
  public final void iMn()
  {
    AppMethodBeat.i(31631);
    AppPanel localAppPanel = this.Yfb;
    localAppPanel.YdH.Yei.value = false;
    localAppPanel.iLL();
    AppMethodBeat.o(31631);
  }
  
  public final void iMo()
  {
    AppMethodBeat.i(31635);
    AppPanel localAppPanel = this.Yfb;
    localAppPanel.YdP = true;
    localAppPanel.YdH.JT(false);
    localAppPanel.iLL();
    Log.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(31635);
  }
  
  public final void iMp()
  {
    this.Yfb.YdS = true;
  }
  
  public final void iMq()
  {
    AppMethodBeat.i(31636);
    AppPanel localAppPanel = this.Yfb;
    localAppPanel.YdQ = true;
    localAppPanel.YdH.JQ(false);
    localAppPanel.iLL();
    Log.i("MicroMsg.AppPanel", "disableServiceRemittance %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(31636);
  }
  
  public final void iMr()
  {
    AppMethodBeat.i(245938);
    this.Yfb.iLC();
    AppMethodBeat.o(245938);
  }
  
  public final void iMs()
  {
    AppMethodBeat.i(245939);
    AppPanel localAppPanel = this.Yfb;
    localAppPanel.YdH.Yeg.value = false;
    localAppPanel.iLL();
    AppMethodBeat.o(245939);
  }
  
  public final void iMt()
  {
    AppMethodBeat.i(31637);
    if (this.Yfk != null) {
      this.Yfk.setVisibility(8);
    }
    AppMethodBeat.o(31637);
  }
  
  public final void iMu()
  {
    AppMethodBeat.i(31638);
    AppPanel localAppPanel = this.Yfb;
    localAppPanel.YdR = true;
    localAppPanel.YdH.JU(false);
    localAppPanel.iLL();
    AppMethodBeat.o(31638);
  }
  
  public final void iMv()
  {
    AppMethodBeat.i(31639);
    Log.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
    this.YfS = true;
    this.Rqt.setImeOptions(4);
    this.Rqt.setInputType(this.Rqt.getInputType() & 0xFFFFFFBF);
    AppMethodBeat.o(31639);
  }
  
  public final boolean iMy()
  {
    AppMethodBeat.i(31645);
    if ((this.Fgt == null) || (this.Fgt.getView() == null))
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Object localObject = this.Fgt.getView().findViewById(R.h.mm_content_fl);
    if (localObject == null)
    {
      AppMethodBeat.o(31645);
      return false;
    }
    Rect localRect = new Rect();
    ((View)localObject).getGlobalVisibleRect(localRect);
    if (com.tencent.mm.compatible.util.d.rb(28))
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
  
  public final boolean iMz()
  {
    return this.mjd != 0;
  }
  
  public final boolean iNb()
  {
    AppMethodBeat.i(185416);
    if ((this.Yhi != null) && (this.Yhi.isShowing()))
    {
      AppMethodBeat.o(185416);
      return true;
    }
    AppMethodBeat.o(185416);
    return false;
  }
  
  public final void kO(View paramView)
  {
    int i = -1;
    AppMethodBeat.i(163212);
    if (this.YfA != null) {
      this.YfA.gaf();
    }
    Log.i("MicroMsg.ChatFooter", "click attach btn: %s, %s", new Object[] { Integer.valueOf(this.Yfb.getVisibility()), Boolean.valueOf(this.Yfg.iNi()) });
    if (this.mjd == 3)
    {
      if (this.YfP == 1)
      {
        showVKB();
        AppMethodBeat.o(163212);
        return;
      }
      s(0, true, -1);
      AppMethodBeat.o(163212);
      return;
    }
    Object localObject;
    if (paramView == null)
    {
      s(3, true, i);
      if ((this.Yab != null) && (this.Yab.getVisibility() == 0) && (this.Yae))
      {
        Log.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
        this.Yab.setVisibility(8);
        this.Yae = false;
        this.Yab.reset();
      }
      paramView = com.tencent.mm.pluginsdk.model.app.at.iIM();
      localObject = MMApplicationContext.getContext();
      if ((com.tencent.mm.kernel.h.baz()) && (localObject != null)) {
        break label278;
      }
      label187:
      com.tencent.mm.pluginsdk.model.app.at.iIM().lu(MMApplicationContext.getContext());
      if (au.bwG(this.toUser))
      {
        paramView = this.toUser;
        if (!ab.Jf(paramView)) {
          break label524;
        }
        i = 2;
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject = new com.tencent.mm.autogen.mmdata.rpt.at();
        ((com.tencent.mm.autogen.mmdata.rpt.at)localObject).kH(paramView);
        ((com.tencent.mm.autogen.mmdata.rpt.at)localObject).ila = 1L;
        ((com.tencent.mm.autogen.mmdata.rpt.at)localObject).ips = i;
        ((com.tencent.mm.autogen.mmdata.rpt.at)localObject).bMH();
        AppMethodBeat.o(163212);
        return;
        if (paramView.getTag() == null) {
          break;
        }
        i = ((Integer)paramView.getTag()).intValue();
        break;
        try
        {
          label278:
          String str = com.tencent.mm.k.i.aRC().getValue("ShowAPPSuggestion");
          if ((Util.isNullOrNil(str)) || (Integer.valueOf(str).intValue() != 1)) {
            Log.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[] { str });
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[] { localException.getMessage() });
          if (paramView.XTD)
          {
            Log.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
            break label187;
          }
          Log.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
          paramView.XTD = true;
          if (System.currentTimeMillis() - paramView.XTG < 43200000L)
          {
            Log.d("MicroMsg.SuggestionAppListLogic", "not now");
            paramView.XTD = false;
            break label187;
          }
          com.tencent.mm.kernel.h.baF();
          paramView.XTG = com.tencent.mm.kernel.h.baE().ban().amW(352275);
          if (System.currentTimeMillis() - paramView.XTG < 43200000L)
          {
            Log.w("MicroMsg.SuggestionAppListLogic", "not now sp");
            paramView.XTD = false;
            break label187;
          }
          if (paramView.lang == null) {
            paramView.lang = LocaleUtil.loadApplicationLanguage(((Context)localObject).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), (Context)localObject);
          }
          paramView = new com.tencent.mm.pluginsdk.model.app.aj(paramView.lang, new LinkedList());
          com.tencent.mm.plugin.openapi.a.gxq();
          com.tencent.mm.pluginsdk.model.app.e.a(4, paramView);
        }
      }
      break label187;
      label524:
      if (ab.Je(paramView)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(31579);
    super.onAttachedToWindow();
    iMD();
    iMC();
    awJ(getKeyBordHeightPX());
    AppMethodBeat.o(31579);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31643);
    super.onConfigurationChanged(paramConfiguration);
    if (com.tencent.mm.compatible.util.d.rb(24)) {
      this.Ygb = ((Activity)getContext()).isInMultiWindowMode();
    }
    if (paramConfiguration.orientation == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.YfV = bool;
      s(0, false, -1);
      iMD();
      Log.i("MicroMsg.ChatFooter", "onConfigurationChanged: %s, %s, %s", new Object[] { paramConfiguration, Boolean.valueOf(this.YfV), Boolean.valueOf(this.Ygb) });
      awJ(getKeyBordHeightPX());
      paramConfiguration = com.tencent.mm.plugin.patmsg.ui.b.MHL;
      paramConfiguration = com.tencent.mm.plugin.patmsg.ui.b.gxN();
      if (paramConfiguration != null) {
        paramConfiguration.dismiss();
      }
      if (com.tencent.mm.ui.chatting.atsomeone.d.jBl()) {
        com.tencent.mm.ui.chatting.atsomeone.d.aDM();
      }
      AppMethodBeat.o(31643);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(31580);
    super.onDetachedFromWindow();
    this.lKz.close();
    this.YfX = null;
    this.YfY = false;
    AppMethodBeat.o(31580);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(245946);
    this.Rqt.jEJ();
    this.Ygd = false;
    showVKB();
    YfL = null;
    AppMethodBeat.o(245946);
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(31670);
    Log.i("MicroMsg.ChatFooter", "onKeyboardHeightChanged: %s, %s, %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(this.YfZ) });
    if (!this.Ygc)
    {
      AppMethodBeat.o(31670);
      return;
    }
    if ((this.Ygv != null) && (this.Ygv.iNh() != null)) {
      ((com.tencent.mm.ui.chatting.component.api.bd)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.bd.class)).aCq(paramInt);
    }
    Object localObject = this.Rqt;
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.widget.cedit.api.c)localObject).Ni(bool);
      if (!this.Ygd)
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        if (((ebg)com.tencent.mm.plugin.secdata.ui.a.a.c(getContext(), 4, ebg.class)).abgO != 1) {
          break label192;
        }
      }
      if (paramInt > 0) {
        break;
      }
      this.HDO = false;
      AppMethodBeat.o(31670);
      return;
    }
    this.HDO = true;
    AppMethodBeat.o(31670);
    return;
    label192:
    if (com.tencent.mm.ui.f.a.jBl())
    {
      if (paramInt <= 0)
      {
        this.HDO = false;
        AppMethodBeat.o(31670);
        return;
      }
      this.HDO = true;
      AppMethodBeat.o(31670);
      return;
    }
    if ((this.Ygv != null) && (this.Ygv.iNh() != null) && (((com.tencent.mm.ui.chatting.component.api.bd)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.bd.class)).jup()))
    {
      if (paramInt <= 0)
      {
        this.HDO = false;
        AppMethodBeat.o(31670);
        return;
      }
      this.HDO = true;
      AppMethodBeat.o(31670);
      return;
    }
    int i;
    if ((this.Yhg) && (this.Yhi != null) && (this.Yhi.isShowing()))
    {
      if ((paramInt <= 0) || (w.mO(getContext())))
      {
        this.HDO = false;
        this.Yhm.setCursorVisible(false);
        this.Yhw.animate().translationY(0.0F).setDuration(200L).start();
        this.Yhl.animate().translationY(0.0F).setDuration(200L).start();
        this.Yho.animate().translationY(0.0F).setDuration(200L).start();
        this.Yhr.animate().translationY(0.0F).setDuration(200L).start();
        if (this.Yhl.getHeight() < this.Yit)
        {
          localObject = ValueAnimator.ofInt(new int[] { this.Yhl.getHeight(), this.Yit }).setDuration(200L);
          ((ValueAnimator)localObject).addUpdateListener(new ChatFooter.69(this));
          ((ValueAnimator)localObject).start();
          AppMethodBeat.o(31670);
        }
      }
      else
      {
        this.HDO = true;
        this.Yhm.setCursorVisible(true);
        Log.d("MicroMsg.ChatFooter", "height:%s, WeUIToolHelper.getDisplayRealSize(getContext()).y - newVoice2txtOpeArea.getBottom():%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.ui.bf.bf(getContext()).y - this.Yhw.getBottom()) });
        i = com.tencent.mm.ui.bf.bf(getContext()).y;
        localObject = new int[2];
        this.Yhw.getLocationOnScreen((int[])localObject);
        j = localObject[1];
        int k = this.Yhw.getHeight();
        int m = com.tencent.mm.ui.bf.bk(getContext());
        this.Yhw.animate().translationY(-(paramInt - (i - (j + k)) + m)).setDuration(200L).start();
        paramInt = i - (this.Yhw.getHeight() + paramInt) - com.tencent.mm.ui.bd.fromDPToPix(getContext(), 24);
        i = this.Yhl.getHeight() + this.Yho.getHeight() + com.tencent.mm.ui.bd.fromDPToPix(getContext(), 48);
        Log.d("MicroMsg.ChatFooter", "leftSpcaeDown:%s, editDown:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        this.Yis = (paramInt - com.tencent.mm.ui.bd.fromDPToPix(getContext(), 52));
        if (this.Yis < this.Yil)
        {
          Log.i("MicroMsg.ChatFooter", "invalid maxHeightWhenKeyboard, value:%s", new Object[] { Integer.valueOf(this.Yis) });
          this.Yis = this.Yil;
        }
        this.Yit = this.Yhl.getHeight();
        localObject = new int[2];
        this.Yho.getLocationOnScreen((int[])localObject);
        j = localObject[1] + this.Yho.getHeight();
        if (j > paramInt)
        {
          j -= paramInt;
          if (i > paramInt)
          {
            k = this.Yhl.getLayoutParams().height;
            localObject = ValueAnimator.ofInt(new int[] { k, k - (i - paramInt) }).setDuration(200L);
            ((ValueAnimator)localObject).addUpdateListener(new ChatFooter.70(this));
            ((ValueAnimator)localObject).start();
          }
          this.Yhl.animate().translationY(-j).setDuration(200L).start();
          this.Yho.animate().translationY(-j).setDuration(200L).start();
          this.Yhr.animate().translationY(-j).setDuration(200L).start();
        }
      }
      AppMethodBeat.o(31670);
      return;
    }
    if ((!this.Ygb) && (this.YfV))
    {
      if (this.Ygf == paramBoolean) {
        break label1073;
      }
      i = 1;
      this.Ygf = paramBoolean;
      if (paramInt <= 0) {
        break label1133;
      }
      if (this.sNb == paramInt) {
        break label1205;
      }
      this.sNb = paramInt;
      com.tencent.mm.compatible.util.j.H(getContext(), paramInt);
      awJ(paramInt);
    }
    label1073:
    label1205:
    for (paramInt = 1;; paramInt = 0)
    {
      if (!this.HDO)
      {
        t(1, true, -1);
        this.YfW = -1;
      }
      while ((paramInt == 0) && (i == 0))
      {
        this.HDO = true;
        if (this.YfA != null) {
          this.YfA.yp(this.HDO);
        }
        AppMethodBeat.o(31670);
        return;
        i = 0;
        break;
      }
      this.Yga = this.sNb;
      i = this.Yga;
      if (this.Ygm == null) {}
      for (paramInt = j;; paramInt = this.Ygm.fJG())
      {
        c(i, true, 1, paramInt);
        break;
      }
      label1133:
      if (this.HDO)
      {
        if (this.YfW == -1) {
          break label1195;
        }
        t(this.YfW, true, -1);
        this.YfW = -1;
      }
      for (;;)
      {
        if (this.mjd == 1)
        {
          Log.i("MicroMsg.ChatFooter", "keyboard not open");
          t(0, true, -1);
        }
        this.HDO = false;
        break;
        t(0, true, -1);
      }
    }
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
    this.cqi = false;
    if ((this.YfZ == 48) && (this.mjd == 1) && (!this.Ygk))
    {
      this.HDO = false;
      t(0, true, -1);
    }
    this.lKz.close();
    if (this.moD != null) {
      this.moD.onPause();
    }
    if ((this.Yae) && (this.Yab != null)) {
      this.Yab.pause();
    }
    if (this.YfA != null) {
      this.YfA.onPause();
    }
    if (this.Yfy != null) {
      this.Yfy.hide();
    }
    if ((this.SOn != null) && (this.SOn.isShowing())) {
      this.SOn.dismiss();
    }
    iMF();
    this.Rqt.onPause();
    this.lAx.dead();
    ((com.tencent.mm.plugin.musicchat.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.musicchat.a.a.class)).onExitChat();
    AppMethodBeat.o(31577);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31672);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(31672);
  }
  
  public final void pn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(245936);
    this.hQQ = paramString1;
    this.toUser = paramString2;
    if (this.Rqt != null) {
      if (!au.bwE(paramString2)) {
        break label73;
      }
    }
    label73:
    for (int i = 2;; i = 1)
    {
      this.Rqt.getInputExtras(true).putInt("wechat_scene", i);
      this.Rqt.getInputExtras(true).putBoolean("if_support_wx_emoji", true);
      AppMethodBeat.o(245936);
      return;
    }
  }
  
  public final HashMap<String, String> po(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31603);
    long l = System.currentTimeMillis();
    if (Util.isNullOrNil(paramString2))
    {
      if (this.YfD.Yjr.containsKey(paramString1)) {
        this.YfD.Yjr.remove(paramString1);
      }
      AppMethodBeat.o(31603);
      return null;
    }
    if ((!this.YfD.Yjr.containsKey(paramString1)) || (((LinkedList)this.YfD.Yjr.get(paramString1)).size() <= 0))
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
      ((LinkedList)this.YfD.Yjr.get(paramString1)).clear();
      AppMethodBeat.o(31603);
      return null;
    }
    paramString1 = (LinkedList)this.YfD.Yjr.get(paramString1);
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      Log.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", new Object[] { Integer.valueOf(paramString1.size()) });
      paramString2 = new LinkedList();
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label374;
        }
        String str = (String)((Iterator)localObject).next();
        Iterator localIterator = paramString1.iterator();
        if (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          if (!localHashMap.containsKey(str)) {
            break;
          }
          paramString2.add((String)localHashMap.get(str));
        }
      }
      label374:
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
  
  public final void s(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(163217);
    Log.i("MicroMsg.ChatFooter", "configPanel: %s, %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.HDO), Boolean.valueOf(this.Ygb), Boolean.valueOf(this.YfV) });
    int i;
    int j;
    label98:
    int k;
    if ((this.Ygb) || (!this.YfV))
    {
      i = 1;
      if ((paramInt1 != 1) || (this.HDO)) {
        break label199;
      }
      j = 1;
      if ((paramInt1 == 1) || (!this.HDO)) {
        break label205;
      }
      k = 1;
      label113:
      if ((i == 0) && ((j != 0) || (k != 0))) {
        break label211;
      }
      t(paramInt1, paramBoolean, paramInt2);
      label135:
      if (j != 0)
      {
        this.Yge = 0;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(185809);
            ChatFooter.a(ChatFooter.this, true);
            ChatFooter.this.setToSendTextColor(true);
            boolean bool = ChatFooter.aX(ChatFooter.this).showSoftInput(ChatFooter.b(ChatFooter.this).jEG(), 0);
            ChatFooter.by(ChatFooter.this);
            Log.i("MicroMsg.ChatFooter", "showSoftInput %b, %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(ChatFooter.bz(ChatFooter.this)) });
            if ((!bool) && (ChatFooter.bz(ChatFooter.this) < 10)) {
              ChatFooter.this.postDelayed(this, 100L);
            }
            AppMethodBeat.o(185809);
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
      this.HDO = paramBoolean;
      AppMethodBeat.o(163217);
      return;
      i = 0;
      break;
      j = 0;
      break label98;
      k = 0;
      break label113;
      this.YfW = paramInt1;
      break label135;
    }
  }
  
  public void setAppPanelListener(AppPanel.a parama)
  {
    AppMethodBeat.i(31649);
    this.Yfb.setAppPanelListener(parama);
    AppMethodBeat.o(31649);
  }
  
  public void setAppPanelTip(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(31595);
    if ((this.Yfh == null) || (this.Yfb == null))
    {
      AppMethodBeat.o(31595);
      return;
    }
    this.Yfh.setText(paramCharSequence);
    if (!Util.isNullOrNil(paramCharSequence)) {
      if (this.Yfb.getVisibility() != 0) {
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
    if (this.Yfh == null)
    {
      AppMethodBeat.o(31596);
      return;
    }
    if (TextUtils.isEmpty(this.Yfh.getText()))
    {
      this.Yfh.setVisibility(8);
      AppMethodBeat.o(31596);
      return;
    }
    if (paramBoolean)
    {
      localObject = this.Yfh.getContext();
      i = this.Yfg.getHeight();
      int j = getKeyBordHeightPX();
      int k = com.tencent.mm.cd.a.fromDPToPix((Context)localObject, 32);
      localObject = this.Yfh.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (i - j + k);
        this.Yfh.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    Object localObject = this.Yfh;
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
    this.Yfb.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163214);
  }
  
  public void setAppPanelVisible(int paramInt)
  {
    AppMethodBeat.i(31642);
    if (this.Yfb != null) {
      this.Yfb.setVisibility(paramInt);
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
    this.YfD.Yjp = paramString;
  }
  
  public void setBottomPanelVisibility(int paramInt)
  {
    AppMethodBeat.i(31644);
    if (paramInt == 0) {
      this.Yfg.setVisibility(paramInt);
    }
    for (;;)
    {
      if ((this.Ygv != null) && (this.Ygv.iNh() != null) && (this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.j.class) != null)) {
        ((com.tencent.mm.ui.chatting.component.api.j)this.Ygv.iNh().cm(com.tencent.mm.ui.chatting.component.api.j.class)).aBR(paramInt);
      }
      AppMethodBeat.o(31644);
      return;
      s(0, true, -1);
    }
  }
  
  public void setCattingRootLayoutId(int paramInt)
  {
    this.YiJ = null;
    this.YiI = paramInt;
  }
  
  public void setDefaultSmileyByDetail(String paramString)
  {
    AppMethodBeat.i(31600);
    if (!Util.isNullOrNil(paramString))
    {
      if (this.moD == null) {
        iMc();
      }
      this.moD.setDefaultEmojiByDetail(paramString);
    }
    AppMethodBeat.o(31600);
  }
  
  public void setEditTextOnDragListener(View.OnDragListener paramOnDragListener)
  {
    AppMethodBeat.i(31647);
    this.Rqt.setOnDragListener(paramOnDragListener);
    AppMethodBeat.o(31647);
  }
  
  public void setExitType(int paramInt)
  {
    AppMethodBeat.i(185414);
    com.tencent.mm.plugin.transvoice.model.c.a locala = com.tencent.mm.plugin.transvoice.model.c.TUa;
    com.tencent.mm.plugin.transvoice.model.c.hPD().setExitType(paramInt);
    AppMethodBeat.o(185414);
  }
  
  public void setFooterEventListener(b paramb)
  {
    this.YfA = paramb;
  }
  
  public void setFooterStatus(boolean paramBoolean) {}
  
  public void setFooterType(int paramInt)
  {
    AppMethodBeat.i(31576);
    this.Wqp = paramInt;
    if (this.moD != null) {
      this.moD.setFooterType(paramInt);
    }
    AppMethodBeat.o(31576);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(245937);
    if (this.Rqt != null) {
      this.Rqt.setHint(paramCharSequence);
    }
    AppMethodBeat.o(245937);
  }
  
  public void setIOnTodoViewCallback(af.c paramc)
  {
    this.Ygm = paramc;
  }
  
  public void setIOnTranslateViewController(bq.d paramd)
  {
    this.Ygo = paramd;
  }
  
  public void setIgnoreScroll(Boolean paramBoolean)
  {
    AppMethodBeat.i(31661);
    this.Ygk = paramBoolean.booleanValue();
    AppMethodBeat.o(31661);
  }
  
  public void setInsertPos(int paramInt)
  {
    this.YfD.Yjq = paramInt;
  }
  
  public void setIsMultiWindow(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(31667);
    Log.i("MicroMsg.ChatFooter", "setIsMultiWindow: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.Ygb != paramBoolean) {}
    for (;;)
    {
      this.Ygb = paramBoolean;
      iMD();
      if (i != 0)
      {
        awJ(getKeyBordHeightPX());
        s(0, false, -1);
      }
      AppMethodBeat.o(31667);
      return;
      i = 0;
    }
  }
  
  public void setKeyboardShow(Boolean paramBoolean)
  {
    AppMethodBeat.i(31662);
    this.HDO = paramBoolean.booleanValue();
    AppMethodBeat.o(31662);
  }
  
  public void setLastContent(String paramString)
  {
    this.YfD.Yjo = paramString;
  }
  
  public void setLastQuoteMsgId(long paramLong)
  {
    AppMethodBeat.i(31605);
    if (paramLong != 0L)
    {
      Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramLong);
      if ((localObject == null) || ((((fi)localObject).jUq & 0x4) == 4) || (((cc)localObject).getType() == 10000))
      {
        if (localObject == null) {}
        for (localObject = "null";; localObject = ((cc)localObject).getType() + "," + (((fi)localObject).jUq & 0x4))
        {
          Log.e("MicroMsg.ChatFooter", "msg(%s) is revoked!", new Object[] { localObject });
          com.tencent.mm.ui.base.k.c(getContext(), getContext().getString(R.l.gOa), "", true);
          AppMethodBeat.o(31605);
          return;
        }
      }
      this.Yfo.setTag(localObject);
      AppMethodBeat.o(31605);
      return;
    }
    this.Yfo.setTag(null);
    AppMethodBeat.o(31605);
  }
  
  public void setLastText(String paramString)
  {
    AppMethodBeat.i(31606);
    F(paramString, -1, true);
    AppMethodBeat.o(31606);
  }
  
  public void setLbsMode(boolean paramBoolean)
  {
    this.YfF = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    AppMethodBeat.i(31623);
    cu(paramInt, true);
    AppMethodBeat.o(31623);
  }
  
  public void setOnEditFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(31648);
    this.Rqt.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(31648);
  }
  
  public void setOnFooterPanelSwitchListener(f paramf)
  {
    this.YfC = paramf;
  }
  
  public void setOnFooterSwitchListener(g paramg)
  {
    AppMethodBeat.i(31650);
    this.YfB = paramg;
    if (paramg == null)
    {
      AppMethodBeat.o(31650);
      return;
    }
    paramg = findViewById(R.h.fzq);
    paramg.setVisibility(0);
    paramg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(245333);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$62", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ChatFooter.bu(ChatFooter.this) != null) {
          ChatFooter.bu(ChatFooter.this).Ke(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$62", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245333);
      }
    });
    AppMethodBeat.o(31650);
  }
  
  public void setRecordNormalWording(String paramString)
  {
    AppMethodBeat.i(31618);
    if ((paramString == null) || (this.YfN == null))
    {
      AppMethodBeat.o(31618);
      return;
    }
    this.YfN.setText(paramString);
    AppMethodBeat.o(31618);
  }
  
  public void setSetTolastCustomPage(boolean paramBoolean) {}
  
  public void setSmileyPanelCallback(f paramf)
  {
    AppMethodBeat.i(31592);
    this.XYk = paramf;
    if (this.moD != null) {
      this.moD.setCallback(paramf);
    }
    AppMethodBeat.o(31592);
  }
  
  public void setSmileyPanelCallback2(j paramj)
  {
    this.Yfy.Ykx = paramj;
  }
  
  public void setSwitchButtonMode(int paramInt)
  {
    AppMethodBeat.i(31651);
    if (paramInt == this.Yiy)
    {
      AppMethodBeat.o(31651);
      return;
    }
    this.Yiy = paramInt;
    ImageView localImageView1 = (ImageView)findViewById(R.h.switch_btn);
    ImageView localImageView2 = (ImageView)findViewById(R.h.fSI);
    if (this.Yiy == 1)
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
    this.Ygs = paramc;
  }
  
  public void setToSendTextColor(final boolean paramBoolean)
  {
    AppMethodBeat.i(31652);
    if (com.tencent.mm.compatible.util.d.rb(11))
    {
      com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a()
      {
        public final void run()
        {
          AppMethodBeat.i(245334);
          Message localMessage = new Message();
          localMessage.what = 1002;
          localMessage.obj = Boolean.valueOf(paramBoolean);
          ChatFooter.bv(ChatFooter.this).sendMessage(localMessage);
          AppMethodBeat.o(245334);
        }
      });
      AppMethodBeat.o(31652);
      return;
    }
    if (paramBoolean)
    {
      this.Rqt.setTextColor(getResources().getColor(R.e.mm_edit_text_color));
      AppMethodBeat.o(31652);
      return;
    }
    this.Rqt.setTextColor(getResources().getColor(R.e.half_alpha_black));
    JX(false);
    AppMethodBeat.o(31652);
  }
  
  public void setUserName(String paramString)
  {
    AppMethodBeat.i(31682);
    this.Yfa = paramString;
    if (this.moD != null) {
      this.moD.setTalkerName(this.Yfa);
    }
    if (this.Yfb != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ChatFooter", "setusername: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (this.Yfb == null) {
        break label167;
      }
      if ((!ab.IV(this.Yfa)) && (!au.bws(this.Yfa))) {
        break;
      }
      this.Yfb.setServiceShowFlag(0);
      AppMethodBeat.o(31682);
      return;
    }
    if (ab.IS(this.Yfa))
    {
      this.Yfb.setServiceShowFlag(4);
      AppMethodBeat.o(31682);
      return;
    }
    if (au.bwE(this.Yfa))
    {
      this.Yfb.setServiceShowFlag(2);
      AppMethodBeat.o(31682);
      return;
    }
    this.Yfb.setServiceShowFlag(1);
    label167:
    AppMethodBeat.o(31682);
  }
  
  public void setVoice2txtCountDown(int paramInt)
  {
    AppMethodBeat.i(31619);
    if (-1 == paramInt)
    {
      this.YgH.setVisibility(0);
      this.YgJ.setVisibility(8);
      AppMethodBeat.o(31619);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 10))
    {
      if (8 == this.YgJ.getVisibility())
      {
        this.YgH.setVisibility(8);
        this.YgJ.setVisibility(0);
      }
      if (this.YgJ != null) {
        this.YgJ.setImageResource(this.Yij[paramInt]);
      }
    }
    AppMethodBeat.o(31619);
  }
  
  public void setVoiceInputShowCallback(d paramd)
  {
    this.Ygt = paramd;
  }
  
  public void setVoiceReactArea(int paramInt)
  {
    AppMethodBeat.i(185401);
    if (this.Yhg)
    {
      setNewVoice2TxtCountDown(paramInt);
      AppMethodBeat.o(185401);
      return;
    }
    if (paramInt < 10)
    {
      if (this.YfQ)
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
      setRecordNormalWording(getResources().getQuantityString(R.j.gpm, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    }
    AppMethodBeat.o(185401);
  }
  
  public void setWordCountLimit(int paramInt)
  {
    AppMethodBeat.i(31646);
    this.Yfc = ((TextView)this.hDw.findViewById(R.h.chatting_wordcount_tv));
    this.Rqt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    AppMethodBeat.o(31646);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(31656);
    if ((this.Fgt != null) && (this.Fgt.isSupportNavigationSwipeBack()) && (this.Fgt.getSwipeBackLayout() != null)) {
      this.Fgt.getSwipeBackLayout().setOnceDisEnableGesture(true);
    }
    if (!iMy())
    {
      s(1, true, -1);
      AppMethodBeat.o(31656);
      return;
    }
    Log.i("MicroMsg.ChatFooter", "isScrolling!! pass this event!");
    AppMethodBeat.o(31656);
  }
  
  public final void u(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(31582);
    if ((this.Yfo.getTag() != null) && ((this.Yfo.getTag() instanceof cc)) && (Util.isEqual(paramLong, ((cc)this.Yfo.getTag()).field_msgId))) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(245321);
          if (!paramBoolean) {
            com.tencent.mm.ui.base.k.c(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(R.l.gOa), "", true);
          }
          ChatFooter.this.iLY();
          AppMethodBeat.o(245321);
        }
      });
    }
    AppMethodBeat.o(31582);
  }
  
  public static final class a
  {
    public String Yjo;
    String Yjp;
    int Yjq;
    HashMap<String, LinkedList<HashMap<String, String>>> Yjr;
    
    private a()
    {
      AppMethodBeat.i(31558);
      this.Yjr = new HashMap();
      AppMethodBeat.o(31558);
    }
  }
  
  public static abstract interface b
  {
    public abstract String getTalkerUserName();
    
    public abstract com.tencent.mm.ui.chatting.g.b iNg();
    
    public abstract com.tencent.mm.ui.chatting.d.a iNh();
  }
  
  public static abstract interface c
  {
    public abstract void a(Boolean paramBoolean1, Boolean paramBoolean2);
    
    public abstract void b(Boolean paramBoolean1, Boolean paramBoolean2);
  }
  
  public static abstract interface d
  {
    public abstract void J(Boolean paramBoolean);
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(185398);
      Yjs = new e("MODE_VOICE", 0);
      Yjt = new e("MODE_CANCEL", 1);
      Yju = new e("MODE_TRANS", 2);
      Yjv = new e[] { Yjs, Yjt, Yju };
      AppMethodBeat.o(185398);
    }
    
    private e() {}
  }
  
  public static abstract interface f
  {
    public abstract void nM(int paramInt1, int paramInt2);
  }
  
  public static abstract interface g
  {
    public abstract boolean Ke(boolean paramBoolean);
  }
  
  public static enum h
  {
    static
    {
      AppMethodBeat.i(185821);
      Yjw = new h("SendVoice", 0);
      Yjx = new h("StopRecord", 1);
      Yjy = new h("Reset", 2);
      Yjz = new h("Cancel", 3);
      YjA = new h("Pause", 4);
      YjB = new h("Error", 5);
      YjC = new h[] { Yjw, Yjx, Yjy, Yjz, YjA, YjB };
      AppMethodBeat.o(185821);
    }
    
    private h() {}
  }
  
  public final class i
    implements TextWatcher
  {
    TextWatcher PuL;
    private boolean YjD;
    private boolean YjE;
    
    public i(TextWatcher paramTextWatcher)
    {
      AppMethodBeat.i(31559);
      this.YjD = false;
      this.YjE = com.tencent.mm.compatible.util.d.rc(11);
      this.PuL = paramTextWatcher;
      AppMethodBeat.o(31559);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(31560);
      if ((ChatFooter.i(ChatFooter.this)) && (this.YjD) && (paramEditable.length() > 0))
      {
        this.YjD = false;
        ChatFooter.b(ChatFooter.this).setText(paramEditable.subSequence(0, paramEditable.length() - 1));
        if (ChatFooter.b(ChatFooter.this).length() > 0)
        {
          ChatFooter.j(ChatFooter.this).performClick();
          Log.i("MicroMsg.ChatFooter", "enter button, do send");
        }
        Log.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        AppMethodBeat.o(31560);
        return;
      }
      this.PuL.afterTextChanged(paramEditable);
      if (ChatFooter.G(ChatFooter.this) != null)
      {
        if (ChatFooter.b(ChatFooter.this).getLineCount() <= 1) {
          break label282;
        }
        ChatFooter.G(ChatFooter.this).setVisibility(0);
        ChatFooter.G(ChatFooter.this).setText(paramEditable.length() + "/140");
      }
      for (;;)
      {
        boolean bool = ChatFooter.e(paramEditable);
        if (!ChatFooter.C(ChatFooter.this)) {
          ChatFooter.b(ChatFooter.this, bool);
        }
        if (ChatFooter.H(ChatFooter.this) != null) {
          ChatFooter.H(ChatFooter.this).setSendButtonEnable(bool);
        }
        Log.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        AppMethodBeat.o(31560);
        return;
        label282:
        ChatFooter.G(ChatFooter.this).setVisibility(8);
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(31561);
      this.PuL.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      Log.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
      AppMethodBeat.o(31561);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(31562);
      if ((ChatFooter.i(ChatFooter.this)) && (paramInt2 == 0) && (paramInt1 == paramCharSequence.length() - 1) && (paramInt3 == 1) && (paramCharSequence.charAt(paramCharSequence.length() - 1) == '\n'))
      {
        Log.i("MicroMsg.ChatFooter", "text changed, enter button");
        this.YjD = true;
        AppMethodBeat.o(31562);
        return;
      }
      long l = Util.currentTicks();
      int m = 0;
      int k = 0;
      int j = m;
      Spannable localSpannable;
      int n;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int i;
      label232:
      boolean bool;
      if (paramInt3 > 0)
      {
        j = m;
        if ((paramCharSequence instanceof Spannable))
        {
          localSpannable = (Spannable)paramCharSequence;
          n = paramInt1 + paramInt3;
          localObject1 = (com.tencent.mm.ui.widget.a[])localSpannable.getSpans(paramInt1, n, com.tencent.mm.ui.widget.a.class);
          localObject2 = (com.tencent.mm.ui.h.a[])localSpannable.getSpans(paramInt1, n, com.tencent.mm.ui.h.a.class);
          if (localObject2.length <= 0) {
            break label925;
          }
          localObject2 = localObject2[(localObject2.length - 1)];
          localObject3 = paramCharSequence.subSequence(paramInt1, n);
          kotlin.g.b.s.u(localObject3, "newText");
          i = -1;
          j = 0;
          if ((localObject3 instanceof String))
          {
            i = localObject3.hashCode();
            if (!(((com.tencent.mm.ui.h.a)localObject2).afuS instanceof SpannedString)) {
              break label351;
            }
            j = ((com.tencent.mm.ui.h.a)localObject2).afuS.toString().hashCode();
            if (i == j) {
              break label375;
            }
            bool = false;
            label242:
            if (bool) {
              break label396;
            }
            i = 1;
          }
        }
      }
      for (;;)
      {
        label250:
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          j = m;
          if (i == 0) {}
        }
        else
        {
          if ((i != 0) && (localObject1 != null) && (localObject1.length > 0))
          {
            j = localObject1.length;
            i = 0;
            for (;;)
            {
              if (i < j)
              {
                localSpannable.removeSpan(localObject1[i]);
                i += 1;
                continue;
                if ((!(localObject3 instanceof SpannableString)) && (!(localObject3 instanceof SpannableStringBuilder))) {
                  break;
                }
                i = localObject3.toString().hashCode();
                break;
                if (!(((com.tencent.mm.ui.h.a)localObject2).afuS instanceof String)) {
                  break label232;
                }
                j = ((com.tencent.mm.ui.h.a)localObject2).afuS.hashCode();
                break label232;
                bool = kotlin.g.b.s.p(((com.tencent.mm.ui.h.a)localObject2).afuS.toString(), localObject3.toString());
                break label242;
                i = 0;
                break label250;
              }
            }
          }
          localObject1 = (SpanWatcher[])localSpannable.getSpans(0, localSpannable.length(), SpanWatcher.class);
          i = k;
          if (localObject1 != null)
          {
            j = localObject1.length;
            k = localObject1.length;
            i = 0;
            while (i < k)
            {
              localSpannable.removeSpan(localObject1[i]);
              i += 1;
            }
            i = j;
          }
          localObject2 = com.tencent.mm.smiley.u.iVt();
          ChatFooter.this.getContext();
          float f = ChatFooter.b(ChatFooter.this).getTextSize();
          if (!Util.isNullOrNil(localSpannable.toString()))
          {
            j = Math.round(f);
            localObject3 = new PInt();
            ((PInt)localObject3).value = ((com.tencent.mm.smiley.u)localObject2).acyP;
            EmojiHelper.iUM();
            localObject2 = EmojiHelper.a(localSpannable, j, (PInt)localObject3, paramInt1, n);
            localObject2 = QQSmileyManager.iVq().a((Spannable)localObject2, j, paramInt1, n);
            if ((localObject2 != null) && (((com.tencent.mm.ui.widget.a[])((Spannable)localObject2).getSpans(paramInt1, n, com.tencent.mm.ui.widget.a.class)).length > 0))
            {
              localObject3 = (com.tencent.mm.ui.h.a[])((Spannable)localObject2).getSpans(paramInt1, n, com.tencent.mm.ui.h.a.class);
              k = localObject3.length;
              j = 0;
              while (j < k)
              {
                ((Spannable)localObject2).removeSpan(localObject3[j]);
                j += 1;
              }
              localObject3 = new com.tencent.mm.ui.h.a(paramInt1, n);
              CharSequence localCharSequence = ((Spannable)localObject2).subSequence(paramInt1, n);
              kotlin.g.b.s.u(localCharSequence, "<set-?>");
              ((com.tencent.mm.ui.h.a)localObject3).afuS = localCharSequence;
              ((Spannable)localObject2).setSpan(localObject3, paramInt1, n, 33);
            }
          }
          j = i;
          if (localObject1 != null)
          {
            m = localObject1.length;
            k = 0;
            for (;;)
            {
              j = i;
              if (k >= m) {
                break;
              }
              localSpannable.setSpan(localObject1[k], 0, localSpannable.length(), 18);
              k += 1;
            }
          }
        }
        label351:
        label375:
        Log.i("MicroMsg.ChatFooter", "onTextChanged: cost %s; start:%s, count:%s, watcherCount:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(j) });
        label396:
        this.PuL.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        ChatFooter.this.Ygr.ilj += 1L;
        ChatFooter.this.Ygr.aIH();
        if (ChatFooter.this.Ygr.ilg == 0L) {
          ChatFooter.this.Ygr.aIG();
        }
        if (ChatFooter.H(ChatFooter.this) != null) {
          ChatFooter.H(ChatFooter.this).setToSendText(ChatFooter.b(ChatFooter.this).getText().toString());
        }
        AppMethodBeat.o(31562);
        return;
        label925:
        i = 0;
      }
    }
  }
  
  static enum j
  {
    static
    {
      AppMethodBeat.i(31565);
      YjF = new j("MODE_INVALID", 0);
      YjG = new j("MODE_BLUR", 1);
      YjH = new j("MODE_NORMAL", 2);
      YjI = new j[] { YjF, YjG, YjH };
      AppMethodBeat.o(31565);
    }
    
    private j() {}
  }
  
  static enum k
  {
    static
    {
      AppMethodBeat.i(31568);
      YjJ = new k("MODE_INVALID", 0);
      YjK = new k("MODE_TRANS", 1);
      YjL = new k("MODE_CANCEL", 2);
      YjM = new k[] { YjJ, YjK, YjL };
      AppMethodBeat.o(31568);
    }
    
    private k() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter
 * JD-Core Version:    0.7.0.1
 */