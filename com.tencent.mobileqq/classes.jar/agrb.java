import java.util.ArrayList;
import java.util.List;

public class agrb
{
  int jdField_a_of_type_Int = 2;
  public List<agqy> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public agrb()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List<agqy> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    agqy localagqy = new agqy();
    localagqy.a((agqy)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localagqy);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    agqy localagqy = (agqy)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localagqy.a.a(localagqy.b);
    localagqy.c.a(localagqy.d);
    localagqy.b.a(localagqy.d);
    this.jdField_a_of_type_JavaUtilList.add(localagqy);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    agqy localagqy = new agqy();
    localagqy.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localagqy);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    agqy localagqy1 = new agqy();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    agqy localagqy2 = (agqy)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localagqy1.a.a(localagqy2.b);
    localagqy1.c.a(localagqy2.d);
    localagqy1.b.a((localagqy1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localagqy1.c.b + paramFloat2) / 2.0F, (localagqy1.c.c + paramFloat3) / 2.0F, (localagqy1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localagqy1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localagqy1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrb
 * JD-Core Version:    0.7.0.1
 */