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
import com.tencent.mm.cj.a.a;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.plugin.transvoice.a.c;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "bottomSheetCoordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "btnLayout", "canCloseKeyboard", "", "canClosePanel", "canHideKeyboard", "closeInputMethod", "Landroid/widget/ImageView;", "closePanel", "container", "Lcom/tencent/mm/modelvoiceaddr/ShortSentenceContainer;", "curTxt", "", "getCurTxt", "()Ljava/lang/String;", "setCurTxt", "(Ljava/lang/String;)V", "dotCounter", "", "dotStr", "emojiRoot", "Landroid/widget/FrameLayout;", "hasClick", "inputMethodLayout", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoicePanelLayout;", "inputMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "isEdited", "isKeyboardShown", "keyboardHeight", "langType", "languageChoiceDialog", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "mNewVoiceInputReport", "Lcom/tencent/mm/modelvoiceaddr/voicereport/NewVoiceInputReportManager;", "mVoiceIdSet", "", "needSendTxtMsg", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "overTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "panelDragOpeMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "reporter", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "sendTxtMsg", "Landroid/widget/Button;", "sendVoiceMsg", "showImeRunnable", "Ljava/lang/Runnable;", "smileyItem", "smileyOpener", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "talker", "getTalker", "setTalker", "targetView", "tmpClickChangeLangTypeTime", "", "transCancelable", "transMore", "transPanelAction", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "getTransPanelAction", "()Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "setTransPanelAction", "(Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;)V", "transSP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "txtEditView", "Lcom/tencent/mm/ui/widget/MMEditText;", "txtMsg4Send", "updateDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceAddr", "Lcom/tencent/mm/plugin/transvoice/model/SceneVoiceInputAddr2;", "value", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "voiceLen", "getVoiceLen", "()J", "setVoiceLen", "(J)V", "voiceMsgSend", "cgiReport", "", "msg", "closeInputMethodBtnVisibility", "visible", "closeTransPanel", "exitType", "delPunctuation", "getContentTxt", "init", "initSmileyPanel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshBottomPanelHeight", "resetTransPanel", "saveTransLangTypeByTalker", "type", "setBottomBtnVisibility", "setKeyboardVisibility", "setSmileyItemVisibility", "setSmileyPanelVisibility", "show", "startTrans", "updateCurTxt", "updateTransLangTypeByTalker", "Companion", "InputMode", "PanelDragOpeMode", "TransPanelAction", "plugin-transvoice_release"})
public final class b
  extends e
{
  public static int BVv;
  public static final b.a BVw;
  private MMBottomSheetBehavior<View> BTC;
  private boolean BTD;
  private a.b BTE;
  private ImageView BTz;
  final c BUM;
  long BUN;
  boolean BUO;
  private TransVoicePanelLayout BUP;
  private MMEditText BUQ;
  private ImageView BUR;
  private ImageView BUS;
  private View BUT;
  private View BUU;
  private ImageView BUV;
  private Button BUW;
  private Button BUX;
  com.tencent.mm.plugin.transvoice.a.b BUY;
  private b BUZ;
  public long BVa;
  String BVb;
  private boolean BVc;
  private String BVd;
  private int BVe;
  aw BVf;
  private boolean BVg;
  private a BVh;
  aq BVi;
  private SharedPreferences BVj;
  boolean BVk;
  private CoordinatorLayout BVl;
  private b.c BVm;
  private boolean BVn;
  private boolean BVo;
  private boolean BVp;
  private String BVq;
  private final com.tencent.mm.modelvoiceaddr.b.b BVr;
  private List<String> BVs;
  String BVt;
  public d BVu;
  private FrameLayout Brb;
  private boolean Bri;
  int iAD;
  h iAy;
  private int nMm;
  private final Runnable qdL;
  private ChatFooterPanel qdo;
  public String talker;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(102605);
    BVw = new b.a((byte)0);
    BVv = -1;
    AppMethodBeat.o(102605);
  }
  
  public b(final Context paramContext)
  {
    super(paramContext, 2131821488);
    AppMethodBeat.i(102604);
    c.a locala = c.BTw;
    this.BUM = c.evb();
    this.iAD = g.iBb;
    this.BUZ = b.BVx;
    this.BVd = "";
    this.BVj = paramContext.getSharedPreferences("voice2txt_sp", 0);
    this.BVm = b.c.BVB;
    this.BVq = "";
    gK();
    this.BVr = new com.tencent.mm.modelvoiceaddr.b.b();
    this.qdL = ((Runnable)new w(this, paramContext));
    this.BVt = "";
    AppMethodBeat.o(102604);
  }
  
  private final void Uf(int paramInt)
  {
    AppMethodBeat.i(102600);
    if (isShowing())
    {
      this.BUM.setExitType(paramInt);
      evo();
      dismiss();
      d locald = this.BVu;
      if (locald != null) {
        locald.evp();
      }
      if (!this.BVc)
      {
        locald = this.BVu;
        if (locald != null) {
          locald.aEA(this.BVb);
        }
      }
      this.BVc = false;
    }
    AppMethodBeat.o(102600);
  }
  
  private final void sW(boolean paramBoolean)
  {
    AppMethodBeat.i(102598);
    if (paramBoolean)
    {
      localImageView = this.BUR;
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        AppMethodBeat.o(102598);
        return;
      }
      AppMethodBeat.o(102598);
      return;
    }
    ImageView localImageView = this.BUR;
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
    ae.d("MicroMsg.TransVoiceDialog", "setKeyboardVisibility, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      localObject = this.targetView;
      if (localObject != null) {
        ((View)localObject).removeCallbacks(this.qdL);
      }
      localObject = this.targetView;
      if (localObject != null)
      {
        ((View)localObject).post(this.qdL);
        AppMethodBeat.o(102599);
        return;
      }
      AppMethodBeat.o(102599);
      return;
    }
    Object localObject = this.targetView;
    if (localObject != null) {
      ((View)localObject).removeCallbacks(this.qdL);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localObject = this.BUQ;
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
  
  public final void aEx(String paramString)
  {
    AppMethodBeat.i(185255);
    if (!bu.isNullOrNil(paramString))
    {
      this.BVb = paramString;
      a.a locala = com.tencent.mm.cj.a.Jmx;
      if (paramString == null) {
        p.gkB();
      }
      p.h(paramString, "<set-?>");
      com.tencent.mm.cj.a.aWH(paramString);
    }
    AppMethodBeat.o(185255);
  }
  
  public final void aEy(String paramString)
  {
    AppMethodBeat.i(102602);
    p.h(paramString, "<set-?>");
    this.BVt = paramString;
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
    localObject = this.BTC;
    if (localObject != null) {
      ((MMBottomSheetBehavior)localObject).cS();
    }
    this.BUO = false;
    this.BVk = false;
    int i = this.BVj.getInt(this.talker, 0);
    localObject = this.BVh;
    if (localObject == null) {
      p.gkB();
    }
    localObject = ((a)localObject).BTA;
    if (localObject == null) {
      p.gkB();
    }
    if (((ArrayList)localObject).contains(Integer.valueOf(i))) {
      this.iAD = i;
    }
    for (;;)
    {
      this.BUM.BTl = this.iAD;
      evo();
      localObject = this.BVi;
      if (localObject != null) {
        ((aq)localObject).sendEmptyMessageDelayed(5000, 5000L);
      }
      localObject = this.BVf;
      if (localObject != null) {
        ((aw)localObject).Dv(500L);
      }
      this.iAy = paramh;
      this.BUY = new com.tencent.mm.plugin.transvoice.a.b(paramh, this.iAD, (g.b)new x(this));
      paramh = this.BUY;
      if (paramh == null) {
        break;
      }
      paramh.start();
      AppMethodBeat.o(185256);
      return;
      localObject = this.BVh;
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((a)localObject).BTA;
      if (localObject == null) {
        p.gkB();
      }
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = this.BVh;
        if (localObject == null) {
          p.gkB();
        }
        localObject = ((a)localObject).BTA;
        if (localObject == null) {
          p.gkB();
        }
        localObject = ((ArrayList)localObject).get(0);
        p.g(localObject, "languageChoiceDialog!!.langTypeArr!![0]");
        this.iAD = ((Number)localObject).intValue();
      }
      else
      {
        localObject = ad.iR(getContext());
        if ((p.i(localObject, "zh_CN")) || (p.i(localObject, "zh_HK")) || (p.i(localObject, "zh_TW"))) {
          this.iAD = g.iBb;
        } else if (p.i(localObject, "en")) {
          this.iAD = g.iBd;
        }
      }
    }
    AppMethodBeat.o(185256);
  }
  
  final void evo()
  {
    AppMethodBeat.i(102601);
    this.BVt = "";
    this.BVe = 0;
    this.BVd = "";
    this.BVg = false;
    Object localObject = this.BUQ;
    if (localObject != null) {
      ((MMEditText)localObject).setText((CharSequence)"");
    }
    localObject = this.BUQ;
    if (localObject != null) {
      ((MMEditText)localObject).setCursorVisible(false);
    }
    localObject = this.BUQ;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusable(false);
    }
    localObject = this.BUQ;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusableInTouchMode(false);
    }
    localObject = this.BUT;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.BUU;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    setKeyboardVisibility(false);
    localObject = this.qdo;
    if (localObject != null) {
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    sW(false);
    localObject = this.BVi;
    if (localObject != null) {
      ((aq)localObject).removeMessages(5000);
    }
    this.BVm = b.c.BVB;
    this.BTD = false;
    this.BVn = false;
    this.BVo = false;
    AppMethodBeat.o(102601);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(102597);
    Uf(6);
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
      this.BUP = paramBundle;
      paramBundle = this.BUP;
      if (paramBundle != null) {
        paramBundle.setOnInputPanelChange((TransVoicePanelLayout.a)new h(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1056;
      }
      paramBundle = (CoordinatorLayout)paramBundle.findViewById(2131296673);
      label160:
      this.BVl = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1061;
      }
      paramBundle = paramBundle.findViewById(2131303747);
      label182:
      this.BTC = MMBottomSheetBehavior.w(paramBundle);
      paramBundle = this.BTC;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new o(this));
      }
      paramBundle = this.BTC;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.b)new p(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1066;
      }
      paramBundle = (MMEditText)paramBundle.findViewById(2131306060);
      label258:
      this.BUQ = paramBundle;
      paramBundle = this.BUQ;
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
      this.BTz = paramBundle;
      paramBundle = this.BTz;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new q(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1076;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131306061);
      label403:
      this.BUR = paramBundle;
      paramBundle = this.BUR;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new r(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1081;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131298371);
      label452:
      this.BUS = paramBundle;
      paramBundle = this.BUS;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new s(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1086;
      }
      paramBundle = paramBundle.findViewById(2131303745);
      label498:
      this.BUT = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1091;
      }
      paramBundle = paramBundle.findViewById(2131304864);
      label520:
      this.BUU = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1096;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131304869);
      label545:
      this.BUV = paramBundle;
      paramBundle = this.BUV;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new t(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1101;
      }
      paramBundle = (FrameLayout)paramBundle.findViewById(2131299431);
      label594:
      this.Brb = paramBundle;
      this.qdo = ((ChatFooterPanel)com.tencent.mm.api.aa.bi(getContext()));
      this.nMm = com.tencent.mm.sdk.platformtools.aa.iN(getContext());
      paramBundle = new FrameLayout.LayoutParams(-1, this.nMm);
      localObject = this.Brb;
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.qdo, (ViewGroup.LayoutParams)paramBundle);
      }
      paramBundle = this.qdo;
      if (paramBundle != null) {
        paramBundle.setPortHeightPx(this.nMm);
      }
      paramBundle = this.qdo;
      if (paramBundle != null) {
        paramBundle.setEntranceScene(ChatFooterPanel.FkJ);
      }
      paramBundle = this.qdo;
      if (paramBundle != null) {
        paramBundle.fft();
      }
      paramBundle = this.qdo;
      if (paramBundle != null) {
        paramBundle.onResume();
      }
      paramBundle = this.qdo;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.qdo;
      if (paramBundle != null) {
        paramBundle.setShowSend(true);
      }
      paramBundle = this.qdo;
      if (paramBundle != null) {
        paramBundle.setOnTextOperationListener((ChatFooterPanel.a)new v(this));
      }
      this.BVf = new aw((aw.a)new u(this), true);
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1106;
      }
      paramBundle = (Button)paramBundle.findViewById(2131297597);
      label815:
      this.BUW = paramBundle;
      paramBundle = this.BUW;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new i(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1111;
      }
      paramBundle = (Button)paramBundle.findViewById(2131297598);
      label864:
      this.BUX = paramBundle;
      paramBundle = this.BUX;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new j(this));
      }
      paramBundle = this.BUW;
      if (paramBundle == null) {
        break label1116;
      }
      paramBundle = paramBundle.getPaint();
      label907:
      al.a((Paint)paramBundle, 0.8F);
      paramBundle = this.BUX;
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
      al.a((Paint)paramBundle, 0.8F);
      this.BTE = ((a.b)new k(this));
      paramBundle = getContext();
      p.g(paramBundle, "context");
      this.BVh = new a(paramBundle);
      paramBundle = this.BVh;
      if (paramBundle != null)
      {
        paramBundle.setOnDismissListener((DialogInterface.OnDismissListener)b.l.BVF);
        paramBundle.BTE = this.BTE;
      }
      this.BVi = new aq((aq.a)new m(this));
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
    a.a locala = com.tencent.mm.cj.a.Jmx;
    com.tencent.mm.cj.a.xc(true);
    super.show();
    AppMethodBeat.o(102603);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "", "(Ljava/lang/String;I)V", "INPUT_NONE", "INPUT_EMOJI", "INPUT_KEYBOARD", "plugin-transvoice_release"})
  static enum b
  {
    static
    {
      AppMethodBeat.i(102558);
      b localb1 = new b("INPUT_NONE", 0);
      BVx = localb1;
      b localb2 = new b("INPUT_EMOJI", 1);
      BVy = localb2;
      b localb3 = new b("INPUT_KEYBOARD", 2);
      BVz = localb3;
      BVA = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(102558);
    }
    
    private b() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "", "onTransPanelClose", "", "onTxtMsgSend", "txt", "", "onVoiceMsgDelete", "fileName", "onVoiceMsgSend", "", "fileLength", "", "(Ljava/lang/String;Ljava/lang/Long;)Z", "plugin-transvoice_release"})
  public static abstract interface d
  {
    public abstract void aEA(String paramString);
    
    public abstract void aEz(String paramString);
    
    public abstract boolean b(String paramString, Long paramLong);
    
    public abstract void evp();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$1"})
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
        b.o(this.BVE);
        AppMethodBeat.o(102565);
        return true;
      }
      AppMethodBeat.o(102565);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$2"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102566);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      b.p(this.BVE).BTu = 1;
      b.r(this.BVE);
      if (b.s(this.BVE))
      {
        b.j(this.BVE, false);
        b.p(this.BVE).BTs = 0;
        b.p(this.BVE).BTo = System.currentTimeMillis();
        paramView = b.t(this.BVE);
        if (paramView != null) {
          paramView.cancel(true);
        }
        paramView = b.u(this.BVE);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = b.v(this.BVE);
        if (paramView != null) {
          paramView.removeMessages(5000);
        }
        paramView = b.w(this.BVE);
        if (paramView != null) {
          paramView.stopTimer();
        }
        paramView = b.e(this.BVE);
        if (paramView != null) {
          paramView.setText((CharSequence)this.BVE.BVt);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102566);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-transvoice_release"})
  public static final class g
    implements TextWatcher
  {
    g(b paramb) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int i = 0;
      AppMethodBeat.i(102567);
      if ((!b.x(this.BVE)) && (b.q(this.BVE)))
      {
        b.y(this.BVE);
        b.p(this.BVE).BTt = 1;
      }
      Object localObject = b.z(this.BVE);
      if (localObject != null) {
        if (bu.ah((CharSequence)paramEditable)) {
          break label115;
        }
      }
      label115:
      for (boolean bool = true;; bool = false)
      {
        ((Button)localObject).setEnabled(bool);
        localObject = b.A(this.BVE);
        if (localObject == null) {
          break;
        }
        if (bu.ah((CharSequence)paramEditable)) {
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "isKeyboardShow", "", "keyboardHeight", "", "onInputPanelChange"})
  static final class h
    implements TransVoicePanelLayout.a
  {
    h(b paramb) {}
    
    public final void g(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(102568);
      b.a(this.BVE, paramBoolean);
      ae.d("MicroMsg.TransVoiceDialog", "isKeyboardShow %s.", new Object[] { Boolean.valueOf(paramBoolean) });
      Object localObject;
      if (paramBoolean)
      {
        b.a(this.BVE, b.b.BVz);
        localObject = b.c(this.BVE);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState())) {
          b.a(this.BVE, b.c.BVC);
        }
        localObject = b.e(this.BVE);
        if (localObject != null) {
          ((MMEditText)localObject).setCursorVisible(true);
        }
        b.b(this.BVE, true);
        b.c(this.BVE, false);
        b.d(this.BVE, false);
        localObject = b.f(this.BVE);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(2131231701);
        }
        b.e(this.BVE, true);
      }
      for (;;)
      {
        if ((b.h(this.BVE) != paramInt) && (paramInt != 0))
        {
          b.a(this.BVE, paramInt);
          i.A(this.BVE.getContext(), paramInt);
          b.i(this.BVE);
        }
        AppMethodBeat.o(102568);
        return;
        localObject = b.c(this.BVE);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState()) && (b.b.BVy != b.b(this.BVE))) {
          b.a(this.BVE, b.c.BVB);
        }
        localObject = b.b(this.BVE);
        switch (c.cqt[localObject.ordinal()])
        {
        case 1: 
        default: 
          break;
        case 2: 
          b.a(this.BVE, b.b.BVx);
          if (b.c.BVC != b.d(this.BVE))
          {
            b.b(this.BVE, false);
            b.c(this.BVE, true);
            localObject = b.g(this.BVE);
            if (localObject != null) {
              ((ChatFooterPanel)localObject).setVisibility(8);
            }
            localObject = b.e(this.BVE);
            if (localObject != null) {
              ((MMEditText)localObject).setCursorVisible(false);
            }
            b.e(this.BVE, false);
          }
          break;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102569);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ae.i("MicroMsg.TransVoiceDialog", "sendVoiceMsg onClick.");
      paramView = this.BVE.BVu;
      if ((paramView != null) && (true == paramView.b(this.BVE.BVb, Long.valueOf(this.BVE.BVa)))) {
        b.F(this.BVE);
      }
      b.b(this.BVE, 7);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102569);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102570);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      b.o(this.BVE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102570);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$12", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static final class k
    implements a.b
  {
    public final void TZ(int paramInt)
    {
      AppMethodBeat.i(102571);
      Object localObject1 = b.B(this.BVE);
      if (localObject1 != null) {
        ((a)localObject1).dismiss();
      }
      b.d(this.BVE, paramInt);
      if (paramInt == b.C(this.BVE))
      {
        AppMethodBeat.o(102571);
        return;
      }
      if (az.isConnected(this.BVE.getContext()))
      {
        localObject1 = this.BVE;
        ((b)localObject1).BUO = false;
        ((b)localObject1).BVk = false;
        ((b)localObject1).BUM.BTk = ((b)localObject1).BUN;
        ((b)localObject1).BUM.BTn = 0;
        ((b)localObject1).BUM.BTo = 0L;
        ((b)localObject1).BUM.BTp = 0;
        ((b)localObject1).BUM.BTs = 0;
        ((b)localObject1).BUM.BTt = 0;
        ((b)localObject1).BUM.BTu = 0;
        ((b)localObject1).evo();
        localObject2 = ((b)localObject1).BVi;
        if (localObject2 != null) {
          ((aq)localObject2).sendEmptyMessageDelayed(5000, 5000L);
        }
        localObject2 = ((b)localObject1).BVf;
        if (localObject2 != null) {
          ((aw)localObject2).Dv(500L);
        }
        ((b)localObject1).iAD = paramInt;
        long l2 = System.nanoTime() & 0xFFFFFFFF;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = Math.abs(l2);
        }
        localObject2 = new h(String.valueOf(l1));
        h localh = ((b)localObject1).iAy;
        if (localh != null) {
          localh.a((h)localObject2);
        }
        ((b)localObject1).BUY = new com.tencent.mm.plugin.transvoice.a.b((h)localObject2, paramInt, (g.b)new b.y((b)localObject1));
        localObject1 = ((b)localObject1).BUY;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.transvoice.a.b)localObject1).start();
          AppMethodBeat.o(102571);
          return;
        }
        AppMethodBeat.o(102571);
        return;
      }
      localObject1 = new d.a(this.BVE.getContext());
      Object localObject2 = this.BVE.getContext();
      p.g(localObject2, "context");
      ((d.a)localObject1).aZi(((Context)localObject2).getResources().getString(2131755828));
      localObject2 = this.BVE.getContext();
      p.g(localObject2, "context");
      ((d.a)localObject1).aZo(((Context)localObject2).getResources().getString(2131761549));
      localObject2 = this.BVE.getContext();
      p.g(localObject2, "context");
      ((d.a)localObject1).afW(((Context)localObject2).getResources().getColor(2131099770));
      ((d.a)localObject1).fQv().show();
      AppMethodBeat.o(102571);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class m
    implements aq.a
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
        b.p(this.BVE).BTn = 1;
        b.p(this.BVE).BTo = System.currentTimeMillis();
        b.p(this.BVE).BTs = 0;
        paramMessage = b.w(this.BVE);
        if (paramMessage != null) {
          paramMessage.stopTimer();
        }
        paramMessage = b.t(this.BVE);
        if (paramMessage != null) {
          paramMessage.cancel(false);
        }
        if (!bu.isNullOrNil(this.BVE.BVt))
        {
          paramMessage = b.e(this.BVE);
          if (paramMessage != null) {
            paramMessage.setFocusable(true);
          }
          paramMessage = b.e(this.BVE);
          if (paramMessage != null) {
            paramMessage.setFocusableInTouchMode(true);
          }
        }
        paramMessage = b.e(this.BVE);
        if (paramMessage != null) {
          paramMessage.setText((CharSequence)this.BVE.BVt);
        }
        paramMessage = b.u(this.BVE);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class n
    implements DialogInterface.OnDismissListener
  {
    n(b paramb) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(102574);
      ae.d("MicroMsg.TransVoiceDialog", "onDismiss.");
      if (b.G(this.BVE))
      {
        b.H(this.BVE);
        if (!bu.isNullOrNil(b.I(this.BVE)))
        {
          paramDialogInterface = this.BVE.BVu;
          if (paramDialogInterface != null) {
            paramDialogInterface.aEz(b.I(this.BVE));
          }
          b.b(this.BVE, b.I(this.BVE));
        }
      }
      AppMethodBeat.o(102574);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$2", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class o
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102576);
      p.h(paramView, "bottomSheet");
      ae.d("MicroMsg.TransVoiceDialog", "slideOffset: %f, panelDragOpeMode: %s.", new Object[] { Float.valueOf(paramFloat), b.d(this.BVE) });
      paramView = b.c(this.BVE);
      if (paramView != null)
      {
        if (paramView.getState() != 1) {
          break label305;
        }
        if (b.c.BVB == b.d(this.BVE))
        {
          paramView = this.BVE;
          if (0.7F < paramFloat) {
            break label239;
          }
          bool = true;
          b.f(paramView, bool);
          paramView = this.BVE.getWindow();
          if (paramView != null) {
            paramView.setDimAmount((float)(0.5D - (1.0F - paramFloat) / 2.0D));
          }
        }
        if (b.c.BVC != b.d(this.BVE)) {
          break label305;
        }
        paramView = this.BVE;
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
        if (b.l(this.BVE)) {
          break label305;
        }
        b.h(this.BVE, true);
        b.i(this.BVE, false);
        b.b(this.BVE, false);
        b.c(this.BVE, false);
        b.d(this.BVE, false);
        paramView = b.f(this.BVE);
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
      if (b.l(this.BVE))
      {
        b.h(this.BVE, false);
        b.i(this.BVE, true);
        b.b(this.BVE, true);
        b.c(this.BVE, false);
        b.d(this.BVE, false);
      }
      label305:
      AppMethodBeat.o(102576);
    }
    
    @SuppressLint({"SwitchIntDef"})
    public final void k(View paramView, int paramInt)
    {
      AppMethodBeat.i(102577);
      p.h(paramView, "bottomSheet");
      ae.d("MicroMsg.TransVoiceDialog", "newState: %d, panelDragOpeMode: %s, canClosePanel: %s, canHideKeyboard: %s, canCloseKeyboard: %s.", new Object[] { Integer.valueOf(paramInt), b.d(this.BVE), Boolean.valueOf(b.j(this.BVE)), Boolean.valueOf(b.l(this.BVE)), Boolean.valueOf(b.k(this.BVE)) });
      switch (paramInt)
      {
      }
      while ((1 != paramInt) && (3 != paramInt)) {
        if (!b.j(this.BVE))
        {
          paramView = this.BVE.getWindow();
          if (paramView != null) {
            paramView.setDimAmount(0.5F);
          }
          paramView = b.c(this.BVE);
          if (paramView != null)
          {
            paramView.cS();
            AppMethodBeat.o(102577);
            return;
            b.f(this.BVE, false);
            b.h(this.BVE, false);
            b.g(this.BVE, false);
            continue;
            if ((b.c.BVB == b.d(this.BVE)) && (b.j(this.BVE))) {
              b.b(this.BVE, 6);
            }
            if ((b.c.BVC == b.d(this.BVE)) && (b.l(this.BVE))) {
              if (b.k(this.BVE))
              {
                b.a(this.BVE, b.c.BVB);
                b.c(this.BVE, true);
                b.b(this.BVE, false);
                paramView = b.g(this.BVE);
                if (paramView != null) {
                  paramView.setVisibility(8);
                }
                paramView = b.e(this.BVE);
                if (paramView != null) {
                  paramView.setCursorVisible(false);
                }
                b.e(this.BVE, false);
                paramView = b.m(this.BVE);
                if (paramView != null) {
                  paramView.postDelayed((Runnable)new a(this), 200L);
                }
              }
              else
              {
                b.i(this.BVE, true);
                b.b(this.BVE, true);
                b.c(this.BVE, false);
                b.d(this.BVE, false);
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
          b.b(this.BVE, 6);
        }
      }
      AppMethodBeat.o(102577);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.o paramo) {}
      
      public final void run()
      {
        AppMethodBeat.i(102575);
        TransVoicePanelLayout localTransVoicePanelLayout = b.m(this.BVG.BVE);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$ExternalTouchHelper;", "downY", "", "getDownY", "()F", "setDownY", "(F)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onNeedJudge", "plugin-transvoice_release"})
  public static final class p
    implements MMBottomSheetBehavior.b
  {
    private float cNR;
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      Boolean localBoolean = null;
      AppMethodBeat.i(102578);
      p.h(paramMotionEvent, "event");
      p.h(paramMotionEvent, "event");
      Object localObject = b.n(this.BVE);
      int i;
      if (localObject != null)
      {
        MMEditText localMMEditText = b.e(this.BVE);
        if (localMMEditText == null) {
          p.gkB();
        }
        if (true == ((CoordinatorLayout)localObject).d((View)localMMEditText, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          i = 1;
          if (i != 0)
          {
            localObject = b.e(this.BVE);
            if (localObject == null) {
              break label268;
            }
            localObject = Boolean.valueOf(((MMEditText)localObject).canScrollVertically(-1));
            label106:
            localMMEditText = b.e(this.BVE);
            if (localMMEditText != null) {
              localBoolean = Boolean.valueOf(localMMEditText.canScrollVertically(1));
            }
            ae.d("MicroMsg.TransVoiceDialog", "can scroll up, %s.", new Object[] { localObject });
            ae.d("MicroMsg.TransVoiceDialog", "can scroll down, %s.", new Object[] { localBoolean });
            ae.d("MicroMsg.TransVoiceDialog", "action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
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
          this.cNR = paramMotionEvent.getY();
        }
        f = paramMotionEvent.getY() - this.cNR;
        ae.d("MicroMsg.TransVoiceDialog", "yOffset: %f.", new Object[] { Float.valueOf(f) });
        if (f > 0.0F)
        {
          bool = p.i(Boolean.TRUE, localObject);
          AppMethodBeat.o(102578);
          return bool;
        }
      } while (f >= 0.0F);
      boolean bool = p.i(Boolean.TRUE, localBoolean);
      AppMethodBeat.o(102578);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102579);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      b.b(this.BVE, 6);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102579);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102580);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      b.a(this.BVE, System.currentTimeMillis());
      paramView = b.B(this.BVE);
      if (paramView != null) {
        paramView.iAD = b.C(this.BVE);
      }
      paramView = b.B(this.BVE);
      if (paramView != null) {
        paramView.evd();
      }
      paramView = b.B(this.BVE);
      if (paramView != null) {
        paramView.show();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102580);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102581);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = b.b(this.BVE);
      switch (c.gpL[paramView.ordinal()])
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(102581);
        return;
        b.i(this.BVE, false);
        continue;
        b.a(this.BVE, b.b.BVx);
        b.b(this.BVE, false);
        b.c(this.BVE, true);
        paramView = b.g(this.BVE);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = b.e(this.BVE);
        if (paramView != null) {
          paramView.setCursorVisible(false);
        }
        b.e(this.BVE, false);
        continue;
        b.a(this.BVE, b.b.BVx);
        b.b(this.BVE, 6);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102582);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (b.a(this.BVE))
      {
        b.a(this.BVE, b.b.BVy);
        b.i(this.BVE, false);
        b.d(this.BVE, true);
        paramView = b.f(this.BVE);
        if (paramView != null) {
          paramView.setImageResource(2131231706);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(102582);
        return;
        b.a(this.BVE, b.b.BVz);
        b.i(this.BVE, true);
        b.d(this.BVE, false);
        paramView = b.f(this.BVE);
        if (paramView != null) {
          paramView.setImageResource(2131231701);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class u
    implements aw.a
  {
    u(b paramb) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(102583);
      int i = b.D(this.BVE);
      b localb = this.BVE;
      b.c(localb, b.D(localb) + 1);
      switch (i % 3)
      {
      }
      for (;;)
      {
        b.E(this.BVE);
        AppMethodBeat.o(102583);
        return true;
        b.a(this.BVE, "·");
        continue;
        b.a(this.BVE, "··");
        continue;
        b.a(this.BVE, "···");
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-transvoice_release"})
  public static final class v
    implements ChatFooterPanel.a
  {
    public final void apc()
    {
      AppMethodBeat.i(102585);
      Object localObject = b.e(this.BVE);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = b.e(this.BVE);
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
    
    public final void apd()
    {
      AppMethodBeat.i(102586);
      b.o(this.BVE);
      AppMethodBeat.o(102586);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(102584);
      MMEditText localMMEditText = b.e(this.BVE);
      if (localMMEditText != null)
      {
        localMMEditText.aZf(paramString);
        AppMethodBeat.o(102584);
        return;
      }
      AppMethodBeat.o(102584);
    }
    
    public final void dW(boolean paramBoolean) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
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
        localInputMethodManager.showSoftInput((View)b.e(this.BVE), 0);
        AppMethodBeat.o(102587);
        return;
      }
      AppMethodBeat.o(102587);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class x
    implements g.b
  {
    public final void aOo()
    {
      AppMethodBeat.i(102590);
      ae.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102590);
    }
    
    public final void aOs()
    {
      AppMethodBeat.i(102591);
      ae.i("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.BVE, false);
      b.p(this.BVE).BTs = 1;
      b.p(this.BVE).BTo = System.currentTimeMillis();
      Object localObject = b.v(this.BVE);
      if (localObject != null) {
        ((aq)localObject).removeMessages(5000);
      }
      localObject = b.w(this.BVE);
      if (localObject != null) {
        ((aw)localObject).stopTimer();
      }
      b.J(this.BVE);
      localObject = b.u(this.BVE);
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
      ae.i("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.BVE, paramList);
      paramList = b.v(this.BVE);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.BVE);
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
            this.BVE.aEy(paramArrayOfString[0]);
            ae.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.BVE.BVt });
            b.p(this.BVE).BTp = this.BVE.BVt.length();
            if (b.s(this.BVE)) {
              break;
            }
            b.j(this.BVE, true);
            paramArrayOfString = b.e(this.BVE);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.BVE);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.BVE);
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
      ae.i("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
      b.p(this.BVE).BTs = 0;
      b.p(this.BVE).BTo = System.currentTimeMillis();
      AppMethodBeat.o(102589);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$2", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class y
    implements g.b
  {
    public final void aOo()
    {
      AppMethodBeat.i(102594);
      ae.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102594);
    }
    
    public final void aOs()
    {
      AppMethodBeat.i(102595);
      ae.d("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.BVE, false);
      b.p(this.BVE).BTs = 1;
      b.p(this.BVE).BTo = System.currentTimeMillis();
      Object localObject = b.v(this.BVE);
      if (localObject != null) {
        ((aq)localObject).removeMessages(5000);
      }
      localObject = b.w(this.BVE);
      if (localObject != null) {
        ((aw)localObject).stopTimer();
      }
      b.J(this.BVE);
      localObject = b.u(this.BVE);
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
      ae.d("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.BVE, paramList);
      paramList = b.v(this.BVE);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.BVE);
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
            this.BVE.aEy(paramArrayOfString[0]);
            ae.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.BVE.BVt });
            b.p(this.BVE).BTp = this.BVE.BVt.length();
            if (b.s(this.BVE)) {
              break;
            }
            b.j(this.BVE, true);
            paramArrayOfString = b.e(this.BVE);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.BVE);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.BVE);
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
      ae.d("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
      b.p(this.BVE).BTs = 0;
      b.p(this.BVE).BTo = System.currentTimeMillis();
      AppMethodBeat.o(102593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b
 * JD-Core Version:    0.7.0.1
 */