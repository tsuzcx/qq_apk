package android.support.v4.os;

import android.os.Bundle;

final class e
  implements Runnable
{
  final int iN;
  final Bundle iO;
  
  e(ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    this.iN = paramInt;
    this.iO = paramBundle;
  }
  
  public final void run()
  {
    this.iM.onReceiveResult(this.iN, this.iO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.os.e
 * JD-Core Version:    0.7.0.1
 */