import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import com.tencent.mobileqq.campuscircle.CampusCirclePublishActivity;

public class abwq
  implements DialogInterface.OnClickListener
{
  public abwq(CampusCirclePublishActivity paramCampusCirclePublishActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    Message.obtain(this.a.a, 8, 0, 0, null).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwq
 * JD-Core Version:    0.7.0.1
 */