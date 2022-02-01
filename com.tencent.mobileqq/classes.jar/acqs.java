import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tencent.im.s2c.msgtype0x210.submsgtype0x31.submsgtype0x31.MsgBody;

public class acqs
  implements acpi
{
  public static void a(acnk paramacnk, int paramInt, bdxt parambdxt, long paramLong)
  {
    Object localObject1 = (bdxj)paramacnk.a().getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
    if (paramInt == 1)
    {
      bdxj.a(paramacnk.a(), (byte)0, parambdxt.c);
      bdxj.a(paramacnk.a(), parambdxt.c);
      parambdxt.a = 1;
      ((bdxj)localObject1).a(parambdxt.c, 1);
      paramacnk.a(8004, true, parambdxt);
    }
    while (paramInt != 0) {
      return;
    }
    localObject1 = String.valueOf(paramLong);
    bdxs localbdxs = (bdxs)paramacnk.a().getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    parambdxt.a((String)localObject1);
    localbdxs.a(parambdxt);
    Object localObject2 = parambdxt.a();
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint is new,msg num=1, subUin=" + str);
        }
        paramInt = 1 - paramacnk.a().getConversationFacade().a(str, 7000);
        if (paramInt != 0) {
          paramacnk.a().getConversationFacade().d(str, 7000, paramInt);
        }
      }
    }
    boolean bool = false;
    localObject2 = bdxj.a(paramacnk.a(), (String)localObject1);
    if (localObject2 != null) {
      bool = ((Boolean)((Pair)localObject2).second).booleanValue();
    }
    if (bool)
    {
      localbdxs.a((String)localObject1, 1);
      paramacnk.a().getSubAccountKey(paramacnk.a().getAccount(), String.valueOf(paramLong), new acqt(paramacnk, localbdxs));
    }
    for (;;)
    {
      parambdxt.a = 0;
      paramacnk.a(8004, true, parambdxt);
      return;
      if (localbdxs.a(String.valueOf(paramLong), 2))
      {
        paramInt = 1 - paramacnk.a().getConversationFacade().a((String)localObject1, 7000);
        if (paramInt != 0)
        {
          paramacnk.a().getConversationFacade().d((String)localObject1, 7000, paramInt);
          paramacnk.a().getMessageFacade().setChangeAndNotify(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, localObject1 });
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint need to verify,msg num=1, subUin=" + (String)localObject1);
        }
      }
    }
  }
  
  private static void a(acnk paramacnk, long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x31.MsgBody();
    try
    {
      paramArrayOfByte = (submsgtype0x31.MsgBody)((submsgtype0x31.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new HashMap();
        paramArrayOfByte.put("param_FailCode", "12017");
        paramArrayOfByte.put("fail_step", "msgbyod_null");
        paramArrayOfByte.put("fail_location", "MessageHandler");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramacnk.a().getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      int i;
      long l1;
      long l2;
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramArrayOfByte);
          }
          paramArrayOfByte = null;
        }
        if ((!paramArrayOfByte.uint32_flag.has()) || (!paramArrayOfByte.uint64_bind_uin.has()) || (!paramArrayOfByte.uint64_uin.has()))
        {
          paramArrayOfByte = new HashMap();
          paramArrayOfByte.put("param_FailCode", "12017");
          paramArrayOfByte.put("fail_step", "uinflag_null");
          paramArrayOfByte.put("fail_location", "MessageHandler");
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramacnk.a().getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
          return;
        }
        i = paramArrayOfByte.uint32_flag.get();
        l1 = paramArrayOfByte.uint32_time.get();
        l1 = paramArrayOfByte.uint64_uin.get();
        l2 = paramArrayOfByte.uint64_bind_uin.get();
        if ((l1 <= 0L) || (l2 <= 0L))
        {
          paramArrayOfByte = new HashMap();
          paramArrayOfByte.put("param_FailCode", "12017");
          paramArrayOfByte.put("fail_step", "uin_error");
          paramArrayOfByte.put("fail_location", "MessageHandler");
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramacnk.a().getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
          return;
        }
      } while (!String.valueOf(paramLong).equalsIgnoreCase(paramacnk.a().getAccount()));
      paramArrayOfByte = new bdxt();
      paramArrayOfByte.c = String.valueOf(l1);
      paramArrayOfByte.b = String.valueOf(l2);
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", "12018");
      ((HashMap)localObject).put("fail_step", "success_" + i);
      ((HashMap)localObject).put("fail_location", "MessageHandler");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramacnk.a().getCurrentAccountUin(), "actSBPushNotifaction", true, 0L, 0L, (HashMap)localObject, "");
      a(paramacnk, i, paramArrayOfByte, l1);
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramLong, paramArrayOfByte);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqs
 * JD-Core Version:    0.7.0.1
 */