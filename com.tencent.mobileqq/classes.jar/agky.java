import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class agky
  implements agin
{
  public static long a;
  public static long b = 36000L;
  protected aoep a;
  private BaseChatPie a;
  protected String a;
  
  static
  {
    jdField_a_of_type_Long = 86400L;
  }
  
  public agky(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameNotifyUpdateHelper", 2, "setNotifyUpdateTime, troopUin = " + paramString + ", curTime = " + paramLong);
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = "SP_GAME_NOTIFY_UPDATE_" + paramQQAppInterface + "_" + paramString;
    localSharedPreferences.edit().putLong(paramQQAppInterface, paramLong).commit();
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    long l1;
    long l2;
    do
    {
      return false;
      SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      l1 = localSharedPreferences.getLong("SP_GAME_NOTIFY_UPDATE_" + paramQQAppInterface + "_" + paramString, 0L);
      l2 = NetConnInfoCenter.getServerTime();
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameNotifyUpdateHelper", 2, "hasNotifyUpdate, updateTime = " + l1 + ", curTime = " + l2);
      }
    } while ((l1 < b) || (l1 > l2) || ((l2 - b) / jdField_a_of_type_Long != (l1 - b) / jdField_a_of_type_Long));
    return true;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getMessageFacade().getLastMessage(paramString, 1);
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopGameNotifyUpdateHelper", 2, "checkSendMsgAfterTenClockToday, lastMsg is null");
    return false;
    long l2 = paramString.time;
    long l1 = (NetConnInfoCenter.getServerTime() - b) / jdField_a_of_type_Long;
    l2 = (l2 - b) / jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameNotifyUpdateHelper", 2, "checkSendMsgAfterTenClockToday, curDay = " + l1 + ", updateDay = " + l2);
    }
    if (l1 == l2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Aoep == null) {
      this.jdField_a_of_type_Aoep = ((aoep)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
    }
    if (this.jdField_a_of_type_Aoep != null)
    {
      this.jdField_a_of_type_Aoep.D(this.jdField_a_of_type_JavaLangString);
      long l = NetConnInfoCenter.getServerTime();
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_JavaLangString, l);
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameNotifyUpdateHelper", 2, "notifyUpdate, curTime = " + l);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    label7:
    Object localObject;
    do
    {
      do
      {
        do
        {
          break label7;
          do
          {
            return;
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo == null) || (bdvn.a()));
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
        } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
        localObject = (bgft)aqxe.a().a(695);
      } while ((localObject == null) || (!((bgft)localObject).a(this.jdField_a_of_type_JavaLangString)));
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
    } while ((localObject == null) || (((TroopInfo)localObject).isHomeworkTroop()) || (!((TroopInfo)localObject).isTroopGameCardEnabled()) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_JavaLangString)) || (a(this.jdField_a_of_type_JavaLangString)));
    b();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a();
  }
  
  public int[] a()
  {
    return new int[] { 8 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agky
 * JD-Core Version:    0.7.0.1
 */