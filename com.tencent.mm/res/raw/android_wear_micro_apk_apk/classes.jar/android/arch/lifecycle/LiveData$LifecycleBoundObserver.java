package android.arch.lifecycle;

class LiveData$LifecycleBoundObserver
  extends LiveData<T>.n
  implements GenericLifecycleObserver
{
  final i af;
  
  LiveData$LifecycleBoundObserver(i parami, q<T> paramq)
  {
    super(parami, localq);
    this.af = paramq;
  }
  
  public final void a(i parami, f paramf)
  {
    if (this.af.h().g() == g.H)
    {
      this.ag.a(this.ah);
      return;
    }
    a(n());
  }
  
  final boolean c(i parami)
  {
    return this.af == parami;
  }
  
  final boolean n()
  {
    return this.af.h().g().a(g.K);
  }
  
  final void o()
  {
    this.af.h().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.LiveData.LifecycleBoundObserver
 * JD-Core Version:    0.7.0.1
 */