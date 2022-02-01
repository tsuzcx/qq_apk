import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
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
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class agbc
{
  private static volatile agbc jdField_a_of_type_Agbc;
  public volatile long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ConcurrentHashMap<Integer, CopyOnWriteArraySet<Long>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public volatile boolean a;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  
  private agbc()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static agbc a()
  {
    if (jdField_a_of_type_Agbc == null) {}
    try
    {
      if (jdField_a_of_type_Agbc == null) {
        jdField_a_of_type_Agbc = new agbc();
      }
      return jdField_a_of_type_Agbc;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, agbe paramagbe)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (agbq.a(paramagbe)) {
        afur.a(paramQQAppInterface, true);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, agbe paramagbe, boolean paramBoolean, ChatMessage paramChatMessage)
  {
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramagbe.jdField_a_of_type_Int));
    if (localCopyOnWriteArraySet == null) {}
    do
    {
      return;
      if (localCopyOnWriteArraySet.contains(Long.valueOf(paramChatMessage.shmsgseq)))
      {
        if (paramBoolean) {
          agbq.a(paramQQAppInterface, "0X800B071", paramChatMessage.frienduin, paramagbe);
        }
        localCopyOnWriteArraySet.remove(Long.valueOf(paramChatMessage.shmsgseq));
      }
    } while (!bgnk.a(localCopyOnWriteArraySet));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramagbe.jdField_a_of_type_Int));
  }
  
  private void a(QQAppInterface paramQQAppInterface, AIOAnimationConatiner paramAIOAnimationConatiner, Drawable paramDrawable, int paramInt, agbe paramagbe, ChatMessage paramChatMessage)
  {
    if (paramagbe.jdField_a_of_type_Agbf == null) {}
    for (int i = -1;; i = paramagbe.jdField_a_of_type_Agbf.jdField_a_of_type_Int)
    {
      boolean bool = paramAIOAnimationConatiner.a(2, 300, new Object[] { paramDrawable, Integer.valueOf(paramInt), Integer.valueOf(i), paramagbe, paramChatMessage });
      a(paramQQAppInterface, paramagbe);
      a(paramQQAppInterface, paramagbe, bool, paramChatMessage);
      return;
    }
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
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt1, int paramInt2, agbe paramagbe)
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
      bcst.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_rec", 0, 0, String.valueOf(i), String.valueOf(paramagbe.jdField_a_of_type_Int), "", "");
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
      bcst.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_launch", 0, 0, String.valueOf(i), String.valueOf(paramagbe.jdField_a_of_type_Int), "", "");
      return;
    }
    label134:
    if (!paramChatMessage.isSendFromLocal())
    {
      bcst.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_rec", 0, 0, String.valueOf(i), String.valueOf(paramagbe.jdField_a_of_type_Int), "", "");
      return;
    }
    bcst.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_launch", 0, 0, String.valueOf(i), String.valueOf(paramagbe.jdField_a_of_type_Int), "", "");
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, agbe paramagbe)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("AioAnimationDetector", 2, "detect combo =======> isLastStackMessageFromOthers ? " + this.jdField_b_of_type_Boolean + "  lastStackMessageSeq=" + this.jdField_b_of_type_Long + "thisMessageSeq=" + paramChatMessage.shmsgseq);
    }
    if ((paramChatMessage.isSendFromLocal()) && (this.jdField_b_of_type_Boolean) && (paramChatMessage.shmsgseq == this.jdField_b_of_type_Long + 1L)) {
      bcst.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Eggs_stack_new", 0, 0, String.valueOf(0), String.valueOf(paramagbe.jdField_a_of_type_Int), "", "");
    }
    if (!paramChatMessage.isSendFromLocal()) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    this.jdField_b_of_type_Long = paramChatMessage.shmsgseq;
  }
  
  private void a(QQAppInterface paramQQAppInterface, @NonNull ArrayList<agbe> paramArrayList, ChatMessage paramChatMessage)
  {
    if (!paramChatMessage.isSend()) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        agbe localagbe = (agbe)paramArrayList.next();
        agbq.a(paramQQAppInterface, "0X800B070", paramChatMessage.frienduin, localagbe);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, agbe paramagbe)
  {
    try
    {
      CopyOnWriteArraySet localCopyOnWriteArraySet2 = (CopyOnWriteArraySet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramagbe.jdField_a_of_type_Int));
      CopyOnWriteArraySet localCopyOnWriteArraySet1 = localCopyOnWriteArraySet2;
      if (localCopyOnWriteArraySet2 == null)
      {
        localCopyOnWriteArraySet1 = new CopyOnWriteArraySet();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramagbe.jdField_a_of_type_Int), localCopyOnWriteArraySet1);
      }
      localCopyOnWriteArraySet1.add(Long.valueOf(paramChatMessage.shmsgseq));
      return;
    }
    finally {}
  }
  
  public String a(AbsShareMsg paramAbsShareMsg)
  {
    if ((paramAbsShareMsg != null) && (paramAbsShareMsg.getItemCount() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramAbsShareMsg = paramAbsShareMsg.iterator();
      while (paramAbsShareMsg.hasNext())
      {
        Object localObject = (bcvs)paramAbsShareMsg.next();
        if ((localObject instanceof bcvt))
        {
          localObject = ((bcvt)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            bcvs localbcvs = (bcvs)((Iterator)localObject).next();
            String str = localbcvs.jdField_a_of_type_JavaLangString;
            if ("title".equals(str)) {
              localStringBuilder.append(((StructMsgItemTitle)localbcvs).b());
            } else if ("summary".equals(str)) {
              localStringBuilder.append(((bdaq)localbcvs).b());
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public ArrayList<agbe> a(ChatMessage paramChatMessage)
  {
    Object localObject3 = null;
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
    ArrayList localArrayList;
    do
    {
      return localObject2;
      localArrayList = agbb.a().a();
      if (localArrayList != null) {
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
    label116:
    long l2;
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localIterator = localArrayList.iterator();
        paramChatMessage = (ChatMessage)localObject3;
        localObject1 = paramChatMessage;
        if (localIterator.hasNext())
        {
          localObject1 = (agbe)localIterator.next();
          if (((agbe)localObject1).jdField_a_of_type_JavaUtilArrayList == null) {
            break label436;
          }
          int i = 0;
          for (;;)
          {
            if (i >= ((agbe)localObject1).jdField_a_of_type_JavaUtilArrayList.size()) {
              break label436;
            }
            localObject3 = (String)((agbe)localObject1).jdField_a_of_type_JavaUtilArrayList.get(i);
            if ((localObject2 != null) && (((String)localObject2).contains((CharSequence)localObject3)))
            {
              if (((agbe)localObject1).jdField_a_of_type_Agbf == null) {
                break;
              }
              l2 = System.currentTimeMillis() / 1000L;
              if ((((agbe)localObject1).jdField_a_of_type_Agbf.jdField_a_of_type_Int != 1) || ((((agbe)localObject1).jdField_a_of_type_Agbf.jdField_b_of_type_Int <= l2) && (((agbe)localObject1).jdField_a_of_type_Agbf.c >= l2))) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "JD red pack,But not in date.");
              }
            }
            i += 1;
          }
          localObject2 = paramChatMessage.msg;
          continue;
          if (paramChatMessage != null) {
            break label433;
          }
          paramChatMessage = new ArrayList();
          label294:
          localObject3 = new agbe((agbe)localObject1);
          ((agbe)localObject3).jdField_b_of_type_Int = i;
          paramChatMessage.add(localObject3);
          localObject1 = paramChatMessage;
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "matched ===> rule: id=" + ((agbe)localObject3).jdField_a_of_type_Int + ", index = " + ((agbe)localObject3).jdField_b_of_type_Int);
          }
        }
      }
    }
    label433:
    label436:
    for (localObject1 = paramChatMessage;; localObject1 = paramChatMessage)
    {
      paramChatMessage = (ChatMessage)localObject1;
      break label116;
      l2 = System.currentTimeMillis();
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AioAnimationDetector", 2, "match duration: " + (l2 - l1) + " ms");
      return localObject1;
      break label294;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
                    break label463;
                  }
                  a(paramQQAppInterface, localArrayList, true, localChatMessage, bool, paramAIOAnimationConatiner, j * 800, paramBaseChatPie);
                  j += 1;
                }
              }
            }
          }
          label463:
          for (;;)
          {
            k = j;
            for (;;)
            {
              m += 1;
              j = k;
              break label139;
              if (!acwh.d(paramSessionInfo.jdField_a_of_type_Int)) {
                break label466;
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
                    a(paramQQAppInterface, localArrayList, false, localChatMessage, false, paramAIOAnimationConatiner, j * 800, paramBaseChatPie);
                    k = j + 1;
                  }
                }
              }
            }
            this.jdField_a_of_type_Boolean = false;
            return;
          }
          label466:
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
    label448:
    label452:
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
        if ((paramSessionInfo.jdField_a_of_type_Int == 1008) || (acwh.a(paramSessionInfo.jdField_a_of_type_Int) == 1032)) {
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
          if (((i == 0) && (j == 0)) || (!paramSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) || ((paramSessionInfo.jdField_a_of_type_Int != paramMessageRecord.istroop) && ((j == 0) || (!acwh.d(paramMessageRecord.istroop))))) {
            break label452;
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
              break label346;
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
                paramMessageRecord.a(paramQQAppInterface, localArrayList, true, localChatMessage, true, paramAIOAnimationConatiner, 0, paramBaseChatPie);
              }
              paramMessageRecord.jdField_a_of_type_Long = localChatMessage.shmsgseq;
            }
          }
          for (;;)
          {
            j -= 1;
            break label196;
            break label20;
            if (!acwh.d(paramSessionInfo.jdField_a_of_type_Int)) {
              break label448;
            }
            j = 1;
            i = 0;
            break label109;
            label346:
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
                paramMessageRecord.a(paramQQAppInterface, localArrayList, false, localChatMessage, true, paramAIOAnimationConatiner, 0, paramBaseChatPie);
              }
              paramMessageRecord.jdField_a_of_type_Long = localChatMessage.time;
            }
          }
          i = 0;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList<agbe> paramArrayList, boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, BaseChatPie paramBaseChatPie)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null) || (paramAIOAnimationConatiner == null) || (paramArrayList == null) || (!a(paramChatMessage))) {}
    agbe localagbe;
    int i;
    int j;
    int m;
    Object localObject;
    int k;
    label467:
    label615:
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (!paramChatMessage.isAioAnimChecked) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("AioAnimationDetector", 2, "detect : message is checked, just return;");
        return;
        paramChatMessage.isAioAnimChecked = true;
        oda localoda = (oda)paramQQAppInterface.getManager(88);
        Iterator localIterator = paramArrayList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label1742;
          }
          localagbe = (agbe)localIterator.next();
          a(paramChatMessage, localagbe);
          i = paramChatMessage.getRepeatCount();
          j = localagbe.c;
          m = localagbe.d;
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect : troopOrDiscussion=" + paramBoolean1 + " matched (" + paramChatMessage.uniseq + "), rule: id=" + localagbe.jdField_a_of_type_Int + ",M=" + i + ",X=" + j + ",Y=" + m + ",crazyMode=" + localagbe.jdField_a_of_type_Boolean);
          }
          if (paramBoolean1) {
            break;
          }
          if ((j == 0) && (m == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AioAnimationDetector", 2, "detect c2c =======>  egg_jumper animation, crazyModeEnable=" + localagbe.jdField_a_of_type_Boolean);
            }
            a(paramQQAppInterface, paramChatMessage, 0, 3, localagbe);
            if ((paramChatMessage instanceof MessageForStructing)) {
              a(paramQQAppInterface, paramChatMessage, 0);
            }
            if (localagbe.jdField_a_of_type_Boolean)
            {
              j = localagbe.jdField_b_of_type_JavaUtilArrayList.size();
              i = 0;
              while (i < j)
              {
                localObject = (agbg)localagbe.jdField_b_of_type_JavaUtilArrayList.get(i);
                localObject = agbg.a(paramQQAppInterface.getApplication(), (agbg)localObject);
                k = i * 800;
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.2(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, k, localagbe, paramChatMessage), paramInt + k);
                i += 1;
              }
            }
            localObject = (agbg)localagbe.jdField_b_of_type_JavaUtilArrayList.get(0);
            localObject = agbg.a(paramQQAppInterface.getApplication(), (agbg)localObject);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.3(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, localagbe, paramChatMessage), paramInt);
            if ((localagbe.jdField_a_of_type_Agbf == null) || (localagbe.jdField_a_of_type_Agbf.jdField_a_of_type_Int != 1) || (localoda == null)) {
              break label1740;
            }
            localoda.jdField_b_of_type_Int = localagbe.jdField_a_of_type_Agbf.d;
            localoda.c = localagbe.jdField_a_of_type_Agbf.e;
          }
        }
        if ((j != 0) || (m != 0)) {
          break label956;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect =======>  egg_jumper animation ,crazyModeEnable=" + localagbe.jdField_a_of_type_Boolean);
        }
        a(paramQQAppInterface, paramChatMessage, 1, 3, localagbe);
        if ((paramChatMessage instanceof MessageForStructing)) {
          a(paramQQAppInterface, paramChatMessage, 1);
        }
        if (!localagbe.jdField_a_of_type_Boolean) {
          break label900;
        }
        j = localagbe.jdField_b_of_type_JavaUtilArrayList.size();
        i = 0;
        if (i >= j) {
          break;
        }
        localObject = (agbg)localagbe.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (((agbg)localObject).c != 3) {
          break label845;
        }
      } while (paramBaseChatPie == null);
      str = paramChatMessage.frienduin;
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "curTroopUin : " + str);
      }
    } while (TextUtils.isEmpty(str));
    boolean bool2 = njo.a().a(str);
    agcl localagcl = (agcl)aqlk.a().a(609);
    if ((localagcl != null) && (localagcl.a(str))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "bManageOpen : " + bool1 + " curTroopUin : " + str);
      }
      if ((bool1) && (!bool2)) {
        ((bfgp)paramQQAppInterface.getManager(346)).a(str, paramChatMessage.senderuin, new agbd(this, str, paramQQAppInterface, paramChatMessage, localagbe, (agbg)localObject, paramBaseChatPie, paramInt));
      }
      for (;;)
      {
        i += 1;
        break label615;
        break;
        label845:
        localObject = agbg.a(paramQQAppInterface.getApplication(), (agbg)localObject);
        k = i * 800;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.5(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, k, localagbe, paramChatMessage), paramInt + k);
      }
      label900:
      localObject = (agbg)localagbe.jdField_b_of_type_JavaUtilArrayList.get(0);
      localObject = agbg.a(paramQQAppInterface.getApplication(), (agbg)localObject);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.6(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, localagbe, paramChatMessage), paramInt);
      break label467;
      label956:
      if (j >= m) {
        break label467;
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
          a(paramQQAppInterface, paramChatMessage, 1, 2, localagbe);
          a(paramQQAppInterface, paramChatMessage, localagbe);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.7(this, paramAIOAnimationConatiner, i, paramChatMessage), paramInt + 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect (M == Y) =======>  egg_jumper animation ,Y=" + m + ",crazyModeEnable=" + localagbe.jdField_a_of_type_Boolean);
        }
        a(paramQQAppInterface, paramChatMessage, 1, 3, localagbe);
        i = 0;
        label1123:
        if (i < m) {
          if (!paramBoolean2) {
            break label1757;
          }
        }
      }
      label1740:
      label1742:
      label1751:
      label1757:
      for (j = 1000;; j = 0)
      {
        if (localagbe.jdField_a_of_type_Boolean)
        {
          int n = localagbe.jdField_b_of_type_JavaUtilArrayList.size();
          k = 0;
          while (k < n)
          {
            localObject = (agbg)localagbe.jdField_b_of_type_JavaUtilArrayList.get(k);
            localObject = agbg.a(paramQQAppInterface.getApplication(), (agbg)localObject);
            int i1 = (k + i) * 800;
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.8(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, i1, localagbe, paramChatMessage), paramInt + j + i1);
            k += 1;
          }
        }
        localObject = (agbg)localagbe.jdField_b_of_type_JavaUtilArrayList.get(0);
        localObject = agbg.a(paramQQAppInterface.getApplication(), (agbg)localObject);
        k = i * 800;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.9(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, k, localagbe, paramChatMessage), j + paramInt + k);
        i += 1;
        break label1123;
        break label467;
        if (i > m)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect (M > Y) =======>  egg_combo animation, checkCombo= " + paramBoolean2);
          }
          if (paramBoolean2)
          {
            a(paramQQAppInterface, paramChatMessage, 1, 2, localagbe);
            a(paramQQAppInterface, paramChatMessage, localagbe);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.10(this, paramAIOAnimationConatiner, i, paramChatMessage), paramInt + 0);
          }
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect (M > Y) =======>  egg_jumper animation ,Y=" + m + ",crazyModeEnable=" + localagbe.jdField_a_of_type_Boolean);
          }
          a(paramQQAppInterface, paramChatMessage, 1, 3, localagbe);
          if (!paramBoolean2) {
            break label1751;
          }
        }
        for (i = 1000;; i = 0)
        {
          if (localagbe.jdField_a_of_type_Boolean)
          {
            k = localagbe.jdField_b_of_type_JavaUtilArrayList.size();
            j = 0;
            while (j < k)
            {
              localObject = (agbg)localagbe.jdField_b_of_type_JavaUtilArrayList.get(j);
              localObject = agbg.a(paramQQAppInterface.getApplication(), (agbg)localObject);
              m = j * 800;
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.11(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, m, localagbe, paramChatMessage), paramInt + i + m);
              j += 1;
            }
            break label467;
          }
          localObject = (agbg)localagbe.jdField_b_of_type_JavaUtilArrayList.get(0);
          localObject = agbg.a(paramQQAppInterface.getApplication(), (agbg)localObject);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.12(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, localagbe, paramChatMessage), paramInt + i);
          break label467;
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect (X <= M < Y) ======>  egg_combo animation, checkCombo= " + paramBoolean2);
          }
          if (!paramBoolean2) {
            break;
          }
          a(paramQQAppInterface, paramChatMessage, 1, 2, localagbe);
          a(paramQQAppInterface, paramChatMessage, localagbe);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.13(this, paramAIOAnimationConatiner, i, paramChatMessage), 0 + paramInt);
          break label467;
          break;
          a(paramQQAppInterface, paramArrayList, paramChatMessage);
          return;
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
 * Qualified Name:     agbc
 * JD-Core Version:    0.7.0.1
 */