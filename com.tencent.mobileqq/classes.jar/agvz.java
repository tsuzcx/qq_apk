import VACDReport.ReportRsp;
import android.os.Bundle;
import mqq.observer.BusinessObserver;

class agvz
  implements BusinessObserver
{
  agvz(agvx paramagvx) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBundle.containsKey("rsp")) {}
    for (paramBundle = ((ReportRsp)paramBundle.getSerializable("rsp")).headers;; paramBundle = null)
    {
      agvx.a(this.a, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agvz
 * JD-Core Version:    0.7.0.1
 */