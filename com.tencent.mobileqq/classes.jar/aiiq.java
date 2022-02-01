import android.support.v4.util.SparseArrayCompat;

public class aiiq<T>
{
  SparseArrayCompat<aiip<T>> a = new SparseArrayCompat();
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(T paramT, int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((aiip)this.a.valueAt(i)).a(paramT, paramInt)) {
        return this.a.keyAt(i);
      }
      i -= 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + paramInt + " in data source");
  }
  
  public aiip a(int paramInt)
  {
    return (aiip)this.a.get(paramInt);
  }
  
  public aiiq<T> a(aiip<T> paramaiip)
  {
    int i = this.a.size();
    if (paramaiip != null) {
      this.a.put(i, paramaiip);
    }
    return this;
  }
  
  public void a(aiix paramaiix, T paramT, int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      aiip localaiip = (aiip)this.a.valueAt(i);
      if (localaiip.a(paramT, paramInt))
      {
        localaiip.a(paramaiix, paramT, paramInt);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + paramInt + " in data source");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiiq
 * JD-Core Version:    0.7.0.1
 */