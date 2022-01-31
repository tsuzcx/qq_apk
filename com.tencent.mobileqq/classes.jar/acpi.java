import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;

public class acpi
  implements DialogInterface.OnClickListener
{
  public acpi(DevlockPhoneStatus paramDevlockPhoneStatus) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acpi
 * JD-Core Version:    0.7.0.1
 */