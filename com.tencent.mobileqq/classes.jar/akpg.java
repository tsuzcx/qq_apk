import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.PhoneFrame;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akpg
  implements View.OnClickListener
{
  public akpg(PhoneFrameActivity paramPhoneFrameActivity) {}
  
  public void onClick(View paramView)
  {
    auxu localauxu = this.a.a.a();
    if (localauxu != null) {
      localauxu.a(false);
    }
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.f = false;
    this.a.setResult(1);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpg
 * JD-Core Version:    0.7.0.1
 */