package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.b.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.protocal.protobuf.faj;
import com.tencent.mm.protocal.protobuf.fak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMClearEditText;
import java.nio.charset.Charset;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.d;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.as;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/TeenModeGuardianInfoUI;", "Lcom/tencent/mm/ui/MMWizardActivity;", "()V", "idNumET", "Lcom/tencent/mm/ui/widget/MMClearEditText;", "kotlin.jvm.PlatformType", "getIdNumET", "()Lcom/tencent/mm/ui/widget/MMClearEditText;", "idNumET$delegate", "Lkotlin/Lazy;", "nameET", "getNameET", "nameET$delegate", "HmacSHA256Encrypt", "", "text", "secretKey", "doScene", "", "getEncryptBuf", "Lcom/tencent/mm/protobuf/ByteString;", "pwd", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showErrorTip", "errMsg", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TeenModeGuardianInfoUI
  extends MMWizardActivity
{
  public static final TeenModeGuardianInfoUI.a Tba;
  private final j Tbb;
  private final j Tbc;
  
  static
  {
    AppMethodBeat.i(279381);
    Tba = new TeenModeGuardianInfoUI.a((byte)0);
    AppMethodBeat.o(279381);
  }
  
  public TeenModeGuardianInfoUI()
  {
    AppMethodBeat.i(279310);
    this.Tbb = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Tbc = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(279310);
  }
  
  private static final void a(Button paramButton, TeenModeGuardianInfoUI paramTeenModeGuardianInfoUI, InputPanelLinearLayout paramInputPanelLinearLayout, ScrollView paramScrollView, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(279363);
    s.u(paramTeenModeGuardianInfoUI, "this$0");
    Object localObject = paramButton.getLayoutParams();
    if (localObject == null)
    {
      paramButton = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(279363);
      throw paramButton;
    }
    localObject = (LinearLayout.LayoutParams)localObject;
    if (paramBoolean)
    {
      ((LinearLayout.LayoutParams)localObject).bottomMargin = paramTeenModeGuardianInfoUI.getResources().getDimensionPixelSize(a.b.Edge_8A);
      ((LinearLayout.LayoutParams)localObject).topMargin = paramTeenModeGuardianInfoUI.getResources().getDimensionPixelSize(a.b.Edge_5A);
      paramButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramInputPanelLinearLayout.setPadding(paramInputPanelLinearLayout.getPaddingLeft(), paramInputPanelLinearLayout.getPaddingTop(), paramInputPanelLinearLayout.getPaddingRight(), paramInt);
      paramInt = paramScrollView.getHeight();
      paramInputPanelLinearLayout.requestLayout();
      paramInputPanelLinearLayout.post(new TeenModeGuardianInfoUI..ExternalSyntheticLambda3(paramInputPanelLinearLayout, paramInt, paramScrollView));
      AppMethodBeat.o(279363);
      return;
    }
    ((LinearLayout.LayoutParams)localObject).bottomMargin = paramTeenModeGuardianInfoUI.getResources().getDimensionPixelSize(a.b.Edge_12A);
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    paramButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramInputPanelLinearLayout.setPadding(paramInputPanelLinearLayout.getPaddingLeft(), paramInputPanelLinearLayout.getPaddingTop(), paramInputPanelLinearLayout.getPaddingRight(), 0);
    paramScrollView.scrollBy(0, 0);
    AppMethodBeat.o(279363);
  }
  
  private static final void a(TeenModeGuardianInfoUI paramTeenModeGuardianInfoUI, View paramView)
  {
    AppMethodBeat.i(279348);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramTeenModeGuardianInfoUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/TeenModeGuardianInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramTeenModeGuardianInfoUI, "this$0");
    localObject2 = new faj();
    ((faj)localObject2).vhJ = 1;
    localObject1 = paramTeenModeGuardianInfoUI.getIntent().getStringExtra("pass");
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = "";
    }
    localObject1 = d.UTF_8;
    if (paramView == null)
    {
      paramTeenModeGuardianInfoUI = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(279348);
      throw paramTeenModeGuardianInfoUI;
    }
    paramView = paramView.getBytes((Charset)localObject1);
    s.s(paramView, "(this as java.lang.String).getBytes(charset)");
    h.baC();
    localObject1 = com.tencent.mm.kernel.b.aZs();
    s.s(localObject1, "account().getUinString()");
    localObject1 = ((String)localObject1).getBytes(d.UTF_8);
    s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
    paramView = m(paramView, (byte[])localObject1);
    h.baC();
    localObject1 = com.tencent.mm.kernel.b.aZs();
    s.s(localObject1, "account().getUinString()");
    localObject1 = ((String)localObject1).getBytes(d.UTF_8);
    s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
    ((faj)localObject2).abAK = new com.tencent.mm.bx.b(m(paramView, (byte[])localObject1));
    ((faj)localObject2).IGU = paramTeenModeGuardianInfoUI.hFg().getText().toString();
    ((faj)localObject2).abAL = paramTeenModeGuardianInfoUI.hFh().getText().toString();
    paramView = new c.a();
    paramView.funcId = 4277;
    paramView.uri = "/cgi-bin/micromsg-bin/setteenagermodepwd";
    paramView.otE = ((com.tencent.mm.bx.a)localObject2);
    paramView.otF = ((com.tencent.mm.bx.a)new fak());
    localObject1 = paramView.bEF();
    paramView = com.tencent.mm.ui.base.k.a((Context)paramTeenModeGuardianInfoUI.getContext(), paramTeenModeGuardianInfoUI.getString(a.g.app_sending), false, null);
    localObject2 = com.tencent.mm.am.a.b.ovw;
    s.s(localObject1, "commReqResp");
    localObject1 = b.a.e((c)localObject1);
    localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject2 = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramTeenModeGuardianInfoUI).q(com.tencent.mm.plugin.mvvmbase.a.a.class);
    s.s(localObject2, "UICProvider.of(this).get…ycleScopeUIC::class.java)");
    l.b((aq)((com.tencent.mm.plugin.mvvmbase.a.a)localObject2).gsu(), (f)bg.kCh(), as.ajvK, (m)new TeenModeGuardianInfoUI.b((g)localObject1, paramView, paramTeenModeGuardianInfoUI, null));
    paramTeenModeGuardianInfoUI.hideVKB();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/TeenModeGuardianInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279348);
  }
  
  private static final void a(InputPanelLinearLayout paramInputPanelLinearLayout, int paramInt, ScrollView paramScrollView)
  {
    AppMethodBeat.i(279355);
    Log.i("MicroMsg.TeenModeGuardianInfoUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(paramInputPanelLinearLayout.getHeight()), Integer.valueOf(paramInt) });
    if (paramInputPanelLinearLayout.getHeight() > paramInt) {
      paramScrollView.scrollBy(0, paramInputPanelLinearLayout.getHeight() - paramInt);
    }
    AppMethodBeat.o(279355);
  }
  
  private static final boolean a(TeenModeGuardianInfoUI paramTeenModeGuardianInfoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(279366);
    s.u(paramTeenModeGuardianInfoUI, "this$0");
    paramTeenModeGuardianInfoUI.finish();
    AppMethodBeat.o(279366);
    return true;
  }
  
  private final MMClearEditText hFg()
  {
    AppMethodBeat.i(279316);
    MMClearEditText localMMClearEditText = (MMClearEditText)this.Tbb.getValue();
    AppMethodBeat.o(279316);
    return localMMClearEditText;
  }
  
  private final MMClearEditText hFh()
  {
    AppMethodBeat.i(279322);
    MMClearEditText localMMClearEditText = (MMClearEditText)this.Tbc.getValue();
    AppMethodBeat.o(279322);
    return localMMClearEditText;
  }
  
  private static byte[] m(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(279327);
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init((Key)new SecretKeySpec(paramArrayOfByte1, "HmacSHA256"));
      paramArrayOfByte1 = localMac.doFinal(paramArrayOfByte2);
      s.s(paramArrayOfByte1, "sha256_HMAC.doFinal(secretKey)");
      return paramArrayOfByte1;
    }
    finally
    {
      AppMethodBeat.o(279327);
    }
    return new byte[0];
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.e.SWx;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279406);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    paramBundle = (Button)findViewById(a.d.next_btn);
    paramBundle.setOnClickListener(new TeenModeGuardianInfoUI..ExternalSyntheticLambda1(this));
    Object localObject1 = (ScrollView)findViewById(a.d.scroll_view);
    Object localObject2 = (InputPanelLinearLayout)findViewById(a.d.input_container);
    ((InputPanelLinearLayout)localObject2).setExternalListener(new TeenModeGuardianInfoUI..ExternalSyntheticLambda2(paramBundle, this, (InputPanelLinearLayout)localObject2, (ScrollView)localObject1));
    localObject1 = hFg();
    localObject2 = hFh();
    int i = 0;
    while (i < 2)
    {
      new MMClearEditText[] { localObject1, localObject2 }[i].addTextChangedListener((TextWatcher)new e(paramBundle, this));
      i += 1;
    }
    hFg().requestFocus();
    setBackBtn(new TeenModeGuardianInfoUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(279406);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMClearEditText;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<MMClearEditText>
  {
    c(TeenModeGuardianInfoUI paramTeenModeGuardianInfoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMClearEditText;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<MMClearEditText>
  {
    d(TeenModeGuardianInfoUI paramTeenModeGuardianInfoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/teenmode/ui/TeenModeGuardianInfoUI$onCreate$3$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements TextWatcher
  {
    e(Button paramButton, TeenModeGuardianInfoUI paramTeenModeGuardianInfoUI) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(279161);
      paramEditable = this.Tbh;
      if ((TeenModeGuardianInfoUI.a(jdField_this).length() > 0) && (TeenModeGuardianInfoUI.b(jdField_this).length() > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        paramEditable.setEnabled(bool);
        TeenModeGuardianInfoUI.a(jdField_this, "");
        AppMethodBeat.o(279161);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModeGuardianInfoUI
 * JD-Core Version:    0.7.0.1
 */