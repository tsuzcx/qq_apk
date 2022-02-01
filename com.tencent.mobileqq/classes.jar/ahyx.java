public class ahyx
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("UserInfo{");
    localStringBuffer.append("age=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", sex=").append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", nickName='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", province='").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", city='").append(this.jdField_c_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", headPic='").append(this.d).append('\'');
    localStringBuffer.append(", relationShip=").append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", uin='").append(this.e).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyx
 * JD-Core Version:    0.7.0.1
 */