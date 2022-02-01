import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class ajku
  implements bkzq
{
  ajku(ajkt paramajkt, boolean paramBoolean, Friends paramFriends, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_Ajkt.a)) {
      QQToast.a(this.jdField_a_of_type_Ajkt.a, 1, 2131692125, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.e();
      return;
      paramView = (FriendListHandler)ajkt.a(this.jdField_a_of_type_Ajkt).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
        bdla.b(ajkt.a(this.jdField_a_of_type_Ajkt), "dc00898", "", "", "0X800808B", "0X800808B", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
        bdla.b(ajkt.a(this.jdField_a_of_type_Ajkt), "dc00898", "", "", "0X800808A", "0X800808A", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajku
 * JD-Core Version:    0.7.0.1
 */