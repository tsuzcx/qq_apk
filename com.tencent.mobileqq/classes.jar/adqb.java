import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.ChatHistoryImageView.DownloadAndSaveTask;
import com.tencent.mobileqq.app.ThreadManager;

public class adqb
  implements DialogInterface.OnClickListener
{
  public adqb(ChatHistoryImageView paramChatHistoryImageView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    ChatHistoryImageView.DownloadAndSaveTask localDownloadAndSaveTask = new ChatHistoryImageView.DownloadAndSaveTask(this.a, this.a.jdField_a_of_type_JavaUtilArrayList, true, false);
    paramDialogInterface.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask = localDownloadAndSaveTask;
    ThreadManager.post(localDownloadAndSaveTask, 5, null, true);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqb
 * JD-Core Version:    0.7.0.1
 */