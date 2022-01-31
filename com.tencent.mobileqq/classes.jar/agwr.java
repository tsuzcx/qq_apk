import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

final class agwr
  implements DialogInterface.OnClickListener
{
  agwr(AbsShareMsg paramAbsShareMsg, FragmentActivity paramFragmentActivity, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "qbShowWpaResultDialog back");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        paramDialogInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("appid");
        if (paramDialogInterface != null) {
          asdb.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, true, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type"), Long.parseLong(paramDialogInterface));
        }
      }
      ndq.a(this.jdField_a_of_type_AndroidContentContext, 0, "", "");
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8004B56", "0X8004B56", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8004B55", "0X8004B55", 0, 0, "", "", "", "");
    if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      paramDialogInterface.putExtra("tab_index", MainFragment.b);
      paramDialogInterface.addFlags(67108864);
      paramDialogInterface.addFlags(268435456);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment().a().R();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwr
 * JD-Core Version:    0.7.0.1
 */