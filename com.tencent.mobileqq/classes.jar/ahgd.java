import android.support.v4.util.SparseArrayCompat;

public class ahgd<T>
{
  SparseArrayCompat<ahgc<T>> a = new SparseArrayCompat();
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(T paramT, int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((ahgc)this.a.valueAt(i)).a(paramT, paramInt)) {
        return this.a.keyAt(i);
      }
      i -= 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + paramInt + " in data source");
  }
  
  public ahgc a(int paramInt)
  {
    return (ahgc)this.a.get(paramInt);
  }
  
  public ahgd<T> a(ahgc<T> paramahgc)
  {
    int i = this.a.size();
    if (paramahgc != null) {
      this.a.put(i, paramahgc);
    }
    return this;
  }
  
  public void a(ahgk paramahgk, T paramT, int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ahgc localahgc = (ahgc)this.a.valueAt(i);
      if (localahgc.a(paramT, paramInt))
      {
        localahgc.a(paramahgk, paramT, paramInt);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + paramInt + " in data source");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgd
 * JD-Core Version:    0.7.0.1
 */