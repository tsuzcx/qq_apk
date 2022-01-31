import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ablk
  implements Runnable
{
  public ablk(AboutConfig paramAboutConfig, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    ??? = AboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig).getEntityManagerFactory().createEntityManager();
    List localList = ResourcePluginInfo.getAll((EntityManager)???, 32, false);
    ((EntityManager)???).a();
    int j;
    if (localList != null)
    {
      j = localList.size();
      i = j;
      if (j <= 0) {}
    }
    synchronized (AboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig))
    {
      AboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig);
      AboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig, localList);
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.b();
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("AboutConfig", 2, "Load about config from DB = " + AboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig) + ",asynchronous=" + this.jdField_a_of_type_Boolean + ",size=" + i);
      }
      AboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ablk
 * JD-Core Version:    0.7.0.1
 */