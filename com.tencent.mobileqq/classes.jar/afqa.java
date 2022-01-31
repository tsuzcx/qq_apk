import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.CsTask.Callback;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.ReportCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_report.ReportRsp;
import com.tencent.qphone.base.util.QLog;

public final class afqa
  implements CsTask.Callback
{
  public afqa(NearbyMomentProtocol.ReportCallback paramReportCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool = true;
    paramBundle = new ilive_report.ReportRsp();
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (paramBundle.ret_code.has())
        {
          paramInt = paramBundle.ret_code.get();
          if (paramInt == 0)
          {
            if (this.a != null) {
              this.a.a(bool);
            }
            return;
          }
          QLog.i("NearbyMomentProtocol", 1, "report, retCode=" + paramBundle.ret_code.get() + ",errMsg=" + paramBundle.err_msg.get());
          bool = false;
          continue;
        }
        QLog.i("NearbyMomentProtocol", 1, "report, has no retCode , errMsg=" + paramBundle.err_msg.get());
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.i("NearbyMomentProtocol", 1, "report, e=" + paramArrayOfByte.toString());
        continue;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afqa
 * JD-Core Version:    0.7.0.1
 */