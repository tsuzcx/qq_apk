import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloadReportUtils;
import cooperation.comic.PluginPreloadStrategy;
import cooperation.comic.PluginPreloader.ExtraResult;
import mqq.app.AppRuntime;

public final class altb
  implements OnPluginInstallListener
{
  public altb(AppRuntime paramAppRuntime, PluginPreloadStrategy paramPluginPreloadStrategy, PluginPreloader.ExtraResult paramExtraResult, int paramInt) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "pluginType:" + this.jdField_a_of_type_CooperationComicPluginPreloadStrategy.b + " preload:fail:installerror");
    }
    PluginPreloadReportUtils.a(this.jdField_a_of_type_MqqAppAppRuntime, 1, this.jdField_a_of_type_CooperationComicPluginPreloadStrategy.b, this.jdField_a_of_type_CooperationComicPluginPreloadStrategy.c, 3, "preload:fail:installerror", this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_CooperationComicPluginPreloadStrategy.d) });
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "plugin install success, do preload.");
    }
    PluginPreloadReportUtils.a(this.jdField_a_of_type_MqqAppAppRuntime, 0, this.jdField_a_of_type_CooperationComicPluginPreloadStrategy.b, this.jdField_a_of_type_CooperationComicPluginPreloadStrategy.c, this.jdField_a_of_type_CooperationComicPluginPreloader$ExtraResult.jdField_a_of_type_Int, this.jdField_a_of_type_CooperationComicPluginPreloader$ExtraResult.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_CooperationComicPluginPreloadStrategy.d) });
    this.jdField_a_of_type_CooperationComicPluginPreloadStrategy.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altb
 * JD-Core Version:    0.7.0.1
 */