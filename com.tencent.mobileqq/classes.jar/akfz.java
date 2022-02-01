import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class akfz
  implements DialogInterface.OnClickListener
{
  public akfz(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.a()) {
      ((VasExtensionHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_Bhll.a, -1);
    }
    VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentAccountUin(), "faceAddon", "0X80088EE", "", 1, 0, 0, null, "", "");
    bdla.b(this.a.app, "CliOper", "", "", "0X8005FDB", "0X8005FDB", 0, 0, String.valueOf(this.a.jdField_a_of_type_Long), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akfz
 * JD-Core Version:    0.7.0.1
 */