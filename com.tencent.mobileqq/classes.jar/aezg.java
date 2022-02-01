import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class aezg
{
  public static int a;
  public static HashMap<Integer, bgbb> a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static int m;
  public static int n;
  public static int o;
  public static int p;
  
  static
  {
    jdField_a_of_type_Int = 1;
    b = 2;
    c = 4;
    d = 8;
    e = 16;
    f = 32;
    g = 64;
    h = 128;
    i = 256;
    j = 512;
    k = 1024;
    l = 2048;
    m = 4096;
    n = 4096;
    o = 4096;
    p = 4096;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(jdField_a_of_type_Int), new bgbb(2131365216, localBaseApplication.getString(2131691178), 2130838963));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(b), new bgbb(2131367094, localBaseApplication.getString(2131692448), 2130838971));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(c), new bgbb(2131371455, localBaseApplication.getString(2131693964), 2130838979));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(d), new bgbb(2131371498, localBaseApplication.getString(2131693996), 2130838981));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(e), new bgbb(2131365382, localBaseApplication.getString(2131690679), 2130838966));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(f), new bgbb(2131366153, localBaseApplication.getString(2131719142), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(g), new bgbb(2131366154, localBaseApplication.getString(2131719143), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(h), new bgbb(2131366347, localBaseApplication.getString(2131692036), 2130838970));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new bgbb(2131380171, localBaseApplication.getString(2131690815), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), new bgbb(2131376279, localBaseApplication.getString(2131697158), 2130838977));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(k), new bgbb(2131376292, localBaseApplication.getString(2131697164), 2130838977));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(l), new bgbb(2131362481, localBaseApplication.getString(2131689950), 2130838981));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(o), new bgbb(2131362481, localBaseApplication.getString(2131689950), 2130838981));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(m), new bgbb(2131376333, localBaseApplication.getString(2131717631), 2130838978));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(n), new bgbb(2131364189, localBaseApplication.getString(2131690678), 2130838960));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(p), new bgbb(2131367116, localBaseApplication.getString(2131692448), 2130838971));
  }
  
  public static bgbb a(int paramInt)
  {
    return (bgbb)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public static void a(int paramInt, bgaz parambgaz)
  {
    bgbb localbgbb = a(paramInt);
    parambgaz.a(localbgbb.a(), localbgbb.a(), localbgbb.b());
  }
  
  public static void a(@NonNull ChatMessage paramChatMessage, @NonNull bgaz parambgaz)
  {
    if ((!AppSetting.i) && (paramChatMessage.istroop == 0)) {}
    while (abwz.a(paramChatMessage.istroop) == 1032) {
      return;
    }
    a(e, parambgaz);
  }
  
  public static void a(MessageRecord paramMessageRecord, bgaz parambgaz)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      localObject1 = localObject2;
      if (localAppRuntime != null)
      {
        localObject1 = localObject2;
        if ((localAppRuntime instanceof QQAppInterface)) {
          localObject1 = (QQAppInterface)localAppRuntime;
        }
      }
    }
    if (localObject1 == null) {}
    label46:
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
              break label46;
              break label46;
              break label46;
              do
              {
                return;
              } while ((!a(paramMessageRecord, (QQAppInterface)localObject1)) || ((!paramMessageRecord.isSend()) && (!TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr((QQAppInterface)localObject1, paramMessageRecord, ((QQAppInterface)localObject1).getCurrentAccountUin()))) || ((nmy.a(paramMessageRecord)) && (!aqdi.a().a)) || (abwz.a(paramMessageRecord.istroop) == 1032));
              localObject2 = (amsw)((QQAppInterface)localObject1).getManager(51);
            } while ((paramMessageRecord.istroop == 0) && (!((amsw)localObject2).b(paramMessageRecord.frienduin)));
            if (paramMessageRecord.istroop != 1) {
              break;
            }
            localObject2 = (HotChatManager)((QQAppInterface)localObject1).getManager(60);
          } while ((localObject2 != null) && (((HotChatManager)localObject2).b(paramMessageRecord.frienduin)));
          if ((paramMessageRecord.msgtype != -5008) || (!(paramMessageRecord instanceof MessageForArkApp))) {
            break;
          }
          localObject2 = (MessageForArkApp)paramMessageRecord;
        } while ((((MessageForArkApp)localObject2).ark_app_message != null) && (((MessageForArkApp)localObject2).ark_app_message.appName.equals("com.tencent.mannounce")));
      } while (!a(paramMessageRecord));
      a(c, parambgaz);
    } while (!TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr((QQAppInterface)localObject1, paramMessageRecord, ((QQAppInterface)localObject1).getCurrentAccountUin()));
    parambgaz = new bcek((QQAppInterface)localObject1).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
    localObject2 = paramMessageRecord.frienduin;
    if (TroopUtils.isTroopOwner((QQAppInterface)localObject1, paramMessageRecord.frienduin, ((QQAppInterface)localObject1).getCurrentAccountUin())) {}
    for (paramMessageRecord = "1";; paramMessageRecord = "2")
    {
      parambgaz.a(new String[] { localObject2, paramMessageRecord }).a();
      return;
    }
  }
  
  private static boolean a(MessageRecord paramMessageRecord)
  {
    int i1 = paramMessageRecord.istroop;
    return (i1 == 0) || (i1 == 1) || (i1 == 3000) || (i1 == 1000) || (i1 == 1004);
  }
  
  public static boolean a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = TroopUtils.isTroopOwnerOrAdmin(paramQQAppInterface, paramMessageRecord, paramQQAppInterface.getCurrentAccountUin());
    return ((l1 - paramMessageRecord.time * 1000L < 120000L) && (!bool)) || ((bool) && (paramMessageRecord.isSend())) || (paramMessageRecord.msgtype == -2005) || (TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr(paramQQAppInterface, paramMessageRecord, paramQQAppInterface.getCurrentAccountUin()));
  }
  
  public static void b(@NonNull ChatMessage paramChatMessage, @NonNull bgaz parambgaz)
  {
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 0))
    {
      if (BaseApplicationImpl.sProcessId != 1) {
        break label164;
      }
      localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {
        break label164;
      }
    }
    label164:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {}
      do
      {
        return;
        if ((!paramChatMessage.isSend()) && (paramChatMessage.isSupportReply()))
        {
          a(j, parambgaz);
          MessageForReplyText.reportReplyMsg((QQAppInterface)localObject, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
          return;
        }
      } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.istroop == 3000));
      a(j, parambgaz);
      MessageForReplyText.reportReplyMsg((QQAppInterface)localObject, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
      return;
    }
  }
  
  public static void c(ChatMessage paramChatMessage, bgaz parambgaz)
  {
    boolean bool;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        localObject = (QQAppInterface)localObject;
        if (paramChatMessage.istroop == 1)
        {
          if ((!bezm.b((QQAppInterface)localObject, paramChatMessage.senderuin)) && (!nmy.a(paramChatMessage)) && (!apse.a(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (paramChatMessage.isSupportReply())) {
            break label173;
          }
          if (QLog.isColorLevel())
          {
            parambgaz = new StringBuilder("addReplyOnlyMenu isRobot=").append(bezm.b((QQAppInterface)localObject, paramChatMessage.senderuin)).append(" isAnonymousMsg=").append(nmy.a(paramChatMessage)).append(" isConfessMsg=").append(apse.a(paramChatMessage)).append(" isNotSupport=");
            if (paramChatMessage.isSupportReply()) {
              break label168;
            }
            bool = true;
            QLog.d("BaseBubbleBuilderMenuHelper", 2, bool);
          }
        }
      }
    }
    label168:
    label173:
    do
    {
      return;
      bool = false;
      break;
      if (!paramChatMessage.isSend())
      {
        a(k, parambgaz);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768));
    a(k, parambgaz);
  }
  
  public static void d(ChatMessage paramChatMessage, bgaz parambgaz)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {}
    }
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {}
      int i1;
      do
      {
        do
        {
          return;
        } while (paramChatMessage.istroop != 1);
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(paramChatMessage.frienduin);
          l1 = l2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        i1 = beeg.a((QQAppInterface)localObject, new bedw(l1, paramChatMessage.shmsgseq, bblk.b(paramChatMessage.msgUid)), paramChatMessage);
        if (i1 == 2)
        {
          a(g, parambgaz);
          return;
        }
      } while (i1 != 1);
      a(f, parambgaz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezg
 * JD-Core Version:    0.7.0.1
 */