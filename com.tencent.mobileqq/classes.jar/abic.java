import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.armap.ARMapActivity;

public class abic
  implements DialogInterface.OnDismissListener
{
  public abic(ARMapActivity paramARMapActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ARMapActivity.i(this.a)) {
      this.a.finish();
    }
    ARMapActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abic
 * JD-Core Version:    0.7.0.1
 */