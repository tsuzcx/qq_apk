import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.ChatHistoryImageView.DownloadAndSaveTask;

public class acjq
  implements DialogInterface.OnClickListener
{
  public acjq(ChatHistoryImageView paramChatHistoryImageView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a != null)
    {
      this.a.a.b = false;
      this.a.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjq
 * JD-Core Version:    0.7.0.1
 */