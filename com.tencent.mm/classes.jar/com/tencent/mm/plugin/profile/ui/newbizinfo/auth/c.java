package com.tencent.mm.plugin.profile.ui.newbizinfo.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthTestUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mainUI", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthMainUI;", "getMainUI", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthMainUI;", "mainUI$delegate", "Lkotlin/Lazy;", "goToTestPage", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showTestMenu", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  public static final c.a Ncn;
  private final j Ncf;
  
  static
  {
    AppMethodBeat.i(305802);
    Ncn = new c.a((byte)0);
    AppMethodBeat.o(305802);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(305778);
    this.Ncf = k.cm((kotlin.g.a.a)new b(paramAppCompatActivity));
    AppMethodBeat.o(305778);
  }
  
  private static final void a(c paramc, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(305797);
    kotlin.g.b.s.u(paramc, "this$0");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(305797);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("rawUrl", "https://stream.weixin.qq.com/jsapidemo/static/index.html#/index");
      com.tencent.mm.br.c.b((Context)paramc.getContext(), "webview", ".ui.tools.WebViewUI", paramMenuItem);
      AppMethodBeat.o(305797);
      return;
      paramc = com.tencent.mm.plugin.webview.jsapi.a.WDs;
      com.tencent.mm.plugin.webview.jsapi.a.Ix(true);
      AppMethodBeat.o(305797);
      return;
      paramc = com.tencent.mm.plugin.webview.jsapi.a.WDs;
      com.tencent.mm.plugin.webview.jsapi.a.Ix(false);
    }
  }
  
  private static final boolean a(c paramc, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(305787);
    kotlin.g.b.s.u(paramc, "this$0");
    paramMenuItem = new f((Context)paramc.getContext(), 1, true);
    paramMenuItem.Vtg = c..ExternalSyntheticLambda1.INSTANCE;
    paramMenuItem.GAC = new c..ExternalSyntheticLambda2(paramc);
    paramMenuItem.dDn();
    AppMethodBeat.o(305787);
    return true;
  }
  
  private static final void q(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(305793);
    params.c(0, (CharSequence)"跳转到此公众号对应的jsapi测试页");
    params.c(1, (CharSequence)"打开cgi提醒toast");
    params.c(2, (CharSequence)"关闭cgi提醒toast");
    AppMethodBeat.o(305793);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305821);
    super.onCreate(paramBundle);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      ((MMActivity)getActivity()).addTextOptionMenu(0, "测试", new c..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(305821);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthMainUI;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<NewBizInfoAuthMainUI>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.auth.c
 * JD-Core Version:    0.7.0.1
 */