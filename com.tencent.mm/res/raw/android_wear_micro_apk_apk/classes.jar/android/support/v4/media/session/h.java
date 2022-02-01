package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder.DeathRecipient;
import android.os.Message;

public abstract class h
  implements IBinder.DeathRecipient
{
  private final Object jU;
  i jV;
  boolean jW;
  
  public h()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jU = new t(new j(this));
      return;
    }
    this.jU = new k(this);
  }
  
  final void a(int paramInt, Object paramObject, Bundle paramBundle)
  {
    if (this.jV != null)
    {
      paramObject = this.jV.obtainMessage(paramInt, paramObject);
      paramObject.setData(paramBundle);
      paramObject.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.h
 * JD-Core Version:    0.7.0.1
 */