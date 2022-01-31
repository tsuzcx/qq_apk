import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;

public class aeze
  implements DialogInterface.OnClickListener
{
  public aeze(VideoStatusTipsBar paramVideoStatusTipsBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mqw.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeze
 * JD-Core Version:    0.7.0.1
 */