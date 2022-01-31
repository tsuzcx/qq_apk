import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;

class aasg
  implements aasr
{
  aasg(aasc paramaasc, aasp paramaasp, aasr paramaasr) {}
  
  public void a(boolean paramBoolean)
  {
    ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, local not exists, full update, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.jdField_a_of_type_Aasp.a }));
    if (paramBoolean) {
      ArkAppDataReport.a(this.jdField_a_of_type_Aasp.a, 2);
    }
    this.jdField_a_of_type_Aasr.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aasg
 * JD-Core Version:    0.7.0.1
 */