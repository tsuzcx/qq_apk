import java.util.ArrayList;
import java.util.List;

public class agdz
{
  int jdField_a_of_type_Int = 2;
  public List<agdw> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public agdz()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List<agdw> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    agdw localagdw = new agdw();
    localagdw.a((agdw)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localagdw);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    agdw localagdw = (agdw)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localagdw.a.a(localagdw.b);
    localagdw.c.a(localagdw.d);
    localagdw.b.a(localagdw.d);
    this.jdField_a_of_type_JavaUtilList.add(localagdw);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    agdw localagdw = new agdw();
    localagdw.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localagdw);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    agdw localagdw1 = new agdw();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    agdw localagdw2 = (agdw)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localagdw1.a.a(localagdw2.b);
    localagdw1.c.a(localagdw2.d);
    localagdw1.b.a((localagdw1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localagdw1.c.b + paramFloat2) / 2.0F, (localagdw1.c.c + paramFloat3) / 2.0F, (localagdw1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localagdw1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localagdw1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdz
 * JD-Core Version:    0.7.0.1
 */