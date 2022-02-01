import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class agbe
  implements bjoe
{
  agbe(agbc paramagbc, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bjnw.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    }
    String str;
    if (this.jdField_a_of_type_Agbc.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1006)
    {
      str = this.jdField_a_of_type_Agbc.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      paramView = null;
    }
    for (;;)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Agbc.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_Agbc.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agbc.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView, this.jdField_a_of_type_Agbc.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, str, true, this.jdField_a_of_type_Agbc.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin, true, true, null, null);
      str = ChatActivityUtils.a(this.jdField_a_of_type_Agbc.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      bcef.b(this.jdField_a_of_type_Agbc.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "12", paramView, "", "");
      bcef.b(this.jdField_a_of_type_Agbc.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005974", "0X8005974", 0, 0, "", "", "", "");
      return;
      paramView = this.jdField_a_of_type_Agbc.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbe
 * JD-Core Version:    0.7.0.1
 */