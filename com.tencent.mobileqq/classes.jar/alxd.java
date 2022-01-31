import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QQProxyForQlink;

public class alxd
  implements DialogInterface.OnDismissListener
{
  public alxd(QQProxyForQlink paramQQProxyForQlink) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QQProxyForQlink.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alxd
 * JD-Core Version:    0.7.0.1
 */