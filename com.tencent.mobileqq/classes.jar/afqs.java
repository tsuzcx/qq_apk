import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class afqs
{
  public static int a;
  public static HashMap<Integer, bhjs> a;
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
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(jdField_a_of_type_Int), new bhjs(2131365307, localBaseApplication.getString(2131691263), 2130838983));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(b), new bhjs(2131367213, localBaseApplication.getString(2131692550), 2130838991));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(c), new bhjs(2131371641, localBaseApplication.getString(2131694155), 2130838999));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(d), new bhjs(2131371684, localBaseApplication.getString(2131694187), 2130839001));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(e), new bhjs(2131365475, localBaseApplication.getString(2131690756), 2130838986));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(f), new bhjs(2131366254, localBaseApplication.getString(2131719547), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(g), new bhjs(2131366255, localBaseApplication.getString(2131719548), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(h), new bhjs(2131366456, localBaseApplication.getString(2131692126), 2130838990));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new bhjs(2131380506, localBaseApplication.getString(2131690900), 0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), new bhjs(2131376534, localBaseApplication.getString(2131697435), 2130838997));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(k), new bhjs(2131376547, localBaseApplication.getString(2131697441), 2130838997));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(l), new bhjs(2131362494, localBaseApplication.getString(2131689979), 2130839001));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(o), new bhjs(2131362494, localBaseApplication.getString(2131689979), 2130839001));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(m), new bhjs(2131376588, localBaseApplication.getString(2131717998), 2130838998));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(n), new bhjs(2131364266, localBaseApplication.getString(2131690755), 2130838980));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(p), new bhjs(2131367235, localBaseApplication.getString(2131692550), 2130838991));
  }
  
  public static bhjs a(int paramInt)
  {
    return (bhjs)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public static void a(int paramInt, bhjq parambhjq)
  {
    bhjs localbhjs = a(paramInt);
    parambhjq.a(localbhjs.a(), localbhjs.a(), localbhjs.b());
  }
  
  public static void a(@NonNull ChatMessage paramChatMessage, @NonNull bhjq parambhjq)
  {
    if ((!AppSetting.i) && (paramChatMessage.istroop == 0)) {}
    while (acnh.a(paramChatMessage.istroop) == 1032) {
      return;
    }
    a(e, parambhjq);
  }
  
  public static void a(MessageRecord paramMessageRecord, bhjq parambhjq)
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
              } while ((!a(paramMessageRecord, (QQAppInterface)localObject1)) || ((!paramMessageRecord.isSend()) && (!TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr((QQAppInterface)localObject1, paramMessageRecord, ((QQAppInterface)localObject1).getCurrentAccountUin()))) || ((nty.a(paramMessageRecord)) && (!argp.a().a)) || (acnh.a(paramMessageRecord.istroop) == 1032));
              localObject2 = (anvk)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
            } while ((paramMessageRecord.istroop == 0) && (!((anvk)localObject2).b(paramMessageRecord.frienduin)));
            if (paramMessageRecord.istroop != 1) {
              break;
            }
            localObject2 = (HotChatManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
          } while ((localObject2 != null) && (((HotChatManager)localObject2).b(paramMessageRecord.frienduin)));
          if ((paramMessageRecord.msgtype != -5008) || (!(paramMessageRecord instanceof MessageForArkApp))) {
            break;
          }
          localObject2 = (MessageForArkApp)paramMessageRecord;
        } while ((((MessageForArkApp)localObject2).ark_app_message != null) && (((MessageForArkApp)localObject2).ark_app_message.appName.equals("com.tencent.mannounce")));
      } while (!a(paramMessageRecord));
      a(c, parambhjq);
    } while (!TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr((QQAppInterface)localObject1, paramMessageRecord, ((QQAppInterface)localObject1).getCurrentAccountUin()));
    parambhjq = new bdlf((QQAppInterface)localObject1).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
    localObject2 = paramMessageRecord.frienduin;
    if (TroopUtils.isTroopOwner((QQAppInterface)localObject1, paramMessageRecord.frienduin, ((QQAppInterface)localObject1).getCurrentAccountUin())) {}
    for (paramMessageRecord = "1";; paramMessageRecord = "2")
    {
      parambhjq.a(new String[] { localObject2, paramMessageRecord }).a();
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
  
  public static void b(@NonNull ChatMessage paramChatMessage, @NonNull bhjq parambhjq)
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
          a(j, parambhjq);
          MessageForReplyText.reportReplyMsg((QQAppInterface)localObject, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
          return;
        }
      } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.istroop == 3000));
      a(j, parambhjq);
      MessageForReplyText.reportReplyMsg((QQAppInterface)localObject, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
      return;
    }
  }
  
  public static void c(ChatMessage paramChatMessage, bhjq parambhjq)
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
          if ((!bghs.b((QQAppInterface)localObject, paramChatMessage.senderuin)) && (!nty.a(paramChatMessage)) && (!aqvh.a(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (paramChatMessage.isSupportReply())) {
            break label173;
          }
          if (QLog.isColorLevel())
          {
            parambhjq = new StringBuilder("addReplyOnlyMenu isRobot=").append(bghs.b((QQAppInterface)localObject, paramChatMessage.senderuin)).append(" isAnonymousMsg=").append(nty.a(paramChatMessage)).append(" isConfessMsg=").append(aqvh.a(paramChatMessage)).append(" isNotSupport=");
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
        a(k, parambhjq);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768));
    a(k, parambhjq);
  }
  
  public static void d(ChatMessage paramChatMessage, bhjq parambhjq)
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
        i1 = bflj.a((QQAppInterface)localObject, new bfkz(l1, paramChatMessage.shmsgseq, bcsc.b(paramChatMessage.msgUid)), paramChatMessage);
        if (i1 == 2)
        {
          a(g, parambhjq);
          return;
        }
      } while (i1 != 1);
      a(f, parambhjq);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqs
 * JD-Core Version:    0.7.0.1
 */