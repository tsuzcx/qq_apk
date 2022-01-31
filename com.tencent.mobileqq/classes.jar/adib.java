import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;
import com.tencent.qphone.base.util.QLog;

public class adib
  implements DialogInterface.OnClickListener
{
  public adib(PresenceInterfaceImpl paramPresenceInterfaceImpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    PresenceInterfaceImpl.a(this.a);
    QLog.d("PresenceInterfaceImpl", 2, "User allowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adib
 * JD-Core Version:    0.7.0.1
 */