import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class alto
{
  altp jdField_a_of_type_Altp;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<altp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  int a(altp paramaltp, boolean paramBoolean)
  {
    int i = 1;
    if (paramaltp == null) {}
    int j;
    do
    {
      do
      {
        return i;
        paramaltp.jdField_a_of_type_Boolean = true;
        j = paramaltp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(7);
        if ((j == 3) && (paramaltp.jdField_c_of_type_JavaLangString != null) && (paramBoolean))
        {
          FileUtils.deleteFile(paramaltp.jdField_c_of_type_JavaLangString);
          paramaltp.jdField_c_of_type_JavaLangString = null;
          return j;
        }
        i = j;
      } while (j != 6);
      i = j;
    } while (paramaltp.jdField_b_of_type_JavaLangString == null);
    FileUtils.deleteFile(paramaltp.jdField_b_of_type_JavaLangString);
    paramaltp.jdField_b_of_type_JavaLangString = null;
    return j;
  }
  
  public altp a()
  {
    return this.jdField_a_of_type_Altp;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Altp != null) {
      this.jdField_a_of_type_Altp.jdField_b_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Altp);
      this.jdField_a_of_type_Altp = null;
      return;
    }
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    a(paramString, paramFloat, paramInt, 0);
  }
  
  public void a(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Altp != null) {
      this.jdField_a_of_type_Altp.jdField_b_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Altp);
      this.jdField_a_of_type_Altp = null;
      b(paramString, paramFloat, paramInt1, paramInt2);
      return;
    }
  }
  
  void b()
  {
    altp localaltp = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localaltp = (altp)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      if ((localaltp == null) || (a(localaltp, localaltp.jdField_b_of_type_Boolean) != 2)) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localaltp);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  void b(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    altp localaltp = new altp(this);
    localaltp.jdField_a_of_type_Boolean = false;
    localaltp.jdField_a_of_type_JavaLangString = paramString;
    localaltp.jdField_a_of_type_Int = paramInt1;
    localaltp.jdField_c_of_type_Int = paramInt2;
    paramInt2 = (int)(localaltp.jdField_a_of_type_Int / paramFloat);
    paramInt1 = paramInt2;
    if (paramInt2 % 2 > 0) {
      paramInt1 = paramInt2 - 1;
    }
    localaltp.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Altp = localaltp;
    localaltp.jdField_a_of_type_Altq.jdField_a_of_type_Altp = localaltp;
    localaltp.jdField_a_of_type_Altq.execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alto
 * JD-Core Version:    0.7.0.1
 */