class afim
  implements Comparable<afim>
{
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  
  afim(afik paramafik, String paramString, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangLong = paramLong;
  }
  
  public int a(afim paramafim)
  {
    if (this.jdField_a_of_type_JavaLangLong.longValue() > paramafim.jdField_a_of_type_JavaLangLong.longValue()) {
      return -1;
    }
    return 1;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afim
 * JD-Core Version:    0.7.0.1
 */