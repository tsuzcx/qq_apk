import com.tencent.ark.ark.Application;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter.ApplicationInformation;
import java.util.Map;

public final class abal
  implements Runnable
{
  public abal(String paramString) {}
  
  public void run()
  {
    ArkAppCenter.ApplicationInformation localApplicationInformation = new ArkAppCenter.ApplicationInformation();
    ark.Application localApplication = ark.Application.Create(this.jdField_a_of_type_JavaLangString);
    localApplicationInformation.jdField_a_of_type_JavaLangString = localApplication.GetActionSet();
    localApplicationInformation.b = localApplication.GetDescription();
    localApplicationInformation.c = localApplication.GetVersion();
    localApplicationInformation.jdField_a_of_type_Int = localApplication.CheckVersion();
    localApplicationInformation.d = localApplication.GetPermissions();
    localApplicationInformation.e = localApplication.GetLauncher();
    localApplication.Release();
    ArkAppCenter.a.put(this.jdField_a_of_type_JavaLangString, localApplicationInformation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abal
 * JD-Core Version:    0.7.0.1
 */