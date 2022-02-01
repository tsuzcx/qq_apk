import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class aclp
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = aclo.a().iterator();
    while (localIterator.hasNext())
    {
      aclo localaclo = (aclo)((WeakReference)localIterator.next()).get();
      if (localaclo != null) {
        localaclo.a(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclp
 * JD-Core Version:    0.7.0.1
 */