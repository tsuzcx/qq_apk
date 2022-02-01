import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.C2CMessageManager.1;
import com.tencent.imcore.message.C2CMessageManager.2;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UinType;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.BaseRecentUser;
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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
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
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class abwe
  extends BaseMessageManager
{
  public abwe(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, abww paramabww)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramabww);
  }
  
  private int a(MessageRecord paramMessageRecord, abvu paramabvu, Map<String, RecentUser> paramMap, anuz paramanuz, String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    RecentUser localRecentUser = a(paramMap, paramanuz, paramString1, paramInt1, paramInt2, paramBoolean);
    if ((abwz.h(paramMessageRecord.msgtype)) || ((paramInt1 == 1008) && (!c(paramString1)))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return paramInt1;
              } while (bily.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord));
              if (paramString1.equals(AppConstants.NEARBY_LBS_HELLO_UIN))
              {
                QLog.i("Q.msg.BaseMessageManager.NEARBY_MSG", 2, "mr.senderUin = " + paramMessageRecord.senderuin);
                return paramInt1;
              }
              if ((paramInt1 == 1009) && (paramString1.equals(AppConstants.SAME_STATE_BOX_UIN)))
              {
                if (paramLong > localRecentUser.lastmsgtime) {
                  localRecentUser.lastmsgtime = paramLong;
                }
                localRecentUser.setType(abwz.a(localRecentUser.getType()));
                paramanuz.saveRecentUser(localRecentUser);
                return paramInt1;
              }
              if ((paramInt1 == 1032) && (paramString1.equals(AppConstants.CONFESS_UIN)))
              {
                if ((paramLong > localRecentUser.lastmsgtime) && (apse.b(paramMessageRecord))) {
                  localRecentUser.lastmsgtime = paramLong;
                }
                localRecentUser.setType(abwz.a(localRecentUser.getType()));
                paramanuz.saveRecentUser(localRecentUser);
                return paramInt1;
              }
              if ((paramInt1 == 1008) && (!nyj.a(paramMessageRecord)) && ((uda.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1)) || ("1".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num")))))
              {
                paramMap = abwz.a(paramString1, paramInt1);
                if (paramabvu.f.containsKey(paramMap))
                {
                  ((List)paramabvu.f.get(paramMap)).add(paramMessageRecord);
                  return paramInt1;
                }
                paramanuz = new ArrayList();
                paramanuz.add(paramMessageRecord);
                paramabvu.f.put(paramMap, paramanuz);
                return paramInt1;
              }
              if ((paramInt1 == 1008) && (!nyj.a(paramMessageRecord)) && (("2".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num"))) || (uaw.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1))))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("EcShopAssistantManager", 2, "ecshop new msg puin: " + paramMessageRecord.senderuin + ", inter_num: " + paramMessageRecord.getExtInfoFromExtStr("inter_num"));
                }
                paramMap = abwz.a(paramString1, paramInt1);
                if (paramabvu.g.containsKey(paramMap))
                {
                  ((List)paramabvu.g.get(paramMap)).add(paramMessageRecord);
                  return paramInt1;
                }
                paramanuz = new ArrayList();
                paramanuz.add(paramMessageRecord);
                paramabvu.g.put(paramMap, paramanuz);
                return paramInt1;
              }
              if (paramMessageRecord.msgtype != -1034) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache start");
              }
            } while (!paramanuz.isUinInRecent(paramString1));
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache uin " + paramString1);
            }
            localRecentUser.uin = paramString1;
            localRecentUser.setType(abwz.a(localRecentUser.getType()));
            if (paramLong > localRecentUser.lastmsgtime) {
              localRecentUser.lastmsgtime = paramLong;
            }
            paramMap.put(abwz.a(paramString1, paramInt1), localRecentUser);
            return paramInt1;
            if ((paramMessageRecord.msgtype != -5010) || (!paramMessageRecord.isSend())) {
              break;
            }
          } while ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.frienduin.equals(paramMessageRecord.selfuin)));
          localRecentUser.setType(abwz.a(localRecentUser.getType()));
          if (paramLong > localRecentUser.lastmsgtime) {
            localRecentUser.lastmsgtime = paramLong;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache MSG_TYPE_DINGDONG_SCHEDULE_MSG");
          }
          paramMap.put(abwz.a(paramString1, paramInt1), localRecentUser);
          return paramInt1;
          if (((!paramMessageRecord.isBlessMsg) && (!paramMessageRecord.isCheckNeedShowInListTypeMsg)) || (!paramMessageRecord.isSend())) {
            break;
          }
        } while (((!paramMessageRecord.isBlessMsg) || (!paramMessageRecord.needUpdateMsgTag)) && ((!paramMessageRecord.isCheckNeedShowInListTypeMsg) || (!paramMessageRecord.needNeedShowInList)));
        localRecentUser.uin = paramString1;
        localRecentUser.setType(0);
        if (paramLong > localRecentUser.lastmsgtime) {
          localRecentUser.lastmsgtime = paramLong;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache isBlessMsg");
        }
        paramMap.put(abwz.a(paramString1, paramInt1), localRecentUser);
        return paramInt1;
        if ((paramMessageRecord.frienduin.equals(AppConstants.MAYKNOW_RECOMMEND_UIN)) && (paramMessageRecord.istroop == 0))
        {
          localRecentUser.uin = AppConstants.RECOMMEND_CONTACT_UIN;
          localRecentUser.setType(4000);
          localRecentUser.displayName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131694083);
          if (paramLong > localRecentUser.lastmsgtime) {
            localRecentUser.lastmsgtime = paramLong;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache MAYKNOW_RECOMMEND_UIN");
          }
          paramMap.put(abwz.a(paramString1, paramInt1), localRecentUser);
          return paramInt1;
        }
        if ((paramMessageRecord.frienduin.equals(AppConstants.FRIEND_ANNIVER_UIN)) && (paramMessageRecord.istroop == 0))
        {
          localRecentUser.uin = AppConstants.RECOMMEND_CONTACT_UIN;
          localRecentUser.setType(4000);
          localRecentUser.displayName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131694083);
          if (paramLong > localRecentUser.lastmsgtime) {
            localRecentUser.lastmsgtime = paramLong;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache FRIEND_ANNIVER_UIN");
          }
          paramMap.put(abwz.a(paramString1, paramInt1), localRecentUser);
          return paramInt1;
        }
        if ((paramMessageRecord.frienduin.equals(AppConstants.FRIEND_SYSTEM_MSG_UIN)) && (paramMessageRecord.istroop == 0))
        {
          localRecentUser.uin = AppConstants.RECOMMEND_CONTACT_UIN;
          localRecentUser.setType(4000);
          localRecentUser.displayName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131694083);
          if (paramLong > localRecentUser.lastmsgtime) {
            localRecentUser.lastmsgtime = paramLong;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache FRIEND_SYSTEM_MSG_UIN");
          }
          paramMap.put(abwz.a(paramString1, paramInt1), localRecentUser);
          return paramInt1;
        }
        if ((!paramMessageRecord.isLongMsg()) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramMessageRecord))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
      return paramInt1;
    } while ((auyo.b(paramMessageRecord)) || ((paramInt1 == 1044) && (paramString1.equals(AppConstants.MATCH_CHAT_UIN))) || (TextUtils.equals(paramMessageRecord.senderuin, AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN)) || ((paramInt1 == 10008) && (paramString1.equals(AppConstants.QCIRCLE_CHAT_UIN))));
    localRecentUser.uin = paramString1;
    if ((paramInt1 != 1000) && (paramInt1 != 1020))
    {
      paramInt2 = paramInt1;
      if (paramInt1 != 1004) {}
    }
    else
    {
      if (!akms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) {
        break label1444;
      }
      paramInt2 = 0;
      localRecentUser.setType(0);
      localRecentUser.troopUin = "";
    }
    for (;;)
    {
      localRecentUser.setType(abwz.a(localRecentUser.getType()));
      paramBoolean = true;
      if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
        paramBoolean = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
      }
      if ((paramLong > localRecentUser.lastmsgtime) && (paramBoolean)) {
        localRecentUser.lastmsgtime = paramLong;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache ELSE");
      }
      paramMap.put(abwz.a(paramString1, paramInt2), localRecentUser);
      return paramInt2;
      label1444:
      paramInt2 = paramInt1;
      if (!TextUtils.equals(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
      {
        paramInt2 = paramInt1;
        if (!TextUtils.equals(paramString2, paramString1))
        {
          localRecentUser.troopUin = paramString2;
          paramInt2 = paramInt1;
        }
      }
    }
  }
  
  private long a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramString);
    if (paramString == null) {
      return 0L;
    }
    return ((Long)paramString.first).longValue();
  }
  
  private long a(boolean paramBoolean, long paramLong)
  {
    long l = paramLong;
    if (paramBoolean) {
      l = Math.max(paramLong, NetConnInfoCenter.getServerTime() - 86400L);
    }
    return l;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.time, paramMessageRecord.senderuin, paramMessageRecord.msg);
  }
  
  private RecentUser a(Map<String, RecentUser> paramMap, anuz paramanuz, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 != 1032) {}
    for (paramanuz = (RecentUser)paramanuz.findRecentUserByUin(paramString, paramInt2);; paramanuz = (RecentUser)paramanuz.findRecentUserByUin(paramString, paramInt1))
    {
      if (paramBoolean) {
        paramanuz.lFlag = 16L;
      }
      paramString = paramanuz;
      if (paramMap.containsKey(abwz.a(paramanuz.uin, paramanuz.getType()))) {
        paramString = (RecentUser)paramMap.get(abwz.a(paramanuz.uin, paramanuz.getType()));
      }
      return paramString;
    }
  }
  
  private ArrayList<MessageRecord> a(String paramString, List<MessageRecord> paramList1, List<MessageRecord> paramList2, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("C2CMsgFilter basetime=" + paramLong1 + ",lowtime=" + paramLong2, "");
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
        break label783;
      }
      l2 = ((MessageRecord)localObject2).time;
    }
    label395:
    label783:
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
          localMessageRecord1 = bbli.a(-1000);
          localMessageRecord2 = bbli.a(-1000);
          paramList1 = paramList1.iterator();
        }
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
                if (abwz.a((MessageRecord)localObject3, localMessageRecord3, true)) {
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
              break label778;
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
            break label395;
            if ((paramLong1 > 0L) && (localObject1 != null))
            {
              localMessageRecord1.time = paramLong2;
              localMessageRecord2.time = paramLong1;
              paramString = b(paramString, 0, paramLong2, paramLong1).iterator();
              while (paramString.hasNext())
              {
                paramList1 = (MessageRecord)paramString.next();
                if ((!abwz.g(paramList1.msgtype)) && (paramList1.time <= paramLong1))
                {
                  this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("addmsg ptt = " + paramList1.getId(), "");
                  abwz.b((List)localObject1, paramList1, true);
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
  
  @NotNull
  private ArrayList<MessageRecord> a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (localMessageRecord.time != paramMessageRecord.time) {
        break;
      }
      localArrayList.add(localMessageRecord);
      i += 1;
    }
    return localArrayList;
  }
  
  private List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, abwf paramabwf)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).f(paramString, paramInt1);
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.resultMsgList = null;
      a(paramRefreshMessageContext, paramInt1);
      paramString = paramRefreshMessageContext.resultMsgList;
      return paramString;
    }
    if (localObject2 != null) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("current Aio", ((List)localObject2).subList(0, Math.min(paramInt2, ((List)localObject2).size())));
    }
    long l1 = ((MessageRecord)((List)localObject2).get(0)).uniseq;
    long l2 = a(paramString);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1);
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("NavigateRefreshMessageListHead isLocalOnly=" + paramRefreshMessageContext.isLocalOnly + ",uniseq=" + l1 + ",ect=" + l2, " ,getC2CRoamingSetting" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting() == 0) {
      paramRefreshMessageContext.isLocalOnly = true;
    }
    int i = 0;
    label245:
    if (i < ((List)localObject2).size()) {
      if (((MessageRecord)((List)localObject2).get(i)).uniseq == l1)
      {
        if (i >= ((List)localObject2).size()) {
          break label2294;
        }
        if (abwz.g(((MessageRecord)((List)localObject2).get(i)).msgtype))
        {
          l1 = ((MessageRecord)((List)localObject2).get(i)).uniseq;
          i = 1;
        }
      }
    }
    for (;;)
    {
      label278:
      if ((paramRefreshMessageContext.isLocalOnly) || (l2 == 0L) || (i == 0))
      {
        a(paramString, paramInt1, l1, paramInt2, paramRefreshMessageContext, localArrayList);
        a(localArrayList, paramabwf);
        a(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1, localArrayList);
        paramRefreshMessageContext.resultMsgList = localArrayList;
        if (paramRefreshMessageContext.isComplete) {
          c(paramString, paramInt1);
        }
        paramString = localArrayList;
        if (!abwz.c(localArrayList)) {
          break;
        }
        paramString = localArrayList;
        if (paramRefreshMessageContext.repullStickerMsgIndex >= 3) {
          break;
        }
        a(paramRefreshMessageContext, paramInt1);
        return localArrayList;
        i += 1;
        break label278;
        i += 1;
        break label245;
      }
      i = 0;
      label468:
      MessageRecord localMessageRecord1;
      if (i < ((List)localObject3).size())
      {
        localMessageRecord1 = (MessageRecord)((List)localObject3).get(i);
        if (localMessageRecord1.uniseq != l1) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead cacheIndex:" + i + ", itemList:" + ((List)localObject3).size());
        }
        long l3;
        boolean bool1;
        if (localMessageRecord1 == null)
        {
          localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l1);
          if (localMessageRecord1 == null)
          {
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("refresh from empty C2C msg", "");
            paramRefreshMessageContext.isComplete = true;
            paramRefreshMessageContext.isLocalOnly = true;
            paramRefreshMessageContext.resultMsgList = new ArrayList();
            return paramRefreshMessageContext.resultMsgList;
            i += 1;
            break label468;
          }
          l3 = localMessageRecord1.time;
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("NavigateRefreshMessageListHead uniseq=" + l1 + ", aioBase.getId():" + localMessageRecord1.getId(), "");
          localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l3, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(localMessageRecord1.getId()) })));
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("NavigateRefreshMessageListHead Db fromTime:" + l3, "");
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("only load in db", localArrayList);
          l1 = l3;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead locallist size " + localArrayList.size());
          }
          if (l2 <= l1) {
            break label2275;
          }
          l1 = Math.min(l1, paramRefreshMessageContext.c2cTempEct);
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("ect > fromTime!! newEct:" + l1, "");
          bool1 = false;
        }
        for (;;)
        {
          for (;;)
          {
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("before pull locallist", localArrayList);
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("before pull locallist" + localArrayList.size(), "");
            if (localArrayList.size() >= paramInt2) {
              break label1985;
            }
            localObject3 = new Bundle();
            i = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.pullCounter.addAndGet(1);
            ((Bundle)localObject3).putInt("counter", i);
            ((Bundle)localObject3).putBoolean("timeout", true);
            ((Bundle)localObject3).putLong("UIN", Long.valueOf(paramString).longValue());
            ((Bundle)localObject3).putBoolean("canUpdateEct", bool1);
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.pullCache.put(Integer.valueOf(i), localArrayList);
            localObject2 = a((List)localObject2, localMessageRecord1);
            l2 = localMessageRecord1.uniseq;
            i = localArrayList.size();
            if (localArrayList.isEmpty())
            {
              i = paramInt2;
              label1055:
              ((Bundle)localObject3).putLong("baseTime", l1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "pull roam " + i + ",time=" + l1 + ",timeFilterList:" + ((ArrayList)localObject2).size());
              }
              l3 = 0L;
              if (!bool1) {
                l3 = paramRefreshMessageContext.c2cTempRand;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramString, l1, (short)i, (Bundle)localObject3, l3);
              ((Bundle)localObject3).putInt("size_req", i);
              this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.autoPullCache.put(abwz.a(paramString, paramInt1), Boolean.valueOf(false));
            }
            try
            {
              localArrayList.wait(35000L);
              if ((this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.autoPullCache.containsKey(abwz.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.autoPullCache.get(abwz.a(paramString, paramInt1))).booleanValue()))
              {
                paramRefreshMessageContext.resultMsgList = null;
                this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("get auto pull C2C msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                return paramRefreshMessageContext.resultMsgList;
                l1 = localMessageRecord1.time;
                MessageRecord localMessageRecord2;
                if (i >= paramInt2)
                {
                  int j = i - paramInt2;
                  while (j < i)
                  {
                    localMessageRecord2 = (MessageRecord)((List)localObject3).get(j);
                    if (localMessageRecord2.time >= l2) {
                      localArrayList.add(localMessageRecord2);
                    }
                    j += 1;
                  }
                  this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("all in cache", localArrayList);
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead fromTime:" + l1);
                  }
                  break;
                  localMessageRecord2 = (MessageRecord)((List)localObject3).get(0);
                  localObject3 = ((List)localObject3).subList(0, i).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    MessageRecord localMessageRecord3 = (MessageRecord)((Iterator)localObject3).next();
                    if (localMessageRecord3.time >= l2) {
                      localArrayList.add(localMessageRecord3);
                    }
                  }
                  this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("cache part", localArrayList);
                  i = paramInt2 - localArrayList.size();
                  localArrayList.addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, localMessageRecord2.time, i, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l2), Long.valueOf(localMessageRecord2.time), Long.valueOf(localMessageRecord2.getId()) })));
                  this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("cache + db", localArrayList);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead memdb:size:" + localArrayList.size() + ",miss:" + i);
                  }
                }
                i = paramInt2 - i;
                break label1055;
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
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("after pull locallist" + localArrayList.size(), "");
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("after pull locallist", localArrayList);
          a(localArrayList, (ArrayList)localObject2);
          if (!((Bundle)localObject3).getBoolean("timeout"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead " + localArrayList.size());
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l2, localArrayList);
            boolean bool2 = ((Bundle)localObject3).getBoolean("success");
            boolean bool3 = ((Bundle)localObject3).getBoolean("complete");
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.BaseMessageManager", 2, "success ?" + bool2 + ", complete?" + bool3);
            }
            if ((!bool2) || (bool3))
            {
              paramRefreshMessageContext.isLocalOnly = true;
              if (localArrayList.isEmpty())
              {
                label1885:
                if (!localArrayList.isEmpty()) {
                  break label2194;
                }
                label1893:
                a(paramString, paramInt1, l2, paramInt2, paramRefreshMessageContext, localArrayList);
              }
            }
            else
            {
              if (!bool1)
              {
                paramRefreshMessageContext.c2cTempEct = ((Bundle)localObject3).getLong("tempEct");
                paramRefreshMessageContext.c2cTempRand = ((Bundle)localObject3).getLong("tempRandom");
                this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("update tempEct:" + paramRefreshMessageContext.c2cTempEct + ", rand=" + paramRefreshMessageContext.c2cTempRand, "");
              }
              label1985:
              a(localArrayList);
              a(localArrayList, paramabwf);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1, localArrayList);
              paramRefreshMessageContext.resultMsgList = localArrayList;
              if (paramRefreshMessageContext.isComplete) {
                c(paramString, paramInt1);
              }
              paramString = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
              paramabwf = new StringBuilder().append("refresh C2C finish , context = ").append(paramRefreshMessageContext).append(" , size = ");
              if (localArrayList != null) {
                break label2266;
              }
            }
          }
          label2194:
          label2266:
          for (paramInt2 = -1;; paramInt2 = localArrayList.size())
          {
            paramString.qLogColor(paramInt2, ", timestamp = " + System.currentTimeMillis());
            paramString = localArrayList;
            if (!abwz.c(localArrayList)) {
              break;
            }
            paramString = localArrayList;
            if (paramRefreshMessageContext.repullStickerMsgIndex >= 3) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramRefreshMessageContext.repullStickerMsgIndex);
            }
            a(paramRefreshMessageContext, paramInt1);
            return localArrayList;
            l2 = ((MessageRecord)localArrayList.get(0)).uniseq;
            break label1885;
            paramInt2 -= localArrayList.size();
            break label1893;
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("pull timeout", "");
            paramRefreshMessageContext.isLocalOnly = true;
            if (localArrayList.isEmpty()) {}
            for (;;)
            {
              a(paramString, paramInt1, l2, i, paramRefreshMessageContext, localArrayList);
              break;
              l2 = ((MessageRecord)localArrayList.get(0)).uniseq;
            }
          }
          label2275:
          bool1 = true;
          l1 = l2;
        }
        i = 0;
        Object localObject1 = null;
      }
      label2294:
      i = 0;
      continue;
      i = 0;
    }
  }
  
  private List<MessageRecord> a(String paramString, List<MessageRecord> paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString, paramList, localArrayList, paramLong1, paramLong2);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("needSave", paramString);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("msgInDB", localArrayList);
    if ((paramString != null) && (!paramString.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(((MessageRecord)paramString.get(0)).istroop).a(paramString, null);
    }
    paramList = paramString.iterator();
    label429:
    while (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      MessageRecord localMessageRecord;
      if (((MessageRecord)localObject).getId() < 0L)
      {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("refresh C2C insert db error ! , mr.seq = " + ((MessageRecord)localObject).shmsgseq + " , mr.uniseq = " + ((MessageRecord)localObject).uniseq + ", mr.uid=" + ((MessageRecord)localObject).msgUid, "mr.msg = " + ((MessageRecord)localObject).getLogColorContent());
        localMessageRecord = a((MessageRecord)localObject);
        if (localMessageRecord == null) {
          localArrayList.remove(localObject);
        }
      }
      for (;;)
      {
        if ((!(localObject instanceof MessageForShortVideo)) || (((MessageForShortVideo)localObject).redBagType != LocalMediaInfo.REDBAG_TYPE_GET)) {
          break label429;
        }
        localObject = (MessageForShortVideo)localObject;
        VideoRedbagData.insertData(((MessageForShortVideo)localObject).shortVideoId, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).redBagStat);
        break;
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("refresh C2C insert db error ! , m.seq = " + localMessageRecord.shmsgseq + " , mr.uniseq = " + localMessageRecord.uniseq + ", m.uid=" + localMessageRecord.msgUid, "");
        localArrayList.set(localArrayList.indexOf(localObject), localMessageRecord);
        continue;
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("refresh C2C roam step 3 , mr.seq = " + ((MessageRecord)localObject).shmsgseq + " , mr.uniseq = " + ((MessageRecord)localObject).uniseq, "mr.msg = " + ((MessageRecord)localObject).getLogColorContent());
      }
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("setC2CRoamMessageResult needsave=" + paramString.size(), "");
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
  
  private void a(abwg paramabwg, String paramString, int paramInt1, int paramInt2, long paramLong, List<MessageRecord> paramList, ArrayList<MessageRecord> paramArrayList)
  {
    abwg.a(paramabwg, abwg.a(paramabwg).time);
    if (abwg.a(paramabwg) >= paramInt2)
    {
      paramInt1 = abwg.a(paramabwg) - paramInt2;
      while (paramInt1 < abwg.a(paramabwg))
      {
        paramString = (MessageRecord)paramList.get(paramInt1);
        if (paramString.time >= paramLong) {
          paramArrayList.add(paramString);
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("all in cache", paramArrayList);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead fromTime:" + abwg.a(paramabwg));
      }
      return;
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.get(0);
      paramList = paramList.subList(0, abwg.a(paramabwg)).iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord2 = (MessageRecord)paramList.next();
        if (localMessageRecord2.time >= paramLong) {
          paramArrayList.add(localMessageRecord2);
        }
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("cache part", paramArrayList);
      paramInt2 -= paramArrayList.size();
      paramArrayList.addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, localMessageRecord1.time, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(paramLong), Long.valueOf(localMessageRecord1.time), Long.valueOf(localMessageRecord1.getId()) })));
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("cache + db", paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead memdb:size:" + paramArrayList.size() + ",miss:" + paramInt2);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, abwp paramabwp, int paramInt)
  {
    String str;
    if ((paramInt != 3000) && (paramInt != 1) && (paramInt != 7000))
    {
      str = paramMessageRecord.frienduin;
      if (!String.valueOf(AppConstants.LBS_HELLO_UIN).equals(str)) {
        break label506;
      }
      str = paramMessageRecord.senderuin;
    }
    label238:
    label506:
    for (;;)
    {
      if ((paramInt == 1001) && (!paramMessageRecord.isSend()) && (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)))
      {
        if (abwz.d(paramMessageRecord)) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8E", "0X8005C8E", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if ((abwz.a(paramInt) != 1009) && (paramabwp.a(str, 1009)))
        {
          paramabwp.a(AppConstants.SAME_STATE_BOX_UIN, 1009, str, paramMessageRecord.istroop);
          a(AppConstants.SAME_STATE_BOX_UIN, 1009, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((abwz.a(paramInt) != 1001) && (paramabwp.a(str, 1001)))
        {
          paramabwp.a(AppConstants.LBS_HELLO_UIN, 1001, str, paramMessageRecord.istroop);
          if (!paramabwp.a(str, 1001, AppConstants.LBS_SAY_HELLO_LIST_UIN)) {
            break label462;
          }
          a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((abwz.a(paramInt) != 1010) && (paramabwp.a(str, 1010)))
        {
          paramabwp.a(AppConstants.DATE_UIN, 1010, str, paramMessageRecord.istroop);
          if (!paramabwp.a(str, 1010, AppConstants.DATE_SAY_HELLO_LIST_UIN)) {
            break label484;
          }
          a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
      }
      for (;;)
      {
        if ((abwz.a(paramInt) != 1044) && (paramabwp.a(str, 1044)) && (paramabwp.a(str, 1044, AppConstants.MATCH_CHAT_UIN))) {
          a(AppConstants.MATCH_CHAT_UIN, 1044, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if ((abwz.a(paramInt) != 10008) && (paramabwp.a(str, 10008)) && (paramabwp.a(str, 10008, AppConstants.QCIRCLE_CHAT_UIN))) {
          a(AppConstants.QCIRCLE_CHAT_UIN, 10008, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        return;
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8F", "0X8005C8F", 0, 0, "", "", "", "");
        break;
        a(AppConstants.LBS_HELLO_UIN, 1001, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        break label238;
        a(AppConstants.DATE_UIN, 1010, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, long paramLong)
  {
    int i = paramArrayList.size();
    abwt localabwt = paramRefreshMessageContext.roamMsgFetcher;
    if ((localabwt != null) && (!localabwt.a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramArrayList, paramMessageRecord, paramLong)))
    {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("get roam msg failed", "");
      paramRefreshMessageContext.isLocalOnly = true;
      if (!paramArrayList.isEmpty()) {
        break label103;
      }
      if (paramMessageRecord != null) {
        break label93;
      }
      paramLong = 0L;
    }
    for (;;)
    {
      a(paramString, paramInt1, paramLong, paramInt2 - i, paramRefreshMessageContext, paramArrayList, false);
      return;
      label93:
      paramLong = paramMessageRecord.uniseq;
      continue;
      label103:
      paramLong = ((MessageRecord)paramArrayList.get(0)).uniseq;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean1, long paramLong1, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean2, Bundle paramBundle, long paramLong2, int paramInt3)
  {
    if (!paramBundle.getBoolean("timeout"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead " + paramArrayList.size());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramLong2, paramArrayList);
      boolean bool1 = paramBundle.getBoolean("success");
      boolean bool2 = paramBundle.getBoolean("complete");
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "success ?" + bool1 + ", complete?" + bool2);
      }
      if ((!paramBoolean1) && ((!bool1) || (bool2)))
      {
        paramRefreshMessageContext.isLocalOnly = true;
        if (!paramArrayList.isEmpty()) {
          break label296;
        }
        if (!paramArrayList.isEmpty()) {
          break label313;
        }
      }
      label296:
      label313:
      for (paramInt3 = paramInt2;; paramInt3 = paramInt2 - paramArrayList.size())
      {
        a(paramString, paramInt1, paramLong2, paramInt3, paramRefreshMessageContext, paramArrayList);
        if (!paramBoolean2)
        {
          paramRefreshMessageContext.c2cTempEct = paramBundle.getLong("tempEct");
          paramRefreshMessageContext.c2cTempRand = paramBundle.getLong("tempRandom");
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("update tempEct:" + paramRefreshMessageContext.c2cTempEct + ", rand=" + paramRefreshMessageContext.c2cTempRand, "");
        }
        if ((paramBoolean1) && (paramArrayList.size() < paramInt2) && (bool2)) {
          a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramArrayList, paramMessageRecord, paramLong1);
        }
        return;
        paramLong2 = ((MessageRecord)paramArrayList.get(0)).uniseq;
        break;
      }
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("pull timeout", "");
    paramRefreshMessageContext.isLocalOnly = true;
    if (paramArrayList.isEmpty()) {}
    for (;;)
    {
      a(paramString, paramInt1, paramLong2, paramInt3, paramRefreshMessageContext, paramArrayList);
      return;
      paramLong2 = ((MessageRecord)paramArrayList.get(0)).uniseq;
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, abwf paramabwf)
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
      } while ((abwz.b(localMessageRecord)) || (localMessageRecord.msgUid != paramabwf.a) || (localMessageRecord.time != paramabwf.b));
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
  
  private void a(ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayList1.size() - 1;
    while (i >= 0)
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramArrayList1.get(i);
      Iterator localIterator = paramArrayList2.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
        if (abwz.a(localMessageRecord2, localMessageRecord1, true))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead filterMr " + localMessageRecord2.getLogColorContent() + ",uniseq=" + localMessageRecord2.uniseq);
          }
          localArrayList.add(localMessageRecord1);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead not find filterMr " + localMessageRecord2.getLogColorContent() + ",mr=" + localMessageRecord1.getLogColorContent());
        }
      }
      i -= 1;
    }
    paramArrayList1.removeAll(localArrayList);
  }
  
  private boolean a(int paramInt, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean, List<MessageRecord> paramList)
  {
    if (((paramList == null) || (paramList.isEmpty())) && (!paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.resultMsgList = null;
      a(paramRefreshMessageContext, paramInt);
      return true;
    }
    return false;
  }
  
  private boolean a(abwg paramabwg, String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean, long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList)
  {
    abwg.a(paramabwg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramLong1));
    if (abwg.a(paramabwg) == null)
    {
      if (paramBoolean)
      {
        a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramArrayList, null, 0L);
        a(paramArrayList);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1, paramArrayList);
        paramRefreshMessageContext.resultMsgList = paramArrayList;
        if (paramRefreshMessageContext.isComplete) {
          c(paramString, paramInt1);
        }
        paramString = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
        StringBuilder localStringBuilder = new StringBuilder().append("refresh C2C finish , context = ").append(paramRefreshMessageContext).append(" , size = ");
        if (paramArrayList == null)
        {
          paramInt2 = -1;
          paramString.qLogColor(paramInt2, ", timestamp = " + System.currentTimeMillis());
          if ((!abwz.c(paramArrayList)) || (paramRefreshMessageContext.repullStickerMsgIndex >= 3)) {
            break label241;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramRefreshMessageContext.repullStickerMsgIndex);
          }
          a(paramRefreshMessageContext, paramInt1);
        }
      }
      for (;;)
      {
        abwg.a(paramabwg, true);
        return true;
        paramInt2 = paramArrayList.size();
        break;
        label241:
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
        continue;
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("refresh from empty C2C msg", "");
        paramRefreshMessageContext.isComplete = true;
        paramRefreshMessageContext.isLocalOnly = true;
        paramRefreshMessageContext.resultMsgList = new ArrayList();
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
      }
    }
    abwg.a(paramabwg, abwg.a(paramabwg).time);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("refreshC2CMessageListHead uniseq=" + paramLong1 + ", aioBase.getId():" + abwg.a(paramabwg).getId(), "");
    paramArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, abwg.a(paramabwg), paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(paramLong2), Long.valueOf(abwg.a(paramabwg)), Long.valueOf(abwg.a(paramabwg).getId()) })));
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("refreshC2CMessageListHead Db fromTime:" + abwg.a(paramabwg), "");
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("only load in db", paramArrayList);
    return false;
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    if (a(paramInt1))
    {
      if (paramRefreshMessageContext.msgRefresher != null)
      {
        paramRefreshMessageContext.msgRefresher.a(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead TYPE ERROR! TYPE = " + paramInt1);
      }
      paramRefreshMessageContext.isComplete = true;
      paramRefreshMessageContext.resultMsgList = null;
      a(paramRefreshMessageContext, paramInt1);
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean1, long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean2)
  {
    if ((paramRefreshMessageContext.isLocalOnly) || (paramLong2 == 0L) || ((!paramBoolean2) && (!paramBoolean1)))
    {
      a(paramString, paramInt1, paramLong1, paramInt2, paramRefreshMessageContext, paramArrayList);
      a(paramArrayList);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1, paramArrayList);
      paramRefreshMessageContext.resultMsgList = paramArrayList;
      if (paramRefreshMessageContext.isComplete) {
        c(paramString, paramInt1);
      }
      paramString = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
      StringBuilder localStringBuilder = new StringBuilder().append("refresh load local C2C msg only FIN , context = ").append(paramRefreshMessageContext).append(", size = ");
      if (paramArrayList == null)
      {
        paramInt2 = -1;
        paramString.qLogColor(paramInt2, ", timestamp = " + System.currentTimeMillis());
        if ((!abwz.c(paramArrayList)) || (paramRefreshMessageContext.repullStickerMsgIndex >= 3)) {
          break label188;
        }
        a(paramRefreshMessageContext, paramInt1);
      }
      for (;;)
      {
        return true;
        paramInt2 = paramArrayList.size();
        break;
        label188:
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
      }
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean1, List<MessageRecord> paramList, long paramLong, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    int i = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.pullCounter.addAndGet(1);
    localBundle.putInt("counter", i);
    localBundle.putBoolean("timeout", true);
    localBundle.putLong("UIN", Long.valueOf(paramString).longValue());
    localBundle.putBoolean("canUpdateEct", paramBoolean2);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.pullCache.put(Integer.valueOf(i), paramArrayList);
    paramList = a(paramList, paramMessageRecord);
    long l2 = paramMessageRecord.uniseq;
    i = paramArrayList.size();
    if (paramArrayList.isEmpty()) {
      i = paramInt2;
    }
    for (;;)
    {
      localBundle.putLong("baseTime", paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "pull roam " + i + ",time=" + paramLong + ",timeFilterList:" + paramList.size());
      }
      long l1 = 0L;
      if (!paramBoolean2) {
        l1 = paramRefreshMessageContext.c2cTempRand;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramString, paramLong, (short)i, localBundle, l1);
      localBundle.putInt("size_req", i);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.autoPullCache.put(abwz.a(paramString, paramInt1), Boolean.valueOf(false));
      try
      {
        paramArrayList.wait(35000L);
        if ((this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.autoPullCache.containsKey(abwz.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.autoPullCache.get(abwz.a(paramString, paramInt1))).booleanValue()))
        {
          paramRefreshMessageContext.resultMsgList = null;
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("get auto pull C2C msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
          return true;
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
    if ((localBundle.getBoolean("timeout")) && (QLog.isColorLevel())) {
      QLog.w("Q.msg.BaseMessageManager", 2, "timeout!");
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("after pull locallist" + paramArrayList.size(), "");
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("after pull locallist", paramArrayList);
    a(paramArrayList, paramList);
    a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramBoolean1, paramLong, paramMessageRecord, paramArrayList, paramBoolean2, localBundle, l2, i);
    return false;
  }
  
  private List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramString, paramInt, Math.min(paramLong1, paramLong2), Math.max(paramLong1, paramLong2));
  }
  
  private void c(String paramString, int paramInt)
  {
    if ((1000 == paramInt) || (1004 == paramInt))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAIOList(paramString, paramInt);
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
    } while ((localChatMessage.isSend()) || (abwz.h(localChatMessage.msgtype)));
    ((ChatMessage)paramString.get(0)).mNeedGrayTips = true;
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.time;
  }
  
  abwg a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, List<MessageRecord> paramList, ArrayList<MessageRecord> paramArrayList)
  {
    abwg localabwg = new abwg(null);
    int i;
    int j;
    if (paramList == null)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (j < i)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(j);
        if (localMessageRecord.uniseq == paramLong1)
        {
          abwg.a(localabwg, localMessageRecord);
          abwg.a(localabwg, j);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead cacheIndex:" + abwg.a(localabwg) + ", itemList:" + paramList.size());
        }
        if (abwg.a(localabwg) != null) {
          break label175;
        }
        if (!a(localabwg, paramString, paramInt1, paramInt2, paramRefreshMessageContext, paramBoolean, paramLong1, paramLong2, paramArrayList)) {
          break label190;
        }
        return localabwg;
        i = paramList.size();
        break;
      }
      j += 1;
    }
    label175:
    a(localabwg, paramString, paramInt1, paramInt2, paramLong3, paramList, paramArrayList);
    label190:
    abwg.a(localabwg, false);
    return localabwg;
  }
  
  List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).b(paramString, paramInt);
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
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(paramString, paramInt, paramLong2, -1, String.format("time>=%d or time=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB from=" + paramLong1 + ",to=" + paramLong2 + ",size=" + paramString.size());
        }
        paramString = abwz.a(localArrayList, paramString).iterator();
        while (paramString.hasNext()) {
          abwz.b(localArrayList, (MessageRecord)paramString.next(), false);
        }
      }
      localArrayList.add(localMessageRecord);
    }
    return localArrayList;
  }
  
  protected Map<String, List<MessageRecord>> a()
  {
    return this.jdField_a_of_type_Abww.a();
  }
  
  public void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    String str = paramRefreshMessageContext.uin;
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).f(str, paramInt);
    if ((paramRefreshMessageContext.repullStickerMsgIndex < 3) && (abwz.c(localList)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more sticker msg");
      }
      paramRefreshMessageContext.repullStickerMsgIndex += 1;
      b(str, paramInt, 15, paramRefreshMessageContext);
      return;
    }
    super.a(paramRefreshMessageContext, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, abvu paramabvu)
  {
    if (paramMessageRecord == null) {}
    Map localMap;
    anuz localanuz;
    Object localObject1;
    Object localObject2;
    String str1;
    int i;
    long l;
    Object localObject3;
    do
    {
      return;
      localMap = paramabvu.jdField_a_of_type_JavaUtilMap;
      localanuz = paramabvu.jdField_a_of_type_Anuz;
      localObject1 = paramabvu.jdField_a_of_type_Abwp;
      if (paramMessageRecord.time == 0L) {
        paramMessageRecord.time = bbko.a();
      }
      if (paramMessageRecord.msgseq == 0L) {
        paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
      }
      localObject2 = paramMessageRecord.frienduin;
      str1 = paramMessageRecord.senderuin;
      i = paramMessageRecord.istroop;
      l = paramMessageRecord.time;
      a(paramMessageRecord, (abwp)localObject1, i);
      if ((i != 1008) || (!agjp.a(paramMessageRecord.frienduin))) {
        break;
      }
      localObject3 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).edit();
    } while ((paramMessageRecord instanceof MessageForPubAccount));
    if ((paramMessageRecord instanceof MessageForText))
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_push", 0, 0, "", "", "", "");
      ((SharedPreferences.Editor)localObject3).putLong("pa_list_send_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
    }
    int k;
    boolean bool1;
    for (;;)
    {
      ((SharedPreferences.Editor)localObject3).commit();
      localObject2 = new abwh(this, paramMessageRecord, paramEntityManager, localMap, localanuz, (abwp)localObject1, (String)localObject2, i, l).a();
      localObject1 = ((abwh)localObject2).a();
      k = ((abwh)localObject2).a();
      l = ((abwh)localObject2).a();
      int j;
      if (((paramMessageRecord instanceof MessageForVideo)) && (paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1)) {
        j = -1;
      }
      try
      {
        localObject2 = paramMessageRecord.msg.split("\\|");
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (localObject2.length >= 2) {
            i = Integer.valueOf(localObject2[1]).intValue();
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          boolean bool2;
          Object localObject4;
          i = -1;
          continue;
          localException1.a((MessageForVideo)paramMessageRecord, false);
        }
        if (!QLog.isColorLevel()) {
          break label1098;
        }
        QLog.d("AdvertisementRecentUserManager", 2, "isAdMessage:recent_list_advertisement_message change 0");
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "0");
      }
      localObject2 = (azjc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
      if (i != 6) {
        break;
      }
      ((azjc)localObject2).a((MessageForVideo)paramMessageRecord, true);
      ((azjc)localObject2).a((MessageForVideo)paramMessageRecord);
      i = paramMessageRecord.istroop;
      bool2 = false;
      bool1 = bool2;
      if (k == 1008)
      {
        bool1 = bool2;
        if (nyj.a(paramMessageRecord)) {
          bool1 = true;
        }
      }
      if (!bool1) {
        break label1326;
      }
      localObject2 = nyj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, false);
      if ((localObject2 == null) || (TextUtils.isEmpty(((nxq)localObject2).jdField_a_of_type_Nxs.jdField_a_of_type_JavaLangString))) {
        break label1082;
      }
      nxz.a().a(((nxq)localObject2).jdField_a_of_type_JavaLangString);
      nxz.a().a((nxq)localObject2);
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_uin", ((nxq)localObject2).jdField_a_of_type_Nxs.jdField_a_of_type_JavaLangString);
      if (((nxq)localObject2).jdField_a_of_type_Nxs.b != null) {
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_name", ((nxq)localObject2).jdField_a_of_type_Nxs.b);
      }
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "false");
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "false");
      localObject2 = paramEntityManager.query(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
      if (localObject2 == null) {
        break label1108;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        paramEntityManager.remove((Entity)localObject3);
        akms.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop);
        localObject4 = (RecentUser)localanuz.findRecentUserByUin((String)localObject1, i);
        if (localObject4 != null)
        {
          akla.a().a((String)localObject1 + "-" + i);
          localanuz.delRecentUser((BaseRecentUser)localObject4);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReaded(((MessageRecord)localObject3).senderuin, 1008, true, true);
      }
      if ((paramMessageRecord instanceof MessageForArkApp))
      {
        localObject4 = (MessageForArkApp)paramMessageRecord;
        ((SharedPreferences.Editor)localObject3).putBoolean("show_flag", true);
        try
        {
          localObject4 = new JSONObject(((MessageForArkApp)localObject4).ark_app_message.metaList).optJSONObject("weather");
          if ((localObject4 != null) && (((JSONObject)localObject4).has("info")))
          {
            JSONObject localJSONObject = ((JSONObject)localObject4).optJSONObject("info");
            Object localObject5 = localJSONObject.optJSONObject("it1");
            if (localObject5 != null)
            {
              String str2 = ((JSONObject)localObject5).optString("city");
              String str3 = ((JSONObject)localObject5).optString("temp");
              localObject5 = ((JSONObject)localObject5).optString("type");
              if (!TextUtils.isEmpty(str2)) {
                ((SharedPreferences.Editor)localObject3).putString("cur_city", str2.split("-")[0]);
              }
              if (!TextUtils.isEmpty(str3)) {
                ((SharedPreferences.Editor)localObject3).putString("cur_temp", str3);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                ((SharedPreferences.Editor)localObject3).putString("cur_code", (String)localObject5);
              }
              ((SharedPreferences.Editor)localObject3).putLong("pa_send_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), System.currentTimeMillis());
              if (0L != ((JSONObject)localObject4).optLong("ts")) {
                ((SharedPreferences.Editor)localObject3).putLong("pa_time_stamp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localJSONObject.optLong("ts"));
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "parse ark msg city: " + str2 + ", temp: " + str3 + ", code: " + (String)localObject5 + ", ts: " + localJSONObject.optLong("ts"));
              }
            }
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
    }
    for (;;)
    {
      label1082:
      label1098:
      label1108:
      i = a(paramMessageRecord, paramabvu, localMap, localanuz, (String)localObject1, str1, k, l, i, bool1);
      if ((!paramMessageRecord.isSend()) && (paramMessageRecord.istroop == 0) && (bftf.b(paramMessageRecord.frienduin)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
      {
        bool1 = bfyg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
        if (QLog.isColorLevel()) {
          QLog.i("BabyQReportCookie", 2, "now in the aio, isScreenLocked = " + bool1);
        }
        if ((a().containsKey(abwz.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) && (!bool1))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().sendSpecialMessage(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
          if (QLog.isColorLevel()) {
            QLog.i("BabyQReportCookie", 2, "now in the aio!!!");
          }
        }
      }
      if (i == 1036) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg(null);
      }
      super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramabvu);
      paramEntityManager = bcvt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramEntityManager.a(paramMessageRecord);
      paramEntityManager.a();
      return;
      label1326:
      if (k == 10005) {
        aula.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, paramEntityManager, localanuz);
      } else if (azxb.b(k)) {
        azxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, k, paramMessageRecord);
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
      ((amwo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).b(paramMessageRecord);
      super.a(paramMessageRecord, paramBoolean1, paramBoolean2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in MainThread!");
      }
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList)
  {
    a(paramString, paramInt1, paramLong, paramInt2, paramRefreshMessageContext, paramArrayList, true);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    MessageRecord localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramLong);
    Object localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
    Object localObject2 = new StringBuilder().append("loadFromLocal uniseq=").append(paramLong).append(",count=").append(paramInt2).append(", fromtime=");
    label141:
    MessageRecord localMessageRecord2;
    if (localMessageRecord1 == null)
    {
      paramLong = -1L;
      ((QQMessageFacade)localObject1).qLogColor(paramLong, "");
      if (localMessageRecord1 == null) {
        break label520;
      }
      long l3 = localMessageRecord1.time;
      long l2 = localMessageRecord1.getId();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1);
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localMessageRecord2 = (MessageRecord)((Iterator)localObject2).next();
          if ((localMessageRecord2.time <= l3) && (!abwz.a(localMessageRecord1, localMessageRecord2, true))) {
            break label468;
          }
        }
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("loadFromLocal load from Cache", (Collection)localObject1);
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
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l1, localMessageRecord1.versionCode, paramLong, paramInt2, String.format(" or (time=%d and _id<%d) ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) }));
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("queryTimedMessageDBUnion list size" + paramString.size() + ", getID=" + localMessageRecord1.getId(), "");
        if (!paramString.isEmpty()) {
          break label481;
        }
        paramRefreshMessageContext.isComplete = true;
      }
    }
    for (;;)
    {
      paramRefreshMessageContext.isLocalOnly = paramBoolean;
      return;
      paramLong = localMessageRecord1.time;
      break;
      label468:
      ((List)localObject1).add(localMessageRecord2);
      break label141;
      label481:
      if (paramString.size() < paramInt2) {
        paramRefreshMessageContext.isComplete = true;
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("loadFromLocal load from DB", paramString);
      paramArrayList.addAll(0, paramString);
    }
    label520:
    paramRefreshMessageContext.isLocalOnly = paramBoolean;
    paramRefreshMessageContext.isComplete = true;
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("loadFromLocal complete", "");
  }
  
  public void a(String paramString, int paramInt, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, abwf paramabwf, FragmentActivity paramFragmentActivity)
  {
    paramRefreshMessageContext.needNotifyUI = false;
    paramRefreshMessageContext.needRefreshAIO = true;
    paramRefreshMessageContext.uin = paramString;
    paramRefreshMessageContext.uinType = paramInt;
    if ((!paramRefreshMessageContext.numTroopRefresh) && (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.refreshActionMap.containsKey(abwz.a(paramString, paramInt))))
    {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.refreshActionMap.put(abwz.a(paramString, paramInt), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new C2CMessageManager.2(this, paramRefreshMessageContext, paramInt, paramString, paramabwf, paramFragmentActivity));
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("success");
    boolean bool2 = paramBundle.getBoolean("complete");
    List localList = (List)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.pullCache.get(Integer.valueOf(paramBundle.getInt("counter")));
    paramBundle.putBoolean("timeout", false);
    long l1 = paramBundle.getLong("baseTime");
    long l2 = paramBundle.getLong("lowTime");
    paramBundle = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
    Object localObject = new StringBuilder().append("setC2CRoamMessageResult success=").append(bool1).append(",complete=").append(bool2).append(",res_size=");
    if (paramList1 == null)
    {
      paramInt = -1;
      paramBundle.qLogColor(paramInt + ",baseT=" + l1 + ",lowTime=" + l2, "");
      if (paramList1 != null) {
        break label528;
      }
    }
    label528:
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
            break label447;
          }
          paramBundle = (MessageRecord)paramList2.next();
          localObject = paramString.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!abwz.a((MessageRecord)((Iterator)localObject).next(), paramBundle, true));
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
        label447:
        paramString = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
        paramList1 = new StringBuilder().append("setC2CRoamMessageResult locallist:");
        if (localList == null) {}
        for (paramInt = -1;; paramInt = localList.size())
        {
          paramString.qLogColor(paramInt, "");
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
  
  protected boolean a(int paramInt)
  {
    UinType localUinType = UinType.valueOf(paramInt);
    if (localUinType != null) {
      return localUinType.isInvalidUinTypeWhenRefresh();
    }
    return (paramInt != 0) && (paramInt != 1000) && (paramInt != 1004) && (paramInt != 9501) && (paramInt != 1044) && (paramInt != 1045) && (paramInt != 10007) && (paramInt != 10008) && (paramInt != 10009) && (paramInt != 10010);
  }
  
  public void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    if (paramInt == 1038)
    {
      paramString = (anxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(148);
      if (paramString != null) {
        paramString.b();
      }
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    if (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext)) {}
    boolean bool1;
    Object localObject1;
    label105:
    long l2;
    Object localObject2;
    ArrayList localArrayList;
    do
    {
      long l3;
      do
      {
        do
        {
          return;
          if (paramRefreshMessageContext.roamMsgFetcher == null) {
            break;
          }
          bool1 = true;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).f(paramString, paramInt1);
        } while (a(paramInt1, paramRefreshMessageContext, bool1, (List)localObject1));
        if (localObject1 != null) {
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("current Aio", ((List)localObject1).subList(0, Math.min(paramInt2, ((List)localObject1).size())));
        }
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          break label703;
        }
        l1 = 0L;
        l2 = a(paramString);
        l3 = a(bool1, l2);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1);
        localArrayList = new ArrayList();
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("refreshC2CMessageListHead isLocalOnly=" + paramRefreshMessageContext.isLocalOnly + ",uniseq=" + l1 + ",ect=" + l2 + ", possibleBreakTime=" + l3, " ,getC2CRoamingSetting" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting());
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting() == 0) {
          paramRefreshMessageContext.isLocalOnly = true;
        }
        localObject3 = new abxn((List)localObject1, l1).a();
        l1 = ((abxn)localObject3).a();
      } while (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, bool1, l1, l3, localArrayList, ((abxn)localObject3).a()));
      localObject2 = a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, bool1, l1, l2, l3, (List)localObject2, localArrayList);
    } while (((abwg)localObject2).a());
    Object localObject3 = ((abwg)localObject2).a();
    long l1 = ((abwg)localObject2).a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead locallist size " + localArrayList.size());
    }
    boolean bool2;
    if (l2 > l1)
    {
      l1 = Math.min(l1, paramRefreshMessageContext.c2cTempEct);
      bool2 = false;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("ect > fromTime!! newEct:" + l1, "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("before pull locallist", localArrayList);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.qLogColor("before pull locallist" + localArrayList.size(), "");
      if ((l1 > 0L) && (localArrayList.size() < paramInt2))
      {
        if (a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, bool1, (List)localObject1, l1, (MessageRecord)localObject3, localArrayList, bool2)) {
          break;
        }
        label521:
        a(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1, localArrayList);
        paramRefreshMessageContext.resultMsgList = localArrayList;
        if (paramRefreshMessageContext.isComplete) {
          c(paramString, paramInt1);
        }
        paramString = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
        localObject1 = new StringBuilder().append("refresh C2C finish , context = ").append(paramRefreshMessageContext).append(" , size = ");
        if (localArrayList != null) {
          break label754;
        }
      }
      label703:
      label754:
      for (paramInt2 = -1;; paramInt2 = localArrayList.size())
      {
        paramString.qLogColor(paramInt2, ", timestamp = " + System.currentTimeMillis());
        if ((!abwz.c(localArrayList)) || (paramRefreshMessageContext.repullStickerMsgIndex >= 3)) {
          break label763;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramRefreshMessageContext.repullStickerMsgIndex);
        }
        a(paramRefreshMessageContext, paramInt1);
        return;
        bool1 = false;
        break;
        l1 = ((MessageRecord)((List)localObject1).get(0)).uniseq;
        break label105;
        if ((!bool1) || (localArrayList.size() >= paramInt2)) {
          break label521;
        }
        a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, localArrayList, (MessageRecord)localObject3, l1);
        break label521;
      }
      label763:
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
      return;
      bool2 = true;
      l1 = l2;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().cachedMsg.remove(AppConstants.LBS_HELLO_UIN);
    String str = AppConstants.LBS_HELLO_UIN;
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1001).a(str, 1001).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (!aquz.b(localMessageRecord)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(localMessageRecord.istroop).a(AppConstants.LBS_HELLO_UIN, localMessageRecord.istroop, localMessageRecord.senderuin + "", localMessageRecord.selfuin + "", localMessageRecord.getExtraKey());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().e(str, 1001);
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    ThreadManager.post(new C2CMessageManager.1(this, paramMessageRecord), 8, null, true);
  }
  
  protected boolean c(String paramString)
  {
    paramString = ((amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(paramString);
    if (paramString != null) {
      return paramString.isVisible();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwe
 * JD-Core Version:    0.7.0.1
 */