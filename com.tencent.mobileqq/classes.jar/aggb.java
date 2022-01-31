import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class aggb
  implements DialogInterface.OnClickListener
{
  public aggb(NewPhotoPreviewActivity paramNewPhotoPreviewActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoPreviewActivity", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
    if (this.a.b != null) {
      this.a.b.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggb
 * JD-Core Version:    0.7.0.1
 */