package com.tencent.mm.plugin.teenmode.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.b.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/AuthorizationRequestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "authorizationReqItem", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "getAuthorizationReqItem", "()Landroid/widget/RelativeLayout;", "authorizationReqItem$delegate", "Lkotlin/Lazy;", "hadCallback", "", "isFromVerifyPwd", "pwdItem", "getPwdItem", "pwdItem$delegate", "getLayoutId", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStop", "resultCallback", "showErrorTip", "errMsg", "", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AuthorizationRequestUI
  extends MMActivity
{
  public static final AuthorizationRequestUI.a SZK;
  private final j SZL;
  private final j SZM;
  private boolean SZN;
  private boolean SZO;
  
  static
  {
    AppMethodBeat.i(279223);
    SZK = new AuthorizationRequestUI.a((byte)0);
    AppMethodBeat.o(279223);
  }
  
  public AuthorizationRequestUI()
  {
    AppMethodBeat.i(279173);
    this.SZL = k.cm((kotlin.g.a.a)new d(this));
    this.SZM = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(279173);
  }
  
  private static final void a(RelativeLayout paramRelativeLayout, AuthorizationRequestUI paramAuthorizationRequestUI, View paramView)
  {
    AppMethodBeat.i(279209);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRelativeLayout);
    localb.cH(paramAuthorizationRequestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/AuthorizationRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramAuthorizationRequestUI, "this$0");
    ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(paramRelativeLayout.getContext(), paramAuthorizationRequestUI.getIntent().getIntExtra("intent_extra_type", 0), paramAuthorizationRequestUI.getIntent().getStringExtra("intent_extra_key"), paramAuthorizationRequestUI.getIntent().getStringExtra("intent_extra_title"), paramAuthorizationRequestUI.getIntent().getStringExtra("intent_extra_digest"), paramAuthorizationRequestUI.getIntent().getStringExtra("intent_extra_content"), null, new AuthorizationRequestUI..ExternalSyntheticLambda4(paramAuthorizationRequestUI));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/AuthorizationRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279209);
  }
  
  private static final void a(AuthorizationRequestUI paramAuthorizationRequestUI, View paramView)
  {
    AppMethodBeat.i(279193);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramAuthorizationRequestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/AuthorizationRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramAuthorizationRequestUI, "this$0");
    ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).n((Activity)paramAuthorizationRequestUI, 101);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/AuthorizationRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279193);
  }
  
  private static final void a(AuthorizationRequestUI paramAuthorizationRequestUI, boolean paramBoolean)
  {
    AppMethodBeat.i(279200);
    s.u(paramAuthorizationRequestUI, "this$0");
    if (paramBoolean) {
      com.tencent.mm.ae.d.a(200L, (kotlin.g.a.a)new c(paramAuthorizationRequestUI));
    }
    AppMethodBeat.o(279200);
  }
  
  private static final boolean a(AuthorizationRequestUI paramAuthorizationRequestUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(279186);
    s.u(paramAuthorizationRequestUI, "this$0");
    paramAuthorizationRequestUI.finish();
    AppMethodBeat.o(279186);
    return true;
  }
  
  private static final void b(AuthorizationRequestUI paramAuthorizationRequestUI, View paramView)
  {
    AppMethodBeat.i(279217);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramAuthorizationRequestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/AuthorizationRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramAuthorizationRequestUI, "this$0");
    paramAuthorizationRequestUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/AuthorizationRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279217);
  }
  
  private final void hEQ()
  {
    AppMethodBeat.i(279180);
    if (this.SZN)
    {
      AppMethodBeat.o(279180);
      return;
    }
    this.SZN = true;
    int i = getIntent().getIntExtra("intent_extra_type", 2147483647);
    String str = getIntent().getStringExtra("intent_extra_key");
    if ((((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).jdMethod_do(i, str)) && (this.SZO)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.teenmode.b.a locala = com.tencent.mm.plugin.teenmode.b.a.SYz;
      com.tencent.mm.plugin.teenmode.b.a.j(i, str, bool);
      AppMethodBeat.o(279180);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.e.SWt;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(279281);
    com.tencent.mm.plugin.teenmode.a.e locale;
    if ((paramInt1 == 101) && (paramInt2 == -1))
    {
      locale = new com.tencent.mm.plugin.teenmode.a.e();
      locale.field_businessType = getIntent().getIntExtra("intent_extra_type", 2147483647);
      locale.field_businessKey = getIntent().getStringExtra("intent_extra_key");
      paramIntent = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEu();
      if (paramIntent != null) {
        break label148;
      }
    }
    label148:
    for (paramIntent = null;; paramIntent = paramIntent.field_username)
    {
      locale.field_guardianUserName = paramIntent;
      locale.field_wardUserName = z.bAM();
      locale.field_time = cn.bDv();
      paramIntent = com.tencent.mm.plugin.teenmode.b.a.e.SZq;
      com.tencent.mm.plugin.teenmode.b.a.e.hEB().replace((IAutoDBItem)locale);
      ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEs();
      this.SZO = true;
      setResult(-1);
      finish();
      AppMethodBeat.o(279281);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279272);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    setBackBtn(new AuthorizationRequestUI..ExternalSyntheticLambda0(this));
    if (getIntent().getBooleanExtra("intent_extra_can_auth", true))
    {
      ((LinearLayout)findViewById(a.d.SVP)).setVisibility(0);
      ((TextView)findViewById(a.d.item_title)).setVisibility(0);
    }
    for (;;)
    {
      ((RelativeLayout)this.SZL.getValue()).setOnClickListener(new AuthorizationRequestUI..ExternalSyntheticLambda2(this));
      if (((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEu() != null)
      {
        paramBundle = (RelativeLayout)this.SZM.getValue();
        paramBundle.setOnClickListener(new AuthorizationRequestUI..ExternalSyntheticLambda1(paramBundle, this));
        paramBundle.setVisibility(0);
      }
      ((Button)findViewById(a.d.close_btn)).setOnClickListener(new AuthorizationRequestUI..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(279272);
      return;
      ((LinearLayout)findViewById(a.d.SVP)).setVisibility(8);
      ((TextView)findViewById(a.d.item_title)).setVisibility(8);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(279295);
    super.onDestroy();
    Log.i("MicroMsg.AuthorizationRequestUI", s.X("onDestroy hadCallback:", Boolean.valueOf(this.SZN)));
    hEQ();
    AppMethodBeat.o(279295);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(279288);
    super.onStop();
    Log.i("MicroMsg.AuthorizationRequestUI", s.X("onStop isFinishing:", Boolean.valueOf(isFinishing())));
    if (isFinishing()) {
      hEQ();
    }
    AppMethodBeat.o(279288);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(AuthorizationRequestUI paramAuthorizationRequestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(AuthorizationRequestUI paramAuthorizationRequestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    d(AuthorizationRequestUI paramAuthorizationRequestUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.AuthorizationRequestUI
 * JD-Core Version:    0.7.0.1
 */