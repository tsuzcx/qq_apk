import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

class aaqh
  extends BroadcastReceiver
{
  private aaqh(aaqa paramaaqa) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (aaqa.a(this.a))
    {
      aaqa.b(this.a, false);
      aase.a("GdtMvViewController", "SilentModeReceiver first auto called! so skip!");
    }
    while ((aaqa.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = aaqa.a(this.a).getRingerMode();
    int j = aaqa.a(this.a).getStreamVolume(3);
    aase.a("GdtMvViewController", "system context mode: " + i + ", streamVolume = " + j);
    switch (i)
    {
    default: 
      aaqa.c(this.a, true);
      this.a.a = true;
      aaqa.a(this.a).a(true);
    }
    for (;;)
    {
      aaqa.a(this.a, j, aaqa.b(this.a), false);
      return;
      aaqa.c(this.a, false);
      if (j > 0) {
        this.a.a = false;
      }
      aaqa.a(this.a).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqh
 * JD-Core Version:    0.7.0.1
 */