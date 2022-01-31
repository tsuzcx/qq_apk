import java.util.ArrayList;
import java.util.List;

public class adej
{
  public int a;
  private ArrayList<adek> a;
  private int b;
  private int c = -1;
  
  public adej()
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
      return ((adek)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
    }
    return 0L;
  }
  
  public adek a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (adek)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public ArrayList<adek> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    adek localadek = new adek();
    localadek.a(paramFloat1);
    localadek.b(paramFloat2);
    localadek.c(paramFloat3);
    localadek.a(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList.add(localadek);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(adej paramadej)
  {
    this.b = paramadej.b;
    this.c = paramadej.c;
    this.jdField_a_of_type_Int = paramadej.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramadej.a());
  }
  
  public void a(List<adek> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public adek b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (adek)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
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
 * Qualified Name:     adej
 * JD-Core Version:    0.7.0.1
 */