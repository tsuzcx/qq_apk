import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qphone.base.util.QLog;

public class agkz
  implements DialogInterface.OnClickListener
{
  public agkz(PhotoListPanel paramPhotoListPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListPanel", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkz
 * JD-Core Version:    0.7.0.1
 */