package android.support.v4.b;

public final class q<T>
  extends p<T>
{
  private final Object f = new Object();
  
  public q()
  {
    super(12);
  }
  
  public final T bC()
  {
    synchronized (this.f)
    {
      Object localObject2 = super.bC();
      return localObject2;
    }
  }
  
  public final boolean t(T paramT)
  {
    synchronized (this.f)
    {
      boolean bool = super.t(paramT);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.q
 * JD-Core Version:    0.7.0.1
 */