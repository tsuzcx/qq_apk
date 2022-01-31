import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;

public class aaje
  implements View.OnClickListener
{
  public aaje(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("start_from", 2);
    ColorNoteSettingFragment.a(paramView.getContext(), ColorNoteSettingFragment.class, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaje
 * JD-Core Version:    0.7.0.1
 */