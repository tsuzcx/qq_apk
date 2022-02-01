import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.1;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.2;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.3;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.4;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public abstract class acvk
  extends acvh
{
  public acvk(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, acwe paramacwe)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramacwe);
  }
  
  private HashMap<String, MessageRecord> a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      return localHashMap;
    }
    Object localObject = paramList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject).next();
    } while (localMessageRecord.shmsgseq <= 0L);
    for (long l = localMessageRecord.uniseq;; l = 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, l);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh find msg in cache id = " + ((MessageRecord)localObject).getId() + ", msg = " + ((MessageRecord)localObject).getLogColorContent() + ", uniseq = " + ((MessageRecord)localObject).uniseq + " , msgtime = " + ((MessageRecord)localObject).time + " , shMsgSeq = " + ((MessageRecord)localObject).shmsgseq + " , extra = " + ((MessageRecord)localObject).extraflag);
        }
        if (!paramList.isEmpty())
        {
          paramList = paramList.iterator();
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localMessageRecord = (MessageRecord)paramList.next();
          } while (localMessageRecord.shmsgseq != ((MessageRecord)localObject).shmsgseq);
          StringBuilder localStringBuilder = new StringBuilder();
          if (localMessageRecord.getId() > 0L) {}
          for (paramString = "id&" + localMessageRecord.getId();; paramString = "uniseq&" + localMessageRecord.uniseq)
          {
            localHashMap.put(paramString + "&" + localMessageRecord.shmsgseq, localMessageRecord);
            break;
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.BaseMessageManager", 2, "refresh can't find msg in cache !!");
      }
      return localHashMap;
    }
  }
  
  private void a(int paramInt, String paramString, long paramLong, List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    label323:
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (paramList != null)
      {
        localObject1 = paramList.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (acwh.a((MessageRecord)localObject2));
      }
      for (long l1 = ((ChatMessage)localObject2).shmsgseq;; l1 = 0L)
      {
        if ((l1 > paramLong) || (paramLong == 0L) || (l1 == 0L)) {
          break label323;
        }
        long l2 = bbyp.a();
        localObject1 = paramList.iterator();
        do
        {
          l1 = l2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (((ChatMessage)localObject2).shmsgseq != paramLong);
        l1 = ((ChatMessage)localObject2).time;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = (MessageForTroopUnreadTips)bbzh.a(-4009);
        ((MessageForTroopUnreadTips)localObject1).init((String)localObject2, paramString, (String)localObject2, "", l1, -4009, paramInt, 0L);
        ((MessageForTroopUnreadTips)localObject1).shmsgseq = paramLong;
        paramString = new ArrayList();
        paramString.add(localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, (String)localObject2, false, false);
        paramString = new ArrayList();
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add((ChatMessage)((Iterator)localObject2).next());
        }
        acwh.a(paramString, (MessageRecord)localObject1, false);
        paramList.clear();
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          paramList.add((ChatMessage)paramString.next());
        }
        break;
      }
    }
  }
  
  public int a(String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "clearLimitCountHistory uin = " + paramString1 + ", type = " + paramInt1 + ", needDeleteDB = " + paramBoolean1 + ", delNum = " + paramInt2);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 1, false, false);
    if (1 == paramInt1) {}
    for (String str = String.format("shmsgseq in (select shmsgseq from %s order by shmsgseq limit %s)", new Object[] { paramString2, Integer.valueOf(paramInt2) });; str = null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString1, paramInt1, paramString2, str, null, null);
      }
      return i;
    }
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.shmsgseq;
  }
  
  protected abstract String a(String paramString1, String paramString2);
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("COUNT MUST > 0 !");
    }
    System.currentTimeMillis();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).f(paramString, paramInt1);
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      return new ArrayList();
    }
    long l2 = 0L;
    Object localObject3 = ((List)localObject2).iterator();
    do
    {
      l1 = l2;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      localObject4 = (MessageRecord)((Iterator)localObject3).next();
    } while (((MessageRecord)localObject4).shmsgseq <= 0L);
    long l1 = ((MessageRecord)localObject4).uniseq;
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l1);
    Object localObject4 = a(paramString, paramInt1, (List)localObject2);
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
    int i;
    int j;
    label222:
    int k;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i = 0;
      if (i < localList.size())
      {
        if (((MessageRecord)localList.get(i)).uniseq != l1) {
          break label1602;
        }
        j = i;
        for (;;)
        {
          label387:
          label691:
          try
          {
            localObject2 = new ArrayList();
            if (localObject3 == null)
            {
              l1 = 0L;
              if (j == 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 0, timestamp = " + System.currentTimeMillis());
                }
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
                if (l1 - paramInt2 < 0L) {
                  break label1611;
                }
                l2 = l1 - paramInt2;
                break label1584;
                label309:
                Object localObject1;
                ((List)localObject2).addAll(((acwf)localObject3).c(paramString, paramInt1, l2, localObject1));
                ((List)localObject2).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l1, (Map)localObject4));
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 1, timestamp = " + System.currentTimeMillis());
                }
                paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                paramInt1 = 0;
                if (paramInt1 >= ((List)localObject2).size()) {
                  break label1570;
                }
                localObject3 = (MessageRecord)((List)localObject2).get(paramInt1);
                paramString.b(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).senderuin);
                paramInt1 += 1;
                continue;
              }
            }
            else
            {
              l1 = ((MessageRecord)localObject3).shmsgseq;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 0, cacheIndex = " + j + " timestamp = " + System.currentTimeMillis());
            }
            if (j < paramInt2) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 1, timestamp = " + System.currentTimeMillis());
            }
            i = j - paramInt2;
            l2 = ((MessageRecord)localList.get(i)).shmsgseq;
            label566:
            if ((i > 0) && (((MessageRecord)localList.get(i - 1)).shmsgseq == ((MessageRecord)localList.get(i)).shmsgseq))
            {
              i -= 1;
              if (!QLog.isColorLevel()) {
                break label1575;
              }
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + i);
              continue;
            }
            if (i != 0) {
              break label1108;
            }
            if (!QLog.isColorLevel()) {
              break label1623;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 2, timestamp = " + System.currentTimeMillis());
          }
          finally {}
          if ((i < localList.size() - 1) && (((MessageRecord)localList.get(i)).shmsgseq == ((MessageRecord)localList.get(i + 1)).shmsgseq))
          {
            k += 1;
            if (!QLog.isColorLevel()) {
              break label1636;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + k);
            break label1636;
          }
          i = k + 1;
          if (i > j)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 3, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
            }
            ((List)localObject2).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l1, (Map)localObject4));
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 4, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
            }
          }
          else
          {
            ((List)localObject2).addAll(localList.subList(i, j));
            paramInt2 -= ((List)localObject2).size();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 5, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
            }
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
            if (l2 - paramInt2 < 0L) {
              break label1645;
            }
            l1 = l2 - paramInt2;
            label1035:
            ((List)localObject2).addAll(0, ((acwf)localObject3).c(paramString, paramInt1, l1, l2));
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 6, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
              continue;
              label1108:
              ((List)localObject2).addAll(localList.subList(i, j));
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 7, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
              }
            }
          }
        }
        l2 = ((MessageRecord)localList.get(0)).shmsgseq;
        k = 0;
        i = 0;
        label1202:
        if ((i < localList.size() - 1) && (((MessageRecord)localList.get(i)).shmsgseq == ((MessageRecord)localList.get(i + 1)).shmsgseq))
        {
          k += 1;
          if (!QLog.isColorLevel()) {
            break label1651;
          }
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + k);
          break label1651;
        }
        i = k + 1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 0, sameSeq = " + l2 + ",itemListStartPoint = " + i + ", timestamp = " + System.currentTimeMillis());
        }
        if (i > j)
        {
          ((List)localObject2).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2, (Map)localObject4));
          label1388:
          paramInt2 -= ((List)localObject2).size();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 1, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
          if (l2 - paramInt2 < 0L) {
            break label1660;
          }
        }
      }
    }
    label1570:
    label1575:
    label1584:
    label1602:
    label1611:
    label1617:
    label1623:
    label1636:
    label1645:
    label1651:
    label1660:
    for (l1 = l2 - paramInt2;; l1 = 0L)
    {
      ((List)localObject2).addAll(0, ((acwf)localObject3).c(paramString, paramInt1, l1, l2));
      if (!QLog.isColorLevel()) {
        break label387;
      }
      QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 2, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
      break label387;
      ((List)localObject2).addAll(localList.subList(i, j));
      break label1388;
      return localObject2;
      break label566;
      j = 0;
      break label222;
      for (;;)
      {
        if (l1 - 1L < 0L) {
          break label1617;
        }
        l3 = l1 - 1L;
        break label309;
        i += 1;
        break;
        l2 = 0L;
      }
      long l3 = 0L;
      break label309;
      k = j - paramInt2;
      i = k;
      break label691;
      i += 1;
      break label691;
      l1 = 0L;
      break label1035;
      i += 1;
      break label1202;
    }
  }
  
  protected void a(acwr paramacwr, int paramInt)
  {
    String str = paramacwr.jdField_a_of_type_JavaLangString;
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).f(str, paramInt);
    if ((paramacwr.jdField_c_of_type_Int < 3) && (acwh.c(localList)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more sticker msg");
      }
      paramacwr.jdField_c_of_type_Int += 1;
      b(str, paramInt, 15, paramacwr);
      return;
    }
    if ((acwh.a(str, paramInt, localList)) && (paramacwr.jdField_d_of_type_Boolean) && (paramacwr.b < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more long msg");
      }
      paramacwr.b += 1;
      b(str, paramInt, 15, paramacwr);
      return;
    }
    super.a(paramacwr, paramInt);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean, acwr paramacwr)
  {
    paramacwr.f = false;
    paramacwr.jdField_d_of_type_Boolean = true;
    paramacwr.jdField_a_of_type_JavaLangString = paramString;
    paramacwr.jdField_d_of_type_Int = paramInt;
    if ((!paramacwr.i) && (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilMap.containsKey(acwh.a(paramString, paramInt))))
    {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramacwr);
      return;
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilMap.put(acwh.a(paramString, paramInt), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new BaseMessageManagerForTroopAndDisc.4(this, paramacwr, paramString, paramInt, paramLong2, paramLong1, paramBoolean));
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    boolean bool2 = paramBundle.getBoolean("success");
    long l3 = paramBundle.getLong("beginSeq", -1L);
    long l4 = paramBundle.getLong("endSeq", -1L);
    boolean bool3 = paramBundle.getBoolean("key_from_parallel_pull", false);
    List localList;
    Object localObject1;
    Object localObject2;
    int i;
    label112:
    long l1;
    label278:
    long l2;
    label293:
    label329:
    Object localObject3;
    if ((paramInt == 1) && (bool3) && (paramList1 != null) && (!paramList1.isEmpty()))
    {
      localList = a(paramString, paramInt, paramList1.size());
      localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
      localObject2 = new StringBuilder().append("refresh roam step 1 , result = ");
      if (paramList1 != null) {
        break label730;
      }
      i = -1;
      ((QQMessageFacade)localObject1).a(i + " , success = " + bool2 + " , beginSeq = " + l3 + " , endSeq = " + l4, " , timestamp = " + System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramBundle.getInt("counter")));
      if (localList == null) {
        break label1170;
      }
      localObject1 = paramList2;
      if (paramList2 == null) {
        localObject1 = new ArrayList();
      }
      if ((paramList1 == null) || (paramList1.isEmpty())) {
        break label854;
      }
      paramList2 = new ArrayList();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt);
      if (l3 - 15L <= 0L) {
        break label741;
      }
      l1 = l3 - 15L;
      if (l3 - 1L <= 0L) {
        break label747;
      }
      l2 = l3 - 1L;
      paramList2.addAll(((acwf)localObject2).c(paramString, paramInt, l1, l2));
      paramList2.addAll(localList);
      paramList1 = paramList1.iterator();
      if (!paramList1.hasNext()) {
        break label854;
      }
      localObject2 = (MessageRecord)paramList1.next();
      localObject3 = paramList2.iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
      } while (!acwh.a((MessageRecord)((Iterator)localObject3).next(), (MessageRecord)localObject2, false, true));
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam msg rewrite sending msg  mr.senderuin: " + ((MessageRecord)localObject2).senderuin + " mr.msgtype: " + ((MessageRecord)localObject2).msgtype + " mr.frienduin: " + ((MessageRecord)localObject2).frienduin + " mr.shmsgseq: " + ((MessageRecord)localObject2).shmsgseq + " mr.time:" + ((MessageRecord)localObject2).time + " mr.msg: " + ((MessageRecord)localObject2).getLogColorContent());
        }
        if ((((MessageRecord)localObject2).senderuin != null) && (((MessageRecord)localObject2).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
        {
          localObject3 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, (MessageRecord)localObject2, paramList2);
          if (localObject3 != null) {
            if (((MessageRecord)localObject3).isValid) {
              break label1197;
            }
          }
        }
      }
      label1157:
      label1170:
      label1197:
      for (paramInt = 1;; paramInt = 0)
      {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject3).uniseq, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
        if (((MessageRecord)localObject3).msgtype == -2017)
        {
          byte[] arrayOfByte = acwh.a((MessageRecord)localObject3, (MessageRecord)localObject2);
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(((MessageRecord)localObject2).frienduin, 1, ((MessageRecord)localObject3).uniseq, arrayOfByte);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam text msg rewrite success");
        }
        if (paramInt == 0) {
          break label329;
        }
        ((MessageRecord)localObject3).shmsgseq = ((MessageRecord)localObject2).shmsgseq;
        ((MessageRecord)localObject3).time = ((MessageRecord)localObject2).time;
        ((MessageRecord)localObject3).extraflag = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((MessageRecord)localObject3);
        break label329;
        localList = (List)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramBundle.getInt("counter")));
        break;
        label730:
        i = paramList1.size();
        break label112;
        label741:
        l1 = 0L;
        break label278;
        label747:
        l2 = 0L;
        break label293;
        ((List)localObject1).add(localObject2);
        if (!QLog.isColorLevel()) {
          break label329;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 2 , mr.msg = " + ((MessageRecord)localObject2).getLogColorContent() + " , mr.seq = " + ((MessageRecord)localObject2).shmsgseq + " , mr.msgtype = " + ((MessageRecord)localObject2).msgtype + ", isExist = " + bool1 + " , extra = " + ((MessageRecord)localObject2).extraflag);
        break label329;
        label854:
        paramBundle.putBoolean("success", bool2);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)((List)localObject1).get(0)).istroop).a((List)localObject1, null);
        }
        paramList1 = ((List)localObject1).iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (MessageRecord)paramList1.next();
          if (paramList2.getId() < 0L) {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.BaseMessageManager", 2, "refresh insert db error ! , mr.msg = " + paramList2.getLogColorContent() + " , mr.seq = " + paramList2.shmsgseq + " , mr.uniseq = " + paramList2.uniseq + " , extra = " + paramList2.extraflag);
            }
          }
          for (;;)
          {
            if ((!(paramList2 instanceof MessageForShortVideo)) || (((MessageForShortVideo)paramList2).redBagType != LocalMediaInfo.REDBAG_TYPE_GET)) {
              break label1157;
            }
            paramList2 = (MessageForShortVideo)paramList2;
            VideoRedbagData.insertData(paramList2.shortVideoId, paramList2.uniseq, paramList2.redBagStat);
            break;
            acwh.c(localList, paramList2, true);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 3 , mr.msg = " + paramList2.getLogColorContent() + " , mr.seq = " + paramList2.shmsgseq + " , mr.uniseq = " + paramList2.uniseq + " , extra = " + paramList2.extraflag);
            }
          }
        }
        try
        {
          localList.notify();
          if (bool3) {
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a().b(paramString, l3, l4);
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public void a(String paramString, ArrayList<MessageRecord> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    int j = -1;
    int i = 0;
    if (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      bepr localbepr = localMessageRecord.mMessageInfo;
      int k = j;
      int m = i;
      if (localbepr != null)
      {
        k = j;
        m = i;
        if (!localMessageRecord.isread) {
          if (localMessageRecord.istroop != 1) {
            break label299;
          }
        }
      }
      label299:
      for (boolean bool = true;; bool = false)
      {
        aong localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        RecentUser localRecentUser = (RecentUser)localaong.findRecentUserByUin(paramString, localMessageRecord.istroop);
        k = j;
        m = i;
        if (localbepr.a())
        {
          int n = localbepr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool, localMessageRecord.frienduin);
          if (bepr.a(n, localRecentUser.msgType))
          {
            localRecentUser.msgType = n;
            localRecentUser.msg = bfiu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, localbepr, localRecentUser.msg, localMessageRecord, bool);
            localaong.saveRecentUser(localRecentUser);
            j = localMessageRecord.istroop;
            i = 1;
          }
          k = j;
          m = i;
          if (bool) {
            if (n != 24)
            {
              k = j;
              m = i;
              if (n != 22) {}
            }
            else
            {
              k = j;
              m = i;
              if (!njo.a(localMessageRecord))
              {
                k = j;
                m = i;
                if (bfup.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "atMeOrReplyMe"))
                {
                  localArrayList.add(localMessageRecord);
                  m = i;
                  k = j;
                }
              }
            }
          }
        }
        i = m;
        j = k;
        break;
      }
    }
    if (localArrayList.size() > 0)
    {
      ThreadManager.getSubThreadHandler().post(new BaseMessageManagerForTroopAndDisc.2(this, localArrayList));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "markAtOrReplyMeMsgInTroop_" + localArrayList.size());
      }
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramString, j));
    }
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager.troop.revoked_troop_msg", 2, "cleanBizTypeMarkForMsgRevoke==>uin:" + paramString + "|type:" + paramInt + "|seqFrom:" + paramLong);
    }
    if ((paramString == null) || (paramLong < 0L)) {
      return false;
    }
    aong localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = (RecentUser)localaong.findRecentUserByUin(paramString, paramInt);
    bfiv localbfiv;
    if ((localRecentUser != null) && (localRecentUser.shouldShowInRecentList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      localbfiv = (bfiv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(363);
      if ((!(localRecentUser.msg instanceof alej)) || (((alej)localRecentUser.msg).a.a != paramLong)) {
        break label199;
      }
    }
    label199:
    for (int i = bfhu.b(localRecentUser.msgType);; i = -1)
    {
      if (i == -1) {
        return false;
      }
      localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
      localaong.saveRecentUser(localRecentUser);
      localbfiv.a(paramString, paramInt, i);
      return true;
      return false;
    }
  }
  
  public boolean a(String paramString1, int paramInt, List<MessageRecord> paramList, String paramString2)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refresh autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(acwh.a(paramString1, paramInt), Boolean.valueOf(true));
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).f(paramString1, paramInt);
    } while ((paramString1 == null) || (paramString1.isEmpty()));
    paramList = acwh.a(paramList, true);
    int i;
    if (((MessageRecord)paramList.get(0)).shmsgseq <= ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq + 1L)
    {
      i = 1;
      if (i == 0) {
        break label276;
      }
      paramInt = 0;
      label151:
      if (paramInt >= paramList.size()) {
        break label300;
      }
      if (((MessageRecord)paramList.get(paramInt)).shmsgseq <= ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq) {
        break label269;
      }
    }
    for (;;)
    {
      paramList = paramList.subList(paramInt, paramList.size());
      if ((!paramList.isEmpty()) && (((MessageRecord)paramString1.get(0)).shmsgseq <= ((MessageRecord)paramList.get(0)).shmsgseq)) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramList, paramString2);
      }
      for (;;)
      {
        return true;
        i = 0;
        break;
        label269:
        paramInt += 1;
        break label151;
        label276:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).c();
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramList, paramString2);
      }
      label300:
      paramInt = 0;
    }
  }
  
  protected abstract String b(String paramString1, String paramString2);
  
  protected void b(QQMessageFacade.Message paramMessage)
  {
    paramMessage.nickName = a(paramMessage.senderuin, paramMessage.frienduin);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, acwr paramacwr)
  {
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("COUNT MUST > 0 !");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).f(paramString, paramInt1);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      paramacwr.jdField_a_of_type_JavaUtilList = null;
      a(paramacwr, paramInt1);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    Object localObject2;
    long l3;
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (((MessageRecord)localObject2).shmsgseq > 0L)
      {
        l3 = ((MessageRecord)localObject2).uniseq;
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
        }
        paramacwr.jdField_a_of_type_JavaUtilList = null;
        a(paramacwr, paramInt1);
        return;
      }
      MessageRecord localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l3);
      long l1;
      if (localMessageRecord1 == null)
      {
        l1 = 0L;
        if (localMessageRecord1 != null) {
          break label305;
        }
      }
      long l2;
      label305:
      for (int j = 3;; j = localMessageRecord1.versionCode)
      {
        localObject2 = a(paramString, paramInt1, paramInt2);
        i = 0;
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          break label1908;
        }
        int k = ((List)localObject2).size() - 1;
        l2 = l1;
        i = 0;
        while ((k >= 0) && (l2 - ((MessageRecord)((List)localObject2).get(k)).shmsgseq <= 1L))
        {
          l2 = ((MessageRecord)((List)localObject2).get(k)).shmsgseq;
          i += 1;
          k -= 1;
        }
        l1 = localMessageRecord1.shmsgseq;
        break;
      }
      for (;;)
      {
        long l4 = l2 - 1L;
        long l5;
        long l6;
        if (paramInt2 - i < 0)
        {
          i = 0;
          l5 = 1L + (l4 - i);
          l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1);
          i = 1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 0, delSeq = " + l6 + ", endSeq = " + l4 + ",beginSeq = " + l5 + ",lastContinuedSeq = " + l2 + ",localSeqEnd = " + l1 + ", timestamp = " + System.currentTimeMillis());
          }
          if (l4 <= 0L)
          {
            paramacwr.jdField_a_of_type_Boolean = true;
            i = 0;
          }
          if (l4 > l6) {
            break label659;
          }
          paramacwr.jdField_a_of_type_Boolean = true;
          i = 0;
          l1 = l5;
        }
        for (;;)
        {
          label484:
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          localObject1 = new ArrayList();
          Iterator localIterator = ((List)localObject2).iterator();
          Object localObject3;
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label767;
            }
            localObject3 = (MessageRecord)localIterator.next();
            if (((MessageRecord)localObject3).shmsgseq < l2)
            {
              ((List)localObject1).add(localObject3);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint invalid: id = " + ((MessageRecord)localObject3).getId() + ", msg = " + ((MessageRecord)localObject3).getLogColorContent() + " , msgtime = " + ((MessageRecord)localObject3).time + " , shMsgSeq = " + ((MessageRecord)localObject3).shmsgseq + " , extra = " + ((MessageRecord)localObject3).extraflag);
              continue;
              i = paramInt2 - i;
              break;
              label659:
              if (l5 > l6) {
                break label1901;
              }
              l1 = l6 + 1L;
              break label484;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint valid: id = " + ((MessageRecord)localObject3).getId() + ", msg = " + ((MessageRecord)localObject3).getLogColorContent() + " , msgtime = " + ((MessageRecord)localObject3).time + " , shMsgSeq = " + ((MessageRecord)localObject3).shmsgseq + " , extra = " + ((MessageRecord)localObject3).extraflag);
            }
          }
          label767:
          ((List)localObject2).removeAll((Collection)localObject1);
          ((List)localObject1).clear();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 1, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
          }
          boolean bool2 = true;
          boolean bool1 = bool2;
          if (!paramacwr.jdField_c_of_type_Boolean)
          {
            bool1 = bool2;
            if (l4 >= l2)
            {
              bool1 = bool2;
              if (l4 > 0L)
              {
                bool1 = bool2;
                if (i != 0)
                {
                  localObject1 = new Bundle();
                  i = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
                  ((Bundle)localObject1).putInt("counter", i);
                  ((Bundle)localObject1).putBoolean("success", false);
                  this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 0 , timestamp = " + System.currentTimeMillis());
                  }
                  if (paramInt1 == 3000) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(paramString).longValue(), l2, l4, true, (Bundle)localObject1);
                  }
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(acwh.a(paramString, paramInt1), Boolean.valueOf(false));
                    if (bgnt.g(BaseApplication.getContext())) {}
                    try
                    {
                      localObject2.wait(35000L);
                      bool1 = ((Bundle)localObject1).getBoolean("success");
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 4 , size = " + ((List)localObject2).size() + " , timestamp = " + System.currentTimeMillis());
                      }
                      if ((this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(acwh.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(acwh.a(paramString, paramInt1))).booleanValue()))
                      {
                        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("get auto pull msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                        paramacwr.jdField_a_of_type_JavaUtilList = null;
                        a(paramacwr, paramInt1);
                        return;
                        if (paramInt1 != 1) {
                          continue;
                        }
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, l2, l4, true, (Bundle)localObject1, 0);
                      }
                    }
                    catch (InterruptedException localInterruptedException)
                    {
                      for (;;)
                      {
                        localInterruptedException.printStackTrace();
                      }
                    }
                    finally {}
                  }
                }
              }
            }
          }
          if (((((List)localObject2).isEmpty()) && (l4 > 0L)) || ((!bool1) && (((List)localObject2).size() < paramInt2)))
          {
            l1 = l4;
            if (!((List)localObject2).isEmpty())
            {
              HashMap localHashMap = new HashMap();
              localObject3 = ((List)localObject2).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                MessageRecord localMessageRecord2 = (MessageRecord)((Iterator)localObject3).next();
                if (localMessageRecord2.shmsgseq == ((MessageRecord)((List)localObject2).get(0)).shmsgseq)
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  if (localMessageRecord2.getId() > 0L) {}
                  for (localObject1 = "id&" + localMessageRecord2.getId();; localObject1 = "uniseq&" + localMessageRecord2.uniseq)
                  {
                    localHashMap.put((String)localObject1 + "&" + localMessageRecord2.shmsgseq, localMessageRecord2);
                    break;
                  }
                }
              }
              ((List)localObject2).addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, ((MessageRecord)((List)localObject2).get(0)).shmsgseq, localHashMap));
              l1 = ((MessageRecord)((List)localObject2).get(0)).shmsgseq - 1L;
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
            if (localMessageRecord1 == null)
            {
              l2 = 0L;
              localObject1 = ((acwf)localObject1).a(paramString, paramInt1, l2, j, l1, paramInt2 - ((List)localObject2).size(), null);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam fail step 0 , size = " + ((List)localObject1).size() + ",seq = " + l1 + " , timestamp = " + System.currentTimeMillis());
              }
              if (!((List)localObject1).isEmpty()) {
                break label1795;
              }
              paramacwr.jdField_a_of_type_Boolean = true;
              label1633:
              paramacwr.jdField_c_of_type_Boolean = true;
              label1639:
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg", 2, "context.isLocalOnly = " + paramacwr.jdField_c_of_type_Boolean);
              }
              a((List)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1, (List)localObject2);
              paramacwr.jdField_a_of_type_JavaUtilList = ((List)localObject2);
              paramString = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
              localObject1 = new StringBuilder().append("refresh finish , context = ").append(paramacwr).append(" , size = ");
              if (localObject2 != null) {
                break label1890;
              }
            }
          }
          label1795:
          label1890:
          for (paramInt2 = -1;; paramInt2 = ((List)localObject2).size())
          {
            paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
            a(paramacwr, paramInt1);
            return;
            l2 = localMessageRecord1.getId();
            break;
            ((List)localObject2).addAll(0, (Collection)localObject1);
            break label1633;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam addRoamMsgToList uniseq = " + l3 + " , locallist = " + ((List)localObject2).size() + " , timestamp = " + System.currentTimeMillis());
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l3, (List)localObject2);
            break label1639;
          }
          label1901:
          l1 = l5;
        }
        label1908:
        l2 = l1;
      }
      i = 0;
      l3 = 0L;
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateTroopUnread uin=" + paramString + ",type=" + paramInt + ",from=" + paramLong);
    }
    if (paramLong < 0L) {}
    do
    {
      return;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "updateTroopUnread return : uin=null");
    return;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramString, paramInt));
  }
  
  protected void c(QQMessageFacade.Message paramMessage)
  {
    paramMessage.nickName = b(paramMessage.senderuin, paramMessage.frienduin);
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    ThreadManager.post(new BaseMessageManagerForTroopAndDisc.3(this, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramMessageRecord), l), 8, null, true);
  }
  
  public void c(String paramString, int paramInt)
  {
    if (paramInt <= 0) {}
    Object localObject1;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "pullTroopMsgParallelInSilence, start...count:" + paramInt);
      }
      beue.b = System.currentTimeMillis();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).f(paramString, 1);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
    return;
    long l1 = 0L;
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      if (((MessageRecord)localObject3).shmsgseq > 0L) {
        l1 = ((MessageRecord)localObject3).uniseq;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "aioMsgList size:" + ((List)localObject1).size());
      }
      if (i == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(paramString, 1, l1);
      if (localObject1 == null) {}
      long l2;
      for (l1 = 0L;; l1 = ((MessageRecord)localObject1).shmsgseq)
      {
        localObject1 = a(paramString, 1, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "lastContinuedSeq:" + l1 + " locallist size:" + ((List)localObject1).size());
        }
        i = 0;
        if (((List)localObject1).isEmpty()) {
          break label1270;
        }
        int j = ((List)localObject1).size() - 1;
        l2 = l1;
        i = 0;
        while ((j >= 0) && (l2 - ((MessageRecord)((List)localObject1).get(j)).shmsgseq <= 1L))
        {
          l2 = ((MessageRecord)((List)localObject1).get(j)).shmsgseq;
          i += 1;
          j -= 1;
        }
      }
      for (;;)
      {
        long l4 = l2 - 1L;
        long l3;
        long l5;
        if (paramInt - i < 0)
        {
          paramInt = 0;
          l3 = 1L + (l4 - paramInt);
          l5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1);
          paramInt = 1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint step 0, delSeq = " + l5 + ", endSeq = " + l4 + ",beginSeq = " + l3 + ",lastContinuedSeq = " + l2 + ",localSeqEnd = " + l1 + ", timestamp = " + System.currentTimeMillis());
          }
          if (l4 <= 0L) {
            paramInt = 0;
          }
          if (l4 > l5) {
            break label705;
          }
          l1 = l3;
          paramInt = 0;
        }
        for (;;)
        {
          label535:
          if (l1 < 0L) {
            l1 = 0L;
          }
          for (;;)
          {
            for (;;)
            {
              localObject2 = new ArrayList();
              localObject3 = ((List)localObject1).iterator();
              for (;;)
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break label814;
                }
                MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
                if (localMessageRecord.shmsgseq < l1)
                {
                  ((List)localObject2).add(localMessageRecord);
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint invalid: id = " + localMessageRecord.getId() + ", msg = " + localMessageRecord.getLogColorContent() + " , msgtime = " + localMessageRecord.time + " , shMsgSeq = " + localMessageRecord.shmsgseq + " , extra = " + localMessageRecord.extraflag);
                  continue;
                  paramInt -= i;
                  break;
                  label705:
                  if (l3 > l5) {
                    break label1263;
                  }
                  l1 = 1L + l5;
                  break label535;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint valid: id = " + localMessageRecord.getId() + ", msg = " + localMessageRecord.getLogColorContent() + " , msgtime = " + localMessageRecord.time + " , shMsgSeq = " + localMessageRecord.shmsgseq + " , extra = " + localMessageRecord.extraflag);
                }
              }
              label814:
              ((List)localObject1).removeAll((Collection)localObject2);
              ((List)localObject2).clear();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint step 1, size = " + ((List)localObject1).size() + ", timestamp = " + System.currentTimeMillis());
              }
              if ((l4 < l1) || (l4 <= 0L) || (paramInt == 0)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh roam step 0 , timestamp = " + System.currentTimeMillis() + " beginSeq:" + l1 + " endSeq:" + l4);
              }
              l2 = (l4 - l1) / 20L;
              if ((l4 - l1) % 20L == 0L) {}
              for (paramInt = 0;; paramInt = 1)
              {
                l2 = paramInt;
                localObject2 = new Bundle();
                ((Bundle)localObject2).putBoolean("key_from_parallel_pull", true);
                ((Bundle)localObject2).putBoolean("success", false);
                paramInt = 0;
                while (l1 < l4)
                {
                  ThreadManager.post(new BaseMessageManagerForTroopAndDisc.1(this, l1 + 19L, l4, paramInt, l1, paramString, (Bundle)localObject2), 8, null, false);
                  l1 += 20L;
                  paramInt += 1;
                }
              }
              this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(acwh.a(paramString, 1), Boolean.valueOf(false));
              if (bgnt.g(BaseApplication.getContext())) {}
              try
              {
                localObject1.wait(35000L);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh roam step 4 , size = " + ((List)localObject1).size() + " , timestamp = " + System.currentTimeMillis());
                }
                if ((!this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(acwh.a(paramString, 1))) || (!((Boolean)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(acwh.a(paramString, 1))).booleanValue())) {
                  break;
                }
                this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("get auto pull msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                return;
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  localInterruptedException.printStackTrace();
                }
              }
              finally {}
            }
          }
          label1263:
          l1 = l3;
        }
        label1270:
        l2 = l1;
      }
    }
  }
  
  protected void c(String paramString, int paramInt, long paramLong)
  {
    if ((paramString == null) || (paramLong < 0L) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    aong localaong;
    RecentUser localRecentUser;
    do
    {
      return;
      localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = (RecentUser)localaong.findRecentUserByUin(paramString, paramInt);
    } while ((localRecentUser == null) || (!localRecentUser.shouldShowInRecentList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (!(localRecentUser.msg instanceof alej)) || (((alej)localRecentUser.msg).a.a > paramLong));
    int i;
    if ((paramInt == 1) && ((localRecentUser.msg instanceof alez)))
    {
      bftq localbftq = bftr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      if ((localbftq != null) && (localbftq.a == 1))
      {
        i = 1;
        label132:
        if (i == 0)
        {
          if (awhv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) {
            break label322;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "TroopNotificationMsg, cleanMsgAndMsgData");
          }
          localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
          localaong.saveRecentUser(localRecentUser);
        }
      }
    }
    for (;;)
    {
      ((bfiv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(363)).a(paramString, paramInt, 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "cleanBizTypeMark TYPE_ALL_MSG type = " + paramInt + ", seqFrom = " + paramLong);
      }
      if (paramInt != 1) {
        break;
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString);
      if ((paramInt == 1) || (paramInt == 4)) {
        break;
      }
      albs.a().a(localRecentUser.uin + "-" + localRecentUser.getType());
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localRecentUser);
      return;
      i = 0;
      break label132;
      label322:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "TroopNotificationMsg, delRecentUser");
      }
      localaong.delRecentUser(localRecentUser, false);
      continue;
      localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
      localaong.saveRecentUser(localRecentUser);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvk
 * JD-Core Version:    0.7.0.1
 */