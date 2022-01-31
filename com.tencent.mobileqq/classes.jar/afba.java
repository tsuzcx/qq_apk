import java.util.ArrayList;
import java.util.List;

public class afba
{
  public int a;
  private ArrayList<afbb> a;
  private int b;
  private int c = -1;
  
  public afba()
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
      return ((afbb)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
    }
    return 0L;
  }
  
  public afbb a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (afbb)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public ArrayList<afbb> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    afbb localafbb = new afbb();
    localafbb.a(paramFloat1);
    localafbb.b(paramFloat2);
    localafbb.c(paramFloat3);
    localafbb.a(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList.add(localafbb);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(afba paramafba)
  {
    this.b = paramafba.b;
    this.c = paramafba.c;
    this.jdField_a_of_type_Int = paramafba.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramafba.a());
  }
  
  public void a(List<afbb> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public afbb b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (afbb)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
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
 * Qualified Name:     afba
 * JD-Core Version:    0.7.0.1
 */