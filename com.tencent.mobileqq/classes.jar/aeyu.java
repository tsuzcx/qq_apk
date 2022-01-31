import android.os.Handler;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel.9.1;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel.9.2;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class aeyu
  implements INetInfoHandler
{
  public aeyu(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "onNetMobile2None isSttNetFinish=" + VoiceTextEditPanel.a(this.a).get());
    }
    VoiceTextEditPanel.a(this.a).post(new VoiceTextEditPanel.9.1(this));
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "onNetWifi2None isSttNetFinish=" + VoiceTextEditPanel.a(this.a).get());
    }
    VoiceTextEditPanel.a(this.a).post(new VoiceTextEditPanel.9.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyu
 * JD-Core Version:    0.7.0.1
 */