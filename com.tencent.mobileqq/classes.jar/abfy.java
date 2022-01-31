import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.qphone.base.util.QLog;

class abfy
  implements DialogInterface.OnDismissListener
{
  abfy(abfw paramabfw) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ARMapActivity.a(this.a.a, null);
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "onGetLBSPoiList clicked");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfy
 * JD-Core Version:    0.7.0.1
 */