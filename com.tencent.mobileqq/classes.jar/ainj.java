public class ainj
{
  private int jdField_a_of_type_Int = 1;
  private aink jdField_a_of_type_Aink;
  
  public ainj() {}
  
  public ainj(aink paramaink)
  {
    this.jdField_a_of_type_Aink = paramaink;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_Aink != null)
      {
        this.jdField_a_of_type_Aink.a(1);
        this.jdField_a_of_type_Int = 2;
      }
    }
    while ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Aink == null)) {
      return;
    }
    this.jdField_a_of_type_Aink.a(2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Aink != null))
    {
      this.jdField_a_of_type_Aink.a();
      this.jdField_a_of_type_Int = 3;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_Aink != null))
    {
      this.jdField_a_of_type_Aink.b();
      this.jdField_a_of_type_Int = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainj
 * JD-Core Version:    0.7.0.1
 */