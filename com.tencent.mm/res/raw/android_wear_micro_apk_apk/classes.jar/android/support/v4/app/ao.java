package android.support.v4.app;

import android.arch.lifecycle.q;
import android.support.v4.content.d;
import android.util.Log;
import java.io.PrintWriter;

final class ao<D>
  implements q<D>
{
  private final d<D> ge;
  private final am<D> gh;
  private boolean gi;
  
  public final void d(D paramD)
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  onLoadFinished in " + this.ge + ": " + d.dataToString(paramD));
    }
    this.gi = true;
  }
  
  public final void dump(String paramString, PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mDeliveredData=");
    paramPrintWriter.println(this.gi);
  }
  
  final void reset()
  {
    if ((this.gi) && (LoaderManagerImpl.DEBUG)) {
      Log.v("LoaderManager", "  Resetting: " + this.ge);
    }
  }
  
  public final String toString()
  {
    return this.gh.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ao
 * JD-Core Version:    0.7.0.1
 */