import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;

public class acoh
  implements View.OnLayoutChangeListener
{
  public acoh(Conversation paramConversation) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    Conversation.a(this.a).removeOnLayoutChangeListener(this);
    Conversation.g(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acoh
 * JD-Core Version:    0.7.0.1
 */