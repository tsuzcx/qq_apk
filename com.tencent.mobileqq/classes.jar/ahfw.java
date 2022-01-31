import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

class ahfw
  implements Animator.AnimatorListener
{
  ahfw(ahfu paramahfu) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.a = true;
    paramAnimator = new Intent(this.a.a, SearchContactsActivity.class);
    paramAnimator.putExtra("from_key", this.a.a.a());
    paramAnimator.putExtra("fromType", 13);
    this.a.a.startActivity(paramAnimator);
    this.a.a.overridePendingTransition(0, 0);
    bdeq.a(false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfw
 * JD-Core Version:    0.7.0.1
 */