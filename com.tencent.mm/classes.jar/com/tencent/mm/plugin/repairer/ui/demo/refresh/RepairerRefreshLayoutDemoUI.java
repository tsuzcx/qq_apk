package com.tencent.mm.plugin.repairer.ui.demo.refresh;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "btnCoordinatorDemo", "Landroid/view/View;", "btnListViewDemo", "btnNestScrollViewDemo", "btnNoMoreDataDemo", "btnRecyclerViewDemo", "btnSnapDemo", "btnStaggerDemo", "btnValueSetDemo", "getLayoutId", "", "gotoDetail", "", "type", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerRefreshLayoutDemoUI
  extends BaseRepairerUI
{
  private View OxL;
  private View OxM;
  private View OxN;
  private View OxO;
  private View OxP;
  private View OxQ;
  private View OxR;
  private View OxS;
  
  private static final void a(RepairerRefreshLayoutDemoUI paramRepairerRefreshLayoutDemoUI, View paramView)
  {
    AppMethodBeat.i(278464);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerRefreshLayoutDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerRefreshLayoutDemoUI, "this$0");
    paramRepairerRefreshLayoutDemoUI.ahq(1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278464);
  }
  
  private static final boolean a(RepairerRefreshLayoutDemoUI paramRepairerRefreshLayoutDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278454);
    s.u(paramRepairerRefreshLayoutDemoUI, "this$0");
    paramRepairerRefreshLayoutDemoUI.finish();
    AppMethodBeat.o(278454);
    return true;
  }
  
  private final void ahq(int paramInt)
  {
    AppMethodBeat.i(278446);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("KEY_SHOW_TYPE", paramInt);
    ((Intent)localObject).setClass((Context)this, RepairerRefreshLayoutDemoDetailUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "gotoDetail", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "gotoDetail", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(278446);
  }
  
  private static final void b(RepairerRefreshLayoutDemoUI paramRepairerRefreshLayoutDemoUI, View paramView)
  {
    AppMethodBeat.i(278468);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerRefreshLayoutDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerRefreshLayoutDemoUI, "this$0");
    paramRepairerRefreshLayoutDemoUI.ahq(2);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278468);
  }
  
  private static final void c(RepairerRefreshLayoutDemoUI paramRepairerRefreshLayoutDemoUI, View paramView)
  {
    AppMethodBeat.i(278476);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerRefreshLayoutDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerRefreshLayoutDemoUI, "this$0");
    paramRepairerRefreshLayoutDemoUI.ahq(3);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278476);
  }
  
  private static final void d(RepairerRefreshLayoutDemoUI paramRepairerRefreshLayoutDemoUI, View paramView)
  {
    AppMethodBeat.i(278481);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerRefreshLayoutDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerRefreshLayoutDemoUI, "this$0");
    paramRepairerRefreshLayoutDemoUI.ahq(4);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278481);
  }
  
  private static final void e(RepairerRefreshLayoutDemoUI paramRepairerRefreshLayoutDemoUI, View paramView)
  {
    AppMethodBeat.i(278486);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerRefreshLayoutDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerRefreshLayoutDemoUI, "this$0");
    paramRepairerRefreshLayoutDemoUI.ahq(5);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278486);
  }
  
  private static final void f(RepairerRefreshLayoutDemoUI paramRepairerRefreshLayoutDemoUI, View paramView)
  {
    AppMethodBeat.i(278494);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerRefreshLayoutDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerRefreshLayoutDemoUI, "this$0");
    paramRepairerRefreshLayoutDemoUI.ahq(6);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278494);
  }
  
  private static final void g(RepairerRefreshLayoutDemoUI paramRepairerRefreshLayoutDemoUI, View paramView)
  {
    AppMethodBeat.i(278501);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerRefreshLayoutDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerRefreshLayoutDemoUI, "this$0");
    paramRepairerRefreshLayoutDemoUI.ahq(7);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278501);
  }
  
  private static final void h(RepairerRefreshLayoutDemoUI paramRepairerRefreshLayoutDemoUI, View paramView)
  {
    AppMethodBeat.i(278512);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerRefreshLayoutDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerRefreshLayoutDemoUI, "this$0");
    paramRepairerRefreshLayoutDemoUI.ahq(8);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278512);
  }
  
  public final int getLayoutId()
  {
    return b.d.OvP;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(278603);
    super.onCreate(paramBundle);
    setMMTitle("刷新组件Demo");
    setBackBtn(new RepairerRefreshLayoutDemoUI..ExternalSyntheticLambda0(this));
    this.OxL = findViewById(b.c.OtN);
    this.OxM = findViewById(b.c.OtL);
    this.OxN = findViewById(b.c.OtJ);
    this.OxO = findViewById(b.c.OtK);
    this.OxP = findViewById(b.c.OtM);
    this.OxQ = findViewById(b.c.OtQ);
    this.OxR = findViewById(b.c.OtP);
    this.OxS = findViewById(b.c.OtO);
    View localView = this.OxL;
    paramBundle = localView;
    if (localView == null)
    {
      s.bIx("btnRecyclerViewDemo");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new RepairerRefreshLayoutDemoUI..ExternalSyntheticLambda6(this));
    localView = this.OxM;
    paramBundle = localView;
    if (localView == null)
    {
      s.bIx("btnNestScrollViewDemo");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new RepairerRefreshLayoutDemoUI..ExternalSyntheticLambda4(this));
    localView = this.OxN;
    paramBundle = localView;
    if (localView == null)
    {
      s.bIx("btnCoordinatorDemo");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new RepairerRefreshLayoutDemoUI..ExternalSyntheticLambda5(this));
    localView = this.OxO;
    paramBundle = localView;
    if (localView == null)
    {
      s.bIx("btnListViewDemo");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new RepairerRefreshLayoutDemoUI..ExternalSyntheticLambda1(this));
    localView = this.OxR;
    paramBundle = localView;
    if (localView == null)
    {
      s.bIx("btnStaggerDemo");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new RepairerRefreshLayoutDemoUI..ExternalSyntheticLambda8(this));
    localView = this.OxS;
    paramBundle = localView;
    if (localView == null)
    {
      s.bIx("btnSnapDemo");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new RepairerRefreshLayoutDemoUI..ExternalSyntheticLambda3(this));
    localView = this.OxP;
    paramBundle = localView;
    if (localView == null)
    {
      s.bIx("btnNoMoreDataDemo");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new RepairerRefreshLayoutDemoUI..ExternalSyntheticLambda2(this));
    paramBundle = this.OxQ;
    if (paramBundle == null)
    {
      s.bIx("btnValueSetDemo");
      paramBundle = localObject;
    }
    for (;;)
    {
      paramBundle.setOnClickListener(new RepairerRefreshLayoutDemoUI..ExternalSyntheticLambda7(this));
      AppMethodBeat.o(278603);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.RepairerRefreshLayoutDemoUI
 * JD-Core Version:    0.7.0.1
 */