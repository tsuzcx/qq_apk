import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;

class aaza
  implements aazl
{
  aaza(aayw paramaayw, aazj paramaazj, aazl paramaazl) {}
  
  public void a(boolean paramBoolean)
  {
    ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateDict, local not exists, full update, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.jdField_a_of_type_Aazj.a }));
    if (paramBoolean) {
      ArkAppDataReport.a(this.jdField_a_of_type_Aazj.a, 2);
    }
    this.jdField_a_of_type_Aazl.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaza
 * JD-Core Version:    0.7.0.1
 */