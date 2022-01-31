import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class akts
  extends BroadcastReceiver
{
  akts(aktr paramaktr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (aktr.a(this.a) == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
        {
          if (aktr.a(this.a))
          {
            aktr.a(this.a).runRenderTask(aktr.a(this.a));
            return;
          }
          aktr.a(this.a);
          return;
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (!aktr.a(this.a)) {
        break;
      }
    } while (aktr.a(this.a) == null);
    aktr.a(this.a).runRenderTask(aktr.b(this.a));
    return;
    aktr.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akts
 * JD-Core Version:    0.7.0.1
 */