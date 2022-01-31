import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.armap.ARMapActivity;

public class aaul
  implements DialogInterface.OnDismissListener
{
  public aaul(ARMapActivity paramARMapActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ARMapActivity.q(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaul
 * JD-Core Version:    0.7.0.1
 */