import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class adfy
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = adfx.a().iterator();
    while (localIterator.hasNext())
    {
      adfx localadfx = (adfx)((WeakReference)localIterator.next()).get();
      if (localadfx != null) {
        localadfx.a(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfy
 * JD-Core Version:    0.7.0.1
 */