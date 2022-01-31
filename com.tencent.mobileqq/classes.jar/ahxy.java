import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ahxy
{
  ahxz jdField_a_of_type_Ahxz;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<ahxz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  int a(ahxz paramahxz, boolean paramBoolean)
  {
    int i = 1;
    if (paramahxz == null) {}
    int j;
    do
    {
      do
      {
        return i;
        paramahxz.jdField_a_of_type_Boolean = true;
        j = paramahxz.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(7);
        if ((j == 3) && (paramahxz.jdField_c_of_type_JavaLangString != null) && (paramBoolean))
        {
          bbdj.d(paramahxz.jdField_c_of_type_JavaLangString);
          paramahxz.jdField_c_of_type_JavaLangString = null;
          return j;
        }
        i = j;
      } while (j != 6);
      i = j;
    } while (paramahxz.jdField_b_of_type_JavaLangString == null);
    bbdj.d(paramahxz.jdField_b_of_type_JavaLangString);
    paramahxz.jdField_b_of_type_JavaLangString = null;
    return j;
  }
  
  public ahxz a()
  {
    return this.jdField_a_of_type_Ahxz;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahxz != null) {
      this.jdField_a_of_type_Ahxz.jdField_b_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ahxz);
      this.jdField_a_of_type_Ahxz = null;
      return;
    }
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    a(paramString, paramFloat, paramInt, 0);
  }
  
  public void a(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ahxz != null) {
      this.jdField_a_of_type_Ahxz.jdField_b_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ahxz);
      this.jdField_a_of_type_Ahxz = null;
      b(paramString, paramFloat, paramInt1, paramInt2);
      return;
    }
  }
  
  void b()
  {
    ahxz localahxz = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localahxz = (ahxz)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      if ((localahxz == null) || (a(localahxz, localahxz.jdField_b_of_type_Boolean) != 2)) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localahxz);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  void b(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    ahxz localahxz = new ahxz(this);
    localahxz.jdField_a_of_type_Boolean = false;
    localahxz.jdField_a_of_type_JavaLangString = paramString;
    localahxz.jdField_a_of_type_Int = paramInt1;
    localahxz.jdField_c_of_type_Int = paramInt2;
    paramInt2 = (int)(localahxz.jdField_a_of_type_Int / paramFloat);
    paramInt1 = paramInt2;
    if (paramInt2 % 2 > 0) {
      paramInt1 = paramInt2 - 1;
    }
    localahxz.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ahxz = localahxz;
    localahxz.jdField_a_of_type_Ahya.jdField_a_of_type_Ahxz = localahxz;
    localahxz.jdField_a_of_type_Ahya.execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahxy
 * JD-Core Version:    0.7.0.1
 */