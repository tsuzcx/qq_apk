import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade.1;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleChatBoxHelper;
import cooperation.qqcircle.chat.QCircleHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class acmw
  extends Observable
  implements Manager
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private Set<String> b;
  
  public acmw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a(ConfessConvInfo paramConfessConvInfo)
  {
    if (paramConfessConvInfo == null) {
      return 0;
    }
    return paramConfessConvInfo.unreadCount;
  }
  
  public static int a(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    paramConversationInfo = a(paramConversationInfo);
    return Math.max(paramConversationInfo.unreadCount, paramConversationInfo.unreadMark);
  }
  
  private int a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord.time <= paramLong) {}
    do
    {
      return 0;
      paramMessageRecord = a(paramMessageRecord.istroop).b(paramMessageRecord.senderuin, paramMessageRecord.istroop);
    } while (paramMessageRecord == null);
    paramMessageRecord = paramMessageRecord.iterator();
    int i = 0;
    if (paramMessageRecord.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.next();
      if ((localMessageRecord.time <= paramLong) || (localMessageRecord.isread)) {
        break label95;
      }
      i += 1;
    }
    label95:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private acmx a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
  }
  
  private acnf a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt);
  }
  
  private static SharedPreferences a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 1001) {}
    for (String str = "sp_nearby_summary_" + paramQQAppInterface.getCurrentAccountUin(); !TextUtils.isEmpty(str); str = "") {
      return BaseApplicationImpl.sApplication.getSharedPreferences("sp_nearby_summary_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    }
    return null;
  }
  
  private aqvm a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
  }
  
  private QQMessageFacade a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
  }
  
  private static ConversationInfo a(ConversationInfo paramConversationInfo)
  {
    Object localObject = paramConversationInfo;
    if (TextUtils.equals(paramConversationInfo.uin, AppConstants.FILTER_MSG_UIN))
    {
      paramConversationInfo = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = a(paramConversationInfo.getConversationFacade().a(), paramConversationInfo);
      paramConversationInfo = new ConversationInfo();
      Iterator localIterator = ((List)localObject).iterator();
      for (;;)
      {
        localObject = paramConversationInfo;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (ConversationInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "onGetUnreadCount() called with: info = [" + localObject + "]");
        }
        if (((ConversationInfo)localObject).type == 7000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.unread.Facade", 2, "onGetUnreadCount() called skip UIN_TYPE_SUBACCOUNT_ASSISTANT ");
          }
        }
        else
        {
          paramConversationInfo.unreadCount += ((ConversationInfo)localObject).unreadCount;
          int i = paramConversationInfo.unreadMark;
          paramConversationInfo.unreadMark = (((ConversationInfo)localObject).unreadMark + i);
        }
      }
    }
    return localObject;
  }
  
  private static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "lastuin";; str = "sm") {
      return String.format("%s_%s_%s", new Object[] { str, paramString, Integer.valueOf(paramInt) });
    }
  }
  
  @NonNull
  private static List<ConversationInfo> a(Set<ConversationInfo> paramSet, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    paramQQAppInterface = (almg)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)paramSet.next();
      if (paramQQAppInterface.a(localConversationInfo.uin, localConversationInfo.type)) {
        localArrayList.add(localConversationInfo);
      }
    }
    return localArrayList;
  }
  
  private Set<String> a(int paramInt)
  {
    if (paramInt == 1010)
    {
      if (this.jdField_a_of_type_JavaUtilSet == null) {
        this.jdField_a_of_type_JavaUtilSet = a(AppConstants.DATE_SAY_HELLO_LIST_UIN, paramInt, "date_box_last_read_time");
      }
      return this.jdField_a_of_type_JavaUtilSet;
    }
    if (paramInt == 1001)
    {
      if (this.b == null) {
        this.b = a(AppConstants.LBS_SAY_HELLO_LIST_UIN, paramInt, "lbs_box_last_read_time");
      }
      return this.b;
    }
    return null;
  }
  
  private Set<String> a(String paramString1, int paramInt, String paramString2)
  {
    long l1 = 0L;
    if (QLog.isColorLevel())
    {
      l1 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 2, "initSayHelloSet,boxType:" + paramInt + ",startTime:" + l1);
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    HashSet localHashSet = new HashSet();
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(paramString1, paramInt);
    long l2 = localSharedPreferences.getLong(paramString2, 0L);
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (MessageRecord)paramString1.next();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg_box", 4, "lastTime:" + l2 + ",mr.time:" + paramString2.time + ",uin:" + paramString2.senderuin + ",istroop:" + paramString2.istroop);
      }
      if ((a(paramString2.senderuin, paramInt) > 0) && (paramString2.time > l2)) {
        localHashSet.add(paramString2.senderuin);
      }
    }
    if (QLog.isColorLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 2, "initSayHelloSet,endTime:" + l2 + ",costTime:" + (l2 - l1));
    }
    return localHashSet;
  }
  
  private void a(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo != null) {}
    try
    {
      if ((("2747277822".equals(paramConversationInfo.uin)) || (10007 == paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        paramConversationInfo = (avds)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
        if (paramConversationInfo != null) {
          paramConversationInfo.c(0);
        }
      }
      return;
    }
    catch (Exception paramConversationInfo)
    {
      bdjw.a(paramConversationInfo);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3000) || (paramInt == 1);
  }
  
  private boolean a(MessageRecord paramMessageRecord, Set<MessageRecord> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return false;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (acnh.a(paramMessageRecord, (MessageRecord)paramSet.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static int b(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.extInt2;
  }
  
  public static int c(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.unreadCount;
  }
  
  public static int d(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.unreadMark;
  }
  
  private void d()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).a().b();
      if ((localConcurrentHashMap.get(acnh.a(AppConstants.LBS_HELLO_UIN, 1001)) != null) || (localConcurrentHashMap.get(acnh.a(AppConstants.SAME_STATE_BOX_UIN, 1009)) != null) || (localConcurrentHashMap.get(acnh.a(AppConstants.DATE_UIN, 1010)) != null) || (localConcurrentHashMap.get(acnh.a(AppConstants.CONFESS_UIN, 1032)) != null) || (localConcurrentHashMap.get(acnh.a(AppConstants.NEARBY_LBS_HELLO_UIN, 1001)) != null) || (localConcurrentHashMap.get(acnh.a(AppConstants.MATCH_CHAT_UIN, 1044)) != null) || (localConcurrentHashMap.get(acnh.a(AppConstants.QCIRCLE_CHAT_UIN, 10008)) != null)) {
        ThreadManager.post(new ConversationFacade.1(this), 8, null, false);
      }
      return;
    }
    e();
  }
  
  private void e()
  {
    b(AppConstants.NEARBY_LBS_HELLO_UIN, 1001);
    b(AppConstants.LBS_HELLO_UIN, 1001);
    b(AppConstants.SAME_STATE_BOX_UIN, 1009);
    b(AppConstants.DATE_UIN, 1010);
    b(AppConstants.CONFESS_UIN, 1032);
    b(AppConstants.MATCH_CHAT_UIN, 1044);
    b(AppConstants.QCIRCLE_CHAT_UIN, 10008);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("sp_key_sayhello_box_unread_count", 0);
  }
  
  public int a(int paramInt)
  {
    Set localSet = a(paramInt);
    int i = 0;
    if (localSet != null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      i = localSet.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_box", 2, "getUnreadSayHelloNum,boxType:" + paramInt + ",num:" + i);
      }
      return i;
    }
  }
  
  public int a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!paramMessageRecord.isSend()) && (!paramMessageRecord.isread) && (paramMessageRecord.msgtype == -2038)) {
      return 1;
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt)
  {
    return a(a().a(paramString, paramInt));
  }
  
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    return a(a().a(paramString, paramInt1, paramInt2));
  }
  
  public long a(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public ConversationInfo a(String paramString, int paramInt)
  {
    try
    {
      paramString = a().a(paramString, paramInt);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!acnh.w(paramInt1))) {}
    for (;;)
    {
      return paramString2;
      SharedPreferences localSharedPreferences = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1);
      String str;
      if ((paramInt1 == 1001) || (paramInt1 == 10002))
      {
        if ((paramInt2 < 0) || (paramInt2 > 0)) {
          continue;
        }
        if (AppConstants.LBS_HELLO_UIN.equals(paramString1))
        {
          paramString1 = localSharedPreferences.getString(a(AppConstants.LBS_HELLO_UIN, paramInt2, true), "");
          str = paramString1;
          if (AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString1)) {
            str = localSharedPreferences.getString(a(AppConstants.LBS_SAY_HELLO_LIST_UIN, paramInt2, true), "");
          }
        }
      }
      while (!TextUtils.isEmpty(str))
      {
        return SecurityUtile.decode(localSharedPreferences.getString(a(str, paramInt2, false), paramString2));
        str = paramString1;
        if (AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString1))
        {
          str = localSharedPreferences.getString(a(AppConstants.LBS_SAY_HELLO_LIST_UIN, paramInt2, true), "");
          continue;
          str = null;
        }
      }
    }
  }
  
  public Set<ConversationInfo> a()
  {
    return a().a();
  }
  
  public void a()
  {
    a().c();
    a().c();
    Object localObject2 = a().a();
    Object localObject1 = new HashSet();
    localObject2 = ((Set)localObject2).iterator();
    label297:
    while (((Iterator)localObject2).hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject2).next();
      if (b(localConversationInfo.uin, localConversationInfo.type))
      {
        if (acnh.b(localConversationInfo.uin, localConversationInfo.type)) {
          b(localConversationInfo.uin, localConversationInfo.type);
        }
        if ((QLog.isColorLevel()) && ((a(localConversationInfo) != 0) || (localConversationInfo.unreadGiftCount != 0) || (localConversationInfo.extInt1 != 0))) {
          QLog.d("Q.unread.Facade", 2, "initCache info=" + localConversationInfo.toString());
        }
      }
      for (;;)
      {
        if ((a(localConversationInfo) != 0) || ((localConversationInfo.unreadGiftCount == 0) && (localConversationInfo.extInt1 == 0))) {
          break label297;
        }
        a(localConversationInfo.uin, localConversationInfo.unreadGiftCount, false);
        break;
        if ((acnh.t(localConversationInfo.type)) && (!acnh.b(localConversationInfo.uin, localConversationInfo.type)) && (!a(localConversationInfo.uin, acnh.a(localConversationInfo.type)))) {
          ((Set)localObject1).add(localConversationInfo);
        }
        if ((QLog.isColorLevel()) && ((a(localConversationInfo) != 0) || (localConversationInfo.unreadGiftCount != 0) || (localConversationInfo.extInt1 != 0))) {
          QLog.d("Q.unread.Facade", 2, "initCache [not in recent] info=" + localConversationInfo.toString());
        }
      }
    }
    if (!((Set)localObject1).isEmpty())
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConversationInfo)((Iterator)localObject1).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "initCache remove info=" + ((ConversationInfo)localObject2).toString());
        }
        a().c(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
      }
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    Set localSet = a(paramInt);
    if (localSet == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localSet.clear();
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
        if (paramInt == 1010)
        {
          ((SharedPreferences)???).edit().putLong("date_box_last_read_time", paramLong).commit();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg_box", 2, "clearNewSayHelloSet,boxType:" + paramInt + ",time:" + paramLong);
          return;
        }
      }
      if (paramInt == 1001) {
        ((SharedPreferences)???).edit().putLong("lbs_box_last_read_time", paramLong).commit();
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Set localSet = a(paramInt);
    if ((localSet == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!localSet.contains(paramString)) {
        localSet.add(paramString);
      }
      return;
    }
  }
  
  public void a(ConversationInfo paramConversationInfo, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg_box", 2, "updateSummaryLastUin info = " + paramConversationInfo + ", lbsHongbaoLastUin = " + paramString);
    }
    if ((paramConversationInfo == null) || (!acnh.w(paramConversationInfo.type)) || (TextUtils.isEmpty(paramConversationInfo.uin))) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localEditor = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConversationInfo.type).edit();
      if ((paramConversationInfo.type != 1001) && (paramConversationInfo.type != 10002)) {
        break;
      }
    } while ((!AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramConversationInfo.uin)) && (!AppConstants.LBS_HELLO_UIN.equals(paramConversationInfo.uin)));
    if ((paramConversationInfo.extInt1 <= 0) || (TextUtils.isEmpty(paramString))) {
      localEditor.remove(a(paramConversationInfo.uin, 0, true));
    }
    for (;;)
    {
      i = 1;
      if (i == 0) {
        break;
      }
      localEditor.commit();
      return;
      localEditor.putString(a(paramConversationInfo.uin, 0, true), paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, true);
    a().c(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a().b(paramString, paramInt1, paramInt2);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 != 1033) && (paramInt1 != 1034))
    {
      a(paramString, paramInt1, a().a(paramString, paramInt1), paramBoolean);
      return;
    }
    a(paramString, paramInt1, a().a(paramString, paramInt1, paramInt2), true, paramBoolean, paramInt2);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanUnreadFrom uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
    }
    if (paramInt == 1008) {}
    for (boolean bool1 = uot.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);; bool1 = false)
    {
      if ((paramInt == 1008) && (uqx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) && (!bool1)) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "isTroopBarAccount");
        }
      }
      do
      {
        return;
        if ((paramInt != 1008) || (!TextUtils.equals(paramString, AppConstants.NEW_KANDIAN_UIN))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.unread.Facade", 2, "NEW_KANDIAN_UIN not unread");
      return;
      b(paramString, paramInt, paramLong);
      a(paramInt).a(paramString, paramInt, paramLong);
      if ((paramInt == 1008) && (bool1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "inServiceAccountFolder uin=" + paramString);
        }
        uot.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshAppBadge();
      OpenApiManager localOpenApiManager = OpenApiManager.getInstance();
      bool1 = bool2;
      if (a(paramString, paramInt) == 0) {
        bool1 = true;
      }
      localOpenApiManager.onMessageReaded(paramString, paramInt, bool1, paramLong);
      return;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramInt, paramLong, true, paramBoolean);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramInt, paramLong, paramBoolean1, paramBoolean2, 0);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    long l;
    if ((paramInt1 != 1033) && (paramInt1 != 1034))
    {
      l = a().b(paramString, paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "cleanUnread uin=" + paramString + ",type" + paramInt1 + ",unread" + l + " ,lastread" + paramLong + ",needDelMark" + paramBoolean2);
      }
      if (paramBoolean2) {
        a().b(paramString, paramInt1, 0);
      }
      a().a(paramString, paramInt1, paramLong, 0, 0, 0);
    }
    for (paramLong = l;; paramLong = l)
    {
      if (paramLong > 0L)
      {
        if ((acnh.d(paramInt1)) && (paramBoolean1)) {
          d();
        }
        QQMessageFacade.Message localMessage = a().getLastMessage(paramString, paramInt1, paramInt2);
        if (localMessage != null) {
          a(paramInt1).a(paramString, paramInt1, localMessage, paramInt2);
        }
      }
      OpenApiManager.getInstance().onMessageReaded(paramString, paramInt1, true, 0L);
      return;
      l = a().a(paramString, paramInt1, paramInt2);
      a().a(paramString, paramInt1, paramInt2, paramLong, 0);
    }
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int j = 0;
    int i;
    if (paramMessageRecord != null)
    {
      i = a(paramMessageRecord) * -1;
      j = b(paramMessageRecord) * -1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt + ",unreadDiff" + -1 + ",unreadGiftDiff=" + i + ",unreadRedPacketDiff=" + j + ",mr=" + paramMessageRecord);
      }
      a().a(paramString, paramInt, -1, i, j);
      if (acnh.d(paramInt)) {
        d();
      }
      return;
      i = 0;
    }
  }
  
  @Deprecated
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramInt2 = a().b(paramString2, paramInt2);
    int i = a().b(paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "moveBoxToMessageTab innerItemUnread=" + paramInt2 + ", convsItemUnread=" + i);
    }
    b(paramString1, paramInt1);
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    int i = 0;
    Iterator localIterator = paramList.iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      int n = a(localMessageRecord) * -1;
      int i1 = b(localMessageRecord) * -1;
      if (localMessageRecord != null)
      {
        int k = j + n;
        int m = i + i1;
        j = k;
        i = m;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt + ",unreadDiff" + -1 + ",unreadGiftDiff=" + n + ",unreadRedPacketDiff=" + i1 + ",mr=" + localMessageRecord);
          j = k;
          i = m;
        }
      }
    }
    a().a(paramString, paramInt, paramList.size(), j, i);
    if (acnh.d(paramInt)) {
      d();
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    a(paramString, paramInt, 0, paramBoolean);
  }
  
  public void a(List<MessageRecord> paramList)
  {
    HashSet localHashSet = null;
    int i;
    MessageRecord localMessageRecord;
    Object localObject;
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "addUnread msg size=" + paramList.size());
      }
      Iterator localIterator = paramList.iterator();
      for (i = 0;; i = 1) {
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localMessageRecord = (MessageRecord)localIterator.next();
            if ((localMessageRecord.isSendFromLocal()) || (localMessageRecord.isread)) {
              break label1280;
            }
            if ((localMessageRecord.msgtype != -2006) || (!(localMessageRecord instanceof MessageForFoldMsg)))
            {
              if (!localMessageRecord.isLongMsg()) {
                break label1277;
              }
              localObject = acnh.b(localMessageRecord);
              if (localHashSet != null) {
                break label1274;
              }
              localHashSet = new HashSet();
              label140:
              if (acnh.c(localMessageRecord))
              {
                if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(localMessageRecord)) || (localHashSet.contains(localObject))) {
                  continue;
                }
                localHashSet.add(localObject);
                label191:
                if ((1001 != localMessageRecord.istroop) && (10002 != localMessageRecord.istroop)) {
                  break label409;
                }
                if (localMessageRecord.msgtype != -2055) {
                  break label291;
                }
                localObject = (MessageForInteractAndFollow)localMessageRecord;
                c(localMessageRecord.senderuin, localMessageRecord.istroop, ((MessageForInteractAndFollow)localObject).unReadCount);
                label250:
                if (!acnh.d(localMessageRecord.istroop)) {
                  break label1268;
                }
              }
            }
          }
        }
      }
    }
    label1280:
    for (;;)
    {
      break;
      if (localHashSet.contains(localObject)) {
        localHashSet.remove(localObject);
      }
      break label191;
      label291:
      if (localMessageRecord.msgtype == -2053)
      {
        if (!((MessageForNearbyLiveTip)localMessageRecord).isLiving) {
          break label1271;
        }
        if (a(localMessageRecord.frienduin, localMessageRecord.msgtype) > 0) {
          break;
        }
      }
      if (AppConstants.LBS_HELLO_UIN.equals(localMessageRecord.frienduin))
      {
        a().a(localMessageRecord.senderuin, 1001, 1, a(localMessageRecord), b(localMessageRecord));
        break label250;
      }
      a().a(localMessageRecord.frienduin, 1001, 1, a(localMessageRecord), b(localMessageRecord));
      break label250;
      label409:
      if (1009 == localMessageRecord.istroop)
      {
        a().a(localMessageRecord.frienduin, 1009, 1, a(localMessageRecord), b(localMessageRecord));
        break label250;
      }
      if ((1033 == localMessageRecord.istroop) || (1034 == localMessageRecord.istroop))
      {
        a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getConfessTopicId(), 1);
        aqvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, true);
        break label250;
      }
      if (1008 == localMessageRecord.istroop)
      {
        if ("1".equals(localMessageRecord.getExtInfoFromExtStr("public_account_msg_unread_flag")))
        {
          a().b(localMessageRecord.frienduin, localMessageRecord.istroop);
          break label250;
        }
        if ((AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(localMessageRecord.frienduin)) || (AppConstants.KANDIAN_DAILY_UIN.equals(localMessageRecord.frienduin))) {
          a().a(localMessageRecord.frienduin, localMessageRecord.istroop);
        }
        a().a(localMessageRecord.frienduin, localMessageRecord.istroop, 1, a(localMessageRecord), b(localMessageRecord));
        break label250;
      }
      if (1044 == acnh.a(localMessageRecord.istroop))
      {
        a().a(localMessageRecord.frienduin, localMessageRecord.istroop, 1, a(localMessageRecord), b(localMessageRecord));
        ((aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a();
        break label250;
      }
      if (10008 == acnh.a(localMessageRecord.istroop))
      {
        a().a(localMessageRecord.frienduin, localMessageRecord.istroop, 1, a(localMessageRecord), b(localMessageRecord));
        QCircleChatBoxHelper.getInstance().insertUnReadMessage(localMessageRecord.frienduin);
        ((QCircleHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QCIRCLE_HANDLER)).updateRedPoint();
        break label250;
      }
      localObject = a().a(localMessageRecord.frienduin, localMessageRecord.istroop);
      if ((localObject != null) && (((ConversationInfo)localObject).type == 1037) && (localMessageRecord.istroop != 1037))
      {
        a(localMessageRecord.frienduin, 1037);
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "addUnread, remove old ConversationInfo,  uin=" + localMessageRecord.frienduin + ",new type" + localMessageRecord.istroop);
        }
      }
      if ((localObject != null) && (((ConversationInfo)localObject).type == 1044) && (localMessageRecord.istroop != 1044))
      {
        a(localMessageRecord.frienduin, 1044);
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "addUnread, remove old ConversationInfo,  uin=" + localMessageRecord.frienduin + ",new type" + localMessageRecord.istroop);
        }
      }
      if ((localObject != null) && (((ConversationInfo)localObject).type == 10008) && (localMessageRecord.istroop != 10008))
      {
        a(localMessageRecord.frienduin, 10008);
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "addUnread, remove old ConversationInfo,  uin=" + localMessageRecord.frienduin + ",new type" + localMessageRecord.istroop);
        }
      }
      if ((localObject != null) && (((ConversationInfo)localObject).type == 1045) && (localMessageRecord.istroop != 1045))
      {
        a(localMessageRecord.frienduin, 1045);
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "addUnread, remove old ConversationInfo,  uin=" + localMessageRecord.frienduin + ",new type" + localMessageRecord.istroop);
        }
      }
      if (localMessageRecord.istroop == 10005) {}
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label1189;
        }
        a().a(localMessageRecord.frienduin, localMessageRecord.istroop, 1);
        break;
      }
      label1189:
      if (1038 == localMessageRecord.istroop)
      {
        localObject = (apap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
        if (localObject != null) {
          ((apap)localObject).b(paramList);
        }
      }
      a().a(localMessageRecord.frienduin, localMessageRecord.istroop, 1, a(localMessageRecord), b(localMessageRecord));
      break label250;
      if (i != 0) {
        d();
      }
      return;
      label1268:
      continue;
      label1271:
      break;
      label1274:
      break label140;
      label1277:
      break label191;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanAllUnread needUpdateMsgtable=" + paramBoolean1 + ",needDelMark=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      Iterator localIterator = a().a().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (ConversationInfo)localIterator.next();
        if ((a((ConversationInfo)localObject) > 0) && (!AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(((ConversationInfo)localObject).uin)) && ((!AppConstants.ACTIVATE_FRIENDS_UIN.equals(((ConversationInfo)localObject).uin)) || (AppConstants.ACTIVATE_FRIENDS_UIN.equals(((ConversationInfo)localObject).uin)))) {
          a(((ConversationInfo)localObject).uin, ((ConversationInfo)localObject).type, paramBoolean2);
        }
        a((ConversationInfo)localObject);
      }
      localIterator = a().a().iterator();
      while (localIterator.hasNext())
      {
        localObject = (ConfessConvInfo)localIterator.next();
        if (a((ConfessConvInfo)localObject) > 0) {
          a(((ConfessConvInfo)localObject).uin, ((ConfessConvInfo)localObject).type, ((ConfessConvInfo)localObject).topicId, paramBoolean2);
        }
      }
    }
    a().d();
    a().d();
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (paramString == null) {}
    label329:
    label330:
    label332:
    label339:
    for (;;)
    {
      return false;
      Object localObject;
      String str;
      if (paramInt == 1009)
      {
        localObject = a(paramInt).a(AppConstants.SAME_STATE_BOX_UIN, 1009);
        str = null;
      }
      for (;;)
      {
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label339;
        }
        localObject = ((List)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (paramString.equals(localMessageRecord.senderuin))
          {
            return true;
            if (paramInt == 1001)
            {
              localObject = a(paramInt).a(AppConstants.LBS_HELLO_UIN, 1001);
              if (localObject != null) {
                ((List)localObject).addAll(a(paramInt).a(AppConstants.NEARBY_LBS_HELLO_UIN, 1001));
              }
              for (;;)
              {
                str = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                break;
                localObject = a(paramInt).a(AppConstants.NEARBY_LBS_HELLO_UIN, 1001);
              }
            }
            if (paramInt == 1010)
            {
              localObject = a(paramInt).a(AppConstants.DATE_UIN, 1010);
              str = AppConstants.DATE_SAY_HELLO_LIST_UIN;
              continue;
            }
            if (paramInt == 1032)
            {
              localObject = a(paramInt).a(AppConstants.CONFESS_UIN, 1032);
              str = null;
              continue;
            }
            if (paramInt == 1044)
            {
              localObject = a(paramInt).a(AppConstants.MATCH_CHAT_UIN, 1044);
              str = null;
              continue;
            }
            if (paramInt != 10008) {
              break label332;
            }
            localObject = a(paramInt).a(AppConstants.QCIRCLE_CHAT_UIN, 10008);
            str = null;
            continue;
          }
          if ((str == null) || (i != 0) || (!str.equals(localMessageRecord.senderuin))) {
            break label329;
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if (i == 0) {
            break label330;
          }
          return a(paramString, paramInt, str);
        }
        break;
        str = null;
        localObject = null;
      }
    }
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    paramString2 = a(paramInt).a(paramString2, paramInt);
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext()) {
        if (paramString1.equals(((MessageRecord)paramString2.next()).senderuin)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int b()
  {
    return a() + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getInterFollowMgr().getInterFollowMsgBoxUnreadCount();
  }
  
  public int b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while ((paramMessageRecord.isSend()) || (paramMessageRecord.isread) || (!MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))) {
      return 0;
    }
    return 1;
  }
  
  public int b(String paramString, int paramInt)
  {
    return b(a().a(paramString, paramInt));
  }
  
  public ConversationInfo b(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public void b()
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      ConfessConvInfo localConfessConvInfo = (ConfessConvInfo)localIterator.next();
      if (a(localConfessConvInfo) > 0) {
        a(localConfessConvInfo.uin, localConfessConvInfo.type, localConfessConvInfo.topicId, true);
      }
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (AppConstants.CONFESS_UIN.equals(paramString)) {
      d(paramString, paramInt);
    }
    do
    {
      return;
      localObject1 = a(paramInt).a(paramString, paramInt);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    if (acnh.b(paramString))
    {
      c(paramString, paramInt);
      return;
    }
    if (AppConstants.LBS_HELLO_UIN.equals(paramString))
    {
      e(paramString, paramInt);
      return;
    }
    if (AppConstants.NEARBY_LBS_HELLO_UIN.equals(paramString))
    {
      e(paramString, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNearbyProxy().b(0);
      return;
    }
    String str = "";
    Object localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j = 0;
    int k = 0;
    label124:
    Object localObject2;
    int m;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (acnh.b(((MessageRecord)localObject2).senderuin))
      {
        c(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        m = k;
        label175:
        j += e(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        i += f(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        if ((!TextUtils.isEmpty(str)) || (i <= 0)) {
          break label458;
        }
        str = ((MessageRecord)localObject2).senderuin;
      }
    }
    label284:
    label448:
    label458:
    for (;;)
    {
      k = m;
      break label124;
      m = k;
      if (acnh.d((MessageRecord)localObject2)) {
        break label175;
      }
      m = k + a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
      break label175;
      if (f(paramString, paramInt) != i)
      {
        m = 1;
        if ((a(paramString, paramInt) != k) || (e(paramString, paramInt) != j) || (m != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label448;
          }
        }
      }
      for (long l = 0L;; l = ((ConversationInfo)localObject1).lastread)
      {
        ((acmx)localObject2).a(paramString, paramInt, l, k, j, i);
        if ((acnh.w(paramInt)) && (m != 0)) {
          a(a().a(paramString, paramInt), str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "calculateMsgBoxUnreadCount boxUin=" + paramString + ", unread=" + k + ", giftCount=" + j + ", redPacketCount=" + i);
        return;
        m = 0;
        break label284;
      }
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    a().c(paramString, paramInt1, paramInt2);
  }
  
  protected void b(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = a(paramInt).b(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (a().b(paramString, paramInt) > 0) {
        a(paramString, paramInt, paramLong, true);
      }
      return;
    }
    ConversationInfo localConversationInfo;
    long l;
    label216:
    int i1;
    if (((a(paramInt)) && (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq <= paramLong)) || ((a(paramInt)) || (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time > paramLong) || (acnh.b(paramInt)) || (acnh.c(paramInt))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "updateLastReadSeq uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
      }
      localConversationInfo = a().a(paramString, paramInt);
      if (localConversationInfo == null) {
        break label1201;
      }
      if (!a(paramInt)) {
        break label1195;
      }
      l = Math.max(paramLong, localConversationInfo.lastread);
      i1 = localConversationInfo.unreadCount;
    }
    for (;;)
    {
      label256:
      int i;
      int n;
      int m;
      Object localObject2;
      label314:
      MessageRecord localMessageRecord;
      if (a(paramInt))
      {
        paramLong = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq - l;
        i = (int)paramLong;
        n = 0;
        m = 0;
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "updateLastReadSeq unread =" + i);
        }
        localObject2 = null;
        Iterator localIterator = ((List)localObject1).iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label1028;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
        if (!a(paramInt)) {
          break label648;
        }
        paramLong = localMessageRecord.shmsgseq;
        label349:
        if (paramLong > l) {
          break label1173;
        }
        if (!localMessageRecord.isLongMsg()) {
          break label707;
        }
        if (localObject1 != null) {
          break label1188;
        }
      }
      label648:
      label1163:
      label1166:
      label1173:
      label1188:
      for (Object localObject3 = new HashMap();; localObject3 = localObject1)
      {
        localObject1 = acnh.b(localMessageRecord);
        Object localObject4;
        int i2;
        int j;
        int k;
        if (((Map)localObject3).containsKey(acnh.b(localMessageRecord)))
        {
          localObject4 = (Set)((Map)localObject3).get(localObject1);
          localObject1 = localObject3;
          i2 = i;
          j = n;
          k = m;
          if (localObject4 != null)
          {
            localObject1 = localObject3;
            i2 = i;
            j = n;
            k = m;
            if (!((Set)localObject4).isEmpty())
            {
              localObject1 = localObject3;
              i2 = i;
              j = n;
              k = m;
              if (!a(localMessageRecord, (Set)localObject4))
              {
                ((Set)localObject4).add(localMessageRecord);
                k = m;
                j = n;
                i2 = i;
                localObject1 = localObject3;
              }
            }
          }
        }
        for (;;)
        {
          localObject3 = localObject2;
          n = j;
          m = k;
          if (paramLong > l)
          {
            if (acnh.s(localMessageRecord.msgtype))
            {
              i = i2 - 1;
              n = j;
              m = k;
              break label314;
              if ((a().b(paramString, paramInt) > 0) || (a().c(paramString, paramInt) > 0) || (a().d(paramString, paramInt) > 0))
              {
                a(paramString, paramInt, paramLong, false);
                return;
              }
              if ((paramLong <= 0L) || (a(paramString, paramInt) >= paramLong)) {
                break;
              }
              a(paramString, paramInt, paramLong, false);
              return;
              paramLong = a(paramInt).a(paramString, paramInt, paramLong);
              break label256;
              paramLong = localMessageRecord.time;
              break label349;
              localObject4 = new HashSet();
              ((Set)localObject4).add(localMessageRecord);
              ((Map)localObject3).put(localObject1, localObject4);
              localObject1 = localObject3;
              i2 = i;
              j = n;
              k = m;
              continue;
              label707:
              if ((!acnh.n(localMessageRecord.msgtype)) || (localMessageRecord.isread)) {
                break label1173;
              }
              i2 = i + 1;
              j = n + a(localMessageRecord);
              k = m + b(localMessageRecord);
              continue;
            }
            if ((a(paramInt)) && (avia.a(localMessageRecord)))
            {
              i = i2 - 1;
              n = j;
              m = k;
              break label314;
            }
            if (!localMessageRecord.isLongMsg()) {
              break label1166;
            }
            if ((localObject1 != null) && (((Map)localObject1).containsKey(acnh.b(localMessageRecord))) && (a(localMessageRecord, (Set)((Map)localObject1).get(acnh.b(localMessageRecord)))))
            {
              i = i2 - 1;
              n = j;
              m = k;
              break label314;
            }
            if (localObject2 != null) {
              break label1163;
            }
            localObject2 = new HashSet();
            label872:
            localObject4 = acnh.b(localMessageRecord);
            if (!acnh.c(localMessageRecord)) {
              break label995;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(localMessageRecord))
            {
              i = i2 - 1;
              n = j;
              m = k;
              break label314;
            }
            if (((Set)localObject2).contains(localObject4))
            {
              i = i2 - 1;
              n = j;
              m = k;
              break label314;
            }
            ((Set)localObject2).add(localObject4);
            localObject3 = localObject2;
          }
          for (;;)
          {
            n = j + a(localMessageRecord);
            m = k + b(localMessageRecord);
            localObject2 = localObject3;
            i = i2;
            break label314;
            label995:
            localObject3 = localObject2;
            if (((Set)localObject2).contains(localObject4))
            {
              ((Set)localObject2).remove(localObject4);
              localObject3 = localObject2;
              continue;
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder().append("updateLastReadSeq before=");
                if (localConversationInfo == null) {
                  break label1157;
                }
              }
              for (localObject1 = localConversationInfo.toString();; localObject1 = null)
              {
                QLog.d("Q.unread.Facade", 2, (String)localObject1 + " , end unread=" + i + ", lastread=" + l + ",unreadGift=" + n + ",unreadRedPacket=" + m);
                a().a(paramString, paramInt, l, i, n, m);
                if ((i == i1) || (!acnh.d(paramInt))) {
                  break;
                }
                d();
                return;
              }
              break label872;
              localObject3 = localObject2;
            }
          }
          i2 = i;
          j = n;
          k = m;
        }
      }
      label1028:
      label1157:
      label1195:
      l = paramLong;
      break label216;
      label1201:
      i1 = 0;
      l = paramLong;
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if ((RecentUser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().findRecentUser(paramString, paramInt) != null) {
      return true;
    }
    if (7000 == paramInt) {
      return false;
    }
    if (!a(paramInt)) {
      return a(paramString);
    }
    return awtz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  public int c(String paramString, int paramInt)
  {
    return c(a().a(paramString, paramInt));
  }
  
  public void c()
  {
    SharedPreferences localSharedPreferences = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1001);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    acmw localacmw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1001).a(AppConstants.LBS_HELLO_UIN, 1001).iterator();
    int i = 0;
    int j = 0;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (MessageRecord)localIterator.next();
      if (localacmw.f(((MessageRecord)localObject).senderuin, 1001) > 0) {
        break label290;
      }
      localObject = a(((MessageRecord)localObject).senderuin, 0, false);
      if (!localSharedPreferences.contains((String)localObject)) {
        break label290;
      }
      localEditor.remove((String)localObject);
      i += 1;
      j = 1;
    }
    label290:
    for (;;)
    {
      break;
      localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1001).a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001).iterator();
      while (localIterator.hasNext())
      {
        localObject = (MessageRecord)localIterator.next();
        if (localacmw.f(((MessageRecord)localObject).senderuin, 1001) <= 0)
        {
          localObject = a(((MessageRecord)localObject).senderuin, 0, false);
          if (localSharedPreferences.contains((String)localObject))
          {
            localEditor.remove((String)localObject);
            i += 1;
            j = 1;
          }
        }
      }
      if (j != 0) {
        localEditor.commit();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box", 2, "clearMrSummary2, count=" + i);
      }
      return;
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).a(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return;
    }
    int m = 0;
    int i = 0;
    int j = 0;
    String str = "";
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("sp_key_nearby_clean_unread_time", 0L);
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("sp_key_say_hello_msg_clean_unread_time", 0L);
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    label88:
    Object localObject2;
    int n;
    int i1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      Iterator localIterator = a(((MessageRecord)localObject2).istroop).b(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop).iterator();
      MessageRecord localMessageRecord;
      while (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        n = k;
        if (localMessageRecord.time > l1)
        {
          n = k;
          if (!localMessageRecord.isread) {
            n = k + 1;
          }
        }
        k = n;
        if (localMessageRecord.time > l2)
        {
          k = n;
          if (!localMessageRecord.isread)
          {
            m += 1;
            k = n;
          }
        }
      }
      if (e(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0)
      {
        n = i;
        i1 = j;
        if (f(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {}
      }
      else
      {
        localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMessages(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop, a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) * 2).iterator();
        for (;;)
        {
          n = i;
          i1 = j;
          if (!localIterator.hasNext()) {
            break;
          }
          localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord.time > l2)
          {
            i += a(localMessageRecord);
            j += b(localMessageRecord);
          }
        }
      }
      if ((i1 <= 0) || (!TextUtils.isEmpty(str))) {
        break label626;
      }
      str = ((MessageRecord)localObject2).senderuin;
    }
    label453:
    label616:
    label626:
    for (;;)
    {
      i = n;
      j = i1;
      break label88;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("sp_key_sayhello_box_unread_count", k).commit();
      if (f(paramString, paramInt) != j)
      {
        k = 1;
        if ((a(paramString, paramInt) != m) || (e(paramString, paramInt) != i) || (k != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label616;
          }
        }
      }
      for (l1 = 0L;; l1 = ((ConversationInfo)localObject1).lastread)
      {
        ((acmx)localObject2).a(paramString, paramInt, l1, m, i, j);
        if ((acnh.w(paramInt)) && (k != 0)) {
          a(a().a(paramString, paramInt), str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "calculateSayHelloBoxUnreadCount boxUin=" + paramString + ", unread=" + m + ", giftCount=" + i + ", redPacketCount=" + j);
        return;
        k = 0;
        break label453;
      }
    }
  }
  
  public void c(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "rewriteUnreadCount uin=" + paramString + ",type" + paramInt1 + ",unread" + paramInt2);
    }
    a().d(paramString, paramInt1, paramInt2);
  }
  
  public int d(String paramString, int paramInt)
  {
    return d(a().a(paramString, paramInt));
  }
  
  public void d(String paramString, int paramInt)
  {
    Object localObject2 = a(paramInt).a(paramString, paramInt);
    Object localObject1;
    int i;
    int j;
    if (!aqvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true))
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if (((MessageRecord)localObject2).isSelfConfessor()) {}
        for (j = 1033;; j = 1034)
        {
          aqvh.a(((MessageRecord)localObject2).senderuin, j, ((MessageRecord)localObject2).getConfessTopicId());
          i = a(((MessageRecord)localObject2).senderuin, j, ((MessageRecord)localObject2).getConfessTopicId()) + i;
          break;
        }
      }
      if ((((aqvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a() != null) && (aquz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_box_show")))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.unread.Facade", 2, "calcConfessBoxUnreadCount box redpoint show +1");
        }
        i += 1;
      }
    }
    for (;;)
    {
      if (f(paramString, paramInt) != 0)
      {
        j = 1;
        if ((a(paramString, paramInt) != i) || (e(paramString, paramInt) != 0) || (j != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label353;
          }
        }
      }
      label353:
      for (long l = 0L;; l = ((ConversationInfo)localObject1).lastread)
      {
        ((acmx)localObject2).a(paramString, paramInt, l, i, 0, 0);
        if ((acnh.w(paramInt)) && (j != 0)) {
          a(a().a(paramString, paramInt), "");
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "calcConfessBoxUnreadCount boxUin=" + paramString + ", unread=" + i + ", giftCount=" + 0 + ", redPacketCount=" + 0);
        }
        return;
        j = 0;
        break;
      }
      continue;
      i = 0;
    }
  }
  
  public void d(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt1 + ",count" + paramInt2);
    }
    a().e(paramString, paramInt1, paramInt2);
    if (acnh.d(paramInt1)) {
      d();
    }
  }
  
  public int e(String paramString, int paramInt)
  {
    return a().c(paramString, paramInt);
  }
  
  public void e(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).a(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return;
    }
    int m = 0;
    int i = 0;
    int j = 0;
    String str = "";
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("sp_key_nearby_clean_unread_time", 0L);
    localObject1 = ((List)localObject1).iterator();
    label67:
    Object localObject2;
    int k;
    int n;
    int i1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (acnh.b(((MessageRecord)localObject2).senderuin))
      {
        c(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        k = m;
      }
      for (;;)
      {
        if (e(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0)
        {
          n = i;
          i1 = j;
          if (f(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {
            break label315;
          }
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMessages(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop, a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) * 2).iterator();
        for (;;)
        {
          n = i;
          i1 = j;
          if (!localIterator.hasNext()) {
            break;
          }
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord.time > l)
          {
            i += a(localMessageRecord);
            j += b(localMessageRecord);
          }
        }
        if ((acnh.c(((MessageRecord)localObject2).senderuin)) || (acnh.d(((MessageRecord)localObject2).senderuin))) {
          break;
        }
        k = m;
        if (!acnh.d((MessageRecord)localObject2)) {
          k = m + a((MessageRecord)localObject2, l);
        }
      }
      label315:
      if ((!TextUtils.isEmpty(str)) || (i1 <= 0)) {
        break label536;
      }
      str = ((MessageRecord)localObject2).senderuin;
    }
    label526:
    label536:
    for (;;)
    {
      m = k;
      i = n;
      j = i1;
      break label67;
      if (f(paramString, paramInt) != j)
      {
        k = 1;
        label363:
        if ((a(paramString, paramInt) != m) || (e(paramString, paramInt) != i) || (k != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label526;
          }
        }
      }
      for (l = 0L;; l = ((ConversationInfo)localObject1).lastread)
      {
        ((acmx)localObject2).a(paramString, paramInt, l, m, i, j);
        if ((acnh.w(paramInt)) && (k != 0)) {
          a(a().a(paramString, paramInt), str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "calculateMsgBoxUnreadCount boxUin=" + paramString + ", unread=" + m + ", giftCount=" + i + ", redPacketCount=" + j);
        return;
        k = 0;
        break label363;
      }
    }
  }
  
  public int f(String paramString, int paramInt)
  {
    return a().d(paramString, paramInt);
  }
  
  public int g(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public void onDestroy()
  {
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmw
 * JD-Core Version:    0.7.0.1
 */