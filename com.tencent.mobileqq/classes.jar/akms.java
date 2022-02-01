import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;

public class akms
  implements DialogInterface.OnClickListener
{
  public akms(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(this.a.app, "CliOper", "", "", "0X8005FDA", "0X8005FDA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akms
 * JD-Core Version:    0.7.0.1
 */