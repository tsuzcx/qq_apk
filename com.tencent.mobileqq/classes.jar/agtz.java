import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import mqq.util.WeakReference;

class agtz
  implements DialogInterface.OnClickListener
{
  agtz(agtw paramagtw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (((NewPhotoListActivity)this.a.a.get()).c != null) {
      ((NewPhotoListActivity)this.a.a.get()).c.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtz
 * JD-Core Version:    0.7.0.1
 */