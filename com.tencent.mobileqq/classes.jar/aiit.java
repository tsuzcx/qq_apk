import android.support.v4.util.SparseArrayCompat;

public class aiit
{
  private SparseArrayCompat<SparseArrayCompat<affa>> a = new SparseArrayCompat(15);
  private SparseArrayCompat<afez> b = new SparseArrayCompat();
  
  public aiit(aijq paramaijq)
  {
    a(1, new aike(paramaijq));
    a(2, new aijp(paramaijq));
    a(3, new aiix(paramaijq));
  }
  
  private void a(int paramInt, affa paramaffa)
  {
    this.b.put(paramInt, paramaffa);
    int[] arrayOfInt = paramaffa.a();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.a.get(k);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.a.put(k, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramaffa);
      i += 1;
    }
  }
  
  public <T extends afez> T a(int paramInt)
  {
    return (afez)this.b.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.a.get(paramInt);
    if (localSparseArrayCompat == null) {}
    for (;;)
    {
      return;
      int j = localSparseArrayCompat.size();
      int i = 0;
      while (i < j)
      {
        ((affa)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiit
 * JD-Core Version:    0.7.0.1
 */