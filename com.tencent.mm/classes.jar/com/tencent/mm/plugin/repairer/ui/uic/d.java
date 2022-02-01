package com.tencent.mm.plugin.repairer.ui.uic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmActivity;
import com.tencent.mm.plugin.repairer.ui.d.c;
import com.tencent.mm.plugin.repairer.ui.d.e;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/uic/RepairerSearchDataUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "indexList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "searchObj", "Lkotlinx/coroutines/Job;", "getSearchObj", "()Lkotlinx/coroutines/Job;", "setSearchObj", "(Lkotlinx/coroutines/Job;)V", "buildSearchIndex", "", "repairerItem", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.mvvmbase.a
{
  private final LinkedList<ept> AdX;
  cb OyF;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(278040);
    this.AdX = new LinkedList();
    AppMethodBeat.o(278040);
  }
  
  public final void d(ept paramept)
  {
    AppMethodBeat.i(278069);
    s.u(paramept, "repairerItem");
    paramept = paramept.abtJ;
    s.s(paramept, "repairerItem.subItemList");
    paramept = ((Iterable)paramept).iterator();
    while (paramept.hasNext())
    {
      ept localept = (ept)paramept.next();
      if (localept.type == 1)
      {
        this.AdX.add(localept);
        s.s(localept, "it");
        d(localept);
      }
      else
      {
        this.AdX.add(localept);
      }
    }
    AppMethodBeat.o(278069);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278052);
    paramBundle = getLifecycleScope();
    if (paramBundle != null) {
      LifecycleScope.launchDefault$default(paramBundle, null, (m)new a(this, null), 1, null);
    }
    paramBundle = gst();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStateCenter();
      if (paramBundle != null) {
        paramBundle.process((q)getActivity(), (kotlin.g.a.b)d.b.OyH);
      }
    }
    paramBundle = gst();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStateCenter();
      if (paramBundle != null) {
        paramBundle.observe((q)getActivity(), (kotlin.g.a.b)new c(this));
      }
    }
    AppMethodBeat.o(278052);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(278061);
    paramBundle = gst();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStateCenter();
      if (paramBundle != null) {
        paramBundle.dispatch((IStateAction)new com.tencent.mm.plugin.repairer.ui.d.a(new ept()));
      }
    }
    AppMethodBeat.o(278061);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(d paramd, kotlin.d.d<? super a> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(278066);
      paramObject = (kotlin.d.d)new a(this.OyG, paramd);
      AppMethodBeat.o(278066);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(278060);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(278060);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = new ept();
      localObject = this.OyG.getIntent().getByteArrayExtra("key_config_item_list");
      if (localObject != null) {
        paramObject.parseFrom((byte[])localObject);
      }
      this.OyG.d(paramObject);
      paramObject = this.OyG.gst();
      if (paramObject != null)
      {
        paramObject = paramObject.getStateCenter();
        if (paramObject != null) {
          paramObject.dispatch((IStateAction)new com.tencent.mm.plugin.repairer.ui.d.d((List)d.a(this.OyG)));
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(278060);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/repairer/ui/state/RepairerState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.repairer.ui.d.b, ah>
  {
    c(d paramd)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(e parame, d paramd, kotlin.d.d<? super a> paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(278089);
        paramObject = (kotlin.d.d)new a(this.OyI, this.OyG, paramd);
        AppMethodBeat.o(278089);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(278081);
        Object localObject1 = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(278081);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = new LinkedList();
        if (!n.bp((CharSequence)this.OyI.query))
        {
          Object localObject2 = (Iterable)d.a(this.OyG);
          localObject1 = this.OyI;
          localObject2 = ((Iterable)localObject2).iterator();
          label175:
          while (((Iterator)localObject2).hasNext())
          {
            ept localept = (ept)((Iterator)localObject2).next();
            String str = localept.name;
            if ((str != null) && (n.i((CharSequence)str, (CharSequence)((e)localObject1).query) == true)) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label175;
              }
              paramObject.add(localept);
              break;
            }
          }
        }
        localObject1 = this.OyG.gst();
        if (localObject1 != null)
        {
          localObject1 = ((BaseMvvmActivity)localObject1).getStateCenter();
          if (localObject1 != null) {
            ((UIStateCenter)localObject1).dispatch((IStateAction)new c((List)paramObject));
          }
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(278081);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.uic.d
 * JD-Core Version:    0.7.0.1
 */