import Wallet.PopDialog;
import Wallet.SkinInfo;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;

class akwb
  implements DialogInterface.OnClickListener
{
  akwb(akvz paramakvz, akvt paramakvt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_Akvt.a.pop_dialog.right_url;
    if (!TextUtils.isEmpty(paramDialogInterface)) {
      bmhg.a(akvw.a(this.jdField_a_of_type_Akvz.a), paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwb
 * JD-Core Version:    0.7.0.1
 */