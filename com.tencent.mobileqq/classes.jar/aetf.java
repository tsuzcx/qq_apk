import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;

public class aetf
  implements DialogInterface.OnDismissListener
{
  public aetf(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    GroupManagerActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetf
 * JD-Core Version:    0.7.0.1
 */