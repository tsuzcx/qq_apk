import VACDReport.ReportRsp;
import android.os.Bundle;
import mqq.observer.BusinessObserver;

class ahim
  implements BusinessObserver
{
  ahim(ahik paramahik) {}
  
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
      ahik.a(this.a, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahim
 * JD-Core Version:    0.7.0.1
 */