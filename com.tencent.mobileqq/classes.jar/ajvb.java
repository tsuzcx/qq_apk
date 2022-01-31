import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;

public class ajvb
  implements DialogInterface.OnClickListener
{
  public ajvb(VideoBroadcastReceiver paramVideoBroadcastReceiver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajvb
 * JD-Core Version:    0.7.0.1
 */