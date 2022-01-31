import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;

public class adhx
  implements DialogInterface.OnClickListener
{
  public adhx(PresenceInterfaceImpl paramPresenceInterfaceImpl, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicPresenceInterfaceImpl.a.post(new adhy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adhx
 * JD-Core Version:    0.7.0.1
 */