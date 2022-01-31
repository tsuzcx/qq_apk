import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import dov.com.qq.im.capture.util.ConfigSimplifier.ConfigDownloadCallback;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;

public class absr
  implements ConfigSimplifier.ConfigDownloadCallback
{
  public absr(ConfigServlet paramConfigServlet, QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig) {}
  
  public void a(String paramString)
  {
    VideoFilterTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramString, this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     absr
 * JD-Core Version:    0.7.0.1
 */