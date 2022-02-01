import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.PositionActivatePage;
import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

public class afml
  implements View.OnClickListener
{
  public afml(PositionActivatePage paramPositionActivatePage) {}
  
  public void onClick(View paramView)
  {
    if ((PositionActivatePage.a(this.a) != null) && (PositionActivatePage.a(this.a).get() != null))
    {
      Intent localIntent = new Intent((Context)PositionActivatePage.a(this.a).get(), SendBirthdayWishesActivity.class);
      localIntent.putExtra("key_msg_type", 1);
      localIntent.putExtra("key_friend_list", this.a.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a());
      localIntent.putExtra("key_roam_city", this.a.jdField_a_of_type_JavaLangString);
      ((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).startActivityForResult(localIntent, 1000);
      ((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).overridePendingTransition(2130771979, 2130771990);
      bdla.b(((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).app, "CliOper", "", "", "0X8004E06", "0X8004E06", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afml
 * JD-Core Version:    0.7.0.1
 */