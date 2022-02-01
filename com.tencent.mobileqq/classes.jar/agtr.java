import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class agtr
  implements bkzq
{
  agtr(agtp paramagtp, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkzi.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    }
    String str;
    if (this.jdField_a_of_type_Agtp.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1006)
    {
      str = this.jdField_a_of_type_Agtp.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      paramView = null;
    }
    for (;;)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Agtp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_Agtp.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agtp.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView, this.jdField_a_of_type_Agtp.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, str, true, this.jdField_a_of_type_Agtp.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin, true, true, null, "from_internal");
      str = ChatActivityUtils.a(this.jdField_a_of_type_Agtp.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      bdla.b(this.jdField_a_of_type_Agtp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "13", paramView, "", "");
      bdla.b(this.jdField_a_of_type_Agtp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005974", "0X8005974", 0, 0, "", "", "", "");
      return;
      paramView = this.jdField_a_of_type_Agtp.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtr
 * JD-Core Version:    0.7.0.1
 */