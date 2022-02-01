import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adkj
  implements View.OnClickListener
{
  public adkj(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.dismiss();
      AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, -1, this.jdField_a_of_type_JavaLangString);
      label58:
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a = null;
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adkj
 * JD-Core Version:    0.7.0.1
 */