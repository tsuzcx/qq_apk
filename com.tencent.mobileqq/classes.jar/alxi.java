import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QlinkBridgeActivity;

public class alxi
  implements DialogInterface.OnClickListener
{
  public alxi(QlinkBridgeActivity paramQlinkBridgeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxi
 * JD-Core Version:    0.7.0.1
 */