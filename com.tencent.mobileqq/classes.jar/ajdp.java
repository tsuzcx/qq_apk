import android.support.v4.util.SparseArrayCompat;

public class ajdp<T>
{
  SparseArrayCompat<ajdo<T>> a = new SparseArrayCompat();
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(T paramT, int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((ajdo)this.a.valueAt(i)).a(paramT, paramInt)) {
        return this.a.keyAt(i);
      }
      i -= 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + paramInt + " in data source");
  }
  
  public ajdo a(int paramInt)
  {
    return (ajdo)this.a.get(paramInt);
  }
  
  public ajdp<T> a(ajdo<T> paramajdo)
  {
    int i = this.a.size();
    if (paramajdo != null) {
      this.a.put(i, paramajdo);
    }
    return this;
  }
  
  public void a(ajdw paramajdw, T paramT, int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ajdo localajdo = (ajdo)this.a.valueAt(i);
      if (localajdo.a(paramT, paramInt))
      {
        localajdo.a(paramajdw, paramT, paramInt);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + paramInt + " in data source");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdp
 * JD-Core Version:    0.7.0.1
 */