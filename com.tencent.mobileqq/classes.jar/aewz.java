import java.util.ArrayList;
import java.util.List;

public class aewz
{
  int jdField_a_of_type_Int = 2;
  public List<aeww> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public aewz()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List<aeww> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    aeww localaeww = new aeww();
    localaeww.a((aeww)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localaeww);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    aeww localaeww = (aeww)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localaeww.a.a(localaeww.b);
    localaeww.c.a(localaeww.d);
    localaeww.b.a(localaeww.d);
    this.jdField_a_of_type_JavaUtilList.add(localaeww);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    aeww localaeww = new aeww();
    localaeww.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localaeww);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    aeww localaeww1 = new aeww();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    aeww localaeww2 = (aeww)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localaeww1.a.a(localaeww2.b);
    localaeww1.c.a(localaeww2.d);
    localaeww1.b.a((localaeww1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localaeww1.c.b + paramFloat2) / 2.0F, (localaeww1.c.c + paramFloat3) / 2.0F, (localaeww1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localaeww1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localaeww1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewz
 * JD-Core Version:    0.7.0.1
 */