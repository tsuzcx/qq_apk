import android.os.Handler;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController.1.1;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController.1.2;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class ahsb
  implements INetInfoHandler
{
  ahsb(ahsa paramahsa) {}
  
  public void onNetMobile2None()
  {
    ahsa.a(this.a).post(new VoiceTextSttProcessController.1.1(this));
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    ahsa.a(this.a).post(new VoiceTextSttProcessController.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsb
 * JD-Core Version:    0.7.0.1
 */