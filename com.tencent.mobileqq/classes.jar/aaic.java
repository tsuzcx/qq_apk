public class aaic
{
  private volatile int jdField_a_of_type_Int = 0;
  private aaim jdField_a_of_type_Aaim;
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Aaim != null) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_Aaim.d();
      return;
    case 1: 
      this.jdField_a_of_type_Aaim.b();
      return;
    case 2: 
      this.jdField_a_of_type_Aaim.a();
      return;
    }
    this.jdField_a_of_type_Aaim.c();
  }
  
  public void a(aaim paramaaim)
  {
    this.jdField_a_of_type_Aaim = paramaaim;
    a(this.jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaic
 * JD-Core Version:    0.7.0.1
 */