package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ha;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;", "Landroid/support/v7/app/AppCompatDialog;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "dialogContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "PAT_SUFFIX_LENGTH_LIMIT", "", "getPAT_SUFFIX_LENGTH_LIMIT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "curSuffix", "getCurSuffix", "setCurSuffix", "(Ljava/lang/String;)V", "getDialogContext", "()Landroid/content/Context;", "setDialogContext", "errorTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getErrorTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "hintTv", "Landroid/widget/TextView;", "getHintTv", "()Landroid/widget/TextView;", "setHintTv", "(Landroid/widget/TextView;)V", "suffixET", "Landroid/widget/EditText;", "getSuffixET", "()Landroid/widget/EditText;", "setSuffixET", "(Landroid/widget/EditText;)V", "textWatcher", "Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "getTextWatcher", "()Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismiss", "", "doModifyPatSuffixScene", "suffix", "", "hideVKB", "initContentView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "onOpLogResult", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "showVKB", "Companion", "PatTextWatcher", "plugin-patmsg_release"})
public final class b
  extends android.support.v7.app.e
  implements h.a, com.tencent.mm.ui.widget.b.a
{
  private static b ARM;
  public static final a ARN;
  final int ARG;
  String ARH;
  EditText ARI;
  final b ARJ;
  final MTimerHandler ARK;
  Context ARL;
  final String TAG;
  TextView kuu;
  private q tipDialog;
  
  static
  {
    AppMethodBeat.i(207031);
    ARN = new a((byte)0);
    AppMethodBeat.o(207031);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, 2131821238);
    AppMethodBeat.i(207030);
    this.ARL = paramContext;
    this.TAG = "MicroMsg.Pat.PatSuffixSettingDialog";
    this.ARG = 16;
    this.ARJ = new b();
    this.ARK = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new c(this), false);
    AppMethodBeat.o(207030);
  }
  
  public final void a(int paramInt, cxl paramcxl, k.b paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(207029);
    String str = this.TAG;
    Object localObject1;
    Object localObject2;
    if (paramcxl != null)
    {
      localObject1 = paramcxl.iAc;
      if (paramcxl == null) {
        break label200;
      }
      localObject2 = paramcxl.Title;
      label35:
      Log.i(str, "ret:%d, content:%s, title:%s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2 });
      localObject1 = this.tipDialog;
      if (localObject1 != null) {
        ((q)localObject1).dismiss();
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new ha();
        ((ha)localObject1).uP(String.valueOf(cl.aWA()));
        ((ha)localObject1).lo(2);
        ((ha)localObject1).agT();
        if (paramInt != 0) {
          break label418;
        }
        com.tencent.mm.ui.base.h.cA(this.ARL, this.ARL.getString(2131755898));
        if (paramb == null) {
          break label206;
        }
        paramcxl = paramb.eiR();
        if (paramcxl != null) {
          break label211;
        }
        paramcxl = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ModPatSuffixOplog");
        AppMethodBeat.o(207029);
        throw paramcxl;
      }
      catch (Exception paramcxl)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramcxl, "", new Object[0]);
        AppMethodBeat.o(207029);
        return;
      }
      localObject1 = null;
      break;
      label200:
      localObject2 = null;
      break label35;
      label206:
      paramcxl = null;
    }
    label211:
    paramcxl = (cqa)paramcxl;
    paramb = g.aAh();
    p.g(paramb, "MMKernel.storage()");
    paramb = paramb.azQ().i(ar.a.Oob);
    if (paramb == null)
    {
      paramcxl = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(207029);
      throw paramcxl;
    }
    if ((p.j(Util.nullAsNil((String)paramb), paramcxl.MvT) ^ true))
    {
      paramb = g.aAh();
      p.g(paramb, "MMKernel.storage()");
      paramb.azQ().set(ar.a.Ooh, Integer.valueOf(2));
    }
    paramb = g.aAh();
    p.g(paramb, "MMKernel.storage()");
    paramb.azQ().set(ar.a.Oob, paramcxl.MvT);
    paramcxl = g.aAh();
    p.g(paramcxl, "MMKernel.storage()");
    paramcxl.azQ().set(ar.a.Ooj, Long.valueOf(cl.aWA()));
    paramcxl = g.aAh();
    p.g(paramcxl, "MMKernel.storage()");
    paramcxl.azQ().set(ar.a.Ook, Integer.valueOf(0));
    ((ha)localObject1).lp(0);
    dismiss();
    ((ha)localObject1).bfK();
    paramcxl = com.tencent.mm.util.b.QYu;
    com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject1);
    AppMethodBeat.o(207029);
    return;
    label418:
    if (paramcxl != null) {}
    for (paramb = paramcxl.iAc;; paramb = null)
    {
      if (!Util.isNullOrNil(paramb))
      {
        localObject2 = this.ARL;
        paramb = localObject3;
        if (paramcxl != null) {
          paramb = paramcxl.iAc;
        }
        com.tencent.mm.ui.base.h.X((Context)localObject2, paramb, this.ARL.getString(2131755897));
      }
      for (;;)
      {
        ((ha)localObject1).lp(paramInt);
        break;
        com.tencent.mm.ui.base.h.n(this.ARL, 2131755804, 2131755897);
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(207028);
    Object localObject = this.ARL.getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(207028);
      throw ((Throwable)localObject);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)localObject;
    localObject = this.ARI;
    if (localObject != null) {}
    for (localObject = ((EditText)localObject).getWindowToken();; localObject = null)
    {
      localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
      super.dismiss();
      AppMethodBeat.o(207028);
      return;
    }
  }
  
  public final void f(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(207027);
    if (paramBoolean)
    {
      localView = findViewById(2131302671);
      if (localView != null)
      {
        localView.setPadding(0, 0, 0, paramInt);
        AppMethodBeat.o(207027);
        return;
      }
      AppMethodBeat.o(207027);
      return;
    }
    View localView = findViewById(2131302671);
    if (localView != null)
    {
      localView.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(207027);
      return;
    }
    AppMethodBeat.o(207027);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(207026);
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
      paramBundle.setWindowAnimations(2131820793);
    }
    paramBundle = LayoutInflater.from(this.ARL).inflate(2131495898, null, false);
    p.g(paramBundle, "LayoutInflater.from(dial…ting_dialog, null, false)");
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    this.ARI = ((EditText)findViewById(2131305794));
    this.kuu = ((TextView)findViewById(2131305795));
    paramBundle.findViewById(2131300079).setOnTouchListener((View.OnTouchListener)new d(this));
    paramBundle.findViewById(2131298770).setOnClickListener((View.OnClickListener)new e(this));
    setCancelable(true);
    paramBundle = (EditText)findViewById(2131305794);
    if (paramBundle != null) {
      paramBundle.requestFocus();
    }
    com.tencent.f.h.RTc.n((Runnable)new f(this), 128L);
    paramBundle = (InputPanelLinearLayout)findViewById(2131302671);
    if (paramBundle != null) {
      paramBundle.setExternalListener((com.tencent.mm.ui.widget.b.a)this);
    }
    paramBundle = findViewById(2131305592);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new g(this));
    }
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    Object localObject = paramBundle.azQ().i(ar.a.Oob);
    paramBundle = (Bundle)localObject;
    if (!(localObject instanceof String)) {
      paramBundle = null;
    }
    localObject = (String)paramBundle;
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.ARH = paramBundle;
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    int i = paramBundle.azQ().getInt(ar.a.Ooh, 0);
    Log.i(this.TAG, "curSuffix %s, suffixVersion %d", new Object[] { this.ARH, Integer.valueOf(i) });
    if ((i == 0) && (LocaleUtil.isChineseAppLang()))
    {
      paramBundle = this.ARH;
      if (paramBundle != null) {
        this.ARH = "的".concat(String.valueOf(paramBundle));
      }
    }
    paramBundle = this.ARH;
    if (paramBundle != null)
    {
      localObject = this.ARI;
      if (localObject != null) {
        ((EditText)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.ARL, (CharSequence)paramBundle));
      }
      localObject = this.ARI;
      if (localObject != null) {
        ((EditText)localObject).setSelection(paramBundle.length());
      }
    }
    paramBundle = this.ARI;
    if (paramBundle != null) {
      paramBundle.addTextChangedListener((TextWatcher)this.ARJ);
    }
    paramBundle = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).eis().a(222, (h.a)this);
    setOnDismissListener((DialogInterface.OnDismissListener)new h(this));
    paramBundle = new ha();
    paramBundle.uP(String.valueOf(cl.aWA()));
    paramBundle.lo(1);
    paramBundle.agT();
    paramBundle.lp(0);
    paramBundle.bfK();
    localObject = com.tencent.mm.util.b.QYu;
    com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)paramBundle);
    setOnCancelListener((DialogInterface.OnCancelListener)i.ARP);
    ARM = (b)this;
    AppMethodBeat.o(207026);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$Companion;", "", "()V", "patSettingDialog", "Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;", "getPatSettingDialog", "()Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;", "setPatSettingDialog", "(Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;)V", "plugin-patmsg_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "Landroid/text/TextWatcher;", "(Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;)V", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-patmsg_release"})
  public final class b
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(207017);
      Object localObject1 = this.ARO.ARI;
      if (localObject1 != null) {
        ((EditText)localObject1).removeTextChangedListener((TextWatcher)this.ARO.ARJ);
      }
      int i = f.a(String.valueOf(paramEditable), f.a.Qui);
      Log.i(this.ARO.TAG, "afterTextChanged inputCount:".concat(String.valueOf(i)));
      Object localObject2 = String.valueOf(paramEditable);
      if (i > this.ARO.ARG)
      {
        localObject1 = f.hm((String)localObject2, this.ARO.ARG);
        p.g(localObject1, "InputTextLengthFilter.su… PAT_SUFFIX_LENGTH_LIMIT)");
        TextView localTextView = this.ARO.kuu;
        if (localTextView != null) {
          localTextView.setText((CharSequence)this.ARO.ARL.getString(2131763817, new Object[] { Integer.valueOf(this.ARO.ARG / 2) }));
        }
        localTextView = this.ARO.kuu;
        if (localTextView != null) {
          localTextView.setTextColor(com.tencent.mm.cb.a.n(this.ARO.ARL, 2131100996));
        }
        localTextView = this.ARO.kuu;
        if (localTextView != null) {
          localTextView.performHapticFeedback(3, 2);
        }
        if (paramEditable != null) {
          paramEditable.replace(((String)localObject1).length(), ((String)localObject2).length(), (CharSequence)"");
        }
        paramEditable = (Editable)localObject1;
        if (this.ARO.ARK.stopped())
        {
          this.ARO.ARK.startTimer(3000L);
          paramEditable = (Editable)localObject1;
        }
      }
      for (;;)
      {
        localObject1 = this.ARO.ARI;
        if (localObject1 != null) {
          ((EditText)localObject1).addTextChangedListener((TextWatcher)this.ARO.ARJ);
        }
        localObject1 = this.ARO.findViewById(2131305592);
        if (localObject1 != null)
        {
          ((View)localObject1).setEnabled(p.j(paramEditable, this.ARO.ARH) ^ true);
          AppMethodBeat.o(207017);
          return;
          if (i < this.ARO.ARG)
          {
            this.ARO.ARK.stopTimer();
            localObject1 = String.valueOf(paramEditable);
            paramEditable = this.ARO.kuu;
            if (paramEditable != null) {
              paramEditable.setText((CharSequence)this.ARO.ARL.getString(2131763818));
            }
            localObject2 = this.ARO.kuu;
            paramEditable = (Editable)localObject1;
            if (localObject2 == null) {
              continue;
            }
            ((TextView)localObject2).setTextColor(com.tencent.mm.cb.a.n(this.ARO.ARL, 2131100245));
            paramEditable = (Editable)localObject1;
          }
        }
        else
        {
          AppMethodBeat.o(207017);
          return;
        }
        paramEditable = (Editable)localObject2;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements MTimerHandler.CallBack
  {
    c(b paramb) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(207018);
      Log.i(this.ARO.TAG, "errorTimeHandler callback");
      TextView localTextView = (TextView)this.ARO.findViewById(2131305795);
      if (localTextView != null) {
        localTextView.setText((CharSequence)this.ARO.ARL.getString(2131763818));
      }
      if (localTextView != null) {
        localTextView.setTextColor(com.tencent.mm.cb.a.n(this.ARO.ARL, 2131100245));
      }
      AppMethodBeat.o(207018);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(b paramb) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(207019);
      this.ARO.cancel();
      AppMethodBeat.o(207019);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(207020);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.ARO.cancel();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(207020);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(207021);
      Object localObject1 = this.ARO;
      Object localObject2 = ((b)localObject1).ARL.getSystemService("input_method");
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(207021);
        throw ((Throwable)localObject1);
      }
      ((InputMethodManager)localObject2).showSoftInput((View)((b)localObject1).ARI, 0);
      AppMethodBeat.o(207021);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(207022);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = (EditText)this.ARO.findViewById(2131305794);
      if (localObject != null)
      {
        paramView = this.ARO;
        localObject = ((EditText)localObject).getText();
        p.g(localObject, "it.text");
        b.a(paramView, (CharSequence)localObject);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(207022);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class h
    implements DialogInterface.OnDismissListener
  {
    h(b paramb) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(207023);
      paramDialogInterface = b.ARN;
      b.eBt();
      this.ARO.ARK.stopTimer();
      paramDialogInterface = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramDialogInterface, "MMKernel.service(IMessengerStorage::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.l)paramDialogInterface).eis().b(222, (h.a)this.ARO);
      paramDialogInterface = SecDataUIC.CWq;
      paramDialogInterface = (czj)SecDataUIC.a.c(this.ARO.ARL, 4, czj.class);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.MEF = 0;
        AppMethodBeat.o(207023);
        return;
      }
      AppMethodBeat.o(207023);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class i
    implements DialogInterface.OnCancelListener
  {
    public static final i ARP;
    
    static
    {
      AppMethodBeat.i(207025);
      ARP = new i();
      AppMethodBeat.o(207025);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(207024);
      paramDialogInterface = new ha();
      paramDialogInterface.uP(String.valueOf(cl.aWA()));
      paramDialogInterface.lo(3);
      paramDialogInterface.agT();
      paramDialogInterface.lp(0);
      paramDialogInterface.bfK();
      com.tencent.mm.util.b localb = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)paramDialogInterface);
      AppMethodBeat.o(207024);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.b
 * JD-Core Version:    0.7.0.1
 */