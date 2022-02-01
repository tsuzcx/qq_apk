import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agbp
  implements View.OnClickListener
{
  public agbp(ActivateFriendActivity paramActivateFriendActivity, blir paramblir) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app;
    if (ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {}
    for (;;)
    {
      agci.a(localQQAppInterface, "remindpage_click", null, null, String.valueOf(2), String.valueOf(i));
      this.jdField_a_of_type_Blir.dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbp
 * JD-Core Version:    0.7.0.1
 */