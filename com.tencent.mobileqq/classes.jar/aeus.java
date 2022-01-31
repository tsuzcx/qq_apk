import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.1;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.10;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.11;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.12;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.13;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.2;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.3;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.5;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.6;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.7;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.8;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.9;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aeus
{
  private static volatile aeus jdField_a_of_type_Aeus;
  public volatile long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public volatile boolean a;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  
  private aeus()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static aeus a()
  {
    if (jdField_a_of_type_Aeus == null) {}
    try
    {
      if (jdField_a_of_type_Aeus == null) {
        jdField_a_of_type_Aeus = new aeus();
      }
      return jdField_a_of_type_Aeus;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt)
  {
    String str2 = "";
    String str1;
    if (paramInt == 0) {
      str1 = "0X8004A27";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {
        VipUtils.a(paramQQAppInterface, "Vip_StructuredEgg", str1, str1, 0, 0, new String[0]);
      }
      return;
      str1 = str2;
      if (paramInt == 1) {
        if (paramChatMessage.istroop == 1)
        {
          str1 = "0X8004A28";
        }
        else
        {
          str1 = str2;
          if (paramChatMessage.istroop == 3000) {
            str1 = "0X8004A29";
          }
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt1, int paramInt2, aeuu paramaeuu)
  {
    int j = -1;
    int i;
    if (paramInt1 == 0)
    {
      i = 0;
      if (paramInt2 != 2) {
        break label134;
      }
      if (paramChatMessage.isSendFromLocal()) {
        break label100;
      }
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_rec", 0, 0, String.valueOf(i), String.valueOf(paramaeuu.jdField_a_of_type_Int), "", "");
    }
    label100:
    while (paramInt2 != 3)
    {
      return;
      i = j;
      if (paramInt1 != 1) {
        break;
      }
      if (paramChatMessage.istroop == 1)
      {
        i = 1;
        break;
      }
      i = j;
      if (paramChatMessage.istroop != 3000) {
        break;
      }
      i = 2;
      break;
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_launch", 0, 0, String.valueOf(i), String.valueOf(paramaeuu.jdField_a_of_type_Int), "", "");
      return;
    }
    label134:
    if (!paramChatMessage.isSendFromLocal())
    {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_rec", 0, 0, String.valueOf(i), String.valueOf(paramaeuu.jdField_a_of_type_Int), "", "");
      return;
    }
    azqs.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_launch", 0, 0, String.valueOf(i), String.valueOf(paramaeuu.jdField_a_of_type_Int), "", "");
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, aeuu paramaeuu)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("AioAnimationDetector", 2, "detect combo =======> isLastStackMessageFromOthers ? " + this.jdField_b_of_type_Boolean + "  lastStackMessageSeq=" + this.jdField_b_of_type_Long + "thisMessageSeq=" + paramChatMessage.shmsgseq);
    }
    if ((paramChatMessage.isSendFromLocal()) && (this.jdField_b_of_type_Boolean) && (paramChatMessage.shmsgseq == this.jdField_b_of_type_Long + 1L)) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Eggs_stack_new", 0, 0, String.valueOf(0), String.valueOf(paramaeuu.jdField_a_of_type_Int), "", "");
    }
    if (!paramChatMessage.isSendFromLocal()) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    this.jdField_b_of_type_Long = paramChatMessage.shmsgseq;
  }
  
  public String a(AbsShareMsg paramAbsShareMsg)
  {
    if ((paramAbsShareMsg != null) && (paramAbsShareMsg.getItemCount() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramAbsShareMsg = paramAbsShareMsg.iterator();
      while (paramAbsShareMsg.hasNext())
      {
        Object localObject = (azus)paramAbsShareMsg.next();
        if ((localObject instanceof azut))
        {
          localObject = ((azut)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            azus localazus = (azus)((Iterator)localObject).next();
            String str = localazus.jdField_a_of_type_JavaLangString;
            if ("title".equals(str)) {
              localStringBuilder.append(((StructMsgItemTitle)localazus).b());
            } else if ("summary".equals(str)) {
              localStringBuilder.append(((azzm)localazus).b());
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public ArrayList<aeuu> a(ChatMessage paramChatMessage)
  {
    aeuu localaeuu = null;
    Object localObject1 = null;
    Iterator localIterator = null;
    Object localObject2 = localIterator;
    if (paramChatMessage != null)
    {
      if (a(paramChatMessage)) {
        break label32;
      }
      localObject2 = localIterator;
    }
    label32:
    Object localObject3;
    do
    {
      return localObject2;
      localObject3 = aeur.a().a();
      if (localObject3 != null) {
        break;
      }
      localObject2 = localIterator;
    } while (!QLog.isColorLevel());
    QLog.d("AioAnimationDetector", 2, "match : rules == null, just return;");
    return null;
    paramChatMessage.parse();
    long l1 = System.currentTimeMillis();
    if (b(paramChatMessage)) {
      localObject2 = a((AbsShareMsg)((MessageForStructing)paramChatMessage).structingMsg);
    }
    label115:
    long l2;
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localIterator = ((ArrayList)localObject3).iterator();
        paramChatMessage = localaeuu;
        localObject1 = paramChatMessage;
        if (localIterator.hasNext())
        {
          localaeuu = (aeuu)localIterator.next();
          if (localaeuu.jdField_a_of_type_JavaUtilArrayList == null) {
            break label401;
          }
          localObject1 = localaeuu.jdField_a_of_type_JavaUtilArrayList.iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label401;
            }
            localObject3 = (String)((Iterator)localObject1).next();
            if ((localObject2 != null) && (((String)localObject2).contains((CharSequence)localObject3)))
            {
              if (localaeuu.jdField_a_of_type_Aeuv == null) {
                break;
              }
              l2 = System.currentTimeMillis() / 1000L;
              if ((localaeuu.jdField_a_of_type_Aeuv.jdField_a_of_type_Int != 1) || ((localaeuu.jdField_a_of_type_Aeuv.jdField_b_of_type_Int <= l2) && (localaeuu.jdField_a_of_type_Aeuv.c >= l2))) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "JD red pack,But not in date.");
              }
            }
          }
          localObject2 = paramChatMessage.msg;
          continue;
          if (paramChatMessage != null) {
            break label398;
          }
          paramChatMessage = new ArrayList();
          label292:
          paramChatMessage.add(localaeuu);
          localObject1 = paramChatMessage;
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "matched ===> rule: id=" + localaeuu.jdField_a_of_type_Int);
          }
        }
      }
    }
    label398:
    label401:
    for (localObject1 = paramChatMessage;; localObject1 = paramChatMessage)
    {
      paramChatMessage = (ChatMessage)localObject1;
      break label115;
      l2 = System.currentTimeMillis();
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AioAnimationDetector", 2, "match duration: " + (l2 - l1) + " ms");
      return localObject1;
      break label292;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramAIOAnimationConatiner == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "handleUnreadMsgList, hasUnRead=" + this.jdField_a_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_Boolean) && (paramSessionInfo.jdField_a_of_type_Int != 1008))
      {
        int j = 0;
        int i;
        if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
          i = 1;
        }
        while ((i != 0) || (j != 0))
        {
          List localList = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -1L, true);
          long l = this.jdField_a_of_type_Long;
          j = 0;
          int n = localList.size();
          int m = 0;
          label141:
          ChatMessage localChatMessage;
          int k;
          ArrayList localArrayList;
          if (m < n)
          {
            localChatMessage = (ChatMessage)localList.get(m);
            if (i != 0)
            {
              k = j;
              if (localChatMessage.shmsgseq >= l)
              {
                k = j;
                if (!localChatMessage.isAioAnimChecked)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("AioAnimationDetector", 2, "handleUnreadMsgList, troop&discussion message ===> (" + localChatMessage.shmsgseq + ")");
                  }
                  boolean bool = false;
                  if (m == n - 1) {
                    bool = true;
                  }
                  localArrayList = a(localChatMessage);
                  this.jdField_a_of_type_Long = localChatMessage.shmsgseq;
                  if (localArrayList == null) {
                    break label474;
                  }
                  a(paramQQAppInterface, localArrayList, true, localChatMessage, bool, paramAIOAnimationConatiner, j * 800, paramSessionInfo.b, paramBaseChatPie);
                  j += 1;
                }
              }
            }
          }
          label474:
          for (;;)
          {
            k = j;
            for (;;)
            {
              m += 1;
              j = k;
              break label141;
              if (!abti.d(paramSessionInfo.jdField_a_of_type_Int)) {
                break label477;
              }
              j = 1;
              i = 0;
              break;
              k = j;
              if (localChatMessage.time >= l)
              {
                k = j;
                if (!localChatMessage.isAioAnimChecked)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("AioAnimationDetector", 2, "handleUnreadMsgList, c2c message ===> (" + localChatMessage.time + ")");
                  }
                  localArrayList = a(localChatMessage);
                  this.jdField_a_of_type_Long = localChatMessage.time;
                  k = j;
                  if (localArrayList != null)
                  {
                    a(paramQQAppInterface, localArrayList, false, localChatMessage, false, paramAIOAnimationConatiner, j * 800, paramSessionInfo.b, paramBaseChatPie);
                    k = j + 1;
                  }
                }
              }
            }
            this.jdField_a_of_type_Boolean = false;
            return;
          }
          label477:
          i = 0;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 1033) || (paramSessionInfo.jdField_a_of_type_Int == 1034))
    {
      break label20;
      break label20;
      break label20;
    }
    label20:
    label198:
    label464:
    label468:
    for (;;)
    {
      return;
      if ((!(paramMessageRecord instanceof MessageForArkFlashChat)) && (!this.jdField_a_of_type_Boolean))
      {
        if (this.jdField_a_of_type_Long == -1L)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AioAnimationDetector", 2, "handleNewMsg, lastMsgIdOrTime == -1, just return");
          return;
        }
        if ((paramSessionInfo.jdField_a_of_type_Int == 1008) || (abti.a(paramSessionInfo.jdField_a_of_type_Int) == 1032)) {
          break;
        }
        int j = 0;
        int i;
        if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
          i = 1;
        }
        for (;;)
        {
          label109:
          if (((i == 0) && (j == 0)) || (!paramSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) || ((paramSessionInfo.jdField_a_of_type_Int != paramMessageRecord.istroop) && ((j == 0) || (!abti.d(paramMessageRecord.istroop))))) {
            break label468;
          }
          paramMessageRecord = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
          aeus localaeus = a();
          long l = localaeus.jdField_a_of_type_Long;
          j = paramMessageRecord.size() - 1;
          ChatMessage localChatMessage;
          ArrayList localArrayList;
          if (j >= 0)
          {
            localChatMessage = (ChatMessage)paramMessageRecord.get(j);
            if (i == 0) {
              break label355;
            }
            if (localChatMessage.shmsgseq <= l) {
              break;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "handle troop&discussion new message ===> (" + localChatMessage.shmsgseq + ")");
              }
              localArrayList = localaeus.a(localChatMessage);
              if (localArrayList != null) {
                localaeus.a(paramQQAppInterface, localArrayList, true, localChatMessage, true, paramAIOAnimationConatiner, 0, paramSessionInfo.b, paramBaseChatPie);
              }
              localaeus.jdField_a_of_type_Long = localChatMessage.shmsgseq;
            }
          }
          for (;;)
          {
            j -= 1;
            break label198;
            break label20;
            if (!abti.d(paramSessionInfo.jdField_a_of_type_Int)) {
              break label464;
            }
            j = 1;
            i = 0;
            break label109;
            label355:
            if (localChatMessage.time <= l) {
              break;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "handle c2c new message ===> (" + localChatMessage.time + ")");
              }
              localArrayList = localaeus.a(localChatMessage);
              if (localArrayList != null) {
                localaeus.a(paramQQAppInterface, localArrayList, false, localChatMessage, true, paramAIOAnimationConatiner, 0, paramSessionInfo.b, paramBaseChatPie);
              }
              localaeus.jdField_a_of_type_Long = localChatMessage.time;
            }
          }
          i = 0;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList<aeuu> paramArrayList, boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, String paramString, BaseChatPie paramBaseChatPie)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null) || (paramAIOAnimationConatiner == null) || (paramArrayList == null) || (!a(paramChatMessage)))
    {
      return;
      break label75;
    }
    label75:
    aeuu localaeuu;
    int i;
    label445:
    label499:
    int n;
    label593:
    aeuw localaeuw;
    do
    {
      for (;;)
      {
        if (paramChatMessage.isAioAnimChecked)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect : message is checked, just return;");
          }
        }
        else
        {
          paramChatMessage.isAioAnimChecked = true;
          ntw localntw = (ntw)paramQQAppInterface.getManager(88);
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            localaeuu = (aeuu)localIterator.next();
            i = paramChatMessage.getRepeatCount();
            j = localaeuu.jdField_b_of_type_Int;
            m = localaeuu.c;
            if (QLog.isColorLevel()) {
              QLog.d("AioAnimationDetector", 2, "detect : troopOrDiscussion=" + paramBoolean1 + " matched (" + paramChatMessage.uniseq + "), rule: id=" + localaeuu.jdField_a_of_type_Int + ",M=" + i + ",X=" + j + ",Y=" + m + ",crazyMode=" + localaeuu.jdField_a_of_type_Boolean);
            }
            if (paramBoolean1) {
              break label499;
            }
            if ((j == 0) && (m == 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "detect c2c =======>  egg_jumper animation, crazyModeEnable=" + localaeuu.jdField_a_of_type_Boolean);
              }
              a(paramQQAppInterface, paramChatMessage, 0, 3, localaeuu);
              if ((paramChatMessage instanceof MessageForStructing)) {
                a(paramQQAppInterface, paramChatMessage, 0);
              }
              if (localaeuu.jdField_a_of_type_Boolean)
              {
                j = localaeuu.jdField_b_of_type_JavaUtilArrayList.size();
                i = 0;
                while (i < j)
                {
                  paramArrayList = (aeuw)localaeuu.jdField_b_of_type_JavaUtilArrayList.get(i);
                  paramArrayList = aeuw.a(paramQQAppInterface.getApplication(), paramArrayList);
                  k = i * 800;
                  this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.2(this, paramAIOAnimationConatiner, paramArrayList, k, localaeuu), paramInt + k);
                  i += 1;
                }
              }
              paramArrayList = (aeuw)localaeuu.jdField_b_of_type_JavaUtilArrayList.get(0);
              paramArrayList = aeuw.a(paramQQAppInterface.getApplication(), paramArrayList);
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.3(this, paramAIOAnimationConatiner, paramArrayList, localaeuu), paramInt);
              if ((localaeuu.jdField_a_of_type_Aeuv == null) || (localaeuu.jdField_a_of_type_Aeuv.jdField_a_of_type_Int != 1) || (localntw == null)) {
                break label1738;
              }
              localntw.jdField_b_of_type_Int = localaeuu.jdField_a_of_type_Aeuv.d;
              localntw.c = localaeuu.jdField_a_of_type_Aeuv.e;
            }
          }
        }
      }
      if ((j != 0) || (m != 0)) {
        break label982;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "detect =======>  egg_jumper animation ,crazyModeEnable=" + localaeuu.jdField_a_of_type_Boolean);
      }
      a(paramQQAppInterface, paramChatMessage, 1, 3, localaeuu);
      if ((paramChatMessage instanceof MessageForStructing)) {
        a(paramQQAppInterface, paramChatMessage, 1);
      }
      if (!localaeuu.jdField_a_of_type_Boolean) {
        break label933;
      }
      n = localaeuu.jdField_b_of_type_JavaUtilArrayList.size();
      i = 0;
      if (i >= n) {
        break;
      }
      localaeuw = (aeuw)localaeuu.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localaeuw.jdField_b_of_type_Int != 3) {
        break label883;
      }
    } while (paramBaseChatPie == null);
    int m = 0;
    int k = 0;
    label635:
    int j = m;
    String str;
    if (k < localaeuu.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((String)localaeuu.jdField_a_of_type_JavaUtilArrayList.get(k)).equals(paramChatMessage.msg)) {
        j = 1;
      }
    }
    else if (j != 0)
    {
      paramArrayList = (TroopManager)paramQQAppInterface.getManager(52);
      str = "";
      if (paramArrayList == null) {
        break label1758;
      }
    }
    label933:
    label982:
    label1758:
    for (paramArrayList = paramArrayList.b(paramString);; paramArrayList = null)
    {
      if (paramArrayList != null) {
        str = "" + paramArrayList.dwGroupClassExt;
      }
      azqs.b(paramQQAppInterface, "dc00898", "", paramQQAppInterface.getCurrentAccountUin(), "0X800AE16", "0X800AE16", localaeuu.jdField_a_of_type_Int, 0, paramString, str, "", "");
      boolean bool = nav.a().a(paramString);
      paramArrayList = (aevz)aoks.a().a(609);
      if ((paramArrayList != null) && (paramArrayList.a(paramString))) {}
      for (k = 1;; k = 0)
      {
        if ((k != 0) && (j != 0) && (!bool)) {
          ((bcgc)paramQQAppInterface.getManager(346)).a(paramString, paramChatMessage.senderuin, new aeut(this, paramQQAppInterface, paramString, paramChatMessage, localaeuu, localaeuw, paramBaseChatPie, paramInt));
        }
        for (;;)
        {
          i += 1;
          break label593;
          break;
          k += 1;
          break label635;
          label883:
          paramArrayList = aeuw.a(paramQQAppInterface.getApplication(), localaeuw);
          j = i * 800;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.5(this, paramAIOAnimationConatiner, paramArrayList, j, localaeuu), paramInt + j);
        }
        paramArrayList = (aeuw)localaeuu.jdField_b_of_type_JavaUtilArrayList.get(0);
        paramArrayList = aeuw.a(paramQQAppInterface.getApplication(), paramArrayList);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.6(this, paramAIOAnimationConatiner, paramArrayList, localaeuu), paramInt);
        break label445;
        if (j >= m) {
          break label445;
        }
        if (i < j) {
          break;
        }
        if (i == m)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect (M == Y) =======>  egg_combo animation, checkCombo= " + paramBoolean2);
          }
          if (paramBoolean2)
          {
            a(paramQQAppInterface, paramChatMessage, 1, 2, localaeuu);
            a(paramQQAppInterface, paramChatMessage, localaeuu);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.7(this, paramAIOAnimationConatiner, i, paramChatMessage), paramInt + 0);
          }
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect (M == Y) =======>  egg_jumper animation ,Y=" + m + ",crazyModeEnable=" + localaeuu.jdField_a_of_type_Boolean);
          }
          a(paramQQAppInterface, paramChatMessage, 1, 3, localaeuu);
          i = 0;
          label1149:
          if (i < m) {
            if (!paramBoolean2) {
              break label1746;
            }
          }
        }
        for (j = 1000;; j = 0)
        {
          if (localaeuu.jdField_a_of_type_Boolean)
          {
            n = localaeuu.jdField_b_of_type_JavaUtilArrayList.size();
            k = 0;
            while (k < n)
            {
              paramArrayList = (aeuw)localaeuu.jdField_b_of_type_JavaUtilArrayList.get(k);
              paramArrayList = aeuw.a(paramQQAppInterface.getApplication(), paramArrayList);
              int i1 = (k + i) * 800;
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.8(this, paramAIOAnimationConatiner, paramArrayList, i1, localaeuu), paramInt + j + i1);
              k += 1;
            }
          }
          paramArrayList = (aeuw)localaeuu.jdField_b_of_type_JavaUtilArrayList.get(0);
          paramArrayList = aeuw.a(paramQQAppInterface.getApplication(), paramArrayList);
          k = i * 800;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.9(this, paramAIOAnimationConatiner, paramArrayList, k, localaeuu), paramInt + j + k);
          i += 1;
          break label1149;
          break label445;
          if (i > m)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AioAnimationDetector", 2, "detect (M > Y) =======>  egg_combo animation, checkCombo= " + paramBoolean2);
            }
            if (paramBoolean2)
            {
              a(paramQQAppInterface, paramChatMessage, 1, 2, localaeuu);
              a(paramQQAppInterface, paramChatMessage, localaeuu);
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.10(this, paramAIOAnimationConatiner, i, paramChatMessage), paramInt + 0);
            }
            if (QLog.isColorLevel()) {
              QLog.d("AioAnimationDetector", 2, "detect (M > Y) =======>  egg_jumper animation ,Y=" + m + ",crazyModeEnable=" + localaeuu.jdField_a_of_type_Boolean);
            }
            a(paramQQAppInterface, paramChatMessage, 1, 3, localaeuu);
            if (!paramBoolean2) {
              break label1740;
            }
          }
          for (i = 1000;; i = 0)
          {
            if (localaeuu.jdField_a_of_type_Boolean)
            {
              k = localaeuu.jdField_b_of_type_JavaUtilArrayList.size();
              j = 0;
              while (j < k)
              {
                paramArrayList = (aeuw)localaeuu.jdField_b_of_type_JavaUtilArrayList.get(j);
                paramArrayList = aeuw.a(paramQQAppInterface.getApplication(), paramArrayList);
                m = j * 800;
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.11(this, paramAIOAnimationConatiner, paramArrayList, m, localaeuu), paramInt + i + m);
                j += 1;
              }
              break label445;
            }
            paramArrayList = (aeuw)localaeuu.jdField_b_of_type_JavaUtilArrayList.get(0);
            paramArrayList = aeuw.a(paramQQAppInterface.getApplication(), paramArrayList);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.12(this, paramAIOAnimationConatiner, paramArrayList, localaeuu), paramInt + i);
            break label445;
            if (QLog.isColorLevel()) {
              QLog.d("AioAnimationDetector", 2, "detect (X <= M < Y) ======>  egg_combo animation, checkCombo= " + paramBoolean2);
            }
            if (!paramBoolean2) {
              break;
            }
            a(paramQQAppInterface, paramChatMessage, 1, 2, localaeuu);
            a(paramQQAppInterface, paramChatMessage, localaeuu);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.13(this, paramAIOAnimationConatiner, i, paramChatMessage), 0 + paramInt);
            break label445;
            break label75;
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt1, Drawable paramDrawable, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = i * 800;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.1(this, paramAIOAnimationConatiner, paramDrawable, j), j + paramInt1);
      i += 1;
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if ((!(paramChatMessage instanceof MessageForText)) && (!(paramChatMessage instanceof MessageForLongMsg)) && (!(paramChatMessage instanceof MessageForStructing)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : not MessageForText and MessageForLongMsg and MessageFlashChat, return false;");
      }
      return false;
    }
    if ((paramChatMessage instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : messageForText");
      }
    }
    for (;;)
    {
      return true;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "checkMsgType : MessageForLongMsg");
        }
      }
      else if (((paramChatMessage instanceof MessageForStructing)) && (QLog.isColorLevel())) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : MessageForStructing");
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if (paramChatMessage != null) {
        break label36;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "msg type is MessageForStructing, strctMsg is null");
      }
    }
    return false;
    label36:
    return paramChatMessage instanceof AbsShareMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeus
 * JD-Core Version:    0.7.0.1
 */