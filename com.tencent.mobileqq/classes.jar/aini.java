public class aini
{
  private ainh jdField_a_of_type_Ainh = new ainh();
  private ainj jdField_a_of_type_Ainj = new ainj();
  private aink jdField_a_of_type_Aink = new aink();
  
  public ainh a()
  {
    return this.jdField_a_of_type_Ainh;
  }
  
  public ainj a()
  {
    return this.jdField_a_of_type_Ainj;
  }
  
  public aink a()
  {
    return this.jdField_a_of_type_Aink;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_Aink.b) {
      return this.jdField_a_of_type_Ainh.b();
    }
    if (this.jdField_a_of_type_Ainj.f()) {
      return this.jdField_a_of_type_Ainh.a();
    }
    return "";
  }
  
  public void a()
  {
    a().b("");
    this.jdField_a_of_type_Ainj.a(0);
    this.jdField_a_of_type_Aink.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aini
 * JD-Core Version:    0.7.0.1
 */