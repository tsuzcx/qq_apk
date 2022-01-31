import com.tencent.mobileqq.ark.ArkAppCenter;

class aldc
  implements aldk
{
  aldc(alcy paramalcy, aldi paramaldi, aldk paramaldk, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Aldi.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Aldk.a(true);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Aldi.jdField_a_of_type_JavaLangString }));
    alcy.a(this.jdField_a_of_type_Alcy, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aldi, new aldd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aldc
 * JD-Core Version:    0.7.0.1
 */