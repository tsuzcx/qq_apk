import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class aggv
  implements agin
{
  private aijr jdField_a_of_type_Aijr;
  public FragmentActivity a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ndm jdField_a_of_type_Ndm = new aggw(this);
  
  public aggv(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aijr != null) {
      this.jdField_a_of_type_Aijr.a();
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ndm);
      return;
    case 6: 
      a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ndm);
  }
  
  public void a(ailr paramailr)
  {
    if (paramailr == null) {
      return;
    }
    this.jdField_a_of_type_Aijr = new aijr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramailr, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    paramailr.a(this.jdField_a_of_type_Aijr);
  }
  
  public void a(boolean paramBoolean)
  {
    ncz localncz = (ncz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localncz != null)
    {
      boolean bool = localncz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      if (bool) {
        localncz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 0, 1);
      }
      if ((QLog.isColorLevel()) && (paramBoolean)) {
        QLog.d("AVGameHelper", 2, "Enter AIO, troopUin :" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin + "isAVGameOpen is: " + bool);
      }
    }
  }
  
  public int[] a()
  {
    return new int[] { 4, 6, 14 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggv
 * JD-Core Version:    0.7.0.1
 */