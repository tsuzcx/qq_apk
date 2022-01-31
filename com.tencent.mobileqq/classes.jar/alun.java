import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.dingdong.DingdongPluginBridgeActivity;

public class alun
  implements DialogInterface.OnDismissListener
{
  public alun(DingdongPluginBridgeActivity paramDingdongPluginBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alun
 * JD-Core Version:    0.7.0.1
 */