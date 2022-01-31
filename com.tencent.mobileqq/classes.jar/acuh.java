import java.util.ArrayList;
import java.util.List;

public class acuh
{
  int jdField_a_of_type_Int = 2;
  public List<acue> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public acuh()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List<acue> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    acue localacue = new acue();
    localacue.a((acue)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localacue);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    acue localacue = (acue)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localacue.a.a(localacue.b);
    localacue.c.a(localacue.d);
    localacue.b.a(localacue.d);
    this.jdField_a_of_type_JavaUtilList.add(localacue);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    acue localacue = new acue();
    localacue.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localacue);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    acue localacue1 = new acue();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    acue localacue2 = (acue)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localacue1.a.a(localacue2.b);
    localacue1.c.a(localacue2.d);
    localacue1.b.a((localacue1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localacue1.c.b + paramFloat2) / 2.0F, (localacue1.c.c + paramFloat3) / 2.0F, (localacue1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localacue1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localacue1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acuh
 * JD-Core Version:    0.7.0.1
 */