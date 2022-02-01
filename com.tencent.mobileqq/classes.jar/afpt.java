public class afpt
{
  public int a;
  bhck jdField_a_of_type_Bhck;
  volatile boolean jdField_a_of_type_Boolean;
  
  public afpt(bhck parambhck, int paramInt)
  {
    this(parambhck, paramInt, false);
  }
  
  public afpt(bhck parambhck, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bhck = parambhck;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bhck a()
  {
    return this.jdField_a_of_type_Bhck;
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
  
  public boolean a(afpt paramafpt)
  {
    if ((paramafpt == null) || (this.jdField_a_of_type_Bhck == null)) {
      return false;
    }
    return this.jdField_a_of_type_Bhck.equals(paramafpt.jdField_a_of_type_Bhck);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpt
 * JD-Core Version:    0.7.0.1
 */