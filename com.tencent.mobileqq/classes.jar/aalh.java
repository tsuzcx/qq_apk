import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;

class aalh
  implements aalq
{
  aalh(aalg paramaalg) {}
  
  public void a(boolean paramBoolean)
  {
    ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, full update result, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.a.jdField_a_of_type_Aalo.a }));
    if (paramBoolean) {
      ArkAppDataReport.a(this.a.jdField_a_of_type_Aalo.a, 2);
    }
    this.a.jdField_a_of_type_Aalq.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aalh
 * JD-Core Version:    0.7.0.1
 */