import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahqn
  implements View.OnClickListener
{
  public ahqn(ScribbleItemBuilder paramScribbleItemBuilder) {}
  
  public void onClick(View paramView)
  {
    MessageRecord localMessageRecord = (MessageRecord)paramView.getTag();
    if (localMessageRecord != null) {
      ((FlashChatManager)this.a.a.getManager(217)).a(paramView.getContext(), localMessageRecord);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqn
 * JD-Core Version:    0.7.0.1
 */