import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.app.QQAppInterface;

public class ahbf
  implements ahcn
{
  public ahbf(AddContactsActivity paramAddContactsActivity) {}
  
  public Activity a()
  {
    return this.a;
  }
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a()
  {
    if (this.a.a) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -(this.a.getTitleBarHeight() + 0 + AddContactsActivity.a(this.a).a()) });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new ahbg(this));
    localValueAnimator.addListener(new ahbh(this));
    localValueAnimator.start();
    bdah.a(true);
  }
  
  public void b()
  {
    this.a.findViewById(2131375934).setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -(this.a.getTitleBarHeight() + 0 + AddContactsActivity.a(this.a).a()), 0 });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new ahbi(this));
    localValueAnimator.addListener(new ahbj(this));
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbf
 * JD-Core Version:    0.7.0.1
 */