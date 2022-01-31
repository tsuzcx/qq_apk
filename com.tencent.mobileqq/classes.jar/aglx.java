import android.util.SparseArray;

public abstract class aglx
  implements Cloneable
{
  public static final aglx a;
  public static final SparseArray<aglx> a;
  public static final aglx b;
  public static final aglx c;
  public static final aglx d;
  public static final aglx e;
  public static final aglx f;
  public static final aglx g;
  public static final aglx h;
  private boolean a;
  
  static
  {
    jdField_a_of_type_Aglx = new agly();
    b = new aglz();
    c = new agma();
    d = new agmb();
    e = new agmc();
    f = new agmd();
    g = new agme();
    h = new agmf();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(0, b);
    jdField_a_of_type_AndroidUtilSparseArray.put(1, d);
    jdField_a_of_type_AndroidUtilSparseArray.put(2, e);
    jdField_a_of_type_AndroidUtilSparseArray.put(3, f);
    jdField_a_of_type_AndroidUtilSparseArray.put(4, h);
    jdField_a_of_type_AndroidUtilSparseArray.put(5, jdField_a_of_type_Aglx);
    jdField_a_of_type_AndroidUtilSparseArray.put(6, c);
    jdField_a_of_type_AndroidUtilSparseArray.put(7, g);
  }
  
  public static aglx a(int paramInt)
  {
    aglx localaglx2 = (aglx)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    aglx localaglx1 = localaglx2;
    if (localaglx2 != null) {}
    try
    {
      localaglx1 = (aglx)localaglx2.clone();
      return localaglx1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return localaglx2;
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
 * Qualified Name:     aglx
 * JD-Core Version:    0.7.0.1
 */