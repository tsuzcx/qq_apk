import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.SecUtil;

class akbi
  implements Runnable
{
  akbi(akbh paramakbh, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.jdField_a_of_type_Akbh.a.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    String str = SecUtil.getFileMd5(this.jdField_a_of_type_Akbh.a.a(this.jdField_a_of_type_JavaLangString));
    if (!this.b.equalsIgnoreCase(str))
    {
      this.jdField_a_of_type_Akbh.a.a(this.jdField_a_of_type_JavaLangString, this.b, this.c);
      return;
    }
    this.jdField_a_of_type_Akbh.a.a(this.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akbi
 * JD-Core Version:    0.7.0.1
 */