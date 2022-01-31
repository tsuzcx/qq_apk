import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class aasw
  implements BusinessObserver
{
  public aasw(ArkAppCGI paramArkAppCGI, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.b("ArkApp.ArkAppCGI", "queryAppInfoByAppNameBatch, sso request failed");
      paramObject = null;
    }
    for (;;)
    {
      paramObject = ArkAppCGI.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI, (String)paramObject);
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ArkAppCGICallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ArkAppCGICallback.a(paramObject, this.jdField_a_of_type_JavaLangObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aasw
 * JD-Core Version:    0.7.0.1
 */