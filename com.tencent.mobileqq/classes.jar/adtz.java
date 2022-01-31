import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;

public class adtz
  implements View.OnClickListener
{
  public adtz(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    SoundAndVibrateActivity.a(this.a, "CHANNEL_ID_SHOW_BADGE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtz
 * JD-Core Version:    0.7.0.1
 */