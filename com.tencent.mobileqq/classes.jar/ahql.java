import android.content.res.Resources;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ahql
  implements afrc
{
  private long jdField_a_of_type_Long;
  private ahqo jdField_a_of_type_Ahqo;
  private bcpe jdField_a_of_type_Bcpe = new ahqn(this);
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bjmp(Looper.getMainLooper(), new ahqm(this));
  
  public ahql(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_Ahqo = new ahqo(paramTroopChatPie.app, paramTroopChatPie.mActivity);
  }
  
  private ahqo a()
  {
    if (this.jdField_a_of_type_Ahqo == null)
    {
      this.jdField_a_of_type_Ahqo = new ahqo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a(this.jdField_a_of_type_Ahqo);
      }
    }
    return this.jdField_a_of_type_Ahqo;
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.s();
  }
  
  public String a(boolean paramBoolean)
  {
    int i = ((bcpa)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getManager(362)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mActivity.getResources().getString(2131718630, new Object[] { i + "" });
    if (paramBoolean) {
      str = amtj.a(2131693395);
    }
    return str;
  }
  
  public void a()
  {
    a();
    this.jdField_a_of_type_Ahqo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin);
  }
  
  public void a(int paramInt)
  {
    bcpa localbcpa = (bcpa)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getApp().getManager(362);
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
        localbcpa.a(this.jdField_a_of_type_Bcpe);
        return;
        localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getManager(52);
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin;
      } while (localTroopManager.b(str) == null);
      localbcpa.a(str);
      return;
    }
    localbcpa.b(this.jdField_a_of_type_Bcpe);
  }
  
  public void a(ahqq paramahqq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "onOtherTipsHide tip=" + paramahqq);
    }
    if ((this.jdField_a_of_type_Ahqo != null) && (this.jdField_a_of_type_Ahqo != paramahqq))
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
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a() != this.jdField_a_of_type_Ahqo) {
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
    ahqq localahqq;
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
      localahqq = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a();
      if ((localahqq == null) || (localahqq == this.jdField_a_of_type_Ahqo)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StudyRoomTipBarHelper", 2, "currTip is other");
    return false;
    if (localahqq != null) {
      this.jdField_a_of_type_Ahqo.a();
    }
    for (;;)
    {
      c();
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a(this.jdField_a_of_type_Ahqo, new Object[0]);
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_Ahqo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null or studyRoomTips is null");
      }
    }
    ahqq localahqq;
    do
    {
      return false;
      localahqq = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a();
    } while ((localahqq == null) || (localahqq != this.jdField_a_of_type_Ahqo));
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "currTip is studyRoomTips");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a();
    c();
    return true;
  }
  
  public boolean d()
  {
    return ((bcpa)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getManager(362)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahql
 * JD-Core Version:    0.7.0.1
 */