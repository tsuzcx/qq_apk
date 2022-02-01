import android.support.v4.util.SparseArrayCompat;

public class ajzm
{
  private SparseArrayCompat<SparseArrayCompat<agma>> a = new SparseArrayCompat(17);
  private SparseArrayCompat<aglz> b = new SparseArrayCompat();
  
  public ajzm(akaj paramakaj)
  {
    a(1, new akax(paramakaj));
    a(2, new akai(paramakaj));
    a(3, new ajzq(paramakaj));
  }
  
  private void a(int paramInt, agma paramagma)
  {
    this.b.put(paramInt, paramagma);
    int[] arrayOfInt = paramagma.a();
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
      localSparseArrayCompat1.put(paramInt, paramagma);
      i += 1;
    }
  }
  
  public <T extends aglz> T a(int paramInt)
  {
    return (aglz)this.b.get(paramInt);
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
        ((agma)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzm
 * JD-Core Version:    0.7.0.1
 */