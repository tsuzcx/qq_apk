package com.tencent.mm.sdk.statecenter;

import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/statecenter/RootProcessor;", "State", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "Lcom/tencent/mm/sdk/statecenter/IProcessor;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "processorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/sdk/statecenter/RootProcessor$LifecycleBoundProcessor;", "addProcessor", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "processor", "process", "state", "(Lcom/tencent/mm/sdk/statecenter/BaseState;)V", "Companion", "LifecycleBoundProcessor", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class RootProcessor<State extends BaseState>
  implements p, IProcessor<State>
{
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Mvvm.RootProcessor";
  private final ConcurrentHashMap<Integer, RootProcessor<State>.LifecycleBoundProcessor> processorMap;
  
  static
  {
    AppMethodBeat.i(243318);
    Companion = new Companion(null);
    AppMethodBeat.o(243318);
  }
  
  public RootProcessor()
  {
    AppMethodBeat.i(243307);
    this.processorMap = new ConcurrentHashMap();
    AppMethodBeat.o(243307);
  }
  
  public final void addProcessor(q paramq, IProcessor<State> paramIProcessor)
  {
    AppMethodBeat.i(243328);
    s.u(paramq, "lifecycleOwner");
    s.u(paramIProcessor, "processor");
    Object localObject = (LifecycleBoundProcessor)this.processorMap.get(Integer.valueOf(paramIProcessor.hashCode()));
    if (localObject != null)
    {
      localObject = ((LifecycleBoundProcessor)localObject).getOwner();
      if (!s.p(localObject, paramq))
      {
        i = 1;
        if (i == 0) {
          break label86;
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label92;
        }
        Log.e("MicroMsg.Mvvm.RootProcessor", "Cannot add the same processor with different lifecycles");
        AppMethodBeat.o(243328);
        return;
        i = 0;
        break;
        label86:
        localObject = null;
      }
    }
    label92:
    localObject = (Map)this.processorMap;
    int i = paramIProcessor.hashCode();
    paramq = new LifecycleBoundProcessor(paramq, paramIProcessor);
    paramq.attachObserver();
    ((Map)localObject).put(Integer.valueOf(i), paramq);
    AppMethodBeat.o(243328);
  }
  
  public void process(State paramState)
  {
    AppMethodBeat.i(243339);
    s.u(paramState, "state");
    Object localObject2 = (Map)this.processorMap;
    Object localObject1 = (Collection)new ArrayList(((Map)localObject2).size());
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add((LifecycleBoundProcessor)((Map.Entry)((Iterator)localObject2).next()).getValue());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((LifecycleBoundProcessor)((Iterator)localObject1).next()).process(paramState);
    }
    AppMethodBeat.o(243339);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/statecenter/RootProcessor$Companion;", "", "()V", "TAG", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/statecenter/RootProcessor$LifecycleBoundProcessor;", "Landroidx/lifecycle/LifecycleObserver;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "processor", "Lcom/tencent/mm/sdk/statecenter/IProcessor;", "(Lcom/tencent/mm/sdk/statecenter/RootProcessor;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/sdk/statecenter/IProcessor;)V", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getProcessor", "()Lcom/tencent/mm/sdk/statecenter/IProcessor;", "attachObserver", "", "detachObserver", "onLifecycleDestroy", "process", "state", "(Lcom/tencent/mm/sdk/statecenter/BaseState;)V", "shouldBeActive", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class LifecycleBoundProcessor
    implements p
  {
    private final q owner;
    private final IProcessor<State> processor;
    
    public LifecycleBoundProcessor(IProcessor<State> paramIProcessor)
    {
      AppMethodBeat.i(243305);
      this.owner = paramIProcessor;
      this.processor = localObject;
      AppMethodBeat.o(243305);
    }
    
    private final boolean shouldBeActive()
    {
      AppMethodBeat.i(243311);
      if (this.owner.getLifecycle().getCurrentState() != j.b.bHg)
      {
        AppMethodBeat.o(243311);
        return true;
      }
      AppMethodBeat.o(243311);
      return false;
    }
    
    public final void attachObserver()
    {
      AppMethodBeat.i(243332);
      if (shouldBeActive())
      {
        this.owner.getLifecycle().addObserver((p)this);
        AppMethodBeat.o(243332);
        return;
      }
      Log.e("MicroMsg.Mvvm.RootProcessor", "attachObserver fail, lifecycle is destroyed owner:" + this.owner.hashCode() + " observer:" + this.processor.hashCode());
      AppMethodBeat.o(243332);
    }
    
    public final void detachObserver()
    {
      AppMethodBeat.i(243338);
      this.owner.getLifecycle().removeObserver((p)this);
      AppMethodBeat.o(243338);
    }
    
    public final q getOwner()
    {
      return this.owner;
    }
    
    public final IProcessor<State> getProcessor()
    {
      return this.processor;
    }
    
    @z(Ho=j.a.ON_DESTROY)
    public void onLifecycleDestroy()
    {
      AppMethodBeat.i(243354);
      Log.i("MicroMsg.Mvvm.RootProcessor", "onLifecycleDestroy owner:" + this.owner.hashCode() + " observer:" + this.processor.hashCode());
      LifecycleBoundProcessor localLifecycleBoundProcessor = (LifecycleBoundProcessor)RootProcessor.access$getProcessorMap$p(RootProcessor.this).remove(Integer.valueOf(this.processor.hashCode()));
      if (localLifecycleBoundProcessor != null) {
        localLifecycleBoundProcessor.detachObserver();
      }
      AppMethodBeat.o(243354);
    }
    
    public final void process(State paramState)
    {
      AppMethodBeat.i(243347);
      s.u(paramState, "state");
      if (!shouldBeActive())
      {
        AppMethodBeat.o(243347);
        return;
      }
      this.processor.process(paramState);
      AppMethodBeat.o(243347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.statecenter.RootProcessor
 * JD-Core Version:    0.7.0.1
 */