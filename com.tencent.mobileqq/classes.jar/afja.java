import android.support.v4.util.SparseArrayCompat;

public class afja<T>
{
  SparseArrayCompat<afiz<T>> a = new SparseArrayCompat();
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(T paramT, int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((afiz)this.a.valueAt(i)).a(paramT, paramInt)) {
        return this.a.keyAt(i);
      }
      i -= 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + paramInt + " in data source");
  }
  
  public afiz a(int paramInt)
  {
    return (afiz)this.a.get(paramInt);
  }
  
  public afja<T> a(afiz<T> paramafiz)
  {
    int i = this.a.size();
    if (paramafiz != null) {
      this.a.put(i, paramafiz);
    }
    return this;
  }
  
  public void a(afjh paramafjh, T paramT, int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      afiz localafiz = (afiz)this.a.valueAt(i);
      if (localafiz.a(paramT, paramInt))
      {
        localafiz.a(paramafjh, paramT, paramInt);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + paramInt + " in data source");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afja
 * JD-Core Version:    0.7.0.1
 */