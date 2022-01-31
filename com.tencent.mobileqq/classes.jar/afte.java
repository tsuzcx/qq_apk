import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class afte
  implements DialogInterface.OnClickListener
{
  public afte(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afte
 * JD-Core Version:    0.7.0.1
 */