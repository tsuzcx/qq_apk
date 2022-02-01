import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;

public class afix
  implements DialogInterface.OnDismissListener
{
  public afix(QQTranslucentBrowserActivity paramQQTranslucentBrowserActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afix
 * JD-Core Version:    0.7.0.1
 */