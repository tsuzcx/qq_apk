import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;
import com.tencent.qphone.base.util.QLog;

public class adsa
  implements DialogInterface.OnClickListener
{
  public adsa(PresenceInterfaceImpl paramPresenceInterfaceImpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    PresenceInterfaceImpl.a(this.a);
    QLog.d("PresenceInterfaceImpl", 2, "User allowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsa
 * JD-Core Version:    0.7.0.1
 */