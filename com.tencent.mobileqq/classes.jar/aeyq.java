import com.tencent.mobileqq.nearby.now.protocol.CsTask.OnCsError;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.ReportCallback;
import com.tencent.qphone.base.util.QLog;

public final class aeyq
  implements CsTask.OnCsError
{
  public aeyq(NearbyMomentProtocol.ReportCallback paramReportCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    QLog.i("NearbyMomentProtocol", 1, "report ,0xada error errorCode= " + paramInt);
    if (this.a != null) {
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeyq
 * JD-Core Version:    0.7.0.1
 */