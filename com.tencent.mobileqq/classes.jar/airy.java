import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.qphone.base.util.QLog;

class airy
  implements Animator.AnimatorListener
{
  airy(airw paramairw) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.a = true;
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsActivity", 2, "click search onAnimationEnd mCurrentView = " + AddContactsActivity.a(this.a.a));
    }
    if ((AddContactsActivity.a(this.a.a) instanceof AddContactsView)) {
      ActiveEntitySearchActivity.a(this.a.a, anvx.a(2131713102), new long[] { 1001L, 1002L }, 99);
    }
    for (;;)
    {
      this.a.a.overridePendingTransition(0, 0);
      bhbr.a(false);
      return;
      paramAnimator = new Intent(this.a.a, SearchContactsActivity.class);
      paramAnimator.putExtra("from_key", this.a.a.a());
      paramAnimator.putExtra("fromType", 13);
      this.a.a.startActivity(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airy
 * JD-Core Version:    0.7.0.1
 */