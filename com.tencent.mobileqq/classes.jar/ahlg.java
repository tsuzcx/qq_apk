import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ahlg
{
  ahlh jdField_a_of_type_Ahlh;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<ahlh> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  int a(ahlh paramahlh, boolean paramBoolean)
  {
    int i = 1;
    if (paramahlh == null) {}
    int j;
    do
    {
      do
      {
        return i;
        paramahlh.jdField_a_of_type_Boolean = true;
        j = paramahlh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(7);
        if ((j == 3) && (paramahlh.jdField_c_of_type_JavaLangString != null) && (paramBoolean))
        {
          bace.d(paramahlh.jdField_c_of_type_JavaLangString);
          paramahlh.jdField_c_of_type_JavaLangString = null;
          return j;
        }
        i = j;
      } while (j != 6);
      i = j;
    } while (paramahlh.jdField_b_of_type_JavaLangString == null);
    bace.d(paramahlh.jdField_b_of_type_JavaLangString);
    paramahlh.jdField_b_of_type_JavaLangString = null;
    return j;
  }
  
  public ahlh a()
  {
    return this.jdField_a_of_type_Ahlh;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahlh != null) {
      this.jdField_a_of_type_Ahlh.jdField_b_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ahlh);
      this.jdField_a_of_type_Ahlh = null;
      return;
    }
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    a(paramString, paramFloat, paramInt, 0);
  }
  
  public void a(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ahlh != null) {
      this.jdField_a_of_type_Ahlh.jdField_b_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ahlh);
      this.jdField_a_of_type_Ahlh = null;
      b(paramString, paramFloat, paramInt1, paramInt2);
      return;
    }
  }
  
  void b()
  {
    ahlh localahlh = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localahlh = (ahlh)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      if ((localahlh == null) || (a(localahlh, localahlh.jdField_b_of_type_Boolean) != 2)) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localahlh);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  void b(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    ahlh localahlh = new ahlh(this);
    localahlh.jdField_a_of_type_Boolean = false;
    localahlh.jdField_a_of_type_JavaLangString = paramString;
    localahlh.jdField_a_of_type_Int = paramInt1;
    localahlh.jdField_c_of_type_Int = paramInt2;
    paramInt2 = (int)(localahlh.jdField_a_of_type_Int / paramFloat);
    paramInt1 = paramInt2;
    if (paramInt2 % 2 > 0) {
      paramInt1 = paramInt2 - 1;
    }
    localahlh.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ahlh = localahlh;
    localahlh.jdField_a_of_type_Ahli.jdField_a_of_type_Ahlh = localahlh;
    localahlh.jdField_a_of_type_Ahli.execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahlg
 * JD-Core Version:    0.7.0.1
 */