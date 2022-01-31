import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class ajcg
  extends BroadcastReceiver
{
  ajcg(ajcf paramajcf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (ajcf.a(this.a) == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
        {
          if (ajcf.a(this.a))
          {
            ajcf.a(this.a).runRenderTask(ajcf.a(this.a));
            return;
          }
          ajcf.a(this.a);
          return;
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (!ajcf.a(this.a)) {
        break;
      }
    } while (ajcf.a(this.a) == null);
    ajcf.a(this.a).runRenderTask(ajcf.b(this.a));
    return;
    ajcf.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajcg
 * JD-Core Version:    0.7.0.1
 */