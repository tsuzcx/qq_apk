import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;

class aash
  implements aasr
{
  aash(aasc paramaasc, aasp paramaasp, aasr paramaasr, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString }));
      ArkAppDataReport.a(this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString, 4);
      this.jdField_a_of_type_Aasr.a(true);
      return;
    }
    ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString }));
    ArkAppDataReport.a(this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString, 1);
    aasc.a(this.jdField_a_of_type_Aasc, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aasp, new aasi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aash
 * JD-Core Version:    0.7.0.1
 */