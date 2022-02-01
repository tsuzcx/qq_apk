import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import tencent.im.c2c.msgtype0x210.submsgtype0x79.submsgtype0x79.MsgBody;

public class acbj
  implements abzb
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UndealCount.ZebraAlbum.Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor receive zebarunread push message, seq = " + paramMsgInfo.shMsgSeq + "submsgtype:" + paramMsgInfo.shMsgType);
    }
    try
    {
      paramMsgInfo = new submsgtype0x79.MsgBody();
      paramMsgInfo.mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgInfo.uint32_src_app_id.get();
      int i = paramMsgInfo.uint32_undeal_count.get();
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.ZebraAlbum.Q.msg.BaseMessageProcessor", 2, "OnLinePushMessageProcessor receive zebarunread count: " + i);
      }
      int j = LocalMultiProcConfig.getInt4Uin("NavigatorItemShow7", -1, paramQQAppInterface.getLongAccountUin());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "account: " + paramQQAppInterface.getLongAccountUin() + " QZoneGetFeedAlertRequest read NavigatorItemShow 7 from sharerefrence value: " + j);
      }
      if (j == 1)
      {
        paramMsgInfo = (bbox)paramQQAppInterface.getManager(10);
        paramMsgType0x210 = new ArrayList();
        QZoneCountUserInfo localQZoneCountUserInfo = new QZoneCountUserInfo();
        localQZoneCountUserInfo.uin = paramQQAppInterface.getLongAccountUin();
        paramMsgType0x210.add(localQZoneCountUserInfo);
        paramMsgInfo.a(17, i, paramMsgType0x210, "", false, true, "");
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbj
 * JD-Core Version:    0.7.0.1
 */