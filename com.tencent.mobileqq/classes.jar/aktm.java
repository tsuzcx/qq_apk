import android.graphics.RectF;

public class aktm
{
  public int a;
  public RectF a;
  public String a;
  aktl[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  
  public aktm()
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_c_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ssoErrCode:").append(this.jdField_a_of_type_Int).append(",ssoErrMsg:").append(this.jdField_a_of_type_JavaLangString).append(",errCode:").append(this.jdField_b_of_type_Int).append(",errMsg:").append(this.jdField_b_of_type_JavaLangString).append(",sessionId:").append(this.jdField_c_of_type_JavaLangString).append(",moreUrl:").append(this.d);
    int i = 0;
    while ((this.jdField_a_of_type_ArrayOfAktl != null) && (i < this.jdField_a_of_type_ArrayOfAktl.length))
    {
      localStringBuilder.append("\n{index=").append(i).append(":").append(this.jdField_a_of_type_ArrayOfAktl[i].toString()).append("}\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aktm
 * JD-Core Version:    0.7.0.1
 */