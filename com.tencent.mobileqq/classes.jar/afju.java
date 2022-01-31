import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class afju
  extends BroadcastReceiver
{
  afju(afjt paramafjt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("recording_time_out", false))
    {
      bbmy.a(this.a.mRuntime.a(), 2131633268, 0).a();
      QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock record timeout!");
      return;
    }
    paramContext = paramIntent.getStringExtra("target_media_url");
    afjt.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afju
 * JD-Core Version:    0.7.0.1
 */