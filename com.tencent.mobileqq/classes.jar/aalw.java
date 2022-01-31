import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aalw
  extends BroadcastReceiver
{
  private aalw(aalu paramaalu) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
    if (i == 3) {}
    for (boolean bool = true;; bool = false)
    {
      aanp.a("VolumeBroadcastReceiver", "VolumeBroadcastReceiver action type = " + paramIntent.getAction() + ", isStreamMusic = " + bool + ", streamType = " + i);
      if (("android.media.VOLUME_CHANGED_ACTION".equals(paramIntent.getAction())) && (bool) && (aalu.a(this.a) != null)) {
        aalu.a(this.a).a(new Object[0]);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalw
 * JD-Core Version:    0.7.0.1
 */