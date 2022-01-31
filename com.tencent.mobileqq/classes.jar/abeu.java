import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class abeu
  implements DialogInterface.OnClickListener
{
  public abeu(NotificationActivity paramNotificationActivity, signature.SignatureKickData paramSignatureKickData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("NotificationActivity", 1, "setPositiveButton.onClick: invoked.  isDialogShow: " + NotificationActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity));
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("password", null);
    this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, LoginActivity.class).putExtras(paramDialogInterface).addFlags(67108864));
    try
    {
      paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_ComTencentImsSignature$SignatureKickData.str_url.get()));
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.startActivity(paramDialogInterface);
      label106:
      paramDialogInterface = new Intent("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.sendBroadcast(paramDialogInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abeu
 * JD-Core Version:    0.7.0.1
 */