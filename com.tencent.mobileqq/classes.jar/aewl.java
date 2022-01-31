import java.util.ArrayList;
import java.util.List;

public class aewl
{
  public int a;
  private ArrayList<aewm> a;
  private int b;
  private int c = -1;
  
  public aewl()
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
      return ((aewm)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
    }
    return 0L;
  }
  
  public aewm a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (aewm)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public ArrayList<aewm> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    aewm localaewm = new aewm();
    localaewm.a(paramFloat1);
    localaewm.b(paramFloat2);
    localaewm.c(paramFloat3);
    localaewm.a(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaewm);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(aewl paramaewl)
  {
    this.b = paramaewl.b;
    this.c = paramaewl.c;
    this.jdField_a_of_type_Int = paramaewl.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramaewl.a());
  }
  
  public void a(List<aewm> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public aewm b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (aewm)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
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
 * Qualified Name:     aewl
 * JD-Core Version:    0.7.0.1
 */