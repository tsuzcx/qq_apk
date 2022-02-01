import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class akvs
{
  akvt jdField_a_of_type_Akvt;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<akvt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  int a(akvt paramakvt, boolean paramBoolean)
  {
    int i = 1;
    if (paramakvt == null) {}
    int j;
    do
    {
      do
      {
        return i;
        paramakvt.jdField_a_of_type_Boolean = true;
        j = paramakvt.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(7);
        if ((j == 3) && (paramakvt.jdField_c_of_type_JavaLangString != null) && (paramBoolean))
        {
          FileUtils.deleteFile(paramakvt.jdField_c_of_type_JavaLangString);
          paramakvt.jdField_c_of_type_JavaLangString = null;
          return j;
        }
        i = j;
      } while (j != 6);
      i = j;
    } while (paramakvt.jdField_b_of_type_JavaLangString == null);
    FileUtils.deleteFile(paramakvt.jdField_b_of_type_JavaLangString);
    paramakvt.jdField_b_of_type_JavaLangString = null;
    return j;
  }
  
  public akvt a()
  {
    return this.jdField_a_of_type_Akvt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akvt != null) {
      this.jdField_a_of_type_Akvt.jdField_b_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Akvt);
      this.jdField_a_of_type_Akvt = null;
      return;
    }
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    a(paramString, paramFloat, paramInt, 0);
  }
  
  public void a(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Akvt != null) {
      this.jdField_a_of_type_Akvt.jdField_b_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Akvt);
      this.jdField_a_of_type_Akvt = null;
      b(paramString, paramFloat, paramInt1, paramInt2);
      return;
    }
  }
  
  void b()
  {
    akvt localakvt = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localakvt = (akvt)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      if ((localakvt == null) || (a(localakvt, localakvt.jdField_b_of_type_Boolean) != 2)) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localakvt);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  void b(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    akvt localakvt = new akvt(this);
    localakvt.jdField_a_of_type_Boolean = false;
    localakvt.jdField_a_of_type_JavaLangString = paramString;
    localakvt.jdField_a_of_type_Int = paramInt1;
    localakvt.jdField_c_of_type_Int = paramInt2;
    paramInt2 = (int)(localakvt.jdField_a_of_type_Int / paramFloat);
    paramInt1 = paramInt2;
    if (paramInt2 % 2 > 0) {
      paramInt1 = paramInt2 - 1;
    }
    localakvt.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Akvt = localakvt;
    localakvt.jdField_a_of_type_Akvu.jdField_a_of_type_Akvt = localakvt;
    localakvt.jdField_a_of_type_Akvu.execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvs
 * JD-Core Version:    0.7.0.1
 */