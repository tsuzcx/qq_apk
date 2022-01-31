import java.util.ArrayList;
import java.util.List;

public class adex
{
  int jdField_a_of_type_Int = 2;
  public List<adeu> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public adex()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List<adeu> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    adeu localadeu = new adeu();
    localadeu.a((adeu)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localadeu);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    adeu localadeu = (adeu)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localadeu.a.a(localadeu.b);
    localadeu.c.a(localadeu.d);
    localadeu.b.a(localadeu.d);
    this.jdField_a_of_type_JavaUtilList.add(localadeu);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    adeu localadeu = new adeu();
    localadeu.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localadeu);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    adeu localadeu1 = new adeu();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    adeu localadeu2 = (adeu)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localadeu1.a.a(localadeu2.b);
    localadeu1.c.a(localadeu2.d);
    localadeu1.b.a((localadeu1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localadeu1.c.b + paramFloat2) / 2.0F, (localadeu1.c.c + paramFloat3) / 2.0F, (localadeu1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localadeu1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localadeu1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adex
 * JD-Core Version:    0.7.0.1
 */