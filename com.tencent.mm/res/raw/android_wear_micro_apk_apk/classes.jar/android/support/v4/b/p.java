package android.support.v4.b;

public class p<T>
  implements o<T>
{
  private final Object[] lr;
  private int ls;
  
  public p(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    this.lr = new Object[paramInt];
  }
  
  public T bC()
  {
    if (this.ls > 0)
    {
      int i = this.ls - 1;
      Object localObject = this.lr[i];
      this.lr[i] = null;
      this.ls -= 1;
      return localObject;
    }
    return null;
  }
  
  public boolean t(T paramT)
  {
    boolean bool = false;
    int i = 0;
    if (i < this.ls) {
      if (this.lr[i] != paramT) {}
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
    if (this.ls < this.lr.length)
    {
      this.lr[this.ls] = paramT;
      this.ls += 1;
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.p
 * JD-Core Version:    0.7.0.1
 */