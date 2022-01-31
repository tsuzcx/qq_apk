import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ahxw
{
  ahxx jdField_a_of_type_Ahxx;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<ahxx> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  int a(ahxx paramahxx, boolean paramBoolean)
  {
    int i = 1;
    if (paramahxx == null) {}
    int j;
    do
    {
      do
      {
        return i;
        paramahxx.jdField_a_of_type_Boolean = true;
        j = paramahxx.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(7);
        if ((j == 3) && (paramahxx.jdField_c_of_type_JavaLangString != null) && (paramBoolean))
        {
          bbdx.d(paramahxx.jdField_c_of_type_JavaLangString);
          paramahxx.jdField_c_of_type_JavaLangString = null;
          return j;
        }
        i = j;
      } while (j != 6);
      i = j;
    } while (paramahxx.jdField_b_of_type_JavaLangString == null);
    bbdx.d(paramahxx.jdField_b_of_type_JavaLangString);
    paramahxx.jdField_b_of_type_JavaLangString = null;
    return j;
  }
  
  public ahxx a()
  {
    return this.jdField_a_of_type_Ahxx;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahxx != null) {
      this.jdField_a_of_type_Ahxx.jdField_b_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ahxx);
      this.jdField_a_of_type_Ahxx = null;
      return;
    }
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    a(paramString, paramFloat, paramInt, 0);
  }
  
  public void a(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ahxx != null) {
      this.jdField_a_of_type_Ahxx.jdField_b_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ahxx);
      this.jdField_a_of_type_Ahxx = null;
      b(paramString, paramFloat, paramInt1, paramInt2);
      return;
    }
  }
  
  void b()
  {
    ahxx localahxx = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localahxx = (ahxx)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      if ((localahxx == null) || (a(localahxx, localahxx.jdField_b_of_type_Boolean) != 2)) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localahxx);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  void b(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    ahxx localahxx = new ahxx(this);
    localahxx.jdField_a_of_type_Boolean = false;
    localahxx.jdField_a_of_type_JavaLangString = paramString;
    localahxx.jdField_a_of_type_Int = paramInt1;
    localahxx.jdField_c_of_type_Int = paramInt2;
    paramInt2 = (int)(localahxx.jdField_a_of_type_Int / paramFloat);
    paramInt1 = paramInt2;
    if (paramInt2 % 2 > 0) {
      paramInt1 = paramInt2 - 1;
    }
    localahxx.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ahxx = localahxx;
    localahxx.jdField_a_of_type_Ahxy.jdField_a_of_type_Ahxx = localahxx;
    localahxx.jdField_a_of_type_Ahxy.execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahxw
 * JD-Core Version:    0.7.0.1
 */