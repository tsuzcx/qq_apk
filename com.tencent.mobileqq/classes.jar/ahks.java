import android.support.v4.util.SparseArrayCompat;

public class ahks<T>
{
  SparseArrayCompat<ahkr<T>> a = new SparseArrayCompat();
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(T paramT, int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((ahkr)this.a.valueAt(i)).a(paramT, paramInt)) {
        return this.a.keyAt(i);
      }
      i -= 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + paramInt + " in data source");
  }
  
  public ahkr a(int paramInt)
  {
    return (ahkr)this.a.get(paramInt);
  }
  
  public ahks<T> a(ahkr<T> paramahkr)
  {
    int i = this.a.size();
    if (paramahkr != null) {
      this.a.put(i, paramahkr);
    }
    return this;
  }
  
  public void a(ahkz paramahkz, T paramT, int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ahkr localahkr = (ahkr)this.a.valueAt(i);
      if (localahkr.a(paramT, paramInt))
      {
        localahkr.a(paramahkz, paramT, paramInt);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + paramInt + " in data source");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahks
 * JD-Core Version:    0.7.0.1
 */