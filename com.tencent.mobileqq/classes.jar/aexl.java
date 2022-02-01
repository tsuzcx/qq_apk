import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;

public class aexl
  implements DialogInterface.OnClickListener
{
  public aexl(ShortcutRouterActivity paramShortcutRouterActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexl
 * JD-Core Version:    0.7.0.1
 */