import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;

public class aaxi
  implements View.OnLayoutChangeListener
{
  public aaxi(Conversation paramConversation) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    Conversation.a(this.a).removeOnLayoutChangeListener(this);
    Conversation.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaxi
 * JD-Core Version:    0.7.0.1
 */