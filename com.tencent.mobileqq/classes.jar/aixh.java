public class aixh
{
  private int jdField_a_of_type_Int = 1;
  private aixi jdField_a_of_type_Aixi;
  
  public aixh() {}
  
  public aixh(aixi paramaixi)
  {
    this.jdField_a_of_type_Aixi = paramaixi;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_Aixi != null)
      {
        this.jdField_a_of_type_Aixi.a(1);
        this.jdField_a_of_type_Int = 2;
      }
    }
    while ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Aixi == null)) {
      return;
    }
    this.jdField_a_of_type_Aixi.a(2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Aixi != null))
    {
      this.jdField_a_of_type_Aixi.a();
      this.jdField_a_of_type_Int = 3;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_Aixi != null))
    {
      this.jdField_a_of_type_Aixi.b();
      this.jdField_a_of_type_Int = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixh
 * JD-Core Version:    0.7.0.1
 */