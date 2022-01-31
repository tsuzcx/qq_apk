import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem;

public class ajku
  extends BroadcastReceiver
{
  public ajku(AudioItem paramAudioItem) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action".equals(paramContext)) {
      this.a.b(AudioItem.a(this.a));
    }
    while (!"com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video".equals(paramContext)) {
      return;
    }
    this.a.b(AudioItem.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajku
 * JD-Core Version:    0.7.0.1
 */