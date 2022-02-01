import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahxo
  implements View.OnClickListener
{
  ahxo(ahxm paramahxm) {}
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = agej.a(paramView);
    ahxm.a(this.a, localChatMessage, 5);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxo
 * JD-Core Version:    0.7.0.1
 */