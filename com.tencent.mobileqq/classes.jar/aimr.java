public class aimr
{
  private int jdField_a_of_type_Int = 1;
  private aims jdField_a_of_type_Aims;
  
  public aimr() {}
  
  public aimr(aims paramaims)
  {
    this.jdField_a_of_type_Aims = paramaims;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_Aims != null)
      {
        this.jdField_a_of_type_Aims.a(1);
        this.jdField_a_of_type_Int = 2;
      }
    }
    while ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Aims == null)) {
      return;
    }
    this.jdField_a_of_type_Aims.a(2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Aims != null))
    {
      this.jdField_a_of_type_Aims.a();
      this.jdField_a_of_type_Int = 3;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_Aims != null))
    {
      this.jdField_a_of_type_Aims.b();
      this.jdField_a_of_type_Int = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimr
 * JD-Core Version:    0.7.0.1
 */