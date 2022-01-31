import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class aghn
  implements DialogInterface.OnClickListener
{
  public aghn(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.a()) {
      ((bbrd)this.a.app.a(71)).a(this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_Bbod.a, -1);
    }
    VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentAccountUin(), "faceAddon", "0X80088EE", "", 1, 0, 0, null, "", "");
    axqy.b(this.a.app, "CliOper", "", "", "0X8005FDB", "0X8005FDB", 0, 0, String.valueOf(this.a.jdField_a_of_type_Long), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghn
 * JD-Core Version:    0.7.0.1
 */