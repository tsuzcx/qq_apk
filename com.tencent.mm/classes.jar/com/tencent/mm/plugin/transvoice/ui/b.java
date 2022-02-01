package com.tencent.mm.plugin.transvoice.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.MMBottomSheetBehavior;
import android.support.design.widget.MMBottomSheetBehavior.a;
import android.support.design.widget.MMBottomSheetBehavior.b;
import android.support.v7.app.e;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.cl.a.a;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.plugin.transvoice.a.c;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "bottomSheetCoordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "btnLayout", "canCloseKeyboard", "", "canClosePanel", "canHideKeyboard", "closeInputMethod", "Landroid/widget/ImageView;", "closePanel", "container", "Lcom/tencent/mm/modelvoiceaddr/ShortSentenceContainer;", "curTxt", "", "getCurTxt", "()Ljava/lang/String;", "setCurTxt", "(Ljava/lang/String;)V", "dotCounter", "", "dotStr", "emojiRoot", "Landroid/widget/FrameLayout;", "hasClick", "inputMethodLayout", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoicePanelLayout;", "inputMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "isEdited", "isKeyboardShown", "keyboardHeight", "langType", "languageChoiceDialog", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "mNewVoiceInputReport", "Lcom/tencent/mm/modelvoiceaddr/voicereport/NewVoiceInputReportManager;", "mVoiceIdSet", "", "needSendTxtMsg", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "overTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "panelDragOpeMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "reporter", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "sendTxtMsg", "Landroid/widget/Button;", "sendVoiceMsg", "showImeRunnable", "Ljava/lang/Runnable;", "smileyItem", "smileyOpener", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "talker", "getTalker", "setTalker", "targetView", "tmpClickChangeLangTypeTime", "", "transCancelable", "transMore", "transPanelAction", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "getTransPanelAction", "()Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "setTransPanelAction", "(Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;)V", "transSP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "txtEditView", "Lcom/tencent/mm/ui/widget/MMEditText;", "txtMsg4Send", "updateDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceAddr", "Lcom/tencent/mm/plugin/transvoice/model/SceneVoiceInputAddr2;", "value", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "voiceLen", "getVoiceLen", "()J", "setVoiceLen", "(J)V", "voiceMsgSend", "cgiReport", "", "msg", "closeInputMethodBtnVisibility", "visible", "closeTransPanel", "exitType", "delPunctuation", "getContentTxt", "init", "initSmileyPanel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshBottomPanelHeight", "resetTransPanel", "saveTransLangTypeByTalker", "type", "setBottomBtnVisibility", "setKeyboardVisibility", "setSmileyItemVisibility", "setSmileyPanelVisibility", "show", "startTrans", "updateCurTxt", "updateTransLangTypeByTalker", "Companion", "InputMode", "PanelDragOpeMode", "TransPanelAction", "plugin-transvoice_release"})
public final class b
  extends e
{
  public static int yYw;
  public static final a yYx;
  private ChatFooterPanel fSY;
  h hDI;
  int hDN;
  private int mEi;
  private final Runnable oQp;
  boolean qfi;
  public String talker;
  private View targetView;
  private ImageView yWA;
  private MMBottomSheetBehavior<View> yWD;
  private boolean yWE;
  private a.b yWF;
  final c yXO;
  long yXP;
  boolean yXQ;
  private TransVoicePanelLayout yXR;
  private MMEditText yXS;
  private ImageView yXT;
  private ImageView yXU;
  private View yXV;
  private View yXW;
  private ImageView yXX;
  private Button yXY;
  private Button yXZ;
  com.tencent.mm.plugin.transvoice.a.b yYa;
  private b yYb;
  public long yYc;
  String yYd;
  private boolean yYe;
  private String yYf;
  private int yYg;
  av yYh;
  private boolean yYi;
  private a yYj;
  ap yYk;
  private SharedPreferences yYl;
  private CoordinatorLayout yYm;
  private b.c yYn;
  private boolean yYo;
  private boolean yYp;
  private boolean yYq;
  private String yYr;
  private final com.tencent.mm.modelvoiceaddr.b.b yYs;
  private List<String> yYt;
  String yYu;
  public d yYv;
  private FrameLayout yuK;
  private boolean yuR;
  
  static
  {
    AppMethodBeat.i(102605);
    yYx = new a((byte)0);
    yYw = -1;
    AppMethodBeat.o(102605);
  }
  
  public b(final Context paramContext)
  {
    super(paramContext, 2131821488);
    AppMethodBeat.i(102604);
    c.a locala = c.yWx;
    this.yXO = c.dQE();
    this.hDN = g.hEm;
    this.yYb = b.yYy;
    this.yYf = "";
    this.yYl = paramContext.getSharedPreferences("voice2txt_sp", 0);
    this.yYn = b.c.yYC;
    this.yYr = "";
    gl();
    this.yYs = new com.tencent.mm.modelvoiceaddr.b.b();
    this.oQp = ((Runnable)new w(this, paramContext));
    this.yYu = "";
    AppMethodBeat.o(102604);
  }
  
  private final void PI(int paramInt)
  {
    AppMethodBeat.i(102600);
    if (isShowing())
    {
      this.yXO.setExitType(paramInt);
      dQR();
      dismiss();
      d locald = this.yYv;
      if (locald != null) {
        locald.dQS();
      }
      if (!this.yYe)
      {
        locald = this.yYv;
        if (locald != null) {
          locald.asT(this.yYd);
        }
      }
      this.yYe = false;
    }
    AppMethodBeat.o(102600);
  }
  
  private final void rk(boolean paramBoolean)
  {
    AppMethodBeat.i(102598);
    if (paramBoolean)
    {
      localImageView = this.yXT;
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        AppMethodBeat.o(102598);
        return;
      }
      AppMethodBeat.o(102598);
      return;
    }
    ImageView localImageView = this.yXT;
    if (localImageView != null)
    {
      localImageView.setVisibility(0);
      AppMethodBeat.o(102598);
      return;
    }
    AppMethodBeat.o(102598);
  }
  
  private final void setKeyboardVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(102599);
    ad.d("MicroMsg.TransVoiceDialog", "setKeyboardVisibility, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      localObject = this.targetView;
      if (localObject != null) {
        ((View)localObject).removeCallbacks(this.oQp);
      }
      localObject = this.targetView;
      if (localObject != null)
      {
        ((View)localObject).post(this.oQp);
        AppMethodBeat.o(102599);
        return;
      }
      AppMethodBeat.o(102599);
      return;
    }
    Object localObject = this.targetView;
    if (localObject != null) {
      ((View)localObject).removeCallbacks(this.oQp);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localObject = this.yXS;
      if (localObject != null) {}
      for (localObject = ((MMEditText)localObject).getWindowToken();; localObject = null)
      {
        localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
        AppMethodBeat.o(102599);
        return;
      }
    }
    AppMethodBeat.o(102599);
  }
  
  public final void asQ(String paramString)
  {
    AppMethodBeat.i(185255);
    if (!bt.isNullOrNil(paramString))
    {
      this.yYd = paramString;
      a.a locala = com.tencent.mm.cl.a.FFw;
      if (paramString == null) {
        k.fvU();
      }
      k.h(paramString, "<set-?>");
      com.tencent.mm.cl.a.aJR(paramString);
    }
    AppMethodBeat.o(185255);
  }
  
  public final void asR(String paramString)
  {
    AppMethodBeat.i(102602);
    k.h(paramString, "<set-?>");
    this.yYu = paramString;
    AppMethodBeat.o(102602);
  }
  
  public final void c(h paramh)
  {
    AppMethodBeat.i(185256);
    k.h(paramh, "container");
    Object localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).setDimAmount(0.5F);
    }
    localObject = this.yWD;
    if (localObject != null) {
      ((MMBottomSheetBehavior)localObject).cv();
    }
    this.yXQ = false;
    this.qfi = false;
    int i = this.yYl.getInt(this.talker, 0);
    localObject = this.yYj;
    if (localObject == null) {
      k.fvU();
    }
    localObject = ((a)localObject).yWB;
    if (localObject == null) {
      k.fvU();
    }
    if (((ArrayList)localObject).contains(Integer.valueOf(i))) {
      this.hDN = i;
    }
    for (;;)
    {
      this.yXO.yWm = this.hDN;
      dQR();
      localObject = this.yYk;
      if (localObject != null) {
        ((ap)localObject).sendEmptyMessageDelayed(5000, 5000L);
      }
      localObject = this.yYh;
      if (localObject != null) {
        ((av)localObject).vE(500L);
      }
      this.hDI = paramh;
      this.yYa = new com.tencent.mm.plugin.transvoice.a.b(paramh, this.hDN, (g.b)new x(this));
      paramh = this.yYa;
      if (paramh == null) {
        break;
      }
      paramh.start();
      AppMethodBeat.o(185256);
      return;
      localObject = this.yYj;
      if (localObject == null) {
        k.fvU();
      }
      localObject = ((a)localObject).yWB;
      if (localObject == null) {
        k.fvU();
      }
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = this.yYj;
        if (localObject == null) {
          k.fvU();
        }
        localObject = ((a)localObject).yWB;
        if (localObject == null) {
          k.fvU();
        }
        localObject = ((ArrayList)localObject).get(0);
        k.g(localObject, "languageChoiceDialog!!.langTypeArr!![0]");
        this.hDN = ((Number)localObject).intValue();
      }
      else
      {
        localObject = ac.ir(getContext());
        if ((k.g(localObject, "zh_CN")) || (k.g(localObject, "zh_HK")) || (k.g(localObject, "zh_TW"))) {
          this.hDN = g.hEm;
        } else if (k.g(localObject, "en")) {
          this.hDN = g.hEo;
        }
      }
    }
    AppMethodBeat.o(185256);
  }
  
  final void dQR()
  {
    AppMethodBeat.i(102601);
    this.yYu = "";
    this.yYg = 0;
    this.yYf = "";
    this.yYi = false;
    Object localObject = this.yXS;
    if (localObject != null) {
      ((MMEditText)localObject).setText((CharSequence)"");
    }
    localObject = this.yXS;
    if (localObject != null) {
      ((MMEditText)localObject).setCursorVisible(false);
    }
    localObject = this.yXS;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusable(false);
    }
    localObject = this.yXS;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusableInTouchMode(false);
    }
    localObject = this.yXV;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.yXW;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    setKeyboardVisibility(false);
    localObject = this.fSY;
    if (localObject != null) {
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    rk(false);
    localObject = this.yYk;
    if (localObject != null) {
      ((ap)localObject).removeMessages(5000);
    }
    this.yYn = b.c.yYC;
    this.yWE = false;
    this.yYo = false;
    this.yYp = false;
    AppMethodBeat.o(102601);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(102597);
    PI(6);
    super.onBackPressed();
    AppMethodBeat.o(102597);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102596);
    this.targetView = LayoutInflater.from(getContext()).inflate(2131495804, null, false);
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
      paramBundle.setWindowAnimations(2131820790);
    }
    paramBundle = this.targetView;
    if (paramBundle != null)
    {
      paramBundle = (TransVoicePanelLayout)paramBundle.findViewById(2131301032);
      this.yXR = paramBundle;
      paramBundle = this.yXR;
      if (paramBundle != null) {
        paramBundle.setOnInputPanelChange((TransVoicePanelLayout.a)new h(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1056;
      }
      paramBundle = (CoordinatorLayout)paramBundle.findViewById(2131296673);
      label160:
      this.yYm = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1061;
      }
      paramBundle = paramBundle.findViewById(2131303747);
      label182:
      this.yWD = MMBottomSheetBehavior.w(paramBundle);
      paramBundle = this.yWD;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new o(this));
      }
      paramBundle = this.yWD;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.b)new p(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1066;
      }
      paramBundle = (MMEditText)paramBundle.findViewById(2131306060);
      label258:
      this.yXS = paramBundle;
      paramBundle = this.yXS;
      if (paramBundle != null)
      {
        paramBundle.setCursorVisible(false);
        paramBundle.setOnEditorActionListener((TextView.OnEditorActionListener)new e(this));
        paramBundle.setMaxLines(2147483647);
        paramBundle.setHorizontallyScrolling(false);
        paramBundle.setOnClickListener((View.OnClickListener)new f(this));
        paramBundle.addTextChangedListener((TextWatcher)new g(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1071;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131298375);
      label354:
      this.yWA = paramBundle;
      paramBundle = this.yWA;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new q(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1076;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131306061);
      label403:
      this.yXT = paramBundle;
      paramBundle = this.yXT;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new r(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1081;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131298371);
      label452:
      this.yXU = paramBundle;
      paramBundle = this.yXU;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new s(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1086;
      }
      paramBundle = paramBundle.findViewById(2131303745);
      label498:
      this.yXV = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1091;
      }
      paramBundle = paramBundle.findViewById(2131304864);
      label520:
      this.yXW = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1096;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131304869);
      label545:
      this.yXX = paramBundle;
      paramBundle = this.yXX;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new t(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1101;
      }
      paramBundle = (FrameLayout)paramBundle.findViewById(2131299431);
      label594:
      this.yuK = paramBundle;
      this.fSY = ((ChatFooterPanel)aa.bg(getContext()));
      this.mEi = z.in(getContext());
      paramBundle = new FrameLayout.LayoutParams(-1, this.mEi);
      localObject = this.yuK;
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.fSY, (ViewGroup.LayoutParams)paramBundle);
      }
      paramBundle = this.fSY;
      if (paramBundle != null) {
        paramBundle.setPortHeightPx(this.mEi);
      }
      paramBundle = this.fSY;
      if (paramBundle != null) {
        paramBundle.setEntranceScene(ChatFooterPanel.BUT);
      }
      paramBundle = this.fSY;
      if (paramBundle != null) {
        paramBundle.exn();
      }
      paramBundle = this.fSY;
      if (paramBundle != null) {
        paramBundle.onResume();
      }
      paramBundle = this.fSY;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.fSY;
      if (paramBundle != null) {
        paramBundle.setShowSend(true);
      }
      paramBundle = this.fSY;
      if (paramBundle != null) {
        paramBundle.setOnTextOperationListener((ChatFooterPanel.a)new v(this));
      }
      this.yYh = new av((av.a)new u(this), true);
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1106;
      }
      paramBundle = (Button)paramBundle.findViewById(2131297597);
      label815:
      this.yXY = paramBundle;
      paramBundle = this.yXY;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new i(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1111;
      }
      paramBundle = (Button)paramBundle.findViewById(2131297598);
      label864:
      this.yXZ = paramBundle;
      paramBundle = this.yXZ;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new j(this));
      }
      paramBundle = this.yXY;
      if (paramBundle == null) {
        break label1116;
      }
      paramBundle = paramBundle.getPaint();
      label907:
      ai.a((Paint)paramBundle, 0.8F);
      paramBundle = this.yXZ;
      if (paramBundle == null) {
        break label1121;
      }
    }
    label1056:
    label1061:
    label1066:
    label1071:
    label1076:
    label1081:
    label1086:
    label1091:
    label1096:
    label1101:
    label1106:
    label1111:
    label1116:
    label1121:
    for (paramBundle = paramBundle.getPaint();; paramBundle = null)
    {
      ai.a((Paint)paramBundle, 0.8F);
      this.yWF = ((a.b)new k(this));
      paramBundle = getContext();
      k.g(paramBundle, "context");
      this.yYj = new a(paramBundle);
      paramBundle = this.yYj;
      if (paramBundle != null)
      {
        paramBundle.setOnDismissListener((DialogInterface.OnDismissListener)b.l.yYG);
        paramBundle.yWF = this.yWF;
      }
      this.yYk = new ap((ap.a)new m(this));
      setOnDismissListener((DialogInterface.OnDismissListener)new n(this));
      AppMethodBeat.o(102596);
      return;
      paramBundle = null;
      break;
      paramBundle = null;
      break label160;
      paramBundle = null;
      break label182;
      paramBundle = null;
      break label258;
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
      break label815;
      paramBundle = null;
      break label864;
      paramBundle = null;
      break label907;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(102603);
    a.a locala = com.tencent.mm.cl.a.FFw;
    com.tencent.mm.cl.a.vg(true);
    super.show();
    AppMethodBeat.o(102603);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$Companion;", "", "()V", "MODE_ONLY_PANEL_CLOSE_PANEL_OFFSET", "", "MODE_WITH_KEYBOARD_CLOSE_KEYBOARD_OFFSET", "MODE_WITH_KEYBOARD_HIDE_KEYBOARD_OFFSET", "OVERTIME_INTERVAL", "", "OVERTIME_MSG", "", "SP_NAME", "", "TAG", "UPDATE_DOT_STR_INTERVAL", "trans2txt_cmd", "trans2txt_cmd_close", "trans2txt_cmd_invalid", "trans2txt_cmd_open", "plugin-transvoice_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "", "(Ljava/lang/String;I)V", "INPUT_NONE", "INPUT_EMOJI", "INPUT_KEYBOARD", "plugin-transvoice_release"})
  static enum b
  {
    static
    {
      AppMethodBeat.i(102558);
      b localb1 = new b("INPUT_NONE", 0);
      yYy = localb1;
      b localb2 = new b("INPUT_EMOJI", 1);
      yYz = localb2;
      b localb3 = new b("INPUT_KEYBOARD", 2);
      yYA = localb3;
      yYB = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(102558);
    }
    
    private b() {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "", "onTransPanelClose", "", "onTxtMsgSend", "txt", "", "onVoiceMsgDelete", "fileName", "onVoiceMsgSend", "", "fileLength", "", "(Ljava/lang/String;Ljava/lang/Long;)Z", "plugin-transvoice_release"})
  public static abstract interface d
  {
    public abstract boolean a(String paramString, Long paramLong);
    
    public abstract void asS(String paramString);
    
    public abstract void asT(String paramString);
    
    public abstract void dQS();
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$1"})
  static final class e
    implements TextView.OnEditorActionListener
  {
    e(b paramb) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(102565);
      if (4 != paramInt)
      {
        k.g(paramKeyEvent, "event");
        if (66 != paramKeyEvent.getAction()) {}
      }
      else
      {
        b.o(this.yYF);
        AppMethodBeat.o(102565);
        return true;
      }
      AppMethodBeat.o(102565);
      return false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$2"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102566);
      b.p(this.yYF).yWv = 1;
      b.r(this.yYF);
      if (b.s(this.yYF))
      {
        b.j(this.yYF, false);
        b.p(this.yYF).yWt = 0;
        b.p(this.yYF).yWp = System.currentTimeMillis();
        paramView = b.t(this.yYF);
        if (paramView != null) {
          paramView.cancel(true);
        }
        paramView = b.u(this.yYF);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = b.v(this.yYF);
        if (paramView != null) {
          paramView.removeMessages(5000);
        }
        paramView = b.w(this.yYF);
        if (paramView != null) {
          paramView.stopTimer();
        }
        paramView = b.e(this.yYF);
        if (paramView != null)
        {
          paramView.setText((CharSequence)this.yYF.yYu);
          AppMethodBeat.o(102566);
          return;
        }
      }
      AppMethodBeat.o(102566);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-transvoice_release"})
  public static final class g
    implements TextWatcher
  {
    g(b paramb) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int i = 0;
      AppMethodBeat.i(102567);
      if ((!b.x(this.yYF)) && (b.q(this.yYF)))
      {
        b.y(this.yYF);
        b.p(this.yYF).yWu = 1;
      }
      Object localObject = b.z(this.yYF);
      if (localObject != null) {
        if (bt.ai((CharSequence)paramEditable)) {
          break label115;
        }
      }
      label115:
      for (boolean bool = true;; bool = false)
      {
        ((Button)localObject).setEnabled(bool);
        localObject = b.A(this.yYF);
        if (localObject == null) {
          break;
        }
        if (bt.ai((CharSequence)paramEditable)) {
          i = 4;
        }
        ((ImageView)localObject).setVisibility(i);
        AppMethodBeat.o(102567);
        return;
      }
      AppMethodBeat.o(102567);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "isKeyboardShow", "", "keyboardHeight", "", "onInputPanelChange"})
  static final class h
    implements TransVoicePanelLayout.a
  {
    h(b paramb) {}
    
    public final void g(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(102568);
      b.a(this.yYF, paramBoolean);
      ad.d("MicroMsg.TransVoiceDialog", "isKeyboardShow %s.", new Object[] { Boolean.valueOf(paramBoolean) });
      Object localObject;
      if (paramBoolean)
      {
        b.a(this.yYF, b.b.yYA);
        localObject = b.c(this.yYF);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState())) {
          b.a(this.yYF, b.c.yYD);
        }
        localObject = b.e(this.yYF);
        if (localObject != null) {
          ((MMEditText)localObject).setCursorVisible(true);
        }
        b.b(this.yYF, true);
        b.c(this.yYF, false);
        b.d(this.yYF, false);
        localObject = b.f(this.yYF);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(2131231701);
        }
        b.e(this.yYF, true);
      }
      for (;;)
      {
        if ((b.h(this.yYF) != paramInt) && (paramInt != 0))
        {
          b.a(this.yYF, paramInt);
          i.A(this.yYF.getContext(), paramInt);
          b.i(this.yYF);
        }
        AppMethodBeat.o(102568);
        return;
        localObject = b.c(this.yYF);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState()) && (b.b.yYz != b.b(this.yYF))) {
          b.a(this.yYF, b.c.yYC);
        }
        localObject = b.b(this.yYF);
        switch (c.ciE[localObject.ordinal()])
        {
        case 1: 
        default: 
          break;
        case 2: 
          b.a(this.yYF, b.b.yYy);
          if (b.c.yYD != b.d(this.yYF))
          {
            b.b(this.yYF, false);
            b.c(this.yYF, true);
            localObject = b.g(this.yYF);
            if (localObject != null) {
              ((ChatFooterPanel)localObject).setVisibility(8);
            }
            localObject = b.e(this.yYF);
            if (localObject != null) {
              ((MMEditText)localObject).setCursorVisible(false);
            }
            b.e(this.yYF, false);
          }
          break;
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102569);
      ad.i("MicroMsg.TransVoiceDialog", "sendVoiceMsg onClick.");
      paramView = this.yYF.yYv;
      if ((paramView != null) && (true == paramView.a(this.yYF.yYd, Long.valueOf(this.yYF.yYc)))) {
        b.F(this.yYF);
      }
      b.b(this.yYF, 7);
      AppMethodBeat.o(102569);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102570);
      b.o(this.yYF);
      AppMethodBeat.o(102570);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$12", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static final class k
    implements a.b
  {
    public final void PC(int paramInt)
    {
      AppMethodBeat.i(102571);
      Object localObject1 = b.B(this.yYF);
      if (localObject1 != null) {
        ((a)localObject1).dismiss();
      }
      b.d(this.yYF, paramInt);
      if (paramInt == b.C(this.yYF))
      {
        AppMethodBeat.o(102571);
        return;
      }
      if (ay.isConnected(this.yYF.getContext()))
      {
        localObject1 = this.yYF;
        ((b)localObject1).yXQ = false;
        ((b)localObject1).qfi = false;
        ((b)localObject1).yXO.yWl = ((b)localObject1).yXP;
        ((b)localObject1).yXO.yWo = 0;
        ((b)localObject1).yXO.yWp = 0L;
        ((b)localObject1).yXO.yWq = 0;
        ((b)localObject1).yXO.yWt = 0;
        ((b)localObject1).yXO.yWu = 0;
        ((b)localObject1).yXO.yWv = 0;
        ((b)localObject1).dQR();
        localObject2 = ((b)localObject1).yYk;
        if (localObject2 != null) {
          ((ap)localObject2).sendEmptyMessageDelayed(5000, 5000L);
        }
        localObject2 = ((b)localObject1).yYh;
        if (localObject2 != null) {
          ((av)localObject2).vE(500L);
        }
        ((b)localObject1).hDN = paramInt;
        long l2 = System.nanoTime() & 0xFFFFFFFF;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = Math.abs(l2);
        }
        localObject2 = new h(String.valueOf(l1));
        h localh = ((b)localObject1).hDI;
        if (localh != null) {
          localh.a((h)localObject2);
        }
        ((b)localObject1).yYa = new com.tencent.mm.plugin.transvoice.a.b((h)localObject2, paramInt, (g.b)new b.y((b)localObject1));
        localObject1 = ((b)localObject1).yYa;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.transvoice.a.b)localObject1).start();
          AppMethodBeat.o(102571);
          return;
        }
        AppMethodBeat.o(102571);
        return;
      }
      localObject1 = new d.a(this.yYF.getContext());
      Object localObject2 = this.yYF.getContext();
      k.g(localObject2, "context");
      ((d.a)localObject1).aMg(((Context)localObject2).getResources().getString(2131755828));
      localObject2 = this.yYF.getContext();
      k.g(localObject2, "context");
      ((d.a)localObject1).aMm(((Context)localObject2).getResources().getString(2131761549));
      localObject2 = this.yYF.getContext();
      k.g(localObject2, "context");
      ((d.a)localObject1).aaD(((Context)localObject2).getResources().getColor(2131099770));
      ((d.a)localObject1).fft().show();
      AppMethodBeat.o(102571);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class m
    implements ap.a
  {
    m(b paramb) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(102573);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(102573);
        return true;
        b.p(this.yYF).yWo = 1;
        b.p(this.yYF).yWp = System.currentTimeMillis();
        b.p(this.yYF).yWt = 0;
        paramMessage = b.w(this.yYF);
        if (paramMessage != null) {
          paramMessage.stopTimer();
        }
        paramMessage = b.t(this.yYF);
        if (paramMessage != null) {
          paramMessage.cancel(false);
        }
        if (!bt.isNullOrNil(this.yYF.yYu))
        {
          paramMessage = b.e(this.yYF);
          if (paramMessage != null) {
            paramMessage.setFocusable(true);
          }
          paramMessage = b.e(this.yYF);
          if (paramMessage != null) {
            paramMessage.setFocusableInTouchMode(true);
          }
        }
        paramMessage = b.e(this.yYF);
        if (paramMessage != null) {
          paramMessage.setText((CharSequence)this.yYF.yYu);
        }
        paramMessage = b.u(this.yYF);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class n
    implements DialogInterface.OnDismissListener
  {
    n(b paramb) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(102574);
      ad.d("MicroMsg.TransVoiceDialog", "onDismiss.");
      if (b.G(this.yYF))
      {
        b.H(this.yYF);
        if (!bt.isNullOrNil(b.I(this.yYF)))
        {
          paramDialogInterface = this.yYF.yYv;
          if (paramDialogInterface != null) {
            paramDialogInterface.asS(b.I(this.yYF));
          }
          b.b(this.yYF, b.I(this.yYF));
        }
      }
      AppMethodBeat.o(102574);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$2", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class o
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102576);
      k.h(paramView, "bottomSheet");
      ad.d("MicroMsg.TransVoiceDialog", "slideOffset: %f, panelDragOpeMode: %s.", new Object[] { Float.valueOf(paramFloat), b.d(this.yYF) });
      paramView = b.c(this.yYF);
      if (paramView != null)
      {
        if (paramView.getState() != 1) {
          break label305;
        }
        if (b.c.yYC == b.d(this.yYF))
        {
          paramView = this.yYF;
          if (0.7F < paramFloat) {
            break label239;
          }
          bool = true;
          b.f(paramView, bool);
          paramView = this.yYF.getWindow();
          if (paramView != null) {
            paramView.setDimAmount((float)(0.5D - (1.0F - paramFloat) / 2.0D));
          }
        }
        if (b.c.yYD != b.d(this.yYF)) {
          break label305;
        }
        paramView = this.yYF;
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
        if (b.l(this.yYF)) {
          break label305;
        }
        b.h(this.yYF, true);
        b.i(this.yYF, false);
        b.b(this.yYF, false);
        b.c(this.yYF, false);
        b.d(this.yYF, false);
        paramView = b.f(this.yYF);
        if (paramView == null) {
          break label249;
        }
        paramView.setImageResource(2131231701);
        AppMethodBeat.o(102576);
        return;
        AppMethodBeat.o(102576);
        return;
        bool = false;
        break;
      }
      label249:
      AppMethodBeat.o(102576);
      return;
      label255:
      if (b.l(this.yYF))
      {
        b.h(this.yYF, false);
        b.i(this.yYF, true);
        b.b(this.yYF, true);
        b.c(this.yYF, false);
        b.d(this.yYF, false);
      }
      label305:
      AppMethodBeat.o(102576);
    }
    
    @SuppressLint({"SwitchIntDef"})
    public final void k(View paramView, int paramInt)
    {
      AppMethodBeat.i(102577);
      k.h(paramView, "bottomSheet");
      ad.d("MicroMsg.TransVoiceDialog", "newState: %d, panelDragOpeMode: %s, canClosePanel: %s, canHideKeyboard: %s, canCloseKeyboard: %s.", new Object[] { Integer.valueOf(paramInt), b.d(this.yYF), Boolean.valueOf(b.j(this.yYF)), Boolean.valueOf(b.l(this.yYF)), Boolean.valueOf(b.k(this.yYF)) });
      switch (paramInt)
      {
      }
      while ((1 != paramInt) && (3 != paramInt)) {
        if (!b.j(this.yYF))
        {
          paramView = this.yYF.getWindow();
          if (paramView != null) {
            paramView.setDimAmount(0.5F);
          }
          paramView = b.c(this.yYF);
          if (paramView != null)
          {
            paramView.cv();
            AppMethodBeat.o(102577);
            return;
            b.f(this.yYF, false);
            b.h(this.yYF, false);
            b.g(this.yYF, false);
            continue;
            if ((b.c.yYC == b.d(this.yYF)) && (b.j(this.yYF))) {
              b.b(this.yYF, 6);
            }
            if ((b.c.yYD == b.d(this.yYF)) && (b.l(this.yYF))) {
              if (b.k(this.yYF))
              {
                b.a(this.yYF, b.c.yYC);
                b.c(this.yYF, true);
                b.b(this.yYF, false);
                paramView = b.g(this.yYF);
                if (paramView != null) {
                  paramView.setVisibility(8);
                }
                paramView = b.e(this.yYF);
                if (paramView != null) {
                  paramView.setCursorVisible(false);
                }
                b.e(this.yYF, false);
                paramView = b.m(this.yYF);
                if (paramView != null) {
                  paramView.postDelayed((Runnable)new a(this), 200L);
                }
              }
              else
              {
                b.i(this.yYF, true);
                b.b(this.yYF, true);
                b.c(this.yYF, false);
                b.d(this.yYF, false);
              }
            }
          }
          else
          {
            AppMethodBeat.o(102577);
          }
        }
        else
        {
          b.b(this.yYF, 6);
        }
      }
      AppMethodBeat.o(102577);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.o paramo) {}
      
      public final void run()
      {
        AppMethodBeat.i(102575);
        TransVoicePanelLayout localTransVoicePanelLayout = b.m(this.yYH.yYF);
        if (localTransVoicePanelLayout != null)
        {
          localTransVoicePanelLayout.requestLayout();
          AppMethodBeat.o(102575);
          return;
        }
        AppMethodBeat.o(102575);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$ExternalTouchHelper;", "downY", "", "getDownY", "()F", "setDownY", "(F)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onNeedJudge", "plugin-transvoice_release"})
  public static final class p
    implements MMBottomSheetBehavior.b
  {
    private float cFa;
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      Boolean localBoolean = null;
      AppMethodBeat.i(102578);
      k.h(paramMotionEvent, "event");
      k.h(paramMotionEvent, "event");
      Object localObject = b.n(this.yYF);
      int i;
      if (localObject != null)
      {
        MMEditText localMMEditText = b.e(this.yYF);
        if (localMMEditText == null) {
          k.fvU();
        }
        if (true == ((CoordinatorLayout)localObject).d((View)localMMEditText, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          i = 1;
          if (i != 0)
          {
            localObject = b.e(this.yYF);
            if (localObject == null) {
              break label268;
            }
            localObject = Boolean.valueOf(((MMEditText)localObject).canScrollVertically(-1));
            label106:
            localMMEditText = b.e(this.yYF);
            if (localMMEditText != null) {
              localBoolean = Boolean.valueOf(localMMEditText.canScrollVertically(1));
            }
            ad.d("MicroMsg.TransVoiceDialog", "can scroll up, %s.", new Object[] { localObject });
            ad.d("MicroMsg.TransVoiceDialog", "can scroll down, %s.", new Object[] { localBoolean });
            ad.d("MicroMsg.TransVoiceDialog", "action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
            switch (paramMotionEvent.getAction())
            {
            }
          }
        }
      }
      label268:
      float f;
      do
      {
        for (;;)
        {
          AppMethodBeat.o(102578);
          return false;
          i = 0;
          break;
          localObject = null;
          break label106;
          this.cFa = paramMotionEvent.getY();
        }
        f = paramMotionEvent.getY() - this.cFa;
        ad.d("MicroMsg.TransVoiceDialog", "yOffset: %f.", new Object[] { Float.valueOf(f) });
        if (f > 0.0F)
        {
          bool = k.g(Boolean.TRUE, localObject);
          AppMethodBeat.o(102578);
          return bool;
        }
      } while (f >= 0.0F);
      boolean bool = k.g(Boolean.TRUE, localBoolean);
      AppMethodBeat.o(102578);
      return bool;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102579);
      b.b(this.yYF, 6);
      AppMethodBeat.o(102579);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102580);
      b.a(this.yYF, System.currentTimeMillis());
      paramView = b.B(this.yYF);
      if (paramView != null) {
        paramView.hDN = b.C(this.yYF);
      }
      paramView = b.B(this.yYF);
      if (paramView != null) {
        paramView.dQG();
      }
      paramView = b.B(this.yYF);
      if (paramView != null)
      {
        paramView.show();
        AppMethodBeat.o(102580);
        return;
      }
      AppMethodBeat.o(102580);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102581);
      paramView = b.b(this.yYF);
      switch (c.fPQ[paramView.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(102581);
        return;
        b.i(this.yYF, false);
        AppMethodBeat.o(102581);
        return;
        b.a(this.yYF, b.b.yYy);
        b.b(this.yYF, false);
        b.c(this.yYF, true);
        paramView = b.g(this.yYF);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = b.e(this.yYF);
        if (paramView != null) {
          paramView.setCursorVisible(false);
        }
        b.e(this.yYF, false);
        AppMethodBeat.o(102581);
        return;
        b.a(this.yYF, b.b.yYy);
        b.b(this.yYF, 6);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102582);
      if (b.a(this.yYF))
      {
        b.a(this.yYF, b.b.yYz);
        b.i(this.yYF, false);
        b.d(this.yYF, true);
        paramView = b.f(this.yYF);
        if (paramView != null)
        {
          paramView.setImageResource(2131231706);
          AppMethodBeat.o(102582);
          return;
        }
        AppMethodBeat.o(102582);
        return;
      }
      b.a(this.yYF, b.b.yYA);
      b.i(this.yYF, true);
      b.d(this.yYF, false);
      paramView = b.f(this.yYF);
      if (paramView != null)
      {
        paramView.setImageResource(2131231701);
        AppMethodBeat.o(102582);
        return;
      }
      AppMethodBeat.o(102582);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class u
    implements av.a
  {
    u(b paramb) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(102583);
      int i = b.D(this.yYF);
      b localb = this.yYF;
      b.c(localb, b.D(localb) + 1);
      switch (i % 3)
      {
      }
      for (;;)
      {
        b.E(this.yYF);
        AppMethodBeat.o(102583);
        return true;
        b.a(this.yYF, "·");
        continue;
        b.a(this.yYF, "··");
        continue;
        b.a(this.yYF, "···");
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-transvoice_release"})
  public static final class v
    implements ChatFooterPanel.a
  {
    public final void append(String paramString)
    {
      AppMethodBeat.i(102584);
      MMEditText localMMEditText = b.e(this.yYF);
      if (localMMEditText != null)
      {
        localMMEditText.aMd(paramString);
        AppMethodBeat.o(102584);
        return;
      }
      AppMethodBeat.o(102584);
    }
    
    public final void btF()
    {
      AppMethodBeat.i(102585);
      Object localObject = b.e(this.yYF);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = b.e(this.yYF);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(102585);
          return;
        }
      }
      AppMethodBeat.o(102585);
    }
    
    public final void cqY()
    {
      AppMethodBeat.i(102586);
      b.o(this.yYF);
      AppMethodBeat.o(102586);
    }
    
    public final void lf(boolean paramBoolean) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(b paramb, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(102587);
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)b.e(this.yYF), 0);
        AppMethodBeat.o(102587);
        return;
      }
      AppMethodBeat.o(102587);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class x
    implements g.b
  {
    public final void aDQ()
    {
      AppMethodBeat.i(102590);
      ad.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102590);
    }
    
    public final void aDU()
    {
      AppMethodBeat.i(102591);
      ad.i("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.yYF, false);
      b.p(this.yYF).yWt = 1;
      b.p(this.yYF).yWp = System.currentTimeMillis();
      Object localObject = b.v(this.yYF);
      if (localObject != null) {
        ((ap)localObject).removeMessages(5000);
      }
      localObject = b.w(this.yYF);
      if (localObject != null) {
        ((av)localObject).stopTimer();
      }
      b.J(this.yYF);
      localObject = b.u(this.yYF);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        AppMethodBeat.o(102591);
        return;
      }
      AppMethodBeat.o(102591);
    }
    
    public final void b(String[] paramArrayOfString, List<String> paramList)
    {
      AppMethodBeat.i(102588);
      ad.i("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.yYF, paramList);
      paramList = b.v(this.yYF);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.yYF);
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
            this.yYF.asR(paramArrayOfString[0]);
            ad.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.yYF.yYu });
            b.p(this.yYF).yWq = this.yYF.yYu.length();
            if (b.s(this.yYF)) {
              break;
            }
            b.j(this.yYF, true);
            paramArrayOfString = b.e(this.yYF);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.yYF);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.yYF);
            if (paramArrayOfString == null) {
              break;
            }
            paramArrayOfString.requestFocus();
            AppMethodBeat.o(102588);
            return;
          }
        }
      }
      AppMethodBeat.o(102588);
      return;
      AppMethodBeat.o(102588);
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(102589);
      ad.i("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
      b.p(this.yYF).yWt = 0;
      b.p(this.yYF).yWp = System.currentTimeMillis();
      AppMethodBeat.o(102589);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$2", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class y
    implements g.b
  {
    public final void aDQ()
    {
      AppMethodBeat.i(102594);
      ad.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102594);
    }
    
    public final void aDU()
    {
      AppMethodBeat.i(102595);
      ad.d("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.yYF, false);
      b.p(this.yYF).yWt = 1;
      b.p(this.yYF).yWp = System.currentTimeMillis();
      Object localObject = b.v(this.yYF);
      if (localObject != null) {
        ((ap)localObject).removeMessages(5000);
      }
      localObject = b.w(this.yYF);
      if (localObject != null) {
        ((av)localObject).stopTimer();
      }
      b.J(this.yYF);
      localObject = b.u(this.yYF);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        AppMethodBeat.o(102595);
        return;
      }
      AppMethodBeat.o(102595);
    }
    
    public final void b(String[] paramArrayOfString, List<String> paramList)
    {
      AppMethodBeat.i(102592);
      ad.d("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.yYF, paramList);
      paramList = b.v(this.yYF);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.yYF);
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
            this.yYF.asR(paramArrayOfString[0]);
            ad.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.yYF.yYu });
            b.p(this.yYF).yWq = this.yYF.yYu.length();
            if (b.s(this.yYF)) {
              break;
            }
            b.j(this.yYF, true);
            paramArrayOfString = b.e(this.yYF);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.yYF);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.yYF);
            if (paramArrayOfString == null) {
              break;
            }
            paramArrayOfString.requestFocus();
            AppMethodBeat.o(102592);
            return;
          }
        }
      }
      AppMethodBeat.o(102592);
      return;
      AppMethodBeat.o(102592);
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(102593);
      ad.d("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
      b.p(this.yYF).yWt = 0;
      b.p(this.yYF).yWp = System.currentTimeMillis();
      AppMethodBeat.o(102593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b
 * JD-Core Version:    0.7.0.1
 */