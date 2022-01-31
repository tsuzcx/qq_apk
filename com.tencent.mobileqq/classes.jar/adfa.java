import java.util.ArrayList;
import java.util.List;

public class adfa
{
  int jdField_a_of_type_Int = 2;
  public List<adex> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public adfa()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List<adex> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    adex localadex = new adex();
    localadex.a((adex)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localadex);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    adex localadex = (adex)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localadex.a.a(localadex.b);
    localadex.c.a(localadex.d);
    localadex.b.a(localadex.d);
    this.jdField_a_of_type_JavaUtilList.add(localadex);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    adex localadex = new adex();
    localadex.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localadex);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    adex localadex1 = new adex();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    adex localadex2 = (adex)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localadex1.a.a(localadex2.b);
    localadex1.c.a(localadex2.d);
    localadex1.b.a((localadex1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localadex1.c.b + paramFloat2) / 2.0F, (localadex1.c.c + paramFloat3) / 2.0F, (localadex1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localadex1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localadex1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adfa
 * JD-Core Version:    0.7.0.1
 */