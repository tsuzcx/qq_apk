import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.FrameHelperActivity;
import java.util.List;
import mqq.os.MqqHandler;

public class aeak
  implements aled
{
  private final int jdField_a_of_type_Int = -2147483648;
  
  private aeak(Conversation paramConversation) {}
  
  public void a(int paramInt, List<RecentBaseData> paramList) {}
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramDragFrameLayout.a() == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b.sendEmptyMessage(10);
      FrameHelperActivity.c(true);
      return;
    }
    FrameHelperActivity.c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeak
 * JD-Core Version:    0.7.0.1
 */