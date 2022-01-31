import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateProviderView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public final class ahmr
  extends BroadcastReceiver
{
  private ahmr(PtvTemplateProviderView paramPtvTemplateProviderView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("action_brocassreceiver_for_ptv".equals(paramIntent.getAction()))
    {
      CapturePtvTemplateManager.a().b(false);
      PtvTemplateProviderView.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateProviderView", 2, "PtvTemplateProviderView PtvBroadcastReceiver size=" + this.a.a.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmr
 * JD-Core Version:    0.7.0.1
 */