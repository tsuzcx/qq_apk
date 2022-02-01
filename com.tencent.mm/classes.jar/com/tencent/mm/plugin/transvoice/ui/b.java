package com.tencent.mm.plugin.transvoice.ui;

import android.content.Context;
import android.content.DialogInterface;
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
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ae;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.plugin.transvoice.a.c;
import com.tencent.mm.plugin.transvoice.a.d;
import com.tencent.mm.plugin.transvoice.a.e;
import com.tencent.mm.plugin.transvoice.a.f;
import com.tencent.mm.plugin.transvoice.a.g;
import com.tencent.mm.plugin.transvoice.model.c.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "bottomSheetCoordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "btnLayout", "canCloseKeyboard", "", "canClosePanel", "canHideKeyboard", "closeInputMethod", "Landroid/widget/ImageView;", "closePanel", "container", "Lcom/tencent/mm/modelvoiceaddr/ShortSentenceContainer;", "curTxt", "", "getCurTxt", "()Ljava/lang/String;", "setCurTxt", "(Ljava/lang/String;)V", "dotCounter", "", "dotStr", "emojiRoot", "Landroid/widget/FrameLayout;", "hasClick", "inputMethodLayout", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoicePanelLayout;", "inputMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "isEdited", "isKeyboardShown", "keyboardHeight", "langType", "languageChoiceDialog", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "mNewVoiceInputReport", "Lcom/tencent/mm/modelvoiceaddr/voicereport/NewVoiceInputReportManager;", "mVoiceIdSet", "", "needSendTxtMsg", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "overTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "panelDragOpeMode", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$PanelDragOpeMode;", "reporter", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "sendTxtMsg", "Landroid/widget/Button;", "sendVoiceMsg", "showImeRunnable", "Ljava/lang/Runnable;", "smileyItem", "smileyOpener", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "talker", "getTalker", "setTalker", "targetView", "tmpClickChangeLangTypeTime", "", "transCancelable", "transMore", "transPanelAction", "Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "getTransPanelAction", "()Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "setTransPanelAction", "(Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;)V", "transSP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "txtEditView", "Lcom/tencent/mm/ui/widget/MMEditText;", "txtMsg4Send", "updateDotTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceAddr", "Lcom/tencent/mm/plugin/transvoice/model/SceneVoiceInputAddr2;", "value", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "voiceLen", "getVoiceLen", "()J", "setVoiceLen", "(J)V", "voiceMsgSend", "cgiReport", "", "msg", "closeInputMethodBtnVisibility", "visible", "closeTransPanel", "exitType", "delPunctuation", "getContentTxt", "init", "initSmileyPanel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshBottomPanelHeight", "resetTransPanel", "saveTransLangTypeByTalker", "type", "setBottomBtnVisibility", "setKeyboardVisibility", "setSmileyItemVisibility", "setSmileyPanelVisibility", "show", "startTrans", "updateCurTxt", "updateTransLangTypeByTalker", "Companion", "InputMode", "PanelDragOpeMode", "TransPanelAction", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends androidx.appcompat.app.e
{
  public static final b.a TVJ;
  public static int TWs;
  boolean FzT;
  private FrameLayout SxL;
  private boolean SxS;
  private MMBottomSheetBehavior<View> TUA;
  private boolean TUB;
  private a.b TUC;
  private ImageView TUx;
  final com.tencent.mm.plugin.transvoice.model.c TVK;
  long TVL;
  boolean TVM;
  private TransVoicePanelLayout TVN;
  private MMEditText TVO;
  private ImageView TVP;
  private ImageView TVQ;
  private View TVR;
  private View TVS;
  private ImageView TVT;
  private Button TVU;
  private Button TVV;
  com.tencent.mm.plugin.transvoice.model.b TVW;
  private b TVX;
  public long TVY;
  private String TVZ;
  private boolean TWa;
  private String TWb;
  private int TWc;
  MTimerHandler TWd;
  private boolean TWe;
  private a TWf;
  MMHandler TWg;
  private SharedPreferences TWh;
  private CoordinatorLayout TWi;
  private b.c TWj;
  private boolean TWk;
  private boolean TWl;
  private boolean TWm;
  private String TWn;
  private final com.tencent.mm.modelvoiceaddr.b.b TWo;
  private List<String> TWp;
  String TWq;
  public d TWr;
  private ChatFooterPanel moD;
  private View nmf;
  h pfc;
  int pfh;
  private int sNb;
  public String talker;
  private final Runnable ymo;
  
  static
  {
    AppMethodBeat.i(102605);
    TVJ = new b.a((byte)0);
    TWs = -1;
    AppMethodBeat.o(102605);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, a.g.TransDialog);
    AppMethodBeat.i(102604);
    c.a locala = com.tencent.mm.plugin.transvoice.model.c.TUa;
    this.TVK = com.tencent.mm.plugin.transvoice.model.c.hPD();
    this.pfh = g.pfF;
    this.TVX = b.TWt;
    this.TWb = "";
    this.TWh = paramContext.getSharedPreferences("voice2txt_sp", 0);
    this.TWj = b.c.TWx;
    this.TWn = "";
    bU();
    this.TWo = new com.tencent.mm.modelvoiceaddr.b.b();
    this.ymo = new b..ExternalSyntheticLambda13(paramContext, this);
    this.TWq = "";
    AppMethodBeat.o(102604);
  }
  
  private static final void E(DialogInterface paramDialogInterface) {}
  
  private final void FI(boolean paramBoolean)
  {
    AppMethodBeat.i(102598);
    ImageView localImageView;
    if (paramBoolean)
    {
      localImageView = this.TVP;
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        AppMethodBeat.o(102598);
      }
    }
    else
    {
      localImageView = this.TVP;
      if (localImageView != null) {
        localImageView.setVisibility(0);
      }
    }
    AppMethodBeat.o(102598);
  }
  
  private final void FJ(boolean paramBoolean)
  {
    AppMethodBeat.i(262542);
    View localView;
    if (paramBoolean)
    {
      localView = this.TVS;
      if (localView != null)
      {
        localView.setVisibility(0);
        AppMethodBeat.o(262542);
      }
    }
    else
    {
      localView = this.TVS;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(262542);
  }
  
  private final void FK(boolean paramBoolean)
  {
    AppMethodBeat.i(262544);
    View localView;
    if (paramBoolean)
    {
      localView = this.TVR;
      if (localView != null)
      {
        localView.setVisibility(0);
        AppMethodBeat.o(262544);
      }
    }
    else
    {
      localView = this.TVR;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(262544);
  }
  
  private final void FL(boolean paramBoolean)
  {
    AppMethodBeat.i(262547);
    ChatFooterPanel localChatFooterPanel;
    if (paramBoolean)
    {
      localChatFooterPanel = this.moD;
      if (localChatFooterPanel != null)
      {
        localChatFooterPanel.setVisibility(0);
        AppMethodBeat.o(262547);
      }
    }
    else
    {
      localChatFooterPanel = this.moD;
      if (localChatFooterPanel != null) {
        localChatFooterPanel.setVisibility(4);
      }
    }
    AppMethodBeat.o(262547);
  }
  
  private static final void a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(262573);
    s.u(paramContext, "$context");
    s.u(paramb, "this$0");
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext != null) {
      paramContext.showSoftInput((View)paramb.TVO, 0);
    }
    AppMethodBeat.o(262573);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(262572);
    s.u(paramb, "this$0");
    Log.d("MicroMsg.TransVoiceDialog", "onDismiss.");
    String str;
    if (paramb.TWm)
    {
      paramb.TWm = false;
      if (!Util.isNullOrNil(paramb.TWn))
      {
        paramDialogInterface = paramb.TWr;
        if (paramDialogInterface != null) {
          paramDialogInterface.beT(paramb.TWn);
        }
        str = paramb.TWn;
        paramDialogInterface = paramb.TWp;
        if (paramDialogInterface != null) {
          break label195;
        }
        paramDialogInterface = null;
        Log.i("MicroMsg.TransVoiceDialog", "cgiReport size = %s", new Object[] { paramDialogInterface });
        paramDialogInterface = com.tencent.mm.model.newabtest.d.bEt().Fd("100235");
        if ((paramDialogInterface == null) || (!paramDialogInterface.isValid())) {
          break label208;
        }
      }
    }
    label195:
    label208:
    for (int i = Util.getInt((String)paramDialogInterface.iWZ().get("MMVoipVadOn"), 0);; i = 0)
    {
      Log.i("MicroMsg.TransVoiceDialog", "cgiReport: abTestFlag = [%s]", new Object[] { Integer.valueOf(i) });
      paramb.TWo.a(paramb.TWp, str, String.valueOf(i));
      paramb = paramb.TWp;
      if (paramb != null) {
        paramb.clear();
      }
      AppMethodBeat.o(262572);
      return;
      paramDialogInterface = Integer.valueOf(paramDialogInterface.size());
      break;
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(262555);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.TVK.TUs = 1;
    paramb.FzT = true;
    if (paramb.TWe)
    {
      paramb.TWe = false;
      paramb.TVK.TUq = 0;
      paramb.TVK.TUm = System.currentTimeMillis();
      paramView = paramb.TVW;
      if (paramView != null) {
        paramView.bj(false, true);
      }
      paramView = paramb.TVR;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = paramb.TWg;
      if (paramView != null) {
        paramView.removeMessages(5000);
      }
      paramView = paramb.TWd;
      if (paramView != null) {
        paramView.stopTimer();
      }
      paramView = paramb.TVO;
      if (paramView != null) {
        paramView.setText((CharSequence)paramb.TWq);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262555);
  }
  
  private static final void a(b paramb, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(262551);
    s.u(paramb, "this$0");
    paramb.SxS = paramBoolean;
    Log.d("MicroMsg.TransVoiceDialog", "isKeyboardShow %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    int i;
    if (paramBoolean)
    {
      paramb.TVX = b.TWv;
      localObject = paramb.TUA;
      if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).mState))
      {
        i = 1;
        if (i != 0) {
          paramb.TWj = b.c.TWy;
        }
        localObject = paramb.TVO;
        if (localObject != null) {
          ((MMEditText)localObject).setCursorVisible(true);
        }
        paramb.FJ(true);
        paramb.FK(false);
        paramb.FL(false);
        localObject = paramb.TVT;
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(a.c.chatting_setmode_biaoqing_btn);
        }
        paramb.FI(true);
        if ((paramb.sNb != paramInt) && (paramInt != 0))
        {
          paramb.sNb = paramInt;
          j.H(paramb.getContext(), paramInt);
          paramInt = KeyBoardUtil.getValidPanelHeight(paramb.getContext());
          localObject = paramb.moD;
          if (localObject != null) {
            ((ChatFooterPanel)localObject).setPortHeightPx(paramInt);
          }
          paramb = paramb.moD;
          if (paramb != null) {
            break label378;
          }
        }
      }
    }
    label378:
    for (paramb = null;; paramb = paramb.getLayoutParams())
    {
      if (paramb != null) {
        paramb.height = paramInt;
      }
      AppMethodBeat.o(262551);
      return;
      i = 0;
      break;
      localObject = paramb.TUA;
      if ((localObject != null) && (3 == ((MMBottomSheetBehavior)localObject).mState)) {}
      for (i = 1;; i = 0)
      {
        if ((i != 0) && (b.TWu != paramb.TVX)) {
          paramb.TWj = b.c.TWx;
        }
        localObject = paramb.TVX;
        switch (e.$EnumSwitchMapping$0[localObject.ordinal()])
        {
        case 1: 
        default: 
          break;
        case 2: 
          paramb.TVX = b.TWt;
          if (b.c.TWy == paramb.TWj) {
            break;
          }
          paramb.FJ(false);
          paramb.FK(true);
          localObject = paramb.moD;
          if (localObject != null) {
            ((ChatFooterPanel)localObject).setVisibility(8);
          }
          localObject = paramb.TVO;
          if (localObject != null) {
            ((MMEditText)localObject).setCursorVisible(false);
          }
          paramb.FI(false);
          break;
        }
      }
    }
  }
  
  private static final boolean a(b paramb)
  {
    AppMethodBeat.i(262566);
    s.u(paramb, "this$0");
    int i = paramb.TWc;
    paramb.TWc += 1;
    Object localObject;
    switch (i % 3)
    {
    default: 
      localObject = paramb.TWq;
      if (((String)localObject).length() <= 3) {
        break;
      }
    }
    for (i = ((String)localObject).length() - 3;; i = 0)
    {
      String str = s.X((String)localObject, paramb.TWb);
      localObject = new SpannableString((CharSequence)str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramb.getContext().getResources().getColor(com.tencent.mm.plugin.transvoice.a.a.BW_0_Alpha_0_3)), i, str.length(), 18);
      paramb = paramb.TVO;
      if (paramb != null) {
        paramb.setText((CharSequence)localObject);
      }
      AppMethodBeat.o(262566);
      return true;
      paramb.TWb = "·";
      break;
      paramb.TWb = "··";
      break;
      paramb.TWb = "···";
      break;
    }
  }
  
  private static final boolean a(b paramb, Message paramMessage)
  {
    AppMethodBeat.i(262571);
    s.u(paramb, "this$0");
    s.u(paramMessage, "it");
    if (paramMessage.what == 5000)
    {
      paramb.TVK.TUl = 1;
      paramb.TVK.TUm = System.currentTimeMillis();
      paramb.TVK.TUq = 0;
      paramMessage = paramb.TWd;
      if (paramMessage != null) {
        paramMessage.stopTimer();
      }
      paramMessage = paramb.TVW;
      if (paramMessage != null) {
        paramMessage.bj(false, false);
      }
      if (!Util.isNullOrNil(paramb.TWq))
      {
        paramMessage = paramb.TVO;
        if (paramMessage != null) {
          paramMessage.setFocusable(true);
        }
        paramMessage = paramb.TVO;
        if (paramMessage != null) {
          paramMessage.setFocusableInTouchMode(true);
        }
      }
      paramMessage = paramb.TVO;
      if (paramMessage != null) {
        paramMessage.setText((CharSequence)paramb.TWq);
      }
      paramb = paramb.TVR;
      if (paramb != null) {
        paramb.setVisibility(0);
      }
    }
    AppMethodBeat.o(262571);
    return true;
  }
  
  private static final boolean a(b paramb, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(262553);
    s.u(paramb, "this$0");
    if ((4 == paramInt) || (66 == paramKeyEvent.getAction()))
    {
      paramb.hPR();
      AppMethodBeat.o(262553);
      return true;
    }
    AppMethodBeat.o(262553);
    return false;
  }
  
  private final void apv(int paramInt)
  {
    AppMethodBeat.i(102600);
    if (isShowing())
    {
      this.TVK.setExitType(paramInt);
      hPQ();
      dismiss();
      d locald = this.TWr;
      if (locald != null) {
        locald.hPS();
      }
      if (!this.TWa)
      {
        locald = this.TWr;
        if (locald != null) {
          locald.beU(this.TVZ);
        }
      }
      this.TWa = false;
    }
    AppMethodBeat.o(102600);
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(262558);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.apv(6);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262558);
  }
  
  private static final void c(b paramb, View paramView)
  {
    AppMethodBeat.i(262560);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.TVL = System.currentTimeMillis();
    paramView = paramb.TWf;
    if (paramView != null) {
      paramView.pfh = paramb.pfh;
    }
    paramView = paramb.TWf;
    if (paramView != null) {
      paramView.hPF();
    }
    paramb = paramb.TWf;
    if (paramb != null) {
      paramb.show();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262560);
  }
  
  private static final void d(b paramb, View paramView)
  {
    AppMethodBeat.i(262562);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramView = paramb.TVX;
    switch (e.$EnumSwitchMapping$0[paramView.ordinal()])
    {
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(262562);
      return;
      paramb.setKeyboardVisibility(false);
      continue;
      paramb.TVX = b.TWt;
      paramb.FJ(false);
      paramb.FK(true);
      paramView = paramb.moD;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramView = paramb.TVO;
      if (paramView != null) {
        paramView.setCursorVisible(false);
      }
      paramb.FI(false);
      continue;
      paramb.TVX = b.TWt;
      paramb.apv(6);
    }
  }
  
  private static final void e(b paramb, View paramView)
  {
    AppMethodBeat.i(262565);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    if (paramb.SxS)
    {
      paramb.TVX = b.TWu;
      paramb.setKeyboardVisibility(false);
      paramb.FL(true);
      paramb = paramb.TVT;
      if (paramb != null) {
        paramb.setImageResource(a.c.chatting_setmode_keyboard_btn);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(262565);
      return;
      paramb.TVX = b.TWv;
      paramb.setKeyboardVisibility(true);
      paramb.FL(false);
      paramb = paramb.TVT;
      if (paramb != null) {
        paramb.setImageResource(a.c.chatting_setmode_biaoqing_btn);
      }
    }
  }
  
  private static final void f(b paramb, View paramView)
  {
    AppMethodBeat.i(262567);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    Log.i("MicroMsg.TransVoiceDialog", "sendVoiceMsg onClick.");
    paramView = paramb.TWr;
    if ((paramView != null) && (true == paramView.e(paramb.TVZ, Long.valueOf(paramb.TVY)))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramb.TWa = true;
      }
      paramb.apv(7);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(262567);
      return;
    }
  }
  
  private static final void g(b paramb, View paramView)
  {
    AppMethodBeat.i(262568);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.hPR();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262568);
  }
  
  private final void hPR()
  {
    AppMethodBeat.i(262550);
    this.TVK.TUk = this.pfh;
    Object localObject = this.TVO;
    if (localObject == null)
    {
      localObject = null;
      localObject = String.valueOf(localObject);
      if (Util.isNullOrNil((String)localObject)) {
        break label89;
      }
      this.TVK.TUo = ((String)localObject).length();
      this.TWm = true;
    }
    for (this.TWn = ((String)localObject);; this.TWn = "")
    {
      if (!this.TVM) {
        break label107;
      }
      apv(8);
      AppMethodBeat.o(262550);
      return;
      localObject = ((MMEditText)localObject).getText();
      break;
      label89:
      this.TVK.TUo = 0;
    }
    label107:
    apv(5);
    AppMethodBeat.o(262550);
  }
  
  private final void setKeyboardVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(102599);
    Log.d("MicroMsg.TransVoiceDialog", "setKeyboardVisibility, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    InputMethodManager localInputMethodManager;
    if (paramBoolean)
    {
      localObject = this.nmf;
      if (localObject != null) {
        ((View)localObject).removeCallbacks(this.ymo);
      }
      localObject = this.nmf;
      if (localObject != null)
      {
        ((View)localObject).post(this.ymo);
        AppMethodBeat.o(102599);
      }
    }
    else
    {
      localObject = this.nmf;
      if (localObject != null) {
        ((View)localObject).removeCallbacks(this.ymo);
      }
      localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localObject = this.TVO;
        if (localObject != null) {
          break label134;
        }
      }
    }
    label134:
    for (Object localObject = null;; localObject = ((MMEditText)localObject).getWindowToken())
    {
      localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
      AppMethodBeat.o(102599);
      return;
    }
  }
  
  public final void beR(String paramString)
  {
    AppMethodBeat.i(185255);
    if (!Util.isNullOrNil(paramString))
    {
      this.TVZ = paramString;
      com.tencent.mm.cj.a.a locala = com.tencent.mm.cj.a.adtq;
      s.checkNotNull(paramString);
      s.u(paramString, "<set-?>");
      com.tencent.mm.cj.a.bzA(paramString);
    }
    AppMethodBeat.o(185255);
  }
  
  public final void beS(String paramString)
  {
    AppMethodBeat.i(102602);
    s.u(paramString, "<set-?>");
    this.TWq = paramString;
    AppMethodBeat.o(102602);
  }
  
  public final void c(h paramh)
  {
    AppMethodBeat.i(185256);
    s.u(paramh, "container");
    Object localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).setDimAmount(0.5F);
    }
    localObject = this.TUA;
    if (localObject != null) {
      ((MMBottomSheetBehavior)localObject).aL();
    }
    this.TVM = false;
    this.FzT = false;
    int i = this.TWh.getInt(this.talker, 0);
    localObject = this.TWf;
    s.checkNotNull(localObject);
    localObject = ((a)localObject).TUy;
    s.checkNotNull(localObject);
    if (((ArrayList)localObject).contains(Integer.valueOf(i))) {
      this.pfh = i;
    }
    do
    {
      for (;;)
      {
        this.TVK.TUj = this.pfh;
        hPQ();
        localObject = this.TWg;
        if (localObject != null) {
          ((MMHandler)localObject).sendEmptyMessageDelayed(5000, 5000L);
        }
        localObject = this.TWd;
        if (localObject != null) {
          ((MTimerHandler)localObject).startTimer(500L);
        }
        this.pfc = paramh;
        this.TVW = new com.tencent.mm.plugin.transvoice.model.b(paramh, this.pfh, (g.b)new k(this));
        paramh = this.TVW;
        if (paramh != null) {
          paramh.start();
        }
        AppMethodBeat.o(185256);
        return;
        localObject = this.TWf;
        s.checkNotNull(localObject);
        localObject = ((a)localObject).TUy;
        s.checkNotNull(localObject);
        if (((ArrayList)localObject).size() > 0)
        {
          localObject = this.TWf;
          s.checkNotNull(localObject);
          localObject = ((a)localObject).TUy;
          s.checkNotNull(localObject);
          localObject = ((ArrayList)localObject).get(0);
          s.s(localObject, "languageChoiceDialog!!.langTypeArr!![0]");
          this.pfh = ((Number)localObject).intValue();
        }
        else
        {
          localObject = LocaleUtil.getCurrentLanguage(getContext());
          if (localObject != null) {
            switch (((String)localObject).hashCode())
            {
            default: 
              break;
            case 3241: 
              if (((String)localObject).equals("en")) {
                this.pfh = g.pfH;
              }
              break;
            }
          }
        }
      }
    } while (!((String)localObject).equals("zh_HK"));
    for (;;)
    {
      this.pfh = g.pfF;
      break;
      if (!((String)localObject).equals("zh_TW")) {
        if ((goto 101) || (!((String)localObject).equals("zh_CN"))) {
          break;
        }
      }
    }
  }
  
  final void hPQ()
  {
    AppMethodBeat.i(102601);
    this.TWq = "";
    this.TWc = 0;
    this.TWb = "";
    this.TWe = false;
    Object localObject = this.TVO;
    if (localObject != null) {
      ((MMEditText)localObject).setText((CharSequence)"");
    }
    localObject = this.TVO;
    if (localObject != null) {
      ((MMEditText)localObject).setCursorVisible(false);
    }
    localObject = this.TVO;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusable(false);
    }
    localObject = this.TVO;
    if (localObject != null) {
      ((MMEditText)localObject).setFocusableInTouchMode(false);
    }
    localObject = this.TVR;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.TVS;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    setKeyboardVisibility(false);
    localObject = this.moD;
    if (localObject != null) {
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    FI(false);
    localObject = this.TWg;
    if (localObject != null) {
      ((MMHandler)localObject).removeMessages(5000);
    }
    this.TWj = b.c.TWx;
    this.TUB = false;
    this.TWk = false;
    this.TWl = false;
    AppMethodBeat.o(102601);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(102597);
    apv(6);
    super.onBackPressed();
    AppMethodBeat.o(102597);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102596);
    this.nmf = LayoutInflater.from(getContext()).inflate(a.e.TTJ, null, false);
    Object localObject = new ViewGroup.LayoutParams(-1, -1);
    View localView = this.nmf;
    s.checkNotNull(localView);
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
    paramBundle = this.nmf;
    if (paramBundle == null)
    {
      paramBundle = null;
      this.TVN = paramBundle;
      paramBundle = this.TVN;
      if (paramBundle != null) {
        paramBundle.setOnInputPanelChange(new b..ExternalSyntheticLambda10(this));
      }
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label918;
      }
      paramBundle = null;
      label145:
      this.TWi = paramBundle;
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label932;
      }
      paramBundle = null;
      label161:
      this.TUA = MMBottomSheetBehavior.c(paramBundle);
      paramBundle = this.TUA;
      if (paramBundle != null) {
        paramBundle.cb = ((MMBottomSheetBehavior.a)new g(this));
      }
      paramBundle = this.TUA;
      if (paramBundle != null) {
        paramBundle.cj = ((MMBottomSheetBehavior.b)new h(this));
      }
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label943;
      }
      paramBundle = null;
      label228:
      this.TVO = paramBundle;
      paramBundle = this.TVO;
      if (paramBundle != null)
      {
        paramBundle.setCursorVisible(false);
        paramBundle.setOnEditorActionListener(new b..ExternalSyntheticLambda9(this));
        paramBundle.setMaxLines(2147483647);
        paramBundle.setHorizontallyScrolling(false);
        paramBundle.setOnClickListener(new b..ExternalSyntheticLambda6(this));
        paramBundle.addTextChangedListener((TextWatcher)new i(this));
      }
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label957;
      }
      paramBundle = null;
      label309:
      this.TUx = paramBundle;
      paramBundle = this.TUx;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new b..ExternalSyntheticLambda3(this));
      }
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label971;
      }
      paramBundle = null;
      label346:
      this.TVP = paramBundle;
      paramBundle = this.TVP;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new b..ExternalSyntheticLambda7(this));
      }
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label985;
      }
      paramBundle = null;
      label383:
      this.TVQ = paramBundle;
      paramBundle = this.TVQ;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new b..ExternalSyntheticLambda8(this));
      }
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label999;
      }
      paramBundle = null;
      label420:
      this.TVR = paramBundle;
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label1010;
      }
      paramBundle = null;
      label436:
      this.TVS = paramBundle;
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label1021;
      }
      paramBundle = null;
      label452:
      this.TVT = paramBundle;
      paramBundle = this.TVT;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new b..ExternalSyntheticLambda2(this));
      }
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label1035;
      }
      paramBundle = null;
      label489:
      this.SxL = paramBundle;
      this.moD = ((ChatFooterPanel)ae.co(getContext()));
      this.sNb = KeyBoardUtil.getValidPanelHeight(getContext());
      paramBundle = new FrameLayout.LayoutParams(-1, this.sNb);
      localObject = this.SxL;
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.moD, (ViewGroup.LayoutParams)paramBundle);
      }
      paramBundle = this.moD;
      if (paramBundle != null) {
        paramBundle.setPortHeightPx(this.sNb);
      }
      paramBundle = this.moD;
      if (paramBundle != null) {
        paramBundle.setEntranceScene(ChatFooterPanel.XYl);
      }
      paramBundle = this.moD;
      if (paramBundle != null) {
        paramBundle.iKh();
      }
      paramBundle = this.moD;
      if (paramBundle != null) {
        paramBundle.onResume();
      }
      paramBundle = this.moD;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.moD;
      if (paramBundle != null) {
        paramBundle.setShowSend(true);
      }
      paramBundle = this.moD;
      if (paramBundle != null) {
        paramBundle.setOnTextOperationListener((ChatFooterPanel.a)new j(this));
      }
      this.TWd = new MTimerHandler(new b..ExternalSyntheticLambda12(this), true);
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label1049;
      }
      paramBundle = null;
      label698:
      this.TVU = paramBundle;
      paramBundle = this.TVU;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new b..ExternalSyntheticLambda5(this));
      }
      paramBundle = this.nmf;
      if (paramBundle != null) {
        break label1063;
      }
      paramBundle = null;
      label735:
      this.TVV = paramBundle;
      paramBundle = this.TVV;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new b..ExternalSyntheticLambda4(this));
      }
      paramBundle = this.TVU;
      if (paramBundle != null) {
        break label1077;
      }
      paramBundle = null;
      label772:
      aw.a((Paint)paramBundle, 0.8F);
      paramBundle = this.TVV;
      if (paramBundle != null) {
        break label1085;
      }
    }
    label918:
    label932:
    label943:
    label1077:
    label1085:
    for (paramBundle = null;; paramBundle = paramBundle.getPaint())
    {
      aw.a((Paint)paramBundle, 0.8F);
      this.TUC = ((a.b)new f(this));
      paramBundle = getContext();
      s.s(paramBundle, "context");
      this.TWf = new a(paramBundle);
      paramBundle = this.TWf;
      if (paramBundle != null)
      {
        paramBundle.setOnDismissListener(b..ExternalSyntheticLambda1.INSTANCE);
        paramBundle.TUC = this.TUC;
      }
      this.TWg = new MMHandler(new b..ExternalSyntheticLambda11(this));
      setOnDismissListener(new b..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(102596);
      return;
      paramBundle = (TransVoicePanelLayout)paramBundle.findViewById(a.d.TTo);
      break;
      paramBundle = (CoordinatorLayout)paramBundle.findViewById(a.d.TTi);
      break label145;
      paramBundle = paramBundle.findViewById(a.d.TTA);
      break label161;
      paramBundle = (MMEditText)paramBundle.findViewById(a.d.TTD);
      break label228;
      label957:
      paramBundle = (ImageView)paramBundle.findViewById(a.d.TTm);
      break label309;
      label971:
      paramBundle = (ImageView)paramBundle.findViewById(a.d.TTE);
      break label346;
      label985:
      paramBundle = (ImageView)paramBundle.findViewById(a.d.TTl);
      break label383;
      label999:
      paramBundle = paramBundle.findViewById(a.d.TTz);
      break label420;
      label1010:
      paramBundle = paramBundle.findViewById(a.d.TTB);
      break label436;
      label1021:
      paramBundle = (ImageView)paramBundle.findViewById(a.d.TTC);
      break label452;
      paramBundle = (FrameLayout)paramBundle.findViewById(a.d.TTn);
      break label489;
      paramBundle = (Button)paramBundle.findViewById(a.d.TTj);
      break label698;
      paramBundle = (Button)paramBundle.findViewById(a.d.TTk);
      break label735;
      paramBundle = paramBundle.getPaint();
      break label772;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(102603);
    com.tencent.mm.cj.a.a locala = com.tencent.mm.cj.a.adtq;
    com.tencent.mm.cj.a.KP(true);
    super.show();
    AppMethodBeat.o(102603);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$InputMode;", "", "(Ljava/lang/String;I)V", "INPUT_NONE", "INPUT_EMOJI", "INPUT_KEYBOARD", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static enum b
  {
    static
    {
      AppMethodBeat.i(102558);
      TWt = new b("INPUT_NONE", 0);
      TWu = new b("INPUT_EMOJI", 1);
      TWv = new b("INPUT_KEYBOARD", 2);
      TWw = new b[] { TWt, TWu, TWv };
      AppMethodBeat.o(102558);
    }
    
    private b() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$TransPanelAction;", "", "onTransPanelClose", "", "onTxtMsgSend", "txt", "", "onVoiceMsgDelete", "fileName", "onVoiceMsgSend", "", "fileLength", "", "(Ljava/lang/String;Ljava/lang/Long;)Z", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void beT(String paramString);
    
    public abstract void beU(String paramString);
    
    public abstract boolean e(String paramString, Long paramLong);
    
    public abstract void hPS();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$12", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements a.b
  {
    f(b paramb) {}
    
    public final void app(int paramInt)
    {
      AppMethodBeat.i(102571);
      Object localObject1 = b.o(this.TWA);
      if (localObject1 != null) {
        ((a)localObject1).dismiss();
      }
      b.a(this.TWA, paramInt);
      if (paramInt == b.p(this.TWA))
      {
        AppMethodBeat.o(102571);
        return;
      }
      if (NetStatusUtil.isConnected(this.TWA.getContext()))
      {
        localObject1 = this.TWA;
        ((b)localObject1).TVM = false;
        ((b)localObject1).FzT = false;
        ((b)localObject1).TVK.TUi = ((b)localObject1).TVL;
        ((b)localObject1).TVK.TUl = 0;
        ((b)localObject1).TVK.TUm = 0L;
        ((b)localObject1).TVK.TUn = 0;
        ((b)localObject1).TVK.TUq = 0;
        ((b)localObject1).TVK.TUr = 0;
        ((b)localObject1).TVK.TUs = 0;
        ((b)localObject1).hPQ();
        Object localObject2 = ((b)localObject1).TWg;
        if (localObject2 != null) {
          ((MMHandler)localObject2).sendEmptyMessageDelayed(5000, 5000L);
        }
        localObject2 = ((b)localObject1).TWd;
        if (localObject2 != null) {
          ((MTimerHandler)localObject2).startTimer(500L);
        }
        ((b)localObject1).pfh = paramInt;
        long l2 = System.nanoTime() & 0xFFFFFFFF;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = Math.abs(l2);
        }
        localObject2 = new h(String.valueOf(l1));
        h localh = ((b)localObject1).pfc;
        if (localh != null) {
          localh.a((h)localObject2);
        }
        ((b)localObject1).TVW = new com.tencent.mm.plugin.transvoice.model.b((h)localObject2, paramInt, (g.b)new b.l((b)localObject1));
        localObject1 = ((b)localObject1).TVW;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.transvoice.model.b)localObject1).start();
        }
        AppMethodBeat.o(102571);
        return;
      }
      localObject1 = new e.a(this.TWA.getContext());
      ((e.a)localObject1).bDw(this.TWA.getContext().getResources().getString(a.f.app_network_unavailable));
      ((e.a)localObject1).bDC(this.TWA.getContext().getResources().getString(a.f.gOB));
      ((e.a)localObject1).aET(this.TWA.getContext().getResources().getColor(com.tencent.mm.plugin.transvoice.a.a.Link_100));
      ((e.a)localObject1).jHH().show();
      AppMethodBeat.o(102571);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$2", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends MMBottomSheetBehavior.a
  {
    g(b paramb) {}
    
    private static final void C(b paramb)
    {
      AppMethodBeat.i(262522);
      s.u(paramb, "this$0");
      paramb = b.m(paramb);
      if (paramb != null) {
        paramb.requestLayout();
      }
      AppMethodBeat.o(262522);
    }
    
    public final void c(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102576);
      s.u(paramView, "bottomSheet");
      Log.d("MicroMsg.TransVoiceDialog", "slideOffset: %f, panelDragOpeMode: %s.", new Object[] { Float.valueOf(paramFloat), b.b(this.TWA) });
      paramView = b.c(this.TWA);
      int i;
      if ((paramView != null) && (paramView.mState == 1))
      {
        i = 1;
        if (i == 0) {
          break label309;
        }
        if (b.c.TWx == b.b(this.TWA))
        {
          paramView = this.TWA;
          if (0.7F < paramFloat) {
            break label248;
          }
          bool = true;
          label93:
          b.a(paramView, bool);
          paramView = this.TWA.getWindow();
          if (paramView != null) {
            paramView.setDimAmount((float)(0.5D - (1.0F - paramFloat) / 2.0D));
          }
        }
        if (b.c.TWy != b.b(this.TWA)) {
          break label309;
        }
        paramView = this.TWA;
        if (0.8F < paramFloat) {
          break label254;
        }
      }
      label248:
      label254:
      for (boolean bool = true;; bool = false)
      {
        b.b(paramView, bool);
        if (0.9F < paramFloat) {
          break label260;
        }
        if (b.d(this.TWA)) {
          break label309;
        }
        b.c(this.TWA, true);
        b.d(this.TWA, false);
        b.e(this.TWA, false);
        b.f(this.TWA, false);
        b.e(this.TWA);
        paramView = b.f(this.TWA);
        if (paramView == null) {
          break label309;
        }
        paramView.setImageResource(a.c.chatting_setmode_biaoqing_btn);
        AppMethodBeat.o(102576);
        return;
        i = 0;
        break;
        bool = false;
        break label93;
      }
      label260:
      if (b.d(this.TWA))
      {
        b.c(this.TWA, false);
        b.d(this.TWA, true);
        b.e(this.TWA, true);
        b.f(this.TWA, false);
        b.e(this.TWA);
      }
      label309:
      AppMethodBeat.o(102576);
    }
    
    public final void e(View paramView, int paramInt)
    {
      AppMethodBeat.i(102577);
      s.u(paramView, "bottomSheet");
      Log.d("MicroMsg.TransVoiceDialog", "newState: %d, panelDragOpeMode: %s, canClosePanel: %s, canHideKeyboard: %s, canCloseKeyboard: %s.", new Object[] { Integer.valueOf(paramInt), b.b(this.TWA), Boolean.valueOf(b.g(this.TWA)), Boolean.valueOf(b.d(this.TWA)), Boolean.valueOf(b.h(this.TWA)) });
      switch (paramInt)
      {
      }
      while ((1 != paramInt) && (3 != paramInt)) {
        if (!b.g(this.TWA))
        {
          paramView = this.TWA.getWindow();
          if (paramView != null) {
            paramView.setDimAmount(0.5F);
          }
          paramView = b.c(this.TWA);
          if (paramView != null)
          {
            paramView.aL();
            AppMethodBeat.o(102577);
            return;
            b.a(this.TWA, false);
            b.c(this.TWA, false);
            b.b(this.TWA, false);
            continue;
            if ((b.c.TWx == b.b(this.TWA)) && (b.g(this.TWA))) {
              b.i(this.TWA);
            }
            if ((b.c.TWy == b.b(this.TWA)) && (b.d(this.TWA))) {
              if (b.h(this.TWA))
              {
                b.a(this.TWA, b.c.TWx);
                b.f(this.TWA, true);
                b.e(this.TWA, false);
                paramView = b.j(this.TWA);
                if (paramView != null) {
                  paramView.setVisibility(8);
                }
                paramView = b.k(this.TWA);
                if (paramView != null) {
                  paramView.setCursorVisible(false);
                }
                b.l(this.TWA);
                paramView = b.m(this.TWA);
                if (paramView != null) {
                  paramView.postDelayed(new b.g..ExternalSyntheticLambda0(this.TWA), 200L);
                }
              }
              else
              {
                b.d(this.TWA, true);
                b.e(this.TWA, true);
                b.f(this.TWA, false);
                b.e(this.TWA);
              }
            }
          }
        }
        else
        {
          b.i(this.TWA);
        }
      }
      AppMethodBeat.o(102577);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$ExternalTouchHelper;", "downY", "", "getDownY", "()F", "setDownY", "(F)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onNeedJudge", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements MMBottomSheetBehavior.b
  {
    private float fig;
    
    h(b paramb) {}
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      Boolean localBoolean = null;
      AppMethodBeat.i(102578);
      s.u(paramMotionEvent, "event");
      s.u(paramMotionEvent, "event");
      Object localObject = b.n(this.TWA);
      MMEditText localMMEditText;
      int i;
      if (localObject != null)
      {
        localMMEditText = b.k(this.TWA);
        s.checkNotNull(localMMEditText);
        if (true == ((CoordinatorLayout)localObject).d((View)localMMEditText, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          i = 1;
          if (i != 0)
          {
            localObject = b.k(this.TWA);
            if (localObject != null) {
              break label244;
            }
            localObject = null;
            label95:
            localMMEditText = b.k(this.TWA);
            if (localMMEditText != null) {
              break label258;
            }
            label109:
            Log.d("MicroMsg.TransVoiceDialog", "can scroll up, %s.", new Object[] { localObject });
            Log.d("MicroMsg.TransVoiceDialog", "can scroll down, %s.", new Object[] { localBoolean });
            Log.d("MicroMsg.TransVoiceDialog", "action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
            switch (paramMotionEvent.getAction())
            {
            }
          }
        }
      }
      label244:
      float f;
      label258:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(102578);
          return false;
          i = 0;
          break;
          localObject = Boolean.valueOf(((MMEditText)localObject).canScrollVertically(-1));
          break label95;
          localBoolean = Boolean.valueOf(localMMEditText.canScrollVertically(1));
          break label109;
          this.fig = paramMotionEvent.getY();
        }
        f = paramMotionEvent.getY() - this.fig;
        Log.d("MicroMsg.TransVoiceDialog", "yOffset: %f.", new Object[] { Float.valueOf(f) });
        if (f > 0.0F)
        {
          bool = s.p(Boolean.TRUE, localObject);
          AppMethodBeat.o(102578);
          return bool;
        }
      } while (f >= 0.0F);
      boolean bool = s.p(Boolean.TRUE, localBoolean);
      AppMethodBeat.o(102578);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$4$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements TextWatcher
  {
    i(b paramb) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int i = 0;
      AppMethodBeat.i(262519);
      if ((!b.x(this.TWA)) && (b.y(this.TWA)))
      {
        b.z(this.TWA);
        b.s(this.TWA).TUr = 1;
      }
      Object localObject = b.A(this.TWA);
      if (localObject != null) {
        if (Util.isNullOrNil((CharSequence)paramEditable)) {
          break label115;
        }
      }
      label115:
      for (boolean bool = true;; bool = false)
      {
        ((Button)localObject).setEnabled(bool);
        localObject = b.B(this.TWA);
        if (localObject != null)
        {
          if (Util.isNullOrNil((CharSequence)paramEditable)) {
            i = 4;
          }
          ((ImageView)localObject).setVisibility(i);
        }
        AppMethodBeat.o(262519);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements ChatFooterPanel.a
  {
    j(b paramb) {}
    
    public final void aWL()
    {
      AppMethodBeat.i(102586);
      b.q(this.TWA);
      AppMethodBeat.o(102586);
    }
    
    public final void aWM()
    {
      AppMethodBeat.i(102585);
      Object localObject = b.k(this.TWA);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = b.k(this.TWA);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
        }
      }
      AppMethodBeat.o(102585);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(102584);
      MMEditText localMMEditText = b.k(this.TWA);
      if (localMMEditText != null) {
        localMMEditText.bDt(paramString);
      }
      AppMethodBeat.o(102584);
    }
    
    public final void fp(boolean paramBoolean) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements g.b
  {
    k(b paramb) {}
    
    public final void b(String[] paramArrayOfString, List<String> paramList)
    {
      AppMethodBeat.i(102588);
      Log.i("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.TWA, paramList);
      paramList = b.r(this.TWA);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.r(this.TWA);
      if (paramList != null) {
        paramList.sendEmptyMessageDelayed(5000, 5000L);
      }
      if (paramArrayOfString != null)
      {
        paramList = paramArrayOfString[0];
        if (paramList != null) {
          if (((CharSequence)paramList).length() > 0)
          {
            i = 1;
            if (i != 1) {
              break label230;
            }
          }
        }
      }
      label230:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          this.TWA.beS(paramArrayOfString[0]);
          Log.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.TWA.TWq });
          b.s(this.TWA).TUn = this.TWA.TWq.length();
          if (!b.t(this.TWA))
          {
            b.g(this.TWA, true);
            paramArrayOfString = b.k(this.TWA);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.k(this.TWA);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.k(this.TWA);
            if (paramArrayOfString != null) {
              paramArrayOfString.requestFocus();
            }
          }
        }
        AppMethodBeat.o(102588);
        return;
        i = 0;
        break;
      }
    }
    
    public final void bPD()
    {
      AppMethodBeat.i(102591);
      Log.i("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.g(this.TWA, false);
      b.s(this.TWA).TUq = 1;
      b.s(this.TWA).TUm = System.currentTimeMillis();
      Object localObject = b.r(this.TWA);
      if (localObject != null) {
        ((MMHandler)localObject).removeMessages(5000);
      }
      localObject = b.u(this.TWA);
      if (localObject != null) {
        ((MTimerHandler)localObject).stopTimer();
      }
      b.v(this.TWA);
      localObject = b.w(this.TWA);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      AppMethodBeat.o(102591);
    }
    
    public final void bPz()
    {
      AppMethodBeat.i(102590);
      Log.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102590);
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(102589);
      Log.i("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
      b.s(this.TWA).TUq = 0;
      b.s(this.TWA).TUm = System.currentTimeMillis();
      AppMethodBeat.o(102589);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$2", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements g.b
  {
    l(b paramb) {}
    
    public final void b(String[] paramArrayOfString, List<String> paramList)
    {
      AppMethodBeat.i(102592);
      Log.d("MicroMsg.TransVoiceDialog", "onRes.");
      b.a(this.TWA, paramList);
      paramList = b.r(this.TWA);
      if (paramList != null) {
        paramList.removeMessages(5000);
      }
      paramList = b.r(this.TWA);
      if (paramList != null) {
        paramList.sendEmptyMessageDelayed(5000, 5000L);
      }
      if (paramArrayOfString != null)
      {
        paramList = paramArrayOfString[0];
        if (paramList != null) {
          if (((CharSequence)paramList).length() > 0)
          {
            i = 1;
            if (i != 1) {
              break label230;
            }
          }
        }
      }
      label230:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          this.TWA.beS(paramArrayOfString[0]);
          Log.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.TWA.TWq });
          b.s(this.TWA).TUn = this.TWA.TWq.length();
          if (!b.t(this.TWA))
          {
            b.g(this.TWA, true);
            paramArrayOfString = b.k(this.TWA);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusable(true);
            }
            paramArrayOfString = b.k(this.TWA);
            if (paramArrayOfString != null) {
              paramArrayOfString.setFocusableInTouchMode(true);
            }
            paramArrayOfString = b.k(this.TWA);
            if (paramArrayOfString != null) {
              paramArrayOfString.requestFocus();
            }
          }
        }
        AppMethodBeat.o(102592);
        return;
        i = 0;
        break;
      }
    }
    
    public final void bPD()
    {
      AppMethodBeat.i(102595);
      Log.d("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
      b.g(this.TWA, false);
      b.s(this.TWA).TUq = 1;
      b.s(this.TWA).TUm = System.currentTimeMillis();
      Object localObject = b.r(this.TWA);
      if (localObject != null) {
        ((MMHandler)localObject).removeMessages(5000);
      }
      localObject = b.u(this.TWA);
      if (localObject != null) {
        ((MTimerHandler)localObject).stopTimer();
      }
      b.v(this.TWA);
      localObject = b.w(this.TWA);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      AppMethodBeat.o(102595);
    }
    
    public final void bPz()
    {
      AppMethodBeat.i(102594);
      Log.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
      AppMethodBeat.o(102594);
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(102593);
      Log.d("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
      b.s(this.TWA).TUq = 0;
      b.s(this.TWA).TUm = System.currentTimeMillis();
      AppMethodBeat.o(102593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b
 * JD-Core Version:    0.7.0.1
 */