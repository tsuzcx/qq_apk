import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;

class aazb
  implements aazl
{
  aazb(aayw paramaayw, aazj paramaazj, aazl paramaazl, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Aazj.jdField_a_of_type_JavaLangString }));
      ArkAppDataReport.a(this.jdField_a_of_type_Aazj.jdField_a_of_type_JavaLangString, 4);
      this.jdField_a_of_type_Aazl.a(true);
      return;
    }
    ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Aazj.jdField_a_of_type_JavaLangString }));
    ArkAppDataReport.a(this.jdField_a_of_type_Aazj.jdField_a_of_type_JavaLangString, 1);
    aayw.a(this.jdField_a_of_type_Aayw, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aazj, new aazc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazb
 * JD-Core Version:    0.7.0.1
 */