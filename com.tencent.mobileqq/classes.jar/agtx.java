import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class agtx
  implements agvc
{
  private aiul jdField_a_of_type_Aiul;
  public FragmentActivity a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private mxp jdField_a_of_type_Mxp = new agty(this);
  
  public agtx(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aiul != null) {
      this.jdField_a_of_type_Aiul.a();
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Mxp);
      return;
    case 5: 
      a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Mxp);
  }
  
  public void a(aiwh paramaiwh)
  {
    if (paramaiwh == null) {
      return;
    }
    this.jdField_a_of_type_Aiul = new aiul(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramaiwh, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    paramaiwh.a(this.jdField_a_of_type_Aiul);
  }
  
  public void a(boolean paramBoolean)
  {
    mxc localmxc = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
    if (localmxc != null)
    {
      boolean bool = localmxc.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (bool) {
        localmxc.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, 1);
      }
      if ((QLog.isColorLevel()) && (paramBoolean)) {
        QLog.d("AVGameHelper", 2, "Enter AIO, troopUin :" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + "isAVGameOpen is: " + bool);
      }
    }
  }
  
  public int[] a()
  {
    return new int[] { 3, 5, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtx
 * JD-Core Version:    0.7.0.1
 */