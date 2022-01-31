import android.os.Bundle;
import com.tencent.mobileqq.statistics.battery.BatteryIPCModule;
import com.tencent.mobileqq.statistics.battery.BatteryStatsImpl;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class ahsj
  implements EIPCResultCallback
{
  public ahsj(BatteryIPCModule paramBatteryIPCModule) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult.isSuccess()) && (paramEIPCResult.data.getBoolean("key_monitor"))) {
      BatteryStatsImpl.a().e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahsj
 * JD-Core Version:    0.7.0.1
 */