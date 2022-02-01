class aiwt
  implements Comparable<aiwt>
{
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  
  aiwt(aiwr paramaiwr, String paramString, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangLong = paramLong;
  }
  
  public int a(aiwt paramaiwt)
  {
    if (this.jdField_a_of_type_JavaLangLong.longValue() > paramaiwt.jdField_a_of_type_JavaLangLong.longValue()) {
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
 * Qualified Name:     aiwt
 * JD-Core Version:    0.7.0.1
 */