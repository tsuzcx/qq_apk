import VACDReport.ReportRsp;
import android.os.Bundle;
import mqq.observer.BusinessObserver;

class aizv
  implements BusinessObserver
{
  aizv(aizt paramaizt) {}
  
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
      aizt.a(this.a, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizv
 * JD-Core Version:    0.7.0.1
 */