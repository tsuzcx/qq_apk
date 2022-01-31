import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.qphone.base.util.QLog;

public class aceb
  implements View.OnClickListener
{
  public aceb(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      anoe.a(this.a.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.a).a, null, anoe.b, 0, 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "click to close");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aceb
 * JD-Core Version:    0.7.0.1
 */