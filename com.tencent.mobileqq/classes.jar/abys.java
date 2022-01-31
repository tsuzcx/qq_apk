import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class abys
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = abyr.a().iterator();
    while (localIterator.hasNext())
    {
      abyr localabyr = (abyr)((WeakReference)localIterator.next()).get();
      if (localabyr != null) {
        localabyr.a(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abys
 * JD-Core Version:    0.7.0.1
 */