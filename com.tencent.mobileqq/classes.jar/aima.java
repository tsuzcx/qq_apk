import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;

public class aima
  implements DialogInterface.OnClickListener
{
  public aima(VideoStatusTipsBar paramVideoStatusTipsBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    msa.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aima
 * JD-Core Version:    0.7.0.1
 */