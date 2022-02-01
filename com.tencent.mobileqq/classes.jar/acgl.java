import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.WPATmp;

public class acgl
  implements abyl
{
  public int a()
  {
    return 1005;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getMsgCache().b(paramMessageRecord.frienduin);
    msg_svc.WPATmp localWPATmp = new msg_svc.WPATmp();
    localWPATmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    if (paramQQAppInterface != null)
    {
      paramMessageRecord = new byte[paramQQAppInterface.length - 2];
      PkgTools.copyData(paramMessageRecord, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
      if (QLog.isColorLevel()) {
        QLog.d("WPARoutingType", 2, "wpa------>" + HexUtil.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
      }
      localWPATmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.wpa_tmp.set(localWPATmp);
    return true;
  }
  
  public int b()
  {
    return 7000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgl
 * JD-Core Version:    0.7.0.1
 */