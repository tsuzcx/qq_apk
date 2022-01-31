import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class adwd
  extends BroadcastReceiver
{
  public adwd(EventApiPlugin paramEventApiPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((EventApiPlugin.a != null) && (EventApiPlugin.a.size() > 0))
    {
      Iterator localIterator = EventApiPlugin.a.iterator();
      while (localIterator.hasNext())
      {
        EventApiPlugin localEventApiPlugin = (EventApiPlugin)((WeakReference)localIterator.next()).get();
        if (localEventApiPlugin != null) {
          localEventApiPlugin.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwd
 * JD-Core Version:    0.7.0.1
 */