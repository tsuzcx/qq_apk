import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aick
  implements View.OnClickListener
{
  public aick(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new ArrayList();
    Iterator localIterator = this.a.a.b.iterator();
    while (localIterator.hasNext()) {
      paramView.add(Long.valueOf(Long.parseLong((String)localIterator.next())));
    }
    ChatHistoryTroopMemberFragment.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aick
 * JD-Core Version:    0.7.0.1
 */