import java.util.ArrayList;
import java.util.List;

public class agia
{
  int jdField_a_of_type_Int = 2;
  public List<aghx> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public agia()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List<aghx> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    aghx localaghx = new aghx();
    localaghx.a((aghx)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localaghx);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    aghx localaghx = (aghx)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localaghx.a.a(localaghx.b);
    localaghx.c.a(localaghx.d);
    localaghx.b.a(localaghx.d);
    this.jdField_a_of_type_JavaUtilList.add(localaghx);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    aghx localaghx = new aghx();
    localaghx.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localaghx);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    aghx localaghx1 = new aghx();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    aghx localaghx2 = (aghx)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localaghx1.a.a(localaghx2.b);
    localaghx1.c.a(localaghx2.d);
    localaghx1.b.a((localaghx1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localaghx1.c.b + paramFloat2) / 2.0F, (localaghx1.c.c + paramFloat3) / 2.0F, (localaghx1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localaghx1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localaghx1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agia
 * JD-Core Version:    0.7.0.1
 */