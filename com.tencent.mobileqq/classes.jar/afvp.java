import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class afvp
  extends BroadcastReceiver
{
  afvp(afvo paramafvo) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("recording_time_out", false))
    {
      bcql.a(this.a.mRuntime.a(), 2131699027, 0).a();
      QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock record timeout!");
      return;
    }
    paramContext = paramIntent.getStringExtra("target_media_url");
    afvo.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvp
 * JD-Core Version:    0.7.0.1
 */