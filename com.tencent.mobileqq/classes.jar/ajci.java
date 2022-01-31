import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class ajci
  extends BroadcastReceiver
{
  ajci(ajch paramajch) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (ajch.a(this.a) == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
        {
          if (ajch.a(this.a))
          {
            ajch.a(this.a).runRenderTask(ajch.a(this.a));
            return;
          }
          ajch.a(this.a);
          return;
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (!ajch.a(this.a)) {
        break;
      }
    } while (ajch.a(this.a) == null);
    ajch.a(this.a).runRenderTask(ajch.b(this.a));
    return;
    ajch.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajci
 * JD-Core Version:    0.7.0.1
 */