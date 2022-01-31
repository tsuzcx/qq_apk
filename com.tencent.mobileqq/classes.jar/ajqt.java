import android.os.CountDownTimer;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

public class ajqt
  implements INetInfoHandler
{
  public ajqt(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onNetMobile2None()
  {
    this.a.b.cancel();
    this.a.b.start();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.a.b.cancel();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.a.b.cancel();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.a.b.cancel();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.a.b.cancel();
  }
  
  public void onNetWifi2None()
  {
    this.a.b.cancel();
    this.a.b.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqt
 * JD-Core Version:    0.7.0.1
 */