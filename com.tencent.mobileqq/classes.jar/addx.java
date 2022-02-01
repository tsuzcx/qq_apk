import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ClearCountMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GroupSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ModifySyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.WaitingSyncMsg;

public class addx
  implements adci
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
  
  private static void a(adan paramadan, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse start");
    }
    paramArrayOfByte = a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return;
    }
    a(paramArrayOfByte);
    a(paramadan, b(paramadan, paramArrayOfByte), a(paramadan, paramArrayOfByte));
    c(paramadan, paramArrayOfByte);
    b(paramadan, paramArrayOfByte);
    a(paramadan, paramArrayOfByte);
  }
  
  private static void a(adan paramadan, submsgtype0x44.MsgBody paramMsgBody)
  {
    if ((paramMsgBody.msg_waiting_msg_sync.has()) && (paramMsgBody.msg_waiting_msg_sync.get() != null)) {
      d(paramadan, paramMsgBody);
    }
  }
  
  private static void a(adan paramadan, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) || (paramBoolean2)) {
      b(paramadan, paramBoolean1, paramBoolean2);
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
  
  private static boolean a(adan paramadan, submsgtype0x44.MsgBody paramMsgBody)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMsgBody.msg_group_msg_sync.has())
    {
      bool1 = bool2;
      if (paramMsgBody.msg_group_msg_sync.get() != null) {
        bool1 = c(paramadan, paramMsgBody);
      }
    }
    return bool1;
  }
  
  private static void b(adan paramadan, submsgtype0x44.MsgBody paramMsgBody)
  {
    if ((paramMsgBody.msg_modify_msg_sync.has()) && (paramMsgBody.msg_modify_msg_sync.get() != null)) {
      e(paramadan, paramMsgBody);
    }
  }
  
  private static void b(adan paramadan, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      paramadan.a().a().a().a(4);
    }
    do
    {
      return;
      if (paramBoolean1)
      {
        paramadan.a().a().a().a(2);
        return;
      }
    } while (!paramBoolean2);
    paramadan.a().a().a().a(3, 1, false);
  }
  
  private static boolean b(adan paramadan, submsgtype0x44.MsgBody paramMsgBody)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMsgBody.msg_friend_msg_sync.has())
    {
      bool1 = bool2;
      if (paramMsgBody.msg_friend_msg_sync.get() != null) {
        bool1 = d(paramadan, paramMsgBody);
      }
    }
    return bool1;
  }
  
  private static void c(adan paramadan, submsgtype0x44.MsgBody paramMsgBody)
  {
    if ((paramMsgBody.msg_clean_count_msg.has()) && (paramMsgBody.msg_clean_count_msg.get() != null)) {
      f(paramadan, paramMsgBody);
    }
  }
  
  private static boolean c(adan paramadan, submsgtype0x44.MsgBody paramMsgBody)
  {
    if (paramadan.a(paramMsgBody.msg_group_msg_sync.uint32_processflag.get())) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramadan.b(paramMsgBody.msg_group_msg_sync.uint32_msg_type.get()))
      {
        String str = String.valueOf(paramMsgBody.msg_group_msg_sync.uint64_grp_code.get());
        Object localObject = bdzj.a(paramMsgBody.msg_group_msg_sync.uint64_grp_code.get());
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (bhsr.c(str)))
        {
          TroopManager localTroopManager = (TroopManager)paramadan.a().getManager(52);
          if (localTroopManager.b(str) == null)
          {
            TroopInfo localTroopInfo = new TroopInfo();
            localTroopInfo.troopuin = str;
            localTroopInfo.troopcode = ((String)localObject);
            localTroopManager.a(localTroopInfo);
            localObject = (aoip)paramadan.a().a(20);
            ((aoip)localObject).a(localTroopInfo.troopuin, false, "", true, true, true, false);
            ((aoip)localObject).a(1, antz.a(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
            ((aoip)localObject).f(str);
            ((aoip)localObject).notifyUI(6, true, new Object[] { Integer.valueOf(6), Byte.valueOf(0), str });
            ((aoip)localObject).notifyUI(127, true, new Object[] { str });
          }
          paramadan.a(2001, true, null);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=" + paramMsgBody.msg_group_msg_sync.uint32_processflag.get() + ";uint32_msg_type=" + paramMsgBody.msg_group_msg_sync.uint32_msg_type.get());
      }
      return bool;
    }
  }
  
  private static void d(adan paramadan, submsgtype0x44.MsgBody paramMsgBody)
  {
    paramadan.a().a().a().a(2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_waiting_msg_sync =" + paramMsgBody.msg_waiting_msg_sync.get());
    }
  }
  
  private static boolean d(adan paramadan, submsgtype0x44.MsgBody paramMsgBody)
  {
    if (paramadan.a(paramMsgBody.msg_friend_msg_sync.uint32_processflag.get())) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramadan.c(paramMsgBody.msg_friend_msg_sync.uint32_processtype.get()))
      {
        String str = String.valueOf(paramMsgBody.msg_friend_msg_sync.uint64_fuin.get());
        if ((!TextUtils.isEmpty(str)) && (bhsr.c(str)))
        {
          paramadan = (FriendListHandler)paramadan.a().a(1);
          int i = paramMsgBody.msg_friend_msg_sync.uint32_sourceid.get();
          str = String.valueOf(str);
          if (!paramadan.a(str, 0, i, null, false, false, -1L)) {
            paramadan.a(str);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=" + paramMsgBody.msg_friend_msg_sync.uint32_processflag.get() + ";uint32_processtype=" + paramMsgBody.msg_friend_msg_sync.uint32_processtype.get());
      }
      return bool;
    }
  }
  
  private static void e(adan paramadan, submsgtype0x44.MsgBody paramMsgBody)
  {
    paramadan.a().a().a().b(2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_modify_msg_sync =" + paramMsgBody.msg_modify_msg_sync.get());
    }
  }
  
  private static void f(adan paramadan, submsgtype0x44.MsgBody paramMsgBody)
  {
    if (paramadan.a(paramMsgBody.msg_clean_count_msg.uint32_processflag.get()))
    {
      paramadan.a().a().d(antf.W, 9000, 0 - bdzi.a().a(paramadan.a()));
      bdzi.a().a(paramadan.a(), 0);
      bdzh.a().a(paramadan.a(), 0);
      ajka localajka = (ajka)paramadan.a().getManager(34);
      paramadan.a().a().a(antf.M, 0, true, true);
      localajka.b();
    }
    int i = ((submsgtype0x44.ClearCountMsg)paramMsgBody.msg_clean_count_msg.get()).uint32_updateflag.get();
    if (i > 0) {
      paramadan.a().a().a().a(2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg uint32_processflag=" + paramMsgBody.msg_clean_count_msg.uint32_processflag.get() + " updateFlag=" + i);
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan, paramLong, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addx
 * JD-Core Version:    0.7.0.1
 */