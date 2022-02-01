import java.util.ArrayList;
import java.util.List;

public class afmv
{
  int jdField_a_of_type_Int = 2;
  public List<afms> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public afmv()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List<afms> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    afms localafms = new afms();
    localafms.a((afms)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localafms);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    afms localafms = (afms)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localafms.a.a(localafms.b);
    localafms.c.a(localafms.d);
    localafms.b.a(localafms.d);
    this.jdField_a_of_type_JavaUtilList.add(localafms);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    afms localafms = new afms();
    localafms.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localafms);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    afms localafms1 = new afms();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    afms localafms2 = (afms)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localafms1.a.a(localafms2.b);
    localafms1.c.a(localafms2.d);
    localafms1.b.a((localafms1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localafms1.c.b + paramFloat2) / 2.0F, (localafms1.c.c + paramFloat3) / 2.0F, (localafms1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localafms1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localafms1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmv
 * JD-Core Version:    0.7.0.1
 */