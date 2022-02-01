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
import com.tencent.mm.api.ad;
import com.tencent.mm.cj.a.a;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.plugin.transvoice.a.c;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "bottomSheetCoordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "btnLayout", "canCloseKeyboard", "", "canClosePanel", "canHideKeyboard", "closeInputMethod", "Landroid/widget/ImageView;", "closePanel", "container", "Lcom/tencent/mm/modelvoiceaddr/ShortSentenceContainer;", "curTxt", "", "getCurTxt", "()Ljava/lang/String;", "setCurTxt", "(Ljava/lang/String;)V", "dotCounter", "", "dotStr", "emojiRoot", "Landroid/widget/FrameLayout;", "hasClick", "inputMethodLayout", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoicePanelLayout;", "inputMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "isEdited", "isKeyboardShown", "keyboardHeight", "langType", "languageChoiceDialog", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "mNewVoiceInputReport", "Lcom/tencent/mm/modelvoiceaddr/voicereport/NewVoiceInputReportManager;", "mVoiceIdSet", "", "needSendTxtMsg", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "overTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "panelDragOpeMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "reporter", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "sendTxtMsg", "Landroid/widget/Button;", "sendVoiceMsg", "showImeRunnable", "Ljava/lang/Runnable;", "smileyItem", "smileyOpener", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "talker", "getTalker", "setTalker", "targetView", "tmpClickChangeLangTypeTime", "", "transCancelable", "transMore", "transPanelAction", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "getTransPanelAction", "()Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "setTransPanelAction", "(Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;)V", "transSP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "txtEditView", "Lcom/tencent/mm/ui/widget/MMEditText;", "txtMsg4Send", "updateDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceAddr", "Lcom/tencent/mm/plugin/transvoice/model/SceneVoiceInputAddr2;", "value", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "voiceLen", "getVoiceLen", "()J", "setVoiceLen", "(J)V", "voiceMsgSend", "cgiReport", "", "msg", "closeInputMethodBtnVisibility", "visible", "closeTransPanel", "exitType", "delPunctuation", "getContentTxt", "init", "initSmileyPanel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshBottomPanelHeight", "resetTransPanel", "saveTransLangTypeByTalker", "type", "setBottomBtnVisibility", "setKeyboardVisibility", "setSmileyItemVisibility", "setSmileyPanelVisibility", "show", "startTrans", "updateCurTxt", "updateTransLangTypeByTalker", "Companion", "InputMode", "PanelDragOpeMode", "TransPanelAction", "plugin-transvoice_release"})
public final class b
  extends e
{
  public static int Gwb;
  public static final a Gwc;
  private FrameLayout FBO;
  private boolean FBV;
  private ImageView Guf;
  private MMBottomSheetBehavior<View> Gui;
  private boolean Guj;
  private a.b Guk;
  private View GvA;
  private ImageView GvB;
  private Button GvC;
  private Button GvD;
  com.tencent.mm.plugin.transvoice.a.b GvE;
  private b GvF;
  public long GvG;
  String GvH;
  private boolean GvI;
  private String GvJ;
  private int GvK;
  MTimerHandler GvL;
  private boolean GvM;
  private a GvN;
  MMHandler GvO;
  private SharedPreferences GvP;
  boolean GvQ;
  private CoordinatorLayout GvR;
  private c GvS;
  private boolean GvT;
  private boolean GvU;
  private boolean GvV;
  private String GvW;
  private final com.tencent.mm.modelvoiceaddr.b.b GvX;
  private List<String> GvY;
  String GvZ;
  final c Gvs;
  long Gvt;
  boolean Gvu;
  private TransVoicePanelLayout Gvv;
  private MMEditText Gvw;
  private ImageView Gvx;
  private ImageView Gvy;
  private View Gvz;
  public d Gwa;
  h jvN;
  int jvS;
  private int oXi;
  private final Runnable ruJ;
  private ChatFooterPanel rum;
  public String talker;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(102605);
    Gwc = new a((byte)0);
    Gwb = -1;
    AppMethodBeat.o(102605);
  }
  
  public b(final Context paramContext)
  {
    super(paramContext, 2131821534);
    AppMethodBeat.i(102604);
    c.a locala = c.Guc;
    this.Gvs = c.fAu();
    this.jvS = g.jwq;
    this.GvF = b.Gwd;
    this.GvJ = "";
    this.GvP = paramContext.getSharedPreferences("voice2txt_sp", 0);
    this.GvS = c.Gwh;
    this.GvW = "";
    gR();
    this.GvX = new com.tencent.mm.modelvoiceaddr.b.b();
    this.ruJ = ((Runnable)new w(this, paramContext));
    this.GvZ = "";
    AppMethodBeat.o(102604);
  }
  
  private final void acv(int paramInt)
  {
    AppMethodBeat.i(102600);
    if (isShowing())
    {
      this.Gvs.setExitType(paramInt);
      fAH();
      dismiss();
      d locald = this.Gwa;
      if (locald != null) {
        locald.fAI();
      }
      if (!this.GvI)
      {
        locald = this.Gwa;
        if (locald != null) {
          locald.aTQ(this.GvH);
        }
      }
      this.GvI = false;
    }
    AppMethodBeat.o(102600);
  }
  
  private final void setKeyboardVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(102599);
    Log.d("MicroMsg.TransVoiceDialog", "setKeyboardVisibility, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      localObject = this.targetView;
      if (localObject != null) {
        ((View)localObject).removeCallbacks(this.ruJ);
      }
      localObject = this.targetView;
      if (localObject != null)
      {
        ((View)localObject).post(this.ruJ);
        AppMethodBeat.o(102599);
        return;
      }
      AppMethodBeat.o(102599);
      return;
    }
    Object localObject = this.targetView;
    if (localObject != null) {
      ((View)localObject).removeCallbacks(this.ruJ);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localObject = this.Gvw;
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
  
  private final void wA(boolean paramBoolean)
  {
    AppMethodBeat.i(102598);
    if (paramBoolean)
    {
      localImageView = this.Gvx;
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        AppMethodBeat.o(102598);
        return;
      }
      AppMethodBeat.o(102598);
      return;
    }
    ImageView localImageView = this.Gvx;
    if (localImageView != null)
    {
      localImageView.setVisibility(0);
      AppMethodBeat.o(102598);
      return;
    }
    AppMethodBeat.o(102598);
  }
  
  public final void aTN(String paramString)
  {
    AppMethodBeat.i(185255);
    if (!Util.isNullOrNil(paramString))
    {
      this.GvH = paramString;
      a.a locala = com.tencent.mm.cj.a.Owq;
      if (paramString == null) {
        p.hyc();
      }
      p.h(paramString, "<set-?>");
      com.tencent.mm.cj.a.blG(paramString);
    }
    AppMethodBeat.o(185255);
  }
  
  public final void aTO(String paramString)
  {
    AppMethodBeat.i(102602);
    p.h(paramString, "<set-?>");
    this.GvZ = paramString;
    AppMethodBeat.o(102602);
  }
  
  public final void c(h paramh)
  {
    AppMethodBeat.i(185256);
    p.h(paramh, "container");
    Object localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).setDimAmount(0.5F);
    }
    localObject = this.Gui;
    if (localObject != null) {
      ((MMBottomSheetBehavior)localObject).cU();
    }
    this.Gvu = false;
    this.GvQ = false;
    int i = this.GvP.getInt(this.talker, 0);
    localObject = this.GvN;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((a)localObject).Gug;
    if (localObject == null) {
      p.hyc();
    }
    if (((ArrayList)localObject).contains(Integer.valueOf(i))) {
      this.jvS = i;
    }
    for (;;)
    {
      this.Gvs.GtR = this.jvS;
      fAH();
      localObject = this.GvO;
      if (localObject != null) {
        ((MMHandler)localObject).sendEmptyMessageDelayed(5000, 5000L);
      }
      localObject = this.GvL;
      if (localObject != null) {
        ((MTimerHandler)localObject).startTimer(500L);
      }
      this.jvN = paramh;
      this.GvE = new com.tencent.mm.plugin.transvoice.a.b(paramh, this.jvS, (g.b)new x(this));
      paramh = this.GvE;
      if (paramh == null) {
        break;
      }
      paramh.start();
      AppMethodBeat.o(185256);
      return;
      localObject = this.GvN;
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((a)localObject).Gug;
      if (localObject == null) {
        p.hyc();
      }
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = this.GvN;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((a)localObject).Gug;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((ArrayList)localObject).get(0);
        p.g(localObject, "languageChoiceDialog!!.langTypeArr!![0]");
        this.jvS = ((Number)localObject).intValue();
      }
      else
      {
        localObject = LocaleUtil.getCurrentLanguage(getContext());
        if ((p.j(localObject, "zh_CN")) || (p.j(localObject, "zh_HK")) || (p.j(localObject, "zh_TW"))) {
          this.jvS = g.jwq;
        } else if (p.j(localObject, "en")) {
          this.jvS = g.jws;
        }
      }
    }
    AppMethodBeat.o(185256);
  }
  
  final void fAH()
  {
    AppMethodBeat.i(102601);
    this.GvZ = "";
    this.GvK = 0;
    this.GvJ = "";
    this.GvM = false;
    Object localObject = this.Gvw;
    if (localObject != null) {
      ((MMEditText)localObject).setText((CharSequence)"");
    }
    localObject = this.Gvw;
    if (localObject != null) {
      ((MMEditText)localObject).setCursorVisible(false);
    }
    localObject = this.Gvw;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusable(false);
    }
    localObject = this.Gvw;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusableInTouchMode(false);
    }
    localObject = this.Gvz;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.GvA;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    setKeyboardVisibility(false);
    localObject = this.rum;
    if (localObject != null) {
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    wA(false);
    localObject = this.GvO;
    if (localObject != null) {
      ((MMHandler)localObject).removeMessages(5000);
    }
    this.GvS = c.Gwh;
    this.Guj = false;
    this.GvT = false;
    this.GvU = false;
    AppMethodBeat.o(102601);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(102597);
    acv(6);
    super.onBackPressed();
    AppMethodBeat.o(102597);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102596);
    this.targetView = LayoutInflater.from(getContext()).inflate(2131496762, null, false);
    Object localObject = new ViewGroup.LayoutParams(-1, -1);
    View localView = this.targetView;
    if (localView == null) {
      p.hyc();
    }
    setContentView(localView, (ViewGroup.LayoutParams)localObject);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(67108864);
      paramBundle.setLayout(-1, -1);
      paramBundle.setSoftInputMode(34);
      paramBundle.setDimAmount(0.5F);
      paramBundle.setWindowAnimations(2131820793);
    }
    paramBundle = this.targetView;
    if (paramBundle != null)
    {
      paramBundle = (TransVoicePanelLayout)paramBundle.findViewById(2131302680);
      this.Gvv = paramBundle;
      paramBundle = this.Gvv;
      if (paramBundle != null) {
        paramBundle.setOnInputPanelChange((TransVoicePanelLayout.a)new h(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1065;
      }
      paramBundle = (CoordinatorLayout)paramBundle.findViewById(2131296761);
      label169:
      this.GvR = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1070;
      }
      paramBundle = paramBundle.findViewById(2131306536);
      label191:
      this.Gui = MMBottomSheetBehavior.x(paramBundle);
      paramBundle = this.Gui;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new o(this));
      }
      paramBundle = this.Gui;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.b)new p(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1075;
      }
      paramBundle = (MMEditText)paramBundle.findViewById(2131309389);
      label267:
      this.Gvw = paramBundle;
      paramBundle = this.Gvw;
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
        break label1080;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131298784);
      label363:
      this.Guf = paramBundle;
      paramBundle = this.Guf;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new q(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1085;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131309390);
      label412:
      this.Gvx = paramBundle;
      paramBundle = this.Gvx;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new r(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1090;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131298779);
      label461:
      this.Gvy = paramBundle;
      paramBundle = this.Gvy;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new s(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1095;
      }
      paramBundle = paramBundle.findViewById(2131306534);
      label507:
      this.Gvz = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1100;
      }
      paramBundle = paramBundle.findViewById(2131307950);
      label529:
      this.GvA = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1105;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131307955);
      label554:
      this.GvB = paramBundle;
      paramBundle = this.GvB;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new t(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1110;
      }
      paramBundle = (FrameLayout)paramBundle.findViewById(2131300044);
      label603:
      this.FBO = paramBundle;
      this.rum = ((ChatFooterPanel)ad.bC(getContext()));
      this.oXi = KeyBoardUtil.getValidPanelHeight(getContext());
      paramBundle = new FrameLayout.LayoutParams(-1, this.oXi);
      localObject = this.FBO;
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.rum, (ViewGroup.LayoutParams)paramBundle);
      }
      paramBundle = this.rum;
      if (paramBundle != null) {
        paramBundle.setPortHeightPx(this.oXi);
      }
      paramBundle = this.rum;
      if (paramBundle != null) {
        paramBundle.setEntranceScene(ChatFooterPanel.KbB);
      }
      paramBundle = this.rum;
      if (paramBundle != null) {
        paramBundle.goD();
      }
      paramBundle = this.rum;
      if (paramBundle != null) {
        paramBundle.onResume();
      }
      paramBundle = this.rum;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.rum;
      if (paramBundle != null) {
        paramBundle.setShowSend(true);
      }
      paramBundle = this.rum;
      if (paramBundle != null) {
        paramBundle.setOnTextOperationListener((ChatFooterPanel.a)new v(this));
      }
      this.GvL = new MTimerHandler((MTimerHandler.CallBack)new u(this), true);
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1115;
      }
      paramBundle = (Button)paramBundle.findViewById(2131297847);
      label824:
      this.GvC = paramBundle;
      paramBundle = this.GvC;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new i(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1120;
      }
      paramBundle = (Button)paramBundle.findViewById(2131297848);
      label873:
      this.GvD = paramBundle;
      paramBundle = this.GvD;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new j(this));
      }
      paramBundle = this.GvC;
      if (paramBundle == null) {
        break label1125;
      }
      paramBundle = paramBundle.getPaint();
      label916:
      ao.a((Paint)paramBundle, 0.8F);
      paramBundle = this.GvD;
      if (paramBundle == null) {
        break label1130;
      }
    }
    label1065:
    label1070:
    label1075:
    label1080:
    label1085:
    label1090:
    label1095:
    label1100:
    label1105:
    label1110:
    label1115:
    label1120:
    label1125:
    label1130:
    for (paramBundle = paramBundle.getPaint();; paramBundle = null)
    {
      ao.a((Paint)paramBundle, 0.8F);
      this.Guk = ((a.b)new k(this));
      paramBundle = getContext();
      p.g(paramBundle, "context");
      this.GvN = new a(paramBundle);
      paramBundle = this.GvN;
      if (paramBundle != null)
      {
        paramBundle.setOnDismissListener((DialogInterface.OnDismissListener)b.l.Gwl);
        paramBundle.Guk = this.Guk;
      }
      this.GvO = new MMHandler((MMHandler.Callback)new m(this));
      setOnDismissListener((DialogInterface.OnDismissListener)new n(this));
      AppMethodBeat.o(102596);
      return;
      paramBundle = null;
      break;
      paramBundle = null;
      break label169;
      paramBundle = null;
      break label191;
      paramBundle = null;
      break label267;
      paramBundle = null;
      break label363;
      paramBundle = null;
      break label412;
      paramBundle = null;
      break label461;
      paramBundle = null;
      break label507;
      paramBundle = null;
      break label529;
      paramBundle = null;
      break label554;
      paramBundle = null;
      break label603;
      paramBundle = null;
      break label824;
      paramBundle = null;
      break label873;
      paramBundle = null;
      break label916;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(102603);
    a.a locala = com.tencent.mm.cj.a.Owq;
    com.tencent.mm.cj.a.AQ(true);
    super.show();
    AppMethodBeat.o(102603);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$Companion;", "", "()V", "MODE_ONLY_PANEL_CLOSE_PANEL_OFFSET", "", "MODE_WITH_KEYBOARD_CLOSE_KEYBOARD_OFFSET", "MODE_WITH_KEYBOARD_HIDE_KEYBOARD_OFFSET", "OVERTIME_INTERVAL", "", "OVERTIME_MSG", "", "SP_NAME", "", "TAG", "UPDATE_DOT_STR_INTERVAL", "trans2txt_cmd", "trans2txt_cmd_close", "trans2txt_cmd_invalid", "trans2txt_cmd_open", "plugin-transvoice_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "", "(Ljava/lang/String;I)V", "INPUT_NONE", "INPUT_EMOJI", "INPUT_KEYBOARD", "plugin-transvoice_release"})
  static enum b
  {
    static
    {
      AppMethodBeat.i(102558);
      b localb1 = new b("INPUT_NONE", 0);
      Gwd = localb1;
      b localb2 = new b("INPUT_EMOJI", 1);
      Gwe = localb2;
      b localb3 = new b("INPUT_KEYBOARD", 2);
      Gwf = localb3;
      Gwg = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(102558);
    }
    
    private b() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "", "(Ljava/lang/String;I)V", "MODE_ONLY_PANEL", "MODE_WITH_KEYBOARD", "plugin-transvoice_release"})
  static enum c
  {
    static
    {
      AppMethodBeat.i(102561);
      c localc1 = new c("MODE_ONLY_PANEL", 0);
      Gwh = localc1;
      c localc2 = new c("MODE_WITH_KEYBOARD", 1);
      Gwi = localc2;
      Gwj = new c[] { localc1, localc2 };
      AppMethodBeat.o(102561);
    }
    
    private c() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "", "onTransPanelClose", "", "onTxtMsgSend", "txt", "", "onVoiceMsgDelete", "fileName", "onVoiceMsgSend", "", "fileLength", "", "(Ljava/lang/String;Ljava/lang/Long;)Z", "plugin-transvoice_release"})
  public static abstract interface d
  {
    public abstract void aTP(String paramString);
    
    public abstract void aTQ(String paramString);
    
    public abstract boolean b(String paramString, Long paramLong);
    
    public abstract void fAI();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$1"})
  static final class e
    implements TextView.OnEditorActionListener
  {
    e(b paramb) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(102565);
      if (4 != paramInt)
      {
        p.g(paramKeyEvent, "event");
        if (66 != paramKeyEvent.getAction()) {}
      }
      else
      {
        b.o(this.Gwk);
        AppMethodBeat.o(102565);
        return true;
      }
      AppMethodBeat.o(102565);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$2"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102566);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      b.p(this.Gwk).Gua = 1;
      b.r(this.Gwk);
      if (b.s(this.Gwk))
      {
        b.j(this.Gwk, false);
        b.p(this.Gwk).GtY = 0;
        b.p(this.Gwk).GtU = System.currentTimeMillis();
        paramView = b.t(this.Gwk);
        if (paramView != null) {
          paramView.cancel(true);
        }
        paramView = b.u(this.Gwk);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = b.v(this.Gwk);
        if (paramView != null) {
          paramView.removeMessages(5000);
        }
        paramView = b.w(this.Gwk);
        if (paramView != null) {
          paramView.stopTimer();
        }
        paramView = b.e(this.Gwk);
        if (paramView != null) {
          paramView.setText((CharSequence)this.Gwk.GvZ);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102566);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-transvoice_release"})
  public static final class g
    implements TextWatcher
  {
    g(b paramb) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int i = 0;
      AppMethodBeat.i(102567);
      if ((!b.x(this.Gwk)) && (b.q(this.Gwk)))
      {
        b.y(this.Gwk);
        b.p(this.Gwk).GtZ = 1;
      }
      Object localObject = b.z(this.Gwk);
      if (localObject != null) {
        if (Util.isNullOrNil((CharSequence)paramEditable)) {
          break label115;
        }
      }
      label115:
      for (boolean bool = true;; bool = false)
      {
        ((Button)localObject).setEnabled(bool);
        localObject = b.A(this.Gwk);
        if (localObject == null) {
          break;
        }
        if (Util.isNullOrNil((CharSequence)paramEditable)) {
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isKeyboardShow", "", "keyboardHeight", "", "onInputPanelChange"})
  static final class h
    implements TransVoicePanelLayout.a
  {
    h(b paramb) {}
    
    public final void f(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(102568);
      b.a(this.Gwk, paramBoolean);
      Log.d("MicroMsg.TransVoiceDialog", "isKeyboardShow %s.", new Object[] { Boolean.valueOf(paramBoolean) });
      Object localObject;
      if (paramBoolean)
      {
        b.a(this.Gwk, b.b.Gwf);
        localObject = b.c(this.Gwk);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState())) {
          b.a(this.Gwk, b.c.Gwi);
        }
        localObject = b.e(this.Gwk);
        if (localObject != null) {
          ((MMEditText)localObject).setCursorVisible(true);
        }
        b.b(this.Gwk, true);
        b.c(this.Gwk, false);
        b.d(this.Gwk, false);
        localObject = b.f(this.Gwk);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(2131231772);
        }
        b.e(this.Gwk, true);
      }
      for (;;)
      {
        if ((b.h(this.Gwk) != paramInt) && (paramInt != 0))
        {
          b.a(this.Gwk, paramInt);
          i.C(this.Gwk.getContext(), paramInt);
          b.i(this.Gwk);
        }
        AppMethodBeat.o(102568);
        return;
        localObject = b.c(this.Gwk);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState()) && (b.b.Gwe != b.b(this.Gwk))) {
          b.a(this.Gwk, b.c.Gwh);
        }
        localObject = b.b(this.Gwk);
        switch (c.$EnumSwitchMapping$0[localObject.ordinal()])
        {
        case 1: 
        default: 
          break;
        case 2: 
          b.a(this.Gwk, b.b.Gwd);
          if (b.c.Gwi != b.d(this.Gwk))
          {
            b.b(this.Gwk, false);
            b.c(this.Gwk, true);
            localObject = b.g(this.Gwk);
            if (localObject != null) {
              ((ChatFooterPanel)localObject).setVisibility(8);
            }
            localObject = b.e(this.Gwk);
            if (localObject != null) {
              ((MMEditText)localObject).setCursorVisible(false);
            }
            b.e(this.Gwk, false);
          }
          break;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102569);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i("MicroMsg.TransVoiceDialog", "sendVoiceMsg onClick.");
      paramView = this.Gwk.Gwa;
      if ((paramView != null) && (true == paramView.b(this.Gwk.GvH, Long.valueOf(this.Gwk.GvG)))) {
        b.F(this.Gwk);
      }
      b.b(this.Gwk, 7);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102569);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102570);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      b.o(this.Gwk);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102570);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$12", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static final class k
    implements a.b
  {
    public final void acp(int paramInt)
    {
      AppMethodBeat.i(102571);
      Object localObject1 = b.B(this.Gwk);
      if (localObject1 != null) {
        ((a)localObject1).dismiss();
      }
      b.d(this.Gwk, paramInt);
      if (paramInt == b.C(this.Gwk))
      {
        AppMethodBeat.o(102571);
        return;
      }
      if (NetStatusUtil.isConnected(this.Gwk.getContext()))
      {
        localObject1 = this.Gwk;
        ((b)localObject1).Gvu = false;
        ((b)localObject1).GvQ = false;
        ((b)localObject1).Gvs.GtQ = ((b)localObject1).Gvt;
        ((b)localObject1).Gvs.GtT = 0;
        ((b)localObject1).Gvs.GtU = 0L;
        ((b)localObject1).Gvs.GtV = 0;
        ((b)localObject1).Gvs.GtY = 0;
        ((b)localObject1).Gvs.GtZ = 0;
        ((b)localObject1).Gvs.Gua = 0;
        ((b)localObject1).fAH();
        localObject2 = ((b)localObject1).GvO;
        if (localObject2 != null) {
          ((MMHandler)localObject2).sendEmptyMessageDelayed(5000, 5000L);
        }
        localObject2 = ((b)localObject1).GvL;
        if (localObject2 != null) {
          ((MTimerHandler)localObject2).startTimer(500L);
        }
        ((b)localObject1).jvS = paramInt;
        long l2 = System.nanoTime() & 0xFFFFFFFF;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = Math.abs(l2);
        }
        localObject2 = new h(String.valueOf(l1));
        h localh = ((b)localObject1).jvN;
        if (localh != null) {
          localh.a((h)localObject2);
        }
        ((b)localObject1).GvE = new com.tencent.mm.plugin.transvoice.a.b((h)localObject2, paramInt, (g.b)new b.y((b)localObject1));
        localObject1 = ((b)localObject1).GvE;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.transvoice.a.b)localObject1).start();
          AppMethodBeat.o(102571);
          return;
        }
        AppMethodBeat.o(102571);
        return;
      }
      localObject1 = new d.a(this.Gwk.getContext());
      Object localObject2 = this.Gwk.getContext();
      p.g(localObject2, "context");
      ((d.a)localObject1).boo(((Context)localObject2).getResources().getString(2131755914));
      localObject2 = this.Gwk.getContext();
      p.g(localObject2, "context");
      ((d.a)localObject1).bou(((Context)localObject2).getResources().getString(2131763515));
      localObject2 = this.Gwk.getContext();
      p.g(localObject2, "context");
      ((d.a)localObject1).aoX(((Context)localObject2).getResources().getColor(2131099784));
      ((d.a)localObject1).hbn().show();
      AppMethodBeat.o(102571);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class m
    implements MMHandler.Callback
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
        b.p(this.Gwk).GtT = 1;
        b.p(this.Gwk).GtU = System.currentTimeMillis();
        b.p(this.Gwk).GtY = 0;
        paramMessage = b.w(this.Gwk);
        if (paramMessage != null) {
          paramMessage.stopTimer();
        }
        paramMessage = b.t(this.Gwk);
        if (paramMessage != null) {
          paramMessage.cancel(false);
        }
        if (!Util.isNullOrNil(this.Gwk.GvZ))
        {
          paramMessage = b.e(this.Gwk);
          if (paramMessage != null) {
            paramMessage.setFocusable(true);
          }
          paramMessage = b.e(this.Gwk);
          if (paramMessage != null) {
            paramMessage.setFocusableInTouchMode(true);
          }
        }
        paramMessage = b.e(this.Gwk);
        if (paramMessage != null) {
          paramMessage.setText((CharSequence)this.Gwk.GvZ);
        }
        paramMessage = b.u(this.Gwk);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class n
    implements DialogInterface.OnDismissListener
  {
    n(b paramb) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(102574);
      Log.d("MicroMsg.TransVoiceDialog", "onDismiss.");
      if (b.G(this.Gwk))
      {
        b.H(this.Gwk);
        if (!Util.isNullOrNil(b.I(this.Gwk)))
        {
          paramDialogInterface = this.Gwk.Gwa;
          if (paramDialogInterface != null) {
            paramDialogInterface.aTP(b.I(this.Gwk));
          }
          b.b(this.Gwk, b.I(this.Gwk));
        }
      }
      AppMethodBeat.o(102574);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$2", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class o
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102576);
      p.h(paramView, "bottomSheet");
      Log.d("MicroMsg.TransVoiceDialog", "slideOffset: %f, panelDragOpeMode: %s.", new Object[] { Float.valueOf(paramFloat), b.d(this.Gwk) });
      paramView = b.c(this.Gwk);
      if (paramView != null)
      {
        if (paramView.getState() != 1) {
          break label305;
        }
        if (b.c.Gwh == b.d(this.Gwk))
        {
          paramView = this.Gwk;
          if (0.7F < paramFloat) {
            break label239;
          }
          bool = true;
          b.f(paramView, bool);
          paramView = this.Gwk.getWindow();
          if (paramView != null) {
            paramView.setDimAmount((float)(0.5D - (1.0F - paramFloat) / 2.0D));
          }
        }
        if (b.c.Gwi != b.d(this.Gwk)) {
          break label305;
        }
        paramView = this.Gwk;
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
        if (b.l(this.Gwk)) {
          break label305;
        }
        b.h(this.Gwk, true);
        b.i(this.Gwk, false);
        b.b(this.Gwk, false);
        b.c(this.Gwk, false);
        b.d(this.Gwk, false);
        paramView = b.f(this.Gwk);
        if (paramView == null) {
          break label249;
        }
        paramView.setImageResource(2131231772);
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
      if (b.l(this.Gwk))
      {
        b.h(this.Gwk, false);
        b.i(this.Gwk, true);
        b.b(this.Gwk, true);
        b.c(this.Gwk, false);
        b.d(this.Gwk, false);
      }
      label305:
      AppMethodBeat.o(102576);
    }
    
    @SuppressLint({"SwitchIntDef"})
    public final void f(View paramView, int paramInt)
    {
      AppMethodBeat.i(102577);
      p.h(paramView, "bottomSheet");
      Log.d("MicroMsg.TransVoiceDialog", "newState: %d, panelDragOpeMode: %s, canClosePanel: %s, canHideKeyboard: %s, canCloseKeyboard: %s.", new Object[] { Integer.valueOf(paramInt), b.d(this.Gwk), Boolean.valueOf(b.j(this.Gwk)), Boolean.valueOf(b.l(this.Gwk)), Boolean.valueOf(b.k(this.Gwk)) });
      switch (paramInt)
      {
      }
      while ((1 != paramInt) && (3 != paramInt)) {
        if (!b.j(this.Gwk))
        {
          paramView = this.Gwk.getWindow();
          if (paramView != null) {
            paramView.setDimAmount(0.5F);
          }
          paramView = b.c(this.Gwk);
          if (paramView != null)
          {
            paramView.cU();
            AppMethodBeat.o(102577);
            return;
            b.f(this.Gwk, false);
            b.h(this.Gwk, false);
            b.g(this.Gwk, false);
            continue;
            if ((b.c.Gwh == b.d(this.Gwk)) && (b.j(this.Gwk))) {
              b.b(this.Gwk, 6);
            }
            if ((b.c.Gwi == b.d(this.Gwk)) && (b.l(this.Gwk))) {
              if (b.k(this.Gwk))
              {
                b.a(this.Gwk, b.c.Gwh);
                b.c(this.Gwk, true);
                b.b(this.Gwk, false);
                paramView = b.g(this.Gwk);
                if (paramView != null) {
                  paramView.setVisibility(8);
                }
                paramView = b.e(this.Gwk);
                if (paramView != null) {
                  paramView.setCursorVisible(false);
                }
                b.e(this.Gwk, false);
                paramView = b.m(this.Gwk);
                if (paramView != null) {
                  paramView.postDelayed((Runnable)new a(this), 200L);
                }
              }
              else
              {
                b.i(this.Gwk, true);
                b.b(this.Gwk, true);
                b.c(this.Gwk, false);
                b.d(this.Gwk, false);
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
          b.b(this.Gwk, 6);
        }
      }
      AppMethodBeat.o(102577);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.o paramo) {}
      
      public final void run()
      {
        AppMethodBeat.i(102575);
        TransVoicePanelLayout localTransVoicePanelLayout = b.m(this.Gwm.Gwk);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$ExternalTouchHelper;", "downY", "", "getDownY", "()F", "setDownY", "(F)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onNeedJudge", "plugin-transvoice_release"})
  public static final class p
    implements MMBottomSheetBehavior.b
  {
    private float dep;
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      Boolean localBoolean = null;
      AppMethodBeat.i(102578);
      p.h(paramMotionEvent, "event");
      p.h(paramMotionEvent, "event");
      Object localObject = b.n(this.Gwk);
      int i;
      if (localObject != null)
      {
        MMEditText localMMEditText = b.e(this.Gwk);
        if (localMMEditText == null) {
          p.hyc();
        }
        if (true == ((CoordinatorLayout)localObject).d((View)localMMEditText, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          i = 1;
          if (i != 0)
          {
            localObject = b.e(this.Gwk);
            if (localObject == null) {
              break label268;
            }
            localObject = Boolean.valueOf(((MMEditText)localObject).canScrollVertically(-1));
            label106:
            localMMEditText = b.e(this.Gwk);
            if (localMMEditText != null) {
              localBoolean = Boolean.valueOf(localMMEditText.canScrollVertically(1));
            }
            Log.d("MicroMsg.TransVoiceDialog", "can scroll up, %s.", new Object[] { localObject });
            Log.d("MicroMsg.TransVoiceDialog", "can scroll down, %s.", new Object[] { localBoolean });
            Log.d("MicroMsg.TransVoiceDialog", "action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
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
          this.dep = paramMotionEvent.getY();
        }
        f = paramMotionEvent.getY() - this.dep;
        Log.d("MicroMsg.TransVoiceDialog", "yOffset: %f.", new Object[] { Float.valueOf(f) });
        if (f > 0.0F)
        {
          bool = p.j(Boolean.TRUE, localObject);
          AppMethodBeat.o(102578);
          return bool;
        }
      } while (f >= 0.0F);
      boolean bool = p.j(Boolean.TRUE, localBoolean);
      AppMethodBeat.o(102578);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102579);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      b.b(this.Gwk, 6);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102579);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102580);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      b.a(this.Gwk, System.currentTimeMillis());
      paramView = b.B(this.Gwk);
      if (paramView != null) {
        paramView.jvS = b.C(this.Gwk);
      }
      paramView = b.B(this.Gwk);
      if (paramView != null) {
        paramView.fAw();
      }
      paramView = b.B(this.Gwk);
      if (paramView != null) {
        paramView.show();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102580);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102581);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = b.b(this.Gwk);
      switch (c.haE[paramView.ordinal()])
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(102581);
        return;
        b.i(this.Gwk, false);
        continue;
        b.a(this.Gwk, b.b.Gwd);
        b.b(this.Gwk, false);
        b.c(this.Gwk, true);
        paramView = b.g(this.Gwk);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = b.e(this.Gwk);
        if (paramView != null) {
          paramView.setCursorVisible(false);
        }
        b.e(this.Gwk, false);
        continue;
        b.a(this.Gwk, b.b.Gwd);
        b.b(this.Gwk, 6);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102582);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (b.a(this.Gwk))
      {
        b.a(this.Gwk, b.b.Gwe);
        b.i(this.Gwk, false);
        b.d(this.Gwk, true);
        paramView = b.f(this.Gwk);
        if (paramView != null) {
          paramView.setImageResource(2131231777);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(102582);
        return;
        b.a(this.Gwk, b.b.Gwf);
        b.i(this.Gwk, true);
        b.d(this.Gwk, false);
        paramView = b.f(this.Gwk);
        if (paramView != null) {
          paramView.setImageResource(2131231772);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class u
    implements MTimerHandler.CallBack
  {
    u(b paramb) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(102583);
      int i = b.D(this.Gwk);
      b localb = this.Gwk;
      b.c(localb, b.D(localb) + 1);
      switch (i % 3)
      {
      }
      for (;;)
      {
        b.E(this.Gwk);
        AppMethodBeat.o(102583);
        return true;
        b.a(this.Gwk, "·");
        continue;
        b.a(this.Gwk, "··");
        continue;
        b.a(this.Gwk, "···");
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-transvoice_release"})
  public static final class v
    implements ChatFooterPanel.a
  {
    public final void aHC()
    {
      AppMethodBeat.i(102585);
      Object localObject = b.e(this.Gwk);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = b.e(this.Gwk);
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
    
    public final void aHD()
    {
      AppMethodBeat.i(102586);
      b.o(this.Gwk);
      AppMethodBeat.o(102586);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(102584);
      MMEditText localMMEditText = b.e(this.Gwk);
      if (localMMEditText != null)
      {
        localMMEditText.bol(paramString);
        AppMethodBeat.o(102584);
        return;
      }
      AppMethodBeat.o(102584);
    }
    
    public final void eP(boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
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
        localInputMethodManager.showSoftInput((View)b.e(this.Gwk), 0);
        AppMethodBeat.o(102587);
        return;
      }
      AppMethodBeat.o(102587);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class x
    implements g.b
  {
    public final void b(String[] paramArrayOfString, List<String> paramList)
    {
      AppMethodBeat.i(102588);
      Log.i("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.Gwk, paramList);
      paramList = b.v(this.Gwk);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.Gwk);
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
            this.Gwk.aTO(paramArrayOfString[0]);
            Log.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.Gwk.GvZ });
            b.p(this.Gwk).GtV = this.Gwk.GvZ.length();
            if (b.s(this.Gwk)) {
              break;
            }
            b.j(this.Gwk, true);
            paramArrayOfString = b.e(this.Gwk);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.Gwk);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.Gwk);
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
    
    public final void biv()
    {
      AppMethodBeat.i(102590);
      Log.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102590);
    }
    
    public final void biz()
    {
      AppMethodBeat.i(102591);
      Log.i("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.Gwk, false);
      b.p(this.Gwk).GtY = 1;
      b.p(this.Gwk).GtU = System.currentTimeMillis();
      Object localObject = b.v(this.Gwk);
      if (localObject != null) {
        ((MMHandler)localObject).removeMessages(5000);
      }
      localObject = b.w(this.Gwk);
      if (localObject != null) {
        ((MTimerHandler)localObject).stopTimer();
      }
      b.J(this.Gwk);
      localObject = b.u(this.Gwk);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        AppMethodBeat.o(102591);
        return;
      }
      AppMethodBeat.o(102591);
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(102589);
      Log.i("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
      b.p(this.Gwk).GtY = 0;
      b.p(this.Gwk).GtU = System.currentTimeMillis();
      AppMethodBeat.o(102589);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$2", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class y
    implements g.b
  {
    public final void b(String[] paramArrayOfString, List<String> paramList)
    {
      AppMethodBeat.i(102592);
      Log.d("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.Gwk, paramList);
      paramList = b.v(this.Gwk);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.Gwk);
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
            this.Gwk.aTO(paramArrayOfString[0]);
            Log.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.Gwk.GvZ });
            b.p(this.Gwk).GtV = this.Gwk.GvZ.length();
            if (b.s(this.Gwk)) {
              break;
            }
            b.j(this.Gwk, true);
            paramArrayOfString = b.e(this.Gwk);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.Gwk);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.Gwk);
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
    
    public final void biv()
    {
      AppMethodBeat.i(102594);
      Log.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102594);
    }
    
    public final void biz()
    {
      AppMethodBeat.i(102595);
      Log.d("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.Gwk, false);
      b.p(this.Gwk).GtY = 1;
      b.p(this.Gwk).GtU = System.currentTimeMillis();
      Object localObject = b.v(this.Gwk);
      if (localObject != null) {
        ((MMHandler)localObject).removeMessages(5000);
      }
      localObject = b.w(this.Gwk);
      if (localObject != null) {
        ((MTimerHandler)localObject).stopTimer();
      }
      b.J(this.Gwk);
      localObject = b.u(this.Gwk);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        AppMethodBeat.o(102595);
        return;
      }
      AppMethodBeat.o(102595);
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(102593);
      Log.d("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
      b.p(this.Gwk).GtY = 0;
      b.p(this.Gwk).GtU = System.currentTimeMillis();
      AppMethodBeat.o(102593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b
 * JD-Core Version:    0.7.0.1
 */