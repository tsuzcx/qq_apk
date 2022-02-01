class ajhl
  implements Comparable<ajhl>
{
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  
  ajhl(ajhj paramajhj, String paramString, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangLong = paramLong;
  }
  
  public int a(ajhl paramajhl)
  {
    if (this.jdField_a_of_type_JavaLangLong.longValue() > paramajhl.jdField_a_of_type_JavaLangLong.longValue()) {
      return -1;
    }
    return 1;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhl
 * JD-Core Version:    0.7.0.1
 */