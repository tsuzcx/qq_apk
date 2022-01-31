import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.31.3.1;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.ThreadManager;

public class aczu
  implements View.OnClickListener
{
  aczu(aczr paramaczr) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Awor == null) {}
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_Awor.a instanceof String)) {
        paramView = (String)this.a.jdField_a_of_type_Awor.a;
      }
      while (paramView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(paramView);
        ThreadManager.post(new FriendProfileCardActivity.31.3.1(this), 5, null, true);
        return;
        if ((this.a.jdField_a_of_type_Awor.a instanceof ProfileActivity.CardContactInfo))
        {
          paramView = (ProfileActivity.CardContactInfo)this.a.jdField_a_of_type_Awor.a;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a.a == 33)) {
            paramView = paramView.c;
          } else {
            paramView = paramView.a + " " + paramView.c;
          }
        }
        else if ((this.a.jdField_a_of_type_Awor.a instanceof awoc))
        {
          if ((paramView instanceof TextView)) {
            paramView = ((awoc)this.a.jdField_a_of_type_Awor.a).a(((TextView)paramView).getText().toString());
          } else {
            paramView = ((awoc)this.a.jdField_a_of_type_Awor.a).a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczu
 * JD-Core Version:    0.7.0.1
 */