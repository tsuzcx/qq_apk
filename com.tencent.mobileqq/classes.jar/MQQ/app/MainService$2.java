package mqq.app;

import android.os.Process;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.VerifyCodeManager;
import mqq.manager.VerifyDevLockManager;
import mqq.os.MqqRegulatorCallback;
import mqq.util.MqqConnRateReport;
import mqq.util.MqqConnRateReport.EventType;

class MainService$2
  implements Runnable
{
  MainService$2(MainService paramMainService) {}
  
  private void handleResp(MsfMessagePair paramMsfMessagePair)
  {
    paramMsfMessagePair.fromServiceMsg.setAppSeq(paramMsfMessagePair.toServiceMsg.getAppSeq());
    MainService.access$200(this.this$0).handleRespMsg(paramMsfMessagePair.toServiceMsg, paramMsfMessagePair.fromServiceMsg);
  }
  
  public void run()
  {
    com.tencent.qphone.base.util.BaseApplication.gMsfReceiverStarted = 1;
    MainService.sNativeTidOfReceiver = Process.myTid();
    for (;;)
    {
      try
      {
        if (MainService.access$100(this.this$0)) {
          MainService.sRegulatorCallback.checkInRegulatorMsg();
        }
        Object localObject1 = MainService.access$000(this.this$0);
        Object localObject5 = null;
        localObject1 = ((MobileQQ)localObject1).waitAppRuntime(null);
        if (localObject1 != null)
        {
          localObject4 = (VerifyCodeManager)((AppRuntime)localObject1).getManager(6);
          localObject1 = (VerifyDevLockManager)((AppRuntime)localObject1).getManager(7);
          MsfMessagePair localMsfMessagePair = this.this$0.msfSub.getServiceRespMsg();
          Object localObject3 = localObject5;
          if (localMsfMessagePair != null) {
            if (localMsfMessagePair.toServiceMsg == null)
            {
              localObject1 = localMsfMessagePair.fromServiceMsg;
              localObject3 = localObject1;
              if (localObject1 != null)
              {
                if ((((FromServiceMsg)localObject1).getServiceCmd() != null) && (((FromServiceMsg)localObject1).getServiceCmd().equals("SharpSvr.s2c"))) {
                  MqqConnRateReport.getInstance().doReport(MqqConnRateReport.EventType.eVideoMSFReceiverProcess, ((FromServiceMsg)localObject1).getWupBuffer(), 0);
                }
                localObject3 = localObject1;
                if (!MainService.access$200(this.this$0).handlePushMsg((FromServiceMsg)localObject1))
                {
                  localObject3 = localObject1;
                  if (QLog.isColorLevel())
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("[MSF Receive] No handler for ");
                    ((StringBuilder)localObject3).append(((FromServiceMsg)localObject1).getServiceCmd());
                    QLog.w("mqq", 2, ((StringBuilder)localObject3).toString());
                    localObject3 = localObject1;
                  }
                }
              }
            }
            else if ((localObject4 != null) && (localObject1 != null))
            {
              localObject3 = localObject5;
              if (((VerifyCodeManager)localObject4).checkVerifyCodeResp(localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg))
              {
                localObject3 = localObject5;
                if (((VerifyDevLockManager)localObject1).checkVerifyDevLockSmsResp(localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg))
                {
                  handleResp(localMsfMessagePair);
                  localObject3 = localObject5;
                }
              }
            }
            else
            {
              handleResp(localMsfMessagePair);
              localObject3 = localObject5;
            }
          }
          if ((localObject3 == null) && (localMsfMessagePair == null))
          {
            this.this$0.msfSub.queueWait();
            continue;
          }
          if (MainService.sPwdPacketTime == 0L) {
            continue;
          }
          long l = System.currentTimeMillis() - MainService.sPwdPacketTime;
          if ((l >= 40000L) || (l <= 0L) || (this.this$0.msfSub.getQueueSize() <= 0)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "[MSF Receive] UI_BUSY");
          }
          Thread.sleep(120L);
          continue;
          continue;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[MSF Receive]");
          ((StringBuilder)localObject3).append(localException.toString());
          QLog.e("mqq", 2, ((StringBuilder)localObject3).toString());
        }
        localException.printStackTrace();
      }
      Object localObject2 = null;
      Object localObject4 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.MainService.2
 * JD-Core Version:    0.7.0.1
 */