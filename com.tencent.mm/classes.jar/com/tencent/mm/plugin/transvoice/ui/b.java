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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "bottomSheetCoordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "btnLayout", "canCloseKeyboard", "", "canClosePanel", "canHideKeyboard", "closeInputMethod", "Landroid/widget/ImageView;", "closePanel", "container", "Lcom/tencent/mm/modelvoiceaddr/ShortSentenceContainer;", "curTxt", "", "getCurTxt", "()Ljava/lang/String;", "setCurTxt", "(Ljava/lang/String;)V", "dotCounter", "", "dotStr", "emojiRoot", "Landroid/widget/FrameLayout;", "hasClick", "inputMethodLayout", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoicePanelLayout;", "inputMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "isEdited", "isKeyboardShown", "keyboardHeight", "langType", "languageChoiceDialog", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "mNewVoiceInputReport", "Lcom/tencent/mm/modelvoiceaddr/voicereport/NewVoiceInputReportManager;", "mVoiceIdSet", "", "needSendTxtMsg", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "overTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "panelDragOpeMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "reporter", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "sendTxtMsg", "Landroid/widget/Button;", "sendVoiceMsg", "showImeRunnable", "Ljava/lang/Runnable;", "smileyItem", "smileyOpener", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "talker", "getTalker", "setTalker", "targetView", "tmpClickChangeLangTypeTime", "", "transCancelable", "transMore", "transPanelAction", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "getTransPanelAction", "()Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "setTransPanelAction", "(Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;)V", "transSP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "txtEditView", "Lcom/tencent/mm/ui/widget/MMEditText;", "txtMsg4Send", "updateDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceAddr", "Lcom/tencent/mm/plugin/transvoice/model/SceneVoiceInputAddr2;", "value", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "voiceLen", "getVoiceLen", "()J", "setVoiceLen", "(J)V", "voiceMsgSend", "cgiReport", "", "msg", "closeInputMethodBtnVisibility", "visible", "closeTransPanel", "exitType", "delPunctuation", "getContentTxt", "init", "initSmileyPanel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshBottomPanelHeight", "resetTransPanel", "saveTransLangTypeByTalker", "type", "setBottomBtnVisibility", "setKeyboardVisibility", "setSmileyItemVisibility", "setSmileyPanelVisibility", "show", "startTrans", "updateCurTxt", "updateTransLangTypeByTalker", "Companion", "InputMode", "PanelDragOpeMode", "TransPanelAction", "plugin-transvoice_release"})
public final class b
  extends e
{
  public static int BDX;
  public static final b.a BDY;
  private FrameLayout AZD;
  private boolean AZK;
  private ImageView BCb;
  private MMBottomSheetBehavior<View> BCe;
  private boolean BCf;
  private a.b BCg;
  com.tencent.mm.plugin.transvoice.a.b BDA;
  private b BDB;
  public long BDC;
  String BDD;
  private boolean BDE;
  private String BDF;
  private int BDG;
  av BDH;
  private boolean BDI;
  private a BDJ;
  ap BDK;
  private SharedPreferences BDL;
  boolean BDM;
  private CoordinatorLayout BDN;
  private b.c BDO;
  private boolean BDP;
  private boolean BDQ;
  private boolean BDR;
  private String BDS;
  private final com.tencent.mm.modelvoiceaddr.b.b BDT;
  private List<String> BDU;
  String BDV;
  public d BDW;
  final c BDo;
  long BDp;
  boolean BDq;
  private TransVoicePanelLayout BDr;
  private MMEditText BDs;
  private ImageView BDt;
  private ImageView BDu;
  private View BDv;
  private View BDw;
  private ImageView BDx;
  private Button BDy;
  private Button BDz;
  h ixF;
  int ixK;
  private int nGK;
  private ChatFooterPanel pWJ;
  private final Runnable pXg;
  public String talker;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(102605);
    BDY = new b.a((byte)0);
    BDX = -1;
    AppMethodBeat.o(102605);
  }
  
  public b(final Context paramContext)
  {
    super(paramContext, 2131821488);
    AppMethodBeat.i(102604);
    c.a locala = c.BBY;
    this.BDo = c.eru();
    this.ixK = g.iyi;
    this.BDB = b.BDZ;
    this.BDF = "";
    this.BDL = paramContext.getSharedPreferences("voice2txt_sp", 0);
    this.BDO = b.c.BEd;
    this.BDS = "";
    gK();
    this.BDT = new com.tencent.mm.modelvoiceaddr.b.b();
    this.pXg = ((Runnable)new w(this, paramContext));
    this.BDV = "";
    AppMethodBeat.o(102604);
  }
  
  private final void Ty(int paramInt)
  {
    AppMethodBeat.i(102600);
    if (isShowing())
    {
      this.BDo.setExitType(paramInt);
      erH();
      dismiss();
      d locald = this.BDW;
      if (locald != null) {
        locald.erI();
      }
      if (!this.BDE)
      {
        locald = this.BDW;
        if (locald != null) {
          locald.aDh(this.BDD);
        }
      }
      this.BDE = false;
    }
    AppMethodBeat.o(102600);
  }
  
  private final void sP(boolean paramBoolean)
  {
    AppMethodBeat.i(102598);
    if (paramBoolean)
    {
      localImageView = this.BDt;
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        AppMethodBeat.o(102598);
        return;
      }
      AppMethodBeat.o(102598);
      return;
    }
    ImageView localImageView = this.BDt;
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
        ((View)localObject).removeCallbacks(this.pXg);
      }
      localObject = this.targetView;
      if (localObject != null)
      {
        ((View)localObject).post(this.pXg);
        AppMethodBeat.o(102599);
        return;
      }
      AppMethodBeat.o(102599);
      return;
    }
    Object localObject = this.targetView;
    if (localObject != null) {
      ((View)localObject).removeCallbacks(this.pXg);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localObject = this.BDs;
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
  
  public final void aDe(String paramString)
  {
    AppMethodBeat.i(185255);
    if (!bt.isNullOrNil(paramString))
    {
      this.BDD = paramString;
      a.a locala = com.tencent.mm.ck.a.IRP;
      if (paramString == null) {
        p.gfZ();
      }
      p.h(paramString, "<set-?>");
      com.tencent.mm.ck.a.aVg(paramString);
    }
    AppMethodBeat.o(185255);
  }
  
  public final void aDf(String paramString)
  {
    AppMethodBeat.i(102602);
    p.h(paramString, "<set-?>");
    this.BDV = paramString;
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
    localObject = this.BCe;
    if (localObject != null) {
      ((MMBottomSheetBehavior)localObject).cS();
    }
    this.BDq = false;
    this.BDM = false;
    int i = this.BDL.getInt(this.talker, 0);
    localObject = this.BDJ;
    if (localObject == null) {
      p.gfZ();
    }
    localObject = ((a)localObject).BCc;
    if (localObject == null) {
      p.gfZ();
    }
    if (((ArrayList)localObject).contains(Integer.valueOf(i))) {
      this.ixK = i;
    }
    for (;;)
    {
      this.BDo.BBN = this.ixK;
      erH();
      localObject = this.BDK;
      if (localObject != null) {
        ((ap)localObject).sendEmptyMessageDelayed(5000, 5000L);
      }
      localObject = this.BDH;
      if (localObject != null) {
        ((av)localObject).CX(500L);
      }
      this.ixF = paramh;
      this.BDA = new com.tencent.mm.plugin.transvoice.a.b(paramh, this.ixK, (g.b)new x(this));
      paramh = this.BDA;
      if (paramh == null) {
        break;
      }
      paramh.start();
      AppMethodBeat.o(185256);
      return;
      localObject = this.BDJ;
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((a)localObject).BCc;
      if (localObject == null) {
        p.gfZ();
      }
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = this.BDJ;
        if (localObject == null) {
          p.gfZ();
        }
        localObject = ((a)localObject).BCc;
        if (localObject == null) {
          p.gfZ();
        }
        localObject = ((ArrayList)localObject).get(0);
        p.g(localObject, "languageChoiceDialog!!.langTypeArr!![0]");
        this.ixK = ((Number)localObject).intValue();
      }
      else
      {
        localObject = ac.iM(getContext());
        if ((p.i(localObject, "zh_CN")) || (p.i(localObject, "zh_HK")) || (p.i(localObject, "zh_TW"))) {
          this.ixK = g.iyi;
        } else if (p.i(localObject, "en")) {
          this.ixK = g.iyk;
        }
      }
    }
    AppMethodBeat.o(185256);
  }
  
  final void erH()
  {
    AppMethodBeat.i(102601);
    this.BDV = "";
    this.BDG = 0;
    this.BDF = "";
    this.BDI = false;
    Object localObject = this.BDs;
    if (localObject != null) {
      ((MMEditText)localObject).setText((CharSequence)"");
    }
    localObject = this.BDs;
    if (localObject != null) {
      ((MMEditText)localObject).setCursorVisible(false);
    }
    localObject = this.BDs;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusable(false);
    }
    localObject = this.BDs;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusableInTouchMode(false);
    }
    localObject = this.BDv;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.BDw;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    setKeyboardVisibility(false);
    localObject = this.pWJ;
    if (localObject != null) {
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    sP(false);
    localObject = this.BDK;
    if (localObject != null) {
      ((ap)localObject).removeMessages(5000);
    }
    this.BDO = b.c.BEd;
    this.BCf = false;
    this.BDP = false;
    this.BDQ = false;
    AppMethodBeat.o(102601);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(102597);
    Ty(6);
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
      this.BDr = paramBundle;
      paramBundle = this.BDr;
      if (paramBundle != null) {
        paramBundle.setOnInputPanelChange((TransVoicePanelLayout.a)new h(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1056;
      }
      paramBundle = (CoordinatorLayout)paramBundle.findViewById(2131296673);
      label160:
      this.BDN = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1061;
      }
      paramBundle = paramBundle.findViewById(2131303747);
      label182:
      this.BCe = MMBottomSheetBehavior.w(paramBundle);
      paramBundle = this.BCe;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new o(this));
      }
      paramBundle = this.BCe;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.b)new p(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1066;
      }
      paramBundle = (MMEditText)paramBundle.findViewById(2131306060);
      label258:
      this.BDs = paramBundle;
      paramBundle = this.BDs;
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
      this.BCb = paramBundle;
      paramBundle = this.BCb;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new q(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1076;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131306061);
      label403:
      this.BDt = paramBundle;
      paramBundle = this.BDt;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new r(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1081;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131298371);
      label452:
      this.BDu = paramBundle;
      paramBundle = this.BDu;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new s(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1086;
      }
      paramBundle = paramBundle.findViewById(2131303745);
      label498:
      this.BDv = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1091;
      }
      paramBundle = paramBundle.findViewById(2131304864);
      label520:
      this.BDw = paramBundle;
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1096;
      }
      paramBundle = (ImageView)paramBundle.findViewById(2131304869);
      label545:
      this.BDx = paramBundle;
      paramBundle = this.BDx;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new t(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1101;
      }
      paramBundle = (FrameLayout)paramBundle.findViewById(2131299431);
      label594:
      this.AZD = paramBundle;
      this.pWJ = ((ChatFooterPanel)aa.bh(getContext()));
      this.nGK = z.iI(getContext());
      paramBundle = new FrameLayout.LayoutParams(-1, this.nGK);
      localObject = this.AZD;
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.pWJ, (ViewGroup.LayoutParams)paramBundle);
      }
      paramBundle = this.pWJ;
      if (paramBundle != null) {
        paramBundle.setPortHeightPx(this.nGK);
      }
      paramBundle = this.pWJ;
      if (paramBundle != null) {
        paramBundle.setEntranceScene(ChatFooterPanel.ESo);
      }
      paramBundle = this.pWJ;
      if (paramBundle != null) {
        paramBundle.fbF();
      }
      paramBundle = this.pWJ;
      if (paramBundle != null) {
        paramBundle.onResume();
      }
      paramBundle = this.pWJ;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.pWJ;
      if (paramBundle != null) {
        paramBundle.setShowSend(true);
      }
      paramBundle = this.pWJ;
      if (paramBundle != null) {
        paramBundle.setOnTextOperationListener((ChatFooterPanel.a)new v(this));
      }
      this.BDH = new av((av.a)new u(this), true);
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1106;
      }
      paramBundle = (Button)paramBundle.findViewById(2131297597);
      label815:
      this.BDy = paramBundle;
      paramBundle = this.BDy;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new i(this));
      }
      paramBundle = this.targetView;
      if (paramBundle == null) {
        break label1111;
      }
      paramBundle = (Button)paramBundle.findViewById(2131297598);
      label864:
      this.BDz = paramBundle;
      paramBundle = this.BDz;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new j(this));
      }
      paramBundle = this.BDy;
      if (paramBundle == null) {
        break label1116;
      }
      paramBundle = paramBundle.getPaint();
      label907:
      al.a((Paint)paramBundle, 0.8F);
      paramBundle = this.BDz;
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
      this.BCg = ((a.b)new k(this));
      paramBundle = getContext();
      p.g(paramBundle, "context");
      this.BDJ = new a(paramBundle);
      paramBundle = this.BDJ;
      if (paramBundle != null)
      {
        paramBundle.setOnDismissListener((DialogInterface.OnDismissListener)b.l.BEh);
        paramBundle.BCg = this.BCg;
      }
      this.BDK = new ap((ap.a)new m(this));
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
    a.a locala = com.tencent.mm.ck.a.IRP;
    com.tencent.mm.ck.a.wU(true);
    super.show();
    AppMethodBeat.o(102603);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "", "(Ljava/lang/String;I)V", "INPUT_NONE", "INPUT_EMOJI", "INPUT_KEYBOARD", "plugin-transvoice_release"})
  static enum b
  {
    static
    {
      AppMethodBeat.i(102558);
      b localb1 = new b("INPUT_NONE", 0);
      BDZ = localb1;
      b localb2 = new b("INPUT_EMOJI", 1);
      BEa = localb2;
      b localb3 = new b("INPUT_KEYBOARD", 2);
      BEb = localb3;
      BEc = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(102558);
    }
    
    private b() {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "", "onTransPanelClose", "", "onTxtMsgSend", "txt", "", "onVoiceMsgDelete", "fileName", "onVoiceMsgSend", "", "fileLength", "", "(Ljava/lang/String;Ljava/lang/Long;)Z", "plugin-transvoice_release"})
  public static abstract interface d
  {
    public abstract void aDg(String paramString);
    
    public abstract void aDh(String paramString);
    
    public abstract boolean b(String paramString, Long paramLong);
    
    public abstract void erI();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$1"})
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
        b.o(this.BEg);
        AppMethodBeat.o(102565);
        return true;
      }
      AppMethodBeat.o(102565);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$2"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102566);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      b.p(this.BEg).BBW = 1;
      b.r(this.BEg);
      if (b.s(this.BEg))
      {
        b.j(this.BEg, false);
        b.p(this.BEg).BBU = 0;
        b.p(this.BEg).BBQ = System.currentTimeMillis();
        paramView = b.t(this.BEg);
        if (paramView != null) {
          paramView.cancel(true);
        }
        paramView = b.u(this.BEg);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = b.v(this.BEg);
        if (paramView != null) {
          paramView.removeMessages(5000);
        }
        paramView = b.w(this.BEg);
        if (paramView != null) {
          paramView.stopTimer();
        }
        paramView = b.e(this.BEg);
        if (paramView != null) {
          paramView.setText((CharSequence)this.BEg.BDV);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102566);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-transvoice_release"})
  public static final class g
    implements TextWatcher
  {
    g(b paramb) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int i = 0;
      AppMethodBeat.i(102567);
      if ((!b.x(this.BEg)) && (b.q(this.BEg)))
      {
        b.y(this.BEg);
        b.p(this.BEg).BBV = 1;
      }
      Object localObject = b.z(this.BEg);
      if (localObject != null) {
        if (bt.ai((CharSequence)paramEditable)) {
          break label115;
        }
      }
      label115:
      for (boolean bool = true;; bool = false)
      {
        ((Button)localObject).setEnabled(bool);
        localObject = b.A(this.BEg);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "isKeyboardShow", "", "keyboardHeight", "", "onInputPanelChange"})
  static final class h
    implements TransVoicePanelLayout.a
  {
    h(b paramb) {}
    
    public final void g(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(102568);
      b.a(this.BEg, paramBoolean);
      ad.d("MicroMsg.TransVoiceDialog", "isKeyboardShow %s.", new Object[] { Boolean.valueOf(paramBoolean) });
      Object localObject;
      if (paramBoolean)
      {
        b.a(this.BEg, b.b.BEb);
        localObject = b.c(this.BEg);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState())) {
          b.a(this.BEg, b.c.BEe);
        }
        localObject = b.e(this.BEg);
        if (localObject != null) {
          ((MMEditText)localObject).setCursorVisible(true);
        }
        b.b(this.BEg, true);
        b.c(this.BEg, false);
        b.d(this.BEg, false);
        localObject = b.f(this.BEg);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(2131231701);
        }
        b.e(this.BEg, true);
      }
      for (;;)
      {
        if ((b.h(this.BEg) != paramInt) && (paramInt != 0))
        {
          b.a(this.BEg, paramInt);
          i.A(this.BEg.getContext(), paramInt);
          b.i(this.BEg);
        }
        AppMethodBeat.o(102568);
        return;
        localObject = b.c(this.BEg);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState()) && (b.b.BEa != b.b(this.BEg))) {
          b.a(this.BEg, b.c.BEd);
        }
        localObject = b.b(this.BEg);
        switch (c.cpQ[localObject.ordinal()])
        {
        case 1: 
        default: 
          break;
        case 2: 
          b.a(this.BEg, b.b.BDZ);
          if (b.c.BEe != b.d(this.BEg))
          {
            b.b(this.BEg, false);
            b.c(this.BEg, true);
            localObject = b.g(this.BEg);
            if (localObject != null) {
              ((ChatFooterPanel)localObject).setVisibility(8);
            }
            localObject = b.e(this.BEg);
            if (localObject != null) {
              ((MMEditText)localObject).setCursorVisible(false);
            }
            b.e(this.BEg, false);
          }
          break;
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102569);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.i("MicroMsg.TransVoiceDialog", "sendVoiceMsg onClick.");
      paramView = this.BEg.BDW;
      if ((paramView != null) && (true == paramView.b(this.BEg.BDD, Long.valueOf(this.BEg.BDC)))) {
        b.F(this.BEg);
      }
      b.b(this.BEg, 7);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102569);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102570);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      b.o(this.BEg);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102570);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$12", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static final class k
    implements a.b
  {
    public final void Ts(int paramInt)
    {
      AppMethodBeat.i(102571);
      Object localObject1 = b.B(this.BEg);
      if (localObject1 != null) {
        ((a)localObject1).dismiss();
      }
      b.d(this.BEg, paramInt);
      if (paramInt == b.C(this.BEg))
      {
        AppMethodBeat.o(102571);
        return;
      }
      if (ay.isConnected(this.BEg.getContext()))
      {
        localObject1 = this.BEg;
        ((b)localObject1).BDq = false;
        ((b)localObject1).BDM = false;
        ((b)localObject1).BDo.BBM = ((b)localObject1).BDp;
        ((b)localObject1).BDo.BBP = 0;
        ((b)localObject1).BDo.BBQ = 0L;
        ((b)localObject1).BDo.BBR = 0;
        ((b)localObject1).BDo.BBU = 0;
        ((b)localObject1).BDo.BBV = 0;
        ((b)localObject1).BDo.BBW = 0;
        ((b)localObject1).erH();
        localObject2 = ((b)localObject1).BDK;
        if (localObject2 != null) {
          ((ap)localObject2).sendEmptyMessageDelayed(5000, 5000L);
        }
        localObject2 = ((b)localObject1).BDH;
        if (localObject2 != null) {
          ((av)localObject2).CX(500L);
        }
        ((b)localObject1).ixK = paramInt;
        long l2 = System.nanoTime() & 0xFFFFFFFF;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = Math.abs(l2);
        }
        localObject2 = new h(String.valueOf(l1));
        h localh = ((b)localObject1).ixF;
        if (localh != null) {
          localh.a((h)localObject2);
        }
        ((b)localObject1).BDA = new com.tencent.mm.plugin.transvoice.a.b((h)localObject2, paramInt, (g.b)new b.y((b)localObject1));
        localObject1 = ((b)localObject1).BDA;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.transvoice.a.b)localObject1).start();
          AppMethodBeat.o(102571);
          return;
        }
        AppMethodBeat.o(102571);
        return;
      }
      localObject1 = new d.a(this.BEg.getContext());
      Object localObject2 = this.BEg.getContext();
      p.g(localObject2, "context");
      ((d.a)localObject1).aXG(((Context)localObject2).getResources().getString(2131755828));
      localObject2 = this.BEg.getContext();
      p.g(localObject2, "context");
      ((d.a)localObject1).aXM(((Context)localObject2).getResources().getString(2131761549));
      localObject2 = this.BEg.getContext();
      p.g(localObject2, "context");
      ((d.a)localObject1).afn(((Context)localObject2).getResources().getColor(2131099770));
      ((d.a)localObject1).fMb().show();
      AppMethodBeat.o(102571);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
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
        b.p(this.BEg).BBP = 1;
        b.p(this.BEg).BBQ = System.currentTimeMillis();
        b.p(this.BEg).BBU = 0;
        paramMessage = b.w(this.BEg);
        if (paramMessage != null) {
          paramMessage.stopTimer();
        }
        paramMessage = b.t(this.BEg);
        if (paramMessage != null) {
          paramMessage.cancel(false);
        }
        if (!bt.isNullOrNil(this.BEg.BDV))
        {
          paramMessage = b.e(this.BEg);
          if (paramMessage != null) {
            paramMessage.setFocusable(true);
          }
          paramMessage = b.e(this.BEg);
          if (paramMessage != null) {
            paramMessage.setFocusableInTouchMode(true);
          }
        }
        paramMessage = b.e(this.BEg);
        if (paramMessage != null) {
          paramMessage.setText((CharSequence)this.BEg.BDV);
        }
        paramMessage = b.u(this.BEg);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class n
    implements DialogInterface.OnDismissListener
  {
    n(b paramb) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(102574);
      ad.d("MicroMsg.TransVoiceDialog", "onDismiss.");
      if (b.G(this.BEg))
      {
        b.H(this.BEg);
        if (!bt.isNullOrNil(b.I(this.BEg)))
        {
          paramDialogInterface = this.BEg.BDW;
          if (paramDialogInterface != null) {
            paramDialogInterface.aDg(b.I(this.BEg));
          }
          b.b(this.BEg, b.I(this.BEg));
        }
      }
      AppMethodBeat.o(102574);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$2", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class o
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102576);
      p.h(paramView, "bottomSheet");
      ad.d("MicroMsg.TransVoiceDialog", "slideOffset: %f, panelDragOpeMode: %s.", new Object[] { Float.valueOf(paramFloat), b.d(this.BEg) });
      paramView = b.c(this.BEg);
      if (paramView != null)
      {
        if (paramView.getState() != 1) {
          break label305;
        }
        if (b.c.BEd == b.d(this.BEg))
        {
          paramView = this.BEg;
          if (0.7F < paramFloat) {
            break label239;
          }
          bool = true;
          b.f(paramView, bool);
          paramView = this.BEg.getWindow();
          if (paramView != null) {
            paramView.setDimAmount((float)(0.5D - (1.0F - paramFloat) / 2.0D));
          }
        }
        if (b.c.BEe != b.d(this.BEg)) {
          break label305;
        }
        paramView = this.BEg;
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
        if (b.l(this.BEg)) {
          break label305;
        }
        b.h(this.BEg, true);
        b.i(this.BEg, false);
        b.b(this.BEg, false);
        b.c(this.BEg, false);
        b.d(this.BEg, false);
        paramView = b.f(this.BEg);
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
      if (b.l(this.BEg))
      {
        b.h(this.BEg, false);
        b.i(this.BEg, true);
        b.b(this.BEg, true);
        b.c(this.BEg, false);
        b.d(this.BEg, false);
      }
      label305:
      AppMethodBeat.o(102576);
    }
    
    @SuppressLint({"SwitchIntDef"})
    public final void k(View paramView, int paramInt)
    {
      AppMethodBeat.i(102577);
      p.h(paramView, "bottomSheet");
      ad.d("MicroMsg.TransVoiceDialog", "newState: %d, panelDragOpeMode: %s, canClosePanel: %s, canHideKeyboard: %s, canCloseKeyboard: %s.", new Object[] { Integer.valueOf(paramInt), b.d(this.BEg), Boolean.valueOf(b.j(this.BEg)), Boolean.valueOf(b.l(this.BEg)), Boolean.valueOf(b.k(this.BEg)) });
      switch (paramInt)
      {
      }
      while ((1 != paramInt) && (3 != paramInt)) {
        if (!b.j(this.BEg))
        {
          paramView = this.BEg.getWindow();
          if (paramView != null) {
            paramView.setDimAmount(0.5F);
          }
          paramView = b.c(this.BEg);
          if (paramView != null)
          {
            paramView.cS();
            AppMethodBeat.o(102577);
            return;
            b.f(this.BEg, false);
            b.h(this.BEg, false);
            b.g(this.BEg, false);
            continue;
            if ((b.c.BEd == b.d(this.BEg)) && (b.j(this.BEg))) {
              b.b(this.BEg, 6);
            }
            if ((b.c.BEe == b.d(this.BEg)) && (b.l(this.BEg))) {
              if (b.k(this.BEg))
              {
                b.a(this.BEg, b.c.BEd);
                b.c(this.BEg, true);
                b.b(this.BEg, false);
                paramView = b.g(this.BEg);
                if (paramView != null) {
                  paramView.setVisibility(8);
                }
                paramView = b.e(this.BEg);
                if (paramView != null) {
                  paramView.setCursorVisible(false);
                }
                b.e(this.BEg, false);
                paramView = b.m(this.BEg);
                if (paramView != null) {
                  paramView.postDelayed((Runnable)new a(this), 200L);
                }
              }
              else
              {
                b.i(this.BEg, true);
                b.b(this.BEg, true);
                b.c(this.BEg, false);
                b.d(this.BEg, false);
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
          b.b(this.BEg, 6);
        }
      }
      AppMethodBeat.o(102577);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.o paramo) {}
      
      public final void run()
      {
        AppMethodBeat.i(102575);
        TransVoicePanelLayout localTransVoicePanelLayout = b.m(this.BEi.BEg);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$ExternalTouchHelper;", "downY", "", "getDownY", "()F", "setDownY", "(F)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onNeedJudge", "plugin-transvoice_release"})
  public static final class p
    implements MMBottomSheetBehavior.b
  {
    private float cNh;
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      Boolean localBoolean = null;
      AppMethodBeat.i(102578);
      p.h(paramMotionEvent, "event");
      p.h(paramMotionEvent, "event");
      Object localObject = b.n(this.BEg);
      int i;
      if (localObject != null)
      {
        MMEditText localMMEditText = b.e(this.BEg);
        if (localMMEditText == null) {
          p.gfZ();
        }
        if (true == ((CoordinatorLayout)localObject).d((View)localMMEditText, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          i = 1;
          if (i != 0)
          {
            localObject = b.e(this.BEg);
            if (localObject == null) {
              break label268;
            }
            localObject = Boolean.valueOf(((MMEditText)localObject).canScrollVertically(-1));
            label106:
            localMMEditText = b.e(this.BEg);
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
          this.cNh = paramMotionEvent.getY();
        }
        f = paramMotionEvent.getY() - this.cNh;
        ad.d("MicroMsg.TransVoiceDialog", "yOffset: %f.", new Object[] { Float.valueOf(f) });
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102579);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      b.b(this.BEg, 6);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102579);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102580);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      b.a(this.BEg, System.currentTimeMillis());
      paramView = b.B(this.BEg);
      if (paramView != null) {
        paramView.ixK = b.C(this.BEg);
      }
      paramView = b.B(this.BEg);
      if (paramView != null) {
        paramView.erw();
      }
      paramView = b.B(this.BEg);
      if (paramView != null) {
        paramView.show();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102580);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102581);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = b.b(this.BEg);
      switch (c.gnp[paramView.ordinal()])
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(102581);
        return;
        b.i(this.BEg, false);
        continue;
        b.a(this.BEg, b.b.BDZ);
        b.b(this.BEg, false);
        b.c(this.BEg, true);
        paramView = b.g(this.BEg);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = b.e(this.BEg);
        if (paramView != null) {
          paramView.setCursorVisible(false);
        }
        b.e(this.BEg, false);
        continue;
        b.a(this.BEg, b.b.BDZ);
        b.b(this.BEg, 6);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102582);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (b.a(this.BEg))
      {
        b.a(this.BEg, b.b.BEa);
        b.i(this.BEg, false);
        b.d(this.BEg, true);
        paramView = b.f(this.BEg);
        if (paramView != null) {
          paramView.setImageResource(2131231706);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(102582);
        return;
        b.a(this.BEg, b.b.BEb);
        b.i(this.BEg, true);
        b.d(this.BEg, false);
        paramView = b.f(this.BEg);
        if (paramView != null) {
          paramView.setImageResource(2131231701);
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class u
    implements av.a
  {
    u(b paramb) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(102583);
      int i = b.D(this.BEg);
      b localb = this.BEg;
      b.c(localb, b.D(localb) + 1);
      switch (i % 3)
      {
      }
      for (;;)
      {
        b.E(this.BEg);
        AppMethodBeat.o(102583);
        return true;
        b.a(this.BEg, "·");
        continue;
        b.a(this.BEg, "··");
        continue;
        b.a(this.BEg, "···");
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-transvoice_release"})
  public static final class v
    implements ChatFooterPanel.a
  {
    public final void aoO()
    {
      AppMethodBeat.i(102585);
      Object localObject = b.e(this.BEg);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = b.e(this.BEg);
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
    
    public final void aoP()
    {
      AppMethodBeat.i(102586);
      b.o(this.BEg);
      AppMethodBeat.o(102586);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(102584);
      MMEditText localMMEditText = b.e(this.BEg);
      if (localMMEditText != null)
      {
        localMMEditText.aXD(paramString);
        AppMethodBeat.o(102584);
        return;
      }
      AppMethodBeat.o(102584);
    }
    
    public final void dU(boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
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
        localInputMethodManager.showSoftInput((View)b.e(this.BEg), 0);
        AppMethodBeat.o(102587);
        return;
      }
      AppMethodBeat.o(102587);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class x
    implements g.b
  {
    public final void aNQ()
    {
      AppMethodBeat.i(102590);
      ad.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102590);
    }
    
    public final void aNU()
    {
      AppMethodBeat.i(102591);
      ad.i("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.BEg, false);
      b.p(this.BEg).BBU = 1;
      b.p(this.BEg).BBQ = System.currentTimeMillis();
      Object localObject = b.v(this.BEg);
      if (localObject != null) {
        ((ap)localObject).removeMessages(5000);
      }
      localObject = b.w(this.BEg);
      if (localObject != null) {
        ((av)localObject).stopTimer();
      }
      b.J(this.BEg);
      localObject = b.u(this.BEg);
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
      b.a(this.BEg, paramList);
      paramList = b.v(this.BEg);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.BEg);
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
            this.BEg.aDf(paramArrayOfString[0]);
            ad.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.BEg.BDV });
            b.p(this.BEg).BBR = this.BEg.BDV.length();
            if (b.s(this.BEg)) {
              break;
            }
            b.j(this.BEg, true);
            paramArrayOfString = b.e(this.BEg);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.BEg);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.BEg);
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
      b.p(this.BEg).BBU = 0;
      b.p(this.BEg).BBQ = System.currentTimeMillis();
      AppMethodBeat.o(102589);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$2", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class y
    implements g.b
  {
    public final void aNQ()
    {
      AppMethodBeat.i(102594);
      ad.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102594);
    }
    
    public final void aNU()
    {
      AppMethodBeat.i(102595);
      ad.d("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.BEg, false);
      b.p(this.BEg).BBU = 1;
      b.p(this.BEg).BBQ = System.currentTimeMillis();
      Object localObject = b.v(this.BEg);
      if (localObject != null) {
        ((ap)localObject).removeMessages(5000);
      }
      localObject = b.w(this.BEg);
      if (localObject != null) {
        ((av)localObject).stopTimer();
      }
      b.J(this.BEg);
      localObject = b.u(this.BEg);
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
      b.a(this.BEg, paramList);
      paramList = b.v(this.BEg);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.BEg);
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
            this.BEg.aDf(paramArrayOfString[0]);
            ad.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.BEg.BDV });
            b.p(this.BEg).BBR = this.BEg.BDV.length();
            if (b.s(this.BEg)) {
              break;
            }
            b.j(this.BEg, true);
            paramArrayOfString = b.e(this.BEg);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.BEg);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.BEg);
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
      b.p(this.BEg).BBU = 0;
      b.p(this.BEg).BBQ = System.currentTimeMillis();
      AppMethodBeat.o(102593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b
 * JD-Core Version:    0.7.0.1
 */