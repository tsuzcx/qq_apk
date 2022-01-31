import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;

public class agwj
  implements DialogInterface.OnClickListener
{
  public agwj(VideoStatusTipsBar paramVideoStatusTipsBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mtq.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwj
 * JD-Core Version:    0.7.0.1
 */