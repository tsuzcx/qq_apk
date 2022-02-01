import java.util.ArrayList;
import java.util.List;

public class aghm
{
  public int a;
  private ArrayList<aghn> a;
  private int b;
  private int c = -1;
  
  public aghm()
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
      return ((aghn)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
    }
    return 0L;
  }
  
  public aghn a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (aghn)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public ArrayList<aghn> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    aghn localaghn = new aghn();
    localaghn.a(paramFloat1);
    localaghn.b(paramFloat2);
    localaghn.c(paramFloat3);
    localaghn.a(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaghn);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(aghm paramaghm)
  {
    this.b = paramaghm.b;
    this.c = paramaghm.c;
    this.jdField_a_of_type_Int = paramaghm.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramaghm.a());
  }
  
  public void a(List<aghn> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public aghn b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (aghn)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
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
 * Qualified Name:     aghm
 * JD-Core Version:    0.7.0.1
 */