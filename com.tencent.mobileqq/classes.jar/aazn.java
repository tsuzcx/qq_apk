import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.armap.ARMapActivity;

public class aazn
  implements DialogInterface.OnDismissListener
{
  public aazn(ARMapActivity paramARMapActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ARMapActivity.f(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazn
 * JD-Core Version:    0.7.0.1
 */