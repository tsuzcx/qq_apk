import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class adow
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = adov.a().iterator();
    while (localIterator.hasNext())
    {
      adov localadov = (adov)((WeakReference)localIterator.next()).get();
      if (localadov != null) {
        localadov.a(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adow
 * JD-Core Version:    0.7.0.1
 */