import java.util.ArrayList;

public abstract class abfj
  implements abfy
{
  protected long a;
  protected ArrayList<abfy> a;
  protected boolean a;
  public boolean b = true;
  public boolean c;
  
  public abfj()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 350L;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 350L;
  }
  
  public void a(abfy paramabfy)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramabfy)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramabfy);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public abstract boolean b();
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abfj
 * JD-Core Version:    0.7.0.1
 */