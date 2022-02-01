package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.content.DialogInterface;
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
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.lp;
import com.tencent.mm.emoji.view.EmojiPanelInputComponent;
import com.tencent.mm.emoji.view.EmojiPanelInputComponent.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.d.b;
import com.tencent.mm.plugin.patmsg.d.d;
import com.tencent.mm.plugin.patmsg.d.e;
import com.tencent.mm.plugin.patmsg.d.f;
import com.tencent.mm.plugin.patmsg.d.g;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.dpx;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.ebg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMClearEditText;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent$InputComponentListener;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "dialogContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "PAT_SUFFIX_LENGTH_LIMIT", "", "getPAT_SUFFIX_LENGTH_LIMIT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "curSuffix", "getCurSuffix", "setCurSuffix", "(Ljava/lang/String;)V", "getDialogContext", "()Landroid/content/Context;", "setDialogContext", "errorTimeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getErrorTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "hintTv", "Landroid/widget/TextView;", "getHintTv", "()Landroid/widget/TextView;", "setHintTv", "(Landroid/widget/TextView;)V", "inputComponent", "Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;", "getInputComponent", "()Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;", "setInputComponent", "(Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;)V", "suffixET", "Lcom/tencent/mm/ui/widget/MMClearEditText;", "getSuffixET", "()Lcom/tencent/mm/ui/widget/MMClearEditText;", "setSuffixET", "(Lcom/tencent/mm/ui/widget/MMClearEditText;)V", "textWatcher", "Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "getTextWatcher", "()Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismiss", "", "doModifyPatSuffixScene", "suffix", "", "hideVKB", "initContentView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onOpLogResult", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "showVKB", "Companion", "PatTextWatcher", "plugin-patmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends androidx.appcompat.app.e
  implements EmojiPanelInputComponent.a, h.b
{
  public static final b.a MHL;
  private static b MHT;
  Context MHM;
  final int MHN;
  EmojiPanelInputComponent MHO;
  String MHP;
  MMClearEditText MHQ;
  final b MHR;
  final MTimerHandler MHS;
  final String TAG;
  TextView qjr;
  private w tipDialog;
  
  static
  {
    AppMethodBeat.i(266454);
    MHL = new b.a((byte)0);
    AppMethodBeat.o(266454);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, d.g.PatSuffixSettingDialog);
    AppMethodBeat.i(266403);
    this.MHM = paramContext;
    this.TAG = "MicroMsg.Pat.PatSuffixSettingDialog";
    this.MHN = 20;
    this.MHR = new b();
    this.MHS = new MTimerHandler(Looper.getMainLooper(), new b..ExternalSyntheticLambda5(this), false);
    AppMethodBeat.o(266403);
  }
  
  private static final void A(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(266447);
    paramDialogInterface = new lp();
    paramDialogInterface.ux(String.valueOf(cn.bDw()));
    paramDialogInterface.ilm = 3;
    paramDialogInterface.imW = 3;
    paramDialogInterface.inj = 0;
    paramDialogInterface.bMH();
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.agsX;
    com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)paramDialogInterface);
    AppMethodBeat.o(266447);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(266431);
    s.u(paramb, "this$0");
    paramb.showVKB();
    AppMethodBeat.o(266431);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(266441);
    s.u(paramb, "this$0");
    MHT = null;
    paramb.MHS.stopTimer();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaT().b(222, (h.b)paramb);
    paramDialogInterface = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramb = (ebg)a.a.c(paramb.MHM, 4, ebg.class);
    if (paramb != null) {
      paramb.abgO = 0;
    }
    AppMethodBeat.o(266441);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(266425);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.cancel();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(266425);
  }
  
  private static final boolean a(b paramb, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(266423);
    s.u(paramb, "this$0");
    paramb.cancel();
    AppMethodBeat.o(266423);
    return true;
  }
  
  private final void ap(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(266414);
    dpx localdpx = new dpx();
    paramCharSequence = Util.escapeStringForUCC(paramCharSequence.toString());
    s.s(paramCharSequence, "escapeStringForUCC(suffix.toString())");
    paramCharSequence = (CharSequence)paramCharSequence;
    int i = paramCharSequence.length() - 1;
    int k = 0;
    int j = 0;
    while (j <= i)
    {
      int m;
      if (k == 0)
      {
        m = j;
        label62:
        if (s.compare(paramCharSequence.charAt(m), 32) > 0) {
          break label103;
        }
        m = 1;
      }
      for (;;)
      {
        if (k == 0)
        {
          if (m == 0)
          {
            k = 1;
            break;
            m = i;
            break label62;
            label103:
            m = 0;
            continue;
          }
          j += 1;
          break;
        }
      }
      if (m == 0) {
        break;
      }
      i -= 1;
    }
    localdpx.aaWy = paramCharSequence.subSequence(j, i + 1).toString();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaT().b((k.b)new k.a(222, (com.tencent.mm.bx.a)localdpx));
    this.tipDialog = k.a(this.MHM, this.MHM.getString(d.f.modify_ing), false, null);
    AppMethodBeat.o(266414);
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(266437);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramView = (EditText)paramb.findViewById(d.d.pat_suffix_edit);
    if (paramView != null)
    {
      paramView = paramView.getText();
      s.s(paramView, "it.text");
      paramb.ap((CharSequence)paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(266437);
  }
  
  private static final boolean b(b paramb)
  {
    AppMethodBeat.i(266451);
    s.u(paramb, "this$0");
    Log.i(paramb.TAG, "errorTimeHandler callback");
    TextView localTextView = (TextView)paramb.findViewById(d.d.pat_suffix_hint_tv);
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramb.MHM.getString(d.f.pat_suffix_modify_tip));
    }
    if (localTextView != null) {
      localTextView.setTextColor(com.tencent.mm.cd.a.w(paramb.MHM, d.b.desc_text_color));
    }
    AppMethodBeat.o(266451);
    return false;
  }
  
  public final void a(int paramInt, dzc paramdzc, k.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(266482);
    String str2 = this.TAG;
    Object localObject1;
    String str1;
    if (paramdzc == null)
    {
      localObject1 = null;
      if (paramdzc != null) {
        break label193;
      }
      str1 = null;
      label29:
      Log.i(str2, "ret:%d, content:%s, title:%s", new Object[] { Integer.valueOf(paramInt), localObject1, str1 });
      localObject1 = this.tipDialog;
      if (localObject1 != null) {
        ((w)localObject1).dismiss();
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new lp();
        ((lp)localObject1).ux(String.valueOf(cn.bDw()));
        ((lp)localObject1).ilm = 2;
        ((lp)localObject1).imW = 3;
        if (paramInt != 0) {
          break label370;
        }
        k.cZ(this.MHM, this.MHM.getString(d.f.app_modify_success));
        if (paramb != null) {
          break label202;
        }
        paramdzc = null;
        if (paramdzc != null) {
          break label210;
        }
        paramdzc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ModPatSuffixOplog");
        AppMethodBeat.o(266482);
        throw paramdzc;
      }
      catch (Exception paramdzc)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramdzc, "", new Object[0]);
        AppMethodBeat.o(266482);
        return;
      }
      localObject1 = paramdzc.nUB;
      break;
      label193:
      str1 = paramdzc.hAP;
      break label29;
      label202:
      paramdzc = paramb.KRu;
    }
    label210:
    paramdzc = (dpx)paramdzc;
    paramb = com.tencent.mm.kernel.h.baE().ban().get(at.a.adgr, null);
    if (paramb == null)
    {
      paramdzc = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(266482);
      throw paramdzc;
    }
    if (!s.p(Util.nullAsNil((String)paramb), paramdzc.aaWy)) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgx, Integer.valueOf(2));
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adgr, paramdzc.aaWy);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adgz, Long.valueOf(cn.bDw()));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adgA, Integer.valueOf(0));
    ((lp)localObject1).inj = 0;
    dismiss();
    ((lp)localObject1).bMH();
    paramdzc = com.tencent.mm.util.c.agsX;
    com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject1);
    AppMethodBeat.o(266482);
    return;
    label370:
    if (paramdzc == null)
    {
      paramb = null;
      label376:
      if (Util.isNullOrNil(paramb)) {
        break label437;
      }
      paramb = this.MHM;
      if (paramdzc != null) {
        break label429;
      }
      paramdzc = localObject2;
      k.c(paramb, paramdzc, this.MHM.getString(d.f.app_modify_failed), true);
    }
    for (;;)
    {
      label395:
      ((lp)localObject1).inj = paramInt;
      break;
      paramb = paramdzc.nUB;
      break label376;
      label429:
      paramdzc = paramdzc.nUB;
      break label395;
      label437:
      k.s(this.MHM, d.f.app_err_system_busy_tip, d.f.app_modify_failed);
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(266479);
    EmojiPanelInputComponent localEmojiPanelInputComponent = this.MHO;
    if (localEmojiPanelInputComponent != null) {
      localEmojiPanelInputComponent.setVisibility(4);
    }
    localEmojiPanelInputComponent = this.MHO;
    if (localEmojiPanelInputComponent != null) {
      localEmojiPanelInputComponent.release();
    }
    hideVKB();
    super.dismiss();
    AppMethodBeat.o(266479);
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(266477);
    Object localObject = this.MHM.getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(266477);
      throw ((Throwable)localObject);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)localObject;
    localObject = this.MHQ;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((MMClearEditText)localObject).getWindowToken())
    {
      localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
      AppMethodBeat.o(266477);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(266474);
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
    paramBundle = LayoutInflater.from(this.MHM).inflate(d.e.pat_suffix_setting_dialog, null, false);
    s.s(paramBundle, "from(dialogContext).infl…ting_dialog, null, false)");
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    this.MHO = ((EmojiPanelInputComponent)findViewById(d.d.input_component));
    this.MHQ = ((MMClearEditText)findViewById(d.d.pat_suffix_edit));
    this.qjr = ((TextView)findViewById(d.d.pat_suffix_hint_tv));
    paramBundle.findViewById(d.d.empty_area_view).setOnTouchListener(new b..ExternalSyntheticLambda4(this));
    paramBundle.findViewById(d.d.close_btn).setOnClickListener(new b..ExternalSyntheticLambda3(this));
    setCancelable(true);
    paramBundle = (EditText)findViewById(d.d.pat_suffix_edit);
    if (paramBundle != null) {
      paramBundle.requestFocus();
    }
    com.tencent.threadpool.h.ahAA.o(new b..ExternalSyntheticLambda6(this), 128L);
    paramBundle = findViewById(d.d.ok_btn);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new b..ExternalSyntheticLambda2(this));
    }
    paramBundle = com.tencent.mm.kernel.h.baE().ban().get(at.a.adgr, null);
    Object localObject;
    int i;
    if ((paramBundle instanceof String))
    {
      paramBundle = (String)paramBundle;
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = "";
      }
      this.MHP = ((String)localObject);
      i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adgx, 0);
      Log.i(this.TAG, "curSuffix %s, suffixVersion %d", new Object[] { this.MHP, Integer.valueOf(i) });
      if ((i == 0) && (LocaleUtil.isChineseAppLang()))
      {
        paramBundle = this.MHP;
        if (paramBundle != null) {
          this.MHP = s.X("的", paramBundle);
        }
      }
      paramBundle = this.MHP;
      if (paramBundle != null)
      {
        localObject = this.MHQ;
        if (localObject != null) {
          ((MMClearEditText)localObject).setText((CharSequence)p.b(this.MHM, (CharSequence)paramBundle));
        }
        localObject = this.MHQ;
        if (localObject != null) {
          ((MMClearEditText)localObject).setSelection(paramBundle.length());
        }
        if (((CharSequence)paramBundle).length() <= 0) {
          break label638;
        }
        i = 1;
        label438:
        if (i == 0) {
          break label643;
        }
        paramBundle = this.MHO;
        if (paramBundle != null) {
          paramBundle.setSmileySendButtonEnable(true);
        }
      }
    }
    for (;;)
    {
      paramBundle = this.MHQ;
      if (paramBundle != null) {
        paramBundle.addTextChangedListener((TextWatcher)this.MHR);
      }
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaT().a(222, (h.b)this);
      setOnDismissListener(new b..ExternalSyntheticLambda1(this));
      paramBundle = new lp();
      paramBundle.ux(String.valueOf(cn.bDw()));
      paramBundle.ilm = 1;
      paramBundle.imW = 3;
      paramBundle.inj = 0;
      paramBundle.bMH();
      localObject = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)paramBundle);
      setOnCancelListener(b..ExternalSyntheticLambda0.INSTANCE);
      MHT = this;
      paramBundle = this.MHO;
      if (paramBundle != null) {
        paramBundle.setMMEditText((com.tencent.mm.ui.widget.cedit.api.c)this.MHQ);
      }
      paramBundle = this.MHO;
      if (paramBundle != null) {
        paramBundle.setInputComponentListener((EmojiPanelInputComponent.a)this);
      }
      paramBundle = this.MHO;
      if (paramBundle != null) {
        paramBundle.setVisibility(4);
      }
      AppMethodBeat.o(266474);
      return;
      paramBundle = null;
      break;
      label638:
      i = 0;
      break label438;
      label643:
      paramBundle = this.MHO;
      if (paramBundle != null) {
        paramBundle.setSmileySendButtonEnable(false);
      }
    }
  }
  
  public final void onInputPanelChange(boolean paramBoolean, int paramInt) {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(266484);
    s.u(paramKeyEvent, "event");
    if (paramInt == 4)
    {
      paramKeyEvent = this.MHO;
      if ((paramKeyEvent != null) && (paramKeyEvent.aWG() == true)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        paramKeyEvent = this.MHO;
        if (paramKeyEvent != null) {
          paramKeyEvent.aWI();
        }
        AppMethodBeat.o(266484);
        return true;
      }
      dismiss();
      AppMethodBeat.o(266484);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(266484);
    return bool;
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(266476);
    Object localObject = this.MHM.getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(266476);
      throw ((Throwable)localObject);
    }
    ((InputMethodManager)localObject).showSoftInput((View)this.MHQ, 0);
    AppMethodBeat.o(266476);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog$PatTextWatcher;", "Landroid/text/TextWatcher;", "(Lcom/tencent/mm/plugin/patmsg/ui/PatSuffixSettingDialog;)V", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-patmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements TextWatcher
  {
    public b()
    {
      AppMethodBeat.i(266430);
      AppMethodBeat.o(266430);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(266443);
      Object localObject1 = this.MHU.MHQ;
      if (localObject1 != null) {
        ((MMClearEditText)localObject1).removeTextChangedListener((TextWatcher)this.MHU.MHR);
      }
      localObject1 = String.valueOf(paramEditable);
      Object localObject2 = this.MHU.MHQ;
      int i;
      int j;
      Object localObject3;
      if (localObject2 == null)
      {
        i = 0;
        localObject2 = new com.tencent.mm.plugin.emoji.e((String)localObject1, i);
        j = ((com.tencent.mm.plugin.emoji.e)localObject2).a(g.a.afII);
        Log.i(this.MHU.TAG, s.X("afterTextChanged inputCount:", Integer.valueOf(j)));
        localObject1 = String.valueOf(paramEditable);
        if (j <= this.MHU.MHN) {
          break label537;
        }
        paramEditable = ((com.tencent.mm.plugin.emoji.e)localObject2).b(this.MHU.MHN, g.a.afII);
        localObject1 = this.MHU.qjr;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)this.MHU.MHM.getString(d.f.pat_suffix_modify_limit_tip, new Object[] { Integer.valueOf(this.MHU.MHN / 2) }));
        }
        localObject1 = this.MHU.qjr;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(com.tencent.mm.cd.a.w(this.MHU.MHM, d.b.red_text_color));
        }
        localObject1 = this.MHU.qjr;
        if (localObject1 != null) {
          ((TextView)localObject1).performHapticFeedback(3, 2);
        }
        localObject1 = this.MHU.MHQ;
        if (localObject1 != null)
        {
          localObject2 = this.MHU.MHM;
          CharSequence localCharSequence = (CharSequence)paramEditable;
          localObject3 = this.MHU.MHQ;
          if (localObject3 != null) {
            break label482;
          }
          i = 0;
          label282:
          ((MMClearEditText)localObject1).setText(com.tencent.mm.ui.i.c.b.a((Context)localObject2, localCharSequence, i));
        }
        localObject1 = this.MHU.MHQ;
        if (localObject1 != null)
        {
          localObject2 = this.MHU.MHQ;
          if (localObject2 != null) {
            break label509;
          }
          i = 0;
          label325:
          ((MMClearEditText)localObject1).setSelection(i);
        }
        localObject1 = paramEditable;
        if (this.MHU.MHS.stopped())
        {
          this.MHU.MHS.startTimer(3000L);
          localObject1 = paramEditable;
        }
        label363:
        paramEditable = this.MHU.MHQ;
        if (paramEditable != null) {
          paramEditable.addTextChangedListener((TextWatcher)this.MHU.MHR);
        }
        paramEditable = this.MHU.findViewById(d.d.ok_btn);
        if (paramEditable != null) {
          if (s.p(localObject1, this.MHU.MHP)) {
            break label639;
          }
        }
      }
      label482:
      label509:
      label639:
      for (boolean bool = true;; bool = false)
      {
        paramEditable.setEnabled(bool);
        if (j <= 0) {
          break label645;
        }
        paramEditable = this.MHU.MHO;
        if (paramEditable == null) {
          break label662;
        }
        paramEditable.setSmileySendButtonEnable(true);
        AppMethodBeat.o(266443);
        return;
        localObject2 = ((MMClearEditText)localObject2).getPaint();
        if (localObject2 == null)
        {
          i = 0;
          break;
        }
        i = (int)((TextPaint)localObject2).getTextSize();
        break;
        localObject3 = ((MMClearEditText)localObject3).getPaint();
        if (localObject3 == null)
        {
          i = 0;
          break label282;
        }
        i = (int)((TextPaint)localObject3).getTextSize();
        break label282;
        localObject2 = ((MMClearEditText)localObject2).getText();
        if (localObject2 == null)
        {
          i = 0;
          break label325;
        }
        i = ((Editable)localObject2).length();
        break label325;
        if (j >= this.MHU.MHN) {
          break label363;
        }
        this.MHU.MHS.stopTimer();
        paramEditable = String.valueOf(paramEditable);
        localObject1 = this.MHU.qjr;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)this.MHU.MHM.getString(d.f.pat_suffix_modify_tip));
        }
        localObject2 = this.MHU.qjr;
        localObject1 = paramEditable;
        if (localObject2 == null) {
          break label363;
        }
        ((TextView)localObject2).setTextColor(com.tencent.mm.cd.a.w(this.MHU.MHM, d.b.desc_text_color));
        localObject1 = paramEditable;
        break label363;
      }
      label537:
      paramEditable = this.MHU.MHO;
      label645:
      if (paramEditable != null) {
        paramEditable.setSmileySendButtonEnable(false);
      }
      label662:
      AppMethodBeat.o(266443);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.b
 * JD-Core Version:    0.7.0.1
 */