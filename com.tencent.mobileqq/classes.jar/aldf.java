import com.tencent.mobileqq.ark.ArkAppCenter;

class aldf
  implements aldj
{
  aldf(alcy paramalcy, aldi paramaldi, String paramString, aldk paramaldk) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Aldi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aldi.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Aldk.a(false);
      return;
      if (!alcy.b(paramArrayOfByte, this.jdField_a_of_type_Aldi.d))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Aldi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aldi.b, this.jdField_a_of_type_Aldi.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aldi.jdField_a_of_type_JavaLangString });
        if (alcy.a(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_Aldi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aldi.b, str }));
      }
    }
    this.jdField_a_of_type_Aldk.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aldf
 * JD-Core Version:    0.7.0.1
 */