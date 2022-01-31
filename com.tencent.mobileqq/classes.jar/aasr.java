import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.ChatHistoryImageView.DownloadAndSaveTask;

public class aasr
  implements DialogInterface.OnClickListener
{
  public aasr(ChatHistoryImageView paramChatHistoryImageView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.cancel();
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aasr
 * JD-Core Version:    0.7.0.1
 */