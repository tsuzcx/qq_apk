import com.tencent.mobileqq.ark.ArkAppCenter;

class alrq
  implements alrx
{
  alrq(alrp paramalrp) {}
  
  public void a(boolean paramBoolean)
  {
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, full update result, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.a.jdField_a_of_type_Alrv.a }));
    if (paramBoolean) {}
    this.a.jdField_a_of_type_Alrx.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alrq
 * JD-Core Version:    0.7.0.1
 */