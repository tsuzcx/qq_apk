import android.util.SparseArray;

public abstract class afzz
  implements Cloneable
{
  public static final afzz a;
  public static final SparseArray<afzz> a;
  public static final afzz b;
  public static final afzz c;
  public static final afzz d;
  public static final afzz e;
  public static final afzz f;
  public static final afzz g;
  public static final afzz h;
  private boolean a;
  
  static
  {
    jdField_a_of_type_Afzz = new agaa();
    b = new agab();
    c = new agac();
    d = new agad();
    e = new agae();
    f = new agaf();
    g = new agag();
    h = new agah();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(0, b);
    jdField_a_of_type_AndroidUtilSparseArray.put(1, d);
    jdField_a_of_type_AndroidUtilSparseArray.put(2, e);
    jdField_a_of_type_AndroidUtilSparseArray.put(3, f);
    jdField_a_of_type_AndroidUtilSparseArray.put(4, h);
    jdField_a_of_type_AndroidUtilSparseArray.put(5, jdField_a_of_type_Afzz);
    jdField_a_of_type_AndroidUtilSparseArray.put(6, c);
    jdField_a_of_type_AndroidUtilSparseArray.put(7, g);
  }
  
  public static afzz a(int paramInt)
  {
    afzz localafzz2 = (afzz)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    afzz localafzz1 = localafzz2;
    if (localafzz2 != null) {}
    try
    {
      localafzz1 = (afzz)localafzz2.clone();
      return localafzz1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return localafzz2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(String paramString)
  {
    if ((c()) && ("image/webp".equals(paramString))) {}
    while ((d()) && (("image/heif".equals(paramString)) || ("image/heic".equals(paramString)))) {
      return false;
    }
    return true;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afzz
 * JD-Core Version:    0.7.0.1
 */