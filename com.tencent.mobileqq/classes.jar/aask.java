import com.tencent.mobileqq.ark.ArkAppCenter;

class aask
  implements aasq
{
  aask(aasc paramaasc, aasp paramaasp, String paramString, aasr paramaasr) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aasp.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Aasr.a(false);
      return;
      if (!aasc.b(paramArrayOfByte, this.jdField_a_of_type_Aasp.d))
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aasp.b, this.jdField_a_of_type_Aasp.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString });
        if (aasc.a(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aasp.b, str }));
      }
    }
    this.jdField_a_of_type_Aasr.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aask
 * JD-Core Version:    0.7.0.1
 */