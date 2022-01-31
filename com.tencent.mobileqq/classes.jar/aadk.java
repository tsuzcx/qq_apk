import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class aadk
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = aadj.a().iterator();
    while (localIterator.hasNext())
    {
      aadj localaadj = (aadj)((WeakReference)localIterator.next()).get();
      if (localaadj != null) {
        localaadj.a(paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadk
 * JD-Core Version:    0.7.0.1
 */