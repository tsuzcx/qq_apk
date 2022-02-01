import android.support.v4.util.SparseArrayCompat;

public class ajoh<T>
{
  SparseArrayCompat<ajog<T>> a = new SparseArrayCompat();
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(T paramT, int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((ajog)this.a.valueAt(i)).a(paramT, paramInt)) {
        return this.a.keyAt(i);
      }
      i -= 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + paramInt + " in data source");
  }
  
  public ajog a(int paramInt)
  {
    return (ajog)this.a.get(paramInt);
  }
  
  public ajoh<T> a(ajog<T> paramajog)
  {
    int i = this.a.size();
    if (paramajog != null) {
      this.a.put(i, paramajog);
    }
    return this;
  }
  
  public void a(ajoo paramajoo, T paramT, int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ajog localajog = (ajog)this.a.valueAt(i);
      if (localajog.a(paramT, paramInt))
      {
        localajog.a(paramajoo, paramT, paramInt);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + paramInt + " in data source");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoh
 * JD-Core Version:    0.7.0.1
 */