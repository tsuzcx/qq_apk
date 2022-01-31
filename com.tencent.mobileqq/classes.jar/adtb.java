import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

class adtb
  implements adtd
{
  adtb(adta paramadta) {}
  
  public void a(View paramView)
  {
    paramView = (adte)aciy.a(paramView);
    adta.jdField_a_of_type_JavaLangString = paramView.a.senderuin;
    Object localObject = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment();
    ajtv localajtv = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    if ((localObject != null) && (((ChatFragment)localObject).a() != null))
    {
      localObject = (aejb)((ChatFragment)localObject).a();
      ((acyg)((aejb)localObject).a(41)).b(1);
      localajtv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((aejb)localObject).a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, paramView.a);
    }
    new awrb(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_welcome").a(new String[] { paramView.a.frienduin, "", "" + azlj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.a.frienduin) }).a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击欢迎");
    }
    adta.c = 1;
  }
  
  public void b(View paramView)
  {
    paramView = (adte)aciy.a(paramView);
    adta.jdField_a_of_type_JavaLangString = paramView.a.senderuin;
    ajtv localajtv = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    Object localObject = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if ((localObject != null) && (((ChatFragment)localObject).a() != null))
    {
      localObject = (aejb)((ChatFragment)localObject).a();
      localajtv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((aejb)localObject).a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, paramView.a);
    }
    new awrb(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_play").a(new String[] { paramView.a.frienduin }).a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击撩一下");
    }
    adta.c = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adtb
 * JD-Core Version:    0.7.0.1
 */