import android.support.v4.util.SparseArrayCompat;

public class aggb
{
  private SparseArrayCompat<SparseArrayCompat<adih>> a = new SparseArrayCompat(15);
  private SparseArrayCompat<adig> b = new SparseArrayCompat();
  
  public aggb(aggy paramaggy)
  {
    a(1, new aghm(paramaggy));
    a(2, new aggx(paramaggy));
    a(3, new aggf(paramaggy));
  }
  
  private void a(int paramInt, adih paramadih)
  {
    this.b.put(paramInt, paramadih);
    int[] arrayOfInt = paramadih.a();
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
      localSparseArrayCompat1.put(paramInt, paramadih);
      i += 1;
    }
  }
  
  public <T extends adig> T a(int paramInt)
  {
    return (adig)this.b.get(paramInt);
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
        ((adih)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggb
 * JD-Core Version:    0.7.0.1
 */