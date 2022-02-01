import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.3.1;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class ambl
  implements INetInfoHandler
{
  ambl(ambk paramambk) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    long l = Thread.currentThread().getId();
    if (ambk.a(this.a) == l) {
      ambk.a(this.a);
    }
    while (ambk.a(this.a) == null) {
      return;
    }
    ambk.a(this.a).post(new LbsFilterStatusManager.3.1(this));
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambl
 * JD-Core Version:    0.7.0.1
 */