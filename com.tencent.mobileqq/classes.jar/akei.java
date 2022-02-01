import android.support.v4.util.SparseArrayCompat;

public class akei
{
  private SparseArrayCompat<SparseArrayCompat<agin>> a = new SparseArrayCompat(18);
  private SparseArrayCompat<agim> b = new SparseArrayCompat();
  
  public akei(akfg paramakfg)
  {
    a(1, new akfu(paramakfg));
    a(2, new akff(paramakfg));
    a(3, new akem(paramakfg));
  }
  
  private void a(int paramInt, agin paramagin)
  {
    this.b.put(paramInt, paramagin);
    int[] arrayOfInt = paramagin.a();
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
      localSparseArrayCompat1.put(paramInt, paramagin);
      i += 1;
    }
  }
  
  public <T extends agim> T a(int paramInt)
  {
    return (agim)this.b.get(paramInt);
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
        ((agin)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akei
 * JD-Core Version:    0.7.0.1
 */