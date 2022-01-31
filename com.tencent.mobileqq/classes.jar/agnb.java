import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;

public class agnb
  implements DialogInterface.OnClickListener
{
  public agnb(PhotoListActivity paramPhotoListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.setResult(8001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnb
 * JD-Core Version:    0.7.0.1
 */