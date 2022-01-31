package android.support.v4.b;

public final class p<T>
  implements o<T>
{
  private final Object[] ju = new Object[30];
  private int jv;
  
  public final T bl()
  {
    if (this.jv > 0)
    {
      int i = this.jv - 1;
      Object localObject = this.ju[i];
      this.ju[i] = null;
      this.jv -= 1;
      return localObject;
    }
    return null;
  }
  
  public final boolean m(T paramT)
  {
    boolean bool = false;
    int i = 0;
    if (i < this.jv) {
      if (this.ju[i] != paramT) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label50;
      }
      throw new IllegalStateException("Already in the pool!");
      i += 1;
      break;
    }
    label50:
    if (this.jv < this.ju.length)
    {
      this.ju[this.jv] = paramT;
      this.jv += 1;
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.p
 * JD-Core Version:    0.7.0.1
 */