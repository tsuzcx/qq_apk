import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class aipk
  extends BroadcastReceiver
{
  aipk(aipj paramaipj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (aipj.a(this.a) == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
        {
          if (aipj.a(this.a))
          {
            aipj.a(this.a).runRenderTask(aipj.a(this.a));
            return;
          }
          aipj.a(this.a);
          return;
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (!aipj.a(this.a)) {
        break;
      }
    } while (aipj.a(this.a) == null);
    aipj.a(this.a).runRenderTask(aipj.b(this.a));
    return;
    aipj.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aipk
 * JD-Core Version:    0.7.0.1
 */