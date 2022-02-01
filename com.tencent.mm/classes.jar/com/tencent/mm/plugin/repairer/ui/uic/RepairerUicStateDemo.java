package com.tencent.mm.plugin.repairer.ui.uic;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.e;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.component.p;
import com.tencent.mm.ui.component.support.c;
import com.tencent.mm.ui.component.support.c.b;
import com.tencent.mm.ui.component.support.c.c;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.b.x;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/uic/RepairerUicStateDemo;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerUicStateDemo
  extends MMActivity
{
  public static final a OyJ;
  
  static
  {
    AppMethodBeat.i(278087);
    OyJ = new a((byte)0);
    AppMethodBeat.o(278087);
  }
  
  private static final void a(RepairerUicStateDemo paramRepairerUicStateDemo, View paramView)
  {
    AppMethodBeat.i(278078);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerUicStateDemo);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/uic/RepairerUicStateDemo", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerUicStateDemo, "this$0");
    kotlinx.coroutines.ar.a(paramRepairerUicStateDemo.getLifecycleAsyncScope(), "cancel by click!");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/uic/RepairerUicStateDemo", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278078);
  }
  
  private static final void a(f paramf, View paramView)
  {
    AppMethodBeat.i(278070);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/uic/RepairerUicStateDemo", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "$state1");
    paramf.OyR += 1;
    paramf.jxQ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/uic/RepairerUicStateDemo", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278070);
  }
  
  public final int getLayoutId()
  {
    return b.d.Owe;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(278115);
    Set localSet = kotlin.a.ar.setOf(new Class[] { g.class, i.class });
    AppMethodBeat.o(278115);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278132);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = ((g)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(g.class)).OyT;
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this);
    s.u(a.class, "apiClass");
    Object localObject2 = (h)((com.tencent.mm.ui.component.d)((k.b)localObject1).cq(a.class)).gND();
    localObject1 = new c().a((p)paramBundle).b((p)localObject2).aU((kotlin.g.a.b)c.OyN).v((m)d.OyO).a(getLifecycleAsyncScope(), 1);
    localObject2 = new c().a((p)paramBundle).b((p)localObject2).aU((kotlin.g.a.b)e.OyP).v((m)f.OyQ).a(getLifecycleAsyncScope(), "init");
    Log.i("RepairerUicStateDemo", s.X("stateTransform2.init=", ((x)localObject2).getValue()));
    Object localObject3 = com.tencent.mm.ui.component.k.aeZF;
    localObject3 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mvvmbase.a.a.class);
    s.s(localObject3, "UICProvider.of(this).get…ycleScopeUIC::class.java)");
    e.launch$default((e)localObject3, null, null, (m)new b((w)localObject1, (x)localObject2, null), 3, null);
    findViewById(b.c.Ovg).setOnClickListener(new RepairerUicStateDemo..ExternalSyntheticLambda1(paramBundle));
    findViewById(b.c.cancel).setOnClickListener(new RepairerUicStateDemo..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(278132);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/uic/RepairerUicStateDemo$Companion;", "", "()V", "TAG", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(w<String> paramw, x<String> paramx, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(278054);
      paramObject = (kotlin.d.d)new b(this.OyK, this.OyL, paramd);
      AppMethodBeat.o(278054);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(278048);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(278048);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.b.g)this.OyK;
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.OyL);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(278048);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(278048);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<String>
    {
      public a(x paramx) {}
      
      public final Object a(String paramString, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(278045);
        Log.i("RepairerUicStateDemo", String.valueOf((String)paramString));
        Log.i("RepairerUicStateDemo", String.valueOf(this.OyM.getValue()));
        paramString = ah.aiuX;
        AppMethodBeat.o(278045);
        return paramString;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/component/UicState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<p, ah>
  {
    public static final c OyN;
    
    static
    {
      AppMethodBeat.i(278042);
      OyN = new c();
      AppMethodBeat.o(278042);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/repairer/ui/uic/Test1State;", "state2", "Lcom/tencent/mm/plugin/repairer/ui/uic/Test2State;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<f, h, String>
  {
    public static final d OyO;
    
    static
    {
      AppMethodBeat.i(278046);
      OyO = new d();
      AppMethodBeat.o(278046);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/component/UicState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<p, ah>
  {
    public static final e OyP;
    
    static
    {
      AppMethodBeat.i(278053);
      OyP = new e();
      AppMethodBeat.o(278053);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/repairer/ui/uic/Test1State;", "state2", "Lcom/tencent/mm/plugin/repairer/ui/uic/Test2State;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<f, h, String>
  {
    public static final f OyQ;
    
    static
    {
      AppMethodBeat.i(278039);
      OyQ = new f();
      AppMethodBeat.o(278039);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.uic.RepairerUicStateDemo
 * JD-Core Version:    0.7.0.1
 */