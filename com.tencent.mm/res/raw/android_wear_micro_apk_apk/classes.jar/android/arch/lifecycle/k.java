package android.arch.lifecycle;

import java.lang.reflect.Method;

final class k
{
  final int K;
  final Method L;
  
  k(int paramInt, Method paramMethod)
  {
    this.K = paramInt;
    this.L = paramMethod;
    this.L.setAccessible(true);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (k)paramObject;
    } while ((this.K == paramObject.K) && (this.L.getName().equals(paramObject.L.getName())));
    return false;
  }
  
  public final int hashCode()
  {
    return this.K * 31 + this.L.getName().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.k
 * JD-Core Version:    0.7.0.1
 */