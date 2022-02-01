import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class adby
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = adbx.a().iterator();
    while (localIterator.hasNext())
    {
      adbx localadbx = (adbx)((WeakReference)localIterator.next()).get();
      if (localadbx != null) {
        localadbx.a(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adby
 * JD-Core Version:    0.7.0.1
 */