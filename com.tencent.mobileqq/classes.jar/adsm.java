import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.QQSettingMe;

public class adsm
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public adsm(QQSettingMe paramQQSettingMe) {}
  
  public void onGlobalLayout()
  {
    if (QQSettingMe.a(this.a)) {
      QQSettingMe.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsm
 * JD-Core Version:    0.7.0.1
 */