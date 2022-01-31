import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.armap.ARMapActivity;

public class aasm
  implements DialogInterface.OnDismissListener
{
  public aasm(ARMapActivity paramARMapActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ARMapActivity.f(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aasm
 * JD-Core Version:    0.7.0.1
 */