import com.tencent.mobileqq.ark.ArkAppCenter;

class alrq
  implements alry
{
  alrq(alrm paramalrm, alrw paramalrw, alry paramalry, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Alry.a(true);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString }));
    alrm.a(this.jdField_a_of_type_Alrm, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alrw, new alrr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alrq
 * JD-Core Version:    0.7.0.1
 */