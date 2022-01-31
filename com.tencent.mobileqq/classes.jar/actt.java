import java.util.ArrayList;
import java.util.List;

public class actt
{
  public int a;
  private ArrayList<actu> a;
  private int b;
  private int c = -1;
  
  public actt()
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
      return ((actu)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
    }
    return 0L;
  }
  
  public actu a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (actu)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public ArrayList<actu> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    actu localactu = new actu();
    localactu.a(paramFloat1);
    localactu.b(paramFloat2);
    localactu.c(paramFloat3);
    localactu.a(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList.add(localactu);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(actt paramactt)
  {
    this.b = paramactt.b;
    this.c = paramactt.c;
    this.jdField_a_of_type_Int = paramactt.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramactt.a());
  }
  
  public void a(List<actu> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public actu b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (actu)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
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
 * Qualified Name:     actt
 * JD-Core Version:    0.7.0.1
 */