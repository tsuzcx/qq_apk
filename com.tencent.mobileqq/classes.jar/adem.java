import java.util.ArrayList;
import java.util.List;

public class adem
{
  public int a;
  private ArrayList<aden> a;
  private int b;
  private int c = -1;
  
  public adem()
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
      return ((aden)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
    }
    return 0L;
  }
  
  public aden a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (aden)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public ArrayList<aden> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    aden localaden = new aden();
    localaden.a(paramFloat1);
    localaden.b(paramFloat2);
    localaden.c(paramFloat3);
    localaden.a(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaden);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(adem paramadem)
  {
    this.b = paramadem.b;
    this.c = paramadem.c;
    this.jdField_a_of_type_Int = paramadem.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramadem.a());
  }
  
  public void a(List<aden> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public aden b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (aden)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adem
 * JD-Core Version:    0.7.0.1
 */