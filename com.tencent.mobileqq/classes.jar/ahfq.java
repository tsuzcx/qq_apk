import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahfq
  implements View.OnClickListener
{
  public ahfq(ScribbleItemBuilder paramScribbleItemBuilder) {}
  
  public void onClick(View paramView)
  {
    MessageRecord localMessageRecord = (MessageRecord)paramView.getTag();
    if (localMessageRecord != null) {
      ((FlashChatManager)this.a.a.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(paramView.getContext(), localMessageRecord);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfq
 * JD-Core Version:    0.7.0.1
 */