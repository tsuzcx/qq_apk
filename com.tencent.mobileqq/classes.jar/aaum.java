import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.armap.ARMapActivity;

public class aaum
  implements DialogInterface.OnClickListener
{
  public aaum(ARMapActivity paramARMapActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaum
 * JD-Core Version:    0.7.0.1
 */