import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;

public class agbf
  implements DialogInterface.OnClickListener
{
  public agbf(PhotoListActivity paramPhotoListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.setResult(8001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agbf
 * JD-Core Version:    0.7.0.1
 */