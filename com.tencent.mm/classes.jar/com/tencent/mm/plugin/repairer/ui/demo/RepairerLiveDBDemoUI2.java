package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.mvvmlist.MvvmList.k;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerLiveDBDemoUI2;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "ThreadTag", "", "getThreadTag", "()Ljava/lang/String;", "adapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem1;", "getAdapter", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dataSource", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoDataSource;", "getDataSource", "()Lcom/tencent/mm/plugin/repairer/ui/demo/DemoDataSource;", "setDataSource", "(Lcom/tencent/mm/plugin/repairer/ui/demo/DemoDataSource;)V", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "text", "Landroid/widget/Button;", "getText", "()Landroid/widget/Button;", "setText", "(Landroid/widget/Button;)V", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerLiveDBDemoUI2
  extends BaseRepairerUI
{
  public static final RepairerLiveDBDemoUI2.a Oxc;
  public Button Oxd;
  public h Oxe;
  private final String tRX;
  private final j xZP;
  WxRecyclerView yAg;
  
  static
  {
    AppMethodBeat.i(278187);
    Oxc = new RepairerLiveDBDemoUI2.a((byte)0);
    AppMethodBeat.o(278187);
  }
  
  public RepairerLiveDBDemoUI2()
  {
    AppMethodBeat.i(278168);
    this.tRX = "DemoThread";
    this.xZP = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(278168);
  }
  
  private static final void a(RepairerLiveDBDemoUI2 paramRepairerLiveDBDemoUI2, View paramView)
  {
    AppMethodBeat.i(278177);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerLiveDBDemoUI2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveDBDemoUI2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerLiveDBDemoUI2, "this$0");
    d.e(paramRepairerLiveDBDemoUI2.tRX, (kotlin.g.a.a)d.Oxg);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveDBDemoUI2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278177);
  }
  
  public final com.tencent.mm.plugin.mvvmlist.g<l> fcp()
  {
    AppMethodBeat.i(278222);
    com.tencent.mm.plugin.mvvmlist.g localg = (com.tencent.mm.plugin.mvvmlist.g)this.xZP.getValue();
    AppMethodBeat.o(278222);
    return localg;
  }
  
  public final Button gNi()
  {
    AppMethodBeat.i(278211);
    Button localButton = this.Oxd;
    if (localButton != null)
    {
      AppMethodBeat.o(278211);
      return localButton;
    }
    s.bIx("text");
    AppMethodBeat.o(278211);
    return null;
  }
  
  public final h gNj()
  {
    AppMethodBeat.i(278217);
    h localh = this.Oxe;
    if (localh != null)
    {
      AppMethodBeat.o(278217);
      return localh;
    }
    s.bIx("dataSource");
    AppMethodBeat.o(278217);
    return null;
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovy;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278226);
    super.onCreate(paramBundle);
    setMMTitle("LiveDBDemo2");
    paramBundle = (Button)findViewById(b.c.Ouc);
    s.u(paramBundle, "<set-?>");
    this.Oxd = paramBundle;
    gNi().setOnClickListener(new RepairerLiveDBDemoUI2..ExternalSyntheticLambda0(this));
    d.e(this.tRX, (kotlin.g.a.a)new e(this));
    AppMethodBeat.o(278226);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem1;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.g<l>>
  {
    b(RepairerLiveDBDemoUI2 paramRepairerLiveDBDemoUI2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveDBDemoUI2$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.view.recyclerview.g
  {
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(278394);
      f localf = (f)new e();
      AppMethodBeat.o(278394);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final d Oxg;
    
    static
    {
      AppMethodBeat.i(278392);
      Oxg = new d();
      AppMethodBeat.o(278392);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(RepairerLiveDBDemoUI2 paramRepairerLiveDBDemoUI2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerLiveDBDemoUI2
 * JD-Core Version:    0.7.0.1
 */