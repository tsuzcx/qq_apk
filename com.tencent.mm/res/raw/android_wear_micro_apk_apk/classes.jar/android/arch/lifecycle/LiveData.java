package android.arch.lifecycle;

import android.arch.a.a.a;
import android.arch.a.b.b;

public abstract class LiveData<T>
{
  private static final Object Y = new Object();
  private b<q<T>, LiveData<T>.n> Z;
  private int aa;
  private volatile Object ab;
  private int ac;
  private boolean ad;
  private boolean ae;
  
  private void a(LiveData<T>.n paramLiveData)
  {
    if (!paramLiveData.ai) {}
    do
    {
      return;
      if (!paramLiveData.n())
      {
        paramLiveData.a(false);
        return;
      }
    } while (paramLiveData.aj >= this.ac);
    paramLiveData.aj = this.ac;
    paramLiveData.ah.d(this.ab);
  }
  
  public final void a(i parami, q<T> paramq)
  {
    if (parami.h().g() == g.H) {}
    LiveData.LifecycleBoundObserver localLifecycleBoundObserver;
    do
    {
      return;
      localLifecycleBoundObserver = new LiveData.LifecycleBoundObserver(this, parami, paramq);
      paramq = (n)this.Z.putIfAbsent(paramq, localLifecycleBoundObserver);
      if ((paramq != null) && (!paramq.c(parami))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (paramq != null);
    parami.h().a(localLifecycleBoundObserver);
  }
  
  public void a(q<T> paramq)
  {
    if (!a.a().b()) {
      throw new IllegalStateException("Cannot invoke " + "removeObserver" + " on a background thread");
    }
    paramq = (n)this.Z.remove(paramq);
    if (paramq == null) {
      return;
    }
    paramq.o();
    paramq.a(false);
  }
  
  public final T getValue()
  {
    Object localObject = this.ab;
    if (localObject != Y) {
      return localObject;
    }
    return null;
  }
  
  protected void l() {}
  
  public final boolean m()
  {
    return this.aa > 0;
  }
  
  protected void onActive() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.LiveData
 * JD-Core Version:    0.7.0.1
 */