import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.3.1;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class ajxd
  implements INetInfoHandler
{
  ajxd(ajxc paramajxc) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    long l = Thread.currentThread().getId();
    if (ajxc.a(this.a) == l) {
      ajxc.a(this.a);
    }
    while (ajxc.a(this.a) == null) {
      return;
    }
    ajxc.a(this.a).post(new LbsFilterStatusManager.3.1(this));
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxd
 * JD-Core Version:    0.7.0.1
 */