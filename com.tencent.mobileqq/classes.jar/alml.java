import android.util.SparseArray;

public class alml
{
  public static final SparseArray<almk> a = new SparseArray();
  
  static
  {
    a.put(1000, new almk(2, 0));
    a.put(1004, new almk(2, 1));
    a.put(1006, new almk(1, 130));
    a.put(1023, new almk(1, 133));
    a.put(1022, new almk(1, 134));
    a.put(10010, new almk(1, 167));
  }
  
  public static boolean a(int paramInt, almk paramalmk)
  {
    almk localalmk = (almk)a.get(paramInt);
    if ((localalmk != null) && (paramalmk != null)) {
      return (localalmk.a == paramalmk.a) && (localalmk.b == paramalmk.b);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alml
 * JD-Core Version:    0.7.0.1
 */