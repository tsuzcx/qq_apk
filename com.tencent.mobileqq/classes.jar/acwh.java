import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.qphone.base.util.QLog;

public class acwh
  implements DialogInterface.OnClickListener
{
  public acwh(FriendProfileCardActivity paramFriendProfileCardActivity, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.dismiss();
      com.tencent.mobileqq.activity.AddFriendLogicActivity.b = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "qbShowShareResultDialog back");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getIntent().getIntExtra("source_id", 3999) == 3090) {}
      try
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getIntent().getStringExtra("extra");
        arys.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, true, "action_game_make_friend", Long.valueOf(paramDialogInterface).longValue(), -1, alpo.a(2131705293));
        if ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity))) {
          continue;
        }
        ((Activity)this.jdField_a_of_type_AndroidContentContext).moveTaskToBack(true);
      }
      catch (Exception paramDialogInterface)
      {
        for (;;)
        {
          QLog.e("FriendProfileCardActivity", 1, "feedBackToGameSDK error = " + paramDialogInterface);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "qbShowShareResultDialog stay");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwh
 * JD-Core Version:    0.7.0.1
 */