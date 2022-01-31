import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.QQSettingMe;

public class abwp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public abwp(QQSettingMe paramQQSettingMe) {}
  
  public void onGlobalLayout()
  {
    if (QQSettingMe.a(this.a)) {
      QQSettingMe.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abwp
 * JD-Core Version:    0.7.0.1
 */