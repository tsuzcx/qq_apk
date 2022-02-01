import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class actl
  extends BroadcastReceiver
{
  private actl(actj paramactj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
    if (i == 3) {}
    for (boolean bool = true;; bool = false)
    {
      acvc.a("VolumeBroadcastReceiver", "VolumeBroadcastReceiver action type = " + paramIntent.getAction() + ", isStreamMusic = " + bool + ", streamType = " + i);
      if (("android.media.VOLUME_CHANGED_ACTION".equals(paramIntent.getAction())) && (bool) && (actj.a(this.a) != null)) {
        actj.a(this.a).a(new Object[0]);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actl
 * JD-Core Version:    0.7.0.1
 */