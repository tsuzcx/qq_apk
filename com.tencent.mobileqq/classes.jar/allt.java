import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xefe.oidb_cmd0xefe.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class allt
  extends BusinessHandler
{
  protected allt(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected allt(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("FilterMsgBoxHandler", 2, "onReceiverOxefe() called with: resultCode = [" + i + "], req = [" + paramToServiceMsg + "], res = [" + paramFromServiceMsg + "]");
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (Exception paramFromServiceMsg)
    {
      for (;;)
      {
        QLog.d("FilterMsgBoxHandler", 1, "onReceiverOxefe()  e =", paramFromServiceMsg);
      }
    }
    notifyUI(paramToServiceMsg.uint32_result.get(), true, null);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterMsgBoxHandler", 2, "sendDelPbReq() called with: uin = [" + paramLong + "]");
    }
    oidb_cmd0xefe.ReqBody localReqBody = new oidb_cmd0xefe.ReqBody();
    localReqBody.friend_uin.set(paramLong);
    localReqBody.last_ts.set(allw.a());
    sendPbReq(makeOIDBPkg("OidbSvc.0xefe", 3838, 3, localReqBody.toByteArray()));
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return allu.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramObject == null)) {
      QLog.e("FilterMsgBoxHandler", 1, "[onReceive] params: res: " + paramFromServiceMsg + ". data: " + paramObject);
    }
    while (!"OidbSvc.0xefe".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allt
 * JD-Core Version:    0.7.0.1
 */