import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDGuideActivity;

public class abhw
  implements View.OnClickListener
{
  public abhw(GesturePWDGuideActivity paramGesturePWDGuideActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, GesturePWDCreateActivity.class);
    this.a.startActivityForResult(paramView, 999);
    this.a.overridePendingTransition(2130771997, 2130771990);
    axqy.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_Gesture_password", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhw
 * JD-Core Version:    0.7.0.1
 */