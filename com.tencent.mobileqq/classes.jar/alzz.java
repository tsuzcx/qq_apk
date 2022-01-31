import android.os.Bundle;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import cooperation.qqindividuality.ipc.IndividualityRemoteCommandHandler;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy;

public class alzz
  extends UniPayHandler.UniPayUpdateListener
{
  public alzz(IndividualityRemoteCommandHandler paramIndividualityRemoteCommandHandler) {}
  
  public void a()
  {
    QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 2, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzz
 * JD-Core Version:    0.7.0.1
 */