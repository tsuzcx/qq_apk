public class aeyh
{
  public int a;
  bfts jdField_a_of_type_Bfts;
  volatile boolean jdField_a_of_type_Boolean;
  
  public aeyh(bfts parambfts, int paramInt)
  {
    this(parambfts, paramInt, false);
  }
  
  public aeyh(bfts parambfts, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bfts = parambfts;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bfts a()
  {
    return this.jdField_a_of_type_Bfts;
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
  
  public boolean a(aeyh paramaeyh)
  {
    if ((paramaeyh == null) || (this.jdField_a_of_type_Bfts == null)) {
      return false;
    }
    return this.jdField_a_of_type_Bfts.equals(paramaeyh.jdField_a_of_type_Bfts);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyh
 * JD-Core Version:    0.7.0.1
 */