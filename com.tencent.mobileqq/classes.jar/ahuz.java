import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class ahuz
  extends arqb
{
  public ahuz(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment) {}
  
  public void a(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {
      return;
    }
    paramView = (FileManagerEntity)((ahzc)paramView.getTag()).a;
    this.a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuz
 * JD-Core Version:    0.7.0.1
 */