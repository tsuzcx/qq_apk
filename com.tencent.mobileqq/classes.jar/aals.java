import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

class aals
  extends BroadcastReceiver
{
  private aals(aall paramaall) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (aall.a(this.a))
    {
      aall.b(this.a, false);
      aanp.a("GdtMvViewController", "SilentModeReceiver first auto called! so skip!");
    }
    while ((aall.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = aall.a(this.a).getRingerMode();
    int j = aall.a(this.a).getStreamVolume(3);
    aanp.a("GdtMvViewController", "system context mode: " + i + ", streamVolume = " + j);
    switch (i)
    {
    default: 
      aall.c(this.a, true);
      this.a.a = true;
      aall.a(this.a).a(true);
    }
    for (;;)
    {
      aall.a(this.a, j, aall.b(this.a), false);
      return;
      aall.c(this.a, false);
      if (j > 0) {
        this.a.a = false;
      }
      aall.a(this.a).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aals
 * JD-Core Version:    0.7.0.1
 */