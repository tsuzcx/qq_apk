import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.PhoneFrame;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;

public class agkl
  implements View.OnClickListener
{
  public agkl(PhoneFrameActivity paramPhoneFrameActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.a();
    if (paramView != null) {
      paramView.a(false);
    }
    com.tencent.mobileqq.app.PhoneContactManagerImp.f = false;
    this.a.setResult(1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agkl
 * JD-Core Version:    0.7.0.1
 */