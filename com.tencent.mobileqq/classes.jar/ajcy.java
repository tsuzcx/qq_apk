import android.support.v4.util.SparseArrayCompat;

public class ajcy<T>
{
  SparseArrayCompat<ajcx<T>> a = new SparseArrayCompat();
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(T paramT, int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((ajcx)this.a.valueAt(i)).a(paramT, paramInt)) {
        return this.a.keyAt(i);
      }
      i -= 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + paramInt + " in data source");
  }
  
  public ajcx a(int paramInt)
  {
    return (ajcx)this.a.get(paramInt);
  }
  
  public ajcy<T> a(ajcx<T> paramajcx)
  {
    int i = this.a.size();
    if (paramajcx != null) {
      this.a.put(i, paramajcx);
    }
    return this;
  }
  
  public void a(ajdf paramajdf, T paramT, int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ajcx localajcx = (ajcx)this.a.valueAt(i);
      if (localajcx.a(paramT, paramInt))
      {
        localajcx.a(paramajdf, paramT, paramInt);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + paramInt + " in data source");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcy
 * JD-Core Version:    0.7.0.1
 */