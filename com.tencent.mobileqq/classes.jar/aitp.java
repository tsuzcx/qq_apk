import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;

public class aitp
  extends BroadcastReceiver
{
  public aitp(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("key_photo_delete_action".equals(paramContext))
    {
      int i = paramIntent.getIntExtra("key_photo_delete_position", -1);
      this.a.a(i, 9);
    }
    do
    {
      return;
      if ("key_audio_delete_action".equals(paramContext))
      {
        this.a.a(0);
        this.a.a = null;
        TroopBarUtils.a(this.a.p, this.a.q, "del_record", this.a.r, this.a.c, "", "");
        return;
      }
    } while (!"key_audio_play_action".equals(paramContext));
    TroopBarUtils.a(this.a.p, this.a.q, "preview_record", this.a.r, this.a.c, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitp
 * JD-Core Version:    0.7.0.1
 */