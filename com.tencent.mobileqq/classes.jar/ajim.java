import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class ajim
  implements bkzq
{
  ajim(ajik paramajik, boolean paramBoolean, Friends paramFriends, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(ajik.a(this.jdField_a_of_type_Ajik))) {
      QQToast.a(ajik.a(this.jdField_a_of_type_Ajik), 1, 2131692125, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.e();
      return;
      paramView = (FriendListHandler)ajik.a(this.jdField_a_of_type_Ajik).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (this.jdField_a_of_type_Boolean) {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
      } else {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajim
 * JD-Core Version:    0.7.0.1
 */