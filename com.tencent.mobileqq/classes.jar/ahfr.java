class ahfr
  implements Comparable<ahfr>
{
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  
  ahfr(ahfp paramahfp, String paramString, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangLong = paramLong;
  }
  
  public int a(ahfr paramahfr)
  {
    if (this.jdField_a_of_type_JavaLangLong.longValue() > paramahfr.jdField_a_of_type_JavaLangLong.longValue()) {
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
 * Qualified Name:     ahfr
 * JD-Core Version:    0.7.0.1
 */