package android.arch.lifecycle;

class ReflectiveGenericLifecycleObserver
  implements GenericLifecycleObserver
{
  private final Object al;
  private final b am;
  
  ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    this.al = paramObject;
    this.am = a.v.c(this.al.getClass());
  }
  
  public final void a(i parami, f paramf)
  {
    this.am.a(parami, paramf, this.al);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.ReflectiveGenericLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */