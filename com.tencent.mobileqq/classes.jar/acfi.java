import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;

class acfi
  extends BroadcastReceiver
{
  private acfi(acey paramacey) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (acey.a(this.a))
    {
      acey.b(this.a, false);
      QLog.i("GdtMvViewController", 1, "SilentModeReceiver first auto called! so skip!");
    }
    while ((acey.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = acey.a(this.a).getRingerMode();
    int j = acey.a(this.a).getStreamVolume(3);
    QLog.i("GdtMvViewController", 1, "system context mode: " + i + ", streamVolume = " + j);
    switch (i)
    {
    default: 
      acey.c(this.a, true);
      this.a.a = true;
      acey.a(this.a).a(true);
    }
    for (;;)
    {
      acey.a(this.a, j, acey.b(this.a), false);
      return;
      acey.c(this.a, false);
      if (j > 0) {
        this.a.a = false;
      }
      acey.a(this.a).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfi
 * JD-Core Version:    0.7.0.1
 */