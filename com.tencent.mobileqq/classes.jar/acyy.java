import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDManualGuideActivity;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

public class acyy
  implements View.OnClickListener
{
  public acyy(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367143: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.getCurrentAccountUin(), 20);
      this.a.a();
      return;
    case 2131367140: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.getCurrentAccountUin(), 21);
      this.a.a();
      return;
    case 2131367144: 
      paramView = new Intent(this.a, GesturePWDManualGuideActivity.class);
      this.a.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a, GesturePWDCreateActivity.class);
    this.a.startActivityForResult(paramView, 11);
    this.a.overridePendingTransition(2130771997, 2130771990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyy
 * JD-Core Version:    0.7.0.1
 */