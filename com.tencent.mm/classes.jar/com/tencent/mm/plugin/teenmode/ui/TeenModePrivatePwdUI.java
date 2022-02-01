package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.v;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.threadpool.i;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TempSecureEditText;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI;", "Lcom/tencent/mm/ui/MMWizardActivity;", "()V", "mKBLayout", "Landroid/view/View;", "mKeyboard", "Lcom/tenpay/android/wechat/MyKeyboardWindow;", "passInput", "Lcom/tenpay/android/wechat/TempSecureEditText;", "getPassInput", "()Lcom/tenpay/android/wechat/TempSecureEditText;", "passInput$delegate", "Lkotlin/Lazy;", "process", "", "getProcess", "()I", "process$delegate", "scene", "getScene", "scene$delegate", "stepOne", "", "getStepOne", "()Z", "stepOne$delegate", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "HmacSHA256Encrypt", "", "text", "secretKey", "doClear", "", "doModify", "doVerify", "getEncryptBuf", "Lcom/tencent/mm/protobuf/ByteString;", "pwd", "", "getLayoutId", "hideErr", "hideKeyboardPushDownBtn", "hideTenpayKB", "jumpWebView", "url", "requestCode", "getA8Key", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "rawPass", "setEditFocusListener", "parent", "editMode", "isShowSysKB", "isShowFirstTime", "saveFocusChangeListener", "setKBMode", "showErr", "errMsg", "showTenpayKB", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TeenModePrivatePwdUI
  extends MMWizardActivity
{
  public static final TeenModePrivatePwdUI.a Tbi;
  private final j Tbj;
  private final j Tbk;
  private final j Tbl;
  private View mKBLayout;
  private MyKeyboardWindow mKeyboard;
  private final j pmx;
  private w tipDialog;
  
  static
  {
    AppMethodBeat.i(279238);
    Tbi = new TeenModePrivatePwdUI.a((byte)0);
    AppMethodBeat.o(279238);
  }
  
  public TeenModePrivatePwdUI()
  {
    AppMethodBeat.i(278986);
    this.Tbj = k.cm((kotlin.g.a.a)new g(this));
    this.Tbk = k.cm((kotlin.g.a.a)new i(this));
    this.pmx = k.cm((kotlin.g.a.a)new h(this));
    this.Tbl = k.cm((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(278986);
  }
  
  private static final void a(TextView paramTextView, TeenModePrivatePwdUI paramTeenModePrivatePwdUI, View paramView)
  {
    AppMethodBeat.i(279100);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextView);
    localb.cH(paramTeenModePrivatePwdUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTeenModePrivatePwdUI, "this$0");
    paramView = new Intent(paramTextView.getContext(), TeenModeVerifyPwdUI.class);
    localObject = new Intent(paramTextView.getContext(), SettingsTeenModeMain.class);
    MMWizardActivity.b(paramTextView.getContext(), paramView, (Intent)localObject);
    paramTeenModePrivatePwdUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279100);
  }
  
  private static final void a(TeenModePrivatePwdUI paramTeenModePrivatePwdUI)
  {
    AppMethodBeat.i(279094);
    kotlin.g.b.s.u(paramTeenModePrivatePwdUI, "this$0");
    paramTeenModePrivatePwdUI.finish();
    AppMethodBeat.o(279094);
  }
  
  private static final void a(TeenModePrivatePwdUI paramTeenModePrivatePwdUI, View paramView)
  {
    AppMethodBeat.i(279148);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTeenModePrivatePwdUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTeenModePrivatePwdUI, "this$0");
    paramTeenModePrivatePwdUI.hideTenpayKB();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279148);
  }
  
  private static final void a(TeenModePrivatePwdUI paramTeenModePrivatePwdUI, View paramView, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(279118);
    kotlin.g.b.s.u(paramTeenModePrivatePwdUI, "this$0");
    View localView = paramTeenModePrivatePwdUI.mKBLayout;
    Object localObject1 = localView;
    if (localView == null)
    {
      kotlin.g.b.s.bIx("mKBLayout");
      localObject1 = null;
    }
    if ((!((View)localObject1).isShown()) && (paramView.isShown())) {
      paramTeenModePrivatePwdUI.showTenpayKB();
    }
    paramTeenModePrivatePwdUI.setKBMode(paramInt);
    localObject1 = paramTeenModePrivatePwdUI.mKeyboard;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mKeyboard");
      localObject1 = localObject2;
    }
    while (paramView == null)
    {
      paramTeenModePrivatePwdUI = new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
      AppMethodBeat.o(279118);
      throw paramTeenModePrivatePwdUI;
    }
    ((MyKeyboardWindow)localObject1).setInputEditText((EditText)paramView);
    paramTeenModePrivatePwdUI = paramTeenModePrivatePwdUI.getContext().getSystemService("input_method");
    if (paramTeenModePrivatePwdUI == null)
    {
      paramTeenModePrivatePwdUI = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(279118);
      throw paramTeenModePrivatePwdUI;
    }
    ((InputMethodManager)paramTeenModePrivatePwdUI).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    AppMethodBeat.o(279118);
  }
  
  private static final void a(TeenModePrivatePwdUI paramTeenModePrivatePwdUI, boolean paramBoolean, int paramInt, TempSecureEditText paramTempSecureEditText, View paramView)
  {
    AppMethodBeat.i(279139);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTeenModePrivatePwdUI);
    localb.fv(paramBoolean);
    localb.sc(paramInt);
    localb.cH(paramTempSecureEditText);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTeenModePrivatePwdUI, "this$0");
    kotlin.g.b.s.u(paramTempSecureEditText, "$hintTv");
    localObject = paramTeenModePrivatePwdUI.mKBLayout;
    paramView = (View)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("mKBLayout");
      paramView = null;
    }
    if ((!paramView.isShown()) && (!paramBoolean))
    {
      paramTeenModePrivatePwdUI.showTenpayKB();
      paramTeenModePrivatePwdUI.setKBMode(paramInt);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279139);
      return;
      if (paramBoolean)
      {
        paramTeenModePrivatePwdUI.hideTenpayKB();
        paramTeenModePrivatePwdUI = paramTeenModePrivatePwdUI.getContext().getSystemService("input_method");
        if (paramTeenModePrivatePwdUI == null)
        {
          paramTeenModePrivatePwdUI = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
          AppMethodBeat.o(279139);
          throw paramTeenModePrivatePwdUI;
        }
        ((InputMethodManager)paramTeenModePrivatePwdUI).showSoftInput((View)paramTempSecureEditText, 0);
      }
    }
  }
  
  private static final void a(TeenModePrivatePwdUI paramTeenModePrivatePwdUI, boolean paramBoolean1, View.OnFocusChangeListener paramOnFocusChangeListener, int paramInt, TempSecureEditText paramTempSecureEditText, View paramView, boolean paramBoolean2)
  {
    AppMethodBeat.i(279133);
    kotlin.g.b.s.u(paramTeenModePrivatePwdUI, "this$0");
    kotlin.g.b.s.u(paramTempSecureEditText, "$hintTv");
    paramTeenModePrivatePwdUI.hideVKB();
    if ((paramView.isFocused()) && (!paramBoolean1))
    {
      paramTempSecureEditText = paramTeenModePrivatePwdUI.getContext().getSystemService("input_method");
      if (paramTempSecureEditText == null)
      {
        paramTeenModePrivatePwdUI = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(279133);
        throw paramTeenModePrivatePwdUI;
      }
      ((InputMethodManager)paramTempSecureEditText).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new MMHandler().postDelayed(new TeenModePrivatePwdUI..ExternalSyntheticLambda7(paramTeenModePrivatePwdUI, paramView, paramInt), 300L);
    }
    for (;;)
    {
      if (paramOnFocusChangeListener != null) {
        paramOnFocusChangeListener.onFocusChange(paramView, paramBoolean2);
      }
      AppMethodBeat.o(279133);
      return;
      new MMHandler().postDelayed(new TeenModePrivatePwdUI..ExternalSyntheticLambda8(paramTeenModePrivatePwdUI, paramBoolean1, paramTempSecureEditText), 200L);
    }
  }
  
  private static final void a(TeenModePrivatePwdUI paramTeenModePrivatePwdUI, boolean paramBoolean, TempSecureEditText paramTempSecureEditText)
  {
    AppMethodBeat.i(279127);
    kotlin.g.b.s.u(paramTeenModePrivatePwdUI, "this$0");
    kotlin.g.b.s.u(paramTempSecureEditText, "$hintTv");
    paramTeenModePrivatePwdUI.hideTenpayKB();
    if (paramBoolean)
    {
      paramTeenModePrivatePwdUI = paramTeenModePrivatePwdUI.getContext().getSystemService("input_method");
      if (paramTeenModePrivatePwdUI == null)
      {
        paramTeenModePrivatePwdUI = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(279127);
        throw paramTeenModePrivatePwdUI;
      }
      ((InputMethodManager)paramTeenModePrivatePwdUI).showSoftInput((View)paramTempSecureEditText, 0);
    }
    AppMethodBeat.o(279127);
  }
  
  private static final boolean a(TeenModePrivatePwdUI paramTeenModePrivatePwdUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(279113);
    kotlin.g.b.s.u(paramTeenModePrivatePwdUI, "this$0");
    paramTeenModePrivatePwdUI.setResult(0);
    paramTeenModePrivatePwdUI.finish();
    AppMethodBeat.o(279113);
    return true;
  }
  
  private final void atM(String paramString)
  {
    AppMethodBeat.i(279020);
    TextView localTextView = (TextView)findViewById(a.d.desc);
    localTextView.setText((CharSequence)paramString);
    localTextView.setVisibility(0);
    localTextView.setTextColor(localTextView.getResources().getColor(a.a.Red));
    AppMethodBeat.o(279020);
  }
  
  private static final void b(TextView paramTextView, TeenModePrivatePwdUI paramTeenModePrivatePwdUI, View paramView)
  {
    AppMethodBeat.i(279111);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextView);
    localb.cH(paramTeenModePrivatePwdUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTeenModePrivatePwdUI, "this$0");
    paramView = com.tencent.mm.plugin.expt.e.d.dNI().hx("clicfg_wxalitebff7a643e2eefdb070cb79979b6ddd7f_enable", "0");
    kotlin.g.b.s.s(paramView, "getInstance().getMulitEx…dd7f_enable\", \"0\", false)");
    int i;
    if (paramView.equals("1")) {
      if (((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).et("wxalitebff7a643e2eefdb070cb79979b6ddd7f") == null)
      {
        if (((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).fTU() == null) {
          ((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).fTS();
        }
        ((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).a("wxalitebff7a643e2eefdb070cb79979b6ddd7f", null);
        i = 0;
      }
    }
    for (;;)
    {
      if (i == 0) {
        paramTeenModePrivatePwdUI.bdn("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=parental/resetpassword");
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279111);
      return;
      paramView = new Bundle();
      paramView.putString("appId", "wxalitebff7a643e2eefdb070cb79979b6ddd7f");
      paramView.putInt("requestCode", 101);
      Log.i("MicroMsg.TeenModePrivatePwdUI", "open liteapp:" + "wxalitebff7a643e2eefdb070cb79979b6ddd7f" + ",page:" + "");
      ((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).a(paramTextView.getContext(), paramView, false, true, null);
      i = 1;
      continue;
      i = 0;
    }
  }
  
  private static com.tencent.mm.bx.b bdm(String paramString)
  {
    AppMethodBeat.i(279047);
    com.tencent.mm.kernel.h.baC();
    Log.i("MicroMsg.TeenModePrivatePwdUI", "getEncryptBuf, %s, %s", new Object[] { paramString, com.tencent.mm.kernel.b.aZs() });
    Object localObject = kotlin.n.d.UTF_8;
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(279047);
      throw paramString;
    }
    paramString = paramString.getBytes((Charset)localObject);
    kotlin.g.b.s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    com.tencent.mm.kernel.h.baC();
    localObject = com.tencent.mm.kernel.b.aZs();
    kotlin.g.b.s.s(localObject, "account().getUinString()");
    localObject = ((String)localObject).getBytes(kotlin.n.d.UTF_8);
    kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
    paramString = m(paramString, (byte[])localObject);
    com.tencent.mm.kernel.h.baC();
    localObject = com.tencent.mm.kernel.b.aZs();
    kotlin.g.b.s.s(localObject, "account().getUinString()");
    localObject = ((String)localObject).getBytes(kotlin.n.d.UTF_8);
    kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
    paramString = new com.tencent.mm.bx.b(m(paramString, (byte[])localObject));
    AppMethodBeat.o(279047);
    return paramString;
  }
  
  private final void bdn(String paramString)
  {
    AppMethodBeat.i(279072);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", false);
    localIntent.putExtra("hardcode_jspermission", (Parcelable)JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", (Parcelable)GeneralControlWrapper.YxA);
    com.tencent.mm.br.c.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", localIntent, 101);
    AppMethodBeat.o(279072);
  }
  
  private final int getScene()
  {
    AppMethodBeat.i(279004);
    int i = ((Number)this.pmx.getValue()).intValue();
    AppMethodBeat.o(279004);
    return i;
  }
  
  private final int hFi()
  {
    AppMethodBeat.i(278993);
    int i = ((Number)this.Tbj.getValue()).intValue();
    AppMethodBeat.o(278993);
    return i;
  }
  
  private final boolean hFj()
  {
    AppMethodBeat.i(278998);
    boolean bool = ((Boolean)this.Tbk.getValue()).booleanValue();
    AppMethodBeat.o(278998);
    return bool;
  }
  
  private final TempSecureEditText hFk()
  {
    AppMethodBeat.i(279011);
    Object localObject = this.Tbl.getValue();
    kotlin.g.b.s.s(localObject, "<get-passInput>(...)");
    localObject = (TempSecureEditText)localObject;
    AppMethodBeat.o(279011);
    return localObject;
  }
  
  private final void hFl()
  {
    AppMethodBeat.i(279028);
    int i = a.g.SXZ;
    if (getScene() == 1) {
      i = a.g.SYf;
    }
    for (;;)
    {
      TextView localTextView = (TextView)findViewById(a.d.desc);
      if (hFj())
      {
        localTextView.setText((CharSequence)getString(i));
        localTextView.setTextColor(localTextView.getResources().getColor(a.a.normal_text));
        if ((hFi() == 1) || (hFi() == 5)) {
          break label96;
        }
      }
      label96:
      for (i = 0;; i = 8)
      {
        localTextView.setVisibility(i);
        AppMethodBeat.o(279028);
        return;
      }
    }
  }
  
  private final String hFm()
  {
    AppMethodBeat.i(279034);
    String str = hFk().getText().toString();
    AppMethodBeat.o(279034);
    return str;
  }
  
  private void hideTenpayKB()
  {
    Object localObject2 = null;
    AppMethodBeat.i(279083);
    if (this.mKBLayout == null) {
      kotlin.g.b.s.bIx("mKBLayout");
    }
    View localView = this.mKBLayout;
    Object localObject1 = localView;
    if (localView == null)
    {
      kotlin.g.b.s.bIx("mKBLayout");
      localObject1 = null;
    }
    if (((View)localObject1).isShown())
    {
      localObject1 = this.mKBLayout;
      if (localObject1 != null) {
        break label77;
      }
      kotlin.g.b.s.bIx("mKBLayout");
      localObject1 = localObject2;
    }
    label77:
    for (;;)
    {
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(279083);
      return;
    }
  }
  
  private static byte[] m(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(279062);
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init((Key)new SecretKeySpec(paramArrayOfByte1, "HmacSHA256"));
      Log.i("MicroMsg.TeenModePrivatePwdUI", "HmacSHA256Encrypt: %s   %s   %s", new Object[] { Util.encodeHexString(paramArrayOfByte1), Util.encodeHexString(paramArrayOfByte2), Util.encodeHexString(localMac.doFinal(paramArrayOfByte2)) });
      paramArrayOfByte1 = localMac.doFinal(paramArrayOfByte2);
      kotlin.g.b.s.s(paramArrayOfByte1, "sha256_HMAC.doFinal(secretKey)");
      return paramArrayOfByte1;
    }
    finally
    {
      AppMethodBeat.o(279062);
    }
    return new byte[0];
  }
  
  private void setKBMode(int paramInt)
  {
    AppMethodBeat.i(279091);
    MyKeyboardWindow localMyKeyboardWindow2 = this.mKeyboard;
    MyKeyboardWindow localMyKeyboardWindow1 = localMyKeyboardWindow2;
    if (localMyKeyboardWindow2 == null)
    {
      kotlin.g.b.s.bIx("mKeyboard");
      localMyKeyboardWindow1 = null;
    }
    localMyKeyboardWindow1.setXMode(paramInt);
    AppMethodBeat.o(279091);
  }
  
  private void showTenpayKB()
  {
    Object localObject2 = null;
    AppMethodBeat.i(279076);
    if (this.mKBLayout == null) {
      kotlin.g.b.s.bIx("mKBLayout");
    }
    View localView = this.mKBLayout;
    Object localObject1 = localView;
    if (localView == null)
    {
      kotlin.g.b.s.bIx("mKBLayout");
      localObject1 = null;
    }
    if (!((View)localObject1).isShown())
    {
      localObject1 = this.mKBLayout;
      if (localObject1 != null) {
        break label76;
      }
      kotlin.g.b.s.bIx("mKBLayout");
      localObject1 = localObject2;
    }
    label76:
    for (;;)
    {
      ((View)localObject1).setVisibility(0);
      AppMethodBeat.o(279076);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.e.SWy;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(279323);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramInt2 == 0) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("result_err");
      paramIntent = str;
      if (str == null) {
        paramIntent = "";
      }
      atM(paramIntent);
      AppMethodBeat.o(279323);
      return;
    }
    if ((paramInt1 == 101) && (paramIntent != null))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if (paramIntent != null) {
        break label294;
      }
      paramIntent = null;
      paramIntent = (Map)paramIntent;
      Log.i("MicroMsg.TeenModePrivatePwdUI", "onActivityResult: %s", new Object[] { paramIntent });
      if ((paramIntent != null) && (n.T("goback", (String)paramIntent.get("next_step"), true)))
      {
        if (getScene() != 3) {
          break label305;
        }
        paramIntent = new Intent((Context)getContext(), SettingsTeenModeMain.class);
        paramIntent.addFlags(67108864);
        paramIntent.putExtra("intent_close_me", true);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.b.class)).bKY().wG(7);
      paramIntent = new q(z.bAM());
      com.tencent.mm.kernel.h.aZW().a((p)paramIntent, 0);
      AppMethodBeat.o(279323);
      return;
      label294:
      paramIntent = paramIntent.getSerializable("next_params");
      break;
      label305:
      finish();
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(279330);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(279330);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279313);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    Log.i("MicroMsg.TeenModePrivatePwdUI", "process:{" + hFi() + "}, scene:{" + getScene() + "}, stepOne:" + hFj());
    if (hFi() == 4)
    {
      paramBundle = new Intent((Context)this, SettingsTeenModeMain.class);
      paramBundle.addFlags(67108864);
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aYi(), "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.threadpool.h.ahAA.o(new TeenModePrivatePwdUI..ExternalSyntheticLambda6(this), 200L);
      AppMethodBeat.o(279313);
      return;
    }
    int i = a.g.SXX;
    if ((hFi() == 3) && (!hFj())) {
      i = a.g.SXY;
    }
    for (;;)
    {
      ((TextView)findViewById(a.d.title)).setText((CharSequence)getString(i));
      hFl();
      paramBundle = (TextView)findViewById(a.d.SVW);
      if ((hFi() == 3) && (getScene() != 1) && (hFj())) {
        paramBundle.setVisibility(0);
      }
      paramBundle.setOnClickListener(new TeenModePrivatePwdUI..ExternalSyntheticLambda2(paramBundle, this));
      paramBundle = (TextView)findViewById(a.d.SVG);
      Object localObject;
      if ((hFi() == 1) && (getScene() != 3))
      {
        localObject = paramBundle.getParent();
        if (localObject == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(279313);
          throw paramBundle;
          if ((hFi() == 1) || (hFi() == 5))
          {
            if (getScene() == 3) {
              i = a.g.SYe;
            } else {
              i = a.g.SYg;
            }
          }
          else if (hFi() == 2) {
            if (hFj()) {
              i = a.g.SYc;
            } else {
              i = a.g.SYd;
            }
          }
        }
        else
        {
          ((View)localObject).setVisibility(0);
        }
      }
      else
      {
        paramBundle.setOnClickListener(new TeenModePrivatePwdUI..ExternalSyntheticLambda1(paramBundle, this));
        hFk().addTextChangedListener((TextWatcher)new e(this));
        paramBundle = findViewById(a.d.tenpay_push_down);
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
        paramBundle = findViewById(a.d.tenpay_keyboard_top_line);
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
        paramBundle = hFk();
        kotlin.g.b.s.u(paramBundle, "parent");
        localObject = findViewById(a.d.tenpay_num_keyboard);
        if (localObject == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type com.tenpay.android.wechat.MyKeyboardWindow");
          AppMethodBeat.o(279313);
          throw paramBundle;
        }
        this.mKeyboard = ((MyKeyboardWindow)localObject);
        localObject = findViewById(a.d.tenpay_keyboard_layout);
        if (localObject == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(279313);
          throw paramBundle;
        }
        this.mKBLayout = ((View)localObject);
        localObject = findViewById(a.d.tenpay_push_down);
        if (localObject == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(279313);
          throw paramBundle;
        }
        if (this.mKeyboard == null) {
          kotlin.g.b.s.bIx("mKeyboard");
        }
        if (this.mKBLayout == null) {
          kotlin.g.b.s.bIx("mKBLayout");
        }
        View.OnFocusChangeListener localOnFocusChangeListener = paramBundle.getOnFocusChangeListener();
        hideVKB();
        paramBundle.setInputType(0);
        paramBundle.setPwdLength(4);
        paramBundle.setOnFocusChangeListener(new TeenModePrivatePwdUI..ExternalSyntheticLambda5(this, false, localOnFocusChangeListener, 0, paramBundle));
        paramBundle.setOnClickListener(new TeenModePrivatePwdUI..ExternalSyntheticLambda4(this, false, 0, paramBundle));
        ((View)localObject).setOnClickListener(new TeenModePrivatePwdUI..ExternalSyntheticLambda3(this));
        showTenpayKB();
        hFk().setIsPasswordFormat(true, true);
        hFk().requestFocus();
        setBackBtn(new TeenModePrivatePwdUI..ExternalSyntheticLambda0(this));
        AppMethodBeat.o(279313);
        return;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(279335);
    super.onResume();
    hFk().setText((CharSequence)"");
    AppMethodBeat.o(279335);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI$onCreate$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements TextWatcher
  {
    e(TeenModePrivatePwdUI paramTeenModePrivatePwdUI) {}
    
    private static final void l(TeenModePrivatePwdUI paramTeenModePrivatePwdUI)
    {
      AppMethodBeat.i(279174);
      kotlin.g.b.s.u(paramTeenModePrivatePwdUI, "this$0");
      paramTeenModePrivatePwdUI.finish();
      AppMethodBeat.o(279174);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int j = 1;
      AppMethodBeat.i(279204);
      if ((paramEditable != null) && (paramEditable.length() == 4)) {
        i = 1;
      }
      while (i != 0) {
        if ((TeenModePrivatePwdUI.b(this.Tbm) == 1) || (TeenModePrivatePwdUI.b(this.Tbm) == 5))
        {
          TeenModePrivatePwdUI.c(this.Tbm);
          AppMethodBeat.o(279204);
          return;
          i = 0;
        }
        else
        {
          if (TeenModePrivatePwdUI.b(this.Tbm) == 2)
          {
            if (TeenModePrivatePwdUI.d(this.Tbm))
            {
              paramEditable = new Intent((Context)this.Tbm.getContext(), TeenModePrivatePwdUI.class);
              paramEditable.putExtra("pass", TeenModePrivatePwdUI.e(this.Tbm));
              paramEditable.putExtra("intent_process", 2);
              paramEditable.putExtra("intent_process_step_one", false);
              this.Tbm.startActivityForResult(paramEditable, 100);
              AppMethodBeat.o(279204);
              return;
            }
            if (!TeenModePrivatePwdUI.e(this.Tbm).equals(this.Tbm.getIntent().getStringExtra("pass")))
            {
              paramEditable = new Intent();
              paramEditable.putExtra("result_err", this.Tbm.getString(a.g.SYh));
              this.Tbm.setResult(0, paramEditable);
              this.Tbm.finish();
              AppMethodBeat.o(279204);
              return;
            }
            TeenModePrivatePwdUI.f(this.Tbm);
            AppMethodBeat.o(279204);
            return;
          }
          if (TeenModePrivatePwdUI.b(this.Tbm) != 3) {
            break label558;
          }
          if (TeenModePrivatePwdUI.d(this.Tbm))
          {
            paramEditable = new Intent((Context)this.Tbm.getContext(), TeenModePrivatePwdUI.class);
            paramEditable.putExtra("pass", TeenModePrivatePwdUI.e(this.Tbm));
            paramEditable.putExtra("intent_process", 3);
            paramEditable.putExtra("intent_process_step_one", false);
            this.Tbm.startActivityForResult(paramEditable, 100);
            AppMethodBeat.o(279204);
            return;
          }
          if (!TeenModePrivatePwdUI.e(this.Tbm).equals(this.Tbm.getIntent().getStringExtra("pass")))
          {
            paramEditable = new Intent();
            paramEditable.putExtra("result_err", this.Tbm.getString(a.g.SYh));
            this.Tbm.setResult(0, paramEditable);
            this.Tbm.finish();
            AppMethodBeat.o(279204);
            return;
          }
          Object localObject = new Intent((Context)this.Tbm.getContext(), TeenModeGuardianInfoUI.class);
          ((Intent)localObject).putExtra("pass", TeenModePrivatePwdUI.e(this.Tbm));
          paramEditable = this.Tbm;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramEditable, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI$onCreate$4", "afterTextChanged", "(Landroid/text/Editable;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramEditable.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramEditable, "com/tencent/mm/plugin/teenmode/ui/TeenModePrivatePwdUI$onCreate$4", "afterTextChanged", "(Landroid/text/Editable;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.threadpool.h.ahAA.o(new TeenModePrivatePwdUI.e..ExternalSyntheticLambda0(this.Tbm), 200L);
          AppMethodBeat.o(279204);
          return;
        }
      }
      if ((paramEditable != null) && (paramEditable.length() == 0)) {}
      for (int i = j;; i = 0)
      {
        if (i == 0) {
          TeenModePrivatePwdUI.g(this.Tbm);
        }
        label558:
        AppMethodBeat.o(279204);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tenpay/android/wechat/TempSecureEditText;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<TempSecureEditText>
  {
    f(TeenModePrivatePwdUI paramTeenModePrivatePwdUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<Integer>
  {
    g(TeenModePrivatePwdUI paramTeenModePrivatePwdUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<Integer>
  {
    h(TeenModePrivatePwdUI paramTeenModePrivatePwdUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    i(TeenModePrivatePwdUI paramTeenModePrivatePwdUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModePrivatePwdUI
 * JD-Core Version:    0.7.0.1
 */