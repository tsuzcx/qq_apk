import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alnh
  implements View.OnClickListener
{
  public alnh(LoginView paramLoginView) {}
  
  public void onClick(View paramView)
  {
    bdla.a(this.a.a, "dc00898", "", "", "0X800AA2E", "0X800AA2E", 0, 0, "", "", "", "");
    LoginView.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnh
 * JD-Core Version:    0.7.0.1
 */