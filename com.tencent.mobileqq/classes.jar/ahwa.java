import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

class ahwa
  implements ahwc
{
  ahwa(ahvz paramahvz) {}
  
  public void a(View paramView)
  {
    paramView = (ahwd)agej.a(paramView);
    ahvz.jdField_a_of_type_JavaLangString = paramView.a.senderuin;
    Object localObject = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment();
    aojl localaojl = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    if ((localObject != null) && (((ChatFragment)localObject).a() != null))
    {
      localObject = (TroopChatPie)((ChatFragment)localObject).a();
      ((agwm)((TroopChatPie)localObject).a(41)).b(1);
      localaojl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((TroopChatPie)localObject).a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, paramView.a);
    }
    new bdlq(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_welcome").a(new String[] { paramView.a.frienduin, "", "" + bguq.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.a.frienduin) }).a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击欢迎");
    }
    ahvz.c = 1;
  }
  
  public void b(View paramView)
  {
    paramView = (ahwd)agej.a(paramView);
    ahvz.jdField_a_of_type_JavaLangString = paramView.a.senderuin;
    aojl localaojl = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    Object localObject = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if ((localObject != null) && (((ChatFragment)localObject).a() != null))
    {
      localObject = (TroopChatPie)((ChatFragment)localObject).a();
      localaojl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((TroopChatPie)localObject).a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, paramView.a);
    }
    new bdlq(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_play").a(new String[] { paramView.a.frienduin }).a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击撩一下");
    }
    ahvz.c = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwa
 * JD-Core Version:    0.7.0.1
 */