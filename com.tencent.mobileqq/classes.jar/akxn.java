import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.ar.view.ARScanEntryView;

public class akxn
  implements DialogInterface.OnClickListener
{
  public akxn(ARScanEntryView paramARScanEntryView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Activity localActivity = (Activity)this.a.a;
    Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan");
    localActivity.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akxn
 * JD-Core Version:    0.7.0.1
 */