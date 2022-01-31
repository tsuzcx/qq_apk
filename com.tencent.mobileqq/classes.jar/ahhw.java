import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ahhw
  extends BroadcastReceiver
{
  private ahhw(ahhs paramahhs) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("open_video_callback".equals(paramIntent.getAction())) {}
    try
    {
      int i = paramIntent.getIntExtra("retcode", 4);
      paramContext = paramIntent.getStringExtra("retmsg");
      int j = paramIntent.getIntExtra("isDownloaded", -1);
      long l1 = paramIntent.getLongExtra("played_time", 0L);
      long l2 = paramIntent.getLongExtra("total_time", 0L);
      paramIntent = new JSONObject();
      paramIntent.put("retcode", i);
      paramIntent.put("retmsg", paramContext);
      paramIntent.put("played_time", l1);
      paramIntent.put("total_time", l2);
      if (j != -1) {
        paramIntent.put("is_downloaded", j);
      }
      ahhs.a(this.a, "openVideoPlayer", paramIntent.toString());
      return;
    }
    catch (JSONException paramContext)
    {
      QLog.e("springHb_SpringFestivalRedpacketJsPlugin", 1, paramContext, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhw
 * JD-Core Version:    0.7.0.1
 */