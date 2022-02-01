import java.util.ArrayList;
import java.util.List;

public class afmh
{
  public int a;
  private ArrayList<afmi> a;
  private int b;
  private int c = -1;
  
  public afmh()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return ((afmi)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
    }
    return 0L;
  }
  
  public afmi a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (afmi)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public ArrayList<afmi> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    afmi localafmi = new afmi();
    localafmi.a(paramFloat1);
    localafmi.b(paramFloat2);
    localafmi.c(paramFloat3);
    localafmi.a(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList.add(localafmi);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(afmh paramafmh)
  {
    this.b = paramafmh.b;
    this.c = paramafmh.c;
    this.jdField_a_of_type_Int = paramafmh.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramafmh.a());
  }
  
  public void a(List<afmi> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public afmi b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (afmi)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmh
 * JD-Core Version:    0.7.0.1
 */