import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ajpg
{
  ajph jdField_a_of_type_Ajph;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<ajph> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  int a(ajph paramajph, boolean paramBoolean)
  {
    int i = 1;
    if (paramajph == null) {}
    int j;
    do
    {
      do
      {
        return i;
        paramajph.jdField_a_of_type_Boolean = true;
        j = paramajph.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(7);
        if ((j == 3) && (paramajph.jdField_c_of_type_JavaLangString != null) && (paramBoolean))
        {
          bdcs.d(paramajph.jdField_c_of_type_JavaLangString);
          paramajph.jdField_c_of_type_JavaLangString = null;
          return j;
        }
        i = j;
      } while (j != 6);
      i = j;
    } while (paramajph.jdField_b_of_type_JavaLangString == null);
    bdcs.d(paramajph.jdField_b_of_type_JavaLangString);
    paramajph.jdField_b_of_type_JavaLangString = null;
    return j;
  }
  
  public ajph a()
  {
    return this.jdField_a_of_type_Ajph;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajph != null) {
      this.jdField_a_of_type_Ajph.jdField_b_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ajph);
      this.jdField_a_of_type_Ajph = null;
      return;
    }
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    a(paramString, paramFloat, paramInt, 0);
  }
  
  public void a(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ajph != null) {
      this.jdField_a_of_type_Ajph.jdField_b_of_type_Boolean = true;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ajph);
      this.jdField_a_of_type_Ajph = null;
      b(paramString, paramFloat, paramInt1, paramInt2);
      return;
    }
  }
  
  void b()
  {
    ajph localajph = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localajph = (ajph)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      if ((localajph == null) || (a(localajph, localajph.jdField_b_of_type_Boolean) != 2)) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localajph);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  void b(String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    ajph localajph = new ajph(this);
    localajph.jdField_a_of_type_Boolean = false;
    localajph.jdField_a_of_type_JavaLangString = paramString;
    localajph.jdField_a_of_type_Int = paramInt1;
    localajph.jdField_c_of_type_Int = paramInt2;
    paramInt2 = (int)(localajph.jdField_a_of_type_Int / paramFloat);
    paramInt1 = paramInt2;
    if (paramInt2 % 2 > 0) {
      paramInt1 = paramInt2 - 1;
    }
    localajph.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ajph = localajph;
    localajph.jdField_a_of_type_Ajpi.jdField_a_of_type_Ajph = localajph;
    localajph.jdField_a_of_type_Ajpi.execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpg
 * JD-Core Version:    0.7.0.1
 */