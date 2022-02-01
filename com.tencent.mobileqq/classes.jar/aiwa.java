import android.content.res.Resources;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aiwa
  implements agvc
{
  private long jdField_a_of_type_Long;
  private aiwd jdField_a_of_type_Aiwd;
  private bdvn jdField_a_of_type_Bdvn = new aiwc(this);
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), new aiwb(this));
  
  public aiwa(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_Aiwd = new aiwd(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  private aiwd a()
  {
    if (this.jdField_a_of_type_Aiwd == null)
    {
      this.jdField_a_of_type_Aiwd = new aiwd(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().a(this.jdField_a_of_type_Aiwd);
      }
    }
    return this.jdField_a_of_type_Aiwd;
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.bF();
  }
  
  public String a(boolean paramBoolean)
  {
    int i = ((bdvj)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(362)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131718382, new Object[] { i + "" });
    if (paramBoolean) {
      str = anzj.a(2131693300);
    }
    return str;
  }
  
  public void a()
  {
    a();
    this.jdField_a_of_type_Aiwd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  public void a(int paramInt)
  {
    bdvj localbdvj = (bdvj)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().getManager(362);
    switch (paramInt)
    {
    default: 
    case 3: 
    case 2: 
      TroopManager localTroopManager;
      String str;
      do
      {
        return;
        localbdvj.a(this.jdField_a_of_type_Bdvn);
        return;
        localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      } while (localTroopManager.b(str) == null);
      localbdvj.a(str);
      return;
    }
    localbdvj.b(this.jdField_a_of_type_Bdvn);
  }
  
  public void a(aiwf paramaiwf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "onOtherTipsHide tip=" + paramaiwf);
    }
    if ((this.jdField_a_of_type_Aiwd != null) && (this.jdField_a_of_type_Aiwd != paramaiwf))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "onOtherTipsHide tip not equal StudyRoomTip");
      }
      b();
      c();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().a() != this.jdField_a_of_type_Aiwd) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "curTip is studyRoomTip");
    }
    return true;
  }
  
  public int[] a()
  {
    return new int[] { 3, 2, 13 };
  }
  
  public void b()
  {
    if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L) {
      return;
    }
    if (a()) {
      c();
    }
    for (;;)
    {
      c();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      b();
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "showStudyRoomTip");
    }
    if (!d()) {}
    aiwf localaiwf;
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a() != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null");
      return false;
      localaiwf = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().a();
      if ((localaiwf == null) || (localaiwf == this.jdField_a_of_type_Aiwd)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StudyRoomTipBarHelper", 2, "currTip is other");
    return false;
    if (localaiwf != null) {
      this.jdField_a_of_type_Aiwd.a();
    }
    for (;;)
    {
      c();
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().a(this.jdField_a_of_type_Aiwd, new Object[0]);
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_Aiwd == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null or studyRoomTips is null");
      }
    }
    aiwf localaiwf;
    do
    {
      return false;
      localaiwf = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().a();
    } while ((localaiwf == null) || (localaiwf != this.jdField_a_of_type_Aiwd));
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "currTip is studyRoomTips");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().a();
    c();
    return true;
  }
  
  public boolean d()
  {
    return ((bdvj)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(362)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwa
 * JD-Core Version:    0.7.0.1
 */