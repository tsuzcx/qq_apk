package com.tencent.mm.sdk.event;

import androidx.lifecycle.x;
import com.tencent.mm.sdk.observer.ILifecycleObserver;
import com.tencent.mm.sdk.observer.LifecycleObserverOwner;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/event/LifecycleEvent;", "D", "Landroidx/lifecycle/ViewModel;", "()V", "observerOwner", "Lcom/tencent/mm/sdk/observer/LifecycleObserverOwner;", "Lcom/tencent/mm/sdk/event/ILifecycleEventObserver;", "getObserverOwner", "()Lcom/tencent/mm/sdk/observer/LifecycleObserverOwner;", "observe", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "threadTag", "", "observeInUIThread", "publish", "data", "(Ljava/lang/Object;)V", "removeObserver", "wechat-sdk_release"})
public abstract class LifecycleEvent<D>
  extends x
{
  private final LifecycleObserverOwner<ILifecycleEventObserver<D>, D> observerOwner = (LifecycleObserverOwner)new LifecycleObserverOwner()
  {
    public final String getDefaultThreadTag()
    {
      return "Mvvm.EventCenterObserver";
    }
    
    public final String getLogTag()
    {
      return "MicroMsg.Mvvm.LifecycleEventCenter";
    }
  };
  
  public final LifecycleObserverOwner<ILifecycleEventObserver<D>, D> getObserverOwner()
  {
    return this.observerOwner;
  }
  
  public final void observe(androidx.lifecycle.l paraml, ILifecycleEventObserver<D> paramILifecycleEventObserver)
  {
    p.k(paraml, "lifecycleOwner");
    p.k(paramILifecycleEventObserver, "observer");
    this.observerOwner.observe(paraml, (ILifecycleObserver)paramILifecycleEventObserver);
  }
  
  public final void observe(androidx.lifecycle.l paraml, String paramString, ILifecycleEventObserver<D> paramILifecycleEventObserver)
  {
    p.k(paraml, "lifecycleOwner");
    p.k(paramString, "threadTag");
    p.k(paramILifecycleEventObserver, "observer");
    this.observerOwner.observe(paraml, paramString, (ILifecycleObserver)paramILifecycleEventObserver);
  }
  
  public final void observeInUIThread(androidx.lifecycle.l paraml, ILifecycleEventObserver<D> paramILifecycleEventObserver)
  {
    p.k(paraml, "lifecycleOwner");
    p.k(paramILifecycleEventObserver, "observer");
    this.observerOwner.observe(paraml, "%MainThread%", (ILifecycleObserver)paramILifecycleEventObserver);
  }
  
  public final void publish(D paramD)
  {
    this.observerOwner.notify(paramD);
  }
  
  public final void removeObserver(ILifecycleEventObserver<D> paramILifecycleEventObserver)
  {
    p.k(paramILifecycleEventObserver, "observer");
    this.observerOwner.removeObserver((ILifecycleObserver)paramILifecycleEventObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.event.LifecycleEvent
 * JD-Core Version:    0.7.0.1
 */