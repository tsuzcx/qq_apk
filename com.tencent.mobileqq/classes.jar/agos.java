import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.qphone.base.util.QLog;

public class agos
  implements Runnable
{
  public agos(OpenApiManager paramOpenApiManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "onRuntimeCreate, app = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface + ", current = " + OpenApiManager.access$000(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager) + ", bg = " + BaseApplicationImpl.sIsBgStartup);
    }
    this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager.onRuntimeDestroy(OpenApiManager.access$000(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager));
    OpenApiManager.access$002(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Intent localIntent = new Intent("com.tencent.mobileqq.openapi.ACTION_LOGIN");
    if (BaseApplicationImpl.sIsBgStartup) {
      localIntent.putExtra("imm_reg", true);
    }
    BaseApplicationImpl.sApplication.sendBroadcast(localIntent);
    OpenApiManager.access$000(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager).addObserver(OpenApiManager.access$100(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agos
 * JD-Core Version:    0.7.0.1
 */