import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;

class abpr
  extends BroadcastReceiver
{
  private abpr(abpi paramabpi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (abpi.a(this.a))
    {
      abpi.b(this.a, false);
      QLog.i("GdtMvViewController", 1, "SilentModeReceiver first auto called! so skip!");
    }
    while ((abpi.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = abpi.a(this.a).getRingerMode();
    int j = abpi.a(this.a).getStreamVolume(3);
    QLog.i("GdtMvViewController", 1, "system context mode: " + i + ", streamVolume = " + j);
    switch (i)
    {
    default: 
      abpi.c(this.a, true);
      this.a.a = true;
      abpi.a(this.a).a(true);
    }
    for (;;)
    {
      abpi.a(this.a, j, abpi.b(this.a), false);
      return;
      abpi.c(this.a, false);
      if (j > 0) {
        this.a.a = false;
      }
      abpi.a(this.a).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpr
 * JD-Core Version:    0.7.0.1
 */