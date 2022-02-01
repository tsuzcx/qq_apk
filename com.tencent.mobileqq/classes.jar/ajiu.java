import android.support.v4.util.SparseArrayCompat;

public class ajiu
{
  private SparseArrayCompat<SparseArrayCompat<afrc>> a = new SparseArrayCompat(17);
  private SparseArrayCompat<afrb> b = new SparseArrayCompat();
  
  public ajiu(ajjs paramajjs)
  {
    a(1, new ajkg(paramajjs));
    a(2, new ajjr(paramajjs));
    a(3, new ajiy(paramajjs));
  }
  
  private void a(int paramInt, afrc paramafrc)
  {
    this.b.put(paramInt, paramafrc);
    int[] arrayOfInt = paramafrc.a();
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
      localSparseArrayCompat1.put(paramInt, paramafrc);
      i += 1;
    }
  }
  
  public <T extends afrb> T a(int paramInt)
  {
    return (afrb)this.b.get(paramInt);
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
        ((afrc)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajiu
 * JD-Core Version:    0.7.0.1
 */