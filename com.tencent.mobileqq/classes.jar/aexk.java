import android.support.v4.util.SparseArrayCompat;

public class aexk<T>
{
  SparseArrayCompat<aexj<T>> a = new SparseArrayCompat();
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(T paramT, int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((aexj)this.a.valueAt(i)).a(paramT, paramInt)) {
        return this.a.keyAt(i);
      }
      i -= 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + paramInt + " in data source");
  }
  
  public aexj a(int paramInt)
  {
    return (aexj)this.a.get(paramInt);
  }
  
  public aexk<T> a(aexj<T> paramaexj)
  {
    int i = this.a.size();
    if (paramaexj != null) {
      this.a.put(i, paramaexj);
    }
    return this;
  }
  
  public void a(aexr paramaexr, T paramT, int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      aexj localaexj = (aexj)this.a.valueAt(i);
      if (localaexj.a(paramT, paramInt))
      {
        localaexj.a(paramaexr, paramT, paramInt);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + paramInt + " in data source");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexk
 * JD-Core Version:    0.7.0.1
 */