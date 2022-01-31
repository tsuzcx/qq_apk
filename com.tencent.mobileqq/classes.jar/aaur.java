import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.armap.ARMapActivity;

public class aaur
  implements DialogInterface.OnClickListener
{
  public aaur(ARMapActivity paramARMapActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaur
 * JD-Core Version:    0.7.0.1
 */