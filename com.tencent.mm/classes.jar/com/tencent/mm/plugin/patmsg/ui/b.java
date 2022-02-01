package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiPanelInputComponent;
import com.tencent.mm.emoji.view.EmojiPanelInputComponent.a;
import com.tencent.mm.f.b.a.jf;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.d.b;
import com.tencent.mm.plugin.patmsg.d.d;
import com.tencent.mm.plugin.patmsg.d.e;
import com.tencent.mm.plugin.patmsg.d.f;
import com.tencent.mm.plugin.patmsg.d.g;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMClearEditText;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent$InputComponentListener;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "dialogContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "PAT_SUFFIX_LENGTH_LIMIT", "", "getPAT_SUFFIX_LENGTH_LIMIT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "curSuffix", "getCurSuffix", "setCurSuffix", "(Ljava/lang/String;)V", "getDialogContext", "()Landroid/content/Context;", "setDialogContext", "errorTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getErrorTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "hintTv", "Landroid/widget/TextView;", "getHintTv", "()Landroid/widget/TextView;", "setHintTv", "(Landroid/widget/TextView;)V", "inputComponent", "Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;", "getInputComponent", "()Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;", "setInputComponent", "(Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;)V", "suffixET", "Lcom/tencent/mm/ui/widget/MMClearEditText;", "getSuffixET", "()Lcom/tencent/mm/ui/widget/MMClearEditText;", "setSuffixET", "(Lcom/tencent/mm/ui/widget/MMClearEditText;)V", "textWatcher", "Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "getTextWatcher", "()Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismiss", "", "doModifyPatSuffixScene", "suffix", "", "hideVKB", "initContentView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onOpLogResult", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "showVKB", "Companion", "PatTextWatcher", "plugin-patmsg_release"})
public final class b
  extends androidx.appcompat.app.e
  implements EmojiPanelInputComponent.a, h.b
{
  private static b GKY;
  public static final a GKZ;
  final int GKR;
  EmojiPanelInputComponent GKS;
  String GKT;
  MMClearEditText GKU;
  final b GKV;
  final MTimerHandler GKW;
  Context GKX;
  final String TAG;
  TextView nmi;
  private s tipDialog;
  
  static
  {
    AppMethodBeat.i(186522);
    GKZ = new a((byte)0);
    AppMethodBeat.o(186522);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, d.g.PatSuffixSettingDialog);
    AppMethodBeat.i(186521);
    this.GKX = paramContext;
    this.TAG = "MicroMsg.Pat.PatSuffixSettingDialog";
    this.GKR = 20;
    this.GKV = new b();
    this.GKW = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new c(this), false);
    AppMethodBeat.o(186521);
  }
  
  public final void a(int paramInt, dgv paramdgv, k.b paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(186516);
    String str = this.TAG;
    Object localObject1;
    Object localObject2;
    if (paramdgv != null)
    {
      localObject1 = paramdgv.lpy;
      if (paramdgv == null) {
        break label200;
      }
      localObject2 = paramdgv.fwr;
      label35:
      Log.i(str, "ret:%d, content:%s, title:%s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2 });
      localObject1 = this.tipDialog;
      if (localObject1 != null) {
        ((s)localObject1).dismiss();
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new jf();
        ((jf)localObject1).Am(String.valueOf(cm.bfE()));
        ((jf)localObject1).nl(2);
        ((jf)localObject1).ama();
        if (paramInt != 0) {
          break label418;
        }
        com.tencent.mm.ui.base.h.cL(this.GKX, this.GKX.getString(d.f.app_modify_success));
        if (paramb == null) {
          break label206;
        }
        paramdgv = paramb.eSx();
        if (paramdgv != null) {
          break label211;
        }
        paramdgv = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ModPatSuffixOplog");
        AppMethodBeat.o(186516);
        throw paramdgv;
      }
      catch (Exception paramdgv)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramdgv, "", new Object[0]);
        AppMethodBeat.o(186516);
        return;
      }
      localObject1 = null;
      break;
      label200:
      localObject2 = null;
      break label35;
      label206:
      paramdgv = null;
    }
    label211:
    paramdgv = (cyr)paramdgv;
    paramb = com.tencent.mm.kernel.h.aHG();
    p.j(paramb, "MMKernel.storage()");
    paramb = paramb.aHp().j(ar.a.VDu);
    if (paramb == null)
    {
      paramdgv = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(186516);
      throw paramdgv;
    }
    if ((p.h(Util.nullAsNil((String)paramb), paramdgv.TGR) ^ true))
    {
      paramb = com.tencent.mm.kernel.h.aHG();
      p.j(paramb, "MMKernel.storage()");
      paramb.aHp().set(ar.a.VDA, Integer.valueOf(2));
    }
    paramb = com.tencent.mm.kernel.h.aHG();
    p.j(paramb, "MMKernel.storage()");
    paramb.aHp().set(ar.a.VDu, paramdgv.TGR);
    paramdgv = com.tencent.mm.kernel.h.aHG();
    p.j(paramdgv, "MMKernel.storage()");
    paramdgv.aHp().set(ar.a.VDC, Long.valueOf(cm.bfE()));
    paramdgv = com.tencent.mm.kernel.h.aHG();
    p.j(paramdgv, "MMKernel.storage()");
    paramdgv.aHp().set(ar.a.VDD, Integer.valueOf(0));
    ((jf)localObject1).nm(0);
    dismiss();
    ((jf)localObject1).bpa();
    paramdgv = com.tencent.mm.util.c.Yyz;
    com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject1);
    AppMethodBeat.o(186516);
    return;
    label418:
    if (paramdgv != null) {}
    for (paramb = paramdgv.lpy;; paramb = null)
    {
      if (!Util.isNullOrNil(paramb))
      {
        localObject2 = this.GKX;
        paramb = localObject3;
        if (paramdgv != null) {
          paramb = paramdgv.lpy;
        }
        com.tencent.mm.ui.base.h.af((Context)localObject2, paramb, this.GKX.getString(d.f.app_modify_failed));
      }
      for (;;)
      {
        ((jf)localObject1).nm(paramInt);
        break;
        com.tencent.mm.ui.base.h.p(this.GKX, d.f.app_err_system_busy_tip, d.f.app_modify_failed);
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(186515);
    EmojiPanelInputComponent localEmojiPanelInputComponent = this.GKS;
    if (localEmojiPanelInputComponent != null) {
      localEmojiPanelInputComponent.aDH();
    }
    localEmojiPanelInputComponent = this.GKS;
    if (localEmojiPanelInputComponent != null) {
      localEmojiPanelInputComponent.release();
    }
    hideVKB();
    super.dismiss();
    AppMethodBeat.o(186515);
  }
  
  public final void h(boolean paramBoolean, int paramInt) {}
  
  public final void hideVKB()
  {
    AppMethodBeat.i(186514);
    Object localObject = this.GKX.getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(186514);
      throw ((Throwable)localObject);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)localObject;
    localObject = this.GKU;
    if (localObject != null) {}
    for (localObject = ((MMClearEditText)localObject).getWindowToken();; localObject = null)
    {
      localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
      AppMethodBeat.o(186514);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186508);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setLayout(-1, -1);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(67108864);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setDimAmount(0.5F);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setWindowAnimations(d.g.BottomToTopSlowAnimation);
    }
    paramBundle = LayoutInflater.from(this.GKX).inflate(d.e.pat_suffix_setting_dialog, null, false);
    p.j(paramBundle, "LayoutInflater.from(dial…ting_dialog, null, false)");
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    this.GKS = ((EmojiPanelInputComponent)findViewById(d.d.input_component));
    this.GKU = ((MMClearEditText)findViewById(d.d.pat_suffix_edit));
    this.nmi = ((TextView)findViewById(d.d.pat_suffix_hint_tv));
    paramBundle.findViewById(d.d.empty_area_view).setOnTouchListener((View.OnTouchListener)new d(this));
    paramBundle.findViewById(d.d.close_btn).setOnClickListener((View.OnClickListener)new e(this));
    setCancelable(true);
    paramBundle = (EditText)findViewById(d.d.pat_suffix_edit);
    if (paramBundle != null) {
      paramBundle.requestFocus();
    }
    com.tencent.e.h.ZvG.n((Runnable)new f(this), 128L);
    paramBundle = findViewById(d.d.ok_btn);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new g(this));
    }
    paramBundle = com.tencent.mm.kernel.h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    Object localObject = paramBundle.aHp().j(ar.a.VDu);
    paramBundle = (Bundle)localObject;
    if (!(localObject instanceof String)) {
      paramBundle = null;
    }
    localObject = (String)paramBundle;
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.GKT = paramBundle;
    paramBundle = com.tencent.mm.kernel.h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    int i = paramBundle.aHp().getInt(ar.a.VDA, 0);
    Log.i(this.TAG, "curSuffix %s, suffixVersion %d", new Object[] { this.GKT, Integer.valueOf(i) });
    if ((i == 0) && (LocaleUtil.isChineseAppLang()))
    {
      paramBundle = this.GKT;
      if (paramBundle != null) {
        this.GKT = "的".concat(String.valueOf(paramBundle));
      }
    }
    paramBundle = this.GKT;
    if (paramBundle != null)
    {
      localObject = this.GKU;
      if (localObject != null) {
        ((MMClearEditText)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.GKX, (CharSequence)paramBundle));
      }
      localObject = this.GKU;
      if (localObject != null) {
        ((MMClearEditText)localObject).setSelection(paramBundle.length());
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label687;
      }
      i = 1;
      if (i == 0) {
        break label692;
      }
      paramBundle = this.GKS;
      if (paramBundle != null) {
        paramBundle.setSmileySendButtonEnable(true);
      }
    }
    for (;;)
    {
      paramBundle = this.GKU;
      if (paramBundle != null) {
        paramBundle.addTextChangedListener((TextWatcher)this.GKV);
      }
      paramBundle = com.tencent.mm.kernel.h.ae(n.class);
      p.j(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
      ((n)paramBundle).eRY().a(222, (h.b)this);
      setOnDismissListener((DialogInterface.OnDismissListener)new h(this));
      paramBundle = new jf();
      paramBundle.Am(String.valueOf(cm.bfE()));
      paramBundle.nl(1);
      paramBundle.ama();
      paramBundle.nm(0);
      paramBundle.bpa();
      localObject = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)paramBundle);
      setOnCancelListener((DialogInterface.OnCancelListener)i.GLb);
      GKY = (b)this;
      paramBundle = this.GKS;
      if (paramBundle != null) {
        paramBundle.setMMEditText((com.tencent.mm.ui.widget.cedit.api.c)this.GKU);
      }
      paramBundle = this.GKS;
      if (paramBundle != null) {
        paramBundle.setInputComponentListener((EmojiPanelInputComponent.a)this);
      }
      paramBundle = this.GKS;
      if (paramBundle == null) {
        break label709;
      }
      paramBundle.setVisibility(4);
      AppMethodBeat.o(186508);
      return;
      label687:
      i = 0;
      break;
      label692:
      paramBundle = this.GKS;
      if (paramBundle != null) {
        paramBundle.setSmileySendButtonEnable(false);
      }
    }
    label709:
    AppMethodBeat.o(186508);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(186518);
    p.k(paramKeyEvent, "event");
    if (paramInt == 4)
    {
      paramKeyEvent = this.GKS;
      if ((paramKeyEvent != null) && (paramKeyEvent.aDI() == true))
      {
        paramKeyEvent = this.GKS;
        if (paramKeyEvent != null) {
          paramKeyEvent.aDK();
        }
        AppMethodBeat.o(186518);
        return true;
      }
      dismiss();
      AppMethodBeat.o(186518);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(186518);
    return bool;
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(186512);
    Object localObject = this.GKX.getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(186512);
      throw ((Throwable)localObject);
    }
    ((InputMethodManager)localObject).showSoftInput((View)this.GKU, 0);
    AppMethodBeat.o(186512);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$Companion;", "", "()V", "patSettingDialog", "Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;", "getPatSettingDialog", "()Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;", "setPatSettingDialog", "(Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;)V", "plugin-patmsg_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "Landroid/text/TextWatcher;", "(Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;)V", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-patmsg_release"})
  public final class b
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(186542);
      Object localObject1 = this.GLa.GKU;
      if (localObject1 != null) {
        ((MMClearEditText)localObject1).removeTextChangedListener((TextWatcher)this.GLa.GKV);
      }
      localObject1 = String.valueOf(paramEditable);
      Object localObject2 = this.GLa.GKU;
      int i;
      int j;
      if (localObject2 != null)
      {
        localObject2 = ((MMClearEditText)localObject2).getPaint();
        if (localObject2 != null)
        {
          i = (int)((TextPaint)localObject2).getTextSize();
          localObject2 = new com.tencent.mm.plugin.emoji.e((String)localObject1, i);
          j = ((com.tencent.mm.plugin.emoji.e)localObject2).a(g.a.XSu);
          Log.i(this.GLa.TAG, "afterTextChanged inputCount:".concat(String.valueOf(j)));
          localObject1 = String.valueOf(paramEditable);
          if (j <= this.GLa.GKR) {
            break label516;
          }
          paramEditable = ((com.tencent.mm.plugin.emoji.e)localObject2).b(this.GLa.GKR, g.a.XSu);
          localObject1 = this.GLa.nmi;
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)this.GLa.GKX.getString(d.f.pat_suffix_modify_limit_tip, new Object[] { Integer.valueOf(this.GLa.GKR / 2) }));
          }
          localObject1 = this.GLa.nmi;
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(com.tencent.mm.ci.a.w(this.GLa.GKX, d.b.red_text_color));
          }
          localObject1 = this.GLa.nmi;
          if (localObject1 != null) {
            ((TextView)localObject1).performHapticFeedback(3, 2);
          }
          localObject1 = this.GLa.GKU;
          if (localObject1 != null)
          {
            localObject2 = this.GLa.GKX;
            CharSequence localCharSequence = (CharSequence)paramEditable;
            Object localObject3 = this.GLa.GKU;
            if (localObject3 == null) {
              break label506;
            }
            localObject3 = ((MMClearEditText)localObject3).getPaint();
            if (localObject3 == null) {
              break label506;
            }
            i = (int)((TextPaint)localObject3).getTextSize();
            label316:
            ((MMClearEditText)localObject1).setText(com.tencent.mm.ui.h.c.b.a((Context)localObject2, localCharSequence, i));
          }
          localObject1 = this.GLa.GKU;
          if (localObject1 != null)
          {
            localObject2 = this.GLa.GKU;
            if (localObject2 == null) {
              break label511;
            }
            localObject2 = ((MMClearEditText)localObject2).getText();
            if (localObject2 == null) {
              break label511;
            }
            i = ((Editable)localObject2).length();
            label377:
            ((MMClearEditText)localObject1).setSelection(i);
          }
          localObject1 = paramEditable;
          if (this.GLa.GKW.stopped())
          {
            this.GLa.GKW.startTimer(3000L);
            localObject1 = paramEditable;
          }
        }
      }
      for (;;)
      {
        paramEditable = this.GLa.GKU;
        if (paramEditable != null) {
          paramEditable.addTextChangedListener((TextWatcher)this.GLa.GKV);
        }
        paramEditable = this.GLa.findViewById(d.d.ok_btn);
        if (paramEditable != null) {
          paramEditable.setEnabled(p.h(localObject1, this.GLa.GKT) ^ true);
        }
        if (j <= 0) {
          break label624;
        }
        paramEditable = this.GLa.GKS;
        if (paramEditable == null) {
          break label618;
        }
        paramEditable.setSmileySendButtonEnable(true);
        AppMethodBeat.o(186542);
        return;
        i = 0;
        break;
        label506:
        i = 0;
        break label316;
        label511:
        i = 0;
        break label377;
        label516:
        if (j < this.GLa.GKR)
        {
          this.GLa.GKW.stopTimer();
          paramEditable = String.valueOf(paramEditable);
          localObject1 = this.GLa.nmi;
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)this.GLa.GKX.getString(d.f.pat_suffix_modify_tip));
          }
          localObject2 = this.GLa.nmi;
          localObject1 = paramEditable;
          if (localObject2 != null)
          {
            ((TextView)localObject2).setTextColor(com.tencent.mm.ci.a.w(this.GLa.GKX, d.b.desc_text_color));
            localObject1 = paramEditable;
          }
        }
      }
      label618:
      AppMethodBeat.o(186542);
      return;
      label624:
      paramEditable = this.GLa.GKS;
      if (paramEditable != null)
      {
        paramEditable.setSmileySendButtonEnable(false);
        AppMethodBeat.o(186542);
        return;
      }
      AppMethodBeat.o(186542);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements MTimerHandler.CallBack
  {
    c(b paramb) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(186604);
      Log.i(this.GLa.TAG, "errorTimeHandler callback");
      TextView localTextView = (TextView)this.GLa.findViewById(d.d.pat_suffix_hint_tv);
      if (localTextView != null) {
        localTextView.setText((CharSequence)this.GLa.GKX.getString(d.f.pat_suffix_modify_tip));
      }
      if (localTextView != null) {
        localTextView.setTextColor(com.tencent.mm.ci.a.w(this.GLa.GKX, d.b.desc_text_color));
      }
      AppMethodBeat.o(186604);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(b paramb) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(186743);
      this.GLa.cancel();
      AppMethodBeat.o(186743);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186605);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.GLa.cancel();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(186605);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(186582);
      this.GLa.showVKB();
      AppMethodBeat.o(186582);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186395);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = (EditText)this.GLa.findViewById(d.d.pat_suffix_edit);
      if (localObject != null)
      {
        paramView = this.GLa;
        localObject = ((EditText)localObject).getText();
        p.j(localObject, "it.text");
        b.a(paramView, (CharSequence)localObject);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(186395);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class h
    implements DialogInterface.OnDismissListener
  {
    h(b paramb) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(186458);
      paramDialogInterface = b.GKZ;
      b.fna();
      this.GLa.GKW.stopTimer();
      paramDialogInterface = com.tencent.mm.kernel.h.ae(n.class);
      p.j(paramDialogInterface, "MMKernel.service(IMessengerStorage::class.java)");
      ((n)paramDialogInterface).eRY().b(222, (h.b)this.GLa);
      paramDialogInterface = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramDialogInterface = (diw)a.a.c(this.GLa.GKX, 4, diw.class);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.TQp = 0;
        AppMethodBeat.o(186458);
        return;
      }
      AppMethodBeat.o(186458);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class i
    implements DialogInterface.OnCancelListener
  {
    public static final i GLb;
    
    static
    {
      AppMethodBeat.i(186768);
      GLb = new i();
      AppMethodBeat.o(186768);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(186761);
      paramDialogInterface = new jf();
      paramDialogInterface.Am(String.valueOf(cm.bfE()));
      paramDialogInterface.nl(3);
      paramDialogInterface.ama();
      paramDialogInterface.nm(0);
      paramDialogInterface.bpa();
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)paramDialogInterface);
      AppMethodBeat.o(186761);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.b
 * JD-Core Version:    0.7.0.1
 */