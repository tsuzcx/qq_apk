import com.tencent.mobileqq.ark.ArkAppCenter;

class alrp
  implements alrx
{
  alrp(alrl paramalrl, alrv paramalrv, alrx paramalrx, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Alrv.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Alrx.a(true);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Alrv.jdField_a_of_type_JavaLangString }));
    alrl.a(this.jdField_a_of_type_Alrl, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alrv, new alrq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alrp
 * JD-Core Version:    0.7.0.1
 */