package com.tencent.mm.plugin.surface.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.co;
import com.tencent.mm.plugin.surface.a.b;
import com.tencent.mm.plugin.surface.b.d;
import com.tencent.mm.plugin.surface.c.f;
import com.tencent.mm.plugin.surface.core.g;
import com.tencent.mm.plugin.surface.view.SurfaceAppContainer;
import com.tencent.mm.plugin.surface.view.SurfaceAppContainer.a;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/test/TestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "container", "Lcom/tencent/mm/plugin/surface/view/SurfaceAppContainer;", "getContainer", "()Lcom/tencent/mm/plugin/surface/view/SurfaceAppContainer;", "container$delegate", "Lkotlin/Lazy;", "roots", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TestUI
  extends MMActivity
{
  public static final TestUI.a SLG;
  private final LinkedList<f> SLH;
  private final j vFm;
  
  static
  {
    AppMethodBeat.i(265014);
    SLG = new TestUI.a((byte)0);
    g localg = new g((Collection)kotlin.a.p.listOf(new com.tencent.mm.plugin.appbrand.jsapi.p[] { (com.tencent.mm.plugin.appbrand.jsapi.p)new d(), (com.tencent.mm.plugin.appbrand.jsapi.p)new co(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.b() }), (com.tencent.mm.plugin.surface.d.a)new b());
    com.tencent.mm.plugin.surface.b localb = com.tencent.mm.plugin.surface.b.SJM;
    com.tencent.mm.plugin.surface.b.a("test1", localg);
    localb = com.tencent.mm.plugin.surface.b.SJM;
    com.tencent.mm.plugin.surface.b.a("test2", localg);
    AppMethodBeat.o(265014);
  }
  
  public TestUI()
  {
    AppMethodBeat.i(265000);
    this.vFm = k.cm((kotlin.g.a.a)new c(this));
    this.SLH = new LinkedList();
    AppMethodBeat.o(265000);
  }
  
  private static final boolean a(TestUI paramTestUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(265009);
    s.u(paramTestUI, "this$0");
    paramTestUI.finish();
    AppMethodBeat.o(265009);
    return true;
  }
  
  private final SurfaceAppContainer hCa()
  {
    AppMethodBeat.i(265005);
    Object localObject = this.vFm.getValue();
    s.s(localObject, "<get-container>(...)");
    localObject = (SurfaceAppContainer)localObject;
    AppMethodBeat.o(265005);
    return localObject;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.b.surface_test_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265031);
    super.onCreate(paramBundle);
    setMMTitle("Surface Canvas Test");
    paramBundle = getIntent().getStringArrayListExtra("appIds");
    if (paramBundle == null)
    {
      Toast.makeText((Context)((TestUI)this).getContext(), (CharSequence)"appIds not found", 0).show();
      AppMethodBeat.o(265031);
      return;
    }
    Object localObject1;
    if (paramBundle.size() > 0)
    {
      localObject1 = SurfaceAppContainer.SLJ;
      localObject1 = getContext();
      s.s(localObject1, "this.context");
      localObject1 = (Context)localObject1;
      Object localObject2 = paramBundle.get(0);
      s.s(localObject2, "appIds[0]");
      localObject1 = SurfaceAppContainer.a.b(this, (Context)localObject1, (String)localObject2, "", "?name=testA");
      this.SLH.add(localObject1);
      SurfaceAppContainer.a(hCa(), (f)localObject1);
    }
    if (paramBundle.size() > 1)
    {
      localObject1 = SurfaceAppContainer.SLJ;
      localObject1 = getContext();
      s.s(localObject1, "this.context");
      localObject1 = (Context)localObject1;
      paramBundle = paramBundle.get(1);
      s.s(paramBundle, "appIds[1]");
      paramBundle = SurfaceAppContainer.a.b(this, (Context)localObject1, (String)paramBundle, "", "?name=testB");
      this.SLH.add(paramBundle);
      SurfaceAppContainer.a(hCa(), paramBundle);
    }
    setBackBtn(new TestUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(265031);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(265049);
    super.onDestroy();
    com.tencent.mm.plugin.surface.b localb = com.tencent.mm.plugin.surface.b.SJM;
    AppMethodBeat.o(265049);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(265036);
    super.onPause();
    Iterator localIterator = ((Iterable)this.SLH).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).pause();
    }
    AppMethodBeat.o(265036);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(265043);
    super.onResume();
    Iterator localIterator = ((Iterable)this.SLH).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).resume();
    }
    AppMethodBeat.o(265043);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/test/TestUI$Companion$config$1", "Lcom/tencent/mm/plugin/surface/reporter/SurfaceReporter;", "reportFirstFrameRender", "", "reportJsException", "appId", "", "source", "message", "stackTrace", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.surface.d.a
  {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/surface/view/SurfaceAppContainer;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<SurfaceAppContainer>
  {
    c(TestUI paramTestUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.test.TestUI
 * JD-Core Version:    0.7.0.1
 */