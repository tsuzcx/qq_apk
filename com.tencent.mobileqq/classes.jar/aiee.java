import android.support.v4.util.SparseArrayCompat;

public class aiee
{
  private SparseArrayCompat<SparseArrayCompat<afal>> a = new SparseArrayCompat(15);
  private SparseArrayCompat<afak> b = new SparseArrayCompat();
  
  public aiee(aifb paramaifb)
  {
    a(1, new aifp(paramaifb));
    a(2, new aifa(paramaifb));
    a(3, new aiei(paramaifb));
  }
  
  private void a(int paramInt, afal paramafal)
  {
    this.b.put(paramInt, paramafal);
    int[] arrayOfInt = paramafal.a();
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
      localSparseArrayCompat1.put(paramInt, paramafal);
      i += 1;
    }
  }
  
  public <T extends afak> T a(int paramInt)
  {
    return (afak)this.b.get(paramInt);
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
        ((afal)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiee
 * JD-Core Version:    0.7.0.1
 */