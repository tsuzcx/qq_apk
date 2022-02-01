import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class acve
  implements DialogInterface.OnClickListener
{
  acve(acxa paramacxa, acxb paramacxb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Acxa != null) {
      this.jdField_a_of_type_Acxa.onCancel();
    }
    mrd.e(true, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mrd.b(this.jdField_a_of_type_Acxb.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acve
 * JD-Core Version:    0.7.0.1
 */