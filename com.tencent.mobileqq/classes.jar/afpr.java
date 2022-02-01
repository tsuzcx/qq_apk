import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afpr
  implements afrc
{
  private ahow jdField_a_of_type_Ahow;
  public FragmentActivity a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private mya jdField_a_of_type_Mya = new afps(this);
  
  public afpr(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahow != null) {
      this.jdField_a_of_type_Ahow.a();
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Mya);
      return;
    case 5: 
      a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Mya);
  }
  
  public void a(ahqs paramahqs)
  {
    if (paramahqs == null) {
      return;
    }
    this.jdField_a_of_type_Ahow = new ahow(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramahqs, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    paramahqs.a(this.jdField_a_of_type_Ahow);
  }
  
  public void a(boolean paramBoolean)
  {
    mxn localmxn = (mxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
    if (localmxn != null)
    {
      boolean bool = localmxn.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      if (bool) {
        localmxn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 0, 1);
      }
      if ((QLog.isColorLevel()) && (paramBoolean)) {
        QLog.d("AVGameHelper", 2, "Enter AIO, troopUin :" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin + "isAVGameOpen is: " + bool);
      }
    }
  }
  
  public int[] a()
  {
    return new int[] { 3, 5, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpr
 * JD-Core Version:    0.7.0.1
 */