import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;

class acpe
  extends BroadcastReceiver
{
  private acpe(acow paramacow) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (acow.a(this.a))
    {
      acow.b(this.a, false);
      QLog.i("GdtMvViewController", 1, "SilentModeReceiver first auto called! so skip!");
    }
    while ((acow.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = acow.a(this.a).getRingerMode();
    int j = acow.a(this.a).getStreamVolume(3);
    QLog.i("GdtMvViewController", 1, "system context mode: " + i + ", streamVolume = " + j);
    switch (i)
    {
    default: 
      acow.c(this.a, true);
      this.a.a = true;
      acow.a(this.a).a(true);
    }
    for (;;)
    {
      acow.a(this.a, j, acow.b(this.a), false);
      return;
      acow.c(this.a, false);
      if (j > 0) {
        this.a.a = false;
      }
      acow.a(this.a).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpe
 * JD-Core Version:    0.7.0.1
 */