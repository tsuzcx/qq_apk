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
import android.support.design.widget.MMBottomSheetBehavior;
import android.support.design.widget.MMBottomSheetBehavior.a;
import android.support.design.widget.MMBottomSheetBehavior.b;
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
import androidx.appcompat.app.e;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.plugin.transvoice.a.c;
import com.tencent.mm.plugin.transvoice.a.d;
import com.tencent.mm.plugin.transvoice.a.e;
import com.tencent.mm.plugin.transvoice.a.f;
import com.tencent.mm.plugin.transvoice.a.g;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "bottomSheetCoordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "btnLayout", "canCloseKeyboard", "", "canClosePanel", "canHideKeyboard", "closeInputMethod", "Landroid/widget/ImageView;", "closePanel", "container", "Lcom/tencent/mm/modelvoiceaddr/ShortSentenceContainer;", "curTxt", "", "getCurTxt", "()Ljava/lang/String;", "setCurTxt", "(Ljava/lang/String;)V", "dotCounter", "", "dotStr", "emojiRoot", "Landroid/widget/FrameLayout;", "hasClick", "inputMethodLayout", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoicePanelLayout;", "inputMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "isEdited", "isKeyboardShown", "keyboardHeight", "langType", "languageChoiceDialog", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "mNewVoiceInputReport", "Lcom/tencent/mm/modelvoiceaddr/voicereport/NewVoiceInputReportManager;", "mVoiceIdSet", "", "needSendTxtMsg", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "overTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "panelDragOpeMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "reporter", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "sendTxtMsg", "Landroid/widget/Button;", "sendVoiceMsg", "showImeRunnable", "Ljava/lang/Runnable;", "smileyItem", "smileyOpener", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "talker", "getTalker", "setTalker", "targetView", "tmpClickChangeLangTypeTime", "", "transCancelable", "transMore", "transPanelAction", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "getTransPanelAction", "()Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "setTransPanelAction", "(Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;)V", "transSP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "txtEditView", "Lcom/tencent/mm/ui/widget/MMEditText;", "txtMsg4Send", "updateDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceAddr", "Lcom/tencent/mm/plugin/transvoice/model/SceneVoiceInputAddr2;", "value", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "voiceLen", "getVoiceLen", "()J", "setVoiceLen", "(J)V", "voiceMsgSend", "cgiReport", "", "msg", "closeInputMethodBtnVisibility", "visible", "closeTransPanel", "exitType", "delPunctuation", "getContentTxt", "init", "initSmileyPanel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshBottomPanelHeight", "resetTransPanel", "saveTransLangTypeByTalker", "type", "setBottomBtnVisibility", "setKeyboardVisibility", "setSmileyItemVisibility", "setSmileyPanelVisibility", "show", "startTrans", "updateCurTxt", "updateTransLangTypeByTalker", "Companion", "InputMode", "PanelDragOpeMode", "TransPanelAction", "plugin-transvoice_release"})
public final class b
  extends e
{
  public static int Nju;
  public static final a Njv;
  private FrameLayout LVS;
  private boolean LVZ;
  private MMBottomSheetBehavior<View> NhB;
  private boolean NhC;
  private a.b NhD;
  private ImageView Nhy;
  final c NiL;
  long NiM;
  boolean NiN;
  private TransVoicePanelLayout NiO;
  private MMEditText NiP;
  private ImageView NiQ;
  private ImageView NiR;
  private View NiS;
  private View NiT;
  private ImageView NiU;
  private Button NiV;
  private Button NiW;
  com.tencent.mm.plugin.transvoice.a.b NiX;
  private b NiY;
  public long NiZ;
  String Nja;
  private boolean Njb;
  private String Njc;
  private int Njd;
  MTimerHandler Nje;
  private boolean Njf;
  private a Njg;
  MMHandler Njh;
  private SharedPreferences Nji;
  boolean Njj;
  private CoordinatorLayout Njk;
  private c Njl;
  private boolean Njm;
  private boolean Njn;
  private boolean Njo;
  private String Njp;
  private final com.tencent.mm.modelvoiceaddr.b.b Njq;
  private List<String> Njr;
  String Njs;
  public d Njt;
  private ChatFooterPanel jPN;
  private View kJL;
  h mlq;
  int mlv;
  private int pIk;
  public String talker;
  private final Runnable vao;
  
  static
  {
    AppMethodBeat.i(102605);
    Njv = new a((byte)0);
    Nju = -1;
    AppMethodBeat.o(102605);
  }
  
  public b(final Context paramContext)
  {
    super(paramContext, a.g.TransDialog);
    AppMethodBeat.i(102604);
    c.a locala = c.Nhv;
    this.NiL = c.gsv();
    this.mlv = g.mlT;
    this.NiY = b.Njw;
    this.Njc = "";
    this.Nji = paramContext.getSharedPreferences("voice2txt_sp", 0);
    this.Njl = c.NjA;
    this.Njp = "";
    bb();
    this.Njq = new com.tencent.mm.modelvoiceaddr.b.b();
    this.vao = ((Runnable)new w(this, paramContext));
    this.Njs = "";
    AppMethodBeat.o(102604);
  }
  
  private final void An(boolean paramBoolean)
  {
    AppMethodBeat.i(102598);
    if (paramBoolean)
    {
      localImageView = this.NiQ;
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        AppMethodBeat.o(102598);
        return;
      }
      AppMethodBeat.o(102598);
      return;
    }
    ImageView localImageView = this.NiQ;
    if (localImageView != null)
    {
      localImageView.setVisibility(0);
      AppMethodBeat.o(102598);
      return;
    }
    AppMethodBeat.o(102598);
  }
  
  private final void akc(int paramInt)
  {
    AppMethodBeat.i(102600);
    if (isShowing())
    {
      this.NiL.setExitType(paramInt);
      gsI();
      dismiss();
      d locald = this.Njt;
      if (locald != null) {
        locald.gsJ();
      }
      if (!this.Njb)
      {
        locald = this.Njt;
        if (locald != null) {
          locald.bfo(this.Nja);
        }
      }
      this.Njb = false;
    }
    AppMethodBeat.o(102600);
  }
  
  private final void setKeyboardVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(102599);
    Log.d("MicroMsg.TransVoiceDialog", "setKeyboardVisibility, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      localObject = this.kJL;
      if (localObject != null) {
        ((View)localObject).removeCallbacks(this.vao);
      }
      localObject = this.kJL;
      if (localObject != null)
      {
        ((View)localObject).post(this.vao);
        AppMethodBeat.o(102599);
        return;
      }
      AppMethodBeat.o(102599);
      return;
    }
    Object localObject = this.kJL;
    if (localObject != null) {
      ((View)localObject).removeCallbacks(this.vao);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localObject = this.NiP;
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
  
  public final void bfl(String paramString)
  {
    AppMethodBeat.i(185255);
    if (!Util.isNullOrNil(paramString))
    {
      this.Nja = paramString;
      com.tencent.mm.cq.a.a locala = com.tencent.mm.cq.a.VPo;
      if (paramString == null) {
        p.iCn();
      }
      p.k(paramString, "<set-?>");
      com.tencent.mm.cq.a.byf(paramString);
    }
    AppMethodBeat.o(185255);
  }
  
  public final void bfm(String paramString)
  {
    AppMethodBeat.i(102602);
    p.k(paramString, "<set-?>");
    this.Njs = paramString;
    AppMethodBeat.o(102602);
  }
  
  public final void c(h paramh)
  {
    AppMethodBeat.i(185256);
    p.k(paramh, "container");
    Object localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).setDimAmount(0.5F);
    }
    localObject = this.NhB;
    if (localObject != null) {
      ((MMBottomSheetBehavior)localObject).T();
    }
    this.NiN = false;
    this.Njj = false;
    int i = this.Nji.getInt(this.talker, 0);
    localObject = this.Njg;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((a)localObject).Nhz;
    if (localObject == null) {
      p.iCn();
    }
    if (((ArrayList)localObject).contains(Integer.valueOf(i))) {
      this.mlv = i;
    }
    for (;;)
    {
      this.NiL.Nhk = this.mlv;
      gsI();
      localObject = this.Njh;
      if (localObject != null) {
        ((MMHandler)localObject).sendEmptyMessageDelayed(5000, 5000L);
      }
      localObject = this.Nje;
      if (localObject != null) {
        ((MTimerHandler)localObject).startTimer(500L);
      }
      this.mlq = paramh;
      this.NiX = new com.tencent.mm.plugin.transvoice.a.b(paramh, this.mlv, (g.b)new x(this));
      paramh = this.NiX;
      if (paramh == null) {
        break;
      }
      paramh.start();
      AppMethodBeat.o(185256);
      return;
      localObject = this.Njg;
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((a)localObject).Nhz;
      if (localObject == null) {
        p.iCn();
      }
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = this.Njg;
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((a)localObject).Nhz;
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((ArrayList)localObject).get(0);
        p.j(localObject, "languageChoiceDialog!!.langTypeArr!![0]");
        this.mlv = ((Number)localObject).intValue();
      }
      else
      {
        localObject = LocaleUtil.getCurrentLanguage(getContext());
        if ((p.h(localObject, "zh_CN")) || (p.h(localObject, "zh_HK")) || (p.h(localObject, "zh_TW"))) {
          this.mlv = g.mlT;
        } else if (p.h(localObject, "en")) {
          this.mlv = g.mlV;
        }
      }
    }
    AppMethodBeat.o(185256);
  }
  
  final void gsI()
  {
    AppMethodBeat.i(102601);
    this.Njs = "";
    this.Njd = 0;
    this.Njc = "";
    this.Njf = false;
    Object localObject = this.NiP;
    if (localObject != null) {
      ((MMEditText)localObject).setText((CharSequence)"");
    }
    localObject = this.NiP;
    if (localObject != null) {
      ((MMEditText)localObject).setCursorVisible(false);
    }
    localObject = this.NiP;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusable(false);
    }
    localObject = this.NiP;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusableInTouchMode(false);
    }
    localObject = this.NiS;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.NiT;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    setKeyboardVisibility(false);
    localObject = this.jPN;
    if (localObject != null) {
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    An(false);
    localObject = this.Njh;
    if (localObject != null) {
      ((MMHandler)localObject).removeMessages(5000);
    }
    this.Njl = c.NjA;
    this.NhC = false;
    this.Njm = false;
    this.Njn = false;
    AppMethodBeat.o(102601);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(102597);
    akc(6);
    super.onBackPressed();
    AppMethodBeat.o(102597);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102596);
    this.kJL = LayoutInflater.from(getContext()).inflate(a.e.NgL, null, false);
    Object localObject = new ViewGroup.LayoutParams(-1, -1);
    View localView = this.kJL;
    if (localView == null) {
      p.iCn();
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
      paramBundle.setWindowAnimations(a.g.BottomToTopSlowAnimation);
    }
    paramBundle = this.kJL;
    if (paramBundle != null)
    {
      paramBundle = (TransVoicePanelLayout)paramBundle.findViewById(a.d.Ngq);
      this.NiO = paramBundle;
      paramBundle = this.NiO;
      if (paramBundle != null) {
        paramBundle.setOnInputPanelChange((TransVoicePanelLayout.a)new h(this));
      }
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1065;
      }
      paramBundle = (CoordinatorLayout)paramBundle.findViewById(a.d.Ngk);
      label169:
      this.Njk = paramBundle;
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1070;
      }
      paramBundle = paramBundle.findViewById(a.d.NgC);
      label191:
      this.NhB = MMBottomSheetBehavior.c(paramBundle);
      paramBundle = this.NhB;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new o(this));
      }
      paramBundle = this.NhB;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.b)new p(this));
      }
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1075;
      }
      paramBundle = (MMEditText)paramBundle.findViewById(a.d.NgF);
      label267:
      this.NiP = paramBundle;
      paramBundle = this.NiP;
      if (paramBundle != null)
      {
        paramBundle.setCursorVisible(false);
        paramBundle.setOnEditorActionListener((TextView.OnEditorActionListener)new e(this));
        paramBundle.setMaxLines(2147483647);
        paramBundle.setHorizontallyScrolling(false);
        paramBundle.setOnClickListener((View.OnClickListener)new f(this));
        paramBundle.addTextChangedListener((TextWatcher)new g(this));
      }
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1080;
      }
      paramBundle = (ImageView)paramBundle.findViewById(a.d.Ngo);
      label363:
      this.Nhy = paramBundle;
      paramBundle = this.Nhy;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new q(this));
      }
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1085;
      }
      paramBundle = (ImageView)paramBundle.findViewById(a.d.NgG);
      label412:
      this.NiQ = paramBundle;
      paramBundle = this.NiQ;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new r(this));
      }
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1090;
      }
      paramBundle = (ImageView)paramBundle.findViewById(a.d.Ngn);
      label461:
      this.NiR = paramBundle;
      paramBundle = this.NiR;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new s(this));
      }
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1095;
      }
      paramBundle = paramBundle.findViewById(a.d.NgB);
      label507:
      this.NiS = paramBundle;
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1100;
      }
      paramBundle = paramBundle.findViewById(a.d.NgD);
      label529:
      this.NiT = paramBundle;
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1105;
      }
      paramBundle = (ImageView)paramBundle.findViewById(a.d.NgE);
      label554:
      this.NiU = paramBundle;
      paramBundle = this.NiU;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new t(this));
      }
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1110;
      }
      paramBundle = (FrameLayout)paramBundle.findViewById(a.d.Ngp);
      label603:
      this.LVS = paramBundle;
      this.jPN = ((ChatFooterPanel)ad.bB(getContext()));
      this.pIk = KeyBoardUtil.getValidPanelHeight(getContext());
      paramBundle = new FrameLayout.LayoutParams(-1, this.pIk);
      localObject = this.LVS;
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.jPN, (ViewGroup.LayoutParams)paramBundle);
      }
      paramBundle = this.jPN;
      if (paramBundle != null) {
        paramBundle.setPortHeightPx(this.pIk);
      }
      paramBundle = this.jPN;
      if (paramBundle != null) {
        paramBundle.setEntranceScene(ChatFooterPanel.Rcg);
      }
      paramBundle = this.jPN;
      if (paramBundle != null) {
        paramBundle.hjp();
      }
      paramBundle = this.jPN;
      if (paramBundle != null) {
        paramBundle.onResume();
      }
      paramBundle = this.jPN;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.jPN;
      if (paramBundle != null) {
        paramBundle.setShowSend(true);
      }
      paramBundle = this.jPN;
      if (paramBundle != null) {
        paramBundle.setOnTextOperationListener((ChatFooterPanel.a)new v(this));
      }
      this.Nje = new MTimerHandler((MTimerHandler.CallBack)new u(this), true);
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1115;
      }
      paramBundle = (Button)paramBundle.findViewById(a.d.Ngl);
      label824:
      this.NiV = paramBundle;
      paramBundle = this.NiV;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new i(this));
      }
      paramBundle = this.kJL;
      if (paramBundle == null) {
        break label1120;
      }
      paramBundle = (Button)paramBundle.findViewById(a.d.Ngm);
      label873:
      this.NiW = paramBundle;
      paramBundle = this.NiW;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new j(this));
      }
      paramBundle = this.NiV;
      if (paramBundle == null) {
        break label1125;
      }
      paramBundle = paramBundle.getPaint();
      label916:
      ar.a((Paint)paramBundle, 0.8F);
      paramBundle = this.NiW;
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
      ar.a((Paint)paramBundle, 0.8F);
      this.NhD = ((a.b)new k(this));
      paramBundle = getContext();
      p.j(paramBundle, "context");
      this.Njg = new a(paramBundle);
      paramBundle = this.Njg;
      if (paramBundle != null)
      {
        paramBundle.setOnDismissListener((DialogInterface.OnDismissListener)b.l.NjE);
        paramBundle.NhD = this.NhD;
      }
      this.Njh = new MMHandler((MMHandler.Callback)new m(this));
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
    com.tencent.mm.cq.a.a locala = com.tencent.mm.cq.a.VPo;
    com.tencent.mm.cq.a.Ff(true);
    super.show();
    AppMethodBeat.o(102603);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$Companion;", "", "()V", "MODE_ONLY_PANEL_CLOSE_PANEL_OFFSET", "", "MODE_WITH_KEYBOARD_CLOSE_KEYBOARD_OFFSET", "MODE_WITH_KEYBOARD_HIDE_KEYBOARD_OFFSET", "OVERTIME_INTERVAL", "", "OVERTIME_MSG", "", "SP_NAME", "", "TAG", "UPDATE_DOT_STR_INTERVAL", "trans2txt_cmd", "trans2txt_cmd_close", "trans2txt_cmd_invalid", "trans2txt_cmd_open", "plugin-transvoice_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "", "(Ljava/lang/String;I)V", "INPUT_NONE", "INPUT_EMOJI", "INPUT_KEYBOARD", "plugin-transvoice_release"})
  static enum b
  {
    static
    {
      AppMethodBeat.i(102558);
      b localb1 = new b("INPUT_NONE", 0);
      Njw = localb1;
      b localb2 = new b("INPUT_EMOJI", 1);
      Njx = localb2;
      b localb3 = new b("INPUT_KEYBOARD", 2);
      Njy = localb3;
      Njz = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(102558);
    }
    
    private b() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "", "(Ljava/lang/String;I)V", "MODE_ONLY_PANEL", "MODE_WITH_KEYBOARD", "plugin-transvoice_release"})
  static enum c
  {
    static
    {
      AppMethodBeat.i(102561);
      c localc1 = new c("MODE_ONLY_PANEL", 0);
      NjA = localc1;
      c localc2 = new c("MODE_WITH_KEYBOARD", 1);
      NjB = localc2;
      NjC = new c[] { localc1, localc2 };
      AppMethodBeat.o(102561);
    }
    
    private c() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "", "onTransPanelClose", "", "onTxtMsgSend", "txt", "", "onVoiceMsgDelete", "fileName", "onVoiceMsgSend", "", "fileLength", "", "(Ljava/lang/String;Ljava/lang/Long;)Z", "plugin-transvoice_release"})
  public static abstract interface d
  {
    public abstract void bfn(String paramString);
    
    public abstract void bfo(String paramString);
    
    public abstract boolean d(String paramString, Long paramLong);
    
    public abstract void gsJ();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$1"})
  static final class e
    implements TextView.OnEditorActionListener
  {
    e(b paramb) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(102565);
      if (4 != paramInt)
      {
        p.j(paramKeyEvent, "event");
        if (66 != paramKeyEvent.getAction()) {}
      }
      else
      {
        b.o(this.NjD);
        AppMethodBeat.o(102565);
        return true;
      }
      AppMethodBeat.o(102565);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$2"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102566);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.p(this.NjD).Nht = 1;
      b.r(this.NjD);
      if (b.s(this.NjD))
      {
        b.j(this.NjD, false);
        b.p(this.NjD).Nhr = 0;
        b.p(this.NjD).Nhn = System.currentTimeMillis();
        paramView = b.t(this.NjD);
        if (paramView != null) {
          paramView.cancel(true);
        }
        paramView = b.u(this.NjD);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = b.v(this.NjD);
        if (paramView != null) {
          paramView.removeMessages(5000);
        }
        paramView = b.w(this.NjD);
        if (paramView != null) {
          paramView.stopTimer();
        }
        paramView = b.e(this.NjD);
        if (paramView != null) {
          paramView.setText((CharSequence)this.NjD.Njs);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102566);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-transvoice_release"})
  public static final class g
    implements TextWatcher
  {
    g(b paramb) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int i = 0;
      AppMethodBeat.i(102567);
      if ((!b.x(this.NjD)) && (b.q(this.NjD)))
      {
        b.y(this.NjD);
        b.p(this.NjD).Nhs = 1;
      }
      Object localObject = b.z(this.NjD);
      if (localObject != null) {
        if (Util.isNullOrNil((CharSequence)paramEditable)) {
          break label115;
        }
      }
      label115:
      for (boolean bool = true;; bool = false)
      {
        ((Button)localObject).setEnabled(bool);
        localObject = b.A(this.NjD);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isKeyboardShow", "", "keyboardHeight", "", "onInputPanelChange"})
  static final class h
    implements TransVoicePanelLayout.a
  {
    h(b paramb) {}
    
    public final void h(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(102568);
      b.a(this.NjD, paramBoolean);
      Log.d("MicroMsg.TransVoiceDialog", "isKeyboardShow %s.", new Object[] { Boolean.valueOf(paramBoolean) });
      Object localObject;
      if (paramBoolean)
      {
        b.a(this.NjD, b.b.Njy);
        localObject = b.c(this.NjD);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState())) {
          b.a(this.NjD, b.c.NjB);
        }
        localObject = b.e(this.NjD);
        if (localObject != null) {
          ((MMEditText)localObject).setCursorVisible(true);
        }
        b.b(this.NjD, true);
        b.c(this.NjD, false);
        b.d(this.NjD, false);
        localObject = b.f(this.NjD);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(a.c.chatting_setmode_biaoqing_btn);
        }
        b.e(this.NjD, true);
      }
      for (;;)
      {
        if ((b.h(this.NjD) != paramInt) && (paramInt != 0))
        {
          b.a(this.NjD, paramInt);
          i.E(this.NjD.getContext(), paramInt);
          b.i(this.NjD);
        }
        AppMethodBeat.o(102568);
        return;
        localObject = b.c(this.NjD);
        if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).getState()) && (b.b.Njx != b.b(this.NjD))) {
          b.a(this.NjD, b.c.NjA);
        }
        localObject = b.b(this.NjD);
        switch (c.$EnumSwitchMapping$0[localObject.ordinal()])
        {
        case 1: 
        default: 
          break;
        case 2: 
          b.a(this.NjD, b.b.Njw);
          if (b.c.NjB != b.d(this.NjD))
          {
            b.b(this.NjD, false);
            b.c(this.NjD, true);
            localObject = b.g(this.NjD);
            if (localObject != null) {
              ((ChatFooterPanel)localObject).setVisibility(8);
            }
            localObject = b.e(this.NjD);
            if (localObject != null) {
              ((MMEditText)localObject).setCursorVisible(false);
            }
            b.e(this.NjD, false);
          }
          break;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102569);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("MicroMsg.TransVoiceDialog", "sendVoiceMsg onClick.");
      paramView = this.NjD.Njt;
      if ((paramView != null) && (true == paramView.d(this.NjD.Nja, Long.valueOf(this.NjD.NiZ)))) {
        b.F(this.NjD);
      }
      b.b(this.NjD, 7);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102569);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102570);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.o(this.NjD);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102570);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$12", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static final class k
    implements a.b
  {
    public final void ajW(int paramInt)
    {
      AppMethodBeat.i(102571);
      Object localObject1 = b.B(this.NjD);
      if (localObject1 != null) {
        ((a)localObject1).dismiss();
      }
      b.d(this.NjD, paramInt);
      if (paramInt == b.C(this.NjD))
      {
        AppMethodBeat.o(102571);
        return;
      }
      if (NetStatusUtil.isConnected(this.NjD.getContext()))
      {
        localObject1 = this.NjD;
        ((b)localObject1).NiN = false;
        ((b)localObject1).Njj = false;
        ((b)localObject1).NiL.Nhj = ((b)localObject1).NiM;
        ((b)localObject1).NiL.Nhm = 0;
        ((b)localObject1).NiL.Nhn = 0L;
        ((b)localObject1).NiL.Nho = 0;
        ((b)localObject1).NiL.Nhr = 0;
        ((b)localObject1).NiL.Nhs = 0;
        ((b)localObject1).NiL.Nht = 0;
        ((b)localObject1).gsI();
        localObject2 = ((b)localObject1).Njh;
        if (localObject2 != null) {
          ((MMHandler)localObject2).sendEmptyMessageDelayed(5000, 5000L);
        }
        localObject2 = ((b)localObject1).Nje;
        if (localObject2 != null) {
          ((MTimerHandler)localObject2).startTimer(500L);
        }
        ((b)localObject1).mlv = paramInt;
        long l2 = System.nanoTime() & 0xFFFFFFFF;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = Math.abs(l2);
        }
        localObject2 = new h(String.valueOf(l1));
        h localh = ((b)localObject1).mlq;
        if (localh != null) {
          localh.a((h)localObject2);
        }
        ((b)localObject1).NiX = new com.tencent.mm.plugin.transvoice.a.b((h)localObject2, paramInt, (g.b)new b.y((b)localObject1));
        localObject1 = ((b)localObject1).NiX;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.transvoice.a.b)localObject1).start();
          AppMethodBeat.o(102571);
          return;
        }
        AppMethodBeat.o(102571);
        return;
      }
      localObject1 = new d.a(this.NjD.getContext());
      Object localObject2 = this.NjD.getContext();
      p.j(localObject2, "context");
      ((d.a)localObject1).bBd(((Context)localObject2).getResources().getString(a.f.app_network_unavailable));
      localObject2 = this.NjD.getContext();
      p.j(localObject2, "context");
      ((d.a)localObject1).bBj(((Context)localObject2).getResources().getString(a.f.eMu));
      localObject2 = this.NjD.getContext();
      p.j(localObject2, "context");
      ((d.a)localObject1).ayl(((Context)localObject2).getResources().getColor(com.tencent.mm.plugin.transvoice.a.a.Link_100));
      ((d.a)localObject1).icu().show();
      AppMethodBeat.o(102571);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
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
        b.p(this.NjD).Nhm = 1;
        b.p(this.NjD).Nhn = System.currentTimeMillis();
        b.p(this.NjD).Nhr = 0;
        paramMessage = b.w(this.NjD);
        if (paramMessage != null) {
          paramMessage.stopTimer();
        }
        paramMessage = b.t(this.NjD);
        if (paramMessage != null) {
          paramMessage.cancel(false);
        }
        if (!Util.isNullOrNil(this.NjD.Njs))
        {
          paramMessage = b.e(this.NjD);
          if (paramMessage != null) {
            paramMessage.setFocusable(true);
          }
          paramMessage = b.e(this.NjD);
          if (paramMessage != null) {
            paramMessage.setFocusableInTouchMode(true);
          }
        }
        paramMessage = b.e(this.NjD);
        if (paramMessage != null) {
          paramMessage.setText((CharSequence)this.NjD.Njs);
        }
        paramMessage = b.u(this.NjD);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class n
    implements DialogInterface.OnDismissListener
  {
    n(b paramb) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(102574);
      Log.d("MicroMsg.TransVoiceDialog", "onDismiss.");
      if (b.G(this.NjD))
      {
        b.H(this.NjD);
        if (!Util.isNullOrNil(b.I(this.NjD)))
        {
          paramDialogInterface = this.NjD.Njt;
          if (paramDialogInterface != null) {
            paramDialogInterface.bfn(b.I(this.NjD));
          }
          b.b(this.NjD, b.I(this.NjD));
        }
      }
      AppMethodBeat.o(102574);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$2", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class o
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102576);
      p.k(paramView, "bottomSheet");
      Log.d("MicroMsg.TransVoiceDialog", "slideOffset: %f, panelDragOpeMode: %s.", new Object[] { Float.valueOf(paramFloat), b.d(this.NjD) });
      paramView = b.c(this.NjD);
      if (paramView != null)
      {
        if (paramView.getState() != 1) {
          break label306;
        }
        if (b.c.NjA == b.d(this.NjD))
        {
          paramView = this.NjD;
          if (0.7F < paramFloat) {
            break label240;
          }
          bool = true;
          b.f(paramView, bool);
          paramView = this.NjD.getWindow();
          if (paramView != null) {
            paramView.setDimAmount((float)(0.5D - (1.0F - paramFloat) / 2.0D));
          }
        }
        if (b.c.NjB != b.d(this.NjD)) {
          break label306;
        }
        paramView = this.NjD;
        if (0.8F < paramFloat) {
          break label245;
        }
      }
      label240:
      label245:
      for (boolean bool = true;; bool = false)
      {
        b.g(paramView, bool);
        if (0.9F < paramFloat) {
          break label256;
        }
        if (b.l(this.NjD)) {
          break label306;
        }
        b.h(this.NjD, true);
        b.i(this.NjD, false);
        b.b(this.NjD, false);
        b.c(this.NjD, false);
        b.d(this.NjD, false);
        paramView = b.f(this.NjD);
        if (paramView == null) {
          break label250;
        }
        paramView.setImageResource(a.c.chatting_setmode_biaoqing_btn);
        AppMethodBeat.o(102576);
        return;
        AppMethodBeat.o(102576);
        return;
        bool = false;
        break;
      }
      label250:
      AppMethodBeat.o(102576);
      return;
      label256:
      if (b.l(this.NjD))
      {
        b.h(this.NjD, false);
        b.i(this.NjD, true);
        b.b(this.NjD, true);
        b.c(this.NjD, false);
        b.d(this.NjD, false);
      }
      label306:
      AppMethodBeat.o(102576);
    }
    
    @SuppressLint({"SwitchIntDef"})
    public final void e(View paramView, int paramInt)
    {
      AppMethodBeat.i(102577);
      p.k(paramView, "bottomSheet");
      Log.d("MicroMsg.TransVoiceDialog", "newState: %d, panelDragOpeMode: %s, canClosePanel: %s, canHideKeyboard: %s, canCloseKeyboard: %s.", new Object[] { Integer.valueOf(paramInt), b.d(this.NjD), Boolean.valueOf(b.j(this.NjD)), Boolean.valueOf(b.l(this.NjD)), Boolean.valueOf(b.k(this.NjD)) });
      switch (paramInt)
      {
      }
      while ((1 != paramInt) && (3 != paramInt)) {
        if (!b.j(this.NjD))
        {
          paramView = this.NjD.getWindow();
          if (paramView != null) {
            paramView.setDimAmount(0.5F);
          }
          paramView = b.c(this.NjD);
          if (paramView != null)
          {
            paramView.T();
            AppMethodBeat.o(102577);
            return;
            b.f(this.NjD, false);
            b.h(this.NjD, false);
            b.g(this.NjD, false);
            continue;
            if ((b.c.NjA == b.d(this.NjD)) && (b.j(this.NjD))) {
              b.b(this.NjD, 6);
            }
            if ((b.c.NjB == b.d(this.NjD)) && (b.l(this.NjD))) {
              if (b.k(this.NjD))
              {
                b.a(this.NjD, b.c.NjA);
                b.c(this.NjD, true);
                b.b(this.NjD, false);
                paramView = b.g(this.NjD);
                if (paramView != null) {
                  paramView.setVisibility(8);
                }
                paramView = b.e(this.NjD);
                if (paramView != null) {
                  paramView.setCursorVisible(false);
                }
                b.e(this.NjD, false);
                paramView = b.m(this.NjD);
                if (paramView != null) {
                  paramView.postDelayed((Runnable)new a(this), 200L);
                }
              }
              else
              {
                b.i(this.NjD, true);
                b.b(this.NjD, true);
                b.c(this.NjD, false);
                b.d(this.NjD, false);
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
          b.b(this.NjD, 6);
        }
      }
      AppMethodBeat.o(102577);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.o paramo) {}
      
      public final void run()
      {
        AppMethodBeat.i(102575);
        TransVoicePanelLayout localTransVoicePanelLayout = b.m(this.NjF.NjD);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$ExternalTouchHelper;", "downY", "", "getDownY", "()F", "setDownY", "(F)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onNeedJudge", "plugin-transvoice_release"})
  public static final class p
    implements MMBottomSheetBehavior.b
  {
    private float diu;
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      Boolean localBoolean = null;
      AppMethodBeat.i(102578);
      p.k(paramMotionEvent, "event");
      p.k(paramMotionEvent, "event");
      Object localObject = b.n(this.NjD);
      int i;
      if (localObject != null)
      {
        MMEditText localMMEditText = b.e(this.NjD);
        if (localMMEditText == null) {
          p.iCn();
        }
        if (true == ((CoordinatorLayout)localObject).d((View)localMMEditText, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          i = 1;
          if (i != 0)
          {
            localObject = b.e(this.NjD);
            if (localObject == null) {
              break label268;
            }
            localObject = Boolean.valueOf(((MMEditText)localObject).canScrollVertically(-1));
            label106:
            localMMEditText = b.e(this.NjD);
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
          this.diu = paramMotionEvent.getY();
        }
        f = paramMotionEvent.getY() - this.diu;
        Log.d("MicroMsg.TransVoiceDialog", "yOffset: %f.", new Object[] { Float.valueOf(f) });
        if (f > 0.0F)
        {
          bool = p.h(Boolean.TRUE, localObject);
          AppMethodBeat.o(102578);
          return bool;
        }
      } while (f >= 0.0F);
      boolean bool = p.h(Boolean.TRUE, localBoolean);
      AppMethodBeat.o(102578);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102579);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.b(this.NjD, 6);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102579);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102580);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.a(this.NjD, System.currentTimeMillis());
      paramView = b.B(this.NjD);
      if (paramView != null) {
        paramView.mlv = b.C(this.NjD);
      }
      paramView = b.B(this.NjD);
      if (paramView != null) {
        paramView.gsx();
      }
      paramView = b.B(this.NjD);
      if (paramView != null) {
        paramView.show();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102580);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102581);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = b.b(this.NjD);
      switch (c.jLJ[paramView.ordinal()])
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(102581);
        return;
        b.i(this.NjD, false);
        continue;
        b.a(this.NjD, b.b.Njw);
        b.b(this.NjD, false);
        b.c(this.NjD, true);
        paramView = b.g(this.NjD);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = b.e(this.NjD);
        if (paramView != null) {
          paramView.setCursorVisible(false);
        }
        b.e(this.NjD, false);
        continue;
        b.a(this.NjD, b.b.Njw);
        b.b(this.NjD, 6);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102582);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (b.a(this.NjD))
      {
        b.a(this.NjD, b.b.Njx);
        b.i(this.NjD, false);
        b.d(this.NjD, true);
        paramView = b.f(this.NjD);
        if (paramView != null) {
          paramView.setImageResource(a.c.chatting_setmode_keyboard_btn);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(102582);
        return;
        b.a(this.NjD, b.b.Njy);
        b.i(this.NjD, true);
        b.d(this.NjD, false);
        paramView = b.f(this.NjD);
        if (paramView != null) {
          paramView.setImageResource(a.c.chatting_setmode_biaoqing_btn);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class u
    implements MTimerHandler.CallBack
  {
    u(b paramb) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(102583);
      int i = b.D(this.NjD);
      b localb = this.NjD;
      b.c(localb, b.D(localb) + 1);
      switch (i % 3)
      {
      }
      for (;;)
      {
        b.E(this.NjD);
        AppMethodBeat.o(102583);
        return true;
        b.a(this.NjD, "·");
        continue;
        b.a(this.NjD, "··");
        continue;
        b.a(this.NjD, "···");
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-transvoice_release"})
  public static final class v
    implements ChatFooterPanel.a
  {
    public final void aDN()
    {
      AppMethodBeat.i(102586);
      b.o(this.NjD);
      AppMethodBeat.o(102586);
    }
    
    public final void aDO()
    {
      AppMethodBeat.i(102585);
      Object localObject = b.e(this.NjD);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = b.e(this.NjD);
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
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(102584);
      MMEditText localMMEditText = b.e(this.NjD);
      if (localMMEditText != null)
      {
        localMMEditText.bBa(paramString);
        AppMethodBeat.o(102584);
        return;
      }
      AppMethodBeat.o(102584);
    }
    
    public final void eE(boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
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
        localInputMethodManager.showSoftInput((View)b.e(this.NjD), 0);
        AppMethodBeat.o(102587);
        return;
      }
      AppMethodBeat.o(102587);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class x
    implements g.b
  {
    public final void b(String[] paramArrayOfString, List<String> paramList)
    {
      AppMethodBeat.i(102588);
      Log.i("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.NjD, paramList);
      paramList = b.v(this.NjD);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.NjD);
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
            this.NjD.bfm(paramArrayOfString[0]);
            Log.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.NjD.Njs });
            b.p(this.NjD).Nho = this.NjD.Njs.length();
            if (b.s(this.NjD)) {
              break;
            }
            b.j(this.NjD, true);
            paramArrayOfString = b.e(this.NjD);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.NjD);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.NjD);
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
    
    public final void brT()
    {
      AppMethodBeat.i(102590);
      Log.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102590);
    }
    
    public final void brX()
    {
      AppMethodBeat.i(102591);
      Log.i("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.NjD, false);
      b.p(this.NjD).Nhr = 1;
      b.p(this.NjD).Nhn = System.currentTimeMillis();
      Object localObject = b.v(this.NjD);
      if (localObject != null) {
        ((MMHandler)localObject).removeMessages(5000);
      }
      localObject = b.w(this.NjD);
      if (localObject != null) {
        ((MTimerHandler)localObject).stopTimer();
      }
      b.J(this.NjD);
      localObject = b.u(this.NjD);
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
      b.p(this.NjD).Nhr = 0;
      b.p(this.NjD).Nhn = System.currentTimeMillis();
      AppMethodBeat.o(102589);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$2", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
  public static final class y
    implements g.b
  {
    public final void b(String[] paramArrayOfString, List<String> paramList)
    {
      AppMethodBeat.i(102592);
      Log.d("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.NjD, paramList);
      paramList = b.v(this.NjD);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.v(this.NjD);
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
            this.NjD.bfm(paramArrayOfString[0]);
            Log.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.NjD.Njs });
            b.p(this.NjD).Nho = this.NjD.Njs.length();
            if (b.s(this.NjD)) {
              break;
            }
            b.j(this.NjD, true);
            paramArrayOfString = b.e(this.NjD);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.e(this.NjD);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.e(this.NjD);
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
    
    public final void brT()
    {
      AppMethodBeat.i(102594);
      Log.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102594);
    }
    
    public final void brX()
    {
      AppMethodBeat.i(102595);
      Log.d("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.j(this.NjD, false);
      b.p(this.NjD).Nhr = 1;
      b.p(this.NjD).Nhn = System.currentTimeMillis();
      Object localObject = b.v(this.NjD);
      if (localObject != null) {
        ((MMHandler)localObject).removeMessages(5000);
      }
      localObject = b.w(this.NjD);
      if (localObject != null) {
        ((MTimerHandler)localObject).stopTimer();
      }
      b.J(this.NjD);
      localObject = b.u(this.NjD);
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
      b.p(this.NjD).Nhr = 0;
      b.p(this.NjD).Nhn = System.currentTimeMillis();
      AppMethodBeat.o(102593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b
 * JD-Core Version:    0.7.0.1
 */