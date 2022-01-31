import VACDReport.ReportRsp;
import android.os.Bundle;
import mqq.observer.BusinessObserver;

class ajek
  implements BusinessObserver
{
  ajek(ajei paramajei) {}
  
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
      ajei.a(this.a, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajek
 * JD-Core Version:    0.7.0.1
 */