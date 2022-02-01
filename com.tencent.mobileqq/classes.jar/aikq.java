import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager.2;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager.3;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager.4;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager.5;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class aikq
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, ailt> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<MessageRecord> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, Integer>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private List<MessageRecord> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private List<MessageRecord> c = new ArrayList();
  private List<MessageRecord> d = new ArrayList();
  private List<aiks> e = new CopyOnWriteArrayList();
  
  public aikq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private long a(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((paramList instanceof MessageForSystemMsg))
      {
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList != null) && (paramList.msg_seq.has()))
        {
          long l = paramList.msg_seq.get();
          if (l > 0L) {
            return l;
          }
        }
      }
    }
    return 0L;
  }
  
  private String a(structmsg.StructMsg paramStructMsg)
  {
    if ((paramStructMsg != null) && (paramStructMsg.msg.has())) {
      return String.valueOf(((structmsg.SystemMsg)paramStructMsg.msg.get()).group_code.get()) + String.valueOf(paramStructMsg.req_uin.get()) + String.valueOf(((structmsg.SystemMsg)paramStructMsg.msg.get()).group_msg_type.get());
    }
    return "";
  }
  
  private List<ailt> a(List<oidb_0x5eb.UdcUinData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (oidb_0x5eb.UdcUinData)localIterator.next();
        if (localObject != null)
        {
          long l = ((oidb_0x5eb.UdcUinData)localObject).uint64_uin.get();
          int i = ((oidb_0x5eb.UdcUinData)localObject).uint32_age.get();
          label99:
          String str1;
          if (((oidb_0x5eb.UdcUinData)localObject).bytes_country.has())
          {
            paramList = ((oidb_0x5eb.UdcUinData)localObject).bytes_country.get().toStringUtf8();
            if (!((oidb_0x5eb.UdcUinData)localObject).bytes_province.has()) {
              break label225;
            }
            str1 = ((oidb_0x5eb.UdcUinData)localObject).bytes_province.get().toStringUtf8();
            label123:
            if (!((oidb_0x5eb.UdcUinData)localObject).bytes_city.has()) {
              break label232;
            }
          }
          int j;
          label225:
          label232:
          for (String str2 = ((oidb_0x5eb.UdcUinData)localObject).bytes_city.get().toStringUtf8();; str2 = "")
          {
            j = ((oidb_0x5eb.UdcUinData)localObject).uint32_gender.get();
            localObject = (ailt)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
            if (localObject == null) {
              break label239;
            }
            ((ailt)localObject).b(j);
            ((ailt)localObject).c(str2);
            ((ailt)localObject).a(paramList);
            ((ailt)localObject).b(str1);
            ((ailt)localObject).a(i);
            ((ailt)localObject).a(true);
            break;
            paramList = "";
            break label99;
            str1 = "";
            break label123;
          }
          label239:
          localArrayList.add(new ailt(l, i, paramList, str1, str2, j, true));
        }
      }
    }
    return localArrayList;
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    return a(b(paramList1, paramList2));
  }
  
  private List<MessageRecord> b(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return paramList1;
    }
    if (a(paramList1) >= a(paramList2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationManager", 2, new Object[] { "insertAddedMessageToOri", "insertAddedMessageToOri pull" });
      }
      paramList1.addAll(paramList2);
      return paramList1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationManager", 2, new Object[] { "insertAddedMessageToOri", "insertAddedMessageToOri push" });
    }
    paramList2.addAll(paramList1);
    return paramList2;
  }
  
  private void b(String paramString, List<Long> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {}
    for (;;)
    {
      return;
      paramString = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          paramString.remove((Long)paramList.next());
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject1 = (amzo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationManager", 1, "updateRecentUserListWhenNewEntryNotShow, Recent need to create and add");
    }
    Object localObject2 = d();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = bcsz.a().a();
      if (localObject2 != null)
      {
        long l = ((structmsg.StructMsg)localObject2).msg_time.get();
        ((amzo)localObject1).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000, amtj.a(2131690989), l, l);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(1009));
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationManager", 1, "updateRecentUserListWhenNewEntryNotShow, Recent be Added");
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("TroopNotificationManager", 1, "updateRecentUserListWhenNewEntryNotShow, structMsg is null");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationManager", 1, "updateRecentUserListWhenNewEntryNotShow, getMessageRecordListFromCache() is null or empty");
      }
      ((amzo)localObject1).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(1009));
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationManager", 1, "updateRecentUserListWhenNewEntryNotShow, getMessageRecordListFromCache() is null or empty。 when deleteRecent");
  }
  
  private void c(apus paramapus)
  {
    if (QLog.isColorLevel())
    {
      if (paramapus != null) {
        QLog.d("TroopNotificationManager", 1, "updateRecentUserListWhenHasNewConf, newConf = " + paramapus.toString());
      }
    }
    else
    {
      if ((paramapus != null) && (paramapus.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label89;
      }
      c();
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationManager", 1, "updateRecentUserListWhenHasNewConf, call updateRecentUserListWhenNewEntryNotShow");
      }
    }
    label89:
    do
    {
      return;
      QLog.d("TroopNotificationManager", 1, "updateRecentUserListWhenHasNewConf, newConf is null ");
      break;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationManager", 1, "updateRecentUserListWhenHasNewConf, delete notification entry in recent");
      }
      ((amzo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
      paramapus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    } while (paramapus == null);
    paramapus.sendMessage(paramapus.obtainMessage(1009));
  }
  
  private void e(List<MessageRecord> paramList)
  {
    Collections.sort(paramList, new aikr(this));
  }
  
  public ailt a(Long paramLong)
  {
    return (ailt)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong);
  }
  
  public ArrayList<MessageRecord> a(List<MessageRecord> paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.d("TroopNotificationManager", 2, "noti size is " + paramList.size());
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (localArrayList == null)) {
      return localArrayList;
    }
    HashSet localHashSet = new HashSet();
    HashMap localHashMap = new HashMap();
    apuq localapuq = (apuq)apub.a().a(634);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord instanceof MessageForSystemMsg))
      {
        structmsg.StructMsg localStructMsg1 = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
        String str = a(localStructMsg1);
        if (((localStructMsg1 == null) || (localStructMsg1.msg_time == null) || (!localStructMsg1.msg_time.has()) || (localapuq == null) || (System.currentTimeMillis() - localStructMsg1.msg_time.get() * 1000L <= localapuq.b * 1000L)) && (localStructMsg1 != null) && (localStructMsg1.msg_seq != null) && (localStructMsg1.msg_seq.has()))
        {
          int i;
          if (localHashSet.contains(Long.valueOf(localStructMsg1.msg_seq.get())))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopNotificationManager", 2, new Object[] { "duplicateMessages", "Repeat Msg Seq =", Long.valueOf(localStructMsg1.msg_seq.get()) });
            }
            structmsg.StructMsg localStructMsg2 = (structmsg.StructMsg)localHashMap.get(str);
            if ((localStructMsg2 != null) && (localStructMsg1.msg.sub_type.get() != 1))
            {
              i = 0;
              label326:
              Object localObject;
              int j;
              if (i < localArrayList.size())
              {
                localObject = (MessageRecord)localArrayList.get(i);
                if (localObject != null) {
                  break label369;
                }
                localArrayList.remove(i);
                j = i - 1;
              }
              label369:
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      i = j + 1;
                      break label326;
                      break;
                      localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
                      j = i;
                    } while (localStructMsg2.msg_seq == null);
                    j = i;
                  } while (localObject == null);
                  j = i;
                } while (((structmsg.StructMsg)localObject).msg_seq == null);
                j = i;
              } while (((structmsg.StructMsg)localObject).msg_seq.get() != localStructMsg2.msg_seq.get());
              localArrayList.remove(i);
              localArrayList.add(i, localMessageRecord);
              localHashMap.put(str, localStructMsg1);
            }
          }
          else
          {
            if ((localHashMap.containsKey(str)) && (localStructMsg1.msg.group_msg_type.get() != 91))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationManager", 2, new Object[] { "duplicateMessages", "New Repeat Undeal Msg Seq =", Long.valueOf(localStructMsg1.msg_seq.get()) });
              }
              if (localStructMsg1.msg_seq.get() > ((structmsg.StructMsg)localHashMap.get(str)).msg_seq.get())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("TroopNotificationManager", 2, new Object[] { "duplicateMessages", "New Repeat Undeal Msg Seq =", Long.valueOf(localStructMsg1.msg_seq.get()), "Old Repeat Undeal Msg Seq =", Long.valueOf(((structmsg.StructMsg)localHashMap.get(str)).msg_seq.get()) });
                }
                i = 0;
                label624:
                if (i < localArrayList.size())
                {
                  if (((MessageForSystemMsg)localArrayList.get(i)).getSystemMsg().msg_seq.get() != ((structmsg.StructMsg)localHashMap.get(str)).msg_seq.get()) {
                    break label721;
                  }
                  localArrayList.remove(i);
                  localArrayList.add(localMessageRecord);
                  localHashMap.put(str, localStructMsg1);
                }
              }
            }
            for (;;)
            {
              localHashSet.add(Long.valueOf(localStructMsg1.msg_seq.get()));
              break;
              label721:
              i += 1;
              break label624;
              if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationManager", 2, new Object[] { "duplicateMessages", "No Repeat Msg Seq =", Long.valueOf(localStructMsg1.msg_seq.get()) });
              }
              localHashMap.put(str, localStructMsg1);
              localArrayList.add(localMessageRecord);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public List<MessageRecord> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<Long> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if ((localLong != null) && (((Integer)paramString.get(localLong)).intValue() == 0))
      {
        localArrayList.add(localLong);
        paramString.put(localLong, Integer.valueOf(1));
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    try
    {
      this.d.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.c.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new TroopNotificationManager.4(this, paramInt));
  }
  
  public void a(long paramLong, int paramInt)
  {
    ailt localailt = (ailt)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localailt != null)
    {
      localailt.c(paramInt);
      localailt.b(true);
      return;
    }
    localailt = new ailt(paramLong, paramInt, true);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localailt);
  }
  
  public void a(aiks paramaiks)
  {
    if (paramaiks != null) {
      this.e.add(paramaiks);
    }
  }
  
  public void a(apus paramapus)
  {
    ThreadManager.getUIHandler().post(new TroopNotificationManager.5(this, paramapus));
  }
  
  public void a(Long paramLong, int paramInt, String paramString)
  {
    if ((paramLong == null) || (TextUtils.isEmpty(paramString))) {}
    ConcurrentHashMap localConcurrentHashMap1;
    do
    {
      return;
      ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localConcurrentHashMap1 = localConcurrentHashMap2;
      if (localConcurrentHashMap2 == null)
      {
        localConcurrentHashMap1 = new ConcurrentHashMap();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localConcurrentHashMap1);
      }
    } while (localConcurrentHashMap1.contains(paramLong));
    localConcurrentHashMap1.put(paramLong, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, List<Long> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      return;
    }
    Object localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      localObject = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (Long)paramList.next();
        if (localObject != null) {
          paramString.put(localObject, Integer.valueOf(0));
        }
      }
      break;
    }
  }
  
  public void a(List<oidb_0x5eb.UdcUinData> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      localObject = a(paramList);
    } while ((localObject == null) || (((List)localObject).isEmpty()));
    paramList = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ailt localailt = (ailt)((Iterator)localObject).next();
      if (localailt != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localailt.a()), localailt);
        paramList.add(Long.valueOf(localailt.a()));
      }
    }
    ThreadManager.postImmediately(new TroopNotificationManager.2(this, paramList), null, false);
  }
  
  public void a(List<MessageRecord> paramList, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_b_of_type_JavaUtilList.clear();
        this.c.clear();
        this.d.clear();
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationManager", 2, "setmDataList list:" + paramList.size() + " unReadCount:" + paramInt + " list info:" + paramList.toString());
        }
        Object localObject = (apuq)apub.a().a(634);
        this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_JavaUtilList, paramList);
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationManager", 2, "setmDataList mDataList:" + this.jdField_a_of_type_JavaUtilList.size() + " mDataList info:" + this.jdField_a_of_type_JavaUtilList.toString());
        }
        e(this.jdField_a_of_type_JavaUtilList);
        if ((localObject == null) || (!((apuq)localObject).jdField_a_of_type_Boolean))
        {
          this.d = this.jdField_a_of_type_JavaUtilList;
          return;
        }
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localObject = (MessageRecord)paramList.next();
          if (!(localObject instanceof MessageForSystemMsg)) {
            break label538;
          }
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localObject).getSystemMsg();
          if ((localStructMsg == null) || (!localStructMsg.msg.has())) {
            break label538;
          }
          int j = ((structmsg.SystemMsg)localStructMsg.msg.get()).group_msg_type.get();
          int k = ((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get();
          if ((j == 13) || (j == 6))
          {
            this.jdField_b_of_type_JavaUtilList.add(localObject);
            if ((i < paramInt) && (!this.jdField_a_of_type_Boolean)) {
              this.jdField_a_of_type_Boolean = true;
            }
            if (k != 1) {
              break label538;
            }
            this.c.add(localObject);
            if ((i >= paramInt) || (this.jdField_b_of_type_Boolean)) {
              break label538;
            }
            this.jdField_b_of_type_Boolean = true;
            break label538;
          }
          this.d.add(localObject);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationManager", 2, "setmDataList mUndealDataList:" + this.c.size() + " mUndealDataList info:" + this.c.toString() + " mExitDataList:" + this.jdField_b_of_type_JavaUtilList.size() + " mExitDataList info:" + this.jdField_b_of_type_JavaUtilList.toString() + " mHasUndealDataList:" + this.jdField_b_of_type_Boolean + " mHasExitMsgUnread" + this.jdField_a_of_type_Boolean);
      }
      return;
      label538:
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public List<MessageRecord> b()
  {
    return this.c;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void b(aiks paramaiks)
  {
    if (paramaiks != null) {
      this.e.remove(paramaiks);
    }
  }
  
  public void b(apus paramapus)
  {
    a(paramapus);
    c(paramapus);
  }
  
  public void b(List<Long> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ThreadManager.postImmediately(new TroopNotificationManager.3(this, paramList), null, false);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public List<MessageRecord> c()
  {
    return this.d;
  }
  
  public void c(List<Long> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      a("OidbSvc.0x5eb_troopnotifycation", paramList);
      return;
    }
    aikp localaikp = (aikp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(188);
    if (localaikp == null)
    {
      a("OidbSvc.0x5eb_troopnotifycation", paramList);
      return;
    }
    int i = paramList.size();
    if (i > 70)
    {
      label72:
      ArrayList localArrayList;
      if (i > 0)
      {
        if (i <= 70) {
          break label115;
        }
        localArrayList = new ArrayList(paramList.subList(i - 70, i));
        i -= 70;
      }
      for (;;)
      {
        localaikp.a(localArrayList);
        break label72;
        break;
        label115:
        localArrayList = new ArrayList(paramList.subList(0, i));
        i = 0;
      }
    }
    localaikp.a(paramList);
  }
  
  public List<MessageRecord> d()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void d(List<Long> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      a("OidbSvc.0x668", paramList);
      return;
    }
    aikp localaikp = (aikp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(188);
    if (localaikp == null)
    {
      a("OidbSvc.0x668", paramList);
      return;
    }
    int i = paramList.size();
    if (i > 70)
    {
      label72:
      ArrayList localArrayList;
      if (i > 0)
      {
        if (i <= 70) {
          break label115;
        }
        localArrayList = new ArrayList(paramList.subList(i - 70, i));
        i -= 70;
      }
      for (;;)
      {
        localaikp.b(localArrayList);
        break label72;
        break;
        label115:
        localArrayList = new ArrayList(paramList.subList(0, i));
        i = 0;
      }
    }
    localaikp.b(paramList);
  }
  
  public void onDestroy()
  {
    a();
    b();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikq
 * JD-Core Version:    0.7.0.1
 */