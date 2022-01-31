import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class aczi
  implements bhuk
{
  public aczi(FriendProfileCardActivity paramFriendProfileCardActivity, PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhuf.e();
      return;
      Object localObject;
      if (bdin.d(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getApplication().getApplicationContext()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ArrayOfJavaLangString[3];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramView = (View)localObject;
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo)) {}
        }
        else
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k;
        }
        if (!TextUtils.isEmpty(paramView))
        {
          localObject = paramView;
          if (!paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo)) {}
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataContactCard.nickName;
        }
        localObject = aseb.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataContactCard.bindQQ);
        paramView = new Bundle();
        paramView.putString("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo);
        paramView.putInt("uintype", 1006);
        paramView.putInt("forward_type", 20);
        paramView.putInt("structmsg_service_id", ((AbsShareMsg)localObject).mMsgServiceID);
        paramView.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
        paramView.putBoolean("k_dataline", false);
        paramView.putInt("pa_type", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
        localObject = new Intent();
        ((Intent)localObject).putExtras(paramView);
        aryv.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, (Intent)localObject, 21);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007016", "0X8007016", 0, 0, "", "", "", "");
        } else {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007168", "0X8007168", 0, 0, "", "", "", "");
        }
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 1, alud.a(2131705307), 1000).a();
        continue;
        if (bdin.d(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getApplication().getApplicationContext()))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
          localObject = FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          label472:
          QQAppInterface localQQAppInterface;
          if (!this.jdField_a_of_type_Boolean)
          {
            paramView.a((String)localObject, bool);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.z();
            localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app;
            if (!this.jdField_a_of_type_Boolean) {
              break label548;
            }
            paramView = "0X800603E";
            label505:
            if (!this.jdField_a_of_type_Boolean) {
              break label554;
            }
          }
          label548:
          label554:
          for (localObject = "0X800603E";; localObject = "0X800603D")
          {
            azqs.b(localQQAppInterface, "CliOper", "", "", paramView, (String)localObject, 0, 0, "", "", "", "");
            break;
            bool = false;
            break label472;
            paramView = "0X800603D";
            break label505;
          }
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 1, alud.a(2131705292), 1000).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczi
 * JD-Core Version:    0.7.0.1
 */