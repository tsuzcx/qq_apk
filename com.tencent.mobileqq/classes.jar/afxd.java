import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class afxd
  extends apwz
{
  public afxd(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment) {}
  
  public void a(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {
      return;
    }
    paramView = (FileManagerEntity)((aimb)paramView.getTag()).a;
    this.a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afxd
 * JD-Core Version:    0.7.0.1
 */