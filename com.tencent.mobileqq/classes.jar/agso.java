import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class agso
  implements DialogInterface.OnClickListener
{
  agso(agsl paramagsl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListActivity", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
    if (((NewPhotoListActivity)this.a.a.get()).c != null) {
      ((NewPhotoListActivity)this.a.a.get()).c.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agso
 * JD-Core Version:    0.7.0.1
 */