package android.support.v4.os;

import android.os.Bundle;

final class e
  implements Runnable
{
  final int kL;
  final Bundle kM;
  
  e(ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    this.kL = paramInt;
    this.kM = paramBundle;
  }
  
  public final void run()
  {
    this.kK.onReceiveResult(this.kL, this.kM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.os.e
 * JD-Core Version:    0.7.0.1
 */