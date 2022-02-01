package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.sdk.storage.observer.StorageEventId;
import com.tencent.mm.sdk.storage.observer.StorageEventId.Companion;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerLiveDBDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "ThreadTag", "", "getThreadTag", "()Ljava/lang/String;", "adapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem;", "getAdapter", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "getLiveList", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "liveList$delegate", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerLiveDBDemoUI
  extends BaseRepairerUI
{
  public static final RepairerLiveDBDemoUI.a OwZ;
  private final j FWi;
  private final String tRX;
  final j xZP;
  WxRecyclerView yAg;
  
  static
  {
    AppMethodBeat.i(278214);
    OwZ = new RepairerLiveDBDemoUI.a((byte)0);
    AppMethodBeat.o(278214);
  }
  
  public RepairerLiveDBDemoUI()
  {
    AppMethodBeat.i(278176);
    this.tRX = "DemoThread";
    this.FWi = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.xZP = kotlin.k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(278176);
  }
  
  private static final void a(RepairerLiveDBDemoUI paramRepairerLiveDBDemoUI, View paramView)
  {
    AppMethodBeat.i(278190);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerLiveDBDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveDBDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramRepairerLiveDBDemoUI, "this$0");
    com.tencent.mm.ae.d.e(paramRepairerLiveDBDemoUI.tRX, (kotlin.g.a.a)f.Oxb);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveDBDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278190);
  }
  
  private static final boolean a(RepairerLiveDBDemoUI paramRepairerLiveDBDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278182);
    kotlin.g.b.s.u(paramRepairerLiveDBDemoUI, "this$0");
    paramRepairerLiveDBDemoUI.finish();
    AppMethodBeat.o(278182);
    return true;
  }
  
  public final MvvmList<k> gNg()
  {
    AppMethodBeat.i(278227);
    MvvmList localMvvmList = (MvvmList)this.FWi.getValue();
    AppMethodBeat.o(278227);
    return localMvvmList;
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovy;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278235);
    super.onCreate(paramBundle);
    setMMTitle("LiveDBDemo");
    setBackBtn(new RepairerLiveDBDemoUI..ExternalSyntheticLambda0(this));
    com.tencent.mm.ae.d.e(this.tRX, (kotlin.g.a.a)new e(this));
    paramBundle = findViewById(b.c.Ouc);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerLiveDBDemoUI..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(278235);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.g<k>>
  {
    b(RepairerLiveDBDemoUI paramRepairerLiveDBDemoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/demo/RepairerLiveDBDemoUI$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.view.recyclerview.g
  {
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(278312);
      f localf = (f)new d();
      AppMethodBeat.o(278312);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<MvvmList<k>>
  {
    d(RepairerLiveDBDemoUI paramRepairerLiveDBDemoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(RepairerLiveDBDemoUI paramRepairerLiveDBDemoUI)
    {
      super();
    }
    
    private static final void a(RepairerLiveDBDemoUI paramRepairerLiveDBDemoUI, StorageObserverEvent paramStorageObserverEvent)
    {
      AppMethodBeat.i(278325);
      kotlin.g.b.s.u(paramRepairerLiveDBDemoUI, "this$0");
      kotlin.g.b.s.u(paramStorageObserverEvent, "event");
      StorageEventId localStorageEventId = paramStorageObserverEvent.getEventId();
      if (kotlin.g.b.s.p(localStorageEventId, StorageEventId.Companion.getINSERT()))
      {
        paramStorageObserverEvent = (s)paramStorageObserverEvent.getObj();
        if (paramStorageObserverEvent != null)
        {
          MvvmList.a(paramRepairerLiveDBDemoUI.gNg(), (com.tencent.mm.plugin.mvvmlist.b)new k(paramStorageObserverEvent));
          AppMethodBeat.o(278325);
        }
      }
      else if (kotlin.g.b.s.p(localStorageEventId, StorageEventId.Companion.getUPDATE()))
      {
        paramStorageObserverEvent = (s)paramStorageObserverEvent.getObj();
        if (paramStorageObserverEvent != null)
        {
          MvvmList.b(paramRepairerLiveDBDemoUI.gNg(), (com.tencent.mm.plugin.mvvmlist.b)new k(paramStorageObserverEvent));
          AppMethodBeat.o(278325);
        }
      }
      else if (kotlin.g.b.s.p(localStorageEventId, StorageEventId.Companion.getDELETE()))
      {
        paramStorageObserverEvent = (s)paramStorageObserverEvent.getObj();
        if (paramStorageObserverEvent != null) {
          paramRepairerLiveDBDemoUI.gNg().a((com.tencent.mm.plugin.mvvmlist.b)new k(paramStorageObserverEvent));
        }
      }
      AppMethodBeat.o(278325);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final f Oxb;
    
    static
    {
      AppMethodBeat.i(278322);
      Oxb = new f();
      AppMethodBeat.o(278322);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerLiveDBDemoUI
 * JD-Core Version:    0.7.0.1
 */