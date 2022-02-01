public class afvw
{
  public int a;
  bgkk jdField_a_of_type_Bgkk;
  volatile boolean jdField_a_of_type_Boolean;
  
  public afvw(bgkk parambgkk, int paramInt)
  {
    this(parambgkk, paramInt, false);
  }
  
  public afvw(bgkk parambgkk, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bgkk = parambgkk;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bgkk a()
  {
    return this.jdField_a_of_type_Bgkk;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(afvw paramafvw)
  {
    if ((paramafvw == null) || (this.jdField_a_of_type_Bgkk == null)) {
      return false;
    }
    return this.jdField_a_of_type_Bgkk.equals(paramafvw.jdField_a_of_type_Bgkk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvw
 * JD-Core Version:    0.7.0.1
 */