import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class aikh
  implements DialogInterface.OnClickListener
{
  public aikh(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.a()) {
      ((bdug)this.a.app.a(71)).a(this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_Bdrg.a, -1);
    }
    VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentAccountUin(), "faceAddon", "0X80088EE", "", 1, 0, 0, null, "", "");
    azqs.b(this.a.app, "CliOper", "", "", "0X8005FDB", "0X8005FDB", 0, 0, String.valueOf(this.a.jdField_a_of_type_Long), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikh
 * JD-Core Version:    0.7.0.1
 */