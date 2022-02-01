import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;

public class aesw
  implements DialogInterface.OnDismissListener
{
  public aesw(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    GroupManagerActivity.b(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesw
 * JD-Core Version:    0.7.0.1
 */