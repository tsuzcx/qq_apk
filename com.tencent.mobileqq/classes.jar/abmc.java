import com.tencent.mobileqq.app.HotchatSCMng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class abmc
  implements Runnable
{
  public abmc(ConfigServlet paramConfigServlet, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime();
    boolean bool = ((HotchatSCMng)localQQAppInterface.getManager(122)).a(this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config);
    SharedPreUtils.a(localQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get(), bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abmc
 * JD-Core Version:    0.7.0.1
 */