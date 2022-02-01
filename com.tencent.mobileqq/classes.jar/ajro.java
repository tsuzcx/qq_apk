import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

class ajro
  implements DialogInterface.OnClickListener
{
  ajro(ajrg paramajrg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoPreviewActivity", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
    if (((NewPhotoPreviewActivity)this.a.mActivity).sendBtn != null) {
      ((NewPhotoPreviewActivity)this.a.mActivity).sendBtn.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajro
 * JD-Core Version:    0.7.0.1
 */