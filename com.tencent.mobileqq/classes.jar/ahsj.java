public class ahsj
{
  private ahsi jdField_a_of_type_Ahsi = new ahsi();
  private ahsk jdField_a_of_type_Ahsk = new ahsk();
  private ahsl jdField_a_of_type_Ahsl = new ahsl();
  
  public ahsi a()
  {
    return this.jdField_a_of_type_Ahsi;
  }
  
  public ahsk a()
  {
    return this.jdField_a_of_type_Ahsk;
  }
  
  public ahsl a()
  {
    return this.jdField_a_of_type_Ahsl;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_Ahsl.b) {
      return this.jdField_a_of_type_Ahsi.b();
    }
    if (this.jdField_a_of_type_Ahsk.f()) {
      return this.jdField_a_of_type_Ahsi.a();
    }
    return "";
  }
  
  public void a()
  {
    a().b("");
    this.jdField_a_of_type_Ahsk.a(0);
    this.jdField_a_of_type_Ahsl.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsj
 * JD-Core Version:    0.7.0.1
 */