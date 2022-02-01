import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class agkw
  implements agma
{
  private aiks jdField_a_of_type_Aiks;
  public FragmentActivity a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private mwq jdField_a_of_type_Mwq = new agkx(this);
  
  public agkw(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aiks != null) {
      this.jdField_a_of_type_Aiks.a();
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Mwq);
      return;
    case 5: 
      a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Mwq);
  }
  
  public void a(aimj paramaimj)
  {
    if (paramaimj == null) {
      return;
    }
    this.jdField_a_of_type_Aiks = new aiks(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramaimj, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    paramaimj.a(this.jdField_a_of_type_Aiks);
  }
  
  public void a(boolean paramBoolean)
  {
    mwd localmwd = (mwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
    if (localmwd != null)
    {
      boolean bool = localmwd.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (bool) {
        localmwd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0);
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
 * Qualified Name:     agkw
 * JD-Core Version:    0.7.0.1
 */