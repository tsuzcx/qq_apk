package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;

final class d
  extends b
{
  d(ResultReceiver paramResultReceiver) {}
  
  public final void send(int paramInt, Bundle paramBundle)
  {
    if (this.iM.mHandler != null)
    {
      this.iM.mHandler.post(new e(this.iM, paramInt, paramBundle));
      return;
    }
    this.iM.onReceiveResult(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.os.d
 * JD-Core Version:    0.7.0.1
 */