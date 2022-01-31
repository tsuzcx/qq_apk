import android.support.v4.util.SparseArrayCompat;

public class agfz
{
  private SparseArrayCompat<SparseArrayCompat<adif>> a = new SparseArrayCompat(15);
  private SparseArrayCompat<adie> b = new SparseArrayCompat();
  
  public agfz(aggw paramaggw)
  {
    a(1, new aghk(paramaggw));
    a(2, new aggv(paramaggw));
    a(3, new aggd(paramaggw));
  }
  
  private void a(int paramInt, adif paramadif)
  {
    this.b.put(paramInt, paramadif);
    int[] arrayOfInt = paramadif.a();
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
      localSparseArrayCompat1.put(paramInt, paramadif);
      i += 1;
    }
  }
  
  public <T extends adie> T a(int paramInt)
  {
    return (adie)this.b.get(paramInt);
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
        ((adif)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfz
 * JD-Core Version:    0.7.0.1
 */