import VACDReport.ReportRsp;
import android.os.Bundle;
import mqq.observer.BusinessObserver;

class alhu
  implements BusinessObserver
{
  alhu(alhs paramalhs) {}
  
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
      alhs.a(this.a, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhu
 * JD-Core Version:    0.7.0.1
 */