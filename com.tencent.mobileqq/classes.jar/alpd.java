import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public abstract class alpd
  extends aloy
{
  public static final int MM_APPID = 1000277;
  public final QQAppInterface app;
  public final AppInterface mApp;
  
  protected alpd(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (this.app = ((QQAppInterface)paramAppInterface);; this.app = null)
    {
      this.mApp = paramAppInterface;
      return;
    }
  }
  
  protected alpd(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mApp = paramQQAppInterface;
  }
  
  public static <T extends MessageMicro<T>> T decodeOidb(String paramString, byte[] paramArrayOfByte, Class<T> paramClass)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
      if ((!paramArrayOfByte.uint32_result.has()) || (paramArrayOfByte.uint32_result.get() != 0) || (!paramArrayOfByte.bytes_bodybuffer.has()) || (paramArrayOfByte.bytes_bodybuffer.get() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e(paramString, 2, "sso check fail " + paramArrayOfByte.uint32_result.get());
        }
        return null;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e(paramString, 2, "merge fail " + paramArrayOfByte.toString());
      }
      return null;
    }
    try
    {
      paramClass = (MessageMicro)paramClass.newInstance();
      paramClass.mergeFrom(paramArrayOfByte.bytes_bodybuffer.get().toByteArray());
      return paramClass;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e(paramString, 2, "rspBody merge fail " + paramArrayOfByte.toString());
      }
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  protected void checkReportErrorToMM(FromServiceMsg paramFromServiceMsg)
  {
    if (reportErrorToMM(paramFromServiceMsg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("msgCmdFilter", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + getCurrentAccountUin());
      }
      bfhz.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), getCurrentAccountUin(), 1000277, alud.a(2131701646) + paramFromServiceMsg.getServiceCmd(), true);
    }
  }
  
  public String getCurrentAccountUin()
  {
    return this.mApp.getCurrentAccountUin();
  }
  
  public List<alpg> getObservers(int paramInt)
  {
    return this.mApp.getBusinessObserver(paramInt);
  }
  
  protected final boolean isPbReq(ToServiceMsg paramToServiceMsg)
  {
    boolean bool = false;
    if (paramToServiceMsg != null) {
      bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    }
    return bool;
  }
  
  protected boolean reportErrorToMM(FromServiceMsg paramFromServiceMsg)
  {
    return (!paramFromServiceMsg.isSuccess()) && ((paramFromServiceMsg.getServiceCmd().equals("EncounterSvc.ReqGetEncounter")) || (paramFromServiceMsg.getServiceCmd().equals("RoamClientSvr.GetQualify")) || (paramFromServiceMsg.getServiceCmd().equals("NeighborSvc.ReqGetPoint")));
  }
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    this.mApp.sendToService(paramToServiceMsg);
  }
  
  public void sendPbReq(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      this.mApp.sendToService(paramToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alpd
 * JD-Core Version:    0.7.0.1
 */