public class aiqf
{
  public int a;
  public long a;
  public long b;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof aiqf))
    {
      paramObject = (aiqf)paramObject;
      if ((paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (paramObject.jdField_a_of_type_Long == this.jdField_a_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqf
 * JD-Core Version:    0.7.0.1
 */