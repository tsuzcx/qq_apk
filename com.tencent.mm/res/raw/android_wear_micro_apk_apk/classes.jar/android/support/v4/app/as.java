package android.support.v4.app;

import android.app.Notification.BigTextStyle;
import android.os.Build.VERSION;

public final class as
  extends av
{
  private CharSequence gp;
  
  public final as a(CharSequence paramCharSequence)
  {
    this.gp = at.e(paramCharSequence);
    return this;
  }
  
  public final void a(ap paramap)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramap = new Notification.BigTextStyle(paramap.aJ()).setBigContentTitle(this.hd).bigText(this.gp);
      if (this.hf) {
        paramap.setSummaryText(this.he);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.as
 * JD-Core Version:    0.7.0.1
 */