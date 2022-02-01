import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class alyd
{
  alye jdField_a_of_type_Alye;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<alye> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  int a(alye paramalye, boolean paramBoolean)
  {
    int i = 1;
    if (paramalye == null) {}
    int j;
    do
    {
      do
      {
        return i;
        paramalye.jdField_a_of_type_Boolean = true;
        j = paramalye.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(7);
        if ((j == 3) && (paramalye.jdField_c_of_type_JavaLangString != null) && (paramBoolean))
        {
          bhmi.d(paramalye.jdField_c_of_type_JavaLangString);
          paramalye.jdField_c_of_type_JavaLangString = null;
          return j;
        }
        i = j;
      } while (j != 6);
      i = j;
    } while (paramalye.jdField_b_of_type_JavaLangString == null);
    bhmi.d(paramalye.jdField_b_of_type_JavaLangString);
    paramalye.jdField_b_of_type_JavaLangString = null;
    return j;
  }
  
  public alye a()
  {
    return this.jdField_a_of_type_Alye;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alye != null) {
      this.jdField_a_of_type_Alye.jdField_b_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Alye);
      this.jdField_a_of_type_Alye = null;
      return;
    }
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    a(paramString, paramFloat, paramInt, 0);
  }
  
  public void a(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Alye != null) {
      this.jdField_a_of_type_Alye.jdField_b_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Alye);
      this.jdField_a_of_type_Alye = null;
      b(paramString, paramFloat, paramInt1, paramInt2);
      return;
    }
  }
  
  void b()
  {
    alye localalye = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localalye = (alye)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      if ((localalye == null) || (a(localalye, localalye.jdField_b_of_type_Boolean) != 2)) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localalye);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  void b(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    alye localalye = new alye(this);
    localalye.jdField_a_of_type_Boolean = false;
    localalye.jdField_a_of_type_JavaLangString = paramString;
    localalye.jdField_a_of_type_Int = paramInt1;
    localalye.jdField_c_of_type_Int = paramInt2;
    paramInt2 = (int)(localalye.jdField_a_of_type_Int / paramFloat);
    paramInt1 = paramInt2;
    if (paramInt2 % 2 > 0) {
      paramInt1 = paramInt2 - 1;
    }
    localalye.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Alye = localalye;
    localalye.jdField_a_of_type_Alyf.jdField_a_of_type_Alye = localalye;
    localalye.jdField_a_of_type_Alyf.execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alyd
 * JD-Core Version:    0.7.0.1
 */