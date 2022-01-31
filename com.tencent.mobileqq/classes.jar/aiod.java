import android.os.Bundle;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.diy.ResData;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.qphone.base.util.QLog;

public class aiod
  implements ThemeDiyStyleLogic.StyleCallBack
{
  public aiod(ThemeSwitchManager paramThemeSwitchManager) {}
  
  public int callback(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    if (paramInt2 == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "saveThemeToSVCallBack:save theme server ok, themeId=" + this.a.a + ",version=" + this.a.b);
      }
      new aiok(this.a).execute(new Object[] { this.a.a, this.a.b });
      return 0;
    }
    QLog.e("ThemeSwitchManager", 1, "saveThemeToSVCallBack:save theme server error, themeId=" + this.a.a + ",version=" + this.a.b);
    this.a.a(-2, this.a.a, this.a.b, 20);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiod
 * JD-Core Version:    0.7.0.1
 */