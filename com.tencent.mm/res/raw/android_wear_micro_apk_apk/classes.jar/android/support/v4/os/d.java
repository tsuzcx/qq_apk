package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;

final class d
  extends b
{
  d(ResultReceiver paramResultReceiver) {}
  
  public final void send(int paramInt, Bundle paramBundle)
  {
    if (this.kK.dG != null)
    {
      this.kK.dG.post(new e(this.kK, paramInt, paramBundle));
      return;
    }
    this.kK.onReceiveResult(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.os.d
 * JD-Core Version:    0.7.0.1
 */