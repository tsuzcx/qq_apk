import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForceLogoutActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adxz
  implements View.OnClickListener
{
  public adxz(ForceLogoutActivity paramForceLogoutActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    this.a.startActivity(new Intent(this.a, LoginActivity.class).addFlags(67108864));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxz
 * JD-Core Version:    0.7.0.1
 */