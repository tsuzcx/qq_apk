import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;

class aasi
  implements aasr
{
  aasi(aash paramaash) {}
  
  public void a(boolean paramBoolean)
  {
    ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, full update result, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.a.jdField_a_of_type_Aasp.a }));
    if (paramBoolean) {
      ArkAppDataReport.a(this.a.jdField_a_of_type_Aasp.a, 2);
    }
    this.a.jdField_a_of_type_Aasr.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aasi
 * JD-Core Version:    0.7.0.1
 */