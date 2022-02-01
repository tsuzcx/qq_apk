import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;

public class aiwq
  implements DialogInterface.OnClickListener
{
  public aiwq(VideoStatusTipsBar paramVideoStatusTipsBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mru.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwq
 * JD-Core Version:    0.7.0.1
 */