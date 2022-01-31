public class alxq
{
  public int a;
  public alxr a;
  public Object a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  
  public alxq()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|_DownloadParam_start");
    localStringBuilder.append("|").append(" type:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|").append(" md5:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("|").append(" endFix:").append(this.c);
    localStringBuilder.append("|").append(" retryCount:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("|").append(" needUnzip:").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("|").append(" needVerify:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("|").append(" url:").append(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaLangObject != null) {
      localStringBuilder.append("|").append(" userData:").append(this.jdField_a_of_type_JavaLangObject);
    }
    localStringBuilder.append("|end");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alxq
 * JD-Core Version:    0.7.0.1
 */