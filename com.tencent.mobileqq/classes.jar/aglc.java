import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aglc
  implements View.OnClickListener
{
  aglc(aglb paramaglb) {}
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = this.a.a(paramView);
    this.a.a.b(localChatMessage);
    this.a.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglc
 * JD-Core Version:    0.7.0.1
 */