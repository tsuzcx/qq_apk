import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class agot
  implements Runnable
{
  public agot(OpenApiManager paramOpenApiManager, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "onRuntimeDisactive, app = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface + ", current = " + OpenApiManager.access$000(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager) + ", " + this.jdField_a_of_type_Boolean);
    }
    if ((OpenApiManager.access$000(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager) != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == OpenApiManager.access$000(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager)))
    {
      OpenApiManager.access$000(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager).removeObserver(OpenApiManager.access$100(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager));
      OpenApiManager.access$200(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager).clear();
      OpenApiManager.access$300(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager).clear();
      OpenApiManager.access$402(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager, 0);
      OpenApiManager.access$502(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager, 0);
      OpenApiManager.access$002(this.jdField_a_of_type_ComTencentMobileqqOpenapiOpenApiManager, null);
      BaseApplicationImpl.sApplication.sendBroadcast(new Intent("com.tencent.mobileqq.openapi.ACTION_LOGOUT"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agot
 * JD-Core Version:    0.7.0.1
 */