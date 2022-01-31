import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class aisi
  implements DialogInterface.OnClickListener
{
  aisi(aisf paramaisf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (((NewPhotoListActivity)this.a.mActivity).sendBtn != null) {
      ((NewPhotoListActivity)this.a.mActivity).sendBtn.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisi
 * JD-Core Version:    0.7.0.1
 */