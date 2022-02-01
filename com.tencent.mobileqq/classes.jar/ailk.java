import android.content.res.Resources;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ailk
  implements agin
{
  private long jdField_a_of_type_Long;
  private ailn jdField_a_of_type_Ailn;
  private bdwd jdField_a_of_type_Bdwd = new ailm(this);
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), new aill(this));
  
  public ailk(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_Ailn = new ailn(paramTroopChatPie.app, paramTroopChatPie.mActivity);
  }
  
  private ailn a()
  {
    if (this.jdField_a_of_type_Ailn == null)
    {
      this.jdField_a_of_type_Ailn = new ailn(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a(this.jdField_a_of_type_Ailn);
      }
    }
    return this.jdField_a_of_type_Ailn;
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.v();
  }
  
  public String a(boolean paramBoolean)
  {
    int i = ((bdvz)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mActivity.getResources().getString(2131719019, new Object[] { i + "" });
    if (paramBoolean) {
      str = anvx.a(2131693576);
    }
    return str;
  }
  
  public void a()
  {
    a();
    this.jdField_a_of_type_Ailn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin);
  }
  
  public void a(int paramInt)
  {
    bdvz localbdvz = (bdvz)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getApp().getManager(QQManagerFactory.STUDY_ROOM_MANAGER);
    switch (paramInt)
    {
    default: 
    case 4: 
    case 3: 
      TroopManager localTroopManager;
      String str;
      do
      {
        return;
        localbdvz.a(this.jdField_a_of_type_Bdwd);
        return;
        localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER);
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin;
      } while (localTroopManager.b(str) == null);
      localbdvz.a(str);
      return;
    }
    localbdvz.b(this.jdField_a_of_type_Bdwd);
  }
  
  public void a(ailp paramailp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "onOtherTipsHide tip=" + paramailp);
    }
    if ((this.jdField_a_of_type_Ailn != null) && (this.jdField_a_of_type_Ailn != paramailp))
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a() != this.jdField_a_of_type_Ailn) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "curTip is studyRoomTip");
    }
    return true;
  }
  
  public int[] a()
  {
    return new int[] { 4, 3, 14 };
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
    ailp localailp;
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null");
      return false;
      localailp = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a();
      if ((localailp == null) || (localailp == this.jdField_a_of_type_Ailn)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StudyRoomTipBarHelper", 2, "currTip is other");
    return false;
    if (localailp != null) {
      this.jdField_a_of_type_Ailn.a();
    }
    for (;;)
    {
      c();
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a(this.jdField_a_of_type_Ailn, new Object[0]);
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_Ailn == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null or studyRoomTips is null");
      }
    }
    ailp localailp;
    do
    {
      return false;
      localailp = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a();
    } while ((localailp == null) || (localailp != this.jdField_a_of_type_Ailn));
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "currTip is studyRoomTips");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a();
    c();
    return true;
  }
  
  public boolean d()
  {
    return ((bdvz)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailk
 * JD-Core Version:    0.7.0.1
 */