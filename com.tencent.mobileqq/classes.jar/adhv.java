import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;

public class adhv
  implements DialogInterface.OnClickListener
{
  public adhv(PresenceInterfaceImpl paramPresenceInterfaceImpl, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicPresenceInterfaceImpl.a.post(new adhw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adhv
 * JD-Core Version:    0.7.0.1
 */