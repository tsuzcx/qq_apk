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
import com.tencent.mm.ck.a.a;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.plugin.transvoice.a.c;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "bottomSheetCoordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "btnLayout", "canCloseKeyboard", "", "canClosePanel", "canHideKeyboard", "closeInputMethod", "Landroid/widget/ImageView;", "closePanel", "container", "Lcom/tencent/mm/modelvoiceaddr/ShortSentenceContainer;", "curTxt", "", "getCurTxt", "()Ljava/lang/String;", "setCurTxt", "(Ljava/lang/String;)V", "dotCounter", "", "dotStr", "emojiRoot", "Landroid/widget/FrameLayout;", "hasClick", "inputMethodLayout", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoicePanelLayout;", "inputMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "isEdited", "isKeyboardShown", "keyboardHeight", "langType", "languageChoiceDialog", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "mNewVoiceInputReport", "Lcom/tencent/mm/modelvoiceaddr/voicereport/NewVoiceInputReportManager;", "mVoiceIdSet", "", "needSendTxtMsg", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "overTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "panelDragOpeMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "reporter", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "sendTxtMsg", "Landroid/widget/Button;", "sendVoiceMsg", "showImeRunnable", "Ljava/lang/Runnable;", "smileyItem", "smileyOpener", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "talker", "getTalker", "setTalker", "targetView", "tmpClickChangeLangTypeTime", "", "transCancelable", "transMore", "transPanelAction", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "getTransPanelAction", "()Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "setTransPanelAction", "(Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;)V", "transSP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "txtEditView", "Lcom/tencent/mm/ui/widget/MMEditText;", "txtMsg4Send", "updateDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceAddr", "Lcom/tencent/mm/plugin/transvoice/model/SceneVoiceInputAddr2;", "value", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "voiceLen", "getVoiceLen", "()J", "setVoiceLen", "(J)V", "voiceMsgSend", "cgiReport", "", "msg", "closeInputMethodBtnVisibility", "visible", "closeTransPanel", "exitType", "delPunctuation", "getContentTxt", "init", "initSmileyPanel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshBottomPanelHeight", "resetTransPanel", "saveTransLangTypeByTalker", "type", "setBottomBtnVisibility", "setKeyboardVisibility", "setSmileyItemVisibility", "setSmileyPanelVisibility", "show", "startTrans", "updateCurTxt", "updateTransLangTypeByTalker", "Companion", "InputMode", "PanelDragOpeMode", "TransPanelAction", "plugin-transvoice_release"})
public final class b
  extends e
{
  public static int Aml;
  public static final b.a Amm;
  private ImageView Akp;
  private MMBottomSheetBehavior<View> Aks;
  private boolean Akt;
  private a.b Aku;
  final c AlD;
  long AlE;
  boolean AlF;
  private TransVoicePanelLayout AlG;
  private MMEditText AlH;
  private ImageView AlI;
  private ImageView AlJ;
  private View AlK;
  private View AlL;
  private ImageView AlM;
  private Button AlN;
  private Button AlO;
  com.tencent.mm.plugin.transvoice.a.b AlP;
  private b AlQ;
  public long AlR;
  String AlS;
  private boolean AlT;
  private String AlU;
  private int AlV;
  au AlW;
  private boolean AlX;
  private a AlY;
  ao AlZ;
  private SharedPreferences Ama;
  private CoordinatorLayout Amb;
  private b.c Amc;
  private boolean Amd;
  private boolean Ame;
  private boolean Amf;
  private String Amg;
  private final com.tencent.mm.modelvoiceaddr.b.b Amh;
  private List<String> Ami;
  String Amj;
  public d Amk;
  private ChatFooterPanel fWT;
  h iek;
  int iep;
  private int ngo;
  private final Runnable ptC;
  boolean qNK;
  public String talker;
  private View targetView;
  private FrameLayout zIc;
  private boolean zIj;
  
  static
  {
    AppMethodBeat.i(102605);
    Amm = new b.a((byte)0);
    Aml = -1;
    AppMethodBeat.o(102605);
  }
  
  public b(final Context paramContext)
  {
    super(paramContext, 2131821488);
    AppMethodBeat.i(102604);
    c.a locala = c.Akm;
    this.AlD = c.efd();
    this.iep = g.ieO;
    this.AlQ = b.Amn;
    this.AlU = "";
    this.Ama = paramContext.getSharedPreferences("voice2txt_sp", 0);
    this.Amc = b.c.Amr;
    this.Amg = "";
    gt();
    this.Amh = new com.tencent.mm.modelvoiceaddr.b.b();
    this.ptC = ((Runnable)new w(this, paramContext));
    this.Amj = "";
    AppMethodBeat.o(102604);
  }
  
  private final void RO(int paramInt)
  {
    AppMethodBeat.i(102600);
    if (isShowing())
    {
      this.AlD.setExitType(paramInt);
      efq();
      dismiss();
      d locald = this.Amk;
      if (locald != null) {
        locald.efr();
      }
      if (!this.AlT)
      {
        locald = this.Amk;
        if (locald != null) {
          locald.ayc(this.AlS);
        }
      }
      this.AlT = false;
    }
    AppMethodBeat.o(102600);
  }
  
  private final void setKeyboardVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(102599);
    ac.d("MicroMsg.TransVoiceDialog", "setKeyboardVisibility, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      localObject = this.targetView;
      if (localObject != null) {
        ((View)localObject).removeCallbacks(this.ptC);
      }
      localObject = this.targetView;
      if (localObject != null)
      {
        ((View)localObject).post(this.ptC);
        AppMethodBeat.o(102599);
        return;
      }
      AppMethodBeat.o(102599);
      return;
    }
    Object localObject = this.targetView;
    if (localObject != null) {
      ((View)localObject).removeCallbacks(this.ptC);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localObject = this.AlH;
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
  
  private final void si(boolean paramBoolean)
  {
    AppMethodBeat.i(102598);
    if (paramBoolean)
    {
      localImageView = this.AlI;
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        AppMethodBeat.o(102598);
        return;
      }
      AppMethodBeat.o(102598);
      return;
    }
    ImageView localImageView = this.AlI;
    if (localImageView != null)
    {
      localImageView.setVisibility(0);
      AppMethodBeat.o(102598);
      return;
    }
    AppMethodBeat.o(102598);
  }
  
  public final void axZ(String paramString)
  {
    AppMethodBeat.i(185255);
    if (!bs.isNullOrNil(paramString))
    {
      this.AlS = paramString;
      a.a locala = com.tencent.mm.ck.a.Hez;
      if (paramString == null) {
        k.fOy();
      }
      k.h(paramString, "<set-?>");
      com.tencent.mm.ck.a.aPp(paramString);
    }
    AppMethodBeat.o(185255);
  }
  
  public final void aya(String paramString)
  {
    AppMethodBeat.i(102602);
    k.h(paramString, "<set-?>");
    this.Amj = paramString;
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
    localObject = this.Aks;
    if (localObject != null) {
      ((MMBottomSheetBehavior)localObject).cC();
    }
    this.AlF = false;
    this.qNK = false;
    int i = this.Ama.getInt(this.talker, 0);
    localObject = this.AlY;
    if (localObject == null) {
      k.fOy();
    }
    localObject = ((a)localObject).Akq;
    if (localObject == null) {
      k.fOy();
    }
    if (((ArrayList)localObject).contains(Integer.valueOf(i))) {
      this.iep = i;
    }
    for (;;)
    {
      this.AlD.Akb = this.iep;
      efq();
      localObject = this.AlZ;
      if (localObject != null) {
        ((ao)localObject).sendEmptyMessageDelayed(5000, 5000L);
      }
      localObject = this.AlW;
      if (localObject != null) {
        ((au)localObject).Ah(500L);
      }
      this.iek = paramh;
      this.AlP = new com.tencent.mm.plugin.transvoice.a.b(paramh, this.iep, (g.b)new x(this));
      paramh = this.AlP;
      if (paramh == null) {
        break;
      }
      paramh.start();
      AppMethodBeat.o(185256);
      return;
      localObject = this.AlY;
      if (localObject == null) {
        k.fOy();
      }
      localObject = ((a)localObject).Akq;
      if (localObject == null) {
        k.fOy();
      }
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = this.AlY;
        if (localObject == null) {
          k.fOy();
        }
        localObject = ((a)localObject).Akq;
        if (localObject == null) {
          k.fOy();
        }
        localObject = ((ArrayList)localObject).get(0);
        k.g(localObject, "languageChoiceDialog!!.langTypeArr!![0]");
        this.iep = ((Number)localObject).intValue();
      }
      else
      {
        localObject = ab.iC(getContext());
        if ((k.g(localObject, "zh_CN")) || (k.g(localObject, "zh_HK")) || (k.g(localObject, "zh_TW"))) {
          this.iep = g.ieO;
        } else if (k.g(localObject, "en")) {
          this.iep = g.ieQ;
        }
      }
    }
    AppMethodBeat.o(185256);
  }
  
  final void efq()
  {
    AppMethodBeat.i(102601);
    this.Amj = "";
    this.AlV = 0;
    this.AlU = "";
    this.AlX = false;
    Object localObject = this.AlH;
    if (localObject != null) {
      ((MMEditText)localObject).setText((CharSequence)"");
    }
    localObject = this.AlH;
    if (localObject != null) {
      ((MMEditText)localObject).setCursorVisible(false);
    }
    localObject = this.AlH;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusable(false);
    }
    localObject = this.AlH;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusableInTouchMode(false);
    }
    localObject = this.AlK;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.AlL;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    setKeyboardVisibility(false);
    localObject = this.fWT;
    if (localObject != null) {
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    si(false);
    localObject = this.AlZ;
    if (localObject != null) {
      ((ao)localObject).removeMessages(5000);
    }
    this.Amc = b.c.Amr;
    this.Akt = false;
    this.Amd = false;
    this.Ame = false;
    AppMethodBeat.o(102601);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(102597);
    RO(6);
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
      this.AlG = paramBundle;
      paramBundle = this.AlG;
      if (paramBundle != null) {
        paramBundle.setOnInputPanelChange((TransVoicePanelLayout.a)new h(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1056;
      }
      paramBundle = (CoordinatorLayout)paramBundle.findViewById(2131296673);
      label160:
      this.Amb = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1061;
      }
      paramBundle = paramBundle.findViewById(2131303747);
      label182:
      this.Aks = MMBottomSheetBehavior.w(paramBundle);
      paramBundle = this.Aks;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new o(this));
      }
      paramBundle = this.Aks;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.b)new p(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1066;
      }
      paramBundle = (MMEditText)paramBundle.findViewById(2131306060);
      label258:
      this.AlH = paramBundle;
      paramBundle = this.AlH;
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
      this.Akp = paramBundle;
      paramBundle = this.Akp;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new q(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1076;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131306061);
      label403:
      this.AlI = paramBundle;
      paramBundle = this.AlI;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new r(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1081;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131298371);
      label452:
      this.AlJ = paramBundle;
      paramBundle = this.AlJ;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new s(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1086;
      }
      paramBundle = paramBundle.findViewById(2131303745);
      label498:
      this.AlK = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1091;
      }
      paramBundle = paramBundle.findViewById(2131304864);
      label520:
      this.AlL = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1096;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131304869);
      label545:
      this.AlM = paramBundle;
      paramBundle = this.AlM;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new t(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1101;
      }
      paramBundle = (FrameLayout)paramBundle.findViewById(2131299431);
      label594:
      this.zIc = paramBundle;
      this.fWT = ((ChatFooterPanel)aa.bh(getContext()));
      this.ngo = y.iy(getContext());
      paramBundle = new FrameLayout.LayoutParams(-1, this.ngo);
      localObject = this.zIc;
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.fWT, (ViewGroup.LayoutParams)paramBundle);
      }
      paramBundle = this.fWT;
      if (paramBundle != null) {
        paramBundle.setPortHeightPx(this.ngo);
      }
      paramBundle = this.fWT;
      if (paramBundle != null) {
        paramBundle.setEntranceScene(ChatFooterPanel.Dnj);
      }
      paramBundle = this.fWT;
      if (paramBundle != null) {
        paramBundle.eMH();
      }
      paramBundle = this.fWT;
      if (paramBundle != null) {
        paramBundle.onResume();
      }
      paramBundle = this.fWT;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.fWT;
      if (paramBundle != null) {
        paramBundle.setShowSend(true);
      }
      paramBundle = this.fWT;
      if (paramBundle != null) {
        paramBundle.setOnTextOperationListener((ChatFooterPanel.a)new v(this));
      }
      this.AlW = new au((au.a)new u(this), true);
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1106;
      }
      paramBundle = (Button)paramBundle.findViewById(2131297597);
      label815:
      this.AlN = paramBundle;
      paramBundle = this.AlN;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new i(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1111;
      }
      paramBundle = (Button)paramBundle.findViewById(2131297598);
      label864:
      this.AlO = paramBundle;
      paramBundle = this.AlO;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new j(this));
      }
      paramBundle = this.AlN;
      if (paramBundle == null) {
        break label1116;
      }
      paramBundle = paramBundle.getPaint();
      label907:
      aj.a((Paint)paramBundle, 0.8F);
      paramBundle = this.AlO;
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
      aj.a((Paint)paramBundle, 0.8F);
      this.Aku = ((a.b)new k(this));
      paramBundle = getContext();
      k.g(paramBundle, "context");
      this.AlY = new a(paramBundle);
      paramBundle = this.AlY;
      if (paramBundle != null)
      {
        paramBundle.setOnDismissListener((DialogInterface.OnDismissListener)b.l.Amv);
        paramBundle.Aku = this.Aku;
      }
      this.AlZ = new ao((ao.a)new m(this));
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
    a.a locala = com.tencent.mm.ck.a.Hez;
    com.tencent.mm.ck.a.wi(true);
    super.show();
    AppMethodBeat.o(102603);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "", "(Ljava/lang/String;I)V", "INPUT_NONE", "INPUT_EMOJI", "INPUT_KEYBOARD", "plugin-transvoice_release"})
  static enum b
  {
    static
    {
      AppMethodBeat.i(102558);
      b localb1 = new b("INPUT_NONE", 0);
      Amn = localb1;
      b localb2 = new b("INPUT_EMOJI", 1);
      Amo = localb2;
      b localb3 = new b("INPUT_KEYBOARD", 2);
      Amp = localb3;
      Amq = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(102558);
    }
    
    private b() {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "", "onTransPanelClose", "", "onTxtMsgSend", "txt", "", "onVoiceMsgDelete", "fileName", "onVoiceMsgSend", "", "fileLength", "", "(Ljava/lang/String;Ljava/lang/Long;)Z", "plugin-transvoice_release"})
  public static abstract interface d
  {
    public abstract void ayb(String paramString);
    
    public abstract void ayc(String paramString);
    
    public abstract boolean b(String paramString, Long paramLong);
    
    public abstract void efr();
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$1"})
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
        b.o(this.Amu);
        AppMethodBeat.o(102565);
        return true;
      }
      AppMethodBeat.o(102565);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$2"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102566);
      b.p(this.Amu).Akk = 1;
      b.r(this.Amu);
      if (b.s(this.Amu))
      {
        b.j(this.Amu, false);
        b.p(this.Amu).Aki = 0;
        b.p(this.Amu).Ake = System.currentTimeMillis();
        paramView = b.t(this.Amu);
        if (paramView != null) {
          paramView.cancel(true);
        }
        paramView = b.u(this.Amu);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = b.v(this.Amu);
        if (paramView != null) {
          paramView.removeMessages(5000);
        }
        paramView = b.w(this.Amu);
        if (paramView != null) {
          paramView.stopTimer();
        }
        paramView = b.e(this.Amu);
        if (paramView != null)
        {
          paramView.setText((CharSequence)this.Amu.Amj);
          AppMethodBeat.o(102566);
          return;
        }
      }
      AppMethodBeat.o(102566);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-transvoice_release"})
  public static final class g
    implements TextWatcher
  {
    g(b paramb) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int i = 0;
      AppMethodBeat.i(102567);
      if ((!b.x(this.Amu)) && (b.q(this.Amu)))
      {
        b.y(this.Amu);
        b.p(this.Amu).Akj = 1;
      }
      Object localObject = b.z(this.Amu);
      if (localObject != null) {
        if (bs.aj((CharSequence)paramEditable)) {
          break label115;
        }
      }
      label115:
      for (boolean bool = true;; bool = false)
      {
        ((Button)localObject).setEnabled(bool);
        localObject = b.A(this.Amu);
        if (localObject == null) {
          break;
        }
        if (bs.aj((CharSequence)paramEditable)) {
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "isKeyboardShow", "", "keyboardHeight", "", "onInputPanelChange"})
  static final class h
    implements TransVoicePanelLayout.a
  {
    h(b paramb) {}
    
    public final void g(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(102568);
      b.a(this.Amu, paramBoolean);
      ac.d("MicroMsg.TransVoiceDialog", "isKeyboardShow %s.", new Object[] { Boolean.valueOf(paramBoolean) });
      Object localObject;
      if (paramBoolean)
      {
        b.a(this.Amu, b.b.Amp);
        localObject = b.c(this.Amu);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState())) {
          b.a(this.Amu, b.c.Ams);
        }
        localObject = b.e(this.Amu);
        if (localObject != null) {
          ((MMEditText)localObject).setCursorVisible(true);
        }
        b.b(this.Amu, true);
        b.c(this.Amu, false);
        b.d(this.Amu, false);
        localObject = b.f(this.Amu);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(2131231701);
        }
        b.e(this.Amu, true);
      }
      for (;;)
      {
        if ((b.h(this.Amu) != paramInt) && (paramInt != 0))
        {
          b.a(this.Amu, paramInt);
          i.A(this.Amu.getContext(), paramInt);
          b.i(this.Amu);
        }
        AppMethodBeat.o(102568);
        return;
        localObject = b.c(this.Amu);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState()) && (b.b.Amo != b.b(this.Amu))) {
          b.a(this.Amu, b.c.Amr);
        }
        localObject = b.b(this.Amu);
        switch (c.cfA[localObject.ordinal()])
        {
        case 1: 
        default: 
          break;
        case 2: 
          b.a(this.Amu, b.b.Amn);
          if (b.c.Ams != b.d(this.Amu))
          {
            b.b(this.Amu, false);
            b.c(this.Amu, true);
            localObject = b.g(this.Amu);
            if (localObject != null) {
              ((ChatFooterPanel)localObject).setVisibility(8);
            }
            localObject = b.e(this.Amu);
            if (localObject != null) {
              ((MMEditText)localObject).setCursorVisible(false);
            }
            b.e(this.Amu, false);
          }
          break;
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102569);
      ac.i("MicroMsg.TransVoiceDialog", "sendVoiceMsg onClick.");
      paramView = this.Amu.Amk;
      if ((paramView != null) && (true == paramView.b(this.Amu.AlS, Long.valueOf(this.Amu.AlR)))) {
        b.F(this.Amu);
      }
      b.b(this.Amu, 7);
      AppMethodBeat.o(102569);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102570);
      b.o(this.Amu);
      AppMethodBeat.o(102570);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$12", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static final class k
    implements a.b
  {
    public final void RI(int paramInt)
    {
      AppMethodBeat.i(102571);
      Object localObject1 = b.B(this.Amu);
      if (localObject1 != null) {
        ((a)localObject1).dismiss();
      }
      b.d(this.Amu, paramInt);
      if (paramInt == b.C(this.Amu))
      {
        AppMethodBeat.o(102571);
        return;
      }
      if (ax.isConnected(this.Amu.getContext()))
      {
        localObject1 = this.Amu;
        ((b)localObject1).AlF = false;
        ((b)localObject1).qNK = false;
        ((b)localObject1).AlD.Aka = ((b)localObject1).AlE;
        ((b)localObject1).AlD.Akd = 0;
        ((b)localObject1).AlD.Ake = 0L;
        ((b)localObject1).AlD.Akf = 0;
        ((b)localObject1).AlD.Aki = 0;
        ((b)localObject1).AlD.Akj = 0;
        ((b)localObject1).AlD.Akk = 0;
        ((b)localObject1).efq();
        localObject2 = ((b)localObject1).AlZ;
        if (localObject2 != null) {
          ((ao)localObject2).sendEmptyMessageDelayed(5000, 5000L);
        }
        localObject2 = ((b)localObject1).AlW;
        if (localObject2 != null) {
          ((au)localObject2).Ah(500L);
        }
        ((b)localObject1).iep = paramInt;
        long l2 = System.nanoTime() & 0xFFFFFFFF;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = Math.abs(l2);
        }
        localObject2 = new h(String.valueOf(l1));
        h localh = ((b)localObject1).iek;
        if (localh != null) {
          localh.a((h)localObject2);
        }
        ((b)localObject1).AlP = new com.tencent.mm.plugin.transvoice.a.b((h)localObject2, paramInt, (g.b)new b.y((b)localObject1));
        localObject1 = ((b)localObject1).AlP;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.transvoice.a.b)localObject1).start();
          AppMethodBeat.o(102571);
          return;
        }
        AppMethodBeat.o(102571);
        return;
      }
      localObject1 = new d.a(this.Amu.getContext());
      Object localObject2 = this.Amu.getContext();
      k.g(localObject2, "context");
      ((d.a)localObject1).aRI(((Context)localObject2).getResources().getString(2131755828));
      localObject2 = this.Amu.getContext();
      k.g(localObject2, "context");
      ((d.a)localObject1).aRO(((Context)localObject2).getResources().getString(2131761549));
      localObject2 = this.Amu.getContext();
      k.g(localObject2, "context");
      ((d.a)localObject1).acO(((Context)localObject2).getResources().getColor(2131099770));
      ((d.a)localObject1).fvp().show();
      AppMethodBeat.o(102571);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class m
    implements ao.a
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
        b.p(this.Amu).Akd = 1;
        b.p(this.Amu).Ake = System.currentTimeMillis();
        b.p(this.Amu).Aki = 0;
        paramMessage = b.w(this.Amu);
        if (paramMessage != null) {
          paramMessage.stopTimer();
        }
        paramMessage = b.t(this.Amu);
        if (paramMessage != null) {
          paramMessage.cancel(false);
        }
        if (!bs.isNullOrNil(this.Amu.Amj))
        {
          paramMessage = b.e(this.Amu);
          if (paramMessage != null) {
            paramMessage.setFocusable(true);
          }
          paramMessage = b.e(this.Amu);
          if (paramMessage != null) {
            paramMessage.setFocusableInTouchMode(true);
          }
        }
        paramMessage = b.e(this.Amu);
        if (paramMessage != null) {
          paramMessage.setText((CharSequence)this.Amu.Amj);
        }
        paramMessage = b.u(this.Amu);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class n
    implements DialogInterface.OnDismissListener
  {
    n(b paramb) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(102574);
      ac.d("MicroMsg.TransVoiceDialog", "onDismiss.");
      if (b.G(this.Amu))
      {
        b.H(this.Amu);
        if (!bs.isNullOrNil(b.I(this.Amu)))
        {
          paramDialogInterface = this.Amu.Amk;
          if (paramDialogInterface != null) {
            paramDialogInterface.ayb(b.I(this.Amu));
          }
          b.b(this.Amu, b.I(this.Amu));
        }
      }
      AppMethodBeat.o(102574);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$2", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class o
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102576);
      k.h(paramView, "bottomSheet");
      ac.d("MicroMsg.TransVoiceDialog", "slideOffset: %f, panelDragOpeMode: %s.", new Object[] { Float.valueOf(paramFloat), b.d(this.Amu) });
      paramView = b.c(this.Amu);
      if (paramView != null)
      {
        if (paramView.getState() != 1) {
          break label305;
        }
        if (b.c.Amr == b.d(this.Amu))
        {
          paramView = this.Amu;
          if (0.7F < paramFloat) {
            break label239;
          }
          bool = true;
          b.f(paramView, bool);
          paramView = this.Amu.getWindow();
          if (paramView != null) {
            paramView.setDimAmount((float)(0.5D - (1.0F - paramFloat) / 2.0D));
          }
        }
        if (b.c.Ams != b.d(this.Amu)) {
          break label305;
        }
        paramView = this.Amu;
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
        if (b.l(this.Amu)) {
          break label305;
        }
        b.h(this.Amu, true);
        b.i(this.Amu, false);
        b.b(this.Amu, false);
        b.c(this.Amu, false);
        b.d(this.Amu, false);
        paramView = b.f(this.Amu);
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
      if (b.l(this.Amu))
      {
        b.h(this.Amu, false);
        b.i(this.Amu, true);
        b.b(this.Amu, true);
        b.c(this.Amu, false);
        b.d(this.Amu, false);
      }
      label305:
      AppMethodBeat.o(102576);
    }
    
    @SuppressLint({"SwitchIntDef"})
    public final void k(View paramView, int paramInt)
    {
      AppMethodBeat.i(102577);
      k.h(paramView, "bottomSheet");
      ac.d("MicroMsg.TransVoiceDialog", "newState: %d, panelDragOpeMode: %s, canClosePanel: %s, canHideKeyboard: %s, canCloseKeyboard: %s.", new Object[] { Integer.valueOf(paramInt), b.d(this.Amu), Boolean.valueOf(b.j(this.Amu)), Boolean.valueOf(b.l(this.Amu)), Boolean.valueOf(b.k(this.Amu)) });
      switch (paramInt)
      {
      }
      while ((1 != paramInt) && (3 != paramInt)) {
        if (!b.j(this.Amu))
        {
          paramView = this.Amu.getWindow();
          if (paramView != null) {
            paramView.setDimAmount(0.5F);
          }
          paramView = b.c(this.Amu);
          if (paramView != null)
          {
            paramView.cC();
            AppMethodBeat.o(102577);
            return;
            b.f(this.Amu, false);
            b.h(this.Amu, false);
            b.g(this.Amu, false);
            continue;
            if ((b.c.Amr == b.d(this.Amu)) && (b.j(this.Amu))) {
              b.b(this.Amu, 6);
            }
            if ((b.c.Ams == b.d(this.Amu)) && (b.l(this.Amu))) {
              if (b.k(this.Amu))
              {
                b.a(this.Amu, b.c.Amr);
                b.c(this.Amu, true);
                b.b(this.Amu, false);
                paramView = b.g(this.Amu);
                if (paramView != null) {
                  paramView.setVisibility(8);
                }
                paramView = b.e(this.Amu);
                if (paramView != null) {
                  paramView.setCursorVisible(false);
                }
                b.e(this.Amu, false);
                paramView = b.m(this.Amu);
                if (paramView != null) {
                  paramView.postDelayed((Runnable)new a(this), 200L);
                }
              }
              else
              {
                b.i(this.Amu, true);
                b.b(this.Amu, true);
                b.c(this.Amu, false);
                b.d(this.Amu, false);
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
          b.b(this.Amu, 6);
        }
      }
      AppMethodBeat.o(102577);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.o paramo) {}
      
      public final void run()
      {
        AppMethodBeat.i(102575);
        TransVoicePanelLayout localTransVoicePanelLayout = b.m(this.Amw.Amu);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$ExternalTouchHelper;", "downY", "", "getDownY", "()F", "setDownY", "(F)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onNeedJudge", "plugin-transvoice_release"})
  public static final class p
    implements MMBottomSheetBehavior.b
  {
    private float cCi;
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      Boolean localBoolean = null;
      AppMethodBeat.i(102578);
      k.h(paramMotionEvent, "event");
      k.h(paramMotionEvent, "event");
      Object localObject = b.n(this.Amu);
      int i;
      if (localObject != null)
      {
        MMEditText localMMEditText = b.e(this.Amu);
        if (localMMEditText == null) {
          k.fOy();
        }
        if (true == ((CoordinatorLayout)localObject).d((View)localMMEditText, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          i = 1;
          if (i != 0)
          {
            localObject = b.e(this.Amu);
            if (localObject == null) {
              break label268;
            }
            localObject = Boolean.valueOf(((MMEditText)localObject).canScrollVertically(-1));
            label106:
            localMMEditText = b.e(this.Amu);
            if (localMMEditText != null) {
              localBoolean = Boolean.valueOf(localMMEditText.canScrollVertically(1));
            }
            ac.d("MicroMsg.TransVoiceDialog", "can scroll up, %s.", new Object[] { localObject });
            ac.d("MicroMsg.TransVoiceDialog", "can scroll down, %s.", new Object[] { localBoolean });
            ac.d("MicroMsg.TransVoiceDialog", "action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
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
          this.cCi = paramMotionEvent.getY();
        }
        f = paramMotionEvent.getY() - this.cCi;
        ac.d("MicroMsg.TransVoiceDialog", "yOffset: %f.", new Object[] { Float.valueOf(f) });
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102579);
      b.b(this.Amu, 6);
      AppMethodBeat.o(102579);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102580);
      b.a(this.Amu, System.currentTimeMillis());
      paramView = b.B(this.Amu);
      if (paramView != null) {
        paramView.iep = b.C(this.Amu);
      }
      paramView = b.B(this.Amu);
      if (paramView != null) {
        paramView.eff();
      }
      paramView = b.B(this.Amu);
      if (paramView != null)
      {
        paramView.show();
        AppMethodBeat.o(102580);
        return;
      }
      AppMethodBeat.o(102580);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102581);
      paramView = b.b(this.Amu);
      switch (c.fTL[paramView.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(102581);
        return;
        b.i(this.Amu, false);
        AppMethodBeat.o(102581);
        return;
        b.a(this.Amu, b.b.Amn);
        b.b(this.Amu, false);
        b.c(this.Amu, true);
        paramView = b.g(this.Amu);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = b.e(this.Amu);
        if (paramView != null) {
          paramView.setCursorVisible(false);
        }
        b.e(this.Amu, false);
        AppMethodBeat.o(102581);
        return;
        b.a(this.Amu, b.b.Amn);
        b.b(this.Amu, 6);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102582);
      if (b.a(this.Amu))
      {
        b.a(this.Amu, b.b.Amo);
        b.i(this.Amu, false);
        b.d(this.Amu, true);
        paramView = b.f(this.Amu);
        if (paramView != null)
        {
          paramView.setImageResource(2131231706);
          AppMethodBeat.o(102582);
          return;
        }
        AppMethodBeat.o(102582);
        return;
      }
      b.a(this.Amu, b.b.Amp);
      b.i(this.Amu, true);
      b.d(this.Amu, false);
      paramView = b.f(this.Amu);
      if (paramView != null)
      {
        paramView.setImageResource(2131231701);
        AppMethodBeat.o(102582);
        return;
      }
      AppMethodBeat.o(102582);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class u
    implements au.a
  {
    u(b paramb) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(102583);
      int i = b.D(this.Amu);
      b localb = this.Amu;
      b.c(localb, b.D(localb) + 1);
      switch (i % 3)
      {
      }
      for (;;)
      {
        b.E(this.Amu);
        AppMethodBeat.o(102583);
        return true;
        b.a(this.Amu, "·");
        continue;
        b.a(this.Amu, "··");
        continue;
        b.a(this.Amu, "···");
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-transvoice_release"})
  public static final class v
    implements ChatFooterPanel.a
  {
    public final void amb()
    {
      AppMethodBeat.i(102585);
      Object localObject = b.e(this.Amu);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = b.e(this.Amu);
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
    
    public final void amc()
    {
      AppMethodBeat.i(102586);
      b.o(this.Amu);
      AppMethodBeat.o(102586);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(102584);
      MMEditText localMMEditText = b.e(this.Amu);
      if (localMMEditText != null)
      {
        localMMEditText.aRF(paramString);
        AppMethodBeat.o(102584);
        return;
      }
      AppMethodBeat.o(102584);
    }
    
    public final void dS(boolean paramBoolean) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
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
        localInputMethodManager.showSoftInput((View)b.e(this.Amu), 0);
        AppMethodBeat.o(102587);
        return;
      }
      AppMethodBeat.o(102587);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class x
    implements g.b
  {
    public final void aKH()
    {
      AppMethodBeat.i(102590);
      ac.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102590);
    }
    
    public final void aKL()
    {
      AppMethodBeat.i(102591);
      ac.i("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.Amu, false);
      b.p(this.Amu).Aki = 1;
      b.p(this.Amu).Ake = System.currentTimeMillis();
      Object localObject = b.v(this.Amu);
      if (localObject != null) {
        ((ao)localObject).removeMessages(5000);
      }
      localObject = b.w(this.Amu);
      if (localObject != null) {
        ((au)localObject).stopTimer();
      }
      b.J(this.Amu);
      localObject = b.u(this.Amu);
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
      ac.i("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.Amu, paramList);
      paramList = b.v(this.Amu);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.Amu);
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
            this.Amu.aya(paramArrayOfString[0]);
            ac.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.Amu.Amj });
            b.p(this.Amu).Akf = this.Amu.Amj.length();
            if (b.s(this.Amu)) {
              break;
            }
            b.j(this.Amu, true);
            paramArrayOfString = b.e(this.Amu);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.Amu);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.Amu);
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
      ac.i("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
      b.p(this.Amu).Aki = 0;
      b.p(this.Amu).Ake = System.currentTimeMillis();
      AppMethodBeat.o(102589);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$2", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class y
    implements g.b
  {
    public final void aKH()
    {
      AppMethodBeat.i(102594);
      ac.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102594);
    }
    
    public final void aKL()
    {
      AppMethodBeat.i(102595);
      ac.d("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.Amu, false);
      b.p(this.Amu).Aki = 1;
      b.p(this.Amu).Ake = System.currentTimeMillis();
      Object localObject = b.v(this.Amu);
      if (localObject != null) {
        ((ao)localObject).removeMessages(5000);
      }
      localObject = b.w(this.Amu);
      if (localObject != null) {
        ((au)localObject).stopTimer();
      }
      b.J(this.Amu);
      localObject = b.u(this.Amu);
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
      ac.d("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.Amu, paramList);
      paramList = b.v(this.Amu);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.Amu);
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
            this.Amu.aya(paramArrayOfString[0]);
            ac.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.Amu.Amj });
            b.p(this.Amu).Akf = this.Amu.Amj.length();
            if (b.s(this.Amu)) {
              break;
            }
            b.j(this.Amu, true);
            paramArrayOfString = b.e(this.Amu);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.Amu);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.Amu);
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
      ac.d("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
      b.p(this.Amu).Aki = 0;
      b.p(this.Amu).Ake = System.currentTimeMillis();
      AppMethodBeat.o(102593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b
 * JD-Core Version:    0.7.0.1
 */