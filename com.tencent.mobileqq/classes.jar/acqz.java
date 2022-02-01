import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ClearCountMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GeneralNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GroupSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ModifySyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.WaitingSyncMsg;

public class acqz
  implements acpi
{
  private static submsgtype0x44.MsgBody a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (submsgtype0x44.MsgBody)new submsgtype0x44.MsgBody().mergeFrom(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse failed.", paramArrayOfByte);
      }
    }
    return null;
  }
  
  private static void a(acnk paramacnk, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse start");
    }
    paramArrayOfByte = a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return;
    }
    a(paramArrayOfByte);
    a(paramacnk, b(paramacnk, paramArrayOfByte), a(paramacnk, paramArrayOfByte));
    c(paramacnk, paramArrayOfByte);
    b(paramacnk, paramArrayOfByte);
    a(paramacnk, paramArrayOfByte);
  }
  
  private static void a(acnk paramacnk, submsgtype0x44.MsgBody paramMsgBody)
  {
    if ((paramMsgBody.msg_waiting_msg_sync.has()) && (paramMsgBody.msg_waiting_msg_sync.get() != null)) {
      d(paramacnk, paramMsgBody);
    }
  }
  
  private static void a(acnk paramacnk, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) || (paramBoolean2)) {
      b(paramacnk, paramBoolean1, paramBoolean2);
    }
  }
  
  private static void a(submsgtype0x44.MsgBody paramMsgBody)
  {
    if (QLog.isColorLevel())
    {
      if ((paramMsgBody.msg_friend_msg_sync.has()) && (paramMsgBody.msg_friend_msg_sync.get() != null)) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync processflag=" + paramMsgBody.msg_friend_msg_sync.uint32_processflag.get() + ";processtype=" + paramMsgBody.msg_friend_msg_sync.uint32_processtype.get() + ";fuin" + paramMsgBody.msg_friend_msg_sync.uint64_fuin.get());
      }
      if ((paramMsgBody.msg_group_msg_sync.has()) && (paramMsgBody.msg_group_msg_sync.get() != null)) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync processflag=" + paramMsgBody.msg_group_msg_sync.uint32_processflag.get() + ";processtype=" + paramMsgBody.msg_group_msg_sync.uint32_msg_type.get() + ";grp_code=" + paramMsgBody.msg_group_msg_sync.uint64_grp_code.get());
      }
      if ((paramMsgBody.msg_clean_count_msg.has()) && (paramMsgBody.msg_clean_count_msg.get() != null)) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg processflag=" + paramMsgBody.msg_clean_count_msg.uint32_processflag.get());
      }
    }
  }
  
  private static boolean a(acnk paramacnk, submsgtype0x44.MsgBody paramMsgBody)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMsgBody.msg_group_msg_sync.has())
    {
      bool1 = bool2;
      if (paramMsgBody.msg_group_msg_sync.get() != null) {
        bool1 = c(paramacnk, paramMsgBody);
      }
    }
    bool2 = bool1;
    if (paramMsgBody.msg_general_notify.has())
    {
      bool2 = bool1;
      if (paramMsgBody.msg_general_notify.get() != null) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private static void b(acnk paramacnk, submsgtype0x44.MsgBody paramMsgBody)
  {
    if ((paramMsgBody.msg_modify_msg_sync.has()) && (paramMsgBody.msg_modify_msg_sync.get() != null)) {
      e(paramacnk, paramMsgBody);
    }
  }
  
  private static void b(acnk paramacnk, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      paramacnk.a().getMsgHandler().a().a(4);
    }
    do
    {
      return;
      if (paramBoolean1)
      {
        paramacnk.a().getMsgHandler().a().a(2);
        return;
      }
    } while (!paramBoolean2);
    paramacnk.a().getMsgHandler().a().a(3, 1, false);
  }
  
  private static boolean b(acnk paramacnk, submsgtype0x44.MsgBody paramMsgBody)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMsgBody.msg_friend_msg_sync.has())
    {
      bool1 = bool2;
      if (paramMsgBody.msg_friend_msg_sync.get() != null) {
        bool1 = d(paramacnk, paramMsgBody);
      }
    }
    return bool1;
  }
  
  private static void c(acnk paramacnk, submsgtype0x44.MsgBody paramMsgBody)
  {
    if ((paramMsgBody.msg_clean_count_msg.has()) && (paramMsgBody.msg_clean_count_msg.get() != null)) {
      f(paramacnk, paramMsgBody);
    }
  }
  
  private static boolean c(acnk paramacnk, submsgtype0x44.MsgBody paramMsgBody)
  {
    if (paramacnk.a(paramMsgBody.msg_group_msg_sync.uint32_processflag.get())) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramacnk.b(paramMsgBody.msg_group_msg_sync.uint32_msg_type.get()))
      {
        String str = String.valueOf(paramMsgBody.msg_group_msg_sync.uint64_grp_code.get());
        Object localObject = bdzz.a(paramMsgBody.msg_group_msg_sync.uint64_grp_code.get());
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (StringUtil.isValideUin(str)))
        {
          TroopManager localTroopManager = (TroopManager)paramacnk.a().getManager(QQManagerFactory.TROOP_MANAGER);
          if (localTroopManager.b(str) == null)
          {
            TroopInfo localTroopInfo = new TroopInfo();
            localTroopInfo.troopuin = str;
            localTroopInfo.troopcode = ((String)localObject);
            localTroopManager.a(localTroopInfo);
            localObject = (aoep)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
            ((aoep)localObject).a(localTroopInfo.troopuin, false, "SubType0x44.source_apply_for_join_troop", true, true, true, false);
            ((aoep)localObject).a(1, anrb.a(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
            ((aoep)localObject).f(str);
            ((aoep)localObject).notifyUI(6, true, new Object[] { Integer.valueOf(6), Byte.valueOf(0), str });
            ((aoep)localObject).notifyUI(127, true, new Object[] { str });
          }
          paramacnk.a(2001, true, null);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=" + paramMsgBody.msg_group_msg_sync.uint32_processflag.get() + ";uint32_msg_type=" + paramMsgBody.msg_group_msg_sync.uint32_msg_type.get());
      }
      return bool;
    }
  }
  
  private static void d(acnk paramacnk, submsgtype0x44.MsgBody paramMsgBody)
  {
    paramacnk.a().getMsgHandler().a().a(2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_waiting_msg_sync =" + paramMsgBody.msg_waiting_msg_sync.get());
    }
  }
  
  private static boolean d(acnk paramacnk, submsgtype0x44.MsgBody paramMsgBody)
  {
    if (paramacnk.a(paramMsgBody.msg_friend_msg_sync.uint32_processflag.get())) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramacnk.c(paramMsgBody.msg_friend_msg_sync.uint32_processtype.get()))
      {
        String str = String.valueOf(paramMsgBody.msg_friend_msg_sync.uint64_fuin.get());
        if ((!TextUtils.isEmpty(str)) && (StringUtil.isValideUin(str)))
        {
          paramacnk = (FriendListHandler)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          int i = paramMsgBody.msg_friend_msg_sync.uint32_sourceid.get();
          str = String.valueOf(str);
          if (!paramacnk.addFriendToFriendList(str, 0, i, null, false, false, -1L)) {
            paramacnk.getFriendDetailInfo(str);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=" + paramMsgBody.msg_friend_msg_sync.uint32_processflag.get() + ";uint32_processtype=" + paramMsgBody.msg_friend_msg_sync.uint32_processtype.get());
      }
      return bool;
    }
  }
  
  private static void e(acnk paramacnk, submsgtype0x44.MsgBody paramMsgBody)
  {
    paramacnk.a().getMsgHandler().a().b(2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_modify_msg_sync =" + paramMsgBody.msg_modify_msg_sync.get());
    }
  }
  
  private static void f(acnk paramacnk, submsgtype0x44.MsgBody paramMsgBody)
  {
    if (paramacnk.a(paramMsgBody.msg_clean_count_msg.uint32_processflag.get()))
    {
      paramacnk.a().getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - bdzy.a().a(paramacnk.a()));
      bdzy.a().a(paramacnk.a(), 0);
      bdzx.a().a(paramacnk.a(), 0);
      aizi localaizi = (aizi)paramacnk.a().getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
      paramacnk.a().getMessageFacade().setReaded(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
      localaizi.b();
    }
    int i = ((submsgtype0x44.ClearCountMsg)paramMsgBody.msg_clean_count_msg.get()).uint32_updateflag.get();
    if (i > 0) {
      paramacnk.a().getMsgHandler().a().a(2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg uint32_processflag=" + paramMsgBody.msg_clean_count_msg.uint32_processflag.get() + " updateFlag=" + i);
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramLong, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqz
 * JD-Core Version:    0.7.0.1
 */