package com.tencent.mm.sdk.event;

import androidx.lifecycle.af;
import androidx.lifecycle.q;
import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.observer.MvvmObserverOwner;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/event/BaseMvvmEvent;", "D", "Landroidx/lifecycle/ViewModel;", "()V", "observerOwner", "Lcom/tencent/mm/sdk/observer/MvvmObserverOwner;", "Lcom/tencent/mm/sdk/observer/IMvvmObserver;", "getObserverOwner", "()Lcom/tencent/mm/sdk/observer/MvvmObserverOwner;", "observe", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "threadTag", "", "observeInUIThread", "publish", "data", "(Ljava/lang/Object;)V", "removeObserver", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseMvvmEvent<D>
  extends af
{
  private final MvvmObserverOwner<IMvvmObserver<D>, D> observerOwner = (MvvmObserverOwner)new MvvmObserverOwner()
  {
    public final String getLogTag()
    {
      return "MicroMsg.Mvvm.MvvmEventCenter";
    }
  };
  
  public final MvvmObserverOwner<IMvvmObserver<D>, D> getObserverOwner()
  {
    return this.observerOwner;
  }
  
  public final void observe(q paramq, IMvvmObserver<D> paramIMvvmObserver)
  {
    s.u(paramq, "lifecycleOwner");
    s.u(paramIMvvmObserver, "observer");
    this.observerOwner.observe(paramq, paramIMvvmObserver);
  }
  
  public final void observe(q paramq, String paramString, IMvvmObserver<D> paramIMvvmObserver)
  {
    s.u(paramq, "lifecycleOwner");
    s.u(paramString, "threadTag");
    s.u(paramIMvvmObserver, "observer");
    this.observerOwner.observe(paramq, paramString, paramIMvvmObserver);
  }
  
  public final void observeInUIThread(q paramq, IMvvmObserver<D> paramIMvvmObserver)
  {
    s.u(paramq, "lifecycleOwner");
    s.u(paramIMvvmObserver, "observer");
    this.observerOwner.observe(paramq, "%MainThread%", paramIMvvmObserver);
  }
  
  public final void publish(D paramD)
  {
    this.observerOwner.notify(paramD);
  }
  
  public final void removeObserver(IMvvmObserver<D> paramIMvvmObserver)
  {
    s.u(paramIMvvmObserver, "observer");
    this.observerOwner.removeObserver(paramIMvvmObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.event.BaseMvvmEvent
 * JD-Core Version:    0.7.0.1
 */