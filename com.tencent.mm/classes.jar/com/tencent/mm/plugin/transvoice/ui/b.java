package com.tencent.mm.plugin.transvoice.ui;

import a.f.b.j;
import a.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.MMBottomSheetBehavior;
import android.support.design.widget.MMBottomSheetBehavior.a;
import android.support.design.widget.MMBottomSheetBehavior.b;
import android.support.v7.app.e;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.u;
import com.tencent.mm.cj.a.a;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.plugin.transvoice.a.c;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "bottomSheetCoordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "btnLayout", "canCloseKeyboard", "", "canClosePanel", "canHideKeyboard", "closeInputMethod", "Landroid/widget/ImageView;", "closePanel", "container", "Lcom/tencent/mm/modelvoiceaddr/ShortSentenceContainer;", "curTxt", "", "getCurTxt", "()Ljava/lang/String;", "setCurTxt", "(Ljava/lang/String;)V", "dotCounter", "", "dotStr", "emojiRoot", "Landroid/widget/FrameLayout;", "hasClick", "inputMethodLayout", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoicePanelLayout;", "inputMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "isEdited", "isKeyboardShown", "keyboardHeight", "langType", "languageChoiceDialog", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "mNewVoiceInputReport", "Lcom/tencent/mm/modelvoiceaddr/voicereport/NewVoiceInputReportManager;", "mVoiceIdSet", "", "needSendTxtMsg", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "overTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "panelDragOpeMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "reporter", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "sendTxtMsg", "Landroid/widget/Button;", "sendVoiceMsg", "showImeRunnable", "Ljava/lang/Runnable;", "smileyItem", "smileyOpener", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "talker", "getTalker", "setTalker", "targetView", "tmpClickChangeLangTypeTime", "", "transCancelable", "transMore", "transPanelAction", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "getTransPanelAction", "()Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "setTransPanelAction", "(Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;)V", "transSP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "txtEditView", "Lcom/tencent/mm/ui/widget/MMEditText;", "txtMsg4Send", "updateDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceAddr", "Lcom/tencent/mm/plugin/transvoice/model/SceneVoiceInputAddr2;", "value", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "voiceLen", "getVoiceLen", "()J", "setVoiceLen", "(J)V", "voiceMsgSend", "cgiReport", "", "msg", "closeInputMethodBtnVisibility", "visible", "closeTransPanel", "exitType", "delPunctuation", "getContentTxt", "init", "initSmileyPanel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshBottomPanelHeight", "resetTransPanel", "saveTransLangTypeByTalker", "type", "setBottomBtnVisibility", "setKeyboardVisibility", "setSmileyItemVisibility", "setSmileyPanelVisibility", "show", "startTrans", "updateCurTxt", "updateTransLangTypeByTalker", "Companion", "InputMode", "PanelDragOpeMode", "TransPanelAction", "plugin-transvoice_release"})
public final class b
  extends e
{
  public static int tqA;
  public static final b.a tqB;
  private ChatFooterPanel eys;
  public h gaW;
  public int gbb;
  private final Runnable lzz;
  public boolean mxI;
  private FrameLayout sMg;
  private boolean sMn;
  private int sMo;
  public String talker;
  private View targetView;
  private ImageView tpG;
  public MMBottomSheetBehavior<View> tpN;
  private boolean tpO;
  private a.b tpP;
  public final c tpS;
  long tpT;
  public boolean tpU;
  private TransVoicePanelLayout tpV;
  private MMEditText tpW;
  private ImageView tpX;
  private ImageView tpY;
  private View tpZ;
  private View tqa;
  private ImageView tqb;
  private Button tqc;
  private Button tqd;
  public com.tencent.mm.plugin.transvoice.a.b tqe;
  private b.b tqf;
  public long tqg;
  public String tqh;
  private boolean tqi;
  private String tqj;
  private int tqk;
  public ap tql;
  private boolean tqm;
  private a tqn;
  public ak tqo;
  public SharedPreferences tqp;
  private CoordinatorLayout tqq;
  private b.c tqr;
  private boolean tqs;
  private boolean tqt;
  private boolean tqu;
  private String tqv;
  private final com.tencent.mm.modelvoiceaddr.b.b tqw;
  private List<String> tqx;
  String tqy;
  public b.d tqz;
  
  static
  {
    AppMethodBeat.i(155270);
    tqB = new b.a((byte)0);
    tqA = -1;
    AppMethodBeat.o(155270);
  }
  
  public b(final Context paramContext)
  {
    super(paramContext, 2131493698);
    AppMethodBeat.i(155269);
    c.a locala = c.tpD;
    this.tpS = c.cKY();
    this.gbb = 1;
    this.tqf = b.b.tqC;
    this.tqj = "";
    this.tqp = paramContext.getSharedPreferences("voice2txt_sp", 0);
    this.tqr = b.c.tqG;
    this.tqv = "";
    eS();
    this.tqw = new com.tencent.mm.modelvoiceaddr.b.b();
    this.lzz = ((Runnable)new w(this, paramContext));
    this.tqy = "";
    AppMethodBeat.o(155269);
  }
  
  private final void GX(int paramInt)
  {
    AppMethodBeat.i(155265);
    if (isShowing())
    {
      this.tpS.GV(paramInt);
      cLb();
      dismiss();
      b.d locald = this.tqz;
      if (locald != null) {
        locald.cLc();
      }
      if (!this.tqi)
      {
        locald = this.tqz;
        if (locald != null) {
          locald.aez(this.tqh);
        }
      }
      this.tqi = false;
    }
    AppMethodBeat.o(155265);
  }
  
  private final void mG(boolean paramBoolean)
  {
    AppMethodBeat.i(155263);
    if (paramBoolean)
    {
      localImageView = this.tpX;
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        AppMethodBeat.o(155263);
        return;
      }
      AppMethodBeat.o(155263);
      return;
    }
    ImageView localImageView = this.tpX;
    if (localImageView != null)
    {
      localImageView.setVisibility(0);
      AppMethodBeat.o(155263);
      return;
    }
    AppMethodBeat.o(155263);
  }
  
  private final void setKeyboardVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(155264);
    ab.d("MicroMsg.TransVoiceDialog", "setKeyboardVisibility, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      localObject = this.targetView;
      if (localObject != null) {
        ((View)localObject).removeCallbacks(this.lzz);
      }
      localObject = this.targetView;
      if (localObject != null)
      {
        ((View)localObject).post(this.lzz);
        AppMethodBeat.o(155264);
        return;
      }
      AppMethodBeat.o(155264);
      return;
    }
    Object localObject = this.targetView;
    if (localObject != null) {
      ((View)localObject).removeCallbacks(this.lzz);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localObject = this.tpW;
      if (localObject != null) {}
      for (localObject = ((MMEditText)localObject).getWindowToken();; localObject = null)
      {
        localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
        AppMethodBeat.o(155264);
        return;
      }
    }
    AppMethodBeat.o(155264);
  }
  
  public final void aex(String paramString)
  {
    AppMethodBeat.i(155267);
    j.q(paramString, "<set-?>");
    this.tqy = paramString;
    AppMethodBeat.o(155267);
  }
  
  public final void cLb()
  {
    AppMethodBeat.i(155266);
    this.tqy = "";
    this.tqk = 0;
    this.tqj = "";
    this.tqm = false;
    Object localObject = this.tpW;
    if (localObject != null) {
      ((MMEditText)localObject).setText((CharSequence)"");
    }
    localObject = this.tpW;
    if (localObject != null) {
      ((MMEditText)localObject).setCursorVisible(false);
    }
    localObject = this.tpW;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusable(false);
    }
    localObject = this.tpW;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusableInTouchMode(false);
    }
    localObject = this.tpZ;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.tqa;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    setKeyboardVisibility(false);
    localObject = this.sMg;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    mG(false);
    localObject = this.tqo;
    if (localObject != null) {
      ((ak)localObject).removeMessages(5000);
    }
    this.tqr = b.c.tqG;
    this.tpO = false;
    this.tqs = false;
    this.tqt = false;
    AppMethodBeat.o(155266);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(155262);
    GX(6);
    super.onBackPressed();
    AppMethodBeat.o(155262);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(155261);
    this.targetView = LayoutInflater.from(getContext()).inflate(2130971039, null, false);
    Object localObject = new ViewGroup.LayoutParams(-1, -1);
    setContentView(this.targetView, (ViewGroup.LayoutParams)localObject);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(67108864);
      paramBundle.setLayout(-1, -1);
      paramBundle.setSoftInputMode(34);
      paramBundle.setDimAmount(0.5F);
      paramBundle.setWindowAnimations(2131493120);
    }
    paramBundle = this.targetView;
    if (paramBundle != null)
    {
      paramBundle = (TransVoicePanelLayout)paramBundle.findViewById(2131828630);
      this.tpV = paramBundle;
      paramBundle = this.tpV;
      if (paramBundle != null) {
        paramBundle.setOnInputPanelChange((TransVoicePanelLayout.a)new b.h(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1006;
      }
      paramBundle = (CoordinatorLayout)paramBundle.findViewById(2131825348);
      label160:
      this.tqq = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1011;
      }
      paramBundle = paramBundle.findViewById(2131825349);
      label182:
      this.tpN = MMBottomSheetBehavior.r(paramBundle);
      paramBundle = this.tpN;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new o(this));
      }
      paramBundle = this.tpN;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.b)new b.p(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1016;
      }
      paramBundle = (MMEditText)paramBundle.findViewById(2131828634);
      label258:
      this.tpW = paramBundle;
      paramBundle = this.tpW;
      if (paramBundle != null)
      {
        paramBundle.setCursorVisible(false);
        paramBundle.setOnEditorActionListener((TextView.OnEditorActionListener)new b.e(this));
        paramBundle.setMaxLines(2147483647);
        paramBundle.setHorizontallyScrolling(false);
        paramBundle.setOnClickListener((View.OnClickListener)new f(this));
        paramBundle.addTextChangedListener((TextWatcher)new b.g(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1021;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131825351);
      label354:
      this.tpG = paramBundle;
      paramBundle = this.tpG;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b.q(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1026;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131828632);
      label403:
      this.tpX = paramBundle;
      paramBundle = this.tpX;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b.r(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1031;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131828633);
      label452:
      this.tpY = paramBundle;
      paramBundle = this.tpY;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b.s(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1036;
      }
      paramBundle = paramBundle.findViewById(2131828636);
      label498:
      this.tpZ = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1041;
      }
      paramBundle = paramBundle.findViewById(2131828639);
      label520:
      this.tqa = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1046;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131828640);
      label545:
      this.tqb = paramBundle;
      paramBundle = this.tqb;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b.t(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1051;
      }
      paramBundle = (FrameLayout)paramBundle.findViewById(2131828641);
      label594:
      this.sMg = paramBundle;
      this.eys = ((ChatFooterPanel)u.aW(getContext()));
      this.sMo = x.gL(getContext());
      paramBundle = new FrameLayout.LayoutParams(-1, this.sMo);
      localObject = this.sMg;
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.eys, (ViewGroup.LayoutParams)paramBundle);
      }
      paramBundle = this.eys;
      if (paramBundle != null) {
        paramBundle.setPortHeightPx(this.sMo);
      }
      paramBundle = this.eys;
      if (paramBundle != null) {
        paramBundle.setEntranceScene(ChatFooterPanel.vQy);
      }
      paramBundle = this.eys;
      if (paramBundle != null) {
        paramBundle.Az();
      }
      paramBundle = this.eys;
      if (paramBundle != null) {
        paramBundle.onResume();
      }
      paramBundle = this.eys;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.eys;
      if (paramBundle != null) {
        paramBundle.AB();
      }
      paramBundle = this.eys;
      if (paramBundle != null) {
        paramBundle.setOnTextOperationListener((ChatFooterPanel.a)new v(this));
      }
      this.tql = new ap((ap.a)new b.u(this), true);
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1056;
      }
      paramBundle = (Button)paramBundle.findViewById(2131828637);
      label814:
      this.tqc = paramBundle;
      paramBundle = this.tqc;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b.i(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1061;
      }
    }
    label1026:
    label1031:
    label1036:
    label1041:
    label1046:
    label1051:
    label1056:
    label1061:
    for (paramBundle = (Button)paramBundle.findViewById(2131828638);; paramBundle = null)
    {
      this.tqd = paramBundle;
      paramBundle = this.tqd;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b.j(this));
      }
      this.tpP = ((a.b)new b.k(this));
      paramBundle = getContext();
      j.p(paramBundle, "context");
      this.tqn = new a(paramBundle);
      paramBundle = this.tqn;
      if (paramBundle != null)
      {
        paramBundle.setOnDismissListener((DialogInterface.OnDismissListener)b.l.tqK);
        paramBundle.tpP = this.tpP;
      }
      this.tqo = new ak((ak.a)new b.m(this));
      setOnDismissListener((DialogInterface.OnDismissListener)new b.n(this));
      AppMethodBeat.o(155261);
      return;
      paramBundle = null;
      break;
      label1006:
      paramBundle = null;
      break label160;
      label1011:
      paramBundle = null;
      break label182;
      label1016:
      paramBundle = null;
      break label258;
      label1021:
      paramBundle = null;
      break label354;
      paramBundle = null;
      break label403;
      paramBundle = null;
      break label452;
      paramBundle = null;
      break label498;
      paramBundle = null;
      break label520;
      paramBundle = null;
      break label545;
      paramBundle = null;
      break label594;
      paramBundle = null;
      break label814;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(155843);
    a.a locala = com.tencent.mm.cj.a.yTb;
    com.tencent.mm.cj.a.pX(true);
    super.show();
    AppMethodBeat.o(155843);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$2"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(156319);
      b.p(this.tqJ).tpB = 1;
      b.r(this.tqJ);
      if (b.s(this.tqJ))
      {
        b.j(this.tqJ, false);
        b.p(this.tqJ).tpz = 0;
        b.p(this.tqJ).tpv = System.currentTimeMillis();
        paramView = b.t(this.tqJ);
        if (paramView != null) {
          paramView.cancel(true);
        }
        paramView = b.u(this.tqJ);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = b.v(this.tqJ);
        if (paramView != null) {
          paramView.removeMessages(5000);
        }
        paramView = b.w(this.tqJ);
        if (paramView != null) {
          paramView.stopTimer();
        }
        paramView = b.e(this.tqJ);
        if (paramView != null)
        {
          paramView.setText((CharSequence)this.tqJ.tqy);
          AppMethodBeat.o(156319);
          return;
        }
      }
      AppMethodBeat.o(156319);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$2", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class o
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(155240);
      j.q(paramView, "bottomSheet");
      ab.d("MicroMsg.TransVoiceDialog", "slideOffset: %f, panelDragOpeMode: %s.", new Object[] { Float.valueOf(paramFloat), b.d(this.tqJ) });
      paramView = b.c(this.tqJ);
      if (paramView != null)
      {
        if (paramView.getState() != 1) {
          break label305;
        }
        if (b.c.tqG == b.d(this.tqJ))
        {
          paramView = this.tqJ;
          if (0.7F < paramFloat) {
            break label239;
          }
          bool = true;
          b.f(paramView, bool);
          paramView = this.tqJ.getWindow();
          if (paramView != null) {
            paramView.setDimAmount((float)(0.5D - (1.0F - paramFloat) / 2.0D));
          }
        }
        if (b.c.tqH != b.d(this.tqJ)) {
          break label305;
        }
        paramView = this.tqJ;
        if (0.8F < paramFloat) {
          break label244;
        }
      }
      label239:
      label244:
      for (boolean bool = true;; bool = false)
      {
        b.g(paramView, bool);
        if (0.9F < paramFloat) {
          break label255;
        }
        if (b.l(this.tqJ)) {
          break label305;
        }
        b.h(this.tqJ, true);
        b.i(this.tqJ, false);
        b.b(this.tqJ, false);
        b.c(this.tqJ, false);
        b.d(this.tqJ, false);
        paramView = b.f(this.tqJ);
        if (paramView == null) {
          break label249;
        }
        paramView.setImageResource(2130838345);
        AppMethodBeat.o(155240);
        return;
        AppMethodBeat.o(155240);
        return;
        bool = false;
        break;
      }
      label249:
      AppMethodBeat.o(155240);
      return;
      label255:
      if (b.l(this.tqJ))
      {
        b.h(this.tqJ, false);
        b.i(this.tqJ, true);
        b.b(this.tqJ, true);
        b.c(this.tqJ, false);
        b.d(this.tqJ, false);
      }
      label305:
      AppMethodBeat.o(155240);
    }
    
    @SuppressLint({"SwitchIntDef"})
    public final void j(View paramView, int paramInt)
    {
      AppMethodBeat.i(155241);
      j.q(paramView, "bottomSheet");
      ab.d("MicroMsg.TransVoiceDialog", "newState: %d, panelDragOpeMode: %s, canClosePanel: %s, canHideKeyboard: %s, canCloseKeyboard: %s.", new Object[] { Integer.valueOf(paramInt), b.d(this.tqJ), Boolean.valueOf(b.j(this.tqJ)), Boolean.valueOf(b.l(this.tqJ)), Boolean.valueOf(b.k(this.tqJ)) });
      switch (paramInt)
      {
      }
      while ((1 != paramInt) && (3 != paramInt)) {
        if (!b.j(this.tqJ))
        {
          paramView = this.tqJ.getWindow();
          if (paramView != null) {
            paramView.setDimAmount(0.5F);
          }
          paramView = b.c(this.tqJ);
          if (paramView != null)
          {
            paramView.bC();
            AppMethodBeat.o(155241);
            return;
            b.f(this.tqJ, false);
            b.h(this.tqJ, false);
            b.g(this.tqJ, false);
            continue;
            if ((b.c.tqG == b.d(this.tqJ)) && (b.j(this.tqJ))) {
              b.b(this.tqJ, 6);
            }
            if ((b.c.tqH == b.d(this.tqJ)) && (b.l(this.tqJ))) {
              if (b.k(this.tqJ))
              {
                b.a(this.tqJ, b.c.tqG);
                b.c(this.tqJ, true);
                b.b(this.tqJ, false);
                paramView = b.g(this.tqJ);
                if (paramView != null) {
                  paramView.setVisibility(8);
                }
                paramView = b.e(this.tqJ);
                if (paramView != null) {
                  paramView.setCursorVisible(false);
                }
                b.e(this.tqJ, false);
                paramView = b.m(this.tqJ);
                if (paramView != null) {
                  paramView.postDelayed((Runnable)new b.o.a(this), 200L);
                }
              }
              else
              {
                b.i(this.tqJ, true);
                b.b(this.tqJ, true);
                b.c(this.tqJ, false);
                b.d(this.tqJ, false);
              }
            }
          }
          else
          {
            AppMethodBeat.o(155241);
          }
        }
        else
        {
          b.b(this.tqJ, 6);
        }
      }
      AppMethodBeat.o(155241);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-transvoice_release"})
  public static final class v
    implements ChatFooterPanel.a
  {
    public final void aRo()
    {
      AppMethodBeat.i(155250);
      Object localObject = b.e(this.tqJ);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = b.e(this.tqJ);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(155250);
          return;
        }
      }
      AppMethodBeat.o(155250);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(155249);
      MMEditText localMMEditText = b.e(this.tqJ);
      if (localMMEditText != null)
      {
        localMMEditText.avk(paramString);
        AppMethodBeat.o(155249);
        return;
      }
      AppMethodBeat.o(155249);
    }
    
    public final void bag()
    {
      AppMethodBeat.i(155251);
      b.o(this.tqJ);
      AppMethodBeat.o(155251);
    }
    
    public final void fT(boolean paramBoolean) {}
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(b paramb, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(155252);
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)b.e(this.tqJ), 0);
        AppMethodBeat.o(155252);
        return;
      }
      AppMethodBeat.o(155252);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class x
    implements g.b
  {
    public final void amK()
    {
      AppMethodBeat.i(155255);
      ab.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(155255);
    }
    
    public final void amO()
    {
      AppMethodBeat.i(155256);
      ab.d("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.tqJ, false);
      b.p(this.tqJ).tpz = 1;
      b.p(this.tqJ).tpv = System.currentTimeMillis();
      Object localObject = b.v(this.tqJ);
      if (localObject != null) {
        ((ak)localObject).removeMessages(5000);
      }
      localObject = b.w(this.tqJ);
      if (localObject != null) {
        ((ap)localObject).stopTimer();
      }
      b.I(this.tqJ);
      localObject = b.u(this.tqJ);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        AppMethodBeat.o(155256);
        return;
      }
      AppMethodBeat.o(155256);
    }
    
    public final void b(String[] paramArrayOfString, List<String> paramList)
    {
      AppMethodBeat.i(155253);
      ab.d("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.tqJ, paramList);
      paramList = b.v(this.tqJ);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.tqJ);
      if (paramList != null) {
        paramList.sendEmptyMessageDelayed(5000, 5000L);
      }
      if (paramArrayOfString != null)
      {
        paramList = paramArrayOfString[0];
        if (paramList != null)
        {
          if (((CharSequence)paramList).length() > 0) {}
          for (int i = 1; i == 1; i = 0)
          {
            this.tqJ.aex(paramArrayOfString[0]);
            ab.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.tqJ.tqy });
            b.p(this.tqJ).tpw = this.tqJ.tqy.length();
            if (b.s(this.tqJ)) {
              break;
            }
            b.j(this.tqJ, true);
            paramArrayOfString = b.e(this.tqJ);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.tqJ);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.tqJ);
            if (paramArrayOfString == null) {
              break;
            }
            paramArrayOfString.requestFocus();
            AppMethodBeat.o(155253);
            return;
          }
        }
      }
      AppMethodBeat.o(155253);
      return;
      AppMethodBeat.o(155253);
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(155254);
      ab.d("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
      b.p(this.tqJ).tpz = 0;
      b.p(this.tqJ).tpv = System.currentTimeMillis();
      AppMethodBeat.o(155254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b
 * JD-Core Version:    0.7.0.1
 */