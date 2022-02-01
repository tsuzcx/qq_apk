import java.util.ArrayList;

public abstract class abjn
  implements abkc
{
  protected long a;
  protected ArrayList<abkc> a;
  protected boolean a;
  public boolean b = true;
  public boolean c;
  
  public abjn()
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
  
  public void a(abkc paramabkc)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramabkc)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramabkc);
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
 * Qualified Name:     abjn
 * JD-Core Version:    0.7.0.1
 */