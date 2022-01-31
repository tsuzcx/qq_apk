import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;

class aalg
  implements aalq
{
  aalg(aalb paramaalb, aalo paramaalo, aalq paramaalq, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Aalo.jdField_a_of_type_JavaLangString }));
      ArkAppDataReport.a(this.jdField_a_of_type_Aalo.jdField_a_of_type_JavaLangString, 4);
      this.jdField_a_of_type_Aalq.a(true);
      return;
    }
    ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Aalo.jdField_a_of_type_JavaLangString }));
    ArkAppDataReport.a(this.jdField_a_of_type_Aalo.jdField_a_of_type_JavaLangString, 1);
    aalb.a(this.jdField_a_of_type_Aalb, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aalo, new aalh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aalg
 * JD-Core Version:    0.7.0.1
 */