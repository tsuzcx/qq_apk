import android.support.v4.util.SparseArrayCompat;

public class afuc
{
  private SparseArrayCompat<SparseArrayCompat<acxg>> a = new SparseArrayCompat(15);
  private SparseArrayCompat<acxf> b = new SparseArrayCompat();
  
  public afuc(afuz paramafuz)
  {
    a(1, new afvn(paramafuz));
    a(2, new afuy(paramafuz));
  }
  
  private void a(int paramInt, acxg paramacxg)
  {
    this.b.put(paramInt, paramacxg);
    int[] arrayOfInt = paramacxg.a();
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
      localSparseArrayCompat1.put(paramInt, paramacxg);
      i += 1;
    }
  }
  
  public <T extends acxf> T a(int paramInt)
  {
    return (acxf)this.b.get(paramInt);
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
        ((acxg)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuc
 * JD-Core Version:    0.7.0.1
 */