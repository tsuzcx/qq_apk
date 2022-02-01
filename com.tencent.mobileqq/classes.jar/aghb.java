import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class aghb
  implements agin
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aghb(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext instanceof Activity)) {
      annj.a(false, (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, new aghc(this));
    }
    ((amma)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter);
    anhn.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    ((amma)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a(1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 14: 
    default: 
      return;
    }
    a();
  }
  
  public int[] a()
  {
    return new int[] { 14, 8 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghb
 * JD-Core Version:    0.7.0.1
 */