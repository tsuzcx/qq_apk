import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class adlq
  implements DialogInterface.OnClickListener
{
  adlq(adnm paramadnm, adnn paramadnn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Adnm != null) {
      this.jdField_a_of_type_Adnm.onCancel();
    }
    msa.e(true, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    msa.b(this.jdField_a_of_type_Adnn.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlq
 * JD-Core Version:    0.7.0.1
 */