import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.QIMPasterConfigManager;
import dov.com.qq.im.capture.util.ConfigSimplifier.ConfigDownloadCallback;

public class ablv
  implements ConfigSimplifier.ConfigDownloadCallback
{
  public ablv(ConfigServlet paramConfigServlet) {}
  
  public void a(String paramString)
  {
    ((QIMPasterConfigManager)QIMManager.a(1)).a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ablv
 * JD-Core Version:    0.7.0.1
 */