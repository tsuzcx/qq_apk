import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.ArkAppCenter;

class alvb
  implements DialogInterface.OnDismissListener
{
  alvb(alva paramalva, bfpc parambfpc) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bfpc.dismiss();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("ClearData actionsheet is closed", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alvb
 * JD-Core Version:    0.7.0.1
 */