import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.C2CMessageManager.1;
import com.tencent.mobileqq.app.message.C2CMessageManager.2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class akot
  extends akoj
{
  public akot(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.time, paramMessageRecord.senderuin, paramMessageRecord.msg);
  }
  
  private ArrayList<MessageRecord> a(String paramString, List<MessageRecord> paramList1, List<MessageRecord> paramList2, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("C2CMsgFilter basetime=" + paramLong1 + ",lowtime=" + paramLong2, "");
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return localArrayList;
    }
    Object localObject1 = paramList1.iterator();
    long l2 = 9223372036854775807L;
    long l1 = -1L;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (l2 < ((MessageRecord)localObject2).time) {
        break label768;
      }
      l2 = ((MessageRecord)localObject2).time;
    }
    label768:
    for (;;)
    {
      if (l1 <= ((MessageRecord)localObject2).time) {
        l1 = ((MessageRecord)localObject2).time;
      }
      for (;;)
      {
        break;
        localObject2 = b(paramString, 0, l2 - 30L, l1 + 30L);
        MessageRecord localMessageRecord1;
        MessageRecord localMessageRecord2;
        if (paramList2 == null)
        {
          localObject1 = null;
          localMessageRecord1 = axas.a(-1000);
          localMessageRecord2 = axas.a(-1000);
          paramList1 = paramList1.iterator();
        }
        label391:
        label763:
        for (;;)
        {
          MessageRecord localMessageRecord3;
          boolean bool;
          if (paramList1.hasNext())
          {
            localMessageRecord3 = (MessageRecord)paramList1.next();
            localMessageRecord3.time -= 30L;
            localMessageRecord3.time += 30L;
            Object localObject3 = a((List)localObject2, localMessageRecord1.time, localMessageRecord2.time);
            if ((localObject2 == null) || (((List)localObject2).size() == 0))
            {
              localArrayList.add(localMessageRecord3);
              if (localObject1 == null) {
                continue;
              }
              ((List)localObject1).add(localMessageRecord3);
              continue;
              localObject1 = new ArrayList();
              break;
            }
            Object localObject4 = ((List)localObject3).iterator();
            for (;;)
            {
              if (((Iterator)localObject4).hasNext())
              {
                localObject3 = (MessageRecord)((Iterator)localObject4).next();
                if (akpx.a((MessageRecord)localObject3, localMessageRecord3, true)) {
                  if (QLog.isColorLevel())
                  {
                    localObject4 = new StringBuilder().append("C2CMsgFilter shmsgseq equals?");
                    if (localMessageRecord3.shmsgseq == ((MessageRecord)localObject3).shmsgseq)
                    {
                      bool = true;
                      QLog.i("Q.msg.BaseMessageManager", 2, bool + ",msg=" + localMessageRecord3.getLogColorContent() + "time:" + localMessageRecord3.time + "<->" + ((MessageRecord)localObject3).time + ", type=" + ((MessageRecord)localObject3).msgtype + "-" + localMessageRecord3.msgtype);
                    }
                  }
                  else if ((localObject1 != null) && (paramLong1 != -1L) && (((MessageRecord)localObject3).time <= paramLong1))
                  {
                    ((List)localObject1).add(localObject3);
                  }
                }
              }
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label763;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "C2CMsgFilter not eq: msg=" + localMessageRecord3.getLogColorContent() + "time:" + localMessageRecord3.time + ",type:" + localMessageRecord3.msgtype + ",msg.con : " + localMessageRecord3.getLogColorContent());
            }
            if (localObject1 != null) {
              ((List)localObject1).add(localMessageRecord3);
            }
            localArrayList.add(localMessageRecord3);
            break;
            bool = false;
            break label391;
            if ((paramLong1 > 0L) && (localObject1 != null))
            {
              localMessageRecord1.time = paramLong2;
              localMessageRecord2.time = paramLong1;
              paramString = b(paramString, 0, paramLong2, paramLong1).iterator();
              while (paramString.hasNext())
              {
                paramList1 = (MessageRecord)paramString.next();
                if ((!akpx.f(paramList1.msgtype)) && (paramList1.time <= paramLong1))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("addmsg ptt = " + paramList1.getId(), "");
                  akpx.b((List)localObject1, paramList1, true);
                }
              }
            }
            if (paramList2 != null) {
              paramList2.addAll((Collection)localObject1);
            }
            return localArrayList;
          }
        }
      }
    }
  }
  
  private List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, akqr paramakqr, akou paramakou)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).e(paramString, paramInt1);
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead ERROR: AIO is closed !!");
      }
      paramakqr.jdField_a_of_type_JavaUtilList = null;
      a(paramakqr, paramInt1);
      paramString = paramakqr.jdField_a_of_type_JavaUtilList;
      return paramString;
    }
    if (localObject2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("current Aio", ((List)localObject2).subList(0, Math.min(paramInt2, ((List)localObject2).size())));
    }
    long l2 = ((MessageRecord)((List)localObject2).get(0)).uniseq;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString);
    long l1;
    label135:
    Object localObject3;
    ArrayList localArrayList2;
    int i;
    if (localObject1 == null)
    {
      l1 = 0L;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
      localArrayList2 = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("NavigateRefreshMessageListHead isLocalOnly=" + paramakqr.jdField_c_of_type_Boolean + ",uniseq=" + l2 + ",ect=" + l1, " ,getC2CRoamingSetting" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e() == 0) {
        paramakqr.jdField_c_of_type_Boolean = true;
      }
      i = 0;
      label256:
      if (i >= ((List)localObject2).size()) {
        break label2572;
      }
      if (((MessageRecord)((List)localObject2).get(i)).uniseq != l2) {
        break label483;
      }
      label289:
      if (i >= ((List)localObject2).size()) {
        break label2566;
      }
      if (!akpx.f(((MessageRecord)((List)localObject2).get(i)).msgtype)) {
        break label474;
      }
      l2 = ((MessageRecord)((List)localObject2).get(i)).uniseq;
      i = 1;
    }
    for (;;)
    {
      if ((paramakqr.jdField_c_of_type_Boolean) || (l1 == 0L) || (i == 0))
      {
        b(paramString, paramInt1, l2, paramInt2, paramakqr, localArrayList2);
        a(localArrayList2, paramakou);
        a(localArrayList2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, localArrayList2);
        paramakqr.jdField_a_of_type_JavaUtilList = localArrayList2;
        if (paramakqr.jdField_a_of_type_Boolean) {
          b(paramString, paramInt1);
        }
        paramString = localArrayList2;
        if (!akpx.c(localArrayList2)) {
          break;
        }
        paramString = localArrayList2;
        if (paramakqr.jdField_c_of_type_Int >= 3) {
          break;
        }
        a(paramakqr, paramInt1);
        return localArrayList2;
        l1 = ((Long)((Pair)localObject1).first).longValue();
        break label135;
        label474:
        i += 1;
        break label289;
        label483:
        i += 1;
        break label256;
      }
      i = 0;
      label495:
      if (i < ((List)localObject3).size())
      {
        localObject1 = (MessageRecord)((List)localObject3).get(i);
        if (((MessageRecord)localObject1).uniseq != l2) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead cacheIndex:" + i + ", itemList:" + ((List)localObject3).size());
        }
        long l3;
        if (localObject1 == null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2);
          if (localObject1 == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh from empty C2C msg", "");
            paramakqr.jdField_a_of_type_Boolean = true;
            paramakqr.jdField_c_of_type_Boolean = true;
            paramakqr.jdField_a_of_type_JavaUtilList = new ArrayList();
            return paramakqr.jdField_a_of_type_JavaUtilList;
            i += 1;
            break label495;
          }
          l3 = ((MessageRecord)localObject1).time;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("NavigateRefreshMessageListHead uniseq=" + l2 + ", aioBase.getId():" + ((MessageRecord)localObject1).getId(), "");
          localArrayList2.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l3, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(((MessageRecord)localObject1).getId()) })));
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("NavigateRefreshMessageListHead Db fromTime:" + l3, "");
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("only load in db", localArrayList2);
          l2 = l3;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead locallist size " + localArrayList2.size());
          }
          if (l1 <= l2) {
            break label2551;
          }
          l1 = Math.min(l2, paramakqr.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("ect > fromTime!! newEct:" + l1, "");
        }
        label2163:
        label2551:
        for (boolean bool1 = false;; bool1 = true)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("before pull locallist", localArrayList2);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("before pull locallist" + localArrayList2.size(), "");
          if (localArrayList2.size() < paramInt2)
          {
            localObject3 = new Bundle();
            i = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
            ((Bundle)localObject3).putInt("counter", i);
            ((Bundle)localObject3).putBoolean("timeout", true);
            ((Bundle)localObject3).putLong("UIN", Long.valueOf(paramString).longValue());
            ((Bundle)localObject3).putBoolean("canUpdateEct", bool1);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), localArrayList2);
            Object localObject4 = new ArrayList();
            i = 0;
            Object localObject5;
            while (i < ((List)localObject2).size())
            {
              localObject5 = (MessageRecord)((List)localObject2).get(i);
              if (((MessageRecord)localObject5).time == ((MessageRecord)localObject1).time)
              {
                ((ArrayList)localObject4).add(localObject5);
                i += 1;
                continue;
                l2 = ((MessageRecord)localObject1).time;
                if (i >= paramInt2)
                {
                  j = i - paramInt2;
                  while (j < i)
                  {
                    localObject4 = (MessageRecord)((List)localObject3).get(j);
                    if (((MessageRecord)localObject4).time >= l1) {
                      localArrayList2.add(localObject4);
                    }
                    j += 1;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("all in cache", localArrayList2);
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead fromTime:" + l2);
                  }
                  break;
                  localObject4 = (MessageRecord)((List)localObject3).get(0);
                  localObject3 = ((List)localObject3).subList(0, i).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject5 = (MessageRecord)((Iterator)localObject3).next();
                    if (((MessageRecord)localObject5).time >= l1) {
                      localArrayList2.add(localObject5);
                    }
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("cache part", localArrayList2);
                  i = paramInt2 - localArrayList2.size();
                  localArrayList2.addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, ((MessageRecord)localObject4).time, i, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l1), Long.valueOf(((MessageRecord)localObject4).time), Long.valueOf(((MessageRecord)localObject4).getId()) })));
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("cache + db", localArrayList2);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead memdb:size:" + localArrayList2.size() + ",miss:" + i);
                  }
                }
              }
            }
            l2 = ((MessageRecord)localObject1).uniseq;
            i = localArrayList2.size();
            if (localArrayList2.isEmpty()) {
              i = paramInt2;
            }
            for (;;)
            {
              ((Bundle)localObject3).putLong("baseTime", l1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "pull roam " + i + ",time=" + l1 + ",timeFilterList:" + ((ArrayList)localObject4).size());
              }
              l3 = 0L;
              if (!bool1) {
                l3 = paramakqr.b;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, l1, (short)i, (Bundle)localObject3, l3);
              ((Bundle)localObject3).putInt("size_req", i);
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(akpx.a(paramString, paramInt1), Boolean.valueOf(false));
              try
              {
                localArrayList2.wait(35000L);
                if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(akpx.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(akpx.a(paramString, paramInt1))).booleanValue()))
                {
                  paramakqr.jdField_a_of_type_JavaUtilList = null;
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("get auto pull C2C msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                  return paramakqr.jdField_a_of_type_JavaUtilList;
                  i = paramInt2 - i;
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
            if ((((Bundle)localObject3).getBoolean("timeout")) && (QLog.isColorLevel())) {
              QLog.w("Q.msg.BaseMessageManager", 2, "timeout!");
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("after pull locallist" + localArrayList2.size(), "");
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("after pull locallist", localArrayList2);
            localArrayList1 = new ArrayList();
            int j = localArrayList2.size() - 1;
            while (j >= 0)
            {
              localObject2 = (MessageRecord)localArrayList2.get(j);
              localObject5 = ((ArrayList)localObject4).iterator();
              while (((Iterator)localObject5).hasNext())
              {
                MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject5).next();
                if (akpx.a(localMessageRecord, (MessageRecord)localObject2, true))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead filterMr " + localMessageRecord.getLogColorContent() + ",uniseq=" + localMessageRecord.uniseq);
                  }
                  localArrayList1.add(localObject2);
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead not find filterMr " + localMessageRecord.getLogColorContent() + ",mr=" + ((MessageRecord)localObject2).getLogColorContent());
                }
              }
              j -= 1;
            }
            localArrayList2.removeAll(localArrayList1);
            if (((Bundle)localObject3).getBoolean("timeout")) {
              break label2482;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead " + localArrayList2.size());
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2, localArrayList2);
            boolean bool2 = ((Bundle)localObject3).getBoolean("success");
            boolean bool3 = ((Bundle)localObject3).getBoolean("complete");
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.BaseMessageManager", 2, "success ?" + bool2 + ", complete?" + bool3);
            }
            if ((!bool2) || (bool3))
            {
              paramakqr.jdField_c_of_type_Boolean = true;
              if (!localArrayList2.isEmpty()) {
                break label2454;
              }
              if (!localArrayList2.isEmpty()) {
                break label2471;
              }
              label2171:
              b(paramString, paramInt1, l2, paramInt2, paramakqr, localArrayList2);
            }
            if (!bool1)
            {
              paramakqr.jdField_a_of_type_Long = ((Bundle)localObject3).getLong("tempEct");
              paramakqr.b = ((Bundle)localObject3).getLong("tempRandom");
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("update tempEct:" + paramakqr.jdField_a_of_type_Long + ", rand=" + paramakqr.b, "");
            }
          }
          a(localArrayList2);
          a(localArrayList2, paramakou);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, localArrayList2);
          paramakqr.jdField_a_of_type_JavaUtilList = localArrayList2;
          if (paramakqr.jdField_a_of_type_Boolean) {
            b(paramString, paramInt1);
          }
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
          paramakou = new StringBuilder().append("refresh C2C finish , context = ").append(paramakqr).append(" , size = ");
          if (localArrayList2 == null) {}
          for (paramInt2 = -1;; paramInt2 = localArrayList2.size())
          {
            paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
            paramString = localArrayList2;
            if (!akpx.c(localArrayList2)) {
              break;
            }
            paramString = localArrayList2;
            if (paramakqr.jdField_c_of_type_Int >= 3) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramakqr.jdField_c_of_type_Int);
            }
            a(paramakqr, paramInt1);
            return localArrayList2;
            l2 = ((MessageRecord)localArrayList2.get(0)).uniseq;
            break label2163;
            paramInt2 -= localArrayList2.size();
            break label2171;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("pull timeout", "");
            paramakqr.jdField_c_of_type_Boolean = true;
            if (localArrayList2.isEmpty()) {}
            for (;;)
            {
              b(paramString, paramInt1, l2, i, paramakqr, localArrayList2);
              break;
              l2 = ((MessageRecord)localArrayList2.get(0)).uniseq;
            }
          }
        }
        label2454:
        label2471:
        label2482:
        i = 0;
        ArrayList localArrayList1 = null;
      }
      label2566:
      i = 0;
      continue;
      label2572:
      i = 0;
    }
  }
  
  private List<MessageRecord> a(String paramString, List<MessageRecord> paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString, paramList, localArrayList, paramLong1, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("needSave", paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("msgInDB", localArrayList);
    if ((paramString != null) && (!paramString.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)paramString.get(0)).istroop).a(paramString, null);
    }
    paramList = paramString.iterator();
    label428:
    while (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      MessageRecord localMessageRecord;
      if (((MessageRecord)localObject).getId() < 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh C2C insert db error ! , mr.seq = " + ((MessageRecord)localObject).shmsgseq + " , mr.uniseq = " + ((MessageRecord)localObject).uniseq + ", mr.uid=" + ((MessageRecord)localObject).msgUid, "mr.msg = " + ((MessageRecord)localObject).getLogColorContent());
        localMessageRecord = a((MessageRecord)localObject);
        if (localMessageRecord == null) {
          localArrayList.remove(localObject);
        }
      }
      for (;;)
      {
        if ((!(localObject instanceof MessageForShortVideo)) || (((MessageForShortVideo)localObject).redBagType != LocalMediaInfo.REDBAG_TYPE_GET)) {
          break label428;
        }
        localObject = (MessageForShortVideo)localObject;
        VideoRedbagData.insertData(((MessageForShortVideo)localObject).shortVideoId, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).redBagStat);
        break;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh C2C insert db error ! , m.seq = " + localMessageRecord.shmsgseq + " , mr.uniseq = " + localMessageRecord.uniseq + ", m.uid=" + localMessageRecord.msgUid, "");
        localArrayList.set(localArrayList.indexOf(localObject), localMessageRecord);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh C2C roam step 3 , mr.seq = " + ((MessageRecord)localObject).shmsgseq + " , mr.uniseq = " + ((MessageRecord)localObject).uniseq, "mr.msg = " + ((MessageRecord)localObject).getLogColorContent());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("setC2CRoamMessageResult needsave=" + paramString.size(), "");
    return localArrayList;
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord.time > paramLong1) && (localMessageRecord.time < paramLong2)) {
        localArrayList.add(localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    MessageRecord localMessageRecord = axas.a(paramMessageRecord.msgtype);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.senderuin = paramString2;
    localMessageRecord.frienduin = paramString1;
    if (TextUtils.equals(ajsd.H, paramString1)) {
      paramMessageRecord.saveExtInfoToExtStr("msg_in_box", "msg_in_box");
    }
    if (akpx.a(paramMessageRecord.istroop) == 1032) {}
    for (localMessageRecord.istroop = 1032;; localMessageRecord.istroop = paramMessageRecord.istroop)
    {
      if (!akpx.g(paramMessageRecord.msgtype))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin, localMessageRecord.getExtraKey());
        a(localMessageRecord, null, false, true, 1);
      }
      return;
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, akou paramakou)
  {
    ArrayList localArrayList = new ArrayList();
    MessageRecord localMessageRecord;
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
      } while ((akpx.b(localMessageRecord)) || (localMessageRecord.msgUid != paramakou.jdField_a_of_type_Long) || (localMessageRecord.time != paramakou.b));
    }
    for (int i = paramArrayList.indexOf(localMessageRecord);; i = -1)
    {
      int j = i;
      if (i == -1) {
        return;
      }
      while (j < paramArrayList.size())
      {
        localArrayList.add(paramArrayList.get(j));
        j += 1;
      }
      paramArrayList.clear();
      paramArrayList.addAll(localArrayList);
      return;
    }
  }
  
  private List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramString, paramInt, Math.min(paramLong1, paramLong2), Math.max(paramLong1, paramLong2));
  }
  
  private void b(String paramString, int paramInt)
  {
    if ((1000 == paramInt) || (1004 == paramInt))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label41;
      }
    }
    label41:
    ChatMessage localChatMessage;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramString.iterator();
      }
      localChatMessage = (ChatMessage)localIterator.next();
    } while ((localChatMessage.isSend()) || (akpx.g(localChatMessage.msgtype)));
    ((ChatMessage)paramString.get(0)).mNeedGrayTips = true;
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.time;
  }
  
  List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.time < paramLong1) || (localMessageRecord.time > paramLong2)) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB fromCache=" + localArrayList.size());
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, paramLong2, -1, String.format("time>=%d or time=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB from=" + paramLong1 + ",to=" + paramLong2 + ",size=" + paramString.size());
        }
        paramString = akpx.a(localArrayList, paramString).iterator();
        while (paramString.hasNext()) {
          akpx.b(localArrayList, (MessageRecord)paramString.next(), false);
        }
      }
      localArrayList.add(localMessageRecord);
    }
    return localArrayList;
  }
  
  protected void a(akqr paramakqr, int paramInt)
  {
    String str = paramakqr.jdField_a_of_type_JavaLangString;
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).e(str, paramInt);
    if ((paramakqr.jdField_c_of_type_Int < 3) && (akpx.c(localList)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more sticker msg");
      }
      paramakqr.jdField_c_of_type_Int += 1;
      b(str, paramInt, 15, paramakqr);
      return;
    }
    super.a(paramakqr, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, aukp paramaukp, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, akok paramakok)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap = paramakok.jdField_a_of_type_JavaUtilMap;
    aktf localaktf = paramakok.jdField_a_of_type_Aktf;
    Object localObject4 = paramakok.jdField_a_of_type_Akpb;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = awzy.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    String str2 = paramMessageRecord.senderuin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    Object localObject1;
    if ((i != 3000) && (i != 1) && (i != 7000))
    {
      localObject1 = paramMessageRecord.frienduin;
      if (!String.valueOf(ajsd.H).equals(localObject1)) {
        break label4858;
      }
      localObject1 = paramMessageRecord.senderuin;
    }
    label328:
    label1110:
    label1132:
    label1520:
    label4852:
    label4855:
    label4858:
    for (;;)
    {
      if ((i == 1001) && (!paramMessageRecord.isSend()) && (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)))
      {
        if (akpx.d(paramMessageRecord)) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8E", "0X8005C8E", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if ((akpx.a(i) != 1009) && (((akpb)localObject4).a((String)localObject1, 1009)))
        {
          ((akpb)localObject4).a(ajsd.w, 1009, (String)localObject1, paramMessageRecord.istroop);
          a(ajsd.w, 1009, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((akpx.a(i) != 1001) && (((akpb)localObject4).a((String)localObject1, 1001)))
        {
          ((akpb)localObject4).a(ajsd.H, 1001, (String)localObject1, paramMessageRecord.istroop);
          if (!((akpb)localObject4).a((String)localObject1, 1001, ajsd.aj)) {
            break label1110;
          }
          a(ajsd.aj, 1001, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((akpx.a(i) != 1010) && (((akpb)localObject4).a((String)localObject1, 1010)))
        {
          ((akpb)localObject4).a(ajsd.ab, 1010, (String)localObject1, paramMessageRecord.istroop);
          if (!((akpb)localObject4).a((String)localObject1, 1010, ajsd.ak)) {
            break label1132;
          }
          a(ajsd.ak, 1010, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((akpx.a(i) != 1044) && (((akpb)localObject4).a((String)localObject1, 1044)) && (((akpb)localObject4).a((String)localObject1, 1044, ajsd.aT))) {
          a(ajsd.aT, 1044, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((i == 1008) && (advo.a(paramMessageRecord.frienduin)))
        {
          localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).edit();
          if ((paramMessageRecord instanceof MessageForPubAccount)) {
            break;
          }
          if (!(paramMessageRecord instanceof MessageForText)) {
            break label1154;
          }
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_push", 0, 0, "", "", "", "");
          ((SharedPreferences.Editor)localObject1).putLong("pa_list_send_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject1).commit();
        }
        if (akpx.a(paramMessageRecord.istroop) != 1009) {
          break label1520;
        }
        if ((((akpb)localObject4).a(str1)) || (localMap.containsKey(akpx.a(paramMessageRecord.frienduin, paramMessageRecord.istroop)))) {
          localaktf.a(paramMessageRecord.frienduin);
        }
        a(paramMessageRecord, ajsd.w, paramMessageRecord.frienduin);
        str1 = ajsd.w;
        i = paramMessageRecord.istroop;
        l = paramMessageRecord.time;
      }
      int k;
      for (;;)
      {
        for (;;)
        {
          if (((paramMessageRecord instanceof MessageForVideo)) && (paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1)) {
            k = -1;
          }
          try
          {
            localObject1 = paramMessageRecord.msg.split("\\|");
            j = k;
            if (localObject1 != null)
            {
              j = k;
              if (localObject1.length >= 2) {
                j = Integer.valueOf(localObject1[1]).intValue();
              }
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Object localObject5;
              boolean bool;
              int j = -1;
              continue;
              localException1.a((MessageForVideo)paramMessageRecord, false);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementRecentUserManager", 2, "isAdMessage:recent_list_advertisement_message change 0");
              }
              paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "0");
              if (i != 1032)
              {
                localObject3 = localaktf.a(str1, k);
                if (j != 0) {
                  ((RecentUser)localObject3).lFlag = 16L;
                }
                if (!localMap.containsKey(akpx.a(((RecentUser)localObject3).uin, ((RecentUser)localObject3).getType()))) {
                  break label4843;
                }
                localObject3 = (RecentUser)localMap.get(akpx.a(((RecentUser)localObject3).uin, ((RecentUser)localObject3).getType()));
              }
              for (;;)
              {
                j = i;
                if (!akpx.g(paramMessageRecord.msgtype))
                {
                  if ((i != 1008) || (b(str1))) {
                    break label3281;
                  }
                  j = i;
                }
                do
                {
                  do
                  {
                    do
                    {
                      for (;;)
                      {
                        if ((!paramMessageRecord.isSend()) && (paramMessageRecord.istroop == 0) && (bbbr.b(paramMessageRecord.frienduin)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
                        {
                          bool = bbjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
                          if (QLog.isColorLevel()) {
                            QLog.i("BabyQReportCookie", 2, "now in the aio, isScreenLocked = " + bool);
                          }
                          if ((akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().containsKey(akpx.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) && (!bool))
                          {
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
                            if (QLog.isColorLevel()) {
                              QLog.i("BabyQReportCookie", 2, "now in the aio!!!");
                            }
                          }
                        }
                        if (j == 1036) {
                          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c(null);
                        }
                        super.a(paramMessageRecord, paramaukp, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramakok);
                        paramaukp = ayfy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                        paramaukp.a(paramMessageRecord);
                        paramaukp.a();
                        return;
                        if (i == 10005)
                        {
                          ardi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, paramaukp, localaktf);
                          break;
                        }
                        if (!aknx.b(i)) {
                          break;
                        }
                        aknx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, i, paramMessageRecord);
                        break;
                        localObject3 = localaktf.a(str1, i);
                        break label2926;
                        j = i;
                        if (!bduf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord)) {
                          if (str1.equals(ajsd.I))
                          {
                            QLog.i("Q.msg.BaseMessageManager.NEARBY_MSG", 2, "mr.senderUin = " + paramMessageRecord.senderuin);
                            j = i;
                          }
                          else if ((i == 1009) && (str1.equals(ajsd.w)))
                          {
                            if (l > ((RecentUser)localObject3).lastmsgtime) {
                              ((RecentUser)localObject3).lastmsgtime = l;
                            }
                            ((RecentUser)localObject3).setType(akpx.a(((RecentUser)localObject3).getType()));
                            localaktf.a((RecentUser)localObject3);
                            j = i;
                          }
                          else if ((i == 1032) && (str1.equals(ajsd.aM)))
                          {
                            if ((l > ((RecentUser)localObject3).lastmsgtime) && (amnr.b(paramMessageRecord))) {
                              ((RecentUser)localObject3).lastmsgtime = l;
                            }
                            ((RecentUser)localObject3).setType(akpx.a(((RecentUser)localObject3).getType()));
                            localaktf.a((RecentUser)localObject3);
                            j = i;
                          }
                          else if ((i == 1008) && (!njl.a(paramMessageRecord)) && ((sdc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, i)) || ("1".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num")))))
                          {
                            str1 = akpx.a(str1, i);
                            if (paramakok.f.containsKey(str1))
                            {
                              ((List)paramakok.f.get(str1)).add(paramMessageRecord);
                              j = i;
                            }
                            else
                            {
                              localObject3 = new ArrayList();
                              ((List)localObject3).add(paramMessageRecord);
                              paramakok.f.put(str1, localObject3);
                              j = i;
                            }
                          }
                          else if ((i == 1008) && (!njl.a(paramMessageRecord)) && (("2".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num"))) || (saz.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1))))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("EcShopAssistantManager", 2, "ecshop new msg puin: " + paramMessageRecord.senderuin + ", inter_num: " + paramMessageRecord.getExtInfoFromExtStr("inter_num"));
                            }
                            str1 = akpx.a(str1, i);
                            if (paramakok.g.containsKey(str1))
                            {
                              ((List)paramakok.g.get(str1)).add(paramMessageRecord);
                              j = i;
                            }
                            else
                            {
                              localObject3 = new ArrayList();
                              ((List)localObject3).add(paramMessageRecord);
                              paramakok.g.put(str1, localObject3);
                              j = i;
                            }
                          }
                          else if (paramMessageRecord.msgtype == -1034)
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache start");
                            }
                            j = i;
                            if (localaktf.a(str1))
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache uin " + str1);
                              }
                              ((RecentUser)localObject3).uin = str1;
                              ((RecentUser)localObject3).setType(akpx.a(((RecentUser)localObject3).getType()));
                              if (l > ((RecentUser)localObject3).lastmsgtime) {
                                ((RecentUser)localObject3).lastmsgtime = l;
                              }
                              localMap.put(akpx.a(str1, i), localObject3);
                              j = i;
                            }
                          }
                          else if ((paramMessageRecord.msgtype == -5010) && (paramMessageRecord.isSend()))
                          {
                            j = i;
                            if (paramMessageRecord.istroop != 3000)
                            {
                              j = i;
                              if (paramMessageRecord.istroop != 1)
                              {
                                j = i;
                                if (!paramMessageRecord.frienduin.equals(paramMessageRecord.selfuin))
                                {
                                  ((RecentUser)localObject3).setType(akpx.a(((RecentUser)localObject3).getType()));
                                  if (l > ((RecentUser)localObject3).lastmsgtime) {
                                    ((RecentUser)localObject3).lastmsgtime = l;
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache MSG_TYPE_DINGDONG_SCHEDULE_MSG");
                                  }
                                  localMap.put(akpx.a(str1, i), localObject3);
                                  j = i;
                                }
                              }
                            }
                          }
                          else if (((paramMessageRecord.isBlessMsg) || (paramMessageRecord.isCheckNeedShowInListTypeMsg)) && (paramMessageRecord.isSend()))
                          {
                            if ((!paramMessageRecord.isBlessMsg) || (!paramMessageRecord.needUpdateMsgTag))
                            {
                              j = i;
                              if (paramMessageRecord.isCheckNeedShowInListTypeMsg)
                              {
                                j = i;
                                if (!paramMessageRecord.needNeedShowInList) {}
                              }
                            }
                            else
                            {
                              ((RecentUser)localObject3).uin = str1;
                              ((RecentUser)localObject3).setType(0);
                              if (l > ((RecentUser)localObject3).lastmsgtime) {
                                ((RecentUser)localObject3).lastmsgtime = l;
                              }
                              if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache isBlessMsg");
                              }
                              localMap.put(akpx.a(str1, i), localObject3);
                              j = i;
                            }
                          }
                          else if ((paramMessageRecord.frienduin.equals(ajsd.ax)) && (paramMessageRecord.istroop == 0))
                          {
                            ((RecentUser)localObject3).uin = ajsd.D;
                            ((RecentUser)localObject3).setType(4000);
                            ((RecentUser)localObject3).displayName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131694632);
                            if (l > ((RecentUser)localObject3).lastmsgtime) {
                              ((RecentUser)localObject3).lastmsgtime = l;
                            }
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache MAYKNOW_RECOMMEND_UIN");
                            }
                            localMap.put(akpx.a(str1, i), localObject3);
                            j = i;
                          }
                          else if ((paramMessageRecord.frienduin.equals(ajsd.aE)) && (paramMessageRecord.istroop == 0))
                          {
                            ((RecentUser)localObject3).uin = ajsd.D;
                            ((RecentUser)localObject3).setType(4000);
                            ((RecentUser)localObject3).displayName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131694632);
                            if (l > ((RecentUser)localObject3).lastmsgtime) {
                              ((RecentUser)localObject3).lastmsgtime = l;
                            }
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache FRIEND_ANNIVER_UIN");
                            }
                            localMap.put(akpx.a(str1, i), localObject3);
                            j = i;
                          }
                          else if ((paramMessageRecord.frienduin.equals(ajsd.M)) && (paramMessageRecord.istroop == 0))
                          {
                            ((RecentUser)localObject3).uin = ajsd.D;
                            ((RecentUser)localObject3).setType(4000);
                            ((RecentUser)localObject3).displayName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131694632);
                            if (l > ((RecentUser)localObject3).lastmsgtime) {
                              ((RecentUser)localObject3).lastmsgtime = l;
                            }
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache FRIEND_SYSTEM_MSG_UIN");
                            }
                            localMap.put(akpx.a(str1, i), localObject3);
                            j = i;
                          }
                          else
                          {
                            if ((!paramMessageRecord.isLongMsg()) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord))) {
                              break label4589;
                            }
                            j = i;
                            if (QLog.isColorLevel())
                            {
                              QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
                              j = i;
                            }
                          }
                        }
                      }
                      j = i;
                    } while (arqp.b(paramMessageRecord));
                    if (i != 1044) {
                      break label4623;
                    }
                    j = i;
                  } while (str1.equals(ajsd.aT));
                  j = i;
                } while (TextUtils.equals(paramMessageRecord.senderuin, ajsd.Q));
                ((RecentUser)localObject3).uin = str1;
                if ((i != 1000) && (i != 1020))
                {
                  j = i;
                  if (i != 1004) {}
                }
                else
                {
                  if (!ahpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1)) {
                    break label4796;
                  }
                  j = 0;
                  ((RecentUser)localObject3).setType(0);
                  ((RecentUser)localObject3).troopUin = "";
                }
                for (;;)
                {
                  ((RecentUser)localObject3).setType(akpx.a(((RecentUser)localObject3).getType()));
                  bool = true;
                  if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
                    bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.jdField_d_of_type_Boolean;
                  }
                  if ((l > ((RecentUser)localObject3).lastmsgtime) && (bool)) {
                    ((RecentUser)localObject3).lastmsgtime = l;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache ELSE");
                  }
                  localMap.put(akpx.a(str1, j), localObject3);
                  break;
                  j = i;
                  if (!TextUtils.equals(str2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
                  {
                    j = i;
                    if (!TextUtils.equals(str2, str1))
                    {
                      ((RecentUser)localObject3).troopUin = str2;
                      j = i;
                    }
                  }
                }
              }
              j = 0;
            }
          }
          localObject1 = (avet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
          if (j != 6) {
            break label2868;
          }
          ((avet)localObject1).a((MessageForVideo)paramMessageRecord, true);
          ((avet)localObject1).a((MessageForVideo)paramMessageRecord);
          k = paramMessageRecord.istroop;
          if ((i != 1008) || (!njl.a(paramMessageRecord))) {
            break label4846;
          }
          j = 1;
          if (j == 0) {
            break label3222;
          }
          localObject1 = njl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, false);
          if ((localObject1 == null) || (TextUtils.isEmpty(((nis)localObject1).jdField_a_of_type_Niu.jdField_a_of_type_JavaLangString))) {
            break label2881;
          }
          njb.a().a(((nis)localObject1).jdField_a_of_type_JavaLangString);
          njb.a().a((nis)localObject1);
          paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_uin", ((nis)localObject1).jdField_a_of_type_Niu.jdField_a_of_type_JavaLangString);
          if (((nis)localObject1).jdField_a_of_type_Niu.b != null) {
            paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_name", ((nis)localObject1).jdField_a_of_type_Niu.b);
          }
          paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "false");
          paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "false");
          localObject1 = paramaukp.a(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
          if (localObject1 == null) {
            break label2907;
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject1).next();
            paramaukp.b((auko)localObject4);
            ahpd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop);
            localObject5 = localaktf.a(str1, k);
            if (localObject5 != null)
            {
              ahnl.a().a(str1 + "-" + k);
              localaktf.b((RecentUser)localObject5);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject4).senderuin, 1008, true, true);
          }
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8F", "0X8005C8F", 0, 0, "", "", "", "");
          break;
          a(ajsd.H, 1001, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          break label328;
          a(ajsd.ab, 1010, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          break label404;
          if (!(paramMessageRecord instanceof MessageForArkApp)) {
            break label580;
          }
          localObject5 = (MessageForArkApp)paramMessageRecord;
          ((SharedPreferences.Editor)localObject1).putBoolean("show_flag", true);
          try
          {
            localObject5 = new JSONObject(((MessageForArkApp)localObject5).ark_app_message.metaList).optJSONObject("weather");
            if ((localObject5 == null) || (!((JSONObject)localObject5).has("info"))) {
              break label580;
            }
            JSONObject localJSONObject = ((JSONObject)localObject5).optJSONObject("info");
            Object localObject6 = localJSONObject.optJSONObject("it1");
            if (localObject6 == null) {
              break label580;
            }
            String str3 = ((JSONObject)localObject6).optString("city");
            String str4 = ((JSONObject)localObject6).optString("temp");
            localObject6 = ((JSONObject)localObject6).optString("type");
            if (!TextUtils.isEmpty(str3)) {
              ((SharedPreferences.Editor)localObject1).putString("cur_city", str3.split("-")[0]);
            }
            if (!TextUtils.isEmpty(str4)) {
              ((SharedPreferences.Editor)localObject1).putString("cur_temp", str4);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {
              ((SharedPreferences.Editor)localObject1).putString("cur_code", (String)localObject6);
            }
            ((SharedPreferences.Editor)localObject1).putLong("pa_send_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), System.currentTimeMillis());
            if (0L != ((JSONObject)localObject5).optLong("ts")) {
              ((SharedPreferences.Editor)localObject1).putLong("pa_time_stamp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localJSONObject.optLong("ts"));
            }
            if (!QLog.isColorLevel()) {
              break label580;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "parse ark msg city: " + str3 + ", temp: " + str4 + ", code: " + (String)localObject6 + ", ts: " + localJSONObject.optLong("ts"));
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
        break label580;
        if (String.valueOf(ajsd.H).equals(paramMessageRecord.frienduin))
        {
          if ((((akpb)localObject4).a(paramMessageRecord.senderuin)) || (localMap.containsKey(akpx.a(paramMessageRecord.senderuin, paramMessageRecord.istroop)))) {
            localaktf.a(paramMessageRecord.senderuin);
          }
          k = 0;
          j = 0;
          bool = annb.a();
          if (akpx.d(paramMessageRecord))
          {
            a(paramMessageRecord, ajsd.aj, paramMessageRecord.senderuin);
            if (!bool) {
              a(paramMessageRecord, ajsd.H, ajsd.aj);
            }
            a(paramMessageRecord, ajsd.I, ajsd.aj);
            k = j;
            if (!paramMessageRecord.isread)
            {
              ((akpb)localObject4).a(1001, paramMessageRecord.senderuin);
              k = j;
            }
            label1662:
            if (k != 0) {
              break label1799;
            }
          }
          for (str1 = ajsd.I;; str1 = ajsd.H)
          {
            paramMessageRecord.frienduin = paramMessageRecord.senderuin;
            break;
            if (((akpb)localObject4).a(paramMessageRecord.frienduin, 1001, ajsd.aj)) {
              a(ajsd.aj, 1001, paramMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            j = k;
            if (annb.b(paramMessageRecord))
            {
              a(paramMessageRecord, ajsd.H, paramMessageRecord.senderuin);
              j = 1;
            }
            k = j;
            if (annb.a(paramMessageRecord.msgtype, paramMessageRecord.senderuin)) {
              break label1662;
            }
            k = j;
            if (paramMessageRecord.istroop != 1001) {
              break label1662;
            }
            a(paramMessageRecord, ajsd.I, paramMessageRecord.senderuin);
            k = j;
            break label1662;
          }
        }
        if (((akpx.a(paramMessageRecord.istroop) == 1001) && (akpx.a(paramMessageRecord.istroop, paramMessageRecord.msgtype))) || (akpx.a(paramMessageRecord.istroop) == 1010))
        {
          if ((((akpb)localObject4).a(str1)) || (localMap.containsKey(akpx.a(paramMessageRecord.frienduin, paramMessageRecord.istroop)))) {
            localaktf.a(paramMessageRecord.frienduin);
          }
          j = 0;
          i = 0;
          bool = annb.a();
          if (akpx.d(paramMessageRecord))
          {
            a(paramMessageRecord, ajsd.aj, paramMessageRecord.senderuin);
            if (!bool) {
              a(paramMessageRecord, ajsd.H, ajsd.aj);
            }
            a(paramMessageRecord, ajsd.I, ajsd.aj);
            j = i;
            if (!paramMessageRecord.isread)
            {
              ((akpb)localObject4).a(1001, paramMessageRecord.senderuin);
              j = i;
            }
            if (j != 0) {
              break label2112;
            }
          }
          for (str1 = ajsd.I;; str1 = ajsd.H)
          {
            i = paramMessageRecord.istroop;
            l = paramMessageRecord.time;
            break;
            if (((akpb)localObject4).a(paramMessageRecord.frienduin, 1001, ajsd.aj)) {
              a(ajsd.aj, 1001, paramMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            i = j;
            if (annb.b(paramMessageRecord))
            {
              a(paramMessageRecord, ajsd.H, paramMessageRecord.frienduin);
              i = 1;
            }
            j = i;
            if (annb.a(paramMessageRecord.msgtype, paramMessageRecord.senderuin)) {
              break label1971;
            }
            j = i;
            if (paramMessageRecord.istroop != 1001) {
              break label1971;
            }
            a(paramMessageRecord, ajsd.I, paramMessageRecord.frienduin);
            j = i;
            break label1971;
          }
        }
        if (!String.valueOf(ajsd.G).equals(paramMessageRecord.frienduin)) {
          break label2178;
        }
        if (!(paramMessageRecord instanceof MessageForSystemMsg)) {
          break label4852;
        }
        localObject1 = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
        if (localObject1 != null) {
          paramMessageRecord.time = ((structmsg.StructMsg)localObject1).msg_time.get();
        }
        l = paramMessageRecord.time;
      }
      if (String.valueOf(ajsd.N).equals(paramMessageRecord.frienduin))
      {
        if (!(paramMessageRecord instanceof MessageForSystemMsg)) {
          break label4855;
        }
        localObject1 = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
        if (localObject1 != null) {
          paramMessageRecord.time = ((structmsg.StructMsg)localObject1).msg_time.get();
        }
        l = paramMessageRecord.time;
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        int m = aydd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (m > 0)
        {
          k = 0;
          j = k;
          if (!paramMessageRecord.isSendFromLocal())
          {
            j = k;
            if (paramMessageRecord.time < ((QQMessageFacade.Message)localObject1).time) {
              j = 1;
            }
          }
          if (j == 0)
          {
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject1, paramMessageRecord);
            ((QQMessageFacade.Message)localObject1).msgData = paramMessageRecord.msgData;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c((QQMessageFacade.Message)localObject1);
          }
        }
        for (;;)
        {
          try
          {
            a((QQMessageFacade.Message)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = m;
          }
          catch (Throwable localThrowable1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", localThrowable1);
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c(null);
        }
        if (ajsd.O.equals(paramMessageRecord.frienduin))
        {
          afoo.a(this, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          l = paramMessageRecord.time;
          break;
        }
        Object localObject2;
        if (ajsd.E.equals(paramMessageRecord.frienduin))
        {
          try
          {
            localObject2 = paramaukp.a(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                paramaukp.b((MessageRecord)((Iterator)localObject2).next());
              }
            }
          }
          finally {}
          break;
        }
        if ((String.valueOf(ajsd.ax).equals(paramMessageRecord.frienduin)) || (ajsd.aE.equals(paramMessageRecord.frienduin)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
          localObject4 = (akbn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
          ((QQMessageFacade.Message)localObject2).istroop = paramMessageRecord.istroop;
          ((akbn)localObject4).a(false);
          m = ((akbn)localObject4).d();
          if (m > 0)
          {
            k = 0;
            j = k;
            if (!paramMessageRecord.isSendFromLocal())
            {
              j = k;
              if (paramMessageRecord.time < ((QQMessageFacade.Message)localObject2).time) {
                j = 1;
              }
            }
            if (j == 0)
            {
              MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, paramMessageRecord);
              ((QQMessageFacade.Message)localObject2).msgData = paramMessageRecord.msgData;
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c((QQMessageFacade.Message)localObject2);
            }
          }
          for (;;)
          {
            try
            {
              a((QQMessageFacade.Message)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = m;
            }
            catch (Throwable localThrowable2)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", localThrowable2);
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c(null);
          }
        }
        if (akpx.a(paramMessageRecord.istroop) == 1032)
        {
          if (amnr.b(paramMessageRecord)) {
            a(paramMessageRecord, ajsd.aM, paramMessageRecord.frienduin);
          }
          str1 = ajsd.aM;
          l = paramMessageRecord.time;
          i = 1032;
          break;
        }
        if (akpx.a(paramMessageRecord.istroop) == 1044)
        {
          if (((((akpb)localObject4).a(paramMessageRecord.senderuin)) || (localMap.containsKey(akpx.a(paramMessageRecord.senderuin, paramMessageRecord.istroop)))) && (!ahpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.senderuin))) {
            localaktf.a(paramMessageRecord.senderuin);
          }
          a(paramMessageRecord, ajsd.aT, paramMessageRecord.frienduin);
          str1 = ajsd.aT;
          l = paramMessageRecord.time;
          i = 1044;
          break;
        }
        Object localObject3;
        break;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in SubThread!");
      }
    }
    for (;;)
    {
      ((akaw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).b(paramMessageRecord);
      super.a(paramMessageRecord, paramBoolean1, paramBoolean2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in MainThread!");
      }
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if (paramInt == 1038)
    {
      paramString = (akwp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(148);
      if (paramString != null) {
        paramString.b();
      }
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, akqr paramakqr, ArrayList<MessageRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageManager", 2, String.format("loadFromLocalConfess uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramakqr.jdField_f_of_type_Int) }));
    }
    String str = amnr.a(paramString, paramInt1, paramakqr.jdField_f_of_type_Int);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    long l1;
    if (paramLong > 0L)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramLong);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
      localObject3 = new StringBuilder().append("loadFromLocal uniseq=").append(paramLong).append(",count=").append(paramInt2).append(", fromtime=");
      if (localObject1 == null)
      {
        paramLong = -1L;
        ((QQMessageFacade)localObject2).a(paramLong, "");
        if (localObject1 == null) {
          break label726;
        }
        l1 = ((MessageRecord)localObject1).time;
        paramLong = ((MessageRecord)localObject1).getId();
      }
    }
    for (;;)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
      localObject2 = new ArrayList();
      label201:
      MessageRecord localMessageRecord;
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
          if (TextUtils.equals(str, amnr.a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getConfessTopicId()))) {
            if ((localMessageRecord.time <= l1) && ((localObject1 == null) || (!akpx.a((MessageRecord)localObject1, localMessageRecord, true)))) {
              break label664;
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("loadFromLocal load from Cache", (Collection)localObject2);
      }
      long l2;
      if ((paramArrayList.size() < paramInt2) && (((List)localObject2).size() > 0))
      {
        paramArrayList.addAll(0, ((List)localObject2).subList(Math.max(((List)localObject2).size() - (paramInt2 - paramArrayList.size()), 0), ((List)localObject2).size()));
        if (paramArrayList.size() > 0)
        {
          l1 = Math.min(l1, ((MessageRecord)paramArrayList.get(0)).time);
          l2 = Math.max(Math.min(paramLong, ((MessageRecord)paramArrayList.get(0)).getId()), 0L);
          paramLong = l1;
          l1 = l2;
          l2 = paramLong;
          paramLong = l1;
        }
      }
      for (;;)
      {
        if (paramArrayList.size() < paramInt2)
        {
          int i = amnr.a(paramInt1, paramakqr.jdField_f_of_type_Int) << 3;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(String.format(" and (extLong & 4194296)=%d", new Object[] { Integer.valueOf(i) }));
          ((StringBuilder)localObject1).append(String.format(" or (time=%d and _id<%d and (extLong & 4194296)=%d) ", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Integer.valueOf(i) }));
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramLong, 3, l2, paramInt2, ((StringBuilder)localObject1).toString());
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("queryTimedMessageDBUnion list size" + ((List)localObject1).size() + ", getID=" + paramLong, "");
          if (!((List)localObject1).isEmpty()) {
            break label677;
          }
          paramakqr.jdField_a_of_type_Boolean = true;
        }
        for (;;)
        {
          paramakqr.jdField_c_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageManager", 2, String.format("loadFromLocalConfess uin:%s type:%d topicId:%d findCount:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramakqr.jdField_f_of_type_Int), Integer.valueOf(paramArrayList.size()) }));
          }
          return;
          paramLong = ((MessageRecord)localObject1).time;
          break;
          label664:
          ((List)localObject2).add(localMessageRecord);
          break label201;
          label677:
          if (((List)localObject1).size() < paramInt2) {
            paramakqr.jdField_a_of_type_Boolean = true;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("loadFromLocal load from DB", (Collection)localObject1);
          paramArrayList.addAll(0, (Collection)localObject1);
        }
        l2 = l1;
      }
      label726:
      paramLong = 9223372036854775807L;
      l1 = 9223372036854775807L;
      continue;
      localObject1 = null;
      paramLong = 9223372036854775807L;
      l1 = 9223372036854775807L;
    }
  }
  
  public void a(String paramString, int paramInt, akqr paramakqr, akou paramakou, FragmentActivity paramFragmentActivity)
  {
    paramakqr.jdField_f_of_type_Boolean = false;
    paramakqr.jdField_d_of_type_Boolean = true;
    paramakqr.jdField_a_of_type_JavaLangString = paramString;
    paramakqr.jdField_d_of_type_Int = paramInt;
    if ((!paramakqr.i) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilMap.containsKey(akpx.a(paramString, paramInt))))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramakqr);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilMap.put(akpx.a(paramString, paramInt), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new C2CMessageManager.2(this, paramakqr, paramInt, paramString, paramakou, paramFragmentActivity));
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("success");
    boolean bool2 = paramBundle.getBoolean("complete");
    List localList = (List)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramBundle.getInt("counter")));
    paramBundle.putBoolean("timeout", false);
    long l1 = paramBundle.getLong("baseTime");
    long l2 = paramBundle.getLong("lowTime");
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
    Object localObject = new StringBuilder().append("setC2CRoamMessageResult success=").append(bool1).append(",complete=").append(bool2).append(",res_size=");
    if (paramList1 == null)
    {
      paramInt = -1;
      paramBundle.a(paramInt + ",baseT=" + l1 + ",lowTime=" + l2, "");
      if (paramList1 != null) {
        break label526;
      }
    }
    label526:
    for (paramBundle = new ArrayList();; paramBundle = paramList1)
    {
      paramList1 = paramList2;
      if (paramList2 == null) {
        paramList1 = new ArrayList();
      }
      if (bool1)
      {
        paramList2 = a(paramString, paramBundle, l1, l2);
        if ((localList != null) && (!localList.isEmpty()))
        {
          l1 = ((MessageRecord)localList.get(0)).time;
          paramString = new ArrayList();
          paramBundle = localList.iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              localObject = (MessageRecord)paramBundle.next();
              if (((MessageRecord)localObject).time == l1)
              {
                paramString.add(localObject);
                continue;
                paramInt = paramList1.size();
                break;
              }
            }
          }
          paramList2 = paramList2.iterator();
          paramInt = 0;
          if (!paramList2.hasNext()) {
            break label446;
          }
          paramBundle = (MessageRecord)paramList2.next();
          localObject = paramString.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!akpx.a((MessageRecord)((Iterator)localObject).next(), paramBundle, true));
        }
      }
      for (int j = 1;; j = 0)
      {
        int i = paramInt;
        if (localList != null)
        {
          i = paramInt;
          if (j == 0)
          {
            localList.add(paramInt, paramBundle);
            i = paramInt + 1;
            paramList1.add(paramBundle);
          }
        }
        paramInt = i;
        break;
        if (localList != null) {
          localList.addAll(paramList2);
        }
        label446:
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
        paramList1 = new StringBuilder().append("setC2CRoamMessageResult locallist:");
        if (localList == null) {}
        for (paramInt = -1;; paramInt = localList.size())
        {
          paramString.a(paramInt, "");
          if (localList != null) {}
          try
          {
            localList.notify();
            return;
          }
          finally {}
        }
      }
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, akqr paramakqr)
  {
    if ((paramInt1 != 0) && (paramInt1 != 1000) && (paramInt1 != 1004) && (paramInt1 != 9501) && (paramInt1 != 1044))
    {
      if (paramInt1 == 1008)
      {
        c(paramString, paramInt1, paramInt2, paramakqr);
        return;
      }
      if ((akpx.a(paramInt1) == 1032) && (paramakqr.jdField_f_of_type_Int > 0))
      {
        paramakqr.jdField_c_of_type_Boolean = true;
        d(paramString, paramInt1, paramInt2, paramakqr);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead TYPE ERROR! TYPE = " + paramInt1);
      }
      paramakqr.jdField_a_of_type_Boolean = true;
      paramakqr.jdField_a_of_type_JavaUtilList = null;
      a(paramakqr, paramInt1);
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).e(paramString, paramInt1);
    if ((localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
      }
      paramakqr.jdField_a_of_type_JavaUtilList = null;
      a(paramakqr, paramInt1);
      return;
    }
    if (localObject3 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("current Aio", ((List)localObject3).subList(0, Math.min(paramInt2, ((List)localObject3).size())));
    }
    long l2 = ((MessageRecord)((List)localObject3).get(0)).uniseq;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString);
    long l1;
    Object localObject4;
    ArrayList localArrayList;
    int i;
    if (localObject1 == null)
    {
      l1 = 0L;
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
      localArrayList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refreshC2CMessageListHead isLocalOnly=" + paramakqr.jdField_c_of_type_Boolean + ",uniseq=" + l2 + ",ect=" + l1, " ,getC2CRoamingSetting" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e() == 0) {
        paramakqr.jdField_c_of_type_Boolean = true;
      }
      i = 0;
      label386:
      if (i >= ((List)localObject3).size()) {
        break label2780;
      }
      if (((MessageRecord)((List)localObject3).get(i)).uniseq != l2) {
        break label670;
      }
      label419:
      if (i >= ((List)localObject3).size()) {
        break label2774;
      }
      if (!akpx.f(((MessageRecord)((List)localObject3).get(i)).msgtype)) {
        break label661;
      }
      l2 = ((MessageRecord)((List)localObject3).get(i)).uniseq;
      i = 1;
    }
    for (;;)
    {
      if ((paramakqr.jdField_c_of_type_Boolean) || (l1 == 0L) || (i == 0))
      {
        b(paramString, paramInt1, l2, paramInt2, paramakqr, localArrayList);
        a(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, localArrayList);
        paramakqr.jdField_a_of_type_JavaUtilList = localArrayList;
        if (paramakqr.jdField_a_of_type_Boolean) {
          b(paramString, paramInt1);
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
        localObject1 = new StringBuilder().append("refresh load local C2C msg only FIN , context = ").append(paramakqr).append(", size = ");
        if (localArrayList == null) {}
        for (paramInt2 = -1;; paramInt2 = localArrayList.size())
        {
          paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
          if ((!akpx.c(localArrayList)) || (paramakqr.jdField_c_of_type_Int >= 3)) {
            break label688;
          }
          a(paramakqr, paramInt1);
          return;
          l1 = ((Long)((Pair)localObject1).first).longValue();
          break;
          label661:
          i += 1;
          break label419;
          label670:
          i += 1;
          break label386;
        }
        label688:
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramakqr);
        return;
      }
      i = 0;
      if (i < ((List)localObject4).size())
      {
        localObject1 = (MessageRecord)((List)localObject4).get(i);
        if (((MessageRecord)localObject1).uniseq != l2) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead cacheIndex:" + i + ", itemList:" + ((List)localObject4).size());
        }
        long l3;
        if (localObject1 == null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2);
          if (localObject1 == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh from empty C2C msg", "");
            paramakqr.jdField_a_of_type_Boolean = true;
            paramakqr.jdField_c_of_type_Boolean = true;
            paramakqr.jdField_a_of_type_JavaUtilList = new ArrayList();
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramakqr);
            return;
            i += 1;
            break;
          }
          l3 = ((MessageRecord)localObject1).time;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refreshC2CMessageListHead uniseq=" + l2 + ", aioBase.getId():" + ((MessageRecord)localObject1).getId(), "");
          localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l3, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(((MessageRecord)localObject1).getId()) })));
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refreshC2CMessageListHead Db fromTime:" + l3, "");
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("only load in db", localArrayList);
          l2 = l3;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead locallist size " + localArrayList.size());
          }
          if (l1 <= l2) {
            break label2759;
          }
          l1 = Math.min(l2, paramakqr.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("ect > fromTime!! newEct:" + l1, "");
        }
        label2749:
        label2759:
        for (boolean bool1 = false;; bool1 = true)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("before pull locallist", localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("before pull locallist" + localArrayList.size(), "");
          if (localArrayList.size() < paramInt2)
          {
            localObject4 = new Bundle();
            i = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
            ((Bundle)localObject4).putInt("counter", i);
            ((Bundle)localObject4).putBoolean("timeout", true);
            ((Bundle)localObject4).putLong("UIN", Long.valueOf(paramString).longValue());
            ((Bundle)localObject4).putBoolean("canUpdateEct", bool1);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), localArrayList);
            Object localObject5 = new ArrayList();
            i = 0;
            Object localObject6;
            while (i < ((List)localObject3).size())
            {
              localObject6 = (MessageRecord)((List)localObject3).get(i);
              if (((MessageRecord)localObject6).time == ((MessageRecord)localObject1).time)
              {
                ((ArrayList)localObject5).add(localObject6);
                i += 1;
                continue;
                l2 = ((MessageRecord)localObject1).time;
                if (i >= paramInt2)
                {
                  j = i - paramInt2;
                  while (j < i)
                  {
                    localObject5 = (MessageRecord)((List)localObject4).get(j);
                    if (((MessageRecord)localObject5).time >= l1) {
                      localArrayList.add(localObject5);
                    }
                    j += 1;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("all in cache", localArrayList);
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead fromTime:" + l2);
                  }
                  break;
                  localObject5 = (MessageRecord)((List)localObject4).get(0);
                  localObject4 = ((List)localObject4).subList(0, i).iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject6 = (MessageRecord)((Iterator)localObject4).next();
                    if (((MessageRecord)localObject6).time >= l1) {
                      localArrayList.add(localObject6);
                    }
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("cache part", localArrayList);
                  i = paramInt2 - localArrayList.size();
                  localArrayList.addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, ((MessageRecord)localObject5).time, i, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l1), Long.valueOf(((MessageRecord)localObject5).time), Long.valueOf(((MessageRecord)localObject5).getId()) })));
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("cache + db", localArrayList);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead memdb:size:" + localArrayList.size() + ",miss:" + i);
                  }
                }
              }
            }
            l2 = ((MessageRecord)localObject1).uniseq;
            i = localArrayList.size();
            if (localArrayList.isEmpty()) {
              i = paramInt2;
            }
            for (;;)
            {
              ((Bundle)localObject4).putLong("baseTime", l1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "pull roam " + i + ",time=" + l1 + ",timeFilterList:" + ((ArrayList)localObject5).size());
              }
              l3 = 0L;
              if (!bool1) {
                l3 = paramakqr.b;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, l1, (short)i, (Bundle)localObject4, l3);
              ((Bundle)localObject4).putInt("size_req", i);
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(akpx.a(paramString, paramInt1), Boolean.valueOf(false));
              try
              {
                localArrayList.wait(35000L);
                if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(akpx.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(akpx.a(paramString, paramInt1))).booleanValue()))
                {
                  paramakqr.jdField_a_of_type_JavaUtilList = null;
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("get auto pull C2C msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramakqr);
                  return;
                  i = paramInt2 - i;
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
            if ((((Bundle)localObject4).getBoolean("timeout")) && (QLog.isColorLevel())) {
              QLog.w("Q.msg.BaseMessageManager", 2, "timeout!");
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("after pull locallist" + localArrayList.size(), "");
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("after pull locallist", localArrayList);
            localObject2 = new ArrayList();
            int j = localArrayList.size() - 1;
            while (j >= 0)
            {
              localObject3 = (MessageRecord)localArrayList.get(j);
              localObject6 = ((ArrayList)localObject5).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject6).next();
                if (akpx.a(localMessageRecord, (MessageRecord)localObject3, true))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead filterMr " + localMessageRecord.getLogColorContent() + ",uniseq=" + localMessageRecord.uniseq);
                  }
                  ((ArrayList)localObject2).add(localObject3);
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead not find filterMr " + localMessageRecord.getLogColorContent() + ",mr=" + ((MessageRecord)localObject3).getLogColorContent());
                }
              }
              j -= 1;
            }
            localArrayList.removeAll((Collection)localObject2);
            if (((Bundle)localObject4).getBoolean("timeout")) {
              break label2680;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead " + localArrayList.size());
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2, localArrayList);
            boolean bool2 = ((Bundle)localObject4).getBoolean("success");
            boolean bool3 = ((Bundle)localObject4).getBoolean("complete");
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.BaseMessageManager", 2, "success ?" + bool2 + ", complete?" + bool3);
            }
            if ((!bool2) || (bool3))
            {
              paramakqr.jdField_c_of_type_Boolean = true;
              if (!localArrayList.isEmpty()) {
                break label2652;
              }
              if (!localArrayList.isEmpty()) {
                break label2669;
              }
              label2385:
              b(paramString, paramInt1, l2, paramInt2, paramakqr, localArrayList);
            }
            if (!bool1)
            {
              paramakqr.jdField_a_of_type_Long = ((Bundle)localObject4).getLong("tempEct");
              paramakqr.b = ((Bundle)localObject4).getLong("tempRandom");
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("update tempEct:" + paramakqr.jdField_a_of_type_Long + ", rand=" + paramakqr.b, "");
            }
          }
          a(localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, localArrayList);
          paramakqr.jdField_a_of_type_JavaUtilList = localArrayList;
          if (paramakqr.jdField_a_of_type_Boolean) {
            b(paramString, paramInt1);
          }
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
          localObject2 = new StringBuilder().append("refresh C2C finish , context = ").append(paramakqr).append(" , size = ");
          if (localArrayList == null) {}
          for (paramInt2 = -1;; paramInt2 = localArrayList.size())
          {
            paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
            if ((!akpx.c(localArrayList)) || (paramakqr.jdField_c_of_type_Int >= 3)) {
              break label2749;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramakqr.jdField_c_of_type_Int);
            }
            a(paramakqr, paramInt1);
            return;
            label2652:
            l2 = ((MessageRecord)localArrayList.get(0)).uniseq;
            break;
            label2669:
            paramInt2 -= localArrayList.size();
            break label2385;
            label2680:
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("pull timeout", "");
            paramakqr.jdField_c_of_type_Boolean = true;
            if (localArrayList.isEmpty()) {}
            for (;;)
            {
              b(paramString, paramInt1, l2, i, paramakqr, localArrayList);
              break;
              l2 = ((MessageRecord)localArrayList.get(0)).uniseq;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramakqr);
          return;
        }
        i = 0;
        Object localObject2 = null;
      }
      label2774:
      i = 0;
      continue;
      label2780:
      i = 0;
    }
  }
  
  public void b(String paramString, int paramInt1, long paramLong, int paramInt2, akqr paramakqr, ArrayList<MessageRecord> paramArrayList)
  {
    MessageRecord localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramLong);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
    Object localObject2 = new StringBuilder().append("loadFromLocal uniseq=").append(paramLong).append(",count=").append(paramInt2).append(", fromtime=");
    label140:
    MessageRecord localMessageRecord2;
    if (localMessageRecord1 == null)
    {
      paramLong = -1L;
      ((QQMessageFacade)localObject1).a(paramLong, "");
      if (localMessageRecord1 == null) {
        break label517;
      }
      long l3 = localMessageRecord1.time;
      long l2 = localMessageRecord1.getId();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localMessageRecord2 = (MessageRecord)((Iterator)localObject2).next();
          if ((localMessageRecord2.time <= l3) && (!akpx.a(localMessageRecord1, localMessageRecord2, true))) {
            break label465;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("loadFromLocal load from Cache", (Collection)localObject1);
      }
      long l1 = l2;
      paramLong = l3;
      if (paramArrayList.size() < paramInt2)
      {
        l1 = l2;
        paramLong = l3;
        if (((List)localObject1).size() > 0)
        {
          paramArrayList.addAll(0, ((List)localObject1).subList(Math.max(((List)localObject1).size() - (paramInt2 - paramArrayList.size()), 0), ((List)localObject1).size()));
          l1 = l2;
          paramLong = l3;
          if (paramArrayList.size() > 0)
          {
            paramLong = Math.min(l3, ((MessageRecord)paramArrayList.get(0)).time);
            l1 = Math.max(Math.min(l2, ((MessageRecord)paramArrayList.get(0)).getId()), 0L);
          }
        }
      }
      if (paramArrayList.size() < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l1, localMessageRecord1.versionCode, paramLong, paramInt2, String.format(" or (time=%d and _id<%d) ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) }));
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("queryTimedMessageDBUnion list size" + paramString.size() + ", getID=" + localMessageRecord1.getId(), "");
        if (!paramString.isEmpty()) {
          break label478;
        }
        paramakqr.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      paramakqr.jdField_c_of_type_Boolean = true;
      return;
      paramLong = localMessageRecord1.time;
      break;
      label465:
      ((List)localObject1).add(localMessageRecord2);
      break label140;
      label478:
      if (paramString.size() < paramInt2) {
        paramakqr.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("loadFromLocal load from DB", paramString);
      paramArrayList.addAll(0, paramString);
    }
    label517:
    paramakqr.jdField_c_of_type_Boolean = true;
    paramakqr.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("loadFromLocal complete", "");
  }
  
  protected boolean b(String paramString)
  {
    paramString = ((akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(paramString);
    if (paramString != null) {
      return paramString.isVisible();
    }
    return true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilMap.remove(ajsd.H);
    String str = ajsd.H;
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1001).a(str, 1001).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (!annb.b(localMessageRecord)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localMessageRecord.istroop).a(ajsd.H, localMessageRecord.istroop, localMessageRecord.senderuin + "", localMessageRecord.selfuin + "", localMessageRecord.getExtraKey());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(str, 1001);
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    ThreadManager.post(new C2CMessageManager.1(this, paramMessageRecord), 8, null, true);
  }
  
  public void c(String paramString, int paramInt1, int paramInt2, akqr paramakqr)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).e(paramString, paramInt1);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
      }
      paramakqr.jdField_a_of_type_JavaUtilList = null;
      a(paramakqr, paramInt1);
    }
    long l;
    do
    {
      return;
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("current Aio", ((List)localObject).subList(0, Math.min(15, ((List)localObject).size())));
      }
      l = ((MessageRecord)((List)localObject).get(0)).uniseq;
      localObject = new ArrayList();
      paramakqr.jdField_c_of_type_Boolean = true;
    } while (!paramakqr.jdField_c_of_type_Boolean);
    b(paramString, paramInt1, l, paramInt2, paramakqr, (ArrayList)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, (List)localObject);
    paramakqr.jdField_a_of_type_JavaUtilList = ((List)localObject);
    if (sgg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString))
    {
      if ((paramakqr.jdField_a_of_type_JavaUtilList == null) || (paramakqr.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        l = nnu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a(paramString, l, 1);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X8005C99", "0X8005C99", 0, 1, 0, "new", "2", "", "");
        return;
      }
      paramakqr.jdField_a_of_type_Boolean = false;
      paramakqr.g = false;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
    StringBuilder localStringBuilder = new StringBuilder().append("refresh load local C2C msg only FIN , context = ").append(paramakqr).append(", size = ");
    if (localObject == null) {}
    for (paramInt1 = -1;; paramInt1 = ((ArrayList)localObject).size())
    {
      paramString.a(paramInt1, ", timestamp = " + System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramakqr);
      return;
    }
  }
  
  public void d(String paramString, int paramInt1, int paramInt2, akqr paramakqr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageManager", 2, String.format("doRefreshMessageListHead_Confess uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramakqr.jdField_f_of_type_Int) }));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).e(paramString, paramInt1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        if (((MessageRecord)((List)localObject).get(i)).getConfessTopicId() != paramakqr.jdField_f_of_type_Int) {
          ((List)localObject).remove(i);
        }
        i -= 1;
      }
    }
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("current Aio", ((List)localObject).subList(0, Math.min(paramInt2, ((List)localObject).size())));
    }
    if ((localObject != null) && (((List)localObject).size() > 0)) {}
    for (long l = ((MessageRecord)((List)localObject).get(0)).uniseq;; l = 0L)
    {
      localObject = new ArrayList();
      a(paramString, paramInt1, l, paramInt2, paramakqr, (ArrayList)localObject);
      a((List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, (List)localObject);
      paramakqr.jdField_a_of_type_JavaUtilList = ((List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramakqr);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akot
 * JD-Core Version:    0.7.0.1
 */