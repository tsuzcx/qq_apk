import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class abud
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = abuc.a().iterator();
    while (localIterator.hasNext())
    {
      abuc localabuc = (abuc)((WeakReference)localIterator.next()).get();
      if (localabuc != null) {
        localabuc.a(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abud
 * JD-Core Version:    0.7.0.1
 */