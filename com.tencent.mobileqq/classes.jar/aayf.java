import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDManualGuideActivity;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

public class aayf
  implements View.OnClickListener
{
  public aayf(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301406: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.getCurrentAccountUin(), 20);
      this.a.a();
      return;
    case 2131301403: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.getCurrentAccountUin(), 21);
      this.a.a();
      return;
    case 2131301407: 
      paramView = new Intent(this.a, GesturePWDManualGuideActivity.class);
      this.a.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a, GesturePWDCreateActivity.class);
    this.a.startActivityForResult(paramView, 11);
    this.a.overridePendingTransition(2130771997, 2130771990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aayf
 * JD-Core Version:    0.7.0.1
 */