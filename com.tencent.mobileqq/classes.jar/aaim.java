import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.qphone.base.util.QLog;

public class aaim
  implements View.OnClickListener
{
  public aaim(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      altc.a(this.a.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.a).a, null, altc.b, 0, 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "click to close");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaim
 * JD-Core Version:    0.7.0.1
 */