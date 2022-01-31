import com.tencent.qqprotect.qsec.ICloudAVEngine.ResultBundle;

final class alww
  extends alwz
{
  public ICloudAVEngine.ResultBundle a;
  private String jdField_a_of_type_JavaLangString;
  
  public alww(alwu paramalwu, String paramString)
  {
    super(null);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(String paramString, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    if (paramString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$ResultBundle = paramResultBundle;
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alww
 * JD-Core Version:    0.7.0.1
 */