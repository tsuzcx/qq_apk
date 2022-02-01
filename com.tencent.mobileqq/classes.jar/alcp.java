import Wallet.PopDialog;
import Wallet.SkinInfo;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;

class alcp
  implements DialogInterface.OnClickListener
{
  alcp(alcn paramalcn, alch paramalch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_Alch.a.pop_dialog.right_url;
    if (!TextUtils.isEmpty(paramDialogInterface)) {
      bmrq.a(alck.a(this.jdField_a_of_type_Alcn.a), paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcp
 * JD-Core Version:    0.7.0.1
 */