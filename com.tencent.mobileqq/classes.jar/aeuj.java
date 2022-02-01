import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeuj
  implements View.OnClickListener
{
  public aeuj(ActivateFriendActivity paramActivateFriendActivity, bjnw parambjnw) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app;
    if (ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {}
    for (;;)
    {
      aevc.a(localQQAppInterface, "remindpage_click", null, null, String.valueOf(2), String.valueOf(i));
      this.jdField_a_of_type_Bjnw.dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeuj
 * JD-Core Version:    0.7.0.1
 */