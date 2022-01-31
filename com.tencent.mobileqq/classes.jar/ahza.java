import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;

public class ahza
  implements View.OnClickListener
{
  public ahza(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.d)
    {
      if (bhtb.e()) {
        this.a.startActivity(new Intent("android.settings.SETTINGS"));
      }
    }
    else {
      return;
    }
    this.a.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahza
 * JD-Core Version:    0.7.0.1
 */