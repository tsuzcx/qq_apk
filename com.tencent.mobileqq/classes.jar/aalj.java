import com.tencent.mobileqq.ark.ArkAppCenter;

class aalj
  implements aalp
{
  aalj(aalb paramaalb, aalo paramaalo, String paramString, aalq paramaalq) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Aalo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aalo.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Aalq.a(false);
      return;
      if (!aalb.b(paramArrayOfByte, this.jdField_a_of_type_Aalo.d))
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Aalo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aalo.b, this.jdField_a_of_type_Aalo.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aalo.jdField_a_of_type_JavaLangString });
        if (aalb.a(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_Aalo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aalo.b, str }));
      }
    }
    this.jdField_a_of_type_Aalq.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aalj
 * JD-Core Version:    0.7.0.1
 */