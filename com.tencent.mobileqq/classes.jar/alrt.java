import com.tencent.mobileqq.ark.ArkAppCenter;

class alrt
  implements alrx
{
  alrt(alrm paramalrm, alrw paramalrw, String paramString, alry paramalry) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alrw.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Alry.a(false);
      return;
      if (!alrm.b(paramArrayOfByte, this.jdField_a_of_type_Alrw.d))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alrw.b, this.jdField_a_of_type_Alrw.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString });
        if (alrm.a(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alrw.b, str }));
      }
    }
    this.jdField_a_of_type_Alry.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alrt
 * JD-Core Version:    0.7.0.1
 */