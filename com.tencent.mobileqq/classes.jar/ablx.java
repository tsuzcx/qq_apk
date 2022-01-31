import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;

public class ablx
  implements Runnable
{
  public ablx(ChatXListView paramChatXListView, Context paramContext) {}
  
  public void run()
  {
    int i = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getHeight();
    if (i <= 0) {
      i = ChatXListView.a();
    }
    for (;;)
    {
      ChatXListView.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("ChatXListView", 2, "ChatXListView open_panel_threshold_value = " + ChatXListView.b());
      }
      return;
      i >>= 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ablx
 * JD-Core Version:    0.7.0.1
 */