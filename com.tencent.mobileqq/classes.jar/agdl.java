import java.util.ArrayList;
import java.util.List;

public class agdl
{
  public int a;
  private ArrayList<agdm> a;
  private int b;
  private int c = -1;
  
  public agdl()
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
      return ((agdm)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a();
    }
    return 0L;
  }
  
  public agdm a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (agdm)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public ArrayList<agdm> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    agdm localagdm = new agdm();
    localagdm.a(paramFloat1);
    localagdm.b(paramFloat2);
    localagdm.c(paramFloat3);
    localagdm.a(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList.add(localagdm);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(agdl paramagdl)
  {
    this.b = paramagdl.b;
    this.c = paramagdl.c;
    this.jdField_a_of_type_Int = paramagdl.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramagdl.a());
  }
  
  public void a(List<agdm> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public agdm b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (agdm)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
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
 * Qualified Name:     agdl
 * JD-Core Version:    0.7.0.1
 */