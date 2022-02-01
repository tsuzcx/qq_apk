import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahna
  implements View.OnClickListener
{
  ahna(ahmy paramahmy) {}
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.getMessage(paramView);
    ahmy.a(this.a, localChatMessage, 5);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahna
 * JD-Core Version:    0.7.0.1
 */