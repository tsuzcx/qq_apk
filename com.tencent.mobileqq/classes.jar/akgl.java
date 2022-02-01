import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class akgl
{
  public static Rect a(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    return localRect;
  }
  
  public static View a(ChatMessage paramChatMessage, ChatXListView paramChatXListView)
  {
    int i = ((aezn)((bjqx)paramChatXListView.getAdapter()).getWrappedAdapter()).a(paramChatMessage) + paramChatXListView.getHeaderViewsCount();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i);
    }
    if (i < 0) {
      return null;
    }
    return paramChatXListView.getChildAt(i - paramChatXListView.getFirstVisiblePosition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgl
 * JD-Core Version:    0.7.0.1
 */