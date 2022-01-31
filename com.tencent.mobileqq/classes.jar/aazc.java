import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;

class aazc
  implements aazl
{
  aazc(aazb paramaazb) {}
  
  public void a(boolean paramBoolean)
  {
    ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, full update result, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.a.jdField_a_of_type_Aazj.a }));
    if (paramBoolean) {
      ArkAppDataReport.a(this.a.jdField_a_of_type_Aazj.a, 2);
    }
    this.a.jdField_a_of_type_Aazl.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazc
 * JD-Core Version:    0.7.0.1
 */