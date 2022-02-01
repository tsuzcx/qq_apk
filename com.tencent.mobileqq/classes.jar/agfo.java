public class agfo
{
  public int a;
  bhkl jdField_a_of_type_Bhkl;
  volatile boolean jdField_a_of_type_Boolean;
  
  public agfo(bhkl parambhkl, int paramInt)
  {
    this(parambhkl, paramInt, false);
  }
  
  public agfo(bhkl parambhkl, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bhkl = parambhkl;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bhkl a()
  {
    return this.jdField_a_of_type_Bhkl;
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
  
  public boolean a(agfo paramagfo)
  {
    if ((paramagfo == null) || (this.jdField_a_of_type_Bhkl == null)) {
      return false;
    }
    return this.jdField_a_of_type_Bhkl.equals(paramagfo.jdField_a_of_type_Bhkl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfo
 * JD-Core Version:    0.7.0.1
 */