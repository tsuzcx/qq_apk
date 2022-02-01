import android.support.v4.util.SparseArrayCompat;

public class akkv
{
  private SparseArrayCompat<SparseArrayCompat<agvc>> a = new SparseArrayCompat(17);
  private SparseArrayCompat<agvb> b = new SparseArrayCompat();
  
  public akkv(aklt paramaklt)
  {
    a(1, new akmh(paramaklt));
    a(2, new akls(paramaklt));
    a(3, new akkz(paramaklt));
  }
  
  private void a(int paramInt, agvc paramagvc)
  {
    this.b.put(paramInt, paramagvc);
    int[] arrayOfInt = paramagvc.a();
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
      localSparseArrayCompat1.put(paramInt, paramagvc);
      i += 1;
    }
  }
  
  public <T extends agvb> T a(int paramInt)
  {
    return (agvb)this.b.get(paramInt);
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
        ((agvc)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkv
 * JD-Core Version:    0.7.0.1
 */