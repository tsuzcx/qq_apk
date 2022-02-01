import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class ahwd
  extends ahvv
{
  boolean a;
  
  ahwd()
  {
    this.jdField_a_of_type_Boolean = false;
    a(new ahvl());
    a(new mzt());
  }
  
  private ahvd a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    ahvd localahvd = new ahvd();
    localahvd.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramBaseChatPie.app, paramPlusPanelAppInfo);
    localahvd.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localahvd.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localahvd.c = String.valueOf(paramPlusPanelAppInfo.getRedDotID());
    localahvd.e = paramPlusPanelAppInfo.actionType;
    localahvd.d = paramPlusPanelAppInfo.action;
    localahvd.jdField_a_of_type_JavaLangString = a(paramPlusPanelAppInfo);
    localahvd.jdField_b_of_type_JavaLangString = (localahvd.jdField_a_of_type_JavaLangString + anvx.a(2131707759));
    return localahvd;
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.getApp();
    if (localQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reloadFriend app is null");
      }
    }
    do
    {
      return;
      if (paramSessionInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PlusPanel", 2, "reloadFriend() sessionInfo is null");
    return;
    b(paramBaseChatPie);
    bdla.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
  }
  
  private ahvd b(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    ahvd localahvd = new ahvd();
    localahvd.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localahvd.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localahvd.e = paramPlusPanelAppInfo.actionType;
    localahvd.d = paramPlusPanelAppInfo.action;
    localahvd.jdField_a_of_type_JavaLangString = paramPlusPanelAppInfo.getTitle();
    localahvd.jdField_b_of_type_JavaLangString = (localahvd.jdField_a_of_type_JavaLangString + anvx.a(2131707759));
    if (paramPlusPanelAppInfo.getAppID() == 209)
    {
      localahvd.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ahqp.a(paramBaseChatPie.app).a();
      localahvd.jdField_a_of_type_JavaLangString = arbw.a().g();
      if (paramPlusPanelAppInfo.getAppID() != 204) {
        break label182;
      }
      if (!ShortVideoUtils.isHotPicConfiginitied) {
        ShortVideoUtils.isHotPicConfiginitied = true;
      }
    }
    for (;;)
    {
      localahvd.jdField_b_of_type_JavaLangString = (paramPlusPanelAppInfo.getTitle() + anvx.a(2131707767));
      return localahvd;
      localahvd.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(paramPlusPanelAppInfo.defaultDrawableID());
      break;
      label182:
      if (paramPlusPanelAppInfo.getAppID() == 209) {
        localahvd.jdField_a_of_type_Boolean = ahqp.a(paramBaseChatPie.app).b();
      } else {
        localahvd.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public ahvd a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return a(paramBaseChatPie, paramPlusPanelAppInfo);
    }
    return b(paramBaseChatPie, paramPlusPanelAppInfo);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a(paramBaseChatPie, paramBaseChatPie.sessionInfo);
    a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  abstract void b(BaseChatPie paramBaseChatPie);
  
  void c(int paramInt)
  {
    if (bdfk.b())
    {
      a(paramInt, 217);
      a(paramInt, 218);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwd
 * JD-Core Version:    0.7.0.1
 */