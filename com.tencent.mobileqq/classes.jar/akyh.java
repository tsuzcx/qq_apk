import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class akyh
  extends BroadcastReceiver
{
  akyh(akyg paramakyg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (akyg.a(this.a) == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
        {
          if (akyg.a(this.a))
          {
            akyg.a(this.a).runRenderTask(akyg.a(this.a));
            return;
          }
          akyg.a(this.a);
          return;
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (!akyg.a(this.a)) {
        break;
      }
    } while (akyg.a(this.a) == null);
    akyg.a(this.a).runRenderTask(akyg.b(this.a));
    return;
    akyg.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyh
 * JD-Core Version:    0.7.0.1
 */