import android.util.SparseArray;

public abstract class aglv
  implements Cloneable
{
  public static final aglv a;
  public static final SparseArray<aglv> a;
  public static final aglv b;
  public static final aglv c;
  public static final aglv d;
  public static final aglv e;
  public static final aglv f;
  public static final aglv g;
  public static final aglv h;
  private boolean a;
  
  static
  {
    jdField_a_of_type_Aglv = new aglw();
    b = new aglx();
    c = new agly();
    d = new aglz();
    e = new agma();
    f = new agmb();
    g = new agmc();
    h = new agmd();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(0, b);
    jdField_a_of_type_AndroidUtilSparseArray.put(1, d);
    jdField_a_of_type_AndroidUtilSparseArray.put(2, e);
    jdField_a_of_type_AndroidUtilSparseArray.put(3, f);
    jdField_a_of_type_AndroidUtilSparseArray.put(4, h);
    jdField_a_of_type_AndroidUtilSparseArray.put(5, jdField_a_of_type_Aglv);
    jdField_a_of_type_AndroidUtilSparseArray.put(6, c);
    jdField_a_of_type_AndroidUtilSparseArray.put(7, g);
  }
  
  public static aglv a(int paramInt)
  {
    aglv localaglv2 = (aglv)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    aglv localaglv1 = localaglv2;
    if (localaglv2 != null) {}
    try
    {
      localaglv1 = (aglv)localaglv2.clone();
      return localaglv1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return localaglv2;
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
 * Qualified Name:     aglv
 * JD-Core Version:    0.7.0.1
 */