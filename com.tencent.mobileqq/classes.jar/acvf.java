import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.31.3.1;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.ThreadManager;

public class acvf
  implements View.OnClickListener
{
  acvf(acvc paramacvc) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Awki == null) {}
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_Awki.a instanceof String)) {
        paramView = (String)this.a.jdField_a_of_type_Awki.a;
      }
      while (paramView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(paramView);
        ThreadManager.post(new FriendProfileCardActivity.31.3.1(this), 5, null, true);
        return;
        if ((this.a.jdField_a_of_type_Awki.a instanceof ProfileActivity.CardContactInfo))
        {
          paramView = (ProfileActivity.CardContactInfo)this.a.jdField_a_of_type_Awki.a;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a.a == 33)) {
            paramView = paramView.c;
          } else {
            paramView = paramView.a + " " + paramView.c;
          }
        }
        else if ((this.a.jdField_a_of_type_Awki.a instanceof awjt))
        {
          if ((paramView instanceof TextView)) {
            paramView = ((awjt)this.a.jdField_a_of_type_Awki.a).a(((TextView)paramView).getText().toString());
          } else {
            paramView = ((awjt)this.a.jdField_a_of_type_Awki.a).a;
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
 * Qualified Name:     acvf
 * JD-Core Version:    0.7.0.1
 */