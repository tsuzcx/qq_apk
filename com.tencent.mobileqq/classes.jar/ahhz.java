import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmedia.capture.fragment.CameraCaptureFragment;
import com.tencent.qphone.base.util.QLog;

public class ahhz
  extends BroadcastReceiver
{
  public ahhz(CameraCaptureFragment paramCameraCaptureFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.getActivity();
    if ((paramContext == null) || (paramContext.isFinishing()) || (CameraCaptureFragment.a(this.a))) {}
    while (!"tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureFragment", 2, "receive ACTION_START_VIDEO_CHAT.");
    }
    CameraCaptureFragment.a(this.a, true);
    paramContext.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahhz
 * JD-Core Version:    0.7.0.1
 */