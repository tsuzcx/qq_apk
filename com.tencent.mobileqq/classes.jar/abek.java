import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.31.3.1;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.ThreadManager;

public class abek
  implements View.OnClickListener
{
  abek(abeh paramabeh) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Ausu == null) {}
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_Ausu.a instanceof String)) {
        paramView = (String)this.a.jdField_a_of_type_Ausu.a;
      }
      while (paramView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(paramView);
        ThreadManager.post(new FriendProfileCardActivity.31.3.1(this), 5, null, true);
        return;
        if ((this.a.jdField_a_of_type_Ausu.a instanceof ProfileActivity.CardContactInfo))
        {
          paramView = (ProfileActivity.CardContactInfo)this.a.jdField_a_of_type_Ausu.a;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a.a == 33)) {
            paramView = paramView.c;
          } else {
            paramView = paramView.a + " " + paramView.c;
          }
        }
        else if ((this.a.jdField_a_of_type_Ausu.a instanceof ausf))
        {
          if ((paramView instanceof TextView)) {
            paramView = ((ausf)this.a.jdField_a_of_type_Ausu.a).a(((TextView)paramView).getText().toString());
          } else {
            paramView = ((ausf)this.a.jdField_a_of_type_Ausu.a).a;
          }
        }
        else
        {
          paramView = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abek
 * JD-Core Version:    0.7.0.1
 */