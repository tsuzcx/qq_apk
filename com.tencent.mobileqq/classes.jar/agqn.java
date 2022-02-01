import java.util.ArrayList;
import java.util.List;

public class agqn
{
  public int a;
  private ArrayList<agqo> a;
  private int b;
  private int c = -1;
  
  public agqn()
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
      return ((agqo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
    }
    return 0L;
  }
  
  public agqo a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (agqo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public ArrayList<agqo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    agqo localagqo = new agqo();
    localagqo.a(paramFloat1);
    localagqo.b(paramFloat2);
    localagqo.c(paramFloat3);
    localagqo.a(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList.add(localagqo);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(agqn paramagqn)
  {
    this.b = paramagqn.b;
    this.c = paramagqn.c;
    this.jdField_a_of_type_Int = paramagqn.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramagqn.a());
  }
  
  public void a(List<agqo> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public agqo b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (agqo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqn
 * JD-Core Version:    0.7.0.1
 */