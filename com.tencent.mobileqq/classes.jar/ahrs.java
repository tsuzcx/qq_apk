public class ahrs
{
  private int jdField_a_of_type_Int = 1;
  private ahrt jdField_a_of_type_Ahrt;
  
  public ahrs() {}
  
  public ahrs(ahrt paramahrt)
  {
    this.jdField_a_of_type_Ahrt = paramahrt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_Ahrt != null)
      {
        this.jdField_a_of_type_Ahrt.a(1);
        this.jdField_a_of_type_Int = 2;
      }
    }
    while ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Ahrt == null)) {
      return;
    }
    this.jdField_a_of_type_Ahrt.a(2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Ahrt != null))
    {
      this.jdField_a_of_type_Ahrt.a();
      this.jdField_a_of_type_Int = 3;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_Ahrt != null))
    {
      this.jdField_a_of_type_Ahrt.b();
      this.jdField_a_of_type_Int = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrs
 * JD-Core Version:    0.7.0.1
 */