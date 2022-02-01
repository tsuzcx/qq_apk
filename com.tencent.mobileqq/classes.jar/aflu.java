import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aflu
  implements View.OnClickListener
{
  public aflu(ActivateFriendActivity paramActivateFriendActivity, bkzi parambkzi) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app;
    if (ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {}
    for (;;)
    {
      afmn.a(localQQAppInterface, "remindpage_click", null, null, String.valueOf(2), String.valueOf(i));
      this.jdField_a_of_type_Bkzi.dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflu
 * JD-Core Version:    0.7.0.1
 */