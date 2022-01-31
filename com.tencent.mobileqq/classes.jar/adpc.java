import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.HiBoomFont.HiBoomFontDownloader;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import mqq.app.AppRuntime;

public final class adpc
  implements HiBoomFont.HiBoomFontDownloader
{
  public String a()
  {
    return AppConstants.aJ + ".hiboom_font/";
  }
  
  public void a(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((VasQuickUpdateManager)localAppRuntime.getManager(183)).a(5L, "font.hifont.android." + paramInt, "HiBoomDownloader");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpc
 * JD-Core Version:    0.7.0.1
 */