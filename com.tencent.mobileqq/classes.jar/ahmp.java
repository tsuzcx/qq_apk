import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmedia.capture.fragment.BlessEffectsCameraCaptureFragment;
import com.tencent.qphone.base.util.QLog;

public class ahmp
  extends BroadcastReceiver
{
  public ahmp(BlessEffectsCameraCaptureFragment paramBlessEffectsCameraCaptureFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.video.q2v.startUploadPTV".equals(paramIntent.getAction())) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOEffectsCameraCaptureFragment", 2, "receive ACTION_BLESS_UPLOAD_PTV.");
      }
    }
    switch (paramIntent.getIntExtra("broadcastType", 1))
    {
    default: 
    case 1: 
      do
      {
        return;
        paramContext = this.a.getActivity();
      } while ((paramContext == null) || (paramContext.isFinishing()));
      paramContext.finish();
      return;
    }
    BlessEffectsCameraCaptureFragment.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmp
 * JD-Core Version:    0.7.0.1
 */