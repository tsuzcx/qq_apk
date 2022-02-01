package android.support.v4.media;

import android.os.Build.VERSION;

public class b
{
  final Object in;
  c io;
  
  public b()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.in = new t(new d(this));
      return;
    }
    this.in = null;
  }
  
  public void onConnected() {}
  
  public void onConnectionFailed() {}
  
  public void onConnectionSuspended() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.b
 * JD-Core Version:    0.7.0.1
 */