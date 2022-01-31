import com.tencent.common.app.BaseApplicationImpl;
import java.lang.reflect.Method;

public class agwg
{
  public static void a(String paramString)
  {
    try
    {
      ClassLoader localClassLoader = BaseApplicationImpl.sApplication.getClassLoader();
      if (localClassLoader == null) {
        return;
      }
      localClassLoader.loadClass("cooperation.qwallet.plugin.QWalletPluginProxyActivity").getMethod("handleNoCatchCrash", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     agwg
 * JD-Core Version:    0.7.0.1
 */