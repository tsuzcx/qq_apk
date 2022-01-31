import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.1;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.10;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.11;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.12;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.2;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.3;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.4;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.5;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.6;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.7;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.8;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.9;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class acoa
{
  private static volatile acoa jdField_a_of_type_Acoa;
  public volatile long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public volatile boolean a;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  
  private acoa()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static acoa a()
  {
    if (jdField_a_of_type_Acoa == null) {}
    try
    {
      if (jdField_a_of_type_Acoa == null) {
        jdField_a_of_type_Acoa = new acoa();
      }
      return jdField_a_of_type_Acoa;
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
        bajr.a(paramQQAppInterface, "Vip_StructuredEgg", str1, str1, 0, 0, new String[0]);
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
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt1, int paramInt2, acob paramacob)
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
      awqx.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_rec", 0, 0, String.valueOf(i), String.valueOf(paramacob.jdField_a_of_type_Int), "", "");
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
      awqx.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_launch", 0, 0, String.valueOf(i), String.valueOf(paramacob.jdField_a_of_type_Int), "", "");
      return;
    }
    label134:
    if (!paramChatMessage.isSendFromLocal())
    {
      awqx.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_rec", 0, 0, String.valueOf(i), String.valueOf(paramacob.jdField_a_of_type_Int), "", "");
      return;
    }
    awqx.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_launch", 0, 0, String.valueOf(i), String.valueOf(paramacob.jdField_a_of_type_Int), "", "");
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, acob paramacob)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("AioAnimationDetector", 2, "detect combo =======> isLastStackMessageFromOthers ? " + this.jdField_b_of_type_Boolean + "  lastStackMessageSeq=" + this.jdField_b_of_type_Long + "thisMessageSeq=" + paramChatMessage.shmsgseq);
    }
    if ((paramChatMessage.isSendFromLocal()) && (this.jdField_b_of_type_Boolean) && (paramChatMessage.shmsgseq == this.jdField_b_of_type_Long + 1L)) {
      awqx.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Eggs_stack_new", 0, 0, String.valueOf(0), String.valueOf(paramacob.jdField_a_of_type_Int), "", "");
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
        Object localObject = (awul)paramAbsShareMsg.next();
        if ((localObject instanceof awum))
        {
          localObject = ((awum)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            awul localawul = (awul)((Iterator)localObject).next();
            String str = localawul.jdField_a_of_type_JavaLangString;
            if ("title".equals(str)) {
              localStringBuilder.append(((StructMsgItemTitle)localawul).b());
            } else if ("summary".equals(str)) {
              localStringBuilder.append(((awzf)localawul).b());
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public ArrayList<acob> a(ChatMessage paramChatMessage)
  {
    acob localacob = null;
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
      localObject3 = acnz.a().a();
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
        paramChatMessage = localacob;
        localObject1 = paramChatMessage;
        if (localIterator.hasNext())
        {
          localacob = (acob)localIterator.next();
          if (localacob.jdField_a_of_type_JavaUtilArrayList == null) {
            break label401;
          }
          localObject1 = localacob.jdField_a_of_type_JavaUtilArrayList.iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label401;
            }
            localObject3 = (String)((Iterator)localObject1).next();
            if ((localObject2 != null) && (((String)localObject2).contains((CharSequence)localObject3)))
            {
              if (localacob.jdField_a_of_type_Acoc == null) {
                break;
              }
              l2 = System.currentTimeMillis() / 1000L;
              if ((localacob.jdField_a_of_type_Acoc.jdField_a_of_type_Int != 1) || ((localacob.jdField_a_of_type_Acoc.jdField_b_of_type_Int <= l2) && (localacob.jdField_a_of_type_Acoc.c >= l2))) {
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
          paramChatMessage.add(localacob);
          localObject1 = paramChatMessage;
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "matched ===> rule: id=" + localacob.jdField_a_of_type_Int);
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
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
          paramSessionInfo = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -1L, true);
          long l = this.jdField_a_of_type_Long;
          j = 0;
          int n = paramSessionInfo.size();
          int m = 0;
          label139:
          ChatMessage localChatMessage;
          int k;
          ArrayList localArrayList;
          if (m < n)
          {
            localChatMessage = (ChatMessage)paramSessionInfo.get(m);
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
                    break label459;
                  }
                  a(paramQQAppInterface, localArrayList, true, localChatMessage, bool, paramAIOAnimationConatiner, j * 800);
                  j += 1;
                }
              }
            }
          }
          label459:
          for (;;)
          {
            k = j;
            for (;;)
            {
              m += 1;
              j = k;
              break label139;
              if (!akbm.c(paramSessionInfo.jdField_a_of_type_Int)) {
                break label462;
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
                    a(paramQQAppInterface, localArrayList, false, localChatMessage, false, paramAIOAnimationConatiner, j * 800);
                    k = j + 1;
                  }
                }
              }
            }
            this.jdField_a_of_type_Boolean = false;
            return;
          }
          label462:
          i = 0;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 1033) || (paramSessionInfo.jdField_a_of_type_Int == 1034))
    {
      break label20;
      break label20;
      break label20;
    }
    label20:
    label444:
    label448:
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
        if ((paramSessionInfo.jdField_a_of_type_Int == 1008) || (akbm.a(paramSessionInfo.jdField_a_of_type_Int) == 1032)) {
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
          if (((i == 0) && (j == 0)) || (!paramSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) || ((paramSessionInfo.jdField_a_of_type_Int != paramMessageRecord.istroop) && ((j == 0) || (!akbm.c(paramMessageRecord.istroop))))) {
            break label448;
          }
          paramSessionInfo = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
          paramMessageRecord = a();
          long l = paramMessageRecord.jdField_a_of_type_Long;
          j = paramSessionInfo.size() - 1;
          label196:
          ChatMessage localChatMessage;
          ArrayList localArrayList;
          if (j >= 0)
          {
            localChatMessage = (ChatMessage)paramSessionInfo.get(j);
            if (i == 0) {
              break label344;
            }
            if (localChatMessage.shmsgseq <= l) {
              break;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "handle troop&discussion new message ===> (" + localChatMessage.shmsgseq + ")");
              }
              localArrayList = paramMessageRecord.a(localChatMessage);
              if (localArrayList != null) {
                paramMessageRecord.a(paramQQAppInterface, localArrayList, true, localChatMessage, true, paramAIOAnimationConatiner, 0);
              }
              paramMessageRecord.jdField_a_of_type_Long = localChatMessage.shmsgseq;
            }
          }
          for (;;)
          {
            j -= 1;
            break label196;
            break label20;
            if (!akbm.c(paramSessionInfo.jdField_a_of_type_Int)) {
              break label444;
            }
            j = 1;
            i = 0;
            break label109;
            label344:
            if (localChatMessage.time <= l) {
              break;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "handle c2c new message ===> (" + localChatMessage.time + ")");
              }
              localArrayList = paramMessageRecord.a(localChatMessage);
              if (localArrayList != null) {
                paramMessageRecord.a(paramQQAppInterface, localArrayList, false, localChatMessage, true, paramAIOAnimationConatiner, 0);
              }
              paramMessageRecord.jdField_a_of_type_Long = localChatMessage.time;
            }
          }
          i = 0;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList<acob> paramArrayList, boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null) || (paramAIOAnimationConatiner == null) || (paramArrayList == null) || (!a(paramChatMessage))) {}
    label74:
    acob localacob;
    int i;
    int m;
    Object localObject;
    int k;
    label450:
    label504:
    do
    {
      return;
      break label74;
      break label74;
      do
      {
        if (!paramChatMessage.isAioAnimChecked) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AioAnimationDetector", 2, "detect : message is checked, just return;");
      return;
      paramChatMessage.isAioAnimChecked = true;
      nfp localnfp = (nfp)paramQQAppInterface.getManager(88);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localacob = (acob)paramArrayList.next();
        i = paramChatMessage.getRepeatCount();
        j = localacob.jdField_b_of_type_Int;
        m = localacob.c;
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect : troopOrDiscussion=" + paramBoolean1 + " matched (" + paramChatMessage.uniseq + "), rule: id=" + localacob.jdField_a_of_type_Int + ",M=" + i + ",X=" + j + ",Y=" + m + ",crazyMode=" + localacob.jdField_a_of_type_Boolean);
        }
        if (paramBoolean1) {
          break label504;
        }
        if ((j == 0) && (m == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect c2c =======>  egg_jumper animation, crazyModeEnable=" + localacob.jdField_a_of_type_Boolean);
          }
          a(paramQQAppInterface, paramChatMessage, 0, 3, localacob);
          if ((paramChatMessage instanceof MessageForStructing)) {
            a(paramQQAppInterface, paramChatMessage, 0);
          }
          if (localacob.jdField_a_of_type_Boolean)
          {
            j = localacob.jdField_b_of_type_JavaUtilArrayList.size();
            i = 0;
            while (i < j)
            {
              localObject = (acod)localacob.jdField_b_of_type_JavaUtilArrayList.get(i);
              localObject = acod.a(paramQQAppInterface.getApplication(), (acod)localObject);
              k = i * 800;
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.2(this, paramAIOAnimationConatiner, (Drawable)localObject, k, localacob), paramInt + k);
              i += 1;
            }
          }
          localObject = (acod)localacob.jdField_b_of_type_JavaUtilArrayList.get(0);
          localObject = acod.a(paramQQAppInterface.getApplication(), (acod)localObject);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.3(this, paramAIOAnimationConatiner, (Drawable)localObject, localacob), paramInt);
        }
      }
      do
      {
        for (;;)
        {
          if ((localacob.jdField_a_of_type_Acoc == null) || (localacob.jdField_a_of_type_Acoc.jdField_a_of_type_Int != 1) || (localnfp == null)) {
            break label1503;
          }
          localnfp.jdField_b_of_type_Int = localacob.jdField_a_of_type_Acoc.d;
          localnfp.c = localacob.jdField_a_of_type_Acoc.e;
          break label74;
          break;
          if ((j != 0) || (m != 0)) {
            break label731;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect =======>  egg_jumper animation ,crazyModeEnable=" + localacob.jdField_a_of_type_Boolean);
          }
          a(paramQQAppInterface, paramChatMessage, 1, 3, localacob);
          if ((paramChatMessage instanceof MessageForStructing)) {
            a(paramQQAppInterface, paramChatMessage, 1);
          }
          if (localacob.jdField_a_of_type_Boolean)
          {
            j = localacob.jdField_b_of_type_JavaUtilArrayList.size();
            i = 0;
            while (i < j)
            {
              localObject = (acod)localacob.jdField_b_of_type_JavaUtilArrayList.get(i);
              localObject = acod.a(paramQQAppInterface.getApplication(), (acod)localObject);
              k = i * 800;
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.4(this, paramAIOAnimationConatiner, (Drawable)localObject, k, localacob), paramInt + k);
              i += 1;
            }
          }
          else
          {
            localObject = (acod)localacob.jdField_b_of_type_JavaUtilArrayList.get(0);
            localObject = acod.a(paramQQAppInterface.getApplication(), (acod)localObject);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.5(this, paramAIOAnimationConatiner, (Drawable)localObject, localacob), paramInt);
          }
        }
      } while (j >= m);
    } while (i < j);
    label731:
    if (i == m)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "detect (M == Y) =======>  egg_combo animation, checkCombo= " + paramBoolean2);
      }
      if (paramBoolean2)
      {
        a(paramQQAppInterface, paramChatMessage, 1, 2, localacob);
        a(paramQQAppInterface, paramChatMessage, localacob);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.6(this, paramAIOAnimationConatiner, i, paramChatMessage), paramInt + 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "detect (M == Y) =======>  egg_jumper animation ,Y=" + m + ",crazyModeEnable=" + localacob.jdField_a_of_type_Boolean);
      }
      a(paramQQAppInterface, paramChatMessage, 1, 3, localacob);
      i = 0;
      if (i < m) {
        if (!paramBoolean2) {
          break label1511;
        }
      }
    }
    label898:
    label1503:
    label1505:
    label1511:
    for (int j = 1000;; j = 0)
    {
      if (localacob.jdField_a_of_type_Boolean)
      {
        int n = localacob.jdField_b_of_type_JavaUtilArrayList.size();
        k = 0;
        while (k < n)
        {
          localObject = (acod)localacob.jdField_b_of_type_JavaUtilArrayList.get(k);
          localObject = acod.a(paramQQAppInterface.getApplication(), (acod)localObject);
          int i1 = (k + i) * 800;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.7(this, paramAIOAnimationConatiner, (Drawable)localObject, i1, localacob), paramInt + j + i1);
          k += 1;
        }
      }
      localObject = (acod)localacob.jdField_b_of_type_JavaUtilArrayList.get(0);
      localObject = acod.a(paramQQAppInterface.getApplication(), (acod)localObject);
      k = i * 800;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.8(this, paramAIOAnimationConatiner, (Drawable)localObject, k, localacob), paramInt + j + k);
      i += 1;
      break label898;
      break label450;
      if (i > m)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect (M > Y) =======>  egg_combo animation, checkCombo= " + paramBoolean2);
        }
        if (paramBoolean2)
        {
          a(paramQQAppInterface, paramChatMessage, 1, 2, localacob);
          a(paramQQAppInterface, paramChatMessage, localacob);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.9(this, paramAIOAnimationConatiner, i, paramChatMessage), paramInt + 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect (M > Y) =======>  egg_jumper animation ,Y=" + m + ",crazyModeEnable=" + localacob.jdField_a_of_type_Boolean);
        }
        a(paramQQAppInterface, paramChatMessage, 1, 3, localacob);
        if (!paramBoolean2) {
          break label1505;
        }
      }
      for (i = 1000;; i = 0)
      {
        if (localacob.jdField_a_of_type_Boolean)
        {
          k = localacob.jdField_b_of_type_JavaUtilArrayList.size();
          j = 0;
          while (j < k)
          {
            localObject = (acod)localacob.jdField_b_of_type_JavaUtilArrayList.get(j);
            localObject = acod.a(paramQQAppInterface.getApplication(), (acod)localObject);
            m = j * 800;
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.10(this, paramAIOAnimationConatiner, (Drawable)localObject, m, localacob), paramInt + i + m);
            j += 1;
          }
          break label450;
        }
        localObject = (acod)localacob.jdField_b_of_type_JavaUtilArrayList.get(0);
        localObject = acod.a(paramQQAppInterface.getApplication(), (acod)localObject);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.11(this, paramAIOAnimationConatiner, (Drawable)localObject, localacob), paramInt + i);
        break label450;
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect (X <= M < Y) ======>  egg_combo animation, checkCombo= " + paramBoolean2);
        }
        if (!paramBoolean2) {
          break;
        }
        a(paramQQAppInterface, paramChatMessage, 1, 2, localacob);
        a(paramQQAppInterface, paramChatMessage, localacob);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.12(this, paramAIOAnimationConatiner, i, paramChatMessage), 0 + paramInt);
        break label450;
        break label74;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acoa
 * JD-Core Version:    0.7.0.1
 */