import android.support.v4.util.SparseArrayCompat;

public class afiy<T>
{
  SparseArrayCompat<afix<T>> a = new SparseArrayCompat();
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(T paramT, int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((afix)this.a.valueAt(i)).a(paramT, paramInt)) {
        return this.a.keyAt(i);
      }
      i -= 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + paramInt + " in data source");
  }
  
  public afix a(int paramInt)
  {
    return (afix)this.a.get(paramInt);
  }
  
  public afiy<T> a(afix<T> paramafix)
  {
    int i = this.a.size();
    if (paramafix != null) {
      this.a.put(i, paramafix);
    }
    return this;
  }
  
  public void a(afjf paramafjf, T paramT, int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      afix localafix = (afix)this.a.valueAt(i);
      if (localafix.a(paramT, paramInt))
      {
        localafix.a(paramafjf, paramT, paramInt);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + paramInt + " in data source");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afiy
 * JD-Core Version:    0.7.0.1
 */