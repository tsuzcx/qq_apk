public class aamd
{
  private volatile int jdField_a_of_type_Int = 0;
  private aamn jdField_a_of_type_Aamn;
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Aamn != null) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_Aamn.d();
      return;
    case 1: 
      this.jdField_a_of_type_Aamn.b();
      return;
    case 2: 
      this.jdField_a_of_type_Aamn.a();
      return;
    }
    this.jdField_a_of_type_Aamn.c();
  }
  
  public void a(aamn paramaamn)
  {
    this.jdField_a_of_type_Aamn = paramaamn;
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
 * Qualified Name:     aamd
 * JD-Core Version:    0.7.0.1
 */