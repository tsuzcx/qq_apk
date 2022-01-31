import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class aadg
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = aadf.a().iterator();
    while (localIterator.hasNext())
    {
      aadf localaadf = (aadf)((WeakReference)localIterator.next()).get();
      if (localaadf != null) {
        localaadf.a(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadg
 * JD-Core Version:    0.7.0.1
 */