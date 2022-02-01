import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.QQSettingMe;

public class aerw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aerw(QQSettingMe paramQQSettingMe) {}
  
  public void onGlobalLayout()
  {
    if (QQSettingMe.a(this.a)) {
      QQSettingMe.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerw
 * JD-Core Version:    0.7.0.1
 */