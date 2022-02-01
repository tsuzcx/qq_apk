import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment;

public class aixs
  extends ClickableSpan
{
  public aixs(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void onClick(View paramView)
  {
    PermisionPrivacyActivity.a(NewFriendVerifyBlockedListFragment.a(this.a));
    bdla.b(null, "dc00898", "", "", "0X800A3AA", "0X800A3AA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixs
 * JD-Core Version:    0.7.0.1
 */