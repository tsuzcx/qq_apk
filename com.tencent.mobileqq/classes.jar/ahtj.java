import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ahtj
  extends BroadcastReceiver
{
  ahtj(ahti paramahti) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("recording_time_out", false))
    {
      QQToast.a(this.a.mRuntime.a(), 2131699370, 0).a();
      QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock record timeout!");
      return;
    }
    paramContext = paramIntent.getStringExtra("target_media_url");
    ahti.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtj
 * JD-Core Version:    0.7.0.1
 */