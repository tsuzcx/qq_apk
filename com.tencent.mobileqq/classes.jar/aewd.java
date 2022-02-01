import Wallet.AcsMsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.1;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.2;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.3;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.4;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.5;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.6;
import com.tencent.mobileqq.activity.activateFriend.biz.entity.ReminderEntity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import mqq.manager.Manager;

public class aewd
  implements Manager
{
  private aewa jdField_a_of_type_Aewa;
  private aewm jdField_a_of_type_Aewm;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private volatile ConcurrentHashMap<String, ReminderEntity> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public aewd(AppInterface paramAppInterface)
  {
    a(paramAppInterface);
  }
  
  private int a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "delete expired reminder msg -> time: ", Long.valueOf(paramLong) });
    }
    AcsMsg localAcsMsg = new AcsMsg();
    localAcsMsg.notice_time = (paramLong - 1L);
    a(localAcsMsg, 3);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.delete(ReminderEntity.class.getSimpleName(), "mReminderTime < ?", new String[] { String.valueOf(paramLong) });
  }
  
  private List<ReminderEntity> a(long paramLong)
  {
    long l = Calendar.getInstance().getTimeZone().getRawOffset();
    return a("mReminderTime >= ? and mReminderTime < ?", new String[] { String.valueOf((paramLong - 86400000L) / 1000L), String.valueOf((paramLong - paramLong % 86400000L - l + 86400000L) / 1000L) }, "mReminderTime");
  }
  
  private List a(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ReminderEntity.class, ReminderEntity.class.getSimpleName(), false, paramString1, paramArrayOfString, null, null, paramString2, null);
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "updateTab size: ", Integer.valueOf(paramInt) });
    }
    if ((paramInt <= 0) && (((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().getMsgList(AppConstants.ACTIVATE_FRIENDS_UIN, 9002).size() <= 0))
    {
      anuz localanuz = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getProxyManager().a();
      RecentUser localRecentUser = (RecentUser)localanuz.findRecentUser(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
      if (localRecentUser != null)
      {
        localanuz.delRecentUser(localRecentUser);
        ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().setChangeAndNotify(localRecentUser);
      }
    }
  }
  
  private void a(AcsMsg paramAcsMsg, int paramInt)
  {
    if (((paramAcsMsg.type == 0) && (!aeuy.a(paramAcsMsg.notice_time * 1000L))) || ((paramAcsMsg.type == 1) && (paramAcsMsg.notice_time - NetConnInfoCenter.getServerTime() > 86400L))) {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "updateCache msg notice time is not today: ", Long.valueOf(paramAcsMsg.notice_time) });
      }
    }
    for (;;)
    {
      return;
      Object localObject1 = aevc.a(paramAcsMsg);
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (localObject1 == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderDataManagerNew", 1, new Object[] { "updateCache fail -> msgId: ", localObject1 });
        }
      }
      else
      {
        Object localObject2;
        switch (paramInt)
        {
        default: 
          return;
        case 0: 
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject1))
          {
            ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().removeMsgByUniseq(AppConstants.ACTIVATE_FRIENDS_UIN, 9002, ((String)localObject1).hashCode());
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
            return;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ReminderDataManagerNew", 1, new Object[] { "CACHE_DELETE: cache do not contain key: ", localObject1 });
            return;
          }
          break;
        case 1: 
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReminderDataManagerNew", 1, new Object[] { "CACHE_ADD: cache contain key: ", localObject1 });
            }
          }
          else
          {
            localObject2 = new ReminderEntity();
            ((ReminderEntity)localObject2).setAcsMsg(paramAcsMsg);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, localObject2);
            return;
          }
          break;
        case 2: 
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject1))
          {
            localObject1 = (ReminderEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
            if (localObject1 != null) {
              ((ReminderEntity)localObject1).setAcsMsg(paramAcsMsg);
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("ReminderDataManagerNew", 1, new Object[] { "CACHE_UPDATE: cache do not contain key: ", localObject1 });
            return;
          }
          break;
        case 3: 
          localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            if (((ReminderEntity)((Map.Entry)localObject2).getValue()).mReminderTime <= paramAcsMsg.notice_time) {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((Map.Entry)localObject2).getKey());
            }
          }
        }
      }
    }
  }
  
  private void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Aewa = ((aewa)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(321));
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramAppInterface.getApp().getSharedPreferences("pref_act_frd" + paramAppInterface.getCurrentAccountUin(), 0);
    c();
  }
  
  private void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManagerV2.excute(paramRunnable, 32, null, true);
      return;
    }
    paramRunnable.run();
  }
  
  private void a(boolean paramBoolean, aewi paramaewi)
  {
    try
    {
      str1 = aeuy.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
      if (QLog.isColorLevel()) {
        QLog.i("ReminderDataManagerNew", 2, "pullTodayMsgList currenDayTimeStapStr: " + str1);
      }
      str2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("sp_key_new_fetch_reminder_list_time", "");
      if (QLog.isColorLevel()) {
        QLog.i("ReminderDataManagerNew", 2, "pullTodayMsgList cacheCurrenDayTimeStapStr: " + str2);
      }
    }
    catch (Throwable paramaewi)
    {
      String str1;
      String str2;
      long l2;
      label153:
      QLog.e("ReminderDataManagerNew", 1, "checkTodayReminder throw an exception: " + paramaewi);
    }
    try
    {
      l2 = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()) % 3600L * 1000L;
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.i("ReminderDataManagerNew", 2, "pullTodayMsgList delay: " + l2);
        l1 = l2;
      }
    }
    catch (Exception localException)
    {
      l1 = 0L;
      break label153;
    }
    l2 = NetConnInfoCenter.getServerTimeMillis();
    l1 += aeuy.a(NetConnInfoCenter.getServerTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("ReminderDataManagerNew", 2, "pullTodayMsgList currentDelayTs: " + aeuy.a(l1, "yyyy-MM-dd HH:mm:ss"));
    }
    if ((!paramBoolean) && ((str1.equals(str2)) || (l2 < l1)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReminderDataManagerNew", 2, "already fetch today's data");
      }
    }
    else
    {
      a(str1, new aewe(this, str1, paramaewi));
      return;
    }
  }
  
  private boolean a(String paramString, @Nullable AcsMsg paramAcsMsg)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.delete(ReminderEntity.class.getSimpleName(), "mMsgId = ?", new String[] { paramString });
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "deleteReminderMsg msgId: ", paramString, " count: ", Integer.valueOf(j) });
    }
    if (j > 0) {}
    for (int i = 1;; i = 0)
    {
      if ((paramAcsMsg != null) && (i != 0) && (a(aevc.a(paramAcsMsg)))) {
        a(paramAcsMsg, 0);
      }
      if (j <= 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void b()
  {
    String str1 = aeuy.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
    String str2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("sp_key_cache_list_time", "");
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "cur: ", str1, " cache: ", str2 });
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      AcsMsg localAcsMsg = ((ReminderEntity)((Map.Entry)localObject3).getValue()).getAcsMsg();
      if (localAcsMsg.type == 0)
      {
        if (!aeuy.a(localAcsMsg.notice_time * 1000L)) {
          ((ArrayList)localObject1).add(((Map.Entry)localObject3).getKey());
        }
      }
      else if ((localAcsMsg.type == 1) && (l - localAcsMsg.notice_time > 86400L)) {
        ((ArrayList)localObject1).add(((Map.Entry)localObject3).getKey());
      }
    }
    localObject2 = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject3);
      ((QQMessageFacade)localObject2).removeMsgByUniseq(AppConstants.ACTIVATE_FRIENDS_UIN, 9002, ((String)localObject3).hashCode());
    }
    a(((QQMessageFacade)localObject2).getMsgList(AppConstants.ACTIVATE_FRIENDS_UIN, 9002).size());
    if (!str1.equals(str2))
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("sp_key_cache_list_time", aeuy.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd")).apply();
      if (Looper.myLooper() == Looper.getMainLooper()) {
        a(new ReminderDataManager.1(this));
      }
    }
    else
    {
      return;
    }
    a(NetConnInfoCenter.getServerTime() - 86400L);
  }
  
  private void b(String paramString1, String paramString2)
  {
    ReminderEntity localReminderEntity = (ReminderEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
    if (localReminderEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, "addToMsgTab, not found msgId");
      }
      c(paramString1, paramString2);
    }
    do
    {
      return;
      if ((localReminderEntity.getAcsMsg().type != 0) || (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString2 + ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getCurrentAccountUin(), false))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReminderDataManagerNew", 2, new Object[] { "msgId: ", paramString2, " have Reminded!" });
    return;
    if (localReminderEntity.getAcsMsg().type == 0) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(paramString2 + ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getCurrentAccountUin(), true).apply();
    }
    c(paramString1, paramString2);
  }
  
  private void b(List<AcsMsg> paramList)
  {
    Object localObject;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = (aewa)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(321);
      paramList = paramList.iterator();
    }
    label276:
    int i;
    int j;
    for (;;)
    {
      if (paramList.hasNext())
      {
        AcsMsg localAcsMsg = (AcsMsg)paramList.next();
        if (localAcsMsg.notice_time > NetConnInfoCenter.getServerTime())
        {
          if (localObject != null) {
            ((aewa)localObject).a(localAcsMsg);
          }
        }
        else
        {
          if ((this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(localAcsMsg.msg_id + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), false)) || (localAcsMsg.type == 1)) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReminderDataManagerNew", 2, " has notifaction: " + bool1 + " key: " + localAcsMsg.msg_id + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
            }
            boolean bool2 = ((aneo)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(85)).a(true);
            if (QLog.isColorLevel()) {
              QLog.d("ReminderDataManagerNew", 2, " isSettingOpen: " + bool2);
            }
            if ((bool1) || (!bool2)) {
              break label276;
            }
            a(localAcsMsg.title, aevc.a(localAcsMsg));
            break;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ReminderDataManagerNew", 2, "the msg " + localAcsMsg.title + " has notifaction!!!");
            continue;
            paramList = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().getMsgList(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
            i = paramList.size();
            j = i;
            if (paramList != null)
            {
              j = i;
              if (!paramList.isEmpty())
              {
                paramList = paramList.iterator();
                if (paramList.hasNext())
                {
                  localObject = (MessageRecord)paramList.next();
                  if (!(localObject instanceof MessageForText)) {
                    break label438;
                  }
                  localObject = (MessageForText)localObject;
                  ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().removeMsgByMessageRecord((MessageRecord)localObject, true);
                  i -= 1;
                }
              }
            }
          }
        }
      }
    }
    label438:
    for (;;)
    {
      break;
      j = i;
      a(j);
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(16);
    }
  }
  
  private void c(AcsMsg paramAcsMsg)
  {
    ReminderEntity localReminderEntity = new ReminderEntity();
    localReminderEntity.setAcsMsg(paramAcsMsg);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(localReminderEntity);
    if (!a(aevc.a(paramAcsMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "save Reminder Msg cache not contain, need save, msgId: ", paramAcsMsg.msg_id });
      }
      a(paramAcsMsg, 1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "save Reminder Msg cache contain, do not save, msgId: ", paramAcsMsg.msg_id });
    }
    a(paramAcsMsg, 2);
  }
  
  private void c(String paramString1, String paramString2)
  {
    MessageForText localMessageForText = new MessageForText();
    localMessageForText.selfuin = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getCurrentAccountUin();
    localMessageForText.frienduin = AppConstants.ACTIVATE_FRIENDS_UIN;
    localMessageForText.istroop = 9002;
    localMessageForText.senderuin = "";
    localMessageForText.time = NetConnInfoCenter.getServerTime();
    localMessageForText.msg = paramString1;
    localMessageForText.uniseq = paramString2.hashCode();
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 2, "---doNotifaction---" + paramString2 + ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getCurrentAccountUin() + "---uniseq: " + localMessageForText.uniseq);
    }
    paramString1 = new ArrayList();
    paramString1.add(localMessageForText);
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().addMessage(paramString1, ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getCurrentAccountUin(), ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).isBackgroundStop);
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).handleReceivedMessage(1, true, true);
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).refreshAppBadge();
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 2, "do report : QQnotice.list.show");
    }
    bcef.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.list.show", 0, 0, "", "", paramString2, "");
    MobileReportManager.getInstance().reportActionOfNotice("qqremind", "2", "1", 100, paramString2, "15", 1);
  }
  
  private void d(AcsMsg paramAcsMsg)
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (paramAcsMsg != null))
    {
      str = aevc.a(paramAcsMsg);
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "handleAlterDeleteFileOrException msgId: ", str });
      }
      if (this.jdField_a_of_type_Aewa == null) {
        this.jdField_a_of_type_Aewa = ((aewa)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(321));
      }
      if (this.jdField_a_of_type_Aewa == null) {
        break label168;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove(str + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).apply();
      this.jdField_a_of_type_Aewa.a(str.hashCode());
    }
    while ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      paramAcsMsg = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      paramAcsMsg.getMessageFacade().removeMsgByUniseq(AppConstants.ACTIVATE_FRIENDS_UIN, 9002, str.hashCode());
      paramAcsMsg.refreshAppBadge();
      return;
      label168:
      akfu.b(paramAcsMsg);
    }
    akfu.c(paramAcsMsg);
  }
  
  public ReminderEntity a(String paramString)
  {
    return (ReminderEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public List<AcsMsg> a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      b();
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      return null;
    }
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((ReminderEntity)((Iterator)localObject).next()).getAcsMsg());
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "getTodayReminderMsgFromCache, msg count: ", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      b();
    }
    List localList;
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      localList = a();
      b(localList);
    }
    for (;;)
    {
      if (localList == null) {
        a(new aewh(this));
      }
      a(false, null);
      return;
      localList = null;
    }
  }
  
  public void a(AcsMsg paramAcsMsg)
  {
    a(new ReminderDataManager.2(this, paramAcsMsg));
  }
  
  public void a(aewk paramaewk)
  {
    a(new ReminderDataManager.4(this, paramaewk));
  }
  
  public void a(aewk paramaewk, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, "getTodayReminderMsgAsync...");
    }
    a(new ReminderDataManager.5(this, paramBoolean, localArrayList, paramaewk));
  }
  
  public void a(aewm paramaewm)
  {
    this.jdField_a_of_type_Aewm = paramaewm;
  }
  
  public void a(String paramString, aewj paramaewj)
  {
    a(new ReminderDataManager.6(this, paramString, paramaewj));
  }
  
  public void a(String paramString, aewl paramaewl)
  {
    try
    {
      aewc.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, new aewg(this, paramaewl));
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ReminderDataManagerNew", 1, paramString, new Object[0]);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    boolean bool;
    do
    {
      try
      {
        bool = ((aneo)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(85)).a(true);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReminderDataManagerNew", 2, " isSettingOpen: " + bool);
      }
      catch (Throwable paramString1)
      {
        QLog.e("ReminderDataManagerNew", 1, "doNotifaction throw an exception: " + paramString1);
        return;
      }
      b(paramString1, paramString2);
      return;
    } while (bool);
  }
  
  public void a(List<AcsMsg> paramList)
  {
    a(new ReminderDataManager.3(this, paramList));
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    }
    return false;
  }
  
  public List<String> b()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet());
  }
  
  public void b(AcsMsg paramAcsMsg)
  {
    a(paramAcsMsg);
    if ((paramAcsMsg.type == 0) && (paramAcsMsg.notice_time > NetConnInfoCenter.getServerTime()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 2, "has not arrive noticetime, set AlarmMangaer first!");
      }
      aewa localaewa = (aewa)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(321);
      if (localaewa != null) {
        localaewa.a(paramAcsMsg);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 2, "has arrive noticetime, doNotifaction!");
    }
    if (paramAcsMsg.type == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 2, "[notify][push] multiple doNotifyByPush.");
      }
      if (this.jdField_a_of_type_Aewm != null) {
        this.jdField_a_of_type_Aewm.a(paramAcsMsg);
      }
    }
    a(paramAcsMsg.title, aevc.a(paramAcsMsg));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewd
 * JD-Core Version:    0.7.0.1
 */