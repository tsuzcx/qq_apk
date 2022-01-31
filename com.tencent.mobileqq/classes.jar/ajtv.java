import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ajtv
{
  ajtw jdField_a_of_type_Ajtw;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<ajtw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  int a(ajtw paramajtw, boolean paramBoolean)
  {
    int i = 1;
    if (paramajtw == null) {}
    int j;
    do
    {
      do
      {
        return i;
        paramajtw.jdField_a_of_type_Boolean = true;
        j = paramajtw.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(7);
        if ((j == 3) && (paramajtw.jdField_c_of_type_JavaLangString != null) && (paramBoolean))
        {
          bdhb.d(paramajtw.jdField_c_of_type_JavaLangString);
          paramajtw.jdField_c_of_type_JavaLangString = null;
          return j;
        }
        i = j;
      } while (j != 6);
      i = j;
    } while (paramajtw.jdField_b_of_type_JavaLangString == null);
    bdhb.d(paramajtw.jdField_b_of_type_JavaLangString);
    paramajtw.jdField_b_of_type_JavaLangString = null;
    return j;
  }
  
  public ajtw a()
  {
    return this.jdField_a_of_type_Ajtw;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajtw != null) {
      this.jdField_a_of_type_Ajtw.jdField_b_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ajtw);
      this.jdField_a_of_type_Ajtw = null;
      return;
    }
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    a(paramString, paramFloat, paramInt, 0);
  }
  
  public void a(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ajtw != null) {
      this.jdField_a_of_type_Ajtw.jdField_b_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ajtw);
      this.jdField_a_of_type_Ajtw = null;
      b(paramString, paramFloat, paramInt1, paramInt2);
      return;
    }
  }
  
  void b()
  {
    ajtw localajtw = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localajtw = (ajtw)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      if ((localajtw == null) || (a(localajtw, localajtw.jdField_b_of_type_Boolean) != 2)) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localajtw);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  void b(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    ajtw localajtw = new ajtw(this);
    localajtw.jdField_a_of_type_Boolean = false;
    localajtw.jdField_a_of_type_JavaLangString = paramString;
    localajtw.jdField_a_of_type_Int = paramInt1;
    localajtw.jdField_c_of_type_Int = paramInt2;
    paramInt2 = (int)(localajtw.jdField_a_of_type_Int / paramFloat);
    paramInt1 = paramInt2;
    if (paramInt2 % 2 > 0) {
      paramInt1 = paramInt2 - 1;
    }
    localajtw.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ajtw = localajtw;
    localajtw.jdField_a_of_type_Ajtx.jdField_a_of_type_Ajtw = localajtw;
    localajtw.jdField_a_of_type_Ajtx.execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtv
 * JD-Core Version:    0.7.0.1
 */