import Wallet.PopDialog;
import Wallet.SkinInfo;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;

class akrd
  implements DialogInterface.OnClickListener
{
  akrd(akrc paramakrc, akqw paramakqw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_Akqw.a.pop_dialog.left_url;
    if (!TextUtils.isEmpty(paramDialogInterface)) {
      blqo.a(akqz.a(this.jdField_a_of_type_Akrc.a), paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrd
 * JD-Core Version:    0.7.0.1
 */