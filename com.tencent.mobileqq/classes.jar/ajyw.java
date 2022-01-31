import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;

class ajyw
  implements DialogInterface.OnClickListener
{
  ajyw(ajyv paramajyv, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("back_for_hidden_chat", true);
    paramDialogInterface.setFlags(603979776);
    HiddenChatFragment.a(this.jdField_a_of_type_AndroidAppActivity, 3, 0, paramDialogInterface);
    awqx.b(this.jdField_a_of_type_Ajyv.a, "dc00898", "", "", "0X800A34A", "0X800A34A", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajyw
 * JD-Core Version:    0.7.0.1
 */