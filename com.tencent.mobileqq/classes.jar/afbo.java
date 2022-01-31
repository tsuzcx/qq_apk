import java.util.ArrayList;
import java.util.List;

public class afbo
{
  int jdField_a_of_type_Int = 2;
  public List<afbl> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public afbo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List<afbl> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    afbl localafbl = new afbl();
    localafbl.a((afbl)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localafbl);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    afbl localafbl = (afbl)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localafbl.a.a(localafbl.b);
    localafbl.c.a(localafbl.d);
    localafbl.b.a(localafbl.d);
    this.jdField_a_of_type_JavaUtilList.add(localafbl);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    afbl localafbl = new afbl();
    localafbl.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localafbl);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    afbl localafbl1 = new afbl();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    afbl localafbl2 = (afbl)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localafbl1.a.a(localafbl2.b);
    localafbl1.c.a(localafbl2.d);
    localafbl1.b.a((localafbl1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localafbl1.c.b + paramFloat2) / 2.0F, (localafbl1.c.c + paramFloat3) / 2.0F, (localafbl1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localafbl1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localafbl1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbo
 * JD-Core Version:    0.7.0.1
 */