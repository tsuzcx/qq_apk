import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodePushNotify;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;

public class adcp
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x10b");
    }
    wwh localwwh = (wwh)paramQQAppInterface.getManager(252);
    try
    {
      qqstory_service.MsgTabNodePushNotify localMsgTabNodePushNotify = new qqstory_service.MsgTabNodePushNotify();
      localMsgTabNodePushNotify.mergeFrom(paramMsgType0x210.vProtobuf);
      paramQQAppInterface = (wwg)paramQQAppInterface.getManager(251);
      if (localwwh.a) {
        paramQQAppInterface.a().a(localMsgTabNodePushNotify);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0xf3], errInfo->" + paramQQAppInterface.getMessage());
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcp
 * JD-Core Version:    0.7.0.1
 */