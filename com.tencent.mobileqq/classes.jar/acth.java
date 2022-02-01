import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;

class acth
  extends BroadcastReceiver
{
  private acth(acsz paramacsz) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (acsz.a(this.a))
    {
      acsz.b(this.a, false);
      QLog.i("GdtMvViewController", 1, "SilentModeReceiver first auto called! so skip!");
    }
    while ((acsz.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = acsz.a(this.a).getRingerMode();
    int j = acsz.a(this.a).getStreamVolume(3);
    QLog.i("GdtMvViewController", 1, "system context mode: " + i + ", streamVolume = " + j);
    switch (i)
    {
    default: 
      acsz.c(this.a, true);
      this.a.a = true;
      acsz.a(this.a).a(true);
    }
    for (;;)
    {
      acsz.a(this.a, j, acsz.b(this.a), false);
      return;
      acsz.c(this.a, false);
      if (j > 0) {
        this.a.a = false;
      }
      acsz.a(this.a).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acth
 * JD-Core Version:    0.7.0.1
 */