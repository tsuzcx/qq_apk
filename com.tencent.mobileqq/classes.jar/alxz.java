import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class alxz
  extends BroadcastReceiver
{
  alxz(alxy paramalxy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (alxy.a(this.a) == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
        {
          if (alxy.a(this.a))
          {
            alxy.a(this.a).runRenderTask(alxy.a(this.a));
            return;
          }
          alxy.a(this.a);
          return;
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (!alxy.a(this.a)) {
        break;
      }
    } while (alxy.a(this.a) == null);
    alxy.a(this.a).runRenderTask(alxy.b(this.a));
    return;
    alxy.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxz
 * JD-Core Version:    0.7.0.1
 */